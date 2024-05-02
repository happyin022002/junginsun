/*=========================================================
	 *Copyright(c) 2006 CyberLogitec
	 *@FileName :  ESM_BKG_3008.js
	 *@FileTitle : Manual Booking Number Create
	 *@author     : CLT
	 *@version    : 1.0
	 *@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_3008 : business script for ESM_BKG_3008
 */
function ESM_BKG_3008() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			// Number of BKG(s) and Agent Code is blank when retrieving 
			ComSetObjValue(formObject.no_of_bkg, '');
//			ComSetObjValue(formObject.act_chn_agn_cd, '');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;
		case "btn_create":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_down_excel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fm_cre_dt, formObject.to_cre_dt, 'yyyy-MM-dd');
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
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
	if (curPgmNo == "ESM_BKG_3008-Q") {
		ComBtnDisable("btn_create");
	}
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
}

/**
 * setting sheet initial values and header 
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
        with(sheetObj){
            if (location.hostname != "")
            	var HeadTitle1 = "Seq.|Booking Number|Prefix|Office|User ID|Creation Date|BKG Creation Date|Use";
            
        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ 
        	            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
        	            {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chn_agn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	            {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
        	            ];
			   
        	InitColumns(cols);
        	SetSheetHeight(455);
        	SetEditable(1);
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBCLEAR: 
		if (sheetObj.id == "sheet1") {
			if (sheetObj.RowCount()> 0) {
				sheetObj.RemoveAll();
			}
			formObj.reset();
			formObj.cre_ofc_cd.value=formObj.ofc_cd.value;
			formObj.cre_usr_id.value=formObj.usr_id.value;
			formObj.fm_cre_dt.value=ComGetDateAdd(null, "m", -1, "-");
			formObj.to_cre_dt.value=ComGetNowInfo("ymd", "-");
			formObj.cre_ofc_cd.focus();
		}
		break;
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_3008GS.do", FormQueryString(formObj) );
			}
		break;
	case IBSAVE: 
		if (validateForm(sheetObj, formObj, sAction)){
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveData("ESM_BKG_3008GS.do", FormQueryString(formObj));
				
				if(ComGetEtcData(sXml, "MNL_BKG_NO_OPT_CD") != undefined){
					ComShowCodeMessage("BKG43060");
					return null;
				}
				
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					
					if (sheetObj.RowCount()> 0) {
						sheetObj.RemoveAll();
					}
					sheetObj.LoadSaveData(sXml, true);
					//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} else {
					sheetObj.LoadSaveData(sXml, true);
					ComSetFocus(formObj.cre_ofc_cd);
				}
			}
		}
		break;
	case IBDOWNEXCEL: // Down Excel
		if (sheetObj.id == "sheet1") {		
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
			}
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (ComChkLen(formObj.cre_ofc_cd, 4) == 1) {
				ComShowCodeMessage("BKG00626", "B.Office");
				ComSetFocus(formObj.cre_ofc_cd);
				return false;
			}
			if (ComChkLen(formObj.fm_cre_dt, 10) != 2) {
				ComShowCodeMessage("BKG00626", "Creation Date(From)");
				ComSetFocus(formObj.fm_cre_dt);
				return false;
			}
			if (ComChkLen(formObj.to_cre_dt, 10) != 2) {
				ComShowCodeMessage("BKG00626", "Creation Date(To)");
				ComSetFocus(formObj.to_cre_dt);
				return false;
			}
		}
		else if (sAction == IBSAVE) {
			if (formObj.no_of_bkg.value < 1) {
				ComShowCodeMessage("BKG43063", "Number of BKG");
				ComSetFocus(formObj.no_of_bkg);
				return false;			
			}else if(formObj.act_chn_agn_cd.value.length < 2) {
				ComShowCodeMessage("BKG43063", "BKG No. Prefix");
				ComSetFocus(formObj.act_chn_agn_cd);
				return false;	
			}
		}
	}
	return true;
}
/**
 * select all inputed text when field focus in
 */
function obj_Focus() {
	if (window.event.srcElement.getAttribute("type") == "text") {
		window.event.srcElement.select();
	}
}
/**
 * focus move next field in case of filed inputed over maxlength ,TAB and BACK TAB block
 */

function prefixCheck(prefixObj, event){
//	if(prefixObj.value.length < 1) return;
//	var key = ('which' in event) ? event.which : event.keyCode;
//	key = String.fromCharCode( key );
//	var regex = /[0-9]|\./;
//	if( !regex.test(key) ) {
//		event.returnValue = false;
//		if(event.preventDefault) event.preventDefault();
//	}
}