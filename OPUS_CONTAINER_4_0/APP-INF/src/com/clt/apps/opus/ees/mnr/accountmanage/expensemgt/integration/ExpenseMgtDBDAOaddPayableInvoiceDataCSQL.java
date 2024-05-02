/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExpenseMgtDBDAOaddPayableInvoiceDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOaddPayableInvoiceDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOaddPayableInvoiceDataCSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOaddPayableInvoiceDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_rjct_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_rjct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_trns_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOaddPayableInvoiceDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_PAY_INV_WRK (" ).append("\n"); 
		query.append("PAY_INV_SEQ" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",ORD_VNDR_SEQ" ).append("\n"); 
		query.append(",MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",BZC_AMT" ).append("\n"); 
		query.append(",VAT_AMT" ).append("\n"); 
		query.append(",SLS_TAX_AMT" ).append("\n"); 
		query.append(",WHLD_TAX_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",MNR_INP_TP_CD" ).append("\n"); 
		query.append(",MNR_INV_STS_CD" ).append("\n"); 
		query.append(",MNR_INV_RJCT_FLG" ).append("\n"); 
		query.append(",HLD_FLG" ).append("\n"); 
		query.append(",INV_CFM_DT" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",ISS_DT" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",RCV_DT" ).append("\n"); 
		query.append(",ISS_OFC_CD" ).append("\n"); 
		query.append(",TTL_LSS_DIV_CD" ).append("\n"); 
		query.append(",INV_RGST_NO" ).append("\n"); 
		query.append(",MNR_INV_RMK" ).append("\n"); 
		query.append(",CHK_TRNS_NO" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",GL_DT" ).append("\n"); 
		query.append(",INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",MNR_INV_REF_NO" ).append("\n"); 
		query.append(",MNR_INV_RJCT_DT" ).append("\n"); 
		query.append(",MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(",PAY_DT" ).append("\n"); 
		query.append(",PROV_USR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[pay_inv_seq]" ).append("\n"); 
		query.append(",@[inv_no]" ).append("\n"); 
		query.append(",TO_NUMBER(@[ord_vndr_seq])" ).append("\n"); 
		query.append(",TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append(",REPLACE (NVL(@[bzc_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",REPLACE (NVL(@[vat_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",REPLACE (NVL(@[sls_tax_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",REPLACE (NVL(@[whld_tax_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",REPLACE (NVL(@[ttl_amt],'0'), ',', '')" ).append("\n"); 
		query.append(",@[gen_pay_term_cd]" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[mnr_inp_tp_cd]" ).append("\n"); 
		query.append(",@[mnr_inv_sts_cd]" ).append("\n"); 
		query.append(",@[mnr_inv_rjct_flg]" ).append("\n"); 
		query.append(",@[hld_flg]" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'HC')" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TO_DATE(@[inv_cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TO_DATE(@[cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",TO_DATE(@[iss_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TO_DATE(@[eff_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TO_DATE(@[rcv_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",@[iss_ofc_cd]" ).append("\n"); 
		query.append(",@[ttl_lss_div_cd]" ).append("\n"); 
		query.append(",@[inv_rgst_no]" ).append("\n"); 
		query.append(",@[mnr_inv_rmk]" ).append("\n"); 
		query.append(",@[chk_trns_no]" ).append("\n"); 
		query.append(",@[csr_no]" ).append("\n"); 
		query.append(",@[gl_dt]" ).append("\n"); 
		query.append(",@[inv_pay_mzd_cd]" ).append("\n"); 
		query.append(",@[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",@[mnr_inv_ref_no]" ).append("\n"); 
		query.append(",@[mnr_inv_rjct_dt]" ).append("\n"); 
		query.append(",@[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append(",@[mnr_prnr_tp_cd]" ).append("\n"); 
		query.append(",@[pay_dt]" ).append("\n"); 
		query.append(",@[prov_usr_id]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}