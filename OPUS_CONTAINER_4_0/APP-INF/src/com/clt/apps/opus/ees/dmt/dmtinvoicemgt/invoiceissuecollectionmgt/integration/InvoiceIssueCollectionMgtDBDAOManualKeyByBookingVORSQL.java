/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOManualKeyByBookingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOManualKeyByBookingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BOOKING 정보로 조회된 정보를 저장하기 위한 VO 객체 생성용 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOManualKeyByBookingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOManualKeyByBookingVORSQL").append("\n"); 
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
		query.append("SELECT	DMDT_INV_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' VVD_CD" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	'' AS RCV_TERM_CD" ).append("\n"); 
		query.append(",	'' AS DE_TERM_CD" ).append("\n"); 
		query.append(",	'' AS BKG_CUST_CD" ).append("\n"); 
		query.append(",	'' AS BKG_CUST_NM" ).append("\n"); 
		query.append(",	'' AS ACT_CUST_CD" ).append("\n"); 
		query.append(",	'' AS ACT_CUST_NM" ).append("\n"); 
		query.append(",	'' AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append(",	'' AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append(",	'' AS VNDR_SEQ" ).append("\n"); 
		query.append(",	'' AS VNDR_NM" ).append("\n"); 
		query.append(",	'' AS DUE_DT" ).append("\n"); 
		query.append(",	'' AS CR_TERM_DYS" ).append("\n"); 
		query.append(",	'' AS ISS_DT_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS DFLT_TAX_RTO" ).append("\n"); 
		query.append("FROM	DMT_INV_MN" ).append("\n"); 

	}
}