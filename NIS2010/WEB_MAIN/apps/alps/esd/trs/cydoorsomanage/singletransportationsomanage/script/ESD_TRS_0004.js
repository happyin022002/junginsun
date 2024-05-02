/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0004.js
*@FileTitle : USA CY & DOOR S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.02
*@LastModifier : 민정호
*@LastVersion : 1.6
* 2006.09.25 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.02.26 조풍연 1.1 [N200902230070] TRS SO delete 대상 범위 변경
* 2009.03.19 조풍연 1.2 [N200903160110] 미주 I/B Overweight/Haz 구분 표시 (GRID HEADER를 BKG SPE -> CNTR SPE로 변경)
* 2010.10.08 최 선     1.3 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.03.15 최 선     1.4 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2011.09.07 민정호   1.5 [CHM-201113207] [TRS] overweight 정보를 가진 candidate 발행 block message 추가 요청
* 2011.11.02 민정호   1.6 [CHM-201114318] [TRS] 선택된 Row 표현 구분방식 변경 + D7 (AK) SPC cargo 표현로직 제거 요청
* 2011.12.14 민정호   1.7 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
* 2014.03.27 김현화 [CHM-201429546] [TRS] S/O candidate 변경 방지 로직 요청(Planed 된 경우 Transmode와 Route blocking 처리, 'Reason of Trans Mode/Node Change' hidden 처리)
*                                   O/B Door 인 경우 -> From node 수정 허용
*                                   I/B Door 인 경우 -> To node 수정 허용
* 2014.04.10 김현화 [CHM-201429806]S/O candidate 변경 방지 로직 요청2- Yard 수정 가능하도록 변경.
* 2014.04.25 김현화 [CHM-201429986]Multiple Apply 로직 변경
* 2014.05.13 김현화 [CHM-201430227]Multiple Apply 로직 변경 원상복귀
* 2014.05.16 김현화 [CHM-201430212]TRS S/O candidate 변경 방지 로직 요청2-Via Location 수정가능하도록 변경
* 2014.10.20 김현화 [CHM-201432366]No rate BKG에 대한 S/O Creation 미허용 로직 -Status'R' 인 경우 미허용                                       
* 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var sheetObject4 = sheetObjects[4];  //Actual Customer Info Set GRID
	var sheetObject5 = sheetObjects[5];
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
				style.height    = 240; // 높이 설정
				SheetWidth      = mainTable.clientWidth; //전체 너비 설정
				
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet       = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable         = true; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo      ( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo   (165, 6, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode     (true, true, true, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				var HeadTitle0 = "Sel.|STS|CB|SOURCE|Pre-Pull|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|CNT(Approval)|CNT(Approval)|CNT(Approval)|CNT(Approval)|"
				+"From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|Door Location|"
				+"Door Information|Door Information|Door Information|Door Information|"
				+"Door Information|Door Information|Door Information|Remark\n(Special Instruction)|"
				+"Web D/O|Web D/O|Web D/O|Multi\nStop|Bid|Bid|Bid|Estimated Time|Estimated Time|"
				+"Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|CNTR\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|"
				+"in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|USA Rail|USA Rail|USA Rail|"
				+"Customs\nC.LOC|USA\nLast City|"
				+"F|O|C|Pickup No.|Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nNode Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";

				var HeadTitle1 = "Sel.|STS|CB|SOURCE|Pre-Pull|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|Contract No|Flag|Type|Count|"
				+"Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Name|"
				+"Actual\nCustomer|Factory\nName|Zip\nCode|Address|"
				+"TEL|FAX|PIC|Remark\n(Special Instruction)|"
				+"User Info|Time|Time|Multi\nStop||Due Date|Due Date|From Departure|From Departure|"
				+"To Arrival|To Arrival|Door Arrival|Door Arrival|TRO Door Date|TRO Door Date|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term"
				+"|SEQ|CNFM|Office|User ID|"
				+"Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|CNTR\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|"
				+"in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|To Node|Creation Time|Creation Time|"
				+"Customs\nC.LOC|USA\nLast City|"
				+"F|O|C|Pickup No.|||||S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nNode Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", 			false, "", dfNone, 0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 50, 	daCenter, true, "trsp_so_cmb_seq", 		false, "", dfNone, 0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 100, 	daCenter, true, "source", 				false, "", dfNone, 0, false, 	false);
				InitDataProperty(0, cnt++, dtDummyCheck, 50,daCenter, true, "pre_pull_chk", 		false, "", dfNone, 0, true, 	true, -1, false, true, "", false); //20121030
				InitDataProperty(0, cnt++, dtData, 100, 	daCenter, true, "eq_no", 				false, "", dfNone, 0, false, 	false);
				InitDataProperty(0, cnt++, dtData,  50, 	daCenter, true, "eq_tpsz_cd", 			false, "", dfNone, 0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 	50, 	daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 1, false, 	false);
				InitDataProperty(0, cnt++, dtCombo,	50, 	daCenter, true, "trsp_crr_mod_cd", 		false, "", dfNone, 0, true, 	true);

				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "ctrt_no", 	false, "", dfEngUpKey, 1, true,  true,  5);
				InitDataProperty(0, cnt++, dtData,   40, daCenter, true, "cnt_flg", 	false, "", dfEngUpKey, 1, false, false, 5);
				//InitDataProperty(0, cnt++, dtData,   40, daCenter, true, "cnt_tp_cd", 	false, "", dfEngUpKey, 1, false, false, 5);
				//dtData -> dtCombo
				InitDataProperty(0, cnt++, dtCombo,	50,  daCenter, true, "cnt_tp_cd", 	false, "", dfEngUpKey, 0, false, false);
				
				InitDataProperty(0, cnt++, dtPopup,  50,  daRight, true, "ctrt_cnt", 	false, "", dfEngUpKey, 1, true,  true,  5);
				
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "fm_nod_cd", 		false, "", dfEngUpKey, 	1, 	true, true, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "fm_nod_yard", 		false, "", dfNone, 	   	1, 	true, true);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "via_nod_cd", 		false, "", dfEngUpKey, 	1, 	true, true, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "via_nod_yard",		false, "", dfNone, 	   	1, 	true, true);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "to_nod_cd", 		false, "", dfEngUpKey, 	1, 	true, true, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "to_nod_yard", 		false, "", dfNone, 	   	1, 	true, true);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "dor_nod_cd", 		false, "", dfNone, 		1, 	true, true, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "dor_nod_yard", 	false, "", dfNone, 		1, 	true, true);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "dor_nod_yard_nm", 	false, "", dfNone, 		1,  false,false);
				
				/* DOOR INFORMATION */
				//-jsk-20071127-InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "cust_cnt_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq
				InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "act_cust_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq
				
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "fctry_nm", 		false, "", dfNone, 1, true, true, 100); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, true, "dor_pst_cd", 		false, "", dfNone, 1, true, true, 10);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "dor_de_addr", 		false, "", dfNone, 1, true, true, 200);
				InitDataProperty(0, cnt++, dtData, 80,  daCenter, true, "cntc_pson_phn_no", false, "", dfNone, 1, true, true, 20); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80,  daCenter, true, "cntc_pson_fax_no", false, "", dfNone, 1, true, true, 20); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80,  daLeft,   true, "cntc_pson_nm", 	false, "", dfNone, 1, true, true, 100); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 120, daLeft,   true, "spcl_instr_rmk", 	false, "", dfEngUpKey, 0, true, true, 255);
                /* DOOR INFORMATION */
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "usa_do_usr_info", 	false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "do_cre_date", 		false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "do_cre_time", 		false, "", dfNone, 0, false, false, 255);

				InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "mlt_stop_de_flg", false, "", dfNone, 1, true, true);
				
				InitDataProperty(0, cnt++, dtCheckBox, 30, 	daCenter, true, "spot_bid_flg");
				InitDataProperty(0, cnt++, dtData, 70, 		daCenter, true, "spot_bid_due_dt", 		false, "",    	dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 60, 		daCenter, true, "spot_bid_due_dt_hms", 	false, "",   	dfTimeHms, 1, false, false);			
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "n1st_nod_pln_dt", 		false, "", dfDateYmd, 1, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "n1st_nod_pln_dt_hms", 	false, "", dfTimeHms, 1, true, true);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lst_nod_pln_dt", 		false, "", dfDateYmd, 1, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "lst_nod_pln_dt_hms", 	false, "", dfTimeHms, 1, true, true);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "dor_nod_pln_dt", 		false, "", dfDateYmd, 1, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "dor_nod_pln_dt_hms", 	false, "", dfTimeHms, 1, true, true);
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "dor_arr_dt_dd", 	false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "dor_arr_dt_hms", 	false, "", dfTimeHms, 1, false, false); //20070726
				
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cop_no", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "cost_act_grp_cd", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "trsp_so_sts_nm", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", 			false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "prt_bkg_no", 		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", 			false, "", dfNone, 0, false, false); //bl_no = BL_NO + BL_NO_TP + BL_NO_CHK
				InitDataProperty(0, cnt++, dtData,  30, daCenter, true, "trsp_bnd_cd", 		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "bkg_rcvde_term_cd",false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_seq", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cnfm", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_ofc_cd", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_usr_id", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_upd_dt1", false, "", dfDateYmd, 	0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "tro_cfm_upd_dt2", false, "", dfTimeHms, 	0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_curr_cd", false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight,  true, "tro_cfm_rev_amt", false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_lod_ref_no", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_rep_cmdt_cd", false, "", dfNone, 		0, false, false);

				InitDataProperty(0, cnt++, dtData, 	 80, daLeft,   true, "bkg_qty", 			false, "", dfNone, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 	 50, daCenter, true, "bkg_cgo_tp_cd", 		false, "", dfNone, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtPopup,	 50, daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 	1, true, 	true);
				InitDataProperty(0, cnt++, dtData, 	 80, daLeft,   true, "sealno", 				false, "", dfNone, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 	 80, daLeft,   true, "sealno2", 			false, "", dfNone, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 50, daRight,  true, "cntr_wgt",			false, "", dfFloat, 3, false, 	false);

				InitDataProperty(0, cnt++, dtData,   80, daRight,  true, "cntr_kgs_wgt", 	false, "", dfFloat, 3, true, true);
				InitDataProperty(0, cnt++, dtData,   90, daRight,  true, "cntr_lbs_wgt", 	false, "", dfFloat, 3, true, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "wgt_meas_ut_cd", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daRight,  true, "noofpkg", 		false, "", dfFloat,3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "pkgcode", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  100, daLeft,   true, "cmdt_name", 		false, "", dfNone, 0, false, false, 100);
				InitDataProperty(0, cnt++, dtData,  100, daCenter, true, "trunkvvd", 		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,   50, daCenter, true, "slan_cd", 		false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ib_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ob_vvd_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "por_cd", 				false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "pol_cd", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "pod_cd", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "del_cd", 				false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "shpr_cust_nm",   		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "cnee_cust_nm",   		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft,   true, "ntfy_cust_nm",   		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  60, daCenter, true, "rail_to_nod_cd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "rail_cre_dt_dd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  60, daCenter, true, "rail_cre_dt_hms", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "lst_loc_cd", 			false, "", dfNone, 0,  true, true);
				InitDataProperty(0, cnt++, dtData,  30, daCenter, true, "cgor_frt_pay_ind_flg", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  30, daCenter, true, "cgor_org_bl_rcvr_ind_flg", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  30, daCenter, true, "cgor_cstms_acpt_re_ind_flg", 	false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_pkup_no", 	false, "", dfNone,    0, true, true, 12);
				InitDataProperty(0, cnt++, dtData,  80,  daCenter, true, "aval_dt", 		false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData,  60,  daCenter, true, "aval_dt_hms", 	false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtData,  80,  daCenter, true, "lst_free_dt", 	false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData,  60,  daCenter, true, "lst_free_dt_hms", false, "", dfTimeHms, 0, true, true);

				InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "sc_no", 			    false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "customsclearance",   false, "", dfNone,    1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "customsclearanceNo", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "rfano", 		  		false, "", dfNone, 	  0, false, false);
				InitDataProperty(0, cnt++, dtData,    80, daCenter, true, "ownr_co_cd",   		false, "", dfNone, 	  0, false, false);
				InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "imdt_ext_flg", 		false, "", dfNone, 	  0, false, false);
				InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "lstm_cd", 	  		false, "", dfNone, 	  1, false, false);
				InitDataProperty(0, cnt++, dtCombo,   80, daCenter, true, "dor_svc_tp_cd",		false, "", dfNone, 	  0,  true, true);
				InitDataProperty(0, cnt++, dtData,   120, daLeft,   true, "inter_rmk", 	  		false, "", dfEngUpKey,1,  true,	true, 255);
				
				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "ctrl_ofc_cd", 	false, "", dfEngUpKey, 0, false, 	false);
				InitDataProperty(0, cnt++, dtData,   100, daLeft,   true, "cng_rsn_desc", 	false, "", dfEngUpKey, 0, true, 	true, 255); // 2014.03.27 hidden //2014.04.22 다시 오픈	
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft,   true, "irg", 			false, "", dfEngUpKey, 0, false, 	false);

				InitDataProperty(0, cnt++, dtData, 130, daCenter, true, "trns_rqst_ofc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 130, daLeft,   true, "trns_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 130, daLeft,   true, "trns_rqst_rsn", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "lse_cntr_flg", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "non_rt_sts_cd",   	false, "", dfNone, 0, false, false);

				//UI에 나타나지 않는 값 시작
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cgo_tp_cd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pod_conti_cd", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_loc_conti_cd", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_cnt_cd", 		false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_seq", 		false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_seq", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_seq", 	false, "", dfNone, 0, false, false);
							
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_cnt_cd", 	false, "", dfNone, 0, false, false); //20070726 정원근 수석 요청
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_seq", 	false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_addr_seq",false, "", dfNone, 0, false, false); /* 2007-11-23 */
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cstms_clr_no", 	false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rep_cmdt_cd", 		false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rev_curr_cd", 		false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_rev_amt", 	false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_nxt_port_cd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_nomi_trkr_flg", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rail_cmb_thru_tp_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_so_ofc_cty_cd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cre_usr_id", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upd_usr_id", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_cd2", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_cd2", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_cd2", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_cd2", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_arr_dt", 	false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_pln", 	false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_cost_dtl_mod_sep",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upln_so_flg", 			false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "proc_cfm_ind_cd", 		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cmdt_cd", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vndr_seq", 			false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq", 	false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rc_seq", 		false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "awk_cgo_seq", 	false, "", dfNone, 1, false, false);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_seq", 	false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_dt",  		false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_flg", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_crr_mod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tro_sub_seq", 		false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "feedervvd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pre_pull_flg", 	false, "", dfNone, 0, false, false); //20121030
				//UI에 나타나지 않는 값 끝

				RangeBackColor(1, 24, 1, 31) = RgbColor(222, 251, 248); // ENIS
				RangeBackColor(1, 8, 1, 16) = RgbColor(222, 251, 248); // ENIS

				InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
				InitDataCombo(0, 'dor_svc_tp_cd', dor_svc_tp_cdText, dor_svc_tp_cdCode);
				
				InitDataCombo(0, 'cnt_tp_cd',    "SML|CNT|CPT|HPT",    "HJS|CNT|CPT|HPT");
				
				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
