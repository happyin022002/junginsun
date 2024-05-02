/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2010.08.27 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
	  *    Direction Wise 항목 추가 (Loc-Loc)에 따른 MatchBack 조회 쿼리
	  * * 2012.05.11 신자영 [CHM-201217714-01] Cargo Flow Map 로직 수정 - LOC-LOC조건 선택 시 region 에 걸린 제약 제거
	  * 2013.06.13 이영두 [CHM-201324997] Daily Trend 탭의 TP/SZ 조건 OT 일 경우 O5 항목 추가
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocRSQL(){
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
		params.put("inquiryWise2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inquiryWise1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocRSQL").append("\n"); 
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
		query.append("SELECT 'Loc' AS YARD_CD," ).append("\n"); 
		query.append("    DECODE(BND,1,LOC1,2,LOC2,'') AS LOC_CD,--FM_LOC," ).append("\n"); 
		query.append("    DECODE(BND,1,LOC2,2,LOC1,'') AS VVD,--TO_LOC," ).append("\n"); 
		query.append("    DECODE(BND,3,'MB(%)','VOL')  AS DIVISION,--DIV," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'99',CNT,0)) AS TOTAL," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'01',CNT,0)) AS QTY_0," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'02',CNT,0)) AS QTY_1," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'03',CNT,0)) AS QTY_2," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'04',CNT,0)) AS QTY_3," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'05',CNT,0)) AS QTY_4," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'06',CNT,0)) AS QTY_5," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'07',CNT,0)) AS QTY_6," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'08',CNT,0)) AS QTY_7," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'09',CNT,0)) AS QTY_8," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'10',CNT,0)) AS QTY_9," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'11',CNT,0)) AS QTY_10," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'12',CNT,0)) AS QTY_11," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'13',CNT,0)) AS QTY_12," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'14',CNT,0)) AS QTY_13," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'15',CNT,0)) AS QTY_14," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'16',CNT,0)) AS QTY_15," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'17',CNT,0)) AS QTY_16," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'18',CNT,0)) AS QTY_17," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'19',CNT,0)) AS QTY_18," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'20',CNT,0)) AS QTY_19," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'21',CNT,0)) AS QTY_20," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'22',CNT,0)) AS QTY_21," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'23',CNT,0)) AS QTY_22," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'24',CNT,0)) AS QTY_23," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'25',CNT,0)) AS QTY_24," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'26',CNT,0)) AS QTY_25," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'27',CNT,0)) AS QTY_26," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'28',CNT,0)) AS QTY_27," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'29',CNT,0)) AS QTY_28," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'30',CNT,0)) AS QTY_29," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'31',CNT,0)) AS QTY_30," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'32',CNT,0)) AS QTY_31," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'33',CNT,0)) AS QTY_32," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'34',CNT,0)) AS QTY_33," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'35',CNT,0)) AS QTY_34," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'36',CNT,0)) AS QTY_35," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'37',CNT,0)) AS QTY_36," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'38',CNT,0)) AS QTY_37," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'39',CNT,0)) AS QTY_38," ).append("\n"); 
		query.append("    SUM(DECODE(DSP_SEQ,'40',CNT,0)) AS QTY_39" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT LOC1," ).append("\n"); 
		query.append("             LOC2," ).append("\n"); 
		query.append("             DSP_SEQ," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             DECODE(BND, 1, CNT1, 2, CNT2, MB) CNT," ).append("\n"); 
		query.append("             BND" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("              SELECT  DECODE(BND,1,LOC1,2,LOC2,'') LOC1," ).append("\n"); 
		query.append("                      DECODE(BND,1,LOC2,2,LOC1,'') LOC2," ).append("\n"); 
		query.append("                      NVL(DSP_SEQ, 99) DSP_SEQ," ).append("\n"); 
		query.append("                      NVL(CNTR_TPSZ_CD,'99') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      SUM(DECODE(BND,1,CNT,0)) CNT1," ).append("\n"); 
		query.append("                      SUM(DECODE(BND,2,CNT,0)) CNT2," ).append("\n"); 
		query.append("                      ROUND(LEAST(SUM(DECODE(BND,1,CNT,0)),SUM(DECODE(BND,2,CNT,0))) / GREATEST(SUM(DECODE(BND,1,CNT,0)),SUM(DECODE(BND,2,CNT,0))) * 100,1) MB" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                      SELECT BND," ).append("\n"); 
		query.append("                             DECODE(BND,1," ).append("\n"); 
		query.append("                             #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            							A.FM_RCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            							A.FM_LCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            							A.FM_ECC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            							A.FM_SCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.FM_SCC_CD,1,2) ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            						   A.LOC_CD ," ).append("\n"); 
		query.append("            				 #end  								" ).append("\n"); 
		query.append("							 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("            							A.FM_RCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("            							A.FM_LCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("            							A.FM_ECC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("            							A.FM_SCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.FM_SCC_CD,1,2)" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("            						   A.LOC_CD" ).append("\n"); 
		query.append("            				 #end 	" ).append("\n"); 
		query.append("							 )LOC1,					                                  " ).append("\n"); 
		query.append("                             DECODE(BND,1," ).append("\n"); 
		query.append("							 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("            							A.TO_RCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("            							A.TO_LCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("            							A.TO_ECC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("            							A.TO_SCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.TO_SCC_CD,1,2)," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("            						   A.TO_LOC_CD," ).append("\n"); 
		query.append("            				 #end  	" ).append("\n"); 
		query.append("                             #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            							A.TO_RCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            							A.TO_LCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            							A.TO_ECC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            							A.TO_SCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.TO_SCC_CD,1,2)" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            						   A.TO_LOC_CD" ).append("\n"); 
		query.append("            				 #end " ).append("\n"); 
		query.append("							 ) LOC2, 	                             " ).append("\n"); 
		query.append("                             DSP_SEQ," ).append("\n"); 
		query.append("                             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                             SUM(CNT) CNT" ).append("\n"); 
		query.append("                       FROM" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                             SELECT" ).append("\n"); 
		query.append("                                    T.LOC_CD," ).append("\n"); 
		query.append("                                    T.TO_LOC_CD," ).append("\n"); 
		query.append("                                    O1.SCC_CD FM_SCC_CD," ).append("\n"); 
		query.append("                                    O1.ECC_CD FM_ECC_CD," ).append("\n"); 
		query.append("                                    O1.LCC_CD FM_LCC_CD," ).append("\n"); 
		query.append("                                    O1.RCC_CD FM_RCC_CD," ).append("\n"); 
		query.append("                                    O2.SCC_CD TO_SCC_CD," ).append("\n"); 
		query.append("                                    O2.ECC_CD TO_ECC_CD," ).append("\n"); 
		query.append("                                    O2.LCC_CD TO_LCC_CD," ).append("\n"); 
		query.append("                                    O2.RCC_CD TO_RCC_CD," ).append("\n"); 
		query.append("                                    S.DP_SEQ DSP_SEQ," ).append("\n"); 
		query.append("                                    T.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                    (T.OB_QTY) CNT" ).append("\n"); 
		query.append("                               FROM CIM_BKG_MTCH_BAK_SMRY T," ).append("\n"); 
		query.append("                                    CIM_TP_SZ_DP_SEQ S," ).append("\n"); 
		query.append("                                    MDM_LOCATION     L1," ).append("\n"); 
		query.append("                                    MDM_EQ_ORZ_CHT   O1," ).append("\n"); 
		query.append("                                    MDM_LOCATION     L2," ).append("\n"); 
		query.append("                                    MDM_EQ_ORZ_CHT   O2" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("                                AND T.TGT_YRWK BETWEEN @[fromz] AND @[toz]" ).append("\n"); 
		query.append("#elseif (${period} == 'M')" ).append("\n"); 
		query.append("                                AND T.TGT_MVMT_DT BETWEEN @[fromz] AND @[toz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                AND T.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                AND T.LOC_CD       = L1.LOC_CD" ).append("\n"); 
		query.append("                                AND L1.SCC_CD      = O1.SCC_CD" ).append("\n"); 
		query.append("                                AND T.TO_LOC_CD    = L2.LOC_CD" ).append("\n"); 
		query.append("                                AND L2.SCC_CD      = O2.SCC_CD" ).append("\n"); 
		query.append("#if ( ${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("                                AND	T.CNTR_PERF_LOC_DIV_CD = 'POL'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                AND	T.CNTR_PERF_LOC_DIV_CD = 'POR'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location} !='' && ${location2} =='')		" ).append("\n"); 
		query.append("                                AND (    DECODE(@[inquiryWise1],'R',O1.RCC_CD,'L',O1.LCC_CD,'E',O1.ECC_CD,'S',O1.SCC_CD,'C',SUBSTR(O1.SCC_CD,1,2),'P',L1.LOC_CD) IN(#foreach( $key IN ${arrLocFr}) #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end) " ).append("\n"); 
		query.append("                                      OR" ).append("\n"); 
		query.append("                                         DECODE(@[inquiryWise1],'R',O2.RCC_CD,'L',O2.LCC_CD,'E',O2.ECC_CD,'S',O2.SCC_CD,'C',SUBSTR(O2.SCC_CD,1,2),'P',L2.LOC_CD) IN(#foreach( $key IN ${arrLocFr}) #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("#elseif (${location} =='' && ${location2} !='')" ).append("\n"); 
		query.append("								AND (    DECODE(@[inquiryWise2],'R',O2.RCC_CD,'L',O2.LCC_CD,'E',O2.ECC_CD,'S',O2.SCC_CD,'C',SUBSTR(O2.SCC_CD,1,2),'P',L2.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end)                                                              " ).append("\n"); 
		query.append("                                      OR" ).append("\n"); 
		query.append("                                         DECODE(@[inquiryWise2],'R',O1.RCC_CD,'L',O1.LCC_CD,'E',O1.ECC_CD,'S',O1.SCC_CD,'C',SUBSTR(O1.SCC_CD,1,2),'P',L1.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("#elseif (${location} !='' && ${location2} !='')" ).append("\n"); 
		query.append("                                AND ((    DECODE(@[inquiryWise1],'R',O1.RCC_CD,'L',O1.LCC_CD,'E',O1.ECC_CD,'S',O1.SCC_CD,'C',SUBSTR(O1.SCC_CD,1,2),'P',L1.LOC_CD) IN(#foreach( $key IN ${arrLocFr}) #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end) " ).append("\n"); 
		query.append("                                      AND DECODE(@[inquiryWise2],'R',O2.RCC_CD,'L',O2.LCC_CD,'E',O2.ECC_CD,'S',O2.SCC_CD,'C',SUBSTR(O2.SCC_CD,1,2),'P',L2.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end))                                                              " ).append("\n"); 
		query.append("                                      OR" ).append("\n"); 
		query.append("                                     (    DECODE(@[inquiryWise2],'R',O1.RCC_CD,'L',O1.LCC_CD,'E',O1.ECC_CD,'S',O1.SCC_CD,'C',SUBSTR(O1.SCC_CD,1,2),'P',L1.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end) " ).append("\n"); 
		query.append("                                      AND DECODE(@[inquiryWise1],'R',O2.RCC_CD,'L',O2.LCC_CD,'E',O2.ECC_CD,'S',O2.SCC_CD,'C',SUBSTR(O2.SCC_CD,1,2),'P',L2.LOC_CD) IN(#foreach( $key IN ${arrLocFr})  #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end))" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("#end                                                             " ).append("\n"); 
		query.append("							  /* tpsz */" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'D')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'D2','D4','D5','D7','D8','D9','DW','DX' )" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'S')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'O2','O4','O5','S2','S4','F2','F4','F5','A4','A2','P2','P4','T2','T4' )" ).append("\n"); 
		query.append("               			 	#end" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'R')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'R2','R5','R7','R9' )" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			/* rdType */" ).append("\n"); 
		query.append("                			#if (${rdtype} == 'E')" ).append("\n"); 
		query.append("                                AND  T.RD_FLG = 'N'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${rdtype} == 'O')" ).append("\n"); 
		query.append("                                AND  T.RD_FLG = 'Y'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			/* soc */" ).append("\n"); 
		query.append("                			#if (${soc} == 'E')" ).append("\n"); 
		query.append("                                AND  T.SOC_FLG  = 'N'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${soc} == 'O')" ).append("\n"); 
		query.append("                                AND  T.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("                			#end	" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("                            , (SELECT LEVEL BND FROM DUAL CONNECT BY LEVEL<=2) B" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("		#if (${location} !='' && ${location2} =='')" ).append("\n"); 
		query.append("		        AND (   BND = 1 " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise1],'R',A.FM_RCC_CD,'L',A.FM_LCC_CD,'E',A.FM_ECC_CD,'S',A.FM_SCC_CD,'C',SUBSTR(A.FM_SCC_CD,1,2),'P',A.LOC_CD) IN(#foreach( $key IN ${arrLocFr})  #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                     OR" ).append("\n"); 
		query.append("                       BND = 2                        " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise1],'R',A.TO_RCC_CD,'L',A.TO_LCC_CD,'E',A.TO_ECC_CD,'S',A.TO_SCC_CD,'C',SUBSTR(A.TO_SCC_CD,1,2),'P',A.TO_LOC_CD) IN(#foreach( $key IN ${arrLocFr})  #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        #elseif (${location} =='' && ${location2} !='')" ).append("\n"); 
		query.append("			   AND (  BND = 1 " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise2],'R',A.TO_RCC_CD,'L',A.TO_LCC_CD,'E',A.TO_ECC_CD,'S',A.TO_SCC_CD,'C',SUBSTR(A.TO_SCC_CD,1,2),'P',A.TO_LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                     OR" ).append("\n"); 
		query.append("                      BND = 2 " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise2],'R',A.FM_RCC_CD,'L',A.FM_LCC_CD,'E',A.FM_ECC_CD,'S',A.FM_SCC_CD,'C',SUBSTR(A.FM_SCC_CD,1,2),'P',A.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("		#elseif (${location} !='' && ${location2} !='')" ).append("\n"); 
		query.append("			   AND ((   BND = 1  " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise1],'R',A.FM_RCC_CD,'L',A.FM_LCC_CD,'E',A.FM_ECC_CD,'S',A.FM_SCC_CD,'C',SUBSTR(A.FM_SCC_CD,1,2),'P',A.LOC_CD) IN(#foreach( $key IN ${arrLocFr})  #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end) " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise2],'R',A.TO_RCC_CD,'L',A.TO_LCC_CD,'E',A.TO_ECC_CD,'S',A.TO_SCC_CD,'C',SUBSTR(A.TO_SCC_CD,1,2),'P',A.TO_LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end))" ).append("\n"); 
		query.append("                     OR" ).append("\n"); 
		query.append("                    (   BND = 2  " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise2],'R',A.FM_RCC_CD,'L',A.FM_LCC_CD,'E',A.FM_ECC_CD,'S',A.FM_SCC_CD,'C',SUBSTR(A.FM_SCC_CD,1,2),'P',A.LOC_CD) IN(#foreach( $key IN ${arrLocTo}) #if($velocityCount < $arrLocTo.size()) '$key', #else '$key' #end #end) " ).append("\n"); 
		query.append("                      AND DECODE(@[inquiryWise1],'R',A.TO_RCC_CD,'L',A.TO_LCC_CD,'E',A.TO_ECC_CD,'S',A.TO_SCC_CD,'C',SUBSTR(A.TO_SCC_CD,1,2),'P',A.TO_LOC_CD) IN(#foreach( $key IN ${arrLocFr})  #if($velocityCount < $arrLocFr.size()) '$key', #else '$key' #end #end))" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("           GROUP BY BND," ).append("\n"); 
		query.append("                    DECODE(B.BND,1," ).append("\n"); 
		query.append("                             #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            							A.FM_RCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            							A.FM_LCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            							A.FM_ECC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            							A.FM_SCC_CD ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.FM_SCC_CD,1,2) ," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            						   A.LOC_CD ," ).append("\n"); 
		query.append("            				 #end  								" ).append("\n"); 
		query.append("							 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("            							A.FM_RCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("            							A.FM_LCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("            							A.FM_ECC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("            							A.FM_SCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.FM_SCC_CD,1,2)" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("            						   A.LOC_CD" ).append("\n"); 
		query.append("            				 #end 	" ).append("\n"); 
		query.append("							 ),					                                  " ).append("\n"); 
		query.append("                             DECODE(B.BND,1," ).append("\n"); 
		query.append("							 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("            							A.TO_RCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("            							A.TO_LCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("            							A.TO_ECC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("            							A.TO_SCC_CD," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.TO_SCC_CD,1,2)," ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("            						   A.TO_LOC_CD," ).append("\n"); 
		query.append("            				 #end  	" ).append("\n"); 
		query.append("                             #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("            							A.TO_RCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("            							A.TO_LCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("            							A.TO_ECC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("            							A.TO_SCC_CD" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("            							SUBSTR(A.TO_SCC_CD,1,2)" ).append("\n"); 
		query.append("            				 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("            						   A.TO_LOC_CD" ).append("\n"); 
		query.append("            				 #end " ).append("\n"); 
		query.append("							 ) , 	                             " ).append("\n"); 
		query.append("                             DSP_SEQ," ).append("\n"); 
		query.append("                             CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("     GROUP BY GROUPING SETS((DECODE(BND,1,LOC1,2,LOC2,''),DECODE(BND,1,LOC2,2,LOC1,''),DSP_SEQ,CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                           ,(DECODE(BND,1,LOC1,2,LOC2,''),DECODE(BND,1,LOC2,2,LOC1,''))" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("     , (SELECT LEVEL BND FROM DUAL CONNECT BY LEVEL<=3) B" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("GROUP BY LOC1,LOC2,BND" ).append("\n"); 
		query.append("ORDER BY LOC1||LOC2||BND" ).append("\n"); 

	}
}