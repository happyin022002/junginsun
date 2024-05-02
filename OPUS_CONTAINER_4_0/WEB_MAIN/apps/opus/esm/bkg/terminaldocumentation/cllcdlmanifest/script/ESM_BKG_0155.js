/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0155.js
*@FileTitle  : ESM_BKG_0155
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/16
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var cntrNo="";
var bkgNo="";
var cntrLodgNo="";
var vvdCd="";
var portCd="";
var gubun="";
var gubunValue="";
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.in_vvd_cd.focus();
			break;
		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_loadingConfirm":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;
		case "btn_edi":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
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
		// khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	initControl();
}
/**
 * HTML Control on the page  loaded dynamically  the event. <br>
 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects array  sequence number
 */
function initControl() {
	// ** Date Delimiter **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	// Axon Event
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - Focus Out
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - Focus In
	// Keyboard
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_edi");
	ComBtnDisable("btn_loadingConfirm");
	//alert("TEST");
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	document.form.in_vvd_cd.focus()
}
///**
// * handling  search condition  Input 
// */
//function obj_KeyUp() {
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
	        var HeadTitle="|Seq.|Sel.|CFM|CNTR|CNTR|Remark|TS||R||D||A|B|RD|Booking No.|TEU|FEU|POR|POL|POD|DEL|SOC|F/M|R/D|Net Weight|Net Weight|VGM|Unit|Seal||||||||||||||||||||";
	
	        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	               {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
	               {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
//	               {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"edi_rcv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ts_cgo_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	               {Type:"Popup",     Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg_pop",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	               {Type:"Popup",     Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg_pop",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	               {Type:"Popup",     Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg_pop",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rd_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
	               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	               {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"teu_cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"feu_cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	               {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
//	               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"11",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Int",       Hidden:0,  Width:74,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"wgt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Int",       Hidden:0,  Width:74,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"vgm_wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"grs_cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"meas_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_fwrd_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_bkwd_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_port_len",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_sd_len",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"ovr_cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cdo_temp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vent_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lodg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_count",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"bkg_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:74,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetShowButtonImage(1);
	        SetColProperty("cfm_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
	        SetColProperty("ts_cgo_cd", {ComboText:"L\tLocal|T\tTS", ComboCode:"L|T"} );
	        SetColProperty("wgt_tp_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
	        SetColProperty("vgm_wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
	        SetColProperty("edi_rcv_sts_cd", {ComboText:"M\tMerchant|C\tCarrier", ComboCode:"M|C"} );
	        SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"bl_rmk" , {AcceptKeys:"E|N|[!-?~@#$%&*()[]{};:<>/\| ]"});		
	        SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"bkg_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"teu_cntr_qty" , {AcceptKeys:"N|[.]"});		
	        SetColProperty(0 ,"feu_cntr_qty" , {AcceptKeys:"N|[.]"});		
//	        SetColProperty(0 ,"por_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
//	        SetColProperty(0 ,"pol_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
//	        SetColProperty(0 ,"pod_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
//	        SetColProperty(0 ,"del_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"por_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});	//Number is allowed for locations.	
	        SetColProperty(0 ,"pol_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"pod_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"del_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"soc_flg" , {AcceptKeys:"E" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"full_mty_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"rcv_de_term_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
	        SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});		
	        
	        SetSheetHeight(332);
	        SetCountPosition(0);
		}
		break;
	}
}
/**
 * Sheet handling process
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	// alert(sAction);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0155GS.do", FormQueryString(formObj), {Sync:2}); // 2014.08.18
			ComEtcDataToForm(formObj, sheetObj);
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
			
			if (state == "S") {
				var cntr=0;
				var bkg=0;
				var teu=0;
				var feu=0;
				var bkgNo="";
				var cntrNo="";
				for ( var i=1; i <= sheetObj.RowCount(); i++) {
					if (sheetObj.GetCellValue(i, "bkg_no") != "") {
						bkgNo=sheetObj.GetCellValue(i, "bkg_no");
						break;
					}
				}
				var first=false;
				for ( var i=1; i <= sheetObj.RowCount(); i++) {
					if (bkgNo == sheetObj.GetCellValue(i, "bkg_no")) {
						if (first == true) {
							sheetObj.SetCellValue(i, "bkg_no","",0);
							sheetObj.SetCellValue(i, "teu_cntr_qty","",0);
							sheetObj.SetCellValue(i, "feu_cntr_qty","",0);
							sheetObj.SetCellValue(i, "ibflag", "R",0);
						} else {
							first=true;
						}
					} else {
						bkgNo=sheetObj.GetCellValue(i, "bkg_no");
					}
				}
				bkgNo="";
				for ( var i=1; i <= sheetObj.RowCount(); i++) {
					if (bkgNo != sheetObj.GetCellValue(i, "bkg_no")) {
						//bkg = bkg + 1;
						bkgNo=sheetObj.GetCellValue(i, "bkg_no");
					}
					teu=teu + sheetObj.GetCellValue(i, "teu_cntr_qty") * 1;
					feu=feu + sheetObj.GetCellValue(i, "feu_cntr_qty") * 1;
				}
				if (sheetObj.RowCount()> 0){
					cntr=sheetObj.GetCellValue(1, "cntr_count") * 1;
					bkg=sheetObj.GetCellValue(1, "bkg_count") * 1;
				}
				// for ( var i = 1; i <= sheetObj.RowCount; i++) {
				// if ( cntrNo != sheetObj.CellValue(i, "cntr_no") )
				// {
				// cntr = cntr + 1;
				// cntrNo = sheetObj.CellValue(i, "cntr_no");
				// }
				// }
				//
				// alert(feu);
				formObj.cntr.value=cntr;
				formObj.bkg.value=bkg;
				formObj.teu.value=teu;
				formObj.feu.value=feu;
				formObj.cntr.value=ComGetMaskedValue(formObj.cntr.value,
						'int');
				formObj.bkg.value=ComGetMaskedValue(formObj.bkg.value, 'int');
				formObj.teu.value=ComGetMaskedValue(formObj.teu.value,
						'float');
				formObj.feu.value=ComGetMaskedValue(formObj.feu.value,
						'float');
				var rowCnt=sheetObj.RowCount();
				// alert(rowCnt);
				if (rowCnt == 0) {
					ComBtnDisable("btn_downExcel");
					ComBtnDisable("btn_edi");
					ComBtnDisable("btn_loadingConfirm");
				} else {
					ComBtnEnable("btn_downExcel");
					ComBtnEnable("btn_edi");
					ComBtnEnable("btn_loadingConfirm");
				}
			}
			ComOpenWait(false);
		}
		break;
	case IBSAVE: // Save
		if (validateForm(sheetObj, formObj, sAction)) {
//			if (sheetObj.GetSaveString() == "") return;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_0155GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;
	case IBINSERT: // Insert
		if (sheetObj.RowCount() < 1) {
			ComShowCodeMessage("BKG95057");
			return;
		}
		sheetObj.RenderSheet(0);
		var newRow = sheetObj.DataCopy();
		sheetObj.SetCellValue(newRow, "cntr_no","",0);
		sheetObj.SetCellValue(newRow, "bkg_no","",0);
		sheetObj.SetCellValue(newRow, "bkg_no2","",0);
		sheetObj.SetCellValue(newRow, "bkg_no3","",0);
		sheetObj.SetCellValue(newRow, "cntr_lodg_no","",0);
		sheetObj.RenderSheet(1);
		break;
	case IBDELETE: // Delete
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i=sheetObj.RowCount(); i >= 1; i--) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					//alert(i);
					sheetObj.SetRowHidden(i,1);
					sheetObj.SetRowStatus(i,"D");
				}
			}
		}
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel( {CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1,Merge:1,HiddenColumn:1 });//DownCols: makeHiddenSkipCol(sheetObj), 
		break;
	case COMMAND01: // Retrieve
		// alert();
		if (validateForm(sheetObj, formObj, sAction)) {
			var inListType="L";
			var inVvdCd=formObj.in_vvd_cd.value;
			var inPolCd=formObj.in_pol_cd.value;
			var sUrl="/opuscntr/ESM_BKG_0723.do?pgmNo=ESM_BKG_0723&inListType="
					+ inListType + "&inVvdCd=" + inVvdCd + "&inPolCd="
					+ inPolCd;
			// var sUrl = "/opuscntr/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// location.href=sUrl;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0723", 450, 450, true);
		}
		break;
	case COMMAND02: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			var inVvdCd=formObj.in_vvd_cd.value;
			var inPolCd=formObj.in_pol_cd.value;
			var sUrl="ESM_BKG_0617_POP.do?pgmNo=ESM_BKG_0617&isPop=Y&inVvdCd="
					+ inVvdCd + "&inPolCd=" + inPolCd;
			// alert(sUrl);
			//location.href = sUrl;
            var iWidth=1024;
            var iHeight=600;
            var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
            var sFeatures="status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
            var winObj=ComOpenWindowCenter(sUrl, "ESM_BKG_0617", 1224, 650, false);
            	//window.open("/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^" + sUrl, "", sFeatures);
            //winObj.focus();
			//ComOpenWindowCenter(sUrl, "ESM_BKG_0617", 1024, 600, true);
		}
		break;
	case COMMAND03: // Retrieve
		// alert();
		if (validateForm(sheetObj, formObj, sAction)) {
			//alert(cntrNo);
			var sUrl="/opuscntr/ESM_BKG_0915.do?pgmNo=ESM_BKG_0915&vvdCd="
					+ vvdCd + "&portCd=" + portCd + "&bkgNo="
					+ formObj.popBkgNo.value + "&cntrNo=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")
					+ "&cntrLodgNo=" + cntrLodgNo + "&rowNum="
					+ sheetObj.GetSelectRow();
			// alert(sUrl);
			rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0915", 700, 510, true);
		}
		break;
	case COMMAND04: // Retrieve
		// alert(cntrNo);
		if (validateForm(sheetObj, formObj, sAction)) {
			var sUrl = "/opuscntr/ESM_BKG_0916.do?pgmNo=ESM_BKG_0916&vvdCd="
				+ vvdCd + "&portCd=" + portCd + "&bkgNo="
				+ formObj.popBkgNo.value + "&cntrNo=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")
				+ "&cntrLodgNo=" + cntrLodgNo + "&rowNum="
				+ sheetObj.GetSelectRow() + "&gubun=" + gubun + "&gubunValue="
				+ gubunValue;
			// alert(sUrl);
			rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0916", 810, 320, true);
		}
		break;
	}
}
/**
 * Register as array  to IBTab Object adding process for list in case of needing batch processing with other items  
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Hire", "");
			InsertItem( "Other ExpB", "");
			InsertItem( "Payment Term", "");
			InsertItem( "Redelivery", "");
			InsertItem( "CP file up", "");
			InsertItem( "Certi File up", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// --------------- Importance --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case IBSAVE: // Save
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		if(sheetObj.ColValueDup("cntr_no|bkg_no3", false, false, false) > -1){
//			ComShowCodeMessage("BKG01126");
			ComShowCodeMessage("BKG03056", "Container / Booking");
			return false;
		}
		return true;
		break;
	case IBDELETE: // Delete
		var vIsCheck=false;
		// alert(sheetObj.RowCount);
		if (!ComShowCodeConfirm("COM12188")) {
			//alert();
			return false;
		}
		for ( var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		//alert(vIsCheck);
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;
	case COMMAND01: // Retrieve
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		var vIsCheck=false;
		for ( var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		if (!vIsCheck) {
			//alert("test");
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;
	case COMMAND02: // Retrieve
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND03: // Retrieve
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND04: // Retrieve
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00213');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeMessage('BKG00213');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	for ( var i=1; i <= sheetObj.RowCount(); i++) {
		sheetObj.SetCellValue(i, "bkg_no3", sheetObj.GetCellValue(i, "bkg_no2"));
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg != "0") return;    
	saveYN="Y";
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}
function sheet1_OnChange(sheetObj, row, col) {
	if (sheetObj.GetRowStatus(row) == "I") {
		sheetObj.SetCellValue(row, "bkg_no2",sheetObj.GetCellValue(row, "bkg_no"),0);
	}
	sheetObj.SetCellValue(row, "bkg_no3",sheetObj.GetCellValue(row, "bkg_no"),0);
}
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj=document.form;
	var rowCnt=sheetObj.RowCount();
	var check=sheetObj.GetCellValue(row, "rc_flg");
	var check2=sheetObj.GetCellValue(row, "dcgo_flg");
	var check3=sheetObj.GetCellValue(row, "awk_cgo_flg");
	cntrNo=sheetObj.GetCellValue(row, "cntr_no");
	//alert(cntrNo);
	formObj.popBkgNo.value=sheetObj.GetCellValue(row, "bkg_no2");
	// alert(bkgNo);
	cntrLodgNo=sheetObj.GetCellValue(row, "cntr_lodg_no");
	vvdCd=formObj.in_vvd_cd.value;
	portCd=formObj.in_pol_cd.value;
	var colSaveName=sheetObj.ColSaveName(col);
	if (colSaveName == "dcgo_flg_pop") {
		doActionIBSheet(sheetObj, formObj, COMMAND03);
	} else if (colSaveName == "rc_flg_pop" || colSaveName == "awk_cgo_flg_pop") {
		if (colSaveName == "rc_flg_pop") {
			gubun="rc_flg_pop";
			gubunValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rc_flg");
		} else {
			gubun="awk_cgo_flg_pop";
			gubunValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "awk_cgo_flg");
		}
		doActionIBSheet(sheetObj, formObj, COMMAND04);
	}
}

/**
 * Pop up when click the check box
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {
	
}
/**
 * Check box in the parent window pop-up data after treatment setting
 * @param rowNum rowNum
 * @param gubun gubun
 * @param rowCount rowCount
 * @param resultGubun resultGubun
 */
function setCheckBox(rowNum, gubun, rowCount, resultGubun) {
	//alert(rowNum);
	// alert(gubun);
	// alert(rowCount);
	if (gubun == "915") {
		//alert(gubun);
		if (rowCount != "0") {
			//alert(rowCount);
			sheetObjects[0].SetCellValue(rowNum, "dcgo_flg",1);
		} else {
			//alert(rowCount);
			sheetObjects[0].SetCellValue(rowNum, "dcgo_flg",0);
		}
	} else if (gubun == "916") {
		//alert(rowCount);
		if (rowCount != "0") {
			//alert(resultGubun);
			if (resultGubun == "rc_flg_pop")
				sheetObjects[0].SetCellValue(rowNum, "rc_flg",1);
			if (resultGubun == "awk_cgo_flg_pop")
				sheetObjects[0].SetCellValue(rowNum, "awk_cgo_flg",1);
		} else {
			//alert(resultGubun);
			if (resultGubun == "rc_flg_pop")
				sheetObjects[0].SetCellValue(rowNum, "rc_flg",0);
			if (resultGubun == "awk_cgo_flg_pop")
				sheetObjects[0].SetCellValue(rowNum, "awk_cgo_flg",0);
		}
	}
}