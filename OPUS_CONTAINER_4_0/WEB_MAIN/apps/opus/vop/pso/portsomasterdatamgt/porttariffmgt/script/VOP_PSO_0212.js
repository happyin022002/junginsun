/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0212.js
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
var gColumnCountInSheet2=0;	//Column Count of sheet2
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var TerminalList="";
var AccountList="";
var ObjList="";
var conditionXML="";
var searchVersionXML="";	//VersionRetrieving Result
var arrFormulaNo=new Array();	//Getting Formula_No IN (1, 2) when page load

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
		    		param += "&uid="      + "0004"; 
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
	axon_event.addListenerForm  ('paste', 'obj_paste', form);
	axon_event.addListenerForm  ('drop', 'obj_drop', form);
	//load Terminal List..
	setToday(formObj.year, "y");
}
/**
 * setting combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form
	switch(comboNo) {  
		case 1: 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(2);
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "300");
				ValidChar(2,1);
			}
	
			break; 
		case 2: 
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
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			SetDropHeight(190);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColAlign(2, "center");
			SetColWidth(0, "40");
			SetColWidth(1, "160");
			SetColWidth(2, "40");
			}
			
			break; 
	} 
}

/**
 * Adding data to combo (Currency)
 */	
function addComboItem(comboObj,comboItems) {
	if(!comboItems || ""==comboItems){
		comboObj.SetEnable(0);
		return false;
	}
	if(!comboObj.GetEnable()){
		comboObj.SetEnable(1);
	}
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}
 /**
  * Adding data to combo (Object/Method in Sheets)
  */	
 function makeItemObject(comboItems) {	
 	var comboCode="";
 	var comboText="";
 	//comboItems = " , |" + comboItems;
 	arrComboItems=comboItems.split("|");
 	var preCode="";
 	for (i=0 ; i < arrComboItems.length ; i++) {
 		var comboItem=arrComboItems[i].split(",");
 		if(preCode != comboItem[0]){
 			comboCode += "|" + comboItem[0];
 			comboText += "|" + comboItem[1];
 		}
 		preCode=comboItem[0];
 	}  
 	comboCode=comboCode.substr(1);	//Code
 	comboText=comboText.substr(1); 	//Text
 	return new Array(comboCode, comboText);
 }
  /**
   * Adding data to combo (Object/Method in Regular Value Sheet)
   */	
  function makeItemObjectInRegVal(comboItems) {	
  	var comboCode="";
  	var comboText="";
  	arrComboItems=comboItems.split("|");
  	var preCode="";
  	for (i=0 ; i < arrComboItems.length ; i++) {
  		var comboItem=arrComboItems[i].split(",");
  		//if(preCode != comboItem[0]){
  			comboCode += "|" + comboItem[4];
  			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
  		//}
  		//preCode = comboItem[0];
  	}  
  	comboCode=comboCode.substr(1);	//Code
  	comboText=comboText.substr(1); 	//Text
  	return new Array(comboCode, comboText);
  }  
 /**
  * Adding data to combo (UOM in Sheets)
  */	
 function makeItemUOM(comboItems, objCd) {
 	var comboCode="";
 	var comboText="";
 	arrComboItems=comboItems.split("|");
 	for (i=0 ; i < arrComboItems.length ; i++) {
 		var comboItem=arrComboItems[i].split(",");	//[0]:Object Code, [1]:UOM Code, [2]:UOM Name
 		if(objCd == comboItem[0]){
 			comboCode += "|" + comboItem[1];
 			comboText += "|" + comboItem[2];
 		}
 	}  
 	comboCode=comboCode.substr(1);	//Code
 	comboText=comboText.substr(1); 	//Text
 	return new Array(comboCode, comboText);	 
 }
