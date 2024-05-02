/*=========================================================
 * Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1701.js
 *@FileTitle : Booking Status Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*
 *  variable which is for handling inserting value to initial value
 * */
var arrFormElementMap={vvd_cd:'input',		trunk_flag:'check',     lane_cd:'input',		dir_cd:'multi',			pol_cd:'input',
					 pol_yard_cd:'input',	pol_local:'check',      pol_ts:'check',			pod_cd:'input',			pod_yard_cd:'input', 
					 pod_local:'check',		pod_ts:'check',         por_cd:'input',			del_cd:'input',			r_term:'multi',
					 d_term:'multi',		board_from_dt:'input',  board_to_dt:'input',	bkg_from_dt:'input',  	bkg_to_dt:'input',
					 bkg_kind:'multi',		b_ofc_cd:'input',       b_ofc_cd_sub:'check',	b_staff_id:'combo',		ca_flag:'check',
					 bl_rlse_ofc_cd:'input',eq_type:'multi',		cmdt_cd:'input',		cmdt_nm:'input',		cgo_wgt_from:'input',
					 cgo_wgt_to:'input',	cgo_wgt_kg:'check',		cgo_wgt_lb:'check',		grs_wgt_from:'input',	grs_wgt_to:'input',
					 grs_wgt_kg:'check',	grs_wgt_lb:'check',		
					 //weight band
					 wgt_bnd_xh:'check',	wgt_bnd_h:'check',		wgt_bnd_m:'check',		wgt_bnd_l:'check',	
					 //sc,rfa,taa
					 ctr_rfa_cd:'radio',	ctr_rfa_no:'input',      
					 //booking sts
					 bkg_sts_cd_f:'check',	bkg_sts_cd_x:'check',   bkg_sts_cd_a:'check', 
					 bkg_sts_cd_w:'check',	non_sp_cargo:'check',   holding:'check',
					 //container sts
					 cntr_sts_cd_en:'check',cntr_sts_cd_op:'check',cntr_sts_cd_ic:'check',cntr_sts_cd_tn:'check',cntr_sts_cd_id:'check',
					 cntr_sts_cd_ts:'check',cntr_sts_cd_mt:'check',cntr_sts_cd_vs:'check',cntr_sts_cd_oc:'check',cntr_sts_cd_vl:'check',
					 //rating sts
					 rate_sts_r:'check',	rate_sts_u:'check',
					 //customer
					 cust_tp_cd_s:'check',  cust_tp_cd_c:'check', cust_tp_cd_n:'check',   cust_tp_cd_f:'check', 	cust_tp_cd_a:'check',
//					 cust_tp_cd_g:'check',  cust_cnt_cd:'input',  cust_seq:'input',       cust_nm:'input',			cust_tp_cd:'multi', 
					 cust_cnt_cd:'input',  cust_seq:'input',       cust_nm:'input',			//cust_grp_id:'input',
					 //cargo nature
					 sp_cargo_dg:'check',   sp_cargo_rf:'check',  sp_cargo_ak:'check',    sp_cargo_bb:'check', 	sp_cargo_rd:'check',
					 sp_cargo_hg:'check',
					 
                    }
/*
 * defining attribute of grid column
 * */                     
var arrGridColsProp={
		bl_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bl_no' })",
		obl_iss_ofc_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'obl_iss_ofc_cd' })",
		cre_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cre_dt' })",
		bkg_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_no' })",
		bkg_ofc_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_ofc_cd' })",
		cre_usr_id	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cre_usr_id' })",
		bkg_sts_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_sts_cd' })",
		ctrt_srep_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrt_srep_cd' })",
		ob_srep_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_srep_cd' })",
		rate_sts	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rate_sts' })",
		sls_area	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'sls_area' })",
		sls_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'sls_cd' })",
		ob_sls_ofc_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_sls_ofc_cd' })",
		scac_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'scac_cd' })",
		spcl_hndl_inst	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'spcl_hndl_inst' })",
		split_flg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'split_flg' })",
		xter_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'xter_rmk' })",
		inter_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'inter_rmk' })",
		vndr_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vndr_rmk' })",
		lcl_meas_qty	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'lcl_meas_qty' })",
		lcl_meas_ut_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'lcl_meas_ut_cd' })",
		cgo_n	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cgo_n' })",
		cgo_wgt_kg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cgo_wgt_kg' })",
		cgo_wgt_lb	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cgo_wgt_lb' })",
		cmdt_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmdt_cd' })",
		cmdt_desc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmdt_desc' })",
		cmdt_hs_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmdt_hs_cd' })",
		cmdt_hs_grp_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmdt_hs_grp_cd' })",
		hts_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'hts_cd' })",
		ncm_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ncm_no' })",
		lcl_pck_qty	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'lcl_pck_qty' })",
		ob_cfs_loc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_cfs_loc' })",
		lcl_cntr_mf_gds_desc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'lcl_cntr_mf_gds_desc' })",
		lcl_pck_tp_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'lcl_pck_tp_cd' })",
		est_pkup_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'est_pkup_dt' })",
		act_pkup_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'act_pkup_dt' })",
		est_rtn_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'est_rtn_dt' })",
		act_rtn_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'act_rtn_dt' })",
		cgo_cutoff_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cgo_cutoff_dt' })",
		cgo_aval_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cgo_aval_dt' })",
		grs_wgt_kg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'grs_wgt_kg' })",
		grs_wgt_lb	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'grs_wgt_lb' })",
		cntr_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cntr_no' })",
		cntr_vol_qty	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cntr_vol_qty' })",
		teu	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'teu' })",
		feu	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'feu' })",
		cntr_tpsz_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cntr_tpsz_cd' })",
		cnmv_sts_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cnmv_sts_cd' })",
		cnmv_sts_desc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cnmv_sts_desc' })",
		tare_wgt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'tare_wgt' })",
		tare_lbs	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'tare_lbs' })",
		mty_pkup_loc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'mty_pkup_loc' })",
		mty_rtn_loc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'mty_rtn_loc' })",
		full_rtn_loc	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'full_rtn_loc' })",
		ib_pkup_yd_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ib_pkup_yd_cd' })",
		ib_pkup_yd_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ib_pkup_yd_nm' })",
		ib_clr_loc_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ib_clr_loc_cd' })",
		ib_hlg_bkg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ib_hlg_bkg' })",
		ob_hlg_bkg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_hlg_bkg' })",
		pck_tp_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pck_tp_cd' })",
		pck_qty	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pck_qty' })",
		cntr_seal_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cntr_seal_no' })",
		cntr_seal_cnt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cntr_seal_cnt' })",
		eq_subst_tp	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'eq_subst_tp' })",
		wgt_bnd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'wgt_bnd' })",
		c_cust	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'c_cust' })",
		ctrt_cust	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrt_cust' })",
		f_cust	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'f_cust' })",
		f_cntc_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'f_cntc_nm' })",
		f_cntc_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'f_cntc_no' })",
		f_cnt_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'f_cnt_cd' })",
		f_ste_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'f_ste_cd' })",
		s_grp_cust	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'s_grp_cust' })",
		ctrl_pty	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrl_pty' })",
		s_cust_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'s_cust_nm' })",
		s_cntc_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'s_cntc_nm' })",
		s_cntc_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'s_cntc_no' })",
		ebff_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ebff_ref_no' })",
		ebrf_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ebrf_ref_no' })",
		ebsh_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ebsh_ref_no' })",
		dg_certi_flg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'dg_certi_flg' })",
		xpt_decl_rcv	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'xpt_decl_rcv' })",
		ens_mrn	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ens_mrn' })",
		cmrn_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmrn_ref_no' })",
		exs_mrn	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'exs_mrn' })",
		finv_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'finv_ref_no' })",
		aes_itn_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'aes_itn_no' })",
		po_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'po_no' })",
		rgbk_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rgbk_ref_no' })",
		essh_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'essh_ref_no' })",
		esff_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'esff_ref_no' })",
		esrf_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'esrf_ref_no' })",
		twn_so_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'twn_so_no' })",
		si_flg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'si_flg' })",
		cucr_ref_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cucr_ref_no' })",
		blck_stwg_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'blck_stwg_cd' })",
		t_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'t_vvd' })",
		t_vsl_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'t_vsl_nm' })",
		trd_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trd_cd' })",
		svc_scp_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'svc_scp_cd' })",
		de_term_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'de_term_cd' })",
		rcv_term_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rcv_term_cd' })",
		por_cnt_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'por_cnt_cd' })",
		por_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'por_cd' })",
		por_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'por_nm' })",
		vvd1_pol_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd1_pol_cd' })",
		vvd1_pol_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd1_pol_nm' })",
		vvd2_pol_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd2_pol_cd' })",
		vvd2_pol_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd2_pol_nm' })",
		vvd3_pol_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd3_pol_cd' })",
		vvd3_pol_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd3_pol_nm' })",
		vvd4_pol_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd4_pol_cd' })",
		vvd4_pol_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd4_pol_nm' })",
		vvd1_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd1_pod_cd' })",
		vvd1_pod_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd1_pod_nm' })",
		vvd2_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd2_pod_cd' })",
		vvd2_pod_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd2_pod_nm' })",
		vvd3_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd3_pod_cd' })",
		vvd3_pod_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd3_pod_nm' })",
		vvd4_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd4_pod_cd' })",
		vvd4_pod_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vvd4_pod_nm' })",
		last_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'last_pod_cd' })",
		last_pod_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'last_pod_nm' })",
		del_cnt_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'del_cnt_cd' })",
		del_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'del_cd' })",
		del_nm	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'del_nm' })",
		pre1_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre1_vvd' })",
		pre2_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre2_vvd' })",
		pre3_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre3_vvd' })",
		pre4_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre4_vvd' })",
		post1_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post1_vvd' })",
		post2_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post2_vvd' })",
		post3_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post3_vvd' })",
		post4_vvd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post4_vvd' })",
		traf_mod_ib	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'traf_mod_ib' })",
		traf_mod_ob	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'traf_mod_ob' })",
		trsp_mod_ib	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trsp_mod_ib' })",
		trsp_mod_ob	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trsp_mod_ob' })",
		trunk_slan_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_slan_cd' })",
		trunk_pod_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_pod_cd' })",
		trunk_pol_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_pol_cd' })",
		trunk_vsl_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_vsl_cd' })",
		first_pol_cutoff_dt	:"cols.push({Type:'Text',     Hidden:0,  Width:110,   Align:'Center',  ColMerge:0,   SaveName:prefix+'first_pol_cutoff_dt' })",
		first_pol_etb	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'first_pol_etb' })",
		first_pol_etd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'first_pol_etd' })",
		first_pol_atd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'first_pol_atd' })",
		last_pod_etb	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'last_pod_etb' })",
		last_pod_eta	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'last_pod_eta' })",
		last_pod_ata	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'last_pod_ata' })",
		rfa_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rfa_no' })",
		sc_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'sc_no' })",
		taa_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'taa_no' })",
		ctrl_atms_flg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrl_atms_flg' })",
		modi_atms_flg	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'modi_atms_flg' })",
		rf_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rf_rmk' })",
		rf_temp	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rf_temp' })",
		vent	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vent' })",
		awk_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_rmk' })",
		awk_grs_wgt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_grs_wgt' })",
		awk_net_wgt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_net_wgt' })",
		awk_ovr_fwrd_len	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ovr_fwrd_len' })",
		awk_ovr_hgt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ovr_hgt' })",
		awk_ovr_lf_len	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ovr_lf_len' })",
		awk_ovr_bkwd_len	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ovr_bkwd_len' })",
		awk_ovr_rt_len	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ovr_rt_len' })",
		awk_ttl_dim_hgt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ttl_dim_hgt' })",
		awk_ttl_dim_len	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ttl_dim_len' })",
		awk_ttl_dim_wdt	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_ttl_dim_wdt' })",
		dg_rmk	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'dg_rmk' })",
		imdg_clss_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'imdg_clss_cd' })",
		imdg_un_no	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:0,   SaveName:prefix+'imdg_un_no'	 })"
	 	}

