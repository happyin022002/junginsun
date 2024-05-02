/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0031.js
 *@FileTitle : G/L Data
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 김진일
 *@LastVersion : 1.0
 * 2009.07.08 김진일
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
 * @class VOP_PSO_0031 : VOP_PSO_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0031() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var LANE = "vendor";
var ROWMARK = "|";
var FIELDMARK = "";

var arrPrefix = new Array("sheet1_", "sheet2_");

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btns_calendar_s":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.rqst_dt, "yyyy-MM");
				break;
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	
			case "btn_new":
				//조회조건 초기화	
				f_initCondition();
				break;
	
			case "btn_DownExcel":
				/* SpeedDown2Excel([Mode], [UseOpenFile], [NewSheet], [SaveAsName],[ReportPageUrl],[HideExcelMsg],[WriteTreeLevel], [WorkSheetName],[FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect], [IncludeImageType]) 
				 * [Mode] 내려 받기 종류 옵션. Default=0  -1이면 DataType이 dtStatus, dtHiddenStatus, dtDelCheck, dtDelCehckEx, dtHidden, dtResult에 해당하는 컬럼의 데이터는 내려 받지 않는다.
				 */
				 
				if(sheetObjects[0].RowCount == 0 && sheetObjects[1].RowCount == 0){
					return;
				}
				
				var initRowCount = sheetObjects[0].RowCount;

				var paramObj = new Object();
				paramObj.title  = "G/L Data Inquiry"
				 			    + "\\n(Month : " + formObject.rqst_dt.value + ", Service Provider : " + formObject.vndr_seq.Code + " " + formObject.vndr_seq.Text + ")";
				
				var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);   
				if(initRowCount == 0){
					sheetObjects[0].DataInsert(-1);
				}
				sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url);
				if(initRowCount == 0){
					sheetObjects[0].RowDelete(sheetObjects[0].HeaderRows, false);
				}
				sheetObjects[1].SpeedDown2Excel(-1, true);
				
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	 
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//alert("initSheet_" + i);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//Event 초기화
	initControl();	
	
	//Combo 값 세팅은 sheet1_OnLoadFinish()에서 실시! ☞^.^
}

function initControl() {
	axon_event.addListenerForm('keypress', 		'obj_keypress',  		form); 
	axon_event.addListenerForm('deactivate',  	'obj_deactivate', 		form);	
	axon_event.addListenerForm('focus',   		'obj_focus',      		form); //- 포커스 들어갈때
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	switch(comboNo) {  
		case 1: 
			with (comboObj) { 
				//SetTitle("CD|NM");
				SetColWidth("60|350");
				DropHeight = 190;
				MultiSelect = false;
				MaxSelect = 1;
				UseAutoComplete = true;
				UseCode = true;
			}
			break; 
	} 
}


// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch(sAction) {

		case IBSEARCH:      // 조회
			if (sheetObj.id == "sheet1") {		
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
	
				formObj.f_cmd.value = COMMAND01;
				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				//--> 내 SC에서 BC를 Implement해야 된다. 
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0031GS.do", FormQueryString(formObj));
	
				var comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
				addComboItem(sComboObj,comboItems);				
	
			}
		break;
	}
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		var key = comboItem[comboItem.length - 1];
		var val = comboItems[i].substring(0, comboItems[i].lastIndexOf(FIELDMARK));
		
		comboObj.InsertItem(i, key + "|" + val, key);
	}   	
	comboObj.Index = 0;
	//comboObj.InsertItem(0, "ALL","");
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
			style.height = 312;
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

			var HeadTitle1 = "|GL Date|Debit Amount|Credit Amount|Slip Amount|Slip Number|Invoice Number";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  	DATATYPE,   			WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  							KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	true,		arrPrefix[0] + "ibflag");
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		arrPrefix[0] + "gl_dt",				false,		"",			dfDateYmd,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		arrPrefix[0] + "debit",				false,		"",			dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		arrPrefix[0] + "credit",			false,		"",			dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		arrPrefix[0] + "slip",				false,		"",			dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					180,	daRight,	true,		arrPrefix[0] + "csr_no",			false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,					300,	daLeft,		true,		arrPrefix[0] + "inv_no",			false,		"",			dfNone,			0,		true,		true);


		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			SelectHighLight = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1,1, 7, 100);

			var HeadTitle1 = "|Debit Amount|Credit Amount|AMOUNT";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 1, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			Rows= 4;

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  	DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, 	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		280,	daRight,	true,	arrPrefix[1] + "",			false,		"",			dfNone,			0,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,		240,	daRight,	true,	arrPrefix[1] + "debit",		false,		"",			dfNullFloat,	2,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,		240,	daRight,	true,	arrPrefix[1] + "credit",	false,		"",			dfNullFloat,	2,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,		140,	daRight,	true,	arrPrefix[1] + "amt",		false,		"",			dfNullFloat,	2,			true,		true,		-1,			false,	false);

			//좌측 헤더
			InitHeadColumn(0, "TTL Amount|Last Month G/L Data|This Month G/L Data");
			CountPosition = 0;
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObjects[0].ShowDebugMsg = false;
	sheetObjects[1].ShowDebugMsg = false;
	
	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)){
				return;
			}
			
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[1].WaitImageVisible = false;
			sheetObjects[0].Redraw = false;    							
			sheetObjects[1].Redraw = false;    
	        ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0031GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam( arrPrefix ));
			var arrXml = sXml.split("|$$|");

			
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			
			//두번째 Sheet는 LoadSearchXml()하지 않고, 값을 설정한다. [Query가 바뀐 관계로 아래 문장 수정]
			//Result Query : 항상 2rows 출력, 첫번째 Row는 This Month/두번째 Row는 Last Month 정보
			//sheetObjects[1].RemoveAll();
			//sheetObjects[1].CellValue(1, arrPrefix[1] + "debit")  = f_GetValueFromXMLData(arrXml[1], 1, arrPrefix[1] + "debit");
			//sheetObjects[1].CellValue(1, arrPrefix[1] + "credit") = f_GetValueFromXMLData(arrXml[1], 1, arrPrefix[1] + "credit");
			//sheetObjects[1].CellValue(2, arrPrefix[1] + "amt")    = f_GetValueFromXMLData(arrXml[1], 2, arrPrefix[1] + "amt");
			//sheetObjects[1].CellValue(3, arrPrefix[1] + "amt")    = f_GetValueFromXMLData(arrXml[1], 1, arrPrefix[1] + "amt");
			
			sheetObjects[0].Redraw = true;    
			sheetObjects[1].Redraw = true;  
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
			//조회
			case IBSEARCH:
				if(!ComChkObjValid(formObj.rqst_dt)){
					return false;
				}
	    				    	
			break;
			
		}	
	}

	return true;
}
 
function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	doActionIBCombo(sheetObj, formObj, IBSEARCH, comboObjects[0], COMMAND01, LANE); 
}

function sheet2_OnLoadFinish(sheetObj) {
	//조회조건 초기화	
	f_initCondition();
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) { 
//	sheetObj.CellBackColor(1, arrPrefix[1] + "amt") = sheetObj.UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
//	sheetObj.CellBackColor(2, arrPrefix[1] + "debit") = sheetObj.UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
//	sheetObj.CellBackColor(2, arrPrefix[1] + "credit") = sheetObj.UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
//	sheetObj.CellBackColor(3, arrPrefix[1] + "debit") = sheetObj.UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
//	sheetObj.CellBackColor(3, arrPrefix[1] + "credit") = sheetObj.UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;

	sheetObjects[1].CellBackColor(1, 3) = sheetObjects[1].UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
	sheetObjects[1].CellBackColor(2, 1) = sheetObjects[1].UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
	sheetObjects[1].CellBackColor(2, 2) = sheetObjects[1].UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
	sheetObjects[1].CellBackColor(3, 1) = sheetObjects[1].UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
	sheetObjects[1].CellBackColor(3, 2) = sheetObjects[1].UnEditableColor;	//UnEditableColor = RgbColor(192, 192, 92)  in CoObject.js;
}
	
