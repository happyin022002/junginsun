/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  esm_bkg_0017.js
*@FileTitle  : ESM_BKG-0017
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	initControl();
	document.form.vvd_cd.focus();
}
/**
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	//axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	ComBtnDisable("btn_transmit");
	
	if (document.form.vvd_cd.value != "")
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * when inputting search condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		ComKeyOnlyNumber(event.srcElement);
	}
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
	case "t1sheet1": // sheet1 init
	    with(sheetObj){
        
		var HeadTitle1="|Seq.|CNTR No.|TP/SZ|Weight(MTN)|DESC|B/L No.|POL|POD";

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"value1",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:1,   SaveName:"value2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		 
		InitColumns(cols);
//		SetSheetHeight(260);
		ComResizeSheet(sheetObj);
		SetEditable(1);
		}


		break;
	case "t2sheet1": // t2sheet1 init
		 with(sheetObj){
	        
	      var HeadTitle1="|Seq.|Total|Deck Loc|Type/Size";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0,  Width:220,  Align:"Right",   ColMerge:1,   SaveName:"x_mt_total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:320,  Align:"Center",  ColMerge:1,   SaveName:"x_mt_loc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:340,  Align:"Center",  ColMerge:1,   SaveName:"x_mt_ts",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(430);
//        ComResizeSheet(sheetObj);
      
	      SetEditable(1);
            }


		break;
	case "t3sheet1": // t3sheet1 init
	    with(sheetObj){
       
      var HeadTitle1="|Seq.|CNTR No.|TYPE/SIZE|UN No.|IMO Class|IMO COMP GRP|Flash Point|Weight(MTN)|POL|POD";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"imdg_co_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:145,  Align:"Center",  ColMerge:1,   SaveName:"value1",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
      SetSheetHeight(430);
//      ComResizeSheet(sheetObj);
      
      SetEditable(1);
            }




		break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj 
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.vsl_cd.value=formObj.vvd_cd.value.substring(0, 4);
			formObj.skd_voy_no.value=formObj.vvd_cd.value.substring(4, 8);
			formObj.skd_dir_cd.value=formObj.vvd_cd.value.substring(8);
			
			if (formObj.error_yn_temp[0].checked) {
				formObj.error_yn.value="";
			} else {
				formObj.error_yn.value="ERROR";
			}
			// alert(formObj.error_yn.value)
			
			var sXml=sheetObj.GetSearchData("ESM_BKG_0017GS.do",FormQueryString(formObj));
			
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			}
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
			if (state == "S") {
				if (document.form.error_yn_temp[0].checked
						&& sheetObjects[0].RowCount()>= 0) {
					ComBtnEnable("btn_transmit");
				} else {
					ComBtnDisable("btn_transmit");
				}
			}
			// formObj.shp_id_no.value = sheetObj.EtcData("shp_id_no");
			ComEtcDataToForm(formObj, sheetObj);
			formObj.pnm_org_cd_temp.value=getCodeName(formObj,formObj.pnm_org_cd.value);
			formObj.pnm_dest_cd_temp.value=getCodeName(formObj,formObj.pnm_dest_cd.value);
			//ComOpenWait(false);
			
		}
		break;
	case IBSAVE: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.vsl_cd.value=formObj.vvd_cd.value.substring(0, 4);
			formObj.skd_voy_no.value=formObj.vvd_cd.value.substring(4, 8);
			formObj.skd_dir_cd.value=formObj.vvd_cd.value.substring(8);
			formObj.f_cmd.value=MULTI;
			sheetObj.SetWaitImageVisible(0);
			
			if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) return false;

			ComOpenWait(true);
			var sParam="";
			var sParamSheet2=sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			// alert("sParam"+sParam);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0017GS.do", sParam);
			
			var key=ComGetEtcData(sXml, "KEY");
			
//			ComOpenWait(true);
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');",3000);
		}
		break;
	case IBINSERT: 
		break;
	}
}

function t1sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

function t1sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

function t1sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
//	ComOpenWait(true);
//	intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');",3000);
}


/**
 * BackEndJob
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
//	sheetObjects[0].SetWaitImageVisble(0);
	var sXml=sheetObj.GetSearchData("ESM_BKG_0017GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// ending status of waiting in case of error
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// show message of success 
		ComShowCodeMessage('BKG00204');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		// ComShowMessage(ComResultMessage(sXml));
		return;
	} else if (sJbStsFlg == "FAIL") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
	
	ComOpenWait(false);
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
InsertItem( "General Cargo Info", "");
InsertItem( "Empty Container Info", "");
InsertItem( "Hazardous Cargo Info", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	beforetab=nItem;
}
/**
 * handling process for input validation
 * @param sheetObj 
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.vvd_cd.value == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		return true;
		break;
	case IBSAVE: // 
		if (formObj.error_yn_temp[0].checked) {
			ComBtnEnable("btn_transmit");
		} else {
			ComBtnDisable("btn_transmit");
			return false;
		}
		if (formObj.vvd_cd.value == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vst_no.value == "") {
			ComShowCodeMessage('BKG00116');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.mvmt_seq.value.length == "") {
			ComShowCodeMessage('BKG00117');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.pnm_vsl_opr_cd.value == "") {
			ComShowCodeMessage('BKG00118');
			formObj.vvd_cd.focus();
			return false;
		}
//		if (formObj.pnm_org_cd.value.length == "") {
//			ComShowCodeMessage('BKG00119');
//			formObj.vvd_cd.focus();
//			return false;
//		}
//		if (formObj.pnm_dest_cd.value == "") {
//			ComShowCodeMessage('BKG00120');
//			formObj.vvd_cd.focus();
//			return false;
//		}
		if (formObj.slan_cd.value.length == ""
				|| formObj.vps_eta_dt.value.length == ""
				|| formObj.pod_cd.value.length == ""
				|| formObj.pol_cd.value.length == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		return true;
		break;
	}
}
/**
 * setting name according to code
 * @param formObj formObj
 * @param Value Value
 */
