/*=========================================================
 * Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0103.js
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
var arrFormElementMap={vvd_cd:'input',       trunk_flag:'check',     lane_cd:'input',			 dir_cd:'multi',				 pol_cd:'input', 
					 pol_yard_cd:'input',  pol_local:'check',      pol_ts:'check',			 pod_cd:'input',				 pod_yard_cd:'input', 
					 pod_local:'check',    pod_ts:'check',         por_cd:'input',			 del_cd:'input',				 r_term:'multi', 
					 d_term:'multi',       zone_cd:'select',       deli_mode:'multi',		 board_from_dt:'input',  board_to_dt:'input', 
					 bkg_from_dt:'input',  bkg_to_dt:'input',      bkg_kind:'multi',		 b_ofc_cd:'input',       b_ofc_cd_sub:'check', 
					 b_staff_id:'combo',   ca_flag:'check',        agent_cd:'input',		 agent_cd_all:'check',   eq_type:'multi', 
					 cmdt_cd:'input',      cmdt_nm:'input',        wgt_from:'input',		 wgt_to:'input',         so_no:'input', 
					 l_ofc_cd:'input',     l_ofc_cd_sub:'check',   dept_cd:'input',			 l_rep_id:'combo',       c_ofc_cd:'input', 
					 c_ofc_cd_sub:'check', c_rep_id:'input',       ctr_rfa_cd:'radio',	 ctr_rfa_no:'input',     s_mode_ori:'multi', 
					 s_mode_dest:'multi',  s_route_ori:'multi',    s_route_dest:'multi', fv_pre_pst_cd:'radio',  fv_vvd_cd:'input', 
					 fv_pol_cd:'input',    fv_pol_yard_cd:'input', fv_pol_local:'check', fv_pod_cd:'input',      fv_pod_yard_cd:'input', 
					 fv_pod_local:'check', cust_tp_cd_s:'check',   cust_tp_cd_c:'check', cust_tp_cd_n:'check',   cust_tp_cd_f:'check', 
					 cust_tp_cd_a:'check', cust_tp_cd_g:'check',   cust_cnt_cd:'input',  cust_seq:'input',       cust_nm:'input', 
//					 cust_tp_cd:'multi',   
					 sp_cargo_dg:'check',    sp_cargo_rf:'check',  sp_cargo_ak:'check',    sp_cargo_bb:'check', 
					 sp_cargo_hg:'check',  sp_cargo_soc:'check',   sp_cargo_eq:'check',  sp_cargo_rd:'check',    sp_cargo_pm:'check', 
					 sp_cargo_pc:'check',  sp_cargo_fg:'check',    sp_cargo_hd:'check',  sp_cargo_rb:'check',    cargo_tp_f:'check', 
					 cargo_tp_p:'check',   cargo_tp_r:'check',     bkg_sts_cd_f:'check', bkg_sts_cd_x:'check',   bkg_sts_cd_a:'check', 
					 bkg_sts_cd_w:'check', non_sp_cargo:'check',   holding:'check',      bl_type_a:'check',      bl_type_s:'check', 
					 rev:'check',          non_rev:'check',        aes_y:'check',        aes_n:'check',          stop_cargo:'check', 
					 ro_y:'multi',                                 caed_y:'check',       caed_n:'check',         crn_no_flag:'check', 
					 certi_y:'check',      certi_n:'check',        certi_d:'check',      certi_a:'check',        certi_b:'check',
					 certi_g:'check',      certi_c:'check'
                    }
/*
 * defining attribute of grid column
 * */                     
var arrGridColsProp={bkg_sts_cd :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_sts_cd' })",          
		si_flg                 :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'si_flg' })",              
		bkg_no                 :"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_no' })",              
		shpr_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'shpr_name' })",          
		por_cd                 :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'por_cd' })",              
		rep                    :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rep' })",                 
		teu                    :"cols.push({Type:'Float',     Hidden:0,  Width:55,   Align:'Right',   ColMerge:0,   SaveName:prefix+'teu',   KeyField:0,   CalcLogic:'',   Format:'Float',       PointCount:3 })",                         
		bkg_mea_qty            :"cols.push({Type:'Float',     Hidden:0,  Width:95,   Align:'Right',   ColMerge:0,   SaveName:prefix+'bkg_mea_qty', KeyField:0,   CalcLogic:'',   Format:'Float',       PointCount:3 })",           
		pck_tp_cd              :"cols.push({Type:'Text',     Hidden:0,  Width:50,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pck_tp_cd' })",           
		dcgo_flg               :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'dcgo_flg' })",            
		rc_flg                 :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rc_flg' })",              
		fd_grd_flg             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'fd_grd_flg' })",          
		itn_flg                :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'itn_flg' })",             
		caed_flg               :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'caed_flg' })",            
		bkg_ofc_cd             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_ofc_cd' })",          
		ctrt_ofc_cd            :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrt_ofc_cd' })",         
		ob_sls_ofc_cd          :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_sls_ofc_cd' })",       
		remark                 :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'remark' })",             
		sc_no                  :"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Center',  ColMerge:0,   SaveName:prefix+'sc_no' })",              
		bdr_flg                :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bdr_flg' })",       
		bl_no                  :"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bl_no' })",              
		cnee_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'cnee_name' })",        
		del_cd                 :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'del_cd' })",
		commodity          	   :"cols.push({Type:'Text',     Hidden:0,  Width:120,   Align:'Center',  ColMerge:0,   SaveName:prefix+'commodity' })",          
		feu                    :"cols.push({Type:'Float',     Hidden:0,  Width:55,   Align:'Right',   ColMerge:0,   SaveName:prefix+'feu', KeyField:0,   CalcLogic:'', Format:'Float', PointCount:3 })",               
		bkg_actwgt_qty         :"cols.push({Type:'Float',     Hidden:0,  Width:95,   Align:'Right',   ColMerge:0,   SaveName:prefix+'bkg_actwgt_qty', KeyField:0, CalcLogic:'', Format:'Float', PointCount:3 })",      
		rcv_term_cd            :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rcv_term_cd' })",
		de_term_cd             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'de_term_cd' })",         
		awk_cgo_flg            :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'awk_cgo_flg' })",         
		bb_cgo_flg             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bb_cgo_flg' })",          
		pc                     :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pc' })",                  
		itn_type               :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'itn_type' })",
		caed_type              :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'caed_type' })",           
		doc_usr_id             :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Left',    ColMerge:0,   SaveName:prefix+'doc_usr_id' })",          
		ctrt_srep_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ctrt_srep_cd' })",        
		ob_srep_cd             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'ob_srep_cd' })",          
		rfa_no                 :"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rfa_no' })",              
		trunk_vvd              :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_vvd' })",           
		org_trns_svc_mod_cd    :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'org_trns_svc_mod_cd' })",
		dest_trns_svc_mod_cd   :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'dest_trns_svc_mod_cd' })",
		del_nod_cd             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'del_nod_cd' })",
		por_nod_cd             :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'por_nod_cd' })",          
		fnl_dest_cd            :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'fnl_dest_cd' })",       
		slan_cd                :"cols.push({Type:'Text',     Hidden:0,  Width:50,   Align:'Center',  ColMerge:0,   SaveName:prefix+'slan_cd' })", 
		bkg_cre_dt             :"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_cre_dt' })",
		cmdt_cd                :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'cmdt_cd' })",
		pol_cd                 :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pol_cd' })",
		pod_cd                 :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pod_cd' })",
		shipper                :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:0,   SaveName:prefix+'shipper' })",
		consignee              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:0,   SaveName:prefix+'consignee' })",
		ntfy                   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:0,   SaveName:prefix+'ntfy' })",
		ffdr                   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:0,   SaveName:prefix+'ffdr' })",
		pre_1_vvd              :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_1_vvd' })",
		pre_2_vvd              :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_2_vvd' })",
		pre_3_vvd              :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_3_vvd' })",
		pre_4_vvd              :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_4_vvd' })",
		post_1_vvd             :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post_1_vvd' })",
		post_2_vvd             :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post_2_vvd' })",
		post_3_vvd             :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post_3_vvd' })",
		post_4_vvd             :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'post_4_vvd' })",
		pre_1_pol_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_1_pol_cd' })",
		pre_2_pol_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_2_pol_cd' })",
		pre_3_pol_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_3_pol_cd' })",
		pre_4_pol_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_4_pol_cd' })",
		pre_1_pod_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_1_pod_cd' })",
		pre_2_pod_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_2_pod_cd' })",
		pre_3_pod_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_3_pod_cd' })",
		pre_4_pod_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'pre_4_pod_cd' })",
		bkg_clz_flg            :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_clz_flg' })",
		ntfy_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'ntfy_name' })",
		anty_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'anty_name' })",
		ffdr_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'ffdr_name' })",
		expt_name              :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'expt_name' })",
		hngr_flg               :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'hngr_flg' })",
		soc_flg                :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'soc_flg' })",
		eq_subst_flg           :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'eq_subst_flg' })",
		rd_cgo_flg             :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'rd_cgo_flg' })",
		trunk_pol              :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_pol' })",
		trunk_pod              :"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:0,   SaveName:prefix+'trunk_pod' })",
		hot_de_flg             :"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:0,   SaveName:prefix+'hot_de_flg' })",
		bkg_ctrl_ofc_cd        :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'bkg_ctrl_ofc_cd' })",
		eq_ctrl_ofc_cd         :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:prefix+'eq_ctrl_ofc_cd' })",
		cntr_tpsz_cd           :"cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Left',    ColMerge:0,   SaveName:prefix+'cntr_tpsz_cd' })",
		cntr_no                :"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Left',    ColMerge:0,   SaveName:prefix+'cntr_no' })",
		aes_no                 :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'aes_no' })",
		caed_no                :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:0,   SaveName:prefix+'caed_no' })",
		shp_call_no            :"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:0,   SaveName:prefix+'shp_call_no' })",
		vsl_eng_nm             :"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:0,   SaveName:prefix+'vsl_eng_nm' })",
		s_addr				   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'s_addr' })",
		c_addr				   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'c_addr' })",
		n_addr				   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'n_addr' })",        
        ofc_team_cd			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'ofc_team_cd' })",		
        inter_remark		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'inter_remark' })",
        remark_detail		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'remark_detail' })",		
        inter_remark_detail	   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'inter_remark_detail' })",
        actual_pol			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'actual_pol' })",
        actual_pod			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'actual_pod' })",		
        por_nod_cd		       :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'por_nod_cd' })",
        blck_stwg_cd	 	   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'blck_stwg_cd' })",		
        act_cust_code		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'act_cust_code' })",
        act_cust_name		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'act_cust_name' })",		
        shp_call_no			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'shp_call_no' })",
        frt_term_cd			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'frt_term_cd' })",		
        chg_term_cd			   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'chg_term_cd' })",
        chg_inter_remark	   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'chg_inter_remark' })",		
        chg_inter_remark_detail:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'chg_inter_remark_detail' })",		
        chg_xter_remark		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'chg_xter_remark' })",		
        chg_xter_remark_detail :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'chg_xter_remark_detail' })",		
        rate_chk_sts		   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'rate_chk_sts' })",        
        sail_dt				   :"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:0,   SaveName:prefix+'sail_dt' })"	
	 	}

