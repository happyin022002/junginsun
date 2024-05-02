/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0990.js
 *@FileTitle : ESM_BKG-0990
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
			var HeadTitle1="|User ID|Office Code|B/L No.|D/O  ID|CY Operator Code|Bkg No.";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cy_opr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:false } ];
       
			InitColumns(cols);
			SetCountPosition(0);
			SetEditable(1);
			SetSheetHeight(485);
            }


		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=MULTI;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoAllSave("ESM_BKG_0466GS.do", FormQueryString(formObj));
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
		}
		break;
	case IBSEARCH: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0466GS.do", FormQueryString(formObj), {Sync:2} );
			ComOpenWait(false);
			
		}
		break;
	}
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
	if (state == "S") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
		var vIsCheck=true;
		if ( sheetObj.RowCount()==0) {
			vIsCheck=false;
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;
	case IBSEARCH:
		return true;
		break;
	}
}