/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.01.21 박광석
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

public class EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Flow Map
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromz",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("toz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapRSQL").append("\n"); 
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
		query.append("'Vol' ibflag," ).append("\n"); 
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
		query.append("ORDER BY  DP_SEQ" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		X.LOC_FST loc_cd," ).append("\n"); 
		query.append("		X.LOC_SND1 vvd," ).append("\n"); 
		query.append("		X.LOC_SND2 division," ).append("\n"); 
		query.append("		'Vol' ibflag," ).append("\n"); 
		query.append("		SUM(CNT) AS total," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'01',CNT,0)) AS qty_0," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'02',CNT,0)) AS qty_1," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'03',CNT,0)) AS qty_2," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'04',CNT,0)) AS qty_3," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'05',CNT,0)) AS qty_4," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'06',CNT,0)) AS qty_5," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'07',CNT,0)) AS qty_6," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'08',CNT,0)) AS qty_7," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'09',CNT,0)) AS qty_8," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'10',CNT,0)) AS qty_9," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'11',CNT,0)) AS qty_10," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'12',CNT,0)) AS qty_11," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'13',CNT,0)) AS qty_12," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'14',CNT,0)) AS qty_13," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'15',CNT,0)) AS qty_14," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'16',CNT,0)) AS qty_15," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'17',CNT,0)) AS qty_16," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'18',CNT,0)) AS qty_17," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'19',CNT,0)) AS qty_18," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'20',CNT,0)) AS qty_19," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'21',CNT,0)) AS qty_20," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'22',CNT,0)) AS qty_21," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'23',CNT,0)) AS qty_22," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'24',CNT,0)) AS qty_23," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'25',CNT,0)) AS qty_24," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'26',CNT,0)) AS qty_25," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'27',CNT,0)) AS qty_26," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'28',CNT,0)) AS qty_27," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'29',CNT,0)) AS qty_28," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'30',CNT,0)) AS qty_29," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'31',CNT,0)) AS qty_30," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'32',CNT,0)) AS qty_31," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'33',CNT,0)) AS qty_32," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'34',CNT,0)) AS qty_33," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'35',CNT,0)) AS qty_34," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'36',CNT,0)) AS qty_35," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'37',CNT,0)) AS qty_36," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'38',CNT,0)) AS qty_37," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'39',CNT,0)) AS qty_38," ).append("\n"); 
		query.append("		SUM(DECODE(DSP_SEQ,'40',CNT,0)) AS qty_39" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("#if (${directionWise} == 'F')" ).append("\n"); 
		query.append("	#if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("					O1.RCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("					O1.LCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("					O1.ECC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("					O1.SCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("					SUBSTR(O1.SCC_CD,1,2)" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("					L1.LOC_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("					O2.RCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("					O2.LCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("					O2.ECC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("					O2.SCC_CD" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("					SUBSTR(O2.SCC_CD,1,2)" ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("					L2.LOC_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    ) LOC_FST," ).append("\n"); 
		query.append("#if (${directionWise} == 'F')" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    ' '" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O2.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O2.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    ) LOC_SND1," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O2.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O2.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O2.SCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    SUBSTR(O2.SCC_CD,1,2)" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    L2.LOC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    ) LOC_SND2," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    ' '" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O1.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O1.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    ) LOC_SND1," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O1.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O1.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O1.SCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    SUBSTR(O1.SCC_CD,1,2)" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    L1.LOC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    ) LOC_SND2," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					S.DP_SEQ DSP_SEQ," ).append("\n"); 
		query.append("					SUM(T.IB_QTY)+SUM(T.OB_QTY) CNT" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("					CIM_BKG_MTCH_BAK_SMRY T," ).append("\n"); 
		query.append("					CIM_TP_SZ_DP_SEQ S," ).append("\n"); 
		query.append("					MDM_LOCATION     L1," ).append("\n"); 
		query.append("					MDM_EQ_ORZ_CHT   O1," ).append("\n"); 
		query.append("					MDM_LOCATION     L2," ).append("\n"); 
		query.append("					MDM_EQ_ORZ_CHT   O2" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("			WHERE   T.TGT_YRWK BETWEEN @[fromz] AND @[toz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period} == 'M')" ).append("\n"); 
		query.append("			WHERE   T.TGT_MVMT_DT BETWEEN @[fromz] AND @[toz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND		T.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			AND		T.LOC_CD       = L1.LOC_CD" ).append("\n"); 
		query.append("			AND		L1.SCC_CD      = O1.SCC_CD" ).append("\n"); 
		query.append("			AND		T.TO_LOC_CD    = L2.LOC_CD" ).append("\n"); 
		query.append("			AND		L2.SCC_CD      = O2.SCC_CD" ).append("\n"); 
		query.append("#if ( ${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("			AND		T.CNTR_PERF_LOC_DIV_CD = 'POL'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			AND		T.CNTR_PERF_LOC_DIV_CD = 'POR'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- if (${inquiryWise2} != 'R')" ).append("\n"); 
		query.append("	#if (${directionWise} == 'F')" ).append("\n"); 
		query.append("            #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            AND     O1.RCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            AND     O1.LCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            AND     O1.ECC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            AND     O1.SCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(O1.SCC_CD,1,2) LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            AND     L1.LOC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("	#else -- (${directionWise} == 'F')" ).append("\n"); 
		query.append("            #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            AND     O2.RCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            AND     O2.LCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            AND     O2.ECC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            AND     O2.SCC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(O2.SCC_CD,1,2) LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            AND     L2.LOC_CD LIKE @[location]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("	#end -- (${directionWise} == 'F')" ).append("\n"); 
		query.append("-- end -- (${inquiryWise2} != 'R')" ).append("\n"); 
		query.append("/* tpsz */" ).append("\n"); 
		query.append("#if (${tpsz} == 'D')" ).append("\n"); 
		query.append("			AND  T.CNTR_TPSZ_CD IN ( 'D2','D4','D5','D7','D8','D9','DW','DX' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tpsz} == 'S')" ).append("\n"); 
		query.append("			AND  T.CNTR_TPSZ_CD IN ( 'O2','O4','S2','S4','F2','F4','F5','A4','A2','P2','P4','T2','T4' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tpsz} == 'R')" ).append("\n"); 
		query.append("			AND  T.CNTR_TPSZ_CD IN ( 'R2','R5','R7' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* rdType */" ).append("\n"); 
		query.append("#if (${rdtype} == 'E')" ).append("\n"); 
		query.append("			AND  T.RD_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rdtype} == 'O')" ).append("\n"); 
		query.append("			AND  T.RD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* soc */" ).append("\n"); 
		query.append("#if (${soc} == 'E')" ).append("\n"); 
		query.append("			AND  T.SOC_FLG  = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc} == 'O')" ).append("\n"); 
		query.append("			AND  T.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			GROUP BY" ).append("\n"); 
		query.append("#if (${directionWise} == 'F')" ).append("\n"); 
		query.append("	#if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("					O1.RCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("					O1.LCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("					O1.ECC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("					O1.SCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("					SUBSTR(O1.SCC_CD,1,2)," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("					L1.LOC_CD," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("					O2.RCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("					O2.LCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("					O2.ECC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("					O2.SCC_CD," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("					SUBSTR(O2.SCC_CD,1,2)," ).append("\n"); 
		query.append("	#elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("					L2.LOC_CD," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${directionWise} == 'F')" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    ' '" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O2.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O2.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    O2.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O2.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O2.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O2.SCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    SUBSTR(O2.SCC_CD,1,2)" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    L2.LOC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    ' '" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O1.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O1.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("                    O1.RCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("                    O1.LCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("                    O1.ECC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("                    O1.SCC_CD" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("                    SUBSTR(O1.SCC_CD,1,2)" ).append("\n"); 
		query.append("                    #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("                    L1.LOC_CD" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					S.DP_SEQ" ).append("\n"); 
		query.append("        )   X" ).append("\n"); 
		query.append("GROUP BY X.LOC_FST, X.LOC_SND1, X.LOC_SND2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY loc_cd, vvd, division" ).append("\n"); 

	}
}