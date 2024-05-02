/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.24 김태균
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

public class InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'S', CUST_CNT_CD||LPAD(CUST_SEQ,6,'0'))) AS CUST_CD_S" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'S', CUST_NM)) AS CUST_NM_S" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'C', CUST_CNT_CD||LPAD(CUST_SEQ,6,'0'))) AS CUST_CD_C" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'C', CUST_NM)) AS CUST_NM_C" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'N', CUST_CNT_CD||LPAD(CUST_SEQ,6,'0'))) AS CUST_CD_N" ).append("\n"); 
		query.append(", MIN(DECODE(BKG_CUST_TP_CD, 'N', CUST_NM)) AS CUST_NM_N" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 

	}
}