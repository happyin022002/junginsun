/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0212.js
 *@FileTitle : Tariff Copy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.24
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.03 박명종
 * 1.0 Creation
 * 
 * History
 * 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
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
function VOP_PSO_0212() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;    	
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
﻿// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var gColumnCountInSheet2 = 0;	//sheet2의 Column Count

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var TerminalList = "";
var AccountList = "";
var ObjList = "";
var conditionXML = "";		//페이지로딩시 조회조건 세팅용 쿼리 결과
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
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObj,IBSEARCH);
				break;
			case "btn_New":
				//alert("Do you need me?");
				break;
			case "btn_Ok":
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("PSO00019");
					return;
				}
				var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(SEARCH);				//Command
		    		param += "&port_cd="  + sheetObjects[0].UrlEncoding(formObj.port_cd.value);	//Port
		    		param += "&combo1="   + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 	//Yard
		    		param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);//Service Provider
//param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
//		    		param += "&combo4="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code); 	//Version 
		    		param += "&combo5="   + sheetObjects[0].UrlEncoding(comboObjects[3].Code); 	//Version 
		    		param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
		    		param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(0,10)); 	//From Date 
			    	param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(11)); 	//To Date
		    		param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID
		    		
		    	var opForm = opener.document.form;
				opForm.copy_condition.value = param;	
				
				opener.f_RetrieveAfterCopy();
				self.close();
					
				break;
			case "btn_close":
				self.close();
				break;
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

	initControl(sheetObjects[0]);  
	xsheet1_OnLoadFinish(sheetObjects[0]);
}

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  {object} sheetObj	필수
 * @return 없음
 * @author 김창식
 * @version 2009.05.20
 */
function initControl(sheetObj){
	// Form 객체 선언
	var formObj = document.form;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('click', 'obj_click', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form);
	axon_event.addListenerForm  ('drop', 'obj_drop', form);
	//load Terminal List..
	setToday(formObj.year, "y");

}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form
	switch(comboNo) {  
		case 1: 
			with (comboObj) { 
				//MultiSelect = true; 
				MultiSeparator = "|";
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("40|300");
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자
				MaxLength = 2;
			}
	
			break; 
		case 2: 
			with (comboObj) { 
				//MultiSelect = true; 
				MultiSeparator = "|";
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
			}
			
			break; 
		case 3:		//Account 
			with (comboObj) { 
			MultiSeparator = "|";
			UseAutoComplete = true;
			UseCode = true;
			DropHeight = 190;
			
			}
			break; 			
		case 4: 
			with (comboObj) { 
				//MultiSelect = true; 
				MultiSeparator = "|";
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
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
		case "y": case "ym": case "ymd":
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
			if(obj.name=="vsl_slan_cd") ComKeyOnlyAlphabet('uppernum')
			else ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
	}
}


/**
 * 콤보필드에 데이터를 추가해준다. (Currency)
 */	
function addComboItem(comboObj,comboItems) {
	if(!comboItems || ""==comboItems){
		comboObj.Enable = false;
		return false;
	}
	
	if(!comboObj.Enable){
		comboObj.Enable = true;
	}
		
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}

 /**
  * 콤보필드에 데이터를 추가해준다. (Object/Method in Sheets)
  */	
 function makeItemObject(comboItems) {	
 	var comboCode= "";
 	var comboText= "";
 	
 	//comboItems = " , |" + comboItems;
 	
 	arrComboItems = comboItems.split("|");
 	var preCode = "";
 	for (i = 0 ; i < arrComboItems.length ; i++) {
 		var comboItem = arrComboItems[i].split(",");
 		if(preCode != comboItem[0]){
 			comboCode += "|" + comboItem[0];
 			comboText += "|" + comboItem[1];
 		}
 		preCode = comboItem[0];
 	}  
 	
 	comboCode = comboCode.substr(1);	//Code
 	comboText = comboText.substr(1); 	//Text
 	
 	return new Array(comboCode, comboText);
 }
  
  /**
   * 콤보필드에 데이터를 추가해준다. (Object/Method in Regular Value Sheet)
   */	
  function makeItemObjectInRegVal(comboItems) {	
  	var comboCode= "";
  	var comboText= "";
  	
  	arrComboItems = comboItems.split("|");
  	var preCode = "";
  	for (i = 0 ; i < arrComboItems.length ; i++) {
  		var comboItem = arrComboItems[i].split(",");
  		//if(preCode != comboItem[0]){
  			comboCode += "|" + comboItem[4];
  			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
  		//}
  		//preCode = comboItem[0];
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
		case "year":
			if(eleObj.value.length == 4){
				searchVendor();
				searchVersion();
				f_RemoveAllSheet();
				f_HideSheets();
			}
			break;
		case "se_prv":
			if(eleObj.value.length == 8){
				formObj.from_date.focus();
			}
			break;
		case "from_date":
			if(eleObj.value.length == 8){
				formObj.to_date.focus();
			}
			break; 
		case "to_date":
			if(eleObj.value.length == 8){
				formObj.port_cd.focus();
			}
			break;
		case "port_cd":
			if(eleObj.value.length == 5){
				formObj.yd_cd.value = eleObj.value;
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
				doActionIBCombo(sheetObjects[0], formObj,COMMAND01, formObj.acct_or_cost_cd,COMMAND01,"accountAndCost","");	// Account Code Combo
			} else{
				comboObjects[0].RemoveAll();
			}
			f_RemoveAllSheet();
			break;
	}
}

