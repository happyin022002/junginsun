/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0212.js
*@FileTitle  :  DG Cargo Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObject1,formObject,IBDELETE);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject , IBSAVE);
			break;
		case "btn_TransDGM":
			doActionIBSheet(sheetObject1, formObject , MULTI01);
			break;
		case "btn_TransDGL":
			doActionIBSheet(sheetObject1, formObject , MULTI02);
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_New":
			sheetObjects[0].RemoveAll();
			formObject.reset();
			formObject.vvd.focus();
			comboObjects[0].SetSelectCode("020");
			comboObjects[1].SetSelectCode("02");
			break;
		case "btn_SelectAll":
			sheetObject1.CheckAll(1,2);
			if (sheetObject1.CheckedRows(1) < 1) {
				document.getElementById("btn_SelectAll").innerHTML="Select All";
			}else {
				document.getElementById("btn_SelectAll").innerHTML="Deselect All";
			}
			break;
		case "btn_DownExcel":
			var exceptLines="";
			var chkCnt=0;
			//  non-checked data
			for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
				if (sheetObjects[0].GetCellValue(i, "Sel")==0)
					exceptLines=exceptLines + "|" + i;
				else {
					chkCnt++;
				}
			}			
			if (chkCnt > 0) {
				sheetObjects[0].RenderSheet(0);
				sheetObjects[0].Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1});
				sheetObjects[0].RenderSheet(1);
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_cal1":
			var cal=new ComCalendar();
			cal.select(formObject.send_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal2":
			var cal=new ComCalendar();
			cal.select(formObject.io_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal3":
			var cal=new ComCalendar();
			cal.select(formObject.arv_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal4":
			var cal=new ComCalendar();
			cal.select(formObject.from_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal5":
			var cal=new ComCalendar();
			cal.select(formObject.to_dt, 'yyyy-MM-dd');
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
// registering the created IBCombo Object at page as comboObjects list
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
	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
	// handling input Key 
	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// initializing button
	comboAuth.SetSelectIndex(0);
	comboIO.SetSelectIndex(1);
	disableButtons();
}
/**
 * deactivating button
 * @return
 */ 
function disableButtons()
{
	ComBtnDisable("btn_TransDGM");
	ComBtnDisable("btn_TransDGL");
	ComBtnDisable("btn_Save");
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
	case "sheet1":
	    with(sheetObj){
		        
		      var HeadTitle="|Sel.|Seq.|I/B Seq.|Container No.|UN No.|Certi No.|Certi No.|Job|Class|Class|Net Weight|B/L No.|Substance||||||";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ib_seq" },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"certi_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"certi_seq_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"job",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"net_weight",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"substance",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"msn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cstms_decl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);		
		      SetEditable(1);
		      SetSheetHeight(150);
		      
		      SetColProperty("cntr_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("imdg_un_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("certi_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("imdg_clss_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("imdg_comp_grp_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("bl_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("bkg_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("msn_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("pol_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("pod_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("cntr_seq", {AcceptKeys : "N"} );
		      SetColProperty("cstms_decl_tp_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
		      SetColProperty("certi_seq_no", {AcceptKeys : "N"} );
            }


		break;
	//  SHEET to save
	case "sheet2":
	    with(sheetObj){        
		      var HeadTitle="|Save";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"save" } ];		       
		      InitColumns(cols);		
		      SetEditable(1);
		      SetVisible(false);
            }
		break;
	}
}
/**
 * initializing Combo Object 
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt=0;	
	switch(comboObj.options.id) {
	case "comboAuth":
		with (comboObj) {
		SetColAlign(0, "center");
		SetColAlign(1, "left");
		SetColWidth(0, "50");
		SetColWidth(1, "100");
			SetDropHeight(400);
//no support[check again]CLT 			ShowCol=0;
			SetTitle("Code|Description");
			SetMultiSelect(0);
			SetMaxSelect(1);
			InsertItem(cnt ++, "020|KRPUS", "020");
			InsertItem(cnt ++, "030|KRINC", "030");
			InsertItem(cnt ++, "622|KRKAN", "622");
			Code="020";
		}
		break;    	            
	case "comboIO":
		with (comboObj) {
		SetColAlign(0, "center");
		SetColAlign(1, "left");
		SetColWidth(0, "50");
		SetColWidth(1, "100");
			SetDropHeight(400);
//no support[check again]CLT 			ShowCol=0;
			SetTitle("Code|Description");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt ++, "01|입항", "01");
			InsertItem(cnt ++, "02|출항", "02");
			Code="02";
		}
		break;    	            
	case "comboDchgComCd":
		with (comboObj) {
		SetColAlign(0, "center");
		SetColAlign(1, "left");
		SetColWidth(0, "100");
		SetColWidth(1, "150");
			SetDropHeight(400);
//no support[check again]CLT 			ShowCol=0;
			SetTitle("Com Code|DSCH Com");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt ++, "BS-G-0010|㈜부산인터내셔널 터미널", "BS-G-0010");
			InsertItem(cnt ++, "BS-G-4122|㈜OPUS해운 신항만", "BS-G-4122");
			InsertItem(cnt ++, "YS-G-0006|㈜OPUS", "YS-G-0006");
			InsertItem(cnt ++, "IC-G-1048|㈜인천컨테이너터미날", "IC-G-1048");
			InsertItem(cnt ++, "PT-K-1107|㈜평택컨테이너터미날", "PT-K-1107");
			InsertItem(cnt ++, " | ", " ");
			Code=" ";
		}
		break;    	            
	}
}
/**
 * handling Auth  
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboAuth_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	var form=document.form;
	form.authority.value=document.form.comboAuth_text.value;
}
/**
 * handling IO 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboIO_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	var form=document.form;
	form.io.value=document.form.comboIO_text.value;
}
/**
 * handling Discharging Compnay Code  
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboDchgComCd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	var form=document.form;
	form.dchg_com_cd.value=NewCode;
	if (NewCode.length < 1) {
		form.dchg_com_cd.value=NewText;
	} else {
		form.dsch_com_nm.value=comboObj.GetText(NewCode, 1);
	}
}
//handling of Sheet 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //search
		if(validateForm(sheetObj,formObj,sAction)) {
			disableButtons();
			// initializing time and variable
			formObj.arv_tm.value="";
			formObj.io_tm.value="";
			formObj.send_tm.value="";
			formObj.to_tm.value="";
			formObj.from_tm.value="";
			formObj.max_vvd_seq.value="0";
			formObj.dgco_seq.value="0000";
			formObj.f_cmd.value=SEARCH;
			//sheetObj.RenderSheet(0);
//			sheetObj.SetWaitImageVisible(0);
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0212GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");			
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			// SORT
			sheetObjects[0].ColumnSort("4");
			// mapping the searching result 
			ComEtcDataToForm(formObj, sheetObj);
			if (formObj.current_check[1].checked && sheetObjects[0].GetEtcData("dgco_seq") != null) {
				formObj.dgco_seq.value=ComLpad(sheetObjects[0].GetEtcData("dgco_seq"),4,"0");
			} else {
				formObj.dgco_seq.value="0000";
			}
			//sheetObj.RenderSheet(1);
			// handling time and date 
			with(formObj) {
				if (arv_dt.value.length > 10) {
					arv_tm.value=arv_dt.value.substring(11,16);
					arv_dt.value=arv_dt.value.substring(0,10);
				}
				if (io_dt.value.length > 10) {
					io_tm.value=io_dt.value.substring(11,16);
					io_dt.value=io_dt.value.substring(0,10);
				}
				if (send_dt.value.length > 10) {
					send_tm.value=send_dt.value.substring(11,16);
					send_dt.value=send_dt.value.substring(0,10);
				}
				if (from_dt.value.length > 10) {
					from_tm.value=from_dt.value.substring(11,16);
					from_dt.value=from_dt.value.substring(0,10);
				}
				if (to_dt.value.length > 10) {
					to_tm.value=to_dt.value.substring(11,16);
					to_dt.value=to_dt.value.substring(0,10);
				}
			}
			// handling combo
			comboObjects[0].SetSelectCode(formObj.authority.value);
			comboObjects[1].SetSelectCode(formObj.io.value);
			if (comboObjects[2].FindItem(formObj.dchg_com_cd.value,0) < 0)
				comboObjects[2].InsertItem(-1, formObj.dchg_com_cd.value, formObj.dchg_com_cd.value);
			comboObjects[2].SetSelectCode(formObj.dchg_com_cd.value);
			changeTextToNumberFormat(formObj);
			// handling result of searching 
			if (formObj.mrn_no.value.length > 1) {
				ComBtnEnable("btn_Save");
				if (formObj.current_check[1].checked) {
					ComBtnEnable("btn_TransDGM");
					ComBtnEnable("btn_TransDGL");
				}
				sheetObj.CheckAll("Sel",1);
				document.getElementById("btn_SelectAll").innerHTML="Deselect All";
			}
			ComOpenWait(false);
		}	
		break;
	case IBSAVE:        //save
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			ComOpenWait(true);
			sheetObjects[1].RemoveAll();
			sheetObjects[1].DataInsert(-1);
			sheetObjects[1].SetRowStatus(1,"U");
			formObj.f_cmd.value=MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			var params=FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
			var sXml=sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
			changeTextToNumberFormat(formObj);
			// auto searching
			formObj.current_check[1].checked=true;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			ComOpenWait(false);
		}
		break;
	case MULTI01:        // Transmit DGN
		// Validation Check
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?
				ComOpenWait(true);
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowStatus(1,"U");
				formObj.f_cmd.value=MULTI;
				changeNumberToTextFormat(formObj);
				ComBtnDisable("btn_Save");
				var params=FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0212GS.do",  params);
				changeTextToNumberFormat(formObj);
				//  auto searching
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				// Transmit
				formObj.f_cmd.value=MULTI01;
				params=FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowStatus(1,"U");
				sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
				ComOpenWait(false);
			}
		}
		break;
	case MULTI02: 	// Transmit DGM
		// Validation Check
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){
				ComOpenWait(true);
				// 우선 SAVE
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowStatus(1,"U");
				formObj.f_cmd.value=MULTI;
				changeNumberToTextFormat(formObj);
				ComBtnDisable("btn_Save");
				var params=FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0212GS.do",  params);
				changeTextToNumberFormat(formObj);
				// Transmit
				formObj.f_cmd.value=MULTI02;
				params=FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, false, "Sel"), "sheet1_");
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowStatus(1,"U");
				sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
				ComOpenWait(false);
				//  auto searching
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
		break;
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			if (pol_cd.value.length + pod_cd.value.length < 5) {
				ComShowCodeMessage("BKG00214");
				return false;
			}
			if (pod_cd.value.length > 1 && pol_cd.value.length > 1) {
				ComShowCodeMessage("BKG00231");
				return false;
			}
			break;
		case IBSAVE:
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			if (pol_cd.value.length + pod_cd.value.length < 5) {
				ComShowCodeMessage("BKG00214");
				return false;
			}
			if (pod_cd.value.length > 1 && pol_cd.value.length > 1) {
				ComShowCodeMessage("BKG00231");
				return false;
			}
			break;
		case MULTI02:
			var gridChecked=false;
			// Grid Check 
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "Sel")==1) {
					gridChecked=true;
					break;
				}
			}
			if (gridChecked==false) {
				ComShowCodeMessage("BKG00775");
				return false;
			}
			if (pod_cd.value.length < 1 && pol_cd.value.length > 1) {
				var certiCheck=false;
				for(var i=1; i <= sheetObj.RowCount(); i++) {
					if (sheetObj.GetCellValue(i, "Sel")==1 && sheetObj.GetCellValue(i, "certi_seq_no").length < 1) {
						certiCheck=true;
						break;
					}
				}	
				if (certiCheck) {
					ComShowCodeMessage("COM12114", "Certi Seq");
					sheetObj.CheckAll(1,0);
					return false;
				}
			}
			break;
		}
	}
	return true;
}
/**
 * adding comma and  number form 
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.total_cntr.value=ComGetMaskedValue(formObj.total_cntr.value, 	"int");
	formObj.total_wgt.value=ComGetMaskedValue(formObj.total_wgt.value, 	"float");
}
/**
 * deleting comma and  number form
 * @param formObj
 * @return
 */
function changeNumberToTextFormat(formObj) {
	formObj.total_cntr.value=ComGetUnMaskedValue(formObj.total_cntr.value, "int");
	formObj.total_wgt.value=ComGetUnMaskedValue(formObj.total_wgt.value, 	"float");
}
