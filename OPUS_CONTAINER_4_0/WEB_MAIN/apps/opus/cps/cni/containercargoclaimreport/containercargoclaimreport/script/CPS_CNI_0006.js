/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0006.js
*@FileTitle  : [CPS_CNI_0006] Cargo Claim Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/**
 * [CPS_CNI_0006] Status
 * 
 * @extends
 * @class Status 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0006() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
// common global variables
//IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//HTML Form
var frm=null;
var rdObjects=new Array();
var rdCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	frm=document.form;
	sheet1=sheetObjects[0];
	sheetCnt=sheetObjects.length;
	sheet1.SetWaitImageVisible(0);
	// sheet initial
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//registering initial event 
	initControl();
	//RD
	initRdConfig(rdObjects[0],"CPS_CNI_0062_01.mrd");
	if (ComGetObjValue(frm.cgo_clm_no) !=""){
		doActionIBSheet(SEARCH);
	}
}
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var frm=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn1_Retrieve":
				doActionIBSheet(SEARCH);
				break;
			case "btn1_New":
				ComResetAll();
				//ComSetObjValue(frm.area, area_cd);
				break;
			case "btn1_Print":
				viewer.print({isServerSide:true}); //인쇄 시작
				break;
		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;	
}
function setrdObject(rd_obj){
	rdObjects[rdCnt++]=rd_obj;	
}
/**
 * registering initial event 
 **/
function initControl() {
//	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
	axon_event.addListenerForm('click', 'obj_focus', frm);
}
/**
* setting sheet initial values and header
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* adding case as numbers of counting sheets
**/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
	        if (location.hostname != "") {
	        }
	        var HeadTitle1="";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	        InitColumns(cols);
			SetEditable(0);
		}//end of with
		break;
	}// end of switch
}
//focus in
function obj_activate(){
	obj=ComGetEvent();
	if (obj.getAttribute("readOnly")) return;
	ComClearSeparator(obj);
} 
// focus out
function obj_deactivate(){
	obj=ComGetEvent();
	ComChkObjValid(obj);
	if (ComIsNull(obj.value)) {
		return;
	}
}
/**
 * HTML Control KeyPress event
 **/
function obj_keypress() {
	obj=ComGetEvent();
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
   }// end of switch
}
/**
 * HTML Control KeyUp event
 **/
function obj_keyup() {
	 if ((ComGetEvent("keycode") >= 37 && ComGetEvent("keycode") <= 40)|| (ComGetEvent("keycode") == 16)) return;
	 switch (ComGetEvent("name")) {
		case "cgo_clm_no":
			ComKeyOnlyAlphabet('uppernum');
			if (frm.cgo_clm_no.value.length == 10) {
				doActionIBSheet(SEARCH);
			}
			break;
	}//end of switch
}
 /**
  * HTML Control Click event
  */
 function obj_focus() {
     switch (ComGetEvent("name")) {  
 		//Before /After 선택시
 		case "status":
 			if (frm.cgo_clm_no.value.length == 10) { 
 			    doActionIBSheet(SEARCH);
 			}else {
	 			if(frm.status[0].checked == true){
	 				initRdConfig(rdObjects[0],"CPS_CNI_0062_01.mrd");
	 			}else{
	 				initRdConfig(rdObjects[0],"CPS_CNI_0062_02.mrd");
	 			}
 			}	
 		break;
 	}
 }
// Handling Sheet's process
function doActionIBSheet(sAction) {
	frm.f_cmd.value=sAction;
	switch (sAction) {
		case SEARCH: // Retrieve
			if (validateForm(sAction)) {
				var status=ComGetObjValue(frm.status);
				var reportFileName="CPS_CNI_0062_01.mrd";
				if (status == "A"){
				   reportFileName="CPS_CNI_0062_02.mrd";	
				}
 				var sXml=sheet1.GetSearchData("CPS_CNI_0006GS.do", FormQueryString(frm) );
				var list=SheetXml2ListMap(sXml);
				if (list.length == 0) {
					ComShowCodeMessage("CNI00013");
					ComSetObjValue(frm.area_cd, "");
					viewer.openFile(RD_path+ "apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + reportFileName, "", {timeout:1800} );
					return;
				}
				var area_cd=ComGetEtcData(sXml,"AREA_CD");
				ComSetObjValue(frm.area_cd, area_cd);
				frm.f_cmd.value=PRINT;
				frm.com_mrdArguments.value="";
				frm.com_mrdTitle.value="";
				frm.com_mrdBodyTitle.value="";
				var rf="/rf [" + RDServerIP + "/CPS_CNI_0006_01.do]";
				var rpost="/rpost [" + FormQueryString(frm) + "]";
				var rpaper="/rpaper [A4]";
				if (frm.usr_area.value == "A") {
					rpaper="/rpaper [LETTER]";
				}
				var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+frm.jsession.value+"]";
				frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;
				frm.com_mrdTitle.value="Cargo Claim Report";
				frm.com_mrdBodyTitle.value="Cargo Claim Report";
			    //frm.com_mrdPath.value = "apps/opus/cps/cni/codemgt/codemgt/report/CPS_CNI_0084.mrd";
				frm.com_mrdPath.value="";
				viewer.setRData("");
				viewer.openFile(RD_path+ "apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + reportFileName, rf + " " + rv + " " + rpost + " " + rpaper, {timeout:1800} );
			}
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sAction) {
	var cgo_clm_no=ComGetObjValue(frm.cgo_clm_no);
	if (cgo_clm_no =="") {
		ComShowCodeMessage("CNI00003", "Claim No.");
//		frm.cgo_clm_no.focus();
		return false;	
	}
	return true;
}
 /**
  * 페이지에 있는 RD Object를 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 initializing 한다. <br>
  * @param {rdObject} rdObject    RD Object
  **/
	function initRdConfig(rdObject, rdFileName){
	    var Rdviewer=rdObject ;
		//Rdviewer.SetSheetHeight(440);  //CuongLe: don't know how to convert
		var rpaper="/rpaper [A4]";	
		viewer.openFile(RDServerIP + "/apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + rdFileName , rpaper, {timeout:1800} );
	} 

