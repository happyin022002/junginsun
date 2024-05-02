/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchAcctXchRtDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchAcctXchRtDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAcctXchRtDt
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchAcctXchRtDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ym",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchAcctXchRtDtRSQL").append("\n"); 
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
		query.append("SELECT MAX(ACCT_XCH_RT_DT) AS ACCT_XCH_RT_DT FROM SCO_MON_XCH_RT_IF SIF" ).append("\n"); 
		query.append("WHERE ACCT_XCH_RT_DT LIKE @[ym] || '%'" ).append("\n"); 

	}
}