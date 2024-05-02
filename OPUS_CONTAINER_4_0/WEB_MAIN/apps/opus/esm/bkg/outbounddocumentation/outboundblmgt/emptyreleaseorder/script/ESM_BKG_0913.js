/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0913.js
*@FileTitle  : Edit Remark(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // 공통전역변수
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
	 var screen_id=ComGetObjValue(document.form.screen_id);
	 if ("9424"==screen_id || "0218"==screen_id || "0252"==screen_id || "0095"==screen_id) {
		 if (opener) sValue=opener.document.form.inter_rmk.value; 
		 else if (parent) sValue=parent.document.form.inter_rmk.value;  
		 ComSetObjValue(document.form.text_remark, sValue.trim());
	 }
 }
 
	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
	  * 선택한 버튼의 액션이 실행된다.
	  * @param 	Object  
	  * @return Object  
	  */
     function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_save":
					var result=ComGetObjValue(formObj.text_remark);
					if(!opener) opener=parent;  
					//ESM_BKG_9424
					if ("9424"==ComGetObjValue(formObj.screen_id)) {
						opener.callBack0913(result);
						ComClosePopup(); 
					} else if("0218"==ComGetObjValue(formObj.screen_id)){
				    	var sheetObject=opener.sheetObjects[opener.beforetab];
				    	var prefix=sheetObject.id;
						var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) {
								sheetObject.SetCellValue(arrRow[i],prefix+"remark",result,0);
							}
						}
						ComClosePopup(); 
						
					} else if("0252"==ComGetObjValue(formObj.screen_id)){
						   
						var sheetObject=opener.sheetObjects[0];
						var arrRow=sheetObject.FindCheckedRow("Check").split("|");
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) { 
								sheetObject.SetCellValue(arrRow[i],"diff_rmk",result,0);
							}
						}
						ComClosePopup(); 
						
					}else{
						opener.setRemark(result);
						ComClosePopup(); 
					}
					break;
				case "btn_clear":
					ComSetObjValue(formObj.text_remark, '');
					formObj.text_remark.focus();
					break;
				case "btn_close":
					ComSetObjValue(formObj.text_remark, '');
					formObj.text_remark.focus();
					ComClosePopup(); 
					break;
             } // end switch
     	} catch(e) {
   			ComShowMessage(e.message);
     	}
     }
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
	  * @param 	sheetObj,formObj,sAction  
	  * @return boolean  
	  */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }

 	function getMakeBr(obj) {
		var formObj=document.form;
		var arrVal = formObj.text_remark.value.split("\n");
		var strVal = "";
		if (arrVal.length > 0) {
	        for (var i=0; i < arrVal.length; i++) {
	          	var cnt = Math.ceil(arrVal[i].length / 70);
	            if (cnt > 1) {
	            	for (var j=0; j < cnt; j++) {
		            	strVal = strVal + arrVal[i].substring((j*70),(j*70)+70) + "\n";	            		
	            	}
	            }else{
	            	if (arrVal[i].length > 0) strVal = strVal + arrVal[i] + "\n";
	            }
	        }
		}
		formObj.text_remark.value = strVal.trim();	
	}
     
	/* 개발자 작업  끝 */
