/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0060.js
*@FileTitle  : EQ Payable Charge Summary 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
//Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array();
var arrTpSz2=new Array();
//Event handler processing by button click event */
document.onclick=processButtonClick;
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerForm('change','obj_change',formObj);       
//	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
	axon_event.addListenerFormat('blur','obj_blur',formObj);         
//	axon_event.addListenerFormat('focus','obj_focus',formObj);       
//	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
}
//Event handler processing by button name */
function processButtonClick(){
	/**********/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcObj=window.event.srcElement;
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
//				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			break;
		case "btn_print":
			/*if(sheetObjects[0].RowCount()<= 0){
				return;
			}*/
			
			var fromObj=new Array();
			var rdObj=new Array();
			var parmObj=new Array();
			fromObj[0]=formObject;
			rdObj[0]=sheetObjects[0];
			// setting RD
			parmObj[0]="1";
			parmObj[1]="";
			parmObj[2]="N";
			
			if(document.form.report_type.value == "rp_0060"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0066_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0061"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0067_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0062"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0068_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0063"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0069_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0064"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0070_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}else if(document.form.report_type.value == "rp_0065"){
				ComOpenPopupWithTarget('/opuscntr/EES_LSE_0071_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
			}
			break;
		case "btn_New":
			obj_newchange();
			formObject.search_tp[0].selected=true;
			formObject.period_stdt.value="";
			formObject.period_eddt.value="";
			formObject.period_year.value="";
			formObject.payable[0].selected=true;
			formObject.agmt_seq.value="";
			formObject.contract_no.value="";
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			formObject.abbr_nm.value="";
			formObject.loc_cd.value="";
			formObject.loc_tp[0].selected=true;
			ComEnableObject(document.form.btns_search1, false);
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
				comboObjects[0].SetItemCheck(i,0);
			}
			comboObjects[0].SetItemCheck(0,1);
			formObject.lstm_cd.value="";
			for(var i=1 ; i < comboObjects[1].GetItemCount(); i++ ){
				comboObjects[1].SetItemCheck(i,0);
			}
			comboObjects[1].SetItemCheck(0,1);
			formObject.cntr_tpsz_cd.value="";
			for(var i=1 ; i < comboObjects[2].GetItemCount(); i++ ){
				comboObjects[2].SetItemCheck(i,0);
			}		
			comboObjects[2].SetItemCheck(0,1);
			for(var i=1 ; i < comboObjects[3].GetItemCount(); i++ ){
				comboObjects[3].SetItemCheck(i,0);
			}		
			comboObjects[3].SetItemCheck(0,1);			
			formObject.charge_type_cd.value="";
			if(document.form.report_type.value == "rp_0061" || document.form.report_type.value == "rp_0063" || document.form.report_type.value == "rp_0064" ){
				document.form.period_year.focus();
			}else{
				document.form.period_stdt.focus();
			}
			break;
		case "btns_calendar1":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('year');
				cal.select(formObject.period_year, "yyyy");
			}
			break;
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_stdt, "yyyy-MM");
			}
			break;
		case "btns_calendar3":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_eddt, "yyyy-MM");
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
		case "btn_DownExcel":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
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