var arrGridColsTitle1={
		bl_no	:'BKG & B/L Info',
		obl_iss_ofc_cd	:'BKG & B/L Info',
		cre_dt	:'BKG & B/L Info',
		bkg_no	:'BKG & B/L Info',
		bkg_ofc_cd	:'BKG & B/L Info',
		cre_usr_id	:'BKG & B/L Info',
		bkg_sts_cd	:'BKG & B/L Info',
		ctrt_srep_cd	:'BKG & B/L Info',
		ob_srep_cd	:'BKG & B/L Info',
		rate_sts	:'BKG & B/L Info',
		sls_area	:'BKG & B/L Info',
		sls_cd	:'BKG & B/L Info',
		ob_sls_ofc_cd	:'BKG & B/L Info',
		scac_cd	:'BKG & B/L Info',
		spcl_hndl_inst	:'BKG & B/L Info',
		split_flg	:'BKG & B/L Info',
		xter_rmk	:'BKG & B/L Info ',
		inter_rmk	:'BKG & B/L Info ',
		vndr_rmk	:'BKG & B/L Info ',
		lcl_meas_qty	:'Cargo & Commodity',
		lcl_meas_ut_cd	:'Cargo & Commodity',
		cgo_n	:'Cargo & Commodity',
		cgo_wgt_kg	:'Cargo & Commodity',
		cgo_wgt_lb	:'Cargo & Commodity',
		cmdt_cd	:'Cargo & Commodity',
		cmdt_desc	:'Cargo & Commodity',
		cmdt_hs_cd	:'Cargo & Commodity',
		cmdt_hs_grp_cd	:'Cargo & Commodity',
		hts_cd	:'Cargo & Commodity',
		ncm_no	:'Cargo & Commodity',
		lcl_pck_qty	:'Cargo & Commodity',
		ob_cfs_loc	:'Cargo & Commodity',
		lcl_cntr_mf_gds_desc	:'Cargo & Commodity',
		lcl_pck_tp_cd	:'Cargo & Commodity',
		est_pkup_dt	:'Container',
		act_pkup_dt	:'Container',
		est_rtn_dt	:'Container',
		act_rtn_dt	:'Container',
		cgo_cutoff_dt	:'Container',
		cgo_aval_dt	:'Container',
		grs_wgt_kg	:'Container',
		grs_wgt_lb	:'Container',
		cntr_no	:'Container',
		cntr_vol_qty	:'Container',
		teu	:'Container',
		feu	:'Container',
		cntr_tpsz_cd	:'Container',
		cnmv_sts_cd	:'Container',
		cnmv_sts_desc	:'Container',
		tare_wgt	:'Container',
		tare_lbs	:'Container',
		mty_pkup_loc	:'Container',
		mty_rtn_loc	:'Container',
		full_rtn_loc	:'Container',
		ib_pkup_yd_cd	:'Container',
		ib_pkup_yd_nm	:'Container',
		ib_clr_loc_cd	:'Container',
		ib_hlg_bkg	:'Container',
		ob_hlg_bkg	:'Container',
		pck_tp_cd	:'Container',
		pck_qty	:'Container',
		cntr_seal_no	:'Container',
		cntr_seal_cnt	:'Container',
		eq_subst_tp	:'Container',
		wgt_bnd	:'Container',
		c_cust	:'Customer',
		ctrt_cust	:'Customer',
		f_cust	:'Customer',
		f_cntc_nm	:'Customer',
		f_cntc_no	:'Customer',
		f_cnt_cd	:'Customer',
		f_ste_cd	:'Customer',
		s_grp_cust	:'Customer',
		ctrl_pty	:'Customer',
		s_cust_nm	:'Customer',
		s_cntc_nm	:'Customer',
		s_cntc_no	:'Customer',
		ebff_ref_no	:'Reference No',
		ebrf_ref_no	:'Reference No',
		ebsh_ref_no	:'Reference No',
		dg_certi_flg	:'Reference No',
		xpt_decl_rcv	:'Reference No',
		ens_mrn	:'Reference No',
		cmrn_ref_no	:'Reference No',
		exs_mrn	:'Reference No',
		finv_ref_no	:'Reference No',
		aes_itn_no	:'Reference No',
		po_no	:'Reference No',
		rgbk_ref_no	:'Reference No',
		essh_ref_no	:'Reference No',
		esff_ref_no	:'Reference No',
		esrf_ref_no	:'Reference No',
		twn_so_no	:'Reference No',
		si_flg	:'Reference No',
		cucr_ref_no	:'Reference No',
		blck_stwg_cd	:'Route & Schedule',
		t_vvd	:'Route & Schedule',
		t_vsl_nm	:'Route & Schedule',
		trd_cd	:'Route & Schedule',
		svc_scp_cd	:'Route & Schedule',
		de_term_cd	:'Route & Schedule',
		rcv_term_cd	:'Route & Schedule',
		por_cnt_cd	:'Route & Schedule',
		por_cd	:'Route & Schedule',
		por_nm	:'Route & Schedule',
		vvd1_pol_cd	:'Route & Schedule',
		vvd1_pol_nm	:'Route & Schedule',
		vvd2_pol_cd	:'Route & Schedule',
		vvd2_pol_nm	:'Route & Schedule',
		vvd3_pol_cd	:'Route & Schedule',
		vvd3_pol_nm	:'Route & Schedule',
		vvd4_pol_cd	:'Route & Schedule',
		vvd4_pol_nm	:'Route & Schedule',
		vvd1_pod_cd	:'Route & Schedule',
		vvd1_pod_nm	:'Route & Schedule',
		vvd2_pod_cd	:'Route & Schedule',
		vvd2_pod_nm	:'Route & Schedule',
		vvd3_pod_cd	:'Route & Schedule',
		vvd3_pod_nm	:'Route & Schedule',
		vvd4_pod_cd	:'Route & Schedule',
		vvd4_pod_nm	:'Route & Schedule',
		last_pod_cd	:'Route & Schedule',
		last_pod_nm	:'Route & Schedule',
		del_cnt_cd	:'Route & Schedule',
		del_cd	:'Route & Schedule',
		del_nm	:'Route & Schedule',
		pre1_vvd	:'Route & Schedule',
		pre2_vvd	:'Route & Schedule',
		pre3_vvd	:'Route & Schedule',
		pre4_vvd	:'Route & Schedule',
		post1_vvd	:'Route & Schedule',
		post2_vvd	:'Route & Schedule',
		post3_vvd	:'Route & Schedule',
		post4_vvd	:'Route & Schedule',
		traf_mod_ib	:'Route & Schedule',
		traf_mod_ob	:'Route & Schedule',
		trsp_mod_ib	:'Route & Schedule',
		trsp_mod_ob	:'Route & Schedule',
		trunk_slan_cd	:'Route & Schedule',
		trunk_pod_cd	:'Route & Schedule',
		trunk_pol_cd	:'Route & Schedule',
		trunk_vsl_cd	:'Route & Schedule',
		first_pol_cutoff_dt	:'Route & Schedule',
		first_pol_etb	:'Route & Schedule',
		first_pol_etd	:'Route & Schedule',
		first_pol_atd	:'Route & Schedule',
		last_pod_etb	:'Route & Schedule',
		last_pod_eta	:'Route & Schedule',
		last_pod_ata	:'Route & Schedule',
		rfa_no	:'Rate & Invoice',
		sc_no	:'Rate & Invoice',
		taa_no	:'Rate & Invoice',
		ctrl_atms_flg	:'Reefer Info',
		modi_atms_flg	:'Reefer Info',
		rf_rmk	:'Reefer Info',
		rf_temp	:'Reefer Info',
		vent	:'Reefer Info',
		awk_rmk	:'AK Info',
		awk_grs_wgt	:'AK Info',
		awk_net_wgt	:'AK Info',
		awk_ovr_fwrd_len	:'AK Info',
		awk_ovr_hgt	:'AK Info',
		awk_ovr_lf_len	:'AK Info',
		awk_ovr_bkwd_len	:'AK Info',
		awk_ovr_rt_len	:'AK Info',
		awk_ttl_dim_hgt	:'AK Info',
		awk_ttl_dim_len	:'AK Info',
		awk_ttl_dim_wdt	:'AK Info',
		dg_rmk	:'DG Info',
		imdg_clss_cd	:'DG Info',
		imdg_un_no	:'DG Info'
}
var arrGridColsTitle={                  
		bl_no	:'B/L Number',
		obl_iss_ofc_cd	:'B/L Release Office',
		cre_dt	:'Booking Date',
		bkg_no	:'Booking Number',
		bkg_ofc_cd	:'Booking Office',
		cre_usr_id	:'Booking Staff',
		bkg_sts_cd	:'Booking Status',
		ctrt_srep_cd	:'C.SREP',
		ob_srep_cd	:'L.SREP',
		rate_sts	:'Rating Status',
		sls_area	:'Sales Area',
		sls_cd	:'Sales Code',
		ob_sls_ofc_cd	:'Sales Office',
		scac_cd	:'SCAC Code',
		spcl_hndl_inst	:'Special Handling Instructions',
		split_flg	:'Split Booking Permitted',
		xter_rmk	:'Customer Booking Remarks',
		inter_rmk	:'Intl Booking Remarks',
		vndr_rmk	:'Vndr Booking Remarks',
		lcl_meas_qty	:'Cargo Measurement',
		lcl_meas_ut_cd	:'Cargo Measurement Unit',
		cgo_n	:'Cargo Nature',
		cgo_wgt_kg	:'Cargo Weight (KG)',
		cgo_wgt_lb	:'Cargo Weight (LB)',
		cmdt_cd	:'Commodity Code',
		cmdt_desc	:'Commodity Description',
		cmdt_hs_cd	:'HS Code',
		cmdt_hs_grp_cd	:'HS Group',
		hts_cd	:'HTS Code',
		ncm_no	:'NCM Code',
		lcl_pck_qty	:'No. of Packages',
		ob_cfs_loc	:'O/B CFS Location',
		lcl_cntr_mf_gds_desc	:'Package Description',
		lcl_pck_tp_cd	:'Package Type',
		est_pkup_dt	:'Estd Pick Up Date/Time',
		act_pkup_dt	:'Actual Pick Up Date/Time or CVDD',
		est_rtn_dt	:'Estd Return Date/Time',
		act_rtn_dt	:'Actual Return Date/Time or VLPD',
		cgo_cutoff_dt	:'Cargo Cutoff Date/Time',
		cgo_aval_dt	:'Cargo Availability Date/Time',
		grs_wgt_kg	:'Container GRS Weight (KG)',
		grs_wgt_lb	:'Container GRS Weight (LB)',
		cntr_no	:'Container Number',
		cntr_vol_qty	:'Container Quantity',
		teu	:'TEU',
		feu	:'FEU',
		cntr_tpsz_cd	:'Container Size Type',
		cnmv_sts_cd	:'Container Movement Status',
		cnmv_sts_desc	:'Container Movement Status Description',
		tare_wgt	:'Container T/W (KG)',
		tare_lbs	:'Container T/W (LB)',
		mty_pkup_loc	:'Empty Pickup Location',
		mty_rtn_loc	:'Empty Return Location',
		full_rtn_loc	:'Full Return Location',
		ib_pkup_yd_cd	:'IB Cargo Pickup Code',
		ib_pkup_yd_nm	:'IB Cargo Pickup Name',
		ib_clr_loc_cd	:'IB Clearance Location Code',
		ib_hlg_bkg	:'IB Haulage Type',
		ob_hlg_bkg	:'OB Haulage Type',
		pck_tp_cd	:'Package Uni Code',
		pck_qty	:'Piece Count',
		cntr_seal_no	:'Seal Number',
		cntr_seal_cnt	:'Seal Number Count',
		eq_subst_tp	:'Substitution Type',
		wgt_bnd	:'Weight Band',
		c_cust	:'Consignee',
		ctrt_cust	:'Contract /Agreement Owner',
		f_cust	:'Forwarder',
		f_cntc_nm	:'Forwarder Contact Name',
		f_cntc_no	:'Forwarder Contact Number',
		f_cnt_cd	:'Forwarder Country Name',
		f_ste_cd	:'Forwarder State Name',
		s_grp_cust	:'G.Cust (SHPR) Code',
		ctrl_pty	:'Shipment Control Party',
		s_cust_nm	:'Shipper',
		s_cntc_nm	:'Shipper Contact Name',
		s_cntc_no	:'Shipper Contact Number',
		ebff_ref_no	:'BKG FF Ref. No.',
		ebrf_ref_no	:'BKG Ref. No.',
		ebsh_ref_no	:'BKG SH Ref. No.',
		dg_certi_flg	:'DG Certificate Rsvd.',
		xpt_decl_rcv	:'Export Declaration Rcvd.',
		ens_mrn	:'ENS MRN',
		cmrn_ref_no	:'Export MRN No. ',
		exs_mrn	:'EXS MRN',
		finv_ref_no	:'Invoice Ref. No.',
		aes_itn_no	:'ITN Ref. No. ',
		po_no	:'Purchase Order Number',
		rgbk_ref_no	:'Regional BKG No.',
		essh_ref_no	:'S/I SH Ref. No.',
		esff_ref_no	:'S/I FF Ref. No.',
		esrf_ref_no	:'S/I Ref. No.',
		twn_so_no	:'S/O Number',
		si_flg	:'SI & BL Master Rcvd.',
		cucr_ref_no	:'UCR Ref. No.',
		blck_stwg_cd	:'Block Stowage',
		t_vvd	:'Trunk VVD',
		t_vsl_nm	:'Vessel Name',
		trd_cd	:'Trade Code',
		svc_scp_cd	:'Service Scope Code',
		de_term_cd	:'Delivery Term',
		rcv_term_cd	:'Receiving Term',
		por_cnt_cd	:'POR Country',
		por_cd	:'POR Code',
		por_nm	:'POR Name',
		vvd1_pol_cd	:'Pre 1. POL Code',
		vvd1_pol_nm	:'Pre 1. POL Name',
		vvd2_pol_cd	:'Pre 2. POL Code',
		vvd2_pol_nm	:'Pre 2. POL Name',
		vvd3_pol_cd	:'Pre 3. POL Code',
		vvd3_pol_nm	:'Pre 3. POL Name',
		vvd4_pol_cd	:'Pre 4. POL Code',
		vvd4_pol_nm	:'Pre 4. POL Name',
		vvd1_pod_cd	:'Pre 1. POD Code',
		vvd1_pod_nm	:'Pre 1. POD Name',
		vvd2_pod_cd	:'Pre 2. POD Code',
		vvd2_pod_nm	:'Pre 2. POD Name',
		vvd3_pod_cd	:'Pre 3. POD Code',
		vvd3_pod_nm	:'Pre 3. POD Name',
		vvd4_pod_cd	:'Pre 4. POD Code',
		vvd4_pod_nm	:'Pre 4. POD Name',
		last_pod_cd	:'Last POD Code',
		last_pod_nm	:'Last POD Name',
		del_cnt_cd	:'DEL Country',
		del_cd	:'DEL Code',
		del_nm	:'DEL Name',
		pre1_vvd	:'Pre 1.VVD',
		pre2_vvd	:'Pre 2.VVD',
		pre3_vvd	:'Pre 3.VVD',
		pre4_vvd	:'Pre 4.VVD',
		post1_vvd	:'Post 1.VVD',
		post2_vvd	:'Post 2.VVD',
		post3_vvd	:'Post 3.VVD',
		post4_vvd	:'Post 4.VVD',
		traf_mod_ib	:'Traffic Mode I/B',
		traf_mod_ob	:'Traffic Mode O/B',
		trsp_mod_ib	:'Transport Mode I/B',
		trsp_mod_ob	:'Transport Mode O/B',
		trunk_slan_cd	:'Trunk Lane',
		trunk_pod_cd	:'Trunk POD',
		trunk_pol_cd	:'Trunk POL',
		trunk_vsl_cd	:'Trunk Vessel',
		first_pol_cutoff_dt	:'POL Cut-Off Date',
		first_pol_etb	:'Berth at First POL',
		first_pol_etd	:'ETD from First POL',
		first_pol_atd	:'ATD from First POL',
		last_pod_etb	:'Berth at Last POD',
		last_pod_eta	:'ETA at Last POD',
		last_pod_ata	:'ATA at Last POD',
		rfa_no	:'RFA No.',
		sc_no	:'S/C No.',
		taa_no	:'Tariff No.',
		ctrl_atms_flg	:'CA',
		modi_atms_flg	:'MA',
		rf_rmk	:'RF Remarks',
		rf_temp	:'RF Temperature',
		vent	:'Vent',
		awk_rmk	:'AK Remarks',
		awk_grs_wgt	:'GRS Weight (KGS / LBS)',
		awk_net_wgt	:'Net Weight (KGS / LBS)',
		awk_ovr_fwrd_len	:'Over Dimension Front (unit : cm)',
		awk_ovr_hgt	:'Over Dimension Height (unit : cm)',
		awk_ovr_lf_len	:'Over Dimension Left (unit : cm)',
		awk_ovr_bkwd_len	:'Over Dimension Rear (unit : cm)',
		awk_ovr_rt_len	:'Over Dimension Right (unit : cm)',
		awk_ttl_dim_hgt	:'Total Dimension Height (unit : cm)',
		awk_ttl_dim_len	:'Total Dimension Length (unit : cm)',
		awk_ttl_dim_wdt	:'Total Dimension Width (unit : cm)',
		dg_rmk	:'DG Remarks',
		imdg_clss_cd	:'IMDG Class',
		imdg_un_no	:'UN No.'
}
/**
 *  using to create condition of printing RD
 */