//				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
			}
			break;
		case 2:      //sheet 2 init
			with (sheetObj) {
				style.height = 240; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(155, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false)

				var HeadTitle0 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|"
				+"From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|"
				+"Door Information|Door Information|Door Information|Door Information|"
				+"Door Information|Door Information|Door Information|Remark\n(Special Instruction)|"
				+"Web D/O|Web D/O|Web D/O|Multi\nStop|Estimated Time|Estimated Time|"
				+"Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|Estimated Time|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|"
				+"in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|USA Rail|USA Rail|USA Rail|"
				+"Customs\nC.LOC|USA\nLast City|"
				+"F|O|C|Pickup No.|Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nTrans Mode\n/Node Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";

				var HeadTitle1 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|"
				+"Loc|Node|Loc|Node|Loc|Node|Loc|Zone|"
				+"Actual\nCustomer|Factory\nName|Zip\nCode|Address|"
				+"TEL|FAX|PIC|Remark\n(Special Instruction)|"
				+"User Info|Time|Time|Multi\nStop|From Departure|From Departure|"
				+"To Arrival|To Arrival|Door Arrival|Door Arrival|TRO Door Date|TRO Door Date|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term"
				+"|SEQ|CNFM|Office|User ID|"
				+"Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|"
				+"in VVD|out VVD|POR|POL|POD|DEL|Shipper|Consignee|Notify|To Node|Creation Time|Creation Time|"
				+"Customs\nC.LOC|USA\nLast City|"
				+"F|O|C|Pickup No.|||||S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nTrans Mode\n/Node Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trsp_so_cmb_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "source", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "trsp_crr_mod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "fm_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "fm_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "via_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "via_nod_yard",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "to_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "to_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "dor_nod_cd", false, "", dfNone, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "dor_nod_yard", false, "", dfNone, 1, false, false);
				
				//-jsk-20071127-InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "cust_cnt_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq
				InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "act_cust_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq				
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fctry_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_pst_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "dor_de_addr", false, "", dfNone, 1, false, false, 200);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_phn_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_fax_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, true, true, 255);
                
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "usa_do_usr_info", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "do_cre_date", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "do_cre_time", false, "", dfNone, 0, false, false, 255);
                
                
                InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "mlt_stop_de_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "n1st_nod_pln_dt", false, "",    dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "n1st_nod_pln_dt_hms", false, "",   dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "lst_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lst_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dor_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "dor_arr_dt_dd", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_arr_dt_hms", false, "", dfTimeHms, 1, false, false); //20070726

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cost_act_grp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trsp_so_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "prt_bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false); //bl_no = BL_NO + BL_NO_TP + BL_NO_CHK
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cnfm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "tro_cfm_upd_dt1", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt2", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_curr_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "tro_cfm_rev_amt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_lod_ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_rep_cmdt_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "bkg_qty", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,50 , daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daLeft, true, "sealno", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daLeft, true, "sealno2", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtData, 60 , daRight, true, "cntr_kgs_wgt", false, "", dfFloat, 3, false, false);
				InitDataProperty(0, cnt++, dtData, 60 , daRight, true, "cntr_lbs_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "wgt_meas_ut_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "noofpkg", false, "", dfFloat,3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pkgcode", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100 , daLeft, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "trunkvvd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ib_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ob_vvd_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "por_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "del_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "shpr_cust_nm", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cnee_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "ntfy_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rail_to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rail_cre_dt_dd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rail_cre_dt_hms", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "lst_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cgor_frt_pay_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cgor_org_bl_rcvr_ind_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "cgor_cstms_acpt_re_ind_flg", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "cntr_pkup_no", false, "", dfNone, 0, true, true, 12);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "aval_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "aval_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "lst_free_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "lst_free_dt_hms", false, "", dfTimeHms, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "sc_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearance", false,"", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearanceNo", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "rfano", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "imdt_ext_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60 , daCenter, true, "lstm_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 80 , daCenter, true, "dor_svc_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "inter_rmk", false, "", dfEngUpKey, 1, true, true, 255);
				
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ctrl_ofc_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100,  daLeft, true, "cng_rsn_desc", false, "", dfEngUpKey, 0, true, true, 255);  
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "irg", false, "", dfEngUpKey, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trns_rqst_ofc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trns_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "trns_rqst_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "lse_cntr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "non_rt_sts_cd",   false, "", dfNone, 0, false, false);

				//UI에 나타나지 않는 값 시작
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pod_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_loc_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_seq", false, "", dfNone, 0, false, false);
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_seq", false, "", dfNone, 0, false, false);								
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726 정원근 수석 요청
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_seq", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_addr_seq", false, "", dfNone, 0, false, false); /* 2007-11-23 */

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cstms_clr_no", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_arr_dt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_pln", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rep_cmdt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rev_curr_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_nxt_port_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_nomi_trkr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rail_cmb_thru_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_cost_dtl_mod_sep", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upln_so_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "proc_cfm_ind_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vndr_seq", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rc_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "awk_cgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_seq", false, "", dfNone, 1, false, false);
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_dt",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_flg", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_crr_mod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tro_sub_seq", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "feedervvd", false, "", dfNone, 0, false, false);	
				
				//UI에 나타나지 않는 값 끝

				RangeBackColor(1, 24, 1, 31) = RgbColor(222, 251, 248); // ENIS
				RangeBackColor(1, 8, 1, 16) = RgbColor(222, 251, 248); // ENIS

				InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
				InitDataCombo(0, 'dor_svc_tp_cd', dor_svc_tp_cdText, dor_svc_tp_cdCode);
				
				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
			}
			break;
		case 3: //sheet 2 init
			with (sheetObj) {
				style.height = 240; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(162, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false)

				var HeadTitle0 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|"
				+"From Node|From Node|Via Node|Via Node|To Node|To Node|Door Location|Door Location|"
				+"Door Information|Door Information|Door Information|Door Information|"
				+"Door Information|Door Information|Door Information|Remark\n(Special Instruction)|"
				+"Web D/O|Web D/O|Web D/O|Multi\nStop|"
				+"Estimated Time|Estimated Time|Estimated Time|Estimated Time|"
				+"Estimated Time|Estimated Time|Estimated Time|Estimated Time|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|"
				+"POR|POL|POD|DEL|Shipper|Consignee|Notify|USA Rail|USA Rail|USA Rail|"
				+"Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|"
				+"Avaliable DT|Avaliable DT|Last Free DT|Last Free DT|S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nTrans Mode\n/Node Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";
				var HeadTitle1 = "Sel.|STS|CB|SOURCE|CNTR No.|TP / SZ|Cost\nMode|Trans\nMode|"
				+"Loc|Node|Loc|Node|Loc|Node|Loc|Zone|"
				+"Actual\nCustomer|Factory\nName|Zip\nCode|Address|"
				+"TEL|FAX|PIC|Remark\n(Special Instruction)|"
				+"User Info|Time|Time|Multi\nStop|From Departure|From Departure|"
				+"To Arrival|To Arrival|"
				+"Door Arrival|Door Arrival|TRO Door Date|TRO Door Date|"
				+"COP No|A/G SEQ|A/G Code|S/O Status|BKG No|Master BKG No|BL No|BND|Term|"
				+"SEQ|CNFM|Office|User ID|"
				+"Time|Time|Revenue\nCurrency|Revenue\nAmount|Load\nReference No|"
				+"TRO REP CMDT|BKG QTY|CGO\nTP|BKG\nSPE|Seal\nNo.1|Seal\nNo.2|Weight|Weight\n(KGS)|Weight\n(LBS)|"
				+"Weight\nUOM|No of\nPKG|PKG\nCode|Commodity\nDescription|Trunk\nVVD|Lane|in VVD|out VVD|"
				+"POR|POL|POD|DEL|Shipper|Consignee|Notify|To Node|Creation Time|Creation Time|"
				+"Customs\nC.LOC|USA\nLast City|F|O|C|Pickup No.|"
				+"||||S/C No|"
				+"Customs\nClearance|Customs\nClearance No|RFA No|Used|Imm.\nExit|L/T|"
				+"Door\nSVC TP|Internal Remark|S/O Office|Reason of\nTrans Mode\n/Node Change|IRG|"
				+"Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Off Hire\n Verify Result|BKG\nStatus";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trsp_so_cmb_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "source", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trsp_cost_dtl_mod_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "trsp_crr_mod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "fm_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "fm_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "via_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "via_nod_yard",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "to_nod_cd", false, "", dfEngUpKey, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "to_nod_yard", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true, "dor_nod_cd", false, "", dfNone, 1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "dor_nod_yard", false, "", dfNone, 1, false, false);
				
				//-jsk-20071127-InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "cust_cnt_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq
				InitDataProperty(0, cnt++, dtPopup,100, daCenter, true, "act_cust_cd", false, "", dfNone, 1, true, true); //cust_cnt_cd = cust_cnt_cd + cust_seq				
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fctry_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_pst_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "dor_de_addr", false, "", dfNone, 1, false, false, 200);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_phn_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_fax_no", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntc_pson_nm", false, "", dfNone, 1, false, false); //20070720 추가
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, true, true, 255);
                
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "usa_do_usr_info", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "do_cre_date", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "do_cre_time", false, "", dfNone, 0, false, false, 255);
                InitDataProperty(0, cnt++, dtHidden,100, daCenter, true, "mlt_stop_de_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "n1st_nod_pln_dt", false, "",    dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "n1st_nod_pln_dt_hms", false, "",   dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "lst_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lst_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dor_nod_pln_dt", false, "", dfDateYmd, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dor_nod_pln_dt_hms", false, "",     dfTimeHms, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "dor_arr_dt_dd", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dor_arr_dt_hms", false, "", dfTimeHms, 1, false, false); //20070726

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cost_act_grp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trsp_so_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "prt_bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false); //bl_no = BL_NO + BL_NO_TP + BL_NO_CHK
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cnfm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_ofc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "tro_cfm_upd_dt1", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tro_cfm_upd_dt2", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_cfm_curr_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "tro_cfm_rev_amt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_lod_ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "tro_rep_cmdt_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "bkg_qty", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,50 , daCenter, true, "spcl_cgo_cntr_tp_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daLeft, true, "sealno", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daLeft, true, "sealno2", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "cntr_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtData, 60 , daRight, true, "cntr_kgs_wgt", false, "", dfFloat, 3, false, false);
				InitDataProperty(0, cnt++, dtData, 60 , daRight, true, "cntr_lbs_wgt", false, "", dfFloat, 3, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "wgt_meas_ut_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daRight, true, "noofpkg", false, "", dfFloat,3, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50 , daCenter, true, "pkgcode", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100 , daLeft, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "trunkvvd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ib_vvd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ob_vvd_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "por_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "del_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "shpr_cust_nm", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cnee_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "ntfy_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rail_to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rail_cre_dt_dd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rail_cre_dt_hms", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "lst_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cgor_frt_pay_ind_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cgor_org_bl_rcvr_ind_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "cgor_cstms_acpt_re_ind_flg", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "cntr_pkup_no", false, "", dfNone, 0, true, true, 12);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "aval_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "aval_dt_hms", false, "", dfTimeHms, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100 , daCenter, true, "lst_free_dt", false, "", dfDateYmd, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "lst_free_dt_hms", false, "", dfTimeHms, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "sc_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearance", false,"", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100 , daCenter, true, "customsclearanceNo", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "rfano", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80 , daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50 , daCenter, true, "imdt_ext_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60 , daCenter, true, "lstm_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtCombo, 80 , daCenter, true, "dor_svc_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "inter_rmk", false, "", dfEngUpKey, 1, true, true, 255);
				
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ctrl_ofc_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cng_rsn_desc", false, "", dfEngUpKey, 0, true, true, 255); 				
				InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "irg", false, "", dfEngUpKey, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trns_rqst_ofc_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trns_rqst_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trns_rqst_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  70, daCenter, true, "lse_cntr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "non_rt_sts_cd",   false, "", dfNone, 0, false, false);

				//UI에 나타나지 않는 값 시작
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pod_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_loc_conti_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_seq", false, "", dfNone, 0, false, false);
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cnee_cust_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "shpr_cust_seq", false, "", dfNone, 0, false, false);								
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_cnt_cd", false, "", dfNone, 0, false, false); //20070726 정원근 수석 요청
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_seq", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "act_cust_addr_seq", false, "", dfNone, 0, false, false); /* 2007-11-23 */
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cstms_clr_no", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_arr_dt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_pln", false, "", dfDateYmd, 1, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rep_cmdt_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rev_curr_cd", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_rev_amt", false, "", dfNone, 0, false, false); //20070726
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_nxt_port_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cust_nomi_trkr_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rail_cmb_thru_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "via_nod_yard2",false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dor_nod_yard2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_cost_dtl_mod_sep", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upln_so_flg", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "proc_cfm_ind_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vndr_seq", false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rc_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "awk_cgo_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_bnd_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rqst_ord_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ref_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "repo_pln_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pln_yrwk", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ref_seq", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_so_cmb_tp_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_mty_cost_mod_cd", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_mty_rqst_dt", false, "", dfEngUpKey, 0, false, false);
								
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_dt",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_bdr_flg", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_crr_mod_cd2", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "tro_sub_seq", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "feedervvd", false, "", dfNone, 0, false, false);	
				
				//UI에 나타나지 않는 값 끝	

				RangeBackColor(1, 24, 1, 31) = RgbColor(222, 251, 248); // ENIS
				RangeBackColor(1, 8, 1, 16) = RgbColor(222, 251, 248); // ENIS

				InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
				InitDataCombo(0, 'dor_svc_tp_cd', dor_svc_tp_cdText, dor_svc_tp_cdCode);
				
				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
		  }
		break;
		
		case 4: //sheet 2 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				SheetWidth = 0; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(12, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle0 = "chk|S/O Office|Seqence|Bid Flag|Due Date|Due Time|crr_mod_cd|fm node|via node|dor node|to node";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,  50, 	daCenter, 	true, "chk");
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "trsp_so_ofc_cty_cd"	,false, 	"",			dfNone, 	0, false, false);
				InitDataProperty(0, cnt++, dtData,  	80, 	daCenter, 	true, "trsp_so_seq"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "spot_bid_flg"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "spot_bid_due_dt"     ,false, 	"", 		dfDateYmd, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "spot_bid_due_dt_hms" ,false, 	"", 		dfTimeHms, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "trsp_crr_mod_cd"     ,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "fm_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "via_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "dor_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "to_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,   true, "ibflag");
			}
		break;
		
		case 5: //sheet 5 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				SheetWidth   = 0; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet   = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable     = false; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(12, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)

				var HeadTitle0 = "RTN_VALUE|ACT_CUST_CNT_CD|ACT_CUST_SEQ|ACT_CUST_ADDR_SEQ|ACT_CUST_FCTRY_PST_CD|ACT_CUST_FCTRY_NM|ACT_CUST_FCTRY_ADDR|ACT_CUST_FCTRY_PHN_NO|ACT_CUST_FCTRY_FAX_NO|ACT_CUST_FCTRY_PIC_NO|ACT_CUST_EML|ACT_CUST_RMK";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "rtn_value", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_cnt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_addr_seq", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_pst_cd", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_nm", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_addr", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_phn_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_fax_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_fctry_pic_no", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_eml", false, "", dfNone, 1, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "act_cust_rmk", false, "", dfNone, 1, false, false);
			}
		break;

		case 6: //sheet 6 init
		with (sheetObj) {
			style.height = 0; // 높이 설정
			SheetWidth = 0; //전체 너비 설정
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
			MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
			Editable = false; //전체Edit 허용 여부 [선택, Default false]
			InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitColumnInfo(2, 2, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle0 = "CNTR_NO|OFFH_YD_CD";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle0, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "offh_yd_cd", false, "", dfNone, 0, false, false);			
		}
		break;
		
	}
}


/*========================================================="
 * CY & DOOR 화면 ESD_TRS_0002, ESD_TRS_0004, ESD_TRS_0005
 * 는 IBSHEET화면을 제외한 나머지 모든 SCRIPT를 공유하므로 JavaScript
 * 이하 모든 Script를 동일하게 복사해서 사용한다.
=========================================================*/
/****************************************************************************************
이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
* @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
* @author 한진해운
*/

