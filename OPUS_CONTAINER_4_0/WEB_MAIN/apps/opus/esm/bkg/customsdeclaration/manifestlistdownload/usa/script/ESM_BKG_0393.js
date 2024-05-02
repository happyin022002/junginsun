/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0393.js
*@FileTitle  : House B/L Data Input Checklist
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer's work*/
// global variable
var tot_bkg=0;
var tot_bl=0;
var tot_mbl=0;
var tot_hbl=0;
var tot_fileno=0;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		case "btn_Print":
			doActionIBSheet(sheetObjects[0], document.form, RDPRINT);
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
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing Combo Object
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "mbl_filer":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#CCFFFD");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	}
}
/**
 * combo Change event
 */
function mbl_filer_OnChange() {
	document.form.filer.value=comboObjects[0].GetSelectCode();
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
	for (i=0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	comboObjects[0].InsertItem(0, "ALL|ALL", "ALL");
	comboObjects[0].InsertItem(1, "01|Carrier Filing NVOCC", "1");
	comboObjects[0].InsertItem(2, "02|Self-Filing NVOCC", "2");
	comboObjects[0].InsertItem(3, "03|Not Applicable", "3");
	comboObjects[0].SetSelectCode('ALL');
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.form.vvd.focus();
}
/**
 * handling in case of inserting searching condition
 */
function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	/*if ((srcName == "vvd" || srcName == "pol_cd" || srcName == "pod_cd" || srcName == "conti_cd" || srcName == "bkg_ofc_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2"&& keyValue != 9 && keyValue !=16 ) {
		ComSetNextFocus();
	}*/
}
/**
 * handling Click event
 */
