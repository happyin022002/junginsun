/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_XLS.js
*@FileTitle  : Excel Save Kind 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/

window.returnValue="CANCEL";
	//Event handler processing by button click event */
document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_ok":
					var data="";
					if(formObject.data[0].checked){
						data="A";
					}
					if(formObject.data[1].checked){
						data="D";
					}
					var format="";
					if(formObject.format[0].checked){
						format="Y";
					}
					if(formObject.format[1].checked){
						format="N";
					}
					ComPopUpReturnValue(data+format);
                    ComClosePopup();
					break;
				case "btn_close":
					window.returnValue="CANCEL";
					ComClosePopup();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(getMsg("COM12111"));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	function loadPage(data, format){
    	var arg=window.dialogArguments;
    	if( arg != true ){
    	    document.form.data[0].disabled=true;
    	    document.form.data[1].checked=true;
    	}
    	if( data == "A"){                           // data All
          document.form.data[0].checked=true;
    	  document.form.data[1].checked=false;          
    	}else if( data == "D" ){                    // data designed
          document.form.data[0].checked=false;
    	  document.form.data[1].checked=true;      	  
    	}
    	if( format == "Y"){                         // format Yes
          document.form.format[0].checked=true;
    	  document.form.format[1].checked=false;          
    	}else if( data == "N" ){                    // format No
          document.form.format[0].checked=false;
    	  document.form.format[1].checked=true;      	  
    	}    	
    }	