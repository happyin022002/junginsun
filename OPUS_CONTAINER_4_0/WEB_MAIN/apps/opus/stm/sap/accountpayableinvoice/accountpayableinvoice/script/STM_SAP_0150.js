/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0150.js
*@FileTitle  : AP Cost Accrual Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/10
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAP_0150 : business script for STM_SAP_0150
 */
//function stm_sap_0150() { 
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
			case "btn_accrual_if":
				doActionIBSheet(sheetObjects[0], formObj, MULTI01);
				break;
			case "btn_if_cancel":
				doActionIBSheet(sheetObjects[0], formObj, MULTI02);
				break;
			case "btn_print":
				break;
			case "btn_downexcel":
				var sheetID=sheetObject.id;
				var prefix=sheetID + "_";
    	    	if(sheetObject.RowCount() < 1) {//no data
    	    		ComShowCodeMessage("COM132501");
    	    	}else{
    	    		//var oldRow=sheetObject.GetSelectRow();
    	    		sheetObjects[1].RemoveAll();
//    	    		for(var i=1; i <= sheetObject.RowCount(); i++){
//            			if(selchk == "1") {
//            				var rowJson = sheetObject.GetRowJson(i);
//            				//var strJson = JSON.stringify(rowJson);
//            				//var cRowJson = strJson.replace(/sheet1_/gi,"sheet2_").replace(/\\/gi,"").replace(/\\n/gi,"").replace(/ /gi,"");
//            				var nRowJson = JSON.stringify(eval("(" + cRowJson + ")")); 
//            				var copiedIdx = sheetObjects[1].DataInsert(-1);
//            				sheetObjects[1].SetRowJson(copiedIdx, nRowJson);
//            			}
//            		}
    	    		var strXml = ComPriSheet2Xml(sheetObjects[0], "",prefix+"checkbox","1");
    	    		sheetObjects[1].LoadSearchData(strXml.replace(/sheet1_/gi,"sheet2_")); 
    	    	}
    	    	break;
			case "btns_calInvFr":
				var cal=new ComCalendar();
				cal.select(form.inv_date_from, 'yyyy-MM-dd');
				break;					
			case "btns_calInvTo":
				var cal=new ComCalendar();
				cal.select(form.inv_date_to, 'yyyy-MM-dd');
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
	var obj=ComGetEvent();
	switch(ComGetEvent("name")){ 	    	
   		case "inv_date_from":
   			ComAddSeparator(form.inv_date_from, "ymd");
   			ComChkObjValid(ComGetEvent());
   			break;
   		case "inv_date_to":
   			ComAddSeparator(form.inv_date_to, "ymd");
   			ComChkObjValid(ComGetEvent());		
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
		var HeadTitle1="|Invoice ID|Chk|CSR No|Supplier No|Supplier Name|Curr|Invoice Amount|Invoice Date|Invoice Type|Accrual Account|Exchange Rate|Office|GL Date|Line No|Line Type|Line Amount|Line Functional Amount|Line COA|Supplier Inv No|Supplier Inv Date|Location|Activity Date|Activity Place|Service Lane|Line Description|Estimate I/F Flag|Accrual I/F Flag";
        var headCount=ComCountHeadTitle(HeadTitle1);
//        (headCount, 0, 0, true);
        SetConfig( { SearchMode:2, MergeSheet:2, Page:10000, DataRowMerge:0, DragMode:-1, DragCell:0 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                   {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  	               {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"checkbox",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_tp_lu_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"accrual_acct_cd",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gl_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"line_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"line_tp_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dtrb_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dtrb_func_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dtrb_coa",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_inv_date",    KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"location_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"activity_date",    KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"activity_place",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"service_lane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dtrb_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"interface_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accrual_if_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
         
        	 InitColumns(cols);
        	 SetEditable(1);
        	 SetSelectionMode(0);
        	 //SetSheetHeight(460);
        	 resizeSheet();
		}
		break;
	case 2: //sheet2 init
		with (sheetObj) {
		var HeadTitle1="|Invoice ID|Chk|CSR No|Supplier No|Supplier Name|Curr|Invoice Amount|Invoice Date|Invoice Type|Accrual Account|Exchange Rate|Office|GL Date|Line No|Line Type|Line Amount|Line Functional Amount|Line COA|Supplier Inv No|Supplier Inv Date|Location|Activity Date|Activity Place|Service Lane|Line Description|Estimate I/F Flag|Accrual I/F Flag";
        var headCount=ComCountHeadTitle(HeadTitle1);
//        (headCount, 0, 0, true);
        SetConfig( { SearchMode:2, MergeSheet:2, Page:10000, DataRowMerge:0, DragMode:-1, DragCell:0 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                   {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  	               {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"checkbox",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_tp_lu_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"accrual_acct_cd",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gl_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"line_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"line_tp_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dtrb_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dtrb_func_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dtrb_coa",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_inv_date",    KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"location_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"activity_date",    KeyField:0,   CalcLogic:"",   Format:"Ymd",   						UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"activity_place",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"service_lane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dtrb_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"interface_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accrual_if_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
         
        	 InitColumns(cols);
        	 SetEditable(1);
        	 SetSelectionMode(0);
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
			var localTime=SapGetLocDate(sheetObj);
			var localStartTime=localTime.substr(0,6) + "01";
			formObj.inv_date_from.value=ComGetMaskedValue(localStartTime, "ymd");				
			formObj.inv_date_to.value=ComGetMaskedValue(localTime, "ymd");
			break;	
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			//alert(FormQueryString(formObj));
			//return;
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("STM_SAP_0150GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case MULTI01: // Accural I/F
			//msgs["SAP00016"] = "Do you want to execute?";
			if (ComShowCodeConfirm("SAP00017", "Aaccural I/F?")) {
				formObj.f_cmd.value=MULTI01;
				
				var sParam1="";
				var csrno="";
				for(k=1; k <= sheetObj.LastRow(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						if (csrno != sheetObj.GetCellValue(k, prefix + "inv_no")){
							sParam1 += sheetObj.RowSaveStr(k) + "&" ;
							csrno = sheetObj.GetCellValue(k, prefix + "inv_no");
						}
					}
				}
				
				var sParam=sParam1 + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				ComOpenWait(true);
				setTimeout( function () {
					var sXml=sheetObj.GetSaveData("STM_SAP_0150GS.do", sParam);
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
		case MULTI02: // Accural I/F Cancel
			//msgs["SAP00016"] = "Do you want to execute?";
			if (ComShowCodeConfirm("SAP00017", "Aaccural I/F Delete?")) {
				formObj.f_cmd.value=MULTI02;
				
				var sParam1="";
				var csrno="";
				for(k=1; k <= sheetObj.LastRow(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						if (csrno != sheetObj.GetCellValue(k, prefix + "inv_no")){
							sParam1 += sheetObj.RowSaveStr(k) + "&" ;
							csrno = sheetObj.GetCellValue(k, prefix + "inv_no");
						}
					}
				}
				
				var sParam=sParam1 + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				ComOpenWait(true);
				setTimeout( function () {
					var sXml=sheetObj.GetSaveData("STM_SAP_0150GS.do", sParam);
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

/**
 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 */	
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	//if (Value == "") return;
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var formObj=document.form;
    with (sheetObj) {
        switch (ColSaveName(Col)) {
        	case prefix + "checkbox":    // Check Box
        		var mergeKey1 = sheetObj.GetCellValue(Row, prefix + "inv_seq");
        		for(var i = Row + 1; i <= sheetObj.RowCount(); i++){
        			var mergeKey2 = sheetObj.GetCellValue(i, prefix + "inv_seq");
        			if(mergeKey1 == mergeKey2) sheetObj.SetCellValue(i, Col, Value, 0);
        		}
            	break;
        }
    }
}

/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */	
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	// button control
	if (sheetObj.RowCount()> 0 ) {
		//alert(ComGetObjValue(accrual_if_flag));
		if (ComGetObjValue(formObj.accrual_if_flag) == "Y") {
			ComBtnDisable("btn_accrual_if");
			ComBtnEnable("btn_if_cancel");
		} else {
			ComBtnEnable("btn_accrual_if");
			ComBtnDisable("btn_if_cancel");
		}
	}
	// INTERFACE_FLAG = "Y" : Disable	
	var sheetID=sheetObj.id;
	var prefix=sheetID + "_";
	var interfaceFlg="";
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++) {
		interfaceFlg=sheetObj.GetCellValue(i, prefix + "interface_flag");
		accrualIFFlg=sheetObj.GetCellValue(i, prefix + "accrual_if_flag");
		if (ComGetObjValue(formObj.accrual_if_flag) == "Y") {
			if(accrualIFFlg == "Y") {
				sheetObj.SetRowEditable(i,0);
			} else {
				sheetObj.SetRowEditable(i,1);
			}
		} else {
			if(interfaceFlg == "Y") {
				sheetObj.SetRowEditable(i,0);
			} else {
				sheetObj.SetRowEditable(i,1);
			}		
		}
	}
}

/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */	
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	if (sheetObj.RowCount() < 1) {//no data
		ComShowCodeMessage("COM132501");
	} else {
		sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1,Merge:1});
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
			if(formObj.inv_date_from.value == ""){
				ComShowCodeMessage("COM12113", "From Invoice Date");
				ComSetFocus(document.all.item("inv_date_from"));
				return false;
			}
			if(formObj.inv_date_to.value == ""){
				ComShowCodeMessage("COM12113", "To Invoice Date");
				ComSetFocus(document.all.item("inv_date_to"));
				return false;
			}
			break;
		case MULTI01: //retrieve
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			}
			break;
		case MULTI02: //retrieve
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SAP00036");
				return false;
			}
			break;
		
	}
	return true;
}
/**
 * initialize vendor name
 */ 
/*function vndr_no_onchange() {
	//document.form.vndr_lgl_eng_nm.value = "";
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.vndr_no.value;
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
}*/
/**
 * initialize or check selected header information
 */ 
function obj_onchange(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	switch(ComGetEvent("name")){
		case "vndr_no":
			var vndr_no=formObj.vndr_no.value;
			formObj.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
	    	break;
			
		case "ofc_cd":
			var office_code=formObj.ofc_cd.value;
			formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
			break;
	}
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
    ComResizeSheet(sheetObjects[1]);
}
/**
 * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
 * saveColName 파라미터를 이용하여 원하는 컬럼을 지정할수 있고, <br>
 * sCol, sValue 파라미터를 이용하여 원하는 행의 조건을 줄수 있다.(필터링) <br>
 * saveColName의 값이 없으면 전체 컬럼을 대상으로 진행되고, <br>
 * sCol, sValue 값이 없으면 전체 행을 대상으로 진행된다. <br>
 * Sheet의 전체 데이터에 대해 스캔이 이루어지므로, 데이터양이 너무 많을 경우 속도가 저하될수 있음에 유의한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     sXml = ComPriSheet2Xml(sheetObj);
 *     sXml = ComPriSheet2Xml(sheetObj, "col1|col2|col3|col4");
 *     sXml = ComPriSheet2Xml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
 * </pre>
 * @param {ibsheet} sheetObj    필수,IBSheet Object
 * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
 *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
 * @param {string}  sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
 *                              지정하지 않으면, 전체 행을 대상으로 한다.
 * @param {string}  sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
 *                              지정하지 않으면, 전체 행을 대상으로 한다.
 * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
 * @param {bool}    bIsStyled   선택, 열과 행의 색상 Editable정보 포함 여부, default=false. ComPriSheet2StyledXml 참조
 * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
 * @author 박성수
 * @version 2009.05.07
 */
function ComPriSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel, bIsStyled)  {
    try {
        if ((!sheetObj) || (!sheetObj.IBSheetVersion))  return "";
        var allXml="";
        var sColSep="☜☞";
        var allRows=false;
        var arrPrcdRow=new Array();
        if (saveColName == undefined || saveColName == null || saveColName == "") {
            saveColName=IBS_ConcatSaveName(sheetObj);
        }
        var arrCol=saveColName.split("|");
        var condNames=new Array();
        var condValues=new Array();
        if (sCol == undefined || sCol == null || sCol == "" || sValue == undefined || sValue == null || sValue == "") {
            allRows=true;
        } else {
            condNames=sCol.split("|");
            condValues=sValue.split("|");
        }
        var aryTR=new Array();
        var aryTD=new Array(arrCol.length);
        if (sheetObj.RowCount()> 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
                var isMatch=true;
                if (!allRows) {
                    for (var j=0; j < condNames.length; j++) {
                        isMatch=true;
                        if (sheetObj.GetCellValue(i, condNames[j]) != condValues[j]) {
                            isMatch=false;
                            break;
                        }
                    }
                }
                
                if (!isMatch)  continue;

                if (bIsStyled) {
                    var sheetFontColor=sheetObj.GetDataFontColor();
                    var sheetBackColor=sheetObj.GetDataBackColor();
                    var sheetBackColorAlt=sheetObj.GetDataAlternateBackColor();
                    var sTr="";
                    sTr += "\t<TR";
                    var rowFontColor=sheetObj.GetRowFontColor(i);
                    if (rowFontColor !=  "" && rowFontColor != sheetFontColor) {
                        var radixVal=parseInt(rowFontColor.substring(0, 2), 16) + "," + parseInt(rowFontColor.substring(2, 4), 16) + "," + parseInt(rowFontColor.substring(4, 6), 16);
                        sTr += " COLOR=\"" + radixVal + "\"";
                    }
                    var rowBackColor=sheetObj.GetRowBackColor(i);
                    if (rowBackColor !=  "" && rowBackColor != sheetBackColor && rowBackColor != sheetBackColorAlt) {
                        var radixVal=parseInt(rowBackColor.substring(0, 2), 16) + "," + parseInt(rowBackColor.substring(2, 4), 16) + "," + parseInt(rowBackColor.substring(4, 6), 16);
                        sTr += " BGCOLOR=\"" + radixVal + "\"";
                    }
                    var rowEditable=new String(sheetObj.GetRowEditable(i)).toUpperCase();
                    sTr += " EDIT=\"" + rowEditable + "\"";
                    for (var j=0; j < arrCol.length; j++) {
                        aryTD[j]="";
                        aryTD[j] += "\t\t<TD";
                        var cellFontColor=sheetObj.GetCellFontColor(i, arrCol[j]);
                        if (cellFontColor !=  "" && cellFontColor != sheetFontColor && cellFontColor != rowFontColor) {
                            var radixVal=parseInt(cellFontColor.substring(0, 2), 16) + "," + parseInt(cellFontColor.substring(2, 4), 16) + "," + parseInt(cellFontColor.substring(4, 6), 16);
                            aryTD[j] += " COLOR=\"" + radixVal + "\"";
                        }
                        var cellBackColor=sheetObj.GetCellBackColor(i, arrCol[j]);
                        if (cellBackColor !=  "" && cellBackColor != sheetBackColor
                                && cellBackColor != sheetBackColorAlt && cellBackColor != rowBackColor) {
                            var radixVal=parseInt(cellBackColor.substring(0, 2), 16) + "," + parseInt(cellBackColor.substring(2, 4), 16) + "," + parseInt(cellBackColor.substring(4, 6), 16);
                            aryTD[j] += " BGCOLOR=\"" + radixVal + "\"";
                        }
                        var cellEditable=new String(sheetObj.GetCellEditable(i, arrCol[j])).toUpperCase()
                        if (cellEditable !=  "" && cellEditable != rowEditable) {
                            aryTD[j] += " EDIT=\"" + cellEditable + "\"";
                        }
                        if (sheetObj.GetToolTipText(i, arrCol[j]) != "") {
                            var sTxt=sheetObj.GetToolTipText(i, arrCol[j]).replace(/&/g, "&amp;").replace(/\"/g, "&quot;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
                            aryTD[j] += " TOOL-TIP=\"" + sTxt + "\"";
                        }
                        aryTD[j] += "><![CDATA[" + new String(sheetObj.GetCellValue(i, arrCol[j])) + "]]></TD>";
                    }
                    sTr += ">\n" + aryTD.join("\n")+ "\t</TR>";
                    aryTR.push(sTr);
                } else {
                    for (var j=0; j < arrCol.length; j++) {
                    	aryTD[j]=String(sheetObj.GetCellValue(i, arrCol[j]));
                    }
                    aryTR.push("\t<TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>");
                }
                arrPrcdRow.push(i);
            }
        }
        allXml += "<?xml version='1.0'  ?>\n";
        allXml += "<SHEET>\n";
        allXml += "  <DATA TOTAL='" + arrPrcdRow.length + "' COLORDER='" + saveColName + "'";
        if (!bIsStyled) {
            allXml += " COLSEPARATOR='" + sColSep + "'";
        }
        allXml += ">\n";
        allXml += aryTR.join("\n");
        allXml += "  </DATA>\n";
        allXml += "</SHEET>";
        if (bRowDel) {
            if (allRows) {
                sheetObj.RemoveAll();
            } else {
                sheetObj.RowDelete(arrPrcdRow.join("|"), false);
            }
        }
        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}