var searchOptionsMap={  vvd_cd          :"form.vvd_cd.value",           
						lane_cd			:"form.lane_cd.value",          
						dir_cd			:"dir_cd.GetSelectText()",
						pol_cd			:"form.pol_cd.value",           
						pol_yard_cd		:"form.pol_yard_cd.value",      
						pol_local		:"form.pol_local.checked ? 'T.POL local':''",        
						pol_ts			:"form.pol_ts.checked ? 'POL TS':''",           
						pod_cd			:"form.pod_cd.value",           
						pod_yard_cd		:"form.pod_yard_cd.value",      
						pod_local		:"form.pod_local.checked ? 'T.POd local':''",        
						pod_ts			:"form.pod_ts.checked ? 'POD TS':''",           
						por_cd			:"form.por_cd.value",           
						del_cd			:"form.del_cd.value",           
						r_term			:"r_term.GetSelectText()",
						d_term			:"d_term.GetSelectText()",
						board_from_dt	:"form.board_from_dt.value",    
						board_to_dt		:"form.board_to_dt.value",      
						bkg_from_dt		:"form.bkg_from_dt.value",      
						bkg_to_dt		:"form.bkg_to_dt.value",        
						bkg_kind		:"bkg_kind.GetSelectText()",
						b_ofc_cd		:"form.b_ofc_cd.value",         
						b_staff_id		:"b_staff_id.GetSelectText()",
						ca_flag			:"form.ca_flag.checked ? 'CA':''",          
						bl_rlse_ofc_cd	:"form.bl_rlse_ofc_cd.value",   
						eq_type			:"eq_type.GetSelectText()",
						cmdt_cd			:"form.cmdt_cd.value",          
						cmdt_nm			:"form.cmdt_nm.value",          
						cgo_wgt_from	:"form.cgo_wgt_from.value != '' ? 'CGO Wgt From-' + form.cgo_wgt_from.value + (form.cgo_wgt_kg.checked?' KG':(form.cgo_wgt_lb.checked?' LB':'')):'' ",
						cgo_wgt_to		:"form.cgo_wgt_to.value   != '' ? 'CGO Wgt To-' + form.cgo_wgt_to.value + (form.cgo_wgt_kg.checked?' KG':(form.cgo_wgt_lb.checked?' LB':'')):'' ",         
						grs_wgt_from	:"form.grs_wgt_from.value != '' ? 'GRS Wgt From-' + form.grs_wgt_from.value + (form.grs_wgt_kg.checked?' KG':(form.grs_wgt_lb.checked?' LB':'')):'' ",         
						grs_wgt_to		:"form.grs_wgt_to.value   != '' ? 'GRS Wgt To ' + form.grs_wgt_to.value + (form.grs_wgt_kg.checked?' KG':(form.grs_wgt_lb.checked?' LB':'')):'' ",         
						ctr_rfa_no		:"form.ctr_rfa_no.value",       
						cust_tp_cd_s	:"form.cust_tp_cd_s.checked? 'Shipper':''",     
						cust_tp_cd_c	:"form.cust_tp_cd_c.checked? 'CNT':''",     
						cust_tp_cd_n	:"form.cust_tp_cd_n.checked? 'Notify':''",     
						cust_tp_cd_f	:"form.cust_tp_cd_f.checked? 'Forwarder':''",     
						cust_tp_cd_a	:"form.cust_tp_cd_a.checked? 'Also Notify':''",     
						//SJH.20150129.MOD 
//						cust_tp_cd_g	:"form.cust_tp_cd_g.checked? 'Group Customer':''",   	
//						customer	  	:"form.cust_cnt_cd.value + (form.cust_seq.value != '' ? ' SEQ:'+form.cust_seq.value:'') + (form.cust_nm.value != '' ? ' Name:'+form.cust_nm.value:'') + (cust_tp_cd.GetSelectText()!= '' ? ' Code:'+cust_tp_cd.GetSelectText():'')" ,
//						customer	  	:"form.cust_cnt_cd.value + (form.cust_seq.value != '' ? ' SEQ:'+form.cust_seq.value:'') + (form.cust_nm.value != '' ? ' Name:'+form.cust_nm.value:'') + (form.cust_grp_id.value != '' ? ' Group:'+form.cust_grp_id.value:'')" ,
						customer	  	:"form.cust_cnt_cd.value + (form.cust_seq.value != '' ? ' SEQ:'+form.cust_seq.value:'') + (form.cust_nm.value != '' ? ' Name:'+form.cust_nm.value:'')" ,
						sp_cargo_dg 	:"form.sp_cargo_dg.checked ? 'Danger':''",             
						sp_cargo_rf 	:"form.sp_cargo_rf.checked ? 'Reefer':''",             
						sp_cargo_ak 	:"form.sp_cargo_ak.checked ? 'Awkward':''",            
						sp_cargo_bb 	:"form.sp_cargo_bb.checked ? 'Break Bulk':''",         
						sp_cargo_hg 	:"form.sp_cargo_hg.checked ? 'Hanger':''",             
						sp_cargo_rd 	:"form.sp_cargo_rd.checked ? 'Reefer Dry':''",         
						bkg_sts_cd_f 	:"form.bkg_sts_cd_f.checked ? 'Firm':''",              
						bkg_sts_cd_x 	:"form.bkg_sts_cd_x.checked ? 'Booking Cancel':''",     
						bkg_sts_cd_a 	:"form.bkg_sts_cd_a.checked ? 'Pseudo Booking':''",     
						bkg_sts_cd_w 	:"form.bkg_sts_cd_w.checked ? 'Waiting BKG':''",        
						non_sp_cargo 	:"form.non_sp_cargo.checked ? 'Non Approval Cgo':''",   
						holding  		:"form.holding .checked ? 'Holding':''",
						cntr_sts_cd_en  :"form.cntr_sts_cd_en.checked?'EN':''",
						cntr_sts_cd_op  :"form.cntr_sts_cd_op.checked?'OP':''",
						cntr_sts_cd_ic  :"form.cntr_sts_cd_ic.checked?'IC':''",
						cntr_sts_cd_tn  :"form.cntr_sts_cd_tn.checked?'TN':''",
						cntr_sts_cd_id  :"form.cntr_sts_cd_id.checked?'ID':''",
						cntr_sts_cd_ts  :"form.cntr_sts_cd_ts.checked?'TS':''",
						cntr_sts_cd_mt  :"form.cntr_sts_cd_mt.checked?'MT':''",
						cntr_sts_cd_vs  :"form.cntr_sts_cd_vs.checked?'VS':''",
						cntr_sts_cd_oc  :"form.cntr_sts_cd_oc.checked?'OC':''",
						cntr_sts_cd_vl  :"form.cntr_sts_cd_vl.checked?'VL':''",
						rate_sts_r      :"form.cntr_sts_cd_vl.rate_sts_r?'Rate':''",
						rate_sts_u      :"form.cntr_sts_cd_vl.rate_sts_u?'Unrate':''"
						}
 
