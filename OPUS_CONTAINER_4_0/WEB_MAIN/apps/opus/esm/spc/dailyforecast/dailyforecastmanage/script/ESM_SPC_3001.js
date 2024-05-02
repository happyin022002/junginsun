/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_3001.js
*@FileTitle  : SPC Office Level
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/**
 * @extends
 * @class ESM_SPC_3001 : business script for ESM_SPC_3001.
 */
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
//			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		} 
		tRoleApply();
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	tRoleApply();
	sheet1_OnLoadFinish(sheet1);
}
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
function tRoleApply() {
	var formObj=document.form;
	// ComBtnDisable("btn_save");
}
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
		
			if (location.hostname != "")
			var HeadTitle="|Seq.|Office|Eng Name|Local Name|From YrWk|To YrWk|OFC Type|Parent OFC|OFC Kind|OFC Level|1st Parent OFC|2nd Parent OFC|3rd Parent OFC|4th Parent OFC|5th Parent OFC|6th Parent OFC|7th Parent OFC|Del. Flag";
			var headCount=ComCountHeadTitle(HeadTitle);
	//		(headCount, 0, 0, true);
			var prefix="sheet1_";
			
//			2014.08.06 - 시트의 잘못된 Merge 현상을 고치기 위해 DataRowMerge를 1-> 0으로 변경
			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
			var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:65,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ofc_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ofc_locl_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_aply_fm_yrwk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_aply_to_yrwk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"prnt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"intg_cd_val_dp_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_lvl",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"n7th_prnt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 } ];
			 
			InitColumns(cols);
			SetEditable(1);
//			SetSheetHeight(580);
			resizeSheet();
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	switch (sAction) {
	case IBSEARCH:
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
 		sheetObj.DoSearch("ESM_SPC_3001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		ComOpenWait(false);
		break;
	case IBSAVE:
		sheetObj.SetWaitImageVisible(0);
		if(ComShowConfirm(getMsg("SPC90040"))){
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
 			var rslt=sheetObj.GetSaveData("ESM_SPC_3001GS.do", FormQueryString(formObj));
 			sheetObj.LoadSaveData(rslt);
			ComOpenWait(false);
		}
		break;
	}
}
 function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.SetWaitImageVisible(0);
	for (i=0; i < sheetObjects.length; i++) {
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.SetWaitImageVisible(1);
}
function sheet1_OnSaveEnd(sheetObj, Code, errMsg) {
	if(sheetObj.GetEtcData("status") == "OK"){
//		ComShowMessage("saved successfully.");  
		ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}else{
		ComShowMessage(errMsg);
	}	
}


/**
 * This method counts numbers again.
 * @param Col
 * @param SortArrow
 */
//2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
function sheet1_OnSort(Col, SortArrow){
	sheet1.ReNumberSeq();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
