/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0001.js
 *@FileTitle : Vessel Report Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.12
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation 
 * History
 * 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
 * 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설 
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
 * @class VOP_FCM_0001 : VOP_FCM_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0001() {
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
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var fmDtTmp = "";
var toDtTmp = "";
var status = false;

var callbackevent = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	var sheetObject6 = sheetObjects[5];
	var sheetObject7 = sheetObjects[6];
	var sheetObject8 = sheetObjects[7];
	var sheetObject9 = sheetObjects[8];
	var sheetObject10 = sheetObjects[9];

	/** **************************************************** */
	var tabObj    = tabObjects[0];
	var formObj = document.form;
	var selTabIdx = tabObj.SelectedIndex;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btn_Retrieve":
				var vSearch = '';
				if(selTabIdx == 0){
					vSearch = SEARCH01;
				} else if (selTabIdx == 1){
					vSearch = SEARCH02;
				}
//				else if (selTabIdx == 2){
//					vSearch = SEARCH03;
//				} 
				else if (selTabIdx == 2){
					vSearch = SEARCH04;
				}
				doActionIBSheet(sheetObjects[selTabIdx], formObj, vSearch);
				break;
	
			case "btn_popup_crr_cd":
				var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX";
				var rVal = ComOpenPopupWithTarget(sUrl, 550, 406, "", "0,0", true);
				if (rVal) {
					formObj.crr_cd.value = rVal;
				}
				break;
			
			case "btns_calendarfm":
				var cal = new ComCalendar();
				cal.select(formObj.fm_dt, 'yyyy-MM-dd');
				break;
			
			case "btns_calendarto":
				var cal = new ComCalendar();
				cal.select(formObj.to_dt, 'yyyy-MM-dd');
				break;
			
			case "btn_port":	//Location 조회 팝업
				var cnt_cd = "";
				var loc_cd = formObj.loc_cd.value;
		    	var sUrl = "/hanjin/VOP_VSK_0043.do";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
				if(rVal){
					formObj.loc_cd.value = rVal;
					loc_cd_onchange();
				}					
				break;
				
			case "btn2_mail": 
				var chkRow = sheetObject2.FindCheckedRow("ibcheck");
				if (chkRow == "") {
	            	ComShowCodeMessage("FCM00007");
				} else {
					ComFcmSendMail(sheetObject2, formObj, mailObj);
				}
				break;	
				
				
			case "btn2_delete1":
				var delCnt = 0;
				for(var i=0; i<sheetObject3.SearchRows+2; i++){
					if(sheetObject3.CellValue(i, "ibflag")=="D"){
						delCnt ++;
					}
				}
				if(delCnt>0){
					doActionIBSheet(sheetObject3,formObj,IBDELETE);
				}
				break;
				
			case "btn2_delete2":
				var delCnt = 0;
				for(var i=0; i<sheetObject4.SearchRows+2; i++){
					if(sheetObject4.CellValue(i, "ibflag")=="D"){
						delCnt ++;
					}
				}
				if(delCnt>0){
					doActionIBSheet(sheetObject4,formObj,IBDELETE);
				}
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    
	document.form.vsl_cd.focus();
	initControl();
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("keypress",		 "obj_keypress",	  formObj);
	axon_event.addListenerForm("keyup",			 "obj_keyup",		  formObj);
	axon_event.addListenerForm("focus",			 "obj_activate",	  formObj);
	axon_event.addListenerForm("deactivate", 	 "obj_deactivate",	  formObj);
	axon_event.addListenerForm("propertychange", "obj_propertychange",formObj);
	
	if(formObj.fm_dt.value == ''){
	formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);
	}
	if(formObj.to_dt.value == ''){
	formObj.to_dt.value = ComGetNowInfo("ymd");
	}
	if(formObj.date.value == ''){
		formObj.date.value = ComGetNowInfo("ymd");
	}

}


function obj_activate() {
	switch(event.srcElement.name){
		case "fm_dt":
			fmDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			break;
		case "to_dt":
			toDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			break;
	}
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_deactivate() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = event.srcElement;
	
	switch(obj.name){
		case "fm_dt":
			fmDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함
			break;
		case "to_dt":
			toDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함
			break;
	}
	
}

function obj_keyup() {
	
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = event.srcElement;

	switch(obj.name){
	}
}

function obj_keypress() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = event.srcElement;
	switch(obj.name){
		case "fm_dt":
		case "to_dt":
			ComKeyOnlyNumber();
			break;
		case "vsl_slan_cd":
		case "vsl_cd":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "vps_port_cd":
		case "skd_dir_cd":
			ComKeyOnlyAlphabet("upper");
			break;
	}

}

