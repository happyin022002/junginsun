/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0103.js
*@FileTitle : Booking Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.02.14 변종건 [CHM-201108913-01] [BKG] Booking Status Report보완요청-Page Break,SPECIAL화물구분자 및 CNTR-TYPE./SIZE표기
* 2011.07.08 김영철 [CHM-201111970] [BKG]Booking status report 기능 보완
* 2011.07.25 김영철 [] [BKG]화면에서 Office Code 값을 입력후 엔터클릭하면 조회 조건에 들어가도록 수정함.([CHM-201111970] CSR 관련 보강요청 )
* 2011.10.20 이경원 [CHM-201114018-01] Booking Status Report 수정 요청
* 2011.10.20 이경원 [CHM-201114019-01] Booking Status Report 보완 요청(2)
* 2011.11.09 이경원 [CHM-201114454-01] Booking Stutus Report 항목 추가
* 2011.12.22 채창호 [CHM-201115234-01] BST - 로직 수정 요청
* 2012.03.26 김보배 [CHM-201216886] [BKG] [Booking Status Report] Vessel Name 아이템 조회결과 제한 제거
* 2012.04.06 김보배 [CHM-201217102] [BKG] [Booking Status Report] Item option 추가
* 2012.10.30 문동선 [CHM-201220937] [BKG] [Booking Status Report] Charge remark(DIFF_RMK, RT_INTER_RMK) 컬럼 추가
* 2013.03.11 김진주 [CHM-201322943] [Invalid VVD 추가] - Booking status report
* 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
* 2013.04.16 김진주 [CHM-201324119] [BKG] 통합로그 Error 복구
* 2014.06.18 조인영 [CHM-201430731] BKG Status Report에 POL 이나 BKG OFFICE가 US/CA Country에 속하는 경우 1달동아 조회토록 로직 보완
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 * @extends 
 * @class esm_bkg_0103  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0103() {
	this.processButtonClick	= processButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.setTabObject 		= setTabObject;
	this.validateForm 		= validateForm;    	
}
    
/* 개발자 작업 */
/*
 * 입력한 조건 값을 폼에 초기 값으로 처리하기 위한 변수
 * */
var arrFormElementMap = {
					 vvd_cd:'input',		trunk_flag:'check',		lane_cd:'input',		dir_cd:'multi',			pol_cd:'input', 
                     pol_yard_cd:'input',	pol_local:'check',		pol_ts:'check',			pod_cd:'input',			pod_yard_cd:'input', 
					 pod_local:'check',		pod_ts:'check',			por_cd:'input',			del_cd:'input',			r_term:'multi', 
					 d_term:'multi',		zone_cd:'select',		deli_mode:'multi',		board_from_dt:'input',	board_to_dt:'input', 
					 bkg_from_dt:'input',	bkg_to_dt:'input',		eta_from_dt:'input',	eta_to_dt:'input',	
					 bkg_kind:'multi',		b_ofc_cd:'input',		b_ofc_cd_sub:'check', 
					 b_staff_id:'combo',	ca_flag:'check',		agent_cd:'input',		agent_cd_all:'check',	eq_type:'multi', 
					 cmdt_cd:'input',		cmdt_nm:'input',		wgt_from:'input',		wgt_to:'input',			so_no:'input', 
					 l_ofc_cd:'input',		l_ofc_cd_sub:'check',	l_team_cd:'combo',		l_rep_id:'combo',		c_ofc_cd:'input', 
					 c_ofc_cd_sub:'check',	c_rep_id:'input',		ctr_rfa_cd:'radio',		ctr_rfa_no:'input',		s_mode_ori:'multi', 
					 s_mode_dest:'multi',	s_route_ori:'multi',	s_route_dest:'multi',	fv_pre_pst_cd:'radio',	fv_vvd_cd:'input', 
					 fv_pol_cd:'input',		fv_pol_yard_cd:'input',	fv_pol_local:'check',	fv_pod_cd:'input',		fv_pod_yard_cd:'input', 
					 fv_pod_local:'check',	cust_tp_cd_s:'check',	cust_tp_cd_c:'check',	cust_tp_cd_n:'check',	cust_tp_cd_f:'check', 
					 cust_tp_cd_a:'check',	cust_tp_cd_g:'check',	cust_cnt_cd:'input', 	cust_seq:'input',		cust_nm:'input', 
					 cust_tp_cd:'multi',	sp_cargo_dg:'check',	sp_cargo_rf:'check', 	sp_cargo_ak:'check',	sp_cargo_bb:'check', 
					 sp_cargo_hg:'check',	sp_cargo_soc:'check',	sp_cargo_eq:'check',	sp_cargo_rd:'check',	
					 sp_cargo_pc:'check',	sp_cargo_fg:'check',	sp_cargo_hd:'check',	sp_cargo_rb:'check',	cargo_tp_f:'check', 
					 cargo_tp_p:'check',	cargo_tp_r:'check',		bkg_sts_cd_f:'check',	bkg_sts_cd_x:'check',	bkg_sts_cd_a:'check', 
					 bkg_sts_cd_w:'check',	non_sp_cargo:'check',	holding:'check',		bl_type_a:'check',		bl_type_s:'check', 
					 rev:'check',			non_rev:'check',		aes_y:'check',			aes_n:'check',			stop_cargo:'check', 
					 ro_y:'multi',			caed_y:'check',			caed_n:'check',			crn_no_flag:'check',	certi_y:'check',
					 certi_n:'check',		certi_d:'check',		certi_a:'check',        certi_b:'check',		certi_g:'check',
					 certi_c:'check',	    rate_check:'select',	bkg_sts_cd_i:'check',
					 sp_cargo_fu:'check',	sp_cargo_li:'check'	,	non_dg_chem_flg: 'check'			 
                    }
/*
 * Grid 칼럼 별 속성 정의
 * */                     
var arrGridColsProp= {	
					bkg_sts_cd             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'bkg_sts_cd' )",          
					si_flg                 :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'si_flg' )",              
					bkg_no                 :"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'bkg_no' )",              
					shpr_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'shpr_name' )",          
					por_cd                 :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'por_cd' )",              
					rep                    :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'rep' )",                 
					teu                    :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'teu' ,false, '', dfFloat,3)",                         
					bkg_mea_qty            :"InitDataProperty(0, cnt++ , dtData,  95, daLeft, true,  prefix + 'bkg_mea_qty' ,false, '', dfFloat,3)",           
					pck_tp_cd              :"InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix + 'pck_tp_cd' )",           
					dcgo_flg               :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'dcgo_flg' )",            
					rc_flg                 :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'rc_flg' )",              
					fd_grd_flg             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'fd_grd_flg' )",          
					itn_flg                :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'itn_flg' )",             
					caed_flg               :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'caed_flg' )",            
					bkg_ofc_cd             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'bkg_ofc_cd' )",          
					ctrt_ofc_cd            :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'ctrt_ofc_cd' )",         
					ob_sls_ofc_cd          :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'ob_sls_ofc_cd' )",       
					remark                 :"InitDataProperty(0, cnt++ , dtData,  180, daCenter, true,  prefix + 'remark' )",             
					sc_no                  :"InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix + 'sc_no' )",               
																 																																															 
					bdr_flg                :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'bdr_flg' )",             
					bl_no                  :"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'bl_no' )",               
					cnee_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'cnee_name' )",          
					del_cd                 :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'del_cd' )",              
					commodity              :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'commodity' )",
					feu                    :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'feu'  ,false, '', dfFloat,3)",                 
					bkg_actwgt_qty         :"InitDataProperty(0, cnt++ , dtData,  95, daCenter, true,  prefix + 'bkg_actwgt_qty'  ,false, '', dfFloat,3)",      
					rcv_term_cd            :"InitDataProperty(0, cnt++ , dtData,  55, daLeft, true,  prefix + 'rcv_term_cd' )",           
					de_term_cd             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'de_term_cd' )",          
					awk_cgo_flg            :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'awk_cgo_flg' )",         
					bb_cgo_flg             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'bb_cgo_flg' )",          
					pc                     :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'pc' )",                  
					itn_type               :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'itn_type' )",            
					caed_type              :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'caed_type' )",           
					doc_usr_id             :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'doc_usr_id' )",          
					ctrt_srep_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'ctrt_srep_cd' )",        
					ob_srep_cd             :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'ob_srep_cd' )",          
					ofc_team_cd            :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'ofc_team_cd' )",      
					rfa_no                 :"InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix + 'rfa_no' )",              
																 																																															 
					trunk_vvd              :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'trunk_vvd' )",
					dest_trns_svc_mod_cd   :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'dest_trns_svc_mod_cd' )",
					org_trns_svc_mod_cd    :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'org_trns_svc_mod_cd' )", 
					del_nod_cd             :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'del_nod_cd' )",
					por_nod_cd             :"InitDataProperty(0, cnt++ , dtData,  125, daCenter, true,  prefix + 'por_nod_cd' )",

					slan_cd                :"InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix + 'slan_cd' )",             
					bkg_cre_dt             :"InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix + 'bkg_cre_dt' )",          
					cmdt_cd                :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'cmdt_nm' )",
					pol_cd                 :"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'pol_cd' )",              
					pod_cd                 :"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'pod_cd' )",              
					shipper                :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'shipper' )",            
					consignee              :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'consignee' )",          
					ntfy                   :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'ntfy' )",               
					ffdr                   :"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'ffdr' )",               
					pre_1_vvd              :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'pre_1_vvd' )",           
					pre_2_vvd              :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'pre_2_vvd' )",           
					pre_3_vvd              :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'pre_3_vvd' )",           
					pre_4_vvd              :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'pre_4_vvd' )",           
					post_1_vvd             :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'post_1_vvd' )",          
					post_2_vvd             :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'post_2_vvd' )",          
					post_3_vvd             :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'post_3_vvd' )",          
					post_4_vvd             :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'post_4_vvd' )",          
					pre_1_pol_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_1_pol_cd' )",        
					pre_2_pol_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_2_pol_cd' )",        
					pre_3_pol_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_3_pol_cd' )",        
					pre_4_pol_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_4_pol_cd' )",        
					pre_1_pod_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_1_pod_cd' )",        
					pre_2_pod_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_2_pod_cd' )",        
					pre_3_pod_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_3_pod_cd' )",        
					pre_4_pod_cd           :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'pre_4_pod_cd' )",        
					bkg_clz_flg            :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'bkg_clz_flg' )",         
					ntfy_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'ntfy_name' )",          
					anty_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'anty_name' )",          
					ffdr_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'ffdr_name' )",          
					expt_name              :"InitDataProperty(0, cnt++ , dtData,  120, daLeft, true,  prefix + 'expt_name' )",          
					hngr_flg               :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'hngr_flg' )",            
					soc_flg                :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'soc_flg' )",             
					eq_subst_flg           :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'eq_subst_flg' )",        
					rd_cgo_flg             :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'rd_cgo_flg' )",          
					trunk_pol              :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'trunk_pol' )",           
					trunk_pod              :"InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix + 'trunk_pod' )",           
					hot_de_flg             :"InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix + 'hot_de_flg' )",          
					bkg_ctrl_ofc_cd        :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'bkg_ctrl_ofc_cd' )",     
					eq_ctrl_ofc_cd         :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'eq_ctrl_ofc_cd' )",      
					cntr_tpsz_cd           :"InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix + 'cntr_tpsz_cd' )",        
					cntr_no                :"InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix + 'cntr_no' )",             
					aes_no                 :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'aes_no' )",              
					caed_no                :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'caed_no' )" ,            
					shp_call_no				:"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'shp_call_no' )",             
					vsl_eng_nm				:"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'vsl_eng_nm' )" ,
					s_addr					:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 's_addr' )",            
					c_addr					:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'c_addr' )",            
					n_addr					:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'n_addr' )",            
					remark_detail			:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'remark_detail' )",
					inter_remark			:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'inter_remark' )",
					inter_remark_detail		:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'inter_remark_detail' )",
					dg_cmdt_desc			:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'dg_cmdt_desc' )",					
					chg_inter_remark		:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'chg_inter_remark' )",
					chg_inter_remark_detail	:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'chg_inter_remark_detail' )",
					chg_xter_remark			:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'chg_xter_remark' )",
					chg_xter_remark_detail	:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'chg_xter_remark_detail' )",
					rate_chk_sts			:"InitDataProperty(0, cnt++ , dtData,  120, daCenter, true,  prefix + 'rate_chk_sts' )",
					blck_stwg_cd			:"InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix + 'blck_stwg_cd' )",
					actual_pol				:"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'actual_pol' )",              
					actual_pod				:"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'actual_pod' )",
					act_cust_code			:"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'act_cust_code' )",              
					act_cust_name			:"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'act_cust_name' )",
					frt_term_cd				:"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'frt_term_cd' )",              
					chg_term_cd				:"InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix + 'chg_term_cd' )",
					etb_dt					:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'etb_dt' )",					
					sail_dt					:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'sail_dt' )",
					aloc_sts_cd				:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'aloc_sts_cd' )",
					
					cstms_desc				:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'cstms_desc' )",
					tel						:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'tel' )",
					cntc_pson_eml			:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'cntc_pson_eml' )",					
					si_cntc_pson_phn_no		:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'si_cntc_pson_phn_no' )",				
					si_cntc_pson_eml		:"InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix + 'si_cntc_pson_eml' )",
					cost_wk					:"InitDataProperty(0, cnt++ , dtData,  66, daCenter, true,  prefix + 'cost_wk' )",
					activity_teu            :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'activity_teu' ,false, '', dfFloat,3)",
					activity_feu            :"InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix + 'activity_feu'  ,false, '', dfFloat,3)"
					
	 				}

var arrGridColsTitle = {
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
					commodity            :'Commodity Code ',            
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
															 					               
					trunk_vvd            :'Trunk VVD ',           
					dest_trns_svc_mod_cd :'Dest Service Mode ',   
					org_trns_svc_mod_cd  :'Orgin Service Mode',   
					del_nod_cd           :'Dest Service Route',   
					por_nod_cd           :'Origin Service Route', 
					slan_cd              :'Lane',                 
					bkg_cre_dt           :'Booking Date',         
					cmdt_cd              :'Commodity Name',           
					pol_cd               :'POL(Vessel)',         
					pod_cd               :'POD(Vessel)',         
					shipper              :'Shipper Code ',        
					consignee            :'Consignee Code',       
					ntfy                 :'Notify Code',          
					ffdr                 :'Forward Code',         
					pre_1_vvd            :'Pre1.VVD',             
					pre_2_vvd            :'Pre2.VVD',             
					pre_3_vvd            :'Pre3.VVD',             
					pre_4_vvd            :'Pre4.VVD',             
					post_1_vvd           :'Post.VVD',             
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
					dg_cmdt_desc		 :'Mark & Description',					
					chg_inter_remark		 :'Charge Interal Remark',
					chg_inter_remark_detail  :'Charge Interal Remark Description',
					chg_xter_remark		 	 :'Charge External Remark',
					chg_xter_remark_detail   :'Charge External Description',
					rate_chk_sts		 :'Rate Check Status',
					blck_stwg_cd		 :'Block Stowage',
					
					actual_pol			 :'POL(BKG)',              
					actual_pod			 :'POD(BKG)',
					act_cust_code		 :'Actual Code',              
					act_cust_name		 :'Actual Name',
					frt_term_cd			 :'Freight Term',
					chg_term_cd			 :'Charge Terms',
					ofc_team_cd          :'L.TEAM',
					etb_dt		         :'ETB DT',					
					sail_dt		         :'Sailing DT',
					aloc_sts_cd	         :'Standby Status',
					
					cstms_desc	         :'Customs Description',

					tel     			 :'BKG Contact Phone Number',
					cntc_pson_eml	     :'BKG Contact E-Mail',
					si_cntc_pson_phn_no  :'SI  Contact Phone Number',
					si_cntc_pson_eml     :'SI  Contact E-Mail',
					cost_wk     		 :'REV.WEEK',
					
					activity_teu         :'Activity TEU',					
					activity_feu         :'Activity FEU'
					

				 	}

/**
 * RD 프린트 시 표시할 검색 조건 생성에 사용
 */
