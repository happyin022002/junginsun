/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0406.js
*@FileTitle  : Detail2
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class CPS_CNI_0406 : CPS_CNI_0406 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0406() {
    	this.processButtonClick=tprocessButtonClick;
    	this.loadPage=loadPage;
    }
   	/* 개발자 작업	*/
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/*******************************************************/
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_confirm":
			        if (!ComChkValid(formObject)) return false;
					var len=ComGetLenByByte(formObject.contents.value);
					if (len > 4000) {
						ComAlertFocus(formObject.contents, ComGetMsg("CNI09009", "Contents", "4000"));
					} else {
						eval("opener.form."+formObject.pop_cont_col.value).value=formObject.contents.value;
						//Interest와 Subject Matter Insured인 경우 name필드에도 세팅함.
						var pop_cont_col=formObject.pop_cont_col.value;
						if (pop_cont_col == "int_desc") {
							opener.form.int_desc_nm.value=formObject.contents.value;
						} else if (pop_cont_col == "subj_mat_ins_desc") {
							opener.form.subj_mat_ins_desc_nm.value=formObject.contents.value;
						}
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
    	form.contents.value=form.pop_cont_hidden.value;
    }
