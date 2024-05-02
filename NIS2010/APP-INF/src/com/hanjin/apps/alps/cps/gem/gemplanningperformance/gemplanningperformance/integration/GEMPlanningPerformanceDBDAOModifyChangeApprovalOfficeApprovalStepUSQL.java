/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOModifyChangeApprovalOfficeApprovalStepUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOModifyChangeApprovalOfficeApprovalStepUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.18 [CHM-201108838-01] 이준범
	  * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
	  * DESC :   월별 예산 신청 금액을 조정한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOModifyChangeApprovalOfficeApprovalStepUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOModifyChangeApprovalOfficeApprovalStepUSQL").append("\n"); 
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
		query.append("UPDATE GEM_APRO_STEP" ).append("\n"); 
		query.append("   SET JAN_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '01' THEN 0 ELSE JAN_AMT END" ).append("\n"); 
		query.append("      ,FEB_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '02' THEN 0 ELSE FEB_AMT END" ).append("\n"); 
		query.append("      ,MAR_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '03' THEN 0 ELSE MAR_AMT END" ).append("\n"); 
		query.append("      ,APR_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '04' THEN 0 ELSE APR_AMT END" ).append("\n"); 
		query.append("      ,MAY_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '05' THEN 0 ELSE MAY_AMT END" ).append("\n"); 
		query.append("      ,JUN_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '06' THEN 0 ELSE JUN_AMT END" ).append("\n"); 
		query.append("      ,JUL_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '07' THEN 0 ELSE JUL_AMT END" ).append("\n"); 
		query.append("      ,AUG_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '08' THEN 0 ELSE AUG_AMT END" ).append("\n"); 
		query.append("      ,SEP_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '09' THEN 0 ELSE SEP_AMT END" ).append("\n"); 
		query.append("      ,OCT_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '10' THEN 0 ELSE OCT_AMT END" ).append("\n"); 
		query.append("      ,NOV_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '11' THEN 0 ELSE NOV_AMT END" ).append("\n"); 
		query.append("      ,DEC_AMT = CASE WHEN SUBSTR(@[stnd_dt],5 ,2) <= '12' THEN 0 ELSE DEC_AMT END" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE GEN_EXPN_RQST_NO IN ( " ).append("\n"); 
		query.append("                            SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                              FROM GEM_REQUEST" ).append("\n"); 
		query.append("                             WHERE PLN_YRMON LIKE SUBSTR(@[stnd_dt], 1, 4)||'%'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}