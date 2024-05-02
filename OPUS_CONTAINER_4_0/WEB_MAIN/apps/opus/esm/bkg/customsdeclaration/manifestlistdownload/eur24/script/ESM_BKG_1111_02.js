/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1111.js
*@FileTitle  :  US AMS: Main Menu
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
    var formObject=document.form;
 	try {
   		var srcName=ComGetEvent("id");
   		var isOpen=false;
   		var sUrl="";
   		var sId="";
		switch(srcName) {
			/*
			 * Europe Office
			 */
			// Inbound Documentation
			case "btn_EXS_1": // //1. EXS Download & Transmit
				sUrl = "ESM_BKG_1121.do?pgmNo=ESM_BKG_1121&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1121";
				break;	
			
			case "btn_EXS_2": // //2. EXS Report
				sUrl = "ESM_BKG_1126.do?pgmNo=ESM_BKG_1126&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1126";
				break;
				
			case "btn_EXS_3": // //3. EXS Monitor
				sUrl = "ESM_BKG_1152.do?pgmNo=ESM_BKG_1152&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1152";
				break;
	
			case "btn_IB_1": // //1. Arrival Notice
				sUrl = "ESM_BKG_1104.do?pgmNo=ESM_BKG_1104&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1104";
				break;	
			
			case "btn_IB_2": // //2. Diversion Request
				sUrl = "ESM_BKG_1105.do?pgmNo=ESM_BKG_1105&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1105";
				break;	
				
			// Report
			case "btn_IT_1": // 1. ENS Report
				sUrl = "ESM_BKG_1108.do?pgmNo=ESM_BKG_1108_2&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1108_2";
				break;		
				
			case "btn_IT_2": // 2. ENS Monitor
				sUrl = "ESM_BKG_1120.do?pgmNo=ESM_BKG_1120_2&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1120_2";
			break;						
				
			// Code
			case "btn_CS_1": // 1. Customs Setup
				sUrl = "ESM_BKG_1109.do?pgmNo=ESM_BKG_1109&parentPgmNo=ESM_BKG_M001";
				sId = "ESM_BKG_1109";
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
	            var winObj = window.open("/opuscntr/"+url, sFeatures);
//	            var winObj=window.open("/opuscntr/"+id+".do", "", sFeatures);
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
