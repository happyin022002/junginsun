/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0001_02t.js
 *@FileTitle : [CPS_GEM-0001_02] Expense Request - Transfer
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
=========================================================*/


/**
 * [CPS_GEM-0001_02]  Expense Request - Transfer
 * @extends
 * @class  Expense Request - Transfer생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0001_02t() {
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
//실행중 여부 false =>미실행, true =>실행
var isIng = false;

var processing = false;

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

// note팝업창 
var noteWin = null;
// uthorized Expense Code  팝업창
var authWin = null;
// assigend 팝업창
var assWin = null;

// Assigned Expense 구분 (FM , TO)
var assWinDiv = "";

//Authorized Expense Code 구분 (FM , TO)
var authWinDiv = "";

//request no  pop up win
var reqWin = null;


//To currInfo 통화정보
var toCurrInfo = null;

//Fm currInfo 통화정보
var fmCurrInfo = null;
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
    resizeIframe("t2frame");    

	
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
            style.height = 160;

            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            MultiSelection = false;
            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 15, 100);

            var hdHeader =  "|fm_gen_expn_trns_div_cd|fm_sls_ofc_div_cd|fm_ofc_lv1|fm_ofc_lv2|fm_eng_abbr_nm|fm_krn_abbr_nm|fm_locl_curr_cd|fm_rqst_ut_val|fm_usd_locl_xch_rt|fm_tic_cd|fm_chk_assigned|fm_gen_expn_itm_no";
	            hdHeader += "|fm_gen_expn_itm_desc|fm_gen_expn_calc_bss_desc|fm_rqst_opin_rmk|fm_jan_amt|fm_feb_amt|fm_mar_amt|fm_apr_amt|fm_may_amt|fm_jun_amt|fm_jul_amt|fm_aug_amt|fm_sep_amt|fm_oct_amt|fm_nov_amt";
	            hdHeader += "|fm_dec_amt|fm_rqst_jan_amt|fm_rqst_feb_amt|fm_rqst_mar_amt|fm_rqst_apr_amt|fm_rqst_may_amt|fm_rqst_jun_amt|fm_rqst_jul_amt|fm_rqst_aug_amt|fm_rqst_sep_amt|fm_rqst_oct_amt|fm_rqst_nov_amt|fm_rqst_dec_amt|to_gen_expn_rqst_seq|to_gen_expn_trns_div_cd|to_sls_ofc_div_cd|to_ofc_lv1|to_ofc_lv2|to_eng_abbr_nm";
	            hdHeader += "|to_krn_abbr_nm|to_locl_curr_cd|to_rqst_ut_val|to_usd_locl_xch_rt|to_tic_cd|to_chk_assigned|to_gen_expn_itm_no|to_gen_expn_itm_desc|to_gen_expn_calc_bss_desc|to_rqst_opin_rmk";
	            hdHeader += "|to_jan_amt|to_feb_amt|to_mar_amt|to_apr_amt|to_may_amt|to_jun_amt|to_jul_amt|to_aug_amt|to_sep_amt|to_oct_amt|to_nov_amt|to_dec_amt|to_rqst_jan_amt|to_rqst_feb_amt|to_rqst_mar_amt|to_rqst_apr_amt|to_rqst_may_amt|to_rqst_jun_amt|to_rqst_jul_amt|to_rqst_aug_amt|to_rqst_sep_amt|to_rqst_oct_amt|to_rqst_nov_amt|to_rqst_dec_amt";
	            hdHeader += "|fm_ttl|to_ttl|retrieve_yn|itm_upd_dt|req_upd_dt";
			var HeadTitle1 = "ibflg|fm_ibflag|to_ibflag|Sel.|Seq.|FM|FM|FM|FM|TO|TO|TO|TO" + hdHeader;
			var HeadTitle2 = "ibflg|fm_ibflag|to_ibflag|Sel.|Seq.|Office|Expense Code|Amount ׀ LCL|Amount ׀ USD|Office|Expense Code|Amount ׀ LCL|Amount ׀ USD" + hdHeader;
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, false, true, false,false)
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	10,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,	10,		daCenter,	true,		"fm_ibflag");
			InitDataProperty(0, cnt++ , dtHidden,	10,		daCenter,	true,		"to_ibflag");
			InitDataProperty(0, cnt++ , dtDummyCheck,		40,		daCenter,	true,		"delChk" , false , "" , dfNone , 0 , true, true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"fm_gen_expn_rqst_seq" , false , "" , dfNone , 0 , false, false);			
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,       "fm_ofc_cd" , false , "" , dfNone , 0 , false, false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,       "fm_gen_expn_cd" , false , "" , dfNone , 0 , false, false);
			InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,       "fm_rqst_locl_amt",		false,		"",		dfNullInteger , 0,false, false);
			InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,       "fm_rqst_usd_amt",		false,		"",		dfNullInteger , 0,false ,false);

			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,       "to_ofc_cd" , false , "" , dfNone , 0 , false, false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,       "to_gen_expn_cd" , false , "" , dfNone , 0 , false, false);
			InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,       "to_rqst_locl_amt",		false,		"",		dfNullInteger ,0 , false,false);
			InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,       "to_rqst_usd_amt",		false,		"",		dfNullInteger,0 , false,false);
			
			//Hidden =================================================================================
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_gen_expn_trns_div_cd");			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_sls_ofc_div_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ofc_lvl1");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ofc_lvl2");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_locl_curr_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_usd_locl_xch_rt", false , "",dfFloat,4);
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_tic_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_chk_assigned");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_gen_expn_itm_no");
			
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_gen_expn_itm_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_gen_expn_calc_bss_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_opin_rmk");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_jan_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_feb_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_mar_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_apr_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_may_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_jun_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_jul_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_aug_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_sep_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_oct_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_nov_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_dec_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_jan_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_feb_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_mar_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_apr_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_may_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_jun_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_jul_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_aug_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_sep_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_oct_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_nov_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_rqst_dec_amt", false , "",dfInteger);
			
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_rqst_seq");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_trns_div_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_sls_ofc_div_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_ofc_lvl1");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_ofc_lvl2");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_locl_curr_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_usd_locl_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_tic_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_chk_assigned");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_no");
			
			
			
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_calc_bss_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_opin_rmk");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_jan_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_feb_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_mar_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_apr_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_may_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_jun_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_jul_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_aug_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_sep_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_oct_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_nov_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_dec_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_jan_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_feb_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_mar_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_apr_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_may_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_jun_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_jul_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_aug_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_sep_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_oct_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_nov_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_rqst_dec_amt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ttl", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_ttl", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"retrieve_yn");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"itm_upd_dt");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"req_upd_dt");
			
			break;

		case "sheet2":

            // 높이 설정
            style.height = 140;

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
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jan_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"feb_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"mar_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"apr_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"may_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jun_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"jul_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aug_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"sep_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"oct_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"nov_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"dec_amt",			false,		"",			dfNullInteger , 0 , false , false , 9);
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
* From 항목 disable
* @author 진윤오
* @version 2009.05.13
*/
function disableFromItem() {
	frm.fm_sls_ofc_div_cd[0].disabled=true;
	frm.fm_sls_ofc_div_cd[1].disabled=true;
	frm.fm_ofc_lvl1.disabled=true;
	frm.fm_ofc_lvl2.disabled=true;
	frm.fm_ofc_lvl3.disabled=true;	
	frm.fm_gen_expn_cd.readOnly = true;		
	frm.fm_chk_assigned.disabled = true;	
}

/**
* To 항목 disable
* @author 진윤오
* @version 2009.05.13
*/
function disableToItem() {
	frm.to_sls_ofc_div_cd[0].disabled=true;
	frm.to_sls_ofc_div_cd[1].disabled=true;
	frm.to_ofc_lvl1.disabled=true;
	frm.to_ofc_lvl2.disabled=true;
	frm.to_ofc_lvl3.disabled=true;
	frm.same_ofc_cd.disabled = true;
	frm.same_expn_cd.disabled = true;	
	frm.to_gen_expn_cd.readOnly = true;
}


/**
* From 항목 enable
* @author 진윤오
* @version 2009.05.13
*/
function enableFromItem() {
	frm.fm_sls_ofc_div_cd[0].disabled=false;
	frm.fm_sls_ofc_div_cd[1].disabled=false;
	frm.fm_ofc_lvl1.disabled=false;
	frm.fm_ofc_lvl2.disabled=false;
	frm.fm_ofc_lvl3.disabled=false;	
	frm.fm_gen_expn_cd.readOnly = false;
}



/**
* To 항목 enable
* @author 진윤오
* @version 2009.05.13
*/
function enableToItem() {
	frm.to_sls_ofc_div_cd[0].disabled=false;
	frm.to_sls_ofc_div_cd[1].disabled=false;
	frm.to_ofc_lvl1.disabled=false;
	frm.to_ofc_lvl2.disabled=false;
	frm.to_ofc_lvl3.disabled=false;
	frm.same_ofc_cd.disabled = false;
	frm.same_expn_cd.disabled = false;	
	frm.to_gen_expn_cd.readOnly = false;
	
	frm.to_gen_expn_itm_desc.readOnly = false;
}

/**
* From 항목 초기화
* @author 진윤오
* @version 2009.05.13
*/
function initFromItem() {
	
	ComSetObjValue(frm.fm_ofc_lvl1, "");		
	ComSetObjValue(frm.fm_ofc_lvl2, "");
	ComSetObjValue(frm.fm_ofc_lvl3, "");	
	
	/*
	ComSetObjValue(frm.fm_rqst_ut_val, "");	
	ComSetObjValue(frm.fm_usd_locl_xch_rt, "");
	document.getElementById("fm_locl_curr_cd").innerText = "";
	*/
	
	ComSetObjValue(frm.fm_gen_expn_cd , "");
	ComSetObjValue(frm.fm_eng_abbr_nm, "");
	ComSetObjValue(frm.fm_krn_abbr_nm, "");
	ComSetObjValue(frm.fm_gen_expn_cd_abbr_name, "");
	
	frm.fm_chk_assigned.checked = false;	
	ComSetObjValue(frm.fm_tic_cd, "");
	ComSetObjValue(frm.fm_gen_expn_itm_no, "");
	ComSetObjValue(frm.fm_gen_expn_itm_desc, "");
	ComSetObjValue(frm.fm_gen_expn_calc_bss_desc, "");	
	
	//시트 assigned 지우기
	var janCol = sheet2.SaveNameCol("jan_amt")
	var decCol = sheet2.SaveNameCol("dec_amt")
	
	for ( var i = janCol ; i <= decCol; i++) {		
		sheet2.CellValue2(1,i) = 0;
		sheet2.CellValue2(3,i) = 0;
	}


	
}

