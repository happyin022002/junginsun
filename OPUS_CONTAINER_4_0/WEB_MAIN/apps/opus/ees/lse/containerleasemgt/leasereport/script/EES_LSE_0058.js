/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0058.js
*@FileTitle  : New container Receiving Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0058 : business script for EES_LSE_0058
 */

/* developer job */
// common global variables
var vXmlBuff;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerFormat('change','obj_change',formObj);       
//	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
	axon_event.addListenerFormat('blur','obj_blur',formObj);         
//	axon_event.addListenerFormat('focus','obj_focus',formObj);       
//	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);
}
//Event handler processing by button name */
function processButtonClick(){
	/**********/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj=ComGetEvent();
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
			}
			break;
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;
		case "btn_DownExcel":
			sheetObjects[1].WaitImageVisible = false;
			ComOpenWait(true);
			sheetObjects[1].LoadSearchData(vXmlBuff,{Sync:1} );
			if(sheetObjects[1].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
				}
			ComOpenWait(false);
			sheetObjects[1].SetWaitImageVisible(1);
			break;
		case "btn_New":
			sheetObjects[0].RemoveAll();
			formObject.sn_eng_range1.value="";
			formObject.sn_num_range1.value="";
			formObject.sn_eng_range2.value="";
			formObject.sn_num_range2.value="";
			formObject.sn_num.value="";
			formObject.report_type[0].selected=true;
			formObject.period_stdt.value="";
			formObject.period_eddt.value="";
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
				comboObjects[0].SetItemCheck(i,0);
			}
			formObject.cntr_tpsz_cd.value="";
			comboObjects[0].SetItemCheck(0,1);
			Detail_text.innerHTML="";
			break;
		} // end switch
	}catch(e) {
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
/**
* registering IBMultiCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	sheet1_OnLoadFinish(sheet1);
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	comboObjects[0].SetItemCheck(0,1);
	document.form.sn_eng_range1.focus();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {

	    var HeadTitle1="|Seq.|Container No.|TP/SZ|Received Date|Yard|Seq.|Container No.|TP/SZ|Received Date|Yard";
	    var headCount=ComCountHeadTitle(HeadTitle1);
	    //(headCount, 0, 0, true);

	    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    InitHeaders(headers, info);

	    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntrno1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tysz1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rcive_dt1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yard1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntrno2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tysz2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rcive_dt2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yard2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	     
	    InitColumns(cols);

	    SetEditable(0);
	    
	    SetColBackColor("seq1","#C0C0C0");
	    SetColBackColor("seq2","#C0C0C0");
	    //SetSheetHeight(355);
	    ComResizeSheet(sheetObj);
	}
	break;
	case "sheet2":
		with (sheetObj) {

		    var HeadTitle1="|Seq.|Container No.|TP/SZ|Received Date|Yard|Seq.|Container No.|TP/SZ|Received Date|Yard";
		    var headCount=ComCountHeadTitle(HeadTitle1);
		    (headCount, 0, 0, true);
	
		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntrno1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tysz1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rcive_dt1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yard1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntrno2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tysz2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rcive_dt2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yard2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		     
		    InitColumns(cols);
	
		    SetEditable(0);
		    //SetSheetHeight(355);
		    ComResizeSheet(sheetObj);
		}
 	break;
	}
}

/**
 * calling event after retrieving Sheet
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var rowCount =  sheetObj.RowCount();
		
	if(rowCount > 0){
		Detail_text.innerHTML=" Total : " + rowCount;
	}
	sheetObjects[0].SetColBackColor("seq1","#EEEEEE");
	sheetObjects[0].SetColBackColor("seq2","#EEEEEE");
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
}


//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH: 
	if(validateForm(sheetObj,formObj,sAction)){
		if(sheetObj.id == "sheet1"){
			formObj.f_cmd.value=SEARCH;
			//sheetObj.DoSearch("EES_LSE_0058GS.do",FormQueryString(formObj));
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(1);
			
			vXmlBuff=sheetObj.GetSearchData("EES_LSE_0058GS.do",FormQueryString(formObj));
			
			sheetObj.LoadSearchData(vXmlBuff,{Sync:0} );
		}
	}
	break;
	case IBCREATE:
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml2, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
		}
		break;
	}
}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH: 
			if ( formObj.sn_eng_range1.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_eng_range1);
				return false;
				break;
			}
			if ( formObj.sn_num_range1.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_num_range1);
				return false;
				break;
			}
			if ( formObj.sn_eng_range2.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_range2);
				return false;
				break;
			}
			if ( formObj.sn_num_range2.value == "" ) {
				ComShowCodeMessage("LSE01091");
				ComSetFocus(formObj.sn_num_range2);
				return false;
				break;
			}
			if ( Number(formObj.sn_num.value) > 10000 ) {
				ComShowCodeMessage("LSE01147");
				ComSetFocus(formObj.sn_num_range2);
				return false;
				break;
			}
			break;
			}
		}
	}
	return true;
}
/**
* handling Location blur event
*/
function obj_blur(){
	var obj=ComGetEvent();
	switch(ComGetEvent("name")){
	case "period_stdt":
		//checking number
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		//checking number
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//checking number
		ComChkObjValid(obj);
		break;
	case "sn_eng_range1":
		//if(document.form.sn_eng_range1.value.length == 4){
		document.form.sn_eng_range2.value=document.form.sn_eng_range1.value;
		//}
		break;
	case "sn_num_range1":
		var num1=document.form.sn_num_range1.value;
		var num2=document.form.sn_num_range2.value;
		if(num1 != "" && num2 != "" ){
		   if(Number(num1) > Number(num2) ){
			   document.form.sn_num_range2.value="";
			   document.form.sn_num.value="";
			   document.form.sn_num_range2.focus();
			   return;
		   }
		   document.form.sn_num.value=Number(num2) - Number(num1) + 1;
		}
		break;
	case "sn_num_range2":
		var num1=document.form.sn_num_range1.value;
		var num2=document.form.sn_num_range2.value;
		if(num1 != "" && num2 != "" ){
			if(Number(num1) > Number(num2) ){
				document.form.sn_num_range2.value="";
				document.form.sn_num.value="";
				document.form.sn_num_range2.focus();
				return;
			}
		    document.form.sn_num.value=Number(num2) - Number(num1) + 1;
		}
		break;
	default:
		//checking Validation
	break;
	}
}

/**
* initializing IBMultiCombo
*/
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
	case "combo2":
		with(comboObj) {
			SetDropHeight(200);
			SetMultiSelect(1);
			//MaxSelect = 1;
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
			combo2.SetSelectIndex(0);
			//only upper case, special characters, number - TP/SZ
//no support[check again]CLT 			ValidChar(2,3);
		}
		break;
	}
}
/**
* handling event in case of OnCheckClick combo1
* @return
*/
function combo2_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
		}
	} else {
		comboObj.SetItemCheck(0,0);
	}
}
/**
 * combo2_OnBlur
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function combo2_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if( comboObj.GetItemCheck(0)){
		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
			comboObj.SetItemCheck(i,0);
		}
		formObj.cntr_tpsz_cd.value="";
	}else if(comboObj.GetSelectText()== ""){
		comboObj.SetItemCheck(0,1);
		formObj.cntr_tpsz_cd.value="";
	}else{
	    formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
}
/**
 * combo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
			comboObj.SetSelectText("");
		}else if(KeyCode == 13){
			sheetObjects[0].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
}
/**
* handling event in case of focus
*/
function obj_focus(){
	var obj=ComGetEvent();
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//deleting data unit separator
		ComClearSeparator(event.srcElement);
	}
}
/**
* handling event in case of Change
*/
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
	switch(ComGetEvent("name")) {
	case "period_stdt":		//Location Code
	if(formObj.period_eddt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;
	case "period_eddt":		//Location Code
	checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	break;
	}
    //}
}
/* end of developer job */
