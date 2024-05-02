/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchYearlyCostBudgetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class AccrualBatchExecuteResultDBDAOSearchYearlyCostBudgetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYearlyCostBudget
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchYearlyCostBudgetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchYearlyCostBudgetRSQL").append("\n"); 
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
		query.append("SELECT A.BSE_YR,          " ).append("\n"); 
		query.append("       C.RHQ_CD," ).append("\n"); 
		query.append("       A.CTRL_OFC_CD," ).append("\n"); 
		query.append("       B.COST_SRC_SYS_CD,     " ).append("\n"); 
		query.append("       A.COA_COST_SRC_CD," ).append("\n"); 
		query.append("       B.LGS_COST_FULL_NM, " ).append("\n"); 
		query.append("       A.ACCT_CD,         " ).append("\n"); 
		query.append("       A.TTL_USD_AMT,     " ).append("\n"); 
		query.append("       A.MON_BUD_USD_AMT, " ).append("\n"); 
		query.append("       A.MNL_FLG         " ).append("\n"); 
		query.append(" FROM LEA_YRY_COST_BUD A," ).append("\n"); 
		query.append("      LEA_LGS_COST B," ).append("\n"); 
		query.append("      (SELECT     *" ).append("\n"); 
		query.append("FROM  (SELECT " ).append("\n"); 
		query.append("             -- DECODE(L.OFC_CD, 'SELTOB', 'SHAAS', 'SELCOE','SHAAS', L.OFC_N3RD_LVL_CD ) as RHQ_CD" ).append("\n"); 
		query.append("             --, DECODE(L.OFC_CD, 'SELTOB', 'SELBB', 'SELCOE','SELBB', L.OFC_N5TH_LVL_CD ) as CONTROL_OFC" ).append("\n"); 
		query.append("               DECODE(L.OFC_CD, 'SELTBB', 'SHARC', 'SELOPE','SHARC', L.OFC_N3RD_LVL_CD ) as RHQ_CD" ).append("\n"); 
		query.append("             , DECODE(L.OFC_CD, 'SELTBB', 'SELSC', 'SELOPE','SELSC', L.OFC_N5TH_LVL_CD ) as CONTROL_OFC" ).append("\n"); 
		query.append("             , L.OFC_CD AS SUB_OFC_CD" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC) OFC_ORDER" ).append("\n"); 
		query.append("        FROM  COA_OFC_LVL L" ).append("\n"); 
		query.append("       WHERE  L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("         AND  L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("      ) X" ).append("\n"); 
		query.append("WHERE X.OFC_ORDER    = 1" ).append("\n"); 
		query.append("			) C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("  AND A.COA_COST_SRC_CD =  B.COA_COST_SRC_CD" ).append("\n"); 
		query.append("  AND A.CTRL_OFC_CD = C.SUB_OFC_CD" ).append("\n"); 
		query.append("#if (${rhq_cd} !='')" ).append("\n"); 
		query.append("  AND C.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C.RHQ_CD," ).append("\n"); 
		query.append("         A.CTRL_OFC_CD,     " ).append("\n"); 
		query.append("         A.COA_COST_SRC_CD" ).append("\n"); 

	}
}