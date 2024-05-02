/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_CONFIRM.js
*@FileTitle : EES_MNR_CONFIRM
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0   
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**	
     * @extends Mnr   
     * @class ees_mnr_confirm :  business script for ees_mnr_confirm.
     */ 
    function ees_mnr_confirm() {    
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm; 
    }     
   	/* developer job	*/  
	var returnval = "";
	  
	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	 
	/* Event handler processing by button name */
	function processButtonClick(){
		
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Row0":
					returnval = "0"; 
					comPopupOK(formObject);
					window.close();
				break;  
				 
				case "btn_Row1":
					returnval = "1"; 
	    			comPopupOK(formObject);
					window.close();
				break;
				
				case "btn_Row2": 
					returnval = "2";   
					comPopupOK(formObject);
					window.close();
				break;
				
				case "btn_Row3":  
					returnval = "3";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row4":  
					returnval = "4";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row5": 
					returnval = "5"; 
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row6":  
				    returnval = "6";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row7":
					returnval = "7";
					comPopupOK(formObject);   
					window.close();
				break;	
				
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
			}	
		}
	}
	
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {	 
					  
	}
		
	function comPopupOK(formObject) {  
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		opener.getMnr_Confirm(returnval);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		window.close();	 	                 
	}   
	/* developer job */ 
