﻿﻿﻿/*
 * ========================================================= 
 * Copyright(c) 2009 CyberLogitec @FileName : esm_bkg_0229_06.js 
 * @FileTitle : e-Booking & SI Process Detail(TRO/O) 
 * Open Issues : 
 * Change history : 
 * @LastModifyDate : 2009.06.22
 * @LastModifier : 전용진 
 * @LastVersion : 1.0 2009.06.22 전용진 1.0
 * Creation 20091101 modified by 이남경
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.30 김영철 [CHM-201006575-01] e-BKG & SI TRO 업데이트 로직 변경
 2010.12.01 김영철 [] eBooking TRO화면에서 오류로 인한 수정 
 2010.12.23 김영철 [] eBooking TRO화면에서 DTL 관련 수정
 2010.12.23 김영철 [] eBooking TRO화면에서 DTL 화면폼 관련 수정 ( 2010.12.24 수정 )
 2010.12.27 김영철 [] eBooking TRO화면에서 Cancel Copy Data 버튼 오류관련 수정
 2011.01.24 김영철 [] eBooking TRO화면에서 Data Copy to ALPS를 클릭시 TRO Detail Max값으로 Seq를 정하는 로직 수정
 2011.01.26 김영철 [] eBooking TRO화면에서 Data Copy to ALPS를 클릭시 TRO Detail TotalRows로 건수를 확인하던걸 RowCount로 수정함.
 2011.04.21 김영출 [CHM-201110189-01] [ALPS] TRO Multi 요청 - eBooking TRO 수신시에 Multi로 들어온 것에 대하여 저장이 가능하도록 수정함.
 * =========================================================
 */
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class esm_bkg_0229_06 : esm_bkg_0229_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_06() {
	this.processButtonClick		  = tprocessButtonClick;
	this.setSheetObject 		  = setSheetObject;
	this.loadPage 				  = loadPage;
	this.initSheet 				  = initSheet;
	this.initControl              = initControl;
	this.doActionIBSheet 		  = doActionIBSheet;
	this.validateForm 		      = validateForm;
	this.change_seq               = change_seq;
	this.click_seq                = click_seq;
	this.changeMasterColor        = changeMasterColor;
	this.seq_rowhidden            = seq_rowhidden;
	this.dataCopy                 = dataCopy;
	this.cancelDtl                = cancelDtl;
	this.addRow                   = addRow;
	this.copyRow                  = copyRow;
	this.changeEnabled_master     = changeEnabled_master;
	this.ComEnableObject_loc      = ComEnableObject_loc;
	this.ComEnableManyObjects_loc = ComEnableManyObjects_loc;
}

/* 개발자 작업 */
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var isCopy = "false";
var dor_addr_tp_str = "|D|C";
var dor_addr_tp_str2 = "|Door|Customs";
var bkg_trsp_mod_cd = "|T|R|F|B|A|U|E";
var bkg_trsp_mod_cd2 = "|Truck|Rail|Feeder|Barge|Rail/Truck|Barge/Truck|Feeder/Truck";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) 
		{
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			isCopy = "false";
			top.isCopyAllRequested = false;
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			break;

		case "btn_datacopytoalps":
			if (isCopy == "false") {
				dataCopy();
			}
			break;  

		case "btn_add":
			addRow(sheetObjects[0], "N", 0);   
			break;

		case "btn_del":
			var nRow = sheetObjects[0].CheckedRows("del_chk");
			if (nRow <= 0) {
				ComShowCodeMessage("BKG00624");
				return false;
			}
			if (!ComShowCodeConfirm("BKG00535")) {
				return false;
			}
			cancelDtl();
			break;

		case "btn_copy":
			copyRow(sheetObjects[0]);
			break;

		case "btn_split":

			var nRow = sheetObjects[0].CheckedRows("del_chk");
			if (nRow <= 0) {
				ComShowCodeMessage("BKG00624");
				return false;
			}
			
			splitRow(sheetObjects[0]);
			break;

		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btns_popActCust":
			var conti_cd        = " ";
			if("US" == parent.frames("t1frame").document.form.bkg_por_cd.value.substr(0,2) ){
				conti_cd        = "M";	//hidden : 대륙코드 
			}
			var cnt_cd          = parent.frames("t1frame").document.form.bkg_por_cd.value.substr(0,2);  //국가코드 -> 사용않함
			var dor_loc_cd      = ""; 
			var act_shpr_cnt_cd = parent.frames("t1frame").document.form.s_cust_cnt_cd.value; 
			var act_shpr_seq    = parent.frames("t1frame").document.form.s_cust_seq.value;
			var act_shpr_nm     = document.form.act_sh.value; 
			var arrAct_shpr_nm  = act_shpr_nm.split(" ");
			act_shpr_nm = arrAct_shpr_nm[0];
			var bkg_no          = formObject.bkg_no.value;
			comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
			break;
		} 
	}catch(e) {
		ComShowMessage(e);
	}
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
 * 기능을 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for(i=0;i<sheetLen;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();
}

function initControl(){
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'form_keypress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);

	applyShortcut();
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1": //alps detail
		//with (sheetObj){
			// 높이 설정
		sheetObj.style.height = 122;
			// 전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo( 1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, false, true, false,false);
			sheetObj.InitHeadMode(false, true, false, true, false, false); 

			var HeadTitle = "|Chk.|Seq|TP/SZ|Q'ty|Door DT/Time|P/Up CY|P/Up CY|Mode|Type|Returm CY|Returm CY|Return DT";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,0,    daCenter,  false,   "ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  false,   "del_chk");
			sheetObj.InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  false,   "tro_sub_seq",    false,  "",      dfNone, 		0,     false,      false); 
			sheetObj.InitDataProperty(0, cnt++ , dtData,   	   45,    daCenter,  false,   "cntr_tpsz_cd",   false,  "",      dfNone,         0,     true,       true, 2);
			sheetObj.InitDataProperty(0, cnt++ , dtData,       45,    daCenter,  false,   "tro_qty",        false,  "",      dfInteger, 	    0,     true,       true, 5);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "dor_arr_dt",     false,  "",      dfUserFormat2,  0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,  	   60,    daCenter,  false,   "pkup_loc_cd",    false,  "",      dfNone, 		0,     true,       true, 5);	
			sheetObj.InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,   "pkup_yd_cd",     false,  "",      dfNone,         0,     true,       true, 2);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,  false,   "bkg_trsp_mzd_cd",false,  "",      dfNone, 		0,     true,        true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,  false,   "dor_addr_tp_cd", false,  "",      dfNone,        0,     true,        true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   "rtn_loc_cd",     false,  "",      dfNone, 		0,     true,       true, 5);
			sheetObj.InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  false,   "rtn_yd_cd",      false,  "",      dfNone, 		0,     true,       true, 2);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "rtn_dt",     false,  "",      dfUserFormat2,  0,     true,       true);
			// dtHidden
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,     40,    daLeft,    false,   "cxl_flg");  
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,     40,    daLeft,    false,   "tro_seq");  
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,     40,    daLeft,    false,   "bkg_trsp_mod_cd");

			sheetObj.InitUserFormat2(0, "dor_arr_dt", "####-##-## ##:##", "-|:" );
			sheetObj.InitUserFormat2(0, "rtn_dt", "####-##-## ##:##", "-|:" );
			sheetObj.InitDataCombo(0, "dor_addr_tp_cd", dor_addr_tp_str2, dor_addr_tp_str);
			sheetObj.InitDataCombo(0, "bkg_trsp_mzd_cd", bkg_trsp_mod_cd2, bkg_trsp_mod_cd);
			sheetObj.InitDataValid(0, 3, vtEngUpOther, "1234567890");
			sheetObj.InitDataValid(0, 6, vtEngUpOther, "1234567890");
			sheetObj.InitDataValid(0, 7, vtEngUpOther, "1234567890");
			sheetObj.InitDataValid(0, 10, vtEngUpOther, "1234567890");
			sheetObj.InitDataValid(0, 11, vtEngUpOther, "1234567890");
			sheetObj.CountPosition = 0;
		//}
		break;

	case "sheet2": //esvc detail
		//with (sheetObj){
			// 높이 설정
		sheetObj.style.height = 145;
			// 전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo( 1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(10, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, true, false, true, false, false);

			var HeadTitle = "|TP/SZ|Q'ty|Door DT/Time|Mode|Type|Return CY|Return DT";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix="sheet2_";
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   "ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtData,     	 80,    daCenter,  false,   "cntr_tpsz_cd",    false,  "",      dfNone,         0,     false,  true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,  false,   "cntr_qty",        false,  "",      dfNone, 		0,     false,  true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,   "dor_rqst_dt",     false,  "",      dfUserFormat2, 	0,     false,  true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,      	 80,    daCenter,  false,   "bkg_trsp_mod_cd",        false,  "",      dfNone, 		0,     false,  true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,      	 80,    daCenter,  false,   "dor_addr_tp_cd",      false,     "",      dfNone,    0,        false,        true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 80,    daCenter,  false,   "cntr_rtn_yd_cd",        false,  "",      dfNone, 		0,     false,  true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,  false,   "cntr_rtn_dt",     false,  "",      dfUserFormat2, 	0,     false,  true);			
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,         0,      daLeft,  false,   "tro_seq");
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,         0,      daLeft,  false,   "tro_sub_seq");

			sheetObj.InitUserFormat2(0, "dor_rqst_dt" , "####-##-## ##:##", "-|:" );
			sheetObj.InitUserFormat2(0, "cntr_rtn_dt" , "####-##-## ##:##", "-|:" );
			
			
