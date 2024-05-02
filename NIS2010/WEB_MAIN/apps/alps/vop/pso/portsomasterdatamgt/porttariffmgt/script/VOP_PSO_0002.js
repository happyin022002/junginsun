/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0002.js
 *@FileTitle : Tariff List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.10
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.06.03 박명종
 * 1.0 Creation
 *  
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
 * 2011.07.15 김기종 CHM-201111662-01 Formula 및 Condition ID 입력 변경 & 칼럼 숨김 요청
 * 2011.11.10 진마리아 CHM-201114331-01 [VOP-PSO] Formula Selection 내 Add Row 로직 변경건
 * 2013.07.23 SKY    CHM-201325679  [VOP-PSO] Tariff 생성시 effective date 값 변경
 * 2014.03.20 이윤정 [CHM-201429328] [PSO] Tariff Creation 화면에서 Invoice 생성 여부와 관계없이 Delete 버튼 활성화
 * 2014.07.16 이성훈   CHM-201430928    Port Tariff Contract 및 URL 저장
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
 * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0002() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.setComboObject 		= setComboObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;    	
	this.initControl            = initControl;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var gSheet1_rate_code = "";	//sheet1에서 Rate Type 콤보가  변경될때, 변경 전 값을 갖고 있음.
var ENABLE_COMBO_ONCHANGE = true;
var COMBO_ONCHANGE_CODE   = "";
var WIDTH_FORMULA_POPUP = 700;		//VOP_PSO_0209.do Popup 
var HEIGHT_FORMULA_POPUP = 420;
var WIDTH_CONDITION_CREATION_POPUP = 800;	//VOP_PSO_0206.do Popup
var HEIGHT_CONDITION_CREATION_POPUP = 290;
var WIDTH_COPY_POPUP = 750;	//VOP_PSO_0211.do Popup
var HEIGHT_COPY_POPUP = 500;
var POP_TITLE_0206 = "Formula Condition";		//VOP_PSO_0004의 특정 버튼에서 띄울때만 'Rate Condition'이 됨.

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var conditionXML = "";	//페이지로딩시 조회조건 세팅용 쿼리 결과
var searchVersionXML = "";	//Version 조회결과

var arrFormulaNo = new Array();	//페이지로딩시 Formula_No IN (1, 2) 가져옴 

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_RowAdd":
				
				if( !validateForm(sheetObject1,formObject,IBSEARCH)) return;
				
				var prefix = "sheet1_";	
				var selectRow = sheetObject1.SelectRow;
	
				if (comboObjects[3].Text == "") {	// comboObjects[4] -> 3 으로 변경완료
					ComShowCodeMessage('PSO00005');
					return;
				}	
				
				if (sheetObject1.RowCount == 0) {	//신규 첫행
	
				} 
				else if (sheetObject1.RowCount > 0) {	//두번째 행부터
					if( sheetObject1.CellValue( sheetObject1.LastRow, "sheet1_range_from") == "" 
						||	sheetObject1.CellValue( sheetObject1.LastRow, "sheet1_range_to") == "" 
						||	sheetObject1.CellValue( sheetObject1.LastRow, "sheet1_rate_value") == "" ){ 
						ComShowCodeMessage('PSO00003');
						return;
					}			
				}
	
				sheetObject1.DataInsert(-1);
				sheetObject1.HeadCheck(0, "sheet1_del_chk") = false;
				sheetObject1.HeadCheck(1, "sheet1_del_chk") = false;
				
				selectRow = eval(sheetObject1.SelectRow);
				sheetObject1.CellValue2(selectRow, "sheet1_seq") = 10;  
				sheetObject1.CellValue2(selectRow, "sheet1_obj_list_no") = "";	//콤보 디폴트선택을 없애기위해
	
				if( selectRow == sheetObject1.HeaderRows ){	//첫번째 신규행은
					sheetObject1.CellValue(sheetObject1.LastRow, "sheet1_upd_mnu_cond_no") = "1";	//값이 없으면 그림이 안 나타남
	
				} else if( selectRow > sheetObject1.HeaderRows ){	//두번째 행부터는 이전 행 복사하여 디폴트 표현
					sheetObject1.CellValue2(sheetObject1.LastRow, "sheet1_obj_list_no") = sheetObject1.CellValue(sheetObject1.HeaderRows, "sheet1_obj_list_no");
					sheetObject1.CellValue2(sheetObject1.LastRow, "sheet1_rate_code") = sheetObject1.CellValue(sheetObject1.HeaderRows, "sheet1_rate_code");
					//sheetObject1.CellValue2(sheetObject1.LastRow, "sheet1_range_from") = ""+(eval(sheetObject1.CellValue(  sheetObject1.LastRow-1 , "sheet1_range_to"))+1);
					sheetObject1.CellValue2(sheetObject1.LastRow, "sheet1_object_code_dsp") = sheetObject1.CellValue(sheetObject1.HeaderRows, "sheet1_object_code_dsp");
				}
	
				//첫번째 행만 Enable 하기 위하여
				setEnableControl4Columns(sheetObject1, prefix+"obj_list_no|" + prefix+"rate_code|" + prefix+"condition|" + prefix+"upd_mnu_no_cond");	//[2010.01.13] Regular Value를 ReadOnly로 변경
	
				break;
			case "btn_Delete":
				var prefix = "sheet1_";	
				var selectRow = eval(sheetObject1.SelectRow);
				
				//체크된 행 삭제
				for( var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i-- ) {
					if(sheetObject1.CellValue(i, "sheet1_del_chk") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				
				if(sheetObject1.LastRow < sheetObject1.HeaderRows){
					ComBtnEnable("btn_RowAdd");
				}
				
				sheetObject1.HeadCheck(0, "sheet1_del_chk") = false;
				sheetObject1.HeadCheck(1, "sheet1_del_chk") = false;
				
				break;	
				
			case "btn_RowAdd2":
				if( !validateForm(sheetObject1,formObject,IBSEARCH)) return;
				
				sheetObject2.DataInsert(-1);
				//var vals = comboItems2.split("|");
				sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_upd_mnu_no_cond") = "1";
				selectRow = eval(sheetObject2.SelectRow);
				sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_seq") = 10*selectRow; 
				sheetObject2.HeadCheck(0, "sheet2_del_chk") = false;
				
				//Call sheet2_Onchange()
				sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_method_code") = ""; 
				sheetObject2.CellValue(sheetObject2.LastRow, "sheet2_method_code") = "A"; 
				
				break;
	
			case "btn_Delete2":	
				//체크된 행 삭제
				for( var i=sheetObject2.LastRow; i>=sheetObject2.HeaderRows; i-- ) {
					if(sheetObject2.CellValue(i, "sheet2_del_chk") == 1){
						sheetObject2.RowDelete( i, false );
					}
				}
				sheetObject2.HeadCheck(0, "sheet2_del_chk") = false;
				break;
				
			case "btn_RowAdd3":
				if( !validateForm(sheetObject1,formObject,IBSEARCH)) return;
				
				sheetObject3.DataInsert(-1);
				//var vals = comboItems2.split("|");
				sheetObject3.CellValue2(sheetObject3.LastRow, "sheet3_upd_mnu_no_cond") = "1";
				selectRow = eval(sheetObject3.SelectRow);
				sheetObject3.CellValue2(sheetObject3.LastRow, "sheet3_seq") = 10*selectRow; 
				sheetObject3.HeadCheck(0, "sheet3_del_chk") = false;
	
				//Call sheet3_Onchange()
				sheetObject3.CellValue2(sheetObject3.LastRow, "sheet3_method_code") = ""; 
				sheetObject3.CellValue(sheetObject3.LastRow, "sheet3_method_code") = "A"; 
				
				break;
				
			case "btn_Delete3":	
				//체크된 행 삭제
				for( var i=sheetObject3.LastRow; i>=sheetObject3.HeaderRows; i-- ) {
					if(sheetObject3.CellValue(i, "sheet3_del_chk") == 1){
						sheetObject3.RowDelete( i, false );
					}
				}
				sheetObject3.HeadCheck(0, "sheet3_del_chk") = false;
				break;
				
			case "btn_port_cd":
				var originalPortCd = formObject.port_cd.value; 	
				var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
	
				if(rVal != undefined && rVal != "" && rVal != originalPortCd){
					formObject.port_cd.value = rVal;
					loadTerminal();				//COMBO YARD
					f_SetComboAccount(rVal);	//COMBO ACCOUNT		
					f_RemoveAllSheet();
					comboObjects[0].focus();
				}
				break;
			case "btns_VendorSeq":
				//ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 430, 'setVendorSeq', '1,0,1,1,1', true);
				ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setVendorSeq', '0,0', true, true);
				break;
			case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal = new ComCalendar();
				cal.select(formObject.from_date, 'yyyy-MM-dd');
			break;
	
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal = new ComCalendar();
				cal.select(formObject.to_date, 'yyyy-MM-dd');
			break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_DataDelete":			
				doActionIBSheet(sheetObject1,formObject,IBDELETE);	
				break;
			case "btn_Copy":
				if( formObject.port_cd.value == '' || formObject.port_cd.value.length != 5) {
					ComShowCodeMessage("PSO00003", "[Port]");	
					formObject.port_cd.focus();
					return; 
				}	
				if( comboObjects[2].Code == '' ) {
					ComShowCodeMessage("PSO00003", "[Account/Cost]");	
					//formObject.vndr_seq.focus();
					return; 
				}	
				if( formObject.vndr_seq.value == '' ) {
					ComShowCodeMessage("PSO00003", "[Service Provider]");	
					formObject.vndr_seq.focus();
					return; 
				}	
				
				var param  = "port_cd="   + sheetObjects[0].UrlEncoding(formObject.port_cd.value);
				    param += "&yd_cd="    + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 
				    param += "&acct_cd="  + sheetObjects[0].UrlEncoding(comboObjects[1].Code);
				    param += "&acct_nm="  + sheetObjects[0].UrlEncoding(formObject.account_nm.value);
				    param += "&cost_cd="  + sheetObjects[0].UrlEncoding(comboObjects[2].Code);
				    param += "&cost_nm="  + sheetObjects[0].UrlEncoding(formObject.lgs_cost_nm.value);
				    param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(Number(formObject.vndr_seq.value));
				    param += "&vndr_nm="  + sheetObjects[0].UrlEncoding(formObject.vndr_lgl_eng_nm.value);
				
				var sUrl = "/hanjin/VOP_PSO_0211.do?" + param;
				//ComOpenPopup(sUrl, 800, 474, "setPso0211", "0,0", false, false);
				var sFeatures = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_COPY_POPUP + ",height=" + HEIGHT_COPY_POPUP;
				ComOpenWindow(sUrl, "COPY1", sFeatures, false);
				
				break;
				
			// ======================================================================================================
			// 수정일자 : 2014.07.07
			// 수정내용 : Contract/Regulation 필드 추가
			// ======================================================================================================
			case "btn_cntr_cd":
				var param  = "yd_chg_no=" + sheetObject1.UrlEncoding(ComGetObjValue(formObject.yd_chg_no));
		            param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[4].Code);	// comboObjects[3] -> 4 으로 변경완료
		            param += "&caller=" + "0002";
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
	            	param += "&yd_chg_ver_seq=" + sheetObject1.UrlEncoding(comboObjects[4].Code);	// comboObjects[3] -> 4 으로 변경완료
				    param += "&caller=" + "0002";
				ComOpenPopup("VOP_PSO_0042.do?" + param, 422, 350, "setPortTrfRmk", "1,0,1,1,1,1,1", true);
				break;				
			// ======================================================================================================
				
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

function loadTerminal() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	//콤보필드를 초기화시킨다.
	comboObjects[0].RemoveAll();
	formObj.f_cmd.value = COMMAND01;
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(comboObjects[0], comboItems);
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
	
	//Version Combo
	comboObjects[4].Enable = false;	// comboObjects[3] -> 4 으로 변경완료

	initControl(sheetObjects[0]);  
	
	//xsheet1_OnLoadFinish(sheetObjects[0]);
	//xsheet2_OnLoadFinish(sheetObjects[1]);
	//xsheet3_OnLoadFinish(sheetObjects[2]);
}

