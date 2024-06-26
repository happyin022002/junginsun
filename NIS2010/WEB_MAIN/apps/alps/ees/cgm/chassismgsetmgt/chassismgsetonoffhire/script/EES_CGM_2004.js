﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2004.js
 *@FileTitle : Own M.G.Set Master Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.23
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.06.23 박의수
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


/**
 * @extends
 * @class ees_cgm_2004 : ees_cgm_2004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2004() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if(comboObjects[0].Text == ""){
				ComShowCodeMessage("CGM10004", "M.G.Set Serial Range");
				comboObjects[0].focus();
				return;
			}
			// IBSHEET 조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			// HTML 오브젝트 ENABLE DISABLE 함수 호출
			CgmSetFormObjDisable(formObj, true);
			break;

		case "btn_New":
			// 그리드 초기화(그리드 단건을 가지고 컨트롤해야 하므로 모두 삭제)하고 행을 한개만 생성
			// 플레그는 신규이므로 "I"로 강제 할당함.
			
			// 행추가 함수 호출
			sheetObj.RemoveAll();
			var row = sheetObj.DataInsert(0);
			
			sheetObj1.RemoveAll();
			var row = sheetObj1.Datainsert(0);

			formObj.reset();
			comboObjects[0].Code               = "";
			formObj.eq_spec_no.Code            = "";
			formObj.financier.Code             = "";
			sheetObj.CellValue(1, "eq_knd_cd") = "Z";
			sheetObj.RowStatus(1)              = "I";
			formObj.page_status.value          = "N";
			
			// HTML 오브젝트 ENABLE DISABLE 함수 호출
			CgmSetFormObjDisable(formObj, false);
			break;

		case "btn_Save":
			// 저장 전 필수 입력 필드 검사
			if(formObj.eq_spec_no.Text == ""){
				ComShowCodeMessage("CGM10004", "Model No.");
				formObj.eq_spec_no.focus();
				return;
			}
			if(formObj.eq_pfx_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
				formObj.eq_pfx_cd.focus();
				return;
			}
			if(formObj.fm_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
				formObj.fm_ser_no.focus();
				return;
			}
			if(formObj.to_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
				formObj.to_ser_no.focus();
				return;
			}
			if(formObj.de_yrmon.value == ""){
				ComShowCodeMessage("CGM10004", "Delivery Month");
				if(formObj.de_yrmon.disabled != true)
					formObj.de_yrmon.focus();
				return;
			}
			if(formObj.agreement_no.value == ""){
				ComShowCodeMessage("CGM10004", "Agreement No");
				formObj.agreement_no.focus();
				return;
			}
			doActionIBSheet(sheetObj,formObj,IBSAVE);
			break;

		case "btn_FA I/F":
			var param = "";
			if(formObj.mgset_range.Text != '' && formObj.eq_pfx_cd.disabled == true)
		  	{
		  		var pgmNo = 'EES_CGM_1146';
		  		var pgmUrl = '/hanjin/EES_CGM_1146.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   

		  		//1146
		  		var eq_knd_cd = 'G'; // 장비 종류 => 샤시:'Z', MGSET:'G'  
		  		var de_yrmon = form.de_yrmon.value;
		  		var eq_no_fm = form.eq_pfx_cd.value+form.fm_ser_no.value;
		  		var eq_no_to = form.to_ser_no.value;
		  		
		  		
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")
		    				+"&pgmNo="+pgmNo
		    				+"&eq_knd_cd="+eq_knd_cd
		    				+"&de_yrmon="+de_yrmon
		    				+"&eq_no_fm="+eq_no_fm
		    				+"&eq_no_to="+eq_no_to;
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//eq_no 없어도 띄워준다.
		  		var pgmNo = 'EES_CGM_1146';
		  		var pgmUrl = '/hanjin/EES_CGM_1146.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;


			// 일달력을 보여준다
		case "btn_Calendar" :
			if(window.event.srcElement.disabled) {
				return;
			}
			var cal = new ComCalendar();
			cal.select(formObj.cre_dt, "yyyy-MM-dd");
			break;

	// 월달력을 보여준다
	case "btn_Calendar_b" :
		if(window.event.srcElement.disabled) {
			return;
		}
		var cal = new ComCalendar();
		cal.setDisplayType("month");
		cal.select(formObj.de_yrmon, "yyyy-MM");
		break;
			
	    case "btn_ComOpenPopupWithTargetAgree":
			if(window.event.srcElement.disabled) {
				return;
			}
	    	ComOpenPopup('/hanjin/EES_CGM_2022.do', 820, 435, "setProgramNo", "1,0,1,1,1,1", true, false);
			break;
			
		} // end switch
		tRoleApply();
  }catch(e) {
    if( e == "[object Error]") {
     ComShowMessage(OBJECT_ERROR);
    } else {
     ComShowMessage(e);
    }
  }
}


/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * IBMultiCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {

   comboObjects[comboCnt++] = combo_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;

	//AXON EVENT 등록
    axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
    axon_event.addListenerFormat('keypress',			'obj_keydown',		form);
    axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form);
	axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
    axon_event.addListener      ("focusout",			"obj_focusout",		"eq_lot_no", "eq_pfx_cd", "fm_ser_no", "to_ser_no", "eq_lot_iss_dt","de_yrmon");
    axon_event.addListener      ("blur",				"obj_blur",			"eq_lot_no");
    axon_event.addListener		("change",				"obj_change",		"agreement_no");
    axon_event.addListenerForm	('keyup', 'obj_keyup', form);
    
	for (i = 0; i < sheetObjects.length; i++) {

		// 시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// 마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

		sheetObjects[i].DataInsert(0);
	}

	for(i=0;i<comboObjects.length;i++){
        initCombo(comboObjects[i],i+1);
    }

	//콤보 오브젝트
	initControl(sheetObjects[0]);

	formObj.page_status.value = "N";
	sheetObjects[0].CellValue(1, "eq_knd_cd") = "Z";
	
	tRoleApply();
}


/**
 * Form의 Conrol 를 초기화 시킨다.
 */
function initControl(sheetObj){
	// Form 객체 선언
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	/*
	// 콤보 초기화
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02); // COMBO >> SPEC NO
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03); // COMBO >> FINANING CO
	*/
   	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
}


