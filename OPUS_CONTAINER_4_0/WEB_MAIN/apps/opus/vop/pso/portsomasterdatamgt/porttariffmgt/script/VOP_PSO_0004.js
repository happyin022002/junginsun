/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0004.js
*@FileTitle  : Tariff List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class Service Provider Help :business script for  Service Provider Help
 */

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var gSheet2_obj_list_no="";		//Object of sheet2
var gSheet2_object_code_dsp="";	//UOM of sheet2
var gSheet2_object_code="";		//UOM of sheet2
var gSheet2_rate_code="";			//Rate Type of sheet2
var gColumnCountInSheet2=0;		//Column Count of sheet2
var gSelectEvent=true;			//Sheet1 RowDeleting
var gObjUomInSheet2=new Object();
var WIDTH_FORMULA_POPUP=900;		//VOP_PSO_0209.do Popup 
var HEIGHT_FORMULA_POPUP=500;
var WIDTH_CONDITION_CREATION_POPUP=800;	//VOP_PSO_0206.do Popup
var HEIGHT_CONDITION_CREATION_POPUP=290;
var WIDTH_COPY_POPUP=850;	//VOP_PSO_0211.do Popup
var HEIGHT_COPY_POPUP=830;
var POPUP_IS_MODAL = true;
var POP_TITLE_0206="Formula Condition";		//in case of calling from VOP_PSO_0004, 'Rate Condition'
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var conditionXML="";
var searchVersionXML="";
var arrFormulaNo=new Array();	//Getting Formula_No IN (1, 2)
var rowIdx=10;
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
	var sheetObject4=sheetObjects[3];
	var sheetObject5=sheetObjects[4];
	var sheetObject6=sheetObjects[5];	//Base Dummy
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return; // 버튼 상태를 확인을 합니다.
		switch(srcName) {
			case "btn_RowAdd":
				if( !validateForm(sheetObject1,formObject,IBSEARCH)) return;
				
				var prefix="sheet1_";	
				var selectRow=sheetObject1.GetSelectRow();
				
				if( comboObjects[4].GetSelectText()== "" ) {
					ComShowCodeMessage('PSO00005');
					return;
				}
				
				if( sheetObject1.RowCount()== 0 ){	//1st row
				} else if(sheetObject1.RowCount()> 0){	//from 2nd row
					if( sheetObject1.GetCellValue( sheetObject1.LastRow(), "sheet1_formula_no") == ""){
						ComShowCodeMessage('PSO00003');
						return;
					}			
				}
				
				//Getting UK
				var minVal = f_GetMinValInSheet(sheetObject1, "sheet1_uk") - 1;
				sheetObject1.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[0]", "rows" : "0,1", "col" : "sheet1_del_chk"}]);
				
				selectRow=eval(sheetObject1.GetSelectRow());
				sheetObject1.SetCellValue(selectRow, "sheet1_seq"					,10		,0);
				sheetObject1.SetCellValue(selectRow, "sheet1_uk"					,minVal	,0); //음수값으로 UK설정함, Base Child에 UK전달  
				sheetObject1.SetCellValue(selectRow, "sheet1_upd_mnu_no_cond"		,"1"	,0); //from 0007
				sheetObject1.SetCellValue(selectRow, "sheet1_upd_mnu_no_cond_text"	,"1"	,0);//from 0007
			break;

			case "btn_Delete":	//It is complicated. 
				var prefix="sheet1_";	
				var selectRowBf = eval(sheetObject1.GetSelectRow());
				gSelectEvent=false;
				
				//Deleting checked row of Sheet6, Sheet2 << 체크된 행 삭제 (Sheet6, Sheet2)
				for( var i=sheetObject1.LastRow(); i>=sheetObject1.HeaderRows(); i-- ) {
					if(sheetObject1.GetCellValue(i, prefix + "del_chk") == 1){
						var sheet1_uk = sheetObject1.GetCellValue(i, prefix + "uk");
						
						f_RemoveDummyByBase(sheet1_uk);	//Dummy(Sheet6)	Deleting
						
						if(sheetObject2.RowCount()> 0){
							//Sheet2 Deleting
							if(sheetObject2.GetCellValue(sheetObject2.HeaderRows(), "sheet2_uk") == sheet1_uk){
								sheetObject2.RemoveAll();
							}
						}
					}
				} 
				
				//Deleting checked row of Sheet1 << 체크된 행 삭제 (Sheet1)
				sheetObject1.RenderSheet(0);
				for( var i=sheetObject1.LastRow(); i>=sheetObject1.HeaderRows(); i-- ) {
					if(sheetObject1.GetCellValue(i, prefix + "del_chk") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				sheetObject1.RenderSheet(1);
				
				//[2009.11.18] Sheet1의 Row 삭제중에는 OnSelect Event를 발생시키지 않고, 최종 Focus된 Row의 정보를 가져온다.
				//if(selectRowBf == sheetObject1.SelectRow){	//삭제후 row가 바뀌지 않으면, onSelect Event가 발생하지 않는다.	
					var seletedRow			= sheetObject1.GetSelectRow();
					var sheet1FomlSysDesc 	= sheetObject1.GetCellValue(seletedRow, "sheet1_foml_sys_desc");
					var sheet1Uk 			= sheetObject1.GetCellValue(seletedRow, "sheet1_uk");
					
					f_SetComboItemByFormula(sheet1FomlSysDesc);	//Creating combo using object of selected formula
					f_CopyDummy2Base(sheet1Uk);
					
					document.getElementById("foml_desc").innerHTML=sheetObject1.RowCount()> 0 ? sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_foml_desc") : "";
					document.getElementById("cond_desc").innerHTML=sheetObject1.RowCount()> 0 ? sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cond_desc") : "";
				//}
				sheetObject1.RenderSheet(1);//RenderSheetagain
				gSelectEvent=true;
				f_ControlGridCopyButton();	//Grid Copy Button
			break;		
			
			case "btn_RowAdd2": //[2009.11.05] '///' 주석은 현업테스트시 데이터입력을 용이하게 하기 위한 조치
				if( !validateForm(sheetObject2,formObject,IBSEARCH)) return;
				var selectRow1=sheetObject1.GetSelectRow();
				var prefix="sheet2_";	
				
				if(selectRow1 < 0 || sheetObject1.RowCount()== 0){
					ComShowCodeMessage('PSO00022', "[Base Formula]");
					return;
				} else{
					if(sheetObject1.GetCellValue(selectRow1, "sheet1_formula_no") == ""){
						ComShowCodeMessage('PSO00036', "[Formula ID]");
						return;
					}
				}
				/*
				if( comboObjects[4].GetSelectText()== "" ) {
					///ComShowCodeMessage('PSO00005');
					///return;
				}		
				if( sheetObject2.RowCount()== 0 ){	//1st new row
				} else if(sheetObject2.RowCount()> 0){	//from 2nd row
					if(sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_rate_code") == "F"){
						if( sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_obj_list_no") == ""
							||	sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_rate_value") == "" ){
							///ComShowCodeMessage('PSO00003');
							///return;
						}						
					} else{
						if( sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_obj_list_no") == ""
							||  sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_range_from") == ""
								||	sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_range_to") == ""
									||	sheetObject2.GetCellValue( sheetObject2.LastRow(), "sheet2_rate_value") == "" ){
							///ComShowCodeMessage('PSO00003');
							///return;
						}		
					}
				}*/
				
				sheetObject2.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[1]", "rows" : "0,1", "col" : "sheet2_del_chk"}]);
				
				var selectRow2 = eval(sheetObject2.GetSelectRow());
				var selectRow6 = eval(sheetObject6.GetSelectRow());
				
				sheetObject2.SetCellValue(selectRow2, "sheet2_uk"			,sheetObject1.GetCellValue(selectRow1, "sheet1_uk"),0);
				sheetObject2.SetCellValue(selectRow2, "sheet2_obj_list_no"	,"",0); //콤보 디폴트선택을 없애기위해
				
				if( selectRow2 == sheetObject2.HeaderRows()){	//first new row << 첫번째 신규행은
					sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_seq"	,10	,0);
				} else if( selectRow2 > sheetObject2.HeaderRows()){	//from 2nd row, Copying pre row << //두번째 행부터는 이전 행 복사하여 디폴트 표현
					sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_obj_list_no",sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_obj_list_no"),0);
					sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_object_code_dsp",sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_object_code_dsp"),0);
					
					if(sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_rate_code") != "F"){
						sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_seq",sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_seq"),0);
						sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_rate_code",sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_rate_code"),0);
						//sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_range_from") = ""+(eval(sheetObject2.CellValue(  sheetObject2.LastRow - 1 , "sheet2_range_to"))+1);
						sheetObject2.SetCellEditable(sheetObject2.LastRow(), "sheet2_condition",0);
						sheetObject2.SetCellEditable(sheetObject2.LastRow(), "sheet2_cons_als_nm",0);
					} else{
						sheetObject2.SetCellValue(sheetObject2.LastRow(), "sheet2_seq",Number(sheetObject2.GetCellValue(sheetObject2.LastRow()- 1, "sheet2_seq")) + 10,0);
					}
				}
				
				f_SetMeasUnitByRow(sheetObject2, sheetObject2.LastRow());
				break;
				
			case "btn_Delete2":
				var prefix = "sheet2_";	
				var selectRow = eval(sheetObject2.GetSelectRow());
				
				//Deleting Checked Rows
				for( var i = sheetObject2.LastRow(); i >= sheetObject2.HeaderRows(); i-- ) {
					if(sheetObject2.GetCellValue(i, "sheet2_del_chk") == 1){
						sheetObject2.RowDelete( i, false );
					}
				}
				
				if(sheetObject2.LastRow() < sheetObject2.HeaderRows()){
					ComBtnEnable("btn_RowAdd2");
				}
				
				f_RearrangeInSheet2();
				break;
				
			case "btn_RowAdd3":		//Regular Value
				if( !validateForm(sheetObject4,formObject,IBSEARCH)) return;
				sheetObject3.DataInsert(-1);
				
				var selectRow3=eval(sheetObject3.GetSelectRow());
				sheetObject3.SetCellValue(selectRow3, "sheet3_obj_list_no","",0); //콤보 디폴트선택을 없애기위해
				break;
				
			case "btn_Delete3":		//Regular Value	
				//Deleting Checked Rows
				for( var i=sheetObject3.LastRow(); i>=sheetObject3.HeaderRows(); i-- ) {
					if(sheetObject3.GetCellValue(i, "sheet3_del_chk") == 1){
						sheetObject3.RowDelete( i, false );
					}
				}
				break;
				
			case "btn_RowAdd4":		//Surcharge
				if( !validateForm(sheetObject4,formObject,IBSEARCH)) return;
				sheetObject4.DataInsert(-1);
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[3]", "rows" : "0,1", "col" : "sheet4_del_chk"}]);
				
				//sheetObject4.CellValue2(sheetObject4.LastRow, "sheet4_seq2") = "0";
				sheetObject4.SetCellValue(sheetObject4.LastRow(), "sheet4_upd_mnu_no_cond","1",0);//빵집
				sheetObject4.SetCellValue(sheetObject4.LastRow(), "sheet4_upd_mnu_no_cond_text","1",0);//0007
				
				selectRow = eval(sheetObject4.GetSelectRow());
				
				sheetObject4.SetCellValue(sheetObject4.LastRow(), "sheet4_seq",10*selectRow,0);
				//Call sheet4_Onchange()
				sheetObject4.SetCellValue(sheetObject4.LastRow(), "sheet4_method_code","",0);
				sheetObject4.SetCellValue(sheetObject4.LastRow(), "sheet4_method_code","A");
				break;
				
			case "btn_Delete4":		//Surcharge	
				//Deleting Checked Rows << //체크된 행 삭제
				for( var i=sheetObject4.LastRow(); i>=sheetObject4.HeaderRows(); i-- ) {
					if(sheetObject4.GetCellValue(i, "sheet4_del_chk") == 1){
						sheetObject4.RowDelete( i, false );
					}
				}
				break;
				
			case "btn_RowAdd5":		//Discount
				if( !validateForm(sheetObject5,formObject,IBSEARCH)) return;
				sheetObject5.DataInsert(-1);
				
				//HeadCheck Uncheck
				f_SetHeadUnCheck([{"sheetObj" : "sheetObjects[4]", "rows" : "0,1", "col" : "sheet5_del_chk"}]);
				
				//sheetObject5.CellValue2(sheetObject5.LastRow, "sheet5_seq2") = "0";
				sheetObject5.SetCellValue(sheetObject5.LastRow(), "sheet5_upd_mnu_no_cond","1",0);
				sheetObject5.SetCellValue(sheetObject5.LastRow(), "sheet5_upd_mnu_no_cond_text","1",0);
				
				selectRow = eval(sheetObject5.GetSelectRow());
				
				sheetObject5.SetCellValue(sheetObject5.LastRow(), "sheet5_seq",10*selectRow,0);
				//Call sheet5_Onchange()
				sheetObject5.SetCellValue(sheetObject5.LastRow(), "sheet5_method_code","",0);
				sheetObject5.SetCellValue(sheetObject5.LastRow(), "sheet5_method_code","A");
				break;
				
			case "btn_Delete5":		//Discount	
				//Deleting Checked rows
				for( var i=sheetObject5.LastRow(); i>=sheetObject5.HeaderRows(); i-- ) {
					if(sheetObject5.GetCellValue(i, "sheet5_del_chk") == 1){
						sheetObject5.RowDelete( i, false );
					}
				}
				break;	
				
			case "btn_GridCopy":
				var selectRow=sheetObjects[0].GetSelectRow();
				//if Formula is not selected, Permitting Grid Copy
				if(selectRow < 0 || sheetObject1.RowCount()== 0){
					ComShowCodeMessage('PSO00022', "[Base Formula]");
					return;
				} else{
					if(sheetObject1.GetCellValue(selectRow, "sheet1_formula_no") == ""){
						ComShowCodeMessage('PSO00036', "[Formula ID]");
						return;
					}
				}
				
				if(selectRow >= sheetObjects[0].HeaderRows()){
					
					f_CopyDummy2Base(sheetObjects[0].GetCellValue(selectRow - 1, "sheet1_uk"));
					
					for(var i=sheetObjects[1].HeaderRows(); i<sheetObjects[1].LastRow()+1; i++){
						sheetObjects[1].SetCellValue(i, "sheet2_uk",sheetObjects[0].GetCellValue(selectRow, "sheet1_uk"),0);
					}
				} 
				break;
				
			case "btn_port_cd":
				var sUrl="/opuscntr/VOP_VSK_0043.do?op=0043";
				ComOpenPopup(sUrl, 900, 510, "portCallBack","0,1,1,1", true);
				break;
				
			case "btns_VendorSeq":
				//ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 430, 'setVendorSeq', '1,0,1,1,1', true);
				ComOpenPopup('/opuscntr/VOP_PSO_0205.do', 600, 470, 'setVendorSeq', '0,0', true, true);
				break;
				
			case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal=new ComCalendar();
				cal.select(formObject.from_date, 'yyyy-MM-dd');
			break;
			
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal=new ComCalendar();
				cal.select(formObject.to_date, 'yyyy-MM-dd');
			break;
			
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);	
				formObject.csearch.value="1";
				break;
				
			case "btn_New":
				formObject.csearch.value="";
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				formObj.port_cd.focus();
				break;
				
			case "btn_Save":
				ComOpenWait(true);
				doActionIBSheet(sheetObject1,formObject,IBSAVE);	
				ComOpenWait(false);
				break;
				
			case "btn_DataDelete":
				ComOpenWait(true);
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
				ComOpenWait(false);
				break;
				
			case "btn_Copy":
				if( formObject.port_cd.value == '' || formObject.port_cd.value.length != 5) {
					ComShowCodeMessage("PSO00003", "[Port]");	
					formObject.port_cd.focus();
					return; 
				}	
				if( comboObjects[2].GetSelectCode()== '' ) {
					ComShowCodeMessage("PSO00003", "[Account/Cost]");	
					//formObject.vndr_seq.focus();
					return; 
				}	
				if( formObject.vndr_seq.value == '' ) {
					ComShowCodeMessage("PSO00003", "[Service Provider]");	
					formObject.vndr_seq.focus();
					return; 
				}	
				
				var param  = "port_cd="   + formObject.port_cd.value;
				    param += "&yd_cd="    + comboObjects[0].GetSelectCode(); 
				    param += "&acct_cd="  + comboObjects[1].GetSelectCode();
				    param += "&acct_nm="  + formObject.account_nm.value;
				    param += "&cost_cd="  + comboObjects[2].GetSelectCode();
				    param += "&cost_nm="  + formObject.lgs_cost_nm.value;
				    param += "&vndr_seq=" + Number(formObject.vndr_seq.value);
				    param += "&vndr_nm="  + formObject.vndr_lgl_eng_nm.value;
				    
				var sUrl="/opuscntr/VOP_PSO_0212.do?" + param;
