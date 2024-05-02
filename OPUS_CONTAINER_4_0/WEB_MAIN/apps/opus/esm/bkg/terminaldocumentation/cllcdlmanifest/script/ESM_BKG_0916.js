/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0916.js
*@FileTitle  : ESM_BKG_0916
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/16
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//global variable
var sheetObjects=new Array();
var sheetCnt=0;
var saveYN="N";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;			
		case "btn_close":
			var resultCount="";
			if ( saveYN == "Y" )
			{
				resultCount="1";
			} else {
				if ( formObject.gubunValue.value == "1" )
					resultCount="1";
				else
					resultCount="0";
			}
			//alert(formObject.gubun.value);
			var opener=window.dialogArguments;
			if (!opener)
				opener=parent;
			opener.setCheckBox(formObject.rowNum.value, "916", resultCount, formObject.gubun.value);
			ComClosePopup();
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
* @param sheet_obj IBSheet Object
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
	initControl();  
}
/**
* init control
*/
function initControl() {
	// ** Date delimiter **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject);
//	axon_event.addListenerFormat('focus', 'obj_activate', formObject);
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_edi");
	ComBtnDisable("btn_loadingConfirm");
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	document.form.form1_ovr_fwrd_len.focus();
}
/**
 * handling process for KeyUp
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
	        var HeadTitle="|||||||||||||||||||";
	
	        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lodg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ovr_fwrd_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ovr_bkwd_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"ovr_port_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"ovr_sd_len",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"ovr_wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ovr_cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	               {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"cdo_temp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vent_rto",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
	         
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(314);
		}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj){
	IBS_CopyRowToForm(sheetObj, document.form, 1, "form1_");
}


/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrive
		if (validateForm(sheetObj, formObj, sAction))
		{
			formObj.f_cmd.value=SEARCH;	
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0916GS.do", FormQueryString(formObj) );			
			ComOpenWait(false);
		}
		break;
	case IBSAVE: // Save
		formObj.f_cmd.value=MULTI;	
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		IBS_CopyFormToRow(document.form, sheetObj, 1, "form1_");
		sheetObj.DoAllSave("ESM_BKG_0916GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	}	
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg != "") return;
    ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
	saveYN="Y";
	IBS_CopyRowToForm(sheetObj, document.form, 1, "form1_");
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}
/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrive
		return true;
		break;
	case IBSAVE: // Save
		return true;
		break;	
	case COMMAND01:
		// check one more check
		var vIsCheck=true;
		for(var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetRowStatus(i) == "I"||
					sheetObj.GetRowStatus(i) == "U"||
					sheetObj.GetRowStatus(i) == "D") {
				vIsCheck=false;
				break;
			}
		}
		if ( check == false && sheetObj.RowCount()== 0 )
			vIsCheck=false;
		if (!vIsCheck) {
			//ComShowCodeMessage('BKG00265','');
			if ( confirm("Do you want to save your change(s)?") )
			{
				return false;
			}
		}		
		return true;
		break;			
	}
}
/**
 * get Next data
 */
function goNext()
{
	var formObj=document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var nextSeq=formObj.currentSeq.value*1 + 1;
	// alert(sheetObjects[0].RowCount);
	if ( nextSeq*1 <= sheetObjects[0].RowCount())
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, nextSeq, "form1_");
		formObj.currentSeq.value=nextSeq;
	}
}
/**
 * get Previous data
 */
function goPrev()
{
	var formObj=document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var prevSeq=formObj.currentSeq.value*1 - 1;
	// alert(sheetObjects[0].RowCount);
	if ( prevSeq*1 >= 1)
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, prevSeq, "form1_");
		formObj.currentSeq.value=prevSeq;
	}
}
/**
 * Centigrade To Fahrenheit 
 */
function cToF()
{
	var formObj=document.form;
	var cdoTemp=formObj.form1_cdo_temp.value*1;
	var fdoTemp=(2*cdoTemp)+30;
	// var fdoTemp = (9/(5*cdoTemp))+32;
	formObj.form1_fdo_temp.value=fdoTemp;
// alert(fdoTemp);
}