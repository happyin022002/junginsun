/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.03 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderIssueBySoNo
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("BIL_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchWorkOrderIssueBySoNoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN WO_RJCT_FLG = 'Y' THEN '1' ELSE '0' END REJECTED_CHECK ,  " ).append("\n"); 
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
		query.append("NVL(A.CUST_CNT_CD||A.CUST_SEQ,TRS_GET_CUST_INFO_FNC(A.BKG_NO))  CUST_CNT_CD_SEQ ," ).append("\n"); 
		query.append("A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ   ACT_CUST_CD ,  -- 추가 " ).append("\n"); 
		query.append("A.CUST_NOMI_TRKR_FLG ," ).append("\n"); 
		query.append("	CASE WHEN A.CUST_CNT_CD IS NOT NULL THEN A.CUST_CNT_CD " ).append("\n"); 
		query.append("		 ELSE SUBSTR(TRS_GET_CUST_INFO_FNC(A.BKG_NO),1,2)" ).append("\n"); 
		query.append("     END AS CUST_CNT_CD," ).append("\n"); 
		query.append("	CASE WHEN A.CUST_SEQ IS NOT NULL THEN A.CUST_SEQ" ).append("\n"); 
		query.append("         ELSE TO_NUMBER(SUBSTR(TRS_GET_CUST_INFO_FNC(A.BKG_NO),3))" ).append("\n"); 
		query.append("     END AS CUST_SEQ," ).append("\n"); 
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
		query.append("A.NEGO_RMK ," ).append("\n"); 
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
		query.append("TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS VNDR_SEQ ," ).append("\n"); 
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
		query.append("CASE WHEN TRSP_SO_CMB_TP_CD = 'BD' THEN COUNT(A.TRSP_SO_SEQ) OVER (PARTITION BY TRSP_SO_CMB_TP_CD, TRSP_SO_CMB_SEQ) ELSE 1 END BUNDLING_NO ," ).append("\n"); 
		query.append("NVL(A.CURR_CD, @[BIL_CURR_CD]) AS CURR_CD," ).append("\n"); 
		query.append("A.WGT_MEAS_UT_CD ," ).append("\n"); 
		query.append("A.ETC_ADD_AMT ," ).append("\n"); 
		query.append("A.BZC_AMT ," ).append("\n"); 
		query.append("A.FUEL_SCG_AMT ," ).append("\n"); 
		query.append("A.SCG_VAT_AMT ," ).append("\n"); 
		query.append("A.NEGO_AMT ," ).append("\n"); 
		query.append("( NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.SCG_VAT_AMT, 0) + NVL(A.ETC_ADD_AMT, 0) ) AS WO_TOT_AMT ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROUND((TO_NUMBER( NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.SCG_VAT_AMT, 0) + NVL(A.ETC_ADD_AMT, 0) ) / RAT.USD_LOCL_XCH_RT), 2) WO_TOT_AMT_USD" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE RAT.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("AND RAT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND RAT.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM') ) AS WO_TOT_AMT_USD ," ).append("\n"); 
		query.append("'' WO_RJCT_INDCT ," ).append("\n"); 
		query.append("DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'CNT', 'HJS') AS SP_TYPE ," ).append("\n"); 
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
		query.append("A.TRO_SEQ,													 " ).append("\n"); 
		query.append("-- ,	DECODE(NVL(BKG.SHPR_CNTR_QTY, 0), 0, BKG.CNTR_TPSZ_CD||' '||BKG.OP_CNTR_QTY, BKG.CNTR_TPSZ_CD||' '||BKG.OP_CNTR_QTY||'-SUB '||BKG.SHPR_CNTR_TPSZ_CD||' '||BKG.SHPR_CNTR_QTY)	AS	BKG_QTY																		 " ).append("\n"); 
		query.append("A.IB_VVD_CD,																		 " ).append("\n"); 
		query.append("A.OB_VVD_CD,																		 " ).append("\n"); 
		query.append("A.REF_ID,																		 " ).append("\n"); 
		query.append("NVL(USR1.USR_NM,A.CRE_USR_ID)	SO_CRE_NM," ).append("\n"); 
		query.append("NVL(USR2.USR_NM,WRK.UPD_USR_ID)	WO_CRE_NM,														 " ).append("\n"); 
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
		query.append("AND CUST.BKG_CUST_TP_CD = 'N' ) AS NTFY_CUST_NM	,																 " ).append("\n"); 
		query.append("A.N3PTY_BIL_BZC_AMT	AS N3PTY_BZC_AMT,											 " ).append("\n"); 
		query.append("A.N3PTY_VNDR_SEQ AS N3PTY_BZC_VNDR_SEQ,											 " ).append("\n"); 
		query.append("A.N3PTY_OFC_CD AS N3PTY_BZC_OFC_CD,												 " ).append("\n"); 
		query.append("A.N3PTY_DESC AS N3PTY_BZC_DESC,													 " ).append("\n"); 
		query.append("A.N3PTY_CUST_SEQ AS N3PTY_BZC_CUST_SEQ,											 " ).append("\n"); 
		query.append("A.N3PTY_CUST_CNT_CD AS N3PTY_BZC_CUST_CNT_CD,									 " ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD AS N3PTY_BZC_TP_CD," ).append("\n"); 
		query.append("NVL(( SELECT 'Y' FROM TRS_TRSP_SVC_ORD BUNDL" ).append("\n"); 
		query.append("WHERE SUBSTR(BUNDL.EQ_TPSZ_CD,1,1) IN ('A', 'F', 'P')" ).append("\n"); 
		query.append("AND BUNDL.TRSP_SO_TP_CD = 'M'" ).append("\n"); 
		query.append("AND BUNDL.TRSP_COST_DTL_MOD_CD = 'ER'" ).append("\n"); 
		query.append("AND BUNDL.TRSP_SO_CMB_TP_CD IS NULL" ).append("\n"); 
		query.append("AND BUNDL.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND BUNDL.TRSP_SO_SEQ = A.TRSP_SO_SEQ ),'N') AS BUNDLING_FLG" ).append("\n"); 
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
		query.append("     ,NVL(D.VGM_WGT,0) VGM_WGT" ).append("\n"); 
		query.append("     ,D.VGM_WGT_UT_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A ,  " ).append("\n"); 
		query.append("BKG_BOOKING B ,  " ).append("\n"); 
		query.append("BKG_CONTAINER D ,  " ).append("\n"); 
		query.append("TRS_AGMT_DIST DIST ,  " ).append("\n"); 
		query.append("MDM_VENDOR VNDR ,  " ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WRK," ).append("\n"); 
		query.append("-- CIM_CNTR_STK STK," ).append("\n"); 
		query.append("COM_USER USR1," ).append("\n"); 
		query.append("COM_USER USR2" ).append("\n"); 
		query.append("WHERE A.BKG_NO =B.BKG_NO(+)  " ).append("\n"); 
		query.append("AND A.BKG_NO =D.BKG_NO(+)  " ).append("\n"); 
		query.append("AND A.EQ_NO = D.CNTR_NO(+)  " ).append("\n"); 
		query.append("AND A.FM_NOD_CD = DIST.FM_NOD_CD(+)  " ).append("\n"); 
		query.append("AND A.TO_NOD_CD = DIST.TO_NOD_CD(+)  " ).append("\n"); 
		query.append("AND A.VNDR_SEQ = VNDR.VNDR_SEQ (+)  " ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD =WRK.TRSP_WO_OFC_CTY_CD (+)  " ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ =WRK.TRSP_WO_SEQ (+)  " ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("AND NVL(A.SPOT_BID_FLG,'N') = 'N' " ).append("\n"); 
		query.append("-- AND NVL(VNDR.DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("-- AND A.TRSP_SO_OFC_CTY_CD = STK.SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("-- AND A.TRSP_SO_SEQ = STK.SO_SEQ(+)" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = SUBSTR(@[form_usr_ofc_cd],1,3)" ).append("\n"); 
		query.append("AND	NVL(A.UPD_USR_ID,A.CRE_USR_ID)	=USR1.USR_ID (+)" ).append("\n"); 
		query.append("AND	WRK.CRE_USR_ID                	=USR2.USR_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($so_no.size() > 0)  " ).append("\n"); 
		query.append("AND (A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${so_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append(" 			(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("		   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL  " ).append("\n"); 
		query.append("AND DIST.HJL_NO IS NULL" ).append("\n"); 

	}
}