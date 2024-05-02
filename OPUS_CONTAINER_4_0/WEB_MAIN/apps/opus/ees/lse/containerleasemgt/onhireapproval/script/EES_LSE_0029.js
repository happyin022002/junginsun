/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0029.js
*@FileTitle  : On Hire Approval creation	
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
          MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
          OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job */
// common global variables
var vOrcCntrTpszCd="";
var sheetObjects=new Array();
var sheetCnt=0;
// Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array();
var arrTpSz2=new Array();
var arrTpSz3=new Array();
var curRow=0;
var addColCnt=0; 
//Event handler processing by button click event */ 
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){ 
	/**********/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj=ComGetEvent();
		var srcName=ComGetEvent("name");
		switch(srcName) {
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
				var rerunflg =  ComShowConfirm(ComGetMsg("LSE01156"))
			    if (rerunflg == '0'){
			    	comboObjects[0].SetSelectText("");
                	formObject.loc_cd.value           = "";
        			formObject.pkup_fm_dt.value       = "";
        			formObject.pkup_due_dt.value      = "";
        			formObject.cntr_onh_auth_no.value = "";
        			sheetObject.RemoveAll();
        			
        			for(var i = 0; i < comboObjects[1].GetItemCount() ; i++){
        				comboObjects[1].SetItemCheck(i, 0);
        			}
        			formObject.tpsz_cd.value = "";
       				sheetObjects[0].RenderSheet(1);
        			formObject.apro_rmk.value = "";
        			ComBtnEnable("btn1_handleOnCharge");
                     }

			}else {
				formObject.loc_cd.value="";
				comboObjects[0].SetSelectText("");
				formObject.pkup_fm_dt.value       = "";
				formObject.pkup_due_dt.value      = "";
				formObject.cntr_onh_auth_no.value = "";
				
				sheetObject.RemoveAll();				
				for(var i=0; i < comboObjects[1].GetItemCount() ; i++){
					comboObjects[1].SetItemCheck(i,0);
				}
				formObject.tpsz_cd.value="";
				
				//sheetObjects[0].RenderSheet(0);
				//for(var i=0; i < arrTpSz3.length; i++){
				//	sheetObjects[0].SetColHidden(arrTpSz3[i],true);
				//}
				//sheetObjects[0].RenderSheet(1);
				
				formObject.apro_rmk.value="";
				ComBtnEnable("btn1_handleOnCharge");
			}
			
			formObject.type_chk[0].checked = true;
			comboObjects[0].RemoveAll();
			comboObjects[0].InsertItem('OL', 'OL');
			comboObjects[0].InsertItem('LT', 'LT');
			comboObjects[0].InsertItem('ST', 'ST');
			comboObjects[0].InsertItem('OF', 'OF');
			comboObjects[0].InsertItem('SI', 'SI');
			comboObjects[0].InsertItem('MI', 'MI');
			
			sheetObjects[0].SetColHidden("return_lcc", 1);
			break;
		case "Row_Add":
			var row=sheetObject.DataInsert();
			sheetObject.SetCellValue(row ,"agmt_cty_cd","HHO");
			sheetObject.SetCellEditable(row ,"agmt_cty_cd",0);
			sheetObject.SetCellEditable(row ,"lstm_cd",0);
			sheetObject.SetCellEditable(row ,"lstm",0);
			sheetObject.SetCellEditable(row ,"div_total",0);
			break;
		case "Delete":
			for(var i=sheetObject.RowCount()+ 1 ; i > 1; i--){
				if(sheetObject.GetCellValue(i,1) == "1"){
					var retVal = confirm("Do you realy want to delete ?");
					if(retVal == true){
						sheetObject.RowDelete(i);
					}
				}
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
		case "btn1_handleOnCharge":    // 
		if ( srcObj.style.filter == "" ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		break;
		case "chk_cntr_tpsz_cd":
			/* clicking in case of clicking TP/SZ */
			if ( srcObj.checked ) {
				comboObjects[1].SetSelectCode(vOrcCntrTpszCd.replaceStr("|", ","));
			} else {
				comboObjects[1].SetSelectCode("");
			}
			break;
		case "btns_calendar1":		// Pick Up Period (FromTo)
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

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);		 
		//sheetObjects[i].Visible = true;
		//sheetObjects[i].ExtendLastCol = true;
	}
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	/* Axon Control Setting*/
	initControl();
	var objs=document.all.item("tabLayer");
	objs.style.display="";
	sheet1_OnLoadFinish();
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj);     
//	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
//	axon_event.addListenerFormat('keypress','obj_keypress', formObj); 
	axon_event.addListenerFormat('blur',  'obj_blur',   formObj);     
