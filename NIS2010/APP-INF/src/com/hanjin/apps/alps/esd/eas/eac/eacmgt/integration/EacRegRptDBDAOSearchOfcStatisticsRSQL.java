/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacRegRptDBDAOSearchOfcStatisticsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.08.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacRegRptDBDAOSearchOfcStatisticsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별 비용심사 실적 조회
	  * </pre>
	  */
	public EacRegRptDBDAOSearchOfcStatisticsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_eac_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cal_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_yrmon_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacRegRptDBDAOSearchOfcStatisticsRSQL").append("\n"); 
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
		query.append("SELECT AUDR_OFC_CD" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'VU' THEN 1 ELSE 0 END)) AS M_BIL_UMCH_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'VU' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_BIL_UMCH_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'RD' THEN 1 ELSE 0 END)) AS M_RT_DIS_UMCH_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'RD' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_RT_DIS_UMCH_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'DB' THEN 1 ELSE 0 END)) AS M_DBL_BIL_UMCH_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'DB' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_DBL_BIL_UMCH_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'NH' THEN 1 ELSE 0 END)) AS M_NOT_ACCT_UMCH_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'NH' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_NOT_ACCT_UMCH_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'LE' THEN 1 ELSE 0 END)) AS M_LACK_EVID_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'LE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_LACK_EVID_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'MO' THEN 1 ELSE 0 END)) AS M_OTR_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' AND EAC_BIL_TP_CD = 'MO' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_OTR_AMT          " ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' THEN 1 ELSE 0 END)) AS M_SUB_TOT_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'M' THEN INV_AUD_USD_AMT ELSE 0 END)) AS M_SUB_TOT_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'BE' THEN 1 ELSE 0 END)) AS I_BKG_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'BE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_BKG_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'WE' THEN 1 ELSE 0 END)) AS I_WRK_ORD_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'WE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_WRK_ORD_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'OR' THEN 1 ELSE 0 END)) AS I_OP_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'OR' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_OP_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'CE' THEN 1 ELSE 0 END)) AS I_CTRT_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'CE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_CTRT_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'SE' THEN 1 ELSE 0 END)) AS I_SYS_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'SE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_SYS_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'OE' THEN 1 ELSE 0 END)) AS I_OTR_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' AND EAC_BIL_TP_CD = 'OE' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_OTR_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' THEN 1 ELSE 0 END)) AS I_SUB_TOT_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'I' THEN INV_AUD_USD_AMT ELSE 0 END)) AS I_SUB_TOT_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'T' THEN 1 ELSE 0 END)) AS MIS_TPB_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD = 'T' THEN INV_AUD_USD_AMT ELSE 0 END)) AS MIS_TPB_AMT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD IN ('M', 'I', 'T') THEN 1 ELSE 0 END)) AS TOT_CNT" ).append("\n"); 
		query.append("      ,SUM((CASE WHEN EAC_TP_CD IN ('M', 'I', 'T') THEN INV_AUD_USD_AMT ELSE 0 END)) AS TOT_AMT" ).append("\n"); 
		query.append(" FROM      " ).append("\n"); 
		query.append("(    " ).append("\n"); 
		query.append("    SELECT CASE WHEN @[s_ofc_tp_cd] = 'A' THEN AUDR_OFC_CD" ).append("\n"); 
		query.append("                WHEN @[s_ofc_tp_cd] = 'K' THEN KPI_OFC_CD" ).append("\n"); 
		query.append("           END AUDR_OFC_CD" ).append("\n"); 
		query.append("          ,EAC_TP_CD" ).append("\n"); 
		query.append("          ,EAC_BIL_TP_CD" ).append("\n"); 
		query.append("          ,CASE WHEN @[s_cal_val] = 'I' THEN INV_AUD_USD_AMT" ).append("\n"); 
		query.append("                WHEN @[s_cal_val] = 'U' THEN ROUND(INV_AUD_USD_AMT)" ).append("\n"); 
		query.append("                WHEN @[s_cal_val] = 'T' THEN TRUNC(INV_AUD_USD_AMT)            " ).append("\n"); 
		query.append("           END INV_AUD_USD_AMT" ).append("\n"); 
		query.append("      FROM EAS_EXPN_AUD_CS_MGMT" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("--       AND EAC_STS_CD IN ('IS', 'AC', 'RC', 'HC') 요청에 의한 코드 변경" ).append("\n"); 
		query.append("       AND EAC_STS_CD IN ('HC')" ).append("\n"); 
		query.append("       #if (${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("         #if (${s_rhq_ofc_cd} == 'SELADG')" ).append("\n"); 
		query.append("         AND AUDR_OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("         AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(AUDR_OFC_CD) = @[s_rhq_ofc_cd] -- RHQ 필수" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("         #if (${s_ofc_tp_cd} == 'A')" ).append("\n"); 
		query.append("         AND AUDR_OFC_CD = @[s_ofc_cd] -- Audit Office" ).append("\n"); 
		query.append("         #elseif (${s_ofc_tp_cd} == 'K')" ).append("\n"); 
		query.append("         AND KPI_OFC_CD = @[s_ofc_cd] -- Audit Office" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AND EAC_YRMON BETWEEN replace(@[s_eac_yrmon_fm],'-','') AND replace(@[s_eac_yrmon_to],'-','') -- Audit Month 필수" ).append("\n"); 
		query.append("       #if (${s_eac_tp_cd} != '') " ).append("\n"); 
		query.append("       AND EAC_TP_CD = @[s_eac_tp_cd] -- EAC Type" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${s_eac_apro_tp_cd} != '') " ).append("\n"); 
		query.append("       AND EAC_APRO_TP_CD = @[s_eac_apro_tp_cd] -- Audit Type" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" GROUP BY AUDR_OFC_CD" ).append("\n"); 

	}
}