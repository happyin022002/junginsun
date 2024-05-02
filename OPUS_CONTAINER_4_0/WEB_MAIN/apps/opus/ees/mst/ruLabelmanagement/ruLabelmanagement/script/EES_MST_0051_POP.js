/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0050
*@FileTitle  : RU Label Maintenance
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class EES_MST_0050 : business script for EES_MST_0050
     */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var strRulabelTypeSearchYn = "";
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	 /***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_select":
				var hRow=sheetObjects[0].HeaderRows();
				var checkYN ="N";
				if(strRulabelTypeSearchYn == "") {
					for (var row=hRow; row <= sheetObjects[0].RowCount(); row++) {
						if(sheetObjects[0].GetCellValue(row,"ibcheck") == 1){
							checkYN = "Y";
							break;
						}					
					}    
					
					if(checkYN == "Y") {
						comPopupOK();
					}else{
						ComShowCodeMessage("MST00010");
						return false;
					}
				}else{
					comPopOK(sheetObject,formObject);
				}
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_search":
				sheetObject.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	strRulabelTypeSearchYn = document.form.ru_label_type_search_yn.value;
	
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var formObject=document.form;
	var strRulabelTypeModYn = formObject.ru_label_type_mod_yn.value;
	if(strRulabelTypeModYn == "Y") {
		formObject.ru_label_type.value = formObject.ru_label_default.value;
	}
	
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();	
}
/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
	axon_event.addListener("change", "obj_ruLableTp_change", "ru_label_type");
}


/**
 * handlin event changing on object
 */
function obj_ruLableTp_change() {
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}


/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var HeadTitle = "";
	var strHeaderCheck = 0;
	var strType = "Radio";
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
			if(strRulabelTypeSearchYn == "") {
				HeadTitle="Sel||RU Label Value|Description|Remark|Update by|Update Date|Seq" ;
			}else{
				HeadTitle="||RU Label Value|Description|Remark|Update by|Update Date|Seq" ;
				strHeaderCheck = 1;
				 strType = "DummyCheck";
			}
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:strHeaderCheck, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:strType, Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },             
                {Type:"Text",       Hidden:1,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                {Type:"Text",       Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                {Type:"Text",       Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
                {Type:"Text",       Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"usr_def_rmk",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
                {Type:"Text",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rstr_usg_cd_seq" } ];
            InitColumns(cols);
            resizeSheet();
            SetEditable(1);
		   }
			break;
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
}

/**
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Value){
	/*var formObject=document.form;
	var strRulabelTypeModYn = formObject.ru_label_type_mod_yn.value;
	var strRuLabelType = "";
	if(sheetObj.ColSaveName(Col) == "ibcheck"){
		if(strRulabelTypeModYn == "Y") {
			if(formObject.ru_label_type.value != "ALL") {
				strRuLabelType = formObject.ru_label_type.value;
				sheet1.SetCellValue(Row,"rstr_usg_tp_cd",strRuLabelType);
			}
		}
	}*/
}


function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction))	
			ComOpenWait(true);					
			formObj.f_cmd.value=SEARCH;
			var xml="";					
 			xml=sheetObj.GetSearchData("EES_MST_0050GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(xml,{Sync:1} );			
			break;
	}
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	}
	return true;
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}


function comPopOK(sheetObj,formObject) {
	var formObject=document.form;
	var checkRows;
	var rArray=null; //list containing row data
	var cArray=null; // list containing col data
	
	var hRow=sheetObjects[0].HeaderRows();
	var checkYN ="N";
	var checkRows = 0;
	for (var row=hRow; row <= sheetObj.RowCount(); row++) {
		if(sheetObjects[0].GetCellValue(row,"ibcheck") == 1){
			checkYN = "Y";
			checkRows += 1;
		}					
	}    
	
	if(checkYN == "N") {
		ComShowCodeMessage("MST00010"); 
		return;
	} else {
		var idx=0;
		var chkval="";
		rArray=new Array(checkRows);
		for(var i=hRow; i <= sheetObj.RowCount(); i++) {
			if(sheetObj.GetCellValue(i, "ibcheck") == 1) {
				
				chkval=sheetObj.GetCellValue(i, 'rstr_usg_lbl_nm');
				
				rArray[idx++]=chkval;
				
			}
		}
	}
	
	parent.setPopupChkParam(rArray);  //호출하는 부모js에 getLse_Multi 붙여넣으면됩니다.
	ComClosePopup(); 
}   
