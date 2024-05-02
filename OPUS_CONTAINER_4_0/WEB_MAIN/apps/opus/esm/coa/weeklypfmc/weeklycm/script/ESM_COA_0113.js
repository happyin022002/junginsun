/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0113.js
*@FileTitle  : Select Creation Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_OK":
            		var rtnValue = formObj.rdoType.value
            		ComPopUpReturnValue(rtnValue);
                case "btn_Close":
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
    /**
     * Handling process for form object input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (!ComIsNumber(iPage)) {
                return false;
            }
        }
        return true;
    }