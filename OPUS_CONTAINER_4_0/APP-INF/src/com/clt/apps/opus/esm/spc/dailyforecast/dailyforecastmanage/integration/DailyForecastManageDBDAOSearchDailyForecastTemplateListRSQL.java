/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastTemplateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchDailyForecastTemplateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Daily Forecast Template을 조회한다.
	  * 2015.07.22. SKY[CLT-000042051-10] Virtual add call - VT_ADD_CALL_FLG IS  NULL  로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchDailyForecastTemplateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("OPERATOR",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchDailyForecastTemplateListRSQL").append("\n"); 
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
		query.append("WITH PARAMS AS " ).append("\n"); 
		query.append("       (SELECT @[year] AS COST_YR " ).append("\n"); 
		query.append("            , @[week] AS COST_WK " ).append("\n"); 
		query.append("            , @[duration] AS DUR " ).append("\n"); 
		query.append("            , @[trade] AS TRD_CD " ).append("\n"); 
		query.append("            , @[subtrade] AS SUB_TRD_CD " ).append("\n"); 
		query.append("            , @[lane] AS RLANE_CD " ).append("\n"); 
		query.append("            , @[bound] AS DIR_CD" ).append("\n"); 
		query.append("            , (SELECT N4TH_PRNT_OFC_CD  FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND OFC_CD = @[office]" ).append("\n"); 
		query.append("              ) RGN_OFC_CD" ).append("\n"); 
		query.append("            , @[office] AS FCAST_OFC_CD  " ).append("\n"); 
		query.append("            , @[OPERATOR] AS SALESREP " ).append("\n"); 
		query.append("            , @[fcast] AS CUSTOMER " ).append("\n"); 
		query.append("            , @[vvd] AS VVD " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       )  " ).append("\n"); 
		query.append("     , VVDLS AS " ).append("\n"); 
		query.append("       (SELECT DISTINCT SLS_YRMON " ).append("\n"); 
		query.append("            , COST_WK " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("            , DIR_CD " ).append("\n"); 
		query.append("            , VSL_CD " ).append("\n"); 
		query.append("            , SKD_VOY_NO " ).append("\n"); 
		query.append("            , SKD_DIR_CD " ).append("\n"); 
		query.append("            , IOC_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT MV.SLS_YRMON " ).append("\n"); 
		query.append("                   , MV.COST_WK " ).append("\n"); 
		query.append("                   , MV.TRD_CD " ).append("\n"); 
		query.append("                   , MV.SUB_TRD_CD " ).append("\n"); 
		query.append("                   , MV.RLANE_CD " ).append("\n"); 
		query.append("                   , MV.DIR_CD " ).append("\n"); 
		query.append("                   , MV.VSL_CD " ).append("\n"); 
		query.append("                   , MV.SKD_VOY_NO " ).append("\n"); 
		query.append("                   , MV.DIR_CD AS SKD_DIR_CD " ).append("\n"); 
		query.append("                   , MV.IOC_CD " ).append("\n"); 
		query.append("                FROM COA_MON_VVD MV /* VVD 값 들어올 경우 조건 추가 */ " ).append("\n"); 
		query.append("                   , PARAMS P " ).append("\n"); 
		query.append("               WHERE SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK IN " ).append("\n"); 
		query.append("                     (SELECT COST_YR||COST_WK " ).append("\n"); 
		query.append("                       FROM " ).append("\n"); 
		query.append("                            (SELECT P.COST_YR " ).append("\n"); 
		query.append("                                 , P.COST_WK " ).append("\n"); 
		query.append("                              FROM COA_WK_PRD P " ).append("\n"); 
		query.append("                             WHERE P.COST_YR||P.COST_WK >= @[year]||@[week] " ).append("\n"); 
		query.append("                          ORDER BY P.COST_YR||P.COST_WK " ).append("\n"); 
		query.append("                            ) Z " ).append("\n"); 
		query.append("                      WHERE ROWNUM <= P.DUR " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                     AND MV.TRD_CD = P.TRD_CD " ).append("\n"); 
		query.append("                     AND MV.SUB_TRD_CD LIKE P.SUB_TRD_CD||'%' " ).append("\n"); 
		query.append("                     AND MV.RLANE_CD LIKE P.RLANE_CD||'%' " ).append("\n"); 
		query.append("                     AND MV.DIR_CD = P.DIR_CD " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                     ( " ).append("\n"); 
		query.append("                         MV.DELT_FLG IS NULL " ).append("\n"); 
		query.append("                         OR MV.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                     AND MV.RLANE_CD <> 'RBCCO' " ).append("\n"); 
		query.append("					 #if (${vvd} != '') " ).append("\n"); 
		query.append("                     AND MV.VSL_CD = SUBSTR(@[vvd], 1, 4) " ).append("\n"); 
		query.append("                     AND MV.SKD_VOY_NO = SUBSTR(@[vvd] , 5, 4) " ).append("\n"); 
		query.append("                     AND MV.DIR_CD = SUBSTR(@[vvd], 9, 1) " ).append("\n"); 
		query.append("                     #end " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("     , VVD_POL AS " ).append("\n"); 
		query.append("       (SELECT SLS_YRMON " ).append("\n"); 
		query.append("            , COST_WK " ).append("\n"); 
		query.append("            , TRD_CD " ).append("\n"); 
		query.append("            , SUB_TRD_CD " ).append("\n"); 
		query.append("            , RLANE_CD " ).append("\n"); 
		query.append("            , M.VSL_CD " ).append("\n"); 
		query.append("            , M.SKD_VOY_NO " ).append("\n"); 
		query.append("            , M.SKD_DIR_CD " ).append("\n"); 
		query.append("            , NVL(V.YD_CD, M.POL_CD) AS POL_CD " ).append("\n"); 
		query.append("            , MAX " ).append("\n"); 
		query.append("              ( " ).append("\n"); 
		query.append("                     (SELECT DECODE(MAX(S.SKD_CNG_STS_CD), 'S', 0, NVL(MAX(S.CLPT_SEQ), -1)) " ).append("\n"); 
		query.append("                       FROM VSK_VSL_PORT_SKD S " ).append("\n"); 
		query.append("                      WHERE S.VSL_CD = M.VSL_CD " ).append("\n"); 
		query.append("                            AND S.SKD_VOY_NO = M.SKD_VOY_NO " ).append("\n"); 
		query.append("                            AND S.SKD_DIR_CD = M.SKD_DIR_CD " ).append("\n"); 
		query.append("                            AND S.VPS_PORT_CD = M.POL_CD" ).append("\n"); 
		query.append("                            AND S.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("                            AND " ).append("\n"); 
		query.append("                            ( " ).append("\n"); 
		query.append("                                S.SKD_CNG_STS_CD IS NULL " ).append("\n"); 
		query.append("                                OR S.SKD_CNG_STS_CD <> 'S' " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                 ) AS POL_SEQ " ).append("\n"); 
		query.append("               , MAX " ).append("\n"); 
		query.append("                 ( " ).append("\n"); 
		query.append("                        (SELECT MLOC.CONTI_CD " ).append("\n"); 
		query.append("                          FROM MDM_LOCATION MLOC " ).append("\n"); 
		query.append("                         WHERE M.POL_CD = MLOC.LOC_CD " ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                    ) AS POL_CONTI " ).append("\n"); 
		query.append("                  , MIN(CD_DP_SEQ) AS CD_DP_SEQ " ).append("\n"); 
		query.append("                  , SUB_OFC_CD " ).append("\n"); 
		query.append("                  , RGN_OFC_CD " ).append("\n"); 
		query.append("                  , IOC_TS_CD " ).append("\n"); 
		query.append("               FROM " ).append("\n"); 
		query.append("                    (SELECT 1 AS FLG " ).append("\n"); 
		query.append("                         , V.SLS_YRMON " ).append("\n"); 
		query.append("                         , V.COST_WK " ).append("\n"); 
		query.append("                         , V.TRD_CD " ).append("\n"); 
		query.append("                         , V.SUB_TRD_CD " ).append("\n"); 
		query.append("                         , V.RLANE_CD " ).append("\n"); 
		query.append("                         , V.VSL_CD " ).append("\n"); 
		query.append("                         , V.SKD_VOY_NO " ).append("\n"); 
		query.append("                         , V.SKD_DIR_CD " ).append("\n"); 
		query.append("                         , M.POL_CD " ).append("\n"); 
		query.append("                         , M.CD_DP_SEQ " ).append("\n"); 
		query.append("                         , P.FCAST_OFC_CD   AS SUB_OFC_CD " ).append("\n"); 
		query.append("                         , M.SLS_RGN_OFC_CD AS RGN_OFC_CD " ).append("\n"); 
		query.append("                         , M.IOC_TS_CD " ).append("\n"); 
		query.append("                      FROM VVDLS V " ).append("\n"); 
		query.append("                         , SPC_FCAST_OFC_POL_MAPG M " ).append("\n"); 
		query.append("                         , PARAMS P " ).append("\n"); 
		query.append("                     WHERE 1=1 " ).append("\n"); 
		query.append("                           AND M.TRD_CD = V.TRD_CD " ).append("\n"); 
		query.append("                           AND M.SUB_TRD_CD = V.SUB_TRD_CD " ).append("\n"); 
		query.append("                           AND M.RLANE_CD = V.RLANE_CD " ).append("\n"); 
		query.append("                           AND M.DIR_CD = V.DIR_CD " ).append("\n"); 
		query.append("                           AND M.SLS_OFC_CD = P.RGN_OFC_CD " ).append("\n"); 
		query.append("                           AND M.BSE_YRWK = " ).append("\n"); 
		query.append("                           (SELECT /*+ INDEX_DESC(MI XPKSPC_FCAST_OFC_POL_MAPG) */ " ).append("\n"); 
		query.append("                                  MI.BSE_YRWK " ).append("\n"); 
		query.append("                             FROM SPC_FCAST_OFC_POL_MAPG MI " ).append("\n"); 
		query.append("                            WHERE MI.TRD_CD = M.TRD_CD " ).append("\n"); 
		query.append("                                  AND MI.SUB_TRD_CD = M.SUB_TRD_CD " ).append("\n"); 
		query.append("                                  AND MI.RLANE_CD = M.RLANE_CD " ).append("\n"); 
		query.append("                                  AND MI.DIR_CD = M.DIR_CD " ).append("\n"); 
		query.append("                                  AND MI.SLS_OFC_CD = M.SLS_OFC_CD " ).append("\n"); 
		query.append("                                  AND MI.BSE_YRWK <= SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK " ).append("\n"); 
		query.append("                                  AND ROWNUM = 1 " ).append("\n"); 
		query.append("                           ) " ).append("\n"); 
		query.append("                    ) M " ).append("\n"); 
		query.append("                  , VSK_VSL_PORT_SKD V " ).append("\n"); 
		query.append("              WHERE M.VSL_CD = V.VSL_CD " ).append("\n"); 
		query.append("                    AND M.SKD_VOY_NO = V.SKD_VOY_NO " ).append("\n"); 
		query.append("                    AND M.SKD_DIR_CD = V.SKD_DIR_CD " ).append("\n"); 
		query.append("                    AND M.POL_CD = V.VPS_PORT_CD " ).append("\n"); 
		query.append("                    AND V.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("              GROUP BY SLS_YRMON " ).append("\n"); 
		query.append("                  , COST_WK " ).append("\n"); 
		query.append("                  , TRD_CD " ).append("\n"); 
		query.append("                  , SUB_TRD_CD " ).append("\n"); 
		query.append("                  , RLANE_CD " ).append("\n"); 
		query.append("                  , M.VSL_CD " ).append("\n"); 
		query.append("                  , M.SKD_VOY_NO " ).append("\n"); 
		query.append("                  , M.SKD_DIR_CD " ).append("\n"); 
		query.append("                  , NVL(V.YD_CD, M.POL_CD) " ).append("\n"); 
		query.append("                  , SUB_OFC_CD " ).append("\n"); 
		query.append("                  , RGN_OFC_CD " ).append("\n"); 
		query.append("                  , IOC_TS_CD " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("           , TEMP_VVD AS " ).append("\n"); 
		query.append("             (SELECT SLS_YRMON " ).append("\n"); 
		query.append("                  , COST_WK " ).append("\n"); 
		query.append("                  , TRD_CD " ).append("\n"); 
		query.append("                  , SUB_TRD_CD " ).append("\n"); 
		query.append("                  , RLANE_CD " ).append("\n"); 
		query.append("                  , VSL_CD " ).append("\n"); 
		query.append("                  , SKD_VOY_NO " ).append("\n"); 
		query.append("                  , SKD_DIR_CD " ).append("\n"); 
		query.append("                  , VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("                  , POL_CD AS POL_YD_CD " ).append("\n"); 
		query.append("                  , POD_CD AS POD_YD_CD --  , POL_SEQ " ).append("\n"); 
		query.append("                    --  , CD_DP_SEQ " ).append("\n"); 
		query.append("                    --  , MIN(POD_SEQ) AS POD_SEQ " ).append("\n"); 
		query.append("                  , FCAST_OFC_CD --  , SUB_OFC_CD " ).append("\n"); 
		query.append("                  , IOC_TS_CD " ).append("\n"); 
		query.append("				  #if (${operator} == 'Y') " ).append("\n"); 
		query.append("                  , SREP_CD AS SREP_USR_ID " ).append("\n"); 
		query.append("                  #end  " ).append("\n"); 
		query.append("                  #if (${fcast} == 'Y') " ).append("\n"); 
		query.append("                  , FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("                  , CUST_CNT_CD " ).append("\n"); 
		query.append("                  , CUST_SEQ " ).append("\n"); 
		query.append("                  --20160203.ADD" ).append("\n"); 
		query.append("                  , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                  , CTRT_CUST_NM" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("               FROM " ).append("\n"); 
		query.append("                    (SELECT SL.SLS_YRMON " ).append("\n"); 
		query.append("                         , SL.COST_WK " ).append("\n"); 
		query.append("                         , RL.TRD_CD " ).append("\n"); 
		query.append("                         , RL.SUB_TRD_CD " ).append("\n"); 
		query.append("                         , RL.RLANE_CD " ).append("\n"); 
		query.append("                         , SL.VSL_CD " ).append("\n"); 
		query.append("                         , SL.SKD_VOY_NO " ).append("\n"); 
		query.append("                         , SL.SKD_DIR_CD " ).append("\n"); 
		query.append("                         , SL.POL_CD " ).append("\n"); 
		query.append("                         , SL.POL_SEQ " ).append("\n"); 
		query.append("                         , SL.CD_DP_SEQ " ).append("\n"); 
		query.append("                         , SL.POL_CONTI " ).append("\n"); 
		query.append("                         , SD.YD_CD AS POD_CD " ).append("\n"); 
		query.append("                         , TO_NUMBER(DECODE(SD.SKD_CNG_STS_CD, 'S', NULL, SD.CLPT_SEQ)) AS POD_SEQ " ).append("\n"); 
		query.append("                         , DECODE(SL.SUB_OFC_CD,SL.RGN_OFC_CD,SL.RGN_OFC_CD,SL.SUB_OFC_CD) AS FCAST_OFC_CD " ).append("\n"); 
		query.append("                        -- , SL.SUB_OFC_CD " ).append("\n"); 
		query.append("                         , SL.IOC_TS_CD " ).append("\n"); 
		query.append("                         , MLOC.CONTI_CD AS POD_CONTI " ).append("\n"); 
		query.append("                         , DECODE(SL.POL_SEQ, NULL, 'Y', 'N') AS POL_SKIP " ).append("\n"); 
		query.append("                         , RL.IOC_CD  " ).append("\n"); 
		query.append("                         #if (${operator} == 'Y') " ).append("\n"); 
		query.append("                         , SRCM.SREP_CD " ).append("\n"); 
		query.append("                         #end  " ).append("\n"); 
		query.append("                         #if (${fcast} == 'Y') " ).append("\n"); 
		query.append("                         , SRCM.FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("                         , SRCM.CUST_CNT_CD " ).append("\n"); 
		query.append("                         , SRCM.CUST_SEQ " ).append("\n"); 
		query.append("                         --20160203.ADD" ).append("\n"); 
		query.append("                         , SRCM.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                         , SRCM.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                         ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SRCM.CTRT_CUST_CNT_CD AND CUST_SEQ = SRCM.CTRT_CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("                         #end  " ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SD " ).append("\n"); 
		query.append("                         , VVD_POL SL " ).append("\n"); 
		query.append("                         , MDM_DTL_REV_LANE RL " ).append("\n"); 
		query.append("                         , MDM_LOCATION MLOC  " ).append("\n"); 
		query.append("                         #if (${operator} == 'Y' || ${fcast} == 'Y') " ).append("\n"); 
		query.append("                         , SPC_SLS_REP_CUST_MAPG SRCM /* sales Rep customer 체크 된 경우 사용 */ " ).append("\n"); 
		query.append("                         #end  " ).append("\n"); 
		query.append("                     WHERE SUBSTR(SL.POL_CD, 1, 5) NOT IN ('EGSCA', 'PAPCA') " ).append("\n"); 
		query.append("                           AND SD.VPS_PORT_CD NOT IN ('EGSCA', 'PAPCA') " ).append("\n"); 
		query.append("                           AND SL.POL_SEQ >= 0 " ).append("\n"); 
		query.append("                           AND SD.VSL_CD = SL.VSL_CD " ).append("\n"); 
		query.append("                           AND SD.SKD_VOY_NO = SL.SKD_VOY_NO " ).append("\n"); 
		query.append("                           AND SD.SKD_DIR_CD = SL.SKD_DIR_CD " ).append("\n"); 
		query.append("                           AND " ).append("\n"); 
		query.append("                           ( " ).append("\n"); 
		query.append("                               SD.SKD_CNG_STS_CD IS NULL " ).append("\n"); 
		query.append("                               OR SD.SKD_CNG_STS_CD <> 'S' " ).append("\n"); 
		query.append("                           ) " ).append("\n"); 
		query.append("                           AND SD.CLPT_SEQ > SL.POL_SEQ" ).append("\n"); 
		query.append("                           AND SD.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append("                           AND RL.TRD_CD = SL.TRD_CD " ).append("\n"); 
		query.append("                           AND RL.SUB_TRD_CD = SL.SUB_TRD_CD " ).append("\n"); 
		query.append("                           AND RL.RLANE_CD = SL.RLANE_CD " ).append("\n"); 
		query.append("                           AND RL.VSL_SLAN_DIR_CD = SL.SKD_DIR_CD " ).append("\n"); 
		query.append("                           AND RL.FM_CONTI_CD = SL.POL_CONTI " ).append("\n"); 
		query.append("                           AND SD.VPS_PORT_CD = MLOC.LOC_CD " ).append("\n"); 
		query.append("                           AND RL.TO_CONTI_CD = MLOC.CONTI_CD " ).append("\n"); 
		query.append("                           AND RL.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                           #if (${operator} == 'Y' || ${fcast} == 'Y') " ).append("\n"); 
		query.append("                           AND SL.TRD_CD = SRCM.TRD_CD(+) " ).append("\n"); 
		query.append("                           AND SL.SUB_TRD_CD = SRCM.SUB_TRD_CD(+) " ).append("\n"); 
		query.append("                           AND SL.RLANE_CD = SRCM.RLANE_CD(+) " ).append("\n"); 
		query.append("                           AND SL.SUB_OFC_CD = SRCM.SLS_OFC_CD(+) " ).append("\n"); 
		query.append("                           AND SL.SKD_DIR_CD = SRCM.DIR_CD(+) " ).append("\n"); 
		query.append("                           #end " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("              GROUP BY SLS_YRMON " ).append("\n"); 
		query.append("                  , COST_WK " ).append("\n"); 
		query.append("                  , TRD_CD " ).append("\n"); 
		query.append("                  , SUB_TRD_CD " ).append("\n"); 
		query.append("                  , RLANE_CD " ).append("\n"); 
		query.append("                  , VSL_CD " ).append("\n"); 
		query.append("                  , SKD_VOY_NO " ).append("\n"); 
		query.append("                  , SKD_DIR_CD " ).append("\n"); 
		query.append("                  , POL_CD " ).append("\n"); 
		query.append("                  , POL_SEQ " ).append("\n"); 
		query.append("                  , CD_DP_SEQ " ).append("\n"); 
		query.append("                  , POD_CD " ).append("\n"); 
		query.append("                  , FCAST_OFC_CD " ).append("\n"); 
		query.append("             --   , SUB_OFC_CD, " ).append("\n"); 
		query.append("                  , IOC_TS_CD  " ).append("\n"); 
		query.append("                  #if (${operator} == 'Y') " ).append("\n"); 
		query.append("                  , SREP_CD " ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                  #if (${fcast} == 'Y') " ).append("\n"); 
		query.append("                  , FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("                  , CUST_CNT_CD " ).append("\n"); 
		query.append("                  , CUST_SEQ " ).append("\n"); 
		query.append("                  --20160203.ADD" ).append("\n"); 
		query.append("                  , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                  , CTRT_CUST_NM" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("           ORDER BY SLS_YRMON " ).append("\n"); 
		query.append("                  ,COST_WK " ).append("\n"); 
		query.append("                  ,TRD_CD " ).append("\n"); 
		query.append("                  ,SUB_TRD_CD " ).append("\n"); 
		query.append("                  ,RLANE_CD " ).append("\n"); 
		query.append("                  ,VSL_CD " ).append("\n"); 
		query.append("                  ,SKD_VOY_NO " ).append("\n"); 
		query.append("                  ,SKD_DIR_CD " ).append("\n"); 
		query.append("                  ,POL_CD " ).append("\n"); 
		query.append("                  ,POD_CD " ).append("\n"); 
		query.append("                  ,FCAST_OFC_CD  " ).append("\n"); 
		query.append("                  #if (${operator} == 'Y') " ).append("\n"); 
		query.append("                  ,SREP_CD " ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                  #if (${fcast} == 'Y') " ).append("\n"); 
		query.append("                  ,FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("                  ,CUST_CNT_CD " ).append("\n"); 
		query.append("                  ,CUST_SEQ " ).append("\n"); 
		query.append("                  --20160203.ADD" ).append("\n"); 
		query.append("                  , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                  , CTRT_CUST_NM" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("      #if(${operator} == 'Y' && ${fcast} == 'Y')  " ).append("\n"); 
		query.append("      SELECT SUBSTR(TV.SLS_YRMON, 1, 4) AS SLS_YRMON" ).append("\n"); 
		query.append("           , TV.COST_WK " ).append("\n"); 
		query.append("           , TV.TRD_CD " ).append("\n"); 
		query.append("           , TV.SUB_TRD_CD " ).append("\n"); 
		query.append("           , TV.RLANE_CD " ).append("\n"); 
		query.append("           , TV.VSL_CD " ).append("\n"); 
		query.append("           , TV.SKD_VOY_NO " ).append("\n"); 
		query.append("           , TV.SKD_DIR_CD " ).append("\n"); 
		query.append("           , TV.VVD " ).append("\n"); 
		query.append("           , TV.POL_YD_CD " ).append("\n"); 
		query.append("           , TV.POD_YD_CD " ).append("\n"); 
		query.append("           , TV.FCAST_OFC_CD " ).append("\n"); 
		query.append("           , TV.IOC_TS_CD " ).append("\n"); 
		query.append("           , TV.SREP_USR_ID " ).append("\n"); 
		query.append("           , TV.FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("           , TV.CUST_CNT_CD " ).append("\n"); 
		query.append("           , TV.CUST_SEQ " ).append("\n"); 
		query.append("           --20160203.ADD" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_NM" ).append("\n"); 
		query.append("           , FC.FCAST_TTL_QTY " ).append("\n"); 
		query.append("           , FC.FCAST_40FT_HC_QTY " ).append("\n"); 
		query.append("           , FC.FCAST_45FT_HC_QTY " ).append("\n"); 
		query.append("           , FC.FCAST_RF_QTY " ).append("\n"); 
		query.append("           , FC.FCAST_TTL_WGT " ).append("\n"); 
		query.append("        FROM TEMP_VVD TV " ).append("\n"); 
		query.append("           , SPC_DLY_FCAST_CUST FC " ).append("\n"); 
		query.append("       WHERE 1=1               " ).append("\n"); 
		query.append("             AND TV.RLANE_CD = FC.RLANE_CD(+) " ).append("\n"); 
		query.append("             AND TV.VSL_CD = FC.VSL_CD(+) " ).append("\n"); 
		query.append("             AND TV.SKD_VOY_NO = FC.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("             AND TV.SKD_DIR_CD = FC.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("             AND TV.FCAST_OFC_CD = FC.FCAST_OFC_CD(+) " ).append("\n"); 
		query.append("             AND TV.IOC_TS_CD = FC.IOC_TS_CD(+) " ).append("\n"); 
		query.append("             AND TV.SREP_USR_ID = FC.SREP_USR_ID(+) " ).append("\n"); 
		query.append("             AND TV.FCAST_CUST_TP_CD = FC.FCAST_CUST_TP_CD(+) " ).append("\n"); 
		query.append("             AND TV.CUST_CNT_CD = FC.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("             AND TV.CUST_SEQ = FC.CUST_SEQ(+) " ).append("\n"); 
		query.append("             AND TV.POL_YD_CD = FC.POL_YD_CD(+) " ).append("\n"); 
		query.append("             AND TV.POD_YD_CD = FC.POD_YD_CD(+) " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      #if (${operator} != 'Y' || ${fcast} != 'Y') " ).append("\n"); 
		query.append("      SELECT SUBSTR(TV.SLS_YRMON, 1, 4) AS SLS_YRMON" ).append("\n"); 
		query.append("           , TV.COST_WK " ).append("\n"); 
		query.append("           , TV.TRD_CD " ).append("\n"); 
		query.append("           , TV.SUB_TRD_CD " ).append("\n"); 
		query.append("           , TV.RLANE_CD " ).append("\n"); 
		query.append("           , TV.VSL_CD " ).append("\n"); 
		query.append("           , TV.SKD_VOY_NO " ).append("\n"); 
		query.append("           , TV.SKD_DIR_CD " ).append("\n"); 
		query.append("           , TV.VVD " ).append("\n"); 
		query.append("           , TV.POL_YD_CD " ).append("\n"); 
		query.append("           , TV.POD_YD_CD " ).append("\n"); 
		query.append("           , TV.FCAST_OFC_CD " ).append("\n"); 
		query.append("           , TV.IOC_TS_CD " ).append("\n"); 
		query.append("           #if (${operator} == 'Y') " ).append("\n"); 
		query.append("           , TV.SREP_USR_ID " ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           #if (${fcast} == 'Y') " ).append("\n"); 
		query.append("           , TV.FCAST_CUST_TP_CD " ).append("\n"); 
		query.append("           , TV.CUST_CNT_CD " ).append("\n"); 
		query.append("           , TV.CUST_SEQ " ).append("\n"); 
		query.append("           --20160203.ADD" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("           , TV.CTRT_CUST_NM" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           , NULL AS FCAST_TTL_QTY " ).append("\n"); 
		query.append("           , NULL AS FCAST_40FT_HC_QTY " ).append("\n"); 
		query.append("           , NULL AS FCAST_45FT_HC_QTY " ).append("\n"); 
		query.append("           , NULL AS FCAST_TTL_WGT " ).append("\n"); 
		query.append("        FROM TEMP_VVD TV " ).append("\n"); 
		query.append("     #end" ).append("\n"); 

	}
}