//				var sFeatures="toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_COPY_POPUP + ",height=" + HEIGHT_COPY_POPUP;
//				ComOpenWindow(sUrl, "COPY", sFeatures, false);
				ComOpenPopup(sUrl, WIDTH_COPY_POPUP, HEIGHT_COPY_POPUP, "portCallBack", "0,0", false);
				break;
				
			case "btn1_Tariff_Inquiry":
				moveToUpdate();
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

function portCallBack(rtnVal) {
	if(rtnVal){
		document.form.port_cd.value=rtnVal;
		loadTerminal();				//COMBO YARD
		f_SetComboAccount(rtnVal);	//COMBO ACCOUNT		
		f_RemoveAllSheet();
		comboObjects[0].Focus();
	}
}

function loadTerminal() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
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
	resizeSheet();
	//Version Combo
	//comboObjects[3].SetEnable(0);
	initControl(sheetObjects[0]);
	sheet2_OnLoadFinish(sheetObjects[1]);
	sheet3_OnLoadFinish(sheetObjects[2]);
	sheet1_OnLoadFinish(sheetObjects[0]);
	
}
/**
 * registering initial event
 */
function initControl(sheetObj){
	formObj=document.form;
	//setToday(formObj.from_date);
	formObj.to_date.value='9999-12-31';
	//setToday(formObj.to_date);
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
	var formObject=document.form;
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
  * Adding data to combo (Currency, Yard)
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
  * in case of EGSCA,PAPCA Port, Showing only 511911 Account
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
 	var comboCode="";
 	var comboText="";
 	arrComboItems=comboItems.split("|");
 	var preCode="";
 	for (var i=0 ; i < arrComboItems.length ; i++) {
 		var comboItem=arrComboItems[i].split(",");
 			comboCode += "|" + comboItem[4];
 			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
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
	for (var i=0 ; i < arrComboItems.length ; i++) {
		var comboItem=arrComboItems[i].split(",");
			comboCode += "|" + comboItem[4];
			comboText += "|" + comboItem[1] + "\t" + comboItem[3];
	}  
	comboCode=comboCode.substr(1);	//Code
	comboText=comboText.substr(1); 	//Text
	return new Array(comboCode, comboText);
}  
 /**
  * Adding data to combo (UOM in Sheets) <<  콤보필드에 데이터를 추가해준다. (UOM in Sheets)
  */	
 function makeItemUOM(comboItems, objCd) {
 	var comboCode="";
 	var comboText="";
 	arrComboItems=comboItems.split("|");
 	for (var i=0 ; i < arrComboItems.length ; i++) {
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
		 case "org_vndr_nm":
			 document.getElementById("info_byte").innerHTML = "("+ComGetLenByByte(formObj.org_vndr_nm) +" Byte)";
			 ComChkObjValid(event.srcElement);
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
 * Handling deactivate event
 */
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
			 if(form.year.value == ""){
				 form.year.value=creDtFr.substr(0,4);
			 }
			 ComChkObjValid(event.srcElement);
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
					 var val=obj.value;
					 if(isNaN(val)){
						 formObj.vndr_seq.value="";
					 	formObj.vndr_lgl_eng_nm.value="";
					 	return;
					 }
					 doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
					 form.year.value="";
					 searchVersion();
				 } else{
					 formObj.vndr_lgl_eng_nm.value="";
					 form.year.value="";
					 searchVersion();
				 }
			 break;
		 }	
	 }
 }
 function obj_click(){
	 var formObj=document.form;
	 obj=event.srcElement;      	
	 with(formObj){
		 if(obj.name=="cSur"){
			 if(cSur.checked){
				 document.getElementById("div_surcharge").style.display="inline";
			 } else{
				 document.getElementById("div_surcharge").style.display="none";
			 	 sheetObjects[3].RemoveAll();
			 }
		 }
		 if(obj.name=="cDis"){
			 if(cDis.checked){
				 document.getElementById("div_discount").style.display="inline";
			 } else{
				 document.getElementById("div_discount").style.display="none";
			 	 sheetObjects[4].RemoveAll();
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
		      //var HeadTitle1="|||Formula|Formula|Condition|Condition|Condition|text|foml_sys_desc|Compulsory|UK";
		      //var HeadTitle2="|||ID|DESC| ID|DESC||text|foml_sys_desc|Compulsory|UK";
		      var HeadTitle1="|||D/F|Formula|Formula|Condition|Condition|Condition|text|foml_sys_desc|Compulsory|UK";
		      var HeadTitle2="|||D/F|ID|DESC| ID|DESC||text|foml_sys_desc|Compulsory|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"CheckBox",  Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"default2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Image",     Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond_text"},
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"foml_sys_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetCountPosition(0);
		      SetImageList("0","img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X) 
		      SetImageList("1","img/btng_condition.gif");//
		      SetImageList("2","img/btng_condition_h.gif");//
		      SetShowButtonImage(1);
		      SetColProperty(prefix+"formula_no" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
		      SetSheetHeight(150);
		      SetFocusAfterProcess(0);
			}
		break;
	case "sheet2":
	    with(sheetObj){
		      var HeadTitle1="||Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		      var HeadTitle2="||Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		      //var HeadTitle1="||Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		      //var HeadTitle2="||Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColumnCountInSheet2=headCount;
		      var prefix="sheet2_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no" },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",     Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:1, Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Fixed\tObjectXFixedRate", ComboCode:"R|F"} );
	          
		     /* SetColProperty(0, prefix+"range_from", {AcceptKeys:"N"} );  
		      SetColProperty(0, prefix+"range_from", {Format:"#,###.####"} );
	          SetColProperty(0, prefix+"range_to", {Format:"#,###.####"} );
	          SetColProperty(0, prefix+"rate_value", {Format:"#,###.####"} );*/
		      SetShowButtonImage(1);
		      SetSheetHeight(275);
		      SetFocusAfterProcess(0);
		      SetCountPosition(0);
      }
		break;
	case "sheet3":			//Regular Value
	    with(sheetObj){
		      var HeadTitle1="|||Regular Value|Regular Value|Regular Value|Regular Value";
		      var HeadTitle2="|||Object|UOM|Value|pso_meas_ut_cd";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet3_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:1, Width:190,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no" },
		             {Type:"Text",      Hidden:0, Width:190,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_nm" },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"regular_value",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 }, 
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(125);
		      SetSheetWidth(450);
		      SetCountPosition(0);
            }
		break;
		
	case "sheet4": // surcharge
	    with(sheetObj){
		      var HeadTitle1="||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|text|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet4_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
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
			             {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
			             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			             {Type:"Image",     Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond_text"},
			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1, 	EditLen:500 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetImageList("0","img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X)
		      SetImageList("1","img/btng_condition.gif");//
		      SetImageList("2","img/btng_condition_h.gif");//
		      SetShowButtonImage(1);
		      SetColProperty(prefix+"formula_no" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetSheetHeight(125);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0); 
			}
		break;
		
	case "sheet5": // discount
	    with(sheetObj){
		      var HeadTitle1="||seq|Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Formula Condition|text|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet5_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
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
		             {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		             {Type:"Image",     Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond_text"},
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1, 	EditLen:500 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetImageList("0","img/btng_condition.gif");//upd_mnu_no_cond(O),seq2(X)
		      SetImageList("1","img/btng_condition.gif");//
		      SetImageList("2","img/btng_condition_h.gif");//
		      SetShowButtonImage(1);
		      SetColProperty(prefix+"formula_no" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"condition" 	, {AcceptKeys:"N"});
		      SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
	          SetSheetHeight(125);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
		break;
	case "sheet6":		//Base Dummy
	    with(sheetObj){
		      var HeadTitle1="||Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		      var HeadTitle2="||Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet6_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormat10, UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Range2\tRangeRateOnly|Fixed\tObjectXFixedRate", ComboCode:"R|S|F"} );
		      SetSheetHeight(235);
              SetShowButtonImage(1);
		      SetCountPosition(0);
      	}
		break;
	case "sheet7":	//Dummy Sheet that is not initialized
		break;	
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction, selValue, gubun) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");        
			if( !validateForm(sheetObj,formObj,sAction)) return;
			ComBtnEnable("btn_RowAdd");
			formObj.f_cmd.value = SEARCH;//COMBO
			
			f_SetHeadUnCheckAll();//Deleting GetHeaderCheckof all sheets
			f_RemoveAllSheet();
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0004GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			
			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[5].SetWaitImageVisible(0);
			sheetObjects[2].SetWaitImageVisible(0);
			sheetObjects[3].SetWaitImageVisible(0);
			sheetObjects[4].SetWaitImageVisible(0);
			
			sheetObjects[5].LoadSearchData(arrXml[1],{Sync:1});
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1});
			sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1});
			sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1});
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1});
			
		break;
		
		case IBSEARCH_ASYNC01:	//Setting initial conditions << //초기 조회조건 Setting   
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_" );
			formObj.f_cmd.value=SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			
			sheetObjects[0].SetWaitImageVisible(0);
			conditionXML = sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			var arrXml = conditionXML.split("|$$|");
			
			//Object Setting in Sheets (1, 2)
			var comboItems = ComGetEtcData(conditionXML, "objlist");
			var arrCodeTextObject = makeItemObject(comboItems);
			
			//Setting Object Combo of Base Sheet
			sheetObjects[1].SetColProperty("sheet2_obj_list_no", {ComboText:arrCodeTextObject[1], ComboCode:arrCodeTextObject[0]} );
			
			//Initializing combo (Account)
			comboObjects[1].RemoveAll();
			
			//Initializing combo (Cost)
			comboObjects[2].RemoveAll();
			
			//Initializing combo (Currency)
			//var localCurrency = ComGetEtcData(conditionXML, "localCurrency" );
			comboObjects[4].RemoveAll();
			comboItems = ComGetEtcData(conditionXML, "currency" ).split(ROWMARK);
			addComboItem(comboObjects[4],comboItems);
			//comboObjects[4].Code2 = localCurrency;	//Setting Local Currency
			
			var arrFormula4Loading=ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k = 0;
			for(var i = 0; i < arrFormula4Loading.length; i++){
				arrKeyVal = arrFormula4Loading[i].split("|@DELIM|");
				for(var j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k]=arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
		break;
		
		case IBSAVE:        //Save
			var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_", "sheet6_", "sheet7_");
			
			f_RemoveDummyByBase(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_uk"));	//Dummy 	Deleting
			f_CopyBase2Dummy(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_uk"));																	//Adding to Dummy
			
			formObj.f_cmd.value=MULTI;
			
			if( !validateForm(sheetObj,formObj,sAction)) return;
			
			var sParam=ComGetSaveString(sheetObjects, true, true);	//Transmitting all rows
			if (sParam == "") return;
			
			//ComDebug("[Debug] \n" + sParam + "\n");	//alert
			formObj.yd_chg_ver_seq.value=comboObjects[3].GetSelectCode();
			ComOpenWait(true);
			
			sheetObjects[0].SetWaitImageVisible(0);
			
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0004GS.do", sParam);
			
			var sResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			
			sheetObjects[0].LoadSaveData(sXml);
			//			sheetObjects[0].RenderSheet(1);
			//			sheetObjects[1].RenderSheet(1);
			//			sheetObjects[2].RenderSheet(1);
			formObj.year.value="";
			ComOpenWait(false);
			
			ComOpenWait(true);
			if("F" != sResultKey){				
				searchVersion();			
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
			ComOpenWait(false);
		break;
		
		case IBCLEAR:  
			f_SetHeadUnCheckAll();//Deleting GetHeaderCheckof all sheets
			
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
			
			//Version
			comboObjects[3].RemoveAll();
			
			//Currency
			//comboObjects[4].Code2 = ComGetEtcData(conditionXML, "localCurrency" );	
			comboObjects[4].SetSelectCode("",false);
			
			//Sheets	
			f_RemoveAllSheet("IBCLEAR");
		break;     
		
		case IBDELETE:      // Deleting
			formObj.f_cmd.value = REMOVE;
			if(!validateForm(sheetObj,formObj,sAction)) return;
			if(!confirm(msgs["PSO00020"])) return;
			ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			
			sParam = FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveData("VOP_PSO_0004GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			
			searchVersion();
			f_RemoveAllSheet("IBCLEAR");
			//doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			ComOpenWait(false);
			
		break;
		
		case COMMAND05:	//Port Code [keyup:5 length]  
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal=formObj.port_cd.value;
				loadTerminal();
				f_SetComboAccount(rVal);
				comboObjects[0].Focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value="";
				formObj.port_cd.focus();
			}
		break;
		
		case COMMAND06:	//Service Provider   
			formObj.f_cmd.value = COMMAND06;//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
			
			var spName = ComGetEtcData(sXml, "spName");	//Service Provider Name
			formObj.vndr_lgl_eng_nm.value = spName;
			if(spName != ""){
			} else{
				ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
				formObj.vndr_seq.focus();
				formObj.vndr_seq.value="";
			}
		break;	
		
		case COMMAND08:      // after COPYing, Retrieving
			//value from Copy Popup
			var param = formObj.copy_condition.value;
			var aryPrefix = new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_");   
			
			f_SetHeadUnCheckAll();//Deleting GetHeaderCheckof all sheets
			
			f_RemoveAllSheet();
			
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchData("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			
			var arrXml=sXml.split("|$$|");

			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[5].SetWaitImageVisible(0);
			sheetObjects[2].SetWaitImageVisible(0);
			sheetObjects[3].SetWaitImageVisible(0);
			sheetObjects[4].SetWaitImageVisible(0);
			
			sheetObjects[5].LoadSearchData(arrXml[1],{Sync:1});
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1});
			sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1});
			sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1});
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1});
			
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
	var strPrefix = "";
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
				comboObjects[0].Focus();
				return false;
			}	
			//Account
			if( comboObjects[1].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//mandatory
				comboObjects[1].Focus();
				return false;
			}					
			//Cost
			if( comboObjects[2].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Cost CD]");	//mandatory
				comboObjects[2].Focus();
				return false;
			}	
			//Service Provider
			if(vndr_seq.value == ''){
				ComShowCodeMessage('PSO00011');
				vndr_seq.focus();
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
				comboObjects[3].Focus();
				return false;
			}	
			//Currency	
			if( comboObjects[4].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Currency]");	//mandatory
				comboObjects[4].Focus();
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
				comboObjects[0].Focus();
				return false;
			}	
			if( comboObjects[0].GetSelectCode().split(",").length > 1 ){
				ComShowCodeMessage('PSO00006');
				return false;
			}	
			//Account
			if( comboObjects[1].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//mandatory
				comboObjects[1].Focus();
				return false;
			}				
			//Cost
			if( comboObjects[2].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00010');
				comboObjects[2].Focus();
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
				vndr_seq.focus();
				return false;
			}	
			if( csearch.value != '' && comboObjects[3].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00012');
				combo5.Focus();
				return false;
			}	
			if( sheetObjects[0].LastRow()< sheetObjects[0].HeaderRows()){
				ComShowCodeMessage('PSO00017');
				return false;
			}
			//Base
			var strRows="";
			var iLoneRateCnt = 0;
			var arrLoneRateValue =["* RATE","*RATE","+ RATE","+RATE","- RATE","-RATE","/ RATE","/RATE","( RATE","(RATE"];
			for(var i=sheetObjects[0].HeaderRows(); i<sheetObjects[0].LastRow()+1; i++){
				strPrefix="sheet1_";
				var formula_no=sheetObjects[0].GetCellValue(i, strPrefix + "formula_no");
				var condition=sheetObjects[0].GetCellValue(i, strPrefix + "condition");
				var uk=sheetObjects[0].GetCellValue(i, strPrefix + "uk");
				if(formula_no == ""){
					ComShowCodeMessage("PSO00003", "[Base : Formula]");	//mandatory
					return false;
				}
				//in case Tariff doesn't input and Formula input
				if(sheetObjects[5].FindText("sheet6_uk", uk) == -1){
					strRows += "," + (i - sheetObjects[0].HeaderRows()+ 1);
				}
				
				//2015.12.21 Add foml_desc foml_sys_desc
				var tmpFomlDesc = sheetObjects[0].GetCellValue(i, strPrefix + "foml_desc");
				for(var ii=0; ii<arrLoneRateValue.length;ii++){
					if(tmpFomlDesc.toUpperCase().indexOf(arrLoneRateValue[ii]) > -1) iLoneRateCnt++;
				}
				
			}	
			//Alerting no inputed row
			if(strRows != ""){
				ComShowCodeMessage("PSO00003", "[Base : " + strRows.substring(1) + " Row]");	//mandatory
				return false;
			}
			//Base Total 
			if(sheetObjects[5].RowCount()> 0){
				if(sheetObjects[5].RowCount()> 150){
					//ComOpenWait(true);
					//ComShowCodeMessage("PSO00029");
				}
				for(var i=sheetObjects[5].HeaderRows(); i<sheetObjects[5].HeaderRows()+ sheetObjects[5].RowCount(); i++){
					strPrefix="sheet6_";
					var obj_list_no=sheetObjects[5].GetCellValue(i, strPrefix + "obj_list_no");
					var rate_code=sheetObjects[5].GetCellValue(i, strPrefix + "rate_code");
					var range_from=sheetObjects[5].GetCellValue(i, strPrefix + "range_from").replace(/[,:]/g, ""); 	//ComReplaceStr(from_date.value,"-","");
					var range_to=sheetObjects[5].GetCellValue(i, strPrefix + "range_to").replace(/[,:]/g, "");	//comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
					var rate_value=sheetObjects[5].GetCellValue(i, strPrefix + "rate_value")+"";
					if(ComTrim(obj_list_no) == ""){
						ComShowCodeMessage("PSO00003", "[Base : Object]");	//mandatory
						return false;
					}
					if(rate_code != "F" && range_from == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range From]");	//mandatory
						return false;
					}
					if(rate_code != "F" && range_to == ""){
						ComShowCodeMessage("PSO00003", "[Base : Range To]");	//mandatory
						return false;
					}
					if(ComIsNull(rate_value)){
						ComShowCodeMessage("PSO00003", "[Base : Rate]");	//mandatory
						return false;
					}
					if(Number(range_from) > Number(range_to)){
						ComShowCodeMessage("PSO00018", "[Base : Range To]", "[Base : Range From]");
						return false;
					}
				}
			}
			//Surcharge
			if(sheetObjects[3].RowCount()> 0){
				for(var i=1; i<=sheetObjects[3].RowCount(); i++){
					strPrefix="sheet4_";
					var method_code=sheetObjects[3].GetCellValue(i, strPrefix + "method_code");
					var rate_value=sheetObjects[3].GetCellValue(i, strPrefix + "rate_value")+"";
					var formula_no=sheetObjects[3].GetCellValue(i, strPrefix + "formula_no");
					if(ComIsNull(method_code)){
						ComShowCodeMessage("PSO00003", "[Surcharge : Method]");	//mandatory
						return false;
					}
					if(ComIsNull(rate_value)){
						ComShowCodeMessage("PSO00003", "[Surcharge : Rate]");	//mandatory
						return false;
					}
					if(ComIsNull(formula_no)){
						ComShowCodeMessage("PSO00003", "[Surcharge : Formula ID]");	//mandatory
						return false;
					}
				}
			}
			//Discount
			if(sheetObjects[4].RowCount()> 0){
				for(var i=1; i<=sheetObjects[4].RowCount(); i++){
					strPrefix="sheet5_";
					var method_code=sheetObjects[4].GetCellValue(i, strPrefix + "method_code");
					var rate_value=sheetObjects[4].GetCellValue(i, strPrefix + "rate_value")+"";
					var formula_no=sheetObjects[4].GetCellValue(i, strPrefix + "formula_no");
					if(ComIsNull(method_code)){
						ComShowCodeMessage("PSO00003", "[Discount : Method]");	//mandatory
						return false;
					}
					if(ComIsNull(rate_value)){
						ComShowCodeMessage("PSO00003", "[Discount : Rate]");	//mandatory
						return false;
					}
					if(ComIsNull(formula_no)){
						ComShowCodeMessage("PSO00003", "[Discount : Formula ID]");	//mandatory
						return false;
					}
				}
			}
			
			if(iLoneRateCnt > 0){
				if(!ComShowCodeConfirm("PSO01012")) return false;
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
				comboObjects[0].Focus();
				return false;
			}	
			if(vndr_seq.value == ''){
				ComShowCodeMessage('PSO00011');
				vndr_seq.focus();
				return false;
			}	
			if( comboObjects[3].GetSelectCode()== ''){
				ComShowCodeMessage('PSO00012');
				combo5.Focus();
				return false;
			}	
			break;
		}      
	}
	return true;
}
/********************************************************************************************************************
 * Getting data for condition Combo and combo of sheet
 ********************************************************************************************************************/