/**
* @extends Bkg
* @class ESD_TRS_0002 : Booking ??? ?? ???? ???? ?? ????? ????.
*/
function ESD_TRS_0002() {
  this.processButtonClick     = processButtonClick;
  this.setSheetObject         = setSheetObject;
  this.setComboObject         = setComboObject;
  this.setTabObject           = setTabObject;
  this.loadPage               = loadPage;
  this.initSheet              = initSheet;        
  this.initControl            = initControl;
  this.initTab                = initTab;
  this.doActionIBSheet        = doActionIBSheet;
  this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'CYDR';

var tabObjects       = new Array();
var tabCnt           = 0 ;
var beforetab        = 1;
var beforetab2       = 1;

var sheetObjects       = new Array();
var sheetCnt         = 0;
var Mincount         = 0;
var docUsrail        = "";
var docUnconfirm     = "";
var docUnplanshuttle = "";

var R = 222;
var G = 251;
var B = 248;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
function processButtonClick() {

	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve": //조회
			if( validateFormSearch(formObject) ) {
				tabObjects[0].SelectedIndex = 0; //tab 이동
					formObject.rad_dateSep[0].disabled = true;
					formObject.rad_dateSep[1].disabled = true;
					formObject.rad_dateSep[2].disabled = true;
					formObject.unplan_shuttle.disabled = true;
					formObject.tro_unconfirm_dr.disabled = true;
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
					sheetObject1.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
					sheetObject2.RemoveAll(); //Combined CNTR Trans. Case2의 쉬트 내용을 제거
					
					// 2014.03.27 Planed 된 경우 Transmode와 Route blocking 처리
					var disabledFg = true ;
					if( formObject.unplan_shuttle.value == ""){
						disabledFg = false ;
					}
					
					for (var i = sheetObject.HeaderRows ; i< sheetObject.RowCount + sheetObject.HeaderRows ; i++) {
						var io_bnd = sheetObject.CellValue(i, "trsp_bnd_cd");
						var cost_mod = sheetObject.CellValue(i, "trsp_cost_dtl_mod_cd");
						
						if (cost_mod == "DOOR"){
							if( io_bnd == "O"){
								sheetObject.CellEditable(i,  "trsp_crr_mod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "via_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "via_nod_yard") = disabledFg;
								sheetObject.CellEditable(i,  "to_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "to_nod_yard") = disabledFg;
								sheetObject.CellEditable(i,  "dor_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "dor_nod_yard") = disabledFg;
											
							}else{
								sheetObject.CellEditable(i,  "trsp_crr_mod_cd") = disabledFg;
								sheetObject.CellEditable(i,  "fm_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "fm_nod_yard") = disabledFg;
							  //sheetObject.CellEditable(i,  "via_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "via_nod_yard") = disabledFg;
								sheetObject.CellEditable(i,  "dor_nod_cd") = disabledFg;
							  //sheetObject.CellEditable(i,  "dor_nod_yard") = disabledFg;
						     }
					
					}else{
						sheetObject.CellEditable(i,  "trsp_crr_mod_cd") = disabledFg;
						sheetObject.CellEditable(i,  "fm_nod_cd") = disabledFg;
						//sheetObject.CellEditable(i,  "fm_nod_yard") = disabledFg;
						//sheetObject.CellEditable(i,  "via_nod_cd") = disabledFg;
						//sheetObject.CellEditable(i,  "via_nod_yard") = disabledFg;
						sheetObject.CellEditable(i,  "to_nod_cd") = disabledFg;
						//sheetObject.CellEditable(i,  "to_nod_yard") = disabledFg;
						sheetObject.CellEditable(i,  "dor_nod_cd") = disabledFg;
						//sheetObject.CellEditable(i,  "dor_nod_yard") = disabledFg;
						
					}
				  }
				}
			break;
			
			case "btn_new": //reset
				tabObjects[0].SelectedIndex = 0; //tab 이동
				formObject.reset();
				formObject.search_fm_yard.RemoveAll(); // combo 데이터삭제
				formObject.search_via_yard.RemoveAll(); // combo 데이터삭제
				formObject.search_to_yard.RemoveAll(); // combo 데이터삭제
				formObject.search_door_yard.RemoveAll(); // combo 데이터삭제
				fun_disabled();
			break;
			
			case "btn_minimize": //Minimize
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			
			case "btng_officetransfer": //Office Transfer 버튼
				if( doOfficeTrans(sheetObject) )
					ComOpenWindow('ESD_TRS_0930Pop.screen', 'ESD_TRS_0930Pop', 'top=200, left=200, width=500, height=180, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			break;
			
			case "btng_multipleapply": //Multiple Apply 동시적용
			    var lv_cost_mode_cd  = null;
				if( doMultipleApply(sheetObject) ) {
				    
              	for( var i=0; i<sheetObject.RowCount; i++ ) {
              		if( sheetObject.CellValue(i+2, "chk1") == "1" ) {
              			lv_cost_mode_cd = sheetObject.CellValue(i+2, "trsp_cost_dtl_mod_cd");
              			break;
              		}
              	}				    
              		document.form.pop_flag.value = 'Y';
					ComOpenWindow('ESD_TRS_0003.do?scrn_id=0004&cost_mode_cd='+lv_cost_mode_cd, 'ESD_TRS_0003', 'top=200, left=200, width=785, height=395, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				}
			break;
			
			case "btns_calendar":
				getCalendar();
			break;
			
			case "btng_downexcel1": //sheet1 엑셀다운로드
				sheetObject.SpeedDown2Excel(true);
			break;
			
			case "btng_downexcel2": //sheet2 엑셀다운로드
				sheetObject1.SpeedDown2Excel(true);
			break;
			
			case "btng_downexcel3": //sheet3 엑셀다운로드
				sheetObject2.SpeedDown2Excel(true);
			break;
			
			case "btng_matchmaking1": //Combined CNTR Trans. Case One
				if(	doDataEquals(sheetObject) ) {
					IBS_Sheet2SheetStatus2(sheetObject, sheetObject1, "chk1");
				}
			break;
			
			case "btng_matchmaking2":  //Matchmaking for Combined Case Two
				if( doCombinedTwo(sheetObject) )
					ComOpenWindow('ESD_TRS_0920.screen', 'ESD_TRS_0920', 'top=200, left=200, width=800, height=485, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			break;
			
			case "btng_socreation1": //sheet1 S/O Creation
				if( validateForm(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, SEARCH17, "");
				}
			break;
			
			case "btng_socreation2":
				if( validateForm(sheetObject1, formObject) ) {
					doActionIBSheet(sheetObject1, formObject, SEARCH17, "");
				}
			break;
			
			case "btng_socreation3":
				if( validateForm(sheetObject2, formObject) ) {
					doActionIBSheet(sheetObject2, formObject, SEARCH17, "");
				}
			break;
			
			case "btng_woissue1": //sheet1 W/O Issue
				doActionIBSheet(sheetObject3, formObject, IBINSERT, "WO");
			break;
			
			case "btng_woissue2": //sheet1 W/O Issue
				doActionIBSheet(sheetObject3, formObject, IBINSERT, "WO");
			break;
			
			case "btng_woissue3": //sheet1 W/O Issue
				doActionIBSheet(sheetObject3, formObject, IBINSERT, "WO");
			break;
			case "btng_separate1": //Combined CNTR Trans. Case One 취소
				IBS_Sheet2SheetStatus3(sheetObject1, sheetObject, "chk1");
			break;
			
			case "btng_separate2": //Combined CNTR Trans. Case Two 취소
				IBS_Sheet2SheetStatus3_1(sheetObject2, sheetObject, "chk1");
			break;
			
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			
			case "btns_vianode": //ViaNode Popup창
				openHireYardPopup('getViaNode');
			break;
			
			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			
			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;
			
			case "btns_tvvd": //Trunk VVD Popup창
				openTVVDPopup("getCOM_ENS_VVD_1");
			break;
			
			case "btns_fvvd": //Feeder VVD Popup창
				openTVVDPopup("getCOM_ENS_VVD_2");
			break;
			
			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;
			
			case "btns_multifvvd": //M Feeder VVD
				openMultipleinquiry('VVD', 'F.VVD');
			break;
			
			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;
			
			case "btns_multibl": //M B/L No
				openMultipleinquiry('BLN', 'B/L No');
			break;
			
			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;
			
			case "btns_office": //M CNTR
				if( validation_check() ) {
					var ofc_cd = formObject.ctrl_so_office.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
				}
			break;
			
			case "btns_multizipcode":
				openMultipleinquiry('ZIP', 'ZIP Code');
			break;

			case "btns_contract":
				openContractNoPopup();
			break;

			case "btng_candidatedelete":
				deleteSOCandidate();
			break;
			
			case "btng_offhireverify":
			  offHireVerify();
			break;
			
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			//errMsg = ComGetMsg("TRS90108");
			//ComShowMessage(errMsg);
		} else {
			//ComShowMessage(e);
		}
	}
}


/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
/**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "   Single Transportation   " , -1 );
				InsertTab( cnt++ , "Combined CNTR Trans. CaseⅠ" , -1 );
				InsertTab( cnt++ , "Combined CNTR Trans. CaseⅡ" , -1 );
			}
		break;
	}
}
	
	
/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}

/**
* IBSheet Object를 배열로 등록
* comSheetObject(id)에서 호출한다
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* Sheet 기본 설정 및 초기화 
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	 
	 for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheetTrs(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}
	for(k=0;k<tabObjects.length;k++) {
		initTab(tabObjects[k],k+1);
	}
	getCostModeCombo(document.sel_costmode);
	IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
	
	//html컨트롤 이벤트초기화
	initControl();

	if(s_cost_act_grp_seq != undefined && s_cost_act_grp_seq != ''){
		var formObj = document.soForm;
		formObj.f_cmd.value = SEARCH;
		sheetObjects[0].DoSearch4Post("ESD_TRS_0002GS.do", TrsFrmQryString(formObj));
	}
}

  /**
* 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
   * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
   * @param {ibsheet} sheetObj    IBSheet Object
   * @param {int}     sheetNo     sheetObjects 배열에서 순번
   **/
  function initControl() {
      axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
      axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
      axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
      axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
      axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
      axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리

      axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
  }


  //Axon ??? ??2. ??????? --- start
  /**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
   **/
  function engnum_keypress() {
      //???? ????
      ComKeyOnlyAlphabet('uppernum');
  }

  /**
   * BKG Creation?? manual? ???? ??? ????. <br>
   **/
  function manual_click() {
      //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
      form.boo_bkg_no.readOnly =!form.manual.checked;
  }

  /**
   * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
   **/
  function bkgno_keyup() {
      //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
      if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
          form.boo_bl_no.value = "";
      else
          form.boo_bl_no.value = form.hdn_boo_bl_no.value;
  }

  /**
   * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
   **/
  function obj_blur(){
      //입력Validation 확인하기
      return ComChkObjValid(event.srcElement);
  }

  /**
   * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
   **/
  function obj_focus(){
      //?????? ???
      ComClearSeparator(event.srcElement);
  }

  /**
   * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
   **/
  function obj_keypress(){
      //???????
      ComKeyOnlyNumber(event.srcElement);
  }
  
  //Axon 이벤트 처리2. 이벤트처리함수 --- end


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function validateFormSearch(formObj) {
	if( sheetObjects[1].RowCount > 0 || sheetObjects[2].RowCount > 0 ) {
		errMsg = ComGetMsg("TRS90130");
		if( confirm(errMsg) ) {
		} else {
			return false;
		}
	}

	var lvfrmDate = doSepRemove(doSepRemove(formObj.frm_plandate.value, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(formObj.to_plandate.value, " "), "-");
	var lvfrm_node = doSepRemove(formObj.search_fm_loc.value, " ");
	var lvvia_node = doSepRemove(formObj.search_via_loc.value, " ");
	var lvto_node = doSepRemove(formObj.search_to_loc.value, " ");
	var lvdor_loc = doSepRemove(formObj.search_door_loc.value, " ");
	var lvtrunk_vvd = doSepRemove(formObj.trunk_vvd.value, " ");
	var lvbkg_no = doSepRemove(formObj.bkg_no.value, " ");
	var lvbill_no = doSepRemove(formObj.bill_no.value, " ");
	var lvcntr_no = doSepRemove(formObj.cntr_no.value, " ");
	var lvcontract_no = formObj.contract_no.value;

	var lvfeeder_vvd = doSepRemove(formObj.txt_feeder_vvd.value, " "); //20070622 정원근 수석요청
	var prm_office = doSepRemove(formObj.ctrl_so_office.value.toUpperCase(), " "); //input text
	var lvzip_code = doSepRemove(formObj.zip_code.value, " ");

	if( prm_office == "" ) {
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	} else {
		formObj.ctrl_so_office.value = prm_office;
	}

	if( lvfrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvtoDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvtrunk_vvd == "" ) //T.VVD
		formObj.trunk_vvd.value = "";
	if( lvbkg_no == "" ) //BKG No
		formObj.bkg_no.value = "";
	if( lvbill_no == "" ) //B/L No
		formObj.bill_no.value = "";
	if( lvcntr_no == "" ) //CNTR No
		formObj.cntr_no.value = "";
	if( lvfeeder_vvd == "" ) //F.VVD
		formObj.txt_feeder_vvd.value = "";
	if( lvzip_code == "" ) //Zip Code
		formObj.zip_code.value = "";

	if( lvfrmDate == "" && lvtoDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvfrmDate != "" && lvtoDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvfrmDate != "" && lvtoDate != "" ) { //날짜 체크하는 부분
		if( !doDatecheck(lvfrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !doDatecheck(lvtoDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_plandate.focus();
			return false;
		}
		if( dateCalcuration(lvfrmDate, lvtoDate) > 15 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( dateCalcuration(lvfrmDate, lvtoDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvtrunk_vvd == "" && lvbkg_no == "" && lvbill_no == "" && lvcntr_no == "" && lvcontract_no == "") {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}

	/* UNPLANNED SHUTTLE S/O */
	/* Mandatory   : TRUNK VVD or BKG# or B/L# or CNTR#    */
	if( document.form.unplan_shuttle.checked ) {
		if( lvfrm_node == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		} else {
			if( lvtrunk_vvd == "" && lvbkg_no == "" && lvbill_no == "" && lvcntr_no == "" && lvcontract_no == "") {
				errMsg = ComGetMsg("TRS90124");
				ComShowMessage(errMsg);
				return false;
			}
		}
	}
	if( lvfrm_node == "" ) { //From Node
		formObj.search_fm_loc.value = "";
		formObj.search_fm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvvia_node == "" ) { //Via Node
		formObj.search_via_loc.value = "";
		formObj.search_via_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvto_node == "" ) { //To Node
		formObj.search_to_loc.value = "";
		formObj.search_to_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvdor_loc == "" ) { //Door Node
		formObj.search_door_loc.value = "";
		formObj.search_door_yard.RemoveAll(); // combo 데이터삭제
	}

	if( !doengnumcheck(lvtrunk_vvd) ) {
		formObj.trunk_vvd.value = "";
		formObj.trunk_vvd.focus();
		return false;
	}
	if( !doengnumcheck(lvbkg_no) ) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	if( !doengnumcheck(lvbill_no) ) {
		formObj.bill_no.value = "";
		formObj.bill_no.focus();
		return false;
	}
	if( !doengnumcheck(lvcntr_no) ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value = lvfrmDate; //from Date
	formObj.hid_todate.value = lvtoDate; //to Date

	formObj.search_fm_loc.value = lvfrm_node.toUpperCase();
	formObj.search_via_loc.value = lvvia_node.toUpperCase();
	formObj.search_to_loc.value = lvto_node.toUpperCase();
	formObj.search_door_loc.value = lvdor_loc.toUpperCase();

	formObj.trunk_vvd.value = lvtrunk_vvd.toUpperCase(); //T.VVD
	formObj.bkg_no.value = lvbkg_no.toUpperCase(); //BKG No.
	formObj.bill_no.value = lvbill_no.toUpperCase(); //B/L No
	formObj.cntr_no.value = lvcntr_no.toUpperCase(); //CNTR No

	// Unplanned Shuttle
	if( formObj.unplan_shuttle.checked ) {
	    //UNPLANNED SHUTTLE INDICATOR SET
		formObj.unplan_shuttle.value = "US";   //Unplanned Shuttle S/O
	} else {
		formObj.unplan_shuttle.value = "";
	}
	// Incl. TRO Unconfirmed Door
	if( formObj.tro_unconfirm_dr.checked ) {
	    //TRO UNCONFIRMED DOOR SET
		formObj.tro_unconfirm_dr.value = "UD";    //Unconfirmed Door S/O
	} else {
		formObj.tro_unconfirm_dr.value = "";
	}

	return true;
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction,sObj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH: //조회
		    fun_ParentOffice();
		    formObj.f_cmd.value = SEARCH;
            //UNPLANNED SHUTTLE INDICATOR
			if( document.form.unplan_shuttle.checked ) {
				docUnplanshuttle = "Y";
			} else {
				docUnplanshuttle = "";
			}
			
			//PROVISION CHECK INDICATOR
			if( document.form.tro_unconfirm_dr.checked ) {
				docUnconfirm = "Y";
			} else {
				docUnconfirm = "";
			}
			
			sheetObj.DoSearch4Post("ESD_TRS_0002GS.do", TrsFrmQryString(formObj));
		break;

		case IBINSERT: //삽입
			if(chkCntrLbsWgt(sheetObj)){	//CNTR_LBS_WGT의 값이 9자리 이상 체크
				if( sObj == "" || sObj == "CF" || sObj == "CS" ) {
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	
					formObj.f_cmd.value = SEARCH20; // 2010 Frame 변경으로 DoSearch4Post를 사용하면서 MULTI를 Response값을 받을 수 없어 SEARCH20로 변경
					formObj.cbstatus.value = sObj;
					var queryStr = sheetObj.GetSaveString(false, true, "chk1");
					sheetObjects[3].DoSearch4Post("ESD_TRS_0002GS.do", queryStr+"&"+TrsFrmQryString(formObj), "", true);
				
					ComOpenWait(false);
					
					var bid_flg = "N";
					for(var i=1; i<=sheetObjects[3].RowCount; i++) {
						if(sheetObjects[3].CellValue(i, 'spot_bid_flg') == "Y"){
							bid_flg = "Y";
						}
					}
					
					if(bid_flg == "Y"){
				    	var myOption = "dialogWidth:550px; dialogHeight:420px; help:no; status:no; resizable:no; scroll=no; ";
//				    	var myOption = "width=550px; height=620px; help:no; status:no; resizable:yes; scroll=no; ";
					    var url = 'ESD_TRS_0940.screen';
					    var myWin = window.showModalDialog(url,window, myOption);
//					    var myWin = window.open(url,"", myOption);
					}
				} else if( sObj == "WO" ) {
					if( sheetObj.RowCount < 1 ) {
						errMsg = ComGetMsg("TRS90110");
						ComShowMessage(errMsg);
						return false;
					}
					if( sheetObjects[1].RowCount > 0 || sheetObjects[2].RowCount > 0 ) {
						errMsg = ComGetMsg("TRS90130");
						if( confirm(errMsg) ) {
						} else {
							return false;
						}
					}
					var cty_cd = "";
					var seq_no = "";
					for(var i=1; i<sheetObj.RowCount+1; i++) {
						if( i == sheetObj.RowCount ) {
							cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
							seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
						} else {
							cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd') + ",";
							seq_no += sheetObj.CellValue(i, 'trsp_so_seq') + ",";					
						}
					}
					document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
					document.woForm.trsp_so_seq.value = seq_no;
					document.woForm.eq_mode.value = "CG";
					document.woForm.pgmNo.value = "ESD_TRS_0023";
					document.woForm.action = "ESD_TRS_0023.screen";
					document.woForm.submit();
				}
			}
		break;
		case SEARCH17:
			if(!validSpot()){
				return;				
			}
			var queryStr = sheetObj.GetSaveString(false, true, "chk1");
			formObj.f_cmd.value = SEARCH17;
			sheetObj.DoSearch4Post("ESD_TRS_0002GS.do", queryStr+"&"+TrsFrmQryString(formObj), "", true);
		break;			
	}
}

//Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			tabObjects[0].SelectedIndex = 0; //tab 이동
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
			sheetObject1.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
			sheetObject2.RemoveAll(); //Combined CNTR Trans. Case2의 쉬트 내용을 제거
		}
	}
}

/**
 * Spot Bidding Validation check
 * 2015.08.20 by SHIN DONG IL
 */
function validSpot(){
	var sheetObj  = sheetObjects[0];   //t1sheet1
	var formObj = document.form;
	var rtn_flg = true;
	//지역별 현재일자 조회.
   	
	getLocalTime(sheetObj,formObj,formObj.FORM_USR_OFC_CD.value);
    var locl_dt_tm = sheetObj.EtcData('locl_dt_tm');
    sheetObj.RemoveEtcData();
    var locl_dt = locl_dt_tm.substr(0,8);
    var add_d14_locl_dt =  ComGetDateAdd(locl_dt, "D", 14, "")
    var trans_mode ="";
    var fm_nod_cd ="";
    var via_nod_cd ="";
    var dor_nod_cd ="";
    var to_nod_cd ="";
    var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	
	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
		if(rtn_flg){
			fromRow = arrRow[i];
			if(sheetObj.CellValue(fromRow,"spot_bid_flg")=="1"){
				if(trans_mode == ""){
					trans_mode = sheetObj.CellValue(fromRow,"trsp_crr_mod_cd");					
				}
				
				if(fm_nod_cd == "" && via_nod_cd == "" && dor_nod_cd == "" && to_nod_cd == ""){
				    fm_nod_cd  =sheetObj.CellValue(fromRow,"fm_nod_cd");			
				    via_nod_cd =sheetObj.CellValue(fromRow,"via_nod_cd");			
				    dor_nod_cd =sheetObj.CellValue(fromRow,"dor_nod_cd");			
				    to_nod_cd =sheetObj.CellValue(fromRow,"to_nod_cd");			
				}
				
				if(sheetObj.CellValue(fromRow,"spot_bid_due_dt")== ""){
					errMsg = ComGetMsg("TRS90701");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(sheetObj.CellValue(fromRow,"spot_bid_due_dt_hms") == ""){
					errMsg = ComGetMsg("TRS90701");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(locl_dt_tm > (sheetObj.CellValue(fromRow,"spot_bid_due_dt")+" "+sheetObj.CellValue(fromRow,"spot_bid_due_dt_hms"))){
					errMsg = ComGetMsg("TRS90388","Bid due date");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(ComGetDaysBetween(add_d14_locl_dt,sheetObj.CellValue(fromRow,"spot_bid_due_dt")) > 0){
					errMsg = ComGetMsg("TRS90388","Bid due date");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(trans_mode != sheetObj.CellValue(fromRow,"trsp_crr_mod_cd")){
					errMsg = ComGetMsg("TRS90702","(Spot Bidding)Trans mode");
					ComShowMessage(errMsg);
					rtn_flg = false;	
				}else if(fm_nod_cd  !=sheetObj.CellValue(fromRow,"fm_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(From)");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(via_nod_cd  !=sheetObj.CellValue(fromRow,"via_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(Via)");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(dor_nod_cd  !=sheetObj.CellValue(fromRow,"dor_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(Door)");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(to_nod_cd  !=sheetObj.CellValue(fromRow,"to_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(To)");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else{
					rtn_flg = true;
				}
			}
		}
	}
    return rtn_flg; 
}

//tab1의 sheet에 대한 정보
function t1sheet1_OnClick(sheetObj, row , col , value) {
	if( sheetObj.ReadDataProperty(row, col, dpDataType) == 6 ) {
		// 2014.03.27 unplan 인 경우에만 처리 되도록 함
//	  if( document.form.unplan_shuttle.value == "US"){	
		if( sheetObj.ColSaveName(col) == "fm_nod_yard" ) {
			value = doSepRemove(sheetObj.CellValue(row, "fm_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value = "";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "fm_nod_cd") = "";
			}
		} else if( sheetObj.ColSaveName(col) == "to_nod_yard" ) {
			value = doSepRemove(sheetObj.CellValue(row, "to_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value = "A";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			}
		} else if (sheetObj.ColSaveName(col) == "via_nod_yard" ) {
			value = doSepRemove(sheetObj.CellValue(row, "via_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value = "";
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "via_nod_cd") = "";
			}
		} else if( sheetObj.ColSaveName(col) == "dor_nod_yard" ) {
			value = doSepRemove(sheetObj.CellValue(row, "dor_nod_cd"), " ");
			document.form.TRSP_SO_EQ_KIND.value = "";
			if( value.length > 0 ) {
				getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "dor_nod_cd") = "";
			}
		}
//	  }else{
//		  var cost_mod =  sheetObj.CellValue(row, "trsp_cost_dtl_mod_cd");
//		  var bnd_cd =  sheetObj.CellValue(row, "trsp_bnd_cd");
//		  if (cost_mod == "DOOR" ) {
//			  if( bnd_cd == "O" && sheetObj.ColSaveName(col) == "fm_nod_yard" ) {
//					value = doSepRemove(sheetObj.CellValue(row, "fm_nod_cd"), " ");
//					document.form.TRSP_SO_EQ_KIND.value = "";
//					if( value.length > 0 ) {
//						getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
//					} else {
//						sheetObj.CellValue2(row, "fm_nod_cd") = "";
//					}
//			}else if( bnd_cd == "I" && sheetObj.ColSaveName(col) == "to_nod_yard" ) {
//				value = doSepRemove(sheetObj.CellValue(row, "to_nod_cd"), " ");
//				document.form.TRSP_SO_EQ_KIND.value = "A";
//				if( value.length > 0 ) {
//					getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
//				} else {
//					sheetObj.CellValue2(row, "to_nod_cd") = "";
//				}
//			}
//		  }
//	  }		
	}
	
	var colName = sheetObj.ColSaveName(col);
	
	switch(colName){
		case 'chk1':
			if( sheetObj.CellValue(row, 'trsp_bnd_cd') == 'I' &&
					sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') == 'DOOR' &&
					sheetObj.CellValue(row, 'bkg_bdr_flg') != 'Y'){
					ComShowCodeMessage('TRS90369');
				  }
			break;
		case 'pre_pull_chk': //20121030
			var v_pre_chk = sheetObj.CellValue(row,"pre_pull_chk");
			var v_fm_nod = doSepRemove(sheetObj.CellValue(row, "fm_nod_cd"), " ");
			var v_to_nod = doSepRemove(sheetObj.CellValue(row, "to_nod_cd"), " ");
			var v_trsp_cost_dtl_mod_cd = doSepRemove(sheetObj.CellValue(row, "trsp_cost_dtl_mod_cd"), " ");

			if( v_pre_chk == 0 ) {
				if( v_trsp_cost_dtl_mod_cd == "CY" ) {
					sheetObj.CellValue2(row,"pre_pull_flg") = "Y";
				} else {
					sheetObj.CellValue2(row,"pre_pull_chk") = "1";
					sheetObj.CellValue2(row,"pre_pull_flg") = "N";
					ComShowCodeMessage('TRS90502');
				}
			} else {
				sheetObj.CellValue2(row,"pre_pull_flg") = "N";
			}
			break;
	}
}

function t1sheet1_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "I";
		} else {
			sheetObj.RowStatus(row) = "R";
		}
	} else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd").toUpperCase(), " ");
		sheetObj.CellValue2(row, "fm_nod_cd") = lvfm;
		document.form.TRSP_SO_EQ_KIND.value = "";
		if( doengnumcheck(lvfm) ) {
			if( lvfm.length == 5 ) {
//				getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
				if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
					getBkgVvd(sheetObj, document.form, row);
				} else {
					sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
					sheetObj.CellValue2(row, "fm_nod_yard") = "";					
				}
			} else {
				if( lvfm.length == 0 ) {
					sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
					sheetObj.CellValue2(row, "fm_nod_yard") = "";
				} else {
					errMsg = ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.CellValue2(row,"fm_nod_cd") = "";
					sheetObj.SelectCell(row,"fm_nod_cd");
					sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
					sheetObj.CellValue2(row, "fm_nod_yard") = "";
				}
			}
		} else {
			sheetObj.CellValue2(row,"fm_nod_cd") = "";
			sheetObj.SelectCell(row,"fm_nod_cd");
			sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
			sheetObj.CellValue2(row, "fm_nod_yard") = "";
		}
		
	} else if( sheetObj.ColSaveName(col) == "via_nod_cd" ) {
		var lvvia = doSepRemove(sheetObj.CellValue(row,"via_nod_cd").toUpperCase(), " ");
		sheetObj.CellValue(row,"via_nod_cd") = lvvia;
		document.form.TRSP_SO_EQ_KIND.value = "";
		if( doengnumcheck(lvvia) ) {
			if( lvvia.length == 5 ) {
//				getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yard", lvvia); //Varidation check
				if( sheetObj.CellValue(row, "via_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "via_nod_yard", lvvia);
				} else {
					sheetObj.CellComboItem(row, "via_nod_yard", "", "");
					sheetObj.CellValue2(row, "via_nod_yard") = "";
				}
			} else {
				if( lvvia.length == 0 ) {
					sheetObj.CellComboItem(row, "via_nod_yard", "", "");
					sheetObj.CellValue2(row, "via_nod_yard") = "";
				} else {
					errMsg = ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.CellValue2(row,"via_nod_cd") = "";
					sheetObj.SelectCell(row,"via_nod_cd");
					sheetObj.CellComboItem(row, "via_nod_yard", "", "");
					sheetObj.CellValue2(row, "via_nod_yard") = "";
				}
			}
		} else {
			sheetObj.CellValue2(row,"via_nod_cd") = "";
			sheetObj.SelectCell(row,"via_nod_cd");
			sheetObj.CellComboItem(row, "via_nod_yard", "", "");
			sheetObj.CellValue2(row, "via_nod_yard") = "";
		}
		
	} else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
		var lvto = doSepRemove(sheetObj.CellValue(row,"to_nod_cd").toUpperCase(), " ");
		sheetObj.CellValue(row,"to_nod_cd") = lvto;
		document.form.TRSP_SO_EQ_KIND.value = "A";
		if( doengnumcheck(lvto) ) {
			if( lvto.length == 5 ) {
//				getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Varidation check
				if( sheetObj.CellValue(row, "to_nod_cd") != "" ) {
					getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
					getBkgVvd(sheetObj, document.form, row);
				} else {
					sheetObj.CellComboItem(row, "to_nod_yard", "", "");
					sheetObj.CellValue2(row, "to_nod_yard") = "";
				}
			} else {
				if( lvto.length == 0 ) {
					sheetObj.CellComboItem(row, "to_nod_yard", "", "");
					sheetObj.CellValue2(row, "to_nod_yard") = "";
				} else {
					errMsg = ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.CellValue2(row,"to_nod_cd") = "";
					sheetObj.SelectCell(row,"to_nod_cd");
					sheetObj.CellComboItem(row, "to_nod_yard", "", "");
					sheetObj.CellValue2(row, "to_nod_yard") = "";
				}
			}
		} else {
			sheetObj.CellValue2(row,"to_nod_cd") = "";
			sheetObj.SelectCell(row,"to_nod_yard");
			sheetObj.CellComboItem(row, "to_nod_yard", "", "");
			sheetObj.CellValue2(row, "to_nod_yard") = "";
		}
		
	} else if( sheetObj.ColSaveName(col) == "dor_nod_cd" ) {
	    
 		/* Actual Customer Automatic Apply  : DOOR + USA/ASIA + NONE-TRO  */
		//applyActualCustomerCauseFromDoorInfoChange(sheetObj, row, 'location');

		var lvdor = doSepRemove(sheetObj.CellValue(row,"dor_nod_cd").toUpperCase(), " ");
		sheetObj.CellValue(row,"dor_nod_cd") = lvdor;
		document.form.TRSP_SO_EQ_KIND.value = "";
		if( doengnumcheck(lvdor) ) {
			if( lvdor.length == 5 ) {
				getZoneSheetCombo1(sheetObj, document.form, row, col, "dor_nod_yard", lvdor);
				if( sheetObj.CellValue(row, "dor_nod_cd") != "" ) {
					getZoneSheetCombo(sheetObj, document.form, row, "dor_nod_yard", lvdor);
				} else {
					sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
					sheetObj.CellValue2(row, "dor_nod_yard") = "";
				}
			} else {
				if( lvdor.length == 0 ) {
					sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
					sheetObj.CellValue2(row, "dor_nod_yard") = "";
				} else {
					errMsg = ComGetMsg("TRS90122");
					ComShowMessage(errMsg);
					sheetObj.CellValue2(row,"dor_nod_cd") = "";
					sheetObj.SelectCell(row,"dor_nod_cd");
					sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
					sheetObj.CellValue2(row, "dor_nod_yard") = "";
				}
			}
		} else {
			sheetObj.CellValue2(row,"dor_nod_cd") = "";
			sheetObj.SelectCell(row,"dor_nod_cd");
			sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
			sheetObj.CellValue2(row, "dor_nod_yard") = "";
		}
		
		/* Actual Customer Automatic Apply  : DOOR + USA/ASIA + NONE-TRO  */
		applyActualCustomerCauseFromDoorInfoChange(sheetObj, row, 'location', 'dor_loc_change');
		
    } else if( sheetObj.ColSaveName(col) == "dor_nod_yard" ) {
      /* Actual Customer Automatic Apply  : DOOR + USA/ASIA + NONE-TRO  */
      applyActualCustomerCauseFromDoorInfoChange(sheetObj, row, 'zone', 'dor_zn_change');
      
      /*Door Yard변경시 Yard Name 조회*/
      var formObj = document.form;
	  formObj.f_cmd.value = SEARCH23;
	  var doorLoc = sheetObj.CellValue(row,"dor_nod_cd");
	  var doorYard = sheetObj.CellValue(row,"dor_nod_yard");
	  var queryStr ="f_cmd="+SEARCH23+"&search_door_loc="+doorLoc+"&search_door_yard="+doorYard;
	  var sXml = sheetObj.GetSearchXml("ESD_TRS_0002GS.do", queryStr);
	  var dorYdNm = ComGetEtcData(sXml, "dorYdNm");
	  if(dorYdNm==""){
		  sheetObj.CellValue2(row, "dor_nod_yard_nm") = " " ;
	  }else{
		  sheetObj.CellValue2(row, "dor_nod_yard_nm") = dorYdNm ;		 
	  }
	} else if( sheetObj.ColSaveName(col) == "trsp_crr_mod_cd" ) {
	    
		var lvCrrmodcd = sheetObj.CellValue(row, "trsp_crr_mod_cd"); //TW, WT
		if( lvCrrmodcd.indexOf("D") < 0 ) {
			sheetObj.CellEditable(row, "via_nod_cd") = true;
			sheetObj.CellEditable(row, "via_nod_yard") = true;
		} else {
			sheetObj.CellEditable(row, "via_nod_cd") = false;
			sheetObj.CellEditable(row, "via_nod_yard") = false;
			sheetObj.CellValue2(row, "via_nod_cd") = "";
			sheetObj.CellValue2(row, "via_nod_yard") = "";
			sheetObj.CellComboItem(row, "via_nod_yard", "", "");
		}
	} else if(  sheetObj.ColSaveName(col) == "cntr_kgs_wgt" ) {
		sheetObj.CellValue2(row, "cntr_lbs_wgt") = value * 2.204;
	} else if(  sheetObj.ColSaveName(col) == "cntr_lbs_wgt" ) {
		sheetObj.CellValue2(row, "cntr_kgs_wgt") = value / 2.204;
	} else if (sheetObj.ColSaveName(col) == "spot_bid_flg" ){
		var spot_bid_flg = sheetObj.CellValue(row, "spot_bid_flg"); //Spot Bid Flag
		if(spot_bid_flg == "1"){
			sheetObj.CellEditable(row, "spot_bid_due_dt") = true;
			sheetObj.CellEditable(row, "spot_bid_due_dt_hms") = true;
		}else{
			sheetObj.CellEditable(row, "spot_bid_due_dt") = false;
			sheetObj.CellEditable(row, "spot_bid_due_dt_hms") = false;
			sheetObj.CellValue(row, "spot_bid_due_dt") = "";
			sheetObj.CellValue(row, "spot_bid_due_dt_hms") = "";
		}	
	}
	
	if ( sheetObj.ColSaveName(col) == "fm_nod_yard" || sheetObj.ColSaveName(col) == "fm_nod_cd" || 
		 sheetObj.ColSaveName(col) == "via_nod_yard" || sheetObj.ColSaveName(col) == "via_nod_cd" || 
		 sheetObj.ColSaveName(col) == "to_nod_yard" || sheetObj.ColSaveName(col) == "to_nod_cd" ) {
		// 조회되었던 값을 확인하고 현재 값과 비교하여 달라진 값이 있으면 중복 체크 함수를 호출한다.
		var OrgValue =  sheetObj.CellSearchValue(row,"fm_nod_cd")+sheetObj.CellSearchValue(row,"fm_nod_yard")
					   +sheetObj.CellSearchValue(row,"via_nod_cd")+sheetObj.CellSearchValue(row,"via_nod_yard")
					   +sheetObj.CellSearchValue(row,"to_nod_cd")+sheetObj.CellSearchValue(row,"to_nod_yard");
		var NowValue =  sheetObj.CellValue(row,"fm_nod_cd")+sheetObj.CellValue(row,"fm_nod_yard")
					   +sheetObj.CellValue(row,"via_nod_cd")+sheetObj.CellValue(row,"via_nod_yard")
					   +sheetObj.CellValue(row,"to_nod_cd")+sheetObj.CellValue(row,"to_nod_yard");
		
		if ( document.form.pop_flag.value == 'N') {
			if (OrgValue != NowValue){
				searchSODupCheck(sheetObj, document.form, row);
			}
			document.form.msg_flag.value = "N";
		}
	}
}

//Actual Customer Info Change cause from Door Location/Zone Modification.
/* Actual Customer Automatic Apply  : DOOR + USA/ASIA + TRO Not Exist  */
function applyActualCustomerCauseFromDoorInfoChange(sheetObj, row, node, eventIndicator)
{
  /* TRO Un-Confirm 일때만 실행함. */
  //if(tro_cfm_flag != "Y")       return; -- 불필요.
  
  var doorNodeCode            = sheetObj.CellValue(row, "dor_nod_cd")  + sheetObj.CellValue(row, "dor_nod_yard");
  var contiCode               = sheetObj.CellValue(row, "fm_loc_conti_cd");   
  var troSeq                  = sheetObj.CellValue(row, "tro_seq");   
  
  var orgDoorNodeCode         = sheetObj.CellValue(row, "dor_nod_cd2") + sheetObj.CellValue(row, "dor_nod_yard2"); 

  var formObj                 = document.form;
  var sheetObjParent          = sheetObjects[0];
  var sheetObjActCust         = sheetObjects[4];

  formObj.FM_LOC_CONTI_CD.value   = sheetObj.CellValue(row, "fm_loc_conti_cd"    );
  formObj.BOUND_CD.value		    = sheetObj.CellValue(row, "trsp_bnd_cd"        );
  formObj.CNEE_CUST_CNT_CD.value	= sheetObj.CellValue(row, "cnee_cust_cnt_cd"   );
  formObj.CNEE_CUST_SEQ.value		= sheetObj.CellValue(row, "cnee_cust_seq"      );
  formObj.SHPR_CUST_CNT_CD.value	= sheetObj.CellValue(row, "shpr_cust_cnt_cd"   );
  formObj.SHPR_CUST_SEQ.value		= sheetObj.CellValue(row, "shpr_cust_seq"      );
  formObj.DOOR_NOD_CD.value	    = sheetObj.CellValue(row, "dor_nod_cd"         ) + sheetObj.CellValue(row, "dor_nod_yard");    

  formObj.f_cmd.value         = SEARCH19;
  var queryStr = sheetObj.GetSaveString(false, false, "ibflag");

  sheetObjects[4].DoSearch4Post("ESD_TRS_0002GS.do", queryStr+'&'+TrsFrmQryString(formObj), '', false);

//  if (sheetObjActCust.RowCount > 0) {
	    sheetObjParent.CellValue(row, "act_cust_cd"      )	= sheetObjActCust.CellValue(1, "act_cust_cnt_cd"		) + sheetObjActCust.CellValue(1, "act_cust_seq"			);
	    sheetObjParent.CellValue(row, "act_cust_cnt_cd"  )	= sheetObjActCust.CellValue(1, "act_cust_cnt_cd"		);
	    sheetObjParent.CellValue(row, "act_cust_seq"     )	= sheetObjActCust.CellValue(1, "act_cust_seq"			);        
	    sheetObjParent.CellValue(row, "act_cust_addr_seq")	= sheetObjActCust.CellValue(1, "act_cust_addr_seq"		);
	    sheetObjParent.CellValue(row, "dor_pst_cd"       )	= sheetObjActCust.CellValue(1, "act_cust_fctry_pst_cd"	);
	    sheetObjParent.CellValue(row, "fctry_nm"         )	= sheetObjActCust.CellValue(1, "act_cust_fctry_nm"		);
	    sheetObjParent.CellValue(row, "dor_de_addr"      )	= sheetObjActCust.CellValue(1, "act_cust_fctry_addr"	);
	    sheetObjParent.CellValue(row, "cntc_pson_phn_no" )	= sheetObjActCust.CellValue(1, "act_cust_fctry_phn_no"	);
	    sheetObjParent.CellValue(row, "cntc_pson_fax_no" )	= sheetObjActCust.CellValue(1, "act_cust_fctry_fax_no"	);
	    sheetObjParent.CellValue(row, "cntc_pson_nm"     )	= sheetObjActCust.CellValue(1, "act_cust_fctry_pic_no"	);
//  }
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.ctrl_so_office.value = obj;
}

//일자에 더하기를 한다.
function getDateBetween(obj) {
	if(obj.value.length >= 8) {
	    document.form.to_plandate.value = ComGetDateAdd(obj.value,"D", 15, "-");
	}else{
		document.form.to_plandate.value = "";
	}
}

function t2sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk = sheetObj.CellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.RowStatus(row) = "I";
			for( var i=2; i<(sheetObj.RowCount+2); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.RowStatus(i) = "I";
					sheetObj.CellValue2(i, "chk1") = "1";
				}
			}
		} else {
			sheetObj.RowStatus(row) = "R";
			for( var i=2; i<(sheetObj.RowCount+2); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.RowStatus(i) = "R";
					sheetObj.CellValue2(i, "chk1") = "0";
				}
			}
		}
	}
}

function t3sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk = sheetObj.CellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.RowStatus(row) = "I";
			for( var i=2; i<(sheetObj.RowCount+2); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.RowStatus(i) = "I";
					sheetObj.CellValue2(i, "chk1") = "1";
				}
			}
		} else {
			sheetObj.RowStatus(row) = "R";
			for( var i=2; i<(sheetObj.RowCount+2); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.RowStatus(i) = "R";
					sheetObj.CellValue2(i, "chk1") = "0";
				}
			}
		}
	}
}

/**
* IBTab Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj) {
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
		fromRow = arrRow[i];
		var trsp_dtl_mod = sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_sep");
		var doc_cfm_ind = sheetObj.CellValue(fromRow, "proc_cfm_ind_cd");
		var lvCrrmodcd = sheetObj.CellValue(fromRow, "trsp_crr_mod_cd");
		//지연대리 요청 20070510 수정
		if( docUsrail == "Y" && lvCrrmodcd.indexOf("R") > -1 ) { //lvCrrmodcd == "RD"
			errMsg = ComGetMsg("TRS90223");
			ComShowMessage(errMsg);
			return false;
		}
		var lv_frm_node = doSepRemove(sheetObj.CellValue(fromRow, "fm_nod_cd"), " ");
		var lv_to_node = doSepRemove(sheetObj.CellValue(fromRow, "to_nod_cd"), " ");
		var lv_via_node = doSepRemove(sheetObj.CellValue(fromRow, "via_nod_cd"), " ");
		var lvfmnod = lv_frm_node+doSepRemove(sheetObj.CellValue(fromRow, "fm_nod_yard"), " ");
		var lvvinod = lv_via_node+doSepRemove(sheetObj.CellValue(fromRow, "via_nod_yard"), " ");
		var lvtonod = lv_to_node+doSepRemove(sheetObj.CellValue(fromRow, "to_nod_yard"), " ");
		var lvdrnod = doSepRemove(sheetObj.CellValue(fromRow, "dor_nod_cd"), " ")+doSepRemove(sheetObj.CellValue(fromRow, "dor_nod_yard"), " ");
		var lvoutints = sheetObj.CellValue(fromRow, "trsp_bnd_cd"); //IN, OUT, T/S
		var lvcostmod = sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd"); //CY, DOOR
		var lvcgo_tp_cd = sheetObj.CellValue(fromRow, "cgo_tp_cd"); //CGO_TP_CD Empty, Full구분
		var lveq_no = doSepRemove(sheetObj.CellValue(fromRow, "eq_no"), " "); //20070626 지연대리요청(TRO --> PROVISION변경)
		var lvconti_cd = doSepRemove(sheetObj.CellValue(fromRow, "pod_conti_cd"), " "); //20070702 정원근 수석 요청
		var lv_fm_loc_conti_cd = doSepRemove(sheetObj.CellValue(fromRow, "fm_loc_conti_cd"), " "); //2007.12.27 jsk

		//지연대리 요청 20070510 다시 추가
		if( lvCrrmodcd.indexOf("D") > -1 ) {
			if( lvvinod != "" ) {
				errMsg = ComGetMsg("TRS90085");
				ComShowMessage(errMsg);
				return false;
			}
		} else {
			if( lvvinod == "" ) {
				errMsg = ComGetMsg("TRS90104");
				ComShowMessage(errMsg);
				return false;
			}
		}

		//지연대리 요청 20070510
		if( (lv_frm_node.substring(0, 2) == "US") || (lv_to_node.substring(0, 2) == "CA") ) {
			if( lvCrrmodcd.indexOf("R") > -1 ) {
				errMsg = ComGetMsg("TRS90223");
				ComShowMessage(errMsg);
				return false;
			}
		}

		/**
		 * docUnconfirm : 'PROVISION' 일경우 'Y' 아니면 'N'
		 */
		 
		/* 'Door' Term Only */
		if( lvcostmod == "DOOR" ) {
		    
		    /* 'PROVISION' */
			
		    /* checked ... 'PROVISION' */
		    /** 
		     * <<TRO CONFIRM>>
		     * 'OUT BOUND'
		     * 미주+OutBound
		     * 구주 
		     * -----------------
		     * <<TRO Unconfirm>>
		     * 'OUT BOUND'
		     * 미주+InBound
		     * 아주 
		     */
		     
		     /**   <<INBOUND DOOR>>
		      *    Container No Must Exist for ALL CONTINENTAL 
		      *    adding TRO must confirm for Exrope
		      */
		     
		    /**  docUnconfirm <== PROVISION CHECK INDICATOR ['PROVISION' 일경우 'Y' 아니면 'N']
		     *   doc_cfm_ind  <== proc_cfm_ind_cd           ['C' : TRO Confirm]
		     */
			if( docUnconfirm == 'Y' ) {
				if( !(lv_fm_loc_conti_cd == 'M' && lvoutints == 'I') && lv_fm_loc_conti_cd != 'A' ) {
					if( doc_cfm_ind != 'C' ) {
						errMsg = ComGetMsg("TRS90302");
						ComShowMessage(errMsg);
						return false;
					}
				}
				//2008-01-22 jsk
				if( lvoutints == 'I' && (lveq_no == '' || lveq_no == null) ) {
				    if(lv_fm_loc_conti_cd == 'E' && doc_cfm_ind != 'C' ) {
				    	errMsg = ComGetMsg("TRS90302");    //Trans S/O cannot be created for ones that TRO have not been confirmed.
						ComShowMessage(errMsg);
						return false;
				    }else{
						errMsg = ComGetMsg("TRS90389");     //There is no container no.
						ComShowMessage(errMsg);
						return false;
				    }
				}	

		    /* None-Provision */
			} else {
				if( !(lv_fm_loc_conti_cd == 'M' && lvoutints == 'I') && lv_fm_loc_conti_cd != 'A' ) {
					if( doc_cfm_ind != 'C' ) {
						errMsg = ComGetMsg("TRS90302");
						ComShowMessage(errMsg);
						return false;
					}
				}
				//2008-01-22 jsk
				if( lvoutints == 'I' && (lveq_no == '' || lveq_no == null) ) {
				    if(lv_fm_loc_conti_cd == 'E' && doc_cfm_ind != 'C' ) {
				    	errMsg = ComGetMsg("TRS90302");    //Trans S/O cannot be created for ones that TRO have not been confirmed.
						ComShowMessage(errMsg);
						return false;
				    }else{
				    	errMsg = ComGetMsg("TRS90389");     //There is no container no.
						ComShowMessage(errMsg);
						return false;
				    }
				}				
			}	

	    /* 'CY' + etc Term Only except 'DOOR' Term */
		} else {
			if( lveq_no == "" ) { //20070626
				errMsg = ComGetMsg("TRS90344");
				ComShowMessage(errMsg);
				return false;
			}
		}

		if( docUnplanshuttle == "Y" ) {
			if( sheetObj.CellValue(fromRow, "trsp_crr_mod_cd") == "" ) {
				errMsg = ComGetMsg("TRS90212");
				ComShowMessage(errMsg);
				return false;
			}
			if( lvfmnod == lvtonod ) {
				errMsg = ComGetMsg("TRS90134");
				ComShowMessage(errMsg);
				return false;
			}

			if( lvfmnod == "" || lvtonod == "" ) {
				errMsg = ComGetMsg("TRS90104");
				ComShowMessage(errMsg);
				return false;
			} else if( lvdrnod != "" ) {
				errMsg = ComGetMsg("TRS90085");
				ComShowMessage(errMsg);
				return false;
			}
		} else {
			if( lvcgo_tp_cd == "M" ) { //Empty일 경우는 하루차이
				if( lvfmnod == lvtonod ) {
					errMsg = ComGetMsg("TRS90134");
					ComShowMessage(errMsg);
					return false;
				}
			} else {
				if( lvoutints == "O" || lvoutints == "I" ) {
					if( lvcostmod == "CY" ) {
						if( lvfmnod.length < 7 || lvtonod.length < 7 ) {
							errMsg = ComGetMsg("TRS90104");
							ComShowMessage(errMsg);
							return false;
						} else if( lvdrnod != "" ) {
							errMsg = ComGetMsg("TRS90085");
							ComShowMessage(errMsg);
							return false;
						} else {
							if( lvfmnod == lvtonod ) {
								errMsg = ComGetMsg("TRS90134");
								ComShowMessage(errMsg);
								return false;
							}
						}
					} else if( lvcostmod == "DOOR" ) {
						if( lvfmnod == "" || lvtonod == "" || lvdrnod == "" ) {
							errMsg = ComGetMsg("TRS90104");
							ComShowMessage(errMsg);
							return false;
						}
					} else {
						return false;
					}
				} else if( lvoutints == "T" ) {
					if( lvcostmod == "CY" ) {
						if( lvfmnod == "" || lvtonod == "" ) {
							errMsg = ComGetMsg("TRS90104");
							ComShowMessage(errMsg);
							return false;
						} else if( lvdrnod != "" ) {
							errMsg = ComGetMsg("TRS90085");
							ComShowMessage(errMsg);
							return false;
						} else {
							if( lvfmnod == lvtonod ) {
								errMsg = ComGetMsg("TRS90134");
								ComShowMessage(errMsg);
								return false;
							}
						}
					} else {
						errMsg = ComGetMsg("TRS90049");
						ComShowMessage(errMsg);
						return false;
					}
				} else {
					errMsg = ComGetMsg("TRS90108");
					ComShowMessage(errMsg);
				}
			}
		}
//2014.03.27 CHECK 제외 //2014.04.28 다시 적용.
		if(changeLocCheck(sheetObj,fromRow)== false){
//			errMsg = ComGetMsg("TRS90500");
		    errMsg = ComGetMsg("TRS90530");
			ComShowMessage(errMsg);
			sheetObj.SelectCell(fromRow, 'cng_rsn_desc');
			return false;
		}
		
//2014.10.20 BKG No Rate Status Code Check(R이면 S/O Creation불가, F,null은 허용)		
		if( sheetObj.CellValue(fromRow, "non_rt_sts_cd") == "R" ) {
			errMsg = ComGetMsg("TRS90620");
			ComShowMessage(errMsg);
			return false;		
		 }
	}
	return true;
}

/*
* 업무에 따른 Validation Check / Combined CNTR Trans. Case One과 Single Transportation의 관계 체크
*/
function doDataEquals(sheetObj) { //데이터를 비교하기 위해서 추가함.
	if( sheetObj.RowCount("I") < 2 ) {
		errMsg = ComGetMsg("TRS90037");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		var lvFmnod = doSepRemove(sheetObj.CellValue(fromRow, "fm_nod_cd")+sheetObj.CellValue(fromRow, "fm_nod_yard"), " ");
		var lvVinod = doSepRemove(sheetObj.CellValue(fromRow, "via_nod_cd")+sheetObj.CellValue(fromRow, "via_nod_yard"), " ");
		var lvTonod = doSepRemove(sheetObj.CellValue(fromRow, "to_nod_cd")+sheetObj.CellValue(fromRow, "to_nod_yard"), " ");
		var lvDrnod = doSepRemove(sheetObj.CellValue(fromRow, "dor_nod_cd")+sheetObj.CellValue(fromRow, "dor_nod_yard"), " ");

		var lvOutInTS  = sheetObj.CellValue(fromRow, "trsp_bnd_cd"); //IN, OUT, T/S
		var lvCostMod  = sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd"); //CY, DOOR
		var lvCrrmodcd = sheetObj.CellValue(fromRow, "trsp_crr_mod_cd"); //TW, WT
		
		if( lvCrrmodcd.indexOf("T") < 0 ) {
			sheetObj.RowStatus(fromRow) = "R"; //false
			sheetObj.CellValue2(fromRow, "chk1") = "0";
			sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
		} else {
			if( sheetObj.CellValue(fromRow, "eq_tpsz_cd").substring(1) == "2" ) {
				if( lvOutInTS == "O" || lvOutInTS == "I" ) {
					if( lvCostMod == "CY" ) {
						if( lvFmnod == lvTonod ) {
							sheetObj.CellValue2(fromRow, "chk1") = "0";
							sheetObj.RowStatus(fromRow) = "R";
							sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
						} else {
							if( lvFmnod == "" || lvTonod == "" || lvDrnod != "" ) {
								sheetObj.CellValue2(fromRow, "chk1") = "0";
								sheetObj.RowStatus(fromRow) = "R";
								sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
							}
						}
					} else if( lvCostMod == "DOOR" ) {
						if( lvFmnod == "" || lvTonod == "" || lvDrnod == "" ) {
							sheetObj.CellValue2(fromRow, "chk1") = "0";
							sheetObj.RowStatus(fromRow) = "R";
							sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
						}
					} else {
						sheetObj.CellValue2(fromRow, "chk1") = "0";
						sheetObj.RowStatus(fromRow) = "R";
						sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
					}
				} else if( lvOutInTS == "T" ) {
					if( lvCostMod == "CY" ) {
						if( lvFmnod == lvTonod ) {
							sheetObj.CellValue2(fromRow, "chk1") = "0";
							sheetObj.RowStatus(fromRow) = "R";
							sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
						} else {
							if( lvFmnod == "" || lvTonod == "" ) {
								sheetObj.CellValue2(fromRow, "chk1") = "0";
								sheetObj.RowStatus(fromRow) = "R";
								sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
							}
						}
					} else {
						sheetObj.CellValue2(fromRow, "chk1") = "0";
						sheetObj.RowStatus(fromRow) = "R";
						sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
					}
				} else {
					sheetObj.CellValue2(fromRow, "chk1") = "0";
					sheetObj.RowStatus(fromRow) = "R";
					sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
				}
			} else {
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				sheetObj.RowStatus(fromRow) = "R";
				sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
			}
		}
	}
	return true;
}

/*
* Combined CNTR Trans. Case Two의 체크
*/
function doOfficeTrans(sheetObj) {
	var fromRow = 0;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/*
* Combined CNTR Trans. Case Two의 체크
*/
function doCombinedTwo(sheetObj) {
	var fromRow = 0;
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var i = 0; i < arrRow.length-1; i++ ) {
			fromRow = arrRow[i];
			if( sheetObj.CellValue(fromRow, "trsp_crr_mod_cd").indexOf("T") < 0 ) {
				errMsg = ComGetMsg("TRS90060");
				ComShowMessage(errMsg);
				return false;
			} else {
				if( sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd") == "DOOR" ) {
					if( sheetObj.CellValue(fromRow, "trsp_bnd_cd") != "I" ) {
						errMsg = ComGetMsg("TRS90012");
						ComShowMessage(errMsg);
						return false;
					}
				}
			}
		}
	}
	return true;
}

