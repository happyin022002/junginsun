/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * weekly simulation 의 과거 주차 조회
	  * </pre>
	  */
	public MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_ori_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("present_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("condition_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration").append("\n"); 
		query.append("FileName : MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN LOC_CD IS NULL THEN 'TOTAL'" ).append("\n"); 
		query.append("			ELSE LOC_CD||'('||LOC_GRP_CD||')' END  LOC_CD" ).append("\n"); 
		query.append("	  ,LOC_GRP_CD" ).append("\n"); 
		query.append("	  ,CODE" ).append("\n"); 
		query.append("  	  ,NAME" ).append("\n"); 
		query.append("	  ,SORT" ).append("\n"); 
		query.append("      ,CASE WHEN LOC_CD IS NULL THEN NULL" ).append("\n"); 
		query.append("			ELSE '+' END TREE" ).append("\n"); 
		query.append("#foreach( $key in ${arrweek})      " ).append("\n"); 
		query.append("      ,D2$key" ).append("\n"); 
		query.append("      ,D4$key" ).append("\n"); 
		query.append("      ,D5$key" ).append("\n"); 
		query.append("      ,D7$key" ).append("\n"); 
		query.append("      ,DTOTAL_$key" ).append("\n"); 
		query.append("      ,R2$key" ).append("\n"); 
		query.append("      ,R5$key" ).append("\n"); 
		query.append("      ,R9$key" ).append("\n"); 
		query.append("      ,O2$key" ).append("\n"); 
		query.append("      ,S2$key" ).append("\n"); 
		query.append("      ,O4$key" ).append("\n"); 
		query.append("      ,S2$key" ).append("\n"); 
		query.append("      ,F2$key" ).append("\n"); 
		query.append("      ,A2$key" ).append("\n"); 
		query.append("      ,F4$key" ).append("\n"); 
		query.append("      ,A4$key" ).append("\n"); 
		query.append("      ,F5$key" ).append("\n"); 
		query.append("      ,O5$key" ).append("\n"); 
		query.append("      ,STOTAL_$key" ).append("\n"); 
		query.append("      ,GTOTAL_$key" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("	  ,@[condition_value] ORI_LOC_CD" ).append("\n"); 
		query.append("	  ,@[ori_loc_cd] ORI_ORI_LOC_CD" ).append("\n"); 
		query.append("	  ,@[ori_ori_loc_cd] ORI_ORI_ORI_LOC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--RCC : ALL일때 표현 (RCC : ALL)" ).append("\n"); 
		query.append("#if ( ${condition_value} == '' && ${present_flag} == 'L')" ).append("\n"); 
		query.append("SELECT A.RCC_CD LOC_CD" ).append("\n"); 
		query.append("      ,'R' LOC_GRP_CD" ).append("\n"); 
		query.append("      ,A.CODE" ).append("\n"); 
		query.append("      ,A.NAME" ).append("\n"); 
		query.append("      ,A.SORT" ).append("\n"); 
		query.append("  #foreach( $key in ${arrweek})" ).append("\n"); 
		query.append("      ,SUM(A.GTOTAL_$key) GTOTAL_$key" ).append("\n"); 
		query.append("      ,SUM(A.DTOTAL_$key) DTOTAL_$key" ).append("\n"); 
		query.append("      ,SUM(A.STOTAL_$key) STOTAL_$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D2$key),0) D2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D4$key),0) D4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D5$key),0) D5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D7$key),0) D7$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R2$key),0) R2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R5$key),0) R5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R9$key),0) R9$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O2$key),0) O2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O4$key),0) O4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O5$key),0) O5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.S2$key),0) S2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.S4$key),0) S4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F2$key),0) F2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F4$key),0) F4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F5$key),0) F5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.A2$key),0) A2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.A4$key),0) A4$key  " ).append("\n"); 
		query.append("  #end      " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.LOC_CD" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT RCC_CD FROM MDM_EQ_ORZ_CHT X WHERE X.LCC_CD = B.LOC_CD) RCC_CD" ).append("\n"); 
		query.append("      ,B.LOC_GRP_CD" ).append("\n"); 
		query.append("      ,B.CODE" ).append("\n"); 
		query.append("      ,B.NAME" ).append("\n"); 
		query.append("      ,B.SORT" ).append("\n"); 
		query.append("#foreach( $key in ${arrweek})      " ).append("\n"); 
		query.append("      -- 가변쿼리" ).append("\n"); 
		query.append("      ,NVL(SUM(D2$key)+SUM(D4$key)+SUM(D5$key)+SUM(D7$key)+SUM(R2$key)+SUM(R5$key)+SUM(R9$key)+SUM(O2$key)+SUM(S2$key)+SUM(O4$key)+SUM(S4$key)+SUM(F2$key)+SUM(A2$key)+SUM(F4$key)+SUM(A4$key)+SUM(F5$key)+SUM(O5$key),0) GTOTAL_$key" ).append("\n"); 
		query.append("      ,NVL(SUM(D2$key)+SUM(D4$key)+SUM(D5$key)+SUM(D7$key),0) DTOTAL_$key" ).append("\n"); 
		query.append("      ,NVL(SUM(R2$key)+SUM(R5$key)+SUM(R9$key)+SUM(O2$key)+SUM(S2$key)+SUM(O4$key)+SUM(S4$key)+SUM(F2$key)+SUM(A2$key)+SUM(F4$key)+SUM(A4$key)+SUM(F5$key)+SUM(O5$key),0) STOTAL_$key         " ).append("\n"); 
		query.append("      ,NVL(SUM(A.D2$key),0) D2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D4$key),0) D4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D5$key),0) D5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.D7$key),0) D7$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R2$key),0) R2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R5$key),0) R5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.R9$key),0) R9$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O2$key),0) O2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O4$key),0) O4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.O5$key),0) O5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.S2$key),0) S2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.S4$key),0) S4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F2$key),0) F2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F4$key),0) F4$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.F5$key),0) F5$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.A2$key),0) A2$key" ).append("\n"); 
		query.append("      ,NVL(SUM(A.A4$key),0) A4$key    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("#foreach( $key in ${arrweek})          " ).append("\n"); 
		query.append("          -- 가변쿼리" ).append("\n"); 
		query.append("    #if(${period} == 'W')" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D2$key', A.CNTR_QTY),0)) D2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D4$key', A.CNTR_QTY),0)) D4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D5$key', A.CNTR_QTY),0)) D5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D7$key', A.CNTR_QTY),0)) D7$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R2$key', A.CNTR_QTY),0)) R2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R5$key', A.CNTR_QTY),0)) R5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R9$key', A.CNTR_QTY),0)) R9$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O2$key', A.CNTR_QTY),0)) O2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O4$key', A.CNTR_QTY),0)) O4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O5$key', A.CNTR_QTY),0)) O5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'S2$key', A.CNTR_QTY),0)) S2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'S4$key', A.CNTR_QTY),0)) S4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F2$key', A.CNTR_QTY),0)) F2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F4$key', A.CNTR_QTY),0)) F4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F5$key', A.CNTR_QTY),0)) F5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'A2$key', A.CNTR_QTY),0)) A2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'A4$key', A.CNTR_QTY),0)) A4$key" ).append("\n"); 
		query.append("    #elseif(${period} == 'M')" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D2$key', A.CNTR_QTY),0)) D2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D4$key', A.CNTR_QTY),0)) D4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D5$key', A.CNTR_QTY),0)) D5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D7$key', A.CNTR_QTY),0)) D7$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R2$key', A.CNTR_QTY),0)) R2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R5$key', A.CNTR_QTY),0)) R5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R9$key', A.CNTR_QTY),0)) R9$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O2$key', A.CNTR_QTY),0)) O2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O4$key', A.CNTR_QTY),0)) O4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O5$key', A.CNTR_QTY),0)) O5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'S2$key', A.CNTR_QTY),0)) S2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'S4$key', A.CNTR_QTY),0)) S4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F2$key', A.CNTR_QTY),0)) F2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F4$key', A.CNTR_QTY),0)) F4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F5$key', A.CNTR_QTY),0)) F5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'A2$key', A.CNTR_QTY),0)) A2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'A4$key', A.CNTR_QTY),0)) A4$key" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    #if(${period} == 'W')" ).append("\n"); 
		query.append("        SELECT A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("    #elseif(${period} == 'M')" ).append("\n"); 
		query.append("        SELECT C.PLN_YR||C.PLN_MON MONTH" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("              ,A.LOC_CD" ).append("\n"); 
		query.append("              ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("              ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("              ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CNTR_QTY     " ).append("\n"); 
		query.append("        FROM EQR_MTY_WKY_SIM A" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("             #if ( ${present_flag} == 'L') " ).append("\n"); 
		query.append("                 SELECT DISTINCT LCC_CD LOC_CD " ).append("\n"); 
		query.append("             #elseif( ${present_flag} == 'E' )" ).append("\n"); 
		query.append("                 SELECT DISTINCT ECC_CD LOC_CD" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("                 SELECT DISTINCT SCC_CD LOC_CD  " ).append("\n"); 
		query.append("             #end                 " ).append("\n"); 
		query.append("                 FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("                 WHERE RCC_CD IN ('CNSHA', 'CNHKG', 'TWTPE', 'KRSEL', 'JPTYO', 'SGSIN') -- 하드코딩" ).append("\n"); 
		query.append("                 AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if( ${condition_value} != '' ) -- RCC : ALL 일대는 쿼리 감춤" ).append("\n"); 
		query.append("             #if(${condition_flag} == 'R')" ).append("\n"); 
		query.append("        		 AND   RCC_CD = @[condition_value]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'L' )" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNSZP' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('CNCWN','CNSHU','CNYIT')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPTYO' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPTYO','JPYOK')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPOSA' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPOSA','JPUKB','JPNGO')" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                 AND   LCC_CD = @[condition_value]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'E')" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNCWN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'CNCWN'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRPUS' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRPUS'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRKAN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRKAN'" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("        		 AND   ECC_CD = @[condition_value]        " ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #else    --SCC" ).append("\n"); 
		query.append("        		 AND   SCC_CD = @[condition_value]    " ).append("\n"); 
		query.append("    		 #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("                 -- 지점 office 검색범위 (CDO_EQ, 지역본부 OFFICE 는 아래조건을 제거함)" ).append("\n"); 
		query.append("             #if( ${level_cd} == '3' ) " ).append("\n"); 
		query.append("                 AND LCC_CD IN (" ).append("\n"); 
		query.append("                                   SELECT LCC_CD" ).append("\n"); 
		query.append("                                   FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("                                   WHERE SCC_CD IN (                                     " ).append("\n"); 
		query.append("                                                       SELECT SCC_CD                      " ).append("\n"); 
		query.append("                                                       FROM MDM_LOCATION                  " ).append("\n"); 
		query.append("                                                       WHERE LOC_CD IN ( SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] )                            " ).append("\n"); 
		query.append("                                                   )      " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ) B" ).append("\n"); 
		query.append("            ,EQR_WK_PRD C" ).append("\n"); 
		query.append("        WHERE A.FCAST_YRWK = C.PLN_YR||C.PLN_WK  " ).append("\n"); 
		query.append("        AND   A.CFM_FLG    = 'Y'  -- 배치를 통해 저장이 완료" ).append("\n"); 
		query.append("        #if(${period} == 'W')   " ).append("\n"); 
		query.append("        -- WEEK 일때  " ).append("\n"); 
		query.append("        AND   C.PLN_YR||C.PLN_WK BETWEEN @[fmdate] AND @[todate] " ).append("\n"); 
		query.append("        #elseif(${period} == 'M')" ).append("\n"); 
		query.append("        -- MONTH 일때" ).append("\n"); 
		query.append("        AND   C.PLN_YR||C.PLN_MON BETWEEN @[fmdate] AND @[todate]   " ).append("\n"); 
		query.append("        #end             " ).append("\n"); 
		query.append("        AND   A.LOC_GRP_CD = @[present_flag] " ).append("\n"); 
		query.append("        AND   A.LOC_CD      = B.LOC_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    GROUP BY A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    -- BALANCE REPORT 계산      " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("          ,'BA' WKY_SIM_TP_CD" ).append("\n"); 
		query.append("#foreach( $key in ${arrweek})          " ).append("\n"); 
		query.append("          -- 가변쿼리" ).append("\n"); 
		query.append("    #if(${period} == 'W')" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'D7$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D7$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'R9$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R9$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'O5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'S2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) S2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'S4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) S4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'F5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'A2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) A2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.WEEK, 'A4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) A4$key" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif(${period} == 'M')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'D7$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) D7$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'R9$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) R9$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'O5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) O5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'S2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) S2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'S4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) S4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F4$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'F5$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) F5$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'A2$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) A2$key" ).append("\n"); 
		query.append("          ,SUM(NVL(DECODE(A.CNTR_TPSZ_CD||A.MONTH, 'A4$key', NVL(DECODE(A.WKY_SIM_TP_CD, 'IN', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'RI', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'OT', A.CNTR_QTY),0)+NVL(DECODE(A.WKY_SIM_TP_CD, 'IF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'OF', A.CNTR_QTY),0)-NVL(DECODE(A.WKY_SIM_TP_CD, 'RO', A.CNTR_QTY),0)  ),0)) A4$key" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    #if(${period} == 'W')" ).append("\n"); 
		query.append("        SELECT A.FCAST_YRWK WEEK" ).append("\n"); 
		query.append("    #elseif(${period} == 'M')" ).append("\n"); 
		query.append("        SELECT C.PLN_YR||C.PLN_MON MONTH" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("              ,A.LOC_CD" ).append("\n"); 
		query.append("              ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("              ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("              ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CNTR_QTY     " ).append("\n"); 
		query.append("        FROM EQR_MTY_WKY_SIM A" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("           #if ( ${present_flag} == 'L') " ).append("\n"); 
		query.append("                 SELECT DISTINCT LCC_CD LOC_CD " ).append("\n"); 
		query.append("           #elseif( ${present_flag} == 'E' )" ).append("\n"); 
		query.append("                 SELECT DISTINCT ECC_CD LOC_CD" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("                 SELECT DISTINCT SCC_CD LOC_CD  " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("                 WHERE RCC_CD IN ('CNSHA', 'CNHKG', 'TWTPE', 'KRSEL', 'JPTYO', 'SGSIN') -- 하드코딩" ).append("\n"); 
		query.append("                 AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if( ${condition_value} != '' ) -- RCC : ALL 일대는 쿼리 감춤" ).append("\n"); 
		query.append("             #if(${condition_flag} == 'R')" ).append("\n"); 
		query.append("        		 AND   RCC_CD = @[condition_value]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'L' )" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNSZP' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('CNCWN','CNSHU','CNYIT')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPTYO' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPTYO','JPYOK')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPOSA' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPOSA','JPUKB','JPNGO')" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                 AND   LCC_CD = @[condition_value]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'E')" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNCWN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'CNCWN'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRPUS' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRPUS'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRKAN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRKAN'" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("        		 AND   ECC_CD = @[condition_value]        " ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #else    --SCC" ).append("\n"); 
		query.append("        		 AND   SCC_CD = @[condition_value]    " ).append("\n"); 
		query.append("    		 #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 -- 지점 office 검색범위 (CDO_EQ, 지역본부 OFFICE 는 아래조건을 제거함)" ).append("\n"); 
		query.append("             #if( ${level_cd} == '3' ) " ).append("\n"); 
		query.append("                 AND LCC_CD IN (" ).append("\n"); 
		query.append("                                   SELECT LCC_CD" ).append("\n"); 
		query.append("                                   FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("                                   WHERE SCC_CD IN (                                     " ).append("\n"); 
		query.append("                                                       SELECT SCC_CD                      " ).append("\n"); 
		query.append("                                                       FROM MDM_LOCATION                  " ).append("\n"); 
		query.append("                                                       WHERE LOC_CD IN ( SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] )                            " ).append("\n"); 
		query.append("                                                   )      " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             ) B" ).append("\n"); 
		query.append("            ,EQR_WK_PRD C" ).append("\n"); 
		query.append("        WHERE A.FCAST_YRWK = C.PLN_YR||C.PLN_WK  " ).append("\n"); 
		query.append("        AND   A.CFM_FLG    = 'Y'  -- 배치를 통해 저장이 완료" ).append("\n"); 
		query.append("        #if(${period} == 'W')  " ).append("\n"); 
		query.append("        -- WEEK 일때  " ).append("\n"); 
		query.append("        AND   C.PLN_YR||C.PLN_WK BETWEEN @[fmdate] AND @[todate] " ).append("\n"); 
		query.append("        #elseif(${period} == 'M')" ).append("\n"); 
		query.append("        -- MONTH 일때" ).append("\n"); 
		query.append("        AND   C.PLN_YR||C.PLN_MON BETWEEN @[fmdate] AND @[todate]   " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("        AND   A.LOC_GRP_CD = @[present_flag] " ).append("\n"); 
		query.append("        AND   A.LOC_CD      = B.LOC_CD" ).append("\n"); 
		query.append("    ) A " ).append("\n"); 
		query.append("    GROUP BY A.LOC_CD" ).append("\n"); 
		query.append("          ,A.LOC_GRP_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT A.LOC_CD" ).append("\n"); 
		query.append("          ,B.CODE" ).append("\n"); 
		query.append("          ,B.NAME" ).append("\n"); 
		query.append("          ,B.SORT" ).append("\n"); 
		query.append("          ,@[present_flag] LOC_GRP_CD" ).append("\n"); 
		query.append("    FROM      " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      #if( ${present_flag} == 'L'  )  -- ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT LCC_CD LOC_CD" ).append("\n"); 
		query.append("      #elseif( ${present_flag} == 'E' )   " ).append("\n"); 
		query.append("        SELECT DISTINCT ECC_CD LOC_CD  " ).append("\n"); 
		query.append("      #else  --SCC일때" ).append("\n"); 
		query.append("        SELECT DISTINCT SCC_CD LOC_CD   " ).append("\n"); 
		query.append("      #end       " ).append("\n"); 
		query.append("        FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("        WHERE RCC_CD IN ('CNSHA', 'CNHKG', 'TWTPE', 'KRSEL', 'JPTYO', 'SGSIN') -- 하드코딩" ).append("\n"); 
		query.append("        AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("        -- 지점 office 검색범위 (CDO_EQ, 지역본부 OFFICE 는 아래조건을 제거함)" ).append("\n"); 
		query.append("      #if( ${level_cd} == '3' ) " ).append("\n"); 
		query.append("        AND LCC_CD IN (" ).append("\n"); 
		query.append("                         SELECT LCC_CD" ).append("\n"); 
		query.append("                         FROM MDM_EQ_ORZ_CHT                         " ).append("\n"); 
		query.append("                         WHERE SCC_CD IN (                                     " ).append("\n"); 
		query.append("                                             SELECT SCC_CD                      " ).append("\n"); 
		query.append("                                             FROM MDM_LOCATION                  " ).append("\n"); 
		query.append("                                             WHERE LOC_CD IN ( SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd] )                            " ).append("\n"); 
		query.append("                                          )      " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("      #end        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("           #if( ${condition_value} != '' ) -- RCC : ALL 일대는 쿼리 감춤" ).append("\n"); 
		query.append("             #if(${condition_flag} == 'R')" ).append("\n"); 
		query.append("        		 AND   RCC_CD = @[condition_value]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'L' )" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNSZP' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('CNCWN','CNSHU','CNYIT')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPTYO' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPTYO','JPYOK')" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'JPOSA' )" ).append("\n"); 
		query.append("                 AND   ECC_CD IN ('JPOSA','JPUKB','JPNGO')" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                 AND   LCC_CD = @[condition_value]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #elseif( ${condition_flag} == 'E')" ).append("\n"); 
		query.append("                 #if    ( ${condition_value} == 'CNCWN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'CNCWN'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRPUS' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRPUS'" ).append("\n"); 
		query.append("                 #elseif( ${condition_value} == 'KRKAN' )" ).append("\n"); 
		query.append("                 AND   SCC_CD = 'KRKAN'" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("        		 AND   ECC_CD = @[condition_value]        " ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		 #else    --SCC" ).append("\n"); 
		query.append("        		 AND   SCC_CD = @[condition_value]    " ).append("\n"); 
		query.append("    		 #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'IN' CODE, 'Inventory' NAME,       1 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'RI' CODE, 'Reposition In' NAME,   2 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'OT' CODE, 'Other(LT/ST/OW)' NAME, 3 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'IF' CODE, 'MG Forecast' NAME,     4 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'OF' CODE, 'OP Forecast' NAME,     5 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'RO' CODE, 'Reposition Out' NAME,  6 SORT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("        SELECT 'IC' CODE, 'IC' NAME,              7 SORT FROM DUAL UNION ALL  " ).append("\n"); 
		query.append("        SELECT 'BA' CODE, 'Balance' NAME,         8 SORT FROM DUAL          " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    ORDER BY LOC_CD,SORT" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.LOC_CD(+)        = B.LOC_CD" ).append("\n"); 
		query.append("AND   A.WKY_SIM_TP_CD(+) = B.CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- RCC : ALL일때 표현 (RCC : ALL)" ).append("\n"); 
		query.append("#if ( ${condition_value} == '' && ${present_flag} == 'L')  " ).append("\n"); 
		query.append("GROUP BY B.LOC_CD -- LOC CD 별 전체합" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY ROLLUP(B.LOC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,B.LOC_GRP_CD" ).append("\n"); 
		query.append("      ,B.CODE" ).append("\n"); 
		query.append("      ,B.NAME" ).append("\n"); 
		query.append("      ,B.SORT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- RCC : ALL일때 표현 (RCC : ALL)" ).append("\n"); 
		query.append("#if ( ${condition_value} == '' && ${present_flag} == 'L')        " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.RCC_CD) -- RCC CD 별 전체합" ).append("\n"); 
		query.append("        ,A.LOC_GRP_CD" ).append("\n"); 
		query.append("        ,A.CODE" ).append("\n"); 
		query.append("        ,A.NAME" ).append("\n"); 
		query.append("        ,A.SORT" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("        ,SORT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}