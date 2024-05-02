/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.19 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 3rd Party Billing 대상일 경우 Surcharge 정보를 null로 변경
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SCG_DTL SET" ).append("\n"); 
		query.append("N3PTY_AMT		= NULL" ).append("\n"); 
		query.append(",	N3PTY_BIL_FLG	= NULL" ).append("\n"); 
		query.append(",	CUST_CNT_CD		= NULL" ).append("\n"); 
		query.append(",	CUST_SEQ		= NULL" ).append("\n"); 
		query.append(",	N3PTY_VNDR_SEQ	= NULL" ).append("\n"); 
		query.append(",	N3PTY_OFC_CD	= NULL" ).append("\n"); 
		query.append(",	N3PTY_DESC		= NULL" ).append("\n"); 
		query.append(",  UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append(",  UPD_USR_ID		= @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append(",  LOCL_UPD_DT		= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD	= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	TRSP_SO_SEQ		= @[trsp_so_seq]" ).append("\n"); 

	}
}