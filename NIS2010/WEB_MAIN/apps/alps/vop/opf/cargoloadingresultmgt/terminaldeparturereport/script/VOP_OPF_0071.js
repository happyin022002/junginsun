/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VOP_OPF_0071.js
 *@FileTitle : Vessel Not Operationally Ready Report Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.27
 *@LastModifier : 이병훈
 *@LastVersion : 1.0
 * 2015.03.27 이병훈
 * 1.0 Creation
 * 
* History
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
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
 * @class VOP_FCM_0071 : VOP_FCM_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0071() {
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
var comboObjects = new Array();
var comboCnt = 0;

var from_date = "";
var to_date = "";
var fileUploadSheetIndex = 0;
var checkedRows = "";

var NUMBER_STRING = "0123456789"; // 숫자 
var SPCHAR_STRING = "~!@#$%^&*()_+{}|:<>?`-=[]\\;',./\" "; // 키보드상의 특수 문자 Punctuation, Typography...

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			
			case "btn_New":
				clearAll();
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObj, COMMAND01);
				break;
				
			case "btn_Submit":
				doActionIBSheet(sheetObject1, formObj, COMMAND02);
				break;
				
			case "btn_Delete":
				doActionIBSheet(sheetObject1, formObj, COMMAND03);
				break;
				
			case "btn_Setup":
				openPicPopup();
				break;
				
			case "btn_Down_Excel":
				var sheet1_skipCols = "file_attach";
				var sheet2_skipCols = "chk|file_attach";
				sheetObject1.Down2Excel(-1, true, true, true, "", "", false, false, "", false, sheet1_skipCols);
				if (sheetObject2.RowCount > 0) {
					sheetObject2.Down2Excel(-1, true, true, true, "", "", false, false, "", false, sheet2_skipCols);
				}
				break;
				
			case "btn_RowAdd":
				addSubItem();
				break;
				
			case "btn_RowDelete":
				ComRowHideDelete(sheetObject2, "chk");
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	
	// IBSheet 초기화
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// IBCombo 초기화
	for(var k=0; k<comboObjects.length; k++){
		initCombo(comboObjects[k], k+1);
	}
	
	initControl();
	initComboData();
	formObj.vnor_fm_port_cd.Enable = false;
	formObj.vnor_to_port_cd.Enable = false;
	formObj.vnor_stup_sts_cd.Enable = false;
	formObj.vnor_offh_tp_cd.Enable = false;
	addDefaultMainItem();
	ComBtnDisable("btn_Submit");
	ComBtnDisable("btn_Delete");
	
	setFromInquiry(); // VNOR Summary Inquiry 화면에서 오픈 되었을 경우 처리
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
			style.height = 60;
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
			
			var HeadTitle1 = "|Item|vnor_itm_ofc_cd|UOM|Value|File|File|Status|Remark|ItmSeq|FileLnkId|is_upload_possible|vnor_mn_itm_flg";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, 	false, 		"ibflag");
			InitDataProperty(0, cnt++ , dtCombo,		150,	daCenter,		false,		"vnor_itm_cd",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,		false,		"vnor_itm_ofc_cd",		false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		false,		"vnor_itm_ut_cd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		"vnor_itm_val",			false,	"",	dfFloat,			2,	false,	false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,		daCenter,		false,		"file_attach",				false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtData		,	30,		daCenter,		false,		"atch_file_knt",			false,	"",	dfInteger,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		false,		"vnor_itm_sts_cd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			false,		"vnor_itm_rmk",			false,	"",	dfEngKey,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"vnor_itm_seq",  		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"atch_file_lnk_id",  		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"is_upload_possible",  	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"vnor_mn_itm_flg",  	false,	"",	dfNone,		0,	false,	false);
			
			InitDataCombo (0, "vnor_itm_cd", "Off-Hire Time(LT)", "OH");
			InitDataCombo (0, "vnor_itm_ut_cd", "Hour", "H");
			InitDataCombo (0, "vnor_itm_sts_cd", " |Saved|Submitted", " |SA|SU");
			InitDataValid(0, "vnor_itm_rmk", vtEngOther, NUMBER_STRING + SPCHAR_STRING );
			ShowButtonImage = 2;
		}
		break;
		
	case 2: // sheet2 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 180;
			// 전체 너비 설정
			SheetWidth = subTable.clientWidth;
			
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
			InitHeadMode(true, false, true, true, false, false);
			
			var HeadTitle1 = "||Item|Office|UOM|Value|File|File|Status|Remark|ItmSeq|FileLnkId|is_upload_possible|vnor_mn_itm_flg";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, 	false, 		"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 		"chk", 						false, "", 	dfNone, 		0, 	true, 	true);
			InitDataProperty(0, cnt++ , dtCombo,		150,	daCenter,		false,		"vnor_itm_cd",			false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtComboEdit,	100,	daCenter,		false,		"vnor_itm_ofc_cd",		false,	"",	dfEngUpKey,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		false,		"vnor_itm_ut_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		"vnor_itm_val",			false,	"",	dfFloat,		2,	true,	true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,		daCenter,		false,		"file_attach",				false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		false,		"atch_file_knt",			false,	"",	dfInteger,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		false,		"vnor_itm_sts_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			false,		"vnor_itm_rmk",			false,	"",	dfEngKey,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"vnor_itm_seq",  		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"atch_file_lnk_id",  		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"is_upload_possible",  	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,		true,		"vnor_mn_itm_flg",  	false,	"",	dfNone,		0,	false,	false);
			
			InitDataCombo (0, "vnor_itm_cd", " |HFO (M/T)|MDO(M/T)|LSFO(M/T)|LSDO(M/T)|Port Charge|Terminal Charge|Others", " |HF|MD|LF|LD|PC|TC|OT");
			InitDataCombo (0, "vnor_itm_ut_cd", " |MT|$", " |T|D");
			InitDataCombo (0, "vnor_itm_sts_cd", " |Saved|Submitted", " |SA|SU");
			InitDataValid(0, "vnor_itm_ofc_cd", vtEngUpOnly);
			InitDataValid(0, "vnor_itm_rmk", vtEngOther, NUMBER_STRING + SPCHAR_STRING );
			ShowButtonImage = 2;
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
	axon_event.addListenerForm('click', 'obj_click', formObj);
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm("activate", "obj_activate", formObj);
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	var comboId = comboObj.id;
	switch(comboId) {
		case "vnor_fm_port_cd":
		case "vnor_to_port_cd":
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 5;
			}
		break; 			
	} 
}