//			var bkg_trsp_mod_cd = "|D|C";
//			var bkg_trsp_mod_cd2 = "|D\tDoor|C\tCustoms";
			
			sheetObj.InitDataCombo(0, "dor_addr_tp_cd", dor_addr_tp_str2, dor_addr_tp_str);
			sheetObj.InitDataCombo(0, "bkg_trsp_mod_cd", bkg_trsp_mod_cd2, bkg_trsp_mod_cd);
			
			sheetObj.CountPosition = 0;
		//}
		break;

	case "sheet3": //alps master
		//with (sheetObj){
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo( 1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false,false)

			var HeadTitle = "ibflag|(3)tro_seq|self_trk|request_result|request_date|act_sh|cntc_pson|tel|mobile|zip|addr|rmk|cxl_flg|cfm_flg|is_eur|io_bnd_cd";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix="sheet3_";
			sheetObj.InitDataProperty(0, cnt++ , dtStatus,	 30,     daCenter,  false,   "ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "tro_seq",         false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "ownr_trk_flg",    false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "request_result",  false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "rqst_dt",         false,   "",      dfNone,      0,     true,       true);
			
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "act_shpr_nm",     false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "cntc_pson_nm",    false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "cntc_phn_no",     false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "cntc_mphn_no",    false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "dor_pst_no",      false,   "",      dfNone,      0,     true,       true);
			
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "act_shpr_addr",   false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,   "diff_rmk",        false,   "",      dfNone,      0,     true,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,        0,      daLeft,  false,   "cxl_flg");
			sheetObj.InitDataProperty(0, cnt++ , dtData,        0,      daLeft,  false,   "cfm_flg");
			sheetObj.InitDataProperty(0, cnt++ , dtData,        0,      daLeft,  false,   "is_eur");
			sheetObj.InitDataProperty(0, cnt++ , dtData,        0,      daLeft,  false,   "io_bnd_cd");
			
			sheetObj.CountPosition = 0;
		//}
		break;

	case "sheet4": // esvc master
		//with (sheetObj){
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = 350;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo( 1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(11, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false,false)

			var HeadTitle = "|(4)tro_seq|self_trk|act_sh|cntc_pson|tel|mobile|zip|addr|rmk";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
			// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
			// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet4_";
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,   30,    daCenter,  false,   "ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "tro_seq",        false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "ownr_trk_flg",   false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "act_shpr_nm",    false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "cntc_pson_nm",   false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "cntc_phn_no",    false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "cntc_mphn_no",   false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "dor_pst_no",     false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "act_shpr_addr",  false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,   "diff_rmk",       false,   "",      dfNone,      0,     false,       true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,            0,      daLeft,  false,   "is_eur");

			sheetObj.CountPosition = 0;
		//}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction){
	//sheetObj.ShowDebugMsg = 1;
	switch(sAction) {
	case IBSEARCH_ASYNC01:  
		parent.tabObjects[0].TabBackColor(5) = "#96c792";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	
		break;

	case IBSEARCH: 
		// if(!validateForm(sheetObj,formObj,sAction)) return;

		formObj.alps_seq.value = ""; 
		formObj.self_trk.value = ""; 
		formObj.act_sh.value = ""; 
		formObj.cntc_pson.value = ""; 
		formObj.tel.value = ""; 
		formObj.mobile.value = ""; 
		formObj.dor_pst_no.value = ""; 
		formObj.addr.value = ""; 
		formObj.rmk.value = ""; 
		
		isCopy = "false";

		var sXml = formObj.sXml.value;
		var arrXml = sXml.split("|$$|");
		for(var i = 0; i < arrXml.length; i++) { 
			sheetObjects[i].Redraw = false;    
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
			sheetObjects[i].Redraw = true; 
		}
		formObj.alps_seq.selectedIndex = 0;
		formObj.alps_seq.length=0;
		formObj.xter_seq.length=0;

		var obj = document.getElementById("alps_seq");
		for (var i=0; i<sheetObjects[2].TotalRows; i++) {
			opt = document.createElement("option");
			opt.value = i+1;
			opt.text  = i+1;
			obj.add(opt);
		}
		var obj2 = document.getElementById("xter_seq");
		for (var j=0; j<sheetObjects[3].TotalRows; j++){
			opt2 = document.createElement("option");
			opt2.value = j+1;
			opt2.text  = j+1;
			obj2.add(opt2);
		}
		
		if ( sheetObjects[0].TotalRows > 0){
			if(sheetObjects[0].CellValue(1,"dor_arr_dt").length == 12){
		  		parent.frames("t1frame").document.form.mty_pkup_dt.value = sheetObjects[0].CellValue(1,"dor_arr_dt").substr(0,4) + "-" +
		  																   sheetObjects[0].CellValue(1,"dor_arr_dt").substr(4,2) + "-" +
		  																   sheetObjects[0].CellValue(1,"dor_arr_dt").substr(6,2) ;
			}
	  			
		}

		if ( sheetObjects[2].TotalRows > 0 ){
			var prefix="sheet3_";
			formObj.tro_seq.value        = sheetObjects[2].CellValue(1, "tro_seq");
			formObj.self_trk.value       = sheetObjects[2].CellValue(1, "ownr_trk_flg");
			if (sheetObjects[2].CellValue(1, "ownr_trk_flg") == "Y") {
				formObj.self_trk.checked = true;
			} else {
				formObj.self_trk.checked = false;
			}
			formObj.request_result.value = sheetObjects[2].CellValue(1, "request_result");
			formObj.request_date.value   = sheetObjects[2].CellValue(1, "rqst_dt");
			formObj.act_sh.value         = sheetObjects[2].CellValue(1, "act_shpr_nm");
			formObj.cntc_pson.value      = sheetObjects[2].CellValue(1, "cntc_pson_nm");
			formObj.tel.value            = sheetObjects[2].CellValue(1, "cntc_phn_no");
			formObj.mobile.value         = sheetObjects[2].CellValue(1, "cntc_mphn_no");
			formObj.dor_pst_no.value     = sheetObjects[2].CellValue(1, "dor_pst_no");
			formObj.addr.value           = sheetObjects[2].CellValue(1, "act_shpr_addr");
			formObj.rmk.value            = sheetObjects[2].CellValue(1, "diff_rmk");
			formObj.cxl_flg.value     	 = sheetObjects[2].CellValue(1, "cxl_flg");
			var strBoundCd               = sheetObjects[2].CellValue(1, "io_bnd_cd");
			
			formObj.io_bnd_cd.value      = (strBoundCd == null)? "Y": strBoundCd;
			formObj.is_eur_flg.value     = sheetObjects[2].CellValue(1, "is_eur"); // 구주 TRO인지 여부
			
			checkTroStatus(1);

			// 구주 TRO 건수 - 건수가 있으면 INSERT하지 않고 Skip
			formObj.alps_eur_cnt.value   = sheetObjects[2].TotalRows;	
			if (sheetObjects[2].TotalRows > 0) {
				formObj.tro_alps.value = "Y"; 
			} else {
				formObj.tro_alps.value = "N";
			} 
			for (var i=1; i<sheetObjects[2].Rows; i++) {
				sheetObjects[2].RowStatus(i) = "U";
			}

			seq_rowhidden("sheet3", "1");
			seq_rowhidden("sheet4", "1");
		} 

		if ( sheetObjects[3].TotalRows > 0 ){
			var prefix = "sheet4_";
			formObj.self_trk2.value  = sheetObjects[3].CellValue(1, "ownr_trk_flg");
			if (sheetObjects[3].CellValue(1, "ownr_trk_flg") == "Y"){
				formObj.self_trk2.checked = true;
			}
			formObj.act_sh2.value      = sheetObjects[3].CellValue(1, "act_shpr_nm");
			formObj.cntc_pson2.value   = sheetObjects[3].CellValue(1, "cntc_pson_nm");
			formObj.tel2.value         = sheetObjects[3].CellValue(1, "cntc_phn_no");
			formObj.mobile2.value      = sheetObjects[3].CellValue(1, "cntc_mphn_no");
			formObj.dor_pst_no2.value  = sheetObjects[3].CellValue(1, "dor_pst_no");
			formObj.addr2.value        = sheetObjects[3].CellValue(1, "act_shpr_addr");
			formObj.rmk2.value         = sheetObjects[3].CellValue(1, "diff_rmk");

			// 구주 TRO인지 여부
			formObj.is_eur_flg.value = sheetObjects[3].CellValue(1, "is_eur");  // 첫째
			// row의
			// isEur여부를
			// eur_flg로
			// 함
			if (sheetObjects[3].TotalRows > 0) {
				formObj.tro_esvc.value = "Y"; 
			} else {
				formObj.tro_esvc.value = "N";
			}
		}
		changeMasterColor(formObj);  // cxl_flg checkbox : Master 수정
		checkTroStatus(1);
		// 불가/가능 처리
		if(top.document.form.tabload6.value == "COPY"){
			dataCopy();
		} else {
			compareItem();
		}
		top.document.form.tabload6.value = "LOAD";

		if(parent.frames("t1frame").document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoalps");
		}
		
		/* XTER SEQ를 정리해 줌 */
		var obj = document.getElementById("xter_seq");
		obj.length=0;
		for (var i = 1; i < sheetObjects[3].Rows; i++) {
			opt = document.createElement("option");
			opt.value = i;
			opt.text  = i;
			obj.add(opt);
		}
		change_seq("sheet4", obj);
		
		break;

	case IBSEARCH_ASYNC02:      // Data Copy
		parent.tabObjects[0].TabBackColor(5)="#fff270";

		var isAppend = "true";
		var maxTroSeq = 0;
		var finalTroSeq = 0;
		var troSubSeq = ""
		var troSeqEnd = 0;
		//  From e- Service에 tro master에 해당하는 Row
		for(var i = 1; i <= sheetObjects[3].TotalRows; i++) {
			isAppend = "true";
			// KOR 인경우
			if ( parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) == "KR" ) { 
				if ( troSeqEnd <= sheetObjects[2].TotalRows ) {
					for (var j = eval(troSeqEnd+"+1"); j <= sheetObjects[2].TotalRows; j++) {
						//isAppend = "true";
						//cancel, confirm 건은 copy하지 않음
						if (sheetObjects[2].CellValue(j, "cxl_flg") == "Y" || sheetObjects[2].CellValue(j, "cfm_flg") == "Y") {
							if ( parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) != "KR" ) {
								continue;
							} else if ( sheetObjects[2].CellValue(j, "cxl_flg") == "Y") {
								continue;
							}
						}

						sheetObjects[2].RowStatus(j)   = "U";
						if(!ComIsNull(sheetObjects[3].CellValue(i, "ownr_trk_flg"))){
							sheetObjects[2].CellValue(j, "ownr_trk_flg") = sheetObjects[3].CellValue(i, "ownr_trk_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "request_result"))){
							sheetObjects[2].CellValue(j, "request_result") = sheetObjects[3].CellValue(i, "request_result");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "act_shpr_nm"))){
							sheetObjects[2].CellValue(j, "act_shpr_nm")= sheetObjects[3].CellValue(i, "act_shpr_nm");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_pson_nm"))){
							sheetObjects[2].CellValue(j, "cntc_pson_nm") = sheetObjects[3].CellValue(i, "cntc_pson_nm");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_phn_no"))){
							sheetObjects[2].CellValue(j, "cntc_phn_no") = sheetObjects[3].CellValue(i, "cntc_phn_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_mphn_no"))){
							sheetObjects[2].CellValue(j, "cntc_mphn_no") = sheetObjects[3].CellValue(i, "cntc_mphn_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "dor_pst_no"))){
							sheetObjects[2].CellValue(j, "dor_pst_no") = sheetObjects[3].CellValue(i, "dor_pst_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "act_shpr_addr"))){
							sheetObjects[2].CellValue(j, "act_shpr_addr") = sheetObjects[3].CellValue(i, "act_shpr_addr");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "diff_rmk"))){
							sheetObjects[2].CellValue(j, "diff_rmk") = sheetObjects[3].CellValue(i, "diff_rmk");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cxl_flg"))){
							sheetObjects[2].CellValue(j, "cxl_flg") = sheetObjects[3].CellValue(i, "cxl_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cfm_flg"))){
							sheetObjects[2].CellValue(j, "cfm_flg") = sheetObjects[3].CellValue(i, "cfm_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "is_eur"))){
							sheetObjects[2].CellValue(j, "is_eur") = sheetObjects[3].CellValue(i, "is_eur");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "io_bnd_cd"))){
							sheetObjects[2].CellValue(j, "io_bnd_cd") = sheetObjects[3].CellValue(i, "io_bnd_cd");
						}
						isAppend = "false";
						finalTroSeq = sheetObjects[2].CellValue(j, "tro_seq");
						troSeqEnd = sheetObjects[2].CellValue(j, "tro_seq")
						break;
					}
				}

				maxTroSeq = 1;
				if(sheetObjects[2].RowCount>0) maxTroSeq = parseInt(sheetObjects[2].CellValue(sheetObjects[2].Rows - 1, "tro_seq")) + 1;
				// 일치하는 것이 하나도 없을 경우에는 ALPS쪽에 Row를 하나 추가 하고 값을 넣음
				if ( isAppend == "true" ) {
					var insRow = sheetObjects[2].DataInsert(-1);
					sheetObjects[2].CellValue(insRow, "tro_seq")       = maxTroSeq;
					sheetObjects[2].CellValue(insRow, "ownr_trk_flg")  = sheetObjects[3].CellValue(i, "ownr_trk_flg");
					sheetObjects[2].CellValue(insRow, "request_result")= sheetObjects[3].CellValue(i, "request_result");
					sheetObjects[2].CellValue(insRow, "act_shpr_nm")   = sheetObjects[3].CellValue(i, "act_shpr_nm");
					sheetObjects[2].CellValue(insRow, "cntc_pson_nm")  = sheetObjects[3].CellValue(i, "cntc_pson_nm");
					sheetObjects[2].CellValue(insRow, "cntc_phn_no")   = sheetObjects[3].CellValue(i, "cntc_phn_no");
					sheetObjects[2].CellValue(insRow, "cntc_mphn_no")  = sheetObjects[3].CellValue(i, "cntc_mphn_no");
					sheetObjects[2].CellValue(insRow, "dor_pst_no")    = sheetObjects[3].CellValue(i, "dor_pst_no");
					sheetObjects[2].CellValue(insRow, "act_shpr_addr") = sheetObjects[3].CellValue(i, "act_shpr_addr");
					sheetObjects[2].CellValue(insRow, "diff_rmk")      = sheetObjects[3].CellValue(i, "diff_rmk");
					sheetObjects[2].CellValue(insRow, "cxl_flg")       = sheetObjects[3].CellValue(i, "cxl_flg");
					sheetObjects[2].CellValue(insRow, "cfm_flg")       = sheetObjects[3].CellValue(i, "cfm_flg");
					sheetObjects[2].CellValue(insRow, "is_eur")        = sheetObjects[3].CellValue(i, "is_eur");
					sheetObjects[2].CellValue(insRow, "io_bnd_cd")     = sheetObjects[3].CellValue(i, "io_bnd_cd");				
					sheetObjects[2].RowStatus(insRow)                  = "I";
					finalTroSeq       								   = maxTroSeq;
				}
				
				
				// From e- Service에 TRO detail에 해당하는 Row 개수를 기준으로 넣는다
				for(var k = 1; k <= sheetObjects[1].TotalRows; k++) {
					isAppend = "true";
					// Booking Data ALPS로 Copy 한다.
					for (var j = 1; j <= sheetObjects[0].TotalRows; j++) {
						if (sheetObjects[1].CellValue(k, "tro_seq")     == sheetObjects[3].CellValue(i, "tro_seq") &&
							sheetObjects[0].CellValue(j, "tro_seq")     == finalTroSeq &&
							sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == sheetObjects[1].CellValue(k, "cntr_tpsz_cd") &&
							sheetObjects[0].CellValue(j, "cxl_flg")   != "Y" ) {
							
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_tpsz_cd"))){
								sheetObjects[0].CellValue(j, "cntr_tpsz_cd") = sheetObjects[1].CellValue(k, "cntr_tpsz_cd");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_qty"))){
								sheetObjects[0].CellValue(j, "tro_qty")      = sheetObjects[1].CellValue(k, "cntr_qty");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "dor_rqst_dt"))){
								sheetObjects[0].CellValue(j, "dor_arr_dt")   = sheetObjects[1].CellValue(k, "dor_rqst_dt");
							}
							sheetObjects[0].RowStatus(j)   = "U";
							isAppend = "false";

							break;
						}
					}

					// 일치하는 것이 하나도 없을 경우에는 ALPS쪽에 Row를 하나 추가 하고 값을 넣음
					if ( isAppend == "true" && 
						 sheetObjects[1].CellValue(k, "tro_seq") == sheetObjects[3].CellValue(i, "tro_seq") &&
						 sheetObjects[1].CellValue(k, "tro_seq") == finalTroSeq ) {
							troSubSeq = 0;
							for (var j = 1; j <= sheetObjects[0].RowCount; j++) {
								if ( sheetObjects[0].CellValue(j, "tro_seq")     == finalTroSeq ){
									troSubSeq = sheetObjects[0].CellValue(j, "tro_sub_seq");
								}
							}
							
							var insRow = sheetObjects[0].DataInsert(-1);
							sheetObjects[0].CellValue(insRow, "tro_seq")      = finalTroSeq;
							sheetObjects[0].CellValue(insRow, "tro_sub_seq")  = eval(troSubSeq+"+1");
							sheetObjects[0].CellValue(insRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(k, "cntr_tpsz_cd");
							sheetObjects[0].CellValue(insRow, "tro_qty")      = sheetObjects[1].CellValue(k, "cntr_qty");
							sheetObjects[0].CellValue(insRow, "dor_arr_dt")   = sheetObjects[1].CellValue(k, "dor_rqst_dt");
							sheetObjects[0].RowStatus(insRow)   = "I";

					}
				} 

				for (var j = 1; j <= sheetObjects[0].TotalRows; j++) {
					if ( sheetObjects[0].CellValue(j, "tro_seq")     == finalTroSeq &&
						 sheetObjects[0].RowStatus(j)   != "D" ){
						
						if (sheetObj.CellValue(j, "ibflag") != "I" && sheetObj.CellValue(j, "ibflag") != "U"){
							//추가된 row를 제외하고는 취소 처리
							sheetObj.CellValue2    (j, "cxl_flg") = "Y";
							sheetObj.RangeFontColor(j, 0, j, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); 
							sheetObj.CellFont("FontStrikethru", j, 0, j, sheetObj.LastCol) = true; 
							sheetObj.RowEditable(j) = false;
						}
					}
				}
				// KOR 인경우 END
			} else { 
				// KOR 이 아닌경우
				// eSvc data를 ALPS로 Copy 한다.
				for (var j = 1; j <= sheetObjects[2].TotalRows; j++) {
								
					if (sheetObjects[2].CellValue(j, "tro_seq") == sheetObjects[3].CellValue(i, "tro_seq")) {
						isAppend = "false";
						//cancel, confirm 건은 copy하지 않음
						if (sheetObjects[2].CellValue(j, "cxl_flg") == "Y" || sheetObjects[2].CellValue(j, "cfm_flg") == "Y") {
							continue;
						}

						sheetObjects[2].RowStatus(j)   = "U";
						if(!ComIsNull(sheetObjects[3].CellValue(i, "ownr_trk_flg"))){
							sheetObjects[2].CellValue(j, "ownr_trk_flg") = sheetObjects[3].CellValue(i, "ownr_trk_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "request_result"))){
							sheetObjects[2].CellValue(j, "request_result") = sheetObjects[3].CellValue(i, "request_result");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "act_shpr_nm"))){
							sheetObjects[2].CellValue(j, "act_shpr_nm")= sheetObjects[3].CellValue(i, "act_shpr_nm");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_pson_nm"))){
							sheetObjects[2].CellValue(j, "cntc_pson_nm") = sheetObjects[3].CellValue(i, "cntc_pson_nm");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_phn_no"))){
							sheetObjects[2].CellValue(j, "cntc_phn_no") = sheetObjects[3].CellValue(i, "cntc_phn_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cntc_mphn_no"))){
							sheetObjects[2].CellValue(j, "cntc_mphn_no") = sheetObjects[3].CellValue(i, "cntc_mphn_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "dor_pst_no"))){
							sheetObjects[2].CellValue(j, "dor_pst_no") = sheetObjects[3].CellValue(i, "dor_pst_no");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "act_shpr_addr"))){
							sheetObjects[2].CellValue(j, "act_shpr_addr") = sheetObjects[3].CellValue(i, "act_shpr_addr");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "diff_rmk"))){
							sheetObjects[2].CellValue(j, "diff_rmk") = sheetObjects[3].CellValue(i, "diff_rmk");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cxl_flg"))){
							sheetObjects[2].CellValue(j, "cxl_flg") = sheetObjects[3].CellValue(i, "cxl_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "cfm_flg"))){
							sheetObjects[2].CellValue(j, "cfm_flg") = sheetObjects[3].CellValue(i, "cfm_flg");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "is_eur"))){
							sheetObjects[2].CellValue(j, "is_eur") = sheetObjects[3].CellValue(i, "is_eur");
						}
						if(!ComIsNull(sheetObjects[3].CellValue(i, "io_bnd_cd"))){
							sheetObjects[2].CellValue(j, "io_bnd_cd") = sheetObjects[3].CellValue(i, "io_bnd_cd");
						}
						break;
					}
				}
			
				maxTroSeq = 1;
				if(sheetObjects[2].RowCount>0) maxTroSeq = parseInt(sheetObjects[2].CellValue(sheetObjects[2].Rows - 1, "tro_seq")) + 1;
				// 일치하는 것이 하나도 없을 경우에는 ALPS쪽에 Row를 하나 추가 하고 값을 넣음
				if ( isAppend == "true" ) {
					var insRow = sheetObjects[2].DataInsert(-1);
					sheetObjects[2].CellValue(insRow, "tro_seq")       = maxTroSeq;
					sheetObjects[2].CellValue(insRow, "ownr_trk_flg")  = sheetObjects[3].CellValue(i, "ownr_trk_flg");
					sheetObjects[2].CellValue(insRow, "request_result")= sheetObjects[3].CellValue(i, "request_result");
					sheetObjects[2].CellValue(insRow, "act_shpr_nm")   = sheetObjects[3].CellValue(i, "act_shpr_nm");
					sheetObjects[2].CellValue(insRow, "cntc_pson_nm")  = sheetObjects[3].CellValue(i, "cntc_pson_nm");
					sheetObjects[2].CellValue(insRow, "cntc_phn_no")   = sheetObjects[3].CellValue(i, "cntc_phn_no");
					sheetObjects[2].CellValue(insRow, "cntc_mphn_no")  = sheetObjects[3].CellValue(i, "cntc_mphn_no");
					sheetObjects[2].CellValue(insRow, "dor_pst_no")    = sheetObjects[3].CellValue(i, "dor_pst_no");
					sheetObjects[2].CellValue(insRow, "act_shpr_addr") = sheetObjects[3].CellValue(i, "act_shpr_addr");
					sheetObjects[2].CellValue(insRow, "diff_rmk")      = sheetObjects[3].CellValue(i, "diff_rmk");
					sheetObjects[2].CellValue(insRow, "cxl_flg")       = sheetObjects[3].CellValue(i, "cxl_flg");
					sheetObjects[2].CellValue(insRow, "cfm_flg")       = sheetObjects[3].CellValue(i, "cfm_flg");
					sheetObjects[2].CellValue(insRow, "is_eur")        = sheetObjects[3].CellValue(i, "is_eur");
					sheetObjects[2].CellValue(insRow, "io_bnd_cd")     = sheetObjects[3].CellValue(i, "io_bnd_cd");				
					sheetObjects[2].RowStatus(insRow)                  = "I";
					finalTroSeq       								   = maxTroSeq;
				}

				isAppend = "true";
				// From e- Service에 TRO detail에 해당하는 Row 개수를 기준으로 넣는다
				for(var k = 1; k <= sheetObjects[1].TotalRows; k++) {
					// Booking Data ALPS로 Copy 한다.
					for (var j = 1; j <= sheetObjects[0].TotalRows; j++) {
						if (sheetObjects[0].CellValue(j, "tro_seq")     == sheetObjects[1].CellValue(k, "tro_seq") &&
							sheetObjects[0].CellValue(j, "tro_sub_seq") == sheetObjects[1].CellValue(k, "tro_sub_seq")) {
						
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_tpsz_cd"))){
								sheetObjects[0].CellValue(j, "cntr_tpsz_cd") = sheetObjects[1].CellValue(k, "cntr_tpsz_cd");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_qty"))){
								sheetObjects[0].CellValue(j, "tro_qty")      = sheetObjects[1].CellValue(k, "cntr_qty");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "dor_rqst_dt"))){
								sheetObjects[0].CellValue(j, "dor_arr_dt")   = sheetObjects[1].CellValue(k, "dor_rqst_dt");
							}
							
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_rtn_dt"))){
								sheetObjects[0].CellValue(j, "rtn_dt")   = sheetObjects[1].CellValue(k, "cntr_rtn_dt");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "cntr_rtn_yd_cd"))){
								sheetObjects[0].CellValue(j, "rtn_loc_cd")   = sheetObjects[1].CellValue(k, "cntr_rtn_yd_cd").substring(0,5);
								sheetObjects[0].CellValue(j, "rtn_yd_cd")   = sheetObjects[1].CellValue(k, "cntr_rtn_yd_cd").substring(5,7);
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "dor_addr_tp_cd"))){
								sheetObjects[0].CellValue(j, "dor_addr_tp_cd")   = sheetObjects[1].CellValue(k, "dor_addr_tp_cd");
							}
							if(!ComIsNull(sheetObjects[1].CellValue(k, "bkg_trsp_mod_cd"))){
								sheetObjects[0].CellValue(j, "bkg_trsp_mzd_cd")   = sheetObjects[1].CellValue(k, "bkg_trsp_mod_cd");
							}
							
							sheetObjects[0].RowStatus(j)   = "U"; 
							isAppend = "false";    
							break;
						}
					}					
					// 일치하는 것이 하나도 없을 경우에는 ALPS쪽에 Row를 하나 추가 하고 값을 넣음
					if ( isAppend == "true" && sheetObjects[1].CellValue(k, "tro_seq") == finalTroSeq ) {
						var insRow = sheetObjects[0].DataInsert(-1);
						sheetObjects[0].CellValue(insRow, "tro_seq")      = sheetObjects[1].CellValue(k, "tro_seq");
						sheetObjects[0].CellValue(insRow, "tro_sub_seq")  = sheetObjects[1].CellValue(k, "tro_sub_seq");
						sheetObjects[0].CellValue(insRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(k, "cntr_tpsz_cd");
						sheetObjects[0].CellValue(insRow, "tro_qty")      = sheetObjects[1].CellValue(k, "cntr_qty");
						sheetObjects[0].CellValue(insRow, "dor_arr_dt")   = sheetObjects[1].CellValue(k, "dor_rqst_dt");
						
						sheetObjects[0].CellValue(insRow, "rtn_dt")   = sheetObjects[1].CellValue(k, "cntr_rtn_dt");
						sheetObjects[0].CellValue(insRow, "rtn_loc_cd")   = sheetObjects[1].CellValue(k, "cntr_rtn_yd_cd").substring(0,5);
						sheetObjects[0].CellValue(insRow, "rtn_yd_cd")   = sheetObjects[1].CellValue(k, "cntr_rtn_yd_cd").substring(5,7);
						sheetObjects[0].CellValue(insRow, "dor_addr_tp_cd")   = sheetObjects[1].CellValue(k, "dor_addr_tp_cd");
						sheetObjects[0].CellValue(insRow, "bkg_trsp_mzd_cd")   = sheetObjects[1].CellValue(k, "bkg_trsp_mod_cd");
						sheetObjects[0].RowStatus(insRow)   = "I";
					}
				}				
			}

		} 
		// KOR 이 아닌경우 END
		
		/* ALPS SEQ를 정리해 줌 */
		var obj = document.getElementById("alps_seq");
		obj.length=0;
		for (var i = 1; i < sheetObjects[2].Rows; i++) {
			opt = document.createElement("option");
			opt.value = i;
			opt.text  = i;
			obj.add(opt);
		}
		if ( parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) == "KR" ) formObj.alps_seq.selectedIndex = finalTroSeq-1;
		// sheet의 data를 화면에 load함
		change_seq("sheet3", obj);
		
		compareItem();
		isCopy = "true";
		break;

	case IBSAVE:      // Save
		if (validateForUpload() == false) return false;
		var sParam = getSaveStringForUpload();
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_06GS.do", sParam);

		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
			// 01. msg
			ComBkgSaveCompleted(); 

			var param = parent.document.all.t6frame.document.form.param_data.value;
			parent.document.all.t6frame.src = "ESM_BKG_0229_06.do"+param;
		} else {
			sheetObjects[2].LoadSaveXml(sXml); 
		}
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSAVE:			
			var mtyPkupYdCd = parent.document.frames("t1frame").form.mty_pkup_yd_cd.value;
			var bkgPorCd = parent.document.frames("t1frame").document.form.bkg_por_cd.value.substring(0,2);
			var bkgPolCd = parent.document.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2);
			if(mtyPkupYdCd == '' && (bkgPorCd = 'KR' || bkgPolCd == 'KR')){
				
				
				
				var krTel = formObj.tel.value;
				if(krTel.indexOf('-')){
					krTel = krTel.split('-')[0];
				}
				if(krTel == '02' || krTel == '031' || krTel == '032'){
					parent.document.frames("t1frame").form.mty_pkup_yd_cd.value = 'KRSEL1H';
				} else if(krTel == '061' || krTel == '062' || krTel == '063'){
					parent.document.frames("t1frame").form.mty_pkup_yd_cd.value = 'KRKANY4';
				}
			}
			
			if((bkgPorCd = 'KR' || bkgPolCd == 'KR') && parent.frames("t1frame").document.form.route_modify_flag.value == "Y"){
				for(var k = 1; k <= sheetObjects[0].TotalRows; k++) {
					sheetObjects[0].CellValue(k, "pkup_loc_cd") = "";
					sheetObjects[0].CellValue(k, "pkup_yd_cd") = "";
					sheetObjects[0].CellValue(k, "rtn_loc_cd") = "";
					sheetObjects[0].CellValue(k, "rtn_yd_cd") = "";
				}
			}
			
			if(parent.frames("t1frame").document.form.doc_tp_cd.value == "B"){
				//validation 하지 않음 20100311 신은영 차장 요청
//				//MST VALIDATION
//				var porCntCd = parent.frames("t1frame").document.form.bkg_por_cd.value.substr(0,2);
//				for(var i=1; i<=sheetObjects[2].RowCount; i++) {
//				    var sheetObj = sheetObjects[2];				
//				    var tro_seq = sheetObj.CellValue(i, "tro_seq");
//				    //cancel이 아니것만 validation  
//				    if (sheetObj.CellValue(i, "cxl_flg") == "Y"){
//				        continue; 
//				    }
//	
//				    //Actual Customer Nm : act_shpr_nm
//				    if (ComIsNull(sheetObj.CellValue(i, "act_shpr_nm"))) {
//				        ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", Actual Customer Name");
//				        return false;
//				    }
//	
//				    //Zip : dor_pst_no
//				    if ("US" == porCntCd && ComIsNull(sheetObj.CellValue(i, "dor_pst_no"))) {
//				        ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", Zip");
//				        return false;
//				    }
//				}
//		
//				//DTL VALIDATION
//			   	for (var i=1; i<=sheetObjects[0].RowCount; i++) {
//				    var sheetObj = sheetObjects[0];
//			   		var tro_seq = sheetObj.CellValue(i, "tro_seq");
//			   		var tro_sub_seq = sheetObj.CellValue(i, "tro_sub_seq");
//	
//		    		if(sheetObj.CellValue(i, "cxl_flg") == "Y"){
//		    			continue; 
//		    		}
//	
//			   		// TP/SZ
//		   			if (ComIsNull(sheetObj.CellValue(i, "cntr_tpsz_cd"))) {   
//		   		    	ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", TP/SZ");
//		   				return false;
//		   			}
//	
//		   			// Qty
//		   			if (ComIsNull(sheetObj.CellValue(i, "tro_qty"))||sheetObj.CellValue(i, "tro_qty")=="0") {
//		   		    	ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", Qty");
//		   				return false;
//		   			}
//	
//		   		    // Arrival dt
//					if (ComIsNull(sheetObj.CellValue(i, "dor_arr_dt"))) {
//						ComShowCodeMessage("COM12138", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", Door Arrival Date");
//						return false; 
//					}
//			   	}
//	
				// 하지 않음(20100330 신은영 차장님 요청)
				//vol validation
//			   	var bkgQtyTpSz = new Array();
//			   	var bkgQtyTpSzVol = new Array();
//			   	var bkgQtySheetObj = parent.frames("t1frame").sheetObjects[0];
//			    var sheetObj = sheetObjects[0];
//			    // bkg qty에 없는 type/size는 tro 불가
//			   	for (var i=1; i<=sheetObj.RowCount; i++) {
//					if(bkgQtySheetObj.FindText("cntr_tpsz_cd", sheetObj.CellValue(i, "cntr_tpsz_cd")) < 0){
//			   			ComShowCodeMessage("COM12133", "["+sheetObj.CellValue(i, "cntr_tpsz_cd")+"] Total Qty", "or equal to the BKG Qty", "lesser");
//			   			return false;
//					}
//				}
//			    // bkg qty의 vol보다 크게 tro입력 불가
//				var troTpSzCnt = 0;
//			   	for(var i=1;i<=bkgQtySheetObj.RowCount;i++){
//			   		bkgQtyTpSz   [i] = bkgQtySheetObj.CellValue(i, "cntr_tpsz_cd");
//			   		bkgQtyTpSzVol[i] = bkgQtySheetObj.CellValue(i, "op_cntr_qty");
//	
//			   		troTpSzCnt = 0;
//			   		for(var j=1;j<=sheetObj.RowCount;j++){			   			
//			   			if(bkgQtyTpSz[i] == sheetObj.CellValue(j, "cntr_tpsz_cd")){
//			   				if(sheetObjects[2].CellValue(parseInt(sheetObj.CellValue(j, "tro_seq")), "cxl_flg")=="Y"){
//			   					continue;
//			   				}
//			   				if(sheetObj.CellValue(j, "cxl_flg")!="Y"){
//			   					troTpSzCnt++;
//			   				}
//			   			}		   			
//			   		}
//			   		if(troTpSzCnt>bkgQtyTpSzVol[i]){
//			   			ComShowCodeMessage("COM12133", "["+bkgQtyTpSz[i]+"] Total Qty", "or equal to the BKG Qty", "lesser");
//			   			return false;
//			   		}
//			   	}
			}		   	
		break;
	}
	return true;
}
		
