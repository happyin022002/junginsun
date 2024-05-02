/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0032.js
 *@FileTitle : Balance Diff. Account
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 정명훈
 *@LastVersion : 1.0
 * 2009.08.25 정명훈
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
 * @class VOP_PSO_0032 : VOP_PSO_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0032() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

var FIELDMARK = "";
var arrPrefix = new Array("sheet1_", "sheet2_");

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			/** TAB [DOMINION(2132)] (S) **/
	
			case "btns_calendar_s":
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.yyyymm, "yyyy-MM");
				break;
	
				/** TAB [DOMINION(2132)] (E) **/
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	
			case "btn_new":
				//조회조건 초기화	
				f_initCondition();
				break;

			case "btn_down_excel":
				/* SpeedDown2Excel([Mode], [UseOpenFile], [NewSheet], [SaveAsName],[ReportPageUrl],[HideExcelMsg],[WriteTreeLevel], [WorkSheetName],[FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect], [IncludeImageType]) 
				 * [Mode] 내려 받기 종류 옵션. Default=0  -1이면 DataType이 dtStatus, dtHiddenStatus, dtDelCheck, dtDelCehckEx, dtHidden, dtResult에 해당하는 컬럼의 데이터는 내려 받지 않는다.
				 *
				 * Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],[ReportPageUrl],
				 */
				 
				 if(sheetObjects[0].RowCount == 0 && sheetObjects[1].RowCount == 0){
					 return;
				 }

				 var paramObj = new Object();
				 paramObj.title  = "Agent Statement Account"
					 			 + "\\n(Month : " + formObject.yyyymm.value + ", Service Provider : " + formObject.vndr_seq.Code + " " + formObject.vndr_seq.Text + ")";
				 //paramObj.cols = "6";
				 var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
				 
				 if(sheetObjects[0].RowCount == 0){
					 showCol4ExcelDown("sheet1_");
					 sheetObjects[2].SpeedDown2Excel(-1, false, false, "", url);
				 } else{
					 sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url);
				 }
				 
				 if(sheetObjects[1].RowCount == 0){
					 showCol4ExcelDown("sheet2_");
					 sheetObjects[2].SpeedDown2Excel(-1, true);
				 } else{
					 sheetObjects[1].SpeedDown2Excel(-1, true);
				 }
				 
				 
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

/*
 * Excel DownLoad : 조회된 결과가 없을 경우, 빈 그리드 보여주기
 */
function showCol4ExcelDown(prefixOfCol){
	var colCount = sheetObjects[2].LastCol + 1;
	for(i=0; i<colCount; i++){
		if(sheetObjects[2].ColSaveName(i).indexOf(prefixOfCol) > -1){
			sheetObjects[2].ColHidden(i) = false;
		} else{
			sheetObjects[2].ColHidden(i) = true;							 
		}
	}	
}

function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}

function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	for(i=0;i<sheetObjects.length;i++){

		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Event 초기화
	initControl();	
}

function initControl() {
	axon_event.addListenerForm('keypress', 		'obj_keypress',  		form); 
	axon_event.addListenerForm('deactivate',  	'obj_deactivate', 			form);	
	axon_event.addListenerForm('focus',   		'obj_focus',      		form); //- 포커스 들어갈때
}

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
			style.height = 100;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			//선택행 하이라이트
			SelectHighLight = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Seq.|Settlement date|Amount|Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    	[ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		arrPrefix[0]+"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	true,		arrPrefix[0]+"seq",			false,		"",			dfNone,			0,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,				300,	daCenter,	true,		arrPrefix[0]+"dt",			false,		"",			dfUserFormat,	0,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,				250,	daRight,	true,		arrPrefix[0]+"amt",			false,		"",			dfNullFloat,	2,			true,		true,		-1,			false,	false);
			InitDataProperty(0, cnt++ , dtData,				300,	daLeft,		true,		arrPrefix[0]+"description",	false,		"",			dfNone,			0,			true,		true,		-1,			false,	false);

			//InitDataValid(0, prefix+"rlane_cd", vtEngUpOnly);
			//InitUserFormat(0, arrPrefix[0]+"yyyymm", "####-##", "-" );
			CountPosition = 0;
			SetSortDialog(false);
		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 180;
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

			var HeadTitle1 = "||Not Included Advance Payment Invoice|Slip Number|Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	arrPrefix[1]+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	arrPrefix[1]+"sel");
			InitDataProperty(0, cnt++ , dtAutoSum,		250,	daRight,	true,	arrPrefix[1]+"ttl_usd_amt",		false,		"",			dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			300,	daCenter,	true,	arrPrefix[1]+"csr_no",			false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,	arrPrefix[1]+"inv_no",			false,		"",			dfNone,			0,		true,		true);

			SetSortDialog(false);

		}
		break;
		
	case "sheet3":	//Excel Down : 빈 그리드 출력용
		with (sheetObj) {
			// 높이 설정
			style.height = 180;
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

			var HeadTitle1 = "Seq.|Settlement date|Amount|Description||Not Included Advance Payment Invoice|Slip Number|Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			var prefix1 = "sheet1_";
			var prefix2 = "sheet2_";

			//데이터속성    	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		300,	daRight,	true,	prefix1+"a",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daCenter,	true,	prefix1+"b",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix1+"c",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix1+"d",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix2+"a",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix2+"b",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix2+"c",	false,		"",			dfNone,			0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,	prefix2+"d",	false,		"",			dfNone,			0,		true,		true);
		}
		break;

	}
}

