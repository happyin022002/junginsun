/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1021.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.13 손윤석
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
	var formObj = document.form;
	   
	try 
	{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) 
		{
			case "btn_Close":
				if(formObj.old_rmk.value != formObj.p_remark.value)
				{
					if(!ComShowCodeConfirm("BKG00168")) return;
				}
				window.close();
			break;
			case "btn_Save":
				if(opener)
				{
					if(formObj.old_rmk.value == formObj.p_remark.value)
					{
						ComShowCodeMessage("BKG00233");
						return;
					}
					opener.funcSetRemark(formObj.p_row.value, formObj.p_remark.value);
					
					window.close();
				}
				else
				{
					ComShowCodeMessage("BKG00391");
				}
				formObj.old_rmk.value = formObj.p_remark.value;
			break;
		}
	}
	catch(e) 
	{
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else 					   ComShowMessage(e);
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
   sheetObjects[sheetCnt++] = sheet_obj;
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
    document.form.old_rmk.value = document.form.p_remark.value;
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
    	//if (!isNumber(formObj.iPage)) 
    	//{
    	//	return false;
    	//}
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
	var cnt = 0;
	switch(sheetNo) 
	{
		case 1:      //sheet1 init
			with (sheetObj) 
			{
				//높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				var HeadTitle = "|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false, prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,   40,   	daCenter,  	true,  prefix + "Seq");
				InitDataProperty(0, cnt++ , dtData,  170,  	daCenter,	false, prefix + "mrn",      false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  110,  	daCenter,	false, prefix + "vvd",      false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  100,  	daCenter,  	false, prefix + "pol",      false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  80,   	daCenter,  	false, prefix + "pod",      false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  75,   	daCenter,	false, prefix + "office",   false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  75,   	daCenter,  	false, prefix + "userid",   false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  90,   	daRight,  	false, prefix + "blcount",  false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  60,   	daCenter,	false, prefix + "ac",       false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,  90,   	daCenter,  	false, prefix + "dt",   	false, "",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++ , dtData,  80,   	daCenter,  	false, prefix + "dt2",      false, "",	dfNone,	0, true, true);
				CountPosition = 0;
			}
		break;
	}
}
//*************************************************************************************************
function obj_KeyDown() 
{
	var srcName = window.event.srcElement.getAttribute("name").substring(10);
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	fncTextareaMaxLine(window.event.srcElement, 5);
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
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
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************