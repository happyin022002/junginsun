/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Master Inquiry
	  * 2010.10.21 남궁진호 [CHM-201006508-01] LT,ST Term일경우 Reefer Unit Info를 MST_CONTAINER에서 조회한다.기존엔 MST_CNTR_LOT에서 모두조회함
	  * 2010.12.27 진마리아 [CHM-201007809-01] RF_TP_CD을 COM_INTG_CD_DTL에서 조회한다.
	  * 2016.07.20 전지연 [CSR-#15678] Hawk : MST - (SOLAS VGM related topic) Allow update TareWeight & Payload with Container # level : Gross weight, Pay Load 추가
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL").append("\n"); 
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
		query.append("WITH PPARAM" ).append("\n"); 
		query.append("AS " ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("     CNTR_NO " ).append("\n"); 
		query.append(" FROM " ).append("\n"); 
		query.append("	MST_CONTAINER A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() == 10)" ).append("\n"); 
		query.append(" AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append(" AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND NVL(CNMV_DT, SYSDATE) " ).append("\n"); 
		query.append("               = NVL((" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("					MAX(CNMV_DT) " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("					MST_CONTAINER " ).append("\n"); 
		query.append("                WHERE 1 = 1   " ).append("\n"); 
		query.append("      ##${cntr_no}" ).append("\n"); 
		query.append("      #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      ##${cntr_no}" ).append("\n"); 
		query.append("      #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("               ), SYSDATE)" ).append("\n"); 
		query.append(" AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     A.CNTR_NO, A.PLST_FLR_FLG, A.CHK_DGT, A.ACIAC_DIV_CD, A.CNTR_TPSZ_CD, A.CNTR_TPSZ_ISO_CD, A.CNTR_MTRL_CD" ).append("\n"); 
		query.append("   , A.TARE_WGT, A.CNTR_SPEC_NO, A.TARE_WGT_LBS, A.CNTR_GRS_WGT, A.CNTR_GRS_WGT_LBS, A.PAY_LOAD, A.PAY_LOAD_LBS,A.LSTM_CD" ).append("\n"); 
		query.append("   , A.MFTR_VNDR_SEQ AS VNDR_ABBR_NM, A.MFTR_VNDR_ABBR_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("   , A.MFT_DT, A.D2_PAYLD_FLG, A.RF_TP_CD, A.CNMV_STS_CD, A.CRNT_YD_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CNMV_DT" ).append("\n"); 
		query.append("   , A.FULL_FLG, A.DMG_FLG, A.IMDT_EXT_FLG, A.CNTR_HNGR_RCK_CD, A.MNR_HNGR_BAR_TP_CD, A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("   , A.DISP_FLG, A.UCLM_LS, A.ONH_DT, A.ONH_DT_OLD, A.ONH_CNTR_STS_CD, A.ONH_AGMT_NO, A.VNDR_SEQ, A.LESSOR_NM, A.DPC_VAL" ).append("\n"); 
		query.append("   , A.CRE_DT, A.CRE_USR_ID, A.UPD_DT, A.UPD_USR_ID" ).append("\n"); 
		query.append("   , B.SUB_LSTM_CD, B.CNTR_STS_EVNT_DT, B.CNTR_STS_EVNT_DT_OLD, B.CNTR_STS_CD, B.EXIT_AGMT_NO, B.EXIT_VNDR_SEQ, B.EXIT_VNDR_ENG_NM" ).append("\n"); 
		query.append("   , B.DPP_TP_CD, B.DPP_AMT, B.RNTL_CHG_AMT1, B.OFF_HIRE_AVAIL, B.LSE_VNDR_URL" ).append("\n"); 
		query.append("   , COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC() AS CNTR_USE_CO_CD" ).append("\n"); 
		query.append("   , NVL(( SELECT COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC()" ).append("\n"); 
		query.append("             FROM MNR_TTL_LSS_RQST_HDR TH" ).append("\n"); 
		query.append("                , MNR_TTL_LSS_RQST_DTL TD" ).append("\n"); 
		query.append("                , MST_CONTAINER MC" ).append("\n"); 
		query.append("            WHERE 1                   = 1" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 
		query.append("              AND    TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("              AND    TD.RQST_EQ_NO    = A.CNTR_NO" ).append("\n"); 
		query.append("              AND    A.CNTR_NO       = MC.CNTR_NO" ).append("\n"); 
		query.append("              AND    MC.ONH_DT < TH.TTL_LSS_DT" ).append("\n"); 
		query.append("              AND    ROWNUM            = 1), DECODE(A.CNTR_STS_CD||A.CNMV_STS_CD||A.ACIAC_DIV_CD, 'OWNMTInactive', 'Not Receiving', A.LESSOR_NM) " ).append("\n"); 
		query.append("        ) AS OWNR_CO_CD," ).append("\n"); 
		query.append("--	CASE WHEN A.LSTM_CD IN ('LT','ST','OF','SB','MU') THEN " ).append("\n"); 
		query.append("--		(DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD)) * B.RNTL_CHG_AMT1" ).append("\n"); 
		query.append("--	ELSE 0 END AS RNTL_CHG_AMT," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])," ).append("\n"); 
		query.append("	'Y'," ).append("\n"); 
		query.append("		CASE WHEN A.LSTM_CD IN ('LT','ST','OF','SB','MU') THEN " ).append("\n"); 
		query.append("    		(DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD)) * B.RNTL_CHG_AMT1" ).append("\n"); 
		query.append("		ELSE 0 END," ).append("\n"); 
		query.append("	'N', '')" ).append("\n"); 
		query.append("	AS RNTL_CHG_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	C.BKG_NO1," ).append("\n"); 
		query.append("	C.BKG_NO2," ).append("\n"); 
		query.append("	C.BKG_NO3," ).append("\n"); 
		query.append("--	DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD) USING_DAYS," ).append("\n"); 
		query.append("	DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])," ).append("\n"); 
		query.append("		'Y',DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD)," ).append("\n"); 
		query.append("		'N','')" ).append("\n"); 
		query.append("	AS USING_DAYS," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',P.CNTR_NO) COST_AMT," ).append("\n"); 
		query.append("	L.CERTI_NO," ).append("\n"); 
		query.append("	L.APRO_CSC_NO," ).append("\n"); 
		query.append("	L.APRO_TIR_NO," ).append("\n"); 
		query.append("	(SELECT NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("	 FROM MDM_VENDOR " ).append("\n"); 
		query.append("	 WHERE VNDR_SEQ = CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MKR_SEQ ELSE L.RF_MKR_SEQ END" ).append("\n"); 
		query.append("	)AS RF_MKR_SEQ," ).append("\n"); 
		query.append("	CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MDL_NM ELSE L.RF_MDL_NM END AS RF_MDL_NM," ).append("\n"); 
		query.append("	CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_RFR_NO ELSE L.RF_RFR_NO END AS RF_RFR_NO," ).append("\n"); 
		query.append("	CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.MIN_TEMP ELSE L.MIN_TEMP END AS MIN_TEMP," ).append("\n"); 
		query.append("	CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.MAX_TEMP ELSE L.MAX_TEMP END AS MAX_TEMP," ).append("\n"); 
		query.append("--    MST_COMMON_PKG.MST_RU_LBL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("	MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("    MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC," ).append("\n"); 
		query.append("	(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID   = 'CD30023' AND INTG_CD_VAL_CTNT = A.RF_HUMID_CTRL_VAL_CD) AS RF_HUMID_CTRL_VAL_CD," ).append("\n"); 
		query.append("    A.RF_CMPR_CTNT," ).append("\n"); 
		query.append("    A.CNTR_AUTH_NO, " ).append("\n"); 
		query.append("	A.CNTR_OFFH_AUTH_NO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			A.CNTR_NO," ).append("\n"); 
		query.append("			A.PLST_FLR_FLG," ).append("\n"); 
		query.append("			SUBSTR(A.CNTR_NO,11) CHK_DGT," ).append("\n"); 
		query.append("			DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD," ).append("\n"); 
		query.append("			A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			B.CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("			A.CNTR_MTRL_CD," ).append("\n"); 
		query.append("			E.CNTR_SPEC_NO, " ).append("\n"); 
		query.append("			RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.TARE_WGT), 3), 'FM9999999999999990D000'), '.') TARE_WGT," ).append("\n"); 
		query.append("			RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.TARE_WGT) * 2.2046, 3), 'FM9999999999999990D000'), '.') TARE_WGT_LBS," ).append("\n"); 
		query.append("            RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.CNTR_GRS_WGT), 3), 'FM9999999999999990D000'), '.') CNTR_GRS_WGT," ).append("\n"); 
		query.append("			RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.CNTR_GRS_WGT) * 2.2046, 3), 'FM9999999999999990D000'), '.') CNTR_GRS_WGT_LBS," ).append("\n"); 
		query.append("            RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.PAY_LOAD), 3), 'FM9999999999999990D000'), '.') PAY_LOAD," ).append("\n"); 
		query.append("			RTRIM(TO_CHAR(ROUND(TO_NUMBER(E.PAY_LOAD) * 2.2046, 3), 'FM9999999999999990D000'), '.') PAY_LOAD_LBS," ).append("\n"); 
		query.append("			A.LSTM_CD," ).append("\n"); 
		query.append("			C.VNDR_ABBR_NM," ).append("\n"); 
		query.append("			C.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("			TO_CHAR(A.MFT_DT, 'YYYY-MM-DD') MFT_DT," ).append("\n"); 
		query.append("			A.D2_PAYLD_FLG," ).append("\n"); 
		query.append("			--DECODE(A.RF_TP_CD,'H','HU','C','CA','M','MG','D','DF','') RF_TP_CD," ).append("\n"); 
		query.append("			(SELECT S.INTG_CD_VAL_DP_DESC ||' (' ||S.INTG_CD_VAL_DESC || ')' AS RF_TP_CD" ).append("\n"); 
		query.append("		     FROM   COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("			 WHERE	S.INTG_CD_VAL_CTNT = A.RF_TP_CD" ).append("\n"); 
		query.append("			 AND    S.INTG_CD_ID       = 'CD01085'	) RF_TP_CD," ).append("\n"); 
		query.append("			A.CNMV_STS_CD," ).append("\n"); 
		query.append("			A.CRNT_YD_CD," ).append("\n"); 
		query.append("			A.VSL_CD," ).append("\n"); 
		query.append("			A.SKD_VOY_NO," ).append("\n"); 
		query.append("			A.SKD_DIR_CD," ).append("\n"); 
		query.append("			TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD HH24:MI') CNMV_DT," ).append("\n"); 
		query.append("			A.FULL_FLG," ).append("\n"); 
		query.append("			A.DMG_FLG," ).append("\n"); 
		query.append("			A.IMDT_EXT_FLG," ).append("\n"); 
		query.append("			(	SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("				FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("				WHERE INTG_CD_ID ='CD02012'" ).append("\n"); 
		query.append("				AND INTG_CD_VAL_CTNT = A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("			) CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("			A.MNR_HNGR_BAR_TP_CD, --" ).append("\n"); 
		query.append("			A.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("			A.DISP_FLG," ).append("\n"); 
		query.append("			A.UCLM_LS_DIV_CD UCLM_LS, " ).append("\n"); 
		query.append("			TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT," ).append("\n"); 
		query.append("			A.ONH_DT ONH_DT_OLD," ).append("\n"); 
		query.append("			A.ONH_CNTR_STS_CD," ).append("\n"); 
		query.append("			MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) ONH_AGMT_NO," ).append("\n"); 
		query.append("			D.VNDR_SEQ," ).append("\n"); 
		query.append("			D.VNDR_LGL_ENG_NM LESSOR_NM," ).append("\n"); 
		query.append("			MNR_COMMON_PKG.MNR_CAL_DV_FNC('U',A.CNTR_NO,TO_CHAR(SYSDATE,'YYYYMMDD')) DPC_VAL," ).append("\n"); 
		query.append("			A.RF_MKR_SEQ," ).append("\n"); 
		query.append("			A.RF_MDL_NM," ).append("\n"); 
		query.append("			A.RF_RFR_NO," ).append("\n"); 
		query.append("			A.MIN_TEMP," ).append("\n"); 
		query.append("			A.MAX_TEMP," ).append("\n"); 
		query.append("			TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("			A.CRE_USR_ID," ).append("\n"); 
		query.append("			TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("			A.UPD_USR_ID," ).append("\n"); 
		query.append("			A.RF_HUMID_CTRL_VAL_CD," ).append("\n"); 
		query.append("            A.RF_CMPR_CTNT," ).append("\n"); 
		query.append("            A.CNTR_STS_CD," ).append("\n"); 
		query.append("            A.LOT_PLN_YR," ).append("\n"); 
		query.append("            A.LOT_LOC_CD," ).append("\n"); 
		query.append("            A.LOT_SEQ," ).append("\n"); 
		query.append("            C.VNDR_SEQ AS MFTR_VNDR_SEQ," ).append("\n"); 
		query.append("            C.VNDR_ABBR_NM AS MFTR_VNDR_ABBR_NM," ).append("\n"); 
		query.append("            A.CNTR_AUTH_NO," ).append("\n"); 
		query.append("			A.CNTR_OFFH_AUTH_NO" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			MST_CONTAINER A," ).append("\n"); 
		query.append("			MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("	    	SELECT " ).append("\n"); 
		query.append("	    		BB.VNDR_ABBR_NM," ).append("\n"); 
		query.append("	       		BB.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	       		BB.VNDR_SEQ" ).append("\n"); 
		query.append("	    	FROM" ).append("\n"); 
		query.append("	       		MST_CONTAINER AA, " ).append("\n"); 
		query.append("	       		MDM_VENDOR BB," ).append("\n"); 
		query.append("	       		PPARAM P" ).append("\n"); 
		query.append("	    	WHERE AA.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("	    	AND   AA.MFTR_VNDR_SEQ = BB.VNDR_SEQ" ).append("\n"); 
		query.append("			) C," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("				AA.VNDR_SEQ," ).append("\n"); 
		query.append("				BB.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM " ).append("\n"); 
		query.append("				MST_CONTAINER AA," ).append("\n"); 
		query.append("				MDM_VENDOR BB," ).append("\n"); 
		query.append("				PPARAM P" ).append("\n"); 
		query.append("			WHERE AA.CNTR_NO    = P.CNTR_NO" ).append("\n"); 
		query.append("			AND   AA.VNDR_SEQ   = BB.VNDR_SEQ" ).append("\n"); 
		query.append("			) D," ).append("\n"); 
		query.append("			(SELECT MST_SPEC_FNC('TARE', C.CNTR_NO) TARE_WGT," ).append("\n"); 
		query.append("                    MST_SPEC_FNC('GRSS', C.CNTR_NO) CNTR_GRS_WGT," ).append("\n"); 
		query.append("                    MST_SPEC_FNC('PAYL', C.CNTR_NO) PAY_LOAD," ).append("\n"); 
		query.append("                    B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("               FROM MST_CNTR_SPEC B," ).append("\n"); 
		query.append("                    MST_CONTAINER C," ).append("\n"); 
		query.append("                    PPARAM P," ).append("\n"); 
		query.append("MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("              WHERE 1 = 1" ).append("\n"); 
		query.append("                AND C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("                AND C.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("                AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("            ) E," ).append("\n"); 
		query.append("			PPARAM P   " ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("		AND A.CNTR_NO				=	P.CNTR_NO" ).append("\n"); 
		query.append("		AND B.CNTR_TPSZ_CD	=	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		AND A.MFTR_VNDR_SEQ	=	C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		AND A.VNDR_SEQ			=	D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	)A," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("	       CASE WHEN C.ACIAC_DIV_CD = 'I' THEN " ).append("\n"); 
		query.append("	           CASE WHEN B.CNTR_STS_CD IN ('SBO', 'MUO', 'SBI', 'MUI') THEN D.LSTM_CD" ).append("\n"); 
		query.append("	           ELSE C.LSTM_CD END" ).append("\n"); 
		query.append("	       ELSE C.LSTM_CD END SUB_LSTM_CD," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	       THEN TO_CHAR(B.CNTR_STS_EVNT_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	       ELSE '' END CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	       THEN B.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("	       ELSE NULL END  CNTR_STS_EVNT_DT_OLD," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	       THEN B.CNTR_STS_CD" ).append("\n"); 
		query.append("	       ELSE '' END CNTR_STS_CD," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	       THEN MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD, B.AGMT_SEQ) " ).append("\n"); 
		query.append("	       ELSE '' END EXIT_AGMT_NO," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	            THEN TO_CHAR(E.VNDR_SEQ)" ).append("\n"); 
		query.append("	       WHEN B.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	            THEN DECODE(NVL(B.CUST_CNT_CD,'0'), '0', '', B.CUST_CNT_CD||B.CUST_SEQ)" ).append("\n"); 
		query.append("	       ELSE '' END EXIT_VNDR_SEQ," ).append("\n"); 
		query.append("	       CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SCR', 'DON', 'TLL')" ).append("\n"); 
		query.append("	            THEN E.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	       WHEN B.CNTR_STS_CD IN ('SLD') " ).append("\n"); 
		query.append("	            THEN DECODE(NVL(B.CUST_CNT_CD,'0'), '0', B.CUST_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = B.CUST_CNT_CD AND CUST_SEQ = B.CUST_SEQ))" ).append("\n"); 
		query.append("	       ELSE '' END EXIT_VNDR_ENG_NM," ).append("\n"); 
		query.append("	       NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(C.AGMT_CTY_CD, C.AGMT_SEQ, 'DPP',C.CNTR_TPSZ_CD, C.ONH_YD_CD), 0) DPP_TP_CD," ).append("\n"); 
		query.append("	       NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(C.AGMT_CTY_CD, C.AGMT_SEQ, 'DPC',C.CNTR_TPSZ_CD, C.ONH_YD_CD), 0) AS DPP_AMT," ).append("\n"); 
		query.append("	      NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(C.AGMT_CTY_CD, C.AGMT_SEQ, 'PDM',C.CNTR_TPSZ_CD, C.ONH_YD_CD), 0) AS RNTL_CHG_AMT1," ).append("\n"); 
		query.append("	      CASE WHEN C.ACIAC_DIV_CD = 'A' AND C.LSTM_CD = 'LT' THEN" ).append("\n"); 
		query.append("	          CASE WHEN TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (A XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("										   FROM LSE_AGMT_VER A" ).append("\n"); 
		query.append("										   WHERE  A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("										   AND    A.AGMT_SEQ    = C.AGMT_SEQ" ).append("\n"); 
		query.append("										   AND    ROWNUM = 1" ).append("\n"); 
		query.append("	                            		 ) > 0" ).append("\n"); 
		query.append("	          	   THEN  'Offhire Available !!!'" ).append("\n"); 
		query.append("	          	   ELSE '' " ).append("\n"); 
		query.append("			  END" ).append("\n"); 
		query.append("	      WHEN C.ACIAC_DIV_CD = 'A' AND C.LSTM_CD IN ('ST', 'SI', 'OF', 'MI') THEN" ).append("\n"); 
		query.append("	          CASE WHEN TRUNC(SYSDATE)  > TRUNC(C.ONH_DT) + (NVL(C.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("	                   THEN  'Offhire Available !!!'" ).append("\n"); 
		query.append("	              ELSE '' END" ).append("\n"); 
		query.append("	       ELSE '' END OFF_HIRE_AVAIL," ).append("\n"); 
		query.append("	       C.CNTR_NO," ).append("\n"); 
		query.append("	       D.LSE_VNDR_URL" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("				A.LST_STS_SEQ MAX_STS_SEQ, " ).append("\n"); 
		query.append("				A.CNTR_NO" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("				MST_CONTAINER A," ).append("\n"); 
		query.append("				PPARAM P" ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			AND    A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("			) A, " ).append("\n"); 
		query.append("			MST_CNTR_STS_HIS B, " ).append("\n"); 
		query.append("			MST_CONTAINER C, " ).append("\n"); 
		query.append("			LSE_AGREEMENT D," ).append("\n"); 
		query.append("			MDM_VENDOR E" ).append("\n"); 
		query.append("		WHERE A.CNTR_NO     = B.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND   A.MAX_STS_SEQ = B.CNTR_STS_SEQ(+)" ).append("\n"); 
		query.append("		AND   C.CNTR_NO     = A.CNTR_NO" ).append("\n"); 
		query.append("		AND   D.AGMT_CTY_CD(+) = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("		AND   D.AGMT_SEQ(+)    = B.AGMT_SEQ" ).append("\n"); 
		query.append("		AND   D.VNDR_SEQ    = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	) B," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("    	MAX(DECODE(RN, 1, BKG_NO)) BKG_NO1," ).append("\n"); 
		query.append("    	MAX(DECODE(RN, 2, BKG_NO)) BKG_NO2," ).append("\n"); 
		query.append("    	MAX(DECODE(RN, 3, BKG_NO)) BKG_NO3" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("    	SELECT ROWNUM RN,BKG_NO" ).append("\n"); 
		query.append("    	FROM" ).append("\n"); 
		query.append("        	(" ).append("\n"); 
		query.append("        	SELECT /*+ INDEX_DESC(A XAK11CTM_MOVEMENT) */  " ).append("\n"); 
		query.append("				A.BKG_NO, " ).append("\n"); 
		query.append("				CNMV_EVNT_DT EVNT_DT" ).append("\n"); 
		query.append("        	FROM " ).append("\n"); 
		query.append("				CTM_MOVEMENT A , " ).append("\n"); 
		query.append("				PPARAM P , " ).append("\n"); 
		query.append("				MST_CONTAINER B" ).append("\n"); 
		query.append("        	WHERE 1 = 1" ).append("\n"); 
		query.append("        	AND B.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	AND A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	AND B.CNMV_CYC_NO =A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        	AND A.BKG_CGO_TP_CD IN('F','R')" ).append("\n"); 
		query.append("        	AND  ROWNUM=1" ).append("\n"); 
		query.append("        	UNION ALL" ).append("\n"); 
		query.append("        	SELECT /*+ INDEX_DESC(A XAK11CTM_MOVEMENT) */  " ).append("\n"); 
		query.append("				A.BKG_NO, " ).append("\n"); 
		query.append("				MAX(CNMV_EVNT_DT) EVNT_DT" ).append("\n"); 
		query.append("        	FROM " ).append("\n"); 
		query.append("				CTM_MOVEMENT A , " ).append("\n"); 
		query.append("				PPARAM P , " ).append("\n"); 
		query.append("				MST_CONTAINER B" ).append("\n"); 
		query.append("        	WHERE 1 = 1" ).append("\n"); 
		query.append("	        AND B.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("    	    AND A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	AND B.CNMV_CYC_NO > A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        	AND A.MVMT_STS_CD IN('VD')" ).append("\n"); 
		query.append("        	AND A.BKG_CGO_TP_CD IN('F','R')" ).append("\n"); 
		query.append("        	AND ROWNUM <= 10" ).append("\n"); 
		query.append("        	GROUP BY A.BKG_NO" ).append("\n"); 
		query.append("        	ORDER BY EVNT_DT DESC" ).append("\n"); 
		query.append("        	) " ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	)C," ).append("\n"); 
		query.append("	PPARAM P," ).append("\n"); 
		query.append("	MST_CNTR_LOT L" ).append("\n"); 
		query.append("WHERE A.CNTR_NO      = B.CNTR_NO" ).append("\n"); 
		query.append("AND   A.LOT_PLN_YR   = L.LOT_PLN_YR(+)" ).append("\n"); 
		query.append("AND   A.LOT_LOC_CD   = L.LOT_LOC_CD(+)" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = L.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND   A.LOT_SEQ      = L.LOT_SEQ(+)" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}