var searchOptionsMap = {
					vvd_cd 				:"form.vvd_cd.value",           
					lane_cd				:"form.lane_cd.value",          
					dir_cd				:"form.dir_cd.Text",           
					
					pol_cd				:"form.pol_cd.value",           
					pol_yard_cd			:"form.pol_yard_cd.value",      
					pol_local			:"form.pol_local.checked ? 'T.POL local':''",        
					pol_ts				:"form.pol_ts.checked ? 'POL TS':''",           
					pod_cd				:"form.pod_cd.value",           
					pod_yard_cd			:"form.pod_yard_cd.value",      
					pod_local			:"form.pod_local.checked ? 'T.POd local':''",        
					pod_ts				:"form.pod_ts.checked ? 'POD TS':''",           
					
					por_cd				:"form.por_cd.value",           
					del_cd				:"form.del_cd.value",           
					r_term				:"form.r_term.Text",                     
					d_term				:"form.d_term.Text",           
					
					zone_cd				:"form.zone_cd.options[form.zone_cd.selectedIndex].text",          
					deli_mode			:"form.deli_mode.Text",        
					
					board_from_dt		:"form.board_from_dt.value",    
					board_to_dt			:"form.board_to_dt.value",      						
					bkg_from_dt			:"form.bkg_from_dt.value",      
					bkg_to_dt			:"form.bkg_to_dt.value",
					eta_from_dt			:"form.eta_from_dt.value",      
					eta_to_dt			:"form.eta_to_dt.value",   
					
					bkg_kind			:"form.bkg_kind.Text",
					
					b_ofc_cd			:"form.b_ofc_cd.value",         
					b_staff_id			:"form.b_staff_id.Text",       
					ca_flag				:"form.ca_flag.checked ? 'CA':''",          

					fv_pre_pst_cd		:"( form.fv_pre_pst_cd[0].checked || form.fv_pre_pst_cd[1].checked  || form.fv_pol_local.checked  || form.fv_pod_local.checked || (form.fv_vvd_cd.value+form.fv_pol_cd.value+form.fv_pol_yard_cd.value+form.fv_pod_cd.value+form.fv_pod_yard_cd.value) != '' ?'Feeder Vessel-':'')+ (form.fv_pre_pst_cd[0].checked ?'PRE. ':'') + (form.fv_pre_pst_cd[1].checked ?'POST. ':'')",    
					fv_vvd_cd			:"form.fv_vvd_cd.value",        
					
					fv_pol_cd			:"form.fv_pol_cd.value",        
					fv_pol_yard_cd		:"form.fv_pol_yard_cd.value",   
					fv_pol_local		:"form.fv_pol_local.checked? 'POL local':''",     
					fv_pod_cd			:"form.fv_pod_cd.value",        
					fv_pod_yard_cd		:"form.fv_pod_yard_cd.value",   
					fv_pod_local		:"form.fv_pod_local.checked? 'POD local':''",     
					
					agent_cd			:"form.agent_cd.value",   
					
					eq_type				:"form.eq_type.Text",          
					cmdt_cd				:"form.cmdt_cd.value",          
					cmdt_nm				:"form.cmdt_nm.value",          
					
					wgt_from			:"form.wgt_from.value != '' ? 'WGT From ' + form.wgt_from.value + ' Ton':'' ",         
					wgt_to				:"form.wgt_to.value   != '' ? 'WGT To ' + form.wgt_to.value + ' Ton':'' ",         
					so_no				:"form.so_no.value",            
					
					l_ofc_cd			:"form.l_ofc_cd.value",         
					l_team_cd			:"form.l_team_cd.Text",          
					l_rep_id			:"form.l_rep_id.Text",         
					
					c_ofc_cd    		:"form.c_ofc_cd.value",     
					c_rep_id			:"form.c_rep_id.value",         
					
					ctr_rfa_no			:"form.ctr_rfa_no.value",       
					s_mode_ori			:"form.s_mode_ori.Text",       
					s_mode_dest			:"form.s_mode_dest.Text",      
					s_route_ori			:"form.s_route_ori.Text",      
					s_route_dest		:"form.s_route_dest.Text",     
					
					cust_tp_cd_s		:"form.cust_tp_cd_s.checked? 'Shipper':''",     
					cust_tp_cd_c		:"form.cust_tp_cd_c.checked? 'CNT':''",     
					cust_tp_cd_n		:"form.cust_tp_cd_n.checked? 'Notify':''",     
					cust_tp_cd_f		:"form.cust_tp_cd_f.checked? 'Forwarder':''",     
					cust_tp_cd_a		:"form.cust_tp_cd_a.checked? 'Also Notify':''",     
					cust_tp_cd_g		:"form.cust_tp_cd_g.checked? 'Group Customer':''",    
					
					customer	  		:"form.cust_cnt_cd.value + (form.cust_seq.value != '' ? ' SEQ:'+form.cust_seq.value:'') + (form.cust_nm.value != '' ? ' Name:'+form.cust_nm.value:'') + (form.cust_tp_cd.Text != '' ? ' Code:'+form.cust_tp_cd.Text:'')" ,
					
					sp_cargo_dg 		:"form.sp_cargo_dg.checked ? 'Danger':''",             
					sp_cargo_rf 		:"form.sp_cargo_rf.checked ? 'reffer':''",             
					sp_cargo_ak 		:"form.sp_cargo_ak.checked ? 'Awkward':''",            
					sp_cargo_bb 		:"form.sp_cargo_bb.checked ? 'Break Bulk':''",         
					sp_cargo_fu 		:"form.sp_cargo_fu.checked ? 'Fumigation':''",
					
					sp_cargo_hg 		:"form.sp_cargo_hg.checked ? 'Hanger':''",             
					sp_cargo_soc 		:"form.sp_cargo_soc.checked ? 'SOC':''",                
					sp_cargo_eq 		:"form.sp_cargo_eq.checked ? 'E.Sub':''",              
					sp_cargo_rd 		:"form.sp_cargo_rd.checked ? 'Reffer Dry':''",         
					sp_cargo_li 		:"form.sp_cargo_li.checked ? 'Hide Liner':''",
					
					sp_cargo_pc 		:"form.sp_cargo_pc.checked ? 'Precaution':''",         
					sp_cargo_fg 		:"form.sp_cargo_fg.checked ? 'Food Grade':''",         
					sp_cargo_hd 		:"form.sp_cargo_hd.checked ? 'SPC.HD':''",    
					sp_cargo_rb 		:"form.sp_cargo_rb.checked ? 'Rail Bulk':''", 
					
					cargo_tp_p 			:"form.cargo_tp_p.checked ? 'P.Empty Cgo Type':''",   
					cargo_tp_f 			:"form.cargo_tp_f.checked ? 'Full CGO':''",           
					cargo_tp_r 			:"form.cargo_tp_r.checked ? 'R.Empty Cgo Type':''",   
					
					bl_type_a 			:"form.bl_type_a.checked ? 'Ahead':''",              
					bl_type_s 			:"form.bl_type_s.checked ? 'Short':''",              
					rev 			    :"form.rev.checked ? 'Revenue Empty':''",      
					non_rev 			:"form.non_rev.checked ? 'Non Rev':''",            
					
					aes_y 			    :"(form.aes_y.checked ? 'AES:Y':'')+(form.aes_n.checked ? 'AES:N':'')",                
					stop_cargo 			:"form.stop_cargo.checked ? 'STOP CGO':''",           
					ro_y 			    :"form.ro_y.Text != '' ? 'Roll Over:'+form.ro_y.Text:''",          
					
					caed_y 			    :"(form.caed_y.checked ? 'CAED:Y':'')+(form.caed_n.checked ? 'CAED:N':'')",               
					crn_no_flag 		:"form.crn_no_flag.checked ? 'CRN':''",
					
					certi_d 			:"form.certi_d.checked ? 'D/G Rider':''",             
					certi_a 			:"form.certi_a.checked ? 'A/K Rider':''",             
					certi_b 			:"form.certi_b.checked ? 'B/B Rider':''",            
					certi_g 			:"form.certi_g.checked ? 'B/L Rider':''",                 
					certi_c 			:"form.certi_c.checked ? 'Certificate':''",
					certi_y 			:"(form.certi_y.checked ? 'Certificate:Y':'')+(form.certi_n.checked ? 'Certificate:N':'')",        
					
					bkg_sts_cd_f 		:"form.bkg_sts_cd_f.checked ? 'FFirm':''",              
					bkg_sts_cd_x 		:"form.bkg_sts_cd_x.checked ? 'Booking Cancel':''",     
					bkg_sts_cd_a 		:"form.bkg_sts_cd_a.checked ? 'Pseudo Booking':''",     
					bkg_sts_cd_i 		:"form.bkg_sts_cd_i.checked ? 'Invalid VVD':''",  
					
					bkg_sts_cd_w 		:"form.bkg_sts_cd_w.checked ? 'Waiting BKG':''",        
					non_sp_cargo 		:"form.non_sp_cargo.checked ? 'Non Approval Cgo':''",   
					holding  			:"form.holding .checked ? 'Holding':''",
					
					rate_check			:"form.rate_check.value"
					}
/**
 *  RD 프린트 시 표시할 검색 조건 제목
 */
var searchOptionsTitleMap = {	
							vvd_cd           :"form.trunk_flag.checked ? 'T.VVD-':'VVD-'",                
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
							board_from_dt    :"'ETD From Date-'",     
							board_to_dt      :"'ETD To Date-'",      
							bkg_from_dt      :"'BKG Date From-'",     
							bkg_to_dt        :"'BKG Date To-'",      
							eta_from_dt      :"'ETA Date From-'",     
							eta_to_dt        :"'ETA Date To-'",      
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
							l_team_cd        :"'L/Team-'",               
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
							     
							customer         :"'CUSTOMER-'",           
							        
							sp_cargo_dg      :"''",             
							sp_cargo_rf      :"''",             
							sp_cargo_ak      :"''",            
							sp_cargo_bb      :"''",
							sp_cargo_fu      :"''",
							sp_cargo_hg      :"''",             
							sp_cargo_soc     :"''",                
							sp_cargo_eq      :"''",              
							sp_cargo_rd      :"''",
							sp_cargo_li      :"''",
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
							bkg_sts_cd_i     :"''",     
							bkg_sts_cd_w     :"''",        
							non_sp_cargo     :"''",   
							holding          :"''",
							rate_check		 :"''"
							}

/*
 * orderby Title 네임 
 * */													
var arrOrderbyTitleMap = {	
						bkg_cre_dt:'Booking Date',					bkg_ofc_cd:'Booking Office',			ob_sls_ofc_cd:'Sales Office',			doc_usr_id:'Booking Staff',	ob_srep_cd:'Sales Rep', 
						bkg_sts_cd:'Booking Status',				shpr_name:'Shipper',					cnee_name:'Consignee',					ntfy_name:'Notify',			ntfy:'Notify Code', 
						rep:'Rep Commodity',						commodity:'Commodity',					rcv_term_cd:'Receiving Term',			de_term_cd:'Delivery Term',	org_trns_svc_mod_cd:'Orgin Service Mode', 
						dest_trns_svc_mod_cd:'Dest Service Mode',	org_svc_route:'Origin Service Route',	dest_svc_route:'Dest Service Route',	por_cd:'POR',				pol_cd:'POL', 
						pod_cd:'POD',								del_cd:'DEL',							sort_pre_pol:'Pre POL',					sort_pre_pod:'Pre POD',		sort_post_pol:'Post POL', 
						sort_post_pod:'Post POD',					trunk_vvd:'Trunk VVD',					sort_pre_vvd:'Pre VVD',					sort_post_vvd:'Post VVD',	slan_cd:'Lane', 
						trunk_pol:'Trunk VVD POL',					trunk_pod:'Trunk VVD POD',				por_eq_ofc:'POR EQ Office',				del_eq_ofc:'DEL EQ Office',	cmdt_nm:'Commodity Name', 
						sc_no:'Contract No',						actual_pol:'POL(Booking)',				rfa_no:'Auth No',						actual_pod:'POD(Booking)',	ctrt_ofc_cd:'Contract Office', 
						china_agent_cd:'China Agent Code',			ctrt_srep_cd:'Contract Sales Rep',		ffdr:'F/Forwarder Code',				shipper_cd:'Shipper Code',	consignee_cd:'Consignee Code',
						frt_term_cd:'Freight Term',					chg_term_cd:'Charge Terms',				ofc_team_cd:'L.Team'
						}

var orderby="";
var defaultOrderby="pol_cd,pod_cd";
var defaultOrderbyTitleSql="'POL : '||POL_CD||' / POD: '||POD_CD";
var locCdList = "";
/*
 * OrderBy Title생성에 필요한 칼럼을 미리 만든다
 * RD에서 Group으로 묶기위해 미리 js에서 생성해서 넘긴다.
 * 'POL : '||POL_CD||' / POD : '||POD_CD
 * 쿼리 예상 결과 POL : USLGB / POD : AUBNE  
 * */
var orderbyTitleSql="";

/*
 * POP-UP에서 받는 Sort 세팅
 * */
function setOrderBy(val){
	//alert(val);
	var arrSort = val.split(",");
	var cnt = 0;
	var tempStr;
	for(var i=0; i < arrSort.length; i++){
		tempStr = arrSort[i].toLowerCase();
		if(arrOrderbyTitleMap[tempStr] == undefined){	
			continue;
		}
		if(cnt==0){
			orderby = tempStr;
			orderbyTitleSql = "'"+arrOrderbyTitleMap[tempStr]+":'||"+tempStr;
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
}						 
/*
 * 104화면 Item Option 으로 등록한 Table Column
 * 선택된 것을 먼저 구성하고 나머지는 Hidden처리 함. 
 * */
var selectedGridCols;

     
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
 
var prefix  = "sheet1_";//IBSheet 구분자
var prefix2 = "sheet2_";//IBSheet 구분자
//var rowsPerPage = 50;//paging
var rowsPerPage = 999999;//paging
 
var sheetObjectsMap = new Array();
 
var l_rep_id_cdMultiComboDataAdded = false;
/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();
var b_staff_idMultiComboDataAdded = false;
var l_rep_idMultiComboDataAdded = false;
var l_team_cdMultiComboDataAdded = false;
/*********************** EDTITABLE MULIT COMBO END ********************/
 
/*********************** TAB START ********************/
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
/*********************** TAB START ********************/
 	
/**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}
     
 /**
   * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
   * ComComboObject생성자 메소드에서 호출됨 
   * param : comboObj ==> 콤보오브젝트
   * 
   */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
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
		sheetObjectsMap[sheetObjects[i].id] = sheetObjects[i];
	}
	    
	//MultiCombo초기화 
 	for(var k=0;k<comboObjects.length;k++){
 		initCombo(comboObjects[k],comboObjects[k].id);
 	}
 	    	
 	for(k=0;k<tabObjects.length;k++){
 		initTab(tabObjects[k],k+1);
    }
    ComBtnDisable("btn_Print");
 
    form.rows_per_page.value = rowsPerPage;
    //debug.innerHTML = form.rows_per_page.value; 
    //setItemOptionHidden();//Item Option Hidden 처리
    initControl();
    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
     //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
    doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
    
    setFeederVessel(); // Trunk에 따라 Feeder Vessel 초기화
    setCRNNo();// POD T/S에 따라 CRN No. 초기화
    if(!form.pod_ts.checked){
    	sheetObjects[1].ColHidden(prefix + "shp_call_no") = true;
    	sheetObjects[1].ColHidden(prefix + "vsl_eng_nm")  = true;
    }
    form.sp_cargo_ge.disabled = true;
    
}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
    var formObject = document.form
	initComboEditable(comboObj, comboId)
}    
	 	
//콤보 멀티 셀렉트 및 수정 여부 초기 설정
function initComboEditable(combo, comboId){
 	with (combo) {
 		if(comboId == "b_staff_id" || comboId == "report_type" || comboId == "ro_y"  ){

 			MultiSelect = false;
 	 		UseAutoComplete = true; 
 	 		UseEdit = false;	 
	 	  	 			
 		} else if( comboId == "rct_rhq_cd" ){
 			
 	 		MultiSelect = false;
 	 		UseAutoComplete = true; 
 	 		UseEdit = false;	 
 	 		
 	 		DropHeight = 200;
			UseAutoComplete = true;
			ValidChar(2, 0);    // 영문대문자만 입력
            MaxLength = 6;      // 6자리만 입력
	 	 
        	DropHeight = 200;
        	//SetTitle("|");
        	SetColWidth("50|200");
        	InsertItem(0,"|All","");
        	MaxLength = 6;
        	ValidChar(2, 0);
            Index2 = 0;
            
 		} else if(comboId == "l_rep_id" || comboId == "l_team_cd"){
 	 		MultiSelect = false;
	 	  	UseEdit = true;
 		}else if( comboId == "blck_stwg_cd"){
 			combo.MultiSelect = true;
 			combo.UseEdit = false;
 			combo.SetColWidth("50|250");
 			combo.SetColAlign("left|left");
 	 	} else {
	 	 	MultiSelect = true;
	 	 	UseEdit = false;	 	 			
 	 	}
 	        
	}
}
	     
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;

}
    
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "Search" , -1 );
                InsertTab( cnt++ , "Result" , -1 );
                InsertTab( cnt++ , "Summary by CNTR" , -1 );    
            }
         break;
     }
}
    
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;

	if ( document.all.bkgOfcList.style.display == "block" ){
		bkgOfcListPopUp();
	}
}
    
function initControl() {
	var formObject = document.form;

    axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
    axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
    axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm ('change', 'bkg_change', formObject);
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
    	case "custname":
    	  	//영문,숫자,공백,기타문자(.,등)
    	  	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
    	  	break;	            
      	default:
      		break;
    }
}  
	
/**
 * HTML Control의 onBlur을 제어한다.
 **/
function bkg_blur() {	
	var formObj = document.form;
 	
    switch (event.srcElement.getAttribute("name")) {
    	case "b_ofc_cd_1":
			//alert('blur');
    				
    		//alert("Blur-"+formObj.b_ofc_cd_1.value);
    	  	var ofcListcnt = 0;
    	  	
    		if ( sheetObjects[0].RowCount < 1 ) {
				sheetObjects[0].DataInsert(-1);
			}
			sheetObjects[0].CellValue2(1, "ofc_cd") = document.form.b_ofc_cd_1.value;
			for( var j=sheetObjects[0].RowCount;j>0;j--){
				if ( ComTrim(sheetObjects[0].CellValue(j, "ofc_cd")).length > 0){
					ofcListcnt = ofcListcnt + 1;
				}else {
					sheetObjects[0].RowDelete(j, false);
				}
			}
			b_ofc_cd_cnt.innerHTML = ofcListcnt;
			
			/* OnBlur 일 때 한번,조회시 한번 더 계산함 - enter이벤트시 onbluer와 조회 이벤트가 거의 동시에 발생 되기 때문 */
			var bkgOfcList = "";	    	  	
			for( var i=0;i<sheetObjects[0].RowCount;i++){
				if ( i == 0 ){
					bkgOfcList = sheetObjects[0].CellValue(i+1, "ofc_cd");
				} else {
					bkgOfcList = bkgOfcList + ',' + sheetObjects[0].CellValue(i+1, "ofc_cd");
				}    				
			}
			document.form.b_ofc_cd.value = bkgOfcList;
    		doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','b_ofc_cd');
    		doActionIBSheet(sheetObjects[1],document.form,SEARCH07);
			break;	    		
    	case "l_ofc_cd":
    		doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','l_ofc_cd');
    		doActionIBSheet(sheetObjects[1],document.form,SEARCH06);
			break;	    		
    	case "board_from_dt":
    		ComAddSeparator(event.srcElement);
			break;	    		
    	case "board_to_dt":
    		ComAddSeparator(event.srcElement);
			break;	    		
    	case "bkg_from_dt":
    		ComAddSeparator(event.srcElement);
			break;	    		
    	case "bkg_to_dt":
    		ComAddSeparator(event.srcElement);
			break;	    		
    	case "eta_from_dt":
    		ComAddSeparator(event.srcElement);
			break;	    		
    	case "eta_to_dt":
    		ComAddSeparator(event.srcElement);
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
    	case "board_from_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
    	case "board_to_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
    	case "bkg_from_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
    	case "bkg_to_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
    	case "eta_from_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
    	case "eta_to_dt":
    		if (ComIsNull(form.vvd_cd)) form.trunk_flag.checked = true;
    		ComClearSeparator(event.srcElement);
			break;
		default:
			break;
	}
}