/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 80;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|eq_lot_no|mgset_range|eq_pfx_cd|fm_ser_no|to_ser_no|units|de_yrmon|eq_spec_no|vndr_seq|vndr_lgl_eng_nm_eqspec|mgst_vltg_capa|mgst_fuel_capa|agreement_no|agmt_ofc_cty_cd|agmt_seq|agmt_lstm_cd|agmt_iss_ofc_cd|cre_dt|vndr_seq_agree|vndr_lgl_eng_nm_agree|eq_tpsz_cd|chss_tare_wgt";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtStatus,	50,		daCenter,	true,	"ibflag");
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"eq_lot_no",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"mgset_range",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"eq_pfx_cd",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"fm_ser_no",				false,	"",	dfNone,	0,	false,	false);

			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"to_ser_no",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"units",					false,	"",	dfNone,	0,	false,	false);
                        InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"de_yrmon",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"eq_spec_no",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"vndr_seq",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"vndr_lgl_eng_nm_eqspec",	false,	"",	dfNone,	0,	false,	false);

			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"mgst_vltg_capa",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"mgst_fuel_capa",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agreement_no",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agmt_ofc_cty_cd",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agmt_seq",					false,	"",	dfNone,	0,	false,	false);

			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agmt_lstm_cd",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agmt_iss_ofc_cd",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"cre_dt",					false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"vndr_seq_agree",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"vndr_lgl_eng_nm_agree",	false,	"",	dfNone,	0,	false,	false);

			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"eq_tpsz_cd",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"chss_tare_wgt",			false,	"",	dfNone,	0,	false,	false);
		}
		break;
		
	case 2:
		with (sheetObj) {

			// 높이 설정
			style.height = 80;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "eq_spec_no|agmt_lstm_cd|vndr_lgl_eng_nm_eqspec|mgst_vltg_capa|mgst_fuel_capa|eq_tpsz_cd|chss_tare_wgt";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"eq_spec_no",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"agmt_lstm_cd",				false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		300,	daCenter,	true,	"vndr_lgl_eng_nm_eqspec",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"mgst_vltg_capa",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"mgst_fuel_capa",			false,	"",	dfNone,	0,	false,	false);
            InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"eq_tpsz_cd",			false,	"",	dfNone,	0,	false,	false);
            InitDataProperty(0,	cnt++,	dtData,		150,	daCenter,	true,	"chss_tare_wgt",			false,	"",	dfNone,	0,	false,	false);
		}
		break;
	}
}


