/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOLocalPayUsdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.11.02 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOLocalPayUsdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOLocalPayUsdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOLocalPayUsdRSQL").append("\n"); 
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
		query.append("SELECT REGEXP_REPLACE (TRIM(TO_CHAR(ROUND(REPLACE(@[locl_amt],',','')/USD_LOCL_XCH_RT,2), '999,999,999,999.99'))," ).append("\n"); 
		query.append("'^\\.+'," ).append("\n"); 
		query.append("'0.'," ).append("\n"); 
		query.append("1) AS USD_AMT" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE  ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND    CURR_CD           = @[curr_cd]" ).append("\n"); 
		query.append("AND    ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 

	}
}