/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0625.js
*@FileTitle  : VIP Customer Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author CLT
     * @extends 
     * @class esm_bkg_0625  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

   	/* 개발자 작업	*/
/*
 * 입력한 조건 값을 폼에 초기 값으로 처리하기 위한 변수
 * */
var arrFormElementMap={ in_out_cd:'radio',   vps_eta_dt:'input',  vps_etd_dt:'input', vvd_cd:'input',      por_cd:'input',
													pol_cd:'input',      pol_yard_cd:'input', pod_cd:'input',     pod_yard_cd:'input', del_cd:'input',   
													eq_ofc_cd:'input',   sc_no:'input',       cust_tp_cd:'combo', cust_cnt_cd:'input', cust_seq:'input', 
													cust_nm:'input',     edi_id:'input',      edi_gr_cd:'input',  gdi_gr_nm:'input'  , gcust:'input',
													sp_cargo_rf:'check', sp_cargo_dg:'check', sp_cargo_ak:'check',sp_cargo_bb:'check', credit:'input'
                        }
/*
 * Grid 칼럼 별 속성 정의
 * */                     
var arrGridColsProp={
		cgo_rcv_dt       	:"cols.push({Type:'Text',     Hidden:0,  Width:50,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cgo_rcv_dt' })",       
		bdr_flg          	:"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bdr_flg' })",          
		due_date         	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'due_date' })",         
		overdue          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'overdue' })",          
		rmk              	:"cols.push({Type:'Text',     Hidden:0,  Width:180,  Align:'Left',    ColMerge:1,   SaveName:prefix+'rmk' })",              
		atd              	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'atd' })",              
		ata              	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'ata' })",              
		atd_t            	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'atd_t' })",              
		ata_t            	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ata_t' })",              
		g_cust_shpr      	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'g_cust_shpr' })",     
		g_cust_cnee		 	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'g_cust_cnee' })",     
		it_no            	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'it_no' })",            
		scac             	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'scac' })",             
		cntr_oc_date     	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_oc_date' })",     
		dchg_ts_port_dt    	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'dchg_ts_port_dt' })",
		ppd_charge       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ppd_charge' })",       
		cct_charge       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cct_charge' })",       
		act_wgt          	:"cols.push({Type:'Text',     Hidden:0,  Width:130,  Align:'Center',  ColMerge:1,   SaveName:prefix+'act_wgt' })",           
		tot_meas         	:"cols.push({Type:'Text',     Hidden:0,  Width:130,  Align:'Center',  ColMerge:1,   SaveName:prefix+'tot_meas' })",       
		cntr_wgt         	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_wgt' })",           
		cntr_wgt_ut_cd   	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_wgt_ut_cd' })",        
		meas_qty         	:"cols.push({Type:'Text',     Hidden:0,  Width:180,  Align:'Center',  ColMerge:1,   SaveName:prefix+'meas_qty' })",        
		cntr_meas_ut_cd  	:"cols.push({Type:'Text',     Hidden:0,  Width:180,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_meas_ut_cd' })",         
		pck_qty          	:"cols.push({Type:'Text',     Hidden:0,  Width:160,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pck_qty' })",          
		chg_amt          	:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'chg_amt' })",          
		pct_qty          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pct_qty' })",          
		bkg_no           	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bkg_no' })",           
		bkg_ofc_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bkg_ofc_cd' })",       
		bl_no            	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bl_no' })",            
		por_cd           	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'por_cd' })",           
		pol_cd           	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pol_cd' })",           
		bl_iss_ofc       	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bl_iss_ofc' })",       
		shpr_code        	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'shpr_code' })",        
		pol_etd          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pol_etd' })",          
		cnee_code        	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cnee_code' })",        
		shpr_name        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:1,   SaveName:prefix+'shpr_name' })",        
		cnee_name        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:1,   SaveName:prefix+'cnee_name' })",        
		pod_eta          	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pod_eta' })",          
		cct_ofc          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cct_ofc' })",          
		rep_cmdt         	:"cols.push({Type:'Text',     Hidden:0,  Width:180,  Align:'Center',  ColMerge:1,   SaveName:prefix+'rep_cmdt' })",         
		customs_rls_dt   	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'customs_rls_dt' })",   
		bl_po_no         	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'bl_po_no' })",            
		cust_ref_no      	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cust_ref_no' })",      
		export_ref_no    	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'export_ref_no' })",    
		cntr_no          	:"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_no' })",          
		ppd_ofc          	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'ppd_ofc' })",          
		pod_cd           	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pod_cd' })",           
		del_cd           	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_cd' })",
		sc_no            	:"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Center',  ColMerge:1,   SaveName:prefix+'sc_no' })",
		rfa_no           	:"cols.push({Type:'Text',     Hidden:0,  Width:85,   Align:'Center',  ColMerge:1,   SaveName:prefix+'rfa_no' }) ", 
		rcv_term_cd      	:"cols.push({Type:'Text',     Hidden:0,  Width:120,   Align:'Center',  ColMerge:1,   SaveName:prefix+'rcv_term_cd' })",      
		de_term_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,   Align:'Center',  ColMerge:1,   SaveName:prefix+'de_term_cd' })",       
		lane_cd          	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'lane_cd' })",          
		obl_iss_dt       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,   Align:'Center',  ColMerge:1,   SaveName:prefix+'obl_iss_dt' })",       
		bl_obrd_dt       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,   Align:'Center',  ColMerge:1,   SaveName:prefix+'bl_obrd_dt' })",        
		svc_scp_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'svc_scp_cd' })",       
		vsl_eng_nm       	:"cols.push({Type:'Text',     Hidden:0,  Width:100,   Align:'Center',  ColMerge:1,   SaveName:prefix+'vsl_eng_nm' })",       
		por_nm           	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'por_nm' })",           
		pol_nm           	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pol_nm' })",           
		pod_nm           	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pod_nm' })",           
		del_nm           	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_nm' })",           
		meas_ut_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:50,   Align:'Center',  ColMerge:1,   SaveName:prefix+'meas_ut_cd' })",       
		wgt_ut_cd        	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'wgt_ut_cd' })",        
		spc_cgo          	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'spc_cgo' })",          
