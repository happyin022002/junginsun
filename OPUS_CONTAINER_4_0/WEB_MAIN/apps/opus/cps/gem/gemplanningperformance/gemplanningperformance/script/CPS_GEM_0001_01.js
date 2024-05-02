/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0001_01.js
 *@FileTitle : [CPS_GEM-0001_01] Expense Request – Initial & Additional
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM-0001_01] Expense Request – Initial & Additional
 * @extends
 * @class Expense Request – Initial & Additional생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0001_01() {
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
// #Form Command#IBSheet Action 
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
//         IBROWSEARCH    = 10; // Row 조회     
//         IBCREATE       = 11; // Create       
//         IBRESET        = 12; // Reset        
//         IBBATCH        = 13; // Batch        
// =============================================================



// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;
var sheet3 = null;
var curYear = "";
var curMon = "";

// html form
var frm = null;

//Initial 마감정보
var initDateVO = null;
//additional 마감정보 
var closingDateVO = null;

//note팝업창 
var noteWin = null;
//assigend pop up
var assWin = null;
//request no  pop up win
var reqWin = null;
//글자 깜박
var intervalID ;

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
 * @param {string} year 현재 년도
 **/
function loadPage(year) {
	
	
	//현재 년도 설정
	curYear = year;
	

    //전역 변수 설정 
    frm = document.form;
   
	curMon = frm.pln_mon.value;
	
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];    
    sheet3 = sheetObjects[2];
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);    
    }
    
    //Form 이벤트 등록
    initControl();
    

    
	//iframe 사이즈 자동조절
    resizeIframe("t1frame");

}

/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function sheet1_OnLoadFinish(sheet) {
	 sheet.WaitImageVisible = false;	    
	 //오피스 콤보 호출
	 doActionIBSheet(SEARCHLIST20); 
	 //OPEN화면 호출
	 doActionIBSheet(INIT);
	 sheet.WaitImageVisible = true;	 
	 parent.document.form.tab1.Enable = true;
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
			  style.height = 340;
			
			  //전체 너비 설정
			  SheetWidth = mainTable.clientWidth;
			
			  //Host정보 설정[필수][HostIp, Port, PagePath]
			  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			  //전체Merge 종류 [선택, Default msNone]
			  MergeSheet = msNone;
			
			 //전체Edit 허용 여부 [선택, Default false]
			  Editable = true;
			  MultiSelection = false;
			  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			  InitRowInfo(1, 1, 15, 100);
			
			  var HeadTitle1 = "|Select|OFC|Code|Item|gen_expn_trns_div_cd|gen_expn_rqst_seq|crnt_gen_expn_apro_step_cd|crnt_gen_expn_apsts_cd|gen_expn_itm_desc|gen_expn_calc_bss_desc|rqst_opin_rmk|jan_amt|feb_amt|mar_amt|apr_amt|may_amt|jun_amt|jul_amt|aug_amt|sep_amt|oct_amt|nov_amt|dec_amt";
			      HeadTitle1 += "|rqst_jan_amt|rqst_feb_amt|rqst_mar_amt|rqst_apr_amt|rqst_may_amt|rqst_jun_amt|rqst_jul_amt|rqst_aug_amt|rqst_sep_amt|rqst_oct_amt|rqst_nov_amt|rqst_dec_amt|chk_assigned|eng_abbr_nm|krn_abbr_nm|rqst_locl_amt|rqst_usd_amt|tic_cd|ofc_lvl1|ofc_lvl2|sls_ofc_div_cd|ttl";   
			      HeadTitle1 += "|usd_locl_xch_rt|rqst_ut_val|locl_curr_cd|add_flg|itm_upd_dt|req_upd_dt";
			  var headCount = ComCountHeadTitle(HeadTitle1);
			        
			  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]   
			  InitColumnInfo(headCount, 0, 0, true);   
			        
			  // 해더에서 처리할 수 있는 각종 기능을 설정한다         
			  InitHeadMode(false, false, false, true, false,false)
			  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			  InitHeadRow(0, HeadTitle1, true);        
        
			  //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]   
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,"ibflag");					  
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true,"delChk");       
			  
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"ofc_cd",			false,		"",		dfNone,		0,			false,			false,		6);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"gen_expn_cd",			true,		"",		dfNone,		0,			false,			true,		6);   
			InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,		"gen_expn_itm_no",			false,		"",		dfNone,		0,			false,			false,		3);			
			// ------------------------------------------------------------------------------------------1  
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_trns_div_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_rqst_seq");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apsts_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_itm_desc", true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_calc_bss_desc" , true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_opin_rmk");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"jan_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"feb_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"mar_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"apr_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"may_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"jun_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"jul_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"aug_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"sep_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"oct_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"nov_amt" , false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"dec_amt" , false , "",dfInteger);

			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_jan_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_feb_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_mar_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_apr_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_may_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_jun_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_jul_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_aug_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_sep_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_oct_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_nov_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_dec_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"chk_assigned");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_locl_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_usd_amt", false , "",dfFloat , 4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"tic_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"ofc_lvl1");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"ofc_lvl2");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"sls_ofc_div_cd");			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"ttl", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"usd_locl_xch_rt", false , "",dfFloat , 4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"locl_curr_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"add_flg");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"itm_upd_dt");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"req_upd_dt");
			InitDataValid(0,    "gen_expn_cd",   vtNumericOnly);
			
			break;

		case "sheet2":

			  // 높이 설정
			  style.height = 100;
			
			  //전체 너비 설정
			  SheetWidth = mainTable.clientWidth;
			
			  //Host정보 설정[필수][HostIp, Port, PagePath]
			  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			  //전체Merge 종류 [선택, Default msNone]
			  MergeSheet = msNone;
			
			 //전체Edit 허용 여부 [선택, Default false]
			  Editable = true;
			
			  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			  InitRowInfo(1, 1, 15, 100);
			
						var HeadTitle1 = "||TTL|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC";
			  var headCount = ComCountHeadTitle(HeadTitle1);
			
			  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			  InitColumnInfo(headCount, 3, 0, true);
			
			  // 해더에서 처리할 수 있는 각종 기능을 설정한다
			  InitHeadMode(false, false, false, true, false,false);
			
			  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			  InitHeadRow(0, HeadTitle1, true);
			
			  //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtImageText,	80,		daCenter,	true,       "title",		false,		"",			dfNone,		0,			false,		false);			
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"ttl",			false,		"|jan_amt|+|feb_amt|+|mar_amt|+|apr_amt|+|may_amt|+|jun_amt|+|jul_amt|+|aug_amt|+|sep_amt|+|oct_amt|+|nov_amt|+|dec_amt|" ,	dfNullInteger );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jan_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"feb_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"mar_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"apr_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"may_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jun_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jul_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aug_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"sep_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"oct_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"nov_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"dec_amt",			false,		"",			dfNullInteger , 0 , false , false ,9 );
				
				
				ColBackColor("title") = WebColor("#EBF6F9");
				
				//CountPosition = 0;
				ImageList(0) = KeyFieldImage ;
				SelectionMode = smSelectionFree ;
				break;			
		case "sheet3":
			  if (location.hostname != "") {
			  	WaitImageVisible = false; 
			  	InitHostInfo(location.hostname, location.port, page_path);
			  }
						break;
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
  /**
   * 예산년도의 비용코드에 대한 시트에서 SEQ MAX + 1 취득
   *   
   */
 function getMaxSeq() {
 	
	var genExpnRqstSeq = 1;
	
 	for ( var i = 0; i < sheet1.RowCount ; i++) {
 		var row =  i + 1;
 		if (sheet1.RowStatus(row) == "D")  {
 			continue;
 		}
 		
 		var gen_expn_rqst_seq = 
 			sheet1.CellValue(row , "gen_expn_rqst_seq");
 	
 		// 시트에 존재하는 SEQ가  이전 SEQ보다 클경우 시트의  SEQ으로  설정 		
		if (gen_expn_rqst_seq >= genExpnRqstSeq) {
			//최대값 + 1
			gen_expn_rqst_seq = parseInt(gen_expn_rqst_seq , 10) + 1;
			genExpnRqstSeq = gen_expn_rqst_seq;
		}
		
 	}
 	
	if (genExpnRqstSeq < 10) {
		genExpnRqstSeq = "000" + genExpnRqstSeq;
	} else if (genExpnRqstSeq < 100) {
		genExpnRqstSeq = "00" + genExpnRqstSeq;
	} else if (genExpnRqstSeq < 1000) {
		genExpnRqstSeq = "0" + genExpnRqstSeq;
	}
	
 	return genExpnRqstSeq ;
 	
 	
 }

 /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   * 그리드 클릭시
   */
function validateForm(){
	
	var rowNum = getRowNum();
	
	if (rowNum < 1) {
		if (!ComChkObjValid(frm.ofc_lvl3)) {			
			return false;
		}
		
		return true;
	}
	
	//폼체크	
	if (!ComChkRequired(frm)) {
		sheet1.SelectRow = rowNum;
		sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
		return false;
	}
	
	var rqst_locl_amt = frm.rqst_locl_amt.value;
	
	var sheet2_ttl = sheet2.CellText(2,"ttl");
	
	if (rqst_locl_amt != sheet2_ttl) {
		//msgs["GEM01040"] = "RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.";
		ComShowCodeMessage("GEM01040" , document.getElementById("locl_curr_cd").innerText);
		sheet1.SelectRow = rowNum;
		sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
		return false;
	}		

	return true;
	

}

/**
  *  다른사용자가 
  *  이미 수정한경우 1
  *  미수정 2
  *  Request NO 미존재 3
  * @return {string} 1(수정) , 2(미수정) , 3(Request No미존재) 
  * @author 진윤오
  * @version 2009.05.13
  */
function checkChangedData() {
	var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
	
	var param = "f_cmd=" + SEARCH;
	param += "&gen_expn_rqst_no=" + gen_expn_rqst_no;	
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);
	var updDt = ComGetEtcData(sXml ,"reqDt");
	
	if (ComIsNull(updDt)) {
		return "3";
	}
	
	var reqUpdDt = frm.req_upd_dt.value;
	
	if (updDt == reqUpdDt ) {
		return "2";
	} else {
		return "1";
	}
	
}   