function obj_keyup(){
	var eleObj=event.srcElement;
	var formObj=document.form;
	switch (eleObj.name) {
		case "year":
			if(eleObj.value.length == 4){
				loadAccount();
				searchVendor();
				searchVersion();
				f_RemoveAllSheet();
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
			f_RemoveAllSheet();
			break;
	}
}
function obj_paste(){
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
}
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
	   
		   MultiSelection=false;
		   var HeadTitle1="||Formula|Formula|Condition|Condition|Compulsory|UK";
		   var HeadTitle2="||ID|DESC| ID|DESC|Compulsory|UK";
		   var headCount=ComCountHeadTitle(HeadTitle1);
		   var prefix="sheet1_";
	
		   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		   var headers = [ { Text:HeadTitle1, Align:"Center"},
		                 { Text:HeadTitle2, Align:"Center"} ];
		   InitHeaders(headers, info);
	
		   var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"default2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"foml_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		    
		   InitColumns(cols);
	
		   SetEditable(0);
		   SetCountPosition(0);
		   SetShowButtonImage(1);
		   SetSheetHeight(125);
		   SetFocusAfterProcess(0);
		   }
		   break;
	    
	    case "sheet2":
		   with(sheetObj){
		    
		   
		   var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		   var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		   var headCount=ComCountHeadTitle(HeadTitle1);
		   gColumnCountInSheet2=headCount;
		   var prefix="sheet2_";
	
		   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		   var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		   var headers = [ { Text:HeadTitle1, Align:"Center"},
		                 { Text:HeadTitle2, Align:"Center"} ];
		   InitHeaders(headers, info);
	
		   var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10,       UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",     Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		    
		   InitColumns(cols);
	
		   SetEditable(0);
		   SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Fixed\tObjectXFixedRate", ComboCode:"R|F"} );
		   SetCountPosition(0);
		   SetShowButtonImage(1);
		   SetSheetHeight(150);
	       SetFocusAfterProcess(0);
	       SetCountPosition(0);
		   }
		   break;
      
       case "sheet3":			//Regular Value
    	   with(sheetObj){


    	   var HeadTitle1="Regular value|Regular value|Regular value|Regular value";
    	   var HeadTitle2="Object|UOM|Value|pso_meas_ut_cd";
    	   var headCount=ComCountHeadTitle(HeadTitle1);
    	   var prefix="sheet3_";

    	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    	   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    	   var headers = [ { Text:HeadTitle1, Align:"Center"},
    	                   { Text:HeadTitle2, Align:"Center"} ];
    	   InitHeaders(headers, info);

    	   var cols = [ 
    	                {Type:"Text",     Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
    	                {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"regular_value",      KeyField:0,   CalcLogic:"",   Format:"",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
    	                {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];

    	   InitColumns(cols);

    	   SetEditable(0);
    	   SetCountPosition(0);
    	   SetSheetHeight(150);
	       SetCountPosition(0);
           }
    	   break;
       
       case "sheet4"://surcharge
    	   with(sheetObj){
			   var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
			   var headCount=ComCountHeadTitle(HeadTitle1);
			   var prefix="sheet4_";
		
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			   var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			   InitHeaders(headers, info);
		
			   var cols = [ 
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
			             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
			    
			   InitColumns(cols);
			   SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
			   SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
			   SetEditable(0);
			   SetCountPosition(0);
			   SetShowButtonImage(1);
			   SetSheetHeight(120);
			   SetCountPosition(0);
		   }
		   break;
     
       case "sheet5"://discount
    	   with(sheetObj){
		      var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet5_";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ 
		                {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		                {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		                {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		                {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		                {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		                {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		       
		      InitColumns(cols);
		      SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
			  SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetEditable(0);
		      SetCountPosition(0);
		      SetShowButtonImage(1);
		      SetSheetHeight(120);
		      SetCountPosition(0);
		      }
		break;
       	case "sheet6":		//Base Dummy
       		with(sheetObj){
              
       		var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
       		var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
       		var headCount=ComCountHeadTitle(HeadTitle1);
       		var prefix="sheet6_";

       		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

       		var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
       		var headers = [ { Text:HeadTitle1, Align:"Center"},
       		                { Text:HeadTitle2, Align:"Center"} ];
       		InitHeaders(headers, info);

       		var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
       		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
       		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
       		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
       		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
       		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
       		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
       		             {Type:"Float",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
       		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
       		             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
       		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
       		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
       		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
       		
       		InitColumns(cols);
    
       		SetEditable(0);
       		SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Fixed\tObjectXFixedRate", ComboCode:"R|F"} );
       		SetCountPosition(0);
       		SetShowButtonImage(1);
       		SetSheetHeight(212);
		    SetCountPosition(0);
       		}
       		break;
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction, etc) {
	//sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			var aryPrefix=new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");       
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH;
 			var param="f_cmd="     + SEARCH;				//Command
		    	param += "&port_cd="  + formObj.port_cd.value;	//Port
		    	param += "&combo1="   + comboObjects[0].GetSelectCode(); 	//Yard
		    	param += "&vndr_seq=" + comboObjects[1].GetSelectCode();	//Service Provider
		    	//param += "&combo3="   + formObj.cost_cd.value; //Cost 
		    	param += "&combo3="   + comboObjects[2].GetSelectCode(); //Cost 
		    	param += "&combo4="   + comboObjects[3].GetSelectCode(); 	//Version 
		    	//param += "&combo5="   + comboObjects[3].GetSelectCode(); 	//Curr. 
		    	param += "&year="     + formObj.year.value; 	//Year 
		    	param += "&from_date="+ formObj.eff_date.value.substring(0,10); 	//From Date 
		    	param += "&to_date="  + formObj.eff_date.value.substring(11); 	//To Date
		    	param += "&uid="      + "0004"; 				//UID 
		    	//param += "&acct_cd="  + comboObjects[2].GetSelectCode(); 	//Account Code 쿼리 조회조건에 조회되도록 추가 
				f_RemoveAllSheet();
				//calling from VOP_PSO_0036.do
			    if(etc != undefined && etc != ""){
			    	param=etc;
			    }
 				var sXml=sheetObj.GetSearchData("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml=sXml.split("|$$|");
				sheetObjects[0].SetWaitImageVisible(1);
				sheetObjects[5].SetWaitImageVisible(0);
				sheetObjects[2].SetWaitImageVisible(0);
				sheetObjects[3].SetWaitImageVisible(0);
				sheetObjects[4].SetWaitImageVisible(0);
				sheetObjects[5].LoadSearchData(arrXml[1],{Sync:1} );
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
				sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
				sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		break;
		case IBSEARCH_ASYNC01:   
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var prefix="sheet1_";
			var aryPrefix=new Array( "sheet1_");
			formObj.f_cmd.value=SEARCHLIST01;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
 			var sXml=sheetObj.GetSearchData("VOP_PSO_0212GS.do", param );
			var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
			ComOpenWait(false);			
			//Initializing combo
			comboObjects[0].RemoveAll();
			addComboItem(comboObjects[0],comboItems);	
			comboObjects[0].SetSelectCode(formObj.ydCd.value,false);
			
			loadAccount();
			
			searchVendor();
			comboObjects[1].SetSelectCode(formObj.vndr_seq.value);
			
			////Retrieving combo 
			formObj.f_cmd.value=SEARCHLIST01;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
 			conditionXML=sheetObj.GetSearchData("VOP_PSO_0004GS.do", param );
			var arrXml=conditionXML.split("|$$|");
			//Object Setting in Sheets (1, 2)
			var comboItems=ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject=makeItemObject(comboItems);
			//Object Setting in Sheet Regular Value
			comboItems=ComGetEtcData(conditionXML, "objListByTpCd");
			arrCodeTextObject=makeItemObjectInRegVal(comboItems);
			//
			var arrFormula4Loading=ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k=0;
			for(i=0; i<arrFormula4Loading.length; i++){
				arrKeyVal=arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k]=arrKeyVal[j];
					k++;             
				}             
			}
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

		case COMMAND06:	//Service Provider   
			formObj.f_cmd.value = COMMAND06;//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var spName = ComGetEtcData(sXml, "spName");		//Service Provider Name
			formObj.vndr_lgl_eng_nm.value = spName;
		
			if (spName != "") {
		
			} 
			else {
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				formObj.vndr_seq.focus();
				formObj.vndr_seq.value = "";
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
	//var port=document.getElementById("port_cd").value;
	//if(port == "PAPCA" || port == "EGSCA"){
		document.getElementById("acct_or_cost_caption").innerText="Cost Code";
		document.getElementById("acct_or_cost_cd").value=document.getElementById("cost_cd").value;
		document.getElementById("acct_or_cost_nm").value=document.getElementById("cost_nm").value;		
	//} else{		
	//	document.getElementById("acct_or_cost_caption").innerText="Account Code";
	//	document.getElementById("acct_or_cost_cd").value=document.getElementById("param_acct_cd").value;
	//	document.getElementById("acct_or_cost_nm").value=document.getElementById("param_acct_nm").value;
	//}

	doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
function sheet2_OnLoadFinish(sheetObj){
	var formObj=document.form;
	document.getElementById("div_surcharge").style.display="none";
}
function sheet3_OnLoadFinish(sheetObj){
	var formObj=document.form;
	document.getElementById("div_discount").style.display="none";	
}
function sheet3_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
		f_SetMeasUnitByRow(sheetObj, i);
	}
}
/**
* Row Change
*/ 
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
	if(OldRow == NewRow){
		return;
	}
	f_RemoveDummyByBase(sheetObj.GetCellValue(OldRow, "sheet1_uk"));	//Dummy 	Deleting
	f_CopyBase2Dummy(sheetObj.GetCellValue(OldRow, "sheet1_uk"));		//Adding to Dummy
	f_CopyDummy2Base(sheetObj.GetCellValue(NewRow, "sheet1_uk"));		//Copying to Base
	document.getElementById("foml_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_foml_desc");
	document.getElementById("cond_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_cond_desc");
}
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var prefix = sheetObj.id+"_";
	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
		//Time 일대 포맷을 마추기 위해 4자리 pad 처리.
		tmpObjectCodeDsp		=sheetObj.GetCellValue(i, prefix + "object_code_dsp");
		if("TIME" == tmpObjectCodeDsp){
			var tmpRangeFrByTm = sheetObj.GetCellValue(i, prefix + "range_from" )+"";
			var tmpRangeToByTm = sheetObj.GetCellValue(i, prefix + "range_to" )+"";
			
			sheetObj.SetCellValue(i, prefix + "range_from"	,ComLpad(tmpRangeFrByTm,4, "0"), 0);
			sheetObj.SetCellValue(i, prefix + "range_to"	,ComLpad(tmpRangeToByTm,4, "0"), 0);
		}
		
		f_SetMeasUnitByRow(sheetObj, i);
	}
}
/**
 * Yard Combo
 */ 
function com_yd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if(oldCode != newCode){
		loadAccount();
		searchVendor();
		searchVersion();
		f_RemoveAllSheet();
		f_HideSheets();
	}
}
function com_yd_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");
}
/**
 * Vendor Combo
 */
function com_vendor_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	 var formObj=document.form;
	 formObj.vndr_nm.value=comboObj.GetText(newCode, 1);
	 searchVersion();
	 f_RemoveAllSheet();
	 f_HideSheets();
}
/**
 * Version Combo
 */
function ver_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObject=document.form;
	var data=comboObj.GetText(parseInt(comboObj.GetSelectIndex()), 1);	//DT
	formObject.eff_date.value=data;
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem=comboItems[i].split(FIELDMARK);
		if(i == comboObj.GetSelectIndex()){
			if(comboItem[4] == "Y"){	//Compulsory
				formObject.cpls_flg.checked=true;
			} else{
				formObject.cpls_flg.checked=false;				
			}
			break;
		}
	}
	f_RemoveAllSheet();
	f_HideSheets();
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
     param += "&vndr_seq=" + comboObjects[1].GetSelectCode();//Service Provider
     //param += "&combo3="   + formObj.cost_cd.value; //Cost 
     param += "&combo3="   + comboObjects[2].GetSelectCode(); //Cost 
     param += "&year="     + formObj.year.value; 	//Year 
     param += "&uid="      + "0004"; 				//UID 
     //param += "&acct_cd="  + comboObjects[2].GetSelectCode();//Account Code
 	searchVersionXML=sheetObjects[0].GetSearchData("VOP_PSO_0004GS.do", param);
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
		//param += "&cost_cd="  + formObj.cost_cd.value; 	//Cost
		param += "&cost_cd="  + comboObjects[2].GetSelectCode(); 	//Cost
		param += "&year="     + formObj.year.value; 	//Year 
		param += "&uid="      + "0004"; 				//UID
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
/*
 * Copyting Sheet2 to Sheet6
 */
function f_CopyBase2Dummy(oldUk){
	var sXml=f_MakeSearchXml4CopyBase2Dummy(oldUk);
	sheetObjects[5].SetWaitImageVisible(0);
	sheetObjects[5].LoadSearchData(sXml,{Append:1 , Sync:1} );
}
/*
 * Copyting Sheet6 to Sheet2
 */
function f_CopyDummy2Base(uk){
	var sXml=f_MakeSearchXml4CopyDummy2Base(uk); 	
	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
}
/*
 * Deleting sheet2 data in Sheet6
 */
function f_RemoveDummyByBase(uk){
	var xxx=ComFindAll(sheetObjects[5], "sheet6_uk", uk) + "";
	if(xxx == "-1"){
		return;
	}
	var zzz=xxx.split("|");
	if(zzz.length == 0){
		return;
	}
	//UK Deleting
	for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
		sheetObjects[5].RowDelete( i, false );
	}
}
/*
* Deleting all sheets
*/
function f_RemoveAllSheet(){
	var formObj=document.form;
	//Sheets	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	
	document.getElementById("cSur").checked=false;
	document.getElementById("cDis").checked=false;
	document.getElementById("div_surcharge").style.display="none";
	document.getElementById("div_discount").style.display="none";

	//formObj.foml_desc.value = "";
	document.getElementById("foml_desc").innerHTML="";
	//formObj.cond_desc.value = "";
	document.getElementById("cond_desc").innerHTML="";
}
function f_AfterRetrieve(){
	var formObj=document.form;
//	if(formObj.caller.value != "IFRAME"){
		if(sheetObjects[3].RowCount()> 0){
			document.getElementById("cSur").checked=true;
			document.getElementById("div_surcharge").style.display="inline";
		} else{		
			document.getElementById("cSur").checked=false;
			document.getElementById("div_surcharge").style.display="none";
		}
		if(sheetObjects[4].RowCount()> 0){
			document.getElementById("cDis").checked=true;
			document.getElementById("div_discount").style.display="inline";
		} else{		
			document.getElementById("cDis").checked=false;
			document.getElementById("div_discount").style.display="none";
		}
//	}
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
 * 
 */ 
function f_MakeSearchXml4CopyDummy2Base(uk)  {
	 var sheetObj=sheetObjects[5];
	 try {
		 //validation check
//		 if (!sheetObj || sheetObj.IBSheetVersion) {
//			 ComShowMessage("sheet_obj of ComMakeSearchXml is not IBSheet.");
//			 return "";
//		 }
		 var allXml="";
		 var hColSep="|";
		 var sColSep="☜☞";
		 var sColOrder="";
		 var aryTD=new Array(gColumnCountInSheet2);
		 for(var i=0; i < gColumnCountInSheet2; i++){
			 aryTD[i]=sheetObj.ColSaveName(i).replace(/sheet6/g, "sheet2");
		 }
		 sColOrder=aryTD.join(hColSep);
		 allXml="<?xml version='1.0'  ?>\n" 
			 + "<SHEET>\n";
		 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		 var arrRow=new Array();
		 var k=0;
		 for( var i=sheetObj.HeaderRows(); i<sheetObj.RowCount()+ sheetObj.HeaderRows(); i++ ) {
			 if(sheetObj.GetCellValue(i, "sheet6_uk") == uk){
				 arrRow[k]=i;
				 k++;
			 }
		 }
		 if(arrRow.length != 0){
			 var aryTR=new Array(arrRow.length);
			 for(var ir=0; ir<arrRow.length; ir++){
				 for(var ic=0; ic<gColumnCountInSheet2; ic++){
					 aryTD[ic]=String(sheetObj.GetCellValue(arrRow[ir], ic));
				 }
				 aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			 }
			 allXml += aryTR.join("\n");
		 }
		 allXml += "  \n</DATA>\n"
			 +  "</SHEET>";
		 return allXml;
	 } catch(err) { ComFuncErrMsg(err.message); }
}  
/**
 * 
 */ 
function f_MakeSearchXml4CopyBase2Dummy(oldUk)  {
	 var sheetObj=sheetObjects[1];
	 try {
		 //validation check
//		 if (!sheetObj || sheetObj.IBSheetVersion) {
//			 ComShowMessage("sheet_obj of ComMakeSearchXml is not IBSheet.");
//			 return "";
//		 }
		 var allXml="";
		 var hColSep="|";
		 var sColSep="☜☞";
		 var sColOrder="";
		 var aryTD=new Array(gColumnCountInSheet2);
		 for(var i=0; i < gColumnCountInSheet2; i++){
			 aryTD[i]=sheetObj.ColSaveName(i).replace(/sheet2/g, "sheet6");
		 }
		 sColOrder=aryTD.join(hColSep);
		 allXml="<?xml version='1.0'  ?>\n" 
			 + "<SHEET>\n";
		 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		 var arrRow=new Array();
		 for( var i=sheetObj.HeaderRows(); i<sheetObj.RowCount()+ sheetObj.HeaderRows(); i++ ) {
			 arrRow[i-sheetObj.HeaderRows()]=i;
		 }
		 if(arrRow.length != 0){
			 var aryTR=new Array(arrRow.length);
			 for(var ir=0; ir<arrRow.length; ir++){
				 for(var ic=0; ic<gColumnCountInSheet2; ic++){
					 aryTD[ic]=String(sheetObj.GetCellValue(arrRow[ir], ic));
				 }
				 aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			 }
			 allXml += aryTR.join("\n");
		 }
		 allXml += "  \n</DATA>\n"
			 +  "</SHEET>";
		 return allXml;
	 } catch(err) { ComFuncErrMsg(err.message); }
} 

/**
 * process after retrieve sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	if(sheetObjects[0].RowCount() > 0){
		f_CopyDummy2Base(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_uk"));
		sheetObjects[0].SelectCell(sheetObjects[0].HeaderRows(), 0);
	}
	
	f_AfterRetrieve();
}

function loadTerminal() {
 	var formObj = document.form;
 	var sheetObj = sheetObjects[0];
 	
 	comboObjects[0].RemoveAll();
 	//formObj.f_cmd.value = COMMAND01;
 	//var sXml = sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
 	formObj.f_cmd.value = SEARCHLIST01;
 	var sXml = sheetObj.GetSearchData("VOP_PSO_0212GS.do", FormQueryString(formObj));
 	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
 	addComboItem(comboObjects[0], comboItems);
}

function loadAccount() {
	doActionIBCombo(sheetObjects[0], document.form, COMMAND01);
}

function doActionIBCombo(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg = false;
 	switch(sAction) {
 		case COMMAND01:     // Account Combo
 			var param = "";
 			param  = "f_cmd="     	+ sAction;				//Command
 	 		param += "&yd_cd="  	+ formObj.port_cd.value + comboObjects[0].GetSelectCode();
 	 		param += "&year="     	+ formObj.year.value; 	//Year
 	 		param += "&upd_mnu_no=" + "2"; 					//1 : 단순, 2 : 복합 
 	 		//formObj.f_cmd.value = sAction;
 			//formObj.yd_cd.value = formObj.port_cd.value + comboObjects[0].GetSelectCode();
 			sheetObj.WaitImageVisible = false;
 			//var sXml = sheetObj.GetSearchData("VOP_PSO_0036GS.do", FormQueryString(formObj) );
 			var sXml = sheetObj.GetSearchData("VOP_PSO_0036GS.do", param );
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0) 
 				ComXml2ComboItem(arrXml[0], comboObjects[2] , "cost_cd", "cost_cd|cost_nm");
 			
 			//comboObjects[2].SetSelectIndex(-1);
 			//comboObjects[2].SetSelectCode(formObj.cost_cd.value, 1);
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

//Surcharge Grid
function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
  var Row=sheetObj.MouseRow();
  var Col=sheetObj.MouseCol();
  var prefix="sheet4_";
  var sText = "";
  var selColName = sheetObj.CellSaveName (Row, Col);
  sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
  	sheetObj.SetToolTipText(Row,Col,sText);
  }
}


//Discount Grid
function sheet5_OnMouseMove(sheetObj, Button, Shift, X, Y){
  var Row=sheetObj.MouseRow();
  var Col=sheetObj.MouseCol();
  var prefix="sheet5_";
  var sText = "";
  var selColName = sheetObj.CellSaveName (Row, Col);
  sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
  	sheetObj.SetToolTipText(Row,Col,sText);
  }
}


//단위별 포맷을 잡아 준다. pso_meas_ut_cd regular_value
function f_SetMeasUnitByRow(sheetObj, row){
	var sheetid=sheetObj.id;
	var prefix = sheetid + "_";
	switch(sheetid) {
		case "sheet2": 
			var tmpUom 			= sheetObj.GetCellValue(row, prefix+"uom");
			var tmpUomDsp		= sheetObj.GetCellValue(row, prefix + "object_code_dsp");	//UOM
			var tmpRateCode 	= sheetObj.GetCellValue(row, prefix+"rate_code");
			var tmpRangeFormat  = "NullFloat";
			
			if(tmpRateCode == "F"){
				tmpRangeFormat		= "NullFloat";
			}else{
				tmpRangeFormat		= gRateFormat4;
			}
			
			if("TIME" == tmpUomDsp){
				sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Date",Align:"Center",Format:"Hm"} );
				sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Date",Align:"Center",Format:"Hm"} );

				sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat10} );
			}else{
				sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
				sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
				
				sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat10} );
			}
			
			
			break;
		case "sheet3": 
			var tmpUom 			= sheetObj.GetCellValue(row, prefix+"pso_meas_ut_cd");
			
			if(Number(tmpUom) <= 10){
				sheetObj.InitCellProperty(row, prefix + "regular_value",{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
			}else if(Number(tmpUom) == 14){
				sheetObj.InitCellProperty(row, prefix + "regular_value",{ Type:"Date",Align:"Center",Format:"Hm"} );
			}else{
				sheetObj.InitCellProperty(row, prefix + "regular_value",{ Type:"Text",Align:"Center",Format:""} );
			}
			break;
	
	}
}