function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	setToday(formObj.from_date);
	formObj.to_date.value = '9999-12-31';
//	setToday(formObj.to_date);
	
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('click', 'obj_click', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	
	switch(comboNo) {  
		case 1:		//Yard 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("40|300");
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자
				MaxLength = 2;
			}
	
			break; 
			
		case 2:		//Account  
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				//UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨. 따라서 User Function 사용)
				MaxLength = 6;
			}
			
			break; 			
		case 3:		//Cost 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 6;
			}
			
			break; 			
		case 4:		//Version  
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
			}
			
			break; 			
	
		case 5:		//Currency 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 3;
			}
	
			break; 			
	} 
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
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			if(obj.name=="vndr_seq"){
				//ComKeyOnlyNumber(obj,",");
				ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
			} else {
				ComKeyOnlyNumber(obj);
			}
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			if(obj.name=="vsl_slan_cd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
		
	}

}


/**
 * 콤보필드에 데이터를 추가해준다. (Currency)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   	
}

/**
 * 콤보필드에 데이터를 추가해준다.(Version 전용)
 */	
function addComboItemVersion(comboObj,comboItems) {
	
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		//Text : Version|FromDt~ToDt|Curr_Cd
		
		var comboValue = comboItem[1];
		var comboText = "";
		comboText  = comboItem[1] + "|";
		comboText += comboItem[2] + "|";
		comboText += comboItem[3];

		comboObj.InsertItem(i, comboText, comboValue);
		//최신 Version만 보여주기로 함
		if(i == 0) break;
	}   		
}
 
/**
 * 콤보필드에 데이터를 추가해준다. (Account)
 * EGSUZ,PAPAC Port의 경우, 511911 Account만 보여줌 
 */	 
function addComboItemAccount(isCanal) {
	 
	comboObjects[1].UseCode = true;
	comboObjects[1].RemoveAll();
	
	var comboItems = ComGetEtcData(conditionXML, "account").split(ROWMARK);
	var comboItem = "";
	if(comboItems!=""){
		if(isCanal == "CANAL_X"){
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if(comboItem[1] != "511911"){
					comboObjects[1].InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
				}
			}   
		} else if(isCanal == "CANAL_O"){
			var accountForCanal = ComGetEtcData(conditionXML, "accountForCanal").split(FIELDMARK);
			comboObjects[1].InsertItem(-1, accountForCanal[1] + "|" + accountForCanal[0], accountForCanal[1]);
		}
		comboObjects[1].Index = 0;
	}else{
		ComShowMessage("There is no registered account at this office.");
	}
}
 
/**
 * 콤보필드에 데이터를 추가해준다. (Cost)
 */	
function addComboItemCost(code) {	
	comboObjects[2].UseCode = true;
	comboObjects[2].RemoveAll();
	
	var accountItems = ComGetEtcData(conditionXML, "account" ).split(ROWMARK);
	var accountItem = "";
	var costItems = ComGetEtcData(conditionXML, "cost" ).split(ROWMARK);
	var costItem = "";
	
 	for (var i = 0 ; i < costItems.length ; i++) {
 		accountItem = accountItems[i].split(FIELDMARK);
 		
 		if(accountItem[1] == code){ 		
	 		costItem = costItems[i].split(FIELDMARK);
	 		comboObjects[2].InsertItem(-1, costItem[0] + "|" + costItem[1], costItem[0]);
 		}
 	}  
 	comboObjects[2].Index = 0;
} 


/**
 * 콤보필드에 데이터를 추가해준다. (Object/Method in Sheets)
 */	
function makeItemObject(comboItems) {	
	//var comboItems = ComGetEtcData(conditionXML, "objlist");
	var comboCode= "";
	var comboText= "";
	
	arrComboItems = comboItems.split("|");
	var preCode = "";
	for (i = 0 ; i < arrComboItems.length ; i++) {
		var comboItem = arrComboItems[i].split(",");
		comboCode += "|" + comboItem[4];
		comboText += "|" + comboItem[1] + "\t" + comboItem[3];
	}  
	
	comboCode = comboCode.substr(1);	//Code
	comboText = comboText.substr(1); 	//Text
	
	return new Array(comboCode, comboText);
} 

/**
 * 콤보필드에 데이터를 추가해준다. (UOM in Sheets)
 */	
function makeItemUOM(comboItems, objCd) {
	var comboCode= "";
	var comboText= "";
		
	arrComboItems = comboItems.split("|");
	for (i = 0 ; i < arrComboItems.length ; i++) {
		var comboItem = arrComboItems[i].split(",");	//[0]:Object Code, [1]:UOM Code, [2]:UOM Name
		if(objCd == comboItem[0]){
			comboCode += "|" + comboItem[1];
			comboText += "|" + comboItem[2];
		}
	}  
	
	comboCode = comboCode.substr(1);	//Code
	comboText = comboText.substr(1); 	//Text
	
	return new Array(comboCode, comboText);	 
}
 
