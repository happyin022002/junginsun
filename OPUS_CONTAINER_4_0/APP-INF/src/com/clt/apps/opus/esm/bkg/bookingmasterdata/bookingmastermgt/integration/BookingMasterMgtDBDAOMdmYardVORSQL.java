/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOMdmYardVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.03.09 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung.kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOMdmYardVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingMasterMgtDBDAOMdmYardVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOMdmYardVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	rf_avg_dwll_hrs," ).append("\n"); 
		query.append("	bfr_ofc_cng_dt," ).append("\n"); 
		query.append("	modi_yd_cd," ).append("\n"); 
		query.append("	rep_yd_tp_cd," ).append("\n"); 
		query.append("	rf_min_dwll_hrs," ).append("\n"); 
		query.append("	rf_yd_ft_hrs," ).append("\n"); 
		query.append("	dry_avg_dwll_hrs," ).append("\n"); 
		query.append("	dry_min_dwll_hrs," ).append("\n"); 
		query.append("	dry_yd_ft_hrs," ).append("\n"); 
		query.append("	yd_ctrl_ofc_addr," ).append("\n"); 
		query.append("	yd_ctrl_ofc_cty_nm," ).append("\n"); 
		query.append("	yd_ctrl_ofc_ste_cd," ).append("\n"); 
		query.append("	yd_ctrl_ofc_zip_cd," ).append("\n"); 
		query.append("	yd_loc_cty_nm," ).append("\n"); 
		query.append("	yd_loc_ste_cd," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt," ).append("\n"); 
		query.append("	delt_flg," ).append("\n"); 
		query.append("	eai_evnt_dt," ).append("\n"); 
		query.append("	hub_yd_flg," ).append("\n"); 
		query.append("	yd_cd," ).append("\n"); 
		query.append("	yd_nm," ).append("\n"); 
		query.append("	loc_cd," ).append("\n"); 
		query.append("	n1st_vndr_cnt_cd," ).append("\n"); 
		query.append("	n1st_vndr_seq," ).append("\n"); 
		query.append("	ofc_cd," ).append("\n"); 
		query.append("	yd_chr_cd," ).append("\n"); 
		query.append("	yd_fcty_tp_mrn_tml_flg," ).append("\n"); 
		query.append("	yd_fcty_tp_cy_flg," ).append("\n"); 
		query.append("	yd_fcty_tp_cfs_flg," ).append("\n"); 
		query.append("	yd_fcty_tp_rail_rmp_flg," ).append("\n"); 
		query.append("	yd_oshp_cd," ).append("\n"); 
		query.append("	bd_yd_flg," ).append("\n"); 
		query.append("	onf_hir_yd_flg," ).append("\n"); 
		query.append("	rep_zn_cd," ).append("\n"); 
		query.append("	yd_addr," ).append("\n"); 
		query.append("	zip_cd," ).append("\n"); 
		query.append("	intl_phn_no," ).append("\n"); 
		query.append("	phn_no," ).append("\n"); 
		query.append("	fax_no," ).append("\n"); 
		query.append("	yd_pic_nm," ).append("\n"); 
		query.append("	yd_ceo_nm," ).append("\n"); 
		query.append("	gate_opn_hrmnt," ).append("\n"); 
		query.append("	gate_clz_hrmnt," ).append("\n"); 
		query.append("	hol_gate_opn_hrmnt," ).append("\n"); 
		query.append("	hol_gate_clz_hrmnt," ).append("\n"); 
		query.append("	sun_gate_opn_hrmnt," ).append("\n"); 
		query.append("	sun_gate_clz_hrmnt," ).append("\n"); 
		query.append("	sat_gate_opn_hrmnt," ).append("\n"); 
		query.append("	sat_gate_clz_hrmnt," ).append("\n"); 
		query.append("	yd_cgo_clz_hrmnt_msg," ).append("\n"); 
		query.append("	yd_rmk," ).append("\n"); 
		query.append("	brth_no," ).append("\n"); 
		query.append("	yd_brth_len," ).append("\n"); 
		query.append("	yd_brth_alng_sd_desc," ).append("\n"); 
		query.append("	yd_brth_dpth_chnl_knt," ).append("\n"); 
		query.append("	yd_ttl_spc," ).append("\n"); 
		query.append("	yd_act_spc," ).append("\n"); 
		query.append("	yd_co_spc," ).append("\n"); 
		query.append("	yd_hndl_capa," ).append("\n"); 
		query.append("	yd_rf_rcpt_440v_knt," ).append("\n"); 
		query.append("	yd_rf_rcpt_220v_knt," ).append("\n"); 
		query.append("	yd_rf_rcpt_dul_knt," ).append("\n"); 
		query.append("	yd_op_sys_cd," ).append("\n"); 
		query.append("	yd_inrl_flg," ).append("\n"); 
		query.append("	yd_cfs_spc," ).append("\n"); 
		query.append("	mnr_shop_flg," ).append("\n"); 
		query.append("	yd_hndl_yr," ).append("\n"); 
		query.append("	yd_ttl_vol_teu_knt," ).append("\n"); 
		query.append("	yd_ttl_vol_bx_knt," ).append("\n"); 
		query.append("	yd_co_vol_teu_knt," ).append("\n"); 
		query.append("	yd_co_vol_bx_knt," ).append("\n"); 
		query.append("	yd_pst_pgc_knt," ).append("\n"); 
		query.append("	yd_pgc_knt," ).append("\n"); 
		query.append("	trstr_knt," ).append("\n"); 
		query.append("	frk_knt," ).append("\n"); 
		query.append("	yd_strdl_crr_knt," ).append("\n"); 
		query.append("	yd_trct_knt," ).append("\n"); 
		query.append("	yd_top_lft_knt," ).append("\n"); 
		query.append("	tml_chss_knt," ).append("\n"); 
		query.append("	eir_svc_flg," ).append("\n"); 
		query.append("	tml_prod_knt," ).append("\n"); 
		query.append("	yd_cstms_no," ).append("\n"); 
		query.append("	yd_fcty_tp_psdo_yd_flg," ).append("\n"); 
		query.append("	yd_eml," ).append("\n"); 
		query.append("	dem_ib_clt_flg," ).append("\n"); 
		query.append("	dem_ob_clt_flg," ).append("\n"); 
		query.append("	bkg_pod_yd_flg," ).append("\n"); 
		query.append("	n2nd_vndr_cnt_cd," ).append("\n"); 
		query.append("	n2nd_vndr_seq," ).append("\n"); 
		query.append("	n3rd_vndr_cnt_cd," ).append("\n"); 
		query.append("	n3rd_vndr_seq," ).append("\n"); 
		query.append("	dmdt_ofc_cd," ).append("\n"); 
		query.append("	yd_fcty_tp_brg_rmp_flg," ).append("\n"); 
		query.append("	bfr_ofc_cd" ).append("\n"); 
		query.append("from mdm_yard" ).append("\n"); 
		query.append("where	1=1" ).append("\n"); 
		query.append("#if (${yd_cd}!= '') " ).append("\n"); 
		query.append("and	yd_cd like '%' || @[yd_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} !='') " ).append("\n"); 
		query.append("and	loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}