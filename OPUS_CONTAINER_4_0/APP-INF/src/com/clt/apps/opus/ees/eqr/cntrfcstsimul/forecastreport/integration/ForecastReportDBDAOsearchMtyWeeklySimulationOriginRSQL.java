/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOsearchMtyWeeklySimulationOriginRSQL.java
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

public class ForecastReportDBDAOsearchMtyWeeklySimulationOriginRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 셀의 원래 값을 찾아온다
	  * </pre>
	  */
	public ForecastReportDBDAOsearchMtyWeeklySimulationOriginRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchMtyWeeklySimulationOriginRSQL").append("\n"); 
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
		query.append("--  1.정의 : 현재데이터 조회" ).append("\n"); 
		query.append("--  2.변수" ).append("\n"); 
		query.append("--    :loc_grp_cd" ).append("\n"); 
		query.append("--    :loc_cd" ).append("\n"); 
		query.append("--    :week       - 화면타이틀의 WEEK와 일치함." ).append("\n"); 
		query.append("--    :cntr_tpsz" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sim_tp_cd} == 'RO')" ).append("\n"); 
		query.append("-- REPO OUT 조회" ).append("\n"); 
		query.append("SELECT WEEK" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,LOC_GRP_CD" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(SUM(CNTR_QTY), 0) AS CNTR_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(              " ).append("\n"); 
		query.append("    -- REPO OUT 조회       " ).append("\n"); 
		query.append("    SELECT A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("          ,A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,B.INTG_CD_VAL_CTNT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          ,CASE WHEN B.INTG_CD_VAL_CTNT='D2' THEN NVL(A.D2_FCAST_QTY,0)" ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D4' THEN NVL(A.D4_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D5' THEN NVL(A.D5_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D7' THEN NVL(A.D7_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R2' THEN NVL(A.R2_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R5' THEN NVL(A.R5_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R9' THEN NVL(A.R9_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O2' THEN NVL(A.O2_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O4' THEN NVL(A.O4_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S2' THEN NVL(A.S2_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S4' THEN NVL(A.S4_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F2' THEN NVL(A.F2_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F4' THEN NVL(A.F4_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F5' THEN NVL(A.F5_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A2' THEN NVL(A.A2_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A4' THEN NVL(A.A4_FCAST_QTY,0)       " ).append("\n"); 
		query.append("                END CNTR_QTY  " ).append("\n"); 
		query.append("    FROM EQR_CTRL_BAL_RPT_REPO_OUT A" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL B    " ).append("\n"); 
		query.append("    WHERE A.LOC_GRP_CD    = @[loc_grp_cd] --L/E/S" ).append("\n"); 
		query.append("    AND   A.LOC_CD        = @[loc_cd] " ).append("\n"); 
		query.append("    AND   A.INP_YRWK      = (" ).append("\n"); 
		query.append("                                SELECT WEEK" ).append("\n"); 
		query.append("                                FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                    SELECT PLN_YR||PLN_WK WEEK" ).append("\n"); 
		query.append("                                    FROM EQR_WK_PRD " ).append("\n"); 
		query.append("                                    WHERE PLN_YR||PLN_WK < @[week]" ).append("\n"); 
		query.append("                                    ORDER BY PLN_YR||PLN_WK DESC" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                                WHERE ROWNUM=1    " ).append("\n"); 
		query.append("                            )             " ).append("\n"); 
		query.append("    AND   A.FCAST_YRWK    = @[week]        " ).append("\n"); 
		query.append("    AND   B.INTG_CD_ID    = 'CD00830'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD = UPPER(@[cntr_tpsz])" ).append("\n"); 
		query.append("GROUP BY WEEK " ).append("\n"); 
		query.append("        ,LOC_CD" ).append("\n"); 
		query.append("        ,LOC_GRP_CD" ).append("\n"); 
		query.append("        ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sim_tp_cd} == 'OF')" ).append("\n"); 
		query.append("-- OP FORECAST" ).append("\n"); 
		query.append("SELECT WEEK" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,LOC_GRP_CD" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(CNTR_QTY, 0) AS CNTR_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(                  " ).append("\n"); 
		query.append("    -- 동일한 FCAST_YRWK 중에 가장 최근 INP_YRWK 의 데이터 를 찾음 " ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(PARTITION BY A.FCAST_YRWK, A.LOC_CD, A.LOC_GRP_CD, B.INTG_CD_VAL_CTNT ORDER BY INP_YRWK DESC) RN" ).append("\n"); 
		query.append("          ,A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("          ,A.INP_YRWK" ).append("\n"); 
		query.append("          ,A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,B.INTG_CD_VAL_CTNT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          ,CASE WHEN B.INTG_CD_VAL_CTNT='D2' THEN NVL(SUM(D2_FCAST_QTY),0) " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D4' THEN NVL(SUM(D4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D5' THEN NVL(SUM(D5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D7' THEN NVL(SUM(D7_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R2' THEN NVL(SUM(R2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R5' THEN NVL(SUM(R5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R9' THEN NVL(SUM(R9_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O2' THEN NVL(SUM(O2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O4' THEN NVL(SUM(O4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S2' THEN NVL(SUM(S2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S4' THEN NVL(SUM(S4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F2' THEN NVL(SUM(F2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F4' THEN NVL(SUM(F4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F5' THEN NVL(SUM(F5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A2' THEN NVL(SUM(A2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A4' THEN NVL(SUM(A4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                END CNTR_QTY   " ).append("\n"); 
		query.append("    FROM EQR_CTRL_MTY_BAL_RPT A" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL B     " ).append("\n"); 
		query.append("    WHERE A.CO_CD         = 'H'" ).append("\n"); 
		query.append("    AND   A.MTY_BAL_TP_CD = '3'         --OUT FORECAST" ).append("\n"); 
		query.append("    AND   A.LOC_GRP_CD    = @[loc_grp_cd] --L/E/S" ).append("\n"); 
		query.append("    AND   A.LOC_CD        = @[loc_cd]              " ).append("\n"); 
		query.append("    AND   A.FCAST_YRWK    = @[week] " ).append("\n"); 
		query.append("    AND   B.INTG_CD_ID    = 'CD00830'" ).append("\n"); 
		query.append("    GROUP BY A.FCAST_YRWK" ).append("\n"); 
		query.append("            ,A.INP_YRWK " ).append("\n"); 
		query.append("            ,A.LOC_CD" ).append("\n"); 
		query.append("            ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("            ,B.INTG_CD_VAL_CTNT    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD = UPPER(@[cntr_tpsz])" ).append("\n"); 
		query.append("AND   RN = 1 -- 동일한 FCAST_YRWK 중에 가장 최근 INP_YRWK 의 데이터 를 찾음 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sim_tp_cd} == 'IF')" ).append("\n"); 
		query.append("-- MG FORECAST" ).append("\n"); 
		query.append("SELECT WEEK" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,LOC_GRP_CD" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,NVL(CNTR_QTY, 0)  AS CNTR_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(                    " ).append("\n"); 
		query.append("    -- 동일한 FCAST_YRWK 중에 가장 최근 INP_YRWK 의 데이터 를 찾음 " ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(PARTITION BY A.FCAST_YRWK, A.LOC_CD, A.LOC_GRP_CD, B.INTG_CD_VAL_CTNT ORDER BY INP_YRWK DESC) RN" ).append("\n"); 
		query.append("          ,A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("          ,A.INP_YRWK" ).append("\n"); 
		query.append("          ,A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,B.INTG_CD_VAL_CTNT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          ,CASE WHEN B.INTG_CD_VAL_CTNT='D2' THEN NVL(SUM(D2_FCAST_QTY),0) " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D4' THEN NVL(SUM(D4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D5' THEN NVL(SUM(D5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='D7' THEN NVL(SUM(D7_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R2' THEN NVL(SUM(R2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R5' THEN NVL(SUM(R5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='R9' THEN NVL(SUM(R9_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O2' THEN NVL(SUM(O2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='O4' THEN NVL(SUM(O4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S2' THEN NVL(SUM(S2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='S4' THEN NVL(SUM(S4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F2' THEN NVL(SUM(F2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F4' THEN NVL(SUM(F4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='F5' THEN NVL(SUM(F5_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A2' THEN NVL(SUM(A2_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                WHEN B.INTG_CD_VAL_CTNT='A4' THEN NVL(SUM(A4_FCAST_QTY),0)       " ).append("\n"); 
		query.append("                END CNTR_QTY    " ).append("\n"); 
		query.append("    FROM EQR_CTRL_MTY_BAL_RPT A" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL B        " ).append("\n"); 
		query.append("    WHERE A.CO_CD         = 'H'" ).append("\n"); 
		query.append("    AND   A.MTY_BAL_TP_CD = '1'         --(MG)IF FORECAST" ).append("\n"); 
		query.append("    AND   A.LOC_GRP_CD    = @[loc_grp_cd] --L/E/S" ).append("\n"); 
		query.append("    AND   A.LOC_CD        = @[loc_cd]          " ).append("\n"); 
		query.append("    AND   A.FCAST_YRWK    = @[week] " ).append("\n"); 
		query.append("    AND   B.INTG_CD_ID    = 'CD00830'" ).append("\n"); 
		query.append("    GROUP BY A.FCAST_YRWK " ).append("\n"); 
		query.append("            ,A.INP_YRWK" ).append("\n"); 
		query.append("            ,A.LOC_CD" ).append("\n"); 
		query.append("            ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("            ,B.INTG_CD_VAL_CTNT             " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD = UPPER(@[cntr_tpsz])" ).append("\n"); 
		query.append("AND   RN = 1 -- 동일한 FCAST_YRWK 중에 가장 최근 INP_YRWK 의 데이터 를 찾음 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}