//		pod_atatic_dt    	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pod_atatic_dt' })",    
		cntr_po_no       	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_po_no' })",       
		pck_tp_cd        	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pck_tp_cd' })",        
		cntr_prt_flg     	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_prt_flg' })",     
		cstms_desc       	:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cstms_desc' })",       
		ntfy_code        	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'ntfy_code' })",        
		ntfy_name        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ntfy_name' })",        
		firms_code       	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'firms_code' })",       
		trunk_vvd        	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'trunk_vvd' })",        
		trunk_vessel     	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'trunk_vessel' })",        
		pre_rly_port_cd  	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pre_rly_port_cd' })",  
		pst_rly_port_cd  	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pst_rly_port_cd' })",  
		cmdt_cd          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:1,   SaveName:prefix+'cmdt_cd' })",          
		scac_cd          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'scac_cd' })",          
		usa_cstms_file_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'usa_cstms_file_cd' })",
		cnd_cstms_file_cd	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cnd_cstms_file_cd' })",
		cntr_seal_no     	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Left',    ColMerge:1,   SaveName:prefix+'cntr_seal_no' })",     
		por_cnty         	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'por_cnty' })",         
		del_cnty         	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_cnty' })",         
		an_send_dt       	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'an_send_dt' })",       
		del_state        	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_state' })",        
		ibd_trsp_iss_dt  	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ibd_trsp_iss_dt' })",  
		hub_loc_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'hub_loc_cd' })",       
		free_dt          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'free_dt' })",          
		pkup_no          	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pkup_no' })",          
		pkup_nod_cd      	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pkup_nod_cd' })",      
		aval_dt          	:"cols.push({Type:'Text',     Hidden:0,  Width:180,  Align:'Center',  ColMerge:1,   SaveName:prefix+'aval_dt' })",          
		del_ata          	:"cols.push({Type:'Text',     Hidden:0,  Width:90,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_ata' })",          
		del_dt           	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'del_dt' })",           
