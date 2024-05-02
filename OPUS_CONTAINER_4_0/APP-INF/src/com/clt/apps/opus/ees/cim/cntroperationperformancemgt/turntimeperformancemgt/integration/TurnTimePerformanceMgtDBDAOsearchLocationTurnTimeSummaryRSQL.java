/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.08.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeSummaryRSQL(){
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
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flowpattern",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inquiryLevel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeSummaryRSQL").append("\n"); 
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
		query.append("SELECT  L.LOC_CD locCode," ).append("\n"); 
		query.append("L.TPSZ tpsz," ).append("\n"); 
		query.append("DECODE(MAX(Y.NO),'1','CNTR','2','Days','3','T/Time' ,1 ) AS division," ).append("\n"); 
		query.append("DECODE(MAX(Y.NO),'1',SUM(T_CNT),'2',SUM(T_TIME),'3',DECODE(SUM(T_CNT),0,0,ROUND(SUM(T_TIME) / SUM(T_CNT) ,1 ))) AS total," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 1,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count01," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 2,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count02," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 3,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count03," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 4,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count04," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 5,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count05," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 6,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count06," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 7,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count07," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 8,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count08," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 9,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count09," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 10,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count10," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 11,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count11," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 12,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count12," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 13,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count13," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 14,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count14," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 15,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count15," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 16,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count16," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 17,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count17," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 18,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count18," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 19,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count19," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 20,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count20," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 21,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count21," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 22,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count22," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 23,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count23," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 24,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count24," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 25,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count25," ).append("\n"); 
		query.append("SUM( DECODE( L.WK_SEQ, 26,DECODE(Y.NO,'1',T_CNT,'2',T_TIME,'3',DECODE(T_CNT,0,0,ROUND(T_TIME / T_CNT ,1 ))),0)) AS count26" ).append("\n"); 
		query.append("		FROM    ( " ).append("\n"); 
		query.append("		SELECT /*+ ORDERED USE_NL ( O L T ) */" ).append("\n"); 
		query.append("		#if (${inquiryLevel} == 'AR' ) " ).append("\n"); 
		query.append("		O.RCC_CD LOC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("		O.LCC_CD LOC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("		O.ECC_CD LOC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES' || ${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("		O.SCC_CD LOC_CD,  " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC') " ).append("\n"); 
		query.append("		SUBSTR(O.SCC_CD,1,2)  LOC_CD, " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		T.CNTR_TPSZ_CD          TPSZ, " ).append("\n"); 
		query.append("		W.WSEQ                  WK_SEQ, " ).append("\n"); 
		query.append("		S.DP_SEQ				DSP_SEQ, " ).append("\n"); 
		query.append("		/* ---------------------------------------------------------------- 2009.09.22 By SBKIM */" ).append("\n"); 
		query.append("  		#if ( ${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC') " ).append("\n"); 
		query.append("   		SUM  (T.TT_DYS + T.ENR_TT_DYS)  T_TIME, " ).append("\n"); 
		query.append("   		SUM(T.CNTR_KNT)    T_CNT " ).append("\n"); 
		query.append("  		#elseif( ${inquiryLevel} == 'AL' || ${inquiryLevel} == 'RL' ) " ).append("\n"); 
		query.append("   		SUM( DECODE( L.PORT_INLND_FLG, 'Y', DECODE( T.ENR_TT_DYS, 0, T.TT_DYS,0), T.TT_DYS + T.ENR_TT_DYS ) ) T_TIME," ).append("\n"); 
		query.append("   		--SUM( DECODE( L.PORT_INLND_FLG, 'Y', DECODE( T.ENR_TT_DYS, 0, T.CNTR_KNT, 0 ), T.CNTR_KNT ) )  T_CNT" ).append("\n"); 
		query.append("		/*--- 계산오류로 인해 원본 쿼리로 변경 ---*/" ).append("\n"); 
		query.append("   		SUM( DECODE( L.PORT_INLND_FLG, 'Y', DECODE( T.ENR_TT_DYS, 0, 1, 0 ), 1 ) )  T_CNT" ).append("\n"); 
		query.append("  		#else" ).append("\n"); 
		query.append("   			#if (${enRoute} == 'E' || ${enRoute} == '') " ).append("\n"); 
		query.append("   			SUM  (T.TT_DYS)      T_TIME, " ).append("\n"); 
		query.append("   			#elseif(${enRoute} == 'I') " ).append("\n"); 
		query.append("   			SUM  (T.TT_DYS + T.ENR_TT_DYS)  T_TIME, " ).append("\n"); 
		query.append("   			#elseif(${enRoute} == 'O') " ).append("\n"); 
		query.append("   			SUM( T.ENR_TT_DYS  )    T_TIME, " ).append("\n"); 
		query.append("   			#end " ).append("\n"); 
		query.append("   			SUM(T.CNTR_KNT) T_CNT" ).append("\n"); 
		query.append("  		#end   " ).append("\n"); 
		query.append("  		/* ---------------------------------------------------------------- 2009.09.22 By SBKIM */" ).append("\n"); 
		query.append("		FROM	" ).append("\n"); 
		query.append("		#if (${inquiryLevel} == 'AR')   " ).append("\n"); 
		query.append("		MDM_EQ_ORZ_CHT		O, " ).append("\n"); 
		query.append("		MDM_LOCATION		L, " ).append("\n"); 
		query.append("		CIM_PORT_TURN_TM_SMRY	T, " ).append("\n"); 
		query.append("		CIM_TP_SZ_DP_SEQ_V	S, " ).append("\n"); 
		query.append("		#else /* if ( :Inquiry Level !='AR' ) CIM_LOC_TURN_TM */ " ).append("\n"); 
		query.append("		MDM_EQ_ORZ_CHT		O, " ).append("\n"); 
		query.append("		MDM_LOCATION		L, " ).append("\n"); 
		query.append("		#if( ${inquiryLevel} == 'AL' || ${inquiryLevel} == 'RL' ) " ).append("\n"); 
		query.append("		/*--- 계산오류로 인해 원본 쿼리로 변경 ---*/" ).append("\n"); 
		query.append("		CIM_LOC_TURN_TM		T, " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		CIM_LOC_TURN_TM_SMRY		T, " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		CIM_TP_SZ_DP_SEQ_V	S, " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		( " ).append("\n"); 
		query.append("		#if (${period} == 'W') " ).append("\n"); 
		query.append("		SELECT  /*+ INDEX ( XPKEQR_WK_PRD ) */ " ).append("\n"); 
		query.append("		PLN_YR||PLN_WK  DAY_UNIT, " ).append("\n"); 
		query.append("		ROWNUM				WSEQ " ).append("\n"); 
		query.append("		FROM    EQR_WK_PRD " ).append("\n"); 
		query.append("		WHERE   PLN_YR||PLN_WK >= @[from] " ).append("\n"); 
		query.append("		AND     PLN_YR||PLN_WK <= @[to] " ).append("\n"); 
		query.append("		#elseif (${period} == 'M') " ).append("\n"); 
		query.append("		SELECT	DAY_UNIT    DAY_UNIT, " ).append("\n"); 
		query.append("		ROWNUM      WSEQ " ).append("\n"); 
		query.append("		FROM	( " ).append("\n"); 
		query.append("		SELECT  DISTINCT PLN_YR||PLN_MON  DAY_UNIT " ).append("\n"); 
		query.append("		FROM    EQR_WK_PRD " ).append("\n"); 
		query.append("		WHERE   PLN_YR||PLN_MON >= SUBSTR(@[from],0,6)" ).append("\n"); 
		query.append("		AND     PLN_YR||PLN_MON <= SUBSTR(@[to],0,6)" ).append("\n"); 
		query.append("		ORDER BY PLN_YR||PLN_MON " ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		) W " ).append("\n"); 
		query.append("		#if (${period} == 'W') " ).append("\n"); 
		query.append("		WHERE   T.TGT_YRWK BETWEEN  @[from] AND @[to] " ).append("\n"); 
		query.append("		#elseif (${period} == 'M') " ).append("\n"); 
		query.append("		WHERE   SUBSTR(T.TGT_MVMT_DT, 1, 6) BETWEEN  @[from] AND @[to] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		/* ---------------------------------------------------------------- 2009.09.22 By SBKIM */" ).append("\n"); 
		query.append("		#if ( ${inquiryLevel} == 'AR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		#elseif ( ${inquiryLevel} == 'AC' || ${inquiryLevel} == 'AL' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'RL' || ${inquiryLevel} == 'CC')  " ).append("\n"); 
		query.append("  		AND     T.TT_LOC_LVL_CD =   'LCC' " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND     T.TT_LOC_LVL_CD =   'SCC'		 " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND     T.CNTR_TPSZ_CD  =   S.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inquiryLevel} == 'AR') " ).append("\n"); 
		query.append("		AND     T.VL_LOC_CD	    =   L.LOC_CD " ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		AND     T.LOC_CD	    =   L.LOC_CD " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		AND     L.SCC_CD		=   O.SCC_CD " ).append("\n"); 
		query.append("		#if (${inquiryLevel} != 'AR' && ${inquiryLevel} != 'AC')" ).append("\n"); 
		query.append("		AND     DECODE( SUBSTR(@[inquiryLevel],1,1),'A',@[location], " ).append("\n"); 
		query.append("		'R', O.RCC_CD, " ).append("\n"); 
		query.append("		'L', O.LCC_CD, " ).append("\n"); 
		query.append("		'E', O.ECC_CD, " ).append("\n"); 
		query.append("		'S', O.SCC_CD, " ).append("\n"); 
		query.append("		'C', SUBSTR(O.SCC_CD,1,2) ) =   @[location] /* inquiryLevel */ /* location */ " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${flowpattern} != '' && ${flowpattern} != 'A' &&  ${flowpattern} != '5') " ).append("\n"); 
		query.append("		AND     T.TT_CGO_TP_CD	=	@[flowpattern] " ).append("\n"); 
		query.append("		#elseif (${flowpattern} != '' && ${flowpattern} == '5') " ).append("\n"); 
		query.append("		AND     T.TT_CGO_TP_CD	<>	'4'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${tpsz} != '') " ).append("\n"); 
		query.append("			AND     T.CNTR_TPSZ_CD  IN ( " ).append("\n"); 
		query.append("		#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("			'$cntrtpszcd',  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("			'') " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${tscntr} == 'E') " ).append("\n"); 
		query.append("		AND		T.TS_FLG		=	'N' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${tscntr} == 'O') " ).append("\n"); 
		query.append("		AND		T.TS_FLG		=	'Y' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${soc} == 'E') " ).append("\n"); 
		query.append("		AND		T.SOC_FLG		=	'N' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${soc} == 'O') " ).append("\n"); 
		query.append("		AND		T.SOC_FLG		=	'Y' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${period} == 'W') " ).append("\n"); 
		query.append("		AND     T.TGT_YRWK					=   W.DAY_UNIT " ).append("\n"); 
		query.append("		#elseif (${period} == 'M') " ).append("\n"); 
		query.append("		AND		SUBSTR(T.TGT_MVMT_DT,1,6)	=   W.DAY_UNIT " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		GROUP BY " ).append("\n"); 
		query.append("		#if (${inquiryLevel} == 'AR' ) " ).append("\n"); 
		query.append("		O.RCC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'RL') " ).append("\n"); 
		query.append("		O.LCC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'LE' || ${inquiryLevel} == 'RE') " ).append("\n"); 
		query.append("		O.ECC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'LS' || ${inquiryLevel} == 'ES' || ${inquiryLevel} == 'SS') " ).append("\n"); 
		query.append("		O.SCC_CD, " ).append("\n"); 
		query.append("		#elseif (${inquiryLevel} == 'AC' || ${inquiryLevel} == 'RC' || ${inquiryLevel} == 'CC') " ).append("\n"); 
		query.append("		SUBSTR(O.SCC_CD,1,2), " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		T.CNTR_TPSZ_CD  , " ).append("\n"); 
		query.append("		W.WSEQ          , " ).append("\n"); 
		query.append("		S.DP_SEQ " ).append("\n"); 
		query.append("		)   L ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT '1' AS NO FROM DUAL UNION SELECT '2' AS NO FROM DUAL UNION SELECT '3' AS NO FROM DUAL" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("ROLLUP(L.LOC_CD,L.TPSZ), DECODE(Y.NO, '1', 'XX', '2', 'YY')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("L.LOC_CD,MAX(L.DSP_SEQ), L.TPSZ, DECODE(Y.NO, '1', 'XX', '2', 'YY')" ).append("\n"); 

	}
}