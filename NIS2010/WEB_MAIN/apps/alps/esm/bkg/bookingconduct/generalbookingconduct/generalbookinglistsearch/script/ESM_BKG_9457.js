/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9457.js
*@FileTitle : Booking Receipt Draft BL EDI
*Open Issues :
*Change history :
**@LastModifyDate : 2013.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.17 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.04.09 김태경 [CHM-201323872] ALPS > Draft B/L &Freight Invoice EDI 화면 Multi Booking No 팝업 추가
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
     * @class ESM_BKG_9457 : ESM_BKG_9457 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_9457() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }


 // 공통전역변수

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var opener = window.dialogArguments;
     	 switch(srcName) {
         	    case "btn_ok":
         	    	if(ComIsNull(formObject.multi_value.value)) return;
         	    	if(formObject.multi_value.value.split('\n').length > 1000){
         	    		ComShowMessage(msgs['BKG08259']);
         	    		break;
         	    	}
         	    	opener.addValueNo(formObject.multi_value.value.toUpperCase());
         	    	self.close();
         	    break;
         	    case "btn_close":
         	    	self.close();
         	    break;
     	 }
     }

     function toUpperCase(str_){
         str="";
         for(i=0;i<str_.length;i++){
             str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
         }  
         return str;      
     }