/**
 * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 Validate
 * 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동 Focus
 * 이동까지 한 후 return false
 */
function validateForUpload() {
	doTroSaveCopy();
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 각 화면에서
 * Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	var formObj = document.form;

	var sXml = formObj.sXml.value;
	formObj.sXml.value = null;
	formObj.f_cmd.value = MULTI; 
	formObj.f_del_flg.value = "N";
	formObj.curr_tro_seq.value = formObj.alps_seq.value;
	
	for (var i=0; i<sheetObjects[2].TotalRows; i++) {
		if(sheetObjects[2].CellValue(i+1,"cfm_flg")=="Y"||sheetObjects[2].CellValue(i+1,"cxl_flg")=="Y"){
			if ( parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) != "KR" ) {
				return "";
			} else {
				sheetObjects[2].CellValue(i+1,"cfm_flg") = "N";
			}
		}
	}
	
	for (var i=0; i<sheetObjects[0].TotalRows; i++) {
		sheetObjects[0].CellValue(i+1,"bkg_trsp_mod_cd")=sheetObjects[0].CellValue(i+1,"bkg_trsp_mzd_cd");
	}
	
	
	
	var sParam1 = ComSetPrifix(sheetObjects[2].GetSaveString(true), "sheet3_");
	var sParam2 = ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
	var sParam = FormQueryString(formObj, false);

	if(sheetObjects[2].RowCount>0){
		formObj.sXml.value = sXml;
		sParam += "&" + sParam1; 
		sParam += "&" + sParam2; 
	} else {
		sParam = ""
	}
	return sParam;
}

