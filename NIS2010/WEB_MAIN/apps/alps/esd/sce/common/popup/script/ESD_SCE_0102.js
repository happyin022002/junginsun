var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			// E-mail Template을 가져온다
			formObj.f_cmd.value = SEARCH10;
			//GET방식으로 조회XML 읽어오기
		 	var sXml = sheetObj.GetSearchXml("ESD_SCE_0102GS.do", SceFrmQryString(formObj));
		 	formObj.send_eml2.value = ComGetEtcData(sXml, "send_eml2");
			formObj.contents1.value = ComGetEtcData(sXml, "contents1");
			formObj.contents2.value = ComGetEtcData(sXml, "contents1");
			break;
	   case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}



   /**
    * IBSheet Object를 배열로 등록
    * ComSheetObject(id)에서 호출한다
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
   function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
   }

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetNum = 0;
	/*******************************************************/
	var formObject = document.form;

//	try{
		var srcName = window.event.srcElement.getAttribute("name");
		if( formObject.selection[0].checked) {
			sheetObject = sheetObjects[0];
			sheetObj = sheetObjects[0];
			sheetNum = 0;
		} else {
			sheetObject = sheetObjects[1];
			sheetObj = sheetObjects[1];
			sheetNum = 1;
		}
		switch(srcName) {
			case "selection":
				if( formObject.selection[0].checked) {
					document.getElementById("location").style.display= "";
					document.getElementById("node").style.display= "none";
				} else if( formObject.selection[1].checked) {
					document.getElementById("node").style.display= "";
					
					document.getElementById("location").style.display= "none";
				}
				break;			
			case "btn_send" :
				if( validateForm(formObject,sheetNum)) {
					if( !ComShowConfirm( "Do you really want to send Email ?")) {
						return false;
					}
					
						// target 변경
						if( sheetNum == 0) {
							formObject.send_eml3.value = formObject.send_eml1.value;
							formObject.subject.value = formObject.subject1.value;
							formObject.contents.value = formObject.contents1.value;
							formObject.attachnm.value = formObject.attachNm1.value;	
							formObject.f_cmd.value = MODIFY01 ;
							// formObject.action 을 ESD_SCE_0102GS.do 로 줄 경우 XML 파싱 에러 발생..
	    	            	formObject.action      = "ESD_SCE_0102.do" ;
	    	           	 	formObject.submit() ;													
						} else if ( sheetNum == 1) {
							formObject.send_eml3.value = formObject.send_eml2.value;
							formObject.subject.value = formObject.subject2.value;
							formObject.contents.value = formObject.contents2.value;
							formObject.attachnm.value = formObject.attachNm2.value;	
							
							//alert(formObject.attachNm.value);
							
							formObject.f_cmd.value = MODIFY01 ;
							//sheetObj.DoSearch4Post("ESD_SCE_0102.do", SceFrmQryString(formObject));
	    	            	formObject.action      = "ESD_SCE_0102.do" ;
	    	           	 	formObject.submit() ;															
						}
											

				}

				break;
			
			case "btn_close" :
				self.close();
				break;
//			case "btn_search" :
//				window.showModelessDialog('COM_ENS_091.do?usr_nm='+formObj.disname.value, window, "scroll:no;status:no;help:no;dialogWidth:620px;dialogHeight:450px");
//				break;
//			case "btn_attach" :
//				break;

		}
/*	
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
*/
}

/**
 * SStaaf 공통 팝업에서 호출하는 함수
 *
 * @param rowArray 결과값
 */
function setValFromStaffArray_new(collArray, gubun, i){


//	var idlist  = document.getElementById("send_id");
//	var namelist  = document.getElementById("send_nm");
	var emllist  = document.getElementById("send_eml");

//	var uid = collArray[4];
	var uname =  collArray[5];
	var eml =  collArray[6];

	if( eml.length > 1 && check_duplicate(eml, emllist.value)) {
//안쓴답니다 .
//		idlist.value = idlist.value+uid+";";
//		namelist.value = namelist.value+uname+";";
		emllist.value = emllist.value+eml+";";


	} else if (eml.length <= 0) {
		alert( "USER '" + uname + "' Have no Email Address ");
	}

 }

function check_duplicate( umail, list) {
	var token = list.split(";");

	for( var i =0; i < token.length; i++) {
		if (umail == token[i]) {
			return false;
		}
	}
	return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObject,sheetNum){


	// target 변경
	if( sheetNum == 0) {
		if( ComIsEmpty( formObject.send_eml1)) {
			alert( "Please Insert Email Address");
			return false;
		}
		if ( ComIsEmpty( formObject.subject1)) {
			alert( "Please Insert Email Subject");
			return false;
		}
		if ( ComIsEmpty( formObject.contents1)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( ComIsEmpty ( formObject.attachNm1)) {
			alert( "Please Insert Email Contents");
			return false;
		}
	
		if( formObject.send_eml.value.match("[',', '|']") != null) {
			alert( "Please divide ';' character between email address ");
			return false;
		}
		return true;		
	} else if ( sheetNum == 1) {
		if( ComIsEmpty( formObject.send_eml2)) {
			alert( "Please Insert Email Address22");
			return false;
		}
		if ( ComIsEmpty( formObject.subject2)) {
			alert( "Please Insert Email Subject");
			return false;
		}
		if ( ComIsEmpty( formObject.contents2)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( ComIsEmpty ( formObject.attachNm2)) {
			alert( "Please Insert Email Contents");
			return false;
		}
	
		if( formObject.send_eml.value.match("[',', '|']") != null) {
			alert( "Please divide ';' character between email address ");
			return false;
		}
		return true;		
	}


}
