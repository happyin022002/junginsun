/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0054.js
*@FileTitle  : Off Hire Result Vs DOL 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19

=========================================================*/
/****************************************************************************************
  Event code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
				 	  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0054 : define business script for EES_LSE_0054
 */

/* developer job  */
// common variables
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array();
var arrTpSz2=new Array();
var arrTotal = 0;
var strEnd = false;
// Event handler processing by button name */
document.onclick=processButtonClick;
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('click','obj_click',formObj);
	axon_event.addListenerFormat('change','obj_change',formObj);
//	axon_event.addListenerFormat('keypress','obj_keypress',formObj);
	axon_event.addListenerFormat('blur','obj_blur',formObj);
//	axon_event.addListenerFormat('focus','obj_focus',formObj);
	axon_event.addListenerFormat('focus','obj_click',formObj);
	axon_event.addListener('change', 'report_type_onchange', 'report_type');		//Location by 변경시 이벤트 처리
//	axon_event.addListenerForm('keydown',		'obj_keydown',	formObj);
}
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj=ComGetEvent();
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_DownExcel1":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObject1), SheetDesign:1,Merge:1 });
				}
			break;
		case "btn_DownExcel2":
			if(sheetObject2.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObject2), SheetDesign:1,Merge:1 });
				}
			break;
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;
		case "btn_New":
			sheetObjects[0].SetCellText(0,"agmt_no" ,"Location");
			formObject.report_type[0].selected=true;
			formObject.agmt_seq.value="";
			formObject.contract_no.value="";
			document.form.loc_cd.className="input";
			document.form.agmt_seq.className="input1";
			sheetObject1.RemoveAll();
			sheetShowInit();
			sheetObject2.RemoveAll();
			formObject.year_month.value="";
			formObject.loc_tp[0].selected=true;
			formObject.loc_cd.value="";
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			formObject.abbr_nm.value="";
			formObject.agmt_seq.value="";
			formObject.contract_no.value="";
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
				comboObjects[0].SetItemCheck(i,0);
			}
			formObject.lstm_cd.value="";
			for(var i=1 ; i < comboObjects[1].GetItemCount(); i++ ){
				comboObjects[1].SetItemCheck(i,0);
			}
			comboObjects[0].SetItemCheck(0,1);
			comboObjects[1].SetItemCheck(0,1);
			formObject.cntr_tpsz_cd.value="";
			formObject.term_change[1].selected=true;
			formObject.dii[0].selected=true;
			break;
		case "btns_calendar1":
			/*
    			var cal=new ComCalendar();
    			cal.select(formObject.year_month, "yyyy-MM");*/
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.year_month, "yyyy-MM");
			}
			break;
		case "btns_search1":      // loc_cd
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
		break;
		case "btns_search2":     // lessor
		if ( srcObj.style.filter == "" ) {
			openPopup("2");
		}
		break;
		case "btns_search3":	//agmt_seq
		if ( srcObj.style.filter == "" ) {
			openPopup("3");
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
function loadPage() {
	var formObj = document.form;
	formObj.f_cmd.value=SEARCH02;
	sheetObjects[0].SetWaitImageVisible(0);
	var sXml2=sheetObjects[0].GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
	sheetObjects[0].SetWaitImageVisible(1);
	if ( sXml2 != "" ) {
		//comboObjects[1].InsertItem(0 , 'ALL','ALL');
		//LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
		vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
		formObj.tysz.value=vOrcCntrTpszCd;
		arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
		arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
	}
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	//initializing IBMultiCombo
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	initSheet(sheetObjects[0],1);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);
	comboObjects[0].SetItemCheck(0,1);
	comboObjects[1].SetItemCheck(0,1);
	sheetShowInit();
	document.form.year_month.focus();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "sheet1":
		with (sheetObj) {

		    var HeadTitleTemp="";
		    for(var i=0; i<arrTpSz.length; i++){
		    HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i];
		    }
		    var HeadTitle="|LCC|SCC|DIV|Total" + HeadTitleTemp + "||";
		    var headCount=ComCountHeadTitle(HeadTitle);
		    //(headCount, 0, 0, true);
		    for(var j=0; j < 4; j ++) {
		    cnt=0;
	
		    SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 ,SizeMode:0} );
	
		    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"location",     KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",      KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"div",          KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"div_total",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
		       for(var i=0; i<arrTpSz2.length; i++){
		    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:arrTpSz2[i]+"", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    }
