/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2004.jsp
*@FileTitle  : Own M.G.Set Master Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_2004 : ees_cgm_2004 business script for
 */

/* developer jop */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if(comboObjects[0].GetSelectText()== ""){
				ComShowCodeMessage("CGM10004", "M.G.Set Serial Range");
//				comboObjects[0].focus();
				return;
			}
			// IBSHEET retrieve
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			// HTML object ENABLE DISABLE function call
			CgmSetFormObjDisable(formObj, true);
			break;
		case "btn_New":
			// setting edit unable
			// setting flag to "I"
			// row add function call
			sheetObj.RemoveAll();
			var row=sheetObj.DataInsert(0);
			sheetObj1.RemoveAll();
			var row=sheetObj1.DataInsert(0);
			formObj.reset();
			comboObjects[0].SetSelectCode("");
			eq_spec_no.SetSelectCode("");
			financier.SetSelectCode("");
			sheetObj.SetCellValue(1, "eq_knd_cd","Z");
			sheetObj.SetRowStatus(1,"I");
			formObj.page_status.value="N";
			// HTML object ENABLE DISABLE function call
			CgmSetFormObjDisable(formObj, false);
			break;
		case "btn_Save":
			// field check before save
			if(eq_spec_no.GetSelectText()== ""){
				ComShowCodeMessage("CGM10004", "Model No.");
//				formObj.eq_spec_no.focus();
				return;
			}
			if(formObj.eq_pfx_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
//				formObj.eq_pfx_cd.focus();
				return;
			}
			if(formObj.fm_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
//				formObj.fm_ser_no.focus();
				return;
			}
			if(formObj.to_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial Range");
//				formObj.to_ser_no.focus();
				return;
			}
			if(formObj.de_yrmon.value == ""){
				ComShowCodeMessage("CGM10004", "Delivery Month");
				if(formObj.de_yrmon.disabled != true)
//					formObj.de_yrmon.focus();
				return;
			}
			if(formObj.agreement_no.value == ""){
				ComShowCodeMessage("CGM10004", "Agreement No");
//				formObj.agreement_no.focus();
				return;
			}
			doActionIBSheet(sheetObj,formObj,IBSAVE);
			break;
/*
		case "btn_FA I/F":
			var param="";
			if(formObj.mgset_range.GetSelectText()!= '' && formObj.eq_pfx_cd.disabled == true)
		  	{
		  		var pgmNo='EES_CGM_1146';
		  		var pgmUrl='/opuscntr/EES_CGM_1146.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
		  		//1146
		  		var eq_knd_cd='G'; //Eq kind=> chassis:'Z', MGSET:'G'  
		  		var de_yrmon=form.de_yrmon.value;
		  		var eq_no_fm=form.eq_pfx_cd.value+form.fm_ser_no.value;
		  		var eq_no_to=form.to_ser_no.value;
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")
		    				+"&pgmNo="+pgmNo
		    				+"&eq_knd_cd="+eq_knd_cd
		    				+"&de_yrmon="+de_yrmon
		    				+"&eq_no_fm="+eq_no_fm
		    				+"&eq_no_to="+eq_no_to;
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//
		  		var pgmNo='EES_CGM_1146';
		  		var pgmUrl='/opuscntr/EES_CGM_1146.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;
*/
			// show day calendar
		case "btn_Calendar" :
			if(window.ComGetEvent().disabled) {
				return;
			}
			var cal=new ComCalendar();
			cal.select(formObj.cre_dt, "yyyy-MM-dd");
			break;
	// show month calendar
	case "btn_Calendar_b" :
		if(window.ComGetEvent().disabled) {
			return;
		}
		var cal=new ComCalendar();
		cal.setDisplayType("month");
		cal.select(formObj.de_yrmon, "yyyy-MM");
		break;
	case "btn_ComOpenPopupWithTargetAgree":
			if(window.ComGetEvent().disabled) {
				return;
			}
	    	ComOpenPopup('/opuscntr/EES_CGM_2022.do', 820, 435, "setProgramNo", "1,0,1,1,1,1", true, false);
			break;
		} // end switch
		tRoleApply();
  }catch(e) {
    if( e == "[object Error]") {
     ComShowMessage(OBJECT_ERROR);
    } else {
     ComShowMessage(e.message);
    }
  }
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * param : combo_obj ==> comboobject
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
   comboObjects[comboCnt++]=combo_obj;
}
/**
 * implementing onLoad event handler in body tag / adding first-served functions after loading screen.
 *
 */
function loadPage() {
	var formObj=document.form;
	//axon event regist
//    axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
//    axon_event.addListenerFormat('keypress',			'obj_keydown',		form);
//    axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form);
//	  axon_event.addListenerFormat("beforeactivate",	"obj_activate",		form);
    axon_event.addListener      ("focusout",			"obj_focusout",		"eq_lot_no", "eq_pfx_cd", "fm_ser_no", "to_ser_no", "eq_lot_iss_dt","de_yrmon");
    axon_event.addListener      ("blur",				"obj_blur",			"eq_lot_no");
   axon_event.addListener		("change",				"obj_change",		"agreement_no");
//    axon_event.addListenerForm	('keyup', 'obj_keyup', form);
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]); 
		sheetObjects[i].DataInsert(0);
	}
	for(i=0;i<comboObjects.length;i++){
        initCombo(comboObjects[i],i+1);
    }
	//combo object
	initControl(sheetObjects[0]);
	formObj.page_status.value="N";
	sheetObjects[0].SetCellValue(1, "eq_knd_cd","Z");
	tRoleApply();
}
/**
 * init control of form
 */
