/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0040.js
*@FileTitle : CCC Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.17
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.17 정행룡
* 1.0 Creation
=========================================================*/
 /**
 * [CPS_CNI_0040] CCC Detail
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
    function CPS_CNI_0040() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    }
    
   	/* 개발자 작업	*/


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_save":
				
			        if (!ComChkValid(formObject)) return false;

					var len = ComGetLenByByte(formObject.contents.value);
//					if (len > 4000) {
//						ComAlertFocus(formObject.contents, ComGetMsg("CNI09009", "Contents", "4000"));
//					} else {
						
						eval("opener.form."+ formObject.pop_cont_col.value).value= formObject.contents.value;
						window.close();
//					}
					
	            break;
				
				case "btn_close":
					window.close();
				break;  

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//form.contents.value = form.pop_cont_hidden.value;
    }

	
	/* 개발자 작업  끝 */