/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	switch (sAction) {

	// SEARCH
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH01;
		formObj.financier.Index = -1; //chungpa 20090813 add iniialize combo index
		sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj));

		// 그리드 값을 폼 객체로 세팅
		formObj.eq_lot_no_tmp.value          = sheetObj.CellValue(1,"eq_lot_no");
		formObj.mgset_range.value            = sheetObj.CellValue(1,"mgset_range");
		formObj.eq_pfx_cd.value              = sheetObj.CellValue(1,"eq_pfx_cd");
		formObj.fm_ser_no.value              = sheetObj.CellValue(1,"fm_ser_no");
		formObj.to_ser_no.value              = sheetObj.CellValue(1,"to_ser_no");

		formObj.units.value                  = sheetObj.CellValue(1,"units");
		formObj.eq_spec_no.value             = sheetObj.CellValue(1,"eq_spec_no");
		formObj.vndr_lgl_eng_nm_eqspec.value = sheetObj.CellValue(1,"vndr_lgl_eng_nm_eqspec");
		formObj.mgst_vltg_capa.value         = sheetObj.CellValue(1,"mgst_vltg_capa");
		formObj.mgst_fuel_capa.value         = sheetObj.CellValue(1,"mgst_fuel_capa");
        var tmpDate			                 = sheetObj.CellValue(1, "de_yrmon");
		if(tmpDate.length == 6)
		{
			formObj.de_yrmon.value	   = tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
		}
		else
		{
			formObj.de_yrmon.value	   = tmpDate;
		}
		formObj.agreement_no.value           = sheetObj.CellValue(1,"agreement_no");
		formObj.agmt_ofc_cty_cd.value        = sheetObj.CellValue(1,"agmt_ofc_cty_cd");
		formObj.agmt_seq.value               = sheetObj.CellValue(1,"agmt_seq");
		formObj.agmt_lstm_cd.value           = sheetObj.CellValue(1,"agmt_lstm_cd");
		formObj.agmt_iss_ofc_cd.value        = sheetObj.CellValue(1,"agmt_iss_ofc_cd");

		formObj.cre_dt.value                 = sheetObj.CellValue(1,"cre_dt");
		formObj.vndr_seq_agree.value         = sheetObj.CellValue(1,"vndr_seq_agree");
		
		// alert(sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree"));
		if(sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree") == ""){
			formObj.financier.Text = ""
		} else {
			formObj.financier.Text               = sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree");			
		}
		
		formObj.eq_spec_no.Text              = sheetObj.CellValue(1,"eq_spec_no");
		formObj.page_status.value            = "R";
		
		formObj.page_status.value = "U";
		sheetObj.RowStatus(1) = "U";
		break;

	// SAVE
	case IBSAVE:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);	
		
		formObj.f_cmd.value = MULTI;
		
		if(sheetObj.CellValue(1,"ibflag") == "I"){
			
			if(sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj))){
				sheetObj.LoadSaveXml(sXml);

				// 콤보 INIT 호출(추가된 데이타를 콤보에 적용하기 위해 호출해 줍니다
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE
				
				var mgset_range_Val = sheetObj.CellValue(1, "mgset_range");
				formObj.mgset_range.text    = mgset_range_Val;
				formObj.eq_lot_no_tmp.value = sheetObj.CellValue(1, "eq_lot_no");
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj));

				formObj.eq_lot_no_tmp.value          = sheetObj.CellValue(1,"eq_lot_no");
				formObj.mgset_range.Text             = sheetObj.CellValue(1,"mgset_range");
				formObj.eq_pfx_cd.value              = sheetObj.CellValue(1,"eq_pfx_cd");
				formObj.fm_ser_no.value              = sheetObj.CellValue(1,"fm_ser_no");
				formObj.to_ser_no.value              = sheetObj.CellValue(1,"to_ser_no");

				formObj.units.value                  = sheetObj.CellValue(1,"units");
				formObj.eq_spec_no.value             = sheetObj.CellValue(1,"eq_spec_no");
				formObj.vndr_lgl_eng_nm_eqspec.value = sheetObj.CellValue(1,"vndr_lgl_eng_nm_eqspec");
				formObj.mgst_vltg_capa.value         = sheetObj.CellValue(1,"mgst_vltg_capa");
				formObj.mgst_fuel_capa.value         = sheetObj.CellValue(1,"mgst_fuel_capa");
                var tmpDate			                 = sheetObj.CellValue(1, "de_yrmon");
        		if(tmpDate.length == 6)
        		{
        			formObj.de_yrmon.value	   = tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
        		}
        		else
        		{
        			formObj.de_yrmon.value	   = tmpDate;
        		}
				formObj.agreement_no.value           = sheetObj.CellValue(1,"agreement_no");
				formObj.agmt_ofc_cty_cd.value        = sheetObj.CellValue(1,"agmt_ofc_cty_cd");
				formObj.agmt_seq.value               = sheetObj.CellValue(1,"agmt_seq");
				formObj.agmt_lstm_cd.value           = sheetObj.CellValue(1,"agmt_lstm_cd");
				formObj.agmt_iss_ofc_cd.value        = sheetObj.CellValue(1,"agmt_iss_ofc_cd");

				formObj.cre_dt.value                 = sheetObj.CellValue(1,"cre_dt");
				formObj.vndr_seq_agree.value         = sheetObj.CellValue(1,"vndr_seq_agree");
				formObj.financier.Text               = sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree");
				formObj.eq_spec_no.Text              = sheetObj.CellValue(1,"eq_spec_no");
				
				sheetObj.CellValue(1, "mgset_range") = formObj.mgset_range.text;
				sheetObj.RowStatus(1) = "U";
				
				// HTML 오브젝트 DISABLE
				CgmSetFormObjDisable(formObj, true);
				
				ComShowCodeMessage("CGM00003");
			}else
 			{
 				
 			}
		} else if(sheetObj.CellValue(1,"ibflag") == "U"){
			if(sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj))){
				
				sheetObj.LoadSaveXml(sXml);
				
				var mgset_range_Val = sheetObj.CellValue(1, "mgset_range");
				formObj.eq_lot_no_tmp.value = sheetObj.CellValue(1, "eq_lot_no");
				formObj.mgset_range.text    = mgset_range_Val;
				
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj)); // 이유가 모야?

				formObj.eq_lot_no_tmp.value          = sheetObj.CellValue(1,"eq_lot_no");
				formObj.mgset_range.value            = sheetObj.CellValue(1,"mgset_range");
				formObj.eq_pfx_cd.value              = sheetObj.CellValue(1,"eq_pfx_cd");
				formObj.fm_ser_no.value              = sheetObj.CellValue(1,"fm_ser_no");
				formObj.to_ser_no.value              = sheetObj.CellValue(1,"to_ser_no");

				formObj.units.value                  = sheetObj.CellValue(1,"units");
				formObj.eq_spec_no.value             = sheetObj.CellValue(1,"eq_spec_no");
				formObj.vndr_lgl_eng_nm_eqspec.value = sheetObj.CellValue(1,"vndr_lgl_eng_nm_eqspec");
				formObj.mgst_vltg_capa.value         = sheetObj.CellValue(1,"mgst_vltg_capa");
				formObj.mgst_fuel_capa.value         = sheetObj.CellValue(1,"mgst_fuel_capa");
                var tmpDate			                 = sheetObj.CellValue(1, "de_yrmon");
        		if(tmpDate.length == 6)
        		{
        			formObj.de_yrmon.value	   = tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
        		}
        		else
        		{
        			formObj.de_yrmon.value	   = tmpDate;
        		}
				formObj.agreement_no.value           = sheetObj.CellValue(1,"agreement_no");
				formObj.agmt_ofc_cty_cd.value        = sheetObj.CellValue(1,"agmt_ofc_cty_cd");
				formObj.agmt_seq.value               = sheetObj.CellValue(1,"agmt_seq");
				formObj.agmt_lstm_cd.value           = sheetObj.CellValue(1,"agmt_lstm_cd");
				formObj.agmt_iss_ofc_cd.value        = sheetObj.CellValue(1,"agmt_iss_ofc_cd");

				formObj.cre_dt.value                 = sheetObj.CellValue(1,"cre_dt");
				formObj.vndr_seq_agree.value         = sheetObj.CellValue(1,"vndr_seq_agree");
				formObj.financier.Text               = sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree");
				formObj.eq_spec_no.Text              = sheetObj.CellValue(1,"eq_spec_no");
				
				sheetObj.CellValue(1, "mgset_range") = formObj.mgset_range.text;
				sheetObj.RowStatus(1) = "U";
				ComShowCodeMessage("CGM00003");
			}else
 			{
 				
 			}
		}
		
		ComOpenWait(false);			
		break;

	// COMBO >> MGSET SERIAL RANGE
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value = SEARCH10;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");
		MakeComboObject1(comboObjects[0], arrStr, 0, 0);
		break;

	// COMBO >> MODEL NO
	case IBSEARCH_ASYNC02:
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");

		MakeComboObject2(formObj.eq_spec_no, arrStr, 0, 0);
		break;

	// COMBO >> FINANCING CO
	case IBSEARCH_ASYNC03:
		formObj.f_cmd.value = SEARCH11;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml,"comboList");
		var arrStr = sStr.split("@");
	
		MakeComboObject3(formObj.financier, arrStr, 0, 0);
		break;
		
		// AGREEMENT NO 조회(엔터키로 단건 조회)
	case IBSEARCH_ASYNC04:
		formObj.f_cmd.value = SEARCH12;
		formObj.agmt_no.value = formObj.agreement_no.value;
		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj));
		
		var dataCount = ComGetTotalRows(sXml);
			// 데이터가 존재할 경우
		if(dataCount>0){
			formObj.agmt_iss_ofc_cd.value = DomXml2String(sXml,"agmt_iss_ofc_cd");
			formObj.agmt_seq.value        = DomXml2String(sXml,"agmt_seq");
			formObj.agmt_ver_no.value     = DomXml2String(sXml,"agmt_ver_no");

			var DtTmp                     = DomXml2String(sXml,"cre_dt");
//			creDtTmp = DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
			formObj.cre_dt.value          = DtTmp;
			formObj.agmt_lstm_cd.value    = DomXml2String(sXml,"agmt_lstm_cd");
			formObj.agmt_ofc_cty_cd.value = DomXml2String(sXml,"agmt_ofc_cty_cd");
			sheetObj.CellValue(1, "agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
			sheetObj.CellValue(1, "agmt_seq")        = formObj.agmt_seq.value;
			sheetObj.CellValue(1, "agreement_no")    = formObj.agreement_no.value;
			return true;
		} else {
	    	// Form Object 초기화
	    	formObj.agmt_no.value         = "";
	    	formObj.agmt_iss_ofc_cd.value = "";
	    	formObj.agmt_seq.value        = "";
	    	formObj.agmt_ver_no.value     = "";
	    	formObj.cre_dt.value          = "";

	    	formObj.agmt_lstm_cd.value    = "";
	    	sheetObjects[0].RemoveAll();
	    	return false;
		}
		break;

	case IBRESET:
		var idx = 0
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");

		//MGSET SERIAL RANGE
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr1 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
		    vListData = vArrayListData[i];
		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		// combo control, 결과 문자열, Text Index, Code Index
  		MakeComboObject1(comboObjects[0], arrStr1, 0, 0);   
		idx++;        		

		//MODEL NO
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr2 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
		    vListData = vArrayListData[i];
		    arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject2(formObj.eq_spec_no, arrStr2, 0, 0);
  		idx++;
  		
		//FINANCING CO
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr3 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
		    vListData = vArrayListData[i];
		    arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject3(formObj.financier, arrStr3, 0, 0);
  		idx++;
  		
 	  	
		break;		
	}
}


