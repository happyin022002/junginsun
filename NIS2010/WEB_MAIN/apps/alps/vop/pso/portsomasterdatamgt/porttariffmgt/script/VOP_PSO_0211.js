/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0211.js
 *@FileTitle : Tariff Copy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 박명종
 *@LastVersion : 1.0
 * 2009.06.03 박명종
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
 * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0211() {
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

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var TerminalList = "";
var AccountList = "";
var ObjList = "";
var conditionXML = "";		//페이지로딩시 조회조건 세팅용 쿼리 결과
var searchVersionXML = "";	//Version 조회결과

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
		    		param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);	//Service Provider
		    		param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
		    		//param += "&combo4="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code);//Version 
		    		param += "&combo5="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code); 	//Version
		    		param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
		    		param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(0,10)); 	//From Date 
			    	param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(11)); 	//To Date
		    		param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID 
		    	
				opener.document.form.copy_condition.value = param;	
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
		case 3: 
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
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}

function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;

	switch (eleObj.name) {
		case "year":
			if(eleObj.value.length == 4){
				searchVendor();
				searchVersion();
				f_RemoveSheets();
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
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		prefix+"object_dsp"		);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"object_code_dsp"	);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		prefix+"rate_code"		);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_from",	false,		"",			dfNone,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"range_to",	    false,		"",			dfNone,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"currency",		false,		"",			dfNone,				0,		false, 	false, 		3 );
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"rate_value",	false,		"",			dfNumber,			10,		true,  	true, 		20);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"regular_value", false,		"",			dfNumber,			4,		true,  	true, 		14);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"condition",		false);
			InitDataProperty(0, cnt++ , dtData,			10,		daLeft,		true,		prefix+"cond_desc",  	false,		"",			dfNone,				0,		false, 	false, 		15);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"object_name");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"uom");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cpls_flg");

			InitDataCombo(0, prefix+"rate_code", "Range1\tObject X Range Rate|Range2\tRange Rate Only|Fixed\tObject X Fixed Rate" , "R|S|F", "", "R");
			CountPosition = 0;
			ShowButtonImage = 1;

		}
		break;

	case "sheet2":
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

	case "sheet3":
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
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, etc) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
			var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_");        
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
			
			var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(SEARCH);				//Command
		    	param += "&port_cd="  + sheetObjects[0].UrlEncoding(formObj.port_cd.value);	//Port
		    	param += "&combo1="   + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 	//Yard
		    	param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);	//Service Provider
		    	param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
		    	//param += "&combo4="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code); //Version 
		    	param += "&combo5="   + sheetObjects[0].UrlEncoding(comboObjects[2].Code); 	//Version		    	
		    	param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
		    	param += "&from_date="+ sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(0,10)); 	//From Date 
		    	param += "&to_date="  + sheetObjects[0].UrlEncoding(formObj.eff_date.value.substring(11)); 	//To Date 
		    	param += "&uid="      + sheetObjects[0].UrlEncoding("0002"); 				//UID 
		    
		    //VOP_PSO_0036.do의 IFRAME에서 호출하는 경우	
		    if(etc != undefined && etc != ""){
		    	param = etc;
		    }
		    
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
			
			//첫번째 행만 Enable 하기 위하여
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"object|" + aryPrefix[0]+"object_code|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"regular_value|" + aryPrefix[0]+"condition");
	
		break;
		case IBSEARCH_ASYNC01:
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_");
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0211GS.do", param );
			var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
			
			//콤보필드를 초기화시킨다.
			comboObjects[0].RemoveAll();
			addComboItem(comboObjects[0],comboItems);	
			
			comboObjects[0].Code2 = formObj.ydCd.value; 
			
			searchVendor();
			comboObjects[1].Code = formObj.vndr_seq.value;

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
		document.getElementById("acct_or_cost_cd").value = document.getElementById("acct_cd").value;
		document.getElementById("acct_or_cost_nm").value = document.getElementById("acct_nm").value;
	}
	
	if(formObj.caller.value != "IFRAME"){
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	}
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
* Yard Combo
*/ 
function com_yd_cd_OnChange(comboObj, Index_Code, Text){
	searchVendor();
	searchVersion();
	f_RemoveSheets();
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
	 f_RemoveSheets();
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
	
	f_RemoveSheets();
	f_HideSheets();
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
	comboObjects[2].RemoveAll();

	formObj.f_cmd.value = COMMAND02;
	
	var param  = "f_cmd="     + sheetObjects[0].UrlEncoding(COMMAND02);				//Command
	    param += "&port_cd="   + sheetObjects[0].UrlEncoding(formObj.port_cd.value);//Port
	    param += "&combo1="   + sheetObjects[0].UrlEncoding(comboObjects[0].Code); 	//Yard
	    param += "&vndr_seq=" + sheetObjects[0].UrlEncoding(comboObjects[1].Code);	//Service Provider
	    param += "&combo3="   + sheetObjects[0].UrlEncoding(formObj.cost_cd.value); //Cost 
	    param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 	//Year 
	    param += "&uid="      + sheetObjects[0].UrlEncoding("0004"); 				//UID  
	searchVersionXML = sheetObjects[0].GetSearchXml("VOP_PSO_0002GS.do", param);
	var comboItems = ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>

	if( comboItems != "" ){ 
		addComboItemVersion(comboObjects[2],comboItems);
		formObj.yd_chg_no.value = comboItems[0].split(FIELDMARK)[0];		
	} else{
		comboObjects[2].InsertItem(0, "001|" + ComGetNowInfo() + "~" + ComGetNowInfo("yy") + "-12-31", "001");
		formObj.yd_chg_no.value = "";
	}
	comboObjects[2].Index2 = -1;
	comboObjects[2].Index = 0;
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
		param += "&year="     + sheetObjects[0].UrlEncoding(formObj.year.value); 		//Year
		param += "&uid="      + sheetObjects[0].UrlEncoding("0002"); 					//UID 
	var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0211GS.do", param);

	var comboItems = ComGetEtcData(sXml, "vendorList").split("||");
	
	if( comboItems != "" ){ 
	 	for (var i = 0 ; i < comboItems.length ; i++) {
	 		var comboItem = comboItems[i].split(",,");
	 		comboObjects[1].InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	 	}  	
	}
	comboObjects[1].Index2 = -1;
	comboObjects[1].Index = 0;
	formObj.vndr_nm.value = comboObjects[1].GetText(comboObjects[1].Code, 1);
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

function f_RemoveSheets(){
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

/* 개발자 작업  끝 */