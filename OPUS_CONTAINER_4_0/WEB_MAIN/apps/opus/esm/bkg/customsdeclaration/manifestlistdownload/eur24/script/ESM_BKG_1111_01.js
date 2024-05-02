/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1111.js
*@FileTitle  :  US AMS: Main Menu
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
document.onclick=processButtonClick;
 function processButtonClick(){
    var formObject=document.form;
 	try {
   		var srcName=ComGetEvent("id");
   		var isOpen=false;
   		var sUrl="";
   		var sId="";
		switch(srcName) {
			/*
			 * Origin Office
			 */
			// Manifest Download
			case "btn_1_1": // 1. ENS Download & Transmit
				sUrl="ESM_BKG_1106.do?pgmNo=ESM_BKG_1106&mainPage=true&parentPgmNo=ESM_BKG_M001";
				sId="ESM_BKG_1106";
				break;	
			case "btn_1_2": // 2. B/L Inquiry
				sUrl="ESM_BKG_1107.do?pgmNo=ESM_BKG_1107&mainPage=true&parentPgmNo=ESM_BKG_M001";
				sId="ESM_BKG_1107";
				break;	
			// Report
			case "btn_2_1": //1. ENS Report
				//sUrl="ESM_BKG_1108.do?pid=ESM_BKG_M080&MENU=Y&pgmNo=ESM_BKG_1108_1&main_page=true&mainMenuLinkFlag=true&menuflag=true";
				sUrl="ESM_BKG_1108.do?pid=ESM_BKG_M080&MENU=Y&pgmNo=ESM_BKG_1108_1&mainPage=true&parentPgmNo=ESM_BKG_M001";
				sId="ESM_BKG_1108";
				break;	
				// Report
			case "btn_2_2": //1. ENS Monitor
				//sUrl="ESM_BKG_1120.do?pid=ESM_BKG_M080&MENU=Y&pgmNo=ESM_BKG_1120_1&parentPgmNo=ESM_BKG_M001&main_page=true&mainMenuLinkFlag=true&menuflag=true";
				sUrl="ESM_BKG_1120.do?pid=ESM_BKG_M080&MENU=Y&pgmNo=ESM_BKG_1120_1&mainPage=true&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1120_1";
				
				break;						
		} // end switch
        if (sId != "") module_pop(sUrl, sId);
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
 /**
  * 링크화면 오픈
  */
 function module_pop(url, id) {
     try {
     	var btn_nm=ComGetEvent("id");
     	var obj=document.getElementById(btn_nm);
     	if (ComIsBtnEnable(btn_nm)) {
	            var iWidth=1040;
	            var iHeight=700;
	            var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
	            var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
	            var sFeatures="status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
//	            var winObj=window.open("/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^" + url, "", sFeatures);
	            var winObj=window.open("/opuscntr/"+ url,  sFeatures);
	            winObj.focus();
     	}
     } catch(err) { alert(err.message); }
 }
 /**
  * Office Type에 따라 버튼 비활성 처리
  */                  
 function loadPage() {
	 axon_event.addListener('MouseOver', 'obj_MouseOver', "form");
	 axon_event.addListener('MouseOut', 'obj_MouseOut', "form");
	}
 /**
  * 버튼에 마우스 오버 시 처리
  */
 function obj_MouseOver() {
 	var btn_nm=ComGetEvent("id");
 	var obj=document.getElementById(btn_nm);
 	if (ComIsBtnEnable(btn_nm)) {
     	obj.style.textDecoration="underline";
     	obj.style.color="#30A5D0";
 	}
 }
 /**
  * 버튼에 마우스 아웃 시 처리
  */
 function obj_MouseOut() {
 	var btn_nm=ComGetEvent("id");
 	var obj=document.getElementById(btn_nm);
 	if (ComIsBtnEnable(btn_nm)) {
     	obj.style.textDecoration="none";
     	obj.style.color="#737373";
 	}
 }
/* 개발자 작업  끝 */