/**
  * Trunk에 따라 Feeder Vessel 초기화 
  * param : 
  * Trunk에 따라 Feeder Vessel 초기화 
  */ 
function setFeederVessel(){
	if(form.trunk_flag.checked){
		form.fv_vvd_cd.disabled        = false;
		form.fv_pre_pst_cd[0].disabled = false;
		form.fv_vvd_cd.disabled        = false;
		form.fv_pre_pst_cd[0].disabled = false;
		form.fv_pre_pst_cd[1].disabled = false;
		form.fv_vvd_cd.disabled        = false;
		form.fv_pol_cd.disabled        = false;
		form.fv_pol_yard_cd.disabled   = false;
		form.fv_pol_local.disabled     = false;
		form.fv_pod_cd.disabled        = false;
		form.fv_pod_yard_cd.disabled   = false;
		form.fv_pod_local.disabled     = false;
		form.fv_vvd_cd.style.background = "#FFFFFF";
		form.fv_pol_cd.style.background = "#FFFFFF";
		form.fv_pol_yard_cd.style.background = "#FFFFFF";
		form.fv_pod_cd.style.background      = "#FFFFFF";
		form.fv_pod_yard_cd.style.background = "#FFFFFF";		
	}else{
		form.fv_vvd_cd.value = "";
		form.fv_pre_pst_cd[0].checked = false;
		form.fv_pre_pst_cd[1].checked = false;
		form.fv_vvd_cd.value          = "";
		form.fv_pol_cd.value          = "";
		form.fv_pol_yard_cd.value     = "";
		form.fv_pol_local.checked     = false;
		form.fv_pod_cd.value          = "";
		form.fv_pod_yard_cd.value     = "";
		form.fv_pod_local.checked     = false;
		
		form.fv_vvd_cd.disabled        = true;
		form.fv_vvd_cd.disabled        = true;
		form.fv_pre_pst_cd[0].disabled = true;
		form.fv_pre_pst_cd[0].disabled = true;
		form.fv_pre_pst_cd[1].disabled = true;
		form.fv_vvd_cd.disabled        = true;
		form.fv_pol_cd.disabled        = true;
		form.fv_pol_yard_cd.disabled   = true;
		form.fv_pol_local.disabled     = true;
		form.fv_pod_cd.disabled        = true;
		form.fv_pod_yard_cd.disabled   = true;
		form.fv_pod_local.disabled     = true;
		
		form.fv_vvd_cd.style.background = "#E8E7EC";
		form.fv_pol_cd.style.background = "#E8E7EC";
		form.fv_pol_yard_cd.style.background = "#E8E7EC";
		form.fv_pod_cd.style.background      = "#E8E7EC";
		form.fv_pod_yard_cd.style.background = "#E8E7EC";
		
	}
}	
/**
 * POD T/S에 따라 CRN No.체크버튼 초기화 
 * param : 
 */ 
function setCRNNo(){
	if(form.pod_ts.checked){
		form.crn_no_flag.disabled        = false;
		form.crn_no_flag.style.background = "#FFFFFF";
	}else{
		form.crn_no_flag.checked     = false;
		form.crn_no_flag.disabled    = true;		
		form.crn_no_flag.style.background = "#E8E7EC";		
	}
}	

/*********************** KEY EVENT END ********************/  

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
var tempSqlCon = "";
var nullMultiComboStr = "<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
var roYComboStr = "<SHEET> <DATA COLORDER='val|desc' COLSEPARATOR=',' TOTAL='6'> 	<TR><![CDATA[,]]></TR> 	<TR><![CDATA[1,Over 1 time]]></TR> 	<TR><![CDATA[2,Over 2 times]]></TR> 	<TR><![CDATA[3,Over 3 times]]></TR> 	<TR><![CDATA[4,Over 4 times]]></TR> 	<TR><![CDATA[5,Over 5 times]]></TR> </DATA> </SHEET> ";

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[1];
				
	var comboObject1 = comboObjects[0]; 
	/*******************************************************/
	var formObject = document.form;
	     		
	var srcName = window.event.srcElement.getAttribute("name");


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
			self.close();
			break;
		case "btn_Set":
			setConditionAndInitSheet(tempSqlCon);
			break;
		case "btn_New":
			var temp = form.p_report_type.value;
			initAll(formObject);
			form.p_report_type.value = temp;
			//sheetObject1.RemoveAll();  
  
			break;
		case "btn_Close":
			self.close();
			break;
		case "btn_ReportTemplate": 		
			var retVal = ComOpenPopup('/hanjin/ESM_BKG_0104.do?p_bkg_rpt_knd_cd=B', 820, 460, 'TemplateSet', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
			break;
					 								
		case "btn_commodity_pop": 		
			comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
			break;		 								
		case "btn_ctr_fra_pop": 		
			var param= "?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
			ComOpenPopup('/hanjin/COM_ENS_021.do'+param, 780, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
			break;		 								
		
		case "btn_customer_pop":
			var param= "" ;
			param = "?cust_cd="+formObject.cust_cnt_cd.value;
			if(formObject.cust_seq.value != ""){

	    		var cust_seq = formObject.cust_seq.value;
	    		if(!ComIsNumber(cust_seq) && cust_seq.length != 0 ){
	    	 		ComShowCodeMessage("BKG00458"); // invalid customer code
	    	 		tabObjects[0].SelectedIndex = 0;
	    	 		formObject.cust_seq.focus();
	    	 		return false;
	    	 	}
	    	 	
			  	param += eval(formObject.cust_seq.value);
			}
			param += "&cust_nm="+formObject.cust_nm.value;	
			ComOpenPopup('/hanjin/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
			break;		
			
			
			
		case "btn_0019Pop":
    	//	if(sheetObjects[1].Rows>2){
    			//var trunkRow = sheetObjects[1].FindText("vsl_pre_pst_cd","T");
			var vvdCd = ComGetObjValue(formObject.vvd_cd);
    		var	polCd = ComGetObjValue(formObject.fv_pol_cd);
    		var	podCd = ComGetObjValue(formObject.fv_pod_cd);
    		//}
    		
    		comBkgCallPop0019('callBack0019', vvdCd, polCd, podCd);
//    		comBkgCallPop0019('callBack0019', vvdCd,"","");
			break;    	
			
			
	
			
		case "btn_board_date":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.board_from_dt, formObject.board_to_dt,'yyyy-MM-dd');
		 	break;
        case "btn_bkg_date":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
			break; 			
        case "btn_eta_date":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.eta_from_dt, formObject.eta_to_dt,'yyyy-MM-dd');
			break; 								
        case "cust_tp_cd_g":
			if(form.cust_tp_cd_g.checked){
				form.cust_tp_cd_s.checked = false;
				form.cust_tp_cd_c.checked = false;
				form.cust_tp_cd_n.checked = false;
				form.cust_tp_cd_f.checked = false;
				form.cust_tp_cd_a.checked = false;
			}
			break; 	
        case "trunk_flag":
			setFeederVessel();
			break; 									
        case "cust_tp_cd_s":
			form.cust_tp_cd_g.checked =false;
			break; 								
        case "cust_tp_cd_c":
			form.cust_tp_cd_g.checked =false;
			break; 								
        case "cust_tp_cd_n":
			form.cust_tp_cd_g.checked =false;
			break; 								
        case "cust_tp_cd_f":
			form.cust_tp_cd_g.checked =false;
			break; 								
        case "cust_tp_cd_a":
			form.cust_tp_cd_g.checked =false;
			break;
			 								
		case "pol_local":
			if(form.pol_local.checked){
				form.pol_ts.checked = false;
			}
			break; 		
		case "pol_ts":
			if(form.pol_ts.checked){
				form.pol_local.checked = false;
			}
			break; 										
		case "pod_local":
			if(form.pod_local.checked){
				form.pod_ts.checked = false;
			}
			break; 		
		case "pod_ts":
			if(form.pod_ts.checked){
				form.pod_local.checked = false;
			}
			setCRNNo();
			break; 										
		case "rev":
			if(form.rev.checked){
				form.non_rev.checked = false;
			}
			break; 		
		case "non_rev":
			if(form.non_rev.checked){
				form.rev.checked = false;
			}
			break; 		
		case "aes_y":
			if(form.caed_y.checked || form.caed_n.checked ){
				ComShowCodeMessage("BKG95096","CAED","CAED","AES/ITN");
				form.aes_y.checked = false;
			} else if(form.aes_y.checked){
				form.aes_n.checked = false;
			}
			break; 		
		case "aes_n":
			if(form.caed_y.checked || form.caed_n.checked ){
				ComShowCodeMessage("BKG95096","CAED","CAED","AES/ITN");
				form.aes_n.checked = false;
			} else if(form.aes_n.checked){
				form.aes_y.checked = false;
			}
			break;
//		case "ro_y":
//			if(form.ro_y.checked){
//				form.ro_n.checked = false;
//			}
//			break; 		
//		case "ro_n":
//			if(form.ro_n.checked){
//				form.ro_y.checked = false;
//			}
//			break; 		
		case "caed_y":
			if(form.aes_y.checked || form.aes_n.checked ){
				ComShowCodeMessage("BKG95096","AES/ITN","AES/ITN","CAED");
				form.caed_y.checked = false;
			} else if(form.caed_y.checked){
				form.caed_n.checked = false;
			}
			break; 		
		case "caed_n":
			if(form.aes_y.checked || form.aes_n.checked ){
				ComShowCodeMessage("BKG95096","AES/ITN","AES/ITN","CAED");
				form.caed_n.checked = false;
			} else if(form.caed_n.checked){
				form.caed_y.checked = false;
			}
			break; 		
		case "certi_y":
			if(form.certi_y.checked){
				form.certi_n.checked = false;
			}
			break; 		
		case "certi_n":
			if(form.certi_n.checked){
				form.certi_y.checked = false;
			}
			break; 
		case "bl_type_a":
			if(form.bl_type_a.checked){
				form.bl_type_s.checked = false;
			}
			break; 		
		case "bl_type_s":
			if(form.bl_type_s.checked){
				form.bl_type_a.checked = false;
			}
			break; 
			
		case "btn_DownExcel":
			var search_report_id =  form.p_report_type.value; 
			if(search_report_id =="ak" || search_report_id =="bb" || search_report_id =="dg" || search_report_id =="rf" || search_report_id =="cntr"){
				sheetObjectsMap[search_report_id].Redraw = false;
				sheetObjectsMap[search_report_id].LoadSearchXml("<?xml version='1.0' ?>"+ComReplaceStr(excelXml, "sheet1", search_report_id));
				sheetObjectsMap[search_report_id].Redraw = true;
				doActionIBSheet(sheetObjectsMap[search_report_id],formObject,IBDOWNEXCEL);
			}else if(search_report_id =="G" ){
				sheetObjectsMap["sheet2"].Redraw = false;
				sheetObjectsMap["sheet2"].LoadSearchXml("<?xml version='1.0' ?>"+ComReplaceStr(excelXml, "sheet1", "sheet2"));
				sheetObjectsMap["sheet2"].Redraw = true;
				doActionIBSheet(sheetObjectsMap["sheet2"],formObject,IBDOWNEXCEL);
			}else {
				doActionIBSheet(sheetObjectsMap["sheet1"],formObject,IBDOWNEXCEL);
			}
			break;
		case "btn_DownExcel_Summary":
			var sheetObj = sheetObjectsMap["summary"];
			if (sheetObj.RowCount < 1) {
				ComShowCodeMessage("COM12189");
				return;
			}
			var op_sheet = sheetObjectsMap["search_options"];
			op_sheet.removeAll();
			var row = op_sheet.DataInsert(-1);
			op_sheet.CellValue(row, "search_options") = getSearchOptions();
  
			op_sheet.SpeedDown2Excel(-1);
			sheetObj.SpeedDown2Excel(1,true);
			break;
										
		case "btn_Retrieve":
			setReportType();
//		 	setOrderBy('pol_cd|pod_cd'); // 추후 삭제
//		 	setOrderBy('pod_cd');
			if ( formObject.b_ofc_cd.value.length < 5 ){
				formObject.b_ofc_cd.value = formObject.b_ofc_cd_1.value;
			}
			// 정상적으로 b_ofc_cd 컬럼에 값이 들어가지 않아 두번 Call 하여 처리함. - 2011.07.25 김영철
//			bkgOfcListPopUp();
//			bkgOfcListPopUp();
							
		 	doActionIBSheet(sheetObject1,formObject,IBSEARCH);

		 	break;
		case "btn_Retrieve_Summary":
			setReportType();
//		 	setOrderBy('pol_cd|pod_cd'); // 추후 삭제
//		 	setOrderBy('pod_cd');
			options_summary.innerHTML = " * Search Options ["+getSearchOptions()+"]";
			doActionIBSheet(sheetObjectsMap["summary"],formObject,SEARCH04);

			break;
					 					
		case "btn_Total":
			setReportType();
			doActionIBSheet(sheetObjects[1],formObject,RDPRINT,null,null,null,"TOTAL");
			break;
		case "btn_Preview":
			setReportType();
			doActionIBSheet(sheetObjects[1],formObject,RDPRINT);
			break;
		case "btn_Page_Break_Preview":
			setReportType();
			doActionIBSheet(sheetObjects[1],formObject,RDPRINT,null,null,null,"PAGE_BREAK");
			break;
		case "btn_Print":
			setReportType();
			doActionIBSheet(sheetObjects[1],formObject,PRINT);
		break;
		case "btn_Sort":
			ComOpenWindowCenter2("/hanjin/ESM_BKG_0161.do?isPop=Y&codeGubun=CD02196", "OrderBy", 400,230,false,"scrollbars=no,resizable=yes");
			//window.open("/hanjin/ESM_BKG_0161.do?codeGubun=CD02196", "OrderBy", "width:400,height:230");
			break;  
		case "btn_multi_ofc":
			bkgOfcListPopUp();
			break;
		case "ofc_list_add":
			sheetObjects[0].DataInsert(-1);
			break;
		case "ofc_list_del":
			if (sheetObjects[0].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjects[0].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjects[0].RowDelete(arrRow[idx], false);
				}
			}
			break;
	} // end switch
}
    
/*
 *  리포트 타입을 설정한다.
 */
function setReportType() {
	if(tempform.report_type.Text =="General(Awkward)"){
		form.p_report_type.value="ak";
    }else if(tempform.report_type.Text =="General(Break Bulk)"){
		form.p_report_type.value="bb";
    }else if(tempform.report_type.Text =="General(Dangerous)"){
		form.p_report_type.value="dg";
    }else if(tempform.report_type.Text =="General(Reefer)"){
		form.p_report_type.value="rf";
    }else if(tempform.report_type.Text =="Genearl(Reefer) by CNTR"){
		form.p_report_type.value="cntr";		
    }else if(tempform.report_type.Text == "General" || selectColList ==""){
    	form.p_report_type.value="G";
    }else{
    	form.p_report_type.value="P";
    }
}
    
function openWinCenter(url,winName,width,height , scrollYn) {
    var left = (screen.width - width)/2;    
    if(left < 0) {
	    left = 0;
    }
    var top  = (screen.height- width)/2;   
    if( top < 0 ) {
 	   top = 0;
    }
    
    if (ComIsNull(scrollYn)) {
 	   scrollYn = "no";
    } else {
 	   if (scrollYn == "Y") {
 		   scrollYn = "yes";
 	   } else {
 		   scrollYn = "no";
 	   }
    }
    var feature = 
 	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
    
    return window.open(url,winName,feature);
}
		
/***
 * 검색 옵션을 생성한다
 */

function  getSearchOptions(){
	var options ="";
	var temp = "";
	for (var key in searchOptionsMap){ //선택된헤더 컬럼 외 나머지 컬럼 헤더 생성
		temp = eval(searchOptionsMap[key]);
		if(temp != "") {
			options += eval(searchOptionsTitleMap[key])+temp + "  |  ";
		}
	}
	return options.substring(0,options.length-5);
}
         			
// Sheet관련 프로세스 처리
var arrMultiCombo;//멀티콤보 세팅할 변수
//var orderbyCnt=0;//Order By Title 개수 - 페이징 처리에서 제외함
var realTotalCnt=0;//실 데이타 총 개수
var currPage=1;//페이징 처리: 현재 페이지
var totalPage=1;//총 페이지
var excelXml;
var setTimeOutYN  = false;//onblur와 조회 메서드가 동시에 먹는것을 방지하기 위해서 setTimeOut으로 돌린다.
 
