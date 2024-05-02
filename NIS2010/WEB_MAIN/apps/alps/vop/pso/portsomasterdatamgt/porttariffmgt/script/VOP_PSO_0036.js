/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0036.js
 *@FileTitle : Port Tariff
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.28
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.07.28 김진일
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
 * 2011.07.28 김기종 CHM-201112475-01 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
 * 2011.09.16 표준희 CHM-201113366-01 [PSO] Port Tariff Inquiry UI 변경  요청건
 * 2013.11.18 S.K.Y CHM-201327648 Surcharge, dicount  포함 account code 붉은색으로 표시
 * 2014.07.07 이성훈 CHM-201430928 두개의 Effective 조회 시 최신의 Effective 를 가지는 것을 우선적으로 조회
 * 2014.07.16 이성훈 CHM-201430928    Port Tariff Contract 및 URL 저장 
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
 * @class VOP_PSO_0036 : VOP_PSO_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0036() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.setComboObject 		= setComboObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var gColumnCountInSheet6 = 0;	//sheet6의 Column Count

var updatedBys = new Array();
var updatedDates = new Array();
var urls = new Array();
var remarks = new Array();
var ydChgNos = new Array();
var contracts = new Array();
var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
//var mode = "1";	//[2009.11.02:jmh]
var HEIGHT_SHEET6 = 220;
var HEIGHT_SHEET7 = 125;

var myDiv0211 	 = "";
var myDiv0212 	 = "";
var tmpTml = "";

//Account Code 임시저장 Array
var acctCdDpTmp = "";
var acctCdNmTmp = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_port_cd":
			var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
			if(rVal){
				formObject.port_cd.value = rVal;
				loadTerminal();
				ComSetFocus(formObject.comboTerminalCd);
			}
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;

		case "btn_New":
			clearCondition(document.form);
			break;

		case "btn1_Tariff_Update":
			moveToUpdate(sheetObjects[0]);
			break;

		// ======================================================================================================
		// 수정일자 : 2014.07.07
		// 수정내용 : Contract/Regulation 필드 추가
		// ======================================================================================================
		case "btn_cntr_cd":
			var param  = "yd_chg_no=" + sheetObject1.UrlEncoding(ComGetObjValue(formObject.yd_chg_no));
	            param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[3].Code);	// comboObjects[3] -> 4 으로 변경완료
	            param += "&caller=" + "0036";
			ComOpenPopup("VOP_PSO_0041.do?" + param, 422, 530, "setContract", "1,0,1,1,1,1,1", false);
			break;				
		// ======================================================================================================

		// ======================================================================================================
		// 수정일자 : 2014.07.07
		// 수정내용 : Remark 필드 추가
		// ======================================================================================================
		case "btn_port_trf_rmk":
			// 화면에서 직접 remark 를 팝업화면으로 전달하다가, 
			// 추가변경요청으로 size 가 4000byte까지 늘어나면서(약 3800 character 을 초과하면서) ibsheet 에서 에러가 발생됨
			// remark 팝업화면에서 조회를 통해서 가져오도록 수정함. 2014.08.06			
			var param  = "yd_chg_no=" + sheetObject1.UrlEncoding(ComGetObjValue(formObject.yd_chg_no));
            	param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[3].Code);	// comboObjects[3] -> 4 으로 변경완료
    			param += "&caller=" + "0036";
			ComOpenPopup("VOP_PSO_0042.do?" + param, 422, 350, "setPortTrfRmk", "1,0,1,1,1,1,1", true);
			break;				
		// ======================================================================================================		
			
		// ======================================================================================================
		// 수정일자 : 2014.07.22
		// 수정내용 : URL 필드 추가
		// ======================================================================================================
		case "btn_url":
				var sUrl = ComGetObjValue(formObject.port_trf_url);
				if (sUrl != "") {
					window.open(sUrl, "trfUrl", "width=800, height=700, toolbar=no, menubar=no, scrollbars=yes, resizable=yes");
				}
			break;				
		// ======================================================================================================				
			
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Tariff Update를 위한 화면으로 화면을 이동한다. 
 * @param mode ( 1 : 단순 Tariff의 경우 0002화면으로 이동, 2: 복잡 Tariff의 경우 004화면으로 이동 
 */
function moveToUpdate(sheetObj){
	var formObj = document.form;

	if(sheetObj == "" || sheetObj == "undefined"){
		return;
	}	
	var mode = sheetObj.CellValue(sheetObjects[0].SelectRow, "sheet_upd_mnu_no");

	var params  = "moved_from=0036";
	params += "&moved_params=";	
	params += "port_cd::" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_yd_cd").substring(0, 5));
	params += "||" + "ver_seq::" + sheetObjects[0].UrlEncoding(formObj.comboVer.Code);
	params += "||" + "yd_cd::" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_yd_cd").substring(5));
	params += "||" + "acct_cd::" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_acct_cd")); 
	params += "||" + "cost_cd::" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_lgs_cost_cd")); 
	params += "||" + "vndr_seq::" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_vndr_seq"));
	params += "||" + "from_date::" + sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(0,10));
	params += "||" + "to_date::" + sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(11));
	params += "||" + "year::" + sheetObjects[0].UrlEncoding(formObj.year.value);	
	
	if(mode == "1"){
		params += "&pgmNo=VOP_PSO_0002";
		this.location = "/hanjin/VOP_PSO_0002.do" + "?" + params;
	} else if(mode == "2"){
		params += "&pgmNo=VOP_PSO_0004";
		this.location = "/hanjin/VOP_PSO_0004.do" + "?" + params;
	}
}