/**
* From 비용항목 초기화
* @author 진윤오
* @version 2009.05.13
*/
function initFromExpnItem() {	
	ComSetObjValue(frm.fm_gen_expn_cd , "");
	ComSetObjValue(frm.fm_eng_abbr_nm, "");
	ComSetObjValue(frm.fm_krn_abbr_nm, "");
	ComSetObjValue(frm.fm_gen_expn_cd_abbr_name, "");
	frm.fm_chk_assigned.checked = false;
	
	ComSetObjValue(frm.fm_tic_cd, "");
	ComSetObjValue(frm.fm_gen_expn_itm_no, "");
	ComSetObjValue(frm.fm_gen_expn_itm_desc, "");	
	
	//-------------------------------	
	ComSetObjValue(frm.fm_rqst_locl_amt , "");
	ComSetObjValue(frm.fm_rqst_usd_amt , "");	
	
	//시트 assigned 지우기
	var janCol = sheet2.SaveNameCol("jan_amt")
	var decCol = sheet2.SaveNameCol("dec_amt")
	
	for ( var i = janCol ; i <= decCol; i++) {		
		sheet2.CellValue2(1,i) = 0;
		sheet2.CellValue2(3,i) = 0;
	}
	
	disableToItem();
	
}


/**
* To 항목 초기화
* @author 진윤오
* @version 2009.05.13
*/
function initToItem() {
	frm.same_ofc_cd.checked = false;
	frm.same_expn_cd.checked = false;
	frm.to_sls_ofc_div_cd[0].checked=false;
	frm.to_sls_ofc_div_cd[1].checked=false;	
	ComSetObjValue(frm.to_ofc_lvl1, "");		
	ComSetObjValue(frm.to_ofc_lvl2, "");
	ComSetObjValue(frm.to_ofc_lvl3, "");
	ComSetObjValue(frm.to_gen_expn_rqst_seq , "");
	ComSetObjValue(frm.to_gen_expn_cd , "");	
	ComSetObjValue(frm.to_eng_abbr_nm, "");
	ComSetObjValue(frm.to_krn_abbr_nm, "");	
	ComSetObjValue(frm.to_gen_expn_cd_abbr_name, "");
	ComSetObjValue(frm.to_tic_cd, "");
	frm.to_chk_assigned.checked = false;
	ComSetObjValue(frm.to_rqst_locl_amt, "");		
	ComSetObjValue(frm.to_gen_expn_itm_no, "");				
	ComSetObjValue(frm.to_gen_expn_itm_desc, "");
	ComSetObjValue(frm.to_gen_expn_calc_bss_desc, "");
	ComSetObjValue(frm.to_rqst_opin_rmk, "");	
	
	//시트 assigned 지우기
	var janCol = sheet2.SaveNameCol("jan_amt")
	var decCol = sheet2.SaveNameCol("dec_amt")
	
	for ( var i = janCol ; i <= decCol; i++) {		
		sheet2.CellValue2(2,i) = 0;
		sheet2.CellValue2(4,i) = 0;
	}
	
}

/**
* To 비용항목 초기화
* @author 진윤오
* @version 2009.05.13
*/
function initToExpnItem() {
	ComSetObjValue(frm.to_gen_expn_cd , "");	
	ComSetObjValue(frm.to_eng_abbr_nm, "");
	ComSetObjValue(frm.to_krn_abbr_nm, "");	
	ComSetObjValue(frm.to_gen_expn_cd_abbr_name, "");
	ComSetObjValue(frm.to_tic_cd, "");
	frm.to_chk_assigned.checked = false;
		
	ComSetObjValue(frm.to_gen_expn_itm_no, "");				
	ComSetObjValue(frm.to_gen_expn_itm_desc, "");	
	// ------------------------------------------	
	ComSetObjValue(frm.to_rqst_locl_amt, "");
	
	
	//시트 assigned 지우기
	var janCol = sheet2.SaveNameCol("jan_amt")
	var decCol = sheet2.SaveNameCol("dec_amt")
	
	for ( var i = janCol ; i <= decCol; i++) {		
		sheet2.CellValue2(2,i) = 0;
		sheet2.CellValue2(4,i) = 0;
	}
	
}



/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function doBlink() {
	var elm = document.getElementById("fm_auth_expn_code");		
	if ( elm.style.color == "red") {
		elm.style.color = "black";
	} else {
		elm.style.color = "red";
	}
}

/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function stopBlink() {
	clearInterval(intervalID);
	var elm = document.getElementById("fm_auth_expn_code");
	elm.style.color = "black";	
}

/**
*  글자 반짝 거리기
* @author 진윤오
* @version 2009.05.13
*/
function startBlink() {
	
	if (ComIsNull(frm.fm_ofc_lvl3.value)) {
		return;
	}
	
	intervalID = setInterval(doBlink, 1000);
}
   

/**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   * 그리드 클릭시
   */
function validateForm(){
	
	var rowNum = getRowNum();
	

	//폼체크	
	if (!ComChkValid(frm)) {
		if (rowNum > 0) {
			sheet1.SelectRow = rowNum;
			sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
		}
		return false;
	}
	
	//FM assigned 금액 체크
	if (!frm.fm_chk_assigned.checked) {
		//From Expense 코드 의 Assigned Expense 코드를 선택하세요
		ComShowCodeMessage("GEM01046");
		frm.fm_chk_assigned.focus();
		return;
	}
	
	var fm_rqst_locl_amt = frm.fm_rqst_locl_amt.value;
	
	var sheet2_ttl = sheet2.CellText(3,"ttl");
	
	if (fm_rqst_locl_amt != sheet2_ttl) {	
		//시트의 FM RQST Amount  와 FM RQST Amount 같지 않습니다.
		ComShowCodeMessage("GEM01053");
		frm.fm_rqst_locl_amt.focus();
		return ;
	}		

	var to_rqst_locl_amt = frm.to_rqst_locl_amt.value;
	
	sheet2_ttl = sheet2.CellText(4,"ttl");
	
	if (to_rqst_locl_amt != sheet2_ttl) {
		// 시트의 TO RQST Amount  와 요청한 FM RQST Amount 같지 않습니다.
		ComShowCodeMessage("GEM01054" , document.getElementById("to_locl_curr_cd").innerText);
		frm.to_rqst_locl_amt.focus();
		return false;
	}		
	
	return true;
	
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
			var row = i + 2;
			if (sheet1.RowStatus(row) == "D")  {
				continue;
			}
			
			var fm_gen_expn_cd = sheet1.CellValue(row,"fm_gen_expn_cd");			
			if (ComIsNull(fm_gen_expn_cd )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "From Expense Code");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"fm_gen_expn_cd",true);				
				return false ;
			}
			
			var to_gen_expn_cd = sheet1.CellValue(row,"to_gen_expn_cd");
			if (ComIsNull(to_gen_expn_cd )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "To Expense Code");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"to_gen_expn_cd",true);
				return false ;
			}

			var fm_gen_expn_itm_desc = sheet1.CellValue(row,"fm_gen_expn_itm_desc");
			if (ComIsNull(fm_gen_expn_itm_desc )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Request Item Description");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"fm_gen_expn_itm_desc",true);
				return false ;
			}
			
			var to_gen_expn_itm_desc = sheet1.CellValue(row,"to_gen_expn_itm_desc");
			if (ComIsNull(to_gen_expn_itm_desc )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Request Item Description");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"to_gen_expn_itm_desc",true);
				return false ;
			}

			
			var to_gen_expn_calc_bss_desc = sheet1.CellValue(row,"to_gen_expn_calc_bss_desc");
			if (ComIsNull(to_gen_expn_calc_bss_desc )) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "Calculation Basis");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"to_gen_expn_calc_bss_desc",true);
				return false ;
			}
			
			
			
			var fm_rqst_locl_amt = sheet1.CellValue(row,"fm_rqst_locl_amt");
			
			if (ComIsNull(fm_rqst_locl_amt ) || fm_rqst_locl_amt == 0) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "RQST Amount");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"fm_rqst_locl_amt",true);
				return false ;
			}
			
			var fm_ttl = sheet1.CellValue(row,"fm_ttl");
			
			if (fm_rqst_locl_amt != fm_ttl ) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" , sheet1.CellText(row,"fm_rqst_locl_amt"));		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"fm_rqst_locl_amt",true);
				return false ;
			}
			
			var to_rqst_locl_amt = sheet1.CellValue(row,"to_rqst_locl_amt");
			
			if (ComIsNull(to_rqst_locl_amt ) || to_rqst_locl_amt == 0) {
				//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다
				ComShowCodeMessage("GEM00003" , "RQST Amount");		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"to_rqst_locl_amt",true);
				return false ;
			}			
			
			var to_ttl = sheet1.CellValue(row,"to_ttl");
			
			if (to_rqst_locl_amt != to_ttl ) {
				//RQST Amount {?msg1} 금액과 Request TTL금액과 일치 하지 않습니다.
				ComShowCodeMessage("GEM01040" ,  sheet1.CellText(row,"to_rqst_locl_amt"));		
				sheet1.SelectRow = row;
				sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
				sheet1.SelectCell(row,"to_rqst_locl_amt",true);
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
		frm.to_gen_expn_itm_desc.value = text;
	} else if (type == "B") {
		frm.to_gen_expn_calc_bss_desc.value = text;
	} else if (type == "C") {
		frm.to_rqst_opin_rmk.value = text;
	}
	
	setFormToSheet1();
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
		    
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_krn_abbr_nm.value;
		    } else {
		    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_eng_abbr_nm.value;
		    }
		    
		    ComSetObjValue(frm.fm_gen_expn_group_cd , expenseInfo.gen_expn_group_cd);
		    setFormToSheet1();
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
		    ComSetObjValue(frm.to_gen_expn_group_cd , expenseInfo.gen_expn_group_cd);	
		    
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm.to_gen_expn_cd_abbr_name.value = frm.to_krn_abbr_nm.value;
		    } else {
		    	frm.to_gen_expn_cd_abbr_name.value = frm.to_eng_abbr_nm.value;
		    }
		    
			var plnYrmon =  frm.pln_yrmon.value;			
			//서버에서 maxItem NO 취득
			var itemNo = searchMaxItem(plnYrmon ,
					                   expenseInfo.ofc_cd ,
					                   expenseInfo.gen_expn_cd);
			
			//시트에 존재하면 시트 maxNo + 1
			itemNo = getGenExpnItmNo(expenseInfo.ofc_cd  , 
					                 expenseInfo.gen_expn_cd , 
					                 itemNo);		
			frm.to_gen_expn_itm_no.value = itemNo;			
			
			frm.to_chk_assigned.checked = false;		
			frm.to_gen_expn_itm_desc.readOnly = false;
			
			//시트 assigned 지우기
			var janCol = sheet2.SaveNameCol("jan_amt")
			var decCol = sheet2.SaveNameCol("dec_amt")
			
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet2.CellValue2(2,i) = 0;
			}
			
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
		frm.fm_gen_expn_itm_desc.readOnly = true;
		// To item ---------------------------
		enableToItem();
		initToExpnItem();
		initToItem();
		ComSetObjValue(frm.fm_rqst_locl_amt , "");
		//Assignment Rule		
		frm.to_assign_rule.checked = false;		
		ComEnableObject(frm.to_monthFrom, false);
		ComEnableObject(frm.to_monthTo, false);
		frm.to_monthTo.value = "";		
		//시트 assigned 지우기
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")		
		for ( var i = janCol ; i <= decCol; i++) {
			sheet2.CellValue2(3,i) = 0;
		}		
		
	} else if (assWinDiv == "TO") {
		frm.to_gen_expn_itm_desc.value = expenseInfo.gen_expn_itm_desc;              
		frm.to_gen_expn_itm_no.value   = expenseInfo.gen_expn_itm_no;
		frm.to_chk_assigned.checked = true;		
		frm.to_gen_expn_itm_desc.readOnly = true;
	}
	

}
 
 
 
 
 /**
  * 마감일 정보 표시
  * @param {array} closingDateVO 마감정보
  */
