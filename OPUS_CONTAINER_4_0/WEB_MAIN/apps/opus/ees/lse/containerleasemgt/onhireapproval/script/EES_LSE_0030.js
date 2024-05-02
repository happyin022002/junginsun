/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0030.js
*@FileTitle  : On Hire Approval Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/ 
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
          MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
          OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_lse_0030 : business script for ees_lse_0030
 */
/* developer job */
// common global variables
var vOrcCntrTpszCd="";
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0; 
//var arrTpSz=new Array("d2","d4","d5","d7","r2","r5","r9","o2","s2","o4","o5","s4","f2","a2","f4","a4","f5","p2","p4","t2","t4","d3","dx","r4","d9","r8","c2");
var arrTpSz=new Array();
var arrTpSz2=new Array();
var arrTpSz3=new Array();

var curRow=0;
var addColCnt=0;
var deleteChk ="";
//Event handler processing by button click event */
document.onclick=processButtonClick;     
//Event handler processing by button name */ 
function processButtonClick(){ 
	/**********/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj= ComGetEvent();
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "Retrieve":
			ComOpenWait(true);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			ComOpenWait(false);
			break;
		case "btns_calendar1": // Pick Up Period (FromTo)
			if ( srcObj.style.filter == "" ) {
				if ( formObject.pkup_fm_dt.className == "input2" ) {
					var cal=new ComCalendar();
					cal.setEndFunction('setDuration');
	                cal.select(formObject.pkup_due_dt, 'yyyy-MM-dd');
				} else {
					var cal=new ComCalendarFromTo();
					ComSetObjValue(formObject.f_cmd, "0");
					cal.setEndFunction('setDuration');
					cal.select(formObject.pkup_fm_dt, formObject.pkup_due_dt, 'yyyy-MM-dd');
				}
			}
			break;
		case "New":
			var sheetCount=sheetObjects[0].RowCount();
			var editCount=0;
			
			if (sheetCount > 0 ){
				for (i=0 ; i <= sheetCount+1 ; i++){
					if (sheetObject.GetRowStatus(i) == 'I' || sheetObject.GetRowStatus(i) == 'U' || sheetObject.GetRowStatus(i) == 'D'){
						editCount ++;
					}
				}
			}
			if (editCount > 0 ){
				//ComShowCodeMessage("LSE01156");
				var rerunflg = ComShowConfirm(ComGetMsg("LSE01156"));
				
				if(rerunflg == false){
					set_new();
				} else {
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				}
				
			}else {
				set_new();
			}
			
			sheetObjects[0].SetColHidden("return_lcc", 1);
			document.form.cntr_onh_auth_no.disabled = false;
			comboObjects[0].SetSelectText("");
			comboObjects[0].SetEnable(1);
			break;
		case "Row_Add":
			if(ComIsBtnEnable("Row_Add")){
				var row=sheetObject.DataInsert();
				sheetObject.SetCellValue(row ,"agmt_cty_cd","HHO");
				sheetObject.SetCellEditable(row ,"agmt_cty_cd",0);
				sheetObject.SetCellEditable(row ,"ref_no",0);
				sheetObject.SetCellEditable(row ,"lstm_cd",0);
				sheetObject.SetCellEditable(row ,"lstm",0);
				sheetObject.SetCellEditable(row ,"div_total",0);
			}
			break;
		case "Delete":		
			if(ComIsBtnEnable("Delete")){		
				if(sheetObject.FindCheckedRow("chk")==""){
					ComShowCodeMessage("LSE01045");
				} else if(ComShowCodeConfirm("LSE01158")){ 
					for(var i=sheetObject.RowCount()+ 1 ; i > 1; i--){
						if(sheetObject.GetCellValue(i,1) == "1"){
								sheetObject.RowDelete(i);
						}
					}					
				}
			}
			break;
		case "Cancel":
			if(ComIsBtnEnable("Cancel")){
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE );
			}		
			break;
		case "Save":
			if(ComIsBtnEnable("Save")){
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			}
			break;
		case "btns_search1":    // onh_loc_cd Pop-up
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
		break;
		case "chk_cntr_tpsz_cd":
			if ( srcObj.checked ) {
				comboObjects[1].SetSelectCode(vOrcCntrTpszCd.replaceStr("|", ","));
			} else {
				comboObjects[1].SetSelectCode("");
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
function sheet1_OnLoadFinish() {
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	//sheetObjects[0] = sheetObjects[0].Reset();
	initSheet(sheetObjects[0],1);
	var ts_old = "";
	var ts_lon = "";
	var ts_new = "";
	for(var i=0; i < arrTpSz.length; i++){
			ts_old = arrTpSz[i]+"_old";
			ts_lon = arrTpSz[i]+"_lon";
			ts_new = arrTpSz[i]+"_new";	
		sheetObjects[0].SetColHidden(ts_old.toLowerCase(),true);
		sheetObjects[0].SetColHidden(ts_lon.toLowerCase(),true);
		sheetObjects[0].SetColHidden(ts_new.toLowerCase(),true);
		
		//sheetObjects[0].SetColHidden(arrTpSz3[i],true);
	}
	
//	this.title_color();
//no support[implemented common]CLT 	sheetObjects[0].ScrollBar=3;
	document.form.loc_cd.focus();
}


function loadPage (){
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	/* Axon Control Setting*/
	initControl();
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	var objs=document.all.item("tabLayer");
	objs.style.display="Inline";
	//control disable
	ComEnableObject(document.form.pkup_fm_dt, true);
	ComEnableObject(document.form.pkup_due_dt, true);
	ComEnableObject(document.form.btns_calendar1, true);
	comboObjects[1].SetEnable(0);
	ComEnableObject(document.form.remarks, false);
	ComBtnDisable("Row_Add");
	ComBtnDisable("Delete");
	ComBtnDisable("Save");
	ComBtnDisable("Cancel");
	sheet1_OnLoadFinish();
}


function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj);     
//	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
//	axon_event.addListenerFormat('keypress','obj_keypress', formObj); 	
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
	switch(sheetNo) {
	case 1:      //t1sheet1 init
	with (sheetObj) {
	    var HeadTitleTemp="";
	    var HeadTitle2Temp="";
	    var HeadUpperTitle="";
	    for(var i=0; i<arrTpSz.length; i++){
	    	HeadUpperTitle = arrTpSz[i].toUpperCase();
	    	HeadTitleTemp=HeadTitleTemp  + "|" + HeadUpperTitle + "|" + HeadUpperTitle + "|" + HeadUpperTitle;
	    	if(form.type_chk[1].checked == true) { 
	    		HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|Qty";
	    	} else {
	    		HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|New";
	    	}
	    }
	    var HeadTitle="sta| |AGMT No.|AGMT No.||Ref No.|Expected Return LOC|Lease\nTerm |Lessor ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|DIV Total" + HeadTitleTemp +  "|loc_cd|pkup_fm_dt|pkup_due_dt|apro_rmk||";
	    var HeadTitle2="sta| |AGMT No.|AGMT No.||Ref No.|Expected Return LOC|Lease\nTerm |Lessor ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|Old / New " + HeadTitle2Temp + "|loc_cd|pkup_fm_dt|pkup_due_dt|apro_rmk||"  ;
	    var headCount=ComCountHeadTitle(HeadTitle);
	    //(headCount, 0, 0, true);

	    SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:0 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	    InitHeaders(headers, info);

	    var cols = [ {Type:"Status",    Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                 {Type:"CheckBox",  Hidden:0, Width:20,    Align:"Center",  ColMerge:1,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	                 {Type:"PopupEdit", Hidden:0, Width:70,    Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"arr_cntr_tpsz_cd"},
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:1,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"return_lcc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   },
	                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"mft_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                 {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"free_dys",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pkup_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"pkup_chg_cr_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                 {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"div_total",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

	          for(var i=0; i<arrTpSz.length; i++){
		          cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_old", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		          cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_lon", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		          cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_new", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
	          }
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_onh_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_pkup_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_pkup_due_dt",    KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_apro_rmk",       KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt" });
		      cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt" });
		       
	    InitColumns(cols);

	    SetEditable(1);
		SetColProperty(0 ,"agmt_seq" , {AcceptKeys:"N"});
		SetColProperty(0 ,"mft_yr" , {AcceptKeys:"N"});
		SetColProperty(0 ,"return_lcc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	    SetMergeCell(0, 2, 2, 2);
	    SetShowButtonImage(1);
	    resizeSheet();
	    SetSheetWidth(1000);
	}
	break;
	}
}



// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction,Row) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:      //retrieve
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(1);
		ComOpenWait(true);
		setTimeout( function () {
		sheetObj.DoSearch("EES_LSE_0030GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		} , 100);
		
		
	}
	
	break;
	case IBSAVE:       
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value=MULTI;
			var sParam=sheetObj.GetSaveString(true);
			sParam += "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("EES_LSE_0030GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
		}
	}
	break;
	case IBCREATE:
		var usr_ofc_cd = formObj.usr_ofc_cd.value;
		var ofc_type = usr_ofc_cd.substring(3,5);
		
		if(ofc_type == 'HQ'){
			comboObjects[0].RemoveAll();
			comboObjects[0].InsertItem('MI', 'MI');
		} else {
			comboObjects[0].RemoveAll();
			comboObjects[0].InsertItem('OL', 'OL');
			comboObjects[0].InsertItem('LT', 'LT');
			comboObjects[0].InsertItem('ST', 'ST');
			comboObjects[0].InsertItem('OF', 'OF');
			comboObjects[0].InsertItem('SI', 'SI');
			comboObjects[0].InsertItem('MI', 'MI');
		}
		
		sheetObj.SetColHidden("return_lcc", 1);
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj),{Sync:1});
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
			
			formObj.tysz.value=vOrcCntrTpszCd;		
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
			var j=0;
			for(var i=0 ; i <  arrTpSz2.length ; i++){
				arrTpSz3[j]=arrTpSz2[i] + "_old";				
				j++;
				arrTpSz3[j]=arrTpSz2[i] + "_lon";
				j++;
				arrTpSz3[j]=arrTpSz2[i] + "_new";
				j++;
			}
		}
		break;
	/*case IBSEARCH_ASYNC05:
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj),{Sync:1});
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			LseComXml2ComboItem(sXml2, comboObjects[2], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
				
			arrTpSz = vOrcCntrTpszCd.replaceStr("|", ",");
			
			arrTpSz = arrTpSz.toLowerCase();
			arrTpSz= new Array(arrTpSz);
		}
		break;*/
	/*case IBCREATE1:
		
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj),{Sync:1});
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			LseComXml2ComboItem(sXml2, comboObjects[2], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
				
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			
		}
		break;*/
	case IBSEARCH_ASYNC01:      //auth_no list retrieve
		if(validateForm(sheetObj,formObj,sAction)) {
			var vAuthNo =formObj.cntr_onh_auth_no.value;	
			var vCombo1=ComGetObjValue(comboObjects[0]);
			if(vCombo1 == null || vCombo1 == "") {
				vCombo1 = formObj.combo1_text.value;
			}
			if(vAuthNo != null && vAuthNo != "" ){
				formObj.f_cmd.value=SEARCH01;
				combo1.value=comboObjects[0].GetSelectText();
				
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_0031GS.do", FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);
				if ( vCombo1 != "" ) {
					if(ComGetEtcData(sXml, "lstm_cd") != vCombo1){
						ComShowCodeMessage("LSE10033");
						formObj.cntr_onh_auth_no.value="";
					}
					
				}
			}
		}
	break;
	case IBSEARCH_ASYNC02:      //retrieve
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);
			if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
				if(curRow != 0){
					sheetObj.SetCellValue(curRow , "lstm",ComGetEtcData(sXml, "lstm_cd"));
					sheetObj.SetCellValue(curRow , "lstm_cd",ComGetEtcData(sXml, "vndr_abbr_nm"));
					sheetObj.SetCellValue(curRow , "free_dys",ComGetEtcData(sXml, "lse_free_dys"));
					sheetObj.SetCellValue(curRow , "ref_no",ComGetEtcData(sXml, "ref_no"));
					sheetObj.SetCellValue(curRow , "eff_dt",ComGetEtcData(sXml, "eff_dt"));
					sheetObj.SetCellValue(curRow , "exp_dt",ComGetEtcData(sXml, "exp_dt"));
					curRow=0;
				}
			} else {
				var errMsg=LseComGetErrMsg(sXml);
				if ( errMsg != "" ) {
					ComShowMessage(errMsg);
				}
				if(curRow != 0){
					sheetObj.SetCellValue(curRow , "agmt_seq","",0);
					sheetObj.SetCellValue(curRow , "lstm","",0);
					sheetObj.SetCellValue(curRow , "lstm_cd","",0);
					sheetObj.SetCellValue(curRow , "free_dys","",0);
					sheetObj.SetCellValue(curRow , "ref_no","",0);
					sheetObj.SetCellValue(curRow , "eff_dt","",0);
					sheetObj.SetCellValue(curRow , "exp_dt","",0);
					sheetObj.SelectCell(curRow , "agmt_seq" , false);
					curRow=0;
				}
			}
		}
	}
	break;
	case IBSEARCH_ASYNC03:  // Location retrieve
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH05;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "lcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "lcc_cd") != "" ) {
						//formObj.loc_cd.value = vLocCd;
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value="";
					}
				} else {
					var errMsg=LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.loc_cd.value="";
					ComSetFocus(formObj.loc_cd);
				}
			}
		}
	}
	break;
	case IBDELETE:  // Cancel 
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value=REMOVE;
	     ComOpenWait(true);
	     setTimeout( function () {
    //		sheetObj.DoSearch("EES_LSE_0030GS.do",FormQueryString(formObj));
            var sParam=sheetObj.GetSaveString(true);
            sParam += "&" + FormQueryString(formObj);
            deleteChk ="Y";
            var sXml=sheetObj.GetSaveData("EES_LSE_0030GS.do", sParam);
            sheetObj.LoadSaveData(sXml);
            
            if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ){
            	ComShowCodeMessage("LSE01134", "Delete");
            	sheetObjects[0].RemoveAll();
            }
            ComOpenWait(false);
	     } , 100);
	}
	break;
	

	case IBSEARCH_ASYNC04:
		sheetObj.SetWaitImageVisible(0);
	    ComOpenWait(true);			
		formObj.f_cmd.value=SEARCH01;			
		var xml="";
		xml=sheetObj.GetSearchData("EES_LSE_0029GS.do", FormQueryString(formObj),{Sync:1});
		sheetObj.SetCellValue(Row , "arr_cntr_tpsz_cd",ComGetEtcData(xml, "cntr_tpsz_cd"),0);
		ComOpenWait(false);
	break;
	
	}
}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSAVE:     
			if ( formObj.pkup_fm_dt.value == "" && formObj.pkup_due_dt.value == "" ) {
				ComShowCodeMessage("LSE01049");
				ComSetFocus(formObj.pkup_fm_dt);
				return false;
				break;
			}
			if ( formObj.tpsz_cd.value == "" ) {
				ComShowCodeMessage("LSE01015");
				ComSetFocus(comboObjects[1]);
				return false;
				break;
			}
			if (sheetObj.RowCount()==0) {
				ComShowCodeMessage("LSE10022");
				return false;
				break;			
			}
			var oldValue="";
			var newValue="";
			var strEffDateSdt = "";
			var strEffDateEdt = "";
			var strPickUpDueDate = "";
			strPickUpDueDate = formObj.pkup_due_dt.value;
			strPickUpDueDate = ComReplaceStr(strPickUpDueDate,"-","");
			
			var objstCd = comboObjects[0].GetSelectText();  
			
			for(var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
				if(sheetObj.GetCellValue( i , "return_lcc" ) == "" && form.type_chk[1].checked == true) {
					ComShowCodeMessage("LSE10013","Expected Return LCC");
					sheetObj.SelectCell( i , "return_lcc" );
					return false;
				}
				
				if(objstCd == "LT" || objstCd == "ST" || objstCd == "SI" || objstCd == "OF") {
					formObj.f_cmd.value=SEARCH23;
					sheetObj.SetWaitImageVisible(0);
					var str_agmt_seq = sheetObj.GetCellValue( i , "agmt_seq" );	
					var chk_date = formObj.pkup_due_dt.value;
					
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
					sheetObj.SetWaitImageVisible(1);

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
							if(ComGetEtcData(sXml, "check_date_yn") == "N") {
								ComShowCodeMessage("LSE10017");
								return false;
							}
						} 
					}
				}
			}
			
			oldValue="";
			newValue="";
			var iOldValue=0;
			var iNewValue=0;
			var strTpSzOldName="";
			var strTpSzNewName="";
			
			if( sheetObj.RowCount()== 1){
				for(var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
					for(var j=12 ; j <= arrTpSz3.length + 11 ; j++){
						 if(sheetObj.GetCellValue( 1 , j ) == "Old" ){
						     if(sheetObj.GetColHidden(j) == false){
							     oldValue=sheetObj.GetCellValue( i , j );
							     newValue=sheetObj.GetCellValue( i , j + 2);
							     if( ( oldValue == "" || oldValue <= 0 ) && ( newValue == "" || newValue <= 0 ) ){
							    	 ComShowCodeMessage("LSE01014");
							         sheetObj.SelectCell( i , j );
							         return false;
							     }
							 }
						 }
					}
				}
			}else{
			    for(var i=0 ; i < arrTpSz2.length ; i++){
				    if( sheetObjects[0].GetColHidden(arrTpSz2[i] + "_old") == false ){
					    for(var j=2 ; j <= sheetObj.RowCount()+ 1 ; j++){
						    strTpSzOldName=arrTpSz2[i] + "_old";
						    oldValue=sheetObj.GetCellValue( j , strTpSzOldName);
						    strTpSzNewName=arrTpSz2[i] + "_new";
						    newValue=sheetObj.GetCellValue( j , strTpSzNewName);
					        iOldValue=iOldValue + Number(oldValue);
					        iNewValue=iNewValue + Number(newValue);
					    }
					    if((iOldValue + iNewValue ) <= 0 ){						
						    ComShowCodeMessage("LSE01014");
						    sheetObj.SelectCell( 2 , strTpSzOldName );
						    return false;
					    }
					    iOldValue=0;
					    iNewValue=0;
				    }
			    }			
			}
			break;
			case IBSEARCH:      //retrieve
			
			if (formObj.cntr_onh_auth_no.value  == "" ) {
				ComShowCodeMessage("LSE01050");
				ComSetFocus(formObj.cntr_onh_auth_no);
				return false;
			} else {
				formObj.f_cmd.value=SEARCH01;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_0031GS.do", FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);

				if ( ComGetEtcData(sXml, "cntr_onh_auth_no") == undefined ) {
					ComShowCodeMessage("LSE01047");
					formObj.cntr_onh_auth_no.value = "";
					return false;
				} 
				
			}
			
			break;
			case IBDELETE:      //Cancel
			if ( formObj.cntr_onh_auth_no.value == "" ) {
				ComShowCodeMessage("LSE01050");
				ComSetFocus(formObj.cntr_onh_auth_no);
			}
			if(sheetObj.RowCount()<= 0){
				ComShowCodeMessage("LSE01048");
			}
			
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_0031GS.do", FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);

			if ( ComGetEtcData(sXml, "cntr_onh_auth_no") == undefined ) {
				ComShowCodeMessage("LSE01047");
				formObj.cntr_onh_auth_no.value = "";
				return false;
			} 
			
			break;
			// Auth No.를 입력했을 때 Type과 Lease Term이 맞지 않는 경우 메세지창을 보여준다.
			case IBSEARCH_ASYNC01:
				if(formObj.cntr_onh_auth_no.value.length == 20) {
					if (formObj.cntr_onh_auth_no.value.substring(9,11) == "MO" || formObj.cntr_onh_auth_no.value.substring(9,11) == "SO") {
						if(formObj.type_chk.value != "L") {
							ComShowCodeMessage("LSE10031");
							formObj.cntr_onh_auth_no.value="";
						}
					} else {
						if(formObj.type_chk.value != "O") {
							ComShowCodeMessage("LSE10031");
							formObj.cntr_onh_auth_no.value="";
						}
					}
				} else {
					if (formObj.cntr_onh_auth_no.value.substring(3,5) == "MO" || formObj.cntr_onh_auth_no.value.substring(3,5) == "SO") {
						if(formObj.type_chk.value != "L") {
							ComShowCodeMessage("LSE10031");
							formObj.cntr_onh_auth_no.value="";
						}
					} else {
						if(formObj.type_chk.value != "O") {
							ComShowCodeMessage("LSE10031");
							formObj.cntr_onh_auth_no.value="";
						}
					}
				}
			break;
			}
		}
	}
	return true;
}
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
	case "combo1":
		with(comboObj) {
			//BackColor = "cyan";
			SetDropHeight(150);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "combo2":
		with(comboObj) {
			//BackColor = "cyan";
			SetDropHeight(150);
			SetMultiSelect(1);
			SetMultiSeparator(",");  // add 
			SetMaxSelect(30);
		}
		break;
	}
}
function openPopup(type, Row, Col) {
	var formObj=document.form;
	if ( type == "1" ) {
		var sUrl='/opuscntr/COM_ENS_051.do';
		var iWidth=770;
		var iHeight=480;
		var sTargetObjList="loc_cd:loc_cd";
		var sDisplay="1,0,1,1,1,1,1,1";
		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	}else if ( type == "2"){
		//ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
		ComOpenPopup("/opuscntr/EES_LSE_0091.do", 805, 480, "setPopData_Agreement",  '1,0', false, false, Row, Col, 0);
	}		
}
/**
 * Agreement Pop-up Return Value handling<br>
 * @param {arry} returnedValues Pop-up page Return value array
 * @param Row Row index
 * @param Col  Col index
 * @param IBSheet Sheet Array index
 */
