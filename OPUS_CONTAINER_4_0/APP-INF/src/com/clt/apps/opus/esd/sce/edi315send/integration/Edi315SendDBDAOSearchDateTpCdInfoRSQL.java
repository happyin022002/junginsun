/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchDateTpCdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.07 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchDateTpCdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi 315 DateTpCd info
	  * </pre>
	  */
	public Edi315SendDBDAOSearchDateTpCdInfoRSQL(){
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
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchDateTpCdInfoRSQL").append("\n"); 
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
		query.append("#if (${trans_tp_cd} == 'OBSTRT' && ${loc_tp_cd} == 'FR' && ${date_tp_cd} == 'CO')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	@[date_tp_cd] AS DATE_TP_CD," ).append("\n"); 
		query.append("		TO_CHAR(SYS_SET_DT,'YYYYMMDDHH24MI') AS DATE_INFO" ).append("\n"); 
		query.append("  FROM  BKG_CLZ_TM" ).append("\n"); 
		query.append(" WHERE 	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND 	CLZ_TP_CD = 'R'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	@[date_tp_cd] AS DATE_TP_CD," ).append("\n"); 
		query.append("		CASE" ).append("\n"); 
		query.append("#if ((${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC') && (${loc_tp_cd} == 'LP'))" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ETA' THEN TO_CHAR(VVPS.VPS_ETA_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ETA' THEN TO_CHAR(SCD.ESTM_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       		WHEN @[date_tp_cd] = 'EAV' THEN TO_CHAR(SCD.ESTM_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC') && (${loc_tp_cd} == 'DP'))" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ATD' THEN TO_CHAR(VAPS.ACT_DEP_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ATD' THEN TO_CHAR(SCD.ACT_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC') && (${loc_tp_cd} == 'DP'))" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ETD' THEN TO_CHAR(VVPS.VPS_ETD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ETD' THEN TO_CHAR(SCD.ESTM_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'LD' THEN TO_CHAR(SCD.ACT_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC') && (${loc_tp_cd} == 'LP'))" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ATA' THEN TO_CHAR(VAPS.ACT_ARR_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'ATA' THEN TO_CHAR(SCD.ACT_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	WHEN @[date_tp_cd] = 'DD' THEN TO_CHAR(SCD.ACT_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("    	END AS DATE_INFO" ).append("\n"); 
		query.append("  FROM 	SCE_COP_DTL SCD" ).append("\n"); 
		query.append("      ,	SCE_COP_HDR SCH" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("      , BKG_VVD BV" ).append("\n"); 
		query.append("      , VSK_ACT_PORT_SKD VAPS" ).append("\n"); 
		query.append("      , VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE  SCD.COP_NO = SCH.COP_NO" ).append("\n"); 
		query.append("   AND 	SCH.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'OBSTRT')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'FRCTY') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'XXXXX'" ).append("\n"); 
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
		query.append("                               AND SUBSTR(ACT_CD, 5,2) = 'DO'" ).append("\n"); 
		query.append("                               AND COP_DTL_SEQ < @[cop_dtl_seq]) " ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'END')" ).append("\n"); 
		query.append("    AND  SCD.COP_DTL_SEQ =  @[cop_dtl_seq]  --- 도착지" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("    AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND SCD.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND SUBSTR(SCD.NOD_CD, 1, 5) = SUBSTR(@[loc_yd_cd], 1, 5)" ).append("\n"); 
		query.append("    AND SCD.VSL_CD = VVPS.VSL_CD(+)" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO = VVPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD = VVPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND SCD.VPS_PORT_CD = VVPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND VVPS.CLPT_IND_SEQ(+) = SCD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND SCD.VSL_CD = VAPS.VSL_CD(+)" ).append("\n"); 
		query.append("    AND SCD.SKD_VOY_NO = VAPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND SCD.SKD_DIR_CD = VAPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND SCD.VPS_PORT_CD = VAPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND VAPS.CLPT_IND_SEQ(+) = SCD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC')" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP')" ).append("\n"); 
		query.append("    	#if (${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD' || ${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FLVMDO', 'FLWMDO','FTVMDO') -- TRNKPC, LP, ETD/ATD" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'LD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FLWMLO', 'FLVMLO','FTVMLO') -- TRNKPC, LP, LD " ).append("\n"); 
		query.append("        #end	" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP')" ).append("\n"); 
		query.append("		#if (${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA' || ${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMAD','FTVMAD','FUWMAD') -- TRNKPC, DP, ETA/ATA" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'DD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMUD','FTVMUD','FUWMUD') -- TRNKPC, DP, DD " ).append("\n"); 
		query.append("        #end		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKMC')" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP')" ).append("\n"); 
		query.append("		#if (${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD' || ${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTVMDO','FUVMDO','FLVMDO','FLWMDO') -- TRNKMC, LP, 'ETD','ATD'" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'LD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTVMLO','FLVMLO','FLWMLO','FTWMLO') -- TRNKMC, LP, 'LD'" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP') " ).append("\n"); 
		query.append("		#if (${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA' || ${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMAD','FTVMAD','FUWMAD','FUVMAD') -- TRNKPC, DP, 'ETA', 'ATA'" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'DD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMUD','FTVMUD','FUWMUD') -- TRNKPC, DP, 'DD'" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP')" ).append("\n"); 
		query.append("		#if (${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD' || ${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FLVMDO','FLWMDO','FTVMDO','FTWMDO') -- -- TRNKOC, LP, ETD, ATD" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'LD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FLWMLO','FLVMLO','FTVMLO','FTWMLO') -- TRNKOC, LP, LD" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP') " ).append("\n"); 
		query.append("		#if (${date_tp_cd} == 'ETA' || ${date_tp_cd} == 'ATA' || ${date_tp_cd} == 'ETD' || ${date_tp_cd} == 'ATD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMAD','FTVMAD','FUWMAD','FUVMAD') -- TRNKOC, DP, 'ETA', 'ATA'" ).append("\n"); 
		query.append("        #elseif(${date_tp_cd} == 'DD')" ).append("\n"); 
		query.append("			AND SCD.ACT_CD IN ('FTWMUD','FTVMUD','FUWMUD','FUVMUD') -- TRNKOC, DP, 'DD'" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'IBEND')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LIBH')" ).append("\n"); 
		query.append("		#if(${date_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("    AND SCD.COP_DTL_SEQ = (SELECT MAX(COP_DTL_SEQ) " ).append("\n"); 
		query.append("                             FROM SCE_COP_DTL " ).append("\n"); 
		query.append("                            WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                               AND ( ACT_CD LIKE 'F%AD' OR ACT_CD  LIKE 'F%UD'))" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("    AND SCD.COP_DTL_SEQ = (SELECT MAX(COP_DTL_SEQ) " ).append("\n"); 
		query.append("                             FROM SCE_COP_DTL " ).append("\n"); 
		query.append("                            WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                              AND SUBSTR(ACT_CD,1,2) = 'FI')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'IBDR') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'FITZAD'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'ER') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'TOCTY') " ).append("\n"); 
		query.append("	AND SCD.ACT_CD = 'XXXXX'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}