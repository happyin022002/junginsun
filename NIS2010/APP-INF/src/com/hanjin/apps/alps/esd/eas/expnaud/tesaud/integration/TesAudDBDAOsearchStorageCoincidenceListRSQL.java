/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAudDBDAOsearchStorageCoincidenceListRSQL.java
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

public class TesAudDBDAOsearchStorageCoincidenceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Storage Calculation - Coincidence 조회
	  * </pre>
	  */
	public TesAudDBDAOsearchStorageCoincidenceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TesAudDBDAOsearchStorageCoincidenceListRSQL").append("\n"); 
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
		query.append("SELECT RHQ" ).append("\n"); 
		query.append("     , COST_OFC_CD" ).append("\n"); 
		query.append("     , INV_OFC_CD" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("	 , CRE_USR_NM" ).append("\n"); 
		query.append("     , BB_CGO_FLG" ).append("\n"); 
		query.append("     , WRK_DT" ).append("\n"); 
		query.append("     , CLM_DT" ).append("\n"); 
		query.append("     , RAIL_BIL_DT" ).append("\n"); 
		query.append("     , DSCR_RSN" ).append("\n"); 
		query.append("     , HNDL_RSLT_RMK" ).append("\n"); 
		query.append("     , CNTR_RMK" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , TML_SO_SEQ" ).append("\n"); 
		query.append("     , TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("     , VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("     , MODI_FLG" ).append("\n"); 
		query.append("     , DSCR_IND_CD" ).append("\n"); 
		query.append("     , TML_RVIS_IND_FLG" ).append("\n"); 
		query.append("     , IO_BND_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , LANE_CD" ).append("\n"); 
		query.append("     , ATB_DT" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CNTR_STY_CD" ).append("\n"); 
		query.append("     , LOCL_TS_IND_CD" ).append("\n"); 
		query.append("     , SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("     , RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("     , PRE_YD_CD" ).append("\n"); 
		query.append("     , INV_GATE_IN_DT" ).append("\n"); 
		query.append("     , GATE_IN_TD_DYS" ).append("\n"); 
		query.append("     , INV_GATE_OUT_DT" ).append("\n"); 
		query.append("     , GATE_OUT_TD_DYS" ).append("\n"); 
		query.append("     , INV_STAY_DYS" ).append("\n"); 
		query.append("     , MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("     , MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("     , MVMT_STAY_DYS" ).append("\n"); 
		query.append("     , STAY_DIFF_DYS" ).append("\n"); 
		query.append("     , AWK_CGO_FLG" ).append("\n"); 
		query.append("     , RC_FLG" ).append("\n"); 
		query.append("     , DCGO_CLSS_CD" ).append("\n"); 
		query.append("     , ROW_NUM" ).append("\n"); 
		query.append("     , ROW_COUNT" ).append("\n"); 
		query.append("     , '' INV_DATE_TYPE" ).append("\n"); 
		query.append("	 , '' TML_INV_TP_CD" ).append("\n"); 
		query.append("	 , '' FM_PRD_DT" ).append("\n"); 
		query.append("     , '' TO_PRD_DT" ).append("\n"); 
		query.append("     , '' TML_INV_STS_CD" ).append("\n"); 
		query.append("     , '' PAGE_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT	  DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD)) AS RHQ" ).append("\n"); 
		query.append("				, TES.COST_OFC_CD			-- Cost Office" ).append("\n"); 
		query.append("				, TES.INV_OFC_CD			-- Inv Office" ).append("\n"); 
		query.append("				, TES.YD_CD					-- Yard" ).append("\n"); 
		query.append("				, TES.VNDR_SEQ				-- S/P" ).append("\n"); 
		query.append("				, V.VNDR_LGL_ENG_NM			-- S/P NAME" ).append("\n"); 
		query.append("				, TES.INV_NO				-- INV No." ).append("\n"); 
		query.append("				, TES.CRE_USR_NM" ).append("\n"); 
		query.append("				, TES.BB_CGO_FLG			-- B/B" ).append("\n"); 
		query.append("				, TES.WRK_DT" ).append("\n"); 
		query.append("				, TES.CLM_DT" ).append("\n"); 
		query.append("				, TES.RAIL_BIL_DT" ).append("\n"); 
		query.append("				, TES.DSCR_RSN" ).append("\n"); 
		query.append("				, TES.HNDL_RSLT_RMK" ).append("\n"); 
		query.append("				, TES.CNTR_RMK				-- Remarks" ).append("\n"); 
		query.append("				, TES.CRE_USR_ID" ).append("\n"); 
		query.append("				, TES.CRE_DT" ).append("\n"); 
		query.append("				, TES.UPD_USR_ID" ).append("\n"); 
		query.append("				, TES.UPD_DT" ).append("\n"); 
		query.append("				, TES.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, TES.TML_SO_SEQ" ).append("\n"); 
		query.append("				, TES.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				, TES.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("				, TES.MODI_FLG" ).append("\n"); 
		query.append("				, TES.DSCR_IND_CD			-- Verify Result" ).append("\n"); 
		query.append("				, TES.TML_RVIS_IND_FLG" ).append("\n"); 
		query.append("				, TES.IO_BND_CD				-- I/O" ).append("\n"); 
		query.append("				, TES.IOC_CD" ).append("\n"); 
		query.append("				, TES.LANE_CD" ).append("\n"); 
		query.append("				, TES.ATB_DT" ).append("\n"); 
		query.append("				, TES.CNTR_NO				-- CNTR No." ).append("\n"); 
		query.append("				, TES.CNTR_TPSZ_CD			-- Type/Size" ).append("\n"); 
		query.append("				, TES.CNTR_STY_CD			-- FM" ).append("\n"); 
		query.append("				, TES.LOCL_TS_IND_CD		-- T/S" ).append("\n"); 
		query.append("				, TES.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("				, TES.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("				, TES.PRE_YD_CD" ).append("\n"); 
		query.append("				, TES.INV_GATE_IN_DT		-- Gate In" ).append("\n"); 
		query.append("				, TES.GATE_IN_TD_DYS" ).append("\n"); 
		query.append("				, TES.INV_GATE_OUT_DT		-- Gate Out" ).append("\n"); 
		query.append("				, TES.GATE_OUT_TD_DYS		" ).append("\n"); 
		query.append("				, TES.INV_STAY_DYS			-- Stay Days" ).append("\n"); 
		query.append("				, TES.MVMT_GATE_IN_DT		-- MVMT Gate In" ).append("\n"); 
		query.append("				, TES.MVMT_GATE_OUT_DT		-- MVMT Gate Out" ).append("\n"); 
		query.append("				, TES.MVMT_STAY_DYS			-- Mvmt Stay Days" ).append("\n"); 
		query.append("				, TES.STAY_DIFF_DYS" ).append("\n"); 
		query.append("				, TES.AWK_CGO_FLG" ).append("\n"); 
		query.append("				, TES.RC_FLG" ).append("\n"); 
		query.append("				, TES.DCGO_CLSS_CD			-- DG" ).append("\n"); 
		query.append("		        , ROW_NUMBER() OVER (ORDER BY TES.INV_NO ASC) AS ROW_NUM" ).append("\n"); 
		query.append("		        , COUNT(TES.INV_NO) OVER() ROW_COUNT" ).append("\n"); 
		query.append("		FROM	(SELECT" ).append("\n"); 
		query.append("						  H.INV_OFC_CD" ).append("\n"); 
		query.append("						, H.COST_OFC_CD" ).append("\n"); 
		query.append("						, H.YD_CD" ).append("\n"); 
		query.append("						, H.VNDR_SEQ" ).append("\n"); 
		query.append("						, H.INV_NO" ).append("\n"); 
		query.append("						, L.BB_CGO_FLG" ).append("\n"); 
		query.append("						, L.WRK_DT" ).append("\n"); 
		query.append("						, L.CLM_DT" ).append("\n"); 
		query.append("						, L.RAIL_BIL_DT" ).append("\n"); 
		query.append("						, L.DSCR_RSN" ).append("\n"); 
		query.append("						, L.HNDL_RSLT_RMK" ).append("\n"); 
		query.append("						, L.CNTR_RMK" ).append("\n"); 
		query.append("						, L.CRE_USR_ID" ).append("\n"); 
		query.append("						, TO_CHAR(H.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("						, L.UPD_USR_ID" ).append("\n"); 
		query.append("						, TO_CHAR(H.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("						, L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						, L.TML_SO_SEQ" ).append("\n"); 
		query.append("						, L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						, L.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("						, L.MODI_FLG" ).append("\n"); 
		query.append("						, L.DSCR_IND_CD" ).append("\n"); 
		query.append("						, L.TML_RVIS_IND_FLG" ).append("\n"); 
		query.append("						, L.IO_BND_CD" ).append("\n"); 
		query.append("						, L.IOC_CD" ).append("\n"); 
		query.append("						, L.LANE_CD" ).append("\n"); 
		query.append("						, L.ATB_DT" ).append("\n"); 
		query.append("						, L.CNTR_NO" ).append("\n"); 
		query.append("						, L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("						, L.CNTR_STY_CD" ).append("\n"); 
		query.append("						, L.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("						, L.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("						, L.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("						, L.PRE_YD_CD" ).append("\n"); 
		query.append("						, TO_CHAR(MVMT_GATE_IN_DT, 'YYYY-MM-DD HH24:MI') AS MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("						, TO_CHAR(INV_GATE_IN_DT, 'YYYY-MM-DD HH24:MI') AS INV_GATE_IN_DT" ).append("\n"); 
		query.append("						, L.GATE_IN_TD_DYS" ).append("\n"); 
		query.append("						, TO_CHAR(MVMT_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI') AS MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("						, TO_CHAR(INV_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI') AS INV_GATE_OUT_DT" ).append("\n"); 
		query.append("						, L.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append("                        , TO_DATE(TO_CHAR(L.MVMT_GATE_OUT_DT, 'YYYYMMDD') , 'YYYYMMDD') - TO_DATE(TO_CHAR(L.MVMT_GATE_IN_DT, 'YYYYMMDD'), 'YYYYMMDD')+1 AS MVMT_STAY_DYS" ).append("\n"); 
		query.append("						-- Storage Type " ).append("\n"); 
		query.append("						#if (${tml_inv_tp_cd} == 'OF')" ).append("\n"); 
		query.append("						, L.INV_STAY_DYS " ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						, L.INV_STAY_DYS + 1 AS INV_STAY_DYS" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						, L.STAY_DIFF_DYS" ).append("\n"); 
		query.append("						, L.AWK_CGO_FLG" ).append("\n"); 
		query.append("						, L.RC_FLG" ).append("\n"); 
		query.append("						, L.DCGO_CLSS_CD" ).append("\n"); 
		query.append("						, (SELECT USR_NM FROM COM_USER WHERE USR_ID = H.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("						, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("						, AP_INV_HDR A" ).append("\n"); 
		query.append("						, COM_APRO_CSR_DTL C" ).append("\n"); 
		query.append("						, COM_APRO_RQST_HDR R" ).append("\n"); 
		query.append("				WHERE	1	= 1" ).append("\n"); 
		query.append("				AND		H.TML_SO_OFC_CTY_CD	= L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND		H.TML_SO_SEQ		= L.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND		L.VRFY_RSLT_IND_CD	= 'CO'" ).append("\n"); 
		query.append("				AND		H.TML_INV_TP_CD		= @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("				--// CHM-201642099 TES Intensive Audit 검색 조건 code 추가 (2016-06-16)" ).append("\n"); 
		query.append("				AND		H.CSR_NO			= A.CSR_NO(+)" ).append("\n"); 
		query.append("				AND		H.CSR_NO			= C.CSR_NO(+)" ).append("\n"); 
		query.append("				AND		C.APRO_RQST_NO		= R.APRO_RQST_NO(+)" ).append("\n"); 
		query.append("				#if (${inv_date_type} == 'I') 	-- ISSUED DATE" ).append("\n"); 
		query.append("				AND		H.ISS_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'R')	-- RECEIVED DATE" ).append("\n"); 
		query.append("				AND		H.RCV_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'P')	-- INVOICE UPDATE DATE" ).append("\n"); 
		query.append("				AND		H.LOCL_UPD_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'A')	-- ARRROVAL REQUESTED DATE" ).append("\n"); 
		query.append("				AND		( (R.RQST_ST_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("				OR		( A.CSR_APRO_STEP_ASGN_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 ) )" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'C')	-- CONFIRMED DATE" ).append("\n"); 
		query.append("				AND		H.INV_CFM_DT BETWEEN TO_DATE(@[fm_prd_dt],'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'U')	-- I/F STATUS UPDATED" ).append("\n"); 
		query.append("				AND		( A.IF_DT BETWEEN TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_prd_dt], 'YYYY-MM-DD') + 0.99999 )" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		        #if ( ${yd_cd} != '' )" ).append("\n"); 
		query.append("				AND		H.YD_CD		 		= @[yd_cd]" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        #if (${io_bnd_cd} != 'A' ) " ).append("\n"); 
		query.append("		        AND		L.IO_BND_CD		 	= @[io_bnd_cd] 	" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("				AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("				#if ( ${cost_ofc_cd} != '' )" ).append("\n"); 
		query.append("				AND		H.COST_OFC_CD		= @[cost_ofc_cd]" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("				#if ( ${inv_ofc_cd} != '' )" ).append("\n"); 
		query.append("				AND		H.INV_OFC_CD		= @[inv_ofc_cd]" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("				#if ( ${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("				AND		H.TML_INV_STS_CD	= @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("		        #if ( ${vrfy_rslt_ind_cd} != '' ) " ).append("\n"); 
		query.append("                AND 	L.DSCR_IND_CD <> 'CO' " ).append("\n"); 
		query.append("                AND 	L.DSCR_IND_CD IS NOT NULL" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				) TES" ).append("\n"); 
		query.append("				, MDM_ORGANIZATION O" ).append("\n"); 
		query.append("				, MDM_LOCATION L" ).append("\n"); 
		query.append("				, MDM_VENDOR V" ).append("\n"); 
		query.append("		WHERE	1	= 1" ).append("\n"); 
		query.append("		AND		TES.INV_OFC_CD	= O.OFC_CD(+)" ).append("\n"); 
		query.append("		AND		O.LOC_CD     	= L.LOC_CD(+)" ).append("\n"); 
		query.append("		AND		TES.VNDR_SEQ	= V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		ORDER BY DECODE(O.OFC_CD, 'DURBA', O.AR_HD_QTR_OFC_CD, 'DARBA', O.AR_HD_QTR_OFC_CD, 'MBABA', O.AR_HD_QTR_OFC_CD, 'AISBA', O.AR_HD_QTR_OFC_CD, DECODE(L.CONTI_CD, 'F', 'HAMUR', 'E', 'HAMUR', 'M', 'NYCNA', 'A', O.AR_HD_QTR_OFC_CD))" ).append("\n"); 
		query.append("		, INV_OFC_CD, COST_OFC_CD, YD_CD, VNDR_SEQ, INV_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  WHERE    ROW_NUM >= (@[pagerows] * (@[page_no] - 1) + 1)" ).append("\n"); 
		query.append("  AND    ROW_NUM <= (@[pagerows] * @[page_no])" ).append("\n"); 

	}
}