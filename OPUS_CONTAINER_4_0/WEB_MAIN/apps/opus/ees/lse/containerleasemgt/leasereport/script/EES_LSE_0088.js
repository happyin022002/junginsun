/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0088.js
*@FileTitle  : On-Hire Report Summary By Month
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0088 : business script for EES_LSE_0088
 */
function EES_LSE_0088() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
	this.combo1_OnCheckClick=combo1_OnCheckClick;
	this.combo1_OnBlur=combo1_OnBlur;
	this.combo1_OnKeyDown=combo1_OnKeyDown;
}
/* developer job */
// common global variables
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array();
var arrTpSz2=new Array();
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
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj=window.event.srcElement;
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_DownExcel":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
				 sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
				}
			break;
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;
		case "btn_New":
			sheetObject1.RemoveAll();
			formObject.period_stdt.value="";
			formObject.period_eddt.value="";
			formObject.loc_tp[0].selected=true;
			formObject.loc_cd.value="";
			document.form.loc_cd.readOnly=true;
			document.form.loc_cd.className="input2";
			ComEnableObject(document.form.btns_search1, false);
			formObject.term_change[1].selected=true;
			formObject.dii[0].selected=true;
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
				comboObjects[0].SetItemCheck(i,0);
			}
			formObject.lstm_cd.value="";
			comboObjects[0].SetItemCheck(0,1);
			break;
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
			}
			break;
		case "btns_search1":      // loc_cd
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
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
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
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
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	initSheet(sheetObjects[0],1);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);
	comboObjects[0].SetItemCheck(0,1);
	document.form.period_stdt.focus();
	document.form.loc_cd.readOnly=true;
	document.form.loc_cd.className="input2";
	ComEnableObject(document.form.btns_search1, false);
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "sheet1":
		with (sheetObj) {

		    var HeadTitleTemp="";
		    for(var i=0; i<arrTpSz.length; i++){
		    	HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i];
		    }
		    var HeadTitle="|Month" + HeadTitleTemp + "|G.TTL|Ratio|";
		    var headCount=ComCountHeadTitle(HeadTitle);
		    //(headCount, 0, 0, true);
//		    for(var i=0; i < 2; i++) {
		    cnt=0;
	
		    SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
	
		    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rcc",          KeyField:0,   CalcLogic:"",   Format:"" } ];
		       for(var j=0; j<arrTpSz2.length; j++){
		    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[j]+"", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    }
		    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"div_total",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"ratio",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    cols.push({Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    for(var j=1; j <= LastCol(); j++) {
		    	SetColHidden(j,(j == LastCol()));
		    }
		  
		    InitColumns(cols);
	
		    SetEditable(0);
//		    }
		    FrozenCols=2;
		    //SetSheetHeight(403);
		    ComResizeSheet(sheetObj);
		}
		break;
	}
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:
	if(validateForm(sheetObj,formObj,sAction))
		if (sheetObj.id == "sheet1"){
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("EES_LSE_0088GS.do", FormQueryString(formObj));
			if(ComGetTotalRows(sXml) > 2) {
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				/*var ratio="";
				var div_total="";
				
				for(var i=0; i < arrTpSz2.length; i++){
					ratio=sheetObj.GetCellValue( sheetObj.LastRow(),  arrTpSz2[i] );
					sheetObj.SetCellValue( sheetObj.LastRow(),  arrTpSz2[i] ,ratio + "%");
				}
				
				if(sheetObj.RowCount()> 0){
					div_total=sheetObj.GetCellValue( sheetObj.LastRow(), "div_total" );
					sheetObj.SetCellValue( sheetObj.LastRow(),  "div_total" ,div_total + ".00%");
					sheetObj.SetCellValue( sheetObj.LastRow(),  "ratio" ,"");
//					var gttlRow=sheetObjects[0].FindText(1, "G.TTL");
//					var ratioRow=sheetObjects[0].FindText(1, "Ratio");
//					sheetObjects[0].RowBackColor(gttlRow) = LSE_TOTCOL_BACK_COLOR;
//					sheetObjects[0].RowBackColor(ratioRow)= LSE_TOTCOL_BACK_COLOR;
				}*/
			} else {
				//sheetObj.LoadSearchData("<SHEET><DATATOTAL='0'></DATA></SHEET>",{Sync:0} );
				sheetObj.LoadSearchData(sXml,{Sync:0} );
			}
			//ComOpenWait(false);
		}
	break;
	case IBCREATE:
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
			formObj.tysz.value=vOrcCntrTpszCd;
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;
	case IBSEARCH_ASYNC03:
		/* Lease Term Form Combo Item Setting */
		ComSetObjValue(formObj.f_cmd, SEARCH01);
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		}
		vOrcLstmCd=ComGetEtcData(sXml, "lease_term_nm");
		break;
	case IBSEARCH_ASYNC05:
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp=formObj.loc_tp.value;
			var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp + "CC"
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
			sheetObj.SetWaitImageVisible(1);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd="";
						switch (vLocTp) {
						case "R":
							vLocCd=ComGetEtcData(sXml, "rcc_cd");
							break;
						case "L":
							vLocCd=ComGetEtcData(sXml, "lcc_cd");
							break;
						case "S":
							vLocCd=ComGetEtcData(sXml, "scc_cd");
							break;
						}
						formObj.loc_cd.value=vLocCd;
						ComSetFocus(formObj.loc_cd);
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value="";
						ComSetFocus(formObj.loc_cd);
					}
				} else {
					var errMsg=LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.loc_cd.value="";
					ComSetFocus(formObj.loc_cd);
				}
			}
		}
	}
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
			var periodStdt=formObj.period_stdt.value;
			periodStdt=periodStdt.replaceStr("-","");
			var periodEtdt=formObj.period_eddt.value;
			periodEtdt=periodEtdt.replaceStr("-","");
			if ( periodStdt == "" ) {
				ComShowCodeMessage("LSE01010");
				ComSetFocus(formObj.period_stdt);
				return false;
				break;
			}
			if ( periodEtdt == "" ) {
				ComShowCodeMessage("LSE01011");
				ComSetFocus(formObj.period_eddt);
				return false;
				break;
			}
			if ( Number(periodStdt) >= Number(periodEtdt)) {
				ComShowCodeMessage("LSE01051");
				formObj.period_eddt.value="";
				ComSetFocus(formObj.period_eddt);
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
		/* checking number */
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		/* checking number */
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		/* checking number */
		ComChkObjValid(obj);
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
	case "combo1":
		with(comboObj) {
			SetDropHeight(250);
			SetMultiSelect(1);
			//MaxSelect = 1;
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
			//only upper case, special characters - Lease Term
//no support[check again]CLT 			ValidChar(2,2);
		}
		break;
	}
}
/**
 * handling event in case of OnCheckClick combo1
 * @return
 */
