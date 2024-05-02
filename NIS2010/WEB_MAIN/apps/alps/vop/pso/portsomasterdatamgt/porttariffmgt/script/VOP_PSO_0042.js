/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_PSO_0042.js
*@FileTitle : Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2014.07.08
* 1.0 Creation
 *----------------------------------------------------------
 * History
=========================================================*/

/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class VOP_PSO_0042 : VOP_PSO_0042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0042() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initControl = initControl;
}

/* 개발자 작업	*/
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//공통전역변수
var PORT_TRF_RMK_LENGTH = 4000;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	var formObj = document.form;
	
	//Remark 조회
    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    
	if (sCaller == "0036") {		// Port Tariff Inquiry 화면에서 호출시
		formObj.remark.readOnly  = "readOnly";
		//formObj.remark.className = "textarea2";

		ComBtnDisable("btn_select");
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		
		case "btn_select":
			var remark = ComGetObjValue(formObject.remark);
			remark = remark.split("\r\n").join("`");
			
			if (!gf_CheckOverLengthString(remark, PORT_TRF_RMK_LENGTH)) {
				eval("window.dialogArguments." + sFunc + "(remark)");    // JSP에서 request.getParameter로 받은 param
	            window.close();
			}
			else {
				alert("Your input exceeds the " + PORT_TRF_RMK_LENGTH + " character limit");
			}
		break;
	
		case "btn_close":
			window.close();
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction ) {
	sheetObj.ShowDebugMsg = false;
    sheetObj.WaitImageVisible=false;
	
	switch(sAction) {

		case IBSEARCH:      //조회

			if(!validateForm(sheetObj, formObj, sAction)) return;
       		
       		ComSetObjValue(formObj.f_cmd, SEARCH);
       		
       		ComOpenWait(true);
       		var sXml = sheetObj.GetSearchXml("VOP_PSO_0042GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
			var portTrfRmk = ComGetEtcData(sXml,"port_trf_rmk");
			if (typeof(portTrfRmk) != "undefined") {
				portTrfRmk = portTrfRmk.split("`").join("\r\n");
				ComSetObjValue(formObj.remark, portTrfRmk);
			}
       	break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	
	var isValid = true;
	
    with(formObj) {
    	switch (sAction) {
    		case IBSEARCH:
	        	if (ComGetObjValue(formObj.yd_chg_no) == "") {
	        		isValid = false;
	        	}
	        	else if (ComGetObjValue(formObj.yd_chg_no) == "") {
	        		isValid = false;
	        	}
	       	break;
    	}
    }

    return isValid;
}

/* 개발자 작업  끝 */