function obj_propertychange(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = event.srcElement;
	
	if(event.propertyName=="value"){
		switch(obj.name){
			case "fm_dt":
				if(obj.value.replace(/-/gi, "")==fmDtTmp){
					return false;
				}
				if(!status){
					searchVslRptInfo();
				}
				break;
			case "to_dt":
				if(obj.value.replace(/-/gi, "")==toDtTmp){
					return false;
				}
				if(!status){
					searchVslRptInfo();
				}
				break;
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 387;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 28;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Lane|Count|Count|Count|Count|Count";
			var HeadTitle2 = "Lane|VVD|Call\nPort|DEP.\nRep|Not\nRcv|Over\nlap";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			33,		daCenter,	    true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		false,	"vvd_cnt",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,	"port_cnt",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,	"dep_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,	"not_rcv_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		false,	"over_lap_cnt",		false,	"",			dfNone,			0,			true,		true);
			
			WaitImageVisible = false;

		}
		break;
		
	case 2: // t1sheet2 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 387;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 22;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Sel|Lane|VVD|Dep.\nPort|Next\nPort|Date\n(Dep)|Call\nSeq|vsl_eng_nm";
			var HeadTitle2 = "|Lane|VVD|Dep.\nPort|Next\nPort|Date\n(Dep)|Call\nSeq|vsl_eng_nm";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,  	22,		daCenter,  	true,   "ibcheck");
			InitDataProperty(0, cnt++ , dtData,			33,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"vvd",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			42,		daCenter,	true,	"vps_port_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			42,		daCenter,	true,	"nxt_port_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			62,		daCenter,	true,	"vps_etd_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			15,		daCenter,	true,	"clpt_ind_seq",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		10,		daCenter,	true,	"vsl_eng_nm",		false,	"",			dfNone,			0,			false,		false);

			WaitImageVisible = false;
//			ScrollBar = 2;
		}
		break;
		
	case 3: // t1sheet3 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 387;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 22;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|Del|Lane|VVD|Dep.\nPort|Error\nType|Error\nType|||||||";
			var HeadTitle2 = "||Lane|VVD|Dep.\nPort|Error\nType|Error\nType||||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);


			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, 		daCenter,  true, 	"ibflag");
			InitDataProperty(0, cnt++ , dtDelCheck,  	22,		daCenter,  	true,   "ibcheck");
			InitDataProperty(0, cnt++ , dtData,			33,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"vvd",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"dep_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"dep_rpt_err_tp_cd",	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"intg_cd_val_desc",		false,	"",			dfNone,			0,			true,		true);

			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"dep_rpt_err_seq",	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"clpt_ind_seq",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"nxt_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"rup_dt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"sb_eng_dt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"rcv_dt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,	"rcv_seq",		false,	"",			dfNone,			0,			true,		true);



			WaitImageVisible = false;
		}
		break;	
		
	case 4: // t1sheet4 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 387;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 22;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|Del|Lane|VVD|Dep.\nPort|CLPT_IND_SEQ|";
			var HeadTitle2 = "||Lane|VVD|Dep.\nPort|CLPT_IND_SEQ|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, 		daCenter,  true, 	"ibflag");
			InitDataProperty(0, cnt++ , dtDelCheck,  	22,		daCenter,  	true,   "ibcheck");
			InitDataProperty(0, cnt++ , dtData,			33,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			68,		daCenter,	true,	"vvd",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	"dep_port_cd",		false,	"",			dfNone,			0,			true,		true);
			
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"dep_rpt_err_seq",	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			50,		daCenter,	true,	"clpt_ind_seq",	false,	"",			dfNone,			0,			true,		true);

			WaitImageVisible = false;
		}
		break;

	case 5: // t2sheet1 init [Noon Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 22;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Lane|Count|Count|Count|Count|Count|Count";
			var HeadTitle2 = "Lane|VVD|Calling\nPort|Sea\nDays|Noon|Missing|Mismatched";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"vvd_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"port_days",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"sea_days",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"noon_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"mss_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"mss_mtch_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			
			WaitImageVisible = false;
		}
		break;	
		
	case 6: // t2sheet2 init [Noon Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 50;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "Lane|VVD|Dep.\nPort|Next Port|Date";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vvd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"dep_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"nxt_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"",		false,	"",			dfNone,			0,			true,		true);
			
			WaitImageVisible = false;

		}
		break;	
		
	case 7: // t2sheet3 init [Noon Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 50;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//var HeadTitle1 = "Lane|VVD|Calling\nSEQ|Dep.\nPort|Next\nPort|Date|Ref.\nNo.";
			var HeadTitle1 = "Lane|VVD|Next\nPort|Date|Ref.\nNo.";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"vvd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"dep_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"nxt_port_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"rpt_dt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"ref_no",		false,	"",			dfNone,			0,			true,		true);
			
			WaitImageVisible = false;

		}
		break;
		
