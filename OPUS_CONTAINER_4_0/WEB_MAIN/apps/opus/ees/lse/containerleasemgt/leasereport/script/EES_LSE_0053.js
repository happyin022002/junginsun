/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0053.js
*@FileTitle  : On-Hire Result by Lease Term/Lessor-Option 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
 
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_LSE_0053 : business script for EES_LSE_0053
 */
function EES_LSE_0053() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
	this.combo1_OnCheckClick=combo1_OnCheckClick;
	this.combo1_OnBlur=combo1_OnBlur;
	this.combo1_OnKeyDown=combo1_OnKeyDown;
	this.combo2_OnCheckClick=combo2_OnCheckClick;
	this.combo2_OnBlur=combo2_OnBlur;
	this.combo2_OnKeyDown=combo2_OnKeyDown;
	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
}
/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array();
var arrTpSz2=new Array();
var iPageNo = 1;
//Event handler processing by button click event */
document.onclick=processButtonClick;
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerFormat('change','obj_change',formObj);       
//	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
	axon_event.addListenerFormat('blur','obj_blur',formObj);         
//	axon_event.addListenerFormat('focus','obj_focus',formObj);       
//	axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
}
//Event handler processing by button name */
function processButtonClick(){
	/**********/
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
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
				}
			break;
		case "btn_DownExcel2":
			if(sheetObject2.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
				}
			break;
		case "btn_more":
            doActionIBSheet1(sheetObjects[1], formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
            break;
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;
		case "btn_New":
			//document.getElementById("Detail_text").innerHTML = "";
			sheetObject1.RemoveAll();
			sheetShowInit();
			sheetObject2.RemoveAll();
			formObject.period_stdt.value="";
			formObject.period_eddt.value="";
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			formObject.abbr_nm.value="";
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
			rtv_total="0";
        	ComBtnDisable("btn_more");
			break;
		case "btns_calendar1":
			var cal=new ComCalendar();
			cal.select(formObject.period_stdt, "yyyy-MM-dd");
			break;
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
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
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	ComBtnDisable("btn_more");
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	initSheet(sheetObjects[0],1);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);
	comboObjects[0].SetItemCheck(0,1);
	comboObjects[1].SetItemCheck(0,1);
	document.form.period_stdt.focus();
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08); //페이징 갯수 가져오기	
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
		    var HeadTitle="|Lease Term|Lessor|Lessor Name|Total" +  HeadTitleTemp +"|";
		    var headCount=ComCountHeadTitle(HeadTitle);
		    (headCount, 0, 0, true);
	
		    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:2, Page:20, DataRowMerge:0 } );
	
		    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"supplier",     KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"div_total",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
		       for(var i=0; i<arrTpSz2.length; i++){
		    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:arrTpSz2[i]+"", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		    }
		    cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		  
		    InitColumns(cols);
	
		    SetEditable(0);
