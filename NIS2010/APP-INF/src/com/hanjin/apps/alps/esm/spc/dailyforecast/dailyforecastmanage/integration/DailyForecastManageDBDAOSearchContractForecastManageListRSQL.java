/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchContractForecastManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2014.05.21 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author simonkim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchContractForecastManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contract Office에서 Forecast 입력 대상 조회
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [Trouble Shooting] VVD만으로 조회가능하도록 수정
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchContractForecastManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("salesrep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchContractForecastManageListRSQL").append("\n"); 
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
		query.append("WITH VVDS AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           DENSE_RANK() OVER (PARTITION BY M.TRD_CD ORDER BY M.RLANE_CD) AS LANE_NUM," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK                          AS COST_WK ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           DECODE(Q.DIR_CD, NULL, 'N', 'Y') AS HH_FLG," ).append("\n"); 
		query.append("           @[ioc]      AS IOC_TS_CD  ," ).append("\n"); 
		query.append("           @[salesrep] AS SREP_CD    ," ).append("\n"); 
		query.append("           @[ofc_cd]   AS CTRT_OFC_CD," ).append("\n"); 
		query.append("           @[acct_cd]  AS CUST_CD" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD    M," ).append("\n"); 
		query.append("           SPC_HD_HUL_MST Q" ).append("\n"); 
		query.append("     WHERE M.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("       AND M.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("       AND M.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("       AND M.DIR_CD     = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND M.TRD_CD     = @[trade]" ).append("\n"); 
		query.append(" #if (${subtrade} != '')" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${lane} != '')" ).append("\n"); 
		query.append("       AND M.RLANE_CD  IN ( ${lane} )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bound} != '')" ).append("\n"); 
		query.append("       AND M.DIR_CD     = @[bound]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("       AND SUBSTR(SLS_YRMON, 1, 4)||COST_WK IN (SELECT /*+INDEX(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                                                       COST_YR||COST_WK" ).append("\n"); 
		query.append("                                                  FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                 WHERE COST_YR  = @[year]" ).append("\n"); 
		query.append("                                                   AND COST_WK >= @[week]" ).append("\n"); 
		query.append("                                                   AND ROWNUM  <= @[duration])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND Q.TRD_CD   (+) = M.TRD_CD" ).append("\n"); 
		query.append("       AND Q.RLANE_CD (+) = M.RLANE_CD" ).append("\n"); 
		query.append("       AND Q.DIR_CD   (+) = M.DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", SLS_REP AS (" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         R.SREP_CD," ).append("\n"); 
		query.append("         S.SREP_NM," ).append("\n"); 
		query.append("         S.OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CUST_SLS_REP R," ).append("\n"); 
		query.append("         MDM_SLS_REP      S" ).append("\n"); 
		query.append("   WHERE R.SREP_CD               = S.SREP_CD" ).append("\n"); 
		query.append("     AND NVL(SREP_STS_CD, 'N')   = 'N'" ).append("\n"); 
		query.append("     AND S.OFC_CD                = @[ofc_cd]" ).append("\n"); 
		query.append("     AND (CUST_CNT_CD, CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("                                       FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("                                      WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                        AND (C.TRD_CD, C.COST_YRWK, C.VER_SEQ) IN  (SELECT /*+ INDEX_DESC (V XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                                           M.TRD_CD, V.COST_YRWK, V.VER_SEQ" ).append("\n"); 
		query.append("                                                                                      FROM SPC_MDL_VER_MST V," ).append("\n"); 
		query.append("                                                                                           VVDS            M" ).append("\n"); 
		query.append("                                                                                     WHERE M.COST_WK BETWEEN V.VER_ST_YRWK AND V.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                                       AND M.TRD_CD  = V.TRD_CD" ).append("\n"); 
		query.append("                                                                                       AND V.CFM_FLG = 'Y' )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         R.SREP_CD," ).append("\n"); 
		query.append("         S.SREP_NM," ).append("\n"); 
		query.append("         @[ofc_cd] AS OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CUST_SLS_REP R," ).append("\n"); 
		query.append("         MDM_SLS_REP      S" ).append("\n"); 
		query.append("   WHERE R.SREP_CD               = S.SREP_CD" ).append("\n"); 
		query.append("     AND NVL(SREP_STS_CD, 'N')   = 'N'" ).append("\n"); 
		query.append("     AND S.OFC_CD                IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                       FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                      WHERE TO_CHAR(SYSDATE, 'YYYYWW') BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                        AND OFC_LVL < 4" ).append("\n"); 
		query.append("                                        AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("     AND (CUST_CNT_CD, CUST_SEQ) IN (SELECT C.CUST_CNT_CD, C.CUST_SEQ" ).append("\n"); 
		query.append("                                       FROM SPC_MDL_CUST_CTRL C," ).append("\n"); 
		query.append("                                            MDM_CUSTOMER      MC" ).append("\n"); 
		query.append("                                      WHERE C.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                        AND C.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                        AND C.CUST_SEQ    = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                        AND MC.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                        AND MC.OFC_CD     = @[ofc_cd]" ).append("\n"); 
		query.append("                                        AND (C.TRD_CD, C.COST_YRWK, C.VER_SEQ) IN  (SELECT /*+ INDEX_DESC (V XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                                           M.TRD_CD, V.COST_YRWK, V.VER_SEQ" ).append("\n"); 
		query.append("                                                                                      FROM SPC_MDL_VER_MST V," ).append("\n"); 
		query.append("                                                                                           VVDS            M" ).append("\n"); 
		query.append("                                                                                     WHERE M.COST_WK BETWEEN V.VER_ST_YRWK AND V.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                                       AND M.TRD_CD  = V.TRD_CD" ).append("\n"); 
		query.append("                                                                                       AND V.CFM_FLG = 'Y' )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PARAMS AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           M.TRD_CD        ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           M.RLANE_CD      ," ).append("\n"); 
		query.append("           ( SELECT N2ND_PRNT_OFC_CD " ).append("\n"); 
		query.append("               FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("              WHERE M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                AND OFC_CD   = O.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           ) AS RHQ_CD," ).append("\n"); 
		query.append("           M.LANE_NUM      ," ).append("\n"); 
		query.append("           DENSE_RANK() OVER (PARTITION BY M.TRD_CD, M.RLANE_CD, M.COST_WK, M.IOC_TS_CD, SR.SREP_CD, M.CTRT_OFC_CD, C.CUST_CNT_CD, C.CUST_SEQ, C.CUST_CTRL_CD, NVL(C.SC_NO,C.RFA_NO), O.SLS_RGN_OFC_CD ORDER BY M.VSL_CD, M.SKD_VOY_NO, M.DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("           --DENSE_RANK() OVER (PARTITION BY M.TRD_CD, M.RLANE_CD, M.COST_WK, M.IOC_TS_CD, SR.SREP_CD, M.CTRT_OFC_CD, C.CUST_CNT_CD, C.CUST_SEQ, C.CUST_CTRL_CD, DECODE(M.TRD_CD, 'AES', C.RFA_NO, C.SC_NO), O.SLS_RGN_OFC_CD ORDER BY M.VSL_CD, M.SKD_VOY_NO, M.DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("           M.COST_WK       ," ).append("\n"); 
		query.append("           M.VSL_CD        ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           M.DIR_CD        ," ).append("\n"); 
		query.append("           M.IOC_TS_CD     ," ).append("\n"); 
		query.append("           SR.SREP_CD      ," ).append("\n"); 
		query.append("           SR.SREP_NM      ," ).append("\n"); 
		query.append("           M.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("           MC.RVIS_CNTR_CUST_TP_CD AS CUST_TP," ).append("\n"); 
		query.append("           C.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           C.CUST_SEQ      ," ).append("\n"); 
		query.append("           C.CUST_CTRL_CD  , " ).append("\n"); 
		query.append("           MC.CUST_LGL_ENG_NM      AS CUST_NM," ).append("\n"); 
		query.append("--           C.DTL_SEQ               AS FCAST_SEQ," ).append("\n"); 
		query.append("           O.FCAST_SEQ     ," ).append("\n"); 
		query.append("           C.SC_NO         ," ).append("\n"); 
		query.append("           O.RFA_NO        ," ).append("\n"); 
		query.append("           O.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           C.COST_YRWK     ," ).append("\n"); 
		query.append("           C.VER_SEQ       ," ).append("\n"); 
		query.append("           M.HH_FLG        ," ).append("\n"); 
		query.append("           DECODE(O.TRD_CD, NULL, 'N', 'Y') AS EXIST_FLG" ).append("\n"); 
		query.append("      FROM VVDS                    M ," ).append("\n"); 
		query.append("           SPC_CTRT_FCAST_OFC_MAPG O ," ).append("\n"); 
		query.append("           SPC_MDL_CUST_CTRL       C ," ).append("\n"); 
		query.append("           BKG_CUST_SLS_REP        B ," ).append("\n"); 
		query.append("           MDM_CUSTOMER            MC," ).append("\n"); 
		query.append("           SLS_REP                 SR" ).append("\n"); 
		query.append("     WHERE M.TRD_CD          = O.TRD_CD  (+)" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD      = O.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("       AND M.RLANE_CD        = O.RLANE_CD(+)" ).append("\n"); 
		query.append("       AND M.DIR_CD          = O.DIR_CD(+)" ).append("\n"); 
		query.append("       AND M.IOC_TS_CD       = O.IOC_TS_CD (+)" ).append("\n"); 
		query.append("       AND M.CTRT_OFC_CD     = O.CTRT_OFC_CD(+)" ).append("\n"); 
		query.append("#if (${salesrep} != '') " ).append("\n"); 
		query.append("       AND SR.SREP_CD = M.SREP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_cd} != '') " ).append("\n"); 
		query.append("       AND C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ, 'FM000000') = M.CUST_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND SR.OFC_CD         = NVL(O.CTRT_OFC_CD, SR.OFC_CD)" ).append("\n"); 
		query.append("       AND B.CUST_CNT_CD     = NVL(O.CUST_CNT_CD, B.CUST_CNT_CD)" ).append("\n"); 
		query.append("       AND B.CUST_SEQ        = NVL(O.CUST_SEQ, B.CUST_SEQ)" ).append("\n"); 
		query.append("       AND C.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("       AND M.TRD_CD          = C.TRD_CD" ).append("\n"); 
		query.append("       AND MC.CUST_CNT_CD    = C.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND MC.CUST_SEQ       = C.CUST_SEQ" ).append("\n"); 
		query.append("       AND NVL(C.SC_NO,NVL(C.RFA_NO, 'X')) = NVL(O.SC_NO,NVL(O.RFA_NO, 'X'))" ).append("\n"); 
		query.append("       --AND DECODE(C.TRD_CD, 'AES', NVL(C.RFA_NO, 'X'), NVL(C.SC_NO, 'X')) = DECODE(C.TRD_CD, 'AES', NVL(O.RFA_NO, 'X'), COALESCE(O.SC_NO, C.SC_NO, 'X'))" ).append("\n"); 
		query.append("       AND B.SREP_CD         = SR.SREP_CD" ).append("\n"); 
		query.append("       AND B.CUST_CNT_CD     = C.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND B.CUST_SEQ        = C.CUST_SEQ" ).append("\n"); 
		query.append("       AND B.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("       AND M.HH_FLG          = 'Y'" ).append("\n"); 
		query.append("       AND (C.COST_YRWK, C.VER_SEQ) IN (SELECT /*+ INDEX_DESC (V XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                               V.COST_YRWK, V.VER_SEQ" ).append("\n"); 
		query.append("                                          FROM SPC_MDL_VER_MST V" ).append("\n"); 
		query.append("                                         WHERE M.COST_WK BETWEEN V.VER_ST_YRWK AND V.VER_END_YRWK" ).append("\n"); 
		query.append("                                           AND V.TRD_CD  = M.TRD_CD" ).append("\n"); 
		query.append("                                           AND V.CFM_FLG = 'Y' " ).append("\n"); 
		query.append("                                           AND ROWNUM    = 1 )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MDL_CUST_REV AS (" ).append("\n"); 
		query.append("    SELECT P.TRD_CD        ," ).append("\n"); 
		query.append("           P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           P.RLANE_CD      ," ).append("\n"); 
		query.append("           P.LANE_NUM      ," ).append("\n"); 
		query.append("           P.VVD_CNT       ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           P.VSL_CD        ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           P.DIR_CD        ," ).append("\n"); 
		query.append("           P.IOC_TS_CD     ," ).append("\n"); 
		query.append("           P.SREP_CD       ," ).append("\n"); 
		query.append("           P.SREP_NM       ," ).append("\n"); 
		query.append("           P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("           P.CUST_TP       ," ).append("\n"); 
		query.append("           P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           P.CUST_SEQ      ," ).append("\n"); 
		query.append("           P.CUST_NM       ," ).append("\n"); 
		query.append("           P.FCAST_SEQ     ," ).append("\n"); 
		query.append("           P.SC_NO         ," ).append("\n"); 
		query.append("           P.RFA_NO        ," ).append("\n"); 
		query.append("           NVL(ML.SLS_RHQ_CD, P.RHQ_CD) SLS_RHQ_CD," ).append("\n"); 
		query.append("           P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           P.COST_YRWK     ," ).append("\n"); 
		query.append("           P.VER_SEQ       ," ).append("\n"); 
		query.append("           P.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("           ML.RLANE_ADJ_QTY AS GUIDE_QTY, " ).append("\n"); 
		query.append("           EXIST_FLG" ).append("\n"); 
		query.append("      FROM PARAMS                P ," ).append("\n"); 
		query.append("           SPC_MDL_CUST_REV_LANE ML" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND P.COST_YRWK       = ML.COST_YRWK      (+)" ).append("\n"); 
		query.append("       AND P.VER_SEQ         = ML.VER_SEQ        (+)" ).append("\n"); 
		query.append("       AND P.TRD_CD          = ML.TRD_CD         (+)" ).append("\n"); 
		query.append("       AND P.SUB_TRD_CD      = ML.SUB_TRD_CD     (+)" ).append("\n"); 
		query.append("       AND P.RLANE_CD        = ML.RLANE_CD       (+)" ).append("\n"); 
		query.append("       AND P.SLS_RGN_OFC_CD  = ML.SLS_RGN_OFC_CD (+)" ).append("\n"); 
		query.append("       AND P.CUST_CNT_CD     = ML.CUST_CNT_CD    (+)" ).append("\n"); 
		query.append("       AND P.CUST_SEQ        = ML.CUST_SEQ       (+)" ).append("\n"); 
		query.append("       AND P.CTRT_OFC_CD     = ML.CTRT_OFC_CD    (+)" ).append("\n"); 
		query.append("       AND NVL(P.SC_NO,NVL(P.RFA_NO, 'X')) = NVL(ML.SC_NO (+),NVL(ML.RFA_NO (+), 'X'))" ).append("\n"); 
		query.append("       --AND DECODE(P.TRD_CD, 'AES', NVL(P.RFA_NO, 'X'), NVL(P.SC_NO, 'X')) = DECODE(P.TRD_CD, 'AES', NVL(ML.RFA_NO (+), 'X'), COALESCE(ML.SC_NO (+), P.SC_NO, 'X'))" ).append("\n"); 
		query.append("       AND NVL(ML.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("       AND P.HH_FLG              = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCAST_DATA AS (" ).append("\n"); 
		query.append("    SELECT P.FLG           ," ).append("\n"); 
		query.append("           P.LANE_NUM      ," ).append("\n"); 
		query.append("           P.TRD_CD        ," ).append("\n"); 
		query.append("           P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           P.RLANE_CD      ," ).append("\n"); 
		query.append("           P.IOC_TS_CD     ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           P.VSL_CD        ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           P.DIR_CD        ," ).append("\n"); 
		query.append("           P.SREP_CD       ," ).append("\n"); 
		query.append("           P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("           P.CUST_TP       ," ).append("\n"); 
		query.append("           P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           P.CUST_SEQ      ," ).append("\n"); 
		query.append("           P.CUST_NM       ," ).append("\n"); 
		query.append("           P.FCAST_SEQ     ," ).append("\n"); 
		query.append("           P.SC_NO         ," ).append("\n"); 
		query.append("           P.RFA_NO        ," ).append("\n"); 
		query.append("           P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("           P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           SUM(FCAST_TTL_QTY)      AS FCAST_TTL_QTY     ," ).append("\n"); 
		query.append("           SUM(FCAST_TTL_TEU)      AS FCAST_TTL_TEU     ," ).append("\n"); 
		query.append("           SUM(FCAST_20FT_QTY)     AS FCAST_20FT_QTY    ," ).append("\n"); 
		query.append("           SUM(FCAST_40FT_QTY)     AS FCAST_40FT_QTY    ," ).append("\n"); 
		query.append("           SUM(FCAST_40FT_HC_QTY)  AS FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("           SUM(FCAST_45FT_HC_QTY)  AS FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("           SUM(FCAST_53FT_QTY)     AS FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("           SUM(FCAST_RF_QTY)       AS FCAST_RF_QTY      ," ).append("\n"); 
		query.append("           SUM(FCAST_TTL_WGT)      AS FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("           SUM(LFCAST_TTL_QTY)     AS LFCAST_TTL_QTY    ," ).append("\n"); 
		query.append("           SUM(LFCAST_TTL_TEU)     AS LFCAST_TTL_TEU    ," ).append("\n"); 
		query.append("           SUM(LFCAST_20FT_QTY)    AS LFCAST_20FT_QTY   ," ).append("\n"); 
		query.append("           SUM(LFCAST_40FT_QTY)    AS LFCAST_40FT_QTY   ," ).append("\n"); 
		query.append("           SUM(LFCAST_40FT_HC_QTY) AS LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           SUM(LFCAST_45FT_HC_QTY) AS LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           SUM(LFCAST_53FT_QTY)    AS LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("           SUM(LFCAST_RF_QTY)      AS LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("           SUM(LFCAST_TTL_WGT)     AS LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("           MAX(FCAST_RMK)          AS FCAST_RMK         ," ).append("\n"); 
		query.append("           MAX(EXIST_FLG)          AS EXIST_FLG" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT 'CF' AS FLG     ," ).append("\n"); 
		query.append("                     P.LANE_NUM      ," ).append("\n"); 
		query.append("                     P.TRD_CD        ," ).append("\n"); 
		query.append("                     P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                     P.RLANE_CD      ," ).append("\n"); 
		query.append("                     P.IOC_TS_CD     ," ).append("\n"); 
		query.append("                     P.COST_WK       ," ).append("\n"); 
		query.append("                     P.VSL_CD        ," ).append("\n"); 
		query.append("                     P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                     P.DIR_CD        ," ).append("\n"); 
		query.append("                     P.SREP_CD       ," ).append("\n"); 
		query.append("                     P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("                     P.CUST_TP       ," ).append("\n"); 
		query.append("                     P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("                     P.CUST_SEQ      ," ).append("\n"); 
		query.append("                     P.CUST_NM       ," ).append("\n"); 
		query.append("                     P.FCAST_SEQ     ," ).append("\n"); 
		query.append("                     F.SC_NO         ," ).append("\n"); 
		query.append("                     F.RFA_NO        ," ).append("\n"); 
		query.append("                     (SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                        FROM SPC_OFC_LVL " ).append("\n"); 
		query.append("                       WHERE OFC_CD = F.SLS_RGN_OFC_cD" ).append("\n"); 
		query.append("                         AND P.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                         AND DELT_FLG = 'N') AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                     F.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                     (NVL(F.FCAST_TTL_QTY   , 0) + (NVL(FCAST_40FT_HC_QTY, 0) + NVL(FCAST_45FT_HC_QTY, 0) + NVL(FCAST_53FT_QTY, 0)) * 2) AS FCAST_TTL_QTY," ).append("\n"); 
		query.append("                     NVL(F.FCAST_TTL_QTY    , 0) AS FCAST_TTL_TEU    ," ).append("\n"); 
		query.append("                     NVL(F.FCAST_20FT_QTY   , 0) AS FCAST_20FT_QTY   ," ).append("\n"); 
		query.append("                     NVL(F.FCAST_40FT_QTY   , 0) AS FCAST_40FT_QTY   ," ).append("\n"); 
		query.append("                     NVL(F.FCAST_40FT_HC_QTY, 0) AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                     NVL(F.FCAST_45FT_HC_QTY, 0) AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                     NVL(F.FCAST_53FT_QTY   , 0) AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                     NVL(F.FCAST_RF_QTY     , 0) AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("                     NVL(F.FCAST_TTL_WGT    , 0) AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("                     0 AS LFCAST_TTL_QTY    ," ).append("\n"); 
		query.append("                     0 AS LFCAST_TTL_TEU    ," ).append("\n"); 
		query.append("                     0 AS LFCAST_20FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS LFCAST_40FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                     0 AS LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                     0 AS LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("                     0 AS LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("                     FCAST_RMK              ," ).append("\n"); 
		query.append("                     EXIST_FLG" ).append("\n"); 
		query.append("                FROM PARAMS              P, " ).append("\n"); 
		query.append("                     SPC_CTRT_FCAST_CUST F" ).append("\n"); 
		query.append("               WHERE P.TRD_CD         = F.TRD_CD" ).append("\n"); 
		query.append("                 AND P.SUB_TRD_CD     = F.SUB_TRD_CD" ).append("\n"); 
		query.append("                 AND P.RLANE_CD       = F.RLANE_CD" ).append("\n"); 
		query.append("                 AND P.IOC_TS_CD      = F.IOC_TS_CD" ).append("\n"); 
		query.append("                 AND P.VSL_CD         = F.VSL_CD" ).append("\n"); 
		query.append("                 AND P.SKD_VOY_NO     = F.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND P.DIR_CD         = F.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND P.SREP_CD        = F.SREP_USR_ID" ).append("\n"); 
		query.append("                 AND P.CTRT_OFC_CD    = F.CTRT_OFC_CD" ).append("\n"); 
		query.append("                 AND P.CUST_CNT_CD    = F.CUST_CNT_CD" ).append("\n"); 
		query.append("                 AND P.CUST_SEQ       = F.CUST_SEQ" ).append("\n"); 
		query.append("                 AND P.FCAST_SEQ      = F.FCAST_SEQ" ).append("\n"); 
		query.append("                 AND NVL(P.SC_NO,NVL(P.RFA_NO,'X')) = NVL(F.SC_NO,NVL(F.RFA_NO,'X'))" ).append("\n"); 
		query.append("                 --AND DECODE(P.TRD_CD, 'AES', NVL(P.RFA_NO,'X'), NVL(P.SC_NO,'X')) = DECODE(P.TRD_CD, 'AES', NVL(F.RFA_NO,'X'), NVL(F.SC_NO,NVL(P.SC_NO,'X')))" ).append("\n"); 
		query.append("                 AND P.SLS_RGN_OFC_CD = F.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                 AND P.HH_FLG         = 'Y'" ).append("\n"); 
		query.append("              UNION ALL " ).append("\n"); 
		query.append("              SELECT 'LF' AS FLG           ," ).append("\n"); 
		query.append("                     P.LANE_NUM            ," ).append("\n"); 
		query.append("                     P.TRD_CD              ," ).append("\n"); 
		query.append("                     P.SUB_TRD_CD          ," ).append("\n"); 
		query.append("                     P.RLANE_CD            ," ).append("\n"); 
		query.append("                     P.IOC_TS_CD           ," ).append("\n"); 
		query.append("                     P.COST_WK             ," ).append("\n"); 
		query.append("                     P.VSL_CD              ," ).append("\n"); 
		query.append("                     P.SKD_VOY_NO          ," ).append("\n"); 
		query.append("                     P.DIR_CD              ," ).append("\n"); 
		query.append("                     P.SREP_CD             ," ).append("\n"); 
		query.append("                     P.CTRT_OFC_CD         ," ).append("\n"); 
		query.append("                     P.CUST_TP             ," ).append("\n"); 
		query.append("                     P.CUST_CNT_CD         ," ).append("\n"); 
		query.append("                     P.CUST_SEQ            ," ).append("\n"); 
		query.append("                     P.CUST_NM             ," ).append("\n"); 
		query.append("                     P.FCAST_SEQ           ," ).append("\n"); 
		query.append("                     F.SC_NO               ," ).append("\n"); 
		query.append("                     F.RFA_NO              ," ).append("\n"); 
		query.append("                     F.SLS_RHQ_CD          ," ).append("\n"); 
		query.append("                     F.SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("                     0 AS FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("                     0 AS FCAST_TTL_TEU    ," ).append("\n"); 
		query.append("                     0 AS FCAST_20FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS FCAST_40FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                     0 AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                     0 AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                     0 AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("                     0 AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_TTL_QTY    , 0) + (NVL(FCAST_40FT_HC_QTY, 0) + NVL(FCAST_45FT_HC_QTY, 0) + NVL(FCAST_53FT_QTY, 0)) * 2) AS LFCAST_TTL_QTY," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_TTL_QTY    , 0)) AS LFCAST_TTL_TEU    ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_20FT_QTY   , 0)) AS LFCAST_20FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_40FT_QTY   , 0)) AS LFCAST_40FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_40FT_HC_QTY, 0)) AS LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_45FT_HC_QTY, 0)) AS LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_53FT_QTY   , 0)) AS LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_RF_QTY     , 0)) AS LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("                     SUM(NVL(F.FCAST_TTL_WGT    , 0)) AS LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("                     NULL AS FCAST_RMK    ," ).append("\n"); 
		query.append("                     MAX(EXIST_FLG) AS EXIST_FLG" ).append("\n"); 
		query.append("                FROM PARAMS             P," ).append("\n"); 
		query.append("                     SPC_DLY_FCAST_CUST F" ).append("\n"); 
		query.append("               WHERE P.TRD_CD         = F.TRD_CD" ).append("\n"); 
		query.append("                 AND P.SUB_TRD_CD     = F.SUB_TRD_CD" ).append("\n"); 
		query.append("                 AND P.RLANE_CD       = F.RLANE_CD" ).append("\n"); 
		query.append("                 AND P.IOC_TS_CD      = F.IOC_TS_CD" ).append("\n"); 
		query.append("                 AND P.VSL_CD         = F.VSL_CD" ).append("\n"); 
		query.append("                 AND P.SKD_VOY_NO     = F.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND P.DIR_CD         = F.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND P.CUST_CNT_CD    = F.CUST_CNT_CD" ).append("\n"); 
		query.append("                 AND P.CUST_SEQ       = F.CUST_SEQ" ).append("\n"); 
		query.append("                 AND NVL(P.SC_NO,NVL(P.RFA_NO,'X')) = NVL(F.SC_NO,NVL(F.RFA_NO,'X'))" ).append("\n"); 
		query.append("                 --AND DECODE(P.TRD_CD, 'AES', NVL(P.RFA_NO,'X'), NVL(P.SC_NO,'X')) = DECODE(P.TRD_CD, 'AES', NVL(F.RFA_NO,'X'), NVL(F.SC_NO,NVL(P.SC_NO,'X')))" ).append("\n"); 
		query.append("                 AND P.SLS_RGN_OFC_CD = F.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                 AND P.HH_FLG         = 'Y'" ).append("\n"); 
		query.append("            GROUP BY P.LANE_NUM      ," ).append("\n"); 
		query.append("                     P.TRD_CD        ," ).append("\n"); 
		query.append("                     P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                     P.RLANE_CD      ," ).append("\n"); 
		query.append("                     P.IOC_TS_CD     ," ).append("\n"); 
		query.append("                     P.COST_WK       ," ).append("\n"); 
		query.append("                     P.VSL_CD        ," ).append("\n"); 
		query.append("                     P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                     P.DIR_CD        ," ).append("\n"); 
		query.append("                     P.SREP_CD       ," ).append("\n"); 
		query.append("                     P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("                     P.CUST_TP       ," ).append("\n"); 
		query.append("                     P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("                     P.CUST_SEQ      ," ).append("\n"); 
		query.append("                     P.CUST_NM       ," ).append("\n"); 
		query.append("                     P.FCAST_SEQ     ," ).append("\n"); 
		query.append("                     F.SC_NO         ," ).append("\n"); 
		query.append("                     F.RFA_NO        ," ).append("\n"); 
		query.append("                     F.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                     F.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("            ) P" ).append("\n"); 
		query.append("   GROUP BY P.FLG           ," ).append("\n"); 
		query.append("            P.LANE_NUM      ," ).append("\n"); 
		query.append("            P.TRD_CD        ," ).append("\n"); 
		query.append("            P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("            P.RLANE_CD      ," ).append("\n"); 
		query.append("            P.IOC_TS_CD     ," ).append("\n"); 
		query.append("            P.COST_WK       ," ).append("\n"); 
		query.append("            P.VSL_CD        ," ).append("\n"); 
		query.append("            P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("            P.DIR_CD        ," ).append("\n"); 
		query.append("            P.SREP_CD       ," ).append("\n"); 
		query.append("            P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("            P.CUST_TP       ," ).append("\n"); 
		query.append("            P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("            P.CUST_NM       ," ).append("\n"); 
		query.append("            P.CUST_SEQ      ," ).append("\n"); 
		query.append("            P.FCAST_SEQ     ," ).append("\n"); 
		query.append("            P.SC_NO         ," ).append("\n"); 
		query.append("            P.RFA_NO        ," ).append("\n"); 
		query.append("            P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("            P.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT P.TRD_CD        ," ).append("\n"); 
		query.append("         P.IOC_TS_CD     ," ).append("\n"); 
		query.append("         P.SREP_CD       ," ).append("\n"); 
		query.append("         P.SREP_NM       ," ).append("\n"); 
		query.append("         P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("         P.CUST_TP       ," ).append("\n"); 
		query.append("         P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("         P.CUST_SEQ      ," ).append("\n"); 
		query.append("         P.CUST_NM       ," ).append("\n"); 
		query.append("         DECODE(SUBSTR(P.SC_RFA_NO,1,1),'1',SUBSTR(P.SC_RFA_NO,2),'') AS SC_NO," ).append("\n"); 
		query.append("         DECODE(P.TRD_CD,'AES',SUBSTR(P.SC_RFA_NO,2),'') AS RFA_NO," ).append("\n"); 
		query.append("         DECODE(P.TRD_CD,'AES',DECODE(SUBSTR(P.SC_RFA_NO,1,1),'1','S','R'),'S') AS SC_FLG," ).append("\n"); 
		query.append("         --DECODE(P.TRD_CD, 'AES', '', P.SC_RFA_NO) AS SC_NO," ).append("\n"); 
		query.append("         --DECODE(P.TRD_CD, 'AES', P.SC_RFA_NO, '') AS RFA_NO," ).append("\n"); 
		query.append("         P.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("         P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         P.RLANE_CD      ,  " ).append("\n"); 
		query.append("#if(${view_type} == 'FEU')" ).append("\n"); 
		query.append("         ROUND(P.GUIDE_QTY / 2, 1) AS GUIDE_QTY," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         P.GUIDE_QTY     ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("         P.FCAST_SEQ     ," ).append("\n"); 
		query.append("         P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("         P.COST_WK       ," ).append("\n"); 
		query.append("         P.VSL_CD        ," ).append("\n"); 
		query.append("         P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("         P.DIR_CD        ,         " ).append("\n"); 
		query.append("         P.RNUM          ," ).append("\n"); 
		query.append("         P.LVL           , " ).append("\n"); 
		query.append("         P.FCAST_CNT     ,   " ).append("\n"); 
		query.append("#if(${view_type} == 'FEU')   " ).append("\n"); 
		query.append("         ROUND(P.FCAST_TTL_QTY / 2, 1)  AS FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         0                              AS FCAST_20FT_QTY   ," ).append("\n"); 
		query.append("         ROUND(P.FCAST_TTL_TEU / 2, 1)  AS FCAST_40FT_QTY   ," ).append("\n"); 
		query.append("         P.FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_RF_QTY      ," ).append("\n"); 
		query.append("         P.FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("         ROUND(P.LFCAST_TTL_QTY / 2, 1)  AS LFCAST_TTL_QTY   ," ).append("\n"); 
		query.append("         0                               AS LFCAST_20FT_QTY  ," ).append("\n"); 
		query.append("         ROUND(P.LFCAST_TTL_TEU / 2, 1)  AS LFCAST_40FT_QTY  ," ).append("\n"); 
		query.append("         P.LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("#elseif(${view_type} == 'TEU')" ).append("\n"); 
		query.append("         P.FCAST_TTL_QTY  AS FCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_TTL_TEU  AS FCAST_20FT_QTY   ," ).append("\n"); 
		query.append("         0                AS FCAST_40FT_QTY   ," ).append("\n"); 
		query.append("         P.FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_RF_QTY      ," ).append("\n"); 
		query.append("         P.FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_QTY  AS LFCAST_TTL_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_TEU  AS LFCAST_20FT_QTY  ," ).append("\n"); 
		query.append("         0                 AS LFCAST_40FT_QTY  ," ).append("\n"); 
		query.append("         P.LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("#else      " ).append("\n"); 
		query.append("         P.FCAST_TTL_QTY     ," ).append("\n"); 
		query.append("         P.FCAST_20FT_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_40FT_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("         P.FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("         P.FCAST_RF_QTY      ," ).append("\n"); 
		query.append("         P.FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_QTY    ," ).append("\n"); 
		query.append("         P.LFCAST_20FT_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_40FT_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         P.LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         P.LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("         P.LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         DECODE(VSL_CD, 'TTL', NULL, P.FCAST_RMK) AS FCAST_RMK," ).append("\n"); 
		query.append("         P.TOT_CNT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("              SELECT P.TRD_CD        ," ).append("\n"); 
		query.append("                     P.IOC_TS_CD     ," ).append("\n"); 
		query.append("                     P.SREP_CD       ," ).append("\n"); 
		query.append("                     P.SREP_NM       ," ).append("\n"); 
		query.append("                     P.CTRT_OFC_CD   ," ).append("\n"); 
		query.append("                     P.CUST_TP       ," ).append("\n"); 
		query.append("                     P.CUST_CNT_CD   ," ).append("\n"); 
		query.append("                     P.CUST_SEQ      ," ).append("\n"); 
		query.append("                     DECODE(P.CUST_TP, NULL, '', MAX(P.CUST_NM)) AS CUST_NM," ).append("\n"); 
		query.append("                     DECODE(NVL(P.SC_NO,'1'),'1','2'||P.RFA_NO, '1'||P.SC_NO) AS SC_RFA_NO," ).append("\n"); 
		query.append("                     --DECODE(P.TRD_CD, 'AES', P.RFA_NO, P.SC_NO) AS SC_RFA_NO," ).append("\n"); 
		query.append("                     P.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("                     P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                     P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                     P.RLANE_CD      ," ).append("\n"); 
		query.append("                     P.GUIDE_QTY     ," ).append("\n"); 
		query.append("                     P.FCAST_SEQ     ," ).append("\n"); 
		query.append("                     P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                     NVL(P.COST_WK   , 'TTL') AS COST_WK   ," ).append("\n"); 
		query.append("                     NVL(P.VSL_CD    , 'TTL') AS VSL_CD    ," ).append("\n"); 
		query.append("                     NVL(P.SKD_VOY_NO, ' '  ) AS SKD_VOY_NO," ).append("\n"); 
		query.append("                     NVL(P.DIR_CD    , ' '  ) AS DIR_CD    ," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     DENSE_RANK() OVER (ORDER BY P.COST_WK, P.VVD_CNT)                 AS RNUM," ).append("\n"); 
		query.append("                     2 - TRUNC((GROUPING_ID(P.CUST_CNT_CD, P.SLS_RGN_OFC_CD) + 1) / 2) AS LVL , " ).append("\n"); 
		query.append("                     1 - GROUPING_ID(DECODE(NVL(P.SC_NO,'1'),'1','2'||P.RFA_NO, '1'||P.SC_NO)) AS SC_LVL," ).append("\n"); 
		query.append("                     --1 - GROUPING_ID(DECODE(P.TRD_CD, 'AES', P.RFA_NO, P.SC_NO)) AS SC_LVL," ).append("\n"); 
		query.append("                     SUM(DECODE(F.FLG, 'CF', 1, 0)) AS FCAST_CNT," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     SUM(FCAST_TTL_QTY)      AS FCAST_TTL_QTY     ," ).append("\n"); 
		query.append("                     SUM(FCAST_TTL_TEU)      AS FCAST_TTL_TEU     ," ).append("\n"); 
		query.append("                     SUM(FCAST_20FT_QTY)     AS FCAST_20FT_QTY    ," ).append("\n"); 
		query.append("                     SUM(FCAST_40FT_QTY)     AS FCAST_40FT_QTY    ," ).append("\n"); 
		query.append("                     SUM(FCAST_40FT_HC_QTY)  AS FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("                     SUM(FCAST_45FT_HC_QTY)  AS FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("                     SUM(FCAST_53FT_QTY)     AS FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("                     SUM(FCAST_RF_QTY)       AS FCAST_RF_QTY      ," ).append("\n"); 
		query.append("                     SUM(FCAST_TTL_WGT)      AS FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("                     SUM(LFCAST_TTL_QTY)     AS LFCAST_TTL_QTY    ," ).append("\n"); 
		query.append("                     SUM(LFCAST_TTL_TEU)     AS LFCAST_TTL_TEU    ," ).append("\n"); 
		query.append("                     SUM(LFCAST_20FT_QTY)    AS LFCAST_20FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(LFCAST_40FT_QTY)    AS LFCAST_40FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(LFCAST_40FT_HC_QTY) AS LFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(LFCAST_45FT_HC_QTY) AS LFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(LFCAST_53FT_QTY)    AS LFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(LFCAST_RF_QTY)      AS LFCAST_RF_QTY     ," ).append("\n"); 
		query.append("                     SUM(LFCAST_TTL_WGT)     AS LFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("                     MAX(FCAST_RMK)          AS FCAST_RMK         ," ).append("\n"); 
		query.append("                     MAX(F.EXIST_FLG)        AS F_EXIST_FLG       ," ).append("\n"); 
		query.append("                     MAX(P.EXIST_FLG)        AS P_EXIST_FLG       ," ).append("\n"); 
		query.append("                     SUM(NVL2(P.COST_WK, 0, 1)) OVER (PARTITION BY P.TRD_CD) AS TOT_CNT" ).append("\n"); 
		query.append("                FROM MDL_CUST_REV P," ).append("\n"); 
		query.append("                     FCAST_DATA   F" ).append("\n"); 
		query.append("               WHERE P.TRD_CD          = F.TRD_CD         (+)" ).append("\n"); 
		query.append("                 AND P.SUB_TRD_CD      = F.SUB_TRD_CD     (+)" ).append("\n"); 
		query.append("                 AND P.RLANE_CD        = F.RLANE_CD       (+)" ).append("\n"); 
		query.append("                 AND P.IOC_TS_CD       = F.IOC_TS_CD      (+)" ).append("\n"); 
		query.append("                 AND P.VSL_CD          = F.VSL_CD         (+)" ).append("\n"); 
		query.append("                 AND P.SKD_VOY_NO      = F.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("                 AND P.DIR_CD          = F.DIR_CD         (+)" ).append("\n"); 
		query.append("                 AND P.SREP_CD         = F.SREP_CD        (+)" ).append("\n"); 
		query.append("                 AND P.CUST_CNT_CD     = F.CUST_CNT_CD    (+)" ).append("\n"); 
		query.append("                 AND P.CUST_SEQ        = F.CUST_SEQ       (+)" ).append("\n"); 
		query.append("                 AND P.CTRT_OFC_CD     = F.CTRT_OFC_CD    (+)" ).append("\n"); 
		query.append("                 AND P.SLS_RGN_OFC_CD  = F.SLS_RGN_OFC_CD (+)" ).append("\n"); 
		query.append("                 AND P.FCAST_SEQ       = F.FCAST_SEQ      (+)" ).append("\n"); 
		query.append("                 AND NVL(P.SC_NO,NVL(P.RFA_NO, 'X')) = NVL(F.SC_NO (+),NVL(F.RFA_NO (+), 'X'))" ).append("\n"); 
		query.append("                 --AND DECODE(P.TRD_CD, 'AES', NVL(P.RFA_NO, 'X'), NVL(P.SC_NO, 'X')) = DECODE(P.TRD_CD, 'AES', NVL(F.RFA_NO (+), 'X'), COALESCE(F.SC_NO (+), P.SC_NO, 'X'))" ).append("\n"); 
		query.append("             GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                        (P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ)," ).append("\n"); 
		query.append("                                        (P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, P.COST_WK, P.VVD_CNT)," ).append("\n"); 
		query.append("#if (${trade} == 'TPS' || ${trade} == 'AES')" ).append("\n"); 
		query.append("                                        (P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, P.COST_WK, P.VVD_CNT, DECODE(NVL(P.SC_NO,'1'),'1','2'||P.RFA_NO, '1'||P.SC_NO))," ).append("\n"); 
		query.append("                                        --(P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, P.COST_WK, P.VVD_CNT, DECODE(P.TRD_CD, 'AES', P.RFA_NO, P.SC_NO))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        (P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, DECODE(NVL(P.SC_NO,'1'),'1','2'||P.RFA_NO, '1'||P.SC_NO), P.CUST_CTRL_CD, P.SLS_RHQ_CD, P.SLS_RGN_OFC_CD, P.RLANE_CD, P.GUIDE_QTY, P.FCAST_SEQ, P.SUB_TRD_CD)," ).append("\n"); 
		query.append("                                        (P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, DECODE(NVL(P.SC_NO,'1'),'1','2'||P.RFA_NO, '1'||P.SC_NO), P.CUST_CTRL_CD, P.SLS_RHQ_CD, P.SLS_RGN_OFC_CD, P.RLANE_CD, P.GUIDE_QTY, P.FCAST_SEQ, P.SUB_TRD_CD, P.COST_WK, P.VVD_CNT, P.VSL_CD, P.SKD_VOY_NO, P.DIR_CD)" ).append("\n"); 
		query.append("                                        --(P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, DECODE(P.TRD_CD, 'AES', P.RFA_NO, P.SC_NO), P.CUST_CTRL_CD, P.SLS_RHQ_CD, P.SLS_RGN_OFC_CD, P.RLANE_CD, P.GUIDE_QTY, P.FCAST_SEQ, P.SUB_TRD_CD)," ).append("\n"); 
		query.append("                                        --(P.TRD_CD, P.IOC_TS_CD, P.SREP_CD, P.SREP_NM, P.CTRT_OFC_CD, P.CUST_TP, P.CUST_CNT_CD, P.CUST_SEQ, DECODE(P.TRD_CD, 'AES', P.RFA_NO, P.SC_NO), P.CUST_CTRL_CD, P.SLS_RHQ_CD, P.SLS_RGN_OFC_CD, P.RLANE_CD, P.GUIDE_QTY, P.FCAST_SEQ, P.SUB_TRD_CD, P.COST_WK, P.VVD_CNT, P.VSL_CD, P.SKD_VOY_NO, P.DIR_CD)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("         ) P                    " ).append("\n"); 
		query.append("   WHERE ( " ).append("\n"); 
		query.append("#if (${trade} == 'TPS' || ${trade} == 'AES' ) " ).append("\n"); 
		query.append("            ( " ).append("\n"); 
		query.append("               NOT ( CUST_CTRL_CD IS NOT NULL AND FCAST_CNT = 0)" ).append("\n"); 
		query.append("               AND ( NVL(P.F_EXIST_FLG, 'N') = 'N' AND NVL(P.P_EXIST_FLG, 'N') = 'N' AND (SC_LVL = 1 OR COST_WK = 'TTL'))" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            ( ( NVL(P.F_EXIST_FLG, 'N') = 'Y' or NVL(P.P_EXIST_FLG, 'N') = 'Y' ) AND (LVL + SC_LVL) <> 2)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            ( " ).append("\n"); 
		query.append("               NOT (CUST_CTRL_CD IS NOT NULL AND FCAST_CNT = 0)" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            ( NVL(P.F_EXIST_FLG, 'N') = 'Y' or NVL(P.P_EXIST_FLG, 'N') = 'Y' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  ORDER BY P.TRD_CD   ," ).append("\n"); 
		query.append("           P.IOC_TS_CD," ).append("\n"); 
		query.append("           NVL(P.SREP_CD, '0')," ).append("\n"); 
		query.append("           P.CTRT_OFC_CD," ).append("\n"); 
		query.append("           NVL(P.CUST_CNT_CD   , '0')," ).append("\n"); 
		query.append("           NVL(P.CUST_SEQ      ,  0 )," ).append("\n"); 
		query.append("           NVL(P.SC_RFA_NO, DECODE(NVL(P.F_EXIST_FLG, 'N')||NVL(P.P_EXIST_FLG, 'N'), 'NN', 'Z', '0' ))," ).append("\n"); 
		query.append("           NVL(P.SLS_RHQ_CD    , '0')," ).append("\n"); 
		query.append("           NVL(P.SLS_RGN_OFC_CD, '0')," ).append("\n"); 
		query.append("           NVL(P.SUB_TRD_CD    ,  0 )," ).append("\n"); 
		query.append("           P.RLANE_CD   ," ).append("\n"); 
		query.append("           P.GUIDE_QTY  ," ).append("\n"); 
		query.append("           NVL(RNUM, 99)," ).append("\n"); 
		query.append("           P.COST_WK    ," ).append("\n"); 
		query.append("           P.VSL_CD     ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO ," ).append("\n"); 
		query.append("           P.DIR_CD" ).append("\n"); 

	}
}