function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
   	sheetObj.ShowDebugMsg = false;
    switch(sAction) {
		case IBSEARCH:      //조회
			ComOpenWait(true);
			temp_input.focus();
			if(!setTimeOutYN){//현재 setTimeOut으로 조회 메소드가 실행중이지 않으면 setTimeOut을 실행한다. BKG Office onBlur메소드 순서 충돌문제 해결을 위함 
				setTimeOutYN = true;
				setTimeout(function(){
					doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun);
				}, 1000);
				return;
			}else{
				setTimeOutYN = false;
			}
			//alert(0);
			var bkgOfcList = "";	    	  	
			for( var i=0;i<sheetObjects[0].RowCount;i++){
				if ( i == 0 ){
					bkgOfcList = sheetObjects[0].CellValue(i+1, "ofc_cd");
				} else {
					bkgOfcList = bkgOfcList + ',' + sheetObjects[0].CellValue(i+1, "ofc_cd");
				}    				
			}
			document.form.b_ofc_cd.value = bkgOfcList;
			
			if(!validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(false);
				return;
			}
			
			options.innerHTML = " * Search Options ["+getSearchOptions()+"]";
			
			//alert("Search"+formObj.b_ofc_cd_1.value);
			//return;
			tab1.SelectedIndex = 1;// 결과 탭으로 전환
			formObj.f_cmd.value = SEARCH;
			/**
			 * 페이징 변수 초기화 
			 */
			currPage=1;
			formObj.curr_page.value = currPage;
			if(orderby==""){
				formObj.orderby.value = defaultOrderby;
				formObj.orderby_title_sql.value = defaultOrderbyTitleSql;
				
			}else{
				formObj.orderby.value = orderby;
				formObj.orderby_title_sql.value = orderbyTitleSql;
			}
			
			formObj.rows_per_page.value = rowsPerPage;
			formObj.last_orderby.value="";
			sheetObj.RemoveAll();
			sheetObjectsMap["sheet2"].RemoveAll();
			sheetObjectsMap["ak"].RemoveAll();
			sheetObjectsMap["bb"].RemoveAll();
			sheetObjectsMap["dg"].RemoveAll();
			sheetObjectsMap["rf"].RemoveAll();
			sheetObjectsMap["cntr"].RemoveAll();
			
			total_bkg.value = "";							  
			total_bl .value = "";							  
			total_teu.value = "";							  
			total_feu.value = "";							  
			total_wgt.value = "";	
			total_mea.value = "";	
			total_all_teu.value = "";
			pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화

			if(form.p_report_type.value == "G"){										
				if(form.pol_cd.value.substring(0,2)=='US' || form.pol_cd.value.substring(0,2)=='US'){
					 sheetObjects[1].ColHidden(prefix + "itn_flg") = false;
					 sheetObjects[1].ColHidden(prefix + "itn_type") = false;
				}else{
					 sheetObjects[1].ColHidden(prefix + "itn_flg") = true;
					 sheetObjects[1].ColHidden(prefix + "itn_type") = true;
				}
				
				if(form.por_cd.value.substring(0,2)=='CA' || form.pol_cd.value.substring(0,2)=='CA'){
					 sheetObjects[1].ColHidden(prefix + "caed_flg") = false;
					 sheetObjects[1].ColHidden(prefix + "caed_type") = false;
				}else{
					 sheetObjects[1].ColHidden(prefix + "caed_flg") = true;
					 sheetObjects[1].ColHidden(prefix + "caed_type") = true;
				}
				
				if(!form.crn_no_flag.checked){
					 sheetObjects[1].ColHidden(prefix + "shp_call_no") = true;
					 sheetObjects[1].ColHidden(prefix + "vsl_eng_nm")  = true;
				}else{
					 sheetObjects[1].ColHidden(prefix + "shp_call_no") = false;
					 sheetObjects[1].ColHidden(prefix + "vsl_eng_nm")  = false;
				}
			}
			
			var sXml = "";
			sheetObjects[1].WaitImageVisible = false;
			if(form.p_report_type.value =="ak"){
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
					
			}else if(form.p_report_type.value =="bb"){
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
					
			}else if(form.p_report_type.value =="dg"){
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
					
			}else if(form.p_report_type.value =="rf"){
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103_04GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			}else if(form.p_report_type.value =="cntr"){
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103_04GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			}else {
				sXml = sheetObj.GetSearchXml("ESM_BKG_0103GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			}

			var arrSXml = sXml.split("|$$|");
			sheetObjects[1].Redraw = false;    
			if(form.p_report_type.value =="P"){
				sheetObjects[1].LoadSearchXml("<?xml version='1.0' ?>"+arrSXml[1]); 
			}else{
				sheetObjects[1].LoadSearchXml("<?xml version='1.0' ?>"+arrSXml[0]); 
			}
							
			sheetObjects[1].Redraw = true;
			ComOpenWait(false);
//			debug.innerHTML = sheetObjects[0].TotalRows; 
//			debug.innerHTML += " : "; 
//			debug.innerHTML = sheetObjects[0].PageNo; 
								
			if(arrSXml.length == 1){
				excelXml ="";
				return;
			}
			excelXml = arrSXml[1];
     
			//orderbyCnt += eval(ComGetEtcData(arrSXml[0], "orderby_cnt"));
			realTotalCnt = eval(ComGetEtcData(arrSXml[0], "real_total_cnt"));		
			totalPage = Math.ceil(realTotalCnt / rowsPerPage);
			
			if(ComGetEtcData(arrSXml[0], "total_bkg") == undefined) return;
			 					  
			formObj.last_orderby.value = ComGetEtcData(arrSXml[0], "last_orderby");
						 
			total_bkg.value = ComGetEtcData(arrSXml[0], "total_bkg");							  
			total_bl .value = ComGetEtcData(arrSXml[0], "total_bl");							  
			total_teu.value = ComGetEtcData(arrSXml[0], "total_teu");							  
			total_feu.value = ComGetEtcData(arrSXml[0], "total_feu");	
			
			total_all_teu.value = new Number(eval(total_teu.value) + eval(total_feu.value)*2).toFixed(2);							  
									  
			total_wgt.value = ComGetEtcData(arrSXml[0], "total_wgt");								  
			total_mea.value = ComGetEtcData(arrSXml[0], "total_mea");
			break; 
						
		case SEARCH04:      //조회
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
			formObj.f_cmd.value = SEARCH04;
			if(orderby==""){
				formObj.orderby.value = defaultOrderby;
				formObj.orderby_title_sql.value = defaultOrderbyTitleSql;
				
			}else{
				formObj.orderby.value = orderby;
				formObj.orderby_title_sql.value = orderbyTitleSql;
			}
			
			sheetObj.RemoveAll();
			
			var sXml =  sheetObj.GetSearchXml("ESM_BKG_0103_05GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				
			sheetObj.Redraw = false;    
			sheetObj.WaitImageVisible = true;
			sheetObj.LoadSearchXml(sXml); 
			sheetObj.Redraw = true;
			sheetObj.WaitImageVisible = false;
			break; 
				
		case SEARCH01:      //조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj));
			arrMultiCombo = sXml.split("|$$|");	
			initAll(formObj);
			initReportType();
		    setConditionAndInitSheet(tempform.report_type.Code);
		  
			break;
		case SEARCH02:      //Staff List 조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH02;
			var p_ofc_cd ="";
			var p_ofc_gubun ="";
			if(subGubun =="b_ofc_cd"){
				p_ofc_cd =formObj.b_ofc_cd.value;
				p_ofc_gubun ="BO";
			}else if(subGubun =="l_ofc_cd"){
				p_ofc_cd =formObj.l_ofc_cd.value;
				p_ofc_gubun ="LO";
			}
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
		
			if(subGubun =="b_ofc_cd"){
				ComXml2ComboItem(sXml, formObj.b_staff_id, "usr_id", "usr_id");
			}else if(subGubun =="l_ofc_cd"){
				l_rep_idMultiComboDataAdded = false;
				ComXml2ComboItem(sXml, formObj.l_rep_id, "srep_cd", "srep_cd");
			}
			break;
			
		case SEARCH06:      //Sales Team 조회
			formObj.f_cmd.value = SEARCH06;
			var p_ofc_cd = formObj.l_ofc_cd.value;			
			if(p_ofc_cd != 'SELSC') p_ofc_cd = '';
			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd);
		
			l_team_cdMultiComboDataAdded = false;
			ComXml2ComboItem(sXml, formObj.l_team_cd, "ofc_team_cd", "ofc_team_cd");
			
			if(p_ofc_cd=='SELSC'){
				formObj.l_team_cd.Enable = true;
			}else{
				formObj.l_team_cd.Enable = false;
			}
					
			break;
			
		case SEARCH07:      //Office 에 따른 LOC_CD 조회
			formObj.f_cmd.value = SEARCH07;
			var p_ofc_cd =formObj.b_ofc_cd.value;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd);
			var arrXml = sXml.split("|$$|"); 	
			sheetObjects[10].LoadSearchXml(arrXml[0], false);
			
			for( var i=0;i<sheetObjects[10].RowCount;i++){
				if ( i == 0 ){
					locCdList = sheetObjects[10].CellValue(i+1, "loc_cd");
				} else {
					locCdList = locCdList + ',' + sheetObjects[10].CellValue(i+1, "loc_cd");
				}
			}
			break;
	
		case IBSEARCHAPPEND:  // 페이징 조회
			//alert(PageNo);
			/*
			formObj.f_cmd.value = SEARCH;
            formObj.curr_page.value = PageNo;
            formObj.f_cmd.value = SEARCH;
			//alert(FormQueryString(formObj));
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0103GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			var arrSXml = sXml.split("|$$|");
			//alert(arrSXml[0]);
			if(form.p_grid_type.value =="G"){
				sheetObjects[0].LoadSearchXml(arrSXml[0],true); 
			}else{
				sheetObjects[0].LoadSearchXml(arrSXml[1],true); 
			}
			
			//orderbyCnt += eval(ComGetEtcData(arrSXml[0], "orderby_cnt"));

			formObj.last_orderby.value = ComGetEtcData(arrSXml[0], "last_orderby");							  
//			debug.innerHTML += "<br>"; 
//			debug.innerHTML += sheetObjects[0].TotalRows; 
//			debug.innerHTML += " : "; 
//								
			sheetObjects[1].LoadSearchXml(ComReplaceStr(arrSXml[1], "sheet1", "sheet2"),true);
*/
			break;  
		case IBINSERT:      // 입력					
			sheetObj.DataInsert(-1);
			break;
			
		case IBDOWNEXCEL:   // 엑셀다운로드
	 	    if (sheetObj.RowCount < 1) {
				ComShowCodeMessage("COM12189");
				return;
			}
//			var op_sheet = sheetObjectsMap["search_options"];
//			op_sheet.removeAll();
//			var row = op_sheet.DataInsert(-1);
//          op_sheet.CellValue(row, "search_options") = getSearchOptions();
//			op_sheet.SpeedDown2Excel(-1);
							
			if(form.p_report_type.value=="P"){
				sheetObj.SpeedDown2Excel(-1);
			}else{
				sheetObj.SpeedDown2Excel(1);
			}
			break;
			
		case RDPRINT:   
			if (sheetObj.RowCount < 1) {
				ComShowCodeMessage("BKG00495");
				return;
			}
 		
			var url = "ESM_BKG_0775.do?"+FormQueryString(formObj);	    	
			var winName = "ESM_BKG_0775";
			
			repWin = openWinCenter("about:blank",winName,1024,800);
		    						    
 			formObj.f_cmd.value = SEARCH02;
			var frm2 = document.form2;
			
			frm2.rfn.value = "/ESM_BKG_0775_1.do?"+FormQueryString(formObj);
			if(subGubun == "TOTAL"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_05.mrd";
			} else if(form.p_report_type.value == "ak"){ 
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_01.mrd";
			} else if(form.p_report_type.value == "bb"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_02.mrd";
			} else if(form.p_report_type.value == "dg"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_03.mrd";
			} else if(form.p_report_type.value == "rf"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_04.mrd";
			} else if(form.p_report_type.value == "cntr"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_07.mrd";				
			} else {
				if ( subGubun == "PAGE_BREAK" ){
					frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_06.mrd";
				}
				else{
					frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775.mrd";
				}
			}

			frm2.rv.value = "options["+getSearchOptions()+"]";		    
			frm2.rd_title.value = "Booking Status Report( General )";
		    frm2.print_type.value = "PREVIEW";
		  
			frm2.action = url;
			frm2.target = winName;
			frm2.submit();
			//frm2.target = "";
			repWin.focus();
			
			break;		
			
		case PRINT:   
			if (sheetObj.RowCount < 1) {
				ComShowCodeMessage("BKG00495");
				return;
			}
 		
			var url = "ESM_BKG_0775.do?"+FormQueryString(formObj);	    	
			var winName = "ESM_BKG_0775";
			
 			formObj.f_cmd.value = SEARCH02;
			var frm2 = document.form2;
			
			frm2.rfn.value = "/ESM_BKG_0775_1.do?"+FormQueryString(formObj);	
			
			if(form.p_report_type.value == "ak"){ 
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_01.mrd";
			} else if(form.p_report_type.value == "bb"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_02.mrd";
			} else if(form.p_report_type.value == "dg"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_03.mrd";
			} else if(form.p_report_type.value == "rf"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_04.mrd";
			} else if(form.p_report_type.value == "cntr"){
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775_07.mrd";
			} else {
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0775.mrd";
			}    
			frm2.rv.value = "options["+getSearchOptions()+"]";		    
			frm2.rd_title.value = "Booking Status Report( General )";
			
			frm2.print_type.value = "PRINT";
			frm2.action = url;
			frm2.target = "hidden_frame";
			frm2.submit();
			hidden_frame.focus();
			break;							
	}
}
     
 /*
  *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
  * 초기값은 쉬트 헤더 개수
  */ 
var pagedMaxCnt=2; 
/**
 * 조회후  이벤트 처리 >>> 폰트 칼라변경
 */ 
      
/**
 * 조회후  이벤트 처리 >>> 폰트 칼라변경
 */ 
 function sheet1_OnSearchEnd(sheetObj, ErrMsg) { 	
 	sheetObj.ColFontUnderline(prefix+"bkg_no") = true;
	sheetObj.ColFontUnderline(prefix+"bl_no") = true;
	sheetObj.ColFontColor(prefix+"bkg_no") = sheetObj.RgbColor(0,0,255);
	sheetObj.ColFontColor(prefix+"bl_no") = sheetObj.RgbColor(0,0,255);

	for(var i = 2 ; i <= sheetObj.LastRow ; i++){
		if(sheetObj.Cellvalue(i, prefix + "rate_chk_sts") == "Y"){
			sheetObj.CellFontColor(i, prefix + "rate_chk_sts") = sheetObj.RgbColor(255, 0, 0);
		}
	}
 	/*
    with (sheetObj) {
		var redColor = RgbColor(255, 0, 0);
		var blueColor = RgbColor(0, 0, 255);
  		for (var i = pagedMaxCnt; i <= LastRow ; i++) {
      		sheetObj.CellFontColor(i, prefix+"bkg_no") = blueColor;
      		sheetObj.CellFontUnderline(i, prefix+"bkg_no") = true;
      		sheetObj.CellFontColor(i, prefix+"bl_no") = blueColor;
      		sheetObj.CellFontUnderline(i, prefix+"bl_no") = true;

  		}
	}
	*/
    pagedMaxCnt = sheetObj.LastRow;
}
          
function setCelColor(flag, obj,idx,celName,color){
 	if(flag =="N")
 		obj.CellFontColor(idx,celName) = color;
}

/*
 *  Search Option or Item Option Modify
 * */
function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    //if(sheetObj.CellValue(rowIdx, prefix+"ibflag") =="D" ) return;
	if( colIdx == sheetObj.SaveNameCol(prefix + 	"remark") && ComTrim(sheetObj.CellValue(rowIdx, prefix+"remark")) =="Y"){
		alert(sheetObj.CellValue(rowIdx, prefix+"remark_detail"));
	} 
	else if ( colIdx == sheetObj.SaveNameCol(prefix + 	"inter_remark") && ComTrim(sheetObj.CellValue(rowIdx, prefix+"inter_remark")) =="Y")
	{
		alert(sheetObj.CellValue(rowIdx, prefix+"inter_remark_detail"));
	} 
	else if ( colIdx == sheetObj.SaveNameCol(prefix + 	"chg_inter_remark") && ComTrim(sheetObj.CellValue(rowIdx, prefix+"chg_inter_remark")) =="Y")
	{
		alert(sheetObj.CellValue(rowIdx, prefix+"chg_inter_remark_detail"));
	} 
	else if ( colIdx == sheetObj.SaveNameCol(prefix + 	"chg_xter_remark") && ComTrim(sheetObj.CellValue(rowIdx, prefix+"chg_xter_remark")) =="Y")
	{
		alert(sheetObj.CellValue(rowIdx, prefix+"chg_xter_remark_detail"));
	}
	else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
		if(sheetObj.CellValue(rowIdx, prefix+"bkg_bl_flg") == "BL"){ //다중라인 처리
		    if(ComTrim(sheetObj.CellValue(rowIdx, prefix+"bl_no")) == "") return;
		    
		  	var param= "?bl_no="+sheetObj.CellValue(rowIdx, prefix+"bl_no");
//     		모달로 변경 2010.04.10
			ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=yes,resizable=yes");	
     	}else{
     		if(ComTrim(sheetObj.CellValue(rowIdx, prefix+"bkg_no")) == "") return;
//			var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
//			ComOpenWindowCenter2("/hanjin/ESM_BKG_0079_Q.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
//     		모달로 변경 2010.04.10
     		comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, prefix+"bkg_no"));
     	}
						
    }else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
		var param= "?bl_no="+sheetObj.CellValue(rowIdx, prefix+"bl_no");
//		ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
//		모달로 변경 2010.04.10
		ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,true,"scrollbars=yes,resizable=yes");
    }
}				
	
