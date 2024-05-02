/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0003.js
 *@FileTitle : [CPS_GEM_0003] Approval of Requested expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * ---------------------------------------------------------------------------
 * History
 * 2010.09.17 이준범 [CHM-201006046-01] toLclAmt , toUsdAmt 는 모두  fmLclAmt(fmUsdAmt) 기준으로 생성한다.
 * 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
 * 1) open000103()
 *   - searchInitialDate() ofcCd 파라미터 추가
 *   - 화면에서 Closing DT 의 유효성을 식별할수 있는 initClzFlg 를 추가하여 Input필드 및 Save 버튼  block 적용
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block      
=========================================================*/


/**
 * [CPS_GEM_0003_02] Approval of Requested expense - Transfer
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0003() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}
//=============================================================
//#Form Command          #IBSheet Action                
//INIT        = 0;       IBSEARCH       = 0;  // 조회         
//ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
//SEARCH      = 2;       IBSAVE         = 2;  // 저장         
//SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
//MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
//REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
//REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
//MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
//PRINT       = 8;       IBDELETE       = 8;  // 삭제         
//REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                     IBROWSEARCH    = 10; // Row 조회     
//                     IBCREATE       = 11; // Create       
//                     IBRESET        = 12; // Reset        
//                     IBBATCH        = 13; // Batch        
//=============================================================



//===================================================================================
//전역변수 추상함수
//===================================================================================

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;
var sheet3 = null;
var sheet4 = null;
var sheet5 = null;
var sheet6 = null;
var sheet7 = null;
var curYear = "";
var curMon = "";




//IBMultiCombo
var comboObjects = new Array();
var combo1 = null
var comboCnt = 0;

//IB tab
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0;
var tab2 = null;

//search form
var frm = null;
//transfer form
var frm1 = null;
//init , additional form
var frm2 = null
//Processing Status form
var frm6 = null

//Initial 마감정보
var initDateVO = null;
//additional 마감정보 
var closingDateVO = null;


//note팝업창 
var noteWin = null;
//Note ID
var noteId = "";

//uthorized Expense Code  팝업창
var authWin = null;
//assigend 팝업창
var assWin = null;

//Assigned Expense 구분 (FM , TO)
var assWinDiv = "";

//Authorized Expense Code 구분 (FM , TO)
var authWinDiv = "";

//request no  pop up win
var reqWin = null;


//To currInfo 통화정보
var toCurrInfo = null;

//Fm currInfo 통화정보
var fmCurrInfo = null;

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
//===================================================================================
//초기화 
//===================================================================================
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
	 frm1 = document.form1;
	 frm2 = document.form2;    
	 frm6 = document.form6;
	 
	 sheet1 = sheetObjects[0];
	 sheet2 = sheetObjects[1];    
	 sheet3 = sheetObjects[2];
	 sheet4 = sheetObjects[3];
	 sheet5 = sheetObjects[4];
	 sheet6 = sheetObjects[5];
	 sheet7 = sheetObjects[6];
	 sheetCnt = sheetObjects.length ;
	
	 //시트 초기화 
	 for(var i=0 ; i < sheetCnt ; i++) {
	     ComConfigSheet (sheetObjects[i]);
	     initSheet(sheetObjects[i],i+1);
	     ComEndConfigSheet(sheetObjects[i]);              
	 }
	 
	 //텝초기화
	 for (var i = 0; i < tabObjects.length; i++) {
	     initTab(tabObjects[i],i+1);
	 }
	 
	 tab2 = tabObjects[0];
	 
	 //IBMultiCombo초기화
	 combo1 = comboObjects[0]
	 comboCnt = comboObjects.length;
	 for(var k=0;k<comboObjects.length;k++){
	 	initCombo(comboObjects[k]);
	 }
	 
	 
	 //Form 이벤트 등록
	 initControl();    	 
	 //DIV diplay none 인경우 tab에러발생방지
	 tab2.Visible = true;	 
}

/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function sheet1_OnLoadFinish(sheet) {
	sheet.WaitImageVisible = false;	    

	
	 //오피스 콤보 호출
	 doActionIBSheet(SEARCHLIST20);
	 
	 
	 //RJ숨김
	 sheet1.ColHidden("crnt_gen_expn_apsts_cd_rj")  = true;
	 
	 //OPEN화면 호출
	 doActionIBSheet(INIT); 
	 
    if (frm6.popup_yn.value == "N") {
    	top.document.body.scrollTop = 0;
    }  else {
	   	var gen_expn_rqst_no = frm6.gen_expn_rqst_no.value;
	   	frm.gen_expn_rqst_no.value = gen_expn_rqst_no;
	   	
	   	var gen_expn_rqst_tp_cd = frm6.gen_expn_rqst_tp_cd.value;
	   	frm.gen_expn_rqst_tp_cd[0].checked = false;
	   	frm.gen_expn_rqst_tp_cd[1].checked = false;
		if ("EI" == gen_expn_rqst_tp_cd) {
			frm.gen_expn_rqst_tp_cd[1].checked = true;
			printClosingDate(initDateVO);	
		} else {		
			frm.gen_expn_rqst_tp_cd[0].checked = true;
			printClosingDate(closingDateVO);
		}

		var level2   = frm6.ofc_lvl1.value;
		var level3   = frm6.ofc_lvl2.value;
		var level4   = frm6.ofc_lvl3.value;
		var rgnOfcFlg  = frm6.sls_ofc_div_cd.value;
		
		frm.sls_ofc_div_cd[0].checked = false;
		frm.sls_ofc_div_cd[1].checked = false;
		
		if ("N" == rgnOfcFlg) {
			frm.sls_ofc_div_cd[0].checked = true;
		} else if ("Y" == rgnOfcFlg) {
			frm.sls_ofc_div_cd[1].checked = true;
		}
		
		if (frm.sls_ofc_div_cd[0].checked || frm.sls_ofc_div_cd[1].checked) {
			ComSetObjValue(frm.ofc_lvl1,level2);
			
			// LV2
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');			
			ComSetObjValue(frm.ofc_lvl2,level3);
			
			// LV3
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');			
			ComSetObjValue(frm.ofc_lvl3,level4);
			frm.ofc_lvl3.blur();
		}  else {
			frm.ofc_lvl1.value = "";
			frm.ofc_lvl2.value = "";
			frm.ofc_lvl3.value = "";
		}
		
		
		//검색 
		doActionIBSheet(SEARCHLIST);
		
		// row 번호 취득
		var row = equalsItem();
		
		if (row > 1) {
			sheet1.SelectRow = row;			
			sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false);
			displayForm(row);
		}
   }	
	
	sheet.WaitImageVisible = true;
}



/**
* Processing status에서 전송된 item정보와 동일한 item의 row를 선택한다.
*/
function equalsItem() {
	//row 번호 취득
	var formKey = frm6.gen_expn_rqst_no.value +
				  frm6.gen_expn_rqst_seq.value +
				  frm6.fm_ofc_cd.value +
				  frm6.fm_gen_expn_cd.value +
				  frm6.fm_gen_expn_itm_no.value +
				  frm6.to_ofc_cd.value +
				  frm6.to_gen_expn_cd.value +
				  frm6.to_gen_expn_itm_no.value ;
	
	for ( var i = 0; i < sheet1.RowCount; i++) {
		var row =  i + 2;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		}
		
		var sheetKey = sheet1.CellValue(row , "gen_expn_rqst_no") +
		               sheet1.CellValue(row , "gen_expn_rqst_seq") +
		               sheet1.CellValue(row , "fm_ofc_cd") +
		               sheet1.CellValue(row , "fm_gen_expn_cd") +
		               sheet1.CellValue(row , "fm_gen_expn_itm_no") +
		               sheet1.CellValue(row , "to_ofc_cd") +
		               sheet1.CellValue(row , "to_gen_expn_cd") +
		               sheet1.CellValue(row , "to_gen_expn_itm_no");		            
		if (formKey == sheetKey) {
			return row;
			break;
		}		
	}	
	
	
	return -1;
	
}

//===================================================================================
//Tab
//===================================================================================
/**
* Tab 기본 설정 탭의 항목을 설정한다.
*/
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt  = 0 ;
			InsertTab( cnt++ , "From" , -1 );
			InsertTab( cnt++ , "To" , -1 );
			BaseColor = "#F3F2F8";
		}		
		break;
	}
	
}


/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab2_OnChange(tabObj , nItem) {
    var objs = document.all.item("tabLayer_sub");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";	
	beforetab= nItem;
}


/**
* Tab 기본 설정 탭설정
*/
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
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
         style.height = 300;

         //전체 너비 설정
         SheetWidth = mainTable.clientWidth;

         //Host정보 설정[필수][HostIp, Port, PagePath]
         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         //전체Merge 종류 [선택, Default msNone]
         MergeSheet = msHeaderOnly;

        //전체Edit 허용 여부 [선택, Default false]
         Editable = true;
         
         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         InitRowInfo(2, 1, 18, 100);
         var HeadHidden = "|to_gen_expn_itm_no|to_gen_expn_itm_desc|cre_usr_id|fm_ut_val|to_ut_val|fm_usd_locl_xch_rt|fm_locl_krw_xch_rt|fm_ut_val|fm_usd_krw_xch_rt|to_usd_locl_xch_rt|to_locl_krw_xch_rt|to_usd_krw_xch_rt|gen_expn_rqst_tp_cd|gen_expn_apro_auth_ofc_cd|crnt_gen_expn_apro_step_cd|crnt_gen_expn_apsts_cd|gen_expn_rqst_seq|fm_eng_abbr_nm|to_eng_abbr_nm|fm_krn_abbr_nm|to_krn_abbr_nm|rqst_opin_rmk|req_upd_dt|itm_upd_dt";
			var HeadTitle1 = "|RJ|AP|OFC|OFC|Expense|Expense|Item\nDescription|CUR|CUR|Request Amount|Request Amount|Adjustment Amount|Adjustment Amount|ISSUED\nOFFICE|Approval Status|Approval Status|Approval Status|Approval Status|Request No. (Item)|Request No. (Item)";
			HeadTitle1 += HeadHidden;
			var HeadTitle2 = "|RJ|AP|FM|TO|FM|TO|Item\nDescription|FM|TO|FM|TO|FM|TO|ISSUED\nOFFICE|1st|2nd|3rd|FNL|Request No.|Item";
			HeadTitle2 += HeadHidden;
			var headCount = ComCountHeadTitle(HeadTitle1);

         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         InitColumnInfo(headCount, 5, 0, true);

         // 해더에서 처리할 수 있는 각종 기능을 설정한다
         InitHeadMode(false, false, true, true, false,false)

         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         InitHeadRow(0, HeadTitle1, true);
		 InitHeadRow(1, HeadTitle2, true);

         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"crnt_gen_expn_apsts_cd_rj",			false,		"",			dfNone,		0,		true,			true);
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"crnt_gen_expn_apsts_cd_ap",			false,		"",			dfNone,		0,		true,			true);			
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,       "fm_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"to_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"fm_gen_expn_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"to_gen_expn_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,	true,		"fm_gen_expn_itm_desc",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,		"fm_locl_curr_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,		"to_locl_curr_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"fm_rq_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"to_rq_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"fm_ad_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"to_ad_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"rqst_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap1",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap2",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap3",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap4",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,		"gen_expn_rqst_no",			false,		"",			dfNone,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,	    50,	daCenter,	true,		"fm_gen_expn_itm_no",			false,		"",			dfNone,		0,			false,		false);

			// -------------------------------------------------------------------------------------
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_no");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"cre_usr_id");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_usd_locl_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_locl_krw_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_usd_krw_xch_rt", false , "",dfInteger);			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_usd_locl_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_locl_krw_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_usd_krw_xch_rt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_rqst_tp_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_apro_auth_ofc_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apro_step_cd");			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apsts_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_rqst_seq");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_opin_rmk");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"req_upd_dt");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"itm_upd_dt");
			
			//CountPosition = 0;
			
			break;

		case "sheet2":

         // 높이 설정
         style.height = 142;

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

			var HeadTitle1 = "||TTL|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|gen_expn_apro_step_cd|gen_expn_apsts_cd";
			
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
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jan_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"feb_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"mar_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"apr_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"may_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jun_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jul_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aug_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"sep_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"oct_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"nov_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"dec_amt",			false,		"",			dfNullInteger , 0 , false , false);
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apsts_cd");
			ColBackColor("title") = WebColor("#EBF6F9");
			SelectionMode = smSelectionFree ;
			CountPosition = 0;
			break;
			
		case "sheet3":
			
         // 높이 설정
         style.height = 142;

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

			var HeadTitle1 = "||TTL|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|gen_expn_apro_step_cd|gen_expn_apsts_cd";
			
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
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jan_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"feb_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"mar_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"apr_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"may_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jun_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jul_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aug_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"sep_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"oct_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"nov_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"dec_amt",			false,		"",			dfNullInteger , 0 , false , false);
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apsts_cd");
			ColBackColor("title") = WebColor("#EBF6F9");
			SelectionMode = smSelectionFree ;
			CountPosition = 0;
			break;
			
		case "sheet4":
            // 높이 설정
            style.height = 140;
            
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "| |Approve|Approve|Approval ID|Approval Date|Opinion|gen_expn_apro_step_cd|gen_expn_apsts_cd";
			var HeadTitle2 = "| |Reject|Approval|Approval ID|Approval Date|Opinion|gen_expn_apro_step_cd|gen_expn_apsts_cd";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, false, true, false,false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");			
			InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"title",					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"crnt_gen_expn_apsts_cd_rj" ,					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"crnt_gen_expn_apsts_cd_ap" ,					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		"upd_usr_id",				false,		"",			dfNone,		0,	false , false);
			InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		"upd_dt",				false,		"",			dfDateYmd,		0,	false , false);
			InitDataProperty(0, cnt++ , dtData,				0,		daLeft,	true,		    "apro_opin_rmk",			false,		"",			dfNone,		0,	false , false);			
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apsts_cd");

			SelectionMode = smSelectionFree ;
			break;
		case "sheet5":
			
         // 높이 설정
         style.height = 142;

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

		 var HeadTitle1 = "||TTL|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|gen_expn_apro_step_cd|gen_expn_apsts_cd";
			
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
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jan_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"feb_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"mar_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"apr_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"may_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jun_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jul_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aug_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"sep_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"oct_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"nov_amt",			false,		"",			dfNullInteger , 0 , false , false);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"dec_amt",			false,		"",			dfNullInteger , 0 , false , false);
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apsts_cd");

			ColBackColor("title") = WebColor("#EBF6F9");
			SelectionMode = smSelectionFree ;
			CountPosition = 0;
			
			break;
			
		case "sheet6":
            // 높이 설정
            style.height = 140;
            
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "| |Approve|Approve|Approval ID|Approval Date|Opinion|gen_expn_apro_step_cd|gen_expn_apsts_cd";
			var HeadTitle2 = "| |Reject|Approval|Approval ID|Approval Date|Opinion|gen_expn_apro_step_cd|gen_expn_apsts_cd";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            //InitHeadMode(true, true, false, true, false,false)
            InitHeadMode(false, false, false, true, false,false);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");			
			InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"title",					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"crnt_gen_expn_apsts_cd_rj" ,					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"crnt_gen_expn_apsts_cd_ap" ,					false,		"",			dfNone,		0,			false , false);
			InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		"upd_usr_id",				false,		"",			dfNone,		0,	false , false);
			InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	true,		"upd_dt",				false,		"",			dfDateYmd,		0,	false , false);
			InitDataProperty(0, cnt++ , dtData,				0,		daLeft,	true,		"apro_opin_rmk",			false,		"",			dfNone,		0,	false , false);			
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apro_step_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_apsts_cd");

			SelectionMode = smSelectionFree ;
			break;
		case "sheet7":
			if (location.hostname != "") {
			 	WaitImageVisible = false; 
			 	InitHostInfo(location.hostname, location.port, page_path);
			}
			break;
		}
	}
}


//===================================================================================
//Private function
//===================================================================================

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
	
	var row = frm.rownum.value;
	var gen_expn_rqst_no = sheet1.CellValue(row , "gen_expn_rqst_no");
	var genExpnRqstSeq = sheet1.CellValue(row , "gen_expn_rqst_seq");	
	var param = "f_cmd=" + SEARCH01;
	param += "&gen_expn_rqst_no=" + gen_expn_rqst_no;	
	param += "&gen_expn_rqst_seq=" + genExpnRqstSeq;
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);
	var updDt = ComGetEtcData(sXml ,"itmDt");
	
	if (ComIsNull(updDt)) {
		return "3";
	}
	
	var itmUpdDt = sheet1.CellValue(row , "itm_upd_dt");
	
	if (updDt == itmUpdDt ) {
		return "2";
	} else {
		return "1";
	}
	
}   



