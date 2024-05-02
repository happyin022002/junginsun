/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchRepairPFMCByACCTListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.18 
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

public class PerformanceReportDBDAOsearchRepairPFMCByACCTListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairPFMCByACCTListData
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchRepairPFMCByACCTListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_only",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchRepairPFMCByACCTListDataRSQL").append("\n"); 
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
		query.append("#if(${report_period_type} == 'EI') " ).append("\n"); 
		query.append("	MRD.ACCT_CD, " ).append("\n"); 
		query.append("	(SELECT B.CNT_NM FROM MDM_LOCATION A,MDM_COUNTRY B,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("     WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("     AND  A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("     AND  C.OFC_CD = MPRH.COST_OFC_CD" ).append("\n"); 
		query.append("     AND  ROWNUM = 1) AS CNT_NM," ).append("\n"); 
		query.append("	MRD.COST_CD, " ).append("\n"); 
		query.append("	(SELECT DECODE(SIGN(INSTR(MNR_CD_DESC, 'Repair Labor')), 1, 'Repair Labor', MNR_CD_DESC) FROM MNR_GEN_CD GD WHERE GD.MNR_CD_ID = MRD.COST_CD AND GD.PRNT_CD_ID IN ('UG','ZG','GG') AND ROWNUM = 1) AS COST_CD_NM, " ).append("\n"); 
		query.append("	MRD.COST_DTL_CD," ).append("\n"); 
		query.append("	(SELECT MNR_CD_DESC " ).append("\n"); 
		query.append("       FROM MNR_GEN_CD GD " ).append("\n"); 
		query.append("      WHERE GD.MNR_CD_ID = MRD.COST_DTL_CD" ).append("\n"); 
		query.append("        AND GD.PRNT_CD_ID IN (SELECT A.MNR_CD_ID" ).append("\n"); 
		query.append("                                FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("                               WHERE A.MNR_CD_ID = MRD.COST_CD" ).append("\n"); 
		query.append("                                 AND A.PRNT_CD_ID IN ('UG','ZG','GG')) " ).append("\n"); 
		query.append("    ) AS COST_DTL_CD_NM, " ).append("\n"); 
		query.append("	MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPRH.COST_OFC_CD) AS RHQ_COST_OFC_CD, " ).append("\n"); 
		query.append("	MPRH.COST_OFC_CD," ).append("\n"); 
		query.append("	MPRH.VNDR_SEQ," ).append("\n"); 
		query.append("	(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MPRH.VNDR_SEQ AND ROWNUM = 1) AS VNDR_NM,	" ).append("\n"); 
		query.append("	DECODE(@[usd_only], 'Y', 'USD', MPRH.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("	SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPRH.CRE_DT, 'YYYYMM'), MPRH.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MPRH.CURR_CD), MPRH.MNR_WRK_AMT)) TOTAL_AMT," ).append("\n"); 
		query.append("	ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPRH.CRE_DT, 'YYYYMM'), MPRH.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MPRH.CURR_CD), MPRH.MNR_WRK_AMT)) / SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))),2) AVG_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))) AS TOTAL_QTY," ).append("\n"); 
		query.append("	MPRH.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	FROM MNR_ORD_DTL MRD,MNR_RPR_RQST_HDR MPRH" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("    AND   MPRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append(" 	AND   MPRH.MNR_ORD_OFC_CTY_CD = MRD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND   MPRH.MNR_ORD_SEQ        = MRD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("   	AND   MPRH.RPR_STS_CD <> 'HD'" ).append("\n"); 
		query.append("   	AND   MPRH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif(${report_period_type} == 'WI')" ).append("\n"); 
		query.append("	MRD.ACCT_CD, " ).append("\n"); 
		query.append("	(SELECT B.CNT_NM FROM MDM_LOCATION A,MDM_COUNTRY B,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("     WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("     AND  A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("     AND  C.OFC_CD = MOH.COST_OFC_CD" ).append("\n"); 
		query.append("     AND  ROWNUM = 1) AS CNT_NM," ).append("\n"); 
		query.append("	MRD.COST_CD, " ).append("\n"); 
		query.append("	(SELECT DECODE(SIGN(INSTR(MNR_CD_DESC, 'Repair Labor')), 1, 'Repair Labor', MNR_CD_DESC) FROM MNR_GEN_CD GD WHERE GD.MNR_CD_ID = MRD.COST_CD AND GD.PRNT_CD_ID IN ('UG','ZG','GG') AND ROWNUM = 1) AS COST_CD_NM, " ).append("\n"); 
		query.append("	MRD.COST_DTL_CD," ).append("\n"); 
		query.append("	(SELECT MNR_CD_DESC " ).append("\n"); 
		query.append("       FROM MNR_GEN_CD GD " ).append("\n"); 
		query.append("      WHERE GD.MNR_CD_ID = MRD.COST_DTL_CD" ).append("\n"); 
		query.append("        AND GD.PRNT_CD_ID IN (SELECT A.MNR_CD_ID" ).append("\n"); 
		query.append("                                FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("                               WHERE A.MNR_CD_ID = MRD.COST_CD" ).append("\n"); 
		query.append("                                 AND A.PRNT_CD_ID IN ('UG','ZG','GG')) " ).append("\n"); 
		query.append("    ) AS COST_DTL_CD_NM, " ).append("\n"); 
		query.append("	MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MOH.COST_OFC_CD) AS RHQ_COST_OFC_CD,  " ).append("\n"); 
		query.append("	MOH.COST_OFC_CD," ).append("\n"); 
		query.append("	MOH.VNDR_SEQ," ).append("\n"); 
		query.append("	(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MOH.VNDR_SEQ AND ROWNUM = 1) AS VNDR_NM," ).append("\n"); 
		query.append("	DECODE(@[usd_only], 'Y', 'USD', MOH.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("	SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MOH.CRE_DT, 'YYYYMM'), MOH.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MOH.CURR_CD), MRD.COST_AMT)) TOTAL_AMT," ).append("\n"); 
		query.append("	ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MOH.CRE_DT, 'YYYYMM'), MOH.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MOH.CURR_CD), MRD.COST_AMT)) / SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))),2) AVG_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))) AS TOTAL_QTY," ).append("\n"); 
		query.append("	MRD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	FROM MNR_ORD_HDR MOH,MNR_ORD_DTL MRD" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND   MOH.MNR_ORD_OFC_CTY_CD  = MRD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND   MOH.MNR_ORD_SEQ         = MRD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("	AND   MOH.CRE_DT BETWEEN  TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	MRD.ACCT_CD, " ).append("\n"); 
		query.append("	(SELECT B.CNT_NM FROM MDM_LOCATION A,MDM_COUNTRY B,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("     WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("     AND  A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("     AND  C.OFC_CD = MIW.ISS_OFC_CD" ).append("\n"); 
		query.append("     AND  ROWNUM = 1) AS CNT_NM," ).append("\n"); 
		query.append("	MRD.COST_CD, " ).append("\n"); 
		query.append("    DECODE(MRD.ACCT_CD,'511591','Other'," ).append("\n"); 
		query.append("	(SELECT DECODE(SIGN(INSTR(MNR_CD_DESC, 'Repair Labor')), 1, 'Repair Labor', MNR_CD_DESC) FROM MNR_GEN_CD GD WHERE GD.MNR_CD_ID = MRD.COST_CD AND GD.PRNT_CD_ID IN ('UG','ZG','GG') AND ROWNUM = 1)) AS COST_CD_NM, " ).append("\n"); 
		query.append("	MRD.COST_DTL_CD," ).append("\n"); 
		query.append("    DECODE(MRD.ACCT_CD,'511591','Other repair charge(511591)'," ).append("\n"); 
		query.append("	(SELECT MNR_CD_DESC " ).append("\n"); 
		query.append("       FROM MNR_GEN_CD GD" ).append("\n"); 
		query.append("      WHERE GD.MNR_CD_ID = MRD.COST_DTL_CD" ).append("\n"); 
		query.append("        AND GD.PRNT_CD_ID IN (SELECT A.MNR_CD_ID" ).append("\n"); 
		query.append("                                FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("                               WHERE A.MNR_CD_ID = MRD.COST_CD" ).append("\n"); 
		query.append("                                 AND A.PRNT_CD_ID IN ('UG','ZG','GG')) " ).append("\n"); 
		query.append("    )) AS COST_DTL_CD_NM, " ).append("\n"); 
		query.append("	MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD) AS RHQ_COST_OFC_CD,  " ).append("\n"); 
		query.append("	MIW.ISS_OFC_CD AS COST_OFC_CD," ).append("\n"); 
		query.append("	MIW.MNR_PRNR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("	(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MIW.MNR_PRNR_SEQ AND ROWNUM = 1) AS VNDR_NM," ).append("\n"); 
		query.append("	DECODE(@[usd_only], 'Y', 'USD', MIW.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("	SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MIW.CURR_CD), NVL(MRD.INV_AMT,0))) TOTAL_AMT," ).append("\n"); 
		query.append("	ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MIW.CRE_DT, 'YYYYMM'), MIW.CURR_CD, DECODE(@[usd_only], 'Y', 'USD', MIW.CURR_CD), NVL(MRD.INV_AMT,0))) / SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))),2) AVG_AMT," ).append("\n"); 
		query.append("	SUM(DECODE(MRD.RPR_QTY,0,1,NVL(MRD.RPR_QTY,1))) AS TOTAL_QTY," ).append("\n"); 
		query.append("	MRD.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	FROM MNR_ORD_HDR MOH,MNR_ORD_DTL MRD,MNR_PAY_INV_WRK MIW" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND   MOH.MNR_ORD_OFC_CTY_CD  = MRD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND   MOH.MNR_ORD_SEQ         = MRD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("	AND   MRD.PAY_INV_SEQ = MIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("	AND   MIW.CRE_DT BETWEEN  TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND MRD.ACCT_CD <> '512125'" ).append("\n"); 
		query.append("#if (${report_period_type} != 'II')" ).append("\n"); 
		query.append("	AND MRD.ACCT_CD <> '511591'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("	#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("	AND MPRH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND MOH.EQ_KND_CD   = @[eq_type]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("	#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("	AND	MPRH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	AND	MRD.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A' && ${rhq} != '') " ).append("\n"); 
		query.append("	#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("		AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPRH.COST_OFC_CD) = @[rhq]" ).append("\n"); 
		query.append("	#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("		AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MOH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${country} != 'A' && ${country} != '')" ).append("\n"); 
		query.append("	#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("		AND MPRH.COST_OFC_CD IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT A.OFC_CD" ).append("\n"); 
		query.append("  				FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" 				WHERE 1 = 1" ).append("\n"); 
		query.append("   				AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])	" ).append("\n"); 
		query.append("				#if (${rhq} != 'A' && ${rhq} != '') " ).append("\n"); 
		query.append("    			AND A.AR_HD_QTR_OFC_CD = @[rhq] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)	" ).append("\n"); 
		query.append("	#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("		AND MOH.COST_OFC_CD IN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT A.OFC_CD" ).append("\n"); 
		query.append("  				FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" 				WHERE 1 = 1" ).append("\n"); 
		query.append("   				AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])	" ).append("\n"); 
		query.append("				#if (${rhq} != 'A' && ${rhq} != '') " ).append("\n"); 
		query.append("    			AND A.AR_HD_QTR_OFC_CD = @[rhq] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#else	" ).append("\n"); 
		query.append("		AND MIW.ISS_OFC_CD IN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT A.OFC_CD" ).append("\n"); 
		query.append("  				FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" 				WHERE 1 = 1" ).append("\n"); 
		query.append("   				AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])	" ).append("\n"); 
		query.append("				#if (${rhq} != 'A' && ${rhq} != '') " ).append("\n"); 
		query.append("    			AND A.AR_HD_QTR_OFC_CD = @[rhq] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("	#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("		AND	MPRH.COST_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("				#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("				'$user_ofcCds'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'$user_ofcCds'" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("		AND	MOH.COST_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("				#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("				'$user_ofcCds'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'$user_ofcCds'" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	MIW.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("				#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("				'$user_ofcCds'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'$user_ofcCds'" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("			#end			  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${acct_cd} != '') " ).append("\n"); 
		query.append("	AND	MRD.ACCT_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_acctCds IN ${acctCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $acctCds.size())" ).append("\n"); 
		query.append("				'$user_acctCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_acctCds'" ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("		#end		  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_cd} != 'A')" ).append("\n"); 
		query.append("	AND MRD.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_dtl_cd} != 'A')" ).append("\n"); 
		query.append("	AND MRD.COST_DTL_CD = @[cost_dtl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND MPRH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND MOH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND MIW.MNR_PRNR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("GROUP BY MPRH.COST_OFC_CD,MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MPRH.VNDR_SEQ,MPRH.EQ_TPSZ_CD,MPRH.CURR_CD" ).append("\n"); 
		query.append("ORDER BY MPRH.COST_OFC_CD, MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPRH.COST_OFC_CD)" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI') " ).append("\n"); 
		query.append("GROUP BY MOH.EQ_KND_CD,MOH.COST_OFC_CD,MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MOH.VNDR_SEQ,MRD.EQ_TPSZ_CD,MOH.CURR_CD" ).append("\n"); 
		query.append("ORDER BY MOH.COST_OFC_CD, MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MOH.COST_OFC_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY MOH.EQ_KND_CD,MIW.ISS_OFC_CD,MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MIW.MNR_PRNR_SEQ,MRD.EQ_TPSZ_CD,MIW.CURR_CD" ).append("\n"); 
		query.append("ORDER BY MIW.ISS_OFC_CD, MRD.ACCT_CD,MRD.COST_CD,MRD.COST_DTL_CD,MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MIW.ISS_OFC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}