//		por_gate_in_dt   	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'por_gate_in_dt' })",   
		cgo_sts_cd       	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cgo_sts_cd' })",       
		dspo_cd          	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'dspo_cd' })",      
		frt_clt_flg      	:"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:1,   SaveName:prefix+'frt_clt_flg' })",      
		obl_rdem_flg     	:"cols.push({Type:'Text',     Hidden:0,  Width:30,   Align:'Center',  ColMerge:1,   SaveName:prefix+'obl_rdem_flg' })",     
		cstms_clr_cd     	:"cols.push({Type:'Text',     Hidden:0,  Width:60,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cstms_clr_cd' })",     
		f_pol_eta        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'f_pol_eta' })",        
		f_pol_etd        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'f_pol_etd' })",        
		f_pod_eta        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'f_pod_eta' })",        
		f_pod_etd        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'f_pod_etd' })",        
		t_pol_eta        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'t_pol_eta' })",        
		t_pol_etd        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'t_pol_etd' })",        
		t_pod_eta        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'t_pod_eta' })",        
		t_pod_etd        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'t_pod_etd' })",        
		eq_ctrl_ofc      	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'eq_ctrl_ofc' })",      
		mt_return_dt     	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'mt_return_dt' })",     
		del_eta_dt       	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'del_eta_dt' })",       
		cntr_pck_tp_cd   	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_pck_tp_cd' })",        
		cntr_tpsz_cd     	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_tpsz_cd' })",
		cntr_size        	:"cols.push({Type:'Text',     Hidden:0,  Width:50,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_size' })",
		cntr_vol_qty        :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'cntr_vol_qty' })",
		ca_itno          	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ca_itno' })",
		cnrr_ref_no      	:"cols.push({Type:'Text',     Hidden:0,  Width:160,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cnrr_ref_no' })",
		ship_id		     	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ship_id' })",
		prt_no		     	:"cols.push({Type:'Text',     Hidden:0,  Width:160,  Align:'Center',  ColMerge:1,   SaveName:prefix+'prt_no' })",
		bkg_rct_snd_dt_fax	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'bkg_rct_snd_dt_fax' })",
		dbl_snd_dt_fax	 	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'dbl_snd_dt_fax' })",
		wbl_snd_dt_fax	 	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'wbl_snd_dt_fax' })",
		dbl_snd_dt_edi	 	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'dbl_snd_dt_edi' })",
		bkg_rct_snd_dt_edi	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'bkg_rct_snd_dt_edi' })",
		act_cust_code       :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'act_cust_code' })",
		act_cust_name       :"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'act_cust_name' })",
		frd_cust_cd        	:"cols.push({Type:'Text',     Hidden:0,  Width:80,   Align:'Center',  ColMerge:1,   SaveName:prefix+'frd_cust_cd' })",        
		frd_cust_nm        	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Left',    ColMerge:1,   SaveName:prefix+'frd_cust_nm' })",        
		pod_etb			  	:"cols.push({Type:'Text',     Hidden:0,  Width:70,   Align:'Center',  ColMerge:1,   SaveName:prefix+'pod_etb' })",
		uvd_max_act_dt     	:"cols.push({Type:'Text',     Hidden:0,  Width:120,  Align:'Center',  ColMerge:1,   SaveName:prefix+'uvd_max_act_dt' })",
		rln_max_act_dt     	:"cols.push({Type:'Text',     Hidden:0,  Width:220,  Align:'Center',  ColMerge:1,   SaveName:prefix+'rln_max_act_dt' })",
		urn_max_act_dt      :"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'urn_max_act_dt' })",
		oan_max_act_dt   	:"cols.push({Type:'Text',     Hidden:0,  Width:100,  Align:'Center',  ColMerge:1,   SaveName:prefix+'oan_max_act_dt' })",
		d_max_act_dt     	:"cols.push({Type:'Text',     Hidden:0,  Width:200,  Align:'Center',  ColMerge:1,   SaveName:prefix+'d_max_act_dt' })",
		web_prt     		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'web_prt' })",
		final_dest_nm  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'final_dest_nm' })",
		pol1_eta_dt  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pol1_eta_dt' })",
		pol1_etd_dt  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pol1_etd_dt' })",
		pod1_eta_dt  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pod1_eta_dt' })",
		pod1_etd_dt  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pod1_etd_dt' })",
		cust_si_ref_no		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cust_si_ref_no' })",
		cust_bkg_ref_no 	:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cust_bkg_ref_no' })",
		cust_inv_no  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cust_inv_no' })",
		g_shpr_code  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'g_shpr_code' })",
		g_cnee_code  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'g_cnee_code' })",
		pre_vvd  			:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pre_vvd' })",
		pre_vvd_nm  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'pre_vvd_nm' })",
		post_vvd  			:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'post_vvd' })",
		post_vvd_nm  		:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'post_vvd_nm' })",
		cct_ex_rt  			:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'cct_ex_rt' })",
		ppd_ex_rt  			:"cols.push({Type:'Text',     Hidden:0,  Width:140,  Align:'Center',  ColMerge:1,   SaveName:prefix+'ppd_ex_rt' })"
			
								 }