//		    cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"scc_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
//		    cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		  
		    InitColumns(cols);
	
		    SetEditable(0);
//		    SetGetCountPosition()(0);
		       }
		   // SetColHidden("auto_sum",1);
		    FrozenCols=5;
		    SetSheetHeight(250);
		    SetSheetWidth(800);
		}
		break;
	case "sheet2":
		with (sheetObj) {
		    
		    var HeadTitle="|Seq.|CNTR No.|TP/SZ|AGMT No.|Term|Ref No.|MVMT|On-hire\nDate|On-hire\nYard|F/Days|Off-hire\nDate|Off-hire\nYard|Used\nDays|Min\nO/H Days|Term\nChange|Direct\nInterchange in|Immediate\nExit|Rental\nCharge|LON|PUC|PCR|LOF|DOC|DCR|On-hire\nDrayage|Off-hire\nDrayage|M & R\nCost|DPP|G.TTL";
		    var headCount=ComCountHeadTitle(HeadTitle);
		    //(headCount, 0, 0, true);
	
		    SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
	
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
		              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrno",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ohdate",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ohloc",             KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fdays",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofhdate",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofhloc",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"useddays",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"minohdays",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"term_change",       KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"CheckBox",  Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"dii",               KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"immediately",       KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"rental_charge",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"lon",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"puc",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pcr",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"lof",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"doc",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"dcr",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"on_hire_drayage",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"off_hire_drayage",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"m_r_cost",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"dpp",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"g_ttl",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
		     
		    InitColumns(cols);
	
		    SetEditable(0);
		    SetSheetHeight(207);
		}
		break;
	}
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:
	if(validateForm(sheetObj,formObj,sAction))
		if (sheetObj.id == "sheet1"){
			formObj.f_cmd.value=SEARCH;
//			sheetObj.RenderSheet(0);
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(true);
			var strSelect = combo2.GetSelectText();
			if(strSelect != "ALL") {
				formObj.tysz.value = strSelect;
			}
			var strYear="";
			var strMonth="";
			var strYearMonth=formObj.year_month.value ;
			if(strYearMonth != null && strYearMonth.length == 7){
				strYearMonth=strYearMonth.replaceStr("-" , "");
			}
			strYear=strYearMonth.substring(0,4);
			strMonth=strYearMonth.substring(4);
			formObj.period_stdt.value=strYear + "-" + strMonth + "-01" ;
			formObj.period_eddt.value=strYear + "-" + strMonth + "-" + GetLastDay(strYear,strMonth);
			
			setTimeout( function () {
				var sXml=sheetObj.GetSearchData("EES_LSE_0054GS.do", FormQueryString(formObj));
				
				var rtnValue=sXml.split("|$$|");
				
				for(var i=0;i<rtnValue.length;i++) {
					arrTotal = i+1;
					if(Number(rtnValue.length) == Number(arrTotal)) {
						strEnd = true;
					}
					sheetObj.LoadSearchData(rtnValue[i],{Append:1 ,Sync:1} );
				}
			} , 100);
			
		
//			sheetObj.RenderSheet(1);
		}
	break;
	case IBCREATE:
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml2 != "" ) {
			comboObjects[1].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");
			formObj.tysz.value=vOrcCntrTpszCd;
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;
	case IBSEARCH_ASYNC01:
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet2") {
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("EES_LSE_0054GS.do",FormQueryString(formObj) );
			ComOpenWait(false);
		}
	}
	break;
	case IBSEARCH_ASYNC02:
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);
			if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
				formObj.contract_no.value=ComGetEtcData(sXml, "ref_no");
				for(var i=0 ; i < comboObjects[0].GetItemCount(); i++ ){
					comboObjects[0].SetItemCheck(i,0);
				}
				comboObjects[0].SetSelectCode(ComGetEtcData(sXml, "lstm_cd"),true);

				formObj.lstm_cd.value=ComGetEtcData(sXml, "lstm_cd");
				formObj.vndr_seq.value=ComGetEtcData(sXml, "vndr_seq");
				formObj.abbr_nm.value=ComGetEtcData(sXml, "vndr_abbr_nm");
				formObj.vndr_nm.value=ComGetEtcData(sXml, "vndr_lgl_eng_nm");
			} else {
				ComShowCodeMessage("LSE01007");
				formObj.agmt_seq.value="";
				formObj.contract_no.value="";
				ComSetFocus(formObj.agmt_seq);
			}
		}
	}
	break;
	case IBSEARCH_ASYNC03:
		/* Lease Term Form Combo Item Setting */
		ComSetObjValue(formObj.f_cmd, SEARCH01);
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.SetWaitImageVisible(1);
		if ( sXml != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL');
			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		}
		vOrcLstmCd=ComGetEtcData(sXml, "lease_term_nm");
		break;
	case IBSEARCH_ASYNC04:	// handling process for input Form Lessor No.)
	if ( validateForm(sheetObj, formObj, sAction) ) {
		var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
		sheetObj.SetWaitImageVisible(1);
		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
				ComSetFocus(formObj.vndr_nm);
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
	case IBSEARCH_ASYNC05:	// Location 
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp=formObj.loc_tp.value;
			var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp + "CC"
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
			sheetObj.SetWaitImageVisible(1);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd="";
						switch (vLocTp) {
						case "R":
							vLocCd=ComGetEtcData(sXml, "rcc_cd");
							break;
						case "L":
							vLocCd=ComGetEtcData(sXml, "lcc_cd");
							break;
						case "S":
							vLocCd=ComGetEtcData(sXml, "scc_cd");
							break;
						}
						formObj.loc_cd.value=vLocCd;
						ComSetFocus(formObj.loc_cd);
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value="";
						ComSetFocus(formObj.loc_cd);
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
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:
			if ( formObj.year_month.value == "" ) {
				ComShowCodeMessage("LSE01010");
				ComSetFocus(formObj.year_month);
				return false;
				break;
			}
			if ( formObj.report_type[0].selected == true && formObj.agmt_seq.value == "" ) {
				ComShowCodeMessage("LSE01006");
				ComSetFocus(formObj.agmt_seq);
				return false;
				break;
			}
			if ( formObj.report_type[1].selected == true && formObj.loc_cd.value == "" ) {
				ComShowCodeMessage("LSE01046");
				ComSetFocus(formObj.loc_cd);
				return false;
				break;
			}
			if(formObj.cntr_tpsz_cd.value == ""  && comboObjects[1].GetItemCheck(0) == false ){
				ComShowCodeMessage("LSE01015");
				formObj.combo2.focus();
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
 * handling Location blur event
 */
function obj_blur(){
	var obj=ComGetEvent();
	switch(ComGetEvent("name")){
	case "period_stdt":
		//date check
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		//date check
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//date check
		ComChkObjValid(obj);
		break;
	case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.contract_no.value="";
		}
		break;
	case "vndr_seq":////
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value="";
			document.form.abbr_nm.value="";
		}
		break;
	case "year_month":
		ComChkObjValid(obj);
		break;
	default:
		break;
	}
}
/**
 * initializing IBMultiCombo
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
	case "combo1":
		with(comboObj) {
			SetDropHeight(250);
			SetMultiSelect(1);
			//MaxSelect = 1;
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
			//only upper case, special characters - Lease Term
//no support[check again]CLT 			ValidChar(2,2);
		}
		break;
	case "combo2":
		with(comboObj) {
			SetDropHeight(200);
			SetMultiSelect(1);
			//MaxSelect = 1;
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
			//only upper case, numbers - TP/SZ
//no support[check again]CLT 			ValidChar(2,3);
		}
		break;
	}
}
/**
 * MultiSelect combo1 click event
 * @return
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
			
			comboObj.SetItemCheck(0,1);
		}
	} else {
		comboObj.SetItemCheck(0,0);
	}
}
/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if( comboObj.GetItemCheck(0)){
		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
			comboObj.SetItemCheck(i,0);
		}
		formObj.lstm_cd.value="";
	}else if(comboObj.GetSelectText()== ""){
		comboObj.SetItemCheck(0,1);
		formObj.lstm_cd.value="";
	}else{
	    formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
}
/**
 * combo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
			comboObj.SetSelectText("");
		}else if(KeyCode == 13){
 		    sheetObjects[0].RemoveAll();
 		    sheetObjects[1].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
}
/**
 * MultiSelect combo2 click event
 * @return
 */
