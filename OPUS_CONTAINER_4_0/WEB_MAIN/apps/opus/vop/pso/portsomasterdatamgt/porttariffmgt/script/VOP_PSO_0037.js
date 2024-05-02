/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0037.js
*@FileTitle  : Tariff Value Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class VOP_PSO_0037 : business script for VOP_PSO_0037
 */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var ACCOUNT_AND_COST="";		//[Global Variable] Account & Cost 
var COST_CODE="";		//[Global Variable] Account & Cost 
var CALENDAR_SELECTED_ROW="";	//[Global Variable] Popup Calendar
var CALENDAR_SELECTED_VAL="";	//[Global Variable] Popup Calendar
var SELECTED_ROW=false;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			case "btn_Save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);	
			break;
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
			break;
			case "btns_Calendar1":		// Agreement Date (From Date)
				var cal=new ComCalendar();
				cal.select(formObject.from_date, 'yyyy-MM-dd');
			break;
			case "btns_Calendar2":		// Agreement Date (To Date)
				var cal=new ComCalendar();
				cal.select(formObject.to_date, 'yyyy-MM-dd');
			break;
			case "btn_port_cd":
				var sUrl="/opuscntr/VOP_VSK_0043.do";//?op=0043
				ComOpenPopup(sUrl, 805, 510, "portCallBack", "0,0", true);
			break;	
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);		//alert(e.description);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
* port code CallBack event
*/
function portCallBack(rtnVal) {
	if(rtnVal){
		document.form.port_cd.value=rtnVal;
		loadTerminal();
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
	for (i=0; i<sheetObjects.length ; i++) {
		ComConfigSheet (sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (var k=0; k<comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	initControl(sheetObjects[0]);
	sheet1_OnLoadFinish(sheet1);
	
}

/**
* registering initial event
*/
function initControl(sheetObj){
	formObj=document.form;
	setToday(formObj.from_date);
	setToday(formObj.to_date);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	//axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
}
/**
* setting combo initial values and header
* param : comboObj, comboNo
* adding case as numbers of counting combos
*/ 
function initCombo(comboObj, comboNo) {
	var formObject=document.form;
	var comboId=comboObj.options.id;
	switch(comboId) {  
		case "yard_cd":		//Yard 
			with (comboObj) { 
				SetMultiSelect(1);
//					UseAutoComplete = true;
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "300");
				SetDropHeight(190);
				SetMaxLength(100);
				ValidChar(2, 3);
			}
		break; 
		case "acct_cd":		//Account 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
				SetColWidth(0, "60");
				SetColWidth(1, "300");
			}
		break; 	
		case "cost_cd":		//Cost 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
			}
		break; 			
	} 
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
		case "sheet1":
		    with(sheetObj){
		      var HeadTitle1="|Yard|Account\nCode|Cost\nCode|Curr.|Service Provider|Service Provider|Effective Date|Effective Date|Ver.|Compulsory for accrual\n(*need to check\nif two or more vendors)|YD_CHG_NO|lst_flg|chk_cpls_flg";
		      var HeadTitle2="|Yard|Account\nCode|Cost\nCode|Curr.|Code|Name|From|To|Ver.|Compulsory for accrual\n(*need to check\nif two or more vendors)|YD_CHG_NO|lst_flg|chk_cpls_flg";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"exp_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_ver_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lst_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_cpls_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetImageList(0, "img/btng_condition.gif");//seq2
              SetShowButtonImage(1);
		      SetHeaderRowHeight(GetDataRowHeight()+ 5);
		      //SetSheetHeight(430);
		      resizeSheet(sheetObj);
	      }
		break; 
		case "sheet2" :
			with (sheetObj) {
				var HeadTitle1 = "IBFLAG|OBJ_LIST_NO|Object|Regular Value|FLAG|YD_CHG_NO|YD_CHG_VER_SEQ|PSO_MEAS_UT_CD|pso_obj_list_tp_cd";
				var headCount = ComCountHeadTitle(HeadTitle1);
				var prefix = "sheet2_";
				SetConfig({SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1});
				var info = {Sort:0, ColMove:1, HeaderCheck:1, ColResize:1};
				var headers = [{ Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);
				var cols = [
					{Type:"Status",		Hidden:1,	Width:30,	Align:"Center",		ColMerge:1,		SaveName:prefix+"ibflag"},
					{Type:"Text",		Hidden:1,	Width:10,	Align:"Center",		ColMerge:1,		SaveName:prefix + "obj_list_no",	KeyField:0},
					{Type:"Text",		Hidden:0,	Width:150,	Align:"Left",		ColMerge:1,		SaveName:prefix + "obj_list_nm",	KeyField:0,		CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0},
					{Type:"Text",		Hidden:0,	Width:80,	Align:"Right",		ColMerge:1,		SaveName:prefix + "regular_value",	KeyField:0,		CalcLogic:"",	Format:"",		UpdateEdit:1,	InsertEdit:1,	EditLen:15,	MaximumValue:10000000000},
					{Type:"Text",		Hidden:1,	Width:50,	Align:"Center",		ColMerge:1,		SaveName:prefix + "flag",			KeyField:0,		CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:1,	EditLen:14},
					{Type:"Text",		Hidden:1,	Width:50,	Align:"Center",		ColMerge:1,		SaveName:prefix + "yd_chg_no",		KeyField:0,		CalcLogic:"",	Format:""},
					{Type:"Text",		Hidden:1,	Width:50,	Align:"Center",		ColMerge:1,		SaveName:prefix + "yd_chg_ver_seq",	KeyField:0,		CalcLogic:"",	Format:""},
					{Type:"Text",		Hidden:1,	Width:50,	Align:"Center",		ColMerge:1,		SaveName:prefix + "pso_meas_ut_cd",	KeyField:0,		CalcLogic:"",	Format:""},
					{Type:"Text",		Hidden:1,	Width:50,	Align:"Center",		ColMerge:1,		SaveName:prefix + "pso_obj_list_tp_cd",	KeyField:0,		CalcLogic:"",	Format:""}
				];
				InitColumns(cols);
				SetEditable(1);
				SetHeaderRowHeight((GetDataRowHeight() + 5) * 2);
				// SetSheetHeight(430);
				resizeSheet(sheetObj);
			}
			break;
		}
	}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // Main Retrieving
			SELECTED_ROW=false;
			var aryPrefix=new Array("sheet1_");   
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[0].SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		break;
		case SEARCH01:      // Detail Retrieving
			var aryPrefix=new Array("sheet2_");   
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH01;
			var yd_chg_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_yd_chg_no");
			var yd_chg_ver_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_yd_chg_ver_seq");
			var param="yd_chg_no=" + yd_chg_no + "&" + "yd_chg_ver_seq=" + yd_chg_ver_seq; 
			var sXml=sheetObj.GetSearchData("VOP_PSO_0037GS.do", param + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			sheetObjects[1].SetWaitImageVisible(1);
			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
		break;
		case IBSAVE:        //Save
			var aryPrefix=new Array( "sheet1_", "sheet2_"); 
			formObj.f_cmd.value=MULTI;
			if(ComGetSaveString(sheetObjects, true, false) == ""){
				ComShowCodeMessage("PSO00034", "[Port]");
				return;
			}
			ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			var sParam=ComGetSaveString(sheetObjects[0], true, false);	//Master
			    sParam=sParam + "&" + ComGetSaveString(sheetObjects[1], true, true);	//Detail
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0037GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			sheetObjects[0].RenderSheet(1);
			sheetObjects[1].RenderSheet(1);
			doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
			ComOpenWait(false);
		break;
		
		case IBCLEAR:  
			//Port
			formObj.port_cd.value="";
			yard_cd.RemoveAll();
			//Account
			acct_cd.SetSelectCode(" ");
			formObj.acct_nm.value="";
			//Cost
			cost_cd.SetSelectCode(" ");
			formObj.cost_nm.value="";
			//Date
			setToday(formObj.from_date);
			setToday(formObj.to_date);
			//Sheets	
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		break;   
		
		case COMMAND05:	//Port Code [keyup:5 lengths]  
		    formObj.f_cmd.value=COMMAND05;	//
			var param=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var isPort=ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal=formObj.port_cd.value;
				loadTerminal();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value="";
			}
		break;
		
		case COMMAND01:  
			var aryPrefix=new Array("sheet1_");
			formObj.f_cmd.value=sAction;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ACCOUNT_AND_COST=ComGetEtcData(sXml, "accountAndCost");	//global
			COST_CODE = ComGetEtcData(sXml, "costCode");	//global
			//ACCOUNT_AND_COST = ComSearchEtcData(sheetObj, "VOP_PSO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix), "accountAndCost");
			createComboAccount();	//Initializing Account & Cost
		break;
		
		case COMMAND02:     // Calendar in Sheet
			var aryPrefix=new Array("sheet1_");
			var portCd = sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_cd");
			var param="f_cmd="           + sAction
			+ "&yd_chg_no="      + sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_chg_no")
			+ "&yd_chg_ver_seq=" + sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_chg_ver_seq")
			+ "&port_cd="        + portCd.substring(0,5)
			+ "&yd_cd="          + portCd.substring(5)
			+ "&vndr_seq="       + sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_vndr_seq")
			+ "&cost_cd="        + sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_cost_cd")
			+ "&exp_dt="         + sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt");
			var sXml=sheetObj.GetSearchData("VOP_PSO_0037GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var checkExpDate=ComGetEtcData(sXml, "checkExpDate");
			if(checkExpDate == "X"){
				ComShowCodeMessage("PSO00035");
				sheetObjects[0].SetCellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt",CALENDAR_SELECTED_VAL);
				return;
			}
		break;
	}
}	
function validateForm(sheetObj, formObj, sAction) {
	with(formObj){
		switch(sAction) {
			case IBSEARCH:
				if(from_date.value.length != 10){
					ComShowCodeMessage('PSO00009');
					return false;
				}
				if(to_date.value.length != 10){
					ComShowCodeMessage('PSO00009');
					return false;
				}	
				if(port_cd.value != ''){
					if(port_cd.value.length != 5){
						ComShowCodeMessage('PSO00001', "[Port]");
						return false;
					}
				}
			break;
			case SEARCH01:
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_yd_chg_no")  == ""){
					sheetObjects[1].RemoveAll();
					return false;
				}
			break;
		}
	}	
	return true;
}
function obj_keyup(){
	 var eleObj=event.srcElement;
	 var formObj=document.form;
	 switch (eleObj.name) {
		 case "port_cd":
			 if(eleObj.value.length == 5){
				 doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			 } else{
				 yard_cd.RemoveAll();
			 }
			 break;
	 }
}
function obj_paste(){
	var eleObj=event.srcElement;
	var formObj=document.form;
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");
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

function obj_blur(){
	var formObj=document.form;
	obj=event.srcElement;      	
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
			ComChkObjValid(event.srcElement);
		}
		switch(ComGetEvent("name")) {
			case "port_cd":		//English Upper Case
				var val=obj.value; 
				for(var i=0; i<val.length; i++) {
					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
						formObj.port_cd.value="";
						break;
					}
				}
			break;
		}	
	}
}
/**
 * Retrieving Combo
 */
function sheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
}
/**
 * process after retrieve sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
	for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++) {
		if(sheetObj.GetCellValue(i,"sheet1_lst_flg") != 'Y') {
			 sheetObj.SetCellEditable(i,"sheet1_exp_dt",0);
			 sheetObj.SetCellEditable(i,"sheet1_cpls_flg",0);
		}
		
		//동일 Yard/Account일때 다른 vendor 가 존재하면 무조건 1건을 체크해야 함.
		if(sheetObj.GetCellValue(i,"sheet1_chk_cpls_flg") == "N"){
			sheetObj.SetRowBackColor(i,gColorRed);
		}
		
	}
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}


/**
 * process after retrieve sheet1
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	sheetObjects[1].SetWaitImageVisible(0);
	var prefix = "sheet2_";
	var lst_flg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_lst_flg");
	if(lst_flg!='Y') {
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++) {
			sheetObj.SetCellEditable(i,"sheet2_regular_value",0);
		}
	}else{
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++) {
			var objNo 			= Number(sheetObj.GetCellValue(i, prefix + "obj_list_no"));
			var psoObjListTpCd 	= sheetObj.GetCellValue(i, prefix + "pso_obj_list_tp_cd");
			var uom 			=sheetObj.GetCellValue(i, prefix + "pso_meas_ut_cd");
			if(objNo >= 18 && objNo <= 22){	//Constant..
				sheetObj.SetCellEditable(i, prefix + "regular_value",0);
			}else{
				//11 : N/A, 12 : FLAG, 14 : CODE, 15 : TIME, 16 : DATE , 17:DAY
				//2015.02.16 Modify : 11, 17 Edit 가능하도록 수정. 
				//if(uom == "11" || uom == "12" ||uom == "14" ||uom == "15" ||uom == "16" ||uom == "17" ){
				//if(uom == "12" ||uom == "14" ||uom == "15" ||uom == "16" ||uom == "17" ){
				if(uom == "14" ||uom == "15" ||uom == "16" ||uom == "17" ){
					sheetObj.SetCellEditable(i,prefix+"regular_value",0);
				}else{
					if(uom == "12"){
						if(psoObjListTpCd == "M" && objNo != "77" && objNo != "89"){ // IN, OUT Object가 아닌경우
							
							var orgValue = sheetObj.GetCellValue(i, prefix+"regular_value");
							
							sheetObj.InitCellProperty	(i , prefix+"regular_value"	,	{ Type:"Combo",Align:"Center"} );
							sheetObj.CellComboItem		(i , prefix+"regular_value"	, 	{ComboText:"|Y|N", ComboCode:"|Y|N"} );
							sheetObj.SetCellValue		(i , prefix+"regular_value"	,	orgValue, 0);
							sheetObj.SetCellValue		(i , prefix+"ibflag"		,	"R"	, 0);
							
							sheetObj.SetCellEditable	(i , prefix+"regular_value",	1);
						}else{
							sheetObj.SetCellEditable	(i , prefix+"regular_value",	0);
						}
					}else{
						var orgValue = sheetObj.GetCellValue(i, prefix+"regular_value");
						
						sheetObj.InitCellProperty	(i , prefix+"regular_value"	,	{ Type:"Float",Align:"Right",Format:"NullFloat"} );
						sheetObj.SetCellEditable	(i , prefix+"regular_value"	,	1);
						sheetObj.SetCellValue		(i , prefix+"ibflag"		,	"R" , 0);
						
						sheetObj.SetCellEditable	(i , prefix+"regular_value"	,	1);
						
					}
				}
			}
			
		}
	}
}


/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "exp_dt":				//to_date popup
			var cal=new ComCalendarGrid("myCal"); 
			CALENDAR_SELECTED_ROW=sheetObj.GetSelectRow();
			CALENDAR_SELECTED_VAL=sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "exp_dt");
			CALENDAR_SELECTED_VAL=ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
			cal.setEndFunction("setExpDate");	//Callback Function
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		break;	 
	}
}
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
	var prefix="sheet1_";
	if(OldRow == NewRow){
		return;
	}
	//alert("OldRow : " + OldRow + "\nNewRow : " + NewRow);
	//if selected Tariff Object is Modified, Then check and save
	if(f_IsModified(OldRow, NewRow)) return;
	doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	sheetObjects[0].SelectCell(NewRow, "sheet1_exp_dt");
}

function sheet1_OnChange(sheetObj,Row,Col,Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "exp_dt":
			CALENDAR_SELECTED_ROW = Row;
			CALENDAR_SELECTED_VAL=OldValue; //sheetObj.GetCellValue(Row, prefix + "exp_dt");
			CALENDAR_SELECTED_VAL=ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
			setExpDate();
		break;
	}
}

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

function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet2_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "regular_value":
			var uom =sheetObj.GetCellValue(i, prefix + "pso_meas_ut_cd");
			var val=sheetObj.GetCellValue(Row, Col);
			if(uom != "12" && !f_SetCipherLess(val, 10, 10)){
				sheetObj.SetCellValue(Row, Col,"",0);
			}
		break;
	}	
}	

function yard_cd_OnKeyDown(comboObj, KeyCode, Shift){
}
/**
 * Account Combo
 */
