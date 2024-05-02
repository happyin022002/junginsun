/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchFindPrepaymentPayScheduleCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchFindPrepaymentPayScheduleCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFindPrepaymentPayScheduleCheck
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchFindPrepaymentPayScheduleCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchFindPrepaymentPayScheduleCheckRSQL").append("\n"); 
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
		query.append("SELECT S.INV_SEQ, S.PAY_SKD_NO, S.PAY_RMN_AMT, S.PAY_GRS_AMT" ).append("\n"); 
		query.append("FROM  SAP_PAY_SKD S" ).append("\n"); 
		query.append("WHERE S.INV_SEQ =  TO_NUMBER(@[inv_seq])" ).append("\n"); 
		query.append("#if (${apply_flg} != 'UNAPPLY') " ).append("\n"); 
		query.append("AND   S.PAY_RMN_AMT <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY S.PAY_SKD_NO" ).append("\n"); 

	}
}