function combo2_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
			
			comboObj.SetItemCheck(0,1);
		}
	} else {
		comboObj.SetItemCheck(0,0);
	}
}
/**
 * combo2_OnBlur
 */
function combo2_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if( comboObj.GetItemCheck(0)){
		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
			comboObj.SetItemCheck(i,0);
		}
		formObj.cntr_tpsz_cd.value="";
	}else if(comboObj.GetSelectText()== ""){
		comboObj.SetItemCheck(0,1);
		formObj.cntr_tpsz_cd.value="";
	}else{
	    formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
}
/**
 * combo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
			comboObj.SetSelectText("");
		}else if(KeyCode == 13){
 		    sheetObjects[0].RemoveAll();
 		    sheetObjects[1].RemoveAll();
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
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
		var sTargetObjList="";
		var sDisplay="1,0,1,1,1,1,1,1";
		if(formObj.loc_tp.value == "R"){
		    sTargetObjList="rcc_cd:loc_cd";
		}else{
			sTargetObjList="scc_cd:loc_cd";
		}
		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	} else if ( type == "2") {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	} else if ( type == "3") {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
	}
}
/**
 * handing process in DeliveryLoc(Country) Pop-up Return Value<br>
 * @param {arry} returnedValues Pop-up Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function getCOM_ENS_0M1_2(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj=sheetObjects[SheetIdx];
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}
/**
 * handing process in DeliveryLoc(Yard) Pop-up Return Value<br>
 * @param {arry} returnedValues Pop-up Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj=sheetObjects[SheetIdx];
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
	}
}
/**
 * handing process in Currency Pop-up Return Value<br>
 * @param {arry} returnedValues Pop-up Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( aryPopupData.length > 0 ) {
		formObj.agmt_seq.value = aryPopupData[0][5];
		formObj.contract_no.value =  aryPopupData[0][6];
	}
}
/**
 * handing process in Lessor(Service Provider) Pop-up Return Value<br>
 * @param {arry} returnedValues Pop-up Return value array
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
		formObj.abbr_nm.value=aryPopupData[0][5];
	}
}

function report_type_onchange(){
	if(document.form.report_type[0].selected == true){
		//by location
    	sheetObjects[0].RemoveAll();
    	sheet1.SetCellText(0,"location" ,"LCC");
		sheet1.SetCellText(0,"agmt_no" ,"SCC");
		document.form.loc_cd.className="input";
		document.form.agmt_seq.className="input1";
	}else if(document.form.report_type[1].selected == true){
		//by agreement
		sheetObjects[0].RemoveAll();
		sheet1.SetCellText(0,"location" ,"LCC / SCC");
		sheet1.SetCellText(0,"agmt_no" ,"AGMT No.");
		document.form.loc_cd.className="input1";
		document.form.agmt_seq.className="input";
	}
}
/**
 * handling event in case of Value
 */
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	switch(ComGetEvent("name")) {
	case "agmt_seq":
		if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
		}
		break;
	case "vndr_seq":
		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
		}
		break;
	case "loc_cd":
		if(formObj.loc_cd.value.length == 5){
			ComChkObjValid(obj);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
		}
		break;
	case "year_month":
		var strYear="";
		var strMonth="";
		var strYearMonth=formObj.year_month.value ;
		if(strYearMonth != null && strYearMonth.length == 7){
			strYearMonth=strYearMonth.replaceStr("-" , "");
		}
		strYear=strYearMonth.substring(0,4);
		strMonth=strYearMonth.substring(4);
		formObj.period_stdt.value=strYear + "-" + strMonth + "-01" ;
		formObj.period_eddt.value=strYear + "-" + strMonth + "-" + GetLastDay(strYear,strMonth);
		break;
	}
	
}

