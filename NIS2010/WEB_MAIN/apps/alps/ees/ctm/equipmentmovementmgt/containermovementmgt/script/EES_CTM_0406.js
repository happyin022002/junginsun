/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ui_ctm_0406.js
 * @FileTitle : International MVMT
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.06.12
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.06.12 우경민 1.0 Creation
 * History
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
 * 2014.05.26 김용습 [CHM-201430368] [CTM] pop up msg 반복해서 보여지지 않도록 수정
 * 2016.03.14 김상현 [CHM-201640325] Cntr check digit에 Wording 추가
 */
/**
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class ui_ctm_0406 : ui_ctm_0406 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ui_ctm_0406() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// Container. Booking 번호가 변경되는 경우를 감지하기 위해 사용
// 현재 Row와 이전 Row를 가지고 값을 저장한 후 포커스가 이동 할 경우
// 이 값을 비교하여 달라진 경우 변경으로 인식하고 Check 함수를 호출한다
var sheetRow = 0;
var sheetCol = 0;
var crntContainer = "";
var sheetContainer = "";
var sheetContainerFlg = null;
var sheetBkgValue = "";
var crntBkgValue = false;
var sheetBkgValueFlg = null;
var selectedRow = null;
var etaEtdPass = true;
var focusCheck = true;
// 오류가 난 행에서 다른 오류 행을 클릭 했을 경우 무한루프에 빠지는 것을 방지.
var errorRow = -1;
var errorBack = -1;
var errCount = 0;
var saveXml = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
var preChk = false; // Pre Check Button 처리여부
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_add":
			formObj.p_cntrno.value = "";
			addRow();
			break;

		case "btn_multi_add":
			formObj.p_cntrno.value = "";
			var stsOpt = formObj.p_status.value;
			if(stsOpt == "VL" || stsOpt == "VD")
			{
				addMultiRow();
			}
			break;
			
		case "btn_delete":
			// "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
			var sRowStr = sheetObject.FindCheckedRow("del_chk");
			// 자바 스크립트 배열로 만들기
			var arr = sRowStr.split("|");
			var stsCond = formObj.p_status.value;
			var delTarget = new Array();
			for (i = 0; i < arr.length - 1; i++) {
				delTarget[i] = arr[i]; // 삭제를 위해 선택row의 Status를 D로 변경
			}
			for (i = delTarget.length; i >= 0; i--) {
				if (delTarget[i])
					sheetObject.RowDelete(delTarget[i], false);
			}
			break;

		case "btn_select":
			// Booking 번호 입력 후 컨테이너를 얻어 오는 팝업 호출
			selectedRow = sheetObject.SelectRow;
			bkg_no = sheetObject.CellValue(selectedRow, "bkg_no")
			sUrl = "EES_CTM_0433.do?bkg_no=" + bkg_no;
			iWidth = "550";
			iHeight = "350";
			bModal = true;
			ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
			break;

		case "btn_qty":
			// Qty Check Popup 호출
			selectedRow = sheetObject.SelectRow;
			bkg_no = sheetObject.CellValue(selectedRow, "bkg_no")
			sUrl = "EES_CTM_0458.do?bkg_no=" + bkg_no;
			iWidth = "360";
			iHeight = "350";
			bModal = true;
			ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
			break;

		case "btn_pre":
			// VL. VD의 Precheck버튼 이벤트
			preCheck();
			break;

		case "btn_downExcel":
			// Excel Download 이벤트 호출
			sheetObject.Down2Excel();
			break;

		case "btn_loadExcel":
			// Excel Load 이벤트 처리
			if (sheetObject.LastRow >= 1) {
				if (ComShowCodeConfirm("CTM20110") != true)
					return;
				else
					sheetObject.RemoveAll();
			}
			// 실제 Load. 로딩이 끝난 후 결과를 체크한다
			rtn = sheetObject.LoadExcel();
			if (rtn == true) {
				checkValidation();
				setElementDisable(true);
			}
			break;

		case "btn_retrieve":
			// VL VD에서만 실행하도록 조정한다.
			if (checkFormField()) {
				if (document.getElementById("p_yard2").Code == '') {
					ComShowCodeMessage("CTM00000", "Yard");
					return;
				}
				var stsCond = formObj.p_status.value;
				if (stsCond == 'VL' || stsCond == 'VD')
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
			}
			break;

		case "btn_new":
			// New button 이벤트 처리. VL/VD는 Save를 비활성화 한다. 그 외는 모두 초기화한다
			sheetObject.RemoveAll();
			document.form.p_yard2.RemoveAll();
			document.getElementsByName("p_yard1")[0].value = "";
			document.getElementsByName("p_pol")[0].value = "";
			document.getElementsByName("p_pod")[0].value = "";
			document.getElementById("p_vvd").value = "";
			document.getElementById("p_type1").options.selectedIndex = 0;
			formObj.p_cntrno.value = "";
			ComBtnEnable("btn_add");

			srcValue = "";
			sheetContainer = "";
			setElementDisable(false);
			preChk = false;
			etaEtdPass = true;
			// Status가 VL. VD인 경우 save버튼을 비활성화 시킨다. (pre check 후 활성화)
			status = document.form.p_status.value;
			if (status == "VL" || status == "VD") {
				ComBtnDisable("btn_save");
				ComEnableObject(formObj.btn_multi_add, true);
			} else {
				ComBtnEnable("btn_save");
				ComEnableObject(formObj.btn_multi_add, false);
			}
			// 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
			strTime = new Date();
			y = strTime.getYear();
			m = strTime.getMonth() + 1;
			d = strTime.getDate();
			if (m < 10) m = "0" + m;
			if (d < 10) d = "0" + d;
			formObj.p_date.value = y + "-" + m + "-" + d;

			digital = new Date();
			hours = digital.getHours();
			minutes = digital.getMinutes();
			if (minutes < 10)
				minutes = "0" + minutes;
			if (hours < 10)
				hours = "0" + hours;
			document.form.p_time.value = hours + ":" + minutes;
			document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value;
			if (status != 'VL' && status != 'VD')
				ComBtnEnable("btn_loadExcel");
			break;

		case "btn_save":
			// preChkFrm은 화면의 필수 항목이 누락되어있는지 체크하는 메소드임. Save 이벤트를 호출한다.
			if (preChkFrm())
				doActionIBSheet(sheetObject, formObj, IBSAVE);
			break;

		case "btn_Calendar1":
			// 달력 호출. event date는 yyyymmddhh24mi이다. 실제 달력은 시간이없기 때문에 뒤의 시간을덧붙여서 hidden칼럼에 저장한다
			if (!window.event.srcElement.disabled) {
				var cal = new ComCalendar();
				;
				cal.select(formObj.p_date, 'yyyy-MM-dd');
				if (!document.layers && !document.all)
					return;
				digital = new Date();
				hours = digital.getHours();
				minutes = digital.getMinutes();
				if (minutes < 10)
					minutes = "0" + minutes;
				if (hours < 10)
					hours = "0" + hours;
				formObj.p_time.value = hours + ":" + minutes;
				formObj.p_date0.value = formObj.p_date.value + " " + formObj.p_time.value;
				formObj.p_date.focus();
				// cal.ComCalendar_select(formObject.p_date0, 'yyyyMMdd');
			}
			break;
		}

	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * new버튼이나 add 버튼이 클릭되면 화면을 초기화 하거나 disable시키기 위한 메소드
 */
function setElementDisable(disableType) {
	var docForm = document.form;
	DomSetFormObjDisable(docForm, disableType);
	if (disableType)
		disableType = false;
	else
		disableType = true;
	docForm.p_yard2.Enable = disableType;
}


	/**
	 *  저장 전 폼 체크.
	 */
	function preChkFrm() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		var stsCond = formObj.p_status.value;
		// 오늘 이후 자료를 넣을 수 없도록 제한한다.
		switch (stsCond) {
			case "OP":
			case "OC":
				for (i = 1; i <= sheetObject.LastRow; i++) {
					bkgValue = sheetObject.CellValue(i, "bkg_no");
					if (bkgValue == '') {
						ComShowCodeMessage("CTM10049", "booking no");
						return false;
					}
				}
			case "IC":
			case "ID":
			case "MT":
			case "EN":
			case "TN":
			case "TS":
				// OP OC는 입력하는 날짜이후로 event date가 입력되지 못하도록 막는다
				for (i = 1; i <= sheetObject.LastRow; i++) {
					evtValue = sheetObject.CellValue(i, "cnmv_evnt_dt").substring(0, 8);
					if (evtValue == '') {
						ComShowCodeMessage("CTM10049", "event date");
						return false;
					}
				}
				break;

			case "VL":
			case "VD":
				// VL VD는 입력한 날짜(시간)보다 3시간 이후면 예약으로 입력된다는 alert 출력. 7일을 초과하면 입력을 막는다.
				idx = document.form.p_date0.value;
				offSet = Number(getDateDiffTim(idx));
				status = document.form.p_status.value
				if (offSet > 7) {
					ComShowCodeMessage("CTM10054");
					// alert ("Event date can't exceed+7 days from today.");
					return false;
				} else {
					strTime = new Date();

					y = strTime.getYear();
					m = strTime.getMonth() + 1;
					d = strTime.getDate();
					h = strTime.getHours();
					n = strTime.getMinutes();
					if (m < 10) m = "0" + m;
					if (d < 10) d = "0" + d;
					if (h < 10) h = "0" + h;
					if (n < 10) n = "0" + n;
					strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
					offSet = Number(dateTimeDiff(strDt, p_date));

					if (offSet > 3) {
						//ComShowCodeMessage("CTM10002");
						// alert ("Since event date/time is 3 hour later than now,
						// movement status will not be reflected right now. Status will
						// be updated around inputted event date/time.");
						return true;
					}
				}
				break;
		}
		return true;
	}


