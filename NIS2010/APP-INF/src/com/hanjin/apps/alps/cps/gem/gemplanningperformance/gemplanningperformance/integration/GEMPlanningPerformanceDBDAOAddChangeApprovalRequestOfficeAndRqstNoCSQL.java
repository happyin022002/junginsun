/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOAddChangeApprovalRequestOfficeAndRqstNoCSQL.java
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

public class GEMPlanningPerformanceDBDAOAddChangeApprovalRequestOfficeAndRqstNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.18 [CHM-201108838-01] 이준범
	  * Title   : OFC code Change 설정 시 Assigned Expense Data 변경 요청
	  * DESC : Request의 기존 OFC_CD 를 변경될 OFC_CD 로 생성 한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOAddChangeApprovalRequestOfficeAndRqstNoCSQL(){
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
		params.put("bfr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : GEMPlanningPerformanceDBDAOAddChangeApprovalRequestOfficeAndRqstNoCSQL").append("\n"); 
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
		query.append("INSERT INTO GEM_REQUEST" ).append("\n"); 
		query.append("( GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(" ,PLN_YRMON" ).append("\n"); 
		query.append(" ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append(" ,RQST_OFC_CD" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRIM(SUBSTR(GEN_EXPN_RQST_NO, 1, 2)||@[bfr_ofc_cd]||SUBSTR(GEN_EXPN_RQST_NO, LENGTH(@[ofc_cd]) + 3, 12))" ).append("\n"); 
		query.append("      ,PLN_YRMON" ).append("\n"); 
		query.append("      ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("      ,@[bfr_ofc_cd]" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM GEM_REQUEST" ).append("\n"); 
		query.append(" WHERE GEN_EXPN_RQST_NO IN (" ).append("\n"); 
		query.append("                            SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                              FROM GEM_ITEM" ).append("\n"); 
		query.append("                             WHERE GEN_EXPN_RQST_NO IN ( " ).append("\n"); 
		query.append("                                                        SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                                                          FROM GEM_REQUEST" ).append("\n"); 
		query.append("                                                         WHERE PLN_YRMON LIKE SUBSTR(@[stnd_dt], 1, 4)||'%'" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                              AND OFC_CD = @[bfr_ofc_cd]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("   AND RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}