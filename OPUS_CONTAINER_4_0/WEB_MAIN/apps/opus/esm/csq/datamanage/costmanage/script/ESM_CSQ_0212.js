﻿/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0212.js
*@FileTitle  : Basic CMCB for IAS Sector_COA UC PFMC Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND13=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0212 : ESM_CSQ_0212 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Downexcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				}
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
	ComSetObjValue(document.form.f_bse_tp_cd, p_bse_tp_cd);
	ComSetObjValue(f_bse_yr, p_bse_yr);
	ComSetObjValue(f_bse_qtr_cd, p_bse_qtr_cd);
	ComSetObjValue(f_sub_trd_cd, p_sub_trd_cd);
	ComSetObjValue(f_dir_cd, p_dir_cd);
	ComSetObjValue(f_rlane_cd, p_rlane_cd);
	f_bse_tp_cd_OnChange();
	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObjects[0].SetColHidden("bse_qtr_cd",1);
	} else {
		sheetObjects[0].SetColHidden("bse_qtr_cd",0);
	}
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|POL|POD|COA CM cost UC|COA CM cost UC|COA CM cost UC|CSQ vs COA|CSQ vs COA|CSQ vs COA";
	        	var HeadTitle2="SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|POL|POD|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"coa_pa_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"coa_ra_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"coa_diff",          KeyField:0,   CalcLogic:"|coa_pa_cm_uc_amt|-|coa_ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             			{Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"diff",              KeyField:0,   CalcLogic:"|pa_cm_uc_amt|-|ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	        	InitColumns(cols);
	        	SetSheetHeight(362);
	        	SetEditable(1);
	        	SetRangeBackColor(1,9,1,14,"#555555");
		}
			break;
		case 2:
			with(sheetObj){
			var HeadTitle="Status|Seq.|Code|Name";
			  SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );

			  var info    = { Sort:1, ColMove:0, ColResize:1, HeaderCheck:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      
			  InitColumns(cols);
			  SetEditable(1);
			  SetVisible(0);
			}
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
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0212GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0212GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.SetColHidden("bse_qtr_cd",1);
			} else {
				sheetObj.SetColHidden("bse_qtr_cd",0);
			}
			ComOpenWait(false);
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet=msNone;
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.MergeSheet=msHeaderOnly;
			ComOpenWait(false);
			break;
    }
}
/**
 *  f_year, f_week, f_duration 바뀌었을때 period 의 week 기간변경
 */
function period_OnChange() {
	var formObj=document.form;
	var year=ComGetObjValue(f_bse_yr);
	var week=ComGetObjValue(formObj.f_week);
	var dur=ComGetObjValue(formObj.f_duration);
	if ( week.length == 1 ) {
		week="0" + week;
		formObj.f_week.value=week;
	}
	if ( year != "" && !ComIsNumber(year) ) {
		ComShowMessage(ComGetMsg('CSQ00008', 'Year', 'YYYY'));
		//formObj.f_year.value="";
		//formObj.f_year.focus();
		return false;
	}
	if ( week != "" && !ComIsNumber(week) || week != "" && !ComIsWeek(week)) {
		ComShowMessage(ComGetMsg('CSQ00008', 'week', 'WW'));
		formObj.f_week.value="";
		formObj.f_week.focus();
		return false;
	}
	if ( dur != "" && !ComIsNumber(dur) ) {
		ComShowMessage(ComGetMsg('CSQ00007', 'Duration'));
		formObj.f_duration.value="";
		formObj.f_duration.focus();
		return false;
	}
	if ( dur != "" && dur * 1 > 5 ) {
		ComShowMessage(ComGetMsg('CSQ00032', '5'));
		formObj.f_duration.value="";
		formObj.f_duration.focus();
		return false;
	}
	var param=year + week + "|" + dur;
	var div_period = document.getElementById("div_period2");
	if ( year != "" && week != "" && dur != "" ) {
		var sXml=sheet2.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=cPeriod&code_param=" + param);
		var arrXml=sXml.split("|$$|");
		var arrData=ComXml2ComboString(arrXml[0], "code", "name");
		var arrWk=arrData[0].split("~");
		formObj.f_fm_wk.value=arrWk[0];
		formObj.f_to_wk.value=arrWk[1];
		div_period.innerHTML="(" + arrData[1] + ")";
	} else {
		div_period.innerHTML="&nbsp;";
	}
}
/**
 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
 */
function setSubTradeCombo(){
 	var formObj=document.form;
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
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
	     + "&all_flag=";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 	}
}
/**
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
 	var formObj=document.form;
 	var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
 	var rlane_cd	 = ComGetObjValue(f_rlane_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if (sub_trd_cd != ""  && sub_trd_cd != "All") {
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
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var index=SearchIndex(f_rlane_cd, rlane_cd);
		f_rlane_cd.SetSelectIndex(index);
 	} else {
		f_rlane_cd.RemoveAll();
 	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:
			var rlane_cd=ComGetObjValue(f_rlane_cd);
			var dir_cd=ComGetObjValue(f_dir_cd);
			var week=ComGetObjValue(formObj.f_week);
			var dur=ComGetObjValue(formObj.f_duration);
			if ( week == "" ) {
				ComShowCodeMessage("CSQ00013", "End Week");
				formObj.f_week.focus();
				return false;
			}
			if ( dur == "" ) {
				ComShowCodeMessage("CSQ00013", "Duration");
				formObj.f_duration.focus();
				return false;
			}
			if ( rlane_cd == "" ) {
				ComShowCodeMessage("CSQ00013", "R/Lane");
				f_rlane_cd.Focus();
				return false;
			}
			if ( dir_cd == "" ) {
				ComShowCodeMessage("CSQ00013", "Lane Bound");
				f_dir_cd.Focus();
				return false;
			}
    		break;
	}
	return true;
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
		f_bse_qtr_cd.SetVisible(0);
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
		f_bse_qtr_cd.SetVisible(1);
	}
	period_change();
	setSubTradeCombo();
}
/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setSubTradeCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
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
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, Newtxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var rlane_cd=ComGetObjValue(f_rlane_cd);
 	if ( rlane_cd != ""  && rlane_cd != "All" ) {
 		var code_name=new Array("polCdSectorMulti", "podCdSectorMulti");
 		var code_param=new Array(NewCd, NewCd);
 		var all_flag=new Array("All", "All");
 		var param="f_cmd="		+ SEARCH02
 		          + "&code_name="	+ code_name
 		          + "&code_param="	+ code_param
 		          + "&all_flag="	+ all_flag
 		          + "&" + FormQueryString(formObj);	
 		var sXml=sheetObj.GetSearchData("CommonGS.do", param);
 		var arrXml=sXml.split("|$$|");
 		if (arrXml.length > 0) {
 			ComXml2ComboItem(arrXml[0], f_pol_cd, "code", "name");
 			f_pol_cd.SetSelectIndex(0);
 		}
 		if (arrXml.length > 1) {
 			ComXml2ComboItem(arrXml[1], f_pod_cd, "code", "name");
 			f_pod_cd.SetSelectIndex(0);
 		}
 	}else{
 		f_pol_cd.RemoveAll();
 		f_pod_cd.RemoveAll();
 	}
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 개발자 작업  끝 */