function doActionIBCombo(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch(sAction) {

		case IBSEARCH:      // 조회
			if (sheetObj.id == "sheet1") {		
				//콤보필드를 초기화시킨다.
				comboObjects[0].RemoveAll();
		
				formObj.f_cmd.value = COMMAND01;
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0031GS.do", FormQueryString(formObj));
		
				var comboItems = ComGetEtcData(sXml, "vendor").split("|");
				addComboItem(comboObjects[0], comboItems);	
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
	        ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0032GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam( arrPrefix ));
			var arrXml = sXml.split("|$$|");

			sheetObjects[0].Redraw = false;    							
			sheetObjects[1].Redraw = false;    
			
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			
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
	switch(sAction) {

		case IBSEARCH:      //조회

			if(ComIsNull(formObj.yyyymm.value) || formObj.yyyymm.value.length < 6){
				ComShowCodeMessage('PSO00003', '[Work Month]');	//필수항목을 입력하여 주십시오.
				formObj.yyyymm.focus();
				return false;
			}

		break;

	}

	return true;
}

/*********************************************************************************************/
/*                                                                                           */
/*********************************************************************************************/

function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	doActionIBCombo(sheetObj, formObj, IBSEARCH); 	
	
	sheetObjects[2].DataInsert(-1);
}

function sheet2_OnLoadFinish(sheetObj) {
	//조회조건 초기화	
	f_initCondition();
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	with(sheetObj)
	{
		
//		var row = LastRow;
//
//		for (var i = 1; i <= LastRow; i ++)
//		{
//			if ("Total" == CellValue(i, "Amount"))
//				RowBackColor(i) = RgbColor(247, 225, 236);
//			CellFont("FontBold", i, "Amount", i, "SlipNumber") = true;
//		}
		//ShowSubSum(arrPrefix[1]+"", arrPrefix[1]+"ttlUsdAmt", -1, false, false, 0, "pod=%s;fm=%s;wg=FullTotal");	
		//ShowSubSum(arrPrefix[1]+"ttl_usd_amt", arrPrefix[1]+"ttl_usd_amt");	
		SumText(0, arrPrefix[1]+"sel") = "Total";
		SumText(0, arrPrefix[1]+"csr_no") = "";
	}
}    
	
/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_focus(){
    //마스크구분자 없애기
	switch(event.srcElement.name){
		case "yyyymm":
			ComClearSeparator(event.srcElement);
    	    event.srcElement.select();
			break;
	}
}

function obj_deactivate(){
    var formObj = document.form;
    switch(event.srcElement.name){
        case "yyyymm":
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
		case "yyyymm": case "vndr_seq": 
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
	
	var formObj = document.form;
	//조회기간
	formObj.yyyymm.value = ComGetNowInfo("ym");
	//comboObjects[0].Index = 0;
	comboObjects[0].Text2 = comboObjects[0].GetIndexText(0, 1);
	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
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
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
	
	
	var objs = document.all.item("tabLayer");
	
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	
	
	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
	
	
}	

/**
 * 콤보필드에 데이터를 추가해준다.
 */	
function addComboItem(comboObj, comboItems) {
//	for (var i = 0 ; i < comboItems.length ; i++) {
//		var comboItem = comboItems[i].split(",");
//		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[0], comboItem[1]);
//	}   	
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