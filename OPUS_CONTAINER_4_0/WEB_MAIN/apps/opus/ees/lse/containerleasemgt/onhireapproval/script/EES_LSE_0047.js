/*=========================================================
 * 

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0047.js
*@FileTitle  : Pick-up Status by Auth No
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
 * @class EES_LSE_0047 : business script for EES_LSE_0047
 */

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
	axon_event.addListenerForm('change','obj_change',formObj);       
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerFormat('blur','obj_blur',formObj);    
	axon_event.addListener('keydown', 'ComKeyEnter', 'form'); 
//	axon_event.addListenerFormat('keypress','obj_keypress',formObj);      
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
		case "btns_search1":   // onh_loc_cd Pop-up
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
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
		case "btns_search2":			 
			if ( srcObj.style.filter == "" ) {
				openPopup("2");
			}
			break;	
		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			}
			break; 
		case "btn_New":			
			sheetObject1.RemoveAll();
			sheetShowInit();
			sheetObject2.RemoveAll();
			formObject.loc_cd.value="";
			formObject.loc_tp[0].selected=true;
			formObject.period_stdt.value="";
			formObject.period_eddt.value="";
			formObject.auth_no.value="";
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
				comboObjects[0].SetItemCheck(i,0);
			}
			formObject.lstm_cd.value="";
			for(var i=1 ; i < comboObjects[1].GetItemCount(); i++ ){
				comboObjects[1].SetItemCheck(i,0);
			}
			comboObjects[0].SetItemCheck(0,1);
			comboObjects[1].SetItemCheck(0,1);
			
			sheetObjects[0].RenderSheet(0);
			for(var i=0 ; i < arrTpSz2.length ; i++){
				sheetObjects[0].SetColHidden(arrTpSz2[i],0);
				sheetObjects[0].SetColWidth(arrTpSz2[i], "80");
			}
			sheetObjects[0].RenderSheet(1);
			
			formObject.cntr_tpsz_cd.value="";
			formObject.agmt_seq.value="";
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			formObject.new_van_tp_cd[0].checked=true;
			formObject.period_stdt.focus();
			break;
		case "btn_Save":
			alert(srcName);
			break; 
		case "btn_Detail":
			alert(srcName);
			break; 				
		case "btn_downexcel_summary":
			if(sheetObject1.RowCount()<1){
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
			}
				//sheetObject1.Down2Excel(-1, false,false,true, "", "", true);
			break; 			
		case "btn_downexcel_detail":
			if(sheetObject2.RowCount()<1){
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
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
function loadPage(){
	var formObj = document.form;
	formObj.f_cmd.value=SEARCH02;
	sheetObjects[0].SetWaitImageVisible(0);
	var sXml2=sheetObjects[0].GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
	if ( sXml2 != "" ) {
		//comboObjects[1].InsertItem(0 , 'ALL','ALL'); 
		//LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
		vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");        
		formObj.tysz.value=vOrcCntrTpszCd;	
		arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
		arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
	}
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	/* initializing IBMultiCombo */
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	sheetShowInit();
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);		
	initSheet(sheetObjects[0],1);
	comboObjects[0].SetItemCheck(0,1);
	comboObjects[1].SetItemCheck(0,1);
	document.form.period_stdt.focus();
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
	case "sheet1":      //sheet2 init
	with (sheetObj) {
        var HeadTitleTemp="";
        for(var i=0; i<arrTpSz.length; i++){
        HeadTitleTemp=HeadTitleTemp + "|" + arrTpSz[i];
        }
        var HeadTitle="|Auth No.|AGMT No.|Division|Total" + HeadTitleTemp;
        var headCount=ComCountHeadTitle(HeadTitle);
        //(headCount, 0, 0, true);

        SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:2, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );

        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
			{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"auth_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"divsion",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty_total",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       for(var i=0; i<arrTpSz2.length; i++){
        cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz2[i]+"", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
        }

        InitColumns(cols);
        SetEditable(0);
        FrozenCols=5;
        SetSheetHeight(180);
	}
	break;
	case "sheet2":      //sheet1 init
	with (sheetObj) {

	    var HeadTitle="|Seq.|CNTR No.|TP/SZ|Auth No.|From Date|Due Date|AGMT No.|Lessor|On-hire\nLoc.|On-hire\nDate|MVMT|MVMT\nDate|F/days|Div|Off-hire\nLoc.|Off-hire\nDate|Using\ndays|Min\nDays";
	    var headCount=ComCountHeadTitle(HeadTitle);
	    //(headCount, 0, 0, true);

	    SetConfig( { SearchMode:2, MergeSheet:0, Page:1000, DataRowMerge:1,PrevColumnMergeMode:0 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    InitHeaders(headers, info);
	    
	    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
	              {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_auth_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_fm_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"due_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lessor",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"on_hire_loc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"on_hire_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mvnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f_days",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"div",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_loc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"using_day",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	              {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"min_days",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	     
	    InitColumns(cols);
	    SetEditable(1);
	    SetSheetHeight(180);
	}
	break;
	}
}
//handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
	case IBSEARCH:      //조회
	if(validateForm(sheetObj,formObj,sAction)){
		
		var auth_val = formObj.auth_no.value;
		var lstm_val = formObj.lstm_tp_cd.value;
		// Term과 Auth #의 lease term이 일치하는지 확인
		if(auth_val != '') {
			if(auth_val.length == 20) {
				if (auth_val.substring(9,11) == "MO" || auth_val.substring(9,11) == "SO") {
					if(lstm_val != "L") {
						ComShowCodeMessage("LSE10035");
						auth_val="";
						return;
					}
				} else {
					if(lstm_val != "O") {
						ComShowCodeMessage("LSE10035");
						auth_val="";
						return;
					}
				}
			} else {
				if (auth_val.substring(3,5) == "MO" || auth_val.substring(3,5) == "SO") {
					if(lstm_val != "L") {
						ComShowCodeMessage("LSE10035");
						auth_val="";
						return;
					}
				} else {
					if(lstm_val != "O") {
						ComShowCodeMessage("LSE10035");
						auth_val="";
						return;
					}
				}
			}
		}
		if(formObj.combo1.value == "") {
			formObj.lstm_cd.value = "";
			if(lstm_val == "O") {
				formObj.lstm_cd.value = 'ST,LT,OF,SI,MI';
			} else {
				formObj.lstm_cd.value = 'SO,MO';
			}
		}
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		setTimeout( function () {
			var sXml = sheetObj.GetSearchData("EES_LSE_0047GS.do",FormQueryString(formObj));
			
			if (ComGetTotalRows(sXml) > 1) {
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}else{
				sheetObj.LoadSearchData(sXml,{Sync:0} );
			}
			ComOpenWait(false);
		} , 100);
	}
	break;
	case IBSEARCH_ASYNC01:
	if(validateForm(sheetObj,formObj,sAction)){            	
		sheetObj.RemoveAll();
		formObj.f_cmd.value=SEARCH01;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.DoSearch("EES_LSE_0047GS.do",FormQueryString(formObj) );
		
	}
	break;
	case IBSEARCH_ASYNC02:
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
				formObj.vndr_seq.value=ComGetEtcData(sXml, "vndr_seq");
				formObj.vndr_nm.value=ComGetEtcData(sXml, "vndr_lgl_eng_nm");
			} else {
				ComShowCodeMessage("LSE01007");
				formObj.agmt_seq.value="";
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				ComSetFocus(formObj.agmt_seq);			        	
			}
		}
	}
	break;
	case IBCREATE:
		formObj.f_cmd.value=SEARCH02;
		sheetObj.SetWaitImageVisible(0);
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		if ( sXml2 != "" ) {
			comboObjects[1].InsertItem(0 , 'ALL','ALL'); 
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd=ComGetEtcData(sXml2, "cntr_tpsz_cd");        
			formObj.tysz.value=vOrcCntrTpszCd;	
			arrTpSz=vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2=vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;
		
	case IBSEARCH_ASYNC04:	// retrieving for Location
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp=formObj.loc_tp[formObj.loc_tp.selectedIndex].text;
			var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd="";
						switch (vLocTp) {
						case "RCC":
							vLocCd=ComGetEtcData(sXml, "rcc_cd");
							break;
						case "LCC":
							vLocCd=ComGetEtcData(sXml, "lcc_cd");
							break;															
						}
						formObj.loc_cd.value=vLocCd;
						ComSetFocus(formObj.period_stdt);
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

function sheet2_OnSearchEnd(sheetObj, Code, Msg) { 
	ComOpenWait(false);
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg) { 
	var lRow=sheetObj.LastRow();
	var authVol="";
	var pickVol="";
	var hiddenCnt=0;
	var formObj = document.form;
	var strCntrTpszCd=formObj.cntr_tpsz_cd.value ;
	
	sheetObjects[0].RenderSheet(0);
	for(var i=0 ; i < arrTpSz2.length ; i++){
		authVol=sheetObjects[0].GetCellValue(lRow -2 ,arrTpSz2[i]);
		pickVol=sheetObjects[0].GetCellValue(lRow -1 ,arrTpSz2[i]);
		
		if( comboObjects[1].GetItemCheck(0) == true ){
			sheetObjects[0].SetColHidden(arrTpSz2[i],0);
			sheetObjects[0].SetColWidth(arrTpSz2[i], "80");
			          	
		}else{
			sheetObjects[0].SetColHidden(arrTpSz2[i],0);
			sheetObjects[0].SetColWidth(arrTpSz2[i], "80");
			if( 0 <= strCntrTpszCd.indexOf(arrTpSz[i])) {                		
				if( Number(authVol) <= 0 && Number(pickVol) <= 0 ){
					//sheetObjects[0].SetColHidden(arrTpSz2[i],1);
					//hiddenCnt++;
				}else{
					sheetObjects[0].SetColHidden(arrTpSz2[i],0);
				}                    
			}else{
				sheetObjects[0].SetColHidden(arrTpSz2[i],1);
				hiddenCnt++;
			}
		}
		
	}
	sheetObjects[0].RenderSheet(1);

	if(sheetObjects[0].RowCount()> 0){
		sheetObjects[0].SetRowBackColor(sheetObjects[0].LastRow(),LSE_TOTCOL_BACK_COLOR);
		sheetObjects[0].SetRowBackColor(sheetObjects[0].LastRow()-1,LSE_TOTCOL_BACK_COLOR);
		sheetObjects[0].SetRowBackColor(sheetObjects[0].LastRow()-2,LSE_TOTCOL_BACK_COLOR);
		if(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), 1) == "G.TTL" ){
			sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow()-2 , 1, 3, 2);
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
		var sUrl="";
		var iWidth=755;
		var iHeight=480;
		var sTargetObjList="";
		var sDisplay="1,0,1,1,1,1,1,1";
		if(formObj.loc_tp.value == "R"){
			sTargetObjList="rcc_cd:loc_cd";
			sUrl='/opuscntr/COM_ENS_051.do';
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}else if(formObj.loc_tp.value == "L"){
			sTargetObjList="lcc_cd:loc_cd";
			sUrl='/opuscntr/COM_ENS_051.do';
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}
	} else if ( type == "2") {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
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
		formObj.agmt_seq.value=aryPopupData[0][5];
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
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
			var periodStdt=formObj.period_stdt.value;
			periodStdt=periodStdt.replaceStr("-","");
			var periodEtdt=formObj.period_eddt.value;			          
			periodEtdt=periodEtdt.replaceStr("-","");			          
			if ( Number(periodStdt) > Number(periodEtdt)) {
				ComShowCodeMessage("LSE01051");
				ComSetFocus(formObj.period_stdt);
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
			document.form.vndr_seq.value="";
			document.form.vndr_nm.value="";    			
		}
		break;
	default:
		//checking Validation
		break;
	}
}
/**
 * handling event in case of Change
 */
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
		switch(ComGetEvent("name")) {
		case "agmt_seq": 	 
			if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
			}
			break; 	    	
		case "loc_cd":		//Location Code
		if ( ComTrim(obj.value) != "" ) {
			if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L"){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
			}
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
		case "loc_tp":
     	   formObj.loc_cd.value="";
     	   formObj.loc_cd.focus();
        break;
		case "lstm_tp_cd":
			comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
			if(formObj.lstm_tp_cd.value == "L"){
				comboObjects[0].RemoveAll();
				comboObjects[0].SetDropHeight(150);
				comboObjects[0].InsertItem(0, "ALL", "ALL");
				comboObjects[0].InsertItem(1, "SO", "SO");
				comboObjects[0].InsertItem(2, "MO", "MO");
			} else {
				comboObjects[0].SetDropHeight(250);
				comboObjects[0].InsertItem(0, "ALL", "ALL");
				comboObjects[0].InsertItem(1, "ST", "ST");
				comboObjects[0].InsertItem(2, "LT", "LT");
				comboObjects[0].InsertItem(3, "OF", "OF");
				comboObjects[0].InsertItem(4, "SI", "SI");
				comboObjects[0].InsertItem(5, "MI", "MI");
			}
			doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
			comboObjects[0].SetItemCheck(0,1);
			comboObjects[1].SetItemCheck(0,1);
			sheetObjects[0].RemoveAll();
			sheetShowInit();
			sheetObjects[1].RemoveAll();
			initSheet(sheetObjects[0],1);
			formObj.loc_cd.value="";
			formObj.loc_tp[0].selected=true;
			formObj.period_stdt.value="";
			formObj.period_eddt.value="";
			formObj.auth_no.value="";
			formObj.lstm_cd.value="";
			formObj.cntr_tpsz_cd.value="";
			formObj.agmt_seq.value="";
			formObj.vndr_seq.value="";
			formObj.vndr_nm.value="";
			formObj.new_van_tp_cd[0].checked=true;
			formObj.period_stdt.focus();
			
			if(formObj.lstm_tp_cd.value == "L") {
				sheetObjects[1].SetCellText(0, "on_hire_loc", "Lease Out \nLoc.");
				sheetObjects[1].SetCellText(0, "on_hire_dt", "Lease Out \nDate");
			} else {
				sheetObjects[1].SetCellText(0, "on_hire_loc", "On-hire \nLoc.");
				sheetObjects[1].SetCellText(0, "on_hire_dt", "On-hire \nDate");
			}
		break;
		}	    		
	}
}
/**
 * sheet1_OnDblClick
 * handling event in case of double-click sheet
 */