/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function stopBlink() {
	clearInterval(intervalID);
	var elm = document.getElementById("btn_authorized");
	elm.style.color = "black";	
}
/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function startBlink() {
	
	if (ComIsNull(frm.ofc_lvl3.value)) {
		return;
	}
	
	intervalID = setInterval(doBlink, 1000);
}
   
/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function doBlink() {
	var elm = document.getElementById("btn_authorized");		
	if ( elm.style.color == "red") {
		elm.style.color = "black";
	} else {
		elm.style.color = "red";
	}
}


/**
 * 시트 유효성검증 프로세스 처리
 * 버튼 클릭시 
 */
function validateSheet() {
	
	var cnt = SheetRowCount(sheet1);
	//최초 입력 이외의 경우  
	if (cnt > 0 ) {
		
		for ( var i = 0; i < sheet1.RowCount  ;i++) {
			var row = i + 1;
			if (sheet1.RowStatus(row) == "D")  {
				continue;
			}
			
			var gen_expn_cd = sheet1.CellValue(row,"gen_expn_cd");
			
			if (ComIsNull(gen_expn_cd )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Code");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"gen_expn_cd",true);
				return false ;
			}
			
			var gen_expn_itm_desc = sheet1.CellValue(row,"gen_expn_itm_desc");
			if (ComIsNull(gen_expn_itm_desc )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Request Item Description");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"gen_expn_cd",true);
				return false ;
			}

			
			var gen_expn_calc_bss_desc = sheet1.CellValue(row,"gen_expn_calc_bss_desc");
			if (ComIsNull(gen_expn_calc_bss_desc )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Calculation Basis");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(row,"gen_expn_cd",true);
				return false ;
			}
			
			var rqst_locl_amt = sheet1.CellValue(row,"rqst_locl_amt");
			
			if (ComIsNull(rqst_locl_amt ) || rqst_locl_amt == 0) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "RQST Amount");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"gen_expn_cd",true);
				return false ;
			}
			
			
			var ttl = sheet1.CellValue(row,"ttl");
			
			if (rqst_locl_amt != ttl ) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" , rqst_locl_amt);		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"gen_expn_cd",true);
				return false ;
			}
			
			
			
			
		}
		
	}
	
	
	return true;
}
 
 
/**
  * 팝업에서 genExpnRqstNo 받음
  */
function setGenExpnRqstNo(genExpnRqstNo) {
	frm.gen_expn_rqst_no.value = genExpnRqstNo;
	doActionIBSheet(SEARCHLIST);
}
  
/**
  * 팝업에서 노트 정보 받음 받음
  */
function setNote(type , text) {
	if (type == "A") {
		frm.gen_expn_itm_desc.value = text;
	} else if (type == "B") {
		frm.gen_expn_calc_bss_desc.value = text;
	} else if (type == "C") {
		frm.rqst_opin_rmk.value = text;
	}
}

/**
 * 팝업에서 expenseCode를 받음
 */
function setExpenseCode(expenseInfoList) {
	 var plnYrmon =  frm.pln_yr.value;
	 
	for ( var i = 0; i < expenseInfoList.length; i++) {
		var expenseInfo = expenseInfoList[i];		
		var row = sheet1.DataInsert(-1);
		frm.rownum.value = row;
		
		sheet1.CellValue2(row,"ofc_cd") = expenseInfo.ofc_cd;
		sheet1.CellValue2(row,"ofc_lvl1") = frm.ofc_lvl1.value;
		sheet1.CellValue2(row,"ofc_lvl2") = frm.ofc_lvl2.value;

		if (frm.sls_ofc_div_cd[0].checked) {
			sheet1.CellValue2(row,"sls_ofc_div_cd") = "N"
		} else {
			sheet1.CellValue2(row,"sls_ofc_div_cd") = "Y"
		}
		
		sheet1.CellValue2(row,"gen_expn_cd") = expenseInfo.gen_expn_cd;
		sheet1.CellValue2(row,"tic_cd") = expenseInfo.tic_cd;
		sheet1.CellValue2(row,"krn_abbr_nm") = expenseInfo.krn_abbr_nm;
		sheet1.CellValue2(row,"eng_abbr_nm") = expenseInfo.eng_abbr_nm;
		
		//MaxItem 취득 
		var itemNo = searchMaxItem(plnYrmon ,
				    expenseInfo.ofc_cd ,
				    expenseInfo.gen_expn_cd);		
		itemNo = getGenExpnItmNo(expenseInfo.ofc_cd  , 
				  expenseInfo.gen_expn_cd , 
				  itemNo);		
		//시트에서 max값 취득
		sheet1.CellValue2(row , "gen_expn_itm_no") = itemNo;
		
		//통화정보 변경
		sheet1.CellValue2(row, "locl_curr_cd") = 
			document.getElementById("locl_curr_cd").innerText;
		sheet1.CellValue2(row, "usd_locl_xch_rt") = frm.usd_locl_xch_rt.value;
		sheet1.CellValue2(row, "rqst_ut_val") = frm.rqst_ut_val.value;
		
		//시퀀스 설정
		sheet1.CellValue2(row,"gen_expn_rqst_seq") = getMaxSeq();
		//ADD로 설정
		sheet1.CellValue2(row , "add_flg") = "ADD";
	}
	
	setSheet1ToForm(1);
	sheet1.SelectRow = 1;
	sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
}

 /**
 * 팝업에서 Assigned Expense 정보전달 
 * @param {json}  expenseInfo Assigned Expense 정보
 */
function setAssignedExpense(expenseInfo) {
		
	sheet2.CellValue2(1 , "jan_amt") = expenseInfo.jan_amt;
	sheet2.CellValue2(1 , "feb_amt") = expenseInfo.feb_amt;
	sheet2.CellValue2(1 , "mar_amt") = expenseInfo.mar_amt;
	sheet2.CellValue2(1 , "apr_amt") = expenseInfo.apr_amt;
	sheet2.CellValue2(1 , "may_amt") = expenseInfo.may_amt;
	sheet2.CellValue2(1 , "jun_amt") = expenseInfo.jun_amt;
	sheet2.CellValue2(1 , "jul_amt") = expenseInfo.jul_amt;
	sheet2.CellValue2(1 , "aug_amt") = expenseInfo.aug_amt;
	sheet2.CellValue2(1 , "sep_amt") = expenseInfo.sep_amt;
	sheet2.CellValue2(1 , "oct_amt") = expenseInfo.oct_amt;
	sheet2.CellValue2(1 , "nov_amt") = expenseInfo.nov_amt;
	sheet2.CellValue2(1 , "dec_amt") = expenseInfo.dec_amt;
	
	var row = getRowNum();
	
	frm.gen_expn_itm_desc.value = expenseInfo.gen_expn_itm_desc;    
	frm.gen_expn_itm_no.value   = expenseInfo.gen_expn_itm_no;
	
	if (row > 0 ) {
		sheet1.CellValue2(row , "gen_expn_itm_no") = expenseInfo.gen_expn_itm_no;
		sheet1.CellValue2(row , "jan_amt") = expenseInfo.jan_amt;
		sheet1.CellValue2(row , "feb_amt") = expenseInfo.feb_amt;
		sheet1.CellValue2(row , "mar_amt") = expenseInfo.mar_amt;
		sheet1.CellValue2(row , "apr_amt") = expenseInfo.apr_amt;
		sheet1.CellValue2(row , "may_amt") = expenseInfo.may_amt;
		sheet1.CellValue2(row , "jun_amt") = expenseInfo.jun_amt;
		sheet1.CellValue2(row , "jul_amt") = expenseInfo.jul_amt;
		sheet1.CellValue2(row , "aug_amt") = expenseInfo.aug_amt;
		sheet1.CellValue2(row , "sep_amt") = expenseInfo.sep_amt;
		sheet1.CellValue2(row , "oct_amt") = expenseInfo.oct_amt;
		sheet1.CellValue2(row , "nov_amt") = expenseInfo.nov_amt;
		sheet1.CellValue2(row , "dec_amt") = expenseInfo.dec_amt;
	}
	
	
	frm.chk_assigned.checked = true;
	
	frm.gen_expn_itm_desc.readOnly = true;
	
	
}
 
 /**
  * 마감일 정보 표시
  * @param {array} closingDateVO 마감정보
  */
function printClosingDate(closingDateVO) {
	
	var clzYrmon = 	closingDateVO["clz_yrmon"];	
	frm.pln_yrmon.value = clzYrmon;
	
	var clzDt = closingDateVO["clz_dt"];
	
	var clzYr = clzYrmon.substring(0,4);
	var clzMon = clzYrmon.substring(4,6);
	
	//Request Enable
	var mon = parseInt(clzMon , 10);
	
	
	if (frm.gen_expn_rqst_tp_cd[0].checked) {
		for ( var i = 0; i < 12; i++) {
			sheet2.CellEditable(2,i+3) = true;
		}
	} else {
		for ( var i = 0; i < 12; i++) {			
			if ( i >= mon-1) {
				sheet2.CellEditable(2,i+3) = true;
			} else {
				sheet2.CellEditable(2,i+3) = false;
			}
		} 
		
	}
	
	var clzDtYr = clzDt.substring(0,4);
	var clzDtMon = clzDt.substring(4,6);
	var clzDtDay = clzDt.substring(6,8);
	
	document.getElementById("clz_yrmon").innerText = 
		getEngMonthName(clzMon) + " " + clzYr;			
	
	document.getElementById("clz_day").innerText = clzDtDay;
	
	document.getElementById("clz_dt").innerText = 
		getEngMonthName(clzDtMon) + " " + clzDtYr;	
	
}


  
/**
 * 예산년도의 비용코드에 대한 서버의 Max Item No 취득 
 * @param {string} ofcCd 오피스코드
 * @param {string} genExpnCd 비요코드
 * @param {string} itemNo 아이템번호
 */
function searchMaxItem(plnYrmon , ofcCd , genExpnCd ) {
	
	var param = "f_cmd=" + SEARCHLIST01;
	   param += "&pln_yrmon=" + plnYrmon + 
	  "&ofc_cd=" + ofcCd + 
	  "&gen_expn_cd=" + genExpnCd;
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);		
	return ComGetEtcData(sXml ,"itemNo");
}


  
/**
  * 예산년도의 비용코드에 대한 시트에서 Item No 취득 
  * @param {string} ofcCd 오피스코드
  * @param {string} genExpnCd 비요코드
  * @param {string} itemNo 아이템번호
  */
