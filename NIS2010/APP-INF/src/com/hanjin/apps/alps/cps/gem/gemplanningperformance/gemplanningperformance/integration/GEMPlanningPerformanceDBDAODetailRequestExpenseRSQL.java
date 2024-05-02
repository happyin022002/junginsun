/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAODetailRequestExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.11 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAODetailRequestExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019_02에 관련한 VO
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAODetailRequestExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAODetailRequestExpenseRSQL").append("\n"); 
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
		query.append("SELECT '' OFC_EXPN" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' RQST_UT_VAL" ).append("\n"); 
		query.append(",'' YRMON" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' OFC_CO_DIV_CD" ).append("\n"); 
		query.append(",'' RHQ_OFC_CD" ).append("\n"); 
		query.append(",'' RGN_OFC_FLG" ).append("\n"); 
		query.append(",'' SLS_OFC_FLG" ).append("\n"); 
		query.append(",'' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' EXPN_NAME" ).append("\n"); 
		query.append(",'' TIC_CD" ).append("\n"); 
		query.append(",'' LVL1_NAME" ).append("\n"); 
		query.append(",'' LVL2_NAME" ).append("\n"); 
		query.append(",'' EX_RATE_PLAN_PRE" ).append("\n"); 
		query.append(",'' EX_RATE_AVG" ).append("\n"); 
		query.append(",'' EX_RATE_PLAN" ).append("\n"); 
		query.append(",'' PERF_USD_YEAR1" ).append("\n"); 
		query.append(",'' PERF_USD_AMT1" ).append("\n"); 
		query.append(",'' PERF_USD_YEAR2" ).append("\n"); 
		query.append(",'' PERF_USD_AMT2" ).append("\n"); 
		query.append(",'' PERF_USD_YEAR3" ).append("\n"); 
		query.append(",'' PERF_USD_AMT3" ).append("\n"); 
		query.append(",'' ASSI_USD_YEAR1" ).append("\n"); 
		query.append(",'' ASSI_USD_AMT1" ).append("\n"); 
		query.append(",'' ASSI_USD_YEAR2" ).append("\n"); 
		query.append(",'' ASSI_USD_AMT2" ).append("\n"); 
		query.append(",'' PLAN_USD_COM_AMT" ).append("\n"); 
		query.append(",'' PLAN_USD_TIC_AMT" ).append("\n"); 
		query.append(",'' PLAN_USD_RHQ_AMT" ).append("\n"); 
		query.append(",'' PLAN_USD_OFC_AMT" ).append("\n"); 
		query.append(",'' PLAN_LCL_COM_AMT" ).append("\n"); 
		query.append(",'' PLAN_LCL_TIC_AMT" ).append("\n"); 
		query.append(",'' PLAN_LCL_RHQ_AMT" ).append("\n"); 
		query.append(",'' PLAN_LCL_OFC_AMT" ).append("\n"); 
		query.append(",'' PERF_LCL_YEAR1" ).append("\n"); 
		query.append(",'' PERF_LCL_EST_AMT" ).append("\n"); 
		query.append(",'' PERF_LCL_PFM_AMT" ).append("\n"); 
		query.append(",'' PERF_LCL_PLAN_AMT" ).append("\n"); 
		query.append(",'' PERF_LCL_YEAR2" ).append("\n"); 
		query.append(",'' PERF_LCL_AMT2" ).append("\n"); 
		query.append(",'' PERF_LCL_YEAR3" ).append("\n"); 
		query.append(",'' PERF_LCL_AMT3" ).append("\n"); 
		query.append(",'' ASSI_LCL_YEAR1" ).append("\n"); 
		query.append(",'' ASSI_LCL_AMT1" ).append("\n"); 
		query.append(",'' ASSI_LCL_YEAR2" ).append("\n"); 
		query.append(",'' ASSI_LCL_AMT2" ).append("\n"); 
		query.append(",'' ASSI_LCL_YEAR3" ).append("\n"); 
		query.append(",'' ASSI_LCL_AMT3" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}