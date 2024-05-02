/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchMaxReporIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOsearchMaxReporIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMaxReporID
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchMaxReporIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custNm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchMaxReporIDRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(REPLACE(@[custNm],' ',''),0,3)||TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]), 'YYYYMMDD')||'-'||LPAD(NVL(MAX(SUBSTR(CUST_RPT_ID,13))+1,1),3,'0') CUST_RPT_ID" ).append("\n"); 
		query.append("FROM    INV_CPRT_HIS" ).append("\n"); 
		query.append("WHERE   SUBSTR(CUST_RPT_ID,0,3) = SUBSTR(REPLACE(@[custNm],' ',''),0,3)" ).append("\n"); 
		query.append("AND     SUBSTR(CUST_RPT_ID,4,8) = TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]), 'YYYYMMDD')" ).append("\n"); 

	}
}