function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

//Container 리스트를 저장용 sheet로 Copy
function doTroSaveCopy() {
	var formObj = document.form;
	var curSeq = ComGetObjValue(formObj.alps_seq);
	if (!ComIsNull(curSeq)) {
		if(sheetObjects[2].RowCount<1){ //1 row는 header임
			sheetObjects[2].DataInsert(-1);
		}
		sheetObjects[2].CellValue2(curSeq, "tro_seq") 		= curSeq;
		sheetObjects[2].CellValue2(curSeq, "ownr_trk_flg") 	= formObj.self_trk.checked?"Y":"N";
		sheetObjects[2].CellValue2(curSeq, "act_shpr_nm") 	= formObj.act_sh.value;
		sheetObjects[2].CellValue2(curSeq, "cntc_pson_nm") 	= formObj.cntc_pson.value;
		sheetObjects[2].CellValue2(curSeq, "cntc_phn_no") 	= formObj.tel.value;
		sheetObjects[2].CellValue2(curSeq, "cntc_mphn_no") 	= formObj.mobile.value;
		sheetObjects[2].CellValue2(curSeq, "dor_pst_no") 	= formObj.dor_pst_no.value;
		sheetObjects[2].CellValue2(curSeq, "act_shpr_addr") = formObj.addr.value;
		sheetObjects[2].CellValue2(curSeq, "diff_rmk") 		= formObj.rmk.value;
		sheetObjects[2].CellValue2(curSeq, "io_bnd_cd") 	= "O";
	}
}