function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;

	switch (eleObj.name) {
		case "port_cd":
			if(eleObj.value.length == 5){
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			} else{
				comboObjects[0].RemoveAll();
			}
			f_RemoveAllSheet();
			break;

		case "from_date":
			if(eleObj.value.length == 8){
				//formObj.to_date.focus();
			}
			break; 
		case "to_date":
			if(eleObj.value.length == 8){
				//formObj.port_cd.focus();
			}
			break;
	}
}

function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");		//영대문자
			break;
			
		case "vndr_seq":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;			

		case "from_date":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;			

		case "to_date":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;			
	}
}

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
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
			style.height = 120;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "||Seq.|Object|Unit of Measure|Rate Type|Range|Range|Currency|Rate|Regular\nValue|Formula Condition|Formula Condition|Formula Condition|||Compulsory";
			var HeadTitle2 = "||Seq.|Object|Unit of Measure|Rate Type|From|To|Currency|Rate|Regular\nValue|ID|Description||||Compulsory";
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
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag"		);
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk"		);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"seq", 			false,		"",			dfNone,				0,		false,	false			);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		prefix+"obj_list_no"		);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"object_code_dsp",	false,	"",			dfNone,			0,		false,  false);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,	4,		true,  		true, 		14);			//	*[2010.01.18] dfNone으로 변경
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",		false,		"",			dfNone,	4,		true,  		true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,				0,		false, 	false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"regular_value",	false,		"",			dfNumber,	4,		false,  		false, 		14);	//	*[2010.01.13] ReadOnly로 변경
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtImage,		60,		daCenter,	true,		prefix+"upd_mnu_no_cond",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"cpls_flg",	false,	"",			dfNone,			0,		true,  true);

			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Range2\tRange Rate Only|Fixed\tObject X Fixed Rate" , "R|S|F", "", "R");
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력
			
			CountPosition = 0;
			
			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//
			
			ShowButtonImage = 1;

		}
		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 122;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|SUM.Option";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet2_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix+"del_chk");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"seq");
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"rate_value",			false,	"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"foml_desc",		false,	"",	dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtImage,		80,		daCenter,	true,		prefix+"upd_mnu_no_cond",			false,		"",			dfNone,				0,		true,  	true);
			InitDataProperty(0, cnt++ , dtCombo,		70,	daCenter,	true,	prefix+"sum_option");

			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			InitDataValid(0, prefix+"formula_no", vtNumericOnly); //숫자만 입력
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력
			
			CountPosition = 0;

			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//

			ShowButtonImage = 1;
		}
		break;

	case "sheet3":
		with (sheetObj) {

			// 높이 설정
			style.height = 122;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|SUM.Option";
			
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
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix+"del_chk");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"seq");
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"method_code");
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"rate_value",			false,	"",			dfNumber,	10,		true,  		true, 		20);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	prefix+"formula_no");
			InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix+"foml_desc",		false,	"",	dfNone,				0,		false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,	prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtImage,		80,		daCenter,	true,	prefix+"upd_mnu_no_cond",			false,		"",			dfNone,				0,		true,  	true);
			InitDataProperty(0, cnt++ , dtCombo,		70,	daCenter,	true,	prefix+"sum_option");			
			
			InitDataCombo(0, prefix+"method_code", "Amount|Percent" , "A|R");	//Amount, Ratio
			InitDataCombo(0, prefix+"sum_option", "ALL|MAX|MIN" , "6|7|8");
			InitDataValid(0, prefix+"formula_no", vtNumericOnly); //숫자만 입력
			InitDataValid(0, prefix+"condition", vtNumericOnly); //숫자만 입력
			
			CountPosition = 0;

			ImageList("0") = "img/btng_condition.gif";			//upd_mnu_no_cond(O), seq2(X)
			ImageList("1") = "img/btng_condition.gif";			//
			ImageList("2") = "img/btng_condition_h.gif"; 		//

			ShowButtonImage = 1;
		}
		break;
		
	case "sheet4":	//Dummy Sheet that is not initialized
		break;
			
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_" );        
	switch(sAction) {
		case IBSEARCH:      // 조회
			if( !validateForm(sheetObj,formObj,sAction)) return;
			ComBtnEnable("btn_RowAdd");
			formObj.f_cmd.value = SEARCH;//COMBO
			
			f_RemoveAllSheet();
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			for(var i = 0; i < arrXml.length; i++){ 
				sheetObjects[i].Redraw = false;    
				if(i > 0) {
					sheetObjects[i].WaitImageVisible = false;	
				}  
				sheetObjects[i].LoadSearchXml(arrXml[i]); 
				sheetObjects[i].Redraw = true; 
			}
		
			//[jmh] 업무요건 변경으로 삭제
			//for(i =  sheetObj.HeaderRows ; i < sheetObj.LastRow+1 ; i++ ) {   		  
			//	f_SetComboObjectCode( sheetObj, i , 3 );
			//}
			
			//첫번째 행만 Enable 하기 위하여
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"obj_list_no|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"condition|" + aryPrefix[0]+"upd_mnu_no_cond");
			f_ShowHideSheet();
			ComOpenWait(false);
		break;

		case IBSEARCH_ASYNC01:	//초기 조회조건 Setting   
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_" );
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
	
			sheetObjects[0].WaitImageVisible = false;
			
			conditionXML = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var arrXml = conditionXML.split("|$$|");
			
			//Object Setting in Sheets
			var comboItems = ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject = makeItemObject(comboItems);
	
			//Base Sheet의 Object Combo Setting
			sheetObjects[0].InitDataCombo(0, "sheet1_obj_list_no", arrCodeTextObject[1], arrCodeTextObject[0]);		  	            		  
	
			//콤보필드를 초기화시킨다. (Account)
			comboObjects[1].RemoveAll();
	
			//콤보필드를 초기화시킨다. (Cost)
			comboObjects[2].RemoveAll();
			
			//콤보필드를 초기화시킨다. (Currency)
			//var localCurrency = ComGetEtcData(conditionXML, "localCurrency" );
			comboObjects[3].RemoveAll();				// comboObjects[4] -> 3 으로 변경완료
			var arrComboItem = ComGetEtcData(conditionXML, "currency").split(ROWMARK);
			addComboItem(comboObjects[3],arrComboItem);	// comboObjects[4] -> 3 으로 변경완료

			var arrFormula4Loading = ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k = 0;
			for(i=0; i<arrFormula4Loading.length; i++){
				var arrKeyVal = arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k] = arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
	
		break;

		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
			if( !validateForm(sheetObj,formObj,sAction)) return;
			/*
		     * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
		     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
		     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
		     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
			 */
			var sParam = ComGetSaveString(sheetObjects, true, true);	//모든 rows를 전송한다.
			if (sParam == "") return;
			
			formObj.yd_chg_ver_seq.value = comboObjects[4].Code; // comboObjects[3] -> 4 으로 변경완료
			
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);

			var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0002GS.do", sParam);
		
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true; 
			sheetObjects[2].Redraw = true; 
			
			searchVersion();
			ComOpenWait(false);
		break;

		case IBCLEAR:  

			//Port
			formObj.port_cd.value = "";
			comboObjects[0].RemoveAll();
			
			//Account
			comboObjects[1].RemoveAll();
			formObj.account_nm.value = "";
			
			//Cost
			comboObjects[2].RemoveAll();
			formObj.lgs_cost_nm.value = "";
			
			//Service Provider
			formObj.vndr_seq.value = "";
			formObj.vndr_lgl_eng_nm.value = "";

			//Origin
			formObj.org_vndr_nm.value = "";
			
			//Date
			setToday(formObj.from_date);
			formObj.to_date.value = "9999-12-31"

			//Version
			comboObjects[4].RemoveAll();	// comboObjects[3] -> 4 으로 변경완료
			
			//Currency
			comboObjects[3].Code2 = "";		// comboObjects[4] -> 3 으로 변경완료
	
			//URL
			ComSetObjValue(formObj.port_trf_url, "");
			
			//Contract/Regulation
			ComSetObjValue(formObj.contract, "");
			
			//Remark
			ComSetObjValue(formObj.port_trf_rmk, "");
			
			//Sheets	
			f_RemoveAllSheet("IBCLEAR");

		break;        

		case IBDELETE:      //데이터 삭제
			formObj.f_cmd.value = REMOVE;
			if(!validateForm(sheetObj,formObj,sAction)) return;
			if(!confirm(msgs["PSO00020"])) return;
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			sParam = FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0002GS.do", sParam);
		
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true; 
			sheetObjects[2].Redraw = true; 
			
			searchVersion();
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			ComOpenWait(false);
			
		break;

		case COMMAND05:	//Port Code [keyup:5자리]  
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
				f_SetComboAccount(rVal);	
				comboObjects[0].focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
		break;

		case COMMAND06:	//Service Provider   
			formObj.f_cmd.value = COMMAND06;//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var spName = ComGetEtcData(sXml, "spName");	//Service Provider Name
			formObj.vndr_lgl_eng_nm.value = spName;
		
			if(spName != ""){
		
			} else{
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				formObj.vndr_seq.focus();
				formObj.vndr_seq.value = "";
			}
		break;		
		
		case COMMAND08:      // COPY후 조회
		
			//Copy Popup에서 얻어온 값
			var param = formObj.copy_condition.value;

			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			for(var i = 0; i < arrXml.length; i++){ 
				sheetObjects[i].RemoveAll();
				sheetObjects[i].Redraw = false;    
				if(i > 0) {
					sheetObjects[i].WaitImageVisible = false;	
				}  
				sheetObjects[i].LoadSearchXml(arrXml[i]); 
				sheetObjects[i].Redraw = true; 
			}
		
			//[jmh] 업무요건 변경으로 삭제
			//for(i =  sheetObj.HeaderRows ; i < sheetObj.LastRow+1 ; i++ ) {   		  
			//	f_SetComboObjectCode( sheetObj, i , 3 );
			//}
			
			//첫번째 행만 Enable 하기 위하여
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"obj_list_no|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"condition|" + aryPrefix[0]+"upd_mnu_no_cond");
			f_ShowHideSheet();
			ComOpenWait(false);
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSEARCH:
				//Port
				if(port_cd.value.length < 5){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
	
				//Yard
				if( comboObjects[0].Code == ''){
					ComShowCodeMessage('PSO00008');
					combo1.focus();
					return false;
				}	
				
				//Account
				if( comboObjects[1].Code == ''){
					ComShowCodeMessage('PSO00003', "[Account]");	//필수항목
					comboObjects[1].focus();
	
					return false;
				}					

				//Cost
				if( comboObjects[2].Code == ''){
					ComShowCodeMessage('PSO00003', "[Cost CD]");	//필수항목
					comboObjects[2].focus();
					
					return false;
				}	
				
				//Service Provider
				if(vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					vndr_seq.focus();
	
					return false;
				}					
	
				if(from_date.value == ''){
					ComShowCodeMessage('PSO00009');
					from_date.focus();
					return false;
				}	
	
				if(to_date.value == ''){
					ComShowCodeMessage('PSO00009');
					to_date.focus();
	
					return false;
				}	
	
				//Ver.	
				if( comboObjects[4].Code == ''){// comboObjects[3] -> 4 으로 변경완료
					ComShowCodeMessage('PSO00003', "[Version]");	//필수항목
					comboObjects[4].focus();	// comboObjects[3] -> 4 으로 변경완료
	
					return false;
				}	

				//Currency	
				if( comboObjects[3].Code == ''){// comboObjects[4] -> 3 으로 변경완료
					ComShowCodeMessage('PSO00003', "[Currency]");	//필수항목
					comboObjects[3].focus();	// comboObjects[4] -> 3 으로 변경완료
					
					return false;
				}	
	
				break;
				
			case IBSAVE:	
				if(port_cd.value == ''){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
	
				if( comboObjects[0].Code == ''){
					ComShowCodeMessage('PSO00008');
					combo1.focus();
					return false;
				}	
	
				if( comboObjects[0].Code.split(",").length > 1 ){
					ComShowCodeMessage('PSO00006');
					return false;
				}	
				
				//Account
				if( comboObjects[1].Code == ''){
					ComShowCodeMessage('PSO00003', "[Account]");	//필수항목
					comboObjects[1].focus();
	
					return false;
				}	
				
				//Cost
				if( comboObjects[2].Code == ''){
					ComShowCodeMessage('PSO00010');
					comboObjects[2].focus();
					return false;
				}	
	
				if(comboObjects[3].Code == ''){		// comboObjects[4] -> 3 으로 변경완료
					ComShowCodeMessage('PSO00013');
					from_date.focus();
					return false;
				}	
	
	
				if(from_date.value == ''){
					ComShowCodeMessage('PSO00009');
					from_date.focus();
					return false;
				}	
	
				if(to_date.value == ''){
					ComShowCodeMessage('PSO00009');
					to_date.focus();
	
					return false;
				}	
	
				if( vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					vndr_seq.focus();
	
					return false;
				}	
	
				if( comboObjects[4].Code == ''){	// comboObjects[3] -> 4 으로 변경완료
					ComShowCodeMessage('PSO00012');
					combo5.focus();
	
					return false;
				}	
				
				if( sheetObjects[0].LastRow < sheetObjects[0].HeaderRows ){
					ComShowCodeMessage('PSO00017');	//Base에는 최소 한건의 데이터를 입력하셔야 합니다.
					return false;
				}
				
				for(i=sheetObjects[0].HeaderRows; i<sheetObjects[0].LastRow+1; i++){ 
					var prefix = "sheet1_";
					var object 			= sheetObjects[0].CellValue(i, prefix + "obj_list_no");
					var rate_code 		= sheetObjects[0].CellValue(i, prefix + "rate_code");
					var range_from 		= sheetObjects[0].CellValue(i, prefix + "range_from").replace(/[,:]/g, "");
					var range_to 		= sheetObjects[0].CellValue(i, prefix + "range_to").replace(/[,:]/g, "");
					var rate_value 		= sheetObjects[0].CellValue(i, prefix + "rate_value");
					var regular_value 	= sheetObjects[0].CellValue(i, prefix + "regular_value");

					if(i == sheetObj.HeaderRows){
						/*
					     *     ret = ComTrim("   121323    "); //결과 : "121323"
					     *     ret = ComTrim("*121323*", "*"); //결과 : "121323"
					     */
						if(ComTrim(object) == ""){
							ComShowCodeMessage("PSO00003", "[Base : Object]");	//필수
							return false;
						}
						
					}
					
					if(rate_code != "F" && range_from == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range From]");	//필수
						return false;
					}
					if(rate_code != "F" && range_to == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range To]");	//필수
						return false;
					}
					if(rate_value == ""){
						ComShowCodeMessage("PSO00003", "[Base : Rate]");	//필수
						return false;
					}
					
					if(Number(range_from) > Number(range_to)){
						ComShowCodeMessage("PSO00018", "[Base : Range To]", "[Base : Range From]");	//{?msg1} 값은 {?msg2} 값보다 커야 합니다.;
						return false;
					}
				}
				
				//Surcharge
				if(sheetObjects[1].RowCount > 0){	
					for(i=1; i<sheetObjects[1].RowCount+1; i++){		
						var prefix = "sheet2_";
						var method_code = sheetObjects[1].CellValue(i, prefix + "method_code");
						var rate_value  = sheetObjects[1].CellValue(i, prefix + "rate_value");
						var formula_no  = sheetObjects[1].CellValue(i, prefix + "formula_no");
						
						if(ComTrim(method_code) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Method]");	//필수
							return false;
						}
						
						if(ComTrim(rate_value) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Rate]");	//필수
							return false;
						}
	
						if(ComTrim(formula_no) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Formula ID]");	//필수
							return false;
						}
					}
				}
				
				//Discount
				if(sheetObjects[2].RowCount > 0){	
					for(i=1; i<sheetObjects[2].RowCount+1; i++){				
						var prefix = "sheet3_";
						var method_code = sheetObjects[2].CellValue(i, prefix + "method_code");
						var rate_value  = sheetObjects[2].CellValue(i, prefix + "rate_value");
						var formula_no  = sheetObjects[2].CellValue(i, prefix + "formula_no");
						
						if(ComTrim(method_code) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Method]");	//필수
							return false;
						}
						
						if(ComTrim(rate_value) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Rate]");	//필수
							return false;
						}
						
						if(ComTrim(formula_no) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Formula ID]");	//필수
							return false;
						}
					}
				}
	
				break;
				
			case IBDELETE: 
				if(port_cd.value == ''){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
	
				if( comboObjects[0].Code == ''){
					ComShowCodeMessage('PSO00008');
					combo1.focus();
					return false;
				}	
	
				if(vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					vndr_seq.focus();
	
					return false;
				}	
	
				if( comboObjects[4].Code == ''){// comboObjects[3] -> 4 으로 변경완료
					ComShowCodeMessage('PSO00012');
					combo5.focus();
	
					return false;
				}	
	
				break;
		}      
	}

	return true;
}

