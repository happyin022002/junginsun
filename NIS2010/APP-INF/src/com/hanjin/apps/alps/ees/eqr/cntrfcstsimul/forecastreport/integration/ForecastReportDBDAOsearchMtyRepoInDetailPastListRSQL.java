/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastReportDBDAOsearchMtyRepoInDetailPastListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOsearchMtyRepoInDetailPastListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reposition In Detail 과거데이터 상세 조회(RI + MR)
	  * </pre>
	  */
	public ForecastReportDBDAOsearchMtyRepoInDetailPastListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchMtyRepoInDetailPastListRSQL").append("\n"); 
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
		query.append("WITH REPO_IN_RESULT AS (  " ).append("\n"); 
		query.append("    SELECT A.FCAST_YRWK" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,A.YD_CD" ).append("\n"); 
		query.append("          ,A.VSL_LANE_CD " ).append("\n"); 
		query.append("          ,A.VVD" ).append("\n"); 
		query.append("          ,MAX(TO_CHAR(A.ETB_DT, 'YYYY-MM-DD')) ETB" ).append("\n"); 
		query.append("          ,MAX(SUBSTR(TO_CHAR(A.ETB_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3)) ETB_DAY                       " ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'D2', A.CNTR_NO)) D2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'D4', A.CNTR_NO)) D4_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'D5', A.CNTR_NO)) D5_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'D7', A.CNTR_NO)) D7_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'R2', A.CNTR_NO)) R2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'R5', A.CNTR_NO)) R5_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'R9', A.CNTR_NO)) R9_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'O2', A.CNTR_NO)) O2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'S2', A.CNTR_NO)) S2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'O4', A.CNTR_NO)) O4_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'S4', A.CNTR_NO)) S4_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'O5', A.CNTR_NO)) O5_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'F2', A.CNTR_NO)) F2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'A2', A.CNTR_NO)) A2_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'F4', A.CNTR_NO)) F4_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'A4', A.CNTR_NO)) A4_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'A5', A.CNTR_NO)) A5_QTY" ).append("\n"); 
		query.append("          ,COUNT(DECODE(A.CNTR_TPSZ_CD, 'F5', A.CNTR_NO)) F5_QTY" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (           " ).append("\n"); 
		query.append("        SELECT A.FCAST_YRWK" ).append("\n"); 
		query.append("              ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("              ,A.YD_CD" ).append("\n"); 
		query.append("              ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                  SELECT VPS_ETB_DT" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                  WHERE VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("                  AND   SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("                  AND   SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND   YD_CD      = A.YD_CD" ).append("\n"); 
		query.append("                  AND   CLPT_IND_SEQ = 1              " ).append("\n"); 
		query.append("               )  ETB_DT" ).append("\n"); 
		query.append("              ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CNTR_NO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        FROM EQR_CTRL_MTY_WKY_SIM_DTL A" ).append("\n"); 
		query.append("            ,EQR_WK_PRD B   " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        WHERE A.FCAST_YRWK = B.PLN_YR||B.PLN_WK                      " ).append("\n"); 
		query.append("#if(${tp_cd} == 'W')                      " ).append("\n"); 
		query.append("        AND   B.PLN_YR||B.PLN_WK = @[fcast_yrwk]" ).append("\n"); 
		query.append("#elseif(${tp_cd} == 'M')                      " ).append("\n"); 
		query.append("        AND   B.PLN_YR||B.PLN_MON = @[fcast_yrwk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND   A.WKY_SIM_TP_CD IN ('RI', 'MR')" ).append("\n"); 
		query.append("        AND   A.LOC_GRP_CD    = @[loc_grp_cd]" ).append("\n"); 
		query.append("        AND   A.LOC_CD        = @[loc_cd]" ).append("\n"); 
		query.append("    ) A    " ).append("\n"); 
		query.append("    GROUP BY A.FCAST_YRWK" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,A.YD_CD" ).append("\n"); 
		query.append("          ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("          ,A.VVD" ).append("\n"); 
		query.append("          ,A.ETB_DT    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CRE_SEQ" ).append("\n"); 
		query.append("      ,LVL" ).append("\n"); 
		query.append("      ,TO_YD_CD" ).append("\n"); 
		query.append("      ,VSL_LANE_CD" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,TO_ETB_DT" ).append("\n"); 
		query.append("      ,REPLACE(TO_ETB_DT, '-', '') TO_ETB_DT_ORG" ).append("\n"); 
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
		query.append("      ,O5_FCAST_QTY" ).append("\n"); 
		query.append("      ,F2_FCAST_QTY" ).append("\n"); 
		query.append("      ,A2_FCAST_QTY" ).append("\n"); 
		query.append("      ,F4_FCAST_QTY" ).append("\n"); 
		query.append("      ,A4_FCAST_QTY" ).append("\n"); 
		query.append("      ,A5_FCAST_QTY" ).append("\n"); 
		query.append("      ,F5_FCAST_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,WK_ST_DT" ).append("\n"); 
		query.append("      ,WK_END_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT '1' CRE_SEQ" ).append("\n"); 
		query.append("          ,'000000'   LVL" ).append("\n"); 
		query.append("          ,YD_CD      TO_YD_CD" ).append("\n"); 
		query.append("          ,VSL_LANE_CD VSL_LANE_CD" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,ETB		  TO_ETB_DT" ).append("\n"); 
		query.append("          ,ETB_DAY	  TO_ETB_DAY" ).append("\n"); 
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
		query.append("          ,O5_QTY	  O5_FCAST_QTY" ).append("\n"); 
		query.append("          ,F2_QTY	  F2_FCAST_QTY" ).append("\n"); 
		query.append("          ,A2_QTY	  A2_FCAST_QTY" ).append("\n"); 
		query.append("          ,F4_QTY	  F4_FCAST_QTY" ).append("\n"); 
		query.append("          ,A4_QTY	  A4_FCAST_QTY" ).append("\n"); 
		query.append("          ,A5_QTY	  A5_FCAST_QTY" ).append("\n"); 
		query.append("          ,F5_QTY	  F5_FCAST_QTY" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt],  'YYYYMMDD'), 'YYYY/MM/DD') 	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT       " ).append("\n"); 
		query.append("    WHERE  (" ).append("\n"); 
		query.append("               D2_QTY" ).append("\n"); 
		query.append("              +D4_QTY" ).append("\n"); 
		query.append("              +D5_QTY" ).append("\n"); 
		query.append("              +D7_QTY" ).append("\n"); 
		query.append("              +R2_QTY  " ).append("\n"); 
		query.append("              +R5_QTY" ).append("\n"); 
		query.append("              +R9_QTY" ).append("\n"); 
		query.append("              +O2_QTY" ).append("\n"); 
		query.append("              +S2_QTY" ).append("\n"); 
		query.append("              +O4_QTY" ).append("\n"); 
		query.append("              +S4_QTY" ).append("\n"); 
		query.append("              +O5_QTY" ).append("\n"); 
		query.append("              +F2_QTY" ).append("\n"); 
		query.append("              +A2_QTY" ).append("\n"); 
		query.append("              +F4_QTY" ).append("\n"); 
		query.append("              +A4_QTY" ).append("\n"); 
		query.append("              +A5_QTY" ).append("\n"); 
		query.append("              +F5_QTY " ).append("\n"); 
		query.append("           ) > 0  -- 0보다 큰것만 수집" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    -- TOTAL" ).append("\n"); 
		query.append("    SELECT '0' CRE_SEQ" ).append("\n"); 
		query.append("          ,'111111' LVL" ).append("\n"); 
		query.append("          ,NULL TO_YD_CD" ).append("\n"); 
		query.append("          ,NULL VSL_LANE_CD" ).append("\n"); 
		query.append("          ,NULL VVD" ).append("\n"); 
		query.append("          ,NULL TO_ETB_DT" ).append("\n"); 
		query.append("          ,NULL TO_ETB_DAY" ).append("\n"); 
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
		query.append("          ,SUM(O5_QTY) O5_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F2_QTY) F2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(A2_QTY) A2_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F4_QTY) F4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(A4_QTY) A4_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(A5_QTY) A5_FCAST_QTY" ).append("\n"); 
		query.append("          ,SUM(F5_QTY) F5_FCAST_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt],  'YYYYMMDD'), 'YYYY/MM/DD')	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY TO_ETB_DT, TO_YD_CD ASC" ).append("\n"); 

	}
}