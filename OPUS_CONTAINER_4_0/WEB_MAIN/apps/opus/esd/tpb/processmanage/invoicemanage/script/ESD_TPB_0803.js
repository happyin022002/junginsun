/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0803.jsp
*@FileTitle  : Collection Agency Remarks
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0803 : business script for ESD_TPB_0803
     */
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	function processButtonClick(){
		try {
			var srcName=ComGetEvent("name");
			with(document.form) {
				switch (srcName) {
					case "btn_retrieve":
						f_cmd.value=SEARCH;
						action='ESD_TPB_0803.do';
						submit();	
						break;
					case "btn_save":					
//						window.returnValue=document.form.s_clt_agn_rmk.value;
//						ComShowCodeMessage('COM12149','Data','','');
//						ComClosePopup();

						var obj=new Object();
						obj.s_clt_agn_rmk = document.form.s_clt_agn_rmk.value;;
						
						if ( obj.s_clt_agn_rmk==null || obj.s_clt_agn_rmk.length==0){
						    /// There is no valid Message data! 
						    ComShowCodeMessage('TPB90045');
						    return;
						} else {
							ComShowCodeMessage('COM12149','Data','','');
							ComPopUpReturnValue(obj);
						}						
						break;
					case "btn_close":
						ComClosePopup(); 
						break;
				} // end switch
			}// end with
		} catch(e) {
			if( e="[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/* Finishing work */
