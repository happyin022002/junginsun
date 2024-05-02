/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0917.js
*@FileTitle  :  Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/
function esm_bkg_0917()
{
	this.processButtonClick=processButtonClick;
	this.funcChangeSearchOption=funcChangeSearchOption;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.setComboObject=setComboObject;
	this.initCombo=initCombo;
	this.cboMsgTp_OnChange=cboMsgTp_OnChange;
	this.cboTp_OnChange=cboTp_OnChange;
	this.validateForm=validateForm;
}
//public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	var sheetObject1=sheetObjects[0];
	var comboObject1=comboObjects[0];
	var comboObject2=comboObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_new":
			sheetObject1.RemoveAll();
			formObject.reset();
			funcChangSearchOption(formObject, "date");
			formObject.from_dt.value=ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
			formObject.to_dt.value=ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
			cboMsgTp.SetSelectIndex(0);
			comboObject1.SetSelectCode("5CD");
			comboObject2.SetSelectCode("D");
			break;
		case "vvd":
			funcChangSearchOption(formObject, "vvd");
			break;
		case "bl_no":
			funcChangSearchOption(formObject, "bl_no");
			break;
		case "smt_no":
			funcChangSearchOption(formObject, "smt_no");
			break;
		case "from_dt":
			funcChangSearchOption(formObject, "date");
			break;
		case "to_dt":
			funcChangSearchOption(formObject, "date");
			break;
		 case "btn_calendar1":
			var cal = new ComCalendarFromTo();
			funcChangSearchOption(formObject, "date");
			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
 * Processing change the search criteria
 * @param formObj
 * @param op
 * @return
 */
function funcChangSearchOption(formObj, op)
{
	switch(op) {
	case "date":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=true;
		formObj.vvd.className="input2";
		formObj.bl_no.className="input2";
		formObj.smt_no.className="input2";
		formObj.from_dt.className="input1";
		formObj.to_dt.className="input1";
		formObj.from_dt.disabled=false;
		formObj.to_dt.disabled=false;
		formObj.search_type[3].checked=true;
		break;
	case "vvd":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=false;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=true;
		formObj.vvd.className="input1";
		formObj.bl_no.className="input2";
		formObj.smt_no.className="input2";
		formObj.from_dt.className="input2";
		formObj.to_dt.className="input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[0].checked=true;
//		formObj.vvd.focus();
		break;
	case "bl_no":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=false;
		formObj.smt_no.disabled=true;
		formObj.vvd.className="input2";
		formObj.bl_no.className="input1";
		formObj.smt_no.className="input2";
		formObj.from_dt.className="input2";
		formObj.to_dt.className="input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[1].checked=true;
//		formObj.bl_no.focus();
		break;
	case "smt_no":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=false;
		formObj.vvd.className="input2";
		formObj.bl_no.className="input2";
		formObj.smt_no.className="input1";
		formObj.from_dt.className="input2";
		formObj.to_dt.className="input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[2].checked=true;
//		formObj.smt_no.focus();
		break;
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
	var formObject=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++) {
		initCombo(comboObjects[k],k+1);
	}
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	funcChangSearchOption(formObject, "date");
	cboMsgTp.SetSelectIndex(0);
	cboTp.SetSelectIndex(3);
	formObject.from_dt.value=ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
	formObject.to_dt.value=ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
}
/**
 * setting sheet initial values and header
 *
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":      //sheet1 init
		  with(sheetObj){
			  var HeadTitle1="|Seq.|MSG|Receive Date|VVD|POL|POD|Office|B/L No.|MRN/ Submit No.|MSG STS|MSG TEXT|User ID ";
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"msg_log_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:135,  Align:"Left",    ColMerge:1,   SaveName:"smt_amd_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"msg_sts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_text",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"user_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			  InitColumns(cols);
			  SetEditable(0);
			  SetSheetHeight(395);
			}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0917GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	}
}
//registering IBCombo Object as list
function setComboObject(combo_obj){
	  comboObjects[comboCnt++]=combo_obj;
}
/**
 * combo initialization
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch (comboObj.options.id) {
	case "cboMsgTp":
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "300");
			SetDropHeight(400);
			SetClass="input2";
			// no support[check again]CLT ShowCol=0;
			SetTitle("Type|Description");
			SetMultiSelect(0);
			SetMaxSelect(1);
			InsertItem(cnt++, "5CG|수출 적하목록 정정 (CUSMOD)", "5CG");
			InsertItem(cnt++, "5LI|수입 적하목록 정정 (IFTMOD)", "5LI");
			InsertItem(cnt++, "5LK|하선 신고 정정     (CUSDMR)", "5LK");
			Code = "5CG";
		}
		break;
	case "cboTp":
		with (comboObj) {

			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "100");
			SetDropHeight(400);
			// no support[check again]CLT ShowCol=0;
			SetTitle("Type|Description");
			SetMultiSelect(0);
			SetMaxSelect(1);
			InsertItem(cnt++, "A|미주 LOCAL", "A");
			InsertItem(cnt++, "B|아/구주 LOCAL", "B");
			InsertItem(cnt++, "C|T/S", "C");
			InsertItem(cnt++, "D|A+B+C", "D");
			Code = "D";
		}
		break;
	}
}
/**
 * MSG combo changing process
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboMsgTp_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode)  {
	document.form.msg_log_tp_id.value=NewCode;
}
/**
 * Type combo changing process
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboTp_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	document.form.tp_cd.value=NewCode;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}
