/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CodSimulateDBDAOSearchRepoPlanPreInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.29
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.08.29 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchRepoPlanPreInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CodSimulateDBDAOSearchRepoPlanPreInfoRSQL
	  * </pre>
	  */
	public CodSimulateDBDAOSearchRepoPlanPreInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchRepoPlanPreInfoRSQL").append("\n"); 
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
		query.append("     PLN_YRWK," ).append("\n"); 
		query.append("     PAST_REPO_PLN_FLG," ).append("\n"); 
		query.append("     LAND_CD," ).append("\n"); 
		query.append("     VVD," ).append("\n"); 
		query.append("     FM_ECC_CD_TMP," ).append("\n"); 
		query.append("     FM_ETD_DT," ).append("\n"); 
		query.append("     FM_YARD," ).append("\n"); 
		query.append("     TO_ECC_CD_TMP," ).append("\n"); 
		query.append("     TO_ETB_DT," ).append("\n"); 
		query.append("     TO_YARD," ).append("\n"); 
		query.append("     SUM(QTY) AS TOTAL," ).append("\n"); 
		query.append("#foreach (${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("     MAX(DECODE(TP, '$key', QTY, 0)) AS ${key}," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     @[repo_pln_id] AS REPO_PLN_ID," ).append("\n"); 
		query.append("     SUBSTR(VVD, 0, 4) AS VSL_CD," ).append("\n"); 
		query.append("     SUBSTR(VVD, 5, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("     SUBSTR(VVD, 9, 1) AS SKD_DIR_CD," ).append("\n"); 
		query.append("     FM_ECC_CD_TMP AS FM_ECC_CD," ).append("\n"); 
		query.append("     TO_ECC_CD_TMP AS TO_ECC_CD," ).append("\n"); 
		query.append("     FM_ECC_CD_TMP AS FM_ECC_CD_TMP1," ).append("\n"); 
		query.append("     FM_ETD_DT AS FM_ETD_DT1," ).append("\n"); 
		query.append("     TO_ECC_CD_TMP AS TO_ECC_CD_TMP1," ).append("\n"); 
		query.append("     TO_ETB_DT AS TO_ETB_DT1," ).append("\n"); 
		query.append("     'N' AS FM_ECC_CD_FLG," ).append("\n"); 
		query.append("     'N' AS TO_ECC_CD_FLG," ).append("\n"); 
		query.append("#foreach (${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("     DECODE(MAX(DECODE(TP, '$key', QTY, 0)), 0, 'N', 'Y') AS ${key}_FLAG," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach (${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("     LAND_CD||VVD||FM_ECC_CD_TMP||'$key'||DECODE(PAST_REPO_PLN_FLG , 'Y' , '1','0') AS SUM_CNTP_CODE${key}," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     '' AS PRE_PLN_TS_FLG," ).append("\n"); 
		query.append("     '0' AS PLN_SEQ," ).append("\n"); 
		query.append("     '0' AS PLN_SEQ1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT /*+ NO_QUERY_TRANSFORMATION */" ).append("\n"); 
		query.append("      (SELECT PLN_YR||PLN_WK" ).append("\n"); 
		query.append("         FROM EQR_WK_PRD" ).append("\n"); 
		query.append("        WHERE TO_CHAR(VL.ETB, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) AS PLN_YRWK," ).append("\n"); 
		query.append("      '1' PAST_REPO_PLN_FLG," ).append("\n"); 
		query.append("      VL.LANE AS LAND_CD," ).append("\n"); 
		query.append("      VL.VSL||VL.VOY||VL.DIR AS VVD," ).append("\n"); 
		query.append("      VL.FM_ECC_CD AS FM_ECC_CD_TMP ," ).append("\n"); 
		query.append("      VL.ETD AS FM_ETD_DT," ).append("\n"); 
		query.append("      VL.FM_YD_CD AS FM_YARD," ).append("\n"); 
		query.append("      VL.TPSZ AS TP," ).append("\n"); 
		query.append("      VL.TO_ECC_CD AS TO_ECC_CD_TMP," ).append("\n"); 
		query.append("      VL.ETB AS TO_ETB_DT," ).append("\n"); 
		query.append("      VL.TO_YD_CD AS TO_YARD," ).append("\n"); 
		query.append("      VL.QTY" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT AA.FM_ECC_CD FM_ECC_CD," ).append("\n"); 
		query.append("          AA.FM_YD_CD FM_YD_CD," ).append("\n"); 
		query.append("          AA.VSL_LANE_CD LANE," ).append("\n"); 
		query.append("          AA.VSL_CD VSL," ).append("\n"); 
		query.append("          AA.SKD_VOY_NO VOY," ).append("\n"); 
		query.append("          AA.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("          AA.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("          MAX(BB.VPS_ETD_DT) ETD," ).append("\n"); 
		query.append("          SUBSTR(AA.PLN_YRWK, 1, 6) PLN_YRWK," ).append("\n"); 
		query.append("          AA.TO_ECC_CD," ).append("\n"); 
		query.append("          AA.TO_YD_CD TO_YD_CD," ).append("\n"); 
		query.append("          MAX(DECODE(CC.VPS_ETB_DT, null, to_date(substr(AA.PLN_YRWK, 7, 8), 'yyyymmdd'), CC.VPS_ETB_DT)) ETB," ).append("\n"); 
		query.append("          TO_NUMBER(SUBSTR(AA.PLN_YRWK, 15)) QTY" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT FM_ECC_CD," ).append("\n"); 
		query.append("              FM_YD_CD," ).append("\n"); 
		query.append("              VSL_LANE_CD ," ).append("\n"); 
		query.append("              VSL_CD," ).append("\n"); 
		query.append("              SKD_VOY_NO," ).append("\n"); 
		query.append("              SKD_DIR_CD," ).append("\n"); 
		query.append("              CNTR_TPSZ_CD," ).append("\n"); 
		query.append("              TO_ECC_CD," ).append("\n"); 
		query.append("              TO_YD_CD," ).append("\n"); 
		query.append("              MAX(PLN_YRWK||to_char(VPS_ETB_DT, 'yyyymmdd')||TO_CHAR(CNTR_QTY)) PLN_YRWK" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT B.VPS_PORT_CD FM_ECC_CD," ).append("\n"); 
		query.append("                  A.FM_YD_CD," ).append("\n"); 
		query.append("                  A.VSL_LANE_CD ," ).append("\n"); 
		query.append("                  A.VSL_CD," ).append("\n"); 
		query.append("                  A.SKD_VOY_NO," ).append("\n"); 
		query.append("                  A.SKD_DIR_CD," ).append("\n"); 
		query.append("                  A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  B.VPS_ETD_DT," ).append("\n"); 
		query.append("                  A.PLN_YRWK," ).append("\n"); 
		query.append("                  A.TO_ECC_CD," ).append("\n"); 
		query.append("                  A.TO_YD_CD," ).append("\n"); 
		query.append("                  DECODE(C.VPS_ETB_DT, NULL , DECODE(C.VPS_ETA_DT, NULL, C.VPS_ETD_DT, C.VPS_ETA_DT), C.VPS_ETB_DT) VPS_ETB_DT ," ).append("\n"); 
		query.append("                  SUM(A.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT (" ).append("\n"); 
		query.append("                        SELECT ECC_CD" ).append("\n"); 
		query.append("                        FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                        WHERE SCC_CD = SUBSTR(A.FM_YD_CD, 1, 5)) FM_ECC_CD," ).append("\n"); 
		query.append("                      A.FM_YD_CD," ).append("\n"); 
		query.append("                      A.VSL_LANE_CD," ).append("\n"); 
		query.append("                      A.VSL_CD," ).append("\n"); 
		query.append("                      A.SKD_VOY_NO," ).append("\n"); 
		query.append("                      A.SKD_DIR_CD," ).append("\n"); 
		query.append("                      DECODE(B.CNTR_TPSZ_CD, 'A2', 'F2', 'A4', 'F4', 'S2', 'O2', 'S4', 'O4', 'F5', 'F4', B.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      A.FM_ETD_DT," ).append("\n"); 
		query.append("                      A.PLN_YRWK," ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        SELECT ECC_CD" ).append("\n"); 
		query.append("                        FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                        WHERE SCC_CD = SUBSTR(A.TO_YD_CD, 1, 5)) TO_ECC_CD," ).append("\n"); 
		query.append("                      A.TO_YD_CD," ).append("\n"); 
		query.append("                      B.CNTR_QTY" ).append("\n"); 
		query.append("                    FROM EQR_VSL_LODG_DCHG_EXE_PLN A," ).append("\n"); 
		query.append("                      EQR_VSL_EXE_PLN_QTY B" ).append("\n"); 
		query.append("                    WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("                      AND A.PLN_YRWK = B.PLN_YRWK" ).append("\n"); 
		query.append("                      AND A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("                      AND A.REF_ID = B.REF_ID" ).append("\n"); 
		query.append("                      AND A.REPO_PLN_ID IN (" ).append("\n"); 
		query.append("                        SELECT 'REPO' || aa || 'W001'" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT PLN_YR||PLN_WK aa" ).append("\n"); 
		query.append("                            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                            WHERE PLN_YR||PLN_WK <= SUBSTR(@[repo_pln_id], 5, 6)" ).append("\n"); 
		query.append("                            ORDER BY PLN_YR||PLN_WK DESC )" ).append("\n"); 
		query.append("                        WHERE ROWNUM < 8)" ).append("\n"); 
		query.append("                      AND A.REPO_MTY_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("                      AND A.SPLIT_REPO_PLN_FLG ='N'" ).append("\n"); 
		query.append("                      AND B.CNTR_QTY > 0" ).append("\n"); 
		query.append("                      AND TO_CHAR(A.FM_ETD_DT, 'YYYYMMDD') >= (" ).append("\n"); 
		query.append("                        SELECT WK_ST_DT" ).append("\n"); 
		query.append("                        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                        WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) ) ) A," ).append("\n"); 
		query.append("                  VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("                  VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("                WHERE A.FM_ECC_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND A.TO_ECC_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                GROUP BY B.VPS_PORT_CD, A.FM_YD_CD, A.VSL_LANE_CD , A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CNTR_TPSZ_CD, B.VPS_ETD_DT, A.PLN_YRWK, A.TO_ECC_CD, A.TO_YD_CD, C.VPS_ETA_DT , C.VPS_ETB_DT , C.VPS_ETD_DT" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT DISTINCT FM_ECC_CD," ).append("\n"); 
		query.append("                  FM_YD_CD," ).append("\n"); 
		query.append("                  VSL_LANE_CD," ).append("\n"); 
		query.append("                  VSL_CD," ).append("\n"); 
		query.append("                  SKD_VOY_NO," ).append("\n"); 
		query.append("                  SKD_DIR_CD," ).append("\n"); 
		query.append("                  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  FM_ETD_DT," ).append("\n"); 
		query.append("                  PLN_YRWK," ).append("\n"); 
		query.append("                  TO_ECC_CD," ).append("\n"); 
		query.append("                  TO_YD_CD," ).append("\n"); 
		query.append("                  MAX(VPS_ETB_DT) OVER(PARTITION BY FM_ECC_CD, VSL_LANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CNTR_TPSZ_CD, FM_ETD_DT, PLN_YRWK, TO_ECC_CD) ," ).append("\n"); 
		query.append("                  CNTR_QTY" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT A.FM_ECC_CD," ).append("\n"); 
		query.append("                      A.FM_YD_CD," ).append("\n"); 
		query.append("                      A.VSL_LANE_CD," ).append("\n"); 
		query.append("                      A.VSL_CD," ).append("\n"); 
		query.append("                      A.SKD_VOY_NO," ).append("\n"); 
		query.append("                      A.SKD_DIR_CD," ).append("\n"); 
		query.append("                      A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      A.FM_ETD_DT," ).append("\n"); 
		query.append("                      A.PLN_YRWK," ).append("\n"); 
		query.append("                      A.TO_ECC_CD," ).append("\n"); 
		query.append("                      A.TO_YD_CD," ).append("\n"); 
		query.append("                      DECODE(B.VPS_ETB_DT, NULL , DECODE(B.VPS_ETA_DT, NULL, B.VPS_ETD_DT, B.VPS_ETA_DT), B.VPS_ETB_DT) VPS_ETB_DT," ).append("\n"); 
		query.append("                      SUM(A.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT (" ).append("\n"); 
		query.append("                            SELECT ECC_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                            WHERE SCC_CD = SUBSTR(A.FM_YD_CD, 1, 5)) FM_ECC_CD," ).append("\n"); 
		query.append("                          A.FM_YD_CD," ).append("\n"); 
		query.append("                          A.VSL_LANE_CD," ).append("\n"); 
		query.append("                          A.VSL_CD," ).append("\n"); 
		query.append("                          A.SKD_VOY_NO," ).append("\n"); 
		query.append("                          A.SKD_DIR_CD," ).append("\n"); 
		query.append("                          DECODE(B.CNTR_TPSZ_CD, 'A2', 'F2', 'A4', 'F4', 'S2', 'O2', 'S4', 'O4', 'F5', 'F4', CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                          A.FM_ETD_DT," ).append("\n"); 
		query.append("                          A.PLN_YRWK," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT ECC_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                            WHERE SCC_CD = SUBSTR(A.TO_YD_CD, 1, 5)) TO_ECC_CD," ).append("\n"); 
		query.append("                          A.TO_YD_CD," ).append("\n"); 
		query.append("                          B.CNTR_QTY" ).append("\n"); 
		query.append("                        FROM EQR_VSL_LODG_DCHG_EXE_PLN A," ).append("\n"); 
		query.append("                          EQR_VSL_EXE_PLN_QTY B" ).append("\n"); 
		query.append("                        WHERE A.REPO_PLN_ID= B.REPO_PLN_ID" ).append("\n"); 
		query.append("                          AND A.PLN_YRWK = B.PLN_YRWK" ).append("\n"); 
		query.append("                          AND A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("                          AND A.REF_ID = B.REF_ID" ).append("\n"); 
		query.append("                          AND A.REPO_PLN_ID IN (" ).append("\n"); 
		query.append("                            SELECT 'REPO' || aa || 'W001'" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("                                SELECT PLN_YR||PLN_WK aa" ).append("\n"); 
		query.append("                                FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                                WHERE PLN_YR||PLN_WK <= SUBSTR(@[repo_pln_id], 5, 6)" ).append("\n"); 
		query.append("                                ORDER BY PLN_YR||PLN_WK DESC )" ).append("\n"); 
		query.append("                            WHERE ROWNUM < 8)" ).append("\n"); 
		query.append("                          AND A.REPO_MTY_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND A.SPLIT_REPO_PLN_FLG ='N'" ).append("\n"); 
		query.append("                          AND B.CNTR_QTY > 0" ).append("\n"); 
		query.append("                          AND TO_CHAR(A.FM_ETD_DT, 'YYYYMMDD') < (" ).append("\n"); 
		query.append("                            SELECT WK_ST_DT" ).append("\n"); 
		query.append("                            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                            WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) ) ) A," ).append("\n"); 
		query.append("                      VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                    WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                      AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND A.TO_ECC_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                      AND TO_CHAR(VPS_ETB_DT, 'YYYYMMDD') >= (" ).append("\n"); 
		query.append("                        SELECT WK_ST_DT" ).append("\n"); 
		query.append("                        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                        WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) )" ).append("\n"); 
		query.append("                    GROUP BY A.FM_ECC_CD, A.FM_YD_CD, A.VSL_LANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CNTR_TPSZ_CD, A.FM_ETD_DT, A.PLN_YRWK, A.TO_ECC_CD, A.TO_YD_CD, B.VPS_ETB_DT , B.VPS_ETA_DT , B.VPS_ETD_DT" ).append("\n"); 
		query.append("                    UNION" ).append("\n"); 
		query.append("                    SELECT FM_ECC_CD," ).append("\n"); 
		query.append("                      FM_YD_CD," ).append("\n"); 
		query.append("                      VSL_LANE_CD," ).append("\n"); 
		query.append("                      VSL_CD," ).append("\n"); 
		query.append("                      SKD_VOY_NO," ).append("\n"); 
		query.append("                      SKD_DIR_CD," ).append("\n"); 
		query.append("                      CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      FM_ETD_DT," ).append("\n"); 
		query.append("                      PLN_YRWK," ).append("\n"); 
		query.append("                      TO_ECC_CD," ).append("\n"); 
		query.append("                      TO_YD_CD," ).append("\n"); 
		query.append("                      TO_ETB_DT," ).append("\n"); 
		query.append("                      SUM(CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT (" ).append("\n"); 
		query.append("                            SELECT ECC_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                            WHERE SCC_CD = SUBSTR(A.FM_YD_CD, 1, 5)) FM_ECC_CD," ).append("\n"); 
		query.append("                          A.FM_YD_CD," ).append("\n"); 
		query.append("                          A.VSL_LANE_CD," ).append("\n"); 
		query.append("                          A.VSL_CD," ).append("\n"); 
		query.append("                          A.SKD_VOY_NO," ).append("\n"); 
		query.append("                          A.SKD_DIR_CD," ).append("\n"); 
		query.append("                          DECODE(B.CNTR_TPSZ_CD, 'A2', 'F2', 'A4', 'F4', 'S2', 'O2', 'S4', 'O4', 'F5', 'F4', CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                          A.FM_ETD_DT," ).append("\n"); 
		query.append("                          A.PLN_YRWK," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT ECC_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                            WHERE SCC_CD = SUBSTR(A.TO_YD_CD, 1, 5)) TO_ECC_CD," ).append("\n"); 
		query.append("                          A.TO_YD_CD," ).append("\n"); 
		query.append("                          A.TO_ETB_DT," ).append("\n"); 
		query.append("                          B.CNTR_QTY" ).append("\n"); 
		query.append("                        FROM EQR_VSL_LODG_DCHG_EXE_PLN A," ).append("\n"); 
		query.append("                          EQR_VSL_EXE_PLN_QTY B" ).append("\n"); 
		query.append("                        WHERE A.REPO_PLN_ID= B.REPO_PLN_ID" ).append("\n"); 
		query.append("                          AND A.PLN_YRWK = B.PLN_YRWK" ).append("\n"); 
		query.append("                          AND A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("                          AND A.REF_ID = B.REF_ID" ).append("\n"); 
		query.append("                          AND A.REPO_PLN_ID IN (" ).append("\n"); 
		query.append("                            SELECT 'REPO' || aa || 'W001'" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("                                SELECT PLN_YR||PLN_WK aa" ).append("\n"); 
		query.append("                                FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                                WHERE PLN_YR||PLN_WK <= SUBSTR(@[repo_pln_id], 5, 6)" ).append("\n"); 
		query.append("                                ORDER BY PLN_YR||PLN_WK DESC )" ).append("\n"); 
		query.append("                            WHERE ROWNUM < 8)" ).append("\n"); 
		query.append("                          AND A.REPO_MTY_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND A.SPLIT_REPO_PLN_FLG ='N'" ).append("\n"); 
		query.append("                          AND B.CNTR_QTY > 0" ).append("\n"); 
		query.append("                          AND TO_CHAR(A.TO_ETB_DT, 'YYYYMMDD') >= (" ).append("\n"); 
		query.append("                            SELECT WK_ST_DT" ).append("\n"); 
		query.append("                            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                            WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) )" ).append("\n"); 
		query.append("                          AND TO_CHAR(A.FM_ETD_DT, 'YYYYMMDD') < (" ).append("\n"); 
		query.append("                            SELECT WK_ST_DT" ).append("\n"); 
		query.append("                            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                            WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) ) )" ).append("\n"); 
		query.append("                    GROUP BY FM_ECC_CD, FM_YD_CD, VSL_LANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CNTR_TPSZ_CD, FM_ETD_DT, PLN_YRWK, TO_ECC_CD, TO_YD_CD, TO_ETB_DT )" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT FM_ECC_CD," ).append("\n"); 
		query.append("                  FM_YD_CD," ).append("\n"); 
		query.append("                  VSL_LANE_CD," ).append("\n"); 
		query.append("                  VSL_CD," ).append("\n"); 
		query.append("                  SKD_VOY_NO," ).append("\n"); 
		query.append("                  SKD_DIR_CD," ).append("\n"); 
		query.append("                  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  FM_ETD_DT," ).append("\n"); 
		query.append("                  PLN_YRWK," ).append("\n"); 
		query.append("                  TO_ECC_CD," ).append("\n"); 
		query.append("                  TO_YD_CD," ).append("\n"); 
		query.append("                  TO_ETB_DT," ).append("\n"); 
		query.append("                  SUM(CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT A.FM_ECC_CD," ).append("\n"); 
		query.append("                      A.FM_YD_CD," ).append("\n"); 
		query.append("                      A.VSL_LANE_CD," ).append("\n"); 
		query.append("                      A.VSL_CD," ).append("\n"); 
		query.append("                      A.SKD_VOY_NO," ).append("\n"); 
		query.append("                      A.SKD_DIR_CD," ).append("\n"); 
		query.append("                      DECODE(B.CNTR_TPSZ_CD, 'A2', 'F2', 'A4', 'F4', 'S2', 'O2', 'S4', 'O4', 'F5', 'F4', B.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      A.FM_ETD_DT," ).append("\n"); 
		query.append("                      A.PLN_YRWK," ).append("\n"); 
		query.append("                      A.TO_ECC_CD," ).append("\n"); 
		query.append("                      A.TO_YD_CD," ).append("\n"); 
		query.append("                      A.TO_ETB_DT," ).append("\n"); 
		query.append("                      B.CNTR_QTY" ).append("\n"); 
		query.append("                    FROM EQR_VSL_LODG_DCHG_PLN A," ).append("\n"); 
		query.append("                      EQR_VSL_LODG_DCHG_PLN_QTY B" ).append("\n"); 
		query.append("                    WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("                      AND A.PLN_YRWK = B.PLN_YRWK" ).append("\n"); 
		query.append("                      AND A.PLN_SEQ = B.PLN_SEQ" ).append("\n"); 
		query.append("                      AND A.REPO_PLN_ID IN (" ).append("\n"); 
		query.append("                        SELECT 'REPO' || aa || 'W001'" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT PLN_YR||PLN_WK aa" ).append("\n"); 
		query.append("                            FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                            WHERE PLN_YR||PLN_WK <= SUBSTR(@[repo_pln_id], 5, 6)" ).append("\n"); 
		query.append("                            ORDER BY PLN_YR||PLN_WK DESC )" ).append("\n"); 
		query.append("                        WHERE ROWNUM < 8)" ).append("\n"); 
		query.append("                      AND CNTR_QTY > 0" ).append("\n"); 
		query.append("                      AND B.COD_SIM_FLG ='Y'" ).append("\n"); 
		query.append("                      AND B.COD_DCHG_PLN_FLG ='Y'" ).append("\n"); 
		query.append("                      AND TO_CHAR(A.TO_ETB_DT, 'YYYYMMDD') >= (" ).append("\n"); 
		query.append("                        SELECT WK_ST_DT" ).append("\n"); 
		query.append("                        FROM EQR_WK_PRD" ).append("\n"); 
		query.append("                        WHERE PLN_YR||PLN_WK = SUBSTR(@[repo_pln_id], 5, 6) ) )" ).append("\n"); 
		query.append("                GROUP BY FM_ECC_CD, FM_YD_CD, VSL_LANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CNTR_TPSZ_CD, FM_ETD_DT, PLN_YRWK, TO_ECC_CD, TO_YD_CD, TO_ETB_DT )" ).append("\n"); 
		query.append("            GROUP BY FM_ECC_CD, FM_YD_CD, VSL_LANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CNTR_TPSZ_CD, TO_ECC_CD, TO_YD_CD ) AA," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD BB," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD CC" ).append("\n"); 
		query.append("        WHERE AA.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("          AND AA.VSL_CD = CC.VSL_CD(+)" ).append("\n"); 
		query.append("          AND AA.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND AA.SKD_VOY_NO = CC.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND AA.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND AA.SKD_DIR_CD = CC.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND AA.FM_ECC_CD = BB.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND AA.TO_ECC_CD = CC.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        GROUP BY AA.FM_ECC_CD, AA.FM_YD_CD, AA.VSL_LANE_CD , AA.VSL_CD, AA.SKD_VOY_NO, AA.SKD_DIR_CD, AA.CNTR_TPSZ_CD, SUBSTR(AA.PLN_YRWK, 1, 6), AA.TO_ECC_CD, AA.TO_YD_CD, TO_NUMBER(SUBSTR(AA.PLN_YRWK, 15)) ) VL," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT VSL_CD," ).append("\n"); 
		query.append("          SKD_VOY_NO," ).append("\n"); 
		query.append("          SKD_DIR_CD," ).append("\n"); 
		query.append("          VPS_PORT_CD," ).append("\n"); 
		query.append("          MAX(DECODE(VPS_ETB_DT, NULL , DECODE(VPS_ETA_DT , NULL, VPS_ETD_DT , VPS_ETA_DT) , VPS_ETB_DT)) VPS_ETB_DT" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD ) V" ).append("\n"); 
		query.append("    WHERE VL.VSL = V.VSL_CD" ).append("\n"); 
		query.append("      AND VL.VOY = V.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND VL.DIR = V.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND VL.FM_ECC_CD = V.VPS_PORT_CD )" ).append("\n"); 
		query.append("group by PLN_YRWK, PAST_REPO_PLN_FLG, LAND_CD, VVD, FM_ECC_CD_TMP, FM_ETD_DT, FM_YARD, TO_ECC_CD_TMP, TO_ETB_DT, TO_YARD" ).append("\n"); 
		query.append("ORDER BY 1, 3, 4" ).append("\n"); 

	}
}