/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeWithoutCreOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeWithoutCreOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeWithoutCreOfcCdRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeWithoutCreOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeWithoutCreOfcCdRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_CYC_NO" ).append("\n"); 
		query.append("	,DMDT_TRF_CD" ).append("\n"); 
		query.append("	,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,CHG_SEQ" ).append("\n"); 
		query.append("	,DMDT_INV_NO" ).append("\n"); 
		query.append("	,CRE_OFC_CD" ).append("\n"); 
		query.append("	,NVL(FX_FT_OVR_DYS, 0) AS FX_FT_OVR_DYS" ).append("\n"); 
		query.append("FROM DMT_INV_DTL" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO 	= @[dmdt_inv_no]" ).append("\n"); 

	}
}