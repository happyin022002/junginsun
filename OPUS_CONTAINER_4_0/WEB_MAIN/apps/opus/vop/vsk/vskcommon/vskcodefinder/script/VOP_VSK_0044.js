/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0044.js
 *@FileTitle : Vessel Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
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
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_popup_crr_cd":
			var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX";
			ComOpenPopup(sUrl, 550, 406, "returnCrrCdHelp", "0,1", true);

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


function returnCrrCdHelp(rtnObjs){
	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		if(rtnObjs.length > 0){
			formObj.crr_cd.value=rtnObjs; //vessel code
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	document.form.vsl_cd.focus();
	initControl();
}
/**
 * registering initial event 
 */
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm("focus"   , "obj_activate", formObj);
	axon_event.addListenerForm('keydown' , 'ComKeyEnter' , formObj);
	axon_event.addListenerForm('keyup'   , "VskKeyFocus" , formObj); // - 자동포커스처리
}
function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
//		event.srcElement.select();
	}
}
function obj_keyup() {
	var formObj=document.form;
	var obj=event.srcElement;
	var val=obj.value;
	switch (event.srcElement.name) {
	case "vsl_cd":
		if (val == "") {
			formObj.vsl_eng_nm.value="";
			formObj.tmp_vsl_cd.value="";
		}
		if (!obj || val == "" || ComChkLen(val, 4) != 2) {
			break;
		}
		if (formObj.tmp_vsl_cd.value != obj.value) {
			sheetObj=sheetObjects[0];
			//doActionIBSheet(sheetObj, formObj, SEARCH01);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	case "crr_cd":
		if (val == "") {
			formObj.tmp_crr_cd.value="";
		}
		if (!obj || val == "" || ComChkLen(val, 3) != 2) {
			break;
		}
		if (formObj.tmp_crr_cd.value != obj.value) {
			sheetObj=sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			obj.focus();
		}
		break;
	}
}
/**
 * Handling English of onkeypress
 */
function eng_keypress() {
	var obj=event.srcElement;
	switch(ComGetEvent("name")) {
	case "vsl_eng_nm":
		var availKeyCode="";
		if (event.keyCode ===32 // null
				|| event.keyCode ===45 // -
				|| event.keyCode ===60 // <
				|| event.keyCode ===62 // >
				|| event.keyCode ===46 // .
				|| event.keyCode ===47 // /
				|| event.keyCode ===39 // '
				|| event.keyCode ===40 // (
				|| event.keyCode ===41 // )
				|| event.keyCode ===38 // &
				|| event.keyCode ===35 // #
				) {
			availKeyCode=String(event.keyCode); 
		}
		ComKeyOnlyAlphabet('uppernum', availKeyCode);
		break;
	case "vsl_cd":
	case "call_sgn_no":
		ComKeyOnlyAlphabet("uppernum");
		break;
	case "lloyd_no":
		ComKeyOnlyAlphabet("uppernum", "46"); // upper case, numbers, .
		break;
	default:
		ComKeyOnlyAlphabet('upper');
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		
		        tabIndex=-1;
		      
		     
		      var HeadTitle="|Code|VSL Name|Carrier Code|Net Ton|Call Sign|IMO No.|Trunk/Feeder";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"crr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:080,  Align:"Right",   ColMerge:0,   SaveName:"net_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lloyd_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_div_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      resizeSheet();
		      SetEditable(0);
		      SetColProperty("fdr_div_cd", {ComboText:"Trunk|Feeder", ComboCode:"T|O"} );
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
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var rXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do",FormQueryString(formObj));
			sheetObj.LoadSearchData(rXml,{Sync:1} );
			ComOpenWait(false);
			formObj.vsl_cd.focus();
		}
		break;
	case SEARCH01:
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var tmp=formObj.vsl_eng_nm.value;
		formObj.vsl_eng_nm.value='';
		var rXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do",FormQueryString(formObj));
		ComOpenWait(false);
		var nm=ComGetEtcData(rXml, "vsl_eng_nm");
		if (nm != null) {
			formObj.vsl_eng_nm.value=nm;
			formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
			ComSetNextFocus();
		} else {
			ComShowCodeMessage('VSK00023', formObj.vsl_cd.value);
			formObj.vsl_eng_nm.value=tmp;
			formObj.vsl_cd.value=formObj.tmp_vsl_cd.value;
			formObj.vsl_cd.focus();
		}
		break;
	case SEARCH02:
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH02;
		var rXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do",FormQueryString(formObj));
		ComOpenWait(false);
		var nm=ComGetEtcData(rXml, "crr_full_nm");
		if (nm != null) {
			formObj.tmp_crr_cd.value=formObj.crr_cd.value;
			ComSetNextFocus();
		} else {
			ComShowCodeMessage('VSK00024', formObj.crr_cd.value);
			formObj.crr_cd.value=formObj.tmp_crr_cd.value;
			formObj.crr_cd.focus();
		}
		break;
	}
}


//function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
//	ComOpenWait(false);
//}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var vsl_cd=formObj.vsl_cd;
	var vsl_eng_nm=formObj.vsl_eng_nm;
	var crr_cd=formObj.crr_cd;
	with (formObj) {
		if (ComChkLen(vsl_cd, 2) == 1 && ComChkLen(vsl_eng_nm, 2) == 1
				&& ComChkLen(crr_cd, 2) == 1 && ComChkLen(call_sgn_no, 2) == 1
				&& ComChkLen(lloyd_no, 2) == 1) {
			ComShowCodeMessage('VSK00022', "2", "vessel code");
			return false;
		}
	}
	return true;
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}