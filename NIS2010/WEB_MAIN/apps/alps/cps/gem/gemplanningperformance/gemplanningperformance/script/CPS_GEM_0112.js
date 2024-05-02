/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : CPS_GEM_0112.js
 *@FileTitle : [CPS_GEM_0112] Slip I/F Error
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.18
 *@LastModifier : 표준희
 *@LastVersion : 1.0
 * 2011.07.18 표준희
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0112] Slip I/F Error
 * @extends
 * @class Slip I/F Error생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0112() {
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

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null
var comboCnt = 0;

// html form
var frm = null;


/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
 **/
function setComboObject(combo_obj){
   comboObjects[comboCnt++] = combo_obj;
}

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 **/
function loadPage() {
	
    //전역 변수 설정 
    frm = document.form;
    
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    combo1 = comboObjects[0]
    comboCnt = comboObjects.length;
    
    //시트 초기화 
    
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
   
    //IBMultiCombo초기화
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
    }
    
    
    //Form 이벤트 등록
    initControl();
    
    //초기 데이타 취득 TIC취득    
    doActionIBSheet(INIT);
}

/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ","; 
	comboObj.DropHeight = 240;
}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	
	with (sheetObj) {
		switch (sheetObj.id) {

		case "sheet1":

            // 높이 설정
            style.height = 260;
            
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 18, 100);

			var HeadTitle1 = "SLIP NO.|SEQ|CUR|Center|ACCT|EFF DT|Office|SLIP AMT|Error Message ";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, true,true)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
            InitDataProperty(0, cnt++ , dtData,		   200,		daCenter,	true,		"slp_tj_no",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"slp_seq_no",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,	   	    40,		daCenter,	true,		"slp_curr_cd",		    false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		    50,		daCenter,	true,		"slp_ctr_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"acct_cd",				false,		"",			dfNone,		0,			false,		false);						
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt",			false,		"",			dfDateYmd,	0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,		"slp_amt",				false,		"",			dfNullFloat,3,		    false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"slp_if_err_rsn",		false,		"",			dfNone,		0,			false,		false);
			
			break;
		
		}
	}
}

// ===================================================================================
// Private function
// ===================================================================================
 /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
function validateForm(){
	return true;
	
}

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;



/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(SEARCHLIST);
			break;
		case "btn_Close":
			self.close();
			break;	
	} 
}



/**
 * Form 이벤트 등록
 */
function initControl() {
	//key up
	axon_event.addListenerForm('keyup', 'obj_keyup', frm);
    //keypress
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    // focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);    
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
	
    switch (event.srcElement.name) {    
    case "gen_expn_cd":
		ComKeyOnlyNumber(event.srcElement);
		break;  
    }
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function obj_keypress() { 	
     switch (event.srcElement.name) {    
     case "gen_expn_cd":
    	 
 		if (event.srcElement.value.length == 6 && 
 				event.keyCode == 13) {
 			doActionIBSheet(SEARCHLIST);
 		}
 		break;  
     }
 }

    
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {
	switch (event.srcElement.name) {
	case "gen_expn_cd":
		ComChkObjValid(event.srcElement);
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}
 


/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


 
//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
//function combo1_OnCheckClick(comboObj, index, code) {
//	if(index==0) {
//    	//checked
//    	var bChk = comboObj.CheckIndex(index);
//		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
//			comboObj.CheckIndex(i) = bChk;
//    	}
//    } else {
//		comboObj.CheckIndex(0) = false;
//    }
//	
//	frm.gen_expn_cd.value = "";
//	
//}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
* sheet1 MouseMove 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
* @param {long} X X 좌표
* @param {long} Y Y 좌표
*/
function sheet1_OnMouseMove(sheet , button, shift, X, Y) {	
   
	   var sName = sheet1.ColSaveName(sheet1.MouseCol);
	   if (sheet1.MouseRow > 0 && ("eng_abbr_nm" == sName ||  "krn_abbr_nm" == sName)) {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,sheet1.MouseCol);		   
	   } else {
		   sheet1.MouseToolTipText = "";
	   }      
}


/**
* sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
//function sheet1_OnChange(sheet, row, col ,value) {
//	
//	var sel_div = frm.sel_div.value;	
//	var sName = sheet1.ColSaveName(col);
//	
//	if ("delChk" == sName) {
//		var sel_div = frm.sel_div.value;
//		if (sel_div == "S") {
//			var cnt = selectRowNum(sheet1);			
//			if ( cnt != null &&  cnt.length > 1 ) {
//				sheet1.CellValue2(row,"delChk") = 0;
//			}			
//		}
//	} 
//}


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {

	//Open
	if (sAction == INIT) {	

		frm.f_cmd.value = INIT;
		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0112GS.do", FormQueryString(frm));	
		sheet1.LoadSearchXml(sXml);	
		// ---------------------------------
		// TIC 콤보박스  설정
		// ---------------------------------		
//		var ticList = ComGetEtcData(sXml, "ticCd").split("|");
//		
//		var tic_cd = frm.tic_cd;
//		tic_cd.length = 0;
//		
//		ComAddComboItem(tic_cd,"","");
//		
//		for(var i=0 ; i < ticList.length ; i++ ) {			
//			ComAddComboItem(tic_cd,ticList[i],ticList[i]);
//		}		
//		
//		
//		if (!ComIsNull(frm.usr_tic_cd.value)) {
//			tic_cd.value = frm.usr_tic_cd.value;
//			ComEnableObject(tic_cd, false);
//		}
		
		// ---------------------------------
		// Expense Code group code 
		// ---------------------------------
//		var arr = ComXml2ListMap(sXml);		
//		combo1.InsertItem(0,"Select All","");
//		for(var i=0 ; i < arr.length ; i++ ) {
//			var expense = arr[i];
//			var langDiv = frm.lang_div.value;
//			if (langDiv == "KOR") {
//				combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["krn_abbr_nm"],expense["gen_expn_cd"]);
//			} else if(langDiv == "ENG") {
//				combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["eng_abbr_nm"],expense["gen_expn_cd"]);
//			}
//			
//		}
		
//		//콤보 설정
//		if (!ComIsNull(frm.gen_expn_group_cd.value)) {
//			combo1.Code = frm.gen_expn_group_cd.value;
//			combo1.Enable = false;
//		} else {
//			combo1.Code = "";
//		}
		
	}  
 	
}
 
 

 
