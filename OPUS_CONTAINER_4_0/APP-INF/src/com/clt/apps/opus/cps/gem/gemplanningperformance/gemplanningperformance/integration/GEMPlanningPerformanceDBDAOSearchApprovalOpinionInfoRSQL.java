/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchApprovalOpinionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.07.17 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHANG JUNE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchApprovalOpinionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 요청된 비용계획에 대하여 승인 정보를 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchApprovalOpinionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_item_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchApprovalOpinionInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(GEN_EXPN_APRO_STEP_CD), 0, 'RQST', 'RQST' ) GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(", MAX(GEN_EXPN_APSTS_CD) GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', UPD_USR_ID, 'RJ', UPD_USR_ID, '' )) UPD_USR_ID" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', TO_CHAR(UPD_DT, 'YYYYMMDD'), 'RJ', TO_CHAR(UPD_DT, 'YYYYMMDD'), '' )) UPD_DT" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', APRO_OPIN_RMK, 'RJ', APRO_OPIN_RMK, '' )) APRO_OPIN_RMK" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP" ).append("\n"); 
		query.append("WHERE GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND GEN_EXPN_ITM_NO = @[gen_expn_item_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(GEN_EXPN_APRO_STEP_CD), 0, 'RHQ | BU', 'RHQ | BU' ) GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(", MAX(GEN_EXPN_APSTS_CD) GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', UPD_USR_ID, 'RJ', UPD_USR_ID, '' )) UPD_USR_ID" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', TO_CHAR(UPD_DT, 'YYYYMMDD'), 'RJ', TO_CHAR(UPD_DT, 'YYYYMMDD'), '' )) UPD_DT" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', APRO_OPIN_RMK, 'RJ', APRO_OPIN_RMK, '' )) APRO_OPIN_RMK" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP" ).append("\n"); 
		query.append("WHERE GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND GEN_EXPN_ITM_NO = @[gen_expn_item_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_APRO_STEP_CD = 'HQ'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(GEN_EXPN_APRO_STEP_CD), 0, 'TIC', 'TIC' ) GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(", MAX(GEN_EXPN_APSTS_CD) GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', UPD_USR_ID, 'RJ', UPD_USR_ID, '' )) UPD_USR_ID" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', TO_CHAR(UPD_DT, 'YYYYMMDD'), 'RJ', TO_CHAR(UPD_DT, 'YYYYMMDD'), '' )) UPD_DT" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', APRO_OPIN_RMK, 'RJ', APRO_OPIN_RMK, '' )) APRO_OPIN_RMK" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP" ).append("\n"); 
		query.append("WHERE GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND GEN_EXPN_ITM_NO = @[gen_expn_item_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_APRO_STEP_CD = 'TC'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(GEN_EXPN_APRO_STEP_CD), 0, 'COM', 'COM' ) GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(", MAX(GEN_EXPN_APSTS_CD) GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', UPD_USR_ID, 'RJ', UPD_USR_ID, '' )) UPD_USR_ID" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', TO_CHAR(UPD_DT, 'YYYYMMDD'), 'RJ', TO_CHAR(UPD_DT, 'YYYYMMDD'), '' )) UPD_DT" ).append("\n"); 
		query.append(", MAX(DECODE(GEN_EXPN_APSTS_CD, 'AP', APRO_OPIN_RMK, 'RJ', APRO_OPIN_RMK, '' )) APRO_OPIN_RMK" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP" ).append("\n"); 
		query.append("WHERE GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND GEN_EXPN_ITM_NO = @[gen_expn_item_no]" ).append("\n"); 
		query.append("AND GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 

	}
}