/**
 * IBSheet Object를 배열로 등록
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

	var formObj = document.form;	
	
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], comboObjects[i].id);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	// 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
	strTime = new Date();
	y = strTime.getYear();
	m = strTime.getMonth() + 1;
	d = strTime.getDate();
	if (m < 10) m = "0" + m;
	if (d < 10) d = "0" + d;
	document.form.p_date.value = y + "-" + m + "-" + d;

	digital = new Date();
	hours = digital.getHours();
	minutes = digital.getMinutes();
	if (minutes < 10)
		minutes = "0" + minutes;
	if (hours < 10)
		hours = "0" + hours;
	document.form.p_time.value = hours + ":" + minutes;
	document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value;
	ComBtnDisable("btn_select", "btn_qty", "btn_pre", "btn_downExcel");

	ComEnableObject(formObj.btn_multi_add, false);
	
	// setEventProcess : 이벤트를 자동으로 생성한다. 파라미터로 넘어간 경우는 이벤트를 만들지 않고 반환한다.
	setEventProcess("p_status", "p_yard1", "p_date0", "p_date", "p_time", "p_vvd", "p_cntrno");
	axon_event.addListener('focus', 'date_focus', 'p_date');
	axon_event.addListener('change', 'status_Change', 'p_status');
	axon_event.addListener('change', 'time_Change', 'p_time');
	axon_event.addListener('keyup', 'yard_Change', 'p_yard1');
	axon_event.addListener('keyup', 'vvd_keyUp', 'p_vvd');
	axon_event.addListener('keyup', 'cntrno_keyUp', 'p_cntrno');
	axon_event.addListener('blur', 'date_Change', 'p_date');
	axon_event.addListener('blur', 'vvd_change', 'p_vvd');
	axon_event.addListener('keypress', 'obj_FormatString', "p_status", "p_yard1", "p_date0", "p_date", "p_time", "p_vvd", "p_cntrno");
	sheetObj = sheetObjects[0];

	document.form.p_status.focus();
}


/**
 * 콤보 Text, Value셋팅
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboId) {
	var frmObj = document.form;
	with (comboObj) {
		UseCode = true;
		switch (comboId) {
		default:
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left|left");
				SetColWidth("30|200");
				BackColor = "#CCFFFD";
				FontColor = "#373737";
				ColBackColor(0) = "#7F9DB9";
				ColFontColor(0) = "#373737";
				ColBackColor(1) = "#EFEFEF";
				ColFontColor(1) = "#373737";
				DropHeight = 160;
			}
			break;

		}
	}

}


	/**
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}


	/*
	 * 날짜가 변경 된 경우 호출된다.
	 * VL. VD는 7일을 넘기지 못하도록 제한한다. OP OC는 당일을넘기지 못하도록 제한한다
	 */
	function date_Change() {
//		obj = document.form.;
//		objValue = obj.value;

		var obj = document.form.p_date;
		// 전체 내용중 -를 삭제.
		if (!ComIsDate(obj) || !ComGetMaskedValue(obj, "ymd")) {
			ComShowCodeMessage("CTM00001");
			// obj.value = objValue;
			obj.focus();
			obj.select();
//			document.form.p_date.value = "";
			return;
		} else {
			obj.value = ComGetMaskedValue(obj, "ymd");
			if (obj.name == "p_date") {
			//document.form.p_date0.select();
			}
		}
//		2013.11.19 Error 로그 관련하여 Date Validation 수정		
//		if (objValue == '') return;
//		// 전체 내용중 -를 삭제.
//		objValue = ComGetMaskedValue(objValue, "ymd")
//		if (objValue != false) {
//			obj.value = objValue;
//			if (obj.name == "p_date") {
//			//document.form.p_date0.select();
//			}
//		} else {
//			ComShowCodeMessage("CTM00001");
//			// obj.value = objValue;
//			obj.select();
//			obj.focus();
//			return;
//		}
		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value;
		var idx = document.form.p_date0.value;
		var status = document.form.p_status.value

		if (status == 'VL' || status == 'VD') {
			//offSet = Number(getDateDiffTim(objValue));
			offSet = Number(getDateDiffTim(idx));
			if (offSet > 7) {
				ComShowCodeMessage("CTM10054");
				// alert ("Event date can't exceed+7 days from today.");
//				* 2014.05.26 김용습 [CHM-201430368] pop up msg 반복해서 보여지지 않도록 수정
//				obj.select();
//				obj.focus();
			}
			vvd = document.form.p_vvd.value;
			if (vvd.length == 9) {
				vvd_check(event);
			}
		} else {
			strTime = new Date();

			y = strTime.getYear();
			m = strTime.getMonth() + 1;
			d = strTime.getDate();
			h = strTime.getHours();
			n = strTime.getMinutes();
			if (m < 10) m = "0" + m;
			if (d < 10) d = "0" + d;
			if (h < 10) h = "0" + h;
			if (n < 10) n = "0" + n;
			strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
			p_date = document.form.p_date0.value;

			rValue = Number(dateTimeDiff(strDt, p_date));
			if (rValue > 3) {
				ComShowCodeMessage("CTM10053");
				// alert ("Event date can't exceed+0 Days from today.");
				obj.select();
				obj.focus();
			}
		}
	}


	/*
	 * 날짜가 변경 된 경우 호출된다.
	 * VL. VD는 7일을 넘기지 못하도록 제한한다. OP OC는 당일을넘기지 못하도록 제한한다
	 * date_Change와 동일하다. VL VD가 아닌 경우 3시간으로 되어있는부분은 필요할경우 바꿀 수 있음.
	 */
	function time_Change() {
		var obj = document.form.p_time;
		// 전체 내용중 -를 삭제.
		if (!ComIsTime(obj, "hm") || !ComGetMaskedValue(obj, "hm")) {
			ComShowCodeMessage("CTM00001");
			// obj.value = objValue;
			obj.focus();
			obj.select();
			document.form.p_time.value = "";
			return;
		} else {
			obj.value = ComGetMaskedValue(obj, "hm");
			if (obj.name == "p_time") {
			//document.form.p_date0.select();
			}
		}
		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value;
		var idx = document.form.p_date0.value;
		var status = document.form.p_status.value
		if (status == 'VL' || status == 'VD') {
			offSet = Number(getDateDiffTim(document.form.p_date.value));
			if (offSet > 7) {
				ComShowCodeMessage("CTM10054");
				// alert ("Event date can't exceed+7 days from today.");
				obj.select();
				obj.focus();
				return;
			}
			vvd = document.form.p_vvd.value;
			if (vvd.length == 9) {
				vvd_check(event);
			}
		} else {
			strTime = new Date();

			y = strTime.getYear();
			m = strTime.getMonth() + 1;
			d = strTime.getDate();
			h = strTime.getHours();
			n = strTime.getMinutes();
			if (m < 10) m = "0" + m;
			if (d < 10) d = "0" + d;
			if (h < 10) h = "0" + h;
			if (n < 10) n = "0" + n;
			strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
			p_date = document.form.p_date0.value;

			rValue = Number(dateTimeDiff(strDt, p_date));
			if (rValue > 3) {
				ComShowCodeMessage("CTM10053");
				// alert ("Event date can't exceed+0 Days from today.");
				obj.select();
				obj.focus();
			}
		}
	}


/**
 * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
 */
function getDateDiff(idx) {
	endDt = idx.substring(0, 4) + idx.substring(5, 7) + idx.substring(8, 10);
	strTime = new Date();
	y = strTime.getYear();
	m = strTime.getMonth() + 1;
	d = strTime.getDate();
	h = strTime.getHours();
	n = strTime.getMinutes();
	if (m < 10) m = "0" + m;
	if (d < 10) d = "0" + d;
	if (h < 10) h = "0" + h;
	if (n < 10) n = "0" + n;
	strDt = y + m + d;
	if (endDt > strDt) return 999;
}


/**
 * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
 * 비교 대상 시간만 입력받고 비교 시간은 현재로 한다. 비교는 날짜만 한다
 */
function getDateDiffTim(idx) {
	var startDt = new Date();
	var endDt = new Date(Number(idx.substring(0, 4)), Number(idx.substring(5, 7)) - 1, Number(idx.substring(8, 10)));
	resultDt = Math.floor(endDt.valueOf() / (24 * 60 * 60 * 1000) - startDt.valueOf() / (24 * 60 * 60 * 1000));
	return resultDt;
}


/**
 * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
 * 비교 대상 시간만 입력받고 비교 시간은 현재로 한다
 */
function getTimeDiff(idx) {

	var startDt = new Date();
	var endDt = new Date(Number(idx.substring(0, 4)), Number(idx.substring(5, 7)) - 1, Number(idx.substring(8, 10)), Number(idx.substring(11, 13)), Number(idx.substring(14, 16)));
	var resultDt = Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
	return resultDt;
}


/**
 * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
 */
function dateTimeDiff(idx1, idx2) {
	var startDt = new Date(Number(idx1.substring(0, 4)), Number(idx1.substring(5, 7)) - 1, Number(idx1.substring(8, 10)), Number(idx1.substring(11, 13)), Number(idx1.substring(14, 16)));
	var endDt = new Date(Number(idx2.substring(0, 4)), Number(idx2.substring(5, 7)) - 1, Number(idx2.substring(8, 10)), Number(idx2.substring(11, 13)), Number(idx2.substring(14, 16)));
	var resultDt = Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
	return resultDt;
}


/**
 * 시작일자와 종료 일자를 비교해서 며칠 차이가 나는지 확인한다.
 * 날짜만 비교한다
 */
function dateDiff(idx1, idx2) {
	var startDt = new Date(Number(idx1.substring(0, 4)), Number(idx1.substring(5, 7)) - 1, Number(idx1.substring(8, 10)));
	var endDt = new Date(Number(idx2.substring(0, 4)), Number(idx2.substring(5, 7)) - 1, Number(idx2.substring(8, 10)));
	var resultDt = Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
	return resultDt;
}


/**
 * 야드가 변경 되었을 경우 야드를 체크한다
 */
function yard_Change(event) {
	eventElement = event.srcElement;
	var status = document.form.p_status.value;
	// 야드가 5자리를 채우지 못했을 경우 다음으로진행하지 않음.
	if (eventElement.value.length < 5)
		return;
	if (srcValue == eventElement.value)
		return;
	document.form.p_yard2.RemoveAll();
	onShowErrMsg = false;
	// 야드를 체크하는 함수는 CTM 공통임. 결과를 S/F로 리턴한다
	rtn = yard_search();
	// 유효하지 않은 야드를 리턴했을 경우 yard2를 모두 지우고 경고창을 출력한 후 야드로 포커스를 이동한다.
	if (rtn && svrChk != "S") {
		document.form.p_yard2.RemoveAll();
		ComShowCodeMessage("CTM20072");
		eventElement.select();
		eventElement.focus();
		return;
	}

	// Status가 VL VD일 경우 vvd 코드 유효성 체크를 같이 진행한다. (VVD가 입력되어 있을 경우)
	if (status == "VL") {
		document.form.p_pol.value = eventElement.value;
		if (document.form.p_vvd.value != '')
			vvd_check();
			vvd_yd_check();
	} else if (status == "VD") {
		document.form.p_pod.value = eventElement.value;
		if (document.form.p_vvd.value != '')
			vvd_check();
			vvd_yd_check();
	}

	if (rtn) {
		if (curKeyCode == "9") {
			// 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
			curKeyCode = "";
			srcValue = event.srcElement.value;
		} else {
			objTmp = setFocusIndex(eventElement, 1)
			try {
				objTmp.focus();
			} catch (e) {
			}
			curKeyCode = "";
			srcValue = event.srcElement.value;
			return;

		}
	} else {
		eventElement.select();
		eventElement.focus();
	}

}


/**
 * VVD가 변경되었을 경우 VVD코드 체크.
 * @param event
 * @return
 */
function vvd_keyUp(event) {
	eventElement = event.srcElement;
	var vvdCode = eventElement.value;
	var status = document.form.p_status.value
	if (vvdCode.length == 9) {
		vvd_check(event);
		if (status == 'VL' || status == 'VD') {
			vvd_yd_check(event);
		}
	}
}


/**
 * VVD코드 체크
 */
function vvd_check() {

	formObj = document.form;
	if (formObj.p_yard1.value == '')
		return;

	strQuery = "f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.p_vvd.value
	strQuery = strQuery + "&p_pol=" + formObj.p_pol.value
	strQuery = strQuery + "&p_pod=" + formObj.p_pod.value
	rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do", strQuery);

	rtnValue = ComGetEtcData(rtnXml, "rtnStr");
	rtnStr = rtnValue.split("|");
	p_date = document.form.p_date0.value;
	status = document.form.p_status.value;
	if (rtnStr.length == 2) {
		if (status == 'VL' || status == 'VD') {
			str = rtnStr[0];
			rValue = Number(dateDiff(str, p_date));
			formObj.p_pod.focus();
			if (rValue < -1 || rValue > 1) {
				if (!ComShowCodeConfirm("CTM99999", "Vessel’s ETA/ETD is " + str + ". Do you want to keep inputted event date/time ?")) {
//					* 2014.05.26 김용습 [CHM-201430368] pop up msg 반복해서 보여지지 않도록 수정
//					formObj.p_date.select();
//					formObj.p_date.focus();
					formObj.p_vvd.select();
					formObj.p_vvd.focus();
					etaEtdPass = false;
					return false;
				}
			}
			formObj.p_pod.focus();

		}
		etaEtdPass = true;
	} else {
		etaEtdPass = false;
		ComShowCodeMessage("CTM20073");
		// alert ("VVD Code is Not Exists")
		formObj.p_vvd.select();
		formObj.p_vvd.focus();
		return false;
	}
	return true;
}


/**
 * VVD가 변경되었을 경우 VVD코드 체크.
 * @param event
 * @return
 */
function vvd_change(event) {
	eventElement = event.srcElement;
	var vvdCode = eventElement.value;
	if (vvdCode == '')
		return;
	if (vvdCode.length != 9) {
		eventElement.select();
		eventElement.focus();
	}

}

 /**
 * VVD가 변경되었을 경우 Yard Code와 입력된 Origin Yard가 같은지 Check.
 * @param event
 * @return
 */
function vvd_yd_check(event) {
	vvd = document.form.p_vvd.value;
	status = document.form.p_status.value;
	if (status == "VL" || status == "VD"){
		if (vvd.length == 9) {
			yard1 = document.form.p_yard1.value;
			yard2 = comboObjects[0].Text;
			if(yard1.length == 5 && yard2.length == 2){

				strQuery = "f_cmd=" + SEARCH05 + "&p_vvd=" +vvd
				strQuery = strQuery + "&p_yard1=" + yard1
				strQuery = strQuery + "&p_yard2=" + yard2
			
				rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do", strQuery);
				rtnValue = ComGetEtcData(rtnXml, "rtnStr");
			
				if (rtnValue == "Correction"){
					if (!ComShowCodeConfirm("CTM10055")) {
						document.getElementsByName("p_yard1")[0].value = "";
						document.getElementById("p_yard2").Code = '';

						document.form.p_yard1.focus();
						return false;
					}
				}
			}
		}
	}
} 
 
function p_yard2_OnChange(comboObj) {
	//alert(p_yard2_OnChange);
		vvd_yd_check();
}


/**
 * Cntr_No체크 [Dup. Check Digit]
 * @param event
 * @return
 */
function cntrno_keyUp(event) {
	var frmObj = document.form;

	// p_cntrno 입력되는 값의 length에 따른 처리
	frmObj.p_cntrno.value = frmObj.p_cntrno.value.toUpperCase();
	var cntr_no = frmObj.p_cntrno;
	if (!checkFormField()) {
		cntr_no.value = "";
		return;
	}

	// p_cntrno에 11글자가 채워지면 CTM 공통 함수의 cntr_search 호출
	if (cntr_no.value.length > 10) {
		var cntrNo = cntr_no.value.substr(0, 10);
		var checkDigit = cntr_no.value.substr(10, 1);

		var xml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntrNo + "&p_yard1=" + formObj.p_yard1.value);
		var rtnValue = ComGetEtcData(xml, "rtnValue");

		// 공통메소드를 호출한 결과 리턴값이 없을 경우, 컨테이너가 없는 것으로 보고 에러 처리 한다
		if (rtnValue == null || rtnValue == "") {
			ComShowCodeMessage("CTM10004"); // Container No. doesn't exist.
			cntr_no.value = "";
			ComSetFocus(cntr_no);
			return;
		} else {
			var addRowNum = addRow();
			// 정상적으로 Add Row가 되었다면 cntr_no컬럼에 cntr_no를 복사
			with (sheetObjects[0]) {
				if (Number(addRowNum) > 0) {
					ComBtnDisable("btn_add");
					CellValue(addRowNum, "cntr_no") = cntr_no.value;
					CellEditable(addRowNum, "cntr_no") = false;
					SelectCell(addRowNum, SaveNameCol("cntr_no") + 1); // sheet_OnKeyUp 이벤트 강제 발생
				}
			}
		}
	}
}

