/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEqrHolidayEffectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Holiday Effect 정보출력
	  * 
	  * <Change History>
	  * 1	2010.01.20	Lee ByoungHun	PRD_HOLIDAY  --> DMT_HOLIDAY 테이블 변경
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEqrHolidayEffectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stpln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("holidays",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEqrHolidayEffectRSQL").append("\n"); 
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
		query.append("A.HOL_YR" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.CNT_NM" ).append("\n"); 
		query.append(", A.ST_DT" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(A.ST_DT,'YYYYMMDD'),'DY','NLS_DATE_LANGUAGE=AMERICAN') ST_DY" ).append("\n"); 
		query.append(", A.END_DT,TO_CHAR(TO_DATE(A.END_DT,'YYYYMMDD'),'DY','NLS_DATE_LANGUAGE=AMERICAN') END_DY" ).append("\n"); 
		query.append(", (TO_DATE(A.END_DT,'YYYYMMDD') - TO_DATE(A.ST_DT,'YYYYMMDD') + 1)||'Days'  DURATION" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_WK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("WK_ST_DT <= A.ST_DT AND WK_END_DT >= A.ST_DT	) || '-' ||" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_WK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("WK_ST_DT <= A.END_DT AND WK_END_DT >= A.END_DT" ).append("\n"); 
		query.append(") WEEK" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_HOLIDAY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("HOL_YR = A.HOL_YR" ).append("\n"); 
		query.append("AND CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("AND RCC_DIV_FLG = A.RCC_DIV_FLG" ).append("\n"); 
		query.append("AND ST_DT = A.ST_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") APPLY" ).append("\n"); 
		query.append(", A.HOL_NM, A.HOL_RMK" ).append("\n"); 
		query.append(", A.RCC_DIV_FLG" ).append("\n"); 
		query.append(",  A.DELT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HOL_YR" ).append("\n"); 
		query.append(", CNT_CD" ).append("\n"); 
		query.append(", CNT_NM" ).append("\n"); 
		query.append(", RCC_DIV_FLG" ).append("\n"); 
		query.append(", ST_DT" ).append("\n"); 
		query.append(", END_DT" ).append("\n"); 
		query.append(", HOL_NM" ).append("\n"); 
		query.append(", HOL_RMK" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PRD.HOL_YR" ).append("\n"); 
		query.append(",PRD.CNT_CD" ).append("\n"); 
		query.append(",MDM.CNT_NM" ).append("\n"); 
		query.append(",'N' RCC_DIV_FLG" ).append("\n"); 
		query.append(",TO_CHAR(PRD.ST_DT, 'YYYYMMDD') ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(PRD.END_DT, 'YYYYMMDD') END_DT" ).append("\n"); 
		query.append(",PRD.HOL_DESC HOL_NM" ).append("\n"); 
		query.append(",'' HOL_RMK" ).append("\n"); 
		query.append(",'N' DELT_FLG" ).append("\n"); 
		query.append(",MAX(PRD.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(",MAX(PRD.CRE_DT) CRE_DT" ).append("\n"); 
		query.append(",MAX(PRD.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append(",MAX(PRD.UPD_DT) UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HOL_YR" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",HOL_DESC" ).append("\n"); 
		query.append(",HOL_DT" ).append("\n"); 
		query.append(",NVL(ST_DT, LAG(ST_DT) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT)) AS ST_DT" ).append("\n"); 
		query.append(",NVL(END_DT, LEAD(END_DT) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT)) AS END_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HOL_YR" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",HOL_DESC" ).append("\n"); 
		query.append(",HOL_DT" ).append("\n"); 
		query.append(",CASE WHEN IS_CONTINUE = 'X' THEN HOL_DT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN HOL_YR <> PRE_HOL_YR OR CNT_CD <> PRE_CNT_CD OR HOL_DESC <> PRE_HOL_DESC OR HOL_DT - PRE_HOL_DT <> 1 THEN HOL_DT" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END AS ST_DT" ).append("\n"); 
		query.append(",CASE WHEN IS_CONTINUE = 'X' THEN HOL_DT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN HOL_YR <> NEXT_HOL_YR OR CNT_CD <> NEXT_CNT_CD OR HOL_DESC <> NEXT_HOL_DESC OR NEXT_HOL_DT - HOL_DT <> 1 THEN HOL_DT" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END AS END_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HOL_YR" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",HOL_DESC" ).append("\n"); 
		query.append(",HOL_DT" ).append("\n"); 
		query.append(",PRE_HOL_YR" ).append("\n"); 
		query.append(",NEXT_HOL_YR" ).append("\n"); 
		query.append(",PRE_CNT_CD" ).append("\n"); 
		query.append(",NEXT_CNT_CD" ).append("\n"); 
		query.append(",PRE_HOL_DESC" ).append("\n"); 
		query.append(",NEXT_HOL_DESC" ).append("\n"); 
		query.append(",PRE_HOL_DT" ).append("\n"); 
		query.append(",NEXT_HOL_DT" ).append("\n"); 
		query.append(",DECODE(NEXT_HOL_DT - HOL_DT, 1, 'O', DECODE(HOL_DT - PRE_HOL_DT, 1, 'O', 'X')) AS IS_CONTINUE" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HOL_YR" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",HOL_DESC" ).append("\n"); 
		query.append(",HOL_DT" ).append("\n"); 
		query.append(",LAG(HOL_YR) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS PRE_HOL_YR" ).append("\n"); 
		query.append(",LEAD(HOL_YR) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS NEXT_HOL_YR" ).append("\n"); 
		query.append(",LAG(CNT_CD) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS PRE_CNT_CD" ).append("\n"); 
		query.append(",LEAD(CNT_CD) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS NEXT_CNT_CD" ).append("\n"); 
		query.append(",LAG(HOL_DESC) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS PRE_HOL_DESC" ).append("\n"); 
		query.append(",LEAD(HOL_DESC) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS NEXT_HOL_DESC" ).append("\n"); 
		query.append(",LAG(HOL_DT) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS PRE_HOL_DT" ).append("\n"); 
		query.append(",LEAD(HOL_DT) OVER (ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT) AS NEXT_HOL_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM DMT_HOLIDAY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ST_DT IS NOT NULL OR END_DT IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY HOL_YR, CNT_CD, HOL_DESC, HOL_DT" ).append("\n"); 
		query.append(") PRD," ).append("\n"); 
		query.append("MDM_COUNTRY MDM" ).append("\n"); 
		query.append("WHERE PRD.CNT_CD = MDM.CNT_CD" ).append("\n"); 
		query.append("GROUP BY PRD.HOL_YR, PRD.CNT_CD, MDM.CNT_NM, PRD.HOL_DESC, PRD.ST_DT, PRD.END_DT" ).append("\n"); 
		query.append("ORDER BY PRD.HOL_YR, PRD.CNT_CD, MDM.CNT_NM, PRD.HOL_DESC, PRD.ST_DT, PRD.END_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", EQR_HOLIDAY  B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.HOL_YR = B.HOL_YR(+)" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.RCC_DIV_FLG = B.RCC_DIV_FLG(+)" ).append("\n"); 
		query.append("AND A.ST_DT = B.ST_DT(+)" ).append("\n"); 
		query.append("#if (${country} != '')" ).append("\n"); 
		query.append("AND A.CNT_CD = @[country]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ST_DT BETWEEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK = @[stpln]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR||PLN_WK = @[endpln]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${holidays} != '')" ).append("\n"); 
		query.append("AND (A.END_DT - A.ST_DT + 1) >= @[holidays]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}