//	axon_event.addListenerFormat('focus', 'obj_focus',  formObj);     
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function sheet1_OnLoadFinish(){
	 /* IBMulti Combo Item Setting */
    ComBtnDisable("Save");
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	
	sheetObjects[0] = sheetObjects[0].Reset();
	initSheet(sheetObjects[0],1);
	sheetObjects[0].RenderSheet(0);
	for(var i=0; i < arrTpSz3.length; i++){
		sheetObjects[0].SetColHidden(arrTpSz3[i],true);
	}	
	sheetObjects[0].RenderSheet(1);
    this.title_color();
    //no support[implemented common]CLT sheetObjects[0].ScrollBar=3;
    document.form.loc_cd.focus();
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
	    var HeadTitleTemp = "";
	    var HeadTitle2Temp= "";
	    for(var i=0; i<arrTpSz.length; i++){
		    	 HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i]+ "|" + arrTpSz[i] + "|" + arrTpSz[i];
		    	 if(form.type_chk[1].checked == true) {
		    		 HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|Qty";
		    	 }else{
		    		 HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|New";
		    	 }
		    	
	    }
	    var HeadTitle="sta| |AGMT No.|AGMT No.||Ref No.|Expected Return LOC|Lease\nTerm |Lessor ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|DIV Total" + HeadTitleTemp+"||";
	    var HeadTitle2="sta| |AGMT No.|AGMT No.||Ref No.|Expected Return LOC|Lease\nTerm |Lessor ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|Old / New" + HeadTitle2Temp+"||";
	    var headCount=ComCountHeadTitle(HeadTitle);
	    //(headCount, 0, 0, true);

	    SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    var headers = [ { Text:HeadTitle, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	    InitHeaders(headers, info);

	    var cols = [ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"N" },
	                 {Type:"PopupEdit", Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"arr_cntr_tpsz_cd" },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   },
	                 {Type:"PopupEdit", Hidden:1,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"return_lcc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mft_yr",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             	 {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"free_dys",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             	 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pkup_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	             	 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"pkup_chg_cr_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	             	 {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             	 {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"div_total",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       for(var i=0; i<arrTpSz2.length; i++){
			    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"_old", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
			    cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"_lon", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
			    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"_new", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	    }
	       cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt" });
	       cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt" });
	    InitColumns(cols);

		SetEditable(1);
		SetColProperty(0 ,"agmt_seq" , {AcceptKeys:"N"});
		SetColProperty(0 ,"mft_yr" , {AcceptKeys:"N"});
		SetColProperty(0 ,"return_lcc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//		sheetObj.SetCellBackColor(0, "div_total","#B0C4DE");
		SetMergeCell(0, 2, 2, 2);
	    SetShowButtonImage(1);
	    FrozenCols=7;
	    //SetSheetHeight(200);
	    ComResizeSheet(sheetObj, 120);
	    SetSheetWidth(1000);
	}
	break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction, Row) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSAVE:
	if(validateForm(sheetObj,formObj,sAction)) { 
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value=MULTI;
			var sParam=sheetObj.GetSaveString();
			sParam += "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("EES_LSE_0029GS.do", sParam);
			if(ComGetEtcData(sXml, "cntr_onh_auth_no") != undefined ){
			    ComSetObjValue(formObj.cntr_onh_auth_no, ComGetEtcData(sXml, "cntr_onh_auth_no"));
			    sheetObj.LoadSaveData(sXml);
			    ComBtnDisable("Save");
			    ComBtnDisable("btn1_handleOnCharge");
			    ComShowCodeMessage("LSE10001");
			}else{
				sheetObj.LoadSaveData(sXml);
			}
		}
	}
	break;
	case IBCREATE:
		var usr_ofc_cd = formObj.usr_ofc_cd.value;
		var ofc_type = usr_ofc_cd.substring(3,5);
		
		if(ofc_type == 'HQ'){
			comboObjects[0].RemoveAll();
			comboObjects[0].InsertItem('MI', 'MI');
		}
		else{
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
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
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
	case IBSEARCH_ASYNC02:
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			for(var j=12 ; j <= arrTpSz3.length + 11 ; j++){
				if(sheetObj.GetCellValue( 1 , j ) == "L/On" ){
		        	sheetObj.SetCellValue( curRow , j ,0.00);
		        }
			}
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
					sheetObj.SetCellValue(curRow , "eff_dt","",0);
					sheetObj.SetCellValue(curRow , "exp_dt","",0);
					sheetObj.SelectCell(curRow , "agmt_seq" , false);
					curRow=0;
				}
			}
			ComBtnEnable("Save");
		}
	}
	break;
	case IBSEARCH_ASYNC03:  // registering for Location
	if(validateForm(sheetObj,formObj,sAction)) {
		var param="f_cmd="  + SEARCH21
				 + "&eq_loc_tp_cd=" + "LO"
				 + "&loc_cd=" + formObj.loc_cd.value;

		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
		sheetObj.SetWaitImageVisible(1);
		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S" ) {
				ComShowCodeMessage("LSE01037");
				formObj.loc_cd.value="";
				ComSetFocus(formObj.loc_cd);
			} 
		}
	}
	break;
	case IBSEARCH:  
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH;						
			formObj.agmt_cty_cd.value="HHO";			
			var strAgmtSeq="";
			for(var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
				if(i == 2){
					strAgmtSeq=sheetObj.GetCellValue( i , "agmt_seq" );
				}else{
					strAgmtSeq=strAgmtSeq + "|" + sheetObj.GetCellValue( i , "agmt_seq" );
				}
			}			
			formObj.agmt_seq.value=strAgmtSeq;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_0029GS.do",FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);
			var strTpSZ=formObj.tpsz_cd.value;
			var rowCnt=ComGetEtcData(sXml, "rowCnt");
			for(var i=0 ; i < Number(rowCnt) ; i++ ){
			     var Row1=sheetObj.FindText("agmt_seq", String(LseXmlStringOfItmCnt(sXml, "agmt_seq", i)), 0);
			     var strName=LseXmlStringOfItmCnt(sXml, "cntr_tpsz_cd1", i);
			     var strTpSZCd=LseXmlStringOfItmCnt(sXml, "cntr_tpsz_cd2", i);
			     var lOnChg=LseXmlStringOfItmCnt(sXml, "n1st_chg_amt", i);
			     var strOldValue=sheetObj.GetCellValue( Row1 , strName + "_old" );
		         var OldValue=0;
		         OldValue=Number(strOldValue);
		         if(OldValue > 0 ){
			         if(strTpSZ.indexOf(strTpSZCd) > -1 ){
			             sheetObj.SetCellValue( Row1 , strName + "_lon" ,Number(lOnChg));
			         }
		         }
		         OldValue=0;
			}
			ComBtnEnable("Save");
		}
	}
	break;
	
	case IBSEARCH_ASYNC04:
	    sheetObj.SetWaitImageVisible(0);
	    ComOpenWait(true);			
		formObj.f_cmd.value=SEARCH01;			
		var xml="";
        xml=sheetObj.GetSearchData("EES_LSE_0029GS.do", FormQueryString(formObj));
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
			if ( formObj.cntr_onh_auth_no.value != "" ) {
				ComShowCodeMessage("LSE01058");
				return false;
				break;
			}
			if ( formObj.loc_cd.value == "" ) {
				ComShowCodeMessage("LSE01046");
				ComSetFocus(formObj.loc_cd);
				return false;
				break;
			}
			if ( comboObjects[0].text == "" ) {
				ComShowCodeMessage("LSE01009");
				ComSetFocus(comboObjects[0]);
				return false;
				break;
			}
			if ( formObj.pkup_due_dt.value == "" ) {
				ComShowCodeMessage("LSE01049");
				ComSetFocus(formObj.pkup_due_dt);
				return false;
				break;
			}
			if ( formObj.tpsz_cd.value == "" ) {
				ComShowCodeMessage("LSE01015");
				ComSetFocus(comboObjects[1]);
				return false;
				break;
			}
			var oldValue="";
			var newValue="";
			var strEffDateSdt = "";
			var strEffDateEdt = "";
			var strBldUpdt = "";
			var strPickUpDueDate = "";
			var strStartDate = "";
			strPickUpDueDate = formObj.pkup_due_dt.value;
			strPickUpDueDate = ComReplaceStr(strPickUpDueDate,"-","");
			
			var objstCd = comboObjects[0].GetSelectText();  
			
			for(var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
				if(sheetObj.GetCellValue( i , "lstm" ) == ""){
					ComShowCodeMessage("LSE01009");
					sheetObj.SelectCell(i, 3, false);
					return false;
				}
				if(sheetObj.GetCellValue( i , "lstm" ) != comboObjects[0].GetSelectText()){
					ComShowCodeMessage("LSE01056");
					sheetObj.SelectCell( i , 3 );
					return false;
				}
				
				if(sheetObj.GetCellValue( i , "return_lcc" ) == "" && form.type_chk[1].checked == true) {
					ComShowCodeMessage("LSE10013","Expected Return LCC");
					sheetObj.SelectCell( i , "return_lcc" );
					return false;
				}
				
//				if(objstCd == "LT" || objstCd == "ST" || objstCd == "SI" || objstCd == "OF") {			
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
					
//				}
			}
			
			oldValue="";
			newValue="";
			var iOldValue=0;
			var iNewValue=0;
			var strTpSzOldName="";
			var strTpSzNewName="";
			if( sheetObj.RowCount()== 1 ){
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
			case IBSEARCH: 
			    if ( formObj.loc_cd.value == "" ) {
			    	ComShowCodeMessage("LSE01046");
					ComSetFocus(formObj.loc_cd);
					return false;
					break;
			    }			
			    if ( comboObjects[0].text == "" ) {
					ComShowCodeMessage("LSE01009");
					ComSetFocus(comboObjects[0]);
					return false;
					break;
				}
				if ( formObj.pkup_due_dt.value == "" ) {
					ComShowCodeMessage("LSE01049");
					ComSetFocus(formObj.pkup_due_dt);
					return false;
					break;
				}
			    if ( formObj.tpsz_cd.value == "" ) {
					ComShowCodeMessage("LSE01015");
					ComSetFocus(comboObjects[1]);
					return false;
					break;
				}
			    if(sheetObj.RowCount()> 0){
			       for(var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
			    	   if(sheetObj.GetCellValue( i , "agmt_seq" ) == ""){
			    		  ComShowCodeMessage("LSE01006");
						  sheetObj.SelectCell(i, "agmt_seq", false);
						  return false;
							break;
			    	  }
			      }			
			    }else{
			    	ComShowCodeMessage("LSE01048");				
					return false;
					break; 
			    }
			break;
			}
		}
	}
	return true;
}
/**
 * initializing IBMultiCombo
 */
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
			SetMaxSelect(30);
		}
		break;
	}
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
		var sUrl='/opuscntr/COM_ENS_051.do';
		var iWidth=800;
		var iHeight=480;
		var sTargetObjList="loc_cd:loc_cd";
		var sDisplay="1,0,1,1,1,1,1,1";
		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	}else if ( type == "2"){
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
	}
}
 /**
  * handing process Agreement Pop-up Return Value <br>
  * @param Return value array
  * @param Row index
  * @param Col index
  * @param Sheet Array index
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
  
  function combo2_OnCheckClick(Index, Code, Checked) {
	  if(sheetObjects[0].GetCellValue(2 , "arr_cntr_tpsz_cd") != ""){
			if(checkingAgmtTpsz(sheetObjects[0], document.form, "", "A") == false) {
				ComShowCodeMessage("LSE01159");
				comboObjects[1].SetItemCheck(Code,0);
				return false;
			} 
		}
	  
	  var tpSz = comboObjects[1].GetSelectText();
	  document.form.tpsz_cd.value = tpSz;
 }
  
 //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	//comboObj,value,text
	var strTpszCd=newCode.replaceStr("|", ",").split(",");
	var sTpSz=document.form.tpsz_cd.value;
	var strTypeChk = document.form.type_chk.value;
	initSheet(sheetObjects[0],1);
	sheetObjects[0].RenderSheet(0);
	for(var i=0; i<arrTpSz.length; i++){
		if(sTpSz.indexOf(arrTpSz[i])>= 0) {
			//column not hidden
			if(strTypeChk == "O") {
				sheetObjects[0].SetColHidden(arrTpSz2[i] + "_old",0);
			}else{
				sheetObjects[0].SetColHidden(arrTpSz2[i] + "_old",1);
			}
			sheetObjects[0].SetColHidden(arrTpSz2[i] + "_new",0);
			sheetObjects[0].SetColHidden(arrTpSz2[i] + "_lon",0);
		} else {
			//column hidden
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
		if(addCnt == 1){
			sheetObjects[0].SheetWidth=984;
		}else if(addCnt > 1){
			sheetObjects[0].SheetWidth=984;	
		}else{
			var addSize=Number(addCnt) * 150 ;
			sheetObjects[0].SheetWidth=780 + addSize;
		}
	}else{
		sheetObjects[0].SheetWidth=780;
	}
	ComBtnDisable("Save");
}
function obj_change(){
	var obj=ComGetEvent();
	var formObject=document.form;
	var sheetObject=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "loc_cd":
			ComBtnDisable("Save");
			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC03);
			break;
			
		case "type_chk":
			var strTypeChk = formObject.type_chk.value;
			var usr_ofc_cd = formObject.usr_ofc_cd.value;
			var ofc_type   = usr_ofc_cd.substring(3,5);
			formObject.loc_cd.value = "";
			formObject.pkup_fm_dt.value = "";
			formObject.pkup_due_dt.value = "";
			
			if(strTypeChk == "O") {
				
				if(ofc_type == 'HQ'){
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('MI', 'MI');
				}
				else{
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('OL', 'OL');
					comboObjects[0].InsertItem('LT', 'LT');
					comboObjects[0].InsertItem('ST', 'ST');
					comboObjects[0].InsertItem('OF', 'OF');
					comboObjects[0].InsertItem('SI', 'SI');
					comboObjects[0].InsertItem('MI', 'MI');
				}
				sheetObject.SetColHidden("return_lcc", 1);
				sheetObject.SetColHidden("div_total", 0);
				
			}else{
				if(ofc_type == "HQ"){
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('MO', 'MO');
				}else{
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem('SO', 'SO');
					comboObjects[0].InsertItem('MO', 'MO');
				}
				sheetObject.SetColHidden("return_lcc", 0);
				sheetObject.SetColHidden("div_total", 1);
			}
			
			for(var i=0 ; i < arrTpSz2.length ; i++){
				sheetObject.SetColHidden(arrTpSz2[i]+"_old", 1);
			}
			ComBtnDisable("Save");
		    ComBtnEnable("btn1_handleOnCharge");
		    
		    formObject.tpsz_cd.value = "";
			sheetObjects[0].RemoveAll();			
			sheetObjects[0].RenderSheet(1);
			
		    for(var i = 0; i < comboObjects[1].GetItemCount() ; i++){
				comboObjects[1].SetItemCheck(i, 0);
			}
			break;
			
		case "pkup_fm_dt":    			
			setDuration();	    			
			break;
			
		case "pkup_due_dt":			
			setDuration();
			break;
		}
	}
}

/**
 * sheet1_OnChange
 * handling event when changing Sheet.
 * checking whether when changing grid agmt_no or retrievent for Lessro ABBR   
 */
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
				sheetObj.SetCellValue(Row,Col, "", 0);
				sheetObj.SelectCell(Row,Col);
			} 
		}
	}
	
	if(Col == 2 || Col == 3){
		if( sheetObj.GetCellValue(Row , 2) != "" && sheetObj.GetCellValue(Row , 3) != "" ){
			formObj.agmt_cty_cd.value=sheetObj.GetCellValue(Row , 2);
			formObj.agmt_seq.value=sheetObj.GetCellValue(Row , 3);
			//checking whether AGMT NO duplicate	
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
						sheetObj.SelectCell(Row , "agmt_seq" , false);
						return;
					}
				}
			} 			
			curRow=Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04, Row);	
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			checkingAgmtTpsz(sheetObj, formObj, Row);
			ComBtnDisable("Save");
		}
	}
	var old_sum=0;
	var new_sum=0;
	var cValue=0;
	if( Col > 11 && Col <= (arrTpSz3.length + 12)  ){
		for(var i=12 ; i <= (arrTpSz3.length + 12) ; i++ ){
			if( sheetObj.GetCellValue(1 , i) == "Old" ){
				cValue=sheetObj.GetCellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue=0 ;
				}
				old_sum=Number(old_sum) + Number(cValue);
			}else if(sheetObj.GetCellValue(1 , i) == "New"){
				cValue=sheetObj.GetCellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue=0 ;
				}
				new_sum=Number(new_sum) + Number(cValue);
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

/**
 * handling Location blur event
 * #19173 : User의 요청에 따라 past date으로도 period를 설정할 수 있도록 변경
 */
/*function obj_blur(){
	var obj=ComGetEvent();
	switch(ComGetEvent("name")){
	case "pkup_due_dt":
		if(document.form.pkup_due_dt.value != ""){
		   var strPkupDt = ComGetNowInfo("ymd");	
		   var pkupDt = document.form.pkup_due_dt.value;	

		   strPkupDt = strPkupDt.replaceStr("-", "");	
		   pkupDt = pkupDt.replaceStr("-", "");	
		   
		   if(pkupDt < strPkupDt){
			   ComShowCodeMessage("LSE01026");
			   document.form.pkup_due_dt.value="";
			   document.form.pkup_due_dt.focus();
		       return;
		   }		
		   ComChkObjValid(obj);
		}
		break;  
	default:
		//checking Validation
		break;
	}
}*/

/**
 * HTML Control??handling event in case of Key-Down?쒕떎.
 */
function obj_keydown() {
	var obj      = ComGetEvent();
	var vKeyCode = event.keyCode;
	var formObj  = document.form;

	switch (ComGetEvent("name")){ 
	case "apro_rmk":		
		if ( ComGetEvent("keycode") == "229" ) {
			event.returnValue = false;
			return true;
		}
		
		if ( ComGetLenByByte(obj) > 400) {			
			ComShowCodeMessage("LSE01024");			
			return false;
		}
	}
}
 /**
  * handling event when OnPopuphandling Sheet.<br>
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
  * adding comma<br>
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
 
/**
 * Pick Up Period inserting, Duration calc handling<br>
 */
 function setDuration() {
 	var formObj=document.form;
		var input1=ComReplaceStr(ComGetObjValue(formObj.pkup_fm_dt), "-", "");
		var input2=ComReplaceStr(ComGetObjValue(formObj.pkup_due_dt), "-", "");
	
 }
 function title_color(){
     for(var i=0; i<arrTpSz2.length; i++){			
//         sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_old","#B0C4DE");
//         sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_lon","#B0C4DE");
//         sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_old","#B0C4DE");
//         sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_lon","#B0C4DE");
     }
 }
 
 
 /**
  * Checking AGMT TP/SZ<br>
  * @param sheetObj, formObj, Row, Div
  */
 function checkingAgmtTpsz(sheetObj, formObj, Row, Div){
	 if(Div == "A"){
		 //Combo Tp/Sz
		 var cntrTpszCd1  = comboObjects[1].GetSelectText()
		 var cbCntrTpszCd = cntrTpszCd1.replaceStr("|", ",").split(",");

		 for(i=0 ; i < cbCntrTpszCd.length ; i++){
			 for(j=2 ; j <= sheetObjects[0].LastRow(); j++){
				 var checkCnt = 0;
                 var cntrTpszCd = sheetObjects[0].GetCellValue(j , "arr_cntr_tpsz_cd");
				 var agmtCntrTpszCd = cntrTpszCd.replaceStr("|", ",").split(",");
				 
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
		 var agmtCntrTpszCd = cntrTpszCd.replaceStr("|", ",").split(",");
		 
		 //Combo Tp/Sz
		 var cntrTpszCd1 = comboObjects[1].GetSelectText()
		 var cbCntrTpszCd = cntrTpszCd1.replaceStr("|", ",").split(",");
		 for(i=0 ; i < cbCntrTpszCd.length ; i++){
			 var checkCnt = 0;
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
/* end of developer job */
