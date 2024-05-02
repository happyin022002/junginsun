/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchMonthlyCostAccrualVerificationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchMonthlyCostAccrualVerificationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Monthly Accrual Verification
	  * </pre>
	  */
	public StatementCommonDBDAOSearchMonthlyCostAccrualVerificationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfitctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchMonthlyCostAccrualVerificationListRSQL").append("\n"); 
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
		query.append("SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("     , A.PFITCTR_CD" ).append("\n"); 
		query.append("     , A.GL_ACCT_NO" ).append("\n"); 
		query.append("     , A.ACT_YRMON" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , SUM(A.ACCL_DOC_AMT) AS ACCL_DOC_AMT" ).append("\n"); 
		query.append("     , SUM(A.ACCL_LOCL_AMT) AS ACCL_LOCL_AMT" ).append("\n"); 
		query.append("     , SUM(A.OPR_DOC_AMT) AS OPR_DOC_AMT" ).append("\n"); 
		query.append("     , SUM(A.OPR_LOCL_AMT) AS OPR_LOCL_AMT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("        SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("             , A.PFITCTR_CD" ).append("\n"); 
		query.append("             , A.GL_ACCT_NO" ).append("\n"); 
		query.append("             , A.ACT_YRMON" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , SUM(A.DOC_AMT) AS ACCL_DOC_AMT" ).append("\n"); 
		query.append("             , SUM(A.LOCL_AMT) AS ACCL_LOCL_AMT" ).append("\n"); 
		query.append("             , 0 AS OPR_DOC_AMT" ).append("\n"); 
		query.append("             , 0 AS OPR_LOCL_AMT" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("                     , CASE WHEN A.TRD_CD IS NOT NULL THEN " ).append("\n"); 
		query.append("                                 NVL(A.TMP_TRD_MODI_COST_CTR_CD, NVL(A.TMP_SVC_MODI_COST_CTR_CD, NVL(DECODE(A.TMP_TGT_CD, 'ZH', A.TMP_ORG_MODI_COST_CTR_CD, A.TMP_TGT_CD), 'A106') ))" ).append("\n"); 
		query.append("                            ELSE NVL(A.TMP_SVC_MODI_COST_CTR_CD, NVL(DECODE(A.TMP_TGT_CD, 'ZH', A.TMP_ORG_MODI_COST_CTR_CD, A.TMP_TGT_CD), 'A106'))" ).append("\n"); 
		query.append("                       END AS PFITCTR_CD" ).append("\n"); 
		query.append("                     , A.GL_ACCT_NO" ).append("\n"); 
		query.append("                     , A.ACT_YRMON" ).append("\n"); 
		query.append("                     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , A.DOC_AMT" ).append("\n"); 
		query.append("                     , A.LOCL_AMT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT INFO.EXE_YRMON" ).append("\n"); 
		query.append("                             , INFO.TRD_CD" ).append("\n"); 
		query.append("                             , MA.MODI_ACCT_CD AS GL_ACCT_NO" ).append("\n"); 
		query.append("                             , SUBSTR(INFO.ACT_DT, 1, 6) AS ACT_YRMON" ).append("\n"); 
		query.append("                             , INFO.LOCL_CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("                             , NVL(INFO.ACCL_AMT,0) AS DOC_AMT" ).append("\n"); 
		query.append("                             , DECODE(INFO.LOCL_CURR_CD, 'JPY', NVL(INFO.ACCL_AMT,0), ROUND(NVL(INFO.ACCL_AMT,0) * SAC_GET_GL_XCH_RT_FNC('1', INFO.ACT_DT, INFO.LOCL_CURR_CD, 'JPY'), 0)) AS LOCL_AMT" ).append("\n"); 
		query.append("                             , ACCLADM.SAC_BRG_IF_PKG.GET_STMT_CD_CONV('GL ACCT OF PROFIT CENTER', MA.MODI_ACCT_CD) AS TMP_TGT_CD" ).append("\n"); 
		query.append("                             , (SELECT DECODE(VS.VSL_SLAN_CD, 'COM', NULL, 'CNT',NULL, VS.MODI_COST_CTR_CD) " ).append("\n"); 
		query.append("                                  FROM MDM_VSL_SVC_LANE VS " ).append("\n"); 
		query.append("                                 WHERE VS.VSL_SLAN_CD = INFO.SLAN_CD) AS TMP_SVC_MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                             , (SELECT ORG.MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                  FROM MDM_ORGANIZATION ORG " ).append("\n"); 
		query.append("                                 WHERE ORG.OFC_CD = NVL(INFO.CTRL_OFC_CD, INFO.ACT_PLC_CD)) AS TMP_ORG_MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                             , (SELECT MT.MODI_COST_CTR_CD " ).append("\n"); 
		query.append("                                  FROM MDM_TRADE MT " ).append("\n"); 
		query.append("                                 WHERE MT.TRD_CD = INFO.TRD_CD AND ROWNUM = 1 ) AS TMP_TRD_MODI_COST_CTR_CD" ).append("\n"); 
		query.append("                          FROM SAC_COST_ACCL_INFO INFO" ).append("\n"); 
		query.append("                             , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("                         WHERE INFO.ACCT_CD             = MA.ACCT_CD(+)" ).append("\n"); 
		query.append("                           AND INFO.EXE_YRMON           = REPLACE(@[accl_yrmon],'-','')      --Cond accrual month" ).append("\n"); 
		query.append("                           AND INFO.ACT_DT              <= TO_CHAR(LAST_DAY(TO_DATE(REPLACE(@[accl_yrmon],'-',''),'YYYYMM')),'YYYYMMDD') --Cond accrual month last day" ).append("\n"); 
		query.append("                           AND NVL(INFO.ACCL_AMT, 0)    <> 0" ).append("\n"); 
		query.append("                           AND NVL(INFO.ACCL_FLG, 'Y')  = 'Y' " ).append("\n"); 
		query.append("                           #if( ${gl_acct_no} !='')" ).append("\n"); 
		query.append("                           AND MA.MODI_ACCT_CD          = @[gl_acct_no] --Cond Sakura Account" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            #if( ${pfitctr_cd} !='')" ).append("\n"); 
		query.append("            AND A.PFITCTR_CD  LIKE '%'||@[pfitctr_cd]||'%' --Cond profit center" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          GROUP BY A.EXE_YRMON" ).append("\n"); 
		query.append("             , A.PFITCTR_CD" ).append("\n"); 
		query.append("             , A.GL_ACCT_NO" ).append("\n"); 
		query.append("             , A.ACT_YRMON" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("        SELECT SUBSTR(ACCL.PST_DT, 1, 6) AS EXE_YRMON" ).append("\n"); 
		query.append("             , ACCL.PFITCTR_CD" ).append("\n"); 
		query.append("             , ACCL.GL_ACCT_NO" ).append("\n"); 
		query.append("             , SUBSTR(ACCL.ACT_DT, 1, 6) AS ACT_YRMON" ).append("\n"); 
		query.append("             , ACCL.CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             , 0 AS ACCL_DOC_AMT" ).append("\n"); 
		query.append("             , 0 AS ACCL_LOCL_AMT" ).append("\n"); 
		query.append("             , SUM(DECODE(ACCL.PST_KEY_CD, '40', ACCL.DOC_AMT, ACCL.DOC_AMT * (-1))) AS OPR_DOC_AMT" ).append("\n"); 
		query.append("             , SUM(DECODE(ACCL.PST_KEY_CD, '40', NVL(ACCL.LOCL_AMT, ACCL.DOC_AMT), NVL(ACCL.LOCL_AMT, ACCL.DOC_AMT) * (-1))) AS OPR_LOCL_AMT" ).append("\n"); 
		query.append("          FROM SAC_COST_ACCL_IF ACCL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ACCL.PST_DT      = TO_CHAR(LAST_DAY(TO_DATE(REPLACE(@[accl_yrmon],'-',''),'YYYYMM')),'YYYYMMDD') --Cond accrual month last day" ).append("\n"); 
		query.append("           AND ACCL.PST_KEY_CD  IN ('40', '50')     " ).append("\n"); 
		query.append("           #if( ${pfitctr_cd} !='')" ).append("\n"); 
		query.append("           AND ACCL.PFITCTR_CD  LIKE '%'||@[pfitctr_cd]||'%' --Cond profit center" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${gl_acct_no} !='')" ).append("\n"); 
		query.append("           AND ACCL.GL_ACCT_NO  = @[gl_acct_no] --Cond Sakura Account" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         GROUP BY SUBSTR(ACCL.PST_DT, 1, 6)" ).append("\n"); 
		query.append("             , ACCL.PFITCTR_CD" ).append("\n"); 
		query.append("             , ACCL.GL_ACCT_NO" ).append("\n"); 
		query.append("             , SUBSTR(ACCL.ACT_DT, 1, 6)" ).append("\n"); 
		query.append("             , ACCL.CURR_CD   " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" GROUP BY A.EXE_YRMON" ).append("\n"); 
		query.append("     , A.PFITCTR_CD" ).append("\n"); 
		query.append("     , A.GL_ACCT_NO" ).append("\n"); 
		query.append("     , A.ACT_YRMON" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append(" ORDER BY A.EXE_YRMON" ).append("\n"); 
		query.append("     , A.PFITCTR_CD" ).append("\n"); 
		query.append("     , A.GL_ACCT_NO" ).append("\n"); 
		query.append("     , A.ACT_YRMON" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD " ).append("\n"); 

	}
}