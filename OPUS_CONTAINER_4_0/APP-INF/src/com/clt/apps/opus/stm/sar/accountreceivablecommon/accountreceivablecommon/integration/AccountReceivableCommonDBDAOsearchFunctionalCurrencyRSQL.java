/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchFunctionalCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchFunctionalCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Functional Currency 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchFunctionalCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchFunctionalCurrencyRSQL").append("\n"); 
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
		query.append("SELECT LU_CD AS FUNC_CURR" ).append("\n"); 
		query.append("FROM   SCO_LU_DTL" ).append("\n"); 
		query.append("WHERE  LU_TP_CD = @[lu_tp_cd]" ).append("\n"); 

	}
}