function printClosingDate(closingDateVO) {
	
	var clzYrmon = 	closingDateVO["clz_yrmon"];
	var clzDt = 	closingDateVO["clz_dt"];
	
	var clzYr = clzYrmon.substring(0,4);
	var clzMon = clzYrmon.substring(4,6);
	
	//Request Enable
	var mon = ComParseInt(clzMon);
	if (mon == 0) {
		for ( var i = 0; i < 12; i++) {
			sheet2.CellEditable(3,i+3) = true;
			sheet2.CellEditable(4,i+3) = true;
		}
	} else {
		for ( var i = 0; i < 12; i++) {			
			if ( i >= mon-1) {
				sheet2.CellEditable(3,i+3) = true;
				sheet2.CellEditable(4,i+3) = true;
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
				genExpnItmNo = parseInt(sItemNo, 10) + 1;
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
 	
	var genExpnRqstSeq = 1;
	
 	for ( var i = 0; i < sheet1.RowCount ; i++) {
 		var row =  i + 2;
 		if (sheet1.RowStatus(row) == "D")  {
 			continue;
 		}
 		
 		var gen_expn_rqst_seq = 
 			sheet1.CellValue(row , "fm_gen_expn_rqst_seq");
 	
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
		
		
		param += "lang_div=" + ComGetObjValue(frm.lang_div);
		param += "&f_cmd=" + SEARCHLIST02;
		param += "&ofc_cd=" + frm.fm_ofc_lvl3.value;	
		var authFlg = frm.auth_flg.value;
		
		if (authFlg != 'YNYY') {
			param += "&tic_cd=" + frm.usr_tic_cd.value;
		}

		param += "&pln_yrmon=" + frm.pln_yrmon.value;
		param += "&gen_expn_cd=" + frm.fm_gen_expn_cd.value ;
		
		initToItem();
		
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
		
		param += "lang_div=" + ComGetObjValue(frm.lang_div);
		param += "&f_cmd=" + SEARCHLIST02;
		param += "&pln_yrmon=" + frm.pln_yrmon.value;
		param += "&ofc_cd=" + frm.to_ofc_lvl3.value;
		
		var authFlg = frm.auth_flg.value;
		
		if (authFlg != 'YNYY') {
			param += "&tic_cd=" + frm.usr_tic_cd.value;
		}
		
		param += "&gen_expn_group_cd=" + frm.fm_gen_expn_group_cd.value;
		param += "&gen_expn_cd=" + frm.to_gen_expn_cd.value ;
	
	}
	
	
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_01GS.do", param);	
	var genExpnInfoList = ComXml2ListMap(sXml);
	
	if (genExpnInfoList.length == 0) {
	    //msgs["GEM01039"] = "오피스코드에 대한 비용코드가 존재하지 않습니다.";
		ComShowCodeMessage("GEM01039");
		if (div == "FM") {
			
			ComSetObjValue(frm.fm_gen_expn_cd , "");			
			ComSetObjValue(frm.fm_gen_expn_cd_abbr_name, "");
			frm.fm_chk_assigned.checked = false;
			
			ComSetObjValue(frm.fm_tic_cd, "");
			ComSetObjValue(frm.fm_gen_expn_itm_no, "");
			ComSetObjValue(frm.fm_gen_expn_itm_desc, "");	
			
			disableToItem();
			initItem();
			initToExpnItem();
			
			//시트 assigned 지우기
			var janCol = sheet2.SaveNameCol("jan_amt")
			var decCol = sheet2.SaveNameCol("dec_amt")
			
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet2.CellValue2(1,i) = 0;
				sheet2.CellValue2(3,i) = 0;
			}
			
			frm.fm_gen_expn_cd.focus();
			
		} else if (div == "TO") {
			initToExpnItem();		
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

	    if (ComGetObjValue(frm.lang_div) == "KOR") {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_krn_abbr_nm.value;
	    } else {
	    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_eng_abbr_nm.value;
	    }
	    
	    ComSetObjValue(frm.fm_gen_expn_group_cd , expenseInfo["gen_expn_group_cd"]);
	    
	    ComSetObjValue(frm.fm_gen_expn_itm_no , itemNo);
	    
		//From Assigned Expense 호출
		setTimeout("openPopup1()",500);
	    	    
	} else if (div == "TO") {
		ComSetObjValue(frm.to_gen_expn_cd ,expenseInfo["gen_expn_cd"]);
		ComSetObjValue(frm.to_tic_cd , expenseInfo["tic_cd"]);
		ComSetObjValue(frm.to_krn_abbr_nm , expenseInfo["krn_abbr_nm"]);
	    ComSetObjValue(frm.to_eng_abbr_nm , expenseInfo["eng_abbr_nm"]);
	    
	    if (ComGetObjValue(frm.lang_div) == "KOR") {
	    	frm.to_gen_expn_cd_abbr_name.value = frm.to_krn_abbr_nm.value;
	    } else {
	    	frm.to_gen_expn_cd_abbr_name.value = frm.to_eng_abbr_nm.value;
	    }

	    ComSetObjValue(frm.to_gen_expn_itm_no , itemNo);
	}
	
	//복사
	setFormToSheet1();
	
}
  
  
/**                                                                                                                                                                                                                                                                                                
 * 폼데이타 (item + apro_step) 을 sheet1에 ofc_cd , gen_expn_cd , item별 저장                                                                                                                                                                                                                      
 * @param {long} row 시트 행번호                                                                                                                                                                                                                                                                   
 */                                                                                                                                                                                                                                                                                                
function setFormToSheet1() {
	 	/*
	 	   	
	 	   var fm_gen_expn_rqst_seq = frm.fm_gen_expn_rqst_seq.value;
		 	
			if (ComIsNull(fm_gen_expn_rqst_seq)) {
				sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = getMaxSeq();
			} else {
				sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = fm_gen_expn_rqst_seq;
			}
			
			frm.fm_gen_expn_rqst_seq.value = "";
		*/
	 
		//isIng = true;
		
	    var row = frm.rownum.value;
		
		if (row >  1) {
			
			sheet1.CellValue2(row,"fm_gen_expn_trns_div_cd") = "F";
		 	sheet1.CellValue2(row,"fm_sls_ofc_div_cd") = checkBoxValue(frm.fm_sls_ofc_div_cd);
			sheet1.CellValue2(row,"fm_ofc_cd") = frm.fm_ofc_lvl3.value;
			sheet1.CellValue2(row,"fm_ofc_lvl1") = frm.fm_ofc_lvl1.value;
			sheet1.CellValue2(row,"fm_ofc_lvl2") = frm.fm_ofc_lvl2.value;
			
			sheet1.CellValue2(row,"fm_gen_expn_cd") = ComGetObjValue(frm.fm_gen_expn_cd);
			sheet1.CellValue2(row,"fm_eng_abbr_nm") = ComGetObjValue(frm.fm_eng_abbr_nm);
			sheet1.CellValue2(row,"fm_krn_abbr_nm") = ComGetObjValue(frm.fm_krn_abbr_nm);
			sheet1.CellValue2(row,"fm_tic_cd") = ComGetObjValue(frm.fm_tic_cd);
	
			sheet1.CellValue2(row,"fm_chk_assigned") = checkBoxValue(frm.fm_chk_assigned);
			sheet1.CellValue2(row,"fm_gen_expn_itm_no") = ComGetObjValue(frm.fm_gen_expn_itm_no);
			sheet1.CellValue2(row,"fm_gen_expn_itm_desc") = ComGetObjValue(frm.fm_gen_expn_itm_desc);
			sheet1.CellValue2(row,"fm_gen_expn_calc_bss_desc") = "";
			sheet1.CellValue2(row,"fm_rqst_opin_rmk") = "";
			
			sheet1.CellValue2(row,"fm_locl_curr_cd") = 
				document.getElementById("fm_locl_curr_cd").innerText;		
			sheet1.CellValue2(row,"fm_rqst_ut_val") = ComGetObjValue(frm.fm_rqst_ut_val);
			sheet1.CellValue2(row,"fm_rqst_locl_amt") = ComGetObjValue(frm.fm_rqst_locl_amt);			
			
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
			sheet1.CellValue2(row,"fm_ttl") = sheet2.CellValue(3,"ttl");
			
			sheet1.CellValue2(row,"to_gen_expn_rqst_seq") = sheet1.CellValue(row,"fm_gen_expn_rqst_seq");
			sheet1.CellValue2(row,"to_gen_expn_trns_div_cd") = "T";
			sheet1.CellValue2(row,"to_sls_ofc_div_cd") = checkBoxValue(frm.to_sls_ofc_div_cd);
			sheet1.CellValue2(row,"to_ofc_cd") = frm.to_ofc_lvl3.value;
			sheet1.CellValue2(row,"to_ofc_lvl1") = frm.to_ofc_lvl1.value;
			sheet1.CellValue2(row,"to_ofc_lvl2") = frm.to_ofc_lvl2.value;
			
			sheet1.CellValue2(row,"to_gen_expn_cd") = ComGetObjValue(frm.to_gen_expn_cd);
			sheet1.CellValue2(row,"to_eng_abbr_nm") = ComGetObjValue(frm.to_eng_abbr_nm);
			sheet1.CellValue2(row,"to_krn_abbr_nm") = ComGetObjValue(frm.to_krn_abbr_nm);
			sheet1.CellValue2(row,"to_tic_cd") = ComGetObjValue(frm.to_tic_cd);
	
			sheet1.CellValue2(row,"to_chk_assigned") = checkBoxValue(frm.to_chk_assigned);
			sheet1.CellValue2(row,"to_gen_expn_itm_no") = ComGetObjValue(frm.to_gen_expn_itm_no);
			sheet1.CellValue2(row,"to_gen_expn_itm_desc") = ComGetObjValue(frm.to_gen_expn_itm_desc);
			sheet1.CellValue2(row,"to_gen_expn_calc_bss_desc") = ComGetObjValue(frm.to_gen_expn_calc_bss_desc);
			sheet1.CellValue2(row,"to_rqst_opin_rmk") = ComGetObjValue(frm.to_rqst_opin_rmk);
			
			sheet1.CellValue2(row,"to_locl_curr_cd") = 
				document.getElementById("to_locl_curr_cd").innerText;		
			sheet1.CellValue2(row,"to_rqst_ut_val") = ComGetObjValue(frm.to_rqst_ut_val);
			sheet1.CellValue2(row,"to_rqst_locl_amt") = ComGetObjValue(frm.to_rqst_locl_amt);
			
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
			sheet1.CellValue2(row,"to_ttl") = sheet2.CellValue(4,"ttl");
			
			//USD total;
			var usdTotal = getUsdTotal();
			
			frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,0));
		}
	             
		
}                                                                                                                                                                                                                                                                                                    
          
 
 
 
/**                                                                                                                                                                                                                                                                                                  
* 시트 sheet1에데이타를 form,sheet2에 설정                                                                                                                                                                                                                                                          
* @param {long} row 시트 행번호                                                                                                                                                                                                                                                                     
*/                                                                                                                                                                                                                                                                                                  
function setSheet1ToForm( row ) {   
	
	
	ComSetObjValue(frm.fm_gen_expn_rqst_seq , sheet1.CellValue(row , "fm_gen_expn_rqst_seq"));
	
	var fm_sls_ofc_div_cd = sheet1.CellValue(row , "fm_sls_ofc_div_cd");	
	if (fm_sls_ofc_div_cd == "N") {
		frm.fm_sls_ofc_div_cd[0].checked = true;
	} else if (fm_sls_ofc_div_cd == "Y") {
		frm.fm_sls_ofc_div_cd[1].checked = true;
	}
	
	//LV1
	ComSetObjValue(frm.fm_ofc_lvl1 , sheet1.CellValue(row , "fm_ofc_lvl1"));
	//LV2
	if (!ComIsNull(frm.fm_ofc_lvl1.value)) {
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');
		frm.fm_ofc_lvl2.value = sheet1.CellValue(row , "fm_ofc_lvl2");
	}
	//LV3
	if (!ComIsNull(frm.fm_ofc_lvl2.value)) {
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');			
		frm.fm_ofc_lvl3.value = sheet1.CellValue(row , "fm_ofc_cd");	
	}
	
	focusOut();
	
	ComSetObjValue(frm.fm_gen_expn_cd   , sheet1.CellValue(row , "fm_gen_expn_cd"));
	ComSetObjValue(frm.fm_rqst_locl_amt , sheet1.CellText(row , "fm_rqst_locl_amt"));
	ComSetObjValue(frm.fm_rqst_usd_amt  , sheet1.CellText(row , "fm_rqst_usd_amt"));
	
	ComSetObjValue(frm.fm_eng_abbr_nm   , sheet1.CellValue(row , "fm_eng_abbr_nm"));
	ComSetObjValue(frm.fm_krn_abbr_nm   , sheet1.CellValue(row , "fm_krn_abbr_nm"));
	
    if (ComGetObjValue(frm.lang_div) == "KOR") {
    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_krn_abbr_nm.value;
    } else {
    	frm.fm_gen_expn_cd_abbr_name.value = frm.fm_eng_abbr_nm.value;
    }	
	
	document.getElementById("fm_locl_curr_cd").innerText = sheet1.CellValue(row , "fm_locl_curr_cd");	
	ComSetObjValue(frm.fm_rqst_ut_val   , sheet1.CellText(row , "fm_rqst_ut_val"));
	
	var fm_usd_locl_xch_rt =  sheet1.CellValue(row , "fm_usd_locl_xch_rt");
	ComSetObjValue(frm.fm_usd_locl_xch_rt   , ComAddComma(fm_usd_locl_xch_rt));
	
	
	ComSetObjValue(frm.fm_tic_cd   , sheet1.CellValue(row , "fm_tic_cd"));
	
	if (sheet1.CellValue(row , "fm_chk_assigned") == "Y") {
		frm.fm_chk_assigned.checked = true;		
	}
	
	ComSetObjValue(frm.fm_gen_expn_itm_no   , sheet1.CellValue(row , "fm_gen_expn_itm_no"));
	ComSetObjValue(frm.fm_gen_expn_itm_desc , sheet1.CellValue(row , "fm_gen_expn_itm_desc"));
	ComSetObjValue(frm.fm_gen_expn_calc_bss_desc , sheet1.CellValue(row , "fm_gen_expn_calc_bss_desc"));
	ComSetObjValue(frm.fm_rqst_opin_rmk , sheet1.CellValue(row , "fm_rqst_opin_rmk"));

	sheet2.CellValue2(1 ,"jan_amt") = sheet1.CellValue(row , "fm_jan_amt");
	sheet2.CellValue2(1 ,"feb_amt") = sheet1.CellValue(row , "fm_feb_amt");
	sheet2.CellValue2(1 ,"mar_amt") = sheet1.CellValue(row , "fm_mar_amt");
	sheet2.CellValue2(1 ,"apr_amt") = sheet1.CellValue(row , "fm_apr_amt");
	sheet2.CellValue2(1 ,"may_amt") = sheet1.CellValue(row , "fm_may_amt");
	sheet2.CellValue2(1 ,"jun_amt") = sheet1.CellValue(row , "fm_jun_amt");
	sheet2.CellValue2(1 ,"jul_amt") = sheet1.CellValue(row , "fm_jul_amt");
	sheet2.CellValue2(1 ,"aug_amt") = sheet1.CellValue(row , "fm_aug_amt");
	sheet2.CellValue2(1 ,"sep_amt") = sheet1.CellValue(row , "fm_sep_amt");
	sheet2.CellValue2(1 ,"oct_amt") = sheet1.CellValue(row , "fm_oct_amt");
	sheet2.CellValue2(1 ,"nov_amt") = sheet1.CellValue(row , "fm_nov_amt");
	sheet2.CellValue2(1 ,"dec_amt") = sheet1.CellValue(row , "fm_dec_amt");

	sheet2.CellValue2(3 ,"jan_amt") = sheet1.CellValue(row , "fm_rqst_jan_amt");
	sheet2.CellValue2(3 ,"feb_amt") = sheet1.CellValue(row , "fm_rqst_feb_amt");
	sheet2.CellValue2(3 ,"mar_amt") = sheet1.CellValue(row , "fm_rqst_mar_amt");
	sheet2.CellValue2(3 ,"apr_amt") = sheet1.CellValue(row , "fm_rqst_apr_amt");
	sheet2.CellValue2(3 ,"may_amt") = sheet1.CellValue(row , "fm_rqst_may_amt");
	sheet2.CellValue2(3 ,"jun_amt") = sheet1.CellValue(row , "fm_rqst_jun_amt");
	sheet2.CellValue2(3 ,"jul_amt") = sheet1.CellValue(row , "fm_rqst_jul_amt");
	sheet2.CellValue2(3 ,"aug_amt") = sheet1.CellValue(row , "fm_rqst_aug_amt");
	sheet2.CellValue2(3 ,"sep_amt") = sheet1.CellValue(row , "fm_rqst_sep_amt");
	sheet2.CellValue2(3 ,"oct_amt") = sheet1.CellValue(row , "fm_rqst_oct_amt");
	sheet2.CellValue2(3 ,"nov_amt") = sheet1.CellValue(row , "fm_rqst_nov_amt");
	sheet2.CellValue2(3 ,"dec_amt") = sheet1.CellValue(row , "fm_rqst_dec_amt");

	
	
	// -------------------------------------
	ComSetObjValue(frm.to_gen_expn_rqst_seq , sheet1.CellValue(row , "to_gen_expn_rqst_seq"));
	
	var to_sls_ofc_div_cd = sheet1.CellValue(row , "to_sls_ofc_div_cd");	
	if (to_sls_ofc_div_cd == "N") {
		frm.to_sls_ofc_div_cd[0].checked = true;
	} else if (to_sls_ofc_div_cd == "Y") {
		frm.to_sls_ofc_div_cd[1].checked = true;
	}
	
	//LV1
	ComSetObjValue(frm.to_ofc_lvl1 , sheet1.CellValue(row , "to_ofc_lvl1"));
	//LV2
	if (!ComIsNull(frm.to_ofc_lvl1.value)) {
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','to_sls_ofc_div_cd','1','document.form.to_ofc_lvl');
		frm.to_ofc_lvl2.value = sheet1.CellValue(row , "to_ofc_lvl2");
	}
	//LV3
	if (!ComIsNull(frm.to_ofc_lvl2.value)) {	
		selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','to_sls_ofc_div_cd','2','document.form.to_ofc_lvl');			
		frm.to_ofc_lvl3.value = sheet1.CellValue(row , "to_ofc_cd");
	}
	
	frm.to_ofc_lvl3.blur();
	
	ComSetObjValue(frm.to_gen_expn_cd   , sheet1.CellValue(row , "to_gen_expn_cd"));
	ComSetObjValue(frm.to_rqst_locl_amt , sheet1.CellText(row , "to_rqst_locl_amt"));
	ComSetObjValue(frm.to_rqst_usd_amt  , sheet1.CellText(row , "to_rqst_usd_amt"));	
		
	ComSetObjValue(frm.to_eng_abbr_nm   , sheet1.CellValue(row , "to_eng_abbr_nm"));
	ComSetObjValue(frm.to_krn_abbr_nm   , sheet1.CellValue(row , "to_krn_abbr_nm"));
	
    if (ComGetObjValue(frm.lang_div) == "KOR") {
    	frm.to_gen_expn_cd_abbr_name.value = frm.to_krn_abbr_nm.value;
    } else {
    	frm.to_gen_expn_cd_abbr_name.value = frm.to_eng_abbr_nm.value;
    }
	
	document.getElementById("to_locl_curr_cd").innerText = sheet1.CellValue(row , "to_locl_curr_cd");
	ComSetObjValue(frm.to_rqst_ut_val   , sheet1.CellText(row , "to_rqst_ut_val"));
	
	var to_usd_locl_xch_rt =  sheet1.CellValue(row , "to_usd_locl_xch_rt");
	ComSetObjValue(frm.to_usd_locl_xch_rt   , ComAddComma(to_usd_locl_xch_rt));
	ComSetObjValue(frm.to_tic_cd   , sheet1.CellValue(row , "to_tic_cd"));

	
	ComSetObjValue(frm.to_gen_expn_itm_no   , sheet1.CellValue(row , "to_gen_expn_itm_no"));
	ComSetObjValue(frm.to_gen_expn_itm_desc , sheet1.CellValue(row , "to_gen_expn_itm_desc"));
	ComSetObjValue(frm.to_gen_expn_calc_bss_desc , sheet1.CellValue(row , "to_gen_expn_calc_bss_desc"));
	ComSetObjValue(frm.to_rqst_opin_rmk , sheet1.CellValue(row , "to_rqst_opin_rmk"));

	sheet2.CellValue2(2 ,"jan_amt") = sheet1.CellValue(row , "to_jan_amt");
	sheet2.CellValue2(2 ,"feb_amt") = sheet1.CellValue(row , "to_feb_amt");
	sheet2.CellValue2(2 ,"mar_amt") = sheet1.CellValue(row , "to_mar_amt");
	sheet2.CellValue2(2 ,"apr_amt") = sheet1.CellValue(row , "to_apr_amt");
	sheet2.CellValue2(2 ,"may_amt") = sheet1.CellValue(row , "to_may_amt");
	sheet2.CellValue2(2 ,"jun_amt") = sheet1.CellValue(row , "to_jun_amt");
	sheet2.CellValue2(2 ,"jul_amt") = sheet1.CellValue(row , "to_jul_amt");
	sheet2.CellValue2(2 ,"aug_amt") = sheet1.CellValue(row , "to_aug_amt");
	sheet2.CellValue2(2 ,"sep_amt") = sheet1.CellValue(row , "to_sep_amt");
	sheet2.CellValue2(2 ,"oct_amt") = sheet1.CellValue(row , "to_oct_amt");
	sheet2.CellValue2(2 ,"nov_amt") = sheet1.CellValue(row , "to_nov_amt");
	sheet2.CellValue2(2 ,"dec_amt") = sheet1.CellValue(row , "to_dec_amt");
                  
	sheet2.CellValue2(4 ,"jan_amt") = sheet1.CellValue(row , "to_rqst_jan_amt");
	sheet2.CellValue2(4 ,"feb_amt") = sheet1.CellValue(row , "to_rqst_feb_amt");
	sheet2.CellValue2(4 ,"mar_amt") = sheet1.CellValue(row , "to_rqst_mar_amt");
	sheet2.CellValue2(4 ,"apr_amt") = sheet1.CellValue(row , "to_rqst_apr_amt");
	sheet2.CellValue2(4 ,"may_amt") = sheet1.CellValue(row , "to_rqst_may_amt");
	sheet2.CellValue2(4 ,"jun_amt") = sheet1.CellValue(row , "to_rqst_jun_amt");
	sheet2.CellValue2(4 ,"jul_amt") = sheet1.CellValue(row , "to_rqst_jul_amt");
	sheet2.CellValue2(4 ,"aug_amt") = sheet1.CellValue(row , "to_rqst_aug_amt");
	sheet2.CellValue2(4 ,"sep_amt") = sheet1.CellValue(row , "to_rqst_sep_amt");
	sheet2.CellValue2(4 ,"oct_amt") = sheet1.CellValue(row , "to_rqst_oct_amt");
	sheet2.CellValue2(4 ,"nov_amt") = sheet1.CellValue(row , "to_rqst_nov_amt");
	sheet2.CellValue2(4 ,"dec_amt") = sheet1.CellValue(row , "to_rqst_dec_amt");
		
	if (sheet2.CellValue(1,"ttl") > 0) {
		frm.fm_chk_assigned.checked = true;
	} else {
		frm.fm_chk_assigned.checked = false;
	}	
	
	if (sheet2.CellValue(2,"ttl") > 0) {
		frm.to_chk_assigned.checked = true;
	} else {
		frm.to_chk_assigned.checked = false;
	}
	
	if (!ComIsNull(frm.fm_gen_expn_cd.value) && 
			frm.fm_gen_expn_cd.value == frm.to_gen_expn_cd.value) {
		frm.same_expn_cd.checked = true;
	} else {
		frm.same_expn_cd.checked = false;
	}
	
	if (!ComIsNull(frm.fm_ofc_lvl3.value) && 
			frm.fm_ofc_lvl3.value == frm.to_ofc_lvl3.value) {
		frm.same_ofc_cd.checked = true;
	} else {
		frm.same_ofc_cd.checked = false;
	}
	
	//조회시 disable
	var retrieveYn = sheet1.CellValue(row , "retrieve_yn");
	

	
	if ("Y" == retrieveYn) {
		disableFromItem();
		disableToItem();	
		frm.to_chk_assigned.disabled = true;
		frm.to_gen_expn_itm_desc.readOnly = true;
	} else {
		enableFromItem();
		if (frm.fm_chk_assigned.checked) {
			enableToItem();
		} else {
			disableToItem();
		}
		
	}
	
	//2009-10-05  추가 
	frm.req_upd_dt.value = sheet1.CellValue(row, "req_upd_dt");
	frm.itm_upd_dt.value = sheet1.CellValue(row, "itm_upd_dt");
	
	frm.rownum.value = row;

}


/**                                                                                                                                                                                                                                                                                                  
 * 폼 초기화                                                                                                                                                                                                                                                                      
 */                                                                                                                                                                                                                                                                                                      
function resetForm() {                             
	
    //권한 설정
	var authFlg = frm.auth_flg.value;	  
    
	frm.fm_sls_ofc_div_cd[0].checked=false;
	frm.fm_sls_ofc_div_cd[1].checked=false;	
	
    initFromItem();
	ComSetObjValue(frm.fm_rqst_locl_amt , "");
	ComSetObjValue(frm.fm_rqst_usd_amt , "");	
	ComSetObjValue(frm.fm_rqst_ut_val, "");
	ComSetObjValue(frm.fm_usd_locl_xch_rt, "");
	document.getElementById("fm_locl_curr_cd").innerText = "";
	
	initToItem();	
	ComSetObjValue(frm.to_rqst_locl_amt, "");		
	ComSetObjValue(frm.to_rqst_ut_val, "");
	ComSetObjValue(frm.to_usd_locl_xch_rt, "");
	document.getElementById("to_locl_curr_cd").innerText = "";
	
	frm.to_chk_assigned.disabled = false;
	frm.to_gen_expn_itm_desc.readOnly = false;
	
	var rowCnt = SheetRowCount(sheet1);		
	//밑줄 표시				
	if (rowCnt > 0 ) {
		var fNum = FirstRowNum(sheet1);
		var usdTotal = getUsdTotal();
		frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,0));			
	}

	
	//Assignment Rule
	frm.fm_assign_rule.checked = false;
	frm.to_assign_rule.checked = false;

	ComEnableObject(frm.fm_monthFrom, false);
	ComEnableObject(frm.fm_monthTo, false);
	frm.fm_monthTo.value = "";
	ComEnableObject(frm.to_monthFrom, false);
	ComEnableObject(frm.to_monthTo, false);
	frm.to_monthTo.value = "";
	
	for ( var i = 0; i < 4; i++) {
		var row = i  + 1;
		sheet2.CellValue2(row , "jan_amt")           =  0;
		sheet2.CellValue2(row , "feb_amt")           =  0;
		sheet2.CellValue2(row , "mar_amt")           =  0;
		sheet2.CellValue2(row , "apr_amt")           =  0;
		sheet2.CellValue2(row , "may_amt")           =  0;
		sheet2.CellValue2(row , "jun_amt")           =  0;
		sheet2.CellValue2(row , "jul_amt")           =  0;
		sheet2.CellValue2(row , "aug_amt")           =  0;
		sheet2.CellValue2(row , "sep_amt")           =  0;
		sheet2.CellValue2(row , "oct_amt")           =  0;
		sheet2.CellValue2(row , "nov_amt")           =  0;
		sheet2.CellValue2(row , "dec_amt")           =  0;
	}
		                                                                                                                                                                                                                                       
}                                                                                                                                                                                                                                                                                                    

 /**                                                                                                                                                                                                                                                                                                  
  * 선택된 행번호                                                                                                                                                                                                                                                                      
  */ 
