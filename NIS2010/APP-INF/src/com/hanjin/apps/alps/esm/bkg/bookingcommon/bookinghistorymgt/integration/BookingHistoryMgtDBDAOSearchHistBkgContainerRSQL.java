/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_dtmn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cy_auto_gen_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_bdl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hlg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rcv_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk_bl_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adv_shtg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tax_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_prt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cy_gen_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgContainerRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[cnmv_yr] CNMV_YR" ).append("\n"); 
		query.append(", @[cnmv_id_no] CNMV_ID_NO" ).append("\n"); 
		query.append(", @[cnmv_cyc_no] CNMV_CYC_NO" ).append("\n"); 
		query.append(", @[cnmv_sts_cd] CNMV_STS_CD" ).append("\n"); 
		query.append(", @[cntr_dp_seq] CNTR_DP_SEQ" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[cntr_wgt] CNTR_WGT" ).append("\n"); 
		query.append(", @[vgm_wgt] VGM_WGT" ).append("\n"); 
		query.append(", @[vgm_wgt_ut_cd] VGM_WGT_UT_CD" ).append("\n"); 
		query.append(", @[vgm_vrfy_dt] VGM_VRFY_DT" ).append("\n"); 
		query.append(", @[vgm_dtmn_dt] VGM_DTMN_DT" ).append("\n"); 
		query.append(", @[vgm_vrfy_sig_ctnt] VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append(", @[vgm_mzd_tp_cd] VGM_MZD_TP_CD" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[meas_qty] MEAS_QTY" ).append("\n"); 
		query.append(", @[meas_ut_cd] MEAS_UT_CD" ).append("\n"); 
		query.append(", @[rcv_term_cd] RCV_TERM_CD" ).append("\n"); 
		query.append(", @[de_term_cd] DE_TERM_CD" ).append("\n"); 
		query.append(", @[org_fm_loc_cd] ORG_FM_LOC_CD" ).append("\n"); 
		query.append(", @[org_to_loc_cd] ORG_TO_LOC_CD" ).append("\n"); 
		query.append(", @[org_yd_cd] ORG_YD_CD" ).append("\n"); 
		query.append(", @[dest_fm_loc_cd] DEST_FM_LOC_CD" ).append("\n"); 
		query.append(", @[dest_to_yd_cd] DEST_TO_YD_CD" ).append("\n"); 
		query.append(", @[dest_yd_cd] DEST_YD_CD" ).append("\n"); 
		query.append(", @[por_nod_cd] POR_NOD_CD" ).append("\n"); 
		query.append(", @[pol_yd_cd] POL_YD_CD" ).append("\n"); 
		query.append(", @[cntr_prt_flg] CNTR_PRT_FLG" ).append("\n"); 
		query.append(", @[cntr_prt_seq] CNTR_PRT_SEQ" ).append("\n"); 
		query.append(", @[cntr_vol_qty] CNTR_VOL_QTY" ).append("\n"); 
		query.append(", @[adv_shtg_cd] ADV_SHTG_CD" ).append("\n"); 
		query.append(", @[cntr_tax_expt_flg] CNTR_TAX_EXPT_FLG" ).append("\n"); 
		query.append(", @[cstms_prn_flg] CSTMS_PRN_FLG" ).append("\n"); 
		query.append(", @[cstms_exp_dt] CSTMS_EXP_DT" ).append("\n"); 
		query.append(", @[cntr_hlg_flg] CNTR_HLG_FLG" ).append("\n"); 
		query.append(", @[dcgo_flg] DCGO_FLG" ).append("\n"); 
		query.append(", @[rc_flg] RC_FLG" ).append("\n"); 
		query.append(", @[bb_cgo_flg] BB_CGO_FLG" ).append("\n"); 
		query.append(", @[awk_cgo_flg] AWK_CGO_FLG" ).append("\n"); 
		query.append(", @[rd_cgo_flg] RD_CGO_FLG" ).append("\n"); 
		query.append(", @[hngr_flg] HNGR_FLG" ).append("\n"); 
		query.append(", @[soc_flg] SOC_FLG" ).append("\n"); 
		query.append(", @[eq_subst_flg] EQ_SUBST_FLG" ).append("\n"); 
		query.append(", @[eq_subst_tpsz_cd] EQ_SUBST_TPSZ_CD" ).append("\n"); 
		query.append(", @[cgo_rcv_dt] CGO_RCV_DT" ).append("\n"); 
		query.append(", @[cgo_rcv_yd_cd] CGO_RCV_YD_CD" ).append("\n"); 
		query.append(", @[ob_cy_gen_dt] OB_CY_GEN_DT" ).append("\n"); 
		query.append(", @[ob_cy_auto_gen_flg] OB_CY_AUTO_GEN_FLG" ).append("\n"); 
		query.append(", @[cnmv_flg] CNMV_FLG" ).append("\n"); 
		query.append(", @[cnmv_evnt_dt] CNMV_EVNT_DT" ).append("\n"); 
		query.append(", @[po_no] PO_NO" ).append("\n"); 
		query.append(", @[do_no] DO_NO" ).append("\n"); 
		query.append(", @[do_no_split] DO_NO_SPLIT" ).append("\n"); 
		query.append(", @[diff_rmk] DIFF_RMK" ).append("\n"); 
		query.append(", @[rmk_bl_dp_flg] RMK_BL_DP_FLG" ).append("\n"); 
		query.append(", @[cntr_cfm_flg] CNTR_CFM_FLG" ).append("\n"); 
		query.append(", @[mcntr_bdl_no] MCNTR_BDL_NO" ).append("\n"); 
		query.append(", @[mf_cfm_flg] MF_CFM_FLG" ).append("\n"); 
		query.append(", @[cntr_delt_flg] CNTR_DELT_FLG" ).append("\n"); 
		query.append(", DECODE((SELECT COUNT(1) " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("		               FROM BKG_CNTR_HIS DEL" ).append("\n"); 
		query.append("			          WHERE DEL.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("			 	        AND DEL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			           FROM BKG_CONTAINER DEL" ).append("\n"); 
		query.append("			          WHERE DEL.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           				AND DEL.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("						AND ROWNUM 		= 1), 0, 'Y', 'N') DEL_YN" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , REPLACE(REPLACE(REPLACE(REPLACE(PRE_CTNT,  '()/()/()/()', null), '/0()', null), '/()', null), '()', null) PRE_CTNT" ).append("\n"); 
		query.append("     , decode(CRNT_CTNT, '()/()/()/()', null, '()/', null, '()', null, '/', null, CRNT_CTNT) CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'Container No.(CNTR)' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')' CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT 'PKG/Weight/Measure(CNTR)' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')/'||OLD.PCK_QTY||'('||OLD.PCK_TP_CD||')/'||OLD.CNTR_WGT||'('||OLD.WGT_UT_CD||')/'||OLD.MEAS_QTY||'('||OLD.MEAS_UT_CD||')' PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')/'||NOW.PCK_QTY||'('||NOW.PCK_TP_CD||')/'||NOW.CNTR_WGT||'('||NOW.WGT_UT_CD||')/'||NOW.MEAS_QTY||'('||NOW.MEAS_UT_CD||')' CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND (OLD.PCK_QTY <> 0 OR OLD.CNTR_WGT <> 0 OR OLD.MEAS_QTY <> 0 )) OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("        SELECT 'CNTR/VGM/Signature/Method' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'/'||OLD.VGM_WGT||'('||OLD.VGM_WGT_UT_CD||')/'||OLD.VGM_VRFY_SIG_CTNT||'/'||OLD.VGM_MZD_TP_CD PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'/'||NOW.VGM_WGT||'('||NOW.VGM_WGT_UT_CD||')/'||NOW.VGM_VRFY_SIG_CTNT||'/'||NOW.VGM_MZD_TP_CD CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND (OLD.VGM_WGT <> 0 )) OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT 'CNTR VOL' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')/'||trim(to_char(OLD.CNTR_VOL_QTY, '999,999,990.000')) PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')/'||trim(to_char(NOW.CNTR_VOL_QTY, '999,999,990.000')) CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND OLD.CNTR_VOL_QTY <> 1) OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO		" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT 'AS' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')/'||OLD.ADV_SHTG_CD PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')/'||NOW.ADV_SHTG_CD CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND OLD.ADV_SHTG_CD IS NOT NULL) OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO		" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT 'HG' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')/'||OLD.HNGR_FLG" ).append("\n"); 
		query.append("                   ||'/D:'||OLD.DCGO_FLG||'/R:'||OLD.RC_FLG ||'/'|| OLD.RD_CGO_FLG ||'/B:'||OLD.BB_CGO_FLG" ).append("\n"); 
		query.append("                   ||'/A:'||OLD.AWK_CGO_FLG ||'/S:'|| OLD.SOC_FLG || '/P:' || OLD.CNTR_PRT_FLG || ':' || OLD.CNTR_VOL_QTY AS PRE_CTNT " ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')/'||NOW.HNGR_FLG" ).append("\n"); 
		query.append("                   ||'/D:'||NOW.DCGO_FLG||'/R:'||NOW.RC_FLG ||'/'|| NOW.RD_CGO_FLG ||'/B:'||NOW.BB_CGO_FLG" ).append("\n"); 
		query.append("                   ||'/A:'||NOW.AWK_CGO_FLG ||'/S:'|| NOW.SOC_FLG || '/P:' || NOW.CNTR_PRT_FLG || ':' || NOW.CNTR_VOL_QTY AS CRNT_CTNT " ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND OLD.HNGR_FLG <> 'N') OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO		" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT 'CNTR Remark' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'('||OLD.CNTR_TPSZ_CD||')/'||OLD.DIFF_RMK PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'('||NOW.CNTR_TPSZ_CD||')/'||NOW.DIFF_RMK CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND OLD.DIFF_RMK IS NOT NULL) OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("        SELECT 'CRD Date' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||'/'|| OLD.CGO_RCV_DT PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||'/'|| TO_CHAR(NOW.CGO_RCV_DT,'YYYY-MM-DD HH24:MI') CRNT_CTNT" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("                     FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ((OLD.DEL_YN = 'Y' AND OLD.HNGR_FLG <> 'N') OR OLD.DEL_YN = 'N')" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}