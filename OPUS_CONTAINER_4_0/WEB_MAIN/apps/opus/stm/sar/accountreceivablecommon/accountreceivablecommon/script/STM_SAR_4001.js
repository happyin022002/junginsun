/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_4001.js
*@FileTitle  : Account Matrix
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAR_4001 : business script for STM_SAR_4001
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var now_select_sheet1=0 ;
var max_lu_tp_cd=0 ;

//Checked Account Type code From Edit or Popup 
var use_pop_chk = 0;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
	        case "btn_new":
	        	formObj.f_dup_chk.value="N";
	        	formObj.f_dup_acct_ctnt1.value="";
	        	formObj.f_dup_acct_ctnt2.value="";
	        	formObj.f_dup_acct_ctnt3.value="";
	        	formObj.f_dup_acct_ctnt4.value="";
	        	formObj.f_dup_acct_tp_cd.value="";
				f_acct_ctnt1.SetSelectIndex(-1);
				f_acct_ctnt2.SetSelectIndex(-1);
				f_acct_ctnt3.SetSelectIndex(-1);
				f_acct_ctnt4.SetSelectIndex(-1);
				f_rev_acct_div_cd.SetSelectIndex(-1);
				formObj.f_acct_tp_cd.value="";
				f_delt_flg.SetSelectIndex(-1);
				formObj.f_ar_acct_cd.value="";
				sheetObject1.RemoveAll();
				ComBtnDisable("btn_save"); 
			  break;
		    case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				/*
				if(sheetObject1.RowCount() > 0){
					ComBtnEnable("btn_save"); 
				} else {
					ComBtnDisable("btn_save");
				}*/
				break;
			case "btn_add":
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
				if(sheetObject1.RowCount() > 0){
					ComBtnEnable("btn_save"); 
				} else {
					ComBtnDisable("btn_save");
				}
				break;	
			case "btn_del":
				if(sheetObject1.RowCount() == 0) break;
				if(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "search_flg") == 'Y'){
					ComShowCodeMessage('SAR00060'); 
					break;
				}	
				
				sheetObject1.RowDelete(sheetObject1.GetSelectRow(), false);
				if(sheetObject1.RowCount() > 0){ 
					ComBtnEnable("btn_save"); 
				} else {
					ComBtnDisable("btn_save");
				} 	
				break;
		 	case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;	
		 	case "btns_search_acct_type":
				ComOpenPopup("STM_SAR_0141.do?acct_ctnt1="+f_acct_ctnt1.GetSelectText()+"&acct_ctnt2="+f_acct_ctnt2.GetSelectText()+"&acct_ctnt3="+f_acct_ctnt3.GetSelectText()
						+"&acct_ctnt4="+f_acct_ctnt4.GetSelectText()+"&acct_tp_cd="+formObj.f_acct_tp_cd.value, 900, 410, "setAcctType", "0,0", true, false);
				break;
		 	case "btns_search_ar_acct":
				ComOpenPopup("STM_SCO_0054.do", 900, 410, "setArAcct", "0,0", true, false);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
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
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    ComBtnDisable("btn_save"); 
  //  document.form.lu_tp_cd.focus();
}
/**
 * Removing IBSheet Row
 **/
function rowRemove(sheetObj){
	ComRowHideDelete(sheetObj, "DelChk");
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
   // axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name");
}
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
function obj_keypress(){
	var src=ComGetEvent("name");
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name");
}

/**
 * Handling business javascript OnChange event
 */
function f_acct_ctnt1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj = document.form;
	
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].RemoveAll();
	formObj.f_acct_tp_cd.value = "";
	formObj.f_ar_acct_cd.value = "";
	
	var comboAcctCtnt2 = SarGetAcctCtnt2ComboItems(sheetObjects[0], newCode);
	if(comboAcctCtnt2 != ''){
		SarAddComboItem(f_acct_ctnt2, comboAcctCtnt2, "2", "ALL", "ALL");
	}
}

/**
 * Handling business javascript OnChange event
 */
function f_acct_ctnt2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj = document.form;
	
	comboObjects[2].RemoveAll();
	comboObjects[3].RemoveAll();
	formObj.f_acct_tp_cd.value = "";
	formObj.f_ar_acct_cd.value = "";

	var comboAcctCtnt3 = SarGetAcctCtnt3ComboItems(sheetObjects[0], f_acct_ctnt1.GetSelectText());
	if(comboAcctCtnt3 != ''){
		SarAddComboItem(f_acct_ctnt3, comboAcctCtnt3, "2", "ALL", "ALL");
	}
}

