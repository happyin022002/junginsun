/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_0031.js
*@FileTitle :  Target Port Set-Up(Popup)
*Open Issues :
*Change history : 2016.02.19
*@LastModifyDate : 2016.02.19 
*@LastModifier : 임예지
*@LastVersion : 1.0
*2016.02.19 임예지
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
 * @class VOP_VSK_0031 : VOP_VSK_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0031() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array(); 
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) { 
			case "btn_Insert":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				
				
			case "btn_Delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
			
				
			case "btn_close":
				window.close();
				break;
				
			case "btn_port":
				doActionIBSheet(sheetObject1,formObject,COMMAND01);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
	ComBtnDisable("btn_Insert");
	ComBtnDisable("btn_Delete");
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
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, false, false, false);

			var HeadTitle = "|Region|Country|Location||";

			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

 
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet1_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	true,	"ibflag",		false,	"",     dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	"conti_nm",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	"sconti_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	"port_cd",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,	"conti_cd",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,	"sconti_cd",	false,	"",		dfNone,			0,			true,		true);
		
		}
		break;
		
	case 2: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 350;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, false, false, false);

			var HeadTitle = "|Region|Country|Port|Port|Port|Port|Port|Port|Port|Port|Port|Port|Port|Port";

			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

 
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet2_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, 0 , dtHiddenStatus,		30,		daCenter,	true,	"ibflag",		false,	"",     dfNone,			0,			true,		true);
			InitDataProperty(0, 1 , dtData,				100,	daCenter,	true,	"conti_nm",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, 2 , dtData,				100,	daCenter,	true,	"sconti_nm",	false,	"",		dfNone,			0,			true,		true);
			//InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	"port_cd",		false,	"",		dfNone,			0,			true,		true);
			for(var i = 3 ; i < 15 ; i++){
				InitDataProperty(0, i , dtData,      		50, 	daCenter,  	true,   "port_cd_"+i ,	false,	"",		dfNone,			0,			true,		true);
			}
			
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheetObj.ShowDebugMsg 		= false;
	sheetObj.WaitImageVisible 	= false;
	
	switch (sAction) {

		case IBSEARCH: // 조회
			formObj.f_cmd.value 		= SEARCH;
			var sParam 					= FormQueryString(formObj);
			ComOpenWait(true);
			var sXml 					= sheetObj.GetSearchXml("VOP_VSK_0031GS.do", sParam);
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			break;
	
			
		case IBSAVE:
			formObj.f_cmd.value = ADD;
			var sParam = ComGetSaveString(sheetObj, false);
			sParam += "&" + FormQueryString(formObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0031GS.do", sParam);
			ComOpenWait(false);
			sheetObj.LoadSaveXml(sXml);
			
			if(!VskGetErrorXml(sXml)){
				ComShowCodeMessage('COM130102', 'Data');
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				formObj.port_cd.value = "";
				ComBtnDisable("btn_Insert");
				ComBtnDisable("btn_Delete");
			}else{
				sheetObj.LoadSaveXml(sXml);	
			}
			
			break;
			
		case IBDELETE: // 삭제
			formObj.f_cmd.value = REMOVE;

			ComOpenWait(true); 

			var sParam = ComGetSaveString(sheetObj, false);
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0031GS.do", sParam);

			ComOpenWait(false);

			if(!VskGetErrorXml(sXml)){
				ComShowCodeMessage('COM12167', 'Data');
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				formObj.port_cd.value = "";
				ComBtnDisable("btn_Insert");
				ComBtnDisable("btn_Delete");
			}else{
				sheetObj.LoadSaveXml(sXml);	
			}
			break;
			
		case COMMAND01:      // Port Pop-up
			sUrl = "/hanjin/VOP_VSK_0043.do";
			ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
			break;
			
		case SEARCH01:				//Port Check
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0031GS.do", sParam);
			return sXml;
			break;
		
	}
}


/**
 * Port Code 존재여부에 따라 화면 제어
 * 
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function isCheckPortForm(sheetObj, formObj, sXml){
	var chkPort = ComGetEtcData(sXml, "check_port");
	if(chkPort == "X"){
		return true;
	}else{
		if(!ComIsNull(formObj.port_cd.value)){
			//해당 Port({?msg1})가 존재하지 않습니다.
			ComShowCodeMessage("VSK00029", formObj.port_cd.value);
			formObj.port_cd.value = "";
		}
	}
	return false;
}


/**
 * [Port] Button Click 후 Pop-up에서 호출.
 * @param rtnObjs
 * @return
 */
function returnPortHelp(rtnObjs){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.port_cd.value = rtnDatas[2];
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(!isCheckPortForm(sheetObj, formObj, sXml)){
					formObj.port_cd.value = "";
					formObj.port_cd.focus();
				}
			}
		}
	}
}