function getRowNum() {	
	  
	var genExpnRqstSeq = frm.fm_gen_expn_rqst_seq.value;
	
	var cnt = sheet1.RowCount;	
	var row = 0 ;	
	for ( var i = 0; i < cnt ; i++) {
		row = i + 2;
		if (sheet1.RowStatus(row) == "D") {
			continue;
		}
		
		var gen_expn_rqst_seq = sheet1.CellValue(row , "fm_gen_expn_rqst_seq");
		
		if (genExpnRqstSeq == gen_expn_rqst_seq) {
			return row;
		}
		
	}
	
	return -1;
	
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
  * fm Assigned Expense popup                                                                                                                                                                                                                                                                      
  */    
function openPopup1() {
	var gen_expn_cd = frm.fm_gen_expn_cd.value;	
	var ofc_cd = frm.fm_ofc_lvl3.value;
	var pln_yrmon= frm.pln_yr.value;
	
	var param = "gen_expn_cd=" + gen_expn_cd;
	param += "&ofc_cd=" + ofc_cd;
	param += "&pln_yrmon=" + frm.pln_yrmon.value;
	param += "&lang_div=" + ComGetObjValue(frm.lang_div);
	var url = "CPS_GEM_0104.do?"+param;
	var winName = "CPS_GEM_0104";
	
	if (assWin != null) {
		assWin.close();
	}
	
	assWin = ComOpenWindowCenter(url,winName,800,350);		
	frm.fm_chk_assigned.checked = false;
	assWinDiv ="FM";
	
	return assWin;
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
	case "t2btn_RowAdd":
		setFormToSheet1();
		var row = sheet1.DataInsert(-1);			
		frm.rownum.value = row;		
		//시퀀스 데이타 설정
		sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = getMaxSeq();
		//이전폼 클리어
		resetForm();
		enableFromItem();
		disableToItem();
		break;
	case "t2btn_Delete":		
		var arrRow = selectRowNum(sheet1);		
		if (arrRow != null && arrRow.length > 0 ) {		
			ComRowDelete(sheet1, "delChk");
			frm.rownum.value = "-1";
			//이전폼 클리어
			resetForm();
		}		
		break;
	case "t2btns_Authorized1":
		
		if (!ComChkObjValid(frm.fm_ofc_lvl3)) {
			return;
		}
		
		var row = frm.rownum.value;
		
		//조회시 disable
		var retrieveYn = sheet1.CellValue(row , "retrieve_yn");
		
		if (retrieveYn=="Y") {
			return;
		}
		
		var param = "lang_div=" + ComGetObjValue(frm.lang_div);
		param += "&ofc_cd=" + frm.fm_ofc_lvl3.value;		
		
		var authFlg = frm.auth_flg.value;
		
		if (authFlg != 'YNYY') {
			param += "&usr_tic_cd=" + frm.usr_tic_cd.value;
		}
		
		param += "&sel_div=S";		
		var url = "CPS_GEM_0101.do?"+param;
		var winName = "CPS_GEM_0101";
		
		if (authWin != null) {
			authWin.close();
		}
		
		authWin = ComOpenWindowCenter(url,winName,700,460, false);
		authWinDiv = "FM";
		
		break;
	case "t2btns_Authorized2":
		
		if (!ComChkObjValid(frm.to_ofc_lvl3) ||
				ComIsNull(frm.fm_gen_expn_cd.value) ) {
			return;
		}
		
		//조회시 disable
		var row = frm.rownum.value;
		var retrieveYn = sheet1.CellValue(row , "retrieve_yn");
		
		if (retrieveYn=="Y") {
			return;
		}

		
		var param = "lang_div=" + ComGetObjValue(frm.lang_div);
		param += "&ofc_cd=" + frm.to_ofc_lvl3.value;
		param += "&usr_tic_cd=" + frm.fm_tic_cd.value;
		param += "&gen_expn_group_cd=" + frm.fm_gen_expn_group_cd.value;
		param += "&sel_div=S";
		var url = "CPS_GEM_0101.do?"+param;
		var winName = "CPS_GEM_0101";
		
		if (authWin != null) {
			authWin.close();
		}
		authWin = ComOpenWindowCenter(url,winName,700,460, false);
		authWinDiv = "TO";
		
		
		break;		
	case "fm_chk_assigned":
		/*
		var win = openPopup1();
		win.focus();
		*/
		break;
	case "to_chk_assigned":
		
		if (frm.to_chk_assigned.checked) {
			var gen_expn_cd = frm.to_gen_expn_cd.value;	
			var ofc_cd = frm.to_ofc_lvl3.value;
			var pln_yrmon= frm.pln_yrmon.value;
			var param = "gen_expn_cd=" + gen_expn_cd;
			param += "&ofc_cd=" + ofc_cd;
			param += "&pln_yrmon=" + pln_yrmon ;
			param += "&lang_div=" + ComGetObjValue(frm.lang_div);
			var url = "CPS_GEM_0104.do?"+param;
			var winName = "CPS_GEM_0104";
			
			if (assWin != null) {
				assWin.close();
			}
			assWin = ComOpenWindowCenter(url,winName,800,350, false);		
			frm.to_chk_assigned.checked = false;			
			assWinDiv ="TO";
			assWin.focus();
			
		} else {
			
			//이전의 아이템번호가 존재 하지 않을경우 item no 취득	
			var plnYrmon =  frm.pln_yrmon.value;
			//서버에서 maxItem NO 취득
			var itemNo = searchMaxItem(plnYrmon ,
					                   frm.to_ofc_lvl3.value ,
					                   frm.to_gen_expn_cd.value);
			
			//시트에 존재하면 시트 maxNo + 1
			itemNo = getGenExpnItmNo(frm.to_ofc_lvl3.value  , 
					                 frm.to_gen_expn_cd.value , 
					                 itemNo);
			
			frm.to_gen_expn_itm_desc.readOnly = false;
			
			frm.to_gen_expn_itm_no.value = itemNo;
			frm.to_gen_expn_itm_desc.value = "";
			//시트 assigned 지우기
			var janCol = sheet2.SaveNameCol("jan_amt")
			var decCol = sheet2.SaveNameCol("dec_amt")
			
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet2.CellValue2(2,i) = 0;
			}
			
		}		
		break;	
	case "t1btn_Request":
		alert(srcName);
		break;	
	case "btn_Retrieve":
		frm.rownum.value = "-1";
		doActionIBSheet(SEARCHLIST);		
		break;	
	case "btn_New":
		//Do you want to initialize?
		if (ComShowCodeConfirm("GEM00011")) {
			/*
			ComResetAll();
		    //OPEN화면 호출
		    doActionIBSheet(INIT);
			*/
			location.reload();
			top.document.body.scrollTop = 0;
		}
		break;
	case "btn_Delete":
		frm.rownum.value = "-1";
		doActionIBSheet(REMOVE);
		break;
	case "btn_Save":
		
		if (sheet1.RowCount == 0) {
			//msgs["GEM01056"] = "There is no contents to save.";
			ComShowCodeMessage("GEM01056");
			return;
		}
		
		
		//GEM00012(Do you want to save changes?)
		if (ComShowCodeConfirm("GEM00012")) {
			setFormToSheet1();
						
			// <2009-10-12>
			// 다른사용자 변경여부 체크 및 request no 존재여부 체크
			var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;
			
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
					frm.gen_expn_rqst_no.focus();
					return;
				}
				
			}			
			// </2009-10-12> 
			
			if (validateSheet()) {				
				frm.rownum.value = "-1";
				doActionIBSheet(MULTI);				
			}
		}	
		break;
	case "btn_Print":
		if (!ComIsNull(frm.gen_expn_rqst_no.value)) {
			var url = "CPS_GEM_0103.do";		
			var winName = "CPS_GEM_0103";
			repWin = openWinCenter("about:blank",winName,700,410);
		    var frm3 = document.form3;
		    var langDiv = ComGetObjValue(frm.lang_div);
		    
		    frm3.rfn.value = "/CPS_GEM_0024.do?lang_div="+langDiv+"&gen_expn_rqst_no="+frm.gen_expn_rqst_no.value+"&pln_yrmon="+frm.pln_yrmon.value+"&f_cmd="+SEARCHLIST02;	    
		    frm3.mrd.value = "apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/report/CPS_GEM_0024.mrd";
		    
		    frm3.rv.value = "title[Expense Report - Transfer]";		    
		    frm3.title.value = "Expense Report - Transfer";		    
		    
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
	    frm1.rqst_ofc_cd.value = frm.fm_ofc_lvl3.value;
	    frm1.auth_flg.value = frm.auth_flg.value;
	    frm1.gen_expn_rqst_tp_cd.value = "ET";
	    frm1.action = url;        
	    frm1.target = winName;
	    frm1.submit();
	    frm1.target = "";	    
	    break;			
	// [init , addition] Radio button
	case "gen_expn_rqst_tp_cd":
		var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);	
		// 예산계획 차년도 설정
		if (gen_expn_rqst_tp_cd == "EI") {
			printClosingDate(initDateVO);			
			var clzYrmon = 	initDateVO["clz_yrmon"];			
			var clzYr = clzYrmon.substring(0,4);
			frm.pln_yr.value = clzYr;
			frm.pln_mon.value = "";
		} else {
			printClosingDate(closingDateVO);
			frm.pln_yr.value = curYear;
			frm.pln_mon.value = curMon;			
		}
		break;		
	// 수동, 자동 배정
	case "fm_assign_rule":
		var assign_rule = ComGetObjValue(frm.fm_assign_rule);		
		if (assign_rule == "Y") {
			ComEnableObject(frm.fm_monthFrom, true);
			ComEnableObject(frm.fm_monthTo, true);
		} else {
			ComEnableObject(frm.fm_monthFrom, false);
			ComEnableObject(frm.fm_monthTo, false);
		}
			
		break;		
	case "to_assign_rule":
		var assign_rule = ComGetObjValue(frm.to_assign_rule);		
		if (assign_rule == "Y") {
			ComEnableObject(frm.to_monthFrom, true);
			ComEnableObject(frm.to_monthTo, true);
		} else {
			ComEnableObject(frm.to_monthFrom, false);
			ComEnableObject(frm.to_monthTo, false);
		}
			
		break;		

    // Same FM Office
	case "same_ofc_cd":
		
		if (frm.same_ofc_cd.checked) {
			if (ComIsNull(frm.fm_ofc_lvl3.value)) {
				frm.same_ofc_cd.checked = false;
				return;
			}
			
			//오피스 조직코드 복사
			if (frm.fm_sls_ofc_div_cd[0].checked) {
				frm.to_sls_ofc_div_cd[0].checked = true; 
			} else {
				frm.to_sls_ofc_div_cd[0].checked = false;
			}
			
			if (frm.fm_sls_ofc_div_cd[1].checked) {
				frm.to_sls_ofc_div_cd[1].checked = true; 
			} else {
				frm.to_sls_ofc_div_cd[1].checked = false;
			}
			
			comboCopy(frm.fm_ofc_lvl1,frm.to_ofc_lvl1 ,true);
			comboCopy(frm.fm_ofc_lvl2,frm.to_ofc_lvl2 ,true);
			comboCopy(frm.fm_ofc_lvl3,frm.to_ofc_lvl3 ,true);
			
			//환율 설정 
			onChangeOfcLvl3("TO");
			
			//복사
			setFormToSheet1();
			
		} else {
			initToItem();
		}
		break;					
	// Same expense code
	case "same_expn_cd":
		if (frm.same_expn_cd.checked) {
			
			if (!frm.same_ofc_cd.checked) {
				frm.same_expn_cd.checked = false;
				return;
			}
			
			if (ComIsNull(frm.fm_gen_expn_cd.value)) {
				frm.same_expn_cd.checked = false;
				return;
			}
			
			ComSetObjValue(frm.to_gen_expn_cd , frm.fm_gen_expn_cd.value);
			ComSetObjValue(frm.to_eng_abbr_nm , frm.fm_eng_abbr_nm.value);
			ComSetObjValue(frm.to_krn_abbr_nm , frm.fm_krn_abbr_nm.value);

		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm.to_gen_expn_cd_abbr_name.value = frm.to_krn_abbr_nm.value;
		    } else {
		    	frm.to_gen_expn_cd_abbr_name.value = frm.to_eng_abbr_nm.value;
		    }

			ComSetObjValue(frm.to_gen_expn_itm_no , frm.fm_gen_expn_itm_no.value);
			ComSetObjValue(frm.to_gen_expn_itm_desc , frm.fm_gen_expn_itm_desc.value);
			ComSetObjValue(frm.to_tic_cd , frm.fm_tic_cd.value);
			
			if ( frm.fm_chk_assigned.checked ) {
				frm.to_chk_assigned.checked = true;
				
				frm.to_gen_expn_itm_desc.readOnly = true;				
				//Assigned amt복사 
				for ( var col = 2; col <= sheet2.LastCol; col++) {
					sheet2.CellValue2(2,col) = sheet2.CellValue(1,col);
				}				
				
			} else {
				frm.to_chk_assigned.checked = false;
				
			}
			
			
			//복사
			setFormToSheet1();

		} else {			
			initToItem();
			initToExpnItem();
		}
		break;				
	} 
		
}


