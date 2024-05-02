/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0055.js
*@FileTitle  : On off Hire Audit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
          MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
          OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0055 : business script for EES_LSE_0055
 */
function EES_LSE_0055() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
	this.obj_change=obj_change;
	this.t1sheet1_OnChange=t1sheet1_OnChange;
	this.sheet1OnSearchEnd=sheet1OnSearchEnd;
	this.t5sheet1_OnSearchEnd=t5sheet1_OnSearchEnd;
}
/* developer job */
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/**********/
	var sheetObject1=sheetObjects[0];
	var tabSheetObject1=sheetObjects[1];
	var tabSheetObject2=sheetObjects[2];
	var tabSheetObject3=sheetObjects[3];
	var tabSheetObject4=sheetObjects[4];
	var tabSheetObject5=sheetObjects[5];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var srcObj=ComGetEvent();
		switch(srcName) {
		case "btn_retrieve":
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_audit");
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			break;
		case "btn_DownExcel1":	
			if(tabSheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				tabSheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(tabSheetObject1), SheetDesign:1,Merge:1 });
			} 			
			break;			
		case "btn_DownExcel2":
			if(tabSheetObject2.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				tabSheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(tabSheetObject2), SheetDesign:1,Merge:1 });
			} 			
			break;
		case "btn_DownExcel3":	
			if(tabSheetObject3.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				tabSheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(tabSheetObject3), SheetDesign:1,Merge:1 });
			} 			
			break;
		case "btn_DownExcel4":	
			if(tabSheetObject4.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				tabSheetObject4.Down2Excel( {DownCols: makeHiddenSkipCol(tabSheetObject4), SheetDesign:1,Merge:1 });
			} 			
			break;
		case "btn_file":
			if ( srcObj.style.filter == "" ) {
				if( formObject.vndr_seq.value == "" ){
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObject.vndr_seq);
					return;
				}
				ComBtnDisable("btn_save");
				setNew("Y");
				openPopup("3");
			}
			break;
		case "btn_audit":
			if ( srcObj.style.filter == "" ) {
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
			    doActionIBSheet(sheetObjects[5],formObject,IBSEARCH_ASYNC04);
			    ComBtnEnable("btn_save");
			}
			break;
		case "btn_save":
			if(ComIsBtnEnable("btn_save")){
				doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
			}
			break;
		case "btn_new":
			setNew();
			ComBtnDisable("btn_save");
			break;
		case "btns_calendar1":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendarFromTo();
				cal.select(formObject.search_stdt, formObject.search_endt, 'yyyy-MM-dd');
			}
			break;
		case "btns_search1":
			if ( srcObj.style.filter == "" ) {
				openPopup("2");
			}
			break;
		case "btns_search2":
			if ( srcObj.style.filter == "" ) {
				openPopup("1");
			}
			break;
		case "btn_rowInsertCoincidence":
			if(ComIsBtnEnable("btn_rowInsertCoincidence")){
			    var iRow=tabSheetObject1.DataInsert(-1);
			    tabSheetObject1.SetCellValue(iRow ,"ref_no" ,sheetObject1.GetCellValue(1 , "ref_no"));
			    tabSheetObject1.SetCellValue(iRow ,"vndr_seq" ,formObject.vndr_seq.value);
			    tabSheetObject1.SetCellValue(iRow ,"audit_type" ,"C");
			    tabSheetObject1.SetCellValue(iRow ,"lse_aud_tp_cd" ,"C");
			    tabSheetObject1.SetCellValue(iRow ,"agmt_cty_cd" ,"HHO");
			}
			break;
		case "btn_rowDeleteCoincidence":
			if(ComIsBtnEnable("btn_rowDeleteCoincidence")){
			    var checkRows=tabSheetObject1.FindCheckedRow(1);
			    if(checkRows == ""){
			        return;
			    }
			    checkRows=checkRows.substr( 0 , checkRows.length -1 );
			    var arryCheckRow=checkRows.split("|");
			    for( var i=arryCheckRow.length ; i >= 0 ; i--){
				    tabSheetObject1.RowDelete(arryCheckRow[i-1] , false);
			    }
			}
			break;
		case "btn_coincidenceDiscrepancy":
			var checkRows=tabSheetObject1.FindCheckedRow(1);
			rowDataShift( tabSheetObject2 , "D" );
			break;
		case "btn_coincidenceCOM":
			rowDataShift( tabSheetObject3 , "H"  );
			break;
		case "btn_coincidenceLessor":
			rowDataShift( tabSheetObject4 , "L"  );
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
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * registering IBMultiCombo Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
 */
 function setComboObject(combo_obj){
 	comboObjects[comboCnt++]=combo_obj;
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
	/* Axon Control Setting*/
	initControl();
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_audit");
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
		 
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	ComSetFocus(document.form.vndr_seq);
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj); 
	//axon_event.addListenerForm('keydown', 'obj_keydown',  formObj); 
	//axon_event.addListenerFormat('keypress','obj_keypress', formObj); 
	axon_event.addListenerFormat('blur',  'obj_blur',   formObj); 
	axon_event.addListenerFormat('focus', 'obj_focus',  formObj); 
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":      //sheet1 init
	    with(sheetObj){       
		      var HeadTitle1="|Seq.|AGMT No.|Contract No.|CNTR No.|TP/SZ|Lease Term|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC||||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bil_fm_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bil_to_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(240);
            }
	break;
	case "t1sheet1":      //t1sheet1 init
	    with(sheetObj){
	      var HeadTitle1="|Sel|Seq.|AGMT No.||Contract No.|Term|CNTR No.|TP/SZ|Original\nStatus|COM Record|COM Record|COM Record|COM Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|Remark(s)||||";
	      var HeadTitle2="|Sel|Seq.|AGMT No.||Contract No.|Term|CNTR No.|TP/SZ|Original\nStatus|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|Remark(s)||||";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (headCount, 0, 0, true);
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"audit_type" },
	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"audit_remark",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_aud_tp_cd" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no" } ];
	       
	      InitColumns(cols);
	      SetEditable(1);
	      SetSheetHeight(260);
	      SetMergeCell(0, 3, 2, 2);
      }
	break;
	case "t2sheet1":      //t1sheet1 init
	    with(sheetObj){       
		      var HeadTitle1="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|COM Record|COM Record|COM Record|COM Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		      var HeadTitle2="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_aud_tp_cd" },
		             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(260);
            }
	break;
	case "t3sheet1":      //t1sheet1 init
	    with(sheetObj){
		      var HeadTitle1="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|COM Record|COM Record|COM Record|COM Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		      var HeadTitle2="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_aud_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(260);
            }
	    break;
	case "t4sheet1":      //t1sheet1 init
	    with(sheetObj){
		      var HeadTitle1="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|COM Record|COM Record|COM Record|COM Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		      var HeadTitle2="||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_aud_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq" } ];
		       
		      InitColumns(cols);		
		      SetEditable(1); 
		      SetSheetHeight(260);
            }
	    break;
	case "t5sheet1":      //t1sheet1 init
	    with(sheetObj){
		      var HeadTitle1="|Seq.|AUDIT Type|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|COM Record|COM Record|COM Record|COM Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record||||";
		      var HeadTitle2="|Seq.|AUDIT Type|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lse_aud_tp_cd" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lr_onh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lr_offh_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onf_hir_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);		
		      SetEditable(1);
		      SetSheetHeight(260);
            }
	    break;
	}
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:
	formObj.f_cmd.value=SEARCH;
	if(validateForm(sheetObj,formObj,sAction)){
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		var sXml=sheetObj.GetSearchData("EES_LSE_0055GS.do" , FormQueryString(formObj));
		//ComOpenWait(false);
		var arrXml=sXml.split("|$$|");
		//ComOpenWait(true);
        for( var i=0 ; i < arrXml.length ; i++ ){
        	sheetObjects[i].SetWaitImageVisible(0);
            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
        }
        ComOpenWait(false);
	}
	break;
	case IBSAVE:
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(true);
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "t1sheet1") {
			formObj.f_cmd.value=MULTI;
			var sParam1=sheetObjects[1].GetSaveString(true);
			var sParam2=sheetObjects[2].GetSaveString(true);
			var sParam3=sheetObjects[3].GetSaveString(true);
			var sParam4=sheetObjects[4].GetSaveString(true);
			sParam=sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + sParam4 +  "&" + FormQueryString(formObj);
 			var sXml=sheetObj.GetSaveData("EES_LSE_0055GS.do", sParam);
 			sheetObjects[1].LoadSaveData(sXml);
		}
	}
	ComOpenWait(false);
	sheetObj.SetWaitImageVisible(1);
	break;
	case IBSEARCH_ASYNC01:	//Form Lessor No.
	if ( validateForm(sheetObj, formObj, sAction) ) {
		var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		sheetObj.SetWaitImageVisible(0);
 		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
		sheetObj.SetWaitImageVisible(1);
		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				ComSetFocus(formObj.vndr_nm);
                doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			} else {
				ComShowCodeMessage("LSE01019");
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				ComSetFocus(formObj.vndr_seq);
			}
		} else {
			ComShowCodeMessage("LSE01019");
			formObj.vndr_seq.value="";
			formObj.vndr_nm.value="";
			ComSetFocus(formObj.vndr_seq);
		}
	}
	break;
	case IBSEARCH_ASYNC02:      //AGMT NO
	if(validateForm(sheetObj,formObj,sAction)) {
		formObj.f_cmd.value=SEARCH03;
		sheetObj.SetWaitImageVisible(0);
 		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
			formObj.lstm_cd.value=ComGetEtcData(sXml, "lstm_cd");
		} else {
			var errMsg=LseComGetErrMsg(sXml);
			if ( errMsg != "" ) {
				ComShowMessage(errMsg);
			}
			formObj.agmt_seq.value="";
			formObj.lstm_cd.value="";
		}
	}
	break;
	case IBSEARCH_ASYNC03:      //Version()List
	    if(validateForm(sheetObj,formObj,sAction)){
		    formObj.f_cmd.value=SEARCH01;
		    sheetObj.SetWaitImageVisible(0);
 		    var sXml=sheetObj.GetSearchData("EES_LSE_0055GS.do", FormQueryString(formObj));
		    sheetObj.SetWaitImageVisible(1);
		    if ( sXml != "" ) {
			    ComXml2ComboItem(sXml, comboObjects[0], "aud_ver_seq", "audit_version");
			    sheetObjects[0].RemoveAll();
			    sheetObjects[1].RemoveAll();
			    sheetObjects[2].RemoveAll();
			    sheetObjects[3].RemoveAll();
			    sheetObjects[4].RemoveAll();
			    sheetObjects[5].RemoveAll();
		    }
	    }
	break;
	case IBSEARCH_ASYNC04:	//Audit & Result
	    formObj.f_cmd.value=SEARCH02;
	    if(validateForm(sheetObj,formObj,sAction)){
	    	formObj.ref_no.value=sheetObjects[0].GetCellValue(1 , "ref_no");
		    sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
 		    var sXml=sheetObj.GetSearchData("EES_LSE_0055GS.do" , FormQueryString(formObj));
		    var arrXml=sXml.split("|$$|");
		    for( var i=0 ; i < arrXml.length ; i++ ){
		        sheetObjects[i + 1].LoadSearchData(arrXml[i],{Sync:0} );
		    }
		    ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
	    }
	break;
	}
}
/**
* registering IBTab Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
*/
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/* initializing Tab */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "Coincidence" , "");
			InsertItem( "Discrepancy" , "");
			InsertItem( "COM Only" , "");
			InsertItem( "Lessor Only" , "");
			//InsertTab( cnt++ , "Total" , -1 );
		}
		break;
	}
}
/**
 * handling event when changing tab
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	for(var i = 0; i<objs.length; i++){
	       if(i != nItem){
	        objs[i].style.display="none";
	        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       }
	      }
	beforetab=nItem;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:
			    if ( formObj.vndr_seq.value == ""  ) {
				    ComShowCodeMessage("LSE01044");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
			    }
			    if ( combo_aud_ver_seq_text.value == "" ) {
				    ComShowCodeMessage("LSE01085");
				    ComSetFocus(combo_aud_ver_seq);
				    return false;
				    break;
			    }
			    return true;
			break;
			case IBSEARCH_ASYNC04:
				if ( formObj.vndr_seq.value == ""  ) {
				    ComShowCodeMessage("LSE01044");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
			    }
				if (combo_aud_ver_seq_text.value == "" ) {
				    ComShowCodeMessage("LSE01085");
				    ComSetFocus(combo_aud_ver_seq);
				    return false;
				    break;
			    }
				var periodStdt=formObj.search_stdt.value;
    			periodStdt=periodStdt.replaceStr("-","");
    			var periodEtdt=formObj.search_endt.value;
    			periodEtdt=periodEtdt.replaceStr("-","");
    			if ( periodStdt == "" ) {
    				ComShowCodeMessage("LSE01010");
    				ComSetFocus(formObj.search_stdt);
    				return false;
    				break;
    			}
    			if ( periodEtdt == "" ) {
    				ComShowCodeMessage("LSE01011");
    				ComSetFocus(formObj.search_endt);
    				return false;
    				break;
    			}
    			if ( Number(periodStdt) > Number(periodEtdt)) {
    				ComShowCodeMessage("LSE01051");
    				ComSetFocus(formObj.search_stdt);
    				return false;
    				break;
    			}
				if(sheetObjects[0].RowCount()<= 0){
					ComShowCodeMessage("LSE01048");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
				}
				return true;
			break;
			case IBSAVE:
				var chkValidate=true;
				for(var i=2 ; i <= sheetObjects[1].LastRow(); i++ ){
					if(sheetObjects[1].GetCellValue(i , "agmt_seq") == ""){
			        	//alert("1");
						ComShowCodeMessage("LSE01006");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "agmt_seq");
			        	break;
			        	return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "lstm_cd") == ""){
			        	//alert("2");
			        	ComShowCodeMessage("LSE01009");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "lstm_cd");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "lstm_cd").length != 2){
			        	//alert("3");
			        	ComShowCodeMessage("LSE01056");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "lstm_cd");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "cntr_no") == ""){
			        	//alert("4");
			        	ComShowCodeMessage("LSE01064");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "cntr_no");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "cntr_no").length != 11){
			        	//alert("5");
			        	ComShowCodeMessage("LSE01074");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "cntr_no");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "cntr_tpsz_cd") == ""){
			        	//alert("6");
			        	ComShowCodeMessage("LSE01015");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "cntr_tpsz_cd");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "cntr_tpsz_cd").length != 2){
			        	//alert("7");
			        	ComShowCodeMessage("LSE01038");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "cntr_tpsz_cd");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "onh_dt") == ""){
			        	//alert("8");
			        	ComShowCodeMessage("LSE01063");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "onh_dt");
			            break;
			            return false;
			        }
					if(sheetObjects[1].GetCellValue(i , "onh_loc_cd").length > 5){
			        	//alert("10");
			        	ComShowCodeMessage("LSE01037");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "onh_loc_cd");
			            break;
			            return false;
			        }
			        if( document.form.audit_tp[2].checked == true ){
			        	if(sheetObjects[1].GetCellValue(i , "offh_dt") == ""){
			            	//alert("11");
			            	ComShowCodeMessage("LSE01088");
			        	    chkValidate=false;
			        	    sheetObjects[1].SelectCell(i , "offh_dt");
			        	    break;
			        	    return false;
			        	}
			        	if(sheetObjects[1].GetCellValue(i , "offh_loc_cd").length > 5){
			               //alert("13");
			               ComShowCodeMessage("LSE01037");
			        	   chkValidate=false;
			        	   sheetObjects[1].SelectCell(i , "offh_loc_cd");
			               break;
			               return false;
			            }
			        }
			        if(sheetObjects[1].GetCellValue(i , "lr_onh_dt") == ""){
			        	//alert("14");
			        	ComShowCodeMessage("LSE01063");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "lr_onh_dt");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].GetCellValue(i , "lr_onh_loc_cd").length > 5){
			        	//alert("16");
			        	ComShowCodeMessage("LSE01037");
			        	chkValidate=false;
			        	sheetObjects[1].SelectCell(i , "lr_onh_loc_cd");
			            break;
			            return false;
			        }
			        if ( document.form.audit_tp[2].checked == true ) {
			        	if(sheetObjects[1].GetCellValue(i , "lr_offh_dt") == ""){
			            	//alert("17");
			            	ComShowCodeMessage("LSE01088");
			                chkValidate=false;
			                sheetObjects[1].SelectCell(i , "lr_offh_dt");
			                break;
			                return false;
			            }
			        	if(sheetObjects[1].GetCellValue(i , "lr_offh_loc_cd").length > 5){
			            	//alert("19");
			            	ComShowCodeMessage("LSE01037");
			                chkValidate=false;
			                sheetObjects[1].SelectCell(i , "lr_offh_loc_cd");
			                break;
			                return false;
			            }
			        }
					var onhDt=sheetObjects[1].GetCellValue(i , "onh_dt");
					var lrOnhDt=sheetObjects[1].GetCellValue(i , "lr_onh_dt");
					var offhDt=sheetObjects[1].GetCellValue(i , "offh_dt");
					var lrOffhDdt=sheetObjects[1].GetCellValue(i , "lr_offh_dt");
	                var searchStdt=formObj.search_stdt.value.replaceStr("-" , "");;
	                var searchEndt=formObj.search_endt.value.replaceStr("-" , "");;
	                // checking On-Hire Date in case of On-Hire Audit 
	                if ( document.form.audit_tp[1].checked == true ) {
		                if(Number(onhDt) > Number(searchEndt)){
		                	//alert("20-1");
		                	ComShowCodeMessage("LSE01086");
		                	chkValidate=false;
		                	sheetObjects[1].SelectCell(i , "onh_dt");
				            break;
				            return false;
		                }
	                }
	                // checking On-Hire Date in case of Off-Hire Audit
	                if ( document.form.audit_tp[2].checked == true ) {
		                if ( offhDt != "" ) {
		                    if( Number(searchStdt) > Number(offhDt) || Number(offhDt) > Number(searchEndt) ){
		                	    ComShowCodeMessage("LSE01087");
		                	    chkValidate=false;
		                	    sheetObjects[1].SelectCell(i , "offh_dt");
				                break;
				                return false;
		                   }
		                }
	                }
	                if ( sheetObjects[1].GetCellValue(i , "onh_dt") != "" && sheetObjects[1].GetCellValue(i , "offh_dt") != "" ) {
	                	if(Number(onhDt) > Number(offhDt)){
	                	    ComShowCodeMessage("LSE01086");
	                	    chkValidate=false;
	                	    sheetObjects[1].SelectCell(i , "onh_dt");
			                break;
			                return false;
	                    }
	                }
	                if ( document.form.audit_tp[1].checked == true ) {
		                if(onhDt != lrOnhDt ){
		                	ComShowCodeMessage("LSE01086");
		                	chkValidate=false;
		                	sheetObjects[1].SelectCell(i , "onh_dt");
				            break;
				            return false;
		                }
	                }
	                if ( document.form.audit_tp[2].checked == true ) {
                        if(offhDt != lrOffhDdt){
                        	//alert("21");
                        	ComShowCodeMessage("LSE01087");
	                	    chkValidate=false;
	                	    sheetObjects[1].SelectCell(i , "offh_dt");
	                	    break;
	                	    return false;
                        }
	                }
			    }
			    if(chkValidate == true){
			        return true;
			    }else{
			        return false;
			    }
			break;
			}
		}
	}
	return true;
}
//	function obj_keypress() {
//		var obj=event.srcElement;
//		switch(obj.dataformat) {
//		case "ymd":
//		case "ym":
//		case "hms":
//		case "hm":
//		case "jumin":
//		case "saupja":
//		case "int":
//			ComKeyOnlyNumber(obj);
//			break;
//		case "float":
//			ComKeyOnlyNumber(obj, "-.");
//			break;
//		case "eng":
//			ComKeyOnlyAlphabet();
//			break;
//		case "engup":
//			ComKeyOnlyAlphabet('upper');
//			break;
//		case "engdn":
//			ComKeyOnlyAlphabet('lower');
//			break;
//		default:
//			ComKeyOnlyNumber(obj);
//		break;
//		}
//	}
/**
 * handling Location blur event
 */
