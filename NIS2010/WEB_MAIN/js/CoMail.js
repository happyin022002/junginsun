/**
 * ===============================================================================
 * 프로그램 명 : 메일 처리 관련 공통 함수 정의 Script 프로그램개요 : 메일 전송 함수 정의 작 성 자 : 김정훈 작 성 일 :
 * 2009-04
 * ===============================================================================
 * 수정자/수정일 : 수정사유/내역 :
 * ===============================================================================
 */

function CoMail() {
	this.ComSendMail = ComSendMail;
	this.ComSendGroupwareMail = ComSendGroupwareMail;
	this.ComOpenGroupwareMail = ComOpenGroupwareMail;
}

/**
 * Mail의 Popup 을 띄운다.
 * @fileoverview mail 관련 함수가 정의되어 있다.
 * @author 한진해운
 * @return 없음
 */
function ComSendMail() {
	ComPostOpenWindow("/hanjin/syscommon/common/mail/jsp/COM_MAIL_COMMON_POPUP_MODALESS.jsp", "mail", "Width=770, Height=768, status=no");
}

/**
 * Mail의 Popup 을 띄운다.
 * @fileoverview mail 관련 함수가 정의되어 있다.
 * @author 한진해운
 * @return 없음
 */
function ComSendMailModal() {
	  window.showModalDialog("/hanjin/syscommon/common/mail/jsp/COM_MAIL_COMMON_POPUP_MODAL.jsp", window, "dialogWidth:770px;dialogHeight:768px;status:no");
}

/**
 * Contents와 Subject를 포함하는 Groupware Popup을 띄운다.
 */
function ComOpenGroupwareMail(sheetObj, formObj){
	var sXml = sheetObj.GetSearchXml("Groupware_Mail_PopupGS.do", FormQueryString(formObj));
	if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F"){
		alert("Please Check your status of SSO.");
	} else if(ComGetEtcData(sXml,"GroupwarePopupURL").indexOf('FAIL') > -1) {
		alert(ComGetEtcData(sXml,"GroupwarePopupURL"));
	} else {
		window.open(ComGetEtcData(sXml,"GroupwarePopupURL"));
	}
}