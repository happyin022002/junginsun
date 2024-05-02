/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOUpdateOTSInquiryByDetailListRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.08 문중철
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

public class InvoiceIssueCollectionMgtDBDAOUpdateOTSInquiryByDetailListRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DMT_4011
	  * Outstanding Inquiry by Customer N Issue - Detail(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOUpdateOTSInquiryByDetailListRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmrk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usof",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOUpdateOTSInquiryByDetailListRemarkUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("DMT_PAYR_INFO" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("DMDT_PAYR_OTS_RMK = @[rmrk]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[usid]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",UPD_OFC_CD = @[usof]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("--        CUST_CNT_CD = NVL(SUBSTR( payc , 1, 2), CUST_CNT_CD)" ).append("\n"); 
		query.append("--AND     CUST_SEQ    = NVL(SUBSTR( payc , 3, 6), CUST_SEQ   )" ).append("\n"); 
		query.append("CUST_CNT_CD     =   DECODE( LENGTH(@[payc]) , 8 , NVL( SUBSTR(@[payc] , 1 , 2 ) , CUST_CNT_CD ) , 6 , CUST_CNT_CD , CUST_CNT_CD )" ).append("\n"); 
		query.append("AND     CUST_SEQ        =   DECODE( LENGTH(@[payc]) , 8 , NVL( SUBSTR(@[payc] , 3 , 6 ) , CUST_SEQ    ) , 6 , @[payc]     , CUST_SEQ    )" ).append("\n"); 

	}
}