function initControl(sheetObj){
	// Form object
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02); // COMBO >> SPEC NO
	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03); // COMBO >> FINANING CO
   	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
	    with(sheetObj){
		      var HeadTitle="|eq_lot_no|mgset_range|eq_pfx_cd|fm_ser_no|to_ser_no|units|de_yrmon|eq_spec_no|vndr_seq|vndr_lgl_eng_nm_eqspec|mgst_vltg_capa|mgst_fuel_capa|agreement_no|agmt_ofc_cty_cd|agmt_seq|agmt_lstm_cd|agmt_iss_ofc_cd|cre_dt|vndr_seq_agree|vndr_lgl_eng_nm_agree|eq_tpsz_cd|chss_tare_wgt|eq_lot_iss_dt";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_lot_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgset_range",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_pfx_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_ser_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_ser_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"units",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_yrmon",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm_eqspec",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_vltg_capa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_fuel_capa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_iss_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq_agree",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm_agree",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"chss_tare_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             	 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"eq_lot_iss_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(80);
            }


		break;
	case 2:
        with(sheetObj){
			  var HeadTitle="eq_spec_no|agmt_lstm_cd|vndr_lgl_eng_nm_eqspec|mgst_vltg_capa|mgst_fuel_capa|eq_tpsz_cd|chss_tare_wgt";
			  var headCount=ComCountHeadTitle(HeadTitle);
			
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);
			
			  var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm_eqspec",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"mgst_vltg_capa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"mgst_fuel_capa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   
			  InitColumns(cols);
			  SetEditable(1);
			  SetSheetHeight(80);
        }
		break;
	}
}
/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	switch (sAction) {
	// SEARCH
	case IBSEARCH:
		formObj.f_cmd.value=SEARCH01;
		financier.SetSelectIndex(-1);//chungpa 20090813 add iniialize combo index
 		sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj) );
		break;
	// SAVE
	case IBSAVE:
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);	
		formObj.f_cmd.value=MULTI;
		if(sheetObj.GetCellValue(1,"ibflag") == "I"){
			sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj));
//			if(sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj) , {Sync:1})){
// 				sheetObj.LoadSaveData(sXml);
//				
// 				// Combo INIT call
// 				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE
//
// 				var mgset_range_Val=sheetObj.GetCellValue(1, "mgset_range");
//				formObj.mgset_range.text=mgset_range_Val;
//				formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1, "eq_lot_no");
//				formObj.f_cmd.value=SEARCH01;
// 				
// 				sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj), {Sync:2}  );
//				formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1,"eq_lot_no");
//				mgset_range.SetSelectText(sheetObj.GetCellValue(1,"mgset_range"));
//				formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1,"eq_pfx_cd");
//				formObj.fm_ser_no.value=sheetObj.GetCellValue(1,"fm_ser_no");
//				formObj.to_ser_no.value=sheetObj.GetCellValue(1,"to_ser_no");
//				formObj.units.value=sheetObj.GetCellValue(1,"units");
//				formObj.eq_spec_no_text.value=sheetObj.GetCellValue(1,"eq_spec_no");
//				formObj.vndr_lgl_eng_nm_eqspec.value=sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_eqspec");
//				formObj.mgst_vltg_capa.value=sheetObj.GetCellValue(1,"mgst_vltg_capa");
//				formObj.mgst_fuel_capa.value=sheetObj.GetCellValue(1,"mgst_fuel_capa");
//				var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
//        		if(tmpDate.length == 6)
//        		{
//        			formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
//        		}
//        		else
//        		{
//        			formObj.de_yrmon.value=tmpDate;
//        		}
//				formObj.agreement_no.value=sheetObj.GetCellValue(1,"agreement_no");
//				formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1,"agmt_ofc_cty_cd");
//				formObj.agmt_seq.value=sheetObj.GetCellValue(1,"agmt_seq");
//				formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1,"agmt_lstm_cd");
//				formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1,"agmt_iss_ofc_cd");
//				formObj.cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
//				formObj.eq_lot_iss_dt.value=sheetObj.GetCellValue(1,"eq_lot_iss_dt");
//				formObj.vndr_seq_agree.value=sheetObj.GetCellValue(1,"vndr_seq_agree");
//				financier.SetSelectText(sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_agree"));
//				eq_spec_no.SetSelectText(sheetObj.GetCellValue(1,"eq_spec_no"));
//				sheetObj.SetCellValue(1, "mgset_range",formObj.mgset_range.text);
//				sheetObj.SetRowStatus(1,"U");
//				// HTML object DISABLE
//				CgmSetFormObjDisable(formObj, true);
//				ComShowCodeMessage("CGM00003");
//			}else
// 			{
// 			}
		} else if(sheetObj.GetCellValue(1,"ibflag") == "U"){
		
			sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj));