var arrGridColsTitle={                  
					bkg_sts_cd           :'BST',                  
					si_flg               :'SR',                   
					bkg_no               :'Booking No',           
					shpr_name            :'Shipper',              
					por_cd               :'POR',                  
					rep                  :'REP',                  
					teu                  :'TEU',                  
					bkg_mea_qty          :'MEA(CBM)',             
					pck_tp_cd            :'PKG',                  
					dcgo_flg             :'DG',                   
					rc_flg               :'RF',                   
					fd_grd_flg           :'FG',                   
					itn_flg              :'ITN',                  
					caed_flg             :'CAED',                 
					bkg_ofc_cd           :'B.OFC',                
					ctrt_ofc_cd          :'C.OFC',                
					ob_sls_ofc_cd        :'L.OFC',                
					remark               :'External Remark',               
					sc_no                :'S/C NO',               
															 					               
					bdr_flg              :'BDR',                  
					bl_no                :'B/L No',               
					cnee_name            :'Consignee',            
					del_cd               :'DEL',                  
					commodity      	     :'CMDT Name',            
					feu                  :'FEU',                  
					bkg_actwgt_qty       :'WGT(KGS)',             
					rcv_term_cd          :'R',                    
					de_term_cd           :'D',                    
					awk_cgo_flg          :'AK',                   
					bb_cgo_flg           :'BB',                   
					pc                   :'PC',                   
					itn_type             :'ITN TYPE',             
					caed_type            :'CAED Type',            
					doc_usr_id           :'BKG STF',              
					ctrt_srep_cd         :'C.SREP',               
					ob_srep_cd           :'L.SREP',               
					rfa_no               :'RFA NO',               
															 					               
					trunk_vvd            :'Trunk VVD',           
					dest_trns_svc_mod_cd :'Dest Service Mode',   
					org_trns_svc_mod_cd  :'Origin Service Mode',   
					del_nod_cd           :'Dest Service Route',   
					por_nod_cd           :'Origin Service Route', 
					fnl_dest_cd			 :'Final Destination Code',
					slan_cd              :'Lane',                 
					bkg_cre_dt           :'Booking Date',         
					cmdt_cd              :'CMDT Code',           
					pol_cd               :'POL(Vessel)',         
					pod_cd               :'POD(Vessel)',         
					shipper              :'Shipper Code',        
					consignee            :'Consignee Code',       
					ntfy                 :'Notify Code',          
					ffdr                 :'Forward Code',         
					pre_1_vvd            :'Pre1.VVD',             
					pre_2_vvd            :'Pre2.VVD',             
					pre_3_vvd            :'Pre3.VVD',             
					pre_4_vvd            :'Pre4.VVD',             
					post_1_vvd           :'Post1.VVD',             
					post_2_vvd           :'Post2.VVD',            
					post_3_vvd           :'Post3.VVD',            
					post_4_vvd           :'Post4.VVD',            
					pre_1_pol_cd         :'Pre1.POL',             
					pre_2_pol_cd         :'Pre2.POL',             
					pre_3_pol_cd         :'Pre3.POL',             
					pre_4_pol_cd         :'Pre4.POL',             
					pre_1_pod_cd         :'Pre1.POD',             
					pre_2_pod_cd         :'Pre2.POD',             
					pre_3_pod_cd         :'Pre3.POD',             
					pre_4_pod_cd         :'Pre4.POD',             
					bkg_clz_flg          :'CBF',                  
					ntfy_name            :'Notify Name',          
					anty_name            :'Also Notify Name',     
					ffdr_name            :'Forward Name',         
					expt_name            :'Export Name',          
					hngr_flg             :'H/G',                  
					soc_flg              :'SOC',                  
					eq_subst_flg         :'Esub',                 
					rd_cgo_flg           :'R/D',                  
					trunk_pol            :'Trunk POL',            
					trunk_pod            :'Trunk POD',            
					hot_de_flg           :'Hot',                  
					bkg_ctrl_ofc_cd      :'Por(EqOfc)',           
					eq_ctrl_ofc_cd       :'Del(EqOfc)',           
					cntr_tpsz_cd         :'Container TP/SZ List', 
					cntr_no              :'Container no',         
					aes_no               :'ITN No',               
					caed_no              :'CAED No',              	
					shp_call_no          :'CRN No.',             
					vsl_eng_nm           :'Vessel Name',
					s_addr				 :'Shipper Address',            
					c_addr				 :'Consignee Address',            
					n_addr				 :'Notify Address',
					remark_detail		 :'External Remark Description',
					inter_remark		 :'Internal Remark',
					inter_remark_detail  :'Internal Remark Description',
					chg_inter_remark		 :'Charge Internal Remark',
					chg_inter_remark_detail  :'Charge Internal Remark Description',
					chg_xter_remark		 	 :'Charge External Remark',
					chg_xter_remark_detail   :'Charge External Remark Description',
					rate_chk_sts		 :'Rate Check Status',
					blck_stwg_cd		 :'Block Stowage',
					
					actual_pol			 :'POL(BKG)',              
					actual_pod			 :'POD(BKG)',
					act_cust_code		 :'Actual Code',              
					act_cust_name		 :'Actual Name',
					frt_term_cd			 :'Freight Term',
					chg_term_cd			 :'Charge Terms',
					ofc_team_cd          :'L.TEAM',
					sail_dt		         :'Sailing DT',
					aloc_sts_cd	         :'Standby Status',
					
					cstms_desc	         :'Customs Description',
			
					tel     			 :'BKG Contact Phone Number',
					cntc_pson_eml	     :'BKG Contact E-Mail',
					si_cntc_pson_phn_no  :'SI  Contact Phone Number',
					si_cntc_pson_eml     :'SI  Contact E-Mail'
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
						zone_cd			:"form.zone_cd.options[form.zone_cd.selectedIndex].text",          
						deli_mode		:"deli_mode.GetSelectText()",
						board_from_dt	:"form.board_from_dt.value",    
						board_to_dt		:"form.board_to_dt.value",      
						bkg_from_dt		:"form.bkg_from_dt.value",      
						bkg_to_dt		:"form.bkg_to_dt.value",        
						bkg_kind		:"bkg_kind.GetSelectText()",
						b_ofc_cd		:"form.b_ofc_cd.value",         
						b_staff_id		:"b_staff_id.GetSelectText()",
						ca_flag			:"form.ca_flag.checked ? 'CA':''",          
						fv_pre_pst_cd	:"( form.fv_pre_pst_cd[0].checked || form.fv_pre_pst_cd[1].checked  || form.fv_pol_local.checked  || form.fv_pod_local.checked || (form.fv_vvd_cd.value+form.fv_pol_cd.value+form.fv_pol_yard_cd.value+form.fv_pod_cd.value+form.fv_pod_yard_cd.value) != '' ?'Feeder Vessel-':'')+ (form.fv_pre_pst_cd[0].checked ?'PRE. ':'') + (form.fv_pre_pst_cd[1].checked ?'POST. ':'')",    
						fv_vvd_cd		:"form.fv_vvd_cd.value",        
						fv_pol_cd		:"form.fv_pol_cd.value",        
						fv_pol_yard_cd	:"form.fv_pol_yard_cd.value",   
						fv_pol_local	:"form.fv_pol_local.checked? 'POL local':''",     
						fv_pod_cd		:"form.fv_pod_cd.value",        
						fv_pod_yard_cd	:"form.fv_pod_yard_cd.value",   
						fv_pod_local	:"form.fv_pod_local.checked? 'POD local':''",     
						agent_cd		:"form.agent_cd.value",   
						eq_type			:"eq_type.GetSelectText()",
						cmdt_cd			:"form.cmdt_cd.value",          
						cmdt_nm			:"form.cmdt_nm.value",          
						wgt_from		:"form.wgt_from.value != '' ? 'WGT From ' + form.wgt_from.value + ' Ton':'' ",         
						wgt_to			:"form.wgt_to.value   != '' ? 'WGT To ' + form.wgt_to.value + ' Ton':'' ",         
						so_no			:"form.so_no.value",            
						l_ofc_cd		:"form.l_ofc_cd.value",         
						dept_cd			:"form.dept_cd.value",          
						l_rep_id		:"l_rep_id.GetSelectText()",
						c_ofc_cd    	:"form.c_ofc_cd.value",     
						c_rep_id		:"form.c_rep_id.value",         
						ctr_rfa_no		:"form.ctr_rfa_no.value",       
						s_mode_ori		:"s_mode_ori.GetSelectText()",
						s_mode_dest		:"s_mode_dest.GetSelectText()",
						s_route_ori		:"s_route_ori.GetSelectText()",
						s_route_dest	:"s_route_dest.GetSelectText()",
						cust_tp_cd_s	:"form.cust_tp_cd_s.checked? 'Shipper':''",     
						cust_tp_cd_c	:"form.cust_tp_cd_c.checked? 'CNT':''",     
						cust_tp_cd_n	:"form.cust_tp_cd_n.checked? 'Notify':''",     
						cust_tp_cd_f	:"form.cust_tp_cd_f.checked? 'Forwarder':''",     
						cust_tp_cd_a	:"form.cust_tp_cd_a.checked? 'Also Notify':''",     
						cust_tp_cd_g	:"form.cust_tp_cd_g.checked? 'Group Customer':''",    
						customer	  	:"form.cust_cnt_cd.value + (form.cust_seq.value != '' ? ' SEQ:'+form.cust_seq.value:'') + (form.cust_nm.value != '' ? ' Name:'+form.cust_nm.value:'')" ,
						sp_cargo_dg 	:"form.sp_cargo_dg.checked ? 'Danger':''",             
						sp_cargo_rf 	:"form.sp_cargo_rf.checked ? 'reffer':''",             
						sp_cargo_ak 	:"form.sp_cargo_ak.checked ? 'Awkward':''",            
						sp_cargo_bb 	:"form.sp_cargo_bb.checked ? 'Break Bulk':''",         
						sp_cargo_hg 	:"form.sp_cargo_hg.checked ? 'Hanger':''",             
						sp_cargo_soc 	:"form.sp_cargo_soc.checked ? 'SOC':''",                
						sp_cargo_eq 	:"form.sp_cargo_eq.checked ? 'E.Sub':''",              
						sp_cargo_rd 	:"form.sp_cargo_rd.checked ? 'Reffer Dry':''",         
						sp_cargo_pm 	:"form.sp_cargo_pm.checked ? 'Premier':''",            
						sp_cargo_pc 	:"form.sp_cargo_pc.checked ? 'Precaution':''",         
						sp_cargo_fg 	:"form.sp_cargo_fg.checked ? 'Food Grade':''",         
						sp_cargo_hd 	:"form.sp_cargo_hd.checked ? 'SPC.HD':''",    
						sp_cargo_rb 	:"form.sp_cargo_rb.checked ? 'Rail Bulk':''", 
						cargo_tp_p 		:"form.cargo_tp_p.checked ? 'P.Empty Cgo Type':''",   
						cargo_tp_f 		:"form.cargo_tp_f.checked ? 'Full CGO':''",           
						cargo_tp_r 		:"form.cargo_tp_r.checked ? 'R.Empty Cgo Type':''",   
						bl_type_a 		:"form.bl_type_a.checked ? 'Ahead':''",              
						bl_type_s 		:"form.bl_type_s.checked ? 'Short':''",              
						rev 			:"form.rev.checked ? 'Revenue Empty':''",      
						non_rev 		:"form.non_rev.checked ? 'Non Rev':''",            
						aes_y 			:"(form.aes_y.checked ? 'AES:Y':'')+(form.aes_n.checked ? 'AES:N':'')",                
						stop_cargo 		:"form.stop_cargo.checked ? 'STOP CGO':''",           
						ro_y 			:"ro_y.GetSelectText()!= '' ? 'Roll Over:'+ro_y.GetSelectText():''",
						caed_y 			:"(form.caed_y.checked ? 'CAED:Y':'')+(form.caed_n.checked ? 'CAED:N':'')",               
						crn_no_flag 	:"form.crn_no_flag.checked ? 'CRN':''",
						certi_d 		:"form.certi_d.checked ? 'D/G Rider':''",             
						certi_a 		:"form.certi_a.checked ? 'A/K Rider':''",             
						certi_b 		:"form.certi_b.checked ? 'B/B Rider':''",            
						certi_g 		:"form.certi_g.checked ? 'B/L Rider':''",                 
						certi_c 		:"form.certi_c.checked ? 'Certificate':''",
						certi_y 		:"(form.certi_y.checked ? 'Certificate:Y':'')+(form.certi_n.checked ? 'Certificate:N':'')",        
						bkg_sts_cd_f 	:"form.bkg_sts_cd_f.checked ? 'FFirm':''",              
						bkg_sts_cd_x 	:"form.bkg_sts_cd_x.checked ? 'Booking Cancel':''",     
						bkg_sts_cd_a 	:"form.bkg_sts_cd_a.checked ? 'Pseudo Booking':''",     
						bkg_sts_cd_w 	:"form.bkg_sts_cd_w.checked ? 'Waiting BKG':''",        
						non_sp_cargo 	:"form.non_sp_cargo.checked ? 'Non Approval Cgo':''",   
						holding  		:"form.holding .checked ? 'Holding':''"
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
							zone_cd          :"'ZONE-'",               
							deli_mode        :"'D.Mode-'",             
							board_from_dt    :"'Bord From Date-'",     
							board_to_dt      :"'Board To Date-'",      
							bkg_from_dt      :"'BKG Date From-'",     
							bkg_to_dt        :"'BKG Date To-'",       
							bkg_kind         :"'B.Kind-'",             
							b_ofc_cd         :"'BKG OFC-'",            
							b_staff_id       :"'BKG Staff-'",          
							ca_flag          :"''",     
							fv_pre_pst_cd    :"''",                
							fv_vvd_cd        :"'F.VVD-'",              
							fv_pol_cd        :"'Pre POL-'",            
							fv_pol_yard_cd   :"'YD-'",                 
							fv_pol_local     :"''",          
							fv_pod_cd        :"'POD-'",                
							fv_pod_yard_cd   :"'YD-'",                 
							fv_pod_local     :"''", 
							agent_cd         :"form.agent_cd_all.checked ? 'AGENT ALL-':'AGENT-'",              
							eq_type          :"'EQ TP-'",              
							cmdt_cd          :"'CMDT Code-'",          
							cmdt_nm          :"'CMDT Name-'",     
							wgt_from         :"''",
							wgt_to           :"''",  
							so_no            :"'SO No.-'",             
							l_ofc_cd         :"'SAL OFC-'",            
							dept_cd          :"'DEPT-'",               
							l_rep_id         :"'REP ID-'",             
							c_ofc_cd         :"'BKG OFC-'",            
							c_rep_id         :"'CTRT OFC-'",
							ctr_rfa_no       :"form.ctr_rfa_cd[0].checked ? 'Contract No-':'RFA No-'",             
							s_mode_ori       :"'ORG SVC-'",            
							s_mode_dest      :"'D.Mode-'",             
							s_route_ori      :"'ORG SVC-'",            
							s_route_dest     :"'DST SVC-'",      
							cust_tp_cd_s     :"''",            
							cust_tp_cd_c     :"''",                
							cust_tp_cd_n     :"''",             
							cust_tp_cd_f     :"''",          
							cust_tp_cd_a     :"''",        
							cust_tp_cd_g     :"''",
							customer          :"'CUSTOMER-'",           
							sp_cargo_dg      :"''",             
							sp_cargo_rf      :"''",             
							sp_cargo_ak      :"''",            
							sp_cargo_bb      :"''",         
							sp_cargo_hg      :"''",             
							sp_cargo_soc     :"''",                
							sp_cargo_eq      :"''",              
							sp_cargo_rd      :"''",         
							sp_cargo_pm      :"''",            
							sp_cargo_pc      :"''",         
							sp_cargo_fg      :"''",         
							sp_cargo_hd      :"''",    
							sp_cargo_rb      :"''",    
							cargo_tp_p       :"''",   
							cargo_tp_f       :"''",           
							cargo_tp_r       :"''",   
							bl_type_a        :"''",              
							bl_type_s        :"''",              
							rev              :"''",      
							non_rev          :"''",            
							aes_y            :"''",                
							stop_cargo       :"''",           
							ro_y             :"''",          
							caed_y           :"''",               
							crn_no_flag      :"''",
							certi_d 		 :"''",             
							certi_a 		 :"''",             
							certi_b 		 :"''",            
							certi_g 		 :"''",                 
							certi_c 		 :"''",                
							certi_y          :"''",        
							bkg_sts_cd_f     :"''",              
							bkg_sts_cd_x     :"''",     
							bkg_sts_cd_a     :"''",     
							bkg_sts_cd_w     :"''",        
							non_sp_cargo     :"''",   
							holding          :"''"
						}
