/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgListFor301310EdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgListFor301310EdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListFor301310Edi
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgListFor301310EdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_stf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgListFor301310EdiRSQL").append("\n"); 
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
		query.append("SELECT /*+ opt_param('_optimizer_skip_scan_enabled', 'false') */ " ).append("\n"); 
		query.append("          BKG_NO" ).append("\n"); 
		query.append("        , STATUS" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , CUST_TP_CD" ).append("\n"); 
		query.append("        , CUST_CD" ).append("\n"); 
		query.append("        , REPLACE(CUST_NM, CHR(10), ' ') CUST_NM" ).append("\n"); 
		query.append("        , SC_NO" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("		, (SELECT /*+ INDEX(CUST XAK1BKG_CUSTOMER) */" ).append("\n"); 
		query.append("                  DECODE(CUST_SEQ, '0', '', CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ, '000000')))" ).append("\n"); 
		query.append("			 FROM BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("            WHERE CUST.BKG_NO = MST.BKG_NO " ).append("\n"); 
		query.append("              AND BKG_CUST_TP_CD = 'E') EDI_REF" ).append("\n"); 
		query.append("        , RECEIVER_NAME" ).append("\n"); 
		query.append("		, VVD" ).append("\n"); 
		query.append("        , POR_CD" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , DEL_CD" ).append("\n"); 
		query.append("        , SENT_DT" ).append("\n"); 
		query.append("        , SND_USR_ID" ).append("\n"); 
		query.append("        , (SELECT usr_nm FROM com_user WHERE usr_id = SND_USR_ID AND ROWNUM = 1) SND_USR_NM" ).append("\n"); 
		query.append("        , SENT_STATUS" ).append("\n"); 
		query.append("        , ACK" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("        , GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("        , CUST_CD REF_CODE" ).append("\n"); 
		query.append("  FROM (SELECT  /*+ INDEX(CUST XAK1BKG_CUSTOMER) */" ).append("\n"); 
		query.append("				MST.BKG_NO" ).append("\n"); 
		query.append("                , BK.BKG_STS_CD STATUS" ).append("\n"); 
		query.append("                , BK.BL_NO||BK.BL_TP_CD BL_NO" ).append("\n"); 
		query.append("                , SUBSTR(RANK, 2, 2) CUST_TP_CD" ).append("\n"); 
		query.append("                , CUST.CUST_CNT_CD||TRIM(TO_CHAR(CUST.CUST_SEQ, '000009')) CUST_CD" ).append("\n"); 
		query.append("                , CUST.CUST_NM" ).append("\n"); 
		query.append("                , BK.SC_NO" ).append("\n"); 
		query.append("                , MST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                , MST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , MST.RECEIVER_NAME" ).append("\n"); 
		query.append("				, MST.VVD" ).append("\n"); 
		query.append("                , BK.POR_CD" ).append("\n"); 
		query.append("                , BK.POL_CD" ).append("\n"); 
		query.append("                , BK.POD_CD" ).append("\n"); 
		query.append("                , BK.DEL_CD" ).append("\n"); 
		query.append("                , TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD') SENT_DT" ).append("\n"); 
		query.append("                , NTC.SND_USR_ID" ).append("\n"); 
		query.append("                , DECODE(NTC.BKG_NTC_SND_RSLT_CD, 'A', 'Success', 'E', 'Fail', null) SENT_STATUS" ).append("\n"); 
		query.append("                , null ACK" ).append("\n"); 
		query.append("		        , NTC.HIS_SEQ" ).append("\n"); 
		query.append("				, NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("				, NTC.NTC_KND_CD" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER CUST, BKG_BOOKING BK, BKG_NTC_HIS NTC, " ).append("\n"); 
		query.append("                (SELECT BKG_NO" ).append("\n"); 
		query.append("                        , MIN(RANK) RANK" ).append("\n"); 
		query.append("                        , GROUP_EDI_ID" ).append("\n"); 
		query.append("                        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                        , RECEIVER_NAME" ).append("\n"); 
		query.append("						, VVD" ).append("\n"); 
		query.append("                   FROM " ).append("\n"); 
		query.append("                        (SELECT /*+ INDEX(CUST XAK1BKG_CUSTOMER) */" ).append("\n"); 
		query.append("                                 BK.BKG_NO" ).append("\n"); 
		query.append("                                , MIN(TP_RANK.RANK) RANK" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.RECEIVER_NAME" ).append("\n"); 
		query.append("								, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                                , BKG_BOOKING BK" ).append("\n"); 
		query.append("                                , BKG_VVD VVD" ).append("\n"); 
		query.append("								, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("                                , (SELECT  GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                                         , GRP.ESVC_GRP_NM          RECEIVER_NAME" ).append("\n"); 
		query.append("                                         , grp_CUST.CNT_CD   " ).append("\n"); 
		query.append("                                         , grp_CUST.CUST_SEQ " ).append("\n"); 
		query.append("                                   FROM BKG_EDI_GRP_CUST GRP_CUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                                    AND GRP.CO_CD               = GRP_CUST.CO_CD" ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                    AND GRP_CUST.CNT_CD         > ' '" ).append("\n"); 
		query.append("                                    AND GRP_CUST.CUST_SEQ       > 0" ).append("\n"); 
		query.append("                                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'B')-- booking receipt" ).append("\n"); 
		query.append("                                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                                    AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'D')--draft b/l" ).append("\n"); 
		query.append("                                    AND GRP_CUST.BL_DRFT_FLG    = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${edi_group_id} != '' && ${edi_receive_nm} != '')" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'G')--Group ID" ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_CD  like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'R')--Receive ID" ).append("\n"); 
		query.append("                                    AND GRP.CUST_TRD_PRNR_ID like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'N')--receive name" ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_NM  like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                    ) EDI_BY_CUST               " ).append("\n"); 
		query.append("                                , (" ).append("\n"); 
		query.append("                                   SELECT ATTR_CTNT1 AS RCV_TP" ).append("\n"); 
		query.append("                                        , HRD_CDG_ID_SEQ||ATTR_CTNT2 AS RANK" ).append("\n"); 
		query.append("                                     FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                    WHERE 'CUSTOMER_TYPE_ORDER' = HRD_CDG_ID" ).append("\n"); 
		query.append("                                   ) TP_RANK" ).append("\n"); 
		query.append("                         WHERE EDI_BY_CUST.CNT_CD   = CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("                           AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = CUST.BKG_NO" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("                           AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("                           AND VVD.VSL_PRE_PST_CD IN ('T', 'S')" ).append("\n"); 
		query.append("                           AND CUST.BKG_CUST_TP_CD = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("                           AND BK.BKG_STS_CD    IN ('F', 'W', 'S')" ).append("\n"); 
		query.append("                           AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        ---------------------------조건절 시작   " ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${multiBkgNo} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("       #foreach($multiBkgNoVal IN ${multiBkgNo})        " ).append("\n"); 
		query.append("          #if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ---------------------------bkg or b/l no입력시 다른 조건 제외함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT > TO_DATE(REPLACE(@[bkg_from_dt],'-',''),'RRRRMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''),'RRRRMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_stf_cd} != '')" ).append("\n"); 
		query.append("                           AND UPPER(BK.DOC_USR_ID) = UPPER(@[bkg_stf_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sales_rep} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SREP_CD = @[sales_rep]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND ISS.OBL_ISS_OFC_CD = @[bl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd} != 'All' && ${cust_tp_cd} != '')" ).append("\n"); 
		query.append("                           AND CUST.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_NM LIKE UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY BK.BKG_NO" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.GROUP_EDI_ID" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                                , EDI_BY_CUST.RECEIVER_NAME" ).append("\n"); 
		query.append("								, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                         UNION" ).append("\n"); 
		query.append("                          SELECT /*+ INDEX(CUST XAK1BKG_CUSTOMER) */" ).append("\n"); 
		query.append("                                  BK.BKG_NO" ).append("\n"); 
		query.append("                                , (SELECT HRD_CDG_ID_SEQ||ATTR_CTNT2" ).append("\n"); 
		query.append("                                     FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                    WHERE 'CUSTOMER_TYPE_ORDER' = HRD_CDG_ID" ).append("\n"); 
		query.append("                                      AND 7 = HRD_CDG_ID_SEQ) AS RANK" ).append("\n"); 
		query.append("                                , EDI_BY_SC.GROUP_EDI_Id" ).append("\n"); 
		query.append("                                , EDI_BY_SC.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                                , EDI_BY_SC.RECEIVER_NAME" ).append("\n"); 
		query.append("								, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                                , BKG_BOOKING BK" ).append("\n"); 
		query.append("                                , BKG_VVD VVD" ).append("\n"); 
		query.append("								, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("                                , (SELECT  GRP.ESVC_GRP_CD          GROUP_EDI_ID" ).append("\n"); 
		query.append("                                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                                         , GRP.ESVC_GRP_NM          RECEIVER_NAME" ).append("\n"); 
		query.append("                                         , GRP_CUST.SC_NO" ).append("\n"); 
		query.append("                                   FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST GRP_CUST" ).append("\n"); 
		query.append("                                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                                    AND GRP.CO_CD               = GRP_CUST.CO_CD      " ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                    AND GRP_CUST.SC_NO          > ' '              " ).append("\n"); 
		query.append("                                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'B')-- booking receipt" ).append("\n"); 
		query.append("                                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                                    AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'D')--draft b/l" ).append("\n"); 
		query.append("                                    AND GRP_CUST.BL_DRFT_FLG    = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_group_id} != '' && ${edi_receive_nm} != '')" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'G')--Group ID" ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_CD  like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'R')--Receive ID" ).append("\n"); 
		query.append("                                    AND GRP.CUST_TRD_PRNR_ID like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'N')--receive name" ).append("\n"); 
		query.append("                                    AND GRP.ESVC_GRP_NM  like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                    ) EDI_BY_SC" ).append("\n"); 
		query.append("                         WHERE EDI_BY_SC.SC_NO  = BK.SC_NO" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = CUST.BKG_NO" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("                           AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("                           AND VVD.VSL_PRE_PST_CD IN ('T', 'S')" ).append("\n"); 
		query.append("                           AND BK.BKG_STS_CD    IN ('F', 'A')" ).append("\n"); 
		query.append("                           AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                        ---------------------------조건절 시작   " ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${multiBkgNo} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("       #foreach($multiBkgNoVal IN ${multiBkgNo})        " ).append("\n"); 
		query.append("          #if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ---------------------------bkg or b/l no입력시 다른 조건 제외함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT > TO_DATE(@[bkg_from_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT < TO_DATE(@[bkg_to_dt],   'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_stf_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.DOC_USR_ID = @[bkg_stf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sales_rep} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SREP_CD = @[sales_rep]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND ISS.OBL_ISS_OFC_CD = @[bl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd} != 'All' && ${cust_tp_cd} != '')" ).append("\n"); 
		query.append("                           AND CUST.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("                           AND CUST.CUST_NM LIKE UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("                           AND BK.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                   GROUP BY BKG_NO" ).append("\n"); 
		query.append("                        , GROUP_EDI_ID" ).append("\n"); 
		query.append("                        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                        , RECEIVER_NAME" ).append("\n"); 
		query.append("						, VVD) MST                " ).append("\n"); 
		query.append("          WHERE MST.BKG_NO             = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("            AND SUBSTR(MST.RANK, 2, 1) = CUST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("            AND MST.BKG_NO             = BK.BKG_NO" ).append("\n"); 
		query.append("            AND MST.BKG_NO             = NTC.BKG_NO    (+)" ).append("\n"); 
		query.append("            AND 'E'                    = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'B')-- booking receipt" ).append("\n"); 
		query.append("            AND 'BK'                   = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'D')--draft b/l" ).append("\n"); 
		query.append("            AND 'BL'                   = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND MST.EDI_RECEIVE_ID 	   = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("			AND MST.GROUP_EDI_ID   	   = NTC.ESVC_GRP_CD(+)" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("        ) MST" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND ((HIS_SEQ IS NOT NULL AND HIS_SEQ = (SELECT MAX(HIS.HIS_SEQ) " ).append("\n"); 
		query.append("                                              FROM BKG_NTC_HIS HIS" ).append("\n"); 
		query.append("                                             WHERE HIS.BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("                                               AND HIS.NTC_VIA_CD = MST.NTC_VIA_CD" ).append("\n"); 
		query.append("                                               AND HIS.NTC_KND_CD = MST.NTC_KND_CD" ).append("\n"); 
		query.append("											   AND HIS.EDI_ID     = MST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("											   AND HIS.ESVC_GRP_CD= MST.GROUP_EDI_ID))" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("      (HIS_SEQ IS NULL))                                   " ).append("\n"); 
		query.append("#if (${edi_sent_sts_cd} != 'All' && ${edi_sent_sts_cd} == 'Y')" ).append("\n"); 
		query.append(" --edi_sent_status = sent" ).append("\n"); 
		query.append(" AND SENT_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_sent_sts_cd} != 'All' && ${edi_sent_sts_cd} == 'N')" ).append("\n"); 
		query.append(" --edi_sent_status = unsent" ).append("\n"); 
		query.append(" AND SENT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${msg_type_cd} == 'B')-- booking receipt" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("       , STATUS" ).append("\n"); 
		query.append("       , BL_NO" ).append("\n"); 
		query.append("       , CUST_TP_CD" ).append("\n"); 
		query.append("       , CUST_CD" ).append("\n"); 
		query.append("       , '' CUST_NM" ).append("\n"); 
		query.append("       , SC_NO" ).append("\n"); 
		query.append("       , GROUP_EDI_ID" ).append("\n"); 
		query.append("		   , CUST_CD EDI_REF" ).append("\n"); 
		query.append("       , RECEIVER_NAME" ).append("\n"); 
		query.append("		   , VVD" ).append("\n"); 
		query.append("       , POR_CD" ).append("\n"); 
		query.append("       , POL_CD" ).append("\n"); 
		query.append("       , POD_CD" ).append("\n"); 
		query.append("       , DEL_CD" ).append("\n"); 
		query.append("       , SENT_DT" ).append("\n"); 
		query.append("       , SND_USR_ID" ).append("\n"); 
		query.append("       , (SELECT usr_nm FROM com_user WHERE usr_id = SND_USR_ID AND ROWNUM = 1) SND_USR_NM" ).append("\n"); 
		query.append("       , SENT_STATUS" ).append("\n"); 
		query.append("       , ACK" ).append("\n"); 
		query.append("       , EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("       , GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("       , CUST_CD REF_CODE" ).append("\n"); 
		query.append("FROM (        " ).append("\n"); 
		query.append("      SELECT MST.BKG_NO" ).append("\n"); 
		query.append("            ,MST.STATUS" ).append("\n"); 
		query.append("            ,MST.BL_NO" ).append("\n"); 
		query.append("            ,MST.CUST_TP_CD" ).append("\n"); 
		query.append("            ,MST.CUST_CD" ).append("\n"); 
		query.append("            ,'' CUST_NM" ).append("\n"); 
		query.append("            ,MST.SC_NO" ).append("\n"); 
		query.append("            ,MST.GROUP_EDI_ID" ).append("\n"); 
		query.append("            ,MST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("            ,'' RECEIVER_NAME" ).append("\n"); 
		query.append("            ,MST.VVD" ).append("\n"); 
		query.append("            ,MST.POR_CD" ).append("\n"); 
		query.append("            ,MST.POL_CD" ).append("\n"); 
		query.append("            ,MST.POD_CD" ).append("\n"); 
		query.append("            ,MST.DEL_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD') SENT_DT" ).append("\n"); 
		query.append("            ,NTC.SND_USR_ID" ).append("\n"); 
		query.append("            ,DECODE(NTC.BKG_NTC_SND_RSLT_CD, 'A', 'Success', 'E', 'Fail', null) SENT_STATUS" ).append("\n"); 
		query.append("            ,null ACK" ).append("\n"); 
		query.append("            ,NTC.HIS_SEQ" ).append("\n"); 
		query.append("            ,NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("            ,NTC.NTC_KND_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT BK.BKG_NO" ).append("\n"); 
		query.append("                   ,BK.BKG_STS_CD STATUS" ).append("\n"); 
		query.append("                   ,BK.BL_NO||BK.BL_TP_CD BL_NO" ).append("\n"); 
		query.append("                   ,'UN' CUST_TP_CD" ).append("\n"); 
		query.append("                   ,BHCC.ATTR_CTNT2 CUST_CD" ).append("\n"); 
		query.append("                   ,'' CUST_NM" ).append("\n"); 
		query.append("                   ,BK.SC_NO" ).append("\n"); 
		query.append("                   ,BHCC.ATTR_CTNT3 AS GROUP_EDI_ID" ).append("\n"); 
		query.append("                   ,BHCC.ATTR_CTNT1 AS EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                   ,BHCC.ATTR_CTNT2 AS REF_CODE" ).append("\n"); 
		query.append("                   ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                   ,BK.POR_CD" ).append("\n"); 
		query.append("                   ,BK.POL_CD" ).append("\n"); 
		query.append("                   ,BK.POD_CD" ).append("\n"); 
		query.append("                   ,BK.DEL_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                 ,BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                 ,BKG_VVD VVD" ).append("\n"); 
		query.append("            	 ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE 1=1     " ).append("\n"); 
		query.append("            AND BHCC.HRD_CDG_ID = 'CUSTOMER_301U'" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                        AND BC.CUST_CNT_CD||BC.CUST_SEQ = BHCC.ATTR_CTNT2)" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'X' FROM BKG_XTER_RQST_MST MST WHERE MST.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                                  AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                                  AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                                  AND BHCC.ATTR_CTNT1 = CASE WHEN MST.XTER_SNDR_ID <> 'PEGASUS' THEN MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                                                      ELSE (SELECT BHCC1.ATTR_CTNT2 " ).append("\n"); 
		query.append("                                                                                            FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                                                                            WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                                                                            AND BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID" ).append("\n"); 
		query.append("                                                                                            AND ROWNUM = 1) END" ).append("\n"); 
		query.append("                                                                  AND MST.XTER_RQST_VIA_CD <> 'WEB')" ).append("\n"); 
		query.append("            AND BK.BKG_NO        = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("            AND BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD IN ('T', 'S')" ).append("\n"); 
		query.append("            AND BK.BKG_STS_CD    IN ('F', 'W', 'S')" ).append("\n"); 
		query.append("            AND BK.BKG_CGO_TP_CD <> 'P'                                                      " ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${multiBkgNo} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("       #foreach($multiBkgNoVal IN ${multiBkgNo})        " ).append("\n"); 
		query.append("          #if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ---------------------------bkg or b/l no입력시 다른 조건 제외함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT > TO_DATE(REPLACE(@[bkg_from_dt],'-',''),'RRRRMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''),'RRRRMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_stf_cd} != '')" ).append("\n"); 
		query.append("                           AND UPPER(BK.DOC_USR_ID) = UPPER(@[bkg_stf_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sales_rep} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SREP_CD = @[sales_rep]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND ISS.OBL_ISS_OFC_CD = @[bl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                  " ).append("\n"); 
		query.append("            UNION ALL                                                      " ).append("\n"); 
		query.append("            SELECT MST.BKG_NO" ).append("\n"); 
		query.append("                   ,BK.BKG_STS_CD STATUS" ).append("\n"); 
		query.append("                   ,BK.BL_NO||BK.BL_TP_CD BL_NO" ).append("\n"); 
		query.append("                   ,'' CUST_TP_CD" ).append("\n"); 
		query.append("                   ,'' CUST_CD" ).append("\n"); 
		query.append("                   ,'' CUST_NM" ).append("\n"); 
		query.append("                   ,BK.SC_NO" ).append("\n"); 
		query.append("                   ,'' GROUP_EDI_ID" ).append("\n"); 
		query.append("                   ,(SELECT BHCC.ATTR_CTNT3" ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                     WHERE BHCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                     AND   BHCC.ATTR_CTNT2 = CASE WHEN MST.XTER_SNDR_ID <> 'PEGASUS' THEN MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                             ELSE (SELECT BHCC1.ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                                                           WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                                                           AND BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID) END" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) AS EDI_RECEIVE_ID " ).append("\n"); 
		query.append("                    ,'' REF_CODE" ).append("\n"); 
		query.append("                    ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                    ,BK.POR_CD" ).append("\n"); 
		query.append("                    ,BK.POL_CD" ).append("\n"); 
		query.append("                    ,BK.POD_CD" ).append("\n"); 
		query.append("                    ,BK.DEL_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                 ,BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                 ,BKG_VVD VVD" ).append("\n"); 
		query.append("            		 ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE MST.BKG_NO =  BK.BKG_NO" ).append("\n"); 
		query.append("            AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("            AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("            AND MST.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("            AND MST.XTER_RQST_SEQ = (SELECT MAX(MST1.XTER_RQST_SEQ) FROM BKG_XTER_RQST_MST MST1 " ).append("\n"); 
		query.append("                                                                    WHERE MST.XTER_SNDR_ID = MST1.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                                                    AND MST.BKG_NO = MST1.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND MST1.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                                    AND MST1.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                                    AND MST1.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("                                                                 )  " ).append("\n"); 
		query.append("            AND BK.BKG_NO        = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("            AND BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("            AND VVD.VSL_PRE_PST_CD IN ('T', 'S')" ).append("\n"); 
		query.append("            AND BK.BKG_STS_CD    IN ('F', 'W', 'S')" ).append("\n"); 
		query.append("            AND BK.BKG_CGO_TP_CD <> 'P'                                                        " ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${multiBkgNo} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("       #foreach($multiBkgNoVal IN ${multiBkgNo})        " ).append("\n"); 
		query.append("          #if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                           AND BK.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ---------------------------bkg or b/l no입력시 다른 조건 제외함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT > TO_DATE(REPLACE(@[bkg_from_dt],'-',''),'RRRRMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_CRE_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''),'RRRRMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_stf_cd} != '')" ).append("\n"); 
		query.append("                           AND UPPER(BK.DOC_USR_ID) = UPPER(@[bkg_stf_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sales_rep} != '')" ).append("\n"); 
		query.append("                           AND BK.OB_SREP_CD = @[sales_rep]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_ofc_cd} != '')" ).append("\n"); 
		query.append("                           AND ISS.OBL_ISS_OFC_CD = @[bl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            ) MST" ).append("\n"); 
		query.append("           ,BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("      WHERE  MST.BKG_NO             = NTC.BKG_NO    (+)" ).append("\n"); 
		query.append("      AND 'E'                    = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("      AND 'BK'                   = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("      AND MST.EDI_RECEIVE_ID 	   = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("      AND NVL(MST.GROUP_EDI_ID,'ZZZZZ') = NVL(NTC.ESVC_GRP_CD(+),'ZZZZZ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${edi_group_id} != '' && ${edi_receive_nm} != '')" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'G')--Group ID" ).append("\n"); 
		query.append("                                    AND MST.GROUP_EDI_ID  like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${edi_group_id} == 'R')--Receive ID" ).append("\n"); 
		query.append("                                    AND MST.EDI_RECEIVE_ID like @[edi_receive_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") MST" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("   AND ((HIS_SEQ IS NOT NULL AND HIS_SEQ = (SELECT MAX(HIS.HIS_SEQ) " ).append("\n"); 
		query.append("                                              FROM BKG_NTC_HIS HIS" ).append("\n"); 
		query.append("                                             WHERE HIS.BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("                                               AND HIS.NTC_VIA_CD = MST.NTC_VIA_CD" ).append("\n"); 
		query.append("                                               AND HIS.NTC_KND_CD = MST.NTC_KND_CD" ).append("\n"); 
		query.append("                      											   AND HIS.EDI_ID     = MST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                      											   AND NVL(HIS.ESVC_GRP_CD,'ZZZZZ')= NVL(MST.GROUP_EDI_ID,'ZZZZZ')))" ).append("\n"); 
		query.append("        OR (HIS_SEQ IS NULL))  " ).append("\n"); 
		query.append("#if (${edi_sent_sts_cd} != 'All' && ${edi_sent_sts_cd} == 'Y')" ).append("\n"); 
		query.append(" --edi_sent_status = sent" ).append("\n"); 
		query.append(" AND SENT_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_sent_sts_cd} != 'All' && ${edi_sent_sts_cd} == 'N')" ).append("\n"); 
		query.append(" --edi_sent_status = unsent" ).append("\n"); 
		query.append(" AND SENT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}