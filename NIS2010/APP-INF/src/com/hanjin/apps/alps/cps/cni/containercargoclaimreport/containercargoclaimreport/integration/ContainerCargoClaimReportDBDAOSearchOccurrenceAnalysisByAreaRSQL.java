/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByAreaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByAreaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOccurrenceAnalysisByArea
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByAreaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("report_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_period",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_period",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.integration").append("\n"); 
		query.append("FileName : ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByAreaRSQL").append("\n"); 
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
		query.append("  " ).append("\n"); 
		query.append("  REPORT_BY_CD   AREA_REPORT_BY_CD" ).append("\n"); 
		query.append("  , REPORT_BY_NM   AREA_REPORT_BY_NM" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE0" ).append("\n"); 
		query.append("  , AREA_PCT_CASE0 ||'%' AREA_PCT_CASE0" ).append("\n"); 
		query.append("  , AREA_AMT0" ).append("\n"); 
		query.append("  , AREA_PCT_AMT0 ||'%' AREA_PCT_AMT0" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE1" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE1 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE1" ).append("\n"); 
		query.append("  , AREA_AMT1" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT1 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE2" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE2 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE2" ).append("\n"); 
		query.append("  , AREA_AMT2" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT2 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT2" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE3" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE3 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE3" ).append("\n"); 
		query.append("  , AREA_AMT3" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT3 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT3" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE4" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE4 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE4" ).append("\n"); 
		query.append("  , AREA_AMT4" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT4 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT4" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE5" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE5 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE5" ).append("\n"); 
		query.append("  , AREA_AMT5" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT5 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT5" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , AREA_CASE6" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE6 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE6" ).append("\n"); 
		query.append("  , AREA_AMT6" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT6 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , AREA_CASE7" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_CASE0, 0, 0, (AREA_CASE7 / AREA_CASE0) * 100), 2) ||'%' AREA_PCT_CASE7" ).append("\n"); 
		query.append("  , AREA_AMT7" ).append("\n"); 
		query.append("  , ROUND (DECODE (AREA_AMT0, 0, 0, (AREA_AMT7 / AREA_AMT0) * 100), 2) ||'%' AREA_PCT_AMT7" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            REPORT_BY_CD" ).append("\n"); 
		query.append("          , REPORT_BY_NM       " ).append("\n"); 
		query.append("          , NVL (CASE0, 0)                      AS AREA_CASE0" ).append("\n"); 
		query.append("          , 100                                   AS AREA_PCT_CASE0" ).append("\n"); 
		query.append("          , NVL (AMT0, 0)                       AS AREA_AMT0" ).append("\n"); 
		query.append("          , 100                                   AS AREA_PCT_AMT0" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE1, 0)                      AS AREA_CASE1" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE1" ).append("\n"); 
		query.append("          , NVL (AMT1, 0)                       AS AREA_AMT1" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE2, 0)                      AS AREA_CASE2" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE2" ).append("\n"); 
		query.append("          , NVL (AMT2, 0)                       AS AREA_AMT2" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT2" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE3, 0)                      AS AREA_CASE3" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE3" ).append("\n"); 
		query.append("          , NVL (AMT3, 0)                       AS AREA_AMT3" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT3" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE4, 0)                      AS AREA_CASE4" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE4" ).append("\n"); 
		query.append("          , NVL (AMT4, 0)                       AS AREA_AMT4" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT4" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("          , NVL (CASE5, 0)                      AS AREA_CASE5" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE5" ).append("\n"); 
		query.append("          , NVL (AMT5, 0)                       AS AREA_AMT5" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT5" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("          , NVL (CASE6, 0)                      AS AREA_CASE6" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE6" ).append("\n"); 
		query.append("          , NVL (AMT6, 0)                       AS AREA_AMT6" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT6" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("          , NVL (CASE7, 0)                      AS AREA_CASE7" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_CASE7" ).append("\n"); 
		query.append("          , NVL (AMT7, 0)                       AS AREA_AMT7" ).append("\n"); 
		query.append("          , 0                                   AS AREA_PCT_AMT7            " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    CLM_AREA_CD      AS REPORT_BY_CD" ).append("\n"); 
		query.append("                  , MISC.CLM_MISC_NM AS REPORT_BY_NM" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  , COUNT (CGO_CLM_NO)        AS CASE0" ).append("\n"); 
		query.append("                  , SUM (CLMT_USD_AMT)        AS AMT0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'CON', CGO_CLM_NO))    AS CASE1                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'CON', CLMT_USD_AMT))   		  AS AMT1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'PHY', CGO_CLM_NO))    AS CASE2                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'PHY', CLMT_USD_AMT))   		  AS AMT2  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'WET', CGO_CLM_NO))    AS CASE3                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'WET', CLMT_USD_AMT))   		  AS AMT3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'STG', CGO_CLM_NO))    AS CASE4                 " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'STG', CLMT_USD_AMT))   		  AS AMT4  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'NDL', CGO_CLM_NO))    AS CASE5                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'NDL', CLMT_USD_AMT))   		  AS AMT5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'RDL', CGO_CLM_NO))    AS CASE6                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'RDL', CLMT_USD_AMT))   		  AS AMT6     " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_TP_CD, 'OTR', CGO_CLM_NO))    AS CASE7                  " ).append("\n"); 
		query.append("				  , SUM (DECODE (CGO_CLM_TP_CD, 'OTR', CLMT_USD_AMT))   		  AS AMT7    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CLM_V CLM_V" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = @[report_by]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    MISC" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                WHERE CLM_AREA_CD      = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CLM_AREA_CD IS NOT NULL" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		 	  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("		          AND TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD') BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("		      #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.INCI_OCCR_DT BETWEEN @[from_period]  AND @[to_period]  " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.SVEY_INP_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.PRLM_CLM_NTC_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLM_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LABL_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.FMAL_CLM_RCV_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.FACT_FND_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.SMNS_SVE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LABL_PTY_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.INSUR_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.RCT_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LODG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.DCHG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DEL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.DE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    CLM_AREA_CD" ).append("\n"); 
		query.append("                  , MISC.CLM_MISC_NM   " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                ORDER  BY CLM_MISC_NM        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}