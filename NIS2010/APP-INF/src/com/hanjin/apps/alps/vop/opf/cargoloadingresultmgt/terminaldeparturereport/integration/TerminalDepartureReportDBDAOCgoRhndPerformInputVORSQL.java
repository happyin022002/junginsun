/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL.java
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

public class TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL(){
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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(C3,1,'G.Total',DECODE(C5,1,'G.Total',PORT)) AS PORT," ).append("\n"); 
		query.append("       LANE                                               AS LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       DECODE(C1,1,'S.Total',DECODE(C3,1,'Total',OPR))    AS OPR," ).append("\n"); 
		query.append("       FL," ).append("\n"); 
		query.append("       MT," ).append("\n"); 
		query.append("       TL," ).append("\n"); 
		query.append("       HJS_RH_UNIT," ).append("\n"); 
		query.append("       OTH_RH_UNIT," ).append("\n"); 
		query.append("       HJS_RH_MOVE," ).append("\n"); 
		query.append("       OTH_RH_MOVE," ).append("\n"); 
		query.append("       CC_MOVE," ).append("\n"); 
		query.append("       CDC_MOVE," ).append("\n"); 
		query.append("       RH_UNIT_RATIO," ).append("\n"); 
		query.append("       RH_MOVE_RATIO," ).append("\n"); 
		query.append("       RSN_CC," ).append("\n"); 
		query.append("       RSN_CR," ).append("\n"); 
		query.append("       RSN_IC," ).append("\n"); 
		query.append("       RSN_ID," ).append("\n"); 
		query.append("       RSN_IF," ).append("\n"); 
		query.append("       RSN_IG," ).append("\n"); 
		query.append("       RSN_IH," ).append("\n"); 
		query.append("       RSN_IL," ).append("\n"); 
		query.append("       RSN_IO," ).append("\n"); 
		query.append("       RSN_IP," ).append("\n"); 
		query.append("       RSN_IR," ).append("\n"); 
		query.append("       RSN_IS," ).append("\n"); 
		query.append("       RSN_IT," ).append("\n"); 
		query.append("       RSN_IW," ).append("\n"); 
		query.append("       RSN_IX," ).append("\n"); 
		query.append("       RSN_XX" ).append("\n"); 
		query.append("FROM   ( SELECT B.PORT PORT," ).append("\n"); 
		query.append("                B.LANE LANE," ).append("\n"); 
		query.append("                B.VVD  VVD," ).append("\n"); 
		query.append("                B.OPR  OPR," ).append("\n"); 
		query.append("                GROUPING(B.PORT) P, GROUPING(B.LANE) L, GROUPING(B.VVD) V, GROUPING(B.OPR) O," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN GROUPING(B.PORT)=0 AND GROUPING(B.LANE)=0 AND GROUPING(B.VVD)=0 AND GROUPING(B.OPR)=1 THEN 1" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END C1," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN GROUPING(B.PORT)=1 AND GROUPING(B.LANE)=1 AND GROUPING(B.VVD)=1 AND GROUPING(B.OPR)=1 THEN 1" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END C3," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN GROUPING(B.PORT)=0 AND GROUPING(B.LANE)=0 AND GROUPING(B.VVD)=0 AND GROUPING(B.OPR)=0 THEN 1" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END C4," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN GROUPING(B.PORT)=1 AND GROUPING(B.LANE)=1 AND GROUPING(B.VVD)=1 AND GROUPING(B.OPR)=0 THEN 1" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("                END C5," ).append("\n"); 
		query.append("                SUM(NVL(A.FL,0))                FL," ).append("\n"); 
		query.append("                SUM(NVL(A.MT,0))                MT," ).append("\n"); 
		query.append("                SUM(NVL(A.TL,0))                TL," ).append("\n"); 
		query.append("                SUM(NVL(B.HBMVS+B.HQMVS,0))     HJS_RH_UNIT," ).append("\n"); 
		query.append("                SUM(NVL(B.OBMVS+B.OQMVS,0))     OTH_RH_UNIT," ).append("\n"); 
		query.append("                SUM(NVL(B.HBMVS+(B.HQMVS*2),0)) HJS_RH_MOVE," ).append("\n"); 
		query.append("                SUM(NVL(B.OBMVS+(B.OQMVS*2),0)) OTH_RH_MOVE," ).append("\n"); 
		query.append("                SUM(NVL(B.HBMVS+B.OBMVS,0))     CC_MOVE," ).append("\n"); 
		query.append("                SUM(NVL((B.HQMVS+B.OQMVS*2),0)) CDC_MOVE," ).append("\n"); 
		query.append("                SUM(NVL(ROUND((B.HBMVS+B.HQMVS+B.OBMVS+B.OQMVS)/A.TL,4),0)) * 100             RH_UNIT_RATIO," ).append("\n"); 
		query.append("                SUM(NVL(ROUND(((B.HBMVS+(B.HQMVS*2))+(B.OBMVS+(B.OQMVS*2)))/A.TL,4),0)) *100  RH_MOVE_RATIO," ).append("\n"); 
		query.append("                SUM(NVL(RSN_CC,0)) RSN_CC," ).append("\n"); 
		query.append("                SUM(NVL(RSN_CR,0)) RSN_CR," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IC,0)) RSN_IC," ).append("\n"); 
		query.append("                SUM(NVL(RSN_ID,0)) RSN_ID," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IF,0)) RSN_IF," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IG,0)) RSN_IG," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IH,0)) RSN_IH," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IL,0)) RSN_IL," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IO,0)) RSN_IO," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IP,0)) RSN_IP," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IR,0)) RSN_IR," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IS,0)) RSN_IS," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IT,0)) RSN_IT," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IW,0)) RSN_IW," ).append("\n"); 
		query.append("                SUM(NVL(RSN_IX,0)) RSN_IX," ).append("\n"); 
		query.append("                SUM(NVL(RSN_XX,0)) RSN_XX" ).append("\n"); 
		query.append("         FROM   ( SELECT S.PORT_CD                    PORT," ).append("\n"); 
		query.append("                         V.LANE                       LANE," ).append("\n"); 
		query.append("                         S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                         S.OPR_CD                     OPR," ).append("\n"); 
		query.append("                         SUM(DECODE(S.CNTR_TYPE,'E',0,QTY)) FL," ).append("\n"); 
		query.append("                         SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) MT," ).append("\n"); 
		query.append("                         SUM(DECODE(S.CNTR_TYPE,'E',0,QTY)) + SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) TL" ).append("\n"); 
		query.append("                  FROM   TDR_SUMMARY S," ).append("\n"); 
		query.append("                         ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                    A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                    A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                    A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                    A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                    A.SLAN_CD         LANE " ).append("\n"); 
		query.append("                           FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                           WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                           AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                           AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                           AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                           AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                           AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end                           " ).append("\n"); 
		query.append("                           AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                      AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999      --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          ) V" ).append("\n"); 
		query.append("                  WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                  AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                  AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                  AND    S.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                  AND    S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                  GROUP BY S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, S.OPR_CD ) A," ).append("\n"); 
		query.append("                ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                         V.LANE                       LANE," ).append("\n"); 
		query.append("                         C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                         C.OPR_CD                     OPR," ).append("\n"); 
		query.append("                         SUM(DECODE(C.ACCOUNT,'SML',DECODE(C.SHIFT_TYPE,'B',1,0),0)) HBMVS," ).append("\n"); 
		query.append("                         SUM(DECODE(C.ACCOUNT,'SML',0,DECODE(C.SHIFT_TYPE,'B',1,0))) OBMVS," ).append("\n"); 
		query.append("                         SUM(DECODE(C.ACCOUNT,'SML',DECODE(C.SHIFT_TYPE,'Q',1,0),0)) HQMVS," ).append("\n"); 
		query.append("                         SUM(DECODE(C.ACCOUNT,'SML',0,DECODE(C.SHIFT_TYPE,'Q',1,0))) OQMVS" ).append("\n"); 
		query.append("                  FROM   TDR_CNTR_DETAIL C," ).append("\n"); 
		query.append("                         ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                    A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                    A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                    A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                    A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                    A.SLAN_CD         LANE " ).append("\n"); 
		query.append("                           FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                           WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                           AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                           AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                           AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                           AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                           AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end                           " ).append("\n"); 
		query.append("                           AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                      AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999      --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         ) V  " ).append("\n"); 
		query.append("                  WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                  AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                  AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                  AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                  AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                  AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("				  AND    C.STATUS         = 'ST'" ).append("\n"); 
		query.append("                  GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, C.OPR_CD ) B," ).append("\n"); 
		query.append("                ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                         V.LANE                       LANE," ).append("\n"); 
		query.append("                         C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                         C.OPR_CD                     OPR," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'CC',1,0)) RSN_CC," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'CR',1,0)) RSN_CR," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IC',1,0)) RSN_IC," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'ID',1,0)) RSN_ID," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IF',1,0)) RSN_IF," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IG',1,0)) RSN_IG," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IH',1,0)) RSN_IH," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IL',1,0)) RSN_IL," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IO',1,0)) RSN_IO," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IP',1,0)) RSN_IP," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IR',1,0)) RSN_IR," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IS',1,0)) RSN_IS," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IT',1,0)) RSN_IT," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IW',1,0)) RSN_IW," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'IX',1,0)) RSN_IX," ).append("\n"); 
		query.append("                         SUM(DECODE(C.SHIFT_RSN,'XX',1,0)) RSN_XX" ).append("\n"); 
		query.append("                  FROM   TDR_CNTR_DETAIL C," ).append("\n"); 
		query.append("                         ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                    A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                    A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                    A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                    A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                    A.SLAN_CD         LANE " ).append("\n"); 
		query.append("                           FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                           WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                           AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                           AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                           AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                           AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                      AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999      --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         ) V" ).append("\n"); 
		query.append("                  WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                  AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                  AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                  AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                  AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                  AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("				  AND    C.STATUS         = 'ST'" ).append("\n"); 
		query.append("                  GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, C.OPR_CD ) C," ).append("\n"); 
		query.append("                ( SELECT  LOC_CD" ).append("\n"); 
		query.append("                  FROM      ( " ).append("\n"); 
		query.append("--                            SELECT LOC_CD, 'HAMRU' POR_RHQ" ).append("\n"); 
		query.append("--                            FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                            WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--                            AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                            AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                            AND    LOC_CD NOT IN ('EGAIS','ZADUR','RUVVO')" ).append("\n"); 
		query.append("--                            UNION ALL" ).append("\n"); 
		query.append("--                            SELECT LOC_CD, 'NYCRA' POR_RHQ" ).append("\n"); 
		query.append("--                            FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                            WHERE  CONTI_CD  = 'M'" ).append("\n"); 
		query.append("--                            AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                            AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                            UNION ALL" ).append("\n"); 
		query.append("--                            SELECT LOC_CD, DECODE(SCONTI_CD, 'AF', DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC'), 'SINRS') POR_RHQ" ).append("\n"); 
		query.append("--                            FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                            WHERE  (CONTI_CD  = 'A' OR LOC_CD = 'EGAIS' OR LOC_CD = 'ZADUR')" ).append("\n"); 
		query.append("--                            AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                            AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--							UNION ALL" ).append("\n"); 
		query.append("--							SELECT LOC_CD, 'VVOIA' POR_RHQ" ).append("\n"); 
		query.append("--                            FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                            WHERE  CONTI_CD = 'E'" ).append("\n"); 
		query.append("--                            AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                            AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                            AND    LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("                            SELECT L.LOC_CD, O.OFC_N3RD_LVL_CD POR_RHQ FROM MDM_LOCATION L, MAS_OFC_LVL O WHERE L.EQ_CTRL_OFC_CD = O.OFC_CD AND L.CALL_PORT_FLG = 'Y' AND L.DELT_FLG = 'N' AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9 " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                  WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq] ) ) R,             --:rhq_cd" ).append("\n"); 
		query.append("                MDM_VSL_SVC_LANE T" ).append("\n"); 
		query.append("         WHERE A.PORT(+)     = B.PORT" ).append("\n"); 
		query.append("         AND   A.LANE(+)     = B.LANE" ).append("\n"); 
		query.append("         AND   A.VVD(+)      = B.VVD" ).append("\n"); 
		query.append("         AND   A.OPR(+)      = B.OPR" ).append("\n"); 
		query.append("         AND   B.PORT     = C.PORT" ).append("\n"); 
		query.append("         AND   B.LANE     = C.LANE" ).append("\n"); 
		query.append("         AND   B.VVD      = C.VVD" ).append("\n"); 
		query.append("         AND   B.OPR      = C.OPR" ).append("\n"); 
		query.append("         AND   B.PORT     = R.LOC_CD" ).append("\n"); 
		query.append("         AND   B.LANE     = T.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("         AND   T.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         GROUP BY CUBE( B.PORT, B.LANE, B.VVD, B.OPR) )" ).append("\n"); 
		query.append("WHERE (C1 = 1 OR C3 = 1 OR C4 = 1 OR C5 = 1)" ).append("\n"); 
		query.append("ORDER BY DECODE(C3,1,'ZZZZZ',DECODE(C5,1,'YYYYY',PORT)), LANE, VVD, DECODE(C1,1,'ZZZZ',DECODE(C3,1,'YYYY',OPR))" ).append("\n"); 

	}
}