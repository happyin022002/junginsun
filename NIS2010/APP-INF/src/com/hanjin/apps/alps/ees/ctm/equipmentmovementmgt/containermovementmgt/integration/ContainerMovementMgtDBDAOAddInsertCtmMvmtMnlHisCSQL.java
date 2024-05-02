/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOAddInsertCtmMvmtMnlHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOAddInsertCtmMvmtMnlHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] CTM Movement History table 변경
	  *  - 신규 생성 건에 대한 데이터 저장
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOAddInsertCtmMvmtMnlHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_xch_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dat_div_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_div_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_lvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_disp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_corr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOAddInsertCtmMvmtMnlHisCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_MNL_HIS (" ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNMV_YR," ).append("\n"); 
		query.append("  CNMV_ID_NO," ).append("\n"); 
		query.append("  CNMV_HIS_SEQ," ).append("\n"); 
		query.append("  DAT_DIV_FLG," ).append("\n"); 
		query.append("  MODI_TP_FLG," ).append("\n"); 
		query.append("  INP_DIV_FLG," ).append("\n"); 
		query.append("  CNMV_SEQ," ).append("\n"); 
		query.append("  CNMV_SPLIT_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  MVMT_STS_CD," ).append("\n"); 
		query.append("  BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  CNMV_CYC_NO," ).append("\n"); 
		query.append("  CNMV_LVL_NO," ).append("\n"); 
		query.append("  CNMV_EVNT_DT," ).append("\n"); 
		query.append("  DEST_YD_CD," ).append("\n"); 
		query.append("  INP_YD_CD," ).append("\n"); 
		query.append("  ORG_YD_CD," ).append("\n"); 
		query.append("  CNT_CD," ).append("\n"); 
		query.append("  CRNT_VSL_CD," ).append("\n"); 
		query.append("  CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("  CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("  TRNK_VSL_CD," ).append("\n"); 
		query.append("  TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("  TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("  CHSS_NO," ).append("\n"); 
		query.append("  MGST_NO," ).append("\n"); 
		query.append("  CNTR_SEAL_NO," ).append("\n"); 
		query.append("  CNTR_DMG_FLG," ).append("\n"); 
		query.append("  FCNTR_FLG," ).append("\n"); 
		query.append("  OB_CNTR_FLG," ).append("\n"); 
		query.append("  BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  LOC_CD," ).append("\n"); 
		query.append("  CNMV_RMK," ).append("\n"); 
		query.append("  CHSS_MGST_MVMT_RMK," ).append("\n"); 
		query.append("  USR_NM," ).append("\n"); 
		query.append("  MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("  SUBST_RULE_CD," ).append("\n"); 
		query.append("  SPCL_CGO_FLG," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BKG_KNT," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("  CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("  CNTR_ACT_CD," ).append("\n"); 
		query.append("  CNTR_RFUB_FLG," ).append("\n"); 
		query.append("  CNTR_DISP_FLG," ).append("\n"); 
		query.append("  IMDT_EXT_FLG," ).append("\n"); 
		query.append("  CNTR_XCH_CD," ).append("\n"); 
		query.append("  INLND_TRSP_LIC_NO," ).append("\n"); 
		query.append("  CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("  CTRT_SEQ," ).append("\n"); 
		query.append("  MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("  WBL_NO," ).append("\n"); 
		query.append("  PKUP_NO," ).append("\n"); 
		query.append("  CNTR_STS_SEQ," ).append("\n"); 
		query.append("  CALL_SGN_NO," ).append("\n"); 
		query.append("  LLOYD_NO," ).append("\n"); 
		query.append("  MTY_REPO_VL_RMK," ).append("\n"); 
		query.append("  MVMT_INP_TP_CD," ).append("\n"); 
		query.append("  CNMV_CO_CD," ).append("\n"); 
		query.append("  SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("  OFC_CD," ).append("\n"); 
		query.append("  PRE_STS_FLG," ).append("\n"); 
		query.append("  CNMV_CORR_RSN," ).append("\n"); 
		query.append("  ATCH_FILE_SAV_ID," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VGM_VRFY_DT," ).append("\n"); 
		query.append("  VGM_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_REF_NO," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT," ).append("\n"); 
		query.append("  GMT_DT," ).append("\n"); 
		query.append("  CRE_LOCL_DT," ).append("\n"); 
		query.append("  UPD_LOCL_DT," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("  @[cnmv_yr] AS CNMV_YR," ).append("\n"); 
		query.append("  @[cnmv_id_no] AS CNMV_ID_NO," ).append("\n"); 
		query.append("  @[cnmv_his_seq] AS CNMV_HIS_SEQ," ).append("\n"); 
		query.append("  @[dat_div_flg] AS DAT_DIV_FLG," ).append("\n"); 
		query.append("  @[modi_tp] AS MODI_TP_FLG," ).append("\n"); 
		query.append("  @[inp_div_flg] AS INP_DIV_FLG," ).append("\n"); 
		query.append("  @[cnmv_seq] AS CNMV_SEQ," ).append("\n"); 
		query.append("  @[cnmv_split_no] AS CNMV_SPLIT_NO," ).append("\n"); 
		query.append("  (SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  @[mvmt_sts_cd] AS MVMT_STS_CD," ).append("\n"); 
		query.append("  @[bkg_cgo_tp_cd] AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  @[cnmv_cyc_no] AS CNMV_CYC_NO," ).append("\n"); 
		query.append("  @[cnmv_lvl_no] AS CNMV_LVL_NO," ).append("\n"); 
		query.append("  TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDDHH24MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("  @[dest_yd_cd] AS DEST_YD_CD," ).append("\n"); 
		query.append("  @[org_yd_cd] AS INP_YD_CD," ).append("\n"); 
		query.append("  @[org_yd_cd] AS ORG_YD_CD," ).append("\n"); 
		query.append("  SUBSTR(@[org_yd_cd],1,2) AS CNT_CD," ).append("\n"); 
		query.append("  DECODE(SUBSTR(@[cntr_id], 1, 4), null, '', SUBSTR(@[cntr_id], 1, 4)) AS CRNT_VSL_CD," ).append("\n"); 
		query.append("  DECODE(SUBSTR(@[cntr_id], 5, 4), null, '', SUBSTR(@[cntr_id], 5, 4)) AS CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("  DECODE(SUBSTR(@[cntr_id], 9, 1), null, '', SUBSTR(@[cntr_id], 9, 1)) AS CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("  DECODE(@[trnk_vsl_cd], 'null', '', @[trnk_vsl_cd]) AS TRNK_VSL_CD," ).append("\n"); 
		query.append("  DECODE(@[trnk_skd_voy_no], 'null', '', @[trnk_skd_voy_no]) AS TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("  DECODE(@[trnk_skd_dir_cd], 'null', '', @[trnk_skd_dir_cd]) AS TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("  @[chss_no] AS CHSS_NO," ).append("\n"); 
		query.append("  @[mgst_no] AS MGST_NO," ).append("\n"); 
		query.append("  @[cntr_seal_no] AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("  NVL(@[cntr_dmg_flg], 'N') AS CNTR_DMG_FLG," ).append("\n"); 
		query.append("  NVL(DECODE(@[fcntr_flg], 'F', 'Y', 'M', 'N', 'E', 'N', @[fcntr_flg]), 'N') AS FCNTR_FLG," ).append("\n"); 
		query.append("  DECODE(@[ob_cntr_flg], 'O', 'Y', 'I', 'N', @[ob_cntr_flg]) AS OB_CNTR_FLG," ).append("\n"); 
		query.append("  @[bkg_rcv_term_cd] AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("  DECODE(@[vndr_seq], 'null', '', @[vndr_seq]) AS VNDR_SEQ," ).append("\n"); 
		query.append("  @[mvmt_trsp_mod_cd] AS MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  '' AS LOC_CD," ).append("\n"); 
		query.append("  @[cnmv_rmk] AS CNMV_RMK," ).append("\n"); 
		query.append("  '' AS CHSS_MGST_MVMT_RMK," ).append("\n"); 
		query.append("  @[usr_nm] AS USR_NM," ).append("\n"); 
		query.append("  @[mvmt_cre_tp_cd] AS MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("  '' SUBST_RULE_CD," ).append("\n"); 
		query.append("  NVL(@[spcl_cgo_flg], 'N') AS SPCL_CGO_FLG," ).append("\n"); 
		query.append("  @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("  @[bkg_knt] AS BKG_KNT," ).append("\n"); 
		query.append("  @[bl_no] AS BL_NO," ).append("\n"); 
		query.append("  '' AS CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("  '' AS CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("  DECODE(@[mvmt_sts_cd], 'XX', 'I', 'A') AS CNTR_ACT_CD," ).append("\n"); 
		query.append("  '' AS CNTR_RFUB_FLG," ).append("\n"); 
		query.append("  NVL(@[cntr_disp_flg], 'N') AS CNTR_DISP_FLG," ).append("\n"); 
		query.append("  NVL(@[imdt_ext_flg], 'N') AS IMDT_EXT_FLG," ).append("\n"); 
		query.append("  @[cntr_xch_cd] AS CNTR_XCH_CD," ).append("\n"); 
		query.append("  '' AS INLND_TRSP_LIC_NO," ).append("\n"); 
		query.append("  @[ctrt_ofc_cty_cd] AS CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("  @[ctrt_seq] AS CTRT_SEQ," ).append("\n"); 
		query.append("  @[mvmt_edi_tp_cd] AS MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("  @[mvmt_edi_msg_tp_id] AS MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  @[mvmt_edi_msg_area_cd] AS MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("  @[mvmt_edi_msg_yrmondy] AS MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("  @[mvmt_edi_msg_seq] AS MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("  '' AS WBL_NO," ).append("\n"); 
		query.append("  '' AS PKUP_NO," ).append("\n"); 
		query.append("  '' AS CNTR_STS_SEQ," ).append("\n"); 
		query.append("  '' AS CALL_SGN_NO," ).append("\n"); 
		query.append("  '' AS LLOYD_NO," ).append("\n"); 
		query.append("  '' AS MTY_REPO_VL_RMK," ).append("\n"); 
		query.append("  @[mvmt_inp_tp_cd] AS MVMT_INP_TP_CD," ).append("\n"); 
		query.append("  'SML' AS CNMV_CO_CD," ).append("\n"); 
		query.append("  @[cntr_svr_id] AS SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("  @[ofc_cd] AS OFC_CD," ).append("\n"); 
		query.append("  DECODE(@[pre_sts_flg], NULL, 'N', @[pre_sts_flg]) AS PRE_STS_FLG," ).append("\n"); 
		query.append("  NVL(@[cnmv_corr_rsn], ' ') AS CNMV_CORR_RSN," ).append("\n"); 
		query.append("  @[atch_file_sav_id] AS ATCH_FILE_SAV_ID," ).append("\n"); 
		query.append("  '' AS VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  '' AS VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  '' AS VGM_WGT_QTY," ).append("\n"); 
		query.append("  '' AS VGM_VRFY_DT," ).append("\n"); 
		query.append("  '' AS VGM_SIG_CTNT," ).append("\n"); 
		query.append("  '' AS VGM_REF_NO," ).append("\n"); 
		query.append("  '' AS VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  '' AS VGM_VRFY_ORD_CTNT," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(@[org_yd_cd], 0, 5 ), SYSDATE, 'GMT') AS GMT_DT," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(@[org_yd_cd], 0, 5)) AS CRE_LOCL_DT," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(@[org_yd_cd], 0, 5)) AS UPD_LOCL_DT," ).append("\n"); 
		query.append("  @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("  SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("  @[cre_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("  SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}