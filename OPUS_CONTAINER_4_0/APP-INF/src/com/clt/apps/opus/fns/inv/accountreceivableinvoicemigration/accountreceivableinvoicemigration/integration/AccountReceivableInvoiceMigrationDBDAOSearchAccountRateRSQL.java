/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchAccountRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchAccountRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Account Rate
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchAccountRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration ").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchAccountRateRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), '0') USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A," ).append("\n"); 
		query.append("  GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_YRMON = @[eff_dt]" ).append("\n"); 
		query.append("  AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("  AND A.CURR_CD = @[to_curr_cd]" ).append("\n"); 
		query.append("  AND B.ACCT_XCH_RT_YRMON = @[eff_dt]" ).append("\n"); 
		query.append("  AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("  AND B.CURR_CD = @[from_curr_cd]" ).append("\n"); 

	}
}