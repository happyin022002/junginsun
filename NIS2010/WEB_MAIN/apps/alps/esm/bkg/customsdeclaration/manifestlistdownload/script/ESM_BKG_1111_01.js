/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1111.js
 *@FileTitle : US AMS: Main Menu
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.23
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.08.18 이수빈
 * 1.0 Creation
 * 
 * 1.1 2011.05.23 민정호 [CHM-201110983] ENS Monitor 기능 - ENS Inbound화면에 중복생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class US AMS: Main Menu : US AMS: Main Menu 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1111() {
	this.processButtonClick		= tprocessButtonClick;
	this.loadPage 				= loadPage;
}

/* 개발자 작업	*/

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
    var formObject = document.form;

 	try {
   		var srcName = window.event.srcElement.getAttribute("id");
   		var isOpen = false;
   		var sUrl = "";
   		var sId = "";

		switch(srcName) {

			/*
			 * Origin Office
			 */
			// Manifest Download
			case "btn_1_1": // 1. ENS Download & Transmit
				sUrl = "ESM_BKG_1106.do&pgmNo=ESM_BKG_1106";
				sId = "ESM_BKG_1106";
				break;	

			case "btn_1_2": // 2. B/L Inquiry
				sUrl = "ESM_BKG_1107.do&pgmNo=ESM_BKG_1107";
				sId = "ESM_BKG_1107";
				break;	
								
			// Report
			case "btn_2_1": //1. ENS Report
				sUrl = "ESM_BKG_1108.do&pgmNo=ESM_BKG_1108_1";
				sId = "ESM_BKG_1108_1";
				break;	
				
			// Report
			case "btn_2_2": //1. ENS Monitor
				sUrl = "ESM_BKG_1120.do&pgmNo=ESM_BKG_1120_1";
				sId = "ESM_BKG_1120_1";
				break;					
				
//			/*
//			 * Europe Office
//			 */btn_2_1
//			// Inbound Documentation
//			case "btn_IB_1": // //1. Arrival Notice
//				sUrl = "ESM_BKG_1104.do&pgmNo=ESM_BKG_1104";
//				sId = "ESM_BKG_1104";
//				break;	
//			
//			case "btn_IB_2": // //2. Diversion Request
//				sUrl = "ESM_BKG_1105.do&pgmNo=ESM_BKG_1105";
//				sId = "ESM_BKG_1105";
//				break;	
//
//			// Report
//			case "btn_IT_1": // 1. ENS Report
//				sUrl = "ESM_BKG_1108.do&pgmNo=ESM_BKG_1108";
//				sId = "ESM_BKG_1108";
//				break;							
//				
//			// Code
//			case "btn_CS_1": // 1. Customs Setup
//				sUrl = "ESM_BKG_1109.do&pgmNo=ESM_BKG_1109";
//				sId = "ESM_BKG_1109";
//				break;
		} // end switch
        if (sId != "") module_pop(sUrl, sId);
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
 }
 
 /**
  * 링크화면 오픈
  */
 function module_pop(url, id) {
     try {
     	var btn_nm = window.event.srcElement.getAttribute("id");
     	var obj = document.getElementById(btn_nm);
     	if (ComIsBtnEnable(btn_nm)) {
	            var iWidth = 1040;
	            var iHeight = 700;
	            var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
	            var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
	            var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
	            var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, "", sFeatures);
	            winObj.focus();
     	}
     } catch(err) { alert(err.message); }
 }
 
 /**
  * Office Type에 따라 버튼 비활성 처리
  */                  
 function loadPage() {
	// if (document.form.ofcType.value == "US") {
	//	 ComBtnDisable("btn_1_1");
	//	 ComBtnDisable("btn_1_2");
	//	 ComBtnDisable("btn_2_1");
	// } else {
	//	 ComBtnDisable("btn_IB_1");
	//	 ComBtnDisable("btn_IB_2");
	//	 ComBtnDisable("btn_IB_3");
	//	 ComBtnDisable("btn_IT_1");
	//	 ComBtnDisable("btn_CS_1");
	// }
	 axon_event.addListener('MouseOver', 'obj_MouseOver', "form");
	 axon_event.addListener('MouseOut', 'obj_MouseOut', "form");
	}
  
 /**
  * 버튼에 마우스 오버 시 처리
  */
 function obj_MouseOver() {
 	var btn_nm = window.event.srcElement.getAttribute("id");
 	var obj = document.getElementById(btn_nm);
 	if (ComIsBtnEnable(btn_nm)) {
     	obj.style.textDecoration = "underline";
     	obj.style.color = "#30A5D0";
 	}
 }

 /**
  * 버튼에 마우스 아웃 시 처리
  */
 function obj_MouseOut() {
 	var btn_nm = window.event.srcElement.getAttribute("id");
 	var obj = document.getElementById(btn_nm);
 	if (ComIsBtnEnable(btn_nm)) {
     	obj.style.textDecoration = "none";
     	obj.style.color = "#737373";
 	}
 }
/* 개발자 작업  끝 */