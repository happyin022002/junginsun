/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0915.jsp
*@FileTitle  : BKG Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
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
    	            alert("btn_ok Click!!");
        	        break;

        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
    		} else {
    			ComShowMessage(e) ;
    		}
    	}
    }