/**
 *   the title of searching condition to show when you print
 */
var searchOptionsTitleMap={ vvd_cd           :"form.trunk_flag.checked ? 'T.VVD-':'VVD-'",                
							lane_cd          :"'Lane-'",               
							dir_cd           :"'DIR-'",                
							pol_cd           :"'POL-'",                
							pol_yard_cd      :"'YD-'",                 
							pol_local        :"''",        
							pol_ts           :"''",             
							pod_cd           :"'POD-'",                
							pod_yard_cd      :"'YD-'",                 
							pod_local        :"''",        
							pod_ts           :"''",             
							por_cd           :"'POR-'",                
							del_cd           :"'DEL-'",                
							r_term           :"'R.term-'",                          
							d_term           :"'D.Term-'",             
							board_from_dt    :"'Board From Date-'",     
							board_to_dt      :"'Board To Date-'",      
							bkg_from_dt      :"'BKG Date From-'",     
							bkg_to_dt        :"'BKG Date To-'",       
							bkg_kind         :"'B.Kind-'",             
							b_ofc_cd         :"'BKG OFC-'",            
							b_staff_id       :"'BKG Staff-'",          
							ca_flag          :"''",     
							bl_rlse_ofc_cd   :"'B/L Release OFC-'",              
							eq_type          :"'EQ TP-'",              
							cmdt_cd          :"'CMDT Code-'",          
							cmdt_nm          :"'CMDT Name-'",     
							cgo_wgt_from     :"''",
							cgo_wgt_to       :"''",  
							grs_wgt_from     :"''",
							grs_wgt_to       :"''",  
							ctr_rfa_no       :"form.ctr_rfa_cd[0].checked ? 'Contract No-':'RFA No-'",             
							cust_tp_cd_s     :"''",            
							cust_tp_cd_c     :"''",                
							cust_tp_cd_n     :"''",             
							cust_tp_cd_f     :"''",          
							cust_tp_cd_a     :"''",        
//							cust_tp_cd_g     :"''",					//SJH.20150129.MOD
							customer          :"'CUSTOMER-'",           
							sp_cargo_dg      :"''",             
							sp_cargo_rf      :"''",             
							sp_cargo_ak      :"''",            
							sp_cargo_bb      :"''",         
							sp_cargo_hg      :"''",             
							sp_cargo_rd      :"''",         
							bkg_sts_cd_f     :"''",              
							bkg_sts_cd_x     :"''",     
							bkg_sts_cd_a     :"''",     
							bkg_sts_cd_w     :"''",        
							non_sp_cargo     :"''",   
							holding          :"''",
							cntr_sts_cd_en   :"''",
							cntr_sts_cd_op   :"''",
							cntr_sts_cd_ic   :"''",
							cntr_sts_cd_tn   :"''",
							cntr_sts_cd_id   :"''",
							cntr_sts_cd_ts   :"''",
							cntr_sts_cd_mt   :"''",
							cntr_sts_cd_vs   :"''",
							cntr_sts_cd_oc   :"''",
							cntr_sts_cd_vl   :"''",
							rate_sts_r       :"''",
							rate_sts_u       :"''"
						}