//		    SetGetCountPosition()(0);
		    SetColHidden("auto_sum",1);
		    FrozenCols=5;
		    SetSheetHeight(202);
		}
		break;
	case "sheet2":
		with (sheetObj) {

		    var HeadTitle="|Seq.|CNTR No.|TP/SZ|AGMT No.|Term|Ref No.|MVMT|On-hire\nDate|On-hire\nYard|F/Days|Off-hire\nDate|Off-hire\nYard|Used\nDays|Min\nO/H DAYS|Term\nChange|Direct\nInterchange In|Immediate\nExit|Rental\nCharge|LON|PUC|PCR|LOF|DOC|DCR|On Hire\nDrayage|Off Hire\nDrayage|M & R\nCost|DPP|G.TTL";
		    var headCount=ComCountHeadTitle(HeadTitle);
		    //(headCount, 0, 0, true);
	
		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		              {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntrno",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tysz",              KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"term",              KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ohdate",            KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ohloc",             KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fdays",             KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofhdate",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofhloc",            KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"useddays",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"minohdays",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		              {Type:"CheckBox",  Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"term_change",       KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"CheckBox",  Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"dii",               KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"CheckBox",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"immediately",       KeyField:0,   CalcLogic:"",   Format:"" },
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
		    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		    SetSheetHeight(207);
		}
		break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param CondParam
 * @param PageNo
 */
function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
	switch(sAction) {
	case IBSEARCH:
	if(validateForm(sheetObj,formObj,sAction))
		if (sheetObj.id == "sheet1"){
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			setTimeout( function () {
				var sXml=sheetObj.GetSearchData("EES_LSE_0053GS.do", FormQueryString(formObj));
				
				if(ComGetTotalRows(sXml) > 1) {
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					var lRow=sheetObj.LastRow();
					var gTTL="";
					var hiddenCnt=0;
					var strCntrTpszCd=formObj.cntr_tpsz_cd.value ;
					for(var i=0 ; i < arrTpSz2.length ; i++){
						gTTL=sheetObjects[0].GetCellValue(lRow ,arrTpSz2[i]);
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
					if(  ((arrTpSz2.length - hiddenCnt) * 50) +  470  > 984 ){
						sheetObjects[0].SheetWidth=984;
					}else{
						sheetObjects[0].SheetWidth=((arrTpSz2.length - hiddenCnt) * 50) +  470 ;
					}
					if(sheetObj.LastRow()> 1 ){
					    var strRows=ComFindAll(sheetObjects[0], 2, "S.TTL");
					    strRows=strRows + "";
					    arrRows=strRows.replaceStr("|", ",").split(",");
					    for( var i=0 ; i < arrRows.length ; i++ ){
					    	var Row= arrRows[i];
						    sheetObjects[0].SetMergeCell( parseInt(Row), 2, 1, 2);
					    }
					    if(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), 1) == "G.TTL" ){
						    sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow(), 1, 1, 3);
					    }
					}
				} else {
					sheetObj.LoadSearchData("<SHEET><DATA TOTAL='0'></DATA></SHEET>",{Sync:1} );
	//				sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				ComOpenWait(false);
			} , 100);
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
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(true);
			iPageNo = 1;
			appendCondParam = FormQueryString(formObj);
//			sheetObj.DoSearch("EES_LSE_0053GS.do",FormQueryString(formObj) );
			sheetObj.DoSearch("EES_LSE_0053GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
	}
	break;
	case IBSEARCH_ASYNC02:
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH03;
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
				formObj.contract_no.value=ComGetEtcData(sXml, "ref_no");
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
	case IBSEARCH_ASYNC04:	//retrieving when input Form Lessor No.
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
	case IBSEARCHAPPEND:
		if(sheetObj.id == "sheet2") {
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("EES_LSE_0053GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
			ComOpenWait(false);
		}
		break;
	case IBSEARCH_ASYNC08:
		formObj.f_cmd.value=SEARCH01;
		var intgCdId='CD30029';
		var param="&intgCdId="+intgCdId;
		var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
		var chk=xml.indexOf("ERROR");
		if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
		   sheetObj.LoadSearchData(xml,{Sync:1} );
		   return;
	    } 
		if (xml != "") {
			var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
			var arrStr=sCntrMtrlCdNm.split("@");					
			var arrCode=arrStr[0].split("|");
			formObj.pagerows.value=arrCode[0];
		}
		break;
	}
}
/**
 * handling process for Sheet
 */    
function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
	switch(sAction) {
	case IBSEARCHAPPEND:
		if(!validateForm(sheetObj,formObj,sAction)) return;
        sheetObj.SetWaitImageVisible(0);
        ComOpenWait(true);
        setTimeout( function () {	        	
        	sheetObjects[1].SetWaitImageVisible(0);				
			sheetObjects[1].DoSearch("EES_LSE_0053GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
			} , 100);        	
		break;
	}
}
/*
function sheet2_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, FormQueryString(document.form), ++iPageNo);
}
*/
/**
 * calling event after retrieving Sheet
 * @param sheetObj
 * @param ErrMsg
 */
