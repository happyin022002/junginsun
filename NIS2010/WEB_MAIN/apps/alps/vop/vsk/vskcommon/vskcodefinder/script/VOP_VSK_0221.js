/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0221.js
 *@FileTitle : Port Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.22
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.05.12 유혁
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
 * 2011.10.10 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
 * 2012.06.22 진마리아 선반영 ZD 추가
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
 * @class VOP_VSK_0221 : VOP_VSK_0221 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0221() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (validateForm(sheetObject, document.form, IBSEARCH)) {
				doActionIBSheet(sheetObject, document.form, IBSEARCH);
			}
			break;

		case "btns_popup":
			var sUrl = "/hanjin/COM_ENS_0M1.do";
			ComOpenPopupWithTarget(sUrl, 560, 470,
					"cnt_cd:tmp_cnt_cd|cnt_nm:cnt_nm|cnt_cd:loc_cd", "1,0,1", true);
			formObj.cnt_cd.value = formObj.tmp_cnt_cd.value;
			break;
			
		case "btns_calendar_s":
			var cal = new ComCalendar();
			cal.select(formObj.fm_dt, 'yyyy-MM-dd');
			break;

		case "btns_calendar_e":
			var cal = new ComCalendar();
			cal.select(formObj.to_dt, 'yyyy-MM-dd');
			break;
			
		case "btn_New":
			clearAllData();
			document.form.cnt_cd.focus();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();

	document.form.vop_port_mntr_flg.disabled = true;
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

	document.form.cnt_cd.focus();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 410;
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
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|Port|Port Name|Conti Code|Continent|Sconti Code|Sub Continent|ZD|Position|Position|Position|Position|VOSI RHQ|Office Code|EU Port|Monitoring";
			var HeadTitle2 = "|Port|Port Name|Conti Code|Continent|Sconti Code|Sub Continent|ZD|LAT|LAT|LONG|LONG|VOSI RHQ|Office Code|EU Port|Monitoring";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,0,    daCenter,  true,    "ibflag");
            InitDataProperty(0, cnt++ , dtData,    100,      daCenter,  true,    "loc_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    215,    daLeft,  true,    "loc_nm",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  true,    "conti_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "conti_nm",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  true,    "sconti_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    130,    daCenter,  true,    "sconti_nm",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  true,    "zd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "loc_lat",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    20,    daCenter,  true,    "lat_ut_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "loc_lon",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    20,    daCenter,  true,    "lon_ut_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "vskd_port_rhq_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "vop_port_ctrl_ofc_cd",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "eu_port",     false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "vop_port_mntr_flg",     false,          "",      dfNone);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {

	case IBSEARCH: // 포트 정보 조회
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0221GS.do", sParam);
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}

		break;

	case SEARCH01: // RHQ 콤보 정보 조회
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0221GS.do", sParam);
		setHtmlCombo(sXml, formObj.vskd_port_rhq_cd);
   		makeContiCd(sXml);
   		makeScontiCd(sXml);
		break;

	case SEARCH02: // Country Name 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0221GS.do", sParam);
		ComOpenWait(false);
		var nm = ComGetEtcData(sXml, "cnt_nm");
		if (nm != null) {
			formObj.cnt_nm.value = nm;
			formObj.tmp_cnt_cd.value = formObj.cnt_cd.value;
			formObj.loc_cd.value = formObj.cnt_cd.value;
		} else {
			ComShowCodeMessage('VSK00021', formObj.cnt_cd.value);
			formObj.cnt_cd.value = formObj.tmp_cnt_cd.value;
		}
		break;
		
	case SEARCH03: //Conti code change시 Sconti code 조회
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0221GS.do", sParam);
//		ComOpenWait(false);
		makeScontiCd(sXml);
		break;
	}
	ComSetFocus(formObj.cnt_cd);
}