function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
	if(aryPopupData.length > 0) {
		with(sheetObjects[sheetIdx]) {			
			SetCellValue(Row, "agmt_seq",Number(aryPopupData[0][5]));
			SetCellValue(Row, "ref_no",aryPopupData[0][6]);
			
			SetCellValue(Row, "eff_dt",aryPopupData[0][10]);
			SetCellValue(Row, "exp_dt",aryPopupData[0][11]);
		}
	}
}
/**
* combo item change <br>
* @param type
* @param object  Object
* @param Row Row index
*/
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

//function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
//}

function combo2_OnCheckClick(Index, Code, Checked) {
	  if(sheetObjects[0].GetCellValue(2 , "arr_cntr_tpsz_cd") != ""){
			if(checkingAgmtTpsz(sheetObjects[0], document.form, "", "A") == false) {
				ComShowCodeMessage("LSE01159");
				combo2.SetItemCheck(Code,0);
				return false;
			} 
		}
	  
	  var tpSz = combo2.GetSelectText();
	  document.form.tpsz_cd.value = tpSz;
}


function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	
	var strTpszCd=newCode.replaceStr("|", ",").split(",");
	var sTpSz=document.form.tpsz_cd.value;
	var strTypeChk = document.form.type_chk.value;
	sheetObjects[0].RenderSheet(0);
	for(var i=0; i<arrTpSz.length; i++){
		if(sTpSz.indexOf(arrTpSz[i])>= 0) {
			if(strTypeChk == "O") {
				sheetObjects[0].SetColHidden(arrTpSz2[i] + "_old",0);
			}else{
				sheetObjects[0].SetColHidden(arrTpSz2[i] + "_old",1);
			}
			sheetObjects[0].SetColHidden(arrTpSz2[i] + "_new",0);
			sheetObjects[0].SetColHidden(arrTpSz2[i] + "_lon",0);
		} else {
			sheetObjects[0].SetColHidden(arrTpSz2[i]+ "_old",1);
			sheetObjects[0].SetColHidden(arrTpSz2[i]+ "_new",1);
			sheetObjects[0].SetColHidden(arrTpSz2[i]+ "_lon",1);
			for(var j=2; j <= sheetObjects[0].RowCount()+ 1; j++){
				sheetObjects[0].SetCellValue(j , arrTpSz2[i]+ "_old" ,"");
				sheetObjects[0].SetCellValue(j , arrTpSz2[i]+ "_new" ,"");
				sheetObjects[0].SetCellValue(j , arrTpSz2[i]+ "_lon" ,"");
			}
		}
	}
	sheetObjects[0].RenderSheet(1);
	
	var addCnt=strTpszCd.length;
	var addSize=0;
	if(document.form.tpsz_cd.value != ""){
		if(addCnt > 1){
			var addSize=Number(addCnt) * 150 ;
			if( 830 + addSize > 984){
				sheetObjects[0].SetSheetWidth(830 + addSize);
			}else{
				sheetObjects[0].SetSheetWidth(984);
			}
		}else{
			sheetObjects[0].SetSheetWidth(984);
		}
	}else{
		sheetObjects[0].SetSheetWidth(984);
	}
}


