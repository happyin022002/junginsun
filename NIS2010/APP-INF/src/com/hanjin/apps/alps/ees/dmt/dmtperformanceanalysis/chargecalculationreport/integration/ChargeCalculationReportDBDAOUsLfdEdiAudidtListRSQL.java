/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationReportDBDAOUsLfdEdiAudidtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAOUsLfdEdiAudidtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationReportDBDAOUsLfdEdiAudidtListVORSQL
	  * </pre>
	  */
	public ChargeCalculationReportDBDAOUsLfdEdiAudidtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loce_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAOUsLfdEdiAudidtListRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_NO,CNTR_TPSZ_CD,YD_CD,GNTE_FLG,DECODE(GNTE_FLG,'N','',GNTE_DT) GNTE_DT," ).append("\n"); 
		query.append("       EVNT_DT,RECE_DT,BKG_NO,ALPS_BKG_NO,FT_END_DT,DMDT_TRF_CD,VVD,BKG_FLG,DAYS,RESULT,GND_TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SIF.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("    ( SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = SIF.EQ_NO ) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    SIF.NOD_CD AS YD_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ( SELECT DECODE(COUNT(*),1,'N','Y') FROM SCE_EDI_DIR_IF A" ).append("\n"); 
		query.append("         WHERE EQ_NO = SIF.EQ_NO" ).append("\n"); 
		query.append("           AND NOD_CD = SIF.NOD_CD" ).append("\n"); 
		query.append("           AND BL_EDI_322_NO = SIF.BL_EDI_322_NO" ).append("\n"); 
		query.append("           AND EDI_STS_CD = SIF.EDI_STS_CD" ).append("\n"); 
		query.append("           AND CRE_DT <= SIF.CRE_DT ) GNTE_FLG," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    TO_CHAR(SIF.EVNT_DT, 'YYYY-MM-DD') GNTE_DT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    ( SELECT TO_CHAR(A.EVNT_DT, 'YYYY-MM-DD') FROM SCE_EDI_DIR_IF A" ).append("\n"); 
		query.append("         WHERE EQ_NO = SIF.EQ_NO" ).append("\n"); 
		query.append("           AND NOD_CD = SIF.NOD_CD" ).append("\n"); 
		query.append("           AND BL_EDI_322_NO = SIF.BL_EDI_322_NO" ).append("\n"); 
		query.append("           AND EDI_STS_CD = SIF.EDI_STS_CD" ).append("\n"); 
		query.append("           AND CRE_DT = ( SELECT MIN(CRE_DT) FROM SCE_EDI_DIR_IF " ).append("\n"); 
		query.append("                           WHERE EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("                             AND NOD_CD = A.NOD_CD" ).append("\n"); 
		query.append("                             AND BL_EDI_322_NO = A.BL_EDI_322_NO" ).append("\n"); 
		query.append("                             AND EDI_STS_CD = A.EDI_STS_CD ) ) EVNT_DT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    TO_CHAR(SIF.CRE_DT, 'YYYY-MM-DD hh24:mm') RECE_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SIF.BL_EDI_322_NO AS BKG_NO," ).append("\n"); 
		query.append("    MAIN.ALPS_BKG_NO," ).append("\n"); 
		query.append("    TO_CHAR(MAIN.FT_END_DT, 'YYYY-MM-DD') FT_END_DT," ).append("\n"); 
		query.append("    MAIN.DMDT_TRF_CD," ).append("\n"); 
		query.append("    MAIN.VVD," ).append("\n"); 
		query.append("	CASE WHEN SIF.BL_EDI_322_NO != MAIN.ALPS_BKG_NO THEN 'Y' ELSE 'N' END BKG_FLG," ).append("\n"); 
		query.append("    NVL((TO_DATE(TO_CHAR(SIF.EVNT_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(MAIN.FT_END_DT,'YYYYMMDD'),'YYYYMMDD')),'') AS Days," ).append("\n"); 
		query.append("    DECODE(SIGN((TO_DATE(TO_CHAR(SIF.EVNT_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(MAIN.FT_END_DT,'YYYYMMDD'),'YYYYMMDD'))),0,'Coincidence','Descripency') AS Result," ).append("\n"); 
		query.append("       ( SELECT COUNT(*) FROM SCE_EDI_DIR_IF AAA" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("#if( ${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("			AND CRE_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("            AND CRE_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND EVNT_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("            AND EVNT_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND EDI_STS_CD = 'NF'" ).append("\n"); 
		query.append("            AND EXISTS ( SELECT /*+ INDEX(A XPKMDM_YARD) */ 'Y' FROM MDM_YARD A WHERE AAA.NOD_CD = YD_CD AND YD_FCTY_TP_MRN_TML_FLG = 'Y' )" ).append("\n"); 
		query.append("		) AS GND_TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT SF.EQ_NO AS CNTR_NO," ).append("\n"); 
		query.append("       SF.NOD_CD AS YD_CD, " ).append("\n"); 
		query.append("       SF.BL_EDI_322_NO AS BKG_NO," ).append("\n"); 
		query.append("       B.BKG_NO AS ALPS_BKG_NO," ).append("\n"); 
		query.append("       A.FT_END_DT," ).append("\n"); 
		query.append("       A.DMDT_TRF_CD," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B, SCE_EDI_DIR_IF SF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("AND SF.CRE_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND SF.CRE_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SF.EVNT_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND SF.EVNT_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${loce_cd} != '')" ).append("\n"); 
		query.append("AND SF.NOD_CD LIKE NVL(@[yd_cd],@[loce_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${bkg_no} != '')" ).append("\n"); 
		query.append("AND SF.BL_EDI_322_NO IN (" ).append("\n"); 
		query.append("        		#foreach( $an_bkg_no in ${bkg_no_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $bkg_no_list.size()) '$an_bkg_no', #else '$an_bkg_no' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${cntr_no} != '')" ).append("\n"); 
		query.append("AND SF.EQ_NO IN (" ).append("\n"); 
		query.append("        		#foreach( $an_cntr_no in ${cntr_no_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $cntr_no_list.size()) '$an_cntr_no', #else '$an_cntr_no' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SF.EDI_STS_CD = 'NF'" ).append("\n"); 
		query.append("AND EXISTS ( SELECT /*+ INDEX(A XPKMDM_YARD) */ 'Y' FROM MDM_YARD A WHERE SF.NOD_CD = YD_CD AND YD_FCTY_TP_MRN_TML_FLG = 'Y' )" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 
		query.append("AND B.BKG_NO LIKE SUBSTR(SF.BL_EDI_322_NO,1,10)||'%'" ).append("\n"); 
		query.append("AND B.CNTR_NO = SF.EQ_NO" ).append("\n"); 
		query.append("AND A.FM_MVMT_YD_CD = SF.NOD_CD" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD IN ( 'DMIF','CTIC' )" ).append("\n"); 
		query.append("AND A.FM_MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != 'All' && ${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND B.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("        		#foreach( $an_cntr_tpsz_cd in ${cntr_tpsz_cd_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $cntr_tpsz_cd_list.size()) '$an_cntr_tpsz_cd', #else '$an_cntr_tpsz_cd' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${result} != 'A' && ${result} != '')" ).append("\n"); 
		query.append("	AND DECODE(SIGN((TO_DATE(TO_CHAR(SF.EVNT_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(A.FT_END_DT,'YYYYMMDD'),'YYYYMMDD'))),0,'C','D') IN (" ).append("\n"); 
		query.append("        		#foreach( $an_result in ${result_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $result_list.size()) '$an_result', #else '$an_result' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") MAIN, SCE_EDI_DIR_IF SIF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("AND SIF.CRE_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND SIF.CRE_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SIF.EVNT_DT > TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND SIF.EVNT_DT < TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${loce_cd} != '')" ).append("\n"); 
		query.append("AND SIF.NOD_CD LIKE NVL(@[yd_cd],@[loce_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${bkg_no} != '')" ).append("\n"); 
		query.append("AND SIF.BL_EDI_322_NO IN (" ).append("\n"); 
		query.append("        		#foreach( $an_bkg_no in ${bkg_no_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $bkg_no_list.size()) '$an_bkg_no', #else '$an_bkg_no' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${cntr_no} != '')" ).append("\n"); 
		query.append("AND SIF.EQ_NO IN (" ).append("\n"); 
		query.append("        		#foreach( $an_cntr_no in ${cntr_no_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $cntr_no_list.size()) '$an_cntr_no', #else '$an_cntr_no' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SIF.EDI_STS_CD = 'NF'" ).append("\n"); 
		query.append("AND EXISTS ( SELECT /*+ INDEX(A XPKMDM_YARD) */  'Y' FROM MDM_YARD A WHERE SIF.NOD_CD = YD_CD AND YD_FCTY_TP_MRN_TML_FLG = 'Y' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND MAIN.BKG_NO(+) = SIF.BL_EDI_322_NO" ).append("\n"); 
		query.append("AND MAIN.CNTR_NO(+) = SIF.EQ_NO" ).append("\n"); 
		query.append("AND MAIN.YD_CD(+) = SIF.NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${latest} == 'Y')" ).append("\n"); 
		query.append("      AND SIF.CRE_DT = ( SELECT CRE_DT FROM SCE_EDI_DIR_IF A" ).append("\n"); 
		query.append("                          WHERE EQ_NO = SIF.EQ_NO" ).append("\n"); 
		query.append("                            AND NOD_CD = SIF.NOD_CD" ).append("\n"); 
		query.append("                            AND BL_EDI_322_NO = SIF.BL_EDI_322_NO" ).append("\n"); 
		query.append("                            AND EDI_STS_CD = SIF.EDI_STS_CD" ).append("\n"); 
		query.append("                            AND CRE_DT = ( SELECT MAX(CRE_DT) FROM SCE_EDI_DIR_IF " ).append("\n"); 
		query.append("                                            WHERE EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("                                              AND NOD_CD = A.NOD_CD" ).append("\n"); 
		query.append("                                              AND BL_EDI_322_NO = A.BL_EDI_322_NO" ).append("\n"); 
		query.append("                                              AND EDI_STS_CD = A.EDI_STS_CD ) ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != 'All' && ${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("        		#foreach( $an_cntr_tpsz_cd in ${cntr_tpsz_cd_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $cntr_tpsz_cd_list.size()) '$an_cntr_tpsz_cd', #else '$an_cntr_tpsz_cd' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${result} != 'A' && ${result} != '')" ).append("\n"); 
		query.append("	AND DECODE(Result,'Coincidence','C','D') IN (" ).append("\n"); 
		query.append("        		#foreach( $an_result in ${result_list} )" ).append("\n"); 
		query.append("        			#if($velocityCount < $result_list.size()) '$an_result', #else '$an_result' #end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${event_receive} == 'RECEIVE')" ).append("\n"); 
		query.append("ORDER BY 1,7" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY 1,6" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}