function getGenExpnItmNo(ofcCd , genExpnCd , itemNo) {
	
	var genExpnItmNo = parseInt(itemNo, 10);
	
	for ( var i = 0; i < sheet1.RowCount ; i++) {
		var row =  i + 1;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		}
		
		//gen_expn_cd , gen_expn_itm_no
		var sOfcCd = sheet1.CellValue(row , "ofc_cd");
		var sGenExpnCd = sheet1.CellValue(row , "gen_expn_cd");
		var sItemNo = sheet1.CellValue(row , "gen_expn_itm_no");
		
		if (ComIsNull(sItemNo)) {
			continue;
		}
		
		sItemNo =  parseInt(sItemNo , 10);
		//오피스 , 비용코드가 같을경우
		if (ofcCd ==  sOfcCd  && genExpnCd == sGenExpnCd) {
			// 시트에 존재하는 itemNo가  인자로 받은 ItemNo보다 클경우 시트의  Item으로  설정
			if (sItemNo >= genExpnItmNo) {
				//최대값 + 1
				genExpnItmNo = sItemNo + 1;
			}
		}
		
	}
	
	if (genExpnItmNo < 10) {
		genExpnItmNo = "00" + genExpnItmNo;
	} else if (genExpnItmNo < 100) {
		genExpnItmNo = "0" + genExpnItmNo;
	} 
	
	return genExpnItmNo ;
	
	
}
  
/**   
 * 폼데이타 (item + apro_step) 을 sheet1에 ofc_cd , gen_expn_cd , item별 저장    
 * @param {long} row 시트 행번호    
 */   
function setFormToSheet1() {
	 
	var row  = getRowNum();
	
	if (row > 0 ) {
		
		sheet1.CellValue2(row,"gen_expn_itm_desc") = ComGetObjValue(frm.gen_expn_itm_desc);        
		sheet1.CellValue2(row,"gen_expn_calc_bss_desc") = ComGetObjValue(frm.gen_expn_calc_bss_desc);   
		sheet1.CellValue2(row,"rqst_opin_rmk") = ComGetObjValue(frm.rqst_opin_rmk);   
		      
		sheet1.CellValue2(row,"jan_amt") = sheet2.CellValue(1 , "jan_amt");    
		sheet1.CellValue2(row,"feb_amt") = sheet2.CellValue(1 , "feb_amt");    
		sheet1.CellValue2(row,"mar_amt") = sheet2.CellValue(1 , "mar_amt");    
		sheet1.CellValue2(row,"apr_amt") = sheet2.CellValue(1 , "apr_amt");    
		sheet1.CellValue2(row,"may_amt") = sheet2.CellValue(1 , "may_amt");    
		sheet1.CellValue2(row,"jun_amt") = sheet2.CellValue(1 , "jun_amt");    
		sheet1.CellValue2(row,"jul_amt") = sheet2.CellValue(1 , "jul_amt");    
		sheet1.CellValue2(row,"aug_amt") = sheet2.CellValue(1 , "aug_amt");    
		sheet1.CellValue2(row,"sep_amt") = sheet2.CellValue(1 , "sep_amt");    
		sheet1.CellValue2(row,"oct_amt") = sheet2.CellValue(1 , "oct_amt");    
		sheet1.CellValue2(row,"nov_amt") = sheet2.CellValue(1 , "nov_amt");    
		sheet1.CellValue2(row,"dec_amt") = sheet2.CellValue(1 , "dec_amt");    
	      
		sheet1.CellValue2(row,"rqst_jan_amt") = sheet2.CellValue(2 , "jan_amt");    
		sheet1.CellValue2(row,"rqst_feb_amt") = sheet2.CellValue(2 , "feb_amt");    
		sheet1.CellValue2(row,"rqst_mar_amt") = sheet2.CellValue(2 , "mar_amt");    
		sheet1.CellValue2(row,"rqst_apr_amt") = sheet2.CellValue(2 , "apr_amt");    
		sheet1.CellValue2(row,"rqst_may_amt") = sheet2.CellValue(2 , "may_amt");    
		sheet1.CellValue2(row,"rqst_jun_amt") = sheet2.CellValue(2 , "jun_amt");    
		sheet1.CellValue2(row,"rqst_jul_amt") = sheet2.CellValue(2 , "jul_amt");    
		sheet1.CellValue2(row,"rqst_aug_amt") = sheet2.CellValue(2 , "aug_amt");    
		sheet1.CellValue2(row,"rqst_sep_amt") = sheet2.CellValue(2 , "sep_amt");    
		sheet1.CellValue2(row,"rqst_oct_amt") = sheet2.CellValue(2 , "oct_amt");    
		sheet1.CellValue2(row,"rqst_nov_amt") = sheet2.CellValue(2 , "nov_amt");    
		sheet1.CellValue2(row,"rqst_dec_amt") = sheet2.CellValue(2 , "dec_amt");
		sheet1.CellValue2(row,"ttl") = sheet2.CellValue(2 , "ttl");
		
		
		sheet1.CellValue2(row,"chk_assigned") = ComGetObjValue(frm.chk_assigned);   
		//sheet1.CellValue2(row,"eng_abbr_nm") = ComGetObjValue(frm.eng_abbr_nm);    
		//sheet1.CellValue2(row,"krn_abbr_nm") = ComGetObjValue(frm.krn_abbr_nm);    
		sheet1.CellValue2(row,"rqst_locl_amt") = ComTrimAll(ComGetObjValue(frm.rqst_locl_amt),",");  
		sheet1.CellValue2(row,"rqst_usd_amt") = ComTrimAll(ComGetObjValue(frm.rqst_usd_amt),",");   
		//sheet1.CellValue2(row,"tic_cd") = ComGetObjValue(frm.tic_cd);

		
		if ( !ComIsNull(frm.gen_expn_itm_no.value) &&
				!ComIsNull(frm.gen_expn_calc_bss_desc.value) &&
				!ComIsNull(frm.rqst_locl_amt.value)
			) {		
			//편집 데이타 표시
			sheet1.RowFontColor(row) = sheet1.WebColor("#0000FF");
			sheet1.CellFont ("FontUnderline", row, "ofc_cd", row, "gen_expn_cd") = true;
		}
		
		//USD total;
		var usdTotal = getUsdTotal();
		
		frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,3));

		
		
	}

	      
}       

 
 
 
/**     
* 시트 sheet1에데이타를 form,sheet2에 설정
* @param {long} row 시트 행번호      
*/     
function setSheet1ToForm( row ) {   
	
	//hidden
	ComSetObjValue(frm.ofc_cd , sheet1.CellValue(row, "ofc_cd"));   
	ComSetObjValue(frm.rownum , row);
	
	//OFFICE 설정
	if (frm.ofc_lvl3.value != sheet1.CellValue(row , "ofc_cd")) {
		var sls_ofc_div_cd = sheet1.CellValue(row , "sls_ofc_div_cd");	
		frm.sls_ofc_div_cd[0].checked = false;
		frm.sls_ofc_div_cd[1].checked = false;
		if (sls_ofc_div_cd == "N") {
			frm.sls_ofc_div_cd[0].checked = true;
		} else {
			frm.sls_ofc_div_cd[1].checked = true;
		}		
		//LV1
		ComSetObjValue(frm.ofc_lvl1               , sheet1.CellValue(row , "ofc_lvl1"));
		//LV2
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');
		ComSetObjValue(frm.ofc_lvl2               , sheet1.CellValue(row , "ofc_lvl2"));
		//LV3
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');			
		ComSetObjValue(frm.ofc_lvl3               , sheet1.CellValue(row , "ofc_cd"));
		frm.ofc_lvl3.blur();
	}
	
	ComSetObjValue(frm.gen_expn_cd , sheet1.CellValue(row, "gen_expn_cd" ) );   
	ComSetObjValue(frm.gen_expn_itm_no , sheet1.CellValue(row, "gen_expn_itm_no") );
	frm.gen_expn_itm_desc.value = sheet1.CellValue(row,"gen_expn_itm_desc");	
	frm.gen_expn_itm_desc.readOnly = false;	
	ComSetObjValue(frm.gen_expn_calc_bss_desc,sheet1.CellValue(row,"gen_expn_calc_bss_desc"));   
	ComSetObjValue(frm.rqst_opin_rmk,sheet1.CellValue(row, "rqst_opin_rmk"));
	sheet2.CellValue2(1 , "jan_amt") = sheet1.CellValue(row, "jan_amt");
	sheet2.CellValue2(1 , "feb_amt") = sheet1.CellValue(row, "feb_amt");         
	sheet2.CellValue2(1 , "mar_amt") = sheet1.CellValue(row, "mar_amt");         
	sheet2.CellValue2(1 , "apr_amt") = sheet1.CellValue(row, "apr_amt");         
	sheet2.CellValue2(1 , "may_amt") = sheet1.CellValue(row, "may_amt");         
	sheet2.CellValue2(1 , "jun_amt") = sheet1.CellValue(row, "jun_amt");         
	sheet2.CellValue2(1 , "jul_amt") = sheet1.CellValue(row, "jul_amt");         
	sheet2.CellValue2(1 , "aug_amt") = sheet1.CellValue(row, "aug_amt");         
	sheet2.CellValue2(1 , "sep_amt") = sheet1.CellValue(row, "sep_amt");         
	sheet2.CellValue2(1 , "oct_amt") = sheet1.CellValue(row, "oct_amt");         
	sheet2.CellValue2(1 , "nov_amt") = sheet1.CellValue(row, "nov_amt");         
	sheet2.CellValue2(1 , "dec_amt") = sheet1.CellValue(row, "dec_amt");         
	sheet2.CellValue2(2 , "jan_amt") = sheet1.CellValue(row, "rqst_jan_amt");         
	sheet2.CellValue2(2 , "feb_amt") = sheet1.CellValue(row, "rqst_feb_amt");         
	sheet2.CellValue2(2 , "mar_amt") = sheet1.CellValue(row, "rqst_mar_amt");         
	sheet2.CellValue2(2 , "apr_amt") = sheet1.CellValue(row, "rqst_apr_amt");         
	sheet2.CellValue2(2 , "may_amt") = sheet1.CellValue(row, "rqst_may_amt");         
	sheet2.CellValue2(2 , "jun_amt") = sheet1.CellValue(row, "rqst_jun_amt");         
	sheet2.CellValue2(2 , "jul_amt") = sheet1.CellValue(row, "rqst_jul_amt");         
	sheet2.CellValue2(2 , "aug_amt") = sheet1.CellValue(row, "rqst_aug_amt");         
	sheet2.CellValue2(2 , "sep_amt") = sheet1.CellValue(row, "rqst_sep_amt");         
	sheet2.CellValue2(2 , "oct_amt") = sheet1.CellValue(row, "rqst_oct_amt");         
	sheet2.CellValue2(2 , "nov_amt") = sheet1.CellValue(row, "rqst_nov_amt");         
	sheet2.CellValue2(2 , "dec_amt") = sheet1.CellValue(row, "rqst_dec_amt");
	
	frm.chk_assigned.disabled = false;
	
	// initial인경우 disable
	if (ComGetObjValue(frm.gen_expn_rqst_tp_cd) == "EI") {
		frm.chk_assigned.disabled = true;		
	}

	
	frm.chk_assigned.checked = false;
	
	if (sheet2.CellValue(1,"ttl") > 0) {		
		frm.chk_assigned.checked = true;		
	}

	//item desc설정
	frm.gen_expn_itm_desc.readOnly = false;	
	
	//조회데이타이면 assigned disable
	if (ComIsNull(sheet1.CellValue(row , "add_flg"))) {
		frm.chk_assigned.disabled = true;		
		if (frm.chk_assigned.checked) {
			frm.gen_expn_itm_desc.readOnly = true;
		}
	}
		
	ComSetObjValue(frm.tic_cd , sheet1.CellValue(row, "tic_cd" ) );
	
	if (ComGetObjValue(frm.lang_div) == "KOR") {
		ComSetObjValue(frm.gen_expn_cd_abbr_name , sheet1.CellValue(row, "krn_abbr_nm")) ;
	} else {
		ComSetObjValue(frm.gen_expn_cd_abbr_name , sheet1.CellValue(row, "eng_abbr_nm"));			
	}
	
	//hidden
	ComSetObjValue(frm.eng_abbr_nm , sheet1.CellValue(row, "eng_abbr_nm") );
	ComSetObjValue(frm.krn_abbr_nm , sheet1.CellValue(row, "krn_abbr_nm") );
	
	//요청금액
	if (sheet1.CellValue(row, "rqst_locl_amt") == 0) {
		ComSetObjValue(frm.rqst_locl_amt , "");
	} else {
		ComSetObjValue(frm.rqst_locl_amt , sheet1.CellText(row, "rqst_locl_amt"));
	}
	
	
	//통화정보 변경
	var locl_curr_cd = sheet1.CellValue(row, "locl_curr_cd");
	var usd_locl_xch_rt = sheet1.CellValue(row, "usd_locl_xch_rt");
	var rqst_ut_val = sheet1.CellValue(row, "rqst_ut_val");
	var rqst_usd_amt = sheet1.CellValue(row, "rqst_usd_amt");
	if (rqst_usd_amt == 0) {
		frm.rqst_usd_amt.value = "";	
	} else {
		frm.rqst_usd_amt.value = rqst_usd_amt;
	}
		
	
	
	
	if (ComIsNull(locl_curr_cd) || usd_locl_xch_rt == 0.0000 || rqst_ut_val == 0) {
		var plnYear = frm.pln_yr.value;

		var ofcCd = frm.ofc_cd.value;	
		
		if ( ComIsNull(ofcCd) ) {
			return;
		}
			
		var officeLevelVo = getCurrInfo(plnYear, ofcCd);
		
		var loclCurrCd  = officeLevelVo["locl_curr_cd"];
		var usdLoclXchRt   = officeLevelVo["usd_locl_xch_rt"];
		var rqstUtVal   = officeLevelVo["rqst_ut_val"];
		
		//환율, 통화 정보 설정			
		document.getElementById("locl_curr_cd").innerText = loclCurrCd;
		//USD
		frm.usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
		//단위
		frm.rqst_ut_val.value = ComAddComma(rqstUtVal);
		
	} else {
		
		//환율, 통화 정보 설정			
		document.getElementById("locl_curr_cd").innerText = locl_curr_cd;
		//USD
		frm.usd_locl_xch_rt.value = ComAddComma(usd_locl_xch_rt);
		//단위
		frm.rqst_ut_val.value = ComAddComma(rqst_ut_val);
		
	}
		
	//환율 계산	
	if (!ComIsNull(frm.rqst_locl_amt.value)) {
		setUsdAmt();
	}
	
	
	// [patch] 2009-10-05 cyo 배타체크 추가	
	// [patch] 2009-11-03 cyo 삭제
	//frm.req_upd_dt.value = sheet1.CellValue(row, "req_upd_dt");
	//frm.itm_upd_dt.value = sheet1.CellValue(row, "itm_upd_dt");
	
}