/**
 * New Button 클릭 시 조건 초기화 처리
 * @param formObj
 * @return
 */
function clearCondition(formObj, option){
	//ComboObject Clear
	for(var k=0;k<comboObjects.length;k++){
		comboObjects[k].RemoveAll();
	}

	if(option == undefined || option == ""){
		//Form 필드 클리어 
		formObj.reset();
		//현재 날짜 셋팅.
		setToday(formObj.year, "y");

		//port_cd에 포커스 ..
		formObj.port_cd.focus();
	}

	formObj.eff_dt.value = "";

	myDiv0211.style.display = "inline";
	myDiv0212.style.display = "none";
	sheetObjects[0].RemoveAll();
	f_RemoveSheets();
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
	initControl(); 
	// VSK 화면에서   Port Tariff Inquiry 화면 Pop-up 사용 처리 로직
    if (document.form.popup_flg.value =='Y') { //PopUp으로 호출되었으면
	 
    	var formObj = document.form;
    	formObj.port_cd.value = formObj.pop_port_cd.value;

    	setTmpTmlCd();
            
    	ComBtnDisable("btn1_Tariff_Update");

    }
  	myDiv0211 	 = document.getElementById("myDiv0211");
	myDiv0212 	 = document.getElementById("myDiv0212");
	
	port_accout_set();
}
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form
	var comboId = comboObj.id;
	switch(comboId) {  
		case "comboTerminalCd":	
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("40|300");
				DropHeight = 190;
				ValidChar(2,3);	//영문대문자,숫자+특수문자
			}
	
			break;
		case "comboLgsCostCd":	
		case "comboVer":	
			comboObj.UseCode = true;
			break;
		case "acct_cd":		//Account 
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
				MaxLength = 6;
			}
			break; 			
	} 
}

/**
 * Control 초기화 처리 
 * @return
 */
function initControl(){
	var formObj = document.form;
	setToday(formObj.year, "y");
	axon_event.addListener('keydown', 'obj_keydown', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('paste', 'obj_paste', form);
	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
}

/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_keydown(){
	ComKeyEnter();
}

function obj_change(){
	var formObject = document.form;
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	var sheetObj = sheetObjects[0];
	/*******************************************************/

	var srcName = window.event.srcElement.getAttribute("name");
	switch(srcName) {

	case "vsl_cd":
		break;

	case "year":
		if(validateForm(sheetObj, formObject, "port_cd_change")){
			clearCondition(formObject, "data");
			loadTerminal();
			loadAccount();
		}
		break;
	case "port_cd":
		/*
		 * 1. Lane Code 3자리 이하이면 null처리.
		 * 2. 3자리 이상이면 SC를 호출
		 */
		 
		if(validateForm(sheetObj, formObject, "port_cd_change")){
			clearCondition(formObject, "data");
			loadTerminal();
			ComSetFocus(formObject.comboTerminalCd);
			loadAccount();
			//comboObjects[0].focus();
		}

		isRmkModFlg = "Y";

		break;

	case "pf_svc_tp_cd":
	case "skd_rmk":
		isRmkModFlg = "Y";
		break;
	} 

}

function port_accout_set(){
	var formObject = document.form;
	var sheetObj = sheetObjects[0];

	if(validateForm(sheetObj, formObject, "port_cd_change")){
		clearCondition(formObject, "data");
		loadTerminal();
		ComSetFocus(formObject.comboTerminalCd);
		loadAccount();
		formObject.comboTerminalCd.code2 = formObject.param_terminal_cd.value;
		formObject.acct_cd.code2 = formObject.param_acct_cd.value;
		
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	}
	isRmkModFlg = "Y";
}

function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;

	switch (eleObj.name) {
	case "port_cd":
		if(eleObj.value.length == 5){
			ComSetFocus(formObj.comboTerminalCd);
//			comboObjects[0].focus();
		}
		break; 
	}
}

function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");		//영문대문자
			break;	
			
		case "year":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;				
	}
}

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */ 
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
	case "y": 
	case "ym": 
	case "ymd":
		ComKeyOnlyNumber(obj);
		break;
	case "num":
		if(obj.name=="vndr_seq"){
			ComKeyOnlyNumber(obj,",");
		} else {
			ComKeyOnlyNumber(obj);
		}
		break;
	case "eng":
		ComKeyOnlyAlphabet(); 
		break;
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	case "uppernum":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}
}