function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch (eleObj.name) {
			
		case "year":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;
	}
}

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
}

function obj_click(){

	var formObj = document.form;
	obj = event.srcElement;      	

	with(formObj){
		if(obj.name=="cBase"){
			if(cBase.checked){
				document.getElementById("div_base").style.display = "inline";
			} else{
				document.getElementById("div_base").style.display = "none";
			}
		}
		if(obj.name=="cSur"){
			if(cSur.checked){
				document.getElementById("div_surcharge").style.display = "inline";
			} else{
				document.getElementById("div_surcharge").style.display = "none";
			}
		}
		if(obj.name=="cDis"){
			if(cDis.checked){
				document.getElementById("div_discount").style.display = "inline";
			} else{
				document.getElementById("div_discount").style.display = "none";
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
			//style.height = 82;	//Origin
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
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"default2",   	false,	"",			dfNone,			0,		true,  true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtPopup,		120,		daCenter,	true,		prefix+"formula_no",	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"foml_desc",  	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtPopup,		110,		daCenter,	true,		prefix+"condition",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,			70,		daLeft,		true,		prefix+"cond_desc",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"cpls_flg");
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"uk",   			false,	"",			dfNone,			0,		false, false);	//Unique, Hidden

			CountPosition = 0;
			ShowButtonImage = 1;
		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			//style.height = 212;
			style.height = 215;

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
			gColumnCountInSheet2 = headCount;

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

	case "sheet3":			//Regular Value
		with (sheetObj) {
			// 높이 설정
			//style.height = 85;
			style.height = 125;

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

	case "sheet4":
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

	case "sheet5":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;

			//전체 너비 설정

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

	case "sheet6":		//Base Dummy
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

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, etc) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
			var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");       
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
			
			var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(SEARCH);				//Command
		    	param += "&port_cd="  + sheetObjects[0].UrlEncoding(formObj.port_cd.value);	//Port
		    	param += "&combo1="   + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 	//Yard
		    	param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);	//Service Provider
		    	param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
//		    	param += "&combo4="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code); 	//Version 
		    	param += "&combo5="   + sheetObjects[0].UrlEncoding(comboObjects[3].Code); 	//Version 
		    	param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
		    	param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(0,10)); 	//From Date 
		    	param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(11)); 	//To Date
		    	param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID 
		    	param += "&acct_cd="  + sheetObjects[0].UrlEncoding(comboObjects[2].Code); 	//Account Code 쿼리 조회조건에 조회되도록 추가 
				f_RemoveAllSheet(); 
				//VOP_PSO_0036.do의 IFRAME에서 호출하는 경우
			    if(etc != undefined && etc != ""){
			    	param = etc;
			    }
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				
				sheetObjects[0].WaitImageVisible = true;
				sheetObjects[5].WaitImageVisible = false;
				sheetObjects[2].WaitImageVisible = false;
				sheetObjects[3].WaitImageVisible = false;
				sheetObjects[4].WaitImageVisible = false;
				
				sheetObjects[0].Redraw = false;
				sheetObjects[5].Redraw = false;
				sheetObjects[2].Redraw = false;
				sheetObjects[3].Redraw = false;
				sheetObjects[4].Redraw = false;
				
				sheetObjects[0].LoadSearchXml(arrXml[0]); 

				sheetObjects[5].LoadSearchXml(arrXml[1]); 

				sheetObjects[2].LoadSearchXml(arrXml[2]); 
				
				sheetObjects[3].LoadSearchXml(arrXml[3]); 
				
				sheetObjects[4].LoadSearchXml(arrXml[4]); 
				
				if(sheetObjects[0].RowCount > 0){
					f_CopyDummy2Base(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_uk"));
				}
			
				sheetObjects[0].Redraw = true;
				sheetObjects[5].Redraw = true;
				sheetObjects[2].Redraw = true;
				sheetObjects[3].Redraw = true;
				sheetObjects[4].Redraw = true;
				
				f_AfterRetrieve();
		break;
		case IBSEARCH_ASYNC01:   
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_");
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0212GS.do", param );
			var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
			ComOpenWait(false);			
			
			//콤보필드를 초기화시킨다.
			comboObjects[0].RemoveAll();
			addComboItem(comboObjects[0],comboItems);	
			
			comboObjects[0].Code2 = formObj.ydCd.value; 
			
			searchVendor();
			comboObjects[1].Code = formObj.vndr_seq.value;

			////각종 sheet내 콤보 조회////
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			

			conditionXML = sheetObj.GetSearchXml("VOP_PSO_0004GS.do", param );
			var arrXml = conditionXML.split("|$$|");
			
			//Object Setting in Sheets (1, 2)
			var comboItems = ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject = makeItemObject(comboItems);
	
			//Object Setting in Sheet Regular Value
			comboItems = ComGetEtcData(conditionXML, "objListByTpCd");
			arrCodeTextObject = makeItemObjectInRegVal(comboItems);
	
			//
			var arrFormula4Loading = ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k = 0;
			for(i=0; i<arrFormula4Loading.length; i++){
				arrKeyVal = arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k] = arrKeyVal[j];
					k++;             
				}             
			}

			
		break;
	
		case COMMAND05:	//Port Code [keyup:5자리]
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
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
			var spName = ComGetEtcData(sXml, "spName");		//Service Provider Name
			formObj.vndr_lgl_eng_nm.value = spName;
		
			if (spName != "") {
		
			} 
			else {
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				formObj.vndr_seq.focus();
				formObj.vndr_seq.value = "";
			}
			
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
				
				//Yard
				if( comboObjects[0].Code == ''){
					ComShowCodeMessage('PSO00008');
					com_yd_cd.focus();
					return false;
				}	
				
				//Vendor
				if( comboObjects[1].Code == ''){
					ComShowCodeMessage('PSO00011');
					com_vendor.focus();
					return false;
				}	
				
				//Year
				if(year.value == '' || year.value.length != 4){
					ComShowCodeMessage('PSO00003');
					year.focus();
	
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
 *                                                    
 ********************************************************************************************************************/
function xsheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	var port = document.getElementById("port_cd").value;
	
	if(port == "PAPAC" || port == "EGSUZ"){
		document.getElementById("acct_or_cost_caption").innerText = "Cost Code";
		document.getElementById("acct_or_cost_cd").value = document.getElementById("cost_cd").value;
		document.getElementById("acct_or_cost_nm").value = document.getElementById("cost_nm").value;		
	} else{		
		document.getElementById("acct_or_cost_caption").innerText = "Account Code";
		document.getElementById("acct_or_cost_cd").value = document.getElementById("param_acct_cd").value;
		document.getElementById("acct_or_cost_nm").value = document.getElementById("param_acct_nm").value;
	}
	
	if(formObj.caller.value != "IFRAME"){
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	}
	
	loadAccount();
	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

function sheet2_OnLoadFinish(sheetObj){
	var formObj = document.form;
	if(formObj.caller.value == "IFRAME"){
		document.getElementById("div_surcharge").style.display = "inline";
	} else{
		document.getElementById("div_surcharge").style.display = "none";
	}
}

function sheet3_OnLoadFinish(sheetObj){
	var formObj = document.form;
	if(formObj.caller.value == "IFRAME"){
		document.getElementById("div_discount").style.display = "inline";	
	} else{		
		document.getElementById("div_discount").style.display = "none";	
	}
}

/**
* Row 변경시
*/ 
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
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

/**
 * Yard Combo
 */ 
function com_yd_cd_OnChange(comboObj, Index_Code, Text){
	searchVendor();
	searchVersion();
	f_RemoveAllSheet();
	f_HideSheets();
}
 
function com_yd_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");	//영문대문자,숫자만 입력 가능	
}