/**
* 팝업에서 genExpnRqstNo 받음
*/
function setGenExpnRqstNo(genExpnRqstNo) {
	frm.gen_expn_rqst_no.value = genExpnRqstNo;	
	doActionIBSheet(SEARCHLIST);
}



/**
* 팝업에서 expenseCode를 받음
*/
function setExpenseCode(expenseInfoList) {
	 	
	if (authWinDiv == "FM") {
		if (expenseInfoList.length > 0 ) {
			var expenseInfo = expenseInfoList[0];
			ComSetObjValue(frm.fm_gen_expn_cd ,expenseInfo.gen_expn_cd);
			ComSetObjValue(frm.fm_tic_cd , expenseInfo.tic_cd);
			ComSetObjValue(frm.fm_krn_abbr_nm , expenseInfo.krn_abbr_nm);
		    ComSetObjValue(frm.fm_eng_abbr_nm , expenseInfo.eng_abbr_nm);
		}
		
		//From Assigned Expense 호출
		setTimeout("openPopup1()",500);
		
		
	} else if (authWinDiv == "TO") {	
		if (expenseInfoList.length > 0 ) {
			var expenseInfo = expenseInfoList[0];				
			//ComSetObjValue(frm.fm_ofc_cd , expenseInfo.ofc_cd);
			ComSetObjValue(frm.to_gen_expn_cd ,expenseInfo.gen_expn_cd);
			ComSetObjValue(frm.to_tic_cd , expenseInfo.tic_cd);
			ComSetObjValue(frm.to_krn_abbr_nm , expenseInfo.krn_abbr_nm);
		    ComSetObjValue(frm.to_eng_abbr_nm , expenseInfo.eng_abbr_nm);
			var plnYrmon =  frm.pln_yr.value;		
			//expense MAX ITEM 취득 
			//MaxItem 취득 
			var plnYrmon =  frm.pln_yr.value
			var itemNo = searchMaxItem(plnYrmon ,
					                   expenseInfo.ofc_cd ,
					                   expenseInfo.gen_expn_cd);	
			
			
			itemNo = getGenExpnItmNo(expenseInfo.ofc_cd  , 
					                 expenseInfo.gen_expn_cd , 
					                 itemNo);		

			frm.to_gen_expn_itm_no.value = itemNo;	
			
			frm.pre_to_gen_expn_itm_no.value = itemNo;
			
		}
		
		
	}
		

}


/**
* 팝업에서 Assigned Expense 정보전달 
* @param {json}  expenseInfo Assigned Expense 정보
*/
function setAssignedExpense(expenseInfo) {
	
	var row = 1;
	if (assWinDiv == "FM") {
		row = 1;
	} else if (assWinDiv == "TO") {
		row = 2;
	}
	
	sheet2.CellValue2(row , "jan_amt") = expenseInfo.jan_amt;
	sheet2.CellValue2(row , "feb_amt") = expenseInfo.feb_amt;
	sheet2.CellValue2(row , "mar_amt") = expenseInfo.mar_amt;
	sheet2.CellValue2(row , "apr_amt") = expenseInfo.apr_amt;
	sheet2.CellValue2(row , "may_amt") = expenseInfo.may_amt;
	sheet2.CellValue2(row , "jun_amt") = expenseInfo.jun_amt;
	sheet2.CellValue2(row , "jul_amt") = expenseInfo.jul_amt;
	sheet2.CellValue2(row , "aug_amt") = expenseInfo.aug_amt;
	sheet2.CellValue2(row , "sep_amt") = expenseInfo.sep_amt;
	sheet2.CellValue2(row , "oct_amt") = expenseInfo.oct_amt;
	sheet2.CellValue2(row , "nov_amt") = expenseInfo.nov_amt;
	sheet2.CellValue2(row , "dec_amt") = expenseInfo.dec_amt;
	
	if (assWinDiv == "FM") {
		frm.fm_gen_expn_itm_desc.value = expenseInfo.gen_expn_itm_desc;              
		frm.fm_gen_expn_itm_no.value   = expenseInfo.gen_expn_itm_no;
		frm.fm_chk_assigned.checked = true;
		frm.fm_chk_assigned.disabled = true;
		frm.fm_gen_expn_itm_desc.readOnly = true;
	} else if (assWinDiv == "TO") {
		frm.to_gen_expn_itm_desc.value = expenseInfo.gen_expn_itm_desc;              
		frm.to_gen_expn_itm_no.value   = expenseInfo.gen_expn_itm_no;
		frm.to_chk_assigned.checked = true;
		//frm.to_chk_assigned.disabled = true;
		frm.to_gen_expn_itm_desc.readOnly = true;
	}


		
	                                                                                                                        
}

/**
 * ET 마감일 정보 표시
 * @param {string} type 마감구분 type "EI":init "EA":addiontional,transfer  
 */
function initClosingDate(type) {
	
	
	if ("EI" == type) {
		printClosingDate(initDateVO);		
		mon = 1;
		// ET ..................
		frm1.fm_monthFrom.length = 0;					
		for ( var i = mon; i <= 12; i++) {
			ComAddComboItem(frm1.fm_monthFrom,  getEngMonthName(i) , i);
		}
		
	} else {
		
		printClosingDate(closingDateVO);

		var clzYrmon = 	closingDateVO["clz_yrmon"];
		
		//마감정보 설정
		frm.pln_yrmon.value = clzYrmon;				

		var clzMon = clzYrmon.substring(4,6);

		var mon = parseInt(clzMon , 10);		
		if (mon == 0) {
			mon = 1;
		}
		
		// EA ..................
		frm1.fm_monthFrom.length = 0;					
		for ( var i = mon; i <= 12; i++) {
			ComAddComboItem(frm1.fm_monthFrom,  getEngMonthName(i) , i);
		}		
	}
	
	frm1.fm_monthTo.length = 0;
	ComAddComboItem(frm1.fm_monthTo,  "" , "");
	comboCopy(frm1.fm_monthFrom, frm1.fm_monthTo, false);
	frm1.fm_monthTo.value = "";
	
	frm1.to_monthFrom.length = 0;
	ComAddComboItem(frm1.to_monthFrom,  "" , "");
	comboCopy(frm1.fm_monthFrom, frm1.to_monthFrom, false);
	
	frm1.to_monthTo.length = 0;
	ComAddComboItem(frm1.to_monthTo,  "" , "");
	comboCopy(frm1.fm_monthFrom, frm1.to_monthTo, false);
	frm1.to_monthTo.value = "";
	
	// EA ,EI ..................
	frm2.fm_monthFrom.length = 0;
	ComAddComboItem(frm2.fm_monthFrom,  "" , "");
	comboCopy(frm1.fm_monthFrom, frm2.fm_monthFrom, false);					
	
	frm2.fm_monthTo.length = 0;
	ComAddComboItem(frm2.fm_monthTo,  "" , "");
	comboCopy(frm1.fm_monthFrom, frm2.fm_monthTo, false);
	frm2.fm_monthTo.value = "";	
	
	frm1.fm_monthFrom.disabled = true;
	frm1.to_monthFrom.disabled = true;
	frm1.fm_monthTo.disabled = true;
	frm1.to_monthTo.disabled = true;
	frm2.fm_monthFrom.disabled = true;
	frm2.fm_monthTo.disabled = true; 
 
}


/**
* ET 마감일 정보 표시
* @param {array} closingDateVO 마감정보
*/
function printClosingDate(closingDateVO) {
	
	//예산년월
	var clzYrmon = 	closingDateVO["clz_yrmon"];
	
	//예산년월 설정
	frm.pln_yrmon.value = clzYrmon;
	
	//마감일
	var clzDt = 	closingDateVO["clz_dt"];
	
	var clzYr = clzYrmon.substring(0,4);
	var clzMon = clzYrmon.substring(4,6);
	
	var clzDtYr = clzDt.substring(0,4);
	var clzDtMon = clzDt.substring(4,6);
	var clzDtDay = clzDt.substring(6,8);
	
	document.getElementById("et_clz_yrmon").innerText = 
		getEngMonthName(clzMon) + " " + clzYr;			
	
	document.getElementById("et_clz_day").innerText = clzDtDay;
	
	document.getElementById("et_clz_dt").innerText = 
		getEngMonthName(clzDtMon) + " " + clzDtYr;	

	document.getElementById("ei_clz_yrmon").innerText = 
		getEngMonthName(clzMon) + " " + clzYr;			
	
	document.getElementById("ei_clz_day").innerText = clzDtDay;
	
	document.getElementById("ei_clz_dt").innerText = 
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
 * 오피스 권한 활성화 , 비활성화  
 */
function setExpnGroupList() {
	// ---------------------------------
	// Expense Code group code 
	// ---------------------------------
	combo1.RemoveAll();		
	combo1.InsertItem(0,"Select All","");
	for(var i=0 ; i < expnGroupList.length ; i++ ) {
		var expense = expnGroupList[i];
		var langDiv = ComGetObjValue(frm.lang_div);
		if (langDiv == "KOR") {
			combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["krn_abbr_nm"],expense["gen_expn_cd"]);
		} else if(langDiv == "ENG") {
			combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["eng_abbr_nm"],expense["gen_expn_cd"]);
		}				
	}
	combo1.Code = "";	
}


/**
* 예산년도의 비용코드에 대한 시트에서 Item No 취득 
* @param {string} ofcCd 오피스코드
* @param {string} genExpnCd 비요코드
* @param {string} itemNo 아이템번호
*/
function getGenExpnItmNo(ofcCd , genExpnCd , itemNo) {
	
	var genExpnItmNo = itemNo;
	
	for ( var i = 0; i < sheet1.RowCount ; i++) {
		var row =  i + 1;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		}
		
		//gen_expn_cd , gen_expn_itm_no
		var sOfcCd = sheet1.CellValue(row , "to_ofc_cd");
		var sGenExpnCd = sheet1.CellValue(row , "to_gen_expn_cd");
		var sItemNo = sheet1.CellValue(row , "to_gen_expn_itm_no");
		
		//오피스 , 비용코드가 같을경우
		if (ofcCd ==  sOfcCd  && genExpnCd == sGenExpnCd) {
			// 시트에 존재하는 itemNo가  인자로 받은 ItemNo보다 클경우 시트의  Item으로  설정
			if (sItemNo >= genExpnItmNo) {
				//최대값 + 1
				genExpnItmNo = parseInt(sItemNo , 10) + 1;
				if (genExpnItmNo < 10) {
					genExpnItmNo = "00" + genExpnItmNo;
				} else if (genExpnItmNo < 100) {
					genExpnItmNo = "0" + genExpnItmNo;
				} 
			}
		}
		
	}
	
	return genExpnItmNo ;
	
	
}

/**
* 예산년도의 비용코드에 대한 시트에서 SEQ MAX + 1 취득
*   
*/
function getMaxSeq() {
	
	var genExpnRqstSeq = "01";
	
	for ( var i = 0; i < sheet1.RowCount ; i++) {
		var row =  i + 2;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		}
		
		var gen_expn_rqst_seq = 
			sheet1.CellValue(row , "gen_expn_rqst_seq");
	
		// 시트에 존재하는 SEQ가  이전 SEQ보다 클경우 시트의  SEQ으로  설정 		
		if (gen_expn_rqst_seq >= genExpnRqstSeq) {
			//최대값 + 1
			gen_expn_rqst_seq = parseInt(gen_expn_rqst_seq) + 1;
			if (gen_expn_rqst_seq < 10) {
				gen_expn_rqst_seq = "0" + gen_expn_rqst_seq;
			}
			
			genExpnRqstSeq = gen_expn_rqst_seq;
		}
		
	}
	
	return genExpnRqstSeq ;
	
	
}


/**
* expense code 체크 및 정보 설정
* @param {string} div FM => FM expensecode
* @param {string} ofcCd 오피스코드
* @param {string} genExpnCd 비요코드
* 
*/   
function checkExpnInfo(div) {
	// 해당 오피스 비용코드 유무 체크
	var plnYrmon =  frm.pln_yr.value;
	
	var param = "";
	if (div == "FM") {
		
		
		var fm_gen_expn_cd = frm.fm_gen_expn_cd.value;		
		if ( ComIsNull(fm_gen_expn_cd) ) {
			return; 
		}

		if (!ComChkObjValid(frm.fm_ofc_lvl3)) {
			return;
		}
		
		if (fm_gen_expn_cd.length != 6) {
		    //msgs["GEM01039"] = "오피스코드에 대한 비용코드가 존재하지 않습니다.";
			ComShowCodeMessage("GEM01039");
			frm.fm_gen_expn_cd.value = "";
			frm.fm_gen_expn_cd.focus();
			return ;
		}
		
		param  += "f_cmd=" + SEARCHLIST02;
		param  += "&pln_yrmon=" + plnYrmon + 
		            "&ofc_cd=" + frm.fm_ofc_lvl3.value + 
		            "&gen_expn_cd=" + frm.fm_gen_expn_cd.value ;
	} else if (div == "TO") {
		var to_gen_expn_cd = frm.to_gen_expn_cd.value;
		if ( ComIsNull(to_gen_expn_cd) ) {
			return; 
		}

		if (!ComChkObjValid(frm.to_ofc_lvl3)) {
			return;
		}
		
		if (to_gen_expn_cd.length != 6) {
		    //msgs["GEM01039"] = "오피스코드에 대한 비용코드가 존재하지 않습니다.";
			ComShowCodeMessage("GEM01039");
			frm.to_gen_expn_cd.value = "";
			frm.to_gen_expn_cd.focus();
			return ;
		}
		
		param  += "f_cmd=" + SEARCHLIST02;
		param  += "&pln_yrmon=" + plnYrmon + 
		            "&ofc_cd=" + frm.to_ofc_lvl3.value + 
		            "&gen_expn_cd=" + frm.to_gen_expn_cd.value ;		
	}
	
	
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);
	
	var genExpnInfoList = ComXml2ListMap(sXml);
	
	if (genExpnInfoList.length == 0) {
	    //msgs["GEM01039"] = "오피스코드에 대한 비용코드가 존재하지 않습니다.";
		ComShowCodeMessage("GEM01039");
		if (div == "FM") {
			frm.fm_gen_expn_cd.value = "";
			frm.fm_gen_expn_cd.focus();
			
		} else if (div == "TO") {
			frm.to_gen_expn_cd.value = "";
			frm.to_gen_expn_cd.focus();	
		}
		return ;
	}               
	
	
	var expenseInfo = genExpnInfoList[0];
	
	var itemNo =  ComGetEtcData(sXml ,"itemNo");
	
	if (div == "FM") {
		ComSetObjValue(frm.fm_gen_expn_cd ,expenseInfo["gen_expn_cd"]);
		ComSetObjValue(frm.fm_tic_cd , expenseInfo["tic_cd"]);
		ComSetObjValue(frm.fm_krn_abbr_nm , expenseInfo["krn_abbr_nm"]);
	    ComSetObjValue(frm.fm_eng_abbr_nm , expenseInfo["eng_abbr_nm"]);
	    ComSetObjValue(frm.fm_eng_abbr_nm , expenseInfo["eng_abbr_nm"]);
	    ComSetObjValue(frm.fm_gen_expn_itm_no , itemNo);
	} else if (div == "TO") {
		ComSetObjValue(frm.to_gen_expn_cd ,expenseInfo["gen_expn_cd"]);
		ComSetObjValue(frm.to_tic_cd , expenseInfo["tic_cd"]);
		ComSetObjValue(frm.to_krn_abbr_nm , expenseInfo["krn_abbr_nm"]);
	    ComSetObjValue(frm.to_eng_abbr_nm , expenseInfo["eng_abbr_nm"]);
	    ComSetObjValue(frm.to_eng_abbr_nm , expenseInfo["eng_abbr_nm"]);
	    ComSetObjValue(frm.to_gen_expn_itm_no , itemNo);
	}
	
	
}

