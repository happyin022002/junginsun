/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName   : ESM_BKG_1037.jsp
 *@FileTitle  : Rail AMS History
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/09
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-1037 :  business script for ESM_BKG-1037.
 */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var comboCnt=0;
var comboObjects=new Array();
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * setting combo initial values and header
 * param : comboObj, comboId
 * adding case as numbers of counting combos
 * @param comboObj
 * @param comboId
 * @return
 */
function initCombo(comboObj, comboId) {
	var formObject=document.form
	comboObj.SetDropHeight(135);
	initComboEditable(comboObj);
}
/**
 * initComboEditable
 * @param combo
 * @return
 */
function initComboEditable(combo) {
	with (combo) {
		SetMultiSelect(0);
		SetUseEdit(0);
		SetUseAutoComplete(1);
	}
}
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Print":
			doActionIBSheet(sheetObject, document.form, SEARCH11);
			break;
		case "btn_Close":
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// initialize MultiCombo 
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	initControl();
	// set delay 0.1 sec for IBSheet error prevent
	setTimeout( function() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}, 100);
}
/**
 * registering initial event 
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	// retrieve when Combo change
	axon_event.addListenerForm('change', 'chkChange2', formObject);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
      if (location.hostname != "")
      var HeadTitle1="Seq.|C|Code|Container No.|Rail AMS File No.|Q'ty|Entry Type & Number|Entry Type & Number|Receive Date/Time|Customs|VVD|Remark|Batch|||";
      var headCount=ComCountHeadTitle(HeadTitle1);

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"c",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"code",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rail_ams_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"entry_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"entry_number",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"customs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nvocc_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"batch",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"code_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"c_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
       
      InitColumns(cols);
//      SetSheetHeight(400);
      ComResizeSheet(sheetObj);
      SetEditable(0);
            }


		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("ESM_BKG_1037GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], bl_no, "bl_no", "bl_no");
//			formObj.bl_no.Index = 0;
			if (formObj.p_bl_no.value != "") {
				bl_no.SetSelectCode(formObj.p_bl_no.value);
			} else {
				bl_no.SetSelectIndex(0);
			}
		}
		formObj.f.value= getUndefined(sheetObj.GetEtcData("f"));
		formObj.o.value= getUndefined(sheetObj.GetEtcData("o"));
		formObj.c.value= getUndefined(sheetObj.GetEtcData("c"));
		formObj.c.title= getUndefined(sheetObj.GetEtcData("c_desc"));
		formObj.vsl_nm.value= getUndefined(sheetObj.GetEtcData("vsl_nm"));
		formObj.pol.value= getUndefined(sheetObj.GetEtcData("pol"));
		formObj.pod.value= getUndefined(sheetObj.GetEtcData("pod"));
		formObj.eta.value= getUndefined(sheetObj.GetEtcData("eta"));
		formObj.del.value= getUndefined(sheetObj.GetEtcData("del"));
		formObj.hub.value= getUndefined(sheetObj.GetEtcData("hub"));
		formObj.r.value= getUndefined(sheetObj.GetEtcData("r"));
		formObj.d.value= getUndefined(sheetObj.GetEtcData("d"));
		formObj.qty.value= getUndefined(ComAddComma(sheetObj.GetEtcData("qty")));
		formObj.qty_tp.value= getUndefined(sheetObj.GetEtcData("qty_tp"));
		formObj.wgt.value= getUndefined(ComAddComma(sheetObj.GetEtcData("wgt")));
		formObj.wgt_up.value= getUndefined(sheetObj.GetEtcData("wgt_up"));
		break;
	case SEARCH11: //Print
		if (sheetObj.RowCount()== 0) {
			ComShowCodeMessage("BKG00889");
			return;
		}
		ComOpenWindowCenter("/opuscntr/ESM_BKG_5024.do", "5024", 1024, 720, false);
		break;
	}
}

function getUndefined(str){
	var returnStr = '';
	if(str != undefined && str != 'undefined'){
		returnStr = str;
	}
	return returnStr;
}

/**
 * retrieve BackEndJob result
 * @param sheetObj
 * @param sKey
 * @return
 */
function doActionValidationResult(sheetObj, sKey) {
 	var sXml=sheetObj.GetSearchData("ESM_BKG_1037GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// in case of error
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage('BKG00101');
		// retrieving sheet1, sheet2 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
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
	case IBSEARCH:
		if (!ComChkRequired(formObj))
			return false;
		break;
	case MULTI:
		if (sheetObjects[0].RowCount()== 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		if (!sheetObj.IsDataModified()) {
			ComShowCodeMessage("BKG00249"); // No Selected Row
			return false;
		}
		break;
	case IBDOWNEXCEL:
		if (sheetObjects[0].RowCount()== 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	}
	return true;
}
/**
 * after retrieve sheet1 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var vvd = document.forms[0].vvd.value;
	with (sheetObj) {
		for ( var i=1; i <= LastRow(); i++) {
			SetToolTipText(i, "code",GetCellValue(i, "code_desc"));
			SetToolTipText(i, "c",GetCellValue(i, "c_desc"));
			vvd = GetCellValue(1, "nvocc_vvd");
		}
	}
	// Consortium VVD 수정
	document.forms[0].vvd.value = vvd;
}
/**
 * ckeck inputed MultiCombo value whether added value or not 
 * @param comboObj
 * @return
 */
function bl_no_OnChange(comboObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
