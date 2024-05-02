/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0136.js
*@FileTitle  :  Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/**
 * @extends 
 * @class Remark : Remark 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0136() {
	this.processButtonClick=tprocessButtonClick;
}
/* 개발자 작업	*/
//공통전역변수
var opener_obj=window.dialogArguments;
if (!opener_obj) opener_obj=parent;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
         switch(srcName) {
			case "btn_accept":
//				window.opener_obj.document.form.bl_mk_desc.value=formObject.mark_desc.value;
				opener_obj.document.getElementById("bl_mk_desc").value = formObject.mark_desc.value;
				ComClosePopup(); 
			break;				
			case "btn_close":
				//window.close();
				ComClosePopup(); 
			break;												
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
/* 개발자 작업  끝 */
