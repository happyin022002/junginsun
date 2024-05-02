/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacRegRptDBDAOSearchOfcPerfRSQL.java
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

public class EacRegRptDBDAOSearchOfcPerfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Audit office 또는 Responsible Office별 실적 조회
	  * </pre>
	  */
	public EacRegRptDBDAOSearchOfcPerfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rnk_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_eac_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacRegRptDBDAOSearchOfcPerfRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[s_rnk_div_cd] = 'C' THEN RANK () OVER (ORDER BY EAC_CNT DESC)" ).append("\n"); 
		query.append("            WHEN @[s_rnk_div_cd] = 'A' THEN RANK () OVER (ORDER BY EAC_AMT DESC)" ).append("\n"); 
		query.append("       END AS RNK" ).append("\n"); 
		query.append("      ,RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,EAC_CNT" ).append("\n"); 
		query.append("      ,EAC_AMT" ).append("\n"); 
		query.append("      ,TPB_AMT" ).append("\n"); 
		query.append("      ,PROC_CNT" ).append("\n"); 
		query.append("      ,PROC_AMT" ).append("\n"); 
		query.append("      ,PND_CNT" ).append("\n"); 
		query.append("      ,PND_AMT" ).append("\n"); 
		query.append("      ,CMPL_CNT" ).append("\n"); 
		query.append("      ,CMPL_AMT" ).append("\n"); 
		query.append("      ,STL_CNT" ).append("\n"); 
		query.append("      ,STL_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT CASE WHEN OFC_CD = 'SELADG' THEN 'SELADG'" ).append("\n"); 
		query.append("                ELSE RHQ_OFC_CD" ).append("\n"); 
		query.append("           END AS RHQ_OFC_CD" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,COUNT(1) AS EAC_CNT" ).append("\n"); 
		query.append("          ,SUM(EAC_AMT) AS EAC_AMT" ).append("\n"); 
		query.append("          ,SUM(TPB_AMT)  AS TPB_AMT      " ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'P' THEN 1 ELSE 0 END)) AS PROC_CNT --Processing Count" ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'P' THEN EAC_AMT ELSE 0 END)) AS PROC_AMT --Processing Amount" ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'H' THEN 1 ELSE 0 END)) AS PND_CNT  --Pending Count" ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'H' THEN EAC_AMT ELSE 0 END)) AS PND_AMT  --Pending Amount" ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'C' THEN 1 ELSE 0 END)) AS CMPL_CNT --Completed Count" ).append("\n"); 
		query.append("          ,SUM((CASE WHEN EAC_CMPL_CD = 'C' THEN EAC_AMT ELSE 0 END)) AS CMPL_AMT --Completed Amount" ).append("\n"); 
		query.append("          ,SUM(STL_CNT) AS STL_CNT" ).append("\n"); 
		query.append("          ,SUM(STL_AMT) AS STL_AMT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(" ).append("\n"); 
		query.append("                       CASE WHEN @[s_ofc_tp_cd] = 'A' THEN AUDR_OFC_CD" ).append("\n"); 
		query.append("                            WHEN @[s_ofc_tp_cd] = 'R' THEN RESPB_OFC_CD" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                       ) RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,CASE WHEN @[s_ofc_tp_cd] = 'A' THEN AUDR_OFC_CD" ).append("\n"); 
		query.append("                    WHEN @[s_ofc_tp_cd] = 'R' THEN RESPB_OFC_CD" ).append("\n"); 
		query.append("               END OFC_CD" ).append("\n"); 
		query.append("              ,EAC_CMPL_CD" ).append("\n"); 
		query.append("              ,NVL(INV_AUD_USD_AMT,0) EAC_AMT" ).append("\n"); 
		query.append("              ,(SELECT SUM(TPB_GET_USD_AMT_FNC(X.CFM_AMT, X.CFM_CURR_CD,TPB_GET_LCL_DATE_FNC(X.CFM_DT,X.CFM_OFC_CD)))" ).append("\n"); 
		query.append("                  FROM TPB_OTS_DTL X" ).append("\n"); 
		query.append("                 WHERE X.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("               ) TPB_AMT" ).append("\n"); 
		query.append("              ,(CASE WHEN NVL(STL_AMT,0) <> 0 THEN 1 ELSE 0 END) STL_CNT" ).append("\n"); 
		query.append("              ,NVL(STL_AMT,0) STL_AMT" ).append("\n"); 
		query.append("          FROM EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("              ,EAS_EXPN_AUD_CS_N3RD_PTY B" ).append("\n"); 
		query.append("         WHERE A.EAC_NO = B.EAC_NO(+)" ).append("\n"); 
		query.append("           AND A.EAC_YRMON BETWEEN replace(@[s_eac_yrmon_fm],'-','') AND replace(@[s_eac_yrmon_to],'-','') -- Audit Month 필수" ).append("\n"); 
		query.append("--           AND A.EAC_STS_CD IN ('IS', 'AC', 'RC', 'HC') 요청에의한 코드변경" ).append("\n"); 
		query.append("           AND A.EAC_STS_CD IN ('HC')" ).append("\n"); 
		query.append("           #if (${s_eac_expn_tp_cd} != '')" ).append("\n"); 
		query.append("           AND A.EAC_EXPN_TP_CD = @[s_eac_expn_tp_cd] -- Expense Type" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_eac_tp_cd} != '')" ).append("\n"); 
		query.append("           AND A.EAC_TP_CD = @[s_eac_tp_cd] -- EAC Type" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_eac_rsn_cd} != '')" ).append("\n"); 
		query.append("           AND A.EAC_RSN_CD = @[s_eac_rsn_cd] -- Action Type" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       #if (${s_rhq_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND CASE WHEN OFC_CD = 'SELADG' THEN 'SELADG'" ).append("\n"); 
		query.append("                ELSE RHQ_OFC_CD" ).append("\n"); 
		query.append("           END = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND OFC_CD     = @[s_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    GROUP BY RHQ_OFC_CD" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CASE WHEN @[s_rnk_div_cd] = 'C' THEN RANK () OVER (ORDER BY EAC_CNT DESC)" ).append("\n"); 
		query.append("            WHEN @[s_rnk_div_cd] = 'A' THEN RANK () OVER (ORDER BY EAC_AMT DESC)" ).append("\n"); 
		query.append("         END" ).append("\n"); 

	}
}