function loadTerminal(code) {
	var formObject = document.form;
	doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,formObject.comboTerminalCd,COMMAND01,LANE,code);
}
function loadAccount(code) {
	var formObject = document.form;
	doActionIBCombo(sheetObjects[0],formObject,COMMAND01,formObject.acct_cd,COMMAND01,"accountAndCost",code);
	for(var i = 0; i < comboObjects[1].GetCount(); i++){
//		acctCdTmp[i] = formObject.acct_cd.GetIndexText(i, 0);
		acctCdNmTmp[i] = formObject.acct_cd.GetIndexText(i, 1);
	}
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH: 
			if(validateForm(sheetObj,formObj,sAction)){
				if (sheetObj.id == "sheet1") {		
					//콤보필드를 초기화시킨다.
					comboObjects[0].RemoveAll();
					comboObjects[1].RemoveAll();
					comboObjects[2].RemoveAll();
					formObj.updated_by.value = "";
					formObj.updated_date.value = "";
	
					//SheetObject Clear
					for(i=0;i<sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}	
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
					var comboData = ComGetEtcData(sXml, sComboKey);
	
					var comboItems = null;
					if(comboData != null && comboData != ""){
						comboItems = comboData.split(ROWMARK);
						//addComboItem(comboObjects[0],comboItems);	//Origin
						addComboItem(formObj.comboTerminalCd,comboItems, 3);
					} else{//검색된 데이터가 없는 경우 
						formObj.port_cd.value = "";
						ComSetFocus(formObj.port_cd);
					}
				}
			}
			break;
		case COMMAND01:     // Account Combo
			formObj.f_cmd.value = sAction;
			formObj.yd_cd.value = formObj.port_cd.value + formObj.comboTerminalCd.Code;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0036GS.do", FormQueryString(formObj) );
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) 
            	ComXml2ComboItem(arrXml[0], formObj.acct_cd, "acct_cd", "acct_cd|acct_nm");
			
			formObj.acct_cd.InsertItem(0, "All|" , "All");
			ComSetObjValue(formObj.acct_cd,"All");
			break;
	}
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems, mode) {
	comboObj.Index2 = -1;
	comboObj.RemoveAll();
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		if(mode == 1){
			comboObj.InsertItem(i, comboItem[0], comboItem[2]);
			
			//Update By 와 Update Date의 정보를 전역변수에 담는다.
			updatedBys[i] = comboItem[3];
			updatedDates[i] = comboItem[4];

			// URL 와 Remark정보를 전역변수에 담는다.
			urls[i] = comboItem[5];
			// ==========================================================================================
			// 필드구분자로 ',' 를 사용하기 때문에, Remark 에 ',' 를 사용할 경우 오류가 발생됨.
			// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
			// ==========================================================================================				
			var portTrfRmk = comboItem[6];
			if (portTrfRmk.indexOf("^") > -1) {
				portTrfRmk = portTrfRmk.split("^").join(",");
			}
			//===========================================================================================			
			remarks[i] = portTrfRmk
			
			// Contract/Regulation
			// ==========================================================================================
			// 필드구분자로 ',' 를 사용하기 때문에, 파일명 구분자에 ',' 를 사용할 경우 오류가 발생됨.
			// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
			// ==========================================================================================				
			var contract = comboItem[7];
			if (contract.indexOf("^") > -1) {
				contract = contract.split("^").join(",");
			}
			//===========================================================================================
			contracts[i] = contract;
			
			// YD_CHG_NO 정보를 전역변수에 담는다.
			ydChgNos[i] = comboItem[1];
		} else if(mode == 0){
			comboObj.InsertItem(i, comboItem[0], comboItem[1]);
		} else{
			comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
			var tem = document.form.pop_btn_port_cd.value;
			if(comboItem[0] == tem){
				tmpTml = i;
			}
		}
		
	}   		
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	 
	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 530;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|Terminal\nCode|Account\nCode|Cost\nCode|Curr\nCode|Service Provider|Service Provider|hmnuno|row_cnt|ver";
			var HeadTitle2 = "|Terminal\nCode|Account\nCode|Cost\nCode|Curr\nCode|No.|Name|hmnuno|row_cnt|ver";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			

			var prefix = "sheet_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"yd_cd",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			53,		daCenter,	true,	prefix+"acct_cd",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"lgs_cost_cd",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			38,		daCenter,	true,	prefix+"curr_cd",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"vndr_seq",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,	prefix+"vndr_abbr_nm",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	prefix+"upd_mnu_no",			false,		"",			dfNone);
	    	InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	prefix+"sd_rw_cnt",			false,		"",			dfNone);
	    	InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	prefix+"yd_chg_ver_seq",			false,		"",			dfNone);
			
            
			CountPosition = 0;
