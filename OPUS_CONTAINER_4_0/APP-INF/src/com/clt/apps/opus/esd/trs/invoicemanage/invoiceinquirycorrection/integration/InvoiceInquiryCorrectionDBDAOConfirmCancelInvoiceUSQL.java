/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 상태를 Confirm에서 Save 상태로 변경
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("   SET TRSP_INV_AUD_STS_CD = 'SV'" ).append("\n"); 
		query.append("      ,RGST_NO             = ''" ).append("\n"); 
		query.append("      ,UPD_USR_ID          = @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append("      ,INV_CFM_DT          = NULL" ).append("\n"); 
		query.append("      ,UPD_DT              = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 

	}
}