/**     
 * 폼 초기화       
 */         
function resetForm() {    
	 
	//ComSetObjValue(frm.gen_expn_rqst_no      , "");
	
	ComSetObjValue(frm.ofc_cd , "");  
	ComSetObjValue(frm.gen_expn_cd , "");  
	ComSetObjValue(frm.gen_expn_itm_no       , "");  
	ComSetObjValue(frm.gen_expn_itm_desc     , "");  
	ComSetObjValue(frm.gen_expn_calc_bss_desc, "");  
	ComSetObjValue(frm.rqst_opin_rmk         , "");
	
	sheet2.CellValue2(1 , "jan_amt") =  0;        
	sheet2.CellValue2(1 , "feb_amt") =  0;        
	sheet2.CellValue2(1 , "mar_amt") =  0;        
	sheet2.CellValue2(1 , "apr_amt") =  0;        
	sheet2.CellValue2(1 , "may_amt") =  0;        
	sheet2.CellValue2(1 , "jun_amt") =  0;        
	sheet2.CellValue2(1 , "jul_amt") =  0;        
	sheet2.CellValue2(1 , "aug_amt") =  0;        
	sheet2.CellValue2(1 , "sep_amt") =  0;        
	sheet2.CellValue2(1 , "oct_amt") =  0;        
	sheet2.CellValue2(1 , "nov_amt") =  0;        
	sheet2.CellValue2(1 , "dec_amt") =  0;        
	sheet2.CellValue2(2 , "jan_amt") =  0;        
	sheet2.CellValue2(2 , "feb_amt") =  0;        
	sheet2.CellValue2(2 , "mar_amt") =  0;        
	sheet2.CellValue2(2 , "apr_amt") =  0;        
	sheet2.CellValue2(2 , "may_amt") =  0;        
	sheet2.CellValue2(2 , "jun_amt") =  0;        
	sheet2.CellValue2(2 , "jul_amt") =  0;        
	sheet2.CellValue2(2 , "aug_amt") =  0;        
	sheet2.CellValue2(2 , "sep_amt") =  0;        
	sheet2.CellValue2(2 , "oct_amt") =  0;        
	sheet2.CellValue2(2 , "nov_amt") =  0;        
	sheet2.CellValue2(2 , "dec_amt") =  0;
	
	frm.chk_assigned.checked = false;  
	frm.chk_assigned.disabled = false;	
	if (ComGetObjValue(frm.gen_expn_rqst_tp_cd) == "EI") {
		frm.chk_assigned.disabled = true;		
	}
	
	ComSetObjValue(frm.gen_expn_cd_abbr_name , "") ;
	ComSetObjValue(frm.eng_abbr_nm , "");  
	ComSetObjValue(frm.krn_abbr_nm , "");  
	ComSetObjValue(frm.rqst_locl_amt         , "");  
	ComSetObjValue(frm.rqst_usd_amt, "");  
	//ComSetObjValue(frm.rqst_ut_val , "");
	//ComSetObjValue(frm.usd_locl_xch_rt , "");
	ComSetObjValue(frm.tic_cd , "");       
	
	//Assignment Rule
	ComEnableObject(frm.monthFrom, false);
	frm.monthFrom.options[0].selected = true;
	ComEnableObject(frm.monthTo, false);
	frm.monthTo.options[0].selected = true;
	ComSetObjValue(frm.assign_rule , "M");
	
	
	//환율, 통화 정보 설정			
	//document.getElementById("locl_curr_cd").innerText = "";
	
}       
 
 


 /**     
  * 선택된 행번호       
  */ 
function getRowNum() {	
	/*
	var ofcCd = frm.ofc_cd.value;
	var genExpnCd =  frm.gen_expn_cd.value;
	var itemNo = frm.gen_expn_itm_no.value;
	//alert(ofcCd + "|" +genExpnCd +"|" + itemNo+ "|"  );
	var cnt = sheet1.RowCount;
	var row = 0 ;
	for ( var i = 0; i < cnt ; i++) {
		row = i + 1;
		if (sheet1.RowStatus(row) == "D") {
			continue;
		}
		var ofc_cd = sheet1.CellValue(row , "ofc_cd");
		var gen_expn_cd = sheet1.CellValue(row , "gen_expn_cd");
		var gen_expn_itm_no = sheet1.CellValue(row , "gen_expn_itm_no");
		if (ofc_cd == ofcCd  && gen_expn_cd == genExpnCd && gen_expn_itm_no == itemNo ) {
			return row;
		}
	}
	
	return -1;
	*/
	
	return parseInt(frm.rownum.value, 10);  
	
}
  
  /**     
   * 총 USD금액 구하기       
   */      
