/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0002.js
*@FileTitle  : Tariff List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
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
var gSheet1_rate_code="";	//setting data before rate type combo change in sheet1
var ENABLE_COMBO_ONCHANGE=true;
var COMBO_ONCHANGE_CODE="";
var WIDTH_FORMULA_POPUP=900;		//VOP_PSO_0209.do Popup 
var HEIGHT_FORMULA_POPUP=500;
var WIDTH_CONDITION_CREATION_POPUP=800;	//VOP_PSO_0206.do Popup
var HEIGHT_CONDITION_CREATION_POPUP=290;
var WIDTH_COPY_POPUP=850;	//VOP_PSO_0211.do Popup
var HEIGHT_COPY_POPUP=700;
var POPUP_IS_MODAL = true;
var POP_TITLE_0206="Formula Condition";		//in case call from VOP_PSO_0004, 'Rate Condition'
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var conditionXML="";
var searchVersionXML="";	//VersionRetrieving Result
var arrFormulaNo=new Array();	//when page load, getting Formula_No IN (1, 2)

var gFormulaFlag = "1";
var gConditonFlag = "2";
var gPointCut5 = 5 ;//소수점 자리수
var gPointCut4 = 4 ;//소수점 자리수
var gPointCut10 = 10 ;//소수점 자리수

var gRateFormat4 = "#,###.####";
var gRateFormat10 = "#,###.##########";
var gRateFormatZero10 = "#,##0.##########";

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
		if (!ComIsBtnEnable(srcName)) return; // 버튼 상태를 확인을 합니다.
		switch(srcName) {
			case "btn_RowAdd":
				if( !validateForm(sheetObject1,formObj,IBSEARCH)) return;
				var prefix="sheet1_";	
				var selectRow=sheetObject1.GetSelectRow();
				if( comboObjects[4].GetSelectText()== "" ) {
					ComShowCodeMessage('PSO00005');
					return;
				}	
				if( sheetObject1.RowCount()== 0 ){	//1st new row
				} else if(sheetObject1.RowCount()> 0){	//from 2nd row
						if( sheetObject1.GetCellValue( sheetObject1.LastRow(), "sheet1_range_from")+"" == ""
						||	sheetObject1.GetCellValue( sheetObject1.LastRow(), "sheet1_range_to")+"" == ""
						||	sheetObject1.GetCellValue( sheetObject1.LastRow(), "sheet1_rate_value")+"" == "" ){
						ComShowCodeMessage('PSO00003');
						return;
					}			
				}
				var iInRow = sheetObject1.DataInsert(-1);
				
				f_SetMeasUnitByRow(sheetObject1, iInRow, "INIT");
				
				sheetObject1.SetHeaderCheck(0, "sheet1_del_chk",0);
				sheetObject1.SetHeaderCheck(1, "sheet1_del_chk",0);
				selectRow=eval(sheetObject1.GetSelectRow());
				sheetObject1.SetCellValue(selectRow, "sheet1_seq",10,0);
				sheetObject1.SetCellValue(selectRow, "sheet1_obj_list_no","",0);//Deleting combo default value
				if( selectRow == sheetObject1.HeaderRows()){	//1st new row
					sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_upd_mnu_cond_no","1",0);//for showing image
					sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_upd_mnu_cond_no_text","1",0);//for showing image
					
					//sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_rate_code","R",0);//for showing image
				} else if( selectRow > sheetObject1.HeaderRows()){	//from 2nd row, copying pre row then showing default data
					sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_obj_list_no",sheetObject1.GetCellValue(sheetObject1.HeaderRows(), "sheet1_obj_list_no"),0);
					sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_rate_code",sheetObject1.GetCellValue(sheetObject1.HeaderRows(), "sheet1_rate_code"),0);
					//sheetObject1.CellValue2(sheetObject1.LastRow, "sheet1_range_from") = ""+(eval(sheetObject1.CellValue(  sheetObject1.LastRow-1 , "sheet1_range_to"))+1);
					sheetObject1.SetCellValue(sheetObject1.LastRow(), "sheet1_object_code_dsp",sheetObject1.GetCellValue(sheetObject1.HeaderRows(), "sheet1_object_code_dsp"),0);
				}
				//Enable to 1st row
				setEnableControl4Columns(sheetObject1, prefix+"obj_list_no|" + prefix+"rate_code|" + prefix+"condition|" + prefix+"upd_mnu_no_cond");
				
				break;
			case "btn_Delete":
				var prefix="sheet1_";	
				var selectRow=eval(sheetObject1.GetSelectRow());
				//Deleting checked row
				for( var i=sheetObject1.LastRow(); i>=sheetObject1.HeaderRows(); i-- ) {
					if(sheetObject1.GetCellValue(i, "sheet1_del_chk") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				if(sheetObject1.LastRow()< sheetObject1.HeaderRows()){
					ComBtnEnable("btn_RowAdd");
				}
				sheetObject1.SetHeaderCheck(0, "sheet1_del_chk",0);
				sheetObject1.SetHeaderCheck(1, "sheet1_del_chk",0);
				break;	
			case "btn_RowAdd2":
				if( !validateForm(sheetObject1,formObj,IBSEARCH)) return;
				sheetObject2.DataInsert(-1);
				//var vals = comboItems2.split("|");
				sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_upd_mnu_no_cond","1",0);
				sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_upd_mnu_no_cond_text","1",0);
				selectRow=eval(sheetObject2.GetSelectRow());
				sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_seq",10*selectRow,0);
				sheetObject2.SetHeaderCheck(0, "sheet2_del_chk",0);
				//Call sheet2_Onchange()
				sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_method_code","",0);
				sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_method_code","A");
				break;
			case "btn_Delete2":	
				//Deleting checked row
				for( var i=sheetObject2.LastRow(); i>=sheetObject2.HeaderRows(); i-- ) {
					if(sheetObject2.GetCellValue(i, "sheet2_del_chk") == 1){
						sheetObject2.RowDelete( i, false );
					}
				}
				sheetObject2.SetHeaderCheck(0, "sheet2_del_chk",0);
				break;
			case "btn_RowAdd3":
				if( !validateForm(sheetObject1,formObj,IBSEARCH)) return;
				sheetObject3.DataInsert(-1);
				//var vals = comboItems2.split("|");
				sheetObject3.SetCellValue(sheetObject3.LastRow(), "sheet3_upd_mnu_no_cond","1",0);
				sheetObject3.SetCellValue(sheetObject3.LastRow(), "sheet3_upd_mnu_no_cond_text","1",0);
				selectRow=eval(sheetObject3.GetSelectRow());
				sheetObject3.SetCellValue(sheetObject3.LastRow(), "sheet3_seq",10*selectRow,0);
				sheetObject3.SetHeaderCheck(0, "sheet3_del_chk",0);
				//Call sheet3_Onchange()
				sheetObject3.SetCellValue(sheetObject3.LastRow(), "sheet3_method_code","",0);
				sheetObject3.SetCellValue(sheetObject3.LastRow(), "sheet3_method_code","A");
				break;
			case "btn_Delete3":	
				//Deleting checked row
				for( var i=sheetObject3.LastRow(); i>=sheetObject3.HeaderRows(); i-- ) {
					if(sheetObject3.GetCellValue(i, "sheet3_del_chk") == 1){
						sheetObject3.RowDelete( i, false );
					}
				}
				sheetObject3.SetHeaderCheck(0, "sheet3_del_chk",0);
				break;
			case "btn_port_cd":
				var sUrl="/opuscntr/VOP_VSK_0043.do?op=0043";
				ComOpenPopup(sUrl, 850, 510, "setPortCd", "0,0", true);
				break;
			case "btns_VendorSeq":
				//ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 430, 'setVendorSeq', '1,0,1,1,1', true);
				ComOpenPopup('/opuscntr/VOP_PSO_0205.do', 600, 470, 'setVendorSeq', '0,0', true, true);
				break;
			case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal=new ComCalendar();
                cal.select(formObj.from_date, 'yyyy-MM-dd');

			break;
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal=new ComCalendar();
                cal.select(formObj.to_date, 'yyyy-MM-dd');
			break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObj,IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1,formObj,IBCLEAR);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject1,formObj,IBSAVE);
				break;
			case "btn_DataDelete":			
				doActionIBSheet(sheetObject1,formObj,IBDELETE);	
				break;
			case "btn_Copy":
				if( formObj.port_cd.value == '' || formObj.port_cd.value.length != 5) {
					ComShowCodeMessage("PSO00003", "[Port]");	
					formObj.port_cd.focus();
					return; 
				}	
				if( comboObjects[2].GetSelectCode()== '' ) {
					ComShowCodeMessage("PSO00003", "[Account/Cost]");	
					//formObj.vndr_seq.focus();
					return; 
				}	
				if( formObj.vndr_seq.value == '' ) {
					//ComShowCodeMessage("PSO00003", "[Service Provider]");	
					formObj.vndr_seq.focus();
					return; 
				}	
 				var param="port_cd="   + formObj.port_cd.value;
 				    param += "&yd_cd="    + comboObjects[0].GetSelectCode(); 
 				    param += "&acct_cd="  + comboObjects[1].GetSelectCode();
 				    param += "&acct_nm="  + formObj.account_nm.value;
 				    param += "&cost_cd="  + comboObjects[2].GetSelectCode();
 				    param += "&cost_nm="  + formObj.lgs_cost_nm.value;
 				    param += "&vndr_seq=" + Number(formObj.vndr_seq.value);
 				    param += "&vndr_nm="  + formObj.vndr_lgl_eng_nm.value;
				var sUrl="/opuscntr/VOP_PSO_0211.do?" + param;
				//ComOpenPopup(sUrl, 800, 474, "setPso0211", "0,0", false, false);
				var sFeatures="toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_COPY_POPUP + ",height=" + HEIGHT_COPY_POPUP;
				ComOpenPopup(sUrl, WIDTH_COPY_POPUP, HEIGHT_COPY_POPUP, "copyCallBack", "0,0", false);
				//ComOpenWindow(sUrl, "COPY1", sFeatures, false);
				break;
				
			case "btn1_Tariff_Inquiry":
				moveToUpdate();
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

function setPortCd(rVal) {
	var formObj = document.form;
	if(rVal != undefined && rVal != "" && rVal != formObj.port_cd.value){
		formObj.port_cd.value = rVal;
		loadTerminal();				//COMBO YARD
		f_SetComboAccount(rVal);	//COMBO ACCOUNT		
		f_RemoveAllSheet();
	}
}

function loadTerminal() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	//Initializing combo
	comboObjects[0].RemoveAll();
	formObj.f_cmd.value=COMMAND01;
	var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
	var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(comboObjects[0], comboItems);
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
	//Version Combo
	//comboObjects[3].SetEnable(0);
	initControl(sheetObjects[0]);  
	
	//xsheet1_OnLoadFinish(sheetObjects[0]);
	//xsheet2_OnLoadFinish(sheetObjects[1]);
	sheet1_OnLoadFinish(sheetObjects[0]);
	sheet2_OnLoadFinish(sheetObjects[1]);
	sheet3_OnLoadFinish(sheetObjects[2]);
	resizeSheet();
}
function initControl(sheetObj){
	formObj=document.form;
	//setToday(formObj.from_date);
	formObj.to_date.value='9999-12-31';
    //setToday(formObj.to_date);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('click', 'obj_click', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
}
/**
 * setting combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */ 
