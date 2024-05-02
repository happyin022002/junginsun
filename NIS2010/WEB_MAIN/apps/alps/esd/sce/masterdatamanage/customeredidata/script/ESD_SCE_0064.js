
// 공통전역변수

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var opener = window.dialogArguments;
    	 switch(srcName) {
        	    case "btn_ok":
        	    	opener.addValueNo(formObject.dist.value, formObject.multi_value.value);
        	    	self.close();
        	    break;
        	    case "btn_close":
        	    	self.close();
        	    break;
    	 }
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
    }


	
	
	
