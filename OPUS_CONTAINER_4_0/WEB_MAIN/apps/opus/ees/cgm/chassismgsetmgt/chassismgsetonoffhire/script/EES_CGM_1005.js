/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1005.js
*@FileTitle  : Own Chassis Master Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1005 : ees_cgm_1005 business script for
 */
	function ees_cgm_1005() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.setComboObject=setComboObject;
		this.initCombo=initCombo;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer jop */
	//common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
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
		case "btn_retrieve":
			if(comboObjects[0].GetSelectText()== ""){
				ComShowCodeMessage("CGM10004", "Cert & Chassis List");
				return;
			}
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			CgmSetFormObjDisable(formObj, true);
			break;
			
		case "btn_new":
			sheetObj.RemoveAll();
			var row=sheetObj.DataInsert(0);
			sheetObj1.RemoveAll();
			var row=sheetObj1.DataInsert(0);
			formObj.reset();
			comboObjects[0].SetSelectCode("");
			eq_spec_no.SetSelectCode("");
			financing_co.SetSelectCode("");
			sheetObj.SetCellValue(1, "eq_knd_cd","Z");
			sheetObj.SetRowStatus(1,"I");
			formObj.page_status.value="N";
			// HTML object ENABLE DISABLE function call
			CgmSetFormObjDisable(formObj, false);
			break;
			
		case "btn_save":
			if(formObj.eq_lot_no.value == ""){
				ComShowCodeMessage("CGM10004", "Cert. No.");
				if(formObj.eq_lot_no.disabled != true)
				return;
			}
			if(formObj.eq_lot_iss_dt.value == ""){
				ComShowCodeMessage("CGM10004", "Cert. Iss Date");
				if(formObj.eq_lot_iss_dt.disabled != true)
				return;
			}
			if(formObj.eq_pfx_cd.value == ""){
				ComShowCodeMessage("CGM10004", "Serial No.");
				if(formObj.eq_pfx_cd.disabled != true)
				return;
			}
			if(formObj.fm_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial No.");
				if(formObj.fm_ser_no.disabled != true)
				return;
			}
			if(formObj.to_ser_no.value == ""){
				ComShowCodeMessage("CGM10004", "Serial No.");
				if(formObj.to_ser_no.disabled != true)
				return;
			}
			if(eq_spec_no.GetSelectText()== ""){
				ComShowCodeMessage("CGM10004", "Spec. No.");
				return;
			}else{
			}
			if(formObj.de_yrmon.value == ""){
				ComShowCodeMessage("CGM10004", "Delivery Month");
				if(formObj.de_yrmon.disabled != true)
				return;
			}
			if(formObj.agreement_no.value == ""){
				ComShowCodeMessage("CGM10004", "Agreement No");
				if(formObj.agreement_no.disabled != true)
				return;
			}
	 		sheetObj.SetWaitImageVisible(0);
	 		ComOpenWait(true);		 
			doActionIBSheet(sheetObj,formObj,IBSAVE);
	 		ComOpenWait(false);		 
			break;
			
		case "FA I/F":
			var param="";
			if(eq_cert_chassis_list.GetSelectText()!= '' && formObj.eq_pfx_cd.disabled == true)
		  	{
		  		var pgmNo='EES_CGM_1146';
		  		var pgmUrl='/opuscntr/EES_CGM_1146.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
		  		//1146
		  		var eq_knd_cd='Z'; // Eq kind=> chassis:'Z', MGSET:'G'  
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
		    } else
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

		case "btns_Calendar_a" :
			if(window.ComGetEvent().disabled) {
				return;
			}
			var cal=new ComCalendar();
			cal.select(formObj.eq_lot_iss_dt, "yyyy-MM-dd");
			break;
			// show month calendar
			
		case "btns_Calendar_b" :
			if(window.ComGetEvent().disabled) {
				return;
			}
			var cal=new ComCalendar();
			cal.setDisplayType("month");
			cal.select(formObj.de_yrmon, "yyyy-MM");
			break;
			
		case "btns_ComOpenPopupWithTargetAgree":
			if(window.ComGetEvent().disabled) {
				return;
			}
			ComOpenPopup('/opuscntr/EES_CGM_1117.do', 820, 420, "setProgramNo", "1,0,1,1,1,1", true, false);
			break;
		} // end switch
