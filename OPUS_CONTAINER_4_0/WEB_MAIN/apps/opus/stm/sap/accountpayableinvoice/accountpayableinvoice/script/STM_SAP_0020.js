/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0020.js
*@FileTitle  : CSR Approval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAP_0020 : business script for STM_SAP_0020
 */
//function stm_sap_0020() { 
//	this.processButtonClick=tprocessButtonClick;
//	this.setSheetObject=setSheetObject;
//	this.loadPage=loadPage;
//	this.initSheet=initSheet;
//	this.initControl=initControl;
//	this.doActionIBSheet=doActionIBSheet;
//	this.setTabObject=setTabObject;
//	this.validateForm=validateForm;
//}
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
    	    case "btn_new" :
    	    	formObj.reset();
    	    	sheetObjects[0].RemoveAll();
    	    	doActionIBSheet(sheetObject, formObj, COMMAND01);
    	    	break;				
			case "btn_approval":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;		
			case "btn_cancel":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;					
			case "btn_print":
				break;
			case "btns_cal":
				var cal=new ComCalendar();
				cal.select(formObj.cre_dt, 'yyyy-MM-dd');
				break;	
			case "btns_ofc":
				ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+formObj.ofc_cd.value, 500, 550,"ap_ofc_cd:ofc_cd", "0,0", true);
				break;					
			case "btns_supplier":
				//ComOpenPopupWithTarget('STM_SAP_0002.do?vndr_seq='+formObj.vndr_no.value, 900, 400,"vndr_lgl_eng_nm:vndr_lgl_eng_nm|vndr_seq:vndr_no", "0,0", true);
				ComOpenPopup('STM_SAP_0002.do?vndr_seq='+formObj.vndr_no.value, 900, 400, "setSupplier", "0,0", true, false);
				break;
			case "btns_csr":
				ComOpenPopupWithTarget('STM_SAP_0003.do?inv_no='+formObj.inv_no.value+"&ofc_cd=" + document.form.ofc_cd.value+"&inv_flg=A", 480, 550,"inv_no:inv_no", "0,0", true);
				break;	
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
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
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // OFC, DATE Setting
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
//	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    ,   formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   ,   formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress',   formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//    axon_event.addListenerFormat('keyup'           , 'obj_keyup'   ,   formObj);
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
    axon_event.addListenerForm ('change', 'obj_onchange', formObj);