/**                                                                                                                                                                                                                                                                                                  
* 총금액 자동 배정                                                                                                                                                                                                                                                                      
*/         
function onChangeFmMonthTo() {

	var rqst_locl_amt = frm.fm_rqst_locl_amt;
	
	if (ComIsNull(rqst_locl_amt.value) || rqst_locl_amt.value == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm.fm_monthTo.value = "";
		frm.fm_rqst_locl_amt.focus();
		return;
	}
	
	//Assignment Rule
	var assign_rule = frm.fm_assign_rule;
	
	if (assign_rule.checked ) {
		var monthFrom = frm.fm_monthFrom.value;
		var monthTo = frm.fm_monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , "TO");
			frm.to_monthFrom.focus();
			return;		
		}
		
		monthFrom = parseInt(monthFrom, 10);
		monthTo = parseInt(monthTo, 10);
				
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(rqst_locl_amt, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		//초기화
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet2.CellValue2(3,i) = 0;
		}
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet2.CellValue(3,i) = avg;
			total += avg;
		}
		
		//나머지 금액은 첫번째 컬럼에 입력
		if (total <= locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet2.CellValue(3, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet2.CellValue(3, start) = (avg - diffAmt);
	    }			
	}
	
}


/**                                                                                                                                                                                                                                                                                                  
* 총금액 자동 배정                                                                                                                                                                                                                                                                      
*/         
function onChangeToMonthTo() {

	var rqst_locl_amt = frm.to_rqst_locl_amt.value;
	
	if (ComIsNull(rqst_locl_amt) || rqst_locl_amt == 0) {
		//GEM00003	ENG	W	{?msg1} 필수항목을 입력하여 주시기 바랍니다	{?msg1} 필수항목을 입력하여 주시기 바랍니다
		ComShowCodeMessage("GEM00003" , "RQST Amount");
		frm.to_monthTo.value = "";
		frm.to_rqst_locl_amt.focus();
		return;
	}
	
	//Assignment Rule
	var assign_rule = frm.to_assign_rule;
	
	if (assign_rule.checked ) {
		var monthFrom = frm.to_monthFrom.value;
		var monthTo = frm.to_monthTo.value;
		
		if (ComIsNull(monthTo)) {
			//GEM01038	ENG	W	Please select {?msg1} 	Please select {?msg1}
			ComShowCodeMessage("GEM01038" , "TO");
			frm.to_monthFrom.focus();
			return;		
		}
		
		monthFrom = parseInt(monthFrom, 10);
		monthTo = parseInt(monthTo, 10);
				
		var diff = monthTo - monthFrom + 1;
		
		var locl_amt = ComTrimAll(rqst_locl_amt, ",");
		
		var avg = ComRound(locl_amt / diff , 0);
		
		var janCol = sheet2.SaveNameCol("jan_amt")
		var decCol = sheet2.SaveNameCol("dec_amt")
		
		var start = janCol + monthFrom - 1;
		var end = janCol + monthTo - 1 ;
		//초기화
		for ( var i = janCol ; i <= decCol; i++) {		
			sheet2.CellValue2(4,i) = 0;
		}
		
		
		var total = 0;
		for ( var i = start ; i <= end; i++) {		
			sheet2.CellValue2(4,i) = avg;
			total += avg;
		}
	
		//나머지 금액은 첫번째 컬럼에 입력
		if (total <= locl_amt ) {
			var diffAmt = locl_amt - total;
			sheet2.CellValue2(4, start) = (avg + diffAmt);
		} else {
			var diffAmt =  total - locl_amt;
			sheet2.CellValue2(4, start) = (avg - diffAmt);
	    }			
	}
	
}