/**                                                                                                                                                                                                                                                                                                
* 폼데이타 (item + apro_step) 을 sheet1에 ofc_cd , gen_expn_cd , item별 저장                                                                                                                                                                                                                      
* @param {long} row 시트 행번호                                                                                                                                                                                                                                                                   
*/                                                                                                                                                                                                                                                                                                
function setFormToSheet1(row) {
	 	var fm_gen_expn_rqst_seq = frm.fm_gen_expn_rqst_seq.value;
		if (ComIsNull(fm_gen_expn_rqst_seq)) {
			sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = getMaxSeq();
		} else {
			sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = fm_gen_expn_rqst_seq;
		}
		
		sheet1.CellValue2(row,"fm_gen_expn_trns_div_cd") = "F";
	 	sheet1.CellValue2(row,"fm_sls_ofc_div_cd") = checkBoxValue(frm.fm_sls_ofc_div_cd);
		sheet1.CellValue2(row,"fm_ofc_cd") = ComGetObjValue(frm.fm_ofc_lvl3);
		sheet1.CellValue2(row,"fm_ofc_lvl1") = ComGetObjValue(frm.fm_ofc_lvl1);
		sheet1.CellValue2(row,"fm_ofc_lvl2") = ComGetObjValue(frm.fm_ofc_lvl2);
		
		sheet1.CellValue2(row,"fm_gen_expn_cd") = ComGetObjValue(frm.fm_gen_expn_cd);
		sheet1.CellValue2(row,"fm_eng_abbr_nm") = ComGetObjValue(frm.fm_eng_abbr_nm);
		sheet1.CellValue2(row,"fm_krn_abbr_nm") = ComGetObjValue(frm.fm_krn_abbr_nm);
	    if (ComGetObjValue(frm.lang_div) == "KOR") {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_krn_abbr_nm.value;
	    } else {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_eng_abbr_nm.value;
	    }
		sheet1.CellValue2(row,"fm_tic_cd") = ComGetObjValue(frm.fm_tic_cd);

		sheet1.CellValue2(row,"fm_chk_assigned") = checkBoxValue(frm.fm_chk_assigned);
		sheet1.CellValue2(row,"fm_gen_expn_itm_no") = ComGetObjValue(frm.fm_gen_expn_itm_no);
		sheet1.CellValue2(row,"fm_gen_expn_itm_desc") = ComGetObjValue(frm.fm_gen_expn_itm_desc);
		sheet1.CellValue2(row,"fm_gen_expn_calc_bss_desc") = "";
		sheet1.CellValue2(row,"fm_rqst_opin_rmk") = "";
		
		sheet1.CellValue2(row,"fm_locl_curr_cd") = 
			document.getElementById("fm_locl_curr_cd").innerText;		
		sheet1.CellValue2(row,"fm_rqst_ut_val") = ComGetObjValue(frm.fm_rqst_ut_val);
		sheet1.CellValue2(row,"fm_rqst_locl_amt") = sheet2.CellValue(3,"ttl");		
		sheet1.CellValue2(row,"fm_usd_locl_xch_rt") = ComGetObjValue(frm.fm_usd_locl_xch_rt);
		sheet1.CellValue2(row,"fm_rqst_usd_amt") = 
			ComTrimAll(ComGetObjValue(frm.fm_rqst_usd_amt),",");

		sheet1.CellValue2(row,"fm_jan_amt") = sheet2.CellValue(1 , "jan_amt");
		sheet1.CellValue2(row,"fm_feb_amt") = sheet2.CellValue(1 , "feb_amt");
		sheet1.CellValue2(row,"fm_mar_amt") = sheet2.CellValue(1 , "mar_amt");
		sheet1.CellValue2(row,"fm_apr_amt") = sheet2.CellValue(1 , "apr_amt");
		sheet1.CellValue2(row,"fm_may_amt") = sheet2.CellValue(1 , "may_amt");
		sheet1.CellValue2(row,"fm_jun_amt") = sheet2.CellValue(1 , "jun_amt");
		sheet1.CellValue2(row,"fm_jul_amt") = sheet2.CellValue(1 , "jul_amt");
		sheet1.CellValue2(row,"fm_aug_amt") = sheet2.CellValue(1 , "aug_amt");
		sheet1.CellValue2(row,"fm_sep_amt") = sheet2.CellValue(1 , "sep_amt");
		sheet1.CellValue2(row,"fm_oct_amt") = sheet2.CellValue(1 , "oct_amt");
		sheet1.CellValue2(row,"fm_nov_amt") = sheet2.CellValue(1 , "nov_amt");
		sheet1.CellValue2(row,"fm_dec_amt") = sheet2.CellValue(1 , "dec_amt");
		sheet1.CellValue2(row,"fm_rqst_jan_amt") = sheet2.CellValue(3 , "jan_amt");
		sheet1.CellValue2(row,"fm_rqst_feb_amt") = sheet2.CellValue(3 , "feb_amt");
		sheet1.CellValue2(row,"fm_rqst_mar_amt") = sheet2.CellValue(3 , "mar_amt");
		sheet1.CellValue2(row,"fm_rqst_apr_amt") = sheet2.CellValue(3 , "apr_amt");
		sheet1.CellValue2(row,"fm_rqst_may_amt") = sheet2.CellValue(3 , "may_amt");
		sheet1.CellValue2(row,"fm_rqst_jun_amt") = sheet2.CellValue(3 , "jun_amt");
		sheet1.CellValue2(row,"fm_rqst_jul_amt") = sheet2.CellValue(3 , "jul_amt");
		sheet1.CellValue2(row,"fm_rqst_aug_amt") = sheet2.CellValue(3 , "aug_amt");
		sheet1.CellValue2(row,"fm_rqst_sep_amt") = sheet2.CellValue(3 , "sep_amt");
		sheet1.CellValue2(row,"fm_rqst_oct_amt") = sheet2.CellValue(3 , "oct_amt");
		sheet1.CellValue2(row,"fm_rqst_nov_amt") = sheet2.CellValue(3 , "nov_amt");
		sheet1.CellValue2(row,"fm_rqst_dec_amt") = sheet2.CellValue(3 , "dec_amt");

		sheet1.CellValue2(row,"to_gen_expn_rqst_seq") = sheet1.CellValue(row,"fm_gen_expn_rqst_seq");
		sheet1.CellValue2(row,"to_gen_expn_trns_div_cd") = "T";
		sheet1.CellValue2(row,"to_sls_ofc_div_cd") = checkBoxValue(frm.to_sls_ofc_div_cd);
		sheet1.CellValue2(row,"to_ofc_cd") = ComGetObjValue(frm.to_ofc_lvl3);
		sheet1.CellValue2(row,"to_ofc_lvl1") = ComGetObjValue(frm.to_ofc_lvl1);
		sheet1.CellValue2(row,"to_ofc_lvl2") = ComGetObjValue(frm.to_ofc_lvl2);
		
		sheet1.CellValue2(row,"to_gen_expn_cd") = ComGetObjValue(frm.to_gen_expn_cd);
		sheet1.CellValue2(row,"to_eng_abbr_nm") = ComGetObjValue(frm.to_eng_abbr_nm);
		sheet1.CellValue2(row,"to_krn_abbr_nm") = ComGetObjValue(frm.to_krn_abbr_nm);
	    if (ComGetObjValue(frm.lang_div) == "KOR") {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.to_krn_abbr_nm.value;
	    } else {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.to_eng_abbr_nm.value;
	    }
		sheet1.CellValue2(row,"to_tic_cd") = ComGetObjValue(frm.to_tic_cd);

		sheet1.CellValue2(row,"to_chk_assigned") = checkBoxValue(frm.to_chk_assigned);
		sheet1.CellValue2(row,"to_gen_expn_itm_no") = ComGetObjValue(frm.to_gen_expn_itm_no);
		sheet1.CellValue2(row,"to_gen_expn_itm_desc") = ComGetObjValue(frm.to_gen_expn_itm_desc);
		sheet1.CellValue2(row,"to_gen_expn_calc_bss_desc") = ComGetObjValue(frm.to_gen_expn_calc_bss_desc);
		sheet1.CellValue2(row,"to_rqst_opin_rmk") = ComGetObjValue(frm.to_rqst_opin_rmk);
		
		sheet1.CellValue2(row,"to_locl_curr_cd") = 
			document.getElementById("to_locl_curr_cd").innerText;		
		sheet1.CellValue2(row,"to_rqst_ut_val") = ComGetObjValue(frm.to_rqst_ut_val);
		sheet1.CellValue2(row,"to_rqst_locl_amt") = sheet2.CellValue(4,"ttl");
		sheet1.CellValue2(row,"to_usd_locl_xch_rt") = ComGetObjValue(frm.to_usd_locl_xch_rt);
		sheet1.CellValue2(row,"to_rqst_usd_amt") = 
			ComTrimAll(ComGetObjValue(frm.fm_rqst_usd_amt),",");
		
		sheet1.CellValue2(row,"to_jan_amt") = sheet2.CellValue(2 , "jan_amt");
		sheet1.CellValue2(row,"to_feb_amt") = sheet2.CellValue(2 , "feb_amt");
		sheet1.CellValue2(row,"to_mar_amt") = sheet2.CellValue(2 , "mar_amt");
		sheet1.CellValue2(row,"to_apr_amt") = sheet2.CellValue(2 , "apr_amt");
		sheet1.CellValue2(row,"to_may_amt") = sheet2.CellValue(2 , "may_amt");
		sheet1.CellValue2(row,"to_jun_amt") = sheet2.CellValue(2 , "jun_amt");
		sheet1.CellValue2(row,"to_jul_amt") = sheet2.CellValue(2 , "jul_amt");
		sheet1.CellValue2(row,"to_aug_amt") = sheet2.CellValue(2 , "aug_amt");
		sheet1.CellValue2(row,"to_sep_amt") = sheet2.CellValue(2 , "sep_amt");
		sheet1.CellValue2(row,"to_oct_amt") = sheet2.CellValue(2 , "oct_amt");
		sheet1.CellValue2(row,"to_nov_amt") = sheet2.CellValue(2 , "nov_amt");
		sheet1.CellValue2(row,"to_dec_amt") = sheet2.CellValue(2 , "dec_amt");
		sheet1.CellValue2(row,"to_rqst_jan_amt") = sheet2.CellValue(4 , "jan_amt");
		sheet1.CellValue2(row,"to_rqst_feb_amt") = sheet2.CellValue(4 , "feb_amt");
		sheet1.CellValue2(row,"to_rqst_mar_amt") = sheet2.CellValue(4 , "mar_amt");
		sheet1.CellValue2(row,"to_rqst_apr_amt") = sheet2.CellValue(4 , "apr_amt");
		sheet1.CellValue2(row,"to_rqst_may_amt") = sheet2.CellValue(4 , "may_amt");
		sheet1.CellValue2(row,"to_rqst_jun_amt") = sheet2.CellValue(4 , "jun_amt");
		sheet1.CellValue2(row,"to_rqst_jul_amt") = sheet2.CellValue(4 , "jul_amt");
		sheet1.CellValue2(row,"to_rqst_aug_amt") = sheet2.CellValue(4 , "aug_amt");
		sheet1.CellValue2(row,"to_rqst_sep_amt") = sheet2.CellValue(4 , "sep_amt");
		sheet1.CellValue2(row,"to_rqst_oct_amt") = sheet2.CellValue(4 , "oct_amt");
		sheet1.CellValue2(row,"to_rqst_nov_amt") = sheet2.CellValue(4 , "nov_amt");
		sheet1.CellValue2(row,"to_rqst_dec_amt") = sheet2.CellValue(4 , "dec_amt");
		
		
		//USD total;
		var usdTotal = getUsdTotal();
		
		frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,0));
	                                                                                                                                                                                                                                                                                                   
}                                                                                                                                                                                                                                                                                                    
       