function obj_newchange(){
	document.form.report_type.value = "rp_0060";
	var formObj=document.form;
	/*sheet1.Reset();
	sheet1.RenderSheet(0);
	initSheet(sheet1, 1);
	sheet1.RenderSheet(1);
	sheet1.RemoveAll();*/
	sheetObjects[0] = sheet1.Reset();
	sheetObjects[0].RenderSheet(0);
	initSheet(sheetObjects[0],1);
	sheetObjects[0].RenderSheet(1);
	sheetObjects[0].RemoveAll();
	document.form.period_stdt.value="";
	document.form.period_eddt.value="";
	document.form.period_year.value="";
	
	var OBJ1=document.getElementById("fixLayer1");
	OBJ1.style.visibility="visible";
	var OBJ2=document.getElementById("fixLayer2");
	OBJ2.style.visibility="hidden";
	document.form.temp_text1.focus();
	document.form.period_stdt.focus();

	for(var i=1 ; i < comboObjects[2].GetItemCount(); i++ ){
		comboObjects[3].SetItemCheck(i,0);
	}
	comboObjects[3].SetItemCheck(0,1);
	comboObjects[3].SetEnable(0);
	document.form.loc_cd.value="";
	document.form.loc_tp[0].selected=true;
    ComEnableObject(document.form.btns_search1, false);
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
	initControl();
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
	//initSheet(sheetObjects[0],1);
	comboObjects[1].SetItemCheck(0,1);
	var OBJ=document.getElementById("fixLayer1");
	OBJ.style.visibility="visible";
	document.form.period_stdt.focus();
	comboObjects[0].InsertItem(0, 'ALL' , 'ALL');
	comboObjects[0].InsertItem(1, 'LT' , 'LT');
	comboObjects[0].InsertItem(2, 'ST' , 'ST');
	comboObjects[0].InsertItem(3, 'OF' , 'OF');
	comboObjects[0].InsertItem(4, 'SI' , 'SI');
	comboObjects[0].InsertItem(5, 'SO' , 'SO');
	comboObjects[0].InsertItem(6, 'MI' , 'MI');
	comboObjects[0].InsertItem(7, 'MO' , 'MO');
	comboObjects[0].InsertItem(8, 'SH' , 'SH');
	comboObjects[0].InsertItem(9, 'LP' , 'LP');
	comboObjects[0].InsertItem(10, 'OL' , 'OL');
	comboObjects[0].InsertItem(11, 'OW' , 'OW');
	comboObjects[0].SetItemCheck(0,1);
	comboObjects[3].InsertItem(0, 'ALL' , 'ALL');
	comboObjects[3].InsertItem(1, 'OPL' , 'OPL');	
	comboObjects[3].InsertItem(2, 'PDM' , 'PDM');
	comboObjects[3].InsertItem(3, 'PUC' , 'PUC');
	comboObjects[3].InsertItem(4, 'PCR' , 'PCR');
	comboObjects[3].InsertItem(5, 'LON' , 'LON');
	comboObjects[3].InsertItem(6, 'LOF' , 'LOF');
	comboObjects[3].InsertItem(7, 'DOC' , 'DOC');
	comboObjects[3].InsertItem(8, 'DCR' , 'DCR');
	comboObjects[3].InsertItem(9, 'DII' , 'DII');
	comboObjects[3].InsertItem(10, 'DIO' , 'DIO');
	comboObjects[3].InsertItem(11,'DPP' , 'DPP');
	comboObjects[3].InsertItem(12,'WDP' , 'WDP');
	comboObjects[3].InsertItem(13,'GTI' , 'GTI');
	comboObjects[3].InsertItem(14,'GTO' , 'GTO');
	comboObjects[3].InsertItem(15,'OPL' , 'OPL');
	comboObjects[3].InsertItem(16,'CRD' , 'CRD');
	comboObjects[3].InsertItem(17,'OTH' , 'OTH');
	comboObjects[3].SetItemCheck(0,1);
	comboObjects[3].SetEnable(0);
	document.form.loc_cd.readOnly=true;
	document.form.loc_cd.className="input2";
	ComEnableObject(document.form.btns_search1, false);
	//sheetObjects[0].CellText(0, 1) = "RCC";

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
			if(document.form.report_type.value == "rp_0060"){
			    var HeadTitle="sta|Lessor|Lessor|Currency|TP/SZ|QTY|G.TTL|OPL|PDM|Pick-Up|Pick-Up|Pick-Up|Handle Charge|Handle Charge|Handle Charge|Drop Off|Drop Off|Drop Off|Direct|Direct|Direct|DPP|Gate In/Out Only|Gate In/Out Only|Gate In/Out Only|WDP|CRD|OTH|";
			    var HeadTitle2="sta|Lessor|Lessor|Currency|TP/SZ|QTY|G.TTL|OPL|PDM|PUC|PCR|S.TTL|HON|HOF|S.TTL|DOC|DCR|S.TTL|DII|DIO|S.TTL|DPP|GTI|GTO|S.TTL|WDP|CRD|OTH|";
			    var headCount=ComCountHeadTitle(HeadTitle);

			    SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

			    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",   Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",        Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",        Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",        Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",        Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"qty",           KeyField:0,   CalcLogic:"",   Format:"Integer" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"g_ttl",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"opl",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pdm",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"puc",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pcr",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_1",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lon",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lof",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"doc",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dcr",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_3",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dii",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dio",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dpp",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"gti",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"gto",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_5",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"wdp",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"crd",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"oth",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
//			              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"auto_sum",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			     
			    InitColumns(cols);

			    SetEditable(0);
//			    SetColHidden("auto_sum",1);
			    FrozenCols=6;
			    SetSelectRow(0);
			    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			    //SetMergeCell(0, 1, 2, 2);
			    //SetSheetHeight(320);
			    resizeSheet();
			}else if(document.form.report_type.value == "rp_0061"){

                var HeadTitle="sta|TP/SZ|Currency|Month|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var HeadTitle2="sta|TP/SZ|Currency|DIV|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
                var headCount=ComCountHeadTitle(HeadTitle);
                for(var j=0; j < 3; j ++) {

                SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
					{ Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
					
                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"div",           KeyField:0,   CalcLogic:"",   Format:"" },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"g_ttl",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"jan",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"feb",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mar",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_1",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"apr",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"may",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"jun",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"jul",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"aug",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"sep",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_3",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"oct",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"nov",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dec",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
					{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 }];
					//{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"auto_sum",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                InitColumns(cols);

                SetEditable(0);
               }
                //SetColHidden("auto_sum",1);
                FrozenCols=4;
                SetSelectRow(0);
                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
                //SetSheetHeight(320);
                resizeSheet();
			}else if(document.form.report_type.value == "rp_0062"){

			    var HeadTitleTemp="";
			    for(var i=0; i<arrTpSz.length; i++){
			    HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i];
			    }
			    var HeadTitle="sta|Charge Type|Currency|TP/SZ|G.TTL" + HeadTitleTemp +"|";
			    var HeadTitle2="sta|Charge Type|Currency|DIV|G.TTL" + HeadTitleTemp +"|";
			    var headCount=ComCountHeadTitle(HeadTitle);
			    //(headCount, 0, 0, true);
			    for(var j=0; j < 3; j ++) {
			    cnt=0;

			    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"charge_type",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"div",          KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"g_ttl",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			    for(var i=0; i<arrTpSz2.length; i++){
			    	cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
			    }
			    //cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
			  
			    InitColumns(cols);

			    SetEditable(0);
			       }
			    //SetColHidden("auto_sum",1);
			    FrozenCols=4;
			    SetSelectRow(0);
			    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			    //SetSheetHeight(320);
			    resizeSheet();
			}else if(document.form.report_type.value == "rp_0063"){

			    var HeadTitle="sta|Term|Currency|Month|Month|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
			    var HeadTitle2="sta|Term|Currency|Lessor|Lessor|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
			    var headCount=ComCountHeadTitle(HeadTitle);
//			    (headCount, 0, 0, true);

			    SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"abbr_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"g_ttl",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jan",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"feb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mar",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_1",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"apr",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"may",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jun",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_2",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jul",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"aug",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sep",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_3",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"oct",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nov",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dec",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_4",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 }];
			              //{Type:"Float",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			              //{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			     
			    InitColumns(cols);

			    SetEditable(0);
			    SetColHidden("auto_sum",1);
			    FrozenCols=5;
			    SetSelectRow(0);
			    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			    //SetSheetHeight(320);
			    resizeSheet();
			}else if(document.form.report_type.value == "rp_0064"){

			    var HeadTitle="sta|Month|Month|Currency|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
			    var HeadTitle2="sta|Lessor|Lessor|Currency|G.TTL|Jan|Feb|Mar|1/4 TTL|Apr|May|Jun|2/4 TTL|Jul|Aug|Sep|3/4 TTL|Oct|Nov|Dec|4/4 TTL|";
			    var headCount=ComCountHeadTitle(HeadTitle);
//			    (headCount, 0, 0, true);

			    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"abbr_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"g_ttl",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jan",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"feb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mar",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_1",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"apr",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"may",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jun",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_2",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"jul",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"aug",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sep",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_3",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"oct",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nov",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dec",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_4",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 }];
			              //{Type:"Float",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			              //{Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			     
			    InitColumns(cols);

			    SetEditable(0);
			    SetColHidden("auto_sum",1);
			    FrozenCols=4;
			    SetSelectRow(0);
			    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			    //SetSheetHeight(320);
			    resizeSheet();
			}else if(document.form.report_type.value == "rp_0065"){

			    var HeadTitleTemp="";
			    for(var i=0; i<arrTpSz.length; i++){
			    HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i];
			    }
			    var HeadTitle="|Month|CHG|Currency|Lessor|Lessor|Term|Agmt No.|Total" + HeadTitleTemp +"|";
			    var headCount=ComCountHeadTitle(HeadTitle);
