/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchChangeOfficeStandardDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchChangeOfficeStandardDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03.16 이준범 [CHM-201108838-01]
	  * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
	  * Description : 이행 데이터 변경시 해당 기준 년월일 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchChangeOfficeStandardDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchChangeOfficeStandardDateRSQL").append("\n"); 
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
		query.append("SELECT MAX(STND_DT) AS STND_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SUBSTR(TO_CHAR(TO_DATE(@[exp_dt], 'YYYYMMDD') + 1, 'YYYYMMDD'), 1, 6) AS STND_DT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         WHERE TO_CHAR(LAST_DAY(TO_DATE(@[exp_dt], 'YYYYMMDD')), 'YYYYMMDD') = @[exp_dt]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT SUBSTR(@[exp_dt], 1, 6) AS STND_DT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         WHERE SUBSTR(@[exp_dt], 1, 6)||'01' = @[exp_dt]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT SUBSTR(@[exp_dt], 1, 6) AS STND_DT" ).append("\n"); 
		query.append("          FROM DUAL " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}