/**                                                                                                                                                                                                                                                                                                  
* 시트 sheet1에 데이타 조회후 폼데이타에 설정                                                                                                                                                                                                                                                          
* @param {long} srow 시트 행번호                                                                                                                                                                                                                                                                     
*/                                                                                                                                                                                                                                                                                                  
function setSheet1ToForm2( srow ) {   
	
		var pln_yrmon = frm.pln_yrmon.value;
		var init_clz_flg = frm.init_clz_flg.value;
		var pln_yr = pln_yrmon.substring(0,4);
		var pln_mon = pln_yrmon.substring(4,6);
	 
		var queryString = getSheetRowQueryString(sheet1,srow);
		
		var param = "f_cmd=" + SEARCHLIST01;
		
		param +=  "&" + queryString;
		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0001_03GS.do", param);		
		
		var arrXml = sXml.split("|$$|");
		
		var gen_expn_rqst_tp_cd = sheet1.CellValue(srow ,"gen_expn_rqst_tp_cd");
		
		
		if ("EA" == gen_expn_rqst_tp_cd) {
			frm2.gen_expn_rqst_tp_cd[1].checked = true;
		} else {		
			frm2.gen_expn_rqst_tp_cd[0].checked = true;
		}
		
		//초기화
		
		sheet5.RemoveAll();	
		sheet6.RemoveAll();
		
		//1. request
		if (arrXml.length > 0) {		
			var list = ComXml2ListMap(arrXml[0]);
			var request  = list[0];			
			
			frm2.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
			var pln_yrmon = request["pln_yrmon"];
			frm2.pln_yr.value = pln_yrmon.substring(0,4);
			
			
			if (gen_expn_rqst_tp_cd != "EI") {
				frm2.pln_mon.value = pln_yrmon.substring(4,6);
			}
			
			frm2.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
			frm2.rqst_ofc_cd.value = request["rqst_ofc_cd"];
			frm2.cre_usr_id.value = request["cre_usr_id"];
		}	
		
		//2. fm_item
		if (arrXml.length > 1) {		
			var list = ComXml2ListMap(arrXml[1]);
			var item  = list[0];
			var row = sheet5.DataInsert(-1);
			sheet5.CellValue2(row, "title") = "Assigned";
		 	sheet5.CellValue2(row ,"jan_amt") = item["jan_amt"];
		 	sheet5.CellValue2(row ,"feb_amt") = item["feb_amt"];
		 	sheet5.CellValue2(row ,"mar_amt") = item["mar_amt"];
		 	sheet5.CellValue2(row ,"apr_amt") = item["apr_amt"];
		 	sheet5.CellValue2(row ,"may_amt") = item["may_amt"];
		 	sheet5.CellValue2(row ,"jun_amt") = item["jun_amt"];
		 	sheet5.CellValue2(row ,"jul_amt") = item["jul_amt"];
		 	sheet5.CellValue2(row ,"aug_amt") = item["aug_amt"];
		 	sheet5.CellValue2(row ,"sep_amt") = item["sep_amt"];
		 	sheet5.CellValue2(row ,"oct_amt") = item["oct_amt"];
		 	sheet5.CellValue2(row ,"nov_amt") = item["nov_amt"];
		 	sheet5.CellValue2(row ,"dec_amt") = item["dec_amt"];	
		 	frm2.fm_gen_expn_itm_desc.value = item["gen_expn_itm_desc"];
		 	frm2.fm_gen_expn_itm_no.value = item["gen_expn_itm_no"];
		 	frm2.fm_gen_expn_calc_bss_desc.value = item["gen_expn_calc_bss_desc"];
		 	frm2.fm_rqst_opin_rmk.value = item["rqst_opin_rmk"];
		}
		
		//3. fm_aproStep
		if (arrXml.length > 2) {		
			var list = ComXml2ListMap(arrXml[2]);

			for ( var i = 0; i < list.length; i++) {
				sheet5.DataInsert(-1);
				sheet6.DataInsert(-1);
			}
			
			//Editable Cell ===========================
			var janCol = sheet5.SaveNameCol("jan_amt");
			var decCol = sheet5.SaveNameCol("dec_amt");
			var rjCol = sheet6.SaveNameCol("crnt_gen_expn_apsts_cd_rj");
			var aproCol = sheet6.SaveNameCol("apro_opin_rmk");
			var start = janCol + parseInt(pln_mon , 10) - 1;
			
			var editRow = 0 ;
			
			for ( var i = 0; i < list.length; i++) {
				var aproStep  = list[i];
				var row = i + 2;
				var step = aproStep["gen_expn_apro_step_cd"];
				//Editable Cell ===========================
				var gen_expn_apsts_cd = aproStep["gen_expn_apsts_cd"];
				//RQ 이면 CELL Editale
				if (gen_expn_apsts_cd == "RQ" || gen_expn_apsts_cd == "AD") {
					if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "N") {
						for ( var j = janCol ; j <= decCol; j++) {		
							sheet5.CellEditable(row,j) = true;
						}
					} else if (gen_expn_rqst_tp_cd == "EA" || gen_expn_rqst_tp_cd == "ET") {		
						for ( var j = start ; j <= decCol; j++) {		
							sheet5.CellEditable(row,j) = true;
						}			
					}			
					
					sheet6.CellEditable(row,"crnt_gen_expn_apsts_cd_rj") = true;
					sheet6.CellEditable(row,"crnt_gen_expn_apsts_cd_ap") = true;
					sheet6.CellEditable(row,"apro_opin_rmk") = true;
					editRow = row;
				}
				
				sheet5.CellValue2(row, "title") = getStepOffice(step);				
			 	sheet5.CellValue2(row ,"jan_amt") = aproStep["jan_amt"];
			 	sheet5.CellValue2(row ,"feb_amt") = aproStep["feb_amt"];
			 	sheet5.CellValue2(row ,"mar_amt") = aproStep["mar_amt"];
			 	sheet5.CellValue2(row ,"apr_amt") = aproStep["apr_amt"];
			 	sheet5.CellValue2(row ,"may_amt") = aproStep["may_amt"];
			 	sheet5.CellValue2(row ,"jun_amt") = aproStep["jun_amt"];
			 	sheet5.CellValue2(row ,"jul_amt") = aproStep["jul_amt"];
			 	sheet5.CellValue2(row ,"aug_amt") = aproStep["aug_amt"];
			 	sheet5.CellValue2(row ,"sep_amt") = aproStep["sep_amt"];
			 	sheet5.CellValue2(row ,"oct_amt") = aproStep["oct_amt"];
			 	sheet5.CellValue2(row ,"nov_amt") = aproStep["nov_amt"];
			 	sheet5.CellValue2(row ,"dec_amt") = aproStep["dec_amt"];
			 	//저장ROW
			 	sheet5.CellValue2(row ,"gen_expn_apsts_cd") = gen_expn_apsts_cd;
			 	sheet5.CellValue2(row ,"gen_expn_apro_step_cd") = step;
			 	
			 	if (gen_expn_apsts_cd == "AP") {
			 		sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
				 	sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_ap") = 1;
			 	} else if (gen_expn_apsts_cd == "RJ") {
			 		sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_rj") = 1;
				 	sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_ap") = 0;				 	
			 	} else {
			 		sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
				 	sheet6.CellValue2(row ,"crnt_gen_expn_apsts_cd_ap") = 0;			
				 	sheet6.CellValue2(row ,"apro_opin_rmk") = aproStep["apro_opin_rmk"];
			 	}
			 	
				sheet6.CellValue2(row, "title") = getStepOffice(step);
				sheet6.CellValue2(row ,"apro_opin_rmk") = aproStep["apro_opin_rmk"];
				sheet6.CellValue(row ,"gen_expn_apsts_cd") = gen_expn_apsts_cd;
				sheet6.CellValue(row ,"gen_expn_apro_step_cd") = step;
			 	
			 	if ( gen_expn_apsts_cd == "AP" || gen_expn_apsts_cd == "RJ" ) {
				 	sheet6.CellValue2(row ,"upd_usr_id") = aproStep["upd_usr_id"];
				 	sheet6.CellValue2(row ,"upd_dt") = aproStep["upd_dt"];
			 	}
			}
			//마지막 Step의 이전 월의 금액은 0 으로 설정		
			if (gen_expn_rqst_tp_cd != "EI") {					
				var start = janCol + parseInt(pln_mon , 10) - 2 ;
				
				for ( var i = janCol ; i <= start; i++) {		
					sheet5.CellValue2(editRow,i) = 0;
				}
			}
		
			frm2.fm_rq_amt.value = sheet5.CellText(2, "ttl");	
			frm2.fm_ad_amt.value = sheet5.CellText(editRow ,"ttl");

		}
		
	
		
		//4.fm_ofc level
		if (arrXml.length > 3) {		
			var list = ComXml2ListMap(arrXml[3]);
			if (list.length > 0) {
				var officeHierarchyVO  = list[0];
				var level1   = officeHierarchyVO["level1"];
				var level2   = officeHierarchyVO["level2"];
				var level3   = officeHierarchyVO["level3"];
				var level4   = officeHierarchyVO["level4"];
				var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
				
				if ("N" == rgnOfcFlg) {
					frm2.fm_sls_ofc_div_cd[0].checked = true;
				} else {
					frm2.fm_sls_ofc_div_cd[1].checked = true;
				}
				
				ComSetObjValue(frm2.fm_ofc_lvl1,level2);
				
				//LV2			
				frm2.fm_ofc_lvl2.length = 0;
				ComAddComboItem(frm2.fm_ofc_lvl2, level3, level3);
				
				//LV3					
				frm2.fm_ofc_lvl3.length = 0;
				ComAddComboItem(frm2.fm_ofc_lvl3, level4, level4);
				
				//환율 CURR설정
				document.getElementById("ei_fm_locl_curr_cd").innerText = 
					officeHierarchyVO["locl_curr_cd"];
				frm2.fm_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
				frm2.fm_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
				frm2.fm_ad_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
				frm2.fm_ad_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
				
				
			}
			
			
		}

		
		//5.fm_expense info
		if (arrXml.length > 4) {		
			var list = ComXml2ListMap(arrXml[4]);
			if (list.length > 0) {
				var expnInfo  = list[0];
				
				frm2.fm_tic_cd.value = expnInfo["tic_cd"];
				frm2.fm_gen_expn_cd.value = expnInfo["gen_expn_cd"];
				frm2.fm_eng_abbr_nm.value = expnInfo["eng_abbr_nm"];
				frm2.fm_krn_abbr_nm.value = expnInfo["krn_abbr_nm"];
			    if (ComGetObjValue(frm.lang_div) == "KOR") {
			    	frm2.fm_gen_expn_cd_abbr_name.value = frm2.fm_krn_abbr_nm.value;
			    } else {
			    	frm2.fm_gen_expn_cd_abbr_name.value = frm2.fm_eng_abbr_nm.value;
			    }
			
			}
		}

		
		if (sheet5.CellValue(1,"ttl") > 0 ) {
			frm2.fm_chk_assigned.checked = true;
		} else {
			frm2.fm_chk_assigned.checked = false;
		}
		
		
		//USD금액
		frm2.fm_usd_amt.value = 
			ComAddComma(getUsdAmt(frm2.fm_rq_amt.value,frm2.fm_ut_val.value,frm2.fm_usd_locl_xch_rt.value));
		frm2.fm_ad_usd_amt.value = 
			ComAddComma(getUsdAmt(frm2.fm_ad_amt.value,frm2.fm_ad_ut_val.value,frm2.fm_ad_usd_locl_xch_rt.value));
		
		frm2.usd_ttl.value = frm2.fm_ad_usd_amt.value;
		
		frm2.ei_fm_assign_rule[0].checked = true	
		frm2.fm_monthFrom.disabled = true;
		frm2.fm_monthTo.disabled = true;
		frm2.fm_monthTo.value = "";
		
		if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "Y" ) {
			ComBtnDisable("btn_Save");
			frm2.fm_ad_amt.readOnly = true;
			frm2.fm_ad_amt.className = "noinput";
			frm2.fm_ad_amt.removeAttribute("required");
			frm2.ei_fm_assign_rule[0].disabled=true;
			frm2.ei_fm_assign_rule[1].disabled=true;
		} 	                                                                                                                                                                                                  
} 


/**                                                                                                                                                                                                                                                                                                  
* 시트 sheet1에데이타를 form,sheet2에 설정                                                                                                                                                                                                                                                          
* @param {long} srow 시트 행번호                                                                                                                                                                                                                                                                     
*/                                                                                                                                                                                                                                                                                                  
function setSheet1ToForm( srow ) {   
	
	var pln_yrmon = frm.pln_yrmon.value;
	var init_clz_flg = frm.init_clz_flg.value;
	var pln_yr = pln_yrmon.substring(0,4);
	var pln_mon = pln_yrmon.substring(4,6);
	
	
	var queryString = getSheetRowQueryString(sheet1,srow);
	
	var param = "f_cmd=" + SEARCHLIST01;
	
	param +=  "&" + queryString;
	
	var sXml = sheet1.GetSearchXml("CPS_GEM_0001_03GS.do", param);		
	
	var arrXml = sXml.split("|$$|");
	
	var gen_expn_rqst_tp_cd = sheet1.CellValue(srow ,"gen_expn_rqst_tp_cd");
	
	
	if ("ET" == gen_expn_rqst_tp_cd) {
		frm1.gen_expn_rqst_tp_cd[1].checked = true;
	} else {		
		frm1.gen_expn_rqst_tp_cd[0].checked = true;
	}
	
	//초기화 
	sheet2.RemoveAll();	
	sheet3.RemoveAll();	
	sheet4.RemoveAll();
	
	//1. request
	if (arrXml.length > 0) {		
		var list = ComXml2ListMap(arrXml[0]);
		var request  = list[0];			
		
		frm1.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
		var pln_yrmon = request["pln_yrmon"];
		frm1.pln_yr.value = pln_yrmon.substring(0,4);
		
		
		if (gen_expn_rqst_tp_cd != "EI") {
			frm1.pln_mon.value = pln_yrmon.substring(4,6);
		}
		
		frm1.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
		frm1.cre_usr_id.value = request["cre_usr_id"];
		
	}	
	
	//2. fm_item
	if (arrXml.length > 1) {		
		var list = ComXml2ListMap(arrXml[1]);
		var item  = list[0];
		var row = sheet2.DataInsert(-1);
		sheet2.CellValue2(row, "title") = "Assigned";
	 	sheet2.CellValue2(row ,"jan_amt") = item["jan_amt"];
	 	sheet2.CellValue2(row ,"feb_amt") = item["feb_amt"];
	 	sheet2.CellValue2(row ,"mar_amt") = item["mar_amt"];
	 	sheet2.CellValue2(row ,"apr_amt") = item["apr_amt"];
	 	sheet2.CellValue2(row ,"may_amt") = item["may_amt"];
	 	sheet2.CellValue2(row ,"jun_amt") = item["jun_amt"];
	 	sheet2.CellValue2(row ,"jul_amt") = item["jul_amt"];
	 	sheet2.CellValue2(row ,"aug_amt") = item["aug_amt"];
	 	sheet2.CellValue2(row ,"sep_amt") = item["sep_amt"];
	 	sheet2.CellValue2(row ,"oct_amt") = item["oct_amt"];
	 	sheet2.CellValue2(row ,"nov_amt") = item["nov_amt"];
	 	sheet2.CellValue2(row ,"dec_amt") = item["dec_amt"];	
	 	frm1.fm_gen_expn_itm_desc.value = item["gen_expn_itm_desc"];
	 	frm1.fm_gen_expn_itm_no.value = item["gen_expn_itm_no"];
	 	
	}
	
	//3. to_item
	if (arrXml.length > 2) {		
		var list = ComXml2ListMap(arrXml[2]);
		var item  = list[0];
		var row = sheet3.DataInsert(-1);
		sheet3.CellValue2(row, "title") = "Assigned";
	 	sheet3.CellValue2(row ,"jan_amt") = item["jan_amt"];
	 	sheet3.CellValue2(row ,"feb_amt") = item["feb_amt"];
	 	sheet3.CellValue2(row ,"mar_amt") = item["mar_amt"];
	 	sheet3.CellValue2(row ,"apr_amt") = item["apr_amt"];
	 	sheet3.CellValue2(row ,"may_amt") = item["may_amt"];
	 	sheet3.CellValue2(row ,"jun_amt") = item["jun_amt"];
	 	sheet3.CellValue2(row ,"jul_amt") = item["jul_amt"];
	 	sheet3.CellValue2(row ,"aug_amt") = item["aug_amt"];
	 	sheet3.CellValue2(row ,"sep_amt") = item["sep_amt"];
	 	sheet3.CellValue2(row ,"oct_amt") = item["oct_amt"];
	 	sheet3.CellValue2(row ,"nov_amt") = item["nov_amt"];
	 	sheet3.CellValue2(row ,"dec_amt") = item["dec_amt"];	 
	 	frm1.to_gen_expn_calc_bss_desc.value = item["gen_expn_calc_bss_desc"];
	 	frm1.to_rqst_opin_rmk.value = item["rqst_opin_rmk"];
	 	frm1.to_gen_expn_itm_desc.value = item["gen_expn_itm_desc"];
	 	frm1.to_gen_expn_itm_no.value = item["gen_expn_itm_no"];
	}
	
	//4. fm_aproStep
	if (arrXml.length > 3) {		
		var list = ComXml2ListMap(arrXml[3]);


		for ( var i = 0; i < list.length; i++) {
			sheet2.DataInsert(-1);
			sheet4.DataInsert(-1);
		}

		//Editable Cell ===========================
		var janCol = sheet2.SaveNameCol("jan_amt");
		var decCol = sheet2.SaveNameCol("dec_amt");
		

		
		var rjCol = sheet4.SaveNameCol("crnt_gen_expn_apsts_cd_rj");
		var aproCol = sheet4.SaveNameCol("apro_opin_rmk");
		

		var editRow = 0;
		
		for ( var i = 0; i < list.length; i++) {
			var aproStep  = list[i];
			var row = i + 2;
			var step = aproStep["gen_expn_apro_step_cd"];
			
			
			
			sheet2.CellValue2(row, "title") = getStepOffice(step);			
		 	sheet2.CellValue2(row ,"jan_amt") = aproStep["jan_amt"];
		 	sheet2.CellValue2(row ,"feb_amt") = aproStep["feb_amt"];
		 	sheet2.CellValue2(row ,"mar_amt") = aproStep["mar_amt"];
		 	sheet2.CellValue2(row ,"apr_amt") = aproStep["apr_amt"];
		 	sheet2.CellValue2(row ,"may_amt") = aproStep["may_amt"];
		 	sheet2.CellValue2(row ,"jun_amt") = aproStep["jun_amt"];
		 	sheet2.CellValue2(row ,"jul_amt") = aproStep["jul_amt"];
		 	sheet2.CellValue2(row ,"aug_amt") = aproStep["aug_amt"];
		 	sheet2.CellValue2(row ,"sep_amt") = aproStep["sep_amt"];
		 	sheet2.CellValue2(row ,"oct_amt") = aproStep["oct_amt"];
		 	sheet2.CellValue2(row ,"nov_amt") = aproStep["nov_amt"];
		 	sheet2.CellValue2(row ,"dec_amt") = aproStep["dec_amt"];	
		 	
		 	// --------------------------------------------
		 	//  Approval 
   		    // --------------------------------------------
		 	
		 	var gen_expn_apsts_cd = aproStep["gen_expn_apsts_cd"];
		 	
		 	//RQ 이면 CELL Editale
			if (gen_expn_apsts_cd == "RQ" || gen_expn_apsts_cd == "AD") {
				if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "N" ) {
					for ( var j = janCol ; j <= decCol; j++) {		
						sheet2.CellEditable(row,j) = true;
					}
				} else if (gen_expn_rqst_tp_cd == "EA" || gen_expn_rqst_tp_cd == "ET"){
					var start = janCol + parseInt(pln_mon , 10) - 1;
					for ( var j = start ; j <= decCol; j++) {		
						sheet2.CellEditable(row,j) = true;
					}			
				}		
				editRow = row;
			}		 	
		 	
		 	//저장ROW
		 	sheet2.CellValue2(row ,"gen_expn_apsts_cd") = gen_expn_apsts_cd;
		 	sheet2.CellValue2(row ,"gen_expn_apro_step_cd") = step;
		 	
			//RQ 이면 CELL Editale
		 	if (gen_expn_apsts_cd == "RQ" || gen_expn_apsts_cd == "AD") {						
				sheet4.CellEditable(row,"crnt_gen_expn_apsts_cd_rj") = true;
				sheet4.CellEditable(row,"crnt_gen_expn_apsts_cd_ap") = true;
				sheet4.CellEditable(row,"apro_opin_rmk") = true;
				
		 	}
		 	if (gen_expn_apsts_cd == "AP") {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 1;	
		 	} else if (gen_expn_apsts_cd == "RJ") {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 1;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 0;
		 	} else {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 0;			 		
		 	}
		 	
		 	
		 	sheet4.CellValue(row, "title") = getStepOffice(step);
		 	sheet4.CellValue(row ,"apro_opin_rmk") = aproStep["apro_opin_rmk"];
		 	sheet4.CellValue(row ,"gen_expn_apsts_cd") = gen_expn_apsts_cd;
		 	sheet4.CellValue(row ,"gen_expn_apro_step_cd") = step;
		 	
		 	if ( gen_expn_apsts_cd == "AP" || gen_expn_apsts_cd == "RJ" ) {				
			 	sheet4.CellValue(row ,"upd_usr_id") = aproStep["upd_usr_id"];
			 	sheet4.CellValue(row ,"upd_dt") = aproStep["upd_dt"];			 	
		 	}
		}
		//마지막 Step의 이전 월의 금액은 0 으로 설정		
		if (gen_expn_rqst_tp_cd != "EI") {
						
			var start = janCol + parseInt(pln_mon , 10) - 2 ;
			
			for ( var i = janCol ; i <= start; i++) {		
				sheet2.CellValue2(editRow,i) = 0;
			}		
			
		} 
		
		frm1.fm_rq_amt.value = sheet2.CellText(2, "ttl");	
		frm1.fm_ad_amt.value = sheet2.CellText(editRow ,"ttl");

		
	}
	
	//5. to_aproStep		
	if (arrXml.length > 4) {		
		var list = ComXml2ListMap(arrXml[4]);
		
		for ( var i = 0; i < list.length; i++) {
			sheet3.DataInsert(-1);
		}
		
		//Edit ===========================
		var janCol = sheet3.SaveNameCol("jan_amt");
		var decCol = sheet3.SaveNameCol("dec_amt");
		
		var editRow = 0 ;
		
		for ( var i = 0; i < list.length; i++) {
			var aproStep  = list[i];
			
			var row = i + 2;
			var step = aproStep["gen_expn_apro_step_cd"];
			
			sheet3.CellValue2(row, "title") = getStepOffice(step);			
		 	sheet3.CellValue2(row ,"jan_amt") = aproStep["jan_amt"];
		 	sheet3.CellValue2(row ,"feb_amt") = aproStep["feb_amt"];
		 	sheet3.CellValue2(row ,"mar_amt") = aproStep["mar_amt"];
		 	sheet3.CellValue2(row ,"apr_amt") = aproStep["apr_amt"];
		 	sheet3.CellValue2(row ,"may_amt") = aproStep["may_amt"];
		 	sheet3.CellValue2(row ,"jun_amt") = aproStep["jun_amt"];
		 	sheet3.CellValue2(row ,"jul_amt") = aproStep["jul_amt"];
		 	sheet3.CellValue2(row ,"aug_amt") = aproStep["aug_amt"];
		 	sheet3.CellValue2(row ,"sep_amt") = aproStep["sep_amt"];
		 	sheet3.CellValue2(row ,"oct_amt") = aproStep["oct_amt"];
		 	sheet3.CellValue2(row ,"nov_amt") = aproStep["nov_amt"];
		 	sheet3.CellValue2(row ,"dec_amt") = aproStep["dec_amt"];	
		 	
		 	var gen_expn_apsts_cd = aproStep["gen_expn_apsts_cd"];
		 	//RQ 이면 CELL Editale
			if (gen_expn_apsts_cd == "RQ" || gen_expn_apsts_cd == "AD") {
				if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "N" ) {
					for ( var j = janCol ; j <= decCol; j++) {		
						sheet3.CellEditable(row,j) = true;
					}
				} else if (gen_expn_rqst_tp_cd == "EA" || gen_expn_rqst_tp_cd == "ET"){
					var start = janCol + parseInt(pln_mon , 10) - 1;
					for ( var j = start ; j <= decCol; j++) {		
						sheet3.CellEditable(row,j) = true;
					}		
					editRow = row;
				}		
			}
		 	
		 	//저장ROW
		 	sheet3.CellValue2(row ,"gen_expn_apsts_cd") = gen_expn_apsts_cd;
		 	sheet3.CellValue2(row ,"gen_expn_apro_step_cd") = step;
		}
		
		//frm1.to_ad_amt.value = sheet3.CellText(editRow ,"ttl"); 

		//마지막 Step의 이전 월의 금액은 0 으로 설정		
		if (gen_expn_rqst_tp_cd != "EI") {		
			var start = janCol + parseInt(pln_mon , 10) - 2 ;
			
			for ( var i = janCol ; i <= start; i++) {		
				sheet3.CellValue2(editRow,i) = 0;
			}		
			
		} 
		frm1.to_rq_amt.value = sheet3.CellText(2, "ttl");
		//frm1.to_ad_amt.value = sheet3.CellText(editRow ,"ttl");
		
	}
	
	//6.fm_ofc level
	if (arrXml.length > 5) {		
		var list = ComXml2ListMap(arrXml[5]);
		if (list.length > 0) {
			var officeHierarchyVO  = list[0];
			var level1   = officeHierarchyVO["level1"];
			var level2   = officeHierarchyVO["level2"];
			var level3   = officeHierarchyVO["level3"];
			var level4   = officeHierarchyVO["level4"];
			var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
			
			if ("N" == rgnOfcFlg) {
				frm1.fm_sls_ofc_div_cd[0].checked = true;
			} else {
				frm1.fm_sls_ofc_div_cd[1].checked = true;
			}
			
			ComSetObjValue(frm1.fm_ofc_lvl1,level2);
			
			//LV2			
			frm1.fm_ofc_lvl2.length = 0;
			ComAddComboItem(frm1.fm_ofc_lvl2, level3, level3);
			
			//LV3					
			frm1.fm_ofc_lvl3.length = 0;
			ComAddComboItem(frm1.fm_ofc_lvl3, level4, level4);
			
			//환율 CURR설정
			document.getElementById("fm_locl_curr_cd").innerText = 
				officeHierarchyVO["locl_curr_cd"];
			frm1.fm_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
			frm1.fm_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
			frm1.fm_ad_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
			frm1.fm_ad_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
			
		}
		
		
	}

	//7.to_ofc level
	if (arrXml.length > 6) {		
		var list = ComXml2ListMap(arrXml[6]);
		if (list.length > 0) {
			var officeHierarchyVO  = list[0];
			var level1   = officeHierarchyVO["level1"];
			var level2   = officeHierarchyVO["level2"];
			var level3   = officeHierarchyVO["level3"];
			var level4   = officeHierarchyVO["level4"];
			var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
			
			if ("N" == rgnOfcFlg) {
				frm1.to_sls_ofc_div_cd[0].checked = true;
			} else {
				frm1.to_sls_ofc_div_cd[1].checked = true;
			}
			
			ComSetObjValue(frm1.to_ofc_lvl1,level2);
			
			//LV2			
			frm1.to_ofc_lvl2.length = 0;
			ComAddComboItem(frm1.to_ofc_lvl2, level3, level3);
			
			//LV3					
			frm1.to_ofc_lvl3.length = 0;
			ComAddComboItem(frm1.to_ofc_lvl3, level4, level4);
			
			//환율 CURR설정
			document.getElementById("to_locl_curr_cd").innerText = 
				officeHierarchyVO["locl_curr_cd"];
			frm1.to_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
			frm1.to_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
			frm1.to_ad_ut_val.value = ComAddComma(officeHierarchyVO["rqst_ut_val"]);
			frm1.to_ad_usd_locl_xch_rt.value = ComAddComma(officeHierarchyVO["usd_locl_xch_rt"]);
			
		}
		
		
	}
	
	//8.fm_expense info
	if (arrXml.length > 7) {		
		var list = ComXml2ListMap(arrXml[7]);
		if (list.length > 0) {
			var expnInfo  = list[0];
			frm1.fm_tic_cd.value = expnInfo["tic_cd"];
			frm1.fm_gen_expn_cd.value = expnInfo["gen_expn_cd"];
			frm1.fm_eng_abbr_nm.value = expnInfo["eng_abbr_nm"];
			frm1.fm_krn_abbr_nm.value = expnInfo["krn_abbr_nm"];
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm1.fm_gen_expn_cd_abbr_name.value = frm1.fm_krn_abbr_nm.value;
		    } else {
		    	frm1.fm_gen_expn_cd_abbr_name.value = frm1.fm_eng_abbr_nm.value;
		    }			
		
		}
	}

	//9.to_expense info
	if (arrXml.length > 8) {
		
		var list = ComXml2ListMap(arrXml[8]);
		if (list.length > 0) {
			var expnInfo  = list[0];
			frm1.to_tic_cd.value = expnInfo["tic_cd"];
			frm1.to_gen_expn_cd.value = expnInfo["gen_expn_cd"];
			frm1.to_eng_abbr_nm.value = expnInfo["eng_abbr_nm"];		
			frm1.to_krn_abbr_nm.value = expnInfo["krn_abbr_nm"];
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm1.to_gen_expn_cd_abbr_name.value = frm1.to_krn_abbr_nm.value;
		    } else {
		    	frm1.to_gen_expn_cd_abbr_name.value = frm1.to_eng_abbr_nm.value;
		    }	
		}
	}
	        
	if (frm1.fm_ofc_lvl3.value == frm1.to_ofc_lvl3.value) {		
		frm1.same_ofc_cd.checked = true;		
	} else {
		frm1.same_ofc_cd.checked = false;
	}
	
	if (frm1.fm_gen_expn_cd.value == frm1.to_gen_expn_cd.value) {		
		frm1.same_expn_cd.checked = true;		
	} else {
		frm1.same_expn_cd.checked = false;
	}
	
	
	if (sheet2.CellValue(1,"ttl") > 0 ) {
		frm1.fm_chk_assigned.checked = true;
	} else {
		frm1.fm_chk_assigned.checked = false;
	}
	
	if (sheet3.CellValue(1,"ttl") > 0 ) {
		frm1.to_chk_assigned.checked = true;
	} else {
		frm1.to_chk_assigned.checked = false;
	}

	//USD 금액 설정
	frm1.fm_usd_amt.value = 
		ComAddComma(getUsdAmt(frm1.fm_rq_amt.value,frm1.fm_ut_val.value,frm1.fm_usd_locl_xch_rt.value));
	/* 2010.09.14 이준범 
	 * toLclAmt , toUsdAmt 는 모두  fmLclAmt 기준으로 생성한다.
	frm1.to_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.to_rq_amt.value,frm1.to_ut_val.value,frm1.to_usd_locl_xch_rt.value));
    */
	frm1.to_usd_amt.value = ComAddComma(Math.abs(removeComma(frm1.fm_usd_amt.value)));

	frm1.fm_ad_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.fm_ad_amt.value,frm1.fm_ad_ut_val.value,frm1.fm_ad_usd_locl_xch_rt.value));
	/*
	frm1.to_ad_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.to_ad_amt.value,frm1.to_ad_ut_val.value,frm1.to_ad_usd_locl_xch_rt.value));
	*/
	frm1.usd_ttl.value = frm1.fm_ad_usd_amt.value;
	
	frm1.fm_assign_rule.checked = false;
	frm1.fm_assign_rule.checked = false;
	frm1.to_assign_rule.checked = false;
	frm1.fm_monthFrom.disabled = true;
	frm1.fm_monthTo.disabled = true;
	frm1.fm_monthTo.value = "";
	frm1.to_monthFrom.disabled = true;
	frm1.to_monthTo.disabled = true;
	frm1.to_monthTo.value = "";

	if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "Y" ) {
		ComBtnDisable("btn_Save");
		frm2.fm_ad_amt.readOnly = true;
		frm2.fm_ad_amt.className = "noinput";
		frm2.fm_ad_amt.removeAttribute("required");
		frm2.ei_fm_assign_rule[0].disabled=true;
		frm2.ei_fm_assign_rule[1].disabled=true;
	} 	

	
}

