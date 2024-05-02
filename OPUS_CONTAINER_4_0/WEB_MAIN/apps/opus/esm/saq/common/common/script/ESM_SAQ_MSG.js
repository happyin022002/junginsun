/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_MSG.js
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
	window.returnValue=0;
	var newMsgTxt="\r\n========================================================\r\n\r\n"
	var rtnValue;
	document.onclick=processButtonClick;
	function processButtonClick(){
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_close":
					rtnValue = 0;
					ComPopUpReturnValue(rtnValue);
					ComClosePopup();
					break;
					
				case "btn_ok":
					rtnValue = 1;
					ComPopUpReturnValue(rtnValue);
					ComClosePopup();
					break;	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");  
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function loadPage(){
    	var arg=window.dialogArguments;
    	if (!arg) arg=parent.msgArr;
	    var str="";
	    for(var i=0 ; i <  arg.length ; i++){
	        str +=  arg[i] ;
	    }
	    document.form.msg.value=str;
		if(document.form.btnFlg.value == false)	   	
		    ComEnableObject(btn_ok, false);   
    }
	
	function btnImgEnable(obj, gb) {
		if(obj.constructor == String){
			obj=document.getElementsByName(obj)[0];
		}
		var btnStyle=obj.style;
		if (gb){
			obj.SetEnable(1);
			btnStyle.cursor="hand";
			btnStyle.filter="";
		} else {
			obj.SetEnable(0);
			btnStyle.cursor="auto";
			btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
		}
	}    