/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationReportDBDAOSummaryReportByCustomerDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
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

public class ChargeCalculationReportDBDAOSummaryReportByCustomerDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer별 발생 Charge정보의 Detail조회
	  * </pre>
	  */
	public ChargeCalculationReportDBDAOSummaryReportByCustomerDetailVORSQL(){
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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAOSummaryReportByCustomerDetailVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("			,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST_CD" ).append("\n"); 
		query.append("	,'' ACUST_NM" ).append("\n"); 
		query.append("	,B.SC_NO" ).append("\n"); 
		query.append("    ,B.RFA_NO" ).append("\n"); 
		query.append("	,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,C.CNTR_NO" ).append("\n"); 
		query.append("	,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("	,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("	,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	,C.FT_DYS" ).append("\n"); 
		query.append("	,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("	,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("	,TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("	,TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("	,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("	,C.SC_RFA_EXPT_AMT AS EXPT_AMT" ).append("\n"); 
		query.append("	,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,C.BIL_AMT" ).append("\n"); 
		query.append("	,B.BKG_NO" ).append("\n"); 
		query.append("	,B.BL_NO" ).append("\n"); 
		query.append("	,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("	,(	SELECT	V.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("		FROM	VSK_VSL_SKD V" ).append("\n"); 
		query.append("		WHERE	B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("		AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append("	) AS LANE" ).append("\n"); 
		query.append("	,B.POR_CD" ).append("\n"); 
		query.append("	,B.POL_CD" ).append("\n"); 
		query.append("	,B.POD_CD" ).append("\n"); 
		query.append("	,B.DEL_CD" ).append("\n"); 
		query.append("	,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,TO_CHAR(V.CRE_DT, 'YYYYMMDD') AS ISS_DT" ).append("\n"); 
		query.append("	,DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("    ,C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("	,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("	,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,C.CHG_SEQ" ).append("\n"); 
		query.append("	,V.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	,V.INV_CURR_CD" ).append("\n"); 
		query.append("	,D.CNTR_INV_AMT AS INV_CHG_AMT" ).append("\n"); 
		query.append("	,V.DMDT_INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC        C," ).append("\n"); 
		query.append("        DMT_CHG_BKG_CNTR    B," ).append("\n"); 
		query.append("		DMT_INV_MN			V," ).append("\n"); 
		query.append("		DMT_INV_DTL			D," ).append("\n"); 
		query.append("		BKG_BOOKING			BK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	#if (${sc_no} != '')" ).append("\n"); 
		query.append("		B.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND C.TO_MVMT_DT BETWEEN TO_DATE(@[start_dt],'YYYYMMDD') + .0" ).append("\n"); 
		query.append("						 AND TO_DATE(@[end_dt],'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND	C.OFC_CD		= @[ofc_cd]" ).append("\n"); 
		query.append("	AND	C.DMDT_TRF_CD	= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'N')" ).append("\n"); 
		query.append("	AND C.SYS_AREA_GRP_ID	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND C.CNTR_NO			= B.CNTR_NO" ).append("\n"); 
		query.append("	AND C.CNTR_CYC_NO		= B.CNTR_CYC_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND C.DMDT_CHG_LOC_DIV_CD <> 'SZP'			-- 2010/03/19 추가" ).append("\n"); 
		query.append("	AND	-- 2010/03/25 추가" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'C')" ).append("\n"); 
		query.append("	    OR        " ).append("\n"); 
		query.append("	    (C.DUL_TP_EXPT_FLG = 'N')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND B.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("		(SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		   FROM COM_SYS_AREA_GRP_ID S, MDM_ORGANIZATION M" ).append("\n"); 
		query.append("		  WHERE CNT_CD = SUBSTR (LOC_CD, 1, 2)" ).append("\n"); 
		query.append("			AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("			AND M.OFC_CD = C.OFC_CD)" ).append("\n"); 
		query.append("	AND B.BKG_NO				=   BK.BKG_NO" ).append("\n"); 
		query.append("	AND C.DMDT_INV_NO			=	V.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("	AND C.DMDT_INV_NO			=	D.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("	AND C.CNTR_NO				=	D.CNTR_NO(+)" ).append("\n"); 
		query.append("--	AND C.OFC_CD				=   V.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("	AND V.DMDT_INV_STS_CD(+)	=	'I'     	/* IF 'Y' IS CANCEL AMT */" ).append("\n"); 
		query.append("	AND (   " ).append("\n"); 
		query.append("        	(C.DMDT_INV_NO IS  NULL)" ).append("\n"); 
		query.append("        	OR" ).append("\n"); 
		query.append("        	(C.DMDT_INV_NO IS NOT NULL AND  V.DMDT_AR_IF_CD	<>	'H')	/* HOLD EXCEPTION   */" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	AND DECODE(C.DMDT_TRF_CD,'DMOF', SUBSTR(C.FM_MVMT_YD_CD, 1, 5), 'DMIF', SUBSTR(C.FM_MVMT_YD_CD, 1, 5)" ).append("\n"); 
		query.append("							,'DTIC', B.DEL_CD, 'CTIC', B.DEL_CD" ).append("\n"); 
		query.append("							,'DTOC', B.POR_CD, 'CTOC', B.POR_CD) = @[cvr_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND	B.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("	AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("	AND B.DEL_CD = @[del_cd]" ).append("\n"); 

	}
}