function getCodeName(formObj, value) {
	var codeName="";
	switch (value) {
	case "00":
		codeName="[" + value + "]UNKNOWN";
		break;
	case "A0":
		codeName="[" + value + "]AROUND THE WORLD";
		break;
	case "A1":
		codeName="[" + value + "]EAST COAST OF THE UNITED STATES";
		break;
	case "A2":
		codeName="[" + value + "]EAST COAST OF CANADA";
		break;
	case "A3":
		codeName="[" + value + "]EAST COAST OF CENTRAL AMERICA";
		break;
	case "A4":
		codeName="[" + value + "]EAST COAST OF SOUTH AMERICA";
		break;
	case "A5":
		codeName="[" + value + "]CRISTOBAL, REPUBLIC OF PANAMA";
		break;
	case "A6":
		codeName="[" + value + "]WEST INDIES";
		break;
	case "A7":
		codeName="[" + value + "]EUROPE";
		break;
	case "A8":
		codeName="[" + value + "]AFRICA";
		break;
	case "A9":
		codeName="[" + value + "]ASIA AND THE MIDDLE EAST";
		break;
	case "P0":
		codeName="[" + value + "]AROUTE THE WORLD";
		break;
	case "P1":
		codeName="[" + value + "]WEST COAST OF THE UNITED STATES";
		break;
	case "P2":
		codeName="[" + value + "]WEST COAST OF CANADA";
		break;
	case "P3":
		codeName="[" + value + "]WEST COAST OF CENTRAL AMERICA";
		break;
	case "P4":
		codeName="[" + value + "]WEST COAST OF SOUTH AMERICA";
		break;
	case "P5":
		codeName="[" + value + "]CRISTOBAL, REPUBLIC OF PANAMA";
		break;
	case "P6":
		codeName="[" + value + "]HAWAII";
		break;
	case "P7":
		codeName="[" + value + "]OCEANIA";
		break;
	case "P8":
		codeName="[" + value + "]ANTARTICA";
		break;
	case "P9":
		codeName="[" + value + "]ASIA";
		break;
	}
	return codeName;
}
/**
 * handling transmit button according to gubun value
 * @param gubun gubun
 */
function checkTransmit(gubun) {
	if (gubun == "1")
		ComBtnEnable("btn_transmit");
	else
		ComBtnDisable("btn_transmit");
}