/*
 * orderby Title 
 * */													
//var arrOrderbyTitleMap={ bl_no:'B/L Number',			obl_iss_ofc_cd:'B/L Release Office',	cre_usr_id:'Booking Creator',	cre_dt:'Booking Date',				bkg_no:'Booking Number', 
//						bkg_ofc_cd:'Booking Office',    bkg_pty:'Booking Party',				bkg_rgn:'Booking Region',		bkg_sts_cd:'Booking Status',		c_cust:'Consignee Name', 
//						cntr_no:'Container Number',     cnmv_sts_cd:'Container Status',			f_cust:'Forwarder',				first_ld_port:'First Load Port',	ib_hlg_bkg:'IB Haulage Type', 
//						de_term_cd:'IB Traffic Mode', 	last_dchg_port:'Last Discharge Port',	t_vvd:'Mother VVD',				ob_hlg_bkg:'OB Haulage Type',		rcv_term_cd:'OB Traffic Mode', 
//						rate_sts:'Rating Status',       rd_term:'R/D Term',						sail_dt:'Sailing Date',			sls_area:'Sale Area',				ob_srep_cd:'Sale Representative', 
//						ob_sls_ofc_cd:'Sale Office',    cntr_seal_no:'Seal Number',				s_cust_nm:'Shipper Name',		trsp_mod:'Transport Mode',			rlane_cd:'Trade Lane'                   
//						}
var orderby="";
/*
 * making column for creating OrderBy Title
 * forwarding from js, to make Group at RD 
 * 'POL : '||POL_CD||' / POD : '||POD_CD
 * expected result POL : USLGB / POD : AUBNE  
 * */
/*
 * setting Sort in POP-UP   * */
function setOrderBy(val){
	//alert(val);
	var arrSort=val.split(",");
	var cnt=0;
	var tempStr;
	for(var i=0; i < arrSort.length; i++){
		tempStr=arrSort[i].toLowerCase();
//			if(arrOrderbyTitleMap[tempStr] == undefined){	
//				continue;
//			}
		if(cnt==0){
			orderby=tempStr;
		}else{
			orderby += tempStr;
		}
		if(arrSort.length > 1 && i < arrSort.length-1){
			orderby += ",";
		}			
		cnt++;
	}
}						 
/*
 *  Table Column which is registered to Item Option of screen 104
 * constructing selected thing first, and handling the other to Hidden . 
 * */
var selectedGridCols;
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="sheet1_";//IBSheet divider
 var prefix2="sheet2_";//IBSheet divider
 var sheetObjectsMap=new Array();
 var l_rep_id_cdMultiComboDataAdded=false;
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt=0;
 var comboObjects=new Array();
 var b_staff_idMultiComboDataAdded = false;
 var l_rep_idMultiComboDataAdded=false;
 /*********************** EDTITABLE MULIT COMBO END ********************/
 /*********************** TAB START ********************/
// var tabObjects=new Array();											//::: tab관련 주석
// var tabCnt=0 ;
// var beforetab=1;
 /*********************** TAB START ********************/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * registering the created IBCombo Object at page as comboObjects list
      * calling from ComComboObject method  
      * param : comboObj ==> combo Object
      *
      */
     function setComboObject(combo_obj){
    	 comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
        	 ComConfigSheet (sheetObjects[i] );
        	 initSheet(sheetObjects[i],i+1);
        	 ComEndConfigSheet(sheetObjects[i]);
        	 sheetObjectsMap[sheetObjects[i].id]=sheetObjects[i];
         }
         //initializing MultiCombo
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],comboObjects[k].options.id);
         }
//         for(k=0;k<tabObjects.length;k++){								//::: tab관련 주석
//        	 initTab(tabObjects[k],k+1);
//        	 tabObjects[k].SetSelectedIndex(0);
//         }

         initControl();
         //to prevent fail to load screen, give delay time 0.1 second 
         doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//         ComBtnDisable("btn_ReportTemplate");
     }
	/**
 	 * setting Combo 
 	 * param : comboObj ==> combo Object, comboNo ==> sequence which is ID of comboObject tag
 	 * construct initial module of sheet, as adding case which is a number of combo 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form;
 	    initComboEditable(comboObj, comboId);
 	}
 	
	 // setting multiple combo selection and modification
	 function initComboEditable(combo, comboId){
 	 	with (combo) {
 	 		//alert("comboId = "+comboId);
 	 		if(comboId == "b_staff_id" || comboId == "l_rep_id" || comboId == "report_type" || comboId == "ro_y" ){
 	 			
	 	 		MultiSelect = false;
	 	 		UseAutoComplete = true; 
		 	    UseEdit = false;
 	 		}
 	 		else{
	 	 		MultiSelect = true;
		 	    UseEdit = false;	
 	 		}
 	 	}
	 }
 	 
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
//    function setTabObject(tab_obj){									//::: tab관련 주석
//        tabObjects[tabCnt++]=tab_obj;
//    }
    /**
     * setting Tab 
     * setting item of Tab
     */
