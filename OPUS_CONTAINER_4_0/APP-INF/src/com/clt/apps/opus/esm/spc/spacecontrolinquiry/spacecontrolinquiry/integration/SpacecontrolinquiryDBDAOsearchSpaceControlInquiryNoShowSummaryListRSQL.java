/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpaceControlInquiryNoShowSummaryList
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL(){
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
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL").append("\n"); 
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
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[type]   AS TYPE    ," ).append("\n"); 
		query.append("           @[year]   AS P_YEAR  ," ).append("\n"); 
		query.append("           @[month]  AS P_MONTH ," ).append("\n"); 
		query.append("           @[week]   AS P_WEEK  ," ).append("\n"); 
		query.append("           @[rhq]    AS RHQ_CD  ," ).append("\n"); 
		query.append("           @[office] AS OFC_CD  ," ).append("\n"); 
		query.append("           @[trade]  AS TRD_CD  ," ).append("\n"); 
		query.append("           @[lane]   AS RLANE_CD," ).append("\n"); 
		query.append("           @[vvd]    AS VVD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", vvds AS (" ).append("\n"); 
		query.append("    SELECT 1 AS FLG    ," ).append("\n"); 
		query.append("           P.TYPE      ," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.RHQ_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD  <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD > ' '" ).append("\n"); 
		query.append("       AND V.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("       AND P.RLANE_CD IS NOT NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK   IS NOT NULL" ).append("\n"); 
		query.append("       AND P.VVD      IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 2 AS FLG    ," ).append("\n"); 
		query.append("           P.TYPE      ," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.RHQ_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND V.TRD_CD    = P.TRD_CD" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("       AND P.RLANE_CD IS NULL" ).append("\n"); 
		query.append("       AND P.TRD_CD   IS NOT NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK   IS NOT NULL" ).append("\n"); 
		query.append("       AND P.VVD      IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 3 AS FLG    ," ).append("\n"); 
		query.append("           P.TYPE      ," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.RHQ_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("       AND V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND P.TRD_CD IS NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK IS NOT NULL" ).append("\n"); 
		query.append("       AND P.VVD    IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 4 AS FLG    ," ).append("\n"); 
		query.append("           P.TYPE      ," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.RHQ_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9, 1)" ).append("\n"); 
		query.append("       AND V.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("       AND P.VVD IS NOT NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 5 AS FLG    ," ).append("\n"); 
		query.append("           P.TYPE      ," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.RHQ_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK IN ( SELECT P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                       FROM ( SELECT DECODE(MON, '01', FDT, (FDT + CASE" ).append("\n"); 
		query.append("                                                                                                        WHEN TO_CHAR(FDT, 'D') < 5 THEN TO_CHAR(FDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                                                                                   ELSE 8 - TO_CHAR(FDT, 'D')" ).append("\n"); 
		query.append("                                                                                                    END)" ).append("\n"); 
		query.append("                                                                     ) AS FDT," ).append("\n"); 
		query.append("                                                                     (LDT + CASE" ).append("\n"); 
		query.append("                                                                                 WHEN TO_CHAR(LDT, 'D') < 4 THEN TO_CHAR(LDT, 'D') * -1 - 6" ).append("\n"); 
		query.append("                                                                                                            ELSE TO_CHAR(LDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                             END" ).append("\n"); 
		query.append("                                                                     ) AS LDT" ).append("\n"); 
		query.append("                                                                FROM ( SELECT TO_DATE(DECODE(S.P_MONTH, '', '', TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))) AS FDT," ).append("\n"); 
		query.append("                                                                              TO_DATE(DECODE(S.P_MONTH, '', '', TRUNC(LAST_DAY(TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))))) AS LDT," ).append("\n"); 
		query.append("                                                                              S.P_MONTH AS MON" ).append("\n"); 
		query.append("                                                                         FROM PARAMS S )" ).append("\n"); 
		query.append("                                                            ) D," ).append("\n"); 
		query.append("                                                            COA_WK_PRD P" ).append("\n"); 
		query.append("                                                      WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                        AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("       AND P.P_MONTH IS NOT NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK  IS NULL" ).append("\n"); 
		query.append("       AND P.TRD_CD  IS NULL" ).append("\n"); 
		query.append("       AND P.VVD     IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 6 AS FLG   ," ).append("\n"); 
		query.append("          P.TYPE      ," ).append("\n"); 
		query.append("          V.RLANE_CD  ," ).append("\n"); 
		query.append("          V.VSL_CD    ," ).append("\n"); 
		query.append("          V.SKD_VOY_NO," ).append("\n"); 
		query.append("          V.DIR_CD    ," ).append("\n"); 
		query.append("          V.TRD_CD    ," ).append("\n"); 
		query.append("          P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("          V.COST_WK   ," ).append("\n"); 
		query.append("          P.RHQ_CD    ," ).append("\n"); 
		query.append("          P.OFC_CD" ).append("\n"); 
		query.append("     FROM COA_MON_VVD V," ).append("\n"); 
		query.append("          PARAMS      P" ).append("\n"); 
		query.append("    WHERE V.IOC_CD = 'O'" ).append("\n"); 
		query.append("      AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("      AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND V.TRD_CD = P.TRD_CD" ).append("\n"); 
		query.append("      AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK IN ( SELECT P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                      FROM ( SELECT DECODE(MON, '01', FDT, (FDT + CASE" ).append("\n"); 
		query.append("                                                                                                       WHEN TO_CHAR(FDT, 'D') < 5 THEN TO_CHAR(FDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                                                                                  ELSE 8 - TO_CHAR(FDT, 'D')" ).append("\n"); 
		query.append("                                                                                                   END)" ).append("\n"); 
		query.append("                                                                    ) AS FDT," ).append("\n"); 
		query.append("                                                                    (LDT + CASE" ).append("\n"); 
		query.append("                                                                                WHEN TO_CHAR(LDT, 'D') < 4 THEN TO_CHAR(LDT, 'D') * -1 - 6" ).append("\n"); 
		query.append("                                                                                                           ELSE TO_CHAR(LDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                            END" ).append("\n"); 
		query.append("                                                                    ) AS LDT" ).append("\n"); 
		query.append("                                                               FROM ( SELECT TO_DATE(DECODE(S.P_MONTH, '', '', TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))) AS FDT," ).append("\n"); 
		query.append("                                                                             TO_DATE(DECODE(S.P_MONTH, '', '', TRUNC(LAST_DAY(TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))))) AS LDT," ).append("\n"); 
		query.append("                                                                             S.P_MONTH AS MON" ).append("\n"); 
		query.append("                                                                        FROM PARAMS S )" ).append("\n"); 
		query.append("                                                           ) D," ).append("\n"); 
		query.append("                                                           COA_WK_PRD P" ).append("\n"); 
		query.append("                                                     WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                       AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("      AND P.P_MONTH  IS NOT NULL" ).append("\n"); 
		query.append("      AND P.P_WEEK   IS NULL" ).append("\n"); 
		query.append("      AND P.RLANE_CD IS NULL" ).append("\n"); 
		query.append("      AND P.TRD_CD   IS NOT NULL" ).append("\n"); 
		query.append("      AND P.VVD      IS NULL" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT 7 AS FLG    ," ).append("\n"); 
		query.append("          P.TYPE      ," ).append("\n"); 
		query.append("          V.RLANE_CD  ," ).append("\n"); 
		query.append("          V.VSL_CD    ," ).append("\n"); 
		query.append("          V.SKD_VOY_NO," ).append("\n"); 
		query.append("          V.DIR_CD    ," ).append("\n"); 
		query.append("          V.TRD_CD    ," ).append("\n"); 
		query.append("          P.P_YEAR AS COST_YR," ).append("\n"); 
		query.append("          V.COST_WK   ," ).append("\n"); 
		query.append("          P.RHQ_CD    ," ).append("\n"); 
		query.append("          P.OFC_CD" ).append("\n"); 
		query.append("     FROM COA_MON_VVD V," ).append("\n"); 
		query.append("          PARAMS      P" ).append("\n"); 
		query.append("    WHERE V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("      AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("      AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("      AND V.RLANE_CD  = P.RLANE_CD" ).append("\n"); 
		query.append("      AND V.TRD_CD    = P.TRD_CD" ).append("\n"); 
		query.append("      AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK IN ( SELECT P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                      FROM ( SELECT DECODE(MON, '01', FDT, (FDT + CASE" ).append("\n"); 
		query.append("                                                                                                       WHEN TO_CHAR(FDT, 'D') < 5 THEN TO_CHAR(FDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                                                                                  ELSE 8 - TO_CHAR(FDT, 'D')" ).append("\n"); 
		query.append("                                                                                                   END)" ).append("\n"); 
		query.append("                                                                    ) AS FDT," ).append("\n"); 
		query.append("                                                                    (LDT + CASE" ).append("\n"); 
		query.append("                                                                                WHEN TO_CHAR(LDT, 'D') < 4 THEN TO_CHAR(LDT, 'D') * -1 - 6" ).append("\n"); 
		query.append("                                                                                                           ELSE TO_CHAR(LDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                            END" ).append("\n"); 
		query.append("                                                                    ) AS LDT" ).append("\n"); 
		query.append("                                                               FROM ( SELECT TO_DATE(DECODE(S.P_MONTH, '', '', TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))) AS FDT," ).append("\n"); 
		query.append("                                                                             TO_DATE(DECODE(S.P_MONTH, '', '', TRUNC(LAST_DAY(TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))))) AS LDT," ).append("\n"); 
		query.append("                                                                             S.P_MONTH AS MON" ).append("\n"); 
		query.append("                                                                        FROM PARAMS S )" ).append("\n"); 
		query.append("                                                           ) D," ).append("\n"); 
		query.append("                                                           COA_WK_PRD P" ).append("\n"); 
		query.append("                                                     WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                       AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("      AND P.P_MONTH  IS NOT NULL" ).append("\n"); 
		query.append("      AND P.P_WEEK   IS NULL" ).append("\n"); 
		query.append("      AND P.RLANE_CD IS NOT NULL" ).append("\n"); 
		query.append("      AND P.VVD      IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA_OFC AS (" ).append("\n"); 
		query.append("    SELECT R.ALOC_DDCT_BSE_CD," ).append("\n"); 
		query.append("           R.OFC_KND_CD     ," ).append("\n"); 
		query.append("           R.TRD_CD         ," ).append("\n"); 
		query.append("           R.RLANE_CD       ," ).append("\n"); 
		query.append("           R.DIR_CD         ," ).append("\n"); 
		query.append("           R.VSL_CD         ," ).append("\n"); 
		query.append("           R.SKD_VOY_NO     ," ).append("\n"); 
		query.append("           R.SKD_DIR_CD     ," ).append("\n"); 
		query.append("           R.SLS_RHQ_CD     ," ).append("\n"); 
		query.append("           SUBSTR(R.SLS_AQ_CD, 4, 3) AS SLS_AQ_CD," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           R.SLS_OFC_CD    ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           DECODE(P.TYPE, '3', 'M', 'D') AS TYPE," ).append("\n"); 
		query.append("           SUM(R.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("           SUM(R.ALOC_LOD_QTY)  AS ALOC_LOD_QTY ," ).append("\n"); 
		query.append("           SUM(R.BKG_LOD_QTY)   AS BKG_LOD_QTY  ," ).append("\n"); 
		query.append("           (SPC_GET_NSHW_SHRTFLL_FNC(DECODE(P.TYPE, '3', 'M', 'D'), SUM(R.FCAST_LOD_QTY), SUM(R.ALOC_LOD_QTY), SUM(R.BKG_LOD_QTY))) AS SHORTFALL" ).append("\n"); 
		query.append("      FROM SPC_NSHW_RSLT R," ).append("\n"); 
		query.append("           VVDS          P" ).append("\n"); 
		query.append("     WHERE R.ALOC_DDCT_BSE_CD = P.TYPE" ).append("\n"); 
		query.append("       AND R.OFC_KND_CD       = '3'" ).append("\n"); 
		query.append("       AND R.RLANE_CD         = P.RLANE_CD" ).append("\n"); 
		query.append("       AND R.DIR_CD           = P.DIR_CD" ).append("\n"); 
		query.append("       AND R.VSL_CD           = P.VSL_CD" ).append("\n"); 
		query.append("       AND R.SKD_VOY_NO       = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND R.SKD_DIR_CD       = P.DIR_CD" ).append("\n"); 
		query.append("       AND (P.RHQ_CD IS NULL OR R.SLS_RHQ_CD     = P.RHQ_CD)" ).append("\n"); 
		query.append("       AND (P.OFC_CD IS NULL OR R.SLS_RGN_OFC_CD = P.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY R.ALOC_DDCT_BSE_CD," ).append("\n"); 
		query.append("           R.OFC_KND_CD      ," ).append("\n"); 
		query.append("           R.TRD_CD          ," ).append("\n"); 
		query.append("           R.RLANE_CD        ," ).append("\n"); 
		query.append("           R.DIR_CD          ," ).append("\n"); 
		query.append("           R.VSL_CD          ," ).append("\n"); 
		query.append("           R.SKD_VOY_NO      ," ).append("\n"); 
		query.append("           R.SKD_DIR_CD      ," ).append("\n"); 
		query.append("           R.SLS_RHQ_CD      ," ).append("\n"); 
		query.append("           SUBSTR(R.SLS_AQ_CD, 4, 3)," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD  ," ).append("\n"); 
		query.append("           R.SLS_OFC_CD      ," ).append("\n"); 
		query.append("           P.COST_WK         ," ).append("\n"); 
		query.append("           DECODE(P.TYPE, '3', 'M', 'D')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA AS (" ).append("\n"); 
		query.append("    SELECT NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD) AS AQ_CD ," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD               AS OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD," ).append("\n"); 
		query.append("           SUM(R.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("           SUM(R.ALOC_LOD_QTY)  AS ALOC_LOD_QTY ," ).append("\n"); 
		query.append("           SUM(R.BKG_LOD_QTY)   AS BKG_LOD_QTY  ," ).append("\n"); 
		query.append("           SUM(SHORTFALL)       AS SHORTFALL" ).append("\n"); 
		query.append("      FROM NSHW_DATA_OFC R" ).append("\n"); 
		query.append("  GROUP BY NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD)," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD        ," ).append("\n"); 
		query.append("           R.TYPE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TRADES AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           TRD_CD" ).append("\n"); 
		query.append("      FROM NSHW_DATA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", OFFICES AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           AQ_CD ," ).append("\n"); 
		query.append("           OFC_CD" ).append("\n"); 
		query.append("      FROM NSHW_DATA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TRD_OFC AS (" ).append("\n"); 
		query.append("    SELECT AQ_CD ," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           TRD_CD" ).append("\n"); 
		query.append("      FROM TRADES  T," ).append("\n"); 
		query.append("           OFFICES O" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT MAX(AQ_CD)         AS AQ_CD        ," ).append("\n"); 
		query.append("         MAX(OFC_CD)        AS OFC_CD       ," ).append("\n"); 
		query.append("         MAX(TRD_CD)        AS TRD_CD       ," ).append("\n"); 
		query.append("         MAX(FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("         0   AS SHORTFALL," ).append("\n"); 
		query.append("         '0' AS RATIO    ," ).append("\n"); 
		query.append("         0   AS LVL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT MIN(COST_WK) AS AQ_CD ," ).append("\n"); 
		query.append("                   MAX(COST_WK) AS OFC_CD," ).append("\n"); 
		query.append("                   '' AS TRD_CD," ).append("\n"); 
		query.append("                   0  AS FCAST_LOD_QTY" ).append("\n"); 
		query.append("              FROM VVDS" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '' AS AQ_CD ," ).append("\n"); 
		query.append("                   '' AS OFC_CD," ).append("\n"); 
		query.append("                      MAX(DECODE(ROWNUM, 1, TRD_CD, ''))" ).append("\n"); 
		query.append("                   || MAX(DECODE(ROWNUM, 2, '|'||TRD_CD, ''))" ).append("\n"); 
		query.append("                   || MAX(DECODE(ROWNUM, 3, '|'||TRD_CD, ''))" ).append("\n"); 
		query.append("                   || MAX(DECODE(ROWNUM, 4, '|'||TRD_CD, ''))" ).append("\n"); 
		query.append("                   || MAX(DECODE(ROWNUM, 5, '|'||TRD_CD, '')) AS TRD_CD," ).append("\n"); 
		query.append("                   COUNT(1) AS FCAST_LOD_QTY" ).append("\n"); 
		query.append("              FROM TRADES" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT AQ_CD        ," ).append("\n"); 
		query.append("         OFC_CD       ," ).append("\n"); 
		query.append("         TRD_CD       ," ).append("\n"); 
		query.append("         FCAST_LOD_QTY," ).append("\n"); 
		query.append("         SHORTFALL    ," ).append("\n"); 
		query.append("         TO_CHAR(ROUND(RATIO, 2), 'FM99990.00') AS RATIO," ).append("\n"); 
		query.append("         LVL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT NVL(O.AQ_CD, 'G.TTL') AS AQ_CD," ).append("\n"); 
		query.append("                   DECODE(O.AQ_CD, NULL, 'G.TTL', NVL(O.OFC_CD, 'S.TTL')) AS OFC_CD," ).append("\n"); 
		query.append("                   NVL(O.TRD_CD, 'TTL') AS TRD_CD," ).append("\n"); 
		query.append("                   SUM(NVL(N.FCAST_LOD_QTY, 0)) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("                   SUM(NVL(N.SHORTFALL, 0))     AS SHORTFALL    ," ).append("\n"); 
		query.append("                   DECODE(SUM(NVL(N.FCAST_LOD_QTY, 0)), 0, 0, SUM(NVL(N.SHORTFALL, 0)) / SUM(NVL(N.FCAST_LOD_QTY, 0)) * 100) AS RATIO," ).append("\n"); 
		query.append("                   DECODE(O.OFC_CD, NULL, DECODE(O.AQ_CD, NULL, 0, 1), 2) AS LVL" ).append("\n"); 
		query.append("              FROM TRD_OFC   O," ).append("\n"); 
		query.append("                   NSHW_DATA N" ).append("\n"); 
		query.append("             WHERE N.OFC_CD(+) = O.OFC_CD" ).append("\n"); 
		query.append("               AND N.TRD_CD(+) = O.TRD_CD" ).append("\n"); 
		query.append("          GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("                                  (O.AQ_CD, O.OFC_CD, O.TRD_CD)," ).append("\n"); 
		query.append("                                  (O.AQ_CD, O.TRD_CD)," ).append("\n"); 
		query.append("                                  (O.AQ_CD, O.OFC_CD)," ).append("\n"); 
		query.append("                                  (O.AQ_CD)," ).append("\n"); 
		query.append("                                  (O.TRD_CD)," ).append("\n"); 
		query.append("                                  ()" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("          ORDER BY DECODE(O.AQ_CD, 'DNC', '1', 'DSC', '2', 'DKJ', '3', 'DSA', '4', 'DPI', '5', '6')," ).append("\n"); 
		query.append("                   NVL(O.AQ_CD , 'ZZZZZZ')," ).append("\n"); 
		query.append("                   NVL(O.OFC_CD, 'ZZZZZ' )," ).append("\n"); 
		query.append("                   NVL(O.TRD_CD, 'ZZZ')" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}