/********************************************************************************************************************
 * <OnLoadFinish : OnLoadFinish가 OnLoad보다 먼저 발생하여 문제가 되므로, 이의 해결을 위해 loadPage()에서 xsheet1_OnLoadFinish()을 호출함>                                       
 ********************************************************************************************************************
 * 1. 조회조건 Combo 또는 Sheet 內 Combo에 채울 값들을 가져온다.                                  
 * 2. VOP_PSO_0036 화면의 'Tariff Update' Button을 Click하여 호출된 경우라면, 조회조건 Setting과 검색이 동시에 이뤄진다.                                                     
 ********************************************************************************************************************/
function sheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	
	//Version Combo
	comboObjects[4].Enable = false;	// comboObjects[3] -> 4 으로 변경완료
	formObj.port_cd.focus();
	
	//VOP_PSO_0036에서 넘어왔다면..
	var movedFrom = formObj.moved_from.value;
	var movedParams = formObj.moved_params.value;
	if(movedFrom != ""){
		if(movedParams != ""){
			f_RetrieveMovedFrom(movedParams);	
		}
	}
	formObj.moved_from.value = "";
}

function sheet2_OnLoadFinish(sheetObj){
	document.getElementById("div_surcharge").style.display = "none";
}

function sheet3_OnLoadFinish(sheetObj){
	document.getElementById("div_discount").style.display = "none";
}