function getUsdTotal() {
	
	var cnt = sheet1.RowCount;
	
	var usdTotal = 0.000;	
	
	for(var i = 0 ; i < cnt ; i++ ) {
		var row = i  + 1;
		if (sheet1.RowStatus(row) == "D") {
			continue;
		}
		var rqst_usd_amt = sheet1.CellValue(row,"rqst_usd_amt");
		if (!ComIsNull(rqst_usd_amt)) {		
			usdTotal =  usdTotal +parseFloat(ComTrimAll(rqst_usd_amt, ","));
		}
	}
	return usdTotal;
}
   
   /**     
    * 오피스의 통화정보 취득
    * @param {string} plnYear 계획년도 yyyy
    * @param {string} ofcCd 오피스 코드
    * @return 통화정보
    */    
   function getCurrInfo(plnYear , ofcCd ) {	
   	var param = "f_cmd=" + SEARCH;
   	param    += "&pln_yrmon=" + plnYear + 
   	  "&ofc_cd=" + ofcCd ;
   	
   	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_02GS.do", param);		
   				
   	var list = ComXml2ListMap(sXml);
   	
   	if (list == null || list.length == 0) {
   		return null;
   	}
   	
   	return list[0];
   	
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
	case "t1btn_RowAdd":
		
		if (ComIsNull(frm.ofc_lvl3.value)) {
			// ( Please select {?msg1} ) msg1 =  a office code
			ComShowCodeMessage("GEM01038" , "a office code");
			frm.ofc_lvl3.focus();
			return;
		}
		
		//빤짝이 중지
		stopBlink();
		
		frm.rqst_locl_amt.readOnly = false;
		frm.rqst_opin_rmk.readOnly = false;
		frm.gen_expn_calc_bss_desc.readOnly = false;
		frm.gen_expn_itm_desc.readOnly = false;
		
		//이전데이타 설정
		setFormToSheet1();

		var row = sheet1.DataInsert(-1);		
		frm.rownum.value = row;
		
		//OFFICE 설정
		if ( frm.sls_ofc_div_cd[0].checked ) {
			sheet1.CellValue2(row , "sls_ofc_div_cd") = "N";
		} else if (frm.sls_ofc_div_cd[1].checked) {
			sheet1.CellValue2(row , "sls_ofc_div_cd") = "Y";
		}
		//LV1
		sheet1.CellValue2(row , "ofc_lvl1") = frm.ofc_lvl1.value;
		//LV2
		sheet1.CellValue2(row , "ofc_lvl2") = frm.ofc_lvl2.value;
		//LV3
		sheet1.CellValue2(row , "ofc_cd") = frm.ofc_lvl3.value;			
		
		//신규 구분
		sheet1.CellValue2(row , "add_flg") = "ADD";
		
		//통화정보 변경
		sheet1.CellValue2(row, "locl_curr_cd") = 
			document.getElementById("locl_curr_cd").innerText;
		sheet1.CellValue2(row, "usd_locl_xch_rt") = frm.usd_locl_xch_rt.value;
		sheet1.CellValue2(row, "rqst_ut_val") = frm.rqst_ut_val.value;		
		
		//시퀀스 설정
		sheet1.CellValue2(row,"gen_expn_rqst_seq") = getMaxSeq();
		
		//이전폼 클리어
		resetForm();
		break;
	case "t1btn_Delete":
		var arrRow = selectRowNum(sheet1);		
		if (arrRow != null && arrRow.length > 0 ) {		
			ComRowDelete(sheet1, "delChk");			
			//이전폼 클리어
			resetForm();			
			if (SheetRowCount(sheet1) > 0) {
				sheet1.SelectRow = 1;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				frm.rownum.value = "1";
				setSheet1ToForm(1);
			} else {				
				frm.rownum.value = "-1";				
			}
			
		}
		break;
	case "t1btn_Authorized":
		
		if (ComIsNull(frm.ofc_lvl3.value)) {
			// ( Please select {?msg1} ) msg1 =  a office code
			ComShowCodeMessage("GEM01038" , "a office code");
			frm.ofc_lvl3.focus();
			return;
		}
		
		//빤짝이 중지
		stopBlink();
		
		frm.rqst_locl_amt.readOnly = false;
		frm.rqst_opin_rmk.readOnly = false;
		frm.gen_expn_calc_bss_desc.readOnly = false;
		frm.gen_expn_itm_desc.readOnly = false;

		//이전데이타 설정
		setFormToSheet1();
		
		var param = "lang_div=" + ComGetObjValue(frm.lang_div);
		param += "&ofc_cd=" + frm.ofc_lvl3.value;
		if (frm.ofc_lvl3.value != frm.usr_tic_cd.value &&
				frm.ofc_lvl2.value != frm.usr_tic_cd.value) {
			param += "&usr_tic_cd=" + frm.usr_tic_cd.value;
		}
		
		var url = "CPS_GEM_0101.do?"+param;
		var winName = "CPS_GEM_0101";		
		var win = ComOpenWindowCenter(url,winName,700,460, false);
		break;
	case "chk_assigned":
		
		if (frm.chk_assigned.checked) {
			if (ComIsNull(frm.gen_expn_cd.value)) {
				frm.chk_assigned.checked = false;
				return;
			}
			var gen_expn_cd = frm.gen_expn_cd.value;	
			var ofc_cd = frm.ofc_cd.value;
			var pln_yrmon= frm.pln_yrmon.value;
			var param = "gen_expn_cd=" + gen_expn_cd;
			param += "&ofc_cd=" + ofc_cd;
			param += "&pln_yrmon=" + pln_yrmon ;
			var url = "CPS_GEM_0104.do?"+param;
			var winName = "CPS_GEM_0104";		
			
			if (assWin != null) {
				assWin.close();
			}
			assWin = ComOpenWindowCenter(url,winName,800,350, false);		
			frm.chk_assigned.checked = false;
			frm.pre_gen_expn_itm_no.value = frm.gen_expn_itm_no.value;
			frm.pre_gen_expn_itm_desc.value = frm.gen_expn_itm_desc.value;

		} else {			
			var row = getRowNum();
			if (row > 0 ) {
				sheet1.CellValue2(row , "gen_expn_itm_no") = frm.pre_gen_expn_itm_no.value ;				
			}
			
			frm.chk_assigned.disabled = false;
			frm.gen_expn_itm_desc.readOnly = false;
			frm.gen_expn_itm_desc.className = "input1";
			frm.gen_expn_itm_no.value = frm.pre_gen_expn_itm_no.value;
			frm.gen_expn_itm_desc.value = frm.pre_gen_expn_itm_desc.value;
			
			//시트 assigned 지우기
			var janCol = sheet2.SaveNameCol("jan_amt")
			var decCol = sheet2.SaveNameCol("dec_amt")
			
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet2.CellValue2(1,i) = 0;
			}
		}		
		
		
		
		
		break;		
	case "t1btn_Request":
		var contents = "";
		contents += "TO : PLP / Eun-young Lee <br>";
		contents += "RE : Request for Expense code matrix<br>";
		contents += "----------------------------------------------------------------<br>";
		contents += "Office:<br>";
		contents += "Code:<br>";
		contents += "Reason:<br>";
		contents += "Due Date:<br>";
		frm.gw_contents.value = contents;
		frm.gw_subject.value = "Request of Expense Code matrix";
		ComOpenGroupwareMail(sheet2,frm);
		break;	
	case "btn_Retrieve":
		doActionIBSheet(SEARCHLIST);
		break;	
	case "btn_New":
		//Do you want to initialize?
		if (ComShowCodeConfirm("GEM00011")) {		
			/*
			resetForm();
			sheet1.RemoveAll();
			frm.gen_expn_rqst_no.value = "";
			*/
			/*
			resetForm();
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			frm.gen_expn_rqst_no.value = "";
			frm.usd_ttl.value = "";			
			doActionIBSheet(INIT);
			*/
			//location.reload();
			location.href = document.location;
			top.document.body.scrollTop = 0;
		}
		
		break;
	case "btn_Delete":
		if (ComShowCodeConfirm("GEM01058")) {
			doActionIBSheet(REMOVE);
		}
		break;
	case "btn_Save":
		
		//GEM00012(Do you want to save changes?)
		if (ComShowCodeConfirm("GEM00012")) {

			var cnt = SheetRowCount(sheet1);
			
			if (cnt == 0) {
				//msgs["GEM01056"] = "There is no contents to save.";
				ComShowCodeMessage("GEM01056");
				return;
			}
			
			//이전데이타 설정
			setFormToSheet1();
			// <2009-10-12>
			// 다른사용자 변경여부 체크 및 request no 존재여부 체크
			var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
			
			if (!ComIsNull(gen_expn_rqst_no) && 
					!ComIsNull(frm.req_upd_dt.value) ) {
				
				var checkData = checkChangedData();
				//msgs["GEM01088"] = "The request no doesn't exist.";
				//msgs["GEM01089"] = "Data is changed by other's user";
				if (checkData == "1") {
					ComShowCodeMessage("GEM01089");
					doActionIBSheet(SEARCHLIST);
					return;		
				} else if (checkData == "3") {
					ComShowCodeMessage("GEM01088");
					frm.gen_expn_rqst_no.focus();
					return;
				}
				
			}			
			// </2009-10-12> 
			
			if ( !validateSheet() ) {
				setSheet1ToForm(sheet1.SelectRow);
				return;
			}

			
			doActionIBSheet(MULTI);
		}	
		
		break;
	case "btn_Print":
		if (!ComIsNull(frm.gen_expn_rqst_no.value)) {
			var url = "CPS_GEM_0103.do";		
			var winName = "CPS_GEM_0103";
			repWin = openWinCenter("about:blank",winName,700,410);
		    var frm3 = document.form3;
		    var langDiv = ComGetObjValue(frm.lang_div);
		    
		    frm3.rfn.value = "/CPS_GEM_0023.do?lang_div="+langDiv+"&gen_expn_rqst_no="+frm.gen_expn_rqst_no.value+"&pln_yrmon="+frm.pln_yrmon.value+"&f_cmd="+SEARCHLIST01;	    
		    frm3.mrd.value = "apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/report/CPS_GEM_0023.mrd";
		    
		    var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);
		    if (gen_expn_rqst_tp_cd == "EI") {
			    frm3.rv.value = "title[Expense Report - Initial]";		    
			    frm3.title.value = "Expense Report - Initial";
		    } else {
			    frm3.rv.value = "title[Expense Report - Additional]";		    
			    frm3.title.value = "Expense Report - Additional";
		    }
		    
		    frm3.action = url;
		    frm3.target = winName;
		    frm3.submit();
		    frm3.target = "";
		    repWin.focus();
		} else {
			//GEM01086 There is no data to print.
			ComShowCodeMessage("GEM01086");
		}
		break;
	//Request popup
	case "btns_popup":
		var url = "CPS_GEM_0105.do";
		var winName = "CPS_GEM_0105";
		if (reqWin != null) {
			reqWin.close();
		}
		reqWin = ComOpenWindowCenter("about:blank",winName,700,430, false);
	    var frm1 = document.form1;
	    frm1.pln_yrmon.value = frm.pln_yr.value;	    
	    frm1.rqst_ofc_cd.value = frm.ofc_lvl3.value;
	    frm1.auth_flg.value = frm.auth_flg.value;
	    frm1.gen_expn_rqst_tp_cd.value = ComGetObjValue(frm.gen_expn_rqst_tp_cd);
	    frm1.action = url;        
	    frm1.target = winName;
	    frm1.submit();
	    frm1.target = "";	    
	    break;			
	// 수동, 자동 배정
	case "assign_rule":
		var assign_rule = ComGetObjValue(frm.assign_rule);		
		if (assign_rule == "A") {
			ComEnableObject(frm.monthFrom, true);
			ComEnableObject(frm.monthTo, true);
		} else {
			ComEnableObject(frm.monthFrom, false);
			ComEnableObject(frm.monthTo, false);
		}
			
		break;		
				
		
	} 
	
}