/**
* 오피스 변경시 code 체크 
*/
function onChangeOfcLvl3(div) {

	var plnYear = frm.pln_yr.value;
	
	
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
		if (!ComIsNull(frm.fm_rqst_locl_amt.value)) {
			setUsdAmt();
		}
		
		onClickToSlsOfcDivCd();
		
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
		if (!ComIsNull(frm.fm_rqst_locl_amt.value)) {
			setUsdAmt();
		}		
		
		
	}
	
	//복사 
	setFormToSheet1();
}


/**
* TO 오피스 HO , HQ클릭시 
*/
function onClickToSlsOfcDivCd() {
	frm.to_ofc_lvl1.value = "";
	frm.to_ofc_lvl2.length = 0;
	frm.to_ofc_lvl3.length = 0;
	frm.to_ofc_lvl3.blur();
}

/**
* To 오피스 LVL1 변경시 code 체크 
*/
function onChangeToOfcLvl1() {
	
	if (ComIsNull(frm.to_ofc_lvl1.value)) {
		frm.to_ofc_lvl2.length = 0;
		frm.to_ofc_lvl3.length = 0;
		return;
	}

	
	var param = "f_cmd=" + SEARCHLIST01;
	var to_sls_ofc_div_cd = checkBoxValue(frm.to_sls_ofc_div_cd);
	param += "&to_sls_ofc_div_cd=" + to_sls_ofc_div_cd;
	param += "&to_ofc_lvl1=" + frm.to_ofc_lvl1.value;
	param += "&fm_ofc_lvl2=" + frm.fm_ofc_lvl2.value;
	param += "&fm_ofc_lvl3=" + frm.fm_ofc_lvl3.value;
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_02GS.do", param);	
	var etcData = ComGetEtcData(sXml, "to_ofc_lvl2");	
	if (!ComIsNull(etcData)) {
		var comboListData = etcData.split("|");	
		if(typeof comboListData != "undefined" && comboListData != "") {
			var ofcLvl = frm.to_ofc_lvl2;
			ofcLvl.length = 0;
			ComAddComboItem(ofcLvl,"","");
			
			for(var i=0 ; i < comboListData.length ; i++ ) {
				ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
			}
			
			frm.to_ofc_lvl3.length = 0;
		}
	} else {
		frm.to_ofc_lvl2.length = 0;
		frm.to_ofc_lvl3.length = 0;
	}

}


