/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.22 
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

public class AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_INV_HDR_IF SIHI" ).append("\n"); 
		query.append("SET      SIHI.INV_IF_FLG = 'Y'" ).append("\n"); 
		query.append("       , SIHI.INV_IF_STS_CD = 'PROCESSED'" ).append("\n"); 
		query.append("       , SIHI.IF_DT = SYSDATE" ).append("\n"); 
		query.append("       , SIHI.AP_IF_ERR_RSN = ''" ).append("\n"); 
		query.append("WHERE   SIHI.INV_NO = @[csr_no]" ).append("\n"); 

	}
}