/**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
function validateForm(sheetObj,formObj,sAction){
	formObj.vvd_cd.value = formObj.vvd_cd.value.replace("\t","");
	formObj.pol_cd.value = formObj.pol_cd.value.replace("\t","");
	formObj.pod_cd.value = formObj.pod_cd.value.replace("\t","");
	formObj.por_cd.value = formObj.por_cd.value.replace("\t","");
	formObj.del_cd.value = formObj.del_cd.value.replace("\t","");
	formObj.b_ofc_cd.value = formObj.b_ofc_cd.value.replace("\t","");
	formObj.l_ofc_cd.value = formObj.l_ofc_cd.value.replace("\t","");
	formObj.c_ofc_cd.value = formObj.c_ofc_cd.value.replace("\t","");
	formObj.c_rep_id.value = formObj.c_rep_id.value.replace("\t","");
		
	switch(sAction) {
		case IBSEARCH:
    		if ((!ComIsNull(ComTrim(formObj.cust_seq)) || !ComIsNull(ComTrim(formObj.cust_cnt_cd)))) {
    			if (ComIsNull(ComTrim(formObj.cust_seq))){
    				ComShowCodeMessage("BKG00340"); // Customer code is invalid.
    				ComOpenWait(false);
    				tabObjects[0].SelectedIndex = 0;
    				formObj.cust_seq.focus();
	    	 		return false;
    			}
    			if (ComIsNull(ComTrim(formObj.cust_cnt_cd))){
    				ComShowCodeMessage("BKG00340"); // Customer code is invalid.
    				ComOpenWait(false);
    				tabObjects[0].SelectedIndex = 0;
	    	 		formObj.cust_cnt_cd.focus();
	    	 		return false;
    			}
    			if (form.cust_tp_cd_s.checked == false && form.cust_tp_cd_c.checked == false && form.cust_tp_cd_n.checked == false && form.cust_tp_cd_f.checked == false && form.cust_tp_cd_a.checked == false && form.cust_tp_cd_g.checked == false ) {
	    			ComShowCodeMessage("BKG95062"); // invalid customer code
	    			ComOpenWait(false);
	    			tabObjects[0].SelectedIndex = 0;
	    	 		formObj.cust_tp_cd_s.focus();
	    	 		return false;
    			}
			} 

    		var cust_seq = formObj.cust_seq.value;
    		if(!ComIsNumber(cust_seq) && cust_seq.length != 0 ){
    	 		ComShowCodeMessage("BKG00458"); // invalid customer code
    	 		tabObjects[0].SelectedIndex = 0;
    	 		formObj.cust_seq.focus();
    	 		return false;
    	 	}    		
    		
    		if (!dateTypeValidation()){
    			return false;
    		}
    		
			if ( ComIsNull(formObj.web_upd_sts) &&  ( !ComIsNull(formObj.web_sts_cd_a.checked) || !ComIsNull(formObj.web_sts_cd_m.checked) ) ) {
				ComShowCodeMessage("BKG95102"); // Please choose Web Upload Status first
				return false;
			} 
			    		
			if (!ComIsNull(ComTrim(formObj.vvd_cd))) {
				return true;
			} else if (ComIsNull(ComTrim(formObj.vvd_cd)) && (ComIsNull(ComTrim(formObj.board_from_dt)) ||  ComIsNull(ComTrim(formObj.board_to_dt))) 
    												&& (ComIsNull(ComTrim(formObj.bkg_from_dt)) ||  ComIsNull(ComTrim(formObj.bkg_to_dt)))  
    												&& (ComIsNull(ComTrim(formObj.eta_from_dt)) ||  ComIsNull(ComTrim(formObj.eta_to_dt)))
    	                     ) {
				ComShowCodeMessage('BKG00626','VVD or On Board Date or Booking Date');
				ComOpenWait(false);
				tabObjects[0].SelectedIndex = 0;
				formObj.vvd_cd.focus();
				return false;    					
    		//날짜조건이 들어온 경우에는 pol,pod 중 하나가 필수 Trunk체크 추가(2010.4.13)
    		} else if (((!ComIsNull(ComTrim(formObj.board_from_dt)) && !ComIsNull(ComTrim(formObj.board_to_dt))) || 
        			    (!ComIsNull(ComTrim(formObj.bkg_from_dt)) && !ComIsNull(ComTrim(formObj.bkg_to_dt))) || 
        			    (!ComIsNull(ComTrim(formObj.eta_from_dt)) && !ComIsNull(ComTrim(formObj.eta_to_dt)))
    			    ) &&
                    ComIsNull(ComTrim(formObj.pol_cd)) && ComIsNull(ComTrim(formObj.pod_cd )) && formObj.trunk_flag.checked == false) {
    			ComShowCodeMessage('BKG95001',' specify additional mandatory item: with POL (or POD) at least 2 letter country or \n define Trunk vessel only with tick on Trunk-V.\n Otherwise,all data is regarded as Trunk VVD base booking.','');
    			tabObjects[0].SelectedIndex = 0;
    			formObj.trunk_flag.checked = true;
    			setFeederVessel();
				formObj.trunk_flag.focus();
    			return false;
		  	}
    		// special 이 하나라도 check 되어 있으면 validation skip (2010.03.08) 
    		else if (formObj.sp_cargo_dg.checked == true || formObj.sp_cargo_rf.checked == true ||
    				 formObj.sp_cargo_ak.checked == true || formObj.sp_cargo_bb.checked == true ||
    				 formObj.sp_cargo_hg.checked == true || formObj.sp_cargo_soc.checked == true ||
    				 formObj.sp_cargo_eq.checked == true || formObj.sp_cargo_rd.checked == true ||
    				 formObj.sp_cargo_pc.checked == true || formObj.non_dg_chem_flg.checked == true ||
    				 formObj.sp_cargo_fg.checked == true || formObj.sp_cargo_hd.checked == true ||
    				 formObj.sp_cargo_fu.checked == true || formObj.sp_cargo_li.checked == true ||    				 
    				 formObj.sp_cargo_rb.checked == true) {
    					return true;
    					
    		//위조건들때문에 아래는 조건의 의미 없음 2010.4.13
//	    	} else if (ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd) && ComIsNull(formObj.por_cd) && ComIsNull(formObj.del_cd)  
//	    				 && ComIsNull(formObj.b_ofc_cd) && ComIsNull(formObj.l_ofc_cd)
//	    		         && ComIsNull(formObj.c_ofc_cd) && ComIsNull(formObj.c_rep_id) ){
//	    		ComShowCodeMessage('BKG40015','POL or POD or POR or DEL or BKG Office or L/Office or C/Office or C/Rep');
//				formObj.pol_cd.focus();
//				return false;
    		/* 신은영 차장님 요청 2010.04.14 */
    		// formObj.ctr_rfa_cd 라디오버튼으로 뺌.			
    		}else if (ComIsNull(ComTrim(formObj.pol_cd)) && ComIsNull(ComTrim(formObj.pod_cd)) && ComIsNull(ComTrim(formObj.por_cd)) && ComIsNull(ComTrim(formObj.del_cd))
    					&& ComIsNull(ComTrim(formObj.b_ofc_cd)) && ComIsNull(ComTrim(formObj.l_ofc_cd)) && ComIsNull(ComTrim(formObj.c_ofc_cd))
    					&& ComIsNull(ComTrim(formObj.c_rep_id)) && ComIsNull(ComTrim(formObj.l_rep_id.Text)) && ComIsNull(ComTrim(formObj.b_staff_id))
    					&& ComIsNull(ComTrim(formObj.ctr_rfa_no)) && ( formObj.rct_rhq_cd.Index < 1 ) 
    					){
    			ComShowCodeMessage('BKG40015','POL or POD or POR or DEL or BKG Staff or BKG Office or L/Office or C/Office or L/Rep or C/Rep or S/C or RFA or RHQ');
    			return false;
    		}
			
			
			/*   POL 이나 BKG OFC 가 US/CA Country 에 속하는 경우 1달 조회가능 (2014.06.18 조인영)
			 *   중국지역은 21일 제한 로직은 그대로, Contract 입력후 조회시만 30일 가능 (2014.07.10 신선희 김미선부장님요청)
			 */
			//VVD 없을 경우
			if ( ComIsNull(formObj.vvd_cd) ) {

				
				//RHQ 7일조회 [김보영과장요청]
				//1st VVD ETD
				if( formObj.rct_rhq_cd.Index > 0 && ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) +1 > 7){
					ComShowCodeMessage('COM132001','On Board Date','7Days');
					ComOpenWait(false);
					tabObjects[0].SelectedIndex = 0;
					formObj.board_to_dt.focus();
					return false;
				}	
				//Booking Date
				if( formObj.rct_rhq_cd.Index > 0 && ComGetDaysBetween(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value) +1 > 7){
					ComShowCodeMessage('COM132001','On Booking Date','7Days');
					ComOpenWait(false);
					tabObjects[0].SelectedIndex = 0;
					formObj.bkg_to_dt.focus();
					return false;
				}					
				//Last VVD ETA
				if( formObj.rct_rhq_cd.Index > 0 && ComGetDaysBetween(formObj.eta_from_dt.value,formObj.eta_to_dt.value) +1 > 7){
					ComShowCodeMessage('COM132001','ETA Date','7Days');
					ComOpenWait(false);
					tabObjects[0].SelectedIndex = 0;
					formObj.eta_to_dt.focus();
					return false;
				}				
				
				//중국지역				
				if ( (formObj.pol_cd.value.substring(0,2) == "CN" || (!ComIsNull(ComTrim(formObj.b_ofc_cd)) && (locCdList.indexOf("CN") != -1 )))) {
    			
					//1st VVD ETD
					if( ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) +1 > 21){
						ComShowCodeMessage('COM132001','On Board Date','21Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.board_to_dt.focus();
						return false;
		    		}else if( !ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) +1 > 31){
						ComShowCodeMessage('COM132001','On Board Date','31Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.board_to_dt.focus();
						return false;
					}
					
					//Booking Date
					if( ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value) +1 > 21){
						ComShowCodeMessage('COM132001','On Booking Date','21Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.bkg_to_dt.focus();
						return false;
		    		}else if( !ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value) +1 > 31){
						ComShowCodeMessage('COM132001','On Booking Date','31Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.bkg_to_dt.focus();
						return false;
					}
					
					//Last VVD ETA
					if( ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.eta_from_dt.value,formObj.eta_to_dt.value) +1 > 21){
						ComShowCodeMessage('COM132001','ETA Date','21Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.eta_to_dt.focus();
						return false;
		    		}else if( !ComIsNull(formObj.ctr_rfa_no) && ComGetDaysBetween(formObj.eta_from_dt.value,formObj.eta_to_dt.value) +1 > 31){
						ComShowCodeMessage('COM132001','ETA Date','31Days');
						ComOpenWait(false);
						tabObjects[0].SelectedIndex = 0;
						formObj.eta_to_dt.focus();
						return false;
					}

				//중국외 기타지역
				} else {
				
					/*   POL 이나 BKG OFC 가 US/CA Country 에 속하는 경우 1달 조회가능 (2014.06.18 조인영)
					 *   중국지역제외한 나머지는 30로 선택 할 수 있도록 수정(2014.07.10 신선희 김미선부장님요청)
					 */		
					//1st VVD ETD
					if( ComGetDaysBetween(formObj.board_from_dt.value,formObj.board_to_dt.value) +1 > 31 ){
		    			ComShowCodeMessage('COM132001','On Board Date','31Days');
		    			ComOpenWait(false);
		    			tabObjects[0].SelectedIndex = 0;
		    			formObj.board_to_dt.focus();
		    			return false;
					}
					//Booking Date
		    		if( ComGetDaysBetween(formObj.bkg_from_dt.value,formObj.bkg_to_dt.value) +1 > 31){
		    			ComShowCodeMessage('COM132001','Booking Date','31Days');
		    			ComOpenWait(false);
		    			tabObjects[0].SelectedIndex = 0;
		    			formObj.bkg_to_dt.focus();
		    			return false;
		    		}
		    		
					//Last VVD ETA
		    		if( ComGetDaysBetween(formObj.eta_from_dt.value,formObj.eta_to_dt.value) +1 > 31){
		    			ComShowCodeMessage('COM132001','ETA Date','31Days');
		    			ComOpenWait(false);
		    			tabObjects[0].SelectedIndex = 0;
		    			formObj.eta_to_dt.focus();
		    			return false;
		    		}
		    		
				} //중국,중국외 기타지역 End
					
			}//VVD 없을 경우
			
			pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
  			break;
		case IBSAVE:
  			break;
	}
    return true;
}

