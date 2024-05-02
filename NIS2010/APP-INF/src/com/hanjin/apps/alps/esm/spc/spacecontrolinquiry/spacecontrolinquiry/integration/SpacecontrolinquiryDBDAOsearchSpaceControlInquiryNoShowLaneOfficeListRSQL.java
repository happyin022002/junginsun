/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.22
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.07.22 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpaceControlInquiryNoShowLaneOfficeList
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL(){
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
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mon_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL").append("\n"); 
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
		query.append("           -- 2014.07.16 REV month기준 추가" ).append("\n"); 
		query.append("           @[rev_month] AS R_MONTH ," ).append("\n"); 
		query.append("           @[mon_flg] AS MON_FLG ," ).append("\n"); 
		query.append("           @[week]   AS P_WEEK  ," ).append("\n"); 
		query.append("           @[rhq]    AS RHQ_CD  ," ).append("\n"); 
		query.append("           @[office] AS OFC_CD  ," ).append("\n"); 
		query.append("           @[trade]  AS TRD_CD  ," ).append("\n"); 
		query.append("           @[lane]   AS RLANE_CD," ).append("\n"); 
		query.append("		   @[bound]  AS DIR_CD  ," ).append("\n"); 
		query.append("           @[vvd]    AS VVD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq2} != '') " ).append("\n"); 
		query.append("     UNION" ).append("\n"); 
		query.append("     SELECT @[type]   TYPE    ," ).append("\n"); 
		query.append("            @[year]   P_YEAR  ," ).append("\n"); 
		query.append("            @[month]  P_MONTH ," ).append("\n"); 
		query.append("            -- 2014.07.16 REV month기준 추가" ).append("\n"); 
		query.append("            @[rev_month] AS R_MONTH ," ).append("\n"); 
		query.append("            @[mon_flg] AS MON_FLG ," ).append("\n"); 
		query.append("            @[week]   P_WEEK  ," ).append("\n"); 
		query.append("            @[rhq2]   RHQ_CD  ," ).append("\n"); 
		query.append("            @[office] OFC_CD  ," ).append("\n"); 
		query.append("            @[trade]  TRD_CD  ," ).append("\n"); 
		query.append("            @[lane]   RLANE_CD," ).append("\n"); 
		query.append("		    @[bound]  AS DIR_CD  ," ).append("\n"); 
		query.append("            @[vvd]    VVD" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",VVDS AS (" ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE " ).append("\n"); 
		query.append("--     V.IOC_CD     = 'O' AND" ).append("\n"); 
		query.append("       V.RLANE_CD  <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD > ' '" ).append("\n"); 
		query.append("       AND V.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE " ).append("\n"); 
		query.append("--     V.IOC_CD    = 'O' AND" ).append("\n"); 
		query.append("       V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND V.TRD_CD    = P.TRD_CD" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.P_YEAR||P.P_WEEK" ).append("\n"); 
		query.append("--       AND V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9, 1)" ).append("\n"); 
		query.append("--       AND V.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE " ).append("\n"); 
		query.append("--     V.IOC_CD    = 'O' AND" ).append("\n"); 
		query.append("       V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("       AND V.SLS_YRMON = @[year]||@[rev_month]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK IN ( SELECT P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                       FROM ( SELECT DECODE(MON, '01', FDT, (FDT + CASE" ).append("\n"); 
		query.append("                                                                                                        WHEN TO_CHAR(FDT, 'D') < 5 THEN TO_CHAR(FDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                                                                                                   ELSE 8 - TO_CHAR(FDT, 'D')" ).append("\n"); 
		query.append("                                                                                                    END)" ).append("\n"); 
		query.append("                                                                     ) AS FDT," ).append("\n"); 
		query.append("                                                                     (LDT + CASE" ).append("\n"); 
		query.append("                                                                                 WHEN TO_CHAR(LDT, 'D') < 4 THEN TO_CHAR(LDT, 'D') * -1 - 6" ).append("\n"); 
		query.append("                                                                                                            ELSE TO_CHAR(LDT, 'D')* -1 + 1" ).append("\n"); 
		query.append("                                                                             END" ).append("\n"); 
		query.append("                                                                     ) AS LDT" ).append("\n"); 
		query.append("                                                                FROM ( SELECT TO_DATE(DECODE(S.P_MONTH, '', '', TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))) AS FDT," ).append("\n"); 
		query.append("                                                                              TO_DATE(DECODE(S.P_MONTH, '', '', TRUNC(LAST_DAY(TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))))) AS LDT," ).append("\n"); 
		query.append("                                                                              S.P_MONTH AS MON" ).append("\n"); 
		query.append("                                                                         FROM PARAMS S )" ).append("\n"); 
		query.append("                                                            ) D," ).append("\n"); 
		query.append("                                                            MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                      WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                        AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND P.P_MONTH IS NOT NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK  IS NULL" ).append("\n"); 
		query.append("       AND P.TRD_CD  IS NULL" ).append("\n"); 
		query.append("       AND P.VVD     IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 6 AS FLG    ," ).append("\n"); 
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
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE " ).append("\n"); 
		query.append("--     V.IOC_CD = 'O' AND" ).append("\n"); 
		query.append("       V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND V.TRD_CD = P.TRD_CD" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("       AND V.SLS_YRMON = @[year]||@[rev_month]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
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
		query.append("                                                            MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                      WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                        AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND P.P_MONTH  IS NOT NULL" ).append("\n"); 
		query.append("       AND P.P_WEEK   IS NULL" ).append("\n"); 
		query.append("       AND P.RLANE_CD IS NULL" ).append("\n"); 
		query.append("       AND P.TRD_CD   IS NOT NULL" ).append("\n"); 
		query.append("       AND P.VVD      IS NULL" ).append("\n"); 
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
		query.append("     FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("          PARAMS      P" ).append("\n"); 
		query.append("    WHERE " ).append("\n"); 
		query.append("--    V.IOC_CD    = 'O' AND" ).append("\n"); 
		query.append("      V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("      AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("      AND V.RLANE_CD  = P.RLANE_CD" ).append("\n"); 
		query.append("      AND V.TRD_CD    = P.TRD_CD" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("       AND V.SLS_YRMON = @[year]||@[rev_month]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
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
		query.append("                                                               FROM ( SELECT TO_DATE(DECODE(S.P_MONTH, '', '', TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))) FDT," ).append("\n"); 
		query.append("                                                                             TO_DATE(DECODE(S.P_MONTH, '', '', TRUNC(LAST_DAY(TO_DATE(S.P_YEAR||S.P_MONTH||'01', 'YYYYMMDD'))))) LDT," ).append("\n"); 
		query.append("                                                                              S.P_MONTH AS MON" ).append("\n"); 
		query.append("                                                                        FROM PARAMS S )" ).append("\n"); 
		query.append("                                                           ) D," ).append("\n"); 
		query.append("                                                           MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                     WHERE P.COST_YR IN (TO_CHAR(D.LDT, 'YYYY'), TO_CHAR(D.FDT, 'YYYY'))" ).append("\n"); 
		query.append("                                                       AND P.SLS_FM_DT BETWEEN TO_CHAR(D.FDT, 'YYYYMMDD') AND TO_CHAR(D.LDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("	   AND V.DIR_CD = P.DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND P.P_MONTH  IS NOT NULL" ).append("\n"); 
		query.append("      AND P.P_WEEK   IS NULL" ).append("\n"); 
		query.append("      AND P.RLANE_CD IS NOT NULL" ).append("\n"); 
		query.append("      AND P.VVD      IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA_OFC AS (" ).append("\n"); 
		query.append("    SELECT R.ALOC_DDCT_BSE_CD," ).append("\n"); 
		query.append("           R.OFC_KND_CD      , " ).append("\n"); 
		query.append("           R.TRD_CD          ," ).append("\n"); 
		query.append("		   R.SUB_TRD_CD 	 ," ).append("\n"); 
		query.append("           R.RLANE_CD        ," ).append("\n"); 
		query.append("           R.DIR_CD          ," ).append("\n"); 
		query.append("           R.VSL_CD          ," ).append("\n"); 
		query.append("           R.SKD_VOY_NO      ," ).append("\n"); 
		query.append("           R.SKD_DIR_CD      ," ).append("\n"); 
		query.append("           R.SLS_RHQ_CD      ," ).append("\n"); 
		query.append("           SUBSTR(R.SLS_AQ_CD, 4, 3) AS SLS_AQ_CD," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD  ," ).append("\n"); 
		query.append("           R.SLS_OFC_CD      ," ).append("\n"); 
		query.append("           P.COST_YR         ," ).append("\n"); 
		query.append("           P.COST_WK         ," ).append("\n"); 
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
		query.append("	   AND R.TRD_CD			  = P.TRD_CD	" ).append("\n"); 
		query.append("  GROUP BY R.ALOC_DDCT_BSE_CD," ).append("\n"); 
		query.append("           R.OFC_KND_CD      ," ).append("\n"); 
		query.append("           R.TRD_CD          ," ).append("\n"); 
		query.append("		   R.SUB_TRD_CD 	 ," ).append("\n"); 
		query.append("           R.RLANE_CD        ," ).append("\n"); 
		query.append("           R.DIR_CD          ," ).append("\n"); 
		query.append("           R.VSL_CD          ," ).append("\n"); 
		query.append("           R.SKD_VOY_NO      ," ).append("\n"); 
		query.append("           R.SKD_DIR_CD      ," ).append("\n"); 
		query.append("           R.SLS_RHQ_CD      ," ).append("\n"); 
		query.append("           SUBSTR(R.SLS_AQ_CD, 4, 3)," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD  ," ).append("\n"); 
		query.append("           R.SLS_OFC_CD      ," ).append("\n"); 
		query.append("           P.COST_YR         ," ).append("\n"); 
		query.append("           P.COST_WK         ," ).append("\n"); 
		query.append("           DECODE(P.TYPE, '3', 'M', 'D')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA AS (" ).append("\n"); 
		query.append("    SELECT NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD) AS AQ_CD ," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD               AS OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD ," ).append("\n"); 
		query.append("		   R.SUB_TRD_CD," ).append("\n"); 
		query.append("           R.RLANE_CD," ).append("\n"); 
		query.append("           R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("		   R.DIR_CD," ).append("\n"); 
		query.append("           R.COST_YR," ).append("\n"); 
		query.append("           R.COST_WK," ).append("\n"); 
		query.append("           SUM(R.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("           SUM(R.ALOC_LOD_QTY)  AS ALOC_LOD_QTY ," ).append("\n"); 
		query.append("           SUM(R.BKG_LOD_QTY)   AS BKG_LOD_QTY  ," ).append("\n"); 
		query.append("           SUM(SHORTFALL)       AS SHORTFALL" ).append("\n"); 
		query.append("      FROM NSHW_DATA_OFC R" ).append("\n"); 
		query.append("  GROUP BY NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD)," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD        ," ).append("\n"); 
		query.append("		   R.SUB_TRD_CD," ).append("\n"); 
		query.append("           R.RLANE_CD      ," ).append("\n"); 
		query.append("           R.VSL_CD        ," ).append("\n"); 
		query.append("           R.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           R.SKD_DIR_CD    ," ).append("\n"); 
		query.append("		   R.DIR_CD," ).append("\n"); 
		query.append("           R.COST_YR       ," ).append("\n"); 
		query.append("           R.COST_WK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT N.TRD_CD  ," ).append("\n"); 
		query.append("         N.SUB_TRD_CD, " ).append("\n"); 
		query.append("         N.RLANE_CD," ).append("\n"); 
		query.append("         N.COST_YR ," ).append("\n"); 
		query.append("         N.COST_WK ," ).append("\n"); 
		query.append("         N.VVD     ," ).append("\n"); 
		query.append("		 N.DIR_CD  ," ).append("\n"); 
		query.append("         N.AQ_CD   ," ).append("\n"); 
		query.append("         N.OFC_CD  ," ).append("\n"); 
		query.append("         SUM(N.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("         SUM(N.ALOC_LOD_QTY)  AS ALOC_LOD_QTY ," ).append("\n"); 
		query.append("         SUM(N.BKG_LOD_QTY)   AS BKG_LOD_QTY  ," ).append("\n"); 
		query.append("         SUM(SHORTFALL)       AS SHORTFALL    ," ).append("\n"); 
		query.append("         TO_CHAR(ROUND(DECODE(SUM(NVL(N.FCAST_LOD_QTY, 0)), 0, 0, SUM(NVL(N.SHORTFALL, 0)) / SUM(NVL(N.FCAST_LOD_QTY, 0)) * 100), 2), 'FM99990.00') AS RATIO," ).append("\n"); 
		query.append("         DECODE(N.TRD_CD, NULL, 0, 1) + DECODE(N.RLANE_CD, NULL, 0, 1) + DECODE(N.VVD, NULL, 0, 1) + DECODE(N.AQ_CD, NULL, 0, 1) + DECODE(N.OFC_CD, NULL, 0, 1) AS LVL" ).append("\n"); 
		query.append("    FROM NSHW_DATA N" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                         (N.TRD_CD, N.SUB_TRD_CD, N.RLANE_CD, N.VVD, N.DIR_CD,	N.COST_YR, N.COST_WK, N.AQ_CD, N.OFC_CD)," ).append("\n"); 
		query.append("                         (N.TRD_CD, N.SUB_TRD_CD, N.RLANE_CD, N.VVD, N.DIR_CD,	N.COST_YR, N.COST_WK, N.AQ_CD)," ).append("\n"); 
		query.append("                         (N.TRD_CD, N.SUB_TRD_CD, N.RLANE_CD, N.VVD, N.DIR_CD,	N.COST_YR, N.COST_WK)," ).append("\n"); 
		query.append("                         (N.TRD_CD, N.SUB_TRD_CD, N.RLANE_CD)," ).append("\n"); 
		query.append("                         (N.TRD_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("ORDER BY NVL(N.TRD_CD  , ' ')," ).append("\n"); 
		query.append("		 NVL(N.SUB_TRD_CD, ' '), " ).append("\n"); 
		query.append("         NVL(N.RLANE_CD, ' ')," ).append("\n"); 
		query.append("         NVL(N.COST_YR , ' ')," ).append("\n"); 
		query.append("         NVL(N.COST_WK , ' ')," ).append("\n"); 
		query.append("         NVL(N.VVD     , ' ')," ).append("\n"); 
		query.append("		 NVL(N.DIR_CD  , ' ')," ).append("\n"); 
		query.append("         DECODE(N.AQ_CD, 'DNC', '1', 'DSC', '2', 'DKJ', '3', 'DSA', '4', 'DPI', '5', NVL(N.AQ_CD, '0'))," ).append("\n"); 
		query.append("         NVL(N.OFC_CD  , ' ')" ).append("\n"); 

	}
}
