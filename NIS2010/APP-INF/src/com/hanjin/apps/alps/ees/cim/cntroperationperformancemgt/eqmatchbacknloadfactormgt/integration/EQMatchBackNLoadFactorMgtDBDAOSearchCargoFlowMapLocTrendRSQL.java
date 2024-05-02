/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocTrendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.01 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocTrendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201432577] Cargo Flow Map 관련 검색 기능 개선 제안
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocTrendRSQL(){
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
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocTrendRSQL").append("\n"); 
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
		query.append("WITH LV_YMD AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	#if (${week_list} != '')" ).append("\n"); 
		query.append("		#foreach ($user_week IN ${weekLists})" ).append("\n"); 
		query.append("			#if($velocityCount < $weekLists.size())" ).append("\n"); 
		query.append("            	REPLACE('$user_week','-','') AS YMW$velocityCount," ).append("\n"); 
		query.append("    	  	#else" ).append("\n"); 
		query.append("				REPLACE('$user_week','-','') AS YMW$velocityCount" ).append("\n"); 
		query.append("		  	#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LV_DATA0 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      SELECT  " ).append("\n"); 
		query.append("              DECODE(BND,1,LOC1,2,LOC2,'') LOC1," ).append("\n"); 
		query.append("              DECODE(BND,1,LOC2,2,LOC1,'') LOC2," ).append("\n"); 
		query.append("              NVL(DSP_SEQ, 99) DSP_SEQ," ).append("\n"); 
		query.append("              NVL(CNTR_TPSZ_CD,'99') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("              SUM(DECODE(BND,1,CNT,0)) CNT1," ).append("\n"); 
		query.append("              SUM(DECODE(BND,2,CNT,0)) CNT2," ).append("\n"); 
		query.append("              NVL(TGT_DT,'999912') AS TGT_DT" ).append("\n"); 
		query.append("        FROM                      " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("              SELECT BND," ).append("\n"); 
		query.append("					 DECODE(BND,1," ).append("\n"); 
		query.append("					 #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("								A.FM_RCC_CD ," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("								A.FM_LCC_CD ," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("								A.FM_ECC_CD ," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("								A.FM_SCC_CD ," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("								SUBSTR(A.FM_SCC_CD,1,2) ," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("							   A.LOC_CD ," ).append("\n"); 
		query.append("					 #end  								" ).append("\n"); 
		query.append("					 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("								A.FM_RCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("								A.FM_LCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("								A.FM_ECC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("								A.FM_SCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("								SUBSTR(A.FM_SCC_CD,1,2)" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("							   A.LOC_CD" ).append("\n"); 
		query.append("					 #end 	" ).append("\n"); 
		query.append("					 )LOC1,		" ).append("\n"); 
		query.append("					 DECODE(BND,1," ).append("\n"); 
		query.append("					 #if     (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("								A.TO_RCC_CD," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("								A.TO_LCC_CD," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("								A.TO_ECC_CD," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("								A.TO_SCC_CD," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("								SUBSTR(A.TO_SCC_CD,1,2)," ).append("\n"); 
		query.append("					 #elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("							   A.TO_LOC_CD," ).append("\n"); 
		query.append("					 #end  	" ).append("\n"); 
		query.append("					 #if     (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("								A.TO_RCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("								A.TO_LCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("								A.TO_ECC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("								A.TO_SCC_CD" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("								SUBSTR(A.TO_SCC_CD,1,2)" ).append("\n"); 
		query.append("					 #elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("							   A.TO_LOC_CD" ).append("\n"); 
		query.append("					 #end " ).append("\n"); 
		query.append("					 ) LOC2, " ).append("\n"); 
		query.append("                     DSP_SEQ," ).append("\n"); 
		query.append("                     CNTR_TPSZ_CD,                             " ).append("\n"); 
		query.append("                     SUM(CNT) CNT" ).append("\n"); 
		query.append("                     ,TGT_DT" ).append("\n"); 
		query.append("               FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
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
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("                                    ,SUBSTR(T.TGT_YRWK,0,6) AS TGT_DT" ).append("\n"); 
		query.append("#elseif (${period} == 'M')" ).append("\n"); 
		query.append("                                    ,SUBSTR(T.TGT_MVMT_DT,0,6) AS TGT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("#end    " ).append("\n"); 
		query.append("                              /* tpsz */" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'D')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'D2','D4','D5','D7','D8','D9','DW','DX' )" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'S')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'O2','O4','O5','S2','S4','F2','F4','F5','A4','A2','P2','P4','T2','T4' )" ).append("\n"); 
		query.append("               			 	#end" ).append("\n"); 
		query.append("                			#if (${tpsz} == 'R')" ).append("\n"); 
		query.append("                				AND  T.CNTR_TPSZ_CD IN ( 'R2','R5','R7','R9' )" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                              /* rdType */" ).append("\n"); 
		query.append("                			#if (${rdtype} == 'E')" ).append("\n"); 
		query.append("                                AND  T.RD_FLG = 'N'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${rdtype} == 'O')" ).append("\n"); 
		query.append("                                AND  T.RD_FLG = 'Y'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                              /* soc */" ).append("\n"); 
		query.append("                			#if (${soc} == 'E')" ).append("\n"); 
		query.append("                                AND  T.SOC_FLG  = 'N'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                			#if (${soc} == 'O')" ).append("\n"); 
		query.append("                                AND  T.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("                			#end" ).append("\n"); 
		query.append("                      ) A" ).append("\n"); 
		query.append("                    , (SELECT LEVEL BND FROM DUAL CONNECT BY LEVEL<=2) B" ).append("\n"); 
		query.append("                   WHERE 1=1      " ).append("\n"); 
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
		query.append("                                   " ).append("\n"); 
		query.append("                   GROUP BY BND" ).append("\n"); 
		query.append("                    ,DECODE(B.BND,1," ).append("\n"); 
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
		query.append("							 )" ).append("\n"); 
		query.append("                            ,DSP_SEQ" ).append("\n"); 
		query.append("                            ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            ,TGT_DT" ).append("\n"); 
		query.append("       )                                                                         " ).append("\n"); 
		query.append("     GROUP BY GROUPING SETS((DECODE(BND,1,LOC1,2,LOC2,''),DECODE(BND,1,LOC2,2,LOC1,''),DSP_SEQ,CNTR_TPSZ_CD,TGT_DT)" ).append("\n"); 
		query.append("                           ,(DECODE(BND,1,LOC1,2,LOC2,''),DECODE(BND,1,LOC2,2,LOC1,''))" ).append("\n"); 
		query.append("                          )  " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LV_DATA1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         LOC1," ).append("\n"); 
		query.append("         LOC2," ).append("\n"); 
		query.append("         DSP_SEQ," ).append("\n"); 
		query.append("         CNTR_TPSZ_CD," ).append("\n"); 
		query.append("          DECODE(BND, 1, CNT1, 2, CNT2, '') CNT " ).append("\n"); 
		query.append("         ,TGT_DT" ).append("\n"); 
		query.append("         ,BND" ).append("\n"); 
		query.append("    FROM LV_DATA0 A" ).append("\n"); 
		query.append("        ,(SELECT LEVEL BND FROM DUAL CONNECT BY LEVEL<=2) B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	'LocTrend' AS YARD_CD" ).append("\n"); 
		query.append("    ,DECODE(BND,1,LOC1,2,LOC2,'TOTAL')    			AS LOC_CD " ).append("\n"); 
		query.append("    ,DECODE(BND,1,LOC2,2,LOC1,'TOTAL')    			AS VVD    " ).append("\n"); 
		query.append("    ,DECODE(CNTR_TPSZ_CD,'99','TOTAL',CNTR_TPSZ_CD) AS TP_SZ" ).append("\n"); 
		query.append("	,BND AS DIVISION" ).append("\n"); 
		query.append("    ,SUM(CNT) 						  AS TOTAL" ).append("\n"); 
		query.append("	#if (${week_list} != '')" ).append("\n"); 
		query.append("		#foreach ($user_week IN ${weekLists})" ).append("\n"); 
		query.append("		#set( $num = $velocityCount - 1 )" ).append("\n"); 
		query.append("	    ,SUM(DECODE(TGT_DT,YMW$velocityCount,CNT,0)) AS QTY_$num" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append(" LV_DATA1 A" ).append("\n"); 
		query.append(",LV_YMD B " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TGT_DT !='999912'" ).append("\n"); 
		query.append("GROUP BY LOC1,LOC2,BND,CNTR_TPSZ_CD,DSP_SEQ" ).append("\n"); 
		query.append("ORDER BY LOC1||LOC2||BND||DSP_SEQ" ).append("\n"); 

	}
}