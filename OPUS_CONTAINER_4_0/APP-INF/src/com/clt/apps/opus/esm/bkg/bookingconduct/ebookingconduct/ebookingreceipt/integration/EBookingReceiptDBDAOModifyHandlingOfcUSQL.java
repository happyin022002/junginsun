/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyHandlingOfcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.09 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOModifyHandlingOfcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. S/I일 떄 기존 bkg이 있으면 해당 bkg의 bkg_ofc_cd 
	  * 2.. cust_cnt_cd, cust_seq가 mdm_customer에 mdm_customer에서 담당 office, 
	  * 3. porCd가 mdm_location에 있으면 location의 sales office, 
	  * 4. polCd가 mdm_location에 있으면 location의 sales office를 찾아서 기준 정보 table에서 mapping된 ofc_cd가 있으면 조회된 Office
	  * 5. Doc Type이 'B'인경우와 'S'인 경우에 컬럼을 나누어 저장함.
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyHandlingOfcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyHandlingOfcUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("update bkg_xter_rqst_mst" ).append("\n"); 
		query.append("   set hndl_ofc_cd =(select ofc" ).append("\n"); 
		query.append("                       from " ).append("\n"); 
		query.append("                        (select rank, case when rank = 1 then ofc.ofc" ).append("\n"); 
		query.append("                                           when rank = 1.1 then ofc.ofc" ).append("\n"); 
		query.append("                                           when rank <> 1 then nvl(ctrl.hndl_OFC_CD, ofc.ofc) end ofc" ).append("\n"); 
		query.append("                          from" ).append("\n"); 
		query.append("                            (SELECT 1 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("           					AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				            and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            and mst.doc_tp_cd = 'S'" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DISTINCT 1.1 RANK, hndl_ofc_cd ofc" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				            and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("                            AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("							UNION" ).append("\n"); 
		query.append("                            SELECT DISTINCT 1.2 RANK, hndl_ofc_cd ofc" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.XTER_SNDR_ID = 'PEGASUS'" ).append("\n"); 
		query.append("                            and mst.pgss_edi_id = (SELECT HCC.ATTR_CTNT1 " ).append("\n"); 
		query.append("                                                     FROM BKG_HRD_CDG_CTNT HCC " ).append("\n"); 
		query.append("                                                     WHERE HCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID' " ).append("\n"); 
		query.append("                                                     AND HCC.ATTR_CTNT2 = @[sender_id]" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1) " ).append("\n"); 
		query.append("        				            and mst.act_cust_ref_no = @[rqst_no]" ).append("\n"); 
		query.append("                   					and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("                            AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("                            and mst.doc_tp_cd = 'B'" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.25 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("           					        AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				                    and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					        and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            and mst.doc_tp_cd = 'B'" ).append("\n"); 
		query.append("                            AND MST.XTER_BKG_RQST_STS_CD = 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.3 RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("                            AND EXISTS (SELECT 'X' FROM BKG_XTER_CUST BXC " ).append("\n"); 
		query.append("                                                        ,BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                        WHERE BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				                    AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			            AND BXR.xter_rqst_seq= BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                                        AND BXC.PRNR_REF_NO = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.5 RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("                            AND EXISTS (SELECT 'X' FROM BKG_XTER_CUST BXC " ).append("\n"); 
		query.append("                                                        ,BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                        WHERE BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				                    AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			            AND BXR.xter_rqst_seq= BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                                        AND BXC.PRNR_REF_NO = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.2,3.2) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.3,3.3) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.4,3.4) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.5,3.5) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL" ).append("\n"); 
		query.append("                            union" ).append("\n"); 
		query.append("                            select 3.7 rank, nvl(por.SLS_OFC_CD, pol.sls_ofc_cd) ofc" ).append("\n"); 
		query.append("                              from bkg_xter_rqst_mst mst, mdm_location por, mdm_location pol" ).append("\n"); 
		query.append("           					 where MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                               and mst.doc_tp_cd    = 'S'" ).append("\n"); 
		query.append("                               and mst.por_cd       = por.loc_cd(+)" ).append("\n"); 
		query.append("                               and mst.pol_cd       = pol.loc_cd(+)	" ).append("\n"); 
		query.append("                               and nvl(por.SLS_OFC_CD, pol.sls_ofc_cd) is not null						" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 4 rank, 'SINHQ' ofc" ).append("\n"); 
		query.append("                              FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            ) ofc, BKG_ESVC_CTRL_OFC ctrl" ).append("\n"); 
		query.append("                         where ofc.ofc = ctrl.CTRL_OFC_CD(+)" ).append("\n"); 
		query.append("                        order by rank" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                     where rownum = 1)" ).append("\n"); 
		query.append("	 , BKG_UPLD_STS_CD = 'N'" ).append("\n"); 
		query.append("	 , RQST_GDT = GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), sysdate, 'GMT')" ).append("\n"); 
		query.append("	 , RQST_DT = NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,NVL(POR_CD, POL_CD))" ).append("\n"); 
		query.append("				, NVL (GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL'" ).append("\n"); 
		query.append("                                                   , SYSDATE" ).append("\n"); 
		query.append("                                                   , (SELECT LOC_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                                       WHERE OFC_CD = (select ofc" ).append("\n"); 
		query.append("                       from " ).append("\n"); 
		query.append("                        (select rank, case when rank = 1 then ofc.ofc" ).append("\n"); 
		query.append("                                           when rank = 1.1 then ofc.ofc" ).append("\n"); 
		query.append("                                           when rank <> 1 then nvl(ctrl.hndl_OFC_CD, ofc.ofc) end ofc" ).append("\n"); 
		query.append("                          from" ).append("\n"); 
		query.append("                            (SELECT 1 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                              FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                             WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("           					   AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                               and mst.doc_tp_cd = 'S'" ).append("\n"); 
		query.append("                            UNION " ).append("\n"); 
		query.append("                            SELECT DISTINCT 1.1 RANK, hndl_ofc_cd ofc" ).append("\n"); 
		query.append("                              FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                             WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("                               AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("							UNION" ).append("\n"); 
		query.append("                            SELECT DISTINCT 1.2 RANK, hndl_ofc_cd ofc" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.XTER_SNDR_ID = 'PEGASUS'" ).append("\n"); 
		query.append("                            and mst.pgss_edi_id = (SELECT HCC.ATTR_CTNT1 " ).append("\n"); 
		query.append("                                                     FROM BKG_HRD_CDG_CTNT HCC " ).append("\n"); 
		query.append("                                                     WHERE HCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID' " ).append("\n"); 
		query.append("                                                     AND HCC.ATTR_CTNT2 = @[sender_id]" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1) " ).append("\n"); 
		query.append("        				            and mst.act_cust_ref_no = @[rqst_no]" ).append("\n"); 
		query.append("                   					and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("                            AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("                            and mst.doc_tp_cd = 'B'" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.25 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                            WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("           					        AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				                    and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					        and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            and mst.doc_tp_cd = 'B'" ).append("\n"); 
		query.append("                            AND MST.XTER_BKG_RQST_STS_CD = 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.3 RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("                            AND EXISTS (SELECT 'X' FROM BKG_XTER_CUST BXC " ).append("\n"); 
		query.append("                                                        ,BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                        WHERE BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				                    AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			            AND BXR.xter_rqst_seq= BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                                        AND BXC.PRNR_REF_NO = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 1.5 RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("                            AND EXISTS (SELECT 'X' FROM BKG_XTER_CUST BXC " ).append("\n"); 
		query.append("                                                        ,BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                        WHERE BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				                    AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			            AND BXR.xter_rqst_seq= BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                                        AND BXC.PRNR_REF_NO = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.2,3.2) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.3,3.3) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POL_CD = BHO.POL_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.4,3.4) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BXR.POR_CD = BHO.POR_CD" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT DECODE(BXC.xter_cust_tp_cd,'HO',2.5,3.5) RANK, BHO.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST BXR" ).append("\n"); 
		query.append("                                 ,BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("                                 ,BKG_HNDL_OFC_STUP BHO" ).append("\n"); 
		query.append("                            WHERE BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            AND BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("      				        AND BXR.xter_rqst_no = BXC.xter_rqst_no" ).append("\n"); 
		query.append("                 			AND BXR.xter_rqst_seq = BXC.xter_rqst_seq" ).append("\n"); 
		query.append("                            AND BXC.xter_cust_tp_cd IN ('HO','S')" ).append("\n"); 
		query.append("                            AND BXC.PRNR_REF_NO = BHO.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("                            AND BHO.POR_CD IS NULL" ).append("\n"); 
		query.append("                            AND BHO.POL_CD IS NULL	" ).append("\n"); 
		query.append("                            union" ).append("\n"); 
		query.append("                            select 3.7 rank, nvl(por.SLS_OFC_CD, pol.sls_ofc_cd) ofc" ).append("\n"); 
		query.append("                              from bkg_xter_rqst_mst mst, mdm_location por, mdm_location pol" ).append("\n"); 
		query.append("           					 where MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                               and mst.doc_tp_cd    = 'S'" ).append("\n"); 
		query.append("                               and mst.por_cd       = por.loc_cd(+)" ).append("\n"); 
		query.append("                               and mst.pol_cd       = pol.loc_cd(+)		" ).append("\n"); 
		query.append("                               and nvl(por.SLS_OFC_CD, pol.sls_ofc_cd) is not null						" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 4 rank, 'SINHQ' ofc" ).append("\n"); 
		query.append("                              FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("                            ) ofc, BKG_ESVC_CTRL_OFC ctrl" ).append("\n"); 
		query.append("                         where ofc.ofc = ctrl.CTRL_OFC_CD(+)" ).append("\n"); 
		query.append("                        order by rank" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                     where rownum = 1" ).append("\n"); 
		query.append("                       AND OFC IS NOT NULL)))" ).append("\n"); 
		query.append("                  , SYSDATE))" ).append("\n"); 
		query.append("	, gds_desc  = @[gds_desc]" ).append("\n"); 
		query.append("	, mk_desc   = @[mk_desc]" ).append("\n"); 
		query.append("	, estm_wgt_ut_cd = decode( estm_wgt_ut_cd, null, 'KGS','K','KGS','L','LBS',estm_wgt_ut_cd)" ).append("\n"); 
		query.append("	, meas_ut_cd     = decode( meas_ut_cd,     null, 'CBM','X','CBM','E','CBF',meas_ut_cd)" ).append("\n"); 
		query.append("	, SI_CNTC_NM          = DECODE( DOC_TP_CD, 'S', CNTC_NM         , SI_CNTC_NM         )" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_INTL_NO = DECODE( DOC_TP_CD, 'S', CNTC_PHN_INTL_NO, SI_CNTC_PHN_INTL_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_AREA_NO = DECODE( DOC_TP_CD, 'S', CNTC_PHN_AREA_NO, SI_CNTC_PHN_AREA_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_NO      = DECODE( DOC_TP_CD, 'S', CNTC_PHN_NO     , SI_CNTC_PHN_NO     )" ).append("\n"); 
		query.append("	, SI_CNTC_XTN_PHN_NO  = DECODE( DOC_TP_CD, 'S', CNTC_XTN_PHN_NO , SI_CNTC_XTN_PHN_NO )" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_INTL_NO = DECODE( DOC_TP_CD, 'S', CNTC_FAX_INTL_NO, SI_CNTC_FAX_INTL_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_AREA_NO = DECODE( DOC_TP_CD, 'S', CNTC_FAX_AREA_NO, SI_CNTC_FAX_AREA_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_NO      = DECODE( DOC_TP_CD, 'S', CNTC_FAX_NO     , SI_CNTC_FAX_NO     )" ).append("\n"); 
		query.append("	, SI_CNTC_EML         = DECODE( DOC_TP_CD, 'S', CNTC_EML        , SI_CNTC_EML        )" ).append("\n"); 
		query.append("	, SI_CNTC_MPHN_NO     = DECODE( DOC_TP_CD, 'S', CNTC_MPHN_NO    , SI_CNTC_MPHN_NO    )" ).append("\n"); 
		query.append("	, CNTC_NM             = DECODE( DOC_TP_CD, 'S', ''              , CNTC_NM            )" ).append("\n"); 
		query.append("	, CNTC_PHN_INTL_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_INTL_NO   )" ).append("\n"); 
		query.append("	, CNTC_PHN_AREA_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_AREA_NO   )" ).append("\n"); 
		query.append("	, CNTC_PHN_NO         = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_NO        )" ).append("\n"); 
		query.append("	, CNTC_XTN_PHN_NO     = DECODE( DOC_TP_CD, 'S', ''              , CNTC_XTN_PHN_NO    )" ).append("\n"); 
		query.append("	, CNTC_FAX_INTL_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_INTL_NO   )" ).append("\n"); 
		query.append("	, CNTC_FAX_AREA_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_AREA_NO   )" ).append("\n"); 
		query.append("	, CNTC_FAX_NO         = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_NO        )" ).append("\n"); 
		query.append("	, CNTC_EML            = DECODE( DOC_TP_CD, 'S', ''              , CNTC_EML           )" ).append("\n"); 
		query.append("	, CNTC_MPHN_NO        = DECODE( DOC_TP_CD, 'S', ''              , CNTC_MPHN_NO       )	" ).append("\n"); 
		query.append(" where XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("   and XTER_SNDR_ID <> 'PEGASUS'" ).append("\n"); 

	}
}