//	case 7: // t3sheet1 init [AB-Log]
//		with (sheetObj) {
//
//			tabIndex = -1;
//
//			// 높이 설정
//			style.height = 420;
//			// 전체 너비 설정
//			SheetWidth = mainTable.clientWidth;
//			// 해더 높이 설정
//			sheetObj.HeadRowHeight = 22;
//			
//			// Host정보 설정[필수][HostIp, Port, PagePath]
//			if (location.hostname != "")
//				InitHostInfo(location.hostname, location.port, page_path);
//
//			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msHeaderOnly;
//
//			// 전체Edit 허용 여부 [선택, Default false]
//			Editable = false;
//
//			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//			InitRowInfo(2, 1, 3, 100);
//
//			// 해더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false)
//
//			var HeadTitle1 = "Lane|Count|Count|Count|Count";
//			var HeadTitle2 = "Lane|VVD|Ab-Log|Missing|Mismatched";
//			var headCount = ComCountHeadTitle(HeadTitle1);
//
//			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//			InitColumnInfo(headCount, 0, 0, true);
//
//			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//			InitHeadRow(0, HeadTitle1, true);
//			InitHeadRow(1, HeadTitle2, true);
//
//			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vvd_cnt",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"ablog_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"mss_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"mss_mtch_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
//
//			WaitImageVisible = false;
//		}
//		break;	
//		
//	case 8: // t3sheet2 init [AB-Log]
//		with (sheetObj) {
//
//			tabIndex = -1;
//
//			// 높이 설정
//			style.height = 420;
//			// 전체 너비 설정
//			SheetWidth = mainTable.clientWidth;
//			// 해더 높이 설정
//			sheetObj.HeadRowHeight = 44;
//			
//			// Host정보 설정[필수][HostIp, Port, PagePath]
//			if (location.hostname != "")
//				InitHostInfo(location.hostname, location.port, page_path);
//
//			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msHeaderOnly;
//
//			// 전체Edit 허용 여부 [선택, Default false]
//			Editable = false;
//
//			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//			InitRowInfo(1, 1, 3, 100);
//
//			// 해더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false)
//
//			var HeadTitle = "Lane|VVD|Date\n(ATD)";
//			var headCount = ComCountHeadTitle(HeadTitle);
//
//			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//			InitColumnInfo(headCount, 0, 0, true);
//
//			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//			InitHeadRow(0, HeadTitle, true);
//
//			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vvd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"act_dep_dt",		false,	"",			dfNone,			0,			true,		true);
//
//			WaitImageVisible = false;
//		}
//		break;	
//		
//	case 9: // t3sheet3 init [AB-Log]
//		with (sheetObj) {
//
//			tabIndex = -1;
//
//			// 높이 설정
//			style.height = 420;
//			// 전체 너비 설정
//			SheetWidth = mainTable.clientWidth;
//			// 해더 높이 설정
//			sheetObj.HeadRowHeight = 44;
//			
//			// Host정보 설정[필수][HostIp, Port, PagePath]
//			if (location.hostname != "")
//				InitHostInfo(location.hostname, location.port, page_path);
//
//			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msHeaderOnly;
//
//			// 전체Edit 허용 여부 [선택, Default false]
//			Editable = false;
//
//			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//			InitRowInfo(1, 1, 3, 100);
//
//			// 해더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false)
//
//			var HeadTitle = "Lane|VVD|Reported\nDate|Calling\nSEQ";
//			var headCount = ComCountHeadTitle(HeadTitle);
//
//			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//			InitColumnInfo(headCount, 0, 0, true);
//
//			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//			InitHeadRow(0, HeadTitle, true);
//
//			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vvd",		false,	"",			dfNone,			0,			true,		true);
//			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"rpt_dt",		false,	"",			dfNone,			0,			true,		true);
//
//			WaitImageVisible = false;
//		}
//		break;	
		
	case 8: // t4sheet1 init [ROB/Month end]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 22;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Lane|Count|Count|Count|Count";
			var HeadTitle2 = "Lane|Vessel|ROM|Missing|Mismatched";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vsl_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"rob_mth_end_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"mss_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"mss_mtch_rpt_cnt",		false,	"",			dfNone,			0,			true,		true);

			WaitImageVisible = false;
		}
		break;	
		
	case 9: // t4sheet2 init [ROB/Month end]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 44;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//var HeadTitle = "Lane|Vessel|REV.\nMonth";
			var HeadTitle = "Vessel|REV.\nMonth";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vsl_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"rev_yrmon",		false,	"",			dfNone,			0,			true,		true);

			WaitImageVisible = false;
		}
		break;	
		
	case 10: // t4sheet3 init [ROB/Month end]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// 해더 높이 설정
			sheetObj.HeadRowHeight = 44;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//var HeadTitle = "Lane|Vessel|REV.\nMonth";
			var HeadTitle = "Vessel|REV.\nMonth";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"vsl_slan_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"vsl_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"rev_yrmon",		false,	"",			dfNone,			0,			true,		true);

			WaitImageVisible = false;
		}
		break;	
		
	}
 }

