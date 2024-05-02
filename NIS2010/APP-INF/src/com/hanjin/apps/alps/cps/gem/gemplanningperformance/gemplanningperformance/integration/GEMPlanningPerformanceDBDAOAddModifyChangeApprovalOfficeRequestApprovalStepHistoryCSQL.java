/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOAddModifyChangeApprovalOfficeRequestApprovalStepHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.06.13 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE-JUN-BUM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOAddModifyChangeApprovalOfficeRequestApprovalStepHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddModifyChangeApprovalOfficeRequestApprovalStepHistory
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOAddModifyChangeApprovalOfficeRequestApprovalStepHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOAddModifyChangeApprovalOfficeRequestApprovalStepHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO GEM_APRO_STEP_HIS" ).append("\n"); 
		query.append("( GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(" ,OFC_CD" ).append("\n"); 
		query.append(" ,GEN_EXPN_CD" ).append("\n"); 
		query.append(" ,GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(" ,GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(" ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(" ,GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(" ,EFF_DT" ).append("\n"); 
		query.append(" ,GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(" ,GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append(" ,JAN_AMT  " ).append("\n"); 
		query.append(" ,FEB_AMT" ).append("\n"); 
		query.append(" ,MAR_AMT" ).append("\n"); 
		query.append(" ,APR_AMT" ).append("\n"); 
		query.append(" ,MAY_AMT" ).append("\n"); 
		query.append(" ,JUN_AMT" ).append("\n"); 
		query.append(" ,JUL_AMT" ).append("\n"); 
		query.append(" ,AUG_AMT" ).append("\n"); 
		query.append(" ,SEP_AMT" ).append("\n"); 
		query.append(" ,OCT_AMT" ).append("\n"); 
		query.append(" ,NOV_AMT" ).append("\n"); 
		query.append(" ,DEC_AMT" ).append("\n"); 
		query.append(" ,APRO_OPIN_RMK" ).append("\n"); 
		query.append(" ,CRE_USR_ID " ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,GEN_EXPN_CD" ).append("\n"); 
		query.append("          ,GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("          ,GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("          ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("          ,GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("	   	  ,@[exp_dt]	" ).append("\n"); 
		query.append("          ,GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("          ,GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("          ,JAN_AMT" ).append("\n"); 
		query.append("          ,FEB_AMT" ).append("\n"); 
		query.append("          ,MAR_AMT" ).append("\n"); 
		query.append("          ,APR_AMT" ).append("\n"); 
		query.append("          ,MAY_AMT" ).append("\n"); 
		query.append("          ,JUN_AMT" ).append("\n"); 
		query.append("          ,JUL_AMT" ).append("\n"); 
		query.append("          ,AUG_AMT" ).append("\n"); 
		query.append("          ,SEP_AMT" ).append("\n"); 
		query.append("          ,OCT_AMT" ).append("\n"); 
		query.append("          ,NOV_AMT" ).append("\n"); 
		query.append("          ,DEC_AMT" ).append("\n"); 
		query.append("          ,APRO_OPIN_RMK" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("      FROM GEM_APRO_STEP " ).append("\n"); 
		query.append("     WHERE GEN_EXPN_RQST_NO IN (" ).append("\n"); 
		query.append("                                SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                                  FROM GEM_REQUEST" ).append("\n"); 
		query.append("                                 WHERE PLN_YRMON LIKE SUBSTR (@[exp_dt], 1, 4)||'%'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("       AND OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}