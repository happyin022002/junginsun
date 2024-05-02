/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AutoAuditRptDAOsearchAutoAuditChangeHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.16 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AutoAuditRptDAOsearchAutoAuditChangeHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit 변경 이력 조회
	  * </pre>
	  */
	public AutoAuditRptDAOsearchAutoAuditChangeHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_more_than_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_cfm_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_after_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_before_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_expn_aud_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_cfm_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.integration").append("\n"); 
		query.append("FileName : AutoAuditRptDAOsearchAutoAuditChangeHistoryRSQL").append("\n"); 
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
		query.append("WITH SRC AS (" ).append("\n"); 
		query.append("SELECT MDL_CD" ).append("\n"); 
		query.append("      ,RHQ_CD" ).append("\n"); 
		query.append("      #if(${s_ofc_cd} == '')" ).append("\n"); 
		query.append("       ,RHQ_CD AS INV_OFC_CD" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("       ,INV_OFC_CD" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ,EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'P' THEN 1 END)) CACO_CNT -- Candidate EAC => Coincidence" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'P' THEN INV_AMT END) / US_XCH_RT),2) AS CACO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'E' THEN 1 END)) CAPO_CNT -- Candidate EAC => Potential EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'E' THEN INV_AMT END) / US_XCH_RT),2) AS CAPO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'A' THEN 1 END)) POCA_CNT -- Potential EAC => Candidate EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'A' THEN INV_AMT END) / US_XCH_RT),2) AS POCA_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'P' THEN 1 END)) POCO_CNT -- Potential EAC => Coincidence" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'P' THEN INV_AMT END) / US_XCH_RT),2) AS POCO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'A' THEN 1 END)) COCA_CNT -- Coincidence => Candidate EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'A' THEN INV_AMT END) / US_XCH_RT),2) AS COCA_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'E' THEN 1 END)) COPO_CNT -- Coincidence => Potential EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'E' THEN INV_AMT END) / US_XCH_RT),2) AS COPO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'A' THEN 1 END)) CACA_CNT -- Candidate EAC => Candidate EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'C' AND EXPN_AUD_STS_CD = 'A' THEN INV_AMT END) / US_XCH_RT),2) AS CACA_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'P' THEN 1 END)) COCO_CNT -- Coincidence => Coincidence" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'S' AND EXPN_AUD_STS_CD = 'P' THEN INV_AMT END) / US_XCH_RT),2) AS COCO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'E' THEN 1 END)) POPO_CNT -- Potential EAC => Potential EAC" ).append("\n"); 
		query.append("      ,ROUND(SUM((CASE WHEN AUTO_EXPN_AUD_STS_CD = 'F' AND EXPN_AUD_STS_CD = 'E' THEN INV_AMT END) / US_XCH_RT),2) AS POPO_USD_AMT" ).append("\n"); 
		query.append("      ,SUM(1) TOT_CNT -- TOTAL" ).append("\n"); 
		query.append("      ,ROUND(SUM(INV_AMT / US_XCH_RT),2) AS TOT_USD_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT NULL MDL_CD" ).append("\n"); 
		query.append("             , NULL RHQ_CD" ).append("\n"); 
		query.append("             , NULL INV_OFC_CD" ).append("\n"); 
		query.append("             , NULL AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , NULL EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , NULL EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("             , NULL CURR_CD" ).append("\n"); 
		query.append("             , NULL INV_AMT" ).append("\n"); 
		query.append("             , NULL INV_CFM_DT" ).append("\n"); 
		query.append("             , NULL US_XCH_RT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'TRS')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRS' MDL_CD" ).append("\n"); 
		query.append("             , RHQ_CD" ).append("\n"); 
		query.append("             , INV_OFC_CD" ).append("\n"); 
		query.append("             , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , INV_AMT" ).append("\n"); 
		query.append("             , INV_CFM_DT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(A.CURR_CD, 'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                    ELSE (" ).append("\n"); 
		query.append("                         SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                          WHERE XCH.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("                            AND XCH.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                            AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(A.INV_CFM_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("               END US_XCH_RT" ).append("\n"); 
		query.append("          FROM EAS_TRSP_AUD A" ).append("\n"); 
		query.append("         WHERE A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_inv_cfm_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_inv_cfm_to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD IN ('S', 'F', 'C')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'X'             " ).append("\n"); 
		query.append("                         FROM TRS_TRSP_INV_WRK X" ).append("\n"); 
		query.append("                             ,AP_INV_HDR Y" ).append("\n"); 
		query.append("                        WHERE X.INV_NO       = A.INV_NO	" ).append("\n"); 
		query.append("                          AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                          AND X.CSR_NO       = Y.CSR_NO(+)" ).append("\n"); 
		query.append("                          AND X.TRSP_INV_AUD_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("                          AND Y.RCV_ERR_FLG(+) <> 'E'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'X'             " ).append("\n"); 
		query.append("                         FROM TRS_TRSP_RAIL_INV_WRK X" ).append("\n"); 
		query.append("                             ,AP_INV_HDR Y" ).append("\n"); 
		query.append("                        WHERE X.INV_NO       = A.INV_NO	" ).append("\n"); 
		query.append("                          AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                          AND X.CSR_NO       = Y.CSR_NO(+)" ).append("\n"); 
		query.append("                          AND X.TRSP_INV_AUD_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("                          AND Y.RCV_ERR_FLG(+) <> 'E'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("           #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '' && ${s_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'TRS')" ).append("\n"); 
		query.append("           AND 1=1" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           AND 1=2" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_before_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD = @[s_before_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_after_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD = @[s_after_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_expn_aud_rslt_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_RSLT_CD = @[s_expn_aud_rslt_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_eac_if_flg} != '')" ).append("\n"); 
		query.append("             #if(${s_eac_if_flg} == 'Y')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_TRSP_AUD_CHK X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_TRSP_AUD_CHK X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.INV_VNDR_SEQ = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'TES')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TES' MDL_CD" ).append("\n"); 
		query.append("             , A.RHQ_CD" ).append("\n"); 
		query.append("             , A.INV_OFC_CD" ).append("\n"); 
		query.append("             , A.AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , A.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.INV_AMT" ).append("\n"); 
		query.append("             , A.INV_CFM_DT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(A.CURR_CD, 'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                    ELSE (" ).append("\n"); 
		query.append("                         SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                          WHERE XCH.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("                            AND XCH.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                            AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(A.INV_CFM_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("               END US_XCH_RT" ).append("\n"); 
		query.append("          FROM EAS_TML_AUD A" ).append("\n"); 
		query.append("             , TES_TML_SO_HDR H" ).append("\n"); 
		query.append("             , AP_INV_HDR AH" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND A.YD_CD   = H.YD_CD" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ  = H.VNDR_SEQ" ).append("\n"); 
		query.append("           AND A.INV_NO  = H.INV_NO" ).append("\n"); 
		query.append("           AND A.INV_CFM_DT = H.INV_CFM_DT" ).append("\n"); 
		query.append("           AND NVL(H.DELT_FLG, 'N')    = 'N'" ).append("\n"); 
		query.append("           -- Detail중 한건이라도 Estimation 물량집계 데이타가 있는 데이타를 기본으로 보여주고 Estimation 물량이 없을 경우 Confirm후 14일 이후 심사대상으로 조회한다." ).append("\n"); 
		query.append("           AND ( ((NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_ESTM_VOL_RSLT_CD_QTY, 0)) > 0) " ).append("\n"); 
		query.append("              OR  ( ((NVL(A.AUD_DTL_TGT_QTY, 0) - NVL(A.BAT_ESTM_VOL_RSLT_CD_QTY, 0)) = 0) " ).append("\n"); 
		query.append("              AND  A.INV_CFM_DT < SYSDATE - 14))" ).append("\n"); 
		query.append("           AND H.CSR_NO  = AH.CSR_NO(+)" ).append("\n"); 
		query.append("           AND H.TML_INV_STS_CD <> 'R'" ).append("\n"); 
		query.append("           AND H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("           AND AH.RCV_ERR_FLG(+) <> 'E'" ).append("\n"); 
		query.append("           AND  A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_inv_cfm_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_inv_cfm_to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD IN ('S', 'F', 'C')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("           #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '' && ${s_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'TES')" ).append("\n"); 
		query.append("           AND 1=1" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           AND 1=2" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_before_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD = @[s_before_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_after_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD = @[s_after_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_expn_aud_rslt_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_RSLT_CD = @[s_expn_aud_rslt_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_eac_if_flg} != '')" ).append("\n"); 
		query.append("             #if(${s_eac_if_flg} == 'Y')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_TML_AUD_DTL X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.INV_CFM_DT = A.INV_CFM_DT" ).append("\n"); 
		query.append("                            AND X.EXPN_AUD_SEQ = A.EXPN_AUD_SEQ" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_TML_AUD_DTL X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.INV_CFM_DT = A.INV_CFM_DT" ).append("\n"); 
		query.append("                            AND X.EXPN_AUD_SEQ = A.EXPN_AUD_SEQ" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'MNR')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'MNR' MDL_CD" ).append("\n"); 
		query.append("             , A.RHQ_CD" ).append("\n"); 
		query.append("             , A.INV_OFC_CD" ).append("\n"); 
		query.append("             , A.AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , A.EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , A.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.INV_AMT" ).append("\n"); 
		query.append("             , A.INV_CFM_DT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(A.INV_CURR_CD, 'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                    ELSE (" ).append("\n"); 
		query.append("                         SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                          WHERE XCH.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("                            AND XCH.CURR_CD = A.INV_CURR_CD" ).append("\n"); 
		query.append("                            AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(A.INV_CFM_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("               END US_XCH_RT" ).append("\n"); 
		query.append("          FROM EAS_MNR_CFM_INV A" ).append("\n"); 
		query.append("             , AP_PAY_INV B" ).append("\n"); 
		query.append("             , AP_INV_HDR C" ).append("\n"); 
		query.append("             , MDM_VENDOR D" ).append("\n"); 
		query.append("             , MNR_PAY_INV_WRK E" ).append("\n"); 
		query.append("         WHERE A.INV_RGST_NO = B.INV_RGST_NO" ).append("\n"); 
		query.append("           AND B.CSR_NO = C.CSR_NO(+)" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND A.INV_RGST_NO = E.INV_RGST_NO" ).append("\n"); 
		query.append("           AND E.MNR_INV_STS_CD = 'HC'" ).append("\n"); 
		query.append("           AND C.RCV_ERR_FLG(+) IS NULL --E(AP REJECT) OR NULL" ).append("\n"); 
		query.append("           AND C.IF_FLG(+) IS NULL -- Y(정상) E(ERROR) NULL(진행안함)" ).append("\n"); 
		query.append("           AND C.AFT_ACT_FLG(+) IS NULL -- N(CANCEL) X(CANCEL : ) NULL(정상)" ).append("\n"); 
		query.append("           AND A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_inv_cfm_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_inv_cfm_to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD IN ('S', 'F', 'C')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("           #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '' && ${s_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'MNR')" ).append("\n"); 
		query.append("           AND 1=1" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           AND 1=2" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_before_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.AUTO_EXPN_AUD_STS_CD = @[s_before_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_after_sts_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_STS_CD = @[s_after_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_expn_aud_rslt_cd} != '')" ).append("\n"); 
		query.append("           AND A.EXPN_AUD_RSLT_CD = @[s_expn_aud_rslt_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${s_eac_if_flg} != '')" ).append("\n"); 
		query.append("             #if(${s_eac_if_flg} == 'Y')" ).append("\n"); 
		query.append("             AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_MNR_CFM_INV_DTL X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                           FROM EAS_MNR_CFM_INV_DTL X" ).append("\n"); 
		query.append("                          WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                            AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("                            AND X.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'PSO')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("       SELECT 'PSO' MDL_CD" ).append("\n"); 
		query.append("             , RHQ_CD" ).append("\n"); 
		query.append("             , INV_OFC_CD" ).append("\n"); 
		query.append("             , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , PORT_CHG_AUD_CHK_CD AS EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("             , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , INV_AMT" ).append("\n"); 
		query.append("             , INV_CFM_DT" ).append("\n"); 
		query.append("             , CASE WHEN NVL(AB.CURR_CD, 'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                    ELSE (" ).append("\n"); 
		query.append("                         SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                          WHERE XCH.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("                            AND XCH.CURR_CD = AB.CURR_CD" ).append("\n"); 
		query.append("                            AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(AB.INV_CFM_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("               END US_XCH_RT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT MAX(A.RHQ_CD) AS RHQ_CD" ).append("\n"); 
		query.append("                     , MAX(A.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("                     , MAX(A.AUTO_EXPN_AUD_STS_CD) AS AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("                     , MAX(A.PORT_CHG_AUD_CHK_CD) AS EXPN_AUD_STS_CD " ).append("\n"); 
		query.append("                     , MAX(A.EXPN_AUD_RSLT_CD) AS  EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("                     , MAX(A.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("                     , MAX(A.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("                     , MAX(A.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("                     , MAX(A.PORT_CHG_AUD_CHK_CD) AS PORT_CHG_AUD_CHK_CD" ).append("\n"); 
		query.append("                     , A.ISS_CTY_CD" ).append("\n"); 
		query.append("                     , A.SO_SEQ" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                     , A.LGS_COST_CD " ).append("\n"); 
		query.append("                  FROM EAS_PORT_SO_CFM_INV A" ).append("\n"); 
		query.append("                     , TES_LGS_COST C" ).append("\n"); 
		query.append("                     , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("                     , EAS_PORT_SO_CHG_ACCT CS" ).append("\n"); 
		query.append("                     , AP_PAY_INV AI" ).append("\n"); 
		query.append("                     , AP_INV_HDR AH" ).append("\n"); 
		query.append("                     , PSO_CHARGE PSO" ).append("\n"); 
		query.append("                     , EAS_AUTO_AUD_BAT B" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND A.ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("                   AND A.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND A.RHQ_CD = CS.AUD_OFC_CD" ).append("\n"); 
		query.append("                   AND A.LGS_COST_CD = CS.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND A.ISS_CTY_CD = PSO.ISS_CTY_CD " ).append("\n"); 
		query.append("                   AND A.SO_SEQ = PSO.SO_SEQ" ).append("\n"); 
		query.append("                   AND PSO.INV_RGST_NO  = AI.INV_RGST_NO" ).append("\n"); 
		query.append("                   AND AI.CSR_NO       = AH.CSR_NO(+)" ).append("\n"); 
		query.append("                   AND B.SUB_SYS_CD(+) = 'PSO'" ).append("\n"); 
		query.append("                   AND A.ISS_CTY_CD   = B.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND A.SO_SEQ       = B.SO_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.SO_DTL_SEQ   = B.SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND LENGTH(A.LGS_COST_CD) = 6" ).append("\n"); 
		query.append("                   AND C.ACCT_CD NOT IN ('999999', '511795')" ).append("\n"); 
		query.append("                   AND ((SUBSTR(C.ACCT_CD,0,4) IN ('5117', '5118', '5119') AND CS.LGS_COST_AUD_FLG = 'Y')) " ).append("\n"); 
		query.append("                   AND A.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_inv_cfm_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_inv_cfm_to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                   AND A.AUTO_EXPN_AUD_STS_CD IN ('S', 'F', 'C')" ).append("\n"); 
		query.append("                   AND A.PORT_CHG_AUD_CHK_CD IS NOT NULL" ).append("\n"); 
		query.append("                   AND NVL(AH.RCV_ERR_FLG, 'X') <> 'E'" ).append("\n"); 
		query.append("                   #if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND A.RHQ_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_ofc_cd} != '' && ${s_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("                   AND A.INV_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_mdl_cd} == '' || ${s_mdl_cd} == 'PSO')" ).append("\n"); 
		query.append("                   AND 1=1" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                   AND 1=2" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_before_sts_cd} != '')" ).append("\n"); 
		query.append("                   AND A.AUTO_EXPN_AUD_STS_CD = @[s_before_sts_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_after_sts_cd} != '')" ).append("\n"); 
		query.append("                   AND A.PORT_CHG_AUD_CHK_CD = @[s_after_sts_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_expn_aud_rslt_cd} != '')" ).append("\n"); 
		query.append("                   AND A.EXPN_AUD_RSLT_CD = @[s_expn_aud_rslt_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${s_eac_if_flg} != '')" ).append("\n"); 
		query.append("                     #if(${s_eac_if_flg} == 'Y')" ).append("\n"); 
		query.append("                       AND A.EAC_NO IS NOT NULL" ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                       AND A.EAC_NO IS NULL" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("              GROUP BY A.ISS_CTY_CD" ).append("\n"); 
		query.append("                     , A.SO_SEQ" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.LGS_COST_CD " ).append("\n"); 
		query.append("              ) AB" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RHQ_CD IS NOT NULL " ).append("\n"); 
		query.append("  #if(${s_more_than_amt} != '')" ).append("\n"); 
		query.append("  AND (INV_AMT / US_XCH_RT) > @[s_more_than_amt]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("GROUP BY MDL_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        #if(${s_ofc_cd} == '')" ).append("\n"); 
		query.append("         ,RHQ_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("         ,INV_OFC_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ,EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT RHQ_CD" ).append("\n"); 
		query.append("              ,INV_OFC_CD" ).append("\n"); 
		query.append("              ,MDL_CD" ).append("\n"); 
		query.append("              ,1 TP_CD" ).append("\n"); 
		query.append("              ,EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,CACO_CNT" ).append("\n"); 
		query.append("              ,CACO_USD_AMT" ).append("\n"); 
		query.append("              ,CAPO_CNT" ).append("\n"); 
		query.append("              ,CAPO_USD_AMT" ).append("\n"); 
		query.append("              ,POCA_CNT" ).append("\n"); 
		query.append("              ,POCA_USD_AMT" ).append("\n"); 
		query.append("              ,POCO_CNT" ).append("\n"); 
		query.append("              ,POCO_USD_AMT" ).append("\n"); 
		query.append("              ,COCA_CNT" ).append("\n"); 
		query.append("              ,COCA_USD_AMT" ).append("\n"); 
		query.append("              ,COPO_CNT" ).append("\n"); 
		query.append("              ,COPO_USD_AMT" ).append("\n"); 
		query.append("              ,CACA_CNT" ).append("\n"); 
		query.append("              ,CACA_USD_AMT" ).append("\n"); 
		query.append("              ,COCO_CNT" ).append("\n"); 
		query.append("              ,COCO_USD_AMT" ).append("\n"); 
		query.append("              ,POPO_CNT" ).append("\n"); 
		query.append("              ,POPO_USD_AMT" ).append("\n"); 
		query.append("              ,TOT_CNT" ).append("\n"); 
		query.append("              ,TOT_USD_AMT" ).append("\n"); 
		query.append("              ,RHQ_CD RHQ_ORD" ).append("\n"); 
		query.append("              ,INV_OFC_CD INV_OFC_ORD" ).append("\n"); 
		query.append("              ,MDL_CD MDL_ORD" ).append("\n"); 
		query.append("          FROM SRC " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Sub Total' RHQ_CD" ).append("\n"); 
		query.append("              ,'' INV_OFC_CD" ).append("\n"); 
		query.append("              ,'' MDL_CD" ).append("\n"); 
		query.append("              ,2 TP_CD" ).append("\n"); 
		query.append("              ,'' EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,SUM(CACO_CNT) CACO_CNT" ).append("\n"); 
		query.append("              ,SUM(CACO_USD_AMT) CACO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CAPO_CNT) CAPO_CNT" ).append("\n"); 
		query.append("              ,SUM(CAPO_USD_AMT) CAPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCA_CNT) POCA_CNT" ).append("\n"); 
		query.append("              ,SUM(POCA_USD_AMT) POCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCO_CNT) POCO_CNT" ).append("\n"); 
		query.append("              ,SUM(POCO_USD_AMT) POCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCA_CNT) COCA_CNT" ).append("\n"); 
		query.append("              ,SUM(COCA_USD_AMT) COCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COPO_CNT) COPO_CNT" ).append("\n"); 
		query.append("              ,SUM(COPO_USD_AMT) COPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CACA_CNT) CACA_CNT" ).append("\n"); 
		query.append("              ,SUM(CACA_USD_AMT) CACA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCO_CNT) COCO_CNT" ).append("\n"); 
		query.append("              ,SUM(COCO_USD_AMT) COCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POPO_CNT) POPO_CNT" ).append("\n"); 
		query.append("              ,SUM(POPO_USD_AMT) POPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(TOT_CNT) TOT_CNT" ).append("\n"); 
		query.append("              ,SUM(TOT_USD_AMT) TOT_USD_AMT" ).append("\n"); 
		query.append("              ,RHQ_CD RHQ_ORD" ).append("\n"); 
		query.append("              ,INV_OFC_CD INV_OFC_ORD" ).append("\n"); 
		query.append("              ,MDL_CD MDL_ORD" ).append("\n"); 
		query.append("          FROM SRC" ).append("\n"); 
		query.append("        GROUP BY RHQ_CD" ).append("\n"); 
		query.append("                ,INV_OFC_CD" ).append("\n"); 
		query.append("                ,MDL_CD     " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Grand Total' RHQ_CD" ).append("\n"); 
		query.append("              ,'' INV_OFC_CD" ).append("\n"); 
		query.append("              ,'' MDL_CD" ).append("\n"); 
		query.append("              ,3 TP_CD" ).append("\n"); 
		query.append("              ,EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,SUM(CACO_CNT) CACO_CNT" ).append("\n"); 
		query.append("              ,SUM(CACO_USD_AMT) CACO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CAPO_CNT) CAPO_CNT" ).append("\n"); 
		query.append("              ,SUM(CAPO_USD_AMT) CAPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCA_CNT) POCA_CNT" ).append("\n"); 
		query.append("              ,SUM(POCA_USD_AMT) POCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCO_CNT) POCO_CNT" ).append("\n"); 
		query.append("              ,SUM(POCO_USD_AMT) POCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCA_CNT) COCA_CNT" ).append("\n"); 
		query.append("              ,SUM(COCA_USD_AMT) COCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COPO_CNT) COPO_CNT" ).append("\n"); 
		query.append("              ,SUM(COPO_USD_AMT) COPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CACA_CNT) CACA_CNT" ).append("\n"); 
		query.append("              ,SUM(CACA_USD_AMT) CACA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCO_CNT) COCO_CNT" ).append("\n"); 
		query.append("              ,SUM(COCO_USD_AMT) COCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POPO_CNT) POPO_CNT" ).append("\n"); 
		query.append("              ,SUM(POPO_USD_AMT) POPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(TOT_CNT) TOT_CNT" ).append("\n"); 
		query.append("              ,SUM(TOT_USD_AMT) TOT_USD_AMT" ).append("\n"); 
		query.append("              ,'XXXXX' RHQ_ORD" ).append("\n"); 
		query.append("              ,'XXXXX' INV_OFC_ORD" ).append("\n"); 
		query.append("              ,'XXX' MDL_ORD" ).append("\n"); 
		query.append("          FROM SRC" ).append("\n"); 
		query.append("         GROUP BY EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'G.Total Sum' RHQ_CD" ).append("\n"); 
		query.append("              ,'' INV_OFC_CD" ).append("\n"); 
		query.append("              ,'' MDL_CD" ).append("\n"); 
		query.append("              ,4 TP_CD" ).append("\n"); 
		query.append("              ,'' EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("              ,SUM(CACO_CNT) CACO_CNT" ).append("\n"); 
		query.append("              ,SUM(CACO_USD_AMT) CACO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CAPO_CNT) CAPO_CNT" ).append("\n"); 
		query.append("              ,SUM(CAPO_USD_AMT) CAPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCA_CNT) POCA_CNT" ).append("\n"); 
		query.append("              ,SUM(POCA_USD_AMT) POCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POCO_CNT) POCO_CNT" ).append("\n"); 
		query.append("              ,SUM(POCO_USD_AMT) POCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCA_CNT) COCA_CNT" ).append("\n"); 
		query.append("              ,SUM(COCA_USD_AMT) COCA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COPO_CNT) COPO_CNT" ).append("\n"); 
		query.append("              ,SUM(COPO_USD_AMT) COPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CACA_CNT) CACA_CNT" ).append("\n"); 
		query.append("              ,SUM(CACA_USD_AMT) CACA_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(COCO_CNT) COCO_CNT" ).append("\n"); 
		query.append("              ,SUM(COCO_USD_AMT) COCO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(POPO_CNT) POPO_CNT" ).append("\n"); 
		query.append("              ,SUM(POPO_USD_AMT) POPO_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(TOT_CNT) TOT_CNT" ).append("\n"); 
		query.append("              ,SUM(TOT_USD_AMT) TOT_USD_AMT" ).append("\n"); 
		query.append("              ,'XXXXX' RHQ_ORD" ).append("\n"); 
		query.append("              ,'XXXXX' INV_OFC_ORD" ).append("\n"); 
		query.append("              ,'XXX' MDL_ORD" ).append("\n"); 
		query.append("          FROM SRC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RHQ_ORD, INV_OFC_ORD, MDL_ORD, TP_CD, EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  '' MDL_CD" ).append("\n"); 
		query.append(", '' RHQ_CD" ).append("\n"); 
		query.append(", '' INV_OFC_CD" ).append("\n"); 
		query.append(", '' TP_CD" ).append("\n"); 
		query.append(", '' EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append(", '' CACO_CNT" ).append("\n"); 
		query.append(", '' CACO_USD_AMT" ).append("\n"); 
		query.append(", '' CAPO_CNT" ).append("\n"); 
		query.append(", '' CAPO_USD_AMT" ).append("\n"); 
		query.append(", '' POCA_CNT" ).append("\n"); 
		query.append(", '' POCA_USD_AMT" ).append("\n"); 
		query.append(", '' POCO_CNT" ).append("\n"); 
		query.append(", '' POCO_USD_AMT" ).append("\n"); 
		query.append(", '' COCA_CNT" ).append("\n"); 
		query.append(", '' COCA_USD_AMT" ).append("\n"); 
		query.append(", '' COPO_CNT" ).append("\n"); 
		query.append(", '' COPO_USD_AMT" ).append("\n"); 
		query.append(", '' CACA_CNT" ).append("\n"); 
		query.append(", '' CACA_USD_AMT" ).append("\n"); 
		query.append(", '' COCO_CNT" ).append("\n"); 
		query.append(", '' COCO_USD_AMT" ).append("\n"); 
		query.append(", '' POPO_CNT" ).append("\n"); 
		query.append(", '' POPO_USD_AMT" ).append("\n"); 
		query.append(", '' TOT_CNT" ).append("\n"); 
		query.append(", '' TOT_USD_AMT" ).append("\n"); 
		query.append(", '' RHQ_ORD" ).append("\n"); 
		query.append(", '' MDL_ORD" ).append("\n"); 
		query.append(", '' S_RHQ_OFC_CD" ).append("\n"); 
		query.append(", '' S_OFC_CD" ).append("\n"); 
		query.append(", '' S_INV_CFM_FM_DT" ).append("\n"); 
		query.append(", '' S_INV_CFM_TO_DT" ).append("\n"); 
		query.append(", '' S_MDL_CD" ).append("\n"); 
		query.append(", '' S_BEFORE_STS_CD" ).append("\n"); 
		query.append(", '' S_AFTER_STS_CD" ).append("\n"); 
		query.append(", '' S_EAC_IF_FLG" ).append("\n"); 
		query.append(", '' S_MORE_THAN_AMT" ).append("\n"); 
		query.append(", '' S_EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}