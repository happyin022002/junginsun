/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : VOP_FCM_0002.js
 *@FileTitle : Departure Report Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.01
 *@LastVersion : 1.0
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
 * @class VOP_FCM_0002 : VOP_FCM_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0002() {
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

var fmDtTmp = "";
var toDtTmp = "";
var vslSlanCdTmp = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btns_calendarfm":
				var cal = new ComCalendar();
				cal.select(formObj.fm_dt, 'yyyy-MM-dd');
				break;
			
			case "btns_calendarto":
				var cal = new ComCalendar();
				cal.select(formObj.to_dt, 'yyyy-MM-dd');
				break;
				
			case "btn_last_port":
				doActionIBSheet(sheetObject, formObj ,COMMAND01);
				break;
				
			case "btn_dep_port":
				doActionIBSheet(sheetObject, formObj, COMMAND02);
				break;
				
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
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
	var sheetObj = sheetObjects[0];
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
	initControl();
	
	formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -14);
	fmDtTmp = formObj.fm_dt.value.replace(/-/gi, "");
	formObj.to_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -1);
	toDtTmp = formObj.to_dt.value.replace(/-/gi, "");
	
	processCellHidden();
	
	// 계산 된 값을 표시하는 항목 Header Color 표시
	sheetObj.CellBackColor(1, "pro_pitch") = sheetObj.RgbColor(255, 204, 102);
	sheetObj.CellBackColor(1, "sailing_time") = sheetObj.RgbColor(255, 204, 102);
	sheetObj.CellBackColor(1, "sea_steaming_me") = sheetObj.RgbColor(255, 204, 102);
	sheetObj.CellBackColor(1, "sea_steaming_ttl") = sheetObj.RgbColor(255, 204, 102);
	sheetObj.CellBackColor(1, "harbor_in_port_ttl") = sheetObj.RgbColor(255, 204, 102);
	
	doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 조회
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다.
 */
function initControl() {
	var formObj = document.form;
	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('click', 'obj_click', formObj);
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
	axon_event.addListenerForm('propertychange', 'obj_propertychange', formObj);
}

/**
 * Click 이벤트 처리
 */
function obj_click() {
	var obj = event.srcElement.name;
	
	if (obj == "chk_perfo" || obj == "chk_fuel" || obj == "chk_rob" || obj == "chk_dest" || obj == "chk_time" || obj == "chk_condi") {
		processCellHidden();
	}
}

/**
 * Keypress 이벤트 처리
 */
