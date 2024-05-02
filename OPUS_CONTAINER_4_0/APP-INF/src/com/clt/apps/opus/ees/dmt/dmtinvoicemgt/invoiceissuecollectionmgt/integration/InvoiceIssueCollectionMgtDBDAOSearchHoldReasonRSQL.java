/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.12 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_5101
	  * Hold Reason Entry
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("REPLACE(DMDT_INV_NO||'||'||INV_HLD_RSN_CD||'||'||INV_HLD_RMK||'||'||TO_CHAR(UPD_DT,'YYYY-MM-DD')||'||'||UPD_OFC_CD||'||'||UPD_USR_ID,'@*','') XXX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_INV_MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DMDT_INV_NO = @[invno]" ).append("\n"); 

	}
}