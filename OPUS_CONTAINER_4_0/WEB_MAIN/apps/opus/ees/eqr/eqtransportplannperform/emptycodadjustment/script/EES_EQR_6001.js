/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6001.js
*@FileTitle  : MTY COD Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class EES_EQR_6001 : business script for EES_EQR_6001
 */
// common static variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;

var sheetObjects=new Array();
var sheetCnt=0;

var comboObjects = new Array();
var comboCnt = 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	// var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		formObject.trade.value = "";
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if(comboObjects[0].GetSelectCode()== "ALL") {
				formObject.trade.value="";
			}else{
				formObject.trade.value=comboObjects[0].GetSelectCode();
			}
			
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
			if(frameLayer0.sheetObjects[0].RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				  return;
			}
			frameLayer0.sheetObjects[0].Down2ExcelBuffer(true);
			if (frameLayer0.sheetObjects[0].RowCount()> 0)
				frameLayer0.sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[0]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet1' });
			if (frameLayer0.sheetObjects[2].RowCount()> 0)
				frameLayer0.sheetObjects[2].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[2]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet2' });
			if (frameLayer0.sheetObjects[4].RowCount()> 0)
				frameLayer0.sheetObjects[4].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[4]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet3' });
			if (frameLayer0.sheetObjects[6].RowCount()> 0)
				frameLayer0.sheetObjects[6].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[6]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet4' });
			if (frameLayer0.sheetObjects[8].RowCount()> 0)
				frameLayer0.sheetObjects[8].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[8]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet5' });
			if (frameLayer0.sheetObjects[1].RowCount()> 0)
				frameLayer0.sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[1]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet6' });
			if (frameLayer0.sheetObjects[3].RowCount()> 0)
				frameLayer0.sheetObjects[3].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[3]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet7' });
			if (frameLayer0.sheetObjects[5].RowCount()> 0)
				frameLayer0.sheetObjects[5].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[5]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet8' });
			if (frameLayer0.sheetObjects[7].RowCount()> 0)
				frameLayer0.sheetObjects[7].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[7]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet9' });
			if (frameLayer0.sheetObjects[9].RowCount()> 0)
				frameLayer0.sheetObjects[9].Down2Excel({DownCols: makeHiddenSkipCol(frameLayer0.sheetObjects[9]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet10' });
			
			frameLayer0.sheetObjects[0].Down2ExcelBuffer(false); 
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
			ComShowCodeMessage("EQR90004");
		} else {
			alert(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initComboSearch();
	initControl();

	sheet1_OnLoadFinish(sheetObjects[0]);
}

function sheet1_OnLoadFinish(sheetObject) {
	ComOpenWait(false);
}
/**
 * initControl
 * 
 * @return
 */
function initControl() {
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListener('keypress', 'obj_keypress', 'form');
//	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); // -OnBeforeActivate이벤트
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form);  // -OnBeforeDeactivate이벤트
//	axon_event.addListener('click', 'radio_click', 'tpsz');
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
// handling deactivate event
function obj_deactivate() {
	var w=document.getElementById("week");
	if (ComChkObjValid(ComGetEvent(), false)) {
		// retrieving for each week
		sVal1=w.value.replace(/\/|\-|\./g, "");
		frameLayer0.document.form.week.value=sVal1;
	} else {
		// retrieving for each week
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
 * handling activate event
 * 
 * @return
 */
function obj_activate() {
	ComClearSeparator(ComGetEvent());
	ComSetFocus(ComGetEvent());
}
/**
 * handling form_keyup event
 * 
 * @return
 */
//function form_keyup() {
//	var obj=null;
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	if (keyValue != 13) {
//	//	ComKeyEnter('lengthnextfocus');
//	}
//}
/**
 * handling obj_keypress event
 * 
 * @return
 */
//function obj_keypress() {
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	switch (event.srcElement.name) {
//	case "week":
//		// only number + "-"
//		ComKeyOnlyNumber(event.srcElement);
//		if (keyValue == 13){
//			document.form.searchvvd.value="";
//			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
//			frameLayer0.sheetObjects[0].SetSelectRow(0);
//			frameLayer0.sheetObjects[1].SetSelectRow(0);
//			frameLayer0.sheetObjects[2].SetSelectRow(0);
//			frameLayer0.sheetObjects[3].SetSelectRow(0);
//			frameLayer0.sheetObjects[4].SetSelectRow(0);
//			frameLayer0.sheetObjects[5].SetSelectRow(0);
//			frameLayer0.sheetObjects[6].SetSelectRow(0);
//			frameLayer0.sheetObjects[7].SetSelectRow(0);
//			frameLayer0.sheetObjects[8].SetSelectRow(0);
//			frameLayer0.sheetObjects[9].SetSelectRow(0);
//		}
//		break;
//	case "searchvvd":
//		ComKeyOnlyAlphabet('uppernum');
//		if (keyValue == 13) {
//			frameLayer0.searchVvd(document.form.searchvvd.value, document.form.searchvvd);
//		}
//		break;
//	default:
//		document.form.searchvvd.value="";
//		frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
//		frameLayer0.sheetObjects[0].SetSelectRow(0);
//		frameLayer0.sheetObjects[1].SetSelectRow(0);
//		frameLayer0.sheetObjects[2].SetSelectRow(0);
//		frameLayer0.sheetObjects[3].SetSelectRow(0);
//		frameLayer0.sheetObjects[4].SetSelectRow(0);
//		frameLayer0.sheetObjects[5].SetSelectRow(0);
//		frameLayer0.sheetObjects[6].SetSelectRow(0);
//		frameLayer0.sheetObjects[7].SetSelectRow(0);
//		frameLayer0.sheetObjects[8].SetSelectRow(0);
//		frameLayer0.sheetObjects[9].SetSelectRow(0);
//	}
//}



/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	//alert("initSheet");
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":      // sheet4 init
            with(sheetObj){
            	var HeadTitle1="|Trade";
            	var headCount=ComCountHeadTitle(HeadTitle1);

            	SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"}];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:0, Width:200,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" }
                       ];
           
            	InitColumns(cols);

            	SetEditable(1);
            	SetVisible(true);
                }

			break;         	
    }
}

function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
} 

/*
 * combobox initializing
 */
function initComboSearch() {
    //data initializing
	var formObj=document.form;	
	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,"",SEARCH12,"");	
}

/**
 * add data  combo field 
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split("=");
		comboObj.InsertItem(i, comboItem[0] , comboItem[0]);		
	}   		
}

//Search criteria field data retrieval Combo
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
    switch(sAction) {
       case IBSEARCH:      // Search
			if(sComboAction == SEARCH12 ) {
				ComSetObjValue(formObj.f_cmd, SEARCH13); 
				//2.Inquiry as a query is run conditions
				var sXml=sheetObj.GetSearchData("EES_EQR_CODGS.do", FormQueryString(formObj));
				
				var comboItem;
				var comboItems;
				comboDatas=ComGetEtcData(sXml, "all_trade_cd");
		        if (comboDatas != undefined) {
		            comboItems=comboDatas.split("|");
		            comboObjects[0].SetSelectCode("-1");
		            comboObjects[0].RemoveAll();
		            addComboItem(comboObjects[0],comboItems); //TRADE
		        }
			} 
        break;
    }
    sheetObj.SetWaitImageVisible(1);
}
