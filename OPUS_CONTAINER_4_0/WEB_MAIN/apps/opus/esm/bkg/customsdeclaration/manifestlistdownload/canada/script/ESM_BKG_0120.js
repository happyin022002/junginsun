/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0120.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/

/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0120() {
	this.processButtonClick=processButtonClick;
	this.loadPage=loadPage;
}
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name")
		var isOpen=false;
		var sUrl="";
		var sId="";
		switch (srcName) {
		/*********************************************
		 * Origin Menu
		 *********************************************/
		case "btn_1_1":
			sUrl="ESM_BKG_0249.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0249";
			sId="ESM_BKG_0249"
			break;
		case "btn_1_2":
			sUrl="ESM_BKG_0111.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0111_03";
			sId="ESM_BKG_0111"
			break;
		case "btn_1_3":
			sUrl="ESM_BKG_0393.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0393_3";
			sId="ESM_BKG_0393"
			break;
		case "btn_1_4":
			sUrl="ESM_BKG_0210.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG-0210_3";
			sId="ESM_BKG_0210"
			break;
		case "btn_1_5":
			sUrl="ESM_BKG_0002.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0002";
			sId="ESM_BKG_0002"
			break;
		case "btn_1_6":
			sUrl="ESM_BKG_0028.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0028_3";
			sId="ESM_BKG_0028"
			break;
		case "btn_1_7":
			sUrl="ESM_BKG_0029.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0029";
			sId="ESM_BKG_0029"
			break;
		case "btn_1_8":
			sUrl="ESM_BKG_0500.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0500";
			sId="ESM_BKG_0500"
			break;
		case "btn_1_9":
			sUrl="ESM_BKG_0431.do?pid=ESM_BKG_M047&mainPage=true&&pgmNo=ESM_BKG_0431";
			sId="ESM_BKG_0431"
			break;
		case "btn_1_10":
			sUrl="ESM_BKG_0142.do?pid=ESM_BKG_M047&mainPage=true&pgmNo=ESM_BKG_0142";
			sId="ESM_BKG_0142"
			break;
		/***************************************************************************************************************
		 * Canada Menu
		 **************************************************************************************************************/
		case "btn_2_1":
			sUrl="ESM_BKG_0249.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0249";
			sId="ESM_BKG_0249"
			break;
		case "btn_2_2":
			sUrl="ESM_BKG_0210.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG-0210_4";
			sId="ESM_BKG_0210"
			break;
		case "btn_2_3":
			sUrl="ESM_BKG_0002.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0002_2";
			sId="ESM_BKG_0002"
			break;
		case "btn_2_4":
			sUrl="ESM_BKG_0015.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0015";
			sId="ESM_BKG_0015"
			break;
		case "btn_2_5":
			sUrl="ESM_BKG_0568.do?mainPage=true&pgmNo=ESM_BKG_0568";
			sId="ESM_BKG_0568"
			break;
		case "btn_2_6":
			sUrl="ESM_BKG_0028.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0028_4";
			sId="ESM_BKG_0028"
			break;
		case "btn_2_7":
			sUrl="ESM_BKG_0029.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0029_2";
			sId="ESM_BKG_0029"
			break;
		case "btn_2_8":
			sUrl="ESM_BKG_0025.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0025";
			sId="ESM_BKG_0025"
			break;
		case "btn_2_9":
			sUrl="ESM_BKG_0013.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0013";
			sId="ESM_BKG_0013"
			break;
		case "btn_2_10":
			sUrl="ESM_BKG_0016.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0016";
			sId="ESM_BKG_0016"
			break;
		case "btn_2_11":
			sUrl="ESM_BKG_0354.do?pid=ESM_BKG_M048&mainPage=true&pgmNo=ESM_BKG_0354";
			sId="ESM_BKG_0354"
			break;
		} // end switch
		if (sId != "")
			module_pop(sUrl, sId);
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}
/**
 * 팝업 오픈
 * @param url URL
 * @param id ID
 */
function module_pop(url, id) {
	try {
        var btn_nm = ComGetEvent("name");
        var obj = document.getElementById(btn_nm);
        if (ComIsBtnEnable(btn_nm)) {
            var winObj = window.open(url + "&parentPgmNo=ESM_BKG_M001");
            winObj.focus();
        }
     } catch(err) { alert(err.message); }
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	if (document.form.menu_type.value == "Origin") {
		ComBtnDisable("btn_2_1");
		ComBtnDisable("btn_2_2");
		ComBtnDisable("btn_2_3");
		ComBtnDisable("btn_2_4");
		ComBtnDisable("btn_2_5");
		ComBtnDisable("btn_2_6");
		ComBtnDisable("btn_2_7");
		ComBtnDisable("btn_2_8");
		ComBtnDisable("btn_2_9");
		ComBtnDisable("btn_2_10");
		ComBtnDisable("btn_2_11");
	} else {
		ComBtnDisable("btn_1_1");
		ComBtnDisable("btn_1_2");
		ComBtnDisable("btn_1_3");
		ComBtnDisable("btn_1_4");
		ComBtnDisable("btn_1_5");
		ComBtnDisable("btn_1_6");
		ComBtnDisable("btn_1_7");
		// ComBtnDisable("btn_1_8");
		// ComBtnDisable("btn_1_9");
		// ComBtnDisable("btn_1_10");
	}
	axon_event.addListener('MouseOver', 'obj_MouseOver', "form");
	axon_event.addListener('MouseOut', 'obj_MouseOut', "form");
}
/**
 * 마우스 오버 시 언더라인 및 글자색 변경
 */
function obj_MouseOver() {
	var btn_nm=$(ComGetEvent()).prop('id');
	var obj=document.getElementById(btn_nm);
	if (ComIsBtnEnable(btn_nm)) {
		obj.style.textDecoration="underline";
		obj.style.color="#30A5D0";
	}
}
/**
 * 마우스 아웃 시 언더라인 및 글자색 변경
 */
function obj_MouseOut() {
	var btn_nm=$(ComGetEvent()).prop('id');
	var obj=document.getElementById(btn_nm);
	if (ComIsBtnEnable(btn_nm)) {
		obj.style.textDecoration="none";
		obj.style.color="#737373";
	}
}
