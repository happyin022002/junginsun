/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterSIInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.23 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterSIInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterSIInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterSIInterfaceRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(M.ESTM_WGT,0),0, BL.ACT_WGT, M.ESTM_WGT) ACT_WGT," ).append("\n"); 
		query.append("       B.ADV_SHTG_CD," ).append("\n"); 
		query.append("       B.ALOC_STS_CD," ).append("\n"); 
		query.append("       B.AWK_CGO_FLG AWK_CGO_FLG," ).append("\n"); 
		query.append("       B.AWK_CGO_FLG AWK_CGO_FLG_OLD," ).append("\n"); 
		query.append("       B.BB_CGO_FLG BB_CGO_FLG," ).append("\n"); 
		query.append("       B.BB_CGO_FLG BB_CGO_FLG_OLD," ).append("\n"); 
		query.append("       NVL(BL.BDR_FLG, 'N') BDR_FLG," ).append("\n"); 
		query.append("       B.BKG_ALOC_TP_CD,  " ).append("\n"); 
		query.append("       NVL(B.BKG_CGO_TP_CD,'F') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       BC.CNTC_PSON_EML BKG_CNTC_PSON_EML," ).append("\n"); 
		query.append("       BC.CNTC_PSON_FAX_NO BKG_CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("       BC.CNTC_PSON_MPHN_NO BKG_CNTC_PSON_MPHN_NO," ).append("\n"); 
		query.append("       BC.CNTC_PSON_NM BKG_CNTC_PSON_NM," ).append("\n"); 
		query.append("       BC.CNTC_PSON_PHN_NO BKG_CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("       NVL(M.SI_CNTC_EML, SC.CNTC_PSON_EML) SI_CNTC_PSON_EML," ).append("\n"); 
		query.append("       NVL(M.SI_CNTC_FAX_AREA_NO||M.SI_CNTC_FAX_NO, SC.CNTC_PSON_FAX_NO) SI_CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("       NVL(M.SI_CNTC_MPHN_NO, SC.CNTC_PSON_MPHN_NO) SI_CNTC_PSON_MPHN_NO," ).append("\n"); 
		query.append("       NVL(M.SI_CNTC_NM, SC.CNTC_PSON_NM) SI_CNTC_PSON_NM," ).append("\n"); 
		query.append("       NVL(M.SI_CNTC_PHN_AREA_NO||M.SI_CNTC_PHN_NO||M.SI_CNTC_XTN_PHN_NO, SC.CNTC_PSON_PHN_NO) SI_CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("       B.DEL_CD BKG_DEL_CD," ).append("\n"); 
		query.append("       SUBSTR(B.DEL_NOD_CD, 6, 2) BKG_DEL_YD_CD," ).append("\n"); 
		query.append("       M.BKG_NO," ).append("\n"); 
		query.append("       B.BKG_OFC_CD BKG_OFC_CD," ).append("\n"); 
		query.append("       B.POD_CD BKG_POD_CD," ).append("\n"); 
		query.append("       SUBSTR(B.POD_NOD_CD, 6, 2) BKG_POD_YD_CD," ).append("\n"); 
		query.append("       B.POL_CD BKG_POL_CD,       " ).append("\n"); 
		query.append("       SUBSTR(B.POL_NOD_CD, 6, 2) BKG_POL_YD_CD," ).append("\n"); 
		query.append("       B.POR_CD BKG_POR_CD," ).append("\n"); 
		query.append("       SUBSTR(B.POR_NOD_CD, 6, 2) BKG_POR_YD_CD," ).append("\n"); 
		query.append("       B.BKG_STS_CD," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD BKG_TRUNK_VVD," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD BKG_TRUNK_VVD_OLD," ).append("\n"); 
		query.append("       B.BLCK_STWG_CD," ).append("\n"); 
		query.append("       B.BL_NO||NVL(B.BL_TP_CD, DECODE(I.OBL_SRND_FLG, 'Y', 'S', null)) BL_NO," ).append("\n"); 
		query.append("       BL.CORR_USR_ID CA_USER," ).append("\n"); 
		query.append("       B.CMDT_CD CMDT_CD," ).append("\n"); 
		query.append("       B.CMDT_CD CMDT_CD_OLD," ).append("\n"); 
		query.append("       (SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD =B.CMDT_CD) CMDT_DESC," ).append("\n"); 
		query.append("       B.CND_CSTMS_FILE_CD CND_CSTMS_FILE_CD," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' FROM BKG_XTER_CNTR CNTR WHERE CNTR.XTER_SNDR_ID = M.XTER_SNDR_ID AND CNTR.XTER_RQST_NO = M.XTER_RQST_NO AND ROWNUM = 1)," ).append("\n"); 
		query.append("            NVL((SELECT 'Y' FROM BKG_CONTAINER CNTR WHERE CNTR.BKG_NO = M.BKG_NO AND ROWNUM = 1), 'N')) CNTR_FLG," ).append("\n"); 
		query.append("       B.CRR_SOC_FLG," ).append("\n"); 
		query.append("       B.CTRT_OFC_CD CTRT_OFC_CD," ).append("\n"); 
		query.append("       B.CTRT_SREP_CD CTRT_SREP_CD," ).append("\n"); 
		query.append("       B.DCGO_FLG DCGO_FLG," ).append("\n"); 
		query.append("       B.DCGO_FLG DCGO_FLG_OLD," ).append("\n"); 
		query.append("       TO_CHAR(B.DE_DUE_DT, 'YYYY-MM-DD') DE_DUE_DT," ).append("\n"); 
		query.append("       TO_CHAR(B.DE_DUE_DT, 'YYYY-MM-DD') DE_DUE_DT_OLD," ).append("\n"); 
		query.append("       B.DEL_CD DEL_CD_OLD," ).append("\n"); 
		query.append("       NVL(M.DEL_NM, BL.DEL_NM) DEL_NM," ).append("\n"); 
		query.append("       SUBSTR(B.DEL_NOD_CD, 6, 2) DEL_YD_CD_OLD," ).append("\n"); 
		query.append("       B.DEST_SCONTI_CD," ).append("\n"); 
		query.append("       B.DEST_TRNS_MOD_CD," ).append("\n"); 
		query.append("       B.DEST_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD DE_TERM_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD DE_TERM_CD_OLD," ).append("\n"); 
		query.append("       DECODE(B.AWK_CGO_FLG, 'Y', 'Y', NULL) AWK_FLG," ).append("\n"); 
		query.append("       DECODE(B.BB_CGO_FLG, 'Y', 'Y', NULL) BB_FLG," ).append("\n"); 
		query.append("       DECODE(B.DCGO_FLG, 'Y', 'Y', NULL) DG_FLG," ).append("\n"); 
		query.append("       B.DOC_USR_ID," ).append("\n"); 
		query.append("       NVL(B.EDI_HLD_FLG, 'N') EDI_HLD_FLG," ).append("\n"); 
		query.append("       CASE WHEN (SELECT SUM(EQ_SUBST_CGO_QTY)" ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                  WHERE Q.BKG_NO = M.BKG_NO) > 0 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END EQ_SUBST_FLG," ).append("\n"); 
		query.append("       B.FD_GRD_FLG," ).append("\n"); 
		query.append("       B.FLEX_HGT_FLG AS FLEX_HGT_FLG," ).append("\n"); 
		query.append("       (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("        FROM BKG_REFERENCE R" ).append("\n"); 
		query.append("        WHERE R.BKG_REF_TP_CD 	= 'FMCN'" ).append("\n"); 
		query.append("        AND R.BKG_NO 			= B.BKG_NO" ).append("\n"); 
		query.append("        AND ROWNUM = 1) FMC_NO," ).append("\n"); 
		query.append("       NVL(M.FNL_DEST_NM, BL.FNL_DEST_NM) FNL_DEST_NM," ).append("\n"); 
		query.append("       B.FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("       B.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("       B.FULL_RTN_YD_CD	FULL_RTN_YD_CD_OLD," ).append("\n"); 
		query.append("       B.FUMG_CNTC_PHN_NO," ).append("\n"); 
		query.append("       B.FUMG_CNTC_PSON_NM," ).append("\n"); 
		query.append("       B.FUMG_DIFF_RMK," ).append("\n"); 
		query.append("       DECODE(NVL(B.FUMG_LOC_CD, 'NULL'), 'NULL', 'N', 'Y') FUMG_FLG," ).append("\n"); 
		query.append("       B.FUMG_LOC_CD," ).append("\n"); 
		query.append("       B.HNGR_FLG," ).append("\n"); 
		query.append("       NVL(B.INDIV_PSON_FLG, 'N') INDIV_PSON_FLG," ).append("\n"); 
		query.append("       B.INTER_RMK," ).append("\n"); 
		query.append("       CASE WHEN 0 < (SELECT COUNT(CHG_CD) FROM BKG_CHG_RT WHERE BKG_NO = M.BKG_NO) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END IS_RATED_FLG," ).append("\n"); 
		query.append("       NVL(M.KR_CSTMS_CUST_TP_CD,B.KR_CSTMS_CUST_TP_CD) KR_CSTMS_CUST_TP_CD," ).append("\n"); 
		query.append("       TO_CHAR(LODG_DUE_DT, 'YYYY-MM-DD') LODG_DUE_DT," ).append("\n"); 
		query.append("       TO_CHAR(LODG_DUE_DT, 'YYYY-MM-DD') LODG_DUE_DT_OLD," ).append("\n"); 
		query.append("       NVL(B.MNL_BKG_NO_FLG, 'N') MNL_BKG_NO_FLG," ).append("\n"); 
		query.append("       TO_CHAR( B.MTY_DOR_ARR_DT, 'YYYY-MM-DD') MTY_DOR_ARR_DT," ).append("\n"); 
		query.append("       TO_CHAR(B.MTY_DOR_ARR_DT, 'YYYY-MM-DD') MTY_DOR_ARR_DT_OLD," ).append("\n"); 
		query.append("       TO_CHAR(B.MTY_PKUP_DT, 'YYYY-MM-DD') MTY_PKUP_DT," ).append("\n"); 
		query.append("       B.MTY_PKUP_DT MTY_PKUP_DT_OLD," ).append("\n"); 
		query.append("       B.MTY_PKUP_YD_CD MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("       B.MTY_PKUP_YD_CD MTY_PKUP_YD_CD_OLD," ).append("\n"); 
		query.append("       B.OB_SREP_CD ," ).append("\n"); 
		query.append("       B.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("       B.BKG_NO OLD_BKG_NO," ).append("\n"); 
		query.append("       B.ORG_SCONTI_CD," ).append("\n"); 
		query.append("       B.ORG_TRNS_MOD_CD," ).append("\n"); 
		query.append("       B.ORG_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("       NVL((SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BK1, BKG_CONTAINER CNTR1," ).append("\n"); 
		query.append("                 BKG_BOOKING BK2, BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("            WHERE BK1.BKG_NO        = CNTR1.BKG_NO " ).append("\n"); 
		query.append("            AND BK2.BKG_NO        = CNTR2.BKG_NO" ).append("\n"); 
		query.append("            AND BK1.BKG_NO        <> BK2.BKG_NO   --다른 BKG" ).append("\n"); 
		query.append("            AND CNTR1.CNTR_NO     = CNTR2.CNTR_NO --같은 CNTR" ).append("\n"); 
		query.append("            AND BK1.BKG_CGO_TP_CD = BK2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("            AND BK1.POL_CD        = BK2.POL_CD" ).append("\n"); 
		query.append("            AND BK1.POD_CD        = BK2.POD_CD" ).append("\n"); 
		query.append("            AND BK1.VSL_CD        = BK2.VSL_CD" ).append("\n"); 
		query.append("            AND BK1.SKD_VOY_NO    = BK2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND BK1.SKD_DIR_CD    = BK2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND CNTR1.CNTR_PRT_FLG= 'Y'" ).append("\n"); 
		query.append("            AND CNTR2.CNTR_PRT_FLG= 'Y'" ).append("\n"); 
		query.append("            AND BK1.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("            AND BK2.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("            AND BK1.BKG_NO        = M.BKG_NO" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') PARTIAL_VVD_ASSIGN_FLG," ).append("\n"); 
		query.append("       B.PCTL_NO," ).append("\n"); 
		query.append("       B.PCTL_NO PCTL_NO_OLD," ).append("\n"); 
		query.append("       B.POD_CD POD_CD_OLD," ).append("\n"); 
		query.append("       NVL(M.POD_NM, BL.POD_NM) POD_NM," ).append("\n"); 
		query.append("       SUBSTR(B.POD_NOD_CD, 6, 2) POD_YD_CD_OLD," ).append("\n"); 
		query.append("       B.POL_CD	POL_CD_OLD," ).append("\n"); 
		query.append("       NVL(M.POL_NM, BL.POL_NM) POL_NM," ).append("\n"); 
		query.append("       SUBSTR(B.POL_NOD_CD, 6, 2) POL_YD_CD_OLD," ).append("\n"); 
		query.append("       B.POR_CD POR_CD_OLD," ).append("\n"); 
		query.append("       NVL(M.POR_NM, BL.POR_NM) POR_NM," ).append("\n"); 
		query.append("       B.PORT_SKP_FLG," ).append("\n"); 
		query.append("       SUBSTR(B.POR_NOD_CD, 6, 2) POR_YD_CD_OLD," ).append("\n"); 
		query.append("       B.PRCT_FLG," ).append("\n"); 
		query.append("       B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       SUBSTR(PRE.POD_YD_CD, 6, 2) PRE_RLY_PORT_YD_CD," ).append("\n"); 
		query.append("       PRE.VSL_CD||PRE.SKD_VOY_NO||PRE.SKD_DIR_CD PRE_VVD_CD," ).append("\n"); 
		query.append("       B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("       SUBSTR(PST.POL_YD_CD, 6, 2) PST_RLY_PORT_YD_CD," ).append("\n"); 
		query.append("       PST.VSL_CD||PST.SKD_VOY_NO||PST.SKD_DIR_CD PST_VVD_CD," ).append("\n"); 
		query.append("       B.RAIL_BLK_CD," ).append("\n"); 
		query.append("       B.RC_FLG RC_FLG," ).append("\n"); 
		query.append("       B.RC_FLG RC_FLG_OLD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD RCV_TERM_CD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD RCV_TERM_CD_OLD," ).append("\n"); 
		query.append("       NVL(B.RD_CGO_FLG, 'N') RD_CGO_FLG," ).append("\n"); 
		query.append("       B.REP_CMDT_CD REP_CMDT_CD," ).append("\n"); 
		query.append("       B.RFA_NO RFA_NO," ).append("\n"); 
		query.append("       B.RFA_NO RFA_NO_OLD," ).append("\n"); 
		query.append("       DECODE(B.RC_FLG, 'Y', 'Y', NULL) RF_FLG," ).append("\n"); 
		query.append("       (SELECT COUNT(1) FROM BKG_ROLL_OVR ROL WHERE ROL.BKG_NO = M.BKG_NO) ROLL_OVR_CNT," ).append("\n"); 
		query.append("       B.SCAC_CD SCAC_CD," ).append("\n"); 
		query.append("       B.SC_NO SC_NO," ).append("\n"); 
		query.append("       B.SC_NO SC_NO_OLD," ).append("\n"); 
		query.append("       NVL(S.CNT_CD, SH.CUST_CNT_CD) S_CUST_CNT_CD," ).append("\n"); 
		query.append("       NVL(S.CUST_SEQ, SH.CUST_SEQ) S_CUST_SEQ," ).append("\n"); 
		query.append("       DECODE(M.DOC_TP_CD, 'S', 'Y', 'U','Y','N') SI_FLG," ).append("\n"); 
		query.append("       B.SLAN_CD," ).append("\n"); 
		query.append("       B.SOC_FLG SOC_FLG," ).append("\n"); 
		query.append("       B.SPCL_HIDE_FLG," ).append("\n"); 
		query.append("       B.SPCL_HIDE_LNR_FLG," ).append("\n"); 
		query.append("       B.STOP_OFF_CNTC_PHN_NO," ).append("\n"); 
		query.append("       B.STOP_OFF_CNTC_PSON_NM," ).append("\n"); 
		query.append("       B.STOP_OFF_DIFF_RMK," ).append("\n"); 
		query.append("       B.STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("       DECODE(NVL(B.STOP_OFF_LOC_CD, 'NULL'), 'NULL', 'N', 'Y') STOP_OFF_FLG," ).append("\n"); 
		query.append("       B.STWG_CD," ).append("\n"); 
		query.append("       DECODE(NVL(B.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') STWG_FLG," ).append("\n"); 
		query.append("       B.STWG_RMK," ).append("\n"); 
		query.append("       B.SVC_SCP_CD," ).append("\n"); 
		query.append("       B.TAA_NO TAA_NO," ).append("\n"); 
		query.append("       B.TAA_NO TAA_NO_OLD," ).append("\n"); 
		query.append("       B.TWN_SO_NO TWN_SO_NO," ).append("\n"); 
		query.append("       B.USA_CSTMS_FILE_CD USA_CSTMS_FILE_CD," ).append("\n"); 
		query.append("       USR.USR_EML, " ).append("\n"); 
		query.append("       USR.USR_NM," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(*),0,'N','Y')" ).append("\n"); 
		query.append("        FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("        WHERE HRD_CDG_ID = 'VEH_CMDT_FLG'" ).append("\n"); 
		query.append("        AND ATTR_CTNT1 = B.CMDT_CD) VEH_CMDT_FLG," ).append("\n"); 
		query.append("       DECODE(M.DOC_TP_CD, 'B', M.XTER_RQST_VIA_CD, B.XTER_BKG_RQST_CD) XTER_BKG_RQST_CD," ).append("\n"); 
		query.append("       DECODE(M.DOC_TP_CD, 'B', M.XTER_RQST_NO, B.XTER_BKG_RQST_REF_NO) XTER_BKG_RQST_REF_NO," ).append("\n"); 
		query.append("       NVL(B.XTER_RMK||CHR(13)||CHR(10)||(CASE WHEN INSTR(M.XTER_BKG_RMK1||M.XTER_BKG_RMK2, CHR(13)||CHR(10)) = 0 " ).append("\n"); 
		query.append("                      AND INSTR(M.XTER_BKG_RMK1||M.XTER_BKG_RMK2, CHR(10)) > 0" ).append("\n"); 
		query.append("                      THEN REPLACE(M.XTER_BKG_RMK1||M.XTER_BKG_RMK2, CHR(10), CHR(13)||CHR(10))" ).append("\n"); 
		query.append("                 ELSE M.XTER_BKG_RMK1||M.XTER_BKG_RMK2" ).append("\n"); 
		query.append("            END)," ).append("\n"); 
		query.append("            B.XTER_RMK) XTER_RMK," ).append("\n"); 
		query.append("       NVL(M.AUTO_EML_FLG, B.XTER_RQST_AUTO_NTC_FLG) XTER_RQST_AUTO_NTC_FLG," ).append("\n"); 
		query.append("       DECODE(M.DOC_TP_CD, 'S', M.XTER_RQST_VIA_CD, B.XTER_SI_CD) XTER_SI_CD," ).append("\n"); 
		query.append("       DECODE(M.DOC_TP_CD, 'S', M.XTER_RQST_NO, B.XTER_SI_REF_NO) XTER_SI_REF_NO," ).append("\n"); 
		query.append("       USR.XTN_PHN_NO" ).append("\n"); 
		query.append("	   /************************************/" ).append("\n"); 
		query.append("	   , DECODE(SUBSTR(M.ESTM_WGT_UT_CD,1,1),'K','KGS',M.ESTM_WGT_UT_CD) WGT_UT_CD" ).append("\n"); 
		query.append("	   , 'Y' WEB_SVC_FLG" ).append("\n"); 
		query.append("	   , B.NON_RT_STS_CD " ).append("\n"); 
		query.append("		, IDA_HLG_TP_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_XTER_CUST S, BKG_XTER_CUST E, BKG_BOOKING B, BKG_BL_DOC BL," ).append("\n"); 
		query.append("     BKG_CNTC_PSON BC, BKG_CNTC_PSON SC, BKG_BL_ISS I," ).append("\n"); 
		query.append("     BKG_VVD PRE, BKG_VVD PST, BKG_CUSTOMER SH, COM_USER USR     " ).append("\n"); 
		query.append("WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = S.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = S.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = S.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'S' = S.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = E.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = E.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = E.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'E' = E.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO =BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append("AND B.BKG_NO =SC.BKG_NO(+)" ).append("\n"); 
		query.append("AND SC.BKG_CNTC_PSON_TP_CD(+) = 'SI'" ).append("\n"); 
		query.append("AND B.BKG_NO = I.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = PRE.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = PRE.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND B.PRE_RLY_PORT_CD= PRE.POD_CD(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = PST.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.PST_RLY_PORT_CD= PST.POL_CD(+)" ).append("\n"); 
		query.append("AND 'U' = PST.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = SH.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND UPPER(B.DOC_USR_ID) = UPPER(USR.USR_ID(+))" ).append("\n"); 

	}
}