/**
 * Vendor Combo
 */
function com_vendor_OnChange(comb, Index_Code, Text){
	 var formObj = document.form;
	 
	 formObj.vndr_nm.value = comb.GetText(Index_Code, 1);
	 searchVersion(); 
	 f_RemoveAllSheet();
	 f_HideSheets();
}

/**
 * Version Combo
 */
function ver_OnChange(comb, Index_Code, Text){
	
	var formObject = document.form;

	var data = comb.GetIndexText(comb.Index, 1);	//DT 
	formObject.eff_date.value = data;
	
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem = comboItems[i].split(FIELDMARK);
		if(i == comb.Index){
			if(comboItem[4] == "Y"){	//Compulsory
				formObject.cpls_flg.checked = true;
			} else{
				formObject.cpls_flg.checked = false;				
			}
			
			break;
		}
	}
	
	f_RemoveAllSheet();
	f_HideSheets();
}

/**
* 콤보필드에 데이터를 추가해준다.(Version 전용)
*/	
function addComboItemVersion(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		//Text : Version|FromDt~ToDt|Curr_Cd
		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3], comboItem[1] );
		//최신 Version만 보여주기로 함
		//if(i == 0) break;
	}   		
}

/**
 * Version 조회
 */
function searchVersion(){
	var formObj = document.form;
//	comboObjects[3].RemoveAll();

	formObj.f_cmd.value = COMMAND02;
	
	var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(COMMAND02);				//Command
	    param += "&port_cd="   + sheetObjects[0].UrlEncoding(formObj.port_cd.value);//Port
        param += "&combo1="   + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 	//Yard
        param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);//Service Provider
        param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
        param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
        param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID 
        param += "&acct_cd="  + sheetObjects[0].UrlEncoding(comboObjects[2].Code);//Account Code
	searchVersionXML = sheetObjects[0].GetSearchXml("VOP_PSO_0004GS.do", param);
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>

	if( comboItems != "" ){ 
		comboObjects[3].RemoveAll();
		
		addComboItemVersion(comboObjects[3],comboItems);
		formObj.yd_chg_no.value = comboItems[0].split(FIELDMARK)[0];		
	} else{
		comboObjects[3].InsertItem(0, "001|" + ComGetNowInfo() + "~" + ComGetNowInfo("yy") + "-12-31", "001");
		formObj.yd_chg_no.value = "";
	}
	comboObjects[3].Index2 = -1;
	comboObjects[3].Index = 0;
}


