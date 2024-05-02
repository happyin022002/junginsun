/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0105.js
 *@FileTitle : [CPS_GEM_0105] Request No. Reference
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0105] Request No. Reference
 * @extends
 * @class 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다.
 */
function CPS_GEM_0105() {
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

//선택되어진 row번호
var selectedRow = 0;

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
   
    //초기 데이타 취득 TIC취득    
    doActionIBSheet(INIT);         
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
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "Seq.|Request No.|Item|Office|Office|Amount (USD)|Amount (USD)|Creator|to_gen_expn_itm_no|gen_expn_rqst_seq|fr_gen_expn_cd|to_gen_expn_cd|req_upd_dt";
			var HeadTitle2 = "Seq.|Request No.|Item|FM|TO|FM|TO|Creator|to_gen_expn_itm_no|gen_expn_rqst_seq|fr_gen_expn_cd|to_gen_expn_cd|req_upd_dt";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"hdnStatus");
			
			InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,		true,		"seq",				false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			180,		daCenter,		true,		"gen_expn_rqst_no",			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		"fr_gen_expn_itm_no",				false,		"",			dfNone);			
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"fr_ofc_cd",		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"to_ofc_cd",		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"fr_amt", 		false,		"",			dfNullFloat ,2);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		"to_amt",		false,		"",			dfNullFloat ,2);
			InitDataProperty(0, cnt++ , dtData,			10,		daCenter,		true,		"cre_usr_id", 			false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"to_gen_expn_itm_no");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"gen_expn_rqst_seq");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"fr_gen_expn_cd");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,		"to_gen_expn_cd");			
			InitDataProperty(0, cnt++ , dtHidden,			100,		daCenter,	true,		"req_upd_dt");
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
	case "btn1_Close":
		self.close();
		break;
	case "btn1_Select":
		//선택된 행번호 
		if (selectedRow > 1) {
			var genExpnRqstNo =  sheet1.CellValue(selectedRow , "gen_expn_rqst_no");
			opener.setGenExpnRqstNo(genExpnRqstNo);
		}
		self.close();
		break;
	} 
}

 
//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
 
 

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * sheet1 OnClick후 이벤트 
 * @param {ibsheet} sheet 해당 시트   
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	if (row > 0 ) {
		for (var i=0 ; i < sheet1.RowCount ; i++  ) {
			sheet1.RowBackColor(i+2) = sheet1.RgbColor(255,255,255);			
		}
		selectedRow  = row;
		sheet1.RowBackColor(row) = sheet1.RgbColor(192,192,192);		
	}
}

/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	
	if (row < 1) {
		return;
	}
	
	var genExpnRqstNo =  sheet.CellValue(row , "gen_expn_rqst_no");	
	opener.setGenExpnRqstNo(genExpnRqstNo);
	self.close();
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	//[Retrieve]
	if (sAction == INIT) {
		frm.f_cmd.value = INIT;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0105GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
	}  
 	
}
 
 

 