var arrGridColsTitle={
											cgo_rcv_dt         	:'APPL Date',          
											bdr_flg            	:'BDR',                
											due_date           	:'DUE Date',           
											overdue            	:'OverDue',            
											rmk                	:'BKG RMK',            
											atd                	:'ATD(FIRST)',         
											ata                	:'ATA(LAST)',          
											atd_t              	:'ATD(TRUNK)',         
											ata_t              	:'ATA(TRUNK)',         
											g_cust_shpr        	:'G.Cust(SHPR)',       
											g_cust_cnee        	:'G.Cust(CNEE)',       
											it_no              	:'IT NO',              
											scac               	:'SCAC(OPUS)',       
											cntr_oc_date       	:'CNTR OC DATE',       
											dchg_ts_port_dt    	:'Discharging at T/S Port',     
											ppd_charge         	:'PPD Charge',         
											cct_charge         	:'CCT Charge',         
											act_wgt            	:'TTL Weight',    
											cntr_wgt           	:'CNTR Weight',         
											cntr_wgt_ut_cd     	:'CNTR Weight Unit',    
											meas_qty           	:'CNTR Measurement',       
											cntr_meas_ut_cd    	:'CNTR Measurement Unit',  
											pck_qty            	:'CNTR Piece Count',   
											chg_amt            	:'CNTR FRT Rate',      
											pct_qty            	:'TTL PKG',            
											bkg_no             	:'BKG No',             
											bkg_ofc_cd         	:'BKG OFC',            
											bl_no              	:'B/L No',             
											por_cd             	:'POR Code',           
											pol_cd             	:'POL Code',           
											bl_iss_ofc         	:'B/L RLS Ofc',        
											shpr_code          	:'SHPR Code',          
											pol_etd            	:'POL ETD ',           
											cnee_code          	:'CNEE Code',          
											shpr_name          	:'SHPR Name',          
											cnee_name          	:'CNEE Name',          
											pod_eta            	:'POD ETA ',           
											cct_ofc            	:'CCT OFC',            
											rep_cmdt           	:'Commodity',          
											customs_rls_dt     	:'Customs RLS DT',     
											bl_po_no           	:'P.O No',             
											cust_ref_no        	:'Customer Ref. No',   
											export_ref_no      	:'Export Ref. No',     
											cntr_no            	:'CNTR No',            
											ppd_ofc            	:'PPD OFC',            
											pod_cd            	:'POD Code',           
											del_cd             	:'DEL Code',           
											sc_no              	:'S/C No',
											rfa_no              :'RFA No',   
											rcv_term_cd        	:'Receving Term',      
											de_term_cd         	:'Delivery Term',      
											lane_cd            	:'Trunk Lane',         
											obl_iss_dt         	:'B/L Issue Date',   
											bl_obrd_dt         	:'B/L On-board Date',  
											svc_scp_cd         	:'Trade Scope',  
											vsl_eng_nm         	:'Trunk Vessel (B/L)',        
											por_nm             	:'POR Name',           
											pol_nm             	:'POL Name',           
											pod_nm             	:'POD Name',           
											del_nm             	:'DEL Name',   									        
											tot_meas           	:'TTL Measure',
											meas_ut_cd         	:'Measure Unit',             
											wgt_ut_cd          	:'Weight Unit',            
											spc_cgo            	:'Special Cargo',      
//											pod_atatic_dt      	:'POD ATAIC DATE',     
											cntr_po_no         	:'CNTR P.O No',        
											pck_tp_cd          	:'PKG Cd',             
											cntr_prt_flg       	:'CNTR Partial',       
											cstms_desc         	:'Customs Description',
											ntfy_code          	:'NTFY Code',          
											ntfy_name          	:'NTFY Name',        
											frd_cust_cd        	:'FWRD Code',          
											frd_cust_nm        	:'FWRD Name',      
											firms_code         	:'Firms Code',         
											trunk_vvd          	:'Trunk VVD',          
											trunk_vessel       	:'Trunk Vessel',          
											pre_rly_port_cd    	:'Pre Relay Port',     
											pst_rly_port_cd    	:'Post Relay Port',    
											cmdt_cd            	:'Commodity Code',     
											scac_cd            	:'SCAC(NVOCC)',        
											usa_cstms_file_cd  	:'US AMS Filer',       
											cnd_cstms_file_cd  	:'CA AMS Filer',       
											cntr_seal_no       	:'CNTR Seal No',       
											por_cnty           	:'POR Country',        
											del_cnty           	:'DEL Country',        
											an_send_dt         	:'A/N Sent Date',      
											del_state          	:'DEL State',          
											ibd_trsp_iss_dt    	:'IT Date',            
											hub_loc_cd         	:'IT Hub',             
											free_dt            	:'Last Free Date',     
											pkup_no            	:'Pickup No',          
											pkup_nod_cd        	:'Pickup YD',          
											aval_dt            	:'CNTR Available Date ',
											del_ata            	:'DEL ATA',            
											del_dt             	:'Delivery Date',      
//											por_gate_in_dt     	:'POR Gate In',        
											cgo_sts_cd         	:'CGO ST',             
											dspo_cd            	:'USDA Hold',          
											frt_clt_flg        	:'F',                  
											obl_rdem_flg       	:'O',                  
											cstms_clr_cd       	:'C',                  
											f_pol_eta          	:'F. POL ETA',         
											f_pol_etd          	:'F. POL ETD',         
											f_pod_eta          	:'F. POD ETA',         
											f_pod_etd          	:'F. POD ETD',         
											t_pol_eta          	:'T. POL ETA',         
											t_pol_etd          	:'T. POL ETD',         
											t_pod_eta          	:'T. POD ETA',         
											t_pod_etd          	:'T. POD ETD',         
											eq_ctrl_ofc        	:'EQ CTRL OFC',        
											mt_return_dt       	:'MT Return Date',     
											del_eta_dt         	:'DEL ETA',            
											cntr_pck_tp_cd     	:'TTL PKG TP',         
											cntr_tpsz_cd       	:'CNTR TP',
											cntr_size          	:'CNTR Size',
											cntr_vol_qty        :'CNTR Vol',
											ca_itno            	:'IT No (CA I/T)',
											cnrr_ref_no        	:'Rail Carrier Ref No (CA I/T)',
											ship_id        	   	:'SHIP ID',
											prt_no        	   	:'PART No',
											bkg_rct_snd_dt_fax 	:'BKG Receipt(Fax/Email) Send Date',
											dbl_snd_dt_fax     	:'Draft BL (Fax/Email) Send Date',
											wbl_snd_dt_fax     	:'Waybill(Fax/Email) Send Date',
											dbl_snd_dt_edi     	:'Datf BL(EDI) Send Date',
											bkg_rct_snd_dt_edi 	:'BKG Receipt(EDI) Send Date',
											act_cust_code     	:'Actual Code',
											act_cust_name   	:'Actual Name',
											pod_etb     		:'POD ETB',
											uvd_max_act_dt	:'Unloaded at POD',
											rln_max_act_dt	:'I/B Rail Departure from Origin Ramp',
											urn_max_act_dt	:'I/B UNLOADED FROM A RAIL CAR',
											oan_max_act_dt	:'I/B OUTGATE',
											d_max_act_dt	:'Actual Delivery to the Customer',
											web_prt	:'Web Original B/L Issue',
											final_dest_nm	:'Final Dest.',
											pol1_eta_dt	:'1st POL ETA',
											pol1_etd_dt	:'1st POL ETD',
											pod1_eta_dt	:'1st POD ETA',
											pod1_etd_dt	:'1st POD ETD',
											cust_si_ref_no : 'Customer S/I Ref No',
											cust_bkg_ref_no : 'Customer BKG Ref No',
											cust_inv_no : 'Customer Invoice Ref No',
											g_shpr_code : 'G.Cust(SHPR) Code',
											g_cnee_code : 'G.Cust(CNEE) Code',
											pre_vvd : 'Pre VVD',
											pre_vvd_nm : 'Pre Vessel',
											post_vvd : 'Post VVD',
											post_vvd_nm : 'Post Vessel',
											cct_ex_rt : 'Exchange Rate (CCT)',
											ppd_ex_rt : 'Exchange Rate (PPD)'
											
										}
