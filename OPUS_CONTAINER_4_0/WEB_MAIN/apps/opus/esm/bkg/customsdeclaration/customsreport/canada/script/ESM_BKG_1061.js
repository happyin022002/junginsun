/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1061.js
*@FileTitle  : Notice-Files E-mail Attached Grouping option Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

//var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
//	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_OK":
			var rtnObject=new Object(); 
			if (formObject.attach_flg[1].checked) {
				if (ComIsNull(formObject.attach_max_cnt)) {
					ComShowCodeMessage('BKG00888', 'File Count');
					formObject.attach_max_cnt.focus();
					return;
				}
				rtnObject.attach_flg = "true";
				rtnObject.attach_max_cnt = formObject.attach_max_cnt.value;
			} else {
				rtnObject.attach_flg = "false";
				rtnObject.attach_max_cnt = 0;
			}
			//window.returnValue = obj;
			//window.close();
			ComPopUpReturnValue(rtnObject);
			ComClosePopup();
			break;
		case "btn_Close":
			//window.close();
			ComClosePopup();
			break;
		case "attach_max_cnt":
			formObject.attach_flg[1].checked = true;
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
}