///**
//* t1sheet1 MouseMove 이벤트 
//* @param {ibsheet} sheet 해당 시트   
//* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
//* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
//* @param {long} X X 좌표
//* @param {long} Y Y 좌표
//*/
//function t1sheet1_OnMouseMove(sheetObj , button, shift, X, Y) {
//   var sName = sheetObj.ColSaveName(sheetObj.MouseCol);   
//   if (sheetObj.MouseRow > 0 && "vvd_cnt" == sName) {	   
//	   sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,"vvd_cnt");   
//   } else {
//	   sheetObj.MouseToolTipText = "";
//   }
//}
//
///**
//* t2sheet1 MouseMove 이벤트 
//* @param {ibsheet} sheet 해당 시트   
//* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
//* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
//* @param {long} X X 좌표
//* @param {long} Y Y 좌표
//*/
//function t2sheet1_OnMouseMove(sheetObj , button, shift, X, Y) {
//   var sName = sheetObj.ColSaveName(sheetObj.MouseCol);   
//   if (sheetObj.MouseRow > 0 && "port_days" == sName) {	   
//	   sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,"port_days");   
//   }else if (sheetObj.MouseRow > 0 && "sea_days" == sName) {	   
//	   sheetObj.MouseToolTipText = sheetObj.CellText(sheetObj.MouseRow,"sea_days");   
//   } else {
//	   sheetObj.MouseToolTipText = "";
//   }
//}

	//Sheet더블클릭시 Pop-up처리
	function t1sheet3_OnDblClick(sheetObj, row, col){
		var colSaveName = sheetObj.ColSaveName(col);
		var Value = sheetObj.CellValue(row, col);
		var formObj = document.form;
		if(sheetObj.CellValue(row, "dep_rpt_err_tp_cd") == "IE" || sheetObj.CellValue(row, "dep_rpt_err_tp_cd") == "IM"){
			openItemErrPop(sheetObj, row);
		}else {
			openPkErrPop(sheetObj, row);
		}
	}	
	
	//Sheet더블클릭시 Pop-up처리
	function t1sheet4_OnDblClick(sheetObj, row, col){
		var colSaveName = sheetObj.ColSaveName(col);
		var Value = sheetObj.CellValue(row, col);
		var formObj = document.form;
		openOverLapPop(sheetObj, row);

	}	
	 
	 function openPkErrPop(sheetObj, row) {
	 	var formObj = document.form;
	 	var sParam = Array();
	 	var idx = 0;	

	 	//검색창에서 Period 와 Vessel 정보
	 	sParam[idx++] = "pfFmDt="		+ formObj.fm_dt.value;
	 	sParam[idx++] = "pfToDt="		+ formObj.to_dt.value;
//	 	sParam[idx++] = "pfVslCd="		+ formObj.vsl_cd.value;
	 	
	 	//PK error 시트에 hidden으로 추가 요청 start
	 	sParam[idx++] = "pVslSlanCd="		+ sheetObj.CellValue(row, "vsl_slan_cd");
	 	sParam[idx++] = "pVVD="				+ sheetObj.CellValue(row, "vvd");
	 	sParam[idx++] = "pClptIndSeq="		+ sheetObj.CellValue(row, "clpt_ind_seq");
	 	sParam[idx++] = "pDepPortCd="		+ sheetObj.CellValue(row, "dep_port_cd"); //dep_port_cd, mss_port_cd
	 	sParam[idx++] = "pNxtPortCd="		+ sheetObj.CellValue(row, "nxt_port_cd");
		sParam[idx++] = "pRupDt="			+ sheetObj.CellValue(row, "rup_dt");
		sParam[idx++] = "pSbEngDt="			+ sheetObj.CellValue(row, "sb_eng_dt");
		sParam[idx++] = "pDepRptErrSeq="	+ sheetObj.CellValue(row, "dep_rpt_err_seq");
		sParam[idx++] = "prcvDt="			+ sheetObj.CellValue(row, "rcv_dt");
		sParam[idx++] = "prcvSeq="			+ sheetObj.CellValue(row, "rcv_seq");
		sParam[idx++] = "pUiId=VOP_FCM_0001";
		 
	 	var theURL = "VOP_FCM_0003.do?"+sParam.join("&");
	    var winName = "PKErrorPop";
	    var features = "scroll:no;status:no;resizable=no;help:no;dialogWidth:730px;dialogHeight:470px";
	    ComOpenWindow(theURL,winName,features,true);
		    	
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);

		 
	    
	 }
	 
	 function openItemErrPop(sheetObj, row) {
	 	var formObj = document.form;
	 	var sParam = Array();
	 	var idx = 0;
	 	
	 	sParam[idx++] = "dep_rpt_err_seq="	+ sheetObj.CellValue(row, "dep_rpt_err_seq");
	 	sParam[idx++] = "vvd="				+ sheetObj.CellValue(row, "vvd");
	 	sParam[idx++] = "dep_port_cd="		+ sheetObj.CellValue(row, "dep_port_cd");
	 	sParam[idx++] = "clpt_ind_seq="		+ sheetObj.CellValue(row, "clpt_ind_seq"); //dep_port_cd, mss_port_cd
	 	sParam[idx++] = "call_ui_id=VOP_FCM_0001";

	 	var theURL = "VOP_FCM_0004.do?"+sParam.join("&");
	    var winName = "VOP_FCM_0004";
	    var features = "scroll:no;status:no;resizable=no;help:no;dialogWidth:1500px;dialogHeight:650px";
	    ComOpenWindow(theURL,winName,features,true);
	    
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);

	}

	 
	 function openOverLapPop(sheetObj, row) {
	 	var formObj = document.form;
	 	var sParam = Array();
	 	var idx = 0;
	 	
	 	sParam[idx++] = "dep_rpt_err_seq="	+ sheetObj.CellValue(row, "dep_rpt_err_seq");
	 	sParam[idx++] = "vvd="				+ sheetObj.CellValue(row, "vvd");
	 	sParam[idx++] = "dep_port_cd="		+ sheetObj.CellValue(row, "dep_port_cd");
	 	sParam[idx++] = "clpt_ind_seq="		+ sheetObj.CellValue(row, "clpt_ind_seq"); //dep_port_cd, mss_port_cd
	 	sParam[idx++] = "call_ui_id=VOP_FCM_0001";
	 	
	 	var theURL = "VOP_FCM_0005.do?"+sParam.join("&");
	    var winName = "VOP_FCM_0005";
	    var features = "scroll:no;status:no;resizable=no;help:no;dialogWidth:1500px;dialogHeight:650px";
	    ComOpenWindow(theURL,winName,features,true);
	    	
	    
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);

	 }
	 
	//Sheet관련 프로세스 처리
	 function doActionIBSheet(sheetObj, formObj, sAction) {
	 	sheetObj.ShowDebugMsg = false;
	 	switch (sAction) {
	 		case SEARCH: // 조회부 기본 조회
	 			if(validateForm(sheetObj, formObj, sAction)){
	 				 if(comboObjects[0].Text == "" && comboObjects[1].Text == "" && comboObjects[2].Text == ""){
			 			ComOpenWait(true);
			 			formObj.f_cmd.value = SEARCH;
			 			
			 			formObj.vsl_slan_cd.removeAll();
			 			formObj.vsl_cd.removeAll();
			 			formObj.vps_port_cd.removeAll();
			 			var sXml = sheetObj.GetSearchXml("VOP_FCM_COM_0001GS.do",
			 					FormQueryString(formObj));
			 			
			 			var vslSlanCds = (","+ComGetEtcData(sXml, "vsl_slan_cd")).split(",");
			 			var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
			 			var vpsPortCds = (","+ComGetEtcData(sXml, "vps_port_cd")).split(",");
			 			for(var i=0; i<comboObjects.length; i++){
			 				if(comboObjects[i].id == "vsl_slan_cd"){
								appendMultiComboItem(comboObjects[i], vslSlanCds, vslSlanCds, "");
		//						setSelectMultiText(comboObjects[i], formObj.vsl_arr_dlay_rsn_nm);
							}else if(comboObjects[i].id == "vsl_cd"){
								appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
		//						setSelectMultiText(comboObjects[i], formObj.vsl_brth_dlay_rsn_nm);
							}else if(comboObjects[i].id == "vps_port_cd"){
								appendMultiComboItem(comboObjects[i], vpsPortCds, vpsPortCds, "");
		//						setSelectMultiText(comboObjects[i], formObj.vsl_dep_dlay_rsn_nm);
							}
			 			}
			 			
			 			ComOpenWait(false);
	 				 }
	 			}
	 			break;
		 	case SEARCH01: // TAB1 조회
		 		if(validateForm(sheetObj, formObj, sAction)){
		 			ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH01;
		 			
		 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0001GS.do",
		 					FormQueryString(formObj));
		 			var arrXml = sXml.split("|$$|");		 		
		 			var arrCt = arrXml.length;
		 			if (arrXml != null && arrCt > 0) {
		 				for (var sRstCt=arrCt; sRstCt>0; sRstCt--) {
		 					sheetObjects[sRstCt-1].Redraw = false;
		 					sheetObjects[sRstCt-1].LoadSearchXml(arrXml[sRstCt-1]);
		 					sheetObjects[sRstCt-1].Redraw = true;
		 				}
		 			}			
		 			
		 			ComOpenWait(false);
		 		}
		 		break;
		 	case SEARCH02: // TAB2 조회
		 		if(validateForm(sheetObj, formObj, sAction)){
		 			ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH02;
		 			
		 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0001GS.do",
		 					FormQueryString(formObj));
		 			var arrXml = sXml.split("|$$|");
		 			var arrCt = arrXml.length;
		 			if (arrXml != null && arrCt > 0) {
		 				for (var i=0; i<arrCt+1; i++) {
		 					sheetObjects[i+3].Redraw = false;
		 					sheetObjects[i+3].LoadSearchXml(arrXml[arrCt-i]);
		 					sheetObjects[i+3].Redraw = true;
		 				}
		 			}			
		 			
		 			ComOpenWait(false);
		 		}
		 		break;