//			sheet1.RowBackColor(4) = mySheet.RgbColor(192,192,192);

		}
		break;

	case "sheet2":
		
		with (sheetObj) {
			// 높이 설정
			style.height = 142;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Regular\nvalue|Formula Condition|Formula Condition|||Compulsory";
			var HeadTitle2 = "Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|Regular\nvalue|ID|Description|||Compulsory";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet1_";
            
			//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix+"seq"			);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"object_dsp"		);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"object_code_dsp"	);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",	    false,		"",			dfNone,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,				0,		false, 	false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"regular_value", false,		"",			dfNumber,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			30,		daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cpls_flg");

			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Range2\tRange Rate Only|Fixed\tObject X Fixed Rate" , "R|S|F", "", "R");
			CountPosition = 0;
			ShowButtonImage = 1;
     
		}
		
		break;

	case "sheet3":
		with (sheetObj) {

			// 높이 설정
			style.height = 102;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|SUM.Option";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet2_";

			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,	prefix+"rate_value",		false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"foml_desc",		false,	"",	dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"sum_option");

			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			ShowButtonImage = 1;
		}
		break;

	case "sheet4":
		with (sheetObj) {

			// 높이 설정
			style.height = 124;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|SUM.Option";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet3_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCombo,60,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,	60,		daRight,	true,	prefix+"rate_value",	false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,	150,	daLeft,		true,	prefix+"foml_desc",		false,		"",			dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,	prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,	150,	daLeft,		true,	prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtCombo,60,		daCenter,	true,	prefix+"sum_option");

			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			ShowButtonImage = 1;
		}
		break;	


	case "sheet5":
		with (sheetObj) {
			// 높이 설정
			style.height = 125;
			
			MultiSelection = false;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|D/F|Formula|Formula|Condition|Condition|Compulsory|UK";
			var HeadTitle2 = "|D/F|ID|DESC|ID|DESC|Compulsory|UK";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHidden	  ,	30,		daCenter,	true,		prefix+"seq" );
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"default2",   	false,	"",			dfNone,			0,		true,  true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtPopup,		110,	daCenter,	true,		prefix+"formula_no",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"foml_desc",  	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtPopup,		100,	daCenter,	true,		prefix+"condition",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daLeft,		true,		prefix+"cond_desc",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"cpls_flg");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"uk",   			false,	"",			dfNone,			0,		false, false);	//Unique, Hidden

			CountPosition = 0;
			ShowButtonImage = 1;
		}
		break;

	case "sheet6":
		with (sheetObj) {
			// 높이 설정
			style.height = HEIGHT_SHEET6;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
			var HeadTitle2 = "Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
			var headCount = ComCountHeadTitle(HeadTitle1);
			gColumnCountInSheet6 = headCount;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet2_";

			//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"seq", 			false,		"",			dfNone,		0,		false,		false			);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"object_dsp"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"object_code_dsp");
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,	4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",		false,		"",			dfNone,	4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,		0,		false, 		false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	true,		prefix+"cond_desc",  	false,		"",			dfNone,		0,		false, 		false, 		15);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix+"cons_als_nm",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"uk",			false,		"",			dfNumber,	4,		true,  		true, 		14);	//Unique, Hidden	

			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Fixed\tObject X Fixed Rate" , "R|F", "", "R");
			CountPosition = 0;
			//PopupImage  =  "img/btng_condition.gif";

			ShowButtonImage = 1;

		}
		break;

	case "sheet7":				//Ragular Value
		with (sheetObj) {
			// 높이 설정
			style.height = HEIGHT_SHEET7;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Regular value|Regular value|Regular value";
			var HeadTitle2 = "Object|UOM|Value";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet3_";

			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		160,	daCenter,	true,		prefix+"pso_obj_cd_dsp");
			InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		prefix+"pso_meas_ut_cd_dsp", 	false,		"",			dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		prefix+"regular_value",			false,		"",			dfNumber,	4,		true,  		true, 		14);

			CountPosition = 0;
		}
		break;

	case "sheet8":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|SUM.Option";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet4_";

			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,	prefix+"rate_value",	false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"foml_desc",		false,		"",			dfNone,				0,		false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"sum_option");

			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			ShowButtonImage = 1;
		}
		break;

	case "sheet9":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|SUM.Option";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet5_";

			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,	prefix+"rate_value",	false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"foml_desc",		false,		"",			dfNone,				0,		false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	true,	prefix+"sum_option");

			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			CountPosition = 0;

			ShowButtonImage = 1;
		}
		break;

	case "sheet10":		//Base Dummy
	with (sheetObj) {
		// 높이 설정
		style.height = 212;

		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);

		var HeadTitle1 = "Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		var HeadTitle2 = "Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
		InitHeadMode(false, false, true, true, false, false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		var prefix = "sheet6_";

		//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"seq", 			false,		"",			dfNone,				0,		false,	false			);
		InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"object_dsp"		);
		InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"object_code_dsp"	);
		InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"rate_code"		);
		InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,	4,		true,  		true, 		14);
		InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",		false,		"",			dfNone,	4,		true,  		true, 		14);
		InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,		0,		false, 		false, 		3 );
		InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
		InitDataProperty(0, cnt++ , dtPopup,		100,	daCenter,	true,		prefix+"condition",		false);
		InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		prefix+"cond_desc",  	false,		"",			dfNone,		0,		false, 		false, 		15);
		InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"object_name");
		InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"uom");
		InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix+"cons_als_nm",	false,	"",			dfNone,			0,		true,  true);
		InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"uk",			false,		"",			dfNumber,	4,		true,  		true, 		14);	//Unique, Hidden	

		InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Fixed\tObject X Fixed Rate" , "R|F", "", "R");
		CountPosition = 0;
		//PopupImage  =  "img/btng_condition.gif";

		ShowButtonImage = 1;

	}
	break;	

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
    
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;//PortCharge List 조회 
			formObj.yd_cd.value = formObj.port_cd.value + formObj.comboTerminalCd.Code;
			
			f_RemoveSheets(); 
		
			sheetObj.DoSearch("VOP_PSO_0036GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_"));
		break;
		
		case SEARCH01://VerClick VersionList Query
	
			formObj.comboLgsCostCd.RemoveAll();
		
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_");
			
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0036GS.do", sParam);
			sheetObjects[0].WaitImageVisible = false;	
			var comboData = ComGetEtcData(sXml, LANE); 
		
			var comboItems = null;
			if(comboData != null && comboData != ""){
				comboItems = comboData.split(ROWMARK);
				addComboItem(formObj.comboLgsCostCd, comboItems, 0);

				// ======================================================================================================
				// 수정일자 : 2014.07.07
				// 수정내용 : 두개의 effective 조회시 항상 이전 Effective date가 조회되니 Year 기준으로 두개를 호출하면
				//            최신의 Effective 를 가지는 것을 우선적으로 조회될 수 있도록 수정함.
				// ======================================================================================================				
				comboObjects[2].Index = 0;
				//formObj.comboLgsCostCd.Index = formObj.comboLgsCostCd.GetCount()-1;
				// ======================================================================================================
			}			
		break;
	
		case SEARCH02://EffectiveDate List Click 시 Version Query
			formObj.comboVer.RemoveAll();
			formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_");
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0036GS.do", sParam);
			var comboData = ComGetEtcData(sXml, LANE);
		
			var comboItems = null;
			if(comboData != null && comboData != ""){
				comboItems = comboData.split(ROWMARK);
				addComboItem(formObj.comboVer,comboItems, 1);
				//comboObjects[2].Code = 1;//1번째 선택
				formObj.comboVer.Index = 0;
			}
		break;

	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		/*if (port_cd.value == "") {
			ComShowCodeMessage("PSO00003", "Port");
			port_cd.focus();
			return false;
		}*/
		if (year.value == "") {
			ComShowCodeMessage("PSO00003", "Year");
			year.focus();
			return false;
		}
	}
	switch (sAction) {
	case "port_cd_change": //port_cd onChange Event
	if (!ComIsNull(formObj.port_cd.value)) {
		if (formObj.port_cd.value.length < 5) {
			ComShowCodeMessage("PSO00014", "[Port]");
			formObj.port_cd.value = "";
			formObj.port_cd.focus();
			return false;
		}
	} else {
		formObj.comboTerminalCd.RemoveAll();
		// SheetObject Clear
		for (i = 0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
		return false;
	}

	break;
	}

	return true;
}

