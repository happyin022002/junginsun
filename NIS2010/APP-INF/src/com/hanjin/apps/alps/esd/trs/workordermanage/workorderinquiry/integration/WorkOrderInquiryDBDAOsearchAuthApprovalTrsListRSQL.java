/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchAuthApprovalTrsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2016.02.29 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchAuthApprovalTrsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Approval Confirm 화면에 대한 TRS 용 조회
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchAuthApprovalTrsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate_auth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchAuthApprovalTrsListRSQL").append("\n"); 
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
		query.append("/* TRS START */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       AUTH_APRO_RQST_NO, " ).append("\n"); 
		query.append("       DENSE_RANK() OVER(ORDER BY AUTH_APRO_RQST_NO) AS SEQ," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER(PARTITION BY AUTH_APRO_RQST_NO ORDER BY AUTH_APRO_RQST_NO, TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ) AUTH_APRO_RQST_NO_SEQ," ).append("\n"); 
		query.append("       SUB_SYS_CD," ).append("\n"); 
		query.append("       PGM_NO," ).append("\n"); 
		query.append("       PGM_NM," ).append("\n"); 
		query.append("       AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("       AUTH_APRO_TP_NM," ).append("\n"); 
		query.append("       RQST_ST_DT," ).append("\n"); 
		query.append("       RQST_USR_ID," ).append("\n"); 
		query.append("       RQST_USR_NM," ).append("\n"); 
		query.append("       RQST_OFC_CD," ).append("\n"); 
		query.append("       DTL_PGM_URL_CTNT," ).append("\n"); 
		query.append("       AUTH_APRO_RMK," ).append("\n"); 
		query.append("       TRSP_SO_TP_NM," ).append("\n"); 
		query.append("       TRSP_COST_DTL_MOD_NM," ).append("\n"); 
		query.append("       TRSP_WO_OFC_CTY_CD, " ).append("\n"); 
		query.append("       TRSP_WO_SEQ," ).append("\n"); 
		query.append("       TRSP_WO_NO," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       VNDR_NM," ).append("\n"); 
		query.append("       FM_NOD_CD," ).append("\n"); 
		query.append("       VIA_NOD_CD," ).append("\n"); 
		query.append("       TO_NOD_CD," ).append("\n"); 
		query.append("       DOR_NOD_CD," ).append("\n"); 
		query.append("       WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       PRE_WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("       PRE_SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("       WO_ISS_KNT," ).append("\n"); 
		query.append("       WO_ISS_STS_CD," ).append("\n"); 
		query.append("       REQUEST_TYPE1," ).append("\n"); 
		query.append("       REQUEST_TYPE2," ).append("\n"); 
		query.append("       PRE_NEGO_AMT," ).append("\n"); 
		query.append("       NEGO_AMT," ).append("\n"); 
		query.append("       PRE_SCG_AMT," ).append("\n"); 
		query.append("       SCG_AMT," ).append("\n"); 
		query.append("       /* REQUEST_TYPE */" ).append("\n"); 
		query.append("       REQUEST_TYPE1 ||(CASE WHEN REQUEST_TYPE1 IS NOT NULL AND REQUEST_TYPE2 IS NOT NULL THEN '; ' ELSE '' END)||REQUEST_TYPE2 AS REQUEST_TYPE," ).append("\n"); 
		query.append("       (CASE WHEN REQUEST_TYPE1 IS NOT NULL THEN NVL(NEGO_AMT, 0) ELSE 0 END) + (CASE WHEN REQUEST_TYPE2 IS NOT NULL THEN NVL(SCG_AMT, 0) ELSE 0 END) AS APPROVAL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("       AUTH_APRO_RQST_NO, " ).append("\n"); 
		query.append("       SUB_SYS_CD," ).append("\n"); 
		query.append("       PGM_NO," ).append("\n"); 
		query.append("       PGM_NM," ).append("\n"); 
		query.append("       AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("       AUTH_APRO_TP_NM," ).append("\n"); 
		query.append("       RQST_ST_DT," ).append("\n"); 
		query.append("       RQST_USR_ID," ).append("\n"); 
		query.append("       RQST_USR_NM," ).append("\n"); 
		query.append("       RQST_OFC_CD," ).append("\n"); 
		query.append("       DTL_PGM_URL_CTNT," ).append("\n"); 
		query.append("       AUTH_APRO_RMK," ).append("\n"); 
		query.append("       TRSP_SO_TP_NM," ).append("\n"); 
		query.append("       TRSP_COST_DTL_MOD_NM," ).append("\n"); 
		query.append("       TRSP_WO_OFC_CTY_CD, " ).append("\n"); 
		query.append("       TRSP_WO_SEQ," ).append("\n"); 
		query.append("       TRSP_WO_NO," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       VNDR_NM," ).append("\n"); 
		query.append("       FM_NOD_CD," ).append("\n"); 
		query.append("       VIA_NOD_CD," ).append("\n"); 
		query.append("       TO_NOD_CD," ).append("\n"); 
		query.append("       DOR_NOD_CD," ).append("\n"); 
		query.append("       WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       PRE_WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("       PRE_SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("       WO_ISS_KNT," ).append("\n"); 
		query.append("       WO_ISS_STS_CD," ).append("\n"); 
		query.append("       /* NEGO" ).append("\n"); 
		query.append("          1. ISSUE AND NEGO AMT != 0 Return Nego " ).append("\n"); 
		query.append("          2. REISSUE AND PRE_WO_PRV_GRP_SEQ IS NULL Retrun Nego" ).append("\n"); 
		query.append("          3. REISSUE AND PRE_NEGO_AMT != NEGO_AMT Return Nego" ).append("\n"); 
		query.append("       */" ).append("\n"); 
		query.append("       (CASE WHEN WO_ISS_STS_CD = 'I' " ).append("\n"); 
		query.append("                  THEN (CASE WHEN NEGO_AMT != 0 THEN 'Nego' ELSE '' END)" ).append("\n"); 
		query.append("             WHEN (WO_ISS_STS_CD = 'R' OR WO_ISS_STS_CD = 'C') AND PRE_WO_PRV_GRP_SEQ IS NULL THEN 'Nego'" ).append("\n"); 
		query.append("             WHEN (WO_ISS_STS_CD = 'R' OR WO_ISS_STS_CD = 'C') AND NEGO_AMT != ( SELECT SUM(NEGO_AMT) FROM TRS_TRSP_WRK_ORD_PRV_TMP WHERE 1=1 AND WO_PRV_GRP_SEQ = T1.PRE_WO_PRV_GRP_SEQ AND TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND TRSP_WO_SEQ = T1.TRSP_WO_SEQ) THEN 'Nego'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END) AS REQUEST_TYPE1," ).append("\n"); 
		query.append("       /* SURCHARGE" ).append("\n"); 
		query.append("          1. ISSUE AND SURCHARGE_AMT != 0 Return Additional " ).append("\n"); 
		query.append("          2. REISSUE AND PRE_SURCHARGE_AMT != SURCHARGE_AMT Return Additional" ).append("\n"); 
		query.append("       */" ).append("\n"); 
		query.append("       (CASE WHEN WO_ISS_STS_CD = 'I' " ).append("\n"); 
		query.append("                  THEN (CASE WHEN NVL((SELECT SUM(SCG_AMT) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0) != 0 THEN 'Additional' ELSE '' END)" ).append("\n"); 
		query.append("             WHEN (WO_ISS_STS_CD = 'R' OR WO_ISS_STS_CD = 'C') " ).append("\n"); 
		query.append("                  THEN (CASE WHEN" ).append("\n"); 
		query.append("                                  /* SCG_CNT = PRE_SCG_CNT */" ).append("\n"); 
		query.append("                                  (NVL((SELECT COUNT(1) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0)" ).append("\n"); 
		query.append("                                  =" ).append("\n"); 
		query.append("                                  NVL((SELECT COUNT(1) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.PRE_WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0))" ).append("\n"); 
		query.append("                                  /* SCG_CNT = SCG_COMPARE_CNT */" ).append("\n"); 
		query.append("                                  AND" ).append("\n"); 
		query.append("                                  (NVL((SELECT COUNT(1) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0)" ).append("\n"); 
		query.append("                                  =" ).append("\n"); 
		query.append("                                  NVL((SELECT COUNT(1) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT, TRS_TRSP_SCG_DTL_TMP SDT_2, TRS_TRSP_WRK_ORD_PRV_TMP WOPT_2" ).append("\n"); 
		query.append("                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                         /* WO PRE_WO_PRV_GRP_SEQ */" ).append("\n"); 
		query.append("                                         AND WOPT.WO_PRV_GRP_SEQ     = T1.PRE_WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_WO_SEQ        = T1.TRSP_WO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_OFC_CTY_CD = SDT.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_SEQ        = SDT.TRSP_SO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.SCG_DTL_TMP_SEQ    = SDT.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' " ).append("\n"); 
		query.append("                                         AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' " ).append("\n"); 
		query.append("                                         AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         /* WO WO_PRV_GRP_SEQ */" ).append("\n"); 
		query.append("                                         AND WOPT_2.WO_PRV_GRP_SEQ     = T1.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_SEQ        = T1.TRSP_WO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_OFC_CTY_CD = SDT_2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_SEQ        = SDT_2.TRSP_SO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.SCG_DTL_TMP_SEQ    = SDT_2.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND SDT_2.TRSP_AGMT_BFR_EXTD_FLG = 'N' " ).append("\n"); 
		query.append("                                         AND (SUBSTR(SDT_2.LGS_COST_CD,3,2) <> 'FU' " ).append("\n"); 
		query.append("                                         AND SUBSTR(SDT_2.LGS_COST_CD, 3, 4) <> 'OTAX') " ).append("\n"); 
		query.append("                                         /* PRE_WO_PRV_GRP_SEQ = WO_PRV_GRP_SEQ JOIN */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_SEQ        = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_OFC_CTY_CD = WOPT.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_SEQ        = WOPT.TRSP_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_OFC_CTY_CD   = SDT_2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_SEQ          = SDT_2.TRSP_SO_SEQ                     " ).append("\n"); 
		query.append("                                         AND SDT.LGS_COST_CD           = SDT_2.LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         ), 0) )" ).append("\n"); 
		query.append("                                  /* SCG_CNT = SCG_COMPARE_AMT_CNT */" ).append("\n"); 
		query.append("                                  AND" ).append("\n"); 
		query.append("                                  (NVL((SELECT COUNT(1) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0)" ).append("\n"); 
		query.append("                                  =" ).append("\n"); 
		query.append("                                  NVL((SELECT SUM(CASE WHEN SDT.SCG_AMT = SDT_2.SCG_AMT  THEN 1 ELSE 0 END) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT, TRS_TRSP_SCG_DTL_TMP SDT_2, TRS_TRSP_WRK_ORD_PRV_TMP WOPT_2" ).append("\n"); 
		query.append("                                        WHERE 1=1 " ).append("\n"); 
		query.append("                                         /* WO PRE_WO_PRV_GRP_SEQ */" ).append("\n"); 
		query.append("                                         AND WOPT.WO_PRV_GRP_SEQ     = T1.PRE_WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_WO_SEQ        = T1.TRSP_WO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_OFC_CTY_CD = SDT.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_SEQ        = SDT.TRSP_SO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT.SCG_DTL_TMP_SEQ    = SDT.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' " ).append("\n"); 
		query.append("                                         AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' " ).append("\n"); 
		query.append("                                         AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         /* WO WO_PRV_GRP_SEQ */" ).append("\n"); 
		query.append("                                         AND WOPT_2.WO_PRV_GRP_SEQ     = T1.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_SEQ        = T1.TRSP_WO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_OFC_CTY_CD = SDT_2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_SEQ        = SDT_2.TRSP_SO_SEQ " ).append("\n"); 
		query.append("                                         AND WOPT_2.SCG_DTL_TMP_SEQ    = SDT_2.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("                                         AND SDT_2.TRSP_AGMT_BFR_EXTD_FLG = 'N' " ).append("\n"); 
		query.append("                                         AND (SUBSTR(SDT_2.LGS_COST_CD,3,2) <> 'FU' " ).append("\n"); 
		query.append("                                         AND SUBSTR(SDT_2.LGS_COST_CD, 3, 4) <> 'OTAX') " ).append("\n"); 
		query.append("                                         /* PRE_WO_PRV_GRP_SEQ = WO_PRV_GRP_SEQ JOIN */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_WO_SEQ        = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_OFC_CTY_CD = WOPT.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT_2.TRSP_SO_SEQ        = WOPT.TRSP_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_OFC_CTY_CD   = SDT_2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("                                         AND WOPT.TRSP_SO_SEQ          = SDT_2.TRSP_SO_SEQ                     " ).append("\n"); 
		query.append("                                         AND SDT.LGS_COST_CD           = SDT_2.LGS_COST_CD" ).append("\n"); 
		query.append("                                         ), 0) )" ).append("\n"); 
		query.append("                             THEN ''" ).append("\n"); 
		query.append("                             ELSE 'Additional' END)" ).append("\n"); 
		query.append("             ELSE '' END) AS REQUEST_TYPE2," ).append("\n"); 
		query.append("        NEGO_AMT," ).append("\n"); 
		query.append("        NVL((SELECT SUM(NEGO_AMT) FROM TRS_TRSP_WRK_ORD_PRV_TMP WHERE 1=1 AND WO_PRV_GRP_SEQ = T1.PRE_WO_PRV_GRP_SEQ AND TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND TRSP_WO_SEQ = T1.TRSP_WO_SEQ), 0) AS PRE_NEGO_AMT," ).append("\n"); 
		query.append("        NVL((SELECT SUM(SCG_AMT) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("            AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0) AS SCG_AMT," ).append("\n"); 
		query.append("        NVL((SELECT SUM(SCG_AMT) FROM TRS_TRSP_SCG_DTL_TMP SDT, TRS_TRSP_WRK_ORD_PRV_TMP WOPT WHERE 1=1 AND WOPT.WO_PRV_GRP_SEQ = T1.PRE_WO_PRV_GRP_SEQ AND WOPT.TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD AND WOPT.TRSP_WO_SEQ = T1.TRSP_WO_SEQ AND WOPT.TRSP_SO_OFC_CTY_CD  = SDT.TRSP_SO_OFC_CTY_CD AND WOPT.TRSP_SO_SEQ  = SDT.TRSP_SO_SEQ AND WOPT.SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append("            AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N' AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX') ), 0) AS PRE_SCG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CAAR.AUTH_APRO_RQST_NO, " ).append("\n"); 
		query.append("       CAAR.SUB_SYS_CD," ).append("\n"); 
		query.append("       CAAR.PGM_NO," ).append("\n"); 
		query.append("       CAAR.PGM_NM," ).append("\n"); 
		query.append("       CAAR.AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("       CAAR.AUTH_APRO_TP_NM," ).append("\n"); 
		query.append("       CAAR.RQST_ST_DT," ).append("\n"); 
		query.append("       CAAR.RQST_USR_ID," ).append("\n"); 
		query.append("       CAAR.RQST_USR_NM," ).append("\n"); 
		query.append("       CAAR.RQST_OFC_CD," ).append("\n"); 
		query.append("       CAAR.DTL_PGM_URL_CTNT," ).append("\n"); 
		query.append("       CAAR.AUTH_APRO_RMK," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00279', (SELECT MAX(TRSP_SO_TP_CD) FROM TRS_TRSP_SVC_ORD SO, TRS_TRSP_WRK_ORD_PRV_TMP INWOPT WHERE INWOPT.WO_PRV_GRP_SEQ = WOPT.WO_PRV_GRP_SEQ AND INWOPT.TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD AND INWOPT.TRSP_WO_SEQ = WOPT.TRSP_WO_SEQ AND SO.TRSP_SO_OFC_CTY_CD = INWOPT.TRSP_SO_OFC_CTY_CD AND SO.TRSP_SO_SEQ = INWOPT.TRSP_SO_SEQ)) AS TRSP_SO_TP_NM," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00594', WOPT.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM," ).append("\n"); 
		query.append("       WOPT.TRSP_WO_OFC_CTY_CD, " ).append("\n"); 
		query.append("       WOPT.TRSP_WO_SEQ," ).append("\n"); 
		query.append("       WOPT.TRSP_WO_OFC_CTY_CD||WOPT.TRSP_WO_SEQ AS TRSP_WO_NO," ).append("\n"); 
		query.append("       WOPT.VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = WOPT.VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("       WOPT.FM_NOD_CD," ).append("\n"); 
		query.append("       WOPT.VIA_NOD_CD," ).append("\n"); 
		query.append("       WOPT.TO_NOD_CD," ).append("\n"); 
		query.append("       WOPT.DOR_NOD_CD," ).append("\n"); 
		query.append("       WOPT.WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       WOPT.SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("       WOH.WO_ISS_KNT," ).append("\n"); 
		query.append("       WOH.WO_ISS_STS_CD," ).append("\n"); 
		query.append("       SUM(NEGO_AMT) AS NEGO_AMT," ).append("\n"); 
		query.append("       (SELECT MAX(WO_PRV_GRP_SEQ) KEEP( DENSE_RANK LAST ORDER BY CRE_DT ASC)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("         WHERE TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND TRSP_WO_SEQ = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("           AND (WO_PRV_GRP_SEQ < WOPT.WO_PRV_GRP_SEQ OR WO_PRV_GRP_SEQ IS NULL)" ).append("\n"); 
		query.append("           AND WO_ISS_STS_CD IN ('I', 'R', 'C') ) PRE_WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("       (SELECT MAX(SCG_DTL_TMP_SEQ) KEEP( DENSE_RANK LAST ORDER BY CRE_DT ASC)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("         WHERE TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND TRSP_WO_SEQ = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("           AND (WO_PRV_GRP_SEQ < WOPT.WO_PRV_GRP_SEQ OR WO_PRV_GRP_SEQ IS NULL)" ).append("\n"); 
		query.append("           AND WO_ISS_STS_CD IN ('I', 'R', 'C')) PRE_SCG_DTL_TMP_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("/* TRS END */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("Q.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append(", P.SUB_SYS_CD" ).append("\n"); 
		query.append(", P.PGM_NO" ).append("\n"); 
		query.append(", C.PGM_NM" ).append("\n"); 
		query.append(", B.AUTH_APRO_TP_CD" ).append("\n"); 
		query.append(", (SELECT CD.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("   FROM COM_INTG_CD_DTL CD " ).append("\n"); 
		query.append("   WHERE CD.INTG_CD_ID='CD03436' AND CD.INTG_CD_VAL_CTNT = B.AUTH_APRO_TP_CD AND ROWNUM=1) AUTH_APRO_TP_NM" ).append("\n"); 
		query.append(", TO_CHAR(Q.RQST_ST_DT,'YYYY-MM-DD HH24:MI') RQST_ST_DT" ).append("\n"); 
		query.append(", Q.RQST_USR_ID" ).append("\n"); 
		query.append(", (SELECT U.USR_NM FROM COM_USER U" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND  U.USR_ID = Q.RQST_USR_ID " ).append("\n"); 
		query.append("    ) RQST_USR_NM" ).append("\n"); 
		query.append(", Q.RQST_OFC_CD" ).append("\n"); 
		query.append(", B.DTL_PGM_URL_CTNT" ).append("\n"); 
		query.append(", R.AUTH_APRO_RMK" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_RQST Q, COM_AUTH_PGM_BTN B, COM_AUTH_PGM P, COM_PROGRAM C, COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(Q.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(Q.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND Q.AUTH_PGM_BTN_SEQ = B.AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("AND B.AUTH_PGM_SEQ = P.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("AND R.AUTH_APSTS_CD = 'P'" ).append("\n"); 
		query.append("AND DECODE(@[sub_sys_cd_auth],NULL,'ALL','','ALL','ALL','ALL',P.SUB_SYS_CD) = DECODE(@[sub_sys_cd_auth],NULL,'ALL','','ALL','ALL','ALL',@[sub_sys_cd_auth]) " ).append("\n"); 
		query.append("AND DECODE(@[pgm_no],NULL,'ALL','','ALL','ALL','ALL',P.PGM_NO) = DECODE(@[pgm_no],NULL,'ALL','','ALL','ALL','ALL',@[pgm_no]) " ).append("\n"); 
		query.append("AND DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',B.AUTH_APRO_TP_CD) = DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',@[auth_apro_tp_cd]) --ex  'AF'" ).append("\n"); 
		query.append("AND NVL(P.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(C.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(R.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("AND Q.CRNT_AUTH_APRO_RQST_SEQ >= R.AUTH_APRO_RQST_ROUT_SEQ" ).append("\n"); 
		query.append("AND R.AUTH_APRO_USR_ID IN ( SELECT NVL(U.USR_ID, U.EP_ID)" ).append("\n"); 
		query.append("                            FROM COM_USER U" ).append("\n"); 
		query.append("                            WHERE (U.USR_ID = @[login_usr_id] OR U.EP_ID = @[login_usr_id])" ).append("\n"); 
		query.append("                            AND NVL(U.USE_FLG,'N') = 'Y' )" ).append("\n"); 
		query.append("#if (${sdate_auth} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(Q.RQST_ST_DT, 'YYYY-MM-DD') >= @[sdate_auth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edate_auth} != '')" ).append("\n"); 
		query.append("AND TO_CHAR(Q.RQST_ST_DT, 'YYYY-MM-DD') <= @[edate_auth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(Q.CXL_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("/* TRS START */" ).append("\n"); 
		query.append(") CAAR, TRS_TRSP_WRK_ORD_HIS WOH, TRS_TRSP_WRK_ORD_PRV_TMP WOPT" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND CAAR.AUTH_APRO_RQST_NO = WOH.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("     AND WOH.TRSP_WO_OFC_CTY_CD = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND WOH.TRSP_WO_SEQ        = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("     AND WOH.WO_PRV_GRP_SEQ     = WOPT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("GROUP BY CAAR.AUTH_APRO_RQST_NO, " ).append("\n"); 
		query.append("         CAAR.SUB_SYS_CD," ).append("\n"); 
		query.append("         CAAR.PGM_NO," ).append("\n"); 
		query.append("         CAAR.PGM_NM," ).append("\n"); 
		query.append("         CAAR.AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("         CAAR.AUTH_APRO_TP_NM," ).append("\n"); 
		query.append("         CAAR.RQST_ST_DT," ).append("\n"); 
		query.append("         CAAR.RQST_USR_ID," ).append("\n"); 
		query.append("         CAAR.RQST_USR_NM," ).append("\n"); 
		query.append("         CAAR.RQST_OFC_CD," ).append("\n"); 
		query.append("         CAAR.DTL_PGM_URL_CTNT," ).append("\n"); 
		query.append("         CAAR.AUTH_APRO_RMK," ).append("\n"); 
		query.append("         WOH.WO_ISS_KNT," ).append("\n"); 
		query.append("         WOH.WO_ISS_STS_CD," ).append("\n"); 
		query.append("         WOPT.WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("         WOPT.SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("         WOPT.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("         WOPT.TRSP_WO_OFC_CTY_CD, " ).append("\n"); 
		query.append("         WOPT.TRSP_WO_SEQ," ).append("\n"); 
		query.append("         WOPT.VNDR_SEQ," ).append("\n"); 
		query.append("         WOPT.FM_NOD_CD," ).append("\n"); 
		query.append("         WOPT.VIA_NOD_CD," ).append("\n"); 
		query.append("         WOPT.TO_NOD_CD," ).append("\n"); 
		query.append("         WOPT.DOR_NOD_CD" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4, 5, 6, 7, 8, TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ" ).append("\n"); 
		query.append("/* TRS END */" ).append("\n"); 

	}
}