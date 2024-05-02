/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USARailPerformanceDBDAOSearchENISSOCRailPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.04.21 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailPerformanceDBDAOSearchENISSOCRailPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchENISSOCRailPerformance SELECT
	  * </pre>
	  */
	public USARailPerformanceDBDAOSearchENISSOCRailPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_on",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration").append("\n"); 
		query.append("FileName : USARailPerformanceDBDAOSearchENISSOCRailPerformanceRSQL").append("\n"); 
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
		query.append("#if( ${loc_on} == 'L' )" ).append("\n"); 
		query.append("	'' MONTH," ).append("\n"); 
		query.append("	'' WEEK," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	MONTH," ).append("\n"); 
		query.append("	WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    'International' COMPANY," ).append("\n"); 
		query.append("    RAIL_CODE," ).append("\n"); 
		query.append("    RAIL_NAME," ).append("\n"); 
		query.append("    FULL_EMPTY," ).append("\n"); 
		query.append("    '-' BOUND," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	AGMT_REF_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	'' AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    '-' SLAN_CD  ," ).append("\n"); 
		query.append("    '-' VVD      ," ).append("\n"); 
		query.append("    FM," ).append("\n"); 
		query.append("    T_O," ).append("\n"); 
		query.append("    CURR," ).append("\n"); 
		query.append("    SUM(ROUND(VOL_20,0))  VOL_20," ).append("\n"); 
		query.append("    SUM(ROUND(VOL_40,0))   VOL_40," ).append("\n"); 
		query.append("    SUM(ROUND(VOL_40HC,0))   VOL_40HC," ).append("\n"); 
		query.append("    SUM(ROUND(VOL_45,0)) VOL_45," ).append("\n"); 
		query.append("    SUM(ROUND(TOT_VOL,0))  TOT_VOL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SUM(LOC_BZC_AMT_20) LOC_BZC_AMT_20," ).append("\n"); 
		query.append("	SUM(LOC_FUEL_AMT_20) LOC_FUEL_AMT_20," ).append("\n"); 
		query.append("	SUM(LOC_OVR_HZD_AMT_20) LOC_OVR_HZD_AMT_20," ).append("\n"); 
		query.append("	SUM(LOC_TTL_AMT_20) LOC_TTL_AMT_20," ).append("\n"); 
		query.append("	SUM(USD_BZC_AMT_20) USD_BZC_AMT_20," ).append("\n"); 
		query.append("	SUM(USD_FUEL_AMT_20) USD_FUEL_AMT_20," ).append("\n"); 
		query.append("	SUM(USD_OVR_HZD_AMT_20) USD_OVR_HZD_AMT_20," ).append("\n"); 
		query.append("	SUM(USD_TTL_AMT_20) USD_TTL_AMT_20," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SUM(LOC_BZC_AMT_40) LOC_BZC_AMT_40," ).append("\n"); 
		query.append("	SUM(LOC_FUEL_AMT_40) LOC_FUEL_AMT_40," ).append("\n"); 
		query.append("	SUM(LOC_OVR_HZD_AMT_40) LOC_OVR_HZD_AMT_40," ).append("\n"); 
		query.append("	SUM(LOC_TTL_AMT_40) LOC_TTL_AMT_40," ).append("\n"); 
		query.append("	SUM(USD_BZC_AMT_40) USD_BZC_AMT_40," ).append("\n"); 
		query.append("	SUM(USD_FUEL_AMT_40) USD_FUEL_AMT_40," ).append("\n"); 
		query.append("	SUM(USD_OVR_HZD_AMT_40) USD_OVR_HZD_AMT_40," ).append("\n"); 
		query.append("	SUM(USD_TTL_AMT_40) USD_TTL_AMT_40," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SUM(LOC_BZC_AMT_40HC) LOC_BZC_AMT_40HC," ).append("\n"); 
		query.append("	SUM(LOC_FUEL_AMT_40HC) LOC_FUEL_AMT_40HC," ).append("\n"); 
		query.append("	SUM(LOC_OVR_HZD_AMT_40HC) LOC_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("	SUM(LOC_TTL_AMT_40HC) LOC_TTL_AMT_40HC," ).append("\n"); 
		query.append("	SUM(USD_BZC_AMT_40HC) USD_BZC_AMT_40HC," ).append("\n"); 
		query.append("	SUM(USD_FUEL_AMT_40HC) USD_FUEL_AMT_40HC," ).append("\n"); 
		query.append("	SUM(USD_OVR_HZD_AMT_40HC) USD_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("    SUM(USD_TTL_AMT_40HC) USD_TTL_AMT_40HC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SUM(LOC_BZC_AMT_45) LOC_BZC_AMT_45," ).append("\n"); 
		query.append("	SUM(LOC_FUEL_AMT_45) LOC_FUEL_AMT_45," ).append("\n"); 
		query.append("	SUM(LOC_OVR_HZD_AMT_45) LOC_OVR_HZD_AMT_45," ).append("\n"); 
		query.append("	SUM(LOC_TTL_AMT_45) LOC_TTL_AMT_45," ).append("\n"); 
		query.append("	SUM(USD_BZC_AMT_45) USD_BZC_AMT_45," ).append("\n"); 
		query.append("	SUM(USD_FUEL_AMT_45) USD_FUEL_AMT_45," ).append("\n"); 
		query.append("	SUM(USD_OVR_HZD_AMT_45) USD_OVR_HZD_AMT_45," ).append("\n"); 
		query.append("	SUM(USD_TTL_AMT_45) USD_TTL_AMT_45," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SUM(TOT_LOC_BZC_AMT)  TOT_LOC_BZC_AMT," ).append("\n"); 
		query.append("	SUM(TOT_LOC_FUEL_AMT)  TOT_LOC_FUEL_AMT," ).append("\n"); 
		query.append("	SUM(TOT_LOC_OVR_HZD_AMT)  TOT_LOC_OVR_HZD_AMT," ).append("\n"); 
		query.append("	SUM(TOT_LOC_TTL_AMT)  TOT_LOC_TTL_AMT," ).append("\n"); 
		query.append("	SUM(TOT_USD_BZC_AMT) TOT_USD_BZC_AMT," ).append("\n"); 
		query.append("	SUM(TOT_USD_FUEL_AMT) TOT_USD_FUEL_AMT," ).append("\n"); 
		query.append("	SUM(TOT_USD_OVR_HZD_AMT) TOT_USD_OVR_HZD_AMT," ).append("\n"); 
		query.append("	SUM(TOT_USD_TTL_AMT) TOT_USD_TTL_AMT" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SO_CRE_YRMON MONTH," ).append("\n"); 
		query.append("	WEEK WEEK," ).append("\n"); 
		query.append("    'International' COMPANY," ).append("\n"); 
		query.append("    WO_VNDR_SEQ  RAIL_CODE," ).append("\n"); 
		query.append("    TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(WO_VNDR_SEQ) RAIL_NAME," ).append("\n"); 
		query.append("    DECODE(CGO_TP_CD  , 'F', 'Full', 'M', 'Empty', CGO_TP_CD  ) FULL_EMPTY," ).append("\n"); 
		query.append("    DECODE(TRSP_BND_CD, 'I', 'In'  , 'O', 'Out'  , TRSP_BND_CD) BOUND," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    SLAN_CD  ," ).append("\n"); 
		query.append("    VVD      ," ).append("\n"); 
		query.append("    FM_NOD_CD FM," ).append("\n"); 
		query.append("    TO_NOD_CD T_O," ).append("\n"); 
		query.append("    CURR_CD  CURR," ).append("\n"); 
		query.append("    SUM(CNTR_20_CNT)  VOL_20," ).append("\n"); 
		query.append("    SUM(CNTR_40_CNT)   VOL_40," ).append("\n"); 
		query.append("    SUM(CNTR_40HC_CNT)   VOL_40HC," ).append("\n"); 
		query.append("    SUM(CNTR_45_CNT) VOL_45," ).append("\n"); 
		query.append("    SUM(CNTR_20_CNT) + SUM(CNTR_40_CNT) + SUM(CNTR_40HC_CNT) + SUM(CNTR_45_CNT)  TOT_VOL," ).append("\n"); 
		query.append("	SUM(CNTR_20_BZC_AMT) LOC_BZC_AMT_20," ).append("\n"); 
		query.append("	SUM(CNTR_20_FUEL_AMT) LOC_FUEL_AMT_20," ).append("\n"); 
		query.append("	SUM(CNTR_20_OVR_HZD_AMT) LOC_OVR_HZD_AMT_20," ).append("\n"); 
		query.append("	SUM(CNTR_20_TTL_AMT) LOC_TTL_AMT_20," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_BZC_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_BZC_AMT), SO_CRE_YRMON),2) END USD_BZC_AMT_20," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_FUEL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_FUEL_AMT), SO_CRE_YRMON),2) END USD_FUEL_AMT_20," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_OVR_HZD_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_OVR_HZD_AMT), SO_CRE_YRMON),2) END USD_OVR_HZD_AMT_20," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_TTL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_TTL_AMT), SO_CRE_YRMON),2) END USD_TTL_AMT_20," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SUM(CNTR_40_BZC_AMT) LOC_BZC_AMT_40," ).append("\n"); 
		query.append("	SUM(CNTR_40_FUEL_AMT) LOC_FUEL_AMT_40," ).append("\n"); 
		query.append("	SUM(CNTR_40_OVR_HZD_AMT) LOC_OVR_HZD_AMT_40," ).append("\n"); 
		query.append("	SUM(CNTR_40_TTL_AMT) LOC_TTL_AMT_40," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40_BZC_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_BZC_AMT), SO_CRE_YRMON),2) END USD_BZC_AMT_40," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40_FUEL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_FUEL_AMT), SO_CRE_YRMON),2) END USD_FUEL_AMT_40," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40_OVR_HZD_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_OVR_HZD_AMT), SO_CRE_YRMON),2) END USD_OVR_HZD_AMT_40," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40_TTL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_TTL_AMT), SO_CRE_YRMON),2) END USD_TTL_AMT_40," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SUM(CNTR_40HC_BZC_AMT) LOC_BZC_AMT_40HC," ).append("\n"); 
		query.append("	SUM(CNTR_40HC_FUEL_AMT) LOC_FUEL_AMT_40HC," ).append("\n"); 
		query.append("  	SUM(CNTR_40HC_OVR_HZD_AMT) LOC_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("  	SUM(CNTR_40HC_TTL_AMT) LOC_TTL_AMT_40HC," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40HC_BZC_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_BZC_AMT), SO_CRE_YRMON),2) END USD_BZC_AMT_40HC," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40HC_FUEL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_FUEL_AMT), SO_CRE_YRMON),2) END USD_FUEL_AMT_40HC," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40HC_OVR_HZD_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_OVR_HZD_AMT), SO_CRE_YRMON),2) END USD_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_40HC_TTL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_TTL_AMT), SO_CRE_YRMON),2) END USD_TTL_AMT_40HC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SUM(CNTR_45_BZC_AMT) LOC_BZC_AMT_45," ).append("\n"); 
		query.append("	SUM(CNTR_45_FUEL_AMT) LOC_FUEL_AMT_45," ).append("\n"); 
		query.append("	SUM(CNTR_45_OVR_HZD_AMT) LOC_OVR_HZD_AMT_45," ).append("\n"); 
		query.append("	SUM(CNTR_45_TTL_AMT) LOC_TTL_AMT_45," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_45_BZC_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_BZC_AMT), SO_CRE_YRMON),2) END USD_BZC_AMT_45," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_45_FUEL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_FUEL_AMT), SO_CRE_YRMON),2) END USD_FUEL_AMT_45," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_45_OVR_HZD_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_OVR_HZD_AMT), SO_CRE_YRMON),2) END USD_OVR_HZD_AMT_45," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_45_TTL_AMT), 2) ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_TTL_AMT), SO_CRE_YRMON),2) END USD_TTL_AMT_45," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SUM(CNTR_20_BZC_AMT) + SUM(CNTR_40_BZC_AMT) + SUM(CNTR_40HC_BZC_AMT) + SUM(CNTR_45_BZC_AMT)  TOT_LOC_BZC_AMT," ).append("\n"); 
		query.append("    SUM(CNTR_20_FUEL_AMT) + SUM(CNTR_40_FUEL_AMT) + SUM(CNTR_40HC_FUEL_AMT) + SUM(CNTR_45_FUEL_AMT)  TOT_LOC_FUEL_AMT," ).append("\n"); 
		query.append("    SUM(CNTR_20_OVR_HZD_AMT) + SUM(CNTR_40_OVR_HZD_AMT) + SUM(CNTR_40HC_OVR_HZD_AMT) + SUM(CNTR_45_OVR_HZD_AMT)  TOT_LOC_OVR_HZD_AMT," ).append("\n"); 
		query.append("    SUM(CNTR_20_TTL_AMT) + SUM(CNTR_40_TTL_AMT) + SUM(CNTR_40HC_TTL_AMT) + SUM(CNTR_45_TTL_AMT)  TOT_LOC_TTL_AMT," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_BZC_AMT) + SUM(CNTR_40_BZC_AMT) + SUM(CNTR_40HC_BZC_AMT) + SUM(CNTR_45_BZC_AMT), 2)" ).append("\n"); 
		query.append("    ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_BZC_AMT) + SUM(CNTR_40_BZC_AMT) + SUM(CNTR_40HC_BZC_AMT) + SUM(CNTR_45_BZC_AMT) , SO_CRE_YRMON),2) END TOT_USD_BZC_AMT," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_FUEL_AMT) + SUM(CNTR_40_FUEL_AMT) + SUM(CNTR_40HC_FUEL_AMT) + SUM(CNTR_45_FUEL_AMT), 2)" ).append("\n"); 
		query.append("    ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, SUM(CNTR_20_FUEL_AMT) + SUM(CNTR_40_FUEL_AMT) + SUM(CNTR_40HC_FUEL_AMT) + SUM(CNTR_45_FUEL_AMT) , SO_CRE_YRMON),2) END TOT_USD_FUEL_AMT," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_OVR_HZD_AMT) + SUM(CNTR_40_OVR_HZD_AMT) + SUM(CNTR_40HC_OVR_HZD_AMT) + SUM(CNTR_45_OVR_HZD_AMT), 2)" ).append("\n"); 
		query.append("    ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, SUM(CNTR_20_OVR_HZD_AMT) + SUM(CNTR_40_OVR_HZD_AMT) + SUM(CNTR_40HC_OVR_HZD_AMT) + SUM(CNTR_45_OVR_HZD_AMT) , SO_CRE_YRMON),2) END TOT_USD_OVR_HZD_AMT," ).append("\n"); 
		query.append("	CASE WHEN CURR_CD = 'USD' THEN ROUND(SUM(CNTR_20_TTL_AMT) + SUM(CNTR_40_TTL_AMT) + SUM(CNTR_40HC_TTL_AMT) + SUM(CNTR_45_TTL_AMT), 2)" ).append("\n"); 
		query.append("    ELSE ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, SUM(CNTR_20_TTL_AMT) + SUM(CNTR_40_TTL_AMT) + SUM(CNTR_40HC_TTL_AMT) + SUM(CNTR_45_TTL_AMT) , SO_CRE_YRMON),2) END TOT_USD_TTL_AMT" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("          SELECT /*+ USE_HASH(LOCTO) USE_HASH(LOCFM) */" ).append("\n"); 
		query.append("            TO_CHAR(LOCL_CRE_DT, 'YYYYMM') SO_CRE_YRMON," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            '' WEEK," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("			COST_WK WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			VNDR_SEQ WO_VNDR_SEQ," ).append("\n"); 
		query.append("        	EQ_NO," ).append("\n"); 
		query.append("        	TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("			AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        	SLAN_CD," ).append("\n"); 
		query.append("        	VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        	CGO_TP_CD," ).append("\n"); 
		query.append("            DECODE(@[loc_on], 'L', SUBSTR(FM_NOD_CD,1,5), FM_NOD_CD) FM_NOD_CD," ).append("\n"); 
		query.append("            DECODE(@[loc_on], 'L', SUBSTR(TO_NOD_CD,1,5), TO_NOD_CD) TO_NOD_CD," ).append("\n"); 
		query.append("            DECODE(CURR_CD, NULL, INV_CURR_CD,  CURR_CD) CURR_CD  ," ).append("\n"); 
		query.append("            LOCTO.LOC_CD," ).append("\n"); 
		query.append("            LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("            LOCFM.LOC_CD," ).append("\n"); 
		query.append("            LOCFM.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("			T.DELT_FLG," ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', 1, 0) )   CNTR_20_CNT," ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', 1, 0) )   CNTR_40_CNT," ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', 1, 0) )   CNTR_40HC_CNT," ).append("\n"); 
		query.append("        	SUM(DECODE(EQ_TPSZ_CD , 'D7', 1, 0) )   CNTR_45_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(BZC_AMT,0) , 0) )   CNTR_20_BZC_AMT," ).append("\n"); 
		query.append("    	    SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_20_FUEL_AMT, " ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_20_OVR_HZD_AMT," ).append("\n"); 
		query.append("	        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_20_TTL_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	    SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(BZC_AMT,0) , 0) )   CNTR_40_BZC_AMT," ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_40_FUEL_AMT, " ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40_OVR_HZD_AMT," ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40_TTL_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(BZC_AMT,0) , 0) )   CNTR_40HC_BZC_AMT," ).append("\n"); 
		query.append("    	    SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_40HC_FUEL_AMT, " ).append("\n"); 
		query.append("        	SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40HC_OVR_HZD_AMT," ).append("\n"); 
		query.append("	        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40HC_TTL_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	    SUM(DECODE(EQ_TPSZ_CD, 'D7', NVL(BZC_AMT,0) ,0 )  )   CNTR_45_BZC_AMT," ).append("\n"); 
		query.append("        	SUM(DECODE(EQ_TPSZ_CD, 'D7', NVL(FUEL_SCG_AMT,0) ,0 )  )   CNTR_45_FUEL_AMT," ).append("\n"); 
		query.append("        	SUM(DECODE(EQ_TPSZ_CD, 'D7', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0) ,0 )  )   CNTR_45_OVR_HZD_AMT," ).append("\n"); 
		query.append("        	SUM(DECODE(EQ_TPSZ_CD, 'D7', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0) ,0 )  )   CNTR_45_TTL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("        (SELECT  " ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            '' COST_WK ," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            C.COST_WK ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            TR.LOCL_CRE_DT ," ).append("\n"); 
		query.append("            TR.EQ_NO," ).append("\n"); 
		query.append("            TR.TRSP_BND_CD," ).append("\n"); 
		query.append("            TR.SLAN_CD," ).append("\n"); 
		query.append("            TR.VSL_CD, " ).append("\n"); 
		query.append("            TR.SKD_VOY_NO, " ).append("\n"); 
		query.append("            TR.SKD_DIR_CD ," ).append("\n"); 
		query.append("            TR.CGO_TP_CD," ).append("\n"); 
		query.append("            YY.FM_NOD_CD," ).append("\n"); 
		query.append("            YY.TO_NOD_CD," ).append("\n"); 
		query.append("            TR.DELT_FLG," ).append("\n"); 
		query.append("            TR.EQ_TPSZ_CD," ).append("\n"); 
		query.append("            YY.VNDR_SEQ," ).append("\n"); 
		query.append("            YY.CURR_CD CURR_CD ," ).append("\n"); 
		query.append("            YY.INV_CURR_CD," ).append("\n"); 
		query.append("            YY.ETC_ADD_AMT ," ).append("\n"); 
		query.append("            YY.HZD_MTRL_SCG_AMT ," ).append("\n"); 
		query.append("            YY.OVR_WGT_SCG_AMT ," ).append("\n"); 
		query.append("            YY.FUEL_SCG_AMT ," ).append("\n"); 
		query.append("            YY.BZC_AMT ," ).append("\n"); 
		query.append("            YY.INV_BZC_AMT," ).append("\n"); 
		query.append("            YY.INV_ETC_ADD_AMT," ).append("\n"); 
		query.append("            YY.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("            YY.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_ORD TR," ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_VNDR_SET YY" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            ,MAS_WK_PRD C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            AND TR.LOCL_CRE_DT BETWEEN TO_DATE(C.SLS_FM_DT,'YYYYMMDD') AND TO_DATE(C.SLS_TO_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND TR.TRSP_SO_OFC_CTY_CD = YY.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND TR.TRSP_SO_SEQ        = YY.TRSP_SO_SEQ" ).append("\n"); 
		query.append("#if ( ${fm_month} != '' && ${to_month} != '')" ).append("\n"); 
		query.append("            AND TR.LOCL_CRE_DT BETWEEN TO_DATE( @[fm_month],'YYYYMMDD') AND TO_DATE( @[to_month],'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND TR.EQ_TPSZ_CD IN (SELECT  INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                                  AND (INSTR('ALL', INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                                   OR 'ALL' = 'ALL'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("            AND NVL(TR.DELT_FLG,'N')  = 'N' " ).append("\n"); 
		query.append("        ) T," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        TRS_AGMT_HDR AH," ).append("\n"); 
		query.append("        MDM_LOCATION LOCTO," ).append("\n"); 
		query.append("        MDM_LOCATION LOCFM  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND LOCTO.LOC_CD = SUBSTR(T.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("        AND LOCFM.LOC_CD = SUBSTR(T.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("        AND T.TRSP_AGMT_OFC_CTY_CD = AH.TRSP_AGMT_OFC_CTY_CD -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("        AND T.TRSP_AGMT_SEQ = AH.TRSP_AGMT_SEQ -- add Agmt. Ref. No." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("      AND   T.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cgo_tp_cd} != 'A')" ).append("\n"); 
		query.append("	#if ( ${cgo_tp_cd} != 'X')" ).append("\n"); 
		query.append("      AND   T.CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("      AND   (T.TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("             OR T.CGO_TP_CD = 'M')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${io_bound} != 'A' )" ).append("\n"); 
		query.append("	#if ( ${cgo_tp_cd} != 'X')" ).append("\n"); 
		query.append("      AND   T.TRSP_BND_CD = @[io_bound]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${ctrl_ofc} != '' )" ).append("\n"); 
		query.append("      AND DECODE(T.TRSP_BND_CD , 'I',  LOCTO.EQ_CTRL_OFC_CD, 'O', LOCFM.EQ_CTRL_OFC_CD , LOCFM.EQ_CTRL_OFC_CD) =  @[ctrl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${input_fm_node} != '' )" ).append("\n"); 
		query.append("      AND T.FM_NOD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${input_to_node} != '' )" ).append("\n"); 
		query.append("      AND T.TO_NOD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${agmt_ref_no} != '' )" ).append("\n"); 
		query.append("	AND AH.AGMT_REF_NO = @[agmt_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz} != '' )" ).append("\n"); 
		query.append("      AND T.EQ_TPSZ_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                            WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                              AND (INSTR(@[cntr_tpsz], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                               OR @[cntr_tpsz] = 'ALL'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      GROUP BY" ).append("\n"); 
		query.append("              TO_CHAR(LOCL_CRE_DT, 'YYYYMM')," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("			  COST_WK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              VNDR_SEQ," ).append("\n"); 
		query.append("    		  EQ_NO," ).append("\n"); 
		query.append("        	  TRSP_BND_CD      ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("			  AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        	  SLAN_CD		  ," ).append("\n"); 
		query.append("        	  VSL_CD||SKD_VOY_NO||SKD_DIR_CD," ).append("\n"); 
		query.append("        	  CGO_TP_CD        ," ).append("\n"); 
		query.append("        	  FM_NOD_CD        ," ).append("\n"); 
		query.append("        	  TO_NOD_CD        ," ).append("\n"); 
		query.append("        	  CURR_CD          ," ).append("\n"); 
		query.append("        	  DECODE(CURR_CD, NULL, INV_CURR_CD,  CURR_CD)," ).append("\n"); 
		query.append("        	  EQ_TPSZ_CD       ," ).append("\n"); 
		query.append("        	  BZC_AMT          ," ).append("\n"); 
		query.append("        	  LOCTO.LOC_CD        ," ).append("\n"); 
		query.append("        	  LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("        	  LOCFM.LOC_CD        ," ).append("\n"); 
		query.append("        	  LOCFM.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("        	  T.DELT_FLG" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        TO_CHAR(LOCL_CRE_DT, 'YYYYMM') SO_CRE_YRMON," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            '' WEEK," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("			COST_WK WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		VNDR_SEQ WO_VNDR_SEQ," ).append("\n"); 
		query.append("        EQ_NO," ).append("\n"); 
		query.append("        TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        SLAN_CD," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        CGO_TP_CD," ).append("\n"); 
		query.append("        DECODE(@[loc_on], 'L', SUBSTR(FM_NOD_CD,1,5), FM_NOD_CD) FM_NOD_CD," ).append("\n"); 
		query.append("        DECODE(@[loc_on], 'L', SUBSTR(TO_NOD_CD,1,5), TO_NOD_CD) TO_NOD_CD," ).append("\n"); 
		query.append("        DECODE(CURR_CD, NULL, INV_CURR_CD,  CURR_CD) CURR_CD ," ).append("\n"); 
		query.append("        LOCTO.LOC_CD a," ).append("\n"); 
		query.append("        LOCTO.EQ_CTRL_OFC_CD b," ).append("\n"); 
		query.append("        LOCFM.LOC_CD c," ).append("\n"); 
		query.append("        LOCFM.EQ_CTRL_OFC_CD d," ).append("\n"); 
		query.append("        T.DELT_FLG," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', 1, 0) )   CNTR_20_CNT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', 1, 0) )   CNTR_40_CNT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', 1, 0) )   CNTR_40HC_CNT," ).append("\n"); 
		query.append("        SUM(DECODE( EQ_TPSZ_CD , 'D7', 1, 0) )   CNTR_45_CNT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(BZC_AMT,0), 0) )   CNTR_20_BZC_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_20_FUEL_AMT, " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_20_OVR_HZD_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '2', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_20_TTL_AMT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(BZC_AMT,0), 0) )   CNTR_40_BZC_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_40_FUEL_AMT, " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40_OVR_HZD_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '4', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40_TTL_AMT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(BZC_AMT,0), 0) )   CNTR_40HC_BZC_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(FUEL_SCG_AMT,0), 0) )   CNTR_40HC_FUEL_AMT, " ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40HC_OVR_HZD_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(SUBSTR(EQ_TPSZ_CD,2,1), '5', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0) )   CNTR_40HC_TTL_AMT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SUM(DECODE( EQ_TPSZ_CD, 'D7', NVL(BZC_AMT,0) ,0 )  )   CNTR_45_BZC_AMT," ).append("\n"); 
		query.append("        SUM(DECODE( EQ_TPSZ_CD, 'D7', NVL(FUEL_SCG_AMT,0), 0 )  )   CNTR_45_FUEL_AMT," ).append("\n"); 
		query.append("        SUM(DECODE( EQ_TPSZ_CD, 'D7', NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0 ) ) CNTR_45_OVR_HZD_AMT," ).append("\n"); 
		query.append("        SUM(DECODE( EQ_TPSZ_CD, 'D7', NVL(BZC_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(OVR_WGT_SCG_AMT,0)+NVL(HZD_MTRL_SCG_AMT,0)+NVL(ETC_ADD_AMT,0), 0 )  )   CNTR_45_TTL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("        (SELECT  " ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("            '' COST_WK ," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            C.COST_WK ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            TR.LOCL_CRE_DT ," ).append("\n"); 
		query.append("            TR.EQ_NO," ).append("\n"); 
		query.append("            TR.TRSP_BND_CD," ).append("\n"); 
		query.append("            TR.SLAN_CD," ).append("\n"); 
		query.append("            TR.VSL_CD, " ).append("\n"); 
		query.append("            TR.SKD_VOY_NO, " ).append("\n"); 
		query.append("            TR.SKD_DIR_CD ," ).append("\n"); 
		query.append("            TR.CGO_TP_CD," ).append("\n"); 
		query.append("            YY.FM_NOD_CD," ).append("\n"); 
		query.append("            YY.TO_NOD_CD," ).append("\n"); 
		query.append("            TR.DELT_FLG," ).append("\n"); 
		query.append("            TR.EQ_TPSZ_CD," ).append("\n"); 
		query.append("            YY.VNDR_SEQ," ).append("\n"); 
		query.append("            YY.CURR_CD CURR_CD ," ).append("\n"); 
		query.append("            YY.INV_CURR_CD," ).append("\n"); 
		query.append("            YY.ETC_ADD_AMT ," ).append("\n"); 
		query.append("            YY.HZD_MTRL_SCG_AMT ," ).append("\n"); 
		query.append("            YY.OVR_WGT_SCG_AMT ," ).append("\n"); 
		query.append("            YY.FUEL_SCG_AMT ," ).append("\n"); 
		query.append("            YY.BZC_AMT ," ).append("\n"); 
		query.append("            YY.INV_BZC_AMT," ).append("\n"); 
		query.append("            YY.INV_ETC_ADD_AMT," ).append("\n"); 
		query.append("            YY.TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("            YY.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_ORD TR," ).append("\n"); 
		query.append("            TRS_TRSP_RAIL_BIL_VNDR_SET YY" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            ,MAS_WK_PRD C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            AND TR.LOCL_CRE_DT BETWEEN TO_DATE(C.SLS_FM_DT,'YYYYMMDD') AND TO_DATE(C.SLS_TO_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND TR.TRSP_SO_OFC_CTY_CD = YY.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND TR.TRSP_SO_SEQ        = YY.TRSP_SO_SEQ" ).append("\n"); 
		query.append("#if ( ${fm_month} != '' && ${to_month} != '')" ).append("\n"); 
		query.append("            AND TR.LOCL_CRE_DT BETWEEN TO_DATE( @[fm_month],'YYYYMMDD') AND TO_DATE( @[to_month],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND TR.EQ_TPSZ_CD IN (SELECT  INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                                  AND (INSTR('ALL', INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                                   OR 'ALL' = 'ALL'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("            AND NVL(TR.DELT_FLG,'N')  = 'Y' " ).append("\n"); 
		query.append("        ) T," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        TRS_AGMT_HDR AH," ).append("\n"); 
		query.append("        MDM_LOCATION LOCTO," ).append("\n"); 
		query.append("        MDM_LOCATION LOCFM  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND LOCTO.LOC_CD = SUBSTR(T.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("        AND LOCFM.LOC_CD = SUBSTR(T.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("        AND T.TRSP_AGMT_OFC_CTY_CD = AH.TRSP_AGMT_OFC_CTY_CD -- add Agmt. Ref. No. " ).append("\n"); 
		query.append("        AND T.TRSP_AGMT_SEQ = AH.TRSP_AGMT_SEQ -- add Agmt. Ref. No." ).append("\n"); 
		query.append("        AND NVL(T.INV_BZC_AMT, 0) + NVL(T.INV_ETC_ADD_AMT, 0) <> 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("      AND   VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cgo_tp_cd} != 'A' )" ).append("\n"); 
		query.append("      AND   T.CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${io_bound} != 'A' )" ).append("\n"); 
		query.append("      AND   T.TRSP_BND_CD = @[io_bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${ctrl_ofc} != '' )" ).append("\n"); 
		query.append("      AND DECODE(T.TRSP_BND_CD , 'I',  LOCTO.EQ_CTRL_OFC_CD, 'O', LOCFM.EQ_CTRL_OFC_CD , LOCFM.EQ_CTRL_OFC_CD) =  @[ctrl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fm_node_length} == '7')" ).append("\n"); 
		query.append("      AND   T.FM_NOD_CD = @[input_fm_node]" ).append("\n"); 
		query.append("#elseif (${fm_node_length} == '5')" ).append("\n"); 
		query.append("      AND   T.FM_NOD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#elseif (${fm_node_length} != '0')" ).append("\n"); 
		query.append("      AND   T.FM_NOD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_node_length} == '7')" ).append("\n"); 
		query.append("      AND   T.TO_NOD_CD = @[input_to_node]" ).append("\n"); 
		query.append("#elseif (${to_node_length} == '5')" ).append("\n"); 
		query.append("      AND   T.TO_NOD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#elseif (${to_node_length} != '0')" ).append("\n"); 
		query.append("      AND   T.TO_NOD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${agmt_ref_no} != '' )" ).append("\n"); 
		query.append("	AND AH.AGMT_REF_NO = @[agmt_ref_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ( ${cntr_tpsz} != '' )" ).append("\n"); 
		query.append("      AND T.EQ_TPSZ_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                            WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                              AND (INSTR(@[cntr_tpsz], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                               OR @[cntr_tpsz] = 'ALL'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       GROUP BY" ).append("\n"); 
		query.append("        TO_CHAR(LOCL_CRE_DT, 'YYYYMM')," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("        COST_WK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 		VNDR_SEQ," ).append("\n"); 
		query.append("        EQ_NO," ).append("\n"); 
		query.append("        TRSP_BND_CD      ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	    AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        SLAN_CD		  ," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD," ).append("\n"); 
		query.append("        CGO_TP_CD        ," ).append("\n"); 
		query.append("        FM_NOD_CD        ," ).append("\n"); 
		query.append("        TO_NOD_CD        ," ).append("\n"); 
		query.append("        CURR_CD          ," ).append("\n"); 
		query.append("        DECODE(CURR_CD, NULL, INV_CURR_CD,  CURR_CD)," ).append("\n"); 
		query.append("        EQ_TPSZ_CD       ," ).append("\n"); 
		query.append("        BZC_AMT          ," ).append("\n"); 
		query.append("        LOCTO.LOC_CD        ," ).append("\n"); 
		query.append("        LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("        LOCFM.LOC_CD        ," ).append("\n"); 
		query.append("        LOCFM.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("        T.DELT_FLG" ).append("\n"); 
		query.append("     )A" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        SO_CRE_YRMON," ).append("\n"); 
		query.append("		WEEK," ).append("\n"); 
		query.append("        WO_VNDR_SEQ , " ).append("\n"); 
		query.append("        CGO_TP_CD   ," ).append("\n"); 
		query.append("        TRSP_BND_CD ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		SLAN_CD	  ," ).append("\n"); 
		query.append("        VVD         ," ).append("\n"); 
		query.append("        FM_NOD_CD," ).append("\n"); 
		query.append("        TO_NOD_CD," ).append("\n"); 
		query.append("        CURR_CD,	  " ).append("\n"); 
		query.append("		DELT_FLG" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("        RAIL_NAME" ).append("\n"); 
		query.append("        , FM_NOD_CD" ).append("\n"); 
		query.append("        , TO_NOD_CD" ).append("\n"); 
		query.append("        , SO_CRE_YRMON" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("		, WEEK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if( ${loc_on} != 'L' )" ).append("\n"); 
		query.append("        MONTH," ).append("\n"); 
		query.append("		WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		RAIL_CODE," ).append("\n"); 
		query.append("		RAIL_NAME," ).append("\n"); 
		query.append("		FULL_EMPTY," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    	FM," ).append("\n"); 
		query.append("    	T_O," ).append("\n"); 
		query.append("		CURR" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("        RAIL_NAME" ).append("\n"); 
		query.append("    	,FM" ).append("\n"); 
		query.append("    	,T_O" ).append("\n"); 
		query.append("#if( ${loc_on} != 'L' )" ).append("\n"); 
		query.append("        , MONTH" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("		, WEEK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , FULL_EMPTY" ).append("\n"); 

	}
}