/*
 * orderby Title 
 * */													
var arrOrderbyTitleMap={ bkg_cre_dt:'Booking Date',                bkg_ofc_cd:'Booking Office',          ob_sls_ofc_cd:'Sales Office',         doc_usr_id:'Booking Staff', ob_srep_cd:'Sales Rep', 
						 bkg_sts_cd:'Booking Status',              shpr_name:'Shipper',                  cnee_name:'Consignee',                ntfy_name:'Notify',         ntfy:'Notify Code', 
						 rep:'Rep Commodity',                      commodity:'Commodity',                rcv_term_cd:'Receiving Term',         de_term_cd:'Delivery Term', org_trns_svc_mod_cd:'Orgin Service Mode', 
						 dest_trns_svc_mod_cd:'Dest Service Mode', org_svc_route:'Origin Service Route', dest_svc_route:'Dest Service Route',  por_cd:'POR',               pol_cd:'POL', 
						 pod_cd:'POD',                             del_cd:'DEL',             						 sort_pre_pol:'Pre POL',               sort_pre_pod:'Pre POD',     sort_post_pol:'Post POL', 
						 sort_post_pod:'Post POD',                 trunk_vvd:'Trunk VVD',                sort_pre_vvd:'Pre VVD',               sort_post_vvd:'Post VVD',   slan_cd:'Lane', 
						 trunk_pol:'Trunk VVD POL',                trunk_pod:'Trunk VVD POD',            por_eq_ofc:'POR EQ Office',           del_eq_ofc:'DEL EQ Office', cmdt_nm:'Commodity Name', 
						 sc_no:'Contract No',                      actual_pol:'POL(Booking)',              rfa_no:'Auth No',                     actual_pod:'POD(Booking)',    ctrt_ofc_cd:'Contract Office', 
						 china_agent_cd:'China Agent Code',        ctrt_srep_cd:'Contract Sales Rep',    ffdr:'F/Forwarder Code',              shipper_cd:'Shipper Code',  consignee_cd:'Consignee Code'                   
						}
var orderby="";
var defaultOrderby="pol_cd,pod_cd";
var defaultOrderbyTitleSql="'POL : '||POL_CD||' / POD: '||POD_CD";
/*
 * making column for creating OrderBy Title
 * forwarding from js, to make Group at RD 
 * 'POL : '||POL_CD||' / POD : '||POD_CD
 * expected result POL : USLGB / POD : AUBNE  
 * */
var orderbyTitleSql="";
/*
 * setting Sort in POP-UP   * */