/**
 * MVMT STS가 변경 될 경우 화면의 출력 내용을 변경한다.
 * @param event
 * @return
 */
function status_Change(event) {
	frmObj = document.form;
	sheetObj = sheetObjects[0];

	eventValue = event.srcElement.value;

	switch (eventValue) {
	case "OP":
	case "OC":
		sheetObj.ColHidden(7) = false;
		sheetObj.ColHidden(8) = false;
		sheetObj.ColHidden(9) = false;
		ComBtnEnable("btn_qty");
		ComBtnEnable("btn_select");
		ComBtnEnable("btn_loadExcel");
		clearYard();
		setDisplay("none", "input");
		setStyle(eventValue, "input");
		ComBtnEnable("btn_save");
		oobj = document.getElementById("sheetFr");
		oobj.style.height = 442;
		sheetObj.style.height = 422;
		ComEnableObject(frmObj.btn_multi_add, false);
		break;
	case "IC":
	case "ID":
	case "MT":
	case "EN":
	case "TN":
	case "TS":
		sheetObj.ColHidden(7) = true;
		sheetObj.ColHidden(8) = true;
		clearYard();
		ComBtnEnable("btn_select");
		ComBtnEnable("btn_loadExcel");
		setStyle(eventValue, "input");
		setDisplay("none", "input");
		ComBtnEnable("btn_save");
		oobj = document.getElementById("sheetFr");
		oobj.style.height = 442;
		sheetObj.style.height = 422;
		ComEnableObject(frmObj.btn_multi_add, false);
		break;

	case "VL":
		sheetObj.ColHidden(7) = true;
		sheetObj.ColHidden(8) = true;
		clearYard();
		setStyle("VL", "input1");
		setDisplay("", "input1");
		ComBtnEnable("btn_pre");
		ComBtnEnable("btn_pre");
		ComBtnDisable("btn_select");
		ComBtnDisable("btn_qty");
		ComBtnDisable("btn_downExcel");
		ComBtnDisable("btn_save");
		oobj = document.getElementById("sheetFr");
		oobj.style.height = 442;
		sheetObj.style.height = 402;
		ComEnableObject(frmObj.btn_multi_add, true);
		break;
		
	case "VD":
		sheetObj.ColHidden(7) = true;
		sheetObj.ColHidden(8) = true;
		clearYard();
		setStyle("VD", "input1")
		setDisplay("", "input1");
		ComBtnEnable("btn_pre");
		ComBtnDisable("btn_select");
		ComBtnDisable("btn_qty");
		ComBtnDisable("btn_downExcel");
		ComBtnDisable("btn_save");
		oobj = document.getElementById("sheetFr");
		oobj.style.height = 442;
		sheetObj.style.height = 402;
		ComEnableObject(frmObj.btn_multi_add, true);
		break;

	}
	document.getElementsByName("p_pol")[0].value = "";
	document.getElementsByName("p_pod")[0].value = "";
	document.getElementById("p_vvd").value = "";
	document.getElementById("p_type1").options.selectedIndex = 0;

	srcValue = "";
	document.form.p_yard1.focus();
}


/**
 * 야드 및 Yard2 Combo를 초기화한다.
 * @return
 */
function clearYard() {
	frmObj = document.form;
	frmObj.p_yard1.value = "";
	frmObj.p_yard2.RemoveAll();
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
}


/**
 * 각 Status별로 보여줘야 하는 항목이달라진다. VL.VD는 아래 VVD등을 보여주도록하고 그외는 보여지지 않도록
 * 처리해준다. classtype별로 색등을 달리 지정한다. (필수항목 체크에서 사용한다)
 * @param val
 * @param classtype
 * @return
 */
function setDisplay(val, classtype) {
	frmObj = document.form;
	document.getElementById("condHidden").style.display = val;
	document.getElementById("condSearch").style.display = val;
	document.getElementById("condPreCheck").style.display = val;
	document.getElementsByName("p_vvd")[0].className = classtype;
	if (val == "")
		document.getElementById("btnExcel").style.display = "none";
	else
		document.getElementById("btnExcel").style.display = "";
}


/**
 * VD VL의 필수 항목이 다르기 때문에 각각 설정해준다. class가 input1일 경우 필수로 인식된다.
 * 필수항목 체크는 공통메소드에 존재.
 * @param val
 * @param cName
 * @return
 */
function setStyle(val, cName) {
	if (val == "VL") {
		document.getElementsByName("p_pol")[0].className = "input1";
		document.getElementsByName("p_pol")[0].readOnly = true;
		document.getElementsByName("p_pod")[0].readOnly = false;
		document.getElementsByName("p_pod")[0].className = "input";
	} else if (val == "VD") {
		document.getElementsByName("p_pod")[0].className = "input1";
		document.getElementsByName("p_pod")[0].readOnly = true
		document.getElementsByName("p_pol")[0].readOnly = false;
		document.getElementsByName("p_pol")[0].className = "input";
	} else {
		document.getElementsByName("p_pod")[0].className = "input";
		document.getElementsByName("p_pol")[0].className = "input";
	}
}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		with (sheetObj) {
			// 높이 설정
			style.height = 422;
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
			InitRowInfo(1, 1, 3, 100);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(27, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			var HeadTitle = "|Seq.||Container No.|Container No.|T/S|STS|Booking No.|RCV|Event Date|Seal No.|Chassis No.|M.G Set|S/P|Mode|Return YD|SP|Remark(s)|Error Message|OrgYd|StsCd|crnt_vsl_cd|trnk_voy_cd|trnk_dir_cd|pol|pod|cnmv_yr";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0,	  daLeft,   false, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq,	  40,	 daRight,  false, "SEQ");
			InitDataProperty(0, cnt++, dtDummyCheck,   30,	 daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtData,		 84,	 daLeft,   false, "cntr_no",		  true,	 "",	dfNone,		0, true,	 true,	 10);
			InitDataProperty(0, cnt++, dtData,		 20,	 daCenter, false, "check_digit",	  false,	"",	dfNone,		0, false,	false);
			InitDataProperty(0, cnt++, dtData,		 28,	 daCenter, false, "cntr_tpsz_cd",	 false,	"",	dfNone,		0, false,	false,	10,	false,	true,	"type/size");
			InitDataProperty(0, cnt++, dtData,		 28,	 daCenter, false, "prev_sts_cd",	  false,	"",	dfNone,		0, false,	false);
			InitDataProperty(0, cnt++, dtData,		 97,	 daLeft,   false, "bkg_no");
			InitDataProperty(0, cnt++, dtData,		 37,	 daCenter, false, "rcv_term_cd",	  false,	"",	dfNone,		0, false,	false,	10,	false,	true,	"Receiving term");
			InitDataProperty(0, cnt++, dtData,		 100,	daCenter, false, "cnmv_evnt_dt",	 true,	 "",	dfUserFormat2);
			InitDataProperty(0, cnt++, dtData,		 84,	 daCenter, false, "cntr_seal_no",	 false,	"",	dfNone);
			InitDataProperty(0, cnt++, dtData,		 93,	 daCenter, false, "chss_no",		  false,	"",	dfNone);
			InitDataProperty(0, cnt++, dtData,		 85,	 daCenter, false, "mgst_no",		  false,	"",	dfNone);
			InitDataProperty(0, cnt++, dtPopup,		56,	 daCenter, false, "vndr_seq");
			InitDataProperty(0, cnt++, dtData,		 37,	 daCenter, false, "mvmt_trsp_mod_cd");
			InitDataProperty(0, cnt++, dtData,		 70,	 daCenter, false, "dest_yd_cd");
			InitDataProperty(0, cnt++, dtData,		 37,	 daCenter, false, "spcl_cgo_flg",	 false,	"",	dfNone,		0, true,	 true,	 10,	false,	true,	"Special");
			InitDataProperty(0, cnt++, dtData,		 130,	daLeft,   false, "cnmv_rmk",		 false,	"",	dfNone,		0, true,	 true,	 30);
			InitDataProperty(0, cnt++, dtData,		 230,	daLeft,   false, "err_msg",		  false,	"",	dfNone,		0, true,	 true,	 30);

			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "org_yd_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "mvmt_sts_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "crnt_vsl_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "crnt_skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "crnt_skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "pol_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "pod_cd");
			InitDataProperty(0, cnt++, dtHidden,	   130,	daCenter, false, "cnmv_yr");

			InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:");

			// 영문,숫자만 입력하기
			InitDataValid(0, "cntr_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "check_digit", vtEngUpOther, "1234567890");
			InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "prev_sts_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "bkg_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "rcv_term_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "cntr_seal_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "chss_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "mgst_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "mvmt_trsp_mod_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "dest_yd_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "spcl_cgo_flg", vtEngUpOther, "1234567890");

			CountPosition = 0;
			FrozenCols = 5;
			// FocusEditMode = "-1";
			MultiSelection = true;
			SelectHighLight = false;
		}
	}


/**
 * SAVE. SEARCH등 일반 버튼 이벤트중 서버를 참조하는 메소드이다.
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	var status = formObj.p_status.value;
	switch (sAction) {
	// VL VD에서만 SEARCH가 동작한다. ( 그 외의 경우 버튼 비활성화 되어있음)
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.RemoveAll();
			if (etaEtdPass == false) return;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("EES_CTM_0406GS.do", FormQueryString(formObj));
		}
		break;

	case IBSAVE: //저장
		// VL. VD의 저장 시 PRE CHECK이 이루어지지않은 경우 입력 할 수 없도록 막는다.
		 if (!preChk && (status == "VL" || status == "VD")) {
			 ComShowCodeMessage("CTM20074");
			 return;
		 }
		// 별도로 정의 되지는 않았으나 sheet내장함수인 OnValidation으로 true/false를 먼저 check
		if (!sheetObj.GetSaveString(true)) {
			return;
		}
		// 저장 시 현재 시간과 EVENT DATE를 비교하여 입력 가능한지 다시 체크한다.
		// VL VD는 7일 그 외 3시간으로 제한. VL VD에서 3시간 초과의 경우 예약등록을 실행한다
		strTime = new Date();

		y = strTime.getYear();
		m = strTime.getMonth() + 1;
		d = strTime.getDate();
		h = strTime.getHours();
		n = strTime.getMinutes();
		if (m < 10)
			m = "0" + m;
		if (d < 10)
			d = "0" + d;
		if (h < 10)
			h = "0" + h;
		if (n < 10)
			n = "0" + n;
		strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
		p_date = formObj.p_date0.value;

		rValue = Number(dateTimeDiff(strDt, p_date));
		var succCnt = 1;

		if (((status == "VL" || status == "VD") && rValue < 3)
				|| (status != "VL" && status != "VD")) {
			if (validateForm(sheetObj, formObj, sAction)) {
				var idx = 1;
				var startId = 1;
				if (sheetObj.LastRow < 100) {
					sendRows = sheetObj.LastRow;
				} else {
					sendRows = Math.round(sheetObj.LastRow / maxThreadCount);
				}

				saveXml = new Array();
				var endId = startId + sendRows;
				var icnt = 0;
				sheetObj.SelectCell(0, 0)
				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				// 저장은 시간이 많이 걸리는 작업이다. 시간을 최대한 단축하기 위해서 그리드의 내용을 분할한 후
				// 서버에서 병렬 처리하도록 한다. 메소드는 공통에서 구현하고 있다. AJAX를 사용하여 진행.
				while (startId <= sheetObj.LastRow) {
					if (sheetObj.LastRow < endId)
						endId = sheetObj.LastRow;
					queryString = getFastString(sheetObj, startId, endId, false);
					xmlHttpPost("EES_CTM_0406GS.do", queryString + "&AJAX=Y&" + FormQueryString(formObj), "rtnValueParses", startId);
					// 리턴받은 갯수를 체크하기 위해 보낼 때마다 sendCount를 증가시킨다.
					// 리턴메소드는 위 호출 함수중 rtnValueParses.
					sendCount++;
					startId = Number(startId) + Number(sendRows) + 1;
					endId = Number(endId) + Number(sendRows) + 1;
				}
				// 전체 전송이 이루어지면 그리드를 모두 지워버리고 초기화 해둔다.
				// 리턴된 내역을 다시 그리드에 등록한다.
				sheetObj.RemoveAll();
			}

		} else { //MODIFY01
			// 별도로 정의 되지는 않았으나 sheet내장함수인 OnValidation으로 true/false를 먼저 check
			if (!sheetObj.GetSaveString(true)) {
				return;
			}
			// 예약저장을 실행한다. 예약은 분할 없이 일괄처리한다.
			ComShowCodeMessage("CTM10002");
			formObj.f_cmd.value = MODIFY01;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var rtnXml = sheetObj.GetSaveXml("EES_CTM_0406GS.do", sheetObj.GetSaveString(true) + "&" + FormQueryString(formObj));
			var resKey = ComGetEtcData(rtnXml, "TRANS_RESULT_KEY");
			ComOpenWait(false);
			if (resKey == 'F') {
				sheetObj.LoadSearchXml(rtnXml);
			} else {
				sheetObj.RemoveAll();
			}
		}
		break;
	}
}


/**
 * MOVEMENT 등록 후 반환되는결과처리
 * @param rtnXml
 * @param startId
 * @return
 */