/**                                                                                                                                                                                                                                                                                                  
* Step별 오피스명 취득 
* @param {string} step approve step RQ,HQ,TC,CO
* @return Step별 오피스명                                                                                                                                                                                                                                                                     
*/   
function getStepOffice(step) {
	if (step == "RQ") {
		return "Request";
	} else if (step == "HQ") {
		return "RHQ|BU";
	} else if (step == "TC") {
		return "TIC";
	} else if (step == "CO") {
		return "Committee";
	}
}


/**                                                                                                                                                                                                                                                                                                  
* 폼 초기화                                                                                                                                                                                                                                                                      
*/                                                                                                                                                                                                                                                                                                      
function resetForm() {                             
		                                                                                                                                                                                                                                       
}                                                                                                                                                                                                                                                                                                    


/**                                                                                                                                                                                                                                                                                                  
* 총 USD금액 구하기                                                                                                                                                                                                                                                                      
*/      
function getUsdTotal() {	
	var cnt = sheet1.RowCount;
	
	var usdTotal = 0.000;
	for(var i = 0 ; i < cnt ; i++ ) {
		var row = i  + 2;
		if (sheet1.RowStatus(row) == "D") {
			continue;
		}
		
		var rqst_usd_amt = sheet1.CellValue(row,"fm_rqst_usd_amt");
		if (!ComIsNull(rqst_usd_amt)) {		
			usdTotal =  usdTotal + parseFloat(ComTrimAll(rqst_usd_amt, ","));
		}
	}
	
	return usdTotal;
}



/**
 * ET LOC금액을  USD 금액으로 환산  계산
 **/
function setUsdAmt1() {
	 
	//로컬금액
	var locl_amt = frm1.fm_ad_amt.value;	
	//USD
	var usd_locl_xch_rt = frm1.fm_ad_usd_locl_xch_rt.value;	
	//단위
	var ut_val = frm1.fm_ad_ut_val.value;
	
	frm1.fm_ad_usd_amt.value = 
		ComAddComma(getUsdAmt(locl_amt , ut_val ,usd_locl_xch_rt ));		
	
	frm1.to_ad_usd_amt.value = 
		ComAddComma(Math.abs(removeComma(frm1.fm_ad_usd_amt.value)));
	
	frm1.usd_ttl.value =  frm1.fm_ad_usd_amt.value;	
	
	var fm_locl_curr_cd =
		document.getElementById("fm_locl_curr_cd").innerText ;

	var to_locl_curr_cd =
		document.getElementById("to_locl_curr_cd").innerText ;
	
	if (fm_locl_curr_cd == to_locl_curr_cd) {
		locl_amt = removeComma(locl_amt);
		frm1.to_ad_amt.value = ComAddComma(Math.abs(locl_amt));
	} else {
		//TO USD
		var usdAmt = frm1.fm_ad_usd_amt.value;
		//TO RATE
		var toRate = frm1.to_ad_usd_locl_xch_rt.value;
		//TO 단위
		var toUnit = frm1.to_ad_ut_val.value;		
		//KRW금액 계산 (USD / (UNIT*RATE)
		frm1.to_ad_amt.value = 
			ComAddComma(Math.abs(getLclAmt( usdAmt ,toUnit ,toRate )));		
		
		
	}

}

