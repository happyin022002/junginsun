/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0210.js
*@FileTitle  : Basic CMCB (CM Cost Per Box)
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_CSQ_0210 : ESM_CSQ_0210 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				}
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
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane Bound|POL|POD|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|";
	        	var HeadTitle2="STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane Bound|POL|POD|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA|";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"gid_pa_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"gid_ra_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"gui_diff",          KeyField:0,   CalcLogic:"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	        	             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"diff",              KeyField:0,   CalcLogic:"|pa_cm_uc_amt|-|ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	       
	        	InitColumns(cols);
	        	SetSheetHeight(400);
	        	SetEditable(1);
	        	SetRangeBackColor(1,10,1,15,"#555555");
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
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0210GS.do", FormQueryString(formObj));
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
		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			toggleButtons("INIT");
			searchParams=FormQueryString(formObj);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0210GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			var etcData=getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("CREATE");
			} else {
				toggleButtons("SEARCH");
			}
			ComOpenWait(false);
			sheetObj.SetSumText(0, "ibflag","");
			sheetObj.SetSumText(0, "bse_yr","TOTAL");
			ComOpenWait(false);
			break;
		case IBCREATE:          // Data 생성
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0210GS.do", searchParams);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//초 - 1시간
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
				}
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
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0210GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			ComOpenWait(false);
			if (State == "S") {
				ComShowCodeMessage("CSQ00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
		case IBLOADEXCEL:		// 엑셀 업로드
			loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
			loadExcelTotFlg=true;		// 화면에 Total Row 존재 여부
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				loadExcelExField="|bse_qtr_cd|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			} else {
				loadExcelExField="|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			}
			loadExcelAplyField="|pa_cm_uc_amt|ra_cm_uc_amt|";				// 반영 필드
			loadExcelsectorFlg="C"; //sector flag에 따라 메세지 달라짐
        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
			break;
		case "NewLaneCostIF":          // 신규노선에 대한 Cost 정보 I/F
			ComSetSearchParams("f_cmd", "");
			ComOpenPopup("ESM_CSQ_0211.do?"+searchParams, 650, 550, "callbackPopup", "0,0", true);
			break;
		case "CoaUcPfmc":          // COA의 PFMC 기반의 단가 조회기능
			searchParams=FormQueryString(formObj);
			ComSetSearchParams("f_cmd", "");
			ComOpenWindow("ESM_CSQ_0212.do?" + searchParams,  window,  "dialogHeight:535px;dialogWidth:1110px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
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
	     + "&all_flag=All";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 		f_sub_trd_cd.InsertItem(0, "All", "All");
 		f_sub_trd_cd.SetSelectIndex(0);
 	}
}
/**
 *  f_sub_trd_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj=document.form;
 	var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
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
	 	f_rlane_cd.SetMultiSelect(1);
 	} else {
		f_rlane_cd.RemoveAll();
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
function sheet1_OnSearchEnd(sheetObj) {
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
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var rlane_cd=ComGetObjValue(f_rlane_cd);
 	if ( rlane_cd != ""  && rlane_cd != "All" ) {
 		var code_name=new Array("polCdSectorMulti", "podCdSectorMulti");
 		var code_param=new Array(rlane_cd, rlane_cd);
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
/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
*/     
function getBackEndJobStatus() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
		var sXml=sheetObj.GetSearchData("ESM_CSQ_0210GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		var errMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
		if (jobState == "3") {
			ComShowCodeMessage("CSQ00010", "Data");
			clearInterval(backEndJobTimer);
			ComOpenWait(false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else if (jobState == "4") {
			ComShowCodeMessage("CSQ00038", errMsg);
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
		} else if (jobState == "5") {
			ComShowCodeMessage("CSQ00039");
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
		}
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 개발자 작업  끝 */