//    function initTab(tabObj , tabNo) {
//         switch(tabNo) {
//             case 1:
//                with (tabObj) {
//                    var cnt=0 ;
//					InsertItem("Search");
//					InsertItem("Result");
////					InsertItem("Summary by VVD");
//                }
//             break;
//         }
//    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
//    function tab1_OnChange(tabObj , nItem)									//::: tab관련 주석
//    {
//        var objs=document.all.item("tabLayer");
//	    	objs[nItem].style.display="Inline";	    	
//	    	//--------------- important --------------------------//
//	    	for(var i = 0; i<objs.length; i++){
//	    		  if(i != nItem){
//	    		   objs[i].style.display="none";
//	    		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//	    		  }
//	    		}	    
//	    	//------------------------------------------------------//
//	    	beforetab=nItem;
//    }
    function initControl() {
    	var formObject=document.form;
    	axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- keyboard
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out of focus     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
        axon_event.addListenerForm ('keydown', 'bkg_keydown', formObject);
      //axon_event.addListener ('keydown', 'ComKeyEnter', formObject);
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
/*********************** KEY EVENT START ********************/ 	 
    /**
     * obj key press event handling ::: 20150317.ADD
     */
    function bkg_keydown() {
        var obj=event.srcElement;
        var vKeyCode=event.keyCode;
        if ( vKeyCode == 13 ) {
        	setReportType();
    		doActionIBSheet(sheetObjects[0],document.form,MULTI01);
        }
    }
    
	  /**
     * controlling onBlur of HTML Control .
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "b_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					break;	    		
	    	case "board_from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "board_to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * checking Validation on onFocus event . <br>
	 **/
	function bkg_focus(){
		//Validation 
		switch(ComGetEvent("name")){	
	    	case "board_from_dt":
	    	case "board_to_dt":
	    	case "bkg_from_dt":
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
			default:
					break;
		}
	}  
/*********************** KEY EVENT END ********************/
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;
		var tempSqlCon="";
		var nullMultiComboStr="<SHEET> <DATA COLORDER='val' COLSEPARATOR='�Т�' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
		var roYComboStr="<SHEET> <DATA COLORDER='val|desc' COLSEPARATOR=',' TOTAL='6'> 	<TR><![CDATA[,]]></TR> 	<TR><![CDATA[1,Over 1 time]]></TR> 	<TR><![CDATA[2,Over 2 times]]></TR> 	<TR><![CDATA[3,Over 3 times]]></TR> 	<TR><![CDATA[4,Over 4 times]]></TR> 	<TR><![CDATA[5,Over 5 times]]></TR> </DATA> </SHEET> ";
 	// Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	    	try {
	     		var srcName=ComGetEvent("name");
	     		 if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {
		 				case "btn_New":
		 					document.tempform.reset();
		 					report_type.SetSelectIndex(0);
//		 					var temp=form.p_report_type.value;
		 					initAll(formObject);
//		 					form.p_report_type.value=temp;
		 					for(k=0;k<comboObjects.length;k++){
		 						initCombo(comboObjects[k],comboObjects[k].id);
		 					}
		 					break;
		 				case "btn_ReportTemplate": 		
	 						var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd='+formObject.p_bkg_rpt_knd_cd.value, 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
							break;
		 				case "btn_commodity_pop": 		
							comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
							break;		 								
		 				case "btn_ctr_fra_pop": 		
							var param="?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
	 						ComOpenPopup('/opuscntr/COM_ENS_021.do'+param, 780, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;		 								
		 				case "btn_customer_pop":
		 				  var param="" ;
		 				  param="?cust_cd="+formObject.cust_cnt_cd.value;
		 				  if(formObject.cust_seq.value != ""){
		 				  	param += eval(formObject.cust_seq.value);
		 				  }
		 				  param += "&cust_nm="+formObject.cust_nm.value;	
	 						ComOpenPopup('/opuscntr/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;		
						case "btn_board_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.board_from_dt, formObject.board_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_bkg_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
							break; 			
						//SJH.20150129.MOD
//						case "cust_tp_cd_g":
//							if(form.cust_tp_cd_g.checked){
//								form.cust_tp_cd_s.checked=false;
//								form.cust_tp_cd_c.checked=false;
//								form.cust_tp_cd_n.checked=false;
//								form.cust_tp_cd_f.checked=false;
//								form.cust_tp_cd_a.checked=false;
//							}
//							break; 	
//						case "cust_tp_cd_s":
//							form.cust_tp_cd_g.checked=false;
//							break; 								
//						case "cust_tp_cd_c":
//							form.cust_tp_cd_g.checked=false;
//							break; 								
//						case "cust_tp_cd_n":
//							form.cust_tp_cd_g.checked=false;
//							break; 								
//						case "cust_tp_cd_f":
//							form.cust_tp_cd_g.checked=false;
//							break; 								
//						case "cust_tp_cd_a":
//							form.cust_tp_cd_g.checked=false;
//							break;
						case "pol_local":
							if(formObject.pol_local.checked){
								formObject.pol_ts.checked=false;
							}
							break; 		
						case "pol_ts":
							if(formObject.pol_ts.checked){
								formObject.pol_local.checked=false;
							}
							break; 										
						case "pod_local":
							if(formObject.pod_local.checked){
								formObject.pod_ts.checked=false;
							}
							break; 		
						case "pod_ts":
							if(formObject.pod_ts.checked){
								formObject.pod_local.checked=false;
							}
							break; 										
						case "cgo_wgt_kg":
							if(formObject.cgo_wgt_kg.checked){
								formObject.cgo_wgt_lb.checked=false;
							}
							break; 		
						case "cgo_wgt_lb":
							if(formObject.cgo_wgt_lb.checked){
								formObject.cgo_wgt_kg.checked=false;
							}
							break; 
						case "grs_wgt_kg":
							if(formObject.grs_wgt_kg.checked){
								formObject.grs_wgt_lb.checked=false;
							}
							break; 		
						case "grs_wgt_lb":
							if(formObject.grs_wgt_lb.checked){
								formObject.grs_wgt_kg.checked=false;
							}
							break; 
						case "btn_DownExcel":
						      doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
						    	  
						      break;
						case "btn_DownExcel_Summary":
						  var sheetObj=sheetObjectsMap["summary"];
							if (sheetObj.RowCount()< 1) {
								ComShowCodeMessage("COM12189");
								return;
							}
							var op_sheet=sheetObjectsMap["search_options"];
							//op_sheet.removeAll();
							var row=op_sheet.DataInsert(-1);
							op_sheet.SetCellValue(row, "search_options",getSearchOptions());
 							/*op_sheet.Down2Excel( {DownCols: makeHiddenSkipCol(op_sheet), SheetDesign:1,Merge:1 });
 							sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });*/
 							
							op_sheet.Down2ExcelBuffer(true);  
							op_sheet.Down2Excel({DownCols: makeHiddenSkipCol(op_sheet), SheetDesign:1,Merge:1,SheetName:' search_options' }); 
							sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,SheetName:' Summary by CNTR' }); 
							op_sheet.Down2ExcelBuffer(false);
							
							break;
		 				case "btn_Retrieve":
							setReportType();
		 					options.innerHTML=" * Search Options ["+getSearchOptions()+"]";
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_Direct_Retrieve":
		 					setReportType();
		 					doActionIBSheet(sheetObject1,formObject,MULTI01);
		 					break;
//		 				case "btn_Retrieve_Summary":
//							setReportType();
//		 					options_summary.innerHTML=" * Search Options ["+getSearchOptions()+"]";
//		 					doActionIBSheet(sheetObjectsMap["summary"],formObject,SEARCH04);
//		 					break;
		 				case "btn_Sort":
			 				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=CD30018", "OrderBy", 420,250,false,"scrollbars=no,resizable=yes");
		 				  break;  
						//SJH.20150129.ADD
//		 				case "btn_cust_grp_pop":
//			 				ComOpenPopup('/opuscntr/COM_COM_0006.do', 770, 430, 'setCustGrp', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
//							break;		 				  
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e);
		    		}
	     	}
    }
    /*
     *  setting type of reporting
     */
    function setReportType() {
//		if(report_type.GetSelectText()== "General" || selectColList ==""){			//SJH.20150303.MOD
//        	form.p_report_type.value="G";
//        }else{
//        	form.p_report_type.value="P";
//        }
    }
	/***
	 * creating option of searching
	 */
	function  getSearchOptions(){
		var options="";
		var temp="";
		for (var key in searchOptionsMap){ //creating other column header
			temp=eval(searchOptionsMap[key]);
			if(temp != "") {
				options += eval(searchOptionsTitleMap[key])+temp + "  |  ";
			}
		}
	    return options.substring(0,options.length-5);
	}
	// handling of Sheet 
     var arrMultiCombo;// variable to set multi combo
     
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
				case IBSEARCH:      
		 				if(!validateForm(sheetObj,formObj,sAction)) return;
