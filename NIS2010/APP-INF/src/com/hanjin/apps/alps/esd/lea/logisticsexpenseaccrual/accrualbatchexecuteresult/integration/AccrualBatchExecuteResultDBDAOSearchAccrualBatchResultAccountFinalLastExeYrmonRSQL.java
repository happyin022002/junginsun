/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalLastExeYrmonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalLastExeYrmonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccrualBatchResultAccountFinalLastExeYrmon
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalLastExeYrmonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalLastExeYrmonRSQL").append("\n"); 
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
		query.append("SELECT    INITCAP(TO_CHAR(TO_DATE(MAX(S.EXE_YRMON),'YYYYMM'), 'MONTH', 'nls_date_language=english')) AS MAX_EXE_YRMON_MONTH" ).append("\n"); 
		query.append("FROM      LEA_ACCL_COST_SMRY  S" ).append("\n"); 

	}
}