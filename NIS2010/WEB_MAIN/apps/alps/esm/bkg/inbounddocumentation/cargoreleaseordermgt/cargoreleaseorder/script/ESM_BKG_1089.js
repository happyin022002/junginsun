/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1089.js
*@FileTitle : Hold/Internal Remark Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2010.03.03 안진응
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
	var formObj = document.form;
	   
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) 
		{
			case "btn_Close":
				if(formObj.old_remark.value != formObj.remark.value)
				{
					if(!ComShowCodeConfirm("BKG00168")) return;
				}
				window.close();
			break;
			case "btn_Save":
//				if(opener) {
					if(formObj.old_remark.value == formObj.remark.value){
						ComShowCodeMessage("BKG00233");
						return;
					}
					dialogArguments.funcSetRemark(formObj.remark.value);
					
					self.close();
//				} else {
//					ComShowCodeMessage("BKG00391");
//				}
				formObj.old_remark.value = formObj.remark.value;
			break;
		}
	} catch(e) {
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else 					   ComShowMessage(e);
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() 
{
	if (document.form.sheet_name.value == "B") { 
		document.form.remark.value = dialogArguments.form.blInfo_inter_rmk.value;
	    document.form.old_remark.value = dialogArguments.form.blInfo_inter_rmk.value;
	} else if (document.form.sheet_name.value == "X") {
		document.form.remark.value = dialogArguments.form.refInfo_inter_rmk.value;
	    document.form.old_remark.value = dialogArguments.form.refInfo_inter_rmk.value;		
	} else {
		document.form.remark.value = dialogArguments.form.refinfo_inter_rmk.value;
	    document.form.old_remark.value = dialogArguments.form.refinfo_inter_rmk.value;		
	}
	axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
}


function obj_KeyDown() 
{
//	var srcName = window.event.srcElement.getAttribute("name").substring(10);
//	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
//	var srcValue = window.event.srcElement.getAttribute("value");
	fncTextareaMaxLine(window.event.srcElement, 5);
}


function fncTextareaMaxLine(obj, maxLine) 
{
    var str_len = obj.value;
    line = str_len.split("\r\n");
    ln = line.length;

    if(ln == maxLine && event.keyCode == 13) 
    { 	  
	    event.returnValue = false;
    }
}