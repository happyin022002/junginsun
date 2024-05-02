/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0016.js
*@FileTitle : Invoice Item Correction(General)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.04 김세일
* 1.0 Creation
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
	 */
	var sheet_container = null;
	
	/**
	 * @extends 
	 * @class fns_inv_0016 : fns_inv_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0016() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// CHM-201113244 
	var act_cust_cd="";
	var inv_cust_cd="";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
		
					break;
		
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					sheetObject5.RemoveAll();
		
					form.bl_no.value = "";
					form.bkg_no.value = "";
					form.if_no.value = "";
					form.str_inv_no.value = "";
					form.act_cust_cnt_cd.value = "";
					form.act_cust_seq.value = "";
					form.cust_nm.value = "";
					form.cust_rgst_no.value = "";
					form.inv_cust_cnt_cd.value = "";
					form.inv_cust_seq.value = "";
					form.cr_curr_cd.value = "";
					form.cr_amt.value = "";
					form.ob_cr_term_dys.value = "";
					form.ib_cr_term_dys.value = "";
					form.cr_clt_ofc_cd.value = "";
					form.local_vvd.value = "";
					form.svc_scp_cd.value = "";
					form.io_bnd_cd.value = "";
					form.sail_arr_dt.value = "";
					form.trunk_vvd.value = "";
					form.slan_cd.value = "";
					form.por_cd.value = "";
					form.pol_cd.value = "";
					form.pod_cd.value = "";
					form.del_cd.value = "";
					form.bkg_corr_no.value = "";
					form.bkg_corr_dt.value = "";
					form.hjs_stf_ctnt.value = "";
					form.inv_ref_no.value = "";
					form.bkg_ref_no.value = "";
					form.si_ref_no.value = "";
					form.inv_rmk.value = "";
					form.rev_tp_cd.value = "";
					form.rev_src_cd.value = "";
					form.mst_bl_no.value = "";
					form.rfa_no.value = "";
					form.sc_no.value = "";
					form.srep_cd.value = "";
					form.cgo_wgt.value = "";
					form.cgo_meas_qty.value = "";
					form.whf_decl_no.value = "";
					form.whf_decl_cfm_dt.value = "";
					form.bkg_teu_qty.value = "";
					form.bkg_feu_qty.value = "";
					form.bl_inv_if_dt.value = "";
					form.bl_inv_cfm_dt.value = "";
					form.gl_eff_dt.value = "";
					form.inv_no.value = "";
					form.iss_dt.value = "";
					form.due_dt.value = "";
					form.frt_fwrd_cnt_cd.value = "";
					form.frt_fwrd_cust_seq.value = "";
					form.cr_flg.value = sheetObjects[0].CellValue(1, "cr_flg");
					form.zn_ioc_cd.value = "";
					form.cust_cnt_cd.value = "";
					form.cust_seq.value = "";
					form.lcl_curr.value = "";
					form.str_inv_no.readOnly = false ;
					document.all.str_inv_no.className = "input" ;
					
					form.mod_flag.value="N";
					form.act_inv_flag.value="N";
					form.inv_cust_flg.value="N";
					
					ComBtnEnable("btn_save");
					
					form.bl_no.focus();
					
					break; 
		
				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
		
					break; 
				case "btn_container":
					open_container();
					break; 
				case "btn_actcust":
					var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.act_cust_cnt_cd.value+'&cust_seq='+formObject.act_cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
					break; 
				case "btn_cust":
					var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.inv_cust_cnt_cd.value+'&cust_seq='+formObject.inv_cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
					break; 
				case "btn_custNm":
					param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.act_cust_seq.value+'&cust_cnt_cd='+formObject.act_cust_cnt_cd.value;
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
					break;
				case "btn_close":
					window.close();
				break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/** 
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		sheet_container = sheetObjects[1]; 
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);	
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
	
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 	
		
		if(document.form2.classId.value=="FNS_INV_0016"){
			document.form.bl_no.value = document.form2.bl_src_no.value;
			document.form.ar_ofc_cd.Text = document.form2.ar_ofc_cd.value;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}	
		
		form.bl_no.focus();
		
	}
	 
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
	
		case 1:      //sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height =0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(71, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|bl_no|bkg_no|if_no|actual cust seq| actual cust cd|cust_nm |cust_rgst_no|inv cust cd|inv_cust_seq |crdt limit cd |crdt limit amt | crdt term ob|crdt term ib| crdt office| vsl_cd|skd_voy_no|skd_dir_cd|local vvd| scope| bound|s/a Date|trnk_vsl_cd|trnk_skd_voy_no|trnk_skd_dir_cd|Trunk vvd|Lane|PoR|pol|pod|del|c/a no.|c/a Date|SML Ref.|INV ref.no|Bkg Ref.No|S/I Ref.No|Description|Rev.Type|Source|Master B/L|RFA No.|S/C No|Sales Rep.|Weight|Measure|WHF DEC|WHF Date|TEU|FEU|I/F Date|Good Date|Eff.Date|INV No.|Issue Date|Due Date|FWDR Code|FWDR Seq|cr_flg|zn_ioc_cd|locl_curr_cd|inv_delt_div_cd|CR_TERM_DYS|CUST_CR_FLG|XCH_RT_N3RD_TP_CD|XCH_RT_USD_TP_CD|XCH_RT_DT|usd_xch_rt|sail_dt|dest_trns_svc_mod_cd|inv_svc_scp_cd";
	
	
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_src_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ar_if_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "act_cust_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "act_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_nm");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_rgst_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_cust_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_curr_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_amt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ob_cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ib_cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_clt_ofc_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "vsl_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "skd_voy_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "skd_dir_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "local_vvd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "svc_scp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "io_bnd_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sail_arr_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_vsl_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_skd_voy_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trnk_skd_dir_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "trunk_vvd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "slan_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "por_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "pol_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "pod_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "del_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_corr_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_corr_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "hjs_stf_ctnt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "si_ref_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_rmk");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rev_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rev_src_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "mst_bl_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "rfa_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sc_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "srep_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cgo_wgt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cgo_meas_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "whf_decl_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "whf_decl_cfm_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_teu_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bkg_feu_qty");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_inv_if_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "bl_inv_cfm_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "gl_eff_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_no");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "iss_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "due_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "frt_fwrd_cnt_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "frt_fwrd_cust_seq");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_flg");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "zn_ioc_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "locl_curr_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_delt_div_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cr_term_dys");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cust_cr_flg");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_n3rd_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_usd_tp_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "xch_rt_dt",false,      "",				dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "usd_xch_rt", false,    "",      dfNullFloat,	6,     false,       false);
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "sail_dt");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "dest_trns_svc_mod_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "inv_svc_scp_cd");
			
			WaitImageVisible = false; 
		}
		break;
	
		case 2:      //container
		with (sheetObj) {
	
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true,true, false, true, false,false)
	
			var HeadTitle = "|cntr_tpsz_cd|cntr_no|cntr_seq|teu|feu|ar_if_no|";
	
	
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cntr_tpsz_cd");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "cntr_no");
			InitDataProperty(0, cnt++ , dtSeq,  40,    daCenter,  true,    "cntr_seq");
			InitDataProperty(0, cnt++ , dtAutoSum,  40,    daCenter,  true,    "teu");
			InitDataProperty(0, cnt++ , dtAutoSum,  40,    daCenter,  true,    "feu");
			InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "ar_if_no");
			
			WaitImageVisible = false; 
		}
		break;
	
	
		case 3:      //Summary
		with (sheetObj) {
			// 높이 설정
			style.height = 120;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			var HeadTitle = "|Cur|Amount|Ex. Rate|Local Cur|Local Amount";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,      		 100,    daCenter,  false,   "curr_cd",     		false,    "",      dfNone,      0,    false,       false);
			InitDataProperty(0, cnt++ , dtData,      		 120,    daRight,   false,   "chg_amt",   		false,    "",      dfNullFloat,	2,     false,       false);
			InitDataProperty(0, cnt++ , dtData,   		   120,    daRight,   false,   "inv_xch_rt",   		false,    "",      dfNullFloat,	6,     false,       false);
			InitDataProperty(0, cnt++ , dtData,   			 100,    daCenter,  false,   "locl_curr_cd",  		false,    "",      dfNone,			0,     false,       false);
			InitDataProperty(0, cnt++ , dtAutoSum,  	   100,    daRight,   false,   "local_total",		false,    "",      dfNullFloat,	2,     false,       false);
	
			EditableColorDiff = false;
	
			WaitImageVisible = false; 
	
		}
		break;
	
		case 4:      //By Charge
		with (sheetObj) {
	
			// 높이 설정
			style.height = 240;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 15, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(15, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			var HeadTitle = "|Seq.|CHG|M/N|Cur|Rate|Rated As|Per|Amount|VAT|||||";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtSeq,  			80,    daCenter,  true,    "seq");
			InitDataProperty(0, cnt++ , dtData,  		   	 80,   daCenter,    false,     "chg_cd",    			false,      "",      dfNone,  		0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,    			 80,   daCenter,  	false,     "mf_div_cd",   		  	false,      "",      dfNone, 			0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,    			 100,   daCenter,  	false,     "curr_cd",   			false,      "",      dfNone,  		0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,  		   	 150,  daRight,     false,     "trf_rt_amt",    		false,      "",      dfNullFloat, 2,     false,       false);
			InitDataProperty(0, cnt++ , dtData,    			 100,   daRight,  	  false,     "rat_as_cntr_qty",   	false,      "",      dfNullFloat, 3,     false,       false);
			InitDataProperty(0, cnt++ , dtData,    			 100,  daCenter,  	false,     "per_tp_cd",   			false,      "",      dfNone, 			0,    false,       false);
	
			InitDataProperty(0, cnt++ , dtData,  		   	 120,  daRight,     false,     "chg_amt",     	false,      "",      dfNullFloat, 2,     false,       false);
			InitDataProperty(0, cnt++ , dtCheckBox,    			 80,  daCenter,  	false,     "tva_flg",   			false,      "",      dfNone, 			0,    true,       false);
	
			InitDataProperty(0, cnt++ , dtHidden,    			 130,   daRight,   	false,     "lcl_curr_cd",   false,      "",      dfNone, 2,    false,       false);
			InitDataProperty(0, cnt++ , dtHidden,    			 130,   daRight,   	false,     "ar_if_ser_no",   false,      "",      dfNone, 2,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden,    			 130,   daRight,   	false,     "chg_seq",   false,      "",      dfNone, 2,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden,    			 130,   daRight,   	false,     "inv_xch_rt",   false,      "",      dfNone, 2,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden,    			 130,   daRight,   	false,     "inv_xch_rt_dt",   false,      "",      dfNone, 2,     false,       false);
	
			EditableColorDiff = false;
			
			WaitImageVisible = false; 
		}
		break; 
	
		case 5:      
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 10, 100);
	
				var HeadTitle = "|bkg_no|ar_if_no|act_cust_cnt_cd|act_cust_seq|inv_cust_cnt_cd|inv_cust_seq|vsl_cd|skd_voy_no|skd_dir_cd|io_bnd_cd|sail_arr_dt|sail_dt|trnk_vsl_cd|trnk_skd_voy_no|trnk_skd_dir_cd|pol_cd|pod_cd|bl_inv_cfm_dt|ar_ofc_cd|dest_trns_svc_mod_cd";
	
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);        				
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true,true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "bkg_no");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "ar_if_no");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "act_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "act_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "inv_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "inv_cust_seq");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "vsl_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "skd_voy_no");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "skd_dir_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "io_bnd_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "sail_arr_dt");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "sail_dt");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "trnk_vsl_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "trnk_skd_voy_no");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "trnk_skd_dir_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "pol_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "pod_cd");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "bl_inv_cfm_dt");
				InitDataProperty(0, cnt++ , dtData,  70,    daCenter,  true,    "ar_ofc_cd");
				InitDataProperty(0, cnt++ , dtData,  40,    daCenter,  true,    "dest_trns_svc_mod_cd");
				
				WaitImageVisible = false; 
			}
			break;
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
		
		ComOpenWait(true);
		
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
	
		MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	
		var arrStr2 = arrStr[1].split("^");
		var ar_ofc_cd = arrStr2[3];
		formObj.ar_ofc_cd.text = ar_ofc_cd;
		formObj.ofc.value = ar_ofc_cd;
		form.ofc_cd.value = form.ofc.value;
		form.loc_cd.value = arrStr2[6];
		
		ComOpenWait(false);
		break;
	
		case IBSEARCH:      //조회
	
		if(validateForm(sheetObj,formObj,sAction)) return;
		
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0016GS.do" , FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
	
		if (sXml.indexOf("ERROR") < 1){
			if ( sheetObj.id == "sheet1") {
				if ( arrXml[0] != null){
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					//삭제된 데이타의 경우 
					if (sheetObjects[0].CellValue(1, "inv_delt_div_cd") == "X") {
						ComShowCodeMessage("INV00067");
						ComOpenWait(false);
						form.bl_no.select();
						
						return;
					}
	
					form.bl_no.value = sheetObjects[0].CellValue(1, "bl_src_no");
					form.bkg_no.value = sheetObjects[0].CellValue(1, "bkg_no");
					form.if_no.value = sheetObjects[0].CellValue(1, "ar_if_no");
					form.str_inv_no.value = sheetObjects[0].CellValue(1, "inv_no");
					form.act_cust_cnt_cd.value = sheetObjects[0].CellValue(1, "act_cust_cnt_cd");
					form.act_cust_seq.value = ComLpad(sheetObjects[0].CellValue(1, "act_cust_seq"), 6, "0");
					form.cust_nm.value = sheetObjects[0].CellValue(1, "cust_nm");
					form.cust_rgst_no.value = sheetObjects[0].CellValue(1, "cust_rgst_no");
					form.inv_cust_cnt_cd.value = sheetObjects[0].CellValue(1, "inv_cust_cnt_cd");
					form.inv_cust_seq.value = sheetObjects[0].CellValue(1, "inv_cust_seq");
					form.cr_curr_cd.value = sheetObjects[0].CellValue(1, "cr_curr_cd");
					form.cr_amt.value = ComAddCommaRun(sheetObjects[0].CellValue(1, "cr_amt"));
					form.ob_cr_term_dys.value = sheetObjects[0].CellValue(1, "ob_cr_term_dys");
					form.ib_cr_term_dys.value = sheetObjects[0].CellValue(1, "ib_cr_term_dys");
					form.cr_clt_ofc_cd.value = sheetObjects[0].CellValue(1, "cr_clt_ofc_cd");
					form.local_vvd.value = sheetObjects[0].CellValue(1, "local_vvd");
					form.vvd.value = sheetObjects[0].CellValue(1, "vvd");
					form.svc_scp_cd.value = sheetObjects[0].CellValue(1, "svc_scp_cd");
					form.io_bnd_cd.value = sheetObjects[0].CellValue(1, "io_bnd_cd");
					form.sail_arr_dt.value = sheetObjects[0].CellText(1, "sail_arr_dt");
					form.sail_dt.value = sheetObjects[0].CellText(1, "sail_dt");
					form.trunk_vvd.value = sheetObjects[0].CellValue(1, "trunk_vvd");
					form.slan_cd.value = sheetObjects[0].CellValue(1, "slan_cd");
					form.por_cd.value = sheetObjects[0].CellValue(1, "por_cd");
					form.pol_cd.value = sheetObjects[0].CellValue(1, "pol_cd");
					form.pod_cd.value = sheetObjects[0].CellValue(1, "pod_cd");
					form.del_cd.value = sheetObjects[0].CellValue(1, "del_cd");
					form.bkg_corr_no.value = sheetObjects[0].CellValue(1, "bkg_corr_no");
					form.bkg_corr_dt.value = sheetObjects[0].CellText(1, "bkg_corr_dt");
					form.hjs_stf_ctnt.value = sheetObjects[0].CellValue(1, "hjs_stf_ctnt");
					form.inv_ref_no.value = sheetObjects[0].CellValue(1, "inv_ref_no");
					form.bkg_ref_no.value = sheetObjects[0].CellValue(1, "bkg_ref_no");
					form.si_ref_no.value = sheetObjects[0].CellValue(1, "si_ref_no");
					form.inv_rmk.value = sheetObjects[0].CellValue(1, "inv_rmk");
					form.rev_tp_cd.value = sheetObjects[0].CellValue(1, "rev_tp_cd");
					form.rev_src_cd.value = sheetObjects[0].CellValue(1, "rev_src_cd");
					form.mst_bl_no.value = sheetObjects[0].CellValue(1, "mst_bl_no");
					form.rfa_no.value = sheetObjects[0].CellValue(1, "rfa_no");
					form.sc_no.value = sheetObjects[0].CellValue(1, "sc_no");
					form.srep_cd.value = sheetObjects[0].CellValue(1, "srep_cd");
					form.cgo_wgt.value = sheetObjects[0].CellValue(1, "cgo_wgt");
					form.cgo_meas_qty.value = sheetObjects[0].CellValue(1, "cgo_meas_qty");
					form.whf_decl_no.value = sheetObjects[0].CellValue(1, "whf_decl_no");
					form.whf_decl_cfm_dt.value = sheetObjects[0].CellText(1, "whf_decl_cfm_dt");
					form.bkg_teu_qty.value = sheetObjects[0].CellValue(1, "bkg_teu_qty");
					form.bkg_feu_qty.value = sheetObjects[0].CellValue(1, "bkg_feu_qty");
					form.bl_inv_if_dt.value = sheetObjects[0].CellText(1, "bl_inv_if_dt");
					form.bl_inv_cfm_dt.value = sheetObjects[0].CellText(1, "bl_inv_cfm_dt");
					form.gl_eff_dt.value = sheetObjects[0].CellText(1, "gl_eff_dt");
					form.inv_no.value = sheetObjects[0].CellValue(1, "inv_no");
					form.iss_dt.value = sheetObjects[0].CellText(1, "iss_dt");
					form.due_dt.value = sheetObjects[0].CellText(1, "due_dt");
					form.frt_fwrd_cnt_cd.value = sheetObjects[0].CellValue(1, "frt_fwrd_cnt_cd");
					form.frt_fwrd_cust_seq.value = sheetObjects[0].CellValue(1, "frt_fwrd_cust_seq");
					form.cr_flg.value = sheetObjects[0].CellValue(1, "cr_flg");
					form.zn_ioc_cd.value = sheetObjects[0].CellValue(1, "zn_ioc_cd");
					form.cust_cnt_cd.value = form.act_cust_cnt_cd.value;
					form.cust_seq.value = form.act_cust_seq.value;
					form.ofc_cd.value = form.ofc.value;
					form.lcl_curr.value = sheetObjects[0].CellValue(1, "locl_curr_cd");
					form.cr_term_dys.value = sheetObjects[0].CellValue(1, "cr_term_dys");
					form.cust_cr_flg.value = sheetObjects[0].CellValue(1, "cust_cr_flg");
					form.xch_rt_n3rd_tp_cd.value = sheetObjects[0].CellValue(1, "xch_rt_n3rd_tp_cd");
					form.xch_rt_usd_tp_cd.value = sheetObjects[0].CellValue(1, "xch_rt_usd_tp_cd");
					form.xch_rt_dt.value = sheetObjects[0].CellValue(1, "xch_rt_dt");
					form.usd_xch_rt.value = sheetObjects[0].CellValue(1, "usd_xch_rt");
					form.dest_trns_svc_mod_cd.value = sheetObjects[0].CellValue(1, "dest_trns_svc_mod_cd");
					form.inv_svc_scp_cd.value = sheetObjects[0].CellValue(1, "inv_svc_scp_cd");
	
					// 전역변수에 Actual Cust.과 INV Cust.설졍
					act_cust_cd = form.act_cust_cnt_cd.value + form.act_cust_seq.value;
					inv_cust_cd = form.inv_cust_cnt_cd.value + form.inv_cust_seq.value;
					
					//good date null
					if (form.bl_inv_cfm_dt.value == "") {
	
						form.local_vvd.readOnly = false;
						form.trunk_vvd.readOnly = false;
						form.pol_cd.readOnly = false;
						form.pod_cd.readOnly = false;
	
						form.local_vvd.className = "input";
						form.trunk_vvd.className = "input";
						form.pol_cd.className = "input";
						form.pod_cd.className = "input";
	
						if (form.io_bnd_cd.value == "I/B") {
							form.pol_cd.readOnly = true;
							form.pol_cd.className = "input2";
							form.pod_cd.readOnly = false;
							form.pod_cd.className = "input";
						} else {
							form.pol_cd.readOnly = false;
							form.pol_cd.className = "input";
							form.pod_cd.readOnly = true;
							form.pod_cd.className = "input2";
						}
	
					} else {  //good date not null
						form.local_vvd.readOnly = true;
						form.trunk_vvd.readOnly = true;
						form.pol_cd.readOnly = true;
						form.pod_cd.readOnly = true;
	
						form.local_vvd.className = "input2";
						form.trunk_vvd.className = "input2";
						form.pol_cd.className = "input2";
						form.pod_cd.className = "input2";
					}
					
					if (form.inv_no.value == ""||form.inv_dup_flg.value == "Y") {
						form.act_cust_cnt_cd.readOnly = false;
						form.act_cust_seq.readOnly = false;
						form.inv_cust_cnt_cd.readOnly = false;
						form.inv_cust_seq.readOnly = false;
						form.cust_nm.readOnly = false;
						form.cust_rgst_no.readOnly = false;
	
						form.act_cust_cnt_cd.className = "input";
						form.act_cust_seq.className = "input";
						form.inv_cust_cnt_cd.className = "input";
						form.inv_cust_seq.className = "input";
						form.cust_nm.className = "input";
						form.cust_rgst_no.className = "input";
	
						document.all.btn_custSer.style.visibility = "visible";
					} else {
						form.act_cust_cnt_cd.readOnly = true;
						form.act_cust_seq.readOnly = true;
						form.inv_cust_cnt_cd.readOnly = true;
						form.inv_cust_seq.readOnly = true;
						form.cust_nm.readOnly = true;
						form.cust_rgst_no.readOnly = true;
	
						form.act_cust_cnt_cd.className = "input2";
						form.act_cust_seq.className = "input2";
						form.inv_cust_cnt_cd.className = "input2";
						form.inv_cust_seq.className = "input2";
						form.cust_nm.className = "input2";
						form.cust_rgst_no.className = "input2";
	
						document.all.btn_custSer.style.visibility = "hidden";		        						
					}
	
					//2010-01-18 이상희과장 요청 I/B일때만 Inv Ref No 변경 가능
					/*
					if(form.io_bnd_cd.value == "O/B"){
						form.inv_ref_no.readOnly = true;
						form.inv_ref_no.className = "input2";
					}else{
						form.inv_ref_no.readOnly = false;
						form.inv_ref_no.className = "input";
					}
					*/
					//2010-03-26 I/O 모두 Inv Ref No 변경 가능 이상희과장 요청
					//form.inv_ref_no.readOnly = false;
					//form.inv_ref_no.className = "input";
					
					//2010-04-29 이상희과장 요청
					
					if(form.inv_no.value == ""||form.inv_dup_flg.value == "Y"){
						if(form.io_bnd_cd.value == "O/B"){
							form.inv_ref_no.readOnly = true;
							form.inv_ref_no.className = "input2";
						}else{
							form.inv_ref_no.readOnly = false;
							form.inv_ref_no.className = "input";
						}
					}else{
						form.inv_ref_no.readOnly = false;
						form.inv_ref_no.className = "input";
					}
					
					
					form.str_inv_no.readOnly = true;
					document.all.str_inv_no.className = "input2" ;
	
				}
				if ( arrXml[3] != null)	{
					sheetObjects[1].LoadSearchXml(arrXml[3]); 	
				}
				if ( arrXml[1] != null)	{
					sheetObjects[2].LoadSearchXml(arrXml[1]); 	
				}
				if ( arrXml[2] != null)	{
					sheetObjects[3].LoadSearchXml(arrXml[2]); 	
				}
	
				if ( arrXml[4] != null)	{
					sheetObjects[4].LoadSearchXml(arrXml[4]); 	
				}
	
	
				sheetObjects[1].SumText(0,"cntr_no") = "Total";
	
			} 
		} else {
	
			if (form.ots_smry_cd.value == "INV"){
				ComShowCodeMessage("INV00067","INV");
	
			} else {
				ComShowCodeMessage("INV00067","BL");
	
			}
			
			ComOpenWait(false);
			form.bl_no.select();
			
			return;
	
		}
		
		ComOpenWait(false);
	
		break;
	
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)) return;
	
		ComBtnDisable("btn_save");
	
		ComOpenWait(true);  			 	
		
		form.mod_flag.value="N";
		form.act_inv_flag.value="N";
		form.inv_cust_flg.value="N";
			
		for (var i = 1 ; i <= sheetObjects[0].RowCount; i++ ) {
			//sheetObjects[0].CellValue(i, "ibflag") = "U";
			sheetObjects[0].RowStatus(i) = "U";
		}				 	
		for (var i = 1 ; i <= sheetObjects[1].RowCount; i++ ) {
			//sheetObjects[1].CellValue(i, "ibflag") = "U";
			sheetObjects[1].RowStatus(i) = "U";
		}	
		for (var i = 1 ; i <= sheetObjects[2].RowCount; i++ ) {
			//sheetObjects[2].CellValue(i, "ibflag") = "U";
			sheetObjects[2].RowStatus(i) = "U";
		}	
		for (var i = 1 ; i <= sheetObjects[3].RowCount; i++ ) {
			//sheetObjects[3].CellValue(i, "ibflag") = "U";
			sheetObjects[3].RowStatus(i) = "U";
		}
		for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
			//sheetObjects[4].CellValue(i, "ibflag") = "U";
			sheetObjects[4].RowStatus(i) = "U";
		}
	
		if (form.act_cust_seq.value != sheetObjects[0].CellValue(1,"act_cust_seq")||form.act_cust_cnt_cd.value != sheetObjects[0].CellValue(1,"act_cust_cnt_cd")||
				form.inv_cust_seq.value != sheetObjects[0].CellValue(1,"inv_cust_seq")||form.inv_cust_cnt_cd.value != sheetObjects[0].CellValue(1,"inv_cust_cnt_cd")) {
			form.act_inv_flag.value="Y";
		} else {
			form.act_inv_flag.value="N";
		}
	
		if (form.inv_cust_seq.value != sheetObjects[0].CellValue(1,"inv_cust_seq")||form.inv_cust_cnt_cd.value != sheetObjects[0].CellValue(1,"inv_cust_cnt_cd")) {
			form.inv_cust_flg.value="Y";
			form.mod_flag.value="Y";
	
			if(sheetObjects[4].RowCount>0){
				for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
					sheetObjects[4].CellValue2(i, "inv_cust_seq") = form.inv_cust_seq.value;
					sheetObjects[4].CellValue2(i, "inv_cust_cnt_cd") = form.inv_cust_cnt_cd.value;
				}
			}	 			 		
		} else {
			form.inv_cust_flg.value="N";
		}
	
		if (form.act_cust_seq.value != sheetObjects[0].CellValue(1,"act_cust_seq")||form.act_cust_cnt_cd.value != sheetObjects[0].CellValue(1,"act_cust_cnt_cd")) {
			form.mod_flag.value="Y";	 			 		
			if(sheetObjects[4].RowCount>0){
				for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
					sheetObjects[4].CellValue2(i, "act_cust_seq") = form.act_cust_seq.value;
					sheetObjects[4].CellValue2(i, "act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
				}
			}	 			 		
		} 
	
		if (form.local_vvd.value != sheetObjects[0].CellValue(1,"local_vvd")) {
			form.mod_flag.value="Y";	 			 		
			if(sheetObjects[4].RowCount>0){
				for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
					sheetObjects[4].CellValue2(i, "vsl_cd") = form.local_vvd.value.substring(0,4);
					sheetObjects[4].CellValue2(i, "skd_voy_no") = form.local_vvd.value.substring(4,8);
					sheetObjects[4].CellValue2(i, "skd_dir_cd") = form.local_vvd.value.substring(8,9);
				}
			}	 			 		
		}
	
		if (form.pol_cd.value != sheetObjects[0].CellValue(1,"pol_cd")) {
			form.mod_flag.value="Y";	 			 		
			if(sheetObjects[4].RowCount>0){
				for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
					sheetObjects[4].CellValue2(i, "pol_cd") = form.pol_cd.value;
				}
			}	 			 		
		}
	
		if (form.pod_cd.value != sheetObjects[0].CellValue(1,"pod_cd")) {
			form.mod_flag.value="Y";	 			 		
			if(sheetObjects[4].RowCount>0){
				for (var i = 1 ; i <= sheetObjects[4].RowCount; i++ ) {
					sheetObjects[4].CellValue2(i, "pod_cd") = form.pod_cd.value;
				}
			}	 			 		
		}
	
		if(form.mod_flag.value=="Y"){
			fn_vvd_bound_pol_pod_chg();		
		}
		
		if(form.mod_flag.value == "Y" || form.bl_inv_cfm_dt.value == ""){
			var effDt = effectiveDtCheck();
			if(effDt==""){
				ComShowCodeMessage("INV00122");
				ComOpenWait(false); 		
				return;				
			}
		}
		
		if (form.inv_no.value != ""&&form.inv_dup_flg.value != "Y"){
			form.mod_flag.value="N";
			form.act_inv_flag.value="N";
			form.inv_cust_flg.value="N"; 
		}		
	
		formObj.f_cmd.value = MULTI;
	 
		// 커스터머 코드가 바뀌었는지 체크한다.
		var acCustCdTmp = form.act_cust_cnt_cd.value + form.act_cust_seq.value;
		if ((act_cust_cd != acCustCdTmp) || (inv_cust_cd != acCustCdTmp)) {
			formObj.changed_cust_cd.value = "custCdIsChanged";
		}
		
		var sXml = sheetObjects[0].GetSaveXml("FNS_INV_0016GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_") + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(),"sheet2_") + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(),"t2sheet1_") + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(),"t2sheet2_")+ "&" + ComSetPrifix(sheetObjects[4].GetSaveString(),"sheet5_"));
		
		sheetObjects[0].LoadSaveXml(sXml);
		
		ComOpenWait(false); 		
		
		break;
		
		
		case IBSEARCH_ASYNC03: // customer name 조회
		if (formObj.cust_rgst_no.value != ""){
	
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			formObj.ar_ofc_cd2.value = arrStr2[1];
	
			formObj.f_cmd.value = SEARCH16;
			formObj.act_cust_cnt_cd.value = "";
			formObj.act_cust_seq.value = "";
			formObj.cust_cnt_cd.value = "";
			formObj.cust_seq.value = "";
	
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
	
			var deltFlg = ComGetEtcData(sXml,"delt_flg");   
			if (deltFlg == undefined) {		
				formObj.cust_nm.value = "";
				formObj.cust_rgst_no.value = "";
				formObj.cr_curr_cd.value = "";
				formObj.cr_amt.value = "";
				formObj.ob_cr_term_dys.value = "";
				formObj.ib_cr_term_dys.value = "";
				formObj.cr_clt_ofc_cd.value = "";
				ComShowCodeMessage("INV00060");
				return;						
			}else if(deltFlg=='Y'){
				form.cust_nm.value="";
				form.act_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.act_cust_cnt_cd.focus();
				return;
			}
			
			var act_cust_cnt_cd = ComGetEtcData(sXml,"cust_cnt_cd");    
			if (act_cust_cnt_cd != undefined) {
				formObj.act_cust_cnt_cd.value = act_cust_cnt_cd;
			} else {
				formObj.act_cust_cnt_cd.value = "";
			}
			
			var act_cust_seq = ComGetEtcData(sXml,"cust_seq");    
			if (act_cust_seq != undefined) {
				formObj.act_cust_seq.value = ComLpad(act_cust_seq, 6, '0');
			} else {
				formObj.act_cust_seq.value = "";
			}
			
			var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");    
			if (cust_nm != undefined) {
				formObj.cust_nm.value = cust_nm;
			} else {
				formObj.cust_nm.value = "";
			}		
	
			var cust_rgst_no = ComGetEtcData(sXml,"cust_rgst_no");    
			if (cust_rgst_no != undefined) {
				formObj.cust_rgst_no.value = cust_rgst_no;
			} else {
				formObj.cust_rgst_no.value = "";
			}
	
			var cr_curr_cd = ComGetEtcData(sXml,"cr_curr_cd");    
			if (cr_curr_cd != undefined) {
				formObj.cr_curr_cd.value = cr_curr_cd;
			} else {
				formObj.cr_curr_cd.value = "";
			}
	
			var cr_amt = ComGetEtcData(sXml,"cr_amt");    
			if (cr_amt != undefined) {
				formObj.cr_amt.value = ComAddComma(cr_amt);
			} else {
				formObj.cr_amt.value = "";
			}
	
			var ob_cr_term_dys = ComGetEtcData(sXml,"ob_cr_term_dys");    
			if (ob_cr_term_dys != undefined) {
				formObj.ob_cr_term_dys.value = ob_cr_term_dys;
			} else {
				formObj.ob_cr_term_dys.value = "";
			}
	
			var ib_cr_term_dys = ComGetEtcData(sXml,"ib_cr_term_dys");    
			if (ib_cr_term_dys != undefined) {
				formObj.ib_cr_term_dys.value = ib_cr_term_dys;
			} else {
				formObj.ib_cr_term_dys.value = "";
			}
	
			var cr_clt_ofc_cd = ComGetEtcData(sXml,"cr_clt_ofc_cd");    
			if (cr_clt_ofc_cd != undefined) {
				formObj.cr_clt_ofc_cd.value = cr_clt_ofc_cd;
			} else {
				formObj.cr_clt_ofc_cd.value = "";
			}
	
		}
	
		break;
		
	
		}
	}
	
	/**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
	}       
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd.value = colArray[8];
		document.form.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_act_cust_chg();
	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_act_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_act_cust_chg(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		fn_dueDate_chg();
		fn_cust_nm();
	
	}
	
	/**
	 * inv_cust_cnt_cd, inv_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_inv_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.20
	 */
	function fn_inv_cust_chg(){
	
		form.cust_cnt_cd.value = form.inv_cust_cnt_cd.value;
		form.cust_seq.value = form.inv_cust_seq.value;
		form.ofc_cd.value = form.ofc.value;
	
		if(form.inv_cust_seq.value!=''){    		  
			form.inv_cust_seq.value = ComLpad(form.inv_cust_seq.value.trim(), 6, "0");  			  
		}
	
		document.form.f_cmd.value = SEARCH03;
	
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "" )&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			if (cust_nm == undefined) {
				form.cust_seq.value="";
				form.inv_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.inv_cust_cnt_cd.focus();
				return;
	
			} 
	
			if(delt_flg=='Y'){
				form.inv_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.inv_cust_cnt_cd.focus();
				return;
			}
	
		}
	
	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_cust_nm(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
	
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "" )&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
	
			if (cust_nm == undefined) {
				form.cust_nm.value="";
				form.act_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.act_cust_cnt_cd.focus();
				return;
	
			} 
	
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			if(delt_flg=='Y'){
				form.cust_nm.value="";
				form.act_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.act_cust_cnt_cd.focus();
				return;
			}
	
			form.cust_nm.value=cust_nm;
			form.cr_curr_cd.value = ComGetEtcData(sXml,"cr_curr_cd");
			form.cr_amt.value = ComGetEtcData(sXml,"cr_amt");
			form.ob_cr_term_dys.value = ComGetEtcData(sXml,"ob_cr_term_dys");
			form.ib_cr_term_dys.value=ComGetEtcData(sXml,"ib_cr_term_dys");
			form.cr_clt_ofc_cd.value = ComGetEtcData(sXml,"cr_clt_ofc_cd");
			form.cust_rgst_no.value = ComGetEtcData(sXml,"cust_rgst_no");
	
		}
	}     
	
	/**
	 * inv_cust_cnt_cd, inv_cust_seq 변경시 실행되는 function<br>
	 * 경리환율 조회해서 환율 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_ex_rate_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */ 	
	function fn_ex_rate_chg(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH05;
		sheetObjects[3].DataAutoTrim = true;
	
		var count = sheetObjects[3].RowCount("R");
	
		form.lcl_vvd.value = form.local_vvd.value.trim();
	
		for (var i = 1; i < count+1; i++) {
			form.curr_cd.value = sheetObjects[3].CellText(i,"curr_cd"); 
			var sXml = sheetObjects[3].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
	
			sheetObjects[3].CellText(i,"inv_xch_rt") = ComGetEtcData(sXml,"ex_rate");
			sheetObjects[3].CellText(i,"inv_xch_rt_dt") = ComGetEtcData(sXml,"ex_rate_date");
			if (i == 1) {
				form.xch_rt_n3rd_tp_cd.value = ComGetEtcData(sXml,"third_exrate_type");
				form.xch_rt_usd_tp_cd.value = ComGetEtcData(sXml,"usd_exrate_type");
				form.xch_rt_dt.value = ComGetEtcData(sXml,"ex_rate_date");
				form.obrd_cd.value = ComGetEtcData(sXml,"chg_indiv_cd");// oneboard type
			}
	
		}
	
		// usd check
		form.curr_cd.value = "USD";
		var sXml2 = sheetObjects[3].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		form.usd_xch_rt.value = ComGetEtcData(sXml2,"ex_rate");
	}
	
	
	/**
	 * vvd_cd,io_bound,pol_cd,pod_cd 변경시 실행되는 function<br>
	 * sail_arr_dt 조회해서 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_vvd_bound_pol_pod_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_vvd_bound_pol_pod_chg(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH07;
		sheetObjects[3].DataAutoTrim = true;
	
		form.vvd.value = form.local_vvd.value.trim();
		form.bnd.value = form.io_bnd_cd.value.trim().substring(0,1);
	
		if (form.io_bnd_cd.value.trim().substring(0,1) == "O") {
			form.port.value = form.pol_cd.value.trim();  //outbound
		} else {
			form.port.value = form.pod_cd.value.trim();	//inbound
		}
	
		var sXml = sheetObjects[3].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
	
		form.sail_arr_dt.value = ComGetEtcData(sXml,"sail_arr_dt");
	
		fn_dueDate_chg();
		fn_ex_rate_chg();
	
	}
	
	/**
	 * vvd_cd,io_bound,pol_cd,pod_cd,act_cust_cnt_cd,act_cust_seq 변경시 실행되는 function<br>
	 * cr_flg,cr_term_dys,due_date 조회해서 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_dueDate_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_dueDate_chg(){
	
		form.cust_cnt_cd.value = form.act_cust_cnt_cd.value;
		form.cust_seq.value = form.act_cust_seq.value;
		form.ofc_cd.value = form.ofc.value;
		form.cust_rgst_no.value = "";
	
		if(form.act_cust_seq.value!=''){
			document.form.f_cmd.value = SEARCH02;
	
			form.act_cust_seq.value = ComLpad(form.act_cust_seq.value.trim(), 6, "0");
	
			if(form.sail_arr_dt.value!=""){
				var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0016GS.do", FormQueryString(document.form));
	
				form.cust_cr_flg.value = ComGetEtcData(sXml,"cr_flg");
				form.cr_term_dys.value = ComGetEtcData(sXml,"cr_term");
				form.due_dt.value = ComGetMaskedValue(ComGetEtcData(sXml,"due_dt"), "ymd");
			}else{
				form.cust_cr_flg.value = "";
				form.cr_term_dys.value = "";
				form.due_dt.value = "";
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
				InsertTab( cnt++ , "Correction" , -1 );
				InsertTab( cnt++ , "Charge" , -1 );
	
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
	
	
	}
	
	
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:        //조회
	
			var sStr2 = form.ots_smry_cd.value;
			if (sStr2=="INV") {
				
				//2010-04-20 자릿수 validation 삭제
				//if((form.bl_no.value.trim() != "") && (form.bl_no.value.trim().length >= 12)){
				if((form.bl_no.value.trim() != "")){
					document.form.bkg_no.value="";
					document.form.str_inv_no.value="";
					document.form.if_no.value="";
				}
	
				//2010-04-20 자릿수 validation 삭제
				//if( ((form.str_inv_no.value.trim() == "") ||(form.str_inv_no.value.trim().length < 9)) && ((form.bl_no.value.trim() == "") || (form.bl_no.value.trim().length < 12)) ) {
				if( (form.str_inv_no.value.trim() == "") && (form.bl_no.value.trim() == "") ) {						
					ComShowCodeMessage("INV00004");
					form.str_inv_no.focus();
					return true;
				} 
			} else {
	
				document.form.bkg_no.value="";
				document.form.str_inv_no.value="";
				document.form.if_no.value="";
	
				//if ((form.bl_no.value.trim() == "") || (form.bl_no.value.trim().length < 12))  {
				//2010-04-20 자릿수 validation 삭제
				if (form.bl_no.value.trim() == "")  {
					ComShowCodeMessage("INV00004");
					form.bl_no.focus();
					return true;
				} 
			}
	
	
			break;
			case IBSAVE:        //저장
			if (form.if_no.value == "") {
				ComShowCodeMessage("INV00004");
				form.bl_no.focus();
				return true;
			}
	
			if (form.act_cust_cnt_cd.value == "") {
				ComShowCodeMessage("INV00004");
				form.act_cust_cnt_cd.focus();
				return true;
			}
	
			if (form.act_cust_seq.value == "") {
				ComShowCodeMessage("INV00004");
				form.act_cust_seq.focus();
				return true;
			}
	
			if (form.inv_cust_cnt_cd.value == "") {
				ComShowCodeMessage("INV00004");
				form.inv_cust_cnt_cd.focus();
				return true;
			}
	
			if (form.inv_cust_seq.value == "") {
				ComShowCodeMessage("INV00004");
				form.inv_cust_seq.focus();
				return true;
			}
	
			if (form.local_vvd.value == "") {
				ComShowCodeMessage("INV00004");
				form.local_vvd.focus();
				return true;
			}
	
			if (form.pol_cd.value == "") {
				ComShowCodeMessage("INV00004");
				form.pol_cd.focus();
				return true;
			}
	
			if (form.pod_cd.value == "") {
				ComShowCodeMessage("INV00004");
				form.pod_cd.focus();
				return true;
			}
	
			/*
			if (sheetObjects[1].CellValue(sheetObjects[1].LastRow, "teu") != form.bkg_teu_qty.value) {
				ComShowCodeMessage("INV00010");
				form.bkg_teu_qty.focus();
				return true;

			}
			if (sheetObjects[1].CellValue(sheetObjects[1].LastRow, "feu") != form.bkg_feu_qty.value) {
				ComShowCodeMessage("INV00010");
				form.bkg_feu_qty.focus();
				return true;
			}
			 */
			break;
			}
		}     
		return;    
	}
	
	
	function t2sheet2_OnPopupClick(sheetObj, Row,Col){
		alert("popup_click");
	}
	
	function t2sheet1_OnChangeSum( sheetObj, Row )
	{
		sheetObj.SumText(0,"curr_cd") = "Total";
		sheetObj.SumText(0,"locl_curr_cd") = sheetObjects[2].CellValue(1, "locl_curr_cd");		//
		sheetObj.CellAlign(sheetObj.LastRow,"curr_cd") = daCenter;
		sheetObj.CellAlign(sheetObj.LastRow,"locl_curr_cd") = daCenter;
		form.inv_ttl_locl_amt.value = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "local_total");
	
	}
	
	/**
	 * container 팝업 조회<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    open_container();
	 * </pre>
	 * @see FNS_INV_0098
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function open_container() {
		ComOpenPopup('/hanjin/FNS_INV_0098.do?pgmNo=FNS_INV_0098&pagetype=E', 700, 400, '', '0,0');    	
	}
	
	/**
	 * 팝업 FNS_INV_0013 에서 act_cust_cnt_cd,act_cust_seq 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   getPopData(rowArray);
	 * </pre>
	 * @param String rowArray
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getPopData(rowArray){
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd.value = colArray[1];
		document.form.act_cust_seq.value = colArray[2];
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form.ar_ofc_cd,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
	
		arrStr = value.split("^");    	
		document.form.ofc.value = arrStr[1];
		var ar_ofc_cd = arrStr[3];	
		document.form.ofc_cd.value = form.ofc.value;
		document.form.loc_cd.value = arrStr[6];
		document.form.svr_id.value = arrStr[7];
		document.form.inv_dup_flg.value = arrStr[14];
	
		document.form.f_cmd.value = SEARCH;
		var sXml2 = sheetObjects[0].GetSearchXml("FNS_INV_0016GS.do", FormQueryString(document.form));
		var sStr2 = ComGetEtcData(sXml2,"ots_smry_cd");
		document.form.ots_smry_cd.value = sStr2;
	
		if (sStr2=="INV") {
			form.str_inv_no.readOnly = false ;
			document.all.str_inv_no.className = "input" ;
		} else {
			form.str_inv_no.readOnly = true;
			document.all.str_inv_no.className = "input2" ;
		}
	}
	
	/**
	 * effective Date 조회<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    effectiveDtCheck();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.11.11
	 */
	function effectiveDtCheck(){
		document.form.f_cmd.value = SEARCH08;  	      
		var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));  	    	  
		document.form.sail_dt.value = ComGetEtcData(sXml,"sail_dt");
	
		document.form.f_cmd.value = SEARCH09;  	      
		var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));  	    	  
		document.form.gl_eff_dt.value = ComGetEtcData(sXml,"eff_dt");
		document.form.gl_eff_dt.value = ComGetMaskedValue(document.form.gl_eff_dt,"ymd","-");
	
		return ComGetEtcData(sXml,"eff_dt");
	}
	
	function keyEnterRetreive(e){
		if(e.keyCode == '13') {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	} 
	 
	 /**
	 * Customer Name 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    fn_rgst_chg();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fn_rgst_chg() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);		
	} 	 
		
    
	/* 개발자 작업  끝 */