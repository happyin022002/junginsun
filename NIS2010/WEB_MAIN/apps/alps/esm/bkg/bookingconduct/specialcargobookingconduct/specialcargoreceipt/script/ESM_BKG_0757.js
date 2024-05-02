/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0757.js
*@FileTitle : Special Cargo Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.19 이병규
* 1.0 Creation
===============================================================================
 History
 2012.02.01 변종건 [CHM-201215892-01] DG Remark 추가 에러 사항 개선 요청
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
     * @class esm_bkg_0757 : esm_bkg_0757 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0757() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
   	

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0; 
    var enter = 0; 
    
    var opener = window.dialogArguments;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 					switch(srcName) {

 						case "btn_ok": 			
 							
 							if(document.getElementById("remarks").value.length > 1){
 								
 								opener.document.getElementById("btn_Remark").style.color = "blue"; 							
 							}else{ 								
 								opener.document.getElementById("btn_Remark").style.color = "";
 							}
 														
 							if(opener.document.getElementById("title_id").value == "awk"){
 								
	 							var row = opener.sheetObjects[1].SelectRow;
	 							opener.sheetObjects[1].CellValue2(row, "diff_rmk") = document.getElementById("remarks").value;	 								 							
 							}
 							
 							if(opener.document.getElementById("title_id").value == "dg"){
 								
 								var bkg_cntr_seq = opener.document.getElementById("dg_cntr_seq").value + opener.document.getElementById("cntr_cgo_seq").value;  	
 								
 					        	var rows = opener.sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
 								
 					        	opener.sheetObjects[3].CellValue2(rows, "diff_rmk") = document.getElementById("remarks").value; 								
 					        	opener.document.getElementById("diff_rmk").value = document.getElementById("remarks").value;
 					        	
 							}
 							
 							if(opener.document.getElementById("title_id").value == "rf"){
 								
	 							var row = opener.sheetObjects[1].SelectRow;
	 							opener.sheetObjects[1].CellValue2(row, "diff_rmk") = document.getElementById("remarks").value;
	 							opener.document.getElementById("diff_rmk").value = document.getElementById("remarks").value;
	 								 							
 							}
 							
 							if(opener.document.getElementById("title_id").value == "bb"){
 								
	 							var row = opener.sheetObjects[2].SelectRow;	 							
	 							opener.sheetObjects[2].CellValue2(row, "diff_rmk") = document.getElementById("remarks").value;
	 							opener.document.getElementById("diff_rmk").value = document.getElementById("remarks").value;
	 								 							
 							}							
 							
 							window.close();
 							
 						break;											
 						
 						case "btn_close":
 							window.close();
 						break;

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
   			 ComShowMessage(OBJECT_ERROR);
   	     } else {
   	         ComShowMessage(e);
   	     }
     	}
     }
     
     function loadPage() {    	 
    	    	
    	 if(opener.document.getElementById("title_id").value == "awk"){
    		 var row = opener.sheetObjects[1].SelectRow;  
    		 document.getElementById("remarks").value = opener.sheetObjects[1].CellValue(row, "diff_rmk");
    	 }
    	 
    	 if(opener.document.getElementById("title_id").value == "dg"){
    		 
    		 document.getElementById("remarks").value = opener.document.getElementById("diff_rmk").value
    	 }
    	 
    	 if(opener.document.getElementById("title_id").value == "rf"){
    		 
    		 document.getElementById("remarks").value = opener.document.getElementById("diff_rmk").value
    	 }
    	 
    	 if(opener.document.getElementById("title_id").value == "bb"){
    		 
    		 document.getElementById("remarks").value = opener.document.getElementById("diff_rmk").value
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
    		if( event.ctrlKey && event.keyCode == 65 ){
    			document.form.remarks.select();
    			return;
			}
    		
    		if( document.form.remarks.value.length > 0 ){
    			var lineStr = document.form.remarks.value.split("\r\n")
    			var idx = 0;
    			var jdx = 0;
    			var str = "";
    			var maxLen = document.form.remarks.cols;

    			//라인 내 50글자 허용
//    			document.form.remarks.value = "";
//    			for( idx=0; idx<lineStr.length; idx++ ){
//    				if( lineStr[idx].length > maxLen ){
//	    				str = "";
//    					for( jdx=0; jdx<lineStr[idx].length/maxLen; jdx++ ){
//    						if( jdx + 1 >= lineStr[idx].length/maxLen ){
//	    						str = str + lineStr[idx].substr(jdx*maxLen,maxLen);
//	    					} else{
//	    						str = str + lineStr[idx].substr(jdx*maxLen,maxLen) + "\r\n";
//	    					}
//	    				}
//	    				lineStr[idx] = str;
//    				}
//    				
//    				if( idx == lineStr.length - 1 ){
//    					document.form.remarks.value = document.form.remarks.value + lineStr[idx];
//    				} else{
//    					document.form.remarks.value = document.form.remarks.value + lineStr[idx] + "\r\n";
//    				}
//    			}
    			
    			//전체 글자 수 체크
    			if( document.form.remarks.value.replace(/\r\n/gi,"").length > 300 ){
    				ComShowMessage("300 characters exceeded.");
    				document.form.remarks.value = document.form.remarks.value.substr(0, (lineStr.length-1) * 2 + 300);
    				return;
	    		}

    			//전체 라인 수 체크
//    			lineStr = document.form.remarks.value.split("\r\n")
//    			if( lineStr.length > 6 ){
////    				ComShowMessage("6 lines exceeded.");
//    				document.form.remarks.value = "";
//    				for( idx=0; idx<6; idx++ ){
//    					if( idx == 6-1 ){
//    						document.form.remarks.value = document.form.remarks.value + lineStr[idx];
//    					} else{
//    						document.form.remarks.value = document.form.remarks.value + lineStr[idx] + "\r\n";
//    					}
//    				}
//    				return;
//    			}
    			
    			
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