/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0211.js
*@FileTitle  : Basic CMCB for IAS Sector_New Lane Cost IF
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND12=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0211 : ESM_CSQ_0211 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Apply":
				doActionIBSheet(sheetObj, formObj, "Apply");
				break;
			case "btn_Close":
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
function loadPage(){
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComSetObjValue(formObj.f_bse_tp_cd[0], p_bse_tp_cd);
	f_bse_tp_cd_OnChange();
	// 화면 조회
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		// sheet1 init
		    with(sheetObj){
	        	var HeadTitle="STS|SEL|Sub Trade|New Lane|cre_flg";
	        	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sel_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	       
	        	InitColumns(cols);
	        	SetSheetHeight(360);
	        	SetEditable(1);
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
		case IBSEARCH:          // 화면 조회
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0211GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case "Apply":          // Apply 버튼 클릭
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
				return false;
			}
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml=sheetObj.GetSaveData("ESM_CSQ_0211GS.do", searchParams + "&" + saveStr);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if ( State == "S" ) {
				ComShowCodeMessage("CSQ00001", "Data");
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			var rtnValue = "S";
            ComPopUpReturnValue(rtnValue);
			break;
    }
}
/**
 * sheet1_OnSearchEnd
 *01. 해당 row가 creation 된 상태일 때 row비활성화
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	for(var i=1;i<sheetObj.RowCount()+1;i++){
		if(sheetObj.GetCellValue(i,"cre_flg") == "Y"){
   			sheetObj.SetRowEditable(i,0);
   		}
	}
}
/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj=document.form;
	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr=document.getElementById("div_qtr");
	var div_period=document.getElementById("div_period");
	if (bse_tp_cd == "Y") {
		div_qtr.style.display="none";
		div_period.style.display="none";
		formObj.f_bse_qtr_cd.style.display="none";
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
		formObj.f_bse_qtr_cd.style.display="inline";
	}
	period_change();
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 개발자 작업  끝 */
