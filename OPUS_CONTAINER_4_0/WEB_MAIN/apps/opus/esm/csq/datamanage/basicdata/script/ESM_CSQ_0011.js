/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0011.js
*@FileTitle  : Target VVD Fix_Disable Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0011 : ESM_CSQ_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_apply":
			ComOpenWait(true);
			comPopupOK();
			ComOpenWait(false);
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		} 
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
function loadPage(){
	var formObject=document.form;
	loadingMode=true;
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="|Trade|Lane Bound|Sub Trade|Lane|Select|";
	        	var headCount = ComCountHeadTitle(HeadTitle1);
	        	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0} );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ 
	        	             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ,
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"blank",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	       
	        	InitColumns(cols);
	        	SetEditable(1);
	        	SetSheetHeight(362);
            }
			break;
	}
}
/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:          //조회
			formObj.f_cmd.value=SEARCH;
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0011GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
/* 개발자 작업  끝 */