function sheet1_OnLoadFinish(sheetObj){ 
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
	
	//comboObjects[3].SetEnable(0);
	formObj.port_cd.focus();
	var movedFrom=formObj.moved_from.value;
	var movedParams=formObj.moved_params.value;
	if(movedFrom != ""){
		if(movedParams != ""){
			f_RetrieveMovedFrom(movedParams);
		}
	}
	formObj.moved_from.value="";
}

/**
 * process after retrieve sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if(sheetObjects[0].RowCount()> 0){
		f_CopyDummy2Base(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_uk"));
		sheetObjects[0].SelectCell(sheetObjects[0].HeaderRows(), 0);
	}else{
		f_RemoveAllSheet("IBCLEAR");
	}
	
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellImage(i, "sheet1_upd_mnu_no_cond", sheetObj.GetCellValue(i, "sheet1_upd_mnu_no_cond_text"));
	}
	
	f_AfterRetrieve();
	
	ComOpenWait(false);
}
function sheet4_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellImage(i, "sheet4_upd_mnu_no_cond", sheetObj.GetCellValue(i, "sheet4_upd_mnu_no_cond_text"));
	}
}
function sheet5_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
		sheetObj.SetCellImage(i, "sheet5_upd_mnu_no_cond", sheetObj.GetCellValue(i, "sheet5_upd_mnu_no_cond_text"));
	}
}
/**
 * process after retrieve sheet1
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	f_RearrangeInSheet2();
}
function sheet2_OnLoadFinish(sheetObj){
	document.getElementById("div_surcharge").style.display="none";
}
function sheet3_OnLoadFinish(sheetObj){
	document.getElementById("div_discount").style.display="none";
}
/**
* IBSheet Popup Event
*/
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula1', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	 
		case prefix + "condition" :				//Condition  popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition1', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
		break;	
	}
}