function rtnValueParses(rtnXml, startId) {
	var sheetObj = sheetObjects[0];
	// 리턴받은 수만큼 1씩 차감하여 sendCount가 0이되면 보낸 갯수와 리턴 갯수가 일치하는 것으로 처리.
	sendCount--;
	// sendCount수만큼 saveXml배열변수를 초기화하여 rtnXml를 담아둔다.
	saveXml[sendCount] = rtnXml;
	// sendCount가 0이되면 에러 카운트를 세고 결과를 출력해준다.
	if (sendCount < 1) {
		// 에러가 난 경우 에러 VO를 리턴한다. 그리드에 LOAD하면 에러난 라인만 다시 등록되게 된다.
		for (var i=0; i<=saveXml.length-1; i++) {
			sheetObj.LoadSearchXml(saveXml[i], true);
		}
		if (sheetObj.LastRow > 0) {
			for (var i=1; i<=sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "cntr_no").length == 11) {
					sheetObj.CellValue(i, "check_digit") = sheetObj.CellValue(i, "cntr_no").substring(10, 11);
					sheetObj.CellValue(i, "cntr_no") = sheetObj.CellValue(i, "cntr_no").substring(0, 10);
				}
			}
			ComOpenWait(false);
			ComShowCodeMessage("CTM20113");
		} else {
			ComOpenWait(false);
			ComBtnDisable("btn_save");
		}
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (document.getElementById("p_yard2").Code == '') {
			ComShowCodeMessage("CTM10049", "yard cd");
			// alert ("야드 항목을 입력하시기 바랍니다.")
			document.form.p_yard2.focus();
			return false;
		}
	}
	return true;
}


/**
 * POPUP 호출.Vender Popup
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet_OnPopupClick(sheetObj, Row, Col) {
	sUrl = "UI_CTM_0435.do";
	iWidth = "620";
	iHeight = "420";
	sFunc = "getServiceProvider";
	sDisplay = "1,0";
	bModal = true;
	sTargetObjList = "vndr_seq";
	iRow = Row;
	iCol = Col;
	iSheetIdx = "";
	sWinName = "Logis Service Provider";
	sheetRow = Row;
	sheetCol = Col;
	ComOpenPopup(sUrl, iWidth, iHeight, 'getVndr', '1,0,1,1,1,1,1');
}


/**
 * 벤더 팝업이 정상 종료 후 결과를 그리드에 다시 매핑해준다
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function getVndr(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	var vndrSeq = "";
	var vndrNm = "";
	var i = 0;

	for (i = 0; i < aryPopupData.length; i++) {
		vndrSeq = vndrSeq + aryPopupData[i][2];
		if (aryPopupData.length == 1) {
			vndrNm = vndrNm + aryPopupData[i][4];
		}
		if (i < aryPopupData.length - 1) {
			vndrSeq = vndrSeq + ",";
		}
	}
	sheetObjects[0].CellValue2(sheetRow, "vndr_seq") = vndrSeq;
}


	/**
	 * Sheet의 OnSearchEnd 이벤트 처리
	 */
	function sheet_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			ComBtnEnable("btn_downExcel");
			// SEARCH 이후에는 조회항목의 모든 입력이 비활성화되어 수정 할 수 없도록 제한한다.
			// SEARCH는 VL/VD에서만 이루어지고 저장은 PRE CHECK 이후에만 가능하므로 전역변수 preCheck을 초기화 한다.
			setElementDisable(true);
			preChk = false;
			if (document.form.p_status.value == "VL" || document.form.p_status.value == "VD") {
				with (sheetObj) {
					// 조회결과가 있으면
					if (RowCount > 0) {
						Redraw = false;
						for (var i=1; i<RowCount+1; i++) {
							CellEditable(i, "bkg_no") = false;
							CellEditable(i, "cnmv_evnt_dt") = false;
						}
						Redraw = true;
					}
				}
			}
		}
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}


	/**
	 * Sheet의 OnSearchEnd 이벤트 처리
	 */
	function sheet_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			ComBtnEnable("btn_downExcel");
			// SEARCH 이후에는 조회항목의 모든 입력이 비활성화되어 수정 할 수 없도록 제한한다.
			// SEARCH는 VL/VD에서만 이루어지고 저장은 PRE CHECK 이후에만 가능하므로 전역변수 preCheck을 초기화 한다.
			setElementDisable(true);
			preChk = false;
			if (document.form.p_status.value == "VL" || document.form.p_status.value == "VD") {
				with (sheetObj) {
					// 조회결과가 있으면
					if (RowCount > 0) {
						Redraw = false;
						for (var i=1; i<RowCount+1; i++) {
							CellEditable(i, "bkg_no") = false;
							CellEditable(i, "cnmv_evnt_dt") = false;
						}
						Redraw = true;
					}
				}
			}
		}
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}


	/**
	 * 그리드의 데이타가 변경되기 전 포커스의 위치를 받고 그 값을 미리 저장해둠.
	 * 변경된 자료가 있는지 확인하기위한 전 처리
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet_OnBeforeEdit(sheetObj, Row, Col) {
		//selectedRow는 전역 변수로 현재 포커스가 위치하고있는 Line번호를 저장한다.
		selectedRow = Row;
		var SaveName = sheetObj.ColSaveName(Col);
		if (Row < 1) return;
		if (SaveName == "cntr_no") {
			// sheetContainer는 컨테이너 번호를 저장하는 전역 변수임. onFocuis Out시 이 값을 비교하게 됨
			sheetContainer = sheetObj.CellValue(Row, Col);

		} else if (SaveName == "bkg_no") {
			// crntBkgValue는 Booking번호를 저장하는 전역 변수임
			if (crntBkgValue != '') {
				sheetBkgValue = crntBkgValue;
				crntBkgValue = sheetObj.CellValue(Row, Col);
			} else {
				crntBkgValue = sheetObj.CellValue(Row, Col);
				sheetBkgValue = crntBkgValue;
			}
			crntBkgValue = sheetObj.CellValue(Row, Col);

		} else if (SaveName == "cnmv_evnt_dt") {
			// sheetEventDt는 컨테이너 번호를 저장하는 전역 변수임. onFocuis Out시 이 값을 비교하게 됨
			sheetEventDt = sheetObj.CellValue(Row, Col);

		} else {
			// 현재 포커스가 위치하고 있는 칼럼이 컨테이너, 부킹이 아닐 경우 값을 초기화 해준다
			sheetContainer = "";
			sheetBkgValue = "";
			sheetContainerFlg = true;
			sheetBkgValueFlg = true;
		}
	}


/**
 * 그리드의 값이 변경될 경우 Validation을 위해 값을 비교한다.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	// 아직 Focus Out이 일어나지 않았음으로 EditValue를 받아서 값을 비교함.
	newValue = sheetObj.EditValue;
	var SaveName = sheetObj.ColSaveName(Col);
	// Validation후 에러가 났을 경우 errorRow에 Line 번호를 저장한다.
	// Error로 인해 값이 변경 될 경우 다시 체크하지 않도록 하기 위해 errorBack에 에러표시해둠
	errorRow = -1;
	errorBack = -1;
	if (Row < 1) return;
	if (SaveName == "cntr_no") {
		sheetContainerFlg = false
		if (Row >= sheetObj.HeaderRows) {
			if (errorRow == Row && newValue.length < 10) {	// 에러행과 이전 행이 동일 하고 현재 입력중인 값의 길이가 10자 미만일 경우 그대로 종료한다
				return;
			} else if (KeyCode == 86) {	// 에러 행과 이전 행이 동일하고 컨트롤키가 눌렸을 경우 종료한다
			//	return;
			} else if (Shift != 0) {	 // Shift키가 눌린 경우 아직 값이 입력된게 아니기 때문에 종료한다
				return;
			} else if (KeyCode < 48 || (KeyCode > 57 && KeyCode < 65) || (KeyCode > 90 && KeyCode < 96) || KeyCode > 105) { // 키 코드가 유효하지 않을 경우 그리드에 입력되지 못하기 때문에 종료한다
				return;
			}
			if (sheetContainer == newValue && sheetContainerFlg == true) {	// 이전에 저장했던 값과 현재 값이 동일하고 에러체크를 통과했을 경우 종료한다
				return;
			}
			sheetCheckValue(sheetObj, Row, Col, false);
			return;
		}
	} else if (SaveName == "bkg_no") {
		sheetBkgValueFlg = false;
	}
}


	/**
	 * 그리드의 셀을 클릭했을 경우 컨테이너 , 부킹을 체크한다.
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		// 만일 errorRow가 -1이 아니면 이전라인에서 에러가 발생 한것으로 간주하고 현재 로직을 취소한다.
		// 선택된 Row와 이전 Row, Col을 비교해서 같으면 아직 포커스를 잃지 않았으므로 종료한다
		if (NewRow == OldRow && OldCol == NewCol) {
			return;

		// 이전에 error를 리턴한 적이 있고 현재 Row가 에러를 낸 Row와 다르거나 현재 Row가 이전 Row와 다르면 현재 Row를 체크하지 않고 종료한다.
		// errorRow가 0을 초과하는 경우는 이전 Row로 포커스를 다시 되돌리기 때문에 무한 validation을 막기위해 작성한다
		// 반환 할때는 에러에 관한 변수들은 모두 초기화 해준다. (예전 Row로 되돌아 갔을 때 초기화 되어 있지 않으면 무한 반복된다)
		} else if (errorRow > 0 && (NewRow != errorRow || OldCol != NewCol)) {
			errorRow = -1;
			errorBack = -1;
			return;

		// 에러로 Back된 경우 예전 Row와 현재 Row를 비교하고 같지 않을 경우 종료하지않고 에러 변수들만 초기화한다.
		// 실제로 유효성 체크는 하지 않는다. 이유는 falg가 초기화 되더라도 값이 같기 때문에 변하지 않은 것으로 간주되기 때문이다.
		} else if (errorBack == 1 && (OldRow != NewRow || OldCol != NewCol)) {
			errorBack = -1;
			errorRow = -1;

		// return;
		// 위의 조건에서 걸러지지 않은 경우는 유효성 체크를 한다.
		} else {
			var Row = OldRow;
			var Col = OldCol;
			var SaveName = sheetObj.ColSaveName(Col);

			// 현재 Col이 부킹이고 rcv_term_cd가 비어 있을 경우 현재 부킹번호에 대한 validatoin이 이루어지지않은 것으로 간주하고 체크한다.
			if (SaveName == 'bkg_no' && sheetObj.CellValue(OldRow, "rcv_term_cd") == '') {
				errorRow = OldRow;
				errorBack = 1;
				sheetCheckValue(sheetObj, OldRow, OldCol, true)
				return;
			}

			newValue = sheetObj.CellValue(Row, Col);

			if (Row < 1) return;

			// 이전 선택 항목이 컨테이너번호이고 내용이 채워져있고 타입사이즈가 비어있는 경우 무조건 실행하도록 한다.
			if (SaveName == "cntr_no" && sheetObj.CellValue(Row, "cntr_no") != '' && sheetObj.CellValue(Row, "cntr_tpsz_cd") == '') {
				sheetCheckValue(sheetObj, Row, Col, true);

			// 현재 선택된 항목이 컨테이너이고 컨테이너 유효체크 완료가 되어있지 않으면 체크하도록 한다.
			// 단 컨테이너 값이 이전 저장값과 같으면 체크하지 않는다.
			} else if (SaveName == "cntr_no") {
				if ((sheetContainerFlg == false && Row >= sheetObj.HeaderRows) || (sheetContainerFlg == false && sheetContainer != newValue)) {
					sheetCheckValue(sheetObj, Row, Col, true);
				}

			// 현재 선택된 항목이 부킹이고 유효성 체크가 완료되지 않았으면 체크하도록 한다.
			// 단 이전 저장값(전역변수 crntBkgValue)과 현재 Value가 동일하지 않은 경우에만 실시한다.
			} else if (SaveName == "bkg_no") {
				if (crntBkgValue != true) {
					if ((sheetBkgValueFlg == false && NewRow >= sheetObj.HeaderRows && crntBkgValue != newValue)) sheetCheckValue(sheetObj, Row, Col, true);
				} else {
					crntBkgValue = false;
				}

			// 리턴 야드가 존재하는지 확인한다. 확인만 한다.
			} else if (SaveName == "dest_yd_cd") {
				sheetCheckValue(sheetObj, Row, Col, true);

			// 모드는 Y/N만 입력하도록 제한한다.
			} else if (SaveName == "mvmt_trsp_mod_cd") {
				sheetCheckValue(sheetObj, Row, Col, true);

			// CellEditable이 가능하고 RowStatus가 Insert일때 event date를 체크한다.
			} else if (SaveName == "cnmv_evnt_dt") {
				if (sheetObj.CellEditable(Row, Col) && sheetObj.RowStatus(Row) != "I") return;
				sheetCheckValue(sheetObj, Row, Col, true);

			// 샤시 번호를 체크한다.
			} else if (SaveName == "chss_no") {
				if (sheetObj.CellValue(Row, Col) == '') return;
				sheetCheckValue(sheetObj, Row, Col, true);

			// MG SET을 체크한다.
			} else if (SaveName == "mgst_no") {
				if (sheetObj.CellValue(Row, Col) == '') return;
				sheetCheckValue(sheetObj, Row, Col, true);
			}
		}
	}


/**
 * 실제 값의 유효성을 체크한다. 각 Col마다 유효성의 체크 범위가 다르기 때문에 내부 주석 참조.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param isOut
 * @return
 */
