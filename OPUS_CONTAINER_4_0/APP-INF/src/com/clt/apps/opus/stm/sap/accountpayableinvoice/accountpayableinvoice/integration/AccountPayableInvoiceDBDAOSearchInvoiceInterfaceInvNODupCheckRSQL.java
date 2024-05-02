/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.09
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.09 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL").append("\n"); 
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
		query.append("   SELECT SIH.INV_NO AS DUP_INV_NO" ).append("\n"); 
		query.append("   FROM   SAP_INV_HDR SIH" ).append("\n"); 
		query.append("   WHERE  SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND    ROWNUM = 1" ).append("\n"); 

	}
}