function setOrderBy(val){
	//alert(val);
	var arrSort=val.split(",");
	var cnt=0;
	var tempStr;
	for(var i=0; i < arrSort.length; i++){
			tempStr=arrSort[i].toLowerCase();
			if(arrOrderbyTitleMap[tempStr] == undefined){	
				continue;
			}
			if(cnt==0){
				orderby=tempStr;
				orderbyTitleSql="'"+arrOrderbyTitleMap[tempStr]+":'||"+tempStr;
			}else{
				orderby += tempStr;
				orderbyTitleSql += "'"+arrOrderbyTitleMap[tempStr]+":'||"+tempStr;
			}
			if(arrSort.length > 1 && i < arrSort.length-1){
				orderby += ",";
				orderbyTitleSql += "||' / '||";
			}			
			cnt++;
	}
//debug.innerHTML+= "<br>"+orderby+"\n"+orderbyTitleSql;
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
 //var rowsPerPage = 50;//paging
 var rowsPerPage=999999;//paging
 var sheetObjectsMap=new Array();
 var l_rep_id_cdMultiComboDataAdded=false;
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt=0;
 var comboObjects=new Array();
 var b_staff_idMultiComboDataAdded = false;
 var l_rep_idMultiComboDataAdded=false;
 /*********************** EDTITABLE MULIT COMBO END ********************/
 /*********************** TAB START ********************/
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
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
	 	    for(k=0;k<tabObjects.length;k++){
	 	    	initTab(tabObjects[k],k+1);
	 	    	tabObjects[k].SetSelectedIndex(0);
	 	    }
	 	    
        ComBtnDisable("btn_Print");
        form.rows_per_page.value=rowsPerPage;
        //alert("setReportType");
        //setReportType();
        //debug.innerHTML = form.rows_per_page.value; 
	 	    //setItemOptionHidden();//Item Option Hidden 
		    initControl();
		    //to prevent fail to load screen, give delay time 0.1 second 
		    doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		    setFeederVessel(); // initializing Feeder Vessel by Trunk
		    setCRNNo();// initializing CRN No. by POD T/S
		    if(!form.pod_ts.checked){
				 sheetObjects[0].SetColHidden(prefix + "shp_call_no",1);
				 sheetObjects[0].SetColHidden(prefix + "vsl_eng_nm",1);
				}
     }
	/**
	 	 * setting Combo 
	 	 * param : comboObj ==> combo Object, comboNo ==> sequence which is ID of comboObject tag
	 	 * construct initial module of sheet, as adding case which is a number of combo 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject = document.form
					initComboEditable(comboObj, comboId)
	 	}
 	 //setting multi combo selection and modification
 	 /*function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		if(comboId == "b_staff_id" || comboId == "report_type" || comboId == "ro_y" ){
	 	 			//alert(comboId);
		 	 		SetMultiSelect(0);
		 	 		SetUseAutoComplete(1);
		 	 		SetUseEdit(0);
	 	 		}else if(comboId == "l_rep_id" ){
	 	 			SetMultiSelect(0);
	 	 			SetUseEdit(1);
	 	 		}
	 	 		else{
		 	 		SetMultiSelect(1);
		 	 		SetUseEdit(0);
	 	 		}
	 	 	}
 	 }*/
 	 
 	
 	
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
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * setting Tab 
     * setting item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem("Search");
					InsertItem("Result");
					InsertItem("Summary by CNTR");
                }
             break;
         }
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
	    	objs[nItem].style.display="Inline";	    	
	    	//--------------- important --------------------------//
	    	for(var i = 0; i<objs.length; i++){
	    		  if(i != nItem){
	    		   objs[i].style.display="none";
	    		   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	    		  }
	    		}	    
	    	//------------------------------------------------------//
	    	beforetab=nItem;
    }
    function initControl() {
    	var formObject=document.form;
//      axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- keyboard
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out of focus     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
      axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      //axon_event.addListener ('keydown', 'ComKeyEnter', formObject);
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
/*********************** KEY EVENT START ********************/ 	 
	  /**
     * controlling onBlur of HTML Control .
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "b_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					break;	    		
	    	case "l_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');
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
	    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked=true;
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "board_to_dt":
	    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked=true;
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "bkg_from_dt":
	    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked=true;
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "bkg_to_dt":
	    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked=true;
	    		ComClearSeparator(ComGetEvent());
					break;
			default:
					break;
		}
	}  
	/**
	 	 *  initializing Feeder Vessel with Trunk
	 	 * param : 
	 	 * initializing Feeder Vessel with Trunk 
	 	 */ 
function setFeederVessel(){
	if(form.trunk_flag.checked){
		form.fv_vvd_cd.disabled=false;
		form.fv_pre_pst_cd[0].disabled=false;
		form.fv_vvd_cd.disabled=false;
		form.fv_pre_pst_cd[0].disabled=false;
		form.fv_pre_pst_cd[1].disabled=false;
		form.fv_vvd_cd.disabled=false;
		form.fv_pol_cd.disabled=false;
		form.fv_pol_yard_cd.disabled=false;
		form.fv_pol_local.disabled=false;
		form.fv_pod_cd.disabled=false;
		form.fv_pod_yard_cd.disabled=false;
		form.fv_pod_local.disabled=false;
		form.fv_vvd_cd.style.background="#FFFFFF";
		form.fv_pol_cd.style.background="#FFFFFF";
		form.fv_pol_yard_cd.style.background="#FFFFFF";
		form.fv_pod_cd.style.background="#FFFFFF";
		form.fv_pod_yard_cd.style.background="#FFFFFF";		
	}else{
		form.fv_vvd_cd.value="";
		form.fv_pre_pst_cd[0].checked=false;
		form.fv_pre_pst_cd[1].checked=false;
		form.fv_vvd_cd.value="";
		form.fv_pol_cd.value="";
		form.fv_pol_yard_cd.value="";
		form.fv_pol_local.checked=false;
		form.fv_pod_cd.value="";
		form.fv_pod_yard_cd.value="";
		form.fv_pod_local.checked=false;
		form.fv_vvd_cd.disabled=true;
		form.fv_vvd_cd.disabled=true;
		form.fv_pre_pst_cd[0].disabled=true;
		form.fv_pre_pst_cd[0].disabled=true;
		form.fv_pre_pst_cd[1].disabled=true;
		form.fv_vvd_cd.disabled=true;
		form.fv_pol_cd.disabled=true;
		form.fv_pol_yard_cd.disabled=true;
		form.fv_pol_local.disabled=true;
		form.fv_pod_cd.disabled=true;
		form.fv_pod_yard_cd.disabled=true;
		form.fv_pod_local.disabled=true;
		form.fv_vvd_cd.style.background="#E8E7EC";
		form.fv_pol_cd.style.background="#E8E7EC";
		form.fv_pol_yard_cd.style.background="#E8E7EC";
		form.fv_pod_cd.style.background="#E8E7EC";
		form.fv_pod_yard_cd.style.background="#E8E7EC";
	}
}	
	/**
	 	 * initializing CRN No.check button with POD T/S 
	 	 * param : 
	 	 */ 
function setCRNNo(){
	if(form.pod_ts.checked){
		form.crn_no_flag.disabled=false;
		form.crn_no_flag.style.background="#FFFFFF";
	}else{
		form.crn_no_flag.checked=false;
		form.crn_no_flag.disabled=true;
		form.crn_no_flag.style.background="#E8E7EC";
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
	    	//try {
	     		var srcName=ComGetEvent("name");
	     		 if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {
		 				case "btn_Save":
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 				case "btn_OK":
		 					opener.setSearchOption(getValidCondition(FormQueryString(formObject)));
		 					//debug.innerHTML=ComReplaceStr(FormQueryString(formObject), "&", "|");
		 					//debug.innerHTML=getValidCondition(FormQueryString(formObject));
		 					//tempSqlCon = ComReplaceStr(FormQueryString(formObject), "&", "|");
		 					//alert(FormQueryString(formObject));
	 						ComClosePopup(); 
		 					break;
		 				case "btn_Set":
		 					setConditionAndInitSheet(tempSqlCon);
		 					break;
		 				case "btn_New":
		 					var temp=form.p_report_type.value;
		 					initAll(formObject);
		 					form.p_report_type.value=temp;
		 					//sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_Close":
		 					ComClosePopup(); 
		 					break;
		 				case "btn_ReportTemplate": 		
	 						var retVal=ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd=B', 850, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
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
						case "cust_tp_cd_g":
							if(form.cust_tp_cd_g.checked){
								form.cust_tp_cd_s.checked=false;
								form.cust_tp_cd_c.checked=false;
								form.cust_tp_cd_n.checked=false;
								form.cust_tp_cd_f.checked=false;
								form.cust_tp_cd_a.checked=false;
							}
							break; 	
						case "trunk_flag":
							setFeederVessel();
							break; 	
						case "cust_tp_cd_s":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_c":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_n":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_f":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_a":
							form.cust_tp_cd_g.checked=false;
							break;
						case "pol_local":
							if(form.pol_local.checked){
								form.pol_ts.checked=false;
							}
							break; 		
						case "pol_ts":
							if(form.pol_ts.checked){
								form.pol_local.checked=false;
							}
							break; 										
						case "pod_local":
							if(form.pod_local.checked){
								form.pod_ts.checked=false;
							}
							break; 		
						case "pod_ts":
							if(form.pod_ts.checked){
								form.pod_local.checked=false;
							}
							setCRNNo();
							break; 										
						case "rev":
							if(form.rev.checked){
								form.non_rev.checked=false;
							}
							break; 		
						case "non_rev":
							if(form.non_rev.checked){
								form.rev.checked=false;
							}
							break; 		
						case "aes_y":
							if(form.aes_y.checked){
								form.aes_n.checked=false;
							}
							break; 		
						case "aes_n":
							if(form.aes_n.checked){
								form.aes_y.checked=false;
							}
							break; 		
//		        		case "ro_y":
//							if(form.ro_y.checked){
//								form.ro_n.checked = false;
//							}
//							break; 		
//		        		case "ro_n":
//							if(form.ro_n.checked){
//								form.ro_y.checked = false;
//							}
//							break; 		
						case "caed_y":
							if(form.caed_y.checked){
								form.caed_n.checked=false;
							}
							break; 		
						case "caed_n":
							if(form.caed_n.checked){
								form.caed_y.checked=false;
							}
							break; 		
						case "certi_y":
							if(form.certi_y.checked){
								form.certi_n.checked=false;
							}
							break; 		
						case "certi_n":
							if(form.certi_n.checked){
								form.certi_y.checked=false;
							}
							break; 
						case "bl_type_a":
							if(form.bl_type_a.checked){
								form.bl_type_s.checked=false;
							}
							break; 		
						case "bl_type_s":
							if(form.bl_type_s.checked){
								form.bl_type_a.checked=false;
							}
							break; 
						case "btn_DownExcel":
						      var search_report_id=form.p_report_type.value; 
						      if(search_report_id =="ak" || search_report_id =="bb" || search_report_id =="dg" || search_report_id =="rf"){
						            sheetObjectsMap[search_report_id].LoadSearchData(ComReplaceStr(excelXml, "sheet1", search_report_id),{Sync:1});
						            doActionIBSheet(sheetObjectsMap[search_report_id],formObject,IBDOWNEXCEL);
						      }else if(search_report_id =="G" ){
						            sheetObjectsMap["sheet2"].LoadSearchData(ComReplaceStr(excelXml, "sheet1", "sheet2"),{Sync:1});
						            doActionIBSheet(sheetObjectsMap["sheet2"],formObject,IBDOWNEXCEL);
						      }else {
						            //doActionIBSheet(sheetObjectsMap["sheet1"],formObject,IBDOWNEXCEL);
						    	  doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
						    	  
						      }
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
//		 					setOrderBy('pol_cd|pod_cd'); 
//		 					setOrderBy('pod_cd');
		 					options.innerHTML=" * Search Options ["+getSearchOptions()+"]";
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_Retrieve_Summary":
							setReportType();
//		 					setOrderBy('pol_cd|pod_cd'); 
//		 					setOrderBy('pod_cd');
		 					options_summary.innerHTML=" * Search Options ["+getSearchOptions()+"]";
		 					doActionIBSheet(sheetObjectsMap["summary"],formObject,SEARCH04);
		 					break;
		 				case "btn_Total":
		 					setReportType();
		 					doActionIBSheet(sheetObjects[0],formObject,RDPRINT,null,null,null,"TOTAL");
		 				  break;
		 				case "btn_Preview":
		 					setReportType();
		 					doActionIBSheet(sheetObjects[0],formObject,RDPRINT);
		 				  break;
		 				case "btn_Print":
		 					setReportType();
		 					doActionIBSheet(sheetObjects[0],formObject,PRINT);
		 				  break;  
		 				case "btn_Sort":
			 				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?isPop=Y&codeGubun=CD02196", "OrderBy", 420,250,false,"scrollbars=no,resizable=yes");
			 				//window.open("/opuscntr/ESM_BKG_0161.do?codeGubun=CD02196", "OrderBy", "width:400,height:230");
		 				  break;  
		        } // end switch
//	     	}catch(e) {
//		     		if( e == "[object Error]") {
//		    			ComShowMessage(OBJECT_ERROR);
//		    		} else {
//		    			ComShowMessage(e);
//		    		}
//	     	}
    }
    /*
     *  setting type of reporting
     */
    function setReportType() {
		if(report_type.GetSelectText()=="General(Awkward)"){
			 		form.p_report_type.value="ak";
        }else if(report_type.GetSelectText()=="General(Break Bulk)"){
			 		form.p_report_type.value="bb";
        }else if(report_type.GetSelectText()=="General(Dangerous)"){
			 		form.p_report_type.value="dg";
        }else if(report_type.GetSelectText()=="General(Reefer)"){
			 		form.p_report_type.value="rf";
        }else if(report_type.GetSelectText()== "General" || selectColList ==""){
        	form.p_report_type.value="G";
        }else{
        	form.p_report_type.value="P";
        }
    }
    function openWinCenter(url,winName,width,height , scrollYn) {
 	   var left=(screen.width - width)/2;    
 	   if(left < 0) {
 		   left=0;
 	   }  
        var top=(screen.height- width)/2;   
        if( top < 0 ) {
     	   top=0;
        }
        if (ComIsNull(scrollYn)) {
     	   scrollYn="no";
        } else {
     	   if (scrollYn == "Y") {
     		   scrollYn="yes";
     	   } else {
     		   scrollYn="no";
     	   }
        }
        var feature=
     	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
        return window.open(url,winName,feature);
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
     //var orderbyCnt=0;//the number of the Order By Title- except handling paging
     var realTotalCnt=0;//total of data
     var currPage=1;//handling paging: current page
     var totalPage=1;//total page
     var excelXml;
     
     
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
						case IBSEARCH:      
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				tab1.SetSelectedIndex(1);//  changing result tab
				 				formObj.f_cmd.value=SEARCH;
				 				/**
				 				 * initializing paging variable
				 				 */
								currPage=1;
								formObj.curr_page.value=currPage;
								if(orderby==""){
									formObj.orderby.value=defaultOrderby;
									formObj.orderby_title_sql.value=defaultOrderbyTitleSql;
								}else{
									formObj.orderby.value=orderby;
									formObj.orderby_title_sql.value=orderbyTitleSql;
								}
								formObj.rows_per_page.value=rowsPerPage;
								formObj.last_orderby.value="";
								sheetObjects[1].RemoveAll();
								sheetObjectsMap["sheet2"].RemoveAll();
								sheetObjectsMap["ak"].RemoveAll();
								sheetObjectsMap["bb"].RemoveAll();
								sheetObjectsMap["dg"].RemoveAll();
								sheetObjectsMap["rf"].RemoveAll();
								total_bkg.value="";							  
								total_bl .value="";							  
								total_teu.value="";							  
								total_feu.value="";							  
								total_wgt.value="";	
								total_mea.value="";	
								total_all_teu.value="";
								pagedMaxCnt=sheetObj.HeaderRows();// initializing variable to change color
								if(form.p_report_type.value == "G"){
										if(form.pol_cd.value.substring(0,2)=='US' || form.pol_cd.value.substring(0,2)=='US'){
										 sheetObjects[0].SetColHidden(prefix + "itn_flg",0);
										 sheetObjects[0].SetColHidden(prefix + "itn_type",0);
										}else{
										 sheetObjects[0].SetColHidden(prefix + "itn_flg",1);
										 sheetObjects[0].SetColHidden(prefix + "itn_type",1);
										}
										if(form.por_cd.value.substring(0,2)=='CA' || form.pol_cd.value.substring(0,2)=='CA'){
										 sheetObjects[0].SetColHidden(prefix + "caed_flg",0);
										 sheetObjects[0].SetColHidden(prefix + "caed_type",0);
										}else{
										 sheetObjects[0].SetColHidden(prefix + "caed_flg",1);
										 sheetObjects[0].SetColHidden(prefix + "caed_type",1);
										}
										if(!form.crn_no_flag.checked){
										 sheetObjects[0].SetColHidden(prefix + "shp_call_no",1);
										 sheetObjects[0].SetColHidden(prefix + "vsl_eng_nm",1);
										}else{
										 sheetObjects[0].SetColHidden(prefix + "shp_call_no",0);
										 sheetObjects[0].SetColHidden(prefix + "vsl_eng_nm",0);
										}
								}
								
								var sXml="";
								if(form.p_report_type.value =="ak"){
									formObj.f_cmd.value=SEARCH03;
 									sXml=sheetObj.GetSearchData("ESM_BKG_0103_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						        }else if(form.p_report_type.value =="bb"){
											formObj.f_cmd.value=SEARCH03;
		 									sXml=sheetObj.GetSearchData("ESM_BKG_0103_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						        }else if(form.p_report_type.value =="dg"){
											formObj.f_cmd.value=SEARCH03;
		 									sXml=sheetObj.GetSearchData("ESM_BKG_0103_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						        }else if(form.p_report_type.value =="rf"){
											formObj.f_cmd.value=SEARCH03;
		 									sXml=sheetObj.GetSearchData("ESM_BKG_0103_04GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						        }else {
		 									sXml=sheetObj.GetSearchData("ESM_BKG_0103GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						        }
								var arrSXml=sXml.split("|$$|");
								
									sheetObjects[0].SetWaitImageVisible(1);
								if(form.p_report_type.value =="P"){
									sheet1.LoadSearchData(arrSXml[1],{Sync:0} );
								}else{
									sheet1.LoadSearchData(arrSXml[0],{Sync:0} );
								}
								

								sheetObjects[0].SetWaitImageVisible(0);
//								debug.innerHTML = sheetObjects[0].TotalRows; 
//								debug.innerHTML += " : "; 
//								debug.innerHTML = sheetObjects[0].PageNo; 
								if(arrSXml.length == 1){
									excelXml="";
									return;
								}
								excelXml=arrSXml[1];
								//orderbyCnt += eval(ComGetEtcData(arrSXml[0], "orderby_cnt"));
								realTotalCnt=eval(ComGetEtcData(arrSXml[0], "real_total_cnt"));		
								totalPage=Math.ceil(realTotalCnt / rowsPerPage);
								
								//alert("ComGetEtcData(arrSXml[0], "total_bkg") = "+ComGetEtcData(arrSXml[0], "total_bkg"));
								if(ComGetEtcData(arrSXml[0], "total_bkg") == undefined) return;
								formObj.last_orderby.value=ComGetEtcData(arrSXml[0], "last_orderby");
								total_bkg.value=ComGetEtcData(arrSXml[0], "total_bkg");							  
								total_bl .value=ComGetEtcData(arrSXml[0], "total_bl");							  
								total_teu.value=ComGetEtcData(arrSXml[0], "total_teu");							  
								total_feu.value=ComGetEtcData(arrSXml[0], "total_feu");	
								total_all_teu.value=new Number(eval(total_teu.value) + eval(total_feu.value)*2).toFixed(2);							  
								total_wgt.value=ComGetEtcData(arrSXml[0], "total_wgt");								  
								total_mea.value=ComGetEtcData(arrSXml[0], "total_mea");
								
								
							break; 
							
						case SEARCH04:      
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				formObj.f_cmd.value=SEARCH04;
								if(orderby==""){
									formObj.orderby.value=defaultOrderby;
									formObj.orderby_title_sql.value=defaultOrderbyTitleSql;
								}else{
									formObj.orderby.value=orderby;
									formObj.orderby_title_sql.value=orderbyTitleSql;
								}
								//sheetObj.RemoveAll();
 								var sXml=sheetObj.GetSearchData("ESM_BKG_0103_05GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								/*sheetObj.RenderSheet(0);
								sheetObj.SetWaitImageVisible(1);*/
								sheetObj.LoadSearchData(sXml,{Sync:1} );
								/*sheetObj.RenderSheet(1);
								sheetObj.SetWaitImageVisible(0);*/
							break; 
			 			case SEARCH01:     
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH01;
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
							arrMultiCombo=sXml.split("|$$|");	
							initAll(formObj);
							initReportType();
						  setConditionAndInitSheet(report_type.GetSelectCode());
							break;
			 			case SEARCH02:      //Staff List 
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH02;
							var p_ofc_cd="";
							var p_ofc_gubun="";
							if(subGubun =="b_ofc_cd"){
								p_ofc_cd=formObj.b_ofc_cd.value;
								p_ofc_gubun="BO";
							}else if(subGubun =="l_ofc_cd"){
								p_ofc_cd=formObj.l_ofc_cd.value;
								p_ofc_gubun="LO";
							}
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
							if(subGubun =="b_ofc_cd"){
							  ComXml2ComboItem(sXml, b_staff_id, "usr_id", "usr_id");
							}else if(subGubun =="l_ofc_cd"){
								l_rep_idMultiComboDataAdded=false;
							  ComXml2ComboItem(sXml, l_rep_id, "srep_cd", "srep_cd");
							}
							break;
 						case IBSEARCHAPPEND:  // paging
 								//alert(PageNo);
 								/*
 								formObj.f_cmd.value=SEARCH;
                				formObj.curr_page.value=PageNo;
                				formObj.f_cmd.value=SEARCH;
								//alert(FormQueryString(formObj));
 								var sXml=sheetObj.GetSearchData("ESM_BKG_0103GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								var arrSXml=sXml.split("|$$|");
								//alert(arrSXml[0]);
								if(form.p_grid_type.value =="G"){
									sheetObjects[0].LoadSearchData(arrSXml[0],{Append:1 , Sync:1} );
								}else{
									sheetObjects[0].LoadSearchData(arrSXml[1],{Append:1 , Sync:1} );
								}
								//orderbyCnt += eval(ComGetEtcData(arrSXml[0], "orderby_cnt"));
								formObj.last_orderby.value=ComGetEtcData(arrSXml[0], "last_orderby");							  
//								debug.innerHTML += "<br>"; 
//								debug.innerHTML += sheetObjects[0].TotalRows; 
//								debug.innerHTML += " : "; 
//							
								sheetObjects[1].LoadSearchData(ComReplaceStr(arrSXml[1],{Sync:1} );
               */
           	break;  
						case IBINSERT:      				
							sheetObj.DataInsert(-1);
							break;
						case IBDOWNEXCEL:   
					 	  if (sheetObj.RowCount()< 1) {
								ComShowCodeMessage("COM12189");
								return;
							}
//							var op_sheet = sheetObjectsMap["search_options"];
//							op_sheet.removeAll();
//							var row = op_sheet.DataInsert(-1);
//             				op_sheet.CellValue(row, "search_options") = getSearchOptions();
//							op_sheet.SpeedDown2Excel(-1);
							if(form.p_report_type.value=="P"){
 								sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
							}else{
 								//sheetObj.Down2Excel({ HiddenColumn:1});
 								sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,HiddenColumn:1  });
							}
							break;
						case RDPRINT:   		
							/*if (sheetObj.RowCount()< 1) {
								ComShowCodeMessage("BKG00495");
								return;
							}*/
							var url="ESM_BKG_0775.do?"+FormQueryString(formObj);	    	
							var winName="ESM_BKG_0775";
							repWin=openWinCenter("about:blank",winName,1024,800);
				 			formObj.f_cmd.value=SEARCH02;
							var frm2=document.form2;
							frm2.rfn.value="/ESM_BKG_0775_1.do?"+FormQueryString(formObj);	   
							if(subGubun == "TOTAL"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_05.mrd";
							} else if(form.p_report_type.value == "ak"){ 
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_01.mrd";
							} else if(form.p_report_type.value == "bb"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_02.mrd";
							} else if(form.p_report_type.value == "dg"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_03.mrd";
							} else if(form.p_report_type.value == "rf"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_04.mrd";
							} else {
								if ( subGubun == "PAGE_BREAK" ){
									frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_06.mrd";
								}
								else{
									frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775.mrd";
								}
							}
							frm2.rv.value="options["+getSearchOptions()+"]"+" NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";		    
							frm2.rd_title.value="Booking Status Report( General )";
							frm2.print_type.value="PREVIEW";
							frm2.action=url;
							frm2.target=winName;
							frm2.submit();
							//frm2.target = "";
						  repWin.focus();
							break;							
						case PRINT:   		
							if (sheetObj.RowCount()< 1) {
								ComShowCodeMessage("BKG00495");
								return;
							}
							var url="ESM_BKG_0775.do?"+FormQueryString(formObj);	    	
							var winName="ESM_BKG_0775";
				 			formObj.f_cmd.value=SEARCH02;
							var frm2=document.form2;
							frm2.rfn.value="/ESM_BKG_0775_1.do?"+FormQueryString(formObj);	
							if(form.p_report_type.value == "ak"){ 
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_01.mrd";
							} else if(form.p_report_type.value == "bb"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_02.mrd";
							} else if(form.p_report_type.value == "dg"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_03.mrd";
							} else if(form.p_report_type.value == "rf"){
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_04.mrd";
							} else {
								frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775.mrd";
							}    
							frm2.rv.value="options["+getSearchOptions()+"]"+" NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";		    
							frm2.rd_title.value="Booking Status Report( General )";
							frm2.print_type.value="PRINT";
							frm2.action=url;
							frm2.target="hidden_frame";
							frm2.submit();
							hidden_frame.focus();
							break;							
			    }
     }

	  /*
      *   variable which is to handle as the number of searching result after handling paging
      *   initial value = the number of sheet header
      */ 
      var pagedMaxCnt=2; 
			/**
       *  handling event after searching >>> changing font color
      */ 
		/**
       * handling event after searching>>> changing font color
      */ 
     function sheet1_OnSearchEnd(sheetObj, Code , ErrMsg) {
// 		sheetObj.SetColFontUnderline(prefix+"bkg_no",1);
//		sheetObj.SetColFontUnderline(prefix+"bl_no",1);
//		sheetObj.SetColFontColor(prefix+"bkg_no","#0000FF");
//		sheetObj.SetColFontColor(prefix+"bl_no","#0000FF");
    	 
    	 sheetObj.RenderSheet(0);
    	 for(var r=sheetObj.HeaderRows(); r<=sheetObj.LastRow(); r++){
    		 if(sheetObj.GetRowHidden(r)==1) continue;
    		 if(sheetObj.GetCellValue(r, 0)!=sheetObj.GetCellValue(r, sheetObj.LastCol())){
    			 sheetObj.SetCellFontUnderline(r, prefix+"bkg_no",1);
    			 sheetObj.SetCellFontUnderline(r, prefix+"bl_no",1);
    			 sheetObj.SetCellFontColor(r, prefix+"bkg_no","#0000FF");
    			 sheetObj.SetCellFontColor(r, prefix+"bl_no","#0000FF");
    		 }
    	 }
    	 sheetObj.RenderSheet(1);
    	 pagedMaxCnt=sheetObj.LastRow();
    	 
//	    if(!document.form.pod_ts.checked){
//	    	sheetObj.SetColHidden(prefix + "shp_call_no",1);
//	    	sheetObj.SetColHidden(prefix + "vsl_eng_nm",1);
//		}    	 
//    	 
//		if(document.form.p_report_type.value == "G"){
//			if(document.form.pol_cd.value.substring(0,2)=='US' || document.form.pol_cd.value.substring(0,2)=='US'){
//				sheetObj.SetColHidden(prefix + "itn_flg",0);
//				sheetObj.SetColHidden(prefix + "itn_type",0);
//			}else{
//				sheetObj.SetColHidden(prefix + "itn_flg",1);
//				sheetObj.SetColHidden(prefix + "itn_type",1);
//			}
//			if(document.form.por_cd.value.substring(0,2)=='CA' || document.form.pol_cd.value.substring(0,2)=='CA'){
//				sheetObj.SetColHidden(prefix + "caed_flg",0);
//				sheetObj.SetColHidden(prefix + "caed_type",0);
//			}else{
//				sheetObj.SetColHidden(prefix + "caed_flg",1);
//				sheetObj.SetColHidden(prefix + "caed_type",1);
//			}
//			if(!document.form.crn_no_flag.checked){
//				sheetObj.SetColHidden(prefix + "shp_call_no",1);
//				sheetObj.SetColHidden(prefix + "vsl_eng_nm",1);
//			}else{
//				sheetObj.SetColHidden(prefix + "shp_call_no",0);
//				sheetObj.SetColHidden(prefix + "vsl_eng_nm",0);
//			}
//		}
		
     }

     function summary_OnSearchEnd(sheetObj, Code , ErrMsg) {
    	 for( var idx=2; idx <= sheetObj.LastRow(); idx++){
    		 if( sheetObj.GetCellValue( idx , "sheet1_tp_sz") == "" ){
    			 sheetObj.SetRowHidden(idx , 1);
    		 }
    	 }
    	 
      }

     
     
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
      			obj.SetCellFontColor(idx,celName,color);
     }
		/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    	 	
    	 	var modResult = rowIdx % 2;
    	 	if(form.p_report_type.value=="P"){
    	 		modResult = 0;
    	 	}
    	 	
		    //if(sheetObj.CellValue(rowIdx, prefix+"ibflag") =="D" ) return;
    	 	if( colIdx == sheetObj.SaveNameCol(prefix + 	"remark") && ComTrim(sheetObj.GetCellValue(rowIdx, prefix+"remark")) =="Y"){
    	 		alert(sheetObj.GetCellValue(rowIdx, prefix+"remark_detail"));
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
//     			if(sheetObj.GetCellValue(rowIdx, prefix+"bkg_bl_flg") == "BL"){ //handling of multiple line . Data 넘어오지 않음.
     			if( modResult == 1 ){ //handling of multiple line
     				if(ComTrim(sheetObj.GetCellValue(rowIdx, prefix+"bl_no")) == "") return;
     					//var param="?bl_no="+sheetObj.GetCellValue(rowIdx, prefix+"bl_no");
						  //ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=yes,resizable=yes");

	         			var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no");
						ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
     				
     			  }else{
     				  if(ComTrim(sheetObj.GetCellValue(rowIdx, prefix+"bkg_no")) == "") return;
//							var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
//							ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079_Q.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
//     			  			changing to madal
     				  	comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, prefix+"bkg_no"));
     			  }
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
//     			var param="?bl_no="+sheetObj.GetCellValue(rowIdx, prefix+"bl_no");
//						ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
//						changing to madal
//				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=yes,resizable=yes");
     			
     			var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no");
				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");     			
     		}
     		
     }				
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    			if (!ComIsNull(formObj.vvd_cd)) {
    				return true;
    			}else	if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.board_from_dt) ||  ComIsNull(formObj.board_to_dt)) 
	    																	&& (ComIsNull(formObj.bkg_from_dt) ||  ComIsNull(formObj.bkg_to_dt)) 
	    	                     ) {
	     					ComShowCodeMessage('BKG00626','VVD or On Board Date or Booking Date');
	     					formObj.vvd_cd.focus();
	     					return false;    					
	    		//in case of condition of date, the pol or pod is mandatory,   adding trunk check(2010.4.13)
	    		} else if (((!ComIsNull(formObj.board_from_dt) && !ComIsNull(formObj.board_to_dt)) || 
        			    (!ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt))) &&
                        ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd ) && formObj.trunk_flag.checked == false) {
	    			ComShowCodeMessage('BKG95001',' specify additional mandatory item: with POL (or POD) at least 2 letter country or \n define Trunk vessel only with tick on Trunk-V.\n Otherwise,all data is regarded as Trunk VVD base booking.','');
	    			formObj.trunk_flag.checked=true;
					  formObj.trunk_flag.focus();
	    			return false;
			  	}
	    		//   if special is checked, skip the validation (2010.03.08) 
	    		else if (formObj.sp_cargo_dg.checked == true || formObj.sp_cargo_rf.checked == true ||
	    				 formObj.sp_cargo_ak.checked == true || formObj.sp_cargo_bb.checked == true ||
	    				 formObj.sp_cargo_hg.checked == true || formObj.sp_cargo_soc.checked == true ||
	    				 formObj.sp_cargo_eq.checked == true || formObj.sp_cargo_rd.checked == true ||
	    				 formObj.sp_cargo_pm.checked == true || formObj.sp_cargo_pc.checked == true ||
	    				 formObj.sp_cargo_fg.checked == true || formObj.sp_cargo_hd.checked == true ||
	    				 formObj.sp_cargo_rb.checked == true) {
	    					return true;
//	    		} else if (ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && ComIsNull(formObj.por_cd) && ComIsNull(formObj.del_cd)  
//	    						 && ComIsNull(formObj.b_ofc_cd) && ComIsNull(formObj.l_ofc_cd)
//	    		         && ComIsNull(formObj.c_ofc_cd) && ComIsNull(formObj.c_rep_id) ){
//	    			ComShowCodeMessage('BKG40015','POL or POD or POR or DEL or BKG Office or L/Office or C/Office or C/Rep');
//					formObj.pol_cd.focus();
//					return false;
	    		//ComIsNull(formObj.ctr_rfa_cd) 삭제. 라이오버튼
	    		}else if (ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && ComIsNull(formObj.por_cd) && ComIsNull(formObj.del_cd)
	    					&& ComIsNull(formObj.b_ofc_cd) && ComIsNull(formObj.l_ofc_cd) && ComIsNull(formObj.c_ofc_cd)
	    					&& ComIsNull(formObj.c_rep_id) && ComIsNull(formObj.l_rep_id) && ComIsNull(formObj.b_staff_id)
	    					&& ComIsNull(formObj.ctr_rfa_no)){
	    				ComShowCodeMessage('BKG40015','POL or POD or POR or DEL or BKG Staff or BKG Office or L/Office or C/Office or L/Rep or C/Rep or S/C or RFA');
	    				return false;
	    		}
	    		if( ComIsNull(formObj.vvd_cd) && ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) +1 > 31){
	    			ComShowCodeMessage('COM132001','On Board Date','31Days');
	    			formObj.board_to_dt.focus();
	    			return false;
	    		}
	    		if( ComIsNull(formObj.vvd_cd) &&  ComGetDaysBetween(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value) +1 > 31){
	    			ComShowCodeMessage('COM132001','Booking Date','31Days');
	    			formObj.bkg_to_dt.focus();
	    			return false;
	    		}
					pagedMaxCnt=sheetObj.HeaderRows();//initializing variable to change color
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
	function report_type_OnChange(comboObj) {
		initAll(document.form);
		setConditionAndInitSheet(comboObj.GetSelectCode());
		setFeederVessel();
		 if(report_type.GetSelectText()=="General(Awkward)" || report_type.GetSelectText()=="General(Break Bulk)"
           || report_type.GetSelectText()=="General(Dangerous)" || report_type.GetSelectText()=="General(Reefer)"){
     	setSpecialCargoOptionDisalbed(true);
     }else{
     	setSpecialCargoOptionDisalbed(false);
     }
     //  deactivating Print View, Print button in case it is not Report Type General 
      var temp_report_type=report_type.GetSelectText();
      if( form.p_grid_type.value == 'G'){
      	if(report_type.GetSelectText()=="General(Awkward)" || report_type.GetSelectText()=="General(Break Bulk)"
           || report_type.GetSelectText()=="General(Dangerous)" || report_type.GetSelectText()=="General(Reefer)"){
	      	ComBtnDisable("btn_Total");
      	}else{
	      	ComBtnEnable("btn_Total");
      	}
      	ComBtnEnable("btn_Preview");
      	//ComBtnEnable("btn_Print");
      }else{
      	ComBtnDisable("btn_Total");
      	ComBtnDisable("btn_Preview");
      	//ComBtnDisable("btn_Print");
      }  	
	}
    /*
     *   in case of selecting special cargo,make the option which is not used disabled
     */
    function setSpecialCargoOptionDisalbed(flg) {
			 		form.aes_y.disabled=flg;
			 		form.aes_n.disabled=flg;
			 		form.caed_y.disabled=flg;
			 		form.caed_n.disabled=flg;
    }  
	function b_staff_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function l_rep_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
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
		/**
		 * start of initializing the paging variable
		 */
		currPage=1;
		/*
		*   result value of current order by column
		*  when it handle paging, don't create title of the order by if it is same before
	  */
		form.last_orderby.value="";
		/**
		 * End of initializing the paging variable
		 */		
		ComXml2ComboItem(roYComboStr, ro_y, "val", "desc");		 
		//ComXml2ComboItem(nullMultiComboStr, b_staff_id, "val", "val");
		//ComXml2ComboItem(nullMultiComboStr, l_rep_id,   "val", "val");
		
		ComXml2ComboItem(nullMultiComboStr, formObject.b_staff_id, "val", "val");
		ComXml2ComboItem(nullMultiComboStr, formObject.l_rep_id, "val", "val");
		
		ComXml2ComboItem(arrMultiCombo[0], dir_cd,      "val", "val");
		ComXml2ComboItem(arrMultiCombo[1], r_term,      "val", "val");
		ComXml2ComboItem(arrMultiCombo[2], d_term,      "val", "val");
		ComXml2ComboItem(arrMultiCombo[3], deli_mode,   "val", "name");
		ComXml2ComboItem(arrMultiCombo[4], bkg_kind,    "desc", "desc");
		ComXml2ComboItem(arrMultiCombo[5], eq_type,     "cntr_tpsz_cd", "cntr_tpsz_cd");
		ComXml2ComboItem(arrMultiCombo[6], s_mode_ori,  "val", "val");
		ComXml2ComboItem(arrMultiCombo[6], s_mode_dest, "val", "val");
		ComXml2ComboItem(arrMultiCombo[7], s_route_ori, "val", "val");
		ComXml2ComboItem(arrMultiCombo[7], s_route_dest,"val", "val");
