/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0007.js
 *@FileTitle : [CPS_CNI_0007] Office Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0007] Main Code Creation
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0007() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================

// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var frm = null;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage() {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
	doActionIBSheet(SEARCHLIST01);
    frm.ofc_cd.focus();
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}

/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {

				// 높이 설정
				style.height = 282;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

				var HeadTitle1 = "|Code|Type|Office Name";
				var headCount = ComCountHeadTitle(HeadTitle1);
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
			   
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"ofc_cd",			false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"intg_cd_val_dp_desc",			false,      "",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		true,		"ofc_eng_nm",			false,      "",				dfNone,		0,			false,		false);
				
				//CountPosition = 0;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
		   }
			break;
	}
}

// ===================================================================================
// Private function
// ===================================================================================

/**
 * Opener Call
 */
 function setOfficeCode(ofcCd) { 
	opener.setOfficeCode(ofcCd);
	window.close();
 }

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn2_Select":
				 var row = sheet1.SelectRow;      
				 if (sheet1.RowCount == 0 || row  < 1) {
				   return;
				 }

				 var ofcCd = sheet1.CellValue(sheet1.SelectRow , "ofc_cd");
				 setOfficeCode(ofcCd);
				break;

			case "btn1_Retrieve":
				doActionIBSheet(SEARCHLIST01);
				break; 

			case "btn1_New":
				//CNI00015 Do you want to initialize?
			    /*
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
				}
				*/
				ComResetAll();
				ComSetFocus(frm.ofc_cd);
				break;

			case "btn1_Close":
				window.close();
				break; 

		} // end switch
}

/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
    switch (event.srcElement.name) {    
    case "ofc_cd":
		if (event.keyCode == 13) {
			doActionIBSheet(SEARCHLIST01);
		}
	break;
	}
}
 
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * row double click 시 parent 에 값 세팅
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */

function sheet1_OnDblClick(sheet, row, col) {
	var ofcCd = sheet1.CellValue(row , "ofc_cd");
	setOfficeCode(ofcCd);
}

/**
 * 조회후 focus 세팅
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnSearchEnd(sheet, row, col) {
	//ComSetFocus(frm.ofc_cd);
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0007GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0]);
		}
		
	} else if (sAction == MULTI) {
		//frm.f_cmd.value = MULTI;		
	} else if (sAction == REMOVE) {		
		//frm.f_cmd.value = REMOVE;		
	}  
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
	}

	return true;
}