/**
* EA,EI LOC금액을  USD 금액으로 환산  계산
**/
function setUsdAmt2() {	 
	//로컬금액
	var locl_amt = frm2.fm_ad_amt.value;	
	//USD
	var usd_locl_xch_rt = frm2.fm_ad_usd_locl_xch_rt.value;	
	//단위
	var ut_val = frm2.fm_ad_ut_val.value;	
	
	
	frm2.fm_ad_usd_amt.value = 
		ComAddComma(getUsdAmt(locl_amt , ut_val ,usd_locl_xch_rt ));
	
	
	//USD TTL
	frm2.usd_ttl.value = frm2.fm_ad_usd_amt.value;
	
	
	
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
*/
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	
	case "t3_btn2_Retrieve":
		doActionIBSheet(SEARCHLIST);		
		break;
	case "t3_btn2_New":
		//Do you want to initialize?
	    if (ComShowCodeConfirm("GEM00015")) {
	    	/*
			frm.reset();
			combo1.Code = "";
			sheet1.RemoveAll();
			//폼숨김
			hideAllForm();	   
		    frm.rownum.value = "";		
			//OPEN화면 호출
		    doActionIBSheet(INIT);
		    */
			location.reload();
			top.document.body.scrollTop = 0;
	    }
		break;
	case "t3_btn2_Down_Excel":
		if (sheet1.RowCount > 0 ) {
			var columnSkipList = "ibflag|to_gen_expn_itm_no|to_gen_expn_itm_desc|cre_usr_id|fm_ut_val|to_ut_val|fm_usd_locl_xch_rt|fm_locl_krw_xch_rt|fm_ut_val|fm_usd_krw_xch_rt|to_usd_locl_xch_rt|to_locl_krw_xch_rt|to_usd_krw_xch_rt|gen_expn_rqst_tp_cd|gen_expn_apro_auth_ofc_cd|crnt_gen_expn_apro_step_cd|crnt_gen_expn_apsts_cd|gen_expn_rqst_seq|fm_eng_abbr_nm|to_eng_abbr_nm|fm_krn_abbr_nm|to_krn_abbr_nm|rqst_opin_rmk";
			sheet1.Down2Excel(1,false,false,true,"","",false,false,"Approval of Requested expense",false,columnSkipList);
		}
		break;	
	case "t3_btn2_Save":		
		//GEM00012(Do you want to save changes?)
		if (ComShowCodeConfirm("GEM00012")) {
			if (doActionIBSheet(MULTI02)) {
				top.document.body.scrollTop = 0;				
				doActionIBSheet(SEARCHLIST);
				//ET , EA 인경우만
				if (frm.gen_expn_rqst_tp_cd[0].checked) {
					showGroupMail();
				}
			}
		}		
		break;		
	case "btn_Retrieve":
		doActionIBSheet(SEARCHLIST);
		break;	
	case "btn_New":
		//Do you want to initialize?
		if (ComShowCodeConfirm("GEM00011")) {
			/*
			frm.reset();
			combo1.Code = "";			
			//폼숨김
			hideAllForm();
		    frm.rownum.value = "";
			//OPEN화면 호출
		    doActionIBSheet(INIT);
		    */			
			location.reload();
			top.document.body.scrollTop = 0;
		}
		break;
	case "btn_Delete":
		doActionIBSheet(REMOVE);
		break;
	case "btn_Save":
		//GEM00012(Do you want to save changes?)
		if (ComShowCodeConfirm("GEM00012")) {
			
			
			// <2009-10-12>
			// 다른사용자 변경여부 체크 및 request no 존재여부 체크
			var row = frm.rownum.value;
			
			var gen_expn_rqst_no = sheet1.CellValue(row , "gen_expn_rqst_no");
			
			if (!ComIsNull(gen_expn_rqst_no)) {
				
				var checkData = checkChangedData();
				//msgs["GEM01088"] = "The request no doesn't exist.";
				//msgs["GEM01089"] = "Data is changed by other's user";
				if (checkData == "1") {
					ComShowCodeMessage("GEM01089");
					doActionIBSheet(SEARCHLIST);
					return;		
				} else if (checkData == "3") {
					ComShowCodeMessage("GEM01088");					
					return;
				}
				
			}			
			// </2009-10-12> 				
			
			
			if (doActionIBSheet(MULTI)) {	
				top.document.body.scrollTop = 0;
				doActionIBSheet(SEARCHLIST);	
				//ET , EA 인경우만
				if (frm.gen_expn_rqst_tp_cd[0].checked) {
					showGroupMail();
				}
				
			}
		}	
		break;
	case "btn_Print":
		var row = frm.rownum.value;		
		var gen_expn_rqst_tp_cd = sheet1.CellValue(row ,"gen_expn_rqst_tp_cd");		
		var gen_expn_rqst_no =  sheet1.CellValue(row ,"gen_expn_rqst_no");
		var gen_expn_rqst_seq = sheet1.CellValue(row ,"gen_expn_rqst_seq");
		
		var url = "CPS_GEM_0103.do";		
		var winName = "CPS_GEM_0103";
		repWin = openWinCenter("about:blank",winName,700,410);
	    var frm5 = document.form5;
	    var langDiv = ComGetObjValue(frm.lang_div);
	    
		if (gen_expn_rqst_tp_cd == "EI") {
		    frm5.rfn.value = "/CPS_GEM_0025.do?lang_div="+langDiv+"&gen_expn_rqst_seq="+gen_expn_rqst_seq+"&gen_expn_rqst_no="+gen_expn_rqst_no+"&pln_yrmon="+frm.pln_yrmon.value+"&f_cmd="+SEARCHLIST03;	    
		    frm5.mrd.value = "apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/report/CPS_GEM_0025.mrd";
		    frm5.rv.value = "title[Expense Report - Initial]";		    
		    frm5.title.value = "Expense Report - Initial";
		} else if (gen_expn_rqst_tp_cd == "EA") {
		    frm5.rfn.value = "/CPS_GEM_0025.do?lang_div="+langDiv+"&gen_expn_rqst_seq="+gen_expn_rqst_seq+"&gen_expn_rqst_no="+gen_expn_rqst_no+"&pln_yrmon="+frm.pln_yrmon.value+"&f_cmd="+SEARCHLIST03;	    
		    frm5.mrd.value = "apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/report/CPS_GEM_0025.mrd";
		    frm5.rv.value = "title[Expense Report - Additional]";		    
		    frm5.title.value = "Expense Report - Additional";
		} else if (gen_expn_rqst_tp_cd == "ET") {
		    frm5.rfn.value = "/CPS_GEM_0027.do?lang_div="+langDiv+"&gen_expn_rqst_seq="+gen_expn_rqst_seq+"&gen_expn_rqst_no="+gen_expn_rqst_no+"&pln_yrmon="+frm.pln_yrmon.value+"&f_cmd="+SEARCHLIST04;	    
		    frm5.mrd.value = "apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/report/CPS_GEM_0027.mrd";
		    frm5.rv.value = "title[Expense Report - Transfer]";		    
		    frm5.title.value = "Expense Report - Transfer";						
		}

	    frm5.action = url;
	    frm5.target = winName;
	    frm5.submit();
	    frm5.target = "";
	    repWin.focus();		
		break;
	//Request popup
	case "btns_popup":		
		var url = "CPS_GEM_0105.do";
		var winName = "CPS_GEM_0105";
		if (reqWin != null) {
			reqWin.close();
		}
		reqWin = ComOpenWindowCenter("about:blank",winName,700,430, false);
	    var form3 = document.form3;
	    form3.pln_yrmon.value = frm.pln_yrmon.value.substring(0,4);
	    form3.prg_id.value = "0003";
	    form3.rqst_ofc_cd.value = frm.ofc_lvl3.value;
	    var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);
	    if (gen_expn_rqst_tp_cd == "EA") {
	    	gen_expn_rqst_tp_cd = "EA,ET";
	    }
	    form3.auth_flg.value = frm.auth_flg.value;
	    form3.gen_expn_rqst_tp_cd.value = gen_expn_rqst_tp_cd ;
	    form3.action = url;        
	    form3.target = winName;
	    form3.submit();
	    form3.target = "";	    		
	    break;			
	// 수동, 자동 배정
	case "ei_fm_assign_rule":
		if (frm2.ei_fm_assign_rule[1].checked) {
			frm2.fm_monthFrom.disabled = false;
			frm2.fm_monthTo.disabled = false;
		} else {
			frm2.fm_monthFrom.disabled = true;
			frm2.fm_monthTo.disabled = true;
		}
		break;		
	// 수동, 자동 배정
	case "fm_assign_rule":
		
		if (frm1.fm_assign_rule.checked) {
			frm1.fm_monthFrom.disabled = false;
			frm1.fm_monthTo.disabled = false;
		} else {
			frm1.fm_monthFrom.disabled = true;
			frm1.fm_monthTo.disabled = true;
		}
		break;		
	case "to_assign_rule":
		if (frm1.to_assign_rule.checked) {
			frm1.to_monthFrom.disabled = false;
			frm1.to_monthTo.disabled = false;
		} else {
			frm1.to_monthFrom.disabled = true;
			frm1.to_monthTo.disabled = true;
		}
		break;
	//Performance Inquiry
	case "btns_perf_search":
		
		if (sheet1.SelectRow > 1) {		
			if (frm.gen_expn_rqst_tp_cd[0].checked) {		
				openPerformance(sheet1);		
			} else {
				openYearlyExpense();		
			}	
		}
		
		break;		
	case "sum_up":		
		if (frm.sum_up[2].checked && frm.curr_cd[0].checked) {			
			//msgs["GEM01079"] = "You should change CUR (USD or KRW)";
			ComShowCodeMessage("GEM01079");
			frm.curr_cd[1].checked = true;
		}
		
		break;	
	case "curr_cd":		
		if (frm.sum_up[2].checked && frm.curr_cd[0].checked) {			
			//msgs["GEM01079"] = "You should change CUR (USD or KRW)";
			ComShowCodeMessage("GEM01079");
			frm.curr_cd[1].checked = true;
		}
		break;
	case "ofc_expn_div":				
		frm.ofc_expn_cd.value = "";
		break;		
	case "lang_div":				
		setExpnGroupList();
		break;		
	case "chk_commit":
		
		if ( frm.chk_commit.checked ) {
			frm.usr_tic_cd.value = "";
			frm.auth_flg.value = "YNYY"; 
		} else {
			frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
			frm.auth_flg.value = "YNYN";
		}
		
		break;		
		
	}
		
}


/**                                                                                                                                                                                                                                                                                                  
* 총금액 자동 배정                                                                                                                                                                                                                                                                      
*/         
function onChangeFmMonthTo() {
	
	tab2.SelectedIndex = 0;
	
	if (ComIsNull(frm1.fm_ad_amt.value) || frm1.fm_ad_amt.value == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm1.fm_ad_amt.focus();
		return;
	}
	
	//Assignment Rule		
	if (frm1.fm_assign_rule.checked ) {
		var monthFrom = frm1.fm_monthFrom.value;
		var monthTo = frm1.fm_monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , "TO");
			frm1.fm_monthFrom.focus();
			return;		
		}
		
		monthFrom = parseInt(frm1.fm_monthFrom.value , 10);
		monthTo = parseInt(frm1.fm_monthTo.value , 10);
		
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(frm1.fm_ad_amt.value, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")
		
		var row = getEditableRow(sheet2);
		
		//초기화 
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet2.CellValue2(row,i) = 0;
		}
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet2.CellValue2(row,i) = avg;
			total += avg;
		}
		
		//나머지 금액 은 첫번째 컬럼에 입력
		if (total < locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet2.CellValue2(row, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet2.CellValue2(row, start) = (avg - diffAmt);
		}
		
	}
	
}


/**                                                                                                                                                                                                                                                                                                  
* 총금액 자동 배정                                                                                                                                                                                                                                                                      
*/         
function onChangeFmMonthTo2() {
	
	if (ComIsNull(frm2.fm_ad_amt.value) || frm2.fm_ad_amt.value == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm2.fm_ad_amt.focus();
		return;
	}
	
	//Assignment Rule		
	if (frm2.ei_fm_assign_rule[1].checked ) {
		var monthFrom = frm2.fm_monthFrom.value;
		var monthTo = frm2.fm_monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , "TO");
			frm2.fm_monthFrom.focus();
			return;		
		}
		
		monthFrom = parseInt(frm2.fm_monthFrom.value , 10);
		monthTo = parseInt(frm2.fm_monthTo.value , 10);
		
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(frm2.fm_ad_amt.value, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")
		
		var row = getEditableRow(sheet5);
		
		//초기화 
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet5.CellValue2(row,i) = 0;
		}
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet5.CellValue2(row,i) = avg;
			total += avg;
		}
		
		//나머지 금액 은 첫번째 컬럼에 입력
		if (total < locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet5.CellValue2(row, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet5.CellValue2(row, start) = (avg - diffAmt);
		}
		
	}
	
}

/**                                                                                                                                                                                                                                                                                                  
* 편집가능 row 찾기 RQ인것만...                                                                                                                                                                                                                                                                      
*/
function getEditableRow(sheet) {	
	
	for ( var i = 0; i < sheet.RowCount; i++) {
		var row = i + 2;
		var gen_expn_apsts_cd = sheet.CellValue(row ,"gen_expn_apsts_cd");
		if (gen_expn_apsts_cd == "RQ" || gen_expn_apsts_cd == "AD") {
			return row;
		}
	}
	
	return sheet.LastRow;
}

/**                                                                                                                                                                                                                                                                                                  
* 총금액 자동 배정                                                                                                                                                                                                                                                                      
*/         
function onChangeToMonthTo() {
	
	
	tab2.SelectedIndex = 1;
	
	if (ComIsNull(frm1.to_ad_amt.value) || frm1.to_ad_amt.value == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm1.fm_ad_amt.focus();
		return;
	}
	
	//Assignment Rule		
	if (frm1.to_assign_rule.checked ) {
		
		var monthFrom = frm1.to_monthFrom.value;
		var monthTo = frm1.to_monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , "TO");
			frm1.to_monthFrom.focus();
			return;		
		}
		
		
		monthFrom = parseInt(frm1.to_monthFrom.value , 10);
		monthTo = parseInt(frm1.to_monthTo.value, 10);
		
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(frm1.to_ad_amt.value, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet3.SaveNameCol("jan_amt")
		var decCol = sheet3.SaveNameCol("dec_amt")
		
		var row = getEditableRow(sheet3);
		//초기화 
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet3.CellValue2(row,i) = 0;
		}
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet3.CellValue2(row,i) = avg;
			total += avg;
		}
		
		//나머지 금액 은 첫번째 컬럼에 입력
		if (total < locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet3.CellValue2(row, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet3.CellValue2(row, start) = (avg - diffAmt);
		}
		
	}
	
}

/**     
* EI, EA onchange시  
*/
function onChagneRqstTpCd() {
	
	var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);	
	
	initClosingDate(gen_expn_rqst_tp_cd);
	
	hideAllForm();
	
	sheet1.RemoveAll();
	
	frm.gen_expn_rqst_no.value = "";
	
	if (frm.gen_expn_rqst_tp_cd[0].checked) {		
		sheet1.ColHidden("crnt_gen_expn_apsts_cd_rj")  = true;		
	} else {
		sheet1.ColHidden("crnt_gen_expn_apsts_cd_rj")  = false;		
	}
	
	ComBtnEnable("btn_Save");
	ComBtnEnable("t3_btn2_Save");
	frm2.fm_ad_amt.readOnly = false;
	frm2.fm_ad_amt.className = "noinput1";
	frm2.fm_ad_amt.setAttribute("required","required")
	frm2.ei_fm_assign_rule[0].disabled=false;
	frm2.ei_fm_assign_rule[1].disabled=false;
}


/**
* 오피스 변경시 code 체크 
*/
function onChangeOfcLvl3(div) {

	
	if (div == "FM") {
		var ofcCd = frm.fm_ofc_lvl3.value;	
		
		if ( ComIsNull(ofcCd) ) {
			return;
		}
		
		var officeLevelVo = getCurrInfo(plnYear, ofcCd);
		
		var loclCurrCd  = officeLevelVo["locl_curr_cd"];
		var usdLoclXchRt   = officeLevelVo["usd_locl_xch_rt"];
		var rqstUtVal   = officeLevelVo["rqst_ut_val"];
		
		//환율, 통화 정보 설정			
		document.getElementById("fm_locl_curr_cd").innerText = loclCurrCd;
		//USD
		frm.fm_usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
		//단위
		frm.fm_rqst_ut_val.value = ComAddComma(rqstUtVal);
		
		//환율 계산
		var rqst_locl_amt = frm.fm_rqst_locl_amt;
		if (!ComIsNull(rqst_locl_amt.value)) {
			setUsdAmt();
		}
		
		
	} else if (div == "TO") {
		var ofcCd = frm.to_ofc_lvl3.value;
		
		if ( ComIsNull(ofcCd) ) {
			return;
		}
		
		var officeLevelVo = getCurrInfo(plnYear, ofcCd);
		
		var loclCurrCd  = officeLevelVo["locl_curr_cd"];
		var usdLoclXchRt   = officeLevelVo["usd_locl_xch_rt"];
		var rqstUtVal   = officeLevelVo["rqst_ut_val"];
		
		//환율, 통화 정보 설정			
		document.getElementById("to_locl_curr_cd").innerText = loclCurrCd;
		//USD
		frm.to_usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
		//단위
		frm.to_rqst_ut_val.value = ComAddComma(rqstUtVal);
		
		//환율 계산
		var rqst_locl_amt = frm.fm_rqst_locl_amt;
		if (!ComIsNull(rqst_locl_amt.value)) {
			setUsdAmt();
		}		
	}
	
}

/**
* 계산식,  요청의견 노트 표시
*/
function showNote(nId , type) {
 	
	var width = 600;
	var height = 370;
    
	var url = "CPS_GEM_0102.do";
	
	var winName = "CPS_GEM_0102";
	
	if (noteWin != null) {
		noteWin.close();
	}
	
	noteWin = ComOpenWindowCenter("about:blank",winName,width,height, false);
	
	var text = "";
	
	var form4 = document.form4;
	form4.saveYn.value = "N";
	
	if ( nId == "A" ) {
		text = frm1.fm_gen_expn_itm_desc.value; 
	} else if ( nId == "B" ) {
		text = frm1.to_gen_expn_itm_desc.value;
	} else if ( nId == "C" ) {
		text = frm1.to_gen_expn_calc_bss_desc.value;
	} else if ( nId == "D" ) {
		text = frm1.to_rqst_opin_rmk.value;
		//form4.saveYn.value = "Y";
	} else if ( nId == "E" ) {
		text = frm2.fm_gen_expn_itm_desc.value;
	} else if ( nId == "F" ) {
		text = frm2.fm_gen_expn_calc_bss_desc.value;
	} else if ( nId == "G" ) {
		text = frm2.fm_rqst_opin_rmk.value;
		form4.saveYn.value = "Y";
	}
	
	form4.text.value = text;
	form4.type.value = type;
	
	form4.action = url;        
	form4.target = winName;
	form4.submit();
	form4.target = "";	   	
	
	noteWin.focus();
	//노트 아이디 설정
	noteId =nId;

}

/**
* 그룹메일
*/
function showGroupMail() {
	var contents = "";
	contents += "TO : PLP / Eun-young Lee <br>";
	contents += "RE : Request for Approval <br>";
	contents += "----------------------------------------------------------------<br>";
	contents += "You can see the prcessing status for request on Processing Status<br><br>";
	contents += "○ RQST OFC:<br>";
	contents += "○ APPL OFC:<br>";
	contents += "○ RQST No.:<br>";
	contents += "○ Expense Code:<br>";
	contents += "○ Amount:<br>";
	contents += "○ Remark:<br><br>";
	contents += "B.RGDS/<br>";
	
	frm.gw_contents.value = contents;
	frm.gw_subject.value = "Request for Approval";
	ComOpenGroupwareMail(sheet1,frm);
}
/**
* Detail _ Yearly Expense (After/Before Closing)
*/
function openYearlyExpense() {
	var param = "popup=Y";
	var popYear = frm.pln_yrmon.value;
	popYear = popYear.substring(0,4);
	
    param +="&popYear=" + popYear;
    
    var langDiv = frm.lang_div.value;
    if (langDiv == "ENG") {
    	langDiv = "E";
    } else {
    	langDiv = "K";
    }    
    param +="&popLang=" + langDiv;
    
    var popBuCd =  "";
    
    if (frm.sls_ofc_div_cd[0].checked) {
    	popBuCd = "N";
    } else {
    	popBuCd = "Y";
    }
    
    	
    param +="&popBuCd=" + popBuCd;
    
    var row = sheet1.SelectRow;
    
    var popOfcCd = sheet1.CellValue(row ,"fm_ofc_cd");
    var popExpnCd = sheet1.CellValue(row ,"fm_gen_expn_cd");
    
    param +="&popOfcCd=" + popOfcCd;
    param +="&popExpnCd=" + popExpnCd;
    
   var url = "CPS_GEM_0019.do?"+param;
   var winName = "CPS_GEM_0019";
   
   var win = ComOpenWindowCenter(url,winName,1040,700, false);
   win.focus();     
   
}


