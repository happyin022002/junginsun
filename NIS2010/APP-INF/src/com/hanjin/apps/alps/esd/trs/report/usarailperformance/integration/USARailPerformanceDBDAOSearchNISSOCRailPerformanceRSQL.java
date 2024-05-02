/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USARailPerformanceDBDAOSearchNISSOCRailPerformanceRSQL.java
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

public class USARailPerformanceDBDAOSearchNISSOCRailPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNISSOCRailPerformance SELECT
	  * </pre>
	  */
	public USARailPerformanceDBDAOSearchNISSOCRailPerformanceRSQL(){
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
		query.append("FileName : USARailPerformanceDBDAOSearchNISSOCRailPerformanceRSQL").append("\n"); 
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
		query.append("      SO_CRE_YRMON MONTH," ).append("\n"); 
		query.append("      WEEK WEEK," ).append("\n"); 
		query.append("      TRSP_CO_IND_CD COMPANY," ).append("\n"); 
		query.append("      VNDR_SEQ RAIL_CODE," ).append("\n"); 
		query.append("      TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ) RAIL_NAME," ).append("\n"); 
		query.append("      'Full' FULL_EMPTY," ).append("\n"); 
		query.append("      DECODE(TRSP_BND_CD, 'I', 'In'  , 'O', 'Out'  , TRSP_BND_CD) BOUND," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	  AGMT_REF_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  '' AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  SLAN_CD," ).append("\n"); 
		query.append("      VVD," ).append("\n"); 
		query.append("      FM_NOD_CD FM," ).append("\n"); 
		query.append("      TO_NOD_CD T_O," ).append("\n"); 
		query.append("      CURR_CD  CURR," ).append("\n"); 
		query.append("      SUM(CNTR_20_CNT)    VOL_20," ).append("\n"); 
		query.append("      SUM(CNTR_20_BASIC)  LOC_BZC_AMT_20," ).append("\n"); 
		query.append("      SUM(CNTR_20_FUEL)   LOC_FUEL_AMT_20,   " ).append("\n"); 
		query.append("      SUM(CNTR_20_HAZARD) LOC_OVR_HZD_AMT_20,      " ).append("\n"); 
		query.append("      SUM(CNTR_20_TOTAL)  LOC_TTL_AMT_20," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_BASIC), SO_CRE_YRMON),2) USD_BZC_AMT_20," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_FUEL), SO_CRE_YRMON),2) USD_FUEL_AMT_20," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_HAZARD), SO_CRE_YRMON),2) USD_OVR_HZD_AMT_20," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_TOTAL), SO_CRE_YRMON),2) USD_TTL_AMT_20," ).append("\n"); 
		query.append("      SUM(CNTR_40_CNT)    VOL_40," ).append("\n"); 
		query.append("      SUM(CNTR_40_BASIC)  LOC_BZC_AMT_40," ).append("\n"); 
		query.append("      SUM(CNTR_40_FUEL)   LOC_FUEL_AMT_40,   " ).append("\n"); 
		query.append("      SUM(CNTR_40_HAZARD) LOC_OVR_HZD_AMT_40,      " ).append("\n"); 
		query.append("      SUM(CNTR_40_TOTAL)  LOC_TTL_AMT_40," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_BASIC), SO_CRE_YRMON),2) USD_BZC_AMT_40," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_FUEL), SO_CRE_YRMON),2) USD_FUEL_AMT_40," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_HAZARD), SO_CRE_YRMON),2) USD_OVR_HZD_AMT_40," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40_TOTAL), SO_CRE_YRMON),2) USD_TTL_AMT_40," ).append("\n"); 
		query.append("      SUM(CNTR_40HC_CNT)   VOL_40HC," ).append("\n"); 
		query.append("	  SUM(CNTR_40HC_BASIC) LOC_BZC_AMT_40HC," ).append("\n"); 
		query.append("	  SUM(CNTR_40HC_FUEL) LOC_FUEL_AMT_40HC," ).append("\n"); 
		query.append("	  SUM(CNTR_40HC_HAZARD) LOC_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("	  SUM(CNTR_40HC_TOTAL) LOC_TTL_AMT_40HC," ).append("\n"); 
		query.append("	  ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_BASIC), SO_CRE_YRMON),2) USD_BZC_AMT_40HC," ).append("\n"); 
		query.append("	  ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_FUEL), SO_CRE_YRMON),2) USD_FUEL_AMT_40HC," ).append("\n"); 
		query.append("	  ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_HAZARD), SO_CRE_YRMON),2) USD_OVR_HZD_AMT_40HC," ).append("\n"); 
		query.append("  	  ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_40HC_TOTAL), SO_CRE_YRMON),2) USD_TTL_AMT_40HC," ).append("\n"); 
		query.append("      SUM(CNTR_45_CNT)    VOL_45," ).append("\n"); 
		query.append("      SUM(CNTR_45_BASIC)  LOC_BZC_AMT_45," ).append("\n"); 
		query.append("      SUM(CNTR_45_FUEL)   LOC_FUEL_AMT_45,   " ).append("\n"); 
		query.append("      SUM(CNTR_45_HAZARD) LOC_OVR_HZD_AMT_45,      " ).append("\n"); 
		query.append("      SUM(CNTR_45_TOTAL)  LOC_TTL_AMT_45," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_BASIC), SO_CRE_YRMON),2) USD_BZC_AMT_45," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_FUEL), SO_CRE_YRMON),2) USD_FUEL_AMT_45," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_HAZARD), SO_CRE_YRMON),2) USD_OVR_HZD_AMT_45," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_45_TOTAL), SO_CRE_YRMON),2) USD_TTL_AMT_45," ).append("\n"); 
		query.append("      SUM(CNTR_20_CNT) + SUM(CNTR_40_CNT) + SUM(CNTR_40HC_CNT) + SUM(CNTR_45_CNT) TOT_VOL," ).append("\n"); 
		query.append("      SUM(CNTR_20_BASIC) + SUM(CNTR_40_BASIC) + SUM(CNTR_40HC_BASIC) + SUM(CNTR_45_BASIC)  TOT_LOC_BZC_AMT," ).append("\n"); 
		query.append("      SUM(CNTR_20_FUEL) + SUM(CNTR_40_FUEL) + SUM(CNTR_40HC_FUEL) + SUM(CNTR_45_FUEL)  TOT_LOC_FUEL_AMT," ).append("\n"); 
		query.append("      SUM(CNTR_20_HAZARD) + SUM(CNTR_40_HAZARD) + SUM(CNTR_40HC_HAZARD) + SUM(CNTR_45_HAZARD)  TOT_LOC_OVR_HZD_AMT," ).append("\n"); 
		query.append("      SUM(CNTR_20_TOTAL) + SUM(CNTR_40_TOTAL) + SUM(CNTR_40HC_TOTAL) + SUM(CNTR_45_TOTAL)  TOT_LOC_TTL_AMT," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_BASIC) + SUM(CNTR_40_BASIC) + SUM(CNTR_40HC_BASIC) + SUM(CNTR_45_BASIC) , SO_CRE_YRMON),2) TOT_USD_BZC_AMT," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_FUEL) + SUM(CNTR_40_FUEL) + SUM(CNTR_40HC_FUEL) + SUM(CNTR_45_FUEL) , SO_CRE_YRMON),2) TOT_USD_FUEL_AMT," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_HAZARD) + SUM(CNTR_40_HAZARD) + SUM(CNTR_40HC_HAZARD) + SUM(CNTR_45_HAZARD) , SO_CRE_YRMON),2) TOT_USD_OVR_HZD_AMT," ).append("\n"); 
		query.append("      ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD,SUM(CNTR_20_TOTAL) + SUM(CNTR_40_TOTAL) + SUM(CNTR_40HC_TOTAL) + SUM(CNTR_45_TOTAL) , SO_CRE_YRMON),2) TOT_USD_TTL_AMT" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT TO_CHAR(A.CRE_DT, 'YYYYMM') SO_CRE_YRMON," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("           '' WEEK," ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("           A.WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           'Domestic' TRSP_CO_IND_CD," ).append("\n"); 
		query.append("           B.VNDR_SEQ," ).append("\n"); 
		query.append("    	   '' TRSP_BND_CD," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("	       X.AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   A.LANE_CD SLAN_CD," ).append("\n"); 
		query.append("    	   A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("    	   B.FM_YD_CD FM_NOD_CD," ).append("\n"); 
		query.append("   		   B.TO_YD_CD TO_NOD_CD," ).append("\n"); 
		query.append("     	   LOCTO.LOC_CD," ).append("\n"); 
		query.append("    	   LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("    	   LOCFM.LOC_CD," ).append("\n"); 
		query.append("    	   LOCFM.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("    	   'USD' CURR_CD," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '2', 1, 0)                                 )  CNTR_20_CNT," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '2', NVL(B.AGMT_BZC_AMT,0)+NVL('',0), 0)   )  CNTR_20_BASIC," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '2', NVL(B.FUEL_SCG_AMT,0)+NVL('',0), 0)   )  CNTR_20_FUEL," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '2', NVL(B.HZD_MTRL_SCG_AMT,0)+NVL(B.TTL_SCG_AMT,0)+NVL('',0), 0)) CNTR_20_HAZARD,  " ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '2', NVL(B.AGMT_RT_AMT,0)+NVL('',0), 0)   )   CNTR_20_TOTAL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '4', 1, 0)                                 )  CNTR_40_CNT," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '4', NVL(B.AGMT_BZC_AMT,0)+NVL('',0), 0)   )  CNTR_40_BASIC," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '4', NVL(B.FUEL_SCG_AMT,0)+NVL('',0), 0)   )  CNTR_40_FUEL," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '4', NVL(B.HZD_MTRL_SCG_AMT,0)+NVL(B.TTL_SCG_AMT,0)+NVL('',0), 0)) CNTR_40_HAZARD,  " ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '4', NVL(B.AGMT_RT_AMT,0)+NVL('',0), 0)   )   CNTR_40_TOTAL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '5', 1, 0)                                 )  CNTR_40HC_CNT," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '5', NVL(B.AGMT_BZC_AMT,0)+NVL('',0), 0)   )  CNTR_40HC_BASIC," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '5', NVL(B.FUEL_SCG_AMT,0)+NVL('',0), 0)   )  CNTR_40HC_FUEL," ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '5', NVL(B.HZD_MTRL_SCG_AMT,0)+NVL(B.TTL_SCG_AMT,0)+NVL('',0), 0)) CNTR_40HC_HAZARD,  " ).append("\n"); 
		query.append("    	   SUM(DECODE(SUBSTR(F.CNTR_TPSZ_CD,2,1), '5', NVL(B.AGMT_RT_AMT,0)+NVL('',0), 0)   )   CNTR_40HC_TOTAL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	   SUM(DECODE(F.CNTR_TPSZ_CD, 'D7', 1, 0)                                           )   CNTR_45_CNT," ).append("\n"); 
		query.append("    	   SUM(DECODE(F.CNTR_TPSZ_CD, 'D7', NVL(B.AGMT_BZC_AMT,0)+NVL('',0) , 0 )           )   CNTR_45_BASIC,   " ).append("\n"); 
		query.append("    	   SUM(DECODE(F.CNTR_TPSZ_CD, 'D7', NVL(B.FUEL_SCG_AMT,0)+NVL('',0) , 0 )           )   CNTR_45_FUEL,      	    	   " ).append("\n"); 
		query.append("    	   SUM(DECODE(F.CNTR_TPSZ_CD, 'D7', NVL(B.HZD_MTRL_SCG_AMT,0)+NVL(B.TTL_SCG_AMT,0)+NVL('',0) , 0 )       )   CNTR_45_HAZARD,    " ).append("\n"); 
		query.append("    	   SUM(DECODE(F.CNTR_TPSZ_CD, 'D7', NVL(B.AGMT_RT_AMT,0)+NVL('',0) , 0 )            )   CNTR_45_TOTAL" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'M' )" ).append("\n"); 
		query.append("           DOM_RAIL_SO_MST       A" ).append("\n"); 
		query.append("#elseif( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("    	    (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, CNTR_NO, DMST_BKG_NO, LANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD,AA.CRE_DT, DELT_FLG, DMST_SO_STS_CD, DMST_EDI_STS_CD, DMST_EDI_SND_CD, ROUT_ORG_YD_CD, ROUT_DEST_YD_CD" ).append("\n"); 
		query.append("			, BB.COST_WK WEEK" ).append("\n"); 
		query.append("			FROM DOM_RAIL_SO_MST AA, MAS_WK_PRD BB" ).append("\n"); 
		query.append("			WHERE AA.CRE_DT BETWEEN TO_DATE(BB.SLS_FM_DT,'YYYYMMDD') AND TO_DATE(BB.SLS_TO_DT,'YYYYMMDD')+0.99999)   A" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  	   , DOM_RAIL_SO_DTL       B" ).append("\n"); 
		query.append("  	   , (SELECT LOC_CD, EQ_CTRL_OFC_CD FROM MDM_LOCATION ) LOCTO" ).append("\n"); 
		query.append("  	   , (SELECT LOC_CD, EQ_CTRL_OFC_CD FROM MDM_LOCATION ) LOCFM" ).append("\n"); 
		query.append("  	   , MST_CONTAINER         F" ).append("\n"); 
		query.append("  	   , DOM_BOOKING           G" ).append("\n"); 
		query.append("  	   , MDM_VENDOR            V" ).append("\n"); 
		query.append("       , TRS_AGMT_HDR          X" ).append("\n"); 
		query.append("    WHERE A.TRSP_SO_OFC_CTY_CD  = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND   A.TRSP_SO_SEQ         = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    AND   B.AGMT_RT_AMT > 0" ).append("\n"); 
		query.append("    AND   NVL(A.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("    AND   LOCTO.LOC_CD = SUBSTR(A.ROUT_ORG_YD_CD,1,5)" ).append("\n"); 
		query.append("    AND   LOCFM.LOC_CD = SUBSTR(A.ROUT_DEST_YD_CD,1,5)" ).append("\n"); 
		query.append("    AND   A.DMST_SO_STS_CD      <> 'D' -- SO 삭제 제외" ).append("\n"); 
		query.append("    AND   A.DMST_EDI_STS_CD     = 'C'  -- COMPLETE ACK" ).append("\n"); 
		query.append("    AND   A.DMST_EDI_SND_CD     = 'S'  -- 404 EDI SUCESS" ).append("\n"); 
		query.append("    AND   A.CNTR_NO             = F.CNTR_NO" ).append("\n"); 
		query.append("    AND   A.DMST_BKG_NO         = G.DMST_BKG_NO" ).append("\n"); 
		query.append("    AND   A.CNTR_NO             = G.CNTR_NO" ).append("\n"); 
		query.append("    AND   B.VNDR_SEQ            = V.VNDR_SEQ" ).append("\n"); 
		query.append("    AND   B.TRSP_AGMT_OFC_CTY_CD= X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND   B.TRSP_AGMT_SEQ       = X.TRSP_AGMT_SEQ    " ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("      AND   B.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cgo_tp_cd} != 'A' )" ).append("\n"); 
		query.append("      AND   'F' = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ctrl_ofc} != '' )" ).append("\n"); 
		query.append("      AND   LOCFM.EQ_CTRL_OFC_CD = @[ctrl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fm_node_length} == '7')" ).append("\n"); 
		query.append("      AND   B.FM_YD_CD = @[input_fm_node]" ).append("\n"); 
		query.append("#elseif (${fm_node_length} == '5')" ).append("\n"); 
		query.append("      AND   B.FM_YD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#elseif (${fm_node_length} != '0')" ).append("\n"); 
		query.append("      AND   B.FM_YD_CD LIKE @[input_fm_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_node_length} == '7')" ).append("\n"); 
		query.append("	  AND   B.TO_YD_CD = @[input_to_node]" ).append("\n"); 
		query.append("#elseif (${to_node_length} == '5')" ).append("\n"); 
		query.append("	  AND   B.TO_YD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#elseif (${to_node_length} != '0')" ).append("\n"); 
		query.append("	  AND   B.TO_YD_CD LIKE @[input_to_node] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${fm_month} != '' && ${to_month} != '')" ).append("\n"); 
		query.append("    AND   A.CRE_DT BETWEEN TO_DATE(@[fm_month],'YYYYMMDD') AND TO_DATE(@[to_month],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${agmt_ref_no} != '' )" ).append("\n"); 
		query.append("	AND   X.AGMT_REF_NO = @[agmt_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz} != '' )" ).append("\n"); 
		query.append("      AND F.CNTR_TPSZ_CD IN (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                            WHERE INTG_CD_ID = 'CD01860'" ).append("\n"); 
		query.append("                              AND (INSTR(@[cntr_tpsz], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("                               OR @[cntr_tpsz] = 'ALL'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY" ).append("\n"); 
		query.append("    		TO_CHAR(A.CRE_DT, 'YYYYMM')," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("            A.WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   		    B.VNDR_SEQ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		    X.AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			A.LANE_CD," ).append("\n"); 
		query.append("    		A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD," ).append("\n"); 
		query.append("    		B.FM_YD_CD," ).append("\n"); 
		query.append("    		B.TO_YD_CD," ).append("\n"); 
		query.append("    		LOCTO.LOC_CD," ).append("\n"); 
		query.append("    		LOCTO.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("    		LOCFM.LOC_CD," ).append("\n"); 
		query.append("    		LOCFM.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        SO_CRE_YRMON  ," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("        WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        TRSP_CO_IND_CD," ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        TRSP_BND_CD   ," ).append("\n"); 
		query.append("#if( ${agmt_chk} == 'Y' )" ).append("\n"); 
		query.append("		AGMT_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		SLAN_CD       ," ).append("\n"); 
		query.append("        VVD           ," ).append("\n"); 
		query.append("        FM_NOD_CD     ," ).append("\n"); 
		query.append("        TO_NOD_CD     ," ).append("\n"); 
		query.append("        CURR_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        SO_CRE_YRMON  ," ).append("\n"); 
		query.append("#if( ${f_chkprd} == 'W' )" ).append("\n"); 
		query.append("        WEEK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        TRSP_CO_IND_CD," ).append("\n"); 
		query.append("        TRSP_BND_CD   ," ).append("\n"); 
		query.append("        FM_NOD_CD     ," ).append("\n"); 
		query.append("        TO_NOD_CD" ).append("\n"); 

	}
}