function sheetCheckValue(sheetObj, Row, Col, isOut) {
	var SaveName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	frmObj = formObj;
	var status = formObj.p_status.value;
	// 체크를 시작하기 전 그리드의 background color를 초기화 하고 에러 변수들을 초기화 한다.
	GridForErr(sheetObj, Row, "S");
	// Edit Value를 가져오는 조건은 isOut에 의해서 결정된다.
	// isOut이 true인 경우 focus이동에의한호출. false인 경우 길이에 의한 (key event)호출이다
	switch (SaveName) {
	case "cntr_no":
		if (isOut)
			cntr_no = sheetObj.CellValue(Row, "cntr_no");
		else
			cntr_no = sheetObj.EditValue;
		// 컨테이너 길이가 1자 미만일 경우 컨테이너가 입력된 내역이 없는걸로 간주하고 체크를 중단한다
		if (cntr_no.length < 1) {
			sheetContainerFlg = true;
			return;
		}
		// 컨테이너 길이가 10자가 되지않고 포커스 이동이 없었던 경우는 아직 입력중인 것으로 간주하고 체크를 중단한다.
		if (cntr_no.length != 10 && isOut == false)
			return;

		p_yard1 = formObj.p_yard1.value;
		p_yard2 = formObj.p_yard2.Code;
		queryString = "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;

		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		// 공통메소드를 호출한 결과 리턴값이 없을 경우 컨테이너가 없는것으로보고 에러처리한다
		if (rtnValue == null || rtnValue == "") {
			clearGridForErr(sheetObj, Row, "E", "C");
			ComShowCodeMessage("CTM10004");
			if (sheetObj.CellEditable(Row, Col)) {
				sheetObj.SelectCell(Row, Col, true);
			} else {
				sheetObj.RemoveAll();
				frmObj.p_cntrno.disabled = false;
				frmObj.p_cntrno.value = "";
				ComSetFocus(formObj.p_cntrno);
			}
			return;
		} else {
			rtnStr = rtnValue.split("|");
			vr = rtnStr[0].substring(10, 11);
			// 컨테이너의 check digit이 일치하지 않는 경우 메시지 출력은 표준 메시지 출력 방식이 아닌 alert를 통해 처리한다.
			// 표준 메시지 처리로 전환 할 경우 CTM20111을 수정한 후 처리해야 한다.
			if (sheetObj.CellValue(Row, "cntr_tpsz_cd") == '' && sheetObj.CellValue(Row, "check_digit") != '' && vr != sheetObj.CellValue(Row, "check_digit")) {
				msg = ComGetMsg("CTM20111") + sheetObj.CellValue(Row, "check_digit") + ":" + vr;
				sheetObj.CellValue(Row, "cntr_tpsz_cd") = '';
				sheetObj.CellValue(Row, "check_digit") = '';
				alert(msg);
				if (sheetObj.CellEditable(Row, Col)) {
					sheetObj.SelectCell(Row, Col, true);
				} else {
					sheetObj.RemoveAll();
					frmObj.p_cntrno.disabled = false;
					frmObj.p_cntrno.value = "";
					ComSetFocus(formObj.p_cntrno);
				}
				return;
			}
			sheetObj.CellValue(Row, "cntr_tpsz_cd") = rtnStr[2];
			sheetObj.CellValue(Row, "prev_sts_cd") = rtnStr[1];
			sheetObj.CellValue(Row, "cntr_no") = rtnStr[0].substring(0, 10);
			// 신규 컨테이너의 경우 MT. OP가 아니면 에러 처리하고 종료한다.
			// 모든 에러처리의 경우 focus는 이전(수정중이었던 항목)으로 이동한다
			if (rtnStr[7] == 'Y' && rtnStr[4] == 'I' && (status != 'MT' && status != 'OP')) {
				ComShowCodeMessage("CTM10005");
				sheetObj.CellValue(Row, "cntr_tpsz_cd") = '';
				sheetObj.CellValue(Row, "check_digit") = '';
				if (sheetObj.CellEditable(Row, Col)) {
					sheetObj.SelectCell(Row, Col, true);
				} else {
					sheetObj.RemoveAll();
					frmObj.p_cntrno.disabled = false;
					frmObj.p_cntrno.value = "";
					ComSetFocus(formObj.p_cntrno);
				}
				return;
			}
			// 컨테이너 mvmt 누적 갯수가 0(이전에 mvmt가 생성된 적이 없고)이고 MT를 생성하는 경우가 아니면 에러처리한다
			if (rtnStr[8] == "0" && status != "MT") {
				ComShowCodeMessage("CTM20119");
				sheetObj.CellValue(Row, "cntr_tpsz_cd") = '';
				sheetObj.CellValue(Row, "check_digit") = '';
				if (sheetObj.CellEditable(Row, Col)) {
					sheetObj.SelectCell(Row, Col, true);
				} else {
					sheetObj.RemoveAll();
					frmObj.p_cntrno.disabled = false;
					frmObj.p_cntrno.value = "";
					ComSetFocus(formObj.p_cntrno);
				}
				return;
			}
			// VL VD는 이벤트 시간을 바꿀 수 없도록 막는다
			if (status == "VL" || status == "VD") {
				sheetObj.CellEditable(i, "cnmv_evnt_dt") = false;
			} else {
				sheetObj.CellEditable(i, "cnmv_evnt_dt") = true;
			}

			if (vr != null)
				sheetObj.CellValue(Row, "check_digit") = vr;
			/*******************************************************************
			 * 컨테이너 상태를 체크한다.
			 ******************************************************************/
			p_yardValue = document.getElementById("p_yard2").Code;
			switch (status) {
			/**
			 *	rtnStr[0] : 컨테이너 번호
			 *	rtnStr[1] : 컨테이너 현재 상태
			 *	rtnStr[2] : 컨테이너 타입/사이즈
			 *	rtnStr[3] : 컨테이너의 현재 야드
			 *	rtnStr[4] : 컨테이너 ACTIVE 여부
			 *	rtnStr[5] : 사용자 서버 & 컨테이너 지역 동일 여부
			 *	rtnStr[6] : 컨테이너 반출 여부
			 *	rtnStr[7] : 신규컨테이너 여부
			 *	rtnStr[8] : 누적 MVMT 갯수
			 */

			case "OP":
				/*********************************************************************************
				 * 사용자 지역과 컨테이너의 서버가 동일한 경우가 아니면 OP를 생성 할 수 없도록 제한한다
				 * 컨테이너가 Active 상태가 아니면 생성 할 수 없도록 제한한다
				 * 컨테이너가 반납 상태가 아닌 경우에만 생성할 수 있도록 한다
				 **********************************************************************************/
				if (rtnStr[5] == 'Y') {
					if ((rtnStr[1] == 'MT' || rtnStr[1] == 'CM')
							&& rtnStr[3] == p_yard1 + p_yard2) {
						if (rtnStr[4] == 'I' && rtnStr[4] != 'A') {
							ComShowCodeMessage("CTM10005");
							// alert ("InActive Container No!");
							clearGridForErr(sheetObj, Row, "E", "C");
							if (sheetObj.CellEditable(Row, Col)) {
								sheetObj.SelectCell(Row, Col, true);
							} else {
								sheetObj.RemoveAll();
								frmObj.p_cntrno.disabled = false;
								frmObj.p_cntrno.value = "";
								ComSetFocus(formObj.p_cntrno);
							}
							return;
						} else if (rtnStr[6] != 'N') {
							ComShowCodeMessage("CTM10006");
							// alert ("Immediately Exit Container");
							clearGridForErr(sheetObj, Row, "E", "C");
							if (sheetObj.CellEditable(Row, Col)) {
								sheetObj.SelectCell(Row, Col, true);
							} else {
								sheetObj.RemoveAll();
								frmObj.p_cntrno.disabled = false;
								frmObj.p_cntrno.value = "";
								ComSetFocus(formObj.p_cntrno);
							}
							return;
						}
					} else {
						//alert ("This Is Not A Empty Container In This Yard!")
						ComShowCodeMessage("CTM20075");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					}
				} else {
					//alert ("Container Is Not Located In This Country!");
					ComShowCodeMessage("CTM10007");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				}
				break;
			case "OC":
				/*********************************************************************************
				 * 사용자 지역과 컨테이너의 서버가 동일한 경우가 아니면 OP를 생성 할 수 없도록 제한한다
				 * 컨테이너가 Active 상태가 아니면 생성 할 수 없도록 제한한다
				 * 컨테이너가 반납 상태가 아닌 경우에만 생성할 수 있도록 한다
				 **********************************************************************************/
				if (rtnStr[5] == 'Y') {
					if (rtnStr[6] != 'N') {
						//alert ("Immediately Exit Container");
						ComShowCodeMessage("CTM10006");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					} else if (rtnStr[1].substring(0, 1) != 'C') {
						if (rtnStr[5] != 'Y') {
							//alert ("Container Is Not Located In This Country!");
							ComShowCodeMessage("CTM10007");
							clearGridForErr(sheetObj, Row, "E", "C");
							if (sheetObj.CellEditable(Row, Col)) {
								sheetObj.SelectCell(Row, Col, true);
							} else {
								sheetObj.RemoveAll();
								frmObj.p_cntrno.disabled = false;
								frmObj.p_cntrno.value = "";
								ComSetFocus(formObj.p_cntrno);
							}
							return;
						}
					} else {
						//alert ("This Is Not A Adequate Container!");
						ComShowCodeMessage("CTM10008");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					}
				} else {
					//alert ("Container Is Not Located In This Country!");
					ComShowCodeMessage("CTM10007");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				}
				break;
			case "VL":
				/*********************************************************************************
				 * 사용자 지역과 컨테이너의 서버가 동일한 경우가 아니면 OP를 생성 할 수 없도록 제한한다
				 * 컨테이너가 Active 상태가 아니면 생성 할 수 없도록 제한한다
				 * 컨테이너가 반납 상태가 아닌 경우에만 생성할 수 있도록 한다
				 * VL이 생성된 컨테이너는 다시 생성 할 수 없다
				 **********************************************************************************/
				if (rtnStr[6] != 'N') {
					//alert ("Immediately Exit Container");
					ComShowCodeMessage("CTM10006");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				} else if (rtnStr[1] == 'VL') {
					//alert ("Aleady 'VL' Container!");
					ComShowCodeMessage("CTM20076", "VL");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				} else {
					/****************************************
					 *   VL인경우 FULL/EMPTY구분.
					 *****************************************/
					strQuery = "f_cmd=" + SEARCH04 + "&cntr_no=" + sheetObj.CellValue(Row, "cntr_no") + sheetObj.CellValue(Row, "check_digit");
					strQuery = strQuery + "&crnt_vsl_cd=" + sheetObj.CellValue(Row, "crnt_vsl_cd");
					strQuery = strQuery + "&crnt_skd_voy_no=" + sheetObj.CellValue(Row, "crnt_skd_voy_no");
					strQuery = strQuery + "&crnt_skd_dir_cd=" + sheetObj.CellValue(Row, "crnt_skd_dir_cd");
					strQuery = strQuery + "&pol_cd=" + sheetObj.CellValue(Row, "pol_cd");
					strQuery = strQuery + "&mvmt_sts_cd=" + sheetObj.CellValue(Row, "mvmt_sts_cd");
					strQuery = strQuery + "&p_type1=" + formObj.p_type1.value;
					// strQuery = strQuery + "&p_type2=" +
					// formObj.p_type2.value;

					rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do", strQuery);

					rtnStr = ComGetEtcData(rtnXml, "rtnStr");
					if (rtnStr == -1) {
						//alert ("Invalid loading Container No!");
						ComShowCodeMessage("CTM20099");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					}
				}
				break;
			case "VD":
				/*********************************************************************************
				 * 사용자 지역과 컨테이너의 서버가 동일한 경우가 아니면 OP를 생성 할 수 없도록 제한한다
				 * 컨테이너가 Active 상태가 아니면 생성 할 수 없도록 제한한다
				 * 컨테이너가 반출 상태가 아닌 경우에만 생성할 수 있도록 한다
				 * VD상태인 컨테이너는 다시 생성 할 수 없고 VL이 아닌 컨테이너도생성 할 수 없다
				 **********************************************************************************/
				if (rtnStr[1] == 'VD') {
					//alert ("Aleady 'VD' Container!");
					ComShowCodeMessage("CTM20076", "VD");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				} else {
					/**************************************
					 *  POL LOCATION이 있는 경우 와 없는 경우로 나눠서 체크.
					 *  Sub_VD 참조.
					 */
					strQuery = "f_cmd=" + SEARCH04 + "&cntr_no="
							+ sheetObj.CellValue(Row, "cntr_no")
							+ sheetObj.CellValue(Row, "check_digit");
					strQuery = strQuery + "&crnt_vsl_cd="
							+ sheetObj.CellValue(Row, "crnt_vsl_cd");
					strQuery = strQuery + "&crnt_skd_voy_no="
							+ sheetObj.CellValue(Row, "crnt_skd_voy_no");
					strQuery = strQuery + "&crnt_skd_dir_cd="
							+ sheetObj.CellValue(Row, "crnt_skd_dir_cd");
					strQuery = strQuery + "&pod_cd="
							+ sheetObj.CellValue(Row, "pod_cd");
					strQuery = strQuery + "&pol_cd="
							+ sheetObj.CellValue(Row, "pol_cd");
					strQuery = strQuery + "&mvmt_sts_cd="
							+ sheetObj.CellValue(Row, "mvmt_sts_cd");
					strQuery = strQuery + "&p_type1=" + formObj.p_type1.value;
					// strQuery = strQuery + "&p_type2=" +
					// formObj.p_type2.value;

					rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do",
							strQuery);

					rtnStr = ComGetEtcData(rtnXml, "rtnStr");
					if (rtnStr == "-1") {
						//alert ("Invalid Discharge Container No");
						ComShowCodeMessage("CTM20077");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					}
				}
				break;
			case "TS":
				/*********************************************************************************
				 * 사용자 지역과 컨테이너의 서버가 동일한 경우가 아니면 OP를 생성 할 수 없도록 제한한다
				 * 이전 상태가 EN TN일 경우만 생성 할 수 있도록 제한한다
				 * 컨테이너가 반출 상태가 아닌 경우에만 생성할 수 있도록 한다
				 **********************************************************************************/
				if (rtnStr[5] == 'Y') {
					if (rtnStr[1] != 'TS') {
						if ((rtnStr[1] == 'EN') || (rtnStr[1] == 'TN')) {
							/******************************
							 *  EN / TN일 경우 처리가능 하도록 한다
							 */
						} else {
							//alert ("Not TS Container Error!");
							ComShowCodeMessage("CTM20078");
							clearGridForErr(sheetObj, Row, "E", "C");
							if (sheetObj.CellEditable(Row, Col)) {
								sheetObj.SelectCell(Row, Col, true);
							} else {
								sheetObj.RemoveAll();
								frmObj.p_cntrno.disabled = false;
								frmObj.p_cntrno.value = "";
								ComSetFocus(formObj.p_cntrno);
							}
							return;
						}

					} else {
						//alert ("UnAceeptable Container!");
						ComShowCodeMessage("CTM20078");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
					}
						return;
					}
				} else {
					//alert ("Container Is Not Located In This Country!");
					ComShowCodeMessage("CTM10007");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				}
				break;
			case "MT":
				/*********************************************************************************
				 * 전 상태가 CM CP이거나 DOM MVMT가 아닌 경우 생성 할 수 있다
				 **********************************************************************************/
				if ((rtnStr[1] == 'CM') || (rtnStr[1] == 'CP')
						|| (rtnStr[1].substring(0, 1) != 'C')) {
					if (rtnStr[7] == 'Y') {
					} else if (rtnStr[5] != 'Y') {
						//alert ("Container Is Not Located In This Country");
						ComShowCodeMessage("CTM10007");
						clearGridForErr(sheetObj, Row, "E", "C");
						if (sheetObj.CellEditable(Row, Col)) {
							sheetObj.SelectCell(Row, Col, true);
						} else {
							sheetObj.RemoveAll();
							frmObj.p_cntrno.disabled = false;
							frmObj.p_cntrno.value = "";
							ComSetFocus(formObj.p_cntrno);
						}
						return;
					}
				} else {
					// 2016.02.12 Sang-Hyun Kim [CHM-201639830] CTM: Domestic MVMT CM 자동생성 logic 변경
					// 이전 상태가 'CI', 'CD'일 경우, Error message 변경 처리
					if (rtnStr[1] == "CI" || rtnStr[1] == "CD") {
						// Message : "Movement Creation Error [Auto Creation][CD,CM]"
						ComShowCodeMessage("CTM30016", "CD, CM");
					} else {
						// Message : "This Is Not A Adequate Container"
						ComShowCodeMessage("CTM10008");
					}

					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				}
				break;
			case "CM":
				if (rtnStr[1] == 'MT' || rtnStr[1].substring(0, 1) == 'C') {

				} else {
					//alert ("This Is Not A Adequate Container");
					ComShowCodeMessage("CTM10008");
					clearGridForErr(sheetObj, Row, "E", "C");
					if (sheetObj.CellEditable(Row, Col)) {
						sheetObj.SelectCell(Row, Col, true);
					} else {
						sheetObj.RemoveAll();
						frmObj.p_cntrno.disabled = false;
						frmObj.p_cntrno.value = "";
						ComSetFocus(formObj.p_cntrno);
					}
					return;
				}
			}
		}
		/**********************************************************
		 *  동일 컨테이너에 여러건의 부킹이 잡혀 있는지 확인한다
		 *  컨테이너가 여러개의 부킹을 가지고 있을 경우 모든 부킹을
		 *  아래에 리스팅한다
		 **********************************************************/
		if (status == 'OP' || status == 'OC') {
			// 다음라인이 동일한 컨테이너인지 확인한다. 동일 컨테이너라면 생략.

			if (sheetObj.CellValue(Number(Row) + 1, "cntr_no") == cntr_no) {
				sheetContainerFlg = true;
				return;
			}
			queryString = "f_cmd=" + SEARCH01 + "&cntr_no=" + rtnStr[0]
					+ "&check_dight=";
			sheetObj0 = sheetObjects[1];
			sheetObj0.RemoveAll();
			xml = sheetObj0.DoSearch("EES_CTM_0406GS.do", queryString);
			if (sheetObj0.LastRow >= 1) {
				if (sheetObj0.CellValue(1, "bkg_no") != '') {
					sheetObj.CellValue2(Row, "bkg_no") = sheetObj0.CellValue(1,
							"bkg_no");
					sheetObj.CellValue2(Row, "rcv_term_cd") = sheetObj0
							.CellValue(1, "rcv_term_cd");
				}
				sheetObj.CellEditable(Row, 7) = true;
				vvdCd = frmObj.p_vvd.value;
				for (i = 2; i <= sheetObj0.LastRow; i++) {
					sheetObj.DataInsert();
					iRow = Number(Row) + (i - 1);
					for (j = 3; j <= 8; j++) {
						sheetObj.CellValue2(iRow, j) = sheetObj0
								.CellValue(i, j);
						sheetObj.CellEditable(iRow, 7) = true;
					}
					sheetObj.CellValue2(iRow, 9) = formObj.p_date0.value;
					sheetObj.CellValue2(iRow, "org_yd_cd") = frmObj.p_yard1.value + document.getElementById("p_yard2").Code
					sheetObj.CellValue2(iRow, "cnmv_sts_cd") = frmObj.p_status.value;
					sheetObj.CellValue(iRow, "crnt_vsl_cd") = vvdCd.substring( 0, 4);
					sheetObj.CellValue(iRow, "crnt_skd_voy_no") = vvdCd.substring(4, 8);
					sheetObj.CellValue(iRow, "crnt_skd_dir_cd") = vvdCd.substring(8, 9);
					sheetObj.CellValue2(iRow, "pol_cd") = frmObj.p_pol.value;
					sheetObj.CellValue2(iRow, "pod_cd") = frmObj.p_pod.value;
					sheetObj.CellValue2(iRow, "mvmt_sts_cd") = frmObj.p_status.value;
					sheetObj.CellValue2(iRow, "cnmv_yr") = frmObj.p_date0.value.substring(0, 4);
				}
			}

			rcv_term_cd = sheetObj.CellValue(Row, "rcv_term_cd");
			bkg_no = sheetObj.CellValue(Row, "bkg_no");
			if (bkg_no != '' && rcv_term_cd == '') {
				sheetCheckValue(sheetObj, Row, 7, true)
			}
		}
		// 정상 체크가 종료되면 컨테이너 체크 플래그를 TRUE상태로 돌린다.
		// 플래그가 FALSE상태인 경우 체크를 실패한 것으로 보기 때문에 포커스 이동시 체크를 다시하게 된다.
		// 초기화 해주지 않는 경우 무한 반복 상태로 넘어갈 소지가 있다
		sheetContainerFlg = true;

		break;
	case "bkg_no":
		/***********************************************************************
		 * 메소드 호출이 포커스 이동에 의한 것인지 키 이벤트에 의한 것인지에 따라
		 * 처리 방식이 다르다. EDITVALUE는 키 이벤트중에 값을얻어오기 위한 방법이다
		 ***********************************************************************/
		if (isOut) {
			bkg_no = sheetObj.CellValue(Row, "bkg_no");
		} else {
			bkg_no = sheetObj.EditValue;
		}

		if (bkg_no.length < 1) {
			return;
		}
		if (bkg_no.length != 13 && isOut == false)
			return;

		cntr_no = sheetObj.CellValue(Row, "cntr_no");

		formObj.f_cmd.value = SEARCH17;
		sheetObj.CellValue(Row, "bkg_no_split") = "";
		sheetObj.CellValue(Row, "rcv_term_cd") = "";

		if (bkg_no.length < 1) {
			return;
		}
		/*******************************************************************
		 * 부킹은 OP OC에서만 입력 받는 내용이다. 내용을 받은 후
		 * STATUS에 관계없이 정상 자료면 하단 버튼을 활성화 시켜준다.
		 * 또한 컨테이너 번호가 등록 되어 있고 타입이 정해지지 않은 경우
		 * 컨테이너번호에대한 체크가 이루어 지지 않은 경우이므로 체크로직을한번
		 * 더 실행해서 컨테이너 번호를 체크하도록 한다 (FILE IMPORT 대비 용)
		 ********************************************************************/
		queryString = "f_cmd=" + SEARCH17 + "&p_bkg_no=" + bkg_no + "&p_bkg_no_split=";

		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		if (rtnValue == "") {
			sheetObj.CellValue(Row, "bkg_no_split") = "";
			sheetObj.CellValue(Row, "rcv_term_cd") = "";
			clearGridForErr(sheetObj, Row, "E", "B");
			ComShowCodeMessage("CTM20999");
			sheetBkgValueFlg = false;
			crntBkgValue = true;
			// crntBkgValue = sheetBkgValue ;
			sheetObj.SelectCell(Row, Col, true);
		} else {
			clearGridForErr(sheetObj, Row, "", "B");
			rtnStr = rtnValue.split("||");
			if (rtnStr.length < 2) {
				sheetObj.CellValue(Row, "bkg_no_split") = "";
				sheetObj.CellValue(Row, "rcv_term_cd") = "";
				sheetBkgValueFlg = true;
				crntBkgValue = true;
				// crntBkgValue = sheetBkgValue ;
				sheetObj.SelectCell(Row, Col, true);
			} else {
				sheetObj.CellValue(Row, "bkg_no_split") = rtnStr[0];
				sheetObj.CellValue(Row, "rcv_term_cd") = rtnStr[1];
				sheetBkgValueFlg = true;
				crntBkgValue = false;
			}
			if (cntr_no.length < 1)
				ComBtnEnable("btn_select");
			else
				ComBtnDisable("btn_select");
			// 컨테이너번호는 등록되어 있으나 컨테이너의 TPSZ가 없을 경우 얻어오도록 한다.
			tpsz_cd = sheetObj.CellValue(Row, "cntr_tpsz_cd");
			if (cntr_no != '' && tpsz_cd == '') {
				sheetCheckValue(sheetObj, Row, 3, true)
				sheetObj.CellValue2(Row, "err_msg") = "";
			}
		}
		break;
	case "vndr_seq":
		break;
	case "dest_yd_cd":
		ydCd = sheetObj.CellValue(Row, "dest_yd_cd");
		if (ydCd.length < 1)
			return;
		queryString = "f_cmd=" + SEARCH14 + "&p_yard1=" + ydCd;
		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		if (rtnValue == null) {
			ComShowCodeMessage("CTM10001");
			sheetObj.SelectCell(Row, Col, true);
		}

		break;
	case "cnmv_evnt_dt":
		// event date를 체크한다. VL/VD는 수정할수 없으므로 나머지 Status의 경우만 체크한다.
		var p_date = sheetObj.CellText(Row, "cnmv_evnt_dt");
		if (p_date == '') {
			ComShowCodeMessage("CTM10049", "event date");
			sheetObj.SelectCell(Row, Col, true, document.form.p_date0.value);
			return;
		}
		var status = document.form.p_status.value
		var strTime = new Date();
		var y = strTime.getYear();
		var m = strTime.getMonth() + 1;
		var d = strTime.getDate();
		var h = strTime.getHours();
		var n = strTime.getMinutes();
		if (m < 10) m = "0" + m;
		if (d < 10) d = "0" + d;
		if (h < 10) h = "0" + h;
		if (n < 10) n = "0" + n;
		var strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
		var rValue = Number(dateTimeDiff(strDt, p_date));
		if (rValue > 3) {
			ComShowCodeMessage("CTM10053");
			// alert ("Event date can't exceed+0 Days from today.");
			sheetObj.SelectCell(Row, Col, true, document.form.p_date0.value);
			return;
		}
		break;
	case "mvmt_trsp_mod_cd":
		val = sheetObj.CellValue(Row, "mvmt_trsp_mod_cd");
		if (val == '')
			return;
		if (val != 'T' && val != 'R' && val != 'B') {
			ComShowCodeMessage("CTM10016");
			sheetObj.SelectCell(Row, Col, true);
		}
		break;
	case "mgst_no":
		queryString = ""; // chss_no
		mgset = sheetObj.CellValue(Row, "mgst_no");
		queryString = "f_cmd=" + SEARCH07 + "&p_mgset=" + mgset;
		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		rtnName = ComGetEtcData(xml, "rtnName");
		if (rtnValue != 'OK') {
			ComShowCodeMessage("CTM20115");
			sheetObj.CellValue2(Row, Col) = "";
			sheetObj.SelectCell(Row, Col);
		}
		break;
	case "chss_no":
		queryString = ""; // chss_no
		p_chassis_no = sheetObj.CellValue(Row, "chss_no");
		queryString = "f_cmd=" + SEARCH08 + "&p_chassis_no=" + p_chassis_no;
		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		rtnName = ComGetEtcData(xml, "rtnName");
		if (rtnValue != 'OK') {
			if (!ComShowCodeConfirm("CTM20116")) {
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
				return;
			}
		}
		break;
	}
}
 /**
  * 체크 에러 발생시 그리드에 내역 표기 하거나 에러처리된 내역을 지우는 메소드
  * Col에 따라 지워야 하는 항목이 달라짐.
  * @param sheetObj
  * @param Row		 : Grid Row Number
  * @param Tp		  : Error Type. E : Error. S : Success
  * @param Col		 : Cell. C : Container. B : Booking
  * @return
  */