//		 				tab1.SetSelectedIndex(1);//  changing result tab				//::: tab관련 주석
		 				formObj.f_cmd.value=SEARCH;
		 				/**
		 				 * initializing paging variable
		 				 */
						formObj.orderby.value=orderby;
						sheetObjects[1].RemoveAll();
						ttl_cntr.value="";							  
						ttl_pck .value="";							  
						ttl_teu.value="";							  
						ttl_feu.value="";							  
						ttl_grs_kg.value="";	
						ttl_grs_lb.value="";	
						ttl_tare_kg.value="";
						ttl_tare_lb.value="";
						ttl_cgo_kg.value="";
						ttl_cgo_lb.value="";
						pagedMaxCnt=sheetObj.HeaderRows();// initializing variable to change color
						
 						var sXml=sheetObj.GetSearchData("ESM_BKG_1701GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
 						
						sheetObjects[0].SetWaitImageVisible(1);
						sheet1.LoadSearchData(sXml,{Sync:1} );
						sheetObjects[0].SetWaitImageVisible(0);

						if(ComGetEtcData(sXml, "ttl_bkg") == undefined) return;
						ttl_cntr.value=ComGetEtcData(sXml, "ttl_cntr");							  
						ttl_pck .value=ComGetEtcData(sXml, "ttl_pck");							  
						ttl_teu.value=ComGetEtcData(sXml, "ttl_teu");							  
						ttl_feu.value=ComGetEtcData(sXml, "ttl_feu");	
						ttl_grs_kg.value=ComGetEtcData(sXml, "ttl_grs_kg");							  
						ttl_grs_lb.value=ComGetEtcData(sXml, "ttl_grs_lb");								  
						ttl_tare_kg.value=ComGetEtcData(sXml, "ttl_tare_kg");
						ttl_tare_lb.value=ComGetEtcData(sXml, "ttl_tare_lb");
						ttl_cgo_kg.value=ComGetEtcData(sXml, "ttl_cgo_kg");
						ttl_cgo_lb.value=ComGetEtcData(sXml, "ttl_cgo_lb");
					break; 
					
				case MULTI01:      
	 				if(!validateForm(sheetObj,formObj,sAction)) return;
					formObj.orderby.value=orderby;
					sheetObjects[1].RemoveAll();
					
					formObj.f_cmd.value=MULTI01;
		            formObj.target="_top";
		            formObj.action="ESM_BKG_1701DL.do?"+FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		            formObj.submit();
		            sheetObj.RemoveEtcData(); // Delete ETC data
					
				break; 
						
//						case SEARCH04:      
//				 				if(!validateForm(sheetObj,formObj,sAction)) return;
//				 				formObj.f_cmd.value=SEARCH04;
//								formObj.orderby.value=orderby;
//								//sheetObj.RemoveAll();
// 								var sXml=sheetObj.GetSearchData("ESM_BKG_1701GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//								sheetObj.LoadSearchData(sXml,{Sync:1} );
//							break; 
							
	 			case SEARCH01:     
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
					arrMultiCombo=sXml.split("|$$|");	
					initAll(formObj);
					initReportType();
					setConditionAndInitSheet(report_type.GetSelectCode());
					break;
					
	 			case SEARCH02:      //Staff List 
					formObj.f_cmd.value=SEARCH02;
					var p_ofc_cd="";
					var p_ofc_gubun="";
					if(subGubun =="b_ofc_cd"){
						p_ofc_cd=formObj.b_ofc_cd.value;
						p_ofc_gubun="BO";
					}
					var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
					if(subGubun =="b_ofc_cd"){
						ComXml2ComboItem(sXml, b_staff_id, "usr_id", "usr_id");
					}
					break;
					
				case IBDOWNEXCEL:   
					if (sheetObj.RowCount()< 1) {
						ComShowCodeMessage("COM12189");
						return;
					}
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					break;
         }
     }

	  /*
      *   variable which is to handle as the number of searching result after handling paging
      *   initial value = the number of sheet header
      */ 
      var pagedMaxCnt=2; 
	  /**
       * handling event after searching>>> changing font color
       */ 
     function sheet1_OnSearchEnd(sheetObj, Code , ErrMsg) {
 		sheetObj.SetColFontUnderline(prefix+"bkg_no",1);
// 		sheetObj.SetColFontUnderline(prefix+"bl_no",1);
		sheetObj.SetColFontColor(prefix+"bkg_no","#0000FF");
//		sheetObj.SetColFontColor(prefix+"bl_no","#0000FF");
    	 
    	pagedMaxCnt=sheetObj.LastRow();
     }

     function summary_OnSearchEnd(sheetObj, Code , ErrMsg) {
    	 for( var idx=2; idx <= sheetObj.LastRow(); idx++){
    		 if( sheetObj.GetCellValue( idx , "sheet1_tp_sz") == "" ){
    			 sheetObj.SetRowHidden(idx , 1);
    		 }
    	 }
     }

		/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    	 if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
    		 if(ComTrim(sheetObj.GetCellValue(rowIdx, prefix+"bkg_no")) == "") return;
    		 comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, prefix+"bkg_no"));
//    	 }else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
//    		 var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no");
//    		 ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");     			
 		}
     }
     
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    		case MULTI01:													//SJH.20150303.ADD
    			if((formObj.cgo_wgt_from.value!=""||formObj.cgo_wgt_to.value!="") && !formObj.cgo_wgt_kg.checked && formObj.cgo_wgt_lb.checked){
    				ComShowCodeMessage('COM12113', 'Cargo Weight Unit');
    				return false;
    			}
    			if((formObj.grs_wgt_from.value!=""||formObj.grs_wgt_to.value!="") && !formObj.cgo_wgt_kg.checked && !formObj.cgo_wgt_lb.checked){
    				ComShowCodeMessage('COM12113', 'Gross Weight Unit');
    				return false;
    			}
    			if (!ComIsNull(formObj.vvd_cd)) {
    				return true;//if vvd is entered, other conditions are not required.
    			}else if (!ComIsNull(formObj.board_from_dt) && !ComIsNull(formObj.board_to_dt) && !ComIsNull(formObj.pol_cd)){
    				if(!ComBkgMonthsBetweenCheck(formObj.board_from_dt.value,formObj.board_to_dt.value, "1")) {
                        ComShowCodeMessage('COM132001','Sail Date','1Month');
                        ComSetFocus(formObj.board_to_dt);
                        return false;    					
    				}
//    				if(ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) > 31){//2015.02.24 테스트 기간 동안 임시로 한달 수정
//    					ComShowCodeMessage('COM132001','Sail Date','31Days');
//    					return false;
//    				}
    				return true;//if sailing date and pol are entered, other conditions are not required.
    			}else if (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) && !ComIsNull(formObj.b_ofc_cd)){
    				if(!ComBkgMonthsBetweenCheck(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value, "1")) {
                        ComShowCodeMessage('COM132001','Booking Date','1Month');
                        ComSetFocus(formObj.bkg_to_dt);
                        return false;    					
    				}
    				return true;//if booking date and booking office are entered, other conditions are not required.
    			//SJH.20150129.ADD
    			}else if (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) && !ComIsNull(formObj.pol_cd)){
    				if(!ComBkgMonthsBetweenCheck(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value, "1")) {
                        ComShowCodeMessage('COM132001','Booking Date','1Month');
                        ComSetFocus(formObj.bkg_to_dt);
                        return false;    					
    				}
    				return true;//if booking date and booking office are entered, other conditions are not required.    			
    			}
    			//SJH.20150129.MOD
    			ComShowCodeMessage('BKG00626','VVD or Sail Date & POL or Booking Date & BKG Office or Booking Date & POL');
    			formObj.vvd_cd.focus();
    			return false;    					
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
/*############################# combo onchage start ########################*/
/**
	 *  checking the inserting value at MultiCombo is added value or not
	 *  registering the inserting value to change upper
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
//		initAll(document.form);
//		setConditionAndInitSheet(comboObj.GetSelectCode());
		if(rptIdArr != null){
			document.form.rpt_id.value = rptIdArr[newindex];
		}
	}
	
	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject=document.form;  
		//  changing the input value to upper case
   	 	var comboText=comboObj.GetSelectText().toUpperCase();
   	 	//  deleting if it is registered before
   	 	if (multiComboDataAddedFlag) { 
 	 			comboObj.DeleteItem(0);
	 			multiComboDataAddedFlag=false; 
   	 	} 
   	 	//  return if selected or inserted value is in the combo
    	 	if (comboObj.FindItem(comboText, 0) != -1) {
   	 		return; 
   	 	} 
   	 	comboObj.InsertItem(0, comboText, comboText); 
 		multiComboDataAddedFlag=true; // registering combo to inserting value(global variable) 
 		comboObj.SetSelectText(comboText,false);//  inserting value can be selected
	 }
/*############################# combo onchage end ########################*/		
	/*
	 *  initializing all condition
	 * */
	function initAll(formObject){
		form.reset();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		/**
		 * start of initializing the paging variable
		 */
		/*
		*   result value of current order by column
		*  when it handle paging, don't create title of the order by if it is same before
	  */
		/**
		 * End of initializing the paging variable
		 */		
		ComXml2ComboItem(nullMultiComboStr, formObject.b_staff_id, "val", "val");
		
		ComXml2ComboItem(arrMultiCombo[0], dir_cd,      "val", "val");
		ComXml2ComboItem(arrMultiCombo[1], r_term,      "val", "val");
		ComXml2ComboItem(arrMultiCombo[2], d_term,      "val", "val");
//		ComXml2ComboItem(arrMultiCombo[3], deli_mode,   "val", "name");
		ComXml2ComboItem(arrMultiCombo[4], bkg_kind,    "desc", "desc");
		ComXml2ComboItem(arrMultiCombo[5], eq_type,     "cntr_tpsz_cd", "cntr_tpsz_cd");
//		ComXml2ComboItem(arrMultiCombo[6], s_mode_ori,  "val", "val");
//		ComXml2ComboItem(arrMultiCombo[6], s_mode_dest, "val", "val");
//		ComXml2ComboItem(arrMultiCombo[7], s_route_ori, "val", "val");
//		ComXml2ComboItem(arrMultiCombo[7], s_route_dest,"val", "val");
//		ComXml2ComboItem(arrMultiCombo[8], cust_tp_cd,  "val", "val");			//SJH.20150129.MOD
		
		dir_cd.SetMultiSelect(1);
		dir_cd.SetMultiSeparator(",");	
		r_term.SetMultiSelect(1);
		r_term.SetMultiSeparator(",");		
		d_term.SetMultiSelect(1);
		d_term.SetMultiSeparator(",");
		bkg_kind.SetMultiSelect(1);
		bkg_kind.SetMultiSeparator(",");
		eq_type.SetMultiSelect(1);
		eq_type.SetMultiSeparator(",");
//		cust_tp_cd.SetMultiSelect(1);											//SJH.20150129.MOD
//		cust_tp_cd.SetMultiSeparator(",");		
		
	}
	
	var rptIdArr;
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[8], report_type, "sql_ctnt_col_nm", "rpt_nm");
		var arr=ComBkgXml2Array(arrMultiCombo[8], "rpt_nm");
		if(arr == undefined) return;
		
		var rptIdStr = ComXml2ComboString(arrMultiCombo[8], "rpt_id", "rpt_id")[0];
		rptIdArr = rptIdStr.split("|");

		report_type.SetSelectIndex(0);
	}
	var selectColList="";//saved grid column list which is each type of report
    /**
     * condition setting and init Sheet
     */ 
	function setConditionAndInitSheet(sqlCtnt){
	//  	 alert(sqlCtnt);
	  	 //debug.innerHTML=ComReplaceStr(sqlCtnt, "<", "&lt;");
	  	 //return;
	  	var arrSqlCtntColnm=sqlCtnt.URLDecode().split("@@");
	  	//alert(arrSqlCtntColnm.length);
	  	//return;
	  	var arrSqlCtnt=arrSqlCtntColnm[0].URLDecode().split("|");
	   	var formNameValue ; 
	  	var field;
	  	try{
		   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
		   			formNameValue=arrSqlCtnt[i].split("=");
		   			if(formNameValue[1] =="") continue;
		   			if(arrFormElementMap[formNameValue[0]] == "check"){
							eval("form."+formNameValue[0]).checked=true;
						}else if(arrFormElementMap[formNameValue[0]] == "radio"){
							field=eval("form."+formNameValue[0]);
								for(var j=0; j < field.length; j++) {
									if(field[j].value == formNameValue[1]){
										field[j].checked=true;
										break;
									}
								}
						}else if(arrFormElementMap[formNameValue[0]] == "select"){
							field=eval("form."+formNameValue[0]);
								for(var j=0; j < field.length; j++) {
									if(field[j].value == formNameValue[1]){
										field[j].selected=true;
										break;
									}
								}
						}else if(arrFormElementMap[formNameValue[0]] == "combo"){
							eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						}else if(arrFormElementMap[formNameValue[0]] == "multi"){
							eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						}else{
							field=eval("form."+formNameValue[0]);
						  field.value=formNameValue[1];
						  if(field.name == "b_ofc_cd")
						  	doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
		   			}
		   	}//end for
	  	}catch(e){}
	  	/*
	  	 * re-loading Grid with Report Type
	  	 * */
	  	/*console.log("arrSqlCtntColnm length 0 : " + arrSqlCtntColnm[0]);
	  	console.log("arrSqlCtntColnm length 1: " + arrSqlCtntColnm[1]);
	  	console.log("arrSqlCtntColnm : "+ arrSqlCtntColnm);*/
	  	if(arrSqlCtntColnm.length > 1){
		  	selectColList=arrSqlCtntColnm[1];
		  	initSheetDynamic(sheetObjects[0],selectColList);
	  	}else{
		  	selectColList="";
		  	initSheetDynamic(sheetObjects[0],selectColList); 
	  	}
	}
	
	/*
	 *   searching after modifying Report Template
	 * */
	function setParent(){
		sheetObjects[0].RemoveAll();
		sheetObjects[0].Reset();
		sheetObjects[1].RemoveAll();
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	}
	/*
	 * method which is setting the result of Customer
	 * */
	function setCustomer(val){
		var c_cd=val[0][3];
		var c_name=val[0][4];
		form.cust_cnt_cd.value=c_cd.substring(0,2);
		form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
		form.cust_nm.value=c_name;
	} 
	/*
	 * SJH.20150129.ADD
	 * */