/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition1', '0,0', true, false, Row, Col, 1); 
		break;	 
	}
}

/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula 팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula2', '0,0', true, false, Row, Col, 1);
		break;	 

		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition2', '0,0', true, false, Row, Col, 1);
		break;	 
	}
}


/**
 * IBSheet Popup Event
 */
function sheet3_OnPopupClick(sheetObj,Row,Col){

	var prefix = "sheet3_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula 팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula3', '0,0', true, false, Row, Col, 1);
		break;	 

		case prefix + "condition" :				//Condition  팝업
			var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition3', '0,0', true, false, Row, Col, 1);
		break;	 
	}
}

function setCondition1(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet1_";
	var sheetObj = sheetObjects[0];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")= "";
		sheetObj.CellValue2(row,prefix+"cond_desc")= "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")= code;
		sheetObj.CellValue2(row,prefix+"cond_desc")= name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
	}
}
function setFormula2(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet2_";
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	
	if(code == "ID"){
		sheetObjects[1].CellValue2(row,prefix+"formula_no")= "";
		sheetObjects[1].CellValue2(row,prefix+"foml_desc")= "";
	} else{
		sheetObjects[1].CellValue2(row,prefix+"formula_no")= code;
		sheetObjects[1].CellValue2(row,prefix+"foml_desc")= name;
	}
}
function setCondition2(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet2_";
	var sheetObj = sheetObjects[1];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")= "";
		sheetObj.CellValue2(row,prefix+"cond_desc")= "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")= code;
		sheetObj.CellValue2(row,prefix+"cond_desc")= name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
	}
}
function setFormula3(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet3_";
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];

	if(code == "ID"){
		sheetObjects[2].CellValue2(row,prefix+"formula_no")= "";
		sheetObjects[2].CellValue2(row,prefix+"foml_desc")= "";
	} else{
		sheetObjects[2].CellValue2(row,prefix+"formula_no")= code;
		sheetObjects[2].CellValue2(row,prefix+"foml_desc")= name;
	}
}
function setCondition3(aryPopupData, row, col, sheetIdx){
	//setCond의 변형, sheetIdx는 안 맞음
	var prefix = "sheet3_";
	var sheetObj = sheetObjects[2];
	var code = aryPopupData[0][1];
	var name = aryPopupData[0][2];
	var riceStore = aryPopupData[0][7];	//2이면 쌀집에서 만든 데이터이므로  Condition생성팝업을 띄우지 않는다.
	if(code == "ID"){
		sheetObj.CellValue2(row,prefix+"condition")= "";
		sheetObj.CellValue2(row,prefix+"cond_desc")= "";
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = "";
	} else{
		sheetObj.CellValue2(row,prefix+"condition")= code;
		sheetObj.CellValue2(row,prefix+"cond_desc")= name;
		sheetObj.CellValue2(row,prefix+"upd_mnu_no_cond") = riceStore;
	}
}

/*
* Sheet Formula,Condition 칼럼 값 변경 조회.
*/
function f_SetCondFormulaDesc(sheetObj,prefix,Row,formcond,val){
	var param = "f_cmd="+SEARCH;
  param = param + "&formcond="+formcond+"&combo1="+val;
  
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0209GS.do", param );
	if (ComIsNull(ComGetEtcData(sXml, "id"))){
		if (formcond == "1"){
			sheetObj.CellValue2(Row, prefix + "formula_no") = "";
			sheetObj.CellValue2(Row, prefix + "foml_desc") = "";
		}else{
			sheetObj.CellValue2(Row, prefix + "condition") = "";
			sheetObj.CellValue2(Row, prefix + "cond_desc") = "";
		}
	}else{
		var code = ComGetEtcData(sXml, "id");
		var name = ComGetEtcData(sXml, "descript");
		if (formcond == "1"){
			sheetObj.CellValue2(Row, prefix + "formula_no") = code;
			sheetObj.CellValue2(Row, prefix + "foml_desc") = name;
		}else{
			var riceStore = ComGetEtcData(sXml, "upd_mnu_no_cond");
			sheetObj.CellValue2(Row, prefix + "condition") = code;
			sheetObj.CellValue2(Row, prefix + "cond_desc") = name;
			sheetObj.CellValue2(Row, prefix+"upd_mnu_no_cond") = riceStore;
		}
	}
}	
/**
 * 
 */
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :				//Condition 생성 팝업
		
			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}
		
			if(sheetObj.HeaderRows == Row){	//첫번째 행이면
				
				var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
				var sUrl = "/hanjin/VOP_PSO_0206.do?type=B&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
				sUrl += "&seq="+sheetObj.CellValue(Row,2);
				
				//Original
				//var rVal = ComOpenPopupWithTarget(surl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "", "0,0", false, false, Row, Col, 0);
			
				var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
				
				if(newCondNoAndCondDesc != undefined){
					sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
					sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
				}
			}

		break;
		
		case prefix + "del_chk" :				
			if(sheetObj.HeaderRows == Row){	//첫번째 행이면
				//두번째 행부터 조작
				if(sheetObj.CellValue(Row, prefix + "del_chk")){
					for(i=sheetObj.HeaderRows+1; i<sheetObj.LastRow+1; i++){
						sheetObj.CellValue2(i, prefix + "del_chk") = 0;
					}
				} else{
					for(i=sheetObj.HeaderRows+1; i<sheetObj.LastRow+1; i++){
						sheetObj.CellValue2(i, prefix + "del_chk") = 1;
					}
				}			
			} else{
				if(sheetObj.CellValue(Row, prefix + "del_chk") == 1){
					sheetObj.CellValue2(sheetObj.HeaderRows, prefix + "del_chk") = 0;
				}
			}
		
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));

		break;
	}
}
  
/**
 * 
 */
function sheet2_OnClick(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :	//Condition 생성 팝업
		
			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}

			var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
			var sUrl  = "/hanjin/VOP_PSO_0206.do?type=S&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
			    sUrl += "&seq="+sheetObj.CellValue(Row,2);

			var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
			
			if(newCondNoAndCondDesc != undefined){
				sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
				sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
			}
		
		break;
			
		case prefix + "del_chk" :			
			//Data영역이 체크해제되면 헤더도 체크해제된다.
	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
	
		break;	
	}
}


/**
 * IBSheet OnClick Event
 */
