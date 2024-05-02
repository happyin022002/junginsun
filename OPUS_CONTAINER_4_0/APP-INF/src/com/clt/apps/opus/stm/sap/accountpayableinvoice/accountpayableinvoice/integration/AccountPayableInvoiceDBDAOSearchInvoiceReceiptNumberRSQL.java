/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceReceiptNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceReceiptNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Login 정보를 기준으로 처리해서 저장 해 놓은 각 값을 조합하여 접수번호의 앞부분 정보를 계산한 후 (Sysdate + Office + Currency) 정보를 조건으로 하여 Receipt No의 일련번호 Max 값 가져옴
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceReceiptNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no_cmb",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceReceiptNumberRSQL").append("\n"); 
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
		query.append("SELECT @[rct_no_cmb]||TRIM(NVL(TO_CHAR(MAX(SUBSTR(INV_RCT_NO, -4)) + 1, '0999'), '0001')) AS INV_RCT_NO" ).append("\n"); 
		query.append("   FROM SAP_INV_RCT" ).append("\n"); 
		query.append("  WHERE INV_RCT_NO LIKE @[rct_no_cmb]||'%'" ).append("\n"); 

	}
}