function obj_click() {
	var formObject=document.form;
	var srcObj=window.event.srcElement;
	var srcName=srcObj.getAttribute("name");
	var srcVal=srcObj.getAttribute("value");
	var sheetObj=sheetObjects[0];
	if (srcName != "chk_err")
		return;
	if (srcVal == "err") {
		formObject.err_flg.value='Y';
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	} else {
		formObject.err_flg.value='N';
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
		case "sheet1": //sheet1 init
			with(sheetObj){

				if (location.hostname != "")
		    //no support[check again]CLT 				InitHostInfo(location.hostname, location.port, page_path);
					var HeadTitle1="|Seq.|Booking No.|Status|B.POL|B.POD|DEL|Filer|B/L No.|vvd|House B/L|House B/L|House B/L|House B/L|Shipper|Shipper|BKG OFC|err|hbl_no|cntr_mf_no";
					var HeadTitle2="|Seq.|Booking No.|Status|B.POL|B.POD|DEL|Filer|B/L No.|vvd|Seq.|H.B/L|File#|C/M|Type|Name|BKG OFC|||";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mbl_filer",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"hbl_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"hbl_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:"Y|N", ComboCode:"Y|N" },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"hbl_fileno_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"hbl_cm_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:"Y|N", ComboCode:"Y|N" },
					             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"shpr_tp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"shpr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"err_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hbl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

						InitColumns(cols);

						SetEditable(0);
						SetCountPosition(0);
						SetSheetHeight(420);
			}
			break;
	}
}
/**
 * handling of Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH:
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		sheetObj.DoSearch("ESM_BKG_0393GS.do", FormQueryString(formObj) );
		ComOpenWait(false);
		break;
	case IBDOWNEXCEL: // EXCEL DOWNLOAD
		if (sheetObj.RowCount()== 0) {
			ComShowCodeMessage("BKG00109");
			return;
		} else {
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		}
		break;
	case RDPRINT: //print
		if (sheetObj.RowCount()== 0) {
			ComShowCodeMessage("BKG00394");
			return;
		} else {
			rdOpen();
		}
		break;
	}
}
/**
 * handling after searching
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	if (ErrMsg == "") {
		if (sheetObj.RowCount()> 0) {
			formObj.tot_bkg.value=" BKG   [" + sheetObj.GetEtcData("tot_bkg") + "]";
			formObj.tot_bl.value=" Target B/L TTL [" + sheetObj.GetEtcData("tot_bl") + "]";
			formObj.tot_mbl_ttl.value=" M.B/L TTL [" + sheetObj.GetEtcData("tot_mbl") + "]=> " + "01 M.B/L["
					+ sheetObj.GetEtcData("tot_mbl01") + "] + " + "02 M.B/L[" + sheetObj.GetEtcData("tot_mbl02") + "] + " + "03 M.B/L["
					+ sheetObj.GetEtcData("tot_mbl03") + "]";
			formObj.tot_mbl.value=" M.B/L [" + sheetObj.GetEtcData("tot_mbl") + "]";
			formObj.tot_hbl.value=" H.B/L TTL [" + sheetObj.GetEtcData("tot_hbl") + "]";
			formObj.tot_fileno.value=" File #   [" + sheetObj.GetEtcData("tot_fileno") + "]";
			formObj.tot_hbl_etc.value=" H.B/L TTL [" + sheetObj.GetEtcData("tot_hbl_etc") + "]";
			formObj.tot_fileno_etc.value=" File #   [" + sheetObj.GetEtcData("tot_fileno_etc") + "]";
//			var redColor="#1000000";
//			var blueColor="#0000100";
	        var redColor="#FF0000";
	        var blueColor="#0000FF";

			for ( var i=2; i < sheetObj.RowCount()+ 2; i++) {
				sheetObj.SetCellFontUnderline(i, "bkg_no",1);
				if (sheetObj.GetCellValue(i, "mbl_filer") == "01") {
					if (sheetObj.GetCellValue(i, "err_flg") == "Y") {
						sheetObj.SetCellFontColor(i, "bkg_no",redColor);
						if (sheetObj.GetCellValue(i, "hbl_flg") == 'N') {
							sheetObj.SetCellFontColor(i, "hbl_flg",redColor);
						} else {
							sheetObj.SetCellFontColor(i, "hbl_flg",blueColor);
						}
						if (sheetObj.GetCellValue(i, "hbl_fileno_flg") == 'N') {
							sheetObj.SetCellFontColor(i, "hbl_fileno_flg",redColor);
						} else {
							sheetObj.SetCellFontColor(i, "hbl_fileno_flg",blueColor);
						}
						if (sheetObj.GetCellValue(i, "hbl_cm_flg") == 'N') {
							sheetObj.SetCellFontColor(i, "hbl_cm_flg",redColor);
						} else {
							sheetObj.SetCellFontColor(i, "hbl_cm_flg",blueColor);
						}
					} else {
						sheetObj.SetCellFontColor(i, "bkg_no",blueColor);
						if (sheetObj.GetCellValue(i, "hbl_flg") == "Y") {
							sheetObj.SetCellFontColor(i, "hbl_flg",blueColor);
							sheetObj.SetCellFontColor(i, "hbl_fileno_flg",blueColor);
							sheetObj.SetCellFontColor(i, "hbl_cm_flg",blueColor);
						}
					}
				} else {
					if (sheetObj.GetCellValue(i, "hbl_flg") == 'Y') {
						sheetObj.SetCellFontColor(i, "hbl_flg",redColor);
					}
					if (sheetObj.GetCellValue(i, "hbl_fileno_flg") == 'Y') {
						sheetObj.SetCellFontColor(i, "hbl_fileno_flg",redColor);
					}
				}
			} // for end
		} else {
//			formObj.tot_bkg.value = " BKG   [0]";
//			formObj.tot_bl.value = " Target B/L TTL [0]";
//			formObj.tot_mbl_ttl.value = " M.B/L TTL [0] => " + "01 M.B/L[0] + " + "02 M.B/L[0] + " + "03 M.B/L[0]";
//			formObj.tot_mbl.value = " M.B/L [0]";
//			formObj.tot_hbl.value = " H.B/L TTL [0]";
//			formObj.tot_fileno.value = " File #   [0]";
			formObj.tot_bkg.value="";
			formObj.tot_bl.value="";
			formObj.tot_mbl_ttl.value="";
			formObj.tot_mbl.value="";
			formObj.tot_hbl.value="";
			formObj.tot_fileno.value="";
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkValid(formObj))
			return false;
		return true;
		break;
	}
}
/**
 * moving into screen Booking Creation
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	if (sheetObj.ColSaveName(Col) != "bkg_no") return;
		ComBkgCall0079(sheetObj.GetCellValue(Row, "bkg_no"));
}
/**
 *  showing tool tip
 * @param sheetObj
 * @param Button direction of mouse
 * @param Shift Shift= 1, Ctrl= 2, Etc 0
 * @param X X coordinate
 * @param Y Y coordinate
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	Col=sheetObj.MouseCol();
	if (sheetObj.ColSaveName(Col) == "bkg_no") {
		sheetObj.SetMousePointer("Hand");
	} else {
		sheetObj.SetMousePointer("Default");
	}
}
/**
 * openning RD
 */
function rdOpen() {
	var formObject=document.form;
	var vvd=formObject.vvd.value;
	var polCd=formObject.pol_cd.value;
	var podCd=formObject.pod_cd.value;
	var ofcCd=formObject.bkg_ofc_cd.value;
	var repCd=formObject.ob_srep_cd.value;
	var mblFiler=formObject.filer.value;
	var totBkg=formObject.tot_bkg.value;
	var totMblTtl=formObject.tot_mbl_ttl.value;
	var totBl=formObject.tot_bl.value;
	var totMbl=formObject.tot_mbl.value;
	var totHbl=formObject.tot_hbl.value;
	var totFileno=formObject.tot_fileno.value;
	var customs=formObject.customs.value;
	var errFlg=formObject.err_flg.value;
	var param="/rp [" + vvd + "][" + polCd + "][" + podCd + "][" + ofcCd + "][" + repCd + "][" + mblFiler + "][" + totBkg
			+ "][" + totMblTtl + "][" + totBl + "][" + totMbl + "][" + totHbl + "][" + totFileno + "][" + customs + "][" + errFlg
			+ "]";
	var sXml="<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "</SHEET>";
	var rdParam=param + " /riprnmargin /rwait";
	var strPath=RD_path + "apps/opus/esm/bkg/customsdeclaration/manifestlistdownload/usa/report/ESM_BKG_0872.mrd";
	viewer.setRData(sXml);
	viewer.openFile(strPath, RDServer + rdParam,{timeout:1800});
	viewer.print({isServerSide:true});
}
/* the end of developer's work */