/**
 * 콤보리스트를 생성한다.
 */
function initComboData() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	// 콤보 목록 가져오기 : Kind Code
	doActionIBSheet(sheetObj, formObj, SEARCHLIST01);
	// 콤보 목록 가져오기 : Vessel Status Code
	doActionIBSheet(sheetObj, formObj, SEARCHLIST02);
	// 콤보 목록 가져오기 : VNOR Status Code
	doActionIBSheet(sheetObj, formObj, SEARCHLIST03);
	// 콤보 목록 가져오기 : Type Code
	doActionIBSheet(sheetObj, formObj, SEARCHLIST04);
}

/**
 * Click 이벤트 처리
 */
function obj_click() {
	var formObj = document.form;
	var obj = event.srcElement.name;
	
	if (obj == "credit_chk") {
		if (formObj.credit_chk.checked) {
			ComShowMessage("If Credit checks Off-Hire Time is calculated negative.");
			formObj.cr_chk_flg.value = "Y";
			setOffHireValue();
		} else {
			formObj.cr_chk_flg.value = "N";
			setOffHireValue();
		}
	}
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
		case "engupnum":
			//영문대문자+숫자 입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "time":
			//숫자+"."+":" 입력하기
			ComKeyOnlyNumber(obj, '.:');
			break;
	}
	

}

/**
 * Activate 이벤트 처리
 */
function obj_activate() {
	var formObj = document.form;
	var obj = event.srcElement;
	
	switch (obj.name) {
		case "vnor_offh_fm_dt": //Off-Hire Time(From)
		case "vnor_offh_to_dt":	//Off-Hire Time(From)
			if (obj.value == "" || obj.value.length != 16) {
				break;
			}
			
			obj.value = obj.value.trimAll(".").trimAll(":");
			break;
	}
}

/**
 * Deactivate 이벤트 처리
 */