/**
 * handling event in case of Click
 */
function obj_click() {
	var obj=event.srcElement;
	
	switch(ComGetEvent("name")) {
	    /*case "report_type":
	    	
	    if(document.form.report_type[0].selected == true){
			//by location
	    	sheetObjects[0].RemoveAll();
	    	sheet1.SetCellText(0,"location" ,"LCC");
			sheet1.SetCellText(0,"agmt_no" ,"SCC");
			document.form.loc_cd.className="input";
			document.form.agmt_seq.className="input1";
		}else if(document.form.report_type[1].selected == true){
			//by agreement
			sheetObjects[0].RemoveAll();
			sheet1.SetCellText(0,"location" ,"LCC / SCC");
			sheet1.SetCellText(0,"agmt_no" ,"AGMT No.");
			document.form.loc_cd.className="input1";
			document.form.agmt_seq.className="input";
		}
		break;*/
	}
}
/**
 * calling event after retrieving Sheet
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(strEnd == true) {
		ComOpenWait(false);
		var formObj=document.form;
		var lRow=sheetObj.LastRow()-3;
		var lastRow=sheetObj.LastRow();
		var gTTL="";
		var hiddenCnt=0;
		var strCntrTpszCd=formObj.cntr_tpsz_cd.value ;
		
		
		for(var i=0 ; i < arrTpSz2.length ; i++){
			gTTL=sheetObjects[0].GetCellValue(lastRow ,arrTpSz2[i]);
			gTTL = gTTL + sheetObjects[0].GetCellValue(lRow ,arrTpSz2[i]);
			if( comboObjects[1].GetItemCheck(0) == true ){
				if( Number(gTTL) <= 0 ){
					sheetObjects[0].SetColHidden(arrTpSz2[i],1);
					hiddenCnt++;
				}else{
					sheetObjects[0].SetColHidden(arrTpSz2[i],0);
				}
			}else{
				if( 0 <= strCntrTpszCd.indexOf(arrTpSz[i])) {
					if( Number(gTTL) <= 0 ){
						sheetObjects[0].SetColHidden(arrTpSz2[i],1);
						hiddenCnt++;
					}else{
						sheetObjects[0].SetColHidden(arrTpSz2[i],0);
					}
				}else{
					sheetObjects[0].SetColHidden(arrTpSz2[i],1);
					hiddenCnt++;
				}
			}
		}
	
		if(sheetObj.SearchRows()> 0) {
			sheetObj.SetMergeCell(sheetObj.LastRow()-4, 1, 4, 2);
			sheetObj.RowDelete(sheetObj.LastRow(),0);
			sheetObj.SelectCell(1, 1);
	
		}
		formObj.tysz.value=vOrcCntrTpszCd;
		
		strEnd = false;
	}
}


/**
 * sheet1_OnDblClick
 * handling event in case of sheet double click
 * retrieving for SUMMARY DETAIL
 */
