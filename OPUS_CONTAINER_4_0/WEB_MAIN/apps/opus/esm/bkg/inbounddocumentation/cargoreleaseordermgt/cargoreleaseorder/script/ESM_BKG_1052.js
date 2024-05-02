/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1052.js
*@FileTitle  : Full CNTR Release Order Remark Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================**/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
	var formObj=document.form;
	try 
	{
		var srcName=ComGetEvent("name");
		switch(srcName) 
		{
			case "btn_Close":
				if(formObj.old_rmk.value != formObj.p_remark.value)
				{
					if(!ComShowCodeConfirm("BKG00168")) return;
				}
			ComClosePopup(); 
			break;
			case "btn_Save":
				//if (!opener) opener=parent; 
				if(opener)
				{
					if(formObj.old_rmk.value == formObj.p_remark.value)
					{
						ComShowCodeMessage("BKG00233");
						return;
					}
					opener.funcSetRemark(formObj.p_row.value, formObj.p_remark.value);
				ComClosePopup(); 
				}
				else
				{
					ComShowCodeMessage("BKG00391");
				}
				formObj.old_rmk.value=formObj.p_remark.value;
			break;
		}
	}
	catch(e) 
	{
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else 					   ComShowMessage(e.message);
	}
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++]=sheet_obj;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() 
{
	for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
    document.form.old_rmk.value=document.form.p_remark.value;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
    }
    return true;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) 
{
	var cnt=0;
	switch(sheetNo) 
	{
		case 1:      //sheet1 init
		    with(sheetObj){
		      //no support[check again]CLT 				if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		      var HeadTitle="|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
		      var prefix="";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mrn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"userid",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"blcount", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetSheetHeight(100);
		      SetVisible(0);
	          }		
		      break;
		}
}
//*************************************************************************************************
function obj_KeyDown() 
{
	var srcName=ComGetEvent("name").substring(10);
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	fncTextareaMaxLine(window.event.srcElement, 5);
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
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
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