function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "cntr_onh_auth_no":
			ComChkObjValid(obj);
//			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			var strAuthNo = formObj.cntr_onh_auth_no.value;
			var lstmCdVal = comboObjects[0].GetSelectText();
			if(strAuthNo.length != ""){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			}
			break;
			
		case "type_chk":
			var strTypeChk = formObj.type_chk.value;
			var usr_ofc_cd = formObj.usr_ofc_cd.value;
			var ofc_type   = usr_ofc_cd.substring(3,5);
			formObj.loc_cd.value = "";
			formObj.pkup_fm_dt.value = "";
			formObj.pkup_due_dt.value = "";
			formObj.cntr_onh_auth_no.value = "";

			if(strTypeChk == 'O') {
				
				if(ofc_type == 'HQ'){
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('MI', 'MI');
				} else {
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('OL', 'OL');
					comboObjects[0].InsertItem('LT', 'LT');
					comboObjects[0].InsertItem('ST', 'ST');
					comboObjects[0].InsertItem('OF', 'OF');
					comboObjects[0].InsertItem('SI', 'SI');
					comboObjects[0].InsertItem('MI', 'MI');
				}
				sheetObj.SetColHidden("return_lcc", 1);
				sheetObj.SetColHidden("div_total", 0);
				for(var i=0 ; i < arrTpSz2.length ; i++){
					sheetObj.SetColHidden(arrTpSz2[i]+"_old", 0);
				}
				set_new();
			}else{
				if(ofc_type == "HQ"){
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('MO', 'MO');
				}else{
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('SO', 'SO');
					comboObjects[0].InsertItem('MO', 'MO');
				}
				
				sheetObj.SetColHidden("return_lcc", 0);
				sheetObj.SetColHidden("div_total", 1);
			}
			sheetObjects[0].RenderSheet(0);
			for(var i=0; i<arrTpSz3.length; i++){
				sheetObjects[0].SetColHidden(arrTpSz3[i],true);
			}
			sheetObjects[0].RenderSheet(1);
			for(var i=0 ; i < arrTpSz2.length ; i++){
				sheetObj.SetColHidden(arrTpSz2[i]+"_old", 1);
			}
			sheetObj.RemoveAll();
			sheetObj.RenderSheet(1);
			formObj.tpsz_cd.value = "";
			for(var i = 0; i < comboObjects[1].GetItemCount() ; i++){
				comboObjects[1].SetItemCheck(i, 0);
			}
			
			comboObjects[0].SetEnable(1);
			ComEnableObject(formObj.loc_cd, true);
			formObj.loc_cd.style.cssText="width:50px;text-align:center;";
			ComEnableObject(formObj.btns_search1, true);
			ComEnableObject(formObj.pkup_fm_dt, false);
			ComEnableObject(formObj.pkup_due_dt, false);
			ComEnableObject(formObj.btns_calendar1, false);
			formObj.pkup_fm_dt.style.cssText=" width:80px; background-color:#E8E7EC;text-align:center;";
			formObj.pkup_due_dt.style.cssText=" width:80px; background-color:#E8E7EC;text-align:center;";
			comboObjects[1].SetEnable(0);
			
			ComEnableObject(document.form.remarks, false);
			ComBtnDisable("Row_Add");
			ComBtnDisable("Delete");
			ComBtnDisable("Save");
			ComBtnDisable("Cancel");
			
			
			break;
		}
	}
}


