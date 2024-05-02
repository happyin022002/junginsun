/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceSoDelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
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

public class InvoiceInquiryCorrectionDBDAODeleteInvoiceSoDelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 테이블에서 Invoice정보를 제거
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAODeleteInvoiceSoDelUSQL(){
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
		query.append("FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceSoDelUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET		" ).append("\n"); 
		query.append(" TRSP_INV_ACT_STS_CD		= NULL		,					" ).append("\n"); 
		query.append(" INV_NO						= NULL		,					" ).append("\n"); 
		query.append(" INV_VNDR_SEQ				= NULL		,					" ).append("\n"); 
		query.append(" INV_BZC_AMT				= NULL		,					" ).append("\n"); 
		query.append(" INV_ETC_ADD_AMT			= NULL		,					" ).append("\n"); 
		query.append(" INV_CURR_CD				= NULL		,									" ).append("\n"); 
		query.append(" INV_RMK					= NULL		,					" ).append("\n"); 
		query.append(" TRSP_INV_CALC_LGC_TP_CD	= NULL		,					" ).append("\n"); 
		query.append(" INV_XCH_RT					= NULL		," ).append("\n"); 
		query.append(" UPD_USR_ID					= @[FORM_CRE_USR_ID]	,	" ).append("\n"); 
		query.append(" UPD_DT						= SYSDATE" ).append("\n"); 
		query.append(" WHERE		" ).append("\n"); 
		query.append(" INV_NO			= @[inv_no]      	" ).append("\n"); 
		query.append(" AND INV_VNDR_SEQ	= @[inv_vndr_seq]	" ).append("\n"); 

	}
}