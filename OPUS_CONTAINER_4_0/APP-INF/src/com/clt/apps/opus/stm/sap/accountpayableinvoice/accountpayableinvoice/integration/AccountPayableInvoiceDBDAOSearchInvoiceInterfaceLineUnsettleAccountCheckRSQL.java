/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.14 차상영
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

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_coa_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL").append("\n"); 
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
		query.append("      SELECT  MA.ACCT_CD AS L_ACCOUNT_CODE" ).append("\n"); 
		query.append("            , MA.PND_TGT_FLG AS L_UNSETTLED_FLAG" ).append("\n"); 
		query.append("      FROM    MDM_ACCOUNT MA" ).append("\n"); 
		query.append("      WHERE   MA.ACCT_CD = @[dtrb_coa_acct_no]" ).append("\n"); 
		query.append("      AND     NVL(MA.DELT_FLG, 'N') != 'Y'" ).append("\n"); 

	}
}