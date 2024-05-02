/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.27 
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

public class AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ap_pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_grp_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_request_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creation_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_attribute_category",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_src_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("glo_attr_ctnt16",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("functional_amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_INV_HDR" ).append("\n"); 
		query.append("(  INV_SEQ" ).append("\n"); 
		query.append(" , VNDR_NO" ).append("\n"); 
		query.append(" , INV_NO" ).append("\n"); 
		query.append(" , INV_CURR_CD" ).append("\n"); 
		query.append(" , INV_PAY_CURR_CD" ).append("\n"); 
		query.append(" , INV_AMT" ).append("\n"); 
		query.append(" , INV_PAY_AMT" ).append("\n"); 
		query.append(" , INV_DT" ).append("\n"); 
		query.append(" , AP_INV_SRC_CD" ).append("\n"); 
		query.append(" , INV_TP_LU_CD" ).append("\n"); 
		query.append(" , INV_DESC" ).append("\n"); 
		query.append(" , BAT_SEQ" ).append("\n"); 
		query.append(" , INV_VAT_AMT" ).append("\n"); 
		query.append(" , INV_TERM_NM" ).append("\n"); 
		query.append(" , INV_TERM_DT" ).append("\n"); 
		query.append(" , PAY_MZD_LU_CD" ).append("\n"); 
		query.append(" , AP_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(" , LIAB_COA_CO_CD" ).append("\n"); 
		query.append(" , LIAB_COA_RGN_CD" ).append("\n"); 
		query.append(" , LIAB_COA_CTR_CD" ).append("\n"); 
		query.append(" , LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append(" , LIAB_COA_VVD_CD" ).append("\n"); 
		query.append(" , LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(" , PAY_STS_FLG" ).append("\n"); 
		query.append(" , INV_FUNC_AMT" ).append("\n"); 
		query.append(" , INV_VAT_CD" ).append("\n"); 
		query.append(" , INV_XCH_RT" ).append("\n"); 
		query.append(" , INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , INV_XCH_DT" ).append("\n"); 
		query.append(" , ERY_STL_DT" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , ATTR_CTNT11" ).append("\n"); 
		query.append(" , ATTR_CTNT12" ).append("\n"); 
		query.append(" , ATTR_CTNT13" ).append("\n"); 
		query.append(" , ATTR_CTNT14" ).append("\n"); 
		query.append(" , ATTR_CTNT15" ).append("\n"); 
		query.append(" , ATTR_CATE_NM" ).append("\n"); 
		query.append(" , AP_APSTS_CD" ).append("\n"); 
		query.append(" , INV_CXL_DT" ).append("\n"); 
		query.append(" , CXL_USR_ID" ).append("\n"); 
		query.append(" , INV_CXL_AMT" ).append("\n"); 
		query.append(" , OFC_CD" ).append("\n"); 
		query.append(" , GLO_ATTR_CATE_NM" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append(" , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append(" , PAY_CURR_INV_AMT" ).append("\n"); 
		query.append(" , GL_DT" ).append("\n"); 
		query.append(" , INV_APRO_RDY_FLG" ).append("\n"); 
		query.append(" , DTRB_SET_SEQ" ).append("\n"); 
		query.append(" , XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  @[inv_seq]" ).append("\n"); 
		query.append(" , @[vndr_no]" ).append("\n"); 
		query.append(" , @[inv_no]" ).append("\n"); 
		query.append(" , @[inv_curr_cd]" ).append("\n"); 
		query.append(" , @[inv_pay_curr_cd]" ).append("\n"); 
		query.append(" , ROUND(TO_NUMBER(REPLACE(@[inv_amt], ',', '')), 3) " ).append("\n"); 
		query.append(" , 0" ).append("\n"); 
		query.append(" , TO_DATE( @[inv_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(" , @[if_src_nm]" ).append("\n"); 
		query.append(" , @[inv_tp_lu_cd]" ).append("\n"); 
		query.append(" , @[inv_desc]" ).append("\n"); 
		query.append(" , @[if_request_seq]" ).append("\n"); 
		query.append(" , ROUND(TO_NUMBER(REPLACE(@[inv_vat_amt], ',', '')), 3)" ).append("\n"); 
		query.append(" , @[inv_term_nm]" ).append("\n"); 
		query.append(" , TO_DATE( @[inv_term_dt] , 'YYYYMMDD' ) " ).append("\n"); 
		query.append(" , @[ap_pay_mzd_lu_cd]" ).append("\n"); 
		query.append(" , @[pay_grp_lu_cd]" ).append("\n"); 
		query.append(" , @[liab_coa_co_cd]" ).append("\n"); 
		query.append(" , @[liab_coa_rgn_cd]" ).append("\n"); 
		query.append(" , @[liab_coa_ctr_cd]" ).append("\n"); 
		query.append(" , @[liab_coa_acct_no]" ).append("\n"); 
		query.append(" , @[liab_coa_vvd_cd]" ).append("\n"); 
		query.append(" , @[liab_coa_inter_co_cd]" ).append("\n"); 
		query.append(" , 'N'" ).append("\n"); 
		query.append(" , @[functional_amount]" ).append("\n"); 
		query.append(" , @[inv_vat_cd]" ).append("\n"); 
		query.append(" , @[inv_xch_rt]" ).append("\n"); 
		query.append(" , @[inv_xch_rt_tp_cd]" ).append("\n"); 
		query.append(" , TO_DATE(@[inv_xch_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(" , DECODE(@[inv_tp_lu_cd], 'PREPAYMENT', SYSDATE, '')" ).append("\n"); 
		query.append(" , @[attr_ctnt1]" ).append("\n"); 
		query.append(" , @[attr_ctnt2]" ).append("\n"); 
		query.append(" , @[attr_ctnt3]" ).append("\n"); 
		query.append(" , @[attr_ctnt4]" ).append("\n"); 
		query.append(" , @[attr_ctnt5]" ).append("\n"); 
		query.append(" , @[attr_ctnt6]" ).append("\n"); 
		query.append(" , @[attr_ctnt7]" ).append("\n"); 
		query.append(" , @[attr_ctnt8]" ).append("\n"); 
		query.append(" , @[attr_ctnt9]" ).append("\n"); 
		query.append(" , @[attr_ctnt10]" ).append("\n"); 
		query.append(" , @[attr_ctnt11]" ).append("\n"); 
		query.append(" , @[attr_ctnt12]" ).append("\n"); 
		query.append(" , @[attr_ctnt13]" ).append("\n"); 
		query.append(" , @[attr_ctnt14]" ).append("\n"); 
		query.append(" , @[attr_ctnt15]" ).append("\n"); 
		query.append(" , @[l_attribute_category]" ).append("\n"); 
		query.append(" , 'NOT REQUIRED'" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , @[ofc_cd]" ).append("\n"); 
		query.append(" , @[glo_attr_cate_nm]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt1]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt2]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt3]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt4]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt5]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt6]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt7]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt8]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt9]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt10]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt11]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt12]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt13]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt14]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt15]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt16]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt17]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt18]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt19]" ).append("\n"); 
		query.append(" , @[glo_attr_ctnt20]" ).append("\n"); 
		query.append(" , 0" ).append("\n"); 
		query.append(" , REPLACE(@[gl_dt], '-', '')" ).append("\n"); 
		query.append(" , 'N'" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , @[vndr_bank_acct_seq]" ).append("\n"); 
		query.append(" , @[creation_user]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[liab_cd_cmb_seq]" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}