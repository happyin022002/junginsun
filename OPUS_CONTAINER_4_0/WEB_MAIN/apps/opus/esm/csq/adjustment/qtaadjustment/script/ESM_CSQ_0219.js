﻿/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0219.js
*@FileTitle  : QTA Adjustment by VVD for IAS Sector
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/09
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0219 : ESM_CSQ_0219 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_DownExcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				}
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
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
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle="Trade|Sub Trade|R.Lane|Lane Bound|Ver|IOC|Flg|STS|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Update Option|Update Option";
	        	var HeadTitle2="Trade|Sub Trade|R.Lane|Lane Bound|Ver|IOC|Flg|STS|Month|Week|VVD|Supply|Load|G.REV|Month|Week|VVD|Supply|COPY VVD|QTA=0";
	        	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"qta_rlse_ver_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fnl_bsa_capa",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"grs_rev",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coa_bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coa_bse_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"coa_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coa_fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"copy_vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"f_click",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	        	InitColumns(cols);
	        	SetSheetHeight(360);
	        	SetEditable(1);
	        	SetRangeBackColor(1,5,1,20,"#555555");
            }
			break;
	}
}
/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.options.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(1);
			}
			break;
		default:
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
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
		case IBCLEAR:          // 화면 접속 시
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0219GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
			formObj.f_crnt_bse_yr.value = f_bse_yr.GetSelectCode();
			formObj.f_crnt_qta_cd.value = f_bse_qtr_cd.GetSelectCode();
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			formObj.f_fm_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value=qtaWeekArr[ComGetObjValue(f_bse_qtr_cd)][1].substring(3,5);
			searchParams=FormQueryString(formObj);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0219GS2.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case IBCREATE:          // 생성
			if (!validateForm(sheetObj, formObj, sAction)) return;
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006"); //"There is no data to save.";
				return false;
			}
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) { //"Do you want to create data?"
				return false;
		    }
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			if ( saveStr == "" ) {
				return;
			}
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml=sheetObj.GetSaveData("ESM_CSQ_0219GS.do", searchParams + "&" + saveStr);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if ( State == "S" ) {
				ComShowCodeMessage("CSQ00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
    }
}
/**
 * f_bse_yr가 바뀌었을때 Lane 재조회
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setSubTradeCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 Lane 재조회
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setSubTradeCombo();
}
/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }
/**
 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
 */
function setSubTradeCombo(){
 	var formObj=document.form;
	var f_bse_tp_cd  = "Q";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if ( trd_cd != ""  && trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=subTradeSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=All";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 	}
}

/**
 *  f_sub_trd_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj=document.form;
 	var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
	var f_bse_tp_cd  = "Q";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if ( sub_trd_cd != ""  && sub_trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLaneSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd+"|"
	     			    +sub_trd_cd
	     + "&all_flag=";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
	 	f_rlane_cd.SetMultiSelect(1);
 	} else {
		f_rlane_cd.RemoveAll();
 	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	var formObj=document.form;
	switch(sAction) {
		case IBCREATE:  // 화면 저장시에
			var iRows=sheetObj.FindStatusRow("I");
			var iRowArr=iRows.split(";");
			for ( var i=0; i < iRowArr.length; i++ ) {
				if (sheetObj.GetCellValue(iRowArr[i], "copy_vvd") == ""){
					ComShowCodeMessage('CSQ00024','Copy VVD');//Please Input VVD.
					return false;
				}
			}
    		break;
	}
	return true;
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 개발자 작업  끝 */
