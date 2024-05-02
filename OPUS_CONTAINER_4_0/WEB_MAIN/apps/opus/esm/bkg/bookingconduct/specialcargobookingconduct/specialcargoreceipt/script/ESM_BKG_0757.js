/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0757.js
*@FileTitle  : Special Cargo Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0; 
    var enter=0; 
    var opener_rmk=window.dialogArguments;
    if (!opener_rmk) opener_rmk=parent;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 					switch(srcName) {
 						case "btn_ok": 		
 							if(document.getElementById("remarks").value.length > 1){
 								opener_rmk.document.getElementById("btn_Remark").setAttribute("style", "font-weight: bold;color:blue!important"); 							
 							}else{ 								
 								opener_rmk.document.getElementById("btn_Remark").setAttribute("style", "color:##A0BAED!important");								
 							}
 							if(opener_rmk.document.getElementById("title_id").value == "awk"){
	 							var row=opener_rmk.sheetObjects[1].GetSelectRow();
	 							opener_rmk.sheetObjects[1].SetCellValue(row, "diff_rmk",document.getElementById("remarks").value,0);
 							}
 							if(opener_rmk.document.getElementById("title_id").value == "dg"){
// 								var bkg_cntr_seq=opener_rmk.document.getElementById("dg_cntr_seq").value + opener_rmk.document.getElementById("cntr_cgo_seq").value;
 								var dcgo_seq = opener_rmk.document.getElementById("dcgo_seq").value;
 					        	var rows=opener_rmk.sheetObjects[3].FindText("dcgo_seq", dcgo_seq, 0, 2);
// 					        	var rows=opener_rmk.sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
 					        	opener_rmk.sheetObjects[3].SetCellValue(rows, "diff_rmk",document.getElementById("remarks").value,0);
 					        	opener_rmk.document.getElementById("diff_rmk").value=document.getElementById("remarks").value;
 							}
 							if(opener_rmk.document.getElementById("title_id").value == "rf"){
	 							var row=opener_rmk.sheetObjects[1].GetSelectRow();
	 							opener_rmk.sheetObjects[1].SetCellValue(row, "diff_rmk",document.getElementById("remarks").value,0);
	 							opener_rmk.document.getElementById("diff_rmk").value=document.getElementById("remarks").value;
 							}
 							if(opener_rmk.document.getElementById("title_id").value == "bb"){
	 							var row=opener_rmk.sheetObjects[2].GetSelectRow();
	 							opener_rmk.sheetObjects[2].SetCellValue(row, "diff_rmk",document.getElementById("remarks").value,0);
	 							opener_rmk.document.getElementById("diff_rmk").value=document.getElementById("remarks").value;
 							}							
 							ComClosePopup(); 
 						break;											
 						case "btn_close":
 							ComClosePopup(); 
 						break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
   			 ComShowMessage(OBJECT_ERROR);
   	     } else {
   	         ComShowMessage(e.message);
   	     }
     	}
     }
     function loadPage() {    	 
    	 if(opener_rmk.document.getElementById("title_id").value == "awk"){
    		 var row=opener_rmk.sheetObjects[1].GetSelectRow();
    		 document.getElementById("remarks").value=opener_rmk.sheetObjects[1].GetCellValue(row, "diff_rmk");
    	 }
    	 if(opener_rmk.document.getElementById("title_id").value == "dg"){
    		 document.getElementById("remarks").value=opener_rmk.document.getElementById("diff_rmk").value
    	 }
    	 if(opener_rmk.document.getElementById("title_id").value == "rf"){
    		 document.getElementById("remarks").value=opener_rmk.document.getElementById("diff_rmk").value
    	 }
    	 if(opener_rmk.document.getElementById("title_id").value == "bb"){
    		 document.getElementById("remarks").value=opener_rmk.document.getElementById("diff_rmk").value
    	 }
    	 initControl();
     }
     function initControl() {    	  
   	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
   	    axon_event.addListenerForm('keyup','obj_keyup', form);
   	    axon_event.addListenerForm('change','obj_change', form);
   	}
    function  obj_keyup(){   	
    	switch (event.srcElement.name) {
    	case "remarks":			
    	var frm=document.form.remarks.value.length;
//    	if(frm > 50){
//    		ComShowMessage("50 characters exceeded.");
//    		document.form.remarks.value=document.form.remarks.value.substring(0, 50);    		
//    	}
    	var str_line=document.form.remarks.value;
    	line=str_line.split("\r\n");
    	ln=line.length;    	
    	if(ln > 10 && event.keyCode == 13){
    		ComShowMessage("10 lines exceeded.");
    		document.form.remarks.value=document.form.remarks.value.substring(0, str_line.length-2);  
    		//event.returnValue = false;
    	}
    	if( document.form.remarks.value.replace(/\r\n/gi,"").length > 300 ){
			ComShowMessage("300 characters exceeded.");
			document.form.remarks.value=document.form.remarks.value.substr(0, (lineStr.length-1) * 2 + 300);
			return;
		}
    	 break;
    	}	
    }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
	/* 개발자 작업  끝 */
