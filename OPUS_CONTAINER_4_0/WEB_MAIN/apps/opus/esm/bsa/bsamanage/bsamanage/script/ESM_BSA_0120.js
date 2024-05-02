/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0120.jsp
*@FileTitle  : Carrier's Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
 var sheetObjects=new Array();
 var sheetCnt=0;
 var selValue="";
 var selRow=0;
 /* Event handler processing by button click event */
 document.onclick=processButtonClick;
 /* Event handler processing by button name */
 function processButtonClick() {
 	var sheetObject=sheetObjects[0];
 	var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
 		if(ComGetBtnDisable(srcName)) return false;
 		switch(srcName) {
 			case "btn_retrieve":
 				doActionIBSheet(sheetObject,formObject,IBSEARCH);
 				break;
 			case "btn_rowadd":
 				sheetObject.DataInsert();
 				break;
 			case "btn_save":
 				doActionIBSheet(sheetObject,formObject,IBSAVE);
 				break;
 			case "btn_downexcel":
 				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 				break;
 			case "btn_close":
 				ComClosePopup(); 
 				break;
 			 case "btn_ok":
 				var chkRow=sheetObject.FindCheckedRow("radio");
 				var bsaOpCd=formObject.bsa_op_cd.value;
 				var arrRow=chkRow.split("|");
// 				  for (idx=0; idx<arrRow.length-1; idx++){ 
 				  for (idx=0; idx<arrRow.length; idx++){
 					  var crrCd=sheetObject.GetCellValue(arrRow[0],"crr_cd");
 				  }
 				 var param="crr_cd="+crrCd+"&rdoOp_cd="+bsaOpCd+"&f_cmd="+MULTI02;
// 				 if (arrRow.length == 2){
 				if (arrRow.length == 1){
 					ComOpenWait(true); 
  					var sXml=sheetObj.GetSaveData("ESM_BSA_0120GS.do",param);
 					ComOpenWait(false); 
 				}
 				comPopupOK();
 				break;
 		} // end switch
 	} catch(e) {
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
 function setSheetObject(sheet_obj) {
 	 sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
  * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
  */
 function loadPage() {
 	for (i=0; i<sheetObjects.length; i++) {
 		ComConfigSheet(sheetObjects[i]);
 		initSheet(sheetObjects[i], i+1, "");
 		ComEndConfigSheet(sheetObjects[i]);
 	}
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  
 }
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo,header) {
 	var arrHeader="";
 	var formObject=document.form;
 	switch(sheetNo) {
 		case 1:      //sheet1 init
 		    with(sheetObj){
	 	      var HeadTitle="||Code|Name";
	 	      var cnt=0;
	 	      var first_hiden = 0;
	 	      var seconde_hiden = 0
	 	     if(formObject.bsa_op_cd.value==""){
	 	    	first_hiden = 1;
	 	    	seconde_hiden = 1;
	 	     }
	
	 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	 	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	 	      InitHeaders(headers, info);
	
	 	      var cols = [ {Type:"Radio", Hidden:first_hiden, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"radio",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 	             {Type:"CheckBox",  Hidden:seconde_hiden, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	 	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"crr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 } ];
	 	           
	 	      InitColumns(cols);
	 	      SetEditable(1);
	 	      SetHeaderRowHeight(10);
//	 	      SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
	 	      SetSheetHeight(270);
	 	      
	 	     SetEditArrowBehavior(3); 
	 	     
 	      }
		break;
 	}
 }
 // handling the process realated with sheet
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg(false);
 	switch(sAction) {
 		case IBSEARCH:      //Retrieve
 			if (!validateCond(sheetObj,formObj,sAction)) {
 				return false;
 			}
 			formObj.f_cmd.value=SEARCHLIST;
 			var queryString = bsaFormString(formObj) + "&" + getParam('ESM_BSA_0120');
  			sheetObj.DoSearch("ESM_BSA_0120GS.do", queryString);
 			break;
 		case IBSAVE:        //save
 			if (!validateForm(sheetObj,formObj,sAction)) {
 				return false;
 			}
 			formObj.f_cmd.value=MULTI;
 			sheetObj.DoSave("ESM_BSA_0120GS.do", bsaFormString(formObj,getParam('ESM_BSA_0120','S')), -1, true);		//SJH.20150210.ADD			
 			break;
 		case IBDOWNEXCEL:   //excel download
 			//sheetObj.SpeedDown2Excel(-1);
            selectDownExcelMethod(sheetObj);
 			break;
 	}
 }
 function callBackExcelMethod(excelType) {
		var sheetObj = sheet1;
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
			return;
		}
		switch (excelType) {
		case "AY":
            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
            break;
		case "AN":
            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
            break;
		case "DY":
            sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
            break;
		case "DN":
            sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
            break;
		 }
	}
 /**
* handling process for carrier code input validation
 * Checking MDM Carrier code
 */
function sheet1_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	if (sheetObj.ColSaveName(Col) == "crr_cd") {
		var param="crr_cd="+Value
				  +"&f_cmd="+MULTI02;
 		var sXml=sheetObj.GetSearchData("ESM_BSA_0120GS.do", param);
		var crrNm=ComXmlString(sXml, "crr_nm");
		if(crrNm==""){
			ComShowMessage(ComGetMsg('BSA10043',Value));
			sheetObj.SetCellValue(Row, 'crr_cd',"",0);
			sheetObj.SetCellValue(Row, 'crr_nm',"",0);
		}else{
			sheetObj.SetCellValue(Row, 'crr_nm',ComXmlString(sXml, "crr_nm"),0);
		}
	}
}
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction) {
 	with(formObj){
 	}
 	return true;
 }
 /**
  * handling process for retrieve validation
  */
 function validateCond(sheetObj,formObj,sAction) {
 	with(formObj){
 	}
 	return true;
 }
