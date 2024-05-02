/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAODmtPayrInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.26 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAODmtPayrInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtPayrInfoVO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAODmtPayrInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAODmtPayrInfoVORSQL").append("\n"); 
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
		query.append("SELECT '' SVR_ID" ).append("\n"); 
		query.append(",'' AS CUST_CD" ).append("\n"); 
		query.append(",'' AS CUST_CNT_CD" ).append("\n"); 
		query.append(",'' AS CUST_SEQ" ).append("\n"); 
		query.append(",'' AS CUST_RGST_NO" ).append("\n"); 
		query.append(",'' AS ISS_DIV_NM" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_NM" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_ZIP_CTNT" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_PHN_NO" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_VNDR_FLG" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_N2ND_EML" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_N3RD_EML" ).append("\n"); 
		query.append(",'' AS DMDT_PAYR_OTS_RMK" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_OFC_CD" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_OFC_CD" ).append("\n"); 
		query.append(",'' AS OFC_CD" ).append("\n"); 
		query.append(",'' AS JOB_TP" ).append("\n"); 
		query.append(",'' AS GUBUN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}