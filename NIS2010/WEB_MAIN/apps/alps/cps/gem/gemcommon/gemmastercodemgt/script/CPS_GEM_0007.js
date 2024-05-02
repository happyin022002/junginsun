/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0007.js
 *@FileTitle : [CPS_GEM-0007] Expense Code Maintenance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block 
=========================================================*/


/**
 * [CPS_GEM-0007] Foreign Exchange Rate Maintenance
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0007() {
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
var sheet2 = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null
var comboCnt = 0;

var curYear = "";
// html form
var frm = null;


var div1Display = true;
var div2Display = true;

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
    sheet2 = sheetObjects[1];    
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
    

    
}

/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function sheet1_OnLoadFinish(sheet) {
	sheet.WaitImageVisible = false;	    
    //초기 데이타 취득 TIC취득
	if ( doActionIBSheet(INIT) == false ) {
		return ;
	}

    doActionIBSheet(SEARCHLIST01);      
    
	sheet.WaitImageVisible = true;
}


/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.BackColor = "#CCFFFD"; 
	comboObj.SetColAlign("center|left|left");
	comboObj.MultiSeparator = ","; 
	comboObj.DropHeight = 190;
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
			style.height = 200;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "|deltflg|Select|Account\nCode|Expense\nCode|Account Name|Account Name|Description|Description";
			var HeadTitle2 = "|deltflg|Select|Account\nCode|Expense\nCode|ENG|KOR|ENG|KOR";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,
					"delt_flg", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);			
			InitDataProperty(0, cnt++, dtDummyCheck, 60, daCenter, true,
					"delChk", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "acct_cd",
					true, "", dfEngKey, 0, false, true, 6, true, true, "",
					true);
						
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "gen_expn_cd",
					false, "", dfEngKey, 0, true, false, 6, true, true, "",
					true);			
			
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "eng_nm",
					false, "", dfEngKey, 0, false, false, 100);
			
			
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "krn_nm",
					false, "", dfHanKey, 0, false, false, 50);
			InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "eng_desc",
					false, "", dfEngKey, 0, true, true, 1000);
			InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "krn_desc",
					true, "", dfHanKey, 0, true, true, 1000);
			
			InitDataValid(0,    "acct_cd",   vtNumericOnly);
			
			
			
			WordWrap = true;
			HeadRowHeight = 20;
			
			break;

		case "sheet2":

			// 높이 설정
			style.height = 120;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|deltflg|Select|Office|Account Code|Divided Expense|Divided Month|Creator|Creator Date";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"delt_flg", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtDummyCheck, 60, daCenter, true,
					"delChk", false, "", dfNone, 0, true, true, 400, false,
					true, "", true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "ofc_cd",
					true, "", dfEngKey, 0, false, true, 6,true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false,
					"acct_cd", true, "", dfNone, 0, false, true, 6,true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false,
					"sprt_gen_expn_cd", true, "", dfNone, 0, false, false, 6,true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false,
					"sprt_yrmon", true, "", dfDateYm,0,true,true);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "cre_usr_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false,
					"cre_dt", false, "", dfDateYmd, 0, false, false);
			
			InitDataValid(0,    "ofc_cd",    vtEngUpOnly);
			InitDataValid(0,    "acct_cd",   vtNumericOnly);
			InitDataValid(0,    "sprt_gen_expn_cd",   vtNumericOnly);
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
function validateForm() {

	return true;
	
	
}
/**
 * 멀티콤보 parent설정
 * @param {string} sXml 조회 Xml
 * @param {string} code 코드  
 */