/**
 * 멀티콤보 생성
 */
function initCombo(comboObj) {
	with(comboObj){
    	DropHeight = 100;
    	MultiSelect = false;
    	MaxSelect = 1;
	}
}


/**
 * 콤보 오브젝트 생성(MGSET SERIAL RANGE)
 */
function MakeComboObject1(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		// DESCRIPTION 보여주기
		cmbObj.InsertItem(i+1, arrCode[1], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
}


/**
 * 콤보 오브젝트 생성(MMODEL NO)
 */
function MakeComboObject2(cmbObj, arrStr, codeCol, txtCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol], arrCode[txtCol]);
	}
	cmbObj.Index2 = "" ;
}


/**
 * 콤보 오브젝트 생성(FINANCING CO)
 */
function MakeComboObject3(cmbObj, arrStr, txtCol, codeCol) {
	
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		// DESCRIPTION 보여주기
		cmbObj.InsertItem(i+1, arrCode[1], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


/**
 * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;
	 
	 switch(obj.dataformat) {
  	    case "engup":
	        if(obj.name == "eq_no" || obj.name == "agreement_no" ){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        if(obj.name == "eq_pfx_cd")
	        {
	        	ComKeyOnlyAlphabet("upper");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
	    case "int":
 	    	ComKeyOnlyNumber(obj);
 	        break;
 	    // 일달력
  	 	case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	        break;
  	   // 월달력
  	 	case "ym":
  	 		ComKeyOnlyNumber(obj);
  	        break;
	 }
}


/**
 * AXON 이벤트 처리
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


/** 
 * OBJECT DEACTIVATE 이벤트에 대한 처리  <br>
 */
function obj_deactivate(){
	var formObj = document.form;
	obj = event.srcElement;
	
	if(obj.name == "cre_dt"){
		with(formObj){
			var creDtFr = ComReplaceStr(cre_dt.value, "-", "");
			//alert("creDtFr : " + creDtFr);
		}
        ComChkObjValid(event.srcElement);
	}else if(obj.name == "de_yrmon"){
		with(formObj){
			var creDtFr = ComReplaceStr(de_yrmon.value, "-", "");
			//alert("creDtFr : " + creDtFr);
		}
        ComChkObjValid(event.srcElement);
	}
}


/** 
 * 포커스 하이픈 제거(DATAFORMAT "YMD")
 */
function domFunFocusDel(a){
	var formObj = document.form;
	obj = event.srcElement;
	if(obj.name == "cre_dt"  ){
		document.form.cre_dt.value = ComReplaceStr(document.form.cre_dt.value, "-", "");
	}else if(obj.name == "de_yrmon"  ){
		document.form.de_yrmon.value      = ComReplaceStr(document.form.de_yrmon.value, "-", "");
	}
}


/**
 * 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	
	//IBMultiCombo 초기화
	formObj.reset();
	comboObjects[0].Code    = "";
	formObj.eq_spec_no.Code = "";
	formObj.financier.Code  = "";
	formObj.de_yrmon.value        = "";
}


/**
 * CERT NO, AGREEMENT NO 값 변경시 그리드로 값 세팅
 */
function obj_blur(){
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var formObj   = document.form;
	var obj       = event.srcElement;

    ComChkObjValid(event.srcElement);
    
    switch(obj.name){
    case "eq_lot_no":
    	sheetObj.CellValue(1, "eq_lot_no")= formObj.eq_lot_no.value;
    	break;
    }
}


/**
 * 페이지 상태에 따른 INSERT*UPDATE 구분
 */
function pageStatusCall(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	if(formObj.page_status.value == "R"){
		sheetObj.RowStatus(1) = "U";
	} else if(formObj.page_status.value == "N"){
		sheetObj.RowStatus(1) = "I";
	}
}


/**
 * FORM의 모든 객체에 대해 DISABLE 처리 (이미지 버튼 포함)
 * DISABLE 처리를 원하지 않는 객체에는 cgmdsbtype="no" 를 붙여줌
 * 
 */
function CgmSetFormObjDisable(form, flag) {
	var styleCursor = "";
	// try {
	if (typeof (form) != "object" || form.tagName != "FORM") {
		alert("[ComEtcDataToForm Error] FORM 태그가 아닙니다.");
		return "";
	}

	if (flag == true) {
		styleCursor = "";
		styleFilter = "progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
	} else {
		styleCursor = "cursor"
		styleFilter = "";
	}

	var elems = form.elements;
	for ( var i = 0; i < elems.length; i++) {
		if (elems[i].type.length > 0 && elems[i].type != "hidden"
				&& elems[i].cgmdsbtype != "no") {
			elems[i].disabled = flag;
		}
	}

	var obj = document.getElementsByTagName("img");
	for ( var i = 0; i < obj.length; i++) {
		
		if (obj[i].getAttribute("name").substr(0, 4) == "btn_" && elems[i].cgmdsbtype != "no") {
			obj[i].className = styleCursor;
			obj[i].disabled = flag;
			obj[i].style.filter = styleFilter;
		}
	}
}


/**
 * Object 의 Keydown 이벤트에 대한 처리  <br>
 * 객체가 agreement_no 일 경우에만 enter 키 발생시 조회실행.  <br>
 */ 
function obj_keydown(){
	var obj = event.srcElement;
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    	
    switch(obj.name){
    case 'agreement_no':
    	var keyValue = null;
        if(event == undefined || event == null) {
        	keyValue = 13;
        } else {
        	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        }

        if(keyValue != 13) return;
            	
    	var agmtNo = formObj.agreement_no.value;
    	var result = true;
    	 		
    	if(agmtNo != ""){
    		if(agmtNo.length <= 3){
    			result = false;
    		} else {
    			if(ComIsNumber(agmtNo.substring(3))==false){
    				result = false;
    			}
    		}
    	} else {
    		result = true;
    	}

    	if(!result){
    		ComShowCodeMessage('CGM10004','Agreement No.');
    		formObj.agreement_no.value = "";
    	 	ComSetFocus(formObj.agreement_no);
    	} else {
    		if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04)){
    			formObj.agreement_no.focus();
    		} else {
    			ComKeyEnter();
    		}
    	}
    	break;
    }
}


