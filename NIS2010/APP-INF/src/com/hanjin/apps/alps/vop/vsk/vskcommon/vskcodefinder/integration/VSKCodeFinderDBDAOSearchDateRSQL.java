/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 날짜정보를 조회한다.
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchDateRSQL").append("\n"); 
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
		query.append("#if(${wm_cd} != 'M')" ).append("\n"); 
		query.append("	SELECT TO_CHAR(TO_DATE(MIN(SLS_FM_DT), 'YYYYMMDD'), 'YYYY-MM-DD') || '~' || TO_CHAR(TO_DATE(MAX(SLS_TO_DT), 'YYYYMMDD'), 'YYYY-MM-DD') RTN_DATE" ).append("\n"); 
		query.append("      FROM MAS_WK_PRD" ).append("\n"); 
		query.append("     WHERE COST_YR||COST_WK BETWEEN REPLACE(@[fm_wk], '-', '') AND REPLACE(@[to_wk], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}