function setParent(sXml , code) {
	var arr = ComXml2ListMap(sXml);

	for ( var i = 0; i < arr.length; i++) {
		var expense = arr[i];
		var text = expense["gen_expn_cd"] + "|" + expense["krn_abbr_nm"] + "|"
				+ expense["eng_abbr_nm"];

		combo1.InsertItem(i, text, expense["gen_expn_cd"]);
	}
	if (ComIsNull(code)) {
		combo1.Code2 = "";
	} else {
		combo1.Code2 = code;
	}
		
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * Parent 코드가 change될때 비용코드 이름 취득
 */
function searchExpenseName() {
	doActionIBSheet(SEARCHLIST03);
}



/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
	case "btn_RowAdd1":		
		var row = sheet1.DataInsert(-1);		
		sheet1.SelectCell(row,"acct_cd",true);
		break;
	case "btn_Delete1":
		ComRowHideDelete(sheet1, "delChk");
		break;
	case "btn_RowAdd2":
		
		var gen_expn_acct_expt_flg = frm.gen_expn_acct_expt_flg;
		
		if (ComGetObjValue(gen_expn_acct_expt_flg) == "Y") {
			var row = sheet2.DataInsert(-1);
			sheet2.SelectCell(row,"ofc_cd",true);
		} else {			
			//Divided by Office 정의된 정보가 없습니다.
			ComShowCodeMessage("GEM01010");			
		}
		
		break;
	case "gen_expn_acct_expt_flg":		
		/*
		var gen_expn_acct_expt_flg = frm.gen_expn_acct_expt_flg;
		var rowCount = SheetRowCount(sheet2);
		if (ComGetObjValue(gen_expn_acct_expt_flg) == "N") {			 
			if (  rowCount > 0 ) {
				//Divided by Office 정의된 정보가 있습니다
				ComShowCodeMessage("GEM01001");
				ComSetObjValue(gen_expn_acct_expt_flg,"Y");
				
			} 
		} else if (ComGetObjValue(gen_expn_acct_expt_flg) == "Y") {			 
			if (  rowCount == 0 ) {
				ComSetObjValue(gen_expn_acct_expt_flg,"N");
			}
		}*/

		
		break;		
	case "btn_Delete2":		
		
		ComRowHideDelete(sheet2, "delChk");
		
		if (SheetRowCount(sheet2) == 0) {
			ComSetObjValue(frm.gen_expn_acct_expt_flg,"N");			
		}
		
		
		break;
	case "btn_Retrieve":		
		var gen_expn_cd = frm.gen_expn_cd;
		if (!ComIsNull(gen_expn_cd)) {
			doActionIBSheet(SEARCHLIST);
		} else {
			//GEM01011	ENG	W	비용코드를 입력해주세요
			ComShowCodeMessage("GEM01011");
		}
		 
		break;
	case "btn_New":
		//Do you want to initialize?
		if (ComShowCodeConfirm("GEM00011")) {
			ComResetAll();
		}
		break;
	case "btn_Delete":
		break;
	case "btn_Save":				
		//GEM00012(Do you want to save changes?)
		if (ComShowCodeConfirm("GEM00012")) {
			doActionIBSheet(MULTI);
		}			
		break;
	case "gen_expn_grp_lvl":
		doActionIBSheet(SEARCHLIST02);
		break;	
	case "btn_Minimize1":		
		var sheet1Div = document.getElementById("sheet1Div");		
		if (div1Display) {
			sheet1Div.style.display  = "none";
			div1Display = false;
			document.getElementById("btn_Minimize1").style.color = "#ff5000";
		} else {
			sheet1Div.style.display = "block";			
			div1Display = true;
			document.getElementById("btn_Minimize1").style.color = "#737373";
		}
		break;	
	case "btn_Minimize2":
		
		var sheet2Div = document.getElementById("sheet2Div");
		if (div2Display) {
			sheet2Div.style.display = "none";
			div2Display = false;
			document.getElementById("btn_Minimize2").style.color = "#ff5000";
		} else {
			sheet2Div.style.display = "block";
			div2Display = true;
			document.getElementById("btn_Minimize2").style.color = "#737373";
		}
		

		break;		
 
	case "acct_mtx_delt_flg":		
		var gen_expn_cd = frm.gen_expn_cd;
		if (!ComIsNull(gen_expn_cd)) {
			doActionIBSheet(SEARCHLIST05);
		} else {
			//GEM01011	ENG	W	비용코드를 입력해주세요
			ComShowCodeMessage("GEM01011");
			frm.acct_mtx_delt_flg.checked = false;
			frm.gen_expn_cd.focus();
		}		
		break;
	case "acct_expt_delt_flg":		
		var gen_expn_cd = frm.gen_expn_cd;
		if (!ComIsNull(gen_expn_cd)) {
			doActionIBSheet(SEARCHLIST06);
		} else {
			//GEM01011	ENG	W	비용코드를 입력해주세요
			ComShowCodeMessage("GEM01011");			
			frm.acct_expt_delt_flg.checked = false;			
			frm.gen_expn_cd.focus();
		}
		break;			
		
	} 
}