//			case SEARCH03: // TAB3 조회
//				if(validateForm(sheetObj, formObj, sAction)){
//		 			ComOpenWait(true);
//		 			formObj.f_cmd.value = SEARCH03;
//		 			
//		 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0001GS.do",
//		 					FormQueryString(formObj));
//		 			var arrXml = sXml.split("|$$|");
//		 			var arrCt = arrXml.length;
//		 			if (arrXml != null && arrCt > 0) {
//		 				for (var i=0; i<arrCt+1; i++) {
//		 					sheetObjects[i+6].Redraw = false;
//		 					sheetObjects[i+6].LoadSearchXml(arrXml[i]);
//		 					sheetObjects[i+6].Redraw = true;
//		 				}
//		 			}			
//		 			
//		 			ComOpenWait(false);
//				}
//		 	    break;
			case SEARCH04: // TAB4 조회	 	
				if(validateForm(sheetObj, formObj, sAction)){
					ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH04;
		 			
		 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0001GS.do",
		 					FormQueryString(formObj));
		 			var arrXml = sXml.split("|$$|");
		 			var arrCt = arrXml.length;
		 			
		 			if (arrXml != null && arrCt > 0) {
		 				for (var i=0; i<arrCt; i++) {
		 					sheetObjects[i+7].Redraw = false;
		 					sheetObjects[i+7].LoadSearchXml(arrXml[i]);
		 					sheetObjects[i+7].Redraw = true;
		 				}
		 			}					
		 			
		 			ComOpenWait(false);
				}
		 	    break;
		 	    
			case IBDELETE: 
				if (sheetObj.id == "t1sheet3"){				// Error 항복삭제
					var SaveStr = ComGetSaveString(sheetObj);
					ComOpenWait(true);
					formObj.f_cmd.value = REMOVE01;
					var sXml = sheetObj.GetSaveXml("VOP_FCM_0001GS.do", FormQueryString(formObj) + "&" + SaveStr);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}else{										// Overlap 항목삭제
					var SaveStr = ComGetSaveString(sheetObj);
					ComOpenWait(true);
					formObj.f_cmd.value = REMOVE02;
					var sXml = sheetObj.GetSaveXml("VOP_FCM_0001GS.do", FormQueryString(formObj) + "&" + SaveStr);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}
				break;
				
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
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
                InsertTab( cnt++ , "Departure Report" , -1 );
				InsertTab( cnt++ , "Noon Report" , -1 );                    
