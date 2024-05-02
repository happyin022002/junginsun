/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOcheckCurrWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
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

public class ForecastReportDBDAOcheckCurrWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 주차가 현재주차인지 확인 
	  * </pre>
	  */
	public ForecastReportDBDAOcheckCurrWeekRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOcheckCurrWeekRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN WK_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND WK_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD') " ).append("\n"); 
		query.append("            THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("       END CURR_FLAG     " ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[fcast_yrwk]" ).append("\n"); 

	}
}