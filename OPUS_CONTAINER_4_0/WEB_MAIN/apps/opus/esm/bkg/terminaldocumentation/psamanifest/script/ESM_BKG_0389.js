/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0389.js
 *@FileTitle  : OPUS vs Portnet Reconciliation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/05
=========================================================*/
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//View TYPE
var viewType=0;
// modification of Port, ETD 
var changePortNEtd=true;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var comboObject1=comboObjects[0];
	/*******************************************************/
	var formObject=document.form;
	if (tabObjects[0].GetSelectedIndex() == 0)  {
		sheetObj=sheetObjects[0];
    } else if (tabObjects[0].GetSelectedIndex() == 1)  {
    	sheetObj=sheetObjects[1];
    } else if (tabObjects[0].GetSelectedIndex() == 2){
    	sheetObj=sheetObjects[2];
    }
	try {
		var srcName=ComGetEvent("name");
		if (srcName == "" || srcName == undefined)
			return false;
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[3],document.form, IBSEARCH);
			break;
		case "btn_New":
			formObject.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			comboObjects[0].RemoveAll();
			tabObjects[0].SetSelectedIndex(0);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[2],document.form, IBSAVE);
			break;
		case "btn_DownExcel":
			var sheetObj = sheetObjects[tabObjects[0].GetSelectedIndex()];
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ HiddenColumn:-1});
			}
			
			break;
		case "btn_PSAIF":
			if (formObject.vvd.value.length < 1 ) {
				ComShowCodeMessage("BKG00115");
			}else {
				// EXCEL FILE UPLOAD
				sheetObjects[2].RemoveAll();
				sheetObjects[2].LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",WorkSheetName:"",Append:false,ColumnMapping:"||2|3|4|5|6|7"});
				ComOpenWait(true);
//				sheetObjects[2].ColumnSort("cntr_no");
//				for(var i=1; i <= sheetObject3.RowCount(); i++) {
//					sheetObject3.SetCellValue(i, "cntr_sz_cd",sheetObject3.GetCellValue(i, "cntr_tp_cd").substring(0,2));
//					sheetObject3.SetCellValue(i, "cntr_tp_cd",sheetObject3.GetCellValue(i, "cntr_tp_cd").substring(2,4));
//				}
				tabObjects[0].SetSelectedIndex(2);
				ComOpenWait(false);
				ComBtnEnable("btn_Save");
			}
			break;
//		case "btn_JurongIF":
//			alert("1")
//			if (formObject.vvd.value.length < 1) {
//				alert("2")
//				ComShowCodeMessage("BKG00115");
//			}else {
//				alert("3")
//				// FILE UPLOAD
//				var return_val= openUpload(formObject.subSysCd.value);
//				alert("33")
//				if (return_val) {
//					alert("4")
//					formObject.file_key.value=return_val;
//					// parsing by using FILE KEY in server
//					doActionIBSheet(sheetObjects[3],document.form, COMMAND01);
//				}
//			}
//			break;
		case "btn_Print":
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0876.do?pgmNo=ESM_BKG_0876", "0876", 1024, 720, false);
			break;
		case "btn_cal1":
			var cal=new ComCalendar(); 
			cal.setEndFunction("etdChange");
 			cal.select(formObject.eta_etd, 'yyyy-MM-dd');
 			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++) {
        initCombo(comboObjects[k],k+1);
    }
	for(var k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    document.form.etd_dt.value=ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
    document.form.eta_etd.value=document.form.etd_dt.value;
    document.form.eta_dt.value=document.form.etd_dt.value;
    ComBtnDisable("btn_Save");
    portChange();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //t1sheet1 init
		with(sheetObj){			
			var HeadTitle1="Seq.|BKG No.|Container No.|OPUS|OPUS|OPUS|OPUS|OPUS|PSA|PSA|PSA|PSA|PSA|PSA";
			var HeadTitle2="Seq.|BKG No.|Container No.|TP|SZ|POD|Special|Load|TP|SZ|POD|Special|Load|Diff";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			
			  var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"opus_cntr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"opus_cntr_sz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"opus_port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"next_pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"next_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",    ColMerge:1,   SaveName:"opus_special",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"opus_load",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"psa_cntr_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"psa_cntr_sz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"psa_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",    ColMerge:1,   SaveName:"psa_special",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_load",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_diff",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(377);
			SetEditable(1);
			SetRangeBackColor(1,3,1,16,"#555555");
		}
		break;
	case 2:      //t2sheet1 init
		with(sheetObj){
			var HeadTitle="Seq.|Container No.|TP|SZ|POD|Special|Load";			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"next_pod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//			 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"next_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:200,  Align:"Center",    ColMerge:0,   SaveName:"special",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(377);
			SetEditable(1);
		}
		break;
	case 3:      //t3sheet1 init
		with(sheetObj){
			var HeadTitle="|Seq.|Container No.|TP|SZ|POD|Special|Load|VVD_NAME";
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:200,  Align:"Center",    ColMerge:0,   SaveName:"special",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"und_deck_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(377);
			SetEditable(1);
		}
		break;
	case 4:      //t1sheet2 init
		with(sheetObj){		
			var HeadTitle="vvd";
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );		
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
		}
		break;
	}
}
// handling of Sheet 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:     
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			tabObjects[0].SetSelectedIndex(0);
			sheetObjects[0].RenderSheet(0);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0389GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if(arrXml.length > 0)
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
				// sorting
				sheetObjects[0].ColumnSort("bkg_no|cntr_no");
			if(arrXml.length > 1){
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
				// sorting
				sheetObjects[1].ColumnSort("cntr_no");
			}
			if(arrXml.length > 2){
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:0} );
				// sorting
				sheetObjects[2].ColumnSort("cntr_no");
			}
			
			//  changing TAB by RADIO BOX 
			tabObjects[0].SetSelectedIndex(viewType);
			sheetObjects[0].RenderSheet(1);
			ComBtnDisable("btn_Save");			
			ComOpenWait(false);