/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_focus(){
    //마스크구분자 없애기
	switch(event.srcElement.name){
		case "rqst_dt":
			ComClearSeparator(event.srcElement);
    	    event.srcElement.select();
			break;
	}
}

function obj_deactivate(){
    var formObj = document.form;
    switch(event.srcElement.name){
        case "rqst_dt":
        	ComAddSeparator(event.srcElement);	
        break;
        
        default:
            //Validation 전체 체크(길이,format,최대,최소 등등)
    }
    return true;
} 

function obj_keypress() {
	switch(event.srcElement.dataformat){
		case "ym":
			//숫자입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "ymd":
			//숫자입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		default:
		//
	}

	switch(event.srcElement.name){
		case "rqst_dt": case "vndr_seq": 
			if(event.keyCode==13){
				doSearch();
			}
		break;
	}  	
}    		

/**
* 조회조건 초기화
*/
function f_initCondition(){
	var formObj = document.form;
	
	/*
     * ret = ComGetDateAdd(null, "D", -6)                //결과 : "2008-11-04", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd(null, "M", -6)                //결과 : "2008-05-10", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd(null, "Y", -6)                //결과 : "2002-11-10", 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd("날짜아님", "Y", -6)          //결과 : "" , 오늘날짜 : 2008-11-10
     * ret = ComGetDateAdd("2008-01-01", "D", 365, "")   //결과 : "20081231"
	 */
	
	/*
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
	
	//조회기간
	formObj.rqst_dt.value = ComGetNowInfo("ym");
	//comboObjects[0].Index = 0;
	comboObjects[0].Text2 = comboObjects[0].GetIndexText(0, 1);
	
	sheetObjects[0].RemoveAll();
	//sheetObjects[1].RemoveAll();	//sheetObjects[1]는 아래와 같이 초기화
	sheetObjects[1].CellValue(1, 1) = "";
	sheetObjects[1].CellValue(1, 2) = "";
	sheetObjects[1].CellValue(2, 3) = "";
	sheetObjects[1].CellValue(3, 3) = "";

	var xxx = "<SHEET>"
			+ "		<DATA COLORDER='sheet2_amt|sheet2_ibflag|sheet2_debit|sheet2_credit|sheet2_section|sheet2_pagerows|' COLSEPARATOR='☜☞' TOTAL='3'>"
			+ "			<TR><![CDATA[☜☞☜☞☜☞☜☞THIS☜☞]]></TR>"
			+ "			<TR><![CDATA[☜☞☜☞☜☞☜☞PREV☜☞]]></TR>"
			+ "			<TR><![CDATA[☜☞☜☞☜☞☜☞THIS☜☞]]></TR>"
			+ "		</DATA>"
			+ "</SHEET>";
	sheetObjects[1].WaitImageVisible = false;
	sheetObjects[1].LoadSearchXml(xxx);		

}

/**
 * Enter키 이벤트
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}  

/**
 *  Xml에서 데이타 가져오기 
 *    savename 복수일경우 | 사용.
 * @param xmlStr
 * @param cRow : from 1
 * @param savename
 * @return value   ex)복수시 리턴값  aaa|dddd
 * @author jkc
 */
function f_GetValueFromXMLData(xmlStr, cRow, savename)  {
    if (xmlStr == null || xmlStr == ""  ) {
         return;
    }
    if (savename  == null || savename == ""  ) {
        return;
    }
    try {
          var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
          xmlDoc.loadXML(xmlStr);

          var xmlRoot = xmlDoc.documentElement;
          if (xmlRoot == null) {
                  return;
          }

          var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);

          if (dataNode == null || dataNode.attributes.length < 3) {
                  return "";
          }
          var TOTAL_ROWS = eval( dataNode.getAttribute("TOTAL") );

          if( TOTAL_ROWS == "0" ){
       	   return "";
          }
          var col = dataNode.getAttribute("COLORDER");

          var colArr = col.split("|");

          var sep = dataNode.getAttribute("COLSEPARATOR");
          var dataChildNodes = dataNode.childNodes;
          if (dataChildNodes == null) {
              return;
          }

          var colListIdx = Array();
          var arrText = savename.split("|");

          for (var i = 0; i < colArr.length; i++) {
              for (var j = 0; j < arrText.length; j++) {
                  if ( colArr[i] == arrText[j] && colArr[i] != "" ) {
                          colListIdx[j] = i;
                  }
              }
          }

          if(  cRow   >  TOTAL_ROWS ){
          	   return "";
          }
          var arrData = dataChildNodes[cRow-1].firstChild.nodeValue.split(sep);

          var trData = "";
          for (var j = 0; j < colListIdx.length; j++) {
       	   if( j < colListIdx.length-1){
       		   trData += arrData[colListIdx[j]]+"|";
       	   }else{
       		   trData += arrData[colListIdx[j]];   
       	   }
              
          }
          return trData;
    } catch (err) {
           ComFuncErrMsg(err.message);
   }               
}

 /**
  * 
  * <pre>
  *    Excel Title 
  * </pre>
  *
  * @param   sheetObj
  * @param   paramObj
  *          - Attribute : title         : 제목명          (default : 화면제목명);
  *                      : align         : Title 가로 정렬 {"center", "left", "right"}, (default:center)
  *                      : cols          : 타이틀 칼럼수   (default : Sheet Cols수(단, hidden Type 제외 )
  *                      : orientation   : 용지방향        {Landscape,Portrait}(default : Landscape )
  *                      : columnwidth   : 특정 Col Width  (default : 자동) ex)지정필요시, 3 col 30, 4 col 50 일때, 3:30|4:50 
  *                      : datarowheight : 특정 Row Height (default : 20) ex)지정필요시, 3 Row 30, 4 Row 50 일때, 3:30|4:50
  *                                        양식 타이틀이 아닌, 그리드 타이틀부터 1, ex2)그리드 타이틀 row Height을 50으로 변경시
  *                                        paramObj.datarowheight="1:50"
  * @author jang kang cheol
  */
  function ComJooGetPgmTitle(sheetObj, paramObj){
     var doc   = document.all;
     var pageUrl = "FNS_JOO_EXCEL.do?";
     
     /*************************** 제목처리 **********************************/
     var sTitle = "";
     /*************************** 정렬처리 **********************************/
     var sTalign = "center,left,right";
     var sAlign = "";
     /*************************** Col수 처리 **********************************/
     var sCols  = "";
     var iCols = 0;
     /*************************** 용지방향 처리 **********************************/        
     var sOrientation = "";

     /*************************** 특정지정 컬럼들 width 처리 **********************************/        
     var sColumnwidth = "";

     /*************************** 특정지정 Row 들 Height 처리 **********************************/        
     var sDatarowheight = "";
     
     
     if(paramObj.title == undefined ){
         sTitle     = doc.title.innerHTML.replace("&nbsp;","");
         sTitle     = sTitle.replace("&amp;"," ");
     }else{
         sTitle     = paramObj.title;
     }
     if(paramObj.align == undefined ){
         sAlign="center"; 
     }else if(sTalign.indexOf(paramObj.align) == -1 ){
         sAlign = "left";
     }else{
         sAlign = paramObj.align;
     }
     if(paramObj.cols == undefined ){
         for(var i=0; i<= sheetObj.LastCol; i++){
             if ( sheetObj.ReadDataProperty(0, i, dpDataType) != dtHidden 
                  && 
                  sheetObj.ReadDataProperty(0, i, dpDataType) != dtHiddenStatus
                ){
                 iCols++;
             }
         }
     }else{
         iCols = eval(paramObj.cols);
     }

     if(paramObj.orientation == undefined ){
         sOrientation = "Landscape";
     }else{
         sOrientation = paramObj.orientation;
     }
     
     if(paramObj.columnwidth == undefined ){
         sColumnwidth = "";
     }else{
         sColumnwidth = paramObj.columnwidth;
     }
     
     if(paramObj.datarowheight == undefined ){
         sDatarowheight = "";
     }else{
         sDatarowheight = paramObj.datarowheight;
     }        

     var sUrl = pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
     return sUrl;
  } 
/* 개발자 작업  끝 */