//			    (headCount, 0, 0, true);

			    SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",   KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"charge_type",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"g_ttl",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
			       for(var i=0; i<arrTpSz2.length; i++){
			    cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
			    } 
			       //cols.push({Type:"Float",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
			    //cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
			       
			  
			    InitColumns(cols);

			    SetEditable(0);
			    SetColHidden("auto_sum",1);
			    FrozenCols=8;
			    SetSelectRow(0);
			    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			    //SetSheetHeight(320);
			    resizeSheet();
			}
		}
		break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
	case IBSEARCH:
		if(validateForm(sheet1,formObj,sAction)){
			if (sheet1.id == "sheet1"){
				formObj.f_cmd.value=SEARCH;
//				sheet1.RenderSheet(0);
				sheet1.SetWaitImageVisible(0);
				ComOpenWait(true);
				setTimeout( function () {
					var sXml=sheet1.GetSearchData("EES_LSE_0060GS.do", FormQueryString(formObj));
					if(ComGetTotalRows(sXml) > 1) {
						sheet1.LoadSearchData(sXml,{Sync:1} );
						if(document.form.report_type.value == "rp_0060"){
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							
							for(var i=0; i<arrGRows.length;i++) {		
								if(sheet1.GetCellValue(sheet1.LastRow()-i , 1) == "G.TTL" ){
									
									sheet1.SetMergeCell(sheet1.LastRow()-i, 1, 1, 2);	//Row, Col, Rows, Cols)
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
								}
							}
							
							if(arrGRows.length > 1) {
								sheet1.SetMergeCell(sheet1.LastRow()-arrGRows.length+1, 1, arrGRows.length, 2);	//Row, Col, Rows, Cols)
							}
						}else if(document.form.report_type.value == "rp_0061"){
							
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							
							for(var i=0; i<arrGRows.length;i++) {		
								if(sheet1.GetCellValue(sheet1.LastRow()-i , 1) == "G.TTL" ){
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
									
									/*for(var i=sheet1.LastRow()-5; i < sheet1.LastRow()-2; i++) {
										sheet1.SetCellAlign(i +3, "div","Center");
										for(var j=0; j <= sheet1.LastCol(); j++) {
											sheet1.SetCellFont("FontBold", sheet1.LastRow()-2,j,sheet1.LastRow(),sheet1.LastCol(),1);
											sheet1.SetCellFontColor(i +3, j ,"#DC0000");
										}
									}*/
									
								}
							}
						}else if(document.form.report_type.value == "rp_0062"){
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							
							for(var i=0; i<arrGRows.length;i++) {		
								if(sheet1.GetCellValue(sheet1.LastRow()-i , 1) == "G.TTL" ){
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
									
									/*for(var i=sheet1.LastRow()-5; i < sheet1.LastRow()-2; i++) {
										sheet1.SetCellAlign(i +3, "div","Center");
										for(var j=0; j <= sheet1.LastCol(); j++) {
											sheet1.SetCellFont("FontBold", sheet1.LastRow()-2,j,sheet1.LastRow(),sheet1.LastCol(),1);
											sheet1.SetCellFontColor(i +3, j ,"#DC0000");
										}
									}*/
									
								}
							}
						}else if(document.form.report_type.value == "rp_0063"){
							var strRows=ComFindAll(sheet1, 2, "S.TTL");
							strRows=strRows + "";
							arrRows=strRows.replaceStr("|", ",").split(",");
							for( var i=0 ; i < arrRows.length ; i++ ){
								sheet1.SetMergeCell(arrRows[i] , 2, 2, 2);
							}
							
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							for( var i=0 ; i < arrGRows.length ; i++ ){
								sheet1.SetMergeCell(arrGRows[i] , 2, 2, 2);
							}				
							
							for(var i=0; i<arrGRows.length;i++) {								
								if(sheet1.GetCellValue(sheet1.LastRow()-i , 1) == "G.TTL" ){
									/*for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellText(sheet1.LastRow(), j ,sheet1.GetCellText(sheet1.LastRow()-1, j));
									}*/
									
									//sheet1.SetRowHidden(sheet1.LastRow()-i,1);		//Row,Hidden
									sheet1.SetMergeCell(sheet1.LastRow()-i, 2, 1, 3);	//Row, Col, Rows, Cols)
									sheet1.SetCellText(sheet1.LastRow()-i, 1 ,"G.TTL");
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
									//sheet1.InitCellProperty(sheet1.LastRow()-i,"auto_sum",{ Type:"AutoSum"} );
								}
							}
							
						}else if(document.form.report_type.value == "rp_0064"){
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							
							for(var i=0; i<arrGRows.length;i++) {		
								if(sheet1.GetCellValue(sheet1.LastRow()-i, 1) == "G.TTL" ){
									/*for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellText(sheet1.LastRow(), j ,sheet1.GetCellText(sheet1.LastRow()-1, j));
									}*/
									//sheet1.SetRowHidden(sheet1.LastRow()-1,1);
									sheet1.SetMergeCell(sheet1.LastRow()-i, 1, 1, 2);
									sheet1.SetCellText(sheet1.LastRow()-i, 1 ,"G.TTL");
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
									//sheet1.RowBackColor(sheet1.LastRow) = LSE_TOTCOL_BACK_COLOR;
								}
							}
							
							if(arrGRows.length > 1) {
								sheet1.SetMergeCell(sheet1.LastRow()-arrGRows.length+1, 1, arrGRows.length, 2);	//Row, Col, Rows, Cols)
							}
							
						}else if(document.form.report_type.value == "rp_0065"){
							var arrGRows = "";
							var strGRows=ComFindAll(sheet1, 1, "G.TTL");
							strGRows=strGRows + "";
							arrGRows=strGRows.replaceStr("|", ",").split(",");
							
							for(var i=0; i<arrGRows.length;i++) {		
								if(sheet1.GetCellValue(sheet1.LastRow()-i, 1) == "G.TTL" ){
									/*for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellText(sheet1.LastRow(), j ,sheet1.GetCellText(sheet1.LastRow()-1, j));
									}
									sheet1.SetRowHidden(sheet1.LastRow()-1,1);*/
									sheet1.SetMergeCell(sheet1.LastRow()-i, 1, 1, 2);
									sheet1.SetMergeCell(sheet1.LastRow()-i, 3, 1, 5);
									sheet1.SetCellText(sheet1.LastRow()-i, 1 ,"G.TTL");
									sheet1.SetRowBackColor(sheet1.LastRow()-i,"#EAF1FB")
									sheet1.SetRowFontColor(sheet1.LastRow()-i,"#F30")
									for(var j=0; j < sheet1.LastCol(); j++) {
										sheet1.SetCellFontBold(sheet1.LastRow()-i,j,1)
									}
									//sheet1.RowBackColor(sheet1.LastRow) = LSE_TOTCOL_BACK_COLOR;
								}
							}
							
							if(arrGRows.length > 1) {
								sheet1.SetMergeCell(sheet1.LastRow()-arrGRows.length+1, 1, arrGRows.length, 2);	//Row, Col, Rows, Cols)
							}
							
						}
					} else {
						//sheet1.LoadSearchData("<SHEET><DATATOTAL='0'></DATA></SHEET>",{Sync:1} );
	//					sheet1.LoadSearchData(sXml,{Sync:0} );
						sheet1.LoadSearchData("<SHEET><DATA  TOTAL='0'></DATA><ETC-DATA><ETC KEY='Exception'><![CDATA[]]></ETC><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC></ETC-DATA></SHEET>",{Sync:0} );
					}
					ComOpenWait(false);
				} , 100);
//				sheet1.RenderSheet(1);
			}
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
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd")+"|XX|BX"; //2010.10.20 XX,BX Code추가
			LseComText2ComboItem(comboObjects[1] , "XX|BX","XX|BX","|");
			formObj.tysz.value=vOrcCntrTpszCd;
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");			
		}

		formObj.f_cmd.value=SEARCH09;	
		var intgCdId='CD30090';
		var param="&intgCdId="+intgCdId;
		var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
		var chk=xml.indexOf("ERROR");
		if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
		   sheetObj.LoadSearchData(xml,{Sync:1} );
		   return;
	    } 
		if (xml != "") {
			var schargeType=ComGetEtcData(xml, "code_nm");
			var arrchargeType=schargeType.split("@");
			MakeComboObject(comboObjects[2], arrchargeType, 1, 0);
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
				if(ComGetEtcData(sXml, "lstm_cd") != "OW" && ComGetEtcData(sXml, "lstm_cd") != "LP" && ComGetEtcData(sXml, "lstm_cd") != "OL" ){
					formObj.contract_no.value=ComGetEtcData(sXml, "ref_no");
					comboObjects[0].SetItemCheck(0,0);
					comboObjects[0].CheckCode(ComGetEtcData(sXml, "lstm_cd"))=true;
					formObj.lstm_cd.value=ComGetEtcData(sXml, "lstm_cd");
					formObj.vndr_seq.value=ComGetEtcData(sXml, "vndr_seq");
					formObj.abbr_nm.value=ComGetEtcData(sXml, "vndr_abbr_nm");
					formObj.vndr_nm.value=ComGetEtcData(sXml, "vndr_lgl_eng_nm");
				}else{
					ComShowCodeMessage("LSE01007");
					formObj.agmt_seq.value="";
					formObj.contract_no.value="";
					ComSetFocus(formObj.agmt_seq);
				}
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
	case IBSEARCH_ASYNC05:	// retrieving for Location
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
	case IBSEARCH_ASYNC06:	// retrieving for Yard
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var param="f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
			+ "&mode=yard";
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
			sheetObj.SetWaitImageVisible(1);
			var rowCnt=ComGetTotalRows(sXml);
			if ( ComGetTotalRows(sXml) > 0 ) {
				ComSetFocus(formObj.loc_cd);
			} else {
				ComShowCodeMessage("LSE01048");
				formObj.loc_cd.value="";
				ComSetFocus(formObj.loc_cd);
			}
		}
	}
	break;
	case IBSEARCH_ASYNC07:	// retrieving for Country
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var param="f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
			sheetObj.SetWaitImageVisible(1);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
						formObj.loc_cd.value=ComGetEtcData(sXml, "loc_cd") ;
					}else{
						ComShowCodeMessage("LSE01048");
						formObj.loc_cd.value="";
						ComSetFocus(formObj.loc_cd);
					}
				}else{
					ComShowCodeMessage("LSE01048");
					formObj.loc_cd.value="";
					ComSetFocus(formObj.loc_cd);
				}
			}else{
				ComShowCodeMessage("LSE01048");
				formObj.loc_cd.value="";
				ComSetFocus(formObj.loc_cd);
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
			/*if(document.form.report_type.value == "rp_0061" || document.form.report_type.value == "rp_0063" || document.form.report_type.value == "rp_0064" ){
				var periodYear=formObj.period_year.value;
				if ( periodYear.length != 4 ) {
					ComShowCodeMessage("LSE01010");
					ComSetFocus(formObj.period_year);
					return false;
					break;
				}
			}else{*/
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
				if( periodStdt != "" &&  ComGetMaskedValue(periodStdt, "ym") != "" ){
				    if ( periodEtdt == "" ) {
					    ComShowCodeMessage("LSE01011");
					    ComSetFocus(formObj.period_eddt);
					    return false;
					    break;
				    }
				}
				//if(document.form.report_type.value == "rp_0060" || document.form.report_type.value == "rp_0062" || document.form.report_type.value == "rp_0065" ){
					if(document.form.period_eddt.value != ""){
						var chk=checkDatePeriod(document.form.period_stdt , document.form.period_eddt , "ym") ;
						if(chk == false){
							return false;
							break;
						}
					}
				//}
				//if(document.form.report_type.value == "rp_0060" || document.form.report_type.value == "rp_0062" || document.form.report_type.value == "rp_0065" ){
					var chk=checkDatePeriod(document.form.period_stdt , document.form.period_eddt , "ym") ;
					if(chk == false){
						return false;
						break;
					}
				//}
				if ( periodStdt.length == 6 && periodEtdt.length == 6 && Number(periodStdt) > Number(periodEtdt)) {
					ComShowCodeMessage("LSE01051");
					formObj.period_eddt.value="";
					ComSetFocus(formObj.period_eddt);
					return false;
					break;
				}
			//}
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
		//ComChkObjValid(obj);
		ComAddSeparator(event.srcElement);
		break;
	case "period_eddt":
		//checking number
		//ComChkObjValid(obj);
		ComAddSeparator(event.srcElement);
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
//no support[check again]CLT 				ValidChar(2,2);
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
//no support[check again]CLT 				ValidChar(2,3);
			}
			break;
		case "combo3":
			with(comboObj) {
				SetDropHeight(250);
				SetMultiSelect(1);
				//MaxSelect = 1;
				SetMultiSeparator(",");
				Style=0;
				SetUseAutoComplete(1);
				//영문(대)+특수문자
//no support[check again]CLT 				ValidChar(2,2);
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
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
}
/**
 * handling event in case of OnCheckClick combo1
 * @return
 */