/**
 * Vendor 조회
 */
function searchVendor(){
	
	var formObj = document.form;
	comboObjects[1].RemoveAll();
	
	var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(COMMAND03);				//Command
		param += "&port_cd="  + sheetObjects[0].UrlEncoding(formObj.port_cd.value + comboObjects[0].Code);//Port
		param += "&cost_cd="  + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); 	//Cost
		param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
		param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID
		param += "&acct_cd="  + sheetObjects[0].UrlEncoding(comboObjects[2].Code);//Account Code
	var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0211GS.do", param);
	var comboItems = ComGetEtcData(sXml, "vendorList").split("||");
	
	if( comboItems != "" ){
		
		comboObjects[1].Enable = true;
		
	 	for (var i = 0 ; i < comboItems.length ; i++) {
	 		var comboItem = comboItems[i].split(",,");
	 		comboObjects[1].InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	 	}
	 	
	 	comboObjects[1].Index2 = -1;
		comboObjects[1].Index = 0;
		formObj.vndr_nm.value = comboObjects[1].GetText(comboObjects[1].Code, 1);
		
	}else{
		comboObjects[1].Enable = false;
		formObj.vndr_nm.value = "";
	}
	
}

function f_HideSheets(){
	var formObj = document.form;
	if(formObj.caller.value != "IFRAME"){
		if(sheetObjects[0].RowCount > 0){
			document.getElementById("cBase").checked = true;
			document.getElementById("div_base").style.display = "inline";
		} else{		
			//document.getElementById("cBase").checked = false;
			//document.getElementById("div_base").style.display = "none";
		}
		
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
	} else{
		document.getElementById("cBase").checked = true;
		document.getElementById("div_base").style.display = "inline";
		document.getElementById("cSur").checked = true;
		document.getElementById("div_surcharge").style.display = "inline";
		document.getElementById("cDis").checked = true;
		document.getElementById("div_discount").style.display = "inline";
	}
}