/**
 * Handling business javascript OnChange event
 */
function f_acct_ctnt3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj = document.form;
	
	comboObjects[3].RemoveAll();
	formObj.f_acct_tp_cd.value = "";
	formObj.f_ar_acct_cd.value = "";

	var comboAcctCtnt4 = SarGetAcctCtnt4ComboItems(sheetObjects[0], f_acct_ctnt1.GetSelectText(), '&f_acct_ctnt2='+f_acct_ctnt2.GetSelectText());
	if(comboAcctCtnt4 != ''){
		SarAddComboItem(f_acct_ctnt4, comboAcctCtnt4, "2", "ALL", "ALL");
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetObj.id) {
	case "sheet1": //t1sheet1 init
	    with(sheetObj){
		var HeadTitle1="|Account\nContent1|Account\nContent2|Account\nContent3|Account\nContent4|Account\nContent5|Account\nContent6|Account\nContent7|Account\nContent8|Account\nDivision|Account Type|Account Type\nName|AR Account|Clearing\nAccount|Bank CHG\nAccount|Ex.Diff\nIncome|Ex.Diff\nLoss|AP Account|Amount Sign|Delete Flag|Seq|Start Date|End Date|";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 5, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:5 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                   {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt3",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt4",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt5",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt6",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt7",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"acct_ctnt8",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rev_acct_div_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"acct_tp_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_acct_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"clr_acct_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bank_chg_acct_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"legr_xch_diff_incm_acct_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"legr_xch_diff_lss_acct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_acct_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amt_sgn_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_mtx_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_st_dt",        			 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_end_dt",        		 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
				             ];
		       
		      InitColumns(cols);
		      
		      SetEditable(1);
//		      SetSheetHeight(360);
		      resizeSheet();
            }
   break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0], 130);
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	if (!validateForm(sheetObj, formObj, sAction))		
		return;
	switch (sAction) {	
	    case IBSEARCH_ASYNC01: 		
	    	// Form Objects
		    //ACCT CTNT1			
			var comboAcctCtnt1 = SarGetComboItems(sheetObj, "ACCT CTNT1");
			SarAddComboItem(f_acct_ctnt1, comboAcctCtnt1, "2", "ALL", "ALL");
            			
		    //ACCT DIV		
			var comboAcctDiv = SarGetComboItems(sheetObj, "ACCT DIV");
			SarAddComboItem(f_rev_acct_div_cd, comboAcctDiv, "2", "ALL", "ALL");
			
		    //DELT FLG		
			var comboDeltFlg = SarGetComboItems(sheetObj, "YES NO");
			SarAddComboItem(f_delt_flg, comboDeltFlg, "1", "ALL", "ALL");
			
			// Sheet Objects
			//ACCT CTNT1	
			SarInitDataCombo(sheetObj, "acct_ctnt1", "2", " ", " ", "ACCT CTNT1");
						
			//ACCT DIV
			SarInitDataCombo(sheetObj, "rev_acct_div_cd", "2", " ", " ", "ACCT DIV");
			
			//ACCT SIGN CODE
			SarInitDataCombo(sheetObj, "amt_sgn_cd", "2", " ", " ", "ACCT SIGN CODE");
			
			//ACCT CTNT2	
			SarInitDataAcctCtnt2ComboAll(sheetObj, "acct_ctnt2", "2", " ", " ", "ACCT CTNT2");
			
			//ACCT CTNT3
			SarInitDataAcctCtnt3ComboAll(sheetObj, "acct_ctnt3", "2", " ", " ", "ACCT CTNT3");
			
			//ACCT CTNT4
			SarInitDataAcctCtnt4ComboAll(sheetObj, "acct_ctnt4", "2", " ", " ", "ACCT CTNT4");
			
			break;
		case IBSEARCH: //retrieve
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				formObj.f_cmd.value=SEARCH;		
	 			var sXml=sheetObj.GetSearchData("STM_SAR_4001GS.do", FormQueryString(formObj));
		    	sheetObj.LoadSearchData(sXml,{Sync:1} );
		    	ComOpenWait(false);
		    	
		    	if(sheetObj.RowCount() > 0){
					ComBtnEnable("btn_save"); 
				} else {
					ComBtnDisable("btn_save");
				}
		    	
		    } , 100);	
			break;	
		case IBINSERT: //Row Insert		
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}			
			var idx=sheetObj.DataInsert();
			break; 
		 case IBSAVE: //Save			 		
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
            var sParamSheet=sheetObjects[0].GetSaveString(true);
			if (!sheetObjects[0].IsDataModified()) {
			    return;
			} 
			formObj.f_cmd.value=MULTI01;	
 			var sParam=FormQueryString(formObj);
	 		if( sParamSheet != "" ){
				sParam += "&" + sParamSheet;
			}
	 		var sXml;
	 		var sav;
			ComOpenWait(true); 
			setTimeout( function () {
				sXml=sheetObj.GetSaveData("STM_SAR_4001GS.do", sParam);
				sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 	 	
	  			sheetObj.LoadSaveData(sXml);
				SarOpenWait(false,true);
		    } , 100);	
				
			setTimeout( function () { 
	 			if (sav == "S"){
	 				ComShowCodeMessage('SAR00004');
	 			} else {
	 				ComShowCodeMessage('SAR00032');
	 			}
			} , 110);	
 			break;		
	  }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			break;		
		case IBSAVE: //save
			for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
				// mandatory check
				if (sheetObj.GetCellValue(i, "acct_ctnt1") == ""){
					ComShowCodeMessage('SAR00031', 'Input ACCT CTNT1');
					sheetObj.SelectCell(i, "acct_ctnt1");
					return false;
				} else if (sheetObj.GetCellValue(i, "acct_tp_cd") == ""){
					ComShowCodeMessage('SAR00031', 'Input Acct Type Code');
					sheetObj.SelectCell(i, "acct_tp_cd");
					return false; 
				}				
				if(sheetObj.GetCellValue(i, "ibflag") == "I" || sheetObj.GetCellValue(i, "ibflag") == "U"){
					// Dup Check 
					formObj.f_dup_chk.value="Y";
					formObj.f_dup_acct_ctnt1.value=sheetObj.GetCellValue(i, "acct_ctnt1");
					formObj.f_dup_acct_ctnt2.value=sheetObj.GetCellValue(i, "acct_ctnt2");
					formObj.f_dup_acct_ctnt3.value=sheetObj.GetCellValue(i, "acct_ctnt3");
					formObj.f_dup_acct_ctnt4.value=sheetObj.GetCellValue(i, "acct_ctnt4");
					formObj.f_dup_acct_tp_cd.value=sheetObj.GetCellValue(i, "acct_tp_cd");
					formObj.f_cmd.value=SEARCH;
 					var sXml=sheetObj.GetSearchData("STM_SAR_4001GS.do?", FormQueryString(formObj));
					var sSetTotalRows = ComGetTotalRows(sXml);
					if (sheetObj.GetCellValue(i, "ibflag") == "I" && sSetTotalRows > 0) {
						ComShowCodeMessage('SAR00031', 'Check Duplicated Data! From ACCT CTNT1 to ACCT CTNT4 and Acct Type Code must be unique!');					
						return false;
					} else if (sheetObj.GetCellValue(i, "ibflag") == "U" && sSetTotalRows > 1) {
						ComShowCodeMessage('SAR00031', 'Check Duplicated Data! From ACCT CTNT1 to ACCT CTNT4 and Acct Type Code must be unique!');					
						return false;
					}            
					formObj.f_dup_chk.value="N";
				}				
			}
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
}
/**
 * Program Name Data List OpenWindow. <br>
 * @param {int}	Row	행번호
 * @param {int}	Col	컬럼번호
 **/