//		tRoleApply();
	  } catch(e) {
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
	* param : combo_obj ==> combo object
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
		// axon event 등록
//		axon_event.addListenerFormat('keypress',			'obj_keypress',		form);
//		axon_event.addListenerFormat('keypress',			'obj_keydown',		form);
//		axon_event.addListenerForm	('keyup',				'obj_keyup',		form);
//		axon_event.addListenerForm  ('beforedeactivate',	'obj_deactivate',	form);
//		axon_event.addListenerFormat('beforeactivate',		'obj_activate',		form);
		axon_event.addListener      ("focusout",			"obj_focusout",		"eq_pfx_cd", "fm_ser_no", "to_ser_no", "eq_lot_iss_dt", "de_yrmon");
		axon_event.addListener      ('blur',				'obj_blur',			'eq_lot_no');
		axon_event.addListener		('change',				'obj_change',		'agreement_no');
		
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
	   	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
		CgmSetFormObjDisable(formObj, true); //
		ComBtnEnable("btn_save");
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_new");
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
			      var HeadTitle="ibflag|cert_chassis_no|eq_lot_no|eq_lot_iss_dt|serial_no|eq_pfx_cd|fm_ser_no|to_ser_no|agmt_ver_no|units|de_yrmon|eq_spec_no|eq_tpsz_cd|vndr_seq|vndr_lgl_eng_nm|agreement_no|agmt_ref_no|agmt_iss_ofc_cd|agmt_ofc_cty_cd|cre_dtc|agmt_lstm_cd|finc_vndr_seq|finc_vndr_lgl_eng_nm|cre_dta|cre_usr_id|upd_dt|upd_usr_id|eq_knd_cd|eq_no|agmt_seq|eq_lot_no_etc|chss_tare_wgt";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cert_chassis_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_lot_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_lot_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"serial_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_pfx_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_ser_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_ser_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ver_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"units",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_yrmon",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_iss_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dtc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"finc_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"finc_vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dta",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_lot_no_etc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(200);
	            }
		    break;
		case 2:
		    with(sheetObj){
			      var HeadTitle="eq_spec_no|eq_tpsz_cd|vndr_lgl_eng_nm|vndr_seq|chss_tare_wgt";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(200);
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
			sheetObj.DoSearch("EES_CGM_1005GS.do", FormQueryString(formObj) );
			
			break;
			
			// SAVE
		case IBSAVE:
			formObj.f_cmd.value=MULTI;
			
			if(sheetObj.GetCellValue(1,"ibflag") == "I"){
				
				formObj.chss_tare_wgt.value=sheetObj.GetCellValue(1, "chss_tare_wgt");
				
				sheetObj.DoSave("EES_CGM_1005GS.do", FormQueryString(formObj));

			} else if(sheetObj.GetCellValue(1,"ibflag") == "U"){

				sheetObj.DoSave("EES_CGM_1005GS.do", FormQueryString(formObj));
					
			}
			break;
			
			// COMBO >> CERT & CHASSIS LIST
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value=SEARCH10;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
			MakeComboObject2_2(comboObjects[0], arrStr, 0);
			break;
			
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value=SEARCH03;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
			MakeComboObject2(eq_spec_no, arrStr, 0, 0);
			break;
			
		case IBSEARCH_ASYNC03:
			formObj.f_cmd.value=SEARCH11;
			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
			MakeComboObject3(financing_co, arrStr, 0, 0);
			break;
			
		case IBRESET:
			var idx=0
			var sXml2=document.form2.sXml.value;
			var arrXml=sXml2.split("|$$|");
			if ( arrXml[idx] == null ) {return;}
			var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
		    var arrStr1=new Array();
			for ( var i=0; i < vArrayListData.length; i++) {
			    vListData=vArrayListData[i];
			    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
			}
			MakeComboObject2_2(comboObjects[0], arrStr1, 0);
			idx++;        		
			if ( arrXml[idx] == null ) {return;}
			var vArrayListData2=ComCgmXml2ListMap(arrXml[idx]);
		    var arrStr2=new Array();
			for ( var i=0; i < vArrayListData2.length; i++) {
			    vListData=vArrayListData2[i];
			    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
			}
//			prompt("in IBRESET : ", arrStr2);
			MakeComboObject2(eq_spec_no, arrStr2, 0, 1);
	  		idx++;
			if ( arrXml[idx] == null ) {return;}
			var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
		    var arrStr3=new Array();
			for ( var i=0; i < vArrayListData.length; i++) {
			    vListData=vArrayListData[i];
			    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
			}
			MakeComboObject3(financing_co, arrStr3, 0, 0);
	  		idx++;
			break;		
		}
	}
	/**
	* multi combo creation
	*/
	function initCombo(comboObj) {
		switch(comboObj.options.id) {
			case "eq_cert_chassis_list":
	  	        with(comboObj) {
	  	        	Code="";
	  	            Text="";
	  	            SetDropHeight(190);
	  	            SetMultiSelect(0);
	  	            SetMaxSelect(1);
	  	            SetEnable(1);
	            	SetMaxLength(100);
	  	        }
				break;
			
			case "eq_spec_no":
				with(comboObj){
					SetDropHeight(100);
					SetMultiSelect(0);
					SetMaxSelect(1);
				}			
				break;
			
			case "financing_co":
				with(comboObj){
					SetDropHeight(100);
					SetMultiSelect(0);
					SetMaxSelect(1);
				}			
				break;
		}
	}
	/** 
	* add combo(SPEC NO)
	*/ 
	function ComCgmMakeMultiCombo1(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		var arrCode=arrStr[0].split("|");
		for (var i=0; i < arrCode.length;i++ ) {
			var arrCode2=arrCode[i].split("|");
			cmbObj.InsertItem(i+1, arrCode2[txtCol], arrCode2[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	/**
	* combo object creation(CERT&CHASSIS LIST * FINANCING CO)
	* 
	*/
	function MakeComboObject1(cmbObj, arrStr, txtCol, codeCol) {
		comboObjects[0].RemoveAll();
		comboObjects[0].InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			// DESCRIPTION show
			comboObjects[0].InsertItem(i+1, arrCode[1], arrCode[codeCol]);
		}
		comboObjects[0].SetSelectIndex("" ,false);
	}
	/**
	* combo object creation(SPEC NO)
	*/
	function MakeComboObject2(cmbObj, arrStr, codeCol, txtCol) {
		comboObjects[1].RemoveAll();
		comboObjects[1].InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
//			alert(codeCol + ", " + txtCol);
//			alert(arrCode[codeCol] + ", " + arrCode[txtCol]);
			comboObjects[1].InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
//			alert(cmbObj.GetText(i+1, 0));
		}
		comboObjects[1].SetSelectIndex("" ,false);
	}
	/**
	 * combo object creation
	 * @author 
	 * @version 20091113
	 */
	function MakeComboObject2_2(cmbObj, arrStr, col) {
		comboObjects[0].RemoveAll();
		comboObjects[0].InsertItem(0, "", "");
		for (var i=0; i < arrStr.length;i++ ) {
			var arrCode=arrStr[i].split("|");
			comboObjects[0].InsertItem(i+1, arrStr[i], arrCode[col]);
		}
		comboObjects[0].SetSelectIndex("" ,false);
	}
	/**
	* combo object creation(CERT&CHASSIS LIST * FINANCING CO)
	* 
	*/
	function MakeComboObject3(cmbObj, arrStr, txtCol, codeCol) {
		comboObjects[2].RemoveAll();
		comboObjects[2].InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			// DESCRIPTION show
			comboObjects[2].InsertItem(i+1, arrCode[1], arrCode[codeCol]);
		}
		comboObjects[2].SetSelectIndex("" ,false);
	}
	/**
	* handling process for input validation
	*/
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
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
			if(obj.name == "eq_no" || obj.name=="agreement_no"){
				ComKeyOnlyAlphabet("uppernum");
			}
			if( obj.name=="eq_pfx_cd" ){
				ComKeyOnlyAlphabet("upper");
			}
			break;
		case "isnum":
			ComKeyOnlyNumber(obj);
			break;
		case "int":
			ComKeyOnlyNumber(obj);
			break;
			// day calendar
		case "ymd":
			ComKeyOnlyNumber(obj);
			break;
			// month calendar
		case "ym":
			ComKeyOnlyNumber(obj);
			break;
			// engUp, number, -
		case "enghi":
			CgmKeyOnlyAlphabet("uppernum");
			break;
		}
	}
		
	/**
	 * Object Keydown event handling  <br>
	 * press enter retrieve action in case of agreement_no status.  <br>
	 */ 
	function obj_keydown(){
		var obj=ComGetEvent();
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		switch(ComGetEvent("name")){
		case 'agreement_no':
			
			var keyValue=null;
			if(event == undefined || event == null) {
				keyValue=13;
			} else {
				keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			}
			if(keyValue != 13) return;
			var agmtNo=formObj.agreement_no.value;
			var result=true;
			if(agmtNo != ""){
				if(agmtNo.length <= 3){
					result=false;
				} else {
					if(ComIsNumber(agmtNo.substring(3))==false){
						result=false;
					}
				}
			} else {
				result=true;
			}
			if(!result){
				ComShowCodeMessage('CGM10004','Agreement No.');
				formObj.agreement_no.value="";
				ComSetFocus(formObj.agreement_no);
			} else {
				
				if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04)){
//						if(formObj.agreement_no.disabled != true)
					
				} else {
					ComKeyEnter();
				}
				
			}
			break;
		}
	}
	
	/**
	 * value check logic
	 * @author 
	 */
	function obj_keyup(){
		var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	obj=ComGetEvent();
	 	switch(ComGetEvent("name")){
	 		case "eq_pfx_cd":
	 			if(formObj.eq_pfx_cd.value.length == 4)
//	 				formObj.fm_ser_no.focus();
	 		break;
	 		case "fm_ser_no":
	 			if(formObj.fm_ser_no.value.length == 6)
//	 				formObj.to_ser_no.focus();
	 	 	break;
	 		case "to_ser_no":
	 			if(formObj.to_ser_no.value.length == 6)
//	 				formObj.units.focus();
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
		 * OBJECT DEACTIVATE event handler  <br>
		 */
//		function obj_-중복으로 제거-focusout(){
//			var formObj=document.form;
//			obj=ComGetEvent();
//			if(obj.name == "eq_lot_iss_dt"){
//				with(formObj){
//					var creDtFr=ComReplaceStr(eq_lot_iss_dt.value, "-", "");
//				}
//				ComChkObjValid(ComGetEvent());
//			} else if(obj.name == "de_yrmon"){
//				with(formObj){
//					var creDtFr=ComReplaceStr(de_yrmon.value, "-", "");
//				}
//				ComChkObjValid(ComGetEvent());
//			}
//		}
		
		/** 
		 * focus hyphen remove(DATAFORMAT "YMD")
		 */
		function domFunFocusDel(a){
			var formObj=document.form;
			obj=ComGetEvent();
			if(obj.name == "eq_lot_iss_dt"  ){
				document.form.eq_lot_iss_dt.value=ComReplaceStr(document.form.eq_lot_iss_dt.value, "-", "");
			} else if(obj.name == "de_yrmon"  ){
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
			financing_co.SetSelectCode("");
		}
		/**
		 * setting grid value in case of CERT NO, AGREEMENT NO value chage
		 */
		function obj_blur(){
			var sheetObj=sheetObjects[0];
			var sheetObj1=sheetObjects[1];
			var formObj=document.form;
			var obj=ComGetEvent();
			switch(ComGetEvent("name")){
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
					&& elems[i].name.substr(0, 4) != "btn_" && elems[i].type != "button") {
					elems[i].disabled=flag;
				}
			}
//			var obj=document.getElementsByTagName("img");
//			for ( var i=0; i < obj.length; i++) {
//				if (obj[i].getAttribute("name").substr(0, 5) == "btns_"
//					&& elems[i].cgmdsbtype != "no") {
//					obj[i].className=styleCursor;
//					obj[i].disabled=flag;
//					obj[i].style.filter=styleFilter;
//				}
//			}
		}
		/**
		 * engUp, number, hyphen
		 */
		function CgmKeyOnlyAlphabet(sFlag){   
			try {
				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				var bCanNum=false;
				//ComDebug('key  = '+keyValue);
				if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
				sFlag=sFlag.toLowerCase();
				if (sFlag.length > 3){
					if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
					if (sFlag.length > 5) sFlag=sFlag.substr(0,5);
				}
				if(keyValue >= 97 && keyValue <= 122){                  //engDown
					if (sFlag=="upper") event.keyCode=keyValue + 65 - 97;
				event.returnValue=true;
				} else if(keyValue >= 65 && keyValue <= 90){            //engUp
					if (sFlag=="lower") event.keyCode=keyValue + 97 - 65;
				event.returnValue=true;
				} else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//number
					event.returnValue=true;
				} else if(keyValue == 45){         // -(hyphen)
					event.returnValue=true; 
				} else if(keyValue == 95){         // _(Under bar)
					event.returnValue=true; 
				} else {   
					event.returnValue=false;
				} 
				return true;
			} catch(err) { ComFuncErrMsg(err.message); }
		}
		
		/**
		 * setting grid value in case of CERT & CHASSIS LIST change
		 */
		function eq_cert_chassis_list_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			var sheetObj1=sheetObjects[1];
			
			if (newText == ""){
				// row add function call
				sheetObj.RemoveAll();
				var row=sheetObj.DataInsert(0);
				sheetObj1.RemoveAll();
				var row=sheetObj1.DataInsert(0);
				sheetObj.SetCellValue(1, "eq_knd_cd","Z");
				// calling row status change function
				pageStatusCall();
				// HTML object ENABLE DISABLE function call
				CgmSetFormObjDisable(formObj, false);
				// reset function call
				objectClear();
				formObj.page_status.value="N";
			} else {
				sheetObj.SetCellValue(1, "eq_lot_no",comboObj.GetSelectCode(),0);
				formObj.eq_lot_no_tmp.value=comboObj.GetSelectCode();
				// calling row status change function
				pageStatusCall();
				// HTML object reset in case of CERT & CHASSIS LIST value change
				formObj.page_status.value="N";
				formObj.eq_lot_no.value="";
				formObj.eq_lot_iss_dt.value="";
				formObj.eq_pfx_cd.value="";
				formObj.fm_ser_no.value="";
				formObj.to_ser_no.value="";
				eq_spec_no.SetSelectText("");
				formObj.eq_tpsz_cd.value="";
				formObj.vndr_lgl_eng_nm.value="";
				formObj.de_yrmon.value="";
				formObj.agreement_no.value="";
				formObj.agmt_ref_no.value="";
				formObj.agmt_iss_ofc_cd.value="";
				formObj.agreement_dt.value="";
				formObj.agmt_lstm_cd.value="";
				financing_co.SetSelectText("");
				formObj.cre_dta.value="";
				formObj.cre_usr_id.value="";
				formObj.units.value="";
				// Auto retrieve in case of Cert_no select
				// IBSHEET retrieve
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				// HTML object ENABLE DISABLE function call
				CgmSetFormObjDisable(formObj, true);
			}
		}
		/**
		 * setting grid value in case of SPEC NO value change
		 */
		function eq_spec_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			var sheetObj1=sheetObjects[1];
			// 1. SPEC NO change