function sheet1_OnDblClick(Row, Col, CellX, CellY, CellW, CellH) {
	var formObj=document.form;
	var sheetObject1=sheetObjects[0];
	var sRow=sheetObject1.GetSelectRow();
	var lRow=sheetObject1.LastRow()-3;
	/*if(sRow > lRow){ 		   
		return;
	}*/
	var sDivsion = sheetObject1.GetCellValue(sRow,"divsion");
	if(sheetObject1.GetSelectCol()== 1){
		formObj.detail_auth_no.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "auth_no" );
		formObj.detail_agmt_cty_cd.value="";
		formObj.detail_agmt_seq.value="";
		formObj.detail_cntr_tpsz_cd.value="";
		formObj.detail_divsion.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "divsion" );
	}else if(sheetObject1.GetSelectCol()> 1 && sheetObject1.GetSelectCol()< 5){
		if(sheetObject1.GetSelectCol() > 3 && sDivsion != "P/UP VOL") {
		}else{
			formObj.detail_auth_no.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "auth_no" );
			var strAgmtNo =sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "agmt_no" );
			var strAgmtCtyCd=strAgmtNo.substr(0,3);
			var strAgmtSeq=strAgmtNo.substr(3);
			strAgmtSeq    =Number(strAgmtSeq);
			formObj.detail_agmt_cty_cd.value=strAgmtCtyCd;
			formObj.detail_agmt_seq.value=strAgmtSeq;        	
			formObj.detail_cntr_tpsz_cd.value="";
			formObj.detail_divsion.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "divsion" );
		}
	}else if( sheetObject1.GetSelectCol()> 4){
		if(sheetObject1.GetSelectCol() > 3 && sDivsion != "P/UP VOL") {
		}else{
			formObj.detail_auth_no.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "auth_no" );
			var strAgmtNo =sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "agmt_no" );
			var strAgmtCtyCd=strAgmtNo.substr(0,3);
			var strAgmtSeq=strAgmtNo.substr(3);
			strAgmtSeq    =Number(strAgmtSeq);
			formObj.detail_agmt_cty_cd.value=strAgmtCtyCd;
			formObj.detail_agmt_seq.value=strAgmtSeq;        	
			formObj.detail_cntr_tpsz_cd.value=sheetObject1.GetCellValue( 0 , sheetObject1.GetSelectCol());
			formObj.detail_divsion.value=sheetObject1.GetCellValue( sheetObject1.GetSelectRow(), "divsion" );
		}
	}
	if(sheetObject1.GetSelectCol() > 3 && sDivsion != "P/UP VOL") {
	}else{
		sheetObjects[1].RemoveAll();
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
	}
}
/**
 * initializing IBMultiCombo
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
	case "combo1":
		with(comboObj) {
			var formObj=document.form;
			
			if(formObj.lstm_tp_cd.value == "L"){
				SetDropHeight(150);
				InsertItem(0, "ALL", "ALL");
				InsertItem(1, "SO", "SO");
				InsertItem(2, "MO", "MO");
			} else {
				SetDropHeight(250);
				InsertItem(0, "ALL", "ALL");
				InsertItem(1, "ST", "ST");
				InsertItem(2, "LT", "LT");
				InsertItem(3, "OF", "OF");
				InsertItem(4, "SI", "SI");
				InsertItem(5, "MI", "MI");
			}
			
			SetMultiSelect(1);
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
		}
		break;
	case "combo2":
		with(comboObj) {
			SetDropHeight(200);
			SetMultiSelect(1);
			SetMultiSeparator(",");
			Style=0;
			SetUseAutoComplete(1);
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
		//alert(KeyCode);
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
 * * initializing sheet TY/SZ 
 */
function sheetShowInit(){
	for(var i=0; i<arrTpSz2.length; i++){
		sheetObjects[0].SetColHidden(arrTpSz2[i],0);
	}
	sheetObjects[0].SetSheetWidth(984);
}
/**
 * handling event in case of focus
 */
/* end of developer job */
