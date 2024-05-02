
window.returnValue = "CANCEL";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_ok":
					var data = "";
					if(formObject.data[0].checked){
						data = "A";
					}
					if(formObject.data[1].checked){
						data = "D";
					}
					var format = "";
					if(formObject.format[0].checked){
						format = "Y";
					}
					if(formObject.format[1].checked){
						format = "N";
					}
					
					window.returnValue = data+format;
					close();
					break;

				case "btn_close":
					window.returnValue = "CANCEL";
					close();
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
    	if( arg != true ){
    	    document.form.data[0].disabled = true;
    	    document.form.data[1].checked = true;
    	    
    	}
    }	