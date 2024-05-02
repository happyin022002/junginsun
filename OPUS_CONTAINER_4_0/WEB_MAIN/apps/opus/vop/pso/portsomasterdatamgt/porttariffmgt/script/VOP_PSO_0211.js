/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0211.js
*@FileTitle  : Tariff Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class Service Provider Help : business script for Service Provider Help
 */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var TerminalList="";
var AccountList="";
var ObjList="";
var conditionXML="";
var searchVersionXML="";	//VersionRetrieving Result

var gRateFormat4 = "#,###.####";
var gRateFormat10 = "#,###.##########";
var gRateFormatZero10 = "#,##0.##########";

var localopener=window.dialogArguments;
if (!localopener)  localopener=window.opener;  //이 코드 추가할것
if (!localopener) localopener=parent; //이 코드 추가할것

//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObj,IBSEARCH);
				break;
			case "btn_New":
				//alert("Do you need me?");
				break;
			case "btn_Ok":
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("PSO00019");
					return;
				}
 				var param="f_cmd="     + SEARCH;				//Command
 		    		param += "&port_cd="  + formObj.port_cd.value;	//Port
 		    		param += "&combo1="   + comboObjects[0].GetSelectCode(); 	//Yard
 		    		param += "&vndr_seq=" + comboObjects[1].GetSelectCode();//Service Provider
 		    		//param += "&combo3="   + formObj.cost_cd.value; //Cost 
 		    		param += "&combo3="   + comboObjects[2].GetSelectCode(); //Cost 
 		    		param += "&combo4="   + comboObjects[3].GetSelectCode(); 	//Version 
 		    		param += "&year="     + formObj.year.value; 	//Year 
 		    		param += "&from_date="+ formObj.eff_date.value.substring(0,10); 	//From Date 
 			    	param += "&to_date="  + formObj.eff_date.value.substring(11); 	//To Date
 		    		param += "&uid="      + "0004"; 				//UID 
 		    		localopener.document.form.copy_condition.value=param;	
 		    		localopener.f_RetrieveAfterCopy();
				ComClosePopup(); 
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		}
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
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	initControl(sheetObjects[0]);  
 	xsheet1_OnLoadFinish(sheetObjects[0]);
}
/**
 * registering initial event 
 */