function initCombo(comboObj, comboNo) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	switch(comboNo) {  
		case 1:		//Yard 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "300");
				SetDropHeight(190);
				SetMaxLength(2);
				ValidChar(2,1);
			}
			break; 
		case 2:		//Account  
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
		case 3:		//Cost 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
			}
			break; 			
		case 4:		//Version()
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
			}
			break; 			
		case 5:		//Currency 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(3);
				ValidChar(2);
			}
			break; 			
	} 
}
/**
 * Adding data to combo (Currency)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
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
 * Adding data to combo (Account)
 * in case of EGSCA,PAPCA Port, Showing 511911 Account
 */	 
function addComboItemAccount(isCanal) {
	comboObjects[1].RemoveAll();
	var comboItem="";
	if(isCanal == "CANAL_X"){			//not Canal
 	 	var comboItems=ComGetEtcData(conditionXML, "account").split(ROWMARK);
 		for (var i=0 ; i < comboItems.length ; i++) {
 			comboItem=comboItems[i].split(FIELDMARK);
 			
 			var nIdx = comboObjects[1].FindItem(comboItem[1], 0, true);		 
 			if( nIdx == -1) { // 찾기 실패한 경우 -1 반환
 				//acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
 				comboObjects[1].InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
 			}
 		}   
 	} else if(isCanal == "CANAL_O"){	//Canal
 		var canalComboItems = ComGetEtcData(conditionXML, "accountForCanal").split(ROWMARK);
		for (var i=0 ; i < canalComboItems.length ; i++) {
			comboItem=canalComboItems[i].split(FIELDMARK);
			
			var nIdx = comboObjects[1].FindItem(comboItem[1], 0, true);		 
 			if( nIdx == -1) { // 찾기 실패한 경우 -1 반환
 				//acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
 				comboObjects[1].InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
 			}
		} 
 	}
	
	comboObjects[1].SetSelectIndex(0);
}
/**
 * Adding data to combo (Cost)
 */	
function addComboItemCost(code) {	
	comboObjects[2].RemoveAll();
	//var accountItems=ComGetEtcData(conditionXML, "account" ).split(ROWMARK);
	var accountItem="";
	var costItems=ComGetEtcData(conditionXML, "cost" ).split(ROWMARK);
	var costItem="";
	
	var portCd = document.form.port_cd.value;
	var canalKey = "";
	if( gf_GetCanalPort(portCd)){
		canalKey = "CN";
	}else{
		canalKey = "PT";
	}

 	for (var i=0 ; i < costItems.length ; i++) {
 		costItem=costItems[i].split(FIELDMARK);
 		if(costItem[2] == code && canalKey == costItem[3]){
 			
 			var nIdx = comboObjects[2].FindItem(costItem[0], 0, true);		 
 			if( nIdx == -1) { // 찾기 실패한 경우 -1 반환
 				comboObjects[2].InsertItem(-1, costItem[0] + "|" + costItem[1], costItem[0]);
 			}
 		}
 	}
 	
 	comboObjects[2].SetSelectIndex(0);
} 
/**
 * Adding data to combo (Object/Method in Sheets)
 */	