//			if(sheetObj.DoSave("EES_CGM_2004GS.do", FormQueryString(formObj), {Sync:1})){
//				
// 				sheetObj.LoadSaveData(sXml);
// 				// Combo INIT call
// 				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE
//
// 				var mgset_range_Val=sheetObj.GetCellValue(1, "mgset_range");
// 				formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1, "eq_lot_no");
//				formObj.mgset_range.text=mgset_range_Val;
//				formObj.f_cmd.value=SEARCH01;
//				
// 				sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj), {Sync:2}  );
//				formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1,"eq_lot_no");
//				formObj.mgset_range_text.value=sheetObj.GetCellValue(1,"mgset_range");
//				formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1,"eq_pfx_cd");
//				formObj.fm_ser_no.value=sheetObj.GetCellValue(1,"fm_ser_no");
//				formObj.to_ser_no.value=sheetObj.GetCellValue(1,"to_ser_no");
//				formObj.units.value=sheetObj.GetCellValue(1,"units");
//				formObj.eq_spec_no_text.value=sheetObj.GetCellValue(1,"eq_spec_no");
//				formObj.vndr_lgl_eng_nm_eqspec.value=sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_eqspec");
//				formObj.mgst_vltg_capa.value=sheetObj.GetCellValue(1,"mgst_vltg_capa");
//				formObj.mgst_fuel_capa.value=sheetObj.GetCellValue(1,"mgst_fuel_capa");
//				var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
//        		if(tmpDate.length == 6)
//        		{
//        			formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
//        		}
//        		else
//        		{
//        			formObj.de_yrmon.value=tmpDate;
//        		}
//				formObj.agreement_no.value=sheetObj.GetCellValue(1,"agreement_no");
//				formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1,"agmt_ofc_cty_cd");
//				formObj.agmt_seq.value=sheetObj.GetCellValue(1,"agmt_seq");
//				formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1,"agmt_lstm_cd");
//				formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1,"agmt_iss_ofc_cd");
//				formObj.cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
//				formObj.eq_lot_iss_dt.value=sheetObj.GetCellValue(1,"eq_lot_iss_dt");
//				formObj.vndr_seq_agree.value=sheetObj.GetCellValue(1,"vndr_seq_agree");
//				financier.SetSelectText(sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_agree"));
//				eq_spec_no.SetSelectText(sheetObj.GetCellValue(1,"eq_spec_no"));
//				sheetObj.SetCellValue(1, "mgset_range",formObj.mgset_range.text);
//				sheetObj.SetRowStatus(1,"U");
//				ComShowCodeMessage("CGM00003");
//			}else
// 			{
// 			}
//			

		}

		ComOpenWait(false);			
		break;
	// COMBO >> MGSET SERIAL RANGE
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value=SEARCH10;
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObject1(comboObjects[0], arrStr, 0, 0);
		break;
	// COMBO >> MODEL NO
	case IBSEARCH_ASYNC02:
		formObj.f_cmd.value=SEARCH03;
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObject2(eq_spec_no, arrStr, 0, 0);
		break;
	// COMBO >> FINANCING CO
	case IBSEARCH_ASYNC03:
		formObj.f_cmd.value=SEARCH11;
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		var sStr=ComGetEtcData(sXml,"comboList");
		var arrStr=sStr.split("@");
		MakeComboObject3(financier, arrStr, 0, 0);
		break;
		// AGREEMENT NO retrieve( retrieve)
	case IBSEARCH_ASYNC04:
		formObj.f_cmd.value=SEARCH12;
		formObj.agmt_no.value=formObj.agreement_no.value;
 		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj));
		var dataCount=ComGetTotalRows(sXml);
			// data existing
		if(dataCount>0){
			formObj.agmt_iss_ofc_cd.value=DomXml2String(sXml,"agmt_iss_ofc_cd");
			formObj.agmt_seq.value=DomXml2String(sXml,"agmt_seq");
			formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
			var DtTmp =DomXml2String(sXml,"cre_dt");
//			creDtTmp = DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
			formObj.cre_dt.value=DtTmp;
			formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
			formObj.agmt_ofc_cty_cd.value=DomXml2String(sXml,"agmt_ofc_cty_cd");
			sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value);
			sheetObj.SetCellValue(1, "agmt_seq",formObj.agmt_seq.value);
			sheetObj.SetCellValue(1, "agreement_no",formObj.agreement_no.value);
			return true;
		} else {
	    	// Form Object reset
	    	formObj.agmt_no.value="";
	    	formObj.agmt_iss_ofc_cd.value="";
	    	formObj.agmt_seq.value="";
	    	formObj.agmt_ver_no.value="";
	    	formObj.cre_dt.value="";
	    	formObj.agmt_lstm_cd.value="";
	    	sheetObjects[0].RemoveAll();
	    	return false;
		}
		break;
	case IBRESET:
		var idx=0
		var sXml2=document.form2.sXml.value;
		var arrXml=sXml2.split("|$$|");
		//MGSET SERIAL RANGE
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr1=new Array();
		for ( var i=0; i < vArrayListData.length; i++) {
		    vListData=vArrayListData[i];
		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		// combo control, result string, Text Index, Code Index
  		MakeComboObject1(comboObjects[0], arrStr1, 0, 0);   
		idx++;        		
		//MODEL NO
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr2=new Array();
		for ( var i=0; i < vArrayListData.length; i++) {
		    vListData=vArrayListData[i];
		    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject2(eq_spec_no, arrStr2, 0, 0);
  		idx++;
		//FINANCING CO
		if ( arrXml[idx] == null ) {return;}
		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    var arrStr3=new Array();
		for ( var i=0; i < vArrayListData.length; i++) {
		    vListData=vArrayListData[i];
		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
		}
		MakeComboObject3(financier, arrStr3, 0, 0);
  		idx++;
		break;		
	}
}

/**
 * HTML Objec enable in case of save success <br>
 * @param {ibsheet} SheetObj    IBSheet Object
 * @param {ibsheet} Event       Event after IBSheet saving 
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	formObj=document.form;
	
	if (ErrMsg == 0) {  // save success..
		// Combo INIT call
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> M.G.SET SERIAL RANGE

		var mgset_range_Val=sheetObj.GetCellValue(1, "mgset_range");
		formObj.mgset_range.text=mgset_range_Val;
		formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1, "eq_lot_no");
		formObj.f_cmd.value=SEARCH01;
			
			sheetObj.DoSearch("EES_CGM_2004GS.do", FormQueryString(formObj), {Sync:2}  );
		formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1,"eq_lot_no");
		mgset_range.SetSelectText(sheetObj.GetCellValue(1,"mgset_range"));
		formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1,"eq_pfx_cd");
		formObj.fm_ser_no.value=sheetObj.GetCellValue(1,"fm_ser_no");
		formObj.to_ser_no.value=sheetObj.GetCellValue(1,"to_ser_no");
		formObj.units.value=sheetObj.GetCellValue(1,"units");
		formObj.eq_spec_no_text.value=sheetObj.GetCellValue(1,"eq_spec_no");
		formObj.vndr_lgl_eng_nm_eqspec.value=sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_eqspec");
		formObj.mgst_vltg_capa.value=sheetObj.GetCellValue(1,"mgst_vltg_capa");
		formObj.mgst_fuel_capa.value=sheetObj.GetCellValue(1,"mgst_fuel_capa");
		var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
		if(tmpDate.length == 6)
		{
			formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
		}
		else
		{
			formObj.de_yrmon.value=tmpDate;
		}
		formObj.agreement_no.value=sheetObj.GetCellValue(1,"agreement_no");
		formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1,"agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObj.GetCellValue(1,"agmt_seq");
		formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1,"agmt_lstm_cd");
		formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1,"agmt_iss_ofc_cd");
		formObj.cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
		formObj.eq_lot_iss_dt.value=sheetObj.GetCellValue(1,"eq_lot_iss_dt");
		formObj.vndr_seq_agree.value=sheetObj.GetCellValue(1,"vndr_seq_agree");
		financier.SetSelectText(sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_agree"));
		eq_spec_no.SetSelectText(sheetObj.GetCellValue(1,"eq_spec_no"));
		sheetObj.SetCellValue(1, "mgset_range",formObj.mgset_range.text);
		sheetObj.SetRowStatus(1,"U");
		// HTML object DISABLE
		CgmSetFormObjDisable(formObj, true);
		ComShowCodeMessage("CGM00003");		
		
	}
	
}


/**
 * multi combo creation
 */
