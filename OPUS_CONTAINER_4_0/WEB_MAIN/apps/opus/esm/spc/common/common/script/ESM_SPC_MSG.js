
window.returnValue = 0;
var newMsgTxt = "\r\n========================================================\r\n\r\n"

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;

			switch(srcName) {

				case "btn_ok":
					window.returnValue = 1;
					close();
					break;

				case "btn_close":
				case "btn_cancel":
					window.returnValue = 0;
					close();
					break;
			    case "btn_copy":
			        var msg="";
			        msg += "======================================================== \r\n";
			        msg += "  Message Window \r\n";
			        msg += "======================================================== \r\n";
			        msg += document.form.msg.value;
    			    window.clipboardData.setData('Text', msg);
			        break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
			} else {
				ComShowMessage(e);
			}
		}
	}

	function loadPage(){
    	var arg = window.dialogArguments;
    	if( arg.constructor != String ){
    	    var str = "";
    	    for(var i=0 ; i <  arg.length ; i++){
    	        str +=  arg[i] ;
    	    }
    	    document.form.msg.value = str;
    	}else{
        	document.form.msg.value = arg;
    	}
    	

    }