function obj_deactivate() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;

	switch (obj.name) {
		case "vnor_offh_fm_dt": //Off-Hire Time(From)
		case "vnor_offh_to_dt":	//Off-Hire Time(From)
			if (obj.value == "") {
				break;
			}
			// Date Format Check
			if (!checkDateFormat(obj)) {
				ComShowCodeMessage("OPF50044", "'yyyy.mm.dd.hh:mi'");
		    	sheetObj.CellValue2(1, "vnor_itm_val") = "";
		    	obj.value = "";
				break;
			}
			
			// Off-Hire Time Item Value 값을 계산하기 위한 Date 변수 셋팅
			if (obj.name == "vnor_offh_fm_dt") {
				from_date = getDateObj(obj.value);
			} else if (obj.name == "vnor_offh_to_dt") {
				to_date = getDateObj(obj.value);
			}
			
			// Off-Hire Time Period Check
			if (from_date != "" && to_date != "") {
				if (from_date > to_date) {
			    	ComShowCodeMessage("OPF50013", "Off-Hire Time(To)", "Off-Hire Time(From)");
			    	sheetObj.CellValue2(1, "vnor_itm_val") = "";
				} else {
					setOffHireValue();
				}
			}
			
			break;
			
		case "skd_voy_no":	// Voy no.
			var vsl_cd = formObj.vsl_cd.value;
			var skd_voy_no = formObj.skd_voy_no.value;
			
			if (skd_voy_no.length == 0) {
				break;
			}
			
			if (vsl_cd.length != 4) {
				ComShowCodeMessage("OPF50009", "Vessel");
				formObj.skd_voy_no.value = "";
				break;
			}
			
			if (!doActionIBSheet(sheetObj, formObj, SEARCH02)) { // Voy No가 유효하지 않으면
				ComShowCodeMessage("OPF50004", skd_voy_no);
				formObj.skd_voy_no.value = "";
			} else { // Voy No가 유효하면 VSK SKD에서 Port 정보를 가져온다.
				doActionIBSheet(sheetObj, formObj, SEARCHLIST07);
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
			
			if (doActionIBSheet(sheetObj, formObj, SEARCH01)) { // VSL CODE가 유효하면
				doActionIBSheet(sheetObj, formObj, SEARCHLIST06); // Off-Hire Time List 조회
			} else {
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
			
		case SEARCHLIST02: // Vessel Status Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST02;
			formObj.intg_cd_id.value = "CD03385";
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_vsl_sts_cd);
			ComOpenWait(false);
			break;
			
		case SEARCHLIST03: // VNOR Status Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST03;
			formObj.intg_cd_id.value = "CD03389";
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_stup_sts_cd);
			ComOpenWait(false);
			break;
			
		case SEARCHLIST04: // Type Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST04;
			formObj.intg_cd_id.value = "CD03384";
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_offh_tp_cd);
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
			
		case SEARCHLIST06: // Off-Hire Time List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST06;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.off_hire_time_list);
			ComOpenWait(false);
			break;
			
		case SEARCHLIST07: // Port List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST07;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			setCombo(arrCombo, formObj.vnor_fm_port_cd);
			setCombo(arrCombo, formObj.vnor_to_port_cd);
			ComOpenWait(false);
			break;
			
		case SEARCHLIST08: // Office Code List 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST08;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_ctnt");
			sheetObjects[1].InitDataCombo(0, "vnor_itm_ofc_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
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
			
		case SEARCH02: // Voyage No Check
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var isVslOk = ComGetEtcData(sXml, "is_vsl_ok");
			ComOpenWait(false);
			if (isVslOk == "Y") {
				return true;
			} else {
				return false;
			}
			break;
			
		case SEARCH03: // From Port Check
			ComOpenWait(true);
			var sParam = "f_cmd="+SEARCH03;
			sParam += "&vsl_cd="+formObj.vsl_cd.value;
			sParam += "&skd_voy_no="+formObj.skd_voy_no.value;
			sParam += "&vnor_fm_port_cd="+formObj.vnor_fm_port_cd.Text;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", sParam);
			var isVslOk = ComGetEtcData(sXml, "is_vsl_ok");
			ComOpenWait(false);
			if (isVslOk == "Y") {
				return true;
			} else {
				return false;
			}
			break;
			
		case SEARCH04: // To Port Check
			ComOpenWait(true);
			var sParam = "f_cmd="+SEARCH04;
			sParam += "&vsl_cd="+formObj.vsl_cd.value;
			sParam += "&skd_voy_no="+formObj.skd_voy_no.value;
			sParam += "&vnor_to_port_cd="+formObj.vnor_to_port_cd.Text;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", sParam);
			var isVslOk = ComGetEtcData(sXml, "is_vsl_ok");
			ComOpenWait(false);
			if (isVslOk == "Y") {
				return true;
			} else {
				return false;
			}
			break;
			
		case SEARCH05: // Sheet2 Office Code Check
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH05;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var isOK = ComGetEtcData( sXml, "IS_OK");	
			ComOpenWait(false);
			if (isOK == "Y") {
				return true;
			} else {
				return false;
			}
			break;
			
		case IBSEARCH: // 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0071GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			// 헤더 정보 셋팅
			formObj.vnor_seq.value = ComGetEtcData(arrXml[0], "vnor_seq");
			formObj.cr_chk_flg.value = ComGetEtcData(arrXml[0], "cr_chk_flg");
			if (ComGetEtcData(arrXml[0], "cr_chk_flg") == "Y") {
				formObj.credit_chk.checked = true;
			} else {
				formObj.credit_chk.checked = false;
			}
			formObj.skd_voy_no.value = ComGetEtcData(arrXml[0], "skd_voy_no");
			
			doActionIBSheet(sheetObj, formObj, SEARCHLIST07); // Port List 조회
			
			formObj.vnor_vsl_sts_cd.Code = ComGetEtcData(arrXml[0], "vnor_vsl_sts_cd");
			formObj.vnor_fm_port_cd.Code2 = ComGetEtcData(arrXml[0], "vnor_fm_port_cd");
			
			doActionIBSheet(sheetObj, formObj, SEARCHLIST08); // Office Code List 조회
			
			formObj.vnor_to_port_cd.Code2 = ComGetEtcData(arrXml[0], "vnor_to_port_cd");
			formObj.vnor_stup_sts_cd.Code = ComGetEtcData(arrXml[0], "vnor_stup_sts_cd");
			formObj.vnor_offh_knd_cd.Code2 = ComGetEtcData(arrXml[0], "vnor_offh_knd_cd");
			formObj.vnor_offh_tp_cd.Code2 = ComGetEtcData(arrXml[0], "vnor_offh_tp_cd");
			formObj.vnor_rmk.value = ComGetEtcData(arrXml[0], "vnor_rmk");
			formObj.eml_snd_no.value = ComGetEtcData(arrXml[0], "eml_snd_no");
			// Sheet 데이터 셋팅
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			ComOpenWait(false);
			// 각 항목들에 대해서 수정 가능 여부 셋팅
			setEditableField();
			break;
			
		case COMMAND01: // Save
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND01;
				var sParam = FormQueryString(formObj);
				sParam += "&"+sheetObjects[0].GetSaveString(false);
				sParam += "&"+sheetObjects[1].GetSaveString(false);
				checkedRows = sheetObjects[1].FindCheckedRow("chk");
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0071GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				formObj.vnor_seq.value = ComGetEtcData( sXml, "VNOR_SEQ");
				var resultKey = ComGetEtcData( sXml, "TRANS_RESULT_KEY");
				var isOK = ComGetEtcData( sXml, "IS_OK");	
				
				if (isOK == "N") {
					ComShowMessage("Off-Hire Time Duplication!");
					addDefaultMainItem();
				}
				
				if (resultKey == "S" && isOK == "Y") {
	 	 			doActionIBSheet(sheetObj, formObj, SEARCHLIST06); // Off-Hire Time List 조회
	 	 			formObj.off_hire_time_list.Code = formObj.vnor_offh_fm_dt.value + "-" + formObj.vnor_offh_to_dt.value + formObj.cr_chk_flg.value + formObj.vnor_seq.value;
	 	 		}
				
				afterSaveRowCheck();
			}
			break;
			
		case COMMAND02: // Submit
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND02;
				var sParam = FormQueryString(formObj);
				if (formObj.vnor_stup_sts_cd.Code == "SA") {
					sParam += "&"+sheetObjects[0].GetSaveString(true);
				}
				sParam += "&"+sheetObjects[1].GetSaveString(false, true, "chk");
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0071GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				var resultKey = ComGetEtcData( sXml, "TRANS_RESULT_KEY");
				if (resultKey == "S") {
	 	 			doActionIBSheet(sheetObj, formObj, SEARCHLIST06); // Off-Hire Time List 조회
	 	 			formObj.off_hire_time_list.Code = formObj.vnor_offh_fm_dt.value + "-" + formObj.vnor_offh_to_dt.value + formObj.cr_chk_flg.value + formObj.vnor_seq.value;
	 	 		}
			}
			break;
			
		case COMMAND03: // Delete
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND03;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0071GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				var resultKey = ComGetEtcData( sXml, "TRANS_RESULT_KEY");
				if (resultKey == "S") {
					clearAll();
				}
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
		case COMMAND01: // Save
			// Mandatory Field Check
			if (formObj.vsl_cd.value.length != 4 || formObj.vnor_offh_fm_dt.value.length != 16 || formObj.vnor_offh_to_dt.value.length != 16) {
				ComShowCodeMessage("OPF50009", "Mandatory Field");
				return false;
			}
			// Off-Hire Time Period Check
			if (from_date != "" && to_date != "") {
				if (from_date > to_date) {
			    	ComShowCodeMessage("OPF50013", "Off-Hire Time(To)", "Off-Hire Time(From)");
			    	return false;
				}
			}
			return true;
			break;
			
		case COMMAND02: // Submit
			if (formObj.vnor_stup_sts_cd.Code == "") {
				ComShowCodeMessage("OPF50045", "Saved Data");
				return false;
			}
			
			if (formObj.vnor_vsl_sts_cd.Code == "LU") { // Place 가 Dock 일 경우에는 From Port 값 입력 여부 체크 안 함
				if (formObj.vsl_cd.value.length != 4 || formObj.vnor_offh_fm_dt.value.length != 16 || formObj.vnor_offh_to_dt.value.length != 16 || formObj.skd_voy_no.value.length != 5
					|| formObj.vnor_vsl_sts_cd.Code == "" || formObj.vnor_offh_knd_cd.Code == "") {
					ComShowCodeMessage("OPF50009", "All Field");
					return false;
				}
			} else {
				if (formObj.vsl_cd.value.length != 4 || formObj.vnor_offh_fm_dt.value.length != 16 || formObj.vnor_offh_to_dt.value.length != 16 || formObj.skd_voy_no.value.length != 5
					|| formObj.vnor_vsl_sts_cd.Code == "" || formObj.vnor_fm_port_cd.Code.length != 5 || formObj.vnor_offh_knd_cd.Code == "") {
					ComShowCodeMessage("OPF50009", "All Field");
					return false;
				}
			}
			
			if (!ComShowConfirm(ComGetMsg("OPF50046"))) {
				return false;
			}
			
			return true;
			break;
			
		case COMMAND03: // Delete
			if (formObj.vnor_stup_sts_cd.Code == "SU") {
				ComShowCodeMessage("OPF50026", "Submitted Data");
				return false;
			}
			
			if (!ComShowConfirm(ComGetMsg("OPF50047"))) {
				return false;
			}
			
			return true;
			break;
	}
	return true;
}

