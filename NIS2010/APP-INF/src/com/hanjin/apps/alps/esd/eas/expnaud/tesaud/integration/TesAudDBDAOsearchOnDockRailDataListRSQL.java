/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAudDBDAOsearchOnDockRailDataListRSQL.java
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

public class TesAudDBDAOsearchOnDockRailDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOnDockRailDataList
	  * </pre>
	  */
	public TesAudDBDAOsearchOnDockRailDataListRSQL(){
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
		query.append("FileName : TesAudDBDAOsearchOnDockRailDataListRSQL").append("\n"); 
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
		query.append("		COST_OFC_CD," ).append("\n"); 
		query.append("		INV_OFC_CD," ).append("\n"); 
		query.append("		YD_CD," ).append("\n"); 
		query.append("		VNDR_SEQ," ).append("\n"); 
		query.append("		VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("		INV_NO," ).append("\n"); 
		query.append("		CRE_USR_NM," ).append("\n"); 
		query.append("		CNTR_NO," ).append("\n"); 
		query.append("		CNTR_DTC," ).append("\n"); 
		query.append("		CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		CNTR_STY_CD," ).append("\n"); 
		query.append("		DCGO_CLSS_CD," ).append("\n"); 
		query.append("		WRK_DT," ).append("\n"); 
		query.append("		CLM_DT," ).append("\n"); 
		query.append("		RAIL_BIL_DT," ).append("\n"); 
		query.append("		VRFY_RSLT_IND_CD," ).append("\n"); 
		query.append("		DSCR_IND_CD," ).append("\n"); 
		query.append("		CNTR_RMK," ).append("\n"); 
		query.append("		ROW_COUNT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("    SELECT	DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD)) RHQ," ).append("\n"); 
		query.append("			  TES.COST_OFC_CD" ).append("\n"); 
		query.append("			, TES.INV_OFC_CD" ).append("\n"); 
		query.append("			, TES.YD_CD" ).append("\n"); 
		query.append("			, TES.VNDR_SEQ			-- S/P" ).append("\n"); 
		query.append("			, V.VNDR_LGL_ENG_NM		-- S/P NAME" ).append("\n"); 
		query.append("			, TES.INV_NO" ).append("\n"); 
		query.append("			, TES.CRE_USR_NM" ).append("\n"); 
		query.append("			, TES.CNTR_NO" ).append("\n"); 
		query.append("			, TES.CNTR_DTC		" ).append("\n"); 
		query.append("			, TES.CNTR_TPSZ_CD		-- TYPE/SIZE" ).append("\n"); 
		query.append("			, TES.CNTR_STY_CD		-- F/M" ).append("\n"); 
		query.append("			, TES.DCGO_CLSS_CD		-- DG" ).append("\n"); 
		query.append("			, TES.WRK_DT			-- Working Date" ).append("\n"); 
		query.append("			, TES.CLM_DT			-- CLM Date" ).append("\n"); 
		query.append("			, TES.RAIL_BIL_DT		-- Rail Billing Date" ).append("\n"); 
		query.append("			, TES.VRFY_RSLT_IND_CD	-- Verify Result" ).append("\n"); 
		query.append("			, TES.DSCR_IND_CD" ).append("\n"); 
		query.append("			, TES.CNTR_RMK			-- Remark	" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER (ORDER BY TES.INV_NO ASC) AS ROW_NUM" ).append("\n"); 
		query.append("			,COUNT(TES.INV_NO) OVER() AS ROW_COUNT" ).append("\n"); 
		query.append("	FROM	(" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("				  H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, L.TML_SO_SEQ" ).append("\n"); 
		query.append("				, L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				, L.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("				, L.MODI_FLG AS CNTR_DTC" ).append("\n"); 
		query.append("				, L.DSCR_IND_CD" ).append("\n"); 
		query.append("				, DECODE(TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD), NULL, '', TES_GET_COMCODENAME_FNC('CD00823', DSCR_IND_CD)) AS DSCR_IND_NM" ).append("\n"); 
		query.append("				, L.RVIS_IND_FLG" ).append("\n"); 
		query.append("				, L.VSL_CD" ).append("\n"); 
		query.append("				, L.SKD_VOY_NO" ).append("\n"); 
		query.append("				, L.SKD_DIR_CD" ).append("\n"); 
		query.append("				, L.FINC_VSL_CD" ).append("\n"); 
		query.append("				, L.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("				, L.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("				, L.IO_BND_CD" ).append("\n"); 
		query.append("				, L.IOC_CD" ).append("\n"); 
		query.append("				, L.LANE_CD" ).append("\n"); 
		query.append("				, TO_CHAR(ATB_DT,'YYYY-MM-DD') AS ATB_DT" ).append("\n"); 
		query.append("				, L.CNTR_NO" ).append("\n"); 
		query.append("				, L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, L.CNTR_STY_CD" ).append("\n"); 
		query.append("				, L.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("				, L.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("				, SUBSTR(RCVDE_TERM_IND_CD,0,1)||'/'||SUBSTR(RCVDE_TERM_IND_CD,2,1) AS RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("				, L.PRE_YD_CD" ).append("\n"); 
		query.append("				, TO_CHAR(MVMT_GATE_IN_DT,'YYYY-MM-DD') AS MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				, TO_CHAR(INV_GATE_IN_DT,'YYYY-MM-DD') AS INV_GATE_IN_DT" ).append("\n"); 
		query.append("				, L.GATE_IN_TD_DYS" ).append("\n"); 
		query.append("				, L.MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				, L.INV_GATE_OUT_DT" ).append("\n"); 
		query.append("				, L.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append("				, L.MVMT_STAY_DYS" ).append("\n"); 
		query.append("				, L.INV_STAY_DYS" ).append("\n"); 
		query.append("				, L.STAY_DIFF_DYS" ).append("\n"); 
		query.append("				, L.DCGO_CLSS_CD" ).append("\n"); 
		query.append("				, L.BB_CGO_FLG" ).append("\n"); 
		query.append("				, TO_CHAR(WRK_DT,'YYYY-MM-DD') AS WRK_DT" ).append("\n"); 
		query.append("				, TO_CHAR(CLM_DT,'YYYY-MM-DD') AS CLM_DT" ).append("\n"); 
		query.append("				, TO_CHAR(RAIL_BIL_DT,'YYYY-MM-DD') AS RAIL_BIL_DT" ).append("\n"); 
		query.append("				, L.BKG_NO" ).append("\n"); 
		query.append("				, L.BL_NO" ).append("\n"); 
		query.append("				, L.DSCR_RSN" ).append("\n"); 
		query.append("				, L.HNDL_RSLT_RMK" ).append("\n"); 
		query.append("				, L.CNTR_RMK" ).append("\n"); 
		query.append("				, L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD_NO" ).append("\n"); 
		query.append("				, L.DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("				, L.AWK_CGO_FLG" ).append("\n"); 
		query.append("				, L.RC_FLG" ).append("\n"); 
		query.append("				, (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("				, AP_INV_HDR A" ).append("\n"); 
		query.append("				, COM_APRO_CSR_DTL C" ).append("\n"); 
		query.append("				, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("		WHERE	1	= 1" ).append("\n"); 
		query.append("		AND		H.TML_SO_OFC_CTY_CD	= L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ		= L.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		H.TML_INV_TP_CD		= 'ON'" ).append("\n"); 
		query.append("--		--// 1. Invoice Date" ).append("\n"); 
		query.append("		--// CHM-201642099 TES Intensive Audit 검색 조건 code 추가 (2016-06-16)" ).append("\n"); 
		query.append("		AND		H.CSR_NO			= A.CSR_NO(+)" ).append("\n"); 
		query.append("		AND		H.CSR_NO			= C.CSR_NO(+)" ).append("\n"); 
		query.append("		AND		C.APRO_RQST_NO		= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("		#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("		AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("		AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("		AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("		AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("		OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("		AND		A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --		--// 2. YARD CODE" ).append("\n"); 
		query.append("		#if ( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("		AND		H.YD_CD		 = @[yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 3. S/P CODE" ).append("\n"); 
		query.append("		#if ( ${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND		H.VNDR_SEQ		 = @[vndr_seq] 	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 6. Cost Office" ).append("\n"); 
		query.append("		#if ( ${cost_ofc_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.COST_OFC_CD	= @[cost_ofc_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      --		--// 7. Invoice Office" ).append("\n"); 
		query.append("		#if ( ${inv_ofc_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.INV_OFC_CD	= @[inv_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("	  --		--// 7. Invoice No" ).append("\n"); 
		query.append("		#if ( ${inv_no} != '' )" ).append("\n"); 
		query.append("		AND		H.INV_NO	= @[inv_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      --		--// 8. Inv Status" ).append("\n"); 
		query.append("		#if ( ${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD = @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("     --		--// 4. Manual Input Only" ).append("\n"); 
		query.append("		#if ( ${manual_check} != '' ) " ).append("\n"); 
		query.append("		AND		L.DSCR_IND_CD <> 'CO' " ).append("\n"); 
		query.append("        AND 	L.DSCR_IND_CD IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		) TES" ).append("\n"); 
		query.append("		, MDM_ORGANIZATION O" ).append("\n"); 
		query.append("		, MDM_LOCATION L" ).append("\n"); 
		query.append("		, MDM_VENDOR V" ).append("\n"); 
		query.append("	WHERE	1	= 1" ).append("\n"); 
		query.append("	AND		TES.INV_OFC_CD	= O.OFC_CD(+)" ).append("\n"); 
		query.append("	AND		O.LOC_CD     	= L.LOC_CD(+)" ).append("\n"); 
		query.append("	AND		TES.VNDR_SEQ	= V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	ORDER BY DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD))" ).append("\n"); 
		query.append("			, INV_OFC_CD, COST_OFC_CD, YD_CD, VNDR_SEQ, INV_NO " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE    ROW_NUM >= (@[pagerows] * (@[page_no] - 1) + 1)" ).append("\n"); 
		query.append("AND    ROW_NUM <= (@[pagerows] * @[page_no])" ).append("\n"); 

	}
}