function makeItemObject(comboItems) {	
	//var comboItems = ComGetEtcData(conditionXML, "objlist");
	var comboCode="";
	var comboText="";
	arrComboItems=comboItems.split("|");
	var preCode="";
	for (i=0 ; i < arrComboItems.length ; i++) {
		var comboItem=arrComboItems[i].split(",");
 		//comboItem[0] : PSO_OBJ_CD                       
 		//comboItem[1] : PSO_OBJ_CD_DSP                   
 		//comboItem[2] : PSO_MEAS_UT_CD                   
 		//comboItem[3] : PSO_MEAS_UT_CD_DSP               
 		//comboItem[4] : OBJ_LIST_NO        
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
		case "port_cd":
			if(eleObj.value.length == 5){
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			} else{
				comboObjects[0].RemoveAll();
			}
			f_RemoveAllSheet();
			break;
		case "from_date":
			if(eleObj.value.length == 8){
				//formObj.to_date.focus();
			}
			break; 
		case "to_date":
			if(eleObj.value.length == 8){
				//formObj.port_cd.focus();
			}
			break;
		case "org_vndr_nm":
			document.getElementById("info_byte").innerHTML = "("+ComGetLenByByte(formObj.org_vndr_nm) +" Byte)";
			ComChkObjValid(event.srcElement);
			break;
	}
}
function obj_paste(){
	var eleObj=ComGetEvent();
	var formObj=document.form;
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");
			break;
		case "vndr_seq":
			gf_SetControlPastePattern(event, "0");
			break;			
		case "from_date":
			gf_SetControlPastePattern(event, "0");
			break;			
		case "to_date":
			gf_SetControlPastePattern(event, "0");
			break;			
	}
}
function obj_drop(){
	event.returnValue=false;
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
	      
		      	var HeadTitle1="||Seq.|Object|Unit of Measure|Rate Type|Range|Range|Currency|Rate|Regular\nValue|Formula Condition|Formula Condition|Formula Condition|text|Alias|||Compulsory";
		      	var HeadTitle2="||Seq.|Object|Unit of Measure|Rate Type|From|To|Currency|Rate|Regular\nValue|ID|Description||text|Alias|||Compulsory";
		      	var headCount=ComCountHeadTitle(HeadTitle1);
		      	var prefix="sheet1_";
		
		      	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		      	var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      	var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      	InitHeaders(headers, info);
		
		      	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"obj_list_no" },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"object_code_dsp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rate_code" },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10, PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"regular_value",   KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:5,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"condition",       KeyField:0 },
	             {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	             {Type:"Image",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_mnu_no_cond_text"},
	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1, 	EditLen:500 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"object_name" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"uom" },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cpls_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
		      	InitColumns(cols);
		      	SetSheetHeight(200);
		      	SetEditable(1);
		      	SetImageList(0,"img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X)
		      	SetImageList(1,"img/btng_condition.gif");//
		      	SetImageList(2,"img/btng_condition_h.gif");//
			    SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
		      	SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Range2\tRangeRateOnly|Fixed\tObjectXFixedRate", ComboCode:"R|S|F"} );
		      	SetShowButtonImage(1);
			}
			break;
		case "sheet2":
		    with(sheetObj){
	        
		      var HeadTitle1="||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|text|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet2_";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10, UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		             {Type:"Image",     Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond_text"},
		             {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1, 	EditLen:500 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(152);
		      SetImageList("0","img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X)
		      SetImageList("1","img/btng_condition.gif");//
		      SetImageList("2","img/btng_condition_h.gif");//
		      SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1); 
		      SetColProperty(prefix+"formula_no" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
	      }
	
	
			break;
		case "sheet3":
		    with(sheetObj){
	       
		      var HeadTitle1="||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|text|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet3_";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10, UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		             {Type:"Image",     Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond_text"},
		             {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1, 	EditLen:500 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(152);
		      //resizeSheet(sheetObj);
		      SetEditable(1);
		      SetImageList("0","img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X)
		      SetImageList("1","img/btng_condition.gif");//
		      SetImageList("2","img/btng_condition_h.gif");//
		      SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1);
		      SetColProperty(prefix+"formula_no" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
	      }
	
	
			break;
		case "sheet4":	//Dummy Sheet that is not initialized
			 sheetObj.SetVisible(false);
			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction, selValue, gubun) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet3_" );        
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			if( !validateForm(sheetObj,formObj,sAction)) return;
			ComBtnEnable("btn_RowAdd");
			formObj.f_cmd.value=SEARCH;//COMBO
			f_RemoveAllSheet();
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			for(var i=0; i < arrXml.length; i++){ 
				if(i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}  
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
			}
			//Enable to 1st row
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"obj_list_no|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"condition|" + aryPrefix[0]+"upd_mnu_no_cond");
			f_ShowHideSheet();
			ComOpenWait(false);
		break;
		case IBSEARCH_ASYNC01:	//Setting conditions
			var prefix="sheet1_";
			var aryPrefix=new Array( "sheet1_" );
			formObj.f_cmd.value=SEARCHLIST01;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			sheetObjects[0].SetWaitImageVisible(0);
			conditionXML=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var arrXml=conditionXML.split("|$$|");
			//Object Setting in Sheets
			var comboItems=ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject=makeItemObject(comboItems);
			//Object Combo Setting of Base Sheet
			sheetObjects[0].SetColProperty("sheet1_obj_list_no", {ComboText:arrCodeTextObject[1], ComboCode:arrCodeTextObject[0]} );
			//Initializing combo (Account)
			comboObjects[1].RemoveAll();
			//Initializing combo (Cost)
			comboObjects[2].RemoveAll();
			//Initializing combo (Currency)
			//var localCurrency = ComGetEtcData(conditionXML, "localCurrency" );
			comboObjects[4].RemoveAll();
			var arrComboItem=ComGetEtcData(conditionXML, "currency").split(ROWMARK);
			addComboItem(comboObjects[4],arrComboItem);
			//comboObjects[4].Code2 = localCurrency;
			//
			var arrFormula4Loading=ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k=0;
			for(i=0; i<arrFormula4Loading.length; i++){
				var arrKeyVal=arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k]=arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
		break;
		case IBSAVE:        //Save
			formObj.f_cmd.value = MULTI;
			if (!validateForm(sheetObj,formObj,sAction)) return;
			var sParam=ComGetSaveString(sheetObjects, true, true);	//Transmitting all rows
			if (sParam == "") return;
			formObj.yd_chg_ver_seq.value=comboObjects[3].GetSelectCode();
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0002GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			//sheetObjects[0].RenderSheet(1);
			//sheetObjects[1].RenderSheet(1);
			//sheetObjects[2].RenderSheet(1);
			ComOpenWait(false);
			
			ComOpenWait(true);
			searchVersion();
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	
			ComOpenWait(false);
		break;
		case IBCLEAR:  
			//Port
			formObj.port_cd.value="";
			comboObjects[0].RemoveAll();
			//Account
			comboObjects[1].RemoveAll();
			formObj.account_nm.value="";
			//Cost
			comboObjects[2].RemoveAll();
			formObj.lgs_cost_nm.value="";
			//Service Provider
			formObj.vndr_seq.value="";
			formObj.vndr_lgl_eng_nm.value="";
			//Origin
			formObj.org_vndr_nm.value="";
			//Date
			//setToday(formObj.from_date);
			formObj.from_date.value="";
			formObj.to_date.value="9999-12-31";
			//setToday(formObj.to_date);
			//Version
			comboObjects[3].RemoveAll();
			//Currency
			//comboObjects[4].Code2 = ComGetEtcData(conditionXML, "localCurrency" );	
			comboObjects[4].SetSelectCode("",false);
			//Sheets	
			f_RemoveAllSheet("IBCLEAR");
		break;        
		case IBDELETE:      //Deleting data
			//formObj.f_cmd.value = COMMAND03;
			formObj.f_cmd.value=REMOVE;
			if(!validateForm(sheetObj,formObj,sAction)) return;
			if(!confirm(msgs["PSO00020"])) return;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sParam=FormQueryString(formObj);
			var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0002GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			//sheetObjects[0].RenderSheet(1);
			//sheetObjects[1].RenderSheet(1);
			//sheetObjects[2].RenderSheet(1);
			searchVersion();
			//doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			f_RemoveAllSheet("IBCLEAR");
			ComOpenWait(false);
		break;
		case COMMAND05:	//Port Code [keyup:5 length]  
		    formObj.f_cmd.value=COMMAND05;	//
			var param=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var isPort=ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal=formObj.port_cd.value;
				loadTerminal();
				f_SetComboAccount(rVal);	
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value="";
				formObj.port_cd.focus();
			}
		break;
		case COMMAND06:	//Service Provider   
			formObj.f_cmd.value=COMMAND06;//
			var param=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var spName=ComGetEtcData(sXml, "spName");	//Service Provider Name
			formObj.vndr_lgl_eng_nm.value=spName;
			if(spName != ""){
			} else{
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				//formObj.vndr_seq.focus();
				formObj.vndr_seq.value="";
			}
		break;		
		case COMMAND08:      // After COPY, Retrieving
			//data from Copy Popup
			var param=formObj.copy_condition.value;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			
			for(var i=0; i < arrXml.length; i++){ 
				sheetObjects[i].RemoveAll();
				//sheetObjects[i].RenderSheet(0);
				if(i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}  
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				//sheetObjects[i].RenderSheet(1);
			}
			//Enable to 1st row
			setEnableControl4Columns(sheetObjects[0], aryPrefix[0]+"obj_list_no|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"condition|" + aryPrefix[0]+"upd_mnu_no_cond");
			f_ShowHideSheet();
			ComOpenWait(false);
		break;
		
		case IBSEARCH_ASYNC02: // 2015.02.15 ADD
			var param = "";
		        param += "f_cmd="+COMMAND02;
			    param += "&formcond="+gubun;
			    param += "&combo1="+selValue;
			var sXml=sheetObj.GetSearchData("VOP_PSO_0209GS.do", param);
			var arrRowData=ComGetEtcData(sXml, "ROW_DATA");
			
			return arrRowData;
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
				//Port
				if(port_cd.value.length < 5){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
				//Yard
				if( comboObjects[0].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00008');
					return false;
				}	
				//Yard	
				//if( comboObjects[0].Code.split(",").length > 1 ){
				//	ComShowCodeMessage('PSO00006');
				//	return false;
				//}	
				//Account
				if( comboObjects[1].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Account]");	//mandatory
					return false;
				}					
				//Cost
				if( comboObjects[2].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Cost CD]");	//mandatory
					return false;
				}	
				//Service Provider
				if(vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					//vndr_seq.focus();
					return false;
				}					
				if(from_date.value == ''){
					ComShowCodeMessage('PSO00009');
					from_date.focus();
					return false;
				}	
				if(to_date.value == ''){
					ComShowCodeMessage('PSO00009');
					to_date.focus();
					return false;
				}	
				//Ver.	
				if( comboObjects[3].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Version()]");	//mandatory
					return false;
				}	
				//Currency	
				if( comboObjects[4].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Currency]");	//mandatory
					return false;
				}	
				break;
			case IBSAVE:	
				if(port_cd.value == ''){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
				if( comboObjects[0].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00008');
					return false;
				}	
				if( comboObjects[0].GetSelectCode().split(",").length > 1 ){
					ComShowCodeMessage('PSO00006');
					return false;
				}	
				//Account
				if( comboObjects[1].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Account]");	//mandatory
					return false;
				}	
				//Cost
				if( comboObjects[2].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00010');
					return false;
				}	
				if(comboObjects[4].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00013');
					from_date.focus();
					return false;
				}	
				if(from_date.value == ''){
					ComShowCodeMessage('PSO00009');
					from_date.focus();
					return false;
				}	
				if(to_date.value == ''){
					ComShowCodeMessage('PSO00009');
					to_date.focus();
					return false;
				}	
				if( vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					//vndr_seq.focus();
					return false;
				}	
				if( comboObjects[3].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00012');
					return false;
				}	
				if( sheetObjects[0].LastRow()< sheetObjects[0].HeaderRows()){
					ComShowCodeMessage('PSO00017');
					return false;
				}
				var iLastRow = sheetObjects[0].LastRow()+1;
				
				for(var i=sheetObjects[0].HeaderRows(); i < iLastRow; i++){
					var prefix1="sheet1_";
					var object			= sheetObjects[0].GetCellValue(i, prefix1 + "obj_list_no");
					var rate_code		= sheetObjects[0].GetCellValue(i, prefix1 + "rate_code");
					var rangeFrom 		= sheetObjects[0].GetCellValue(i, prefix1 + "range_from") + "";
					var range_from 		= rangeFrom.replace(/[,:]/g, "");
					var rangeTo 		= sheetObjects[0].GetCellValue(i, prefix1 + "range_to") + "";
					var range_to 		= rangeTo.replace(/[,:]/g, "");
					var rate_value		= sheetObjects[0].GetCellValue(i, prefix1 + "rate_value")+"";
					var regular_value	= sheetObjects[0].GetCellValue(i, prefix1 + "regular_value");
					var object_code_dsp	= sheetObjects[0].GetCellValue(i, prefix1 + "object_code_dsp");
					if(i == sheetObj.HeaderRows()){
						/*
					     *     ret = ComTrim("   121323    "); //rslt : "121323"
					     *     ret = ComTrim("*121323*", "*"); //rslt : "121323"
					     */
						if(ComTrim(object) == ""){
							ComShowCodeMessage("PSO00003", "[Base : Object]");	//mandatory
							return false;
						}
					}
					if(rate_code != "F" && range_from == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range From]");	//mandatory
						return false;
					}
					if(rate_code != "F" && range_to == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range To]");	//mandatory
						return false;
					}
					if(rate_value == ""){
						ComShowCodeMessage("PSO00003", "[Base : Rate]");	//mandatory
						return false;
					}
					if(Number(range_from) > Number(range_to)){
						ComShowCodeMessage("PSO00018", "[Base : Range To]", "[Base : Range From]");
						return false;
					}
					
					if(object_code_dsp == "TIME" && rate_code == "R"){
						//PSO01014  'Range2' or 'Fixed' type only allowed in the case of 'TIME' unit object.
						ComShowCodeMessage("PSO01014");
						return false;
					}
					
				}
				//Surcharge
				if(sheetObjects[1].RowCount()> 0){
					for(i=1; i<sheetObjects[1].RowCount()+1; i++){
						var prefix2="sheet2_";
						var method_code=sheetObjects[1].GetCellValue(i, prefix2 + "method_code");
						var rate_value=sheetObjects[1].GetCellValue(i, prefix2 + "rate_value")+"";
						var formula_no=sheetObjects[1].GetCellValue(i, prefix2 + "formula_no");
						if(ComTrim(method_code) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Method]");	//mandatory
							return false;
						}
						if(ComTrim(rate_value) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Rate]");	//mandatory
							return false;
						}
						if(ComTrim(formula_no) == ""){
							ComShowCodeMessage("PSO00003", "[Surcharge : Formula ID]");	//mandatory
							return false;
						}
					}
				}
				//Discount
				if(sheetObjects[2].RowCount()> 0){
					for(i=1; i<sheetObjects[2].RowCount()+1; i++){
						var prefix3="sheet3_";
						var method_code=sheetObjects[2].GetCellValue(i, prefix3 + "method_code");
						var rate_value=sheetObjects[2].GetCellValue(i, prefix3 + "rate_value")+"";
						var formula_no=sheetObjects[2].GetCellValue(i, prefix3 + "formula_no");
						if(ComTrim(method_code) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Method]");	//mandatory
							return false;
						}
						if(ComTrim(rate_value) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Rate]");	//mandatory
							return false;
						}
						if(ComTrim(formula_no) == ""){
							ComShowCodeMessage("PSO00003", "[Discount : Formula ID]");	//mandatory
							return false;
						}
					}
				}
				break;
			case IBDELETE: 
				if(port_cd.value == ''){
					ComShowCodeMessage('PSO00007');
					port_cd.focus();
					return false;
				}	
				if( comboObjects[0].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00008');
					return false;
				}	
				if(vndr_seq.value == ''){
					ComShowCodeMessage('PSO00011');
					//vndr_seq.focus();
					return false;
				}	
				if( comboObjects[3].GetSelectCode()== ''){
					ComShowCodeMessage('PSO00012');
					return false;
				}	
				break;
		}      
	}
	return true;
}
/********************************************************************************************************************
 * 1. Getting data for Combo
 * 2. in case from VOP_PSO_0036, Setting Conditions and Retrieving
 ********************************************************************************************************************/
function sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//Version Combo
	//comboObjects[3].SetEnable(0);
	formObj.port_cd.focus();
	//in case from VOP_PSO_0036
	var movedFrom=formObj.moved_from.value;
	var movedParams=formObj.moved_params.value;
	if(movedFrom != ""){
		if(movedParams != ""){
			f_RetrieveMovedFrom(movedParams);	
		}
	}
	formObj.moved_from.value="";
}
function sheet1_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellImage(i, "sheet1_upd_mnu_no_cond", sheetObj.GetCellValue(i, "sheet1_upd_mnu_no_cond_text"));
		
		f_SetMeasUnitByRow(sheetObj, i);
		
		//sheetObj.InitCellProperty(i, "sheet1_rate_value",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		//sheetObj.InitCellProperty(i, "sheet1_regular_value",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	}
}
function sheet2_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellImage(i, "sheet2_upd_mnu_no_cond", sheetObj.GetCellValue(i, "sheet2_upd_mnu_no_cond_text"));
	}
}
function sheet2_OnLoadFinish(sheetObj){
	if(sheetObj.RowCount() == 0){
		document.getElementById("div_surcharge").style.display="none";
	}
}
function sheet3_OnLoadFinish(sheetObj){
	if(sheetObj.RowCount() == 0){
		document.getElementById("div_discount").style.display="none";
	}
}
/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "condition" :				//Condition popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			//ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition1', 'none', true, false, Row, Col, 1); 
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition1', '0,0', POPUP_IS_MODAL, false, Row, Col, 1); 
		break;	 
	}
}
/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula2', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	 
		case prefix + "condition" :				//Condition popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition2', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	 
	}
}
/**
 * IBSheet Popup Event
 */
function sheet3_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet3_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula3', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	 
		case prefix + "condition" :				//Condition popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition3', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	 
	}
}
function setCondition1(aryPopupData, row, col, sheetIdx){
	var prefix="sheet1_";
	var sheetObj=sheetObjects[0];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	var riceStore=aryPopupData[0][7];	
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"condition","",0);
		sheetObj.SetCellValue(row,prefix+"cond_desc","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"condition",code,0);
		sheetObj.SetCellValue(row,prefix+"cond_desc",name,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond",riceStore,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text",riceStore,0);
	}
}
function setFormula2(aryPopupData, row, col, sheetIdx){
	var prefix="sheet2_";
	var sheetObj=sheetObjects[1];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"formula_no","",0);
		sheetObj.SetCellValue(row,prefix+"foml_desc","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"formula_no",code,0);
		sheetObj.SetCellValue(row,prefix+"foml_desc",name,0);
	}
}
function setCondition2(aryPopupData, row, col, sheetIdx){
	var prefix="sheet2_";
	var sheetObj=sheetObjects[1];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	var riceStore=aryPopupData[0][7];	
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"condition","",0);
		sheetObj.SetCellValue(row,prefix+"cond_desc","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"condition",code,0);
		sheetObj.SetCellValue(row,prefix+"cond_desc",name,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond",riceStore,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text",riceStore,0);
	}
}
function setFormula3(aryPopupData, row, col, sheetIdx){
	var prefix="sheet3_";
	var sheetObj=sheetObjects[2];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"formula_no","",0);
		sheetObj.SetCellValue(row,prefix+"foml_desc","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"formula_no",code,0);
		sheetObj.SetCellValue(row,prefix+"foml_desc",name,0);
	}
}
function setCondition3(aryPopupData, row, col, sheetIdx){
	var prefix="sheet3_";
	var sheetObj=sheetObjects[2];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	var riceStore=aryPopupData[0][7];	
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"condition","",0);
		sheetObj.SetCellValue(row,prefix+"cond_desc","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond","",0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"condition",code,0);
		sheetObj.SetCellValue(row,prefix+"cond_desc",name,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond",riceStore,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text",riceStore,0);
	}
}
/**
 * 
 */