function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg) {
	sheetObj.SetWaitImageVisible(0);
	var formObj = document.form;
	var lstTotal = sheetObj.GetTotalRows();
	if (sheetObj.RowCount() < lstTotal) {
        // setting page number for APPEND retrieving
        appendPageNo=Math.ceil(sheetObj.RowCount() / formObj.pagerows.value) + 1;
        ComBtnEnable("btn_more");
    } else {
    	appendPageNo = 1;
        ComBtnDisable("btn_more");
    }	
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait1(false);    
}
/**
 * calling event after retrieving Sheet
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	with(sheetObj) {
		for(var j=0; j < LastCol(); j++) {
			SetCellText(LastRow(), j ,GetCellText(LastRow()-1, j));
		}
		sheetObj.RowDelete(LastRow()-1, false);
		sheetObj.SetMergeCell(LastRow(), 1, 1, 3);
		sheetObj.SetCellText(LastRow(), "lstm_cd" ,"G.TTL");
		
		if ( ErrMsg == "" ) {
			var viewColCount = 0;
            for ( var i=sheetObj.FrozenCol ; i < sheetObj.LastCol()-1 ; i++ ) {
                var sum=eval('sheetObj.ComputeSum("|'+i+'|");');
                if ( sum == 0 ) {
                    sheetObj.SetColHidden(i,1);
                } else {
                    sheetObj.SetColHidden(i,0);
                    sheetObj.SetColWidth(i, 50);
                    viewColCount++;
                }
            }
            sheetObj.SetSheetWidth(470 + (viewColCount * 50));
        }
	}
}
/**
 * handling event in case of Scroll-Next sheet<br>
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 */
//method change[check again]CLT function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
//}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:
			var periodStdt=formObj.period_stdt.value;
			periodStdt=periodStdt.replaceStr("-","");
			var periodEtdt=formObj.period_eddt.value;
			periodEtdt=periodEtdt.replaceStr("-","");
			if ( periodStdt == "" ) {
				ComShowCodeMessage("LSE01010");
				ComSetFocus(formObj.period_stdt);
				return false;
				break;
			}
			if ( periodEtdt == "" ) {
				ComShowCodeMessage("LSE01011");
				ComSetFocus(formObj.period_eddt);
				return false;
				break;
			}
			if ( Number(periodStdt) > Number(periodEtdt)) {
				ComShowCodeMessage("LSE01051");
				formObj.period_eddt.value="";
				ComSetFocus(formObj.period_eddt);
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
		//checking number
		ComChkObjValid(obj);
		break;
	case "period_eddt":
		//checking number
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//checking number
		ComChkObjValid(obj);
		break;
	case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.contract_no.value="";
		}
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value="";
			document.form.abbr_nm.value="";
		}
		break;
	default:
		//checking Validation
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
			//only upper case, special characters, number - TP/SZ
//no support[check again]CLT 			ValidChar(2,3);
		}
		break;
	}
}
/**
 * handling event in case of OnCheckClick combo1
 * @return
 */
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
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

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
 * handling event in case of OnCheckClick combo1
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
	if ( type == "2") {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	} else if ( type == "3") {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
	}
}
/**
 * handling process for Currency Pop-up Return Value<br>
 * @param Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
		ComSetObjValue(formObj.contract_no, aryPopupData[0][6]);
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
		formObj.abbr_nm.value=aryPopupData[0][5];
	}
}
/**
 * handling event in case of Change
 */
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
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
	case "loc_cd":		//Location Code
	if ( ComTrim(obj.value) != "" ) {
		if(document.form.loc_tp.value == "Y" ) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
		} else if(document.form.loc_tp.value == "C" ) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC07);
		} else if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L" || document.form.loc_tp.value == "S"){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
		}
	}
	break;
	case "loc_tp":		//Location Type
	formObj.loc_cd.value="";
	if(obj.value == "") {
		formObj.loc_cd.readOnly=true;
		formObj.loc_cd.className="input2";
		ComEnableObject(formObj.btns_search1, false);
		sheetObjects[0].SetCellText(0, 1 ,"RCC");
	} else {
		formObj.loc_cd.readOnly=false;
		formObj.loc_cd.className="input";
		ComEnableObject(formObj.btns_search1, true);
		if(obj.value == "Y"){
			formObj.loc_cd.maxLength=7;
		}else if(obj.value == "C"){
			formObj.loc_cd.maxLength=2;
		}else if(obj.value == "R"){
			formObj.loc_cd.maxLength=5;
			sheetObjects[0].SetCellText(0, 1 ,"RCC");
		}else if(obj.value == "L"){
			formObj.loc_cd.maxLength=5;
			sheetObjects[0].SetCellText(0, 1 ,"LCC");
		}else if(obj.value == "S"){
			formObj.loc_cd.maxLength=5;
			sheetObjects[0].SetCellText(0, 1 ,"SCC");
		}else{
			formObj.loc_cd.maxLength=5;
			sheetObjects[0].SetCellText(0, 1 ,"RCC");
		}
		ComSetNextFocus(obj);
	}
	break;
	case "period_stdt":		//Location Code
	if(formObj.period_eddt.value != ""){
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	}
	break;
	case "period_eddt":		//Location Code
	checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
	break;
	}
}
/**
 * sheet1_OnDblClick
 * handling event in case of double-click sheet
 */
