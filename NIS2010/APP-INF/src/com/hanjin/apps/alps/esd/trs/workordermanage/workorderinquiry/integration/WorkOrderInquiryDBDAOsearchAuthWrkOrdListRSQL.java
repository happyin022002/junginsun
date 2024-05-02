/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchAuthWrkOrdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchAuthWrkOrdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchAuthWrkOrdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchAuthWrkOrdListRSQL").append("\n"); 
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
		query.append("WITH W_WOH AS(SELECT T1.AUTH_APRO_RQST_NO," ).append("\n"); 
		query.append("               T1.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("               T1.TRSP_WO_SEQ," ).append("\n"); 
		query.append("               T1.WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("               T1.SCG_DTL_TMP_SEQ," ).append("\n"); 
		query.append("               (SELECT MAX(WO_PRV_GRP_SEQ) KEEP( DENSE_RANK LAST ORDER BY CRE_DT ASC)" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("                 WHERE TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND TRSP_WO_SEQ = T1.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                   AND (WO_PRV_GRP_SEQ < T1.WO_PRV_GRP_SEQ OR WO_PRV_GRP_SEQ IS NULL)" ).append("\n"); 
		query.append("                   AND WO_ISS_STS_CD IN ('I', 'R') ) PRE_WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("               (SELECT MAX(SCG_DTL_TMP_SEQ) KEEP( DENSE_RANK LAST ORDER BY CRE_DT ASC)" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_WRK_ORD_HIS" ).append("\n"); 
		query.append("                 WHERE TRSP_WO_OFC_CTY_CD = T1.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND TRSP_WO_SEQ = T1.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                   AND (WO_PRV_GRP_SEQ < T1.WO_PRV_GRP_SEQ OR WO_PRV_GRP_SEQ IS NULL)" ).append("\n"); 
		query.append("                   AND WO_ISS_STS_CD IN ('I', 'R')) PRE_SCG_DTL_TMP_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_WRK_ORD_HIS T1" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND T1.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no] )," ).append("\n"); 
		query.append("       W_SDT AS ( SELECT * FROM (SELECT NVL(T1.WO_PRV_GRP_SEQ, T2.WO_PRV_GRP_SEQ) AS WO_PRV_GRP_SEQ, " ).append("\n"); 
		query.append("                         NVL(T1.TRSP_WO_OFC_CTY_CD, T2.TRSP_WO_OFC_CTY_CD) AS TRSP_WO_OFC_CTY_CD , " ).append("\n"); 
		query.append("                         NVL(T1.TRSP_WO_SEQ, T2.TRSP_WO_SEQ) AS TRSP_WO_SEQ, " ).append("\n"); 
		query.append("                         NVL(T1.TRSP_SO_OFC_CTY_CD, T2.TRSP_SO_OFC_CTY_CD) AS TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("                         NVL(T1.TRSP_SO_SEQ, T2.TRSP_SO_SEQ) AS TRSP_SO_SEQ, " ).append("\n"); 
		query.append("                         NVL(T1.LGS_COST_CD, T2.LGS_COST_CD) AS LGS_COST_CD, " ).append("\n"); 
		query.append("                         T1.SCG_AMT," ).append("\n"); 
		query.append("                         T1.OTR_RMK," ).append("\n"); 
		query.append("                         T2.LGS_COST_CD AS PRE_LGS_COST_CD, " ).append("\n"); 
		query.append("                         T2.SCG_AMT AS PRE_SCG_AMT" ).append("\n"); 
		query.append("                  FROM ( SELECT W1.WO_PRV_GRP_SEQ, WOPT.TRSP_WO_OFC_CTY_CD, WOPT.TRSP_WO_SEQ, WOPT.TRSP_SO_OFC_CTY_CD, WOPT.TRSP_SO_SEQ, SDT.LGS_COST_CD, SDT.SCG_AMT, SDT.OTR_RMK" ).append("\n"); 
		query.append("                           FROM W_WOH W1, TRS_TRSP_WRK_ORD_PRV_TMP WOPT, TRS_TRSP_SCG_DTL_TMP SDT " ).append("\n"); 
		query.append("                          WHERE 1=1 " ).append("\n"); 
		query.append("                            AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N'" ).append("\n"); 
		query.append("                            AND W1.WO_PRV_GRP_SEQ       = WOPT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("                            AND W1.TRSP_WO_OFC_CTY_CD   = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND W1.TRSP_WO_SEQ          = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                            AND W1.SCG_DTL_TMP_SEQ      = SDT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("                            AND WOPT.TRSP_SO_OFC_CTY_CD = SDT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX')" ).append("\n"); 
		query.append("                            AND WOPT.TRSP_SO_SEQ        = SDT.TRSP_SO_SEQ) T1 FULL OUTER JOIN" ).append("\n"); 
		query.append("                       ( SELECT W1.WO_PRV_GRP_SEQ, WOPT.TRSP_WO_OFC_CTY_CD, WOPT.TRSP_WO_SEQ, WOPT.TRSP_SO_OFC_CTY_CD, WOPT.TRSP_SO_SEQ, SDT.LGS_COST_CD, SDT.SCG_AMT, SDT.OTR_RMK" ).append("\n"); 
		query.append("                           FROM W_WOH W1, TRS_TRSP_WRK_ORD_PRV_TMP WOPT, TRS_TRSP_SCG_DTL_TMP SDT " ).append("\n"); 
		query.append("                          WHERE 1=1 " ).append("\n"); 
		query.append("                            AND SDT.TRSP_AGMT_BFR_EXTD_FLG = 'N'" ).append("\n"); 
		query.append("                            AND W1.PRE_WO_PRV_GRP_SEQ   = WOPT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("                            AND W1.TRSP_WO_OFC_CTY_CD   = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND W1.TRSP_WO_SEQ          = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                            AND W1.PRE_SCG_DTL_TMP_SEQ  = SDT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("                            AND WOPT.TRSP_SO_OFC_CTY_CD = SDT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND (SUBSTR(SDT.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(SDT.LGS_COST_CD, 3, 4) <> 'OTAX')" ).append("\n"); 
		query.append("                            AND WOPT.TRSP_SO_SEQ        = SDT.TRSP_SO_SEQ) T2" ).append("\n"); 
		query.append("                    ON T1.WO_PRV_GRP_SEQ = T2.WO_PRV_GRP_SEQ AND T1.TRSP_WO_OFC_CTY_CD = T2.TRSP_WO_OFC_CTY_CD AND T1.TRSP_WO_SEQ = T2.TRSP_WO_SEQ " ).append("\n"); 
		query.append("                   AND T1.TRSP_SO_OFC_CTY_CD = T2.TRSP_SO_OFC_CTY_CD AND T1.TRSP_SO_SEQ = T2.TRSP_SO_SEQ AND T1.LGS_COST_CD = T2.LGS_COST_CD ) WHERE 1=1 AND NVL(SCG_AMT, 0) != NVL(PRE_SCG_AMT, 0)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("SELECT T1.*, ROW_NUMBER() OVER (PARTITION BY T1.AUTH_APRO_RQST_NO ORDER BY T1.AUTH_APRO_RQST_NO, T1.TRSP_WO_OFC_CTY_CD, T1.TRSP_WO_SEQ, T1.TRSP_SO_OFC_CTY_CD, T1.TRSP_SO_SEQ) AUTH_APRO_RQST_NO_SEQ FROM ( " ).append("\n"); 
		query.append("SELECT W1.AUTH_APRO_RQST_NO," ).append("\n"); 
		query.append("       W1.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("       W1.TRSP_WO_SEQ," ).append("\n"); 
		query.append("       (W1.TRSP_WO_OFC_CTY_CD || W1.TRSP_WO_SEQ) AS WO_NO," ).append("\n"); 
		query.append("       WOPT.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       WOPT.TRSP_SO_SEQ," ).append("\n"); 
		query.append("       WOPT.CURR_CD," ).append("\n"); 
		query.append("       (WOPT.TRSP_SO_OFC_CTY_CD || WOPT.TRSP_SO_SEQ) AS SO_NO," ).append("\n"); 
		query.append("       NVL(WOPT.NEGO_AMT, 0) AS NEGO_AMT, " ).append("\n"); 
		query.append("       (CASE WHEN NVL(W1.PRE_WO_PRV_GRP_SEQ, 0) = 0 " ).append("\n"); 
		query.append("             THEN 0 " ).append("\n"); 
		query.append("             ELSE NVL((SELECT SUM(NEGO_AMT)" ).append("\n"); 
		query.append("                         FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND WOPT.TRSP_WO_OFC_CTY_CD = TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                          AND WOPT.TRSP_WO_SEQ = TRSP_WO_SEQ" ).append("\n"); 
		query.append("                          AND WOPT.TRSP_SO_OFC_CTY_CD = TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                          AND WOPT.TRSP_SO_SEQ = TRSP_SO_SEQ" ).append("\n"); 
		query.append("                          AND W1.PRE_WO_PRV_GRP_SEQ = WO_PRV_GRP_SEQ ) , 0) END) AS PRE_NEGO_AMT," ).append("\n"); 
		query.append("       WOPT.NEGO_RMK, W2.LGS_COST_CD, NVL(W2.SCG_AMT, 0) AS SCG_AMT, NVL(W2.PRE_SCG_AMT, 0) AS PRE_SCG_AMT," ).append("\n"); 
		query.append("       (SELECT MAX(LGS_COST_FULL_NM) FROM TES_LGS_COST LC WHERE LC.LGS_COST_CD = W2.LGS_COST_CD) AS LGS_COST_FULL_NM, " ).append("\n"); 
		query.append("       OTR_RMK," ).append("\n"); 
		query.append("       (SELECT MAX(TRSP_SO_TP_CD) FROM TRS_TRSP_SVC_ORD SO WHERE 1=1 AND SO.TRSP_SO_OFC_CTY_CD = WOPT.TRSP_SO_OFC_CTY_CD AND SO.TRSP_SO_SEQ = WOPT.TRSP_SO_SEQ) AS TRSP_SO_TP_CD," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00279', (SELECT MAX(TRSP_SO_TP_CD) FROM TRS_TRSP_SVC_ORD SO WHERE 1=1 AND SO.TRSP_SO_OFC_CTY_CD = WOPT.TRSP_SO_OFC_CTY_CD AND SO.TRSP_SO_SEQ = WOPT.TRSP_SO_SEQ))     AS TRSP_SO_TP_NM," ).append("\n"); 
		query.append("       WOPT.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00594', WOPT.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM ," ).append("\n"); 
		query.append("       WOPT.VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = WOPT.VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("       WOPT.FM_NOD_CD," ).append("\n"); 
		query.append("       WOPT.VIA_NOD_CD," ).append("\n"); 
		query.append("       WOPT.TO_NOD_CD," ).append("\n"); 
		query.append("       WOPT.DOR_NOD_CD," ).append("\n"); 
		query.append("       (SELECT MAX(AUTH_APRO_RMK) KEEP(DENSE_RANK FIRST ORDER BY CAARR.UPD_DT DESC) AUTH_APRO_RMK FROM COM_AUTH_APRO_RQST_ROUT CAARR WHERE 1=1 AND AUTH_APRO_RQST_NO = W1.AUTH_APRO_RQST_NO AND AUTH_APRO_RMK IS NOT NULL) AS AUTH_APRO_RMK," ).append("\n"); 
		query.append("       WOPT.INTER_RMK" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD_PRV_TMP WOPT," ).append("\n"); 
		query.append("       W_WOH W1," ).append("\n"); 
		query.append("       W_SDT W2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND W1.TRSP_WO_OFC_CTY_CD   = WOPT.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND W1.TRSP_WO_SEQ          = WOPT.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND W1.WO_PRV_GRP_SEQ       = WOPT.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("   AND WOPT.WO_PRV_GRP_SEQ     = W2.WO_PRV_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND WOPT.TRSP_WO_OFC_CTY_CD = W2.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND WOPT.TRSP_WO_SEQ        = W2.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("   AND WOPT.TRSP_SO_OFC_CTY_CD = W2.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND WOPT.TRSP_SO_SEQ        = W2.TRSP_SO_SEQ(+) ) T1" ).append("\n"); 
		query.append("   -- 마지막에.. 같은값들은 제거" ).append("\n"); 
		query.append("   --AND ( NEGO != PRE_NEGO OR NVL(W2.SCG_AMT, 0) != NVL(W2.PRE_SCG_AMT, 0))" ).append("\n"); 
		query.append("WHERE ((LGS_COST_CD IS NULL AND NVL(NEGO_AMT,0) != NVL(PRE_NEGO_AMT,0)) OR LGS_COST_CD IS NOT NULL)" ).append("\n"); 
		query.append("   ORDER BY AUTH_APRO_RQST_NO, TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 

	}
}