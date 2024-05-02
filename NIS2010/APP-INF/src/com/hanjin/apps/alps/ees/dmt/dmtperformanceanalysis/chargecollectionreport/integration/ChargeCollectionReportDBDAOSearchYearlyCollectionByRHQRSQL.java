/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOSearchYearlyCollectionByRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOSearchYearlyCollectionByRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년도, RHQ 별로 Collection 대상을 조회한다.
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOSearchYearlyCollectionByRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOSearchYearlyCollectionByRHQRSQL").append("\n"); 
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
		query.append("SELECT COVER.* FROM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("( SELECT  OFC_CD, DMDT_TRF_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		-- Won Ki Eo 추가" ).append("\n"); 
		query.append("		, BZC_TRF_CURR_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', INCR_QTY         , 0)), 2) AS G015_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', INCR_AMT / XCH_RT, 0)), 2) AS G015_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', EXPT_QTY         , 0)), 2) AS G015_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', EXPT_AMT / XCH_RT, 0)), 2) AS G015_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', DCNT_QTY         , 0)), 2) AS G015_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', DCNT_AMT / XCH_RT, 0)), 2) AS G015_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', BILL_QTY         , 0)), 2) AS G015_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G015', BILL_AMT / XCH_RT, 0)), 2) AS G015_BILL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', INCR_QTY         , 0)), 2) AS G030_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', INCR_AMT / XCH_RT, 0)), 2) AS G030_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', EXPT_QTY         , 0)), 2) AS G030_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', EXPT_AMT / XCH_RT, 0)), 2) AS G030_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', DCNT_QTY         , 0)), 2) AS G030_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', DCNT_AMT / XCH_RT, 0)), 2) AS G030_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', BILL_QTY         , 0)), 2) AS G030_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G030', BILL_AMT / XCH_RT, 0)), 2) AS G030_BILL_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', INCR_QTY         , 0)), 2) AS G060_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', INCR_AMT / XCH_RT, 0)), 2) AS G060_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', EXPT_QTY         , 0)), 2) AS G060_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', EXPT_AMT / XCH_RT, 0)), 2) AS G060_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', DCNT_QTY         , 0)), 2) AS G060_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', DCNT_AMT / XCH_RT, 0)), 2) AS G060_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', BILL_QTY         , 0)), 2) AS G060_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G060', BILL_AMT / XCH_RT, 0)), 2) AS G060_BILL_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', INCR_QTY         , 0)), 2) AS G090_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', INCR_AMT / XCH_RT, 0)), 2) AS G090_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', EXPT_QTY         , 0)), 2) AS G090_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', EXPT_AMT / XCH_RT, 0)), 2) AS G090_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', DCNT_QTY         , 0)), 2) AS G090_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', DCNT_AMT / XCH_RT, 0)), 2) AS G090_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', BILL_QTY         , 0)), 2) AS G090_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G090', BILL_AMT / XCH_RT, 0)), 2) AS G090_BILL_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', INCR_QTY         , 0)), 2) AS G180_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', INCR_AMT / XCH_RT, 0)), 2) AS G180_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', EXPT_QTY         , 0)), 2) AS G180_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', EXPT_AMT / XCH_RT, 0)), 2) AS G180_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', DCNT_QTY         , 0)), 2) AS G180_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', DCNT_AMT / XCH_RT, 0)), 2) AS G180_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', BILL_QTY         , 0)), 2) AS G180_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G180', BILL_AMT / XCH_RT, 0)), 2) AS G180_BILL_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', INCR_QTY         , 0)), 2) AS G181_INCR_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', INCR_AMT / XCH_RT, 0)), 2) AS G181_INCR_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', EXPT_QTY         , 0)), 2) AS G181_EXPT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', EXPT_AMT / XCH_RT, 0)), 2) AS G181_EXPT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', DCNT_QTY         , 0)), 2) AS G181_DCNT_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', DCNT_AMT / XCH_RT, 0)), 2) AS G181_DCNT_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', BILL_QTY         , 0)), 2) AS G181_BILL_QTY" ).append("\n"); 
		query.append("        , ROUND(SUM(DECODE(GD, 'G181', BILL_AMT / XCH_RT, 0)), 2) AS G181_BILL_AMT   " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT    " ).append("\n"); 
		query.append("                  #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("        			 DECODE(C.OFC_RHQ_CD, 'NYCHQ', 'NYCRA', C.OFC_RHQ_CD)" ).append("\n"); 
		query.append("        		  #else" ).append("\n"); 
		query.append("        			 C.OFC_CD" ).append("\n"); 
		query.append("        		  #end" ).append("\n"); 
		query.append("        		  AS OFC_CD" ).append("\n"); 
		query.append("                , C.DMDT_TRF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- WONKI_EO추가" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("		  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("			'USD'" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			C.BZC_TRF_CURR_CD " ).append("\n"); 
		query.append("		  END " ).append("\n"); 
		query.append("			AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , C.ORG_CHG_AMT       AS INCR_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.ORG_CHG_AMT,     0), 0, 0, 1) INCR_QTY" ).append("\n"); 
		query.append("                , C.SC_RFA_EXPT_AMT   AS EXPT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.SC_RFA_EXPT_AMT, 0), 0, 0, 1) EXPT_QTY" ).append("\n"); 
		query.append("                , C.AFT_EXPT_DC_AMT   AS DCNT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.AFT_EXPT_DC_AMT, 0), 0, 0, 1) DCNT_QTY" ).append("\n"); 
		query.append("                , C.BIL_AMT           AS BILL_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.BIL_AMT,         0), 0, 0, 1) BILL_QTY" ).append("\n"); 
		query.append("                , CASE" ).append("\n"); 
		query.append("                  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        FROM    GL_MON_XCH_RT S" ).append("\n"); 
		query.append("                        WHERE   S.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("                        AND     S.CURR_CD           = C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                        AND     S.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                        1" ).append("\n"); 
		query.append("                  END               AS XCH_RT" ).append("\n"); 
		query.append("                , CASE " ).append("\n"); 
		query.append(" 				  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  15 THEN  'G015'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  30 THEN  'G030'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  60 THEN  'G060'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  90 THEN  'G090'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') <= 180 THEN  'G180'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.FT_END_DT, 'YYYYMMDD'), 'YYYYMMDD') >= 181 THEN  'G181'" ).append("\n"); 
		query.append("                  END AS GD" ).append("\n"); 
		query.append("        FROM    DMT_CHG_CALC        C," ).append("\n"); 
		query.append("                DMT_CHG_BKG_CNTR	B," ).append("\n"); 
		query.append("                BKG_BOOKING         T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND		C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("		AND		C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND		B.BKG_NO			= T1.BKG_NO" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_STS_CD  	= 'L'" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("        AND     C.FM_MVMT_DT BETWEEN TO_DATE(@[f_year]||'0101', 'YYYYMMDD') AND TO_DATE(@[f_year]||'1231', 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        AND     ( (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("                  OR (C.DUL_TP_EXPT_FLG = 'N'))" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("        --DEM/DET Office          " ).append("\n"); 
		query.append("        #if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("        AND		C.OFC_CD  IN (" ).append("\n"); 
		query.append("                        		#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("                        			#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("                        		#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        #elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("        AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --UC" ).append("\n"); 
		query.append("        #if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("        AND     NVL(C.UCLM_FLG, 'N') =  @[uclm_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --TARIFF TYPE" ).append("\n"); 
		query.append("        AND		C.DMDT_TRF_CD  IN	(		/*_________ MULTI TARIFF TYPE	*/" ).append("\n"); 
		query.append("                            			#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("                            		" ).append("\n"); 
		query.append("        --CNTR TYPE" ).append("\n"); 
		query.append("        AND		B.DMDT_CNTR_TP_CD	IN (" ).append("\n"); 
		query.append("                        					#foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("                        						#if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("                        							'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("                        						#elseif ($cntr_tp == 'D' || $cntr_tp == 'R')" ).append("\n"); 
		query.append("                        							'$cntr_tp'" ).append("\n"); 
		query.append("                        						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        						#if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("                        					#end" ).append("\n"); 
		query.append("                        				)" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        --Status" ).append("\n"); 
		query.append("        AND		C.DMDT_CHG_STS_CD  IN	(	" ).append("\n"); 
		query.append("                            			#foreach( $sts_cd in ${status_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $status_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("                            		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT    " ).append("\n"); 
		query.append("                  #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("        			 DECODE(C.OFC_RHQ_CD, 'NYCHQ', 'NYCRA', C.OFC_RHQ_CD)" ).append("\n"); 
		query.append("        		  #else" ).append("\n"); 
		query.append("        			 C.OFC_CD" ).append("\n"); 
		query.append("        		  #end" ).append("\n"); 
		query.append("        		  AS OFC_CD" ).append("\n"); 
		query.append("                , C.DMDT_TRF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- WONKI_EO추가" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("		  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("			'USD'" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			C.BZC_TRF_CURR_CD " ).append("\n"); 
		query.append("		  END " ).append("\n"); 
		query.append("			AS BZC_TRF_CURR_CD             " ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("				, C.ORG_CHG_AMT       AS INCR_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.ORG_CHG_AMT,     0), 0, 0, 1) INCR_QTY" ).append("\n"); 
		query.append("                , C.SC_RFA_EXPT_AMT   AS EXPT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.SC_RFA_EXPT_AMT, 0), 0, 0, 1) EXPT_QTY" ).append("\n"); 
		query.append("                , C.AFT_EXPT_DC_AMT   AS DCNT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.AFT_EXPT_DC_AMT, 0), 0, 0, 1) DCNT_QTY" ).append("\n"); 
		query.append("                , C.BIL_AMT           AS BILL_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.BIL_AMT,         0), 0, 0, 1) BILL_QTY" ).append("\n"); 
		query.append("				, CASE" ).append("\n"); 
		query.append("                  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        FROM    GL_MON_XCH_RT S" ).append("\n"); 
		query.append("                        WHERE   S.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("                        AND     S.CURR_CD           = C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                        AND     S.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                        1" ).append("\n"); 
		query.append("                  END               AS XCH_RT" ).append("\n"); 
		query.append("                , CASE " ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  15 THEN  'G015'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  30 THEN  'G030'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  60 THEN  'G060'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  90 THEN  'G090'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <= 180 THEN  'G180'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') >= 181 THEN  'G181'" ).append("\n"); 
		query.append("                  END AS GD" ).append("\n"); 
		query.append("        FROM    DMT_CHG_CALC        C," ).append("\n"); 
		query.append("                DMT_CHG_BKG_CNTR	B," ).append("\n"); 
		query.append("                BKG_BOOKING         T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND		C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("		AND		C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND		B.BKG_NO			= T1.BKG_NO" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_STS_CD IN ('F', 'C')" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("        AND     C.TO_MVMT_DT BETWEEN TO_DATE(@[f_year]||'0101', 'YYYYMMDD') AND TO_DATE(@[f_year]||'1231', 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        AND     ( (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("                  OR (C.DUL_TP_EXPT_FLG = 'N') )" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("        --DEM/DET Office" ).append("\n"); 
		query.append("        #if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("        AND		C.OFC_CD IN (" ).append("\n"); 
		query.append("                        		#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("                        			#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("                        		#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        #elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("        AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --UC" ).append("\n"); 
		query.append("        #if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("        AND     NVL(C.UCLM_FLG, 'N') =  @[uclm_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --TARIFF TYPE" ).append("\n"); 
		query.append("        AND		C.DMDT_TRF_CD	IN	(		/*_________ MULTI TARIFF TYPE	*/" ).append("\n"); 
		query.append("                            			#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("                            		" ).append("\n"); 
		query.append("        --CNTR TYPE" ).append("\n"); 
		query.append("        AND		B.DMDT_CNTR_TP_CD	IN (" ).append("\n"); 
		query.append("                        					#foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("                        						#if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("                        							'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("                        						#elseif ($cntr_tp == 'D' || $cntr_tp == 'R')" ).append("\n"); 
		query.append("                        							'$cntr_tp'" ).append("\n"); 
		query.append("                        						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        						#if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("                        					#end" ).append("\n"); 
		query.append("                        				)" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        --Status" ).append("\n"); 
		query.append("        AND		C.DMDT_CHG_STS_CD  IN	(	" ).append("\n"); 
		query.append("                            			#foreach( $sts_cd in ${status_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $status_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT    " ).append("\n"); 
		query.append("                  #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("        			 DECODE(C.OFC_RHQ_CD, 'NYCHQ', 'NYCRA', C.OFC_RHQ_CD)" ).append("\n"); 
		query.append("        		  #else" ).append("\n"); 
		query.append("        			 C.OFC_CD" ).append("\n"); 
		query.append("        		  #end" ).append("\n"); 
		query.append("        		  AS OFC_CD" ).append("\n"); 
		query.append("                , C.DMDT_TRF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- WONKI_EO추가" ).append("\n"); 
		query.append("		, CASE" ).append("\n"); 
		query.append("		  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("			'USD'" ).append("\n"); 
		query.append("		  ELSE" ).append("\n"); 
		query.append("			C.BZC_TRF_CURR_CD " ).append("\n"); 
		query.append("		  END " ).append("\n"); 
		query.append("			AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , C.ORG_CHG_AMT       AS INCR_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.ORG_CHG_AMT,     0), 0, 0, 1) INCR_QTY" ).append("\n"); 
		query.append("                , C.SC_RFA_EXPT_AMT   AS EXPT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.SC_RFA_EXPT_AMT, 0), 0, 0, 1) EXPT_QTY" ).append("\n"); 
		query.append("                , C.AFT_EXPT_DC_AMT   AS DCNT_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.AFT_EXPT_DC_AMT, 0), 0, 0, 1) DCNT_QTY" ).append("\n"); 
		query.append("                , C.BIL_AMT           AS BILL_AMT" ).append("\n"); 
		query.append("                , DECODE(NVL(C.BIL_AMT,         0), 0, 0, 1) BILL_QTY" ).append("\n"); 
		query.append("                , CASE" ).append("\n"); 
		query.append("                  WHEN  @[curr_flg] = 'U' THEN" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        FROM    GL_MON_XCH_RT S" ).append("\n"); 
		query.append("                        WHERE   S.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("                        AND     S.CURR_CD           = C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                        AND     S.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                        1" ).append("\n"); 
		query.append("                  END               AS XCH_RT" ).append("\n"); 
		query.append("                , CASE " ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  15 THEN  'G015'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  30 THEN  'G030'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  60 THEN  'G060'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <=  90 THEN  'G090'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') <= 180 THEN  'G180'" ).append("\n"); 
		query.append("                  WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD'), 'YYYYMMDD') >= 181 THEN  'G181'" ).append("\n"); 
		query.append("                  END AS GD" ).append("\n"); 
		query.append("        FROM    DMT_CHG_CALC        C," ).append("\n"); 
		query.append("                DMT_CHG_BKG_CNTR	B," ).append("\n"); 
		query.append("                BKG_BOOKING         T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND		C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("		AND		C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("		AND		B.BKG_NO			= T1.BKG_NO" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_STS_CD  = 'I'" ).append("\n"); 
		query.append("        AND     C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("        AND     C.TO_MVMT_DT BETWEEN TO_DATE(@[f_year]||'0101', 'YYYYMMDD') AND TO_DATE(@[f_year]||'1231', 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        AND     ( (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("                  OR (C.DUL_TP_EXPT_FLG = 'N') )" ).append("\n"); 
		query.append("        AND     EXISTS  (SELECT 1 FROM  DMT_INV_MN S WHERE S.DMDT_INV_NO = C.DMDT_INV_NO AND DMDT_AR_IF_CD != 'Y' AND ROWNUM=1)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --DEM/DET Office" ).append("\n"); 
		query.append("        #if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("        AND		C.OFC_CD IN (" ).append("\n"); 
		query.append("                        		#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("                        			#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("                        		#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        #elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("        AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --UC" ).append("\n"); 
		query.append("        #if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("        AND     NVL(C.UCLM_FLG, 'N') =  @[uclm_flg]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --TARIFF TYPE" ).append("\n"); 
		query.append("        AND		C.DMDT_TRF_CD	IN	(		/*_________ MULTI TARIFF TYPE	*/" ).append("\n"); 
		query.append("                            			#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("        --CNTR TYPE" ).append("\n"); 
		query.append("        AND		B.DMDT_CNTR_TP_CD	IN (" ).append("\n"); 
		query.append("                        					#foreach( $cntr_tp in ${cntr_tp_list} )" ).append("\n"); 
		query.append("                        						#if ($cntr_tp == 'S')" ).append("\n"); 
		query.append("                        							'F', 'O', 'T', 'P', 'S', 'A'" ).append("\n"); 
		query.append("                        						#elseif ($cntr_tp == 'D' || $cntr_tp == 'R')" ).append("\n"); 
		query.append("                        							'$cntr_tp'" ).append("\n"); 
		query.append("                        						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        						#if($velocityCount < $cntr_tp_list.size()) , #end" ).append("\n"); 
		query.append("                        					#end" ).append("\n"); 
		query.append("                        				)   " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        --Status" ).append("\n"); 
		query.append("        AND		C.DMDT_CHG_STS_CD  IN	(	" ).append("\n"); 
		query.append("                            			#foreach( $sts_cd in ${status_list} )" ).append("\n"); 
		query.append("                            				#if($velocityCount < $status_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("                            			#end" ).append("\n"); 
		query.append("                            		)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ) T" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BILL_AMT > 0" ).append("\n"); 
		query.append("--GROUP BY GROUPING SETS ((OFC_CD, DMDT_TRF_CD), ())" ).append("\n"); 
		query.append("GROUP BY ROLLUP(OFC_CD, BZC_TRF_CURR_CD, DMDT_TRF_CD)" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") COVER" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Currency = Local 일 경우 Last Row의 Total 제외" ).append("\n"); 
		query.append("#if (${curr_flg} != 'U')" ).append("\n"); 
		query.append("	AND     COVER.BZC_TRF_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}