/**     
* EI, EA onchange시  
*/
function onChagneRqstTpCd() {
	
	var add_color = document.getElementById("add_color");
	var init_color = document.getElementById("init_color");
	
	if (sheet1.RowCount > 0) {		
		//msgs["GEM00015"] = "Do you want to initialize?";
		if (!ComShowCodeConfirm("GEM00015")) {
			if (frm.gen_expn_rqst_tp_cd[0].checked) {
				frm.gen_expn_rqst_tp_cd[0].checked = false;
				frm.gen_expn_rqst_tp_cd[1].checked = true;
			} else {
				frm.gen_expn_rqst_tp_cd[0].checked = true;
				frm.gen_expn_rqst_tp_cd[1].checked = false;
			}
			return;
		}
	}
	
	// 예산계획 차년도 설정
	if (frm.gen_expn_rqst_tp_cd[0].checked) {
		
		sheet1.RemoveAll();
		resetForm();
		
		//Request No
		ComSetObjValue(frm.gen_expn_rqst_no , "");			
		// assigned
		frm.chk_assigned.disabled = true;
		printClosingDate(initDateVO);			
		var clzYrmon = 	initDateVO["clz_yrmon"];			
		var clzYr = clzYrmon.substring(0,4);
		frm.pln_yr.value = clzYr;
		frm.pln_mon.value = "";
			
		
		frm.monthFrom.length = 0;					
		for ( var i = 1; i <= 12; i++) {
			ComAddComboItem(frm.monthFrom,  getEngMonthName(i) , i);
		}
		
		frm.monthTo.length = 0;
		ComAddComboItem(frm.monthTo,  "" , "");
		comboCopy(frm.monthFrom, frm.monthTo, false);
		frm.monthTo.value = "";
		
		init_color.className = "span_title1";
		add_color.className = "span_title2";
		
	}
	
	if (frm.gen_expn_rqst_tp_cd[1].checked) {		
		
		sheet1.RemoveAll();
		resetForm();
		
		//Request No
		ComSetObjValue(frm.gen_expn_rqst_no , "");		
		
		// assigned
		frm.chk_assigned.disabled = false;
		
		printClosingDate(closingDateVO);
		frm.pln_yr.value = curYear;
		frm.pln_mon.value = curMon;		
		
		//예산년월
		var clzYrmon = 	closingDateVO["clz_yrmon"];
		
		var clzMon = clzYrmon.substring(4,6);
		
		if ("00" != clzMon) {
			var mon = parseInt(clzMon , 10);
			
			if (mon == 0) {
				mon = 1;
			}
			
			frm.monthFrom.length = 0;					
			for ( var i = mon; i <= 12; i++) {
				ComAddComboItem(frm.monthFrom,  getEngMonthName(i) , i);
			}
			
			frm.monthTo.length = 0;
			ComAddComboItem(frm.monthTo,  "" , "");
			comboCopy(frm.monthFrom, frm.monthTo, false);
			frm.monthTo.value = "";
			
		}					
		
		init_color.className = "span_title2";
		add_color.className = "span_title1";
		
	}	
	
	
	
	
}

/**     
* 총금액 자동 배정       
*/         
function onChangeMonthTo() {
	
	if (ComIsNull(frm.rqst_locl_amt.value) || frm.rqst_locl_amt.value == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm.monthTo.value = "";
		frm.rqst_locl_amt.focus();
		return;
	}
	
	//Assignment Rule
	if (frm.assign_rule[1].checked) {
		var monthFrom = frm.monthFrom.value;
		var monthTo = frm.monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , " MONTH TO");
			frm.monthFrom.focus();
			return;		
		}
		
		monthFrom = parseInt(frm.monthFrom.value , 10);
		monthTo = parseInt(frm.monthTo.value , 10);
				
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(frm.rqst_locl_amt.value, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		//초기화
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet2.CellValue2(2,i) = 0;
		}
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet2.CellValue2(2,i) = avg;
			total += avg;
		}
		
		//나머지 금액은 첫번째 컬럼에 입력
		if (total <= locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet2.CellValue2(2, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet2.CellValue2(2, start) = (avg - diffAmt);
		}	
	}
	
}


/**
* 오피스 변경시 code 체크 
*/
function onChangeOfcLvl3() {
	
	var cnt = SheetRowCount(sheet1);
	/*
	//최초 입력 이외의 경우  
	if (cnt > 0 ) {		
		for ( var i = 0; i < sheet1.RowCount  ;i++) {
			var row = i + 1;
			if (sheet1.RowStatus(row) == "D")  {
				continue;
			}
			
			var gen_expn_cd = sheet1.CellValue(row,"gen_expn_cd");
			
			if (ComIsNull(gen_expn_cd )) {
				//msgs["GEM01042"] = "If you want to change request office, you should delete blank rows of request expense code";
				ComShowCodeMessage("GEM01042" , "Code");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(row,"gen_expn_cd",true);
				frm.ofc_lvl3.value = frm.ofc_cd.value;
				return ;
			}
		}
	}	
	*/
	
	var plnYear = frm.pln_yr.value;
	
	frm.ofc_cd.value = frm.ofc_lvl3.value;
	
	var ofcCd = frm.ofc_lvl3.value;	
	
	if ( ComIsNull(ofcCd) ) {
		return;
	}
	
	var officeLevelVo = getCurrInfo(plnYear, ofcCd);
	
	var loclCurrCd  = officeLevelVo["locl_curr_cd"];
	var usdLoclXchRt   = officeLevelVo["usd_locl_xch_rt"];
	var rqstUtVal   = officeLevelVo["rqst_ut_val"];
	
	//환율, 통화 정보 설정			
	document.getElementById("locl_curr_cd").innerText = loclCurrCd;
	//USD
	frm.usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
	//단위
	frm.rqst_ut_val.value = ComAddComma(rqstUtVal);
	
	//환율 계산
	if (!ComIsNull(frm.rqst_locl_amt.value)) {
		setUsdAmt();
	}
	
	startBlink(); 
		
}

/**                                                                                                                                                                                                                                                                                                  
* 오피스의 통화정보 취득
* @param {string} plnYear 계획년도 yyyy
* @param {string} ofcCd 오피스 코드
* @return 통화정보
*/    
function getCurrInfo(plnYear , ofcCd ) {	
	var param = "f_cmd=" + SEARCH;
	param    += "&pln_yrmon=" + plnYear + 
	            "&ofc_cd=" + ofcCd ;
	
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_02GS.do", param);		
				
	var list = ComXml2ListMap(sXml);
	
	if (list == null || list.length == 0) {
		return null;
	}
	
	return list[0];
	
} 

/**
* 계산식,  요청의견 노트 표시
*/
function showNote(obj , type) {
    
	var param = "type=" + type;	
	var width = 600;
	var height = 370;
    var pos = getPos(obj);	
	var top = pos.y + 180;
	var left =  pos.x - 600 ;
	var url = "CPS_GEM_0102.do?"+param;
	var winName = "CPS_GEM_0102";
	if (noteWin != null) {
		noteWin.close();
	}
	
	noteWin =  ComOpenWindow("about:blank", winName, "status=no, resizable=no, scrollbars=no, width="+width+", height="+height+", left="+left+", top="+top);

	var frm2 = document.form2;
	frm2.saveYn.value = "Y";
	var text = "";
	if (type == "A") {		
		text = frm.gen_expn_itm_desc.value;
		//조회데이타이면 assigned disable
		var row = frm.rownum.value;
		if (ComIsNull(sheet1.CellValue(row , "add_flg"))) {					
			if (frm.chk_assigned.checked) {
				frm2.saveYn.value = "N";
			}
		}
	} else if (type == "B") {
		text = frm.gen_expn_calc_bss_desc.value;
	} else if (type == "C") {
		text = frm.rqst_opin_rmk.value;
	}
	
    frm2.text.value = text;
    frm2.type.value = type;
    frm2.action = url;        
    frm2.target = winName;
    frm2.submit();
    frm2.target = "";	   	
    
}

/**
 * Form 이벤트 등록
 */
