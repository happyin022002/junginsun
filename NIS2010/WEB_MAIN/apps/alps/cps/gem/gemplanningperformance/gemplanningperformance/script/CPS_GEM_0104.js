/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0104.js
 *@FileTitle : [CPS_GEM_0104] Assigned Expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0104] Assigned Expense
 * @extends
 * @class Assigned Expense생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0104() {
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
            style.height = 220;
            
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 7, 100);

			//var HeadTitle1 = "Select|Seq.|Item description|CUR|Expense|Expense|Request|Request";
			//var HeadTitle2 = "Select|Seq.|Item description|CUR|Assigned|Transferable|RQST No.|Item ";
			var HeadTitle1 = "Seq.|Item description|CUR|Expense|Expense|Request|Request|jan_amt|feb_amt|mar_amt|apr_amt|may_amt|jun_amt|jul_amt|aug_amt|sep_amt|oct_amt|nov_amt|dec_amt";
			var HeadTitle2 = "Seq.|Item description|CUR|Assigned|Transferable|RQST No.|Item|jan_amt|feb_amt|mar_amt|apr_amt|may_amt|jun_amt|jul_amt|aug_amt|sep_amt|oct_amt|nov_amt|dec_amt";

            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
            //InitDataProperty(0, cnt++ , dtDummyCheck,		50,		daCenter,	true,		"delChk");
            InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"Sel");					
			InitDataProperty(0, cnt++ , dtData,			240,	daLeft,		true,		"gen_expn_itm_desc");
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"curr_cd");
			InitDataProperty(0, cnt++ , dtData,			90,	daRight,	true,		"assigned",		false,		"",			dfNullInteger);
			InitDataProperty(0, cnt++ , dtData,			90,	daRight,	true,		"transferable",	false,		"",			dfNullInteger);
			InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		"gen_expn_rqst_no");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gen_expn_itm_no");
			
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"jan_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"feb_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"mar_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"apr_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"may_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"jun_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"jul_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"aug_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"sep_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"oct_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"nov_amt");
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		"dec_amt");			
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
	case "btn_Select":
		var row = sheet1.SelectRow;
		var expenseInfo =  setAssignedExpense(row);
		opener.setAssignedExpense(expenseInfo);
		self.close();
		break;
	case "btn_Close":
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
		
		sheet1.RowBackColor(row) = sheet1.RgbColor(235,235,235);		
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
	   if (sheet1.MouseRow > 0 && ("gen_expn_itm_desc" == sName )) {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,sheet1.MouseCol);		   
	   } else {
		   sheet1.MouseToolTipText = "";
	   }      
}


/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	if (row < 2) {
		return;
	}

	var expenseInfo =  setAssignedExpense(row);
	opener.setAssignedExpense(expenseInfo);
	self.close();
	
}

/**
* 비용코드 설정
* 선택된 행 반환
*/
function setAssignedExpense( row ) {
	
	var expenseInfo = {
		"gen_expn_itm_desc"  : "",
		"curr_cd"            : "",
		"assigned"           : "",
		"transferable"       : "",
		"gen_expn_rqst_no"   : "",
		"gen_expn_itm_no"    : "",
		"jan_amt"            : "",
		"feb_amt"            : "",
		"mar_amt"            : "",
		"apr_amt"            : "",
		"may_amt"            : "",
		"jun_amt"            : "",
		"jul_amt"            : "",
		"aug_amt"            : "",
		"sep_amt"            : "",
		"oct_amt"            : "",
		"nov_amt"            : "",
		"dec_amt"		     : ""
	};
	
	expenseInfo.gen_expn_itm_desc     = sheet1.CellValue(row , "gen_expn_itm_desc");
	expenseInfo.curr_cd                = sheet1.CellValue(row , "curr_cd");           
	expenseInfo.assigned               = sheet1.CellValue(row , "assigned");          
	expenseInfo.transferable           = sheet1.CellValue(row , "transferable");      
	expenseInfo.gen_expn_rqst_no       = sheet1.CellValue(row , "gen_expn_rqst_no");  
	expenseInfo.gen_expn_itm_no        = sheet1.CellValue(row , "gen_expn_itm_no");   
	expenseInfo.jan_amt                = sheet1.CellValue(row , "jan_amt");           
	expenseInfo.feb_amt                = sheet1.CellValue(row , "feb_amt");           
	expenseInfo.mar_amt                = sheet1.CellValue(row , "mar_amt");           
	expenseInfo.apr_amt                = sheet1.CellValue(row , "apr_amt");           
	expenseInfo.may_amt                = sheet1.CellValue(row , "may_amt");           
	expenseInfo.jun_amt                = sheet1.CellValue(row , "jun_amt");           
	expenseInfo.jul_amt                = sheet1.CellValue(row , "jul_amt");           
	expenseInfo.aug_amt                = sheet1.CellValue(row , "aug_amt");           
	expenseInfo.sep_amt                = sheet1.CellValue(row , "sep_amt");           
	expenseInfo.oct_amt                = sheet1.CellValue(row , "oct_amt");           
	expenseInfo.nov_amt                = sheet1.CellValue(row , "nov_amt");           
	expenseInfo.dec_amt                = sheet1.CellValue(row , "dec_amt");           
	
	return expenseInfo;
}


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {

	//[Retrieve]
	if (sAction == INIT) {
		frm.f_cmd.value = INIT;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_0104GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
	}  
 	
}
 
 

 
