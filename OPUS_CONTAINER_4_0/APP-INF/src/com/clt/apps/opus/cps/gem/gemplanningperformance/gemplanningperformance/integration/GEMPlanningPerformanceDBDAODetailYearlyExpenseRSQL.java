/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAODetailYearlyExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.02 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAODetailYearlyExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019 화면에서 DownExcel버튼 클릭시 Yearly Expense를 조회하는 VO
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAODetailYearlyExpenseRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' PLN_YRMON" ).append("\n"); 
		query.append(",'' GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append(",'' LVL1_CODE" ).append("\n"); 
		query.append(",'' LVL1_NAME" ).append("\n"); 
		query.append(",'' LVL2_CODE" ).append("\n"); 
		query.append(",'' LVL2_NAME" ).append("\n"); 
		query.append(",'' LVL4_CODE" ).append("\n"); 
		query.append(",'' LVL4_NAME" ).append("\n"); 
		query.append(",'' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",'' GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",'' LVL4_TIC" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' RHQ" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' RQST_UT_VAL" ).append("\n"); 
		query.append(",'' SALY_FLG" ).append("\n"); 
		query.append(",'' OFC_CO_DIV_CD" ).append("\n"); 
		query.append(",'' JAN" ).append("\n"); 
		query.append(",'' FEB" ).append("\n"); 
		query.append(",'' MAR" ).append("\n"); 
		query.append(",'' APR" ).append("\n"); 
		query.append(",'' MAY" ).append("\n"); 
		query.append(",'' JUN" ).append("\n"); 
		query.append(",'' JUL" ).append("\n"); 
		query.append(",'' AUG" ).append("\n"); 
		query.append(",'' SEP" ).append("\n"); 
		query.append(",'' OCT" ).append("\n"); 
		query.append(",'' NOV" ).append("\n"); 
		query.append(",'' DEC" ).append("\n"); 
		query.append(",'' INT_TTL" ).append("\n"); 
		query.append(",'' ADD_TTL" ).append("\n"); 
		query.append(",'' TRN_TTL" ).append("\n"); 
		query.append(",'' GRD_TTL" ).append("\n"); 
		query.append(",'' CAL_BASIS" ).append("\n"); 
		query.append(",'' APRO_OPIN_RMK" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAODetailYearlyExpenseRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}