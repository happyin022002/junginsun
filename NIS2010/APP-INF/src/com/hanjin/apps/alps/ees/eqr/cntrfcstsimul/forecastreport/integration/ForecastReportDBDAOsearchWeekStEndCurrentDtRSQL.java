/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ForecastReportDBDAOsearchWeekStEndCurrentDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.23 
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

public class ForecastReportDBDAOsearchWeekStEndCurrentDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주차 시작, 종료일 조회
	  * </pre>
	  */
	public ForecastReportDBDAOsearchWeekStEndCurrentDtRSQL(){
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
		query.append("FileName : ForecastReportDBDAOsearchWeekStEndCurrentDtRSQL").append("\n"); 
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
		query.append("#if(${tp_cd} == 'M')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MIN(WK_ST_DT)  WK_ST_DT" ).append("\n"); 
		query.append("     , MAX(WK_END_DT) WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("WHERE A.PLN_YR||A.PLN_MON = @[fcast_yrwk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.PLN_YR||A.PLN_WK WEEK " ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(A.WK_ST_DT , 'YYYYMMDD'), 'YYYYMMDD') WK_ST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(A.WK_END_DT, 'YYYYMMDD'), 'YYYYMMDD') WK_END_DT" ).append("\n"); 
		query.append("FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("WHERE A.PLN_YR||A.PLN_WK = @[fcast_yrwk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}