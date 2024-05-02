/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : vop_pso_0207.jsp
 *@FileTitle  : Monthly Estimation Creation (Detail)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/15
=========================================================*/
// public variable
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects=new Array();
var comboCnt=0;
var ROWMARK="|";
var FIELDMARK=",";
var prefix = "sheet1_";
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return; // 버튼 상태를 확인을 합니다.
		switch (srcName) {
		case "btn_close":
			ComClosePopup();
			break;
		case "btn_Retrieve":
			// alert(srcName);
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			changeColor();
			break;
        case "btns_calendar_s":
        	var cal=new ComCalendar();
        	cal.setDisplayType('month');
            cal.select(form.sdt, "yyyy-MM");
        	break;
        case "btns_calendar_e":
        	var cal=new ComCalendar();
        	cal.setDisplayType('month');
        	cal.select(form.edt, "yyyy-MM");
        	break;
		case "btn_New":
			// alert(srcName);
			formObject.match_flag[0].checked = "checked";
			break;
		case "btn_Save":
			// alert(srcName);
			if(!sheetObject1.IsDataModified()){
				ComShowCodeMessage("PSO00034"); //There is no changed Data.
				return;
			}
			
			var iDelCnt = sheetObject1.CheckedRows(prefix+"del_chk");
			if(iDelCnt > 0){
				if(!ComShowCodeConfirm("PSO01008")){//Do you want to delete?
					return;
				}
				//Delete로 변환시킨다.
				SetRowStatusDelete(sheetObject1);
			}else{
				if(!ComShowCodeConfirm("PSO01009")){//Do you want to save?
					return;
				}
			}
			
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_Excel":
			if (sheetObject1.RowCount() < 1) {// no data
				ComShowCodeMessage("COM132501");
			} else {
				sheetObject1.Down2Excel({
					HiddenColumn : 1,
					Merge : 1,
					SheetDesign : 1,
					SheetName : "Monthly Estimation Detail"
				});
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	for (i = 0; i < sheetObjects.length; i++) {
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	changeColor();

	//ComBtnDisable("btns_calendar_s");
	//ComBtnDisable("btns_calendar_e");
}
/**
 * Changing Color of IBSHEET
 */
function changeColor() {
	var colorObj = "#FFFFFF";
	sheetObjects[0].SetColBackColor("sheet1_estm_amt", "#CDFFFE");// Class Input1
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetid = sheetObj.id;
	switch (sheetid) {
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1 = "||Seq.|Activity Date\n(ATD/ETD)|Account\nCode|Cost\nCode|Revenue\nlane|Conti.|Port|Port\nSeq.|Revenue VVD|Cur.|Estimate Cost|Actual Cost|Accrual Cost|Update\nFlag|Update\nUser|Update\nDate|SYS_SRC_ID|ESTM_SEQ_NO|EXE YRMON|REV YRMON";
			var headCount = ComCountHeadTitle(HeadTitle1);
			

			SetConfig({SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1});

			var info = {Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1};
			var headers = [ { Text : HeadTitle1, Align : "Center"} ];
			InitHeaders(headers, info);

			  var cols = [ 
			             {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
  			             {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",	ColMerge:0,   SaveName:"seq" },
  			             {Type:"Text",      Hidden:0,  Width:85,  Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt",   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_lane",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"conti_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_vvd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estm_amt",    	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
  			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"act_amt",     	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"accl_amt",    	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
  			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sys_src_id" },
  			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"estm_seq_no" },
  			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"exe_yrmon"},
  			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_yrmon"} ];

			InitColumns(cols);
			SetColProperty(0, prefix + "act_dt", {Format : "####-##-##"});
			SetEditable(1);
			//SetSheetHeight(390);
			resizeSheet(sheetObj);
		}

		break;
	}
}
function initCombo(comboObj, comboNo) {
	var formObject=document.form;
  
	switch(comboObj.options.id) {  
		case "conti_cd":
			with (comboObj) { 
				SetMultiSelect(true);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(0);
				SetDropHeight(150);
				SetMaxLength(4);
				SetColWidth(0, "40");
				SetColWidth(1, "100");
			}
			if (ComTrim(gContiCd) != ""){
				var comboItems=gContiCd.split(ROWMARK);
				var comboItem="";
				conti_cd.InsertItem(-1, "ALL|", "ALL");	//ALL
				for (var i=0 ; i < comboItems.length ; i++) {
					comboItem=comboItems[i].split(FIELDMARK);
					//conti_cd.InsertItem(-1, comboItem[0], comboItem[1]);
					conti_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
				}
				//conti_cd.SetSelectIndex(0);
			}else{
				conti_cd.RemoveAll();
			}
			break; 

		case "acct_cd":		//Account 
			with (comboObj) { 
				SetMultiSelect(true);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
				SetColWidth(0, "60");
				SetColWidth(1, "300");
				SetEnable(false);
			}
			if (ComTrim(gAcctCd) != ""){
				var comboItems=gAcctCd.split(ROWMARK);
				var comboItem="";
				acct_cd.InsertItem(-1, "ALL|", "ALL");	//ALL
				for (var i=0 ; i < comboItems.length ; i++) {
					comboItem=comboItems[i].split(FIELDMARK);
					//acct_cd.InsertItem(-1, comboItem[0], comboItem[1]);
					acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
				}
				acct_cd.SetSelectCode(gParamAcctCd, true);
				formObject.account_nm.value = comboObj.GetText(gParamAcctCd, 1);
				
			}else{
				acct_cd.RemoveAll();
			}
		break;
	} 
}
function setParameterObject(enableFlag){
	var formObj = document.form;
	if(enableFlag == false){
		//account, cost 처음 넘어 왔던 값으로 변경한다.
		acct_cd.SetSelectIndex(-1, false);//초기화.
	
		acct_cd.SetSelectCode(gParamAcctCd, true);
		formObj.account_nm.value = acct_cd.GetText(gParamAcctCd, 1);	
		
		acct_cd.SetEnable(false);
		
		formObj.cost_cd.value = gParamCostCd;
		formObj.sdt.value= gParamSdt;
		formObj.edt.value= gParamEdt;
		
		ComBtnEnable("btns_calendar_s");
		ComBtnEnable("btns_calendar_e");
		
	}else{
		ComBtnEnable("btns_calendar_s");
		ComBtnEnable("btns_calendar_e");
		acct_cd.SetEnable(true);
		formObj.cost_cd.value = "";
	}
}

var selComboIndex, selComboCode;
function conti_cd_OnSelect(comboObj ,index, text , code) {
	selComboIndex = index;
	selComboCode = code;
}
function conti_cd_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	
	var formObj = document.form;
	var iOneSelItem = 0;
	var tmpSelCode = comboObj.GetSelectCode(); // 멀티콤보에 선택된 아이템 카운터.
	var arrSelCode = tmpSelCode.split(",");
	var name = "";
	var isAllText= false;
	for(var i=0; i < arrSelCode.length ; i++){
		if(arrSelCode[i].indexOf("ALL") > -1){
			isAllText = true;
			continue;
		}else{
			if("" != arrSelCode[i]){
				iOneSelItem++;
				//tmpSelContiCd=arrSelCode[i];
				name = comboObj.GetText(arrSelCode[i], 1);
			}
		}
	}
	
	if(isAllText){
		//acct_cd.SetEnable(false);
		if(iOneSelItem==1){
			setParameterObject(true);
		}else{
			setParameterObject(false);
		}
		
	}else{
		if(iOneSelItem==1){
			setParameterObject(true);
		}else{
			setParameterObject(false);
		}
	}
	
	
	//sheet 정보를 리셋한다.
	sheetObjects[0].RemoveAll();
	
}

var selAcctComboIndex, selAcctComboCode;
function acct_cd_OnSelect(comboObj ,index, text , code) {
	selAcctComboIndex = index;
	selAcctComboCode = code;
}
function acct_cd_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selAcctComboIndex, selAcctComboCode);

	var formObj = document.form;
	var iOneSelItem = 0;
	var tmpSelCode = comboObj.GetSelectCode(); // 멀티콤보에 선택된 아이템 카운터.
	var arrSelCode = tmpSelCode.split(",");
	var name = "";
	var isAllText= false;
	for(var i=0; i < arrSelCode.length ; i++){
		if(arrSelCode[i].indexOf("ALL") > -1){
			isAllText = true;
			break;
		}else{
			iOneSelItem++;
			//tmpSelContiCd=arrSelCode[i];
			name = comboObj.GetText(arrSelCode[i], 1);
		}
	}

	if(isAllText){
		formObj.account_nm.value = "ALL";
	}else{
		if(iOneSelItem==1){
			formObj.account_nm.value = name;
		}else{
			formObj.account_nm.value = "";
		}
	}
	
	//sheet 정보를 리셋한다.
	sheetObjects[0].RemoveAll();
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Retrieving
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("VOP_PSO_0207GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
			}
		}
		break;
	case IBSAVE: // Save
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var SaveStr=ComGetSaveString(sheetObj);
				var sXml=sheetObj.GetSaveData("VOP_PSO_0207GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				//sheetObj.DoSave("VOP_PSO_0207GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);

				sheetObj.LoadSaveData(sXml,{Sync:2} );
			}
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
/**
 * if Est-Act < 0, Setting Accrual Cost to 0
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	// Est-Act >= 0
	var sSaveName = sheetObj.ColSaveName(Col);

	if (sSaveName == "sheet1_estm_amt") {// Estimate Cost change
		var tmpAcclAmt = 0;
		var tmpEstmAmt = Number(sheetObj.GetCellValue(Row, "sheet1_estm_amt"));
		var tmpActAmt = Number(sheetObj.GetCellValue(Row, "sheet1_act_amt"));
		
		tmpAcclAmt = tmpEstmAmt - tmpActAmt;
		/*
		if(tmpAcclAmt < 0){
			tmpAcclAmt = 0;
		}*/
		sheetObj.SetCellValue(Row, "sheet1_accl_amt", tmpAcclAmt, 1);
		// sheetObj.SetCellValue(Row,Col+2,sheetObj.GetCellValue(Row,Col) -
		// sheetObj.GetCellValue(Row,Col+1) < 0 ?
		// 0:sheetObj.GetCellValue(Row,Col) - sheetObj.GetCellValue(Row,Col+1));
	}
}
function sheet1_OnSearchEnd(sheetObj, Row, Col) {
    
    var sheetOrgData = sheetObj.ExportData({Type:"json"}).data;
    if(sheetOrgData == undefined || sheetOrgData == null || sheetOrgData.length == 0) return;
    
    var sIdx = sheetObj.HeaderRows();
    var eIdx = sheetObj.LastRow();
    var cLastIdx = sheetObj.LastCol();
    var resultSheetObj = new Array();
    var updFlgCellColor = "#FEFA91";
    
    for(var i=sIdx; i<=eIdx; i++) {
        var varUpdFlag = sheetObj.GetCellValue(i, "sheet1_upd_flg");
        if(varUpdFlag == "Y"){
            sheetObj.SetCellBackColor(i, "sheet1_estm_amt", updFlgCellColor);
        }
        
    }
    
	//2015.03.30 삭제 부분 주석 처리
	/*
	var iOneSelItem = 0;
	var tmpSelCode = comboObjects[0].GetSelectCode(); // 멀티콤보에 선택된 아이템 카운터.
	var arrSelCode = tmpSelCode.split(",");
	var tmpSelContiCd = "";
	for(var i=0; i < arrSelCode.length ; i++){
		if(arrSelCode[i].indexOf("ALL") > -1){
			continue;
		}else{
			iOneSelItem++;
			tmpSelContiCd=arrSelCode[i];
		}
	}
	
	if(iOneSelItem == 1){
		//var varContiCd = comboObjects[0].GetSelectCode();
		for(var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
			if(sheetObj.GetCellValue(i, prefix+"conti_cd") == tmpSelContiCd){
				sheetObj.SetCellEditable(i,prefix+"del_chk",1);
			}else{
				sheetObj.SetCellEditable(i,prefix+"del_chk",0);
			}
			
		}
	}*/
}
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	/*
	var formObj=document.form;
	if(sheetObj.RowCount()> 0 ){
		var delChk = sheetObj.GetCellValue(Row, prefix+"del_chk");
		if(delChk == 1){
			sheetObj.SetCellValue(Row, prefix+"ibflag", 	"U", 0);
			//sheetObj.SetRowStatus(Row,"D");
			//sheetObj.SetRowHidden(Row, 1);
		}else{
			sheetObj.SetCellValue(Row, prefix+"ibflag", 	"R", 0);
			//sheetObj.SetRowStatus(Row,"R");
		}
	}*/
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
	doActionIBSheet(sheetObj, document.form, IBSEARCH);// After Creation Button
														// Click, reRetrieving
}

function SetRowStatusDelete(sheetObj){
	if(sheetObj.RowCount()> 0 ){
		for(var i=sheetObj.LastRow(); i>=sheetObj.HeaderRows(); i--){
			var delChk = sheetObj.GetCellValue(i, prefix+"del_chk");
			if(delChk == 1){
				sheetObj.SetRowStatus(i,"D");
				sheetObj.SetRowHidden(i, 1);
			}
		}
	}
}

function resizeSheet(){
    for (var i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