/**
* To 오피스 LVL2 변경시 code 체크 
*/
function onChangeToOfcLvl2() {
	
	if (ComIsNull(frm.to_ofc_lvl2.value)) {
		frm.to_ofc_lvl3.length = 0;
		return;
	}
	
	if (!frm.to_sls_ofc_div_cd[0].checked &&
			!frm.to_sls_ofc_div_cd[1].checked ) {
		// HO or HQ를 선택하세요.
		ComShowCodeMessage("GEM01038","an office type");		
		frm.to_ofc_lvl3.value = "";
		frm.to_sls_ofc_div_cd[0].focus();
		return;
	}
	
	var param = "f_cmd=" + SEARCHLIST02;
	var to_sls_ofc_div_cd = checkBoxValue(frm.to_sls_ofc_div_cd);
	param += "&to_sls_ofc_div_cd=" + to_sls_ofc_div_cd;
	param += "&to_ofc_lvl2=" + frm.to_ofc_lvl2.value;
	param += "&fm_ofc_lvl2=" + frm.fm_ofc_lvl2.value;
	param += "&fm_ofc_lvl3=" + frm.fm_ofc_lvl3.value;
	var sXml = sheet3.GetSearchXml("CPS_GEM_0001_02GS.do", param);	
	var etcData = ComGetEtcData(sXml, "to_ofc_lvl3");	
	if (!ComIsNull(etcData)) {
		var comboListData = etcData.split("|");	
		if(typeof comboListData != "undefined" && comboListData != "") {
			var ofcLvl = frm.to_ofc_lvl3;
			ofcLvl.length = 0;
			ComAddComboItem(ofcLvl,"","");
			
			for(var i=0 ; i < comboListData.length ; i++ ) {
				ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
			}
		}
	} else {
		frm.to_ofc_lvl3.length = 0;
	}

	

}

/**
* To 오피스 LVL2 마우스 down시 
*/
function onMouseDownToOfcLvl2() {
	if (!frm.to_sls_ofc_div_cd[0].checked &&
			!frm.to_sls_ofc_div_cd[1].checked ) {
		// HO or HQ를 선택하세요.
		ComShowCodeMessage("GEM01038","an office type");		
		frm.to_ofc_lvl3.value = "";		
		frm.to_sls_ofc_div_cd[0].focus();		
	}
}