function sheet1_OnDblClick(sheet_obj , Row, Col, CellX, CellY, CellW, CellH) {
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sRow=sheetObject1.GetSelectRow();
	var sCol=sheetObject1.GetSelectCol();
	if(sRow == sheetObject1.LastRow()){
		//return;
	}
	var vLstmCd=sheetObject1.GetCellText(sRow , "lstm_cd");
	formObj.detail_lstm_cd.value=vLstmCd == "G.TTL" ? "" : vLstmCd;
	if(sCol <= 1){
		formObj.detail_vndr_seq.value="";
	}else{
		if(sheetObject1.GetCellText(sRow , "vndr_seq") == "S.TTL"){
			formObj.detail_vndr_seq.value="";
		}else{
			formObj.detail_vndr_seq.value=sheetObject1.GetCellText(sRow , "vndr_seq");
		}
	}
	if(sCol > 4){
		formObj.detail_cntr_tpsz_cd.value=sheetObject1.GetCellText(0 , sCol);
	}else{
		formObj.detail_cntr_tpsz_cd.value="";
	}
	sheetObjects[1].RemoveAll();
	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
}
/**
* sheet1_OnMouseDown
* handling event in case of Mouse-Down sheet
*/
function sheet1_OnMouseDown(sheet_obj , Button, Shift, X, Y) {
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sRow=sheetObject1.MouseRow();
	var sCol=sheetObject1.MouseCol();
	if(sRow > sheetObject1.HeaderRows()&& sRow == sheetObject1.LastRow()){
		var vLstmCd=sheetObject1.GetCellText(sRow , "lstm_cd");
		formObj.detail_lstm_cd.value=vLstmCd == "G.TTL" ? "" : vLstmCd;
		if(sCol <= 1){
			formObj.detail_vndr_seq.value="";
		}else{
			if(sheetObject1.GetCellText(sRow , "vndr_seq") == "S.TTL"){
				formObj.detail_vndr_seq.value="";
			}else{
				formObj.detail_vndr_seq.value=sheetObject1.GetCellText(sRow , "vndr_seq");
			}
		}
		if(sCol > 4){
			formObj.detail_cntr_tpsz_cd.value=sheetObject1.GetCellText(0 , sCol);
		}else{
			formObj.detail_cntr_tpsz_cd.value="";
		}
		sheetObjects[1].RemoveAll();
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
	}
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
/* end of developer job */
function ComOpenWait1(flag, bOpenLayer){
    try {
        if(flag == isOpenWaitWindow ) return;
        isOpenWaitWindow = flag;
        if(flag) {
        	var waitW   = 60;
        	var waitH   = 60;
        	var waitImage = "style/images/theme_default/waiting.gif";
        	
        	var ifr = document.getElementById("waitiframe");
        	if (ifr==null){
            	$('<div class="layer_wait"> </div>').appendTo("body");
            	//$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");            	
            	//$('<IFRAME id="waitiframe" name="waitiframe" frameBorder="0" name="iFrm" src="'+waitImage+ '"scrolling="no" width="'+waitW + '" height="' + waitH + '"></IFRAME>').appendTo(".layer_wait")
    
            	$("body").prepend("<div class='layer_wait_bg'></div>");        	
        	}

        	//open wait image
        	$(".layer_wait_bg,.layer_wait").fadeIn(100);

        	//position center
        	$(".layer_wait").css({
            	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
            	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
        	});
        } else {
        	//close wait image
        	$(".layer_wait_bg,.layer_wait").fadeOut(100);
        }
    } catch(err) {ComFuncErrMsg(err.message); }
    return true;
}
