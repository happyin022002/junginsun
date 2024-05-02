/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0211.jsp
*@FileTitle : VSL Voyage Check
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
var sheetObjects	= new Array();
var sheetCnt		= 0;
var bkgVVDs			= new Array();
var virVVDs			= new Array();
var bkgVirVVDs		= new Array();
var nonBkgVVDs		= new Array();
var sortFlag		= new Array();
sortFlag[0]			= 'ASC';
sortFlag[1]			= 'ASC';

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	var sheetObj	= sheetObjects[0];
	/** **************************************************** */
	var formObject	= document.form;
	try {
		var srcName	= ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_simulation":
			checkPreVoyageValidation(sheetObj);
			break;
		case "btn_close":
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
 * pre-checking for verifying validate VVD
 */
function checkPreVoyageValidation(sheetObj){
	
	// doActionIBSheet(sheetObj,formObject,IBSEARCH)
	
	var returnObj = new Object();
	
	for ( var i=1; i <= sheetObj.RowCount(); i++) {
		var vvd				= new Object(); // VVD
		vvd.vslSlanCd		= sheetObj.GetCellValue(i, "vsl_slan_cd");
		vvd.vslCd			= sheetObj.GetCellValue(i, "vsl_cd");
		vvd.skdVoyNo		= sheetObj.GetCellValue(i, "skd_voy_no");
		vvd.skdDirCd		= sheetObj.GetCellValue(i, "skd_dir_cd");
		vvd.turnSkdVoyNo	= sheetObj.GetCellValue(i, "turn_skd_voy_no");
		vvd.turnSkdDirCd	= sheetObj.GetCellValue(i, "turn_skd_dir_cd");
		
		if (sheetObj.GetCellValue(i, "bkg_status") == "Booking" && (sheetObj.GetCellValue(i, "vir_bkg_status") == "BKG" || sheetObj.GetCellValue(i, "vir_bkg_status") == "BKGNOD")) {
			bkgVirVVDs.push(vvd);
		} else if (sheetObj.GetCellValue(i, "bkg_status") == "Booking") {
			bkgVVDs.push(vvd);
		} else if (sheetObj.GetCellValue(i, "vir_bkg_status") == "BKG" || sheetObj.GetCellValue(i, "vir_bkg_status") == "BKGNOD") {
			virVVDs.push(vvd);
		} else {
			nonBkgVVDs.push(vvd);
		}
	}
	
	returnObj.bkgVVDs		= bkgVVDs;
	returnObj.bkgVirVVDs	= bkgVirVVDs;
	returnObj.virVVDs		= virVVDs;
	returnObj.nonBkgVVDs	= nonBkgVVDs;
//	window.returnValue=returnObj;
	//alert(returnObj  );
	
	if( bkgVVDs != -1 ){
		window.returnValue	= returnObj;
	}else{
		window.returnValue	= null;
	}
	
	ComPopUpReturnValue(returnObj);
//	comPopupOK();	
	
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
		
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
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
	      var HeadTitle="Seq|Lane CD|Vessel|Voyage No.|Direction|Booking Status|Start ETA||||||";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Seq",       Hidden:0, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_status",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"start_eta",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vir_bkg_status",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"update_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"turn_skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"turn_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ruse_prohi_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_skd_input_flg",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	       
	      InitColumns(cols);
	
	      SetEditable(0);
          SetColHidden("seq",1);
          SetSheetHeight(277);
      }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(1);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0211GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			var remark=ComGetEtcData(sXml, "remark");
			if (remark != "") {
				formObj.remark.value=remark;
			}
			break;
		}
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

function sheet1_OnMouseDown(sheetObj, Button, Shift, Row, Col) {
	if (Button == 1 && sheetObj.MouseRow()== 0) { // Click Header
		switch (sheetObj.MouseCol()) {
		case 4:
			sheetObj.ColumnSort("bkg_status", sortFlag[0]);
			if (sortFlag[0] == 'DESC') {
				sortFlag[0]='ASC';
			} else {
				sortFlag[0]='DESC';
			}
			break;
		default:
			sheetObj.ColumnSort("seq", sortFlag[1]);
		}
	}
}


function sheet1_OnSearchEnd(sheetObj) {
	
	var dataRows		= sheetObj.RowCount();
	var enableDelete	= true;
	
	for ( var i=sheetObj.HeaderRows(); i < dataRows + sheetObj.HeaderRows(); i++) {
		if (sheetObj.GetCellValue(i, "update_flag") == "NO") {
			sheetObj.SetRowBackColor(i,"#FFA850");// nonRemovable Booking VVD
			enableDelete=false;
		} else if (sheetObj.GetCellValue(i, "bkg_status") == "Booking") {
			sheetObj.SetRowBackColor(i,"#FFFF99");// Removable Booking VVD
		} else if (sheetObj.GetCellValue(i, "vir_bkg_status") == "BKGNOD"
			|| sheetObj.GetCellValue(i, "vir_bkg_status") == "BKG") {
			sheetObj.SetRowBackColor(i,"#FFFF99");// Booking of Virtual Port
		} else if (sheetObj.GetCellValue(i, "act_skd_input_flg") == "Y") {
			sheetObj.SetRowBackColor(i,"#FFA850");// ACTUAL SKD
			enableDelete=false;
		}
	}
	
	/** Automatic turn for pre-checking voyage **/
	//::2015-05-11:by TOP:://if(dataRows==0){
		
		//setTimeout(checkPreVoyageValidation(sheetObj), 5000);
		//$("#popiframe").css("height","10px");
		//$("#popiframe").css("width" ,"10px");
		
		//::2015-05-11:by TOP:://checkPreVoyageValidation(sheetObj);
		
	//::2015-05-11:by TOP:://}
	/********************************************/
	
	if (enableDelete) {
		ComBtnEnable("btn_simulation");
	} else {
		ComBtnDisable("btn_simulation");
	}
	
}

//function loadComplete(){
//	$("#popiframe").css("height","10px");
//	$("#popiframe").css("width" ,"10px");
//}
