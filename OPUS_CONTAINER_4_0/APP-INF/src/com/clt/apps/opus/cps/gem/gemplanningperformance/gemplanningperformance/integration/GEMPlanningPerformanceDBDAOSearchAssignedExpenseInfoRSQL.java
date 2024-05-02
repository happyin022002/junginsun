/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchAssignedExpenseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchAssignedExpenseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchAssignedExpenseInfoRSQL(){
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
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchAssignedExpenseInfoRSQL").append("\n"); 
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
		query.append("SELECT  MAX(A.GEN_EXPN_ITM_DESC) GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("       ,MAX(A.GEN_EXPN_RQST_NO ) GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("       ,C.OFC_CD" ).append("\n"); 
		query.append("       ,C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("       ,C.GEN_EXPN_CD" ).append("\n"); 
		query.append("       ,SUM(C.JAN_AMT) JAN_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.FEB_AMT) FEB_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.MAR_AMT) MAR_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.APR_AMT) APR_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.MAY_AMT) MAY_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.JUN_AMT) JUN_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.JUL_AMT) JUL_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.AUG_AMT) AUG_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.SEP_AMT) SEP_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.OCT_AMT) OCT_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.NOV_AMT) NOV_AMT  " ).append("\n"); 
		query.append("       ,SUM(C.DEC_AMT) DEC_AMT         " ).append("\n"); 
		query.append("       ,MAX((SELECT LOCL_CURR_CD " ).append("\n"); 
		query.append("             FROM   GEM_OFFICE " ).append("\n"); 
		query.append("             WHERE  OFC_CD = A.OFC_CD)) CURR_CD  " ).append("\n"); 
		query.append("FROM GEM_ITEM A  , GEM_REQUEST B , GEM_APRO_STEP C" ).append("\n"); 
		query.append("WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO " ).append("\n"); 
		query.append("AND   B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND   A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND   A.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("AND   B.PLN_YRMON LIKE @[pln_yrmon] || '%'" ).append("\n"); 
		query.append("AND   A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND   A.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("AND   A.CRNT_GEN_EXPN_APSTS_CD = 'AP'" ).append("\n"); 
		query.append("GROUP BY C.OFC_CD, C.GEN_EXPN_CD ,C.GEN_EXPN_ITM_NO  " ).append("\n"); 
		query.append("ORDER BY GEN_EXPN_ITM_NO" ).append("\n"); 

	}
}