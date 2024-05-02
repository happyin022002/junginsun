/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0031.js
*@FileTitle  : On Hire Approval inquiry
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
 * @class ees_lse_0031 : business script for ees_lse_0031
 */

/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var checkDt=0;
// Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
var arrTpSz=new Array("d2","d4","d5","d7","r2","r5","r9","o2","s2","o4","o5","s4","f2","a2","f4","a4","f5","p2","p4","t2","t4","d3","dx","r4","d9","r8","c2");
var arrTpSz2=new Array();
var arrTpSz3=new Array();
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
		case "Retrieve":
			/*for(var i=0; i<arrTpSz3.length; i++){
				sheetObjects[0].SetColHidden(arrTpSz3[i],true);
			}*/
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			ComOpenWait(false);
			break;
		case "btn_New":
			formObject.cntr_tpsz_cd.value="";			
			formObject.loc_cd.value="";			
			comboObjects[0].SetSelectText("");
			formObject.pkup_fm_dt.value="";
			formObject.pkup_due_dt.value="";			
//			formObject.period_stdt.value="";
//			formObject.period_eddt.value="";
			formObject.cntr_onh_auth_no.value="";
			
			formObject.agmt_seq.value="";
			comboObjects[1].SetSelectText("");
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			
			sheetObject.SetWaitImageVisible(0);
			ComOpenWait(true);	
			setTimeout( function () {					
				sheetObject.RemoveAll();					
				
				sheetObjects[0].RenderSheet(0);
				for(var i=0; i<arrTpSz3.length; i++){
					sheetObjects[0].SetColHidden(arrTpSz3[i],true);
				}
				sheetObjects[0].RenderSheet(1);

				sheetObjects[0].SheetWidth=765;
				formObject.apro_rmk.value="";
				ComSetFocus(formObject.loc_cd);
				ComOpenWait(false);	
				sheetObject.SetWaitImageVisible(1);
			} , 100);
			
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
		/*case "btns_calendar1":		
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_stdt, "yyyy-MM");
			}
			break;
		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.period_eddt, "yyyy-MM");
			}
			break;*/
		case "btns_search1":    // onh_loc_cd Pop-up
		   if ( srcObj.style.filter == "" ) {
			  openPopup("1");
		   }
		break;
		case "btns_search":
			// Lessor Search
			openPopup("3");
			break;
		case "btns_search2":		//retrieving for AGMT No.
			openPopup("2");
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
	//var objs = document.all.item("tabLayer");
	//objs.style.display = "Inline";
	sheet1_OnLoadFinish()
}
function sheet1_OnLoadFinish() {
	 /* IBMulti Combo Item Setting */
	 doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	 initSheet(sheetObjects[0],1);
	 for(var i=0; i < arrTpSz3.length; i++){
		 sheetObjects[0].SetColHidden(arrTpSz3[i],true);
	 }
	 this.title_color();
//no support[implemented common]CLT 	 sheetObjects[0].ScrollBar=3;
	 document.form.loc_cd.focus();
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj); 
//	axon_event.addListenerForm('keypress',  'obj_keypress', formObj); 
//	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
	axon_event.addListenerFormat('blur','obj_change',formObj);         
	//axon_event.addListenerFormat('focus','obj_focus',formObj);       
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
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
	    var strLessorVal = "";
	    for(var i=0; i<arrTpSz.length; i++){
	    	HeadUpperTitle = arrTpSz[i].toUpperCase();
	    	HeadTitleTemp=HeadTitleTemp  + "|" + HeadUpperTitle + "|" + HeadUpperTitle + "|" + HeadUpperTitle;
	    	 if(form.type_chk[1].checked == true) {
	    		 HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|Qty";
	    	 }else{
	    		 HeadTitle2Temp=HeadTitle2Temp + "|Old|H/On|New";
	    	 }
	    }
	    
	    if(form.type_chk[1].checked == true) {
	    	strLessorVal = "Lessee";
	   	}else{
	   		strLessorVal = "Lessor";
	   	}
	    var HeadTitle="sta|AGMT No.|Ref No.|Expected Return LOC|Lease\nTerm |Auth No.|Location|Period|"+strLessorVal+" ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|DIV Total|DIV Total" + HeadTitleTemp + "|pkup_due_dt|apro_rmk" ;
	    var HeadTitle2="sta|AGMT No.|Ref No.|Expected Return LOC|Lease\nTerm |Auth No.|Location|Period|"+strLessorVal+" ABBR|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|Old|New" + HeadTitle2Temp + "|pkup_due_dt|apro_rmk"  ;
	    var headCount=ComCountHeadTitle(HeadTitle);
	    //(headCount, 0, 0, true);

	    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    var headers = [ { Text:HeadTitle, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	    InitHeaders(headers, info);

	    var cols = [ {Type:"Status", Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	              {Type:"Text",      Hidden:1,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"return_lcc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
	              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              
	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"auth_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"auth_period",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"lessor",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"m_year",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	              {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"free_day",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	              {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"p_up_charge",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	              {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"p_up_credit",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	              {Type:"Int",       Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_days",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	              {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"div_total_old",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	              {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"div_total_new",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       for(var i=0; i<arrTpSz.length; i++){
	    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_old", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	    cols.push({Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_lon", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:arrTpSz[i]+"_new", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 });
	    }
	    cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pkup_fm_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	    cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pkup_due_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	    cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"apro_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	  
	    InitColumns(cols);

	   SetEditable(1);
       FrozenCols=5;
       resizeSheet();
       SetSheetWidth(1000);
	}
	break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(1);
		ComOpenWait(true);
		setTimeout( function () {
			sheetObj.DoSearch("EES_LSE_0031GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			} , 100);
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
		var sXml2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		if ( sXml2 != "" ) {
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
		
		var sXml_2=sXml2;
		if ( sXml_2 != "" ) {
        	comboObjects[1].InsertItem(0 , 'ALL','');
        	LseComXml2ComboItem(sXml_2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
        	vOrcCntrTpszCd=ComGetEtcData(sXml_2, "cntr_tpsz_cd");
        }
		break;
	case IBSEARCH_ASYNC01:      //retrieving for auth_no
	var vLocCd=formObj.loc_cd.value;
	var vCombo1=ComGetObjValue(comboObjects[0]);
	if(vCombo1 != ""){
		formObj.f_cmd.value=SEARCH01;
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_LSE_0031GS.do", FormQueryString(formObj));
//		if ( sXml != "" ) {
//			ComXml2ComboItem(sXml, comboObjects[1], "cntr_onh_auth_no", "cntr_onh_auth_no");
//		}
		
		if(ComGetEtcData(sXml, "lstm_cd") != vCombo1){
			ComShowCodeMessage("LSE10033");
			formObj.cntr_onh_auth_no.value="";
			return false;
		}
	}
	break;
	case IBSEARCH_ASYNC03:  // retrieving for Location
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH05;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "lcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "lcc_cd") != "" ) {
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
	case IBSEARCH_ASYNC02:	//retrieving when input Form Lessor No.
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
			sheetObj.SetWaitImageVisible(1);
			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
					ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
					ComSetNextFocus(formObj.vndr_seq);
				} else {
					ComShowCodeMessage("LSE01019");
					ComSetObjValue(formObj.vndr_seq, "");
					ComSetObjValue(formObj.vndr_nm, "");
					ComSetFocus(formObj.vndr_seq);
				}
			} else {
				ComShowCodeMessage("LSE01019");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
	}
	break;
	case IBSEARCH_ASYNC04:	//retrieving when input Form Agreement No.
		if(validateForm(sheetObj,formObj,sAction)) {
			if ( sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);
				if ( ComGetEtcData(sXml, "agmt_seq") != undefined) {
					ComSetObjValue(formObj.agmt_seq, ComGetEtcData(sXml, "agmt_seq"));
				}else{
					ComShowCodeMessage("LSE01007");
					ComSetObjValue(formObj.agmt_seq,    "");
					return false;
				}
			}
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
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:
			/*var periodStdt=formObj.period_stdt.value;
			periodStdt=periodStdt.replaceStr("-","");
			var periodEtdt=formObj.period_eddt.value;			          
			periodEtdt=periodEtdt.replaceStr("-","");
			if ( Number(periodStdt) > Number(periodEtdt)) {
				ComShowCodeMessage("LSE01051");
				ComSetFocus(period_stdt);
				return false;
				break;
			}*/
			if ( formObj.cntr_onh_auth_no.value != "" ) {
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
		/*if ( formObj.loc_cd.value == "" ) {
		ComShowCodeMessage("LSE01046");
		ComSetFocus(formObj.loc_cd);
		return false;
		break;
		}
		if ( comboObjects[0].GetSelectText() == "" ) {
			ComShowCodeMessage("LSE01009");
			ComSetFocus(comboObjects[0]);
			return false;
			break;
		}
		*/		
		
		}
	}
	return true;
}

/**
 * initializing IBMultiCombo
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
	case "lstm_cd":
		with(comboObj) {
			//BackColor = "cyan";
			SetDropHeight(150);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "tpsz_cd":
    	with(comboObj) {
        	SetDropHeight(200);
        	SetMultiSelect(1);
        	//MaxSelect = 1;
        	SetMultiSeparator(",");
        	Style=0;
     		SetUseAutoComplete(1);
        }
    	break;
/*	case "cntr_onh_auth_no":
		with(comboObj) {
			//BackColor = "cyan";
			SetDropHeight(150);
			SetMultiSelect(0);
			//MaxSelect = 1;
			SetFontName("Courier New");
		}
		break;*/
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
		//var formObj = document.form;
		var sUrl='/opuscntr/COM_ENS_051.do';
		var iWidth=800;
		var iHeight=480;
		var sTargetObjList="loc_cd:loc_cd";
		var sDisplay="1,0,1,1,1,1,1,1";
		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	}else if ( type == "2" ) {
		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
	}else if ( type == "3" ) {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	}
}


/**
 * handling process for Agreement Pop-up Return Value<br>
 * @param Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj=sheetObjects[SheetIdx];
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
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
		ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
	}
}


/**
 * handling event when changing Combo1
 */
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

function lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
}  

/*function cntr_onh_auth_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if ( newCode == "" ) {
		ComShowCodeMessage("LSE01047");
		ComSetFocus(comboObjects[1]);
		return false;       
	}
}*/     
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "agmt_seq":	//Agreement No.
				if ( ComTrim(obj.value) != "" ) {
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
			}
			break;
		case "loc_cd":
			ComChkObjValid(obj);
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			var strLocCd=formObj.loc_cd.value;
			if(strLocCd.length == 5 && comboObjects[0].GetSelectText()!= "" ){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			}
		break;
		case "vndr_seq":
    		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
		   	break;
		case "type_chk":
			var strTypeChk = formObj.type_chk.value;
			var usr_ofc_cd = formObj.usr_ofc_cd.value;
			var ofc_type   = usr_ofc_cd.substring(3,5);
			
			formObj.loc_cd.value = "";
//			formObj.period_stdt.value = "";
//			formObj.period_eddt.value = "";
			formObj.cntr_onh_auth_no.value = "";
			initSheet(sheetObjects[0],1);
			if(strTypeChk == "O") {
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
				sheetObj.SetColHidden("div_total_old", 0);
				sheetObj.SetColHidden("div_total_new", 0);
				for(var i=0 ; i < arrTpSz2.length ; i++){
					sheetObj.SetColHidden(arrTpSz2[i]+"_old", 1);
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
				sheetObj.SetColHidden("div_total_old", 1);
				sheetObj.SetColHidden("div_total_new", 1);
				
				sheetObjects[0].RenderSheet(0);
				for(var i=0; i<arrTpSz3.length; i++){
					sheetObjects[0].SetColHidden(arrTpSz3[i],true);
				}
				sheetObjects[0].RenderSheet(1);
				
				for(var i=0 ; i < arrTpSz2.length ; i++){
					sheetObj.SetColHidden(arrTpSz2[i]+"_old", 1);
				}
				
			}
			
			sheetObjects[0].RemoveAll();			
			sheetObjects[0].RenderSheet(1);
			formObj.cntr_tpsz_cd.value = "";
			formObj.pkup_fm_dt.value = "";
			formObj.pkup_due_dt.value = "";
			break;
			
		case "cntr_onh_auth_no" :
			var strAuthNo = formObj.cntr_onh_auth_no.value;
			if(strAuthNo.length != ""){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			}
			
			if (strAuthNo.substring(9,11) == "MO" || strAuthNo.substring(9,11) == "SO") {
				if(formObj.type_chk.value != "L") {
					ComShowCodeMessage("LSE10031");
					strAuthNo="";
				}
			} else {
				if(formObj.type_chk.value != "O") {
					ComShowCodeMessage("LSE10031");
					strAuthNo="";
				}
			}
		break;
		}
	}
}
function title_color(){
    for(var i=0; i<arrTpSz2.length; i++){			
    	sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_old","#B0C4DE");
        sheetObjects[0].SetCellBackColor(0, arrTpSz2[i] + "_lon","#B0C4DE");
        sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_old","#B0C4DE");
        sheetObjects[0].SetCellBackColor(1, arrTpSz2[i] + "_lon","#B0C4DE");
    }
}
/**
 * handling event in case Period FM  beforeactivate
 */    
	function obj_activate() {
		var obj=ComGetEvent();
		if( obj.readOnly ) {
			//ComSetNextFocus(obj);
		} else {
			//deleting data unit separator
			/*if(obj.name == "period_stdt" || obj.name == "period_eddt"){			  
				if(obj.name == "period_stdt" && document.form.period_eddt.value != ""){
					document.form.period_eddt.value="";
				}
				if(obj.value.length == 7 ){
			      ComClearSeparator(ComGetEvent());
			    }
			}  */
		}
	}
   /**
	* handling event in case Period to  beforedeactivate
	* Period to  beforedeactivate YYYY-MM 
	*/	
	function obj_deactivate() {		
        var  obj=ComGetEvent();		
		/*if (obj.name == "period_stdt" || obj.name == "period_eddt") { 
            var periodStdt=document.form.period_stdt.value;
            periodStdt=periodStdt.replaceStr("-","");
            var periodEtdt=document.form.period_eddt.value;			          
            periodEtdt=periodEtdt.replaceStr("-","");
             if (obj.name == "period_stdt") {            
                 ComAddSeparator(ComGetEvent());                  
             }else if (obj.name == "period_eddt") {		
                ComAddSeparator(ComGetEvent()); 
                if( checkDt == 0 && ( ComGetMaskedValue(periodEtdt, "ym") == "" || Number(periodStdt) > Number(periodEtdt) ) ){       	            	   	        
                    checkDt=1;	    	    
                    if(ComGetMaskedValue(periodEtdt, "ym") != "" ){
                      ComShowCodeMessage("LSE01051");
                      ComSetFocus(document.form.cntr_onh_auth);
                      ComSetFocus(document.form.period_eddt);	    	 
                   }
                }
                if(checkDt == 0 ){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                }           
            }
		}*/
	}