//*************************************************************************************************
//아래 온체인지 스크립트는 IBSHEET 작업을 하면서 두개 GRID에 값을 서로 동기화 시켜주는 스크립트의 시작입니다.
//*************************************************************************************************

/**
 * MG SET SERIAL RANGE 값 선택변경시 그리드로 값 세팅
 */
function mgset_range_OnChange(comboObj, Index_Code, Text){
	var formObj   = document.form;
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	if (Text == ""){
		// MGSET SERIAL RANGE 값이 없을 경우 처리입니다.
		// 행추가 함수 호출
		sheetObj.RemoveAll();
		var row = sheetObj.DataInsert(0);
		
		sheetObj1.RemoveAll();
		var row = sheetObj1.Datainsert(0);
		sheetObj.CellValue(1, "eq_knd_cd") = "Z";

		// 초기화 함수 호출
		objectClear();
		formObj.page_status.value = "N";

		// 페이지 상태에 따른 행상태 변경 함수호출
		pageStatusCall();
		
		// HTML 오브젝트 ENABLE DISABLE 함수 호출
		CgmSetFormObjDisable(formObj, false);
	} else {
		// MGSET SERIAL RANGE 값이 있을 경우 처리입니다.
		sheetObj.CellValue2(1, "eq_lot_no")  = comboObj.Code;
		formObj.eq_lot_no_tmp.value          = comboObj.Code;
		
		// 페이지 상태에 따른 행상태 변경 함수호출
		pageStatusCall();
		
		// chungpa 20091006 Cert_no 선택시 자동 Retrieve
		// IBSHEET 조회
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		// HTML 오브젝트 ENABLE DISABLE 함수 호출
		CgmSetFormObjDisable(formObj, true);
	}
}
/**
 * SPEC NO 값 변경시 그리드로 값 세팅
 */
function eq_spec_no_OnChange(comboObj, Index_Code, Text){
	var formObj   = document.form;
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	
	if(Text == ""){
		// MODEL NO 값이 없을 경우 처리입니다.
		formObj.vndr_lgl_eng_nm_eqspec.value = "";
		formObj.mgst_vltg_capa.value         = "";
		formObj.mgst_fuel_capa.value         = "";
	} else {
		// MODEL NO 값이 있을 경우 처리입니다.

		sheetObj.CellValue(1, "eq_spec_no")  = comboObj.Code;
		sheetObj1.CellValue(1, "eq_spec_no") = comboObj.Code;
		formObj.eq_spec_no_tmp.value         = comboObj.Code;
	
		sheetObj.CellValue(1, "vndr_lgl_eng_nm_eqspec") = formObj.vndr_lgl_eng_nm_eqspec.value;
		sheetObj.CellValue(1, "mgst_vltg_capa")         = formObj.mgst_vltg_capa.value;
		sheetObj.CellValue(1, "mgst_fuel_capa")         = formObj.mgst_fuel_capa.value;
	}
}

/**
 * FINANCIER 값 변경시 그리드로 값 세팅
 */
function financier_OnChange(comboObj, Index_Code, Text){
	var formObj   = document.form;
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];

	formObj.vndr_seq_agree.value                    = formObj.financier.Code;
	sheetObj.CellValue2(1, "vndr_seq_agree")        = formObj.financier.Code;
	sheetObj.CellValue2(1, "vndr_lgl_eng_nm_agree") = formObj.financier.Text;
}


/**
 * FINANCING CO 값 변경시 그리드로 값 세팅
 */
function financing_co_OnChange(comboObj, Index_Code, Text){
	var sheetObj  = sheetObjects[0];
	var formObj   = document.form;
	
	sheetObj.CellValue(1, "finc_vndr_seq") = formObj.financing_co.Code;
	
	// 페이지 상태에 따른 행상태 변경 함수호출
	pageStatusCall();
}

//*************************************************************************************************
//위 온체인지 스크립트는 IBSHEET 작업을 하면서 두개 GRID에 값을 서로 동기화 시켜주는 스크립트의 끝입니다.
//*************************************************************************************************

/**
 * 1. XML 데이타를 해당행에 컬럼별로 나눠서 넣어줌.
 */
function sheet1_OnChange(sheetObj, Row, Col) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var prefix   = "";
	var chk      = true;

	with (sheetObj) {
		var colName = ColSaveName(Col);
		switch (colName) {
	
		case "eq_lot_no":
		 	//서버 중복 체크
		 	var eqLotNoTmp = CellValue(Row, "eq_lot_no");

			// XML에 담긴 값을 해당컬럼에 값을 넣어줌
			if(eqLotNoTmp.length > 0) {
				formObj.f_cmd.value = SEARCH01;
				document.form.eq_lot_no_tmp.value = eqLotNoTmp;

				var sXml = GetSearchXml("EES_CGM_2004GS.do", FormQueryString(formObj));
			}
			break;
		}
	}
}


/**
 * 1. XML 데이타를 해당행에 컬럼별로 나눠서 넣어줌.
 */