function sheet3_OnClick(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :	//Condition 생성 팝업

			var riceStore = sheetObj.CellValue(Row, prefix + "upd_mnu_no_cond");
			if(riceStore == "2"){	//쌀집에서 만든 Condition일 경우
				return; 
			}
			
			var condNo = sheetObj.CellValue(Row, prefix + "condition"); 
			var sUrl = "/hanjin/VOP_PSO_0206.do?type=D&cond_no=" + condNo + "&pop_title_0206=" + sheetObjects[0].UrlEncoding(POP_TITLE_0206);
			sUrl += "&seq="+sheetObj.CellValue(Row,2);

			var newCondNoAndCondDesc = ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
			
			if(newCondNoAndCondDesc != undefined){
				sheetObj.CellValue2(Row, prefix + "condition") = newCondNoAndCondDesc.split("||")[0];
				sheetObj.CellValue2(Row, prefix + "cond_desc") = newCondNoAndCondDesc.split("||")[1];
			}
			
		break;
		
		case prefix + "del_chk" :			
			//Data영역이 체크해제되면 헤더도 체크해제된다.
	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
	
		break;	
	}
}

/**
 * Yard
 */
function combo1_OnChange(){
	searchVersion();
	f_RemoveAllSheet();
}
 
function combo1_OnKeyDown(comboObj, KeyCode, Shift){
	
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");	//영문대문자,숫자만 입력 가능	
	if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
	}
} 

/**
 * Account CD
 */
function combo2_OnChange(){ 
	var formObject = document.form;
	formObject.account_nm.value = comboObjects[1].GetIndexText(comboObjects[1].Index, 1);

	//Cost Combo Setting
	addComboItemCost(comboObjects[1].Code);

	searchVersion();

	f_RemoveAllSheet();
	
	if(comboObjects[1].Index < 0){
		combo3_OnChange();
	}
}

/**
 * Combo Key-In or Copy&Paste 시, 입력문자제한 설정
 */ 
function combo2_OnKeyDown(comboObj, KeyCode, Shift){
	//document.form.vndr_lgl_eng_nm.value = "combo2_OnKeyDown : " + String.fromCharCode(KeyCode) + " : " + KeyCode;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
}  

/**
 * Cost CD
 */
function combo3_OnChange(){
	var formObject = document.form; 
	formObject.lgs_cost_nm.value = comboObjects[2].GetIndexText(comboObjects[2].Index, 1);
	searchVersion();
}
 
function combo3_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영문대문자만 입력 가능	
}  

/**
 * Version
 */
function combo5_OnChange(comb, Index_Code, Text){	// combo4 -> combo5 변경완료
	var formObject = document.form;
	
	var localCurrency = ComGetEtcData(searchVersionXML, "localCurrency" );

	var data = comb.GetIndexText(comb.Index, 1).split("~");	//DT 
	formObject.from_date.value = data[0];
	formObject.to_date.value   = data[1];
	
	var curr_cd = comb.GetIndexText(comb.Index, 2);					//CURR_CD 
 	if(curr_cd == "") curr_cd = localCurrency;						//Version 콤보에 Currency값이 없을 경우, 지역통화
 	if(curr_cd == "") curr_cd = "USD";								//지역통화가 없을 경우, "USD"
 	if(comboObjects[3].GetText(curr_cd, 0) == "") curr_cd = "USD";	//콤보에 데이터가 없을 경우, "USD"	// comboObjects[4] -> 3 으로 변경완료
	comboObjects[3].Code = curr_cd;
	
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem = comboItems[i].split(FIELDMARK);
		if(i == comb.Index){

			// Compulsory
			if (comboItem[4] == "Y") {	
				formObject.cpls_flg.checked = true;
			} 
			else {
				formObject.cpls_flg.checked = false;				
			}
			
//			[CHM-201429328] [PSO] Tariff Creation 화면에서 Invoice 생성 여부와 관계없이 Delete 버튼 활성화
//			if(comboItem[5] == ""){		//Delete Button
//				ComBtnEnable("btn_DataDelete");		
//			} else{						//Invoice 생성시, Delete 버튼 비활성화
//				ComBtnDisable("btn_DataDelete");
//			}
			
			if (comboItem[6] != undefined && comboItem[6] != "") {
				/*
				var arrOrg = new Array();	//Origin에 ,가 있을 수 있으므로 (index=6 이상인 것)
				for(k=6; k<comboItem.length; k++){
					arrOrg[k-6] = comboItem[k];
				}
				formObject.org_vndr_nm.value = arrOrg.join(",");
				*/
				formObject.org_vndr_nm.value = comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
			} 
			else {
				formObject.org_vndr_nm.value = "";
			}
			
			// URL
			if (typeof(comboItem[7]) != "undefined") {
				ComSetObjValue(formObject.port_trf_url, comboItem[7]);
			}
			else {
				ComSetObjValue(formObject.port_trf_url, "");
			}
			
			// Remark
			if (typeof(comboItem[8]) != "undefined") {
				
				// ==========================================================================================
				// 필드구분자로 ',' 를 사용하기 때문에, Remark 에 ',' 를 사용할 경우 오류가 발생됨.
				// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
				// ==========================================================================================				
				var portTrfRmk = comboItem[8];
				if (portTrfRmk.indexOf("^") > -1) {
					portTrfRmk = portTrfRmk.split("^").join(",");
				}
				//===========================================================================================
				ComSetObjValue(formObject.port_trf_rmk, portTrfRmk);
			}
			else {
				ComSetObjValue(formObject.port_trf_rmk, "");
			}
			
			// Contract/Regulation
			if (typeof(comboItem[9]) != "undefined") {

				// ==========================================================================================
				// 필드구분자로 ',' 를 사용하기 때문에, 파일명 구분자에 ',' 를 사용할 경우 오류가 발생됨.
				// 그래서, ',' 문자를 '^' 문자로 변환해서 전송해주기 때문에 이전 문자로 복원해야 됨.
				// ==========================================================================================				
				var contract = comboItem[9];
				if (contract.indexOf("^") > -1) {
					contract = contract.split("^").join(",");
				}
				//===========================================================================================
				ComSetObjValue(formObject.contract, contract);
			}
			else {
				ComSetObjValue(formObject.contract, "");
			}			
			
			break;
		}
	}
}

/*
 * Currency
 */ 
function combo4_OnKeyDown(comboObj, KeyCode, Shift) {// combo5 -> combo4 변경완료
	 gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영문대문자만 입력 가능	
}   

/**
 * Version 조회
 */