var sheet1_newCond_row;
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :				//Condition Creation popup
			var riceStore=sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//Condition from 0007
				return; 
			}
			if(sheetObj.HeaderRows()== Row){
				var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
				var sUrl="/opuscntr/VOP_PSO_0206.do?type=B&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
					sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
				//var rVal = ComOpenPopupWithTarget(surl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "", "0,0", false, false, Row, Col, 0);
				sheet1_newCond_row = Row;
				ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "setNewCondition", "1,0,1,1,1,1,1", true);
			}
		break;
		case prefix + "del_chk" :				
			if(sheetObj.HeaderRows()== Row){
				//Handling data from 2nd row
				if(sheetObj.GetCellValue(Row, prefix + "del_chk")){
					for(i=sheetObj.HeaderRows()+1; i<sheetObj.LastRow()+1; i++){
						sheetObj.SetCellValue(i, prefix + "del_chk",0,0);
					}
				} else{
					for(i=sheetObj.HeaderRows()+1; i<sheetObj.LastRow()+1; i++){
						sheetObj.SetCellValue(i, prefix + "del_chk",1,0);
					}
				}			
			} else{
				if(sheetObj.GetCellValue(Row, prefix + "del_chk") == 1){
					sheetObj.SetCellValue(sheetObj.HeaderRows(), prefix + "del_chk",0,0);
				}
			}
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
		break;
	}
}

function setNewCondition(rtnVal){
	if(rtnVal != undefined){
		sheetObjects[0].SetCellValue(sheet1_newCond_row, "sheet1_condition",rtnVal.split("||")[0],0);
		sheetObjects[0].SetCellValue(sheet1_newCond_row, "sheet1_cond_desc",rtnVal.split("||")[1],0);
	}
}
/**
 * 
 */
function sheet2_OnClick(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet2_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :	//Condition Creation Popup
			var riceStore=sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//Condition from 0007
				return; 
			}
			var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
			var sUrl="/opuscntr/VOP_PSO_0206.do?type=S&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
			sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
			
			gSheet2SelRow = Row;
			ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "SetConditionSheet2", "0,1", true);
 			
			/*var newCondNoAndCondDesc=ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
			if(newCondNoAndCondDesc != undefined){
				sheetObj.SetCellValue(Row, prefix + "condition",newCondNoAndCondDesc.split("||")[0],0);
				sheetObj.SetCellValue(Row, prefix + "cond_desc",newCondNoAndCondDesc.split("||")[1],0);
			}*/
		break;
		case prefix + "del_chk" :			
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
		break;	
	}
}

var gSheet2SelRow = "";
function SetConditionSheet2(val){
	var prefix="sheet2_";
	sheetObj = sheetObjects[1]; 
	if("" != gSheet2SelRow && val != undefined){
		sheetObj.SetCellValue(gSheet2SelRow, prefix + "condition",val.split("||")[0],0);
		sheetObj.SetCellValue(gSheet2SelRow, prefix + "cond_desc",val.split("||")[1],0);
		
		gSheet2SelRow = "";
	}
}
/**
 * IBSheet OnClick Event
 */
function sheet3_OnClick(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet3_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond" :	//Condition Creation Popup
			var riceStore=sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//Condition from 0007
				return; 
			}
			var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
			var sUrl="/opuscntr/VOP_PSO_0206.do?type=D&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
			sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
			
			gSheet3SelRow = Row;
			ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "SetConditionSheet3", "0,1", true);
 			
			/*var newCondNoAndCondDesc=ComOpenWindowCenter(sUrl, "xxx", WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, true);
			if(newCondNoAndCondDesc != undefined){
				sheetObj.SetCellValue(Row, prefix + "condition",newCondNoAndCondDesc.split("||")[0],0);
				sheetObj.SetCellValue(Row, prefix + "cond_desc",newCondNoAndCondDesc.split("||")[1],0);
			}*/
		break;
		case prefix + "del_chk" :			
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
		break;	
	}
}

var gSheet3SelRow = "";
function SetConditionSheet3(val){
	var prefix="sheet3_";
	sheetObj = sheetObjects[2]; 
	if("" != gSheet3SelRow && val != undefined){
		sheetObj.SetCellValue(gSheet3SelRow, prefix + "condition",val.split("||")[0],0);
		sheetObj.SetCellValue(gSheet3SelRow, prefix + "cond_desc",val.split("||")[1],0);
		
		gSheet3SelRow = "";
	}
}
/**
 * Yard
 */
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var comboObj = combo1;
	form.combo1_text.value = comboObj.GetSelectCode();
	searchVersion();
	f_RemoveAllSheet();
}
function combo1_OnKeyDown(comboObj, KeyCode, Shift){
	
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");
	if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
	}
} 
/**
 * Account CD
 */
function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
	var formObj=document.form;
	formObj.account_nm.value=combo2.GetText(parseInt(comboObj.GetSelectIndex()), 1);
	//Cost Combo Setting
	addComboItemCost(comboObj.GetSelectCode());
	searchVersion();
	f_RemoveAllSheet();
	if(comboObj.GetSelectIndex()< 0){
		combo3_OnChange();
	}
}
/**
 * in case Combo Key-In or Copy&Paste, Setting input string type
 */ 
function combo2_OnKeyDown(comboObj, KeyCode, Shift){
	//document.form.vndr_lgl_eng_nm.value = "combo2_OnKeyDown : " + String.fromCharCode(KeyCode) + " : " + KeyCode;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
}  
/**
 * Cost CD
 */
function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var comboObj = combo3;
	var formObj=document.form; 
	var tmpCostNm = combo3.GetText(parseInt(comboObj.GetSelectIndex()), 1);
	if(tmpCostNm == undefined || tmpCostNm == ""){
		formObj.lgs_cost_nm.value = "";
	}else{
		formObj.lgs_cost_nm.value= tmpCostNm;
	}
	//formObj.lgs_cost_nm.value=combo3.GetText(parseInt(comboObj.GetSelectIndex()), 1);
	searchVersion();
}
function combo3_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");
}  
/**
 * Version
 */
function combo4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	var curIdx = parseInt(newIndex);
	var localCurrency=ComGetEtcData(searchVersionXML, "localCurrency" );
	//comboObj.GetSelectIndex() changed to newIndex
	
	var data=comboObj.GetText(curIdx, 1).split("~");	//DT
	formObj.from_date.value=data[0];
	formObj.to_date.value=data[1];
	
	var curr_cd=comboObj.GetText(curIdx, 2);					//CURR_CD
 	if(curr_cd == "" || "undefined" == curr_cd) curr_cd=localCurrency;						//in case Currency of Version()is null, Local Currency
 	if(curr_cd == "" || "undefined" == curr_cd) curr_cd="USD";								//in case local currency is null, "USD"
 	if(comboObjects[4].GetText(curr_cd, 0) == "") curr_cd="USD";	//in case combo is null, "USD"
	comboObjects[4].SetSelectCode(curr_cd);
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	for(i=0; i<comboItems.length; i++){
		var comboItem=comboItems[i].split(FIELDMARK);
		if(i == curIdx){
			//선택된 Tariff No을 교체한다.
			formObj.yd_chg_no.value = comboItem[0]; //  yd_chg_no
			
			if(comboItem[4] == "Y"){	//Compulsory
				formObj.cpls_flg.checked=true;
			} else{
				formObj.cpls_flg.checked=false;				
			}
			if(comboItem[5] == ""){		//Delete Button
				ComBtnEnable("btn_DataDelete");		
			} else{						//in case Invoice Create, Activate to Delete Button
				ComBtnDisable("btn_DataDelete");
			}
			if(comboItem[6] != undefined && comboItem[6] != ""){
				/*
				var arrOrg=new Array();
				for(k=6; k<comboItem.length; k++){
					arrOrg[k-6]=comboItem[k];
				}
				formObj.org_vndr_nm.value=arrOrg.join(",");
				*/
				formObj.org_vndr_nm.value=comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
			} else{
				formObj.org_vndr_nm.value="";
			}
			
			document.getElementById("info_byte").innerHTML = "("+ComGetLenByByte(formObj.org_vndr_nm) +" Byte)";
			//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			break;
		}
	}
}
/*
 * Currency
 */ 
