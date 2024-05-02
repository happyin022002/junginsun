/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAODetailRequestExpenseRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.17 최정미
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

public class GEMPlanningPerformanceDBDAODetailRequestExpenseRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019화면의 Request Expense의  Target이 Detail RQST NO인 VO를 생성
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAODetailRequestExpenseRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAODetailRequestExpenseRqstNoRSQL").append("\n"); 
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
		query.append("SELECT '' GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",'' GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",'' GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",'' OFC_STS" ).append("\n"); 
		query.append(",'' RHQLBU_STS" ).append("\n"); 
		query.append(",'' TIC_STS" ).append("\n"); 
		query.append(",'' COM_STS" ).append("\n"); 
		query.append(",'' RHQ_OFC_CD" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' RQST_UT_VAL" ).append("\n"); 
		query.append(",'' EXPN_ABBR_NM" ).append("\n"); 
		query.append(",'' TIC_CD" ).append("\n"); 
		query.append(",'' JAN_AMT" ).append("\n"); 
		query.append(",'' FEB_AMT" ).append("\n"); 
		query.append(",'' MAR_AMT" ).append("\n"); 
		query.append(",'' APR_AMT" ).append("\n"); 
		query.append(",'' MAY_AMT" ).append("\n"); 
		query.append(",'' JUN_AMT" ).append("\n"); 
		query.append(",'' JUL_AMT" ).append("\n"); 
		query.append(",'' AUG_AMT" ).append("\n"); 
		query.append(",'' SEP_AMT" ).append("\n"); 
		query.append(",'' OCT_AMT" ).append("\n"); 
		query.append(",'' NOV_AMT" ).append("\n"); 
		query.append(",'' DEC_AMT" ).append("\n"); 
		query.append(",'' OFC_TOTAL" ).append("\n"); 
		query.append(",'' RHQLBU_TOTAL" ).append("\n"); 
		query.append(",'' TIC_TOTAL" ).append("\n"); 
		query.append(",'' COM_TOTAL" ).append("\n"); 
		query.append(",'' GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",'' GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",'' RQST_OPIN_RMK" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}