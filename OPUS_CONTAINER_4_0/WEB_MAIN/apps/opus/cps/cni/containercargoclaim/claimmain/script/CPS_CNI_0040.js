/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0040.js
*@FileTitle  : CCC Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
 /**
 * [CPS_CNI_0040] CCC Detail
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
   	/* 개발자 작업	*/
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/*******************************************************/
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_save":
			        if (!ComChkValid(formObject)) return false;
					var len=ComGetLenByByte(formObject.contents.value);
					if (len > 4000) {
						ComAlertFocus(formObject.contents, ComGetMsg("CNI09009", "Contents", "4000"));
					} else {
						eval("opener.form."+ formObject.pop_cont_col.value).value=formObject.contents.value;
						ComClosePopup(); 
					}
	            break;
				case "btn_close":
					ComClosePopup(); 
				break;  
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	//form.contents.value = form.pop_cont_hidden.value;
    }