function dateTypeValidation(){
    var formObj = document.form;
    
	if(!ComIsNull(formObj.board_from_dt) && !ComIsDate(formObj.board_from_dt,"ymd")){
		formObj.board_from_dt.focus();
		return false;
	}
	if(!ComIsNull(formObj.board_to_dt) && !ComIsDate(formObj.board_to_dt,"ymd")){
		formObj.board_to_dt.focus();
		return false;
	}
	if(!ComIsNull(formObj.bkg_from_dt) && !ComIsDate(formObj.bkg_from_dt,"ymd")){
		formObj.bkg_from_dt.focus();
		return false;
	}
	if(!ComIsNull(formObj.bkg_to_dt) && !ComIsDate(formObj.bkg_to_dt,"ymd")){
		formObj.bkg_to_dt.focus();
		return false;
	}
	if(!ComIsNull(formObj.eta_from_dt) && !ComIsDate(formObj.eta_from_dt,"ymd")){
		formObj.eta_from_dt.focus();
		return false;
	}
	if(!ComIsNull(formObj.eta_to_dt) && !ComIsDate(formObj.eta_to_dt,"ymd")){
		formObj.eta_to_dt.focus();
		return false;
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
function report_type_OnChange(comboObj) {
	initAll(document.form);
	setConditionAndInitSheet(comboObj.Code); 
	setFeederVessel();
	if(tempform.report_type.Text =="General(Awkward)" || tempform.report_type.Text =="General(Break Bulk)"
       || tempform.report_type.Text =="General(Dangerous)" || tempform.report_type.Text =="General(Reefer)"
       || tempform.report_type.Text =="Genearl(Reefer) by CNTR"    	   
       ){
		 setSpecialCargoOptionDisalbed(true);
	}else{
		 setSpecialCargoOptionDisalbed(false);
	}
	
	if(tempform.report_type.Text =="General(Reefer)"){
		form.sp_cargo_ge.disabled = false;
	}else{
		form.sp_cargo_ge.disabled = true;
	}
     
    // Report Type General 이 아니면 Print View, Print 버튼 비활성화 
    var temp_report_type = tempform.report_type.Text;
    if( form.p_grid_type.value == 'G'){
      	if(tempform.report_type.Text =="General(Awkward)" || tempform.report_type.Text =="General(Break Bulk)"
           || tempform.report_type.Text =="General(Dangerous)" || tempform.report_type.Text =="General(Reefer)"
           || tempform.report_type.Text =="Genearl(Reefer) by CNTR"	   
      	){
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
 *  스페셜카고 선택시 사용치 않는 옵션 disabled처리
 */
function setSpecialCargoOptionDisalbed(flg) {
	form.aes_y.disabled =flg;
	form.aes_n.disabled =flg;
	form.caed_y.disabled =flg;
	form.caed_n.disabled =flg;
}  
   	 
function b_staff_id_OnChange(comboObj) {
	//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
}

function l_rep_id_OnChange(comboObj) {
	combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
}

function l_team_cd_OnChange(comboObj) {
	combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
} 

function combo_Change(comboObj, multiComboDataAddedFlag) {
	var formObject = document.form;  

	// 사용자 입력값을 uppercase로 변경  
 	var comboText =  comboObj.Text.toUpperCase();
 	 
 	// 이전에 등록되었으면 삭제 
 	if (multiComboDataAddedFlag) { 
		comboObj.DeleteItem(0); 
		multiComboDataAddedFlag = false; 
 	} 
 	
 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
 	if (comboObj.FindIndex(comboText, 0) != -1) { 
 		return; 
 	} 

 	comboObj.InsertItem(0, comboText, comboText); 
	multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수) 
	comboObj.Text2 = comboText;  // 입력값이 선택되게 한다.
}
	 
/*############################# combo onchage end ########################*/		

/*
 * 모든 조건 값들을 초기화 한다.
 * */
function initAll(formObject){
	form.reset();
    sheetObjects[0].RemoveAll();
    b_ofc_cd_cnt.innerHTML = 0;
	/**
	 * 페이징 변수 초기화 
	 */
	currPage=1;
	/*
	* 현재 최종 order by 칼럼의 마지막 결과 값
	* 페이징 처리시 이전과 같으면 order by 타이틀을 생성하지 않는다.
	*/
	form.last_orderby.value="";
	/**
	 * 페이징 변수 초기화  끝
	 */		
	ComXml2ComboItem(roYComboStr, formObject.ro_y, "val", "desc");		 
	ComXml2ComboItem(nullMultiComboStr, formObject.b_staff_id, "val", "val");
	ComXml2ComboItem(nullMultiComboStr, formObject.l_rep_id,   "val", "val");
	ComXml2ComboItem(nullMultiComboStr, formObject.l_team_cd,   "val", "val");
	ComXml2ComboItem(arrMultiCombo[0], formObject.dir_cd,      "val", "val");
	ComXml2ComboItem(arrMultiCombo[1], formObject.r_term,      "val", "val");
	ComXml2ComboItem(arrMultiCombo[2], formObject.d_term,      "val", "val");
	ComXml2ComboItem(arrMultiCombo[3], formObject.deli_mode,   "val", "name");
	ComXml2ComboItem(arrMultiCombo[4], formObject.bkg_kind,    "desc", "desc");
	ComXml2ComboItem(arrMultiCombo[5], formObject.eq_type,     "cntr_tpsz_cd", "cntr_tpsz_cd");
	ComXml2ComboItem(arrMultiCombo[6], formObject.s_mode_ori,  "val", "val");
	ComXml2ComboItem(arrMultiCombo[6], formObject.s_mode_dest, "val", "val");
	ComXml2ComboItem(arrMultiCombo[7], formObject.s_route_ori, "val", "val");
	ComXml2ComboItem(arrMultiCombo[7], formObject.s_route_dest,"val", "val");
	ComXml2ComboItem(arrMultiCombo[8], formObject.cust_tp_cd,  "val", "val");
	ComXml2ComboItem(arrMultiCombo[10], formObject.rct_rhq_cd, "cd", "cd");
	ComXml2ComboItem(arrMultiCombo[11], formObject.ctrt_cng_tp_cd,  "val", "name");
	ComXml2ComboItem(arrMultiCombo[12], formObject.rtro_knd_cd,  "val", "name");
	ComBkgXml2ComboItem(arrMultiCombo[13], formObject.blck_stwg_cd, "val", "desc");
	formObject.rct_rhq_cd.InsertItem(0,"",""); 
	formObject.ctrt_cng_tp_cd.InsertItem(0,"",""); 
}
	
function initReportType(){
	ComXml2ComboItem(arrMultiCombo[9], tempform.report_type, "sql_ctnt_col_nm", "rpt_nm");
	var arr = ComBkgXml2Array(arrMultiCombo[9], "rpt_nm");
	var chkRptTypeFlg = false;
	if(arr == undefined) return;
	for(var index=0; index<arr.length; index++) {
		if(arr[index] == paramReportName)
			chkRptTypeFlg  = true;
	}
 	tempform.report_type.Text2 = arr[0];
}


var selectColList="";//Report 타입별 저장된 그리드 칼럼 목록

/**
 * condition setting and init Sheet
 */ 
function setConditionAndInitSheet(sqlCtnt){
  	var arrSqlCtntColnm = sqlCtnt.URLDecode().split("@@");
  	//alert(arrSqlCtntColnm.length);
  	//return;
  	var arrSqlCtnt = arrSqlCtntColnm[0].URLDecode().split("|");
   	var formNameValue ; 
  	var field;
  	try{
	   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue = arrSqlCtnt[i].split("=");
   			if(formNameValue[1] =="") continue;
   			if(arrFormElementMap[formNameValue[0]] == "check"){
					eval("form."+formNameValue[0]).checked = true;
					
			}else if(arrFormElementMap[formNameValue[0]] == "radio"){
				field = eval("form."+formNameValue[0]);
					for(var j = 0; j < field.length; j++) {
						if(field[j].value == formNameValue[1]){
							field[j].checked = true;
							break;
						}
							
					}
					
			}else if(arrFormElementMap[formNameValue[0]] == "select"){
				field = eval("form."+formNameValue[0]);
					for(var j = 0; j < field.length; j++) {
						if(field[j].value == formNameValue[1]){
							field[j].selected = true;
							break;
						}
					}
					
			}else if(arrFormElementMap[formNameValue[0]] == "combo"){
				eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
			}else if(arrFormElementMap[formNameValue[0]] == "multi"){
				eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
			}else{
				field = eval("form."+formNameValue[0]);
				field.value=formNameValue[1];
				if(field.name == "b_ofc_cd_1"){
			  		doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','b_ofc_cd');
				}else if(field.name == "l_ofc_cd"){
					doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','l_ofc_cd');
					doActionIBSheet(sheetObjects[1],document.form,SEARCH06);
				}
   			}
	   	}//end for
	   	
  	}catch(e){}
  	/*
  	 * Report Type에 따라 Grid를 다시 그린다.
  	 * */

  	if(arrSqlCtntColnm.length > 1){
	  	selectColList = arrSqlCtntColnm[1];
	  	initSheetDynamic(sheetObjects[1],selectColList);
  	}else{
	  	selectColList = "";
	  	initSheetDynamic(sheetObjects[1],selectColList); 
  	}  	
}
/*
 * Report Template 수정 후 설정 재조회 
 * */
function setParent(){
  	sheetObjects[1].RemoveAll();
  	sheetObjects[1].Reset();
  	sheetObjects[2].RemoveAll();
  	doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
}    

/*
 * Customer 조회 결과를 세팅하는 콜백 메소드
 * */
function setCustomer(val){
	var c_cd = val[0][3];
	var c_name = val[0][4];
	form.cust_cnt_cd.value=c_cd.substring(0,2);
	form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
	form.cust_nm.value=c_name;
} 
	
/**
 * Commodity Code를 입력하기 위해 Code를 검색  .<br>
 * @param {arry} aryPopupData
 */
function setCallBack0653(aryPopupData) {
	var formObject = document.form;
	formObject.cmdt_cd.value = aryPopupData[0][3];
	//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
	formObject.cmdt_nm.value = aryPopupData[0][4];
}		

/**
 * 조건 중 값이 없는 것은 제거한다. 
 */ 
function getValidCondition(sql){
  	// alert(sqlCtnt);
  	var arrSqlCtnt = sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql = ""; 
   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
		formNameValue = arrSqlCtnt[i].split("=");
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
    var cnt = 0;

    switch(sheetObj.id) {

    	case "sheet1":
            initSheetDynamic(sheetObj,"");

        case "summary":
        	with (sheetObj) {
      		    // 높이 설정
	            style.height = 442;
	           
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
	            //전체Merge 종류 [선택, Default msNone]
	            //MergeSheet = msPrevColumnMerge;
	            //MergeSheet = msHeaderOnly +	msPrevColumnMerge;
	            MergeSheet = msAll;
	           
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 100, rowsPerPage);
			    var HeadTitle1 = "TP/SZ|Full Container|Full Container|Empty Reposition container|Empty Reposition container|Revenue Empty Container|Revenue Empty Container|Total Container|Total Container|No of BKG";
	            var HeadTitle2 = "TP/SZ|BKG Q'ty|TEU|BKG Q'ty|TEU|BKG Q'ty|TEU|BKG Q'ty|TEU|No of BKG";
	            var headCount = ComCountHeadTitle(HeadTitle1);
	          
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	          
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
	            InitHeadMode(false, false, true, true, false,false)
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	          
	            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,	prefix + "tp_sz",		false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "f_bkg_qty",   false,			"",      dfInteger,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "f_teu",    	false,			"",      dfInteger,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "p_bkg_qty",   false,			"",      dfInteger,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "p_teu",    	false,			"",      dfInteger,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "r_bkg_qty",   false,			"",      dfInteger,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "r_teu",    	false,			"",      dfInteger,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "t_bkg_qty",   false,			"",      dfInteger,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,	prefix + "t_teu",    	false,			"",      dfInteger,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	true,	prefix + "bkg_cnt",  	false,			"",      dfInteger,			0,		true,		true);
				
				CountPosition = 0;              	
          	}
            	
			break;
			
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "NO | Booking No | BST | BDR | No Rate Status | SR | Previous Contract | Changed Contract | B/L No | Shipper Code | Shipper | Shipper Address | Consignee Code | Consignee | Consignee Address | TEU | FEU | SVC SCOPE | Trunk VVD | Vessel Name| Lane | Container No| TP/SZ| POR | POL(Booking) | POD(Booking) | DEL | RCV Term| DEL Term| WGT(KGS) | MEA(CBM) | PKG | PKG Unit| REP CMDT| CMDT Code| CMDT| Customs Description |External Remrak| Internal Remark | Mark & Description | DG | RF | AK | BB | FG | PC | H/G | SOC | EQ Sub| R/D | Hot | STWG | BS | B.OFC | BKG STF | C.OFC | C.SREP | L.OFC | L.SREP | L.TEAM | S/C NO | RFA NO | TAA No| Freight Term| ITN | ITN Type| ITN No | CAED | CAED Type | CAED No| Forward Code | Forward Name | Notify Code | Notify Name | Notify Address | Also Notify Name | Export Name | Pre1.VVD | Pre2.VVD | Pre3.VVD | Pre4.VVD | Post.VVD | Post2.VVD | Post3.VVD | Post4.VVD | Pre1.POL | Pre2.POL | Pre3.POL | Pre4.POL | Pre1.POD | Pre2.POD | Pre3.POD | Pre4.POD | Post1.POD | Post2.POD | Post3.POD | Trunk POL | Trunk POD | CBF | Dest Service Mode | Orgin Service Mode | Dest Service Route | Origin Service Route | ORG EQ OFC| DEL EQ OFC| CRN No.| Booking Date | Booking Contact Phone Number | Booking Contact E-Mail | SI Contact Phone Number | SI Contact E-Mail | Remark | Inter Remark | Inter Remark Description | Charge Internal Remark | Charge Internal Remark Description | Charge External Remark | Charge External Remark Description | Rate Check Status | Charge Terms | ETB DT |  Sailing DT | Standby Status | OFT Change after PCT | REV.WEEK | Activity Teu | Activity Feu | Mty P/up CY | Mty P/up DT ";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter, true,  prefix2 + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix2 + 'bkg_no' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'bkg_sts_cd' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'bdr_flg' );				
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'non_rt_sts_cd' );				
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'si_flg' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true, prefix2 + 'pre_contrat' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true, prefix2 + 'now_contrat' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix2 + 'bl_no' );
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'shipper' );
				InitDataProperty(0, cnt++ , dtData,  120,daLeft,   true,  prefix2 + 'shpr_name' );
				InitDataProperty(0, cnt++ , dtData,  120,daLeft,   true,  prefix2 + 's_addr' );
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'consignee' );
				InitDataProperty(0, cnt++ , dtData,  120,daLeft,   true,  prefix2 + 'cnee_name' );
				InitDataProperty(0, cnt++ , dtData,  120,daLeft,   true,  prefix2 + 'c_addr' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'teu'  ,false, '', dfFloat,2);
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'feu' ,false, '', dfFloat,2);
				InitDataProperty(0, cnt++ , dtData,  120,daLeft,   true,  prefix2 + 'svc_scp_cd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'trunk_vvd' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix2 + 'vsl_eng_nm' ) ;
				InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix2 + 'slan_cd' );
				InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix2 + 'cntr_no' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'cntr_tpsz_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'por_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'actual_pol' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'actual_pod' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'del_cd' );
				InitDataProperty(0, cnt++ , dtData,  55, daLeft,   true,  prefix2 + 'rcv_term_cd' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'de_term_cd' );
				InitDataProperty(0, cnt++ , dtData,  95, daCenter, true,  prefix2 + 'bkg_actwgt_qty' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  95, daLeft,   true,  prefix2 + 'bkg_mea_qty' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix2 + 'pck_qty' , false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix2 + 'pck_tp_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'rep' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'commodity' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'cmdt_nm' );
				InitDataProperty(0, cnt++ , dtData,  180,daCenter, true,  prefix2 + 'cstms_desc' );
				InitDataProperty(0, cnt++ , dtData,  180,daCenter, true,  prefix2 + 'remark_detail' );
				InitDataProperty(0, cnt++ , dtData,  180,daCenter, true,  prefix2 + 'inter_rmk' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix2 + 'dg_cmdt_desc' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'dcgo_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'rc_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'awk_cgo_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'bb_cgo_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'fd_grd_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'pc' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'hngr_flg' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'soc_flg' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'eq_subst_flg' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'rd_cgo_flg' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'hot_de_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'stwg_cd' );//stwg_cd
				InitDataProperty(0, cnt++ , dtData,  40, daCenter, true,  prefix2 + 'blck_stwg_cd' );//block_stwg_cd
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'bkg_ofc_cd' );//b.ofc
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'doc_usr_id' ); // bkg stf
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'ctrt_ofc_cd' );//c.ofc
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'ctrt_srep_cd' );//c.srep
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'ob_sls_ofc_cd' );//l.ofc
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'ob_srep_cd' );//l.srep
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'ofc_team_cd' );//l.team			
				InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix2 + 'sc_no' );
				InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix2 + 'rfa_no' );
				InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix2 + 'taa_no' );
				InitDataProperty(0, cnt++ , dtData,  85, daCenter, true,  prefix2 + 'frt_term_cd' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'itn_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'itn_type' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'aes_no' );//itn no								
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'caed_flg' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'caed_type' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'caed_no' );			
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'ffdr' );								
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'ffdr_name' );								
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'ntfy' );													
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'ntfy_name' );
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'n_addr' );
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'anty_name' );								
				InitDataProperty(0, cnt++ , dtData,  120,daCenter, true,  prefix2 + 'expt_name' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'pre_1_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'pre_2_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'pre_3_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'pre_4_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'post_1_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'post_2_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'post_3_vvd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'post_4_vvd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_1_pol_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_2_pol_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_3_pol_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_4_pol_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_1_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_2_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_3_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'pre_4_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'post_1_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'post_2_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'post_3_pod_cd' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'trunk_pol' );
				InitDataProperty(0, cnt++ , dtData,  60, daCenter, true,  prefix2 + 'trunk_pod' );
				InitDataProperty(0, cnt++ , dtData,  30, daCenter, true,  prefix2 + 'bkg_clz_flg' );								
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'dest_trns_svc_mod_cd' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'org_trns_svc_mod_cd' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'del_nod_cd' );//Dest Service Route 
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'por_nod_cd' );//Origin Service Route
				//InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'por_nod_cd' );//Dest Service Route 
				//InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'fnl_dest_cd' );//Origin Service Route 
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'bkg_ctrl_ofc_cd' );//ORG EQ OFC
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'eq_ctrl_ofc_cd' );//DEL EQ OFC
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  prefix2 + 'shp_call_no ' );//CRN No.
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'bkg_cre_dt' );//Booking Date 
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'tel' );//Booking Contact Phone Number
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'cntc_pson_eml' );//Booking Contact Email
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'si_cntc_pson_phn_no' );//SI Contact Phone Number
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'si_cntc_pson_eml' );//SI Contact Email				
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'remark' );//remark
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'inter_remark' );//inter_remark
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'inter_remark_detail' );//inter_remark_detail
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'chg_inter_remark' );
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'chg_inter_remark_detail' );
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'chg_xter_remark' );
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'chg_xter_remark_detail' );
				InitDataProperty(0, cnt++ , dtData,  70, daCenter, true,  prefix2 + 'rate_chk_sts' );
				InitDataProperty(0, cnt++ , dtData,  55, daCenter, true,  prefix2 + 'chg_term_cd' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix2 + 'etb_dt' );				
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix2 + 'sail_dt' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix2 + 'aloc_sts_cd' );
				InitDataProperty(0, cnt++ , dtData,  100, daCenter, true,  prefix2 + 'rtro_knd_cd_nm' );
				InitDataProperty(0, cnt++ , dtData,  50, daCenter, true,  prefix2 + 'cost_wk' );	
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'activity_teu'  ,false, '', dfFloat,2);
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'activity_feu' ,false, '', dfFloat,2);	
				
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'mty_pkup_yd_cd' );
				InitDataProperty(0, cnt++ , dtData,  80, daCenter, true,  prefix2 + 'mty_pkup_dt' );
				CountPosition = 0;//[1/3] 페이지 위치 
 			}
 				
 			break;
		case "search_options":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "Search Options";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0,	cnt++ , dtData,	 150, daLeft,	true,	"search_options");
			 	CountPosition = 0;//[1/3] 페이지 위치 
 			}
 				
 			break;
 					
		case "ak":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "N0.|Bst|BKG No.|CNTR No.|T/S|WGT(KGS)|PKG|HT|RF|BKG OFC|BKG STF|RQ|CMDT|Void (FEU)|Bdr|B/L No|R|D|DG|BB|S/OFC|S/REP|AT|FWD|AFT|HGT|PORT|STAR|RMK|AK|NET|ANTY_NAME|BKG_CLZ_FLG|BKG_CRE_DT|MEAS_QTY|COMMODITY|Consignee Code|Consignee Name|CUST_TO_ORD_FLG|DEST_SVC_ROUTE|DEST_TRNS_SVC_MOD_CD|EQ_SUBST_FLG|EXPT_NAME|FFDR|FFDR_NAME|HNGR_FLG|NTFY|NTFY_NAME|ORG_SVC_ROUTE|ORG_TRNS_SVC_MOD_CD|PCK_QTY|PCK_TP_CD|POD|POL|POST1.POD|POST1.POL|POST1.VVD|POST2.POD|POST2.POL|POST2.VVD|POST3.POD|POST3.POL|POST3.VVD|POST4.POD|POST4.POL|POST4.VVD|Pre1.POD|Pre1.POL|Pre1.VVD|Pre2.POD|Pre2.POL|Pre2.VVD|Pre3.POD|Pre3.POL|Pre3.VVD|Pre4.POD|Pre4.POL|Pre4.VVD|RC_FLG|REMARK_DETAIL|REP Commodity|Shipper Code|Shipper Name|SI_FLG|SLAN_CD|SOC_FLG|SPLIT_FLG|TRUNK_VVD";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter,	true,	'ak_' + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bkg_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'cntr_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'cntr_tpsz_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'grs_wgt'  ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pkg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'hot_de_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'rd_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bkg_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bkg_stf' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'spcl_cgo_auth_knt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'akrep_cmdt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_void_slt_qty'  ,false, '', dfFloat);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bdr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bl_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'rcv_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'de_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'dcgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bb_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ob_sls_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ob_srep_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'spcl_cgo_apro_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_fwrd_len'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_bkwd_len'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_hgt'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_lf_len'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ovr_rt_len'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'remark' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'awk_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'net_wgt'  ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'anty_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bkg_clz_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'bkg_cre_dt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'meas_qty'  ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'commodity' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'consignee' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'consignee_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'cust_to_ord_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'dest_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'dest_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'eq_subst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'expt_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ffdr' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ffdr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'hngr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ntfy' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'ntfy_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'org_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'org_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pck_qty' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pck_tp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'post_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'pre_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'rc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'remark_detail' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'rep' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'shipper' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daLeft, true,  'ak_' + 'shpr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'si_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'slan_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'soc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'split_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'ak_' + 'trunk_vvd' ) ;						

				CountPosition = 0;//[1/3] 페이지 위치 
			}
		
			break;
		case "bb":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "No.|Bst| BKG No.| CNTR No.| T/S| WGT(KGS)| PKG| HT| RF| BKG OFC| BKG STF| RQ| Commodity| Length| Width| Height| Void (FEU)| Bdr| B/L No| R| D| DG| AK| S/OFC| S/REP| AT| RMK| BB| NET| ANTY_NAME| BKG_CLZ_FLG| BKG_CRE_DT| MEAS_QTY| COMMODITY| Consignee Code| Consignee Name| CUST_TO_ORD_FLG| DEST_SVC_ROUTE| DEST_TRNS_SVC_MOD_CD| EQ_SUBST_FLG| EXPT_NAME| FFDR| FFDR_NAME| HNGR_FLG| NTFY| NTFY_NAME| ORG_SVC_ROUTE| ORG_TRNS_SVC_MOD_CD| PCK_QTY| PCK_TP_CD| POD| POL| POST1.POD| POST1.POL| POST1.VVD| POST2.POD| POST2.POL| POST2.VVD| POST3.POD| POST3.POL| POST3.VVD| POST4.POD| POST4.POL| POST4.VVD| Pre1.POD| Pre1.POL| Pre1.VVD| Pre2.POD| Pre2.POL| Pre2.VVD| Pre3.POD| Pre3.POL| Pre3.VVD| Pre4.POD| Pre4.POL| Pre4.VVD| RC_FLG| REMARK_DETAIL| REP Commodity| Shipper Code| Shipper Name| SI_FLG| SLAN_CD| SOC_FLG| SPLIT_FLG| TRUNK_VVD";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter,	true,	'bb_' + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bkg_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'cntr_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'cntr_tpsz_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'grs_wgt' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pkg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'hot_de_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'rd_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bkg_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bkg_stf' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'spcl_cgo_auth_knt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bb_cmdt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dim_len' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dim_wdt' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dim_hgt' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ovr_void_slt_qty' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bdr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bl_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'rcv_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'de_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dcgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'awk_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ob_sls_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ob_srep_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'spcl_cgo_apro_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'remark' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bb_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'net_wgt' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'anty_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bkg_clz_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'bkg_cre_dt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'meas_qty' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'commodity' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'consignee' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'consignee_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'cust_to_ord_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dest_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'dest_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'eq_subst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'expt_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ffdr' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ffdr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'hngr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ntfy' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'ntfy_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'org_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'org_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pck_qty' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pck_tp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'post_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'pre_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'rc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'remark_detail' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'rep' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'shipper' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daLeft, true,  'bb_' + 'shpr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'si_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'slan_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'soc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'split_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'bb_' + 'trunk_vvd' ) ;
				CountPosition = 0;//[1/3] 페이지 위치 
 			}
 				
 			break;
		case "dg":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "N0.|Bst| BKG No.| CNTR No.| T/S| Net| Gross| PKG| HT| RF| BKG OFC| BKG STF| RQ| Substance| UN No| Pack Grp| MEA(CBM)| Bdr| B/L No| R| D| AK| BB| S/OFC| S/REP| AT| Contact Point| Class| F/Point| RMK| DG_CNTR_SEQ| DG| IMDG_COMP_GRP_CD| ANTY_NAME| BKG_CLZ_FLG| BKG_CRE_DT| MEAS_QTY| COMMODITY| Consignee Code| Consignee Name| CUST_TO_ORD_FLG| DEST_SVC_ROUTE| DEST_TRNS_SVC_MOD_CD| EQ_SUBST_FLG| EXPT_NAME| FFDR| FFDR_NAME| HNGR_FLG| NTFY| NTFY_NAME| ORG_SVC_ROUTE| ORG_TRNS_SVC_MOD_CD| PCK_QTY| PCK_TP_CD| POD| POL| POST1.POD| POST1.POL| POST1.VVD| POST2.POD| POST2.POL| POST2.VVD| POST3.POD| POST3.POL| POST3.VVD| POST4.POD| POST4.POL| POST4.VVD| Pre1.POD| Pre1.POL| Pre1.VVD| Pre2.POD| Pre2.POL| Pre2.VVD| Pre3.POD| Pre3.POL| Pre3.VVD| Pre4.POD| Pre4.POL| Pre4.VVD| RC_FLG| REMARK_DETAIL| REP Commodity| Shipper Code| Shipper Name| SI_FLG| SLAN_CD| SOC_FLG| SPLIT_FLG| TRUNK_VVD";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter,	true,	'dg_' + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bkg_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'cntr_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'cntr_tpsz_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'net_wgt' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'grs_wgt' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pkg' ,false, '', dfInteger);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'hot_de_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'rd_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bkg_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bkg_stf' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'spcl_cgo_auth_knt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'prp_shp_nm' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'imdg_un_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'imdg_pck_grp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'meas_qty' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bdr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bl_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'rcv_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'de_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'awk_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bb_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ob_sls_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ob_srep_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'spcl_cgo_apro_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'emer_cntc_phn_no_ctnt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'imdg_clss_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'flsh_pnt_cdo_temp' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'remark' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'dg_cntr_seq' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'dcgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'anty_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bkg_clz_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'bkg_cre_dt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'meas_qty' ,false, '', dfFloat,3);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'commodity' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'consignee' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'consignee_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'cust_to_ord_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'dest_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'dest_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'eq_subst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'expt_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ffdr' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ffdr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'hngr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ntfy' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'ntfy_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'org_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'org_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pck_qty' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pck_tp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'post_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'pre_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'rc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'remark_detail' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'rep' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'shipper' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daLeft, true,  'dg_' + 'shpr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'si_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'slan_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'soc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'split_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'dg_' + 'trunk_vvd' ) ;
				CountPosition = 0;//[1/3] 페이지 위치 
 			}
 				
 			break;
		case "rf":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "No.|Bst| BKG No.| CNTR No.| T/S| WGT(KGS)| PKG| HT| DG| BKG OFC| BKG STF| RQ| Commodity| C| F| Humid(%)| Vent| CA| MA| HM| AA| Bdr| B/L No| R| D| Gen| Voltage| AK| BB| S/OFC| S/REP| AT| RMK| CMDT_CD| NET| RD| ANTY_NAME| BKG_CLZ_FLG| BKG_CRE_DT| MEAS_QTY| COMMODITY| Consignee Code| Consignee Name| CUST_TO_ORD_FLG| DEST_SVC_ROUTE| DEST_TRNS_SVC_MOD_CD| EQ_SUBST_FLG| EXPT_NAME| FFDR| FFDR_NAME| HNGR_FLG| NTFY| NTFY_NAME| ORG_SVC_ROUTE| ORG_TRNS_SVC_MOD_CD| PCK_QTY| PCK_TP_CD| POD| POL| POST1.POD| POST1.POL| POST1.VVD| POST2.POD| POST2.POL| POST2.VVD| POST3.POD| POST3.POL| POST3.VVD| POST4.POD| POST4.POL| POST4.VVD| Pre1.POD| Pre1.POL| Pre1.VVD| Pre2.POD| Pre2.POL| Pre2.VVD| Pre3.POD| Pre3.POL| Pre3.VVD| Pre4.POD| Pre4.POL| Pre4.VVD| RC_FLG| REMARK_DETAIL| REP Commodity| Shipper Code| Shipper Name| SI_FLG| SLAN_CD| SOC_FLG| SPLIT_FLG| TRUNK_VVD";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter,	true,	'rf_' + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bkg_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cntr_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cntr_tpsz_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'grs_wgt' ,false, '', dfFloat,3) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pkg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'hot_de_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'dcgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bkg_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bkg_stf' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'spcl_cgo_auth_knt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'rf_cmdt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cdo_temp' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'fdo_temp' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'humid_no' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cntr_vent_tp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ctrl_atms_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'modi_atms_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'humid_ctrl_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'atfc_atms_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bdr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bl_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'rcv_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'de_term_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pwr_spl_cbl_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'vltg_no' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'awk_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bb_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ob_sls_ofc_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ob_srep_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'spcl_cgo_apro_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'remark' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cmdt_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'net_wgt' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'rd_cgo_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'anty_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bkg_clz_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'bkg_cre_dt' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'meas_qty' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'commodity' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'consignee' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'consignee_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'cust_to_ord_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'dest_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'dest_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'eq_subst_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'expt_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ffdr' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ffdr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'hngr_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ntfy' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'ntfy_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'org_svc_route' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'org_trns_svc_mod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pck_qty' ,false, '', dfFloat) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pck_tp_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'post_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_1_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_1_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_1_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_2_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_2_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_2_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_3_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_3_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_3_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_4_pod_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_4_pol_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'pre_4_vvd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'rc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'remark_detail' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'rep' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'shipper' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daLeft, true,  'rf_' + 'shpr_name' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'si_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'slan_cd' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'soc_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'split_flg' ) ;
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'rf_' + 'trunk_vvd' ) ;																										

				CountPosition = 0;//[1/3] 페이지 위치 
			}
	
			break;
			
		case "cntr":
            with (sheetObj) {
			
                // 높이 설정
                style.height = 100;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1, rowsPerPage);

				var HeadTitle1 = "No.|Bst| Bdr | BKG No.| B/L No.| CNTR No.| T/S| Commodity| C| F| Vent| Gen| CA| MA| HM| AA| REMARK_DETAIL";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtSeq,	 30, daCenter, true,  'cntr_' + "no");
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'bst_flg' ); 
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'bdr_flg' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'bkg_no' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'bl_no' );				
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'cntr_no' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'cntr_tpsz_cd' );
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'rf_cmdt' ) ;				
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'cdo_temp' ,false, '', dfFloat);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'fdo_temp' ,false, '', dfFloat);
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'cntr_vent_tp_cd');
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'pwr_spl_cbl_flg');
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'ctrl_atms_flg');
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'modi_atms_flg');				
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'humid_ctrl_flg');				
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'atfc_atms_flg');				
				InitDataProperty(0, cnt++ , dtData,  90, daCenter, true,  'cntr_' + 'remark_detail');
				CountPosition = 0;//[1/3] 페이지 위치 
			}

			break;
			
		case "multiOfc":
			with (sheetObj) {
				// 높이 설정
				style.height = 85;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);

				var HeadTitle1 = " | |Office";
				var headCount = ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "ofc_cd", false, "", dfEngUpKey, 0, true, true);

				CountPosition = 0;

			}
			break;
			
        case "locsheet":
            with (sheetObj) {
                style.height = GetSheetHeight(13);
                SheetWidth = mainTable.clientWidth;

                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                MergeSheet = msHeaderOnly;

                Editable = true;

                //[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 2, 100);

                //[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 1, 0, true);

                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "loc_cd" ;

                //[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "loc_cd",		false,			"",			dfNone,					0,			false,			false	);

           }
            break;  

	}//end case
}
    
    
/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheetDynamic(sheetObj,ColList) {
	sheetObj.RemoveAll();
    sheetObj.Reset();
    var cnt = 0;
    if(tempform.report_type.Text =="General(Awkward)" || tempform.report_type.Text =="General(Break Bulk)"
           || tempform.report_type.Text =="General(Dangerous)" || tempform.report_type.Text =="General(Reefer)"
           || tempform.report_type.Text == "General" || ColList ==""
           || tempform.report_type.Text =="Genearl(Reefer) by CNTR"
        ){
		form.p_grid_type.value ="G";//General - Grid 고정
			     
		with (sheetObj) {
			// 높이 설정
			style.height = 442;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            //MergeSheet = msPrevColumnMerge;
            //MergeSheet = msHeaderOnly +	msPrevColumnMerge;
            MergeSheet = msAll;
            
            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 2, 100, rowsPerPage);
			        	
			        	
			if(tempform.report_type.Text =="General(Awkward)"){
				var HeadTitle1 = "BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Commodity|WGT(KGS)|PKG|PKG|Over Length(CM)|Over Length(CM)|Over Length(CM)|Over Width(CM)|Over Width(CM)|Void (FEU)|HT|RF|BKG OFC|BKG STF|RQ|Remark(s)|REMARK_DETAIL";
				var HeadTitle2 = "BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Commodity|WGT(KGS)|R|D|FWD|AFT|HGT|PORT|STAR|Void (FEU)|DG|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
							
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,	  	daCenter,	false,		prefix + "bst_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "bkg_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daLeft,	 	 true,		prefix + "akrep_cmdt",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_fwrd_len",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_bkwd_len",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_hgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_lf_len",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_rt_len",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "ovr_void_slt_qty", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "hot_de_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "rd_cgo_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_ofc_cd",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix + "bkg_stf",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_auth_knt",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daLeft, 	false,		prefix + "remark_detail",    false,			"",      dfNone,			0,		true,		true);
					
				cnt=0;
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "bdr_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft, 	false,		prefix + "bl_no",    	       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,	  	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daLeft, 	true,		prefix + "akrep_cmdt",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "rcv_term_cd",      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "de_term_cd",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_fwrd_len",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_bkwd_len",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_hgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_lf_len",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "ovr_rt_len",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "ovr_void_slt_qty", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "dcgo_flg",    	   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "bb_cgo_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_sls_ofc_cd",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daCenter,	false,		prefix + "ob_srep_cd",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_apro_cd", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				50,		daLeft,	  	false,		prefix + "remark_detail",    false,			"",      dfNone,			0,		true,		true);

//				SetMergeCell (0, 4, 2, 1); //cntr no												
//				SetMergeCell (0, 5, 2, 1); //t/s												
//				SetMergeCell (0, 6, 2, 1); //cmdt												
//				SetMergeCell (0, 7, 2, 1); //wgt												
//				SetMergeCell (0, 15, 2, 1); //void												
//				SetMergeCell (0, 21, 2, 1); //rmk
												
			}else if(tempform.report_type.Text =="General(Break Bulk)"){
				var HeadTitle1 = "BKG_BL_FLG|No.|Bst|BKG No|T.VVD|Lane|Commodity|WGT(KGS)|PKG|PKG|Length|Width|Height|Void (FEU)|HT|RF|BKG OFC|BKG STF|RQ|Remark(s)|REMARK_DETAIL";
				var HeadTitle2 = "BKG_BL_FLG|No.|Bdr|B/L No|T.VVD|Lane|Commodity|WGT(KGS)|R|D|(CM)|(CM)|(CM)|Void (FEU)|DG|AK|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL	";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
							
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,	  	daCenter,	false,		prefix + "bst_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "bkg_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefix + "trunk_vvd",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "slan_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daLeft,	  	true,		prefix + "bb_cmdt",          false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_len",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_wdt",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_hgt",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "ovr_void_slt_qty", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "hot_de_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "rd_cgo_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_ofc_cd",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_stf",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_auth_knt",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",    false,			"",      dfNone,			0,		true,		true);

				cnt=0;
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "bdr_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft, 	false,		prefix + "bl_no",    	       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daCenter,	true,		prefix + "trunk_vvd",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "slan_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daLeft, 	true,		prefix + "bb_cmdt",       	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "rcv_term_cd",      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "de_term_cd",       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_len",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_wdt",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "dim_hgt",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "ovr_void_slt_qty", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "dcgo_flg",    	   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "awk_cgo_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_sls_ofc_cd",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_srep_cd",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_apro_cd", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",    false,			"",      dfNone,			0,		true,		true);
				
//				SetMergeCell (0, 4, 2, 1); //cntr no												
//				SetMergeCell (0, 5, 2, 1); //t/s												
//				SetMergeCell (0, 6, 2, 1); //cmdt												
//				SetMergeCell (0, 7, 2, 1); //wgt												
//				SetMergeCell (0, 13, 2, 1); //void												
//				SetMergeCell (0, 19, 2, 1); //rmk		
																								
												
			}else if(tempform.report_type.Text =="General(Dangerous)"){
				var HeadTitle1 = "BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Substance|UN No.|Pack Grp|WGT(KGS)|WGT(KGS)|MEA(CBM)|PKG|PKG|HT|RF|BKG OFC|BKG STF|RQ|Remark(s)|REMARK_DETAIL";
				var HeadTitle2 = "BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Contact Point|Class|F/Point|Net|Gross|MEA(CBM)|R|D|AK|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
							
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,	 	daCenter,	false,		prefix + "bst_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "bkg_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "substance", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix + "un no",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "pack grp",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true, 		prefix + "wgt(kgs)",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,	  	prefix + "wgt(kgs)",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "mea(cbm)",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	false,		prefix + "pkg",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	false,		prefix + "pkg",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "ht",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "rf",    	  false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_ofc_cd",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_stf",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_auth_knt", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",    	false,			"",      dfNone,			0,		true,		true);

				
				cnt=0;
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "bdr_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft, 	false,		prefix + "bl_no",    	       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,	  	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,	 	false,		prefix + "contact point",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daCenter,	false,		prefix + "class",    			   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daLeft,  	false,		prefix + "flsh_pnt_cdo_temp",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "net",    	  		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "gross",    			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "mea(cbm)",  		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "r",    	  		  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "d",    	  		  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "ak",    				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "bb",    				false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_sls_ofc_cd",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_srep_cd",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_apro_cd", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",    false,			"",      dfNone,			0,		true,		true);
												
