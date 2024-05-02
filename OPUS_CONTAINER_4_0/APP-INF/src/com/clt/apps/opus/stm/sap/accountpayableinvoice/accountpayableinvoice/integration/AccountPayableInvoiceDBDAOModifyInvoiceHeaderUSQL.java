/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInvoiceHeaderUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInvoiceHeaderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAP_INV_HDR 자료를 UPDATE
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInvoiceHeaderUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cxl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_inv_src_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_vat_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_apro_rdy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("liab_coa_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_set_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_curr_inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ery_stl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cxl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glo_attr_ctnt20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_func_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInvoiceHeaderUSQL").append("\n"); 
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
		query.append("UPDATE SAP_INV_HDR" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("   VNDR_NO	=	@[vndr_no]" ).append("\n"); 
		query.append(" , INV_NO	=	@[inv_no]" ).append("\n"); 
		query.append(" , INV_CURR_CD	=	@[inv_curr_cd]" ).append("\n"); 
		query.append(" , INV_PAY_CURR_CD	=	@[inv_pay_curr_cd]" ).append("\n"); 
		query.append(" , INV_AMT	=	ROUND( TO_NUMBER( REPLACE( @[inv_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , INV_PAY_AMT	=	ROUND( TO_NUMBER( REPLACE( NVL( @[inv_pay_amt], '0' ) , ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , INV_DT	=	TO_DATE(REPLACE( @[inv_dt], '-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append(" , AP_INV_SRC_CD	=	NVL( @[ap_inv_src_cd], AP_INV_SRC_CD)" ).append("\n"); 
		query.append(" , INV_TP_LU_CD	=	@[inv_tp_lu_cd]" ).append("\n"); 
		query.append(" , INV_DESC	=	NVL( @[inv_desc], INV_DESC) " ).append("\n"); 
		query.append(" , BAT_SEQ	=	NVL( @[bat_seq], BAT_SEQ)" ).append("\n"); 
		query.append(" , INV_VAT_AMT	=	ROUND( TO_NUMBER( REPLACE( @[inv_vat_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , INV_TERM_NM	=	@[inv_term_nm]" ).append("\n"); 
		query.append(" , INV_TERM_DT	=	TO_DATE( REPLACE( @[inv_term_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append(" , PAY_MZD_LU_CD	=	@[pay_mzd_lu_cd]" ).append("\n"); 
		query.append(" , AP_PAY_GRP_LU_CD	=	@[ap_pay_grp_lu_cd]" ).append("\n"); 
		query.append(" , LIAB_COA_CO_CD	=	@[liab_coa_co_cd]" ).append("\n"); 
		query.append(" , LIAB_COA_RGN_CD	=	@[liab_coa_rgn_cd]" ).append("\n"); 
		query.append(" , LIAB_COA_CTR_CD	=	@[liab_coa_ctr_cd]" ).append("\n"); 
		query.append(" , LIAB_COA_ACCT_NO	=	@[liab_coa_acct_no]" ).append("\n"); 
		query.append(" , LIAB_COA_VVD_CD	=	@[liab_coa_vvd_cd]" ).append("\n"); 
		query.append(" , LIAB_COA_INTER_CO_CD	=	@[liab_coa_inter_co_cd]" ).append("\n"); 
		query.append(" , PAY_STS_FLG	=	NVL( @[pay_sts_flg], PAY_STS_FLG)" ).append("\n"); 
		query.append(" , INV_FUNC_AMT	=	ROUND( TO_NUMBER( REPLACE( @[inv_func_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , INV_VAT_CD	=	NVL( @[inv_vat_cd], INV_VAT_CD)" ).append("\n"); 
		query.append(" , INV_XCH_RT	=	NVL( @[inv_xch_rt], INV_XCH_RT)" ).append("\n"); 
		query.append(" , INV_XCH_RT_TP_CD	=	NVL( @[inv_xch_rt_tp_cd], INV_XCH_RT_TP_CD	)" ).append("\n"); 
		query.append(" , INV_XCH_DT	=	NVL( TO_DATE( REPLACE( @[inv_xch_dt], '-', ''), 'YYYYMMDD') , INV_XCH_DT )" ).append("\n"); 
		query.append(" , ERY_STL_DT	=	NVL( TO_DATE( REPLACE( @[ery_stl_dt], '-', ''), 'YYYYMMDD') , ERY_STL_DT)" ).append("\n"); 
		query.append(" , ATTR_CTNT1	=	@[attr_ctnt1]" ).append("\n"); 
		query.append(" , ATTR_CTNT2	=	@[attr_ctnt2]" ).append("\n"); 
		query.append(" , ATTR_CTNT3	=	@[attr_ctnt3]" ).append("\n"); 
		query.append(" , ATTR_CTNT4	=	@[attr_ctnt4]" ).append("\n"); 
		query.append(" , ATTR_CTNT5	=	@[attr_ctnt5]" ).append("\n"); 
		query.append(" , ATTR_CTNT6	=	@[attr_ctnt6]" ).append("\n"); 
		query.append(" , ATTR_CTNT7	=	@[attr_ctnt7]" ).append("\n"); 
		query.append(" , ATTR_CTNT8	=	@[attr_ctnt8]" ).append("\n"); 
		query.append(" , ATTR_CTNT9	=	@[attr_ctnt9]" ).append("\n"); 
		query.append(" , ATTR_CTNT10	=	@[attr_ctnt10]" ).append("\n"); 
		query.append(" , ATTR_CTNT11	=	@[attr_ctnt11]" ).append("\n"); 
		query.append(" , ATTR_CTNT12	=	@[attr_ctnt12]" ).append("\n"); 
		query.append(" , ATTR_CTNT13	=	@[attr_ctnt13]" ).append("\n"); 
		query.append(" , ATTR_CTNT14	=	@[attr_ctnt14]" ).append("\n"); 
		query.append(" , ATTR_CTNT15	=	@[attr_ctnt15]" ).append("\n"); 
		query.append(" , ATTR_CATE_NM	=	@[attr_cate_nm]" ).append("\n"); 
		query.append(" , AP_APSTS_CD	=	NVL( @[ap_apsts_cd], AP_APSTS_CD ) " ).append("\n"); 
		query.append(" , INV_CXL_DT	=	NVL( TO_DATE( REPLACE( @[inv_cxl_dt], '-', ''), 'YYYYMMDD') , INV_CXL_DT )" ).append("\n"); 
		query.append(" , CXL_USR_ID	=	NVL( @[cxl_usr_id], CXL_USR_ID )" ).append("\n"); 
		query.append(" , INV_CXL_AMT	=	ROUND( TO_NUMBER( REPLACE( @[inv_cxl_amt], ',', '') ) , 3 ) " ).append("\n"); 
		query.append(" , OFC_CD	=	@[ofc_cd]" ).append("\n"); 
		query.append(" , GLO_ATTR_CATE_NM	=	@[glo_attr_cate_nm]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT1	=	@[glo_attr_ctnt1]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT2	=	@[glo_attr_ctnt2]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT3	=	@[glo_attr_ctnt3]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT4	=	@[glo_attr_ctnt4]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT5	=	@[glo_attr_ctnt5]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT6	=	@[glo_attr_ctnt6]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT7	=	@[glo_attr_ctnt7]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT8	=	@[glo_attr_ctnt8]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT9	=	@[glo_attr_ctnt9]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT10	=	@[glo_attr_ctnt10]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT11	=	@[glo_attr_ctnt11]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT12	=	@[glo_attr_ctnt12]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT13	=	@[glo_attr_ctnt13]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT14	=	@[glo_attr_ctnt14]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT15	=	@[glo_attr_ctnt15]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT16	=	@[glo_attr_ctnt16]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT17	=	@[glo_attr_ctnt17]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT18	=	@[glo_attr_ctnt18]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT19	=	@[glo_attr_ctnt19]" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT20	=	@[glo_attr_ctnt20]" ).append("\n"); 
		query.append(" , PAY_CURR_INV_AMT	=	@[pay_curr_inv_amt]" ).append("\n"); 
		query.append(" , GL_DT	=	REPLACE( @[gl_dt], '-', '')" ).append("\n"); 
		query.append(" , INV_APRO_RDY_FLG	=	NVL( @[inv_apro_rdy_flg], INV_APRO_RDY_FLG )" ).append("\n"); 
		query.append(" , DTRB_SET_SEQ	=	@[dtrb_set_seq]" ).append("\n"); 
		query.append(" , XTER_BANK_ACCT_SEQ	=	NVL( @[xter_bank_acct_seq], XTER_BANK_ACCT_SEQ ) " ).append("\n"); 
		query.append(" , UPD_USR_ID	=	@[usr_id]" ).append("\n"); 
		query.append(" , UPD_DT	=	SYSDATE" ).append("\n"); 
		query.append(" , LIAB_CD_CMB_SEQ	=	NVL( TO_NUMBER( @[liab_cd_cmb_seq] ),LIAB_CD_CMB_SEQ ) " ).append("\n"); 
		query.append("WHERE   INV_SEQ	=	TO_NUMBER( @[inv_seq] )" ).append("\n"); 

	}
}