function obj_keypress() {
	switch(event.srcElement.name){
		case "fm_dt":
		case "to_dt":
			ComKeyOnlyNumber();
			break;
		case "last_port":
		case "dep_port":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * Activate 이벤트 처리
 */
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

/**
 * Deactivate 이벤트 처리
 */
function obj_deactivate() {
	var obj = event.srcElement;
	
	switch(obj.name){
		case "fm_dt":
			fmDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 날짜 유효성 체크
			break;
		case "to_dt":
			toDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 날짜 유효성 체크
			break;
	}
}

/**
 * Propertychange 이벤트 처리
 */
function obj_propertychange(){
	var obj = event.srcElement;
	var formObj = document.form;
	
	if(event.propertyName=="value"){
		switch(obj.name){
			case "fm_dt":
				if(fmDtTmp.length == 8 && obj.value.replace(/-/gi, "").length == 8 && obj.value.replace(/-/gi, "") != fmDtTmp){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 재조회
					vslSlanCdTmp = "";
				} else {
					return false;
				}
				break;
			case "to_dt":
				if(toDtTmp.length == 8 && obj.value.replace(/-/gi, "").length == 8 && obj.value.replace(/-/gi, "") != toDtTmp){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 재조회
					vslSlanCdTmp = "";
				} else {
					return false;
				}
				break;
		}
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
		case "vsl_slan_cd":
			with (comboObj) { 
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 320
				UseAutoComplete = true;
				ValidChar(2, 1); //영문대문자 & 숫자만 입력가능
				MaxLength = 3;
			}
			break;
		case "vsl_cd":
			with (comboObj) { 
				MultiSelect = true;
				MultiSeparator = ",";
				DropHeight = 320;
				UseAutoComplete = true;
				ValidChar(2, 1); //영문대문자 & 숫자만 입력가능
				MaxLength = 4;
			}
			break;
    	case "skd_dir_cd":
    		with (comboObj) { 
				MultiSelect = false;
				DropHeight = 320;
				InsertItem(0, '','');
				InsertItem(1, 'E','E');
				InsertItem(2, 'W','W');
				InsertItem(3, 'S','S');
				InsertItem(4, 'N','N');
				UseAutoComplete = true;
				ValidChar(2, 0); //영문대문자만 입력가능
				MaxLength = 1;
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

	switch (sheetNo) {
	
	case 1:
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
			InitRowInfo(3, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, true, false, false);
			
			var HeadTitle1 = "|vsk_flg|dep_flg|skd_voy_no|skd_dir_cd|clpt_ind_seq|Except|Class|Vessel|Voy No.|Lane|Last Port|Dep Port|PERFORMACE|PERFORMACE|PERFORMACE|PERFORMACE|PERFORMACE|PERFORMACE|PERFORMACE|PERFORMACE"
								+ "|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM"
								+ "|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM"
								+ "|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM"
								+ "|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM"
								+ "|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B"
								+ "|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B"
								+ "|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B"
								+ "|DESTINATION|DESTINATION|DESTINATION|DESTINATION"
								+ "|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME"
								+ "|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO|CONDITION & CARGO";
			var HeadTitle2 = "|vsk_flg|dep_flg|skd_voy_no|skd_dir_cd|clpt_ind_seq|Except|Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|Pro.Pitch|Sailing Time"
								+ "|Sea Steaming\nM/E|Sea Steaming\nTTL|Harbor/In Port\nTTL|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming LS F.O"
								+ "|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Sea Steaming LS D.O"
								+ "|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O"
								+ "|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O"
								+ "|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)"
								+ "|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)"
								+ "|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)"
								+ "|Next Port|ETA|Togo Mile|Togo SPD"
								+ "|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG"
								+ "|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Dep)|Draft(Dep)|Draft(Dep)|Draft(Dep)|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|R/F CNTR|R/F CNTR|R/F CNTR";
			var HeadTitle3 = "|vsk_flg|dep_flg|skd_voy_no|skd_dir_cd|clpt_ind_seq|Except|Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|Pro.Pitch|Sailing Time"
								+ "|Sea Steaming\nM/E|Sea Steaming\nTTL|Harbor/In Port\nTTL|M/E|G/E|BLR|TTL|M/E|G/E|BLR|TTL"
								+ "|M/E|G/E|BLR|TTL|M/E|G/E|BLR|TTL"
								+ "|M/E|G/E|BLR|TTL|M/E|G/E|BLR|TTL"
								+ "|M/E|G/E|BLR|TTL|M/E|G/E|BLR|TTL"
								+ "|F.O|LS F.O|D.O|LS D.O|F.W|B.W|F.O|LS F.O|D.O|LS D.O|F.W|B.W"
								+ "|F.O BDR|F.O Actual|F.O Sulfur|F.O Barge1|F.O Barge2|LS F.O BDR|LS F.O Actual|LS F.O Sulfur|LS F.O Barge1|LS F.O Barge2"
								+ "|D.O BDR|D.O Actual|D.O Sulfur|D.O Barge1|D.O Barge2|LS D.O BDR|LS D.O Actual|LS D.O Sulfur|LS D.O Barge1|LS D.O Barge2"
								+ "|Next Port|ETA|Togo Mile|Togo SPD"
								+ "|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG"
								+ "|FWD|MID|AFT|GM|FWD|MID|AFT|GM|Full|Em'ty|Total|Cargo Weight|Displacement|Disch.|Load|On Board";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 13, 0, false);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	10, 	daCenter, 	false,		"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,		10,		daCenter,		true,		"vsk_flg",									false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		10,		daCenter,		true,		"dep_flg",									false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,		true,		"skd_voy_no",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,		true,		"skd_dir_cd",								false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,		true,		"clpt_ind_seq",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		true,		"avg_expt_flg",							false,	"",	dfNone,		0,	true,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cntr_dzn_capa",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"vsl_cd",									false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"skd_voy_dir",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"vsl_slan_cd",								false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"last_port_cd",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"dep_port_cd",							false,	"",	dfNone,		0,	false,	false);
			
			// PERFORMACE
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"nvgt_ml_dist",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"eng_ml_dist",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"mnvr_in_ml_dist",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"mnvr_out_ml_dist",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"avg_spd",								false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"avg_rpm_pwr",							false,	"",	dfNone,		0,	false,	false);
			// 계산값
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"pro_pitch",								false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		"sailing_time",							false,	"",	dfNone,		0,	false,	false);
			
			// 계산값
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"sea_steaming_me",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"sea_steaming_ttl",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"harbor_in_port_ttl",						false,	"",	dfNone,		0,	false,	false);
			// Sea Steaming F.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_mn_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_gnr_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_blr_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_ttl_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			// Sea Steaming LS F.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_mn_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_gnr_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_blr_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_ttl_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			// Sea Steaming D.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_mn_doil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_gnr_doil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_blr_doil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_ttl_doil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			// Sea Steaming LS D.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_mn_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_gnr_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_blr_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"sea_ttl_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			// Harbor/In Port F.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_mn_foil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_gnr_foil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_blr_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_ttl_foil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			// Harbor/In Port LS F.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_mn_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_gnr_low_sulp_foil_csm_qty",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_blr_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_ttl_low_sulp_foil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			// Harbor/In Port D.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_mn_doil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_gnr_doil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_blr_doil_csm_qty",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_ttl_doil_csm_qty",					false,	"",	dfNone,		0,	false,	false);
			// Harbor/In Port LS D.O
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_mn_low_sulp_doil_csm_qty",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_gnr_low_sulp_doil_csm_qty",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_blr_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"port_ttl_low_sulp_doil_csm_qty",		false,	"",	dfNone,		0,	false,	false);
			
			// Rob(Arr)
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_foil_wgt",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_low_sulp_foil_wgt",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_doil_wgt",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_low_sulp_doil_wgt",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_frsh_wtr_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_blst_wgt",							false,	"",	dfNone,		0,	false,	false);
			// Rob(Dep)
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_foil_wgt",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_low_sulp_foil_wgt",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_doil_wgt",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_low_sulp_doil_wgt",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_frsh_wtr_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_blst_wgt",							false,	"",	dfNone,		0,	false,	false);
			// Rob(Sup)
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_foil_bdr_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_foil_act_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_foil_sulp_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_foil_brg_wgt1",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_foil_brg_wgt2",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_foil_bdr_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_foil_act_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_foil_sulp_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_foil_brg_wgt1",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_foil_brg_wgt2",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_doil_bdr_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_doil_act_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_doil_sulp_wgt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_doil_brg_wgt1",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_doil_brg_wgt2",					false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_doil_bdr_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_doil_act_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_doil_sulp_wgt",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_doil_brg_wgt1",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"spl_low_sulp_doil_brg_wgt2",			false,	"",	dfNone,		0,	false,	false);
			
			// DESTINATION
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"nxt_port_cd",							false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"nxt_port_eta_dt",						false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"rmn_dist",								false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		"rmn_avg_spd",							false,	"",	dfNone,		0,	false,	false);
			
			// TIME
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"sb_eng_dt",								false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"plt_in_dt",								false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"bfr_brth_ank_drp_dt",					false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"bfr_brth_ank_off_dt",					false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"vps_etb_dt",								false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"cgo_wrk_st_dt",							false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"cgo_wrk_end_dt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"vps_etd_dt",								false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"aft_unbrth_ank_drp_dt",				false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"aft_unbrth_ank_off_dt",				false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"plt_out_dt",								false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"rup_dt",									false,	"",	dfNone,		1,	false,	false);
			
			// Draft(Arr)
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_fwddr_hgt",							false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_mid_drft_hgt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_aftdr_hgt",							false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"arr_gm_hgt",							false,	"",	dfNone,		1,	false,	false);
			// Draft(Dep)
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_fwddr_hgt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_mid_drft_hgt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_aftdr_hgt",							false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"dep_gm_hgt",							false,	"",	dfNone,		1,	false,	false);
			// On Board CNTR
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"full_cntr_obrd_teu",					false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"mty_cntr_obrd_teu",					false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"ttl_cntr_obrd_teu",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"dep_cgo_wgt",							false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"dep_dpl_wgt",							false,	"",	dfNone,		1,	false,	false);
			// R/F CNTR
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"rf_cntr_dchg_knt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"rf_cntr_lod_knt",						false,	"",	dfNone,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"rf_cntr_obrd_knt",						false,	"",	dfNone,		1,	false,	false);
		}
		
	break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
		case SEARCH: // 전체 콤보박스 정보 조회
 			ComOpenWait(true);
 			formObj.f_cmd.value = SEARCH;
 			
 			formObj.vsl_slan_cd.removeAll();
 			formObj.vsl_cd.removeAll();
 			
 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0002GS.do", FormQueryString(formObj));
 			var vslSlanCds = (","+ComGetEtcData(sXml, "vsl_slan_cd")).split(",");
 			var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
 			
 			for(var i=0; i<comboObjects.length; i++){
 				if(comboObjects[i].id == "vsl_slan_cd"){
					appendMultiComboItem(comboObjects[i], vslSlanCds, vslSlanCds, "");
				}else if(comboObjects[i].id == "vsl_cd"){
					appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
				}
 			}
 			ComOpenWait(false);
			break;
			
		case SEARCH01: // Vessel 콤보박스 정보 조회
 			ComOpenWait(true);
 			formObj.f_cmd.value = SEARCH;
 			
 			formObj.vsl_cd.removeAll();
 			
 			var sXml = sheetObj.GetSearchXml("VOP_FCM_0002GS.do", FormQueryString(formObj));
 			var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
 			
 			for(var i=0; i<comboObjects.length; i++){
 				if(comboObjects[i].id == "vsl_cd"){
					appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
				}
 			}
 			ComOpenWait(false);
			break;
			
		case COMMAND01: // LAST Port 팝업 오픈
			sUrl = "/hanjin/VOP_VSK_0043.do";
			ComOpenPopup(sUrl, 422, 510, "returnLastPort", "0,0", true);
			break;
			
		case COMMAND02: // DEP Port 팝업 오픈
			sUrl = "/hanjin/VOP_VSK_0043.do";
			ComOpenPopup(sUrl, 422, 510, "returnDepPort", "0,0", true);
			break;
		
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				var sXml = sheetObj.GetSearchXml("VOP_FCM_0002GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
			
		case MULTI: // 업데이트
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var saveStr =sheetObj.GetSaveString(false);
				var sXml = sheetObj.GetSaveXml("VOP_FCM_0002GS.do", saveStr + "&" + FormQueryString(formObj));
				ComOpenWait(false);
				
				if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
					ComShowCodeMessage("COM130102", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch(sAction){
		case IBSEARCH:
			var fmDt = formObj.fm_dt.value;
			var toDt = formObj.to_dt.value;
			
			if (fmDt == "" || toDt == "") {
				ComShowCodeMessage("FCM00006", "Period");
				return false;
			}
			
			var tmpDt = ComGetDateAdd(fmDt, "Y", 1);
			
            if (parseInt(toDt.replace(/-/g, '')) < parseInt(fmDt.replace(/-/g, ''))) {
            	ComShowCodeMessage("COM12133", "To Date", "From Date", "later");
				return false;
			} else {
				if(ComChkPeriod(toDt, tmpDt) == 1){
					return true;
				}else{
					ComShowCodeMessage("FCM00005", "1 year");
					return false;
				}
			}
			break;
			
		case MULTI:
			var updateCnt = 0;
			for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "ibflag") == "U") {
					updateCnt++;
				}
			}
			if (updateCnt == 0) {
				ComShowCodeMessage("FCM00004");
				return false;
			} else {
				return true;
			}
	}
	return true;
}