function sheet1_OnDblClick(sheet_obj , Row, Col, CellX, CellY, CellW, CellH) {
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sRow=sheetObject1.GetSelectRow();
	var sCol=sheetObject1.GetSelectCol();
	//if(sheetObjects[0].CellValue( sRow , "location") != "G.TTL"){
if(sheetObjects[0].GetCellValue( sRow , "div") != "Off-Hired"){
		    return;
	    }
	//}else{
	    //return;
	//}
	if(sCol > 4 ){
		formObj.detail_cntr_tp_sz.value=sheetObject1.GetCellText(0 , sCol);
	}else{
		formObj.detail_cntr_tp_sz.value="";
	}
	if(document.form.report_type[0].selected == true){
		formObj.detail_rcc.value=sheetObjects[0].GetCellValue( sRow , "agmt_no");
		formObj.detail_agmt_seq.value="";
		formObj.detail_scc_cd.value=sheetObjects[0].GetCellValue( sRow , "agmt_no");
	}else if(document.form.report_type[1].selected == true){
		formObj.detail_rcc.value="";
		formObj.detail_agmt_seq.value=sheetObjects[0].GetCellValue( sRow , "agmt_no").substring(3);
		//formObj.detail_scc_cd.value=sheetObjects[0].GetCellValue( sRow , "location").substring(7);
		var arrSccCd = sheetObjects[0].GetCellValue( sRow , "location").split("/");
		var strSccCd = "";
		if(arrSccCd.length>0) {
			strSccCd = ComTrim(arrSccCd[1]);
		}
		formObj.detail_scc_cd.value=strSccCd;
	}
	sheetObjects[1].RemoveAll();
	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
}
/**
 * sheet1_OnMouseDown
 * handling event in case of sheet mouse click
 * retrieving for SUMMARY DETAIL
 */