/**
 * New 버튼 처리
 */
function clearAll() {
	var formObj = document.form;
	ComResetAll();
	formObj.vsl_cd.readOnly = false;
	formObj.vnor_offh_fm_dt.readOnly = false;
	formObj.vnor_offh_to_dt.readOnly = false;
	formObj.credit_chk.disabled = false;
	formObj.skd_voy_no.readOnly = false;
	formObj.skd_voy_no.className = "input";
	formObj.vnor_vsl_sts_cd.Enable = true;
	formObj.vnor_fm_port_cd.Enable = false;
	formObj.vnor_fm_port_cd.RemoveAll();
	formObj.vnor_to_port_cd.Enable = false;
	formObj.vnor_to_port_cd.RemoveAll();
	formObj.vnor_offh_knd_cd.Enable = true;
	formObj.vnor_offh_tp_cd.Enable = false;
	formObj.vnor_rmk.readOnly = false;
	formObj.vnor_rmk.className = "input";
	formObj.off_hire_time_list.RemoveAll();
	formObj.intg_cd_val_ctnt.value = "";
	sheetObjects[1].InitDataCombo(0, "vnor_itm_ofc_cd", "", "");
	initComboData();
	addDefaultMainItem();
	ComBtnEnable("btn_Save");
	ComBtnDisable("btn_Submit");
	ComBtnDisable("btn_Delete");
}

