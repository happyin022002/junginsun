/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOAddInvoiceMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOAddInvoiceMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOAddInvoiceMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cgst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_payr_cntc_pnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_payr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_igst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ar_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_hld_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_edu_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cgst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_igst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_inv_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("ida_expn_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sgst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_ugst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_new_rpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_hld_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_expn_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_n2nd_locl_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_high_edu_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_ugst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_inv_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_edu_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_locl_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_locl_tax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sgst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_knt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_high_edu_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_payr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_mnl_inv_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caller",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_n2nd_locl_tax",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tax_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOAddInvoiceMainCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_INV_MN (" ).append("\n"); 
		query.append("	 TAX_RTO" ).append("\n"); 
		query.append("	,TAX_AMT" ).append("\n"); 
		query.append("	,INV_AMT" ).append("\n"); 
		query.append("	,AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append("	,CR_INV_NO" ).append("\n"); 
		query.append("	,INV_RMK" ).append("\n"); 
		query.append("	,DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	,AR_IF_NO" ).append("\n"); 
		query.append("	,AR_IF_DT" ).append("\n"); 
		query.append("	,AR_IF_USR_ID" ).append("\n"); 
		query.append("	,AR_IF_OFC_CD" ).append("\n"); 
		query.append("	,NTC_KNT_CD" ).append("\n"); 
		query.append("	,DMDT_INV_STS_CD" ).append("\n"); 
		query.append("	,DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append("	,CXL_RMK" ).append("\n"); 
		query.append("	,INV_HLD_RSN_CD" ).append("\n"); 
		query.append("	,INV_HLD_RMK" ).append("\n"); 
		query.append("	,INV_PRT_FLG" ).append("\n"); 
		query.append("	,INV_REF_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_OFC_CD" ).append("\n"); 
		query.append("	,DMDT_INV_NO" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,DMDT_TRF_CD" ).append("\n"); 
		query.append("	,IO_BND_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_TP_CD" ).append("\n"); 
		query.append("	,MNL_INP_FLG" ).append("\n"); 
		query.append("	,MNL_INV_SND_FLG" ).append("\n"); 
		query.append("	,DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append("	,MNL_INV_RMK" ).append("\n"); 
		query.append("	,BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,CUST_CNT_CD" ).append("\n"); 
		query.append("	,CUST_SEQ" ).append("\n"); 
		query.append("	,DMDT_PAYR_TP_CD" ).append("\n"); 
		query.append("	,ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("	,ACT_PAYR_SEQ" ).append("\n"); 
		query.append("	,DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("	,CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("	,POR_CD" ).append("\n"); 
		query.append("	,POL_CD" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,SC_NO" ).append("\n"); 
		query.append("	,RFA_NO" ).append("\n"); 
		query.append("	,CHG_CURR_CD" ).append("\n"); 
		query.append("	,ORG_CHG_AMT" ).append("\n"); 
		query.append("	,DMDT_EXPT_AMT" ).append("\n"); 
		query.append("	,DC_AMT" ).append("\n"); 
		query.append("	,BIL_AMT" ).append("\n"); 
		query.append("	,BKG_CNTR_QTY" ).append("\n"); 
		query.append("	,INV_CURR_CD" ).append("\n"); 
		query.append("	,INV_XCH_RT" ).append("\n"); 
		query.append("	,INV_CHG_AMT" ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("	,BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("	,IDA_EXPN_TAX_RT" ).append("\n"); 
		query.append("	,IDA_EXPN_TAX   " ).append("\n"); 
		query.append("	,IDA_EDU_TAX_RT" ).append("\n"); 
		query.append("	,IDA_EDU_TAX   " ).append("\n"); 
		query.append("	,IDA_HIGH_EDU_TAX_RT" ).append("\n"); 
		query.append("	,IDA_HIGH_EDU_TAX" ).append("\n"); 
		query.append("	,INV_NEW_RPT_FLG" ).append("\n"); 
		query.append("	,IDA_LOCL_TAX_RT" ).append("\n"); 
		query.append("	,IDA_LOCL_TAX   " ).append("\n"); 
		query.append("	,IDA_N2ND_LOCL_TAX_RT" ).append("\n"); 
		query.append("	,IDA_N2ND_LOCL_TAX   " ).append("\n"); 
		query.append("	,TAA_NO" ).append("\n"); 
		query.append("	,IDA_CGST_RTO" ).append("\n"); 
		query.append("	,IDA_CGST_AMT" ).append("\n"); 
		query.append("	,IDA_SGST_RTO" ).append("\n"); 
		query.append("	,IDA_SGST_AMT" ).append("\n"); 
		query.append("	,IDA_IGST_RTO" ).append("\n"); 
		query.append("	,IDA_IGST_AMT" ).append("\n"); 
		query.append("	,IDA_UGST_RTO" ).append("\n"); 
		query.append("	,IDA_UGST_AMT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	 @[tax_rto]" ).append("\n"); 
		query.append("	,@[tax_amt]" ).append("\n"); 
		query.append("	,@[inv_amt]" ).append("\n"); 
		query.append("	,@[aft_expt_apro_no]" ).append("\n"); 
		query.append("	,@[aft_inv_adj_amt]" ).append("\n"); 
		query.append("	,@[cr_inv_no]" ).append("\n"); 
		query.append("	,@[inv_rmk1]||chr(10)||@[inv_rmk2]" ).append("\n"); 
		query.append("	,@[dmdt_ar_if_cd]" ).append("\n"); 
		query.append("	,@[ar_if_no]" ).append("\n"); 
		query.append("	,TO_DATE(@[ar_if_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	,@[ar_if_usr_id]" ).append("\n"); 
		query.append("	,@[ar_if_ofc_cd]" ).append("\n"); 
		query.append("	,@[ntc_knt_cd]" ).append("\n"); 
		query.append("	,@[dmdt_inv_sts_cd]" ).append("\n"); 
		query.append("	,@[dmdt_cxl_rsn_cd]" ).append("\n"); 
		query.append("	,@[cxl_rmk]" ).append("\n"); 
		query.append("	,@[inv_hld_rsn_cd]" ).append("\n"); 
		query.append("	,@[inv_hld_rmk]" ).append("\n"); 
		query.append("	,@[inv_prt_flg]" ).append("\n"); 
		query.append("	,@[inv_ref_no]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,@[upd_ofc_cd]" ).append("\n"); 
		query.append("	,@[dmdt_inv_no]" ).append("\n"); 
		query.append("	,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,@[dmdt_trf_cd]" ).append("\n"); 
		query.append("	,@[io_bnd_cd]" ).append("\n"); 
		query.append("	,@[dmdt_chg_tp_cd]" ).append("\n"); 
		query.append("	,@[mnl_inp_flg]" ).append("\n"); 
		query.append("	,@[mnl_inv_snd_flg]" ).append("\n"); 
		query.append("	,@[dmdt_mnl_inv_rsn_cd]" ).append("\n"); 
		query.append("	,@[mnl_inv_rmk]" ).append("\n"); 
		query.append("	,@[bkg_no]" ).append("\n"); 
		query.append("	,@[bl_no]" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,@[skd_voy_no]" ).append("\n"); 
		query.append("	,@[skd_dir_cd]" ).append("\n"); 
		query.append("	,@[cust_cnt_cd]" ).append("\n"); 
		query.append("	,@[cust_seq]" ).append("\n"); 
		query.append("	,@[dmdt_payr_tp_cd]" ).append("\n"); 
		query.append("	,@[act_payr_cnt_cd]" ).append("\n"); 
		query.append("	,@[act_payr_seq]" ).append("\n"); 
		query.append("	,@[dmdt_payr_cntc_pnt_nm]" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[cust_cntc_pnt_seq]  ), 'UNDEFINED', null, @[cust_cntc_pnt_seq]    ) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,@[por_cd]" ).append("\n"); 
		query.append("	,@[pol_cd]" ).append("\n"); 
		query.append("	,@[pod_cd]" ).append("\n"); 
		query.append("	,@[del_cd]" ).append("\n"); 
		query.append("	,@[sc_no]" ).append("\n"); 
		query.append("	,@[rfa_no]" ).append("\n"); 
		query.append("	,@[chg_curr_cd]" ).append("\n"); 
		query.append("	,@[org_chg_amt]" ).append("\n"); 
		query.append("	,@[dmdt_expt_amt]" ).append("\n"); 
		query.append("	,@[dc_amt]" ).append("\n"); 
		query.append("	,@[bil_amt]" ).append("\n"); 
		query.append("	,@[bkg_cntr_qty]" ).append("\n"); 
		query.append("	,@[inv_curr_cd]" ).append("\n"); 
		query.append("	,@[inv_xch_rt]" ).append("\n"); 
		query.append("	,@[inv_chg_amt]" ).append("\n"); 
		query.append("	,@[vndr_seq]" ).append("\n"); 
		query.append("	,@[rcv_term_cd]" ).append("\n"); 
		query.append("	,@[de_term_cd]" ).append("\n"); 
		query.append("	,DECODE(@[caller], '4016', 'Y', 'N')" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_expn_tax_rt]    	), 'NULL', null, @[ida_expn_tax_rt]    	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_expn_tax]       	), 'NULL', null, @[ida_expn_tax]       	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_edu_tax_rt]     	), 'NULL', null, @[ida_edu_tax_rt]     	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_edu_tax]        	), 'NULL', null, @[ida_edu_tax]        	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_high_edu_tax_rt]	), 'NULL', null, @[ida_high_edu_tax_rt]	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_high_edu_tax]   	), 'NULL', null, @[ida_high_edu_tax]   	) -- 2013.03.27 (ALPS 통합 로그 Error) null 문자 처리를 함." ).append("\n"); 
		query.append("	,NVL(@[inv_new_rpt_flg],'N')" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_locl_tax_rt]    	), 'NULL', null, @[ida_locl_tax_rt]    	) " ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_locl_tax]       	), 'NULL', null, @[ida_locl_tax]       	) " ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_n2nd_locl_tax_rt]   ), 'NULL', null, @[ida_n2nd_locl_tax_rt]) " ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_n2nd_locl_tax]      ), 'NULL', null, @[ida_n2nd_locl_tax]   ) " ).append("\n"); 
		query.append("	,@[taa_no]" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_cgst_rto]), 'NULL', null, @[ida_cgst_rto])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_cgst_amt]), 'NULL', null, @[ida_cgst_amt])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_sgst_rto]), 'NULL', null, @[ida_sgst_rto])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_sgst_amt]), 'NULL', null, @[ida_sgst_amt])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_igst_rto]), 'NULL', null, @[ida_igst_rto])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_igst_amt]), 'NULL', null, @[ida_igst_amt])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_ugst_rto]), 'NULL', null, @[ida_ugst_rto])" ).append("\n"); 
		query.append("	,DECODE(UPPER(@[ida_ugst_amt]), 'NULL', null, @[ida_ugst_amt])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}