function initControl(sheetObj){
	var formObj=document.form;
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('click', 'obj_click', form); 
	//axon_event.addListenerForm  ('paste', 'obj_paste', form);
	//axon_event.addListenerForm  ('drop', 'obj_drop', form);
	//load Terminal List..
	setToday(formObj.year, "y");
}
/**
 * setting Combo basic info 
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */ 
function initCombo(comboObj, comboNo) {
	var formObject=document.form
	switch(comboNo) {  
		case 1: 
			with (comboObj) { 
				//MultiSelect = true; 
				SetMultiSeparator("|");
				SetUseAutoComplete(1);
 				UseCode=true;
 				SetColAlign(0, "center");
 				SetColAlign(1, "left");
 				SetColWidth(0, "40");
 				SetColWidth(1, "300");
				SetDropHeight(190);
 				ValidChar(2,1);
				SetMaxLength(2);
			}
			break; 
		case 2: 
			with (comboObj) { 
				//MultiSelect = true; 
				SetMultiSeparator("|");
				SetUseAutoComplete(1);
 				UseCode=true;
				SetDropHeight(190);
			}
			break; 
		case 3: 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "60");
				SetColWidth(1, "200");
			}
			
			break;
		case 4: 
			with (comboObj) { 
				//MultiSelect = true; 
				SetMultiSeparator("|");
				SetUseAutoComplete(1);
 				UseCode=true;
				SetDropHeight(190);
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "160");
			}
			break; 	
	} 
}
/**
 * Adding data to combo
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}
function obj_keyup(){
	var eleObj=event.srcElement;
	var formObj=document.form;
	switch (eleObj.name) {
		case "year":
			if(eleObj.value.length == 4 && ComIsDate(eleObj.value,"yyyy")){
				loadAccount();
				searchVendor();
				searchVersion();
				f_RemoveSheets();
				f_HideSheets();
			}
			break;
		case "se_prv":
			if(eleObj.value.length == 8){
				formObj.from_date.focus();
			}
			break;
		case "from_date":
			if(eleObj.value.length == 8){
				formObj.to_date.focus();
			}
			break; 
		case "to_date":
			if(eleObj.value.length == 8){
				formObj.port_cd.focus();
			}
			break;
		case "port_cd":
			if(eleObj.value.length == 5){
				formObj.yd_cd.value = eleObj.value;
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
				doActionIBCombo(sheetObjects[0], formObj, COMMAND01);	// Account Code Combo
			} else{
				comboObjects[0].RemoveAll();
			}
			f_RemoveSheets();
			break;
	}
}
/*function obj_paste(){
	var eleObj=event.srcElement;
	var formObj=document.form;
	switch (eleObj.name) {
		case "year":
			gf_SetControlPastePattern(event, "0");		//Number
			break;			
	}
}
function obj_drop(){
	event.returnValue=false;
}*/
function obj_click(){
	var formObj=document.form;
	obj=event.srcElement;      	
	with(formObj){
		if(obj.name=="cBase"){
			if(cBase.checked){
				document.getElementById("div_base").style.display="inline";
			} else{
				document.getElementById("div_base").style.display="none";
			}
		}
		if(obj.name=="cSur"){
			if(cSur.checked){
				document.getElementById("div_surcharge").style.display="inline";
			} else{
				document.getElementById("div_surcharge").style.display="none";
			}
		}
		if(obj.name=="cDis"){
			if(cDis.checked){
				document.getElementById("div_discount").style.display="inline";
			} else{
				document.getElementById("div_discount").style.display="none";
			}
		}
	}
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
			with(sheetObj){
		  
				var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Regular\nValue|Formula Condition|Formula Condition|Alias|||Compulsory";
				var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|Regular\nValue|ID|Description|Alias|||Compulsory";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet1_";
		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
			                 { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
		
				var cols = [ 
				         {Type:"Text",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
			             {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
			             {Type:"Text",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
			             {Type:"Combo",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
			             {Type:"Text",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",     Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			             {Type:"Float",    Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Float",    Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"regular_value",   KeyField:0,   CalcLogic:"",   Format:"",   		UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
			             {Type:"Text",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
			             {Type:"Text",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
			             {Type:"Text",     Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
			             {Type:"Text",     Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
			             {Type:"Text",     Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg" } ];
			    
				InitColumns(cols);
		
				SetEditable(0);
				SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Range2\tRangeRateOnly|Fixed\tObjectXFixedRate", ComboCode:"R|S|F"} );
				SetCountPosition(0);
			    SetShowButtonImage(1);
			    SetSheetHeight(120);
		   	}
			break;
		case "sheet2":
			with(sheetObj){
			   
				var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet2_";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ 
				        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		                {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		                {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		                {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		                {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		                {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		       
				InitColumns(cols);
				SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
				SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );

				SetEditable(0);
				SetCountPosition(0);
		        SetShowButtonImage(1);
		        SetSheetHeight(120);
			}
		   	break;
		case "sheet3":
			with(sheetObj){
			    	  
		    	var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		    	var headCount=ComCountHeadTitle(HeadTitle1);
		    	var prefix="sheet3_";
	
		    	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		    	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		    	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	InitHeaders(headers, info);

		    	var cols = [ 
		    	       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
    	               {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
    	               {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
    	               {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	               {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
    	               {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
    	               {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
    	               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
    	      
		    	InitColumns(cols);
		    	SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		    	SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		    	SetEditable(0);
    	        SetCountPosition(0);
    	        SetShowButtonImage(1);
	    	    SetSheetHeight(120);
    	        
    	     }
	      break;
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction, etc) {
	//sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet3_");        
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH;
 			var param="f_cmd="     + SEARCH;				//Command
 		    	param += "&port_cd="  + formObj.port_cd.value;	//Port
 		    	param += "&combo1="   + comboObjects[0].GetSelectCode(); 	//Yard
 		    	param += "&vndr_seq=" + comboObjects[1].GetSelectCode();	//Service Provider
 		    	param += "&combo3="   + comboObjects[2].GetSelectCode(); //Cost 
 		    	//param += "&combo3="   + formObj.cost_cd.value; //Cost 
 		    	param += "&combo4="   + comboObjects[3].GetSelectCode(); 	//Version 
 		    	param += "&year="     + formObj.year.value; 	//Year 
 		    	param += "&from_date="+ formObj.eff_date.value.substring(0,10); 	//From Date 
 		    	param += "&to_date="  + formObj.eff_date.value.substring(11); 	//To Date 
 		    	param += "&uid="      + "0002"; 				//UID 
		    //calling from VOP_PSO_0036.do
		    if(etc != undefined && etc != ""){
		    	param=etc;
		    }
 			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			
			sheetObjects[0].SetWaitImageVisible(1);
			sheetObjects[1].SetWaitImageVisible(0);
			sheetObjects[2].SetWaitImageVisible(0);
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			
			
			/*for(var i=0; i < arrXml.length; i++){ 
				sheetObjects[i].RemoveAll();
				sheetObjects[i].RenderSheet(0);
				if(i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}  
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				sheetObjects[i].RenderSheet(1);
			}*/
			//first row : Enable
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"object|" + aryPrefix[0]+"object_code|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"regular_value|" + aryPrefix[0]+"condition");
		break;
		case IBSEARCH_ASYNC01:
			var prefix="sheet1_";
			var aryPrefix=new Array( "sheet1_");
			formObj.f_cmd.value=SEARCHLIST01;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
 			var sXml=sheetObj.GetSearchData("VOP_PSO_0211GS.do", param );
			var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
			//Initializing combo
			comboObjects[0].RemoveAll();
			addComboItem(comboObjects[0],comboItems);	
			comboObjects[0].SetSelectCode(formObj.ydCd.value,false);
			
			loadAccount();
			
			searchVendor();
			comboObjects[1].SetSelectCode(formObj.vndr_seq.value);
			break;
		
		case COMMAND05:	//Port Code [keyup:5자리]
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
				//comboObjects[0].focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSEARCH:
				//Yard
				if( comboObjects[0].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00008');
					com_yd_cd.focus();
					return false;
				}	
				//Vendor
				if( comboObjects[1].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00011');
					com_vendor.focus();
					return false;
				}	
				//Year
				if(year.value == '' || year.value.length != 4){
					ComShowCodeMessage('PSO00003');
					year.focus();
					return false;
				}	
				break;
		}      
	}
	return true;
}
 function xsheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	var port=document.getElementById("port_cd").value;
	//if(port == "PAPCA" || port == "EGSCA"){
		document.getElementById("acct_or_cost_caption").innerText="Cost Code";
		document.getElementById("acct_or_cost_cd").value=document.getElementById("cost_cd").value;
		document.getElementById("acct_or_cost_nm").value=document.getElementById("cost_nm").value;		
	//} else{		
	//	document.getElementById("acct_or_cost_caption").innerText="Account Code";
	//	document.getElementById("acct_or_cost_cd").value=document.getElementById("param_acct_cd").value;
	//	document.getElementById("acct_or_cost_nm").value=document.getElementById("param_acct_nm").value;
	//}
		
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
function sheet2_OnLoadFinish(sheetObj){
	document.getElementById("div_surcharge").style.display="none";
}
function sheet3_OnLoadFinish(sheetObj){
	document.getElementById("div_discount").style.display="none";	
}
/**
* Yard Combo
*/ 
function com_yd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if(oldCode != newCode){
		loadAccount();
		searchVendor();
		searchVersion();
		f_RemoveSheets();
		f_HideSheets();
	}
}
function com_yd_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");
}  
/**
* Vendor Combo
*/
function com_vendor_OnChange(comb , oldindex, oldtext , oldcode , newindex, newtext , newcode){
	 var formObj=document.form;
	 formObj.vndr_nm.value=comb.GetText(newcode, 1);
	 searchVersion();
	 f_RemoveSheets();
	 f_HideSheets();
}
/**
 * Version Combo
 */
function ver_OnChange(comb , oldindex, oldtext , oldcode , newindex, newtext , newcode){
	var formObject=document.form;
	var data=comb.GetText(parseInt(comb.GetSelectIndex()), 1);	//DT
	formObject.eff_date.value=data;
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem=comboItems[i].split(FIELDMARK);
		if(i == comb.GetSelectIndex()){
			if(comboItem[4] == "Y"){	//Compulsory
				formObject.cpls_flg.checked=true;
			} else{
				formObject.cpls_flg.checked=false;				
			}
			break;
		}
	}
	f_RemoveSheets();
	f_HideSheets();
}
function setEnableControl4Columns(sheetObj, cols){
	var formObj=document.form;
	var arrCol=cols.split("|");
	for(row=sheetObj.HeaderRows(); row<sheetObj.HeaderRows()+ sheetObj.RowCount(); row++){
		if(row > sheetObj.HeaderRows()){	//except first row
			for(i=0; i<arrCol.length; i++){
				sheetObj.SetCellEditable(row, arrCol[i],0);
			}
			sheetObj.SetCellValue(row, "sheet1_seq","",0);
			sheetObj.SetCellValue(row, "sheet1_object_dsp","",0);
			sheetObj.SetCellValue(row, "sheet1_object_code_dsp","",0);
			sheetObj.SetCellValue(row, "sheet1_rate_code","",0);
			sheetObj.SetCellValue(row, "sheet1_regular_value","",0);
			sheetObj.SetCellValue(row, "sheet1_condition","",0);
			sheetObj.SetCellValue(row, "sheet1_cond_desc","",0);
		} else{
			for(i=0; i<arrCol.length; i++){
				sheetObj.SetCellEditable(row, arrCol[i],1);
			}		
		}
	}
	if(sheetObjects[0].RowCount()> 0){
		document.getElementById("cBase").checked=true;
		document.getElementById("div_base").style.display="inline";
	} else{		
		//document.getElementById("cBase").checked = false;
		//document.getElementById("div_base").style.display = "none";
	}
	if(sheetObjects[1].RowCount()> 0){
		document.getElementById("cSur").checked=true;
		document.getElementById("div_surcharge").style.display="inline";
	} else{		
		document.getElementById("cSur").checked=false;
		document.getElementById("div_surcharge").style.display="none";
	}
	if(sheetObjects[2].RowCount()> 0){
		document.getElementById("cDis").checked=true;
		document.getElementById("div_discount").style.display="inline";
	} else{		
		document.getElementById("cDis").checked=false;
		document.getElementById("div_discount").style.display="none";
	}
	//Compulsory
	if(sheetObjects[0].RowCount()> 0){
		if(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_cpls_flg") == "Y"){
			formObj.cpls_flg.checked=true;
		} else{			
			formObj.cpls_flg.checked=false;
		}
	} else{
		formObj.cpls_flg.checked=false;
	}
}
/**
* Adding data to combo(Version)
*/	
function addComboItemVersion(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		//Text : Version|FromDt~ToDt|Curr_Cd
		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[2] + "|" + comboItem[3], comboItem[1] );
		//if(i == 0) break;
	}   		
}
/**
* Version Retrieving
*/
function searchVersion(){
	var formObj=document.form;
	var comboObj3 = comboObjects[3];
	comboObj3.RemoveAll();
	formObj.f_cmd.value=COMMAND02;
 	var param="f_cmd="     + COMMAND02;				//Command
 	    param += "&port_cd="   + formObj.port_cd.value;//Port
 	    param += "&combo1="   + comboObjects[0].GetSelectCode(); 	//Yard
 	    param += "&vndr_seq=" + comboObjects[1].GetSelectCode();	//Service Provider
 	    //param += "&combo3="   + formObj.cost_cd.value; //Cost 
 	    param += "&combo3="   + comboObjects[2].GetSelectCode(); //Cost 
 	    param += "&year="     + formObj.year.value; 	//Year 
 	    param += "&uid="      + "0002"; 				//UID  
 	searchVersionXML=sheetObjects[0].GetSearchData("VOP_PSO_0002GS.do", param);
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	if( comboItems != "" ){ 
		addComboItemVersion(comboObj3,comboItems);
		formObj.yd_chg_no.value=comboItems[0].split(FIELDMARK)[0];		
	} else{
		comboObj3.InsertItem(0, "001|" + ComGetNowInfo() + "~" + ComGetNowInfo("yy") + "-12-31", "001");
		formObj.yd_chg_no.value="";
	}
	comboObj3.SetSelectIndex(-1,false);
	comboObj3.SetSelectIndex(0);
}
/**
* Vendor Retrieving
*/
function searchVendor(){
	var formObj=document.form;
	comboObjects[1].RemoveAll();
 	var param="f_cmd="     + COMMAND03;				//Command
 		param += "&port_cd="  + formObj.port_cd.value + comboObjects[0].GetSelectCode();//Port
 		param += "&cost_cd="  + comboObjects[2].GetSelectCode(); 	//Cost
 		//param += "&cost_cd="  + formObj.cost_cd.value; 	//Cost
 		param += "&year="     + formObj.year.value; 		//Year
 		param += "&uid="      + "0002"; 					//UID 
		param += "&acct_cd=";//Account Code
		//param += "&acct_cd="  + comboObjects[2].GetSelectCode();//Account Code
 	var sXml=sheetObjects[0].GetSearchData("VOP_PSO_0211GS.do", param);
 	if("" != sXml){
		var comboItems=ComGetEtcData(sXml, "vendorList").split("||");
		if( comboItems != "" ){
			comboObjects[1].SetEnable(1);
		 	for (var i=0 ; i < comboItems.length ; i++) {
		 		var comboItem=comboItems[i].split(",,");
		 		comboObjects[1].InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
		 	}
		 	comboObjects[1].SetSelectIndex(-1,false);
			comboObjects[1].SetSelectIndex(0);
			formObj.vndr_nm.value=comboObjects[1].GetText(comboObjects[1].GetSelectCode(), 1);
		}else{
			comboObjects[1].SetEnable(0);
			formObj.vndr_nm.value="";
		}
 	}else{
		comboObjects[1].SetEnable(0);
		formObj.vndr_nm.value="";
 		
 	}
}
function f_HideSheets(){
	var formObj=document.form;
	if(sheetObjects[0].RowCount()> 0){
		document.getElementById("cBase").checked=true;
		document.getElementById("div_base").style.display="inline";
	} else{		
		//document.getElementById("cBase").checked = false;
		//document.getElementById("div_base").style.display = "none";
	}
	if(sheetObjects[1].RowCount()> 0){
		document.getElementById("cSur").checked=true;
		document.getElementById("div_surcharge").style.display="inline";
	} else{		
		document.getElementById("cSur").checked=false;
		document.getElementById("div_surcharge").style.display="none";
	}
	if(sheetObjects[2].RowCount()> 0){
		document.getElementById("cDis").checked=true;
		document.getElementById("div_discount").style.display="inline";
	} else{		
		document.getElementById("cDis").checked=false;
		document.getElementById("div_discount").style.display="none";
	}	
}
function f_RemoveSheets(){
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

function loadTerminal() {
 	var formObj = document.form;
 	var sheetObj = sheetObjects[0];
 	
 	comboObjects[0].RemoveAll();
 	formObj.f_cmd.value = SEARCHLIST01;
 	var sXml = sheetObj.GetSearchData("VOP_PSO_0211GS.do", FormQueryString(formObj));
 	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
 	addComboItem(comboObjects[0], comboItems);
}

function loadAccount() {
	doActionIBCombo(sheetObjects[0], document.form, COMMAND01);
}

function doActionIBCombo(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg = false;
 	switch(sAction) {
 		case COMMAND01:     // Account Combovar 
 			var param = "";
 			param  = "f_cmd="     	+ sAction;				//Command
 	 		param += "&yd_cd="  	+ formObj.port_cd.value + comboObjects[0].GetSelectCode();
 	 		param += "&year="     	+ formObj.year.value; 	//Year
 	 		param += "&upd_mnu_no=" + "1"; 					//1 : 단순, 2 : 복합 
 			//formObj.f_cmd.value = sAction;
 			//formObj.yd_cd.value = formObj.port_cd.value + comboObjects[0].GetSelectCode();
 			sheetObj.WaitImageVisible = false;
 			//var sXml = sheetObj.GetSearchData("VOP_PSO_0036GS.do", FormQueryString(formObj) );
 			var sXml = sheetObj.GetSearchData("VOP_PSO_0036GS.do", param );
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0) 
 				ComXml2ComboItem(arrXml[0], comboObjects[2], "cost_cd", "cost_cd|cost_nm");
 				//ComXml2ComboItem(arrXml[0], comboObjects[2], "acct_cd", "acct_cd|acct_nm");
 			ComSetObjValue(comboObjects[2], formObj.cost_cd.value);
 			
 			//comboObjects[2].SetSelectCode(code, 1);
 			if(comboObjects[2].GetSelectIndex() < 0){
 				if(comboObjects[2].GetItemCount() > 0){
 					comboObjects[2].SetSelectIndex(0);
 				}else{
 					formObj.acct_or_cost_nm.value = "";
 				}
 			}
 			
 			break;
 	}
 }

/**
 * Account Combo
 */
function acct_or_cost_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if(oldCode == newCode) return;
	var formObject = document.form;
	formObject.acct_or_cost_nm.value = comboObjects[2].GetText(newCode, 1);
	searchVendor();
}

//Base Grid
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
  var Row=sheetObj.MouseRow();
  var Col=sheetObj.MouseCol();
  var prefix="sheet1_";
  var sText = "";
  var selColName = sheetObj.CellSaveName (Row, Col);
  sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
  	sheetObj.SetToolTipText(Row,Col,sText);
  }
}

//Surcharge Grid
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
    var Row=sheetObj.MouseRow();
    var Col=sheetObj.MouseCol();
    var prefix="sheet2_";
    var sText = "";
    var selColName = sheetObj.CellSaveName (Row, Col);
    sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
    	sheetObj.SetToolTipText(Row,Col,sText);
    }
}

//Discount Grid
function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y){
    var Row=sheetObj.MouseRow();
    var Col=sheetObj.MouseCol();
    var prefix="sheet3_";
    var sText = "";
    var selColName = sheetObj.CellSaveName (Row, Col);
    sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
    	sheetObj.SetToolTipText(Row,Col,sText);
    }
}

function sheet1_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		f_SetMeasUnitByRow(sheetObj, i);
	}
}
//단위별 포맷을 잡아 준다. pso_meas_ut_cd regular_value
function f_SetMeasUnitByRow(sheetObj, row){
	var sheetid=sheetObj.id;
	var prefix = sheetid + "_";
	switch(sheetid) {
		case "sheet1": 
			var tmpObjCdDsp		= sheetObj.GetCellValue(row, prefix+"object_code_dsp");

			var tmpRateCode 	= sheetObj.GetCellValue(row, prefix+"rate_code");
			var tmpRangeFormat	= "NullFloat";
			
			if(tmpRateCode == "F"){
				tmpRangeFormat		= "NullFloat";
			}else{ //S, R
				tmpRangeFormat		= gRateFormat4;
			}
			
			if("TIME" == tmpObjCdDsp){
				sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Date",Align:"Center",Format:"Hm"} );
				sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Date",Align:"Center",Format:"Hm"} );

				sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat10} );
				sheetObj.InitCellProperty(row, prefix + "regular_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat4} );
			}else{
				sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
				sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
				
				sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat10} );
				sheetObj.InitCellProperty(row, prefix + "regular_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat4} );
			}
			
			break;	
	}
}