function sheet1_OnChange(sheetObj,Row, Col, Value){
	var formObj=document.form;
	var sName=sheetObj.ColSaveName(Col);
	
	if(sheetObj.GetCellValue(Row,"return_lcc") != "" && sName == "return_lcc"){
		var param="f_cmd="  + SEARCH21
		 + "&eq_loc_tp_cd=LO"
		 + "&loc_cd=" + sheetObj.GetCellValue(Row,"return_lcc");
		
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S" ) {
				ComShowCodeMessage("LSE01037");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			} 
		}
	}
	
	if(Col == 2 || Col == 3){
		if( sheetObj.GetCellValue(Row , "agmt_cty_cd") != "" && sheetObj.GetCellValue(Row , "agmt_seq") != "" ){
			formObj.agmt_cty_cd.value=sheetObj.GetCellValue(Row , "agmt_cty_cd");
			formObj.agmt_seq.value=sheetObj.GetCellValue(Row , "agmt_seq");
			//AGMT NO dup check
			var agmtNo=sheetObj.GetCellValue(Row , 2) + sheetObj.GetCellValue(Row , 3);
			var inPutAgmtNo=""; 
			for(var i=2; i <= sheetObj.RowCount()+ 1 ; i++){
				if( i != Row){
					inPutAgmtNo=sheetObj.GetCellValue( i , 2) + sheetObj.GetCellValue(i , 3);
					if(agmtNo == inPutAgmtNo){
						ComShowCodeMessage("LSE01055");
						sheetObj.SetCellValue(Row , "agmt_seq","",0);
						sheetObj.SetCellValue(Row , "lstm","",0);
						sheetObj.SetCellValue(Row , "lstm_cd","",0);
						sheetObj.SetCellValue(Row , "ref_no","",0);
						sheetObj.SelectCell(Row , "agmt_seq" , false);
						return;
					}
				}
			}
			curRow=Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04, Row);			
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			checkingAgmtTpsz(sheetObj, formObj, Row);
			//ComBtnDisable("Save");
		}
	}
	var old_sum=0;
	var new_sum=0;
	var cValue=0;
	if( Col > 11 && Col <= (arrTpSz3.length + 12) ){
		for(var i=12 ; i <= (arrTpSz3.length + 12); i++ ){
			if(sheetObj.GetCellValue(1 , i) == "New"){
				cValue=sheetObj.GetCellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue=0 ;
				}
				new_sum=Number(new_sum) + Number(cValue);
			}
			else if( sheetObj.GetCellValue(1 , i) == "Old" ){
				cValue=sheetObj.GetCellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue=0 ;
				}
				old_sum=Number(old_sum) + Number(cValue);
			}
			
		}
		old_sum=add_comma(old_sum);
		new_sum=add_comma(new_sum);
		sheetObj.SetCellText(Row , "div_total" ,old_sum + " / " + new_sum );
	}
	if(Col == 9 || Col == 10){
		if(Number(Value) < 0){
			sheetObj.SetCellValue(Row , Col,Number(Value) * -1 ,0);
		}
	}
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if ( ErrMsg == "" ) {
		if(document.form.f_cmd.value == MULTI){
			ComShowCodeMessage("LSE10002");
		}
	}
	ComOpenWait(true);
	if(deleteChk == "") {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}else{
		deleteChk = "";
		set_new();
		
		sheetObjects[0].SetColHidden("return_lcc", 1);
		document.form.cntr_onh_auth_no.disabled = false;
		comboObjects[0].SetSelectText("");
		comboObjects[0].SetEnable(1);
		
	}
	ComOpenWait(false);		
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	var formObj=document.form;
	if(document.form.cntr_onh_auth_no.value != "" && sheetObj.RowCount()> 0) {
		var strTypeChk = formObj.type_chk.value;
		var formObject=document.form;
		var usr_ofc_cd = formObject.usr_ofc_cd.value;
		var ofc_type = usr_ofc_cd.substring(3,5);
		if(strTypeChk == 'O') {
			if(ofc_type == 'HQ' && sheetObj.GetCellValue(2 , "lstm") != "MI"){
				ComShowCodeMessage("LSE10034");
				document.form.cntr_onh_auth_no.value = "";
				sheetObj.RemoveAll();
				return false;
			}
		}else{
			if(ofc_type == 'HQ' && sheetObj.GetCellValue(2 , "lstm") != "MO"){
				ComShowCodeMessage("LSE10034");
				document.form.cntr_onh_auth_no.value = "";
				sheetObj.RemoveAll();
				return false;
			}
		}
	}
	
	initSheet(sheetObjects[0],1);
	//sheetObj.ReNumberSeq();
	if(sheetObj.RowCount()> 0){
		//Searching AGMT`s TP/SZ
		var lastRow=sheetObjects[0].LastRow();
		for(i=2 ; i <= lastRow ; i++){
		    sheetObj.SetWaitImageVisible(0); 
		    ComOpenWait(true);			
			formObj.f_cmd.value=SEARCH01;			
			var xml="";		
			document.form.agmt_cty_cd.value=sheetObj.GetCellValue(i , "agmt_cty_cd");
			document.form.agmt_seq.value=sheetObj.GetCellValue(i , "agmt_seq");
			xml=sheetObj.GetSearchData("EES_LSE_0029GS.do", FormQueryString(formObj),{Sync:1});
			sheetObj.SetCellValue(i , "arr_cntr_tpsz_cd",ComGetEtcData(xml, "cntr_tpsz_cd"),0);
			sheetObj.SetCellValue(i , "ibflag","",0);
			ComOpenWait(false);
		}
		if(sheetObj.GetCellText(2,"s_onh_loc_cd") != null && sheetObj.GetCellText(2,"s_onh_loc_cd") != ""){
			formObj.loc_cd.value=sheetObj.GetCellText(2,"s_onh_loc_cd");
		}else{
			formObj.loc_cd.value="";
		}
		if(sheetObj.GetCellText(2,"s_pkup_fm_dt") != null && sheetObj.GetCellText(2,"s_pkup_fm_dt") != ""){
			formObj.pkup_fm_dt.value=sheetObj.GetCellText(2,"s_pkup_fm_dt");
		}else{
			formObj.pkup_fm_dt.value="";
		}
		if(sheetObj.GetCellText(2,"s_pkup_due_dt") != null && sheetObj.GetCellText(2,"s_pkup_due_dt") != ""){
			formObj.pkup_due_dt.value=sheetObj.GetCellText(2,"s_pkup_due_dt");
		}else{
			formObj.pkup_due_dt.value="";
		}
		if(sheetObj.GetCellText(2,"s_apro_rmk") != null && sheetObj.GetCellText(2,"s_apro_rmk") != ""){
			formObj.remarks.value=sheetObj.GetCellText(2,"s_apro_rmk");
		}else{
			formObj.remarks.value="";   
		}
		var strTpszCd="";
		var strTxt="";
		var chkHidden=true;
		var strTypeChk = formObj.type_chk.value;
		for( var j=15 ; j <=  arrTpSz3.length + 14 ; j++){
			// TP/SZ 추가시 14 부분 수정 필요
			chkHidden=true;
			for( var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
				if( sheetObj.GetCellText(i,j) != "0" && sheetObj.GetCellText(i,j) != "0.00" && sheetObj.GetCellText(i,j) != "" && sheetObj.GetCellText(i,j) != null){
					chkHidden=false;
					strTxt=sheetObj.GetCellText(0,j);
					if(strTpszCd.indexOf(strTxt) < 0){
						strTpszCd=strTpszCd + "," + strTxt;
					}
				}
			}
			if(chkHidden == false){
				if(strTypeChk == "O") {
					if(sheetObj.GetCellText(1,j) == "New" ){
						sheetObj.SetColHidden(j,0);
						sheetObj.SetColHidden(j-1,0);
						sheetObj.SetColHidden(j-2,0);
					}else if(sheetObj.GetCellText(1,j) == "Old"){
						sheetObj.SetColHidden(j,0);
						sheetObj.SetColHidden(j+1,0);
						sheetObj.SetColHidden(j+2,0);
					}else if(sheetObj.GetCellText(1,j) == "H/On"){
						sheetObj.SetColHidden(j-1,0);
						sheetObj.SetColHidden(j,0);
						sheetObj.SetColHidden(j+1,0);
					}
				}
				// Type이 Lease Out일 때 Old 컬럼을 Hidden 처리
				else{
					if(sheetObj.GetCellText(1,j) == "Qty" ){
						sheetObj.SetColHidden(j,0);
						sheetObj.SetColHidden(j-1,0);
						sheetObj.SetColHidden(j-2,1);
					}else if(sheetObj.GetCellText(1,j) == "Old"){
						sheetObj.SetColHidden(j,1);
						sheetObj.SetColHidden(j+1,0);
						sheetObj.SetColHidden(j+2,0);
					}else if(sheetObj.GetCellText(1,j) == "H/On"){
						sheetObj.SetColHidden(j-1,1);
						sheetObj.SetColHidden(j,0);
						sheetObj.SetColHidden(j+1,0);
					}
				}
			}
		}
		
		formObj.tpsz_cd.value="";
		if(strTpszCd.length > 0){
			strTpszCd=strTpszCd.substr(1) ;
			formObj.tpsz_cd.value=strTpszCd;
			var arryTpszCd=strTpszCd.split(",");
			var addCnt=arryTpszCd.length;
			var addSize=0;
			if(document.form.tpsz_cd.value != ""){
				if(addCnt == 1){
					sheetObjects[0].SetSheetWidth(984);
				}else if(addCnt == 2){
					sheetObjects[0].SetSheetWidth(984+150);				
				}else if(addCnt > 2){	
					var addSize=Number(addCnt) * 150 ;
					if( 660 + addSize > 984){
						sheetObjects[0].SetSheetWidth(984);
					}else{
						sheetObjects[0].SetSheetWidth(775 + addSize);
					}
				}else{
					sheetObjects[0].SheetWidth(984);
				}
			}else{
				sheetObjects[0].SheetWidth(765);
			}
		}
		
//		combo1.SetSelectCode(-1, false);
		comboObjects[1].SetEnable(true);
		comboObjects[1].SetSelectCode(strTpszCd, true);
		ComEnableObject(formObj.loc_cd, false);
		ComEnableObject(formObj.btns_search1, false);
		ComEnableObject(formObj.pkup_fm_dt, true);
		ComEnableObject(formObj.pkup_due_dt, true);
		document.form.pkup_fm_dt.style.cssText="width:80px;";
		document.form.pkup_due_dt.style.cssText="width:80px;";
		ComEnableObject(formObj.btns_calendar1, true);
//		combo1.SetEnable(1);
		ComEnableObject(document.form.remarks, true);
		ComBtnEnable("Row_Add");
		ComBtnEnable("Delete");
		ComBtnEnable("Save");
		ComBtnEnable("Cancel");
	}
	if ( ErrMsg == "" ) {
		if(document.form.f_cmd.value == REMOVE){
			ComShowCodeMessage("LSE10003");
			set_new();
		}
		
		/* Mask add */
		ComAddSeparator(document.form.pkup_fm_dt, "ymd");
		ComAddSeparator(document.form.pkup_due_dt, "ymd");
		
	} else {
		ComShowMessage(ErrMsg);
	}
	
	if(document.form.cntr_onh_auth_no.value != "" && sheetObj.RowCount()> 0) {
		document.form.cntr_onh_auth_no.disabled = true;
		var cntrTpszCd= "";
		cntrTpszCd=sheetObj.GetCellValue(2 , "lstm");		
		comboObjects[0].SetSelectText(cntrTpszCd);
		comboObjects[0].SetEnable(0);
	}else{
		document.form.cntr_onh_auth_no.disabled = false;
		comboObjects[0].SetSelectText("");
		comboObjects[0].SetEnable(1);
	}
	
}
/**
* handling Location blur event
*/
function obj_blur(){
	var obj=ComGetEvent();
	var sheetObject=sheetObjects[0];	
	var formObject=document.form;
	switch(ComGetEvent("name")){
		case "pkup_due_dt":
			//checking number
			
			//ComChkObjValid(obj);
			if(sheetObject.RowCount()> 0){
			    var iPkupDueDt=formObject.pkup_due_dt.value;
			    iPkupDueDt=iPkupDueDt.replaceStr("-", "");
			    var oPkupDueDt=sheetObject.GetCellText(2,"s_pkup_due_dt");
			    oPkupDueDt=oPkupDueDt.replaceStr("-", "");
			    if(Number(oPkupDueDt) > Number(iPkupDueDt)){			    	
			    	ComShowCodeMessage("LSE01065");
			    	formObject.pkup_due_dt.value=sheetObject.GetCellText(2,"s_pkup_due_dt");
					return false;
					break;
			    }
			}
			break;
		default:
			//checking Validation
		break;
	}
}

