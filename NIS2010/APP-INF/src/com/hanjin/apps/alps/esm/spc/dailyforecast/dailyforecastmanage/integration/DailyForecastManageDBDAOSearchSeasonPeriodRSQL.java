/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchSeasonPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.08.14 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchSeasonPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accum 화면에서 사용할 Season의 기초정보를 조회합니다.
	  * 
	  * 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchSeasonPeriodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchSeasonPeriodRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC ( V XPKSPC_MDL_VER_MST ) */" ).append("\n"); 
		query.append("     COST_YRWK AS SEASON, " ).append("\n"); 
		query.append("     VER_SEQ AS VERSION, " ).append("\n"); 
		query.append("     (SELECT VER_ST_YRWK" ).append("\n"); 
		query.append("        FROM SPC_MDL_VER_MST" ).append("\n"); 
		query.append("       WHERE COST_YRWK = V.COST_YRWK" ).append("\n"); 
		query.append("         AND TRD_CD    = @[trade]" ).append("\n"); 
		query.append("         AND VER_SEQ   = 1" ).append("\n"); 
		query.append("         AND CFM_FLG   = 'Y') AS SDATE," ).append("\n"); 
		query.append("     VER_END_YRWK AS EDATE" ).append("\n"); 
		query.append("FROM SPC_MDL_VER_MST V" ).append("\n"); 
		query.append("WHERE @[year2]||@[week2] BETWEEN VER_ST_YRWK AND VER_END_YRWK" ).append("\n"); 
		query.append(" AND TRD_CD    = @[trade]" ).append("\n"); 
		query.append(" AND CFM_FLG   = 'Y'" ).append("\n"); 
		query.append(" AND COST_YRWK <> '200001'" ).append("\n"); 
		query.append(" AND ROWNUM    = 1" ).append("\n"); 

	}
}