function combo5_OnKeyDown(comboObj, KeyCode, Shift){
	 gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");
}   
/**
 * Version Retrieving
 */
function searchVersion(period){
	var formObj=document.form;
	comboObjects[3].RemoveAll();
	formObj.f_cmd.value=COMMAND02;
	var port_cd=formObj.port_cd.value;
	var yard_cd=comboObjects[0].GetSelectCode();
	var acct_cd=comboObjects[1].GetSelectCode();
	var cost_cd=comboObjects[2].GetSelectCode();
	var vndr_seq=formObj.vndr_seq.value;
	if(port_cd == "" || yard_cd == "" || acct_cd == "" || cost_cd == "" || vndr_seq == ""){
		//return;
	}
	//1.Combo OnChange
	//searchVersionXML = sheetObjects[0].GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
	//2.Combo OnChange, using dummy sheet
	searchVersionXML=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
	//Simple, Complex
 	var errorMessage=ComGetEtcData(searchVersionXML, "errorMessage" );
 	if(errorMessage != undefined && errorMessage != ""){
 		ComShowCodeMessage("PSO00025", "[Complex Tariff]");	//"This data is already input to {?msg1}.";
 		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 		return;
 	}
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	if( comboItems != "" ){ 
		addComboItemVersion(comboObjects[3],comboItems);
		formObj.yd_chg_no.value=comboItems[0].split(FIELDMARK)[0];		
	} else{
		//comboObjects[3].InsertItem(0, "001|" + ComGetNowInfo() + "~" + ComGetNowInfo("yy") + "-12-31", "001");
		//comboObjects[3].InsertItem(0, "001|" + ComGetNowInfo() + "~" + "9999" + "-12-31", "001");
		comboObjects[3].InsertItem(0, "001|~" + "9999" + "-12-31", "001");
		formObj.yd_chg_no.value="";
	}
	
	if(typeof(period) == undefined || ComIsEmpty(period)){
		comboObjects[3].SetSelectIndex(0);
	}else{
		var idx = comboObjects[3].FindItem(period, 1, 1);
		if(idx < 0) idx = 0;
		comboObjects[3].SetSelectIndex(idx);
	}
	
}
/** 
 * Handling onBlur event
 */
function obj_blur(){
	var formObj=document.form;
	obj=ComGetEvent();      	
	with(formObj){
		if(obj.name=="from_date" || obj.name=="to_date"){
			var creDtFr=ComReplaceStr(from_date.value,"-","");
			var creDtTo=ComReplaceStr(to_date.value,"-","");
			switch(ComGetEvent("name")) {
			case "from_date":	// Agreement From Date
			if(creDtFr != '' && creDtTo != ''){
				if(creDtFr > creDtTo){
					ComShowCodeMessage('COM12133','To date','From date','greater');
					from_date.value='';
					from_date.focus();
				}
			}
			break;
			case "to_date":	// Agreement To Date
			if(creDtFr != '' && creDtTo != ''){
				if(creDtFr > creDtTo){
					ComShowCodeMessage('COM12133','To date','From date','greater');
					to_date.value='';
					to_date.focus();
				}
			}
			break;	
			}
			ComChkObjValid(ComGetEvent());
		}
		switch(ComGetEvent("name")) {
			case "port_cd":
				var val=obj.value; 
				for(var i=0; i<val.length; i++) {
					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
						formObj.port_cd.value="";
						formObj.port_cd.focus();
						break;
					}
				}
			break;
			case "vndr_seq":	//Servicce Provider
				if(obj.value != ""){
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
					searchVersion();
				} else{
					formObj.vndr_lgl_eng_nm.value="";
					searchVersion();
				}
			break;
		}	
	}
}
function obj_click(){
	var formObj=document.form;
	obj=ComGetEvent();      	
	with(formObj){
		if(obj.name=="cSur"){
			if(cSur.checked){
				document.getElementById("div_surcharge").style.display="inline";
			} else{	//Uncheck for Deleting Surcharge Data
				document.getElementById("div_surcharge").style.display="none";
				sheetObjects[1].RemoveAll();
			}
		}
		if(obj.name=="cDis"){
			if(cDis.checked){
				document.getElementById("div_discount").style.display="inline";
			} else{	//Uncheck for Deleting Surcharge Data
				document.getElementById("div_discount").style.display="none";
				sheetObjects[2].RemoveAll();
			}
		}
	}
} 
function setEnableControl4Columns(sheetObj, cols){
 	var arrCol=cols.split("|");
 	for(row=sheetObj.HeaderRows(); row<sheetObj.HeaderRows()+ sheetObj.RowCount(); row++){
		if(row > sheetObj.HeaderRows()){
			for(i=0; i<arrCol.length; i++){
				sheetObj.SetCellEditable(row, arrCol[i],0);
			}
			sheetObj.SetCellValue(row, "sheet1_seq","",0);
			sheetObj.InitCellProperty(row, "sheet1_obj_list_no",{ Type:"Text",Align:"Center"} );
			sheetObj.SetCellValue(row, "sheet1_obj_list_no","",0);
			sheetObj.SetCellValue(row, "sheet1_object_code_dsp","",0);
			sheetObj.InitCellProperty(row, "sheet1_rate_code",{ Type:"Text",Align:"Center"} );
			sheetObj.SetCellValue(row, "sheet1_rate_code","",0);
			sheetObj.SetCellValue(row, "sheet1_regular_value","",0);
			sheetObj.SetCellValue(row, "sheet1_condition","",0);
			sheetObj.SetCellValue(row, "sheet1_cond_desc","",0);
			sheetObj.InitCellProperty(row, "sheet1_upd_mnu_no_cond",{ Type:"Text",Align:"Center"} );
			sheetObj.SetCellValue(row, "sheet1_upd_mnu_no_cond","",0);
			sheetObj.InitCellProperty(row, "sheet1_upd_mnu_no_cond_text",{ Type:"Text",Align:"Center"} );
			sheetObj.SetCellValue(row, "sheet1_upd_mnu_no_cond_text","",0);
		} else{	//1st row
			for(i=0; i<arrCol.length; i++){
				sheetObj.SetCellEditable(row, arrCol[i],1);
			}		
			if(sheetObj.GetCellValue(row, "sheet1_rate_code") == "F"){
				ComBtnDisable("btn_RowAdd");
				sheetObj.SetCellEditable(row, "sheet1_range_from",0);
				sheetObj.SetCellEditable(row, "sheet1_range_to",0);
			}
		}
 	}
}
/**
 * 
 */