/*
* Multiple Apply에 대한 체크
* Multiple Apply Popup 생성
*/
function doMultipleApply(sheetObj) {	
	objInit();
	var objArray = new Array(); //Cost Mode
	var objTrans = new Array(); //Transportation Mode
	var objFrm   = new Array(); //From Node
	var objVia   = new Array(); //Via Node
	var objTo    = new Array(); //To Node
	var objDoor  = new Array(); //Door Location
	var objBnd   = new Array(); //Bound
	
	var lvCostMode  = ""; //Cost Mode
	var lvTransMode = ""; //Transportation Mode
	var lvFrmNode   = ""; //From Node
	var lvViaNode   = ""; //Via Node
	var lvToNode    = ""; //To Node
	var lvDoor      = ""; //Door Location
	var lvBnd       = "";
	var lv_unplan  = document.form.unplan_shuttle.value ;  
	
	var lv_conti_cd     = "";
	//var lv_bound_cd     = "";
	
	var chkTM = true;
	var chkFN = true;
	var chkVN = true;
	var chkTN = true;
	var chkDR = true;
	var chkBND = true;
	var j = 0;
	
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	
	for( var i=0; i<sheetObj.RowCount; i++ ) {
		if( sheetObj.CellValue(i+2, "chk1") == "1" ) {
			objArray[j] = sheetObj.CellValue(i+2, "trsp_cost_dtl_mod_cd");
			objTrans[j] = sheetObj.CellValue(i+2, "trsp_crr_mod_cd");
			objFrm[j]   = sheetObj.CellValue(i+2, "fm_nod_cd2") + "|" + sheetObj.CellValue(i+2, "fm_nod_yard2");
			objVia[j]   = sheetObj.CellValue(i+2, "via_nod_cd2") + "|" + sheetObj.CellValue(i+2, "via_nod_yard2");
			objTo[j]    = sheetObj.CellValue(i+2, "to_nod_cd2") + "|" + sheetObj.CellValue(i+2, "to_nod_yard2");
			objDoor[j]  = sheetObj.CellValue(i+2, "dor_nod_cd2") + "|" + sheetObj.CellValue(i+2, "dor_nod_yard2");
			objBnd[j]   = sheetObj.CellValue(i+2, "trsp_bnd_cd");
			//jsk:20071210
	      lv_conti_cd = sheetObj.CellValue(i+2, "fm_loc_conti_cd");
			//jsk:20071210		
			j++;
		}
	}
	
	/** MULTIPLE APPLY 조건 
	 * 1. COST MODE
	 * 2. BOUND ?
	 */
	for( var i=0; i<objArray.length; i++ ) {
		lvCostMode  = objArray[i]; //CostMode
		lvTransMode = objTrans[i]; //
		lvFrmNode   = objFrm[i]; //From Node
		lvViaNode   = objVia[i]; //Via Node
		lvToNode    = objTo[i]; //To Node
		lvDoor      = objDoor[i]; //Door Location
		lvBnd       = objBnd[i];
		for( var j=0; j<objArray.length; j++ ) {
			if( lvCostMode != objArray[j] ) 
				lvCostMode = "NO"; //CostMode
			if( lvTransMode != objTrans[j] ) 
				chkTM = false; //Transprotation Mode
			if( lvFrmNode != objFrm[j] ) 
				chkFN = false; //From Node
			if( lvViaNode != objVia[j] ) 
				chkVN = false; //Via Node
			if( lvToNode != objTo[j] ) 
				chkTN = false; //To Node
			if( lvDoor != objDoor[j] ) 
				chkDR = false; //Door Location
			if( lvBnd != objBnd [j] ) 
				chkBND = false;
		}
		if( lvCostMode == "NO" ) {
			errMsg = ComGetMsg("TRS90127");
			ComShowMessage(errMsg);
			return false;
			break;
		}
	//  2014.05.13 동일조건일때만 처리 되는 내용 제외			
//		if (!chkTM || !chkFN || !chkVN || !chkTN  || !chkDR  || !chkBND) {
//			errMsg = ComGetMsg("TRS90531");
//			ComShowMessage(errMsg);
//			return false;
//			break;
//		}
	}

	HPut("CM", lvCostMode); //Cost Mode
	
	if( chkTM ) HPut("TM", lvTransMode);
	else HPut("TM", "NULL");
	
	if( chkFN ) HPut("FN", lvFrmNode);
	else HPut("FN", "NULL");
	
	if( chkVN ) HPut("VN", lvViaNode);
	else HPut("VN", "NULL");
	
	if( chkTN ) HPut("TN", lvToNode);
	else HPut("TN", "NULL");
	
	if( chkDR ) HPut("DR", lvDoor);
	else HPut("DR", "NULL");
	
	//jsk:20071210-start
	if( chkDR ) HPut("CONTI_CD", lv_conti_cd);
	else HPut("CONTI_CD", "NULL");
	//jsk:20071210-end
	
	if( chkBND ) HPut("BND", lvBnd);
	else HPut("BND", "NULL");
	
	HPut("US", lv_unplan);
	
	return true;
}

