/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0059.js
*@FileTitle  : VSL SKD Delete & Closing(CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var existEmptyPf=false;
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;
		case "btn_Delete":
			if(checkSelection(sheetObject1)){
				if(ComShowConfirm(ComGetMsg("VSK00088"))){
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
		case "btn_SkdClosing":
			if(checkSelection(sheetObject1)){
				if(checkStatus(sheetObject1)=="ACT"){
					if(ComShowConfirm(ComGetMsg("VSK00103"))){
						var result=doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
						}
					}
				}else{
					ComShowCodeMessage("VSK00015");
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
		case "btn_SkdActivate":
			if(ComShowConfirm(ComGetMsg("VSK00014"))){
				var result=doActionIBSheet(sheetObject1, formObj, MULTI03);
				if(result){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
			break;
		case "btns_search1":
			openLandCd();
			break;
		case "btns_search2":
			openVslCd();
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

function initControl() {
	var formObj=document.form;
	
	axon_event.addListenerForm('blur'    , 'eng_keypress', formObj);
	axon_event.addListenerForm('keypress', 'enter_keypress', formObj);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	formObj.vsl_slan_cd.focus();
}

function initPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].RemoveAll();
		
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
				SetSelectionMode(smSelectionList);
			    var HeadTitle1="|Sel.|Vessel Code|Voyage No.|Direction|Vessel Name|Lane|Status|Status|Created Date|First Port ETA|||";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			    var prefix="sheet1_";

			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			    var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:0 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vir_skd_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_port_brth_dt", KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_sts_mnl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
//			    skd_sts_cd
			    InitColumns(cols);
			    ComBtnDisable("btn_SkdClosing");  
			    SetEditable(1);
			    SetEditableColorDiff(0);
			    sheetObj.SetImageList(0,"img/btns_search.gif");
			    SetColHidden("sheet1_vir_skd_sts_cd",1);
			    resizeSheet();
			}
			break;
	}
}

//handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if (validateForm(sheetObj, formObj, sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.RenderSheet(0);
//				sheetObj.DoSearch("VOP_VSK_0059GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				var sXml = sheetObj.GetSearchData("VOP_VSK_0059GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				sheetObj.LoadSearchData(sXml, {sync:1});
				sheetObj.SetColProperty("sheet1_skd_sts_cd", {ComboText:"Holding|Booking|Booking|", ComboCode:"CLO|BKG|BKGNOD|ACT"} );
				sheetObj.SetColProperty("sheet1_vir_skd_sts_cd", {ComboText:"Holding|Booking|Booking|", ComboCode:"CLO|BKG|BKGNOD|ACT"} );
				sheetObj.RenderSheet(1);
				ComOpenWait(false);
			}
			break;
		case IBDELETE:
			var SaveStr=ComGetSaveString(sheetObjects);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sXml=sheetObj.GetSaveData("VOP_VSK_0059GS.do", FormQueryString(formObj) + "&" + SaveStr);
			ComOpenWait(false);
			var laneData=ComGetEtcData(sXml, "lane").split("|");
			var vvdData=ComGetEtcData(sXml, "vvd").split("|");
			var hisData=ComGetEtcData(sXml, "his").split("|");
			var turnVoyData=ComGetEtcData(sXml, "turn_voy").split("|");
			var turnDirData=ComGetEtcData(sXml, "turn_dir").split("|");
			if(vvdData!=""){
				var sUrl="/opuscntr/VOP_VSK_0249.do?";
				for(var i=0; i<vvdData.length-1; i++){
					sUrl=sUrl + "&lane_vvd=" + laneData[i] + "&bkg_vvd=" + vvdData[i] + "&his_vvd=" + hisData[i] + "&turn_voy=" + turnVoyData[i] + "&turn_dir=" + turnDirData[i] + "&aft_vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				}
				ComOpenPopup(sUrl, 830, 500, "returnDeletePop", "0,0", true);
			}else{
				sheetObj.LoadSaveData(sXml);
				if(!VskGetErrorXml(sXml)){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
			
			break;
		case MULTI01: // Manual Close
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			var sParam=FormQueryString(formObj);

			var sXml=sheetObj.GetSaveData("VOP_VSK_0059GS.do", sParam + "&" + ComGetSaveString(sheetObj));
			sheetObj.LoadSaveData(sXml,{Sync:1} );
			ComOpenWait(false);
			if(VskGetErrorXml(sXml)){
				return false;
			}else{
				return true;
			}
			break;
		case SEARCH01: // Lane Code Retrieve
			formObj.f_cmd.value=SEARCH01;
			if ( sheetObj.id == "sheet1"){
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0059GS.do" , sParam);
				ComOpenWait(false);
				var vsl_slan_nm=ComGetEtcData(sXml, "vsl_slan_nm");
				if(!vsl_slan_nm){
					var message=VskGetXmlNodeValue(sXml, "MESSAGE");
					if(message!=""){
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}else{
						ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
					}
					formObj.tmp_vsl_slan_cd.value="";
					formObj.vsl_slan_cd.value="";
					formObj.vsl_slan_cd.focus();
					return false;
				}else{
					formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
					formObj.vsl_cd.focus();
				}
			}
			break;
		case SEARCH02: // Vessel Code Retrieve
			formObj.f_cmd.value=COMMAND16;
			if ( sheetObj.id == "sheet1"){
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				ComOpenWait(false);
				var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		    	if(!vsl_eng_nm){ // undefined
		    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
					formObj.tmp_vsl_cd.value="";
					formObj.vsl_cd.value="";
					formObj.vsl_cd.focus();
					return false;
		    	}else{
		    		formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
		    		formObj.vsl_cd.focus();
		    	}
			}
			break;
		case MULTI03: // btn_SkdActivate click
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI03;
			//var sParam = FormQueryString(formObj);
			var prefix="sheet1_";
			var sParam="f_cmd=" + MULTI03 + "&" +
						prefix + "vsl_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "vsl_cd") + "&" +
						prefix + "skd_voy_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "skd_voy_no") + "&" +
						prefix + "skd_dir_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "skd_dir_cd");

			var sXml=sheetObj.GetSaveData("VOP_VSK_0059GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			if(VskGetErrorXml(sXml)){
				return false;
			}else{
				return true;
			}
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(formObj.vsl_slan_cd.value == "" && formObj.vsl_cd.value == ""){
			ComShowCodeMessage('VSK00027', 'Lane CD or Vessel CD');
			formObj.vsl_slan_cd.value="";
			formObj.vsl_slan_cd.focus();
			return false;
		}
	}
	return true;
}

/**
 * Open Lane Code Help
 */
function openLandCd() {
	var sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + document.form.vsl_slan_cd.value;
	ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
}

/**
 * After [Lane Code] Button Click, calling from Pop-up
 * @param rtnObjs
 * @return
 */	
function returnDeletePop(rtnObjs) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function returnLaneCdHelp(rVal){
	var formObj=document.form;
	
	var rtnObjs  = rVal[0];
	if(rtnObjs){
		if(rtnObjs.length > 0){
			formObj.vsl_slan_cd.value=rtnObjs[1];
			doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		}
	}
}

function openVslCd() {
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value;
	ComOpenPopup(sUrl, 464, 500, "returnVslCdData", "0,0", true);
	
}
function returnVslCdData(rtnObjs) {
	var formObj=document.form;

	if(rtnObjs){
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				
				formObj.vsl_cd.value=rtnDatas[1];
			}
		}
	}
}

