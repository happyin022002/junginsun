/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastSummaryDBDAOsearchCIMMatchBackWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastSummaryDBDAOsearchCIMMatchBackWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM 모듈의 MatchBack week 를 추출합니다.
	  * </pre>
	  */
	public ForecastSummaryDBDAOsearchCIMMatchBackWeekRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration").append("\n"); 
		query.append("FileName : ForecastSummaryDBDAOsearchCIMMatchBackWeekRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN PLN_YR||PLN_WK - REPLACE(@[fcast_yrwk], '-', '') <= 0 THEN (   -- 현재주차 혹은 미래 이면 -2주차(오늘기준)    " ).append("\n"); 
		query.append("                                                                                SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("                                                                                FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                                                                                WHERE SYSDATE-14 BETWEEN TO_DATE(WK_ST_DT, 'YYYYMMDD')+0.0 AND TO_DATE(WK_END_DT, 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                                                                            )" ).append("\n"); 
		query.append("            WHEN PLN_YR||PLN_WK - REPLACE(@[fcast_yrwk], '-', '') = 1 THEN  (   -- 과거1주차이면 -1주차    " ).append("\n"); 
		query.append("                                                                                SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("                                                                                FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                                                                                WHERE SYSDATE-7 BETWEEN TO_DATE(WK_ST_DT, 'YYYYMMDD')+0.0 AND TO_DATE(WK_END_DT, 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                                                                            )" ).append("\n"); 
		query.append("            WHEN PLN_YR||PLN_WK - REPLACE(@[fcast_yrwk], '-', '') > 1 THEN  (   -- 과거2주차 이상이면 입력된 주차 그대로    " ).append("\n"); 
		query.append("                                                                                REPLACE(@[fcast_yrwk], '-', '')" ).append("\n"); 
		query.append("                                                                            )  " ).append("\n"); 
		query.append("            ELSE REPLACE(@[fcast_yrwk], '-', '')                                                               " ).append("\n"); 
		query.append("        END MATCH_WEEK " ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE SYSDATE BETWEEN TO_DATE(WK_ST_DT, 'YYYYMMDD')+0.0 AND TO_DATE(WK_END_DT, 'YYYYMMDD')+0.99999" ).append("\n"); 

	}
}