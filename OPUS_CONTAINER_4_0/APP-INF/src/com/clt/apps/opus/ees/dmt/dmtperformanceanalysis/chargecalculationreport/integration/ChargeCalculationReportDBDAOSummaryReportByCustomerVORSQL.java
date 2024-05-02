/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer별 발생 Charge정보의 Summary조회
	  * </pre>
	  */
	public ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAOSummaryReportByCustomerVORSQL").append("\n"); 
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
		query.append("WITH RSLT AS (" ).append("\n"); 
		query.append("	SELECT	DB.RFA_NO RFA_NO," ).append("\n"); 
		query.append("			DB.SC_NO SC_NO," ).append("\n"); 
		query.append("			DB.POR_CD POR_CD," ).append("\n"); 
		query.append("			DB.POL_CD POL_CD," ).append("\n"); 
		query.append("			DB.POD_CD POD_CD," ).append("\n"); 
		query.append("			DB.DEL_CD DEL_CD," ).append("\n"); 
		query.append("			DC.DMDT_TRF_CD TRF_CD," ).append("\n"); 
		query.append("			DC.OFC_CD DMDT_OFC," ).append("\n"); 
		query.append("			DC.CHG_SEQ," ).append("\n"); 
		query.append("			DC.TO_MVMT_DT," ).append("\n"); 
		query.append("			DC.FM_MVMT_DT," ).append("\n"); 
		query.append("			DC.DMDT_CHG_STS_CD," ).append("\n"); 
		query.append("			DC.FX_FT_OVR_DYS," ).append("\n"); 
		query.append("			DC.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("			DC.ORG_CHG_AMT," ).append("\n"); 
		query.append("			DC.CMDT_EXPT_AMT," ).append("\n"); 
		query.append("			DC.SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("			DC.AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("			DC.BIL_AMT," ).append("\n"); 
		query.append("			DC.DMDT_INV_NO," ).append("\n"); 
		query.append("			DC.CNTR_NO," ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("				WHEN	DC.DMDT_TRF_CD = 'DMOF'" ).append("\n"); 
		query.append("					OR	DC.DMDT_TRF_CD = 'DMIF' THEN SUBSTR (DC.FM_MVMT_YD_CD, 1, 5)" ).append("\n"); 
		query.append("				WHEN	DC.DMDT_TRF_CD = 'DTIC'" ).append("\n"); 
		query.append("					OR	DC.DMDT_TRF_CD = 'CTIC' THEN DB.DEL_CD" ).append("\n"); 
		query.append("				WHEN	DC.DMDT_TRF_CD = 'DTOC'" ).append("\n"); 
		query.append("					OR	DC.DMDT_TRF_CD = 'CTOC' THEN DB.POR_CD" ).append("\n"); 
		query.append("			END AS CVR" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    FROM	DMT_CHG_BKG_CNTR DB," ).append("\n"); 
		query.append("			DMT_CHG_CALC DC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	AND DC.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt], 'YYYYMMDD') + .0" ).append("\n"); 
		query.append("						  AND TO_DATE(@[end_dt], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("	#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("		AND	DC.OFC_CD	IN (" ).append("\n"); 
		query.append("			#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("		AND	DC.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("	AND DC.DMDT_TRF_CD	IN (" ).append("\n"); 
		query.append("					#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	AND DC.DMDT_CHG_STS_CD	IN ('F', 'C', 'I', 'N')	" ).append("\n"); 
		query.append("	AND DC.SYS_AREA_GRP_ID	= DB.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND DC.CNTR_NO			= DB.CNTR_NO" ).append("\n"); 
		query.append("	AND DC.CNTR_CYC_NO		= DB.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND	DC.DMDT_CHG_LOC_DIV_CD <> 'SZP'				-- 2010/03/18 추가" ).append("\n"); 
		query.append("	AND	-- 2010/03/25 추가" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    (DC.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(DC.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("	    OR        " ).append("\n"); 
		query.append("	    (DC.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(") --END WITH STATEMENT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	X.ORD," ).append("\n"); 
		query.append("	X.SC_NO," ).append("\n"); 
		query.append("	X.RFA_NO," ).append("\n"); 
		query.append("	X.SC_NO || X.RFA_NO AS SC_RFA_NO," ).append("\n"); 
		query.append("	X.CUST_CD," ).append("\n"); 
		query.append("	X.CUST_NAME AS CUST_NM," ).append("\n"); 
		query.append("	X.CTRT_OFC," ).append("\n"); 
		query.append("	X.DMDT_OFC," ).append("\n"); 
		query.append("	X.TRF_CD," ).append("\n"); 
		query.append("	X.CVR AS CVR_CD," ).append("\n"); 
		query.append("	X.POR_CD," ).append("\n"); 
		query.append("	X.POL_CD," ).append("\n"); 
		query.append("	X.POD_CD," ).append("\n"); 
		query.append("	X.DEL_CD," ).append("\n"); 
		query.append("	SUM(ROUND(X.TO_MVMT_DT - X.FM_MVMT_DT, 0) + 1) TTL_STY," ).append("\n"); 
		query.append("	SUM(DECODE(X.CHG_SEQ, 1, 1, 0)) TTL_CNTR," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN COUNT(X.CNTR_NO) = 0 THEN 0" ).append("\n"); 
		query.append("        ELSE ROUND( SUM(ROUND(X.TO_MVMT_DT - X.FM_MVMT_DT, 0) + 1) / COUNT(X.CNTR_NO), 0) " ).append("\n"); 
		query.append("    END AVG_STY,    " ).append("\n"); 
		query.append("    SUM(DECODE(X.DMDT_CHG_STS_CD, 'F', X.FX_FT_OVR_DYS, 'C', X.FX_FT_OVR_DYS, 'I', X.FX_FT_OVR_DYS, 0)) TTL_OVER," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	SUM(DECODE(X.DMDT_CHG_STS_CD, 'F', DECODE(X.CHG_SEQ, 1, 1, 0), 'C', DECODE(X.CHG_SEQ, 1, 1, 0), 'I', DECODE(X.CHG_SEQ, 1, 1, 0), 0)) OVER_CNTR," ).append("\n"); 
		query.append("	--DECODE( SUM(DECODE(X.CHG_SEQ, 1, 1, 0)), 0, 0, ROUND( SUM( DECODE( NVL(X.ORG_CHG_AMT, 0), 0, 0, 1 ) ) / SUM(DECODE(X.CHG_SEQ, 1, 1, 0)) ,2) ) INCUR_RTO," ).append("\n"); 
		query.append("	--DECODE( SUM(DECODE(X.CHG_SEQ, 1, 1, 0)), 0, 0, ROUND( SUM( DECODE( NVL(X.SC_RFA_EXPT_AMT, 0), 0, 0, 1 ) ) / SUM(DECODE(X.CHG_SEQ, 1, 1, 0)) , 2) ) EXPT_RTO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN SUM(DECODE(X.DMDT_CHG_STS_CD, 'F', 1, 'C', 1, 'I', 1, 0)) = 0 THEN 0" ).append("\n"); 
		query.append("        ELSE ROUND(SUM(DECODE(X.DMDT_CHG_STS_CD, 'F', X.FX_FT_OVR_DYS, 'C', X.FX_FT_OVR_DYS, 'I', X.FX_FT_OVR_DYS, 0))" ).append("\n"); 
		query.append("                 / SUM(DECODE(X.DMDT_CHG_STS_CD, 'F', 1, 'C', 1, 'I', 1, 0)), 0) " ).append("\n"); 
		query.append("    END AVG_OVER," ).append("\n"); 
		query.append("	DECODE( @[curr_flg], 'U', 'USD', X.BZC_TRF_CURR_CD ) CURR_CD," ).append("\n"); 
		query.append("	SUM( DECODE( NVL(X.ORG_CHG_AMT, 0), 0, 0, DECODE(X.CHG_SEQ, 1, 1, 0) ) ) INCUR_CNTR," ).append("\n"); 
		query.append("	ROUND ( SUM ( DECODE( @[curr_flg], 'U', X.ORG_CHG_AMT  / F.USD_LOCL_XCH_RT, X.ORG_CHG_AMT  ) ), 2 ) INCUR_AMT," ).append("\n"); 
		query.append("	SUM( DECODE( NVL(X.CMDT_EXPT_AMT, 0), 0, 0, DECODE(X.CHG_SEQ, 1, 1, 0) ) ) CMDT_CNTR," ).append("\n"); 
		query.append("	ROUND ( SUM ( DECODE( @[curr_flg], 'U', NVL(X.CMDT_EXPT_AMT, 0) / F.USD_LOCL_XCH_RT, NVL(X.CMDT_EXPT_AMT, 0) ) ), 2 ) CMDT_AMT," ).append("\n"); 
		query.append("	SUM( DECODE( NVL(X.SC_RFA_EXPT_AMT, 0), 0, 0, DECODE(X.CHG_SEQ, 1, 1, 0) ) ) EXPT_CNTR," ).append("\n"); 
		query.append("	ROUND ( SUM ( DECODE( @[curr_flg], 'U', X.SC_RFA_EXPT_AMT / F.USD_LOCL_XCH_RT, X.SC_RFA_EXPT_AMT) ), 2 ) EXPT_AMT," ).append("\n"); 
		query.append("	SUM( DECODE( NVL(X.AFT_EXPT_DC_AMT, 0), 0, 0, DECODE(X.CHG_SEQ, 1, 1, 0) ) ) DC_CNTR," ).append("\n"); 
		query.append("	ROUND ( SUM ( DECODE( @[curr_flg], 'U', X.AFT_EXPT_DC_AMT  / F.USD_LOCL_XCH_RT, X.AFT_EXPT_DC_AMT  ) ), 2 ) DC_AMT," ).append("\n"); 
		query.append("	/* BILLABLE */" ).append("\n"); 
		query.append("	SUM( DECODE( NVL(X.BIL_AMT, 0), 0, 0, DECODE(X.CHG_SEQ, 1, 1, 0) ) ) BILL_CNTR," ).append("\n"); 
		query.append("	ROUND( SUM( DECODE( @[curr_flg], 'U', X.BIL_AMT / F.USD_LOCL_XCH_RT, X.BIL_AMT ) ), 2 ) BILL_AMT," ).append("\n"); 
		query.append("	/* INVOICE */" ).append("\n"); 
		query.append("	SUM( DECODE( V.DMDT_INV_STS_CD, 'I', DECODE(X.CHG_SEQ, 1, 1, 0), 0 ) ) INV_CNTR," ).append("\n"); 
		query.append("	ROUND( SUM( DECODE( V.DMDT_INV_STS_CD, 'I', DECODE( @[curr_flg], 'U', X.BIL_AMT / F.USD_LOCL_XCH_RT, X.BIL_AMT), 0) ), 2 ) INV_AMT," ).append("\n"); 
		query.append("	/* COLLECTION */" ).append("\n"); 
		query.append("	SUM( DECODE( V.DMDT_AR_IF_CD, 'Y', DECODE(X.CHG_SEQ, 1, 1, 0), 0 ) ) COLL_CNTR," ).append("\n"); 
		query.append("	ROUND( SUM( DECODE (V.DMDT_AR_IF_CD, 'Y', DECODE( @[curr_flg], 'U', X.BIL_AMT / F.USD_LOCL_XCH_RT, X.BIL_AMT ), 0) ), 2 ) COLL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_INV_MN		V," ).append("\n"); 
		query.append("		GL_MON_XCH_RT	F," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT	2 AS ORD," ).append("\n"); 
		query.append("				CTRT.RFA_NO," ).append("\n"); 
		query.append("				'' AS SC_NO," ).append("\n"); 
		query.append("				CTRT.CTRT_CUST_CNT_CD || LPAD(CTRT.CTRT_CUST_SEQ, 6, '0') AS CUST_CD," ).append("\n"); 
		query.append("				(	SELECT  MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("					FROM    MDM_CUSTOMER MC" ).append("\n"); 
		query.append("					WHERE   MC.CUST_CNT_CD  = CTRT.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("					AND     MC.CUST_SEQ     = CTRT.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("				) AS CUST_NAME," ).append("\n"); 
		query.append("				CTRT.PROP_OFC_CD CTRT_OFC," ).append("\n"); 
		query.append("				R.DMDT_OFC," ).append("\n"); 
		query.append("				R.TRF_CD," ).append("\n"); 
		query.append("				R.POR_CD POR_CD," ).append("\n"); 
		query.append("				R.POL_CD POL_CD," ).append("\n"); 
		query.append("				R.POD_CD POD_CD," ).append("\n"); 
		query.append("				R.DEL_CD DEL_CD," ).append("\n"); 
		query.append("				R.CHG_SEQ," ).append("\n"); 
		query.append("				R.TO_MVMT_DT," ).append("\n"); 
		query.append("				R.FM_MVMT_DT," ).append("\n"); 
		query.append("				R.DMDT_CHG_STS_CD," ).append("\n"); 
		query.append("				R.FX_FT_OVR_DYS," ).append("\n"); 
		query.append("				R.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("				R.ORG_CHG_AMT," ).append("\n"); 
		query.append("				R.CMDT_EXPT_AMT," ).append("\n"); 
		query.append("				R.SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("				R.AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("				R.BIL_AMT," ).append("\n"); 
		query.append("				R.DMDT_INV_NO," ).append("\n"); 
		query.append("				R.CNTR_NO," ).append("\n"); 
		query.append("				R.CVR" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("            SELECT	RFH.RFA_NO, " ).append("\n"); 
		query.append("            		CTRT_CUST_CNT_CD, " ).append("\n"); 
		query.append("            		CTRT_CUST_SEQ, " ).append("\n"); 
		query.append("            		PROP_OFC_CD" ).append("\n"); 
		query.append("              FROM	PRI_RP_HDR RFH, " ).append("\n"); 
		query.append("              		PRI_RP_MN RFA" ).append("\n"); 
		query.append("             WHERE RFA.PROP_NO = RFH.PROP_NO" ).append("\n"); 
		query.append("               AND RFA.AMDT_SEQ = (SELECT MAX (AMDT_SEQ)" ).append("\n"); 
		query.append("                                     FROM PRI_RP_MN" ).append("\n"); 
		query.append("                                    WHERE PROP_NO = RFH.PROP_NO" ).append("\n"); 
		query.append("                                      AND ROWNUM <= 1)" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if (${sch_flg} == 'RFA')" ).append("\n"); 
		query.append("				AND RFH.RFA_NO	IN (" ).append("\n"); 
		query.append("									#foreach( $rfa_cd in ${sc_rfa_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $sc_rfa_cd_list.size()) '$rfa_cd', #else '$rfa_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("			#elseif (${sch_flg} == 'CTRT')" ).append("\n"); 
		query.append("				AND RFA.PROP_OFC_CD   = @[ctrt_ofc]" ).append("\n"); 
		query.append("			#elseif (${sch_flg} == 'CUST') " ).append("\n"); 
		query.append("				AND RFA.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("				AND RFA.CTRT_CUST_SEQ	= SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND 1=0		   " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("           ) CTRT," ).append("\n"); 
		query.append("           RSLT R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		-- DB.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("		AND R.RFA_NO = CTRT.RFA_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	SELECT	1 AS ORD," ).append("\n"); 
		query.append("				'' AS RFA_NO," ).append("\n"); 
		query.append("				CTRT.SC_NO," ).append("\n"); 
		query.append("				CTRT.CTRT_CUST_CNT_CD || LPAD (CTRT.CTRT_CUST_SEQ, 6, '0') AS CUST_CD," ).append("\n"); 
		query.append("				CTRT.CUST_NAME AS CUST_NAME," ).append("\n"); 
		query.append("				CTRT.PROP_OFC_CD AS CTRT_OFC," ).append("\n"); 
		query.append("				R.DMDT_OFC," ).append("\n"); 
		query.append("				R.TRF_CD," ).append("\n"); 
		query.append("				R.POR_CD POR_CD," ).append("\n"); 
		query.append("				R.POL_CD POL_CD," ).append("\n"); 
		query.append("				R.POD_CD POD_CD," ).append("\n"); 
		query.append("				R.DEL_CD DEL_CD," ).append("\n"); 
		query.append("				R.CHG_SEQ," ).append("\n"); 
		query.append("				R.TO_MVMT_DT," ).append("\n"); 
		query.append("				R.FM_MVMT_DT," ).append("\n"); 
		query.append("				R.DMDT_CHG_STS_CD," ).append("\n"); 
		query.append("				R.FX_FT_OVR_DYS," ).append("\n"); 
		query.append("				R.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("				R.ORG_CHG_AMT," ).append("\n"); 
		query.append("				R.CMDT_EXPT_AMT," ).append("\n"); 
		query.append("				R.SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("				R.AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("				R.BIL_AMT," ).append("\n"); 
		query.append("				R.DMDT_INV_NO," ).append("\n"); 
		query.append("				R.CNTR_NO," ).append("\n"); 
		query.append("				R.CVR" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT	SPH.SC_NO, " ).append("\n"); 
		query.append("					SCP.CUST_CNT_CD AS CTRT_CUST_CNT_CD," ).append("\n"); 
		query.append("					SCP.CUST_SEQ AS CTRT_CUST_SEQ, " ).append("\n"); 
		query.append("					SC.PROP_OFC_CD, " ).append("\n"); 
		query.append("					SCP.CTRT_PTY_NM CUST_NAME" ).append("\n"); 
		query.append("              FROM	PRI_SP_HDR SPH, " ).append("\n"); 
		query.append("              		PRI_SP_MN SC, " ).append("\n"); 
		query.append("              		PRI_SP_CTRT_PTY SCP" ).append("\n"); 
		query.append("             WHERE	SPH.PROP_NO = SC.PROP_NO" ).append("\n"); 
		query.append("               AND	SCP.PROP_NO = SPH.PROP_NO" ).append("\n"); 
		query.append("               AND	SC.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("               AND	SCP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND	SC.AMDT_SEQ = (	SELECT MAX (AMDT_SEQ)" ).append("\n"); 
		query.append("                                      FROM PRI_SP_MN" ).append("\n"); 
		query.append("                                     WHERE PROP_NO = SPH.PROP_NO" ).append("\n"); 
		query.append("                                       AND ROWNUM <= 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${sch_flg} == 'SC')" ).append("\n"); 
		query.append("					AND SPH.SC_NO	IN (" ).append("\n"); 
		query.append("									#foreach( $sc_cd in ${sc_rfa_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $sc_rfa_cd_list.size()) '$sc_cd', #else '$sc_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("				#elseif (${sch_flg} == 'CTRT')" ).append("\n"); 
		query.append("					AND SC.PROP_OFC_CD	= @[ctrt_ofc]	" ).append("\n"); 
		query.append("				#elseif (${sch_flg} == 'CUST') " ).append("\n"); 
		query.append("               		AND SCP.CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("               		AND SCP.CUST_SEQ	= SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND 1=0" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           ) CTRT," ).append("\n"); 
		query.append("            RSLT R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     	-- DB.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("       AND R.SC_NO = CTRT.SC_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	X.DMDT_INV_NO			= V.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND		V.DMDT_INV_STS_CD(+)	= 'I'     /* IF 'Y' IS CANCEL AMT */" ).append("\n"); 
		query.append("AND (   " ).append("\n"); 
		query.append("        (X.DMDT_INV_NO IS  NULL)" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("        (	X.DMDT_INV_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND V.DMDT_AR_IF_CD	<>	'H'" ).append("\n"); 
		query.append("        )     	/* HOLD EXCEPTION   */" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND  F.ACCT_XCH_RT_YRMON	=	TO_CHAR(X.TO_MVMT_DT,'YYYYMM')" ).append("\n"); 
		query.append("AND  F.ACCT_XCH_RT_LVL		=	'1'" ).append("\n"); 
		query.append("AND  F.CURR_CD				=	X.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cvr_cd} != '')	" ).append("\n"); 
		query.append("	##${cvr_cd}" ).append("\n"); 
		query.append("	#if ($cvr_cd.length() == 2)" ).append("\n"); 
		query.append("		AND	SUBSTR(X.CVR, 1, 2) = @[cvr_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	X.CVR = @[cvr_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("	#if ($por_cd.length() == 2)" ).append("\n"); 
		query.append("		AND	SUBSTR(X.POR_CD, 1, 2) = @[por_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	X.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("	#if ($pol_cd.length() == 2)" ).append("\n"); 
		query.append("		AND	SUBSTR(X.POL_CD, 1, 2) = @[pol_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	X.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	#if ($pod_cd.length() == 2)" ).append("\n"); 
		query.append("		AND	SUBSTR(X.POD_CD, 1, 2) = @[pod_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	X.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("	#if ($del_cd.length() == 2)" ).append("\n"); 
		query.append("		AND	SUBSTR(X.DEL_CD, 1, 2) = @[del_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	X.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	X.ORD, X.SC_NO, X.RFA_NO, X.SC_NO||X.RFA_NO, X.CUST_CD, X.CUST_NAME, X.CTRT_OFC, X.DMDT_OFC," ).append("\n"); 
		query.append("			X.TRF_CD, X.CVR, X.POR_CD, X.POL_CD, X.POD_CD, X.DEL_CD, X.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY	X.ORD, X.SC_NO, X.RFA_NO, X.CTRT_OFC, X.TRF_CD, X.DMDT_OFC, X.CVR, X.POR_CD, X.POL_CD,X.POD_CD, X.DEL_CD" ).append("\n"); 

	}
}