/**
 * cntr_onh_auth_no_OnKeyDown
*/
function cntr_onh_auth_no_OnKeyDown(comboObj, KeyCode, Shift) {	  
    with(comboObj) {
 	    if ( KeyCode == 13 ){
 		    sheetObjects[0].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	    }
    }
}
 
/**
 * reset page
 */
function set_new(){
	var formObject=document.form;
	var usr_ofc_cd = formObject.usr_ofc_cd.value;
	var ofc_type = usr_ofc_cd.substring(3,5);
	formObject.loc_cd.value="";
	comboObjects[0].SetSelectText("");
	formObject.pkup_fm_dt.value="";
	formObject.pkup_due_dt.value="";
	formObject.cntr_onh_auth_no.value="";
	sheetObjects[0].RemoveAll();
	
	for(var i=0; i < comboObjects[1].GetItemCount() ; i++){
		comboObjects[1].SetItemCheck(i,0);
	}

	formObject.tpsz_cd.value="";
	sheetObjects[0].RenderSheet(0);
	for(var i=0; i<arrTpSz3.length; i++){
		sheetObjects[0].SetColHidden(arrTpSz3[i],true);
	}
	sheetObjects[0].RenderSheet(1);
	
	formObject.remarks.value="";
	comboObjects[0].SetEnable(1);
	ComEnableObject(formObject.loc_cd, true);
	formObject.loc_cd.style.cssText="width:50px;text-align:center;";
	ComEnableObject(formObject.btns_search1, true);
	ComEnableObject(formObject.pkup_fm_dt, false);
	ComEnableObject(formObject.pkup_due_dt, false);
	ComEnableObject(formObject.btns_calendar1, false);
	formObject.pkup_fm_dt.style.cssText=" width:80px; background-color:#E8E7EC;text-align:center;";
	formObject.pkup_due_dt.style.cssText=" width:80px; background-color:#E8E7EC;text-align:center;";
	comboObjects[1].SetEnable(0);
	
	ComEnableObject(document.form.remarks, false);
	ComBtnDisable("Row_Add");
	ComBtnDisable("Delete");
	ComBtnDisable("Save");
	ComBtnDisable("Cancel");
	formObject.loc_cd.focus();

	formObject.type_chk[0].checked = true;
	if(ofc_type == 'HQ'){
		comboObjects[0].RemoveAll();
		comboObjects[0].InsertItem('MI', 'MI');
	} else {
		comboObjects[0].RemoveAll();
		comboObjects[0].InsertItem('OL', 'OL');
		comboObjects[0].InsertItem('LT', 'LT');
		comboObjects[0].InsertItem('ST', 'ST');
		comboObjects[0].InsertItem('OF', 'OF');
		comboObjects[0].InsertItem('SI', 'SI');
		comboObjects[0].InsertItem('MI', 'MI');
	}
	
}
/**
 * Sheet의 OnPopuphandling event in case of Click.<br>
 * @param sheetObj
 * @param Row
 * @param Col
 */