function sheet1_OnLoadFinish(sheetObj){
	//myDiv0211.style.display = "inline";	
	loadAccount();
	document.form.port_cd.focus();
}

/**
 * Sheet1_OBject의 Search가 완료 되었을 때 처리 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	f_RemoveSheets();

	if(sheetObj.RowCount > 0 && formObj.popup_flg.value =='Y' ) {

		for (var i=1; i < sheetObj.Rows; i++){

			if(sheetObj.CellValue(i,"sheet_sd_rw_cnt") == '2'){
			   sheetObj.CellFontColor(i,"sheet_lgs_cost_cd") = sheetObj.RgbColor(255,0,0);
			}
		}

 			
		
	}
	if(sheetObj.RowCount > 0 && formObj.f_cmd.value == SEARCH ){
		//최초 에만.. 
		//조회 건수 가 있으면 최초에 Focus된 넘의 데이터를 쿼리 한다. 
		//SEARCH01
		formObj.yd_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_yd_cd");
		formObj.vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_vndr_seq");
		formObj.lgs_cost_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_lgs_cost_cd");
		
		doActionIBSheet(sheetObjects[0],formObj,SEARCH01);		
	} else{
		myDiv0211.style.display = "inline";
		myDiv0212.style.display = "none";

	}
}
 
 /**
 * Sheet6_OBject의 Search가 완료 되었을 때 처리 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet6_OnSearchEnd(sheetObj,ErrMsg){
	 var prefix = "sheet2_";
	 var hidFlg = "N";
	
	 for(i=0; i < sheetObj.RowCount ; i++){
            
		 var row = i + 2;
 		 var rateCode = sheetObj.CellValue(row, prefix+"rate_code");

		 if(rateCode != "F"){
			 hidFlg = "Y";
			
		 }
		 
	 }
	
	 if(  hidFlg == "N" ){
		 sheetObj.ColHidden(prefix+"range_from") = true;
		 sheetObj.ColHidden(prefix+"range_to") = true;
	 }
	 else {
		 sheetObj.ColHidden(prefix+"range_from") = false;
		 sheetObj.ColHidden(prefix+"range_to") = false;
	 }
}

 /**
  * Sheet7_OBject의 Search가 완료 되었을 때 처리 
  * @param sheetObj
  * @param ErrMsg
  * @return
  */
 function sheet7_OnSearchEnd(sheetObj, ErrMsg){
 	var formObj = document.form;
 	if(sheetObj.RowCount > 0){
		sheetObjects[5].style.height = HEIGHT_SHEET6;
		sheetObjects[6].style.height = HEIGHT_SHEET7;
	} else{		
		sheetObjects[6].style.height = 0;
		sheetObjects[5].style.height = HEIGHT_SHEET6+HEIGHT_SHEET7 + 30;
	}
 	
 }
 
/**
 * Sheet1을 클릭시에 EffectiveDateList를 쿼리한다.
 * @param SheetObj
 * @param Row
 * @param Col
 * @param Value
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	var formObj = document.form;
	f_RemoveSheets();
	formObj.yd_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_yd_cd");
	formObj.vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_vndr_seq");
	formObj.lgs_cost_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet_lgs_cost_cd");
	
	//Contract, Regulation 을 초기화해준다.
	ComSetObjValue(formObj.contract, "");
	
	doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
}	


/**
 * Terminal Combo
 */
function comboTerminalCd_OnBlur(){
	loadAccount();
}

 /**
  * Account Combo
  */
 function acct_cd_OnChange(comboObj, Index_Code, Text){
 	var formObj = document.form;
 	
 	acctCdDpTmp ="";
 	
 	for(var i = 1 ; i < comboObj.GetCount() ; i++){
 		if(comboObj.CheckIndex(i)){
 			if(acctCdDpTmp == "" ){
 				acctCdDpTmp = acctCdNmTmp[i];
 			}else{
 				acctCdDpTmp = acctCdDpTmp + ", " + acctCdNmTmp[i];
 			}			
 		}
 	}
 	formObj.acct_nm.value = acctCdDpTmp;
 }

 function acct_cd_OnCheckClick(comboObj, index, code) {
 	if(index==0) { 	    	
 		var bChk = comboObj.CheckIndex(index);
 		if(bChk){
 			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
 				comboObj.CheckIndex(i) = false;
 			}
 		} 		
 	} else {
 		comboObj.CheckIndex(0) = false;
 	}
} 
 