//				InsertTab( cnt++ , "AB-Log" , -1 );
				InsertTab( cnt++ , "ROB/Month end" , -1 );
            }
         break;
     }
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
    switch(comboObj.id) {
		case "vsl_slan_cd":
			with (comboObj) { 
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 320;
				//Style = 1;
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 3;
			}
			break;
		case "vsl_cd":
			with (comboObj) { 
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 320;
				//Style = 1;
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 4;
			}
			break;
		case "vps_port_cd":
			with (comboObj) { 
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 320;
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 5;
			}
			break;
    	case "skd_dir_cd":
    		with (comboObj) { 
				MultiSelect = false;
				DropHeight = 320;
				InsertItem(0, 'E','E');
				InsertItem(1, 'W','W');
				InsertItem(2, 'S','S');
				InsertItem(3, 'N','N');
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 1;
			}
			break;
     }
}

/**
 * vsl_slan_cd에서 OnChange가 발생하는 경우 이벤트처리
 * @param comboObj
 * @param Index_Code
 * @param Text
 * @return
 */   
function vslSlanCdOnChange(){ 
	//alert(comboObj +" :: "+ Index_Code + " :: "+ Text);
	var formObj = document.form;
	var tabObj    = tabObjects[0];
	formObj.vsl_cd.removeAll();
	formObj.vps_port_cd.removeAll();
	var sCondition = new Array (
			new Array("MdmOrganization","SEARCH",comboObjects[0].Code)   //Office
		); 	
	var comboList = ComSearchVslSlanCd(sheetObjects[tabObj.SelectedIndex],sCondition);
} 
/**
 *  vsl_slan_cd에서 OnChange가 발생하는 경우 이벤트처리
 * @param	{Array[][]}	sCondition 서버에서 조회할 조회조건과 값의 배열
 * @return  {Array[][]} 코드|코드디스크립션의 배열의 배열을 리턴한다.
 */
function ComSearchVslSlanCd(sheetObj,sCondition){
	var formObj = document.form;
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH + '&';

	for (var i = 0;i < sCondition.length; i++){
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'vsl_slan_cd' + '=' + sCondition[i][2] + '&';
		f_query += 'fm_dt' + '=' + formObj.fm_dt.value + '&';
		f_query += 'to_dt' + '=' + formObj.to_dt.value + '&';
	}
	//마지막에 &를 없애기 위함
	//f_query = FcmDelLastDelim(f_query);
	if (f_query != ""){
		f_query = f_query.substr(0, f_query.length - 1);
	}

	var sXml = sheetObj.GetSearchXml("VOP_FCM_COM_0001GS.do","" ,f_query,true);
	var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
	var vpsPortCds = (","+ComGetEtcData(sXml, "vps_port_cd")).split(",");
	for(var i=0; i<comboObjects.length; i++){
		if(comboObjects[i].id == "vsl_cd"){
			appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
		}else if(comboObjects[i].id == "vps_port_cd"){
			appendMultiComboItem(comboObjects[i], vpsPortCds, vpsPortCds, "");
		}
	}
}

/**
 * vsl_cd에서 OnChange가 발생하는 경우 이벤트처리
 */   
function vslCdOnChange(){ 
	var formObj = document.form;
	var tabObj    = tabObjects[0];
	formObj.vps_port_cd.removeAll();
	var sCondition = new Array (
			new Array("MdmOrganization","SEARCH",comboObjects[1].Code)   //Office
		); 	
	var comboList = ComSearchVslCd(sheetObjects[tabObj.SelectedIndex],sCondition);
} 
/**
 *  vsl_slan_cd에서 OnChange가 발생하는 경우 이벤트처리
 * @param	{Array[][]}	sCondition 서버에서 조회할 조회조건과 값의 배열
 * @return  {Array[][]} 코드|코드디스크립션의 배열의 배열을 리턴한다.
 */