//				SetMergeCell (0, 4, 2, 1); //cntr no												
//				SetMergeCell (0, 5, 2, 1); //t/s												
//				SetMergeCell (0, 11, 2, 1); //mea												
//				SetMergeCell (0, 19, 2, 1); //rmk													
												
			}else if(tempform.report_type.Text =="General(Reefer)"){
				var HeadTitle1 = "BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Commodity|WGT(KGS)|PKG|PKG|Temp|Temp|Humid(%)|Vent|CA|MA|HM|AA|HT|DG|BKG OFC|BKG STF|RQ|Remark(s)|REMARK_DETAIL";
				var HeadTitle2 = "BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Commodity|WGT(KGS)|R|D|C|F|Voltage|Gen|CA|MA|HM|AA|AK|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
							
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,	 	daCenter,	false,		prefix + "bst_flg",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "bkg_no",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	true,		prefix + "cntr_no",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					75,		daLeft,	  	true,		prefix + "rf_cmdt",         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	    false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	  			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "pkg",    	  			false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "cdo_temp",    		false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "fdo_temp",    		false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,		prefix + "humid_no",    		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	false,		prefix + "cntr_vent_tp_cd", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "ctrl_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "modi_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "humid_ctrl_flg",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "atfc_atms_flg",   false,			"",      dfNone,			0,		true,		true);
								
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "hot_de_flg",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "dcgo_flg",    	 		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_ofc_cd",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bkg_stf",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_auth_knt", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",    	false,			"",      dfNone,			0,		true,		true);

				cnt=0;
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "bdr_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft, 	false,		prefix + "bl_no",    	       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,	 	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					75,		daLeft, 	true,		prefix + "rf_cmdt",       	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "rcv_term_cd",   	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "de_term_cd",    	 false,			"",      dfNone,			0,		true,		true);
												
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	true,		prefix + "cdo_temp",    		 false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	true,		prefix + "fdo_temp",    		 false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daRight,	false,		prefix + "vltg_no",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	false,		prefix + "pwr_spl_cbl_flg",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	true,		prefix + "ctrl_atms_flg",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	true,		prefix + "modi_atms_flg",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	true,		prefix + "humid_ctrl_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	true,		prefix + "atfc_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "awk_cgo_flg",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "bb_cgo_flg",    	false,			"",      dfNone,			0,		true,		true);
												
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_sls_ofc_cd",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "ob_srep_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					20,		daCenter,	false,		prefix + "spcl_cgo_apro_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "remark",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				50,		daCenter,	false,		prefix + "remark_detail",   false,			"",      dfNone,			0,		true,		true);
												
