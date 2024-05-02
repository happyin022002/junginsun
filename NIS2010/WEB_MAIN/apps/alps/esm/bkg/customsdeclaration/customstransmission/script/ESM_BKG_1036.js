/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0136.js
 *@FileTitle : Remark
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.10
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.09.10 이수빈
 * 1.0 Creation
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class Remark : Remark 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0136() {
	this.processButtonClick		= tprocessButtonClick;
}

/* 개발자 작업	*/

//공통전역변수

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {
			
			case "btn_accept":
				window.opener.document.form.bl_mk_desc.value = formObject.mark_desc.value;
				window.close();
			break;				
			
			case "btn_close":
				window.close();
			break;												

         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
 }

	
/* 개발자 작업  끝 */