//    axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');
}
//handling Axon event 2
function obj_blur(){
}
function obj_keypress(){
	switch(event.srcElement.dataformat){
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum');
		break;	
	case "int":
		//숫자 만입력하기
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "ymd":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		ComKeyOnlyNumber(ComGetEvent(), "-.");
		break;
	default:
		//common standard: recognization only number, english
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}
function obj_keyup(){
	var formObj=document.form;
	switch (ComGetEvent("name")) {
	case "ofc_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}//end of switch
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(ComGetEvent());        
} 
/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	ComAddSeparator(form.cre_dt, "ymd");
	ComChkObjValid(ComGetEvent());	
}
/**
 * initialize or check selected header information
 */ 
function obj_onchange(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	switch(ComGetEvent("name")){
		case "ofc_cd":
			var office_code=formObj.ofc_cd.value;
			formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
			break;
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
	var prefix=sheetID + "_";
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
		var HeadTitle1="||Office|CSR No|Supplier Name|Curr|Invoice Amount|Evidence|Prpd By|GL Date|Description|||||";
        var headCount=ComCountHeadTitle(HeadTitle1);
//        (headCount, 0, 0, true);
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"checkbox",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:135,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"attr_cate_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Date",      Hidden:0,  Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },  //2016.05.23 Column Enable
	               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Date",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cte_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"processing_flag", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"approval_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_inv_src_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"due_date",   	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
         
        	 InitColumns(cols);
        	 SetEditable(1);
        	 //SetSheetHeight(460);
        	 resizeSheet();
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {		
		case COMMAND01: // RETRIEVE AP OFFICE
			formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
			formObj.lgin_usr_ap_ofc.value=SapGetLoginAPOfc(sheetObj);
			var localTime=SapGetLocDate(sheetObj);
			var localStartTime=localTime.substr(0,6) + "01";
			formObj.cre_dt.value=ComGetMaskedValue(localTime, "ymd");
			break;	
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("STM_SAP_0020GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case MULTI01: // Approval
			//msgs["SAP00016"] = "Do you want to execute?";
			if (ComShowCodeConfirm("SAP00017", "approval?")) {
				formObj.f_cmd.value=MULTI01;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0020GS.do", sParam);
		    		SapOpenWait(false,true); 
					if (SAPDecideErrXmlSave(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    	} , 100);

		    	
 				
			}
		    break;
		case MULTI02: // Cancel
			if (ComShowCodeConfirm("SAP00017", "cancel?")) { 
				formObj.f_cmd.value=MULTI02;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
		    		var sXml=sheetObj.GetSaveData("STM_SAP_0020GS.do", sParam);
		    		SapOpenWait(false,true); 
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SAP00018");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);		
		    	} , 100);
			}
			 break;
	}
}
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var ofcCd=sheetObj.GetCellValue(Row, prefix + "ofc_cd");
	var invDt=sheetObj.GetCellValue(Row, prefix + "inv_dt");
	var invNo=sheetObj.GetCellValue(Row, prefix + "inv_no");
	if (ofcCd != "" && invDt != "" && invNo != "") {
		var paramVal="?ofc_cd=" + ofcCd + "&inv_dt=" + invDt + "&inv_no=" + invNo;
		ComOpenPopup('STM_SAP_0030.do' + paramVal, 1250, 700, "", "1,0,1,1,1,1,1", false, "","","","","", "yes");		
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			if(formObj.ofc_cd.value == ""){
				ComShowCodeMessage("COM12113", "Office");
				ComSetFocus(document.all.item("ofc_cd"));
				return false;
			}
			if(formObj.cre_dt.value == ""){
				ComShowCodeMessage("COM12113", "By Date");
				ComSetFocus(document.all.item("cre_dt"));
				return false;
			}
			break;
		case MULTI01: //retrieve
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			}
			break;
		case MULTI02: //Cancel
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			} else {
				var prefix = sheetObj.id + "_";

				for(var k=1; k <= sheetObj.RowCount(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						var srcCd = sheetObj.GetCellValue(k, prefix + "ap_inv_src_cd");
						if (srcCd != "Manual Invoice Entry" ) {
							ComShowCodeMessage("SAP00070");
							return false;
						}
					}
				}	
			}
			
			var prefix1 = sheetObj.id + "_";
			for(var k=1; k <= sheetObj.RowCount(); k++){
				if ("1" == sheetObj.GetCellValue(k, prefix1 + "checkbox")) {
					//ASA Close에 따른 Cancel 여부 체크(Close인 경우 Cancel 불가)		
					var inv_seq = sheetObj.GetCellValue(k, prefix1 + "inv_seq");
					var inv_no = sheetObj.GetCellValue(k, prefix1 + "inv_no");
			        var sXml = sheetObj.GetSearchData("STM_SAP_0020GS.do", "f_cmd=" + COMMAND01 + "&value0=" + inv_seq);
					
					if (SAPDecideErrXml(sheetObj, sXml)) {
						
			        } else {	
			        	if(ComGetEtcData(sXml, "value0") != "Y") { // ASA Close 상태
			        		ComShowCodeMessage("SAP00064", "[" + inv_no + "]" ); 		        		
			        		return false;
			        	}		        	
			        }
				}
			}
			break;		
	}
	return true;
}
/**
 * initialize vendor name
 */ 
function vndr_no_onchange() {
	//document.form.vndr_lgl_eng_nm.value = "";
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.vndr_no.value;
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
}
/**
 * Setting supplier by popup
 */
function setSupplier(aryPopupData) {
	document.form.vndr_no.value=aryPopupData[0][1];
	document.form.vndr_lgl_eng_nm.value=aryPopupData[0][2];
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

