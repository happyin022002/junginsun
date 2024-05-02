/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0694.js
*@FileTitle  :  DO LIST CHECK REPORT(JAPAN)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * business script for esm_bkg_0694
 */
function esm_bkg_0694() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("sheet1", "sheet2");
var sheetInits=new Array(false, false);
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				// copy VVD to local variable in case of VVD retrieve
				if (formObject.rd_flag[0].checked) {
					formObject.vsl_cd.value=formObject.vvd.value.substring(0,4);
					formObject.skd_voy_no.value=formObject.vvd.value.substring(4,8);
					formObject.skd_dir_cd.value=formObject.vvd.value.substring(8,9);
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_Downexcel":
				fnExcelSheet(sheetObject1);
				break;
			case "btn_cargo":
				fnMoveToCargoRelease(sheetObject1);
				break;
			case "btn_print":
				fnPrintSheet(sheetObject1);
				break;
			case "btn_evnt_dt":
				formObject.rd_flag[1].checked=true;
				fnSetUpUIByRdFlag();
				var cal=new ComCalendarFromTo();
				cal.select(formObject.evnt_dt_start, formObject.evnt_dt_end, 'yyyy-MM-dd');
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
	for(i=0;i<sheetNames.length;i++){
		if(sheetNames[i] == "sheet1") {
			sheetInit(i);
		}
	}
	fnSetUpUIByRdFlag();
	initControl();
}
/**
 * initializing sheet
 * @param idx
 */
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
		ComConfigSheet (sheetObjects[idx] );
		initSheet(sheetObjects[idx],idx+1);
		ComEndConfigSheet(sheetObjects[idx]);
		sheetInits[idx]=true;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
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
		case "sheet1":      // sheet1 init
			with(sheetObj){
				  (16, 0, 0, true);
				  var HeadTitle1="|No.|VVD|POD|DEL|Issue OFC|B/L No.|D/O ID|Issue Date|Consignee|Notify|Issue Pop-up|Remark(s)|BkgNo|cgo remark|evntUsrId";
				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
				  var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers=[ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);
				  var cols=[ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:200,  Align:"left",  ColMerge:1,   SaveName:"cn_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:200,  Align:"left",  ColMerge:1,   SaveName:"nf_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"do_rsn_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:135,  Align:"Center",  ColMerge:1,   SaveName:"do_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cgo_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 } ];
				  InitColumns(cols);
				  SetEditable(1);
				  //SetGetEllipsis(1);
				  //SetGetWaitImageVisible(0);
				SetCountFormat("[ SELECTDATAROW / TOTALROWS ]");
				  //SetGetSelectionMode(smSelectionList);
//		          SetSheetHeight(450);
				  resizeSheet();
		  }
			break;
		case "sheet2":      //sheet1 init
			with(sheetObj){
				  (11, 0, 0, true);
				  var HeadTitle1="VVD|POD|DEL|Issue OFC|B/L No.|D/O ID|Issue Date|Remark|Consignee|Notify|Remark for Release";
				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
				  var info={ Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				  var headers=[ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);
				  var cols=[ {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"do_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cn_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"nf_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"do_rsn_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0 } ];
				  InitColumns(cols);
				  SetEditable(0);
				  SetGetVisible(false);
				}
			break;
	}
}
/**
* Sheet process handling
* @param sheetObj
* @param formObj
* @param sAction
* @return
*/
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if (!validateForm(sheetObj,formObj,sAction)) return;
			if (formObj.rd_flag[1].checked) {
				if (!ComBkgMonthsBetweenCheck(formObj.evnt_dt_start.value, formObj.evnt_dt_end.value, 1, "-")) {
					// only less than {?msg1}-month periods allowed
					ComShowCodeMessage("BKG40013", "1");
					return;
				}
			}
			if (sheetObj.id == "sheet1") {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0694GS.do", FormQueryString(formObj) + "&page_no=1", {Append:false, Sync:1} );
				iPageNo = 1;
				ComOpenWait(false);
			}
			break;

		case IBSEARCHAPPEND: // search page
			if (!validateForm(sheetObj, formObj, IBSEARCH)) return;
			formObj.f_cmd.value = SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			if (PageNo >= 1) {
				sheetObj.DoSearch("ESM_BKG_0694GS.do", FormQueryString(formObj) + "&page_no=" + PageNo, {Append:true, Sync:1} );
			} else {
				sheetObj.DoSearch("ESM_BKG_0694GS.do", FormQueryString(formObj) + "&page_no=1", {Append:false, Sync:1} );
			}
			ComOpenWait(false);
			break;
	}
}
/**
* init control
*/
function initControl() {
	axon_event.addListenerForm('click', 'objClick', form );
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm('focus', 'objFocus', form);
//    axon_event.addListenerForm('keypress', 'objKeyPress', form);
}
/**
 * Obj click event handling
 */
