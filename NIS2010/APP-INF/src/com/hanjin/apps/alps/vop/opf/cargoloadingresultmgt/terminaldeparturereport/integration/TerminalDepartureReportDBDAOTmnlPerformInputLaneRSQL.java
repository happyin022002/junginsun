/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 터미널생산성 조회
	  * 
	  * 2011.11.14 [CHM-201114541-01] 김민아 [OPF] SQL 튜닝결과적용
	  * 2015.08.17  김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("manu_in_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("carr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL").append("\n"); 
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
		query.append("WITH MVC AS (" ).append("\n"); 
		query.append("				SELECT 		UNIQUE " ).append("\n"); 
		query.append("							VSL_CD" ).append("\n"); 
		query.append("						, 	CRR_CD  " ).append("\n"); 
		query.append("				FROM 		MDM_VSL_CNTR " ).append("\n"); 
		query.append("				ORDER BY 	CRR_CD " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM AS RN, A.* FROM (" ).append("\n"); 
		query.append("SELECT RHQ," ).append("\n"); 
		query.append("       PORT," ).append("\n"); 
		query.append("       LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       TO_CHAR(ETB,'yyyy-mm-dd hh24:mi') ETB," ).append("\n"); 
		query.append("       TO_CHAR(ETD,'yyyy-mm-dd hh24:mi') ETD," ).append("\n"); 
		query.append("       TO_CHAR(ATA,'yyyy-mm-dd hh24:mi') ATA," ).append("\n"); 
		query.append("       TO_CHAR(ATB,'yyyy-mm-dd hh24:mi') ATB," ).append("\n"); 
		query.append("       TO_CHAR(ATD,'yyyy-mm-dd hh24:mi') ATD," ).append("\n"); 
		query.append("       ARR_DELAY," ).append("\n"); 
		query.append("       ARR_WAIT," ).append("\n"); 
		query.append("       PORT_DELAY," ).append("\n"); 
		query.append("       PORT_WORK," ).append("\n"); 
		query.append("       DEP_DELAY," ).append("\n"); 
		query.append("       TUG_IN," ).append("\n"); 
		query.append("       TUG_OUT," ).append("\n"); 
		query.append("       CGO_FL," ).append("\n"); 
		query.append("       CGO_MT," ).append("\n"); 
		query.append("       RH_MVS," ).append("\n"); 
		query.append("       RH_RATIO," ).append("\n"); 
		query.append("       TOT_MVS," ).append("\n"); 
		query.append("       BERTH_PROD," ).append("\n"); 
		query.append("       WORK_GROSS," ).append("\n"); 
		query.append("       WORK_NET," ).append("\n"); 
		query.append("       GANG_GROSS," ).append("\n"); 
		query.append("       GANG_NET," ).append("\n"); 
		query.append("       WORK_PRD_GROSS," ).append("\n"); 
		query.append("       WORK_PRD_NET," ).append("\n"); 
		query.append("       GANG_PRD_GROSS," ).append("\n"); 
		query.append("       GANG_PRD_NET," ).append("\n"); 
		query.append("	   AVG_GANG," ).append("\n"); 
		query.append("       HATCH" ).append("\n"); 
		query.append("FROM ( SELECT RHQ," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'T','G.Sum',PORT) PORT," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'P','S.Sum',LANE) LANE," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'L','S.Sum',VVD)  VVD," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ETB,NULL) AS ETB," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ETD,NULL) AS ETD," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ATA,NULL) AS ATA," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ATB,NULL) AS ATB," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ATD,NULL) AS ATD," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ARR_DELAY,NULL) AS ARR_DELAY," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',ARR_WAIT ,NULL) AS ARR_WAIT ," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',PORT_DELAY,NULL) AS PORT_DELAY," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',PORT_WORK ,NULL) AS PORT_WORK," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'D',DEP_DELAY ,NULL) AS DEP_DELAY," ).append("\n"); 
		query.append("              TUG_IN," ).append("\n"); 
		query.append("              TUG_OUT," ).append("\n"); 
		query.append("              CGO_FL," ).append("\n"); 
		query.append("              CGO_MT," ).append("\n"); 
		query.append("              RH_MVS," ).append("\n"); 
		query.append("              RH_RATIO," ).append("\n"); 
		query.append("              TOT_MVS," ).append("\n"); 
		query.append("              BERTH_PROD," ).append("\n"); 
		query.append("              WORK_GROSS," ).append("\n"); 
		query.append("              WORK_NET," ).append("\n"); 
		query.append("              GANG_GROSS," ).append("\n"); 
		query.append("              GANG_NET," ).append("\n"); 
		query.append("              WORK_PRD_GROSS," ).append("\n"); 
		query.append("              WORK_PRD_NET," ).append("\n"); 
		query.append("              GANG_PRD_GROSS," ).append("\n"); 
		query.append("              GANG_PRD_NET," ).append("\n"); 
		query.append("		      AVG_GANG," ).append("\n"); 
		query.append("              HATCH" ).append("\n"); 
		query.append("       FROM ( SELECT C.RHQ," ).append("\n"); 
		query.append("                     C.PORT," ).append("\n"); 
		query.append("                     C.LANE," ).append("\n"); 
		query.append("                     C.VVD," ).append("\n"); 
		query.append("                     C.CAL," ).append("\n"); 
		query.append("                     MAX(R.PF_ETB_DT)                                              ETB," ).append("\n"); 
		query.append("                     MAX(R.PF_ETD_DT)                                              ETD," ).append("\n"); 
		query.append("                     MAX(C.ARR)                                                    ATA," ).append("\n"); 
		query.append("                     MAX(C.BRTH)                                                   ATB," ).append("\n"); 
		query.append("                     MAX(C.DEP)                                                    ATD," ).append("\n"); 
		query.append("                     CASE GROUPING(C.RHQ)||GROUPING(C.PORT)||GROUPING(C.LANE)||GROUPING(C.VVD)" ).append("\n"); 
		query.append("                          WHEN '0000' THEN 'D' -- DATA" ).append("\n"); 
		query.append("                          WHEN '0001' THEN 'L' -- LANE별 SUMMARY" ).append("\n"); 
		query.append("                          WHEN '0011' THEN 'P' -- PORT별 SUMMARY" ).append("\n"); 
		query.append("                          WHEN '1111' THEN 'T' -- GRAND TOTAL" ).append("\n"); 
		query.append("                     END  DATA_GUBUN," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.ARR - R.PF_ETB_DT + (@[manu_in_time]/24),0)) * 24, 1)                           ARR_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.BRTH - C.ARR - (@[manu_in_time]/24),0)) * 24, 1)                                ARR_WAIT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - C.BRTH) - (R.PF_ETD_DT - R.PF_ETB_DT),0)) * 24, 2)                       PORT_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - C.BRTH),0)) * 24, 2)                                                     PORT_WORK," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - R.PF_ETD_DT),0)) * 24, 1)                                                DEP_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.ATUG,0)),1)                                                                     TUG_IN," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.DTUG,0)),1)                                                                     TUG_OUT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.FL,0)),1)                                                                       CGO_FL," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.MT,0)),1)                                                                       CGO_MT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.MVS,0)),1)                                                                      RH_MVS," ).append("\n"); 
		query.append("                     ROUND(CASE WHEN NVL((SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.MVS,0))),0) = 0 " ).append("\n"); 
		query.append("                                THEN 0" ).append("\n"); 
		query.append("                                ELSE SUM(NVL(C.MVS,0)) / NVL((SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.MVS,0))),1)*100" ).append("\n"); 
		query.append("                           END,1) AS RH_RATIO," ).append("\n"); 
		query.append("--                     ROUND((SUM(NVL(C.MVS,0))/NVL((SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(CMVS,0))),1))*100,1)   RH_RATIO," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.MVS,0))+SUM(NVL(C.HATCH,0)),1)                 TOT_MVS," ).append("\n"); 
		query.append("                     ROUND(CASE WHEN  SUM(NVL((C.DEP - C.BRTH),0)) = 0 " ).append("\n"); 
		query.append("                                THEN  SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.HATCH,0))+SUM(NVL(C.MVS,0))" ).append("\n"); 
		query.append("                                ELSE (SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.HATCH,0))+SUM(NVL(C.MVS,0))) / ROUND((SUM(NVL((C.DEP - C.BRTH),0)) * 24),2)" ).append("\n"); 
		query.append("                           END, 2) AS BERTH_PROD," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)),2)         WORK_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)),2)         GANG_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.GROSS_TML,0)),2)                              WORK_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.NET_TML,0)),2)                                WORK_PRD_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.GROSS_GC,0)),2)                               GANG_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.NET_GC,0)),2)                                 GANG_PRD_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.AVG_GANG,0)),2)                               AVG_GANG," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.HATCH,0)),2)                                  HATCH" ).append("\n"); 
		query.append("              FROM   ( SELECT A.VVD," ).append("\n"); 
		query.append("                              A.CAL," ).append("\n"); 
		query.append("                              A.RHQ," ).append("\n"); 
		query.append("                              A.LANE," ).append("\n"); 
		query.append("                              A.PORT," ).append("\n"); 
		query.append("                              A.STS," ).append("\n"); 
		query.append("                              A.ARR," ).append("\n"); 
		query.append("                              A.BRTH," ).append("\n"); 
		query.append("                              A.DEP," ).append("\n"); 
		query.append("                              A.ATUG," ).append("\n"); 
		query.append("                              A.DTUG," ).append("\n"); 
		query.append("                              A.ETD," ).append("\n"); 
		query.append("                              A.ETB," ).append("\n"); 
		query.append("                              A.FL," ).append("\n"); 
		query.append("                              A.MT," ).append("\n"); 
		query.append("                              B.MVS," ).append("\n"); 
		query.append("							  A.AVG_GANG," ).append("\n"); 
		query.append("                              A.HATCH" ).append("\n"); 
		query.append("                       FROM   ( SELECT " ).append("\n"); 
		query.append("                                       V.RHQ                        RHQ ," ).append("\n"); 
		query.append("                                       S.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                --     SUM(DECODE(S.CNTR_TYPE,'E',0,QTY)) FL," ).append("\n"); 
		query.append("                                       SUM(  CASE WHEN H.UPDATE_SYS = 'I' OR H.UPDATE_SYS IS NULL THEN DECODE(S.CNTR_TYPE, 'E', 0, S.QTY)" ).append("\n"); 
		query.append("                                                  WHEN H.UPDATE_SYS = 'N' THEN DECODE(S.CNTR_TYPE, 'F', S.QTY, 0) ELSE 0" ).append("\n"); 
		query.append("                                             END ) FL,											" ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) MT," ).append("\n"); 
		query.append("									   MAX(H.AVG_GANG) AVG_GANG," ).append("\n"); 
		query.append("                                       MAX(H.HATCH) HATCH" ).append("\n"); 
		query.append("                                FROM   TDR_SUMMARY S, MVC M, TDR_HEADER H,                                " ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB," ).append("\n"); 
		query.append("                                                  CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                                                       ELSE" ).append("\n"); 
		query.append("                                                            (SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9) " ).append("\n"); 
		query.append("--                                                          CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')                 THEN 'HAMRU'" ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'KR'                 THEN 'SELIB'                 " ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'JP'                 THEN 'TYOIB'                 " ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD NOT IN ('KR','JP')     THEN 'SHARC'                 " ).append("\n"); 
		query.append("--                                                               WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("--															   WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                                                               ELSE ''" ).append("\n"); 
		query.append("--                                                          END" ).append("\n"); 
		query.append("                                                  END AS RHQ" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B, MDM_LOCATION ML" ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = ML.LOC_CD" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')             " ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V " ).append("\n"); 
		query.append("                                WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    S.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    H.VSL_CD   = S.VSL_CD" ).append("\n"); 
		query.append("                                AND    H.VOY_NO   = S.VOY_NO" ).append("\n"); 
		query.append("                                AND    H.DIR_CD   = S.DIR_CD" ).append("\n"); 
		query.append("                                AND    H.PORT_CD  = S.PORT_CD" ).append("\n"); 
		query.append("                                AND    H.CALL_IND = S.CALL_IND                                " ).append("\n"); 
		query.append("                                AND    S.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("                                AND    V.RHQ      = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'SML')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   = @[carr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <>'SML'     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    S.DIR_CD   LIKE  @[dir_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                GROUP BY V.RHQ, S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) A," ).append("\n"); 
		query.append("                              ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                      -- SUM(DECODE(C.SHIFT_TYPE,'B',1,0))+SUM(DECODE(C.SHIFT_TYPE,'Q',1,0)*2) MVS" ).append("\n"); 
		query.append("                                       SUM( CASE WHEN C.STATUS = 'ST' AND LENGTH(TRIM(C.PRECELL)) > 0 THEN DECODE(C.SHIFT_TYPE, 'Q', 2, 1) -- ST : Restow(Rehandling)" ).append("\n"); 
		query.append("                                                 WHEN C.STATUS = 'MI' AND C.MISHANDLE_CHK IN ('OD', 'OL', 'SD', 'SL') THEN DECODE(SUBSTR(C.MISHANDLE_CHK, 1, 1), 'O', 1, -1) -- Mis Handling" ).append("\n"); 
		query.append("                                                 ELSE 0 END ) MVS                                      " ).append("\n"); 
		query.append("                                FROM   TDR_CNTR_DETAIL C, MVC M," ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')               --:fm_dt" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V   --:to_dt" ).append("\n"); 
		query.append("                                WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                          --      AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                                AND    C.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'SML')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   =@[carr_cd]                                                                  --:carr_cd('SML')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <>'SML'                                                                      --:carr_cd('Other')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    C.DIR_CD   LIKE @[dir_cd]||'%'                                                          --:dir_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) B" ).append("\n"); 
		query.append("                       WHERE A.PORT     = B.PORT(+)" ).append("\n"); 
		query.append("                       AND   A.LANE     = B.LANE(+)" ).append("\n"); 
		query.append("                       AND   A.VVD      = B.VVD(+)" ).append("\n"); 
		query.append("                       AND   A.OPR      = B.OPR(+)" ).append("\n"); 
		query.append("                       AND   A.CAL      = B.CAL(+)" ).append("\n"); 
		query.append("                       AND   A.STS      = B.STS(+)" ).append("\n"); 
		query.append("                       AND   A.ARR      = B.ARR(+)" ).append("\n"); 
		query.append("                       AND   A.BRTH     = B.BRTH(+)" ).append("\n"); 
		query.append("                       AND   A.DEP      = B.DEP(+)" ).append("\n"); 
		query.append("                       AND   A.ATUG     = B.ATUG(+)" ).append("\n"); 
		query.append("                       AND   A.DTUG     = B.DTUG(+)" ).append("\n"); 
		query.append("                       AND   A.ETD      = B.ETD(+)" ).append("\n"); 
		query.append("                       AND   A.ETB      = B.ETB(+) ) C," ).append("\n"); 
		query.append("                     TDR_HEADER T, VSK_VSL_PORT_SKD R, VSK_VSL_SKD S" ).append("\n"); 
		query.append("              WHERE  SUBSTR(C.VVD,1,4) = T.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = T.VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = T.DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = T.PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = T.CALL_IND(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = R.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = R.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = R.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = S.VSL_CD" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = S.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = S.SKD_DIR_CD        " ).append("\n"); 
		query.append("			  GROUP BY GROUPING SETS((C.RHQ, C.PORT, C.LANE, C.VVD, C.CAL), (C.RHQ, C.PORT, C.LANE), (C.RHQ, C.PORT), ())  " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("/* AVERAGE */			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("              RHQ," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'T','G.Avg',PORT) PORT," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'P','S.Avg',LANE) LANE," ).append("\n"); 
		query.append("              DECODE(DATA_GUBUN,'L','S.Avg',VVD ) VVD," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE ETB" ).append("\n"); 
		query.append("              END  AS ETB," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE ETD" ).append("\n"); 
		query.append("              END  AS ETD," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE ATA" ).append("\n"); 
		query.append("              END  AS ATA," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE ATB" ).append("\n"); 
		query.append("              END  AS ATB," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE ATD" ).append("\n"); 
		query.append("              END ATD," ).append("\n"); 
		query.append("              ARR_DELAY," ).append("\n"); 
		query.append("              ARR_WAIT," ).append("\n"); 
		query.append("              PORT_DELAY," ).append("\n"); 
		query.append("              PORT_WORK," ).append("\n"); 
		query.append("              DEP_DELAY," ).append("\n"); 
		query.append("              TUG_IN," ).append("\n"); 
		query.append("              TUG_OUT," ).append("\n"); 
		query.append("              CGO_FL," ).append("\n"); 
		query.append("              CGO_MT," ).append("\n"); 
		query.append("              RH_MVS," ).append("\n"); 
		query.append("              CASE WHEN DATA_GUBUN IN ('T','P','L') THEN NULL " ).append("\n"); 
		query.append("                   ELSE RH_RATIO" ).append("\n"); 
		query.append("              END  AS RH_RATIO," ).append("\n"); 
		query.append("              TOT_MVS," ).append("\n"); 
		query.append("              BERTH_PROD," ).append("\n"); 
		query.append("              WORK_GROSS," ).append("\n"); 
		query.append("              WORK_NET," ).append("\n"); 
		query.append("              GANG_GROSS," ).append("\n"); 
		query.append("              GANG_NET," ).append("\n"); 
		query.append("              WORK_PRD_GROSS," ).append("\n"); 
		query.append("              WORK_PRD_NET," ).append("\n"); 
		query.append("              GANG_PRD_GROSS," ).append("\n"); 
		query.append("              GANG_PRD_NET," ).append("\n"); 
		query.append("			  AVG_GANG," ).append("\n"); 
		query.append("              HATCH" ).append("\n"); 
		query.append("       FROM ( SELECT C.RHQ," ).append("\n"); 
		query.append("                     C.PORT," ).append("\n"); 
		query.append("                     C.LANE," ).append("\n"); 
		query.append("                     C.VVD," ).append("\n"); 
		query.append("                     C.CAL," ).append("\n"); 
		query.append("                     MAX(R.PF_ETB_DT)                                              ETB," ).append("\n"); 
		query.append("                     MAX(R.PF_ETD_DT)                                              ETD," ).append("\n"); 
		query.append("                     MAX(C.ARR)                                                    ATA," ).append("\n"); 
		query.append("                     MAX(C.BRTH)                                                   ATB," ).append("\n"); 
		query.append("                     MAX(C.DEP)                                                    ATD," ).append("\n"); 
		query.append("                     CASE GROUPING(C.RHQ)||GROUPING(C.PORT)||GROUPING(C.LANE)||GROUPING(C.VVD)" ).append("\n"); 
		query.append("                          WHEN '0001' THEN 'L' -- LANE별 SUMMARY" ).append("\n"); 
		query.append("                          WHEN '0011' THEN 'P' -- PORT별 SUMMARY" ).append("\n"); 
		query.append("                          WHEN '1111' THEN 'T' -- GRAND TOTAL" ).append("\n"); 
		query.append("                     END  DATA_GUBUN," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL(C.ARR - R.PF_ETB_DT + (@[manu_in_time]/24),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),1)                                     ARR_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.BRTH - C.ARR - (@[manu_in_time]/24),0)) * 24, 1)             ARR_WAIT," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL((C.DEP - C.BRTH) - (R.PF_ETD_DT - R.PF_ETB_DT),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),2)                                     PORT_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL((C.DEP - C.BRTH),0)) * 24, 2)                                  PORT_WORK," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL((C.DEP - R.PF_ETD_DT),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),1)                                     DEP_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.ATUG,0)),1)                                                  TUG_IN," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.DTUG,0)),1)                                                  TUG_OUT," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.FL,0)),1)                                                    CGO_FL," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.MT,0)),1)                                                    CGO_MT," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.MVS,0)),1)                                                   RH_MVS," ).append("\n"); 
		query.append("                     ROUND(AVG(CASE WHEN NVL((NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1) = 0 " ).append("\n"); 
		query.append("                                    THEN 0" ).append("\n"); 
		query.append("                                    ELSE NVL(C.MVS/NVL((NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1),0)" ).append("\n"); 
		query.append("                               END) * 100, 1) AS RH_RATIO," ).append("\n"); 
		query.append("--                     ROUND(AVG(NVL(C.MVS/NVL((NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1),0))*100,1) RH_RATIO," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1)                           TOT_MVS," ).append("\n"); 
		query.append("                     ROUND(AVG(CASE WHEN NVL((C.DEP - C.BRTH),0) = 0 " ).append("\n"); 
		query.append("                                    THEN NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)" ).append("\n"); 
		query.append("                                    ELSE (NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0))/(NVL((C.DEP - C.BRTH),0) * 24)" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                              ),2) AS BERTH_PROD, " ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)),2)         WORK_NET," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)),2)         GANG_NET," ).append("\n"); 
		query.append("                     CASE WHEN SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)) = 0 THEN" ).append("\n"); 
		query.append("                               0" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                               ROUND(SUM(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)) / SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)) ,2 ) " ).append("\n"); 
		query.append("                          END WORK_PRD_GROSS," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     CASE WHEN SUM(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)) = 0 THEN" ).append("\n"); 
		query.append("                               0" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                              ROUND(SUM(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)) /SUM(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)),2)" ).append("\n"); 
		query.append("                          END WORK_PRD_NET," ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                     CASE WHEN SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)) = 0 THEN" ).append("\n"); 
		query.append("                               0" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                              ROUND(SUM(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)) /SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),2)  " ).append("\n"); 
		query.append("                          END GANG_PRD_GROSS," ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                     CASE WHEN SUM(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)) = 0 THEN" ).append("\n"); 
		query.append("                               0" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                             ROUND(SUM(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0))/SUM(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)),2) " ).append("\n"); 
		query.append("                          END GANG_PRD_NET," ).append("\n"); 
		query.append("		             ROUND(AVG(NVL(T.AVG_GANG,0)),2) 							   AVG_GANG," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.HATCH,0)),2)                                  HATCH" ).append("\n"); 
		query.append("              FROM   ( SELECT A.VVD," ).append("\n"); 
		query.append("                              A.CAL," ).append("\n"); 
		query.append("                              A.RHQ," ).append("\n"); 
		query.append("                              A.LANE," ).append("\n"); 
		query.append("                              A.PORT," ).append("\n"); 
		query.append("                              A.STS," ).append("\n"); 
		query.append("                              A.ARR," ).append("\n"); 
		query.append("                              A.BRTH," ).append("\n"); 
		query.append("                              A.DEP," ).append("\n"); 
		query.append("                              A.ATUG," ).append("\n"); 
		query.append("                              A.DTUG," ).append("\n"); 
		query.append("                              A.ETD," ).append("\n"); 
		query.append("                              A.ETB," ).append("\n"); 
		query.append("                              A.FL," ).append("\n"); 
		query.append("                              A.MT," ).append("\n"); 
		query.append("                              B.MVS," ).append("\n"); 
		query.append("							  A.AVG_GANG," ).append("\n"); 
		query.append("                              A.HATCH" ).append("\n"); 
		query.append("                       FROM   ( SELECT " ).append("\n"); 
		query.append("                                       V.RHQ                        RHQ," ).append("\n"); 
		query.append("                                       S.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                  	   SUM(CASE WHEN H.UPDATE_SYS = 'I' OR H.UPDATE_SYS IS NULL THEN DECODE(S.CNTR_TYPE, 'E', 0, S.QTY)" ).append("\n"); 
		query.append("                                                WHEN H.UPDATE_SYS = 'N' THEN DECODE(S.CNTR_TYPE, 'F', S.QTY, 0) ELSE 0" ).append("\n"); 
		query.append("                                           END ) FL,	" ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) MT," ).append("\n"); 
		query.append("									   MAX(H.AVG_GANG) AVG_GANG," ).append("\n"); 
		query.append("                                       MAX(H.HATCH) HATCH" ).append("\n"); 
		query.append("                                FROM   TDR_SUMMARY S, MVC M, TDR_HEADER H,                                " ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB," ).append("\n"); 
		query.append("                                                  CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                                                       ELSE " ).append("\n"); 
		query.append("															(SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9)" ).append("\n"); 
		query.append("--                                                          CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')         THEN 'HAMRU'" ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'KR'                 THEN 'SELIB'                 " ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'JP'                 THEN 'TYOIB'                 " ).append("\n"); 
		query.append("--                                                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD NOT IN ('KR','JP')     THEN 'SHARC'                 " ).append("\n"); 
		query.append("--                                                               WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("--															   WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                                                               ELSE ''" ).append("\n"); 
		query.append("--                                                          END" ).append("\n"); 
		query.append("                                                  END AS RHQ" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B, MDM_LOCATION ML" ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = ML.LOC_CD" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("#end                         " ).append("\n"); 
		query.append("#if (${loc_cd} != '')                " ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V" ).append("\n"); 
		query.append("                                WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    S.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    H.VSL_CD   = S.VSL_CD" ).append("\n"); 
		query.append("                                AND    H.VOY_NO   = S.VOY_NO" ).append("\n"); 
		query.append("                                AND    H.DIR_CD   = S.DIR_CD" ).append("\n"); 
		query.append("                                AND    H.PORT_CD  = S.PORT_CD" ).append("\n"); 
		query.append("                                AND    H.CALL_IND = S.CALL_IND " ).append("\n"); 
		query.append("                                AND    S.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("                                AND    V.RHQ      = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'SML')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   =@[carr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <>'SML'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    S.DIR_CD   LIKE @[dir_cd]||'%'" ).append("\n"); 
		query.append("#end                                " ).append("\n"); 
		query.append("                                GROUP BY V.RHQ, S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) A," ).append("\n"); 
		query.append("                              ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                    --   SUM(DECODE(C.SHIFT_TYPE,'B',1,0))+SUM(DECODE(C.SHIFT_TYPE,'Q',1,0)*2) MVS" ).append("\n"); 
		query.append("                                       SUM( CASE WHEN C.STATUS = 'ST' AND LENGTH(TRIM(C.PRECELL)) > 0 THEN DECODE(C.SHIFT_TYPE, 'Q', 2, 1) -- ST : Restow(Rehandling)" ).append("\n"); 
		query.append("                                                 WHEN C.STATUS = 'MI' AND C.MISHANDLE_CHK IN ('OD', 'OL', 'SD', 'SL') THEN DECODE(SUBSTR(C.MISHANDLE_CHK, 1, 1), 'O', 1, -1) -- Mis Handling" ).append("\n"); 
		query.append("                                                 ELSE 0 END ) MVS" ).append("\n"); 
		query.append("                                FROM   TDR_CNTR_DETAIL C, MVC M," ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("#end                                         " ).append("\n"); 
		query.append("#if (${loc_cd} != '')                " ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V " ).append("\n"); 
		query.append("                                WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                        --        AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                                AND    C.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'SML')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   =@[carr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <>'SML'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    C.DIR_CD   LIKE @[dir_cd]||'%'" ).append("\n"); 
		query.append("#end                                " ).append("\n"); 
		query.append("                                GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) B" ).append("\n"); 
		query.append("                       WHERE A.PORT     = B.PORT(+)" ).append("\n"); 
		query.append("                       AND   A.LANE     = B.LANE(+)" ).append("\n"); 
		query.append("                       AND   A.VVD      = B.VVD(+)" ).append("\n"); 
		query.append("                       AND   A.OPR      = B.OPR(+)" ).append("\n"); 
		query.append("                       AND   A.CAL      = B.CAL(+)" ).append("\n"); 
		query.append("                       AND   A.STS      = B.STS(+)" ).append("\n"); 
		query.append("                       AND   A.ARR      = B.ARR(+)" ).append("\n"); 
		query.append("                       AND   A.BRTH     = B.BRTH(+)" ).append("\n"); 
		query.append("                       AND   A.DEP      = B.DEP(+)" ).append("\n"); 
		query.append("                       AND   A.ATUG     = B.ATUG(+)" ).append("\n"); 
		query.append("                       AND   A.DTUG     = B.DTUG(+)" ).append("\n"); 
		query.append("                       AND   A.ETD      = B.ETD(+)" ).append("\n"); 
		query.append("                       AND   A.ETB      = B.ETB(+) ) C," ).append("\n"); 
		query.append("                     TDR_HEADER T, VSK_VSL_PORT_SKD R, VSK_VSL_SKD S" ).append("\n"); 
		query.append("              WHERE  SUBSTR(C.VVD,1,4) = T.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = T.VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = T.DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = T.PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = T.CALL_IND(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = R.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = R.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = R.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = S.VSL_CD" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = S.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = S.SKD_DIR_CD        " ).append("\n"); 
		query.append("			  GROUP BY GROUPING SETS((C.RHQ, C.PORT, C.LANE, C.VVD, C.CAL), (C.RHQ, C.PORT, C.LANE),(C.RHQ, C.PORT),())  " ).append("\n"); 
		query.append("              /*DATA는 필요없고 PORT별 SUB AVERAGE와 TOTAL AVERAGE만 필요함*/" ).append("\n"); 
		query.append("              HAVING NOT (GROUPING(C.RHQ) = 0 AND GROUPING(C.PORT) = 0 AND GROUPING(C.LANE) = 0 AND GROUPING(C.VVD) = 0)                         " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("ORDER BY DECODE(PORT,'G.Avg','ZZZZZ','G.Sum','ZZZZY',PORT), DECODE(LANE,'S.Avg','ZZZ','S.Sum','ZZY',LANE), DECODE(VVD,'S.Avg','ZZZZZZZZZ','S.Sum','ZZZZZZZZY',VVD), ETD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("WHERE RN >= (TO_NUMBER(@[page_no]) -1) * TO_NUMBER(@[pagerows]) + 1" ).append("\n"); 
		query.append("AND   RN <=  TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}