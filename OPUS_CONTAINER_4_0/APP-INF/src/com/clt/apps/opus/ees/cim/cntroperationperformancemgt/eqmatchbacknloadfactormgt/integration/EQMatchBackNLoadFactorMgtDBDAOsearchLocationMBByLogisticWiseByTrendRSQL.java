/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseByTrendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseByTrendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocationMBByLogisticWiseByTrend
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseByTrendRSQL(){
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
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseByTrendRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("		X.LOC_CD," ).append("\n"); 
		query.append("        X.DSP_SEQ IBFLAG," ).append("\n"); 
		query.append("        X.TPSZ VVD," ).append("\n"); 
		query.append("		DECODE(MAX(Y.NO),'1','I/B','2','O/B','3','Balance','4','M/B(%)') DIVISION," ).append("\n"); 
		query.append("		DECODE	(" ).append("\n"); 
		query.append("					MAX(Y.NO),'1',SUM(X.IN_QTY),'2',SUM(X.OUT_QTY),'3',SUM(BALANCE),'4'," ).append("\n"); 
		query.append("					CASE" ).append("\n"); 
		query.append("					WHEN SUM(X.IN_QTY) >= SUM(X.OUT_QTY) THEN ROUND( SUM(X.OUT_QTY) / SUM(X.IN_QTY) * 100 )" ).append("\n"); 
		query.append("					WHEN SUM(X.OUT_QTY) >0 THEN ROUND( SUM(X.IN_QTY) / SUM(X.OUT_QTY) * -1 * 100 )" ).append("\n"); 
		query.append("					ELSE 0" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				) TOTAL," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 1,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_0," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 2,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_1," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 3,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_2," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 4,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_3," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 5,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_4," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 6,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_5," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 7,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_6," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 8,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_7," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ, 9,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_8," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,10,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_9," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,11,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_10," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,12,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_11," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,13,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_12," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,14,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_13," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,15,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_14," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,16,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_15," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,17,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_16," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,18,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_17," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,19,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_18," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,20,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_19," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,21,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_20," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,22,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_21," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,23,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_22," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,24,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_23," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,25,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_24," ).append("\n"); 
		query.append("		SUM(DECODE(X.DAY_SEQ,26,DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_25" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT	/*+ ORDERED USE_NL(O L T S) */" ).append("\n"); 
		query.append("					(#if ( ${locationBy} == 'RC' || ${locationBy} == 'CC' )" ).append("\n"); 
		query.append("					 SUBSTR(O.SCC_CD,1,2)" ).append("\n"); 
		query.append("					 #elseif( ${locationBy} == 'RL' )" ).append("\n"); 
		query.append("					 O.LCC_CD" ).append("\n"); 
		query.append("					 #elseif( ${locationBy} == 'RE' || ${locationBy} == 'LE' )" ).append("\n"); 
		query.append("					 O.ECC_CD" ).append("\n"); 
		query.append("					 #elseif( ${locationBy} == 'ES' || ${locationBy} == 'SS' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("					 O.SCC_CD" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("					 O.RCC_CD" ).append("\n"); 
		query.append("					 #end)   LOC_CD,     /* inquiryLevel */" ).append("\n"); 
		query.append("					T.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("					W.DAY_SEQ DAY_SEQ," ).append("\n"); 
		query.append("					S.DP_SEQ DSP_SEQ," ).append("\n"); 
		query.append("					SUM (T.IB_QTY) IN_QTY," ).append("\n"); 
		query.append("					SUM (T.OB_QTY) OUT_QTY," ).append("\n"); 
		query.append("					( SUM (T.IB_QTY) - SUM(T.OB_QTY) ) BALANCE," ).append("\n"); 
		query.append("					CASE" ).append("\n"); 
		query.append("					WHEN SUM (T.IB_QTY) >= SUM (T.OB_QTY) THEN ROUND( SUM (T.OB_QTY) / SUM (T.IB_QTY) * 100 )" ).append("\n"); 
		query.append("					WHEN SUM (T.OB_QTY) >0 THEN ROUND(  SUM (T.IB_QTY) / SUM (T.OB_QTY) * -1  * 100 )" ).append("\n"); 
		query.append("					ELSE 0" ).append("\n"); 
		query.append("					END AS MB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM	" ).append("\n"); 
		query.append("					MDM_EQ_ORZ_CHT		O," ).append("\n"); 
		query.append("					MDM_LOCATION		L," ).append("\n"); 
		query.append("					CIM_LOC_MTCH_BAK_SMRY	T," ).append("\n"); 
		query.append("					CIM_TP_SZ_DP_SEQ_V	S," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#if ( ${period} == 'W' )" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX ( XPKEQR_WK_PRD ) */ " ).append("\n"); 
		query.append("								PLN_YR||PLN_WK DAY_UNIT," ).append("\n"); 
		query.append("								ROWNUM         DAY_SEQ" ).append("\n"); 
		query.append("						FROM    EQR_WK_PRD" ).append("\n"); 
		query.append("						WHERE   PLN_YR||PLN_WK >= SUBSTR(@[from],0,6)" ).append("\n"); 
		query.append("						AND     PLN_YR||PLN_WK <= SUBSTR(@[to],0,6)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if ( ${period} == 'M' )" ).append("\n"); 
		query.append("					    SELECT DAY_UNIT DAY_UNIT," ).append("\n"); 
		query.append("					           ROWNUM   DAY_SEQ" ).append("\n"); 
		query.append("					    FROM   (          	" ).append("\n"); 
		query.append("            						SELECT  DISTINCT PLN_YR||PLN_MON  DAY_UNIT     " ).append("\n"); 
		query.append("            						FROM    EQR_WK_PRD" ).append("\n"); 
		query.append("            						WHERE   PLN_YR||PLN_MON >= SUBSTR(@[from],0,6)" ).append("\n"); 
		query.append("               						AND     PLN_YR||PLN_MON <= SUBSTR(@[to],0,6)" ).append("\n"); 
		query.append("               						ORDER BY PLN_YR||PLN_MON" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				   )                   W    " ).append("\n"); 
		query.append("			#if ( ${period} == 'W' )   " ).append("\n"); 
		query.append("			WHERE T.TGT_YRWK BETWEEN @[from] AND @[to]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if ( ${period} == 'M' )" ).append("\n"); 
		query.append("			WHERE T.TGT_MVMT_DT BETWEEN @[from] AND @[to]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("			AND T.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			AND T.LOC_CD       = L.LOC_CD" ).append("\n"); 
		query.append("			AND L.SCC_CD       = O.SCC_CD	" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			/* location */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${locationBy} == 'RL' || ${locationBy} == 'RC' || ${locationBy} == 'RE' )" ).append("\n"); 
		query.append("			AND O.RCC_CD = @[location]" ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'LE' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("			AND O.LCC_CD = @[location]" ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'ES' )" ).append("\n"); 
		query.append("			AND O.ECC_CD = @[location]" ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'SS' )" ).append("\n"); 
		query.append("			AND O.SCC_CD = @[location]" ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'CC' )" ).append("\n"); 
		query.append("			AND O.SCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${period} == 'W') 	 								 " ).append("\n"); 
		query.append("			AND T.TGT_YRWK = W.DAY_UNIT" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${period} == 'M')" ).append("\n"); 
		query.append("			AND SUBSTR(T.TGT_MVMT_DT,1,6) = W.DAY_UNIT	" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* cargoType */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${cargoType} == 'F')" ).append("\n"); 
		query.append("			AND T.FULL_MTY_CD			=	'F'		" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cargoType} == 'M')" ).append("\n"); 
		query.append("			AND T.FULL_MTY_CD			=	'M'		" ).append("\n"); 
		query.append("			#end		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* tpsz */" ).append("\n"); 
		query.append("			#if (${tpsz} == 'A') " ).append("\n"); 
		query.append("			AND S.CNTR_TPSZ_DIV_CD = S.CNTR_TPSZ_DIV_CD" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			AND S.CNTR_TPSZ_DIV_CD = @[tpsz]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			/* rdType */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${rdtype} == 'E') " ).append("\n"); 
		query.append("			AND  T.RD_FLG  = 'N'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${rdtype} == 'O') " ).append("\n"); 
		query.append("			AND  T.RD_FLG  = 'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* enRoute */" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${enRoute} == 'E') " ).append("\n"); 
		query.append("			AND		T.ENR_FLG	=	'N'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${enRoute} == 'O') " ).append("\n"); 
		query.append("			AND		T.ENR_FLG	=	'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			/* soc */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${soc} == 'E') " ).append("\n"); 
		query.append("			AND  T.SOC_FLG  = 'N'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${soc} == 'O') " ).append("\n"); 
		query.append("			AND  T.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("			GROUP BY" ).append("\n"); 
		query.append("			#if ( ${locationBy} == 'RC' || ${locationBy} == 'CC' )" ).append("\n"); 
		query.append("			SUBSTR(O.SCC_CD,1,2)," ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'RL' )" ).append("\n"); 
		query.append("			O.LCC_CD, " ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'RE' || ${locationBy} == 'LE' )" ).append("\n"); 
		query.append("			O.ECC_CD," ).append("\n"); 
		query.append("			#elseif( ${locationBy} == 'ES' || ${locationBy} == 'SS' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("			O.SCC_CD," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			O.RCC_CD," ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("					T.CNTR_TPSZ_CD, W.DAY_SEQ, S.DP_SEQ		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )   X," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT '1' AS NO FROM DUAL UNION SELECT '2' AS NO FROM DUAL UNION SELECT '3' AS NO FROM DUAL UNION SELECT '4' AS NO FROM DUAL" ).append("\n"); 
		query.append("		) Y" ).append("\n"); 
		query.append("GROUP BY X.LOC_CD, X.DSP_SEQ, X.TPSZ, DECODE(Y.NO,'1','AA','2','BB','3','CC','4','DD')" ).append("\n"); 
		query.append("ORDER BY X.LOC_CD, X.DSP_SEQ" ).append("\n"); 

	}
}