function sheet1_OnChange(sheetObj,Row,Col, Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			var arrComboText=sheetObj.GetComboInfo(Row, Col, "Text").split("|");
			var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if(idx == -1){
				return;
			}
			var tmpObjectCodeDsp = arrComboText[idx].split("\t")[1];
			sheetObj.SetCellValue(Row, prefix + "object_code_dsp", tmpObjectCodeDsp);
			/*
			if(!f_GetObjectTimeAndMeasUnitCheck(sheetObj, Row, Col)){
				sheetObj.SetCellValue(Row, prefix + "obj_list_no", OldValue, 0);
				
				
				
				return;
			}*/
			
		break;
		case prefix + "object" :
			var comboItems=ComGetEtcData(conditionXML, "uomlist");
			var arrCodeTextUOM=makeItemUOM(comboItems, sheetObj.GetCellValue(Row, Col));
			sheetObj.CellComboItem(Row,prefix+"object_code", {ComboText:arrCodeTextUOM[1], ComboCode:arrCodeTextUOM[0]} );
		break;
		case prefix + "object_code_dsp" : 	//as UOM change, Range(From/To) Type change
			//sheetObj.RenderSheet(0);
			for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow()+1; i++){
				f_SetCellProperty(sheetObj, i);
			}
			//sheetObj.RenderSheet(1);
		break;
		case prefix + "rate_code" :
			var tmpRateCode = sheetObj.GetCellValue(Row, Col);
			var tmpObjectCodeDsp = sheetObj.GetCellValue(Row, prefix + "object_code_dsp");
			/*
			if(!f_GetObjectTimeAndMeasUnitCheck(sheetObj, Row, Col)){
				return;
			}*/
			
			if(tmpRateCode == "F"){		//Fixed
				if(sheetObj.LastRow()> sheetObj.HeaderRows()){
					if(confirm(msgs["PSO00028"])){
						//Deleting except 1st row
						for( var i=sheetObj.LastRow(); i>=sheetObj.HeaderRows(); i-- ) {
							if(i != sheetObj.HeaderRows()){
								sheetObj.RowDelete( i, false );
							}
						}
						ComBtnDisable("btn_RowAdd");
						sheetObj.SetCellEditable(Row, prefix + "range_from",0);
						sheetObj.SetCellEditable(Row, prefix + "range_to",0);
						sheetObj.SetCellValue(Row, prefix + "range_from","",0);
						sheetObj.SetCellValue(Row, prefix + "range_to","",0);
					} else{
						sheetObj.SetCellValue(Row, Col,gSheet1_rate_code,0);//not Fixed change
					}
				} else if(sheetObj.LastRow()== sheetObj.HeaderRows()){
					ComBtnDisable("btn_RowAdd");
					sheetObj.SetCellEditable(Row, prefix + "range_from",0);
					sheetObj.SetCellEditable(Row, prefix + "range_to",0);
					sheetObj.SetCellValue(Row, prefix + "range_from","",0);
					sheetObj.SetCellValue(Row, prefix + "range_to","",0);
				}
				
				f_SetMeasUnitByRow(sheetObj, Row, "INIT");
			} else{
				ComBtnEnable("btn_RowAdd");
				sheetObj.SetCellEditable(Row, prefix + "range_from",1);
				sheetObj.SetCellEditable(Row, prefix + "range_to",1);

				f_SetMeasUnitByRow(sheetObj, Row);
			}
			
			
		break;
		case prefix + "condition":
			if(Value == OldValue || "" == Value) return;
			
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gConditonFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setCondition1(rtnArray, Row, Col, 1);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
			break;
	}
}
function sheet1_OnBeforeEdit(sheetObj, Row,Col){
	var formObj=document.form;
	var prefix="sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "rate_code" :
			gSheet1_rate_code=sheetObj.GetCellValue(Row,Col);
		break;
	}
}
/**
 * 
 */
function sheet2_OnChange(sheetObj,Row,Col, Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet2_";
	if(Value == OldValue || "" == Value) return;
	
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gFormulaFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setFormula2(rtnArray, Row, Col, 2);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			}
			break;
		case prefix + "condition":
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gConditonFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setCondition2(rtnArray, Row, Col, 2);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
			break;
		case prefix + "method_code" :
			if(sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.SetCellValue(Row, prefix + "formula_no",arrFormulaNo[0],0);//Formula_No=1
				sheetObj.SetCellValue(Row, prefix + "foml_desc",arrFormulaNo[1],0);//Formula_No=1
				} else if(sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.SetCellValue(Row, prefix + "formula_no",arrFormulaNo[2],0);//Formula_No=2
				sheetObj.SetCellValue(Row, prefix + "foml_desc",arrFormulaNo[3],0);//Formula_No=2
			}
			break;
	}
}
/**
 * 
 */
function sheet3_OnChange(sheetObj,Row,Col, Value , OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet3_";
	if(Value == OldValue || "" == Value) return;
	
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gFormulaFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setFormula3(rtnArray, Row, Col, 3);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			}
			break;
		case prefix + "condition":
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gConditonFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setCondition3(rtnArray, Row, Col, 3);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
			break;
		case prefix + "method_code" :
			if(sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col)) == "A"){
				sheetObj.SetCellValue(Row, prefix + "formula_no",arrFormulaNo[0],0);//Formula_No=1
				sheetObj.SetCellValue(Row, prefix + "foml_desc",arrFormulaNo[1],0);//Formula_No=1
			} else if(sheetObj.GetCellValue(Row, sheetObj.ColSaveName(Col)) == "R"){
				sheetObj.SetCellValue(Row, prefix + "formula_no",arrFormulaNo[2],0);//Formula_No=2
				sheetObj.SetCellValue(Row, prefix + "foml_desc",arrFormulaNo[3],0);//Formula_No=2
			}
			break;
	}
}
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "range_from" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut4)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
		case prefix + "range_to" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut4)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
		case prefix + "rate_value" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut10)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		break;
		case prefix + "regular_value" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut5)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
		case prefix + "condition" :
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				sheetObj.SetCellValue(Row, prefix + "cond_desc","",0);
			}
		break;
	}	
} 
function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	//It's not used because of Copy & Paste problem.
	return;
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "range_from" :
			var val=sheetObj.GetEditText();
			if(!f_SetCipherLess(val, 10, gPointCut4)){
				sheetObj.SelectCell(Row, Col, true, "");
			}
		break;	
		case prefix + "range_to" :
			var val=sheetObj.GetEditText();
			if(!f_SetCipherLess(val, 10, gPointCut4)){
				sheetObj.SelectCell(Row, Col, true, "");
			}
		break;
		case prefix + "rate_value" :
			var val=sheetObj.GetEditText();
			if(!f_SetCipherLess(val, 10, gPointCut10)){
				sheetObj.SelectCell(Row, Col, true, "");
			}
		break;
		case prefix + "regular_value" :
			var val=sheetObj.GetEditText();
			if(!f_SetCipherLess(val, 10, gPointCut5)){
				sheetObj.SelectCell(Row, Col, true, "");
			}
		break;
	}
}
/**
* Row change
*/ 
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	/*var formObj=document.form;
	if(OldRow == NewRow){
		//return;
	}
	if(sheetObj.RowCount()< 1){
		return;
	}
	var prefix="sheet1_";
	//f_SetCellProperty(sheetObj, NewRow);
	switch (sheetObj.ColSaveName(NewCol)) {
	}*/
}
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet2_";
	//  
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "rate_value" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut10)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
		case prefix + "formula_no":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				sheetObj.SetCellValue(Row, prefix + "foml_desc","",0); 
			}
			break;
		case prefix + "condition":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				sheetObj.SetCellValue(Row, prefix + "cond_desc","",0); 
			}
			break;
	}	
} 
function sheet3_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet3_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "rate_value" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut10)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, ""); 
			}
			break;
		case prefix + "formula_no":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				sheetObj.SetCellValue(Row, prefix + "foml_desc","",0); 
			}
			break;
		case prefix + "condition":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				sheetObj.SetCellValue(Row, prefix + "cond_desc","",0); 
			}
			break;
	}	
} 
/*
 *  Setting data with integerPlace and decimalPlace
 */
function f_SetCipherLess(val, integerPlace, decimalPlace){
	val = val+"";
	
	//지수형으로 넘어오는 소수점 체크.: 소수점 7자리부터 지수형으로 변환된다.
	//ex) 실제값 : 0.000000000000001 val : 1e-15
	var iCutIdx = val.toUpperCase().indexOf("E");
	if(iCutIdx > -1){
		var tmpVal = Math.abs(val.substring(iCutIdx+1));
		
		if(tmpVal > decimalPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
			return false;
		}
	}
	
	var arrVal=val.split(".");
	if(arrVal.length == 1){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
	} else if(arrVal.length == 2){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
		if(arrVal[1].length > decimalPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
			return false;
		}
	}	
	return true;
}
 /**
  * Setting vendor popup
  */
function setVendorSeq(aryPopupData, row, col, sheetIdx){
	/*COM_ENS_0C1.do
	var formObj=document.form;
	formObj.vndr_seq.value=aryPopupData[0][2];
	formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
	combo3_OnChange();
	*/
	/*VOP_PSO_0205.do*/
	var formObj=document.form;
	formObj.vndr_seq.value=aryPopupData[0][1];
	formObj.vndr_lgl_eng_nm.value=aryPopupData[0][2];
	//combo3_OnChange();	
	searchVersion();
} 
/*
 * 
 */ 