function sheet2_OnChange(sheetObj, Row, Col) {
	var formObj   = document.form;
	var sheetObj0 = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var prefix    = "";
	var chk       = true;

	with (sheetObj) {
		var colName = ColSaveName(Col);
		switch (colName) {
		
		case "eq_spec_no":
		 	//서버 중복 체크
		 	var eqSpecNoTmp = CellValue(Row, "eq_spec_no");

			// XML에 담긴 값을 해당컬럼에 값을 넣어줌
			if(eqSpecNoTmp.length > 0) {
				formObj.f_cmd.value = SEARCH02;
				document.form.eq_spec_no_tmp.value = eqSpecNoTmp;

				var sXml = GetSearchXml("EES_CGM_2004GS.do", FormQueryString(formObj));
				
				if(DomXml2String(sXml, "eq_spec_no") == null || DomXml2String(sXml, "eq_spec_no") == "") {
					// 데이타가 없으므로 해당셀을 지워주고 포커스 이동 한다

					// 메세지 알림
					ComShowCodeMessage("CGM10012");

					// 해당 Cell 값을 Null로 설정
					sheetObj.CellValue2(Row, Col) = "";
					// 그리드에 포커스 이동
					sheetObj.SelectCell(Row, Col, true);
					formObj.eq_spec_no_tmp.value = "";
					return;

				} else {
					// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
					var formObj = document.form;
                                        var sheetObj = sheetObjects[0];
					// ETCDATA로 받을 값을 IBSHEET 로 값 셋팅
					CellValue2(Row,"vndr_lgl_eng_nm_eqspec") = DomXml2String(sXml,"vndr_lgl_eng_nm_eqspec");
					CellValue2(Row,"mgst_vltg_capa")         = DomXml2String(sXml,"mgst_vltg_capa");
					CellValue2(Row,"mgst_fuel_capa")         = DomXml2String(sXml,"mgst_fuel_capa");
                    CellValue2(Row,"eq_spec_no")      = DomXml2String(sXml,"eq_spec_no");
                    CellValue2(Row,"eq_tpsz_cd")      = DomXml2String(sXml,"eq_tpsz_cd");
                    CellValue2(Row,"chss_tare_wgt")   = DomXml2String(sXml,"chss_tare_wgt"); // chungpa 20090805 chss_tare_wgt update mgset은 chss_tare_wgt를 사용하지 않음.

					// ETCDATA로 받은 값을 HTML 폼객체로 값 세팅
					formObj.vndr_lgl_eng_nm_eqspec.value = DomXml2String(sXml,"vndr_lgl_eng_nm_eqspec");
					formObj.mgst_vltg_capa.value         = DomXml2String(sXml,"mgst_vltg_capa");
					formObj.mgst_fuel_capa.value         = DomXml2String(sXml,"mgst_fuel_capa");


					//3. SHEET2 와 값을 동기화 시켜주기 위해  SHEET1에도 값을 넣어준다.
					sheetObj0.CellValue2(Row, "eq_spec_no")      = DomXml2String(sXml,"eq_spec_no");
					sheetObj0.CellValue2(Row, "eq_tpsz_cd")      = DomXml2String(sXml,"eq_tpsz_cd");
					sheetObj0.CellValue2(Row, "chss_tare_wgt")	= DomXml2String(sXml,"chss_tare_wgt"); // chungpa 20090805 chss_tare_wgt update mgset은 chss_tare_wgt를 사용하지 않음.
				}
			}
			break;
		}
	}
}


 /** 
  * HTML object의 onchange 이벤트 처리
  * @author chungpa 20090805.
  */
 function obj_change() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;
	
	switch(obj.name){
	case "agreement_no":
		// AGREEMENT NO 조회(엔터키로 단건 조회)
		formObj.f_cmd.value = SEARCH12;
		//alert('----1');
	    if(formObj.agreement_no.value == '')
	    {
	 		formObj.agreement_no.value    = "";
	    	formObj.agmt_lstm_cd.value = "";
	    	formObj.agmt_iss_ofc_cd.value        = "";
	    	formObj.cre_dt.value     = "";
	    	sheetObjects[0].RemoveAll();
	    	//ComShowCodeMessage("CGM10004", "Agreement No.");
	    	return false;
	    }else
	    {
	    	formObj.agmt_no.value = formObj.agreement_no.value;
	    }
	    var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj));
	    // 데이터 건수
		var dataCount = ComGetTotalRows(sXml);
		// 데이터가 존재할 경우
		if(dataCount>0){
	    	formObj.agmt_lstm_cd.value		= DomXml2String(sXml,"agmt_lstm_cd");
	    	formObj.agmt_iss_ofc_cd.value   = DomXml2String(sXml,"agmt_iss_ofc_cd");
	    	formObj.cre_dt.value     		= DomXml2String(sXml,"cre_dt");
	    	var DtTmp                     = DomXml2String(sXml,"cre_dt");
			//var creDtTmp = DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
			formObj.cre_dt.value    = DtTmp;
						
			// AGREEMENT NO 입력후 엔터키 조회시 그리드로 값을 넘겨줌
			sheetObj.CellValue(1, "agmt_ver_no")     = DomXml2String(sXml,"agmt_ver_no");
		    sheetObj.CellValue(1, "agreement_no")    = DomXml2String(sXml,"agmt_no");
		    sheetObj.CellValue(1, "agmt_lstm_cd")    = DomXml2String(sXml,"agmt_lstm_cd");
		    sheetObj.CellValue(1, "agmt_iss_ofc_cd") = DomXml2String(sXml,"agmt_iss_ofc_cd");
		    sheetObj.CellValue(1, "cre_dt")          = DomXml2String(sXml,"cre_dt");

		    sheetObj.CellValue(1, "agmt_ofc_cty_cd") = DomXml2String(sXml,"agmt_ofc_cty_cd");
		    sheetObj.CellValue(1, "agmt_seq")        = DomXml2String(sXml,"agmt_seq");

		    agreementNoChk(formObj.agmt_lstm_cd.value);
			return true;
	    } else {
	    	// Form Object 초기화
	    	//chungpa 20090803 agreementNo가 무한 포커스되면서 브라우저 동작이 안되는 문제점 패치.
	    	//입력된 값이 빈칸이면 입력할 의사가 없는 것으로 판단. 다른 컨트롤들에 access를 허용한다. 
	    	
	    	if(formObj.agreement_no.value != "")
	    	{
		    	formObj.agreement_no.value    = "";
		    	formObj.agmt_iss_ofc_cd.value = "";
		    	formObj.agmt_lstm_cd.value    = "";
		    	formObj.cre_dt.value     = "";
		    	
		    	sheetObjects[0].RemoveAll();
		    	ComShowCodeMessage("CGM10004", "Agreement No.");
		    	if(formObj.agreement_no.disabled != true)
		    		formObj.agreement_no.focus();
		    	return true;
	    	}
	    	else
	    	{
	    		formObj.agreement_no.value    = "";
		    	formObj.agmt_iss_ofc_cd.value = "";
		    	formObj.agmt_lstm_cd.value    = "";
		    	formObj.cre_dt.value     = "";
		    	
		    	sheetObjects[0].RemoveAll();
		    	ComShowCodeMessage("CGM10004", "Agreement No.");
	 		    return true;
	 	    }
	 	}
	 	break;	
	 }
 }
/**
 * HTML Object의 이벤트 처리
 * FROM ~ TO CHASSIS NO 비교 및 UNITS계산
 */
