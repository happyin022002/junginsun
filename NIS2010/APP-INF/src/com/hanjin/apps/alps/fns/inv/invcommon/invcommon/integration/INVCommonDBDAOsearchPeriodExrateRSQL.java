/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : INVCommonDBDAOsearchPeriodExrateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchPeriodExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Period type 환율 계산 쿼리
	  * </pre>
	  */
	public INVCommonDBDAOsearchPeriodExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchPeriodExrateRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), '0') EX_RATE" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(@[sa_dt],1,6)" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("AND B.CURR_CD = @[curr]" ).append("\n"); 

	}
}