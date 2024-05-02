/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchDateListByWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.29 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchDateListByWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 주차내의 일자 목록을 조회한다
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchDateListByWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchDateListByWeekRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(A.WK_ST_DT,'YYYYMMDD') + LEVEL-1,'YYYY-MM-DD') DATE_LIST_BY_WEEK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT WK_ST_DT,WK_END_DT,TO_DATE(WK_END_DT,'YYYYMMDD')-TO_DATE(WK_ST_DT,'YYYYMMDD')+1 WK_DAYS" ).append("\n"); 
		query.append("FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("WHERE PLN_YR=SUBSTR(@[year_week],1,4)" ).append("\n"); 
		query.append("AND PLN_WK=SUBSTR(@[year_week],5,2)) A" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= A.WK_DAYS" ).append("\n"); 

	}
}