/**
 * Handling English of onkeypress
 **/
function eng_keypress() {
	var obj=ComGetEvent();
	var name=ComGetEvent("name");
	switch(name){
		case "vsl_slan_cd":
		case "vsl_cd":
			obj_chk();
			break;
		default:
	}
}

/**
 * Handling enter key
 */
function obj_chk() {
	var formObj=document.form;
	var obj=ComGetEvent();
	switch (ComGetEvent("name")) {
		case "vsl_slan_cd":
			if(obj.value==""){
				formObj.tmp_vsl_slan_cd.value="";
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(sheetObj.RowCount()>0){
					sheetObj.RemoveAll();
				}
				//formObj.vsl_cd.value = "";
			}
			break;
		case "vsl_cd":
			if(obj.value==""){
				formObj.tmp_vsl_cd.value="";
				break;
			}
			if(!obj || ComChkLen(obj.value, 4)!=2){
				break;
			}
			if(formObj.tmp_vsl_cd.value != obj.value){
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH02);
				if(sheetObj.RowCount()>0){
					sheetObj.RemoveAll();
				}
			}
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj) {
	with(sheetObj){
		if(RowCount()> 0){
			for(var i=HeaderRows(); i<HeaderRows()+RowCount(); i++){
				if(GetCellValue(i, "sheet1_skd_sts_cd")=="CLO"){
					SetRowEditable(i,0);
					SetRowBackColor(i,"#F0F0F0");
				}else if(GetCellValue(i, "sheet1_skd_sts_cd")=="BKG"){
					SetRowBackColor(i,"#FFFF99");
				}else if(GetCellValue(i, "sheet1_skd_sts_cd")=="BKGNOD"){
					SetRowEditable(i,0);
					SetRowBackColor(i,"#FFA850");// nonRemovable Booking VVD
				}
			}
		}
	}
}