/**
 * Effective Date가 변할 때 해당 Effective Date사이의 Version정보를 쿼리한다. 
 * @param Combo
 * @param Index_Code
 * @param Text
 * @return
 */
function comboLgsCostCd_OnChange(Combo, Index_Code, Text){
	var formObj = document.form;
	formObj.eff_dt.value = Text;
	doActionIBSheet(sheetObjects[0],formObj,SEARCH02);	
}
/**
 * Vesrion 정보가  변할 때 해당 Tariff 정보를 Query한다. 
 * @param Combo
 * @param Index_Code
 * @param Text
 * @return
 */
function comboVer_OnChange(Combo, Index_Code, Text){
	var formObj = document.form;
	formObj.updated_by.value = updatedBys[Combo.Index];
	formObj.updated_date.value = updatedDates[Combo.Index];

	ComSetObjValue(formObj.port_trf_url, urls[Combo.Index]);
	ComSetObjValue(formObj.port_trf_rmk, remarks[Combo.Index]);
	ComSetObjValue(formObj.yd_chg_no,    ydChgNos[Combo.Index]);
	ComSetObjValue(formObj.contract,     contracts[Combo.Index]);
	
	//SEARCH03
	formObj.combo1.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_yd_cd").substring(5);
	formObj.combo3.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_lgs_cost_cd");
	formObj.combo5.value = Text;

	var dates = formObj.comboLgsCostCd.Text.split('~');
	if(dates.length>=2){
		formObj.from_date.value = dates[0];
		formObj.to_date.value = dates[1];
	}

	//Tariff List를 쿼리한다. 
	//해당 Tariff의 타입이 단순(1) 이냐 복잡(2)이냐에 따라 처리 분기 
	var mode = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_upd_mnu_no");
	if (mode == "1") {
		var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_" ); 

		myDiv0212.style.display = "none";	
		myDiv0211.style.display = "inline";	

		var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(SEARCH);																	//Command
			param += "&port_cd="  + sheetObjects[0].UrlEncoding("");																		//Port
			param += "&combo1="   + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_yd_cd"));		//Yard
			param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_vndr_seq"));	//Service Provider
			param += "&combo3="   + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_lgs_cost_cd"));	//Cost
			param += "&combo5="   + sheetObjects[0].UrlEncoding(formObj.comboVer.Code); 													//Currency -> Version
			param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(0,10));
			param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(11));
			param += "&uid="      + sheetObjects[0].UrlEncoding("0002"); 				//UID 
		
		var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0002GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		var arrXml = sXml.split("|$$|");    

		sheetObjects[1].WaitImageVisible = true;	//Div1 : sheet1
		sheetObjects[2].WaitImageVisible = false;	//Div1 : sheet2
		sheetObjects[3].WaitImageVisible = false;	//Div1 : sheet3

		sheetObjects[1].Redraw = false;
		sheetObjects[2].Redraw = false;
		sheetObjects[3].Redraw = false;

		sheetObjects[1].LoadSearchXml(arrXml[0]); 
		sheetObjects[2].LoadSearchXml(arrXml[1]); 
		sheetObjects[3].LoadSearchXml(arrXml[2]); 

		sheetObjects[1].Redraw = true;
		sheetObjects[2].Redraw = true;
		sheetObjects[3].Redraw = true;

		//첫번째 행만 Enable 하기 위하여
		setEnableControl4Columns(sheetObjects[1], aryPrefix[0]+"object|" + aryPrefix[0]+"object_code|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"regular_value|" + aryPrefix[0]+"condition");
		f_AfterRetrieve(1);

	} 
	else if (mode == "2") {
		var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_" );

		myDiv0211.style.display = "none";	
		myDiv0212.style.display = "inline";	

		var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(SEARCH);				//Command
			param += "&port_cd="  + sheetObjects[0].UrlEncoding("");																		//Port
			param += "&combo1="   + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_yd_cd"));		//Yard
			param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_vndr_seq"));	//Service Provider
			param += "&combo3="   + sheetObjects[0].UrlEncoding(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet_lgs_cost_cd"));	//Cost
			param += "&combo5="   + sheetObjects[0].UrlEncoding(formObj.comboVer.Code); 													//Currency -> Version
			param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(0,10));
			param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_dt.value.substring(11));
			param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID 
		
		var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		var arrXml = sXml.split("|$$|");  	

		//Div2 이전에 그려진 sheets는 4개이므로.. 
		sheetObjects[0+4].WaitImageVisible = true;
		sheetObjects[5+4].WaitImageVisible = false;
		sheetObjects[2+4].WaitImageVisible = false;
		sheetObjects[3+4].WaitImageVisible = false;
		sheetObjects[4+4].WaitImageVisible = false;

		sheetObjects[0+4].Redraw = false;
		sheetObjects[5+4].Redraw = false;
		sheetObjects[2+4].Redraw = false;
		sheetObjects[3+4].Redraw = false;
		sheetObjects[4+4].Redraw = false;

		sheetObjects[0+4].LoadSearchXml(arrXml[0]); 
		sheetObjects[5+4].LoadSearchXml(arrXml[1]); 
		sheetObjects[2+4].LoadSearchXml(arrXml[2]); 
		sheetObjects[3+4].LoadSearchXml(arrXml[3]); 
		sheetObjects[4+4].LoadSearchXml(arrXml[4]); 

		if(sheetObjects[0+4].RowCount > 0){
			f_CopyDummy2Base(sheetObjects[0+4].CellValue(sheetObjects[0+4].HeaderRows, "sheet1_uk"));
		}

		sheetObjects[0+4].Redraw = true;
		sheetObjects[5+4].Redraw = true;
		sheetObjects[2+4].Redraw = true;
		sheetObjects[3+4].Redraw = true;
		sheetObjects[4+4].Redraw = true;	

		f_AfterRetrieve(2);
	}
}