function obj_focusout() {
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var obj = event.srcElement;

	switch(obj.name){

	case "eq_pfx_cd":
		sheetObj.CellValue(1, "eq_pfx_cd") = formObj.eq_pfx_cd.value;
		if(formObj.fm_ser_no.value != "" && formObj.eq_pfx_cd.value != ""){
			// 해당 장비 존재여부 함수 호출
	    	equipChkNo();
		}
    	if(	   formObj.fm_ser_no.value != "" 
    		&& formObj.fm_ser_no.value != null
        	&& formObj.to_ser_no.value != "" 
        	&& formObj.to_ser_no.value != null)
    	{
    		equipChkFmToValid();
    	}
		break;
		
	case "fm_ser_no":
		if(formObj.fm_ser_no.value == "" || formObj.fm_ser_no.value == null){
    			
				return false;
		} else {
	    	var pfTmp = formObj.eq_pfx_cd.value;
	    	var fmTmp = formObj.fm_ser_no.value;

	    	if(fmTmp.length == 6){
	    		var fmSerNoVal = fmTmp;
	    	} else if(fmTmp.length == 5){
	    		var fmSerNoVal = "0"+fmTmp;
	    	} else if(fmTmp.length == 4){
	    		var fmSerNoVal = "00"+fmTmp;
	    	} else if(fmTmp.length == 3){
	    		var fmSerNoVal = "000"+fmTmp;
	    	} else if(fmTmp.length == 2){
	    		var fmSerNoVal = "0000"+fmTmp;
	    	} else if(fmTmp.length == 1){
	    		var fmSerNoVal = "00000"+fmTmp;
	    	}
	    	// 폼객체에서 그리드 객체로 값 넘김.
	    	sheetObj.CellValue2(1, "fm_ser_no") = fmSerNoVal;
	    	
			formObj.fm_ser_no.value = fmSerNoVal;
	    	// 해당 장비번호가 기존재하는지 데이타확인을 위해 검색 파라메타 값을 세팅해줌
			formObj.eq_lot_no_tmp.value = pfTmp+fmSerNoVal;
	    	sheetObj.CellValue(1, "eq_lot_no") = pfTmp+fmSerNoVal;
	    	
			/*if(formObj.fm_ser_no.value != "" && formObj.eq_pfx_cd.value != ""){
				// 해당 장비 존재여부 함수 호출
		    	equipChkNo();
			}*/
			
        	if(	   formObj.fm_ser_no.value != "" 
        		&& formObj.fm_ser_no.value != null
            	&& formObj.to_ser_no.value != "" 
            	&& formObj.to_ser_no.value != null)
        	{
        		equipChkFmToValid();
        	}
		}
    	break; 

    case "to_ser_no":
    	if(formObj.to_ser_no.value == "" || formObj.to_ser_no.value == null){
    			
				return false;
    	} else {
				var toTmp = formObj.to_ser_no.value;
				if(toTmp.length == 6){
					var toSerNoVal = toTmp;
				} else if(toTmp.length == 5){
					var toSerNoVal = "0"+toTmp;
				} else if(toTmp.length == 4){
					var toSerNoVal = "00"+toTmp;
				} else if(toTmp.length == 3){
					var toSerNoVal = "000"+toTmp;
				} else if(toTmp.length == 2){
					var toSerNoVal = "0000"+toTmp;
				} else if(toTmp.length == 1){
					var toSerNoVal = "00000"+toTmp;
				}

				formObj.to_ser_no.value = toSerNoVal;
				sheetObj.CellValue2(1, "to_ser_no") = toSerNoVal;
				
	        	if(	   formObj.fm_ser_no.value != "" 
	        		&& formObj.fm_ser_no.value != null
	            	&& formObj.to_ser_no.value != "" 
	            	&& formObj.to_ser_no.value != null)
	        	{
    		equipChkFmToValid();
    	}
			}
    	break;
        
    case "cre_dt":
    	sheetObj.CellValue(1, "eq_lot_iss_dt") = formObj.eq_lot_iss_dt.value.replaceStr("-", "");
    	break;

    case "de_yrmon":
    	sheetObj.Cellvalue(1, "de_yrmon") = formObj.de_yrmon.value.replaceStr("-", "");     	
    	break;
	}
}


/**
 * 해당 장비 번호 존재 여부 확인
 */
function equipChkNo(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var obj = event.srcElement;
	
	// 해당 장비번호가 기존재하는지 데이타 확인
	formObj.f_cmd.value = SEARCH04;
	var sXml = sheetObj.GetSearchXml("EES_CGM_2004GS.do", FormQueryString(formObj)); //시트가 여러개일 경우 시트명 표시
	
	// 데이터 건수
	var dataCount = ComGetTotalRows(sXml);
	// 데이터가 존재할 경우
	if(dataCount > 0){
		// 중복되는 데이타가 있으면 해당 장비 번호를 띠워서 확인시켜줍니다.
		ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_lot_no"));
		if(formObj.fm_ser_no.disabled != true)
		{
			formObj.fm_ser_no.value = "";
			formObj.fm_ser_no.focus();
		}
		return;			
	}else
	{
		return;
	}
}

/**
 * 해당 장비 번호 FM- TO 존재 여부 확인 <br>
 * @param 없음
 * @return true/false
 * @author 조재성
 * @version 2009.09.25
 */ 
function equipChkFmToNo(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var obj = event.srcElement;
	// 해당 장비번호가 기존재하는지 데이타 확인
	formObj.f_cmd.value = SEARCH06;
	var sXml = sheetObj.GetSearchXml("EES_CGM_1005GS.do", FormQueryString(formObj)); //시트가 여러개일경우 시트명 표시
	// 데이터 건수
	var dataCount = ComGetTotalRows(sXml);
	// 데이터가 존재할 경우
	if(dataCount > 0){
		// 중복되는 데이타가 있으면 해당 장비 번호를 띠워서 확인시켜줍니다.
		ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_no"));
		formObj.fm_ser_no.value = "";
		formObj.to_ser_no.value = "";
		formObj.units.value = "";
		if(formObj.fm_ser_no.disabled != true)
			formObj.fm_ser_no.focus();
		return false;			
		
	}else
	{
		return true;
	}
}
 
 /**
  * 해당 장비 번호 FM- TO 존재 여부 확인 <br>
  * @param 없음
  * @return true/false
  * @author 조재성
  * @version 2009.09.25
  */ 
 function equipChkFmToValid(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var unTmp = "";
	
  	var pfTmp = formObj.eq_pfx_cd.value;
	var fmTmp = formObj.fm_ser_no.value;
	var toTmp = formObj.to_ser_no.value;
	if(fmTmp != "" && toTmp != ""){
		// FROM 값이 TO 값보다 클때
    	if(Number(toTmp) < Number(fmTmp)){
    		ComShowCodeMessage("CGM10027");
    		formObj.to_ser_no.value = "";
    		formObj.to_ser_no.focus();
    		return false;
    	}
	}
	if(fmTmp != "" && toTmp != ""){
		unTmp = ComAddComma(Number(toTmp) - Number(fmTmp) + 1)
		formObj.units.value = unTmp;
    	sheetObj.CellValue(1, "units")     = unTmp.replace(",","");
	}
	
	// 자리수를 맞춰서 그리드로 값을 세팅하고, 입력한 오브젝트에 값을 정정하여 세팅합니다.
	if(equipChkFmToNo()== false)
	{
		return false;
	}
	sheetObj.CellValue2(1, "to_ser_no") = toTmp;
	
	// CERT & CHASSIS LIST 생성하여 IBSHEET 로 값 세팅
	sheetObj.CellValue(1, "mgset_range") = pfTmp+fmTmp+" - "+pfTmp+toTmp+" "+unTmp; 
	
	return true;
 }