//			alert("eq_spec_no_OnChange : " + oldIndex+ "\n" + oldText+ "\n" + oldCode+ "\n" + newIndex+ "\n" + newText+ "\n" + newCode);
			if(newCode != ""){
				// 2. SHEET2 GRID value change -> sheet1_onchange event -> data retrievce
				sheetObj1.SetCellValue(1, "eq_spec_no",comboObj.GetSelectCode(),0);
				formObj.eq_spec_no_tmp.value=comboObj.GetSelectCode();
				sheet2_OnChange(sheetObj1, 1, 0);			
			} else {
				formObj.vndr_lgl_eng_nm.value="";
				formObj.eq_tpsz_cd.value="";
				sheetObj.SetCellValue(1, "eq_spec_no","",0);
				sheetObj.SetCellValue(1, "vndr_seq","",0);
			}
		}
		/**
		 * setting grid value in case of FINANCING CO value change
		 */
		function financing_co_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
			var sheetObj=sheetObjects[0];
			var formObj=document.form;
			sheetObj.SetCellValue(1, "finc_vndr_seq",financing_co.GetSelectCode());
		}
		/**
		 * HTML Objec enable in case of save success <br>
		 * @param {ibsheet} SheetObj    IBSheet Object
		 * @param {ibsheet} Event       Event after IBSheet saving 
		 */
		function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
			formObj=document.form;
			
			if (ErrMsg == 0) {  // save success..
				
				// 1. Combo INIT call
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01); // COMBO >> CERT & CHASSIS LIST
				
				var cert_chassis_no_Val=sheetObj.GetCellValue(1, "cert_chassis_no");
				formObj.eq_lot_no.value=sheetObj.GetCellValue(1, "eq_lot_no");
				formObj.eq_cert_chassis_list.text=cert_chassis_no_Val;

				formObj.f_cmd.value=SEARCH01;
				var sXml = sheetObj.GetSearchData("EES_CGM_1005GS.do",FormQueryString(formObj));
				if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );
				
				formObj.eq_lot_no.value=sheetObj.GetCellValue(1, "eq_lot_no");
				formObj.eq_lot_iss_dt.value=sheetObj.GetCellValue(1, "eq_lot_iss_dt");
				formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1, "eq_pfx_cd");
				formObj.fm_ser_no.value=sheetObj.GetCellValue(1, "fm_ser_no");
				formObj.to_ser_no.value=sheetObj.GetCellValue(1, "to_ser_no");
				formObj.units.value=sheetObj.GetCellValue(1, "units");
				formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(1, "eq_tpsz_cd");
				formObj.vndr_lgl_eng_nm.value=sheetObj.GetCellValue(1, "vndr_lgl_eng_nm");
				
				var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
				if(tmpDate.length == 6) {
					formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
				} else {
					formObj.de_yrmon.value=tmpDate;
				}					
				
				formObj.agreement_no.value=sheetObj.GetCellValue(1, "agreement_no");
				formObj.agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
				formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1, "agmt_ofc_cty_cd");
				formObj.agreement_dt.value=sheetObj.GetCellValue(1, "cre_dtc");
				formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1, "agmt_lstm_cd");
				formObj.cre_dta.value=sheetObj.GetCellValue(1, "cre_dta");
				formObj.cre_usr_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
				formObj.agmt_seq.value=sheetObj.GetCellValue(1, "agmt_seq");
				eq_spec_no.SetSelectCode(sheetObj.GetCellValue(1, "eq_spec_no"));
				formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1, "agmt_iss_ofc_cd");
				financing_co.SetSelectCode(sheetObj.GetCellValue(1, "finc_vndr_seq"));
				sheetObj.SetCellValue(1, "cert_chassis_no",formObj.eq_cert_chassis_list.text);
				sheetObj.SetRowStatus(1,"U");
				formObj.chss_tare_wgt.value=sheetObj.GetCellValue(1, "chss_tare_wgt");
				
				// HTML object Enable
				CgmSetFormObjDisable(formObj, true);
				
				// msgs['CGM00003']='Data was saved successfully.';
				ComShowCodeMessage("CGM00003");
				
				
			} else {
				// HTML object Disable
				CgmSetFormObjDisable(formObj, false);
			}
		}
		
		/**
		 * HTML Objec enable in case of search success <br>
		 * @param {ibsheet} SheetObj    IBSheet Object
		 * @param {ibsheet} Event       number Code
		 * @param {ibsheet} Event       String Msg
		 * @param {ibsheet} Event       number StCode
		 * @param {ibsheet} Event       String StMsg
		 */
		function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { // object, number, string, number, string
//			alert(Code+ ",\n" + Msg+ ",\n" + StCode+ ",\n" + StMsg); // Success : 0,,200,OK
			
			var formObj=document.form;
			
			// setting form object by grid value
			formObj.eq_lot_no.value=sheetObj.GetCellValue(1, "eq_lot_no");
			formObj.eq_lot_iss_dt.value=sheetObj.GetCellValue(1, "eq_lot_iss_dt");
			formObj.eq_pfx_cd.value=sheetObj.GetCellValue(1, "eq_pfx_cd");
			formObj.fm_ser_no.value=sheetObj.GetCellValue(1, "fm_ser_no");
			formObj.to_ser_no.value=sheetObj.GetCellValue(1, "to_ser_no");
			formObj.units.value=sheetObj.GetCellValue(1, "units");
			formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(1, "eq_tpsz_cd");
			formObj.vndr_lgl_eng_nm.value=sheetObj.GetCellValue(1, "vndr_lgl_eng_nm");
			var tmpDate=sheetObj.GetCellValue(1, "de_yrmon");
			if(tmpDate.length == 6)
			{
				formObj.de_yrmon.value=tmpDate.substring(0,4)+"-"+tmpDate.substring(4,6); 
			}
			else
			{
				formObj.de_yrmon.value=tmpDate;
			}
			formObj.agreement_no.value=sheetObj.GetCellValue(1, "agreement_no");
			formObj.agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
			formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1, "agmt_ofc_cty_cd");
			formObj.agreement_dt.value=sheetObj.GetCellValue(1, "cre_dtc");
			formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(1, "agmt_lstm_cd");
			formObj.cre_dta.value=sheetObj.GetCellValue(1, "cre_dta");
			formObj.cre_usr_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
			formObj.agmt_seq.value=sheetObj.GetCellValue(1, "agmt_seq");
			eq_spec_no.SetSelectCode(sheetObj.GetCellValue(1, "eq_spec_no"));
			formObj.agmt_iss_ofc_cd.value=sheetObj.GetCellValue(1, "agmt_iss_ofc_cd");
			financing_co.SetSelectCode(sheetObj.GetCellValue(1, "finc_vndr_seq"));
			formObj.page_status.value="U";
			sheetObj.SetRowStatus(1,"U");
		}
		/**
		 * 1. XML data push to each column.
		 */
		function sheet1_OnChange(sheetObj, Row, Col) {
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			var prefix="";
			var chk=true;
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
						var sXml=GetSearchData("EES_CGM_1005GS.do", FormQueryString(formObj));
						// data count
						var dataCount=ComGetTotalRows(sXml);
						// data existing
						if(dataCount > 0){
							ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_lot_no") );
							document.form.eq_spec_no_tmp.value="";
							sheetObj.SetCellValue(Row, "eq_lot_no","");
//							if(formObj.eq_lot_no.disabled != true) <-- 필요없음
//								{
//								
//								}
						} else {
							return;
						}
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
						var sXml=GetSearchData("EES_CGM_1005GS.do", FormQueryString(formObj));
						if(DomXml2String(sXml, "eq_spec_no") == null || DomXml2String(sXml, "eq_spec_no") == "") {
							// delete cell and focus move
							ComShowCodeMessage("CGM10012");
							// Setting Cell value to Null
							sheetObj.SetCellValue(Row, Col, "");
							// focus to grid
							sheetObj.SelectCell(Row, Col, true);
							formObj.eq_spec_no_tmp.value="";
							return;
						} else {
							// setting cell value
							var formObj=document.form;
							var sheetObj=sheetObjects[0];
							// 1. setting IBSHEET value by ETCDATA
							SetCellValue(Row,"eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
							SetCellValue(Row,"eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
							SetCellValue(Row,"vndr_lgl_eng_nm",DomXml2String(sXml,"vndr_lgl_eng_nm"),0);
							SetCellValue(Row,"vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
							SetCellValue(Row,"chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);//
							// 2. setting form object value by ETCDATA
							formObj.eq_tpsz_cd.value=DomXml2String(sXml,"eq_tpsz_cd");
							formObj.vndr_lgl_eng_nm.value=DomXml2String(sXml,"vndr_lgl_eng_nm");
							//3. put value SHEET1 to sync with SHEET2
							sheetObj.SetCellValue(Row, "eq_spec_no",DomXml2String(sXml,"eq_spec_no"),0);
							sheetObj.SetCellValue(Row, "eq_tpsz_cd",DomXml2String(sXml,"eq_tpsz_cd"),0);
							sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm",DomXml2String(sXml,"vndr_lgl_eng_nm"),0);
							sheetObj.SetCellValue(Row, "vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
							sheetObj.SetCellValue(Row, "chss_tare_wgt",DomXml2String(sXml,"chss_tare_wgt"),0);//
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
			var obj=ComGetEvent(); 
			switch(ComGetEvent("name")){
			case "agreement_no":
				// AGREEMENT NO retrieve(retrieve)
				
				formObj.f_cmd.value=SEARCH12;
				//alert('----1');
				if(formObj.agreement_no.value == '')
				{
					formObj.agreement_no.value="";
					formObj.agmt_iss_ofc_cd.value="";
					formObj.agmt_seq.value="";
					formObj.agmt_ver_no.value="";
					formObj.agmt_ref_no.value="";
					formObj.agmt_lstm_cd.value="";
					formObj.agreement_dt.value="";
					formObj.vndr_seq.value=""; 
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
					formObj.agmt_iss_ofc_cd.value=DomXml2String(sXml,"agmt_iss_ofc_cd");
					formObj.agmt_seq.value=DomXml2String(sXml,"agmt_seq");
					formObj.agmt_ver_no.value=DomXml2String(sXml,"agmt_ver_no");
					formObj.agmt_ref_no.value=DomXml2String(sXml,"agmt_ref_no");
					formObj.agmt_lstm_cd.value=DomXml2String(sXml,"agmt_lstm_cd");
					formObj.vndr_seq.value=DomXml2String(sXml,"vndr_seq");
					var lstmCd=DomXml2String(sXml,"agmt_lstm_cd");
					var DtTmp =DomXml2String(sXml,"cre_dt");
					formObj.agreement_dt.value=DtTmp;
					agreementNoChk(lstmCd)
					sheetObj.SetCellValue(1, "agreement_no",DomXml2String(sXml,"agmt_no"),0);
					sheetObj.SetCellValue(1, "agmt_ref_no",DomXml2String(sXml,"agmt_ref_no"),0);
					sheetObj.SetCellValue(1, "agmt_iss_ofc_cd",DomXml2String(sXml,"agmt_iss_ofc_cd"),0);
					sheetObj.SetCellValue(1, "cre_dtc",DomXml2String(sXml,"cre_dt"),0);
					sheetObj.SetCellValue(1, "agmt_lstm_cd",DomXml2String(sXml,"agmt_lstm_cd"),0);
					sheetObj.SetCellValue(1, "agmt_ver_no",DomXml2String(sXml,"agmt_ver_no"),0);
					sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",DomXml2String(sXml,"agmt_ofc_cty_cd"),0);
					sheetObj.SetCellValue(1, "agmt_seq",DomXml2String(sXml,"agmt_seq"),0);
					sheetObj.SetCellValue(1, "vndr_seq",DomXml2String(sXml,"vndr_seq"),0);
					return true;
				} else {
					if(formObj.agreement_no.value != "")
					{
						formObj.agreement_no.value="";
						formObj.agmt_iss_ofc_cd.value="";
						formObj.agmt_seq.value="";
						formObj.agmt_ver_no.value="";
						formObj.agmt_ref_no.value="";
						formObj.agmt_lstm_cd.value="";
						formObj.agreement_dt.value="";
						formObj.vndr_seq.value="";
						sheetObjects[0].RemoveAll();
						ComShowCodeMessage("CGM10004", "Agreement No.");
						if(formObj.agreement_no.disabled != true)
						return true;
					}
					else
					{
						formObj.agreement_no.value="";
						formObj.agmt_iss_ofc_cd.value="";
						formObj.agmt_seq.value="";
						formObj.agmt_ver_no.value="";
						formObj.agmt_ref_no.value="";
						formObj.agmt_lstm_cd.value="";
						formObj.agreement_dt.value="";
						formObj.vndr_seq.value="";
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
			var obj=ComGetEvent();
			switch(ComGetEvent("name")){
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
			case "eq_lot_iss_dt":
				sheetObj.SetCellValue(1, "eq_lot_iss_dt", formObj.eq_lot_iss_dt.value.replaceStr("-", ""));
				break;
			case "de_yrmon":
				sheetObj.SetCellValue(1, "de_yrmon", formObj.de_yrmon.value.replaceStr("-", ""));     	
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
			formObj.f_cmd.value=SEARCH05;
			var sXml=sheetObj.GetSearchData("EES_CGM_1005GS.do", FormQueryString(formObj)); //show sheet name in case of more than 2 sheet
			// data count
			var dataCount=ComGetTotalRows(sXml);
			// data existing
			if(dataCount > 0){
				ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_lot_no"));
				if(formObj.fm_ser_no.disabled != true)
				return;			
			}else
			{
				return;
			}
		}
	 /**
	  * check Eq No FM- TO existing <br>
	  * @param
	  * @return 
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
	 		ComShowCodeMessage("CGM10017",DomXml2String(sXml, "eq_no"));
	 		formObj.fm_ser_no.value="";
	 		formObj.to_ser_no.value="";
	 		formObj.units.value="";
	 		if(formObj.fm_ser_no.disabled != true)
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
		var fmTmp=formObj.fm_ser_no.value;
		var toTmp=formObj.to_ser_no.value;
		if(fmTmp != "" && toTmp != ""){
			if(Number(toTmp) < Number(fmTmp)){
				ComShowCodeMessage("CGM10027");
				formObj.to_ser_no.value="";
				if(formObj.to_ser_no.disabled != true)
				return false;
			}
		}
		if(fmTmp != "" && toTmp != ""){
			var unTmp=ComAddComma(Number(toTmp) - Number(fmTmp) + 1)
			formObj.units.value=unTmp;
			sheetObj.SetCellValue(1, "units",unTmp.replace(",",""));
		}
		// grid value setting, inserted object value setting
		if(equipChkFmToNo()== false)
			return false;
		// CERT & CHASSIS LIST creation, IBSHEET value setting
		var certTmp=formObj.eq_lot_no.value+" "+formObj.eq_pfx_cd.value+fmTmp+"-"+toTmp;
		sheetObj.SetCellValue(1, "cert_chassis_no",certTmp,0);
		// SERIAL NO creation, IBSHEET value setting
		var seriTmp=formObj.eq_pfx_cd.value+fmTmp+"-"+toTmp;
		sheetObj.SetCellValue(1, "serial_no",seriTmp,0);
		sheetObj.SetCellValue(1, "eq_no",formObj.eq_pfx_cd.value+fmTmp);
		sheetObj.SetCellValue(1, "eq_pfx_cd",formObj.eq_pfx_cd.value,0);
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
			//alert( "chungpa >>>" + sheetObj.RowStatus(1));
			for(i=0; i < aryPopupData.length; i++){
				agreeNo=agreeNo  + aryPopupData[i][2];  // agreement_no
				referNo=referNo  + aryPopupData[i][3];  // reference_no
				officeCd=officeCd + aryPopupData[i][9];  // office_cd
				agreeDt=agreeDt  + aryPopupData[i][10]; // agreement date
				lstmCd=lstmCd   + aryPopupData[i][4];  // lease term
				verNo=verNo    + aryPopupData[i][0];  // ver_no
				vndrSeq=vndrSeq  + aryPopupData[i][5]; //vndrSeq
			}
			formObj.agreement_no.value=agreeNo;
			formObj.agmt_ref_no.value=referNo;
			formObj.agmt_iss_ofc_cd.value=officeCd;
			formObj.agmt_ofc_cty_cd.value=agreeNo.substring(0, 3);
			formObj.agmt_seq.value=agreeNo.substring(4, 10);
			formObj.vndr_seq.value=vndrSeq;		// chungpa 20090803 add vndr_seq
			//formObj.agreement_dt.value    = agreeDt; // chungpa 20090803 agreement_dt format	
			if(agreeDt.length == 8)
			{
				var creDtTmp=agreeDt.substr(0,4)+"-"+agreeDt.substr(4,2)+"-"+agreeDt.substr(6,2);
				formObj.agreement_dt.value=creDtTmp;
			}
			else if(agreeDt.length > 10){
				var creDtTmp=agreeDt.substr(0,10)
				formObj.agreement_dt.value=creDtTmp;
			}
			else
			{
				formObj.agreement_dt.value=agreeDt;
			}
			formObj.agmt_lstm_cd.value=lstmCd;
			formObj.agmt_ver_no.value=verNo;
			sheetObj.SetCellValue(1, "agreement_no",agreeNo);
			sheetObj.SetCellValue(1, "agmt_ref_no",referNo);
			sheetObj.SetCellValue(1, "agmt_iss_ofc_cd",officeCd);
			sheetObj.SetCellValue(1, "cre_dtc",agreeDt);
			sheetObj.SetCellValue(1, "agmt_lstm_cd",lstmCd);
			sheetObj.SetCellValue(1, "agmt_ver_no",verNo);
			sheetObj.SetCellValue(1, "agmt_ofc_cty_cd",agreeNo.substring(0, 3));
			sheetObj.SetCellValue(1, "agmt_seq",agreeNo.substring(4, 10));
			sheetObj.SetCellValue(1, "vndr_seq",vndrSeq);// chungpa 20090803 add vndr_seq
			agreementNoChk(lstmCd);
			//alert( "chungpa 2 >>>" + sheetObj.RowStatus(1));
		}
		function agreementNoChk(lstmCd){
			var formObj=document.form;
			if(!(lstmCd == "OW" || lstmCd == "OL" || lstmCd == "LP")){
				// show message, object reset
				// msgs['CGM10029']='Term does not match. Please check again.';
				ComShowCodeMessage("CGM10029");
				formObj.agreement_no.value="";
				formObj.agmt_ref_no.value="";
				formObj.agmt_iss_ofc_cd.value="";
				formObj.agreement_dt.value="";
				formObj.agmt_lstm_cd.value="";
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
//		  var formObj=document.form;
//		  if(formObj.trole.value == "Authenticated")
//		  {
////			  alert(formObj.trole.value);
//		  }else
//		  {
//			  ComBtnDisable("btn_save");
//			  ComBtnDisable("FA I/F");
//		  }
	  }