//			checkDifference(sheetObjects[0]);
		}
		break;
	case COMMAND01:      // parsing Jurong I/F 	
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND01;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0389GS.do", FormQueryString(formObj));
		//  Loading at sheet
		sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		sheetObjects[2].ColumnSort("cntr_no");
		tabObjects[0].SetSelectedIndex(2);
		
		ComOpenWait(false);
		ComBtnEnable("btn_Save");
		break;
	case IBSAVE:        
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'save')) {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var params=sheetObj.GetSaveString(true) + "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0389GS.do", params);
				sheetObj.LoadSaveData(sXml);
				var state=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);   				  
				if (state == "S") {   
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
				}
				ComOpenWait(false);
			}
		}
		break;
	case SEARCH01:      //searching code
		formObj.f_cmd.value=SEARCH01;		
		sheetObj.DoSearch("ESM_BKG_0389GS.do", FormQueryString(formObj), {Sync:2} );
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
/**
 * setting Tab 
 * setting item of Tab
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "Unmatch" , "");
			InsertItem( "OPUS" , "");
			InsertItem( "PSA" , "");
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
//	objs[beforetab].style.display="none";
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	//---------------important --------------------------//
	
	//------------------------------------------------------//
	beforetab=nItem;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.rly_port.value.length < 5) {
			ComShowCodeMessage("BKG00424");
			formObj.rly_port.focus();
			return false;
		}
		if (formObj.vvd.value.length < 9) {
			ComShowCodeMessage("BKG00115");
			return false;
		}		
	}
	return true;
}
/**
 *  handling Difference Font color after searching Tab1 Sheet1
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
//		for (var i=2; i <= LastRow(); i ++)
//		{
//			if ("Y" == GetCellValue(i, "PSA_DIFF"))
//			SetCellFontColor(i, "PSA_DIFF","#FF0000");// red color
//		}
		checkDifference(sheetObjects[0]);
	}
}

function t3sheet1_OnLoadExcel(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		for(var i=1;i <= sheetObj.RowCount();i++){
//			if("" == sheetObj.GetCellValue(i,"cntr_no") && ""==sheetObj.GetCellValue(i,"cntr_tp_cd")
//					&& ""==sheetObj.GetCellValue(i,"cntr_sz_cd") && ""==sheetObj.GetCellValue(i,"port_cd")
//					&& ""==sheetObj.GetCellValue(i,"special") && ""==sheetObj.GetCellValue(i,"und_deck_tp_id")){
			if("" == sheetObj.GetCellValue(i,"cntr_no")){
				sheetObj.RowDelete(i,0);
				i = i - 1;
			}
		}
		sheetObj.ReNumberSeq();
	}
}

//registering the created IBCombo Object at page as comboObjects list
function setComboObject(combo_obj){
	  comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing combo
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt=0;
	switch(comboObj.id) {
	case "cboVVD":
		with (comboObj) {
			SetColAlign(0, "left");
			SetColWidth(0, "150");
			SetDropHeight(400);
			SetTitle("VVD");
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	}
}
function cboVVD_OnKeyDown(comboObj, KeyCode, Shift) {
	document.form.vvd.value=comboObj.GetSelectText();
}  
/**
 * handling VVD combo modification
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboVVD_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){//comboObj,value,text) {
	document.form.vvd.value=NewText;
	if (NewText=="") 
		document.form.vvd.value=OldText;
}
/**
 * handling of searching in case of modifying PORT  
 * @return
 */
function portChange()
{
	changePortNEtd=true;
	var form=document.form;
	// searching code in case of modifying 
	if (changePortNEtd) {
		if (form.rly_port.value.length > 4 && form.eta_etd.value.length == 10) {
			comboObjects[0].SetEnable(0);
			// searching VVD list
			ComOpenWait(true);
			doActionIBSheet(sheetObjects[3],document.form, SEARCH01);		
			// initializing modification after searching
			changePortNEtd=false;
			// setting to COMBO
			comboObjects[0].RemoveAll();
			for(var i=1; i <= sheetObjects[3].RowCount(); i++ ) {
				comboObjects[0].InsertItem(i-1, sheetObjects[3].GetCellValue(i,"vvd"), sheetObjects[3].GetCellValue(i,"vvd"));
			}
			ComOpenWait(false);
			comboObjects[0].SetEnable(1);
		}
	}
}
/**
 *  handling in case of modifying ETD
 * @return
 */
