/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1021.js
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
			frameLayer0.sheetObjects[0].SetSelectRow(0);
			frameLayer0.sheetObjects[1].SetSelectRow(0);
			frameLayer0.sheetObjects[2].SetSelectRow(0);
			frameLayer0.sheetObjects[3].SetSelectRow(0);
			frameLayer0.sheetObjects[4].SetSelectRow(0);
			frameLayer0.sheetObjects[5].SetSelectRow(0);
			frameLayer0.sheetObjects[6].SetSelectRow(0);
			frameLayer0.sheetObjects[7].SetSelectRow(0);
			frameLayer0.sheetObjects[8].SetSelectRow(0);
			frameLayer0.sheetObjects[9].SetSelectRow(0);
			break;
		case "btn_new":
			frameLayer0.initControl();
			frameLayer0.sheetObjects[0].RemoveAll();
			frameLayer0.sheetObjects[1].RemoveAll();
			frameLayer0.sheetObjects[2].RemoveAll();
			frameLayer0.sheetObjects[3].RemoveAll();
			frameLayer0.sheetObjects[4].RemoveAll();
			frameLayer0.sheetObjects[5].RemoveAll();
			frameLayer0.sheetObjects[6].RemoveAll();
			frameLayer0.sheetObjects[7].RemoveAll();
			frameLayer0.sheetObjects[8].RemoveAll();
			frameLayer0.sheetObjects[9].RemoveAll();
			frameLayer0.sheetObjects[10].RemoveAll();
			frameLayer0.sheetObjects[11].RemoveAll();
			formObject.trade.value="";
			formObject.week.value="";
			document.form.reset();
			frameLayer0.document.form.reset();
			frameLayer0.radio_click();
			ComSetFocus(formObject.week);
			break;
		case "btn_save":
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[10], frameLayer0.document.form, IBSAVE);
			break;
		case "btn_downexcel":
			if (frameLayer0.sheetObjects[0].RowCount()> 0)
				frameLayer0.sheetObjects[0].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[2].RowCount()> 0)
				frameLayer0.sheetObjects[2].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[4].RowCount()> 0)
				frameLayer0.sheetObjects[4].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[6].RowCount()> 0)
				frameLayer0.sheetObjects[6].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[8].RowCount()> 0)
				frameLayer0.sheetObjects[8].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[1].RowCount()> 0)
				frameLayer0.sheetObjects[1].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[3].RowCount()> 0)
				frameLayer0.sheetObjects[3].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[5].RowCount()> 0)
				frameLayer0.sheetObjects[5].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[7].RowCount()> 0)
				frameLayer0.sheetObjects[7].Down2Excel({ HiddenColumn:-1});
			if (frameLayer0.sheetObjects[9].RowCount()> 0)
				frameLayer0.sheetObjects[9].Down2Excel({ HiddenColumn:-1});
			break;
		case "btn_mainretrieve":
			frameLayer0.searchVvd(document.form.searchvvd.value, document.form.searchvvd);
			break;
		case "btn_remark":
			frameLayer0.remarkPop();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert(e);
		} else {
			alert(e);
		}
	}
}
/**
 * IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet body onLoad
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * initControl
 * @return
 */
function initControl() {
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListener('keypress', 'obj_keypress', 'form');
//	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
//	axon_event.addListenerFormat('focus', 'obj_activate', document.form);
//	axon_event.addListenerForm('blur', 'obj_deactivate', document.form);  
//	axon_event.addListener('click', 'radio_click', 'tpsz', '');
	ComSetFocus(document.form.week);
}
function radio_click() {
	frameLayer0.radio_click();
}
function ComBtnEnable_frameLayer0(val) {
	ComBtnEnable(val);
}
function ComBtnDisable_frameLayer0(val) {
	ComBtnDisable(val);
}
// Axon event
function obj_deactivate() {
	var w=document.getElementById("week");
	if (ComChkObjValid(event.srcElement, false)) {
		sVal1=w.value.replace(/\/|\-|\./g, "");
		frameLayer0.document.form.week.value=sVal1;
	} else {
		sVal1=w.value.replace(/\/|\-|\./g, "");
		if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
			event.srcElement.value="";
			ComShowCodeMessage("EQR90211", "YYYYWW");
			document.form.week.focus();
			return false;
		}
	}
	return true;
}
/**
 * @return
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}
/**
 * form_keyup
 * @return
 */
function form_keyup() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
	}
}
/**
 * obj_keypress 
 * @return
 */
function obj_keypress() {
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	switch (event.srcElement.name) {
	case "week":
		ComKeyOnlyNumber(event.srcElement);
		if (keyValue == 13){
			document.form.searchvvd.value="";
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
			frameLayer0.sheetObjects[0].SetSelectRow(0);
			frameLayer0.sheetObjects[1].SetSelectRow(0);
			frameLayer0.sheetObjects[2].SetSelectRow(0);
			frameLayer0.sheetObjects[3].SetSelectRow(0);
			frameLayer0.sheetObjects[4].SetSelectRow(0);
			frameLayer0.sheetObjects[5].SetSelectRow(0);
			frameLayer0.sheetObjects[6].SetSelectRow(0);
			frameLayer0.sheetObjects[7].SetSelectRow(0);
			frameLayer0.sheetObjects[8].SetSelectRow(0);
			frameLayer0.sheetObjects[9].SetSelectRow(0);
		}
		break;
	case "searchvvd":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			frameLayer0.searchVvd(document.form.searchvvd.value, document.form.searchvvd);
		}
		break;
	default:
		document.form.searchvvd.value="";
		frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
		frameLayer0.sheetObjects[0].SetSelectRow(0);
		frameLayer0.sheetObjects[1].SetSelectRow(0);
		frameLayer0.sheetObjects[2].SetSelectRow(0);
		frameLayer0.sheetObjects[3].SetSelectRow(0);
		frameLayer0.sheetObjects[4].SetSelectRow(0);
		frameLayer0.sheetObjects[5].SetSelectRow(0);
		frameLayer0.sheetObjects[6].SetSelectRow(0);
		frameLayer0.sheetObjects[7].SetSelectRow(0);
		frameLayer0.sheetObjects[8].SetSelectRow(0);
		frameLayer0.sheetObjects[9].SetSelectRow(0);
	}
}