function initCombo(comboObj) {
	with(comboObj){
    	SetDropHeight(100);
    	SetMultiSelect(0);
    	SetMaxSelect(1);
	}
}
/**
 * combo object creation(MGSET SERIAL RANGE)
 */
function MakeComboObject1(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		// DESCRIPTION show
		cmbObj.InsertItem(i+1, arrCode[1], arrCode[codeCol]);
	}
	cmbObj.SetSelectIndex("" ,false);
}
/**
 * combo object creation(MMODEL NO)
 */
function MakeComboObject2(cmbObj, arrStr, codeCol, txtCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol], arrCode[txtCol]);
	}
	cmbObj.SetSelectIndex("" ,false);
}
/**
 * combo object creation(FINANCING CO)
 */
function MakeComboObject3(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "", "");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		// DESCRIPTION show
		
		cmbObj.InsertItem(i+1, arrCode[1], arrCode[codeCol]);
	}
	cmbObj.SetSelectIndex("" ,false);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
/**
 * key input limit
 */
function obj_keypress(){
	 obj=ComGetEvent();
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus=obj.dataformat;
	 switch(obj.dataformat) {
  	    case "engup":
	        if(ComGetEvent("name") == "eq_no" || ComGetEvent("name") == "agreement_no" ){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        if(ComGetEvent("name") == "eq_pfx_cd")
	        {
	        	ComKeyOnlyAlphabet("upper");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
	    case "int":
 	    	ComKeyOnlyNumber(obj);
 	        break;
  	 	case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	        break;
  	 	case "ym":
  	 		ComKeyOnlyNumber(obj);
  	        break;
	 }
}
/**
 * AXON event handling
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}

/** 
 * focus hyphen remove(DATAFORMAT "YMD")
 */
function domFunFocusDel(a){
	var formObj=document.form;
	obj=ComGetEvent("name");
	if(obj == "cre_dt"  ){
		document.form.cre_dt.value=ComReplaceStr(document.form.cre_dt.value, "-", "");
	}else if(obj == "de_yrmon"  ){
		document.form.de_yrmon.value=ComReplaceStr(document.form.de_yrmon.value, "-", "");
	}
}
/**
 * init object 
 */
function objectClear(){
	var formObj=document.form;
	//IBMultiCombo reset
	formObj.reset();
	comboObjects[0].SetSelectCode("");
	eq_spec_no.SetSelectCode("");
	financier.SetSelectCode("");
	formObj.de_yrmon.value="";
}
/**
 * setting grid value in case of CERT NO, AGREEMENT NO value chage
 */
function obj_blur(){
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	var formObj=document.form;
	var obj=ComGetEvent("name");
    ComChkObjValid(ComGetEvent());
    switch(obj){
    case "eq_lot_no":
    	sheetObj.SetCellValue(1, "eq_lot_no",formObj.eq_lot_no.value);
    	break;
    }
}
/**
 * INSERT*UPDATE by page status
 */
function pageStatusCall(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(formObj.page_status.value == "R"){
		sheetObj.SetRowStatus(1,"U");
	} else if(formObj.page_status.value == "N"){
		sheetObj.SetRowStatus(1,"I");
	}
}
/**
 * every object of form disable handling
 * exception) cgmdsbtype="no"
 * 
 */
function CgmSetFormObjDisable(form, flag) {
	var styleCursor="";
	// try {
	if (typeof (form) != "object" || form.tagName != "FORM") {
		alert("[ComEtcDataToForm Error] FORM 태그가 아닙니다.");
		return "";
	}
	if (flag == true) {
		styleCursor="";
		styleFilter="progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
	} else {
		styleCursor="cursor"
			styleFilter="";
	}
	var elems=form.elements;
	for ( var i=0; i < elems.length; i++) {
		if (elems[i].type.length > 0 && elems[i].type != "hidden"
			&& elems[i].name.substr(0, 4) != "btn_") {
			elems[i].disabled=flag;
		}
	}
/*	var styleCursor="";
	// try {
	if (typeof (form) != "object" || form.tagName != "FORM") {
		alert("[ComEtcDataToForm Error] FORM 태그가 아닙니다.");
		return "";
	}
	
//	$('.btn_img').attr('disabled', flag);
	if (flag == true) {
		styleCursor="";
		styleFilter="progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";
	} else {
		styleCursor="cursor"
		styleFilter="";
	}
	var elems=form.elements;
	for ( var i=0; i < elems.length; i++) {
		if (elems[i].type.length > 0 && elems[i].type != "hidden"
				&& elems[i].cgmdsbtype != "no") {
			elems[i].disabled=flag;
		}
	}*/
/*	var obj=document.getElementsByClassName("btn_img");
	for ( var i=0; i < obj.length; i++) {
		if (obj[i].getAttribute("name").substr(0, 4) == "btn_" && elems[i].cgmdsbtype != "no") {
//			obj[i].className += styleCursor;
			obj[i].disabled=flag;
			obj[i].style.filter=styleFilter;
		}
	}
	
	$('.btn_accent, .btn_normal').attr('disabled', !flag);
*/}

//
//*************************************************************************************************
function mgset_range_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
/*	if (newCode == ""){
		// row add function call
		sheetObj.RemoveAll();
		var row=sheetObj.DataInsert(0);
		sheetObj1.RemoveAll();
		var row=sheetObj1.DataInsert(0);
		sheetObj.SetCellValue(1, "eq_knd_cd","Z");
		// reset function call
		objectClear();
		formObj.page_status.value="N";
		// calling row status change function
		pageStatusCall();
		// HTML object ENABLE DISABLE function call
		CgmSetFormObjDisable(formObj, false);
	} else {
		sheetObj.SetCellValue(1, "eq_lot_no",comboObj.GetSelectCode());
		formObj.eq_lot_no_tmp.value=comboObj.GetSelectCode();
		// calling row status change function
		pageStatusCall();
		// Auto retrieve in case of Cert_no select
		// IBSHEET retrieve 
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		// HTML object ENABLE DISABLE function call
		CgmSetFormObjDisable(formObj, true);
		formObj.mgset_range_text.value = comboObj.GetText(parseInt(newIndex), 0);
	}*/
	
	if (newCode != ""){
		sheetObj.SetCellValue(1, "eq_lot_no",comboObj.GetSelectCode());
		formObj.eq_lot_no_tmp.value=comboObj.GetSelectCode();
		// calling row status change function
		pageStatusCall();
		// Auto retrieve in case of Cert_no select
		// IBSHEET retrieve 
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		// HTML object ENABLE DISABLE function call
		CgmSetFormObjDisable(formObj, true);
		formObj.mgset_range_text.value = comboObj.GetText(parseInt(newIndex), 0);
	}	
}

function financier_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	formObj.vndr_seq_agreevalue=financier.GetSelectCode();
	
	sheetObj.SetCellValue(1, "vndr_seq_agree",financier.GetSelectCode(),false);
	sheetObj.SetCellValue(1, "vndr_lgl_eng_nm_agree",financier.GetSelectText(),false);
}
/**
 * setting grid value in case of FINANCING CO value change
 */
