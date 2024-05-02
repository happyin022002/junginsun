/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOsearchMBByServiceModeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.04.13 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOsearchMBByServiceModeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Match-Back by Service Mode
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOsearchMBByServiceModeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOsearchMBByServiceModeRSQL").append("\n"); 
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
		query.append("'ZZZZZ' LOC_CD," ).append("\n"); 
		query.append("'ZZZZZ' VVD," ).append("\n"); 
		query.append("'ZZZZZ' DIVISION," ).append("\n"); 
		query.append("'9' XXX," ).append("\n"); 
		query.append("0 TOTAL," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'01',XXX,0)) AS qty_0," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'02',XXX,0)) AS qty_1," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'03',XXX,0)) AS qty_2," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'04',XXX,0)) AS qty_3," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'05',XXX,0)) AS qty_4," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'06',XXX,0)) AS qty_5," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'07',XXX,0)) AS qty_6," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'08',XXX,0)) AS qty_7," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'09',XXX,0)) AS qty_8," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'10',XXX,0)) AS qty_9," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'11',XXX,0)) AS qty_10," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'12',XXX,0)) AS qty_11," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'13',XXX,0)) AS qty_12," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'14',XXX,0)) AS qty_13," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'15',XXX,0)) AS qty_14," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'16',XXX,0)) AS qty_15," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'17',XXX,0)) AS qty_16," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'18',XXX,0)) AS qty_17," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'19',XXX,0)) AS qty_18," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'20',XXX,0)) AS qty_19," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'21',XXX,0)) AS qty_20," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'22',XXX,0)) AS qty_21," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'23',XXX,0)) AS qty_22," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'24',XXX,0)) AS qty_23," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'25',XXX,0)) AS qty_24," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'26',XXX,0)) AS qty_25," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'27',XXX,0)) AS qty_26," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'28',XXX,0)) AS qty_27," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'29',XXX,0)) AS qty_28," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'30',XXX,0)) AS qty_29," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'31',XXX,0)) AS qty_30," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'32',XXX,0)) AS qty_31," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'33',XXX,0)) AS qty_32," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'34',XXX,0)) AS qty_33," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'35',XXX,0)) AS qty_34," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'36',XXX,0)) AS qty_35," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'37',XXX,0)) AS qty_36," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'38',XXX,0)) AS qty_37," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'39',XXX,0)) AS qty_38," ).append("\n"); 
		query.append("SUM(DECODE(DSP_SEQ,'40',XXX,0)) AS qty_39" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DP_SEQ DSP_SEQ, " ).append("\n"); 
		query.append("        DECODE( @[tpsz] , 'A' , 1 , DECODE( CNTR_TPSZ_DIV_CD , @[tpsz] , 1 , 0 ) ) XXX" ).append("\n"); 
		query.append("FROM    CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        X.LOC_CD," ).append("\n"); 
		query.append("        X.SVC_MODE VVD," ).append("\n"); 
		query.append("        DECODE(MAX(Y.NO),'1','I/B','2','O/B','3','Balance','4','M/B(%)') DIVISION," ).append("\n"); 
		query.append("Y.NO XXX," ).append("\n"); 
		query.append("        DECODE(" ).append("\n"); 
		query.append("            MAX(Y.NO),'1',SUM(X.IN_QTY),'2',SUM(X.OUT_QTY),'3',SUM(BALANCE),'4'," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("					WHEN SUM(X.IN_QTY) >= SUM(X.OUT_QTY) THEN ROUND( SUM(X.OUT_QTY) / SUM(X.IN_QTY) * 100 )" ).append("\n"); 
		query.append("					WHEN SUM(X.OUT_QTY) >0 THEN ROUND( SUM(X.IN_QTY) / SUM(X.OUT_QTY) * -1 * 100 )" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ) TOTAL," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'01',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_0," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'02',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_1," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'03',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_2," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'04',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_3," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'05',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_4," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'06',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_5," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'07',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_6," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'08',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_7," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'09',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_8," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'10',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_9," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'11',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_10," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'12',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_11," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'13',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_12," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'14',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_13," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'15',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_14," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'16',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_15," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'17',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_16," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'18',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_17," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'19',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_18," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'20',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_19," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'21',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_20," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'22',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_21," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'23',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_22," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'24',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_23," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'25',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_24," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'26',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_25," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'27',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_26," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'28',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_27," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'29',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_28," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'30',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_29," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'31',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_30," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'32',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_31," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'33',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_32," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'34',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_33," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'35',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_34," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'36',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_35," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'37',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_36," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'38',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_37," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'39',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_38," ).append("\n"); 
		query.append("        SUM(DECODE(DSP_SEQ,'40',DECODE(Y.NO,'1',X.IN_QTY,'2',X.OUT_QTY,'3',BALANCE,'4',MB),0)) AS qty_39" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    #if ( ${locationBy} != 'AP' )" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        /*+ ORDERED USE_NL( T S ) INDEX ( S XPKCIM_TP_SZ_DP_SEQ ) */" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("                        #if     ( ${locationBy} == 'AP' )" ).append("\n"); 
		query.append("                            L.LOC_CD" ).append("\n"); 
		query.append("                        #elseif ( ${locationBy} == 'AR' )" ).append("\n"); 
		query.append("                            O.RCC_CD" ).append("\n"); 
		query.append("                        #elseif ( ${locationBy} == 'RL' )" ).append("\n"); 
		query.append("                            O.LCC_CD" ).append("\n"); 
		query.append("                        #elseif ( ${locationBy} == 'RE' || ${locationBy} == 'LE' )" ).append("\n"); 
		query.append("                            O.ECC_CD" ).append("\n"); 
		query.append("                        #elseif ( ${locationBy} == 'ES' || ${locationBy} == 'SS' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("                            O.SCC_CD" ).append("\n"); 
		query.append("                        #elseif ( ${locationBy} == 'RC' || ${locationBy} == 'AC' )" ).append("\n"); 
		query.append("                            SUBSTR(O.SCC_CD,1,2)" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							''" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    )										LOC_CD,     /* inquiryLevel */" ).append("\n"); 
		query.append("                    DECODE(" ).append("\n"); 
		query.append("                        NVL(T.SVC_MD, '   '),	'LOC', 'LOC'," ).append("\n"); 
		query.append("												'CLO', 'LOC'," ).append("\n"); 
		query.append("												'NLO', 'LOC'," ).append("\n"); 
		query.append("												'ELO', 'LOC'," ).append("\n"); 
		query.append("												'IPI', 'IPI'," ).append("\n"); 
		query.append("												'CIP', 'IPI'," ).append("\n"); 
		query.append("												'NIP', 'IPI'," ).append("\n"); 
		query.append("												'COC', 'IPI'," ).append("\n"); 
		query.append("												'NOC', 'IPI'," ).append("\n"); 
		query.append("												'EOC', 'IPI'," ).append("\n"); 
		query.append("												'MLB', 'MLB'," ).append("\n"); 
		query.append("												'CML', 'MLB'," ).append("\n"); 
		query.append("												'NML', 'MLB'," ).append("\n"); 
		query.append("												'EML', 'MLB', NVL(T.SVC_MD, '   ')" ).append("\n"); 
		query.append("						)									SVC_MODE," ).append("\n"); 
		query.append("                    S.DP_SEQ 								DSP_SEQ," ).append("\n"); 
		query.append("                    SUM(T.IB_QTY)							IN_QTY," ).append("\n"); 
		query.append("                    SUM(T.OB_QTY)							OUT_QTY," ).append("\n"); 
		query.append("                    ( SUM(T.IB_QTY) - SUM(T.OB_QTY) )		BALANCE," ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("					WHEN SUM (T.IB_QTY) >= SUM (T.OB_QTY) THEN ROUND( SUM (T.OB_QTY) / SUM (T.IB_QTY) * 100 )" ).append("\n"); 
		query.append("					WHEN SUM (T.OB_QTY) >0 THEN ROUND(  SUM (T.IB_QTY) / SUM (T.OB_QTY) * -1  * 100 )" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                    END AS                                  MB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM	" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						SELECT	INLND_SVC_MOD_CD	SVC_MD	," ).append("\n"); 
		query.append("								DECODE( OB_QTY, 1, ORG_LOC_CD, DEST_LOC_CD )	LOC_CD	," ).append("\n"); 
		query.append("								CNTR_TPSZ_CD		TPSZ	," ).append("\n"); 
		query.append("								IB_QTY				IB_QTY	," ).append("\n"); 
		query.append("								OB_QTY				OB_QTY" ).append("\n"); 
		query.append("						#if ( ${locationBy} != 'AP' )" ).append("\n"); 
		query.append("								FROM CIM_LOC_MTCH_BAK_SMRY" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("								FROM CIM_PORT_MTCH_BAK_SMRY " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${period} == 'W')" ).append("\n"); 
		query.append("						WHERE	TGT_YRWK BETWEEN @[from] AND @[to]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${period} == 'M')" ).append("\n"); 
		query.append("						WHERE	TGT_MVMT_DT BETWEEN @[from] AND @[to]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						AND		FULL_MTY_CD	=	'F'" ).append("\n"); 
		query.append("						#if ( ${locationBy} != 'AP' )" ).append("\n"); 
		query.append("						AND		ENR_FLG		=	'N'" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						AND		TS_FLG		=	'N'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						AND		INLND_SVC_MOD_CD IS NOT NULL AND INLND_SVC_MOD_CD <> ' '" ).append("\n"); 
		query.append("						AND		INLND_SVC_MOD_CD IN ( 'LOC', 'CLO', 'NLO', 'ELO', 'IPI', 'CIP', 'NIP', 'COC', 'NOC', 'EOC', 'MLB', 'CML', 'NML', 'EML')" ).append("\n"); 
		query.append("						AND		ORG_LOC_CD	IS NOT NULL" ).append("\n"); 
		query.append("						AND		DEST_LOC_CD	IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#if ( ${locationBy} != 'AP' )" ).append("\n"); 
		query.append("						AND		MVMT_CO_CD <> 'L'   /* H :HJS, S :SEN, L:Hanjin Logistics */" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						AND		CO_CD <> 'L'   /* H :HJS, S :SEN, L:Hanjin Logistics */ " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#if (${soc} == 'E')" ).append("\n"); 
		query.append("						AND		SOC_FLG = 'N'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${soc} == 'O')" ).append("\n"); 
		query.append("						AND		SOC_FLG = 'Y'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${rdtype} == 'E')" ).append("\n"); 
		query.append("						AND		RD_FLG = 'N'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${rdtype} == 'O')" ).append("\n"); 
		query.append("						AND		RD_FLG = 'Y'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					)						T," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   MDM_LOCATION			L," ).append("\n"); 
		query.append("                    MDM_EQ_ORZ_CHT			O," ).append("\n"); 
		query.append("                    CIM_TP_SZ_DP_SEQ		S" ).append("\n"); 
		query.append("            WHERE T.TPSZ		= S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND T.LOC_CD	= L.LOC_CD" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            AND L.SCC_CD	= O.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ( ${locationBy} != 'AR' && ${locationBy} != 'AC' && ${locationBy} != 'AP' )" ).append("\n"); 
		query.append("                #if    ( ${locationBy} == 'RL' || ${locationBy} == 'RC' || ${locationBy} == 'RE' )" ).append("\n"); 
		query.append("                    AND O.RCC_CD = @[location]" ).append("\n"); 
		query.append("                #elseif( ${locationBy} == 'LE' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("                    AND O.LCC_CD = @[location]" ).append("\n"); 
		query.append("                #elseif( ${locationBy} == 'ES' )" ).append("\n"); 
		query.append("                    AND O.ECC_CD = @[location]" ).append("\n"); 
		query.append("                #elseif( ${locationBy} == 'SS' )" ).append("\n"); 
		query.append("                    AND O.SCC_CD = @[location]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* SVC Mode */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ( ${cargotype} == 'L' )" ).append("\n"); 
		query.append("                AND NVL(T.SVC_MD,'   ') IN ( 'LOC', 'CLO', 'NLO', 'ELO' )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            #if ( ${cargotype} == 'I' )" ).append("\n"); 
		query.append("                AND NVL(T.SVC_MD,'   ') IN ( 'IPI', 'CIP', 'NIP', 'COC', 'NOC', 'EOC' )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            #if ( ${cargotype} == 'M' )" ).append("\n"); 
		query.append("                AND NVL(T.SVC_MD,'   ') IN ( 'MLB', 'CML', 'NML', 'EML' )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* tpsz */" ).append("\n"); 
		query.append("            AND S.CNTR_TPSZ_DIV_CD = DECODE(@[tpsz],'A', S.CNTR_TPSZ_DIV_CD, @[tpsz] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             GROUP BY" ).append("\n"); 
		query.append("                #if     ( ${locationBy} == 'AP' )" ).append("\n"); 
		query.append("                    L.LOC_CD," ).append("\n"); 
		query.append("                #elseif ( ${locationBy} == 'AR' )" ).append("\n"); 
		query.append("                    O.RCC_CD," ).append("\n"); 
		query.append("                #elseif ( ${locationBy} == 'RL' )" ).append("\n"); 
		query.append("                    O.LCC_CD," ).append("\n"); 
		query.append("                #elseif ( ${locationBy} == 'RE' || ${locationBy} == 'LE' )" ).append("\n"); 
		query.append("                    O.ECC_CD," ).append("\n"); 
		query.append("                #elseif ( ${locationBy} == 'ES' || ${locationBy} == 'SS' || ${locationBy} == 'LS' )" ).append("\n"); 
		query.append("                    O.SCC_CD," ).append("\n"); 
		query.append("                #elseif ( ${locationBy} == 'RC' || ${locationBy} == 'AC' )" ).append("\n"); 
		query.append("                    SUBSTR(O.SCC_CD,1,2)," ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    DECODE( " ).append("\n"); 
		query.append("						NVL(T.SVC_MD, '   '),	'LOC', 'LOC'," ).append("\n"); 
		query.append("												'CLO', 'LOC'," ).append("\n"); 
		query.append("												'NLO', 'LOC'," ).append("\n"); 
		query.append("												'ELO', 'LOC'," ).append("\n"); 
		query.append("												'IPI', 'IPI'," ).append("\n"); 
		query.append("												'CIP', 'IPI'," ).append("\n"); 
		query.append("												'NIP', 'IPI'," ).append("\n"); 
		query.append("												'COC', 'IPI'," ).append("\n"); 
		query.append("												'NOC', 'IPI'," ).append("\n"); 
		query.append("												'EOC', 'IPI'," ).append("\n"); 
		query.append("												'MLB', 'MLB'," ).append("\n"); 
		query.append("												'CML', 'MLB'," ).append("\n"); 
		query.append("												'NML', 'MLB'," ).append("\n"); 
		query.append("												'EML', 'MLB', NVL(T.SVC_MD, '   ')" ).append("\n"); 
		query.append("					) ," ).append("\n"); 
		query.append("                    S.DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )   X, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT '1' AS NO FROM DUAL UNION SELECT '2' AS NO FROM DUAL UNION SELECT '3' AS NO FROM DUAL UNION SELECT '4' AS NO FROM DUAL" ).append("\n"); 
		query.append("        ) Y" ).append("\n"); 
		query.append("GROUP BY X.LOC_CD, X.SVC_MODE, DECODE(Y.NO,'1','AA','2','BB','3','CC','4','DD'), Y.NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LOC_CD, VVD, XXX" ).append("\n"); 

	}
}