/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.03.04 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpaceControlInquiryNoShowTradeList
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL(){
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
		query.append("FileName : SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL").append("\n"); 
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
		query.append("           @[month]  AS P_MON   ," ).append("\n"); 
		query.append("           @[week]   AS P_WEEK  ," ).append("\n"); 
		query.append("           @[rhq]    AS RHQ_CD  ," ).append("\n"); 
		query.append("           @[office] AS OFC_CD  ," ).append("\n"); 
		query.append("           @[trade]  AS TRD_CD  ," ).append("\n"); 
		query.append("           @[lane]   AS RLANE_CD," ).append("\n"); 
		query.append("           @[vvd]    AS VVD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CONV AS (" ).append("\n"); 
		query.append("    SELECT TYPE    ," ).append("\n"); 
		query.append("           TO_DATE(P_YEAR||P_MON||'01', 'YYYYMMDD') AS DT," ).append("\n"); 
		query.append("           RHQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           TRD_CD  ," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("      FROM PARAMS" ).append("\n"); 
		query.append("     WHERE P_WEEK IS NULL" ).append("\n"); 
		query.append("       AND VVD    IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT P.TYPE  ," ).append("\n"); 
		query.append("           TO_DATE(PRD.SLS_FM_DT, 'YYYYMMDD') AS DT," ).append("\n"); 
		query.append("           RHQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           TRD_CD  ," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("      FROM COA_WK_PRD PRD," ).append("\n"); 
		query.append("           PARAMS     P" ).append("\n"); 
		query.append("     WHERE PRD.COST_YR = P.P_YEAR" ).append("\n"); 
		query.append("       AND PRD.COST_WK = P.P_WEEK" ).append("\n"); 
		query.append("       AND P.P_WEEK IS NOT NULL" ).append("\n"); 
		query.append("       AND VVD      IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT P.TYPE    ," ).append("\n"); 
		query.append("           TO_DATE(V.SLS_YRMON||'01', 'YYYYMMDD') AS DT," ).append("\n"); 
		query.append("           P.RHQ_CD  ," ).append("\n"); 
		query.append("           P.OFC_CD  ," ).append("\n"); 
		query.append("           V.TRD_CD  ," ).append("\n"); 
		query.append("           V.RLANE_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9)" ).append("\n"); 
		query.append("       AND V.IOC_CD     = 'O'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PDATE AS (" ).append("\n"); 
		query.append("    SELECT TYPE    ," ).append("\n"); 
		query.append("           TRUNC(ADD_MONTHS(DT, -12), 'MONTH') AS FDT," ).append("\n"); 
		query.append("           LAST_DAY(DT) AS LDT," ).append("\n"); 
		query.append("           RHQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           TRD_CD  ," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("      FROM CONV P" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", DATES AS (" ).append("\n"); 
		query.append("    SELECT TYPE," ).append("\n"); 
		query.append("           TO_CHAR(FDT, 'YYYY') AS FYEAR," ).append("\n"); 
		query.append("           TO_CHAR(LDT, 'YYYY') AS LYEAR," ).append("\n"); 
		query.append("           (FDT + CASE" ).append("\n"); 
		query.append("                       WHEN TO_CHAR(FDT, 'D') < 5 THEN TO_CHAR(FDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                                                  ELSE 8 - TO_CHAR(FDT, 'D')" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("           )AS FDT," ).append("\n"); 
		query.append("           (LDT + CASE" ).append("\n"); 
		query.append("                       WHEN TO_CHAR(LDT, 'D') < 4 THEN TO_CHAR(LDT, 'D') * -1 - 6" ).append("\n"); 
		query.append("                                                  ELSE TO_CHAR(LDT, 'D') * -1 + 1" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("           ) AS LDT," ).append("\n"); 
		query.append("           RHQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           TRD_CD  ," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("    FROM PDATE P" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", WEEKS AS (" ).append("\n"); 
		query.append("    SELECT D.TYPE ," ).append("\n"); 
		query.append("           D.FYEAR," ).append("\n"); 
		query.append("           D.LYEAR," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(PRD.SLS_FM_DT, 'YYYYMMDD') + 3, 'YYYY') AS COST_YR," ).append("\n"); 
		query.append("           PRD.COST_WK," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(PRD.SLS_FM_DT, 'YYYYMMDD') + 3, 'MM') AS COST_MON," ).append("\n"); 
		query.append("           RHQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           TRD_CD  ," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("      FROM DATES      D  ," ).append("\n"); 
		query.append("           COA_WK_PRD PRD" ).append("\n"); 
		query.append("     WHERE PRD.COST_YR IN (D.FYEAR, D.LYEAR)" ).append("\n"); 
		query.append("       AND PRD.COST_YR||PRD.COST_WK BETWEEN D.FYEAR||( SELECT TO_CHAR(CEIL((TO_CHAR(D.FDT, 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00')" ).append("\n"); 
		query.append("                                                         FROM COA_WK_PRD PRD" ).append("\n"); 
		query.append("                                                        WHERE PRD.COST_YR = D.FYEAR AND PRD.COST_WK = '01')" ).append("\n"); 
		query.append("                                        AND D.LYEAR||( SELECT TO_CHAR(CEIL((TO_CHAR(D.LDT, 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) /7), 'FM00')" ).append("\n"); 
		query.append("                                                         FROM COA_WK_PRD PRD" ).append("\n"); 
		query.append("                                                        WHERE PRD.COST_YR = D.LYEAR AND PRD.COST_WK = '01')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVDS AS (" ).append("\n"); 
		query.append("    SELECT 7 AS FLG         ," ).append("\n"); 
		query.append("           W.TYPE           ," ).append("\n"); 
		query.append("           '3' AS OFC_KND_CD," ).append("\n"); 
		query.append("           V.RLANE_CD       ," ).append("\n"); 
		query.append("           V.VSL_CD         ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO     ," ).append("\n"); 
		query.append("           V.DIR_CD         ," ).append("\n"); 
		query.append("           V.TRD_CD         ," ).append("\n"); 
		query.append("           W.COST_YR        ," ).append("\n"); 
		query.append("           W.COST_MON       ," ).append("\n"); 
		query.append("           W.COST_WK        ," ).append("\n"); 
		query.append("           W.RHQ_CD         ," ).append("\n"); 
		query.append("           W.OFC_CD" ).append("\n"); 
		query.append("      FROM COA_MON_VVD V," ).append("\n"); 
		query.append("           WEEKS       W" ).append("\n"); 
		query.append("     WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = W.COST_YR||W.COST_WK" ).append("\n"); 
		query.append("       AND V.IOC_CD    = 'O'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND (W.TRD_CD   IS NULL OR V.TRD_CD   = W.TRD_CD  )" ).append("\n"); 
		query.append("       AND (W.RLANE_CD IS NULL OR V.RLANE_CD = W.RLANE_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA_OFC AS (" ).append("\n"); 
		query.append("    SELECT R.ALOC_DDCT_BSE_CD," ).append("\n"); 
		query.append("           R.OFC_KND_CD      ," ).append("\n"); 
		query.append("           R.TRD_CD          ," ).append("\n"); 
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
		query.append("           P.COST_MON        ," ).append("\n"); 
		query.append("           DECODE(P.TYPE, '3', 'M', 'D') AS TYPE," ).append("\n"); 
		query.append("           SUM(R.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("           SUM(R.ALOC_LOD_QTY)  AS ALOC_LOD_QTY ," ).append("\n"); 
		query.append("           SUM(R.BKG_LOD_QTY)   AS BKG_LOD_QTY  ," ).append("\n"); 
		query.append("           (SPC_GET_NSHW_SHRTFLL_FNC(DECODE(P.TYPE, '3', 'M', 'D'), SUM(R.FCAST_LOD_QTY), SUM(R.ALOC_LOD_QTY), SUM(R.BKG_LOD_QTY))) AS SHORTFALL" ).append("\n"); 
		query.append("      FROM SPC_NSHW_RSLT R," ).append("\n"); 
		query.append("           VVDS          P" ).append("\n"); 
		query.append("     WHERE R.ALOC_DDCT_BSE_CD = P.TYPE" ).append("\n"); 
		query.append("       AND R.OFC_KND_CD       = P.OFC_KND_CD" ).append("\n"); 
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
		query.append("           P.COST_YR         ," ).append("\n"); 
		query.append("           P.COST_MON        ," ).append("\n"); 
		query.append("           DECODE(P.TYPE, '3', 'M', 'D')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", NSHW_DATA AS (" ).append("\n"); 
		query.append("    SELECT NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD) AS AQ_CD ," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD               AS OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD  ," ).append("\n"); 
		query.append("           R.COST_YR ," ).append("\n"); 
		query.append("           R.COST_MON," ).append("\n"); 
		query.append("           SUM(R.FCAST_LOD_QTY) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("           SUM(SHORTFALL)       AS SHORTFALL" ).append("\n"); 
		query.append("      FROM NSHW_DATA_OFC R" ).append("\n"); 
		query.append("  GROUP BY NVL(R.SLS_AQ_CD, R.SLS_RHQ_CD)," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           R.TRD_CD        ," ).append("\n"); 
		query.append("           R.COST_YR       ," ).append("\n"); 
		query.append("           R.COST_MON      ," ).append("\n"); 
		query.append("           R.TYPE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MONTHS AS (" ).append("\n"); 
		query.append("    SELECT COST_YR," ).append("\n"); 
		query.append("           COST_MON," ).append("\n"); 
		query.append("           MIN(COST_WK) AS MIN_WK," ).append("\n"); 
		query.append("           MAX(COST_WK) AS MAX_WK," ).append("\n"); 
		query.append("           TO_CHAR(TO_DATE(COST_YR||COST_MON||'01', 'YYYYMMDD'), 'YYYY/MM') AS MON" ).append("\n"); 
		query.append("      FROM WEEKS" ).append("\n"); 
		query.append("  GROUP BY COST_YR ," ).append("\n"); 
		query.append("           COST_MON" ).append("\n"); 
		query.append("  ORDER BY COST_YR DESC ," ).append("\n"); 
		query.append("           COST_MON DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", OFFICES AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           TRD_CD," ).append("\n"); 
		query.append("           AQ_CD ," ).append("\n"); 
		query.append("           OFC_CD" ).append("\n"); 
		query.append("      FROM NSHW_DATA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MON_OFC AS (" ).append("\n"); 
		query.append("    SELECT TRD_CD  ," ).append("\n"); 
		query.append("           AQ_CD   ," ).append("\n"); 
		query.append("           OFC_CD  ," ).append("\n"); 
		query.append("           COST_YR ," ).append("\n"); 
		query.append("           COST_MON," ).append("\n"); 
		query.append("           MIN_WK  ," ).append("\n"); 
		query.append("           MAX_WK" ).append("\n"); 
		query.append("      FROM MONTHS  T," ).append("\n"); 
		query.append("           OFFICES O" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT '' AS TRD_CD ," ).append("\n"); 
		query.append("         '' AS AQ_CD  ," ).append("\n"); 
		query.append("         '' AS OFC_CD ," ).append("\n"); 
		query.append("         '' AS COST_YR," ).append("\n"); 
		query.append("            MAX(DECODE(ROWNUM,  1, MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  2, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  3, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  4, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  5, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  6, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  7, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  8, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM,  9, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 10, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 11, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 12, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 13, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 14, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 15, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', ''))" ).append("\n"); 
		query.append("         || MAX(DECODE(ROWNUM, 16, '|'||MON||'('||MIN_WK||'-'||MAX_WK||')', '')) AS MON," ).append("\n"); 
		query.append("         COUNT(1) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("         0   AS SHORTFALL," ).append("\n"); 
		query.append("         '0' AS RATIO    ," ).append("\n"); 
		query.append("         0   AS LVL" ).append("\n"); 
		query.append("    FROM MONTHS" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT TRD_CD         ," ).append("\n"); 
		query.append("         AQ_CD          ," ).append("\n"); 
		query.append("         OFC_CD         ," ).append("\n"); 
		query.append("         COST_YR        ," ).append("\n"); 
		query.append("         COST_MON AS MON," ).append("\n"); 
		query.append("         FCAST_LOD_QTY  ," ).append("\n"); 
		query.append("         SHORTFALL      ," ).append("\n"); 
		query.append("         TO_CHAR(ROUND(RATIO, 2), 'FM99990.00') AS RATIO," ).append("\n"); 
		query.append("         LVL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT O.TRD_CD," ).append("\n"); 
		query.append("                   NVL(O.AQ_CD, 'G.TTL') AS AQ_CD," ).append("\n"); 
		query.append("                   DECODE(O.AQ_CD, NULL, 'G.TTL', NVL(O.OFC_CD, 'S.TTL')) AS OFC_CD," ).append("\n"); 
		query.append("                   NVL(O.COST_YR , 'TTL') AS COST_YR ," ).append("\n"); 
		query.append("                   NVL(O.COST_MON, 'TTL') AS COST_MON," ).append("\n"); 
		query.append("                   SUM(NVL(N.FCAST_LOD_QTY, 0)) AS FCAST_LOD_QTY," ).append("\n"); 
		query.append("                   SUM(NVL(N.SHORTFALL    , 0)) AS SHORTFALL    ," ).append("\n"); 
		query.append("                   DECODE(SUM(NVL(N.FCAST_LOD_QTY, 0)), 0, 0, SUM(NVL(N.SHORTFALL, 0)) / SUM(NVL(N.FCAST_LOD_QTY, 0)) * 100) AS RATIO," ).append("\n"); 
		query.append("                   DECODE(O.OFC_CD, NULL, DECODE(O.AQ_CD, NULL, 0, 1), 2) AS LVL" ).append("\n"); 
		query.append("              FROM MON_OFC   O," ).append("\n"); 
		query.append("                   NSHW_DATA N" ).append("\n"); 
		query.append("             WHERE N.OFC_CD  (+) = O.OFC_CD" ).append("\n"); 
		query.append("               AND N.COST_YR (+) = O.COST_YR" ).append("\n"); 
		query.append("               AND N.COST_MON(+) = O.COST_MON" ).append("\n"); 
		query.append("               AND N.TRD_CD  (+) = O.TRD_CD" ).append("\n"); 
		query.append("          GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("                                  (O.TRD_CD, O.AQ_CD, O.OFC_CD, O.COST_YR, O.COST_MON)," ).append("\n"); 
		query.append("                                  (O.TRD_CD, O.AQ_CD, O.COST_YR, O.COST_MON)," ).append("\n"); 
		query.append("                                  (O.TRD_CD, O.AQ_CD, O.OFC_CD)," ).append("\n"); 
		query.append("                                  (O.TRD_CD, O.AQ_CD)," ).append("\n"); 
		query.append("                                  (O.TRD_CD, O.COST_YR, O.COST_MON)," ).append("\n"); 
		query.append("                                  (O.TRD_CD)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("          ORDER BY O.TRD_CD," ).append("\n"); 
		query.append("                   DECODE(O.AQ_CD, 'DNC', '1', 'DSC', '2', 'DKJ', '3', 'DSA', '4', 'DPI', '5', '6')," ).append("\n"); 
		query.append("                   NVL(O.AQ_CD   , 'ZZZZZZ')," ).append("\n"); 
		query.append("                   NVL(O.OFC_CD  , 'ZZZZZ' )," ).append("\n"); 
		query.append("                   NVL(O.COST_YR , '0000'  ) DESC," ).append("\n"); 
		query.append("                   NVL(O.COST_MON, '00'    ) DESC" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}