/*
 * 104화면 Item Option 으로 등록한 Table Column
 * 선택된 것을 먼저 구성하고 나머지는 Hidden처리 함. 
 * */
var selectedGridCols;
 // 공통전역변수
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="sheet1_";//IBSheet 구분자
 var prefix2="sheet2_";//IBSheet 구분자
// var rowsPerPage = 50;//paging
 var rowsPerPage=999999;//paging
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt=0;
 var comboObjects=new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
      /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * ComComboObject생성자 메소드에서 호출됨 
	 	 	* param : comboObj ==> 콤보오브젝트
	 	 	* 
      */
     function setComboObject(combo_obj){
 			comboObjects[comboCnt++]=combo_obj;
 		}	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	  for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }
		      //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
        form.rows_per_page.value=rowsPerPage;
        //debug.innerHTML = form.rows_per_page.value; 
	 	    //setItemOptionHidden();//Item Option Hidden 처리
		    initControl();
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		     //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		    setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH03); },100);
		 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    //form.cust_cnt_cd.focus();
     }
	/**
	 	 * Combo 기본 설정 
	 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject=document.form
 				initComboEditable(comboObj, comboId)
	 	}
 	 //콤보 멀티 셀렉트 및 수정 여부 초기 설정
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		if(comboId == "report_type"){
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
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
//        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
        sheetObjects[0].SetWaitImageVisible(0);
    }
    /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	
	      case "gcust": 
	      ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	
	      default:
	    }
	}  
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "vps_eta_dt":
	    		ComAddSeparator(event.srcElement);
				break;
	    	case "vps_etd_dt":
	    		ComAddSeparator(event.srcElement);
				break;
	    	case "agmt_act_cust_seq":
	    		if( formObj.agmt_act_cust_seq.value != "" && formObj.agmt_act_cust_seq.value.length < 6 ){
	    			var strZero="";
	    			for( var idx=0; idx < 6 - formObj.agmt_act_cust_seq.value.length; idx++ ){
	    				strZero=strZero + "0";
	    			}
	    			formObj.agmt_act_cust_seq.value=strZero + formObj.agmt_act_cust_seq.value
	    		}
	    		break;
			default:
				break;
	    }
    }        
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "vps_eta_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  
/*********************** KEY EVENT END ********************/
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick=processButtonClick;
		var tempSqlCon="";
		var nullMultiComboStr="<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
						case "btn_New":
		 					form.reset();
		 					cust_tp_cd.text2='';
		 					sheetObject1.RemoveAll();				//20150603.ADD
		 					break;		 					
						case "btn_ReportTemplate":
			 				ComOpenPopup('/opuscntr/ESM_BKG_0104.do?p_bkg_rpt_knd_cd=V', 820, 500, 'TemplateSet', '1,0', false,false, 0, 0, 0,"fra_pop");
							break;			 					
		 				case "btn_commodity_pop": 		
							comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
							break;		 								
		 				case "btn_ctr_fra_pop": 		
							var param="?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
	 						ComOpenPopup('/opuscntr/COM_ENS_021.do'+param, 780, 450, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;		 								
		 				case "btn_customer_pop":
		 				  var param="" ;
		 				  param="?cust_cd="+formObject.cust_cnt_cd.value;
		 				  if(formObject.cust_seq.value != ""){
		 				  	param += eval(formObject.cust_seq.value);
		 				  }
		 				  param += "&cust_nm="+formObject.cust_nm.value;	
	 						ComOpenPopup('/opuscntr/COM_ENS_041.do'+param, 770, 450, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;		
		 				case "btn_Edi_Id":
		 				  var param="?grp_id="+formObject.edi_id.value;
		 				  param += "&edi_id="+formObject.edi_gr_cd.value;
		 				  param += "&grp_nm="+formObject.edi_gr_nm.value;
	 						ComOpenPopup('/opuscntr/ESM_BKG_1073.do'+param, 800, 380, 'setEdiId', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"Edi_pop");
							break;		
						case "btn_eta_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.vps_eta_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
						 	break;						
						case "in_out_cd":
		 					if(formObject.in_out_cd[0].checked){
		 							eta_id.innerHTML="ETA";
		 					}else{
		 							eta_id.innerHTML="ETD";
		 					} 
						 	break;						
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
		 					break;
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e.message);
		    		}
	     	}
    }
   // Sheet관련 프로세스 처리
     var arrMultiCombo;//멀티콤보 세팅할 변수
     //var orderbyCnt=0;//Order By Title 개수 - 페이징 처리에서 제외함
     var realTotalCnt=0;//실 데이타 총 개수
     var currPage=1;//페이징 처리: 현재 페이지
     var totalPage=1;//총 페이지
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
						case IBSEARCH:      //조회
							  form.rows_per_page.value=rowsPerPage;
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				formObj.f_cmd.value=SEARCH;
				 				ComOpenWait(true); // 대기창 보임
								sheetObj.RemoveAll();
								var ColList=selectColList.substring(4);
								formObj.select_list.value=ColList.split("|VIP>");
								
								setTimeout( function () { //@ setTimeout ###########################################################
	 								var sXml=sheetObj.GetSearchData("ESM_BKG_0625GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
									sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
									ComOpenWait(false); 
					        	 } , 100);//@ setTimeout end ###########################################################
							break; 
						case SEARCH03:      //조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH03;
							ComOpenWait(true); // 대기창 보임
							setTimeout( function () { //@ setTimeout ###########################################################
								var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
								arrMultiCombo=sXml.split("|$$|");	
								initAll(formObj);
								initReportType();
							    setConditionAndInitSheet(report_type.GetSelectCode());
							    ComOpenWait(false); 
							} , 100);//@ setTimeout end ###########################################################
						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
							break;								
			 			case SEARCH01:      //조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH01;
				 			sheetObj.SetWaitImageVisible(0);
				 			ComOpenWait(true); // 대기창 보임
							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
							arrMultiCombo=sXml.split("|$$|");	
							initAll(formObj);
							initReportType();
						  setConditionAndInitSheet(report_type.GetSelectCode());
						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
							break;
			 			case SEARCH02:      //Staff List 조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH02;
							var p_ofc_cd="";
							if(subGubun =="b_ofc_cd"){
								p_ofc_cd=formObj.b_ofc_cd.value;
							}else if(subGubun =="l_ofc_cd"){
								p_ofc_cd=formObj.l_ofc_cd.value;
							}
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true); // 대기창 보임
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd);
							if(subGubun =="b_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.b_staff_id, "usr_id", "usr_id");
							}else if(subGubun =="l_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.l_rep_id, "usr_id", "usr_id");
							}
							break;
 						case IBSEARCHAPPEND:  // 페이징 조회
 								formObj.f_cmd.value=SEARCH;
 								formObj.curr_page.value=PageNo;
 								sheetObj.SetWaitImageVisible(0);
 								ComOpenWait(true); // 대기창 보임
 								var sXml=sheetObj.GetSearchData("ESM_BKG_0625GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:1} );
								break;  
						case IBINSERT:      // 입력					
							sheetObj.DataInsert(-1);
							break;
						case IBDOWNEXCEL:   // 엑셀다운로드
//							sheetObj.Down2Excel();
							if(sheetObj.RowCount() < 1){//no data
		                		 ComShowCodeMessage("COM132501");
		        	       		}else{
		        	       			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		        	       		}
							break;
			    }
     }
	 /**
     * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
     */ 
 	  function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
		   doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	  }
		/**
       * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }	  
		/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		    //if(sheetObj.CellValue(rowIdx, prefix+"ibflag") =="D" ) return;
    	 if( colIdx == sheetObj.SaveNameCol(prefix + 	"remark") && sheetObj.GetCellValue(rowIdx, prefix+"remark") =="Y"){
    		 alert(sheetObj.GetCellValue(rowIdx, prefix+"remark_detail"));
     		}
     }				
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if ( (ComIsNull(formObj.vps_eta_dt) ||  ComIsNull(formObj.vps_etd_dt)) && ComIsNull(formObj.vvd_cd) ) {
	     					ComShowCodeMessage('BKG00626','ETA or VVD');
	     					if(ComIsNull(formObj.vps_eta_dt))formObj.vps_eta_dt.focus();
	     					else if(ComIsNull(formObj.vps_etd_dt))formObj.vps_etd_dt.focus();
	     					return false;
			  	}
	    		if ( ComIsNull(formObj.sc_no) && (ComIsNull(formObj.cust_cnt_cd) || ComIsNull(formObj.cust_seq) ) && ComIsNull(formObj.edi_id) && ComIsNull(formObj.gcust) && ComIsNull(formObj.rfa_no) && ComIsNull(formObj.taa_no) ) {
	     					ComShowCodeMessage('BKG00626','S/C or RFA or TAA or Group Customer or CUSTOMER or EDI ID');
	     				  formObj.sc_no.focus();
	     					return false;
			  	}
			  	if(ComGetDaysBetween(formObj.vps_eta_dt.value,formObj.vps_etd_dt.value) > 30 ){
							ComShowCodeMessage('COM132001','ETA','30Days')
	     				formObj.vps_etd_dt.focus();
							return false;
						}		
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
/*############################# combo onchage start ########################*/
/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
	 * 입력값을 upper로 변경하여 재등록 한다.
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		id_sheet1.style.display="none";
		initAll(document.form);
		setConditionAndInitSheet(comboObj.GetSelectCode());
		//쉬트 헤드를 초기화 시 스크롤이 보였다 안보였다 하는데 이를 회피하기 위해 헤더 생성 후 쉬트를 전시한다. 
		//setTimeout(function () { setConditionAndInitSheet(comboObj.Code);},100);
	}
	function b_staff_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function l_rep_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject=document.form;  
		// 사용자 입력값을 uppercase로 변경  
   	 	var comboText=comboObj.GetSelectText().toUpperCase();
   	 	// 이전에 등록되었으면 삭제 
   	 	if (multiComboDataAddedFlag) { 
 	 			comboObj.DeleteItem(0);
	 			multiComboDataAddedFlag=false; 
   	 	} 
   	 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
    	 	if (comboObj.FindItem(comboText, 0) != -1) {
   	 		return; 
   	 	} 
   	 	comboObj.InsertItem(0, comboText, comboText); 
	 		multiComboDataAddedFlag=true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수) 
	 		comboObj.SetSelectText(comboText,false);// 입력값이 선택되게 한다.
	 }	 
