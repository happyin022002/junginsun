/*--==============================================================================
'주  시 스 템 : ESD_TES_9080.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_9080.js
'프로그램 명	 : Terminal / Storage Agreement Rate List Remark Search 및 Insert 처리
'프로그램개요 : Terminal / Storage Agreement Rate List Remark Search 및 Insert 처리
'작   성   자 :
'작   성   일 :
==================================================================================
==============================================================================--*/

// 공통전역변수


var docObjects = new Array();
var sheetCnt = 0;

/**
 *  버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 **/
document.onclick = processButtonClick;

	/**
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 **/
	function processButtonClick(){
		var formObject = document.form;
		var cellSaveName1  = "";
		var cellSaveName2  = "";
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_apply":
            		var openerFormObject = eval('window.opener.document.'+document.form.sheetObj.value);

					if(document.form.sheetObj.value == "t2sheet1"){
						cellSaveName1 = "3agmt_dtl_rmk";
						cellSaveName2 = "3remark";
					} else if(document.form.sheetObj.value == "t4sheet1"){
						cellSaveName1 = "5agmt_dtl_rmk";
						cellSaveName2 = "5remark";
					}
					openerFormObject.CellValue2(document.form.row.value,cellSaveName1) = document.form.agmt_dtl_rmk.value;
					openerFormObject.CellValue2(document.form.row.value,cellSaveName2) = cutStr(document.form.agmt_dtl_rmk.value,5);

    	            window.close();
    	            break;

         	    case "btn_close":
         	    	window.close();
    	            break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21025');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


	/**
	 * 문자열 자르기.<br>
	 * @param{str}		str		String Value
	 * @param{limit}	limit	문자열 자를 Byte
	 */
	function cutStr(str,limit){
		var tmpStr = str;
		var byte_count = 0;
		var len = str.length;
		var dot = "";
	
		for(i=0; i<len; i++){
			byte_count += chr_byte(str.charAt(i));
			
			if(byte_count == limit-1){
				
				if(chr_byte(str.charAt(i+1)) == 2){
					tmpStr = str.substring(0,i+1);
					dot = "...";
					
				} else {
					
					if(i+2 != len) dot = "...";
					tmpStr = str.substring(0,i+2);
				}
				break;
			} else if(byte_count == limit){
		
				if(i+1 != len) dot = "...";
				tmpStr = str.substring(0,i+1);
				break;
			}
		}

		return (tmpStr+dot);
	}

	/**
	 * Character Byte. <br>
	 * @param{chr}		chr		Character
	 */
	function chr_byte(chr){
		
		if(escape(chr).length > 4)
			return 2;
		else
			return 1;
	}