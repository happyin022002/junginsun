/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0576.js
*@FileTitle  : PSA Container Booking I/F History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/**
 * business script for esm_bkg_0576
 */
function esm_bkg_0576()
{
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.sheet1_OnClick=sheet1_OnClick;
	this.setComboObject=setComboObject;
	this.comboStatus_OnChange=comboStatus_OnChange;
	this.initCombo=initCombo;
	this.doActionIBSheet=doActionIBSheet;
	this.resetForm=resetForm;
	this.validateForm=validateForm;
}
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event  */
document.onclick=processButtonClick;
//Event handler processing by button name */ */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
//	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_New":
			resetForm();
			break;
		case "btn_StatusLog":
			if (sheetObjects[0].RowCount()< 1) {
				ComShowCodeMessage("BKG00249");
			}else {
				var sUrl="ESM_BKG_0979.do?pgmNo=ESM_BKG_0979&bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bkg_no")+
				"&bkg_seq="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bkg_seq");
				ComOpenWindowCenter(sUrl, "ESM_BKG_0979", 600, 280, true);
			}
			break;
		case "btn_cal1":
			var cal=new ComCalendar();
			cal.select(formObject.from_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal2":
			var cal=new ComCalendar();
			cal.select(formObject.to_dt, 'yyyy-MM-dd');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// Key insert handling
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
* @param sheetObj sheet Object
* @param sheetNo
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":
		with (sheetObj) {


		var HeadTitle1="|Sel.|Booking No.|Seq.|Send\nStatus|VVD|Shipper Name|POD|Ports|Ports|Ports|Send Date|Send ID|Received\nDate|Received\nStatus|AckRcvSts";
		var headCount=ComCountHeadTitle(HeadTitle1);

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			   {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_status",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"n1st_shpr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },

			   {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcv_status",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

		InitColumns(cols);
		SetSheetHeight(300);
		SetEditable(0);


		}
		break;
	}
}
/**
 * Sheet1 click event handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col)
{
	var iCheckRow=sheetObj.FindCheckedRow("Sel");
	var arrRow=iCheckRow.split("|");
	for(idx=0; idx < arrRow.length; idx++) {
		if (Number(arrRow[idx]) > 0 ) sheetObj.SetCellValue(Number(arrRow[idx]), "Sel",0);
	}
	sheetObj.SetCellValue(Row, "Sel",1);
}
// set IBCombo Object to comboObjects array
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
// Combo setup
function initCombo(comboObj, comboNo) {
	var cnt=0;
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "360");
			SetDropHeight(150);
			SetTitle("Stauts|Description");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt ++, "|ALL", "");
			InsertItem(cnt ++, "N|Not Sending", "N");
			InsertItem(cnt ++, "S|Send data, but not received the result from PSA", "S");
			InsertItem(cnt ++, "O|Send data, received the result from PSA", "O");
			InsertItem(cnt ++, "A|Send data, received the result from PSA, \"Accepted\"", "A");
			InsertItem(cnt ++, "E|Send data, received the result from PSA, \"Error\" or \"Rejected\"", "E");
			Code="";
	}
}
/**
 * combo status change handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboStatus_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var form=document.form;
	form.status.value=form.comboStatus.value;
}
// Sheet process handling
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //retrieve
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
//			sheetObj.RenderSheet(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0576GS.do", FormQueryString(formObj));
//				var status;
//				for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
//					status=sheetObj.GetCellValue(i, "ack_rcv_sts_cd");
//					if (status=="N" || status=="") {
//						sheetObj.SetCellValue(i, "snd_status",status);
//						}
//					else {sheetObj.SetCellValue(i, "snd_status","S");}
//					if (status=="A" || status=="E") {
//						sheetObj.SetCellValue(i, "rcv_status",status);
//					}
//					else {sheetObj.SetCellValue(i, "rcv_status","");}
//				}
//				sheetObj.RenderSheet(1);
			ComOpenWait(false);
		}
	break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	if(sheetObj.RowCount()>0){
		sheetObjects[0].RenderSheet(0);
		var status;
		for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
			status=sheetObj.GetCellValue(i, "ack_rcv_sts_cd");
			if (status=="N" || status=="") {
				sheetObj.SetCellValue(i, "snd_status",status);
				}
			else {sheetObj.SetCellValue(i, "snd_status","S");}
			if (status=="A" || status=="E") {
				sheetObj.SetCellValue(i, "rcv_status",status);
			}
			else {sheetObj.SetCellValue(i, "rcv_status","");}
		}
		sheetObj.RenderSheet(1);
	}
}
// screen Clear
function resetForm()
{
	var formObj=document.form;
	sheetObjects[0].RemoveAll();
	formObj.reset();
	comboObjects[0].SetSelectCode("");
}
/**
* handling process for input validation
* @param sheetObj sheet Object
* @param formObj  form Object
* @param sAction
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (ComIsDate(from_dt)==false || ComIsDate(to_dt)==false) {
			ComShowCodeMessage("COM132202", "Send Date");
			return false;
		}
		if (pod_cd.value.length > 0 && pod_cd.value.length < 5) {
			ComShowCodeMessage("COM132202", "POD");
			return false;
		}
		if (vvd.value.length > 0 && vvd.value.length < 9) {
			ComShowCodeMessage("COM132202", "VVD");
			return false;
		}
	}
	return true;
}
