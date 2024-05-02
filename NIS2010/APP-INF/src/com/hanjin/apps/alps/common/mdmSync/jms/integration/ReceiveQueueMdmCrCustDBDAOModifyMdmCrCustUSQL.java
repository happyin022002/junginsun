/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveQueueMdmCrCustDBDAOModifyMdmCrCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCrCustDBDAOModifyMdmCrCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMdmCrCust
	  * </pre>
	  */
	public ReceiveQueueMdmCrCustDBDAOModifyMdmCrCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_local_charge_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_wk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_hjs_referance_phone_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_local_charge_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_customer_referance_number_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rlse_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_indiv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_hjs_referance_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_email",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_ofc_cng_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_curr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cr_due_dt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rlse_ctrl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_cr_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dy_xch_aply_st_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ib_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_hjs_referance_phone_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_ib_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_customer_referance_number_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_kr_ib_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_email",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_inbound_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_due_dt_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_invoice_outbound_hjs_referance_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("riss_inv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCrCustDBDAOModifyMdmCrCustUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CR_CUST " ).append("\n"); 
		query.append("   SET act_cust_cnt_cd          = @[act_cust_cnt_cd]," ).append("\n"); 
		query.append("       act_cust_seq             = @[act_cust_seq]," ).append("\n"); 
		query.append("       cust_rlse_ctrl_flg       = @[cust_rlse_ctrl_flg]," ).append("\n"); 
		query.append("       cr_flg                   = @[cr_flg]," ).append("\n"); 
		query.append("       cr_curr_cd               = @[cr_curr_cd]," ).append("\n"); 
		query.append("       cr_amt                   = @[cr_amt]," ).append("\n"); 
		query.append("       cr_clt_ofc_cd            = @[cr_clt_ofc_cd]," ).append("\n"); 
		query.append("       cr_cust_rmk              = HJSEAI_PKG.H_DECODE(@[cr_cust_rmk], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       ib_cr_term_dys           = @[ib_cr_term_dys]," ).append("\n"); 
		query.append("       ob_cr_term_dys           = @[ob_cr_term_dys]," ).append("\n"); 
		query.append("       pay_div_cd               = @[pay_div_cd]," ).append("\n"); 
		query.append("       cr_st_dt                 = SUBSTR(@[cr_st_dt],1,8)," ).append("\n"); 
		query.append("       cr_end_dt                = SUBSTR(@[cr_end_dt],1,8)," ).append("\n"); 
		query.append("       cr_cust_tp_cd            = @[cr_cust_tp_cd]," ).append("\n"); 
		query.append("       kr_ib_ofc_cd             = @[kr_ib_ofc_cd]," ).append("\n"); 
		query.append("       ob_eml                   = @[ob_eml]," ).append("\n"); 
		query.append("       ib_eml                   = @[ib_eml]," ).append("\n"); 
		query.append("       ob_phn_no                = @[ob_phn_no]," ).append("\n"); 
		query.append("       ib_phn_no                = @[ib_phn_no]," ).append("\n"); 
		query.append("       ob_fax_no                = @[ob_fax_no]," ).append("\n"); 
		query.append("       ib_fax_no                = @[ib_fax_no]," ).append("\n"); 
		query.append("       xch_rt_div_cd            = @[xch_rt_div_cd]," ).append("\n"); 
		query.append("       cng_indiv_cd             = @[cng_indiv_cd]," ).append("\n"); 
		query.append("       dy_xch_aply_st_dt        = SUBSTR(@[dy_xch_aply_st_dt],1,8)," ).append("\n"); 
		query.append("       iss_div_cd               = @[iss_div_cd]," ).append("\n"); 
		query.append("       bank_acct_no             = @[bank_acct_no]," ).append("\n"); 
		query.append("       cntc_pson_nm             = HJSEAI_PKG.H_DECODE(@[cntc_pson_nm], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       cust_cr_due_dt_div_cd    = @[cust_cr_due_dt_div_cd]," ).append("\n"); 
		query.append("       ownr_nm                  = HJSEAI_PKG.H_DECODE(@[ownr_nm], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       bzct_nm                  = HJSEAI_PKG.H_DECODE(@[bzct_nm], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       bztp_nm                  = HJSEAI_PKG.H_DECODE(@[bztp_nm], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       pay_dt_dy1               = @[pay_dt_dy1]," ).append("\n"); 
		query.append("       pay_dt_dy2               = @[pay_dt_dy2]," ).append("\n"); 
		query.append("       pay_dt_dy3               = @[pay_dt_dy3]," ).append("\n"); 
		query.append("       pay_dt_dy4               = @[pay_dt_dy4]," ).append("\n"); 
		query.append("       locl_nm                  = HJSEAI_PKG.H_DECODE(@[locl_nm], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       locl_addr1               = HJSEAI_PKG.H_DECODE(@[locl_addr1], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       locl_addr2               = HJSEAI_PKG.H_DECODE(@[locl_addr2], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       locl_addr3               = HJSEAI_PKG.H_DECODE(@[locl_addr3], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       locl_addr4               = HJSEAI_PKG.H_DECODE(@[locl_addr4], 'UTF8' ,'UTF8')," ).append("\n"); 
		query.append("       locl_zip_cd              = @[locl_zip_cd]," ).append("\n"); 
		query.append("       bfr_cr_clt_ofc_cd        = @[bfr_cr_clt_ofc_cd]," ).append("\n"); 
		query.append("       bfr_ofc_cng_dt           = TO_DATE(@[bfr_ofc_cng_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       bfr_kr_ib_ofc_cd         = @[bfr_kr_ib_ofc_cd]," ).append("\n"); 
		query.append("       inv_due_dt_dp_flg        = @[inv_due_dt_dp_flg]," ).append("\n"); 
		query.append("       cre_usr_id               = @[cre_usr_id]," ).append("\n"); 
		query.append("       cre_dt                   = TO_DATE(@[cre_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       upd_usr_id               = @[upd_usr_id]," ).append("\n"); 
		query.append("       upd_dt                   = TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       delt_flg                 = @[delt_flg]," ).append("\n"); 
		query.append("       eai_evnt_dt              = TO_DATE(@[eai_evnt_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("	   riss_inv_flg				= @[riss_inv_flg]," ).append("\n"); 
		query.append("	   inv_iss_curr_tp_cd		= @[inv_iss_curr_tp_cd]," ).append("\n"); 
		query.append("       eai_if_id        		= @[eai_if_id]," ).append("\n"); 
		query.append("       cust_rlse_ctrl_rmk       = @[cust_rlse_ctrl_rmk]," ).append("\n"); 
		query.append("       sub_sys_nm               = @[sub_sys_nm]," ).append("\n"); 
		query.append("	   auto_inv_ib_flg				= @[auto_invoice_inbound_flag]," ).append("\n"); 
		query.append("	   auto_inv_ib_hjs_ref_no		= @[auto_invoice_inbound_hjs_referance_number]," ).append("\n"); 
		query.append("	   auto_inv_ib_hjs_ref_phn_no	= @[auto_invoice_inbound_hjs_referance_phone_number]," ).append("\n"); 
		query.append("	   auto_inv_ib_cust_ref_no_flg	= @[auto_invoice_inbound_customer_referance_number_flag]," ).append("\n"); 
		query.append("	   auto_inv_ib_locl_chg_flg		= @[auto_invoice_inbound_local_charge_flag]," ).append("\n"); 
		query.append("	   auto_inv_ib_eml				= @[auto_invoice_inbound_email]," ).append("\n"); 
		query.append("	   auto_inv_ob_flg				= @[auto_invoice_outbound_flag]," ).append("\n"); 
		query.append("	   auto_inv_ob_hjs_ref_no		= @[auto_invoice_outbound_hjs_referance_number]," ).append("\n"); 
		query.append("	   auto_inv_ob_hjs_ref_phn_no	= @[auto_invoice_outbound_hjs_referance_phone_number]," ).append("\n"); 
		query.append("	   auto_inv_ob_cust_ref_no_flg	= @[auto_invoice_outbound_customer_referance_number_flag]," ).append("\n"); 
		query.append("	   auto_inv_ob_locl_chg_flg		= @[auto_invoice_outbound_local_charge_flag]," ).append("\n"); 
		query.append("	   auto_inv_ob_eml				= @[auto_invoice_outbound_email]," ).append("\n"); 
		query.append("	   pay_dt_dy5					= @[pay_dt_dy5]," ).append("\n"); 
		query.append("       pay_wk_dy_cd					= @[pay_wk_dy_cd]," ).append("\n"); 
		query.append("       pay_tp_cd					= @[pay_tp_cd]" ).append("\n"); 
		query.append(" WHERE cust_cnt_cd              = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND cust_seq 	            = @[cust_seq]" ).append("\n"); 
		query.append("   AND eai_evnt_dt              <= TO_DATE(@[eai_evnt_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}