function objClick() {
	var objName=event.srcElement.name;
	var formObj=document.form;
	switch(objName) {
		case "rd_flag":
			fnSetUpUIByRdFlag();
			break;
		case "vvd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "pod_cd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "rlse_sts_cd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_ofc_cd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_dt_start":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_dt_end":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
	}
}
/**
 * Obj Key Press event handling
 */
//function objKeyPress() {
//   var objName=event.srcElement.name;
//   var formObj=document.form;
//   switch(objName) {
//       case "vvd":
//	       ComKeyOnlyAlphabet('uppernum');
//           break;
//	   case "pod_cd":
//	       ComKeyOnlyAlphabet('upper');
//		   break;
//	   case "evnt_ofc_cd":
//	   	   ComKeyOnlyAlphabet('upper');
//		   break;
//	   case "evnt_dt_start":
//	   	   obj_KeyPress(event.srcElement);
//		   break;
//	   case "evnt_dt_end":
//	   	   obj_KeyPress(event.srcElement);
//		   break;
//   }
//}
/**
 * on focus event handling
 */
function objFocus() {
	var objName=event.srcElement.name;
	var formObj=document.form;
	switch(objName) {
		case "vvd":
		case "pod_cd":
		case "rlse_sts_cd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_ofc_cd":
		case "evnt_dt_start":
		case "evnt_dt_start":
		case "evnt_dt_s":
		case "evnt_dt_s":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
	}
}
/**
 * change condition status by radio button
 */
function fnSetUpUIByRdFlag() {
	var formObj=document.form;
	with(formObj) {
		if(rd_flag[0].checked == true) {
			document.getElementsByName("vvd")[0].setAttribute("required", true);
			document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
			document.getElementsByName("pod_cd")[0].setAttribute("required", true);
			document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
			document.getElementsByName("rlse_sts_cd")[0].setAttribute("required", true);
			document.getElementsByName("evnt_ofc_cd")[0].removeAttribute("required");
			document.getElementsByName("evnt_ofc_cd")[0].removeAttribute("fullfill");
			document.getElementsByName("evnt_dt_start")[0].removeAttribute("required");
			document.getElementsByName("evnt_dt_end")[0].removeAttribute("required");
		} else {
			document.getElementsByName("vvd")[0].removeAttribute("required");
			document.getElementsByName("vvd")[0].removeAttribute("fullfill");
			document.getElementsByName("pod_cd")[0].removeAttribute("required");
			document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
			document.getElementsByName("rlse_sts_cd")[0].removeAttribute("required");
			document.getElementsByName("evnt_ofc_cd")[0].setAttribute("required", true);
			document.getElementsByName("evnt_ofc_cd")[0].setAttribute("fullfill", true);
			document.getElementsByName("evnt_dt_start")[0].setAttribute("required", true);
			document.getElementsByName("evnt_dt_end")[0].setAttribute("required", true);
		}
	}
}
/**
* handling process for input validation
* @param sheetObj sheet Object
* @param formObj  form Object
* @param sAction
*/
function validateForm(sheetObj,formObj,sAction){
	var formObj=document.form;
	switch (sAction){
		case IBSEARCH:
			if(!ComChkValid(formObj)) return false;
			break;
	}
	return true;
}
/**
* Sheet1 double click event handling
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnDblClick(sheetObj, row, col) {
	var eventCol=sheetObj.ColSaveName(col);
var eventValue=sheetObj.GetCellValue(row, col);
	switch (eventCol) {
		case "cn_nm":
			ComShowMemoPad(sheetObj, row, "cn_nm", true, 200, 100, 200 );
			break;
		case "nf_nm":
			ComShowMemoPad(sheetObj, row, "nf_nm", true, 200, 100, 200 );
			break;
	}
}
/**
* Sheet1 click event handling
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnClick(sheetObj, row, col) {
	var eventCol=sheetObj.ColSaveName(col);
	var eventValue=sheetObj.GetCellValue(row, col);
	switch (eventCol) {
		case "do_rsn_rmk":
			if(eventValue == "Yes" ) {
				var condition="?";
				condition += "bkg_no="+sheetObj.GetCellValue(row, "bkg_no");
				condition += "&remark="+encodeURI(sheetObj.GetCellValue(row, "cgo_rmk"));
				condition += "&evnt_dt="+sheetObj.GetCellValue(row, "evnt_dt");
				condition += "&evnt_usr_id="+sheetObj.GetCellValue(row, "evnt_usr_id");
				result=ComOpenWindowCenter('/opuscntr/ESM_BKG_0954.do' + condition, "ESM_BKG_0954", 600, 250, true);
			}
			break;
	}
}

/**
 *  Scroll click  :Next Page handling<br>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @param {String} CondParam mandatory, Search condition
 * @param {int} PageNo mandatory, Page Number
 * @param {int} OnePageRows select, Page Count
 * @return void
 * @author
 * @version 2009.10.01
 */
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

