/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_CSQ_0006.js
*@FileTitle      : Lane-Office Relation Setting
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**

/* 개발자 작업	*/
//공통전역변수
var formObj = document.form;
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
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_Create":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
				break;
			case "btn_DownExcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
		        } else{
		        	doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
		        }
				break;
			case "btn_NewLaneAdd":
				doActionIBSheet(sheetObj, formObj, "NewLaneAdd");
				break;
            case "btn_close":
            	window.close();
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
	//팝업으로 열렸을때 부모창 조건 세팅
    if(formObj.popMode.value == "Y"){
    	ComSetObjValue(f_bse_yr, formObj.p_bse_yr.value);
    	ComSetObjValue(f_bse_qtr_cd, formObj.p_bse_qtr_cd.value);
    	ComSetObjValue(f_ofc_vw_cd, formObj.p_ofc_vw_cd.value);
		ComSetObjValue(f_sub_trd_cd, formObj.p_sub_trd_cd.value);
		ComSetObjValue(f_dir_cd, formObj.p_dir_cd.value);
		ComSetObjValue(f_rlane_cd, formObj.p_rlane_cd.value);
	}
	loadingMode=false;
	resizeSheet();
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		// sheet1 init
			 with(sheetObj){
	        	var HeadTitle="STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|Office|Active|Add Flg";

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
			      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:'Y', FalseValue:'N'  },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"add_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(400);
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
		case IBCLEAR:          // 화면 접속 시
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0006GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3){
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
				ComCsqSetIBCombo(sheetObj, arrXml[3], "ofc_vw_cd");
			}
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_rhq_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 화면 조회 시
			formObj.f_cmd.value=SEARCH;
			toggleButtons("INIT");
			searchParams=FormQueryString(formObj);
			sheetObj.SetWaitImageVisible(1);
			sheetObj.DoSearch("ESM_CSQ_0006GS.do", searchParams, {Sync:1});
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
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0006GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			ComOpenWait(false);
			if (State == "S") {
				ComShowCodeMessage("CSQ00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
		case IBCREATE:          // Data 생성
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			setTimeout(function(){
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0006GS.do", searchParams);
				ComOpenWait(false);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State == "S") {
					ComShowCodeMessage("CSQ00001", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if (State != "S") {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
			});
			break;
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
			ComOpenWait(false);
			break;
		case "NewLaneAdd":
			ComSetSearchParams("f_cmd", "");
			var text=f_ofc_vw_cd.GetSelectText();//ComGetObjText(f_ofc_vw_cd);
			var rtn =  ComOpenWindow("ESM_CSQ_0007.do?" + searchParams + "&f_text=" + text,  window,  "dialogHeight:525px;dialogWidth:950px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
			break;
    }
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	sheetObj.SetWaitImageVisible(0);
	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObj.SetColHidden("bse_qtr_cd",1);
	} else {
		sheetObj.SetColHidden("bse_qtr_cd",0);
	}
	
//	var etcData = getEtcData(rtnXml);
	if (sheetObj.GetEtcData("dataCnt") == 0) {
		toggleButtons("CREATE");
	} else {
		toggleButtons("SEARCH");
	}
	
}

/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	var formObj=document.form;
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_NewLaneAdd");
			break;
		case "CREATE":
			ComBtnEnable("btn_Create");
			ComBtnEnable("btn_NewLaneAdd");
			break;
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_NewLaneAdd");
			break;
	}
}
/**
 *  선택된 Trade 에 해당하는 Sub Trade, R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var trd_cd		 = ComGetObjValue(f_trd_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var sector_include = "Y"; //sub trade 조회시 sector도 포함
 	var param="f_cmd=" + SEARCH01 
     		+ "&code_name=subTrade"
     		+ "&code_param="+trd_cd+"|"
							+f_bse_tp_cd+"|"
							+f_bse_yr+"|"
							+f_bse_qtr_cd+"|"
							+sector_include
			+ "&all_flag=All";
 	var sXml=sheetObj.GetSearchData("CommonGS.do", param);
 	ComXml2ComboItem(sXml, f_sub_trd_cd, "code", "name");
	f_sub_trd_cd.SetSelectIndex(0);
}
/**
 *  선택된 Sub Trade 에 해당하는 R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_sub_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var trd_cd		 = ComGetObjValue(f_trd_cd);
	var sub_trd_cd 	 = ComGetObjValue(f_sub_trd_cd);
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var sector_include = "Y"; //rlane 조회시 sector도 포함
	if( trd_cd != "All" || sub_trd_cd != "All"){
		var param="f_cmd=" + SEARCH01
	     		+ "&code_name=rLane"
	     		+ "&code_param="+trd_cd+ "|"
	     						+f_bse_tp_cd+"|"
	     						+f_bse_yr+"|"
	     						+f_bse_qtr_cd+"|"
	     						+sub_trd_cd+"|"
	     						+sector_include
	     		+ "&all_flag=All";
		var sXml=sheetObj.GetSearchData("CommonGS.do", param);
		ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
		f_rlane_cd.SetSelectIndex(0);
	}else{
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
		f_rlane_cd.SetSelectIndex(0);
	}
}
/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
 */
function f_rhq_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if (NewCd != "All") {
		var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + NewCd + "&all_flag=All");
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], f_rgn_ofc_cd, "code", "name");
			f_rgn_ofc_cd.SetSelectIndex(0);
		}
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
	var sector_include = "Y"; //trade 조회시 sector도 포함
    param="f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param="  + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd + "|" +sector_include
     + "&all_flag=All";    // Trade
    var sXml=sheetObj.GetSearchData("CommonGS.do",param);
    if (sXml != "") {
        ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
        f_trd_cd.SetSelectIndex(0);
    } else {
        f_trd_cd.RemoveAll();
        f_trd_cd.InsertItem(0, "All", "All");
        f_trd_cd.SetSelectIndex(0);
    }
}
/**
 *  Pop-up 창에서 선택한 New Lane Data 를 시트에 추가
 */
function newLaneAdd(rtnArr) {
	var sheetObj=sheetObjects[0];
	var row=sheetObj.DataInsert(-1);
	sheetObj.SetCellValue(row, "bse_yr",ComGetSearchParams("f_bse_yr"),0);
	sheetObj.SetCellValue(row, "bse_qtr_cd",ComGetSearchParams("f_bse_qtr_cd"),0);
	sheetObj.SetCellValue(row, "ofc_vw_cd",ComGetSearchParams("f_ofc_vw_cd"),0);
	sheetObj.SetCellValue(row, "trd_cd",rtnArr[0],0);
	sheetObj.SetCellValue(row, "sub_trd_cd",rtnArr[1],0);
	sheetObj.SetCellValue(row, "dir_cd",rtnArr[2],0);
	sheetObj.SetCellValue(row, "rlane_cd",rtnArr[3],0);
	sheetObj.SetCellValue(row, "rhq_cd",rtnArr[4],0);
	sheetObj.SetCellValue(row, "rgn_ofc_cd",rtnArr[5],0);
	sheetObj.SetCellValue(row, "csq_act_flg",rtnArr[6],0);
	sheetObj.SetCellValue(row, "add_flg",rtnArr[7],0);
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
