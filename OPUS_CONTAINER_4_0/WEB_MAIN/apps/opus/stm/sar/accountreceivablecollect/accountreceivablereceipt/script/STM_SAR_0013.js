/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : STM_SAR_0013.js
 *@FileTitle : Receipt Cancel Information Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class stm_sar_0013 : business script for stm_sar_0013
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObj=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_Close":
				ComClosePopup(); 
				break;
			case "btn_Save":		
				if(ComIsEmpty(formObj.cancel_dt)){
					ComShowCodeMessage("COM130403", "Cancel Date");
					ComSetFocus(formObj.cancel_dt);
					break;
				}
				if(receipt_cancel_category.GetSelectText() == ""){
					ComShowCodeMessage("COM130403", "Cancel Category");
					//ComSetFocus(receipt_cancel_category);
					break;
				}
				if(receipt_cancel_reason.GetSelectText() == ""){
					ComShowCodeMessage("COM130403", "Cancel Reason");
					//ComSetFocus(receipt_cancel_reason);
					break;
				}
				sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(1, "rct_cxl_dt",ComReplaceStr(formObj.cancel_dt.value, "-", ""),0);
				sheetObj.SetCellValue(1, "rct_cxl_cate_cd",receipt_cancel_category.GetSelectCode(),0);
				sheetObj.SetCellValue(1, "rct_cxl_rsn_cd",receipt_cancel_reason.GetSelectCode(),0);
				sheetObj.SetCellValue(1, "rct_cxl_rmk",formObj.cancel_rmk.value,0);
				comPopupOK();
				break;
			case "btns_calendar": //Calendar Button
				if(formObj.btns_calendar.disabled == true) return;
	            var cal=new ComCalendar();                
	            cal.select(formObj.cancel_dt, 'yyyy-MM-dd');
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
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
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
    initControl();
 // IBMultiCombo Initialize
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var cancelCategoryComboItems=SarGetComboItems(sheetObj, "RECEIPT CANCEL CATEGORY");
	MakeComboObject(receipt_cancel_category, cancelCategoryComboItems);
	var cancelReasonComboItems=SarGetComboItems(sheetObj, "RECEIPT CANCEL REASON");
    MakeComboObject(receipt_cancel_reason, cancelReasonComboItems);
    //retrieve Local Time
	formObj.f_cmd.value=SEARCH07;
 	var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
	var cancelDt=ComGetEtcData(sXml,"lcl_time");
    formObj.f_cmd.value=SEARCH02;
 	var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
	var newEffDt=ComGetEtcData(sXml,"new_eff_dt");
	var effDt=ComReplaceStr(formObj.eff_dt.value, "-", "");
	if(effDt == newEffDt){
		ComEnableObject(formObj.cancel_dt, false);
		formObj.btns_calendar.disabled=true;
	} else {
		formObj.cancel_dt.value=ComGetMaskedValue(cancelDt, "ymd");
		ComShowCodeMessage("SAR00012");
	}
	//ComSetFocus(receipt_cancel_category);
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
}

//handling Axon event 2
function receipt_cancel_category_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
 	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
 	if(code == null && code === ""){
 		return;
 	}else{
 		var text=comboObj.GetText(code, 1);
		if (text != null && text != "" && text != formObj.receipt_cancel_category_nm.value) {
			formObj.receipt_cancel_category_nm.value=comboObj.GetText(code, 1);
		}
 	}
//	if (code != null && code != "") {
//		var text=comboObj.GetText(code, 1);
//	if (text != null && text != "" && text != formObj.receipt_cancel_category_nm.value) {
//		formObj.receipt_cancel_category_nm.value=comboObj.GetText(code, 1);
//	}
//	}
}
function receipt_cancel_reason_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
 	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
 	if(code == null && code === ""){
 		return;
 	}else{
 		var text=comboObj.GetText(code, 1);
		if (text != null && text != "" && text != formObj.receipt_cancel_reason_nm.value) {
			formObj.receipt_cancel_reason_nm.value=comboObj.GetText(code, 1);
		}
 	}
//	if (code != null && code != "") {
//		var text=comboObj.GetText(code, 1);
//		if (text != null && text != "" && text != formObj.receipt_cancel_reason_nm.value) {
//			formObj.receipt_cancel_reason_nm.value=comboObj.GetText(code, 1);
//		}
//	}
}
function MakeComboObject(cmbObj, arrStr) {
	for (var i=0; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("=");
		cmbObj.InsertItem(i, arrStr2[0] + "|" +  arrStr2[1], arrStr2[0]);			 
	}
	cmbObj.SetDropHeight(100);
}  

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|Cancel Date|Category Code|Reason Code|Cancel Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
		
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_cate_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_rsn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetSheetHeight(170);
	            }
		    break;
	}
}
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
 		case "receipt_cancel_category":
 			var i=0;
 			with (comboObj) {
 				//BackColor = "cyan";
 				SetDropHeight(200);
 				SetMultiSelect(0);
 				SetMaxSelect(1);
 				SetUseAutoComplete(1);
 			}
 			break;
 		case "receipt_cancel_reason":
 			var i=0;
 			with (comboObj) {
 				//BackColor = "cyan";
 				SetDropHeight(200);
 				SetMultiSelect(0);
 				SetMaxSelect(1);
 				SetUseAutoComplete(1);
 			}
 			break;
	}
}