/**
* 팝업에서 노트 정보 받음 받음
*/
function setNote(type , text) {
	if ( noteId == "D" ) {
		frm1.to_rqst_opin_rmk.value = text;			
	} else if ( noteId == "G" ) {
		frm2.fm_rqst_opin_rmk.value = text;
	}
}

/**
* Form 이벤트 등록
*/
function initControl() {
	
 //keypress
 axon_event.addListenerForm('keypress','frm_keypress',frm);
	 
 //keypress
 axon_event.addListenerForm('keypress','frm1_keypress',frm1);
 //keyup
 axon_event.addListenerForm('keyup','frm1_keyup',frm1);
 // focus out
 axon_event.addListenerFormat('blur','frm1_deactivate',frm1);    
 // focus in
 axon_event.addListenerFormat('focus','frm1_activate',frm1);
 
 //keypress
 axon_event.addListenerForm('keypress','frm2_keypress',frm2);
 //keyup
 axon_event.addListenerForm('keyup','frm2_keyup',frm2);
 // focus out
 axon_event.addListenerFormat('blur','frm2_deactivate',frm2);    
 // focus in
 axon_event.addListenerFormat('focus','frm2_activate',frm2);    
 
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function frm_keypress() {
	 
    switch (event.srcElement.name) {
    case "gen_expn_rqst_no":
		if (frm.gen_expn_rqst_no.value.length > 0 && event.keyCode == 13) {
			doActionIBSheet(SEARCHLIST);
		}   

		break;
    case "ofc_expn_cd":
  		if (frm.ofc_expn_div[0].checked) {
  			
  		} else if (frm.ofc_expn_div[1].checked) {
  			ComKeyOnlyNumber(event.srcElement);
  		} else {
  			event.returnValue = false;
  			break;
  		}
  		
 		if ( ( (frm.ofc_expn_div[0].checked && frm.ofc_expn_cd.value.length > 3) || 
 				( frm.ofc_expn_div[1].checked && frm.ofc_expn_cd.value.length == 6) )
 				&& event.keyCode == 13) {
 			doActionIBSheet(SEARCHLIST);
 		} 
 		
  		break; 		
		
	}
} 

/**
* HTML Control KeyPress 이벤트 호출
*/
function frm1_keypress() {
   switch (event.srcElement.name) {    
   case "fm_ad_amt":
   	ComKeyOnlyNumber(event.srcElement,"-");
		if (frm1.fm_ad_amt.value.length > 0 && event.keyCode == 13) {
			setUsdAmt1();
		}   

		break;
	}
}

/**
* HTML Control KeyPress 이벤트 호출
*/
function frm1_keyup() { 	
  switch (event.srcElement.name) {    
  case "fm_ad_amt":     
 	var num = event.srcElement.value;
 	if ( isNaN(num) ) {
 		return;
 	}	
 	var absNum = Math.abs(num);    	
		event.srcElement.value = ( absNum * -1); 
		break;
  
	}
}

/**
* HTML Control Focus out
**/
function frm1_deactivate() {
	switch (event.srcElement.name) {
	case "fm_ad_amt":		
		
		if (!ComChkObjValid(frm1.fm_ad_amt)) {
			return;
		}		

		if (Math.abs(ComTrimAll(frm1.fm_ad_amt.value,",")) > sheet2.CellValue(1,"ttl")) {
		    //msgs["GEM01050"] = "assigned 금액 보다 입력한 금액이 큽니다.";
		    ComShowCodeMessage("GEM01050");	
		    frm1.fm_ad_amt.value = "";
			frm1.to_ad_amt.value = 0;
			frm1.fm_ad_amt.focus();
			return;
		}
		
		setUsdAmt1();	
		break;
		
	default:
		ComChkObjValid(event.srcElement);
	}
}

/**
* HTML Control Foucs in
*/
function frm1_activate(){	
	switch (event.srcElement.name) {
	case "fm_ad_amt":
	    ComClearSeparator(event.srcElement);	    
		break;
	default:
	    ComClearSeparator(event.srcElement);
	}
} 



/**
 * HTML Control KeyPress 이벤트 호출
 */
function frm2_keypress() {	
    switch (event.srcElement.name) {    
    case "fm_ad_amt":
    	ComKeyOnlyNumber(event.srcElement,"-");
		if (frm2.fm_ad_amt.value.length > 0 && event.keyCode == 13) {
			setUsdAmt2();
		}   
		break;
	}
}

/**
* HTML Control Focus out
**/
function frm2_deactivate() {
	switch (event.srcElement.name) {
	case "fm_ad_amt":
		
		if (!ComChkObjValid(frm2.fm_ad_amt)) {
			return;
		}		
		setUsdAmt2();
		
		break;
		
	default:
		ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control Foucs in
 */
function frm2_activate(){	
	switch (event.srcElement.name) {
	case "fm_rqst_locl_amt":
	    ComClearSeparator(event.srcElement);	    
		break;
	default:
	    ComClearSeparator(event.srcElement);
	}
} 
  


/**
* 모든폼을 숨김 (et , ei , 하위버튼 form)
**/
function hideAllForm() {	
	var div_type1 = document.getElementById("div_type1");
	var div_type2 = document.getElementById("div_type2");
	var div_type3 = document.getElementById("div_type3");
	div_type1.style.display  = "none";		
    div_type2.style.display  = "none";		
	div_type3.style.display  = "none";	
	 
}
//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
* MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
* @return
*/
function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
	   	//checked
	   	var bChk = comboObj.CheckIndex(index);
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = bChk;
		}
} else {
		comboObj.CheckIndex(0) = false;
}
}




//===================================================================================
//Sheet 이벤트 처리
//===================================================================================


/**
* sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
function sheet1_OnChange(sheet, row, col ,value) {
		
	var sName = sheet1.ColSaveName(col);
	
	if ("crnt_gen_expn_apsts_cd_rj" == sName) {
		if ( sheet1.CellValue(row,"crnt_gen_expn_apsts_cd_rj") == 1) {
			sheet1.CellValue(row,"crnt_gen_expn_apsts_cd_ap") = 0;			
		}					
	} else if ("crnt_gen_expn_apsts_cd_ap" == sName) {	
		if ( sheet1.CellValue(row,"crnt_gen_expn_apsts_cd_ap") == 1) {
			sheet1.CellValue(row,"crnt_gen_expn_apsts_cd_rj") = 0;
		}			
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
	
}



/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	
	displayForm(row);
	
}

/**
* 폼상세정보 취득 및 표시   
* @param {long} row 해당 셀의 Row Index
*/
function displayForm(row) {
	
	 if (sheet1.CellValue(row,"fm_gen_expn_itm_desc") == "SUB TOTAL") {
		 return;
	 }
	 
	//선택행 설정 (저장시 선택된 행의 정보를 서버로 전송
	frm.rownum.value = row;
	
	var gen_expn_rqst_tp_cd = sheet1.CellValue(row ,"gen_expn_rqst_tp_cd");
	
	var div_type1 = document.getElementById("div_type1");
	var div_type2 = document.getElementById("div_type2");
	var div_type3 = document.getElementById("div_type3");

	if ("ET" == gen_expn_rqst_tp_cd) {		
		div_type1.style.display  = "block";		
		div_type2.style.display  = "none";
	} else {		
		div_type1.style.display  = "none";
		div_type2.style.display  = "block";		
	}
	
	div_type3.style.display  = "block";
	
	if (frm6.popup_yn.value == "N") {
		parent.syncHeight();
	}
	
	if ("ET" == gen_expn_rqst_tp_cd) {	
		//시트를 폼으로 전송
		setSheet1ToForm(row);
		tab2.SelectedIndex = 0;
		beforetab = 0;
		var objs = document.all.item("tabLayer_sub");    
		objs[0].style.display = "inline";
		objs[1].style.display = "none";
		top.document.body.scrollTop = 730;
		setUsdAmt1();
	} else {		
		//시트를 폼으로 전송
		setSheet1ToForm2(row);
		top.document.body.scrollTop = 680;
	}
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
   if (sheet1.MouseRow > 0 && "fm_gen_expn_cd" == sName) {	   
	   if (ComGetObjValue(frm.lang_div) == "KOR") {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_krn_abbr_nm");   
	   } else {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_eng_abbr_nm");
	   }	   		   
   } else if (sheet1.MouseRow > 0 && "to_gen_expn_cd" == sName) {
	   if (ComGetObjValue(frm.lang_div) == "KOR") {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_krn_abbr_nm");   
	   } else {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_eng_abbr_nm");
	   }		   
   } else if (sheet1.MouseRow > 0 && "fm_locl_curr_cd" == sName) {
	   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_ut_val");		   
   } else if (sheet1.MouseRow > 0 && "to_locl_curr_cd" == sName) {
	   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_ut_val");		   
   } else {
	   sheet1.MouseToolTipText = "";
   }
 
}


function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	var init_clz_flg = frm.init_clz_flg.value;
	var gen_expn_rqst_tp_cd = "";
	if (frm.gen_expn_rqst_tp_cd[1].checked) gen_expn_rqst_tp_cd = "EI";
			
	if(sheet.RowCount <= 0 )  {
		return;
	}
	
	if(frm.sum_up[1].checked){		
		sheet.Redraw = false;
		sheet.ShowSubSum("fm_ofc_cd", "10|11|12|13", -1, false,false, -1,"1=;7=SUB TOTAL");
		sheet.Redraw = true;
	}
	
	if(frm.sum_up[2].checked){
		sheet.Redraw = false;
		sheet.ShowSubSum("fm_gen_expn_cd", "10|11|12|13", -1, false,false, -1,"1=;7=SUB TOTAL");
		sheet.Redraw = true;
	}
	
	sheet.SumText(0,3)="";
	sheet.MessageText("Sum") = "";	
	sheet.SumText(0,"fm_gen_expn_itm_desc")="Grand Total";

	if (gen_expn_rqst_tp_cd == "EI" && init_clz_flg == "Y" ) {
		ComBtnDisable("t3_btn2_Save");
	} 	
	//sheet.ApplyFormat();
}

/**
* transfer from sheet2 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value
*/
function sheet2_OnChange(sheet , row , col , value) {
	
	//비었으면 0으로 설정
	if (value == "") {
		sheet.CellValue(row,col) = 0;
		return;
	}
	
	var assignAmt = sheet.CellValue(1,col);
	
	if (ComIsNull(assignAmt)) {
		assignAmt = 0;
	} 
	
	//from  음수 
	var fmAmt = -1 * Math.abs(value);
	
	if (parseInt(assignAmt) + parseInt(fmAmt) < 0 ) {
		//msgs["GEM01080"] = "The requested amount cann't be exceeded the assigned amount.";
		ComShowCodeMessage("GEM01080");			
		sheet.CellValue(row,col) = 0;
	} else {
		sheet.CellValue(row,col) = fmAmt;
	}

			
	frm1.fm_ad_amt.value = sheet.CellText(row,"ttl");		
	setUsdAmt1();	
	
	
}
 
/**
* transfer to sheet2 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value
*/
function sheet3_OnChange(sheet , row , col , value) {
	
	//비었으면 0으로 설정
	if (value == "") {
		sheet.CellValue(row,col) = 0;
		return;
	}
	
	if (value < 0) {
		sheet.CellValue(row , col) = value * -1;			
	} else {
		sheet.CellValue(row , col) = value;
	}
	
	if ( parseInt(removeComma(frm1.to_ad_amt.value),10) < sheet.CellValue(row,"ttl") ) {
		ComShowCodeMessage("GEM01081");			
		sheet.CellValue2(row,col) = 0;
	}
}


/**
* sheet4 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
function sheet4_OnChange(sheet, row, col ,value) {
		
	var sName = sheet.ColSaveName(col);
	
	if ("crnt_gen_expn_apsts_cd_rj" == sName) {
		if ( sheet.CellValue(row,"crnt_gen_expn_apsts_cd_rj") == 1) {
			sheet.CellValue(row,"crnt_gen_expn_apsts_cd_ap") = 0;
			sheet.CellValue2(row,"gen_expn_apsts_cd") = "RJ";
		}					
	} else if ("crnt_gen_expn_apsts_cd_ap" == sName) {	
		if ( sheet.CellValue(row,"crnt_gen_expn_apsts_cd_ap") == 1) {
			sheet.CellValue(row,"crnt_gen_expn_apsts_cd_rj") = 0;
			sheet.CellValue2(row,"gen_expn_apsts_cd") = "AP";
		}			
	} 
	
}


/**
* init/additional sheet5 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value
*/
function sheet5_OnChange(sheet , row , col , value) {
	
	//비었으면 0으로 설정
	if (value == "") {
		sheet.CellValue(row,col) = 0;
		return;
	}
	
	var rownum = frm.rownum.value;
	var genExpnRqstTpCd = 
		sheet1.CellValue(rownum ,"gen_expn_rqst_tp_cd");
	
	if (genExpnRqstTpCd == "EI") {
		if (value < 0 ) {
			sheet.CellValue(row , col) = 0;
		}
	}
	
	frm2.fm_ad_amt.value = sheet.CellText(row,"ttl");
	setUsdAmt2();
	
}