function setCondition(aryPopupData, row, col, sheetIdx){
	var sheetObject=sheetObjects[sheetIdx];
	var prefix="sheet"+(sheetIdx+1)+"_";
	sheetObject.SetCellValue(row,prefix+"formula_no",aryPopupData[0][1],0);
	sheetObject.SetCellValue(row,prefix+"fomul_desc",aryPopupData[0][2],0);
}
/********************************************************************************************************************
 * <Base(Master) Sheet : Row 선택시 (NewRow, OldRow)>                                       
 ********************************************************************************************************************
 * 1. NewRow의 Formula에 속하는 Object로, Base(Detail) Sheet의 Object Combo를 채운다.                                
 * 2. OldRow의 Data를 Base(Dummy) Sheet에서 삭제한다.  
 * 3. Base(Detail) Data를 Base(Dummy)에 복사한다. 
 * 4. NewRow에 해당하는 Base(Dummy) Data를 Base(Detail)에 복사한다.                                                  
 ********************************************************************************************************************/
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
	
	if(gSelectEvent == false) return; //Sheet1 Row삭제시 OnSelectCell Event를 발생시키지 말것
	if(OldRow == NewRow) return;
	
	f_ControlGridCopyButton();			//Grid Copy Button

	//2. OldRow의 Data를 Base(Dummy) Sheet에서 삭제한다. 삭제된 Row수 return 
	var deletedRows = f_RemoveDummyByBase(sheetObj.GetCellValue(OldRow, "sheet1_uk"));
	sheetObjects[1].SetWaitImageVisible(0);
	
	//1. OldRow의 Formula에 속하는 Object로, Base(Detail) Sheet의 Object Combo를 채운다. 	
	f_SetComboItemByFormula(sheetObj.GetCellValue(OldRow, "sheet1_foml_sys_desc"));
	
	//3. Base(Detail) Data를 Base(Dummy)에 복사한다.
	f_CopyBase2Dummy(sheetObj.GetCellValue(OldRow, "sheet1_uk"));	

	//4. NewRow의 Formula에 속하는 Object로, Base(Detail) Sheet의 Object Combo를 채운다.
	f_SetComboItemByFormula(sheetObj.GetCellValue(NewRow, "sheet1_foml_sys_desc"));
	
	//4. NewRow에 해당하는 Base(Dummy) Data를 Base(Detail)에 복사한다.	
	f_CopyDummy2Base(sheetObj.GetCellValue(NewRow, "sheet1_uk"));
	
	document.getElementById("foml_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_foml_desc");	//Formula Description
	document.getElementById("cond_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_cond_desc");	//Condition Description
	
	gSelectEvent=true;
}
/**
 * Row change
 */ 
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj=document.form;
	if(OldRow == NewRow){
		//return;
	}
	
	if(sheetObj.RowCount()< 1){
		return;
 	}
	
	//var prefix="sheet2_";
	
	//f_SetCellProperty(sheetObj, NewRow);
	/*
	switch (sheetObj.ColSaveName(NewCol)) {
	}*/
}
/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "condition" :				//Condition  popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition2', '0,0', POPUP_IS_MODAL, false, Row, Col, 1);
			f_RearrangeConditionInSheet2(Row);
		break;	 
	}
}

