/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0002.js
*@FileTitle  : [CPS_CNI_0002] Find
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/**
 * [cps_cni_0002] Find
 * @extends
 * @class business script for Find 
 */
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var combo1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * registering IBCombo Object as list
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++]=comboObj;
 }
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBox();
    //registering initial event 
    initControl();
	ComSetFocus(frm.sch_str);
}
/**
* registering initial event 
*/
function initControl() {
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
   axon_event.addListenerForm('change', 'obj_change', frm);
}
 /**
  * Combobox Initialize, Header Definition
  **/
 function initComboBox() {
 	var sXml2=frm.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	var idx=0;
 	setMultiComboBox("combo1" ,  arrXml[idx] ); //09 Area
 	idx++;
	setMultiComboBox("vt" ,  arrXml[idx] ); //4. Type of Claim class(39)
	idx++;
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                
                var HeadTitle1="Seq.|CL|Claim No.|B/L No.|CNTR No.|VVD|A|HOFC|Handler|STS|DOF|INC No.|VOC No.|DOU|Claimant|Claimant|Claim Amount|TOS|Settled Amount|Liable Party|Insurer|Insurer Ref No.|IMS No.";
                var headCount=ComCountHeadTitle(HeadTitle1);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_bl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trnk_ref_vvd_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fmal_clm_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_inci_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crm_voc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"clmt_clm_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"claimant",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clmt_locl_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cgo_clm_stl_locl_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"liable_party",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"insur_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"past_cgo_clm_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetSheetHeight(450);
                SetEditable(1);
                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
               }
                break;
        }
}
/**
 * Combobox Initialize, Header Definition 
 * @param {object} comboObj Mandatory, IBMultiCombo Object
 * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
 **/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetBackColor("#ffffff");
		comboObj.SetColAlign(0, "center");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	}
} 
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				var schStr=frm.sch_str.value;
				if (ComIsNull(schStr)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "the Data");
					ComSetFocus(frm.schStr);
					return;
				}
				sheet1.RemoveAll();//append mode paging process remove
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);			
				break;	
			case "btn1_New":
				ComResetAll();
				ComSetFocus(frm.sch_str);
				break;
			case "btn1_Main":
				var cgoClmNo = sheet1.GetCellValue(sheet1.GetSelectRow(), "cgo_clm_no");
				location.href = "CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + cgoClmNo;
				break;
			case "btn1_Print":
				if (sheet1.RowCount()<= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
		} // end switch
}
function obj_change() {
    switch (ComGetEvent("name")) {    
    case "vt":
		sheet1.RemoveAll();//append mode paging process remove
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
		break;
	}
}
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
    switch (ComGetEvent("name")) {    
		case "sch_str":
			if (!ComIsNull(frm.sch_str.value) && event.keyCode == 13) {
				sheet1.RemoveAll();//append mode paging process remove
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		comboText1=Text;
		formObj.misc_cd.value=ComGetObjValue(comboObj);
		sheet1.RemoveAll();//append mode paging process remove
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
}
	function vt_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		comboText1=Text;
		formObj.vt.value=ComGetObjValue(comboObj);
		sheet1.RemoveAll();//append mode paging process remove
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
}
	
/**
 * The function called when OnDblClick event triggered
 * Calling function in case of OnDblClick event
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmNo=sheet1.GetCellValue(row , "cgo_clm_no");
	location.href = "CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + cgoClmNo;	
}

 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
 }
  function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value=PageNo;  
	doActionIBSheet(SEARCHLIST01);
 }   
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;	
 		var sXml=sheet1.GetSearchData("CPS_CNI_0002GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Append:1 , Sync:1} );
		}
		sheet1.SetSumText(0, "TOTAL");
	} else if (sAction == PRINT) {		
		frm.f_cmd.value=PRINT;
		frm.page_no.value="";
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0061.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]"
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+frm.jsession.value+"]";
		frm.com_mrdArguments.value= rv + " " + rf + " "  + rpost +  " "  + rpaper;	
		frm.com_mrdBodyTitle.value="Find-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/claimmain/report/CPS_CNI_0061.mrd";
		popupRd(1000,600);
	} 
}
/**
* setting IBMultiComboBox
* @param {select box} combo object
* @param {xml} code , name xml
* @param {String} selected initial Code 
*/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj=null; // IBMultiComboBox
	var vArrayListData=""; 
	var vListData="";
	var vCaptionText="";
	vComboObj=getComboObject(pComboObjId);
	if (vComboObj == null || pXML == null ) {
		return;
	}
	var vArrayListData=SheetXml2ListMap(pXML);
	vComboObj.InsertItem(0, "|", "");
	for ( var idx=1; idx < vArrayListData.length+1; idx++) {
		vListData=vArrayListData[idx-1];
		if (vListData != undefined) {
			vCaptionText=vListData["code"] + "|" + vListData["name"];
			vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
		}
	}//end for
}
/**
 * return comboObject
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}
