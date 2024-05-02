/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchExpensePlanningRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.05 
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

public class GEMPlanningPerformanceDBDAOSearchExpensePlanningRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
	  * 2010.11.05 [CHM-201006871-01] 이준범
	  * 1) Request expense 후 Reject된 데이터를 Initial 기능에서 수정할 수 있는 로직 오류 발생 확인
	  * 2) Request expense  Initial 기능에서는 Request 상태인 데이터만 조회하도록 기존 오류 보완
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchExpensePlanningRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchExpensePlanningRSQL").append("\n"); 
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
		query.append("SELECT A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("      ,A.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("      ,A.CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("      ,A.RQST_OPIN_RMK" ).append("\n"); 
		query.append("      ,A.JAN_AMT" ).append("\n"); 
		query.append("      ,A.FEB_AMT" ).append("\n"); 
		query.append("      ,A.MAR_AMT" ).append("\n"); 
		query.append("      ,A.APR_AMT" ).append("\n"); 
		query.append("      ,A.MAY_AMT" ).append("\n"); 
		query.append("      ,A.JUN_AMT" ).append("\n"); 
		query.append("      ,A.JUL_AMT" ).append("\n"); 
		query.append("      ,A.AUG_AMT" ).append("\n"); 
		query.append("      ,A.SEP_AMT" ).append("\n"); 
		query.append("      ,A.OCT_AMT" ).append("\n"); 
		query.append("      ,A.NOV_AMT" ).append("\n"); 
		query.append("      ,A.DEC_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') ITM_UPD_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(E.UPD_DT,'YYYYMMDDHH24MISS') REQ_UPD_DT" ).append("\n"); 
		query.append("      ,B.JAN_AMT RQST_JAN_AMT" ).append("\n"); 
		query.append("      ,B.FEB_AMT RQST_FEB_AMT" ).append("\n"); 
		query.append("      ,B.MAR_AMT RQST_MAR_AMT" ).append("\n"); 
		query.append("      ,B.APR_AMT RQST_APR_AMT" ).append("\n"); 
		query.append("      ,B.MAY_AMT RQST_MAY_AMT" ).append("\n"); 
		query.append("      ,B.JUN_AMT RQST_JUN_AMT" ).append("\n"); 
		query.append("      ,B.JUL_AMT RQST_JUL_AMT" ).append("\n"); 
		query.append("      ,B.AUG_AMT RQST_AUG_AMT" ).append("\n"); 
		query.append("      ,B.SEP_AMT RQST_SEP_AMT" ).append("\n"); 
		query.append("      ,B.OCT_AMT RQST_OCT_AMT" ).append("\n"); 
		query.append("      ,B.NOV_AMT RQST_NOV_AMT" ).append("\n"); 
		query.append("      ,B.DEC_AMT RQST_DEC_AMT" ).append("\n"); 
		query.append("      ,B.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("      ,B.GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("      ,C.ENG_ABBR_NM" ).append("\n"); 
		query.append("      ,C.KRN_ABBR_NM" ).append("\n"); 
		query.append("      , (  B.JAN_AMT" ).append("\n"); 
		query.append("         + B.FEB_AMT" ).append("\n"); 
		query.append("         + B.MAR_AMT" ).append("\n"); 
		query.append("         + B.APR_AMT" ).append("\n"); 
		query.append("         + B.MAY_AMT" ).append("\n"); 
		query.append("         + B.JUN_AMT" ).append("\n"); 
		query.append("         + B.JUL_AMT" ).append("\n"); 
		query.append("         + B.AUG_AMT" ).append("\n"); 
		query.append("         + B.SEP_AMT" ).append("\n"); 
		query.append("         + B.OCT_AMT" ).append("\n"); 
		query.append("         + B.NOV_AMT" ).append("\n"); 
		query.append("         + B.DEC_AMT" ).append("\n"); 
		query.append("        ) RQST_LOCL_AMT" ).append("\n"); 
		query.append("      ,C.TIC_CD" ).append("\n"); 
		query.append("FROM   GEM_ITEM A, GEM_APRO_STEP B, GEM_EXPENSE C, GEM_OFC_MTX D , GEM_REQUEST E" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    E.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND    E.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND    E.GEN_EXPN_RQST_TP_CD IN ('EA','EI')" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != '') " ).append("\n"); 
		query.append("AND    E.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("AND    E.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_ITM_NO = B.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_TRNS_DIV_CD = B.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_RQST_SEQ = B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND    A.CRNT_GEN_EXPN_APSTS_CD = B.GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("AND    A.CRNT_GEN_EXPN_APRO_STEP_CD = B.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("AND    C.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    C.GEN_EXPN_GRP_LVL = '4'" ).append("\n"); 
		query.append("AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    D.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND    C.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    A.CRNT_GEN_EXPN_APSTS_CD = 'RQ'" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_APRO_AUTH_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY A.GEN_EXPN_RQST_SEQ , A.OFC_CD , A.GEN_EXPN_CD ,A.GEN_EXPN_ITM_NO" ).append("\n"); 

	}
}