function clearGridForErr(sheetObj, Row, Tp, Col) {
	if (Tp == "E") {
		sheetContainerFlg = false;
		if (Col == "C") {
			sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
			sheetObj.CellValue(Row, "check_digit") = "";
			sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
			sheetObj.CellValue(Row, "prev_sts_cd") = "";
		} else {
			sheetObj.CellValue(Row, "rcv_term_cd") = "";
		}
		// 에러가 난 라인을 전역변수에 저장하고 포커스를 이동하는 것에 대비해 전역변수 errorBack에 1을 세팅함.
		// 이 값으로 이전으로 포커스가 이동하더라도 현재 이동한 셀에 대한 유효성검사를 생략할 수 있게 함
		focusCheck = false;
		setErr(Row);
		errorRow = Row;
		errorBack = 1;
	} else {
		//sheetObj.RowBackColor(Row) = sheetObj.RgbColor(241,241,241);
		sheetObj.Redraw = false;
		// 에러가 아닌 경우 색을 원래 색으로 돌려준다.
		sheetObj.RowBackColor(Row) = 0;
		for (xx = 1; xx <= sheetObj.LastCol; xx++) {
			if (!sheetObj.CellEditable(Row, xx))
				sheetObj.CellBackColor(Row, xx) = sheetObj.RgbColor(241, 241, 241);
		}
		sheetObj.Redraw = true;
		// 기본값으로 초기화 (-1)
		errorRow = -1;
		errorBack = -1;
	}
}
/**
 * pre check  버튼의 이벤트 처리. pre check을 위해 내용을 100개씩 최대 10개의 thread로 생성하게 해준다
 * 단 이 값은 공통js파일에 전역변수(maxThreadCount)로등록되어 있는 값을 참조한다
 * @return
 */
