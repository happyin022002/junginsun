/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchOpmgFcstReference2TitleWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchOpmgFcstReference2TitleWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OPMG Forecast 화면의 Reference2 데이터 조회를 위한 title week 를 조회한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchOpmgFcstReference2TitleWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchOpmgFcstReference2TitleWeekRSQL").append("\n"); 
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
		query.append("SELECT	W1" ).append("\n"); 
		query.append("	   ,W2" ).append("\n"); 
		query.append("	   ,W3" ).append("\n"); 
		query.append("	   ,W4" ).append("\n"); 
		query.append("	   ,CASE WHEN W1-C0 >=0 THEN 'Y' ELSE 'N' END W1_F  -- Y : 현재/미래, N : 과거" ).append("\n"); 
		query.append("	   ,CASE WHEN W2-C0 >=0 THEN 'Y' ELSE 'N' END W2_F  -- Y : 현재/미래, N : 과거" ).append("\n"); 
		query.append("	   ,CASE WHEN W3-C0 >=0 THEN 'Y' ELSE 'N' END W3_F  -- Y : 현재/미래, N : 과거" ).append("\n"); 
		query.append("	   ,CASE WHEN W4-C0 >=0 THEN 'Y' ELSE 'N' END W4_F  -- Y : 현재/미래, N : 과거" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  PLN_YR||PLN_WK										        W1" ).append("\n"); 
		query.append("		   ,LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)	W2" ).append("\n"); 
		query.append("		   ,LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	W3" ).append("\n"); 
		query.append("		   ,LEAD(PLN_YR||PLN_WK,3)		OVER (ORDER BY PLN_YR,PLN_WK)	W4" ).append("\n"); 
		query.append("		   ,(SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) C0 -- 오늘기준 EQR WEEK" ).append("\n"); 
		query.append("	FROM	EQR_WK_PRD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   W1  = @[repo_pln_yrwk] 	-- BALANCE REPO ID 입력값" ).append("\n"); 

	}
}