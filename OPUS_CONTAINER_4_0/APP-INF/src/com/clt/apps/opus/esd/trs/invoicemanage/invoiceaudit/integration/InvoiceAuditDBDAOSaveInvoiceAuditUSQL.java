/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 수정
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("PROV_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wht_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("PROV_PHN_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apply_currency",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAuditUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK A" ).append("\n"); 
		query.append("   SET TRSP_INV_AUD_STS_CD = @[trsp_inv_aud_sts_cd]" ).append("\n"); 
		query.append("      ,WO_VNDR_SEQ         = @[combo_svc_provider]" ).append("\n"); 
		query.append("      ,INV_CURR_CD         = @[apply_currency]" ).append("\n"); 
		query.append("      ,INV_BZC_AMT         = NVL(@[inv_amt], 0)" ).append("\n"); 
		query.append("      ,INV_VAT_AMT         = NVL(@[vat_amt], 0)" ).append("\n"); 
		query.append("      ,INV_WHLD_TAX_AMT    = NVL(@[wht_amt], 0)" ).append("\n"); 
		query.append("      ,INV_TTL_AMT         = NVL(@[tot_amt], 0)" ).append("\n"); 
		query.append("      ,INV_RCV_DT          = TO_DATE(@[recieve_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,INV_ISS_DT          = TO_DATE(@[issue_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,IF_SYS_KND_CD       = @[if_sys_knd_cd]" ).append("\n"); 
		query.append("      ,UPD_USR_ID          = @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("      ,PROV_USR_ID         = @[PROV_USR_ID]" ).append("\n"); 
		query.append("      ,PROV_PHN_NO         = @[PROV_PHN_ID]" ).append("\n"); 
		query.append("      ,UPD_DT              = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 

	}
}