/**
 * Deault Main Item (Off-Hire) Row Add
 */
function addDefaultMainItem() {
	var sheetObj = sheetObjects[0];
	var row = sheetObj.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
	sheetObj.CellValue2(row, "atch_file_knt") = 0;
	sheetObj.CellValue2(row, "is_upload_possible") = "N";
	sheetObj.CellValue2(row, "vnor_mn_itm_flg") = "Y";
}

/**
 * Sub Item Row Add
 */
function addSubItem() {
	var sheetObj = sheetObjects[1];
	var row = sheetObj.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가
	sheetObj.CellValue2(row, "chk") = 1;
	sheetObj.CellValue2(row, "atch_file_knt") = 0;
	sheetObj.CellValue2(row, "is_upload_possible") = "N";
	sheetObj.CellValue2(row, "vnor_mn_itm_flg") = "N";
	sheetObj.CellEditable(row, "vnor_itm_ofc_cd") = false;
	ComBtnEnable("btn_Save");
}

/**
 * Main Item File Attach Pop-up Open
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
	
	if (sName == "file_attach") {
		fileUploadPopUp( sheetObj, Row);
	}
}

/**
 * sheet1 조회 후 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var sRow = sheetObj.HeaderRows;
	var eRow = sheetObj.RowCount;
	
	formObj.save_flg.value = "N";
	for (var i = sRow; i <= eRow; i++) {
		if (sheetObj.CellValue(i, "vnor_itm_sts_cd") == "SU") {
			sheetObj.CellEditable(i, "vnor_itm_rmk") = false;
			sheetObj.CellValue2(i, "is_upload_possible") = "N";
		} else {
			sheetObj.CellEditable(i, "vnor_itm_rmk") = true;
			sheetObj.CellValue2(i, "is_upload_possible") = "Y";
			formObj.save_flg.value = "Y";
		}
		sheetObj.CellValue2(i, "ibflag") = "";
	}
}

/**
 * sheet2 조회 후 처리
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var sRow = sheetObj.HeaderRows;
	var eRow = sheetObj.RowCount;
	
	for (var i = sRow; i <= eRow; i++) {
		if (sheetObj.CellValue(i, "vnor_itm_sts_cd") == "SU") {
			sheetObj.CellEditable(i, "chk") = false;
			sheetObj.CellEditable(i, "vnor_itm_cd") = false;
			sheetObj.CellEditable(i, "vnor_itm_ofc_cd") = false;
			sheetObj.CellEditable(i, "vnor_itm_val") = false;
			sheetObj.CellEditable(i, "vnor_itm_rmk") = false;
			sheetObj.CellValue2(i, "is_upload_possible") = "N";
		} else {
			sheetObj.CellEditable(i, "chk") = true;
			sheetObj.CellEditable(i, "vnor_itm_cd") = true;
			sheetObj.CellEditable(i, "vnor_itm_ofc_cd") = true;
			sheetObj.CellEditable(i, "vnor_itm_val") = true;
			sheetObj.CellEditable(i, "vnor_itm_rmk") = true;
			sheetObj.CellValue2(i, "is_upload_possible") = "Y";
			formObj.save_flg.value = "Y";
			
			if (sheetObj.CellValue(i, "vnor_itm_cd") == "PC" || sheetObj.CellValue(i, "vnor_itm_cd") == "TC" || sheetObj.CellValue(i, "vnor_itm_cd") == "OT") {
				sheetObj.CellEditable(i, "vnor_itm_ofc_cd") = true;
			} else {
				sheetObj.CellEditable(i, "vnor_itm_ofc_cd") = false;
			}
		}
		
		sheetObj.CellValue2(i, "ibflag") = "";
	}
}

/**
 * Sub Item File Attach Pop-up Open
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
	
	if (sName == "file_attach") {
		fileUploadPopUp(sheetObj, Row);
	}
}

/**
 * File Upload 팝업 오픈
 */
