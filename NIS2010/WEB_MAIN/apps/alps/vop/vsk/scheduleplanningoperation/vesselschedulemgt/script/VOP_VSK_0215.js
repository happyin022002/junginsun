/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0215.js
 *@FileTitle : Add Call Information (Pop-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.14
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.06.05 유혁
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
 * @class VOP_VSK_0215 : VOP_VSK_0215 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0215() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_ok":
			if (validateForm(formObj)) {
				var info = new Object();
				info.port_cd = formObj.port_cd.value;
				info.yard_cd = formObj.yard_cd.value;
				
				if(formObj.eta_day && formObj.eta_time){
					info.eta = formObj.eta_day.value + formObj.eta_time.value;
				}else{
					info.eta = "";
				}
				info.etb = formObj.etb_day.value + formObj.etb_time.value;
				info.etd = formObj.etd_day.value + formObj.etd_time.value;
				
				if (formObj.turn_ind) {
					info.turn_ind = formObj.turn_ind.value;
				}
				
				info.eta = info.eta.replace(/\/|\-|\:|\./g, "");
				info.etb = info.etb.replace(/\/|\-|\:|\./g, "");
				info.etd = info.etd.replace(/\/|\-|\:|\./g, "");
				
				for ( var i = 0; formObj.position
						&& i < formObj.position.length; i++) {
					if (formObj.position[i].checked) {
						info.position = formObj.position[i].value;
						break;
					}
				}
				
				window.returnValue = info;
				comPopupOK();
			}
			break;

		case "btn_close":
			window.close();
			break;

		case "btn_search1": // Port 조회 팝업
			// var sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
			var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="
					+ formObj.port_cd.value;
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
			if (rVal) {
				formObj.port_cd.value = rVal;
				formObj.port_cd.select();
			}
			break;
			
		case "eta_btn_cal":
			var cal = new ComCalendar();
			cal.select(formObj.eta_day, 'yyyy-MM-dd');
			break;

		case "etb_btn_cal":
			var cal = new ComCalendar();
			cal.select(formObj.etb_day, 'yyyy-MM-dd');
			break;

		case "etd_btn_cal":
			var cal = new ComCalendar();
			cal.select(formObj.etd_day, 'yyyy-MM-dd');
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	if (document.form.pos_flg.value == "B") {
		document.form.position[1].checked = true;
		document.form.position[0].disabled = true;
	} else if (document.form.pos_flg.value == "A") {
		document.form.position[0].checked = true;
		document.form.position[1].disabled = true;
	}

	initControl();
	
	// port_cd가 존재하는 경우 그에 해당하는 yd_cd를 조회하여 yd_cd위치에 select tag로 출력한다.
	// yd_cd값이 이미 존재하는 경우 select의 해당 option tag를 selected 상태로 지정한다.
	var portCd = formObj.port_cd.value;
	var yardCd = "";
	
	if(formObj.yard_cd){
		yardCd = formObj.yard_cd.value;
		if(portCd!="" && yardCd==""){
			loadYdCd(portCd);
		}
	}
}