function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
	/*var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sRow=sheetObj.MouseRow();
	var sCol=sheetObj.MouseCol();
	if(sRow > sheetObj.HeaderRows()&& sRow == sheetObj.LastRow()-2){
		//if(sheetObjects[0].CellValue( sRow , "location") != "G.TTL"){
		if(sheetObjects[0].GetCellValue( sRow , "div") != "Off-Hired"){
			    return;
		    }
		//}else{
		    //return;
		//}
		if(sCol > 4 ){
			formObj.detail_cntr_tp_sz.value=sheetObject1.GetCellText(0 , sCol);
		}else{
			formObj.detail_cntr_tp_sz.value="";
		}
		if(document.form.report_type[0].selected == true){
			formObj.detail_rcc.value=sheetObjects[0].GetCellValue( sRow , "agmt_no");
			formObj.detail_agmt_seq.value="";
			formObj.detail_scc_cd.value=sheetObjects[0].GetCellValue( sRow , "agmt_no");
		}else if(document.form.report_type[1].selected == true){
			formObj.detail_rcc.value="";
			formObj.detail_agmt_seq.value=sheetObjects[0].GetCellValue( sRow , "agmt_no").substring(3);
			//formObj.detail_scc_cd.value=sheetObjects[0].GetCellValue( sRow , "location").substring(7);
			var arrSccCd = sheetObjects[0].GetCellValue( sRow , "location").split("/");
			var strSccCd = "";
			if(arrSccCd.length>0) {
				strSccCd = ComTrim(arrSccCd[1]);
			}
			formObj.detail_scc_cd.value=strSccCd;
		}
		sheetObjects[1].RemoveAll();
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
	}*/
}
/**
 * initializing sheet TY/SZ
 */
function sheetShowInit(){
	for(var i=0; i<arrTpSz2.length; i++){
		sheetObjects[0].SetColHidden(arrTpSz2[i],0);
	}
	sheetObjects[0].SheetWidth=984;
}

/**
 * handling event in last day
 */
function GetLastDay(yyyy, mm) {
	var m=parseInt(mm,10) - 1;
	var end=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
		end[1]=29;
	}
	return end[m];
}
 /* end of developer job */