function fileUploadPopUp(sheetObj, Row) {
	var formObj = document.form;
	var atch_file_lnk_id = "";
	var sParam = "vsl_cd=" + formObj.vsl_cd.value;
	sParam += "&vnor_seq=" + formObj.vnor_seq.value;
	sParam += "&vnor_itm_seq=" + sheetObj.CellValue(Row, "vnor_itm_seq");
	sParam += "&is_upload_possible=" + sheetObj.CellValue(Row, "is_upload_possible");
	if (sheetObj.CellValue(Row, "atch_file_lnk_id") == "") {
		atch_file_lnk_id = "0071_" + ComLpad(sheetObj.CellValue(Row, "vnor_itm_seq"), 5, 0);
		sheetObj.CellValue2(Row, "atch_file_lnk_id") = atch_file_lnk_id;
	} else {
		atch_file_lnk_id =  sheetObj.CellValue(Row, "atch_file_lnk_id");
	}
	sParam += "&atch_file_lnk_id=" + atch_file_lnk_id;
	var fileCount = ComOpenPopupWithTarget('/hanjin/VOP_OPF_0072.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
	sheetObj.CellValue2( Row, "atch_file_knt") = parseInt(fileCount);
}

/**
 * Sub Item Sheet On Change 이벤트 처리
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
	
	// Item이 변경 될 경우 UOM 자동 셋팅
	if (sName == "vnor_itm_cd") {
		var cellValue = sheetObj.CellValue(Row, Col);
		
		if (cellValue == "HF" || cellValue == "MD" || cellValue == "LF" || cellValue == "LD") {
			sheetObj.CellValue2(Row, "vnor_itm_ut_cd") = "T";
			sheetObj.CellEditable(Row, "vnor_itm_ofc_cd") = false;
		} else if (cellValue == "PC" || cellValue == "TC" || cellValue == "OT") {
			sheetObj.CellValue2(Row, "vnor_itm_ut_cd") = "D";
			sheetObj.CellEditable(Row, "vnor_itm_ofc_cd") = true;
		} else {
			sheetObj.CellValue2(Row, "vnor_itm_ut_cd") = " ";
			sheetObj.CellEditable(Row, "vnor_itm_ofc_cd") = false;
		}
	// Office Code 변경 될 경우 정합성 체크
	} else if (sName == "vnor_itm_ofc_cd") {
		var cellValue = sheetObj.CellValue(Row, Col);
		if (cellValue != "") {
			formObj.office_cd.value = cellValue;
			if (!doActionIBSheet(sheetObj, formObj, SEARCH05)) {
				ComShowCodeMessage("OPF50004", cellValue);
				sheetObj.CellValue2(Row, Col) = "";
			}
		}
	}
}

/**
 * Date 유효성 체크
 */
function checkDateFormat(eleObj){
	var check_dt = eleObj.value.trimAll(".").trimAll(":");
	
	if (check_dt.length != 12) {
		return false;
	} else {
		var dt_mm = check_dt.substring(4, 6);
		var dt_dd = check_dt.substring(6, 8);
		var dt_hh = check_dt.substring(8, 10);
		var dt_mi = check_dt.substring(10, 12);
		
		// Month Check
		if (dt_mm < 1 || dt_mm > 12) {
			return false;
		}
		// Day Check
		if (dt_dd < 1 || dt_dd > 31) {
			return false;
		}
		// Hour Check
		if (dt_hh > 24) {
			return false;
		}
		// Minute Check
		if (dt_mi > 59) {
			return false;
		}
		
		eleObj.value = check_dt.substring(0, 4) + "." + check_dt.substring(4, 6) + "." + check_dt.substring(6, 8) + "." + check_dt.substring(8, 10) + ":" + check_dt.substring(10, 12);
		return true;
	}
}

/**
 * Off-Hire Time Value 셋팅
 */
function setOffHireValue() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var timeDiff = 0;
	
	if (from_date != "" && to_date != "") {
	    if (formObj.credit_chk.checked) {
	    	sheetObj.CellValue2(1, "vnor_itm_val") = (from_date - to_date) / 1000 / 60 / 60;
	    } else {
	    	sheetObj.CellValue2(1, "vnor_itm_val") = (to_date - from_date) / 1000 / 60 / 60;
	    }
	}
}

