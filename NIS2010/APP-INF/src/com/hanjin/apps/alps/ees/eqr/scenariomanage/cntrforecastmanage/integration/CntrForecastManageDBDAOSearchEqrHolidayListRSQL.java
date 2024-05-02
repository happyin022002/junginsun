/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAOSearchEqrHolidayListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastManageDBDAOSearchEqrHolidayListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID : EES_EQR_0114
	  * Holiday Effect Popup
	  * </pre>
	  */
	public CntrForecastManageDBDAOSearchEqrHolidayListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastManageDBDAOSearchEqrHolidayListRSQL").append("\n"); 
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
		query.append("SELECT	CNT_NM" ).append("\n"); 
		query.append(",	ST_DT" ).append("\n"); 
		query.append(",	TO_CHAR (TO_DATE (ST_DT, 'YYYYMMDD'), 'DY', 'NLS_DATE_LANGUAGE=AMERICAN') ST_DY" ).append("\n"); 
		query.append(",	END_DT" ).append("\n"); 
		query.append(",	TO_CHAR (TO_DATE (END_DT, 'YYYYMMDD'), 'DY', 'NLS_DATE_LANGUAGE=AMERICAN') END_DY" ).append("\n"); 
		query.append(",	(TO_DATE (END_DT, 'YYYYMMDD') - TO_DATE (ST_DT, 'YYYYMMDD') + 1) || 'Days' DURATION" ).append("\n"); 
		query.append(",	(SELECT	PLN_WK FROM EQR_WK_PRD WHERE WK_ST_DT <= ST_DT AND WK_END_DT >= ST_DT) || '-'" ).append("\n"); 
		query.append("||(SELECT	PLN_WK FROM EQR_WK_PRD WHERE WK_ST_DT <= END_DT AND WK_END_DT >= END_DT) WEEK" ).append("\n"); 
		query.append(",	1 AS ONE" ).append("\n"); 
		query.append(",	HOL_NM" ).append("\n"); 
		query.append(",	HOL_RMK" ).append("\n"); 
		query.append(",	HOL_YR" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	RCC_DIV_FLG" ).append("\n"); 
		query.append(",	@[scnr_id] AS SCNR_ID" ).append("\n"); 
		query.append("FROM EQR_HOLIDAY" ).append("\n"); 
		query.append("WHERE	ST_DT BETWEEN (SELECT	WK_ST_DT" ).append("\n"); 
		query.append("FROM	EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE	PLN_YR||PLN_WK = @[start_yrwk])" ).append("\n"); 
		query.append("AND	(SELECT	WK_END_DT" ).append("\n"); 
		query.append("FROM	EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE	PLN_YR||PLN_WK = @[end_yrwk])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${country} != '')" ).append("\n"); 
		query.append("AND	CNT_CD = '${country}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${holidays} != '')" ).append("\n"); 
		query.append("AND (TO_DATE (END_DT, 'YYYYMMDD') - TO_DATE (ST_DT, 'YYYYMMDD') + 1) >= '${holidays}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}