/**
* 계산식,  요청의견 노트 표시
*/
function showNote(obj , type) {
    
	
	var width = 600;
	var height = 370;
	var url = "CPS_GEM_0102.do";
	var winName = "CPS_GEM_0102";
	if (noteWin != null) {
		noteWin.close();
	}
	noteWin =  ComOpenWindowCenter(url,winName,width,height, false);

	var frm2 = document.form2;
	frm2.saveYn.value = "Y";
	var text = "";
	if (type == "A") {		
		text = frm.to_gen_expn_itm_desc.value;
		
		if (frm.to_chk_assigned.checked) {
			frm2.saveYn.value = "N";
		} else {
			frm2.saveYn.value = "Y";
		}
		
	} else if (type == "B") {
		text = frm.to_gen_expn_calc_bss_desc.value;		
	} else if (type == "C") {
		text = frm.to_rqst_opin_rmk.value;		
	} else if (type == "D") {
		text = frm.fm_gen_expn_itm_desc.value;
		frm2.saveYn.value = "N";
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
    //keyup
    axon_event.addListenerForm('keyup', 'obj_keyup', frm);
    // focus out
    axon_event.addListenerFormat('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);    
}
 
/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {	
    switch (event.srcElement.name) {    
    case "fm_rqst_locl_amt":
    	ComKeyOnlyNumber(event.srcElement,"-");    			
		if (frm.fm_rqst_locl_amt.value.length > 0 && event.keyCode == 13) {
			setUsdAmt();
		}   	
		break;
    case "fm_gen_expn_cd":
    	ComKeyOnlyNumber(event.srcElement);    			
		if (frm.fm_gen_expn_cd.value.length > 0 && event.keyCode == 13) {
			checkExpnInfo('FM');
		}   	
		break;
    case "to_gen_expn_cd":
    	ComKeyOnlyNumber(event.srcElement);    			
		if (frm.to_gen_expn_cd.value.length > 0 && event.keyCode == 13) {
			checkExpnInfo('TO');
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
  * HTML Control KeyPress 이벤트 호출
  */
 function obj_keyup() { 	
     switch (event.srcElement.name) {    
     case "fm_rqst_locl_amt":     
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
function obj_deactivate() {
	switch (event.srcElement.name) {
	case "fm_rqst_locl_amt":
				
		if (!ComChkObjValid(frm.fm_rqst_locl_amt)) {
			frm.fm_rqst_locl_amt.value = "";
			return;
		}		
		
		setUsdAmt();		
		setFormToSheet1();
		
		break;
		
	default:
		ComChkObjValid(event.srcElement);
	}
}
 
 /**
  * HTML Control Foucs in
  */
 function obj_activate(){	
	switch (event.srcElement.name) {
	case "fm_rqst_locl_amt":
	    ComClearSeparator(event.srcElement);	    
		break;
	default:
	    ComClearSeparator(event.srcElement);
	}
 } 
 
/**
 * LOC금액을  USD 금액으로 환산  계산
 **/
function setUsdAmt() {
	 
	//FM LOC
	var locl_amt = frm.fm_rqst_locl_amt.value;
	
	//FM USD
	var usd_xch_rt = frm.fm_usd_locl_xch_rt.value;
	
	//FM 단위
	var ut_val = frm.fm_rqst_ut_val.value;
	
	//USD
	frm.fm_rqst_usd_amt.value =  
		ComAddComma(Math.abs(getUsdAmt(locl_amt ,ut_val, usd_xch_rt)));
			
	var fm_locl_curr_cd =
		document.getElementById("fm_locl_curr_cd").innerText ;

	var to_locl_curr_cd =
		document.getElementById("to_locl_curr_cd").innerText ;
		
	if (fm_locl_curr_cd == to_locl_curr_cd) {		
		locl_amt = removeComma(locl_amt);
		frm.to_rqst_locl_amt.value = ComAddComma(Math.abs(locl_amt));
	} else {
		//TO USD
		var usdAmt = frm.fm_rqst_usd_amt.value;
		//TO 단위
		var toUnit = frm.to_rqst_ut_val.value;
		//TO RATE
		var toRate = frm.to_usd_locl_xch_rt.value;
		
		//KRW금액 계산 (USD / (UNIT*RATE)
		frm.to_rqst_locl_amt.value = 
			ComAddComma(Math.abs(getLclAmt( usdAmt ,toUnit ,toRate )));
		
	}
	
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
	

}


/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	/*
	if (!validateForm()) {
		return;
	}
	
	if (ComIsNull(frm.ofc_lvl3.value)) {
		return;
	}
	*/
	
	/*
	//이전행에 폼의  내용을 시트로 복사	
	setFormToSheet1();
	
	//현재행의 내용을 폼으로 복사 
	setSheet1ToForm(row);
	*/
	
	//sheet.SelectRow = frm.rownum.value;
	  
	
	
	//var sName = sheet1.ColSaveName(col);
	
	
	/*
	if (row < 2) {
		return;
	}

	
	//이전행에 폼의  내용을 시트로 복사	
	setFormToSheet1();
	
	//현재행의 내용을 폼으로 복사 
	setSheet1ToForm(row);
	*/	
}




/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	
	if(processing) {
		return;
	}
	
	processing = true;
	
	try {
		
		if (row < 2) {
			return;
		}
		
		var rownum = frm.rownum.value;
		
		if (row == rownum) {
			return;
		}
		
		//이전행에 폼의  내용을 시트로 복사	
		setFormToSheet1();
		
		//초기화
		resetForm();
		
		//현재행의 내용을 폼으로 복사 
		setSheet1ToForm(row);
		
		processing = false;
		
	} catch (e) {
		
	} finally {
		processing = false;
	}
	
}


/**
* sheet2 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value
*/
function sheet2_OnChange(sheet , row , col , value) {
	
	if (row == 3) {		
		
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
		
		/*
		//입력금액보다 클경우
		if(sheet.CellValue(row,"ttl") <  parseInt(removeComma(frm.fm_rqst_locl_amt.value),10)) {
			ComShowCodeMessage("GEM01040" , sheet1.CellText(row,"fm_rqst_locl_amt"));
			sheet.CellValue(row,col) = 0;
		}
		*/
				
		frm.fm_rqst_locl_amt.value = sheet.CellText(row,"ttl");		
		setUsdAmt();		
		
		
	} else if (row == 4) {
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
		
		if ( parseInt(removeComma(frm.to_rqst_locl_amt.value),10) < sheet.CellValue(row,"ttl") ) {
			ComShowCodeMessage("GEM01081");			
			sheet.CellValue2(row,col) = 0;
		}
				
	}
		
	setFormToSheet1();
	
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
		sheet1.RemoveAll();
		frm.gen_expn_rqst_no.value = gen_expn_rqst_no;		
		frm.f_cmd.value = SEARCHLIST;
		
		var param = "f_cmd=" + SEARCHLIST;
		param += "&gen_expn_rqst_no=" + gen_expn_rqst_no;
		param += "&pln_yrmon=" + frm.pln_yrmon.value;
		
	
		var sXml = sheet1.GetSearchXml("CPS_GEM_0001_02GS.do", param);
		
		sheet1.LoadSaveXml(sXml);
		
		var rowCnt = SheetRowCount(sheet1);		
		//밑줄 표시				
		if (rowCnt > 0 ) {
			var fNum = FirstRowNum(sheet1);
			var usdTotal = getUsdTotal();
			frm.usd_ttl.value = ComAddComma(ComRound(usdTotal,0));
			setSheet1ToForm(2);
			sheet1.SelectRow = 2;
			sheet1.SelectCell(sheet1.SelectRow, sheet1.SelectCol, false); 
			frm.rownum.value = "2";
		} else {		
			//msgs["GEM00013"] = "There is no related data!";
			ComShowCodeMessage("GEM00013");
			return;
		}
		
	//[open]	 	
	} else if (sAction == INIT) {		
		frm.f_cmd.value = INIT;		
		var sXml = sheet3.GetSearchXml("CPS_GEM_0001_02GS.do", FormQueryString(frm));		
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

			
			// BU	
			if ( authFlg == "YYYN" ) {				
				//비용주관팀  TIC 설정 Authorized Expense Code
				frm.usr_tic_cd.value = frm.usr_ofc_cd.value;				
			// 사무국
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

			}
			
			//권한 설정
			frm.auth_flg.value = authFlg;
			
			
			/*
			//환율, 통화 정보 설정			
			document.getElementById("fm_locl_curr_cd").innerText = loclCurrCd;
			//USD
			frm.fm_usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
			//단위
			frm.fm_rqst_ut_val.value = ComAddComma(rqstUtVal);

			//환율, 통화 정보 설정			
			document.getElementById("to_locl_curr_cd").innerText = loclCurrCd;
			//USD
			frm.to_usd_locl_xch_rt.value = ComAddComma(usdLoclXchRt);
			//단위
			frm.to_rqst_ut_val.value = ComAddComma(rqstUtVal);
			*/
			
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
				/*
				if ("N" == rgnOfcFlg) {
					frm.fm_sls_ofc_div_cd[0].checked = true;
				} else {
					frm.fm_sls_ofc_div_cd[1].checked = true;
				}
				
				ComSetObjValue(frm.fm_ofc_lvl1,level2);
				
				//LV2
				selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');			
				ComSetObjValue(frm.fm_ofc_lvl2,level3);
				
				//LV3
				selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');			
				ComSetObjValue(frm.fm_ofc_lvl3,level4);
				frm.fm_ofc_lvl3.blur();
				*/
				
				//TO에 복사
				/*
				if ("N" == rgnOfcFlg) {
					frm.to_sls_ofc_div_cd[0].checked = true;
				} else {
					frm.to_sls_ofc_div_cd[1].checked = true;
				}			
				
				ComSetObjValue(frm.to_ofc_lvl1,level2);
				comboCopy( frm.fm_ofc_lvl2,  frm.to_ofc_lvl2, true);
				comboCopy( frm.fm_ofc_lvl3,  frm.to_ofc_lvl3, true);
				*/
				frm.to_ofc_lvl3.blur();
				
				disableToItem();
				
			}
			
		}		

		//추가후 숨기기
		var row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "FM Assigned";
		
		var row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "To Assigned";

		// TO Assigned Hidden
		//sheet2.RowHidden(2) = true;
		
		row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "From";
		
		sheet2.ColBackColor("title") = sheet2.WebColor("#EBF6F9");
		sheet2.CellImage(row,"title") = 0;

		
		row = sheet2.DataInsert(-1);		
		sheet2.CellValue2(row, "title") = "To";
		
		sheet2.ColBackColor("title") = sheet2.WebColor("#EBF6F9");
		sheet2.CellImage(row,"title") = 0;
		
		// additional 마감 정보
		if (arrXml.length > 2) {
			var list = ComXml2ListMap(arrXml[2]);
			if (list.length > 0) {
				closingDateVO  = list[0];
				var clzYrmon = 	closingDateVO["clz_yrmon"];				
				var clzMon = parseInt(clzYrmon.substring(4,6) , 10)+"";
				
				frm.pln_yrmon.value = clzYrmon;
				
				var mon = parseInt(clzMon, 10);
				if (mon == 0) {
					mon = 1;
				}
				
				frm.fm_monthFrom.length = 0;	
				
				for ( var i = mon; i <= 12; i++) {					
					ComAddComboItem(frm.fm_monthFrom,  getEngMonthName(i) , i);
				}
				
				frm.fm_monthFrom.value = mon;
				
				frm.fm_monthTo.length = 0;
				ComAddComboItem(frm.fm_monthTo,  "" , "");
				comboCopy(frm.fm_monthFrom, frm.fm_monthTo, false);
				frm.fm_monthTo.value = "";
				
				frm.to_monthFrom.length = 0;
				comboCopy(frm.fm_monthFrom, frm.to_monthFrom, false);
				
				frm.to_monthTo.length = 0;
				ComAddComboItem(frm.to_monthTo,  "" , "");
				comboCopy(frm.fm_monthFrom, frm.to_monthTo, false);
				frm.to_monthTo.value = "";
				
				printClosingDate(closingDateVO);
				
			}
		}
		
		//Assignment Rule
		ComEnableObject(frm.fm_monthFrom, false);
		ComEnableObject(frm.fm_monthTo, false);
		ComEnableObject(frm.to_monthFrom, false);
		ComEnableObject(frm.to_monthTo, false);
		
		//초기 Row생성 
		var row = sheet1.DataInsert(-1);
		sheet1.CellValue2(row,"fm_gen_expn_rqst_seq") = "0001";
		frm.rownum.value = row;
		
		frm.fm_ofc_lvl1.focus();
		
	//[Save]	
	} else if (sAction == MULTI) {		
		frm.f_cmd.value = MULTI;
		
		var plnYrmon =  frm.pln_yrmon.value;
		var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);	
		var auth_flg = frm.auth_flg.value;
		var gen_expn_rqst_no = frm.gen_expn_rqst_no.value;

		//ibflag 상태 복사
		for ( var i = 0; i < sheet1.RowCount; i++) {
			var row = i + 2;
			var ibflag = sheet1.CellValue(row , "ibflag");
			sheet1.CellValue2(row , "fm_ibflag") = ibflag;
			sheet1.CellValue2(row , "to_ibflag") = ibflag;			
		}
		
				
		var param = "f_cmd=" + MULTI;
		param    += "&pln_yrmon=" + plnYrmon + 
					"&auth_flg=" + auth_flg +
					"&gen_expn_rqst_no=" + gen_expn_rqst_no +
		            "&gen_expn_rqst_tp_cd=" + gen_expn_rqst_tp_cd ;
		
		var sParam = sheet1.GetSaveString();
		
		if (sheet1.IsDataModified && sParam == "") {				
			return; 
		}
		
		var sXml = sheet1.GetSaveXml("CPS_GEM_0001_02GS.do?"+param, sParam );
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
			
			var fm_ofc_lvl1 = frm.fm_ofc_lvl1;
			fm_ofc_lvl1.length = 0;
			ComAddComboItem(fm_ofc_lvl1, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(fm_ofc_lvl1, comboListData[i], comboListData[i]);
			}
			
			//copy						
			comboCopy( frm.fm_ofc_lvl1,  frm.to_ofc_lvl1, true);
			
		}

	} 	
 
}
