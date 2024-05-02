
document.onclick = processButtonClick;

    function processButtonClick(){
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			
            switch(srcName) {
				
        	     case "btn_ok":
        	     	if(validateForm(formObject)){
	        	     	formObject.vvd.value = toUpperCase(formObject.vvd.value);
		    			formObject.nod.value = toUpperCase(formObject.nod.value);
	    	            window.opener.vvdTerminalUpdate(formObject.vvd.value,formObject.nod.value,formObject.call_port.value);
	    	            window.close();
        	     	}
        	        break;
        	        

        	    case "btn_close":
    	            window.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg('COM12111')) ;
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
		if(formObj.vvd.value == '' || formObj.nod.value == ''){
			ComShowMessage(getMsg('COM12113', 'VVD or Nod Code Infomation')) ;
			return false ;
		}
        return true;
    }