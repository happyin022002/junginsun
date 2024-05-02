/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.08.19 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL").append("\n"); 
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
		query.append("SELECT ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", ACT_CUST_SEQ" ).append("\n"); 
		query.append(", PAY_DT_DY1" ).append("\n"); 
		query.append(", PAY_DT_DY2" ).append("\n"); 
		query.append(", PAY_DT_DY3" ).append("\n"); 
		query.append(", PAY_DT_DY4" ).append("\n"); 
		query.append(", CUST_CR_DUE_DT_DIV_CD" ).append("\n"); 
		query.append(", CR_FLG" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}