function sheet1_OnPopupClick(sheetObj,Row,Col){
    switch (sheetObj.ColSaveName(Col)) {
    case "ar_acct_cd"              :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "clr_acct_cd"                :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "bank_chg_acct_cd"           :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "legr_xch_diff_incm_acct_cd" :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "legr_xch_diff_lss_acct_cd"  :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "pay_acct_cd"                :
    	ComOpenPopup("STM_SCO_0054.do", 900, 410, "setAccount", "0,0", true, false, Row, Col, 0);
   		break;
    case "acct_tp_cd"       :
    	// Checking Account Type Code From Popup
    	use_pop_chk = 1;
    	ComOpenPopup("STM_SAR_0141.do?acct_ctnt1="+sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "acct_ctnt1")+"&acct_ctnt2="+sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "acct_ctnt2")
    			+"&acct_ctnt3="+sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "acct_ctnt3")+"&acct_ctnt4="+sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "acct_ctnt4")
    			+"&acct_tp_cd="+sheetObj.GetCellValue(Row, Col), 900, 410, "setSheetAcctType", "0,0", true, false, Row, Col, 0);
   		break;
    case "acct_st_dt"                :
    	var cal=new ComCalendarGrid();
		//cal.setEndFunction("setGetRowBackColorChange");
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd'); 
   		break;
    case "acct_end_dt"                :
    	var cal=new ComCalendarGrid();
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
   		break;	
   		
    }
}
function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj=document.form;
	// when acct type is deleted
	if (Col == "10") {
		sheetObj.SetCellValue(Row, Col,sheetObj.GetCellValue(Row, Col).toUpperCase(), 0);
		if (sheetObj.GetCellValue(Row, Col) == ""){
			sheetObj.SetCellValue(Row, "acct_tp_nm","", 0);
		} else {// if Account Type Code From Popup then not to Enter this Condition, else Enter this Condition
			if(use_pop_chk == 0){
				formObj.f_cmd.value=SEARCH;
	 			var sXml=sheetObj.GetSearchData("STM_SAR_0141GS.do?f_acct_tp_cd="+sheetObj.GetCellValue(Row, Col)+"&f_acct_ctnt1="+sheetObj.GetCellValue(Row, "acct_ctnt1")
						+"&f_acct_ctnt2="+sheetObj.GetCellValue(Row, "acct_ctnt2")+"&f_acct_ctnt3="+sheetObj.GetCellValue(Row, "acct_ctnt3")
						+"&f_acct_ctnt4="+sheetObj.GetCellValue(Row, "acct_ctnt4"), FormQueryString(formObj));
				var sAcctTpCdTotalRows=ComGetTotalRows(sXml);
				sheetObj.SetCellValue(Row, "acct_tp_nm",ComGetEtcData(sXml,"acct_tp_nm"), 0);
				
				if (sAcctTpCdTotalRows == 0) {				
					sheetObj.SetCellValue(Row, Col, "", 0); 
					sheetObj.SelectCell(Row, Col);	
				}else if(sAcctTpCdTotalRows > 1) {
					sheetObj.SetCellValue(Row, "acct_tp_nm", "", 0);
					use_pop_chk = 1;
			    	ComOpenPopup("STM_SAR_0141.do?acct_ctnt1="+sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "acct_ctnt1")+"&acct_tp_cd="+sheetObj.GetCellValue(Row, Col), 900, 410, "setSheetAcctType", "0,0", true, false, Row, Col, 0);
				}
			}
		}
		
		use_pop_chk = 0;
	}
	// account  column 
	if (Col == "12" || Col == "13" || Col == "14"|| Col == "15"|| Col == "16" || Col == "17") { 		
		if (sheetObj.GetCellValue(Row,Col) == ""){
			return; 
		} else {		
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("STM_SCO_0054GS.do?acct_cd="+sheetObj.GetCellValue(Row, Col), FormQueryString(formObj));
			var sAcctTotalRows = ComGetTotalRows(sXml);
			if (sAcctTotalRows != 1) {
				sheetObj.SetCellValue(Row, Col,"");
				sheetObj.SelectCell(Row, Col);
			} 
		}	
	}
	
	if (Col == "1") {
		sheetObj.SetCellValue(Row, 2, "");
		sheetObj.SetCellValue(Row, 3, "");
		sheetObj.SetCellValue(Row, 4, "");
	}else if (Col == "2") { 	
		sheetObj.SetCellValue(Row, 3, "");
		sheetObj.SetCellValue(Row, 4, "");	
	}else if (Col == "3") { 	
		sheetObj.SetCellValue(Row, 4, "");		
	}
