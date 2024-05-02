/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderIssuedYesList
	  * </pre>
	  */
	public SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_radio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_cost_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BIL_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration").append("\n"); 
		query.append("FileName : SpotBidWorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL").append("\n"); 
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
		query.append("#if(${fmdate} != '' && ${todate} != '' && ${dt_radio} != '')  " ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'so_create')" ).append("\n"); 
		query.append("		/*+ INDEX(A XAK7TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("CASE WHEN WO_RJCT_FLG = 'Y' THEN '1' ELSE '0' END REJECTED_CHECK ,  " ).append("\n"); 
		query.append("A.EQ_NO ," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("A.EQ_KND_CD ," ).append("\n"); 
		query.append("A.CGO_TP_CD ," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00748', A.CGO_TP_CD) AS CGO_TP_NM ," ).append("\n"); 
		query.append("A.TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00594', A.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM ," ).append("\n"); 
		query.append("A.TRSP_SO_CMB_SEQ ," ).append("\n"); 
		query.append("A.TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00283', A.TRSP_CRR_MOD_CD) AS TRSP_CRR_MOD_NM ," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 1, 5) FM_LOC_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 6, 2) FM_YARD_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 1, 5) TO_LOC_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 6, 2) TO_YARD_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC_VALUE ," ).append("\n"); 
		query.append("SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_YARD_VALUE ," ).append("\n"); 
		query.append("DECODE(A.CUST_CNT_CD||A.CUST_SEQ, 'XX0', '', A.CUST_CNT_CD||A.CUST_SEQ) CUST_CNT_CD_SEQ ," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ   ACT_CUST_CD ,  -- 추가 " ).append("\n"); 
		query.append("A.CUST_NOMI_TRKR_FLG ," ).append("\n"); 
		query.append("A.CUST_CNT_CD ," ).append("\n"); 
		query.append("A.CUST_SEQ ," ).append("\n"); 
		query.append("A.DOR_DE_ADDR ," ).append("\n"); 
		query.append("A.MLT_STOP_DE_FLG ," ).append("\n"); 
		query.append("A.CNTR_WGT ," ).append("\n"); 
		query.append("A.WGT_MEAS_UT_CD WGT_UT_CD," ).append("\n"); 
		query.append("A.CNTR_KGS_WGT,  -- 추가 " ).append("\n"); 
		query.append("A.CNTR_LBS_WGT,  -- 추가 " ).append("\n"); 
		query.append("A.SPCL_CGO_CNTR_TP_CD,  -- 추가 " ).append("\n"); 
		query.append("CASE WHEN D.DCGO_FLG ='Y' THEN 'DG' WHEN D.BB_CGO_FLG ='Y' THEN 'BB' WHEN D.AWK_CGO_FLG='Y' THEN 'AK' WHEN D.RC_FLG ='Y' THEN 'RF' WHEN D.RD_CGO_FLG ='Y' THEN 'RD' ELSE '' END BKGSPE ," ).append("\n"); 
		query.append("TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC( 'KM' , 'D' , A.TRSP_COST_DTL_MOD_CD , A.TRSP_BND_CD , A.FM_NOD_CD , A.VIA_NOD_CD , A.DOR_NOD_CD , A.TO_NOD_CD ) AS DISTANCE ," ).append("\n"); 
		query.append("TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC( 'ML' , 'D' , A.TRSP_COST_DTL_MOD_CD , A.TRSP_BND_CD , A.FM_NOD_CD , A.VIA_NOD_CD , A.DOR_NOD_CD , A.TO_NOD_CD ) AS DISTANCE_UOM ," ).append("\n"); 
		query.append("' ' MORE_CANDIDATES ," ).append("\n"); 
		query.append("A.TRSP_RQST_ORD_REV_AMT REVENUE ," ).append("\n"); 
		query.append("A.REV_CURR_CD ," ).append("\n"); 
		query.append("A.N3PTY_BIL_FLG ," ).append("\n"); 
		query.append("A.BKG_NO BKG_NO ," ).append("\n"); 
		query.append("A.BL_NO BL_NO ," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD ," ).append("\n"); 
		query.append("A.SLAN_CD LANE ," ).append("\n"); 
		query.append("FDR_VSL_CD||FDR_SKD_VOY_NO||FDR_SKD_DIR_CD FDR_VVD ," ).append("\n"); 
		query.append("NVL(A.DTN_USE_FLG, 'N') DTN_USE_FLG ," ).append("\n"); 
		query.append("NVL(A.WO_BL_NO_ISS_FLG, 'N') WO_BL_NO_ISS_FLG ," ).append("\n"); 
		query.append("TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') SO_CRE_DT ," ).append("\n"); 
		query.append("TO_CHAR(WRK.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') WO_ISSUE_DT ," ).append("\n"); 
		query.append("'' WO_RJCT_DT,  -- TO_CHAR(WRK.WO_RJCT_DT, 'YYYY-MM-DD HH24:MI:SS') WO_RJCT_DT	," ).append("\n"); 
		query.append("A.INTER_RMK ," ).append("\n"); 
		query.append("A.SPCL_INSTR_RMK ," ).append("\n"); 
		query.append("WRK.WO_RMK ," ).append("\n"); 
		query.append("--DECODE(STK.SO_SEQ, NULL, 'N', 'Y') AS MTY_RR_FLG ," ).append("\n"); 
		query.append("NVL((SELECT 'Y' FROM CIM_CNTR_STK STK WHERE A.TRSP_SO_OFC_CTY_CD = STK.SO_OFC_CTY_CD AND A.TRSP_SO_SEQ = STK.SO_SEQ GROUP BY SO_SEQ),'N') MTY_RR_FLG," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS TRSP_SO_OFC_CTY_CD_SEQ ," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ AS surcharge_key," ).append("\n"); 
		query.append("A.TRSP_SO_TP_CD ," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ ," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD ," ).append("\n"); 
		query.append("A.TRSP_WO_SEQ ," ).append("\n"); 
		query.append("A.CRE_OFC_CD ," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS VNDR_SEQ," ).append("\n"); 
		query.append("DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS PRESET_VNDR_SEQ ," ).append("\n"); 
		query.append("DECODE(VNDR.DELT_FLG, 'Y', '', VNDR.VNDR_LGL_ENG_NM) AS VNDR_NM ," ).append("\n"); 
		query.append("NVL(VNDR.WO_EDI_USE_FLG, 'N') WO_EDI_USE_FLG ," ).append("\n"); 
		query.append("A.TRSP_DFLT_VNDR_FLG AS DEFAULT_SP_FLG ," ).append("\n"); 
		query.append("NVL(A.TRSP_FRST_FLG , 'N') TRSP_FRST_FLG ," ).append("\n"); 
		query.append("A.TRSP_RJCT_RSN_CD ," ).append("\n"); 
		query.append("A.TRSP_RQST_BKG_FLG ," ).append("\n"); 
		query.append("A.TRSP_SO_CMB_TP_CD ," ).append("\n"); 
		query.append("A.TRSP_BND_CD ," ).append("\n"); 
		query.append("A.CMDT_CD ," ).append("\n"); 
		query.append("A.FM_NOD_CD ," ).append("\n"); 
		query.append("A.VIA_NOD_CD ," ).append("\n"); 
		query.append("A.DOR_NOD_CD ," ).append("\n"); 
		query.append("A.TO_NOD_CD ," ).append("\n"); 
		query.append("--CASE WHEN TRSP_SO_CMB_TP_CD = 'BD' THEN COUNT(A.TRSP_SO_SEQ) OVER (PARTITION BY TRSP_SO_CMB_TP_CD, TRSP_SO_CMB_SEQ) ELSE 1 END BUNDLING_NO ," ).append("\n"); 
		query.append("CASE WHEN A.MCNTR_BDL_GRP_SEQ IS NOT NULL THEN A.MTY_BDL_CNTR_QTY ELSE 1 END BUNDLING_NO ," ).append("\n"); 
		query.append("NVL(A.CURR_CD, @[BIL_CURR_CD]) AS CURR_CD," ).append("\n"); 
		query.append("A.WGT_MEAS_UT_CD ," ).append("\n"); 
		query.append("A.ETC_ADD_AMT ," ).append("\n"); 
		query.append("A.BZC_AMT ," ).append("\n"); 
		query.append("A.FUEL_SCG_AMT ," ).append("\n"); 
		query.append("A.SCG_VAT_AMT ," ).append("\n"); 
		query.append("A.NEGO_AMT ," ).append("\n"); 
		query.append("A.NEGO_AMT ORG_NEGO_AMT," ).append("\n"); 
		query.append("A.TOLL_FEE_AMT," ).append("\n"); 
		query.append("( NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.SCG_VAT_AMT, 0) + NVL(A.ETC_ADD_AMT, 0)  + NVL(A.TOLL_FEE_AMT, 0)) AS WO_TOT_AMT ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROUND((TO_NUMBER( NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.SCG_VAT_AMT, 0) + NVL(A.ETC_ADD_AMT, 0) + NVL(A.TOLL_FEE_AMT, 0) ) / RAT.USD_LOCL_XCH_RT), 2) WO_TOT_AMT_USD" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE RAT.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("AND RAT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND RAT.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM') ) AS WO_TOT_AMT_USD ," ).append("\n"); 
		query.append("'' WO_RJCT_INDCT ," ).append("\n"); 
		query.append("DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'Y', 'N') AS SP_TYPE ," ).append("\n"); 
		query.append("A.TRSP_AGMT_RT_TP_CD ," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954',A.TRSP_AGMT_RT_TP_CD) AS TRSP_AGMT_RT_TP_NM," ).append("\n"); 
		query.append("A.TRO_SEQ," ).append("\n"); 
		query.append("A.TRSP_AGMT_WY_TP_CD," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00762',A.TRSP_SO_CMB_TP_CD) AS TRSP_SO_CMB_TP_NM,															 " ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00279',A.TRSP_SO_TP_CD)	AS TRSP_SO_TP_NM,															 " ).append("\n"); 
		query.append("TO_CHAR(A.N1ST_NOD_PLN_DT, 'YYYY-MM-DD') N1ST_NOD_PLN_DT,						 " ).append("\n"); 
		query.append("TO_CHAR(A.N1ST_NOD_PLN_DT, 'HH24:MI:SS') N1ST_NOD_PLN_TM,						 " ).append("\n"); 
		query.append("TO_CHAR(A.LST_NOD_PLN_DT, 'YYYY-MM-DD') LST_NOD_PLN_DT,							 " ).append("\n"); 
		query.append("TO_CHAR(A.LST_NOD_PLN_DT, 'HH24:MI:SS') LST_NOD_PLN_TM,							 " ).append("\n"); 
		query.append("TO_CHAR(A.DOR_NOD_PLN_DT, 'YYYY-MM-DD') DOR_NOD_PLN_DT,							 " ).append("\n"); 
		query.append("TO_CHAR(A.DOR_NOD_PLN_DT, 'HH24:MI:SS') DOR_NOD_PLN_TM,							 " ).append("\n"); 
		query.append("A.COP_NO,																		 " ).append("\n"); 
		query.append("A.COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("A.COST_ACT_GRP_CD COST_ACT_GRP_CD," ).append("\n"); 
		query.append("DECODE (A.TRSP_COST_DTL_MOD_CD,'DR', DECODE (NVL (A.TRO_SEQ, ''),'', 'N','Y'),'N/A') TRO_CNFM," ).append("\n"); 
		query.append("A.TRO_SEQ," ).append("\n"); 
		query.append("											 " ).append("\n"); 
		query.append("-- ,	DECODE(NVL(BKG.SHPR_CNTR_QTY, 0), 0, BKG.CNTR_TPSZ_CD||' '||BKG.OP_CNTR_QTY, BKG.CNTR_TPSZ_CD||' '||BKG.OP_CNTR_QTY||'-SUB '||BKG.SHPR_CNTR_TPSZ_CD||' '||BKG.SHPR_CNTR_QTY)	AS	BKG_QTY																		 " ).append("\n"); 
		query.append("A.IB_VVD_CD,																		 " ).append("\n"); 
		query.append("A.OB_VVD_CD,																		 " ).append("\n"); 
		query.append("A.REF_ID,																		 " ).append("\n"); 
		query.append("NVL(USR1.USR_NM,A.CRE_USR_ID)	SO_CRE_NM," ).append("\n"); 
		query.append("NVL(USR2.USR_NM,WRK.UPD_USR_ID)	WO_CRE_NM,															 " ).append("\n"); 
		query.append("A.FCTRY_NM,					 " ).append("\n"); 
		query.append("A.DOR_PST_CD,																	 " ).append("\n"); 
		query.append("A.CNTC_PSON_PHN_NO,																 " ).append("\n"); 
		query.append("A.CNTC_PSON_FAX_NO,																 " ).append("\n"); 
		query.append("A.CNTC_PSON_NM,																	 " ).append("\n"); 
		query.append("A.TRO_CFM_OFC_CD,																 " ).append("\n"); 
		query.append("A.TRO_CFM_USR_ID,																 " ).append("\n"); 
		query.append("TO_CHAR(A.TRO_CFM_UPD_DT, 'YYYY-MM-DD') AS TRO_CFM_UPD_DT,						 " ).append("\n"); 
		query.append("TO_CHAR(A.TRO_CFM_UPD_DT, 'HH24:MI:SS') AS TRO_CFM_UPD_TM,						 " ).append("\n"); 
		query.append("(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'S' ) AS SHPR_CUST_NM," ).append("\n"); 
		query.append("(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'C' ) AS CNEE_CUST_NM," ).append("\n"); 
		query.append("(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ')" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'N' ) AS NTFY_CUST_NM	," ).append("\n"); 
		query.append("A.N3PTY_BIL_BZC_AMT	AS N3PTY_BZC_AMT,											 " ).append("\n"); 
		query.append("A.N3PTY_VNDR_SEQ AS N3PTY_BZC_VNDR_SEQ,											 " ).append("\n"); 
		query.append("A.N3PTY_OFC_CD AS N3PTY_BZC_OFC_CD,												 " ).append("\n"); 
		query.append("A.N3PTY_DESC AS N3PTY_BZC_DESC,													 " ).append("\n"); 
		query.append("A.N3PTY_CUST_SEQ AS N3PTY_BZC_CUST_SEQ,											 " ).append("\n"); 
		query.append("A.N3PTY_CUST_CNT_CD AS N3PTY_BZC_CUST_CNT_CD,									 " ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD AS N3PTY_BZC_TP_CD" ).append("\n"); 
		query.append("#if(${wo_radio} != '' && ${wo_radio} == 'Y') " ).append("\n"); 
		query.append(",A.TRSP_AGMT_OFC_CTY_CD    po_trsp_agmt_ofc_cty_cd," ).append("\n"); 
		query.append("A.TRSP_AGMT_SEQ           po_trsp_agmt_seq," ).append("\n"); 
		query.append("A.TRSP_AGMT_RT_TP_CD      po_trsp_agmt_rt_tp_cd," ).append("\n"); 
		query.append("--DECODE(A.TRSP_AGMT_WY_TP_CD,'ONE','ONEWAY','RND','ROUNDTRIP')  po_way_type," ).append("\n"); 
		query.append("A.TRSP_AGMT_WY_TP_CD  po_way_type," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954',A.TRSP_AGMT_RT_TP_CD)      po_trsp_agmt_rt_tp_nm," ).append("\n"); 
		query.append("DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'Y', 'N')      po_sp_type," ).append("\n"); 
		query.append("A.CUST_NOMI_TRKR_FLG      po_cust_nomi_trkr_flg," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD         po_cust_cnt_cd," ).append("\n"); 
		query.append("A.ACT_CUST_SEQ            po_cust_seq," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD||ACT_CUST_SEQ    po_cust_cnt_cd_seq," ).append("\n"); 
		query.append("SB.GLINE_CURR_CD /*A.CURR_CD*/                 po_local_curr_cd," ).append("\n"); 
		query.append("A.CURR_CD                 ORG_CURR_CD," ).append("\n"); 
		query.append("SB.GLINE_BZC_AMT /*A.BZC_AMT*/                 po_basic_rt," ).append("\n"); 
		query.append("SB.GLINE_FUEL_SCG_AMT /*A.FUEL_SCG_AMT*/            po_fuel_scg_rt," ).append("\n"); 
		query.append("SB.GLINE_SCG_VAT_AMT /*A.SCG_VAT_AMT*/			  po_vat_scg_rt," ).append("\n"); 
		query.append("''                      po_over_wgt_scg_rt," ).append("\n"); 
		query.append("                                                                   NVL(SB.GLINE_BZC_AMT,0)+NVL(SB.GLINE_FUEL_SCG_AMT,0)+NVL(SB.GLINE_SCG_VAT_AMT,0)+NVL(SB.GLINE_TOLL_FEE_AMT,0)     po_local_curr_tot_amt," ).append("\n"); 
		query.append("--A.BZC_AMT+A.FUEL_SCG_AMT+A.SCG_VAT_AMT+A.nego_amt+A.etc_add_amt     po_local_curr_tot_amt," ).append("\n"); 
		query.append("round(trs_common_pkg.GET_CONVERSION_USD_AMT_FNC( SB.GLINE_CURR_CD, NVL(SB.GLINE_BZC_AMT,0)+NVL(SB.GLINE_FUEL_SCG_AMT,0)+NVL(SB.GLINE_SCG_VAT_AMT,0)+NVL(SB.GLINE_TOLL_FEE_AMT,0), to_char(WRK.cre_dt, 'YYYYMM' ) ), 2)  po_usd_curr_tot_amt,  --- 변환" ).append("\n"); 
		query.append("--round(trs_common_pkg.GET_CONVERSION_USD_AMT_FNC( A.CURR_CD, A.BZC_AMT+A.FUEL_SCG_AMT+A.SCG_VAT_AMT+A.nego_amt+A.etc_add_amt+A.toll_fee_amt, to_char(WRK.cre_dt, 'YYYYMM' ) ), 2)  po_usd_curr_tot_amt,  --- 변환" ).append("\n"); 
		query.append("''                      po_rtn_cd," ).append("\n"); 
		query.append("''                      po_rtn_msg," ).append("\n"); 
		query.append("A.TRSP_AGMT_CFM_FLG     po_cfm_flg," ).append("\n"); 
		query.append("A.TRSP_AGMT_RT_SEQ      po_agmt_rt_seq," ).append("\n"); 
		query.append("TO_CHAR(A.TRSP_AGMT_UPD_DT, 'YYYYMMDDHH24MISS')  po_agmt_upd_dt," ).append("\n"); 
		query.append("A.AGMT_MOR_CNDDT_APLY_FLG   agmt_mor_cnddt_aply_flg," ).append("\n"); 
		query.append("TO_CHAR(A.APNT_DT,'YYYY/MM/DD') AS appo_time_dt," ).append("\n"); 
		query.append("TO_CHAR(A.APNT_DT,'HH24:MI:SS') AS appo_time_hms," ).append("\n"); 
		query.append("TO_CHAR(A.DE_DT,'YYYY/MM/DD') AS deli_time_dt,       " ).append("\n"); 
		query.append("TO_CHAR(A.DE_DT,'HH24:MI:SS') AS deli_time_hms  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",A.VNDR_SEQ SPOT_BID_WIN_VNDR_SEQ" ).append("\n"); 
		query.append(",DECODE(VNDR.DELT_FLG, 'Y', '', VNDR.VNDR_LGL_ENG_NM) AS SPOT_BID_WIN_VNDR_NM" ).append("\n"); 
		query.append(",A.CURR_CD SPOT_BID_WIN_CURR_CD" ).append("\n"); 
		query.append(",A.NEGO_AMT SPOT_BID_WIN_AMT" ).append("\n"); 
		query.append("--spot_bid_win_usd_amt" ).append("\n"); 
		query.append(",ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC( A.CURR_CD, NVL(A.NEGO_AMT,0), to_char(WRK.cre_dt, 'YYYYMM' ) ), 2)  SPOT_BID_WIN_USD_AMT  --- 변환" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", mcntr_bdl_grp_seq" ).append("\n"); 
		query.append(", mcntr_bdl_seq" ).append("\n"); 
		query.append(",( SELECT CONTI_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION X," ).append("\n"); 
		query.append("       MDM_LOCATION     Y" ).append("\n"); 
		query.append(" WHERE X.LOC_CD   = Y.LOC_CD" ).append("\n"); 
		query.append("   AND X.OFC_CD = A.CRE_OFC_CD ) CONTI_CD" ).append("\n"); 
		query.append(",A.TTL_DIST" ).append("\n"); 
		query.append(",A.LNK_DIST_DIV_CD" ).append("\n"); 
		query.append(",(SELECT SC_NO FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO) SC_NO" ).append("\n"); 
		query.append(",(SELECT RFA_NO FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO) RFA_NO" ).append("\n"); 
		query.append("      ,(SELECT MAX(X.PRC_CTRT_NO)" ).append("\n"); 
		query.append("          FROM TRS_CUST_NOMI_TRKR X" ).append("\n"); 
		query.append("              ,BKG_BOOKING Y" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("           AND X.PRC_CTRT_TP_CD = DECODE(Y.SC_NO,'','R','S')" ).append("\n"); 
		query.append("           AND X.PRC_CTRT_NO = NVL(Y.SC_NO,Y.RFA_NO)" ).append("\n"); 
		query.append("           AND X.IO_BND_CD = A.TRSP_BND_CD" ).append("\n"); 
		query.append("           AND X.ORG_NOD_CD = CASE WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(A.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                   WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.ORG_NOD_CD)= 7 THEN A.FM_NOD_CD" ).append("\n"); 
		query.append("                                   WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(A.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                   WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.ORG_NOD_CD)= 7 THEN A.DOR_NOD_CD" ).append("\n"); 
		query.append("                              END " ).append("\n"); 
		query.append("           AND X.DEST_NOD_CD = CASE WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(A.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.DEST_NOD_CD)= 7 THEN A.DOR_NOD_CD" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(A.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.DEST_NOD_CD)= 7 THEN A.TO_NOD_CD" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("           AND X.DISP_STS_CD = '03'                     " ).append("\n"); 
		query.append("        ) AS CTRT_NO" ).append("\n"); 
		query.append("      ,(SELECT COUNT(X.PRC_CTRT_NO)" ).append("\n"); 
		query.append("          FROM TRS_CUST_NOMI_TRKR X" ).append("\n"); 
		query.append("              ,BKG_BOOKING Y" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("           AND X.PRC_CTRT_TP_CD = DECODE(Y.SC_NO,'','R','S')" ).append("\n"); 
		query.append("           AND X.PRC_CTRT_NO = NVL(Y.SC_NO,Y.RFA_NO)" ).append("\n"); 
		query.append("           AND X.IO_BND_CD = A.TRSP_BND_CD" ).append("\n"); 
		query.append("           AND X.ORG_NOD_CD = CASE WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(A.FM_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                 WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.ORG_NOD_CD)= 7 THEN A.FM_NOD_CD" ).append("\n"); 
		query.append("                                 WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.ORG_NOD_CD)= 5 THEN SUBSTR(A.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                 WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.ORG_NOD_CD)= 7 THEN A.DOR_NOD_CD" ).append("\n"); 
		query.append("                              END " ).append("\n"); 
		query.append("           AND X.DEST_NOD_CD = CASE WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(A.DOR_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'I' AND LENGTH(X.DEST_NOD_CD)= 7 THEN A.DOR_NOD_CD" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.DEST_NOD_CD)= 5 THEN SUBSTR(A.TO_NOD_CD,1,5)" ).append("\n"); 
		query.append("                                  WHEN A.TRSP_BND_CD = 'O' AND LENGTH(X.DEST_NOD_CD)= 7 THEN A.TO_NOD_CD" ).append("\n"); 
		query.append("                              END " ).append("\n"); 
		query.append("           AND X.DISP_STS_CD = '03'                     " ).append("\n"); 
		query.append("        ) AS CTRT_CNT" ).append("\n"); 
		query.append("	,NVL((SELECT HZD_MTRL_FLG FROM TRS_SPCL_CGO_AVAL_SVC_PROV WHERE VNDR_SEQ = A.VNDR_SEQ AND SO_CRE_OFC_CD = A.CRE_OFC_CD AND ROWNUM =1 ),'N') HZD_MTRL_FLG" ).append("\n"); 
		query.append("	,NVL((SELECT OVWT_TRI_AXL_FLG FROM TRS_SPCL_CGO_AVAL_SVC_PROV WHERE VNDR_SEQ = A.VNDR_SEQ AND SO_CRE_OFC_CD = A.CRE_OFC_CD AND ROWNUM =1 ),'N') OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("    ,TRS_COM_SPOT_BID_PKG.GET_SPOT_BID_VNDR_INFO(A.SPOT_BID_NO) AS SPOT_BID_VNDR_INFO" ).append("\n"); 
		query.append("    ,(SELECT COUNT(1) FROM TRS_SPOT_BID_VNDR  WHERE 1=1  AND SPOT_BID_NO = A.SPOT_BID_NO AND SPOT_BID_VNDR_STS_CD = 'S' AND SPOT_BID_AMT > 0) AS SPOT_BID_VNDR_CNT" ).append("\n"); 
		query.append("    ,A.SPOT_BID_NO, A.SPOT_BID_DUE_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD A ,  " ).append("\n"); 
		query.append("BKG_CONTAINER D ,  " ).append("\n"); 
		query.append("MDM_VENDOR VNDR ,  " ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WRK," ).append("\n"); 
		query.append("COM_USER USR1," ).append("\n"); 
		query.append("COM_USER USR2," ).append("\n"); 
		query.append("TRS_SPOT_BID SB" ).append("\n"); 
		query.append("WHERE A.BKG_NO =D.BKG_NO(+)  " ).append("\n"); 
		query.append("AND A.EQ_NO =D.CNTR_NO(+)  " ).append("\n"); 
		query.append("AND A.VNDR_SEQ =VNDR.VNDR_SEQ (+)  " ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD =WRK.TRSP_WO_OFC_CTY_CD (+)  " ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ =WRK.TRSP_WO_SEQ (+)  " ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("AND A.INV_NO IS NULL" ).append("\n"); 
		query.append("AND	NVL(A.UPD_USR_ID,A.CRE_USR_ID)	=USR1.USR_ID (+)" ).append("\n"); 
		query.append("AND	WRK.CRE_USR_ID                	=USR2.USR_ID (+)" ).append("\n"); 
		query.append("AND A.SPOT_BID_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = SB.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ        = SB.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD = SB.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ        = SB.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("AND A.SPOT_BID_NO        = SB.SPOT_BID_NO(+)" ).append("\n"); 
		query.append("---------------------W/O Issued Yes --------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("		SELECT D.TRSP_SO_OFC_CTY_CD,D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("		FROM TRS_TRSP_SVC_ORD D," ).append("\n"); 
		query.append("			(					" ).append("\n"); 
		query.append("            SELECT /*+ INDEX(IN_SVC XAK7TRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("            IN_SVC.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("            , 	IN_SVC.TRSP_WO_SEQ	" ).append("\n"); 
		query.append("            FROM 					" ).append("\n"); 
		query.append("			TRS_TRSP_SVC_ORD IN_SVC	" ).append("\n"); 
		query.append("			,	TRS_TRSP_WRK_ORD IN_WRK" ).append("\n"); 
		query.append("			WHERE 					" ).append("\n"); 
		query.append("			     IN_SVC.DELT_FLG='N'" ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_WO_OFC_CTY_CD 	= IN_WRK.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_WO_SEQ			= IN_WRK.TRSP_WO_SEQ" ).append("\n"); 
		query.append("-------------------------------------------------------" ).append("\n"); 
		query.append("#if(${form_usr_ofc_cd} != '')" ).append("\n"); 
		query.append("AND	IN_SVC.TRSP_SO_OFC_CTY_CD	= SUBSTR(@[form_usr_ofc_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($so_no.size() > 0)  " ).append("\n"); 
		query.append("AND (IN_SVC.TRSP_SO_OFC_CTY_CD,IN_SVC.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${so_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" 			(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${wo_radio} != '' && ${wo_radio} == 'Y') " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_SO_STS_CD = 'I'  " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("	AND IN_SVC.INV_NO IS NULL											" ).append("\n"); 
		query.append("	AND	IN_WRK.TRSP_WO_OFC_CTY_CD	= SUBSTR(@[form_usr_ofc_cd],1,3)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_SO_STS_CD IN ('R','C')" ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_WO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("	AND IN_SVC.INV_NO IS NULL		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fmdate} != '' && ${todate} != '' && ${dt_radio} != '')  " ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'plan_dpt')" ).append("\n"); 
		query.append("		AND IN_SVC.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'dor_arr')" ).append("\n"); 
		query.append("		 AND IN_SVC.DOR_NOD_PLN_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'so_create')" ).append("\n"); 
		query.append("		AND IN_SVC.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'wo_issue')" ).append("\n"); 
		query.append("		AND IN_WRK.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if( ${dt_radio} == 'wo_reject')" ).append("\n"); 
		query.append("		AND IN_SVC.UPD_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		AND IN_SVC.WO_RJCT_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( (${fmdate} != '' && ${todate} != '' && ${dt_radio} != '' && ${dt_radio} == 'spot_bid_due') || $spot_bid_no.size() > 0)" ).append("\n"); 
		query.append("	AND (IN_SVC.TRSP_SO_OFC_CTY_CD, IN_SVC.TRSP_SO_SEQ) IN " ).append("\n"); 
		query.append("    ( SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ " ).append("\n"); 
		query.append("        FROM TRS_SPOT_BID SB " ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${fmdate} != '' && ${todate} != '' && ${dt_radio} != '' && ${dt_radio} == 'spot_bid_due')" ).append("\n"); 
		query.append("	     AND SB.SPOT_BID_DUE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if($spot_bid_no.size() > 0)  " ).append("\n"); 
		query.append("         AND SB.SPOT_BID_NO IN( " ).append("\n"); 
		query.append("    #foreach($code IN ${spot_bid_no})  " ).append("\n"); 
		query.append("      #if($velocityCount == 1)  " ).append("\n"); 
		query.append("		'$code' " ).append("\n"); 
		query.append("      #else  " ).append("\n"); 
		query.append("		,'$code' " ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${combo_svc_provider} != '' && ${combo_svc_provider} != 'null')  " ).append("\n"); 
		query.append("	AND IN_SVC.VNDR_SEQ = @[combo_svc_provider]		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($wo_no.size() > 0) " ).append("\n"); 
		query.append("AND (IN_SVC.TRSP_WO_OFC_CTY_CD,IN_SVC.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach($code IN ${wo_no})  " ).append("\n"); 
		query.append("	#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" 		(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 10))" ).append("\n"); 
		query.append("	#else  " ).append("\n"); 
		query.append("	   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 10))  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trs_cost_md_cd} != 'ALL' && ${trs_cost_md_cd} != '')  " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_COST_DTL_MOD_CD = @[trs_cost_md_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trs_md_cd} != 'ALL' && ${trs_md_cd} != '')  " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_CRR_MOD_CD = @[trs_md_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trs_bnd_cd} != 'ALL' && ${trs_bnd_cd} != '')  " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_BND_CD = @[trs_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trs_so_tp_cd} != 'ALL' && ${trs_so_tp_cd} != '')  " ).append("\n"); 
		query.append("	AND IN_SVC.TRSP_SO_TP_CD = @[trs_so_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fm_nod} != '' && ${fm_nod} != 'null')  " ).append("\n"); 
		query.append("	#if ($fm_nod.length() == 5)  " ).append("\n"); 
		query.append("		AND SUBSTR(IN_SVC.FM_NOD_CD,0,5) = @[fm_nod]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND IN_SVC.FM_NOD_CD = @[fm_nod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_nod} != '' && ${to_nod} != 'null')  " ).append("\n"); 
		query.append("	#if ($to_nod.length() == 5)  " ).append("\n"); 
		query.append("		AND SUBSTR(IN_SVC.TO_NOD_CD,0,5) = @[to_nod]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND IN_SVC.TO_NOD_CD = @[to_nod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${via_nod} != '' && ${via_nod} != 'null')  " ).append("\n"); 
		query.append("	#if ($via_nod.length() == 5)  " ).append("\n"); 
		query.append("		AND SUBSTR(IN_SVC.VIA_NOD_CD,0,5) = @[via_nod]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND IN_SVC.VIA_NOD_CD = @[via_nod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${dor_nod} != '' && ${dor_nod} != 'null')  " ).append("\n"); 
		query.append("	#if ($dor_nod.length() == 5)  " ).append("\n"); 
		query.append("		AND SUBSTR(IN_SVC.DOR_NOD_CD,0,5) = @[dor_nod]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND IN_SVC.DOR_NOD_CD = @[dor_nod]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($tvvd_no.size() > 0)" ).append("\n"); 
		query.append("AND (IN_SVC.VSL_CD,IN_SVC.SKD_VOY_NO,IN_SVC.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("#foreach($code IN ${tvvd_no})  " ).append("\n"); 
		query.append("#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" (SUBSTR('$code', 1, 4),SUBSTR('$code', 5, 4),SUBSTR('$code',9))  " ).append("\n"); 
		query.append("#else  " ).append("\n"); 
		query.append(" , (SUBSTR('$code', 1, 4),SUBSTR('$code', 5, 4),SUBSTR('$code',9))  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_vvd_radio} == 'I' && $fvvd_no.size() > 0 )" ).append("\n"); 
		query.append("	#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			AND IN_SVC.IB_VVD_CD IN ('$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		,'$code'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end 	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end 	" ).append("\n"); 
		query.append("#if(${f_vvd_radio} == 'O' && $fvvd_no.size() > 0)" ).append("\n"); 
		query.append("		AND IN_SVC.OB_VVD_CD IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_vvd_radio} == 'A' && $fvvd_no.size() > 0)" ).append("\n"); 
		query.append("			AND (IN_SVC.IB_VVD_CD IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			 )OR IN_SVC.OB_VVD_CD IN ('$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			,'$code'" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkg_no.size() > 0)  " ).append("\n"); 
		query.append("AND IN_SVC.BKG_NO IN( " ).append("\n"); 
		query.append("#foreach($code IN ${bkg_no})  " ).append("\n"); 
		query.append("	#if($velocityCount == 1)  " ).append("\n"); 
		query.append("		'$code' " ).append("\n"); 
		query.append("	#else  " ).append("\n"); 
		query.append("		,'$code' " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bl_no.size() > 0)  " ).append("\n"); 
		query.append("  AND IN_SVC.BL_NO IN(" ).append("\n"); 
		query.append("#foreach($code IN ${bl_no})  " ).append("\n"); 
		query.append("	#if($velocityCount == 1)  " ).append("\n"); 
		query.append("		'$code' " ).append("\n"); 
		query.append("	#else  " ).append("\n"); 
		query.append("		,'$code' " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${eq_radio} != '' && ${eq_radio} != 'null')  " ).append("\n"); 
		query.append("	AND IN_SVC.EQ_KND_CD = @[eq_radio]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($eq_no.size() > 0)  " ).append("\n"); 
		query.append("AND IN_SVC.EQ_NO IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${eq_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			 ,'$code'" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($mty_rfrn_no.size() > 0)  " ).append("\n"); 
		query.append("AND IN_SVC.REF_ID IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${mty_rfrn_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			'$code'" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			 ,'$code'" ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("---------------------W/O Issued Yes --------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("IN_SVC.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	IN_SVC.TRSP_WO_SEQ" ).append("\n"); 
		query.append(") F" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("D.TRSP_WO_OFC_CTY_CD 	= F.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TRSP_WO_SEQ 			= F.TRSP_WO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-----------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 

	}
}