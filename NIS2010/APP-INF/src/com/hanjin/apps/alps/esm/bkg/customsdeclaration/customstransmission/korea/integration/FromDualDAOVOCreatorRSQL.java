/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FromDualDAOVOCreatorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.05.13 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
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
		query.append("-- ' ' MRN_NO, ' ' IO_BND_CD, ' ' VVD1, ' ' PORT_CD, ' ' VVD2, ' ' VVD, ' ' MRN_CHK_NO, ' ' USER_ID" ).append("\n"); 
		query.append("--' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' YARD_CD, ' ' IN_TYPE, ' ' BL_NO, ' ' IO_BND_CD, ' ' USER_ID -- KorManifestListCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' IO_BND_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' CSTMS_DECL_TP_CD --KorCustInfoCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ --KorCustChkVO" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ, ' ' C_BL_NO --KorCntrInfoCondVO" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' TRNS_SEQ --KorElnoInfoCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' TML_CD, ' ' IN_TYPE, ' ' BL_NO, ' ' IO_BND_CD, ' ' RECEIVER, ' ' USER_ID --KorVslInfoNManifestCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POD_TML, ' ' PORT_CD, ' ' IO_BND_CD -- BlSummaryCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' IN_TYPE, ' ' POL_CD, ' ' POD_CD, ' ' MRN_CHK_NO, ' ' MRN_NO, ' ' IO_BND_CD, ' ' VVD_SEQ, ' ' POD_TML" ).append("\n"); 
		query.append("--, MRN_NO , MRN_CHK_NO , VSL_CD , SKD_VOY_NO , SKD_DIR_CD , OB_DECL_TP_CD , VVD_SEQ , PORT_CD , PORT_CD , VSL_CNT_CD , VSL_NM , KR_VSL_CALL_SGN_CD ," ).append("\n"); 
		query.append("-- ETA_DT , ETD_DT , MST_BL_KNT , CNSL_BL_KNT , MTY_BL_KNT , TTL_WGT , TTL_MEAS_QTY , TTL_PCK_QTY , TTL_FULL_KNT , TTL_MTY_KNT , TTL_LC_TEU_QTY ," ).append("\n"); 
		query.append("-- TTL_LC_FEU_QTY , TTL_LC_45FT_QTY, TTL_TS_TEU_QTY , TTL_TS_FEU_QTY , TTL_TS_45FT_QTY, TTL_MTY_TEU_QTY , TTL_MTY_FEU_QTY , TTL_MTY_45FT_QTY," ).append("\n"); 
		query.append("-- JO_CRR_KNT , CRE_DT , CRE_USR_ID , UPD_DT , UPD_USR_ID , MF_SND_DT , MF_SND_USR_ID , RSPN_RCV_DT , CSTMS_DCHG_CD , DCHG_RPT_SND_DT , DCHG_RPT_SND_USR_ID," ).append("\n"); 
		query.append("-- CALL_KNT, DCHG_MZD_CD, IO_TML_LOC_CD, VSL_CNT_CD, ' ' F_DATE, ' ' T_DATE, ' ' TRANS_PRE_CNT, ' ' BD_AREA_CD, ' ' SMP_BL_KNT, ' ' SHP_CO_CD," ).append("\n"); 
		query.append("-- ' ' IO_TML_LOC_CD, ' ' TTL_WGT_UT_CD, ' ' TTL_MEAS_UT_CD, ' ' TTL_PCK_UT_CD, ' ' VSL_CALL_SGN_CD,' ' LOCL_CSTMS_CD, ' ' LOCL_CSTMS_PRT_CD, ' ' JO_CRR_KNT, ' ' CALL_KNT, ' ' CALL_YEAR, ' ' KT_PA, ' ' USER_ID" ).append("\n"); 
		query.append("--, ' ' OLD_SND_CHK, ' ' MST_BL_KNT" ).append("\n"); 
		query.append("--from BKG_CSTMS_KR_VVD_SMRY  --BkgCstmsKrVvdSmryVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' VVD, ' ' PORT_CD, ' ' POL_CD, ' ' POD_CD, ' ' TML_CD, ' ' POD_TML," ).append("\n"); 
		query.append("--' ' BD_AREA_CD, ' ' IO_BND_CD, ' ' IN_TYPE, ' ' CALL_KNT, ' ' VSL_NM, ' ' VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("--' ' ETA_DT, ' ' ETD_DT, ' ' CSTMS_DCHG_CD, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD, ' ' LOCL_CSTMS_CD," ).append("\n"); 
		query.append("--' ' LOCL_CSTMS_PRT_CD, ' ' VSL_CNT_CD, ' ' MRN_NO, ' ' VVD_SEQ --KorManifestSmryCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' BD_AREA_CD, ' ' USER_ID, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POD_CD, ' ' POL_CD, ' ' POD_TML" ).append("\n"); 
		query.append("--, ' ' TRNS_SEQ, ' ' CSTMS_DECL_TP_CD, ' ' BKG_NO --BkgCstmsKrBlVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' VVD, ' ' VVD_SEQ, ' ' IN_TYPE, ' ' PORT_CD, ' ' POD_TML, ' ' USER_ID, ' ' OFC_CD," ).append("\n"); 
		query.append("--' ' POD_CD, ' ' POL_CD, ' ' IO_BND_CD, ' ' TML_CD -- KorManifestSmryVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POD_CD, ' ' POL_CD, ' ' POD_TML, ' ' C_BL_NO, ' ' BKG_NO," ).append("\n"); 
		query.append("--' ' CSTMS_DECL_TP_CD, ' ' TRNS_SEQ --BkgCstmsKrCntrVO" ).append("\n"); 
		query.append("--' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POD_CD, ' ' POL_CD, ' ' POD_TML --BkgCstmsKrCustVO" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POD_CD, ' ' POL_CD, ' ' POD_TML -- BkgCstmsKrXptLicVO" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' VVD, ' ' DL_SEQ, ' ' POL_CD, ' ' POD_CD, ' ' OFC_CD, ' ' USER_ID, ' ' DEL_CNT -- BkgCstmsKrDlHisVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BD_AREA_CD, ' ' IO_BND_CD, ' ' IN_TYPE, ' ' CALL_KNT, ' ' VSL_NM, ' ' VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("--' ' ETA_DT, ' ' ETD_DT, ' ' CSTMS_DCHG_CD, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD, ' ' LOCL_CSTMS_CD," ).append("\n"); 
		query.append("--' ' LOCL_CSTMS_PRT_CD, ' ' VSL_CNT_CD, ' ' MRN_NO, ' ' VVD_SEQ," ).append("\n"); 
		query.append("--' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POL_CD, ' ' POD_CD, ' ' POD_TML, ' ' TML_CD, ' ' USER_ID," ).append("\n"); 
		query.append("--' ' OFC_CD, ' ' MST_BL_KNT  -- KorDischManifestTransmitVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SND_DT, ' ' OFC_CD, ' ' USER_ID, ' ' EDI_SND_MSG, ' ' IO_BND_CD  --BkgCstmsKrSndLogDtlVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SND_DT, ' ' USER_ID, ' ' OFC_CD, ' ' VVD, ' ' IO_BND_CD, ' ' POL_CD, ' ' POD_CD, ' ' IN_TYPE, ' ' BL_KNT" ).append("\n"); 
		query.append("--, ' ' TEU_CNT, ' ' FEU_CNT, ' ' KT_PA, ' ' RESND_CHK, ' ' BL_NO, ' ' CORR_CD, ' ' KT_PA" ).append("\n"); 
		query.append("--, ' ' SUB_NO    --BkgCstmsKrSndLogVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' CSTMS_DSCH_CD, ' ' LOCL_CSTMS_CD, ' ' LOCL_CSTMS_PRT_CD, ' ' BKG_NO, ' ' C_BL_NO," ).append("\n"); 
		query.append("--' ' VVD, ' ' PORT_CD, ' ' IO_BND_CD, ' ' IN_TYPE, ' ' POD_CD, ' ' POL_CD, ' ' BL_DATA, ' ' CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("--' ' CNTR_DATA, ' ' USER_ID  --KorDiscFlatFileVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' TEU_CNT, ' ' FEU_CNT, ' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD  -- KorCntrCntVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' POD_CD, ' ' POL_CD, ' ' OFC_CD, ' ' VVD, ' ' IO_BND_CD, ' ' IN_TYPE, ' ' PORT_CD, ' ' TML_CD," ).append("\n"); 
		query.append("--' ' POD_TML, ' ' BD_AREA_CD, ' ' IO_BND_CD, ' ' IN_TYPE, ' ' CALL_KNT, ' ' VSL_NM, ' ' VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("--' ' ETA_DT, ' ' ETD_DT, ' ' CSTMS_DCHG_CD, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD, ' ' LOCL_CSTMS_CD," ).append("\n"); 
		query.append("--' ' LOCL_CSTMS_PRT_CD, ' ' VSL_CNT_CD, ' ' MRN_NO, ' ' VVD_SEQ," ).append("\n"); 
		query.append("--' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' IO_BND_CD, ' ' POL_CD, ' ' POD_CD, ' ' POD_TML, ' ' TML_CD, ' ' USER_ID," ).append("\n"); 
		query.append("--' ' OFC_CD, ' ' MST_BL_KNT, ' ' IN_RECEIVER, ' ' KT_PA, ' ' MSN_NO, ' ' JO_CRR_KNT, ' ' MST_BL_KNT," ).append("\n"); 
		query.append("--' ' BL_NO, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD, ' ' TTL_LC_TEU_QTY, ' ' TTL_TS_TEU_QTY, ' ' CNSL_BL_KNT," ).append("\n"); 
		query.append("--' ' MTY_BL_KNT, ' ' TTL_WGT --KorManifestTransmitVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' DMST_PORT_CD, ' ' BL_DATA, ' ' SC_DIV, ' ' C_BL_NO," ).append("\n"); 
		query.append("--' ' RESND_CHK, ' ' KT_PA, ' ' IO_BND_CD, ' ' MRN_NO, ' ' D2_CNT, ' ' D4_CNT, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' DISC_MD_CD, ' ' IO_QUAY, ' ' VVD, ' ' PORT_CD, ' ' IN_TYPE, ' ' POD_CD, ' ' POL_CD, ' ' CNTR_NO, ' ' PORT_TML_CD -- KorCusmanVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' KR_CSTMS_DEPT_CD, ' ' CSTMS_OFC_CTY_CD, ' ' SMT_AMD_NO, ' ' PRE_CTNT1, ' ' PRE_CTNT2, ' ' PRE_CTNT3, ' ' PRE_CTNT4," ).append("\n"); 
		query.append("--' ' CRNT_CTNT1, ' ' CRNT_CTNT2, ' ' CRNT_CTNT3, ' ' CRNT_CTNT4," ).append("\n"); 
		query.append("--' ' TRNS_SEQ, ' ' CORR_RSN, ' ' USR_NAME, ' ' OLD_DISC, ' ' NEW_DISC  -- KorCusdmrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' CANCEL_FLG, ' ' IN_CHG_METH, ' ' IN_CHG_PORT, ' ' IN_CHG_COMP, ' ' OFC_CD," ).append("\n"); 
		query.append("--' ' POD_CD, ' ' POL_CD, ' ' IO_BND_CD, ' ' KT_PA, ' ' CALL_KNT, ' ' VSL_CALL_SGN_CD," ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' VVD, ' ' VSL_NM, ' ' VSL_CNT_CD, ' ' DCHG_MZD_CD, ' ' IO_TML_LOC_CD," ).append("\n"); 
		query.append("--' ' BL_NO, ' ' CALL_YEAR, ' ' TTL_WGT, ' ' TTL_MEAS_QTY, ' ' CALL_KNT, ' ' BD_AREA_CD," ).append("\n"); 
		query.append("--' ' JO_CRR_KNT, ' ' TTL_MEAS_UT_CD, ' ' TTL_PCK_UT_CD, ' ' TTL_PCK_QTY, ' ' CSTMS_DCHG_CD," ).append("\n"); 
		query.append("--' ' ETA_DT, ' ' IN_CHG_ETA -- KorAmendManifestTransmitVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' KT_PA, ' ' IO_BND_CD, ' ' CALL_YEAR, ' ' VSL_CALL_SGN_CD, ' ' MRN_NO, ' ' VVD" ).append("\n"); 
		query.append("--, ' ' VSL_NM, ' ' VSL_CNT_CD, ' ' BL_NO, ' ' CALL_KNT, ' ' DCHG_MZD_CD, ' ' UN_POL_CD, ' ' UN_POD_CD" ).append("\n"); 
		query.append("--, ' ' IO_TML_LOC_CD, ' ' BD_AREA_CD, ' ' TTL_PCK_UT_CD, ' ' TTL_WGT, ' ' TTL_MEAS_UT_CD, ' ' TTL_MEAS_QTY" ).append("\n"); 
		query.append("--, ' ' MSN_NO, ' ' KR_CSTMS_CORR_ID, ' ' KR_CSTMS_BL_TP_CD, ' ' BKG_CGO_TP_CD, ' ' POL_CD, ' ' POD_CD" ).append("\n"); 
		query.append("--, ' ' PCK_TP_CD, ' ' CMDT_CD, ' ' CGO_DESC1, ' ' CGO_DESC2, ' ' IMDG_CLSS_CD, ' ' N2ND_IMDG_CLSS_CD" ).append("\n"); 
		query.append("--, ' ' N3RD_IMDG_CLSS_CD, ' ' CNTR_TTL_WGT, ' ' MEAS_UT_CD, ' ' MEAS_QTY, ' ' S_CUST_NM, ' ' S_CUST_ADDR" ).append("\n"); 
		query.append("--, ' ' C_CUST_NM, ' ' C_CUST_ADDR, ' ' N_CUST_NM, ' ' N_CUST_ADDR, ' '  BIZ_NO, ' ' CNTR_WGT" ).append("\n"); 
		query.append("--, ' ' CNTR_SEAL_NO, ' ' CNTR_SEAL_NO1, ' ' CNTR_SEAL_NO2, ' ' CNTR_NO, ' ' PRE_CNTR_NO, ' ' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--, ' ' CRNT_CTNT1, ' ' CRNT_CTNT2, ' ' PRE_CTNT1, ' ' PRE_CTNT2" ).append("\n"); 
		query.append("--, ' ' CORR_RSN, ' ' KR_MEAS_UT_CD   -- KorMacamdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' EDI_SND_MSG, ' ' CORR_CD, ' ' MDATA1, ' ' MDATA2, ' ' MDATA3  -- KorCorrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' CSTMS_OFC_CTY_CD, ' ' KR_CSTMS_DEPT_CD, ' ' SUB_NO, ' ' KR_CSTMS_CORR_ID, ' ' BL_NO, ' ' KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("--, ' ' CSTMS_DECL_TP_CD, ' ' POD_CD, ' ' PCK_QTY, ' ' PCK_TP_CD, ' ' CORR_RSN, ' ' CGO_DESC1, ' ' CNTR_TTL_WGT" ).append("\n"); 
		query.append("--, ' ' WGT_UT_CD, ' ' MEAS_QTY, ' ' CNTR_CNT, ' ' S_CUST_NM, ' ' S_CUST_ADDR, ' ' C_CUST_NM, ' ' C_CUST_ADDR" ).append("\n"); 
		query.append("--, ' ' N_CUST_NM, ' ' N_CUST_ADDR, ' ' BD_AREA_CD" ).append("\n"); 
		query.append("--, ' ' XPT_LIC_NO, ' ' PRE_XPT_LIC_NO, ' ' KR_CSTMS_CORR_ID, ' ' CORR_RSN, ' ' PCK_TP_CD, ' ' PCK_QTY" ).append("\n"); 
		query.append("--, ' ' CNTR_WGT, ' ' WGT_UT_CD, ' ' PRT_LODG_FLG, ' ' PRT_LODG_SEQ, ' ' KR_XPT_PCK_ID" ).append("\n"); 
		query.append("--, ' ' DIVD_PCK_QTY, ' ' DIVD_PCK_UT_CD" ).append("\n"); 
		query.append("--, ' ' CNTR_NO, ' ' PRE_CNTR_NO, ' ' CNTR_TPSZ_CD, ' ' CNTR_SEAL_NO  -- KorCusmodVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SUB_NO, ' ' OFC_CD, ' ' USER_NAME, ' ' KR_CSTMS_CORR_ID, ' ' CORR_RSN, ' ' MSN_NO, ' ' BL_NO" ).append("\n"); 
		query.append("--, ' ' KR_CSTMS_BL_TP_CD, ' ' FRT_FWRD_CD, ' ' BKG_CGO_TP_CD, ' ' POL_CD, ' ' POD_CD" ).append("\n"); 
		query.append("--, ' ' BD_AREA_CD, ' ' KR_CSTMS_WH_TP_CD, ' ' KR_WH_CD, ' ' PCK_QTY, ' ' PCK_TP_CD" ).append("\n"); 
		query.append("--, ' ' CGO_DESC1, ' ' CGO_DESC2, ' ' IMDG_CLSS_CD, ' ' N2ND_IMDG_CLSS_CD, ' ' N3RD_IMDG_CLSS_CD" ).append("\n"); 
		query.append("--, ' ' CNTR_TTL_WGT, ' ' MEAS_QTY, ' ' S_CUST_NM, ' ' S_CUST_ADDR, ' ' C_CUST_NM, ' ' C_CUST_ADDR" ).append("\n"); 
		query.append("--, ' ' N_CUST_NM, ' ' N_CUST_ADDR, ' ' BIZ_NO" ).append("\n"); 
		query.append("--, ' ' CNTR_NO, ' ' CNTR_TPSZ_CD, ' ' KR_CSTMS_CORR_ID, ' ' KR_CSTMS_CORR_ID2, ' ' PRE_DAT_CTNT" ).append("\n"); 
		query.append("--, ' ' NEW_DAT_CTNT, ' ' PCK_QTY, ' ' PCK_TP_CD, ' ' CNTR_SEAL_NO, ' ' CNTR_SEAL_NO1, ' ' CNTR_SEAL_NO2" ).append("\n"); 
		query.append("--, ' ' CRNT_CTNT1, ' ' CRNT_CTNT2, ' ' PRE_CTNT1, ' ' PRE_CTNT2" ).append("\n"); 
		query.append("--, ' ' CORR_RSN, ' ' CSTMS_DECL_TP_CD  -- KorImfmodVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' OFC_CD" ).append("\n"); 
		query.append("-- private KorDgCgoVvdVO korDgCgoVvdVO -- KorManifestDGNTransmitVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' EDI_SND_MSG, ' ' MAX_VVD_SEQ, ' ' VVD, ' ' MRN_NO, ' ' TRANS_CODE" ).append("\n"); 
		query.append("--, ' ' OFC_CD, ' ' SND_DT -- KorDgCgoVvdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' USER_ID, ' ' EDI_SND_MSG, ' ' MAX_VVD_SEQ, ' ' VVD, ' ' MRN_NO, ' ' OFC_CD, ' ' SND_DT" ).append("\n"); 
		query.append("--, ' ' POL_CD, ' ' POD_CD, ' ' IO_BND_CD, ' ' PORT_CD -- KorDgmVvdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' IO_BND_CD, ' ' IB_SEQ, ' ' VVD, ' ' CNTR_SEQ, ' ' CNTR_NO, ' ' CERTI_SEQ_NO, ' ' CERTI_NO, ' ' IMDG_UN_NO, ' ' IMDG_CLSS_CD" ).append("\n"); 
		query.append("--, ' ' POL_CD, ' ' POD_CD, ' ' PORT_CD, ' ' BL_NO, ' ' SND_DT, ' ' OFC_CD, ' ' USER_ID" ).append("\n"); 
		query.append("--, ' ' EDI_SND_MSG, ' ' FLT_FILE_REF_NO -- KorDgmCntrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' USER_ID, ' ' MRN_NO, ' ' MRN_CHK_NO, ' ' VSL_CD, ' ' SKD_VOY_NO,  ' ' SKD_DIR_CD, ' ' PORT_CD -- KorManifestMFTTransmitVO" ).append("\n"); 
		query.append("-- ' ' SND_DT, ' ' RSLT_ACK_DT, ' ' TRSM_MSG_TP_ID, ' ' ERR_MSG, ' ' MRN_NO -- HjtRcvMsg" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MRN_NO, ' ' BL_TP_CD, ' ' SHIP_NM, ' ' ETA_DT, ' ' PORT_CD, ' ' MSN_NO, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' P1, ' ' C1, ' ' SND_DT, ' ' VVD, ' ' POL_CD, ' ' POD_CD, ' ' YARD_CD, ' ' IO_BND_CD," ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' IN_TYPE -- KorAmdFormVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MSG_LOG_TP_CD, ' ' RCV_DT, ' ' RCV_SEQ, ' ' FLT_FILE_REF_NO, ' ' SMT_AMD_NO," ).append("\n"); 
		query.append("--' ' KR_CSTMS_ACPT_CD,  ' ' BL_NO, ' ' USER_ID -- KorAckMsgVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' MSG_LOG_TP_CD, ' ' RCV_DT, ' ' RCV_SEQ, ' ' FLT_FILE_REF_NO, ' ' LOG_DTL_SEQ," ).append("\n"); 
		query.append("--' ' EDI_RCV_MSG, ' ' KR_CSTMS_RJCT_RSN1, ' ' KR_CSTMS_RJCT_RSN2, ' ' USER_ID -- KorAckMsgDtlVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' CNTR_NO, ' ' POD_CD, ' ' VVD, ' ' POL_CD, ' ' IN_TYPE, ' ' POD_TML, ' ' PORT_CD, ' ' IO_BND_CD," ).append("\n"); 
		query.append("-- ' ' CSTMS_DECL_TP_CD, ' ' TRNS_SEQ -- BkgCstmsKrCntrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' CNTR_NO, ' ' BKG_CGO_TP_CD -- KorCntrNoKorVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' IB_TS_SEQ, ' ' IB_TS_CBLNO, ' ' IB_TS_PORT, ' ' IB_TS_BKGNO, ' ' IB_TS_TYPE, ' ' IB_TS_VVD," ).append("\n"); 
		query.append("--' ' CORR_CD, ' ' CORR_REASON, ' ' USR_ID, ' ' SUB_NO, ' ' BL_NO, ' ' RECEIVER, ' ' OFC_CD -- KorEmpAmdManiTransVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SND_DT, ' ' OFC_CD, ' ' FLT_FILE_REF_NO, ' ' USR_ID, ' ' VVD_CD, ' ' POL_CD, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' SUB_NO, ' ' SND_SEQ -- KorAutoImfSndVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SND_DT, ' ' OFC_CD, ' ' FLT_FILE_REF_NO, ' ' USR_ID, ' ' VVD_CD, ' ' POL_CD, ' ' BL_NO," ).append("\n"); 
		query.append("--' ' SUB_NO, ' ' SND_SEQ, ' ' EDI_SND_MSG -- KorAutoImfSndDtlVO, KorAutoMacSndVO, KorAutoMacSndDtlVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' ELNO_B, ' ' BKG_CGO_TP_CD, ' ' ELNO_A, ' ' CUST_NM, ' ' BL_SEQ_NO, ' ' TR, ' ' C_ADDR, ' ' CNTR_CHK_WGT," ).append("\n"); 
		query.append("--' ' BL_NO, ' ' ERROR_CHECK, ' ' KR_BL_AMDT_STS_CD, ' ' POL_CD, ' ' CSTMS_DECL_TP_CD, ' ' CMDT_CD, ' ' MF_SND_DT," ).append("\n"); 
		query.append("--' ' CGO_DESC1, ' ' KR_CSTMS_BL_TP_CD, ' ' WGT_UT_CD, ' ' MEAS_QTY, ' ' PCK_QTY, ' ' PORT_CD, ' ' PCK_TP_CD," ).append("\n"); 
		query.append("--' ' KR_CSTMS_BND_CD, ' ' WH, ' ' S_NM, ' ' N_ADDR, ' ' TRNS_SEQ, ' ' CNTR_CNT, ' ' IO_BND_CD, ' ' BD_AREA_CD," ).append("\n"); 
		query.append("--' ' S_ADDR, ' ' VVD, ' ' POD_CD, ' ' BL_MEAS_UT_CD, ' ' BKG_NO, ' ' YARD_CD, ' ' BIZ_RGST_NO, ' ' N_NM," ).append("\n"); 
		query.append("--' ' C_NM, ' ' MST_BL_SEQ_NO, ' ' CNTR_TTL_WGT, ' ' C_BL_NO, ' ' IB_BKG_NO, ' ' IB_C_BL_NO, ' ' IB_SEQ," ).append("\n"); 
		query.append("--' ' IB_TYPE, ' ' IB_PORT, ' ' IB_VVD, ' ' DWELL_DT, ' ' IB_ETA, ' ' BAC_NM     -- KorAmdBlInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' SMT_AMD_NO, ' ' CSTMS_DECL_TP_CD, ' ' PORT_CD, ' ' BL_NO, ' ' C_BL_NO -- KorAmdNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD1, ' ' PORT_CD, ' ' MRN_NO, ' ' MRN_CHK_NO, ' ' IO_BND_CD, ' ' USER_ID -- KorIftsaiSndCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("' ' BL_NO, ' ' VVD, ' ' KT_PA, ' ' POL_CD, ' ' POD_CD, ' ' IO_BND_CD," ).append("\n"); 
		query.append("' ' TTL_MEAS_QTY, ' ' TTL_MEAS_UT_CD, ' ' TTL_WGT, ' ' TTL_PCK_UT_CD," ).append("\n"); 
		query.append("' ' BD_AREA_CD, ' ' IO_TML_LOC_CD, ' ' DCHG_MZD_CD, ' ' VSL_NM, ' ' VSL_CNT_CD," ).append("\n"); 
		query.append("' ' MRN_NO, ' ' VSL_CALL_SGN_CD, ' ' CALL_KNT, ' ' CALL_YEAR, ' ' USER_ID, ' ' OFC_CD," ).append("\n"); 
		query.append("' ' PORT_CD, ' ' BKG_NO, ' ' CSTMS_DECL_TP_CD, ' ' IN_TYPE   -- KorCancelManifestTransmitVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}