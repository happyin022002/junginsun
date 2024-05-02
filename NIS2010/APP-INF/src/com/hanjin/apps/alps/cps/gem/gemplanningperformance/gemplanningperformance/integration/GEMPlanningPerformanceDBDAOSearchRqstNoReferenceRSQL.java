/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchRqstNoReferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchRqstNoReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다
	  * 2010.11.05 [CHM-201006871-01] 이준범
	  * 1) Request expense 후 Reject된 데이터를 Initial 기능에서 수정할 수 있는 로직 오류 발생 확인
	  * 2) Request expense  Initial 기능에서는 Request 상태인 데이터만 조회하도록 기존 오류 보완
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchRqstNoReferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchRqstNoReferenceRSQL").append("\n"); 
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
		query.append("SELECT  A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("       ,A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("       ,A.FR_GEN_EXPN_CD" ).append("\n"); 
		query.append("       ,A.TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("       ,NVL(A.FR_GEN_EXPN_ITM_NO,A.TO_GEN_EXPN_ITM_NO) FR_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("       ,A.TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("       ,A.FR_OFC_CD" ).append("\n"); 
		query.append("       ,A.TO_OFC_CD" ).append("\n"); 
		query.append("       ,A.FR_AMT" ).append("\n"); 
		query.append("       ,A.TO_AMT" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,A.REQ_UPD_DT" ).append("\n"); 
		query.append("       ,B.LOCL_CURR_CD FR_CURR_CD       " ).append("\n"); 
		query.append("       ,C.LOCL_CURR_CD TO_CURR_CD" ).append("\n"); 
		query.append("       ,B.RQST_UT_VAL FR_UT_VAL  " ).append("\n"); 
		query.append("       ,C.RQST_UT_VAL TO_UT_VAL " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         SELECT  A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                ,A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'F',A.GEN_EXPN_CD ,'')) FR_GEN_EXPN_CD" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'T',A.GEN_EXPN_CD ,'')) TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'F',A.GEN_EXPN_ITM_NO ,'')) FR_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'T',A.GEN_EXPN_ITM_NO ,'')) TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'F',A.OFC_CD ,'')) FR_OFC_CD" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'T',A.OFC_CD ,'')) TO_OFC_CD" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'F',A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ,'')) FR_AMT" ).append("\n"); 
		query.append("                ,MAX(DECODE(A.GEN_EXPN_TRNS_DIV_CD,'T',A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ,'')) TO_AMT" ).append("\n"); 
		query.append("                ,MAX(C.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("                ,MAX(C.CRE_DT) CRE_DT" ).append("\n"); 
		query.append("			    ,MAX(TO_CHAR(C.UPD_DT,'YYYYMMDDHH24MISS')) REQ_UPD_DT" ).append("\n"); 
		query.append("         FROM    GEM_APRO_STEP A , GEM_ITEM B ,GEM_REQUEST C" ).append("\n"); 
		query.append("         WHERE   1=1" ).append("\n"); 
		query.append("             AND A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("             AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("             AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("			 AND A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("			 AND A.GEN_EXPN_ITM_NO = B.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("			 AND A.GEN_EXPN_TRNS_DIV_CD = B.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("			 AND A.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("             AND A.GEN_EXPN_APRO_STEP_CD = B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("             #if (${prg_id} == '0002') " ).append("\n"); 
		query.append("             AND B.OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             AND B.GEN_EXPN_APRO_AUTH_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("             AND B.CRNT_GEN_EXPN_APSTS_CD = 'RQ'" ).append("\n"); 
		query.append("             #end              " ).append("\n"); 
		query.append("             AND C.PLN_YRMON LIKE @[pln_yrmon] || '%'  " ).append("\n"); 
		query.append("			 #if (${prg_id} == '') " ).append("\n"); 
		query.append("             AND C.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("             AND C.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("		     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 #if (${auth_flg} == 'YNYN') " ).append("\n"); 
		query.append("		     AND  B.CRNT_GEN_EXPN_APRO_STEP_CD IN ('RQ','HQ','TC')" ).append("\n"); 
		query.append("		     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 #if (${auth_flg} == 'YNYY') " ).append("\n"); 
		query.append("             -- YNYY 사무국" ).append("\n"); 
		query.append("             AND  B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("             AND  B.CRNT_GEN_EXPN_APSTS_CD <> 'AP'" ).append("\n"); 
		query.append("		     #end			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_tp_cd} != '') " ).append("\n"); 
		query.append("             AND C.GEN_EXPN_RQST_TP_CD IN (${gen_expn_rqst_tp_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY A.GEN_EXPN_RQST_NO , A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(") A , GEM_OFFICE B , GEM_OFFICE C" ).append("\n"); 
		query.append("WHERE B.OFC_CD(+) = A.FR_OFC_CD " ).append("\n"); 
		query.append("  AND C.OFC_CD(+) = A.TO_OFC_CD" ).append("\n"); 
		query.append("ORDER BY A.CRE_DT DESC, " ).append("\n"); 
		query.append("A.GEN_EXPN_RQST_NO ," ).append("\n"); 
		query.append("A.GEN_EXPN_RQST_SEQ ," ).append("\n"); 
		query.append("A.FR_GEN_EXPN_ITM_NO" ).append("\n"); 

	}
}