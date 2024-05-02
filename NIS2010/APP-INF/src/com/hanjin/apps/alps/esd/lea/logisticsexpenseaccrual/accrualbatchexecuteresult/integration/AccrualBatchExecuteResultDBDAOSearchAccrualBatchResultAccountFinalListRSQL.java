/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccrualBatchResultAccountFinalList
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalListRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT   S.EXE_YRMON" ).append("\n"); 
		query.append("      ,  S.REV_YRMON" ).append("\n"); 
		query.append("      ,  S.ACCL_AUTO_CD" ).append("\n"); 
		query.append("      ,  S.ACCT_CD" ).append("\n"); 
		query.append("      ,  A.ACCT_CD_NM" ).append("\n"); 
		query.append("      ,  SUM(S.ESTM_COST_AMT)    AS ESTM_COST_AMT" ).append("\n"); 
		query.append("      ,  SUM(S.PRE_ACT_COST_AMT)   AS PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("      ,  SUM(S.PST_ACT_COST_AMT)   AS PST_ACT_COST_AMT" ).append("\n"); 
		query.append("      ,  CASE  WHEN S.ACCL_AUTO_CD = 'A' THEN SUM(S.PST_ACT_COST_AMT) - SUM(PRE_ACT_COST_AMT)" ).append("\n"); 
		query.append("               ELSE  0" ).append("\n"); 
		query.append("         END   AS DIFF_ACT_COST_AMT" ).append("\n"); 
		query.append("      ,  CASE  WHEN S.ACCL_AUTO_CD = 'A' THEN DECODE(SUM(S.ESTM_COST_AMT),0,0,SUM(S.PST_ACT_COST_AMT)/SUM(S.ESTM_COST_AMT)*100)" ).append("\n"); 
		query.append("               ELSE  0" ).append("\n"); 
		query.append("         END   AS ACT_COST_RATIO" ).append("\n"); 
		query.append("      ,  SUM(S.ADJ_ACCL_COST_AMT)          AS ACCL_COST_AMT" ).append("\n"); 
		query.append("      ,  CASE  WHEN S.ACCL_AUTO_CD = 'A' THEN SUM(S.PST_ACT_COST_AMT) + SUM(S.ADJ_ACCL_COST_AMT)" ).append("\n"); 
		query.append("               ELSE  SUM(S.PRE_ACT_COST_AMT) + SUM(S.ADJ_ACCL_COST_AMT)" ).append("\n"); 
		query.append("         END   AS CONFIRMED_COST_AMT" ).append("\n"); 
		query.append("      ,  SUM(S.PST_ACT_COST_AMT) + SUM(S.ADJ_ACCL_COST_AMT) - SUM(S.ESTM_COST_AMT)    AS  DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM    ( SELECT       DISTINCT(ACCT_CD)         ACCT_CD" ).append("\n"); 
		query.append("                  ,    ACCT_NM                   ACCT_CD_NM" ).append("\n"); 
		query.append("                  ,    ACCL_AUTO_CD" ).append("\n"); 
		query.append("          FROM        LEA_LGS_COST" ).append("\n"); 
		query.append("          WHERE        ACCL_AUTO_CD              IS NOT NULL" ).append("\n"); 
		query.append("          AND          DELT_FLG                  = 'N'" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT       DISTINCT(OTR_CRR_ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                  ,    OTR_CRR_ACCT_NM           ACCT_CD_NM" ).append("\n"); 
		query.append("                  ,    'M'                       ACCL_AUTO_CD" ).append("\n"); 
		query.append("          FROM        LEA_LGS_COST" ).append("\n"); 
		query.append("          WHERE        ACCL_AUTO_CD              IS NOT NULL" ).append("\n"); 
		query.append("          AND         OTR_CRR_ACCT_CD           IS NOT NULL" ).append("\n"); 
		query.append("          AND          DELT_FLG                  = 'N'" ).append("\n"); 
		query.append("        )                               A" ).append("\n"); 
		query.append("    ,   LEA_ACCL_COST_SMRY              S" ).append("\n"); 
		query.append("WHERE   A.ACCT_CD                     = S.ACCT_CD" ).append("\n"); 
		query.append("AND     A.ACCL_AUTO_CD                = S.ACCL_AUTO_CD" ).append("\n"); 
		query.append("AND    ( 1=2" ).append("\n"); 
		query.append("  #if (${f_acct_type_a} == '1')" ).append("\n"); 
		query.append("        OR A.ACCL_AUTO_CD     = 'A'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${f_acct_type_m} == '1')" ).append("\n"); 
		query.append("    OR A.ACCL_AUTO_CD     = 'M'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("AND     S.REV_YRMON                     >= REPLACE(@[frm_rev_yrmon_from],'-') " ).append("\n"); 
		query.append("AND     S.REV_YRMON                     <= REPLACE(@[frm_rev_yrmon_to],'-')" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("GROUP BY  S.EXE_YRMON" ).append("\n"); 
		query.append("      ,   S.REV_YRMON" ).append("\n"); 
		query.append("      ,   S.ACCT_CD                      " ).append("\n"); 
		query.append("      ,   S.ACCL_AUTO_CD   " ).append("\n"); 
		query.append("      ,   A.ACCT_CD_NM " ).append("\n"); 
		query.append("ORDER BY  S.EXE_YRMON" ).append("\n"); 
		query.append("    ,     S.REV_YRMON" ).append("\n"); 
		query.append("    ,     S.ACCL_AUTO_CD" ).append("\n"); 
		query.append("    ,     S.ACCT_CD" ).append("\n"); 
		query.append("    ,     A.ACCT_CD_NM" ).append("\n"); 

	}
}