/**
 * 콤보 리스트를 생성한다.
 */
function setCombo(arrCombo, comboObj) {
	if (arrCombo != null) {
		var arrVal  = arrCombo[0].split("|");
		var arrName = arrCombo[1].split("|");
		comboObj.RemoveAll();
		for (var i = 0 ; i < arrVal.length ; i++) {
			comboObj.InsertItem(-1, arrVal[i], arrName[i]);
		}
	}
}

/**
 * Off-Hire Time List 값 변경시 처리
 */
function off_hire_time_list_OnChange() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var selectedOffHireTime = formObj.off_hire_time_list.Code;
	
	formObj.vnor_offh_fm_dt.value = selectedOffHireTime.substring(0,16);
	formObj.vnor_offh_to_dt.value = selectedOffHireTime.substring(17,33);
//	formObj.cr_chk_flg.value = selectedOffHireTime.substring(33,34);
	formObj.vnor_seq.value = selectedOffHireTime.substring(34);
	
	// Type Code 콤보박스 초기화
	formObj.intg_cd_val_ctnt.value = "";
	doActionIBSheet(sheetObj, formObj, SEARCHLIST04);
	
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
}

/**
 * 조회 후 각 항목 수정 가능 여부 셋팅
 */
function setEditableField() {
	var formObj = document.form;
	
	// Status가 Submitted 일 경우
	if (formObj.vnor_stup_sts_cd.Code == "SU") {
		formObj.vsl_cd.readOnly = true;
		formObj.vnor_offh_fm_dt.readOnly = true;
		formObj.vnor_offh_to_dt.readOnly = true;
		formObj.credit_chk.disabled = true;
		formObj.skd_voy_no.readOnly = true;
		formObj.skd_voy_no.className = "input2";
		formObj.vnor_vsl_sts_cd.Enable = false;
		formObj.vnor_fm_port_cd.Enable = false;
		formObj.vnor_to_port_cd.Enable = false
		formObj.vnor_offh_knd_cd.Enable = false;
		formObj.vnor_offh_tp_cd.Enable = false;
		formObj.vnor_rmk.readOnly = true;
		formObj.vnor_rmk.className = "input2";
		
		ComBtnDisable("btn_Delete");
		if (formObj.save_flg.value == "N") {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Submit");
		} else {
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Submit");
		}
	// Status가 Saved 일 경우
	} else if (formObj.vnor_stup_sts_cd.Code == "SA") {
		formObj.vsl_cd.readOnly = true;
		formObj.vnor_offh_fm_dt.readOnly = true;
		formObj.vnor_offh_to_dt.readOnly = true;
		formObj.credit_chk.disabled = true;
		formObj.skd_voy_no.readOnly = false;
		formObj.skd_voy_no.className = "input";
		formObj.vnor_vsl_sts_cd.Enable = true;
		formObj.vnor_fm_port_cd.Enable = true;
		formObj.vnor_offh_knd_cd.Enable = true;
		formObj.vnor_offh_tp_cd.Enable = false;
		formObj.vnor_rmk.readOnly = false;
		formObj.vnor_rmk.className = "input";
		vnor_vsl_sts_cd_OnChange();
		
		ComBtnEnable("btn_Delete");
		if (formObj.save_flg.value == "N") {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Submit");
		} else {
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Submit");
		}
	}
}

