/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastReportDBDAOsearchMtyRepoOutDetailListRSQL.java
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

public class ForecastReportDBDAOsearchMtyRepoOutDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * forecast reposition out 데이터 조회
	  * - 20150127, CHM-201432224, REPOSITION OUT 현재미래는 지역별 날짜 사용 안함.
	  * </pre>
	  */
	public ForecastReportDBDAOsearchMtyRepoOutDetailListRSQL(){
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
		params.put("wk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchMtyRepoOutDetailListRSQL").append("\n"); 
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
		query.append("WITH REPO_IN_RESULT AS (      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CRE_SEQ" ).append("\n"); 
		query.append("      ,YARD" ).append("\n"); 
		query.append("      ,LANE" ).append("\n"); 
		query.append("      ,VVD " ).append("\n"); 
		query.append("      ,ETB" ).append("\n"); 
		query.append("      ,ETB_DAY" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DIV" ).append("\n"); 
		query.append("      ,RPT_SEQ    -- HIDDEN                                                       " ).append("\n"); 
		query.append("      ,D2_QTY " ).append("\n"); 
		query.append("      ,D4_QTY" ).append("\n"); 
		query.append("      ,D5_QTY" ).append("\n"); 
		query.append("      ,D7_QTY" ).append("\n"); 
		query.append("      ,R2_QTY" ).append("\n"); 
		query.append("      ,R5_QTY" ).append("\n"); 
		query.append("      ,R9_QTY" ).append("\n"); 
		query.append("      ,O2_QTY" ).append("\n"); 
		query.append("      ,O4_QTY" ).append("\n"); 
		query.append("      ,O5_QTY" ).append("\n"); 
		query.append("      ,S2_QTY" ).append("\n"); 
		query.append("      ,S4_QTY" ).append("\n"); 
		query.append("      ,F2_QTY" ).append("\n"); 
		query.append("      ,F4_QTY" ).append("\n"); 
		query.append("      ,F5_QTY" ).append("\n"); 
		query.append("      ,A2_QTY" ).append("\n"); 
		query.append("      ,A4_QTY " ).append("\n"); 
		query.append("      ,A5_QTY                 " ).append("\n"); 
		query.append("      ,REMARK " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(PARTITION BY YARD, LANE, VVD ORDER BY CRE_SEQ   ) AS RN -- 동일 YARD, LANE, VVD 의 경우 COD CONFIRM 우선" ).append("\n"); 
		query.append("          ,CRE_SEQ" ).append("\n"); 
		query.append("          ,YARD" ).append("\n"); 
		query.append("          ,LANE" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,ETB" ).append("\n"); 
		query.append("          ,ETB_DAY" ).append("\n"); 
		query.append("          ,POD_CD" ).append("\n"); 
		query.append("          ,DIV" ).append("\n"); 
		query.append("          ,RPT_SEQ    -- HIDDEN                                                       " ).append("\n"); 
		query.append("          ,D2_QTY " ).append("\n"); 
		query.append("          ,D4_QTY" ).append("\n"); 
		query.append("          ,D5_QTY" ).append("\n"); 
		query.append("          ,D7_QTY" ).append("\n"); 
		query.append("          ,R2_QTY" ).append("\n"); 
		query.append("          ,R5_QTY" ).append("\n"); 
		query.append("          ,R9_QTY" ).append("\n"); 
		query.append("          ,O2_QTY" ).append("\n"); 
		query.append("          ,O4_QTY" ).append("\n"); 
		query.append("          ,O5_QTY" ).append("\n"); 
		query.append("          ,S2_QTY" ).append("\n"); 
		query.append("          ,S4_QTY" ).append("\n"); 
		query.append("          ,F2_QTY" ).append("\n"); 
		query.append("          ,F4_QTY" ).append("\n"); 
		query.append("          ,F5_QTY" ).append("\n"); 
		query.append("          ,A2_QTY" ).append("\n"); 
		query.append("          ,A4_QTY          " ).append("\n"); 
		query.append("          ,A5_QTY         " ).append("\n"); 
		query.append("          ,REMARK " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (      " ).append("\n"); 
		query.append("        -- COD Confirmation 데이터 조회" ).append("\n"); 
		query.append("        SELECT '0' CRE_SEQ -- 삭제불가, REMARK 만 수정 가능" ).append("\n"); 
		query.append("              ,NVL(B.YD_CD, B.PORT_CD) YARD" ).append("\n"); 
		query.append("              ,A.SLAN_CD LANE" ).append("\n"); 
		query.append("              ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,TO_CHAR(B.ETB_DT, 'YYYY-MM-DD') ETB" ).append("\n"); 
		query.append("              ,SUBSTR(TO_CHAR(B.ETB_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3) ETB_DAY      " ).append("\n"); 
		query.append("              ,'' POD_CD  -- HIDDEN" ).append("\n"); 
		query.append("              ,'C' DIV    -- HIDDEN " ).append("\n"); 
		query.append("              ,0 RPT_SEQ    -- HIDDEN                                                       " ).append("\n"); 
		query.append("              ,NVL(B.D2_QTY,0) D2_QTY " ).append("\n"); 
		query.append("              ,NVL(B.D4_QTY,0) D4_QTY" ).append("\n"); 
		query.append("              ,NVL(B.D5_QTY,0) D5_QTY" ).append("\n"); 
		query.append("              ,NVL(B.D7_QTY,0) D7_QTY" ).append("\n"); 
		query.append("              ,NVL(B.R2_QTY,0) R2_QTY" ).append("\n"); 
		query.append("              ,NVL(B.R5_QTY,0) R5_QTY" ).append("\n"); 
		query.append("              ,NVL(B.R9_QTY,0) R9_QTY" ).append("\n"); 
		query.append("              ,NVL(B.O2_QTY,0) O2_QTY" ).append("\n"); 
		query.append("              ,NVL(B.O4_QTY,0) O4_QTY" ).append("\n"); 
		query.append("              ,NVL(B.O5_QTY,0) O5_QTY" ).append("\n"); 
		query.append("              ,NVL(B.S2_QTY,0) S2_QTY" ).append("\n"); 
		query.append("              ,NVL(B.S4_QTY,0) S4_QTY" ).append("\n"); 
		query.append("              ,NVL(B.F2_QTY,0) F2_QTY" ).append("\n"); 
		query.append("              ,NVL(B.F4_QTY,0) F4_QTY" ).append("\n"); 
		query.append("              ,NVL(B.F5_QTY,0) F5_QTY" ).append("\n"); 
		query.append("              ,NVL(B.A2_QTY,0) A2_QTY" ).append("\n"); 
		query.append("              ,NVL(B.A4_QTY,0) A4_QTY            " ).append("\n"); 
		query.append("              ,NVL(B.A5_QTY,0) A5_QTY     " ).append("\n"); 
		query.append("              ,C.DIFF_RMK REMARK     " ).append("\n"); 
		query.append("        FROM EQR_MTY_COD_VVD  A" ).append("\n"); 
		query.append("            ,EQR_MTY_COD_PORT B   " ).append("\n"); 
		query.append("            ,EQR_MTY_COD_RMK  C" ).append("\n"); 
		query.append("        WHERE A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("        AND   A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND   A.COD_CFM_DIV_CD = B.COD_CFM_DIV_CD      " ).append("\n"); 
		query.append("        AND   B.VSL_CD         = C.VSL_CD(+)" ).append("\n"); 
		query.append("        AND   B.SKD_VOY_NO     = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND   B.SKD_DIR_CD     = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND   B.COD_CFM_DIV_CD = C.COD_CFM_DIV_CD(+)    " ).append("\n"); 
		query.append("        AND   B.PORT_CD IN (                        " ).append("\n"); 
		query.append("                                SELECT LOC_CD FROM MDM_LOCATION " ).append("\n"); 
		query.append("                                WHERE SCC_CD IN ( " ).append("\n"); 
		query.append("                                               SELECT SCC_CD " ).append("\n"); 
		query.append("                                               FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("            								#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                            				   WHERE SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("            								#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                           					   WHERE ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("            								#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                            				   WHERE LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("            								#end                                 " ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                            )   " ).append("\n"); 
		query.append("        AND   B.ETB_DT BETWEEN TO_DATE(@[wk_st_dt], 'YYYYMMDD') AND TO_DATE(@[wk_end_dt], 'YYYYMMDD')+0.99999    " ).append("\n"); 
		query.append("        AND   B.LODG_DCHG_DIV_CD = 'L' -- load            " ).append("\n"); 
		query.append("        AND   B.COD_CFM_DIV_CD   = 'C' -- confirm" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        UNION ALL    " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	    -- BKG Loading Data" ).append("\n"); 
		query.append("        SELECT '2' CRE_SEQ -- 삭제불가능, 수정가능 없음." ).append("\n"); 
		query.append("              ,A.YD_CD YARD" ).append("\n"); 
		query.append("              ,A.VSL_LANE_CD LANE" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              ,TO_CHAR(A.ETD_DT, 'YYYY-MM-DD') ETB" ).append("\n"); 
		query.append("              ,SUBSTR(TO_CHAR(A.ETD_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3) ETB_DAY   " ).append("\n"); 
		query.append("              ,(SELECT X.LOC_CD FROM MDM_YARD X WHERE X.YD_CD = A.YD_CD) POD_CD -- HIDDEN" ).append("\n"); 
		query.append("              ,A.COD_CFM_DIV_CD DIV -- HIDDEN" ).append("\n"); 
		query.append("              ,0 RPT_SEQ         -- HIDDEN" ).append("\n"); 
		query.append("              ,NVL(A.D2_FCAST_QTY,0) D2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.D4_FCAST_QTY,0) D4_QTY" ).append("\n"); 
		query.append("              ,NVL(A.D5_FCAST_QTY,0) D5_QTY" ).append("\n"); 
		query.append("              ,NVL(A.D7_FCAST_QTY,0) D7_QTY" ).append("\n"); 
		query.append("              ,NVL(A.R2_FCAST_QTY,0) R2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.R5_FCAST_QTY,0) R5_QTY" ).append("\n"); 
		query.append("              ,NVL(A.R9_FCAST_QTY,0) R9_QTY" ).append("\n"); 
		query.append("              ,NVL(A.O2_FCAST_QTY,0) O2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.O4_FCAST_QTY,0) O4_QTY                              " ).append("\n"); 
		query.append("              ,NVL(A.O5_FCAST_QTY,0) O5_QTY                              " ).append("\n"); 
		query.append("              ,NVL(A.S2_FCAST_QTY,0) S2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.S4_FCAST_QTY,0) S4_QTY               " ).append("\n"); 
		query.append("              ,NVL(A.F2_FCAST_QTY,0) F2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.F4_FCAST_QTY,0) F4_QTY" ).append("\n"); 
		query.append("              ,NVL(A.F5_FCAST_QTY,0) F5_QTY                              " ).append("\n"); 
		query.append("              ,NVL(A.A2_FCAST_QTY,0) A2_QTY" ).append("\n"); 
		query.append("              ,NVL(A.A4_FCAST_QTY,0) A4_QTY" ).append("\n"); 
		query.append("              ,NVL(A.A5_FCAST_QTY,0) A5_QTY" ).append("\n"); 
		query.append("              ,A.DIFF_RMK REMARK" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        FROM EQR_CTRL_REPO_OUT_SNAP A" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                    SELECT C.YD_CD, A.SCC_CD" ).append("\n"); 
		query.append("                    FROM MDM_EQ_ORZ_CHT A,MDM_LOCATION B,MDM_YARD C                     " ).append("\n"); 
		query.append("        #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                    WHERE A.SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                    WHERE A.ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                    WHERE A.LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("        #end                                  " ).append("\n"); 
		query.append("                    AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                    AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("              ) C" ).append("\n"); 
		query.append("         WHERE A.ETD_DT BETWEEN  TO_DATE(@[wk_st_dt],'YYYYMMDD') AND TO_DATE(@[wk_end_dt],'YYYYMMDD')+0.9999          " ).append("\n"); 
		query.append("         AND   A.YD_CD = C.YD_CD         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )     " ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("WHERE RN=1 -- 동일 YARD, LANE, VVD 의 경우 COD CONFIRM 우선" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- REPO IN DETAIL(EES_EQR_1049에서 수기입력)" ).append("\n"); 
		query.append("-- 항상 조회됨(현재 + 미래)" ).append("\n"); 
		query.append("SELECT '1' CRE_SEQ -- 삭제가능" ).append("\n"); 
		query.append("      ,LOC_CD YARD" ).append("\n"); 
		query.append("      ,VSL_LANE_CD LANE" ).append("\n"); 
		query.append("      ,VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,TO_CHAR(ETD_DT, 'YYYY-MM-DD') ETB" ).append("\n"); 
		query.append("      ,SUBSTR(TO_CHAR(ETD_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3) ETB_DAY      " ).append("\n"); 
		query.append("      ,'' POD_CD  -- HIDDEN" ).append("\n"); 
		query.append("      ,'' DIV     -- HIDDEN " ).append("\n"); 
		query.append("      ,RPT_SEQ    -- HIDDEN                                                       " ).append("\n"); 
		query.append("      ,NVL(D2_FCAST_QTY,0) D2_QTY" ).append("\n"); 
		query.append("      ,NVL(D4_FCAST_QTY,0) D4_QTY" ).append("\n"); 
		query.append("      ,NVL(D5_FCAST_QTY,0) D5_QTY" ).append("\n"); 
		query.append("      ,NVL(D7_FCAST_QTY,0) D7_QTY" ).append("\n"); 
		query.append("      ,NVL(R2_FCAST_QTY,0) R2_QTY" ).append("\n"); 
		query.append("      ,NVL(R5_FCAST_QTY,0) R5_QTY" ).append("\n"); 
		query.append("      ,NVL(R9_FCAST_QTY,0) R9_QTY" ).append("\n"); 
		query.append("      ,NVL(O2_FCAST_QTY,0) O2_QTY" ).append("\n"); 
		query.append("      ,NVL(O4_FCAST_QTY,0) O4_QTY" ).append("\n"); 
		query.append("      ,NVL(O5_FCAST_QTY,0) O5_QTY" ).append("\n"); 
		query.append("      ,NVL(S2_FCAST_QTY,0) S2_QTY" ).append("\n"); 
		query.append("      ,NVL(S4_FCAST_QTY,0) S4_QTY" ).append("\n"); 
		query.append("      ,NVL(F2_FCAST_QTY,0) F2_QTY" ).append("\n"); 
		query.append("      ,NVL(F4_FCAST_QTY,0) F4_QTY" ).append("\n"); 
		query.append("      ,NVL(F5_FCAST_QTY,0) F5_QTY" ).append("\n"); 
		query.append("      ,NVL(A2_FCAST_QTY,0) A2_QTY" ).append("\n"); 
		query.append("      ,NVL(A4_FCAST_QTY,0) A4_QTY               " ).append("\n"); 
		query.append("      ,NVL(A5_FCAST_QTY,0) A5_QTY               " ).append("\n"); 
		query.append("      ,DIFF_RMK REMARK       " ).append("\n"); 
		query.append("FROM EQR_CTRL_BAL_RPT_LODG_MNL " ).append("\n"); 
		query.append("WHERE ETD_DT BETWEEN TO_DATE(@[wk_st_dt], 'YYYYMMDD') AND TO_DATE(@[wk_end_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("AND   LOC_CD IN " ).append("\n"); 
		query.append("      (                        " ).append("\n"); 
		query.append("          SELECT LOC_CD FROM MDM_LOCATION " ).append("\n"); 
		query.append("          WHERE SCC_CD IN " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("              SELECT SCC_CD " ).append("\n"); 
		query.append("              FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("    			#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("          	   WHERE SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("    			#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("          	   WHERE ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("    			#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("          	   WHERE LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("    			#end                                 " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      )                " ).append("\n"); 
		query.append("                                                                                                            " ).append("\n"); 
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
		query.append("      ,REMARK" ).append("\n"); 
		query.append("	  ,WK_ST_DT" ).append("\n"); 
		query.append("      ,WK_END_DT" ).append("\n"); 
		query.append("      ,'F' CURR_FLAG -- HIDDEN     " ).append("\n"); 
		query.append("      ,DIV        -- HIDDEN     " ).append("\n"); 
		query.append("      ,RPT_SEQ    -- HIDDEN     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT CRE_SEQ" ).append("\n"); 
		query.append("          ,'000000'   LVL" ).append("\n"); 
		query.append("          ,YARD		  TO_YD_CD" ).append("\n"); 
		query.append("          ,LANE	      VSL_LANE_CD" ).append("\n"); 
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
		query.append("          ,REMARK	" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYYMMDD'), 'YYYY/MM/DD') 	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append("          ,DIV" ).append("\n"); 
		query.append("          ,RPT_SEQ    -- HIDDEN     " ).append("\n"); 
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
		query.append("          ,NULL REMARK" ).append("\n"); 
		query.append("    	  ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYYMMDD'), 'YYYY/MM/DD')	WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')	WK_END_DT" ).append("\n"); 
		query.append("          ,NULL DIV" ).append("\n"); 
		query.append("          ,NULL RPT_SEQ    -- HIDDEN     " ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY TO_ETB_DT, TO_YD_CD ASC" ).append("\n"); 

	}
}