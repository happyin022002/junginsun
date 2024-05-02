/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0008.js
 *@FileTitle : Expense Office Maintenance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.27 최정미
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
 * @author CLT
 */

/**
 * @extends
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0008(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	
	// sheet
	
	// tab
	this.initTab = initTab;
	this.tab1_OnChange = tab1_OnChange;
	this.setTabObject = setTabObject;	
}

/* 개발자 작업 */


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
//html form
var frm = null;

//IB tab
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;


//===================================================================================
//초기화 
//===================================================================================
/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
**/
function loadPage() {
 //전역 변수 설정 
 frm = document.form;
 
 for (var i = 0; i < tabObjects.length; i++) {
     initTab(tabObjects[i],i+1);
 }    
 
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
                InsertTab( cnt++ , "Office Code" , -1 );
                InsertTab( cnt++ , "Expense Matrix per Office" , -1 );
                InsertTab( cnt++ , "Office Matrix per Office" , -1 );
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
			frame.src = "CPS_GEM_0008_01.do";			
		}		
	} else if (nItem == 1) {
		var frame = document.getElementById("t2frame");		
		if (frame.src == "") {			
			frame.src = "CPS_GEM_0008_02.do";			
		}		
	} else if (nItem == 2) {
		var frame = document.getElementById("t3frame");
		if (frame.src == "") {
			frame.src = "CPS_GEM_0008_03.do";			
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

/* 개발자 작업 끝 */