/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByESTListDataCCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCByESTListDataCCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCByESTListDataCC
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByESTListDataCCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByESTListDataCCRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)) RHQ," ).append("\n"); 
		query.append("	(SELECT MGC.MNR_CD_DESC FROM MNR_GEN_CD MGC WHERE MGC.PRNT_CD_ID = 'CD00019' AND MGC.MNR_CD_ID = RH.MNR_INP_TP_CD AND ROWNUM = 1) AS MNR_INP_TP_CD_NM," ).append("\n"); 
		query.append("	MAX(OD.ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("	RH.COST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("	VD.VNDR_SEQ SP_CD," ).append("\n"); 
		query.append("	VD.VNDR_LGL_ENG_NM SP_NM," ).append("\n"); 
		query.append("	RH.EQ_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("	SUM(DECODE(RH.RPR_STS_CD,'HJ',1,0)) HJ_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RH.RPR_STS_CD,'HJ',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) HJ_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RH.RPR_STS_CD,'HO',1,0)) HO_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RH.RPR_STS_CD,'HO',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) HO_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NS',1,0)) NS_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NS',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) NS_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NT',1,0)) NT_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NT',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) NT_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UH',1,0)) UH_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UH',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) UH_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UR',1,0)) UR_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UR',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) UR_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UM',1,0)) UM_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'UM',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) UM_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'SL',1,0)) SL_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'SL',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) SL_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'OF',1,0)) OF_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'OF',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) OF_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'RE',1,0)) RE_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'RE',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) RE_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'DE',1,0)) DE_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'DE',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) DE_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'LE',1,0)) LE_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'LE',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) LE_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NA',1,0)) NA_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'NA',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) NA_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'SS',1,0)) SS_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'SS',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) SS_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'VT',1,0)) VT_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'VT',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) VT_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'CE',1,0)) CE_CNT," ).append("\n"); 
		query.append("	SUM(DECODE(RD.MNR_VRFY_TP_CD,'CE',MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT),0)) CE_AMT," ).append("\n"); 
		query.append("	DECODE(@[curr_cd], 'Y', 'USD', MAX(RH.CURR_CD)) CURR," ).append("\n"); 
		query.append("	COUNT (DISTINCT (RH.RQST_EQ_NO || RH.RPR_RQST_SEQ || RH.RPR_RQST_VER_NO)) EST_QTY," ).append("\n"); 
		query.append("	COUNT(*) DTL_CNT," ).append("\n"); 
		query.append("	SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT)) T_AMT," ).append("\n"); 
		query.append("	ROUND((SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT)) / COUNT(*)),2) T_AVG," ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI') " ).append("\n"); 
		query.append("	TO_CHAR(RH.RQST_DT,'YYYY-MM') AS MONTH" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD, MDM_VENDOR VD,MNR_ORD_DTL OD" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND   RH.RQST_EQ_NO      = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_SEQ    = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("   AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ(+)	" ).append("\n"); 
		query.append("   AND   RH.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI') " ).append("\n"); 
		query.append("	TO_CHAR(OH.CRE_DT,'YYYY-MM') AS MONTH" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD, MNR_ORD_HDR OH, MDM_VENDOR VD, MNR_ORD_DTL OD" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND   RH.RQST_EQ_NO      = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_SEQ    = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("   AND   OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND   OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ	" ).append("\n"); 
		query.append("   AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND   OH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II') " ).append("\n"); 
		query.append("   TO_CHAR(IW.ISS_DT,'YYYY-MM') AS MONTH	" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH, MNR_RPR_RQST_DTL RD, MNR_ORD_DTL OD, MNR_PAY_INV_WRK IW, MDM_VENDOR VD" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND   RH.RQST_EQ_NO      = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_SEQ    = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("   AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("   AND   RD.RQST_EQ_NO = OD.EQ_NO" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND   RH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("   AND   OD.PAY_INV_SEQ        = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append("   AND   RH.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND   IW.ISS_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != 'A') " ).append("\n"); 
		query.append("AND RH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '') " ).append("\n"); 
		query.append("	AND	RH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A') " ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A') " ).append("\n"); 
		query.append("AND RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND RH.VNDR_SEQ   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rpr_sts_cd} != 'A' && ${rpr_sts_cd} != '') " ).append("\n"); 
		query.append("AND RH.RPR_STS_CD = @[rpr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RH.COST_OFC_CD," ).append("\n"); 
		query.append("RH.MNR_INP_TP_CD," ).append("\n"); 
		query.append("VD.VNDR_SEQ," ).append("\n"); 
		query.append("VD.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("RH.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#if (${curr_cd} != 'Y')" ).append("\n"); 
		query.append(",RH.CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI') " ).append("\n"); 
		query.append(",TO_CHAR(RH.RQST_DT,'YYYY-MM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI') " ).append("\n"); 
		query.append(",TO_CHAR(OH.CRE_DT,'YYYY-MM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II') " ).append("\n"); 
		query.append(",TO_CHAR(IW.ISS_DT,'YYYY-MM')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI') " ).append("\n"); 
		query.append("TO_CHAR(RH.RQST_DT,'YYYY-MM')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI') " ).append("\n"); 
		query.append("TO_CHAR(OH.CRE_DT,'YYYY-MM')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II') " ).append("\n"); 
		query.append("TO_CHAR(IW.ISS_DT,'YYYY-MM')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("RH.COST_OFC_CD,VD.VNDR_SEQ,RH.EQ_TPSZ_CD" ).append("\n"); 

	}
}