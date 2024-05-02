/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAODmtPayrCntcPntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.26 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAODmtPayrCntcPntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail VO생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAODmtPayrCntcPntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAODmtPayrCntcPntVORSQL").append("\n"); 
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
		query.append("SELECT '' AS SVR_ID" ).append("\n"); 
		query.append(",'' AS CUST_CNT_CD" ).append("\n"); 
		query.append(",'' AS CUST_SEQ" ).append("\n"); 
		query.append(",'' AS CUST_CD" ).append("\n"); 
		query.append(",'' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",'' AS PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",'' AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",'' AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",'' AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_OFC_CD" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}