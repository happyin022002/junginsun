/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0250.jsp
*@FileTitle  : Port SKD Information(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
// public variable
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
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
		switch (srcName) {
		case "btn_Close":
			ComClosePopup(); 
			break;
		case "btn_Ok":
			doActionIBSheet(sheetObj,formObj,COMMAND01);
			break;
		case "btn_Cancel":
			doActionIBSheet(sheetObj,formObj,COMMAND02);
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
	axon_event.addListenerForm('change', 'obj_change', formObj);
 }

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBCombo Object as list
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	
	comboObjects[0].SetSelectCode(formObj.vsld_wks2.value,false);
	
	if(formObj.vsld_wks2.value == ""){
		ComBtnDisable("btn_Cancel");
	}else{
		ComBtnEnable("btn_Cancel");
	}
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		      tabIndex=-1;
		        
		      var HeadTitle="|vsld_wks|skd_cng_sts_cd|";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsld_wks",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_cng_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(0);
		      SetVisible(false);
            }

		break;
	}
}

/**
	 * setting combo initial values and header 
	 * param : comboObj, comboNo
	 * adding case as numbers of counting combos 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form;
	    switch(comboObj.options.id) {
    	case "vsld_wks":
	    		with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "65");
					SetDropHeight(120);

					InsertItem(0,"1","1") ;
					InsertItem(1,"2","2") ;
					InsertItem(2,"3","3") ;
					InsertItem(3,"4","4") ;
					InsertItem(4,"5","5") ;

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
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
					sheetObj.DoSearch("VOP_VSK_9017GS.do", sParam );
				}
			}
			break;
		case COMMAND01: // Ok
			if (validateForm(sheetObj, formObj, sAction)) {
				var obj={};
				obj.vsld_wks        = comboObjects[0].GetSelectCode();
				obj.skd_cng_sts_cd  = "L";
				
				ComPopUpReturnValue(obj);
			}
			break;
		case COMMAND02: // Cancel
			var obj={};
			obj.vsld_wks        = "";
			
			if(formObj.skd_cng_sts_cd.value == "L"){
				obj.skd_cng_sts_cd  = "";
			}else{
				obj.skd_cng_sts_cd  = formObj.skd_cng_sts_cd.value;	
			}
			
			ComPopUpReturnValue(obj);
			break;			
		default:
	}
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	ComOpenWait(false);
	var i=1;
	var formObj = document.form;
	formObj.vsld_wks.value = getSheetVal(sheetObj, 1, i++);
	
	if(formObj.vsld_wks.value == ""){
		ComBtnDisable("btn_Cancel");
	}else{
		ComBtnEnable("btn_Cancel");
	}
	
}

function getSheetVal(sheetObj, row, col) {
	return sheetObj.GetCellValue(row, col) == -1 ? "" : sheetObj.GetCellValue(row, col);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(comboObjects[0].GetSelectCode() == ""){
			 ComShowCodeMessage("COM12113", "No. Of Weeks");
			return false;
		}
	}
	return true;
}
