/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0913.js
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
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
     * @author 한진해운
     */

    /**
     * @extends 
     * @class esm_bkg_0913 : esm_bkg_0913 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0913() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;


 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
	 var screen_id = ComGetObjValue(document.form.screen_id);
	 if ("9424"==screen_id || "0218"==screen_id || "0252"==screen_id) {
		 ComSetObjValue(document.form.text_remark, window.dialogArguments.document.form.inter_rmk.value);
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
        var formObj = document.form;
//     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_save":
					var result = ComGetObjValue(formObj.text_remark); 
					//ESM_BKG_9424
					if ("9424"==ComGetObjValue(formObj.screen_id)) {
						window.dialogArguments.callBack0913(result);
						window.close();
					//ESM_BKG_0218
					} else if ("0218"==ComGetObjValue(formObj.screen_id)) {
						window.dialogArguments.setRemark(result);
						window.close();
					//ESM_BKG_0252(Emtpy Container Release Order)
					} else if ("0252"==ComGetObjValue(formObj.screen_id)) {
						window.dialogArguments.setRemark(result);
						window.close();
					} else {
						opener.setRemark(result);
					}
					break;
				case "btn_clear":
					ComSetObjValue(formObj.text_remark, '');
					formObj.text_remark.focus();
					break;
				case "btn_close":
					window.close();
					break;
             } // end switch
//     	} catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
     }

	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
	  * @param 	sheetObj,formObj,sAction  
	  * @return boolean  
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