/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(18);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(18);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(18);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(10);
	}
}

//              From Node1/2, 일자,  시간,  Via Node1/2,  To Node1/2, 일자, 시간,      Door Loc1/2, 일자, 시간
function doTimeCheck(of, of2, ov, ov2, ot, ot2, od, od2, fs, fs2, ts, ts2, ds, ds2, fsec, fsec2, tsec, tsec2, dsec, dsec2) {
	var lvFtime    = 10000; //From Departure
	var lvTtime    = 10000; //To Departure
	var standTime  = 7200; //시간차 간격
	var standTime2 = -7200; //시간차 간격
	var lvFdep = dateCalcuration(fs, fs2); //Planned Time(From Departure) : fs2-fs
	var lvTarr = dateCalcuration(ts, ts2); //Planned Time(To Arrival)     : ts2-ts

	if( of == of2 && ov == ov2 && ot == ot2 && od == od2 ) { //Location 정보를 비교
		if( fs!="" && fs2!="" && fsec!="" && fsec2!="" && ts!="" && ts2!="" && tsec!="" && tsec2!="" ) {
			if( lvFdep == -1 ) { //From Departure Time
				lvFtime = eval((Number(fsec.substring(0,2))+24)*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4))) - eval(Number(fsec2.substring(0,2))*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4)));
			} else if( lvFdep == 1 ) {
				lvFtime = eval((Number(fsec2.substring(0,2))+24)*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4))) - eval(Number(fsec.substring(0,2))*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4)));
			} else if( lvFdep == 0 ) { //일자가 동일한 경우
				lvFtime = eval(Number(fsec.substring(0,2))*60*60 + Number(fsec.substring(2,4))*60 + Number(fsec.substring(4))) - eval(Number(fsec2.substring(0,2))*60*60 + Number(fsec2.substring(2,4))*60 + Number(fsec2.substring(4)));
			} else {
				return false;
			}
			if( lvFtime > standTime || lvFtime < standTime2 ) { //From Departrue Planned Time이 2시간 이내가 아닌 경우
				return false;
			}

			if( lvTarr == -1 ) { //To Arrival Time
				lvTtime = eval((Number(tsec.substring(0,2))+24)*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4))) - eval(Number(tsec2.substring(0,2))*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4)));
			} else if( lvTarr == 1 ) {
				lvTtime = eval((Number(tsec2.substring(0,2))+24)*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4))) - eval(Number(tsec.substring(0,2))*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4)));
			} else if( lvTarr == 0 ) { //일자가 동일한 경우
				lvTtime = eval(Number(tsec.substring(0,2))*60*60 + Number(tsec.substring(2,4))*60 + Number(tsec.substring(4))) - eval(Number(tsec2.substring(0,2))*60*60 + Number(tsec2.substring(2,4))*60 + Number(tsec2.substring(4)));
			} else {
				return false;
			}
			if( lvTtime > standTime || lvTtime < standTime2 ) { //To Arrival Planned Time이 2시간 이내가 아닌 경우
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}
	return true;
}

