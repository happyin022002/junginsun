/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.04.02 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOccurrenceAnalysisByCargo
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByCargoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdbtn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.integration").append("\n"); 
		query.append("FileName : ContainerCargoClaimReportDBDAOSearchOccurrenceAnalysisByCargoRSQL").append("\n"); 
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
		query.append("  REPORT_BY_CD   CARGO_REPORT_BY_CD" ).append("\n"); 
		query.append("  , REPORT_BY_NM   CARGO_REPORT_BY_NM" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , CARGO_CASE0" ).append("\n"); 
		query.append("  , CARGO_PCT_CASE0 ||'%' CARGO_PCT_CASE0" ).append("\n"); 
		query.append("  , CARGO_AMT0" ).append("\n"); 
		query.append("  , CARGO_PCT_AMT0 ||'%' CARGO_PCT_AMT0" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , CARGO_CASE1" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_CASE0, 0, 0, (CARGO_CASE1 / CARGO_CASE0) * 100), 2) ||'%' CARGO_PCT_CASE1" ).append("\n"); 
		query.append("  , CARGO_AMT1" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_AMT0, 0, 0, (CARGO_AMT1 / CARGO_AMT0) * 100), 2) ||'%' CARGO_PCT_AMT1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , CARGO_CASE2" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_CASE0, 0, 0, (CARGO_CASE2 / CARGO_CASE0) * 100), 2) ||'%' CARGO_PCT_CASE2" ).append("\n"); 
		query.append("  , CARGO_AMT2" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_AMT0, 0, 0, (CARGO_AMT2 / CARGO_AMT0) * 100), 2) ||'%' CARGO_PCT_AMT2" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , CARGO_CASE3" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_CASE0, 0, 0, (CARGO_CASE3 / CARGO_CASE0) * 100), 2) ||'%' CARGO_PCT_CASE3" ).append("\n"); 
		query.append("  , CARGO_AMT3" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_AMT0, 0, 0, (CARGO_AMT3 / CARGO_AMT0) * 100), 2) ||'%' CARGO_PCT_AMT3" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , CARGO_CASE4" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_CASE0, 0, 0, (CARGO_CASE4 / CARGO_CASE0) * 100), 2) ||'%' CARGO_PCT_CASE4" ).append("\n"); 
		query.append("  , CARGO_AMT4" ).append("\n"); 
		query.append("  , ROUND (DECODE (CARGO_AMT0, 0, 0, (CARGO_AMT4 / CARGO_AMT0) * 100), 2) ||'%' CARGO_PCT_AMT4" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            REPORT_BY_CD" ).append("\n"); 
		query.append("          ,REPORT_BY_NM" ).append("\n"); 
		query.append("          , NVL (CASE0, 0)                      AS CARGO_CASE0" ).append("\n"); 
		query.append("          , 100                                   AS CARGO_PCT_CASE0" ).append("\n"); 
		query.append("          , NVL (AMT0, 0)                       AS CARGO_AMT0" ).append("\n"); 
		query.append("          , 100                                   AS CARGO_PCT_AMT0" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE1, 0)                      AS CARGO_CASE1" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_CASE1" ).append("\n"); 
		query.append("          , NVL (AMT1, 0)                       AS CARGO_AMT1" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_AMT1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE2, 0)                      AS CARGO_CASE2" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_CASE2" ).append("\n"); 
		query.append("          , NVL (AMT2, 0)                       AS CARGO_AMT2" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_AMT2" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE3, 0)                      AS CARGO_CASE3" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_CASE3" ).append("\n"); 
		query.append("          , NVL (AMT3, 0)                       AS CARGO_AMT3" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_AMT3" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , NVL (CASE4, 0)                      AS CARGO_CASE4" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_CASE4" ).append("\n"); 
		query.append("          , NVL (AMT4, 0)                       AS CARGO_AMT4" ).append("\n"); 
		query.append("          , 0                                   AS CARGO_PCT_AMT4" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                   #if(${rdbtn}=='0')" ).append("\n"); 
		query.append("			         AREA_POL AS REPORT_BY_CD" ).append("\n"); 
		query.append("			       #end" ).append("\n"); 
		query.append("			       #if(${rdbtn}=='1')" ).append("\n"); 
		query.append("			         AREA_POR AS REPORT_BY_CD" ).append("\n"); 
		query.append("			       #end" ).append("\n"); 
		query.append("		       " ).append("\n"); 
		query.append("		      " ).append("\n"); 
		query.append("			  , MAX(( SELECT CLM_MISC_NM FROM CNI_MISC_CD WHERE CLSS_CLM_MISC_CD = '09' AND CLM_MISC_CD =  DECODE(@[rdbtn], '0', AREA_POL,'1', AREA_POR)))  AS REPORT_BY_NM" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					  , COUNT(CGO_CLM_NO)        AS CASE0" ).append("\n"); 
		query.append("			  , SUM(CLMT_USD_AMT)        AS AMT0" ).append("\n"); 
		query.append("			  , COUNT(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'A', CGO_CLM_NO))    AS CASE1                  " ).append("\n"); 
		query.append("					  , SUM(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'A', CLMT_USD_AMT))   AS AMT1 " ).append("\n"); 
		query.append("					  , COUNT(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'E', CGO_CLM_NO))    AS CASE2  " ).append("\n"); 
		query.append("					  , SUM(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'E', CLMT_USD_AMT))    AS AMT2 " ).append("\n"); 
		query.append("			  , COUNT(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'S', CGO_CLM_NO))    AS CASE3                  " ).append("\n"); 
		query.append("					  , SUM(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'S', CLMT_USD_AMT))    AS AMT3 " ).append("\n"); 
		query.append("			  , COUNT(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'C', CGO_CLM_NO))    AS CASE4                  " ).append("\n"); 
		query.append("					  , SUM(DECODE(DECODE(@[rdbtn],'0', AREA_POD " ).append("\n"); 
		query.append("						   ,'1', AREA_DEL  ), 'C', CLMT_USD_AMT))    AS AMT4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						,AREA_POL  AS AREA_POL " ).append("\n"); 
		query.append("						,AREA_POR  AS AREA_POR" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("                    SELECT CLM_V.CGO_CLM_NO" ).append("\n"); 
		query.append("                          ,CLM_V.CLMT_USD_AMT" ).append("\n"); 
		query.append("                          ,( SELECT DECODE(B.SCONTI_CD,'AO','S','AF','C','AW','S','AE','S','AM','S','EE','E','EC','E','ES','E','EN','E','FN','E','FS','E','FC','E','FE','E','FW','E','MS','A','MC','A','MN','A')" ).append("\n"); 
		query.append("                               FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                                   ,MDM_COUNTRY B" ).append("\n"); 
		query.append("                              WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("                                AND A.LOC_CD = CLM_V.POL_CD" ).append("\n"); 
		query.append("                            ) AS AREA_POL" ).append("\n"); 
		query.append("                          ,( SELECT DECODE(B.SCONTI_CD,'AO','S','AF','C','AW','S','AE','S','AM','S','EE','E','EC','E','ES','E','EN','E','FN','E','FS','E','FC','E','FE','E','FW','E','MS','A','MC','A','MN','A')" ).append("\n"); 
		query.append("                               FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                                   ,MDM_COUNTRY B" ).append("\n"); 
		query.append("                              WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("                                AND A.LOC_CD = CLM_V.POD_CD" ).append("\n"); 
		query.append("                            ) AS AREA_POD" ).append("\n"); 
		query.append("                          ,( SELECT DECODE(B.SCONTI_CD,'AO','S','AF','C','AW','S','AE','S','AM','S','EE','E','EC','E','ES','E','EN','E','FN','E','FS','E','FC','E','FE','E','FW','E','MS','A','MC','A','MN','A')" ).append("\n"); 
		query.append("                               FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                                   ,MDM_COUNTRY B" ).append("\n"); 
		query.append("                              WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("                                AND A.LOC_CD = CLM_V.POR_CD" ).append("\n"); 
		query.append("                            ) AS AREA_POR" ).append("\n"); 
		query.append("                          ,( SELECT DECODE(B.SCONTI_CD,'AO','S','AF','C','AW','S','AE','S','AM','S','EE','E','EC','E','ES','E','EN','E','FN','E','FS','E','FC','E','FE','E','FW','E','MS','A','MC','A','MN','A')" ).append("\n"); 
		query.append("                               FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                                   ,MDM_COUNTRY B" ).append("\n"); 
		query.append("                              WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("                                AND A.LOC_CD = CLM_V.DEL_CD" ).append("\n"); 
		query.append("                            ) AS AREA_DEL" ).append("\n"); 
		query.append("                            ,CLM_V.UPD_DT" ).append("\n"); 
		query.append("                            ,CLM_V.INCI_OCCR_DT" ).append("\n"); 
		query.append("                            ,CLM_V.SVEY_INP_DT" ).append("\n"); 
		query.append("                            ,CLM_V.PRLM_CLM_NTC_DT" ).append("\n"); 
		query.append("                            ,CLM_V.CLM_TM_BAR_DT" ).append("\n"); 
		query.append("                            ,CLM_V.LABL_TM_BAR_DT" ).append("\n"); 
		query.append("                            ,CLM_V.FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("                            ,CLM_V.FACT_FND_DT" ).append("\n"); 
		query.append("                            ,CLM_V.SMNS_SVE_DT" ).append("\n"); 
		query.append("                            ,CLM_V.CGO_CLM_STL_DT" ).append("\n"); 
		query.append("                            ,CLM_V.LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("                            ,CLM_V.INSUR_RCVR_DT" ).append("\n"); 
		query.append("                            ,CLM_V.RCT_DT" ).append("\n"); 
		query.append("                            ,CLM_V.LODG_DT" ).append("\n"); 
		query.append("                            ,CLM_V.DCHG_DT" ).append("\n"); 
		query.append("                            ,CLM_V.DE_DT                      " ).append("\n"); 
		query.append("                      FROM CNI_CLM_V CLM_V " ).append("\n"); 
		query.append("                      WHERE 0=0" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD') BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.INCI_OCCR_DT BETWEEN @[from_period]  AND @[to_period]  -- 나중확인" ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.SVEY_INP_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end " ).append("\n"); 
		query.append("        			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.PRLM_CLM_NTC_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.CLM_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.LABL_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.FMAL_CLM_RCV_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.FACT_FND_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.SMNS_SVE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.CGO_CLM_STL_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.LABL_PTY_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.INSUR_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.RCT_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.LODG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.DCHG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end" ).append("\n"); 
		query.append("        			  #if(${period} == 'DEL' && ${from_period} != '')" ).append("\n"); 
		query.append("        			      AND CLM_V.DE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("        			  #end                      " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rdbtn}=='0')" ).append("\n"); 
		query.append("GROUP BY  AREA_POL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rdbtn}=='1')" ).append("\n"); 
		query.append("GROUP BY  AREA_POR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}