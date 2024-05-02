/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAOModifyTrsAgmtEqTpRuleUSQL.java
*@FileTitle : TRS_AGMT_EQ_TP_RULE
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.25 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsAgmtEqTpRuleDBDAOModifyTrsAgmtEqTpRuleUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTrsAgmtEqTpRule
	  * </pre>
	  */
	public AgreementTrsAgmtEqTpRuleDBDAOModifyTrsAgmtEqTpRuleUSQL(){
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
		params.put("trsp_agmt_rule_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementTrsAgmtEqTpRuleDBDAOModifyTrsAgmtEqTpRuleUSQL").append("\n"); 
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
		query.append("UPDATE TRS_AGMT_EQ_TP_RULE" ).append("\n"); 
		query.append("   SET TRSP_AGMT_RULE_TP_CD    = @[trsp_agmt_rule_tp_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_STEP_KNT      = @[trsp_agmt_step_knt]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_COST_MOD_CD   = @[trsp_agmt_cost_mod_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_CGO_TP_CD     = @[trsp_agmt_cgo_tp_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_KND_CD     = @[trsp_agmt_eq_knd_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_TP_CD      = @[trsp_agmt_eq_tp_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_EQ_SZ_CD      = @[trsp_agmt_eq_sz_cd]" ).append("\n"); 
		query.append("      ,TRSP_AGMT_TP_CD         = @[trsp_agmt_tp_cd]" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD             = @[trsp_mod_cd]" ).append("\n"); 
		query.append("      ,SCG_COND_CD             = @[scg_cond_cd]" ).append("\n"); 
		query.append("      ,FM_LOC_COND_CD          = @[fm_loc_cond_cd]" ).append("\n"); 
		query.append("      ,VIA_LOC_COND_CD         = @[via_loc_cond_cd]" ).append("\n"); 
		query.append("      ,TO_LOC_COND_CD          = @[to_loc_cond_cd]" ).append("\n"); 
		query.append("      ,DOR_LOC_COND_CD         = @[dor_loc_cond_cd]" ).append("\n"); 
		query.append("      ,RCV_COND_CD             = @[rcv_cond_cd]" ).append("\n"); 
		query.append("      ,DE_COND_CD              = @[de_cond_cd]" ).append("\n"); 
		query.append("      ,RAIL_SVC_TP_CD          = @[rail_svc_tp_cd]" ).append("\n"); 
		query.append("      ,RT_COND_CD              = @[rt_cond_cd]" ).append("\n"); 
		query.append("      ,CURR_COND_CD            = @[curr_cond_cd]" ).append("\n"); 
		query.append("      ,RND_TRP_RT_COND_CD      = @[rnd_trp_rt_cond_cd]" ).append("\n"); 
		query.append("      ,CHSS_NO_COND_CD         = @[chss_no_cond_cd]" ).append("\n"); 
		query.append("      ,TO_DIST_COND_CD         = @[to_dist_cond_cd]" ).append("\n"); 
		query.append("      ,FX_PER_DIST_COND_CD     = @[fx_per_dist_cond_cd]" ).append("\n"); 
		query.append("      ,DIST_UT_COND_CD         = @[dist_ut_cond_cd]" ).append("\n"); 
		query.append("      ,OVWT_UT_COND_CD         = @[ovwt_ut_cond_cd]" ).append("\n"); 
		query.append("      ,OVWT_STND_COND_CD       = @[ovwt_stnd_cond_cd]" ).append("\n"); 
		query.append("      ,UPD_USR_ID              = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT                  = sysdate" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_RULE_SEQ = @[trsp_agmt_rule_seq]" ).append("\n"); 

	}
}