/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOSearchVslLayupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchVslLayupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MNL_DTL_COST 테이블 조회
	  * </pre>
	  */
	public CostSetUpDBDAOSearchVslLayupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchVslLayupListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("    ,COST_WK" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,VSL_CD_TTL" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,STND_COST_CD" ).append("\n"); 
		query.append("    ,STND_COST_NM" ).append("\n"); 
		query.append("    ,SUM(SUN_COST_AMT) AS SUN_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(MON_COST_AMT) AS MON_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(TUE_COST_AMT) AS TUE_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(WED_COST_AMT) AS WED_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(THU_COST_AMT) AS THU_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(FRI_COST_AMT) AS FRI_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(SAT_COST_AMT) AS SAT_COST_AMT" ).append("\n"); 
		query.append("    ,SUM(TTL_AMT) AS TTL_AMT" ).append("\n"); 
		query.append("    ,MIN(DP_SEQ) AS DP_SEQ" ).append("\n"); 
		query.append("    ,MERGE_CD" ).append("\n"); 
		query.append("    ,ROW_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT (SUBSTR(COST_YRMON,1,4)||COST_WK) AS COST_YRMON" ).append("\n"); 
		query.append("    	,COST_WK" ).append("\n"); 
		query.append("    	,RLANE_CD" ).append("\n"); 
		query.append("    	,'' AS VSL_CD_TTL" ).append("\n"); 
		query.append("    	,VSL_CD" ).append("\n"); 
		query.append("    	,STND_COST_CD" ).append("\n"); 
		query.append("	#if (${rlane_cd} == 'CDMCO')" ).append("\n"); 
		query.append("    	,(CASE WHEN STND_COST_CD='43101011' THEN 'Vessel Charter Revenue'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='53101000' THEN 'Port EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='53102000' THEN 'Canal Transit Fee'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='53200000' THEN 'Bunker'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54100000' THEN 'Crew EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54250000' THEN 'Insurance'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54300000' THEN 'Lubricant EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54200000' THEN 'Store Supply EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54150000' THEN 'Vessel M&R'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54450000' THEN 'Depreciations'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54180000' THEN 'Telecom ExP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54550000' THEN 'Other Operation Fixed Exp'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54350000' THEN 'Time Charterage'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54400000' THEN 'Space Charterage'" ).append("\n"); 
		query.append("     	END ) AS STND_COST_NM" ).append("\n"); 
		query.append("	#elseif (${rlane_cd} == 'CNTLY')" ).append("\n"); 
		query.append("    	,(CASE WHEN STND_COST_CD='53101000' THEN 'Port EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='53102000' THEN 'Canal Transit Fee'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='53200000' THEN 'Bunker'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54100000' THEN 'Crew EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54250000' THEN 'Insurance'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54300000' THEN 'Lubricant EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54200000' THEN 'Store Supply EXP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54150000' THEN 'Vessel M&R'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54450000' THEN 'Depreciations'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54180000' THEN 'Telecom ExP'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54550000' THEN 'Other Operation Fixed Exp'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54350000' THEN 'Time Charterage'" ).append("\n"); 
		query.append("        	WHEN STND_COST_CD='54400000' THEN 'Space Charterage'" ).append("\n"); 
		query.append("     	END ) AS STND_COST_NM" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    	,SUN_COST_AMT" ).append("\n"); 
		query.append("    	,MON_COST_AMT" ).append("\n"); 
		query.append("    	,TUE_COST_AMT" ).append("\n"); 
		query.append("    	,WED_COST_AMT" ).append("\n"); 
		query.append("    	,THU_COST_AMT" ).append("\n"); 
		query.append("    	,FRI_COST_AMT" ).append("\n"); 
		query.append("    	,SAT_COST_AMT" ).append("\n"); 
		query.append("    	,TTL_AMT" ).append("\n"); 
		query.append("    	,DP_SEQ" ).append("\n"); 
		query.append("		,VSL_CD AS MERGE_CD" ).append("\n"); 
		query.append("		,'1' AS ROW_SEQ" ).append("\n"); 
		query.append("	FROM COA_MNL_DTL_COST" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("		AND COST_YRMON LIKE SUBSTR(REPLACE(@[f_yearweek],'-',''),1,4)||'%'" ).append("\n"); 
		query.append("		AND COST_WK = SUBSTR(REPLACE(@[f_yearweek],'-',''),5,2)" ).append("\n"); 
		query.append("    	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY COST_YRMON, COST_WK, RLANE_CD, VSL_CD, STND_COST_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ' ' AS COST_YRMON" ).append("\n"); 
		query.append("    ,' ' AS COST_WK" ).append("\n"); 
		query.append("    ,' ' AS RLANE_CD" ).append("\n"); 
		query.append("    ,DECODE(RLANE_CD,'CDMCO', 'VSL Charter', 'Lay Up Expense') AS VSL_CD_TTL" ).append("\n"); 
		query.append("	,'TTL' AS VSL_CD" ).append("\n"); 
		query.append("    ,STND_COST_CD" ).append("\n"); 
		query.append("#if (${rlane_cd} == 'CDMCO')" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD='43101011' THEN 'Vessel Charter Revenue'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='53101000' THEN 'Port EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='53102000' THEN 'Canal Transit Fee'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='53200000' THEN 'Bunker'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54100000' THEN 'Crew EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54250000' THEN 'Insurance'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54300000' THEN 'Lubricant EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54200000' THEN 'Store Supply EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54150000' THEN 'Vessel M&R'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54450000' THEN 'Depreciations'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54180000' THEN 'Telecom ExP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54550000' THEN 'Other Operation Fixed Exp'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54350000' THEN 'Time Charterage'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54400000' THEN 'Space Charterage'" ).append("\n"); 
		query.append("     END ) AS STND_COST_NM" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(SUN_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(SUN_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS SUN_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(MON_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(MON_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS MON_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(TUE_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(TUE_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS TUE_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(WED_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(WED_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS WED_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(THU_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(THU_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS THU_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(FRI_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(FRI_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS FRI_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(SAT_COST_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(SAT_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS SAT_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '43101011' THEN SUM(TTL_AMT) " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53101000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(TTL_AMT) " ).append("\n"); 
		query.append("    END ) AS TTL_AMT" ).append("\n"); 
		query.append("#elseif (${rlane_cd} == 'CNTLY')" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD='53101000' THEN 'Port EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='53102000' THEN 'Canal Transit Fee'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='53200000' THEN 'Bunker'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54100000' THEN 'Crew EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54250000' THEN 'Insurance'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54300000' THEN 'Lubricant EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54200000' THEN 'Store Supply EXP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54150000' THEN 'Vessel M&R'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54450000' THEN 'Depreciations'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54180000' THEN 'Telecom ExP'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54550000' THEN 'Other Operation Fixed Exp'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54350000' THEN 'Time Charterage'" ).append("\n"); 
		query.append("        WHEN STND_COST_CD='54400000' THEN 'Space Charterage'" ).append("\n"); 
		query.append("     END ) AS STND_COST_NM" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(SUN_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(SUN_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS SUN_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(MON_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(MON_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS MON_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(TUE_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(TUE_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS TUE_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(WED_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(WED_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS WED_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(THU_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(THU_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS THU_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(FRI_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(FRI_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS FRI_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(SAT_COST_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(SAT_COST_AMT) " ).append("\n"); 
		query.append("    END ) AS SAT_COST_AMT" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53102000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '53200000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54100000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54250000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54300000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54200000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54150000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54450000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54180000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54550000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54350000' THEN SUM(TTL_AMT)  " ).append("\n"); 
		query.append("        WHEN STND_COST_CD = '54400000' THEN SUM(TTL_AMT) " ).append("\n"); 
		query.append("    END ) AS TTL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,DP_SEQ" ).append("\n"); 
		query.append("    ,' ' AS MERGE_CD" ).append("\n"); 
		query.append("	,'2' AS ROW_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("FROM COA_MNL_DTL_COST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND COST_YRMON LIKE SUBSTR(REPLACE(@[f_yearweek],'-',''),1,4)||'%'" ).append("\n"); 
		query.append("	AND COST_WK = SUBSTR(REPLACE(@[f_yearweek],'-',''),5,2)" ).append("\n"); 
		query.append("    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("GROUP BY STND_COST_CD, DP_SEQ, RLANE_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ROW_SEQ, VSL_CD, DP_SEQ" ).append("\n"); 

	}
}