function setCond(aryPopupData, row, col, sheetIdx){
	var sheetObject=sheetObjects[sheetIdx];
	var prefix="sheet"+(sheetIdx+1)+"_";
	
	sheetObject.SetCellValue(row,prefix+"formula"	,aryPopupData[0][1],0);
	sheetObject.SetCellValue(row,prefix+"foml_desc"	,aryPopupData[0][2],0);
}
/**
* IBSheet Popup Event
*/
function sheet4_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet4_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula4', '0,0', POPUP_IS_MODAL, false, Row, Col, 4);
		break;	 
		case prefix + "condition" :				//Condition  popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition4', '0,0', POPUP_IS_MODAL, false, Row, Col, 4);
		break;	 
	}
}
/**
 * IBSheet Popup Event
 */
function sheet5_OnPopupClick(sheetObj,Row,Col){
	var prefix="sheet5_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :				//Formula popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=1";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setFormula5', '0,0', POPUP_IS_MODAL, false, Row, Col, 5);
		break;	 
		case prefix + "condition" :				//Condition  popup
			var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
			ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, 'setCondition5', '0,0', POPUP_IS_MODAL, false, Row, Col, 5);
		break;	 
	}
} 

var sheet1_newCond_row;
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "upd_mnu_no_cond":
			var riceStore = sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//in case of condition created in 0007 screen
				return; 
			}
			
			var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
			var sUrl="/opuscntr/VOP_PSO_0206.do?type=B&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
			sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
			
			sheet1_newCond_row = Row;
			ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "setNewCondition", "0,1", true);
		break;
		
		case prefix + "del_chk" :
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
 		break;	
	}
}

function setNewCondition(rtnVal){
	if(rtnVal != undefined){
		sheetObjects[0].SetCellValue(sheet1_newCond_row, "sheet1_condition",rtnVal.split("||")[0],0);
		sheetObjects[0].SetCellValue(sheet1_newCond_row, "sheet1_cond_desc",rtnVal.split("||")[1],0);
		document.getElementById("cond_desc").innerHTML=rtnVal.split("||")[1];
	}
}
	
/**
 * IBSheet OnClick Event
 */
function sheet2_OnClick(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet2_";
	sheetObj.ShowDebugMsg(false);
	
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :			
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
 		break;	
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
		case prefix + "del_chk" :			
			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
			break;	
	}
}
 /**
  * 
  */
function sheet4_OnClick(sheetObj,Row,Col) {
 	var formObj=document.form;
 	var prefix="sheet4_";
 	sheetObj.ShowDebugMsg(false);
 	
 	switch (sheetObj.ColSaveName(Col)) {
 		case prefix + "upd_mnu_no_cond" :		//prefix + "seq2" :	//Condition creating popup
 			var riceStore=sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//in case of condition created in 0007 screen
				return; 
			}
			
			var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
			var sUrl="/opuscntr/VOP_PSO_0206.do?type=S&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
			sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
			
			gSheet4SelRow = Row;
			ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "SetConditionSheet4", "0,1", true);
 		break;
 		
 		case prefix + "del_chk" :			
 			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
 		break;	
 	}
 }

var gSheet4SelRow = "";
function SetConditionSheet4(val){
	var prefix="sheet4_";
	sheetObj = sheetObjects[3]; 
	if("" != gSheet4SelRow && val != undefined){
		sheetObj.SetCellValue(gSheet4SelRow, prefix + "condition",val.split("||")[0],0);
		sheetObj.SetCellValue(gSheet4SelRow, prefix + "cond_desc",val.split("||")[1],0);
		
		gSheet4SelRow = "";
	}
}
 
 /**
  * IBSheet OnClick Event
  */
 function sheet5_OnClick(sheetObj,Row,Col) {
 	var formObj=document.form;
 	var prefix="sheet5_";
 	sheetObj.ShowDebugMsg(false);
 	
 	switch (sheetObj.ColSaveName(Col)) {
 		case prefix + "upd_mnu_no_cond" :		//prefix + "seq2" :	//Condition creating popup
 			var riceStore=sheetObj.GetCellValue(Row, prefix + "upd_mnu_no_cond_text");
			if(riceStore == "2"){	//in case of condition created in 0007 screen
				return; 
			}
			
			var condNo=sheetObj.GetCellValue(Row, prefix + "condition");
			var sUrl="/opuscntr/VOP_PSO_0206.do?type=D&cond_no=" + condNo + "&pop_title_0206=" + POP_TITLE_0206;
			sUrl += "&seq="+sheetObj.GetCellValue(Row,2);
 			
			gSheet5SelRow = Row;
			ComOpenPopup(sUrl, WIDTH_CONDITION_CREATION_POPUP, HEIGHT_CONDITION_CREATION_POPUP, "SetConditionSheet5", "0,1", true);
 		break;
 		
 		case prefix + "del_chk" :			
 			ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, prefix + "del_chk"));
 		break;	
 	}
 }

 var gSheet5SelRow = "";
 function SetConditionSheet5(val){
 	var prefix="sheet5_";
 	sheetObj = sheetObjects[4]; 
 	if("" != gSheet5SelRow && val != undefined){
 		sheetObj.SetCellValue(gSheet5SelRow, prefix + "condition",val.split("||")[0],0);
 		sheetObj.SetCellValue(gSheet5SelRow, prefix + "cond_desc",val.split("||")[1],0);
 		
 		gSheet5SelRow = "";
 	}
 }
 
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet2_";
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
	} 
}	
function sheet3_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet3_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "regular_value" :
			var val=sheetObj.GetCellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, gPointCut5)){
				sheetObj.SetCellValue(Row, Col,"",0);
				//sheetObj.SelectCell(Row, Col, true, "");
			}
		break;
	}	
}
function sheet4_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet4_";
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
function sheet5_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet5_";
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
 *  setting integer cipher, decimal cipher
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
 * Yard
 */
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	form.year.value="";
	searchVersion();
	f_RemoveAllSheet();
}
function combo1_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");
}  
/**
 * Account CD
 */
function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObject=document.form;
	formObject.account_nm.value=comboObjects[1].GetText(newCode, 1);
	//Cost Combo Setting
	addComboItemCost(comboObjects[1].GetSelectCode());
	form.year.value="";
	searchVersion();
	f_RemoveAllSheet();
	if((comboObjects[1].GetSelectIndex())< 0){
		combo3_OnChange();
	}
}
function combo2_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
}
/**
 * Cost CD
 */
function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
 	var formObject=document.form; 
 	formObject.lgs_cost_nm.value=comboObjects[2].GetText(newCode, 1);
 	form.year.value="";
 	//Initializing combo
 	searchVersion();
}
function combo3_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");
}    
/**
 * Version
 */
function combo4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObject=document.form;
	var curIdx = parseInt(newIndex);
	var localCurrency=ComGetEtcData(searchVersionXML, "localCurrency" );
	
	var data=comboObj.GetText(curIdx, 1).split("~");	//DT
	//var data=data_temp.split("~");	//DT
	formObject.from_date.value=data[0];
	formObject.to_date.value=data[1];
	
	var curr_cd=comboObj.GetText(curIdx, 2);					//CURR_CD
	if(curr_cd == "" || "undefined" == curr_cd) curr_cd=localCurrency;						//if currency of Version()combo is null, local currency
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
				formObject.cpls_flg.checked=true;
			} else{
				formObject.cpls_flg.checked=false;				
			}
			if(comboItem[5] == ""){		//Delete Button		
				ComBtnEnable("btn_DataDelete");		
			} else{						//in case Invoice creates, Disable to Delete Button
				ComBtnDisable("btn_DataDelete");
			}
			if(comboItem[6] != undefined && comboItem[6] != ""){
				formObject.org_vndr_nm.value=comboItems[i].replace(/[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,[^,]*,/g, "");
			} else{
				formObject.org_vndr_nm.value="";
			}
			document.getElementById("info_byte").innerHTML = "("+ComGetLenByByte(formObject.org_vndr_nm) +" Byte)";
			
			//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
/********************************************************************************************************************
 * Tariff Version Retrieving                         
 ********************************************************************************************************************/   
function searchVersion(period){
	var formObj=document.form;
	comboObjects[3].RemoveAll();
	formObj.f_cmd.value=COMMAND02;
	//var port_cd=formObj.port_cd.value;
	//var yard_cd=comboObjects[0].GetSelectCode();
	//var acct_cd=comboObjects[1].GetSelectCode();
	//var cost_cd=comboObjects[2].GetSelectCode();
	//var vndr_seq=formObj.vndr_seq.value;
	//var year=formObj.year.value;
//	if(port_cd == "" || yard_cd == "" || cost_cd == "" || vndr_seq == ""){
//		return;
//	}
	//1.Combo OnChange
	searchVersionXML=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0004GS.do", FormQueryString(formObj));
	//Simple, Complex
	var errorMessage=ComGetEtcData(searchVersionXML, "errorMessage" );
	if(errorMessage != undefined && errorMessage != ""){
		ComShowCodeMessage("PSO00025", "[Simple Tariff]");	//"This data is already input to {?msg1}.";
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		return;
	}
	var comboItems=ComGetEtcData(searchVersionXML, "ver" ).split(ROWMARK);	//<ETC KEY='ver'><![CDATA[yd_chg_no,001,2009-09-01~2009-09-30,KRW,Compulsory,Invoice|...]]></ETC>
	if( comboItems != "" ){ 
		addComboItemVersion(comboObjects[3],comboItems);
		formObj.yd_chg_no.value=comboItems[0].split(FIELDMARK)[0];		
	} else{
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

function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				//formula 를 삭제시에는 conditon 도 같이 삭제처리 한다.
				var deletedRows=f_RemoveDummyByBase(sheetObj.GetCellValue(Row, "sheet1_uk"));
				document.getElementById("foml_desc").innerHTML= "";
				document.getElementById("cond_desc").innerHTML= "";
				gSelectEvent=true;
				
				sheetObj.SetCellValue(Row, prefix + "foml_desc","",0);
				sheetObj.SetCellValue(Row, prefix + "condition","",0);
				sheetObj.SetCellValue(Row, prefix + "cond_desc","",0);
			}
			break;
		case prefix + "condition":
			var val=sheetObj.GetCellValue(Row, Col);
			if("" == val){
				var deletedRows=f_RemoveDummyByBase(sheetObj.GetCellValue(Row, "sheet1_uk"));
				document.getElementById("cond_desc").innerHTML= "";
				gSelectEvent=true;
				
				sheetObj.SetCellValue(Row, prefix + "cond_desc","",0); 
			}
			break;
	}	
} 
function sheet1_OnChange(sheetObj,Row,Col,Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet1_";
	var sheetIdx = "1";
	
	if(Value == OldValue || "" == Value) return;
	
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gFormulaFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setFormula1(rtnArray, Row, Col, sheetIdx);
				
				//in case Formula change, deleting sheet2
				sheetObjects[1].RemoveAll();
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
				
				setCondition1(rtnArray, Row, Col, sheetIdx);
			}else{
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				return;
			}
			break;
	}
}
/********************************************************************************************************************
 * <Base(Detail) OnChange>
 ********************************************************************************************************************/  