function obj_blur(){
	var obj=event.srcElement;
	switch(ComGetEvent("name")){
	case "search_stdt":
		//checking number
		ComChkObjValid(obj);
		break;
	case "search_endt":
		//checking number
		ComChkObjValid(obj);
		break;
	case "vndr_seq":
	    if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
	    	document.form.vndr_nm.value=""
		}
		break;
	case "agmt_seq":
	    if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
	        document.form.lstm_cd.value="";
		}
		break;
	default:
		//checking Validation
		break;
	}
}
/**
 * handling event in case of focus
 */
function obj_focus(){
	var obj=event.srcElement;
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//deleting data unit separator
		if(obj.name == "period_stdt" ||  obj.name == "period_eddt"){
		    if(obj.value.length == 10 ){
		         ComClearSeparator(event.srcElement);
			}
		}    
	}
}
function obj_change(){
	var obj=event.srcElement;
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "agmt_seq":
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			break;
		case "search_stdt":		//Location Code
	        if(formObj.search_endt.value != ""){
	            checkEffectiveDate( formObj.search_stdt , formObj.search_endt ) ;
	        }
	        break;
	    case "search_endt":		//Location Code
            checkEffectiveDate( formObj.search_stdt , formObj.search_endt ) ;
            break;
		case "vndr_seq":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			break;
		}
	}
}
/**
 * last day
 */