//				SetMergeCell (0, 4, 2, 1); //cntr no												
//				SetMergeCell (0, 5, 2, 1); //t/s												
//				SetMergeCell (0, 6, 2, 1); //commodity												
//				SetMergeCell (0, 7, 2, 1); //wgt												
//				SetMergeCell (0, 14, 2, 1); //ca												
//				SetMergeCell (0, 15, 2, 1); //ma												
//				SetMergeCell (0, 16, 2, 1); //hm												
//				SetMergeCell (0, 22, 2, 1); //rmk	

			}else if(tempform.report_type.Text =="Genearl(Reefer) by CNTR"){

				var HeadTitle1 = "BKG_BL_FLG|No.|Bst|BKG No.|CNTR No.|T/S|Commodity|WGT(KGS)|PKG|PKG|Temp|Temp|Humid(%)|Vent|CA|MA|HM|AA|HT|DG|BKG OFC|BKG STF|RQ|Remark(s)|REMARK_DETAIL";
				var HeadTitle2 = "BKG_BL_FLG|No.|Bdr|B/L No.|CNTR No.|T/S|Commodity|WGT(KGS)|R|D|C|F|Voltage|Gen|CA|MA|HM|AA|AK|BB|S/OFC|S/REP|AT|Remark(s)|REMARK_DETAIL";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
							
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "Seq",						  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,	 	daCenter,	false,		prefix + "bst_flg",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,	  	false,		prefix + "bkg_no",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					90,	daLeft,	  	true,		prefix + "cntr_no",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,				75,		daLeft,	  	true,		prefix + "rf_cmdt",         false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "grs_wgt",    	    false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		prefix + "pkg",    	  			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		prefix + "pkg",    	  			false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "cdo_temp",    		false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefix + "fdo_temp",    		false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	false,		prefix + "humid_no",    		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix + "cntr_vent_tp_cd", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "ctrl_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "modi_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "humid_ctrl_flg",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "atfc_atms_flg",   false,			"",      dfNone,			0,		true,		true);
								
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "hot_de_flg",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "dcgo_flg",    	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				70,		daCenter,	false,		prefix + "bkg_ofc_cd",    	  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				70,		daCenter,	false,		prefix + "bkg_stf",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "spcl_cgo_auth_knt", false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				80,		daCenter,	true,		prefix + "remark",    	      false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					120,		daCenter,	false,		prefix + "remark_detail",     false,			"",      dfNone,			0,		true,		true);
				
				cnt=0;
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "Seq",						   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	false,		prefix + "bdr_flg",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft, 	false,		prefix + "bl_no",    	       false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daLeft,	 	true,		prefix + "cntr_no",    	     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					40,		daCenter,	true,		prefix + "cntr_tpsz_cd",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					75,		daLeft, 	true,		prefix + "rf_cmdt",       	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "grs_wgt",    	     false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtHidden,				40,		daCenter,	false,		prefix + "rcv_term_cd",   	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				40,		daCenter,	false,		prefix + "de_term_cd",    	 false,			"",      dfNone,			0,		true,		true);
												
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "cdo_temp",    		 false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daRight,	true,		prefix + "fdo_temp",    		 false,			"",      dfNone,			1,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				100,	daRight,	false,		prefix + "vltg_no",    	  	 false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	false,		prefix + "pwr_spl_cbl_flg",  false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "ctrl_atms_flg",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "modi_atms_flg",    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "humid_ctrl_flg",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "atfc_atms_flg",   false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "awk_cgo_flg",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "bb_cgo_flg",    	false,			"",      dfNone,			0,		true,		true);
												
				InitDataProperty(1, cnt++ , dtHidden,				70,		daCenter,	false,		prefix + "ob_sls_ofc_cd",   false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				70,		daCenter,	false,		prefix + "ob_srep_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				20,		daCenter,	false,		prefix + "spcl_cgo_apro_cd",false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				80,		daCenter,	true,		prefix + "remark",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					120,		daCenter,	true,		prefix + "remark_detail",   false,			"",      dfNone,			0,		true,		true);
				

			}else if(tempform.report_type.Text == "General" || ColList ==""){
							
				var HeadTitle1 = "No.|BKG_BL_FLG|BST|No Rate Status|SR|Previous\nContract|Changed\nContract|Booking No.|Shipper|POR|Rep.|TEU|SVC SCOPE|MEA(CBM)|PKG|PKG|DG|RF|FG|STWG|BS|ITN|CAED|CRN No.|B/OFC|C/OFC|L/OFC|L/TEAM|External\n Remark|Internal\n Remark|Charge Remark|Charge Remark|Rate Check Status|S/C No.|Remark(s)|Inter Remark Description|Charge Internal Remark Description|Charge External Remark Description|Mty P/up CY|ETB DT|Sailing DT|OFT Change\nafter PCT|REV.WEEK";
				var HeadTitle2 = "No.|BKG_BL_FLG|BDR|No Rate Status|SR|Previous\nContract|Changed\nContract|B/L No.|Consignee|DEL|Commodity|FEU|SVC SCOPE|WGT(KGS)|R|D|AK|BB|PC|STWG|BS|Type|TYPE|Vessel Name|BKG STF|C.SREP|L.SREP|L/TEAM|External\n Remark|Internal\n Remark|Internal|External|Rate Check Status|RFA No.|Remark(s)|Inter Remark Description|Charge Internal Remark Description|Charge External Remark Description|Mty P/up DT|ETB DT|Sailing DT|OFT Change\nafter PCT|REV.WEEK";
				var headCount = ComCountHeadTitle(HeadTitle1);
							          
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
							          
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
							          
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,					48,		daCenter,	true,		prefix + "Seq",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(0, cnt++ , dtData,					48,		daCenter,	false,		prefix + "bkg_sts_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefix + "non_rt_sts_cd",	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(0, cnt++ , dtData,					48,		daCenter,	true,		prefix + "si_flg",    		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		prefix + "pre_contrat",    	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		prefix + "now_contrat", 	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,		prefix + "bkg_no",    	    false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					115,	daLeft,		false,		prefix + "shpr_name", 		false,			"",      dfNone,			0,		true,		true);
												
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		prefix + "por_cd",       	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	false,		prefix + "rep",          	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "teu",          	false,			"",      dfNone,			2,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		true,		prefix + "svc_scp_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					80,		daRight,	false,		prefix + "bkg_mea_qty", 	false,			"",      dfNone,			3,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "pck_qty",    		false,			"",      dfNone,			0,		true,		true);
																																															                         
				InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	true,		prefix + "pck_tp_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "dcgo_flg",     	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "rc_flg",       	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "fd_grd_flg",   	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	true,		prefix + "stwg_cd",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	true,		prefix + "blck_stwg_cd",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "itn_flg",      	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix + "caed_flg",     	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix + "shp_call_no",  	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix + "bkg_ofc_cd",   	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix + "ctrt_ofc_cd",  	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		prefix + "ob_sls_ofc_cd",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "ofc_team_cd",		false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter, 	true,		prefix + "remark",			false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "inter_remark",  	false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "chg_inter_remark",  	false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefix + "chg_xter_remark", false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	true,		prefix + "rate_chk_sts",    false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		prefix + "sc_no",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "remark_detail");
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "inter_remark_detail");
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "chg_inter_remark_detail");
				InitDataProperty(0, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "chg_xter_remark_detail");
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		prefix + "mty_pkup_yd_cd", 	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		prefix + "etb_dt",        	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		prefix + "sail_dt",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	true,		prefix + "rtro_knd_cd_nm",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix + "cost_wk",     false,			"",      dfNone,			0,		true,		true);				
				cnt=0;
				InitDataProperty(1, cnt++ , dtData,					48,		daCenter,	true,		prefix + "Seq",				false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "bkg_bl_flg");
				InitDataProperty(1, cnt++ , dtData,					48,		daCenter,	false,		prefix + "bdr_flg",       	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daCenter,	true,		prefix + "non_rt_sts_cd",	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					48,		daCenter,	true,		prefix + "si_flg",       	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					80,		daCenter,	true,		prefix + "pre_contrat",    	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(1, cnt++ , dtData,					80,		daCenter,	true,		prefix + "now_contrat", 	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,		false,		prefix + "bl_no",         	false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(1, cnt++ , dtData,					115,	daLeft,		false,		prefix + "cnee_name",     	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	false,		prefix + "del_cd",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					80,		daCenter,	false,		prefix + "commodity",     	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "feu",           	false,			"",      dfNone,			2,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					100,	daLeft,		true,		prefix + "svc_scp_cd",		false,			"",      dfNone,			0,		true,		true);				
				InitDataProperty(1, cnt++ , dtData,					80,		daRight,	false,		prefix + "bkg_actwgt_qty",	false,			"",      dfNone,			3,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	false,		prefix + "rcv_term_cd",   	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					30,		daCenter,	false,		prefix + "de_term_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "awk_cgo_flg",   	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "bb_cgo_flg",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "pc",            	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	true,		prefix + "stwg_cd",		  	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	true,		prefix + "blck_stwg_cd",  	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "itn_type",      	false,			"",      dfNone,			0,		true,		true);
					
				InitDataProperty(1, cnt++ , dtData,					45,		daCenter,	false,		prefix + "caed_type",     	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	false,		prefix + "vsl_eng_nm",    	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	false,		prefix + "doc_usr_id",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	false,		prefix + "ctrt_srep_cd",  	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	false,		prefix + "ob_srep_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "ofc_team_cd",    	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter, 	true,		prefix + "remark",		  	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "inter_remark",  	false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "chg_inter_remark",   	false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					70,		daCenter,	true,		prefix + "chg_xter_remark",   	false,			"",    	 dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					120,	daCenter,	true,		prefix + "rate_chk_sts",     	false,			"",      dfNone,			0,		true,		true);
				
				InitDataProperty(1, cnt++ , dtData,					100,	daCenter,	false,		prefix + "rfa_no",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	true,		prefix + "remark_detail");
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "inter_remark_detail");
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "chg_inter_remark_detail");
				InitDataProperty(1, cnt++ , dtHidden,				48,		daCenter,	false,		prefix + "chg_xter_remark_detail");
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	true,		prefix + "mty_pkup_dt",     false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	true,		prefix + "etb_dt",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	true,		prefix + "sail_dt",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					90,		daCenter,	true,		prefix + "rtro_knd_cd_nm",        	false,			"",      dfNone,			0,		true,		true);
				InitDataProperty(1, cnt++ , dtData,					50,		daCenter,	true,		prefix + "cost_wk",     false,			"",      dfNone,			0,		true,		true);				
				//SetMergeCell (0, 21, 2, 1); //rmk	
			}
			
			CountPosition = 0;
		}//end width
						
	}else{ 
		form.p_grid_type.value ="P";//Private - Grid  가변적 
		selectedGridCols = new Array();//초기화
		with (sheetObj) {
			// 높이 설정
//			style.height = 60;
			style.height = 441;
			           
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			var HeadTitle1 = "";
			//alert(ColList);
			var arrColList = ColList.split("|");
			var tempName="";
			var tempCnt=0;
			for(var index=0; index < arrColList.length; index++) {
				tempName = arrColList[index].split(">")[1].toLowerCase();
				//alert(tempName);
				if(arrGridColsTitle[tempName] == undefined) {
					continue;
				}
//				if(tempCnt ==0)
//					HeadTitle1 = "|"+arrGridColsTitle[tempName]; //선택된 컬럼 헤더생성
//				else
					HeadTitle1 += "|"+ arrGridColsTitle[tempName]; //선택된 컬럼 헤더생성
												
				selectedGridCols[tempName]= "Y";//선택된 그리드 칼럼-나머지 헤더 및 속성 정의시 제외
				//debug.innerHTML += "<br>"+tempName;
				tempCnt++;
			}
									
//			debug.innerHTML=selectedGridCols.join("|");
//			debug.innerHTML=selectedGridCols.join("|");
									
			for (var key in arrGridColsTitle){ //선택된헤더 컬럼 외 나머지 컬럼 헤더 생성
				if(selectedGridCols[key] != undefined) {
					continue;
				}
				HeadTitle1 += "|"+ arrGridColsTitle[key];
			}
									
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, rowsPerPage);
											
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(true, true, true, true, false,false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//debug.innerHTML += "<BR><BR>" + HeadTitle1 + "<BR><BR>";
			InitDataProperty(0,		cnt++ , dtSeq,					30,		daCenter,		true,		prefix + "no");
			for (var key in selectedGridCols){ //선택된 헤더 컬럼  속성 세팅
				if(arrGridColsProp[key] == undefined) {
					continue;
				}
				eval(arrGridColsProp[key]);
				//debug.innerHTML += "<br>"+ arrGridColsProp[key];
			}
			for (var key in arrGridColsProp){ //선택된 헤더 컬럼 외 나머지 컬럼 헤더 속성 세팅
				if(selectedGridCols[key] != undefined) {
					continue;
				}
				
				eval(arrGridColsProp[key]);
				//debug.innerHTML += "<br>"+ arrGridColsProp[key];
				ColHidden(prefix + key) = true;
				//debug.innerHTML += "<br>"+cnt+ ColSaveName(cnt-1)+" - "+prefix + key;
			}
								
			//DoSearch("/apps/alps/esm/bkg/bookingreport/statusreport/jsp/UI_BKG_0103_DATA.html");
				
		}//end width        	
        	
		CountPosition = 0;
        	//debug.innerHTML = ColList;
	}        
}

function bkgOfcListPopUp() {
  	var bkgOfcList = "";
  	if (document.all.bkgOfcList.style.display == "none") {
		document.all.bkgOfcList.style.display = "block";
		document.all.bkgOfcList.style.visibility = 'visible';
		if ( sheetObjects[0].RowCount < 1 ) {
			sheetObjects[0].DataInsert(-1);
		}
		sheetObjects[0].CellValue2(1, "ofc_cd") = document.form.b_ofc_cd_1.value;
  	} else {
		document.all.bkgOfcList.style.display = "none";
		document.all.bkgOfcList.style.visibility = 'hidden';
		
		var ofcListcnt = 0;
		for( var j=sheetObjects[0].RowCount;j>0;j--){
			if ( ComTrim(sheetObjects[0].CellValue(j, "ofc_cd")).length > 0){
				ofcListcnt = ofcListcnt + 1;
			}else {
				sheetObjects[0].RowDelete(j, false);
			}
		}
		b_ofc_cd_cnt.innerHTML = ofcListcnt;
		
		if ( sheetObjects[0].RowCount > 0 ) {
			document.form.b_ofc_cd_1.value = sheetObjects[0].CellValue(1, "ofc_cd");
		} else {
			document.form.b_ofc_cd_1.value = "";
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue2(1, "ofc_cd") = "";
		}
		if ( sheetObjects[0].RowCount > 1 ){
			document.form.b_ofc_cd_sub.checked = false;
			document.form.b_ofc_cd_sub.value = "N";
		}
		for( var i=0;i<sheetObjects[0].RowCount;i++){
			if ( i == 0 ){
				bkgOfcList = sheetObjects[0].CellValue(i+1, "ofc_cd");
			} else {
				bkgOfcList = bkgOfcList + ',' + sheetObjects[0].CellValue(i+1, "ofc_cd");
			}
		}
		document.form.b_ofc_cd.value = bkgOfcList;
		doActionIBSheet(sheetObjects[1],document.form,SEARCH02,'','','','b_ofc_cd');   
  	}
}
   
function changeOfcCdSubManual(obj) {
	var formObj = document.form;
	if (obj.checked) {
 		if ( sheetObjects[0].RowCount > 1 ){
 			document.form.b_ofc_cd_sub.checked = false;
 			document.form.b_ofc_cd_sub.value = "N";
		} else {
			document.form.b_ofc_cd_sub.value = "Y";
		}
	} else {
		document.form.b_ofc_cd_sub.value = "N";
	}    			
}

function changeCustomerValue(obj) {
	document.form.cust_nm.value = ""; 			
}

function doProcessPopup(srcName, arg) {
		
		var sheetObj = sheetObjects[0];
		var formObj	= document.form;
		var sUrl	= '';
		var sWidth	= '';
		var sHeight	= '';
		
		with(sheetObj) {
  		switch(srcName) {
  		
  			case 'mty_rtn_ecc':		// CNTR No. 멀티입력 팝업 호출
  				var flag = ComReplaceStr(srcName,"m_","");
  			    var orgval = formObj.mty_rtn_ecc.value ;
		  		// 멀티입력 팝업 타이틀 세부 내용 지정
  				var returntitle = '';
  				if(flag == 'mty_rtn_ecc') returntitle = 'ECC';
  				var param = "?returnval=" + flag + "&returntitle=" + returntitle+ "&orgval=" + orgval;
  				ComOpenPopup('ESM_BKG_0109.do'+param, 400, 380, 'getEcc_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
  			  	if ( formObj.mty_rtn_ecc.value.length >= 5 ){
  			  		  formObj.mty_rtn_ecc.style.background = "#FFCCFF";
  			  		  formObj.mty_rtn_ecc.disabled = true;
  			  	}else{
  			  		 formObj.mty_rtn_ecc.style.background = "#FFFFFF"; 
  			  		 formObj.mty_rtn_ecc.disabled = false;
  			  	  }
  				return;
				break;
  				
  		} // switch-end
		} // with-end
		
	var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
	ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
	}


/*
 * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
 * - 해당 필드에 멀티 입력값을 설정해준다.
 */
function getEcc_Multi(rArray, return_val) {

	var targObj = eval("document.form." + return_val);
	var retStr = rArray.toString().toUpperCase();
	
	ComSetObjValue(targObj, retStr);
}






/**
 * MT PickUp CY Inquiry 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBack0019(rArray);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0019(rArray){    	
	var formObj = document.form;
//	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
    	if(rArray != null){
    		ComSetObjValue(formObj.vvd_cd,rArray[0][3]);
//    		ComSetObjValue(formObj.bkg_pol_yd_cd,"");
//    		ComSetObjValue(formObj.bkg_pod_yd_cd,"");
//    		por_pol_change(formObj);
//    		pod_del_change(formObj);
//    		
//    		ComSetObjValue(formObj.route_modify_flag, "Y");
//    		ComSetObjValue(formObj.modify_flag, "Y");
//    		manageHaveRouteFlag("N");
//    		if(rArray[0][3].substring(0,4) == "HJXX" || rArray[0][3].substring(0,4) == "HJYY" || rArray[0][3].substring(0,4) == "HJZZ"){
//    			ComSetObjValue(formObj.psdo_bkg_flg, "Y");
//    		}else{
//    			ComSetObjValue(formObj.psdo_bkg_flg, "N");
//    		}    		
//    		ComSetObjValue(formObj.check_ts_close_flag, "Y");
    		
//			if(sheetObjects[1].RowCount == 1){
//				sheetObjects[1].CellValue(1, "vsl_pre_pst_cd") = "T";
//				sheetObjects[1].CellValue(1, "vsl_seq") = "0";
//				sheetObjects[1].CellValue(1, "bkg_vvd_cd") = rArray[0][3];
//				sheetObjects[1].CellValue(1, "poL_clpt_ind_seq") = "1";
//				sheetObjects[1].CellValue(1, "pod_clpt_ind_seq") = "1";
//			}
    	}
//	}
}




/* 개발자 작업  끝 */    
		