/*############################# combo onchage end ########################*/		
	/*
	 * 모든 조건 값들을 초기화 한다.
	 * */
	function initAll(formObject){
		form.reset();
		ComXml2ComboItem(arrMultiCombo[0], cust_tp_cd, "val", "val|name");
	}
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[1], report_type, "sql_ctnt_col_nm", "rpt_nm");
	  var arr=ComBkgXml2Array(arrMultiCombo[1], "rpt_nm");
	  //report_type.SetSelectText(arr[0],false);
	  report_type.SetSelectIndex(0);
	  
	}
	var selectColList="";//Report 타입별 저장된 그리드 칼럼 목록
	var defaultSelectColList ="VIP>BKG_NO|VIP>BL_NO|VIP>SC_NO";
    /**
     * condition setting and init Sheet
     */ 
  function setConditionAndInitSheet(sqlCtnt){
  	var arrSqlCtntColnm=sqlCtnt.URLDecode().split("@@");
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
	   			}
	   	}//end for
  	}catch(e){}
			if(form.in_out_cd[0].checked){
		 			eta_id.innerHTML="ETA";
			}else{
					eta_id.innerHTML="ETD";
			}
  	/*
  	 * Report Type에 따라 Grid를 다시 그린다.
  	 * */
		if(arrSqlCtntColnm.length > 1){
		  	selectColList = arrSqlCtntColnm[1];
		  	
		  	if(selectColList == "")
		  		selectColList = defaultSelectColList;
		  	initSheetDynamic(sheetObjects[0],selectColList);
	  	}else{
		  	selectColList = defaultSelectColList;
		  	initSheetDynamic(sheetObjects[0],selectColList); 
	  	}
  }
		/*
		 * Customer 조회 결과를 세팅하는 콜백 메소드
		 * */
		function setCustomer(val){
				var c_cd=val[0][3];
				var c_name=val[0][4];
				form.cust_cnt_cd.value=c_cd.substring(0,2);
				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
				form.cust_nm.value=c_name;
		} 
		/*
		 * EDI ID 조회 결과를 세팅하는 콜백 메소드
		 * */
		function setEdiId(val){
				form.edi_id.value=val[0][3];
				form.edi_gr_cd.value=val[0][4];
				form.edi_gr_nm.value=val[0][5];
		} 
		 /**
		 * Commodity Code를 입력하기 위해 Code를 검색  .<br>
		 * @param {arry} aryPopupData
		 */
		function setCallBack0653(aryPopupData) {
			var formObject=document.form;
			formObject.cmdt_cd.value=aryPopupData[0][3];
			//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
			formObject.cmdt_nm.value=aryPopupData[0][4];
		}
	/**
  * 조건 중 값이 없는 것은 제거한다. 
  */ 
  function getValidCondition(sql){
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
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo,ColList) {
         var cnt=0;
         id_sheet1.style.display="none";
         switch(sheetObj.id) {
            case "sheet1":
            	//Report Type을 조회한 후 초기화 함.
						break;
         }
     }