function changeStatus(sheetObj){
	var dataRows=sheetObj.RowCount();
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+dataRows; i++){
		if(sheetObj.GetCellValue(i, "sheet1_Sel")==1){
			if(sheetObj.GetCellValue(i, "sheet1_skd_sts_cd")!="CLO"){
				sheetObj.SetCellValue(i, "sheet1_skd_sts_cd","CLO",0);
				sheetObj.SetCellValue(i, "sheet1_skd_sts_mnl_flg","Y",0);
				sheetObj.SetCellValue(i, "sheet1_Sel",0,0);
				sheetObj.SetCellValue(i, 0,'R',0);
				// CCA, no divide Manual/Auto. so close is not editable
				sheetObj.SetRowBackColor(i,"#F0F0F0");
				sheetObj.SetRowEditable(i,0);
			}
		}
	}
}

function checkSelection(sheetObj){
	var check=false;
	var dataRows=sheetObj.RowCount();
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+dataRows; i++){
		if(sheetObj.GetCellValue(i, "sheet1_Sel")==1){
			check=true;
			break;
		}
	}
	return check;
}

function checkStatus(sheetObj){
	var dataRows=sheetObj.RowCount();
	var status=0;
	var count=0;
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+dataRows; i++){
		if(sheetObj.GetCellValue(i, "sheet1_Sel")==1){
			count++;
			
			if(sheetObj.GetCellValue(i, "sheet1_skd_sts_cd")=="CLO"){
				status=status + 1;
			}else if((sheetObj.GetCellValue(i, "sheet1_skd_sts_cd")=="ACT" || sheetObj.GetCellValue(i, "sheet1_skd_sts_cd")=="RDY") &&
					(sheetObj.GetCellValue(i, "sheet1_vir_skd_sts_cd")=="ACT" || sheetObj.GetCellValue(i, "sheet1_vir_skd_sts_cd")=="RDY")){
				status=status + 2;
			}else{
				status=0;
				break;;
			}
		}
	}
	// count of checked VVD : count
	// checked VVD is Closed : status + 1
	// checked VVD is not Closed(Non Booking) : status + 2
	if(status/count==1){
		return "CLO";
	}else if(status/count==2){
		return "ACT";
	}else{
		return "";
	}
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
	// Button Handling about selected a VVD
	var skd_sts_cd=sheetObj.GetCellValue(NewRow, "sheet1_skd_sts_cd");
	// SKD Activate Button
	if("Y"==formObj.availActivate.value) {
		if( skd_sts_cd=="CLO"){
			ComBtnEnable("btn_SkdActivate");
		}else{
			ComBtnDisable("btn_SkdActivate");
		}
	}
}

/**
 * Handling English of onkeypress
 */
function enter_keypress() {
	VskKeyEnter();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}