function acct_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var formObj=document.form;
	formObj.acct_nm.value=acct_cd.GetText(newCode, 1);
	//Cost Combo
	cost_cd.RemoveAll();
	createComboCost(ComTrim(newCode));
}
/**
 * when Combo Key-In or Copy&Paste, validating input text
 */ 
function acct_cd_OnKeyDown(comboObj, KeyCode, Shift){
	var formObj=document.form;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
}
/**
 * Cost Combo
 */
function cost_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	formObj.cost_nm.value=cost_cd.GetText(newCode, 1);
} 
/**
 * When Combo Key-In or Copy&Paste, validating input text
 */ 
function cost_cd_OnKeyDown(comboObj, KeyCode, Shift){
	//if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
	//alert("KeyCode : " + KeyCode);
	var formObj=document.form;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");
} 

function loadTerminal() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	//Initializing combo
	yard_cd.RemoveAll();
	formObj.f_cmd.value=COMMAND01;
	var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
	var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(yard_cd, comboItems);
} 

/**
 * Adding data to combo (Yard)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}
/**
 * Create Account Combo
 */
function createComboAccount(){
	var formObj=document.form;
	arrComboItems=ACCOUNT_AND_COST.split("↔");
	var preCode="";
	acct_cd.InsertItem(-1, "ALL|", " ");	//ALL
	for (i=0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		var comboItem=arrComboItems[i].split("↕");
		
		var nIdx = acct_cd.FindItem(comboItem[0], 0, true);		 

		if( nIdx == -1) {
		    // 찾기 실패한 경우 -1 반환
			acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		}
		/*
		if(preCode != comboItem[0]){
			acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		}
		preCode=comboItem[0];*/
	}  
	acct_cd.SetSelectIndex(0);
}
/**
 * Create Cost Combo
 */