function sheet2_OnChange(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet2_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			var arrComboText=sheetObj.GetComboInfo(Row, Col, "Text").split("|");
			var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if(idx == -1){
				return;
			}
			sheetObj.SetCellValue(Row, prefix + "object_code_dsp",arrComboText[idx].split("\t")[1],0);
			if(f_CheckType(Row, "obj_list_no") == true){	
				f_RearrangeInSheet2();
			}
			sheetObj.SetCellValue(Row, prefix + "range_from","",0);
			sheetObj.SetCellValue(Row, prefix + "range_to","",0);
		break;
		case prefix + "object_code_dsp" : 	//in case UOM change, Changing Range(From/To) Type
			f_SetCellProperty(sheetObj, Row);
		break;
		case prefix + "rate_code" :
			if(f_CheckType(Row, "rate_code") == true){		
				f_RearrangeInSheet2();
			}
		break;
	}
}
/********************************************************************************************************************
 * before Base(Detail) Object, Rate Type Combo change, Setting pre values to public variables
 ********************************************************************************************************************/ 
function sheet2_OnBeforeEdit(sheetObj, Row,Col){
	var formObj=document.form;
	var prefix="sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			gSheet2_obj_list_no=sheetObj.GetCellValue(Row,Col);
			gSheet2_object_code_dsp=sheetObj.GetCellValue(Row, prefix + "object_code_dsp");
		break;			
		case prefix + "rate_code" :
			gSheet2_rate_code=sheetObj.GetCellValue(Row,Col);
		break;	
	}
}
/**
 * 
 */
function sheet3_OnChange(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet3_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :
			var arrComboText=sheetObj.GetComboInfo(Row, Col, "Text").split("|");
			var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if(idx == -1){
				return;
			}
			sheetObj.SetCellValue(Row, prefix + "pso_meas_ut_cd_dsp",arrComboText[idx].split("\t")[1],0);
		break;
	}
}

