/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchRFACustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.08 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchRFACustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inv_0090
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchRFACustomerListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 'Customer' CUSTOMER_TYPE,A.CTRT_CUST_CNT_CD CUST_CD,LPAD(A.CTRT_CUST_SEQ,6,0) CUST_SEQ,C.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("FROM PRI_RP_MN A,PRI_RP_HDR B,MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.CTRT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CTRT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'Affiliate' CUSTOMER_TYPE,A.CUST_CNT_CD CUST_CD,LPAD(A.CUST_SEQ,6,0) CUST_SEQ,C.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("FROM PRI_RP_AFIL A,PRI_RP_HDR B,MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND B.RFA_NO = @[rfa_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchRFACustomerListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}