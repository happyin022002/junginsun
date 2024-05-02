/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AocCommonDBDAOSearchPeriodWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AocCommonDBDAOSearchPeriodWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
	  * - Week 조회
	  * </pre>
	  */
	public AocCommonDBDAOSearchPeriodWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration").append("\n"); 
		query.append("FileName : AocCommonDBDAOSearchPeriodWeekRSQL").append("\n"); 
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
		query.append("SELECT (SELECT SUBSTR(SLS_FM_DT,1,4) || '-' || SUBSTR(SLS_FM_DT,5,2) || '-' || SUBSTR(SLS_FM_DT,7)" ).append("\n"); 
		query.append("          FROM MAS_WK_PRD" ).append("\n"); 
		query.append("         WHERE COST_YR = @[f_fm_yr]" ).append("\n"); 
		query.append("           AND COST_WK = @[f_fm_wk]" ).append("\n"); 
		query.append("        ) AS FM_DATE," ).append("\n"); 
		query.append("       (SELECT SUBSTR(SLS_TO_DT,1,4) || '-' || SUBSTR(SLS_TO_DT,5,2) || '-' || SUBSTR(SLS_TO_DT,7)" ).append("\n"); 
		query.append("          FROM MAS_WK_PRD" ).append("\n"); 
		query.append("         WHERE COST_YR = @[f_to_yr]" ).append("\n"); 
		query.append("           AND COST_WK = @[f_to_wk]" ).append("\n"); 
		query.append("        ) AS TO_DATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}