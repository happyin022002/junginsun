/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByWOListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.22 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCByWOListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCByWOListData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByWOListDataRSQL(){
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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByWOListDataRSQL").append("\n"); 
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
		query.append("SELECT SUMA.RHQ" ).append("\n"); 
		query.append(",(SELECT B.CNT_NM FROM MDM_LOCATION A,MDM_COUNTRY B,MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND  A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND  C.OFC_CD = SUMA.COST_OFC_CD" ).append("\n"); 
		query.append("AND  ROWNUM = 1) AS CNT_NM" ).append("\n"); 
		query.append(",SUMA.COST_OFC_CD" ).append("\n"); 
		query.append(",SUMA.VNDR_SEQ" ).append("\n"); 
		query.append(",SUMA.VNDR_SEQ_NM" ).append("\n"); 
		query.append(",SUMA.MNR_WO_TP_NM" ).append("\n"); 
		query.append(",DECODE(SUMA.ACCT_CD,'511591','Other'," ).append("\n"); 
		query.append("SUBSTR(SUMA.COST_CD_NM" ).append("\n"); 
		query.append(",INSTR(SUMA.COST_CD_NM,'|*SPLIT*|')+9" ).append("\n"); 
		query.append(",LENGTH(SUMA.COST_CD_NM)-(INSTR(SUMA.COST_CD_NM,'|*SPLIT*|')+8)" ).append("\n"); 
		query.append(")) AS COST_NM" ).append("\n"); 
		query.append(",DECODE(SUMA.ACCT_CD,'511591','Other repair charge(511591)'," ).append("\n"); 
		query.append("(SELECT MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID= SUBSTR(SUMA.COST_CD_NM" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(",INSTR(SUMA.COST_CD_NM,'|*SPLIT*|')-1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND MGC.MNR_CD_ID=SUMA.COST_DTL_CD" ).append("\n"); 
		query.append(")) COST_DTL_NM" ).append("\n"); 
		query.append(",SUMA.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",SUMA.ACCT_CD" ).append("\n"); 
		query.append(",SUMA.MNR_HNGR_BAR_TP_NM" ).append("\n"); 
		query.append(",SUMA.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",SUMA.SPR_PRT_NO" ).append("\n"); 
		query.append(",SUMA.VSL_VVD" ).append("\n"); 
		query.append(",SUMA.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append(",DECODE(SUMA.MNR_HNGR_BAR_TP_NM,NULL,SUMA.QTY,0) AS QTY" ).append("\n"); 
		query.append(",DECODE(SUMA.MNR_HNGR_BAR_TP_NM,NULL,0,SUMA.HQTY) AS HQTY" ).append("\n"); 
		query.append(",SUMA.CURR_CD" ).append("\n"); 
		query.append(",SUMA.AMT" ).append("\n"); 
		query.append(",SUMA.AVG_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPRH.COST_OFC_CD) RHQ --RHQ" ).append("\n"); 
		query.append(",MPRH.COST_OFC_CD -- Office" ).append("\n"); 
		query.append(",MPRH.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MPRH.VNDR_SEQ AND ROWNUM =1) AS VNDR_SEQ_NM --S/P" ).append("\n"); 
		query.append(",(SELECT MGC.MNR_CD_DP_DESC FROM MNR_GEN_CD MGC WHERE MGC.PRNT_CD_ID='CD00020' AND MGC.MNR_CD_ID= 'EST' AND ROWNUM = 1) AS MNR_WO_TP_NM --Cost type" ).append("\n"); 
		query.append(",MAX((SELECT" ).append("\n"); 
		query.append("MGC.MNR_CD_ID || '|*SPLIT*|' || MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE NVL(MGC.MNR_ORD_TP_CD,'0') = DECODE(MOH.MNR_WO_TP_CD,'SPL','TS','EXT','QT','EST','LB','0')" ).append("\n"); 
		query.append("AND MGC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND MGC.PRNT_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS','CD00037',MOH.EQ_KND_CD ||'G')" ).append("\n"); 
		query.append("AND MGC.MNR_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS',MOH.SPR_PRT_SPL_TP_CD,MOD.COST_CD)" ).append("\n"); 
		query.append(")) COST_CD_NM --Cost Type Nm" ).append("\n"); 
		query.append(",MOD.COST_DTL_CD" ).append("\n"); 
		query.append(",MPRH.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00022'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(") AS MNR_HNGR_BAR_TP_NM" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00009'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(") AS SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",MOD.SPR_PRT_NO" ).append("\n"); 
		query.append(",MOD.ACCT_CD" ).append("\n"); 
		query.append(",MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD AS VSL_VVD" ).append("\n"); 
		query.append(",MOH.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append(",SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))) QTY" ).append("\n"); 
		query.append(",DECODE(MOH.MNR_WO_TP_CD,'EXT',SUM(MOD.RPR_QTY),0) HQTY" ).append("\n"); 
		query.append(",DECODE(@[curr_cd], 'Y', 'USD', MPRH.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPRH.CRE_DT, 'YYYYMM'), MPRH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MPRH.CURR_CD), MPRH.MNR_WRK_AMT)) AMT" ).append("\n"); 
		query.append(",ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPRH.CRE_DT, 'YYYYMM'), MPRH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MPRH.CURR_CD), MPRH.MNR_WRK_AMT)) / SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))),2) AVG_AMT" ).append("\n"); 
		query.append("#elseif(${report_period_type} == 'WI')" ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MOH.COST_OFC_CD) RHQ --RHQ" ).append("\n"); 
		query.append(",MOH.COST_OFC_CD -- Office" ).append("\n"); 
		query.append(",MOH.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MOH.VNDR_SEQ  AND ROWNUM =1) AS VNDR_SEQ_NM --S/P" ).append("\n"); 
		query.append(",(SELECT MGC.MNR_CD_DP_DESC FROM MNR_GEN_CD MGC WHERE MGC.PRNT_CD_ID='CD00020' AND MGC.MNR_CD_ID=MOH.MNR_WO_TP_CD) AS MNR_WO_TP_NM --Cost type" ).append("\n"); 
		query.append(",MAX((SELECT" ).append("\n"); 
		query.append("MGC.MNR_CD_ID || '|*SPLIT*|' || MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE NVL(MGC.MNR_ORD_TP_CD,'0') = DECODE(MOH.MNR_WO_TP_CD,'SPL','TS','EXT','QT','EST','LB','0')" ).append("\n"); 
		query.append("AND MGC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND MGC.PRNT_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS','CD00037',MOH.EQ_KND_CD ||'G')" ).append("\n"); 
		query.append("AND MGC.MNR_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS',MOH.SPR_PRT_SPL_TP_CD,MOD.COST_CD)" ).append("\n"); 
		query.append(")) COST_CD_NM --Cost Type Nm" ).append("\n"); 
		query.append(",MOD.COST_DTL_CD" ).append("\n"); 
		query.append(",MOD.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00022'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(") AS MNR_HNGR_BAR_TP_NM" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00009'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(") AS SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",MOD.SPR_PRT_NO" ).append("\n"); 
		query.append(",MOD.ACCT_CD" ).append("\n"); 
		query.append(",MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD AS VSL_VVD" ).append("\n"); 
		query.append(",MOH.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append(",SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))) QTY" ).append("\n"); 
		query.append(",DECODE(MOH.MNR_WO_TP_CD,'EXT',SUM(MOD.RPR_QTY),0) HQTY" ).append("\n"); 
		query.append(",DECODE(@[curr_cd], 'Y', 'USD', MOH.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MOH.CRE_DT, 'YYYYMM'), MOH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MOH.CURR_CD), MOD.COST_AMT)) AMT" ).append("\n"); 
		query.append(",ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MOH.CRE_DT, 'YYYYMM'), MOH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MOH.CURR_CD), MOD.COST_AMT)) / SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))),2) AVG_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPIW.ISS_OFC_CD) RHQ --RHQ" ).append("\n"); 
		query.append(",MPIW.ISS_OFC_CD AS COST_OFC_CD -- Office" ).append("\n"); 
		query.append(",MPIW.MNR_PRNR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MPIW.MNR_PRNR_SEQ  AND ROWNUM =1) AS VNDR_SEQ_NM --S/P" ).append("\n"); 
		query.append(",(SELECT MGC.MNR_CD_DP_DESC FROM MNR_GEN_CD MGC WHERE MGC.PRNT_CD_ID='CD00020' AND MGC.MNR_CD_ID=MOH.MNR_WO_TP_CD) AS MNR_WO_TP_NM --Cost type" ).append("\n"); 
		query.append(",MAX((SELECT" ).append("\n"); 
		query.append("MGC.MNR_CD_ID || '|*SPLIT*|' || MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE NVL(MGC.MNR_ORD_TP_CD,'0') = DECODE(MOH.MNR_WO_TP_CD,'SPL','TS','EXT','QT','EST','LB','0')" ).append("\n"); 
		query.append("AND MGC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND MGC.PRNT_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS','CD00037',MOH.EQ_KND_CD ||'G')" ).append("\n"); 
		query.append("AND MGC.MNR_CD_ID = DECODE(MOH.MNR_WO_TP_CD,'RFS',MOH.SPR_PRT_SPL_TP_CD,MOD.COST_CD)" ).append("\n"); 
		query.append(")) COST_CD_NM --Cost Type Nm" ).append("\n"); 
		query.append(",MOD.COST_DTL_CD" ).append("\n"); 
		query.append(",MOD.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00022'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(") AS MNR_HNGR_BAR_TP_NM" ).append("\n"); 
		query.append(",(SELECT  MGC.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD MGC" ).append("\n"); 
		query.append("WHERE MGC.PRNT_CD_ID='CD00009'" ).append("\n"); 
		query.append("AND MNR_CD_ID=MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(") AS SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",MOD.SPR_PRT_NO" ).append("\n"); 
		query.append(",MOD.ACCT_CD" ).append("\n"); 
		query.append(",MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD AS VSL_VVD" ).append("\n"); 
		query.append(",MOH.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append(",SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))) QTY" ).append("\n"); 
		query.append(",DECODE(MOH.MNR_WO_TP_CD,'EXT',SUM(MOD.RPR_QTY),0) HQTY" ).append("\n"); 
		query.append(",DECODE(@[curr_cd], 'Y', 'USD', MPIW.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPIW.CRE_DT, 'YYYYMM'), MPIW.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MPIW.CURR_CD), NVL(MOD.INV_AMT,0))) AMT" ).append("\n"); 
		query.append(",ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MPIW.CRE_DT, 'YYYYMM'), MPIW.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', MPIW.CURR_CD), NVL(MOD.INV_AMT,0))) / SUM(DECODE(MOD.RPR_QTY,0,1,NVL(MOD.RPR_QTY,1))),2) AVG_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR MPRH, MNR_ORD_DTL MOD, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE MPRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   MPRH.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   MPRH.MNR_ORD_SEQ        = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   MOH.MNR_ORD_OFC_CTY_CD = MOD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   MOH.MNR_ORD_SEQ        = MOD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   MPRH.RPR_STS_CD <> 'HD'" ).append("\n"); 
		query.append("AND   MPRH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR MOH,MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("WHERE MOH.MNR_ORD_OFC_CTY_CD = MOD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND MOH.MNR_ORD_SEQ		 = MOD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND MOH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_period_type} == 'II')" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR MOH,MNR_ORD_DTL MOD,MNR_PAY_INV_WRK MPIW" ).append("\n"); 
		query.append("WHERE MOH.MNR_ORD_OFC_CTY_CD = MOD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND MOH.MNR_ORD_SEQ		 = MOD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND MOD.PAY_INV_SEQ      	 = MPIW.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND MPIW.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MOD.ACCT_CD <> '512125'" ).append("\n"); 
		query.append("#if (${report_period_type} != 'II')" ).append("\n"); 
		query.append("AND MOD.ACCT_CD <> '511591'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND MPRH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MOH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND	MPRH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	MOD.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPRH.COST_OFC_CD) = @[rhq]" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MOH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MPIW.ISS_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${country} != 'A' && ${country} != '')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND MPRH.COST_OFC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])" ).append("\n"); 
		query.append("#if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND MOH.COST_OFC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])" ).append("\n"); 
		query.append("#if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MPIW.ISS_OFC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.LOC_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CNT_CD = @[country])" ).append("\n"); 
		query.append("#if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND	MPRH.COST_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("'$user_ofcCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_ofcCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND	MOH.COST_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("'$user_ofcCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_ofcCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	MPIW.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_ofcCds IN ${ofcCds})" ).append("\n"); 
		query.append("#if($velocityCount < $ofcCds.size())" ).append("\n"); 
		query.append("'$user_ofcCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_ofcCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND MPRH.VNDR_SEQ    = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND MOH.VNDR_SEQ     = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MPIW.MNR_PRNR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_wo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	MOH.MNR_WO_TP_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_wotpCds IN ${wotpCds})" ).append("\n"); 
		query.append("#if($velocityCount < $wotpCds.size())" ).append("\n"); 
		query.append("'$user_wotpCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_wotpCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI')" ).append("\n"); 
		query.append("GROUP BY MPRH.COST_OFC_CD, MPRH.VNDR_SEQ, MOH.MNR_WO_TP_CD,MOH.COST_CD ,MOD.COST_DTL_CD,MPRH.EQ_TPSZ_CD,MOD.MNR_HNGR_BAR_TP_CD,MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(", MOD.SPR_PRT_NO, MOH.SPR_PRT_SPL_YD_CD, MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD, MPRH.CURR_CD,MOD.ACCT_CD" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("GROUP BY MOH.COST_OFC_CD, MOH.VNDR_SEQ, MOH.MNR_WO_TP_CD,MOH.COST_CD ,MOD.COST_DTL_CD,MOD.EQ_TPSZ_CD,MOD.MNR_HNGR_BAR_TP_CD,MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(", MOD.SPR_PRT_NO, MOH.SPR_PRT_SPL_YD_CD, MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD, MOH.CURR_CD,MOD.ACCT_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY MPIW.ISS_OFC_CD, MPIW.MNR_PRNR_SEQ, MOH.MNR_WO_TP_CD,MOH.COST_CD ,MOD.COST_DTL_CD,MOD.EQ_TPSZ_CD,MOD.MNR_HNGR_BAR_TP_CD,MOD.SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(", MOD.SPR_PRT_NO, MOH.SPR_PRT_SPL_YD_CD, MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD, MPIW.CURR_CD,MOD.ACCT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  SUMA" ).append("\n"); 
		query.append("ORDER BY SUMA.MNR_WO_TP_NM,SUMA.COST_OFC_CD" ).append("\n"); 

	}
}