/**
 * Form 이벤트 등록
 */
function initControl() {
    //keypress
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    // focus out
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);    
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
	
    switch (event.srcElement.name) {    
    case "gen_expn_cd":
		ComKeyOnlyNumber(event.srcElement);
		break;
    case "usd_krw_xch_rt":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	}
}

/**
 * HTML Control Focus out
 **/
function obj_deactivate() {
	switch (event.srcElement.name) {
	case "gen_expn_cd":
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

function gen_expn_cd_on_keyup(){	
	//6자리 이면 focus() 이동후 조회 
	if (frm.gen_expn_cd.value.length == 6) {
		//조회
		doActionIBSheet(SEARCHLIST);
		
	}
} 
//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
* combo1 onchange
* @param {multicombo}   combo1
* @param {string}   code
* @param {text}   text
*/
function combo1_OnChange(combo1 , code, text) {
	var expensInfo = text.split("|");
	ComSetObjValue(frm.prnt_krn_abbr_nm,expensInfo[1]);
	ComSetObjValue(frm.prnt_eng_abbr_nm,expensInfo[2]);
	frm.prnt_krn_abbr_nm.focus();
}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * sheet1 편집처리후 이벤트
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} col 해당 셀의 value 
 * 
 */
function sheet1_OnChange(sheet, row, col ,value) {

	// [Grid_Account Information] Account Code@FOCUS_OUT	 	
	if (col == sheet1.SaveNameCol("acct_cd")) {
		var acct_cd = sheet1.CellValue(row, "acct_cd");		
		if (!ComIsNull(acct_cd)) {			
			frm.f_cmd.value = SEARCHLIST04;			
			var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do?acct_cd=" + acct_cd, FormQueryString(frm));		
			
			var code = ComGetEtcData(sXml, "code");
			var gen_expn_cd = ComGetEtcData(sXml, "gen_expn_cd");
			
			
			if (code == "0") {			
				var arr = ComXml2ListMap(sXml);				
				if (arr.length > 0 ) {
					var mdmAccount = arr[0];				
					sheet1.CellValue2(row, "eng_nm") = mdmAccount["acct_eng_nm"];
					sheet1.CellValue2(row, "krn_nm") = mdmAccount["acct_krn_nm"];					
				} else {
					//GEM01012	ENG	W	회계코드를 찾을수 없습니다.
					ComShowCodeMessage("GEM01012");

					sheet1.CellValue2(row, "acct_cd") = "";
					sheet1.CellValue2(row, "gen_expn_cd") = "";
					sheet1.CellValue2(row, "eng_nm") = "";
					sheet1.CellValue2(row, "krn_nm") = "";
					sheet1.CellValue2(row, "eng_desc") = "";
					sheet1.CellValue2(row, "krn_desc") = "";
					sheet1.SelectCell(row, "acct_cd", true);					
				}
			} else {
				if (code == "1") {
					//GEM01013	ENG	W	{?msg1} 비용코드에서 삭제된 회계코드입니다.
					ComShowCodeMessage("GEM01013", gen_expn_cd);										
				} else if (code == "2") {					
					//GEM01014	ENG	W	{?msg1} 비용코드에서 사용중 회계코드입니다.
					ComShowCodeMessage("GEM01014", gen_expn_cd);										
					
				}	
				
				sheet1.CellValue2(row, "acct_cd") = "";
				sheet1.CellValue2(row, "gen_expn_cd") = "";
				sheet1.CellValue2(row, "eng_nm") = "";
				sheet1.CellValue2(row, "krn_nm") = "";
				sheet1.CellValue2(row, "eng_desc") = "";
				sheet1.CellValue2(row, "krn_desc") = "";
				sheet1.SelectCell(row, "acct_cd", true);
			}
		}		
	}

}



/**
* sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value  
* 
*/
function sheet2_OnChange(sheet , row , col , value) {
	
	if (col == sheet2.SaveNameCol("ofc_cd")) {

		var ofc_cd = sheet2.CellValue(row, "ofc_cd");
		if (!ComIsNull(ofc_cd)) {
			frm.f_cmd.value = SEARCHLIST07;
			var sXml = sheet2.GetSearchXml(
					"CPS_GEM_0007GS.do?ofc_cd=" + ofc_cd, FormQueryString(frm));

			var errCode = ComGetEtcData(sXml, "code");
			if (errCode != "2") {
				if (errCode == "0") {
					//GEM01015	ENG	W	오피스코드가 존재 하지 않습니다.
					ComShowCodeMessage("GEM01015");
					
				} else if (errCode == "0") {
					//GEM01016	ENG	W	삭제된 오피스코드 입니다.
					ComShowCodeMessage("GEM01016");	
				}
				
				sheet1.CellValue2(row, "ofc_cd") = "";
				sheet1.SelectCell(row, "ofc_cd", true);

			}
		}
		
	} else if (col == sheet2.SaveNameCol("acct_cd")) {
		
		var gen_expn_cd = frm.gen_expn_cd;		
		var ofc_cd = sheet2.CellValue(row, "ofc_cd");
		var acct_cd = sheet2.CellValue(row, "acct_cd");
		
		if (ComIsNull(gen_expn_cd)) {
			//GEM01011	ENG	W	비용코드를 입력해주세요
			ComShowCodeMessage("GEM01011");
			gen_expn_cd.focus();
			return;			
		}
		
		if (ComIsNull(ofc_cd)) {
			//GEM01017	ENG	W	오피스코드를 입력해주세요
			ComShowCodeMessage("GEM01017");			
			sheet1.SelectCell(row, "ofc_cd", true);
			return;			
		}
		// ---------------------------------------
		// account 코드 체크 
		// ---------------------------------------
		frm.f_cmd.value = SEARCHLIST08;

		var sXml = sheet2.GetSearchXml("CPS_GEM_0007GS.do?acct_cd="+ acct_cd +"&ofc_cd="+ ofc_cd, FormQueryString(frm));
		
		var code = ComGetEtcData(sXml, "code");
		var sprt_gen_expn_cd = ComGetEtcData(sXml, "gen_expn_cd");
		
		//code : 3 정상
		//code : 0 account코드 미존재 (MDM_ACCOUNT)
		//code
		if (code == "3") {				
			sheet2.CellValue2(row, "sprt_gen_expn_cd") = sprt_gen_expn_cd;				
		} else {
			if (code == "0") {
				//GEM01015	ENG	W	오피스코드가 존재 하지 않습니다.
				ComShowCodeMessage("GEM01015");
			} else if (code == "1") {
				//GEM01018	ENG	W	Divided by Office 정보가 중복되었습니다.
				ComShowCodeMessage("GEM01018");								
			} else if (code == "2") {
				//GEM01019	ENG	W	비용코드가 존재하지 않습니다.
				ComShowCodeMessage("GEM01019");
			}
			
			sheet2.CellValue2(row, "acct_cd") = "";
			sheet2.SelectCell(row, "acct_cd", true);				
			
		}
		
		
	}

}
 


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {

	if (sAction == INIT) {
		
		frm.f_cmd.value = SEARCH;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));
		
		var arrXml = sXml.split("|$$|");
		var authFlg  = "";

		// 로그인 오피스 정보 
		if (arrXml.length > 0) {			
			var list = ComXml2ListMap(arrXml[0]);
			var officeLevelVo  = list[0];
		
			authFlg  = officeLevelVo["auth_flg"];	
		}
		// 권한 없는 Office 가 로그인 시 화면 닫음
		if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
			goNoAuthority();
			return false;
		}
	//Retrive
	} else if (sAction == SEARCHLIST) {
		
		frm.f_cmd.value = SEARCHLIST;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));
		
		var arrXml = sXml.split("|$$|");
		
		var nodata = true;
		
		if (arrXml.length > 0) {
			var list = ComXml2ListMap(arrXml[0]);
			
			if (list.length > 0) {
				
				// ---------------------------------
				// Form 설정
				// ---------------------------------				
				//prnt_gen_expn_cd|tic_cd|gen_expn_sls_div_cd|krn_abbr_nm|cre_usr_id|
				//ibflag|krn_full_nm|upd_usr_id|eng_full_nm|eng_abbr_nm|prnt_krn_abbr_nm|
				//gen_expn_acct_expt_flg|gen_expn_agre_flg|prnt_eng_abbr_nm|upd_dt|
				//gen_expn_grp_lvl|saly_flg|gen_expn_cd|delt_flg|cre_dt|pagerows|
				
				var expensInfo  = list[0];
				
				/*
				ComSetObjValue(frm.gen_expn_cd,expensInfo["gen_expn_cd"]);
				ComSetObjValue(frm.delt_flg,expensInfo["delt_flg"]);
				ComSetObjValue(frm.cre_usr_id,expensInfo["cre_usr_id"]);
				ComSetObjValue(frm.cre_dt,expensInfo["cre_dt"]);
				ComSetObjValue(frm.krn_full_nm,expensInfo["krn_full_nm"]);
				ComSetObjValue(frm.eng_full_nm,expensInfo["eng_full_nm"]);
				ComSetObjValue(frm.krn_abbr_nm,expensInfo["krn_abbr_nm"]);
				ComSetObjValue(frm.eng_abbr_nm,expensInfo["eng_abbr_nm"]);				
				
				ComSetObjValue(frm.gen_expn_agre_flg,expensInfo["gen_expn_agre_flg"]);
				ComSetObjValue(frm.saly_flg,expensInfo["saly_flg"]);
				ComSetObjValue(frm.tic_cd,expensInfo["tic_cd"]);
				ComSetObjValue(frm.gen_expn_sls_div_cd,expensInfo["gen_expn_sls_div_cd"]);
			
				ComSetObjValue(frm.prnt_krn_abbr_nm,expensInfo["prnt_krn_abbr_nm"]);
				ComSetObjValue(frm.prnt_eng_abbr_nm,expensInfo["prnt_eng_abbr_nm"]);
				ComSetObjValue(frm.gen_expn_acct_expt_flg,expensInfo["gen_expn_acct_expt_flg"]);
				ComSetObjValue(frm.gen_expn_grp_lvl,expensInfo["gen_expn_grp_lvl"]);
				ComSetObjValue(frm.prnt_gen_expn_cd,expensInfo["prnt_gen_expn_cd"]);	
				*/
				frm.reset();
				ComMapToForm(frm,expensInfo);
				
				nodata = false;
			} else {
				
				//GEM00013(There is no related data!)
				ComShowCodeMessage("GEM00013");
				var gen_expn_cd = frm.gen_expn_cd.value;				
				ComResetAll();				
				frm.gen_expn_cd.value = gen_expn_cd;
			
				nodata = true;
			}
			
		}

		if (arrXml.length > 1) {
			sheet1.LoadSearchXml(arrXml[1]);			
		}		
		
		if (arrXml.length > 2) {
			sheet2.LoadSearchXml(arrXml[2]);			
		}	

		// ---------------------------------
		// parent 콤보박스  설정
		// ---------------------------------
		if (arrXml.length > 3) {
			var expensInfo  = list[0];
			ComSetObjValue(frm.prnt_gen_expn_cd,expensInfo["prnt_gen_expn_cd"]);
			var code = expensInfo["prnt_gen_expn_cd"];
			setParent(arrXml[3] , code)		
						
		}	
		
		if (nodata) {
			frm.gen_expn_cd.focus();
		} else {
			frm.eng_full_nm.focus();
		}
		
		
	//[open]	 	
	} else if (sAction == SEARCHLIST01) {	
		frm.f_cmd.value = SEARCHLIST01;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));
		
		// ---------------------------------
		// TIC 콤보박스  설정
		// ---------------------------------
		var ticList = ComGetEtcData(sXml, "ticList").split("|");
		
		var tic_cd = frm.tic_cd;
		tic_cd.length = 0;
		
		ComAddComboItem(tic_cd,"","");
		
		for(var i=0 ; i < ticList.length ; i++ ) {
			ComAddComboItem(tic_cd,ticList[i],ticList[i]);
		}		
		
		// ---------------------------------
		// parent 콤보박스  설정
		// ---------------------------------
		
		var arr = ComXml2ListMap(sXml);		
		
		for(var i=0 ; i < arr.length ; i++ ) {			
			var expense = arr[i];
			var text = 
				expense["gen_expn_cd"]+"|"+
				expense["krn_abbr_nm"]+"|"+
				expense["eng_abbr_nm"];
			
			combo1.InsertItem(i,text,expense["gen_expn_cd"]);			
		}		
		
		combo1.Code = "";
		
		/*
		var expnGrpLvl = ComGetEtcData(sXml, "genExpnGrpLvl").split("|");
		
		var prnt_gen_expn_cd = frm.prnt_gen_expn_cd;
		prnt_gen_expn_cd.length = 0;
		
		ComAddComboItem(prnt_gen_expn_cd,"","");
		
		for(var i=0 ; i < expnGrpLvl.length ; i++ ) {
			ComAddComboItem(prnt_gen_expn_cd,expnGrpLvl[i],expnGrpLvl[i]);
		}
		*/		
		
    //[Group Level@CLICK]	 	
	} else if (sAction == SEARCHLIST02) {	
		
		var gen_expn_grp_lvl = frm.gen_expn_grp_lvl;
		
		//var prnt_gen_expn_cd = frm.prnt_gen_expn_cd;
		
		//초기화		
		//prnt_gen_expn_cd.length = 0;
		
		//ComAddComboItem(prnt_gen_expn_cd,"","");
		
		combo1.RemoveAll();
		ComSetObjValue(frm.prnt_krn_abbr_nm,"");
		ComSetObjValue(frm.prnt_eng_abbr_nm,"");
		
		//1그룹 제외		
		if ( gen_expn_grp_lvl.value == "1" ) {
			combo1.Code = "";
			return;
		} 
		
		
		frm.f_cmd.value = SEARCHLIST02;
		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));				
		
		// ---------------------------------
		// parent 콤보박스  설정
		// ---------------------------------
		
		var arr = ComXml2ListMap(sXml);		
		
		for(var i=0 ; i < arr.length ; i++ ) {			
			var expense = arr[i];
			var text = 
				expense["gen_expn_cd"]+"|"+
				expense["krn_abbr_nm"]+"|"+
				expense["eng_abbr_nm"];
			
			combo1.InsertItem(i,text,expense["gen_expn_cd"]);			
		}		
		
		combo1.Code = "";		
		
	//[Parent@CHANGE]	 	
	} else if (sAction == SEARCHLIST03) {
	
		
    // [Grid_Account Information] Account Code@FOCUS_OUT		
	} else if (sAction == SEARCHLIST04) {
				
    //[Grid_Account Information] Deleted Data@CLICK	 	
	} else if (sAction == SEARCHLIST05) {		
		frm.f_cmd.value = SEARCHLIST05;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);		
	//[Grid_Divided by Office] Deleted Data@CLICK	
	} else if (sAction == SEARCHLIST06) {	
		// divided officd yes 인경우 만 
		var gen_expn_acct_expt_flg = frm.gen_expn_acct_expt_flg;		
		/*
		if (ComGetObjValue(gen_expn_acct_expt_flg) == "Y") { 
			frm.f_cmd.value = SEARCHLIST06;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));
			sheet2.LoadSearchXml(sXml);
		}
			*/
		frm.f_cmd.value = SEARCHLIST06;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do", FormQueryString(frm));
		sheet2.LoadSearchXml(sXml);
	} else if (sAction == SEARCHLIST07) {	
		
	} else if (sAction == SEARCHLIST08) {		
		
	//[Save]	
	} else if (sAction == MULTI) {		
		frm.f_cmd.value = MULTI;
		
		//폼체크 
		if (!ComChkValid(frm)) {
			return;
		}

		
		//sheet1 row == 0 && sheet2 row == 0		
		if (sheet1.RowCount == 0 && sheet2.RowCount == 0) {
		   // msgs["GEM01055"] = "[Account Information or Divided 정보를 입력하여 주십시오]";
		   ComShowCodeMessage("GEM01055");
		   return;
		}
		
		
		//콤보값 설정
		frm.prnt_gen_expn_cd.value = combo1.Code;
		var gen_expn_grp_lvl = frm.gen_expn_grp_lvl;

		if (ComGetObjValue(gen_expn_grp_lvl) != "1") {
			if (ComIsNull(frm.prnt_gen_expn_cd.value)) {
				//'Please select {?msg1}';
				ComShowCodeMessage("COM12113" , "Parent");			
				return;
			}
		}
			
		var sParam = FormQueryString(frm);
		
		var sParam1 = sheet1.GetSaveString(); 
		
		if (sheet1.IsDataModified && sParam1 == "") {				
			return; 
		} else {
			
			//중복데이타 체크
			var acct_cd_list = new Array();
			
			for(var row = 0 ; row < sheet1.RowCount   ; row++ ) {					
				acct_cd_list[row] = 
					sheet1.CellValue(row + 2, "acct_cd");
			}
			
			if ( ComIsDupData(acct_cd_list) ) {
				//GEM01020	ENG	W	Account Information 에 중복된 회계코드가 존재합니다.
				ComShowCodeMessage("GEM01020");
				return ;
			}
			
			if (!ComIsNull(sParam1)) { 
				sParam1 = ComSetPrifix(sParam1, "sheet1_");
				sParam = sParam + "&" + sParam1;
			}
		}
					
		var sParam2 = sheet2.GetSaveString(); 
		if (sheet2.IsDataModified && sParam2 == "")  {			
			return; 
		} else {
			
			//중복데이타 체크
			var acct_cd_list = new Array(); 
			
			for(var row = 0 ; row < sheet2.RowCount ; row++ ) {					
				acct_cd_list[acct_cd_list.length] = 
					sheet2.CellValue(row + 2, "ofc_cd") + 
					sheet2.CellValue(row + 2, "acct_cd")  ; 
			}
			
			if ( ComIsDupData(acct_cd_list) ) {
				//GEM01021	ENG	W	Divided by Office에 중복된 오피스, 회계코드가 존재합니다.
				ComShowCodeMessage("GEM01021");
				return ;
			}
			
			if (!ComIsNull(sParam2)) {
				sParam2 = ComSetPrifix(sParam2, "sheet2_");
				sParam = sParam + "&" + sParam2;
			}
		}
		
		// Divided by Office check 여부 
		if (ComGetObjValue(frm.acct_expt_delt_flg) != "Y" &&  
				SheetRowCount(sheet2) == 0 ) {				
			ComSetObjValue(frm.gen_expn_acct_expt_flg,"N");
		}
		
		
		var sXml = sheet1.GetSaveXml("CPS_GEM_0007GS.do", sParam );						
		sheet1.LoadSaveXml(sXml);		
		doActionIBSheet(SEARCHLIST05);
		doActionIBSheet(SEARCHLIST06);

		
	}  
 	
 
}
 
 

 