//		ComXml2ComboItem(arrMultiCombo[8], cust_tp_cd,  "val", "val");
		
		dir_cd.SetMultiSelect(1);
		dir_cd.SetMultiSeparator(",");	
		r_term.SetMultiSelect(1);
		r_term.SetMultiSeparator(",");		
		d_term.SetMultiSelect(1);
		d_term.SetMultiSeparator(",");
		deli_mode.SetMultiSelect(1);
		deli_mode.SetMultiSeparator(",");
		bkg_kind.SetMultiSelect(1);
		bkg_kind.SetMultiSeparator(",");
		eq_type.SetMultiSelect(1);
		eq_type.SetMultiSeparator(",");
		s_mode_ori.SetMultiSelect(1);
		s_mode_ori.SetMultiSeparator(",");		
		s_mode_dest.SetMultiSelect(1);
		s_mode_dest.SetMultiSeparator(",");
		s_route_ori.SetMultiSelect(1);
		s_route_ori.SetMultiSeparator(",");
		s_route_dest.SetMultiSelect(1);
		s_route_dest.SetMultiSeparator(",");
//		cust_tp_cd.SetMultiSelect(1);
//		cust_tp_cd.SetMultiSeparator(",");		
		
	}
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[8], report_type, "sql_ctnt_col_nm", "rpt_nm");
	  var arr=ComBkgXml2Array(arrMultiCombo[8], "rpt_nm");
	  var chkRptTypeFlg=false;
	  if(arr == undefined) return;
	  for(var index=0; index<arr.length; index++) {
	  	if(arr[index] == paramReportName)
	  		chkRptTypeFlg=true;
	  }
