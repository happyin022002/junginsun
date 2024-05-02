/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_FMS_0069.js
*@FileTitle  : Item Detail Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
   var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
      	switch(srcName) {
        	case "btn_retrieve":
        		onRetrieve();
            break;
            
			case "btn_new":
             	if(!CoFmsInitConfirm(sheetObject)) return;
				ComResetAll();
            break;
            
			case "btn_save":
				if (!checkDupAcctItem(sheetObject)) {
					doActionIBSheet(sheetObject,formObject,IBSAVE);
            	}
            break;
            
			case "btn_savetofile":
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}				
            break;
            
			case "btn_print":
            break;
            
			case "btn_add":
				if(!validateForm(sheetObject,formObject)) return;
				var row=sheetObject.DataInsert(-1);
				sheetObject.SelectCell(row, "acct_itm_nm");
            break;
            
			case "btn_ins":
				if(!validateForm(sheetObject,formObject)) return;
				var row=sheetObject.DataInsert();
				sheetObject.SelectCell(row, "acct_itm_nm");
				break;
				
			case "btn_del":
				if(checkBoxCheckYn(sheetObject, "DelChk")) { 
					ComRowHideDelete(sheetObject, "DelChk"); 
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
* Checking duplication when clicking Save button
*/
function checkDupAcctItem(sheetObject) {
	
	
	var dupRow = sheetObject.ColValueDup("acct_itm_nm");
	if(dupRow > -1){
		var tmpRow = sheetObject.GetCellValue(dupRow , "Seq");
		ComShowCodeMessage('FMS20008', "["+tmpRow+" Row]");
		sheetObject.SelectCell(dupRow, "acct_itm_nm");
		return true;
	}
	return false;
	
	/*
	var sRow=sheetObject.FindStatusRow("I|U");
	var arrow=sRow.split(";");
	var len=arrow.length-1;
	var selRow = 2;
	for (var i=0; i<len; i++) {
		selRow += i;
		var findrow=sheetObject.FindText("acct_itm_nm", sheetObject.GetCellValue(arrow[i], "acct_itm_nm"), 0, -1, false);
		if (findrow > 0) {
			if (findrow == arrow[i]) {
				findrow=sheetObject.FindText("acct_itm_nm", sheetObject.GetCellValue(arrow[i], "acct_itm_nm"), findrow+1, -1, false);
			}	
			if (findrow > 0) {
				ComShowCodeMessage('FMS01340', arrow[i], findrow);
				sheetObject.SelectCell(arrow[i], "acct_itm_nm");
				return true;
			}
		}		
	}	
	return false;*/
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
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
	DATE_SEPARATOR="/";
	
	onRetrieve();
}

function onRetrieve(){

 	if(!CoFmsInitConfirm(sheetObjects[0])) return;
 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

 /**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
	             
        		var HeadTitle="|Sel|Seq||Item Name|Debit|Debit|Credit|Credit|Credit|Credit|Update\nDate|Update\nUser";
	             
        		var HeadTitle2="|Sel|Seq||Item Name|";
        		HeadTitle2 += "Account|Account Name|AR Slip|AP Slip|Account Name|Account Name|Update\nDate|Update\nUser";
        		
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} , { Text:HeadTitle2, Align:"Center"} ];
	            InitHeaders(headers, info);

	            var cols = [ 
	                 {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
	                 {Type:"Seq",        Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                 {Type:"Text",       Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"acct_itm_seq" },
	                 {Type:"Text",       Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100},
	                 {Type:"PopupEdit",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",       KeyField:1,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",       Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"acct_nm",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100},
	                 {Type:"PopupEdit",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ar_cr_acct_cd", KeyField:0,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"PopupEdit",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ap_cr_acct_cd", KeyField:0,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",       Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"ar_cr_acct_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100},
	                 {Type:"Text",       Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"ap_cr_acct_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100},
	                 {Type:"Text",       Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt", 		KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50},
	                 {Type:"Text",       Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50}];
	              
	            InitColumns(cols);
	            SetEditable(1);
	            SetShowButtonImage(2);
	             
	            SetSelectionMode(smSelectionRow);
	            SetDataLinkMouse("acct_cd",1);
	            SetDataLinkMouse("ap_cr_acct_cd",1);
	            SetDataLinkMouse("ar_cr_acct_cd",1);

	            resizeSheet();
            }
            break;
     }
 }
/**
 * Handling IBSheet's process(Retrieve, Save) <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form}    formObj Mandatory html form object
 * @param {int}     sAction mandatory,Constant Variable
 * @param {String}  gubun     	gubun value
 **/ 
function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
     	case IBSEARCH:      
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.DoSearch("ESM_FMS_0069GS.do", FormQueryString(formObj) );
            break;
       	case IBSAVE:        
 			if(!validateForm(sheetObj,formObj,sAction))return;
 			formObj.f_cmd.value=MULTI;
 			sheetObj.DoSave("ESM_FMS_0069GS.do", FormQueryString(formObj));
 			ComOpenWait(false);
 			
            break;
           
		case IBROWSEARCH: 
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_FMS_0069GS.do" , FormQueryString(formObj)+"&acct_cd="+sheetObj.GetCellValue(Row,Col));
			
			var acctNm = ComGetEtcData(sXml, "acctNm");			
			setAccountName(sheetObj, acctNm, Row, Col);
			
    		break;
    }
}
/**
 * Checking Account Code <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String}  comboText   Name of Type
 * @param {String}  comboCode   Code Value of Type
 * @param {int}  	col   		column index
 **/
