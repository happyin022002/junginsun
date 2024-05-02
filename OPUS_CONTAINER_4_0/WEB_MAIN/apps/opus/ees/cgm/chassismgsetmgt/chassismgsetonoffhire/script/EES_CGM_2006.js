/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2006.js
*@FileTitle  : M.G.Set Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_2006 : ees_cgm_2006 business script for
 */
	/* developer jop */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** use additional sheet var in case of more than 2 tap each sheet **** */
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		/** **************************************************** */
		var formObj=document.form;
		try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			if(formObj.eq_no.value == "" || formObj.eq_no.value == null){
				ComShowCodeMessage("CGM20023", "M.G.Set No");
				return;
			}
			doActionIBSheet(sheetObj2, formObj, IBSEARCH);
			break;
		case "btn_new":
			// reset function call
			objectClear();
			break;
		case "btn_save":
			noneMgsetCall();
			doActionIBSheet(sheetObj2, formObj, IBSAVE);
			break;
		case "btn_chssmvmt":
			var param="";
		  	if(formObj.eq_no.value != '')
		  	{
			   	formObj.f_cmd.value=SEARCH01;
			   	var sXml=sheetObj2.GetSearchData("EES_CGM_2006GS.do", FormQueryString(formObj));
			   	var chssNo=ComGetEtcData(sXml,"CHSS_NO");
			   	if(chssNo != null && chssNo != '')
			   	{
			  		var pgmNo='EES_CGM_1105';
			  		var pgmUrl='/opuscntr/EES_CGM_1105.do';
			  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';
			    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+chssNo ;
			    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
			    	var winObj=window.open("EES_CGM_1105.do?parentPgmNo="+parentPgmNo+src,"","");
			    	return;
			   	}
		    }
	    	//
	  		var pgmNo='EES_CGM_1105';
	  		var pgmUrl='/opuscntr/EES_CGM_1105.do';
	  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';
	    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;
	    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    	var winObj=window.open("EES_CGM_1105.do?parentPgmNo="+parentPgmNo+src,"","");
	    	break;
	    	
		case "btn_mgstmvmt":
			var param="";
			var mgstNo = "";
		  	if(formObj.eq_no.value != ''){
			   	mgstNo = formObj.eq_no.value;
		    }
	    	//
	  		var pgmNo='EES_CGM_2105';
	  		var pgmUrl='/opuscntr/EES_CGM_2105.do';
	  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';
	    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+mgstNo ;
	    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    	var winObj=window.open("EES_CGM_2105.do?parentPgmNo="+parentPgmNo+src,"","");
	    	break;
	    	
		case "btn_status":
			var param="";
		  	if(formObj.eq_no.value != '')
		  	{
		  		var pgmNo='EES_CGM_2018';
		  		var pgmUrl='/opuscntr/EES_CGM_2018.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value;
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    	var winObj=window.open("EES_CGM_2018.do?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//
		  		var pgmNo='EES_CGM_2018';
		  		var pgmUrl='/opuscntr/EES_CGM_2018.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    	var winObj=window.open("EES_CGM_2018.do?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }
			break;
			
		case "btn_mnr":
			var param="";
		  	if(formObj.eq_no.value != '')
		  	{
		  		var pgmNo='EES_MNR_0028';
		  		var pgmUrl='/opuscntr/EES_MNR_0028.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=G&eq_no="+formObj.eq_no.value ;
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    	var winObj=window.open("EES_MNR_0028.do?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
			    //
			  	var pgmNo='EES_MNR_0028';
			  	var pgmUrl='/opuscntr/EES_MNR_0028.do';
			  	var parentPgmNo=pgmNo.substring(0, 8)+'M001';
			    var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=G";
			    var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
//			    var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
			    var winObj=window.open("EES_MNR_0028.do?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }
		    break;
		case "btn_Calendar_a" :
			var cal=new ComCalendar();
			cal.select(formObj.mft_dt, "yyyy-MM-dd");
			break;
		case "btn_Calendar_b" :
			var cal=new ComCalendar();
			cal.select(formObj.mgst_warr_end_dt, "yyyy-MM-dd");
			break;
		case "btn_delgrid":
			for(var i=sheetObj1.RowCount(); i>=1; i--)
			{
				if(sheetObj1.GetRowStatus(i) == "D") {
					continue;
				} else
				{
					sheetObj1.SetRowStatus(i,"D");
					sheetObj1.SetRowHidden(i,1);//2.
					break;
				}
			}
			AtDtUpdateMode();
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj=document.form;
	    for(i=sheetObjects.length-1; i>=0; i--){
	    	ComConfigSheet (sheetObjects[i] );
	    	initSheet(sheetObjects[i],i+1);
	    	ComEndConfigSheet(sheetObjects[i]);
	    }
	    sheet1_OnLoadFinish(sheetObjects[0]);
	}
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
	    sheetObj.SetWaitImageVisible(0);
	    // axon event regist
		// axon_event.addListener ("click",	"obj_onClick",	"n2nd_chss_als_no_chk");
	  //  axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	formObj);
	    // axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
	    // axon_event.addListenerFormat("keyup",               "obj_keyup",        form);
	//	axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
		axon_event.addListener      ("blur",				"obj_blur",			"eq_no", "mft_dt", "mgst_mchn_ser_no", "mgst_run_hrs", "mgst_warr_end_dt");
	    axon_event.addListener('click', 'pop_atch_cntr', 'atch_cntr');			// atch_cntr popup
	    axon_event.addListener('click', 'pop_atch_chs', 'atch_chs');			// atch_chs popup
	 	initControl();
		if(formObj.eq_no.value != "")
		{
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		}
	    doActionIBSheet(sheetObj,document.form,IBCLEAR);
	    sheetObj.SetWaitImageVisible(1);
	 }
	/**
	 * page init combo
	 */
	function initControl(sheetObj){
		objectClear();
		ibsheetReset();
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
			case "sheet1": // AT/DT
			    with(sheetObj){
				      var HeadTitle="|||Seq.|CNTR/CHSS|Attach Date|Attach Date|Attach Yard|Detach Date|Detach Date|Detach Yard";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Sta" },
				             {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chss",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_dt_day",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"atch_dt_hd",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:"atch_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dtch_dt_day",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dtch_dt_hd",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"dtch_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(300);
		            }
			   break;
			   
	    	case "sheet2":
	    	    with(sheetObj){
			          var HeadTitle="|M.G.Set No.|Status|Type|Term|Yard|Manufactured Date|Model No.|Machine Serial No.|Voltage|Fuel Capacity|Current Hours| Last Updated Date|Warranty Date|On-Hire Office|On-Hire Date|Agreement No.|Lessor|Reference No.|Created Date|Created By|Updated Date|Updated By|eq_knd_cd|vndr_seq|cntr_chk|chs_chk|bare_chk|damage_chk|atch_cntr|atch_chs";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"aciac_div_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"mft_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"mgst_mchn_ser_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_vltg_capa",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_fuel_capa",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_run_hrs",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_run_hrs_upd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgst_warr_end_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"onh_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agreement_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chs_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bare_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"damage_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_cntr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"atch_chs",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetSheetHeight(160);
	                }
		        break;
	    }
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		switch (sAction) {
			// Search
			case IBSEARCH:
				sheetObj1.SetWaitImageVisible(0);
				sheetObj2.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				/* 
				sheetObj2.DoSearch("EES_CGM_2006GS.do",FormQueryString(formObj) );
				*/
				var sXml=sheetObj.GetSearchData("EES_CGM_2006GS.do" , FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if(arrXml.length>0)sheetObj2.LoadSearchData(arrXml[0],{Sync:1} );
				if(arrXml.length>1)sheetObj1.LoadSearchData(arrXml[1],{Sync:1} );
				// message in case of no retrieve data
				if(sheetObj2.RowCount()== 0){
					ComShowCodeMessage("CGM20023", formObj.eq_no.value); 
					initControl();
					ComOpenWait(false);
					return;
				}
				AtDtUpdateMode();
				// setting text field by retrieved grid value
				//Basic Info Start
				formObj.eq_no.value=sheetObj2.GetCellValue(1, "eq_no");
				formObj.eq_tpsz_cd.value=sheetObj2.GetCellValue(1, "eq_tpsz_cd");
				formObj.mft_dt.value=sheetObj2.GetCellValue(1, "mft_dt");
				formObj.mgst_warr_end_dt.value=sheetObj2.GetCellValue(1, "mgst_warr_end_dt");
				formObj.eq_spec_no.value=sheetObj2.GetCellValue(1, "eq_spec_no");
				formObj.mgst_vltg_capa.value=sheetObj2.GetCellValue(1, "mgst_vltg_capa");
				formObj.mgst_fuel_capa.value=sheetObj2.GetCellValue(1, "mgst_fuel_capa");
				formObj.mgst_mchn_ser_no.value=sheetObj2.GetCellValue(1, "mgst_mchn_ser_no");
				formObj.mgst_run_hrs.value=ComAddComma(sheetObj2.GetCellValue(1, "mgst_run_hrs"));
				formObj.mgst_run_hrs_upd_dt.value=sheetObj2.GetCellValue(1, "mgst_run_hrs_upd_dt");
				//Basic Info End
				//On-Hire Status Start
				formObj.aciac_div_cd.value=sheetObj2.GetCellValue(1, "aciac_div_cd");
				formObj.crnt_yd_cd.value=sheetObj2.GetCellValue(1, "crnt_yd_cd");
				formObj.onh_dt.value=sheetObj2.GetCellValue(1, "onh_dt");
				formObj.onh_ofc_cd.value=sheetObj2.GetCellValue(1, "onh_ofc_cd");
				formObj.agreement_no.value=sheetObj2.GetCellValue(1, "agreement_no");
				formObj.agmt_lstm_cd.value=sheetObj2.GetCellValue(1, "agmt_lstm_cd");
				formObj.vndr_lgl_eng_nm.value=sheetObj2.GetCellValue(1, "vndr_lgl_eng_nm");
				formObj.agmt_ref_no.value=sheetObj2.GetCellValue(1, "agmt_ref_no");
				if(sheetObj.GetCellValue(1, "cntr_chk") == "Y"){ 			// CNTR check box
					formObj.cntr_chk.checked=true;
				} else {
					formObj.cntr_chk.checked=false;
				}
				if(sheetObj.GetCellValue(1, "chs_chk") == "Y"){			// CHS check box
					formObj.chs_chk.checked=true;
				} else {
					formObj.chs_chk.checked=false;
				}
				if(sheetObj.GetCellValue(1, "bare_chk") == "Y"){			// BARE check box
					formObj.bare_chk.checked=true;
				} else {
					formObj.bare_chk.checked=false;
				}
				if(sheetObj.GetCellValue(1, "damage_chk") == "Y"){			// DAMAGE check box
					formObj.damage_chk.checked=true;
				} else {
					formObj.damage_chk.checked=false;
				}
				//On-Hire Status End
				//added item start
				formObj.atch_cntr.value=sheetObj2.GetCellValue(1, "atch_cntr");
				formObj.atch_chs.value=sheetObj2.GetCellValue(1, "atch_chs");
				//added item end
				//Basic Info2 Start
				formObj.cre_dt.value=sheetObj2.GetCellValue(1, "cre_dt");
				formObj.cre_usr_id.value=sheetObj2.GetCellValue(1, "cre_usr_id");
				formObj.upd_dt.value=sheetObj2.GetCellValue(1, "upd_dt");
				formObj.upd_usr_id.value=sheetObj2.GetCellValue(1, "upd_usr_id");
				//Basic Info2 End
				//check box DISABLE
				formObj.cntr_chk.disabled=true;
				formObj.chs_chk.disabled=true;
				formObj.bare_chk.disabled=true;
				formObj.damage_chk.disabled=true;
				ComBtnEnable("btn_save");
				ComOpenWait(false);
				break;
			case IBSAVE:
				var sParam="";
				var sParam1="";
				var sParam2="";
				sheetObj1.SetWaitImageVisible(0);
				sheetObj2.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				sParam1=sheetObjects[0].GetSaveString(false);
				sParam1=ComSetPrifix(sParam1, "ATDT_");
				sParam2=sheetObjects[1].GetSaveString(false);
				sParam2=ComSetPrifix(sParam2, "MASTER_");
				/* 
				if(sheetObj2.DoSave("EES_CGM_2006GS.do",FormQueryString(formObj) ))
	 			{
	 				ComShowCodeMessage("CGM00003");
	 			}else
	 			{
	 			}*/
				if(sParam1 == '' && sParam2 == '')
				{
					if(sheetObj2.DoSave("EES_CGM_2006GS.do",sParam ))
			 		{
			 			ComShowCodeMessage("CGM00003");
			 		}else
			 		{
			 		}
				}else 
				{
					if( sParam1 == '' ) 
					{
						formObj.master_save_flag.value='MASTERONLY';
						sParam=sParam2+'&'+FormQueryString(formObj);
					}else if( sParam2 == '' )
					{
						formObj.master_save_flag.value='ATDTONLY';
						sParam=sParam1 + "&" + sParam2+'&'+FormQueryString(formObj);
					}else
					{
						formObj.master_save_flag.value='ALL';
						sParam=sParam1 + "&" + sParam2+'&'+FormQueryString(formObj);
					}
					if(	formObj.master_save_flag.value == 'ATDTONLY'
					||	formObj.master_save_flag.value == 'ALL' )
					{
						if(checkAtDtValid(sheetObj1,formObj,IBSEARCH)==false)
						{
							ComOpenWait(false);
							return;
						}
					}
					var sXml=sheetObj2.GetSaveData("EES_CGM_2006GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
	            	var sCheckResult=ComGetEtcData(sXml,"checkResult");
	            	if(sCheckResult == COM_VALIDATION_FALSE){
	            	} else if(sCheckResult == COM_VALIDATION_TRUE){
	            		ComShowCodeMessage("CGM00003"); 
	            		AtDtUpdateMode(); 				
	            	}
				}
				ComOpenWait(false);
				break;
		}
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
	 *  init object
	 */
	function objectClear(){
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		// IBSHEET reset
		sheetObj1.RemoveAll();
		sheetObj2.RemoveAll();
		// FORM OBJECT reset
		formObj.reset();
		ComBtnDisable("btn_save");
	}
//	function obj_keyup(){
//		obj=event.srcElement;
//	 	switch(ComGetEvent("name")){
//	 		case "eq_no":
//	 		{
//	 	    	var keyValue=null;
//	 	        if(event == undefined || event == null) {
//	 	        	keyValue=13;
//	 	        } else {
//	 	        	keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	 	        }
//	 	        if(keyValue == 13)
//	 	        {
//	 	        	ComKeyEnter('search');
//	 	        }
//	  	    	break;
//	 		}
//	  	}
//	}
	/**
	 * key input limit
	 */
//	function obj_keypress(){
//		 obj=event.srcElement;
//		 if(obj.dataformat == null){
//			 return;
//		 }
//		 window.defaultStatus=obj.dataformat;
//		 switch(obj.dataformat) {
//	  	    case "engup":
//		        if(obj.name == "eq_no"){
//		        	ComKeyOnlyAlphabet("uppernum");
//		        }
//		        break;
//		    case "isnum":
//		    	ComKeyOnlyNumber(obj);
//		    	break;
//		    case "int":
//	 	    	ComKeyOnlyNumber(obj);
//	 	        break;
//	  	 	case "ymd":
//	  	 		ComKeyOnlyNumber(obj);
//	  	        break;
//		 }
//	 }
	/**
	 * AXON event handling
	 */
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	    //ComIsNumber(event.srcElement, ",");
	}
	/**
	 * OBJECT DEACTIVATE event handler  <br>
	 */
	function obj_deactivate(){
		var formObj=document.form;
		obj=event.srcElement;
		if(obj.name == "mgst_warr_end_dt"){
			with(formObj){
				var creDtFr=ComReplaceStr(mgst_warr_end_dt.value, "-", "");
				//alert("creDtFr : " + creDtFr);
			}
	        ComChkObjValid(event.srcElement);
		} else if(obj.name == "mft_dt"){
			with(formObj){
				var creDtFr=ComReplaceStr(mft_dt.value, "-", "");
				//alert("creDtFr : " + creDtFr);
			}
	        ComChkObjValid(event.srcElement);
		}
	}
	/**
	 * focus hyphen remove(DATAFORMAT "YMD")
	 */
	function domFunFocusDel(a){
		var formObj=document.form;
		obj=event.srcElement;
		if(obj.name == "mgst_warr_end_dt"  ){
			document.form.mgst_warr_end_dt.value=ComReplaceStr(document.form.mgst_warr_end_dt.value, "-", "");
		} else if(obj.name == "mft_dt"  ){
			document.form.mft_dt.value=ComReplaceStr(document.form.mft_dt.value, "-", "");
		}
	}
	function noneMgsetCall(){
		var formObj=document.form;
		if(formObj.eq_no.value == "" || formObj.eq_no.value == null){
			ComShowCodeMessage("CGM20023", "M.G.Set No");
	//		formObj.eq_no.focus();
			return;
		}
	}
	/**
	 * IBSHEET reset
	 */
	function ibsheetReset(){
		var sheetObj=sheetObjects[1];
		sheetObj.RemoveAll();
		var row=sheetObj.DataInsert(0);
		sheetObj.SetCellValue(1, "eq_knd_cd","G");
		sheetObj.SetRowStatus(1,"R");
	}
	/**
	 * IBSHEET GRID value setting
	 */
	function obj_blur(comboObj, Index_Code, Text){
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var formObj=document.form;
		sheetObj2.SetCellValue(1, "eq_no",formObj.eq_no.value);
		sheetObj2.SetCellValue(1, "mft_dt",formObj.mft_dt.value);
		sheetObj2.SetCellValue(1, "mgst_mchn_ser_no",formObj.mgst_mchn_ser_no.value);
		sheetObj2.SetCellValue(1, "mgst_run_hrs",formObj.mgst_run_hrs.value.replaceStr(","));
		sheetObj2.SetCellValue(1, "mgst_warr_end_dt",formObj.mgst_warr_end_dt.value.replaceStr(","));
	}
	 /**
	  * pop_atch_cntr  popup event handling  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version 
	  */
	  function pop_atch_cntr(){
		  var formObj=document.form;
		  if(formObj.atch_cntr.value != "")
		  {
			  var formObj=document.form;
			  if(formObj.atch_cntr.value != "")
			  {
					var param="?pgmNo=EES_CGM_1109";
		   		   	param=param + "&f_cmd=" + SEARCH;
		   			param=param + "&p_cntrno=" + formObj.atch_cntr.value;
		   		    ComOpenPopup('/opuscntr/EES_CGM_1109.do' + param, 1080, 600, "", "1,0", true, false);
			  }
		  }
	  }
	 /**
	  * pop_atch_chs popup event handling  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version 
	  */
	  function pop_atch_chs(){
	 	  var formObj=document.form;
	 	  if(formObj.atch_chs.value != "")
	 	  {
	 			var param="?pgmNo=EES_CGM_1003";
	    		   	param=param + "&f_cmd=" + SEARCH;
	    			param=param + "&eq_no=" + formObj.atch_chs.value;
	    		    ComOpenPopup('/opuscntr/EES_CGM_1003_POP.do' + param, 1080, 600, "", "1,0", true, false);
	 	  }
	  }
	///////////////////////////////////////////////////////////////////////////////////////////////////
	 function AtDtUpdateMode(){
		 var formObj=document.form;
		 var sheetObj1=sheetObjects[0];
		 var sheetObj2=sheetObjects[1];
		 var lastData=0;
		 for(var i=sheetObj1.RowCount(); i>=1; i--)
		 {
			 if(sheetObj1.GetRowStatus(i) == "D") {
				 continue;
			 }else
			 {
				 if(sheetObj1.GetCellValue(i, "atch_dt_day")=="" || sheetObj1.GetCellValue(i,"atch_dt_hd")=="")
				 {
					 sheetObj1.SetRowEditable(i,0);
				 }else
				 {
					 formObj.org_atch_dt.value=sheetObj1.GetCellValue(i, "atch_dt_day") + sheetObj1.GetCellValue(i,"atch_dt_hd");
					 formObj.org_atch_yd_cd.value=sheetObj1.GetCellValue(i, "atch_yd_cd");
					 formObj.org_dtch_dt.value=sheetObj1.GetCellValue(i, "dtch_dt_day") + sheetObj1.GetCellValue(i,"dtch_dt_hd");
					 formObj.org_dtch_yd_cd.value=sheetObj1.GetCellValue(i, "dtch_yd_cd");
					 //alert( formObj.org_atch_dt.value + " "+ formObj.org_atch_yd_cd.value + " " + formObj.org_dtch_dt.value+ " "+ formObj.org_dtch_yd_cd.value);
					 sheetObj1.SetRowEditable(i,1);
					 sheetObj1.SetCellEditable(i,"atch_dt_day",1);
					 sheetObj1.SetCellEditable(i,"atch_dt_hd",1);
					 if(sheetObj1.GetCellValue(i, "atch_yd_cd")=="")
						 sheetObj1.SetCellEditable(i,"atch_yd_cd",0);
					 else
						 sheetObj1.SetCellEditable(i,"atch_yd_cd",1);
					 if(sheetObj1.GetCellValue(i, "dtch_dt_day")=="" || sheetObj1.GetCellValue(i, "dtch_dt_hd")=="")
					 {
						 sheetObj1.SetCellEditable(i,"dtch_dt_day",0);
						 sheetObj1.SetCellEditable(i,"dtch_dt_hd",0);
					 }
					 else
					 {
						 sheetObj1.SetCellEditable(i,"dtch_dt_day",1);
						 sheetObj1.SetCellEditable(i,"dtch_dt_hd",1);
					 }
					 if(sheetObj1.GetCellValue(i, "dtch_yd_cd")=="")
						 sheetObj1.SetCellEditable(i,"dtch_yd_cd",0);
					 else
						 sheetObj1.SetCellEditable(i,"dtch_yd_cd",1);
				 }
				 sheetObj1.SetRowStatus(i,"R");
				 lastData=i;
				 break;
			 }
		 }
		 for(var j=1; j<=lastData-1; j++)
		 {
			 sheetObj1.SetRowEditable(j,0);
		 }
	 }
	 function sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "atch_yd_cd" :
	       		ComOpenPopup('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
	       	    break;
	 	    case "dtch_yd_cd" :
	 	    	ComOpenPopup('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
	 	        break;
		}
	}
	function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
		var sheetObj1=sheetObjects[0];
		sheetObj1.SetCellValue(row, col,aryPopupData[0][3],0);
	}
	function sheet1_OnChange(sheetObj, Row, Col){
		var formObj=document.form;
		var chk=true;
		switch (sheetObj.ColSaveName(Col)) {
			case "atch_yd_cd" :
	  			formObj.f_cmd.value=COMMAND01;
	  			formObj.yd_cd.value=sheetObj.GetCellValue(Row, "atch_yd_cd");
			   	if(formObj.yd_cd.value!="")
			   	{
			   		var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
				   	var sCheckResult=ComGetEtcData(sXml,"checkResult");
				   	if(sCheckResult == COM_VALIDATION_FALSE){
				   		ComShowCodeMessage('CGM10009','Yard');
				   		sheetObj.SetCellValue(Row, "atch_yd_cd","");
				   		sheetObj.SelectCell(Row, Col, true);
				   	} else {
				   	}
			   	}
		 	    break;
		 	    
		    case "dtch_yd_cd" :
				formObj.f_cmd.value=COMMAND01;
				formObj.yd_cd.value=sheetObj.GetCellValue(Row, "dtch_yd_cd");
			   	if(formObj.yd_cd.value!="")
			   	{
			   		var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
				   	var sCheckResult=ComGetEtcData(sXml,"checkResult");
				   	if(sCheckResult == COM_VALIDATION_FALSE){
				   		ComShowCodeMessage('CGM10009','Yard');
				   		sheetObj.SetCellValue(Row, "dtch_yd_cd","");
				   		sheetObj.SelectCell(Row, Col, true);
				   	} else {
				   	}
			   	}
		 	    break;
		}
	}
	 function checkAtDtValid(sheetObj1,formObj,sAction){
	 	with(formObj){
			switch(sAction){
				case IBSEARCH:
					 for(var i=sheetObj1.RowCount(); i>=1; i--)
					 {
						 if(sheetObj1.GetRowStatus(i) == "D") {
							 continue;
						 }else
						 {
							 if( (sheetObj1.GetCellValue(i,"atch_dt_day") == "" || sheetObj1.GetCellValue(i,"atch_dt_hd") == "" )
							    && formObj.org_atch_dt.value != ""
							 )
							 {
								 ComShowCodeMessage("CGM10004", "Attach Date");
								 return false;
							 }
							 if(sheetObj1.GetCellValue(i,"atch_yd_cd") == ""
								 && formObj.org_atch_yd_cd.value != ""
							 )
							 {
								 ComShowCodeMessage("CGM10004", "Attach Yard");
								 return false;
							 }
							 if( (sheetObj1.GetCellValue(i,"dtch_dt_day") == "" ||sheetObj1.GetCellValue(i,"dtch_dt_hd") == ""  )
								 && formObj.org_dtch_dt.value != ""
							 )
							 {
								 ComShowCodeMessage("CGM10004", "Detach Date");
								 return false;
							 }
							 if(sheetObj1.GetCellValue(i,"dtch_yd_cd") == ""
								 && formObj.org_dtch_yd_cd.value != ""
							 )
							 {
								 ComShowCodeMessage("CGM10004", "Detach Yard");
								 return false;
							 }
				             if(i>1)
							 {
				            	 if((sheetObj1.GetCellValue(i,"atch_dt_day") != "") && (sheetObj1.GetCellValue(i,"atch_dt_hd") != ""))
				            	 {
				            		 if((sheetObj1.GetCellValue(i,"atch_dt_day")+sheetObj1.GetCellValue(i,"atch_dt_hd")) < (sheetObj1.GetCellValue(i-1,"dtch_dt_day")+sheetObj1.GetCellValue(i-1,"dtch_dt_hd"))
									 )
									 {
										 ComShowCodeMessage("CGM10084");
										 return false;
									 }
				            	 }
							 }
				             if((sheetObj1.GetCellValue(i,"dtch_dt_day") != "") && (sheetObj1.GetCellValue(i,"dtch_dt_hd") != ""))
			            	 {
				            	 if((sheetObj1.GetCellValue(i,"atch_dt_day")+sheetObj1.GetCellValue(i,"atch_dt_hd"))
										 >
				            	 (sheetObj1.GetCellValue(i,"dtch_dt_day")+sheetObj1.GetCellValue(i,"dtch_dt_hd"))
								 )
								 {
									 ComShowCodeMessage("CGM10084");
									 return false;
								 }
			            	 }
							 break; // for
						 }
					 }
			 	break; // switch
			}
	 	}
		return true;
	 }
	/* developer jop end */