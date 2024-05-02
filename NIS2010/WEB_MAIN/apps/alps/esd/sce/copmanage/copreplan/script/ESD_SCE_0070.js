var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /*******************************************************/
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

        	     case "btn_save":
					doActionIBSheet(sheetObj,formObj,IBSAVE);
        	        break;
        	    case "btn_close":
    	            window.close();
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
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}
 
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSAVE:
					formObj.f_cmd.value = MODIFY;
					formObj.action = "ESD_SCE_0070.do" ;
					formObj.submit();
					var r_copNo = formObj.cop_no.value;
					var r_bkgRcvNo = formObj.bkg_rcv_no.value;
					var r_bkgRcvDt = formObj.bkg_rcv_dt.value;
					var ssss = 	"ESD_SCE_0070.do?f_cmd=3&cop_no="+r_copNo+"&bkg_rcv_no="+r_bkgRcvNo+"&bkg_rcv_dt="+r_bkgRcvDt;				
					alert("Successfully Saved.")
					var newWin  = window.open(ssss,"aaa", "width=1000,height=350" );
			break;				
	}
}