function fnMoveToCargoRelease(sheetObj) {
	var sRowStr=sheetObj.GetSelectionRows("|");
	if (sRowStr == "0" || sRowStr == "" ) {
		// Please retrieve data first.
		ComShowCodeMessage("BKG00012");
		return ;
	}
	var sRowArr=sRowStr.split("|");
	var bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");
	if(bkgNo == "") {
		// As there is no result retrieved..
		ComShowCodeMessage("BKG00221");
		return;
	}
	if(sRowArr.length > 1){
		ComShowCodeMessage("BKG00362");
		return;
	}
	var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");
	var cntrNo=sheetObj.GetCellValue(sRowArr[0], "cntr_no");
	var goUrl="";
	var param="";
	goUrl="/opuscntr/ESM_BKG_0326_POP.do?";
	param += "&pgmNo=ESM_BKG_0326";
	param += "&bl_no=" + blNo;
	param += "&cntr_no=" + cntrNo;
	//location.href=goUrl + param;
	ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1250, 700, false);
}
/**
 * copy and print selected row
 * @param sheetObj
 * @return
 */
function fnPrintSheet(sheetObj) {
	if(sheetObj.RowCount() < 1){// no data
		ComShowCodeMessage("BKG00109");
	}else{
		sheetObj.DoPrint();
	}
	return;
	sheetInit(1);
	var prtSheet=sheetObjects[1];
	prtSheet.removeAll();
	ComOpenWait(true);
	var sRowStr=sheetObj.GetSelectionRow("|");
	if (sRowStr == "0" || sRowStr == "" ) {
		// Please retrieve data first.
		ComShowCodeMessage("BKG00012");
		ComOpenWait(false);
		return ;
	}
	var sRowArr=sRowStr.split("|");
	var bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");
	if(bkgNo == "") {
		// As there is no result retrieved..
		ComShowCodeMessage("BKG00221");
		ComOpenWait(false);
		return;
	}
	for (var idx=0; idx <sRowArr.length; idx++) {
		fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
	}
	ComOpenWait(false);
	prtSheet.DoPrint();
}
/**
 * copy and output to excel selected row
 * @param sheetObj
 * @return
 */
function fnExcelSheet(sheetObj) {
	if(sheetObj.RowCount() < 1){//no data
		ComShowCodeMessage("BKG00109");
	} else {
		sheetObj.Down2Excel({HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1});
	}
	return;
	// SHEET INIT
	sheetInit(1);
	var prtSheet=sheetObjects[1];
	prtSheet.removeAll();
	ComOpenWait(true);
	var sRowStr=sheetObj.GetSelectionRow("|");
	if (sRowStr == "0" || sRowStr == "" ) {
		// Please retrieve data first.
		ComShowCodeMessage("BKG00012");
		ComOpenWait(false);
		return ;
	}
	var sRowArr=sRowStr.split("|");
	var bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");
	if (bkgNo == "") {
		// As there is no result retrieved..
		ComShowCodeMessage("BKG00221");
		ComOpenWait(false);
		return;
	}
	for (var idx=0; idx <sRowArr.length; idx++) {
		fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
	}
	prtSheet.Down2Excel();
	ComOpenWait(false);
}
/**
 * copy row
 * @param targetObj
 * @param sourceObj
 * @param row
 * @return
 */
function fnCopyRow(targetObj, sourceObj, row) {
	var lastIdx=targetObj.LastCol();
	var newIdx=targetObj.DataInsert(-1);
	for (var idx=0; idx<= lastIdx; idx++) {
		targetObj.SetCellValue(newIdx, targetObj.ColSaveName(idx),sourceObj.GetCellValue(row, targetObj.ColSaveName(idx)),0);
	}
}