function initControl() {
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
    case "rqst_locl_amt":
		ComKeyOnlyNumber(event.srcElement,"-");		
		if (frm.rqst_locl_amt.value.length > 0 && event.keyCode == 13) {
			setUsdAmt();
			setFormToSheet1();
		}
		break;
    case "gen_expn_rqst_no":
		if (frm.gen_expn_rqst_no.value.length > 0 && event.keyCode == 13) {
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
	case "rqst_locl_amt":
		if ( !ComChkObjValid(frm.rqst_locl_amt) ) {			
			return;
		}
		
		//마이너스 금액이 입력된경우 총 Assigned 금액 보다  큰경우 에러
		var rqst_locl_amt = frm.rqst_locl_amt.value;
		if (!ComIsNull(rqst_locl_amt)) {
			rqst_locl_amt = parseInt(rqst_locl_amt, 10);
			if (rqst_locl_amt < 0 ) {
				var ttl = sheet2.CellValue(1,  "ttl");
				if ( Math.abs(rqst_locl_amt) > ttl) {
					//msgs["GEM01080"] = "The requested amount cann't be exceeded the assigned amountThe requested amount cann't be exceeded the assigned amount.";
					ComShowCodeMessage("GEM01080");
					 frm.rqst_locl_amt.value = "";
					 frm.rqst_locl_amt.focus();
					return;
				}
			}
			
		}
		
		
		setUsdAmt();
		break;
	case "gen_expn_itm_desc":
		if ( !ComChkObjValid(frm.gen_expn_itm_desc) ) {			
			return;
		}		
		
		break;
	case "gen_expn_calc_bss_desc":
		if ( !ComChkObjValid(frm.gen_expn_calc_bss_desc) ) {			
			return;
		}		
		
		break;
	case "rqst_opin_rmk":
		if ( !ComChkObjValid(frm.rqst_opin_rmk) ) {			
			return;
		}		
		
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}
 
/**
 * LOC금액을  USD 금액으로 환산  계산
 **/
function setUsdAmt() {
	 
	//로컬금액
	var rqst_locl_amt = frm.rqst_locl_amt.value;	
	//USD
	var usd_locl_xch_rt = frm.usd_locl_xch_rt.value;	
	//단위
	var rqst_ut_val = frm.rqst_ut_val.value;	
	
	frm.rqst_usd_amt.value = 
		ComAddComma(getUsdAmt(rqst_locl_amt , rqst_ut_val ,usd_locl_xch_rt ));		
	
}

 

/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);    
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
	
	// 비용코드을 입력 할경우
	if (col == sheet1.SaveNameCol("gen_expn_cd") ) {
		
		if (ComIsNull(value)) {
			//입력한 셀로 이동
			sheet1.SelectCell(row, "gen_expn_cd", true);
			setSheet1ToForm(row);
			return;
		}
		
		// 해당 오피스 비용코드 유무 체크
		var plnYrmon =  frm.pln_yr.value;
		var ofcCd  = sheet1.CellValue(row, "ofc_cd");
		var genExpnCd = value;
		
		var param = "f_cmd=" + SEARCHLIST02;
		param    += "&pln_yrmon=" + plnYrmon + 
		  "&ofc_cd=" + ofcCd + 
		  "&gen_expn_cd=" + genExpnCd;
		
		if (frm.ofc_lvl3.value != frm.usr_tic_cd.value &&
				frm.ofc_lvl2.value != frm.usr_tic_cd.value) {
			param += "&tic_cd=" + frm.usr_tic_cd.value;
		}
		
		var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);		
		var genExpnInfoList = ComXml2ListMap(sXml);
		
		if (genExpnInfoList.length == 0) {
		    //msgs["GEM01039"] = "오피스코드에 대한 비용코드가 존재하지 않습니다.";
			ComShowCodeMessage("GEM01039");
			sheet1.CellValue2(row, "gen_expn_cd") = "";
			sheet1.CellValue2(row, "gen_expn_itm_no") = "";
			sheet1.SelectCell(row, "gen_expn_cd", true);
			return ;
		}
		
		//OFFICE 설정
		if ( frm.sls_ofc_div_cd[0].checked ) {
			sheet1.CellValue2(row , "sls_ofc_div_cd") = "N";
		} else if (frm.sls_ofc_div_cd[1].checked) {
			sheet1.CellValue2(row , "sls_ofc_div_cd") = "Y";
		}
		
		//LV1
		sheet1.CellValue2(row , "ofc_lvl1") = frm.ofc_lvl1.value;
		//LV2
		sheet1.CellValue2(row , "ofc_lvl2") = frm.ofc_lvl2.value;
		//LV3
		sheet1.CellValue2(row , "ofc_cd") = frm.ofc_lvl3.value;
		
		var genExpnInfo = genExpnInfoList[0];
		
		var itemNo =  ComGetEtcData(sXml ,"itemNo");
		
		//시트에서 max값 취득
		itemNo = getGenExpnItmNo(ofcCd , value , itemNo);
		sheet1.CellValue2(row , "gen_expn_itm_no") = itemNo;		
		//expens Code 정보 설정 
		ComSetObjValue(frm.tic_cd , genExpnInfo["tic_cd"]);
		sheet1.CellValue2(row , "tic_cd") =  genExpnInfo["tic_cd"];
		
		
		ComSetObjValue(frm.ofc_cd , ofcCd);
		ComSetObjValue(frm.gen_expn_cd , genExpnCd);		
		ComSetObjValue(frm.gen_expn_itm_no , itemNo);
		
		if (ComGetObjValue(frm.lang_div) == "KOR") {
			ComSetObjValue(frm.gen_expn_cd_abbr_name , genExpnInfo["krn_abbr_nm"]);			
		} else {
			ComSetObjValue(frm.gen_expn_cd_abbr_name , genExpnInfo["eng_abbr_nm"]);			
		}	
		
		sheet1.CellValue2(row , "krn_abbr_nm") =  genExpnInfo["krn_abbr_nm"];
		sheet1.CellValue2(row , "eng_abbr_nm") =  genExpnInfo["eng_abbr_nm"];
		
		//입력한 셀로 이동
		sheet1.SelectCell(row, "gen_expn_itm_no", true);

		
	} else if (col == sheet1.SaveNameCol("gen_expn_itm_no") ||
			col == sheet1.SaveNameCol("ofc_cd")) {
		
	}
}



/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	
	
	
	//이전행에 폼의  내용을 시트로 복사	
	setFormToSheet1();
	
	resetForm();
	
	//현재행의 내용을 폼으로 복사 
	setSheet1ToForm(row);
		
}

/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnSelectCell(sheet , oldRow, oldCol, newRow, newCol) {	
	/*
	if (!validateForm()) {
		return;
	}
	
	if (ComIsNull(frm.ofc_lvl3.value)) {
		return;
	}
	
	if (oldRow != newRow) {
	//이전행에 폼의  내용을 시트로 복사	
	setFormToSheet1();
	
	//현재행의 내용을 폼으로 복사 
	setSheet1ToForm(newRow);
	
	}
	*/
	
	
	
}



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
	   if ("gen_expn_itm_no" == sName || "ofc_cd" == sName) {
		   sheet1.MousePointer = "Hand";
	   } else {
		   sheet1.MousePointer = "Default";
	   }      
}



