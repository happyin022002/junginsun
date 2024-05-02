/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOMissingTDRVORSQL.java
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

public class TerminalDepartureReportDBDAOMissingTDRVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.26 박희동 최초작성
	  * Missing TDR Inquiry 화면 조회 Query   
	  * 
	  * 2011.02.15 김기종 CHM-201108749 VSK_VSL_PORT_SKD.VPS_ETB_DT ==> VSK_ACT_PORT_SKD.ACT_DEP_DT 참조로 변경함
	  * 2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * 2016.05.17 Exclude from TPR 조건 변경
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOMissingTDRVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOMissingTDRVORSQL").append("\n"); 
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
		query.append("SELECT /*+ FIRST_ROWS */ T.RHQ_OFC_CD, T.CRR_CD, T.PORT_CD, T.YD_CD, T.YD_NM, T.SLAN_CD, T.SVC_TP_CD, T.VVD, T.AR_DT, T.DP_DT, " ).append("\n"); 
		query.append("             T.MV_CNT, T.BAY_PLN_FLG, T.TDR_FLG," ).append("\n"); 
		query.append("             NVL(T.HJS_MVS,0) AS HJS_MVS," ).append("\n"); 
		query.append("             NVL(T.OTH_MVS,0) AS OTH_MVS, " ).append("\n"); 
		query.append("             CASE WHEN NVL(T.HJS_MVS,0) > 0 THEN 'Y' ELSE 'N' END AS HJS_MVS_FLG," ).append("\n"); 
		query.append("             CASE WHEN NVL(T.OTH_MVS,0) > 0 THEN 'Y' ELSE 'N' END AS OTH_MVS_FLG " ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("           SELECT XX.RHQ_OFC_CD, XX.CRR_CD, XX.PORT_CD, XX.YD_CD, XX.YD_NM, XX.SLAN_CD, XX.SVC_TP_CD, XX.VVD, XX.AR_DT, XX.DP_DT, " ).append("\n"); 
		query.append("                        XX.MV_CNT, XX.BAY_PLN_FLG, XX.TDR_FLG,  " ).append("\n"); 
		query.append("                        SUM(MOVES) AS MVS," ).append("\n"); 
		query.append("                        SUM(DECODE(XX.OPR_CD, 'SML', DECODE(XX.FLG,'A',XX.MOVES,0),0)) AS HJS_MVS,  " ).append("\n"); 
		query.append("                        SUM(DECODE(XX.OPR_CD, 'OTH', DECODE(XX.FLG,'A',XX.MOVES,0),0)) AS OTH_MVS  " ).append("\n"); 
		query.append("            FROM   (" ).append("\n"); 
		query.append("                       SELECT X.RHQ_OFC_CD, X.CRR_CD, X.PORT_CD, X.YD_CD, X.YD_NM, X.SLAN_CD, X.SVC_TP_CD, X.VVD, X.AR_DT, X.DP_DT, " ).append("\n"); 
		query.append("                                   X.MV_CNT, X.BAY_PLN_FLG, X.TDR_FLG,  " ).append("\n"); 
		query.append("                                   X.OPR_CD, 'A' AS FLG, NVL(SUM (X.QTY), 0) AS MOVES" ).append("\n"); 
		query.append("                        FROM   (" ).append("\n"); 
		query.append("                                   SELECT" ).append("\n"); 
		query.append("                                          CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                                               ELSE (SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9)" ).append("\n"); 
		query.append("--                                                   CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')                 THEN 'HAMRU'" ).append("\n"); 
		query.append("--                                                        WHEN ML.CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                                                        WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'KR'                 THEN 'SELIB'                 " ).append("\n"); 
		query.append("--                                                        WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'JP'                 THEN 'TYOIB'                 " ).append("\n"); 
		query.append("--                                                        WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD NOT IN ('KR','JP')     THEN 'SHARC'                 " ).append("\n"); 
		query.append("--                                                        WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("--														WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                                                        ELSE ''" ).append("\n"); 
		query.append("--                                                   END" ).append("\n"); 
		query.append("                                          END AS RHQ_OFC_CD," ).append("\n"); 
		query.append("                                          VS.ACT_CRR_CD AS CRR_CD," ).append("\n"); 
		query.append("                                          PS.VPS_PORT_CD AS PORT_CD," ).append("\n"); 
		query.append("                                          PS.YD_CD," ).append("\n"); 
		query.append("                                          MY.YD_NM," ).append("\n"); 
		query.append("                                          PS.SLAN_CD," ).append("\n"); 
		query.append("                                          SL.VSL_SVC_TP_CD AS SVC_TP_CD," ).append("\n"); 
		query.append("                                          PS.VSL_CD||PS.SKD_VOY_NO||PS.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                                          TO_CHAR(AA.ACT_ARR_DT,'YYYYMMDDHH24MI') AS AR_DT," ).append("\n"); 
		query.append("                                          TO_CHAR(AA.ACT_DEP_DT,'YYYYMMDDHH24MI') AS DP_DT," ).append("\n"); 
		query.append("                                          NVL(TH.MVS,0) AS MV_CNT," ).append("\n"); 
		query.append("                                          DECODE(NVL((" ).append("\n"); 
		query.append("                                            SELECT 1" ).append("\n"); 
		query.append("                                            FROM   BAY_PLAN BP" ).append("\n"); 
		query.append("                                            WHERE  BP.VSL_CD    = PS.VSL_CD" ).append("\n"); 
		query.append("                                            AND    BP.VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND    BP.DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND    BP.PORT_CD   = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                            AND    BP.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                                            AND    ROWNUM       = 1" ).append("\n"); 
		query.append("                                            ),0),0,'N','Y')  AS BAY_PLN_FLG," ).append("\n"); 
		query.append("                                          NVL2(TH.VSL_CD, 'Y', 'N') AS TDR_FLG," ).append("\n"); 
		query.append("                                          DECODE(OP.OPR_CD,'SML','SML','OTH') OPR_CD," ).append("\n"); 
		query.append("                                          OP.QTY " ).append("\n"); 
		query.append("                                   FROM   TDR_HEADER       TH," ).append("\n"); 
		query.append("                                          VSK_VSL_PORT_SKD PS," ).append("\n"); 
		query.append("                                          VSK_VSL_SKD      VS," ).append("\n"); 
		query.append("                                          VSK_ACT_PORT_SKD AA," ).append("\n"); 
		query.append("                                          MDM_LOCATION     ML," ).append("\n"); 
		query.append("                                          MDM_YARD         MY," ).append("\n"); 
		query.append("                                          MDM_VSL_SVC_LANE SL," ).append("\n"); 
		query.append("                                          (" ).append("\n"); 
		query.append("                                            SELECT S.VSL_CD, S.VOY_NO, S.DIR_CD, S.PORT_CD, S.CALL_IND, S.OPR_CD, S.QTY" ).append("\n"); 
		query.append("                                              FROM" ).append("\n"); 
		query.append("                                                      (" ).append("\n"); 
		query.append("                                                        SELECT S.VSL_CD, S.VOY_NO, S.DIR_CD, S.PORT_CD, S.CALL_IND, S.OPR_CD, S.QTY" ).append("\n"); 
		query.append("                                                          FROM TDR_SUMMARY S" ).append("\n"); 
		query.append("                                                        WHERE STATUS IN  ('DS', 'DT', 'LM', 'LI', 'LT') " ).append("\n"); 
		query.append("                                     #if (${port_cd} != '')" ).append("\n"); 
		query.append("                                                            AND S.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("                                     #end                                                        " ).append("\n"); 
		query.append("                                                            AND EXISTS (" ).append("\n"); 
		query.append("                                                                                 SELECT 'X'" ).append("\n"); 
		query.append("                                                                                   FROM TDR_HEADER HD" ).append("\n"); 
		query.append("                                                                                 WHERE 1 = 1" ).append("\n"); 
		query.append("                                                                                      AND S.VSL_CD     = HD.VSL_CD" ).append("\n"); 
		query.append("                                                                                      AND S.VOY_NO    = HD.VOY_NO" ).append("\n"); 
		query.append("                                                                                      AND S.DIR_CD     = HD.DIR_CD" ).append("\n"); 
		query.append("                                                                                      AND S.PORT_CD  = HD.PORT_CD" ).append("\n"); 
		query.append("                                                                                      AND S.CALL_IND  = HD.CALL_IND" ).append("\n"); 
		query.append("                                                                                      AND ( HD.UPDATE_SYS = 'I' OR S.CNTR_TYPE NOT IN ('D', 'A', 'R') )" ).append("\n"); 
		query.append("                                                                               )" ).append("\n"); 
		query.append("                                           )S" ).append("\n"); 
		query.append("                                        )OP " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("                                   WHERE  PS.VSL_CD       = TH.VSL_CD   (+)" ).append("\n"); 
		query.append("                                   AND    PS.SKD_VOY_NO   = TH.VOY_NO   (+)" ).append("\n"); 
		query.append("                                   AND    PS.SKD_DIR_CD   = TH.DIR_CD   (+)" ).append("\n"); 
		query.append("                                   AND    PS.VPS_PORT_CD  = TH.PORT_CD  (+)" ).append("\n"); 
		query.append("                                   AND    PS.CLPT_IND_SEQ = TH.CALL_IND (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                   AND    PS.VSL_CD       = OP.VSL_CD   (+)" ).append("\n"); 
		query.append("                                   AND    PS.SKD_VOY_NO   = OP.VOY_NO   (+)" ).append("\n"); 
		query.append("                                   AND    PS.SKD_DIR_CD   = OP.DIR_CD   (+)" ).append("\n"); 
		query.append("                                   AND    PS.VPS_PORT_CD  = OP.PORT_CD  (+)" ).append("\n"); 
		query.append("                                   AND    PS.CLPT_IND_SEQ = OP.CALL_IND (+)" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                   AND    PS.VSL_CD       = VS.VSL_CD" ).append("\n"); 
		query.append("                                   AND    PS.SKD_VOY_NO   = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND    PS.SKD_DIR_CD   = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                   AND    PS.VSL_CD       = AA.VSL_CD" ).append("\n"); 
		query.append("                                   AND    PS.SKD_VOY_NO   = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND    PS.SKD_DIR_CD   = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND    PS.VPS_PORT_CD  = AA.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND    PS.CLPT_IND_SEQ = AA.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                   AND    PS.VPS_PORT_CD  = ML.LOC_CD" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                   AND    PS.YD_CD        = MY.YD_CD" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                   AND    PS.SLAN_CD      = SL.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                                   AND    PS.VPS_PORT_CD  NOT IN ('EGSUZ','PAPAC')" ).append("\n"); 
		query.append("                                   AND    PS.TURN_PORT_IND_CD IN ('Y','N')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ex_tpr_flg} == 'N')" ).append("\n"); 
		query.append("       AND  NOT  EXISTS (" ).append("\n"); 
		query.append("                SELECT 1" ).append("\n"); 
		query.append("                  FROM OPF_TML_DEP_RPT_DTL X" ).append("\n"); 
		query.append("                 WHERE X.VSL_CD       = PS.VSL_CD" ).append("\n"); 
		query.append("                   AND X.SKD_VOY_NO   = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND X.SKD_DIR_CD   = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND X.CLPT_CD      = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND X.CLPT_IND_SEQ = PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end           " ).append("\n"); 
		query.append("       /* cf. TURN_PORT_FLG" ).append("\n"); 
		query.append("       - D : Direction Change" ).append("\n"); 
		query.append("       - F : Final Port" ).append("\n"); 
		query.append("       - N : First Call/Normal Port" ).append("\n"); 
		query.append("       - V : Voyage Change" ).append("\n"); 
		query.append("       - Y : Turning Port" ).append("\n"); 
		query.append("       */                                         " ).append("\n"); 
		query.append("       AND    NVL(PS.SKD_CNG_STS_CD,'N') <> 'S' -- S:Skip,I:Phase-In,O:Phase-Out,A:Adding" ).append("\n"); 
		query.append("       ##AND    AA.ACT_DEP_DT  BETWEEN TO_DATE(@[fr_dt]) " ).append("\n"); 
		query.append("       ##                          AND TO_DATE(@[to_dt]) - 0.00001 " ).append("\n"); 
		query.append("       AND    AA.ACT_DEP_DT  BETWEEN TO_DATE(REPLACE(@[fr_dt],'-','')||'000000','YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("                                 AND TO_DATE(REPLACE(@[to_dt],'-','')||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND    CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                   ELSE (SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9)" ).append("\n"); 
		query.append("--                       CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')         THEN 'HAMRU'" ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'KR'                 THEN 'SELIB'                 " ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD = 'JP'                 THEN 'TYOIB'                 " ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' AND ML.CNT_CD NOT IN ('KR','JP')     THEN 'SHARC'                 " ).append("\n"); 
		query.append("--                            WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("--							WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                            ELSE ''" ).append("\n"); 
		query.append("--                       END" ).append("\n"); 
		query.append("              END = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("       AND    PS.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("       AND    PS.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("#if (${crr_cd} == 'SML')" ).append("\n"); 
		query.append("       AND    VS.ACT_CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND    VS.ACT_CRR_CD != 'SML'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_tp_cd} != 'All' && ${svc_tp_cd} != '')" ).append("\n"); 
		query.append("#if (${svc_tp_cd} == 'TRK')" ).append("\n"); 
		query.append("       AND    SL.VSL_SVC_TP_CD IN ('I', 'J', 'S') --TRUNK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND    NVL(SL.VSL_SVC_TP_CD,'*') NOT IN ('I', 'J', 'S')  -- FEEDER" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            )X" ).append("\n"); 
		query.append("                     GROUP BY X.RHQ_OFC_CD, X.CRR_CD, X.PORT_CD, X.YD_CD, X.YD_NM, X.SLAN_CD, X.SVC_TP_CD, X.VVD, X.AR_DT, X.DP_DT, " ).append("\n"); 
		query.append("                                    X.MV_CNT, X.BAY_PLN_FLG, X.TDR_FLG, X.OPR_CD" ).append("\n"); 
		query.append("                   ) XX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1 = 1 " ).append("\n"); 
		query.append("#if (${tdr_flg} != 'All' && ${tdr_flg} != '')" ).append("\n"); 
		query.append("#if (${tdr_flg} == 'MSS')" ).append("\n"); 
		query.append("AND  ( XX.SVC_TP_CD IN ('I', 'J', 'S')      " ).append("\n"); 
		query.append("AND    XX.MV_CNT  = 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NOT ( XX.SVC_TP_CD IN ('I', 'J', 'S')      " ).append("\n"); 
		query.append("AND      XX.MV_CNT  = 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bayplan} == 'N')" ).append("\n"); 
		query.append("AND ((XX.BAY_PLN_FLG = 'Y' AND XX.TDR_FLG= 'N') OR XX.BAY_PLN_FLG  = 'N')" ).append("\n"); 
		query.append("#elseif(${bayplan} == 'Y')" ).append("\n"); 
		query.append("AND NOT ((XX.BAY_PLN_FLG = 'Y' AND XX.TDR_FLG= 'N') OR XX.BAY_PLN_FLG  = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            GROUP BY XX.RHQ_OFC_CD, XX.CRR_CD, XX.PORT_CD, XX.YD_CD, XX.YD_NM, XX.SLAN_CD, XX.SVC_TP_CD, XX.VVD, XX.AR_DT, XX.DP_DT, " ).append("\n"); 
		query.append("                        XX.MV_CNT, XX.BAY_PLN_FLG, XX.TDR_FLG" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER  BY 1,2,3,4,6,7,8,9" ).append("\n"); 

	}
}