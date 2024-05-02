/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.08 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4103
	  * Sheet Option
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isof",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL").append("\n"); 
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
		query.append("AA.OFC_CD||'|'||AA.BIL_TO_LOC_DIV_CD||'|'||AA.CUST_REF_PRN_FLG||'|'||AA.PHN_FAX_PRN_FLG||'|'||AA.CUST_VAT_PRN_FLG||'|'||AA.DFLT_TAX_RTO||'|'||AA.TAX_AMT_PRN_FLG||'|'||AA.DC_AMT_FLG AS XXX" ).append("\n"); 
		query.append("/*        ISSOFF      / TOLOCA                   / CUSREF                  / TELFAX                 / CUSVAT                  / TAXRTO              / RTOVAT" ).append("\n"); 
		query.append("AA.OFC_CD            AS ISSOFF" ).append("\n"); 
		query.append(", AA.BIL_TO_LOC_DIV_CD AS TOLOCA" ).append("\n"); 
		query.append(", AA.CUST_REF_PRN_FLG  AS CUSREF" ).append("\n"); 
		query.append(", AA.PHN_FAX_PRN_FLG   AS TELFAX" ).append("\n"); 
		query.append(", AA.CUST_VAT_PRN_FLG  AS CUSVAT" ).append("\n"); 
		query.append(", AA.DFLT_TAX_RTO      AS TAXRTO" ).append("\n"); 
		query.append(", AA.TAX_AMT_PRN_FLG   AS RTOVAT" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_OFC_SH_OPT AA" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AA.OFC_CD = @[isof]" ).append("\n"); 

	}
}