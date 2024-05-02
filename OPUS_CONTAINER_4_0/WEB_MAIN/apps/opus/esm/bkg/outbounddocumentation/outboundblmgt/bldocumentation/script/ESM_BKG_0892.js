/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0892.js
*@FileTitle  :  Container No Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================
*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     var sheetObject1=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
			case "btn_Select":
				//var sRow = sheetObject1.FindCheckedRow("sel");
				//alert("sRow -> "+sRow);
				/*
				if(sRow==''){
					alert("no selected row.");
					break;
				}else{
					//returnArr
					var returnArr=new Array();
					//arrRow
					var arrRow=sRow.split("|");
					for(ir=0;ir<arrRow.length;ir++){
						if(arrRow[ir] == '') continue;
						//rowArr
						var rowArr=new Array();
						rowArr.push(sheetObject1.GetCellValue(arrRow[ir], "cntr_no"));
						rowArr.push(sheetObject1.GetCellValue(arrRow[ir], "cntr_tpsz_cd"));
						rowArr.push(sheetObject1.GetCellValue(arrRow[ir], "mf_cfm_flg"));
						//returnArr
						returnArr.push(rowArr);
					}				
					//alert(returnArr);
					if(!opener) opener=window.dialogArguments; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(returnArr);
					}
				}
				*/
				var arrRow=ComFindText(sheetObject1, "sel", 1);
				if(arrRow.length==0){
					alert(ComGetMsg('BKG00188'));
					break;
				}else if(arrRow.length==1){
					if(!opener) opener = parent; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(sheetObject1.GetCellValue(arrRow[0], "cntr_no"), formObject.bkg_vvd.value);
					}
				}else{
					alert(ComGetMsg('BKG00193'));
					break;
				}
			//break;
			case "btn_Close":
  ComClosePopup(); 
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
 * @param sheet_obj
 * @return
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
		//init sheet
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	// init data
	//if(document.form.bkg_vvd.value != ''){
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	//}
	//add listener
	//axon_event.addListenerForm('blur', 'form1_blur', document.form);
	//axon_event.addListenerForm('focus', 'form1_focus', document.form);
    axon_event.addListenerFormat('keypress', 'form1_keypress', document.form);
	axon_event.addListenerForm('change', 'form1_change', document.form);
}
/**
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
		      var HeadTitle="|Seq.|Container No.|TP/SZ|C/M Confirm";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mf_cfm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(220);
			}
			break;
		}
}
/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
      	case IBSEARCH:      //Retrieve
          	if(validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
           		sheetObj.DoSearch("ESM_BKG_0892GS.do", FormQueryString(formObj) );
				for(ir=1;ir<=sheetObj.RowCount();ir++){
					if(sheetObj.GetCellValue(ir, "mf_cfm_flg") == 'Y'){
						//sheetObj.CellEditable(ir, "cntr_no")  = false;
						//sheetObj.CellEditable(ir, "cntr_tpsz_cd")  = false;
						//sheetObj.RowBackColor(ir) = 0;
						sheetObj.SetRowEditable(ir,0);
					}else{
						//sheetObj.CellEditable(ir, "cntr_no")  = true;
						//sheetObj.CellEditable(ir, "cntr_tpsz_cd")  = true;
						//sheetObj.RowBackColor(ir) = -1;
						sheetObj.SetRowEditable(ir,1);
					}
				}
          	}
        break;
    }
}
/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
      	case IBSEARCH:      // Retrieve
			if(formObj.bkg_vvd.value == '') {
				alert(ComGetMsg('BKG00115'));
				formObj.bkg_vvd.focus();
				return false;
			}
			if(formObj.bkg_vvd.value.length != '9') {
				alert(ComGetMsg('BKG00780'));
				formObj.bkg_vvd.select();
				return false;
			}
			if(formObj.bkg_ofc_cd.value == '') {
				alert(ComGetMsg('BKG00823'));
				formObj.bkg_ofc_cd.focus();
				return false;
			}
			if(formObj.bkg_pol.value == '') {
				alert(ComGetMsg('BKG00823'));
				formObj.bkg_pol.focus();
				return false;
			}
			//if(formObj.bkg_pod.value == '') {
			//	alert(ComGetMsg('BKG00823'));
			//	formObj.bkg_pod.focus();
			//	return false;
			//}
        break;
      	case IBCOPYROW:      // Select
			var selCount=0;
			for(ir=1;ir<sheetObj.RowCount()+1;ir++){
				if(sheetObj.GetCellValue(ir, "sel") == 1){
					selCount++;
				}
			}
			if(selCount == 0) {
				alert(ComGetMsg('BKG00188'));
				return false;
			}
			if(selCount > 1) {
				alert(ComGetMsg('BKG00193'));
				return false;
			}
        break;
    } // end switch
    return true;
}
/**
 * obj key press event handling
 */
function form1_keypress(){
	if (event.srcElement.type == "text" && event.keyCode == 13 ) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//ComKeyEnter("search");
	}
	switch(event.srcElement.dataformat){
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "ym":
		case "yw":
		case "jumin":
		case "saupja":	
			//only Number + "-"
			ComKeyOnlyNumber(event.srcElement, "-"); 
		break;
		case "hms":
		case "hm":		
			//only Number + ":"
			ComKeyOnlyNumber(event.srcElement, ":"); 
		break;
		case "int":		
			//only Number
			ComKeyOnlyNumber(event.srcElement); 
		break;
		case "float":	
			//only Number + "."	            
			ComKeyOnlyNumber(event.srcElement, "."); 
		break;	    
		case "engup":
			//only upper case of Alphabet
			ComKeyOnlyAlphabet("upper");
		break;
		case "engupnum":
			//only Number, upper case of Alphabet
			ComKeyOnlyAlphabet("uppernum");
		break;
		case "engupnumspc":
			//only Number, lower case of Alphabet, space
			//ComKeyOnlyAlphabet("uppernum", "32|45|95");
			var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			if(keyValue >= 97 && keyValue <= 122){                  //lower case
            	event.keyCode=keyValue + 65 - 97;
			}
			//event.returnValue = true;
		break;
	}	
}
/**
 * form change handling 
 */
function form1_change(){
	/* upper case */
	//if(event.srcElement.type =="text") {
	//	event.srcElement.value = event.srcElement.value.toUpperCase();
	//}
	var srcName=ComGetEvent("name");
	switch(srcName){
		case "bkg_no":
			//var comboObj = event.srcElement;
			//document.form.bkg_no_split.value = comboObj.options[comboObj.selectedIndex].value;
		break;
	}
}
/**
 * sheet1 change handling 
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function sheet1_OnChange(sheetObj, row, col) {
	//sheetObj.cellValue2(row, col) = sheetObj.cellValue(row, col).toUpperCase();
}