/**
* Combined CNTR Trans. Case One으로 데이터를 이동시키는 함수
*/
function IBS_Sheet2SheetStatus2(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindStatusRow("I");

	var arrRow = sRow.split(";");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting
	var iz = 1 + (toSheet.RowCount/2); //combined
	var cb = ""; //combined 앞자리 수
	var cs = 0; //combined 뒷자리 수
	var lvcolor = "";
	var btime = false;

	if( arrRow.length < 3 ) {
		errMsg = ComGetMsg("TRS90131");
		ComShowMessage(errMsg);
		return false;
	}

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";

	var lvFmnod = "";
	var lvVinod = "";
	var lvTonod = "";
	var lvDrnod = "";
	var n1st = ""; //n1st_nod_pln_dt
	var lst  = ""; //lst_nod_pln_dt
	var dort = ""; //dor_nod_pln_dt
	var n1stsec = ""; //from Departure Time
	var lstsec = ""; //to Arrival Time
	var dortsec = ""; //to dor_nod_pln_dt Time

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (var ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		if( fromSheet.CellValue(fromRow, "ibflag") == "I" ) {
			lvFmnod = doSepRemove(fromSheet.CellValue(fromRow, "fm_nod_cd")+fromSheet.CellValue(fromRow, "fm_nod_yard"), " ");
			lvVinod = doSepRemove(fromSheet.CellValue(fromRow, "via_nod_cd")+fromSheet.CellValue(fromRow, "via_nod_yard"), " ");
			lvTonod = doSepRemove(fromSheet.CellValue(fromRow, "to_nod_cd")+fromSheet.CellValue(fromRow, "to_nod_yard"), " ");
			lvDrnod = doSepRemove(fromSheet.CellValue(fromRow, "dor_nod_cd")+fromSheet.CellValue(fromRow, "dor_nod_yard"), " ");

			n1st    = fromSheet.CellValue(fromRow, "n1st_nod_pln_dt"); //n1st_nod_pln_dt
			lst     = fromSheet.CellValue(fromRow, "lst_nod_pln_dt"); //lst_nod_pln_dt
			dort    = fromSheet.CellValue(fromRow, "dor_nod_pln_dt"); //dor_nod_pln_dt
			n1stsec = fromSheet.CellValue(fromRow, "n1st_nod_pln_dt_hms"); //from Departure Time
			lstsec  = fromSheet.CellValue(fromRow, "lst_nod_pln_dt_hms"); //to Arrival Time
			dortsec = fromSheet.CellValue(fromRow, "dor_nod_pln_dt_hms"); //to dor_nod_pln_dt Time

			for( var z = ir+1; z < arrRow.length-1; z++ ) {
				var lvFmnod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "fm_nod_cd")+fromSheet.CellValue(arrRow[z], "fm_nod_yard"), " ");
				var lvVinod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "via_nod_cd")+fromSheet.CellValue(arrRow[z], "via_nod_yard"), " ");
				var lvTonod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "to_nod_cd")+fromSheet.CellValue(arrRow[z], "to_nod_yard"), " ");
				var lvDrnod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "dor_nod_cd")+fromSheet.CellValue(arrRow[z], "dor_nod_yard"), " ");

				var n1st2    = doSepRemove(fromSheet.CellValue(arrRow[z], "n1st_nod_pln_dt"), " "); //n1st_nod_pln_dt
				var lst2     = doSepRemove(fromSheet.CellValue(arrRow[z], "lst_nod_pln_dt"), " "); //lst_nod_pln_dt
				var dort2    = doSepRemove(fromSheet.CellValue(arrRow[z], "dor_nod_pln_dt"), " "); //dor_nod_pln_dt
				var n1stsec2 = doSepRemove(fromSheet.CellValue(arrRow[z], "n1st_nod_pln_dt_hms"), " "); //from Departure Time
				var lstsec2  = doSepRemove(fromSheet.CellValue(arrRow[z], "lst_nod_pln_dt_hms"), " "); //to Arrival Time
				var dortsec2 = doSepRemove(fromSheet.CellValue(arrRow[z], "dor_nod_pln_dt_hms"), " "); //to dor_nod_pln_dt Time
				
				btime = doTimeCheck(lvFmnod, lvFmnod2, lvVinod, lvVinod2, lvTonod, lvTonod2, lvDrnod, lvDrnod2, n1st, n1st2, lst, lst2, dort, dort2, n1stsec, n1stsec2, lstsec, lstsec2, dortsec, dortsec2); //시간 유무 체크 2시간 이내
				if( btime ) {
					if( cs == 0 )
						cs = 1;
					else if( cs == 1 )
						cs = 2;
					else if( cs == 2 )
						cs = 1;
					
					if( iz % 2 == 0 ) {
						lvcolor = R+","+G+","+B;
						cb = iz+"-"+cs;
					} else {
						lvcolor = "255,255,255";
						cb = iz+"-"+cs;
					}
					//옮길 데이터를 xml로 구성한다.
					rowXml += "<TR BGCOLOR='"+lvcolor+"'>";
					for (var ic = 0; ic<=fromSheet.LastCol; ic++) {
						if( fromSheet.ColSaveName(ic) == "chk1" ) {
							rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
						} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
							rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
						} else if( fromSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
							rowXml += "<TD>"+cb+"</TD>";
						} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "via_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
							rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(arrRow[z], ic)+"' COMBO-CODE='"+fromSheet.CellText(arrRow[z], ic)+"'>" + fromSheet.CellValue(arrRow[z], ic) + "</TD>";
						} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
							rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(arrRow[z], ic) + "</TD>";
						} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") {
							rowXml += "<TD COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + fromSheet.CellValue(arrRow[z], ic) + "</TD>";
						} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" || fromSheet.ColSaveName(ic) == "inter_rmk" || fromSheet.ColSaveName(ic) == "dor_de_addr" ) {
							rowXml += "<TD><![CDATA[" + fromSheet.CellValue(arrRow[z],ic) + "]]></TD>";
						} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
							var sText = fromSheet.GetComboInfo(arrRow[z], "lst_loc_cd", "Text");
							var sCode = fromSheet.GetComboInfo(arrRow[z], "lst_loc_cd", "Code");
							rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + fromSheet.CellValue(arrRow[z], ic) + "</TD>";
						} else {
							rowXml += "<TD>" + fromSheet.CellValue(arrRow[z],ic) + "</TD>";
						}
					}
					rowXml += "</TR>";
					fromSheet.CellValue2(arrRow[z], "chk1") = "1";
					fromSheet.RowStatus(arrRow[z]) = "R";
					break;
				}
			} //for End

			if( btime ) {
				if( cs == 0 )
					cs = 1;
				else if( cs == 1 )
					cs = 2;
				else if( cs == 2 )
					cs = 1;
				
				if( iz % 2 == 0 ) {
					lvcolor = R+","+G+","+B;
					cb = iz+"-"+cs;
				} else {
					lvcolor = "255,255,255";
					cb = iz+"-"+cs;
				}
				//옮길 데이터를 xml로 구성한다.
				rowXml += "<TR BGCOLOR='"+lvcolor+"'>";
				for (var ic = 0; ic<=fromSheet.LastCol; ic++) {
					if( fromSheet.ColSaveName(ic) == "chk1" ) {
						rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
					} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
						rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
					} else if( fromSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
						rowXml += "<TD>"+cb+"</TD>";
					} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "via_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
						rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
						rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") {
						rowXml += "<TD COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" || fromSheet.ColSaveName(ic) == "inter_rmk" || fromSheet.ColSaveName(ic) == "dor_de_addr" ) {
						rowXml += "<TD><![CDATA[" + fromSheet.CellValue(fromRow,ic) + "]]></TD>";
					} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
						var sText = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Text");
						var sCode = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Code");
						rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else {
						rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
					}
				}
				rowXml += "</TR>";
				btime = false;
				fromSheet.CellValue2(arrRow[z], "chk1") = "1";
				fromSheet.RowStatus(arrRow[z]) = "R";
				iz++;
			} else {
				fromSheet.CellValue2(fromRow, "chk1") = "0";
				fromSheet.RowStatus(fromRow) = "R";
				fromSheet.RowBackColor(fromRow) = fromSheet.RgbColor(R,G,B);
			}
		}
	} //LAST FOR END
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRdel = sRow.split("|");
	for (ir = arrRdel.length-2; ir >=0 ; ir--) {
		//원본에서 지움
		fromSheet.RowDelete(arrRdel[ir], false);
	}
	allXml += rowXml;
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
	if( rowXml.length < 10 ) {
		errMsg = ComGetMsg("TRS90131");
		ComShowMessage(errMsg);
	}
}