function combo1_OnCheckClick(comboObj, index, code) {
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
 * combo1_OnBlur
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if( comboObj.GetItemCheck(0)){
		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
			comboObj.SetItemCheck(i,0);
		}
		formObj.lstm_cd.value="";
	}else if(comboObj.GetSelectText()== ""){
		comboObj.SetItemCheck(0,1);
		formObj.lstm_cd.value="";
	}else{
	    formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
}
/**
 * combo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
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
	if(formObj.period_stdt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;
	case "loc_cd":		//Location Code
	if ( ComTrim(obj.value) != "" ) {
		if(document.form.loc_tp.value == "Y" ) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
		} else if(document.form.loc_tp.value == "C" ) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC07);
		} else if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" || document.form.loc_tp.value == "S"){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
		}
	}
	break;
	case "loc_tp":		//Location Type
	formObj.loc_cd.value="";
	if(obj.value == "") {
		formObj.loc_cd.readOnly=true;
		formObj.loc_cd.className="input2";
		ComEnableObject(formObj.btns_search1, false);
		sheetObjects[0].SetCellText(0, 1 ,"RCC");
	} else {
		formObj.loc_cd.readOnly=false;
		formObj.loc_cd.className="input";
		ComEnableObject(formObj.btns_search1, true);
		if(obj.value == "R"){
			formObj.loc_cd.maxLength=5;
		}else if(obj.value == "L"){
			formObj.loc_cd.maxLength=5;
		}else if(obj.value == "S"){
			formObj.loc_cd.maxLength=5;
		}else{
			formObj.loc_cd.maxLength=5;
		}
		ComSetNextFocus(obj);
	}
	break;
	}
//}
}

/**
* calling event after retrieving Sheet1
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		if(SearchRows()> 0) {
			for(var i=1; i <= LastRow()-1; i++) {
				for(var j=0; j < LastCol(); j++) {
					SetCellText(i, j, GetCellText(i, j).trim());
				}
			}
			
			var ratio = "";
			for(var i=0; i < arrTpSz2.length; i++){
				
				ratio=sheetObj.GetCellValue( sheetObj.LastRow(),  arrTpSz2[i] );
				if(ratio != "") {
					SetCellValue( sheetObj.LastRow(),  arrTpSz2[i] , ratio + "%");
				}
			}
			
			/*
			for(var i=LastRow()-2; i > LastRow()-4; i--) {
				for(var j=0; j < LastCol(); j++) {
					SetCellText(i, j ,GetCellText(i, j));
					console.debug(i + "::" + j + "::" + GetCellText(i, j).trim());
				}
			}
			*/
//			sheetObj.RowDelete(LastRow()-3, false);
//			sheetObj.RowDelete(LastRow()-1, false);
			SetCellValue(LastRow()-1, "rcc","G.TTL",0);
			SetCellValue(LastRow(), "rcc","Ratio",0);
			SetCellValue(LastRow(), "ratio","",0);
			SetRowBackColor(LastRow() - 1, LSE_TOTCOL_BACK_COLOR);
			SetRowBackColor(LastRow(), LSE_TOTCOL_BACK_COLOR);
			console.debug("");
		}
	}
	
	ComOpenWait(false);
}
/**
 * handing process Pop-up<br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
 * @param object
 * @param Row index
 */
function openPopup(type, Row, Col) {
	var formObj=document.form;
	if ( type == "1" ) {
		switch(formObj.loc_tp.value) {
		case "R" :	//RCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "L" :	//LCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "S" :	//SCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		default : 	//do nothing
		}
	}
}
/* end of developer job */
