/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonDBDAOSearchAccountRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.31 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOSearchAccountRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 경리환율
	  * </pre>
	  */
	public INVCommonDBDAOSearchAccountRateRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchAccountRateRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(TO_CHAR(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), '9999999990.000000')) USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A," ).append("\n"); 
		query.append("GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_YRMON = @[eff_dt]" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.CURR_CD = @[to_curr_cd]" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_YRMON = @[eff_dt]" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND B.CURR_CD = @[from_curr_cd]" ).append("\n"); 

	}
}