function etdChange()
{
	changePortNEtd=true;
	var form=document.form;
	form.etd_dt.value="";
	form.eta_dt.value="";
	if (form.trans_tp_cd.value=="E") {
		form.etd_dt.value=form.eta_etd.value;
	}else {
		form.eta_dt.value=form.eta_etd.value;
	}
	// searching code in case of modifying
	if (changePortNEtd) {
		if (form.rly_port.value.length > 4 && form.eta_etd.value.length == 10) {
			comboObjects[0].SetEnable(0);
			// searching VVD list
			ComOpenWait(true);
			doActionIBSheet(sheetObjects[3],document.form, SEARCH01);		
			// initializing modification after searching 
			changePortNEtd=false;
			// setting to COMBO
			comboObjects[0].RemoveAll();
			for(var i=1; i <= sheetObjects[3].RowCount(); i++ ) {
				comboObjects[0].InsertItem(i-1, sheetObjects[3].GetCellValue(i,"vvd"), sheetObjects[3].GetCellValue(i,"vvd"));
			}
			ComOpenWait(false);
			comboObjects[0].SetEnable(1);
		}
	}
}
/**
 * View Type modification
 * @param val
 * @return
 */
function changeViewType(val) {
	viewType=val;
	tabObjects[0].SetSelectedIndex(val);
}
/**
 * comparing OPUS vs PSA 
 * 
 * @param sheetObj
 * @return
 */ 
function checkDifference(sheetObj) {
	var diff;
	for(var i=2; i <= sheetObj.RowCount()+1 ; i++) {
		diff="N";
		with(sheetObj) {
			//comparing TP 
			if (GetCellValue(i, "opus_cntr_tp_cd")!=GetCellValue(i, "psa_cntr_tp_cd")) {
				SetCellBackColor(i,"psa_cntr_tp_cd","#64FF64");
				diff="Y";
			}
			// comparing SZ 
			if (GetCellValue(i, "opus_cntr_sz_cd")!=GetCellValue(i, "psa_cntr_sz_cd")) {
				SetCellBackColor(i,"psa_cntr_sz_cd","#64FF64");
				diff="Y";
			}
			// comparing PORT
			if (document.form.trans_tp_cd.value=="E") {
				if (GetCellValue(i, "opus_port_cd")!=GetCellValue(i, "psa_port_cd")) {
					SetCellBackColor(i,"psa_port_cd","#64FF64");
					diff="Y";
				}
			}else {
				if (GetCellValue(i, "opus_port_cd")!=GetCellValue(i, "psa_port_cd")) {
					SetCellBackColor(i, "psa_port_cd","#64FF64");
					diff="Y";
				}
			}
			// comparing SPECIAL
			if (GetCellValue(i, "opus_special")!=GetCellValue(i, "psa_special")) {
				SetCellBackColor(i,"psa_special","#64FF64");
				diff="Y";
			}
			// comparing LOAD 
			if (GetCellValue(i, "opus_load")!=GetCellValue(i, "psa_load")) {
				SetCellBackColor(i,"psa_load","#64FF64");
				diff="Y";
			}
			SetCellValue(i, "psa_diff",diff);
			if (diff=="Y") {			
				SetCellFontColor(i, "psa_diff","#FF0000");// red
			}else {
				SetCellFontColor(i, "psa_diff","#000000");// black
			}
		}
	}
}
/**
 * Trans modification
 * @return
 */
function trans_tp_change()
{
	var form=document.form;
	if (form.trans_tp_cd.value=="E") {
		document.all.spanEtdEta.innerHTML="ETD";
		sheetObjects[0].SetCellValue(1,10,"POL");
		sheetObjects[0].SetCellValue(1,5,"POL");
		sheetObjects[1].SetCellValue(0,4,"POL");
		sheetObjects[2].SetCellValue(0,5,"POL");
		form.eta_etd.value=form.etd_dt.value;
//		sheetObjects[0].SetColHidden("next_pod",1);
//		sheetObjects[0].SetColHidden("next_vvd",1);
//		sheetObjects[1].SetColHidden("next_pod",1);
//		sheetObjects[1].SetColHidden("next_vvd",1);
	}else {
		document.all.spanEtdEta.innerHTML="ETA";
		sheetObjects[0].SetCellValue(1,5,"POD");
		sheetObjects[0].SetCellValue(1,10,"POD");
		sheetObjects[1].SetCellValue(0,4,"POD");
		sheetObjects[2].SetCellValue(0,5,"POD");
		form.eta_etd.value=form.eta_dt.value;
//		sheetObjects[0].SetColHidden("next_pod",0);
//		sheetObjects[0].SetColHidden("next_vvd",0);
//		sheetObjects[1].SetColHidden("next_pod",0);
//		sheetObjects[1].SetColHidden("next_vvd",0);
	}
	etdChange();
}
