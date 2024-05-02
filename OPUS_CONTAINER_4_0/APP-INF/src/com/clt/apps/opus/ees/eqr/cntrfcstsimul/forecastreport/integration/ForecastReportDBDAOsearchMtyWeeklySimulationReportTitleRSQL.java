/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOsearchMtyWeeklySimulationReportTitleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOsearchMtyWeeklySimulationReportTitleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Weekly Simulation Report의 시트 헤더 조회
	  * </pre>
	  */
	public ForecastReportDBDAOsearchMtyWeeklySimulationReportTitleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchMtyWeeklySimulationReportTitleRSQL").append("\n"); 
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
		query.append("#if(${period} == 'W')       " ).append("\n"); 
		query.append("-- WEEK 일때 " ).append("\n"); 
		query.append("SELECT PLN_YR||PLN_WK WEEK " ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK BETWEEN @[fmdate] AND @[todate]" ).append("\n"); 
		query.append("ORDER BY PLN_YR||PLN_WK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else  -- MONTH" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- MONTH 일때" ).append("\n"); 
		query.append("SELECT DISTINCT PLN_YR||PLN_MON WEEK " ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_MON BETWEEN @[fmdate] AND @[todate]" ).append("\n"); 
		query.append("ORDER BY PLN_YR||PLN_MON" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}