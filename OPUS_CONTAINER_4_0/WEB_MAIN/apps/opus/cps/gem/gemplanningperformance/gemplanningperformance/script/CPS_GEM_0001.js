/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0001.js
 *@FileTitle : [UI_GAE-0001] Expense Request
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [UI_GAE-0001] Expense Request
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0001() {
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
// html form
var frm = null;

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// IB tab
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var tab1 = null;
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
    
    tab1 = tabObjects[0];
    //탭 초기화
    for (var i = 0; i < tabObjects.length; i++) {
        initTab(tabObjects[i],i+1);
    }    
    
    tab1.Enable = false;
    
    sheet1 = sheetObjects[0];
    sheetCnt = sheetObjects.length ;
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);    
    }  
    
	var authFlg  = frm.auth_flg.value;	
	//집행단위
	if ( authFlg == "YNNN" || authFlg == "YYNN") {
		//탭비활성화
		tabObjects[0].DeleteTab(1);
	}		

	//tab1.Enable = true;
}


/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function tab1_OnLoadFinish(tab) {
	tab.Visible = true;	
}

//===================================================================================
// Tab
//===================================================================================
/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt  = 0 ;
			InsertTab( cnt++ , "Initial & Additional" , -1 );
			InsertTab( cnt++ , "Transfer" , -1 );
			InsertTab( cnt++ , "Adjustment" , -1 );
		}		
		break;
	}
	
}


/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem) {
	
	var objs = document.all.item("tabLayer");
    
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	
	
	if ( nItem == 0 ) {
		var frame = document.getElementById("t1frame");
		if (frame.src == "") {
			tab1.Enable = false;
			frame.src = "CPS_GEM_0001_01.do";			
		}		
	} else if (nItem == 1) {		
		var frame = document.getElementById("t2frame");	    
	    if (frame.src == "") {
	    	tab1.Enable = false;
	    	var tabCnt = tabObj.GetCount;
			if (tabCnt == 3  ) {							
				frame.src = "CPS_GEM_0001_02.do";
			} else {
				frame.src = "CPS_GEM_0001_03.do";
			}
	    }	    
	} else if (nItem == 2) {
		var frame = document.getElementById("t3frame");
		if (frame.src == "") {
			tab1.Enable = false;
			frame.src = "CPS_GEM_0001_03.do";			
		}				
	}
	
	beforetab= nItem;
}

/**
* Tab 기본 설정 탭설정
*/
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}