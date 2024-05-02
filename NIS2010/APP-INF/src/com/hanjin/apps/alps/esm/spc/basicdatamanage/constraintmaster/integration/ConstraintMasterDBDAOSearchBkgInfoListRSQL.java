/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSearchBkgInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.11.03 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSearchBkgInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConstraintMaster 테이블에 Import할 대상 BKG의 정보를 조회한다
	  * 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정
	  * </pre>
	  */
	public ConstraintMasterDBDAOSearchBkgInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSearchBkgInfoListRSQL").append("\n"); 
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
		query.append("B.BKG_NO, B.BL_NO" ).append("\n"); 
		query.append("     , (SELECT L.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("        FROM SPC_OFC_LVL L" ).append("\n"); 
		query.append("        WHERE L.OFC_CD = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        AND (SELECT DISTINCT SUBSTR(SLS_YRMON, 0, 4)||COST_WK" ).append("\n"); 
		query.append("              FROM MAS_BKG_EXPN_DTL D" ).append("\n"); 
		query.append("             WHERE D.BKG_NO = B.BKG_NO) BETWEEN L.OFC_APLY_FM_YRWK AND L.OFC_APLY_TO_YRWK) SLS_RHQ_CD" ).append("\n"); 
		query.append("     , '' AS 	bkg_aloc_tp_cd  " ).append("\n"); 
		query.append("     , NULL AS 	sub_trd_yn  " ).append("\n"); 
		query.append("     , NULL AS 	sub_trd_cd" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , NULL AS 	trnk_slan_yn  " ).append("\n"); 
		query.append("     , V.SLAN_CD trnk_slan_cd    " ).append("\n"); 
		query.append("     , NULL AS 	trnk_dir_yn  " ).append("\n"); 
		query.append("     , V.SKD_DIR_CD	trnk_dir_cd      " ).append("\n"); 
		query.append("     , NULL AS 	trnk_pol_yn  " ).append("\n"); 
		query.append("     , V.POL_CD	trunk_pol_cd     " ).append("\n"); 
		query.append("     , NULL AS 	trnk_pod_yn  " ).append("\n"); 
		query.append("     , V.POD_CD	trunk_pod_cd     " ).append("\n"); 
		query.append(", NULL AS 	bkg_por_cnt_yn  " ).append("\n"); 
		query.append(", SUBSTR(B.POR_CD, 0, 2)	bkg_por_cnt_cd    " ).append("\n"); 
		query.append(", NULL AS 	por_yn  " ).append("\n"); 
		query.append(", B.POR_CD" ).append("\n"); 
		query.append(", BL.POR_NM" ).append("\n"); 
		query.append(", NULL AS 	por_nod_yn  " ).append("\n"); 
		query.append(", B.POR_NOD_CD por_nod_cd      " ).append("\n"); 
		query.append(", NULL AS 	bkg_por_scc_yn  " ).append("\n"); 
		query.append(", (select sv.SCC_CD from MAS_LOCATION_V sv where sv.loc_cd = B.POR_CD)	bkg_por_scc_cd " ).append("\n"); 
		query.append(", NULL AS 	bkg_pol_cnt_yn  " ).append("\n"); 
		query.append(", SUBSTR(B.POL_CD, 0, 2)	bkg_pol_cnt_cd    " ).append("\n"); 
		query.append(", NULL AS 	pol_yn  " ).append("\n"); 
		query.append(", B.POL_CD      " ).append("\n"); 
		query.append(", BL.POL_NM" ).append("\n"); 
		query.append(", NULL AS 	pol_nod_yn  " ).append("\n"); 
		query.append(", B.POL_NOD_CD pol_nod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_slan_yn  " ).append("\n"); 
		query.append(", V2.SLAN_CD	n1st_ts_slan_cd   " ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_dir_yn  " ).append("\n"); 
		query.append(", V2.SKD_DIR_CD	n1st_ts_dir_cd    " ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_pol_cnt_yn" ).append("\n"); 
		query.append(", SUBSTR(V2.POL_CD, 0, 2)	n1st_ts_pol_cnt_cd" ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_pol_yn  " ).append("\n"); 
		query.append(", V2.POL_CD	n1st_ts_pol_cd    " ).append("\n"); 
		query.append(", NULL AS 	ts_pol_nod_yn " ).append("\n"); 
		query.append(", V2.POL_YD_CD	ts_pol_nod_cd    " ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_pod_cnt_yn" ).append("\n"); 
		query.append(", SUBSTR(V2.POD_CD, 0, 2)	n1st_ts_pod_cnt_cd" ).append("\n"); 
		query.append(", NULL AS 	n1st_ts_pod_yn  " ).append("\n"); 
		query.append(", V2.POD_CD	n1st_ts_pod_cd  " ).append("\n"); 
		query.append(", NULL AS 	ts_pod_nod_yn " ).append("\n"); 
		query.append(", V2.POD_YD_CD	ts_pod_nod_cd     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	bkg_pod_cnt_yn  " ).append("\n"); 
		query.append(", SUBSTR(B.POD_CD, 0, 2)	bkg_pod_cnt_cd    " ).append("\n"); 
		query.append(", NULL AS 	pod_cd_yn  " ).append("\n"); 
		query.append(", B.POD_CD	pod_cd  " ).append("\n"); 
		query.append(", BL.POD_NM" ).append("\n"); 
		query.append(", NULL AS 	pod_nod_yn  " ).append("\n"); 
		query.append(", B.POD_NOD_CD pod_nod_cd      " ).append("\n"); 
		query.append(", NULL AS 	bkg_del_cnt_yn  " ).append("\n"); 
		query.append(", SUBSTR(B.DEL_CD, 0, 2)		bkg_del_cnt_cd    " ).append("\n"); 
		query.append(", NULL AS 	del_yn  " ).append("\n"); 
		query.append(", B.DEL_CD	del_cd  " ).append("\n"); 
		query.append(", BL.DEL_NM" ).append("\n"); 
		query.append(", NULL AS 	del_nod_yn  " ).append("\n"); 
		query.append(", B.DEL_NOD_CD	del_nod_cd      " ).append("\n"); 
		query.append(", NULL AS 	bkg_del_scc_yn  " ).append("\n"); 
		query.append(", (select sv.SCC_CD from MAS_LOCATION_V sv where sv.loc_cd = B.DEL_CD)	bkg_del_scc_cd    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	vvd_yn  " ).append("\n"); 
		query.append(", V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD vvd      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	cntr_tpsz_yn  " ).append("\n"); 
		query.append(", Q.cntr_tpsz_cd      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	dg_rd_yn  " ).append("\n"); 
		query.append(", B.rd_cgo_flg rd_flg" ).append("\n"); 
		query.append(", B.dcgo_flg dg_flg   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	ob_sls_ofc_yn  " ).append("\n"); 
		query.append(", B.OB_SLS_OFC_CD ob_sls_ofc_cd     " ).append("\n"); 
		query.append(", (select o.OFC_ENG_NM from mdm_organization o where o.ofc_cd = B.OB_SLS_OFC_CD) ob_sls_ofc_nm  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	sc_yn  " ).append("\n"); 
		query.append(", B.SC_NO      " ).append("\n"); 
		query.append(", NULL AS 	rfa_yn  " ).append("\n"); 
		query.append(", B.RFA_NO      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	ctrt_yn  " ).append("\n"); 
		query.append(",	B.CTRT_CUST_CNT_CD  " ).append("\n"); 
		query.append(",	B.CTRT_CUST_SEQ  " ).append("\n"); 
		query.append(",	B.CTRT_CUST_CNT_CD||LPAD(B.CTRT_CUST_SEQ, 6, '0') ctrt_cust_code  " ).append("\n"); 
		query.append(",	CC2.CUST_LGL_ENG_NM ctrt_cust_lgl_eng_nm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	agmt_yn" ).append("\n"); 
		query.append(",	B.AGMT_ACT_CNT_CD  " ).append("\n"); 
		query.append(",	B.AGMT_ACT_CUST_SEQ " ).append("\n"); 
		query.append(",	B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ, 6, '0') agmt_act_cust_code" ).append("\n"); 
		query.append(",	AC2.CUST_LGL_ENG_NM agmt_cust_lgl_eng_nm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	shpr_yn" ).append("\n"); 
		query.append(",	S.CUST_CNT_CD shpr_cust_cnt_cd  " ).append("\n"); 
		query.append(",	S.CUST_SEQ shpr_cust_seq  " ).append("\n"); 
		query.append(",	S.CUST_CNT_CD||LPAD(S.CUST_SEQ, 6, '0') shpr_cust_code" ).append("\n"); 
		query.append(",	S2.CUST_LGL_ENG_NM shpr_cust_lgl_eng_nm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	oft_chg_yn  " ).append("\n"); 
		query.append("--OFT가 없는 경우 BKG ESTIMATED CMPB 테이블의 OFT값 가져오도록 수정" ).append("\n"); 
		query.append(", NVL(R.CHG_UT_AMT, (select MAX(RV.oft_amt) KEEP (DENSE_RANK LAST ORDER BY RV.REV_COST_SEQ) FROM BKG_REV_COST RV WHERE RV.BKG_NO = B.BKG_NO)) AS oft_chg_amt    							" ).append("\n"); 
		query.append(", NULL AS 	cmpb_yn  							" ).append("\n"); 
		query.append("--, NULL AS 	cmpb_rule_cd      							" ).append("\n"); 
		query.append(", (select MAX(RV.CMPB_AMT) KEEP (DENSE_RANK LAST ORDER BY RV.REV_COST_SEQ) AS CMPB FROM BKG_REV_COST RV WHERE RV.BKG_NO = B.BKG_NO) AS 	cmpb_amt  							 " ).append("\n"); 
		query.append(", NULL AS 	aloc_lod_yn  " ).append("\n"); 
		query.append(", NULL AS 	aloc_lod_qty      " ).append("\n"); 
		query.append(", NULL AS 	aloc_rto_yn  " ).append("\n"); 
		query.append(", NULL AS 	aloc_lod_qty_rto  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	ASGN_TTL_WGT_YN  " ).append("\n"); 
		query.append(", NULL AS 	ASGN_TTL_WGT      " ).append("\n"); 
		query.append(", NULL AS 	ASGN_WGT_RTO_YN  " ).append("\n"); 
		query.append(", NULL AS 	ASGN_WGT_RTO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NULL AS 	scg_grp_cmdt_yn  " ).append("\n"); 
		query.append(", MC.GRP_CMDT_CD	scg_grp_cmdt_seq  " ).append("\n"); 
		query.append(", (SELECT GP.SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_CMDT GP" ).append("\n"); 
		query.append("         WHERE GP.SVC_SCP_CD = 'TPW'" ).append("\n"); 
		query.append("           AND GP.CHG_CD = 'GRI'" ).append("\n"); 
		query.append("           AND GP.SCG_GRP_CMDT_CD = MC.GRP_CMDT_CD" ).append("\n"); 
		query.append("           AND GP.DELT_FLG = 'N') scg_grp_cmdt_desc " ).append("\n"); 
		query.append(", NULL AS 	cmdt_yn  " ).append("\n"); 
		query.append(", B.CMDT_CD  " ).append("\n"); 
		query.append(", MC.CMDT_NM    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'A' AS 	aloc_svc_cd      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'S' AS 	bkg_ctrl_tp_cd    " ).append("\n"); 
		query.append(", NULL AS 	bkg_aloc_rmk      " ).append("\n"); 
		query.append("--, NULL AS 	aloc_aply_fm_dt   " ).append("\n"); 
		query.append("--, NULL AS 	aloc_aply_to_dt" ).append("\n"); 
		query.append(", NULL AS 	aply_fm_yrwk   " ).append("\n"); 
		query.append(", NULL AS 	aply_to_yrwk" ).append("\n"); 
		query.append(", 'Y' AS 	aloc_use_flg      " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(", NULL AS 	upd_usr_id" ).append("\n"); 
		query.append(", NULL AS 	upd_dt" ).append("\n"); 
		query.append(", NULL AS 	bkg_aloc_seq" ).append("\n"); 
		query.append("---------------------- report form all column" ).append("\n"); 
		query.append(", B.RCV_TERM_CD ||'/'|| B.DE_TERM_CD AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append(", CASE WHEN F.CUST_CNT_CD IS NOT NULL THEN F.CUST_CNT_CD || LPAD(F.CUST_SEQ, 6, '0') || '(' || F2.CUST_LGL_ENG_NM || ')' ELSE NULL END AS FWDR_CUST_CNT_CD" ).append("\n"); 
		query.append(", CASE WHEN C.CUST_CNT_CD IS NOT NULL THEN C.CUST_CNT_CD || LPAD(C.CUST_SEQ, 6, '0') || '(' ||C2.CUST_LGL_ENG_NM || ')' ELSE NULL END AS CNEE_CUST_CNT_CD" ).append("\n"); 
		query.append(", B.TAA_NO" ).append("\n"); 
		query.append(", B.REP_CMDT_CD || '(' || MR.REP_CMDT_NM|| ')'  AS REP_CMDT_CD" ).append("\n"); 
		query.append(", DECODE(NVL(B.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') AS STWG_FLG" ).append("\n"); 
		query.append(", B.RC_FLG" ).append("\n"); 
		query.append(", B.HNGR_FLG" ).append("\n"); 
		query.append(", B.AWK_CGO_FLG" ).append("\n"); 
		query.append(", B.CTRT_OFC_CD|| '/' || CTRT_SREP_CD AS CTRT_OFC_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = B.ORG_TRNS_MOD_CD)" ).append("\n"); 
		query.append("	|| '/' || (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = B.DEST_TRNS_MOD_CD) AS ORG_DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append(", Q.OP_CNTR_QTY" ).append("\n"); 
		query.append(", DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY AS BKG_TEU_QTY --TEU(Load)" ).append("\n"); 
		query.append(", NULL AS 	us_yn " ).append("\n"); 
		query.append(", CASE WHEN (SUBSTR(B.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(B.DEL_CD, 1, 2) IN ('CA', 'US')) " ).append("\n"); 
		query.append("	   THEN SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POR_CD, B.POL_CD, B.POD_CD,B.DEL_CD) ELSE 'OTH' END usa_bkg_mod_cd " ).append("\n"); 
		query.append("---------------------- report form all column" ).append("\n"); 
		query.append("--     , B.SLAN_CD" ).append("\n"); 
		query.append("--     , NULL AS LANE_YN" ).append("\n"); 
		query.append("--     , B.SC_NO" ).append("\n"); 
		query.append("--     , B.TAA_NO" ).append("\n"); 
		query.append("--     , B.RFA_NO" ).append("\n"); 
		query.append("--     , B.CMDT_CD, MC.CMDT_NM " ).append("\n"); 
		query.append("--     , NULL AS CMDT_YN" ).append("\n"); 
		query.append("--     , B.REP_CMDT_CD, MR.REP_CMDT_NM " ).append("\n"); 
		query.append("--     " ).append("\n"); 
		query.append("--     , Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--     , NULL AS TPSZ_FLG --EQ" ).append("\n"); 
		query.append("--     , Q.OP_CNTR_QTY " ).append("\n"); 
		query.append("--     , DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY BKG_TEU_QTY --TEU(Load)" ).append("\n"); 
		query.append("--     , NULL AS QTY_YN     " ).append("\n"); 
		query.append("--     , B.CTRT_OFC_CD, CTRT_SREP_CD" ).append("\n"); 
		query.append("--     , B.OB_SLS_OFC_CD, OB_SREP_CD" ).append("\n"); 
		query.append("--     , NULL AS LOFC_YN" ).append("\n"); 
		query.append("--     , B.DCGO_FLG" ).append("\n"); 
		query.append("--     , DECODE(NVL(B.STWG_CD, 'NULL'), 'NULL', 'N', 'Y') STWG_FLG" ).append("\n"); 
		query.append("--     , B.RC_FLG" ).append("\n"); 
		query.append("--     , B.HNGR_FLG" ).append("\n"); 
		query.append("--     , B.AWK_CGO_FLG" ).append("\n"); 
		query.append("--     " ).append("\n"); 
		query.append("--     , (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = B.ORG_TRNS_MOD_CD) ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("--     , (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = B.DEST_TRNS_MOD_CD) DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--     , S.CUST_CNT_CD AS SHPR_CUST_CNT_CD, S.CUST_SEQ AS SHPR_CUST_SEQ, S2.CUST_LGL_ENG_NM AS SHPR_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("--     , NULL AS SHPR_YN" ).append("\n"); 
		query.append("--     , C.CUST_CNT_CD AS CNEE_CUST_CNT_CD, C.CUST_SEQ AS CNEE_CUST_SEQ, C2.CUST_LGL_ENG_NM AS CNEE_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("--     , NULL AS CNEE_YN" ).append("\n"); 
		query.append("--     , F.CUST_CNT_CD AS FWDR_CUST_CNT_CD, F.CUST_SEQ AS FWDR_CUST_SEQ, F2.CUST_LGL_ENG_NM AS CUST_SEQ_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("--     , NULL AS FWD_YN" ).append("\n"); 
		query.append("--     , B.CTRT_CUST_CNT_CD, B.CTRT_CUST_SEQ, CC2.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("--     , NULL AS CTRT_YN" ).append("\n"); 
		query.append("--     , B.AGMT_ACT_CNT_CD, B.AGMT_ACT_CUST_SEQ, AC2.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("--     , NULL AS AGMT_YN" ).append("\n"); 
		query.append("--     , R.CURR_CD,  R.RAT_UT_CD, R.CHG_UT_AMT" ).append("\n"); 
		query.append("--     , NULL AS CHG_YN" ).append("\n"); 
		query.append(",'' f_header" ).append("\n"); 
		query.append(",'' f_headernm" ).append("\n"); 
		query.append(",'' pgm" ).append("\n"); 
		query.append(",'' rpt_fom_nm" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("     , BKG_BL_DOC BL" ).append("\n"); 
		query.append("     , BKG_QUANTITY Q" ).append("\n"); 
		query.append("     , BKG_VVD V" ).append("\n"); 
		query.append("     , BKG_VVD V2 --TS" ).append("\n"); 
		query.append("     , BKG_CHG_RT R" ).append("\n"); 
		query.append("     , BKG_CUSTOMER S" ).append("\n"); 
		query.append("     , BKG_CUSTOMER C" ).append("\n"); 
		query.append("--     , BKG_CUSTOMER N" ).append("\n"); 
		query.append("     , BKG_CUSTOMER F" ).append("\n"); 
		query.append("     , MDM_CUSTOMER S2" ).append("\n"); 
		query.append("     , MDM_CUSTOMER C2" ).append("\n"); 
		query.append("----     , MDM_CUSTOMER N2" ).append("\n"); 
		query.append("     , MDM_CUSTOMER F2" ).append("\n"); 
		query.append("     , MDM_CUSTOMER CC2" ).append("\n"); 
		query.append("     , MDM_CUSTOMER AC2" ).append("\n"); 
		query.append("     , MDM_COMMODITY MC" ).append("\n"); 
		query.append("     , MDM_REP_CMDT MR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("--   AND B.BKG_NO = 'JKT410098106'" ).append("\n"); 
		query.append("   AND " ).append("\n"); 
		query.append("(	B.BKG_NO IN (" ).append("\n"); 
		query.append("#if($bkgList.size() != 0)" ).append("\n"); 
		query.append("	#foreach(${bkg} in ${bkgList})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkgList.size())" ).append("\n"); 
		query.append("	'${bkg}'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("	'${bkg}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("OR B.BL_NO IN (" ).append("\n"); 
		query.append("#if($bkgList.size() != 0)" ).append("\n"); 
		query.append("	#foreach(${bkg} in ${bkgList})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkgList.size())" ).append("\n"); 
		query.append("	'${bkg}'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("	'${bkg}'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("   AND B.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = V.BKG_NO(+)" ).append("\n"); 
		query.append("   AND V.VSL_PRE_PST_CD(+) = 'T'" ).append("\n"); 
		query.append("   AND B.BKG_NO = V.BKG_NO(+)" ).append("\n"); 
		query.append("   AND V2.VSL_PRE_PST_CD(+) <> 'T'" ).append("\n"); 
		query.append("   AND B.BKG_NO = V2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND Q.BKG_NO = R.BKG_NO(+)" ).append("\n"); 
		query.append("   AND R.CHG_CD(+) = 'OFT'" ).append("\n"); 
		query.append("   AND (CASE" ).append("\n"); 
		query.append("                         WHEN Q.CNTR_TPSZ_CD LIKE 'Q%' THEN 'BL'" ).append("\n"); 
		query.append("                         ELSE Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       END = R.RAT_UT_CD(+))" ).append("\n"); 
		query.append("   AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("   AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND S.CUST_CNT_CD = S2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND S.CUST_SEQ = S2.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND C.CUST_CNT_CD = C2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND C.CUST_SEQ = C2.CUST_SEQ(+)" ).append("\n"); 
		query.append("--   AND B.BKG_NO = N.BKG_NO " ).append("\n"); 
		query.append("--   AND N.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("   AND F.CUST_CNT_CD = F2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND F.CUST_SEQ = F2.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.ctrt_cust_cnt_cd = CC2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.ctrt_cust_seq = CC2.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.agmt_act_cnt_cd = AC2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.agmt_act_cust_seq = AC2.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.CMDT_CD = MC.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND B.REP_CMDT_CD = MR.REP_CMDT_CD(+)" ).append("\n"); 

	}
}