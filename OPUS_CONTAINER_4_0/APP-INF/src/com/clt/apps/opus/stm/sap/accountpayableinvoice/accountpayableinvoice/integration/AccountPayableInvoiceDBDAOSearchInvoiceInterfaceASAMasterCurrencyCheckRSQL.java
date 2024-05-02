/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCurrencyCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCurrencyCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Interface되는 CSR의 Currency와 해당 CSR의 ASA에 해당하는 ASA Master의 Currency와 일치 여부 체크
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCurrencyCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_currency_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCurrencyCheckRSQL").append("\n"); 
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
		query.append("SELECT  SAM.CURR_CD AS ASA_CURRENCY" ).append("\n"); 
		query.append("FROM    SAR_ASA_MST SAM" ).append("\n"); 
		query.append("WHERE   SAM.ASA_NO = @[attr_ctnt2]" ).append("\n"); 
		query.append("AND     SAM.ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("AND     SAM.CURR_CD = @[inv_currency_code]" ).append("\n"); 

	}
}