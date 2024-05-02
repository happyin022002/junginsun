/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceAuditDBDAOConfirmInvoiceAuditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOConfirmInvoiceAuditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 생성
	  * </pre>
	  */
	public InvoiceAuditDBDAOConfirmInvoiceAuditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wht_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_rvs_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("recieve_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apply_currency",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_sys_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sbc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOConfirmInvoiceAuditCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_WRK (				" ).append("\n"); 
		query.append(" INV_NO                                            ,	" ).append("\n"); 
		query.append(" INV_VNDR_SEQ                                      ,	" ).append("\n"); 
		query.append(" TRSP_INV_AUD_STS_CD                               ,	" ).append("\n"); 
		query.append(" WO_VNDR_SEQ                                       ,	" ).append("\n"); 
		query.append(" INV_CURR_CD                                       ,	" ).append("\n"); 
		query.append(" INV_BZC_AMT                                       ,	" ).append("\n"); 
		query.append(" INV_VAT_AMT                                       ,	" ).append("\n"); 
		query.append(" INV_WHLD_TAX_AMT                                  ,	" ).append("\n"); 
		query.append(" INV_SBC_AMT                                       ,	" ).append("\n"); 
		query.append(" INV_TTL_AMT                                       ,	" ).append("\n"); 
		query.append(" INV_RCV_DT                                        ,	" ).append("\n"); 
		query.append(" INV_ISS_DT                                        ,	" ).append("\n"); 
		query.append(" IF_SYS_KND_CD                                     ,	" ).append("\n"); 
		query.append(" DELT_FLG                                          ,	" ).append("\n"); 
		query.append(" CRE_OFC_CD                                        ,	" ).append("\n"); 
		query.append(" CRE_USR_ID                                        ,	" ).append("\n"); 
		query.append(" INV_CFM_DT	                                       ,	" ).append("\n"); 
		query.append(" CRE_DT		       				                   ," ).append("\n"); 
		query.append(" UPD_USR_ID                                        ,	" ).append("\n"); 
		query.append(" UPD_DT						                       ,	" ).append("\n"); 
		query.append(" LOCL_CRE_DT                                       ,	" ).append("\n"); 
		query.append(" LOCL_UPD_DT									   ," ).append("\n"); 
		query.append(" AP_RVS_CNG_FLG                                    ," ).append("\n"); 
		query.append(" IDA_CGST_AMT                                      ," ).append("\n"); 
		query.append(" IDA_SGST_AMT                                      ," ).append("\n"); 
		query.append(" IDA_IGST_AMT                                      ," ).append("\n"); 
		query.append(" IDA_UGST_AMT " ).append("\n"); 
		query.append("  ) VALUES (						" ).append("\n"); 
		query.append(" @[invoice_no]			                              ,	" ).append("\n"); 
		query.append(" @[paymt_sp_cd]			                              ,	" ).append("\n"); 
		query.append(" @[trsp_inv_aud_sts_cd]		                          ,	" ).append("\n"); 
		query.append(" @[combo_svc_provider]				                  ,	" ).append("\n"); 
		query.append(" @[apply_currency]		                              ,	" ).append("\n"); 
		query.append(" @[inv_amt]			                                  ,	" ).append("\n"); 
		query.append(" @[vat_amt]			                                  ,	" ).append("\n"); 
		query.append(" @[wht_amt]					                          ,	" ).append("\n"); 
		query.append(" @[sbc_amt]					                          ,	" ).append("\n"); 
		query.append(" @[tot_amt]					                          ,	" ).append("\n"); 
		query.append(" TO_DATE( @[recieve_dt], 'YYYYMMDD')                  ,	" ).append("\n"); 
		query.append(" TO_DATE( @[issue_dt], 'YYYYMMDD')                    ,	" ).append("\n"); 
		query.append(" @[if_sys_knd_cd]		                              ," ).append("\n"); 
		query.append(" 'N'				                                  ,	" ).append("\n"); 
		query.append(" @[FORM_USR_OFC_CD]		                              ,	" ).append("\n"); 
		query.append(" @[FORM_CRE_USR_ID]		                              ,	" ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD]),	" ).append("\n"); 
		query.append(" sysdate					                          ," ).append("\n"); 
		query.append(" @[FORM_USR_OFC_CD]		                              ,	" ).append("\n"); 
		query.append(" sysdate					                          ," ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD]),	" ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append(" @[ap_rvs_cng_flg]                                    ," ).append("\n"); 
		query.append(" @[ida_cgst_amt]                                      ," ).append("\n"); 
		query.append(" @[ida_sgst_amt]                                      ," ).append("\n"); 
		query.append(" @[ida_igst_amt]                                      ," ).append("\n"); 
		query.append(" @[ida_ugst_amt]" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}