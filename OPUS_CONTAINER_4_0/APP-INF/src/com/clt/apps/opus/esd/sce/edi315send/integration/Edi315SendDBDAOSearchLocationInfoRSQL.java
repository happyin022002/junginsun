/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchLocationInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchLocationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi 315 Location info
	  * [2015.07.08]LOC_FAC_TP NYK Add
	  * </pre>
	  */
	public Edi315SendDBDAOSearchLocationInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchLocationInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT NOD_CD, SPLC_CD,LOC_DK_CD ,NVL(LOC_NM,LOC_NM1) LOC_NM , LOC_CITY_NM ,LOC_STAT_CD ,LOC_CNT_CD , LOC_TRANS_MODE, LOC_FAC_TP" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN SCH.POR_NOD_CD" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN SCH.DEL_NOD_CD" ).append("\n"); 
		query.append("             ELSE NOD_CD" ).append("\n"); 
		query.append("          END AS NOD_CD 	 " ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT SPLC_CD FROM SCE_RAIL_SPLC WHERE YD_CD = SCH.POR_NOD_CD AND ROWNUM=1)" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT SPLC_CD FROM SCE_RAIL_SPLC WHERE YD_CD = SCH.DEL_NOD_CD AND ROWNUM=1)" ).append("\n"); 
		query.append("             ELSE (SELECT SPLC_CD FROM SCE_RAIL_SPLC WHERE YD_CD = SCD.NOD_CD AND ROWNUM=1)" ).append("\n"); 
		query.append("          END AS SPLC_CD " ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.POR_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.DEL_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             ELSE (SELECT LOC_AMS_PORT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCD.NOD_CD, 1, 5))" ).append("\n"); 
		query.append("          END AS LOC_DK_CD " ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = SCH.POR_NOD_CD AND ROWNUM=1)" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = SCH.DEL_NOD_CD AND ROWNUM=1)" ).append("\n"); 
		query.append("             ELSE (SELECT YD_NM FROM MDM_YARD WHERE YD_CD =SCD.NOD_CD )" ).append("\n"); 
		query.append("          END AS LOC_NM " ).append("\n"); 
		query.append("        ,          " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.POR_NOD_CD ,1 ,5))" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.DEL_NOD_CD ,1 ,5))" ).append("\n"); 
		query.append("             ELSE (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCD.NOD_CD ,1 ,5) )" ).append("\n"); 
		query.append("          END AS LOC_NM1 " ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.POR_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.DEL_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             ELSE (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(NOD_CD,1,5))" ).append("\n"); 
		query.append("          END AS LOC_CITY_NM" ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT STE_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.POR_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT STE_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.DEL_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             ELSE (SELECT STE_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(NOD_CD,1,5))" ).append("\n"); 
		query.append("          END AS LOC_STAT_CD " ).append("\n"); 
		query.append("     	," ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'FRCTY' THEN (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.POR_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             WHEN @[loc_tp_cd] = 'TOCTY' THEN (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(SCH.DEL_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("             ELSE (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(NOD_CD,1,5))" ).append("\n"); 
		query.append("          END AS LOC_CNT_CD" ).append("\n"); 
		query.append("     	,DECODE(SUBSTR(SCD.ACT_CD, 3,1),'W','F',SUBSTR(SCD.ACT_CD, 3,1)) AS LOC_TRANS_MODE " ).append("\n"); 
		query.append("        ,DECODE(SUBSTR(SCD.ACT_CD, 4,1),'M','T','R','R','Z','C','D') AS LOC_FAC_TP /*2015.07.08 NYK Add*/" ).append("\n"); 
		query.append("  FROM 	SCE_COP_DTL SCD" ).append("\n"); 
		query.append("      ,	SCE_COP_HDR SCH" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("      , BKG_VVD BV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE  SCD.COP_NO = SCH.COP_NO" ).append("\n"); 
		query.append("   AND 	SCH.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'OBSTRT')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'FRCTY')" ).append("\n"); 
		query.append("	--AND  SUBSTR(SCD.ACT_CD,2,1) = 'O' " ).append("\n"); 
		query.append("    AND SCH.POR_NOD_CD = SCD.NOD_CD   -- 조건 추가" ).append("\n"); 
		query.append("	ORDER BY SCD.COP_DTL_SEQ ASC" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'EP') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'MOTYDO'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'OBDR') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'MOTZAD'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'FR') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = ( SELECT ACT_CD FROM SCE_COP_DTL WHERE COP_NO = @[cop_no] AND ACT_CD IN ('FOTYAD','FOTRAD','FOTMAD') AND COP_DTL_SEQ = (SELECT MIN(COP_DTL_SEQ) FROM SCE_COP_DTL WHERE COP_NO = @[cop_no] AND ACT_CD IN ('FOTYAD','FOTRAD','FOTMAD')))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'OBIMD')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'START')" ).append("\n"); 
		query.append("    AND  SCD.COP_DTL_SEQ =  @[cop_dtl_seq]  --- 출발지     위에서 조회한 SEQ" ).append("\n"); 
		query.append("    #elseif(${loc_tp_cd} == 'END')" ).append("\n"); 
		query.append("    AND SCD.COP_DTL_SEQ = (SELECT MIN(COP_DTL_SEQ) " ).append("\n"); 
		query.append("                             FROM SCE_COP_DTL " ).append("\n"); 
		query.append("                            WHERE COP_NO = @[cop_no] " ).append("\n"); 
		query.append("                              AND SUBSTR(ACT_CD, 5,2) = 'AD'  -- 직후 도착지 FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                              AND COP_DTL_SEQ > @[cop_dtl_seq])      " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'IBIMD')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'START')" ).append("\n"); 
		query.append("    AND  SCD.COP_DTL_SEQ = (SELECT MAX(COP_DTL_SEQ) " ).append("\n"); 
		query.append("                              FROM SCE_COP_DTL " ).append("\n"); 
		query.append("                             WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                               AND SUBSTR(ACT_CD, 5,2) = 'DO'  --- 도착지의 직전 출발지" ).append("\n"); 
		query.append("                               AND COP_DTL_SEQ < @[cop_dtl_seq]) " ).append("\n"); 
		query.append("    #elseif(${loc_tp_cd} == 'END')" ).append("\n"); 
		query.append("    AND  SCD.COP_DTL_SEQ =  @[cop_dtl_seq]  --- 도착지       " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC')" ).append("\n"); 
		query.append("    AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP')" ).append("\n"); 
		query.append("    AND SUBSTR(BV.POL_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("    AND SCD.ACT_CD IN ('FLWMLO', 'FLVMLO','FTVMLO') -- TRNKPC, LP " ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP')" ).append("\n"); 
		query.append("    AND SUBSTR(BV.POD_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("	AND SCD.ACT_CD IN ('FTWMUD','FTVMUD','FUWMUD') -- TRNKPC, DP" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKMC')" ).append("\n"); 
		query.append("    AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP') " ).append("\n"); 
		query.append("    AND SUBSTR(BV.POL_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("	AND SCD.ACT_CD IN ('FTVMLO','FLVMLO','FLWMLO','FTWMLO') -- TRNKMC, LP" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP')" ).append("\n"); 
		query.append("    AND SUBSTR(BV.POD_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("    AND SCD.ACT_CD IN ('FTVMUD','FUVMAD','FLWMAD','FUWMAD') -- TRNKMC, DP " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("    AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP') " ).append("\n"); 
		query.append("    AND SUBSTR(BV.POL_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("	AND SCD.ACT_CD   IN ('FLWMLO','FTVMLO','FTWMLO') -- TRNKOC, LP" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP') " ).append("\n"); 
		query.append("    AND SUBSTR(BV.POD_YD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("	AND SCD.ACT_CD   IN ('FUWMUD','FUVMUD','FTVMUD','FTWMUD') -- TRNKOC, DP" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKTT')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'START') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'FTTMDO'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'END') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'FTTMAD'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'IBEND')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LIBH')" ).append("\n"); 
		query.append("    AND  SUBSTR(SCD.ACT_CD,1,2) = 'FI' --20150813 수정    " ).append("\n"); 
		query.append("    AND  SUBSTR(SCD.ACT_CD,4,1) <> 'Z'" ).append("\n"); 
		query.append("    ORDER BY SCD.COP_DTL_SEQ DESC" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'IBDR') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'FITZAD'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'ER') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'TOCTY') " ).append("\n"); 
		query.append("	AND  SUBSTR(SCD.ACT_CD,2,1) = 'I'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	ORDER BY SCD.COP_DTL_SEQ ASC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM  = 1" ).append("\n"); 

	}
}