/**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheetDynamic(sheetObj,ColList) {
    	 
     	 sheetObj.RemoveAll();
//     	 sheetObj.Reset();
     	 var sheetNo = parseInt(sheetObj.id.charAt(sheetObj.id.length-1))-1;
     	 sheetObjects[sheetNo] = sheetObjects[sheetNo].Reset();
     	 sheetObj = sheetObjects[sheetNo];

     	 selectedGridCols=new Array();//초기화
			with (sheetObj) {
                
               var HeadTitle1="";
               var arrColList=ColList.split("|");
               var tempName="";
               var tempCnt=0;
               for(var index=0; index < arrColList.length; index++) {
	               if(arrColList[0] == ""){
	               continue;
	               }
	               tempName=arrColList[index].split(">")[1].toLowerCase();
	               if(arrGridColsTitle[tempName] == undefined) {
	               continue;
	               }
	               HeadTitle1 += "|"+ arrGridColsTitle[tempName]; //선택된 컬럼 헤더생성
	               selectedGridCols[tempName]="Y";//선택된 그리드 칼럼-나머지 헤더 및 속성 정의시 제외
	               tempCnt++;
               }
               for (var key in arrGridColsTitle){ //선택된헤더 컬럼 외 나머지 컬럼 헤더 생성
	               if(selectedGridCols[key] != undefined) {
	            	   continue;
	               }
	               HeadTitle1 += "|"+ arrGridColsTitle[key];
               }
               var headCount=ComCountHeadTitle(HeadTitle1);
//               (headCount+1, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [{Type:'Seq', Hidden:0, Width:30,   Align:'Center',  ColMerge:1,   SaveName:prefix+'no' }];

               for (var key in selectedGridCols){ //선택된 헤더 컬럼  속성 세팅
	               if(arrGridColsProp[key] == undefined) {
	            	   continue;
	               }
	               
//	               cols = cols+","+arrGridColsProp[key];
	               eval(arrGridColsProp[key]);
               }
               InitColumns(cols);
               for (var key in arrGridColsProp){ //선택된 헤더 컬럼 외 나머지 컬럼 헤더 속성 세팅
            	   if(selectedGridCols[key] != undefined) {
            		   continue;
            	   }
            	   
            	   eval(arrGridColsProp[key]);
//            	   cols = cols+","+arrGridColsProp[key];
            	   SetColHidden(prefix + key,1);
               }
               
//               cols = eval("["+cols+"]");
               SetSheetHeight(350);   
               SetEditable(0);
	            
               }//end width
               id_sheet1.style.display="";// 헤더 생성 후 쉬트 전시함

               sheetObj.RenderSheet(1);

     }    
	/* 개발자 작업  끝 */    
  