function sheet3_OnSearchEnd(sheetObj){
	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
		f_SetMeasUnitByRow(sheetObj, i);
	}
}
/**
* 
*/
function sheet4_OnChange(sheetObj,Row,Col,Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet4_";
	var sheetIdx = "4";
	if(Value == OldValue || "" == Value) return;
	
	sheetObj.ShowDebugMsg(false);
	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gFormulaFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setFormula4(rtnArray, Row, Col, sheetIdx);
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
				
				setCondition4(rtnArray, Row, Col, sheetIdx);
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
function sheet5_OnChange(sheetObj,Row,Col,Value, OldValue, RaiseFlag) {
	var formObj=document.form;
	var prefix="sheet5_";
	var sheetIdx = "5";
	if(Value == OldValue || "" == Value) return;
	
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "formula_no" :
			var rtnRowData = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02, Value, gFormulaFlag);
			if("undefined" != rtnRowData && "" != rtnRowData){
				var rtnArray=new Array(1);
				rtnArray[0] = rtnRowData.split("|");
				
				setFormula5(rtnArray, Row, Col, sheetIdx);
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
				
				setCondition5(rtnArray, Row, Col, sheetIdx);
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
 * Setting vendor popup
 */
function setVendorSeq(aryPopupData, row, col, sheetIdx){
	var formObj=document.form;
	formObj.vndr_seq.value=aryPopupData[0][1];
	formObj.vndr_lgl_eng_nm.value=aryPopupData[0][2];
	//combo3_OnChange();
	
	searchVersion();
}  
/**
 * Setting Formula popup
 */
function setFormula1(aryPopupData, row, col, sheetIdx){
	var formObject=document.form;
	var prefix="sheet1_";
	var sheetObj=sheetObjects[0];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	var fomlSysDesc=aryPopupData[0][8];	//FOML_SYS_DESC
	
	//2015.12.10 Add.
	/*
	if(name.indexOf("* Rate") > -1){
		ComShowCodeMessage("PSO01012");	
		//ComShowMessage("'Rate' should be setup together with 'Object' in base.\nSystem doesn't recognize which rate is suitable for it.\ne.g. GRT Rate, NRT Rate, Arrival Tug Used Hour Rate..");
		
		sheetObj.SetCellValue(row,prefix+"formula_no","");
		sheetObj.SetCellValue(row,prefix+"foml_desc","");
		sheetObj.SetCellValue(row,prefix+"foml_sys_desc","");
		document.getElementById("foml_desc").innerHTML="";
		
		return;
	}*/
	
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"formula_no","");
		sheetObj.SetCellValue(row,prefix+"foml_desc","");
		sheetObj.SetCellValue(row,prefix+"foml_sys_desc","");
		document.getElementById("foml_desc").innerHTML="";
	} else{
		sheetObj.SetCellValue(row,prefix+"formula_no",code);
		sheetObj.SetCellValue(row,prefix+"foml_desc",name);
		sheetObj.SetCellValue(row,prefix+"foml_sys_desc",fomlSysDesc);
		document.getElementById("foml_desc").innerHTML=name;
	}
	f_SetComboItemByFormula(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_foml_sys_desc"));	//Creating Combo with objects of selected Formula
	f_ControlGridCopyButton();	//Grid Copy Button
}
/**
 * Setting Condition popup
 */ 
function setCondition1(aryPopupData, row, col, sheetIdx){
	var formObject=document.form;
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
		//formObject.cond_desc.value = "";
		document.getElementById("cond_desc").innerHTML="";
	} else{
		sheetObj.SetCellValue(row,prefix+"condition",code,0);
		sheetObj.SetCellValue(row,prefix+"cond_desc",name,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond",riceStore,0);
		sheetObj.SetCellValue(row,prefix+"upd_mnu_no_cond_text",riceStore,0);
		//formObject.cond_desc.value = name;
		document.getElementById("cond_desc").innerHTML=name;
	} 
}   
/**
 * Setting Condition popup
 */ 
function setCondition2(aryPopupData, row, col, sheetIdx){
	var prefix="sheet2_";
	var sheetObj=sheetObjects[1];
	var code=aryPopupData[0][1];
	var name=aryPopupData[0][2];
	if(code == "ID"){
		sheetObj.SetCellValue(row,prefix+"condition","",0);
		sheetObj.SetCellValue(row,prefix+"cond_desc","",0);
	} else{
		sheetObj.SetCellValue(row,prefix+"condition",code,0);
		sheetObj.SetCellValue(row,prefix+"cond_desc",name,0);
	}
}  
/**
 * Setting Formula popup
 */
function setFormula4(aryPopupData, row, col, sheetIdx){
	var prefix="sheet4_";
	var sheetObj=sheetObjects[3];
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
/**
 * Setting Condition popup
 */ 
function setCondition4(aryPopupData, row, col, sheetIdx){
	var prefix="sheet4_";
	var sheetObj=sheetObjects[3];
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
 * Setting Formula popup
 */
function setFormula5(aryPopupData, row, col, sheetIdx){
	var prefix="sheet5_";
	var sheetObj=sheetObjects[4];
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
/**
 * Setting Condition popup
 */ 
function setCondition5(aryPopupData, row, col, sheetIdx){
	var prefix="sheet5_";
	var sheetObj=sheetObjects[4];
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
/*
 * 
 */ 
function f_SetComboAccount(portCd){ 
	//GLOBAL conditionXML
	if( gf_GetCanalPort(portCd)){
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
/********************************************************************************************************************
 * when 'OK' Button Click from Copy Popup(VOP_PSO_0212)
 ********************************************************************************************************************/ 
function f_RetrieveAfterCopy(){		
	var formObject=document.form;
	var param=formObj.copy_condition.value;
	doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
}
/*
 * Copying Sheet2 to Sheet6
 */
function f_CopyBase2Dummy(oldUk){ 
	var sXml=f_MakeSearchXml4CopyBase2Dummy(oldUk);
	sheetObjects[5].SetWaitImageVisible(0);
	sheetObjects[5].LoadSearchData(sXml,{Append:1 , Sync:1} );
}
/*
 * Copying Sheet6 to Sheet2
 */
function f_CopyDummy2Base(uk){
	var sXml=f_MakeSearchXml4CopyDummy2Base(uk);
	sheetObjects[1].SetWaitImageVisible(0);
	sheetObjects[1].LoadSearchData(sXml, {Sync:1});
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
	//Deleting UK
	for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
		sheetObjects[5].RowDelete( i, false );
	}
	return zzz.length;//count of Deleting Rows
}
/********************************************************************************************************************
 * <Base(Detail) Object 또는 Rate Type 변경시 : 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed' 존재 여부 Check>                          
 ********************************************************************************************************************
 * 1. 연속된 Row에 동일 Object, UOM, Rate Type 中 'Fixed'가 존재하면, Alert()후, 이전 값으로 Setting한다.                                          
 ********************************************************************************************************************/  
function f_CheckType(Row, section){
	var sheetObj	= sheetObjects[1];
	var prefix		= "sheet2_";
	var is_type_f	= true;
	var selRateCode	= sheetObj.GetCellValue(Row, prefix + "rate_code");
	
	if(selRateCode == "F"){		//Fixed
		//object, object_code, rate_code 동일 여부 체크 
		var pre_obj_list_no	= "";
		var pre_rate_code	= "";
		
		var obj_list_no		= "";
		var rate_code		= "";
		
		for(var i=(Row-1); i<=(Row+1); i++){ 
			pre_obj_list_no	= i == sheetObj.HeaderRows()? "-1" : sheetObj.GetCellValue(i-1, prefix + "obj_list_no");
			pre_rate_code	= i == sheetObj.HeaderRows()? "-1" : sheetObj.GetCellValue(i-1, prefix + "rate_code");
			
			obj_list_no		= sheetObj.GetCellValue(i, prefix + "obj_list_no");
			rate_code		= sheetObj.GetCellValue(i, prefix + "rate_code");
			
			if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && pre_rate_code == "F"){	//바로 윗 row와 같다면
				if(section == "obj_list_no"){
					ComShowCodeMessage("PSO00024", "[Object]"); //동일 Object에 Fixed 타입의 데이터가 이미 입력되었습니다. 따라서 [Object] 변경이 불가능합니다.	
					sheetObj.SetCellValue(Row, prefix + "obj_list_no"		,gSheet2_obj_list_no	,0); //이전 값으로 세팅
					sheetObj.SetCellValue(Row, prefix + "object_code_dsp"	,gSheet2_object_code_dsp,0);//이전 값으로 세팅
				} else if(section == "rate_code"){
					ComShowCodeMessage("PSO00024", "[Rate Type]"); //동일 Object에 Fixed 타입의 데이터가 이미 입력되었습니다. 따라서 [Rate Type] 변경이 불가능합니다.	 
					sheetObj.SetCellValue(Row, prefix + "rate_code"			,gSheet2_rate_code,0); //Fixed로 변경하지 않고, 이전 값으로 세팅
				}
				is_type_f=false;
				break;
			}
		}				
		if(is_type_f == true){
			sheetObj.SetCellValue(Row	, prefix + "range_from"	,"",0);
			sheetObj.SetCellValue(Row	, prefix + "range_to"	,"",0);
			
			sheetObj.SetCellEditable(Row, prefix + "range_from"	,0);
			sheetObj.SetCellEditable(Row, prefix + "range_to"	,0);
		}
	} else{
		sheetObj.SetCellEditable(Row, prefix + "range_from"	,1);
		sheetObj.SetCellEditable(Row, prefix + "range_to"	,1);
	}
	return is_type_f;
}
/********************************************************************************************************************
 * <Base(Detail) Sheet의 Data에 따른 Seq. Numbering, Cell 활성화 등 각종 제약사항 표현>                          
 ********************************************************************************************************************
 * 1. Seq.는 10부터 시작하여 10씩 증가한다.                             
 * 2. Object, UOM, Rate Type이 같으면 동일 Seq.를 갖는다.                             
 * 3. 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed'는 가질 수 없다. 
 * 4. Rate Type이 'Fixed'일 경우, Range(From/To)는 값이 없다.
 * 5. 동일 Seq.이면 Rate Condition과 Alias는 같다.                                              
 ********************************************************************************************************************/ 
function  f_RearrangeInSheet2(){
	var prefix="sheet2_";
	var sheetObj=sheetObjects[1];
	sheetObj.RenderSheet(0);
	
	var pre_seq				=0;
	var pre_obj_list_no		="";
	var pre_object_code_dsp	="";
	var pre_rate_code		="";
	
	var obj_list_no			="";
	var object_code_dsp		="";
	var rate_code			="";
	
	var condition			="";
	var cond_desc			="";
	var alias				="";
	
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
		pre_seq				= i == sheetObj.HeaderRows()? 0											   			: Number(sheetObj.GetCellValue(i-1, prefix + "seq"));
		pre_obj_list_no		= i == sheetObj.HeaderRows()? "-1" 	   									   			: sheetObj.GetCellValue(i-1, prefix + "obj_list_no");
		pre_object_code_dsp	= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "object_code_dsp")	: sheetObj.GetCellValue(i-1, prefix + "object_code_dsp");
		pre_rate_code		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "rate_code")   		: sheetObj.GetCellValue(i-1, prefix + "rate_code");
		pre_condition		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "condition")   		: sheetObj.GetCellValue(i-1, prefix + "condition");
		pre_cond_desc		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "cond_desc")   		: sheetObj.GetCellValue(i-1, prefix + "cond_desc");
		pre_alias			= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "cons_als_nm") 		: sheetObj.GetCellValue(i-1, prefix + "cons_als_nm");
		
		obj_list_no			=sheetObj.GetCellValue(i, prefix + "obj_list_no");
		object_code_dsp		=sheetObj.GetCellValue(i, prefix + "object_code_dsp");
		rate_code			=sheetObj.GetCellValue(i, prefix + "rate_code");
		condition			=sheetObj.GetCellValue(i, prefix + "condition");
		cond_desc			=sheetObj.GetCellValue(i, prefix + "cond_desc");
		alias				=sheetObj.GetCellValue(i, prefix + "cons_als_nm");
		
		if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && rate_code != "F"){	//바로 윗 row와 같다면
			sheetObj.SetCellValue(i, prefix + "seq"				, pre_seq				,0);
			sheetObj.SetCellValue(i, prefix + "object_code_dsp"	, pre_object_code_dsp	,0);
			sheetObj.SetCellValue(i, prefix + "rate_code"		, pre_rate_code			,0);
			sheetObj.SetCellValue(i, prefix + "condition"		, pre_condition			,0);
			sheetObj.SetCellValue(i, prefix + "cond_desc"		, pre_cond_desc			,0);
			sheetObj.SetCellValue(i, prefix + "cons_als_nm"		, pre_alias				,0);
			
			sheetObj.SetCellEditable(i, prefix + "condition"	,0);
			sheetObj.SetCellEditable(i, prefix + "cons_als_nm"	,0);
		} else{
			sheetObj.SetCellValue(i, prefix + "seq"				,pre_seq + 10		,0);
			sheetObj.SetCellValue(i, prefix + "object_code_dsp"	,object_code_dsp	,0);
			sheetObj.SetCellValue(i, prefix + "rate_code"		,rate_code			,0);
			sheetObj.SetCellValue(i, prefix + "condition"		,condition			,0);
			sheetObj.SetCellValue(i, prefix + "cond_desc"		,cond_desc			,0);
			sheetObj.SetCellValue(i, prefix + "cons_als_nm"		,alias				,0);
			
			sheetObj.SetCellEditable(i, prefix + "condition"	,1);
			sheetObj.SetCellEditable(i, prefix + "cons_als_nm"	,1);
		}
		if(rate_code == "F"){
			
			sheetObj.SetCellValue(i, prefix + "range_from"	,"",0);
			sheetObj.SetCellValue(i, prefix + "range_to"	,"",0);
			
			sheetObj.SetCellEditable(i, prefix + "range_from"	,0);
			sheetObj.SetCellEditable(i, prefix + "range_to"		,0);
		}else{
			if("TIME" == object_code_dsp){
				var tmpRangeFrByTm = sheetObj.GetCellValue(i, prefix + "range_from" )+"";
				var tmpRangeToByTm = sheetObj.GetCellValue(i, prefix + "range_to" )+"";
				
				sheetObj.SetCellValue(i, prefix + "range_from"	,ComLpad(tmpRangeFrByTm,4, "0"), 0);
				sheetObj.SetCellValue(i, prefix + "range_to"	,ComLpad(tmpRangeToByTm,4, "0"), 0);
			}
		}
		
		f_SetMeasUnitByRow(sheetObj, i);
	}		
	sheetObj.RenderSheet(1);
}
/********************************************************************************************************************
 * <Base(Detail) Sheet의 Data에 따른 Seq. Numbering, Cell 활성화 등 각종 제약사항 표현>                          
 ********************************************************************************************************************
 * 1. Seq.는 10부터 시작하여 10씩 증가한다.                             
 * 2. Object, UOM, Rate Type이 같으면 동일 Seq.를 갖는다.                             
 * 3. 연속된 Row에서는 동일 Object, UOM, Rate Type 中 'Fixed'는 가질 수 없다. 
 * 4. Rate Type이 'Fixed'일 경우, Range(From/To)는 값이 없다.
 * 5. 동일 Seq.이면 Rate Condition과 Alias는 같다.                                              
 ********************************************************************************************************************/
function  f_RearrangeConditionInSheet2(Row){
	var prefix="sheet2_";
	var sheetObj=sheetObjects[1];
	sheetObj.RenderSheet(0);
	
	var pre_obj_list_no		= "";
	var pre_object_code_dsp	= "";
	var pre_rate_code		= "";
	var obj_list_no			= "";
	var object_code_dsp		= "";
	
	var rate_code			= "";
	var condition			= "";
	var cond_desc			= "";
	var alias				= "";
	
	for(var i=Row; i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
		if(i == Row){
			continue;
		}
		pre_obj_list_no		= i == sheetObj.HeaderRows()? "-1" 	   									   			: sheetObj.GetCellValue(i-1, prefix + "obj_list_no");
		pre_object_code_dsp	= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "object_code_dsp")	: sheetObj.GetCellValue(i-1, prefix + "object_code_dsp");
		pre_rate_code		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "rate_code")   		: sheetObj.GetCellValue(i-1, prefix + "rate_code");
		pre_condition		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "condition")   		: sheetObj.GetCellValue(i-1, prefix + "condition");
		pre_cond_desc		= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "cond_desc")   		: sheetObj.GetCellValue(i-1, prefix + "cond_desc");
		pre_alias			= i == sheetObj.HeaderRows()? sheetObj.GetCellValue(i, prefix + "cons_als_nm") 		: sheetObj.GetCellValue(i-1, prefix + "cons_als_nm");
		
		obj_list_no			= sheetObj.GetCellValue(i, prefix + "obj_list_no");
		object_code_dsp		= sheetObj.GetCellValue(i, prefix + "object_code_dsp");
		rate_code			= sheetObj.GetCellValue(i, prefix + "rate_code");
		condition			= sheetObj.GetCellValue(i, prefix + "condition");
		cond_desc			= sheetObj.GetCellValue(i, prefix + "cond_desc");
		alias				= sheetObj.GetCellValue(i, prefix + "cons_als_nm");
		
		if(obj_list_no == pre_obj_list_no && rate_code == pre_rate_code && rate_code != "F"){	//바로 윗 row와 같다면
			sheetObj.SetCellValue(i, prefix + "condition"	,pre_condition,0);
			sheetObj.SetCellValue(i, prefix + "cond_desc"	,pre_cond_desc,0);
			sheetObj.SetCellValue(i, prefix + "cons_als_nm"	,pre_alias,0);
			
			sheetObj.SetCellEditable(i, prefix + "condition"	,0);
			sheetObj.SetCellEditable(i, prefix + "cons_als_nm"	,0);
		} else{
			break;
			sheetObj.SetCellValue(i, prefix + "condition"	,condition,0);
			sheetObj.SetCellValue(i, prefix + "cond_desc"	,cond_desc,0);
			sheetObj.SetCellValue(i, prefix + "cons_als_nm"	,alias,0);
			
			sheetObj.SetCellEditable(i, prefix + "condition"	,1);
			sheetObj.SetCellEditable(i, prefix + "cons_als_nm"	,1);
		}
	}		
	sheetObj.RenderSheet(1);
}
/*
 * Clearing all Sheets
 */
