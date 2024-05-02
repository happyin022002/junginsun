/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOAddSarIFDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOAddSarIFDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSarIFData
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOAddSarIFDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_itm_ref_key_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rec_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_val_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_file_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_aset_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("automtc_pay_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_key_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_hdr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_calc_bsel_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cntrl_bank_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dchg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("altn_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dchg_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hus_bank_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_aset_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("entr_expn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfitctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_land_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instr_key_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tax_calc_auto_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instr_key_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_bse_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instr_key_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_prnr_ref_key_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_blck_key_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lodg_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_prnr_ref_key_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_crtr_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtrl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_tax_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_tj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_mgmt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lodg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rec_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_plc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration ").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOAddSarIFDataCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_AR_IF (" ).append("\n"); 
		query.append("	 AR_IF_SEQ                                                                   " ).append("\n"); 
		query.append("	,IF_SEQ_NO                                                                   " ).append("\n"); 
		query.append("	,REC_ID                                                                      " ).append("\n"); 
		query.append("	,ACCT_CO_CD                                                                  " ).append("\n"); 
		query.append("	,IF_DOC_TP_CD                                                                " ).append("\n"); 
		query.append("	,DOC_DT                                                                      " ).append("\n"); 
		query.append("	,PST_DT                                                                      " ).append("\n"); 
		query.append("	,REF_DOC_NO                                                                   " ).append("\n"); 
		query.append("	,DOC_HDR_CD                                                                  " ).append("\n"); 
		query.append("	,CURR_CD                                                                     " ).append("\n"); 
		query.append("	,TAX_CALC_AUTO_FLG                                                           " ).append("\n"); 
		query.append("	,PST_KEY_CD                                                                  " ).append("\n"); 
		query.append("	,VAT_TAX_CD                                                                  " ).append("\n"); 
		query.append("	,LOCL_AMT                                                                    " ).append("\n"); 
		query.append("	,DOC_AMT                                                                     " ).append("\n"); 
		query.append("	,LOCL_TAX_AMT                                                                " ).append("\n"); 
		query.append("	,DOC_TAX_AMT                                                                 " ).append("\n"); 
		query.append("	,ASGN_NO                                                                     " ).append("\n"); 
		query.append("	,ITM_DESC                                                                    " ).append("\n"); 
		query.append("	,PLN_DT                                                                      " ).append("\n"); 
		query.append("	,COST_CTR_CD                                                                 " ).append("\n"); 
		query.append("	,ORD_NO                                                                      " ).append("\n"); 
		query.append("	,MN_ASET_NO                                                                  " ).append("\n"); 
		query.append("	,SUB_ASET_NO                                                                 " ).append("\n"); 
		query.append("	,ASET_TJ_TP_CD                                                               " ).append("\n"); 
		query.append("	,ASET_VAL_DT                                                                 " ).append("\n"); 
		query.append("	,GL_ACCT_NO                                                                  " ).append("\n"); 
		query.append("	,CUST_NO                                                                     " ).append("\n"); 
		query.append("	,VNDR_CRTR_ACCT_NO                                                           " ).append("\n"); 
		query.append("	,DUE_DT_CALC_BSEL_DT                                                         " ).append("\n"); 
		query.append("	,PAY_MZD_CD                                                                  " ).append("\n"); 
		query.append("	,STE_CNTRL_BANK_IND_CD                                                       " ).append("\n"); 
		query.append("	,MTRL_NO                                                                     " ).append("\n"); 
		query.append("	,FUEL_LAND_QTY                                                               " ).append("\n"); 
		query.append("	,MEAS_BSE_UT_CD                                                              " ).append("\n"); 
		query.append("	,PFITCTR_CD                                                                  " ).append("\n"); 
		query.append("	,ALTN_ACCT_NO                                                                " ).append("\n"); 
		query.append("	,BIZ_PRNR_REF_KEY_CD1                                                        " ).append("\n"); 
		query.append("	,BIZ_PRNR_REF_KEY_CD2                                                        " ).append("\n"); 
		query.append("	,LINE_ITM_REF_KEY_CD                                                         " ).append("\n"); 
		query.append("	,INSTR_KEY_CD1                                                               " ).append("\n"); 
		query.append("	,INSTR_KEY_CD2                                                               " ).append("\n"); 
		query.append("	,INSTR_KEY_CD3                                                               " ).append("\n"); 
		query.append("	,PAY_REF_CD                                                                  " ).append("\n"); 
		query.append("	,AUTOMTC_PAY_CURR_CD                                                         " ).append("\n"); 
		query.append("	,PAY_CURR_AMT                                                                " ).append("\n"); 
		query.append("	,CTRT_NO                                                                     " ).append("\n"); 
		query.append("	,CTRT_TP_CD                                                                  " ).append("\n"); 
		query.append("	,PAY_RSN_CD                                                                  " ).append("\n"); 
		query.append("	,CLSS_CD                                                                     " ).append("\n"); 
		query.append("	,ACT_PLC_CD                                                                  " ).append("\n"); 
		query.append("	,ENTR_EXPN_ID                                                                " ).append("\n"); 
		query.append("	,BUD_MGMT_DIV_CD                                                             " ).append("\n"); 
		query.append("	,ACT_DT                                                                      " ).append("\n"); 
		query.append("	,VSL_CD                                                                      " ).append("\n"); 
		query.append("	,VVL_CD                                                                      " ).append("\n"); 
		query.append("	,HUS_BANK_ID                                                                 " ).append("\n"); 
		query.append("	,PAY_BLCK_KEY_CD                                                             " ).append("\n"); 
		query.append("	,CRE_USR_ID                                                                  " ).append("\n"); 
		query.append("	,CRE_DT                                                                      " ).append("\n"); 
		query.append("	,UPD_USR_ID                                                                  " ).append("\n"); 
		query.append("	,UPD_DT                                                                      " ).append("\n"); 
		query.append("	,IF_FLG                                                                      " ).append("\n"); 
		query.append("	,IF_FILE_ID                                                                  " ).append("\n"); 
		query.append("	,IF_DT                                                                       " ).append("\n"); 
		query.append("	,ERP_IF_ERR_FLG                                                              " ).append("\n"); 
		query.append("	,ERP_IF_ERR_RSN    " ).append("\n"); 
		query.append("    ,N1ST_LODG_PORT_CD" ).append("\n"); 
		query.append("	,N1ST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append("	,LST_DCHG_PORT_CD" ).append("\n"); 
		query.append("	,LST_DCHG_PORT_ETA_DT" ).append("\n"); 
		query.append("	,TRD_CD" ).append("\n"); 
		query.append("	,TRNK_VVD_CD  " ).append("\n"); 
		query.append("    ,REC_TP_CD" ).append("\n"); 
		query.append("    ,SLAN_CD" ).append("\n"); 
		query.append("    ,BKG_QTY" ).append("\n"); 
		query.append("    ,ASA_FLG" ).append("\n"); 
		query.append(") VALUES(    " ).append("\n"); 
		query.append("	 @[ar_if_seq]" ).append("\n"); 
		query.append("	,@[if_seq_no]" ).append("\n"); 
		query.append("	,@[rec_id]" ).append("\n"); 
		query.append("	,@[acct_co_cd]" ).append("\n"); 
		query.append("	,@[if_doc_tp_cd]" ).append("\n"); 
		query.append("	,@[doc_dt]" ).append("\n"); 
		query.append("	,@[pst_dt]" ).append("\n"); 
		query.append("	,@[ref_doc_no]" ).append("\n"); 
		query.append("	,@[doc_hdr_cd]" ).append("\n"); 
		query.append("	,@[curr_cd]" ).append("\n"); 
		query.append("	,@[tax_calc_auto_flg]" ).append("\n"); 
		query.append("	,@[pst_key_cd]" ).append("\n"); 
		query.append("	,@[vat_tax_cd]" ).append("\n"); 
		query.append("	,@[locl_amt]" ).append("\n"); 
		query.append("	,@[doc_amt]" ).append("\n"); 
		query.append("	,@[locl_tax_amt]" ).append("\n"); 
		query.append("	,@[doc_tax_amt]" ).append("\n"); 
		query.append("	,@[asgn_no]" ).append("\n"); 
		query.append("	,@[itm_desc]" ).append("\n"); 
		query.append("	,@[pln_dt]" ).append("\n"); 
		query.append("	,@[cost_ctr_cd]" ).append("\n"); 
		query.append("	,@[ord_no]" ).append("\n"); 
		query.append("	,@[mn_aset_no]" ).append("\n"); 
		query.append("	,@[sub_aset_no]" ).append("\n"); 
		query.append("	,@[aset_tj_tp_cd]" ).append("\n"); 
		query.append("	,@[aset_val_dt]" ).append("\n"); 
		query.append("	,@[gl_acct_no]" ).append("\n"); 
		query.append("	,@[cust_no]" ).append("\n"); 
		query.append("	,@[vndr_crtr_acct_no]" ).append("\n"); 
		query.append("	,@[due_dt_calc_bsel_dt]" ).append("\n"); 
		query.append("	,@[pay_mzd_cd]" ).append("\n"); 
		query.append("	,@[ste_cntrl_bank_ind_cd]" ).append("\n"); 
		query.append("	,@[mtrl_no]" ).append("\n"); 
		query.append("	,@[fuel_land_qty]" ).append("\n"); 
		query.append("	,@[meas_bse_ut_cd]" ).append("\n"); 
		query.append("	,@[pfitctr_cd]" ).append("\n"); 
		query.append("	,@[altn_acct_no]" ).append("\n"); 
		query.append("	,@[biz_prnr_ref_key_cd1]" ).append("\n"); 
		query.append("	,@[biz_prnr_ref_key_cd2]" ).append("\n"); 
		query.append("	,@[line_itm_ref_key_cd]" ).append("\n"); 
		query.append("	,@[instr_key_cd1]" ).append("\n"); 
		query.append("	,@[instr_key_cd2]" ).append("\n"); 
		query.append("	,@[instr_key_cd3]" ).append("\n"); 
		query.append("	,@[pay_ref_cd]" ).append("\n"); 
		query.append("	,@[automtc_pay_curr_cd]" ).append("\n"); 
		query.append("	,@[pay_curr_amt]" ).append("\n"); 
		query.append("	,@[ctrt_no]" ).append("\n"); 
		query.append("	,@[ctrt_tp_cd]" ).append("\n"); 
		query.append("	,@[pay_rsn_cd]" ).append("\n"); 
		query.append("	,@[clss_cd]" ).append("\n"); 
		query.append("	,@[act_plc_cd]" ).append("\n"); 
		query.append("	,@[entr_expn_id]" ).append("\n"); 
		query.append("	,@[bud_mgmt_div_cd]" ).append("\n"); 
		query.append("	,@[act_dt]" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,@[vvl_cd]" ).append("\n"); 
		query.append("	,@[hus_bank_id]" ).append("\n"); 
		query.append("	,@[pay_blck_key_cd]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,DECODE(@[if_flg],'H','H','N')" ).append("\n"); 
		query.append("	,@[if_file_id]" ).append("\n"); 
		query.append("	,@[if_dt]" ).append("\n"); 
		query.append("	,@[erp_if_err_flg]" ).append("\n"); 
		query.append("	,@[erp_if_err_rsn]" ).append("\n"); 
		query.append("    ,@[n1st_lodg_port_cd]" ).append("\n"); 
		query.append("	,TO_DATE(SUBSTR(@[n1st_lodg_port_etd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,@[lst_dchg_port_cd]" ).append("\n"); 
		query.append("	,TO_DATE(SUBSTR(@[lst_dchg_port_eta_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,@[trd_cd]" ).append("\n"); 
		query.append("	,@[trnk_vvd_cd]" ).append("\n"); 
		query.append("    ,@[rec_tp_cd]" ).append("\n"); 
		query.append("    ,@[slan_cd]" ).append("\n"); 
		query.append("    ,@[bkg_qty]" ).append("\n"); 
		query.append("    ,@[asa_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}