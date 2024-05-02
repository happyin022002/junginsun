/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpc_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_itchg_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_act_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_wdp_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
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
		params.put("lse_agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lse_vndr_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itchg_fee_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lft_onf_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bld_up_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementUSQL").append("\n"); 
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
		query.append("UPDATE LSE_AGREEMENT SET" ).append("\n"); 
		query.append("   LST_EFF_DT        =  @[eff_dt]" ).append("\n"); 
		query.append(" , LST_EXP_DT        =  @[exp_dt]" ).append("\n"); 
		query.append(" , AGMT_LST_VER_SEQ  =  @[agmt_ver_seq]" ).append("\n"); 
		query.append(" , VNDR_SEQ          =  @[vndr_seq]" ).append("\n"); 
		query.append(" , LSE_VNDR_URL      =  @[lse_vndr_url]" ).append("\n"); 
		query.append(" , LSTM_CD           =  @[lstm_cd]" ).append("\n"); 
		query.append(" , OFC_CD            =  @[ofc_cd]" ).append("\n"); 
		query.append(" , CURR_CD           =  @[curr_cd]" ).append("\n"); 
		query.append(" , REF_NO            =  @[ref_no]" ).append("\n"); 
		query.append(" , LSE_CTRT_NO       =  @[lse_ctrt_no]" ).append("\n"); 
		query.append("#if ( ${dpc_rto} != '' )" ).append("\n"); 
		query.append(" , DPC_RTO           =  DECODE(@[cntr_dpc_lvl_cd] ,'M', ROUND(@[dpc_rto] / 12,3) , 'D', ROUND(@[dpc_rto] / 365,3) , @[dpc_rto])" ).append("\n"); 
		query.append(" , YRY_DPC_RTO       =  @[dpc_rto] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${max_dpc_rto} != '' )" ).append("\n"); 
		query.append(" , MAX_DPC_RTO       =  @[max_dpc_rto]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , CNTR_DPC_LVL_CD   =  @[cntr_dpc_lvl_cd]" ).append("\n"); 
		query.append(" , PST_WDP_RT_TP_CD  =  @[pst_wdp_rt_tp_cd]" ).append("\n"); 
		query.append("#if ( ${wdp_dys} != '' )" ).append("\n"); 
		query.append(" , WDP_DYS           =  @[wdp_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , WDP_TP_CD         =  @[wdp_tp_cd]" ).append("\n"); 
		query.append(" , DPP_TP_CD         =  @[dpp_tp_cd]" ).append("\n"); 
		query.append(" , AGMT_DT           =  @[agmt_dt]" ).append("\n"); 
		query.append(" , AGMT_RMK          =  @[agmt_rmk]" ).append("\n"); 
		query.append(" , BLD_UP_DT         =  @[bld_up_dt]" ).append("\n"); 
		query.append(" , LFT_ONF_CHG_CD    =  @[lft_onf_chg_cd]" ).append("\n"); 
		query.append("#if ( ${lse_pay_term_dys} != '' )" ).append("\n"); 
		query.append(" , LSE_PAY_TERM_DYS  =  @[lse_pay_term_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${lse_free_dys} != '' )" ).append("\n"); 
		query.append(" , LSE_FREE_DYS      =  @[lse_free_dys]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , ITCHG_FEE_FLG     =  @[itchg_fee_flg]" ).append("\n"); 
		query.append("#if ( ${dir_itchg_fee_amt} != '' )" ).append("\n"); 
		query.append(" , DIR_ITCHG_FEE_AMT =  @[dir_itchg_fee_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dpc_val_flg} != '' )" ).append("\n"); 
		query.append(" , DPC_VAL_FLG       =  @[dpc_val_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" , UPD_USR_ID        =  @[upd_usr_id]" ).append("\n"); 
		query.append(" , UPD_DT            =  SYSDATE" ).append("\n"); 
		query.append(" , AGMT_ACT_FLG      =  @[agmt_act_flg]" ).append("\n"); 
		query.append(" , LSE_AGMT_DOC_NO   =  @[lse_agmt_doc_no]" ).append("\n"); 
		query.append(" , LSE_AGMT_DOC_DESC =  @[lse_agmt_doc_desc]" ).append("\n"); 
		query.append("WHERE AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND   AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 

	}
}