function searchVersion(){
	 
	var formObj = document.form;
	comboObjects[4].RemoveAll();	// comboObjects[3] -> 4 으로 변경완료

	formObj.f_cmd.value = COMMAND02;
	var port_cd = formObj.port_cd.value;
	var yard_cd = comboObjects[0].Code;
	var acct_cd = comboObjects[1].Code;
	var cost_cd = comboObjects[2].Code;
	var vndr_seq = formObj.vndr_seq.value;
 	
	if(port_cd == "" || yard_cd == "" || acct_cd == "" || cost_cd == "" || vndr_seq == ""){
		//return;
	}
	
	//1.Combo OnChange
	//searchVersionXML = sheetObjects[0].GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
	//2.Combo OnChange 발생시, Focus 잃지 않게 하기 (초기화되지 않은 Dummy Sheet 이용)
	searchVersionXML = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
 	
	//Simple, Complex 따지기 	 
 	var errorMessage = ComGetEtcData(searchVersionXML, "errorMessage" );
 	if(errorMessage != undefined && errorMessage != ""){
 		ComShowCodeMessage("PSO00025", "[Complex Tariff]");	//"This data is already input to {?msg1}.";
 		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 
 		return;
 	}
	
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>

	if( comboItems != "" ){ 
		addComboItemVersion(comboObjects[4],comboItems);// comboObjects[3] -> 4 으로 변경완료
		formObj.yd_chg_no.value = comboItems[0].split(FIELDMARK)[0]	;		
	} else{
		comboObjects[4].InsertItem(0, "001|" + ComGetNowInfo() + "~" + "9999" + "-12-31", "001");// comboObjects[3] -> 4 으로 변경완료
		formObj.yd_chg_no.value = "";
	}
	comboObjects[4].Index = 0;// comboObjects[3] -> 4 으로 변경완료
	
	/*
     * ret = ComGetDateAdd(null, "D", -6)                //결과 : "2008-11-04", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd(null, "M", -6)                //결과 : "2008-05-10", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd(null, "Y", -6)                //결과 : "2002-11-10", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd("날짜아님", "Y", -6)          //결과 : "" , 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd("2008-01-01", "D", 365, "")   //결과 : "20081231"
	 */
	
	/* function ComGetNowInfo(sFormat, sDelim)
	 * ret = ComGetNowInfo()           //결과 : 2008-11-10
	 * ret = ComGetNowInfo("yy" )      //결과 : 2008
	 * ret = ComGetNowInfo("mm" )      //결과 : 11
	 * ret = ComGetNowInfo("dd" )      //결과 : 10
	 * ret = ComGetNowInfo("hh" )      //결과 : 19
	 * ret = ComGetNowInfo("mi" )      //결과 : 15
	 * ret = ComGetNowInfo("ss" )      //결과 : 31
	 * ret = ComGetNowInfo("ymd")      //결과 : 2008-11-10
	 * ret = ComGetNowInfo("ym" )      //결과 : 2008-11
	 * ret = ComGetNowInfo("hms")      //결과 : 19:15:31
	 * ret = ComGetNowInfo("hm" )      //결과 : 19:15
	 * ret = ComGetNowInfo("ymd", "/") //결과 : 2008/11/10
	 */		
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

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */
function obj_blur(){

	var formObj = document.form;
	obj = event.srcElement;      	

	with(formObj){
		if(obj.name=="from_date" || obj.name=="to_date"){
			var creDtFr = ComReplaceStr(from_date.value,"-","");
			var creDtTo = ComReplaceStr(to_date.value,"-","");

			switch(obj.name) {

			case "from_date":	// Agreement From Date
			if(creDtFr != '' && creDtTo != ''){
				if(creDtFr > creDtTo){
					ComShowCodeMessage('COM12133','To date','From date','greater');
					from_date.value='';
					from_date.focus();
				}
			}

			break;

			case "to_date":	// Agreement To Date
			if(creDtFr != '' && creDtTo != ''){
				if(creDtFr > creDtTo){
					ComShowCodeMessage('COM12133','To date','From date','greater');
					to_date.value='';
					to_date.focus();
				}
			}
			break;	
			}

			ComChkObjValid(event.srcElement);
		}

		switch(obj.name) {

//			case "port_cd":		//영문대문자가 아니면 Clear
//				var val = obj.value; 
//				for(var i=0; i<val.length; i++) {
//					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
//						formObj.port_cd.value = "";
//						formObj.port_cd.focus();
//						break;
//					}
//				}
//			break;
			
			case "vndr_seq":	//Servicce Provider
				if(obj.value != ""){
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
					searchVersion();
				} else{
					formObj.vndr_lgl_eng_nm.value = "";
					searchVersion();
				}
			break;
		}	
	}
}

function obj_click(){

	var formObj = document.form;
	obj = event.srcElement;      	

	with(formObj){
		if(obj.name=="cSur"){
			if(cSur.checked){
				 if(validateForm(sheetObjects[1],formObj,IBSEARCH)){
					 document.getElementById("div_surcharge").style.display = "inline";
					 surRowAdd.fireEvent('onclick'); //btn_RowAdd2(Surcharge) Event 발생
				 }else{
					 cSur.checked = false;
				 }
			} else{	//Uncheck의 목적은 Surcharge Data를 삭제하는 것임
				document.getElementById("div_surcharge").style.display = "none";
				sheetObjects[1].RemoveAll();
			}
		}
		if(obj.name=="cDis"){
			if(cDis.checked){
				if(validateForm(sheetObjects[2],formObj,IBSEARCH)){
					 document.getElementById("div_discount").style.display = "inline";
					 disRowAdd.fireEvent('onclick'); //btn_RowAdd3(Discharge) Event 발생
				 }else{
					 cDis.checked = false;
				 }
			} else{	//Uncheck의 목적은 Discount Data를 삭제하는 것임
				document.getElementById("div_discount").style.display = "none";
				sheetObjects[2].RemoveAll();
			}
		}
	}
} 

function setEnableControl4Columns(sheetObj, cols){
 	var arrCol = cols.split("|");
 	for(row=sheetObj.HeaderRows; row<sheetObj.HeaderRows + sheetObj.RowCount; row++){
		if(row > sheetObj.HeaderRows){	//첫번째 행이 아니면
			for(i=0; i<arrCol.length; i++){
				sheetObj.CellEditable(row, arrCol[i]) = false; 
			}
			
			sheetObj.CellValue2(row, "sheet1_seq") = "";
			
			sheetObj.InitCellProperty(row , "sheet1_obj_list_no", dtData , daCenter , "sheet1_obj_list_no" ); 
			sheetObj.CellValue2(row, "sheet1_obj_list_no") = "";

			sheetObj.CellValue2(row, "sheet1_object_code_dsp") = "";
			
			sheetObj.InitCellProperty(row , "sheet1_rate_code", dtData , daCenter , "sheet1_rate_code" ); 
			sheetObj.CellValue2(row, "sheet1_rate_code") = "";
		
			sheetObj.CellValue2(row, "sheet1_regular_value") = "";

			sheetObj.CellValue2(row, "sheet1_condition") = "";
			
			sheetObj.CellValue2(row, "sheet1_cond_desc") = "";
			
			sheetObj.InitCellProperty(row , "sheet1_upd_mnu_no_cond", dtData , daCenter , "sheet1_upd_mnu_no_cond" ); 
			sheetObj.CellValue2(row, "sheet1_upd_mnu_no_cond") = "";
		
		} else{	//첫번째 행이면
			for(i=0; i<arrCol.length; i++){
				sheetObj.CellEditable(row, arrCol[i]) = true; 
			}		
			
			if(sheetObj.CellValue(row, "sheet1_rate_code") == "F"){
				ComBtnDisable("btn_RowAdd");
				sheetObj.CellEditable(row, "sheet1_range_from") = false; 
				sheetObj.CellEditable(row, "sheet1_range_to") = false; 
			}
		}
 	}

}


/**
 * 
 */
function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
	
		case prefix + "obj_list_no" :
			
			var arrComboText = sheetObj.GetComboInfo(Row, Col, "Text").split("|"); 
			var idx   		 = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			
			if(idx == -1){
				return;
			}
			sheetObj.CellValue(Row, prefix + "object_code_dsp") = arrComboText[idx].split("\t")[1];
			

		break;
		
		case prefix + "object" :	//[업무변경으로 삭제됨]

			var comboItems = ComGetEtcData(conditionXML, "uomlist");
			var arrCodeTextUOM = makeItemUOM(comboItems, sheetObj.CellValue(Row, Col));
			sheetObj.CellComboItem(Row, prefix + "object_code" , arrCodeTextUOM[1], arrCodeTextUOM[0], 0);

		break;
		
		case prefix + "object_code_dsp" : 	//UOM변경시 Range(From/To) Type 바꿈
			sheetObj.Redraw = false;
			for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow+1; i++){
				f_SetCellProperty(sheetObj, i);
				//Range Clear
				sheetObj.CellValue2(i, prefix + "range_from") = "";
				sheetObj.CellValue2(i, prefix + "range_to") = "";
			}
			sheetObj.Redraw = true; 
		break;
		
		case prefix + "rate_code" :
			
			if(sheetObj.CellValue(Row, Col) == "F"){		//Fixed
				if(sheetObj.LastRow > sheetObj.HeaderRows){	//여러줄 입력됨
					if(confirm(msgs["PSO00028"])){	//"Rate Type을 Fixed로 변경하면 첫째행을 제외한 나머지는 삭제됩니다. 계속 하시겠습니까?"
						//첫번째 행 제외 삭제
						for( var i=sheetObj.LastRow; i>=sheetObj.HeaderRows; i-- ) {
							if(i != sheetObj.HeaderRows){
								sheetObj.RowDelete( i, false );
							}
						}
						ComBtnDisable("btn_RowAdd");
						sheetObj.CellEditable(Row, prefix + "range_from") = false;
						sheetObj.CellEditable(Row, prefix + "range_to") = false;
						sheetObj.CellValue2(Row, prefix + "range_from") = "";
						sheetObj.CellValue2(Row, prefix + "range_to") = "";
						
					} else{
						sheetObj.CellValue2(Row, Col) = gSheet1_rate_code;	//Fixed로 변경하지 않고, 이전 값으로 세팅
					}
				} else if(sheetObj.LastRow == sheetObj.HeaderRows){
					ComBtnDisable("btn_RowAdd");
					sheetObj.CellEditable(Row, prefix + "range_from") = false;
					sheetObj.CellEditable(Row, prefix + "range_to") = false;
					sheetObj.CellValue2(Row, prefix + "range_from") = "";
					sheetObj.CellValue2(Row, prefix + "range_to") = "";
				}
			} else{
				ComBtnEnable("btn_RowAdd");
				sheetObj.CellEditable(Row, prefix + "range_from") = true;
				sheetObj.CellEditable(Row, prefix + "range_to") = true;
			}

		break;
	}
}
 