/**
* sheet2 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value  
* 
*/
function sheet2_OnChange(sheet , row , col , value) {
	
	if (row == 2) {
		
		//비었으면 0으로 설정
		if (value == "") {
			sheet.CellValue(row,col) = 0;
			return;
		}
		
		var assignAmt = sheet.CellValue(row-1,col);
		
		if (ComIsNull(assignAmt)) {
			assignAmt = 0;
		}
		
		if (parseInt(assignAmt) + parseInt(value) < 0 ) {
			//msgs["GEM01080"] = "The requested amount cann't be exceeded the assigned amountThe requested amount cann't be exceeded the assigned amount.";
			ComShowCodeMessage("GEM01080");
			sheet.CellValue(row,col) = 0;			
		}
		
		frm.rqst_locl_amt.value = sheet.CellText(row,"ttl");
		
		setUsdAmt();
	}
	
}

 

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {

	//Retrive
	if (sAction == SEARCHLIST) {
		
		var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
		
		if (ComIsNull(gen_expn_rqst_no)) {
			// GEM01038 ( Please select {?msg1} ) msg1 =  a office code
			ComShowCodeMessage("GEM01038" , "a request NO. first");
			frm.gen_expn_rqst_no.focus();
			return;
		}

		
		//폼클리어 
		resetForm();
		
		frm.rqst_locl_amt.readOnly = false;
		frm.rqst_opin_rmk.readOnly = false;
		frm.gen_expn_calc_bss_desc.readOnly = false;
		frm.gen_expn_itm_desc.readOnly = false;
		
		sheet1.RemoveAll();
		
		
		frm.f_cmd.value = SEARCHLIST;
		

		var param = "f_cmd=" + SEARCHLIST;
		param += "&gen_expn_rqst_no=" + gen_expn_rqst_no;
		param += "&pln_yrmon=" + frm.pln_yr.value;
		
		var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);
		var arrXml = sXml.split("|$$|");
		
		if (arrXml.length > 0) {
			var list = ComXml2ListMap(arrXml[0]);
			if (list.length == 0) {
				//msgs["GEM00013"] = "There is no related data!";
				ComShowCodeMessage("GEM00013");
				return;
			}
			
			var gemRequestVO  = list[0];
			
			var gen_expn_rqst_tp_cd = gemRequestVO["gen_expn_rqst_tp_cd"] ;
			var plnYrmon =  gemRequestVO["pln_yrmon"] ;			
			frm.pln_yr.value  = plnYrmon.substring(0,4);
			
			if (gen_expn_rqst_tp_cd == "EA") {
				frm.pln_mon.value	= plnYrmon.substring(4,6);
				frm.gen_expn_rqst_tp_cd[1].checked = true;
			} else {
				frm.gen_expn_rqst_tp_cd[0].checked = true;
			}
			
			
		}
		
		//sheet1  설정
		if (arrXml.length > 1) {
			sheet1.LoadSaveXml(arrXml[1]);
			
			var rowCnt = sheet1.RowCount;
			
			//밑줄 표시
			for ( var i = 0; i < rowCnt; i++) {
				var row = i + 1;
				sheet1.RowFontColor(row) = sheet1.WebColor("#0000FF");
				sheet1.CellFont ("FontUnderline", row, "ofc_cd", row, "gen_expn_cd") = true;				
			}			
			
			if (rowCnt > 0 ) {
				var fNum = FirstRowNum(sheet1);
				
				setSheet1ToForm(fNum);
				sheet1.SelectRow = fNum;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				
				// [patch] 2009-11-03 cyo 배타체크 추가	
				frm.req_upd_dt.value = sheet1.CellValue(fNum, "req_upd_dt");
				frm.itm_upd_dt.value = sheet1.CellValue(fNum, "itm_upd_dt");
				
				var usdTotal = getUsdTotal();
				frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,3));
				
			}
			
			
			
		}
		
		
	//[open]	 	
	} else if (sAction == INIT) {		
		frm.f_cmd.value = INIT;		
		var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");
		var authFlg  = "";

		
		// 로그인 오피스 정보 
		if (arrXml.length > 0) {
			//사용자 오피스 설정
			frm.usr_ofc_cd.value = ComGetEtcData(arrXml[0], "usr_ofc_cd");
						
			var list = ComXml2ListMap(arrXml[0]);
			var officeLevelVo  = list[0];
			
			var loclCurrCd  = officeLevelVo["locl_curr_cd"];
			var usdLoclXchRt   = officeLevelVo["usd_locl_xch_rt"];
			var rqstUtVal   = officeLevelVo["rqst_ut_val"];
			authFlg  = officeLevelVo["auth_flg"];
			
			//환율, 통화 정보 설정			
			document.getElementById("locl_curr_cd").innerText = loclCurrCd;
			//USD
			frm.usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
			//단위
			frm.rqst_ut_val.value = ComAddComma(rqstUtVal);
			
		}
		
		// 로그인 사용자 오피스 정보
		if (arrXml.length > 1) {
			var list = ComXml2ListMap(arrXml[1]);
			if (list.length > 0) {
				var officeHierarchyVO  = list[0];
				var level1   = officeHierarchyVO["level1"];
				var level2   = officeHierarchyVO["level2"];
				var level3   = officeHierarchyVO["level3"];
				var level4   = officeHierarchyVO["level4"];
				var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
				
				
				if ("N" == rgnOfcFlg) {
					frm.sls_ofc_div_cd[0].checked = true;
					frm.sls_ofc_div_cd[1].checked = false;
				} else {
					frm.sls_ofc_div_cd[0].checked = false;
					frm.sls_ofc_div_cd[1].checked = true;					
				}
				
				ComSetObjValue(frm.ofc_lvl1,level2);
				
				//LV2
				selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');			
				ComSetObjValue(frm.ofc_lvl2,level3);
				
				//LV3
				selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');			
				ComSetObjValue(frm.ofc_lvl3,level4);
			}
			
			/*	
			1.[성공] 조회된 정보와 조직의 권한에 따른 Request Office Setup
			  1.1.[집행단위:YNNN] 
			    1.1.1.[BU항목] 비활성화
			    1.1.2.[HO항목] 비활성화
			    1.1.3.[HQ항목] 비활성화
			    1.1.4.[BU조직항목] 비활성화
			    1.1.5.[Major조직L항목] 비활성화
			    1.1.6.[Minor조직항목] 비활성화
			  1.2.[지역그룹:YYNN]
			    1.2.1.[BU항목] 비활성화
			    1.2.2.[HO항목] 비활성화
			    1.2.3.[HQ항목] 비활성화
			    1.2.4.[BU조직항목] 비활성화
			    1.2.5.[Major조직항목] 비활성화
			    1.2.6.[Minor조직항목] 활성화
			  1.3.[BU CTRL:YYYN]
			    1.3.1.[BU항목] 비활성화
			    1.3.2.[HO항목] 활성화
			    1.3.3.[HQ항목] 활성화
			    1.3.4.[BU조직항목] 활성화
			    1.3.5.[Major조직항목] 활성화
			    1.3.6.[Minor조직항목] 활성화
			  1.4.[비용주관팀:YNYN][사무국:YNYY]
			    1.4.1.[BU항목] 비활성화
			    1.4.2.[HO항목] 활성화
			    1.4.3.[HQ항목] 활성화
			    1.4.4.[BU조직항목] 활성화
			    1.4.5.[Major조직항목] 활성화
			    1.4.6.[Minor조직항목] 활성화
			*/
			

			
			//집행단위
			if ( authFlg == "YNNN" ) {
				ComEnableObject(frm.ofc_lvl1, false);
				ComEnableObject(frm.ofc_lvl2, false);
				ComEnableObject(frm.ofc_lvl3, false);		
				frm.sls_ofc_div_cd[0].disabled=true;
				frm.sls_ofc_div_cd[1].disabled=true;
								
		    //지역그룹				
			} else if ( authFlg == "YYNN" ) {
				ComEnableObject(frm.ofc_lvl1, false);
				ComEnableObject(frm.ofc_lvl2, false);
				ComEnableObject(frm.ofc_lvl3, true);				
				frm.sls_ofc_div_cd[0].disabled=true;
				frm.sls_ofc_div_cd[1].disabled=true;
				
			//BU	
			} else if ( authFlg == "YYYN" ) {
				ComEnableObject(frm.ofc_lvl1, true);
				ComEnableObject(frm.ofc_lvl2, true);
				ComEnableObject(frm.ofc_lvl3, true);
				//비용주관팀  TIC 설정 Authorized Expense Code
				frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
				
			//사무국
			} else if ( authFlg == "YNYN" || authFlg == "YNYY") {
				
				//사무국인경우 수퍼유저가 아니경우 비용팀으로 권한 설정
				if (authFlg == "YNYY") {
					if ( frm.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
						authFlg = "YNYN";
					}
				}
				
				//비용주관팀  TIC 설정 Authorized Expense Code 
				if (authFlg == "YNYN") {
					frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
				}
				
				ComEnableObject(frm.ofc_lvl1, true);
				ComEnableObject(frm.ofc_lvl2, true);
				ComEnableObject(frm.ofc_lvl3, true);				
				
			} else {
				ComEnableObject(frm.ofc_lvl1, false);
				ComEnableObject(frm.ofc_lvl2, false);
				ComEnableObject(frm.ofc_lvl3, false);		
				frm.sls_ofc_div_cd[0].disabled=true;
				frm.sls_ofc_div_cd[1].disabled=true;
				
			}			
			
			//권한 설정
			frm.auth_flg.value = authFlg;
			
		}		

		
		var row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "Assigned";
		
		row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "Request";
		
		sheet2.ColBackColor("title") = sheet2.WebColor("#EBF6F9");
		sheet2.CellImage(row,"title") = 0;
		
		
		// additional 마감 정보
		if (arrXml.length > 2) {
			var list = ComXml2ListMap(arrXml[2]);
			if (list.length > 0) {
				closingDateVO  = list[0];
				var clzYrmon = 	closingDateVO["clz_yrmon"];				
				var clzMon = parseInt(clzYrmon.substring(4,6),10)+"";
				frm.pln_yrmon.value = clzYrmon;
				
				frm.monthFrom.value = clzMon;				
				printClosingDate(closingDateVO);
				
				//예산년월
				var clzYrmon = 	closingDateVO["clz_yrmon"];
				
				var clzMon = clzYrmon.substring(4,6);
				
				if ("00" != clzMon) {
					var mon = parseInt(clzMon, 10);
					
					if (mon == 0) {
						mon = 1;
					}

					frm.monthFrom.length = 0;					
					for ( var i = mon; i <= 12; i++) {
						ComAddComboItem(frm.monthFrom,  getEngMonthName(i) , i);
					}
					
					frm.monthTo.length = 0;
					ComAddComboItem(frm.monthTo,  "" , "");
					comboCopy(frm.monthFrom, frm.monthTo, false);
					frm.monthTo.value = "";
					
				}				
				
			}
		}
		
		// initial 마감 정보
		if (arrXml.length > 2) {
			
			frm.gen_expn_rqst_tp_cd[0].disabled=false;
			frm.gen_expn_rqst_tp_cd[1].disabled=false;
			
			var list = ComXml2ListMap(arrXml[3]);
						
			if (list.length > 0) {
				initDateVO  = list[0];					
				var clzYrmon = 	initDateVO["clz_yrmon"];			
				var curr_dt = frm.curr_dt.value;	
				var clz_dt = initDateVO["clz_dt"];
				//예산 수립일이 없거나 ,  현재일이 예산수립일보다 큰경우
				if (curr_dt > clz_dt || clz_dt.substring(4,8) == "0000") {
					frm.gen_expn_rqst_tp_cd[0].disabled=true;
					frm.gen_expn_rqst_tp_cd[1].disabled=false;	
				}				
			} else {
				frm.gen_expn_rqst_tp_cd[0].disabled=true;
				frm.gen_expn_rqst_tp_cd[1].disabled=false;
			}
					
		}			
		
		//Assignment Rule
		ComEnableObject(frm.monthFrom, false);
		ComEnableObject(frm.monthTo, false);
		
		//깜빡깜빡
		startBlink();
	//[Save]	
	} else if (sAction == MULTI) {		
		frm.f_cmd.value = MULTI;
		//현재 년도 , 현재월을 사용
		var plnYrmon =  frm.pln_yr.value + frm.pln_mon.value;
		var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);	
		var auth_flg = frm.auth_flg.value;
		var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;

		var param = "f_cmd=" + MULTI;
		param    += "&pln_yrmon=" + plnYrmon + 
					"&auth_flg=" + auth_flg +
					"&gen_expn_rqst_no=" + gen_expn_rqst_no +
					"&gen_expn_rqst_tp_cd=" + gen_expn_rqst_tp_cd ;
		
		var sParam = sheet1.GetSaveString();
		
		if (sParam == "") {				
			 //msgs["GEM01056"] = "There is no contents to save.";
			ComShowCodeMessage("GEM01056");
			return; 
		}
		
		var sXml = sheet1.GetSaveXml("CPS_GEM_0001_01GS.do?"+param, sParam );	
		
		sheet1.LoadSaveXml(sXml);		

		//Request No 설정
		var gen_expn_rqst_no = ComGetEtcData(sXml, "gen_expn_rqst_no");
		if (!ComIsNull(gen_expn_rqst_no)) {
			frm.gen_expn_rqst_no.value = gen_expn_rqst_no;
			doActionIBSheet(SEARCHLIST);
		}
		
    // DELETE 
	}  else if (sAction == REMOVE ) {
		
		var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
		
		if (ComIsNull(gen_expn_rqst_no)) {
			//{?msg1} 필수항목을 입력하여 주시기 바랍니다
			ComShowCodeMessage("GEM00003" , "Request No.");
			frm.gen_expn_rqst_no.focus();
			return;
		}
		
		//msgs["GEM00016"] = "Do you want to delete it";
		if (!ComShowCodeConfirm("GEM00016")) {			
			return;
		}
		
		var param = "f_cmd=" + REMOVE;
		param    += "&gen_expn_rqst_no=" + gen_expn_rqst_no;
		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0001_01GS.do", param);
		
		sheet1.LoadSaveXml(sXml);
		
		//폼클리어 
		resetForm();
		sheet1.RemoveAll();
		frm.gen_expn_rqst_no.value = "";
		
	// Page Onload 시 Lvl 1 콤보 취득  
	}  else if (sAction == SEARCHLIST20) {		
		
		frm.f_cmd.value = SEARCH;
		
		var sXml = sheet3.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
		
		// LEVEL2 조회
		var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
		
		if (typeof comboListData != "undefined" && comboListData != "") {
			
			var ofcLvl = frm.ofc_lvl1;
			ofcLvl.length = 0;
			ComAddComboItem(ofcLvl, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
			}
		}

	} 		
 
}
