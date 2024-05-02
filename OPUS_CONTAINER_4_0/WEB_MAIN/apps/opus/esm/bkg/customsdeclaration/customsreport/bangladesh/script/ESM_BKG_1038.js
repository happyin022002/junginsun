/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1038.js
*@FileTitle  : Bangladesh Cargo Manifest - Freight Forward License No.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
 /**
	 * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
	 * @author
	 */
/**
 * @extends
 * @class Customer License Info : It defines business script that using screen for Customer License Info creation.
 */
function esm_bkg_1038() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.setComboObject=setComboObject;
	this.validateForm=validateForm;
}
//Common global variables
var sheetObjects=new Array();
var sheetCnt=0;
//Event Handler definition for Button Click event */
document.onclick=processButtonClick;
// Event Handler for branch processing by judging button name. */
	function processButtonClick(){
		  /***** using extra sheet valuable if there are more 2 sheets *****/
		 var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
				case "btn_new":
					//initializing form
					sheetObjects[0].RemoveAll();
					formObject.cust_lic_no.value='';
					formObject.cust_cd.value='';
					formObject.cust_nm.value='';
					formObject.cust_lic_no.focus();
					break;
				case "btn_close":
					ComClosePopup();
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break;
				case "btn_rowdelete":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
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
	  * Registering IBSheet Object in to Array
	  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
	  * The array is defined at upper part of source
	  *
	  * @param {IBSheet} sheet_obj mandatory, IBSheet control
	  * @return none
	  */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	  * Sheet basic setting & initializing
	  * onLoad Event HandlerImplementation of body tag
	  * After loading screen in the browser, add function in pre-processing
	  * @return none
	  */
	function loadPage() {
		 var formObject=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		axon_event.addListenerForm("FocusOut","obj_FocusOut", document.form);
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("keypress","obj_Keypress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		axon_event.addListenerForm("click", "obj_Click", document.form);
		formObject.cust_lic_no.focus();
	}
  /**
	 * Definition for sheet initial setting value, header
	 * param : sheetObj ==> sheet object, sheetNo ==> If the serial number ID tag attached to the sheet are many,
	 * adding 'Case' clause as a number of sheets, configures initial module.
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
				with(sheetObj){

			  var HeadTitle1="|Sel.|Seq.|License No.|Customer Code|Customer Name|Updated Date|Updated ID|";
			  var headCount=ComCountHeadTitle(HeadTitle1);

			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_lic_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8,   AcceptKeys:"E|N" ,   InputCaseSensitive:1},
					 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			  InitColumns(cols);

			  SetEditable(1);
			  SetSheetHeight(300);

			  }

			break;
	}
}
	/**
	 *  Handling process about Sheet
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction))
				{
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					if(sheetObj.id == "sheet1")
						sheetObj.DoSearch("ESM_BKG_1038GS.do", FormQueryString(formObj) );
					ComOpenWait(false);
				}
				break;
			case IBSAVE:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_BKG_1038GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			break;
			case IBINSERT:
				var row=sheetObj.DataInsert(-1);
				sheetObj.SetCellEditable(row, "Chk",1);
				sheetObj.SetCellEditable(row, "cust_lic_no", 1);
				sheetObj.SetCellEditable(row, "cust_cd", 1);
				sheetObj.SetCellEditable(row, "cust_nm", 0);
				sheetObj.SetCellEditable(row, "upd_dt", 0);
				sheetObj.SetCellEditable(row, "upd_usr_id", 0);
				break;
			case IBROWSEARCH:
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				formObj.f_cmd.value=SEARCH01;
				var Row=sheetObj.GetSelectRow();
				var custValue="";
				var tempValue="";
				var tempZero="";
				custValue=sheetObj.GetCellText(Row, "cust_cd");
				tempValue=custValue.substring(2);
				if(tempValue.length != 6 && tempValue.length != 0)
				{
					for(var i=1; i <= 6 - tempValue.length;i++)
					{
						tempZero=tempZero + "0"
					}
					custValue=custValue.substring(0,2) + tempZero + tempValue;
					sheetObj.SetCellValue(Row, "cust_cd",custValue,0);
				}
				var params=FormQueryString(formObj)+"&cust_grid_cd="+sheetObj.GetCellValue(Row, "cust_cd");
				var sXml=sheetObj.GetSearchData("ESM_BKG_1038GS.do", params);
				var cust_cd=ComGetEtcData(sXml, "cust_cd");
				var cust_nm=ComGetEtcData(sXml, "cust_nm");
				var cust_cnt=ComGetEtcData(sXml, "cust_cnt");
				if(cust_cd == undefined || cust_cd == ""){
					ComShowCodeMessage("BKG06012", sheetObj.GetCellText(Row, "cust_cd"));
					sheetObj.SetCellValue(Row, "cust_cd","",0);
					sheetObj.SelectCell(Row, "cust_cd");
					if(sheetObj.id == "sheet1"){
						sheetObj.SetCellValue(Row, "cust_nm","",0);
					}
				}else if(cust_cnt > 0){
					ComShowCodeMessage("BKG06061", sheetObj.Celltext(Row, "cust_cd"));
					sheetObj.SetCellValue(Row, "cust_cd","",0);
					sheetObj.SelectCell(Row, "cust_cd");
					if(sheetObj.id == "sheet1"){
						sheetObj.SetCellValue(Row, "cust_nm","",0);
					}
				}else{
					sheetObj.SetCellValue(Row, "cust_cd",cust_cd,0);
					if(sheetObj.id == "sheet1"){
						sheetObj.SetCellValue(Row, "cust_nm",cust_nm,0);
					}
				}
				break;
			case IBDELETE:     //Row Delete
				if(ComShowCodeConfirm('BKG03037')){
					ComRowHideDelete(sheetObj,"Chk");
				}
				break;
			case IBDOWNEXCEL:   //Down Excel
				ComOpenWait(true);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
		}
	}
	/**
	 * Handling validity verification process about screen form input value.
	 */
	function validateForm(sheetObj,formObj,sAction){
		 switch (sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case IBSAVE:
				break;
		 }
	  return true;
	}
	 /**
	 * After saving, event : If it is successful without Error Message after Multi command performs, search final data through IBSEARCH.
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	  function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var saveGubun=formObj.f_cmd.value;
		if (ErrMsg == "") {
			ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	  }
  /**
   * Handling event Change
   */
	function sheet1_OnChange(sheetObj, row, col, val){
		if(sheetObj.ColSaveName(col) == "seal_pty_tp_cd") {
			document.form.seal_pty_tp_cd.SetSelectCode(val);
			sheetObj.SetCellValue(row, "seal_pty_nm", document.form.seal_pty_tp_cd.GetSelectText(),0);

		} else if (sheetObj.ColSaveName(col) == "cust_cd" && sheetObj.GetCellValue(row, "cust_cd") != ""){
			for(var i=1; i<=sheetObj.LastRow(); i++){
				if(i == row) continue;
				if(sheetObj.GetCellValue(i, "cust_cd") == sheetObj.GetCellValue(row, "cust_cd")) {
					ComShowCodeMessage("BKG06046");    // "Customer Code. is duplicated. Check customer code."
					sheetObj.SetCellValue(row, "cust_cd", "", 0);
					sheetObj.SelectCell(row, "cust_cd");
					return;
				}
			}
			doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
		}
	}
	/**
	 * Handling event when moves mouse
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseMove(Button, Shift, X, Y) {
		Row=sheetObjects[0].MouseRow();
		Col=sheetObjects[0].MouseCol();
		var colSaveName=sheetObjects[0].ColSaveName(Col);
		if(colSaveName == "upd_usr_id") {
			sText=sheetObjects[0].GetCellText(Row,"upd_usr_nm");
		} else if(colSaveName == "consignee_cust_nm") {
				sText=sheetObjects[0].GetCellText(Row,Col);
		} else {
			sText="";
		}
		//making tooltip
		sheetObjects[0].MouseToolTipText=sText;
	}
	/**
	 * after retrieve, handles it
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg)
	{
		var irow=sheetObj.LastRow();
		sheetObj.GetRowMerge(irows);
	}
	/**
	* Controlling keyboard input in onkeypress event of HTML Control.
	**/
	function obj_Keypress(){
		var srcName=ComGetEvent("name");
		var srcValue=event.srcElement.getAttribute("value");
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
			case "uppernum":
				   ComKeyOnlyAlphabet('uppernum');
				   break;
			case "upper":
				   ComKeyOnlyAlphabet('upper');
				   break;
			case "saupja":
				//number + "+-."
				ComKeyOnlyNumber(event.srcElement, "/-.");
				break;
			case "etc": //all characters are possible but English must Upper case
				if(keyValue >= 97 && keyValue <= 122) {//lower case
					event.keyCode=keyValue + 65 - 97;
				}
				break;
			case "ymd":
				   //alert(srcValue.length);
				ComKeyOnlyNumber(event.srcElement);
				   if (srcValue.length == 4) {
					document.form.elements[srcName].value=srcValue.substring(0,4) + "-"
				   }
				   if (srcValue.length == 7) {
					 document.form.elements[srcName].value=srcValue.substring(0,7) + "-"
				   }
					 break;
			   default:
				   ComKeyOnlyNumber(event.srcElement);
		}
	}
	/**
	 * Controlling keyboard input in onkeyUp event of HTML Control.
	 **/
	 function obj_KeyUp() {
			var formObject=document.form;
			var srcName=ComGetEvent("name");
			var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
			var srcValue=window.event.srcElement.getAttribute("value");
			if (ComChkLen(srcValue, srcMaxLength) == "2") {
				ComSetNextFocus();
			}
	 }
	 /**
	  * Controlling keyboard input in FOCUS OUT event of HTML Control.
	  * CUSTOMER CODE input field change
	  **/
	 function obj_FocusOut(){
		var srcObj=window.event.srcElement;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		var tempValue="";
		var tempZero="";
		if (srcName == "cust_cd") {
			tempValue=srcValue.substring(2);
			if(tempValue.length != 6 && tempValue.length != 0)
			{
				for(var i=1; i <= 6 - tempValue.length;i++)
				{
					tempZero=tempZero + "0"
				}
				srcValue=srcValue.substring(0,2) + tempZero + tempValue;
				srcObj.form.elements[srcName].value=srcValue;
			}
		}
	 }
	/**
	* Controlling keyboard input in ENTER KEY event of HTML Control.
	* When changing CUSTOMER CODE input field, after FOCUS OUT inquiry processiing
	**/
	function obj_ComKeyEnter() {
		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyValue == 13) {
			obj_FocusOut();
			var obj=document.getElementById("btn_Retrieve");
			if (obj==null) obj=document.getElementById("btn_retrieve");
			if (obj) obj.fireEvent("onclick");
		}
	}
