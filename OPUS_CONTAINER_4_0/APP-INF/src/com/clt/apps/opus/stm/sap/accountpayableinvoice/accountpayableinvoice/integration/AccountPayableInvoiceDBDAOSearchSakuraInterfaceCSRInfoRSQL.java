/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchSakuraInterfaceCSRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26 
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

public class AccountPayableInvoiceDBDAOSearchSakuraInterfaceCSRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Date 기준의 Sakura로 I/F 처리 할 대상의 CSR을 가져온다
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchSakuraInterfaceCSRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invtodt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invfromdt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchSakuraInterfaceCSRInfoRSQL").append("\n"); 
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
		query.append("SELECT SIH.INV_NO  AS VALUE0" ).append("\n"); 
		query.append("FROM   SAP_INV_HDR SIH" ).append("\n"); 
		query.append("WHERE  SIH.INV_DT >= TO_DATE(@[invfromdt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND    SIH.INV_DT < TO_DATE(@[invtodt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("AND    SIH.INV_CXL_DT IS NULL " ).append("\n"); 
		query.append("AND    NVL(SIH.ATTR_CTNT15, 'N') = 'Y'" ).append("\n"); 
		query.append("AND    NOT EXISTS ( SELECT 'A' FROM SAP_AP_IF SAI WHERE SAI.REF_DOC_NO = SIH.INV_NO)" ).append("\n"); 

	}
}