function ComSearchVslCd(sheetObj,sCondition){
	var formObj = document.form;
	var f_query = '';
	//쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH + '&';

	for (var i = 0;i < sCondition.length; i++){
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'vsl_cd' + '=' + sCondition[i][2] + '&';
		f_query += 'fm_dt' + '=' + formObj.fm_dt.value + '&';
		f_query += 'to_dt' + '=' + formObj.to_dt.value + '&';
	}
	//마지막에 &를 없애기 위함
	//f_query = FcmDelLastDelim(f_query);
	if (f_query != ""){
		f_query = f_query.substr(0, f_query.length - 1);
	}

	var sXml = sheetObj.GetSearchXml("VOP_FCM_COM_0001GS.do","" ,f_query,true);
	var vpsPortCds = (","+ComGetEtcData(sXml, "vps_port_cd")).split(",");
	for(var i=0; i<comboObjects.length; i++){
		if(comboObjects[i].id == "vps_port_cd"){
			appendMultiComboItem(comboObjects[i], vpsPortCds, vpsPortCds, "");
		}
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
* Tab 클릭시 이벤트 관련
* 선택한 탭의 data 조회한다.
*/
function tab1_OnClick(tabObj , nItem)
{
	if ( nItem == 0 ) {
	    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	} else if ( nItem == 1 ) {	//POL-POD Pair탭 클릭시
			//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
 	} else if ( nItem == 2 ) {	//CNTR List탭 클릭시
			//doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
 	}   
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
		case SEARCH:
		case SEARCH01:
		case SEARCH02:
//		case SEARCH03:
		case SEARCH04:
			var fmDt = formObj.fm_dt;
			var toDt = formObj.to_dt;
			if(ComChkObjValid(fmDt) && ComChkObjValid(toDt)){
                if(parseInt(toDt.value.replace(/-/g, '')) < parseInt(fmDt.value.replace(/-/g, ''))) {
                	ComShowCodeMessage("COM12133", "To Date", "From Date", "greater");
    				return false;
    			}else{
				    return true;
				}
//			}else{
				return false;
			}
			break;
	}
}

/**
 * Mutil Combo에 item을 추가한다.
 * @param comboObj
 * @param optionCds
 * @param optionTxts
 * @param selCode
 * @return
 */
function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
	comboObj.InsertItem(0, "ALL", '');
	for(var i=1; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionCds[i], optionTxts[i]);
	}
}

function searchVslRptInfo(){
	status = true;
	var formObj = document.form;
	var fmDt = formObj.fm_dt;
	var toDt = formObj.to_dt;
	
	if((fmDt && fmDt.value!='') && (toDt && toDt.value!='')){
		var fmDtStr = fmDt.value.replace(/-/gi, "");
		var toDtStr = toDt.value.replace(/-/gi, "");
		if(ComChkLen(fmDtStr, 8)==2 && ComChkLen(toDtStr, 8)==2){
			doActionIBSheet(sheetObjects[0], formObj, SEARCH);
		}
	}
	
	status = false;
}