function combo3_OnCheckClick(comboObj, index, code) {
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
 * combo3_OnBlur
 */
function combo3_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if( comboObj.GetItemCheck(0)){
		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
			comboObj.SetItemCheck(i,0);
		}
		formObj.charge_type_cd.value="";
	}else if(comboObj.GetSelectText()== ""){
		comboObj.SetItemCheck(0,1);
		formObj.charge_type_cd.value="";
	}else{
	    formObj.charge_type_cd.value=ComGetObjValue(comboObj);
	}
}
/**
 * combo3_OnKeyDown
 */
function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
			comboObj.SetSelectText("");
		}else if(KeyCode == 13){
 		    sheetObjects[0].RemoveAll();
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
		switch(formObj.loc_tp.value) {
		case "R" :	//RCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "L" :	//LCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "S" :	//SCC
		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
		break;
		case "Y" :	//Yard
		ComOpenPopup("/opuscntr/COM_ENS_061.do",755, 610, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
		break;
		case "C" :	//Country
		ComOpenPopup("/opuscntr/COM_ENS_0M1.do",610, 510, 'getCOM_ENS_0M1_2', "1,0,1,1,1,1,1", true);
		break;
		default : 	//do nothing
		}
	} else if ( type == "2") {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	} else if ( type == "3") {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
	}
}
/**
* handling process for DeliveryLoc(Country) Pop-up Return Value<br>
* @param Return value array
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
* handling process for DeliveryLoc(Yard) Pop-up Return Value<br>
* @param Return value array
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
* handling process for Currency Pop-up Return Value<br>
* @param Return value array
* @param Row index
* @param Col index
* @param Sheet Array index
*/
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if( aryPopupData.length > 0 ) {
		var lstmCd = aryPopupData[0][6];
		if(lstmCd != "OW" && lstmCd != "LP" && lstmCd != "OL" ){
			formObj.agmt_seq.value = aryPopupData[0][5];
			formObj.contract_no.value = aryPopupData[0][6];
			comboObjects[0].SetSelectCode(aryPopupData[0][7], true);
			//comboObjects[0].SetItemCheck(0,0);
			//formObj.vndr_seq.value=aryPopupData[0][8];
			//formObj.abbr_nm.value=aryPopupData[0][13];
			//formObj.vndr_nm.value=aryPopupData[0][8];
		}
	}
}
/**
* handling process for Lessor(Service Provider) Pop-up Return Value <br>
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
		    //if(document.form.report_type.value == "rp_0060" ){
		    //    sheetObjects[0].CellText(0, 1) = "RCC";
		    //    sheetObjects[0].CellText(0, 2) = "RCC";
		    //}
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
		    }else if(obj.value == "L"){
			    formObj.loc_cd.maxLength=5;
		    }else if(obj.value == "S"){
			    formObj.loc_cd.maxLength=5;
		    }else{
			   formObj.loc_cd.maxLength=5;
		    }
		    ComSetNextFocus(obj);
	    }
	break;
	case "period_stdt":		//Location Code
	if(document.form.report_type.value == "rp_0060" || document.form.report_type.value == "rp_0062" || document.form.report_type.value == "rp_0065" ){
		if(formObj.period_stdt.value != "" && formObj.period_eddt.value != ""){
			var chk=period_termchk(formObj.period_stdt.value ,  formObj.period_eddt.value);
    		if(Number(chk) > 12){
    			ComShowCodeMessage("LSE01146");
    		    formObj.period_eddt.value="";
    		    ComSetFocus(formObj.period_eddt);
		        return;
		    }
			checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
		}
	}
	break;
	case "period_eddt":		//Location Code
	if(document.form.report_type.value == "rp_0060" || document.form.report_type.value == "rp_0062" || document.form.report_type.value == "rp_0065" ){
		var chk=period_termchk(formObj.period_stdt.value ,  formObj.period_eddt.value);
    	if(formObj.period_stdt.value != "" && formObj.period_eddt.value != "" && Number(chk) > 12){
    		ComShowCodeMessage("LSE01146");
    	    formObj.period_eddt.value="";
    	    ComSetFocus(formObj.period_eddt);
    	    return;
    	}
		checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
	}
	break;
	case "report_type":		//Location Code
	/*sheet1.Reset();
	sheet1.RenderSheet(0);
	initSheet(sheet1, 1);
	sheet1.RenderSheet(1);
	sheet1.RemoveAll();*/	
	sheetObjects[0] = sheet1.Reset();
	sheetObjects[0].RenderSheet(0);
	initSheet(sheetObjects[0],1);
	sheetObjects[0].RenderSheet(1);
	sheetObjects[0].RemoveAll();
	
	document.form.search_tp[0].selected=true;
	document.form.period_stdt.value="";
	document.form.period_eddt.value="";
	document.form.period_year.value="";
	if(document.form.report_type.value == "rp_0061" || document.form.report_type.value == "rp_0063" || document.form.report_type.value == "rp_0064" ){
		var OBJ1=document.getElementById("fixLayer1");
		OBJ1.style.visibility="visible";
		var OBJ2=document.getElementById("fixLayer2");
		OBJ2.style.visibility="hidden";
		document.form.temp_text1.focus();
		document.form.period_stdt.focus();
	}else{
		var OBJ1=document.getElementById("fixLayer1");
		OBJ1.style.visibility="visible";
		var OBJ2=document.getElementById("fixLayer2");
		OBJ2.style.visibility="hidden";
		document.form.temp_text1.focus();
		document.form.period_stdt.focus();
	}
	if(document.form.report_type.value == "rp_0060" ){
		for(var i=1 ; i < comboObjects[3].GetItemCount(); i++ ){
			comboObjects[3].SetItemCheck(i,0);
		}
		comboObjects[3].SetItemCheck(0,1);
		comboObjects[3].SetEnable(0);
		//sheetObjects[0].CellText(0, 1) = "RCC";
		//sheetObjects[0].CellText(0, 2) = "RCC";
		document.form.loc_cd.value="";
		document.form.loc_tp[0].selected=true;
        ComEnableObject(document.form.btns_search1, false);
	}else if(document.form.report_type.value == "rp_0065" ){
		for(var i=1 ; i < comboObjects[3].GetItemCount(); i++ ){
			comboObjects[3].SetItemCheck(i,0);
		}
		comboObjects[3].SetItemCheck(0,1);
		comboObjects[3].SetEnable(0);
	}else{
		comboObjects[3].SetEnable(1);
	}
	break;
	case "search_tp":		//Location Type
		sheetObjects[0].RemoveAll();
		break;
	}
}

