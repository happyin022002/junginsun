/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0024.js
*@FileTitle  : Canal Transit List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0024 : business script for VOP_VSK_0024
 */
//function VOP_VSK_0024() {
//	this.processButtonClick=tprocessButtonClick;
//	this.setSheetObject=setSheetObject;
//	this.loadPage=loadPage;
//	this.initSheet=initSheet;
//	this.initCombo=initCombo;
//	this.initControl=initControl;
//	this.doActionIBSheet=doActionIBSheet;
//	this.setTabObject=setTabObject;
//	this.validateForm=validateForm;
//}
// public variable
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if(checkPeriod()){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}
			break;
		case "btn_S/PRegistration":
			var sUrl="/opuscntr/VOP_VSK_0240.do";
			ComOpenPopupWithTarget(sUrl, 960, 630, "", "0,0", true);
			break;
		case "btn_TLCreation":
			doActionIBSheet(sheetObject1, formObj, SEARCH02);
			break;
		case "btn_TBCreation":
			doActionIBSheet(sheetObject1, formObj, SEARCH03);
			break;
		case "btn_cal1":
			var cal=new ComCalendar();
			cal.setDisplayType('month');
			cal.setEndFunction("clearSheet");
			cal.select(formObj.start_month, 'yyyy-MM');
			break;
		case "btn_cal2":
			var cal=new ComCalendar();
			cal.setDisplayType('month');
			cal.setEndFunction("clearSheet");
			cal.select(formObj.end_month, 'yyyy-MM');
			break;
		case "btns_search":
			var sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value + "&intg_cd_id=CD00717";

    		ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
			//var rVal=ComOpenPopupWithTarget(sUrl, 458, 470, "", "0,0", true);
			//if(rVal){
			//	formObj.vsl_slan_cd.value=rVal;
			//}
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
 * Calling from [Lane Code] Pop-up
 * @param rtnObjs
 * @return
 */