function f_RemoveAllSheet(section){
	/******************************/
	if(section == undefined){
		return;
	} else if(section == "IBCLEAR"){
	}
	/******************************/
	var formObject=document.form;
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
	document.getElementById("foml_desc").innerHTML="";
	document.getElementById("cond_desc").innerHTML="";
	formObject.cpls_flg.checked=false;
}
function f_AfterRetrieve(){
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
	if(sheetObjects[0].RowCount()> 0){
		document.form.cpls_flg.checked=sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_cpls_flg") == "Y" ? true : false;
	} else{
		document.form.cpls_flg.checked=false;
	}
}
/********************************************************************************************************************
 * Handling Grid Copy Button
 ********************************************************************************************************************/
function f_ControlGridCopyButton(){
	return;
	var sheetObj=sheetObjects[0];
	var selectedRow=sheetObj.GetSelectRow();
	//first row
	if(selectedRow == sheetObj.HeaderRows()){
		ComBtnDisable("btn_GridCopy");
	} else{
		var foml_no_1=sheetObj.GetCellValue(selectedRow, "sheet1_formula_no");
		var foml_no_2=sheetObj.GetCellValue(selectedRow-1, "sheet1_formula_no");
		//in case same as formula of next above row
		if(foml_no_1 != "" && foml_no_1 == foml_no_2){			
			ComBtnEnable("btn_GridCopy");
		} else{
			ComBtnDisable("btn_GridCopy");			
		}
	}
}
/********************************************************************************************************************
 * calling from 'Tariff Update' in VOP_PSO_0036
 * Setting conditions and Retrieving data
 ********************************************************************************************************************/
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
/********************************************************************************************************************
 * Getting UK Seq when Base(Master) RowAdd   
 ********************************************************************************************************************/ 
function f_GetMinValInSheet(sheetObj, col){
	var minVal=0;
	var tmpVal=0;
	if(sheetObj.RowCount()== 0){
		minVal=0;
	} else{
		for(var i=sheetObj.HeaderRows(); i<sheetObj.LastRow()+1; i++){
			tmpVal=Number(sheetObj.GetCellValue(i, col));
			if(tmpVal < minVal){
				minVal=tmpVal;
			}
		}
	}
	return minVal;
}
/********************************************************************************************************************
 * Making Base(Detail) Object Combo except 45          
 ********************************************************************************************************************/ 
function f_SetComboItemByFormula(fomlSysDesc){
	if(fomlSysDesc == -1) fomlSysDesc = "";
	var regExp=/\[[0-9]+\]|<[0-9]+>/gim;
	var result=fomlSysDesc.match(regExp);
	if(result != null){
		var strObjCode="," + result.join(",").replace(/\[45\]/g, "").replace(/\[|\]|<|>/g, "") + ",";	//exception Rate
		var comboItems=ComGetEtcData(conditionXML, "objlist");
	 	var comboCode="";
	 	var comboText="";
	 	arrComboItems=comboItems.split("|");
	 	for (i=0 ; i < arrComboItems.length ; i++) {
	 		var comboItem=arrComboItems[i].split(",");
	 		//comboItem[0] : PSO_OBJ_CD                       
	 		//comboItem[1] : PSO_OBJ_CD_DSP                   
	 		//comboItem[2] : PSO_MEAS_UT_CD                   
	 		//comboItem[3] : PSO_MEAS_UT_CD_DSP               
	 		//comboItem[4] : OBJ_LIST_NO                      
	 		if(strObjCode.indexOf("," + comboItem[4] + ",") > -1){
				comboCode += "|" + comboItem[4];
				comboText += "|" + comboItem[1] + "\t" + comboItem[3];
	 		}
	 	}
	 	comboCode=comboCode.substr(1);	//Code
	 	comboText=comboText.substr(1); 	//Text
		//Setting Object Combo of Base Sheet
		sheetObjects[1].SetColProperty("sheet2_obj_list_no", {ComboText:comboText, ComboCode:comboCode} );
	} else{
		//Setting Object Combo of Base Sheet
		sheetObjects[1].SetColProperty(0, "sheet2_obj_list_no", {ComboText:"", ComboCode:""} );
	}
}
/********************************************************************************************************************
 * Changing Range Type as Base(Detail) UOM
 ********************************************************************************************************************/ 
function f_SetCellProperty(sheetObj, row){
	
	f_SetMeasUnitByRow(sheetObj, row);
	/*
	var prefix="sheet2_";
	var val		= sheetObj.GetCellValue(row, prefix + "object_code_dsp");	//UOM
	
	if(val == "TIME"){
		sheetObj.InitCellProperty(row, prefix + "range_from",{ Type:"Date",Align:"Right",Format:"Hm"} );
		sheetObj.InitCellProperty(row, prefix + "range_to",{ Type:"Date",Align:"Right",Format:"Hm"} );
	} else{			
		sheetObj.InitCellProperty(row, prefix + "range_from",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		sheetObj.InitCellProperty(row, prefix + "range_to",{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	}*/	
}
/********************************************************************************************************************
 * Getting Base(Dummy) data about Base(Master) NewRow
 ********************************************************************************************************************/ 
function f_MakeSearchXml4CopyDummy2Base(uk)  {
	var sheetObj=sheetObjects[5];
	try {
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
		var aryTR=new Array();
		for( var ir=sheetObj.HeaderRows(); ir<sheetObj.RowCount()+ sheetObj.HeaderRows(); ir++ ) {
			if(sheetObj.GetCellValue(ir, "sheet6_uk") == uk){
				for(var ic=0; ic<gColumnCountInSheet2; ic++){
					aryTD[ic]=sheetObj.GetCellValue(ir, ic);
				}
				aryTR[k++]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
			}
		}
		allXml += aryTR.join("\n")
			    + "  \n</DATA>\n"
		        + "</SHEET>";
		aryTD=new Array();
		aryTR=new Array();
		return allXml;
	} catch(err) { ComFuncErrMsg(err.message); }
}  
/********************************************************************************************************************
 * Getting Base(Detail) Data
 ********************************************************************************************************************/ 
function f_MakeSearchXml4CopyBase2Dummy(oldUk)  {
	var sheetObj=sheetObjects[1];
	try {
		var allXml="";
		var hColSep="|";
		var sColSep="☜☞";
		var sColOrder="";
		var aryTD=new Array(gColumnCountInSheet2);
		for(var i=0; i < gColumnCountInSheet2; i++){
			if (sheetObj.ColSaveName(i) != -1)
				aryTD[i]=sheetObj.ColSaveName(i).replace(/sheet2/g, "sheet6");
		}
		sColOrder=aryTD.join(hColSep);
		allXml="<?xml version='1.0'  ?>\n" 
			   + "<SHEET>\n"
		       + "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
		var aryTR=new Array();
		for( var ir=sheetObj.HeaderRows(); ir<sheetObj.RowCount()+ sheetObj.HeaderRows(); ir++ ) {
			for(var ic=0; ic<gColumnCountInSheet2; ic++){
				if(sheetObj.ColSaveName(ic) == "sheet2_range_from" || sheetObj.ColSaveName(ic) == "sheet2_range_to"){
					//in case of Range, Repositing Mask
					//aryTD[ic]=sheetObj.GetCellText(ir, ic); //2016.01.08
					aryTD[ic]=sheetObj.GetCellValue(ir, ic);
				} else{
					aryTD[ic]=sheetObj.GetCellValue(ir, ic);
				}
			}
			aryTR[ir-sheetObj.HeaderRows()]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
		}
		allXml += aryTR.join("\n");
		allXml += "  \n</DATA>\n"
		       +  "</SHEET>";
			aryTD=new Array();
			aryTR=new Array();
		return allXml;
	} catch(err) { ComFuncErrMsg(err.message); }
}  
function f_SetHeadUnCheckAll(){
	var objGetHeaderCheck=[
        {"sheetObj" : "sheetObjects[0]", "rows" : "0,1", "col" : "sheet1_del_chk"}
       ,{"sheetObj" : "sheetObjects[1]", "rows" : "0,1", "col" : "sheet2_del_chk"}                   
       ,{"sheetObj" : "sheetObjects[3]", "rows" : "0",   "col" : "sheet4_del_chk"}                 
       ,{"sheetObj" : "sheetObjects[4]", "rows" : "0",   "col" : "sheet5_del_chk"}              
	   ];
	gf_SetHeadUnCheckAll(objGetHeaderCheck);
}
function f_SetHeadUnCheck(objGetHeaderCheck){
	gf_SetHeadUnCheckAll(objGetHeaderCheck);
}



/**
 * Move Screen for Tariff Update
 * @param mode ( 1 : simple Tariff - move to 0002, 2: complex Tariff - move to 0004
 */
function moveToUpdate(){
	var formObj=document.form;
	
	var params = "parentPgmNo=VOP_PSO_M001&moved_from=0004&pgmNo=VOP_PSO_0036";
	if(formObj.port_cd.value == ""){
		this.location="/opuscntr/VOP_PSO_0036.do?" + params;
	}
	
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

function resizeSheet(){
	var chkCase = "";
	if($("#cSur").is(":checked")){
		chkCase="C";
	}
	if($("#cDis").is(":checked")){
		chkCase="D";
	}
	if("C"==chkCase){
		ComResizeSheet(sheetObjects[3], 20);
	}else if("D" == chkCase){
		ComResizeSheet(sheetObjects[4], 20);
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

//function sheet1_onselect(sheetObj){
//	document.getElementById("foml_desc").innerHTML=sheetObj.GetCellValue(sheetObj.HeaderRows(), "sheet1_foml_desc");	//Formula Description
//	document.getElementById("cond_desc").innerHTML=sheetObj.GetCellValue(sheetObj.HeaderRows(), "sheet1_cond_desc");	//Condition Description
//	f_SetComboItemByFormula(sheetObj.GetCellValue(sheetObj.HeaderRows(), "sheet1_foml_sys_desc"));	
//}
