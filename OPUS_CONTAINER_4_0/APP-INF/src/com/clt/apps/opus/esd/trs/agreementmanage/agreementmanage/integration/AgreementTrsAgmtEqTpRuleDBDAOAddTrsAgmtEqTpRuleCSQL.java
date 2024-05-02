/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAOAddTrsAgmtEqTpRuleCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.05.02 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsAgmtEqTpRuleDBDAOAddTrsAgmtEqTpRuleCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddTrsAgmtEqTpRule
	  * </pre>
	  */
	public AgreementTrsAgmtEqTpRuleDBDAOAddTrsAgmtEqTpRuleCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dist_ut_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_step_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_loc_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dist_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rule_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovwt_stnd_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_per_dist_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rnd_trp_rt_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_loc_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovwt_ut_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsAgmtEqTpRuleDBDAOAddTrsAgmtEqTpRuleCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_AGMT_EQ_TP_RULE( TRSP_AGMT_RULE_SEQ" ).append("\n"); 
		query.append("                                ,TRSP_AGMT_RULE_TP_CD ,TRSP_AGMT_STEP_KNT ,TRSP_AGMT_COST_MOD_CD ,TRSP_AGMT_CGO_TP_CD ,TRSP_AGMT_EQ_KND_CD" ).append("\n"); 
		query.append("                                ,TRSP_AGMT_EQ_TP_CD ,TRSP_AGMT_EQ_SZ_CD ,TRSP_AGMT_TP_CD ,TRSP_MOD_CD ,SCG_COND_CD" ).append("\n"); 
		query.append("                                ,FM_LOC_COND_CD ,VIA_LOC_COND_CD ,TO_LOC_COND_CD ,DOR_LOC_COND_CD ,RCV_COND_CD" ).append("\n"); 
		query.append("                                ,DE_COND_CD ,RAIL_SVC_TP_CD ,RT_COND_CD, CURR_COND_CD ,RND_TRP_RT_COND_CD" ).append("\n"); 
		query.append("                                ,CHSS_NO_COND_CD ,TO_DIST_COND_CD ,FX_PER_DIST_COND_CD ,DIST_UT_COND_CD ,OVWT_UT_COND_CD ,OVWT_STND_COND_CD" ).append("\n"); 
		query.append("                                ,CRE_USR_ID ,CRE_DT ,UPD_USR_ID ,UPD_DT)" ).append("\n"); 
		query.append("                         VALUES( (SELECT NVL(MAX(TRSP_AGMT_RULE_SEQ), 0) + 1 FROM TRS_AGMT_EQ_TP_RULE)" ).append("\n"); 
		query.append("                                ,@[trsp_agmt_rule_tp_cd], @[trsp_agmt_step_knt], @[trsp_agmt_cost_mod_cd], @[trsp_agmt_cgo_tp_cd], @[trsp_agmt_eq_knd_cd]" ).append("\n"); 
		query.append("                                ,@[trsp_agmt_eq_tp_cd], @[trsp_agmt_eq_sz_cd], @[trsp_agmt_tp_cd], @[trsp_mod_cd], @[scg_cond_cd]" ).append("\n"); 
		query.append("                                ,@[fm_loc_cond_cd], @[via_loc_cond_cd], @[to_loc_cond_cd], @[dor_loc_cond_cd], @[rcv_cond_cd]" ).append("\n"); 
		query.append("                                ,@[de_cond_cd], @[rail_svc_tp_cd], @[rt_cond_cd], @[curr_cond_cd], @[rnd_trp_rt_cond_cd]" ).append("\n"); 
		query.append("                                ,@[chss_no_cond_cd], @[to_dist_cond_cd], @[fx_per_dist_cond_cd], @[dist_ut_cond_cd], @[ovwt_ut_cond_cd], @[ovwt_stnd_cond_cd]" ).append("\n"); 
		query.append("                                ,@[upd_usr_id], sysdate, @[upd_usr_id], sysdate )" ).append("\n"); 

	}
}