function setAccountName(sheetObj, acctNm, Row, Col) {
	var tmpColName = sheetObj.ColSaveName(Col);
	
	var tmpTargetColNm = "";
	if(tmpColName == "acct_cd"){
		tmpTargetColNm = "acct_nm";
	}else if(tmpColName == "ap_cr_acct_cd"){
		tmpTargetColNm = "ap_cr_acct_nm";
	}else if(tmpColName == "ar_cr_acct_cd"){
		tmpTargetColNm = "ar_cr_acct_nm";
	}
	
	if(acctNm != undefined && !ComIsNull(acctNm)){
		if(!ComIsNull(tmpTargetColNm)){
			sheetObj.SetCellValue(Row, tmpTargetColNm, acctNm,0);
		}else{
			sheetObj.SetCellValue(Row, Col, "",0);
			if(!ComIsNull(tmpTargetColNm))
				sheetObj.SetCellValue(Row, tmpTargetColNm, "",0);
			ComShowCodeMessage('FMS01336');
			sheetObj.SelectCell(Row, Col);
		}		
	}else{
		sheetObj.SetCellValue(Row, tmpColName, "",0);
		if(!ComIsNull(tmpTargetColNm))
			sheetObj.SetCellValue(Row, tmpTargetColNm, "",0);
		ComShowCodeMessage('FMS01336');
		sheetObj.SelectCell(Row, Col);
	}		
}
/**
  * Handling process for input validation
  */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){}
	return true;
}
/**
  * In case of Clicking Popup in IBSheet Object
  */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}	
 /**
  * In case of Clicking Popup in IBSheet Object
  */
function sheet1_OnPopupClick(sheetObj, Row,Col){
	var colName = sheetObj.ColSaveName(Col);
	switch(colName) {
		case "acct_cd": 
	 	case "ap_cr_acct_cd": 
	 	case "ar_cr_acct_cd":
	 		ComOpenPopup("ESM_FMS_0080.do", 520, 440, "setAccountCode", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0080");
	 		break;
	}
}
/**
  * In case there is a change in input value in IBSheet Object
  */
function sheet1_OnChange(sheetObj,Row, Col, Value){
	var colName = sheetObj.ColSaveName(Col);

	if(ComIsNull(Value)){
		switch(colName) {
		 	case "acct_cd": 
		 		sheetObj.SetCellValue(Row, "acct_nm", "",0);
		 		break;
		 	case "ap_cr_acct_cd":
		 		sheetObj.SetCellValue(Row, "ap_cr_acct_nm", "",0);
		 		break;
		 	case "ar_cr_acct_cd": 
		 		sheetObj.SetCellValue(Row, "ar_cr_acct_nm", "",0);
		 		break;
		}
		return;
	}
	switch(colName) {
	 	case "acct_cd": 
	 	case "ap_cr_acct_cd": 
	 	case "ar_cr_acct_cd": 
	 		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
	 		break;
	}
}
/**
 * Inserting Account Code <br>
 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
 */
function setAccountCode(aryPopupData, Row, Col, sheetIdx){
	var tmpAcctCd = aryPopupData[0][3];//acct_cd
	var tmpAcctNm = aryPopupData[0][4];//acct_nm
	
	sheetObjects[0].SetCellValue(Row,Col,tmpAcctCd,0);
	setAccountName(sheetObjects[0], tmpAcctNm, Row, Col);
	
}

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    var Row=sheetObj.MouseRow();
    var Col=sheetObj.MouseCol();
    var prefix="";
    var sText = "";
    var selColName = sheetObj.CellSaveName (Row, Col);
    sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
    	sheetObj.SetToolTipText(Row,Col,sText);
    }        
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}		