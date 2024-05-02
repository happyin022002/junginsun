/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceStatusCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.21 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceStatusCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전표 정보를 삭제 가능 여부를 확인 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceStatusCheckRSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceStatusCheckRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUM(CHK) > 0 THEN 'N' ELSE 'Y' END  DEL_AVAILABLE " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SUM(DECODE( INV_CXL_DT, NULL, 0, 1) ) CHK" ).append("\n"); 
		query.append("    FROM   SAP_INV_HDR" ).append("\n"); 
		query.append("    WHERE INV_SEQ = to_number(@[inv_seq])" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT SUM(DECODE( NVL(ATTR_CTNT15, 'N'), 'N', 0, 1) ) CHK" ).append("\n"); 
		query.append("    FROM   SAP_INV_HDR" ).append("\n"); 
		query.append("    WHERE INV_SEQ = to_number(@[inv_seq])" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT SUM(DECODE(NVL( ACCTG_PST_FLG , 'N'), 'N', 0, 1 )) CHK" ).append("\n"); 
		query.append("    FROM   SAP_INV_DTL" ).append("\n"); 
		query.append("    WHERE INV_SEQ = to_number(@[inv_seq])" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}