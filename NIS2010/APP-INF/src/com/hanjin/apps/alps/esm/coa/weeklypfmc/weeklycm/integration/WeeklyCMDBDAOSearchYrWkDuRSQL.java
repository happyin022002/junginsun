/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchYrWkDuRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.03.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchYrWkDuRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYrWkDu SELECT
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchYrWkDuRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchYrWkDuRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      MIN(COST_YR) AS COST_YR" ).append("\n"); 
		query.append("    , MIN(COST_WK) AS COST_WK" ).append("\n"); 
		query.append("    , COUNT(*)     AS CNT" ).append("\n"); 
		query.append("  FROM COA_WK_PRD" ).append("\n"); 
		query.append(" WHERE COST_YR = @[in_yr]" ).append("\n"); 
		query.append("   #if (${in_mon_or_wk} == 'W') " ).append("\n"); 
		query.append("       AND COST_WK BETWEEN @[in_fm_wk] AND @[in_to_wk]" ).append("\n"); 
		query.append("   #elseif (${in_mon_or_wk} == 'M') " ).append("\n"); 
		query.append("       AND SUBSTR(SLS_FM_DT,1,6) BETWEEN @[in_yr]||@[in_fm_mon] AND @[in_yr]||@[in_to_mon]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}