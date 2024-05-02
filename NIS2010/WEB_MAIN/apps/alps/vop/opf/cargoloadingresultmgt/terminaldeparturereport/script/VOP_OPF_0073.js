/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VOP_OPF_0073.js
 *@FileTitle : Vessel Not Operationally Ready Report Summary Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.12
 *@LastModifier : 이병훈
 *@LastVersion : 1.0
 * 2015.05.12 이병훈
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
 * @class VOP_FCM_0073 : VOP_FCM_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0073() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
			case "btn_New":
				clearAll();
				break;
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObj1, formObj, IBSEARCH);
				break;
				
			case "btn_Down_Excel":
				sheetObj2.Down2Excel(0, false, false, true);
				break;
				
			case "from_to_calendar": // From 달력버튼
				var cal = new ComCalendarFromTo();
				cal.select(formObj.from_date, formObj.to_date, 'yyyy-MM-dd');
			    break;
			    
			case "btn_vslpop":
				openVslCdHelp(sheetObj1);
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
	var formObj = document.form;
	
	//IBSheet 초기화
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	initCombo();
	set_from_date(); // From Date 날짜 세팅
	formObj.vnor_offh_tp_cd.Enable = false;
}

//From Date 날짜 세팅
function set_from_date() {
	var formObj = document.form;
	var vNowDate = formObj.now_date.value;
	formObj.from_date.value = ComGetDateAdd(vNowDate, "M", -1).substr(0, 8)+"01";
	formObj.to_date.value = vNowDate;
}

/**
 * Vessel Code Help 파일을 오픈한다
 */
function openVslCdHelp(sheetObj) {
	var sUrl = "VOP_VSK_0219.do?vsl_cd="+document.form.vsl_cd.value+"&inc_del_vsl_pop=Y";
	ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
}

function getVslCdData(obj) {
	if (obj) {
		var rtnDatas = obj[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				document.form.vsl_cd.value = rtnDatas[1];
			}
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
	
	case 1: // sheet1 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 430;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, true, false, false);
			
			var HeadTitle1 = "Vessel|Saved Date|Submitted Date|Kind|Type|Off-hire|OPF Status|Created By|FMS Status|off_hire_time_cd";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		"vsl_cd",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		130,	daCenter,		true,		"sa_dt",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		130,	daCenter,		true,		"su_dt",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		"vnor_offh_knd_cd",	false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		180,	daCenter,		true,		"vnor_offh_tp_cd",	false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		false,		"oh_itm_val",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		90,		daCenter,		true,		"vnor_stup_sts_cd",	false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		true,		"created_by",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		90,		daCenter,		true,		"fms_sts_cd",			false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,		true,		"off_hire_time_cd",	false,		"",	dfNone,			0,	false,	false);
		}
		break;
		
	case 2: // sheet2 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 430;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, true, false, false);
			
			var HeadTitle1 = "Vessel|Voy no.|Saved Date|Submitted Date|Off-Hire Time|Off-Hire Time|Off-Hire Time|Off-Hire Time|Place|Port|Port|Kind|Type|OPF Status|Created By|FMS Status|Other Loss|Other Loss|Other Loss|Other Loss|Other Loss|Other Loss|Other Loss|Other Loss|Other Loss";
			var HeadTitle2 = "Vessel|Voy no.|Saved Date|Submitted Date|From|To|Hrs|Remark|Place|From|To|Kind|Type|OPF Status|Created By|FMS Status|HFO|MDO|LSFO|LSDO|Port Charge|TMNL Charge|Others|Office|Remark";
			
			var headCount = ComCountHeadTitle(HeadTitle2);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		"vsl_cd",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		"skd_voy_no",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		"sa_dt",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		"su_dt",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		false,		"vnor_offh_fm_dt",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		false,		"vnor_offh_to_dt",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"oh_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,			false,		"oh_itm_rmk",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		"vnor_vsl_sts_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"vnor_fm_port_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"vnor_to_port_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		"vnor_offh_knd_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		150,	daCenter,		true,		"vnor_offh_tp_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		true,		"vnor_stup_sts_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		true,		"created_by",				false,		"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		true,		"fms_sts_cd",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"hf_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"md_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"lf_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"ld_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"pc_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"tc_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"ot_itm_val",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"vnor_itm_ofc_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,			false,		"ot_itm_rmk",			false,	"",	dfNone,			0,	false,	false);
		}
		break;
	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다.
 */
function initControl() {
	var formObj = document.form;
	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm("activate", "obj_activate", formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListenerForm ('blur', 'obj_blur', form);
}

/**
 * 콤보리스트를 생성한다.
 */
function initCombo() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	// 콤보 목록 가져오기 : Kind Code
	doActionIBSheet(sheetObj, formObj, SEARCHLIST01);
	// 콤보 목록 가져오기 : Status Code
	setStatusCombo();
}

/**
 * Keypress 이벤트 처리
 */
function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch (obj.dataformat) {
		case "engup":
			//영문대문자 입력하기
			ComKeyOnlyAlphabet('upper');
			break;
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			break;
	}
}

/**
 * Activate 이벤트 처리
 */
function obj_activate() {
   	switch(event.srcElement.name){ 	    	
		case "from_date":
			ComClearSeparator(event.srcElement);
			break;
		case "to_date":
			ComClearSeparator(event.srcElement);
			break;
	}
}

