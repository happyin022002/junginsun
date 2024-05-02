/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0053.js
*@FileTitle  : Portion Adjustment by RHQ
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
 * @class ESM_CSQ_0053 : ESM_CSQ_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업	*/

//공통전역변수˜
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var max=0;
var params="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_Downexcel":
				if(sheetObject.RowCount() < 1) {
					 ComShowCodeMessage("COM132501");
				} else{
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
				}
				break;
			case "btn_RowGrpAdd":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObj, "OfcRowAdd");
				break;	
			case "btn_FigureInquiry":
				doActionIBSheet(sheetObject, formObj, "FigureInquiry");
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
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
			var HeadTitle1="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|RHQ|Office|Load (TEU)\nPortion Setting|G.REV\nPortion Setting||From|From||To|To|grp_no|";
			var HeadTitle2="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|RHQ|Office|Load (TEU)\nPortion Setting|G.REV\nPortion Setting||Week|VVD||Week|VVD|grp_no|";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"lod_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 },
	             {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rev_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 },
	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_yrwk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aply_fm_yrwk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_vvd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, AcceptKeys:"E|N" , InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_to_yrwk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aply_to_yrwk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_vvd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, AcceptKeys:"E|N" , InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"grp_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	      InitColumns(cols);
	      SetEditable(1);
	      SetRangeBackColor(1, 9, 1, 30 , "#555555");
	      SetSheetHeight(350);
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
 * f_bse_yr가 바뀌었을때 period 의 year 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
	setLaneCombo();
}
/**
 * f_ofc_vw_cd 바뀌었을때 trade콤보조회
*/
function f_ofc_vw_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
	setLaneCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
	setLaneCombo();
}
/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_ob_div_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
	setLaneCombo();
}
/**
* f_bse_tp_cd,f_bse_qtr_cd,f_bse_yr가 바뀌었을때 trade콤보 settting
*/
function setTradeCombo() {
	 	var formObj=document.form;
	 	var trd_cd=ComGetObjValue(f_trd_cd);
	 	if(f_bse_yr.GetSelectCode()!="" && f_bse_qtr_cd.GetSelectCode()!="" && f_ofc_vw_cd.GetSelectCode()!=""){
		 	var param="f_cmd=" + SEARCH02
		     + "&code_name=tradeControl"
		     + "&code_param=" 
		     + "&all_flag=All"
		     + "&" + FormQueryString(formObj);	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_trd_cd, "code", "name");
	 	var index=SearchIndex(f_trd_cd, trd_cd);
	 	f_trd_cd.SetSelectIndex(index);
	 	}
}
/**
* onChange event
* f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
}
/**
 *  f_bse_yr, f_bse_qtr_cd, f_ofc_vw_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	 	var formObj=document.form;
	 	var trd_cd=comboObjects[4].GetSelectCode();	// trade code
	 	var rlane_cd=f_rlane_cd.GetSelectCode();	// rlane code
		if (trd_cd != "All") {	
		 	var param="f_cmd=" + SEARCH02
		     + "&code_name=rLaneControl"
		     + "&code_param="
		     + "&all_flag="
		     + "&" + FormQueryString(formObj);	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
			var index=SearchIndex(f_rlane_cd, rlane_cd);
			if(index != "0"){ 
				var arrIndex=index.split("|");
				for(var i=0; i<arrIndex.length; i++) {
					f_rlane_cd.SetItemCheck(arrIndex[i],1);
				}
			}
		} else {
			f_rlane_cd.RemoveAll();
		}
		f_rlane_cd.SetMultiSelect(1);
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
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0053GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_conv_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_ob_div_cd, "code", "name");
			ComOpenWait(false);
			setTradeCombo();
			ComOpenWait(false);
			break;
		case IBSEARCH: // 화면 조회 시
			formObj.f_cmd.value=SEARCH;
			searchParams=FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0053GS.do",searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			max = 0;

			if (sheetObj.RowCount() > 0) {
				ComBtnEnable("btn_FigureInquiry");
			} else {
				ComBtnDisable("btn_FigureInquiry");
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
		case IBSAVE:          //화면 저장시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			//ratio가 100%인지 check
			if (!checkRatioForRHQAdj(sheetObj)) return;
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
		        return false;
		    }
			if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0053GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('CSQ00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
		case MULTI01:		// Creation시에
			if (sheetObj.IsDataModified()== true) {
				ComShowCodeMessage("CSQ00017");
		        return false;
		    }
			if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml=sheetObj.GetSaveData("ESM_CSQ_0053GS.do", searchParams);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State == "S") {
				ComShowCodeMessage("CSQ00010", "Data");
			} else if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
		case MULTI02:		// RHQ Group Row Add 클릭시 
			ComSetSearchParams("f_cmd", MULTI02);
			ComOpenWait(true);
			// 추가된 Row의 시작 위치를 확인한다.
			var rowCnt = sheetObj.RowCount()+sheetObj.HeaderRows();
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0053GS.do",searchParams);
			sheetObj.LoadSearchData(rtnXml,{Append:1 , Sync:1} );
			ComOpenWait(false);
			// Add한 Group No를 조정한다
			for(var i=rowCnt; i<sheetObj.RowCount()+sheetObj.HeaderRows(); i++){
				sheetObj.SetRowStatus(i,"I");
				sheetObj.SetCellValue(i,"grp_no",Number(sheetObj.GetCellValue(i,"grp_no")) + Number(max));
			}
			break;
		case "FigureInquiry":
			// sheet에 변경사항이 있는지 확인
			if (sheetObj.IsDataModified()== true) {
				ComShowCodeMessage("CSQ00017");
		        return false;
		    }			
			ComSetSearchParams("f_cmd", "");
			 ComOpenWindow("ESM_CSQ_0054.do?" + searchParams + "&div_period=" + document.getElementById("div_period").innerHTML,  window,  "dialogHeight:560px;dialogWidth:1050px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;" , true);
			break;
		case "OfcRowAdd":  // Office Row Add 클릭시
			//선택한 Row 복사
			var selRow=sheetObj.GetSelectRow();
			var row=sheetObj.DataInsert();
			sheetObj.SetCellValue(row, "bse_yr",sheetObj.GetCellValue(selRow, "bse_yr"),0);
			sheetObj.SetCellValue(row, "bse_qtr_cd",sheetObj.GetCellValue(selRow, "bse_qtr_cd"),0);
			sheetObj.SetCellValue(row, "ob_div_cd",sheetObj.GetCellValue(selRow, "ob_div_cd"),0);
			sheetObj.SetCellValue(row, "ofc_vw_cd",sheetObj.GetCellValue(selRow, "ofc_vw_cd"),0);
			sheetObj.SetCellValue(row, "trd_cd",sheetObj.GetCellValue(selRow, "trd_cd"),0);
			sheetObj.SetCellValue(row, "sub_trd_cd",sheetObj.GetCellValue(selRow, "sub_trd_cd"),0);
			sheetObj.SetCellValue(row, "rlane_cd",sheetObj.GetCellValue(selRow, "rlane_cd"),0);
			sheetObj.SetCellValue(row, "dir_cd",sheetObj.GetCellValue(selRow, "dir_cd"),0);
			sheetObj.SetCellValue(row, "conv_dir_cd",sheetObj.GetCellValue(selRow, "conv_dir_cd"),0);
			sheetObj.SetCellValue(row, "rhq_cd",sheetObj.GetCellValue(selRow, "rhq_cd"),0);
			sheetObj.SetCellValue(row, "org_fm_yrwk",sheetObj.GetCellValue(selRow, "org_fm_yrwk"),0);
			sheetObj.SetCellValue(row, "aply_fm_yrwk",sheetObj.GetCellValue(selRow, "aply_fm_yrwk"),0);
			sheetObj.SetCellValue(row, "fm_vvd_cd",sheetObj.GetCellValue(selRow, "fm_vvd_cd"),0);
			sheetObj.SetCellValue(row, "org_to_yrwk",sheetObj.GetCellValue(selRow, "org_to_yrwk"),0);
			sheetObj.SetCellValue(row, "aply_to_yrwk",sheetObj.GetCellValue(selRow, "aply_to_yrwk"),0);
			sheetObj.SetCellValue(row, "to_vvd_cd",sheetObj.GetCellValue(selRow, "to_vvd_cd"),0);
			sheetObj.SetCellValue(row, "grp_no",sheetObj.GetCellValue(selRow, "grp_no"),0);
			
			sheetObj.SetCellEditable(row, "rgn_ofc_cd",1);
			sheetObj.InitCellProperty(row, "rgn_ofc_cd",{ Type:"Combo"} );
			sheetObj.RenderSheet(1);
			
			var selRow1			=sheetObj.GetSelectRow();
			var f_bse_yr_val	=sheetObj.GetCellValue(selRow1, "bse_yr");
			var f_bse_qtr_cd_val=sheetObj.GetCellValue(selRow1, "bse_qtr_cd");
			var f_ofc_vw_cd_val	=sheetObj.GetCellValue(selRow1, "ofc_vw_cd");
			var f_trd_cd_val	=sheetObj.GetCellValue(selRow1, "trd_cd");
			var f_rlane_cd_val	=sheetObj.GetCellValue(selRow1, "rlane_cd");
			var f_dir_cd_val	=sheetObj.GetCellValue(selRow1, "dir_cd");
			var f_rhq_cd_val	=sheetObj.GetCellValue(selRow1, "rhq_cd");
			var param="&f_bse_yr="     +f_bse_yr_val  
	                 +"&f_bse_qtr_cd=" +f_bse_qtr_cd_val
		             +"&f_ofc_vw_cd="  +f_ofc_vw_cd_val
		             +"&f_trd_cd="     +f_trd_cd_val
		             +"&f_rlane_cd="   +f_rlane_cd_val
		             +"&f_dir_cd="     +f_dir_cd_val
		             +"&f_rhq_cd="     +f_rhq_cd_val
		            ;
			var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH02 + "&code_name=ofcByPortion&code_param=" + param + "&all_flag=");
			ComCsqSetIBCombo(sheetObj, sXml, "rgn_ofc_cd", true, 0, row);
			break;		
    }
}

 /**
 * Sheet1 값 변경시
 *  
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj=document.form;
	var sName=sheetObj.ColSaveName(col);
	switch(sName){
		case "fm_vvd_cd":
		case "to_vvd_cd":
			if(value.length == 9){
				//다른 그룹(trade-rlane-bound-From Week-To Week) 끼리 같은 VVD 정보를 가질수 없음
				for(var j=sheetObj.HeaderRows();j<sheetObj.RowCount()+sheetObj.HeaderRows();j++){
					if(value == sheetObj.GetCellValue(j,col) && sheetObj.GetCellValue(row,"grp_no") != sheetObj.GetCellValue(j,"grp_no")){
	 					ComShowCodeMessage('CSQ00023','VVD');//VVD has been already inputted.
						sheetObj.SetCellValue(row,col,"");
						sheetObj.SetCellValue(row,col-1,"");
						return false;
					}
				}
				// VVD의 주차를 조회한다(COA_MON_VVD로 부터 Why? 신규노선의 경의 CSQ_CFM_TGT_VVD에 없기 때문)
				ComOpenWait(true);
				params=searchParams;
				ComSetParams("f_trd_cd", sheetObj.GetCellValue(row,"trd_cd"));
				ComSetParams("f_rlane_cd", sheetObj.GetCellValue(row,"rlane_cd"));
				params=params + "&f_dir_cd="+ sheetObj.GetCellValue(row,"dir_cd");
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0051GS.do","f_cmd="+SEARCH01+"&vvd="+value+"&"+params);
				ComOpenWait(false);
				var etcData=getEtcData(rtnXml);
				
				//VVD입력시  target vvd의 주차정보 입력
				if(etcData["aply_wk"] != 0){
					sheetObj.SetCellValue(row,col-1,etcData["aply_wk"]);
				}else {
					var msg=sheetObj.GetCellValue(row,"trd_cd") + "-"
					+ sheetObj.GetCellValue(row,"rlane_cd")+ "-"
					+ sheetObj.GetCellValue(row,"dir_cd");
					ComShowCodeMessage('CSQ00044',msg); //VVD code doesn't exist in {?msg1}
					sheetObj.SetCellValue(row,col,"");
					sheetObj.SetCellValue(row,col-1,"");
					return false;
				}
				
				if(sheetObj.RowCount()>1){
					// 다른 Group과 From-To Week가 겹치는 것이 있는지 확인
					for(var j=sheetObj.HeaderRows();j<sheetObj.RowCount()+sheetObj.HeaderRows();j++){
						if( sheetObj.GetCellValue(row,"rlane_cd") == sheetObj.GetCellValue(j,"rlane_cd")
						 && sheetObj.GetCellValue(row,"dir_cd")   == sheetObj.GetCellValue(j,"dir_cd")
						 && sheetObj.GetCellValue(row,"grp_no")   != sheetObj.GetCellValue(j,"grp_no")){
							//From, To중  VVD 입력시에 입력 VVD가 이미 입력된 기간에 포함된 VVD인지 체크
							if( etcData["aply_wk"]>=sheetObj.GetCellValue(j,"aply_fm_yrwk")
						     && etcData["aply_wk"]<=sheetObj.GetCellValue(j,"aply_to_yrwk")){
								ComShowCodeMessage('CSQ00043');//"This Week is already included."
								sheetObj.SetCellValue(row,col,"");
								sheetObj.SetCellValue(row,col-1,"");
								return false;
							}
							
							//From, To VVD가 둘다 입력되었을때는 전체 기간을 포함하는 지도 체크
							if(sheetObj.GetCellValue(row,"fm_vvd_cd") != "" && sheetObj.GetCellValue(row,"to_vvd_cd") != "" ){
								if(	 sheetObj.GetCellValue(row,"aply_fm_yrwk")<=sheetObj.GetCellValue(j,"aply_fm_yrwk")
								 &&	 sheetObj.GetCellValue(row,"aply_to_yrwk")>=sheetObj.GetCellValue(j,"aply_to_yrwk")){
									ComShowCodeMessage('CSQ00043');//"This Week is already included."
									sheetObj.SetCellValue(row,col,"");
									sheetObj.SetCellValue(row,col-1,"");
									return false;
								}
							}
						}
					}
					// 동일 Group에 VVD와 주차 정보를 입력한다.
					for(var k=sheetObj.HeaderRows();k<sheetObj.RowCount()+sheetObj.HeaderRows();k++){
						if( sheetObj.GetCellValue(row,"rlane_cd") == sheetObj.GetCellValue(k,"rlane_cd")
							&& sheetObj.GetCellValue(row,"dir_cd") == sheetObj.GetCellValue(k,"dir_cd")
							&& sheetObj.GetCellValue(row,"grp_no") == sheetObj.GetCellValue(k,"grp_no")
						   ){
							sheetObj.SetCellValue(k,col,value,0);
							sheetObj.SetCellValue(k,col-1,etcData["aply_wk"],0);
						}
					}
				}
				//해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 확인
				if(sheetObj.GetCellValue(row,"fm_vvd_cd") != "" && sheetObj.GetCellValue(row,"to_vvd_cd") != "" ){
					var aply_fm_yrwk=sheetObj.GetCellValue(row,"aply_fm_yrwk");
					var aply_to_yrwk=sheetObj.GetCellValue(row,"aply_to_yrwk");
					var rtnXml1=sheetObj.GetSearchData("ESM_CSQ_0051GS.do","f_cmd="+SEARCH02+"&f_fm_wk="+aply_fm_yrwk+"&f_to_wk="+aply_to_yrwk+"&"+params);
					var vvdList=ComGetEtcData(rtnXml1, "vvdList");
					if(vvdList != "" && vvdList != null){
						vvdList=vvdList.substr(1);
						vvdList=vvdList.split("&");
						var vvd="";
						var mList=""; //csq_cng_tp_cd=M 인 VVD List
						var aList=""; //csq_cng_tp_cd=A 인 VVD List 
						for(i=0;i<vvdList.length;i++){
							vvd=vvdList[i].split("|");
							if(vvd[0] == "M"){
								mList += ","+vvd[1];
							}else if(vvd[0] == "A"){
								aList += ","+vvd[1];
							}
						}
						if(mList != "") mList=mList.substr(1);
						if(aList != "") aList=aList.substr(1);
						ComShowCodeMessage('CSQ00050',aList,mList);
					}	
				}
			}else if(value == ""){ // VVD를 삭제했을 경우 동일 Group의 모든 VVD를 제거한다.
				if(sheetObj.RowCount()>1){
					//VVD를 삭제했을 경우 동일 Group의 모든 VVD를 삭제
					for(var k=sheetObj.HeaderRows();k<sheetObj.RowCount()+sheetObj.HeaderRows();k++){
						if( sheetObj.GetCellValue(row,"rlane_cd") == sheetObj.GetCellValue(k,"rlane_cd")
						 && sheetObj.GetCellValue(row,"dir_cd") == sheetObj.GetCellValue(k,"dir_cd")
						 && sheetObj.GetCellValue(row,"grp_no") == sheetObj.GetCellValue(k,"grp_no")
						   ){
							sheetObj.SetCellValue(k,col,"",0);
							sheetObj.SetCellValue(k,col-1,"",0);
						}
					}
				}
			}
			break;
	}
}
   /**
    *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    * @param sheetObj
    * @param ErrMsg
    */
  function sheet1_OnSearchEnd(sheetObj, ErrMsg){	
  	var formObj=document.form;
  	var rlaneCd=f_rlane_cd.GetSelectCode();
	if (rlaneCd != "") {	
		toggleButtons("SEARCH1");
	}else{
		toggleButtons("SEARCH2");
	}
	sheetObj.SetSumText(0, "ibflag","");
	sheetObj.SetSumText(0, "bse_yr","TOTAL");
	//grp_no의 맥스값 찾기
	max=sheetObj.GetCellValue(sheetObj.HeaderRows(),"grp_no");
	for(var i=sheetObj.HeaderRows();i<sheetObj.RowCount()+sheetObj.HeaderRows();i++){
		if(max <= Number(sheetObj.GetCellValue(i,"grp_no"))){
			max = sheetObj.GetCellValue(i,"grp_no");
		}	
	}
 }   
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
 	switch(sAction) {
 		case IBSAVE:  // 화면 저장시에
		for(var i=sheetObj.HeaderRows();i<sheetObj.RowCount()+sheetObj.HeaderRows();i++){
			if(sheetObj.GetCellValue(i,"rgn_ofc_cd") == ""){
 					ComShowCodeMessage('CSQ00024','Office');//Please Input Office.
 					return false;
 				}
			if(sheetObj.GetCellValue(i,"fm_vvd_cd") == ""
				|| sheetObj.GetCellValue(i,"to_vvd_cd") == ""){
	 					ComShowCodeMessage('CSQ00024','VVD');//Please Input VVD.
	 					return false;
	 				}
				if(sheetObj.GetCellValue(i,"fm_vvd_cd").length!=9
				||sheetObj.GetCellValue(i,"to_vvd_cd").length!=9){
				ComShowCodeMessage('CSQ00007','VVD(Seq:'+sheetObj.GetCellValue(i,"seq")+')');//VVD code is invaild
	 					return false;
	 				}
	 			}
			// from_week가 to_week 보다 느릴때
			if(sheetObj.GetCellValue(i,"aply_fm_yrwk")>sheetObj.GetCellValue(i,"aply_to_yrwk")){
				ComShowCodeMessage('CSQ00022',sheetObj.GetCellValue(i,"seq"));
 				//To week can't be earlier than From week.\nPlease check the row : {?msg1} SEQ.
 				return false;
 			}		
     		break;
 	}
 	return true;
 }
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
function toggleButtons(step) {
 switch (step) {
	   case "INIT":
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Save");
	       ComBtnDisable("btn_Creation");
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_RowGrpAdd");
	       ComBtnDisable("btn_RowAdd");
	       ComBtnDisable("btn_FigureInquiry");
	       break;
	   case "SEARCH1":
		   ComBtnEnable("btn_Save");
		   ComBtnEnable("btn_Downexcel");
	       ComBtnEnable("btn_Creation");
	       ComBtnEnable("btn_RowGrpAdd");
	       ComBtnEnable("btn_RowAdd");
	       break;
	   case "SEARCH2":
		   ComBtnDisable("btn_Creation");
		   ComBtnDisable("btn_RowGrpAdd");
		   ComBtnDisable("btn_RowAdd");
		   ComBtnEnable("btn_Save");
		   ComBtnEnable("btn_Downexcel");
	       break;
 }
}
 /**
  * 특정이름의 값을 searchParams 에서 변경 가져온다.
  * 
  * @param {string} paramName	필수, 변경할 변수 명
  * @param {string} paramValue	필수, 변경할 변수 값
  */
 function ComSetParams(paramName, paramValue) {
 	try {
         var posName=params.indexOf(escape(paramName) + '=');
         if (posName != -1) {
         	var posValue=posName + (escape(paramName) + '=').length;
         	var endPos=params.indexOf('&', posValue);
         	if (endPos != -1)
         		params=unescape(params.substring(0, posValue)) + paramValue + unescape(params.substring(endPos));
             else
             	params=unescape(params.substring(0, posValue)) + paramValue;
         }
     } catch(err) { ComFuncErrMsg(err.message); }
 }
 
 
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i], 95);
	    }
	}
	/* 개발자 작업  끝 */
