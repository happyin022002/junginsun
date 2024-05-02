/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchTransferExpenseItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.13 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchTransferExpenseItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transfer Item취득
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchTransferExpenseItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchTransferExpenseItemRSQL").append("\n"); 
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
		query.append("SELECT B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",B.OFC_CD" ).append("\n"); 
		query.append(",B.GEN_EXPN_CD" ).append("\n"); 
		query.append(",B.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",B.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(",B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",B.CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",B.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",B.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",B.RQST_OPIN_RMK" ).append("\n"); 
		query.append(",B.JAN_AMT" ).append("\n"); 
		query.append(",B.FEB_AMT" ).append("\n"); 
		query.append(",B.MAR_AMT" ).append("\n"); 
		query.append(",B.APR_AMT" ).append("\n"); 
		query.append(",B.MAY_AMT" ).append("\n"); 
		query.append(",B.JUN_AMT" ).append("\n"); 
		query.append(",B.JUL_AMT" ).append("\n"); 
		query.append(",B.AUG_AMT" ).append("\n"); 
		query.append(",B.SEP_AMT" ).append("\n"); 
		query.append(",B.OCT_AMT" ).append("\n"); 
		query.append(",B.NOV_AMT" ).append("\n"); 
		query.append(",B.DEC_AMT" ).append("\n"); 
		query.append(", (  B.JAN_AMT" ).append("\n"); 
		query.append("+ B.FEB_AMT" ).append("\n"); 
		query.append("+ B.MAR_AMT" ).append("\n"); 
		query.append("+ B.APR_AMT" ).append("\n"); 
		query.append("+ B.MAY_AMT" ).append("\n"); 
		query.append("+ B.JUN_AMT" ).append("\n"); 
		query.append("+ B.JUL_AMT" ).append("\n"); 
		query.append("+ B.AUG_AMT" ).append("\n"); 
		query.append("+ B.SEP_AMT" ).append("\n"); 
		query.append("+ B.OCT_AMT" ).append("\n"); 
		query.append("+ B.NOV_AMT" ).append("\n"); 
		query.append("+ B.DEC_AMT) SUM_AMT" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",B.CRE_DT" ).append("\n"); 
		query.append(",B.UPD_USR_ID" ).append("\n"); 
		query.append(",B.UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.UPD_DT,'YYYYMMDDHH24MISS') ITM_UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') REQ_UPD_DT" ).append("\n"); 
		query.append("FROM   GEM_REQUEST A , GEM_ITEM B , GEM_APRO_STEP C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND   B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND   B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("AND   B.GEN_EXPN_APRO_AUTH_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_RQST_TP_CD = 'ET'" ).append("\n"); 
		query.append("AND   A.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND   A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("AND   A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("ORDER BY GEN_EXPN_RQST_SEQ ,  GEN_EXPN_RQST_SEQ , GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 

	}
}