function f_SetComboAccount(portCd){ 
	//GLOBAL conditionXML
	if( gf_GetCanalPort(portCd) ){
		//Account
		comboObjects[1].SetSelectText("");
		comboObjects[1].SetEnable(1);
		form.account_nm.value="";
		//Cost
		comboObjects[2].SetEnable(1);
		form.lgs_cost_nm.value="";
		addComboItemAccount("CANAL_O");
	} else {
		//Account
		comboObjects[1].SetEnable(1);
		form.account_nm.value="";
		//Cost
		comboObjects[2].SetSelectText("");
		comboObjects[2].SetEnable(1);
		form.lgs_cost_nm.value="";
		addComboItemAccount("CANAL_X");	
	}			
}
function f_SetComboObjectCode(sheetObj, Row, Col){	
	var prefix="sheet1_";
	var comboItems=ComGetEtcData(conditionXML, "uomlist");
	var arrCodeTextUOM=makeItemUOM(comboItems, sheetObj.GetCellValue(Row, Col));
	var uom=sheetObj.GetCellValue(Row, prefix + "uom");
	sheetObj.CellComboItem(Row,prefix+"object_code", {ComboText:arrCodeTextUOM[1], ComboCode:arrCodeTextUOM[0]} );
	if(uom != ""){
		sheetObj.SetCellValue(Row, prefix + "object_code",uom,0);
	}	
}
/*function copyCallBack(){	
	alert("copyCallBack Call.");
	var formObj=document.form;
	var param=formObj.copy_condition.value;
	doActionIBSheet(sheetObjects[0], formObj, COMMAND08);
}*/
function f_RetrieveAfterCopy(){		
	var formObj=document.form;
	//var param=formObj.copy_condition.value;
	doActionIBSheet(sheetObjects[0], formObj, COMMAND08);
}
/*
* Deleting all sheet
*/
function f_RemoveAllSheet(section){
	/******************************/
	if(section == undefined){
		return;
	} else if(section == "IBCLEAR"){
		//delete
	}
	/******************************/
	var formObj=document.form;
	//Sheets	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	document.getElementById("cSur").checked=false;
	document.getElementById("cDis").checked=false;
	document.getElementById("div_surcharge").style.display="none";
	document.getElementById("div_discount").style.display="none";	
	ComBtnEnable("btn_RowAdd");
	formObj.cpls_flg.checked=false;
}
function f_ShowHideSheet(){ 
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
	if(sheetObjects[0].RowCount()> 0){
		document.form.cpls_flg.checked=sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_cpls_flg") == "Y" ? true : false;
	} else{
		document.form.cpls_flg.checked=false;
	}
}	
/*
 * calling from VOP_PSO_0036
 */ 
function f_RetrieveMovedFrom(movedParams){
	var formObj=document.form; 
	var arrMovedParams=movedParams.split("||");	//key::val
	var varFrDate = "";
	var varToDate = "";
	for(var i=0; i<arrMovedParams.length; i++){
		var key_val=arrMovedParams[i].split("::");
		var key=key_val[0];
		var val=key_val[1];
		//Port
		if(key == "port_cd"){
			formObj.port_cd.value=val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
		}
		//Year
		if(key == "year"){			
			formObj.year.value=val;
		}
		//Yard
		if(key == "yd_cd"){
			comboObjects[0].SetSelectCode(val);
		}
		//Account
		if(key == "acct_cd"){
			comboObjects[1].SetSelectCode(val);
		}
		//Cost
		if(key == "cost_cd"){
			comboObjects[2].SetSelectCode(val);
		}
		//Service Provider
		if(key == "vndr_seq"){					
			formObj.vndr_seq.value=val;
			doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
		}
		//from_date
		if(key == "from_date"){
			varFrDate = val;
		}
		//to_date
		if(key == "to_date"){
			varToDate = val;
		}
	}
	var tempPeriod =  varFrDate+"~"+varToDate;
	ComOpenWait(true);
	searchVersion(tempPeriod);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	ComOpenWait(false);
}
/*	
 * Changing Range Type as UOM (Hour, Number)
 */
function f_SetCellProperty(sheetObj, row){
	
	f_SetMeasUnitByRow(sheetObj, row, "INIT");
	/*
	var prefix="sheet1_";
	var val=sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix + "object_code_dsp");	//UOM
 	var type="";
	if(val == "TIME"){
		sheetObj.InitCellProperty(row, prefix + "range_from",{ Type:"Date",Align:"Center",Format:"Hm"} );
		sheetObj.InitCellProperty(row, prefix + "range_to",{ Type:"Date",Align:"Center",Format:"Hm"} );
	} else{			
		sheetObj.InitCellProperty(row, prefix + "range_from",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		sheetObj.InitCellProperty(row, prefix + "range_to",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	}
	sheetObj.InitCellProperty(row, prefix + "rate_value",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	sheetObj.InitCellProperty(row, prefix + "regular_value",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	*/
}
function combo5_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
{
 form.combo5_text.value = combo5.GetText(parseInt(newIndex), 0);
 }
//function combo5_OnBlur() {
	// document.form.combo5_text.value = combo5.GetText(parseInt(combo5.GetSelectIndex()), 0);
	//}

function resizeSheet(){
	//ComResizeSheet(sheetObjects[2]);
}

/**
 * Move Screen for Tariff Update
 * @param mode ( 1 : simple Tariff - move to 0002, 2: complex Tariff - move to 0004
 */
function moveToUpdate(){
	var formObj=document.form;
	
	var params = "parentPgmNo=VOP_PSO_M001&moved_from=0002&pgmNo=VOP_PSO_0036";
	if(ComIsEmpty(formObj.port_cd.value)){
		this.location="/opuscntr/VOP_PSO_0036.do?" + params;
	}else{
		var varPortCd = formObj.port_cd.value;
		var varYdCd = comboObjects[0].GetSelectCode();
		var varYear = formObj.year.value;
		var varEffDt = formObj.from_date.value + "~"+formObj.to_date.value;
		var varAcctCd =  comboObjects[1].GetSelectCode();
		var varCostCd =  comboObjects[2].GetSelectCode();
		var varVndrSeq = formObj.vndr_seq.value;
		var varVersion = comboObjects[3].GetSelectCode();
		
		params += "&moved_params=";
		params += "port_cd::" + varPortCd;
		params += "||" + "yd_cd::" + varYdCd;
		params += "||" + "year::" + varYear;
		params += "||" + "eff_dt::" + varEffDt;
		params += "||" + "acct_cd::" + varAcctCd; 
		params += "||" + "cost_cd::" + varCostCd; 
		params += "||" + "vndr_seq::" + varVndrSeq;
		params += "||" + "version::" + varVersion;
		this.location="/opuscntr/VOP_PSO_0036.do?" + params;
	}
	
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

//단위별 포맷을 잡아 준다. pso_meas_ut_cd regular_value
function f_SetMeasUnitByRow(sheetObj, row, flag){
	var sheetid=sheetObj.id;
	var prefix = sheetid + "_";
	switch(sheetid) {
		case "sheet1": 
			var iFirstRow = sheetObj.HeaderRows();
			if(row < iFirstRow) iFirstRow = row;
			
			var tmpObjCdDsp		= sheetObj.GetCellValue(iFirstRow, prefix+"object_code_dsp"); //row
			var tmpRateCode 	= sheetObj.GetCellValue(iFirstRow, prefix+"rate_code"); //row
			
			var tmpRangeFormat	= "NullFloat";
			
			if(tmpRateCode == "F"){
				tmpRangeFormat		= "NullFloat";
			}else{ //S, R
				tmpRangeFormat		= gRateFormat4;
			}
			
			var tmpRangeFmVal = sheetObj.GetCellValue(row, prefix+"rate_code");
			var tmpRangeToVal = sheetObj.GetCellValue(row, prefix+"range_to");
			
			if(flag == "INIT"){
				sheetObj.SetCellValue(row,  prefix + "range_from"	, "", 0);
				sheetObj.SetCellValue(row,  prefix + "range_to"		, "", 0);
			}
			if("TIME" == tmpObjCdDsp){
				//sheetObj.SetCellValue(row,  prefix + "range_from"	, "", 0);
				//sheetObj.SetCellValue(row,  prefix + "range_to"		, "", 0);
				
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

function sheet1_OnEditValidation(sheetObj, Row, Col, Value) {
	var prefix 				= sheetObj.id+"_";
	var tmpRateCode 	 	= sheetObj.GetCellValue(Row, prefix + "rate_code");
	var tmpObjectCodeDsp 	= sheetObj.GetCellValue(Row, prefix + "object_code_dsp");
	var colSaveName			= sheetObj.ColSaveName(Col);
	switch (colSaveName) {
		case prefix + "obj_list_no" :
			var arrComboText=sheetObj.GetComboInfo(Row, Col, "Text").split("|");
			var arrComboCode=sheetObj.GetComboInfo(Row, Col, "Code").split("|");
			
			var idx = arrComboCode.indexOf(Value);//실제 선택된 Object Value로 Index 를 찾는다.
			
			tmpObjectCodeDsp = arrComboText[idx].split("\t")[1];
			break;
		case prefix + "rate_code" :
			tmpRateCode = Value;
			
			break;
		
	}
	
	if(colSaveName == prefix + "obj_list_no" || colSaveName == prefix + "rate_code" ){
		if(tmpObjectCodeDsp == "TIME" && tmpRateCode == "R"){
			//PSO01014  'Range2' or 'Fixed' type only allowed in the case of 'TIME' unit object.
			ComShowCodeMessage("PSO01014");
			sheetObj.ValidateFail(1);
		}
	}
}
