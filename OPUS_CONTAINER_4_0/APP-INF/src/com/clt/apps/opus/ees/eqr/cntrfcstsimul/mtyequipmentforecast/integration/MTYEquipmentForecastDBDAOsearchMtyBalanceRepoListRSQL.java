/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 정의
	  * - EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다
	  * - BALANCE 의 REPO IN 팝업화면
	  * 
	  * 2. 수정
	  * 2012-10-17, 소팅기준에 ETB 추가,  수석 
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL").append("\n"); 
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
		query.append("WITH REPO_IN_RESULT AS (           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${curr_flag} =='T')  -- 입력주차가 현재주차 아닌 경우" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT B.YD_CD YARD" ).append("\n"); 
		query.append("          ,B.SLAN_CD LANE" ).append("\n"); 
		query.append("          ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("          ,TO_CHAR(B.ETB_DT, 'YYYY-MM-DD') ETB" ).append("\n"); 
		query.append("          ,SUBSTR(TO_CHAR(B.ETB_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3) ETB_DAY      " ).append("\n"); 
		query.append("          ,B.POD_CD  -- HIDDEN" ).append("\n"); 
		query.append("          ,B.DIV     -- HIDDEN" ).append("\n"); 
		query.append("           -- RI 수량 - VD 수량 빼기(0 보다 작으면 0처리)                                                                 " ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.D2_QTY,0)-NVL(A.D2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.D2_QTY,0)-NVL(A.D2_QTY,0)) END D2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.D4_QTY,0)-NVL(A.D4_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.D4_QTY,0)-NVL(A.D4_QTY,0)) END D4_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.D5_QTY,0)-NVL(A.D5_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.D5_QTY,0)-NVL(A.D5_QTY,0)) END D5_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.D7_QTY,0)-NVL(A.D7_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.D7_QTY,0)-NVL(A.D7_QTY,0)) END D7_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.R2_QTY,0)-NVL(A.R2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.R2_QTY,0)-NVL(A.R2_QTY,0)) END R2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.R5_QTY,0)-NVL(A.R5_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.R5_QTY,0)-NVL(A.R5_QTY,0)) END R5_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.R9_QTY,0)-NVL(A.R9_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.R9_QTY,0)-NVL(A.R9_QTY,0)) END R9_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.O2_QTY,0)-NVL(A.O2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.O2_QTY,0)-NVL(A.O2_QTY,0)) END O2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.O4_QTY,0)-NVL(A.O4_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.O4_QTY,0)-NVL(A.O4_QTY,0)) END O4_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.S2_QTY,0)-NVL(A.S2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.S2_QTY,0)-NVL(A.S2_QTY,0)) END S2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.S4_QTY,0)-NVL(A.S4_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.S4_QTY,0)-NVL(A.S4_QTY,0)) END S4_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.F2_QTY,0)-NVL(A.F2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.F2_QTY,0)-NVL(A.F2_QTY,0)) END F2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.F4_QTY,0)-NVL(A.F4_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.F4_QTY,0)-NVL(A.F4_QTY,0)) END F4_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.F5_QTY,0)-NVL(A.F5_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.F5_QTY,0)-NVL(A.F5_QTY,0)) END F5_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.A2_QTY,0)-NVL(A.A2_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.A2_QTY,0)-NVL(A.A2_QTY,0)) END A2_QTY" ).append("\n"); 
		query.append("          ,CASE WHEN SUM(NVL(B.A4_QTY,0)-NVL(A.A4_QTY,0)) < 0 THEN 0 ELSE SUM(NVL(B.A4_QTY,0)-NVL(A.A4_QTY,0)) END A4_QTY               " ).append("\n"); 
		query.append("          ,B.REMARK" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (   " ).append("\n"); 
		query.append("        -- MVMT VD  " ).append("\n"); 
		query.append("        SELECT A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,A.VSL_LANE_CD " ).append("\n"); 
		query.append("              ,A.YD_CD" ).append("\n"); 
		query.append("              ,A.ETD_DT ETB_DT" ).append("\n"); 
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
		query.append("        FROM EQR_CTRL_BAL_RPT_DCHG_SNAP A                                               " ).append("\n"); 
		query.append("        WHERE A.ETD_DT BETWEEN TO_DATE(@[wk_st_dt], 'YYYYMMDD') AND TO_DATE((SELECT TO_CHAR(NEXT_DAY(SYSDATE, 2)-7, 'YYYYMMDD') FROM DUAL), 'YYYYMMDD')+0.99999  -- LCC별 시작일부터 이번주 월요일까지                        " ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("                ,A.YD_CD" ).append("\n"); 
		query.append("                ,A.ETD_DT" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT A.YD_CD" ).append("\n"); 
		query.append("               ,A.VSL_LANE_CD SLAN_CD" ).append("\n"); 
		query.append("               ,A.VSL_CD" ).append("\n"); 
		query.append("               ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,A.ETB_DT" ).append("\n"); 
		query.append("               ,(SELECT X.LOC_CD FROM MDM_YARD X WHERE X.YD_CD = A.YD_CD) POD_CD -- HIDDEN" ).append("\n"); 
		query.append("               ,A.COD_CFM_DIV_CD DIV -- HIDDEN" ).append("\n"); 
		query.append("               ,NVL(A.D2_FCAST_QTY,0) D2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.D4_FCAST_QTY,0) D4_QTY" ).append("\n"); 
		query.append("               ,NVL(A.D5_FCAST_QTY,0) D5_QTY" ).append("\n"); 
		query.append("               ,NVL(A.D7_FCAST_QTY,0) D7_QTY" ).append("\n"); 
		query.append("               ,NVL(A.R2_FCAST_QTY,0) R2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.R5_FCAST_QTY,0) R5_QTY" ).append("\n"); 
		query.append("               ,NVL(A.R9_FCAST_QTY,0) R9_QTY" ).append("\n"); 
		query.append("               ,NVL(A.O2_FCAST_QTY,0) O2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.S2_FCAST_QTY,0) S2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.O4_FCAST_QTY,0) O4_QTY" ).append("\n"); 
		query.append("               ,NVL(A.S4_FCAST_QTY,0) S4_QTY" ).append("\n"); 
		query.append("               ,NVL(A.F2_FCAST_QTY,0) F2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.A2_FCAST_QTY,0) A2_QTY" ).append("\n"); 
		query.append("               ,NVL(A.F4_FCAST_QTY,0) F4_QTY" ).append("\n"); 
		query.append("               ,NVL(A.A4_FCAST_QTY,0) A4_QTY" ).append("\n"); 
		query.append("               ,NVL(A.F5_FCAST_QTY,0) F5_QTY" ).append("\n"); 
		query.append("               ,NVL(A.O5_FCAST_QTY,0) O5_QTY" ).append("\n"); 
		query.append("               ,A.DIFF_RMK REMARK" ).append("\n"); 
		query.append("         FROM EQR_CTRL_REPO_SNAP A" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("                     SELECT REPO_ADD_DYS AS ADD_DYS" ).append("\n"); 
		query.append("                     FROM" ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                         SELECT A.REPO_ADD_DYS" ).append("\n"); 
		query.append("                         FROM EQR_WK_PRD_ADD_DY A," ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                  SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("                                  FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("        #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                                  WHERE SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                                  WHERE ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                                  WHERE LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("        #end                                                               ) B" ).append("\n"); 
		query.append("                         WHERE A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("                         UNION " ).append("\n"); 
		query.append("                         SELECT 0 REPO_ADD_DYS FROM DUAL " ).append("\n"); 
		query.append("                         ORDER BY REPO_ADD_DYS DESC  " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     WHERE ROWNUM=1     " ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                     SELECT C.YD_CD, A.SCC_CD" ).append("\n"); 
		query.append("                     FROM MDM_EQ_ORZ_CHT A,MDM_LOCATION B,MDM_YARD C                     " ).append("\n"); 
		query.append("        #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                     WHERE A.SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                     WHERE A.ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                     WHERE A.LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("        #end                                  " ).append("\n"); 
		query.append("                     AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                     AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                ) C" ).append("\n"); 
		query.append("         WHERE A.ETB_DT BETWEEN  TO_DATE(@[wk_st_dt],'YYYYMMDD') AND TO_DATE(@[wk_end_dt],'YYYYMMDD')+0.9999            " ).append("\n"); 
		query.append("         AND   A.YD_CD = C.YD_CD                                                                                                                     " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    WHERE  A.VSL_CD     (+) = B.VSL_CD" ).append("\n"); 
		query.append("    AND    A.SKD_VOY_NO (+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    A.SKD_DIR_CD (+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND    A.VSL_LANE_CD(+) = B.SLAN_CD" ).append("\n"); 
		query.append("    AND    A.YD_CD      (+) = B.YD_CD" ).append("\n"); 
		query.append("    GROUP BY B.YD_CD " ).append("\n"); 
		query.append("            ,B.SLAN_CD " ).append("\n"); 
		query.append("            ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD             " ).append("\n"); 
		query.append("            ,B.ETB_DT" ).append("\n"); 
		query.append("            ,B.POD_CD  -- HIDDEN" ).append("\n"); 
		query.append("            ,B.DIV     -- HIDDEN" ).append("\n"); 
		query.append("            ,B.REMARK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${curr_flag} =='F')  -- 입력주차가 현재주차가 아니거나 WEEK 가 현재주가 아닌 경우" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT A.YD_CD YARD" ).append("\n"); 
		query.append("          ,A.VSL_LANE_CD LANE" ).append("\n"); 
		query.append("          ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("          ,TO_CHAR(A.ETB_DT, 'YYYY-MM-DD') ETB" ).append("\n"); 
		query.append("          ,SUBSTR(TO_CHAR(A.ETB_DT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH'), 1,3) ETB_DAY  " ).append("\n"); 
		query.append("          ,(SELECT X.LOC_CD FROM MDM_YARD X WHERE X.YD_CD = A.YD_CD) POD_CD -- HIDDEN" ).append("\n"); 
		query.append("          ,A.COD_CFM_DIV_CD DIV -- HIDDEN" ).append("\n"); 
		query.append("          ,NVL(A.D2_FCAST_QTY,0) D2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.D4_FCAST_QTY,0) D4_QTY" ).append("\n"); 
		query.append("          ,NVL(A.D5_FCAST_QTY,0) D5_QTY" ).append("\n"); 
		query.append("          ,NVL(A.D7_FCAST_QTY,0) D7_QTY" ).append("\n"); 
		query.append("          ,NVL(A.R2_FCAST_QTY,0) R2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.R5_FCAST_QTY,0) R5_QTY" ).append("\n"); 
		query.append("          ,NVL(A.R9_FCAST_QTY,0) R9_QTY" ).append("\n"); 
		query.append("          ,NVL(A.O2_FCAST_QTY,0) O2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.S2_FCAST_QTY,0) S2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.O4_FCAST_QTY,0) O4_QTY" ).append("\n"); 
		query.append("          ,NVL(A.S4_FCAST_QTY,0) S4_QTY" ).append("\n"); 
		query.append("          ,NVL(A.F2_FCAST_QTY,0) F2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.A2_FCAST_QTY,0) A2_QTY" ).append("\n"); 
		query.append("          ,NVL(A.F4_FCAST_QTY,0) F4_QTY" ).append("\n"); 
		query.append("          ,NVL(A.A4_FCAST_QTY,0) A4_QTY" ).append("\n"); 
		query.append("          ,NVL(A.F5_FCAST_QTY,0) F5_QTY" ).append("\n"); 
		query.append("          ,NVL(A.O5_FCAST_QTY,0) O5_QTY" ).append("\n"); 
		query.append("          ,A.DIFF_RMK REMARK" ).append("\n"); 
		query.append("    FROM EQR_CTRL_REPO_SNAP A" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("                SELECT REPO_ADD_DYS AS ADD_DYS" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                     SELECT A.REPO_ADD_DYS" ).append("\n"); 
		query.append("                     FROM EQR_WK_PRD_ADD_DY A," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                               SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("                               FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("        #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                               WHERE SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                               WHERE ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                               WHERE LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("        #end                                                               ) B" ).append("\n"); 
		query.append("                     WHERE A.LCC_CD = B.LCC_CD" ).append("\n"); 
		query.append("                     UNION " ).append("\n"); 
		query.append("                     SELECT 0 REPO_ADD_DYS FROM DUAL " ).append("\n"); 
		query.append("                     ORDER BY REPO_ADD_DYS DESC  " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                WHERE ROWNUM=1     " ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("                SELECT C.YD_CD, A.SCC_CD" ).append("\n"); 
		query.append("                FROM MDM_EQ_ORZ_CHT A,MDM_LOCATION B,MDM_YARD C                     " ).append("\n"); 
		query.append("        #if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("                WHERE A.SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("                WHERE A.ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("        #elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("                WHERE A.LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("        #end                                  " ).append("\n"); 
		query.append("                AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                ) C" ).append("\n"); 
		query.append("    WHERE A.ETB_DT BETWEEN  TO_DATE(@[wk_st_dt],'YYYYMMDD') AND TO_DATE(@[wk_end_dt],'YYYYMMDD')+0.9999            " ).append("\n"); 
		query.append("    AND   A.YD_CD = C.YD_CD  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("      ,WK_ST_DT" ).append("\n"); 
		query.append("      ,WK_END_DT" ).append("\n"); 
		query.append("      ,@[curr_flag] CURR_FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT '000000' LVL" ).append("\n"); 
		query.append("           ,YARD    TO_YD_CD" ).append("\n"); 
		query.append("           ,LANE    VSL_LANE_CD" ).append("\n"); 
		query.append("           ,VVD" ).append("\n"); 
		query.append("           ,ETB     TO_ETB_DT" ).append("\n"); 
		query.append("           ,ETB_DAY TO_ETB_DAY" ).append("\n"); 
		query.append("           ,D2_QTY  D2_FCAST_QTY" ).append("\n"); 
		query.append("           ,D4_QTY  D4_FCAST_QTY" ).append("\n"); 
		query.append("           ,D5_QTY  D5_FCAST_QTY" ).append("\n"); 
		query.append("           ,D7_QTY  D7_FCAST_QTY" ).append("\n"); 
		query.append("           ,R2_QTY  R2_FCAST_QTY " ).append("\n"); 
		query.append("           ,R5_QTY  R5_FCAST_QTY" ).append("\n"); 
		query.append("           ,R9_QTY  R9_FCAST_QTY" ).append("\n"); 
		query.append("           ,O2_QTY  O2_FCAST_QTY" ).append("\n"); 
		query.append("           ,S2_QTY  S2_FCAST_QTY" ).append("\n"); 
		query.append("           ,O4_QTY  O4_FCAST_QTY" ).append("\n"); 
		query.append("           ,S4_QTY  S4_FCAST_QTY" ).append("\n"); 
		query.append("           ,F2_QTY  F2_FCAST_QTY" ).append("\n"); 
		query.append("           ,A2_QTY  A2_FCAST_QTY" ).append("\n"); 
		query.append("           ,F4_QTY  F4_FCAST_QTY" ).append("\n"); 
		query.append("           ,A4_QTY  A4_FCAST_QTY" ).append("\n"); 
		query.append("           ,F5_QTY  F5_FCAST_QTY" ).append("\n"); 
		query.append("           ,REMARK    " ).append("\n"); 
		query.append("           ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYYMMDD'), 'YYYY/MM/DD')     WK_ST_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')    WK_END_DT" ).append("\n"); 
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
		query.append("              +F2_QTY" ).append("\n"); 
		query.append("              +A2_QTY" ).append("\n"); 
		query.append("              +F4_QTY" ).append("\n"); 
		query.append("              +A4_QTY" ).append("\n"); 
		query.append("              +F5_QTY " ).append("\n"); 
		query.append("           ) > 0  -- 0보다 큰것만 수집" ).append("\n"); 
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
		query.append("          ,TO_CHAR(TO_DATE(@[wk_st_dt], 'YYYYMMDD'), 'YYYY/MM/DD')    WK_ST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(@[wk_end_dt], 'YYYYMMDD'), 'YYYY/MM/DD')   WK_END_DT" ).append("\n"); 
		query.append("    FROM REPO_IN_RESULT " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY LVL, TO_ETB_DT ASC" ).append("\n"); 

	}
}