/**
* cntr_onh_auth_no_OnKeyDown
*/
/*function cntr_onh_auth_no_OnKeyDown(comboObj, KeyCode, Shift) {	  
   with(comboObj) {
	    if ( KeyCode == 13 ){
		    sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
   }
}*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	var formObj=document.form;
	if(sheetObj.RowCount()> 0){
		initSheet(sheetObjects[0],1);
/*		// 검색결과 row의 개수가 1개 이상일 때 모든 Pick up Due Date을 넣어줄 수 없기 때문에 1개일 때만 값을 보여준다
		if(sheetObj.RowCount() <= 1) {
//			formObj.pkup_fm_dt.value=sheetObj.GetCellValue(2,"pkup_fm_dt");
//			formObj.pkup_due_dt.value=sheetObj.GetCellValue(2,"pkup_due_dt");
		} else {
			formObj.pkup_fm_dt.value = "";
			formObj.pkup_due_dt.value = "";
		} */
		
		formObj.apro_rmk.value=sheetObj.GetCellValue(2,"apro_rmk");
		var strTpszCd="";
		var strTxt="";
		var chkHidden=true;
		var strTypeChk = formObj.type_chk.value;
		for( var j = 18 ; j <=  arrTpSz3.length + 12 ; j++){
			// j값은 initSheet에 정의되어 있는 총 컬럼의 개수
			// TP/SZ 추가시 12 부분 수정 필요
			chkHidden=true;
			for( var i=2 ; i <= sheetObj.RowCount()+ 1 ; i++){
				if( sheetObj.GetCellText(i,j) != "0" && sheetObj.GetCellText(i,j) != "0.00" &&  sheetObj.GetCellText(i,j) != "" && sheetObj.GetCellText(i,j) != null){
					chkHidden=false;
					strTxt=sheetObj.GetCellText(0,j);
					if(strTpszCd.indexOf(strTxt) < 0){
						strTpszCd=strTpszCd + "," + strTxt;
					}
				}
			}
			if(chkHidden == false ){
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
				// #9964 : Type이 Lease Out일 때 Old 컬럼을 Hidden 처리
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
				if(strTypeChk == "L"){
					sheetObj.SetColHidden("div_total_new", 1);
					sheetObj.SetColHidden("div_total_old", 1);
				}
			}
		}
		if(strTpszCd.length > 0){
		    //strTpszCd = strTpszCd.substr(1) ;
		    formObj.cntr_tpsz_cd.value=strTpszCd;
		}		
		
		if(strTpszCd.length > 0){
			strTpszCd=strTpszCd.substr(1) ;
			formObj.cntr_tpsz_cd.value=strTpszCd;
			var arryTpszCd=strTpszCd.split(",");
			var addCnt=arryTpszCd.length;
			var addSize=0;
			if(document.form.cntr_tpsz_cd.value != ""){
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
					sheetObjects[0].SheetWidth=984;
				}
			}else{
				sheetObjects[0].SheetWidth=765;
			}
		}
		cntr_tpsz_cd.SetSelectCode(-1,false);
		cntr_tpsz_cd.SetSelectCode(strTpszCd,true);
		combo1.SetEnable(0);
		ComEnableObject(formObj.loc_cd, false);
		ComEnableObject(formObj.btns_search1, false);
		ComEnableObject(formObj.pkup_fm_dt, true);
		ComEnableObject(formObj.pkup_due_dt, true);