//	// account  column 
//	if (Col == "1") { 		
//		
//		if (sheetObj.CellValue(Row,Col) == ""){
//			return; 
//		} else {		
//			//ACCT CTNT2	
//			SarInitDataCombo(sheetObj, "acct_ctnt2", "2", " ", " ", "ACCT CTNT2&attr_ctnt1=" + sheetObj.CellValue(Row,Col));
//		}	
//	}
}
function sheet1_OnClick(sheetObj, Row, Col){
	// account  column tb
	if (Col == "2") {
		if (sheetObj.GetCellValue(Row,1) == ""){
			sheetObj.CellComboItem(Row, Col, {ComboText:"", ComboCode:""} );
		} else {	
			//ACCT CTNT2	
			SarInitDataAcctCtnt2Combo(sheetObj, Row, "acct_ctnt2", "2", " ", " ", sheetObj.GetCellValue(Row,1));
		}	
	}else if (Col == "3") { 	
		if (sheetObj.GetCellValue(Row,2) == ""){
			sheetObj.CellComboItem(Row, Col, {ComboText:"", ComboCode:""} );
		} else {		
			//ACCT CTNT3	
			SarInitDataAcctCtnt3Combo(sheetObj, Row, "acct_ctnt3", "2", " ", " ", sheetObj.GetCellValue(Row,1));
		}	
	}else if (Col == "4") { 	
		if (sheetObj.GetCellValue(Row,3) == ""){
			sheetObj.CellComboItem(Row, Col, {ComboText:"", ComboCode:""} );
		} else {		
			//ACCT CTNT4	
			SarInitDataAcctCtnt4Combo(sheetObj, Row, "acct_ctnt4", "2", " ", " ", sheetObj.GetCellValue(Row,1), '&f_acct_ctnt2='+sheetObj.GetCellValue(Row,2));
		}	
	}
}
/**
 * setAccount 조회 후 값 Return 받아 셋팅한다.
 * setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
 */
