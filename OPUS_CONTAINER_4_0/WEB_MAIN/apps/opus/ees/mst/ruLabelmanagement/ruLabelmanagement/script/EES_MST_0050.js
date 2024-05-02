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
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_rowadd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				
				//doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case 'btn_delete':
				if(sheetObject.FindCheckedRow("ibcheck")==""){
					ComShowCodeMessage("MST00010");
				} else { 
					doActionIBSheet(sheetObject,formObject,IBDELETE);
				}
				break;			
			case "btn_downexcel" :
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}
				break;	
			case "btn_new":
				sheetObject.RemoveAll();
				form.reset();
//				doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
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
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
   ComKeyOnlyAlphabet('uppernum');
}

/**
 * handlin event changing on object
 */
function obj_ruLableTp_change() {
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
* Booking number manual control <br>
 **/
function manual_click() {
    //Activating Bkg_no to edit mode when manual check box is checked
   form.boo_bkg_no.readOnly=!form.manual.checked;
}
/**
 * Processing when booking number of tap BKG Creation is changed
 **/
function bkgno_keyup() {
    //Handling bl_no comparing with the saved data
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value="";
    else
	form.boo_bl_no.value=form.hdn_boo_bl_no.value;
	*/
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){
   return ComChkObjValid(event.srcElement);
}
/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(event.srcElement);
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
    obj=event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    var vKeyCode=event.keyCode;
    switch(obj.dataformat) {
        case "engup":
            if(obj.name=="ru_label_value") {
            	ComKeyOnlyAlphabet('uppernum');
            }
            break;
    }
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
            var HeadTitle="STS|Sel|RU Label Type|RU Label Value|DP|RU Label Value Description|Remark|Update by|Update Date|Seq" ;
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                {Type:"DummyCheck", Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                {Type:"Combo",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Text",       Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
                {Type:"Int",        Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rstr_usg_dp_seq",    KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                {Type:"Text",       Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
                {Type:"Text",       Hidden:0,  Width:600,  Align:"Left",    ColMerge:0,   SaveName:"usr_def_rmk",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
                {Type:"Text",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rstr_usg_cd_seq" } ];
            InitColumns(cols);
            //SetSheetHeight(400);
            resizeSheet();
            SetEditable(1);
            SetColProperty('rstr_usg_tp_cd', {ComboText:"|"+ru_label_typeText, ComboCode:"|"+ru_label_typeCode} );
            //SetGetColHidden('ibflag',1);
            //SetGetColHidden('rstr_usg_cd_seq',1);
            SetColProperty(0 ,"rstr_usg_lbl_nm" , {AcceptKeys:"E|[-/& 0123456789]"});
          //conversion of function[check again]CLT 				InitDataValid(0, "rstr_usg_lbl_nm", vtEngUpOther," -/& 0123456789");
		   }
			break;
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//doActionIBSheet(sheetObject,formObject,IBSEARCH);
	// After Retrieving, RU Label Type is not modifued.
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
			ComOpenWait(false);
			break;
		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			
			var hRow=sheetObj.HeaderRows();
			allRstrUsgTpCd="";
			allRstrUsgLblNm="";
			allRstrUsgflg="";	
			for (var row=hRow; row <= sheetObj.RowCount(); row++) {
				var status=sheetObj.GetRowStatus(row);
				allRstrUsgTpCd=allRstrUsgTpCd + sheetObj.GetCellValue(row, 'rstr_usg_tp_cd') +",";
	    		allRstrUsgLblNm=allRstrUsgLblNm + sheetObj.GetCellValue(row, 'rstr_usg_lbl_nm') +",";
	    		allRstrUsgflg=allRstrUsgflg + sheetObj.GetCellValue(row, 'ibflag') +",";
				
			}    
			
			formObj.all_ru_label_type.value=allRstrUsgTpCd;
			formObj.all_ru_label_value.value=allRstrUsgLblNm;
			formObj.all_ibflag.value=allRstrUsgflg;
 			var sXml=sheetObj.GetSearchData("EES_MST_0050GS.do", FormQueryString(formObj));
			var strRuLabelType=ComGetEtcData(sXml, "strRuLabelType");
			
			if(strRuLabelType == "") {
				// 하위값이 없다면 자동 조회
				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.DoSave("EES_MST_0050GS.do", FormQueryString(formObj));
			}else{
				// mst container에 데이타 있다면 
				if(ComShowCodeConfirm("MST02034", strRuLabelType)) { 
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("EES_MST_0050GS.do", FormQueryString(formObj));
				}else{
					// mst container에 데이타 없다면 
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
			}
			ComOpenWait(false);
			break;
		case IBINSERT:      // Insert
			sheetObj.DataInsert(-1);
			var row=sheetObj.GetSelectRow();
			//sheetObj.CellValue2(row, 'wo_instr_ofc_cd')= formObj.f_usr_ofc_cd.value;
			sheetObj.SetCellValue(row, 'rstr_usg_dp_seq'     ,"1",0);
			sheetObj.SetCellValue(row, 'upd_usr_id'     ,formObj.f_cre_usr_id.value,0);
			sheetObj.SetCellValue(row, 'ibcheck'        ,1,0);
			break;
		case IBDELETE:
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			} 

			var hRow=sheetObj.HeaderRows();
			sheetObj.SetRedrawSum(0);
			allRstrUsgTpCd="";
			allRstrUsgLblNm="";
			for (var row=hRow; row <= sheetObj.RowCount(); row++) {
				var status=sheetObj.GetRowStatus(row);
				if (sheetObj.GetCellValue(row, 'ibcheck') == 1) {
					if (status == "I") {
			    		sheetObj.RowDelete(row,false);
			    	} else {
			    		allRstrUsgTpCd=allRstrUsgTpCd + sheetObj.GetCellValue(row, 'rstr_usg_tp_cd') +",";
			    		allRstrUsgLblNm=allRstrUsgLblNm + sheetObj.GetCellValue(row, 'rstr_usg_lbl_nm') +",";
			    		//sheetObj.SetRowHidden(row,1);
			    		//sheetObj.SetRowStatus(row,"D");
			    	}    	
					if (status == "I") {
		    			row--;
		        	} 
				}
			}    
			ComRowHideDelete(sheetObj, "ibcheck"); 
			
			formObj.all_ru_label_type.value=allRstrUsgTpCd;
			formObj.all_ru_label_value.value=allRstrUsgLblNm;
			sheetObj.SetRedrawSum(1);
			//sheetObj.DoSave("EES_MST_0050GS.do",FormQueryString(formObj),'ibcheck',false);
			/*var checkArray=checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
			if(sheetObj.GetRowStatus(checkArray[k]) == 'I') {
					sheetObj.RowDelete(checkArray[k], false);
				}
			}
			checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			if(checkList== '') return false;
			if(checkArray.length > 0) {
				for(var d=0; d<checkArray.length-1; d++){
					var delIdx=checkArray[d];
					sheetObj.SetCellValue(delIdx, 'ibflag',"D");
				}
			}
			//var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
			//formObj.f_cmd.value = MULTI;
			//sheetObj.DoSave("EES_MST_0050GS.do",FormQueryString(formObj),'ibcheck',false);
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}*/
			break;
		case IBDOWNEXCEL:        //Excel Download
 			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
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

function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text){
	var form=document.form;
    var colName=sheetObj.ColSaveName(Col);
    var inPutAgmtNo="";
	switch(colName) {
		case "rstr_usg_tp_cd": 
			var agmtNo=sheetObj.GetCellValue(Row , 2) + sheetObj.GetCellValue(Row , 3);
			for(var i=1; i <= sheetObj.RowCount(); i++){
				if( i != Row){
					inPutAgmtNo=sheetObj.GetCellValue( i , 2) + sheetObj.GetCellValue(i , 3);
					if(agmtNo == inPutAgmtNo){
						ComShowCodeMessage("MST02031");
						sheetObj.RowDelete(Row, false);
						return;
					}
				}
			}
			break;
	}
}	  
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj=document.form;
	var agmtNo=sheetObj.GetCellValue(row , 2) + sheetObj.GetCellValue(row , 3);
	for(var i=1; i <= sheetObj.RowCount(); i++){
		if( i != row){
			inPutAgmtNo=sheetObj.GetCellValue( i , 2) + sheetObj.GetCellValue(i , 3);
			if(agmtNo == inPutAgmtNo){
				ComShowCodeMessage("MST02031");
				sheetObj.RowDelete(row, false);
				return;
			}
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	//ComShowCodeMessage("COM130102", 'RU Label Maintenace');
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
 }

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