function GetLastDay(yyyy, mm) {
	var m=parseInt(mm,10) - 1;
	var end=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
		end[1]=29;
	}
	return end[m];
}
/**
 * handing process Pop-up<br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
 * @param object
 * @param Row index
 */
function openPopup(type, Row, Col) {
	var formObj=document.form;
	if ( type == "1" ) {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setAgmtNo', '1,0', true);
	}else if ( type == "2" ) {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	}else if ( type == "3" ) {
		ComOpenPopup('/opuscntr/EES_LSE_0056.do', 820, 450, '', '1,0,1,1,1,1,1,1', false);
	}
}
/**
 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
 * @param Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj=sheetObjects[SheetIdx];
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value=ComLtrim(aryPopupData[0][2],"0");
		formObj.vndr_nm.value=aryPopupData[0][4];
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	}
}
 /**
  * handling process for Agmt No(Service Provider) Pop-up Return Value<br>
  * @param Return value array
  * @param Row index
  * @param Col index
  * @param Sheet Array index
  */
function setAgmtNo(aryPopupData, Row, Col, SheetIdx) {
	document.form.agmt_seq.value=aryPopupData[0][5];
	document.form.lstm_cd.value=aryPopupData[0][7];
}
/**
* retrieving in case import saving(EES_LSE_0056 call)
*/
function searchForSave(){
	var formObj=document.form;
	formObj.search_stdt.value="";
	formObj.search_endt.value="";
	formObj.agmt_seq.value="";
	formObj.lstm_cd.value="";
	//formObj.audit_tp[0].checked = true;
	formObj.audit_tp[1].checked=true;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	comboObjects[0].SetItemCheck(0,1);
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}
/**
* initializing IBMultiCombo
*/
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
	case "combo1":
		with(comboObj) {
			//BackColor = "cyan";
			SetDropHeight(150);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	}
}
/**
* initializing
*/
function setNew(importYN){
	var sheetObject1=sheetObjects[0];
	var tabSheetObject1=sheetObjects[1];
	var tabSheetObject2=sheetObjects[2];
	var tabSheetObject3=sheetObjects[3];
	var tabSheetObject4=sheetObjects[4];
	var tabSheetObject5=sheetObjects[5];
	var formObject=document.form;
    sheetObject1.RemoveAll();
    tabSheetObject1.RemoveAll();
    tabSheetObject2.RemoveAll();
    tabSheetObject3.RemoveAll();
    tabSheetObject4.RemoveAll();
    tabSheetObject5.RemoveAll();
    formObject.search_stdt.value="";
    formObject.search_endt.value="";
    if(importYN != "Y" ){
        formObject.vndr_seq.value="";
        formObject.vndr_nm.value="";
        combo_aud_ver_seq.RemoveAll();
    }
    formObject.agmt_seq.value="";
    formObject.lstm_cd.value="";
    formObject.ref_no.value="";
    //formObject.audit_tp[0].checked = true;
    formObject.audit_tp[1].checked=true;
	ComEnableObject(formObject.vndr_seq, true);
	formObject.vndr_seq.className="input1";
	ComEnableObject(formObject.btns_search1, true);
	ComEnableObject(formObject.agmt_seq, true);
	ComEnableObject(formObject.btns_search2, true);
	ComEnableObject(formObject.btns_calendar1, true);
	ComEnableObject(formObject.search_stdt, true);
	ComEnableObject(formObject.search_endt, true);
	formObject.search_stdt.className="input1";
	formObject.search_endt.className="input1";
	formObject.audit_tp[0].disabled=true;
	formObject.audit_tp[1].disabled=false;
	formObject.audit_tp[2].disabled=false;
	comboObjects[0].SetEnable(1);
    ComSetFocus(document.form.vndr_seq);
}
/**
* t5sheet1_OnSearchEnd
* calling event after retrieving Sheet1
*/
function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComBtnEnable("btn_save");
}
/**
* rowDataShift
* handing process sheetCoincidence
*/
function rowDataShift( shiftObj , tabGubun){
	var checkRows=shiftObj.FindCheckedRow(1);
	if(checkRows == ""){
	    return;
	}
	var checkRows=shiftObj.FindCheckedRow(1);
	if(checkRows.length > 0){
	  checkRows=checkRows.substr( 0 , checkRows.length -1 );
	}
	var arryCheckRow=checkRows.split("|");
	var iRow;
	for( var i=arryCheckRow.length ; i > 0 ; i--){
		iRow=sheetObjects[1].DataInsert(-1);
		sheetObjects[1].SetCellValue( iRow , "agmt_no",shiftObj.GetCellValue(arryCheckRow[i-1] , "agmt_no"));
		sheetObjects[1].SetCellValue( iRow , "ref_no",shiftObj.GetCellValue(arryCheckRow[i-1] , "ref_no"));
		sheetObjects[1].SetCellValue( iRow , "lstm_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "lstm_cd"));
		sheetObjects[1].SetCellValue( iRow , "cntr_no",shiftObj.GetCellValue(arryCheckRow[i-1] , "cntr_no"));
		sheetObjects[1].SetCellValue( iRow , "cntr_tpsz_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "cntr_tpsz_cd"));
		sheetObjects[1].SetCellValue( iRow , "onh_dt",shiftObj.GetCellValue(arryCheckRow[i-1] , "onh_dt"));
		sheetObjects[1].SetCellValue( iRow , "onh_loc_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "onh_loc_cd"));
		sheetObjects[1].SetCellValue( iRow , "offh_dt",shiftObj.GetCellValue(arryCheckRow[i-1] , "offh_dt"));
		sheetObjects[1].SetCellValue( iRow , "offh_loc_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "offh_loc_cd"));
		sheetObjects[1].SetCellValue( iRow , "lr_onh_dt",shiftObj.GetCellValue(arryCheckRow[i-1] , "lr_onh_dt"));
		sheetObjects[1].SetCellValue( iRow , "lr_onh_loc_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "lr_onh_loc_cd"));
		sheetObjects[1].SetCellValue( iRow , "lr_offh_dt",shiftObj.GetCellValue(arryCheckRow[i-1] , "lr_offh_dt"));
		sheetObjects[1].SetCellValue( iRow , "lr_offh_loc_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "lr_offh_loc_cd"));
		sheetObjects[1].SetCellValue( iRow , "onf_hir_sts_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "onf_hir_sts_cd"));
		sheetObjects[1].SetCellValue( iRow , "lse_aud_tp_cd","C");
		sheetObjects[1].SetCellValue( iRow , "audit_type",tabGubun);
		sheetObjects[1].SetCellValue( iRow , "vndr_seq",shiftObj.GetCellValue(arryCheckRow[i-1] , "vndr_seq"));
		sheetObjects[1].SetCellValue( iRow , "agmt_cty_cd",shiftObj.GetCellValue(arryCheckRow[i-1] , "agmt_cty_cd"));
		sheetObjects[1].SetCellValue( iRow , "agmt_seq",shiftObj.GetCellValue(arryCheckRow[i-1] , "agmt_seq"));
		shiftObj.RowDelete(arryCheckRow[i-1] , false);
	}
}
/**
* t1sheet1_OnSaveEnd
* calling event after retrieving t1Sheet1
*/
function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
	} else {
		ComShowMessage(ErrMsg);
	}
	ComEnableObject(formObj.vndr_seq, false);
	formObj.vndr_seq.className="input2";
	ComEnableObject(formObj.btns_search1, false);
	ComEnableObject(formObj.agmt_seq, false);
	ComEnableObject(formObj.btns_search2, false);
	ComEnableObject(formObj.btns_calendar1, false);
	ComEnableObject(formObj.search_stdt, false);
	ComEnableObject(formObj.search_endt, false);
	formObj.search_stdt.className="input2";
	formObj.search_endt.className="input2";
	formObj.audit_tp[0].disabled=true;
	formObj.audit_tp[1].disabled=true;
	formObj.audit_tp[2].disabled=true;
	comboObjects[0].SetEnable(0);
}
/**
* sheet1_OnSearchEnd
* calling event after retrieving Sheet1
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var strBilFmDt=sheetObjects[0].GetCellValue(1 , "bil_fm_dt");
	var strBilToDt=sheetObjects[0].GetCellValue(1 , "bil_to_dt");
	var strAuditType=sheetObjects[0].GetCellValue(1 , "onf_hir_sts_cd");
	if(strBilFmDt != "" && strBilToDt != ""){
		formObj.search_stdt.value=strBilFmDt;
		formObj.search_endt.value=strBilToDt;
		ComBtnDisable("btn_audit");
		if(strAuditType == "N"){
		    formObj.audit_tp[1].checked=true;
		}else if(strAuditType == "F"){
		    formObj.audit_tp[2].checked=true;
		}
		ComEnableObject(formObj.vndr_seq, false);
		formObj.vndr_seq.className="input2";
		ComEnableObject(formObj.btns_search1, false);
		ComEnableObject(formObj.agmt_seq, false);
		ComEnableObject(formObj.btns_search2, false);
		ComEnableObject(formObj.btns_calendar1, false);
		ComEnableObject(formObj.search_stdt, false);
		ComEnableObject(formObj.search_endt, false);
		formObj.search_stdt.className="input2";
		formObj.search_endt.className="input2";
		formObj.audit_tp[0].disabled=true;
		formObj.audit_tp[1].disabled=true;
		formObj.audit_tp[2].disabled=true;
		comboObjects[0].SetEnable(0);
	}else{
		ComBtnEnable("btn_audit");
		ComEnableObject(formObj.vndr_seq, true);
		formObj.vndr_seq.className="input1";
		ComEnableObject(formObj.btns_search1, true);
		ComEnableObject(formObj.agmt_seq, true);
		ComEnableObject(formObj.btns_search2, true);
		ComEnableObject(formObj.btns_calendar1, true);
		ComEnableObject(formObj.search_stdt, true);
		ComEnableObject(formObj.search_endt, true);
		document.form.search_stdt.className="input1";
		document.form.search_endt.className="input1";
		formObj.audit_tp[0].disabled=true;
		formObj.audit_tp[1].disabled=false;
		formObj.audit_tp[2].disabled=false;
		comboObjects[0].SetEnable(1);
	}
}
/**
* calling event after retrieving OnChang
*/
function combo_aud_ver_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
}
/* end of developer job */
