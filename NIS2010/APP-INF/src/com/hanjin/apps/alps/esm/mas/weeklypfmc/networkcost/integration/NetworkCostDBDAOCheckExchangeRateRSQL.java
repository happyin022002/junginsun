/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOCheckExchangeRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCheckExchangeRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
	  * 2015.07.01  김시몬 없을 경우 가장최근월가져오도록 보완
	  * </pre>
	  */
	public NetworkCostDBDAOCheckExchangeRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCheckExchangeRateRSQL").append("\n"); 
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
		query.append("SELECT ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("  FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append(" WHERE ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("   AND ACCT_XCH_RT_YRMON = (SELECT MAX(ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                              FROM GL_MON_XCH_RT B" ).append("\n"); 
		query.append("                             WHERE B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                               AND B.ACCT_XCH_RT_YRMON <= @[f_yearweek]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 

	}
}