function returnLaneCdHelp(rVal){
	var formObj=document.form;
	
	var rtnObjs  = rVal[0]
	if(rtnObjs){
			if(rtnObjs.length > 0){
				formObj.vsl_slan_cd.value=rtnObjs[1];
			}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0; k<comboObjects.length; k++){
		initCombo(comboObjects[k],k+1);
	}
	initControl();
	// date Initializing
	var formObj=document.form;
	var today=new Date();
	with (formObj) {
		start_month.value=ComGetNowInfo("ym", "-");
		end_month.value=ComGetNowInfo("ym", "-");
	}
	// combo Initializing
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
//	comboObjects[0].SetSelectCode("ALL");
	sheet1_OnSearchEnd(sheet1);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {	        
	        if (location.hostname != "")
	        var HeadTitle1="|Bound|VVD|Lane\nCode|Coastal SKD|Coastal SKD|Coastal SKD|Booking\nStatus|Surcharge|Surcharge|Surcharge|Surcharge|Surcharge|Surcharge|Saving Bunker\n/ Canal fee|||";
	        var HeadTitle2="|Bound|VVD|Lane\nCode|ETA|ETB|ETD|Booking\nStatus|Limit Time|Limit Time|Carrying Tier|Carrying Tier|Carrying Tier|Carrying Tier|Saving Bunker\n/ Canal fee|||";
	        var HeadTitle3="|Bound|VVD|Lane\nCode|ETA|ETB|ETD|Booking\nStatus|Ratio (%)|Speed (kts)|Port|Tier|TEU|Ratio (%)|Saving Bunker\n/ Canal fee|||";
	        var headCount=ComCountHeadTitle(HeadTitle1);
//	        (headCount, 0, 0, true);
	        var prefix="sheet1_";	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"},
	                    { Text:HeadTitle2, Align:"Center"},
	                    { Text:HeadTitle3, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bound",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_sts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",  ColMerge:0,   SaveName:prefix+"scg_lmt_act_ratio", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1 },
		               {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",  ColMerge:0,   SaveName:prefix+"scg_lmt_act_spd",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scg_car_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",  ColMerge:0,   SaveName:prefix+"scg_car_tier",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1 },
		               {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",  ColMerge:0,   SaveName:prefix+"scg_car_teu",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1 },
		               {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",  ColMerge:0,   SaveName:prefix+"scg_car_ratio",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1 },
		               {Type:"Image",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"detail",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 }, //hidden 처리, 2019,09,18 김성욱 (Hotfix 194)
		               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"clpt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
		               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
	         
	        InitColumns(cols);	
	        SetEditable(0);
	        resizeSheet();
	        SetImageList(0,"img/btns_detail.gif");
	        SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
	        SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
	        SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
	        SetRowHeight(0,20);
	        SetRowHeight(1,20);
	        SetRowHeight(2,20);
		}
		break;
	}
}
function initCombo(comboObj, comboNo) {
	var formObj=document.form;
	switch(comboObj.options.id) { 
		case "vndr_seq": 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetDropHeight(160);
		   	}
			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case COMMAND01: // WINDOW OPEN
		formObj.f_cmd.value=SEARCH01;
		var sParam=FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0024GS.do", sParam);
		var vendorSeq=ComGetEtcData(sXml, "vendorSeq");
		//var vendorNm = ComGetEtcData(sXml, "vendorNm");
		var vendorNm=ComGetEtcData(sXml, "vendorSeq");
		if(!vendorSeq){
			vendorSeq="";
		}else{
			vendorSeq="|" + vendorSeq;
		}
		if(!vendorNm){
			vendorNm="";
		}else{
			vendorNm="|" + vendorNm; 
		}
		var vendorSeqArr=("ALL"+vendorSeq).split("|");	//
		var vendorNmArr=("ALL"+vendorNm).split("|");	//
		//CTRL Combo Setting.
		appendMultiComboItem(getComboObject("vndr_seq"), vendorSeqArr, vendorNmArr, "", "DEF");
		break;
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value=SEARCH;
		// in case of PAPCA, don't express surcharge
		ComOpenWait(true);
		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0024GS.do", sParam);
		sheetObj.RenderSheet(0);
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		sheetObj.RenderSheet(1);
		ComOpenWait(false);
		break;
	case SEARCH01: // Lane Code Retrieve
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND12;
		var sParam=FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
		ComOpenWait(false);
		var vsl_slan_nm=ComGetEtcData(sXml, "checkLane");
		if(vsl_slan_nm==null || vsl_slan_nm==""){
			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
			formObj.vsl_slan_cd.value="";
		}
		break;
	case SEARCH02: // Transmitting to SPP
		formObj.f_cmd.value=SEARCH02;
		var sParam=FormQueryString(formObj);
		if(sheetObj.RowCount()> 0){
			ComOpenWait(true);
 			var sXml=sheetObj.GetSaveData("VOP_VSK_0024GS.do", sParam);
			var msg=VskGetXmlNodeValue(sXml, "MESSAGE");
			ComOpenWait(false);
			if(msg!=""){
				ComShowMessage(msg);
			}
		}
		break;
	case SEARCH03: // Transmitting PAPCA list in one year
		formObj.f_cmd.value=SEARCH02
		formObj.bkg_sts.value="TBCreate";
		var sParam=FormQueryString(formObj);
		if(sheetObj.RowCount()> 0){
			// in case of PAPCA, do not process
			if(port_cd.value!="PAPCA"){
				ComShowCodeMessage("VSK00019");
				return false;
			}
			if(formObj.start_month.value.substring(5)!="01" || formObj.end_month.value.substring(5)!="12"){
				ComShowCodeMessage("VSK00068");
				return false;
			}
			ComOpenWait(true);
 			var sXml=sheetObj.GetSaveData("VOP_VSK_0024GS.do", sParam);
			var msg=VskGetXmlNodeValue(sXml, "MESSAGE");
			ComOpenWait(false);
			if(msg!=""){
				ComShowMessage(msg);
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
function initControl(){
	var formObj=document.form;
////	axon_event.addListenerForm("keypress", "enter_keypress", formObj);
////    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);
    axon_event.addListenerForm("change", "obj_change", formObj);
////    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("blur", "obj_beforedeactivate", formObj);
//    axon_event.addListenerForm("focus", "obj_activate", formObj);
////    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
//    vndr_seq.SetSelectIndex(-1);
    vndr_seq.SetSelectCode("");
}
/**
 * Handling enter key
 */
function enter_keypress(){
	VskKeyEnter();
}
function obj_change(){
	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	switch(ComGetEvent("name")){
		case "port_cd":
		case "vsl_slan_cd":
		case "start_month":
		case "end_month":
		case "surcharge":
			clearSheet();
			break;
		default:
			break;
	}	
}
function obj_keypress(){
	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	switch(ComGetEvent("name")){
		case "vsl_slan_cd":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "start_month":
		case "end_month":
			ComKeyOnlyNumber();
			break;
	}
}
/**
 * Handling focus out event
 */
function obj_beforedeactivate() {
	var formObj=document.form;
	var obj=ComGetEvent();
	switch (ComGetEvent("name")) {
		case "start_month":
		case "end_month":
			ComChkObjValid(ComGetEvent());
			break;
	}
}
/**
 * Remove mask separator
 */
function obj_activate() {
	switch (ComGetEvent("name")) {
		case "start_month":
		case "end_month":
			ComClearSeparator(ComGetEvent());
			break;	
	}
	if(event.srcElement.options){
//		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
function obj_keyup(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=ComGetEvent();
	switch (ComGetEvent("name")) {
		case "vsl_slan_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				formObj.vsl_slan_cd.focus();
			}
			break;
	}
}
function sheet1_OnClick(sheetObj, Row, Col){
	// Detail button click, VOP_VSK_0246 open
	if(sheetObj.ColSaveName(Col)=="sheet1_detail"){
		if(sheetObj.GetCellValue(Row, Col) == '0'){
			var sUrl="/opuscntr/VOP_VSK_0246.do?vvd=" + sheetObj.GetCellValue(Row, "sheet1_vvd") + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, "sheet1_vsl_slan_cd") + "&bound=" + sheetObj.GetCellValue(Row, "sheet1_bound") + "&vps_port_cd=" + sheetObj.GetCellValue(Row, "sheet1_scg_car_port_cd");
			ComOpenPopupWithTarget(sUrl, 1000, 620, "", "0,0", true);			
		}
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	// in case of panama, don't express surcharge
	var prefix="sheet1_";
	if("PAPCA"==formObj.port_cd.value){
		sheetObj.SetColBackColor(prefix + "scg_lmt_act_ratio","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "scg_lmt_act_spd","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "scg_car_port_cd","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "scg_car_tier","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "scg_car_teu","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "scg_car_ratio","#F0F0F0");
		sheetObj.SetColBackColor(prefix + "detail","#F0F0F0");
	}
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
		// SPEED<0, Setting Red color
		if(sheetObj.GetCellValue(i, "sheet1_scg_lmt_act_spd") < 0){
			sheetObj.SetCellFontColor(i, "sheet1_scg_lmt_act_spd","#FF0000");
		}
	}
	
}
function getComboObject(comboId){
	var cnt=comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].options.id== comboId){
				return comboObjects[i];
			}
		}
	}
	return null;
}
function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
	comboObj.RemoveAll();
	if(optionCdArr != null){
		if(sFlag == "DEF"){
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}else{
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}
		comboObj.SetSelectCode(selCode,false);
	}
}
function clearSheet(){
	sheetObjects[0].RemoveAll();
}
function vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text){
	clearSheet();
}
function checkPeriod(){
	var formObj=document.form;
	var start_month=formObj.start_month.value;
	var end_month=formObj.end_month.value;
	var port_cd=formObj.port_cd.value;
	monthToDate();
	var start_date=formObj.start_date.value;
	var end_date=formObj.end_date.value;
	if(ComChkPeriod(start_date, end_date) < 1){
		ComShowCodeMessage("VSK00025", "End date", "start date");
	}
	if("PAPCA"==port_cd){
		return true;
	}
	// in case of EGSCA, checking month is in 1 month
//	var tmp_date=ComGetDateAdd(start_date, "M", 1);
	// in case of EGSCA, checking month is in 3 months (2015.04.21 1>3months)
	var tmp_date=ComGetDateAdd(start_date, "M", 3);
	tmp_date=ComGetDateAdd(tmp_date, "D", -1);
	if(ComGetDaysBetween(tmp_date, end_date)>0){
		ComShowCodeMessage('VSK00018');
		return false;
	}else{
		return true;
	}
}
function monthToDate(){
	var formObj=document.form;
	var start_month=formObj.start_month.value;
	var end_month=formObj.end_month.value;
	formObj.start_date.value=start_month + "-01";
	formObj.end_date.value=end_month + "-" + ComGetLastDay(end_month.substring(0, 4), ComParseInt(end_month.substring(5,7)));
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
