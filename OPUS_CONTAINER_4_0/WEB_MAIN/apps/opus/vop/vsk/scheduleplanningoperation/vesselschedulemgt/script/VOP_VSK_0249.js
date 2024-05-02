/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0249.jsp
*@FileTitle : VSL SKD Delete Information (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
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
		case "btn_ok":
			var cause=formObj.vskd_cng_tp_cd.selectedIndex;
			switch (cause) {
			case 0:
				formObj.aft_vsl_slan_cd.value=formObj.tmp_vsl_slan_cd.value;
				break;
			case 1:
				formObj.aft_vsl_cd.value=formObj.tmp_vsl_cd.value;
				formObj.aft_skd_voy_no.value=formObj.tmp_skd_voy_no.value;
				formObj.aft_skd_dir_cd.value=formObj.tmp_skd_dir_cd.value;
				break;
			case 2:
				formObj.aft_vps_port_cd.value=formObj.tmp_vps_port_cd.value;
				break;
			}
			formObj.diff_rmk.value=formObj.vskd_cng_tp_cd[cause].text + "/" + formObj.rmk.value;
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btns_lane_search":
			if (!formObj.tmp_vsl_slan_cd.disabled) {
				openLandCdHelp(formObj, sheetObject1);
			}
			break;
		case "btns_vvd_search":
			if (!formObj.tmp_vsl_cd.disabled) {
				if (formObj.tmp_vsl_cd.value == '') {
					openVslCdHelp(formObj, sheetObject1);
				} else if (formObj.tmp_skd_voy_no.value == '') {
					openVoyNoHelp(formObj, sheetObject1);
				}
			}
			break;
		case "btns_port_search":
			if (!formObj.tmp_vps_port_cd.disabled) {
				openPortCdHelp(formObj, sheetObject1);
			}
			break;
		default:
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	obj_able(0);
	initControl();
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	if (formObj.tmp_vsl_slan_cd.value != "") {
		formObj.tmp_vsl_slan_cd.readOnly=true;
	}
	formObj.rmk.focus();
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
        	var HeadTitle="||Seq|Lane|VVD|||";
        	var headCount=ComCountHeadTitle(HeadTitle);

        	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hisflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"turn_skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"turn_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(0);
	      SetCountPosition(0);
          SetColHidden(1,1);
          SetColHidden(5,1);
          SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
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
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1") {
				sheetObj.LoadSearchData(formObj.xml.value,{Sync:1} );
			}
		break;
	case SEARCH01: // lane Retrieve
		formObj.f_cmd.value=SEARCH01;
		ComOpenWait(true);
		var sParam=FormQueryString(formObj) + "&vsl_slan_cd=" + formObj.tmp_vsl_slan_cd.value;
 		var rXml=sheetObj.GetSearchData("VOP_VSK_0249GS.do", sParam);
		ComOpenWait(false);
		var nm=ComGetEtcData(rXml, "vsl_slan_nm");
		if (nm == null) {
			ComShowCodeMessage('VSK00021', formObj.tmp_vsl_slan_cd.value);
			formObj.tmp_vsl_slan_cd.value='';
			formObj.tmp_vsl_slan_cd.focus();
		}
		break;
	case SEARCH02:
		if (formObj.tmp_vsl_cd.value != ''
				&& formObj.tmp_skd_voy_no.value != ''
				&& formObj.tmp_skd_dir_cd.value != '') {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			var sParam=FormQueryString(formObj) + "&vsl_cd="
					+ formObj.tmp_vsl_cd.value + "&skd_voy_no="
					+ formObj.tmp_skd_voy_no.value + "&skd_dir_cd="
					+ formObj.tmp_skd_dir_cd.value;
 			var rXml=sheetObj.GetSearchData("VOP_VSK_0249GS.do", sParam);
			ComOpenWait(false);
			var vvd=ComGetEtcData(rXml, "vvd");
			if (vvd == null) {
				ComShowCodeMessage('VSK00028', formObj.tmp_vsl_cd.value
						+ formObj.tmp_skd_voy_no.value
						+ formObj.tmp_skd_dir_cd.value);
				formObj.tmp_vsl_cd.value='';
				formObj.tmp_skd_voy_no.value='';
				formObj.tmp_skd_dir_cd.value='';
				formObj.tmp_vsl_cd.focus();
			}
			break;
		}
		break;
	case SEARCH03:
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH03;
		var sParam=FormQueryString(formObj) + "&vps_loc_cd=" + formObj.tmp_vps_port_cd.value;
 		var rXml=sheetObj.GetSearchData("VOP_VSK_0249GS.do", sParam);
		ComOpenWait(false);
		var nm=ComGetEtcData(rXml, "loc_nm");
		if (nm == null) {
			ComShowCodeMessage('VSK00029', formObj.tmp_vps_port_cd.value);
			formObj.tmp_vps_port_cd.value='';
			formObj.tmp_vps_port_cd.focus();
		}
		break;
	case IBSAVE:
		formObj.f_cmd.value=MULTI;
		for ( var i=0; i < sheetObj.RowCount(); i++) {
			sheetObj.SetCellValue(i + 1, 1,1);
		}
		var sParam=FormQueryString(formObj);
		if (formObj.tp.value == "1") {
			// in case VOP_VSK_0010 call, return remark to VOP_VSK_0010
			var returnParam="&vskd_tp_cd=" + formObj.vskd_tp_cd.value
					+ "&diff_rmk=" + formObj.diff_rmk.value
					+ "&vskd_cng_tp_cd=" + formObj.vskd_cng_tp_cd.value
					+ "&rmk=" + formObj.rmk.value + "&aft_vsl_slan_cd="
					+ formObj.aft_vsl_slan_cd.value + "&aft_vsl_cd="
					+ formObj.aft_vsl_cd.value + "&aft_skd_voy_no="
					+ formObj.aft_skd_voy_no.value + "&aft_skd_dir_cd="
					+ formObj.aft_skd_dir_cd.value + "&aft_vps_port_cd="
					+ formObj.aft_vps_port_cd.value
			window.returnValue=returnParam;
			ComClosePopup(); 
		} else {
			var cause=formObj.vskd_cng_tp_cd.selectedIndex;
			// in case VOP_VSK_0018, VOP_VSK_0059 call
			ComOpenWait(true);
 			var rXml=sheetObj.GetSaveData("VOP_VSK_0249GS.do", sParam + "&" + ComGetSaveString(sheetObj));
 			sheetObj.LoadSaveData(rXml);
			ComOpenWait(false);
			
			var nodeText =  ComGetSelectSingleNode(rXml, "TR-ALL")
			if(nodeText == "OK"){
				comPopupOK();
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
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListener('keypress', 'enter_keypress', 'form');
	axon_event.addListener('keyup', "VskKeyFocus", 'form');
}

/**
 * Handling English of onkeypress
 */
function enter_keypress() {
	VskKeyEnter();
}
function obj_change() {
	var formObj=document.form;
	try {
		var srcValue=ComGetEvent("value");
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "vskd_cng_tp_cd":
			obj_able(document.getElementById("vskd_cng_tp_cd").selectedIndex);
			break;
		case "tmp_vsl_slan_cd":
			if (srcValue != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
			}
			break;
		case "tmp_vsl_cd":
		case "tmp_skd_voy_no":
		case "tmp_skd_dir_cd":
			if (formObj.tmp_vsl_cd.value != ''
					&& formObj.tmp_skd_voy_no.value != ''
					&& formObj.tmp_skd_dir_cd.value != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
			}
			break;
		case "tmp_vps_port_cd":
			if (srcValue != '') {
				doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function obj_able(index) {
	var formObj=document.form;
	with (formObj) {
		tmp_vsl_slan_cd.disabled=true;
		tmp_vsl_cd.disabled=true;
		tmp_skd_voy_no.disabled=true;
		tmp_skd_dir_cd.disabled=true;
		tmp_vps_port_cd.disabled=true;
		aft_vsl_slan_cd.value="";
		aft_vsl_cd.value="";
		aft_skd_voy_no.value="";
		aft_skd_dir_cd.value="";
		aft_vps_port_cd.value="";
		aft_clpt_ind_seq.value="";
		aft_yd_cd.value="";
		aft_vps_eta_dt.value="";
		aft_vps_etb_dt.value="";
		aft_vps_etd_dt.value="";
		switch (index) {
		case 0:
			tmp_vsl_slan_cd.disabled=false;
			tmp_vsl_slan_cd.focus();
			break;
		case 1:
			tmp_vsl_cd.disabled=false;
			tmp_skd_voy_no.disabled=false;
			tmp_skd_dir_cd.disabled=false;
			tmp_vsl_cd.focus();
			break;
		case 2:
			tmp_vps_port_cd.disabled=false;
			tmp_vps_port_cd.focus();
			break;
		default:
		}
	}
}
/**
 * Open Lane Code Help
 */
function openLandCdHelp(formObj, sheetObj) {	
	var v_display="0,0";
	var laneCd=document.form.tmp_vsl_slan_cd.value;
	ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "callBackLaneCd", v_display, true);
}

function callBackLaneCd(rtnVal){

	var formObj = document.form;
	var rVal = rtnVal[0];
	if (rVal.length > 0) {		
		formObj.tmp_vsl_slan_cd.value =rVal[1];
	}
}
/**
 * Open Vessel Code Help
 */
function openVslCdHelp(formObj, sheetObj) {
	
	var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObj.tmp_vsl_cd.value;
	ComOpenPopup(sUrl, 464, 450, "returnVslCdHelp", "0,0", true);
}

function returnVslCdHelp(rtnObjs) {
	var formObj=document.form;
	if (rtnObjs) {
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if (rtnDatas.length > 0) {
				formObj.tmp_vsl_cd.value = rtnDatas[1];
			}
		}
	}
}
/**
 * Open Voyage No Help
 */
function openVoyNoHelp(formObj, sheetObj) {
	
	var sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+formObj.tmp_vsl_cd.value;
	ComOpenPopup(sUrl, 400, 400, "returnVvdHelp", "0,0", true);
}

/**
 * Handling data from VVD Code Help (Pop-Up)
 * @param rtnObjs
 * @return
 */
function returnVvdHelp(rtnObjs){
	var formObj=document.form;
	if(rtnObjs){
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.tmp_skd_voy_no.value=rtnDatas[2];
				formObj.tmp_skd_dir_cd.value=rtnDatas[3];
			}
		}
	}
}
/**
 * Open Port Code Help
 */
function openPortCdHelp(formObj, sheetObj) {
	sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.tmp_vps_port_cd.value;
	ComOpenPopup(sUrl, 422, 464, "returnPortHelp", "0,0", true);
}

/**
 * after [Port] Button Click, calling from Pop-up
 * @param rtnObjs
 * @return
 */
function returnPortHelp(rtnObjs){
	var formObj=document.form;
	if (rtnObjs) {
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if (rtnDatas.length > 0) {
				formObj.tmp_vps_port_cd.value = rtnDatas;
			}
		}
	}
}