/**
 * Row 변경시
 */ 
function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
	if(OldRow == NewRow){
		return;
	}

	f_RemoveDummyByBase(sheetObj.CellValue(OldRow, "sheet1_uk"));	//Dummy 	삭제
	f_CopyBase2Dummy(sheetObj.CellValue(OldRow, "sheet1_uk"));		//Dummy에 	추가
	f_CopyDummy2Base(sheetObj.CellValue(NewRow, "sheet1_uk"));		//Base에 	복사

	document.getElementById("foml_desc").innerHTML = sheetObj.CellValue(NewRow, "sheet1_foml_desc");
	document.getElementById("cond_desc").innerHTML = sheetObj.CellValue(NewRow, "sheet1_cond_desc");
}   

/* 
function sheet6_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;
	switch (sheetObj.ColSaveName(Col)) {
	case prefix + "object" :
		formObj.f_cmd.value = SEARCHLIST02;//2번으로 .. 
		var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		param = param + "&pso_obj_cd=" + sheetObj.
		CellValue(Row, Col); 

		var sXml = sheetObj.GetSearchXml("VOP_PSO_0211GS.do", param );

		var comboItems = ComGetEtcData(sXml, "objlist2");
		var comboItems1= "";
		var comboItems2= "";

		if ( comboItems == "" ) {
			sheetObj.CellComboItem(Row, Col+1 , " |", " |", 0);
		} else {	
			if ( !comboItems.length ) {
				var comboItem = comboItems.split(",");
				comboItems1 = comboItem[0];
				comboItems2 = comboItem[1]; 		
			} else {
				comboItems = comboItems.split("|");
				for (var i = 0 ; i < comboItems.length ; i++) {
					var comboItem = comboItems[i].split(",");
					if( i == 0 ){
						comboItems1 = comboItem[0];
						comboItems2 = comboItem[1]; 
					} else {
						comboItems1 = comboItems1 + "|" +comboItem[0];
						comboItems2 = comboItems2 + "|" +comboItem[1]; 
					}	
				}   		
			}

			sheetObj.CellValue2(Row, Col+1) = "";
			sheetObj.CellComboItem(Row, Col+1 , comboItems2, comboItems1, 0);
		}
		break;
	case prefix + "operator" :
		var opt = sheetObj.CellValue(Row, Col); 
		if( opt == "IN" )
			sheetObj.InitCellProperty(Row, Col+1, dtData, daCenter,	prefix+"Value" , "" , dfEngUpKey);

		break;
	}
}
*/

function f_RemoveSheets(){
	var formObj = document.form;

	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();

	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	sheetObjects[6].RemoveAll();
	sheetObjects[7].RemoveAll();
	sheetObjects[8].RemoveAll();
	sheetObjects[9].RemoveAll();

	//formObj.foml_desc.value = "";
	document.getElementById("foml_desc").innerHTML = "";
	//formObj.cond_desc.value = "";
	document.getElementById("cond_desc").innerHTML = "";
}       

function setEnableControl4Columns(sheetObj, cols){
	var formObj = document.form;
	var arrCol = cols.split("|");
	for(row=sheetObj.HeaderRows; row<sheetObj.HeaderRows + sheetObj.RowCount; row++){
		if(row > sheetObj.HeaderRows){	//첫번째 행이 아니면
			for(i=0; i<arrCol.length; i++){
				sheetObj.CellEditable(row, arrCol[i]) = false; 
			}

			sheetObj.CellValue2(row, "sheet1_seq") = "";
	
			sheetObj.CellValue2(row, "sheet1_object_dsp") = "";
	
			sheetObj.CellValue2(row, "sheet1_object_code_dsp") = "";
	
			sheetObj.CellValue2(row, "sheet1_rate_code") = "";
	
			sheetObj.CellValue2(row, "sheet1_regular_value") = "";
	
			sheetObj.CellValue2(row, "sheet1_condition") = "";
	
			sheetObj.CellValue2(row, "sheet1_cond_desc") = "";

		} else{
			for(i=0; i<arrCol.length; i++){
				sheetObj.CellEditable(row, arrCol[i]) = true; 
			}		
		}
	}

	//Compulsory
	if(sheetObjects[0].RowCount > 0){
		if(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_cpls_flg") == "Y"){
			formObj.cpls_flg.checked = true;
		} else{			
			formObj.cpls_flg.checked = false;
		}
	} else{
		formObj.cpls_flg.checked = false;
	}
}

/*
* Sheet6를 Sheet10로 복사
*/
function f_CopyBase2Dummy(oldUk){

	var sXml = f_MakeSearchXml4CopyBase2Dummy(oldUk);
	sheetObjects[9].WaitImageVisible = false;
	sheetObjects[9].LoadSearchXml(sXml, true, -1);	//Append
}

