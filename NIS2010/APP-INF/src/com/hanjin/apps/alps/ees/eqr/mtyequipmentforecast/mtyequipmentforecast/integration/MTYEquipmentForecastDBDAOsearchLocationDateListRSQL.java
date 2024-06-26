/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchLocationDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchLocationDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * repo in 의 입력가능한 일자 조회
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchLocationDateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchLocationDateListRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("    SELECT @[wk_st_dt] WK_ST_DT " ).append("\n"); 
		query.append("          ,7 WK_DAYS" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= A.WK_DAYS " ).append("\n"); 

	}
}