function financing_co_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	sheetObj.SetCellValue(1, "finc_vndr_seq",financing_co.GetSelectCode());
	// calling row status change function
	pageStatusCall();
}
//*************************************************************************************************
//*************************************************************************************************
/**
 * 1. XML data push to each column.
 */
function sheet1_OnChange(sheetObj, Row, Col) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];

	with (sheetObj) {
		var colName=ColSaveName(Col);
		switch (colName) {
		case "eq_lot_no":
		 	//server  duplication check
			var eqLotNoTmp=GetCellValue(Row, "eq_lot_no");
			// XML data push to each column
			if(eqLotNoTmp.length > 0) {
				formObj.f_cmd.value=SEARCH01;
				document.form.eq_lot_no_tmp.value=eqLotNoTmp;
 				var sXml=GetSearchData("EES_CGM_2004GS.do", FormQueryString(formObj));
			}
			break;
		}
	}
}
/**
 * 1. XML data push to each column.
 */
function sheet2_OnChange(sheetObj, Row, Col) {
	var formObj=document.form;
	var sheetObj0=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	var prefix="";
	var chk=true;
	
	with (sheetObj) {
		var colName=ColSaveName(Col);
		switch (colName) {
		case "eq_spec_no":
		 	//server  duplication check
			var eqSpecNoTmp=GetCellValue(Row, "eq_spec_no");
			// XML data push to each column
			if(eqSpecNoTmp.length > 0) {
				formObj.f_cmd.value=SEARCH02;
				document.form.eq_spec_no_tmp.value=eqSpecNoTmp;
 				var sXml=GetSearchData("EES_CGM_2004GS.do", FormQueryString(formObj));
				if(DomXml2String(sXml, "eq_spec_no") == null || DomXml2String(sXml, "eq_spec_no") == "") {
					// delete cell and focus move
					ComShowCodeMessage("CGM10012");
					// Setting Cell value to Null
					sheetObj.SetCellValue(Row, Col,"",0);
					// focus to grid
					sheetObj.SelectCell(Row, Col, true);
					formObj.eq_spec_no_tmp.value="";
					return;
				} else {
					// setting cell value
					var formObj=document.form;
                    var sheetObj=sheetObjects[0];
					// setting IBSHEET value by ETCDATA
					SetCellValue(Row,"vndr_lgl_eng_nm_eqspec",DomXml2String(sXml,"vndr_lgl_eng_nm_eqspec"),0);
					SetCellValue(Row,"mgst_vltg_capa",DomXml2String(sXml,"mgst_vltg_capa"),0);
					SetCellValue(Row,"mgst_fuel_capa",DomXml2String(sXml,"mgst_fuel_capa"),0);
                    SetCellValue(Row,"eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
                    SetCellValue(Row,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
                    SetCellValue(Row,"chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);
					formObj.vndr_lgl_eng_nm_eqspec.value=DomXml2String(sXml,"vndr_lgl_eng_nm_eqspec");
					formObj.mgst_vltg_capa.value=DomXml2String(sXml,"mgst_vltg_capa");
					formObj.mgst_fuel_capa.value=DomXml2String(sXml,"mgst_fuel_capa");
					//3. put value SHEET1 to sync with SHEET2
					sheetObj0.SetCellValue(Row, "eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
					sheetObj0.SetCellValue(Row, "eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
					sheetObj0.SetCellValue(Row, "chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);
				}
			}
			break;
		}
	}
}
 /** 
  * HTML object onchange event handling
  * @author chungpa 20090805.
  */
 function obj_change() {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=ComGetEvent("name");
	
	switch(obj){
	case "agreement_no":
		// AGREEMENT NO retrieve( retrieve)
		formObj.f_cmd.value=SEARCH12;
		//alert('----1');
	    if(formObj.agreement_no.value == '')
	    {
	 		formObj.agreement_no.value="";
	    	formObj.agmt_lstm_cd.value="";
	    	formObj.agmt_iss_ofc_cd.value="";
	    	formObj.cre_dt.value="";
	    	sheetObjects[0].RemoveAll();
	    	//ComShowCodeMessage("CGM10004", "Agreement No.");
	    	return false;
	    }else
	    {
	    	formObj.agmt_no.value=formObj.agreement_no.value;
	    	formObj.agreement_no.value = formObj.agreement_no.value.substring(0,3)+ComLpad(formObj.agreement_no.value.substring(3),6,"0");
	    	
	    }
 	    var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do" , FormQueryString(formObj));
	    // data count
		var dataCount=ComGetTotalRows(sXml);
		// data existing
		if(dataCount>0){
	    	formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
	    	formObj.agmt_iss_ofc_cd.value=DomXml2String(sXml,"agmt_iss_ofc_cd");
	    	formObj.cre_dt.value=DomXml2String(sXml,"cre_dt");
	    	var DtTmp =DomXml2String(sXml,"cre_dt");
			//var creDtTmp = DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
			formObj.cre_dt.value=DtTmp;
			// push value in case retrieve after AGREEMENT NO inserting
			sheetObj.SetCellValue(1, "agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"));
		    sheetObj.SetCellValue(1, "agreement_no",DomXml2String(sXml,"agmt_no"));
		    sheetObj.SetCellValue(1, "agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"));
		    sheetObj.SetCellValue(1, "agmt_iss_ofc_cd",DomXml2String(sXml,"agmt_iss_ofc_cd"));
		    sheetObj.SetCellValue(1, "cre_dt",DomXml2String(sXml,"cre_dt"));
		    
		    sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",DomXml2String(sXml,"agmt_ofc_cty_cd"));
		    sheetObj.SetCellValue(1, "agmt_seq",DomXml2String(sXml,"agmt_seq"));
		    formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
			
		    agreementNoChk(formObj.agmt_lstm_cd.value);
			return true;
	    } else {
	    	// Form Object reset
	    	//error patch
	    	//inserting null, another control OK 
	    	if(formObj.agreement_no.value != "")
	    	{
		    	formObj.agreement_no.value="";
		    	formObj.agmt_iss_ofc_cd.value="";
		    	formObj.agmt_lstm_cd.value="";
		    	formObj.cre_dt.value="";
		    	sheetObjects[0].RemoveAll();
		    	ComShowCodeMessage("CGM10004", "Agreement No.");
		    	if(formObj.agreement_no.disabled != true)
//		    		formObj.agreement_no.focus();
		    	return true;
	    	}
	    	else
	    	{
	    		formObj.agreement_no.value="";
		    	formObj.agmt_iss_ofc_cd.value="";
		    	formObj.agmt_lstm_cd.value="";
		    	formObj.cre_dt.value="";
		    	sheetObjects[0].RemoveAll();
		    	ComShowCodeMessage("CGM10004", "Agreement No.");
	 		    return true;
	 	    }
	 	}
	 	break;	
	 	

	 }
 }
/**
 * HTML Object event handling
 * FROM ~ TO CHASSIS NO compare and UNITS calc
 */
function obj_focusout() {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=ComGetEvent("name");
	switch(obj){
	case "eq_pfx_cd":
		sheetObj.SetCellValue(1, "eq_pfx_cd",formObj.eq_pfx_cd.value);
		if(formObj.fm_ser_no.value != "" && formObj.eq_pfx_cd.value != ""){
			// Eq existing function call
	    	equipChkNo();
		}
    	if(	   formObj.fm_ser_no.value != "" 
    		&& formObj.fm_ser_no.value != null
        	&& formObj.to_ser_no.value != "" 
        	&& formObj.to_ser_no.value != null)
    	{
    		equipChkFmToValid();
    	}
		break;
	case "fm_ser_no":
		if(formObj.fm_ser_no.value == "" || formObj.fm_ser_no.value == null){
				return false;
		} else {
	    	var pfTmp=formObj.eq_pfx_cd.value;
	    	var fmTmp=formObj.fm_ser_no.value;
	    	if(fmTmp.length == 6){
	    		var fmSerNoVal=fmTmp;
	    	} else if(fmTmp.length == 5){
	    		var fmSerNoVal="0"+fmTmp;
	    	} else if(fmTmp.length == 4){
	    		var fmSerNoVal="00"+fmTmp;
	    	} else if(fmTmp.length == 3){
	    		var fmSerNoVal="000"+fmTmp;
	    	} else if(fmTmp.length == 2){
	    		var fmSerNoVal="0000"+fmTmp;
	    	} else if(fmTmp.length == 1){
	    		var fmSerNoVal="00000"+fmTmp;
	    	}
	    	// pass value to grid from form
	    	sheetObj.SetCellValue(1, "fm_ser_no",fmSerNoVal,0);
			formObj.fm_ser_no.value=fmSerNoVal;
			formObj.eq_lot_no_tmp.value=pfTmp+fmSerNoVal;
	    	sheetObj.SetCellValue(1, "eq_lot_no",pfTmp+fmSerNoVal);
			/*if(formObj.fm_ser_no.value != "" && formObj.eq_pfx_cd.value != ""){
				// Eq existing function call
		    	equipChkNo();
			}*/
        	if(	   formObj.fm_ser_no.value != "" 
        		&& formObj.fm_ser_no.value != null
            	&& formObj.to_ser_no.value != "" 
            	&& formObj.to_ser_no.value != null)
        	{
        		equipChkFmToValid();
        	}
		}
    	break; 
    case "to_ser_no":
    	if(formObj.to_ser_no.value == "" || formObj.to_ser_no.value == null){
				return false;
    	} else {
				var toTmp=formObj.to_ser_no.value;
				if(toTmp.length == 6){
					var toSerNoVal=toTmp;
				} else if(toTmp.length == 5){
					var toSerNoVal="0"+toTmp;
				} else if(toTmp.length == 4){
					var toSerNoVal="00"+toTmp;
				} else if(toTmp.length == 3){
					var toSerNoVal="000"+toTmp;
				} else if(toTmp.length == 2){
					var toSerNoVal="0000"+toTmp;
				} else if(toTmp.length == 1){
					var toSerNoVal="00000"+toTmp;
				}
				formObj.to_ser_no.value=toSerNoVal;
				sheetObj.SetCellValue(1, "to_ser_no",toSerNoVal,0);
	        	if(	   formObj.fm_ser_no.value != "" 
	        		&& formObj.fm_ser_no.value != null
	            	&& formObj.to_ser_no.value != "" 
	            	&& formObj.to_ser_no.value != null)
	        	{
    		equipChkFmToValid();
    	}
			}
    	break;
    case "cre_dt":
    	sheetObj.SetCellValue(1, "eq_lot_iss_dt",formObj.eq_lot_iss_dt.value.replaceStr("-", ""));
    	break;
    case "de_yrmon":
    	sheetObj.SetCellValue(1, "de_yrmon",formObj.de_yrmon.value.replaceStr("-", ""));     	
    	break;
	}
}
/**
 * Eq No exist checking
 */
function equipChkNo(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=ComGetEvent();
	// Eq No exist data checking
	formObj.f_cmd.value=SEARCH04;
 	var sXml=sheetObj.GetSearchData("EES_CGM_2004GS.do", FormQueryString(formObj));
	// data count
	var dataCount=ComGetTotalRows(sXml);
	// data existing
	if(dataCount > 0){
		// show Eq No in case of dup data
		ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_lot_no"));
		if(formObj.fm_ser_no.disabled != true)
		{
			formObj.fm_ser_no.value="";
//			formObj.fm_ser_no.focus();
		}
		return;			
	}else
	{
		return;
	}
}
/**
 * check Eq No FM- TO existing <br>
 * @param
 * @return true/false
 * @author 
 * @version 
 */ 
function equipChkFmToNo(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=ComGetEvent();
	// Eq No exist data checking
	formObj.f_cmd.value=SEARCH06;
 	var sXml=sheetObj.GetSearchData("EES_CGM_1005GS.do", FormQueryString(formObj)); //show sheet name in case of more than 2 sheet
	// data count
	var dataCount=ComGetTotalRows(sXml);
	// data existing
	if(dataCount > 0){
		// show Eq No in case of dup data
		ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_no"));
		formObj.fm_ser_no.value="";
		formObj.to_ser_no.value="";
		formObj.units.value="";
		if(formObj.fm_ser_no.disabled != true)
//			formObj.fm_ser_no.focus();
		return false;			
	}else
	{
		return true;
	}
}
 /**
  * check Eq No FM- TO existing <br>
  * @param
  * @return true/false
  * @author 
  * @version 
  */ 
 function equipChkFmToValid(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var unTmp="";
  	var pfTmp=formObj.eq_pfx_cd.value;
	var fmTmp=formObj.fm_ser_no.value;
	var toTmp=formObj.to_ser_no.value;
	if(fmTmp != "" && toTmp != ""){
    	if(Number(toTmp) < Number(fmTmp)){
    		ComShowCodeMessage("CGM10027");
    		formObj.to_ser_no.value="";
//    		formObj.to_ser_no.focus();
    		return false;
    	}
	}
	if(fmTmp != "" && toTmp != ""){
		unTmp=ComAddComma(Number(toTmp) - Number(fmTmp) + 1)
		formObj.units.value=unTmp;
    	sheetObj.SetCellValue(1, "units",unTmp.replace(",",""));
	}
	// grid value setting, inserted object value setting
	if(equipChkFmToNo()== false)
	{
		return false;
	}
	sheetObj.SetCellValue(1, "to_ser_no",toTmp,0);
	// CERT & CHASSIS LIST creation, IBSHEET value setting
	sheetObj.SetCellValue(1, "mgset_range",pfTmp+fmTmp+" - "+pfTmp+toTmp+" "+unTmp);
	return true;
 }
/**
 * inserting value from PROGRAMNO POPUP
 */   
function setProgramNo(aryPopupData, row, col, sheetIdx){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 var agreeNo="";
	 var referNo="";
	 var officeCd="";
	 var agreeDt="";
	 var lstmCd="";
	 var verNo="";
	 var vndrSeq="";
	 var i=0;
	 
	 //alert(DomXml2String(sXml,"eq_lot_iss_dt"));
	 for(i=0; i < aryPopupData.length; i++){
/*
		 alert(aryPopupData[i][0]); // VERSION NO           : 1
		 alert(aryPopupData[i][1]); // 0
		 alert(aryPopupData[i][2]); // AGREEMENT NO         : NYC003144
		 alert(aryPopupData[i][3]); // REFERENCE NO         : T008904
		 alert(aryPopupData[i][4]); // TERM                 : LT
		 alert(aryPopupData[i][5]); // LESSOR               : 105621
		 alert(aryPopupData[i][6]); // Lessor Name          : FLEXI-VNA LEASING (NYC)
		 alert(aryPopupData[i][7]); // EFFECTIVE DATE(FROM) : 19970101
		 alert(aryPopupData[i][8]); // EFFECTIVE DATE(TO)   : 19991231
		 alert(aryPopupData[i][9]); // U
		 alert(aryPopupData[i][10]);// U
		 alert(aryPopupData[i][11]);// U
		 alert(aryPopupData[i][12]);// NYC
		 alert(aryPopupData[i][13]);// 3144
		 alert(aryPopupData[i][14]);
*/
		 verNo=verNo    + aryPopupData[i][0];  // ver_no
		 agreeNo=agreeNo  + aryPopupData[i][2];  // agreement_no
		 lstmCd=lstmCd   + aryPopupData[i][4];  // lease term
		 officeCd=officeCd + aryPopupData[i][9];  // office_cd
		 agreeDt=agreeDt  + aryPopupData[i][10]; // agreement date
		 vndrSeq=vndrSeq  + aryPopupData[i][5];	// vndr_seq
	 }
	
	  formObj.agmt_ver_no.value=verNo;
	  formObj.agreement_no.value=agreeNo;
	  formObj.agmt_lstm_cd.value=lstmCd;
	  formObj.agmt_iss_ofc_cd.value=officeCd;
	  var DtTmp =agreeDt;
	  if(DtTmp.length == 8)
	  {
		  var creDtTmp=DtTmp.substr(0,4)+"-"+DtTmp.substr(4,2)+"-"+DtTmp.substr(6,2);
		  formObj.cre_dt.value=creDtTmp;
	  }else
	  {
		  formObj.cre_dt.value=agreeDt;
	  }
	  formObj.agmt_ofc_cty_cd.value=agreeNo.substring(0, 3);
	  formObj.agmt_seq.value=agreeNo.substring(4, 10);
	  sheetObj.SetCellValue(1, "agmt_ver_no",verNo);
	  sheetObj.SetCellValue(1, "agreement_no",agreeNo);
	  sheetObj.SetCellValue(1, "agmt_lstm_cd",lstmCd);
	  sheetObj.SetCellValue(1, "agmt_iss_ofc_cd",officeCd);
	  sheetObj.SetCellValue(1, "vndr_seq",vndrSeq);
	  sheetObj.SetCellValue(1, "cre_dt",agreeDt);
	  sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",agreeNo.substring(0, 3));
	  sheetObj.SetCellValue(1, "agmt_seq",agreeNo.substring(4, 10));
	  sheetObj.SetCellValue(1, "eq_lot_iss_dt",agreeDt);
	  formObj.eq_lot_iss_dt.value=agreeDt;
	  agreementNoChk(lstmCd);
}
///////////////////////////////////////////////////////////////////////////////////////////////////
// DomXml2String dont editing
///////////////////////////////////////////////////////////////////////////////////////////////////
function agreementNoChk(lstmCd){
	var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	if(!(lstmCd == "OW" || lstmCd == "OL" || lstmCd == "LP")){
		// show message, object reset
		ComShowCodeMessage("CGM10029");
    	formObj.agreement_no.value="";
    	formObj.agmt_iss_ofc_cd.value="";
    	formObj.agmt_lstm_cd.value="";
    	formObj.cre_dt.value="";
    	sheetObj.SetCellValue(1, "agmt_ver_no",'');
		sheetObj.SetCellValue(1, "agreement_no",'');
		sheetObj.SetCellValue(1, "agmt_lstm_cd",'');
		sheetObj.SetCellValue(1, "agmt_iss_ofc_cd",'');
		sheetObj.SetCellValue(1, "cre_dt",'');
		sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",'');
		sheetObj.SetCellValue(1, "agmt_seq",'');
	}
}
/**
 * value check logic
 * @author  
 */
function obj_keyup(){
	var formObj=document.form;
 	var sheetObj=sheetObjects[0];
 	obj=ComGetEvent("name");
 	switch(obj){
		case "eq_pfx_cd":
 			if(formObj.eq_pfx_cd.value.length == 4)
// 				formObj.fm_ser_no.focus();
 		break;
 		case "fm_ser_no":
 			if(formObj.fm_ser_no.value.length == 6)
// 				formObj.to_ser_no.focus();
 	 	break;
 		case "to_ser_no":
 			if(formObj.to_ser_no.value.length == 6)
// 				formObj.units.focus();
 	 	break;
 	}
}
 /**
 * function(ex:btn_save) role(trole) apply  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */     
 function tRoleApply() {
//	  var formObj=document.form;
//	  if(formObj.trole.value == "Authenticated")
//	  {
//	  }else
//	  {
//		  ComBtnDisable("btn_Save");
//		  //ComBtnDisable("btn_FA I/F");
//	  }
 }  
/* developer jop end */

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	formObj.eq_lot_no_tmp.value=sheetObj.GetCellValue(1,"eq_lot_no");
	formObj.mgset_range_text.value=sheetObj.GetCellValue(1,"mgset_range");
	formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1,"eq_pfx_cd");
	formObj.fm_ser_no.value=sheetObj.GetCellValue(1,"fm_ser_no");
	formObj.to_ser_no.value=sheetObj.GetCellValue(1,"to_ser_no");
	formObj.units.value=sheetObj.GetCellValue(1,"units");
	formObj.eq_spec_no_text.value=sheetObj.GetCellValue(1,"eq_spec_no");
	formObj.vndr_lgl_eng_nm_eqspec.value=sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_eqspec");
	formObj.mgst_vltg_capa.value=sheetObj.GetCellValue(1,"mgst_vltg_capa");
	formObj.mgst_fuel_capa.value=sheetObj.GetCellValue(1,"mgst_fuel_capa");
	var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
	if(tmpDate.length == 6)
	{
		formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
	}
	else
	{
		formObj.de_yrmon.value=tmpDate;
	}
	formObj.agreement_no.value=sheetObj.GetCellValue(1,"agreement_no");
	formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1,"agmt_ofc_cty_cd");
	formObj.agmt_seq.value=sheetObj.GetCellValue(1,"agmt_seq");
	formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1,"agmt_lstm_cd");
	formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1,"agmt_iss_ofc_cd");
	formObj.cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
	formObj.vndr_seq_agree.value=sheetObj.GetCellValue(1,"vndr_seq_agree");
	// alert(sheetObj.CellValue(1,"vndr_lgl_eng_nm_agree"));
	if(sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_agree") == ""){
		financier.SetSelectText("",0);
	} else {
		financier.SetSelectText(sheetObj.GetCellValue(1,"vndr_lgl_eng_nm_agree"));
	}
	eq_spec_no.SetSelectText(sheetObj.GetCellValue(1,"eq_spec_no"));
	formObj.page_status.value="R";
	formObj.page_status.value="U";
	sheetObj.SetRowStatus(1,"U");
}


