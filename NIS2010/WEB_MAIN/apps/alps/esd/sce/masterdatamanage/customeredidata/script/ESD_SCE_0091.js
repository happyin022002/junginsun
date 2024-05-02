
// 공통전역변수

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	
	 switch(srcName) {
    	    case "btn_ok":
                if(!ComIsEmpty(formObject.from_row) && !ComIsEmpty(formObject.end_row)){
    	            if((ComParseInt(formObject.from_row.value) < ComParseInt(formObject.end_row.value)) && (ComParseInt(formObject.from_row.value) + 100 > ComParseInt(formObject.end_row.value))){
    	                window.returnValue = formObject.from_row.value+","+formObject.end_row.value;    	            
                        self.close();
    	            } else {
                        alert('Please, Insert in the range of 100 rows.');

    	            }
    	        } else {
    	            alert('from row and to row is required.');

    	        }
    	    break;
    	    case "btn_close":
    	    	self.close();
    	    break;
	 }
}

function isNum(obj){
	if (!ComIsNumber(obj)){
		obj.value = '';
	}
}