function initControl() {
	var formObj = document.form;

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('activate', 'obj_activate', formObj);
	axon_event.addListenerForm('blur', 'obj_blur', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm('keyup', 'obj_keyup', formObj); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
	axon_event.addListenerForm('keydown', 'obj_keydown', formObj);
}

/**
 * onBlur처리 
 * @return
 */
function obj_change(){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
  	 obj = event.srcElement;      	
  	 
  	 with(formObj){
	 switch(obj.name) {
    	case "port_cd":	// Agreement From Date
			var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
			if(!isCheckPortForm(sheetObj, formObj, sXml)){
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
				return false;
			}else{
				var firstRow 	= sheetObj.HeaderRows;
				var endRow 		= sheetObj.HeaderRows + sheetObj.RowCount;
				for(var i=firstRow; i<=endRow; i++){
					if(sheetObj.CellValue(i, "port_cd") == formObj.port_cd.value){
						ComBtnDisable("btn_Insert");
						ComBtnEnable("btn_Delete");
					}else{
						ComBtnEnable("btn_Insert");
						ComBtnDisable("btn_Delete");
					}
				}
			}
            break;
    	}
  	  }
      return true;	
} 



function obj_keypress(){
	var formObj = document.form;
	switch (event.srcElement.name) {
	    case "port_cd":
	    	ComKeyOnlyAlphabet('uppernum');
			break;

	}
}

function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch (eleObj.name) {
	    case "port_cd":
	    	if(eleObj.value.length == 5){
	    		obj_change();
	    	}
			break; 
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/**
 * 부모창에 선택값 리턴
 */

function sheet2_OnDblClick(sheetObj, Row, Col) {
	var formObj 	= document.form;
	formObj.port_cd.value = sheetObj.CellValue(Row, Col);
	var firstRow 	= sheetObj.HeaderRows;
	var endRow 		= sheetObj.HeaderRows + sheetObj.RowCount;
	for(var i=firstRow; i<=endRow; i++){
		if(sheetObj.CellValue(i, "port_cd") != formObj.port_cd.value){
			ComBtnDisable("btn_Insert");
			ComBtnEnable("btn_Delete");
		}else{
			ComBtnEnable("btn_Insert");
			ComBtnDisable("btn_Delete");
		}
	}
	
//	comPopupOK();
}


function sheet1_OnSearchEnd(sheetObj, ErrMSg) {
	
	var formObj 	= document.form;
		
	var firstRow 	= 0;
	var endRow 		= 0;
	var sheet2Row = sheetObjects[1].HeaderRows;
	with(sheetObj){
		// 데이터가 있으면...
		if(RowCount > 0){

			firstRow 	= HeaderRows;
			endRow 		= HeaderRows + RowCount;
			//Redraw 		= false;
			
			var preConti = "";
			var aftConti = "";
			var obj2 = sheetObjects[1];
			
			obj2.DataInsert(sheet2Row);
			obj2.CellValue2(sheet2Row, "conti_nm" ) =  sheetObj.CellValue(  firstRow , "conti_nm" );
			obj2.CellValue2(sheet2Row, "sconti_nm" ) = sheetObj.CellValue(  firstRow , "sconti_nm" );
			obj2.CellValue2(sheet2Row, "port_cd_3" ) = sheetObj.CellValue(  firstRow , "port_cd" );
			
			var col = 3;
			var j= firstRow;
			var i= firstRow+1;
			while( i < endRow ){
				preConti = sheetObj.CellValue(  j , "sconti_cd" );
								
				aftConti = sheetObj.CellValue( 	i , "sconti_cd" );
				
				if( preConti == aftConti ){
					col++;
					if( col <= 14 ){
						obj2.CellValue2(sheet2Row, "port_cd_"+col ) = sheetObj.CellValue(  i , "port_cd" );
					}else if( col == 15 ){
						col = 3;
						sheet2Row++;
						obj2.DataInsert(sheet2Row);
						obj2.CellValue2(sheet2Row, "conti_nm" ) =  sheetObj.CellValue(  i , "conti_nm" );
						obj2.CellValue2(sheet2Row, "sconti_nm" ) = sheetObj.CellValue(  i , "sconti_nm" );
						obj2.CellValue2(sheet2Row, "port_cd_3" ) = sheetObj.CellValue(  i , "port_cd" );
						
					}
				}else{
					col = 3;
					sheet2Row++; 
					obj2.DataInsert(sheet2Row);
					obj2.CellValue2(sheet2Row, "conti_nm" ) =  sheetObj.CellValue(  i , "conti_nm" );
					obj2.CellValue2(sheet2Row, "sconti_nm" ) = sheetObj.CellValue(  i , "sconti_nm" );
					obj2.CellValue2(sheet2Row, "port_cd_3" ) = sheetObj.CellValue(  i , "port_cd" );
					
				}
				i++;
				j++;
			}
			
			
//			for (var i=firstRow+1; i<=endRow; i++){
//				preConti = sheetObj.CellValue(  i , "conti_cd" );
//				
//				for (var j=firstRow+2; j<=endRow; i++){
//					aftConti = sheetObj.CellValue( j , "conti_cd" );
//					
//					if( preConti == aftConti ){
//						obj2.CellValue2(sheet2FirstRow, "port_cd_"+col ) = 
//					}
//				}
//			}
			
		}else{
		}
	}
}


/* 개발자 작업 끝 */