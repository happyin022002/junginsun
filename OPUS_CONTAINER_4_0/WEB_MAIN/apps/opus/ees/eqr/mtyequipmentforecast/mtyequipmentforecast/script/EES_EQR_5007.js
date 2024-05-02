/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_pso_0018.js
*@FileTitle  : Requested Advance Payment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
	 * @extends
	 * @class vop_pso_0018 : business script for vop_pso_0018
	 */
    function ees_eqr_5007() {
    	this.processButtonClick=tprocessButtonClick;
    }
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
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