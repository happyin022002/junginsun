/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchValidTaxChgCurrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchValidTaxChgCurrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tax 금액이 Local Currency로 존재하지 않은 BL 체크
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchValidTaxChgCurrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchValidTaxChgCurrRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'PASS','FAIL') AS CHK_CURR" ).append("\n"); 
		query.append("FROM INV_AR_CHG IAC, INV_AR_MN IAM" ).append("\n"); 
		query.append("WHERE IAC.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND   IAC.AR_IF_NO = IAM.AR_IF_NO" ).append("\n"); 
		query.append("AND   IAC.TJ_SRC_NM = 'VAT'" ).append("\n"); 
		query.append("AND   IAC.CURR_CD <> IAM.LOCL_CURR_CD" ).append("\n"); 

	}
}