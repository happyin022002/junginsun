/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueDBDAOaddInvoiceSplitIssueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOaddInvoiceSplitIssueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addInvoiceSplitIssue
	  * </pre>
	  */
	public InvoiceIssueDBDAOaddInvoiceSplitIssueCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_stf_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_acct_prn_opt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_split_iss_wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOaddInvoiceSplitIssueCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  INV_NO" ).append("\n"); 
		query.append(", INV_SEQ" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", ACT_CUST_SEQ" ).append("\n"); 
		query.append(", AR_IF_NO" ).append("\n"); 
		query.append(", INV_RMK" ).append("\n"); 
		query.append(", INV_REF_NO" ).append("\n"); 
		query.append(", HJS_STF_CTNT" ).append("\n"); 
		query.append(", ISS_DT" ).append("\n"); 
		query.append(", BL_SRC_NO" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", INV_SPLIT_ISS_WRK_NO" ).append("\n"); 
		query.append(", BANK_ACCT_PRN_OPT_CD" ).append("\n"); 
		query.append(", DUE_DT" ).append("\n"); 
		query.append(", SAIL_ARR_DT" ).append("\n"); 
		query.append("-- 2018.05.16 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append(", IDA_STE_CD" ).append("\n"); 
		query.append(", IDA_PAN_NO" ).append("\n"); 
		query.append(", IDA_GST_RGST_NO" ).append("\n"); 
		query.append(", IDA_SPCL_ECN_ZN_UT_FLG" ).append("\n"); 
		query.append(", IDA_GST_DIV_CD" ).append("\n"); 
		query.append(", IDA_ISS_TP_CD" ).append("\n"); 
		query.append(", IDA_ISS_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[inv_no]" ).append("\n"); 
		query.append(", NVL(@[inv_seq],1)" ).append("\n"); 
		query.append(", @[ar_ofc_cd]" ).append("\n"); 
		query.append(", @[act_cust_cnt_cd]" ).append("\n"); 
		query.append(", @[act_cust_seq]" ).append("\n"); 
		query.append(", @[ar_if_no]" ).append("\n"); 
		query.append(", @[inv_rmk]" ).append("\n"); 
		query.append(", @[inv_ref_no]" ).append("\n"); 
		query.append(", @[hjs_stf_ctnt]" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]), 'YYYYMMDD')  " ).append("\n"); 
		query.append(", @[bl_src_no]" ).append("\n"); 
		query.append(", NVL(@[bkg_no],@[bl_src_no])" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[inv_split_iss_wrk_no]" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} == 'SAOSC') " ).append("\n"); 
		query.append(", @[bank_acct_prn_opt_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(", 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", REPLACE(@[due_dt],'-','')" ).append("\n"); 
		query.append(", REPLACE(@[sail_arr_dt],'-','')" ).append("\n"); 
		query.append("-- 2018.05.16 인도지역 Split Invoice Issue 기능 보완 " ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT C.IDA_STE_CD " ).append("\n"); 
		query.append("                                 FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("                                      MDM_LOCATION B," ).append("\n"); 
		query.append("                                      MDM_STATE C" ).append("\n"); 
		query.append("                                 WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("                                 AND B.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("                                 AND B.STE_CD = C.STE_CD" ).append("\n"); 
		query.append("                                 AND A.CUST_CNT_CD = @[act_cust_cnt_cd] " ).append("\n"); 
		query.append("                                 AND A.CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_PAN_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_GST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_SPCL_ECN_ZN_UT_FLG FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT INV_GET_GST_DIV_CD_FNC(@[ida_iss_ofc_cd], 'C', @[act_cust_cnt_cd], @[act_cust_seq], '', DECODE(IO_BND_CD, 'O', POR_CD, DEL_CD))" ).append("\n"); 
		query.append("                                 FROM INV_AR_MN" ).append("\n"); 
		query.append("                                 WHERE AR_IF_NO = @[ar_if_no]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', @[ida_iss_tp_cd], ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', @[ida_iss_ofc_cd], ''))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}