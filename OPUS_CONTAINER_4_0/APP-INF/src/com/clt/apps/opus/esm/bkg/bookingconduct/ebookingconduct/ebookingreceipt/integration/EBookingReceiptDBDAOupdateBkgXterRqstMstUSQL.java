/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.21 정인선
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

public class EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL(){
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST MST SET " ).append("\n"); 
		query.append("     --  MST.ESTM_WGT = (SELECT SUM(BXC.CNTR_WGT) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("     --, MST.ESTM_WGT_UT_CD = (SELECT DECODE(BXC.WGT_UT_CD,'KG','KGS',BXC.WGT_UT_CD) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("     --, MST.PCK_QTY = (SELECT SUM(BXC.PCK_QTY) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("     --, MST.PCK_TP_CD = (SELECT BXC.PCK_TP_CD FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("     --, MST.MEAS_QTY = (SELECT SUM(BXC.MEAS_QTY) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("     --, MST.MEAS_UT_CD = (SELECT BXC.MEAS_UT_CD FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("      MST.XTER_BKG_RQST_STS_CD = CASE WHEN MST.XTER_BKG_RQST_STS_CD = 'C' THEN 'X'" ).append("\n"); 
		query.append("                                       WHEN MST.XTER_RQST_SEQ = 1 THEN 'C'" ).append("\n"); 
		query.append("                                       WHEN MST.XTER_RQST_SEQ > 1 THEN 'U'" ).append("\n"); 
		query.append("                                       ELSE MST.XTER_BKG_RQST_STS_CD END" ).append("\n"); 
		query.append("     , MST.DCGO_FLG = CASE WHEN (SELECT COUNT(1) FROM BKG_XTER_DG_CGO DG WHERE DG.XTER_SNDR_ID = MST.XTER_SNDR_ID AND DG.XTER_RQST_NO = MST.XTER_RQST_NO AND DG.XTER_RQST_SEQ = MST.XTER_RQST_SEQ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                           ELSE 'N' END" ).append("\n"); 
		query.append("     , MST.RC_FLG = CASE WHEN (SELECT COUNT(1) FROM BKG_XTER_RF_CGO RF WHERE RF.XTER_SNDR_ID = MST.XTER_SNDR_ID AND RF.XTER_RQST_NO = MST.XTER_RQST_NO AND RF.XTER_RQST_SEQ = MST.XTER_RQST_SEQ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                           ELSE 'N' END" ).append("\n"); 
		query.append("     , MST.AWK_CGO_FLG = CASE WHEN (SELECT COUNT(1) FROM BKG_XTER_AWK_CGO AWK WHERE AWK.XTER_SNDR_ID = MST.XTER_SNDR_ID AND AWK.XTER_RQST_NO = MST.XTER_RQST_NO AND AWK.XTER_RQST_SEQ = MST.XTER_RQST_SEQ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                           ELSE 'N' END" ).append("\n"); 
		query.append("	 ,MST.RCV_TERM_CD = DECODE((SELECT MIN(BXC.OB_HLG_TP_CD) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ),'C','D','Y')" ).append("\n"); 
		query.append("     ,MST.DE_TERM_CD = DECODE((SELECT MIN(BXC.IB_HLG_TP_CD) FROM BKG_XTER_CNTR BXC WHERE BXC.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXC.XTER_RQST_NO = MST.XTER_RQST_NO AND BXC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ),'C','D','Y')" ).append("\n"); 
		query.append("     ,MST.CTRT_NO = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD IN ('03','18') AND ROWNUM = 1)" ).append("\n"); 
		query.append("	 ,MST.SHPR_REF_NO = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD = '13' AND ROWNUM = 1)" ).append("\n"); 
		query.append("     ,MST.FWRD_REF_NO  = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD = '23' AND ROWNUM = 1)" ).append("\n"); 
		query.append("     ,MST.CUST_REF_NO = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD = '15' AND ROWNUM = 1)" ).append("\n"); 
		query.append("     ,MST.PO_NO = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD = '17' AND ROWNUM = 1)" ).append("\n"); 
		query.append("     ,MST.INV_NO_CTNT = (SELECT BXR.REF_NO FROM  BKG_XTER_REF BXR WHERE BXR.XTER_SNDR_ID = MST.XTER_SNDR_ID AND BXR.XTER_RQST_NO = MST.XTER_RQST_NO AND BXR.XTER_RQST_SEQ = MST.XTER_RQST_SEQ AND BXR.REF_CD = '26' AND ROWNUM = 1)" ).append("\n"); 
		query.append("	 ,MST.AUTO_EML_FLG = DECODE(MST.XTER_RQST_VIA_CD,'WEB','Y','N')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	 ,MST.SLS_OFC_CD = MST.BKG_OFC_CD" ).append("\n"); 
		query.append("	 ,MST.HNDL_OFC_CD = (SELECT OFC FROM " ).append("\n"); 
		query.append("        (SELECT OFC" ).append("\n"); 
		query.append("         FROM  (SELECT DISTINCT 1.1 RANK, hndl_ofc_cd OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("     		   and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("               AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2 RANK, MO.OFC_CD " ).append("\n"); 
		query.append("               FROM MDM_ORGANIZATION MO, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MO.MODI_OFC_CD = DECODE(BKG_OFC_CD,'VIE','VNA','BSL','BAS',BKG_OFC_CD)" ).append("\n"); 
		query.append("               AND SUBSTR(MO.OFC_CD,4,2) NOT IN ('HO','HQ')" ).append("\n"); 
		query.append("               AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.2 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POL_CD = HNDL.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.4 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POR_CD = HNDL.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.2 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.4 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.6 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 5 RANK, 'SINHQ' OFC" ).append("\n"); 
		query.append("               FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("     		   WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ORDER BY rank" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       WHERE rownum = 1)" ).append("\n"); 
		query.append("       ,MST.BKG_OFC_CD = (SELECT OFC FROM " ).append("\n"); 
		query.append("        (SELECT OFC" ).append("\n"); 
		query.append("         FROM  (SELECT DISTINCT 1.1 RANK, hndl_ofc_cd OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("     		   and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("               AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2 RANK, MO.OFC_CD " ).append("\n"); 
		query.append("               FROM MDM_ORGANIZATION MO, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MO.MODI_OFC_CD = DECODE(BKG_OFC_CD,'VIE','VNA','BSL','BAS',BKG_OFC_CD)" ).append("\n"); 
		query.append("               AND SUBSTR(MO.OFC_CD,4,2) NOT IN ('HO','HQ')" ).append("\n"); 
		query.append("               AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.2 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POL_CD = HNDL.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.4 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POR_CD = HNDL.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.2 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.4 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.6 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 5 RANK, 'SINHQ' OFC" ).append("\n"); 
		query.append("               FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("     		   WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ORDER BY rank" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       WHERE rownum = 1) " ).append("\n"); 
		query.append("     , RQST_DT = NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,NVL(POR_CD, POL_CD))" ).append("\n"); 
		query.append("				, NVL (GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL'" ).append("\n"); 
		query.append("                                                   , SYSDATE" ).append("\n"); 
		query.append("                                                   , (SELECT LOC_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                                       WHERE OFC_CD = (SELECT OFC FROM " ).append("\n"); 
		query.append("        (SELECT OFC" ).append("\n"); 
		query.append("         FROM  (SELECT DISTINCT 1.1 RANK, hndl_ofc_cd OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("               and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("     		   and mst.xter_rqst_seq< @[rqst_seq]" ).append("\n"); 
		query.append("               AND NVL(MST.BKG_UPLD_STS_CD,'N') <> 'D'" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2 RANK, MO.OFC_CD " ).append("\n"); 
		query.append("               FROM MDM_ORGANIZATION MO, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("               WHERE MO.MODI_OFC_CD = DECODE(BKG_OFC_CD,'VIE','VNA','BSL','BAS',BKG_OFC_CD)" ).append("\n"); 
		query.append("               AND SUBSTR(MO.OFC_CD,4,2) NOT IN ('HO','HQ')" ).append("\n"); 
		query.append("               AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.2 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POL_CD = HNDL.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 2.4 RANK, HNDL.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.POR_CD = HNDL.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.VT_CUST_OFC_CD IS NULL" ).append("\n"); 
		query.append("               AND MST.CUST_ID IS NOT NULL" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM BKG_HNDL_OFC_STUP HBOS1" ).append("\n"); 
		query.append("                                      WHERE MST.CUST_ID = HBOS1.VT_CUST_OFC_CD)" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.2 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD = MST.POL_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.4 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD = MST.POR_CD" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 3.6 RANK, HNDL.HNDL_OFC_CD" ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                    ,BKG_HNDL_OFC_STUP HNDL" ).append("\n"); 
		query.append("               WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("               AND MST.CUST_ID = HNDL.VT_CUST_OFC_CD" ).append("\n"); 
		query.append("               AND HNDL.POR_CD IS NULL" ).append("\n"); 
		query.append("               AND HNDL.POL_CD IS NULL" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("               SELECT 5 RANK, 'SINHQ' OFC" ).append("\n"); 
		query.append("               FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("     		   WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("			   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           	   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("               AND MST.XTER_RQST_VIA_CD = 'EDI'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ORDER BY rank" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       WHERE rownum = 1" ).append("\n"); 
		query.append("       AND OFC IS NOT NULL)))" ).append("\n"); 
		query.append("                  , SYSDATE)) " ).append("\n"); 
		query.append("     ,MST.BKG_UPLD_STS_CD = 'N'   " ).append("\n"); 
		query.append("	 ,MST.VSL_CD = (SELECT MVC.VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_ENG_NM = MST.VSL_NM AND 1=(SELECT COUNT(*) FROM MDM_VSL_CNTR MVC1 WHERE MVC1.VSL_ENG_NM = MST.VSL_NM) AND ROWNUM=1)" ).append("\n"); 
		query.append("     ,MST.SKD_VOY_NO = NVL(DECODE(LENGTH(MST.SKD_VOY_NO),3,'0'||MST.SKD_VOY_NO,MST.SKD_VOY_NO)" ).append("\n"); 
		query.append("                     ,(SELECT SKD.SKD_VOY_NO FROM VSK_VSL_PORT_SKD SKD WHERE SKD.OB_CSSM_VOY_NO = MST.CSSM_VOY_NO" ).append("\n"); 
		query.append("                       AND SKD.VSL_CD = (SELECT MVC.VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_ENG_NM = MST.VSL_NM AND 1=(SELECT COUNT(*) FROM MDM_VSL_CNTR MVC1 WHERE MVC1.VSL_ENG_NM = MST.VSL_NM) AND ROWNUM=1)" ).append("\n"); 
		query.append("                       AND SKD.VPS_PORT_CD = MST.POL_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                     ))" ).append("\n"); 
		query.append("     ,MST.SKD_DIR_CD = NVL(MST.SKD_DIR_CD" ).append("\n"); 
		query.append("                     ,(SELECT SKD.SKD_DIR_CD FROM VSK_VSL_PORT_SKD SKD WHERE SKD.OB_CSSM_VOY_NO = MST.CSSM_VOY_NO" ).append("\n"); 
		query.append("                       AND SKD.VSL_CD = (SELECT MVC.VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_ENG_NM = MST.VSL_NM AND 1=(SELECT COUNT(*) FROM MDM_VSL_CNTR MVC1 WHERE MVC1.VSL_ENG_NM = MST.VSL_NM) AND ROWNUM=1)" ).append("\n"); 
		query.append("                       AND SKD.VPS_PORT_CD = MST.POL_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                     ))" ).append("\n"); 
		query.append("	,MST.XTER_BKG_RMK1 = CASE WHEN MST.PGSS_EDI_ID = 'IK' AND LENGTHB(MST.XTER_BKG_RMK1) + LENGTHB(BKG_JOIN_FNC(CURSOR(SELECT REF.REF_CD_DESC||': '||REF.REF_NO" ).append("\n"); 
		query.append("                                 FROM BKG_XTER_REF REF " ).append("\n"); 
		query.append("                                 WHERE REF.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                 AND   REF.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                 AND   REF.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                 AND   REF.REF_CD = '64'" ).append("\n"); 
		query.append("                                 ),', ')) < 4000" ).append("\n"); 
		query.append("       						THEN" ).append("\n"); 
		query.append("            				MST.XTER_BKG_RMK1 ||BKG_JOIN_FNC(CURSOR(SELECT REF.REF_CD_DESC||': '||REF.REF_NO" ).append("\n"); 
		query.append("                                 FROM BKG_XTER_REF REF " ).append("\n"); 
		query.append("                                 WHERE REF.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                 AND   REF.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                                 AND   REF.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                 AND   REF.REF_CD = '64'" ).append("\n"); 
		query.append("                                 ),', ')" ).append("\n"); 
		query.append("       						ELSE MST.XTER_BKG_RMK1 END" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}