/**
 * sheet1_OnSearchEnd
 * calling event after retrieving Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//document.form.detail_text.value =  document.form.loc_tp.text + " : " + document.form.loc_cd.value  + "    " + document.form.period_stdt.value + " - " + document.form.period_eddt.value;
	
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "sheet1":
		with (sheetObj) {
			if (RowCount()> 0) {
				if(document.form.report_type.value == "rp_0060"){
					//RowDelete(LastRow()-1);
					//SetSumText(0, "vndr_seq","G.TTL");
				}
			}
		}
	}
}
/**
 * calculating month of start date and end date
 */
function period_termchk(stDt , endDt){
   var stYear=stDt.substr(0,4);
   var stMonth="";
   if(stDt.length == 6){
	   stMonth=stDt.substr(4,6);
   }else{
	   stMonth=stDt.substr(5,7);
   }
   var endYear=endDt.substr(0,4);
   var endMonth="";
   if(endDt.length == 6){
	   endMonth=endDt.substr(4,6);
   }else{
	   endMonth=endDt.substr(5,7);
   }
   var sdate=new Date(stYear,Number(stMonth),1);
   var edate=new Date(endYear,Number(endMonth),1);
   var sDate=sdate.getDate();
   var count=0;
   while (Date.parse(edate)>=Date.parse(sdate)) {
      if(sdate.getDate() == sDate){
         count++;
      }
      sdate.setDate(sdate.getDate()+1);
   }
   return count;
}

/**
 * creating combo object(Spec No * Type/Size)
 */
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL", "ALL");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.SetSelectIndex(0 ,true);
}  
/* end of developer job */