/**
* sheet6 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
function sheet6_OnChange(sheet, row, col ,value) {
		
	var sName = sheet.ColSaveName(col);
	
	if ("crnt_gen_expn_apsts_cd_rj" == sName) {
		if ( sheet.CellValue(row,"crnt_gen_expn_apsts_cd_rj") == 1) {
			sheet.CellValue(row,"crnt_gen_expn_apsts_cd_ap") = 0;
			sheet.CellValue2(row,"gen_expn_apsts_cd") = "RJ";
		}					
	} else if ("crnt_gen_expn_apsts_cd_ap" == sName) {	
		if ( sheet.CellValue(row,"crnt_gen_expn_apsts_cd_ap") == 1) {
			sheet.CellValue(row,"crnt_gen_expn_apsts_cd_rj") = 0;
			sheet.CellValue2(row,"gen_expn_apsts_cd") = "AP";
		}			
	} 
	
}


/**
* 업무 처리 이벤트
* @param {string} sAction 액션타입 
*/
function doActionIBSheet(sAction) {

	//[Grid Retrive]
	if (sAction == SEARCHLIST) {
		
		//폼숨김
		hideAllForm();
		//팝업이 아닌경우만 실행
		if (frm6.popup_yn.value == "N") {			
			parent.syncHeight();
		}
		
	    //LCL금액으로 검색여부
	    if (frm.curr_cd[0].checked) {
	    	frm.lcl_search_flg.value = "Y";
	    } else {
	    	frm.lcl_search_flg.value = "N";
	    }		
				
	    frm.rownum.value = "";	    
		frm.f_cmd.value = SEARCHLIST;
		frm.fm_gen_expn_cd_grp.value = combo1.Code;
		sheet1.DoSearch("CPS_GEM_0001_03GS.do", FormQueryString(frm));		
		
		if (sheet1.RowCount == 0) {
			//msgs["GEM00013"] = "There is no related data!";
			ComShowCodeMessage("GEM00013");
			return;
		}		
		
    //[open]	 	
	} else if (sAction == INIT) {
		
		//폼숨김
		hideAllForm();
		
		frm.f_cmd.value = INIT;		
		var sXml = sheet7.GetSearchXml("CPS_GEM_0001_03GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");
		var authFlg  = "";
		
		// 로그인 오피스 정보 
		if (arrXml.length > 0) {			
			
			//사용자 오피스 설정
			frm.usr_ofc_cd.value = ComGetEtcData(arrXml[0], "usr_ofc_cd");
			frm.init_clz_flg.value = ComGetEtcData(arrXml[0], "init_clz_flg");
			
			var list = ComXml2ListMap(arrXml[0]);
			var officeLevelVo  = list[0];			
			authFlg  = officeLevelVo["auth_flg"];
			
			// BU	
			if ( authFlg == "YYYN" ) {				
				//비용주관팀  TIC 설정 Authorized Expense Code
				frm.usr_tic_cd.value = frm.usr_ofc_cd.value;				
			// 사무국
			} else if ( authFlg == "YNYN" || authFlg == "YNYY") {				

				//사무국인경우 수퍼유저인경우 commit체크박스 디스플레이				
				if (authFlg == "YNYY") {
					if ( frm.usr_auth_tp_cd.value == USR_AUTH_TP_CD ) {
						var sp_commit = document.getElementById("sp_commit");
						sp_commit.style.display = "inline";
					} else {
						//사무국인경우 비용팀으로 수퍼유저이더라도 commit체크시 수퍼유저로 사용
						authFlg = "YNYN";
					}
				}
				
				//비용주관팀  TIC 설정 Authorized Expense Code 
				if (authFlg == "YNYN") {
					frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
				}
				
			} else if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
				goNoAuthority();
		    }				
			
			//권한 설정
			frm.auth_flg.value = authFlg;
			
			// ---------------------------------
			// TIC 콤보박스  설정
			// ---------------------------------		
					
			var ticList = ComGetEtcData(arrXml[0], "ticCd").split("|");
			
			var tic_cd = frm.fm_tic_cd;
			tic_cd.length = 0;
			
			ComAddComboItem(tic_cd,"","");
			
			for(var i=0 ; i < ticList.length ; i++ ) {			
				ComAddComboItem(tic_cd,ticList[i],ticList[i]);
			}		
			
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
				} else {
					frm.sls_ofc_div_cd[1].checked = true;
				}
				
			    //권한 설정
				var authFlg = frm.auth_flg.value;	  

				//집행단위.지역그룹
				if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
					ComEnableObject(frm.ofc_lvl1, false);
					ComEnableObject(frm.ofc_lvl2, false);
					ComEnableObject(frm.ofc_lvl3, false);
					if ( authFlg == "YYNN" ) {
						ComEnableObject(frm.ofc_lvl3, true);
					}
					frm.sls_ofc_div_cd[0].disabled=true;
					frm.sls_ofc_div_cd[1].disabled=true;
					//LV1
					ComSetObjValue(frm.ofc_lvl1,level2);					
					//LV2
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet7','sls_ofc_div_cd','1','document.form.ofc_lvl');			
					ComSetObjValue(frm.ofc_lvl2,level3);					
					//LV3
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet7','sls_ofc_div_cd','2','document.form.ofc_lvl');			
					ComSetObjValue(frm.ofc_lvl3,level4);					
									
				//사무국 , BU ,TIC
				} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
					ComEnableObject(frm.ofc_lvl1, true);
					ComEnableObject(frm.ofc_lvl2, true);
					ComEnableObject(frm.ofc_lvl3, true);				
					frm.sls_ofc_div_cd[0].checked = false;
					frm.sls_ofc_div_cd[1].checked = false;
				} else {
					ComEnableObject(frm.ofc_lvl1, false);
					ComEnableObject(frm.ofc_lvl2, false);
					ComEnableObject(frm.ofc_lvl3, false);		
					frm.sls_ofc_div_cd[0].disabled=true;
					frm.sls_ofc_div_cd[1].disabled=true;
				}
								
				frm.ofc_lvl3.blur();
			}
			
			
			
		}		
		
		// additional 마감 정보
		if (arrXml.length > 2) {
			var list = ComXml2ListMap(arrXml[2]);
			if (list.length > 0) {
				closingDateVO  = list[0];
				var clzYrmon = 	closingDateVO["clz_yrmon"];
				//마감정보 설정
				frm.pln_yrmon.value = clzYrmon;				
				printClosingDate(closingDateVO);
				
				//예산년월
				var clzYrmon = 	closingDateVO["clz_yrmon"];
				
				var clzMon = clzYrmon.substring(4,6);
				
				if ("00" != clzMon) {
					var mon = parseInt(clzMon , 10);
					
					if (mon == 0) {
						mon = 1;
					}
					// ET ..................
					frm1.fm_monthFrom.length = 0;					
					for ( var i = mon; i <= 12; i++) {
						ComAddComboItem(frm1.fm_monthFrom,  getEngMonthName(i) , i);
					}

					frm1.fm_monthTo.length = 0;
					ComAddComboItem(frm1.fm_monthTo,  "" , "");
					comboCopy(frm1.fm_monthFrom, frm1.fm_monthTo, false);
					frm1.fm_monthTo.value = "";
					
					frm1.to_monthFrom.length = 0;
					ComAddComboItem(frm1.to_monthFrom,  "" , "");
					comboCopy(frm1.fm_monthFrom, frm1.to_monthFrom, false);
					
					frm1.to_monthTo.length = 0;
					ComAddComboItem(frm1.to_monthTo,  "" , "");
					comboCopy(frm1.fm_monthFrom, frm1.to_monthTo, false);
					frm1.to_monthTo.value = "";
					
					// EA ,EI ..................
					frm2.fm_monthFrom.length = 0;
					ComAddComboItem(frm2.fm_monthFrom,  "" , "");
					comboCopy(frm1.fm_monthFrom, frm2.fm_monthFrom, false);					
					
					frm2.fm_monthTo.length = 0;
					ComAddComboItem(frm2.fm_monthTo,  "" , "");
					comboCopy(frm1.fm_monthFrom, frm2.fm_monthTo, false);
					frm2.fm_monthTo.value = "";
					
					
				}
				
				frm1.fm_monthFrom.disabled = true;
				frm1.to_monthFrom.disabled = true;
				frm1.fm_monthTo.disabled = true;
				frm1.to_monthTo.disabled = true;
				frm2.fm_monthFrom.disabled = true;
				frm2.fm_monthTo.disabled = true;
			}
		}
		
		
		// ---------------------------------
		// Expense Code group code 
		// ---------------------------------
		if (arrXml.length > 3) {
			expnGroupList = ComXml2ListMap(arrXml[3]);		
			setExpnGroupList();			
		}
		
		// initial 마감 정보
		if (arrXml.length > 4) {
			var list = ComXml2ListMap(arrXml[4]);
			if (list.length > 0) {
				initDateVO  = list[0];
			}
					
		}	
		
		
		
		
		
	//[Save]	
	} else if (sAction == MULTI) {
		
		var srow = frm.rownum.value;		
		//선택된 Request 미존재 
		if (ComIsNull(srow)) {			
			return false;
		}
		 
		var gen_expn_rqst_tp_cd = sheet1.CellValue(srow ,"gen_expn_rqst_tp_cd");
		var param = "";
		
		
		//EA , ET
		if ("ET" == gen_expn_rqst_tp_cd) {
			//RQST_OPIN_RMK			
			var rqstOpinRmk = frm1.to_rqst_opin_rmk.value;			
			sheet1.CellValue2(srow , "rqst_opin_rmk") = rqstOpinRmk;
			var queryString = getSheetRowQueryString(sheet1,srow);	
			queryString = ComSetPrifix(queryString, "sheet1_");
			
			var editRowS2 = getEditableRow(sheet2);			
			var fm_ad_amt = frm1.fm_ad_amt.value;			
			var fm_ttl  = sheet2.CellText(editRowS2 , "ttl");			
			if ( fm_ttl != fm_ad_amt) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" , fm_ad_amt);
				frm1.fm_ad_amt.value.focus();
				return false;
			}

			var to_ad_amt = frm1.to_ad_amt.value;	
			var editRowS3 = getEditableRow(sheet3);
			var to_ttl  = sheet3.CellText(editRowS3 , "ttl");			
			if (to_ttl != to_ad_amt) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" , to_ad_amt);		
				frm1.to_ad_amt.focus();
				return false;
			}
			
			if (sheet4.CellValue(editRowS2,"crnt_gen_expn_apsts_cd_rj") == 1) {
				var apro_opin_rmk = sheet4.CellValue(editRowS2,"apro_opin_rmk");
				
				// 2009-10-15추가 
				var rqstOfcCd = sheet1.CellValue(srow , "rqst_ofc_cd");
				var usrOfcCd = frm.usr_ofc_cd.value;
				if (rqstOfcCd  == usrOfcCd) {
					//msgs["GEM01090"] = "Requester's office can not reject";
					ComShowCodeMessage("GEM01090");
					return false; 
				}				
				
				if (ComIsNull(apro_opin_rmk)) {
					//msgs["GEM01082"] = "In case of Reject, The opinion should be inputted.";
					ComShowCodeMessage("GEM01082");
					sheet4.SelectCell(editRowS2,"apro_opin_rmk");
					return false;
				}
			}
			
			if (sheet4.CellValue(editRowS2,"crnt_gen_expn_apsts_cd_rj") == 0
				&& sheet4.CellValue(editRowS2,"crnt_gen_expn_apsts_cd_ap") == 0) {				
					//msgs["GEM01084"] = "You should select either Reject or Approval";
					ComShowCodeMessage("GEM01084");
					sheet4.SelectCell(editRowS2,"crnt_gen_expn_apsts_cd_ap");
					return false;				
			}
			

			
			
			frm.f_cmd.value = MULTI;			
			param = FormQueryString(frm);

			
			var sheet2Query = getSheetRowQueryString(sheet2,editRowS2);
			sheet2Query = ComSetPrifix(sheet2Query, "sheet2_");
			
			var sheet3Query = getSheetRowQueryString(sheet3,editRowS3);
			sheet3Query = ComSetPrifix(sheet3Query, "sheet3_");			

			var sheet4Query = getSheetRowQueryString(sheet4,editRowS2);
			sheet4Query = ComSetPrifix(sheet4Query, "sheet4_");			
			
			
			
			queryString += "&" + sheet2Query + "&" + sheet3Query+ "&" + sheet4Query;
			param += "&" + queryString;
			
			var sXml = sheet2.GetSaveXml("CPS_GEM_0003GS.do", param);
			sheet2.LoadSaveXml(sXml);
			
		} else {
			
			//RQST_OPIN_RMK	
			var rqstOpinRmk = frm1.to_rqst_opin_rmk.value;			
			sheet1.CellValue2(srow , "rqst_opin_rmk") = rqstOpinRmk;
			var queryString = getSheetRowQueryString(sheet1,srow);	
			queryString = ComSetPrifix(queryString, "sheet1_");
			
			var editRow = getEditableRow(sheet5);
			
			var fm_ad_amt = frm2.fm_ad_amt.value;			
			var fm_ttl  = sheet5.CellText(editRow , "ttl");			
			if ( fm_ttl != fm_ad_amt) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" , fm_ad_amt);
				frm2.fm_ad_amt.focus();
				return false;
			}
			
			
			if (sheet6.CellValue(editRow,"crnt_gen_expn_apsts_cd_rj") == 1) {
				var apro_opin_rmk = sheet6.CellValue(editRow,"apro_opin_rmk");
				
				// 2009-10-15추가 
				var rqstOfcCd = sheet1.CellValue(srow , "rqst_ofc_cd");
				var usrOfcCd = frm.usr_ofc_cd.value;
				if (rqstOfcCd  == usrOfcCd) {
					//msgs["GEM01090"] = "Requester's office can not reject";
					ComShowCodeMessage("GEM01090");
					return false; 
				}				
				
				if (ComIsNull(apro_opin_rmk)) {
					//msgs["GEM01082"] = "In case of Reject, The opinion should be inputted.";
					ComShowCodeMessage("GEM01082");
					sheet6.SelectCell(editRow,"apro_opin_rmk");
					return false;
				}
			}			
			
			if (sheet6.CellValue(editRow,"crnt_gen_expn_apsts_cd_rj") == 0
					&& sheet6.CellValue(editRow,"crnt_gen_expn_apsts_cd_ap") == 0) {				
						//msgs["GEM01084"] = "You should select either Reject or Approval";
						ComShowCodeMessage("GEM01084");
						sheet6.SelectCell(editRow,"crnt_gen_expn_apsts_cd_ap");
						return false;				
			}			

			
			
			frm.f_cmd.value = MULTI01;
			
			param = FormQueryString(frm); 
			
			var sheet5Query = getSheetRowQueryString(sheet5,editRow);
			sheet5Query = ComSetPrifix(sheet5Query, "sheet5_");		
			
			var sheet6Query = getSheetRowQueryString(sheet6,editRow);
			sheet6Query = ComSetPrifix(sheet6Query, "sheet6_");			
			
			
			queryString += "&" + sheet5Query + "&" + sheet6Query;
			param += "&" + queryString;
			
			var sXml = sheet5.GetSaveXml("CPS_GEM_0003GS.do", param);
			sheet5.LoadSaveXml(sXml);
		}
		
		return true;
		
		//[Save] grid에서 선택  rj, ap		
	} else if (sAction == MULTI02) {

		for (var i =0 ; i < sheet1.RowCount ; i++) {
			var row = i + 2;			
			var ap = sheet1.CellValue(row , "crnt_gen_expn_apsts_cd_ap");			
			var rj = sheet1.CellValue(row , "crnt_gen_expn_apsts_cd_rj");
			if (ap == 0 && rj == 0) {
				sheet1.CellValue(row , "ibflag") = "R";
			}
			
			// 2009-10-15 추가
			if (rj == 1) {				
				var rqstOfcCd = sheet1.CellValue(row , "rqst_ofc_cd");
				var usrOfcCd = frm.usr_ofc_cd.value;
				if (rqstOfcCd  == usrOfcCd) {
					//msgs["GEM01090"] = "Requester's office can not reject";
					ComShowCodeMessage("GEM01090");
					return false; 
				}
				
			}
			
			if (ap == 1 || rj == 1) {
				var gen_expn_rqst_no = sheet1.CellValue(row , "gen_expn_rqst_no");
				var genExpnRqstSeq = sheet1.CellValue(row , "gen_expn_rqst_seq");	
				var param = "f_cmd=" + SEARCH01;
				param += "&gen_expn_rqst_no=" + gen_expn_rqst_no;	
				param += "&gen_expn_rqst_seq=" + genExpnRqstSeq;
				var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);
				var updDt = ComGetEtcData(sXml ,"itmDt");
				
				if (ComIsNull(updDt)) {
					ComShowCodeMessage("GEM01088");	
					sheet1.SelectCell(row , "gen_expn_rqst_no");
					return false;		
				}
				
				var itmUpdDt = sheet1.CellValue(row , "itm_upd_dt");
				
				if (updDt != itmUpdDt ) {					
					ComShowCodeMessage("GEM01089");		
					doActionIBSheet(SEARCHLIST);
					sheet1.SelectCell(row , "gen_expn_rqst_no");
					return false;
				}			
			}
			// 2009-10-15
			
		}
		
		
		var sParam = sheet1.GetSaveString();
		
		if (sParam == "") {		
			//msgs["GEM01056"] = "There is no contents to save.";
			ComShowCodeMessage("GEM01056");
			return false; 
		}
		
		
		sParam = ComSetPrifix(sParam, "sheet1_");		
		frm.f_cmd.value = MULTI02;
		var param = FormQueryString(frm);
		param =  param + "&" + sParam;		
		var sXml = sheet1.GetSaveXml("CPS_GEM_0003GS.do", param);
		
		sheet1.LoadSaveXml(sXml);
		
		return true;
		
     // DELETE 
	}  else if (sAction == REMOVE ) {
		
		var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
		
		if (ComIsNull(gen_expn_rqst_no)) {
			//{?msg1} 필수항목을 입력하여 주시기 바랍니다
			ComShowCodeMessage("GEM00003" , "Request No.");
			frm.gen_expn_rqst_no.focus();
			return false;
		}
		
		//msgs["GEM00016"] = "Do you want to delete it";
		if (!ComShowCodeConfirm("GEM00016")) {			
			return false;
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

		var sXml = sheet7.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
		
		// LEVEL2 조회
		var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
		
		if (typeof comboListData != "undefined" && comboListData != "") {
			// Search
			var ofc_lvl1 = frm.ofc_lvl1;
			ofc_lvl1.length = 0;
			ComAddComboItem(ofc_lvl1, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(ofc_lvl1, comboListData[i], comboListData[i]);
			}

			// transfer			 
			var fm_ofc_lvl1 = frm1.fm_ofc_lvl1;			
			fm_ofc_lvl1.length = 0;
			ComAddComboItem(fm_ofc_lvl1, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(fm_ofc_lvl1, comboListData[i], comboListData[i]);
			}
			
			var to_ofc_lvl1 = frm1.to_ofc_lvl1;
			to_ofc_lvl1.length = 0;
			ComAddComboItem(to_ofc_lvl1, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(to_ofc_lvl1, comboListData[i], comboListData[i]);
			}			

			// init , additional			
			fm_ofc_lvl1 = frm2.fm_ofc_lvl1;			
			fm_ofc_lvl1.length = 0;
			ComAddComboItem(fm_ofc_lvl1, "", "");			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(fm_ofc_lvl1, comboListData[i], comboListData[i]);
			}
			
			
		}

	} 	

}
