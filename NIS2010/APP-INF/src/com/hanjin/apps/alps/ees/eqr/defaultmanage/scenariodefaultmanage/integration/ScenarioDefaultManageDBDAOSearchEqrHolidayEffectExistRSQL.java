/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.05 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEqrHolidayEffectExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_HOL_PERF,  EQR_HOL_EFF_RTO, EQR_HOLIDAY 3개 테이블에서 특정 데이터 존재하는지 여부 확인
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEqrHolidayEffectExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holyr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_div_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntcd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectExistRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_HOL_PERF A" ).append("\n"); 
		query.append(", EQR_HOL_EFF_RTO  B" ).append("\n"); 
		query.append(", EQR_HOLIDAY  C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = B.RCC_DIV_FLG" ).append("\n"); 
		query.append("AND A.WK_DY_CD = B.WK_DY_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.HOL_PERF_YR = C.HOL_YR" ).append("\n"); 
		query.append("AND A.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = C.RCC_DIV_FLG" ).append("\n"); 
		query.append("AND B.IO_BND_CD = @[gubun]" ).append("\n"); 
		query.append("AND B.RCC_DIV_FLG = @[rcc_div_flg]" ).append("\n"); 
		query.append("AND B.CNT_CD = @[cntcd]" ).append("\n"); 
		query.append("AND B.HOL_YR = @[holyr]" ).append("\n"); 
		query.append("AND B.ST_DT = @[stdt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}