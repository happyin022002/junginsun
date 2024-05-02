/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.27 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_APRO_ITEM 저장
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_itm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_trns_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aug_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_apro_auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jan_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_opin_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_apro_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO GEM_APRO_STEP (" ).append("\n"); 
		query.append("GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	GEN_EXPN_CD" ).append("\n"); 
		query.append(",	GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",	GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(",	GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",	GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",	GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",	GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append(",	JAN_AMT" ).append("\n"); 
		query.append(",	FEB_AMT" ).append("\n"); 
		query.append(",	MAR_AMT" ).append("\n"); 
		query.append(",	APR_AMT" ).append("\n"); 
		query.append(",	MAY_AMT" ).append("\n"); 
		query.append(",	JUN_AMT" ).append("\n"); 
		query.append(",	JUL_AMT" ).append("\n"); 
		query.append(",	AUG_AMT" ).append("\n"); 
		query.append(",	SEP_AMT" ).append("\n"); 
		query.append(",	OCT_AMT" ).append("\n"); 
		query.append(",	NOV_AMT" ).append("\n"); 
		query.append(",	DEC_AMT" ).append("\n"); 
		query.append(",	APRO_OPIN_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[gen_expn_rqst_no]" ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	@[gen_expn_cd]" ).append("\n"); 
		query.append(",	@[gen_expn_itm_no]" ).append("\n"); 
		query.append(",	@[gen_expn_trns_div_cd]" ).append("\n"); 
		query.append(",	@[gen_expn_rqst_seq]" ).append("\n"); 
		query.append(",	@[gen_expn_apro_step_cd]" ).append("\n"); 
		query.append(",	@[gen_expn_apsts_cd]" ).append("\n"); 
		query.append(",	@[gen_expn_apro_auth_ofc_cd]" ).append("\n"); 
		query.append(",	nvl(@[jan_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[feb_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[mar_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[apr_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[may_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[jun_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[jul_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[aug_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[sep_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[oct_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[nov_amt],0)" ).append("\n"); 
		query.append(",	nvl(@[dec_amt],0)" ).append("\n"); 
		query.append(",	@[apro_opin_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}