/**
 * Sheet의 Cell Hidden 여부를 처리
 */
function processCellHidden() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	// PERFORMACE 체크여부
	if (formObj.chk_perfo.checked) {
		sheetObj.ColHidden("nvgt_ml_dist") = false;
		sheetObj.ColHidden("eng_ml_dist") = false;
		sheetObj.ColHidden("mnvr_in_ml_dist") = false;
		sheetObj.ColHidden("mnvr_out_ml_dist") = false;
		sheetObj.ColHidden("avg_spd") = false;
		sheetObj.ColHidden("avg_rpm_pwr") = false;
		sheetObj.ColHidden("pro_pitch") = false;
		sheetObj.ColHidden("sailing_time") = false;
	} else {
		sheetObj.ColHidden("nvgt_ml_dist") = true;
		sheetObj.ColHidden("eng_ml_dist") = true;
		sheetObj.ColHidden("mnvr_in_ml_dist") = true;
		sheetObj.ColHidden("mnvr_out_ml_dist") = true;
		sheetObj.ColHidden("avg_spd") = true;
		sheetObj.ColHidden("avg_rpm_pwr") = true;
		sheetObj.ColHidden("pro_pitch") = true;
		sheetObj.ColHidden("sailing_time") = true;
	}
	
	// FUEL CONSUM 체크여부
	if (formObj.chk_fuel.checked) {
		sheetObj.ColHidden("sea_steaming_me") = false;
		sheetObj.ColHidden("sea_steaming_ttl") = false;
		sheetObj.ColHidden("harbor_in_port_ttl") = false;
		sheetObj.ColHidden("sea_mn_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_gnr_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_blr_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_ttl_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_mn_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_gnr_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_blr_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_ttl_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("sea_mn_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_gnr_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_blr_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_ttl_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_mn_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_gnr_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_blr_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("sea_ttl_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("port_mn_foil_csm_qty") = false;
		sheetObj.ColHidden("port_gnr_foil_csm_qty") = false;
		sheetObj.ColHidden("port_blr_foil_csm_qty") = false;
		sheetObj.ColHidden("port_ttl_foil_csm_qty") = false;
		sheetObj.ColHidden("port_mn_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("port_gnr_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("port_blr_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("port_ttl_low_sulp_foil_csm_qty") = false;
		sheetObj.ColHidden("port_mn_doil_csm_qty") = false;
		sheetObj.ColHidden("port_gnr_doil_csm_qty") = false;
		sheetObj.ColHidden("port_blr_doil_csm_qty") = false;
		sheetObj.ColHidden("port_ttl_doil_csm_qty") = false;
		sheetObj.ColHidden("port_mn_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("port_gnr_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("port_blr_low_sulp_doil_csm_qty") = false;
		sheetObj.ColHidden("port_ttl_low_sulp_doil_csm_qty") = false;
	} else {
		sheetObj.ColHidden("sea_steaming_me") = true;
		sheetObj.ColHidden("sea_steaming_ttl") = true;
		sheetObj.ColHidden("harbor_in_port_ttl") = true;
		sheetObj.ColHidden("sea_mn_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_gnr_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_blr_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_ttl_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_mn_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_gnr_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_blr_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_ttl_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("sea_mn_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_gnr_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_blr_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_ttl_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_mn_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_gnr_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_blr_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("sea_ttl_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("port_mn_foil_csm_qty") = true;
		sheetObj.ColHidden("port_gnr_foil_csm_qty") = true;
		sheetObj.ColHidden("port_blr_foil_csm_qty") = true;
		sheetObj.ColHidden("port_ttl_foil_csm_qty") = true;
		sheetObj.ColHidden("port_mn_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("port_gnr_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("port_blr_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("port_ttl_low_sulp_foil_csm_qty") = true;
		sheetObj.ColHidden("port_mn_doil_csm_qty") = true;
		sheetObj.ColHidden("port_gnr_doil_csm_qty") = true;
		sheetObj.ColHidden("port_blr_doil_csm_qty") = true;
		sheetObj.ColHidden("port_ttl_doil_csm_qty") = true;
		sheetObj.ColHidden("port_mn_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("port_gnr_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("port_blr_low_sulp_doil_csm_qty") = true;
		sheetObj.ColHidden("port_ttl_low_sulp_doil_csm_qty") = true;
	}
	
	// R.O.B 체크여부
	if (formObj.chk_rob.checked) {
		sheetObj.ColHidden("arr_foil_wgt") = false;
		sheetObj.ColHidden("arr_low_sulp_foil_wgt") = false;
		sheetObj.ColHidden("arr_doil_wgt") = false;
		sheetObj.ColHidden("arr_low_sulp_doil_wgt") = false;
		sheetObj.ColHidden("arr_frsh_wtr_wgt") = false;
		sheetObj.ColHidden("arr_blst_wgt") = false;
		sheetObj.ColHidden("dep_foil_wgt") = false;
		sheetObj.ColHidden("dep_low_sulp_foil_wgt") = false;
		sheetObj.ColHidden("dep_doil_wgt") = false;
		sheetObj.ColHidden("dep_low_sulp_doil_wgt") = false;
		sheetObj.ColHidden("dep_frsh_wtr_wgt") = false;
		sheetObj.ColHidden("dep_blst_wgt") = false;
		sheetObj.ColHidden("spl_foil_bdr_wgt") = false;
		sheetObj.ColHidden("spl_foil_act_wgt") = false;
		sheetObj.ColHidden("spl_foil_sulp_wgt") = false;
		sheetObj.ColHidden("spl_foil_brg_wgt1") = false;
		sheetObj.ColHidden("spl_foil_brg_wgt2") = false;
		sheetObj.ColHidden("spl_low_sulp_foil_bdr_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_foil_act_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_foil_sulp_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_foil_brg_wgt1") = false;
		sheetObj.ColHidden("spl_low_sulp_foil_brg_wgt2") = false;
		sheetObj.ColHidden("spl_doil_bdr_wgt") = false;
		sheetObj.ColHidden("spl_doil_act_wgt") = false;
		sheetObj.ColHidden("spl_doil_sulp_wgt") = false;
		sheetObj.ColHidden("spl_doil_brg_wgt1") = false;
		sheetObj.ColHidden("spl_doil_brg_wgt2") = false;
		sheetObj.ColHidden("spl_low_sulp_doil_bdr_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_doil_act_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_doil_sulp_wgt") = false;
		sheetObj.ColHidden("spl_low_sulp_doil_brg_wgt1") = false;
		sheetObj.ColHidden("spl_low_sulp_doil_brg_wgt2") = false;
	} else {
		sheetObj.ColHidden("arr_foil_wgt") = true;
		sheetObj.ColHidden("arr_low_sulp_foil_wgt") = true;
		sheetObj.ColHidden("arr_doil_wgt") = true;
		sheetObj.ColHidden("arr_low_sulp_doil_wgt") = true;
		sheetObj.ColHidden("arr_frsh_wtr_wgt") = true;
		sheetObj.ColHidden("arr_blst_wgt") = true;
		sheetObj.ColHidden("dep_foil_wgt") = true;
		sheetObj.ColHidden("dep_low_sulp_foil_wgt") = true;
		sheetObj.ColHidden("dep_doil_wgt") = true;
		sheetObj.ColHidden("dep_low_sulp_doil_wgt") = true;
		sheetObj.ColHidden("dep_frsh_wtr_wgt") = true;
		sheetObj.ColHidden("dep_blst_wgt") = true;
		sheetObj.ColHidden("spl_foil_bdr_wgt") = true;
		sheetObj.ColHidden("spl_foil_act_wgt") = true;
		sheetObj.ColHidden("spl_foil_sulp_wgt") = true;
		sheetObj.ColHidden("spl_foil_brg_wgt1") = true;
		sheetObj.ColHidden("spl_foil_brg_wgt2") = true;
		sheetObj.ColHidden("spl_low_sulp_foil_bdr_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_foil_act_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_foil_sulp_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_foil_brg_wgt1") = true;
		sheetObj.ColHidden("spl_low_sulp_foil_brg_wgt2") = true;
		sheetObj.ColHidden("spl_doil_bdr_wgt") = true;
		sheetObj.ColHidden("spl_doil_act_wgt") = true;
		sheetObj.ColHidden("spl_doil_sulp_wgt") = true;
		sheetObj.ColHidden("spl_doil_brg_wgt1") = true;
		sheetObj.ColHidden("spl_doil_brg_wgt2") = true;
		sheetObj.ColHidden("spl_low_sulp_doil_bdr_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_doil_act_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_doil_sulp_wgt") = true;
		sheetObj.ColHidden("spl_low_sulp_doil_brg_wgt1") = true;
		sheetObj.ColHidden("spl_low_sulp_doil_brg_wgt2") = true;
	}
	
	// DESTINATION 체크여부
	if (formObj.chk_dest.checked) {
		sheetObj.ColHidden("nxt_port_cd") = false;
		sheetObj.ColHidden("nxt_port_eta_dt") = false;
		sheetObj.ColHidden("rmn_dist") = false;
		sheetObj.ColHidden("rmn_avg_spd") = false;
	} else {
		sheetObj.ColHidden("nxt_port_cd") = true;
		sheetObj.ColHidden("nxt_port_eta_dt") = true;
		sheetObj.ColHidden("rmn_dist") = true;
		sheetObj.ColHidden("rmn_avg_spd") = true;
	}
	
	// TIME 체크여부
	if (formObj.chk_time.checked) {
		sheetObj.ColHidden("sb_eng_dt") = false;
		sheetObj.ColHidden("plt_in_dt") = false;
		sheetObj.ColHidden("bfr_brth_ank_drp_dt") = false;
		sheetObj.ColHidden("bfr_brth_ank_off_dt") = false;
		sheetObj.ColHidden("vps_etb_dt") = false;
		sheetObj.ColHidden("cgo_wrk_st_dt") = false;
		sheetObj.ColHidden("cgo_wrk_end_dt") = false;
		sheetObj.ColHidden("vps_etd_dt") = false;
		sheetObj.ColHidden("aft_unbrth_ank_drp_dt") = false;
		sheetObj.ColHidden("aft_unbrth_ank_off_dt") = false;
		sheetObj.ColHidden("plt_out_dt") = false;
		sheetObj.ColHidden("rup_dt") = false;
	} else {
		sheetObj.ColHidden("sb_eng_dt") = true;
		sheetObj.ColHidden("plt_in_dt") = true;
		sheetObj.ColHidden("bfr_brth_ank_drp_dt") = true;
		sheetObj.ColHidden("bfr_brth_ank_off_dt") = true;
		sheetObj.ColHidden("vps_etb_dt") = true;
		sheetObj.ColHidden("cgo_wrk_st_dt") = true;
		sheetObj.ColHidden("cgo_wrk_end_dt") = true;
		sheetObj.ColHidden("vps_etd_dt") = true;
		sheetObj.ColHidden("aft_unbrth_ank_drp_dt") = true;
		sheetObj.ColHidden("aft_unbrth_ank_off_dt") = true;
		sheetObj.ColHidden("plt_out_dt") = true;
		sheetObj.ColHidden("rup_dt") = true;
	}
	
	// CONDITION & CARGO 체크여부
	if (formObj.chk_condi.checked) {
		sheetObj.ColHidden("arr_fwddr_hgt") = false;
		sheetObj.ColHidden("arr_mid_drft_hgt") = false;
		sheetObj.ColHidden("arr_aftdr_hgt") = false;
		sheetObj.ColHidden("arr_gm_hgt") = false;
		sheetObj.ColHidden("dep_fwddr_hgt") = false;
		sheetObj.ColHidden("dep_mid_drft_hgt") = false;
		sheetObj.ColHidden("dep_aftdr_hgt") = false;
		sheetObj.ColHidden("dep_gm_hgt") = false;
		sheetObj.ColHidden("full_cntr_obrd_teu") = false;
		sheetObj.ColHidden("mty_cntr_obrd_teu") = false;
		sheetObj.ColHidden("ttl_cntr_obrd_teu") = false;
		sheetObj.ColHidden("dep_cgo_wgt") = false;
		sheetObj.ColHidden("dep_dpl_wgt") = false;
		sheetObj.ColHidden("rf_cntr_dchg_knt") = false;
		sheetObj.ColHidden("rf_cntr_lod_knt") = false;
		sheetObj.ColHidden("rf_cntr_obrd_knt") = false;
	} else {
		sheetObj.ColHidden("arr_fwddr_hgt") = true;
		sheetObj.ColHidden("arr_mid_drft_hgt") = true;
		sheetObj.ColHidden("arr_aftdr_hgt") = true;
		sheetObj.ColHidden("arr_gm_hgt") = true;
		sheetObj.ColHidden("dep_fwddr_hgt") = true;
		sheetObj.ColHidden("dep_mid_drft_hgt") = true;
		sheetObj.ColHidden("dep_aftdr_hgt") = true;
		sheetObj.ColHidden("dep_gm_hgt") = true;
		sheetObj.ColHidden("full_cntr_obrd_teu") = true;
		sheetObj.ColHidden("mty_cntr_obrd_teu") = true;
		sheetObj.ColHidden("ttl_cntr_obrd_teu") = true;
		sheetObj.ColHidden("dep_cgo_wgt") = true;
		sheetObj.ColHidden("dep_dpl_wgt") = true;
		sheetObj.ColHidden("rf_cntr_dchg_knt") = true;
		sheetObj.ColHidden("rf_cntr_lod_knt") = true;
		sheetObj.ColHidden("rf_cntr_obrd_knt") = true;
	}
}

/**
 * LAST Port 팝업 후 처리
 */
function returnLastPort(rtnObjs) {
	var formObj = document.form;
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.last_port.value = rtnDatas[2];
			}
		}
	}
}

/**
 * DEP Port 팝업 후 처리
 */
function returnDepPort(rtnObjs) {
	var formObj = document.form;
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.dep_port.value = rtnDatas[2];
			}
		}
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

/**
 * Lane 콤보박스 CheckClick 이벤트 처리
 */
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

/**
 * Vessel 콤보박스 CheckClick 이벤트 처리
 */
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

/**
 * Lane 콤보박스 OnBlur 이벤트 처리
 */
function vsl_slan_cd_OnBlur(){
	var formObj = document.form;
	var tmpComboTxt = comboObjects[0].Text();
	
	if (vslSlanCdTmp != tmpComboTxt) {
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01); // Vessel 콤보박스 정보 조회
	}
	
	vslSlanCdTmp = tmpComboTxt;
}

/**
 * Sheet1의 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
		// Departure Report 에 존재하지 않는 데이터인 경우에는 Except 체크박스 비활성화 처리
		if (sheetObj.CellValue(i, "dep_flg") == "N") {
			sheetObj.CellEditable(i, "avg_expt_flg") = false;
		}
		// Departure Report 에만 존재하는 데이터인 경우에는 Row Color 처리
		if (sheetObj.CellValue(i, "vsk_flg") == "N") {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 165);
		}
		sheetObj.CellBackColor(i, "dep_port_cd") = sheetObj.RgbColor(195,195,195);
	}
}

/**
 * Row 더블클릭 시 정보를 수정 할 수 있도록 Item Cleansing 팝업을 Open 한다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
	var vskFlg = sheetObj.CellValue(row, "vsk_flg");
	var depFlg = sheetObj.CellValue(row, "dep_flg");
 	var sParam = Array();
 	var idx = 0;
	
	if (vskFlg == "Y" && depFlg == "Y") {
	 	sParam[idx++] = "vvd="				+ sheetObj.CellValue(row, "vsl_cd") + sheetObj.CellValue(row, "skd_voy_dir");
	 	sParam[idx++] = "dep_port_cd="		+ sheetObj.CellValue(row, "dep_port_cd");
	 	sParam[idx++] = "clpt_ind_seq="		+ sheetObj.CellValue(row, "clpt_ind_seq"); //dep_port_cd, mss_port_cd
	 	sParam[idx++] = "call_ui_id=VOP_FCM_0002";
	 	
	 	var theURL = "VOP_FCM_0004.do?"+sParam.join("&");
	 	var winName = "VOP_FCM_0004";
	 	var features = "scroll:no;status:no;resizable=no;help:no;dialogWidth:1500px;dialogHeight:650px";
	 	ComOpenWindow(theURL,winName,features,true);
	 	
	 	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
}

/* 개발자 작업 끝 */