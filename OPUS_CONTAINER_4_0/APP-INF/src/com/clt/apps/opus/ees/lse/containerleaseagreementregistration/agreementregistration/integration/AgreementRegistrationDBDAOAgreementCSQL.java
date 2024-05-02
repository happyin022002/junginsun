/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.02.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpc_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_itchg_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_dpc_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_wdp_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wdp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpc_val_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dpc_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wdp_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bld_dwn_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_vndr_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lft_onf_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bld_up_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itchg_fee_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AGREEMENT (" ).append("\n"); 
		query.append("   AGMT_CTY_CD" ).append("\n"); 
		query.append(" , AGMT_SEQ" ).append("\n"); 
		query.append(" , AGMT_LST_VER_SEQ " ).append("\n"); 
		query.append(" , LST_EFF_DT" ).append("\n"); 
		query.append(" , LST_EXP_DT" ).append("\n"); 
		query.append(" , VNDR_SEQ" ).append("\n"); 
		query.append(" , LSE_VNDR_URL" ).append("\n"); 
		query.append(" , LSTM_CD" ).append("\n"); 
		query.append(" , OFC_CD" ).append("\n"); 
		query.append(" , CURR_CD" ).append("\n"); 
		query.append(" , REF_NO " ).append("\n"); 
		query.append("#if ( ${dpc_rto} != '' )" ).append("\n"); 
		query.append(" , DPC_RTO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${max_dpc_rto} != '' )" ).append("\n"); 
		query.append(" , MAX_DPC_RTO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , CNTR_DPC_LVL_CD" ).append("\n"); 
		query.append(" , PST_WDP_RT_TP_CD" ).append("\n"); 
		query.append("#if ( ${wdp_dys} != '' )" ).append("\n"); 
		query.append(" , WDP_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , WDP_TP_CD" ).append("\n"); 
		query.append(" , DPP_TP_CD" ).append("\n"); 
		query.append(" , AGMT_DT" ).append("\n"); 
		query.append(" , AGMT_RMK" ).append("\n"); 
		query.append(" , BLD_UP_DT" ).append("\n"); 
		query.append(" , LFT_ONF_CHG_CD" ).append("\n"); 
		query.append("#if ( ${lse_pay_term_dys} != '' )" ).append("\n"); 
		query.append(" , LSE_PAY_TERM_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${lse_free_dys} != '' )" ).append("\n"); 
		query.append(" , LSE_FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , ITCHG_FEE_FLG" ).append("\n"); 
		query.append("#if ( ${dir_itchg_fee_amt} != '' )" ).append("\n"); 
		query.append(" , DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dpc_val_flg} != '' )" ).append("\n"); 
		query.append(" , DPC_VAL_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , LSE_CTRT_NO" ).append("\n"); 
		query.append(" , AGMT_ACT_FLG" ).append("\n"); 
		query.append("#if ( ${old_agmt_no} != '' )" ).append("\n"); 
		query.append(" , OLD_AGMT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , LSE_PAY_TP_CD" ).append("\n"); 
		query.append("#if ( ${bld_dwn_end_dt} != '' )" ).append("\n"); 
		query.append(" , BLD_DWN_END_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[agmt_cty_cd]" ).append("\n"); 
		query.append(" , @[agmt_seq]" ).append("\n"); 
		query.append(" , @[agmt_ver_seq]" ).append("\n"); 
		query.append(" , TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , TO_DATE(@[exp_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , @[vndr_seq]" ).append("\n"); 
		query.append(" , @[lse_vndr_url]" ).append("\n"); 
		query.append(" , @[lstm_cd]" ).append("\n"); 
		query.append(" , @[ofc_cd]" ).append("\n"); 
		query.append(" , @[curr_cd]" ).append("\n"); 
		query.append(" , @[ref_no]" ).append("\n"); 
		query.append("#if ( ${dpc_rto} != '' )" ).append("\n"); 
		query.append(" , @[dpc_rto]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${max_dpc_rto} != '' )" ).append("\n"); 
		query.append(" , @[max_dpc_rto]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[cntr_dpc_lvl_cd]" ).append("\n"); 
		query.append(" , @[pst_wdp_rt_tp_cd]" ).append("\n"); 
		query.append("#if ( ${wdp_dys} != '' )" ).append("\n"); 
		query.append(" , @[wdp_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[wdp_tp_cd]" ).append("\n"); 
		query.append(" , @[dpp_tp_cd]" ).append("\n"); 
		query.append(" , TO_DATE(@[agmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , @[agmt_rmk]" ).append("\n"); 
		query.append(" , TO_DATE(@[bld_up_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" , @[lft_onf_chg_cd]" ).append("\n"); 
		query.append("#if ( ${lse_pay_term_dys} != '' )" ).append("\n"); 
		query.append(" , @[lse_pay_term_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${lse_free_dys} != '' )" ).append("\n"); 
		query.append(" , @[lse_free_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[itchg_fee_flg]" ).append("\n"); 
		query.append("#if ( ${dir_itchg_fee_amt} != '' )" ).append("\n"); 
		query.append(" , @[dir_itchg_fee_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dpc_val_flg} != '' )" ).append("\n"); 
		query.append(" , @[dpc_val_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[cre_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[upd_usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[lse_ctrt_no]" ).append("\n"); 
		query.append(" , @[agmt_act_flg]" ).append("\n"); 
		query.append("#if ( ${old_agmt_no} != '' )" ).append("\n"); 
		query.append(" , @[old_agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("#if ( ${bld_dwn_end_dt} != '' )" ).append("\n"); 
		query.append(" , TO_DATE(@[bld_dwn_end_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}