//Combined CNTR Trans. Case One --> Single Transportation(원복시 사용)
function IBS_Sheet2SheetStatus3(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	if( fromSheet.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90317");
		ComShowMessage(errMsg);
		return false;
	}

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		//옮길 데이터를 xml로 구성한다.
		rowXml = "<TR>";
		for (ic = 0; ic<=fromSheet.LastCol; ic++) {
			var costDtl = fromSheet.CellValue(fromRow, "trsp_cost_dtl_mod_cd");
			var trspMod = fromSheet.CellValue(fromRow, "trsp_crr_mod_cd"); //단일운송, 복합운송비교하기 위한 값
			var lvbool = false;
			if( trspMod.indexOf("D") < 0 ) {
				lvbool = true;
			} else {
				lvbool = false;
			}

			if( fromSheet.ColSaveName(ic) == "chk1" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
				rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "via_nod_yard" ) { //지연대리 요청으로 수정 20070115
				if( lvbool ) {
					rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "via_nod_cd" ) { //지연대리 요청으로 수정 20070115
				if( lvbool ) {
					rowXml += "<TD EDIT='TRUE'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
				rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") { //지연대리 요청으로 수정 20070115
				if( costDtl == "DOOR" ) {
					rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + 	fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else {
					rowXml += "<TD EDIT='FALSE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "dor_de_addr" || fromSheet.ColSaveName(ic) == "fctry_nm" || fromSheet.ColSaveName(ic) == "cntc_pson_phn_no" || fromSheet.ColSaveName(ic) == "cntc_pson_fax_no" || fromSheet.ColSaveName(ic) == "cntc_pson_nm" || fromSheet.ColSaveName(ic) == "dor_pst_cd" ) { //지연대리 요청으로 수정 20070115 정원근 수석 요청 20070723
				if( costDtl == "DOOR" ) {
					rowXml += "<TD EDIT='TRUE'><![CDATA[" + fromSheet.CellValue(fromRow, ic) + "]]></TD>";
				} else {
					rowXml += "<TD EDIT='FALSE'></TD>";
				}
			} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" || fromSheet.ColSaveName(ic) == "inter_rmk" ) {
				rowXml += "<TD><![CDATA[" + fromSheet.CellValue(fromRow,ic) + "]]></TD>";
			} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
				var sText = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Text");
				var sCode = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Code");
				rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
			} else {
				rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
			}
		}
		rowXml += "</TR>";
		allXml += rowXml;
	}

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
	IBS_Sheet2SheetStatus4(fromSheet);
}

//Combined CNTR Trans. Case Two --> Single Transportation(원복시 사용)
function IBS_Sheet2SheetStatus3_1(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;
	
	if( fromSheet.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90317");
		ComShowMessage(errMsg);
		return false;
	}

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting
	var sepObj = "";

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		var objcb = fromSheet.CellValue(ir+2, "trsp_so_cmb_seq").split("-");
		sepObj = objcb[1];

		if( sepObj == "1" ) {
			//옮길 데이터를 xml로 구성한다.
			rowXml = "<TR>";
			for (ic = 0; ic<=fromSheet.LastCol; ic++) {
				var costDtl = fromSheet.CellValue(fromRow, "trsp_cost_dtl_mod_cd");
				var trspMod = fromSheet.CellValue(fromRow, "trsp_crr_mod_cd"); //단일운송, 복합운송비교하기 위한 값
				var lvbool = false;
				if( trspMod.indexOf("D") < 0 ) {
					lvbool = true;
				} else {
					lvbool = false;
				}

				if( fromSheet.ColSaveName(ic) == "chk1" ) {
					rowXml += "<TD></TD>";
				} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
					rowXml += "<TD></TD>";
				} else if( fromSheet.ColSaveName(ic) == "fm_nod_yard" || fromSheet.ColSaveName(ic) == "to_nod_yard" || fromSheet.ColSaveName(ic) == "dor_nod_yard" ) {
					rowXml += "<TD COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else if( fromSheet.ColSaveName(ic) == "via_nod_yard" ) { //지연대리 요청으로 수정 20070115
					if( lvbool ) {
						rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+fromSheet.CellText(fromRow, ic)+"' COMBO-CODE='"+fromSheet.CellText(fromRow, ic)+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else {
						rowXml += "<TD EDIT='FALSE'></TD>";
					}
				} else if( fromSheet.ColSaveName(ic) == "via_nod_cd" ) { //지연대리 요청으로 수정 20070115
					if( lvbool ) {
						rowXml += "<TD EDIT='TRUE'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else {
						rowXml += "<TD EDIT='FALSE'></TD>";
					}
				} else if( fromSheet.ColSaveName(ic) == "trsp_crr_mod_cd" ) {
					rowXml += "<TD COMBO-TEXT='"+trsp_crr_mod_cdText+"' COMBO-CODE='"+trsp_crr_mod_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else if( fromSheet.ColSaveName(ic) == "dor_svc_tp_cd") { //지연대리 요청으로 20070115
					if( costDtl == "DOOR" ) {
						rowXml += "<TD EDIT='TRUE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
					} else {
						rowXml += "<TD EDIT='FALSE' COMBO-TEXT='"+dor_svc_tp_cdText+"' COMBO-CODE='"+dor_svc_tp_cdCode+"'></TD>";
					}
				} else if( fromSheet.ColSaveName(ic) == "dor_de_addr" || fromSheet.ColSaveName(ic) == "fctry_nm" || fromSheet.ColSaveName(ic) == "cntc_pson_phn_no" || fromSheet.ColSaveName(ic) == "cntc_pson_fax_no" || fromSheet.ColSaveName(ic) == "cntc_pson_nm" || fromSheet.ColSaveName(ic) == "dor_pst_cd" ) { //지연대리 요청으로 수정 20070115 정원근 수석 요청 20070723
					if( costDtl == "DOOR" ) {
						rowXml += "<TD EDIT='TRUE'><![CDATA[" + fromSheet.CellValue(fromRow, ic) + "]]></TD>";
					} else {
						rowXml += "<TD EDIT='FALSE'></TD>";
					}
				} else if( fromSheet.ColSaveName(ic) == "shpr_cust_nm" || fromSheet.ColSaveName(ic) == "cnee_cust_nm" || fromSheet.ColSaveName(ic) == "ntfy_cust_nm" || fromSheet.ColSaveName(ic) == "cmdt_name" || fromSheet.ColSaveName(ic) == "spcl_instr_rmk" || fromSheet.ColSaveName(ic) == "inter_rmk" ) {
					rowXml += "<TD><![CDATA[" + fromSheet.CellValue(fromRow,ic) + "]]></TD>";
				} else if( fromSheet.ColSaveName(ic) == "lst_loc_cd"  ) {
					var sText = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Text");
					var sCode = fromSheet.GetComboInfo(fromRow, "lst_loc_cd", "Code");
					rowXml += "<TD COMBO-TEXT='"+sText+"' COMBO-CODE='"+sCode+"'>" + fromSheet.CellValue(fromRow, ic) + "</TD>";
				} else {
					rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
				}
			}
			rowXml += "</TR>";
		} else {
			rowXml = "";
		}
		allXml += rowXml;
	}

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
	IBS_Sheet2SheetStatus4(fromSheet);
}

//Inert 성공에 따라 그리드의 내용을 제거 한다.
function IBS_Sheet2SheetStatus3_2(fromSheet, sStatus, bgObj) {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	for( var ir = arrRow.length-2; ir >=0 ; ir-- ) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	if( bgObj == "YES" ) {
		IBS_Sheet2SheetStatus4(fromSheet);
	}
}

//dtPopupEdit 로 처리 할 경우 팝업오픈 처리
var lvRow = 0;
function t1sheet1_OnPopupClick(sheetObj, row, col) {
	
	if( sheetObj.ColSaveName(col) == "act_cust_cd" ) {
		lvRow = row;
		var lvdor_node        = sheetObj.CellValue(row, "dor_nod_cd"     );
		
		if(lvdor_node == "" || lvdor_node == null)    return;  /* DOOR TERM 이 아닌경우 ACTUAL CUSTOMER POPUP DISABLED - 2007/11/23 */
		
		var lv_zone_cd        = sheetObj.CellValue(row, "dor_nod_yard"   );
		
		var lv_act_cust_cd    = sheetObj.CellValue(row, "act_cust_cd"    );
		var lv_fctry_nm       = sheetObj.CellValue(row, "fctry_nm"       );
		var lv_conti_cd       = sheetObj.CellValue(row, "fm_loc_conti_cd");
		var lv_bound_cd       = sheetObj.CellValue(row, "trsp_bnd_cd"    );

    	var myOption = "dialogWidth:800px; dialogHeight:506px; help:no; status:no; resizable:no; scroll=no; ";
		var url = 'ESD_TRS_0914.screen?act_loc='+lvdor_node+"&zone_cd="+lv_zone_cd+"&bound_cd="+lv_bound_cd+"&act_cust_cd="+lv_act_cust_cd+"&row="+row+"&conti_cd="+lv_conti_cd+"&fctry_nm="+lv_fctry_nm;
    	window.showModalDialog(url, window, myOption);
		
	} else if( sheetObj.ColSaveName(col) == "mlt_stop_de_flg" ) {
		lvRow = row;
		if( sheetObj.CellValue(row, "mlt_stop_de_flg") == "Y" ) {
			var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
			var lvbkg = sheetObj.CellValue(row, "bkg_no");
			var lvbl = sheetObj.CellValue(row, "bl_no");
			var lveq = sheetObj.CellValue(row, "eq_no");
			var lvts = sheetObj.CellValue(row, "eq_tpsz_cd");
			var lvtro = sheetObj.CellValue(row, "tro_seq");
			var url = "ESD_TRS_0933.do?bkgnumber="+lvbkg+"&blnumber="+lvbl+"&cntrnumber="+lveq+"&tpsznumber="+lvts+"&troseqnumber="+lvtro;
			window.showModalDialog(url, window, myOption);
		}
	} else if( sheetObj.ColSaveName(col) == "spcl_cgo_cntr_tp_cd" ) {
		var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
		var lvbkg = sheetObj.CellValue(row, "bkg_no");
		var lveqno = sheetObj.CellValue(row, "eq_no");
		var lvtro_seq = sheetObj.CellValue(row, "tro_seq");
		var lvui_conti_cd = document.form.ui_conti_cd.value;

		if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'DG' ) {
			//Dangerous Cargo Inquiry
			var url = "ESD_TRS_0938Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			window.showModalDialog(url, window, myOption);
		} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'BB' ) {
			//Break Bulk Cargo Inquiry
			var url = "ESD_TRS_0937Pop.do?bkg_no="+lvbkg;
			window.showModalDialog(url, window, myOption);
		} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'AK' ) {
			//Awkward Cargo Inquiry
			var url = "ESD_TRS_0936Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			window.showModalDialog(url, window, myOption);
		} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'RF' ) {
			//Refer Cargo Inquiry
			var url = "ESD_TRS_0935Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
			window.showModalDialog(url, window, myOption);
		}
	} else if( sheetObj.ColSaveName(col) == "ctrt_cnt" ) {
		var myOption = "dialogWidth:450px; dialogHeight:360px; help:no; status:no; resizable:no; scroll=no; ";
		var url = "";
	    var sc_no  = sheetObj.CellValue(row,"sc_no");
	    var rfa_no = sheetObj.CellValue(row,"rfano");
	    var vndr_seq = sheetObj.CellValue(row,"vndr_seq");
	    var trsp_bnd_cd = sheetObj.CellValue(row,"trsp_bnd_cd");
	    var fm_nod_cd   = sheetObj.CellValue(row,"fm_nod_cd");
	    var fm_nod_yard = sheetObj.CellValue(row,"fm_nod_yard");
	    var to_nod_cd   = sheetObj.CellValue(row,"to_nod_cd");
	    var to_nod_yard = sheetObj.CellValue(row,"to_nod_yard");
	    var dor_nod_cd  = sheetObj.CellValue(row,"dor_nod_cd");
	    var dor_nod_yard = sheetObj.CellValue(row,"dor_nod_yard");
	    var ctrl_ofc_cd  = sheetObj.CellValue(row,"ctrl_ofc_cd");
		if(sheetObj.CellValue(row,"ctrt_cnt") !="0"){
			url="ESD_TRS_0980.do"
			   +"?sc_no="+sc_no
			   +"&rfa_no="+rfa_no
			   +"&trsp_bnd_cd="+trsp_bnd_cd
			   +"&ctrl_ofc_cd="+ctrl_ofc_cd
			   +"&fm_nod_cd="+fm_nod_cd
			   +"&fm_nod_yard="+fm_nod_yard
			   +"&to_nod_cd="+to_nod_cd
			   +"&to_nod_yard="+fm_nod_yard
			   +"&dor_nod_cd="+dor_nod_cd
			   +"&dor_nod_yard="+dor_nod_yard
			   +"&chk_row="+row+"|"
			   +"&vndr_seq="
			   +"&scrn_mode=S"
			   ;  
			window.showModalDialog(url, window, myOption);			
		}
	}
}

//Pop-Up의 Return 값 Actual Customer
/* 0. TARGET ROW
* 1. ACTUAL CUSTOMER CODE
* 2. ACTUAL CUSTOMER NAME
* 3. FACTORY NAME
* 4. FACTORY ZIP CODE
* 5. FACTORY ADDRESS
* 6. FACTORY ADDRESS SEQ.
* 7. TEL NO
* 8. FAX NO
* 9. PIC NAME
*/
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {

	if( sheetObjects[0].CellValue(selected_row, "trsp_cost_dtl_mod_cd") == "DOOR" ) {
		sheetObjects[0].CellValue2(selected_row, "act_cust_cd")       = act_cust_cd      ;     /* act_cust_cnt_cd + act_cust_seq */
		sheetObjects[0].CellValue2(selected_row, "act_cust_cnt_cd")   = act_cust_cnt_cd  ;
		sheetObjects[0].CellValue2(selected_row, "act_cust_seq")      = act_cust_seq     ;
		sheetObjects[0].CellValue2(selected_row, "act_cust_addr_seq") = act_cust_addr_seq;  
		sheetObjects[0].CellValue2(selected_row, "fctry_nm")          = factory_nm       ;
		sheetObjects[0].CellValue2(selected_row, "dor_pst_cd")        = factory_zip_code ;
		sheetObjects[0].CellValue2(selected_row, "dor_de_addr")       = factory_addr     ;
		sheetObjects[0].CellValue2(selected_row, "cntc_pson_phn_no")  = factory_tel_no   ;
		sheetObjects[0].CellValue2(selected_row, "cntc_pson_fax_no")  = factory_fax_no   ;
		sheetObjects[0].CellValue2(selected_row, "cntc_pson_nm")      = pic_nm           ;
	}
	
	winObj.close();
}

//배경 색상 및 CB의 내용을 변경하는 부분
function IBS_Sheet2SheetStatus4(fromSheet) {
	var iz = 0;
	var cs = 0;
	for( var i=0; i<fromSheet.RowCount; i++ ) {
		if( i % 2 == 0 )
			iz++;

		if( cs == 0 )
			cs = 1;
		else if( cs == 1 )
			cs = 2;
		else if( cs == 2 )
			cs = 1;
		
		if( iz % 2 == 0 ) {
			fromSheet.CellValue2(i+2, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+2) = fromSheet.RgbColor(R,G,B);
		} else {
			fromSheet.CellValue2(i+2, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+2) = fromSheet.RgbColor(255,255,255);
		}
	}
} 

/*
* 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
*/
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} 
//	else if( lvobj.length != 5 ) {
//		errMsg = ComGetMsg("TRS90074");
//		ComShowMessage(errMsg);
//		obj.focus();
//		return false;
//	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		formObj.TRSP_SO_EQ_KIND.value = "";
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'V' ) {
		formObj.TRSP_SO_EQ_KIND.value = "";
		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		formObj.TRSP_SO_EQ_KIND.value = "A";
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		formObj.TRSP_SO_EQ_KIND.value = "";
		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
* 공통 Node popup
*/
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v6 = "";
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* 공통 Node popup
*/
function openContractNoPopup() {
	
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getContractNo";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="true";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var flag="";
	var cont_tp = '';
	var cont_no = '';
	if(formObject.contract_tp_cd[0].checked) flag = "1";
	else if(formObject.contract_tp_cd[1].checked) flag = "2";

	if(formObject.contract_no.value != '' && formObject.contract_no.value.length > 2) {
		cont_tp = formObject.contract_no.value.substring(0,3);
		cont_no = formObject.contract_no.value.substring(3);
	}
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	param += "&flag="+flag;
	param += "&cont_tp="+cont_tp;
	param += "&cont_no="+cont_no;

	ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 772, 450, 'getCOM_ENS_021_1', '1,0,1,1,1,1,1,1,1,1,1,1');
}


function getContractNo(rowArray){
	
	var formObject = document.form;

	var colArray = rowArray[0];
	var in_val = colArray[2];
	formObject.contract_no.value = in_val;

}

/**
* popSearchPiCommCodeGrid 프로세스 처리
*/
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;
	
	if(myWin != null) myWin.close();
	url = myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
* From Node 팝업에 대한 리턴값
*/
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
* Via Node 팝업에 대한 리턴값
*/
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
}

/**
* To Node 팝업에 대한 리턴값
*/
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
* Door Location 팝업에 대한 리턴값
*/
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/**
* 공통 Trunk VVD popup
*/
function openTVVDPopup(obj) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = obj;

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

/**
* Trunk VVD return value
*/
function getCOM_ENS_VVD_1(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.trunk_vvd.value = colArray[7] + gubun;
}

/**
* Feeder VVD return value
*/
function getCOM_ENS_VVD_2(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.txt_feeder_vvd.value = colArray[7] + gubun;
}

