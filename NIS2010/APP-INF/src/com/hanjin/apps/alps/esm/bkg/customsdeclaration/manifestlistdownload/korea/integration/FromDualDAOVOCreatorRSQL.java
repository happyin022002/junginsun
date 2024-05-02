/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FromDualDAOVOCreatorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.16 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FromDualDAOVOCreatorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생산을 위한 From Dual Query
	  * </pre>
	  */
	public FromDualDAOVOCreatorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : FromDualDAOVOCreatorRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BL_NO, ' ' GEN_SEQ, ' ' USER_ID, ' ' OFC_CD" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' VVD, ' ' BKG_NO, ' ' CSTMS_CLR_TP_CD, ' ' CSTMS_CLR_WH_CD, ' ' CSTMS_DCHG_LOC_WH_CD, ' ' BD_TP_CD, ' ' CSTMS_CLR_LOC_CD, ' ' MSN_CFM_FLG, ' ' UPDATE_CHK, ' ' BL_TP_CD, ' ' MF_SEQ_NO  -- BkgCstmsKrMfSeqNoVO" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' MRN_MODE, ' ' VVD, ' ' POD, ' ' POL, ' ' YARD --KorBondedInfoVO" ).append("\n"); 
		query.append("--' ' TYPE, ' ' MRN_NO, ' ' MRN_CHK_NO, ' ' VVD, ' ' POL, ' ' POD, ' ' MRN_MODE, ' ' YARD, ' ' MSN_NO --KorMsnBondInfoVO" ).append("\n"); 
		query.append("--' ' CNTR_NO --KorContainerCondVO" ).append("\n"); 
		query.append("--' ' BKG_NO  --KorCgoSpecVO" ).append("\n"); 
		query.append("--' ' BL_NO, ' ' IO_BND_CD, ' ' POL_CD, ' ' POD_CD, ' ' VVD , ' ' MRN_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD -- KorBlInfoCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' BL_NO, ' ' POR_CD, ' ' POL_CD, ' ' POD_CD, ' ' DEL_CD, ' ' MSN_NO, ' ' KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("--, ' ' FRT_FWRD_CD, ' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' PCK_QTY, ' ' PCK_TP_CD, ' ' CNTR_TTL_WGT, ' ' WGT_UT_CD, ' ' MEAS_QTY" ).append("\n"); 
		query.append("--, ' ' MEAS_UT_CD, ' ' BD_AREA_CD, ' ' IMDG_CLSS_CD, ' ' N2ND_IMDG_CLSS_CD, ' ' N3RD_IMDG_CLSS_CD, ' ' KR_CSTMS_WH_TP_CD, ' ' KR_WH_CD" ).append("\n"); 
		query.append("--, ' ' USER_ID, ' ' CGO_DESC1, ' ' CGO_DESC2, ' ' FRT_FWRD_CD, ' ' BKG_CGO_TP_CD, ' ' IO_BND_CD, ' ' CSTMS_OFC_CTY_CD, ' ' KR_CSTMS_DEPT_CD" ).append("\n"); 
		query.append("--, ' ' PORT_CD, ' ' CMDT_CD, ' ' KR_MEAS_UT_CD, ' ' BIZ_NO, ' ' BB_CGO_WGT, ' ' BB_CGO_MEAS_QTY, ' ' CGO_SPEC, ' ' OLD_CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("--, ' ' CSTMS_DECL_TP_CD, ' ' KR_CSTMS_BND_CD, ' ' KR_CSTMS_CORR_ID, ' ' SUB_NO, ' ' CORR_RSN, ' ' AMDT_RCVR_FLG" ).append("\n"); 
		query.append("--, ' ' VSL_CALL_SGN_CD, ' ' ETA_DT, ' ' CALL_KNT, ' ' VSL_NM, ' ' VSL_CNT_CD, ' ' IO_TML_LOC_CD" ).append("\n"); 
		query.append("--, ' ' DCHG_MZD_CD, ' ' VVD, ' ' CSTMS_FWRD_ID, ' ' USER_ID, ' ' TRNS_SEQ, ' ' TRANS_CHK, ' ' KR_PORT_AUTH_CD" ).append("\n"); 
		query.append("--, ' ' SMT_AMD_NO, ' ' CALL_YEAR, ' ' ETA_DT, ' ' MRN_NO --KorBlAmdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO,' ' BKG_NO_SPLIT,' ' EXPT_KCD_TP ,' ' KCD_TP,' ' KT_SEQ,' ' CNTR_NO ,' ' FE_IND," ).append("\n"); 
		query.append("--' ' SEAL_NO1, ' ' SEAL_NO2, ' ' CNTRTS_CD ,' ' CNTR_PKG_QTY,' ' CNTR_PKG_CD ,' ' CNTR_WGT_QTY,' ' CNTR_WGT_TP," ).append("\n"); 
		query.append("--' ' CNTR_MEA_QTY,' ' CNTR_MEA_TP ,' ' KT_PORT ,' ' TR_CD ,' ' USERNAME,' ' VSL_CD,' ' OB_TYPE, ' ' C_BL_NO -- BkgCstmsKrCntrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SUB_NO, ' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' BL_NO, ' ' KR_CSTMS_CORR_ID, ' ' CORR_RSN," ).append("\n"); 
		query.append("--' ' USER_ID, ' ' TRNS_SEQ, ' ' PORT_CD, ' ' AMDT_RCVR_FLG, ' ' KR_VSL_CALL_SGN_CD, ' ' CALL_YR," ).append("\n"); 
		query.append("--' ' CALL_KNT, ' ' VSL_NM, ' ' VSL_RGST_CNT_CD, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD, ' ' VVD --KorCorrInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' SUB_NO, ' ' TRNS_SEQ, ' ' KR_CSTMS_CORR_ID, ' ' CORR_RSN" ).append("\n"); 
		query.append("--, ' ' CRNT_CTNT1, ' ' CRNT_CTNT2, ' ' CRNT_CTNT3, ' ' CRNT_CTNT4, ' ' PRE_CTNT1, ' ' PRE_CTNT2" ).append("\n"); 
		query.append("--, ' ' PRE_CTNT3, ' ' PRE_CTNT4, ' ' PORT_CD  -- KorBlCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SMT_AMD_NO, ' ' PORT_CD, ' ' XPT_LIC_NO, ' ' KR_CSTMS_CORR_ID, ' ' CORR_RSN, ' ' PCK_QTY, ' ' PCK_TP_CD" ).append("\n"); 
		query.append("--, ' ' CNTR_WGT, ' ' WGT_UT_CD, ' ' PRT_LODG_FLG, ' ' PRT_LODG_SEQ, ' ' DIVD_PCK_QTY, ' ' DIVD_PCK_UT_CD" ).append("\n"); 
		query.append("--, ' ' DIVD_WGT, ' ' DIVD_WGT_UT_CD, ' ' KR_XPT_PCK_ID, ' ' PRE_XPT_LIC_NO, ' ' USER_ID -- KorExportCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' CURRENT_CHECK -- KorDgCgoManifestVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' MRN_CHK_NO, ' ' VVD, ' ' PORT_CD, ' ' IO_BND_CD, ' ' VSL_ENG_NM, ' ' CALL_SGN_NO, ' ' SND_DT" ).append("\n"); 
		query.append("--, ' ' SND_TM, ' ' DOC_NO, ' ' AUTHORITY, ' ' IO, ' ' CALL_KNT, ' ' ARV_DT, ' ' TRANS_CODE, ' ' DCHG_COM_CD" ).append("\n"); 
		query.append("--, ' ' DSCH_COM_NM, ' ' TOTAL_CNTR, ' ' TOTAL_WGT, ' ' JOB_CODE1, ' ' JOB_CODE2, ' ' FROM_DT, ' ' TO_DT" ).append("\n"); 
		query.append("--, ' ' PRE_PORT, ' ' PORT_AREA, ' ' PORT_ANCH, ' ' PORT_DESC, ' ' SUBSTANCE, ' ' CONTACT, ' ' POL_CD" ).append("\n"); 
		query.append("--, ' ' POD_CD, ' ' USER_ID, ' ' IO_DT, ' ' DATA  -- KorBkgDgVvdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID -- KorDgCgoManifestCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' MRN_CHK_NO, ' ' VVD, ' ' PORT_CD, ' ' IO_BND_CD, ' ' VSL_ENG_NM, ' ' CALL_SGN_NO, ' ' SND_DT" ).append("\n"); 
		query.append("--, ' ' SND_TM, ' ' DOC_NO, ' ' AUTHORITY, ' ' IO, ' ' CALL_KNT, ' ' ARV_DT, ' ' TRANS_CODE, ' ' DCHG_COM_CD" ).append("\n"); 
		query.append("--, ' ' DSCH_COM_NM, ' ' TOTAL_CNTR, ' ' TOTAL_WGT, ' ' JOB_CODE1, ' ' JOB_CODE2, ' ' FROM_DT, ' ' TO_DT" ).append("\n"); 
		query.append("--, ' ' PRE_PORT, ' ' PORT_AREA, ' ' PORT_ANCH, ' ' PORT_DESC, ' ' SUBSTANCE, ' ' CONTACT, ' ' POL_CD" ).append("\n"); 
		query.append("--, ' ' POD_CD, ' ' USER_ID, ' ' IO_DT, ' ' MAX_VVD_SEQ, ' ' CURRENT_CHECK, ' ' TML_VVD, ' ' TML_SKD_VOY_NO" ).append("\n"); 
		query.append("--, ' ' ARV_TM, ' ' TO_TM, ' ' FROM_TM, ' ' IO_TM, ' ' DGCO_SEQ, ' ' USER_ID, ' ' MAX_VVD_SEQ  -- BkgCstmsKrDgCgoVvdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' IB_SEQ, ' ' CNTR_NO, ' ' CNTR_SEQ, ' ' IMDG_UN_NO" ).append("\n"); 
		query.append("--, ' ' MSN_NO, ' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' IMDG_CLSS_CD, ' ' CERTI_NO, ' ' JOB" ).append("\n"); 
		query.append("--, ' ' BL_NO, ' ' SUBSTANCE, ' ' NET_WEIGHT, ' ' SND_CHK, ' ' CERTI_SEQ_NO, ' ' USER_ID" ).append("\n"); 
		query.append("--, ' ' MAX_VVD_SEQ, ' ' IO_BND_CD -- BkgCstmsKrDgCgoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' PORT_CD, ' ' IO_BND_CD -- KorDgInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' RLY_PORT  -- PsaUnmatchCNTRVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' VSL_CD, ' ' SKD_VOY_NO, ' ' SKD_DIR_CD, ' ' MSN_NO, ' ' SEARCH_TYPE, ' ' IO_BND_CD, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' MF_REF_NO, ' ' BKG_NO, ' ' PORT_CD, ' ' MRN_BL_TS_CD, ' ' USER_ID -- ObMsnInfoCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' KR_CSTMS_CORR_ID, ' ' CRNT_DAT_CTNT, ' ' CORR_RSN, ' ' CSTMS_DECL_TP_CD, ' ' CNTR_TPSZ_CD, ' ' WGT_UT_CD," ).append("\n"); 
		query.append("--' ' MEAS_QTY, ' ' USER_ID, ' ' PCK_QTY, ' ' PRE_CNTR_NO, ' ' PORT_CD, ' ' PCK_TP_CD, ' ' MEAS_UT_CD," ).append("\n"); 
		query.append("--' ' SMT_AMD_NO, ' ' CNTR_WGT, ' ' TRNS_SEQ, ' ' VVD, ' ' BKG_NO, ' ' CNTR_NO, ' ' KR_CSTMS_CORR_ID2," ).append("\n"); 
		query.append("--' ' PRE_DAT_CTNT, ' ' FULL_MTY_CD, ' ' CNTR_SEAL_NO1, ' ' CNTR_SEAL_NO2 -- KorCntrCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' KT_SEQ, ' ' EXPT_KD_TP, ' ' BKG_NO, ' ' BKG_ACTWGT_QTY, ' ' BKG_ACTWGT_TP, ' ' BKG_PKG_CD," ).append("\n"); 
		query.append("--' ' KCD_TP, ' ' BKG_PKG_QTY, ' ' KT_PORT, ' ' C_BL_NO, ' ' BME_ELNO, ' ' USERNAME -- KorMailBoxVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_CHK_NO,' ' MRN_NO,' ' IN_BOUND,' ' IN_POL,' ' IN_VVD,' ' IN_POD," ).append("\n"); 
		query.append("--' ' IN_HN,' ' IN_POD_TMNL,' ' SEL_TYPE,' ' BL_DL,' ' ALL_ERR,' ' IN_BLNO," ).append("\n"); 
		query.append("--' ' BL_TYPE,' ' EL_TYPE,' ' CORRECTION,' ' IN_BKG_NO,' ' CNTR_LOCAL, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' CNTR_TS,' ' CNTR_EMPTY,' ' CNTR_TOTAL,' ' BL_LOCAL,' ' BL_TS," ).append("\n"); 
		query.append("--' ' BL_EMPTY,' ' BL_TOTAL,' ' KT_PORT, ' ' ETA_ETD, ' ' ETA_DT, ' ' ETD_DT -- KorMrnNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MSN_START_NUM, ' ' IN_VVD, ' ' IN_POD, ' ' TP, ' ' FE, ' ' BL_NO, ' ' BKG_NO, ' ' HIDDEN3, ' ' POD, ' ' MSN    -- KorMsnNoCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VSL_CD, ' ' SMP_BL_KNT, ' ' ETA_DT, ' ' TTL_TS_TEU_QTY, ' ' MST_BL_KNT, ' ' TTL_MEAS_UT_CD, ' ' LOCL_CSTMS_PRT_CD," ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' TTL_MTY_45FT_QTY, ' ' IN_TYPE, ' ' POL_CD, ' ' CNSL_BL_KNT, ' ' USER_ID, ' ' VSL_CALL_SGN_CD, ' ' TRANS_PRE_CNT," ).append("\n"); 
		query.append("--' ' VVD_SEQ, ' ' UPD_USR_ID, ' ' TTL_TS_FEU_QTY, ' ' JO_CRR_KNT, ' ' OLD_SND_CHK, ' ' MRN_CHK_NO, ' ' LOCL_CSTMS_CD," ).append("\n"); 
		query.append("--' ' DCHG_RPT_SND_DT, ' ' SKD_VOY_NO, ' ' F_DATE, ' ' T_DATE, ' ' DCHG_MZD_CD, ' ' VVD, ' ' POD_CD, ' ' CRE_USR_ID," ).append("\n"); 
		query.append("--' ' TTL_WGT, ' ' TTL_MEAS_QTY, ' ' TTL_LC_FEU_QTY, ' ' CRE_DT, ' ' CSTMS_DCHG_CD, ' ' TTL_TS_45FT_QTY, ' ' CALL_YEAR," ).append("\n"); 
		query.append("--' ' TTL_FULL_KNT, ' ' TTL_LC_TEU_QTY, ' ' TTL_LC_45FT_QTY, ' ' KR_VSL_CALL_SGN_CD, ' ' MF_SND_DT, ' ' CALL_KNT, ' ' TTL_PCK_QTY," ).append("\n"); 
		query.append("--' ' PORT_CD, ' ' VSL_CNT_CD, ' ' MF_SND_USR_ID, ' ' RSPN_RCV_DT, ' ' TTL_MTY_TEU_QTY, ' ' TTL_MTY_FEU_QTY, ' ' UPD_DT," ).append("\n"); 
		query.append("--' ' IO_TML_LOC_CD, ' ' TTL_WGT_UT_CD, ' ' SHP_CO_CD, ' ' VSL_NM, ' ' ETD_DT, ' ' BD_AREA_CD, ' ' MTY_BL_KNT, ' ' IO_BND_CD," ).append("\n"); 
		query.append("--' ' SKD_DIR_CD, ' ' TTL_MTY_KNT, ' ' KT_PA, ' ' TTL_PCK_UT_CD, ' ' DCHG_RPT_SND_USR_ID, ' ' POD_TML, ' ' OB_DECL_TP_CD," ).append("\n"); 
		query.append("--' ' TTL_TS_MTY_TEU_QTY, ' ' TTL_TS_MTY_45FT_QTY, ' ' TTL_TS_MTY_FEU_QTY, ' ' WHF_NOTICE  -- BkgCstmsKrVvdSmryVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' POD_CD, ' ' VVD, ' ' IB_VVD, ' ' IN_TYPE, ' ' POL_CD, ' ' RECEIVER, ' ' USER_ID, ' ' IO_BND_CD, ' ' DWELL, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' TML_CD -- KorVslInfoNManifestCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' IO_QUAY, ' ' D2_CNT, ' ' DISC_MD_CD, ' ' BL_DATA, ' ' D4_CNT, ' ' IO_BND_CD, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' C_BL_NO, ' ' MRN_NO, ' ' SC_DIV, ' ' RESND_CHK, ' ' POD_CD, ' ' VVD, ' ' POL_CD, ' ' IN_TYPE," ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' DMST_PORT_CD, ' ' CSTMS_DECL_TP_CD, ' ' KT_PA, ' ' PORT_CD -- KorCusmanVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' IB_TS_SEQ, ' ' IB_TS_CBLNO, ' ' IB_TS_PORT, ' ' IB_TS_BKGNO, ' ' IB_TS_TYPE, ' ' IB_TS_VVD," ).append("\n"); 
		query.append("--' ' CORR_CD, ' ' CORR_REASON, ' ' USR_ID, ' ' SUB_NO, ' ' BL_NO, ' ' RECEIVER, ' ' OFC_CD -- KorEmpAmdManiVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SUB_NO, ' ' BKG_NO, ' ' BL_NO, ' ' CORR_CD, ' ' CORR_REASON, ' ' USR_ID, ' ' CLT_SEQ, ' ' PORT_CD," ).append("\n"); 
		query.append("--' ' VVD_CD, ' ' CSTMS_BL_NO -- KorEmptyCorrInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USR_ID, ' ' CSTMS_BL_NO, ' ' CSTMS_DECL_TP_CD, ' ' DMST_PORT_CD, ' ' TRNS_SEQ, ' ' SUB_NO -- KorEmpBlInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' OLD_CSTMS_DECL_TP_CD, ' ' BKG_NO, ' ' BL_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' USR_ID -- KorKcdTpChgVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MSN_NO, ' ' BKG_NO, ' ' BL_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' USR_ID -- KorMsnNoInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' OLD_CSTMS_DECL_TP_CD, ' ' MSN_NO, ' ' BKG_NO, ' ' BL_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' USR_ID -- KorKcdTpCntrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BL_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' USR_ID -- KorCustCntVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' S_CUST_NM, ' ' C_CUST_NM, ' ' N_CUST_NM, ' ' S_CUST_ADDR, ' ' C_CUST_ADDR, ' ' N_CUST_ADDR," ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ -- KorCustInqVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' KR_CSTMS_CORR_ID, ' ' CRNT_DAT_CTNT, ' ' CORR_RSN, ' ' CSTMS_DECL_TP_CD, ' ' USER_ID, ' ' MEAS_QTY," ).append("\n"); 
		query.append("--' ' WGT_UT_CD, ' ' CNTR_TPSZ_CD, ' ' PCK_QTY, ' ' PRE_CNTR_NO, ' '  CNTR_SEAL_NO1, ' ' CNTR_SEAL_NO2," ).append("\n"); 
		query.append("--' ' PORT_CD, ' ' PCK_TP_CD, ' '  MEAS_UT_CD, ' ' SMT_AMD_NO, ' ' TRNS_SEQ, ' ' VVD, ' ' BKG_NO, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' CNTR_NO, ' ' KR_CSTMS_CORR_ID2, ' ' PRE_DAT_CTNT, ' ' FULL_MTY_CD, ' ' CNTR_WGT  -- KorCntrCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BL_NO, ' ' SMT_AMD_NO, ' ' KR_XPT_PCK_ID, ' ' CNTR_WGT, ' ' TRNS_SEQ, ' ' KR_CSTMS_CORR_ID, ' ' PRT_LODG_FLG," ).append("\n"); 
		query.append("--' ' XPT_LIC_NO, ' ' DIVD_PCK_QTY, ' ' PRE_XPT_LIC_NO, ' ' BKG_NO, ' ' CORR_RSN, ' ' DIVD_PCK_UT_CD, ' ' PRT_LODG_SEQ," ).append("\n"); 
		query.append("--' ' WGT_UT_CD, ' ' PCK_QTY, ' ' DIVD_WGT, ' ' PORT_CD, ' ' PCK_TP_CD, ' ' DIVD_WGT_UT_CD, ' ' CSTMS_DECL_TP_CD -- KorExpCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' OFFICE, ' ' MRN_PORT, ' ' MRN_CHK, ' ' USERNAME, ' ' VVD_CD, ' ' KDH_SEQ, ' ' MRN_NBR, ' ' MRN_UPDATE_CNT," ).append("\n"); 
		query.append("--' ' ACTION_TIME, ' ' BOUND, ' ' BL_KNT -- KorDownHistVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VSL_CD, ' ' SKD_VOY_NO, ' ' VPS_PORT_CD, ' ' SKD_DIR_CD, ' ' VPS_CALL_IND, ' ' VPS_CALL_SEQ, ' ' VPS_LANE_CD," ).append("\n"); 
		query.append("--' ' VPS_PLISM_VSL, ' ' VPS_PLISM_VOY -- KorIftsaiVslPortVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' DMST_PORT_CD, ' ' TRNS_SEQ, ' ' CSTMS_BL_NO -- KorBlInfoDelAmdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG_NO,RT_BL_TP_CD,FRT_TERM_CD,BKG_CTRT_TP_CD,PPD_RCV_OFC_CD,PPD_PAYR_CNT_CD,PPD_PAYR_CUST_SEQ,CLT_OFC_CD,CLT_PAYR_CNT_CD,CLT_PAYR_CUST_SEQ," ).append("\n"); 
		query.append("--REV_DIV_CD,BKG_RT_WHF_EXPT_CD,WHF_SHPR_RGST_NO,RT_APLY_DT,CGO_RCV_DT,DIFF_RMK,AUD_PRFM_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,PRC_RT_MTCH_PATT_CD," ).append("\n"); 
		query.append("--PRC_GEN_SPCL_RT_TP_CD,PRC_CMDT_HDR_SEQ,PRC_ROUT_SEQ,TRF_LNR_ITM_NO" ).append("\n"); 
		query.append("--FROM BKG_RATE" ).append("\n"); 

	}
}