/*
* Sheet10를 Sheet6로 복사
*/
function f_CopyDummy2Base(uk){

	var sXml = f_MakeSearchXml4CopyDummy2Base(uk);
	sheetObjects[5].Redraw = false;  
	sheetObjects[5].LoadSearchXml(sXml);
	sheetObjects[5].Redraw = true;
}

/*
* Sheet10에 있는 Sheet6데이터를 삭제
*/
function f_RemoveDummyByBase(uk){
	
	var xxx = ComFindAll(sheetObjects[9], "sheet6_uk", uk) + "";
	if(xxx == "-1"){
		return;
	}
	var zzz = xxx.split("|");
	if(zzz.length == 0){
		return;
	}
	 
	//UK 행 삭제
	sheetObjects[9].Redraw = false; 
	for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
		sheetObjects[9].RowDelete( i, false );
	}
	sheetObjects[9].Redraw = true; 
}

function f_AfterRetrieve(div){
	var formObj = document.form;
	var sheetObj = div == 1 ? sheetObjects[1] : sheetObjects[4];
	//Compulsory
	if(sheetObj.RowCount > 0){
		if(sheetObj.CellValue(sheetObj.HeaderRows, "sheet1_cpls_flg") == "Y"){
			formObj.cpls_flg.checked = true;
		} else{			
			formObj.cpls_flg.checked = false;
		}
	} else{
		formObj.cpls_flg.checked = false;
	}
}

/**
 * 
 */ 
function f_MakeSearchXml4CopyDummy2Base(uk)  {
	 var sheetObj = sheetObjects[9];
	 try {
		 //함수 인자 유효성 확인
		 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
			 //ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
			 return "";
		 }

		 var allXml = "";
		 var hColSep = "|";
		 var sColSep = "☜☞";
		 var sColOrder = "";

		 var aryTD = new Array(gColumnCountInSheet6);
		 for(var i = 0; i < gColumnCountInSheet6; i++){
			 aryTD[i] = sheetObj.ColSaveName(i).replace(/sheet6/g, "sheet2");
		 }
		 sColOrder = aryTD.join(hColSep);

		 allXml = "<?xml version='1.0'  ?>\n" 
			 + "<SHEET>\n";

		 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		 var arrRow = new Array();
		 var k = 0;
		 for( var i=sheetObj.HeaderRows; i<sheetObj.RowCount + sheetObj.HeaderRows; i++ ) {
			 if(sheetObj.CellValue(i, "sheet6_uk") == uk){
				 arrRow[k] = i;
				 k++;
			 }
		 }

		 if(arrRow.length != 0){
			 var aryTR  = new Array(arrRow.length);

			 for(var ir = 0; ir<arrRow.length; ir++){
				 for(var ic = 0; ic<gColumnCountInSheet6; ic++){
					 //TD-셀의 값을 변수에 저장한다.
					 aryTD[ic] = String(sheetObj.CellValue(arrRow[ir], ic));
				 }
				 aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			 }

			 allXml += aryTR.join("\n");
		 }
		 allXml += "  \n</DATA>\n"
			 +  "</SHEET>";

		 return allXml;
	 } catch(err) { ComFuncErrMsg(err.message); }
}  

/**
 * 
 */ 
function f_MakeSearchXml4CopyBase2Dummy(oldUk)  {
	 var sheetObj = sheetObjects[5];
	 try {
		 //함수 인자 유효성 확인
		 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
			 return "";
		 }
		 
		 var allXml = "";
		 var hColSep = "|";
		 var sColSep = "☜☞";
		 var sColOrder = "";
		 
		 var aryTD = new Array(gColumnCountInSheet6);
		 for(var i = 0; i < gColumnCountInSheet6; i++){
			 aryTD[i] = sheetObj.ColSaveName(i).replace(/sheet2/g, "sheet6");
		 }
		 sColOrder = aryTD.join(hColSep);
		 
		 allXml = "<?xml version='1.0'  ?>\n" 
			 + "<SHEET>\n";
		 
		 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		 var arrRow = new Array();
		 for( var i=sheetObj.HeaderRows; i<sheetObj.RowCount + sheetObj.HeaderRows; i++ ) {
			 arrRow[i-sheetObj.HeaderRows] = i;
		 }
		 
		 if(arrRow.length != 0){
			 var aryTR  = new Array(arrRow.length);
			 
			 for(var ir = 0; ir<arrRow.length; ir++){
				 for(var ic = 0; ic<gColumnCountInSheet6; ic++){
					 //TD-셀의 값을 변수에 저장한다.
					 aryTD[ic] = String(sheetObj.CellValue(arrRow[ir], ic));
				 }
				 aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			 }
			 
			 allXml += aryTR.join("\n");
		 }
		 allXml += "  \n</DATA>\n"
			 +  "</SHEET>";
		 
		 return allXml;
	 } catch(err) { ComFuncErrMsg(err.message); }
} 

function setTmpTmlCd(){
	loadTerminal();
	loadAccount();
	document.form.comboTerminalCd.Index = tmpTml;
}

/**
 * Remark 팝업설정
 */
function setPortTrfRmk(rtnValue) {
	
	ComSetObjValue(document.form.port_trf_rmk, rtnValue);
}

/**
 * Contract 팝업설정
 */
function setContract(rtnValue) {
	
	ComSetObjValue(document.form.contract, rtnValue);
}


/* 개발자 작업  끝 */