/**
* 조회결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function t1sheet1_OnSearchEnd(sheetObj,errMsg){
	var formObj = document.form;
	var srcName = '';
	
	if(formObj.f_cmd.value == SEARCH17){								// SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직	
		srcName = window.event.srcElement.getAttribute("name");		
		var confirm_flg= sheetObj.EtcData("confirm_flg");
		var bkg_no= sheetObj.EtcData("bkg_no");

		if(confirm_flg == 'X'){			
			ComShowCodeMessage('TRS00407');			
			return;				
		}else if(confirm_flg == 'R'){
			ComShowCodeMessage('TRS00409');			
			return;				
		}else if(confirm_flg == 'T'){
			ComShowCodeMessage('TRS00408');			
			return;					
		}else{
			doActionIBSheet(sheetObj, formObj, IBINSERT, "");
		}
	}else{				
		formObj.rad_dateSep[0].disabled = false;
		formObj.rad_dateSep[1].disabled = false;
		formObj.rad_dateSep[2].disabled = false;
		formObj.unplan_shuttle.disabled = false;
		formObj.tro_unconfirm_dr.disabled = false;
	
		if(errMsg!=null){
			//ComShowMessage(errMsg);
		}
	}	
}

/**
* 조회결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function t2sheet1_OnSearchEnd(sheetObj,errMsg){
	var formObj = document.form;
	var srcName = '';
	
	if(formObj.f_cmd.value == SEARCH17){								// SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직	
		srcName = window.event.srcElement.getAttribute("name");		
		var confirm_flg= sheetObj.EtcData("confirm_flg");
		var bkg_no= sheetObj.EtcData("bkg_no");
		
		if(confirm_flg == 'X'){			
			ComShowCodeMessage('TRS00407');			
			return;				
		}else if(confirm_flg == 'R'){
			ComShowCodeMessage('TRS00409');			
			return;				
		}else if(confirm_flg == 'T'){
			ComShowCodeMessage('TRS00408');			
			return;						
		}else{
			doActionIBSheet(sheetObj, formObj, IBINSERT, "CF");
		}
	}
}

/**
* 조회결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function t3sheet1_OnSearchEnd(sheetObj,errMsg){
	var formObj = document.form;
	var srcName = '';
	
	if(formObj.f_cmd.value == SEARCH17){								// SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직	
		srcName = window.event.srcElement.getAttribute("name");		
		var confirm_flg= sheetObj.EtcData("confirm_flg");
		var bkg_no= sheetObj.EtcData("bkg_no");
		
		if(confirm_flg == 'X'){			
			ComShowCodeMessage('TRS00407');			
			return;				
		}else if(confirm_flg == 'R'){
			ComShowCodeMessage('TRS00409');			
			return;				
		}else if(confirm_flg == 'T'){
			ComShowCodeMessage('TRS00408');			
			return;						
		}else{
			doActionIBSheet(sheetObj, formObj, IBINSERT, "CS");
		}
	}
}

/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObject = document.form;
	var cmbTbcd = "";
	cmbTbcd = document.form.cbstatus.value;
	var sheetObjOrigin;
	var cmbSep = "";

	if( cmbTbcd == "" ) {
		sheetObjOrigin = sheetObjects[0];
		cmbSep = "NO";
	} else if( cmbTbcd == "CF" ) {
		sheetObjOrigin = sheetObjects[1];
		cmbSep = "YES";
	} else if( cmbTbcd == "CS" ) {
		sheetObjOrigin = sheetObjects[2];
		cmbSep = "YES";
	}


	if( errMsg.length > 0 ) {
		return;
	} else {
	    if(formObject.f_cmd.value != SEARCH19){
		    errMsg = ComGetMsg("TRS90107");
		    ComShowMessage(errMsg);
		    IBS_Sheet2SheetStatus3_2(sheetObjOrigin, "chk1", cmbSep);
	    }
	}
}


/**
* 공통 Trunk VVD popup
*/
function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
* Location : 팝업에서 단일 선택을 한경우..
*/
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value = reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value = multiCntrChkDgt(reObj);
	} else if( obj == "FVD" ) {
		formObject.txt_feeder_vvd.value = reObj;
	} else if( obj == "ZIP" ) {
		formObject.zip_code.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/*
* 멀티 달력 입력 Pop-Up
*/
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

function fun_chekcbox(lvobj) {
	sheetObjects[0].RemoveAll();
	if( lvobj == "01" ) {
		if( document.form.unplan_shuttle.checked ) {
//			document.form.incl_usa_rail.checked = false;
			document.form.tro_unconfirm_dr.checked = false;

			document.form.hid_frmdate.value = "";
			document.form.hid_todate.value = "";
			document.form.search_via_loc.value = "";
			document.form.search_to_loc.value = "";
			document.form.search_door_loc.value = "";

			document.form.search_via_yard.RemoveAll(); // combo 데이터삭제
			document.form.search_to_yard.RemoveAll(); // combo 데이터삭제
			document.form.search_door_yard.RemoveAll(); // combo 데이터삭제
			document.form.sel_costmode.enable   = false;
			document.form.sel_bound[0].selected = true;
			document.form.sel_transmode[0].selected = true;

			document.form.frm_plandate.disabled = true;
			document.form.to_plandate.disabled = true;
			document.form.sel_bound.disabled = true;
			document.form.sel_costmode.disabled = true;
			document.form.sel_transmode.disabled = true;
			document.form.search_via_loc.disabled = true;
			document.form.search_via_yard.disabled = true;
			document.form.search_to_loc.disabled = true;
			document.form.search_to_yard.disabled = true;
			document.form.search_door_loc.disabled = true;
			document.form.search_door_yard.disabled = true;
			document.form.btns_calendar.style.visibility = "hidden";
			document.form.btns_vianode.style.visibility = "hidden";
			document.form.btns_tonode.style.visibility = "hidden";
			document.form.btns_dorloc.style.visibility = "hidden";
		} else {
			fun_disabled()
		}
	} else if( lvobj == "02" ) {
/*
		if( document.form.incl_usa_rail.checked ) {
			fun_disabled()
			document.form.unplan_shuttle.checked = false;
			document.form.tro_unconfirm_dr.checked = false;
		}
*/
	} else if( lvobj == "03" ) {
		fun_disabled()
		if( document.form.tro_unconfirm_dr.checked ) {
			document.form.unplan_shuttle.checked = false;
//			document.form.incl_usa_rail.checked = false;
		}
	} else {
		fun_disabled()
//		document.form.incl_usa_rail.checked = false;
		document.form.tro_unconfirm_dr.checked = false;
//		document.form.incl_usa_rail.checked = false;
	}
}

function fun_disabled() {
	document.form.frm_plandate.disabled = false;
	document.form.to_plandate.disabled = false;
	document.form.sel_bound.disabled = false;
	document.form.sel_costmode.enable = true;
	document.form.sel_transmode.disabled = false;
	document.form.search_via_loc.disabled = false;
	document.form.search_via_yard.disabled = false;
	document.form.search_to_loc.disabled = false;
	document.form.search_to_yard.disabled = false;
	document.form.search_door_loc.disabled = false;
	document.form.search_door_yard.disabled = false;
	document.form.btns_calendar.style.visibility = "visible";
	document.form.btns_vianode.style.visibility = "visible";
	document.form.btns_tonode.style.visibility = "visible";
	document.form.btns_dorloc.style.visibility = "visible";
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[0];
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.ctrl_so_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		document.form.ctrl_so_office.disabled = false;
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
		document.form.ctrl_so_office.disabled = true;
	} else {
		document.form.ctrl_so_office.value = document.form.old_ofc_cd.value;
		document.form.ctrl_so_office.disabled = false;
	}
}

function fun_ParentOffice() {
	var doc_office = document.form.chk_office;
	if( doc_office.checked == true ) {
		document.form.prnt_ofc_cd.value = document.form.old_ofc_cd.value;
	} else {
		document.form.prnt_ofc_cd.value = document.form.ctrl_so_office.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.ctrl_so_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.ctrl_so_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}

//Office의 Text 변경시
function fun_officeText() {
	document.form.ctrl_so_office.value = document.form.ctrl_so_office.value.toUpperCase();
	document.form.chk_office.checked = false;
}

function t1sheet1_OnSelectMenu(sheetObj, MenuString){
	
	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}

function deleteSOCandidate(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	if(checkList == ''){
		ComShowCodeMessage('TRS90215');
		return false;
	}

  //N200902230070 2009-02-26 TRS SO delete 대상 범위 변경 TD -> 전체 (이경한 과장 요청)
	if(!confirm(ComGetMsg('COM12165', 'SO Candidates'))) return false;

	formObj.f_cmd.value = REMOVE01;
	sheetObj.DoSave("ESD_TRS_0002GS.do", TrsFrmQryString(formObj), 'chk1', false);
}

//CNTR 직반납 Verify Check 
function offHireVerify(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.f_cmd.value         = SEARCH07;
	var eqno = "";
	
	if(sheetObj.RowCount < 1){
		ComShowCodeMessage('TRS90386', 'First, Please inquiry');
		return false;
	}
	
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	
    for( var i=1; i<sheetObj.RowCount+2; i++ ) {
      if( sheetObj.CellValue(i, "chk1") == "1" ) {
      	eqno = eqno + "&sel_cntr_no=" + sheetObj.CellValue(i, "eq_no");
      }
    }

	eqno = eqno.substring(1, eqno.length);
	sheetObjects[5].DoSearch4Post("ESD_TRS_0002GS.do", eqno+'&'+TrsFrmQryString(formObj), '', false);
}

function rtnsheet_OnSearchEnd(sheetObj, errMsg) {
	var main_sheet = sheetObjects[0];
	var cnt = 0;
	for(i=1;i<main_sheet.RowCount+2;i++) {
		if( main_sheet.CellValue(i, "chk1") == "1" ) {
			for(j=1;j<sheetObj.RowCount+1;j++) {
				if (main_sheet.CellValue(i, "eq_no") == sheetObj.CellValue(j, "cntr_no")) {
					main_sheet.CellValue2(i, "to_nod_cd") = sheetObj.CellValue(j, "offh_yd_cd").substring(0,5);
					main_sheet.CellText(i, "to_nod_yard") = sheetObj.CellValue(j, "offh_yd_cd").substring(5,7);
					main_sheet.CellValue2(i, "lse_cntr_flg") = "Y";
					//main_sheet.RangeBackColor(i, 1, i, 10) = main_sheet.RgbColor(255, 0, 0);
					main_sheet.RangeFontColor(i,12,i,13) = main_sheet.RgbColor(255,0,0);
					cnt++;
				}
			}
		}
	}
	ComShowMessage("Off Hire Verify Success ("+ cnt +" case)");
}

/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	 var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == REMOVE01){
			
			if(!formObj.tro_unconfirm_dr.checked){
				var checkList = sheetObj.FindCheckedRow('chk1');
				var checkArray = checkList.split('|');

				for(var k=checkArray.length-sheetObj.HeaderRows; k>=0; k--){
					sheetObj.RowDelete(checkArray[k], false);
				}
			}
			ComShowCodeMessage('COM12167', 'SO Candidates');
		}
	}
}

/**
* CY / DOOR 구분에 따른 Cost Mode 조회
**/
function getCostModeList(sheetObj, formObject)
{
	 sheetObj.WaitImageVisible  = false;
	 formObject.f_cmd.value = SEARCH08;
	 var queryString = TrsFrmQryString(formObject);
	 //alert(queryString);
	 sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
	 sheetObj.WaitImageVisible  = true;
	 return sheetObj.EtcData('COST_MODE');
}

/**
* CY / DOOR 구분에 따른 Cost Mode 조회 내역을 combo에 설정한다.
**/
function getCostModeCombo(comboObj)
{
	  var formObj = document.form;
	  var CostModeList = getCostModeList(sheetObjects[0], formObj);
	  var yardArray = new Array();
	  CostModeArray = CostModeList.split("|");
	  comboObj.RemoveAll();
	  comboObj.InsertItem(0, "ALL", "ALL");
	  for(var i=1; i<CostModeArray.length+1; i++)
	  {
		  comboObj.InsertItem(i, CostModeArray[i-1].substring(2), CostModeArray[i-1].substring(0,2) );
	  }
	  comboObj.Index=0;
	  
	  var cydoor_div = formObj.cydoor_div.value;
	  if (cydoor_div == "DR"){
		  formObj.rad_dateSep[1].disabled = false;
	  }else{
		  formObj.rad_dateSep[0].checked = true;
		  formObj.rad_dateSep[1].disabled = true;
	  }
}

//FM,TO Location 변경시 In/Out VVD 새로 가지고온다
function getBkgVvd(sheetObj, formObject, row)
{
	var bkg_no = sheetObj.CellValue(row, "bkg_no");
	var fm_nod_cd = sheetObj.CellValue(row, "fm_nod_cd");
	var to_nod_cd = sheetObj.CellValue(row, "to_nod_cd");
	var trsp_bnd_cd = sheetObj.CellValue(row, "trsp_bnd_cd");
	formObject.f_cmd.value = SEARCH09;
	var queryString = "bkg_no="+bkg_no+"&fm_nod_cd="+fm_nod_cd+"&to_nod_cd="+to_nod_cd+"&trsp_bnd_cd="+trsp_bnd_cd+"&"+TrsFrmQryString(formObject);

	sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
	
	sheetObj.CellValue2(row, "ib_vvd_cd") = sheetObj.EtcData('ib_vvd_cd');
	sheetObj.CellValue2(row, "ob_vvd_cd") = sheetObj.EtcData('ob_vvd_cd');
	sheetObj.RemoveEtcData();
}

/**
* CNTR_LBS_WGT의 값 체크 
**/
function chkCntrLbsWgt(sheetObj)
{
	var iLen = '';
	var errMsg = '';
	var sw = '1';
	for(i=2;i<sheetObj.RowCount+2;i++) {		
		if( sheetObj.CellValue(i, "chk1") == '1' && sw == '1') {
			iLen = parseInt(ComTrimAll(sheetObj.CellValue(i,"cntr_lbs_wgt"), ",")).toString();			
			if(iLen.length >= 6){				
				errMsg = ComGetMsg("TRS90408");
				ComShowMessage(errMsg);
				sw = '2';
			}					
		}
	}	
	
	if(sw == '2'){
		return false;
	}else{
		return true;
	}
}

/**
 * 2012.01.10 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
 * Trans mode 와 Route 가 동일한 내용으로 생성된 건이 존재하면
 * 해당 row의 CNTR No.셀의 색을 pink로 변경하고 warning 메시지를 발생시킨다.
 */
function searchSODupCheck(sheetObj, formObject, row) {
	
	var eq_no			= sheetObj.CellValue(row, "eq_no");
	var cop_no			= sheetObj.CellValue(row, "cop_no");
	var fm_nod_yard		= sheetObj.CellValue(row, "fm_nod_yard");
	var fm_nod_cd		= sheetObj.CellValue(row, "fm_nod_cd");
	var via_nod_yard	= sheetObj.CellValue(row, "via_nod_yard");
	var via_nod_cd		= sheetObj.CellValue(row, "via_nod_cd");
	var to_nod_yard		= sheetObj.CellValue(row, "to_nod_yard");
	var to_nod_cd		= sheetObj.CellValue(row, "to_nod_cd");
	var trsp_cost_dtl_mod_cd = sheetObj.CellValue(row, "trsp_cost_dtl_mod_cd");
	var trsp_crr_mod_cd = sheetObj.CellValue(row, "trsp_crr_mod_cd");
	
	var msgFlg = document.form.msg_flag.value;
	
	formObject.f_cmd.value = SEARCH16;
	
 	var queryString = "eq_no="+eq_no+"&cop_no="+cop_no
 					 +"&fm_nod_yard="+fm_nod_yard+"&fm_nod_cd="+fm_nod_cd
 					 +"&via_nod_yard="+via_nod_yard+"&via_nod_cd="+via_nod_cd
 					 +"&to_nod_yard="+to_nod_yard+"&to_nod_cd="+to_nod_cd
 					 +"&trsp_cost_dtl_mod_cd="+trsp_cost_dtl_mod_cd+"&trsp_crr_mod_cd="+trsp_crr_mod_cd
 					 +"&f_cmd="+SEARCH16;
//	 	sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0002GS.do", queryString);
	var soDupChk = ComGetEtcData(sXml, "soDupChk");

	if(soDupChk == "Y") {
		sheetObj.cellBackColor(row, "eq_no") = sheetObj.RgbColor(255, 204, 255);// pink
		if(msgFlg == "N"){
			ComShowCodeMessage("TRS00414");
			document.form.msg_flag.value = "Y";
		} 
	} else {
		sheetObj.cellBackColor(row, "eq_no") = sheetObj.RgbColor(239, 240, 243);
	}
}
 
 /**
 * 2012.06.05 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
 * PRD의 데이터를 조회하여 Distance를  계산한다. 
 */
 function  distance_cal(sheetObj, row) {
 }
 
 /**  CY/Door Unplane일 경우 Reason of Node Change 항목을 입력하도록 Validation Check
  * 	CY/Door Creation(EUR,USA,ASIA)/ Correction화면에 사용
  * 	CSR NO : [CHM-201220222] 2012.09.20 by SHIN DONG IL
  *              [CHM-201221864] 2012.12.17 S/O creation & correction validation (Trans Mode 추가
  * 	Param Desc
  *		sheetObj : Sheet Object
  *		row : check Row Number
  */
 function changeLocCheck(sheetObj,row){
	
	 var trsp_cost_dtl_mod_cd = sheetObj.CellValue(row,"trsp_cost_dtl_mod_cd");
	 var trsp_bnd_cd = sheetObj.CellValue(row,"trsp_bnd_cd");
	 var cng_rsn_desc = ComTrimAll(sheetObj.CellValue(row,"cng_rsn_desc")," ");
	 
	 var trsp_crr_mod_cd = sheetObj.CellValue(row,"trsp_crr_mod_cd");    
	 var trsp_crr_mod_cd2 = sheetObj.CellValue(row,"trsp_crr_mod_cd2");
	
	 var chg_fm_loc =  sheetObj.CellValue(row,"fm_nod_cd")+sheetObj.CellValue(row,"fm_nod_yard");
	 var chg_via_loc =  sheetObj.CellValue(row,"via_nod_cd")+sheetObj.CellValue(row,"via_nod_yard");
	 var chg_to_loc =  sheetObj.CellValue(row,"to_nod_cd")+sheetObj.CellValue(row,"to_nod_yard");
	 var chg_dor_loc =  sheetObj.CellValue(row,"dor_nod_cd")+sheetObj.CellValue(row,"dor_nod_yard");
	 
	 var org_fm_loc =  sheetObj.CellValue(row,"fm_nod_cd2")+sheetObj.CellValue(row,"fm_nod_yard2");
	 var org_via_loc =  sheetObj.CellValue(row,"via_nod_cd2")+sheetObj.CellValue(row,"via_nod_yard2");
	 var org_to_loc =  sheetObj.CellValue(row,"to_nod_cd2")+sheetObj.CellValue(row,"to_nod_yard2");
	 var org_dor_loc =  sheetObj.CellValue(row,"dor_nod_cd2")+sheetObj.CellValue(row,"dor_nod_yard2");
	 
	if(trsp_cost_dtl_mod_cd == "DOOR"){
	   trsp_cost_dtl_mod_cd = "DR";
	}

	if(cng_rsn_desc == ""){
//2014.04.28 check 제외	   
//	   if(trsp_crr_mod_cd != trsp_crr_mod_cd2){
//		   return false;
//	   }
	   
	   if( trsp_cost_dtl_mod_cd =="CY"){
		   if( chg_fm_loc == org_fm_loc &&  chg_via_loc == org_via_loc && chg_to_loc == org_to_loc && chg_dor_loc == org_dor_loc ){
			 return true; 
		   }else{
			 return false;
		   }
	   }else if( trsp_cost_dtl_mod_cd =="DR"){
//		   if(trsp_bnd_cd == "O"){
//			   if( chg_via_loc == org_via_loc && chg_to_loc == org_to_loc && chg_dor_loc == org_dor_loc  ){
//					 return true; 
//			   }else{
//					 return false;
//			   }   
//		   }else if(trsp_bnd_cd == "I"){
//			   if(chg_fm_loc == org_fm_loc &&  chg_via_loc == org_via_loc &&  chg_dor_loc == org_dor_loc ){
//				   return true; 
//			   }else{
//				   return false;
//			   }
//		   }
		   if((chg_fm_loc == org_fm_loc) && (chg_via_loc == org_via_loc) && (chg_to_loc == org_to_loc) && (chg_dor_loc == org_dor_loc)  ){
				return true; 
		   }else{
				return false;
		   }   
	   }else{
			 return true; 
	   }
    }else{
 	   return true; 
    }
 }