/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0101.js
 *@FileTitle : [CPS_GEM_0101] Authorized Expense Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0101] Note Popup
 * @extends
 * @class Note Popup생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0102() {
    this.processButtonClick = processButtonClick;
    this.loadPage = loadPage;

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
var type = "";


// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 **/
function loadPage(mode) {
    //전역 변수 설정 
    frm = document.form;
    type =  mode;
}


// ===================================================================================
// Private function
// ===================================================================================


// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;
document.onkeypress = inputNote;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "btn1_Save":			
			var note = frm.note.value;
			var len = 0;
			//Request Item
			if (type == "A") {		
				len = 500;
			//Calculation Basis
			} else if (type == "B") {
				len = 1300;
			//Requester's Opinion
			} else if (type == "C") {
				len = 600;
			//ReadOnly
			} else if (type == "D") {
				len = 4000;
			}
			
			if (note.length <= len) {
				opener.setNote(type, note);
				self.close();
			} else {
				//msgs['COM12142'] = '{?msg1} must be shorter than {?msg2} characters long.';
				ComShowCodeMessage("COM12142" , "Note" , len);
			}
			
			break;
		case "btn1_Close":
			self.close();
			break;
	} 
}

function inputNote(e) {	
	var evt = e || window.event;	
	var srcName = window.event.srcElement.getAttribute("name");	
	if ("note" ==  srcName) {
		var note = frm.note.value;
		var len = note.length;
		var limit = 0;
		var flg = true;
		//Request Item
		if (type == "A" && len > 500) {
			limit = 500;
			flg = false;
		//Calculation Basis
		} else if (type == "B" && len > 1300) {
			limit = 1300;
			flg = false;
		//Requester's Opinion
		} else if (type == "C" && len > 600) {
			limit = 600;
			flg = false;
		//ReadOnly
		} else if (type == "D" && len > 4000) {
			limit = 4000;
			flg = false;
		}
		
		if (!flg) {
			//msgs['COM12142'] = '{?msg1} must be shorter than {?msg2} characters long.';
			ComShowCodeMessage("COM12142" , "Note" , limit);
			event.returnValue = false;
			return;
		}
		
		/*
		if ( evt.keyCode == 13) {
			note += "▷";
			frm.note.value = note;
		}
		*/
	}
}

























 
