/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_VSK_0228.js
 *@FileTitle : Lane Registration
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
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
		switch (srcName) {
		case "btn_Close":
			ComClosePopup(); 
			break;
		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;
		case "btn_Delete":
			if(sheetObject1.FindCheckedRow("del_chk")==""){
				ComShowCodeMessage("VSK00010");
			}else if(ComShowCodeConfirm("VSK00005")){ 
				ComRowHideDelete(sheetObject1, "del_chk");
			}
			break;
		case "btn_Save":
			btnSave(sheetObject1);
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
				        
		      var HeadTitle="||Group|Lane|Lane Name";

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:0 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"lane_grp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_lane_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetColProperty(0 ,3 , {AcceptKeys:"E" , InputCaseSensitive:1});
		      SetShowButtonImage(2);
		      SetSheetHeight(280);
		      SetColProperty("vsl_slan_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      SetColProperty("lane_grp_nm", {ComboText:"A|B|C|D|E|F|G|H|I|J|K", ComboCode:"A|B|C|D|E|F|G|H|I|J|K"} );
		      }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0228GS.do", sParam);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComOpenWait(false);
		break;
	case IBSAVE: // Save
		var sSaveParam=ComGetSaveString(sheetObj);//sheetObj.GetSaveString(false);
		// in case of no change, do not process
		if(!sheetObj.IsDataModified()|| sSaveParam==""){
			ComShowCodeMessage('VSK00064');
			return;
		}else{
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sParam=FormQueryString(formObj) + "&" + sSaveParam;
 			var sXml=sheetObj.GetSaveData("VOP_VSK_0228GS.do", sParam);
 			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
		}
		break;
	case SEARCH02: // Retrieving vsl_slan_nm
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND12;
		var sParam=FormQueryString(formObj) + "&vsl_slan_cd=" + formObj.tmp_vsl_slan_cd.value;
 		var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
		ComOpenWait(false);
		var vsl_slan_nm=ComGetEtcData(sXml, "checkLane");
		return vsl_slan_nm;
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
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}
function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj=document.form;
	var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
	ComOpenPopup(sUrl, 500, 470, "pickLaneCallBack", "0,0", true);
}

function pickLaneCallBack(rVal) {
	
	var rtnVal = rVal[0];
	
	//sheet1_vsl_slan_cd:tmp_vsl_slan_cd|sheet1_vsl_slan_nm:tmp_vsl_slan_nm
	var curRow = sheet1.GetSelectRow();
	sheet1.SetCellValue(curRow, 'vsl_slan_cd', rtnVal[1]);
	//sheet1.SetCellValue(curRow, 'vsl_slan_nm', rtnVal[0][2]);
	document.form.tmp_vsl_slan_cd.value = rtnVal[1];
	//document.form.tmp_vsl_slan_nm.value = rtnVal[0][2];
	sheet1_OnAfterEdit(sheet1, curRow, 3);
}

function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	// processing about Lane
	if(sheetObj.ColSaveName(Col)=="vsl_slan_cd"){
		// if column length is 3(all input)
		if(ComChkLen(sheetObj.GetCellValue(Row, "vsl_slan_cd"), 3)==2){
			// inputed Group + Lane
			var groupVal=sheetObj.GetCellValue(Row, "lane_grp_nm");
			var laneVal=sheetObj.GetCellValue(Row, "vsl_slan_cd");
			// Checking duplicate
 			for(var i=1; i<sheetObj.RowCount(); i++){
				// current line skip
				if(i==Row){
					continue;
				}
				// not checking deleted line
				if(sheetObj.GetRowHidden(i)){
					continue;
				}
				if((groupVal+laneVal) == sheetObj.GetCellValue(i, "lane_grp_nm") + sheetObj.GetCellValue(i, "vsl_slan_cd")){
					ComShowCodeMessage('VSK00002', "Group=" + groupVal + ", Lane=" + laneVal);
					sheetObj.SetCellValue(Row, "vsl_slan_cd","",0);
					sheetObj.SetCellValue(Row, "vsl_slan_nm","",0);
					return false;
				}
			}
			// in case user input vsl_slan_cd directly, retrieving vsl_slan_nm
 			formObj.tmp_vsl_slan_cd.value=sheetObj.GetCellValue(Row, Col);
			var vsl_slan_nm=doActionIBSheet(sheetObj, formObj, SEARCH02);
			if(vsl_slan_nm){
				sheetObj.SetCellValue(Row, Col+1,vsl_slan_nm,0);
			}else{
				ComShowCodeMessage('VSK00021', sheetObj.GetCellValue(Row, Col));
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.SetCellValue(Row, Col+1,"",0);
			}
		}
	}
}
function btnSave(sheetObj){
	// Checking lane code's length
	for(var i=1; i<=sheetObj.LastRow(); i++){
		if(sheetObj.GetCellValue(i, "vsl_slan_cd")==""){
			ComShowCodeMessage('VSK00027', "Lane");
			return false;
		}else if(ComChkLen(sheetObj.GetCellValue(i, "vsl_slan_cd"), 3) != 2){
			ComShowCodeMessage('VSK00021', "Lane");
			return false;
		}
	}
	// in case of add row
	for(var i=1; i<=sheetObj.LastRow(); i++){
		if("I"==sheetObj.GetCellValue(i, "ibflag")){
			sheetObj.SetCellValue(i, "src_lane_grp_nm",sheetObj.GetCellValue(i, "lane_grp_nm"),0);
			sheetObj.SetCellValue(i, "src_vsl_slan_cd",sheetObj.GetCellValue(i, "vsl_slan_cd"),0);
		}
	}
	doActionIBSheet(sheetObj, document.form, IBSAVE);
}