function setHtmlCombo(xmlStr, comboObj) {
	if (xmlStr == null || xmlStr == "")
		return;

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null)
			return;

		var trNodes = xmlRoot.getElementsByTagName("TR");
		if (trNodes == null)
			return;

		for ( var i = 0; i < trNodes.length; i++) {

			if (trNodes[i].nodeType != 1) {
				continue;
			}

			if (trNodes[i].firstChild == null) {
				// html += "<option></option>";
				comboObj.options.add(new Option('', ''));
			} else {
				// html += "<option value='" + trNodes[i].firstChild.nodeValue +
				// "'>" + trNodes[i].firstChild.nodeValue + "</option>";
				value = trNodes[i].firstChild.nodeValue;
				value = value.replace(/~/g, "");
				value = value.substring(2, value.length - 2);
				comboObj.options.add(new Option(value, value));
			}
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			var sCntCd = cnt_cd.value;
			var sLocCd = loc_cd.value;
			// 데이터양이 많더라고 조회하도록 허용. 2009.05.14
			
			if(!(formObj.fm_loc_lat.value == '' && formObj.to_loc_lat.value == '' && formObj.fm_lat_ut_cd.value == '' && formObj.to_lat_ut_cd.value == '')){
				if(!(formObj.fm_loc_lat.value != '' && formObj.to_loc_lat.value != '' && formObj.fm_lat_ut_cd.value != '' && formObj.to_lat_ut_cd.value != '')){
					ComShowMessage("Please check LAT");
					return false;
				}else if(formObj.fm_loc_lat.value > 90 || formObj.to_loc_lat.value > 90){
					ComShowMessage("LAT must be smaller than 90.");
					return false;
				}else if(formObj.fm_lat_ut_cd.value == formObj.to_lat_ut_cd.value){
					if(formObj.fm_loc_lat.value > formObj.to_loc_lat.value){
						ComShowMessage("From LAT cannot be larger than To LAT");
						return false;
					}
				}
				
			}
			
			if(!(formObj.fm_loc_lon.value == '' && formObj.to_loc_lon.value == '' && formObj.fm_lon_ut_cd.value == '' && formObj.to_lon_ut_cd.value == '')){
				if(!(formObj.fm_loc_lon.value != '' && formObj.to_loc_lon.value != '' && formObj.fm_lon_ut_cd.value != '' && formObj.to_lon_ut_cd.value != '')){
					ComShowMessage("Please check LONG");
					return false;
				}else if(formObj.fm_loc_lon.value > 180 || formObj.to_loc_lon.value > 180){
					ComShowMessage("LONG must be smaller than 180.");
					return false;
				}else if(formObj.fm_lat_ut_cd.value == formObj.to_lat_ut_cd.value){
					if(formObj.fm_loc_lat.value > formObj.to_loc_lat.value){
						ComShowMessage("From LONG cannot be larger than To LONG");
						return false;
					}
				}
			}
			
			break;
		}
	}

	return true;
}

function initControl() {
	// Axon 이벤트 처리1. 이벤트catch
	var formObj = document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj); // - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'eng_keypress', formObj); // - 영문 대문자만 입력하기
	axon_event.addListener('keyup', 'obj_keyup', 'cnt_cd');
	axon_event.addListener('keypress', 'enter_keypress', 'form'); // - Enter 키 처리
	axon_event.addListener('keyup', "VskKeyFocus", 'form'); // - 자동포커스 처리
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur', formObj); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerForm  ('click', 'obj_click', form);
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_change() {
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "cnt_cd":
			with (formObj) {
				if (cnt_cd.value == '') {
					loc_cd.value = '';
					cnt_nm.value = '';
					tmp_cnt_cd.value = '';
				} else {
					if (ComChkLen(cnt_cd.value, 2) == 2) { // 길이가 2이면 국가코드 조회
						if (tmp_cnt_cd.value != cnt_cd.value) {
							doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
						}
					}
				}
			}

			break;

		case "vskd_port_rhq_cd":
			if (0 != formObj.vskd_port_rhq_cd.selectedIndex) {
				formObj.vop_port_mntr_flg.disabled = false;
			} else {
				formObj.vop_port_mntr_flg.selectedIndex = 0;
				formObj.vop_port_mntr_flg.disabled = true;
			}
			break;
			
		case "conti_cd":
			//sconti_cd 지우고
			doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
			break;
			
//		case "vsl_svc_tp_cd":
//			ComShowMessage("안돼");
//			formObj.vsl_svc_tp_cd[0].checked = true;
//			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function obj_click(){
	var formObj = document.form;
	obj = event.srcElement;      	

	if(obj.name == "vsl_svc_tp_cd"){
		if(formObj.fm_dt.value == "" || formObj.to_dt.value == ""){
			ComShowMessage("Please input the Period data");
			formObj.vsl_svc_tp_cd[0].checked = true;
		}
	}
}

function obj_keyup() {
	var formObj = document.form;
	if (event.srcElement.value == "") {
		formObj.loc_cd.value = '';
		formObj.cnt_nm.value = '';
		formObj.tmp_cnt_cd.value = '';
	}
}

