/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamSungNextMsgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchSamSungNextMsgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 문서번호를 구함.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamSungNextMsgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamSungNextMsgNoRSQL").append("\n"); 
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
		query.append("SELECT 'SMLINE'||TO_CHAR(SYSDATE, 'yyyymmdd')||LTRIM(TO_CHAR(NVL(MAX(SUBSTR(MSG_NO, 15, 3)), '000') + 1, '000')) MSG_NO" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR" ).append("\n"); 
		query.append("WHERE SUBSTR(MSG_NO, 7, 8) = TO_CHAR(SYSDATE, 'yyyymmdd')" ).append("\n"); 

	}
}