/**
 * PROGRAMNO POPUP 에서 해당하는 값들 입력부분.
 */   
function setProgramNo(aryPopupData, row, col, sheetIdx){
	 var formObj  = document.form;
	 var sheetObj = sheetObjects[0];
	 var agreeNo  = "";
	 var referNo  = "";
	 var officeCd = "";
	 var agreeDt  = "";
	 var lstmCd   = "";
	 var verNo    = "";
	 var vndrSeq = "";
	 var i = 0;
	 for(i = 0; i < aryPopupData.length; i++){
/*
		 //유지보수시 값 확인 하기 위하여 아래 로그 남겨 놓음 지우지 마세요.
		 alert(aryPopupData[i][0]); // VERSION NO           : 1
		 alert(aryPopupData[i][1]); // 0
		 alert(aryPopupData[i][2]); // AGREEMENT NO         : NYC003144
		 alert(aryPopupData[i][3]); // REFERENCE NO         : T008904
		 alert(aryPopupData[i][4]); // TERM                 : LT
		 alert(aryPopupData[i][5]); // LESSOR               : 105621
		 alert(aryPopupData[i][6]); // Lessor Name          : FLEXI-VNA LEASING (SML-NYC)
		 alert(aryPopupData[i][7]); // EFFECTIVE DATE(FROM) : 19970101
		 alert(aryPopupData[i][8]); // EFFECTIVE DATE(TO)   : 19991231
		 alert(aryPopupData[i][9]); // U
		 alert(aryPopupData[i][10]);// U
		 alert(aryPopupData[i][11]);// U
		 alert(aryPopupData[i][12]);// NYC
		 alert(aryPopupData[i][13]);// 3144
		 alert(aryPopupData[i][14]);
*/
		 verNo    = verNo    + aryPopupData[i][0];  // ver_no
		 agreeNo  = agreeNo  + aryPopupData[i][2];  // agreement_no
		 lstmCd   = lstmCd   + aryPopupData[i][4];  // lease term
		 officeCd = officeCd + aryPopupData[i][9];  // office_cd
		 agreeDt  = agreeDt  + aryPopupData[i][10]; // agreement date
		 vndrSeq  = vndrSeq  + aryPopupData[i][5];	// vndr_seq
	 }
	  formObj.agmt_ver_no.value     = verNo;
	  formObj.agreement_no.value    = agreeNo;
	  formObj.agmt_lstm_cd.value    = lstmCd;
	  formObj.agmt_iss_ofc_cd.value = officeCd;

	  var DtTmp                     = agreeDt;
	  if(DtTmp.length == 8)
	  {
		  var creDtTmp = DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
		  formObj.cre_dt.value    = creDtTmp;
	  }else
	  {
		  formObj.cre_dt.value	  = agreeDt;
	  }
	  
	  
	  formObj.agmt_ofc_cty_cd.value = agreeNo.substring(0, 3);
	  formObj.agmt_seq.value        = agreeNo.substring(4, 10);

	  sheetObj.CellValue(1, "agmt_ver_no")     = verNo;
	  sheetObj.CellValue(1, "agreement_no")    = agreeNo;
	  sheetObj.CellValue(1, "agmt_lstm_cd")    = lstmCd;
	  sheetObj.CellValue(1, "agmt_iss_ofc_cd") = officeCd;
	  
	  sheetObj.CellValue(1, "vndr_seq") 	   = vndrSeq;
	  sheetObj.CellValue(1, "cre_dt")          = agreeDt;
	  sheetObj.CellValue(1, "agmt_ofc_cty_cd") = agreeNo.substring(0, 3);
	  sheetObj.CellValue(1, "agmt_seq")        = agreeNo.substring(4, 10);
	  
	  agreementNoChk(lstmCd);
}


///////////////////////////////////////////////////////////////////////////////////////////////////
//아래 DomXml2String 은 컬럼 매핑등 수정없이 그대로 사용(지우지 말아 주세요)
///////////////////////////////////////////////////////////////////////////////////////////////////

function agreementNoChk(lstmCd){
	var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	if(!(lstmCd == "OW" || lstmCd == "OL" || lstmCd == "LP")){
		// 메세지를 띠워주고 해당 오브젝트를 초기화
		ComShowCodeMessage("CGM10029");
    	formObj.agreement_no.value    = "";
    	formObj.agmt_iss_ofc_cd.value = "";
    	formObj.agmt_lstm_cd.value    = "";
    	formObj.cre_dt.value     = "";
    	
    	//폼 쉬트값도 초기화해준다. 
    	sheetObj.CellValue(1, "agmt_ver_no")     = '';
		sheetObj.CellValue(1, "agreement_no")    = '';
		sheetObj.CellValue(1, "agmt_lstm_cd")    = '';
		sheetObj.CellValue(1, "agmt_iss_ofc_cd") = '';
		sheetObj.CellValue(1, "cre_dt")          = '';
		sheetObj.CellValue(1, "agmt_ofc_cty_cd") = '';
		sheetObj.CellValue(1, "agmt_seq")        = '';    	
	}
}

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.10.06
 */
function obj_keyup(){
	var formObj = document.form;
 	var sheetObj = sheetObjects[0];
 	obj = event.srcElement;
 	switch(obj.name){
		case "eq_pfx_cd":
 			if(formObj.eq_pfx_cd.value.length == 4)
 				formObj.fm_ser_no.focus();
 		break;
 	
 		case "fm_ser_no":
 			if(formObj.fm_ser_no.value.length == 6)
 				formObj.to_ser_no.focus();
 	 	break;
 		case "to_ser_no":
 			if(formObj.to_ser_no.value.length == 6)
 				formObj.units.focus();
 	 	break;
 	}
}
 

 /**
 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2010.03.05
 */     
 function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_Save");
		  ComBtnDisable("btn_FA I/F");
	  }
 }  
/* 개발자 작업 끝 */
