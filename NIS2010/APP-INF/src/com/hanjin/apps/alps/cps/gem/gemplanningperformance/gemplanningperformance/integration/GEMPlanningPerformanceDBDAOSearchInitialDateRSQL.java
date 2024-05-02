/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchInitialDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.19
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.19 이준범
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

public class GEMPlanningPerformanceDBDAOSearchInitialDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 차년도 예산 수립일 및 마감일 취득
	  * 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchInitialDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchInitialDateRSQL").append("\n"); 
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
		query.append("SELECT CLZ_YRMON" ).append("\n"); 
		query.append("      ,CLZ_DT" ).append("\n"); 
		query.append("      ,CLZ_DIV_CD" ).append("\n"); 
		query.append("      ,CLZ_FLG" ).append("\n"); 
		query.append("      ,GL_IF_FLG" ).append("\n"); 
		query.append("FROM   GEM_MON_CLZ" ).append("\n"); 
		query.append("WHERE  CLZ_YRMON  = @[clz_yrmon]" ).append("\n"); 
		query.append("AND    CLZ_DIV_CD = 'IN'" ).append("\n"); 
		query.append("AND    CLZ_DT >= TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd]), 'YYYYMMDD')" ).append("\n"); 

	}
}