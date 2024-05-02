/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairExpensePFMCListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairExpensePFMCListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairExpensePFMCListData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairExpensePFMCListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("from_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairExpensePFMCListDataRSQL").append("\n"); 
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
		query.append("WITH OFC_LIST AS (SELECT DISTINCT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(PD.CTRL_OFC_CD) RHQ, PD.CTRL_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                    FROM MNR_PLN_DTL PD, MNR_PLN_HDR PH" ).append("\n"); 
		query.append("                   WHERE PH.MNR_PLN_SEQ = PD.MNR_PLN_SEQ" ).append("\n"); 
		query.append("                     AND PH.MNR_PLN_YR BETWEEN SUBSTR(REPLACE(@[from_mon], '-', ''), 3, 6) " ).append("\n"); 
		query.append("                                           AND SUBSTR(REPLACE(@[to_mon], '-', ''), 3, 6)" ).append("\n"); 
		query.append("                     AND PH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                     AND PH.MNR_PLN_FLG = 'Y'" ).append("\n"); 
		query.append("                     AND PD.OFC_TP_CD = 'BB'" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                     AND PD.CTRL_OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("#if (${report_type} == 'BI') " ).append("\n"); 
		query.append("                  SELECT DISTINCT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD) RHQ, MIW.ISS_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                    FROM MNR_ORD_DTL OD, MNR_PAY_INV_WRK MIW" ).append("\n"); 
		query.append("                   WHERE OD.PAY_INV_SEQ = MIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("                     AND MIW.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(REPLACE(@[from_mon], '-', '') ||'01', 'YYYYMMDD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("                                        AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], LAST_DAY(TO_DATE(REPLACE(@[to_mon], '-', ''), 'YYYYMM')) + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                     AND MIW.ISS_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                  SELECT DISTINCT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD) RHQ, OH.COST_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                    FROM MNR_ORD_DTL OD, MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                   WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                     AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                     AND OH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(REPLACE(@[from_mon], '-', '') ||'01', 'YYYYMMDD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("                                       AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], LAST_DAY(TO_DATE(REPLACE(@[to_mon], '-', ''), 'YYYYMM')) + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                     AND OH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end                           " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("SELECT RHQ,    " ).append("\n"); 
		query.append("   OFC_CD,                     " ).append("\n"); 
		query.append("	       CURR_CD,    " ).append("\n"); 
		query.append("	       PLN_511511,    " ).append("\n"); 
		query.append("	       PFMC_511511,    " ).append("\n"); 
		query.append("	       PLN_511521,    " ).append("\n"); 
		query.append("	       PFMC_511521,    " ).append("\n"); 
		query.append("	       PLN_511531,    " ).append("\n"); 
		query.append("	       PFMC_511531,    " ).append("\n"); 
		query.append("	       PLN_511541,    " ).append("\n"); 
		query.append("	       PFMC_511541,    " ).append("\n"); 
		query.append("	       PLN_511551,    " ).append("\n"); 
		query.append("	       PFMC_511551,    " ).append("\n"); 
		query.append("	       PLN_511561,    " ).append("\n"); 
		query.append("	       PFMC_511561    " ).append("\n"); 
		query.append("	       FROM (    		" ).append("\n"); 
		query.append("				  SELECT CASE WHEN  GROUPING(RHQ) = 1 AND GROUPING(OFC_CD) = 1 THEN 'G.TOTAL' WHEN GROUPING(RHQ) = 1 THEN 'G.TTL' ELSE RHQ    END AS RHQ     " ).append("\n"); 
		query.append("				  	        , CASE WHEN  GROUPING(RHQ) = 1 AND GROUPING(OFC_CD) = 1 THEN  NULL   WHEN GROUPING(OFC_CD) = 1 THEN 'S.TTL' ELSE OFC_CD END AS OFC_CD          " ).append("\n"); 
		query.append("				  	        , MAX(CURR_CD) CURR_CD,    " ).append("\n"); 
		query.append("				  	        SUM(PLN_511511) PLN_511511,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511511) PFMC_511511,    " ).append("\n"); 
		query.append("				  	       SUM(PLN_511521) PLN_511521,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511521) PFMC_511521,    " ).append("\n"); 
		query.append("				  	       SUM(PLN_511531) PLN_511531,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511531) PFMC_511531,    " ).append("\n"); 
		query.append("				  	       SUM(PLN_511541) PLN_511541,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511541) PFMC_511541,    " ).append("\n"); 
		query.append("				  	       SUM(PLN_511551) PLN_511551,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511551) PFMC_511551,    " ).append("\n"); 
		query.append("				  	       SUM(PLN_511561) PLN_511561,    " ).append("\n"); 
		query.append("				  	       SUM(PFMC_511561) PFMC_511561    " ).append("\n"); 
		query.append("				  	FROM (" ).append("\n"); 
		query.append("                                SELECT OFC_LIST.RHQ RHQ," ).append("\n"); 
		query.append("                                       OFC_LIST.OFC_CD OFC_CD," ).append("\n"); 
		query.append("                                       'USD' CURR_CD," ).append("\n"); 
		query.append("                                       BUDGET.A AS PLN_511511," ).append("\n"); 
		query.append("                                       PFMC.A   AS PFMC_511511," ).append("\n"); 
		query.append("                                       BUDGET.B AS PLN_511521," ).append("\n"); 
		query.append("                                       PFMC.B   AS PFMC_511521," ).append("\n"); 
		query.append("                                       BUDGET.C AS PLN_511531," ).append("\n"); 
		query.append("                                       PFMC.C   AS PFMC_511531," ).append("\n"); 
		query.append("                                       BUDGET.D AS PLN_511541," ).append("\n"); 
		query.append("                                       PFMC.D   AS PFMC_511541," ).append("\n"); 
		query.append("                                       BUDGET.E AS PLN_511551," ).append("\n"); 
		query.append("                                       PFMC.E   AS PFMC_511551," ).append("\n"); 
		query.append("                                       BUDGET.F AS PLN_511561," ).append("\n"); 
		query.append("                                       PFMC.F   AS PFMC_511561" ).append("\n"); 
		query.append("                                  FROM (SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(PD.CTRL_OFC_CD) RHQ, PD.CTRL_OFC_CD OFC_CD," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511511', PD.MNR_PLN_AMT, 0)), 0) A," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511521', PD.MNR_PLN_AMT, 0)), 0) B," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511531', PD.MNR_PLN_AMT, 0)), 0) C," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511541', PD.MNR_PLN_AMT, 0)), 0) D," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511551', PD.MNR_PLN_AMT, 0)), 0) E," ).append("\n"); 
		query.append("                                               NVL(SUM(DECODE(PD.ACCT_CD, '511561', PD.MNR_PLN_AMT, 0)), 0) F" ).append("\n"); 
		query.append("                                          FROM MNR_PLN_DTL PD, MNR_PLN_HDR PH" ).append("\n"); 
		query.append("                                         WHERE PH.MNR_PLN_SEQ = PD.MNR_PLN_SEQ" ).append("\n"); 
		query.append("                                           AND PH.MNR_PLN_YR BETWEEN SUBSTR(REPLACE(@[from_mon], '-', ''), 3, 6) " ).append("\n"); 
		query.append("                                                                 AND SUBSTR(REPLACE(@[to_mon], '-', ''), 3, 6)" ).append("\n"); 
		query.append("                                #if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                                           AND PD.CTRL_OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                           AND PH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                                           AND PH.MNR_PLN_FLG = 'Y'" ).append("\n"); 
		query.append("                                           AND PD.OFC_TP_CD = 'BB'" ).append("\n"); 
		query.append("                                      GROUP BY MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(PD.CTRL_OFC_CD), PD.CTRL_OFC_CD) BUDGET, " ).append("\n"); 
		query.append("                                #if (${report_type} == 'BI') " ).append("\n"); 
		query.append("                                       (SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD) RHQ, MIW.ISS_OFC_CD OFC_CD," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511511', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) A," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511521', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) B," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511531', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) C," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511541', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) D," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511551', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) E," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511561', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, 'USD', NVL(OD.INV_AMT, 0)), 0)) F" ).append("\n"); 
		query.append("                                          FROM MNR_ORD_DTL OD, MNR_PAY_INV_WRK MIW" ).append("\n"); 
		query.append("                                         WHERE OD.PAY_INV_SEQ = MIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("                                           AND MIW.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(REPLACE(@[from_mon], '-', '') ||'01', 'YYYYMMDD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("                                                              AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], LAST_DAY(TO_DATE(REPLACE(@[to_mon], '-', ''), 'YYYYMM')) + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("                                #if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                                           AND MIW.ISS_OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                      GROUP BY MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD), MIW.ISS_OFC_CD" ).append("\n"); 
		query.append("                                        #else " ).append("\n"); 
		query.append("                                       (SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD) RHQ, OH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511511', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) A, " ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511521', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) B, " ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511531', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) C, " ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511541', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) D, " ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511551', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) E, " ).append("\n"); 
		query.append("                                               SUM(DECODE(OD.ACCT_CD, '511561', MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OD.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', NVL(OD.COST_AMT, 0)), 0)) F" ).append("\n"); 
		query.append("                                          FROM MNR_ORD_DTL OD, MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                                         WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                                           AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                                           AND OH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(REPLACE(@[from_mon], '-', '') ||'01', 'YYYYMMDD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("                                                             AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], LAST_DAY(TO_DATE(REPLACE(@[to_mon], '-', ''), 'YYYYMM')) + 0.99999, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("                                #if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("                                           AND OH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                      GROUP BY MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD), OH.COST_OFC_CD" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                                      ) PFMC," ).append("\n"); 
		query.append("                                      OFC_LIST" ).append("\n"); 
		query.append("                                 WHERE BUDGET.OFC_CD(+) = OFC_LIST.OFC_CD" ).append("\n"); 
		query.append("                                   AND PFMC.OFC_CD(+) = OFC_LIST.OFC_CD" ).append("\n"); 
		query.append("                                #if (${rhq} != 'A')" ).append("\n"); 
		query.append("                                   AND OFC_LIST.RHQ = DECODE(@[rhq], 'SELCON', 'SELHO', @[rhq])" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("								)	" ).append("\n"); 
		query.append("					GROUP BY GROUPING SETS ((RHQ), (RHQ,OFC_CD), ())	" ).append("\n"); 
		query.append("					ORDER BY DECODE(RHQ, 'SELHO', 0, 'G.TOTAL',2,1), RHQ, DECODE(OFC_CD, 'S.TTL', 1, 0)	" ).append("\n"); 
		query.append("					)	" ).append("\n"); 
		query.append("	where RHQ <> 'SELHO' or OFC_CD <> 'S.TTL'" ).append("\n"); 

	}
}