/*
 * Sheet2를 Sheet6로 복사
 */
function f_CopyBase2Dummy(oldUk){
//	sheetObjects[5].Redraw = false; 
//	if(sheetObjects[1].RowCount > 0 && uk == sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "sheet2_uk")){
//		sheetObjects[1].Copy2SheetCol(sheetObjects[5], "", "", -1, -1, -1, 2);	//통째로 복사
//	}
//	sheetObjects[5].Redraw = true; 
	
	var sXml = f_MakeSearchXml4CopyBase2Dummy(oldUk);
	sheetObjects[5].WaitImageVisible = false;
	sheetObjects[5].LoadSearchXml(sXml, true, -1);	//Append
}

/*
 * Sheet6를 Sheet2로 복사
 */
function f_CopyDummy2Base(uk){
//	sheetObjects[1].Redraw = false;  
//	for( var i=sheetObjects[5].HeaderRows; i<sheetObjects[5].RowCount + sheetObjects[5].HeaderRows; i++ ) {
//		if(sheetObjects[5].CellValue(i, "sheet6_uk") == uk){
//			sheetObjects[5].Copy2SheetCol(sheetObjects[1], "", "", i, i, -1, 2);
//			sheet2_OnChange(sheetObjects[1], sheetObjects[1].SelectRow, 3);
//			sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "sheet2_object_code") = sheetObjects[5].CellValue(i, "sheet6_object_code");
//		}
//	}
//	sheetObjects[1].Redraw = true;  
	var sXml = f_MakeSearchXml4CopyDummy2Base(uk); 	
	sheetObjects[1].Redraw = false;
	sheetObjects[1].LoadSearchXml(sXml);
	//f_RearrangeInSheet2();
	sheetObjects[1].Redraw = true;  
}

/*
 * Sheet6에 있는 Sheet2데이터를 삭제
 */
function f_RemoveDummyByBase(uk){
//	//UK 행 삭제
//	sheetObjects[5].Redraw = false; 
//	for( var i=sheetObjects[5].LastRow; i>=sheetObjects[5].HeaderRows; i-- ) {
//		if(sheetObjects[5].CellValue(i, "sheet6_uk") == uk){
//			sheetObjects[5].RowDelete( i, false );
//		}
//	}
//	sheetObjects[5].Redraw = true; 
	
	var xxx = ComFindAll(sheetObjects[5], "sheet6_uk", uk) + "";
	if(xxx == "-1"){
		return;
	}
	var zzz = xxx.split("|");
	if(zzz.length == 0){
		return;
	}
	 
	//UK 행 삭제
	sheetObjects[5].Redraw = false; 
	for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
		sheetObjects[5].RowDelete( i, false );
	}
	sheetObjects[5].Redraw = true; 
}


/*
* 모든 Sheet 지우기
*/
function f_RemoveAllSheet(){
	var formObj = document.form;
	//Sheets	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	if(formObj.caller.value != "IFRAME"){
		document.getElementById("cSur").checked = false;
		document.getElementById("cDis").checked = false;
		document.getElementById("div_surcharge").style.display = "none";
		document.getElementById("div_discount").style.display = "none";
	}
	//formObj.foml_desc.value = "";
	document.getElementById("foml_desc").innerHTML = "";
	//formObj.cond_desc.value = "";
	document.getElementById("cond_desc").innerHTML = "";
}

