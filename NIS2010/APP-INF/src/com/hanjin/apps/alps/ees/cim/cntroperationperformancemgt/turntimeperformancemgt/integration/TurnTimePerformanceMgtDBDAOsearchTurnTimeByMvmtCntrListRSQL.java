/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAOsearchTurnTimeByMvmtCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDAOsearchTurnTimeByMvmtCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * aa
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAOsearchTurnTimeByMvmtCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locvalue",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsztitle",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAOsearchTurnTimeByMvmtCntrListRSQL").append("\n"); 
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
		query.append("#if (${mvmtPairDivision} == '1'	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT D.CNTR_NO, M.CNTR_TPSZ_CD, D.FM_LOC_CD FM_YD_CD, D.TO_LOC_CD TO_YD_CD, D.TT_DYS" ).append("\n"); 
		query.append("	  FROM	CIM_SHP_TURN_TM			M," ).append("\n"); 
		query.append("			CIM_SHP_TURN_TM_DTL		D," ).append("\n"); 
		query.append("            		--MDM_LOCATION			FL,		/* From Loc Location */" ).append("\n"); 
		query.append("            		--MDM_EQ_ORZ_CHT		FG,		/* From Loc Orgnization */" ).append("\n"); 
		query.append("            		--MDM_LOCATION			TL,		/* To Loc Location */" ).append("\n"); 
		query.append("            		--MDM_EQ_ORZ_CHT		TG,		/* To Loc Organization */" ).append("\n"); 
		query.append("			CIM_TP_SZ_DP_SEQ		S" ).append("\n"); 
		query.append("		#if (${period} == 'M')" ).append("\n"); 
		query.append("		WHERE	D.TGT_MVMT_DT	BETWEEN	   @[from]	AND @[to]" ).append("\n"); 
		query.append("		#elseif	(${period} == 'W')" ).append("\n"); 
		query.append("		WHERE	M.TGT_YRWK	BETWEEN	   @[from]	AND @[to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		M.TGT_MVMT_DT		=	D.TGT_MVMT_DT" ).append("\n"); 
		query.append("	    AND		M.CNTR_NO			=	D.CNTR_NO" ).append("\n"); 
		query.append("	    AND		M.IB_PORT_CD		=	D.IB_PORT_CD" ).append("\n"); 
		query.append("	    AND		M.ID_LOC_CD			=	D.ID_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    AND	    M.CNTR_TPSZ_CD		=   S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inquiryLevel} !=	'AR' &&	${inquiryLevel}	!= 'AC')" ).append("\n"); 
		query.append("	#if (${inquiryLevel} ==	'RL' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("		AND	D.TO_RCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LE')" ).append("\n"); 
		query.append("		AND	D.TO_LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("		AND	D.TO_LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("		AND	D.TO_SCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("		AND	D.TO_ECC_CD = @[location]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				#if (${inquiryLevel} == 'AR') " ).append("\n"); 
		query.append("					D.FM_RCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'AC') " ).append("\n"); 
		query.append("					SUBSTR(D.FM_SCC_CD,1,2) " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("					D.FM_LCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("					D.FM_ECC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LS') " ).append("\n"); 
		query.append("					D.FM_SCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("					D.FM_SCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'ES') " ).append("\n"); 
		query.append("					D.FM_SCC_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				=" ).append("\n"); 
		query.append("				#if (${inquiryLevel} == 'AR') " ).append("\n"); 
		query.append("					D.TO_RCC_CD" ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'AC') " ).append("\n"); 
		query.append("					SUBSTR(D.TO_SCC_CD,1,2) " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("					D.TO_LCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("					D.TO_ECC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'LS') " ).append("\n"); 
		query.append("					D.TO_SCC_CD  " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("					D.TO_SCC_CD " ).append("\n"); 
		query.append("				#elseif (${inquiryLevel} == 'ES') " ).append("\n"); 
		query.append("					D.TO_SCC_CD " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${convalue} == 'ID-MT')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'MG'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-OP')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'MP'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-VL')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'MR'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-XX')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'FH'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'IC-ID')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'FD'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'OP-VL')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'OF'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'VD-MT')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'IF'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'VD-TS-VL')" ).append("\n"); 
		query.append("        AND D.TT_SHP_TP_CD = 'TL'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tpsz} !=	'A')" ).append("\n"); 
		query.append("	AND		S.CNTR_TPSZ_DIV_CD  =  @[tpsz]		/* CNTR	TPSZ */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${soc} == 'E')" ).append("\n"); 
		query.append("	AND		M.SOC_FLG			=	'N'					/* soc */" ).append("\n"); 
		query.append("	#elseif	(${soc}	== 'O')" ).append("\n"); 
		query.append("	AND		M.SOC_FLG			=	'Y'					/* soc */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND		D.TT_SHP_TP_SEQ	= (" ).append("\n"); 
		query.append("								SELECT	/*+ INDEX( DD XPKCIM_SHP_TURN_TM_DTL ) */" ).append("\n"); 
		query.append("										DD.TT_SHP_TP_SEQ" ).append("\n"); 
		query.append("								FROM	CIM_SHP_TURN_TM_DTL		DD" ).append("\n"); 
		query.append("								WHERE	DD.TGT_MVMT_DT		=	D.TGT_MVMT_DT" ).append("\n"); 
		query.append("								AND		DD.CNTR_NO			=	D.CNTR_NO" ).append("\n"); 
		query.append("								AND		DD.IB_PORT_CD		=	D.IB_PORT_CD" ).append("\n"); 
		query.append("								AND		DD.ID_LOC_CD		=	D.ID_LOC_CD" ).append("\n"); 
		query.append("								AND		DD.TT_SHP_TP_CD		=	D.TT_SHP_TP_CD" ).append("\n"); 
		query.append("								AND		(" ).append("\n"); 
		query.append("								#if (${inquiryLevel} ==	'AR')" ).append("\n"); 
		query.append("									DD.FM_RCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'AC')" ).append("\n"); 
		query.append("									SUBSTR(DD.FM_SCC_CD,1,2)" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("									DD.FM_LCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("									DD.FM_ECC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("									DD.FM_SCC_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								=" ).append("\n"); 
		query.append("								#if (${inquiryLevel} ==	'AR')" ).append("\n"); 
		query.append("									DD.TO_RCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'AC')" ).append("\n"); 
		query.append("									SUBSTR(DD.TO_SCC_CD,1,2)" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'RL')" ).append("\n"); 
		query.append("									DD.TO_LCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("									DD.TO_ECC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("									DD.TO_SCC_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								AND		ROWNUM				=	1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if (${tpsztitle} != 'Total')" ).append("\n"); 
		query.append("   	    AND M.CNTR_TPSZ_CD = @[tpsztitle]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("     #if (${loctitle} == 'RCC')" ).append("\n"); 
		query.append("        AND D.TO_RCC_CD = @[locvalue]" ).append("\n"); 
		query.append("     #elseif	(${loctitle}	== 'Country')" ).append("\n"); 
		query.append("        AND SUBSTR(D.TO_SCC_CD,1,2) = @[locvalue]" ).append("\n"); 
		query.append("     #elseif	(${loctitle}	== 'LCC')" ).append("\n"); 
		query.append("        AND D.TO_LCC_CD = @[locvalue]" ).append("\n"); 
		query.append("     #elseif	(${loctitle}	== 'ECC')" ).append("\n"); 
		query.append("        AND D.TO_ECC_CD = @[locvalue]" ).append("\n"); 
		query.append("     #elseif	(${loctitle}	== 'SCC')" ).append("\n"); 
		query.append("        AND D.TO_SCC_CD = @[locvalue]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT M.CNTR_NO, M.CNTR_TPSZ_CD, DECODE(M.FM_YD_CD, NULL, M.FM_LOC_CD, M.FM_YD_CD) FM_YD_CD, " ).append("\n"); 
		query.append("           DECODE(M.TO_YD_CD, NULL, M.TO_LOC_CD, M.TO_YD_CD) TO_YD_CD, M.TT_DYS" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("				CIM_MVMT_STS_TURN_TM	M," ).append("\n"); 
		query.append("				MDM_LOCATION				FL,  /*	From Loc Location */" ).append("\n"); 
		query.append("				MDM_EQ_ORZ_CHT				FG,  /*	From Loc Orgnization */" ).append("\n"); 
		query.append("				CIM_TP_SZ_DP_SEQ			S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${period} == 'M')" ).append("\n"); 
		query.append("		WHERE M.TGT_MVMT_DT BETWEEN    @[from] AND @[to]" ).append("\n"); 
		query.append("		#elseif	(${period} == 'W')" ).append("\n"); 
		query.append("		WHERE M.TGT_YRWK BETWEEN    @[from] AND	@[to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND	M.CNTR_TPSZ_CD	=   S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		AND	M.FM_LOC_CD		=   FL.LOC_CD" ).append("\n"); 
		query.append("		AND	FL.SCC_CD		=   FG.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inquiryLevel} !=	'AR' &&	${inquiryLevel}	!= 'AC')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${inquiryLevel} ==	'RL' || ${inquiryLevel} == 'RE')" ).append("\n"); 
		query.append("		AND  FG.RCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LE')" ).append("\n"); 
		query.append("		AND  FG.LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'LS')" ).append("\n"); 
		query.append("		AND  FG.LCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'SS')" ).append("\n"); 
		query.append("		AND  FG.SCC_CD = @[location]" ).append("\n"); 
		query.append("	#elseif	(${inquiryLevel} == 'ES')" ).append("\n"); 
		query.append("		AND  FG.ECC_CD = @[location]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${tpsz} !=	'A')" ).append("\n"); 
		query.append("		AND  S.CNTR_TPSZ_DIV_CD	 =  @[tpsz]  /*	CNTR TPSZ */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${soc} == 'E')" ).append("\n"); 
		query.append("		AND  M.SOC_FLG	 = 'N'	   /* soc */" ).append("\n"); 
		query.append("	#elseif	(${soc}	== 'O')" ).append("\n"); 
		query.append("		AND  M.SOC_FLG	 = 'Y'	   /* soc */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     #if (${convalue} == 'IC-EN')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'A'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'EN-IC')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'B'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'IC-ID')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'C'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'ID-MT')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'D'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-EN')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'E'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-TN')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'O'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-XX')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'F'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'XX-MT')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'G'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-OP')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'H'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'OP-OC')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'I'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'OC-EN')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'J'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'EN-OC')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'K'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'OC-VL')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'L'" ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'EN-MT')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'M' " ).append("\n"); 
		query.append("     #elseif	(${convalue}	== 'MT-VL')" ).append("\n"); 
		query.append("        AND  M.TT_MVMT_TP_CD = 'N' " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  #if (${tpsztitle} != 'Total')" ).append("\n"); 
		query.append("    AND M.CNTR_TPSZ_CD = @[tpsztitle]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  #if (${loctitle} == 'RCC')" ).append("\n"); 
		query.append("    AND FG.RCC_CD = @[locvalue]" ).append("\n"); 
		query.append("  #elseif	(${loctitle}	== 'Country')" ).append("\n"); 
		query.append("     AND SUBSTR(FG.SCC_CD,1,2) = @[locvalue]" ).append("\n"); 
		query.append("  #elseif	(${loctitle}	== 'LCC')" ).append("\n"); 
		query.append("     AND FG.LCC_CD = @[locvalue]" ).append("\n"); 
		query.append("  #elseif	(${loctitle}	== 'ECC')" ).append("\n"); 
		query.append("     AND FG.ECC_CD = @[locvalue]" ).append("\n"); 
		query.append("  #elseif	(${loctitle}	== 'SCC')" ).append("\n"); 
		query.append("    AND FG.SCC_CD = @[locvalue]" ).append("\n"); 
		query.append("  #elseif	(${loctitle}	== 'Yard')" ).append("\n"); 
		query.append("    AND NVL(M.FM_YD_CD,FG.SCC_CD) = @[locvalue]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}