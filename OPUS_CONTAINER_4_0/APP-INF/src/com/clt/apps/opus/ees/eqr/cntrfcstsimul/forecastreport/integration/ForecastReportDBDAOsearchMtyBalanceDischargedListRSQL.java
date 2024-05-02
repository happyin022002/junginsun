/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.15 
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

public class ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo In 팝업 시 현재 주차일 경우 Discharged List를 조회
	  * </pre>
	  */
	public ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL").append("\n"); 
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
		query.append("--Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration" ).append("\n"); 
		query.append("--FileName : ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL" ).append("\n"); 
		query.append("--loc_cd    : KRPUS" ).append("\n"); 
		query.append("--wk_St_dt  : 20130630" ).append("\n"); 
		query.append("--wk_end_dt : 20130706" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH REPO_IN_RESULT AS (           " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        -- MVMT VD  " ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,A.VSL_LANE_CD  LANE" ).append("\n"); 
		query.append("              ,A.YD_CD YARD" ).append("\n"); 
		query.append("              ,TO_CHAR(A.ETD_DT, 'YYYY-MM-DD') ETB_DT" ).append("\n"); 
		query.append("              ,SUBSTR(TO_CHAR(A.ETD_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1, 3) ETB_DAY " ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'D2', A.CNTR_QTY)),0) D2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'D4', A.CNTR_QTY)),0) D4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'D5', A.CNTR_QTY)),0) D5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'D7', A.CNTR_QTY)),0) D7_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'R2', A.CNTR_QTY)),0) R2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'R5', A.CNTR_QTY)),0) R5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'R9', A.CNTR_QTY)),0) R9_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'O2', A.CNTR_QTY)),0) O2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'S2', A.CNTR_QTY)),0) S2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'O4', A.CNTR_QTY)),0) O4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'S4', A.CNTR_QTY)),0) S4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'F2', A.CNTR_QTY)),0) F2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'A2', A.CNTR_QTY)),0) A2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'F4', A.CNTR_QTY)),0) F4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'A4', A.CNTR_QTY)),0) A4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, 'F5', A.CNTR_QTY)),0) F5_QTY" ).append("\n"); 
		query.append("              ,'' REMARK" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("        FROM EQR_CTRL_BAL_RPT_DCHG_SNAP A                                               " ).append("\n"); 
		query.append("        WHERE A.ETD_DT BETWEEN TO_DATE(@[wk_st_dt], 'YYYY/MM/DD') " ).append("\n"); 
		query.append("                       AND     TO_DATE((SELECT TO_CHAR(NEXT_DAY(SYSDATE, 2)-7, 'YYYY/MM/DD') FROM DUAL), 'YYYY/MM/DD')+0.99999  -- LCC별 시작일부터 이번주 월요일까지                        " ).append("\n"); 
		query.append("        AND   A.YD_CD IN (" ).append("\n"); 
		query.append("                            SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                            WHERE LOC_CD IN (" ).append("\n"); 
		query.append("                                                SELECT LOC_CD FROM MDM_LOCATION " ).append("\n"); 
		query.append("                                                WHERE SCC_CD IN ( " ).append("\n"); 
		query.append("                                                             SELECT SCC_CD " ).append("\n"); 
		query.append("                                                             FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("        													 WHERE 1=1" ).append("\n"); 
		query.append("                                                    #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                        									 AND SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("                                                    #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                       										 AND ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("                                                    #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                        									 AND LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("                                                    #end                                                                                                                   " ).append("\n"); 
		query.append("                                                                 )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                         )                           " ).append("\n"); 
		query.append("		GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("                ,A.YD_CD" ).append("\n"); 
		query.append("                ,A.ETD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT LVL" ).append("\n"); 
		query.append("      ,TO_YD_CD" ).append("\n"); 
		query.append("      ,VSL_LANE_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,TO_ETB_DT" ).append("\n"); 
		query.append("      ,TO_ETB_DAY" ).append("\n"); 
		query.append("      ,D2_FCAST_QTY" ).append("\n"); 
		query.append("      ,D4_FCAST_QTY" ).append("\n"); 
		query.append("      ,D5_FCAST_QTY" ).append("\n"); 
		query.append("      ,D7_FCAST_QTY" ).append("\n"); 
		query.append("      ,R2_FCAST_QTY" ).append("\n"); 
		query.append("      ,R5_FCAST_QTY" ).append("\n"); 
		query.append("      ,R9_FCAST_QTY" ).append("\n"); 
		query.append("      ,O2_FCAST_QTY" ).append("\n"); 
		query.append("      ,S2_FCAST_QTY" ).append("\n"); 
		query.append("      ,O4_FCAST_QTY" ).append("\n"); 
		query.append("      ,S4_FCAST_QTY" ).append("\n"); 
		query.append("      ,F2_FCAST_QTY" ).append("\n"); 
		query.append("      ,A2_FCAST_QTY" ).append("\n"); 
		query.append("      ,F4_FCAST_QTY" ).append("\n"); 
		query.append("      ,A4_FCAST_QTY" ).append("\n"); 
		query.append("      ,F5_FCAST_QTY" ).append("\n"); 
		query.append("      ,REMARK" ).append("\n"); 
		query.append("	  ,WK_ST_DT" ).append("\n"); 
		query.append("      ,WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT '000000' LVL" ).append("\n"); 
		query.append("          ,YARD		TO_YD_CD" ).append("\n"); 
		query.append("          ,LANE	    VSL_LANE_CD" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,ETB_DT	TO_ETB_DT" ).append("\n"); 
		query.append("          ,ETB_DAY	TO_ETB_DAY" ).append("\n"); 
		query.append("          ,D2_QTY	  D2_FCAST_QTY" ).append("\n"); 
		query.append("          ,D4_QTY	  D4_FCAST_QTY" ).append("\n"); 
		query.append("          ,D5_QTY	  D5_FCAST_QTY" ).append("\n"); 
		query.append("          ,D7_QTY	  D7_FCAST_QTY" ).append("\n"); 
		query.append("          ,R2_QTY	  R2_FCAST_QTY " ).append("\n"); 
		query.append("          ,R5_QTY	  R5_FCAST_QTY" ).append("\n"); 
		query.append("          ,R9_QTY	  R9_FCAST_QTY" ).append("\n"); 
		query.append("          ,O2_QTY	  O2_FCAST_QTY" ).append("\n"); 
		query.append("          ,S2_QTY	  S2_FCAST_QTY" ).append("\n"); 
		query.append("          ,O4_QTY	  O4_FCAST_QTY" ).append("\n"); 
		query.append("          ,S4_QTY	  S4_FCAST_QTY" ).append("\n"); 
		query.append("          ,F2_QTY	  F2_FCAST_QTY" ).append("\n"); 
		query.append("          ,A2_QTY	  A2_FCAST_QTY" ).append("\n"); 
		query.append("          ,F4_QTY	  F4_FCAST_QTY" ).append("\n"); 
		query.append("          ,A4_QTY	  A4_FCAST_QTY" ).append("\n"); 
		query.append("          ,F5_QTY	  F5_FCAST_QTY" ).append("\n"); 
		query.append("          ,REMARK	" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYY/MM/DD'), 'YYYY/MM/DD') 	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYY/MM/DD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    -- TOTAL" ).append("\n"); 
		query.append("    SELECT '111111' LVL" ).append("\n"); 
		query.append("          ,'' TO_YD_CD" ).append("\n"); 
		query.append("          ,'' VSL_LANE_CD" ).append("\n"); 
		query.append("          ,'' VVD" ).append("\n"); 
		query.append("          ,'' TO_ETB_DT" ).append("\n"); 
		query.append("          ,'' TO_ETB_DAY" ).append("\n"); 
		query.append("          ,SUM(D2_QTY) D2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(D4_QTY) D4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(D5_QTY) D5_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(D7_QTY) D7_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(R2_QTY) R2_FCAST_QTY  " ).append("\n"); 
		query.append("          ,SUM(R5_QTY) R5_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(R9_QTY) R9_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(O2_QTY) O2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(S2_QTY) S2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(O4_QTY) O4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(S4_QTY) S4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F2_QTY) F2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(A2_QTY) A2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F4_QTY) F4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(A4_QTY) A4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F5_QTY) F5_FCAST_QTY" ).append("\n"); 
		query.append("          ,'' REMARK" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYY/MM/DD'), 'YYYY/MM/DD')	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYY/MM/DD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY LVL, TO_ETB_DT ASC" ).append("\n"); 

	}
}