//	function setCustGrp(val){
//		form.cust_grp_id.value=val[0][2];
//	}			
	 /**
	 * searching code to input Commodity Code   .<br>
	 * @param {arry} aryPopupData
	 */
	function setCallBack0653(aryPopupData) {
		var formObject=document.form;
		formObject.cmdt_cd.value=aryPopupData[0][3];
		//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
		formObject.cmdt_nm.value=aryPopupData[0][4];
	}
	/**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function initSheet(sheetObj,sheetNo,ColList) {
         var cnt=0;
         switch(sheetObj.id) {
            case "sheet1":
            	            	
                initSheetDynamic(sheetObjects[0],"");
                break;
            case "summary":
                with(sheetObj){       
					var HeadTitle1="TP/SZ|Full Container|Full Container|Empty Reposition container|Empty Reposition container|Revenue Empty Container|Revenue Empty Container|Total Container|Total Container|No of BKG";
					var HeadTitle2="TP/SZ|BKG Q'ty|TEU|BKG Q'ty|TEU|BKG Q'ty|TEU|BKG Q'ty|TEU|No of BKG";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"tp_sz",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"f_bkg_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"f_teu",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"p_bkg_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"p_teu",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"r_bkg_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"r_teu",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"t_bkg_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"t_teu",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bkg_cnt",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					 
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(442);
					SetCountPosition(0);
                    }
                break;
			case "search_options":
			        with(sheetObj){			
						  var HeadTitle1="Search Options";
						  var headCount=ComCountHeadTitle(HeadTitle1);
						
						  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						  InitHeaders(headers, info);
						
						  var cols = [ {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"search_options" } ];
						   
						  InitColumns(cols);						
						  SetEditable(0);
						  SetCountPosition(0);//[1/3]page
						  SetSheetHeight(100);
			
	                    }
					break;


			break;
         }//end case
     }
    /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheetDynamic(sheetObj,ColList) {
    	 
     	 //sheetObj = sheetObj.Reset();
    	 var sheetNo = parseInt(sheetObj.id.charAt(sheetObj.id.length-1))-1;
    	 sheetObjects[sheetNo] = sheetObjects[sheetNo].Reset();
    	 sheetObj = sheetObjects[sheetNo];
    	 
    	 var cnt=0;
    	 
    	 if(report_type.GetSelectText()== "General" || ColList ==""){
    		 form.p_grid_type.value="G";//General - fixed Grid 
    		 with(sheetObj){
    			 var HeadTitle1="No.";
    			 var HeadTitle2="No.";
    			 for (var key in arrGridColsTitle){ //creating header of other column
    				 HeadTitle1 += "|"+ arrGridColsTitle1[key];
    				 HeadTitle2 += "|"+ arrGridColsTitle[key];
    			 }
    			 
    			 SetConfig( { SearchMode:2,  MergeSheet:5, FrozenCol:0, DataRowMerge:0 } );
    			 
    			 var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
    			 var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
    			 InitHeaders(headers, info);		
    			 
    			 var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"no" }];
    			 for (var key in arrGridColsProp){ //setting attribute of other column
    				 eval(arrGridColsProp[key]);
    				 SetColHidden(prefix + key,1);
    			 }
    			 InitColumns(cols);
    			 
    			 SetEditable(0);
    			 SetSheetHeight(441);
    		 }
    	 }else{
			 form.p_grid_type.value="P";//Private - Grid   
			 selectedGridCols=new Array();//initializing
			 with(sheetObj){
    			 var HeadTitle1="No.";
    			 var HeadTitle2="No.";
    			 var arrColList=ColList.split("|");
    			 var tempName="";
    			 var tempCnt=0;
    			 for(var index=0; index < arrColList.length; index++) {
    				 tempName=arrColList[index].split(">")[1].toLowerCase();
    				 if(arrGridColsTitle[tempName] == undefined) {
    					 continue;
    				 }
    				 HeadTitle1 += "|"+ arrGridColsTitle1[tempName]; //creating selected column header
    				 HeadTitle2 += "|"+ arrGridColsTitle[tempName]; //creating selected column header
    				 selectedGridCols[tempName]="Y";//selected grid column- except when other header and attribute are defined
    				 tempCnt++;
    			 }
    			 
//        			 for (var key in arrGridColsTitle){ //creating header of other column
//        				 if(selectedGridCols[key] != undefined) {
//        					 continue;
//        				 }
//        				 HeadTitle1 += "|"+ arrGridColsTitle[key];
//        			 }
    			 
    			 SetConfig( { SearchMode:2,  MergeSheet:5, FrozenCol:0, DataRowMerge:0 } );
    			 
    			 var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
    			 var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
    			 InitHeaders(headers, info);		

    			 var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"no" }];
    			 //var count = 0;	
    			 for (var key in selectedGridCols){ //setting attribute of the selected header column
    				 if(arrGridColsProp[key] == undefined) {
    					 continue;
    				 }
    				 eval(arrGridColsProp[key]);
    				 SetColHidden(prefix + key,1);
    			 }
    			 
    			 InitColumns(cols);
					  
//        			 for (var key in arrGridColsProp){ //setting attribute of other column
//        				 if(selectedGridCols[key] != undefined) {
//        					 continue;
//        				 }				 
//        				 eval(arrGridColsProp[key]);
//        				 SetColHidden(prefix + key,1);
//        			 }
    			 SetEditable(0);
    			 SetCountPosition(0);
    			 SetSheetHeight(441);
			 }
    	 }
     }
     
     //대문자로 입력 변환
	 function onlyText(obj){
		 val=obj.value;
		 re=/[^a-zA-Z]/gi;
		 //alert("Please input text only");
		 obj.value=val.replace(re,"");
	 }
     
	/* the end of developer's work */    
