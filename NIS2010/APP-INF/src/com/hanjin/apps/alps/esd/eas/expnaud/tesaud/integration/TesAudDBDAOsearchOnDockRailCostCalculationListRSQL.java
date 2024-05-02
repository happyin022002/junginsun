/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAudDBDAOsearchOnDockRailCostCalculationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAudDBDAOsearchOnDockRailCostCalculationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOnDockRailCostCalculationList
	  * </pre>
	  */
	public TesAudDBDAOsearchOnDockRailCostCalculationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration").append("\n"); 
		query.append("FileName : TesAudDBDAOsearchOnDockRailCostCalculationListRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("		RHQ," ).append("\n"); 
		query.append("		INV_OFC_CD," ).append("\n"); 
		query.append("		COST_OFC_CD," ).append("\n"); 
		query.append("		YD_CD," ).append("\n"); 
		query.append("		VNDR_SEQ," ).append("\n"); 
		query.append("		VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("		INV_NO," ).append("\n"); 
		query.append("		CRE_USR_NM," ).append("\n"); 
		query.append("		CALC_TP_CD," ).append("\n"); 
		query.append("		LGS_COST_CD," ).append("\n"); 
		query.append("		CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		TML_WRK_DY_CD," ).append("\n"); 
		query.append("		DCGO_IND_CD," ).append("\n"); 
		query.append("		CALC_VOL_QTY," ).append("\n"); 
		query.append("		RVIS_VOL_QTY," ).append("\n"); 
		query.append("		VOL_TR_UT_CD," ).append("\n"); 
		query.append("		CTRT_RT," ).append("\n"); 
		query.append("		CURR_CD," ).append("\n"); 
		query.append("		INV_XCH_RT," ).append("\n"); 
		query.append("		INV_AMT," ).append("\n"); 
		query.append("		CALC_RMK," ).append("\n"); 
		query.append("		N3PTY_FLG," ).append("\n"); 
		query.append("		ROW_COUNT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("    SELECT	DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD)) AS RHQ " ).append("\n"); 
		query.append("    		, TES.INV_OFC_CD" ).append("\n"); 
		query.append("    		, TES.COST_OFC_CD" ).append("\n"); 
		query.append("    		, TES.YD_CD			-- YARD" ).append("\n"); 
		query.append("    		, TES.VNDR_SEQ			-- S/P" ).append("\n"); 
		query.append("    		, V.VNDR_LGL_ENG_NM		-- S/P NAME" ).append("\n"); 
		query.append("    		, TES.INV_NO" ).append("\n"); 
		query.append("			, TES.CRE_USR_NM		" ).append("\n"); 
		query.append("    		, DECODE(TES.CALC_TP_CD, 'A', 'Auto Input', 'S', 'Semi-updated', 'Manual Input') AS CALC_TP_CD	-- Calculated Type" ).append("\n"); 
		query.append("    		, TES.LGS_COST_CD			-- Cost Code" ).append("\n"); 
		query.append("    		, TES.CNTR_TPSZ_CD			-- Type/Size" ).append("\n"); 
		query.append("    		, TES.TML_WRK_DY_CD			-- Applied Date" ).append("\n"); 
		query.append("    		, TES.DCGO_IND_CD			-- DG" ).append("\n"); 
		query.append("    		, TES.CALC_VOL_QTY			-- CAlculated Vol." ).append("\n"); 
		query.append("    		, TES.RVIS_VOL_QTY			-- Revised Vol." ).append("\n"); 
		query.append("    		, TES.VOL_TR_UT_CD			-- UOM" ).append("\n"); 
		query.append("    		, TES.CTRT_RT				-- Rate" ).append("\n"); 
		query.append("    		, TES.CURR_CD				-- AGMT Curr." ).append("\n"); 
		query.append("    		, TES.INV_XCH_RT			-- Exch Rate" ).append("\n"); 
		query.append("    		, TES.INV_AMT				-- Amount(USD)" ).append("\n"); 
		query.append("    		, TES.CALC_RMK				-- Remark" ).append("\n"); 
		query.append("    		, TES.N3PTY_FLG				-- 3rd Party" ).append("\n"); 
		query.append("    		,ROW_NUMBER() OVER (ORDER BY TES.INV_NO ASC) AS ROW_NUM" ).append("\n"); 
		query.append("		    ,COUNT(TES.INV_NO) OVER() AS ROW_COUNT" ).append("\n"); 
		query.append("    FROM	(				" ).append("\n"); 
		query.append("    		SELECT	 H.INV_OFC_CD" ).append("\n"); 
		query.append("    				, H.COST_OFC_CD" ).append("\n"); 
		query.append("    				, H.YD_CD" ).append("\n"); 
		query.append("    				, H.VNDR_SEQ" ).append("\n"); 
		query.append("    				, H.INV_NO	  " ).append("\n"); 
		query.append("    				, D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    				, D.TML_SO_SEQ" ).append("\n"); 
		query.append("    				, D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("    				, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("    				, DECODE(D.CALC_TP_CD, 'A', D.CALC_TP_CD, (DECODE(D.SEMI_AUTO_CALC_FLG, 'Y','S', D.CALC_TP_CD))) AS CALC_TP_CD" ).append("\n"); 
		query.append("    				, D.VSL_CD" ).append("\n"); 
		query.append("    				, D.SKD_VOY_NO" ).append("\n"); 
		query.append("    				, D.SKD_DIR_CD " ).append("\n"); 
		query.append("    				, D.VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD_NO" ).append("\n"); 
		query.append("    				, D.FINC_VSL_CD" ).append("\n"); 
		query.append("    				, D.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("    				, D.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("    				, D.IOC_CD" ).append("\n"); 
		query.append("    				, D.LANE_CD" ).append("\n"); 
		query.append("    				, D.IO_BND_CD" ).append("\n"); 
		query.append("    				, D.LGS_COST_CD" ).append("\n"); 
		query.append("    				, D.LGS_COST_CD AS LGS_COST_CD2" ).append("\n"); 
		query.append("    				, D.ACCT_CD" ).append("\n"); 
		query.append("    				, TO_CHAR(ATB_DT,'YYYYMMDD') AS ATB_DT" ).append("\n"); 
		query.append("    				, D.CNTR_NO" ).append("\n"); 
		query.append("    				, D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    				, D.CNTR_TPSZ_CD AS CNTR_TPSZ_CD2" ).append("\n"); 
		query.append("    				, D.CALC_VOL_QTY" ).append("\n"); 
		query.append("    				, D.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("    				, D.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("    				, D.RVIS_VOL_QTY" ).append("\n"); 
		query.append("    				, D.DCGO_IND_CD" ).append("\n"); 
		query.append("    				, D.STAY_DYS" ).append("\n"); 
		query.append("    				, D.FREE_DYS" ).append("\n"); 
		query.append("    				, D.OVR_DYS" ).append("\n"); 
		query.append("    				, D.FP_CALC_PRD_CD" ).append("\n"); 
		query.append("    				, D.WRK_DT" ).append("\n"); 
		query.append("    				, D.TML_WRK_DY_CD" ).append("\n"); 
		query.append("    				, D.STK_VOL_QTY" ).append("\n"); 
		query.append("    				, D.FP_TEU_QTY" ).append("\n"); 
		query.append("    				, D.INV_VOL_QTY" ).append("\n"); 
		query.append("    				, D.DIFF_VOL_QTY" ).append("\n"); 
		query.append("    				, D.OVR_VOL_QTY" ).append("\n"); 
		query.append("    				, D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("    				, D.CTRT_RT" ).append("\n"); 
		query.append("    				, LPAD(REF_VNDR_SEQ,6,'0') AS REF_VNDR_SEQ" ).append("\n"); 
		query.append("    				, D.CALC_AMT" ).append("\n"); 
		query.append("    				, D.INV_AMT" ).append("\n"); 
		query.append("    				, D.TML_CRR_CD" ).append("\n"); 
		query.append("    				, D.CALC_RMK" ).append("\n"); 
		query.append("    				, D.CURR_CD" ).append("\n"); 
		query.append("    				, D.INV_XCH_RT" ).append("\n"); 
		query.append("    				, D.N3PTY_FLG" ).append("\n"); 
		query.append("    				, D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    				, D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("    				, D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("					, (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("    		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("    				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("					, AP_INV_HDR A" ).append("\n"); 
		query.append("					, COM_APRO_CSR_DTL C" ).append("\n"); 
		query.append("					, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("    		WHERE	1	= 1" ).append("\n"); 
		query.append("    		AND		H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    		AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("    		AND		H.TML_INV_TP_CD		= 'ON'" ).append("\n"); 
		query.append("    --		--// 1. Invoice Date" ).append("\n"); 
		query.append("		--// CHM-201642099 TES Intensive Audit 검색 조건 code 추가 (2016-06-16)" ).append("\n"); 
		query.append("			AND		H.CSR_NO			= A.CSR_NO(+)" ).append("\n"); 
		query.append("			AND		H.CSR_NO			= C.CSR_NO(+)" ).append("\n"); 
		query.append("			AND		C.APRO_RQST_NO		= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("			#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("			AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("			AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("			AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("			AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("			OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("			AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("			AND		A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("         --		--// 2. YARD CODE" ).append("\n"); 
		query.append("    		#if ( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("    		AND		H.YD_CD		 = @[yd_cd]" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          --		--// 3. S/P CODE" ).append("\n"); 
		query.append("    		#if ( ${vndr_seq} != '' ) " ).append("\n"); 
		query.append("    		AND		H.VNDR_SEQ		 = @[vndr_seq] 	" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          --		--// 6. Cost Office" ).append("\n"); 
		query.append("    		#if ( ${cost_ofc_cd} != '' )" ).append("\n"); 
		query.append("    		AND		H.COST_OFC_CD	= @[cost_ofc_cd] " ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          --		--// 7. Invoice Office" ).append("\n"); 
		query.append("    		#if ( ${inv_ofc_cd} != '' )" ).append("\n"); 
		query.append("    		AND		H.INV_OFC_CD	= @[inv_ofc_cd]" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("    	  --		--// 7. Invoice No" ).append("\n"); 
		query.append("    		#if ( ${inv_no} != '' )" ).append("\n"); 
		query.append("    		AND		H.INV_NO	= @[inv_no]" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("          --		--// 8. Inv Status" ).append("\n"); 
		query.append("    		#if ( ${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("    		AND		H.TML_INV_STS_CD = @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("         --		--// 4. Manual Input Only" ).append("\n"); 
		query.append("    		#if ( ${manual_check} != '' ) " ).append("\n"); 
		query.append("    		AND		D.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    		) TES" ).append("\n"); 
		query.append("    		, MDM_ORGANIZATION O" ).append("\n"); 
		query.append("    		, MDM_LOCATION L" ).append("\n"); 
		query.append("    		, MDM_VENDOR V" ).append("\n"); 
		query.append("    WHERE	1	= 1" ).append("\n"); 
		query.append("    AND		TES.INV_OFC_CD	= O.OFC_CD(+)" ).append("\n"); 
		query.append("    AND		O.LOC_CD     	= L.LOC_CD(+)" ).append("\n"); 
		query.append("    AND		TES.VNDR_SEQ	= V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    ORDER BY DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD))" ).append("\n"); 
		query.append("    		, INV_OFC_CD, COST_OFC_CD, YD_CD, VNDR_SEQ, INV_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE    ROW_NUM >= (@[pagerows] * (@[page_no] - 1) + 1)" ).append("\n"); 
		query.append("AND    ROW_NUM <= (@[pagerows] * @[page_no])" ).append("\n"); 

	}
}