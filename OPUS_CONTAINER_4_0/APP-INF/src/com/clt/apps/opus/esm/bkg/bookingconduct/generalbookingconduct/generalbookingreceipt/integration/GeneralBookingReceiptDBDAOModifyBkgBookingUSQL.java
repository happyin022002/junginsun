/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgBookingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgBookingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 정보를 수정한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgBookingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flex_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hot_de_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pty_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_auto_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("irr_bl_no_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_off_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dbl_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_blk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_mtr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_blck_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_bak_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_brog_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("alt_cust_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgBookingUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS SET  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING SET " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	SLAN_CD = ( SELECT 	VSL_SLAN_CD " ).append("\n"); 
		query.append("				FROM 	VSK_VSL_SKD" ).append("\n"); 
		query.append("	 		   	WHERE 	VSL_CD = SUBSTR(@[bkg_trunk_vvd], 1, 4) " ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = SUBSTR(@[bkg_trunk_vvd], 5, 4) " ).append("\n"); 
		query.append("               	AND 	SKD_DIR_CD = SUBSTR(@[bkg_trunk_vvd], 9, 1) " ).append("\n"); 
		query.append("				AND 	ROWNUM = 1 )" ).append("\n"); 
		query.append(",	SVC_SCP_CD 	= nvl(@[svc_scp_cd], SVC_SCP_CD)" ).append("\n"); 
		query.append(",	VSL_CD 		= SUBSTR(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append(",	SKD_VOY_NO 	= SUBSTR(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append(",	SKD_DIR_CD 	= SUBSTR(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append(",	REV_DIR_CD 	= nvl(@[rev_dir_cd], REV_DIR_CD)" ).append("\n"); 
		query.append(",	RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append(",	DE_TERM_CD 	= @[de_term_cd]" ).append("\n"); 
		query.append(",	POR_CD 		= @[bkg_por_cd]" ).append("\n"); 
		query.append(",	POL_CD 		= @[bkg_pol_cd]" ).append("\n"); 
		query.append(",	POD_CD 		= @[bkg_pod_cd]" ).append("\n"); 
		query.append(",	OCP_CD 		= @[ocp_cd]" ).append("\n"); 
		query.append(",	DEL_CD 		= @[bkg_del_cd]" ).append("\n"); 
		query.append(",	MTY_PKUP_YD_CD 	= @[mty_pkup_yd_cd]" ).append("\n"); 
		query.append(",	MTY_PKUP_DT 	= TO_DATE(@[mty_pkup_dt],	'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	FULL_RTN_YD_CD 	= @[full_rtn_yd_cd]" ).append("\n"); 
		query.append(",	MTY_DOR_ARR_DT 	= TO_DATE(@[mty_dor_arr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	LODG_DUE_DT 	= TO_DATE(@[lodg_due_dt],	'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	DE_DUE_DT 		= TO_DATE(@[de_due_dt],		'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	ORG_TRNS_SVC_MOD_CD 	= @[org_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	ORG_SCONTI_CD 			= (SELECT SCONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_por_cd])" ).append("\n"); 
		query.append(",	DEST_TRNS_SVC_MOD_CD 	= @[dest_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	DEST_SCONTI_CD 			= (SELECT SCONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_del_cd])" ).append("\n"); 
		query.append(",	STOP_OFF_LOC_CD 		= @[stop_off_loc_cd]" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PSON_NM 	= @[stop_off_cntc_pson_nm]" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PHN_NO 	= @[stop_off_cntc_phn_no]" ).append("\n"); 
		query.append(",	STOP_OFF_DIFF_RMK 		= @[stop_off_diff_rmk]" ).append("\n"); 
		query.append(",   SC_NO 	= @[sc_no]" ).append("\n"); 
		query.append(",   RFA_NO 	= @[rfa_no]" ).append("\n"); 
		query.append(",	TAA_NO 	= @[taa_no]" ).append("\n"); 
		query.append(",	OB_SLS_OFC_CD 	= (SELECT OFC_CD FROM MDM_SLS_REP WHERE UPPER(SREP_CD) = UPPER(@[ob_srep_cd]))" ).append("\n"); 
		query.append(",	OB_SREP_CD 		= UPPER(@[ob_srep_cd])" ).append("\n"); 
		query.append(",	IB_SLS_OFC_CD 	= (SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_del_cd])" ).append("\n"); 
		query.append(",	CMDT_CD 		= @[cmdt_cd]" ).append("\n"); 
		query.append(",	REP_CMDT_CD 	= (select rep_cmdt_cd from mdm_commodity where cmdt_cd = @[cmdt_cd])" ).append("\n"); 
		query.append(",   BKG_CGO_TP_CD 	= NVL(@[bkg_cgo_tp_cd],'F')" ).append("\n"); 
		query.append(",	DCGO_FLG = NVL(DECODE(NVL(@[dcgo_flg], 'N'), 'Y', 'Y', " ).append("\n"); 
		query.append("								(SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y') " ).append("\n"); 
		query.append("								#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("			                      FROM BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("		                          FROM BKG_DG_CGO" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								   AND ROWNUM = 1)), 'N')" ).append("\n"); 
		query.append(",	RC_FLG = NVL(DECODE(NVL(@[rc_flg], 'N'), 'Y', 'Y', " ).append("\n"); 
		query.append("								(SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y')" ).append("\n"); 
		query.append("								#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		                          FROM BKG_RF_CGO_HIS" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("		                          FROM BKG_RF_CGO" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								#end " ).append("\n"); 
		query.append("								   AND ROWNUM = 1)), 'N')" ).append("\n"); 
		query.append(",	AWK_CGO_FLG = NVL(DECODE(NVL(@[awk_cgo_flg], 'N'), 'Y', 'Y', " ).append("\n"); 
		query.append("								(SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y') " ).append("\n"); 
		query.append("								#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("			                      FROM BKG_AWK_CGO_HIS" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append(" 			                      FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								#end " ).append("\n"); 
		query.append(" 								   AND ROWNUM = 1)), 'N')" ).append("\n"); 
		query.append(",	BB_CGO_FLG = NVL(DECODE(NVL(@[bb_cgo_flg], 'N'), 'Y', 'Y', " ).append("\n"); 
		query.append("								(SELECT DECODE(NVL(COUNT(1), 0), 0, 'N', 'Y') " ).append("\n"); 
		query.append("								#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("				                  FROM BKG_BB_CGO_HIS" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("								#else" ).append("\n"); 
		query.append("		                          FROM BKG_BB_CGO" ).append("\n"); 
		query.append("		                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								#end " ).append("\n"); 
		query.append("								   AND ROWNUM = 1)), 'N')" ).append("\n"); 
		query.append(",	RD_CGO_FLG 		= NVL(@[rd_cgo_flg],'N')" ).append("\n"); 
		query.append(",	HNGR_FLG		= NVL(@[hngr_flg],'N')" ).append("\n"); 
		query.append(",	RAIL_BLK_CD 	= @[rail_blk_cd]" ).append("\n"); 
		query.append(",	PRCT_FLG 		= NVL(@[prct_flg],'N')" ).append("\n"); 
		query.append(",	SPCL_HIDE_FLG 	= NVL(@[spcl_hide_flg],'N')" ).append("\n"); 
		query.append(",	SOC_FLG 		= NVL(@[soc_flg],'N')" ).append("\n"); 
		query.append(",	EQ_SUBST_FLG 	= NVL(@[eq_subst_flg],'N')" ).append("\n"); 
		query.append(",	FD_GRD_FLG 		= NVL(@[fd_grd_flg],'N')" ).append("\n"); 
		query.append(",	FLEX_HGT_FLG 	= NVL(@[flex_hgt_flg],'N')" ).append("\n"); 
		query.append(",	ALL_MTR_FLG 	= NVL(@[all_mtr_flg],'N')" ).append("\n"); 
		query.append(",	HOT_DE_FLG 		= NVL(@[hot_de_flg],'N')" ).append("\n"); 
		query.append(",	DBL_BKG_FLG 	= NVL(@[dbl_bkg_flg],'N')" ).append("\n"); 
		query.append(",	AP_BROG_FLG 	= NVL(@[ap_brog_flg],'N')" ).append("\n"); 
		query.append(",	ALT_CUST_CFM_FLG= NVL(@[alt_cust_cfm_flg],'N')" ).append("\n"); 
		query.append(",	SHP_BAK_FLG 	= NVL(@[shp_bak_flg],'N')" ).append("\n"); 
		query.append(",	BL_ISS_BLCK_FLG = NVL(@[bl_iss_blck_flg],'N')" ).append("\n"); 
		query.append(", 	TWN_SO_NO 		= @[twn_so_no]" ).append("\n"); 
		query.append(",	SCAC_CD 		= @[scac_cd]" ).append("\n"); 
		query.append(",	USA_CSTMS_FILE_CD = @[usa_cstms_file_cd]" ).append("\n"); 
		query.append(",	CND_CSTMS_FILE_CD = @[cnd_cstms_file_cd]" ).append("\n"); 
		query.append(",	INTER_RMK 		= @[inter_rmk]" ).append("\n"); 
		query.append(",	XTER_RMK 		= @[xter_rmk]" ).append("\n"); 
		query.append(",	INTER_RMK_AUD_FLG      = NVL(@[inter_rmk_aud_flg], 'N')" ).append("\n"); 
		query.append(",	XTER_RQST_AUTO_NTC_FLG = NVL(@[xter_rqst_auto_ntc_flg], 'N')" ).append("\n"); 
		query.append(",	SI_FLG 			= NVL(@[si_flg], 'N')" ).append("\n"); 
		query.append(",   EDI_HLD_FLG 	= NVL(@[edi_hld_flg],'N')" ).append("\n"); 
		query.append(",   XTER_SI_CD      = DECODE(NVL(@[xter_si_cd], 'X'), 'X', XTER_SI_CD, @[xter_si_cd])" ).append("\n"); 
		query.append(",	UPD_USR_ID 		= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append(",	VNDR_RMK		= @[vndr_rmk]" ).append("\n"); 
		query.append(",	BKG_CTRL_PTY_CUST_CNT_CD = @[bkg_ctrl_pty_cust_cnt_cd]" ).append("\n"); 
		query.append(",	BKG_CTRL_PTY_CUST_SEQ = @[bkg_ctrl_pty_cust_seq]" ).append("\n"); 
		query.append(",	BL_NO = @[bl_no]" ).append("\n"); 
		query.append(",	IRR_BL_NO_FLG = NVL(@[irr_bl_no_flg],'N')" ).append("\n"); 
		query.append(",	BKG_PTY_CUST_CNT_CD	 = @[bkg_pty_cnt_cd]" ).append("\n"); 
		query.append(",	BKG_PTY_CUST_SEQ = @[bkg_pty_cust_seq]" ).append("\n"); 
		query.append(",	LST_SAV_DT 		= SYSDATE" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}