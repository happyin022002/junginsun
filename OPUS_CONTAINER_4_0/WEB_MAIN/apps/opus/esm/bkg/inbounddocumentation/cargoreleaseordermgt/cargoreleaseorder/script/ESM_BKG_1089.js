/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1089.js
*@FileTitle  : Hold/Internal Remark Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
document.onclick=processButtonClick;
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
	if (!opener) opener=window.dialogArguments;
    if(!opener) opener=parent;
	var formObj=document.form;
	try	{
		var srcName=ComGetEvent("name");
		switch(srcName) 
		{
			case "btn_Close":
				if(formObj.old_remark.value != formObj.remark.value)
				{
					if(!ComShowCodeConfirm("BKG00168")) return;
				}
				ComClosePopup(); 
			break;
			case "btn_Save":
					if(formObj.old_remark.value == formObj.remark.value){
						ComShowCodeMessage("BKG00233");
						return;
					}
					opener.funcSetRemark(formObj.remark.value);
					ComClosePopup(); 
				formObj.old_remark.value=formObj.remark.value;
			break;
		}
	} catch(e) {
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else 					   ComShowMessage(e.message);
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() 
{
	if (!opener) opener=window.dialogArguments;
    if(!opener) opener=parent;
	if (document.form.sheet_name.value == "B") { 
		document.form.remark.value=opener.document.form.blInfo_inter_rmk.value;
	    document.form.old_remark.value=opener.document.form.blInfo_inter_rmk.value;
	} else if (document.form.sheet_name.value == "X") {
		document.form.remark.value=opener.document.form.refInfo_inter_rmk.value;
	    document.form.old_remark.value=opener.document.form.refInfo_inter_rmk.value;		
	} else {
		document.form.remark.value=opener.document.form.refInfo_inter_rmk.value;
	    document.form.old_remark.value=opener.document.form.refInfo_inter_rmk.value;		
	}
	axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
}
function obj_KeyDown() 
{
	fncTextareaMaxLine(window.event.srcElement, 5);
}
function fncTextareaMaxLine(obj, maxLine) 
{
    var str_len=obj.value;
    line=str_len.split("\r\n");
    ln=line.length;
    if(ln == maxLine && event.keyCode == 13) 
    { 	  
	    event.returnValue=false;
    }
}