//	 	report_type.SetSelectText(arr[0],false);
	  report_type.SetSelectIndex(0); // Luc Duong: Fix bug: #34998 
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
//						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						eval(formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else if(arrFormElementMap[formNameValue[0]] == "multi"){
//						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						eval(formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else{
						field=eval("form."+formNameValue[0]);
					  field.value=formNameValue[1];
					  if(field.name == "b_ofc_cd")
					  	doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					  else if(field.name == "l_ofc_cd")
					  	doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');  		
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
  *  deleting if value is not exiting 
  */ 
  function getValidCondition(sql){
  	// alert(sqlCtnt);
  	var arrSqlCtnt=sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql=""; 
   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue=arrSqlCtnt[i].split("=");
   			if(formNameValue[1] == undefined || formNameValue[1] == "") continue;
   			returnSql += formNameValue[0]+"="+formNameValue[1].URLEncode()+"|";
   	}//end for
   	return returnSql;
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
			case "sheet2":
                with(sheetObj){       
			         var HeadTitle1="NO|Booking No|BST|SR|BDR|B/L No|Shipper Code|Shipper|Shipper Address|Consignee Code|Consignee|Consignee Address|TEU|FEU|Trunk VVD|Vessel Name|Lane|Container No|TP/SZ|POR|POL(Booking)|POD(Booking)|DEL|RCV Term|DEL Term|WGT(KGS)|MEA(CBM)|PKG|PKG Unit|REP CMDT|CMDT Code|CMDT|Customs Description|External Remark|Internal Remark|DG|RF|AK|BB|FG|PC|H/G|SOC|EQ Sub|R/D|Hot|B.OFC|BKG STF|C.OFC|C.SREP|L.OFC|L.SREP|S/C NO|RFA NO|TAA No|Freight Term|ITN|ITN Type|ITN No|CAED|CAED Type|CAED No|Forward Code|Forward Name|Notify Code|Notify Name|Notify Address|Also Notify Name|Export Name|Pre1.VVD|Pre2.VVD|Pre3.VVD|Pre4.VVD|Post1.VVD|Post2.VVD|Post3.VVD|Post4.VVD|Pre1.POL|Pre2.POL|Pre3.POL|Pre4.POL|Pre1.POD|Pre2.POD|Pre3.POD|Pre4.POD|Trunk POL|Trunk POD|CBF|Dest Service Mode|Orgin Service Mode|Dest Service Route|Origin Service Route|ORG EQ OFC|DEL EQ OFC|CRN No.|Booking Date|Booking Contact Email";
			         var headCount=ComCountHeadTitle(HeadTitle1);

			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			         InitHeaders(headers, info);

			         var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"no" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_no' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_sts_cd' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'si_flg' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bdr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bl_no' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'shipper' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix2+'shpr_name' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix2+'s_addr' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'consignee' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix2+'cnee_name' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix2+'c_addr' },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix2+'teu',                  KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:2 },
			             {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix2+'feu',                  KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:2 },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'trunk_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'vsl_eng_nm' },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'slan_cd' },
			             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'cntr_no' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'cntr_tpsz_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'por_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'actual_pol' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'actual_pod' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'del_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:prefix2+'rcv_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'de_term_cd' },
			             {Type:"Float",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_actwgt_qty',       KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Float",     Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:prefix2+'bkg_mea_qty',          KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pck_qty',              KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pck_tp_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'rep' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'commodity' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'cmdt_nm' },
			             {Type:"Text",     Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'cstms_desc' },
			             {Type:"Text",     Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'remark_detail' },
			             {Type:"Text",     Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'inter_rmk' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'dcgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'rc_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'awk_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bb_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'fd_grd_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pc' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'hngr_flg' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'soc_flg' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'eq_subst_flg' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'rd_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'hot_de_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'doc_usr_id' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'ctrt_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'ctrt_srep_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'ob_sls_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'ob_srep_cd' },
			             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'sc_no' },
			             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'rfa_no' },
			             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'taa_no' },
			             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'frt_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'itn_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'itn_type' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'aes_no' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'caed_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'caed_type' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'caed_no' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'ffdr' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'ffdr_name' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'ntfy' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'ntfy_name' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'n_addr' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'anty_name' },
			             {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix2+'expt_name' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'post_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'post_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'post_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'post_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'pre_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'trunk_pol' },
			             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'trunk_pod' },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_clz_flg' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'dest_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'org_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'por_nod_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'fnl_dest_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_ctrl_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'eq_ctrl_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'shp_call_no' },
			             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'bkg_cre_dt' },
			             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix2+'cntc_pson_eml' }
			             ];
			         
			         InitColumns(cols);
			         SetEditable(0);
			         SetCountPosition(0);//[1/3]page
		             SetSheetHeight(100);
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
			case "ak":
			    with(sheetObj){
			      var HeadTitle1="N0.|Bst|BKG No.|CNTR No.|T/S|WGT(KGS)|PKG|HT|RF|BKG OFC|BKG STF|CMDT|Void (FEU)|Bdr|B/L No|R|D|DG|BB|S/OFC|S/REP|AT|FWD|AFT|HGT|PORT|STAR|RMK|AK|NET|ANTY_NAME|BKG_CLZ_FLG|BKG_CRE_DT|COMMODITY|Consignee Code|Consignee Name|CUST_TO_ORD_FLG|DEST_SVC_ROUTE|DEST_TRNS_SVC_MOD_CD|EQ_SUBST_FLG|EXPT_NAME|FFDR|FFDR_NAME|HNGR_FLG|NTFY|NTFY_NAME|ORG_SVC_ROUTE|ORG_TRNS_SVC_MOD_CD|PCK_QTY|PCK_TP_CD|POD|POL|POST1.POD|POST1.POL|POST1.VVD|POST2.POD|POST2.POL|POST2.VVD|POST3.POD|POST3.POL|POST3.VVD|POST4.POD|POST4.POL|POST4.VVD|Pre1.POD|Pre1.POL|Pre1.VVD|Pre2.POD|Pre2.POL|Pre2.VVD|Pre3.POD|Pre3.POL|Pre3.VVD|Pre4.POD|Pre4.POL|Pre4.VVD|RC_FLG|REMARK_DETAIL|REP Commodity|Shipper Code|Shipper Name|SI_FLG|SLAN_CD|SOC_FLG|SPLIT_FLG|TRUNK_VVD";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+"no" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bkg_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'cntr_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'cntr_tpsz_cd' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'grs_wgt',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pkg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'hot_de_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'rd_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bkg_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bkg_stf' },