function vsl_slan_cd_OnCheckClick(comboObj,index){
 	if(index==0) { 	    	
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
 	
}

function vsl_cd_OnCheckClick(comboObj,index){
 	if(index==0) { 	    	
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
 	
}

function vps_port_cd_OnCheckClick(comboObj,index){
 	if(index==0) { 	    	
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

function vsl_slan_cd_OnBlur(){
	vslSlanCdOnChange();
}

function vsl_cd_OnBlur(){
	vslCdOnChange();
}



/**
 * [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
 * 
 * Mail Preview 팝업 화면 열기
 * @param {object}  sheetObj               필수, Sheet Object
 * @param {object}  formObj                필수, Form Object
 * @param {object}  mailObj                필수, Value Object
 * @param {boolean} returnYn               선택, 메일링 후 후처리 여부
 * @param {string}  sDomain                선택, 메일링 후 후처리 도메인(저장만 해당)
 * @param {string}  returnProc             선택, 메일링 후 후처리 추가 프로세스
 */    
var mailObj = new Object();  
function ComFcmSendMail(sheetObj, formObj, mailObj, returnYn, sDomain, returnProc) {
	var mailParams = new Array("com_rdSubSysCd","com_from","com_recipient","com_carbonCopy","com_blindCarbonCopy","com_subject","com_content","com_fileKey","com_template","com_argument");
	    try {
	    	 	    	
	    	ComOpenWait(true, true);
	    	
	    	var chkRowArr = sheetObjects[1].FindCheckedRow("ibcheck").split("|");

	    	// check 된 row 의 vsl_cd 를 구한다.
	    	var vslCdArr = "";
	        for (var i=0; i<chkRowArr.length-1; i++) {
	        	var vslCd = sheetObjects[1].CellValue(chkRowArr[i], "vvd").substr(0,4)+",";
	        	vslCdArr += vslCd;
	        }
	        formObj.vsl_cd_arr.value = vslCdArr;
	    	
	        formObj.f_cmd.value = SEARCH11;
	        var sXml = sheetObj.GetSearchXml("VOP_FCM_0001GS.do", FormQueryString(formObj));
	        var mailParamObjs = document.getElementById('mail_param');
	        if(mailParamObjs == null) {
	    	var paramDiv = document.createElement("<div name='mail_param' id='mail_param' style='display:'></div>");	
	    	var paramObj;
	    	for(var idx=0; idx<=mailParams.length; idx++) {   
	    		paramObj = document.createElement("<input type='hidden' name='"+mailParams[idx]+"' value=''>");
	    		paramDiv.appendChild(paramObj); 
	    	}
	    	paramObj = document.createElement("<input type='hidden' id='com_mailKeyFlag' value=''>");
    		paramDiv.appendChild(paramObj); 
    		
	    	formObj.appendChild(paramDiv);
	        }
    	
	        var date = formObj.date.value;
	        var contents = "";
	        	contents += "Date : "+ date +"<br>" ;
	        	contents += "To   : " + sheetObjects[1].CellValue(chkRowArr[0], "vsl_eng_nm") + "<br>";
	        	contents += "                                                                                            		 				<br>";
	        	contents += "From : Maritime Technology Team, Fuel Management Part / SM Line        				<br>";
	        	contents += "                                                                                            		 				<br>";
				contents += "Always thanks for your kind co-operation.                                                 				<br>";
				contents += "                                                                                                    				<br>";
				contents += "We didn't receive the below reports from your vessel until now.                       				<br>";
				contents += "Please send us below missed report to cvslmgr@smlines.com & eco-fuel@smlines.com, again.		<br>";
				contents += "                                                                                                    				<br>";
				contents += "<table width=100% border=2 style='border-collapse: collapse; background-color: white; color: #272727;'>      <br>";
				contents += "	<tr style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'> <br>";
				contents += "		<td>Lane</td>                                                                   			 <br>";
				contents += "		<td>VVD</td>                                                                    			 <br>";
				contents += "		<td>DEP. Port</td>                                                           			 <br>";
				contents += "		<td>Next Port</td>                                                           			 <br>";
				contents += "		<td>DEP Date(ETD)</td>                                                           			 <br>";
				contents += "	</tr>                                                                               			 <br>";
		
	        for (var i=0; i<chkRowArr.length-1; i++) {
				contents += "	<tr>                                                                        	        <br>";
				contents += "		<td align=center>"+ sheetObjects[1].CellValue(chkRowArr[i], "vsl_slan_cd")  +"</td> <br>";
				contents += "		<td align=center>"+ sheetObjects[1].CellValue(chkRowArr[i], "vvd")  +"</td>         <br>";
				contents += "		<td align=center>"+ sheetObjects[1].CellValue(chkRowArr[i], "vps_port_cd")   +"</td><br>";								
				contents += "		<td align=center>"+ sheetObjects[1].CellValue(chkRowArr[i], "nxt_port_cd")  +"</td>   <br>";
				contents += "		<td align=center>"+ sheetObjects[1].CellValue(chkRowArr[i], "vps_etd_dt")  +"</td>   <br>";
				contents += "	</tr>                                                                                   <br>";
	        	
	        }		
			
			contents += "</table>                                                                                       <br>";
			contents += "                                                                                                    				<br>";
			contents += "We hope your cooperation.																					<br>";
			contents += "Thank you.																										<br>";
			contents += "                                                                                                    				<br>";
			contents += "PIC of Vessel Data Manager																					<br>";
			contents += "Maritime Technology Team, Fuel Management Part / SM Line								<br>";
			contents += "E-Mail :  eco-fuel@smlines.com																				<br>";
			contents += "TEL : ++82-51-460-8235																						<br>";
			
	    	ComSetObjValue(formObj.f_cmd,          ComGetEtcData(sXml, SEARCH11));
	    	ComSetObjValue(formObj.com_rdSubSysCd, "COM");
	    	ComSetObjValue(formObj.com_from,       ComGetEtcData(sXml, "from_psn"));
	    	ComSetObjValue(formObj.com_recipient,  ComGetEtcData(sXml, "to_psn"));
	    	ComSetObjValue(formObj.com_subject,    ComGetEtcData(sXml, "subject"));
	    	ComSetObjValue(formObj.com_content, contents);
	    	ComSetObjValue(formObj.com_mailKeyFlag,returnYn);
	    	
	    	ComOpenWait(false);
	    	
    	//Waitting 이미지로 인한 창 스크롤 생성 방지용
			document.body.scroll = "no";
			ComSendMailModal();
						
		//초기화
		ComSetObjValue(formObj.f_cmd,          "");
    	ComSetObjValue(formObj.com_rdSubSysCd, "");
    	ComSetObjValue(formObj.com_from,       "");
    	ComSetObjValue(formObj.com_recipient,  "");
    	ComSetObjValue(formObj.com_carbonCopy, "");
    	ComSetObjValue(formObj.com_subject,    "");
    	ComSetObjValue(formObj.com_content,    "");
    	ComSetObjValue(formObj.com_fileKey,    "");
    	ComSetObjValue(formObj.com_mailKeyFlag,"");
	    } catch(err) { ComFuncErrMsg(err.message); }
	}

/* 개발자 작업 끝 */