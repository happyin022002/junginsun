/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VODAOPlanningStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.13 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOPlanningStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PlanningStatus VO
	  * </pre>
	  */
	public VODAOPlanningStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo").append("\n"); 
		query.append("FileName : VODAOPlanningStatusRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",'' GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",'' FM_GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' TO_GEN_EXPN_CD" ).append("\n"); 
		query.append(",'' FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",'' FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",'' TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",'' TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",'' FM_OFC_CD" ).append("\n"); 
		query.append(",'' TO_OFC_CD" ).append("\n"); 
		query.append(",'' RQST_OFC_CD" ).append("\n"); 
		query.append(",'' FM_RQ_AMT" ).append("\n"); 
		query.append(",'' TO_RQ_AMT" ).append("\n"); 
		query.append(",'' FM_AD_AMT" ).append("\n"); 
		query.append(",'' TO_AD_AMT" ).append("\n"); 
		query.append(",'' CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",'' CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",'' CRNT_GEN_EXPN_APSTS_CD_RJ" ).append("\n"); 
		query.append(",'' CRNT_GEN_EXPN_APSTS_CD_AP" ).append("\n"); 
		query.append(",'' AP1" ).append("\n"); 
		query.append(",'' AP2" ).append("\n"); 
		query.append(",'' AP3" ).append("\n"); 
		query.append(",'' AP4" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append(",'' GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append(",'' FM_LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' TO_LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' FM_UT_VAL" ).append("\n"); 
		query.append(",'' TO_UT_VAL" ).append("\n"); 
		query.append(",'' FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",'' FM_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",'' FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",'' TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",'' TO_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",'' TO_USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' FM_ENG_ABBR_NM" ).append("\n"); 
		query.append(",'' TO_ENG_ABBR_NM" ).append("\n"); 
		query.append(",'' FM_KRN_ABBR_NM" ).append("\n"); 
		query.append(",'' TO_KRN_ABBR_NM" ).append("\n"); 
		query.append(",'' RQST_OPIN_RMK" ).append("\n"); 
		query.append(",'' ITM_UPD_DT" ).append("\n"); 
		query.append(",'' REQ_UPD_DT" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}