//		$("#pkup_due_dt").prop('disabled', false);
		document.form.pkup_fm_dt.style.cssText="width:80px; background-color:#CCFFFD;";
		document.form.pkup_due_dt.style.cssText="width:80px; background-color:#CCFFFD;";
//		ComEnableObject(formObj.btns_calendar1, true);
		cntr_tpsz_cd.SetEnable(1);
		ComEnableObject(document.form.remarks, true);
		ComBtnEnable("Row_Add");
		ComBtnEnable("Delete");
		ComBtnEnable("Save");
		ComBtnEnable("Cancel");
	}else{
		var formObject=document.form;
		var sheetObject=sheetObjects[0];
		var usr_ofc_cd = formObject.usr_ofc_cd.value;
		
		
		sheetObject.SetWaitImageVisible(0);
		ComOpenWait(true);	
		setTimeout( function () {					
			//sheetObject.RemoveAll();					
			sheetObjects[0].RenderSheet(0);
			
			for(var i=0; i<arrTpSz3.length; i++){
				sheetObjects[0].SetColHidden(arrTpSz3[i],true);
			}
			
			sheetObjects[0].RenderSheet(1);
			sheetObjects[0].SheetWidth=765;
			formObject.apro_rmk.value="";
			ComSetFocus(formObject.loc_cd);
			ComOpenWait(false);	
			sheetObject.SetWaitImageVisible(1); 
		} , 100);
		
	}
	
	sheetObj.SetColBackColor(9,"#DCDCDC");
	sheetObj.SetColBackColor(10,"#DCDCDC");	
}
/* end of developer job */