function initCombo(comboObj, comboNo) {
	var formObj = document.form;
    switch(comboObj.id) {
		case "yd_cd":
    		with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("25|340");
				DropHeight = 160;
	    	}
    		break;
     }
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(1, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // Port 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		sParam = sParam + "&loc_cd=" + formObj.port_cd.value;
		//var rXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do", sParam);
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0215GS.do", sParam);
		ComOpenWait(false);
		var nm = ComGetEtcData(rXml, "loc_nm");
		if (!nm) {
			ComShowCodeMessage('VSK00029', formObj.port_cd.value);
			return false;
		}
		return true;
		break;
	case SEARCH01: // Yard 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		sParam = sParam + "&loc_cd=" + formObj.port_cd.value;
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0215GS.do", sParam);
		ComOpenWait(false);
		var ydCds = ComGetEtcData(rXml, "yd_cd").split("|");
		var ydNms = ComGetEtcData(rXml, "yd_nm").split("|");
		//ydCds는 마지막 두자리만 나오도록 조정
		for(var i=0; i<ydCds.length; i++){
			ydCds[i] = ydCds[i].substring(5, 7);
		}
		appendMultiComboItem(comboObjects[0], ydCds, ydNms, "");
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj) {
	with (formObj) {

		// Port Code 검증
		if (ComChkLen(port_cd, 5) != 2) {
			ComShowCodeMessage("VSK00027", "Port Code");
			port_cd.select();
			return false;
		}
		
		// Yard Code 검증
		if("Y"==showYard.value && ComChkLen(yard_cd, 7) != 2) {
			ComShowCodeMessage("VSK00027", "Yard Code");
			return false;
		}
		
		// ETA 날짜검증
		if (formObj.eta_day && !ComIsDate(eta_day.value)) {
			ComShowCodeMessage('VSK00003');
			eta_day.value = '';
			eta_day.select();
			return false;
		}

		// ETB 날짜검증
		if (!ComIsDate(etb_day.value)) {
			ComShowCodeMessage('VSK00003');
			etb_day.value = '';
			etb_day.select();
			return false;
		}

		// ETD 날짜검증
		if (!ComIsDate(etd_day.value)) {
			ComShowCodeMessage('VSK00003');
			etd_day.value = '';
			etd_day.select();
			return false;
		}

		var form = null;
		var to = null;

		// ETA - ETB 검사
		if (formObj.eta_day && eta_day.value != "") {
			from = eta_day.value + eta_time.value;
			to = etb_day.value + etb_time.value;

			from = from.replace(/\/|\-|\:/g, ""); // 날짜구분자 없애기
			to = to.replace(/\/|\-|\:/g, ""); // 날짜구분자 없애기

			if (from - to >= 0) {
				ComShowCodeMessage('VSK00025', 'ETB', 'ETA');
				eta_day.select();
				return false;
			}
		}

		// ETB - ETD 검사
		from = etb_day.value + etb_time.value;
		to = etd_day.value + etd_time.value;

		from = from.replace(/\/|\-|\:/g, ""); // 날짜구분자 없애기
		to = to.replace(/\/|\-|\:/g, ""); // 날짜구분자 없애기

		if (from - to >= 0) {
			ComShowCodeMessage('VSK00025', 'ETD', 'ETB');
			etb_day.select();
			return false;
		}

		return true;

	}

}

function initControl() {
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('focus', 'obj_focus', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListener('keyup', "VskKeyFocus", 'form'); // - 자동포커스 처리
}

function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "float":
		// 숫자+"."입력하기
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
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum":
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

function obj_focus() {
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
	case "eta_day":
	case "eta_time":
	case "etb_day":
	case "etb_time":
	case "etd_day":
	case "etd_time":
		ComClearSeparator(event.srcElement);
		break;
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_blur() {
	// 입력Validation 확인 및 마스킹 처리
	switch (event.srcElement.name) {
	case "eta_day":
	case "eta_time":
	case "etb_day":
	case "etb_time":
	case "etd_day":
	case "etd_time":
		ComChkObjValid(event.srcElement);
		break;
	default:
		break;
	}
}

function obj_change() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (obj.name) {
	case "eta_day":
		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
			ComShowCodeMessage('VSK00003');
			obj.value = '';
			obj.select();
			return false;
		}
		break;
	case "etb_day":
		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
			ComShowCodeMessage('VSK00003');
			obj.value = '';
			obj.select();
			return false;
		}
		break;
	case "etd_day":
		if (obj.value != '' && !ComIsDate(obj.value, "ymd")) {
			ComShowCodeMessage('VSK00003');
			obj.value = '';
			obj.select();
			return false;
		}
		break;
	case "eta_time":
		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
			ComShowCodeMessage('VSK00004');
			obj.value = '';
			obj.select();
			return false;
		}
		break;
	case "etb_time":
		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
			ComShowCodeMessage('VSK00004');
			obj.value = '';
			obj.select();
			return false;
		}
		break;
	case "etd_time":
		if (obj.value != '' && !ComIsTime(obj.value, "hm")) {
			ComShowCodeMessage('VSK00004');
			obj.value = '';
			obj.select();// obj.select();
			return false;
		}
		break;
	case "port_cd":
		if (obj.value != '') {
			if(doActionIBSheet(sheetObjects[0], formObj, IBSEARCH)){
				if(formObj.yd_cd){
					loadYdCd(formObj.port_cd.value);
				}else{
					formObj.eta_day.focus();
				}
			}else{
				clearYdCd();
				formObj.port_cd.value = '';
				formObj.port_cd.select();
			}
		}

		break;
	}
}

function clearYdCd(){
	var formObj = document.form;
	if(formObj.yd_cd){
		formObj.yd_cd.RemoveAll();
		formObj.yard_cd.value = "";
	}
}

function loadYdCd(portCd){
	var formObj = document.form;
	if(portCd){
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		formObj.yd_cd.focus();
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
	comboObj.RemoveAll();
	
	for(var i=0; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
	}
	
	comboObj.Code2 = selCode;
}

function yd_cd_OnChange(comboObj, Code, Text){
	var formObj = document.form;
	formObj.yard_cd.value = formObj.port_cd.value + comboObj.Code;
}

/* 개발자 작업 끝 */