/**
 * Vessel Status 값 변경시 처리
 */
function vnor_vsl_sts_cd_OnChange() {
	var formObj = document.form;
	
	if (formObj.vnor_vsl_sts_cd.Code == "SL") {
		formObj.vnor_fm_port_cd.Enable = true;
		formObj.vnor_to_port_cd.Enable = true;
	} else {
		formObj.vnor_fm_port_cd.Enable = true;
		formObj.vnor_to_port_cd.value = "";
		formObj.vnor_to_port_cd.Enable = false;
	}
}

/**
 * Kind 값 변경시 처리
 */
function vnor_offh_knd_cd_OnChange() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
	formObj.intg_cd_val_ctnt.value = formObj.vnor_offh_knd_cd.Code;
	doActionIBSheet(sheetObj, formObj, SEARCHLIST05);
	formObj.vnor_offh_tp_cd.Enable = true;
}

/**
 * From Port 값 변경시 처리
 */
function vnor_fm_port_cd_OnChange(comboObj, Code, Text) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var vsl_cd = formObj.vsl_cd.value;
	var skd_voy_no = formObj.skd_voy_no.value;
	var vnor_fm_port_cd = formObj.vnor_fm_port_cd.Text;
	
	if (vnor_fm_port_cd.length == 0) {
		return false;
	}
	
	if (vsl_cd.length != 4) {
		ComShowCodeMessage("OPF50009", "Vessel");
		formObj.vnor_fm_port_cd.Text2 = "";
		return false;
	}
	
	if (skd_voy_no.length != 5) {
		ComShowCodeMessage("OPF50009", "Voy No");
		formObj.vnor_fm_port_cd.Text2 = "";
		return false;;
	}
	
	if (!doActionIBSheet(sheetObj, formObj, SEARCH03)) { // From Port 가 유효하지 않으면
		ComShowCodeMessage("OPF50004", vnor_fm_port_cd);
		formObj.vnor_fm_port_cd.Text2 = "";
		sheetObjects[1].InitDataCombo(0, "vnor_itm_ofc_cd", "", "");
	} else {
		doActionIBSheet(sheetObj, formObj, SEARCHLIST08);
	}
}

/**
 * To Port 값 변경시 처리
 */
function vnor_to_port_cd_OnChange(comboObj, Code, Text) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var vsl_cd = formObj.vsl_cd.value;
	var skd_voy_no = formObj.skd_voy_no.value;
	var vnor_to_port_cd = formObj.vnor_to_port_cd.Text;
	
	if (vnor_to_port_cd.length == 0) {
		return false;
	}
	
	if (vsl_cd.length != 4) {
		ComShowCodeMessage("OPF50009", "Vessel");
		formObj.vnor_to_port_cd.Text2 = "";
		return false;
	}
	
	if (skd_voy_no.length != 5) {
		ComShowCodeMessage("OPF50009", "Voy No");
		formObj.vnor_to_port_cd.Text2 = "";
		return false;
	}
	
	if (!doActionIBSheet(sheetObj, formObj, SEARCH04)) { // To Port 가 유효하지 않으면
		ComShowCodeMessage("OPF50004", vnor_to_port_cd);
		formObj.vnor_to_port_cd.Text2 = "";
	}
}

function openPicPopup() {
	var sUrl = "/hanjin/VOP_OPF_0074.do";
	ComOpenPopup(sUrl, 1000, 500, "", "0,0", true);
}

function setFromInquiry() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var in_vsl_cd = formObj.in_vsl_cd.value;
	var in_off_hire_time_cd = formObj.in_off_hire_time_cd.value;
	
	if (in_vsl_cd != "" && in_off_hire_time_cd != "") {
		formObj.vsl_cd.value = in_vsl_cd;
		doActionIBSheet(sheetObj, formObj, SEARCHLIST06); // Off-Hire Time List 조회
		formObj.off_hire_time_list.Code = in_off_hire_time_cd;
	}
}

function afterSaveRowCheck() {
	var checkedRowList = checkedRows.split("|");
	
	for (i = 0; i < checkedRowList.length - 1; i++) {
		sheetObjects[1].CellValue(checkedRowList[i], "chk") = "Y";
	}
}

/* 개발자 작업 끝 */