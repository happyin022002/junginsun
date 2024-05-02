/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_SCE_0164.js
 *@FileTitle : Copy E-mail sending option
 *Open Issues :
 *@LastModifyDate : 2012.05.21
 *@LastModifier : Chang chang Ho
 *@LastVersion : 1.0
 * 1.0 Creation
 * --------------------------------------------------------
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
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0164 : ESD_SCE_0164 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


function ESD_SCE_0164() {
	this.processButtonClick = tprocessButtonClick;
	this.loadPage = loadPage;
	this.initControl = initControl;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function processButtonClick() {
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_ok":
			saveStatusOk();
			break;

		case "btn_close":
            window.close();
			break;
		
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function initControl() {
//    axon_event.addListenerForm('keyup', 'objKeyUp', form ); 
    axon_event.addListenerForm('keypress', 'objKeyPress', document.form);
}


 
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을<br>
 * 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function loadPage() {
//	 var formObject = document.form;
//     formObject.cntr_no.value = opener.parent.document.form.cntr_no_list.value;
//     alert(formObject.cntr_no.value); 
	 initControl();
}
 
 /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            sAction 필수, 작업코드
 * @return {boolean} Validation 결과값
 * @author Park Mangeon
 * @version 2009.10.01
 */
 function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    if(!ComChkValid(formObj)) return false;
    return true;
 }


/**
* 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
* <br>
* <b>Example : </b>
*
* <pre>
* </pre>
*
* @param {void}
* @return void
* @author Park Mangeon
* @version 2009.10.01
*/
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
	    case "cntr_no":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "other_cntr_no":
	    	ComKeyOnlyAlphabet('uppernum');
	    	break;
    }
}

function saveStatusOk(){
	var formObject = document.form;
	if (document.form.cntr_no1.value != ''){
	 	var other_cntr_no = document.form.cntr_no1.value;
     	var cnrtList  = document.form.cntr_list.value.split(",");
		var count = "0";
		 for (idx=0; idx<cnrtList.length; idx++){
			  if(other_cntr_no == cnrtList[idx]){
				   count++;	
			   }  
		  }
		
		 if(count == 0){
			 ComShowMessage("선택된 cntr_no가 아닙니다. 선택된 cntr_no 중에서 입력을 해주세요");
			 document.form.cntr_no1.focus();
			 return false;
		 }
		 
		 formObject.f_cmd.value = MULTI;
		 formObject.action = 'ESD_SCE_0164.do';
		 formObject.submit();
	}else{
		
		 formObject.f_cmd.value = MULTI;
		 formObject.action = 'ESD_SCE_0164.do';
		 formObject.submit();
	}
	
}