//			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'spcl_cgo_auth_knt' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'akrep_cmdt' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_void_slt_qty',   KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bdr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bl_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'rcv_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'de_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'dcgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bb_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ob_sls_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ob_srep_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'spcl_cgo_apro_cd' },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_fwrd_len',       KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_bkwd_len',       KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_hgt',            KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_lf_len',         KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ovr_rt_len',         KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'remark' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'awk_cgo_flg' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'net_wgt',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'anty_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bkg_clz_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'bkg_cre_dt' },
//			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'meas_qty',           KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'commodity' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'consignee' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'consignee_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'cust_to_ord_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'dest_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'dest_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'eq_subst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'expt_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ffdr' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ffdr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'hngr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ntfy' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'ntfy_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'org_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'org_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pck_qty' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pck_tp_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'post_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'pre_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'rc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'remark_detail' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'rep' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'shipper' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:'ak_'+'shpr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'si_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'slan_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'soc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'split_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'ak_'+'trunk_vvd' } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);//[1/3]
 		          SetSheetHeight(100);
			}
	      	break;
			case "bb":
			    with(sheetObj){
			      var HeadTitle1="No.|Bst|BKG No.|CNTR No.|T/S|WGT(KGS)|PKG|HT|RF|BKG OFC|BKG STF|Commodity|Length|Width|Height|Void (FEU)|Bdr|B/L No|R|D|DG|AK|S/OFC|S/REP|AT|RMK|BB|NET|ANTY_NAME|BKG_CLZ_FLG|BKG_CRE_DT|COMMODITY|Consignee Code|Consignee Name|CUST_TO_ORD_FLG|DEST_SVC_ROUTE|DEST_TRNS_SVC_MOD_CD|EQ_SUBST_FLG|EXPT_NAME|FFDR|FFDR_NAME|HNGR_FLG|NTFY|NTFY_NAME|ORG_SVC_ROUTE|ORG_TRNS_SVC_MOD_CD|PCK_QTY|PCK_TP_CD|POD|POL|POST1.POD|POST1.POL|POST1.VVD|POST2.POD|POST2.POL|POST2.VVD|POST3.POD|POST3.POL|POST3.VVD|POST4.POD|POST4.POL|POST4.VVD|Pre1.POD|Pre1.POL|Pre1.VVD|Pre2.POD|Pre2.POL|Pre2.VVD|Pre3.POD|Pre3.POL|Pre3.VVD|Pre4.POD|Pre4.POL|Pre4.VVD|RC_FLG|REMARK_DETAIL|REP Commodity|Shipper Code|Shipper Name|SI_FLG|SLAN_CD|SOC_FLG|SPLIT_FLG|TRUNK_VVD";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+"no" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bkg_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'cntr_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'cntr_tpsz_cd' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'grs_wgt',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pkg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'hot_de_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'rd_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bkg_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bkg_stf' },
//			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'spcl_cgo_auth_knt' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bb_cmdt' },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dim_len',            KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dim_wdt',            KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dim_hgt',            KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ovr_void_slt_qty',   KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bdr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bl_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'rcv_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'de_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dcgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'awk_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ob_sls_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ob_srep_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'spcl_cgo_apro_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'remark' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bb_cgo_flg' },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'net_wgt',            KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'anty_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bkg_clz_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'bkg_cre_dt' },
//			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'meas_qty',           KeyField:0,   CalcLogic:'',   Format:"Integer" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'commodity' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'consignee' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'consignee_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'cust_to_ord_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dest_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'dest_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'eq_subst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'expt_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ffdr' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ffdr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'hngr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ntfy' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'ntfy_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'org_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'org_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pck_qty' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pck_tp_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'post_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'pre_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'rc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'remark_detail' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'rep' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'shipper' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:'bb_'+'shpr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'si_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'slan_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'soc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'split_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'bb_'+'trunk_vvd' } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);//[1/3]
			      SetSheetHeight(100);
			}
			break;
			case "dg":
				with(sheetObj){
		         var HeadTitle1="N0.|Bst|BKG No.|CNTR No.|T/S|Net|Gross|PKG|HT|RF|BKG OFC|BKG STF|Substance|UN No|Pack Grp|MEA(CBM)|Bdr|B/L No|R|D|AK|BB|S/OFC|S/REP|AT|Contact Point|Class|F/Point|RMK|DG_CNTR_SEQ|DG|IMDG_COMP_GRP_CD|ANTY_NAME|BKG_CLZ_FLG|BKG_CRE_DT|COMMODITY|Consignee Code|Consignee Name|CUST_TO_ORD_FLG|DEST_SVC_ROUTE|DEST_TRNS_SVC_MOD_CD|EQ_SUBST_FLG|EXPT_NAME|FFDR|FFDR_NAME|HNGR_FLG|NTFY|NTFY_NAME|ORG_SVC_ROUTE|O6RG_TRNS_SVC_MOD_CD|PCK_QTY|PCK_TP_CD|POD|POL|POST1.POD|POST1.POL|POST1.VVD|POST2.POD|POST2.POL|POST2.VVD|POST3.POD|POST3.POL|POST3.VVD|POST4.POD|POST4.POL|POST4.VVD|Pre1.POD|Pre1.POL|Pre1.VVD|Pre2.POD|Pre2.POL|Pre2.VVD|Pre3.POD|Pre3.POL|Pre3.VVD|Pre4.POD|Pre4.POL|Pre4.VVD|RC_FLG|REMARK_DETAIL|REP Commodity|Shipper Code|Shipper Name|SI_FLG|SLAN_CD|SOC_FLG|SPLIT_FLG|TRUNK_VVD";
		         var headCount=ComCountHeadTitle(HeadTitle1);
	
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		         InitHeaders(headers, info);
	
		         var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+"no" },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bst_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bkg_no' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'cntr_no' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'cntr_tpsz_cd' },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'net_wgt',             KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'grs_wgt',             KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
		             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pkg',                 KeyField:0,   CalcLogic:'',   Format:"Integer" },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'hot_de_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'rd_cgo_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bkg_ofc_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bkg_stf' },
//		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'spcl_cgo_auth_knt' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'prp_shp_nm' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'imdg_un_no' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'imdg_pck_grp_cd' },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'meas_qty',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bdr_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bl_no' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'rcv_term_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'de_term_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'awk_cgo_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bb_cgo_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ob_sls_ofc_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ob_srep_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'spcl_cgo_apro_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'emer_cntc_phn_no_ctnt' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'imdg_clss_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'flsh_pnt_cdo_temp' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'remark' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'dg_cntr_seq' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'dcgo_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'imdg_comp_grp_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'anty_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bkg_clz_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'bkg_cre_dt' },
//		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'meas_qty',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'commodity' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'consignee' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'consignee_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'cust_to_ord_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'dest_svc_route' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'dest_trns_svc_mod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'eq_subst_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'expt_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ffdr' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ffdr_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'hngr_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ntfy' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'ntfy_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'org_svc_route' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'org_trns_svc_mod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pck_qty' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pck_tp_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_1_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_1_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_1_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_2_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_2_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_2_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_3_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_3_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_3_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_4_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_4_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'post_4_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_1_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_1_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_1_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_2_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_2_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_2_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_3_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_3_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_3_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_4_pod_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_4_pol_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'pre_4_vvd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'rc_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'remark_detail' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'rep' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'shipper' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:'dg_'+'shpr_name' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'si_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'slan_cd' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'soc_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'split_flg' },
		             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'dg_'+'trunk_vvd' } ];
		          
		         InitColumns(cols);
	
		         SetEditable(0);
		         SetCountPosition(0);//[1/3]
		         SetSheetHeight(100);
			}
			break;

			case "rf":
			      with(sheetObj){
			         var HeadTitle1="No.|Bst|BKG No.|CNTR No.|T/S|WGT(KGS)|PKG|HT|DG|BKG OFC|BKG STF|Commodity|C|F|Humid(%)|Vent|CA|MA|HM|Bdr|B/L No|R|D|Gen|Voltage|AK|BB|S/OFC|S/REP|AT|RMK|CMDT_CD|NET|RD|ANTY_NAME|BKG_CLZ_FLG|BKG_CRE_DT|COMMODITY|Consignee Code|Consignee Name|CUST_TO_ORD_FLG|DEST_SVC_ROUTE|DEST_TRNS_SVC_MOD_CD|EQ_SUBST_FLG|EXPT_NAME|FFDR|FFDR_NAME|HNGR_FLG|NTFY|NTFY_NAME|ORG_SVC_ROUTE|ORG_TRNS_SVC_MOD_CD|PCK_QTY|PCK_TP_CD|POD|POL|POST1.POD|POST1.POL|POST1.VVD|POST2.POD|POST2.POL|POST2.VVD|POST3.POD|POST3.POL|POST3.VVD|POST4.POD|POST4.POL|POST4.VVD|Pre1.POD|Pre1.POL|Pre1.VVD|Pre2.POD|Pre2.POL|Pre2.VVD|Pre3.POD|Pre3.POL|Pre3.VVD|Pre4.POD|Pre4.POL|Pre4.VVD|RC_FLG|REMARK_DETAIL|REP Commodity|Shipper Code|Shipper Name|SI_FLG|SLAN_CD|SOC_FLG|SPLIT_FLG|TRUNK_VVD";
			         var headCount=ComCountHeadTitle(HeadTitle1);
		
			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			         InitHeaders(headers, info);
		
			         var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+"no" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bkg_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cntr_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cntr_tpsz_cd' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'grs_wgt',            KeyField:0,   CalcLogic:'',   Format:"Float",       PointCount:3 },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pkg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'hot_de_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'dcgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bkg_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bkg_stf' },