function setAccount(aryPopupData, row, col, sheetIdx) {	
	var sheetObject=sheetObjects[0];
	sheetObject.SetCellValue(row,col,aryPopupData[0][1]);
}
/**
 * setAccount 조회 후 값 Return 받아 셋팅한다.
 * setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
 */
function setAcctType(aryPopupData) {
    document.form.f_acct_tp_cd.value=aryPopupData[0][1];
}
/**
 * setAccount 조회 후 값 Return 받아 셋팅한다.
 * setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
 */
function setSheetAcctType(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	sheetObject.SetCellValue(row,col,aryPopupData[0][1]);
	sheetObject.SetCellValue(row, "acct_tp_nm",aryPopupData[0][2]);
}

/**
 * setArAccount 조회 후 값 Return 받아 셋팅한다.
 * setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
 */
function setArAcct(aryPopupData) {
    document.form.f_ar_acct_cd.value = aryPopupData[0][1];
}

function SarInitDataAcctCtnt2ComboAll(sheetObj, colName, type, appendStr, appendCode) {
	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND02 + "&f_acct_ctnt1=ALL");
	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
    if ( appendStr != "" ) appendStr = appendStr + "|";
    if ( appendCode != "" ) appendCode = appendCode + "|";
    if (type == "1" )  { //코드만 
    	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
    } else if (type == "2" ) {
    	var codeStrTemp=comboString[0].split('|'); // 코드
        var nameStrTemp=comboString[1].split('|'); // 이름
        var fullStrTemp='';  // 코드 + 이름  
        for(var i=0; i<codeStrTemp.length; i++){
            fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
            if(i != codeStrTemp.length - 1){
            	fullStrTemp = fullStrTemp + '|' ;
            }
        }
        sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
    }
}

function SarInitDataAcctCtnt3ComboAll(sheetObj, colName, type, appendStr, appendCode) {
	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND03 + "&f_acct_ctnt1=INIT");
	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
    if ( appendStr != "" ) appendStr = appendStr + "|";
    if ( appendCode != "" ) appendCode = appendCode + "|";
    if (type == "1" )  { //코드만 
    	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
    } else if (type == "2" ) {
    	var codeStrTemp=comboString[0].split('|'); // 코드
        var nameStrTemp=comboString[1].split('|'); // 이름
        var fullStrTemp='';  // 코드 + 이름  
        for(var i=0; i<codeStrTemp.length; i++){
            fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
            if(i != codeStrTemp.length - 1){
            	fullStrTemp = fullStrTemp + '|' ;
            }
        }
        sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
    }
}

function SarInitDataAcctCtnt4ComboAll(sheetObj, colName, type, appendStr, appendCode) {
	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND04 + "&f_acct_ctnt1=ALL&f_acct_ctnt2=ALL");
	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
    if ( appendStr != "" ) appendStr = appendStr + "|";
    if ( appendCode != "" ) appendCode = appendCode + "|";
    if (type == "1" )  { //코드만 
    	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
    } else if (type == "2" ) {
    	var codeStrTemp=comboString[0].split('|'); // 코드
        var nameStrTemp=comboString[1].split('|'); // 이름
        var fullStrTemp='';  // 코드 + 이름  
        for(var i=0; i<codeStrTemp.length; i++){
            fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
            if(i != codeStrTemp.length - 1){
            	fullStrTemp = fullStrTemp + '|' ;
            }
        }
        sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
    }
}