function f_AfterRetrieve(){
	var formObj = document.form;
	if(formObj.caller.value != "IFRAME"){
		if(sheetObjects[3].RowCount > 0){
			document.getElementById("cSur").checked = true;
			document.getElementById("div_surcharge").style.display = "inline";
		} else{		
			document.getElementById("cSur").checked = false;
			document.getElementById("div_surcharge").style.display = "none";
		}
		
		if(sheetObjects[4].RowCount > 0){
			document.getElementById("cDis").checked = true;
			document.getElementById("div_discount").style.display = "inline";
		} else{		
			document.getElementById("cDis").checked = false;
			document.getElementById("div_discount").style.display = "none";
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

/**
 * 
 */ 
function f_MakeSearchXml4CopyDummy2Base(uk)  {
	 var sheetObj = sheetObjects[5];
	 try {
		 //함수 인자 유효성 확인
		 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
			 ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
			 return "";
		 }

		 var allXml = "";
		 var hColSep = "|";
		 var sColSep = "☜☞";
		 var sColOrder = "";

		 var aryTD = new Array(gColumnCountInSheet2);
		 for(var i = 0; i < gColumnCountInSheet2; i++){
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
				 for(var ic = 0; ic<gColumnCountInSheet2; ic++){
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
	 var sheetObj = sheetObjects[1];
	 try {
		 //함수 인자 유효성 확인
		 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
			 ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
			 return "";
		 }
		 
		 var allXml = "";
		 var hColSep = "|";
		 var sColSep = "☜☞";
		 var sColOrder = "";
		 
		 var aryTD = new Array(gColumnCountInSheet2);
		 for(var i = 0; i < gColumnCountInSheet2; i++){
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
				 for(var ic = 0; ic<gColumnCountInSheet2; ic++){
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
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 */
 function obj_blur(){
	 var formObj = document.form;
	 obj = event.srcElement;      	

	 with(formObj){
		 switch(obj.name) {
			 case "vndr_seq":	//Service Provider
				 if (obj.value != "") {
					var val = obj.value;
					if (isNaN(val)) {	//숫자가 아니면						 
						formObj.vndr_seq.value = "";
					 	formObj.vndr_lgl_eng_nm.value = "";
					 	return;
					}
		
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
					form.year.value = "";
					searchVersion();
				 } else{
					 formObj.vndr_lgl_eng_nm.value = "";
					 form.year.value = "";
					 searchVersion();
				 }
			 break;
		 }	
	 }
 }
 
 function loadTerminal() {
 	var formObj = document.form;
 	var sheetObj = sheetObjects[0];
 	
 	comboObjects[0].RemoveAll();
 	formObj.f_cmd.value = COMMAND01;
 	var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
 	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
 	addComboItem(comboObjects[0], comboItems);
 }

 function loadAccount(code) {
		var formObject = document.form;
		var chkIndex = 0;
		doActionIBCombo(sheetObjects[0],formObject,COMMAND01,formObject.acct_or_cost_cd,COMMAND01,"accountAndCost",code);

		for(var i = 0; i < comboObjects[2].GetCount(); i++){
	 		if(comboObjects[2].GetIndexText(i, 0) == formObject.param_acct_cd.value){
	 			chkIndex = i;
	 		}
		}
		formObject.acct_or_cost_cd.Index = chkIndex;
	}
 
 function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
 	sheetObj.ShowDebugMsg = false;
 	switch(sAction) {
 		case COMMAND01:     // Account Combo
 			formObj.f_cmd.value = sAction;
 			formObj.yd_cd.value = formObj.port_cd.value + formObj.com_yd_cd.Code;
 			sheetObj.WaitImageVisible = false;
 			var sXml = sheetObj.GetSearchXml("VOP_PSO_0036GS.do", FormQueryString(formObj) );
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0) 
 				ComXml2ComboItem(arrXml[0], formObj.acct_or_cost_cd, "acct_cd", "acct_cd|acct_nm");
// 			formObj.acct_or_cost_cd.InsertItem(0, "All|" , "All");
 			ComSetObjValue(formObj.acct_or_cost_cd,"All");
 			break;
 	}
 }
 
 /**
  * Account Combo
  */
 function acct_or_cost_cd_OnChange(comboObj, Index_Code, Text){
		var formObject = document.form;
		formObject.acct_or_cost_nm.value = comboObjects[2].GetIndexText(comboObjects[2].Index, 1);
//		formObject.cost_cd.value = "";
		searchVendor();
 }

/* 개발자 작업  끝 */