//			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'spcl_cgo_auth_knt' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'rf_cmdt' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cdo_temp',           KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'fdo_temp',           KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'humid_no',           KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cntr_vent_tp_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ctrl_atms_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'modi_atms_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'humid_ctrl_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bdr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bl_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'rcv_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'de_term_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pwr_spl_cbl_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'vltg_no' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'awk_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bb_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ob_sls_ofc_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ob_srep_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'spcl_cgo_apro_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'remark' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cmdt_cd' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'net_wgt',            KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'rd_cgo_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'anty_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bkg_clz_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'bkg_cre_dt' },
//			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'meas_qty',           KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'commodity' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'consignee' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'consignee_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'cust_to_ord_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'dest_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'dest_trns_svc_mod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'eq_subst_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'expt_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ffdr' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ffdr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'hngr_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ntfy' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'ntfy_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'org_svc_route' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'org_trns_svc_mod_cd' },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pck_qty',            KeyField:0,   CalcLogic:'',   Format:"Float" },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pck_tp_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'post_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_1_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_1_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_1_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_2_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_2_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_2_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_3_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_3_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_3_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_4_pod_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_4_pol_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'pre_4_vvd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'rc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'remark_detail' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'rep' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'shipper' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:'rf_'+'shpr_name' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'si_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'slan_cd' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'soc_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'split_flg' },
			             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:'rf_'+'trunk_vvd' } ];
			          
			         InitColumns(cols);
		
			         SetEditable(0);
			         SetCountPosition(0);//[1/3]
		             SetSheetHeight(100);
			}


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
	        if(report_type.GetSelectText()=="General(Awkward)" || report_type.GetSelectText()=="General(Break Bulk)"
	           || report_type.GetSelectText()=="General(Dangerous)" || report_type.GetSelectText()=="General(Reefer)"
	           || report_type.GetSelectText()== "General" || ColList ==""
	           ){
			     form.p_grid_type.value="G";//General - fixed Grid 
			      with(sheetObj){
			         if(report_type.GetSelectText()=="General(Awkward)"){
				         var HeadTitle1="BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Commodity|WGT(KGS)|PKG|PKG|Over Length(CM)|Over Length(CM)|Over Length(CM)|Over Width(CM)|Over Width(CM)|Void (FEU)|HT|RF|BKG OFC|BKG STF|AT|Remark(s)|REMARK_DETAIL";
				         var HeadTitle2="BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Commodity|WGT(KGS)|R|D|FWD|AFT|HGT|PORT|STAR|Void (FEU)|DG|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
				         var headCount=ComCountHeadTitle(HeadTitle1);

				         SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );

				         var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				         var headers = [ { Text:HeadTitle1, Align:"Center"},
				                   { Text:HeadTitle2, Align:"Center"} ];
				         InitHeaders(headers, info);
	
				         var cols = [
				             [ {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bst_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"akrep_cmdt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_fwrd_len",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_bkwd_len",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_hgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_lf_len",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_rt_len",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hot_de_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rd_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_stf",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
				           ],[
				             {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"akrep_cmdt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_fwrd_len",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_bkwd_len",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_hgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_lf_len",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovr_rt_len",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_sls_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_srep_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ]
				          ];
				          
				         	InitColumns(cols , 2);
				         	
			         }else if(report_type.GetSelectText() =="General(Break Bulk)"){
			        	 var HeadTitle1="BKG_BL_FLG|No.|Bst|BKG No|T.VVD|Lane|Commodity|WGT(KGS)|PKG|PKG|Length|Width|Height|Void (FEU)|HT|RF|BKG OFC|BKG STF|AT|Remark(s)|REMARK_DETAIL";
			             var HeadTitle2="BKG_BL_FLG|No.|Bdr|B/L No|T.VVD|Lane|Commodity|WGT(KGS)|R|D|(CM)|(CM)|(CM)|Void (FEU)|DG|AK|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL	";
			             var headCount=ComCountHeadTitle(HeadTitle1);

			             //SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );
			             SetConfig( { SearchMode:2,  MergeSheet:1, FrozenCol:0, DataRowMerge:0 } );

			             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"},
			                       { Text:HeadTitle2, Align:"Center"},
			                       ];
			             InitHeaders(headers, info);

			             var cols =[ [ {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bst_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trunk_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bb_cmdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_len",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_wdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_hgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hot_de_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rd_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_stf",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
			               ],[
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trunk_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bb_cmdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_len",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_wdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dim_hgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_sls_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_srep_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ]];
			              
			             InitColumns(cols , 2);
			         }else if(report_type.GetSelectText() =="General(Dangerous)"){
			        	 var HeadTitle1="BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Substance|UN No.|Pack Grp|WGT(KGS)|WGT(KGS)|PKG|PKG|HT|RF|BKG OFC|BKG STF|AT|Remark(s)|REMARK_DETAIL";
			             var HeadTitle2="BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Contact Point|Class|F/Point|Net|Gross|R|D|AK|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
			             var headCount=ComCountHeadTitle(HeadTitle1);

			             //SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );
			             SetConfig( { SearchMode:2,  MergeSheet:1, FrozenCol:0, DataRowMerge:0 } );

			             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"},
			                       { Text:HeadTitle2, Align:"Center"},
			                        ];
			             InitHeaders(headers, info);

			             var cols = [[ {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bst_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"substance",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"unno",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"packgrp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"wgt(kgs)",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"wgt(kgs)",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mea(cbm)",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ht",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rf",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_stf",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
			                 ],[
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"contactpoint",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"class",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:prefix+"flsh_pnt_cdo_temp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"net",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"gross",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mea(cbm)",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"r",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"d",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ak",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_sls_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_srep_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ]];
			              
			             InitColumns(cols , 2);
			             
			         }else if(report_type.GetSelectText() =="General(Reefer)"){
			        	 var HeadTitle1="BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Commodity|WGT(KGS)|PKG|PKG|Temp|Temp|Humid(%)|Vent|CA|MA|HM|HT|DG|BKG OFC|BKG STF|AT|Remark(s)|REMARK_DETAIL";
			             var HeadTitle2="BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Commodity|WGT(KGS)|R|D|C|F|Voltage|Gen|CA|MA|HM|AK|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
			             var headCount=ComCountHeadTitle(HeadTitle1);

			             //SetConfig( { SearchMode:2, FrozenCol:0, DataRowMerge:1 } );
			             SetConfig( { SearchMode:2,  MergeSheet:1, FrozenCol:0, DataRowMerge:0 } );

			             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"},
			                       { Text:HeadTitle2, Align:"Center"},
			                       ];
			             InitHeaders(headers, info);

			             var cols = [[ {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bst_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rf_cmdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"fdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"humid_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_vent_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ctrl_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"modi_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"humid_ctrl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hot_de_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_stf",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
			                 ],[
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rf_cmdt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"fdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"vltg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pwr_spl_cbl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ctrl_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"modi_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"humid_ctrl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_sls_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_srep_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ]];
			              
			             InitColumns(cols , 2);
			        	 
			         }else if(report_type.GetSelectText() == "General" || ColList ==""){
			             var HeadTitle1="No.|BKG_BL_FLG|BST|SR|Booking No.|Shipper|POR|Rep.|TEU|MEA(CBM)|PKG|PKG|DG|RF|FG|ITN|CAED|CRN No.|B/OFC|C/OFC|L/OFC|Remark(s)|S/C No.|Remark(s)";
			             var HeadTitle2="No.|BKG_BL_FLG|BDR|SR|B/L No.|Consignee|DEL|Commodity|FEU|WGT(KGS)|R|D|AK|BB|PC|Type|TYPE|Vessel Name|BKG STF|C.SREP|L.SREP|Remark(s)|RFA No.|Remark(s)";

			             SetConfig( { SearchMode:2,  MergeSheet:1,  FrozenCol:0, DataRowMerge:0 ,PrevColumnMergeMode:0 } );

			             var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"},
			                             { Text:HeadTitle2, Align:"Center"},
			                       ];
			             InitHeaders(headers, info);

			             var cols = [ [ {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"si_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:0,   SaveName:prefix+"shpr_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"teu",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bkg_mea_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fd_grd_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"itn_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"caed_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shp_call_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ctrt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:0,   SaveName:prefix+"remark_detail" }
				             ],[
			                 {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_bl_flg" },
			                 {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"si_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cnee_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"commodity",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"feu",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bkg_actwgt_qty", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"awk_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"itn_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"caed_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"doc_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ctrt_srep_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ob_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rfa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:48,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark_detail" } ] ];
			              
			             InitColumns(cols , 2);
			         }
			         SetCountPosition(0);
			         SetSheetHeight(442);
			         SetEditable(0);
			      }

        }else{ 
        	form.p_grid_type.value="P";//Private - Grid   
        	selectedGridCols=new Array();//initializing
            with(sheetObj){

				  var HeadTitle1="";
				  var arrColList=ColList.split("|");
				  var tempName="";
				  var tempCnt=0;
				  for(var index=0; index < arrColList.length; index++) {
					  tempName=arrColList[index].split(">")[1].toLowerCase();
					  if(arrGridColsTitle[tempName] == undefined) {
						  continue;
					  }
					  HeadTitle1 += "|"+ arrGridColsTitle[tempName]; //creating selected column header
					  selectedGridCols[tempName]="Y";//selected grid column- except when other header and attribute are defined
					  tempCnt++;
				  }
				  for (var key in arrGridColsTitle){ //creating header of other column
					  if(selectedGridCols[key] != undefined) {
						  continue;
					  }
					  HeadTitle1 += "|"+ arrGridColsTitle[key];
				  }
				  
				  SetConfig( { SearchMode:2,  MergeSheet:0, FrozenCol:0, DataRowMerge:0 } );
				  
				  var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);		
				  
				  var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"no" }];
				  //var count = 0;	
				  for (var key in selectedGridCols){ //setting attribute of the selected header column
					  
//					 count++;
					  
					 //alert(count + " : "+ key + ":" +arrGridColsProp[key]);
					  
					  if(arrGridColsProp[key] == undefined) {
						  //alert(count + " : "+ key + ":" +arrGridColsProp[key]);
						  continue;
					  }
					  eval(arrGridColsProp[key]);
					  SetColHidden(prefix + key,1);
				  }
				  
				  InitColumns(cols);
				  for (var key in arrGridColsProp){ //setting attribute of other column
				      if(selectedGridCols[key] != undefined) {
				    	  continue;
				      }				 
				      eval(arrGridColsProp[key]);
				      SetColHidden(prefix + key,1);
			      }
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
