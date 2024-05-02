/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.12 차상영
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

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL").append("\n"); 
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
		query.append("   SELECT  MO2.OFC_CD   AS OFFICE_CODE" ).append("\n"); 
		query.append("   FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION MO2" ).append("\n"); 
		query.append("   WHERE   MO.AP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND     MO.AP_OFC_CD = MO2.OFC_CD" ).append("\n"); 
		query.append("   AND     MO2.DELT_FLG <> 'Y'" ).append("\n"); 

	}
}