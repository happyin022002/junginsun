/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0013.js
*@FileTitle  :  Basic CMCB (CM Cost Per Box)
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
 * @class ESM_CSQ_0013 : ESM_CSQ_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/
//공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadExcelsectorFlg="";
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
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj,formObj,IBCREATE);
				break; 
			case "btn_Save":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			case "btn_LoadExcel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				break;
			case "btn_NewLaneCostIF":
				doActionIBSheet(sheetObj,formObj,"NewLaneCostIF");
				break;
			case "btn_CoaUcPfmc":
				doActionIBSheet(sheetObj,formObj,"CoaUcPfmc");
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
	toggleButtons("INIT");
	setTradeCombo();
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="STS|SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|";
	        	var HeadTitle2="STS|SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA|";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"gid_pa_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"gid_ra_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"gui_diff",          KeyField:0,   CalcLogic:"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	        	             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"diff",              KeyField:0,   CalcLogic:"|pa_cm_uc_amt|-|ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	        	InitColumns(cols);
	        	SetSheetHeight(400);
	        	SetEditable(1);
	        	SetRangeBackColor(1,10,1,15, "#555555");
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
			}
			break;
		case "f_ofc_vw_cd":
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
		case IBCLEAR:          //조회
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0013GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3){
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
			}
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_rhq_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			setTimeout(function(){
				formObj.f_cmd.value=SEARCH;
				toggleButtons("INIT");
				searchParams=FormQueryString(formObj);
	 			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0013GS.do", searchParams);
				sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				var etcData=getEtcData(rtnXml);
				if (etcData["dataCnt"] == 0) {
					toggleButtons("CREATE");
				} else {
					toggleButtons("SEARCH");
				}
				setEditColor(sheetObj);
				ComOpenWait(false);
			}, 100);
			break;
		case IBCREATE:          // Data 생성
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			setTimeout(function(){
				ComSetSearchParams("f_cmd", MULTI01);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0013GS.do", searchParams);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State == "S") {
					ComShowCodeMessage("CSQ00001", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if (State != "S") {
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false);
					return false;
				}
				ComOpenWait(false);
			}, 100);
			break;
		case IBSAVE:			// 저장
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0013GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			ComOpenWait(false);
			if (State == "S") {
				ComShowCodeMessage("CSQ00001", "Data");
			}
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet=msNone;
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.MergeSheet=msHeaderOnly;
			ComOpenWait(false);
			break;
		case IBLOADEXCEL:		// 엑셀 업로드
			loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
			loadExcelTotFlg=false;		// 화면에 Total Row 존재 여부
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				loadExcelExField="|bse_qtr_cd|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			} else {
				loadExcelExField="|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			}
			loadExcelAplyField="|pa_cm_uc_amt|ra_cm_uc_amt|";	// 반영 필드
			loadExcelsectorFlg="C";
			ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
			break;
		case "NewLaneCostIF":          // 신규노선에 대한 Cost 정보 I/F
			ComSetSearchParams("f_cmd", "");
			ComOpenPopup("ESM_CSQ_0014.do?"+searchParams, 575, 420, "callbackPopup", "0,0", true);
			break;
		case "CoaUcPfmc":          // COA의 PFMC 기반의 단가 조회기능
			ComSetSearchParams("f_cmd", "");
			ComOpenWindow("ESM_CSQ_0015.do?" + searchParams,  window,  "dialogHeight:535px;dialogWidth:1110px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
			break;
    }
}

function callbackPopup(value){
	//팝업에서 받은 리턴값이 S일때 그리드를 다시 조회한다.
    if(value == "S"){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
 *  선택된 Trade 에 해당하는 R.Lane 정보 가져와서 Combo Box 셋팅
 */
function f_trd_cd_OnChange(obj, value, text){
	setLaneCombo();
}
/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 Combo Box 셋팅
 */
function f_rhq_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if (NewTxt != "All") {
 		var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + NewTxt + "&all_flag=All");
		ComXml2ComboItem(sXml, f_rgn_ofc_cd, "code", "name");
		f_rgn_ofc_cd.SetSelectIndex(0);
	} else {
		f_rgn_ofc_cd.RemoveAll();
		f_rgn_ofc_cd.InsertItem(0, "All", "All");
		f_rgn_ofc_cd.SetSelectIndex(0);
	}
}
/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var param="";
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var trd_cd		 = ComGetObjValue(f_trd_cd);

 	param="f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param=" + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd
     + "&all_flag=All";	// Trade
 	var sXml=sheetObj.GetSearchData("CommonGS.do",param);
	ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
	// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
	var index=SearchIndex(f_trd_cd, trd_cd);
	f_trd_cd.SetSelectIndex(index);
}
/**
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var param="";
	var trd_cd		 = ComGetObjValue(f_trd_cd);
	var rlane_cd	 = ComGetObjValue(f_rlane_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	if (trd_cd != "All" && trd_cd != "" ) {
	 	param="f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=All";
 	 	var sXml=sheetObj.GetSearchData("CommonGS.do",param);
		ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var index=SearchIndex(f_rlane_cd, rlane_cd);
		f_rlane_cd.SetSelectIndex(index);
	} else {
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
		f_rlane_cd.SetSelectIndex(0);
	}
}
/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Creation");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_LoadExcel");
			ComBtnDisable("btn_NewLaneCostIF");
			ComBtnDisable("btn_CoaUcPfmc");
			break;
		case "CREATE":
			ComBtnEnable("btn_Creation");
			break;
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_NewLaneCostIF");
			ComBtnEnable("btn_CoaUcPfmc");
			break;
	}
}
/**
 * Sheet 의 Edit 가능한 곳의 색상을 지정한다.
 * Load Excel 과 같이 사용.
 */
function setEditColor(sheetObj) {
//	sheetObj.RangeBackColor(sheetObj.HeaderRows, 13, sheetObj.lastRow, 14) = "#FFFF00";   // Yellow
	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObj.SetColHidden("bse_qtr_cd",1);
	} else {
		sheetObj.SetColHidden("bse_qtr_cd",0);
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
		f_bse_qtr_cd.SetVisible(0);
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
		f_bse_qtr_cd.SetVisible(1);
	}
	period_change();
	setTradeCombo();
}
/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
/* 개발자 작업  끝 */