//색 비교 처리
function compareItem() {
	var formObj = document.form;
	click_seq(document.getElementById("alps_seq"));
	var curAlpsSeq = formObj.alps_seq.value;
	var curEsvcSeq = formObj.xter_seq.value;
	for(var alpsSeq=1;alpsSeq<sheetObjects[2].Rows;alpsSeq++){
		for(var esvcSeq=1;esvcSeq<sheetObjects[3].Rows;esvcSeq++){
			if(curEsvcSeq!=esvcSeq) continue;
			if(alpsSeq == esvcSeq){
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "act_shpr_nm"),   	sheetObjects[3].CellValue(esvcSeq, "act_shpr_nm"),   	"act_sh2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "cntc_pson_nm"),   sheetObjects[3].CellValue(esvcSeq, "cntc_pson_nm"),   "cntc_pson2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "cntc_phn_no"),   	sheetObjects[3].CellValue(esvcSeq, "cntc_phn_no"),  		"tel2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "cntc_mphn_no"),   sheetObjects[3].CellValue(esvcSeq, "cntc_mphn_no"),   	"mobile2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "dor_pst_no"), 	sheetObjects[3].CellValue(esvcSeq, "dor_pst_no"),  "dor_pst_no2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "act_shpr_addr"),  sheetObjects[3].CellValue(esvcSeq, "act_shpr_addr"),   		"addr2");
				setDiffCheckColor(sheetObjects[2].CellValue(alpsSeq, "diff_rmk"),   	sheetObjects[3].CellValue(esvcSeq, "diff_rmk"),   		"rmk2");
			}
		}
	}			
}