function sheet1_OnPopupClick(sheetObj,Row,Col) {
	with(sheetObj) {
		var sName=ColSaveName(Col);
		switch(sName) {			
		case "agmt_seq":	//Agreement No Pop-up
			openPopup("2", Row, Col);
			break;		
		case "return_lcc":
			/* Delivery Location Pop-up */
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setLCCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, 0);
			break;
		}
	}
}
 /**
  * comma handling<br>
  * @param sheetObj
  * @param Row
  * @param Col
  */
function add_comma(strNum) {
    if (strNum.length < 1) {
	     return "0";
	 } else {
	     var tm=strNum + "";	     
	     var st="";
	     var cm=",";
	     for (var i=tm.length, j=0; i > 0; i--, j++) {
	         if ((j % 3) == 2) {
	            if(tm.length == j + 1){
	                st=tm.substring(i - 1, i) + st;
	            }else{
	                st=cm + tm.substring(i - 1, i) + st;
	            }
	         } else {
	            st=tm.substring(i - 1, i) + st;
	         }
	     }
	     return st;
    }
}  
function title_color(){
    for(var i=0; i<arrTpSz2.length; i++){			
	   //sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_old") =  "#C8D2E6";	
	   //sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_lon") =  "#C8D2E6";
	   sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_old","#B0C4DE");
       sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_lon","#B0C4DE");
       sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_old","#B0C4DE");
       sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_lon","#B0C4DE");
	}
} 
/* end of developer job */