function createComboCost(account){
	var formObj=document.form;
	cost_cd.InsertItem(-1, "ALL|", " ");	//ALL
	
	//arrComboItems=ACCOUNT_AND_COST.split("↔");
	arrComboItems=COST_CODE.split("↔");

	for (i=0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		var comboItem=arrComboItems[i].split("↕");
		//comboItem[] : ACCT_CD, ACCT_NM, COST_CD, COST_NM 
		if(account == ""){
			cost_cd.InsertItem(-1, comboItem[2] + "|" + comboItem[3], comboItem[2]);			
		} else{
			if(account == comboItem[0]){
				cost_cd.InsertItem(-1, comboItem[2] + "|" + comboItem[3], comboItem[2]);
			}
		}
	}
	cost_cd.SetSelectIndex(0);
}
/*
 * after EXP_DT select, CallBack
 */ 
function setExpDate(){
	var formObj=document.form;
	var eff_dt=sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_eff_dt");
	    eff_dt=ComReplaceStr(eff_dt, "-", "");
	    var new_exp_dt=sheetObjects[0].GetCellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt");
	    new_exp_dt=ComReplaceStr(new_exp_dt, "-", "");
	if(new_exp_dt < eff_dt){
		ComShowCodeMessage('COM12133','To date','From date','greater');
		sheetObjects[0].SetCellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt",CALENDAR_SELECTED_VAL);
		return;
	}
	//EXP_DT Validation
	doActionIBSheet(sheetObjects[0], formObj, COMMAND02);
}

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
	
	if(val.indexOf(".") < 0 ) val=val+".";
	
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
/*
 * after Checking sheet2 Modified then Save
 */ 
function f_IsModified(OldRow, NewRow){
	var formObj=document.form;
	if(OldRow == 1) return false;
	if(sheetObjects[1].IsDataModified()){
		if(!confirm(msgs["PSO00037"])){	//There are changed data. Would you save them?
			return false;
		} else{
			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
			return true;
		}
	}
	return false;
}

function resizeSheet(){
	for (var i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}