/**
 * onBlur처리 
 * @return
 */
function obj_blur(){

	 var formObj = document.form;
  	 obj = event.srcElement;      	
  	 
  	 with(formObj){
		 switch(obj.name) {
    	    case "fm_dt":	// From Date
     			var fmDt = ComReplaceStr(fm_dt.value,"-","");
     			var toDt = ComReplaceStr(to_dt.value,"-","");
     			if(fmDt != ""){
     				var dt = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
     				if(dt != ""){
     					if(toDt != ""){
     						if(fmDt > toDt){
     							ComShowCodeMessage('COM12133','To date','From date','greater');
     							fm_dt.value='';
     							fm_dt.focus();
     							return false;
     						}
     					}
     					formObj.fm_dt.value = ComGetMaskedValue(formObj.fm_dt.value, "ymd");
     				}else{
     					ComShowCodeMessage('VSK00003');
     					fm_dt.value='';
     					fm_dt.focus();
     				}
     			}
     			break;
    	            
   	    	case "to_dt":	// To Date
   				var fmDt = ComReplaceStr(fm_dt.value,"-","");
   				var toDt = ComReplaceStr(to_dt.value,"-","");
   	    		if(toDt != ""){
   	    			var dt = ComGetMaskedValue(formObj.to_dt.value, "ymd");
   	    			if(dt != ""){
   	    				if(fmDt != ""){
   	    					if(fmDt > toDt){
   	    						ComShowCodeMessage('COM12133','To date','From date','greater');
   	    						to_dt.value='';
   	    						to_dt.focus();
   	    						return false;
   	    					}
   	    				}
   	    				formObj.to_dt.value = ComGetMaskedValue(formObj.to_dt.value, "ymd");
   	    			}else{
   	    				ComShowCodeMessage('VSK00003');
   	    				to_dt.value='';
   	    				to_dt.focus();
   	    			}
   	    		}
   	           	break;	

   	    	case "fm_loc_lat":
  		 	case "to_loc_lat":
  		 		if(!ComChkObjValid(obj, false)){
  		 			ComShowCodeMessage("VSK01018", "LAT");
  		 		}
  		 		break;
  		 	case "fm_loc_lon":
  		 	case "to_loc_lon":
  		 		if(!ComChkObjValid(obj, false)){
  		 			ComShowCodeMessage("VSK01018", "Long");
  		 		}
  		 		break;
  		 }
		 return true;
  	 }
 }

function eng_keypress() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	switch (srcName) {
	case "cnt_cd":
	case "loc_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "loc_nm":
		if (event.keyCode != 32) { // 공백입력가능
			ComKeyOnlyAlphabet('upper');
		}
		break;
	case "fm_loc_lat":
	case "to_loc_lat":
	case "fm_loc_lon":
	case "to_loc_lon":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress() {
	VskKeyEnter();
}
 
function clearAllData() {
	var formObj = document.form;
	sheetObjects[0].RemoveAll();
	formObj.reset();
}

function makeContiCd(sXml) {
	var formObj = document.form;
	var conti_cd_arr = ComGetEtcData(sXml, "conti_cd");
	var contiCdcomboObj = formObj.conti_cd;
		
	contiCdcomboObj.options.length = 0;
	contiCdcomboObj.options.add(new Option("ALL", ""));
	
	if(conti_cd_arr){
		conti_cd_arr = conti_cd_arr.split("|");
		for(var i=0; i<conti_cd_arr.length; i++){
			var arr = conti_cd_arr[i].split(":");
			contiCdcomboObj.options.add(new Option(arr[1], arr[0]));
		}
	}
}

function makeScontiCd(sXml){
	var formObj = document.form;
	var sconti_cd_arr = ComGetEtcData(sXml, "sconti_cd");
	var scontiCdcomboObj = formObj.sconti_cd;
	
	scontiCdcomboObj.options.length = 0;
	scontiCdcomboObj.options.add(new Option("ALL", ""));
	
	if(sconti_cd_arr){
		sconti_cd_arr = sconti_cd_arr.split("|");
		for(var i=0; i<sconti_cd_arr.length; i++){
			var arr = sconti_cd_arr[i].split(":");
			scontiCdcomboObj.options.add(new Option(arr[1], arr[0]));
		}
	}
}

/* 개발자 작업 끝 */