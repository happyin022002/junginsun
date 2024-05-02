/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchPerfClosingDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.02.03 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchPerfClosingDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별 현지법인 실적 입력을 위해서, 마감 일정을 조회한다, 최종 마감 년월을 조회하여, 실적을 입력할 년월을 구한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchPerfClosingDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchPerfClosingDateRSQL").append("\n"); 
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
		query.append("    MAX (CLZ_YRMON) PERFCLOSINGDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            DECODE (SUBSTR (MAX (CLZ_YRMON), 5, 2), '12', SUBSTR (MAX (CLZ_YRMON), 1, 4) + 1||'01', TO_CHAR (MAX (CLZ_YRMON) + 1, 'FM999999')) CLZ_YRMON" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            GEM_MON_CLZ" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLZ_DIV_CD  = 'AT'" ).append("\n"); 
		query.append("            AND CLZ_FLG = 'Y'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            DECODE (SUBSTR (MAX (CLZ_YRMON), 5, 2), '12', SUBSTR (MAX (CLZ_YRMON), 1, 4) + 1||'01', TO_CHAR (MAX (CLZ_YRMON) + 1, 'FM999999')) CLZ_YRMON" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            GEM_MON_CLZ" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLZ_DIV_CD = 'AT'" ).append("\n"); 
		query.append("            AND CLZ_DT < TO_CHAR (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC (@[ofc_cd]), 'YYYYMMDD')" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}