function preCheck() {
	// 별도로 정의 되지는 않았으나 sheet내장함수인 OnValidation으로 true/false를 먼저 check
	if (!sheetObjects[0].GetSaveString(true)) {
		return;
	}

	// VL, VD 구분없이 돌도록 변경.
	// 속도를 위해 한번에 서버로 넘기지 않고 저장과 마찬가지로 100건씩 나눠서 넘긴다.
	// 100건씩 생성 getFastString. 서버로 전송 xmlHttpPost는 공통메소드에 구현.
	var sheetObj = sheetObjects[0];
	if (sheetObj.LastRow < 1)
		return;
	var formObj = document.form;
	var status = formObj.p_status.value;
	sheetObj.WaitImageVisible = false;
	errCount = 0;
	formObj.f_cmd.value = SEARCH03;
	ComOpenWait(true);
	if (status == 'VL' || status == 'VD') {
		formObj.f_cmd.value = SEARCH03;
		var startId = 1;
		if (sheetObj.LastRow < 100)
			sendRows = sheetObj.LastRow;
		else {
			sendRows = Math.round(sheetObj.LastRow / maxThreadCount);
		}
		var endId = startId + sendRows;
		while (startId <= sheetObj.LastRow) {
			if (sheetObj.LastRow < endId)
				endId = sheetObj.LastRow;
			queryString = getFastString(sheetObj, startId, endId, false);
			xmlHttpPost("EES_CTM_0406GS.do", queryString + "&AJAX=Y&"
					+ FormQueryString(formObj), 'rtnpreCheckParses', startId);
			sendCount++;

			sleep(2000);
			startId = Number(startId) + Number(sendRows) + 1;
			endId = Number(endId) + Number(sendRows) + 1;
		}
	}
}
/**
 * pre check이후 실행 지정된 메소드. xmlHttpPost에 의해 실행이 완료되면 자동 호출되도록 지정됨.
 * @param rtnXml
 * @param startId
 * @return
 */
function rtnpreCheckParses(rtnXml, startId) {
	rtnStr = ComGetEtcData(rtnXml, "rtnStr");
	errCnt = ComGetEtcData(rtnXml, "errCount");
	rtnStrV = rtnStr.split("||")
	for (i = 0; i < rtnStrV.length - 1; i++) {
		if (rtnStrV[i] != 'null' && rtnStrV[i] != '') {
			sheetObj.CellValue(Number(startId) + Number(i), "err_msg") = rtnStrV[i];
			errCount = Number(errCount) + Number(1);
		}
	}

	sendCount--;
	if (sendCount < 1) {
		ComOpenWait(false);
		if (errCount == 0) {
			//alert ("There is no Problem to update");
			ComShowCodeMessage("CTM10018");
			preChk = true;
			ComBtnEnable("btn_save");
		} else {
			preChk = true;
			ComShowCodeMessage("CTM20080", errCnt);
			ComBtnEnable("btn_save");
		}
	}

}
/**
 * Excel에의해 Load된 Data를 체크한다.
 * 체크내역은 그리드의 일반 입력과 동일하게 처리되나 MessageBox형태가 아닌 rmk에 표시하는 형태로 지정됨
 * 모든 내역은 위에 기술된 컨테이너 체크와 동일함. 위의 설명 참조
 * @return
 */
function checkValidation() {
	p_yardValue = document.getElementById("p_yard2").Code;
	var formObj = document.form;
	var status = formObj.p_status.value;
	var vvdCd = formObj.p_vvd.value;
	var checkDigit = "";

	for (idx = 1; idx <= sheetObj.LastRow; idx++) {
		cntr_no = sheetObj.CellValue(idx, "cntr_no");
		checkDigit = "";
		if (cntr_no.length == 11) {
			checkDigit = cntr_no.substring(10, 11);
			cntr_no = cntr_no.substring(0, 10);

			sheetObj.CellValue(idx, "cntr_no") = cntr_no;
			sheetObj.CellValue(idx, "check_digit") = checkDigit;
		} else if (cntr_no.length == 0)
			sheetObj.CelLValue2(idx, "err_msg") = ("ERR");

		p_yard1 = formObj.p_yard1.value;
		p_yard2 = formObj.p_yard2.Code;

		sheetObj.CellValue2(idx, "org_yd_cd") = formObj.p_yard1.value + document.getElementById("p_yard2").Code
		sheetObj.CellValue2(idx, "mvmt_sts_cd") = formObj.p_status.value;
		sheetObj.CellValue(idx, "crnt_vsl_cd") = vvdCd.substring(0, 4);
		sheetObj.CellValue(idx, "crnt_skd_voy_no") = vvdCd.substring(4, 8);
		sheetObj.CellValue(idx, "crnt_skd_dir_cd") = vvdCd.substring(8, 9);

		// BKG NO가 있을 경우 Rcv Term을 가져온다.

		bkg_no = sheetObj.CellValue(idx, "bkg_no");
		formObj.f_cmd.value = SEARCH17;

		if (bkg_no.length < 1) {

		} else {
			if (status == 'OP' || status == 'OC') {
				queryString = "f_cmd=" + SEARCH17 + "&p_bkg_no=" + bkg_no
						+ "&p_bkg_no_split=";
				xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
				rtnValue = ComGetEtcData(xml, "rtnValue");
			} else {
				rtnValue = "";
				sheetObj.CellValue(idx, "bkg_no") = "";
			}
			if (rtnValue == "") {
				sheetObj.CellValue(idx, "bkg_no_split") = "";
				sheetObj.CellValue(idx, "rcv_term_cd") = "";

				sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20999");
				setErr(idx);
				continue;
			} else {
				rtnStr = rtnValue.split("||");
				// for (i = 0; i < rtnStr.length; i++)
				// alert (rtnStr[i]);
				if (rtnStr.length < 2) {
					sheetObj.CellValue(idx, "bkg_no_split") = "";
					sheetObj.CellValue(idx, "rcv_term_cd") = "";
				} else {
					sheetObj.CellValue(idx, "bkg_no_split") = rtnStr[0];
					sheetObj.CellValue(idx, "rcv_term_cd") = rtnStr[1];
					sheetBkgValueFlg = true;
				}
			}

		}
		cnmvEvntDt = sheetObj.CellValue(idx, "cnmv_evnt_dt");
		if (cnmvEvntDt == '') {
			sheetObj.CellValue2(idx, "cnmv_evnt_dt") = document.form.p_date0.value;
		}

		queryString = "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + formObj.p_yard1.value;
		xml = sheetObj.GetSearchXml("CTMCommonGS.do", queryString);
		rtnValue = ComGetEtcData(xml, "rtnValue");
		if (rtnValue == null) {
			sheetObj.CelLValue2(idx, "err_msg") = ("Not Exist Container");

			setErr(idx);
		} else {
			rtnStr = rtnValue.split("|");
			sheetObj.CellValue(idx, "cntr_tpsz_cd") = rtnStr[2];
			sheetObj.CellValue(idx, "prev_sts_cd") = rtnStr[1];
			sheetObj.CellValue(idx, "cnmv_yr") = document.form.p_date0.value.substring(0, 4);
			vr = rtnStr[0].substring(10, 11);

			if (rtnStr[8] == '0' && status != 'MT') {
				sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20119");
				GridForErr(sheetObj, idx, "E");
			}
			if (rtnStr[7] == 'Y' && rtnStr[4] == 'I'
					&& (status != 'MT' && status != 'OP')) {
				sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10005");
				GridForErr(sheetObj, idx, "E");
				continue;
			}
			if (vr != null)
				sheetObj.CellValue(idx, "check_digit") = vr;
			if (vr != checkDigit && checkDigit != "") {
				sheetObj.CellValue2(idx, "err_msg") = "Container check digit error"
						+ checkDigit + ":" + vr;
				sheetObj.CellValue(idx, "cntr_tpsz_cd") = "";
				sheetObj.CellValue(idx, "prev_sts_cd") = "";
				sheetObj.CellValue(idx, "check_digit") = "";

				GridForErr(sheetObj, idx, "E");
				continue;
			}
			/*******************************************************
			 *  컨테이너 상태를 체크한다.
			 ******************************************************/
			switch (status) {
			case "OP":
				/*
				 * 이전 Status가 MT. Yard가 동일하다.
				 */
				if (rtnStr[5] == 'Y') {
					if ((rtnStr[1] == 'MT' || rtnStr[1] == 'CM')
							&& rtnStr[3] == p_yard1 + p_yard2) {
						if (rtnStr[4] == 'I' && rtnStr[4] != 'A'
								&& rtnStr[5] != 'Y') {
							sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10005");
							GridForErr(sheetObj, idx, "E");
						} else if (rtnStr[6] != 'N') {
							sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10006");
							GridForErr(sheetObj, idx, "E");
						}
					} else {
						sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20075");
						GridForErr(sheetObj, idx, "E");
					}
				} else {
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10007");
					GridForErr(sheetObj, idx, "E");
				}
				break;

			case "OC":
				/**
				 * 반납 장비가 아닌 경우 사용 가능하다.
				 */
				if (rtnStr[6] != 'N') {
					//alert ("Immediately Exit Container");
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10006");

					GridForErr(sheetObj, idx, "E");

				} else if (rtnStr[1].substring(0, 1) != 'C') {
					if (rtnStr[5] != 'Y') {
						//alert ("Container Is Not Located In This Country!");
						sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10007");

						GridForErr(sheetObj, idx, "E");

					}
				} else {
					//alert ("This Is Not A Adequate Container!");
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10008");

					GridForErr(sheetObj, idx, "E");

				}
				break;

			case "VL":
				if (rtnStr[6] != 'N') {
					//alert ("Immediately Exit Container");
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10006");

					GridForErr(sheetObj, idx, "E");

				} else if (rtnStr[1] == 'VL') {
					//alert ("Aleady 'VL' Container!");
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20076",
							"VL");

					GridForErr(sheetObj, idx, "E");

				} else {
					/****************************************
					 *   VL인경우 FULL/EMPTY구분.
					 *****************************************/
					strQuery = "f_cmd=" + SEARCH04 + "&cntr_no="
							+ sheetObj.CellValue(idx, "cntr_no")
							+ sheetObj.CellValue(idx, "check_digit");
					strQuery = strQuery + "&crnt_vsl_cd="
							+ sheetObj.CellValue(idx, "crnt_vsl_cd");
					strQuery = strQuery + "&crnt_skd_voy_no="
							+ sheetObj.CellValue(idx, "crnt_skd_voy_no");
					strQuery = strQuery + "&crnt_skd_dir_cd="
							+ sheetObj.CellValue(idx, "crnt_skd_dir_cd");
					strQuery = strQuery + "&pol_cd="
							+ sheetObj.CellValue(idx, "pol_cd");
					strQuery = strQuery + "&mvmt_sts_cd="
							+ sheetObj.CellValue(idx, "mvmt_sts_cd");
					strQuery = strQuery + "&p_type1=" + formObj.p_type1.value;
					// strQuery = strQuery + "&p_type2=" +
					// formObj.p_type2.value;

					rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do",
							strQuery);

					rtnStr = ComGetEtcData(rtnXml, "rtnStr");
					if (rtnStr == -1) {
						sheetObj.CellValue2(idx, "err_msg") = ("Invalid loading Container No!");
						GridForErr(sheetObj, idx, "E");

					}
				}
				break;

			case "VD":
				if (rtnStr[1] == 'VD') {
					//alert ("Aleady 'VD' Container!");
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20076",
							"VD");

					GridForErr(sheetObj, idx, "E");

				} else {
					/**************************************
					 *  POL LOCATION이 있는 경우 와 없는 경우로 나눠서 체크.
					 *  Sub_VD 참조.
					 */
					strQuery = "f_cmd=" + SEARCH04 + "&cntr_no="
							+ sheetObj.CellValue(idx, "cntr_no")
							+ sheetObj.CellValue(idx, "check_digit");
					strQuery = strQuery + "&crnt_vsl_cd="
							+ sheetObj.CellValue(idx, "crnt_vsl_cd");
					strQuery = strQuery + "&crnt_skd_voy_no="
							+ sheetObj.CellValue(idx, "crnt_skd_voy_no");
					strQuery = strQuery + "&crnt_skd_dir_cd="
							+ sheetObj.CellValue(idx, "crnt_skd_dir_cd");
					strQuery = strQuery + "&pod_cd="
							+ sheetObj.CellValue(idx, "pod_cd");
					strQuery = strQuery + "&mvmt_sts_cd="
							+ sheetObj.CellValue(idx, "mvmt_sts_cd");
					strQuery = strQuery + "&p_type1=" + formObj.p_type1.value;
					// strQuery = strQuery + "&p_type2=" +
					// formObj.p_type2.value;

					rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do",
							strQuery);
					rtnStr = ComGetEtcData(rtnXml, "rtnStr");
					if (rtnStr == "-1") {
						sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20077");
						GridForErr(sheetObj, idx, "E");
					}
				}
				break;

			case "TS":
				if (rtnStr[1] != 'TS') {
					if ((rtnStr[1] == 'EN') || (rtnStr[1] == 'TN')) {
						/******************************
						 *  EN / TN일 경우 처리가능 하도록 한다
						 */
					} else {
						sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20078");
						GridForErr(sheetObj, idx, "E");
					}

				} else {
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM20078");
					GridForErr(sheetObj, idx, "E");

				}
				break;

			case "MT":
				if ((rtnStr[1] == 'CM') || (rtnStr[1] == 'CP') || (rtnStr[1].substring(0, 1) != 'C')) {
					if (rtnStr[7] == 'Y') {
					} else if (rtnStr[5] != 'Y') {
						sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10007");
						GridForErr(sheetObj, idx, "E");
					}
				} else {
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10008");
					GridForErr(sheetObj, idx, "E");
				}
				break;

			case "CM":
				if (rtnStr[1] == 'MT' || rtnStr[1].substring(0, 1) == 'C') {

				} else {
					sheetObj.CellValue2(idx, "err_msg") = ComGetMsg("CTM10008");
					GridForErr(sheetObj, idx, "E");
				}

			}
			sheetObj.CellEditable(idx, "cntr_no") = true;
			sheetObj.CellEditable(idx, "bkg_no") = true;
			sheetObj.CellEditable(idx, "cnmv_evnt_dt") = true;
		}
	}
}
/**
 * 체크 결과 에러가 났을 경우의 처리. 엑셀에서 처리된 에러는 포커스의 이동이 없다.
 * 에러행을 기록해야할 이유가 없는 관계로 별도의 메소드 처리됨.
 * @param sheetObj
 * @param Row
 * @param Tp
 * @return
 */
