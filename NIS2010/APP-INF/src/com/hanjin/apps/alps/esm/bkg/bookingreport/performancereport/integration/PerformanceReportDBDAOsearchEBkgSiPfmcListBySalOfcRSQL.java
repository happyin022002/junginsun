/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListBySalOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchEBkgSiPfmcListBySalOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0227 : e-Booking & S/I Performance Report
	  * e-Booking & S/I 실적 조회 기능
	  * [Reportkind= 'SalesOffice']
	  * * 2012.02.15 김보배 [CHM-201216103] [BKG] e-SI PFMC Report 수정 요청
	  * * 2013.01.18 김진주 [CHM-201322383] [eSVC PFMC report] 평가 기준 변경 요청
	  * * 2013.03.11 임재관 [CHM-201323202] e-SVC Performance Report 항목 분리 요청
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchEBkgSiPfmcListBySalOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sal_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListBySalOfcRSQL").append("\n"); 
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
		query.append("--e-Booking & S/I 실적 조회 " ).append("\n"); 
		query.append("--2.Case1 => Kind of Report = Sales Office, Kind of Report = Month" ).append("\n"); 
		query.append("--REPORT_TYPE:SALES, DURATION: M,W,D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--********************************************************************************************" ).append("\n"); 
		query.append("--Month,WEEK" ).append("\n"); 
		query.append("--********************************************************************************************" ).append("\n"); 
		query.append("SELECT	SUB.*" ).append("\n"); 
		query.append("	,CASE WHEN (SI_TTL - ( BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB )) > 0 THEN (SI_TTL - (BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB ))" ).append("\n"); 
		query.append("	 ELSE 0 END BL_PENDING" ).append("\n"); 
		query.append("	,ROUND(((BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL+BL_WEB_SWB ) / DECODE((BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL +BL_WEB_SWB+ (CASE WHEN (SI_TTL - ( BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB )) > 0 THEN (SI_TTL - (BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB ))" ).append("\n"); 
		query.append("ELSE 0 END)),0,1,(BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + (CASE WHEN (SI_TTL - ( BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB )) > 0 THEN (SI_TTL - (BL_NIS + BL_EDI + BL_WEB_OBL + BL_SWB_EMAIL + BL_WEB_SWB ))" ).append("\n"); 
		query.append("ELSE 0 END) +BL_WEB_SWB)))*100,1) BL_SVC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("#if (${duration_opt} == 'M' or ${duration_opt} == 'W' ) " ).append("\n"); 
		query.append("/*+ INDEX(MON XAK4MAS_MON_VVD) */ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		'SR' REPORT_TYPE" ).append("\n"); 
		query.append("		,OL.REGION   REGION_CD" ).append("\n"); 
		query.append("		,OL.GSO GSO                                                                          " ).append("\n"); 
		query.append("      	,BK.OB_SLS_OFC_CD OFC_CD" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append("	  ,MON.COST_WK  DURATION" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  ,SUBSTR(MON.COST_YRMON, 1, 4)   || SUBSTR(MON.COST_YRMON, 5, 2)  DURATION" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("		,COUNT(*) BKG_TTL" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'NIS', 1, 0)) BKG_NIS " ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'EDI', 1, 0)) BKG_EDI" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'WEB', 1, 0)) BKG_WEB" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'SIM', 1, 0)) BKG_SIM" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'GTN', 1, 0)) BKG_GTN" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'DSK', 1, 0)) BKG_DESKTOP" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'INT', 1, 0)) BKG_INTTRA" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'CSM', 1, 0)) BKG_CSM" ).append("\n"); 
		query.append("		,CASE WHEN SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'EDI', 1,'SEA',1,'DAK',1,0))+SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'WEB', 1, 0))" ).append("\n"); 
		query.append("					+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'GTN', 1, 0)) + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'DSK', 1, 0))" ).append("\n"); 
		query.append("					+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'INT', 1, 0)) + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'CSM', 1, 0))" ).append("\n"); 
		query.append("					+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'SIM', 1, 0)) =0 THEN '0.0' " ).append("\n"); 
		query.append("  			 ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'EDI', 1,'SEA',1,'DAK',1,0))+SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'WEB', 1, 0))" ).append("\n"); 
		query.append("					+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'GTN', 1, 0)) + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'DSK', 1, 0))" ).append("\n"); 
		query.append("					+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'INT', 1, 0)) + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'CSM', 1, 0))" ).append("\n"); 
		query.append("				 	+ SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'SIM', 1, 0)) ) /   COUNT(*) *100,'99990.9')) END  BKG_SVC" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'EDI', 1,'SEA',1,'DAK',1,0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'WEB', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'DSK', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'SIM', 1, 0)) " ).append("\n"); 
		query.append("                 = 0 THEN '0.0'" ).append("\n"); 
		query.append("              ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'EDI', 1,'SEA',1,'DAK',1,0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'WEB', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'DSK', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'SIM', 1, 0))) / COUNT(*) *100, '99990.9'))" ).append("\n"); 
		query.append("         END BKG_HJSTOOLS" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'GTN', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'INT', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'CSM', 1, 0)) " ).append("\n"); 
		query.append("                 = 0 THEN '0.0'" ).append("\n"); 
		query.append("              ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'GTN', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'INT', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'CSM', 1, 0))) / COUNT(*) *100, '99990.9'))" ).append("\n"); 
		query.append("         END BKG_PORTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,COUNT(*) SI_TTL" ).append("\n"); 
		query.append("        ,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'NIS', 1, 'FAX', 1, 0)) SI_NIS" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EDI', 1, 0)) SI_EDI" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EML', 1, 0)) SI_EML" ).append("\n"); 
		query.append("        ,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'ULD', 1, 0)) SI_ULD" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'WEB', 1, 0)) SI_WEB" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'GTN', 1, 0)) SI_GTN" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'DSK', 1, 0)) SI_DESKTOP" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'INT', 1, 0)) SI_INTTRA" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'CSM', 1, 0)) SI_CSM" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'SIM', 1, 0)) SI_SIM" ).append("\n"); 
		query.append("		,CASE WHEN SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EDI', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'WEB', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'GTN', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'DSK', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'INT', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'CSM', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'SIM', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EML', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'ULD', 1, 0)) = 0 THEN '0.0'" ).append("\n"); 
		query.append("   			ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EDI', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'WEB', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'GTN', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'DSK', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'INT', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'CSM', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'SIM', 1, 0))" ).append("\n"); 
		query.append("				 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EML', 1, 0)) + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'ULD', 1, 0))) /   COUNT(*) *100,'99990.9')) END SI_SVC" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EDI', 1, 'SEA', 1, 'DAK', 1, 0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'WEB', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'DSK', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'SIM', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EML', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'ULD', 1, 0))" ).append("\n"); 
		query.append("                 = 0 THEN '0.0'" ).append("\n"); 
		query.append("              ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EDI', 1, 'SEA', 1, 'DAK', 1, 0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'WEB', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'DSK', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'SIM', 1, 0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'EML', 1, 0))" ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'ULD', 1, 0))) / COUNT(*) *100, '99990.9'))" ).append("\n"); 
		query.append("         END SI_HJSTOOLS" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'GTN', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'INT', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'CSM', 1, 0)) " ).append("\n"); 
		query.append("                 = 0 THEN '0.0'" ).append("\n"); 
		query.append("              ELSE TRIM(TO_CHAR((SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'GTN', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'INT', 1, 0)) " ).append("\n"); 
		query.append("                 + SUM(DECODE(NVL(BK.XTER_SI_CD, 'NIS'), 'CSM', 1, 0))) / COUNT(*) *100, '99990.9'))" ).append("\n"); 
		query.append("         END SI_PORTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.BL_TP_CD,'O'),'O',1,0)) BL_TTL_OBL" ).append("\n"); 
		query.append("		,SUM(DECODE(NVL(BK.BL_TP_CD,'O'),'O',0,1)) BL_TTL_SWB" ).append("\n"); 
		query.append("        ,SUM(DECODE((" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1), null, DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT, null, DECODE(( -- 질문" ).append("\n"); 
		query.append("                            SELECT BKG_NO" ).append("\n"); 
		query.append("                            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                              AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                              AND ROWNUM = 1), NULL, DECODE(BS.OBL_PRN_FLG, 'Y', 1, 0), 0), 0), 0)) BL_NIS" ).append("\n"); 
		query.append("        ,SUM(DECODE((" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 ), NULL, 0, 1)) BL_EDI" ).append("\n"); 
		query.append("        ,SUM(DECODE((" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1), null, DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT, null, 0, DECODE(BK.BL_TP_CD, null, 1, 0)), 0)) BL_WEB_OBL" ).append("\n"); 
		query.append("        ,SUM(DECODE((" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1), null, DECODE(BII.WBL_PRN_DT, null, 0, DECODE(BK.BL_TP_CD, 'W', 1, 0)), 0)) BL_WEB_SWB" ).append("\n"); 
		query.append("        ,SUM(DECODE((" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1 ), null, DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT||BII.WBL_PRN_DT, null, DECODE((" ).append("\n"); 
		query.append("                            SELECT BKG_NO" ).append("\n"); 
		query.append("                            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                              AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                              AND ROWNUM = 1 ), NULL, 0, DECODE(BK.BL_TP_CD, 'W', 1, 0)), 0), 0)) BL_SWB_EMAIL" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("FROM  BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_BL_DOC BMO " ).append("\n"); 
		query.append("      ,BKG_BL_ISS BS" ).append("\n"); 
		query.append("	  ,BKG_OFC_LVL_V OL" ).append("\n"); 
		query.append("	  ,BKG_CUSTOMER BCS" ).append("\n"); 
		query.append("	  ,MAS_MON_VVD  MON" ).append("\n"); 
		query.append("	  ,MAS_RGST_BKG  SCI " ).append("\n"); 
		query.append(",BKG_INET_BL_PRN_AUTH BII	" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${duration_opt} == 'M' or ${duration_opt} == 'W' ) " ).append("\n"); 
		query.append("AND    BK.BKG_NO =SCI.BKG_NO  " ).append("\n"); 
		query.append("AND    MON.VSL_CD = SCI.VSL_CD" ).append("\n"); 
		query.append("AND    MON.SKD_VOY_NO = SCI.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    MON.DIR_CD = SCI.DIR_CD" ).append("\n"); 
		query.append("AND    mon.TRD_CD = sci.TRD_CD" ).append("\n"); 
		query.append("and    mon.RLANE_CD = sci.RLANE_CD" ).append("\n"); 
		query.append("and    mon.IOC_CD = sci.IOC_CD" ).append("\n"); 
		query.append("and    mon.WKY_TGT_FLG ='Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BK.BKG_NO =SCI.BKG_NO(+)  " ).append("\n"); 
		query.append("AND    MON.VSL_CD(+) = SCI.VSL_CD" ).append("\n"); 
		query.append("AND    MON.SKD_VOY_NO(+) = SCI.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    MON.DIR_CD(+) = SCI.DIR_CD" ).append("\n"); 
		query.append("AND    mon.TRD_CD(+) = sci.TRD_CD" ).append("\n"); 
		query.append("and    mon.RLANE_CD(+) = sci.RLANE_CD" ).append("\n"); 
		query.append("and    mon.IOC_CD(+) = sci.IOC_CD" ).append("\n"); 
		query.append("and    mon.WKY_TGT_FLG(+) ='Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zone_cd} == 'OCN') " ).append("\n"); 
		query.append("/*zone_cd OCN*/" ).append("\n"); 
		query.append("AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zone_cd} == 'IPT') " ).append("\n"); 
		query.append("/* zone_cd IPT*/" ).append("\n"); 
		query.append("AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zone_cd} == 'EUAF') " ).append("\n"); 
		query.append("/* zone_cd EUAF*/" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'Y' FROM MDM_LOCATION " ).append("\n"); 
		query.append("             WHERE LOC_CD = BK.POR_CD" ).append("\n"); 
		query.append("             AND CONTI_CD IN ('E','F')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'M') " ).append("\n"); 
		query.append("	 AND MON.COST_YRMON = NVL(@[duration_year] || NVL(@[duration_month],''), MON.COST_YRMON) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append("	 AND MON.COST_YRMON LIKE NVL(@[duration_year] || NVL(@[duration_month],'') || '%', MON.COST_YRMON) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append("	#if (${duration_from_week} != '') " ).append("\n"); 
		query.append("		AND    MON.COST_WK >= TRIM(TO_CHAR(NVL(@[duration_from_week], MON.COST_WK),'00'))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_week} != '')         " ).append("\n"); 
		query.append("        AND    MON.COST_WK <= TRIM(TO_CHAR(NVL(@[duration_to_week], MON.COST_WK),'00')) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'D') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("		AND	BK.BKG_CRE_DT  >= TO_DATE(@[duration_from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_dt} != '') " ).append("\n"); 
		query.append("		AND	BK.BKG_CRE_DT  <= TO_DATE(@[duration_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'B') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("		AND	BMO.BL_OBRD_DT  >= TO_DATE(@[duration_from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_dt} != '') " ).append("\n"); 
		query.append("		AND	BMO.BL_OBRD_DT  <= TO_DATE(@[duration_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("AND    MON.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    SCI.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("AND    SCI.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("--AND    (NVL(BK.XTER_BKG_RQST_CD,' ') != 'NIS' OR    NIS(BK.XTER_SI_CD,' ') != 'NIS')" ).append("\n"); 
		query.append("AND    BK.VSL_CD NOT IN ('SMXX','SMYY','SMZZ')" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("      	AND    BK.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("        AND    BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("        AND    BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sal_ofc} != '') " ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD = @[sal_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc} != '') " ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD = @[bkg_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("#if (${sc_rfa_type} == 'S') " ).append("\n"); 
		query.append("AND	  BK.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#elseif (${sc_rfa_type} == 'R') " ).append("\n"); 
		query.append("AND   BK.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD != 'X' " ).append("\n"); 
		query.append("AND    BK.BKG_CGO_TP_CD !='P'        " ).append("\n"); 
		query.append("AND    (BK.BL_NO_TP  = '0' OR BK.BL_NO_TP  IS NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD = OL.OFC_CD    ----" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BMO.BKG_NO" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BCS.BKG_NO " ).append("\n"); 
		query.append("AND    BK.BKG_NO = BII.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BII.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${region_cd} != '') " ).append("\n"); 
		query.append("AND    OL.REGION = @[region_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gso} != '') " ).append("\n"); 
		query.append("AND    OL.GSO = @[gso] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} != '') " ).append("\n"); 
		query.append("AND    BCS.BKG_CUST_TP_CD = @[bkg_cust_tp_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("AND    BCS.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("AND    BCS.CUST_SEQ LIKE @[cust_seq] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '') " ).append("\n"); 
		query.append("AND    BCS.CUST_NM LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${doc_usr_id} !='')" ).append("\n"); 
		query.append("	AND UPPER(BK.DOC_USR_ID) = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP  BY OL.REGION" ).append("\n"); 
		query.append(",	OL.GSO" ).append("\n"); 
		query.append(", BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append(",	MON.COST_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",   SUBSTR(MON.COST_YRMON, 1, 4)   || SUBSTR(MON.COST_YRMON, 5, 2) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OL.REGION" ).append("\n"); 
		query.append(",	OL.GSO" ).append("\n"); 
		query.append(", BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append(",	MON.COST_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", SUBSTR(MON.COST_YRMON, 1, 4)   || SUBSTR(MON.COST_YRMON, 5, 2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") SUB" ).append("\n"); 

	}
}