function sheet1_OnBeforeEdit(sheetObj, Row,Col){
	
	var formObj = document.form;
	var prefix = "sheet1_";
	
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "rate_code" :
			gSheet1_rate_code = sheetObj.CellValue(Row,Col);
		break;

	}
}


/**
 * 
 */
function sheet2_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "method_code" :
			if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[0];	//Formula_No = 1
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[1];	//Formula_No = 1
			} else if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[2];	//Formula_No = 2
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[3];	//Formula_No = 2
			}
			break;
	}
}


/**
 * 
 */
function sheet3_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "method_code" :
			if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[0];	//Formula_No = 1
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[1];	//Formula_No = 1
			} else if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.CellValue2(Row, prefix + "formula_no") = arrFormulaNo[2];	//Formula_No = 2
				sheetObj.CellValue2(Row, prefix + "foml_desc")  = arrFormulaNo[3];	//Formula_No = 2
			}
			break;
	}
}

function sheet1_OnAfterEdit(sheetObj, Row, Col){
	
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
			 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "range_from" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
		
		case prefix + "range_to" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
			
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;

		case prefix + "regular_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"2",val);
		break;	
	}	
} 

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	//It's not used because of Copy & Paste problem.
	return;
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {	
		case prefix + "range_from" :
			var val = sheetObj.EditValue;
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;	
		
		case prefix + "range_to" :
			var val = sheetObj.EditValue;
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
			
		case prefix + "rate_value" :
			var val = sheetObj.EditValue;
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;

		case prefix + "regular_value" :
			var val = sheetObj.EditValue;
			if(!f_SetCipherLess(val, 10, 4)){	//정수부분 10자리 이하, 소수부분 4자리 이하
				sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
	}
}

/**
* Row 변경시
*/ 
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
	if(OldRow == NewRow){
		//return;
	}
	
	if(sheetObj.RowCount < 1){
		return;
	}
	
	var prefix = "sheet1_";

	f_SetCellProperty(sheetObj, NewRow);
	
	switch (sheetObj.ColSaveName(NewCol)) {
	}
}

function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
		
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
		case prefix + "formula_no" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"1",val);
			break;	
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"2",val);
			break;	
		
	}	
} 

function sheet3_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
		
		case prefix + "rate_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
		case prefix + "formula_no" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"1",val);
			break;	
		case prefix + "condition" :
			var val = sheetObj.CellValue(Row, Col);
			f_SetCondFormulaDesc(sheetObj,prefix,Row,"2",val);
			break;	
		
	}	
} 


/*
 *  정수부분, 소수부분 자리수 이하 설정
 */
function f_SetCipherLess(val, integerPlace, decimalPlace){
	var arrVal = val.split(".");
	
	if(arrVal.length == 1){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
	} else if(arrVal.length == 2){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
		if(arrVal[1].length > decimalPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
			return false;
		}
	}	
	return true;
}
 
 /**
  * vendor 팝업설정
  */
function setVendorSeq(aryPopupData, row, col, sheetIdx){
	/*COM_ENS_0C1.do 팝업 호출시 
	var formObj = document.form;
	formObj.vndr_seq.value = aryPopupData[0][2];
	formObj.vndr_lgl_eng_nm.value = aryPopupData[0][4];
	combo3_OnChange();
	*/
	
	/*VOP_PSO_0205.do*/
	var formObj = document.form;
	formObj.vndr_seq.value = aryPopupData[0][1];
	formObj.vndr_lgl_eng_nm.value = aryPopupData[0][2];
	combo3_OnChange();	
} 

/*
 * 
 */ 
function f_SetComboAccount(portCd){ 
	//GLOBAL conditionXML
	if( portCd == 'EGSUZ' ||  portCd == 'PAPAC' ){
		//Account
		comboObjects[1].Text = ""; 
		comboObjects[1].Enable = false; 
		form.account_nm.value = "";
		//Cost
		comboObjects[2].Enable = true;
		form.lgs_cost_nm.value = "";
		
		addComboItemAccount("CANAL_O");
	} else {
		//Account
		comboObjects[1].Enable = true; 
		form.account_nm.value = "";
		//Cost
		comboObjects[2].Text = ""; 
		comboObjects[2].Enable = false;
		form.lgs_cost_nm.value = "";
		
		addComboItemAccount("CANAL_X");	
	}			

}

function f_SetComboObjectCode(sheetObj, Row, Col){	
	var prefix = "sheet1_";
	var comboItems = ComGetEtcData(conditionXML, "uomlist");
	var arrCodeTextUOM = makeItemUOM(comboItems, sheetObj.CellValue(Row, Col));
	var uom = sheetObj.CellValue(Row, prefix + "uom");
	sheetObj.CellComboItem(Row, prefix + "object_code" , arrCodeTextUOM[1], arrCodeTextUOM[0], 0);
	if(uom != ""){
		sheetObj.CellValue2(Row, prefix + "object_code") = uom;
	}	
}

function f_RetrieveAfterCopy(){		
	var formObject = document.form;
	var param = formObj.copy_condition.value;
	doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
}

/*
* 모든 Sheet 지우기
* @History 
*  -김차장님 요청(임시) : Param section 추가 (Key변경시 return,  New Click시 clear)
*/
function f_RemoveAllSheet(section){
	/******************************/
	if(section == undefined){
		return;
	} else if(section == "IBCLEAR"){
		//지우기
	}
	/******************************/
	
	var formObject = document.form;
	//Sheets	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	document.getElementById("cSur").checked = false;
	document.getElementById("cDis").checked = false;
	document.getElementById("div_surcharge").style.display = "none";
	document.getElementById("div_discount").style.display = "none";	
	ComBtnEnable("btn_RowAdd");
	formObject.cpls_flg.checked = false;
}

function f_ShowHideSheet(){ 
	if(sheetObjects[1].RowCount > 0){
		document.getElementById("cSur").checked = true;
		document.getElementById("div_surcharge").style.display = "inline";
	} else{		
		document.getElementById("cSur").checked = false;
		document.getElementById("div_surcharge").style.display = "none";
	}
	
	if(sheetObjects[2].RowCount > 0){
		document.getElementById("cDis").checked = true;
		document.getElementById("div_discount").style.display = "inline";
	} else{		
		document.getElementById("cDis").checked = false;
		document.getElementById("div_discount").style.display = "none";
	}
	
	if(sheetObjects[0].RowCount > 0){
		document.form.cpls_flg.checked = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_cpls_flg") == "Y" ? true : false;
	} else{
		document.form.cpls_flg.checked = false;
	}
}	
 
/*
 * VOP_PSO_0036에서 호출했을 경우
 */ 
function f_RetrieveMovedFrom(movedParams){
	var formObj = document.form; 
	var arrMovedParams = movedParams.split("||");	//key::val
	for(i=0; i<arrMovedParams.length; i++){
		var key_val = arrMovedParams[i].split("::");
		var key = key_val[0];
		var val = key_val[1];
		//Port
		if(key == "port_cd"){
			formObj.port_cd.value = val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
		}
		//Yard
		if(key == "yd_cd"){
			comboObjects[0].Code = val; 
		}
		
		//Account
		if(key == "acct_cd"){
			comboObjects[1].Code = val; 
		}
		
		//Cost
		if(key == "cost_cd"){
			comboObjects[2].Code = val; 
		}

		//Service Provider
		if(key == "vndr_seq"){					
			formObj.vndr_seq.value = val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
		}
	}
	ComOpenWait(true);
	searchVersion();
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	ComOpenWait(false);
}

/*	
 * UOM에 따라 Range의 Type변경 (시간, 숫자)
 */
function f_SetCellProperty(sheetObj, row){
	var prefix = "sheet1_";
	var val = sheetObj.CellValue(sheetObj.HeaderRows, prefix + "object_code_dsp");	//UOM
 	var type = "";
 	
	if(val == "TIME"){
		sheetObj.InitCellProperty(row, prefix + "range_from", dtNull, daCenter,  prefix + "range_from" , "", dfTimeHm);
		sheetObj.InitCellProperty(row, prefix + "range_to", dtNull, daCenter,  prefix + "range_to" , "", dfTimeHm);
	} else{			
		sheetObj.InitCellProperty(row, prefix + "range_from", dtNull, daCenter,  prefix + "range_from" , "", dfNumber);
		sheetObj.InitCellProperty(row, prefix + "range_to", dtNull, daCenter,  prefix + "range_to" , "", dfNumber);
	}
	
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