function form_keypress(){
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	switch(event.srcElement.dataformat){
	case "int":
		// 숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		// 숫자+".-_"입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		// 영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		// 영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
    case "tel":
        // 숫자+"-"입력하기
        ComKeyOnlyNumber(event.srcElement, "-"); 
        break;
	case "etc": // 모든 문자 가능하지만 영문은 대문자로
		if(keyValue >= 97 && keyValue <= 122) {// 소문자
			event.keyCode = keyValue + 65 - 97;
		}
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

function form_onChange(){
	var srcName = event.srcElement.getAttribute("name");
	var formObj = document.form;  
	
//	isCopy = "false";
	
	if (sheetObjects[2].RowCount > 0 ){
		if(sheetObjects[2].CellValue(formObj.alps_seq.value, "ibflag")=="R"){
			sheetObjects[2].RowStatus(formObj.alps_seq.value) = "U";
		}
	}
	
	compareItem();
}
/**
 * AddRow시, 처리로직 제어
 */
function addRow(sheetObj, NCflag, nCopyRow) {
	//alps dtl만 처리  	  
	if (sheetObj.id == "sheet1"){
		var formObj = document.form;  
			      
		var prevMaxTroSubSeq = 0;
		for(var i=1;i<=sheetObj.RowCount;i++){
			if(prevMaxTroSubSeq<parseInt(sheetObj.CellValue(i, "tro_sub_seq"))){
				prevMaxTroSubSeq = parseInt(sheetObj.CellValue(i, "tro_sub_seq"));
			}
		}
		// 01. 신규행 추가
		var nNewRow = sheetObj.DataInsert(-1);	
		sheetObj.CellValue2(nNewRow, "tro_seq")     = formObj.alps_seq.value;  // 현재, tro_seq
		sheetObj.CellValue2(nNewRow, "tro_sub_seq") = parseInt(prevMaxTroSubSeq) + 1;
		sheetObj.CellValue2(nNewRow, "tro_qty")     = 1; 
		sheetObj.CellValue2(nNewRow, "cxl_flg")     = "N"; 

		// 03. dtl copy
		if (NCflag == "C") {  
			sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd") = sheetObj.CellValue(nCopyRow, "cntr_tpsz_cd"); 
			sheetObj.CellValue2(nNewRow, "tro_qty")      = sheetObj.CellValue(nCopyRow, "tro_qty");
			sheetObj.CellValue2(nNewRow, "dor_arr_dt")   = sheetObj.CellValue(nCopyRow, "dor_arr_dt");
			sheetObj.CellValue2(nNewRow, "pkup_loc_cd")  = sheetObj.CellValue(nCopyRow, "pkup_loc_cd");
			sheetObj.CellValue2(nNewRow, "pkup_yd_cd")   = sheetObj.CellValue(nCopyRow, "pkup_yd_cd");
			sheetObj.CellValue2(nNewRow, "rtn_loc_cd")   = sheetObj.CellValue(nCopyRow, "rtn_loc_cd"); 
			sheetObj.CellValue2(nNewRow, "rtn_yd_cd")    = sheetObj.CellValue(nCopyRow, "rtn_yd_cd");	
			sheetObj.CellValue2(nNewRow, "cxl_flg")      = "N";	
		}
		if (NCflag == "S") {  
			sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd") = sheetObj.CellValue(nCopyRow, "cntr_tpsz_cd"); 
			sheetObj.CellValue2(nNewRow, "tro_qty")      = 1;
			sheetObj.CellValue2(nNewRow, "dor_arr_dt")   = sheetObj.CellValue(nCopyRow, "dor_arr_dt");
			sheetObj.CellValue2(nNewRow, "pkup_loc_cd")  = sheetObj.CellValue(nCopyRow, "pkup_loc_cd");
			sheetObj.CellValue2(nNewRow, "pkup_yd_cd")   = sheetObj.CellValue(nCopyRow, "pkup_yd_cd");
			sheetObj.CellValue2(nNewRow, "rtn_loc_cd")   = sheetObj.CellValue(nCopyRow, "rtn_loc_cd"); 
			sheetObj.CellValue2(nNewRow, "rtn_yd_cd")    = sheetObj.CellValue(nCopyRow, "rtn_yd_cd");	
			sheetObj.CellValue2(nNewRow, "cxl_flg")      = "N";	
		}
		
	}
}

/**
 * Copy 시, 처리로직 제어
 */
function copyRow(sheetObj) {
	sheetObj.ReDraw = false;
	if(sheetObj.SelectRow<1) return;
	if (sheetObj.id == "sheet1"){
		addRow(sheetObj, "C", sheetObj.SelectRow);  
	}
	sheetObj.ReDraw = true;
}

/**
 * Split 시, 처리로직 제어
 */
function splitRow(sheetObj) {

	var sRow   = sheetObj.FindCheckedRow("del_chk");
	var arrRow = sRow.split("|");
		
	sheetObj.ReDraw = false;
	
	for(var i = 0; i<= arrRow.length-2; i++){
		var sel = arrRow[i];
		var cnt = sheetObj.CellValue(arrRow[i], "tro_qty");
		
		if(cnt > 1){
			sheetObj.CellValue(arrRow[i], "tro_qty") = 1;
			for(var idx = 0; idx <cnt-1; idx++){
				addRow(sheetObj, "S", arrRow[i]);  
			}	
		}
	}
	
	sheetObj.ReDraw = true;
}

function change_seq(sheet, obj) {
	var formObj = document.form;
	var prefix  = "";
	var postfix = "";
	var cn      = 0;
	if (sheet == "sheet3") { //alps
		prefix  = "sheet3_";
		postfix = "";
		cn      = 2;

		eval("formObj.request_result"+postfix).value = sheetObjects[cn].CellValue(obj.value, "request_result");
		eval("formObj.request_date"  +postfix).value = sheetObjects[cn].CellValue(obj.value, "rqst_dt");
	} else { //esvc
		prefix  = "sheet4_";
		postfix = "2";
		cn      = 3;
	}

	eval("formObj.self_trk" +postfix).value  = sheetObjects[cn].CellValue(obj.value, "ownr_trk_flg");

	if (sheetObjects[cn].CellValue(obj.value, "ownr_trk_flg") == "Y") {
		eval("formObj.self_trk"+postfix).checked = true;
	} else {
		eval("formObj.self_trk"+postfix).checked = false;		
	}
	eval("formObj.act_sh"    +postfix).value = sheetObjects[cn].CellValue(obj.value, "act_shpr_nm");
	eval("formObj.cntc_pson" +postfix).value = sheetObjects[cn].CellValue(obj.value, "cntc_pson_nm");
	eval("formObj.tel"       +postfix).value = sheetObjects[cn].CellValue(obj.value, "cntc_phn_no");
	eval("formObj.mobile"    +postfix).value = sheetObjects[cn].CellValue(obj.value, "cntc_mphn_no");
	eval("formObj.dor_pst_no"+postfix).value = sheetObjects[cn].CellValue(obj.value, "dor_pst_no");
	eval("formObj.addr"      +postfix).value = sheetObjects[cn].CellValue(obj.value, "act_shpr_addr");
	eval("formObj.rmk"       +postfix).value = sheetObjects[cn].CellValue(obj.value, "diff_rmk");
	
	if (sheet == "sheet3") {
		eval("formObj.cxl_flg"+postfix).value = sheetObjects[cn].CellValue(obj.value, "cxl_flg");
	}

	seq_rowhidden(sheet, sheetObjects[cn].CellValue(obj.value, "tro_seq"));
	
	if (sheet == "sheet3") { //alps
		checkTroStatus(obj.value);
	}
	// ----------------------
	// 5) cxl_flg checkbox : Master 수정 불가/가능 처리	
	changeMasterColor(formObj);		
	compareItem();
}

// form의 값을 sheet로 복사
function click_seq(obj) {
	var formObj = document.form;
	if ( sheetObjects[2].TotalRows > 0 ) {
		sheetObjects[2].CellValue(obj.value, "request_result") = formObj.request_result.value;
		sheetObjects[2].CellValue(obj.value, "rqst_dt")        = formObj.request_date.value;
		sheetObjects[2].CellValue(obj.value, "ownr_trk_flg")   = formObj.self_trk.checked ? "Y": "N";
		sheetObjects[2].CellValue(obj.value, "act_shpr_nm")    = formObj.act_sh.value;
		sheetObjects[2].CellValue(obj.value, "cntc_pson_nm")   = formObj.cntc_pson.value;
		sheetObjects[2].CellValue(obj.value, "cntc_phn_no")    = formObj.tel.value;
		sheetObjects[2].CellValue(obj.value, "cntc_mphn_no")   = formObj.mobile.value;
		sheetObjects[2].CellValue(obj.value, "dor_pst_no")     = formObj.dor_pst_no.value;
		sheetObjects[2].CellValue(obj.value, "act_shpr_addr")  = formObj.addr.value;
		sheetObjects[2].CellValue(obj.value, "diff_rmk")       = formObj.rmk.value;
	}
}    

function seq_rowhidden(sheet, seq){
	var sheetObj = null;
	var prefix   = null;
	if (sheet == "sheet3"){
		sheetObj = sheetObjects[0];
		prefix   = "sheet1_";
	} else {
		sheetObj = sheetObjects[1];
		prefix   = "sheet2_";
	}

	for (var i=sheetObj.HeaderRows; i<=sheetObj.RowCount+sheetObj.HeaderRows-1; i++){
		// cancel된 tro detail : 색상 변경 + 취소선		
		if ("Y" == sheetObj.CellValue(i, "cxl_flg")) {
			sheetObj.RangeFontColor(i, 0, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
			sheetObj.CellFont("FontStrikethru", i, 0, i, sheetObj.LastCol) = true;
			sheetObj.RowEditable(i) = false;
		}

		// 02. 현재 tro_seq 이외의 row : hidden
		if (sheetObj.CellValue(i, "tro_seq") == seq){
			sheetObj.RowHidden(i) = false;
		} else {
			sheetObj.RowHidden(i) = true;
		}
	}
}

/**
 * cancel_dtl
 */
function cancelDtl() {
	var formObj  = document.form; 
	var sheetObj = sheetObjects[0]

	// 1) tro-detail : cancel
	var sRow   = sheetObj.FindCheckedRow("del_chk");
	var arrRow = sRow.split("|");

	for (var idx=arrRow.length-2; idx>=0; idx--){ 
		if ("Y" != sheetObj.CellValue(arrRow[idx], "cxl_flg")){	
			// 추가된 row에 대해서는 삭제
			if (sheetObj.CellValue(arrRow[idx], "ibflag") == "I"){	
				sheetObj.RowStatus(arrRow[idx])  = "D";
			} else {
				//추가된 row를 제외하고는 취소 처리
				sheetObj.CellValue2    (arrRow[idx], "cxl_flg") = "Y";
				sheetObj.RangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); 
				sheetObj.CellFont("FontStrikethru", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol) = true; 
				sheetObj.RowEditable(arrRow[idx]) = false;
			}
		}
	}
}
  
// cancel/confirm 표시 
function checkTroStatus(seq){
	var formObj = document.form;
	var className = "input2";
	if(sheetObjects[2].CellValue(seq, "cxl_flg")=="Y"){
		formObj.tro_status.value = "Cancel";
		formObj.tro_status.style.color = "red";
		formObj.request_result.style.color = "red";
	} else if(sheetObjects[2].CellValue(seq, "cfm_flg")=="Y"){
		formObj.tro_status.value = "Confirm";
		formObj.tro_status.style.color = "blue";
		if ( parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) == "KR" ) {
			className = "input";
		}
	} else {
		formObj.tro_status.value = "";
		formObj.tro_status.style.color = "#606060";
		className = "input";
	}
	
	if(className=="input2"){
		sheetObjects[0].Editable = false;
		BkgEnableObject(formObj.self_trk, false);
	} else {
		sheetObjects[0].Editable = true;
		BkgEnableObject(formObj.self_trk, true);		
	}

	document.getElementById("act_sh").className = className;
	document.getElementById("cntc_pson").className = className;
	document.getElementById("tel").className = className;
	document.getElementById("mobile").className = className;
	document.getElementById("dor_pst_no").className = className;
	document.getElementById("addr").className = className;
	document.getElementById("rmk").className = className;
}

 /**
  * Tro-Master : Mater 수정불가 처리
  */    
function changeMasterColor(formObj) {
 	var isEurFlg = formObj.is_eur_flg.value; 	
 	// 01. cxl_flg checkbox : Master 수정 불가/가능 처리
	if (formObj.cxl_flg.value == "Y") {
		changeEnabled_master(false);
		ComBtnDisable("btn_add");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_add"); 	
	} else {
		changeEnabled_master(true);  
		if(formObj.is_eur_flg.value=="N"){
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_del");
			ComBtnEnable("btn_add");		
		} else {
			// eur 이면, 버튼 disbled 처리 (tro_seq당, mst:dtl=1row:1row) -> 수정만 가능함.
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_add"); 				
		}
	}
}

// Tro-Master : enable/disable 처리
function changeEnabled_master(bFlag) {
 	with(document.form) {
 		ComEnableManyObjects_loc(bFlag, self_trk, act_sh, cntc_pson, tel, mobile, dor_pst_no, addr, rmk);
 	}
}

// 일괄 enable/disable처리
function ComEnableManyObjects_loc(bEnable, objs) {
	try {
		var args = arguments;

		if (args.length < 2) return;
		for(var i=1; i<args.length; i++) {
			if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}

// 항목별 enable/disable처리
function ComEnableObject_loc(obj, bEnable){
	try {
		// disabled나 readOnly 설정하기
		switch( obj.type ) {
			case "text" :
				obj.readOnly = !bEnable;
				break;
			default:
				obj.disabled = !bEnable;
		}

		// 설정에 따라 css 처리하기
		switch( obj.type ) {
			case "text" :
				//input:흰색바탕, input1:흰색바탕+필수입력, input2:회색바탕, input2_2:회색바탕+필수입력
				if (bEnable){
					if (obj.className=="input2_2"){	      
						obj.className = "input1";	      
					} else if (obj.className=="input2"){  
						obj.className = "input";          
					}
				} else {
					if (obj.className=="input1"){         
						obj.className = "input2_2";       
					} else if (obj.className=="input"){   
						obj.className = "input2";         
					}
				}
				break;
	
			case "textarea":
				if (bEnable){
					obj.className = "textarea";
				} else {
					obj.className = "textarea2";
				}
				break;
	
			default :
				if (obj.tagName=="IMG" || obj.tagName=="img") {
					if (bEnable){
						obj.style.cursor = "hand";
						obj.style.filter="";
					} else {
						obj.style.cursor = "default";
						obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
					}
				}
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}

function setActCustCallBack(aryPopupData) {
    var formObj = document.form;     
	var p_act_shpr_nm	       = nullToBlank(aryPopupData[0][3]); 
//	var p_cnt_cd              = nullToBlank(aryPopupData[0][4]); 
	var p_cntc_pson_nm        = nullToBlank(aryPopupData[0][7]); 
	var p_cntc_phn_no         = nullToBlank(aryPopupData[0][8]); 
	var p_cntc_mphn_no        = nullToBlank(aryPopupData[0][9]); 
	var p_act_shpr_addr       = nullToBlank(aryPopupData[0][10]); 
	var p_dor_zip_id          = nullToBlank(aryPopupData[0][11]); 
	var p_cntc_fax_no         = nullToBlank(aryPopupData[0][12]); 
//	var p_cntc_eml            = nullToBlank(aryPopupData[0][13]); 
//	var p_tro_act_cust_knd_cd = nullToBlank(aryPopupData[0][14]);
//	var p_cust_seq            = nullToBlank(aryPopupData[0][17]); 

	formObj.act_sh.value     	= p_act_shpr_nm;
	formObj.dor_pst_no.value    = p_dor_zip_id;
	formObj.addr.value   		= p_act_shpr_addr;
	formObj.cntc_pson.value    	= p_cntc_pson_nm;
	formObj.tel.value     		= p_cntc_phn_no;
	formObj.mobile.value    	= p_cntc_mphn_no;
}


/**
 * Change 이벤트 처리
 */ 
  function sheet1_OnChange(sheetObj, row, col, val){
  	if(sheetObj.ColSaveName(col) == "dor_arr_dt") {
  		if(val.length == 12){
  			parent.frames("t1frame").document.form.mty_pkup_dt.value = val.substr(0,4) +"-"+ val.substr(4,2) +"-"+ val.substr(6,2);
  		}
  	}else if(sheetObj.ColSaveName(col) == "pkup_loc_cd") {
  		if(val != '' && sheetObj.CellValue(row, "pkup_yd_cd") != '' && parent.document.frames("t1frame").form.mty_pkup_yd_cd.value == ''){
  			parent.document.frames("t1frame").form.mty_pkup_yd_cd.value = val + sheetObj.CellValue(row, "pkup_yd_cd");
  		}
  	}else if(sheetObj.ColSaveName(col) == "pkup_yd_cd") {
  		if(val != '' && sheetObj.CellValue(row, "pkup_loc_cd") != '' && parent.document.frames("t1frame").form.mty_pkup_yd_cd.value == ''){
  			parent.document.frames("t1frame").form.mty_pkup_yd_cd.value = sheetObj.CellValue(row, "pkup_loc_cd") + val;
  		}
  	}
  }
///**
//* 지정한 cell의 구간만 editable속성을 일괄 변경
//*/
//function changeAllCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
//	for (var i=nSCol; i<=nECol; i++) {
//		sheetObj.CellEditable(nRow, i) = bFlag;
//	}
//}

///**
// * Td 버튼 Disabled 상태 체크용
// */
//function checkTdDisabled(srcName) {
//	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
//}

///**
// * TD버튼 일괄 Enable/Disable 처리
// */
//function ComEnableManyTd(bEnable, objs) {
//	try {
//		var args = arguments;
//
//		if (args.length < 2) return;
//		for(var i=1; i<args.length; i++) {
//			if (bEnable == true) {
//				ComBtnEnable(args[i]);
//			} else {
//				ComBtnDisable(args[i]);
//			} 
//		}
//	} catch(err) { ComFuncErrMsg(err.message); }
//}	 


///**
//* [tro_dtl]AddRow한 행에, 특정항목의 default값을 설정한다.
//*/
//function setDefaultInsertRow_Dtl(sheetObj, nRow, tro_seq) { 
//}
//
//function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
//}

////addRow prev MaxSeq get
//function getPrevMaxTroSeq(sheetObj, nRow, colId){
//	var prevMaxTroSeq = 0;
//	if (nRow > 1) {
//		prevMaxTroSeq = sheetObj.CellValue(nRow-1, colId); 
//	}
//	return prevMaxTroSeq;
//}
///**
// * 해당 Sheet의 cxl_flg='Y'인 상태row : Delete Color 처리
// */ 
//function setRowDelColorChange(sheetObj) {
//}     
///**
// * IBMultiCombo 일괄 Enable/Disable 처리
// */
//function ComEnableManyIBCombo(bEnable, objs) {
//	try {
//		var args = arguments;
//
//		if (args.length < 2) return;
//		for(var i=1; i<args.length; i++) {
//			if (args[i].tagName != undefined) {
//				args[i].Enable = bEnable;
//			}
//		} 
//	} catch(err) { ComFuncErrMsg(err.message); }
//}

//function acceptText() {
//	var formObj = document.form;
//	var sheetObj = sheetObjects[2];
//	var row = 0;
//	
//	if (sheetObj.RowCount < 1) {
//		row = sheetObj.DataInsert(-1);
//	}
//	else {
//		row = 1;
//	}
//
////	sheetObj.CellValue2(row, "ibflag") = 
//	sheetObj.CellValue2(row, "tro_seq")        = ComGetObjValue(formObj.alps_seq);
//	sheetObj.CellValue2(row, "ownr_trk_flg")   = formObj.self_trk.checked ? "Y" : "N";
//	sheetObj.CellValue2(row, "request_result") = formObj.request_result.value;
//	sheetObj.CellValue2(row, "rqst_dt")        = formObj.request_date.value;
//
//	sheetObj.CellValue2(row, "act_shpr_nm")    = formObj.cntc_pson.value;
//	sheetObj.CellValue2(row, "cntc_pson_nm")   = formObj.tel.value;
//	sheetObj.CellValue2(row, "cntc_phn_no")    = formObj.mobile.value;
//	sheetObj.CellValue2(row, "cntc_mphn_no")   = formObj.mobile2.value;
//	sheetObj.CellValue2(row, "dor_pst_no")     = formObj.dor_pst_no.value;
//
//	sheetObj.CellValue2(row, "act_shpr_addr")  = formObj.addr.value;
//	sheetObj.CellValue2(row, "diff_rmk")       = formObj.rmk.value;
//	sheetObj.CellValue2(row, "cxl_flg")        = "N";
//	sheetObj.CellValue2(row, "is_eur")         = "N";
//	sheetObj.CellValue2(row, "io_bnd_cd")      = "O";
//}


//		// 화면상의 값 복사
//		if(formObj.self_trk.value != ''&&formObj.self_trk2.value != null) {
//			formObj.self_trk.value = formObj.self_trk2.value;
//			if (formObj.self_trk2.checked) formObj.self_trk.checked = true;
//		}
//		if(formObj.act_sh.value != ''&&formObj.act_sh2.value != null) {
//			formObj.act_sh.value = formObj.act_sh2.value;
//		}
//		if(formObj.cntc_pson.value != ''&&formObj.cntc_pson2.value != null) {
//			formObj.cntc_pson.value = formObj.cntc_pson2.value;
//		}
//		if(formObj.tel.value != ''&&formObj.tel2.value != null) {
//			formObj.tel.value = formObj.tel2.value;
//		}
//		if(formObj.mobile.value != ''&&formObj.mobile2.value != null) {
//			formObj.mobile.value = formObj.mobile2.value;
//		}
//		if(formObj.dor_pst_no.value != ''&&formObj.dor_pst_no2.value != null) {
//			formObj.dor_pst_no.value = formObj.dor_pst_no2.value;
//		}
//		if(formObj.addr.value != ''&&formObj.addr2.value != null) {
//			formObj.addr.value = formObj.addr2.value;
//		}
//		if(formObj.rmk.value != ''&&formObj.rmk2.value != null) {
//			formObj.rmk.value = formObj.rmk2.value;
//		}