function GridForErr(sheetObj, Row, Tp) {
	if (Tp == "E") {
		sheetContainerFlg = false;
		setErr(Row);
	} else {
		sheetObj.Redraw = false;
		sheetObj.RowBackColor(Row) = 0;
		for (xx = 1; xx <= sheetObj.LastCol; xx++) {
			if (!sheetObj.CellEditable(Row, xx))
				sheetObj.CellBackColor(Row, xx) = sheetObj.RgbColor(241, 241,
						241);
			;
		}
		sheetObj.Redraw = true;
		sheetObj.CellValue2(Row, "err_msg") = "";
	}
}
/**
 * 에러가 났을 경우 해당 행의 색을 바꿔주기 위해 만들어둔 내부 펑션
 * @param Row
 * @return
 */
function setErr(Row) {
	sheetObj.RowBackColor(Row) = sheetObj.RgbColor(240, 200, 200);
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function sheet_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	if (sheetObj.ColSaveName(Col) != "del_chk") {
		// row클릭시 해당 Check Box도 체크
		with (sheetObj) {
			// "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
			var sRowStr = GetSelectionRows("/");
			var arr = sRowStr.split("/");

			if (arr.length > 1) {
				for (i = 0; i < arr.length; i++) {
					if (CellEditable(Row, "del_chk")) {
						CellValue(arr[i], "del_chk") = "1"; // 선택된 행의 CheckBox
															// 체크
					}
				}
			}
		}
	}
}

/**
 * 멀티 thread방식으로 전환 되었을 때 한번에 너무 많은 데이타가 날아가는 것을 방지하기 위해
 * 만들어 두었으나 그 필요성에 의문을 느껴 주석 처리함.
 * @param milliseconds
 * @return
 */
function sleep(milliseconds) {
	var start = new Date().getTime();
	// for (var i = 0; i < 1e7; i++) {
	// if ((new Date().getTime() - start) > milliseconds){
	// break;
	// }
}


	/**
	 * Use in [btn_add] or [function cntrno_keyUp]
	 * @param Row
	 * @return
	 */
	function addRow() {
		var sheetObject = sheetObjects[0];
		var frmObj = document.form;
		var stsCond = frmObj.p_status.value;
		var Row = 0;
		if (checkFormField()) {
			// Yard가 비어 있을 경우 Row Add를 못하도록 제한한다.
			if (document.getElementById("p_yard2").Code == "") {
			ComShowCodeMessage("CTM10049", "yard cd", "", "")
			return 0;
			}
			// Row Add가 이루어진 후 Hidden 칼럼들의 Data를 모두 채워준다.
			Row = sheetObject.DataInsert(-1);
			sheetObject.CellValue(Row, "cnmv_evnt_dt") = frmObj.p_date0.value;
			sheetObject.CellValue(Row, "org_yd_cd") = frmObj.p_yard1.value + document.getElementById("p_yard2").Code;
			sheetObject.CellValue(Row, "mvmt_sts_cd") = frmObj.p_status.value;

			vvdCd = frmObj.p_vvd.value;
			sheetObject.CellValue(Row, "crnt_vsl_cd") = vvdCd.substring(0, 4);
			sheetObject.CellValue(Row, "crnt_skd_voy_no") = vvdCd.substring(4, 8);
			sheetObject.CellValue(Row, "crnt_skd_dir_cd") = vvdCd.substring(8, 9);

			sheetObject.CellValue(Row, "pol_cd") = frmObj.p_pol.value;
			sheetObject.CellValue(Row, "pod_cd") = frmObj.p_pod.value;
			sheetObject.CellValue(Row, "cnmv_yr") = frmObj.p_date0.value.substring(0, 4);
			if (stsCond == "VL" || stsCond == "VD") {
				sheetObj.CellEditable(Row, "bkg_no") = false;
				sheetObj.CellEditable(Row, "cnmv_evnt_dt") = false;
			} else {
				sheetObj.CellEditable(Row, "bkg_no") = true;
				sheetObj.CellEditable(Row, "cnmv_evnt_dt") = true;
			}
			setElementDisable(true);
			sheetObj.SelectCell(Row, 3);
		}
		ComBtnDisable("btn_loadExcel");
		return Row;
	}

	 function sheet_OnChange(sheetObj, Row, Col, Value) {
	        var SaveName = sheetObj.ColSaveName(Col);
	        if (SaveName == "cnmv_evnt_dt") {
	            // Event Date를 수정한 경우 Validation한다.
	            var srcEvent = sheetObj.CellText(Row, "cnmv_evnt_dt");
	            if(!ComIsDateTime(srcEvent, "", "hm"))
	            {
	            	ComShowCodeMessage("CTM00001");
	            	sheetObj.CellValue2(Row, "cnmv_evnt_dt") = document.form.p_date0.value;
	            	sheetObj.SelectCell(Row, Col, true);
					return;
	            }
	        }
	 }
	 
	/**
	 * Use in [btn_multi_add] or [function cntrno_keyUp]
	 * @param Row
	 * @return
	 */
	function addMultiRow() {
		var sheetObject = sheetObjects[0];
		var frmObj = document.form;
		var stsCond = frmObj.p_status.value;
		var Row = 0;
		if (checkFormField()) {
			// Yard가 비어 있을 경우 Row Add를 못하도록 제한한다.
			if (document.getElementById("p_yard2").Code == "") {
				ComShowCodeMessage("CTM10049", "yard cd", "", "")
			}else{
  				ComOpenPopup('EES_CTM_0466.do', 400, 380, 'getCntr_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', false);
			}
		}
	}

	function getCntr_Multi(cntrNoArray, eventDtArray, return_val) {

		var sheetObject = sheetObjects[0];
		var frmObj = document.form;
		var stsCond = frmObj.p_status.value;
		var Row = 0;

		var cntrNoArray = cntrNoArray+"";
		var eventDtArray = eventDtArray+"";

		var cntrNos = cntrNoArray.split(",");
		var eventDts = eventDtArray.split(",");

		for (var i = 0; i < cntrNos.length; i++) {
			// Row Add가 이루어진 후 Hidden 칼럼들의 Data를 모두 채워준다.
			Row = sheetObject.DataInsert(-1);

			sheetObject.CellValue(Row, "cntr_no") = cntrNos[i];
			
			if(ComIsNull(eventDts[i])){
				sheetObject.CellValue(Row, "cnmv_evnt_dt") = frmObj.p_date0.value;				
			}else{
				sheetObject.CellValue(Row, "cnmv_evnt_dt") = eventDts[i];
			}
			sheetObject.CellValue(Row, "org_yd_cd") = frmObj.p_yard1.value + document.getElementById("p_yard2").Code;
			sheetObject.CellValue(Row, "mvmt_sts_cd") = frmObj.p_status.value;

			vvdCd = frmObj.p_vvd.value;
			sheetObject.CellValue(Row, "crnt_vsl_cd") = vvdCd.substring(0, 4);
			sheetObject.CellValue(Row, "crnt_skd_voy_no") = vvdCd.substring(4, 8);
			sheetObject.CellValue(Row, "crnt_skd_dir_cd") = vvdCd.substring(8, 9);

			sheetObject.CellValue(Row, "pol_cd") = frmObj.p_pol.value;
			sheetObject.CellValue(Row, "pod_cd") = frmObj.p_pod.value;
			sheetObject.CellValue(Row, "cnmv_yr") = frmObj.p_date0.value.substring(0, 4);
			if (stsCond == "VL" || stsCond == "VD") {
				sheetObj.CellEditable(Row, "bkg_no") = false;
				sheetObj.CellEditable(Row, "cnmv_evnt_dt") = false;
			} else {
				sheetObj.CellEditable(Row, "bkg_no") = true;
				sheetObj.CellEditable(Row, "cnmv_evnt_dt") = true;
			}
			setElementDisable(true);
			sheetObj.SelectCell(Row, 3);
		}
		
		ComBtnDisable("btn_loadExcel");
		ComEnableObject(formObj.btn_multi_add, true);
	}
/* 개발자 작업  끝 */