/**
 * Checking AGMT TP/SZ<br>
 * @param sheetObj, formObj, Row, Div
 */
function checkingAgmtTpsz(sheetObj, formObj, Row, Div){
	 if(Div == "A"){
		 //Combo Tp/Sz
		 var cntrTpszCd1=comboObjects[1].GetSelectText()
		 var cbCntrTpszCd=cntrTpszCd1.replaceStr("|", ",").split(",");
		 for(i=0 ; i < cbCntrTpszCd.length ; i++){
			 for(j=2 ; j <= sheetObjects[0].LastRow(); j++){
				 var checkCnt=0;
				 var cntrTpszCd=sheetObjects[0].GetCellValue(j , "arr_cntr_tpsz_cd");
				 var agmtCntrTpszCd=cntrTpszCd.replaceStr("|", ",").split(",");
				 for(k=0 ; k < agmtCntrTpszCd.length ; k++){
					 if(cbCntrTpszCd[i] == agmtCntrTpszCd[k]){
						 checkCnt ++;
					 } 
				 }
				 if(checkCnt > 0 ){
					 continue;
				 } else {
					 return false;;
				 }
			 }
		 }
	 } else {
		 //AGMT No.Tp/Sz
		 var cntrTpszCd=sheetObjects[0].GetCellValue(Row , "arr_cntr_tpsz_cd");
		 var agmtCntrTpszCd=cntrTpszCd.replaceStr("|", ",").split(",");
		 //Combo Tp/Sz
		 var cntrTpszCd1=comboObjects[1].GetSelectText();
		 var cbCntrTpszCd=cntrTpszCd1.replaceStr("|", ",").split(",");
		 for(i=0 ; i < cbCntrTpszCd.length ; i++){
			 var checkCnt=0;
			 for(j=0 ; j < agmtCntrTpszCd.length ; j++){
				 if(cbCntrTpszCd[i] == agmtCntrTpszCd[j]){
					 checkCnt ++;
				 } 
			 }
			 if(checkCnt > 0 ){
				 continue;
			 } else {
				 ComShowCodeMessage("LSE01159");
				 sheetObj.SetCellValue(Row , "agmt_seq","",0);
				 sheetObj.SetCellValue(Row , "arr_cntr_tpsz_cd","",0);
				 sheetObj.SetCellValue(Row , "ref_no","",0);
				 sheetObj.SetCellValue(Row , "lstm","",0);
				 sheetObj.SetCellValue(Row , "lstm_cd","",0);
				 sheetObj.SetCellValue(Row , "free_dys","",0);
				 sheetObj.SetCellValue(Row , "eff_dt","",0);
				 sheetObj.SetCellValue(Row , "exp_dt","",0);
				 break;
			 }
		 }
	 }
}
/* end of developer job */

function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 120);
}


function setLCCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "return_lcc":					
					SetCellValue(Row,Col,aryPopupData[0][3],0);	
					break;
			}
		}
	}
}