/** 	
 * 업무 자바스크립트 Onblur 이벤트 처리  <br>
 */    
function obj_blur() {
	obj = event.srcElement;
	var formObj = document.form;
	switch(obj.name) {

		case "from_date":
			if( formObj.from_date.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("from_date", "");
                	setFocus("from_date");
                    return false;
                }else{
//                	if( formObj.to_date.value != ""){
//                		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
//                			ComAlertFocus(formObj.from_date, ComGetMsg("OPF50021"));
//                			setObjValue("from_date", "");
//                			return false;
//                		}
//                	}
                }
            }
			break;
			
		case "to_date":
			if( formObj.to_date.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("to_date", "");
                	setFocus("to_date");
                    return false;
                }else{
//                	if( formObj.from_date.value != ""){
//                		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
//                			ComAlertFocus(formObj.to_date, ComGetMsg("OPF50021"));
//                			setObjValue("to_date", "");
//                			return false;
//                		}
//                	}
                }
            }
			break;
			
	}
}

/**
 * Change 이벤트 처리
 */
function obj_change() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;

	switch (obj.name) {
		case "vsl_cd":	 // Vessel
			var vsl_cd = formObj.vsl_cd.value;
			if (vsl_cd.length != 4) {
				break;
			}
			
			if (!doActionIBSheet(sheetObj, formObj, SEARCH01)) { // VSL CODE가 유효하면
				ComShowCodeMessage("OPF50004", vsl_cd);
				formObj.vsl_cd.value = "";
			}
			break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
		case SEARCHLIST01: // Kind Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST01;
			formObj.intg_cd_id.value = "CD03388";
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_offh_knd_cd);
			ComOpenWait(false);
			break;
			
		case SEARCHLIST05: // Kind별 Type Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST05;
			formObj.intg_cd_id.value = "CD03384";
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_offh_tp_cd);
			ComOpenWait(false);
			break;
			
		case SEARCH01: // Vessel Code Check
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var isVslOk = ComGetEtcData(sXml, "is_vsl_ok");
			ComOpenWait(false);
			if (isVslOk == "Y") {
				return true;
			} else {
				return false;
			}
			break;
			
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0073GS.do", FormQueryString(formObj));
				// Sheet 데이터 셋팅
				sheetObjects[0].LoadSearchXml(sXml);
				sheetObjects[1].LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var formObj = document.form;
	
	switch (sAction) {
	case IBSEARCH:
		var from_date = getDateObj(formObj.from_date.value);
		var to_date = getDateObj(formObj.to_date.value);
		
		if (from_date > to_date) {
	    	ComShowCodeMessage("OPF50013", "To Date", "From Date");
	    	return false;
		}
		
		if (formObj.vsl_cd.value.length > 0 && formObj.vsl_cd.value.length != 4) {
			ComShowCodeMessage("OPF50004", "Vessel");
			formObj.vsl_cd.value = "";
			return false;
		}
		
		return true;
		break;
	}
}

/**
 * New 버튼 처리
 */
function clearAll() {
	ComResetAll();
	initCombo();
	set_from_date(); // From Date 날짜 세팅
	document.form.vnor_offh_tp_cd.Enable = false;
}

/**
 * 콤보 리스트를 생성한다.
 */
function setCombo(arrCombo, comboObj) {
	if (arrCombo != null) {
		var arrVal  = arrCombo[0].split("|");
		var arrName = arrCombo[1].split("|");
		comboObj.RemoveAll();
		comboObj.InsertItem(-1, "ALL", "ALL");
		for (var i = 0 ; i < arrVal.length ; i++) {
			comboObj.InsertItem(-1, arrVal[i], arrName[i]);
		}
	}
}

/**
 * Kind 값 변경시 처리
 */
function vnor_offh_knd_cd_OnChange() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
	if (formObj.vnor_offh_knd_cd.Code != "ALL") {
		formObj.intg_cd_val_ctnt.value = formObj.vnor_offh_knd_cd.Code;
		doActionIBSheet(sheetObj, formObj, SEARCHLIST05);
		formObj.vnor_offh_tp_cd.Enable = true;
	} else {
		formObj.vnor_offh_tp_cd.Code2 = "ALL";
		formObj.vnor_offh_tp_cd.Enable = false;
	}
}

/**
 * Sheet 더블클릭 시 처리
 */
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var vsl_cd = sheetObjects[0].CellValue(row, "vsl_cd");
	var off_hire_time_cd = sheetObjects[0].CellValue(row, "off_hire_time_cd");
	ComOpenWindow("/hanjin/VOP_OPF_0071.do?vsl_cd="+vsl_cd+"&off_hire_time_cd="+off_hire_time_cd, "VNOR Report Creation", "", false);
}

/**
 * Status Combo 생성
 */
function setStatusCombo() {
	var statusCombo = document.form.vnor_stup_sts_cd;
	statusCombo.InsertItem(-1, "ALL", "ALL");
	statusCombo.InsertItem(-1, "OPF Saved", "SA");
	statusCombo.InsertItem(-1, "OPF Submitted", "SU");
	statusCombo.InsertItem(-1, "FMS Saved", "S");
	statusCombo.InsertItem(-1, "FMS Approval", "A");
	statusCombo.InsertItem(-1, "FMS Non Approval", "N");
	statusCombo.InsertItem(-1, "FMS C/C", "C");
}
/* 개발자 작업 끝 */