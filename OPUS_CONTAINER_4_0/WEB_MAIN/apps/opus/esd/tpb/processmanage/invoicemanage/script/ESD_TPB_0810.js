/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0810.js
*@FileTitle : Invoice Cancel Remark 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_TPB_0810 : business script for ESD_TPB_0810
     */
    function ESD_TPB_0810() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
   	
    /* Event handler defined process to button click event */
	document.onclick = processButtonClick;
	function processButtonClick(){
		var srcName = window.event.srcElement.getAttribute("name");
		with(document.form) {
			switch (srcName) {
			case "btn_save":
				var obj=new Object();
				obj.remark = document.form.s_invoice_cancel_remark.value;
				
                if ( obj.remark==null || obj.remark.length==0){
                    /// There is no valid Message data! 
                    ComShowCodeMessage('TPB90045');
                    return;
                } else {
                	obj.result = true;
                	ComPopUpReturnValue(obj);
                }
				break;		
			case "btn_close":
				ComClosePopup();
				break;
			} // end switch
		}// end with
	}
	/* Finishing work */