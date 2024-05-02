/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ForecastReportDBDAOsearchForecastReportDummyWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOsearchForecastReportDummyWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchForecastReportDummyWeek
	  * </pre>
	  */
	public ForecastReportDBDAOsearchForecastReportDummyWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchForecastReportDummyWeekRSQL").append("\n"); 
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
		query.append("SELECT	P2, P1, C0, F1, F2, F3, F4, F5, F6, F7, F8, F9" ).append("\n"); 
		query.append("	       ,CASE WHEN P2-T0 >=0 THEN 'Y' ELSE 'N' END P2_F" ).append("\n"); 
		query.append("	       ,CASE WHEN P1-T0 >=0 THEN 'Y' ELSE 'N' END P1_F" ).append("\n"); 
		query.append("	       ,CASE WHEN C0-T0 >=0 THEN 'Y' ELSE 'N' END C0_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F1-T0 >=0 THEN 'Y' ELSE 'N' END F1_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F2-T0 >=0 THEN 'Y' ELSE 'N' END F2_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F3-T0 >=0 THEN 'Y' ELSE 'N' END F3_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F4-T0 >=0 THEN 'Y' ELSE 'N' END F4_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F5-T0 >=0 THEN 'Y' ELSE 'N' END F5_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F6-T0 >=0 THEN 'Y' ELSE 'N' END F6_F" ).append("\n"); 
		query.append("	       ,CASE WHEN F7-T0 >=0 THEN 'Y' ELSE 'N' END F7_F	" ).append("\n"); 
		query.append("	       ,CASE WHEN F8-T0 >=0 THEN 'Y' ELSE 'N' END F8_F	" ).append("\n"); 
		query.append("	       ,CASE WHEN F9-T0 >=0 THEN 'Y' ELSE 'N' END F9_F	" ).append("\n"); 
		query.append("	FROM	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT  LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	P2," ).append("\n"); 
		query.append("				LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	P1," ).append("\n"); 
		query.append("				PLN_YR||PLN_WK										        C0," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	F1," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	F2," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,3)		OVER (ORDER BY PLN_YR,PLN_WK)	F3," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,4)		OVER (ORDER BY PLN_YR,PLN_WK)	F4," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,5)		OVER (ORDER BY PLN_YR,PLN_WK)	F5," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,6)		OVER (ORDER BY PLN_YR,PLN_WK)	F6," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,7)		OVER (ORDER BY PLN_YR,PLN_WK)	F7," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,8)		OVER (ORDER BY PLN_YR,PLN_WK)	F8," ).append("\n"); 
		query.append("				LEAD(PLN_YR||PLN_WK,9)		OVER (ORDER BY PLN_YR,PLN_WK)	F9," ).append("\n"); 
		query.append("                (SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) T0 -- 오늘기준 EQR WEEK" ).append("\n"); 
		query.append("		FROM	EQR_WK_PRD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE   C0  = @[fcast_yrwk] --'201328' -- Period 입력값" ).append("\n"); 

	}
}