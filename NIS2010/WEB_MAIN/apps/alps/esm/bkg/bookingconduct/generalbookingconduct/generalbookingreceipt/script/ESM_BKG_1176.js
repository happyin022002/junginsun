/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1176.jsp
*@FileTitle : Notice To Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.10.11 류대영
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

    function ESM_BKG_1176() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var formObject = document.form;
    	var mainFormObj = window.dialogArguments.document.form;	

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		switch(srcName) {             
 		     	case "btn1_Yes":
 		     		mainFormObj.vsl_cng_rsn.value = ComGetObjValue(formObject.vsl_cng_rsn);
 					window.close();
 		        	break;
               
 		        case "btn1_No":
 		     		mainFormObj.vsl_cng_rsn.value = "";
 					window.close();
 					break;
            } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
     		} else {
     			ComShowMessage(e);
     		}
     	}
    }
    
 	function loadPage() {
        initControl();
         
        var formObject = document.form;
    }

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
    function initControl() {
     	var formObject = document.form;
    } 	 

	/* 개발자 작업  끝 */