/**
 * setting grid value in case of SPEC NO value change
 */
/*****
function eq_spec_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	if(Text == ""){
		formObj.vndr_lgl_eng_nm_eqspec.value="";
		formObj.mgst_vltg_capa.value="";
		formObj.mgst_fuel_capa.value="";
	} else {
		sheetObj.SetCellValue(1, "eq_spec_no",comboObj.GetSelectCode());
		sheetObj.SetCellValue(1, "eq_spec_no",comboObj.GetSelectCode());
		formObj.eq_spec_no_tmp.value=comboObj.GetSelectCode();
		sheetObj.SetCellValue(1, "vndr_lgl_eng_nm_eqspec",formObj.vndr_lgl_eng_nm_eqspec.value);
		sheetObj.SetCellValue(1, "mgst_vltg_capa",formObj.mgst_vltg_capa.value);
		sheetObj.SetCellValue(1, "mgst_fuel_capa",formObj.mgst_fuel_capa.value);
	}
}
*************/

function eq_spec_no_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){	
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var sheetObj1=sheetObjects[1];
	
	formObj.eq_spec_no_text.value = newcode;
	sheetObj.SetCellValue(1, "eq_spec_no", newcode);
	
	if(newtext == ""){
		formObj.vndr_lgl_eng_nm_eqspec.value = "";
		formObj.mgst_vltg_capa.value         = "";
		formObj.mgst_fuel_capa.value         = "";
	} else {
		sheetObj.SetCellValue(1, "eq_spec_no", newcode );
		sheetObj1.SetCellValue(1, "eq_spec_no", newcode );
		formObj.eq_spec_no_tmp.value         = newcode;
	
		sheetObj.SetCellValue(1, "vndr_lgl_eng_nm_eqspec", formObj.vndr_lgl_eng_nm_eqspec.value);
		sheetObj.SetCellValue(1, "mgst_vltg_capa",  formObj.mgst_vltg_capa.value);
		sheetObj.SetCellValue(1, "mgst_fuel_capa",  formObj.mgst_fuel_capa.value);
	}
}

function eq_spec_no_OnBlur() {
	if(eq_spec_no.GetText(parseInt(eq_spec_no.GetSelectIndex()), 0) != undefined){
		document.form.eq_spec_no_text.value = eq_spec_no.GetText(parseInt(eq_spec_no.GetSelectIndex()), 0);
	}else{
		document.form.eq_spec_no_text.value = "";
	}
}