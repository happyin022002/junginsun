/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatementCommonDBDAOsearchZeroBalanceRunningListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOsearchZeroBalanceRunningListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchZeroBalanceRunningList
	  * </pre>
	  */
	public StatementCommonDBDAOsearchZeroBalanceRunningListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOsearchZeroBalanceRunningListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT REPLACE(SUBSTR(BAT_PARA_CTNT,0,7),'-','') AS YRMON" ).append("\n"); 
		query.append("  FROM SCO_BAT_HIS" ).append("\n"); 
		query.append(" WHERE BAT_PGM_NO = 'STM_SCO_B002'" ).append("\n"); 
		query.append("   AND BAT_RSLT_CD = 'W'" ).append("\n"); 
		query.append("   AND BAT_ST_DT > SYSDATE - 1" ).append("\n"); 

	}
}