function resizeSheet(){
	    ComResizeSheet(sheetObjects[0], 120);
	}


function set_new(){
	var formObject=document.form;
	var sheetObject=sheetObjects[0];
	var usr_ofc_cd = formObject.usr_ofc_cd.value;
	var ofc_type = usr_ofc_cd.substring(3,5);
	
	formObject.cntr_tpsz_cd.value="";			
	formObject.loc_cd.value="";		
	comboObjects[0].SetSelectText("");
	formObject.pkup_fm_dt.value="";	
	formObject.pkup_due_dt.value="";			
//	formObject.period_stdt.value="";
//	formObject.period_eddt.value="";
	formObject.cntr_onh_auth_no.value="";
	sheetObject.SetWaitImageVisible(0);
	ComOpenWait(true);	
	setTimeout( function () {					
		sheetObject.RemoveAll();					
		sheetObjects[0].RenderSheet(0);
		
		for(var i=0; i<arrTpSz3.length; i++){
			sheetObjects[0].SetColHidden(arrTpSz3[i],true);
		}
		
		sheetObjects[0].RenderSheet(1);
		sheetObjects[0].SheetWidth=765;
		formObject.apro_rmk.value="";
		ComSetFocus(formObject.loc_cd);
		ComOpenWait(false);	
		sheetObject.SetWaitImageVisible(1);
	} , 100);
	
	formObject.type_chk[0].checked = true;
	if(ofc_type == 'HQ') {
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
	sheetObjects[0].SetColHidden("return_lcc", 1);
}


function tpsz_cd_OnCheckClick(comboObj, index, code) {
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