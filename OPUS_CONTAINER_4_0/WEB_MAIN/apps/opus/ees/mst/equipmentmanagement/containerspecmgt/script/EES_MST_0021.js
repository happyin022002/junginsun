/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0021.js
*@FileTitle  : Container Specification Creation &amp; Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ees_mst_0021 : business script for ees_mst_0021
 */
	// common static variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var arr_lod_capa=new Array();  
	var arr_cntr_grs_wgt=new Array();
	var arr_tare_wgt=new Array();
	var arr_inter_len=new Array();
	var arr_inter_wdt=new Array();
	var arr_inter_hgt=new Array();
	var arr_xter_len=new Array();
	var arr_xter_wdt=new Array();
	var arr_xter_hgt=new Array();
	var arr_opn_dor_wdt=new Array();
	var arr_opn_dor_hgt=new Array();
	var arr_rc_ldb_capa=new Array();  
	var arr_rc_ldb_capa_cbf=new Array();
	var arr_tnk_capa_cbf=new Array();
	var nowSpec = "";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_Popup":
				openPopup();
				break;
			case "btn_new":
				if ( f_change_data_checking(formObj)  == true)  return;
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
				break;
			case "btns_vndr":
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 540, "vndr_seq:vndr_seq", "0,0,1,1,1,1", true);
				break;	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("MST00011", srcName + " Button Fail.");
			} else {
				ComShowCodeMessage("MST00011", e);
			}
		}
	}
	/**
	 * registering IBsheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBMultiCombo Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj = document.form;
		
		for (i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		// Axon handling event1. event catch
		// axon_event.addListenerFormat("keypress", "obj_keypress",	form); //- handling on key press event
		axon_event.addListener("focusout", "obj_focusout", "lod_capa", "cntr_grs_wgt", "tare_wgt", "rc_ldb_capa", "tnk_capa", "inter_len", "inter_wdt", "inter_hgt", "xter_len", "xter_wdt");
		axon_event.addListener("focusout", "obj_focusout", "xter_hgt", "opn_dor_wdt", "opn_dor_hgt", "rc_ldb_hgt", "spec_yr");
		axon_event.addListener("change", "obj_own_cntr_flg_change", "own_cntr_flg");
	    axon_event.addListener("change", "obj_cntr_spec_no_change", "cntr_spec_no");
	    axon_event.addListener("change", "obj_vndr_seq_change", "vndr_seq");
	    axon_event.addListener("change", "obj_change", form); // when object is changed.		
	    
		for (k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
		if (formObj.popflag.value != "") {
			// in case of called pop-up - retrieve.
			if (formObj.cntr_spec_no.value != "") {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				initTankRefferValue(ComGetObjValue(comboObjects[0]).substring(0, 1));			
			} else {
				clearForm();
			}
		} else {
			// initailizing form
			doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
		}
		if (formObj.popflag.value == "") {			
			/* Focus Setting */
			ComSetFocus(formObj.spec_yr);
		}
	}
	
	
	function obj_change(){
		var obj = ComGetEvent();
		var formObj = document.form;

		if (ComTrim(ComGetObjValue(obj)) != "") {
			switch(ComGetEvent("name")) {
	    	case "cntr_grs_wgt":
	    		//팝업에서 가져올때
	    		var strCntrGrsWgt = parseFloat(formObj.cntr_grs_wgt.value);
	    		formObj.cntr_grs_wgt.value = strCntrGrsWgt.toFixed(3);
	    		formObj.cntr_grs_wgt.value = ComAddComma(formObj.cntr_grs_wgt.value);
	    		
	    		var cntr_grs_wgt_lbs           = computeKgIbs(strCntrGrsWgt);
	    		cntr_grs_wgt_lbs					= cntr_grs_wgt_lbs.toFixed(3);
	    		formObj.cntr_grs_wgt_lbs.value = ComAddComma(cntr_grs_wgt_lbs);
	    		
				break;
	    	case "tare_wgt":
	    		//팝업에서 가져올때
	    		var strTareWgt = parseFloat(formObj.tare_wgt.value);
	    		formObj.tare_wgt.value = strTareWgt.toFixed(3);
	    		formObj.tare_wgt.value = ComAddComma(formObj.tare_wgt.value);
	    		var tare_wgt_lbs           = computeKgIbs(strTareWgt);
	    		tare_wgt_lbs					= tare_wgt_lbs.toFixed(3);
	    		formObj.tare_wgt_lbs.value = ComAddComma(tare_wgt_lbs);
	    		
				break;
	    	case "pay_load":
	    		//팝업에서 가져올때
	    		var strPayLoad = parseFloat(formObj.pay_load.value);
	    		formObj.pay_load.value = strPayLoad.toFixed(3);
	    		formObj.pay_load.value = ComAddComma(formObj.pay_load.value);
	    		
	    		var pay_load_lbs           = computeKgIbs(strPayLoad);
	    		pay_load_lbs					= pay_load_lbs.toFixed(3);
	    		formObj.pay_load_lbs.value = ComAddComma(pay_load_lbs);
				break;	
		    }
		}	
	}
	//handling event deactivate
//	function obj_keypress() {
//		obj=event.srcElement;
//		if (obj.dataformat == null)
//			return;
//		window.defaultStatus=obj.dataformat;
//		switch (obj.dataformat) {
//		case "ymd":
//		case "ym":
//		case "hms":
//		case "hm":
//		case "jumin":
//		case "saupja":
//			ComKeyOnlyNumber(obj);
//			break;
//		case "int":		
//			if (obj.name == "txtInt"){
//				ComKeyOnlyNumber(obj, "-");
//			}else{
//				ComKeyOnlyNumber(obj);
//			}
//			break;		
//		case "float":
//			ComKeyOnlyNumber(obj, "-.");
//			break;
//		case "eng":
//			ComKeyOnlyAlphabet();
//			break;
//		case "engup":
//			if (obj.name == "spec_yr"){
//				ComKeyOnlyNumber(obj);
//			}else{
//				ComKeyOnlyAlphabet('upper');
//			}
//			break;
//		case "engdn":
//			if (obj.name == "txtEngDn2"){
//				ComKeyOnlyAlphabet('lowernum');
//			}else{
//				ComKeyOnlyAlphabet('lower');
//			}
//			break;
//		}
//	}


	/**
	 * handlirng Focus-out Event
	 */
	function obj_focusout() {
		var obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
		case "lod_capa":
			if(ComTrim(obj.value) == "" && formObj.cntr_spec_no.value!= "") obj.value = "0";
			if (ComTrim(obj.value) != "") {
				formObj.lod_capa_cbf.value=ComAddComma(computeCbmCbf(obj.value
						.replaceStr(",")));
			}
			sheetObjects[0].SetCellValue(1, "lod_capa",obj.value.replaceStr(","));
			break;
		case "cntr_grs_wgt":

			if(ComTrim(obj.value) == "" && formObj.cntr_spec_no.value!= "") obj.value = "0";
			var cntr_grs_wgt=obj.value.replaceStr(",");
			var tare_wgt=formObj.tare_wgt.value.replaceStr(",");
			
			if (ComTrim(obj.value) != "") {
				formObj.cntr_grs_wgt_ibs.value=ComAddComma(computeKgIbs(cntr_grs_wgt));
				formObj.pay_load.value=ComAddComma(computeKgIbs(obj.value.replaceStr(",")));
				var pay_load=ComRound(cntr_grs_wgt - tare_wgt, 3);
				formObj.pay_load.value=ComAddComma(pay_load);
				formObj.pay_load_ibs.value=ComAddComma(computeKgIbs(pay_load));
			}
			sheetObjects[0].SetCellValue(1, "cntr_grs_wgt",obj.value.replaceStr(","));
			break;
		case "tare_wgt":
			if(ComTrim(obj.value) == "" && formObj.cntr_spec_no.value != "") obj.value = "0";
			var cntr_grs_wgt=formObj.cntr_grs_wgt.value.replaceStr(",");
			var tare_wgt=obj.value.replaceStr(",");
			if (ComTrim(obj.value) != "") {
				formObj.tare_wgt_ibs.value=ComAddComma(computeKgIbs(obj.value.replaceStr(",")));
				var pay_load=ComRound(cntr_grs_wgt - tare_wgt, 3);
				formObj.pay_load.value=ComAddComma(pay_load);
				formObj.pay_load_ibs.value=ComAddComma(computeKgIbs(pay_load));
			}
			sheetObjects[0].SetCellValue(1, "tare_wgt",obj.value.replaceStr(","));
			break;
		case "rc_ldb_capa":
			if (ComTrim(obj.value) != "") {
				formObj.rc_ldb_capa_cbf.value=ComAddComma(computeCbmCbf(obj.value
						.replaceStr(",")));
			}
			sheetObjects[0].SetCellValue(1, "rc_ldb_capa",obj.value.replaceStr(","));
			break;
		case "tnk_capa":
			if (ComTrim(obj.value) != "") {
				formObj.tnk_capa_cbf.value=ComAddComma(computeCbmCbf(obj.value
						.replaceStr(",")));
			}
			sheetObjects[0].SetCellValue(1, "tnk_capa",obj.value.replaceStr(","));
			break;
		case "inter_len":
			sheetObjects[0].SetCellValue(1, "inter_len",obj.value.replaceStr(","));
			break;
		case "inter_wdt":
			sheetObjects[0].SetCellValue(1, "inter_wdt",obj.value.replaceStr(","));
			break;
		case "inter_hgt":
			sheetObjects[0].SetCellValue(1, "inter_hgt",obj.value.replaceStr(","));
			break;
		case "xter_len":
			sheetObjects[0].SetCellValue(1, "xter_len",obj.value.replaceStr(","));
			break;
		case "xter_wdt":
			sheetObjects[0].SetCellValue(1, "xter_wdt",obj.value.replaceStr(","));
			break;
		case "xter_hgt":
			sheetObjects[0].SetCellValue(1, "xter_hgt",obj.value.replaceStr(","));
			break;
		case "opn_dor_wdt":
			sheetObjects[0].SetCellValue(1, "opn_dor_wdt",obj.value.replaceStr(","));
			break;
		case "opn_dor_hgt":
			sheetObjects[0].SetCellValue(1, "opn_dor_hgt",obj.value.replaceStr(","));
			break;
		case "rc_ldb_hgt":
			sheetObjects[0].SetCellValue(1, "rc_ldb_hgt",obj.value.replaceStr(","));
			break;
		case "spec_yr":
			sheetObjects[0].SetCellValue(1, "spec_yr",obj.value.replaceStr(""));
			break;
		case "cntr_mtrl_cd":
			sheetObjects[0].SetCellValue(1, "cntr_mtrl_cd",obj.value.replaceStr(","));
			break;
		}
	}
	/**
	 * CBM to CBF로 (cbm * 35.3028)
	 * @param cbm
	 * @return
	 */
	function computeCbmCbf(cbm) {
		return ComRound(cbm * 35.3028, 0);
	}
	/**
	 * Kg to Ibs(kg * 2.20459)
	 * @param kg
	 * @return
	 */
	function computeKgIbs(kg) {
		return ComRound(kg * 2.20459, 3);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": //sheet1 init
		    with(sheetObj){
		      var HeadTitle="|cntr_spec_no|own_cntr_flg|spec_yr|cntr_tpsz_cd|cntr_mtrl_cd"
		      + "|lod_capa|cntr_grs_wgt|tare_wgt|inter_len|inter_wdt|inter_hgt|xter_len"
		      + "|xter_wdt|xter_hgt|opn_dor_wdt|opn_dor_hgt|rc_ldb_capa|rc_ldb_hgt|tnk_capa|vndr_seq2|vndr_abbr_nm";
		      + "|frack_clps_ctnt|frack_bed_tik_ctnt|opntp_roof_opn_ctnt|opntp_intr_hgt_ctnt|opntp_rear_hdr_opn_ctnt";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"own_cntr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spec_yr",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mtrl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lod_capa",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tare_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inter_len",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inter_wdt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inter_hgt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xter_len",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xter_wdt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xter_hgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opn_dor_wdt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opn_dor_hgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rc_ldb_capa",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rc_ldb_hgt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tnk_capa",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"frack_clps_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"frack_bed_tik_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opntp_roof_opn_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opntp_intr_hgt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opntp_rear_hdr_opn_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      	InitColumns(cols);
		      	SetEditable(0);
		      	SetSheetHeight(100);
	            }
			break;		
	    case "sheet2":	// Hidden sheet
		    with (sheetObj) {
		    }	
	    	break;
		}
	}
	/**
	 * setting combo initial values and header
	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
	 * 
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "combo1":
				with (comboObj) {
					SetDropHeight(200);
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetMultiSeparator(",");
					SetBackColor("#CCFFFD");
					Style=0;
					SetUseAutoComplete(1);
					SetMaxLength(2);// 2 character available
					SetColAlign(0, "center");
					//SetColWidth(0, "30");
					SetColWidth(0, "60");
					SetDropHeight(130);
				}
			 break;
			 case "cntr_mtrl_cd": 
				   with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "30");
						SetColWidth(1, "150");
					    SetDropHeight(160);
				   }   
			 break; 	
			 case "mft_vndr_seq": 
				   with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "100");
						SetColWidth(1, "200");
					    SetDropHeight(160);
				   }   
			 break; 			
		}
	}
	/**
	 * handling process for sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBCREATE:
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do",FormQueryString(formObj) + "&eq_knd_cd=U");
			var chk=sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(sXml,{Sync:1} );
			   return;
			}		
			if (sXml != "") {
				var sCntrTpSzCd=ComGetEtcData(sXml, "cntr_tpsz_cd");
				var arrCntrTpSzCd=sCntrTpSzCd.split("|");
				MstMakeComboObject(comboObjects[0], arrCntrTpSzCd, arrCntrTpSzCd);
			}
			formObj.f_cmd.value=SEARCH01;
			var xmlStr=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
		    var chk=xmlStr.indexOf("ERROR");
			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xmlStr,{Sync:1} );
			   return;
		    }  		
			var sStr=ComGetEtcData(xmlStr, "comboList");
			var arrStr=sStr.split("@");
			MakeComboObject(comboObjects[2], arrStr, 1, 0);    
			//Material code
			formObj.f_cmd.value=SEARCH09;	
			var intgCdId='CD01862';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
				var arrCntrMtrlCdNm=sCntrMtrlCdNm.split("@");
				MakeComboObject(comboObjects[1], arrCntrMtrlCdNm, 1, 0);
			}
			break;
			
		case IBSEARCH: //retrieve
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				var xml="";
				sheetObj.SetWaitImageVisible(1);
				xml=sheetObj.GetSearchData("EES_MST_0021GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(xml,{Sync:1} );
				var own_cntr_flg=sheetObj.GetCellValue(1, "own_cntr_flg");
				var lod_capa=sheetObj.GetCellValue(1, "lod_capa");
				var lod_capa_cbf=computeCbmCbf(lod_capa);
				var cntr_grs_wgt=sheetObj.GetCellValue(1, "cntr_grs_wgt");
				var cntr_grs_wgt_ibs=computeKgIbs(cntr_grs_wgt);
				var tare_wgt=sheetObj.GetCellValue(1, "tare_wgt");
				var tare_wgt_ibs=computeKgIbs(tare_wgt);
				
				var strPayLoad = cntr_grs_wgt - tare_wgt;
				var pay_load = strPayLoad.toFixed(3)
				//var pay_load=ComRound(cntr_grs_wgt - tare_wgt, 3);
				
				
				var pay_load_ibs=computeKgIbs(pay_load);
				// Reefer Cargo Loadable
				var rc_ldb_capa=sheetObj.GetCellValue(1, "rc_ldb_capa");
				var rc_ldb_capa_cbf=computeCbmCbf(rc_ldb_capa);
				var tnk_capa=sheetObj.GetCellValue(1, "tnk_capa");
				var tnk_capa_cbf=computeCbmCbf(tnk_capa);
				formObj.own_cntr_flg.value=sheetObj.GetCellValue(1, "own_cntr_flg");
				comboObjects[0].SetSelectText(sheetObj.GetCellValue(1, "cntr_tpsz_cd"));
				formObj.spec_yr.value=sheetObj.GetCellValue(1, "spec_yr");
				ComSetObjValue(cntr_mtrl_cd, sheetObj.GetCellValue(1,'cntr_mtrl_cd'));
				formObj.lod_capa.value=ComAddComma(lod_capa);
				formObj.lod_capa_cbf.value=ComAddComma(lod_capa_cbf);
				formObj.cntr_grs_wgt.value=ComAddComma(cntr_grs_wgt);
				formObj.cntr_grs_wgt_ibs.value=ComAddComma(cntr_grs_wgt_ibs);
				formObj.tare_wgt.value=ComAddComma(tare_wgt);
				formObj.tare_wgt_ibs.value=ComAddComma(tare_wgt_ibs);
				formObj.pay_load.value=ComAddComma(pay_load);
				formObj.pay_load_ibs.value=ComAddComma(pay_load_ibs);
				formObj.inter_len.value=ComAddComma(sheetObj.GetCellValue(1, "inter_len"));
				formObj.inter_wdt.value=ComAddComma(sheetObj.GetCellValue(1, "inter_wdt"));
				formObj.inter_hgt.value=ComAddComma(sheetObj.GetCellValue(1, "inter_hgt"));
				formObj.xter_len.value=ComAddComma(sheetObj.GetCellValue(1, "xter_len"));
				formObj.xter_wdt.value=ComAddComma(sheetObj.GetCellValue(1, "xter_wdt"));
				formObj.xter_hgt.value=ComAddComma(sheetObj.GetCellValue(1, "xter_hgt"));
				formObj.opn_dor_wdt.value=ComAddComma(sheetObj.GetCellValue(1,"opn_dor_wdt"));
				formObj.opn_dor_hgt.value=ComAddComma(sheetObj.GetCellValue(1,"opn_dor_hgt"));
				formObj.rc_ldb_capa.value=ComAddComma(rc_ldb_capa);
				formObj.rc_ldb_capa_cbf.value=ComAddComma(rc_ldb_capa_cbf);
				formObj.rc_ldb_hgt.value=ComAddComma(sheetObj.GetCellValue(1,"rc_ldb_hgt"));
				formObj.tnk_capa.value=ComAddComma(tnk_capa);
				formObj.tnk_capa_cbf.value=ComAddComma(tnk_capa_cbf);
				formObj.vndr_seq2.value=sheetObj.GetCellValue(1, "vndr_seq2");
				
				formObj.frack_clps_ctnt.value=sheetObj.GetCellValue(1, "frack_clps_ctnt");
				formObj.frack_bed_tik_ctnt.value=sheetObj.GetCellValue(1, "frack_bed_tik_ctnt");
				formObj.opntp_roof_opn_ctnt.value=sheetObj.GetCellValue(1, "opntp_roof_opn_ctnt");
				formObj.opntp_intr_hgt_ctnt.value=sheetObj.GetCellValue(1, "opntp_intr_hgt_ctnt");
				formObj.opntp_rear_hdr_opn_ctnt.value=sheetObj.GetCellValue(1, "opntp_rear_hdr_opn_ctnt");
				
				if (own_cntr_flg == "O") {
					div_dcond0.style.display="";
					div_dcond1.style.display="";
					div_dcond2.style.display="none";
					var vndrseqChk = "N";
					for(var i=0;i<comboObjects[2].GetItemCount();i++) {
						if(comboObjects[2].GetText(i, 0) == sheetObj.GetCellValue(1, "vndr_seq2")) {
							vndrseqChk = "Y";
						}
					}
					
					if(vndrseqChk == "Y") {
						comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1, "vndr_seq2"));
					}else{
						comboObjects[2].SetSelectCode("");
					}
				} else if (own_cntr_flg =="L") {
					div_dcond0.style.display="";
					div_dcond1.style.display="none";
					div_dcond2.style.display="";
					formObj.vndr_seq.value=sheetObj.GetCellValue(1, "vndr_seq2");
			 		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);	 		
			 		if(vndrSeq != ''){
			 			// getting Lessor name
		    	 		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
			 		}					
				} else{
					div_dcond0.style.display="none";
					div_dcond1.style.display="none";
					div_dcond2.style.display="none";					
			 	}
				// when M/facturer doesn't exitst, creating
				if (own_cntr_flg == "O") {		// in case of Own 
					if(mft_vndr_seq.GetSelectCode()== ''){
						mft_vndr_seq.InsertItem(-1, sheetObj.GetCellValue(-1,'vndr_seq2') +'|'+sheetObj.GetCellValue(1,'vndr_abbr_nm'), sheetObj.GetCellValue(1,'vndr_seq2'));
						ComSetObjValue(mft_vndr_seq,sheetObj.GetCellValue(1,'vndr_seq2'));
					}			
				}
				
				f_change_data_setting(formObj, true);
				//ComOpenWait(false);
				// disable key fields
				//activeKeyFields(false);			
				// Term
				nowSpec = formObj.own_cntr_flg.value;
				formObj.own_cntr_flg.disabled = false;
				// TY/SZ
				comboObjects[0].SetEnable(0);
				// Material
				comboObjects[1].SetEnable(1);
				//M/facturer
				comboObjects[2].SetEnable(1);
				//Lessor
				document.getElementById("vndr_seq").className="input1";		
			}
			break;
			
		case IBINSERT: // inserting
			sheetObj.RemoveAll();
			var row=sheetObj.DataInsert(0);
			sheetObj.SetRowStatus(1,"I");
			clearForm();
			activeTankCapa(false);
			activeReeferCapa(false);
			activeFlatCapa(false);
			activeOpenCapa(false);
			// enable key fields
			activeKeyFields(true);
			f_change_data_setting(formObj, false);
			break;
			
		case IBSAVE: // handling MODIFYing or ADDing
			if (validateForm(sheetObj, formObj, sAction)) {
				if(formObj.own_cntr_flg.value =='O'){
					formObj.vndr_seq2.value=mft_vndr_seq.GetSelectCode();
				} else{
					formObj.vndr_seq2.value=formObj.vndr_seq.value;
				}
				sheetObjects[0].SetCellValue(1, "own_cntr_flg",formObj.own_cntr_flg.value);				
				var specYear = formObj.cntr_spec_no.value.substr(0,4);				
				
				if(specYear != formObj.spec_yr.value || nowSpec !=formObj.own_cntr_flg.value) {
					sheetObj.SetRowStatus(1,"I");
					formObj.spec_yr_mod.value = "Y";
					formObj.his_cntr_spec_no.value = formObj.cntr_spec_no.value;
				}else{
					formObj.spec_yr_mod.value = "";
					formObj.his_cntr_spec_no.value = "";
				}
				
				sheetObjects[0].SetCellValue(1, "vndr_seq2",formObj.vndr_seq2.value);
				sheetObjects[0].SetCellValue(1, "cntr_mtrl_cd",comboObjects[1].GetSelectCode());
				sheetObjects[0].SetCellValue(1, "frack_clps_ctnt",formObj.frack_clps_ctnt.value);
				sheetObjects[0].SetCellValue(1, "frack_bed_tik_ctnt",formObj.frack_bed_tik_ctnt.value);
				sheetObjects[0].SetCellValue(1, "opntp_roof_opn_ctnt",formObj.opntp_roof_opn_ctnt.value);
				sheetObjects[0].SetCellValue(1, "opntp_intr_hgt_ctnt",formObj.opntp_intr_hgt_ctnt.value);
				sheetObjects[0].SetCellValue(1, "opntp_rear_hdr_opn_ctnt",formObj.opntp_rear_hdr_opn_ctnt.value);
				
				//sheetObj.WaitImageVisible=false;
				sheetObj.SetWaitImageVisible(1);
				ComOpenWait(true);			
				setTimeout( function () {
                    if (sheetObj.GetRowStatus(1) == "I")
                    {
                        formObj.f_cmd.value=ADD;
                        sheetObj.DoSave("EES_MST_0021GS.do", FormQueryString(formObj), -1, false);
    //					sheetObj.DoSave("EES_MST_0021GS.do", {Param: FormQueryString(formObj), Quest:"false", Sync:1});
                        
    //					var cntr_spec_no=sheetObj.GetCellValue("cntr_spec_no");
    //					var cntr_spec_no=sheetObj.GetEtcData("cntr_spec_no");
    //					formObj.cntr_spec_no.value=cntr_spec_no;
    //					sheetObj.SetCellValue(1, "cntr_spec_no",cntr_spec_no);
    //					sheetObj.SetRowStatus(1,"U");
                    } else {
                        formObj.f_cmd.value=MODIFY;
                        sheetObj.SetRowStatus(1,"U");
                        sheetObj.DoSave("EES_MST_0021GS.do", FormQueryString(formObj), -1, false);
                    }
    //				f_change_data_setting(formObj, true);
                    ComOpenWait(false);
				} , 100);
			}
			break;
			
		case IBDELETE: // removing
			if (validateForm(sheetObj, formObj, sAction)) {
				if (ComShowCodeConfirm("MST00005")) { 
					sheetObj.SetRowStatus(1,"D");
					sheetObj.SetRowHidden(1,1);
					//sheetObj.WaitImageVisible=false;
					//ComOpenWait(true);				
					formObj.f_cmd.value=REMOVE;
	     	        var sParam=ComGetSaveString(sheetObj);
	     	        sParam += "&" + FormQueryString(formObj);				
	     	        var sXml=sheetObj.GetSaveData("EES_MST_0021GS.do", sParam);
	     	        //ComOpenWait(false);
					var chk=sXml.indexOf("ERROR");
					var chk1=sXml.indexOf("◎ Info Message");
					var chk2=sXml.indexOf("Error");
					if (chk == -1 && chk1 == -1 && chk2 == -1){
						doActionIBSheet(sheetObj, formObj, IBINSERT);
						f_change_data_setting(formObj, false);
						return;
					} else {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						return;
					}
				}
			}
			break;
			
		case IBSEARCH_ASYNC03:	// Vendor Code,Name retrieve
			formObj.f_cmd.value=SEARCH07;
			formObj.code.value=formObj.vndr_seq.value;
			var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
			var chk=sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				return;
			}		
			var text=ComNullToBlank(ComGetEtcData(sXml,"code_nm"));		
			formObj.vndr_lgl_eng_nm.value=text;
		break;			
		
	 	case IBSEARCH_ASYNC04:	// Vendor Code,Name retrieve
			formObj.f_cmd.value=SEARCH07;
	 		formObj.code.value=formObj.vndr_seq.value;
	 		var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
		    var chk=sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(sXml,{Sync:1} );
			   return;
		    }		
			var text=ComNullToBlank(ComGetEtcData(sXml,"code_nm"));		
			formObj.vndr_lgl_eng_nm.value=text;
			break;			
		}
	}
	
	function sheet1_OnSaveEnd(sheetObj , Code, ErrMsg) { 
		var formObj=document.form;
		if(formObj.spec_yr_mod.value == "Y") {
			var newCntrSpecNo=sheetObj.GetEtcData("cntr_spec_no");
			formObj.cntr_spec_no.value = newCntrSpecNo;
			obj_cntr_spec_no_change();
		}
		if (sheetObj.GetRowStatus(1) == "R") {
//			var cntr_spec_no=sheetObj.GetEtcData("cntr_spec_no");
			var cntr_spec_no=sheetObj.GetCellValue(1, "cntr_spec_no");
			if(cntr_spec_no == "" || cntr_spec_no == "undefined") {
				cntr_spec_no=sheetObj.GetEtcData("cntr_spec_no");
//			    cntr_spec_no=sheetObj.GetCellValue(1, "cntr_spec_no");
			}
			formObj.cntr_spec_no.value=cntr_spec_no;
			sheetObj.SetCellValue(1, "cntr_spec_no",cntr_spec_no);
		}

		f_change_data_setting(formObj, true);
        if (sheetObj.GetRowStatus(1) == "U") {
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }			
	}
	
	
	
	/**
	 * initTankCapa 
	 * initailizing TankCapa
	 * @return
	 */
	function initTankCapa() {
		var formObj=document.form;
		formObj.tnk_capa.value="";
		formObj.tnk_capa_cbf.value="";
		sheetObjects[0].SetCellValue(1, "tnk_capa","");
	}
	/**
	 * activeTankCapa
	 * 
	 * @param active
	 * @return
	 */
	function activeTankCapa(active) {
		var formObj=document.form;
		if (active) {
			formObj.tnk_capa.readOnly=false;
			document.getElementById("tnk_capa").className="input";
		} else {
			formObj.tnk_capa.readOnly=true;
			document.getElementById("tnk_capa").className="input2";
		}
	}
	/**
	 * initReeferCapa 
	 * initailizing ReeferCapa
	 * @return
	 */
	function initReeferCapa() {
		var formObj=document.form;
		formObj.rc_ldb_capa.value="";
		formObj.rc_ldb_capa_cbf.value="";
		formObj.rc_ldb_hgt.value="";
		sheetObjects[0].SetCellValue(1, "rc_ldb_capa","");
		sheetObjects[0].SetCellValue(1, "rc_ldb_hgt","");
	}
	/**
	 * activeReeferCapa
	 * 
	 * @param active
	 * @return
	 */
	function activeReeferCapa(active) {
		var formObj=document.form;
		if (active) {
			formObj.rc_ldb_capa.readOnly=false;
			formObj.rc_ldb_hgt.readOnly=false;
			document.getElementById("rc_ldb_capa").className="input";
			document.getElementById("rc_ldb_hgt").className="input";
		} else {
			formObj.rc_ldb_capa.readOnly=true;
			formObj.rc_ldb_hgt.readOnly=true;
			document.getElementById("rc_ldb_capa").className="input2";
			document.getElementById("rc_ldb_hgt").className="input2";
		}
	}
	
	/**
	 * initFlatCapa 
	 * initailizing FlatCapa 
	 * @return
	 */
	function initFlatCapa() {
		var formObj=document.form;
		formObj.frack_clps_ctnt.value="";
		formObj.frack_bed_tik_ctnt.value="";
		sheetObjects[0].SetCellValue(1, "frack_clps_ctnt","");
		sheetObjects[0].SetCellValue(1, "frack_bed_tik_ctnt","");
	}
	/**
	 * activeFlatCapa
	 * 
	 * @param active
	 * @return
	 */
	function activeFlatCapa(active) {
		var formObj=document.form;
		if (active) {
			formObj.frack_clps_ctnt.readOnly=false;
			document.getElementById("frack_clps_ctnt").className="input";
			formObj.frack_bed_tik_ctnt.readOnly=false;
			document.getElementById("frack_bed_tik_ctnt").className="input";
		} else {
			formObj.frack_clps_ctnt.readOnly=true;
			document.getElementById("frack_clps_ctnt").className="input2";
			formObj.frack_bed_tik_ctnt.readOnly=true;
			document.getElementById("frack_bed_tik_ctnt").className="input2";
		}
	}
	
	
	/**
	 * initOpenCapa 
	 * initailizing OpenCapa  
	 * @return
	 */
	function initOpenCapa() {
		var formObj=document.form;
		formObj.opntp_roof_opn_ctnt.value="";
		formObj.opntp_intr_hgt_ctnt.value="";
		formObj.opntp_rear_hdr_opn_ctnt.value="";
		sheetObjects[0].SetCellValue(1, "opntp_roof_opn_ctnt","");
		sheetObjects[0].SetCellValue(1, "opntp_intr_hgt_ctnt","");
		sheetObjects[0].SetCellValue(1, "opntp_rear_hdr_opn_ctnt","");
	}
	/**
	 * activeOpenCapa
	 * 
	 * @param active
	 * @return
	 */
	function activeOpenCapa(active) {
		var formObj=document.form;
		if (active) {
			formObj.opntp_roof_opn_ctnt.readOnly=false;
			document.getElementById("opntp_roof_opn_ctnt").className="input";
			formObj.opntp_intr_hgt_ctnt.readOnly=false;
			document.getElementById("opntp_intr_hgt_ctnt").className="input";
			formObj.opntp_rear_hdr_opn_ctnt.readOnly=false;
			document.getElementById("opntp_rear_hdr_opn_ctnt").className="input";
		} else {
			formObj.opntp_roof_opn_ctnt.readOnly=true;
			document.getElementById("opntp_roof_opn_ctnt").className="input2";
			formObj.opntp_intr_hgt_ctnt.readOnly=true;
			document.getElementById("opntp_intr_hgt_ctnt").className="input2";
			formObj.opntp_rear_hdr_opn_ctnt.readOnly=true;
			document.getElementById("opntp_rear_hdr_opn_ctnt").className="input2";
		}
	}
	
	/**
	 * activeKeyFields
	 * handling activation of key fields
	 * @param active
	 * @return
	 */
	function activeKeyFields(active) {
		var formObj=document.form;
		if (active) 
		{
			// Term
			formObj.own_cntr_flg.disabled = false;
			// Year
			formObj.spec_yr.readOnly=false;
			document.getElementById("spec_yr").className="input1";
			// TY/SZ
			comboObjects[0].SetEnable(1);
			// Material
			comboObjects[1].SetEnable(true);
			//M/facturer
			comboObjects[2].SetEnable(1);
			//Lessor
			document.getElementById("vndr_seq").className="input1";
		} else 
		{
			// Term
			formObj.own_cntr_flg.disabled = true;
			// Year
			//formObj.spec_yr.readOnly=true;
			//document.getElementById("spec_yr").className="input2";
			// TY/SZ
			comboObjects[0].SetEnable(0);
			// Material
			comboObjects[1].SetEnable(1);
			//M/facturer
			comboObjects[2].SetEnable(1);
			//Lessor
			document.getElementById("vndr_seq").className="input1";		
		}
	}
	/**
	 * combo1_OnChange
	 * handling event changing on combo1
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function combo1_OnChange(comboObj, OlđĨ, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		if (document.form.popflag.value == "") // when called as main
		{
			var strTpszCd=ComGetObjValue(comboObj);
			sheetObjects[0].SetCellValue(1, "cntr_tpsz_cd",strTpszCd);
			if (strTpszCd.substring(0, 1) == "R") // in case of TY/SZ=R,  Tank Capacity disable.
			{
				activeTankCapa(false);
				activeFlatCapa(false);
				activeOpenCapa(false);
				activeReeferCapa(true);
				initTankCapa();
			} else if (strTpszCd.substring(0, 1) == "T") // in case of TY/SZ=T, Reefer
			{
				activeTankCapa(true);
				activeReeferCapa(false);
				activeFlatCapa(false);
				activeOpenCapa(false);
				initReeferCapa();
			} else if (strTpszCd.substring(0, 1) == "F") // in case of TY/SZ=F, Reefer
			{
				activeTankCapa(false);
				activeReeferCapa(false);
				activeFlatCapa(true);
				activeOpenCapa(false);
				initFlatCapa();
			} else if (strTpszCd.substring(0, 1) == "O") // in case of TY/SZ=O, Reefer
			{
				activeTankCapa(false);
				activeReeferCapa(false);
				activeFlatCapa(false);
				activeOpenCapa(true);
				initOpenCapa();
			} else // disable all
			{
				activeTankCapa(false);
				activeReeferCapa(false);
				activeFlatCapa(false);
				activeOpenCapa(false);
				initTankCapa();
				initReeferCapa();
				initFlatCapa();
				initOpenCapa();
			}
		}
	}
	/**
	 * changeTySzCd
	 * 
	 * @param strTpszCd
	 * @return
	 */
	function initTankRefferValue(strTp) {
		var formObj=document.form;
		if (strTp == "R") // in case of TY/SZ=R, Tank Capacity disable.
		{
			formObj.tnk_capa.value=0;
			formObj.tnk_capa_cbf.value=0;
		} else if (strTp == "T") // in case of TY/SZ=T, Reefer Cargo Loadable disable.
		{
			formObj.rc_ldb_capa.value=0;
			formObj.rc_ldb_capa_cbf.value=0;
			formObj.rc_ldb_hgt.value=0;
		} else // disable all
		{
			formObj.tnk_capa.value=0;
			formObj.tnk_capa_cbf.value=0;
			formObj.rc_ldb_capa.value=0;
			formObj.rc_ldb_capa_cbf.value=0;
			formObj.rc_ldb_hgt.value=0;
		}
	}
	/**
	 * changeTySzCd
	 *
	 * @param strTpszCd
	 * @return
	 */
	function changeTySzCd(strTpszCd) {
		if (strTpszCd.substring(0, 1) == "R") // in case of TY/SZ=R, Tank Capacity disable.
		{
			activeTankCapa(false);
			activeReeferCapa(true);
			initTankRefferValue("R");
		} else if (strTpszCd.substring(0, 1) == "T") // in case of TY/SZ=T,  Reefer Cargo
														// Loadable disable.
		{
			activeTankCapa(true);
			activeReeferCapa(false);
			initTankRefferValue("T");
		} else // disable all
		{
			activeTankCapa(false);
			activeReeferCapa(false);
			initTankRefferValue("");
		}
	}
	/**
	 * combo1_OnKeyDown
	 * handling key down event on combo1
	 * @param comboObj
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	with (comboObj) {
		if (KeyCode == 8 || KeyCode == 46) {
			for (i=0; i < GetItemCount(); i++) {
				if (CheckIndex(i)) {
					CheckIndex(i)=false;
				}
			}
		}
	}
	}
	/**
	 * Pop-up Open<br>
	 */
	function openPopup() {
		var formObj=document.form;
		var sUrl='/opuscntr/EES_MST_0022_POP.do';
		var iWidth=1250;
		var iHeight=630;
		var sTargetObjList="cntr_spec_no:cntr_spec_no|cntr_tpsz_cd:cntr_tpsz_cd|cntr_mtrl_cd:cntr_mtrl_cd|frack_clps_ctnt:frack_clps_ctnt|frack_bed_tik_ctnt:frack_bed_tik_ctnt|opntp_roof_opn_ctnt:opntp_roof_opn_ctnt|opntp_intr_hgt_ctnt:opntp_intr_hgt_ctnt|opntp_rear_hdr_opn_ctnt:opntp_rear_hdr_opn_ctnt";
		var sDisplay="0,0";
		var ownCntrFlg="";
		if (formObj.own_cntr_flg.value=="O"){
			div_dcond1.style.display="";
			div_dcond2.style.display="none";		
		}else {
			div_dcond1.style.display="none";
			div_dcond2.style.display="";		
		}
		ownCntrFlg=formObj.own_cntr_flg.value;
		var strvndr_seq = formObj.vndr_seq.value;
		var strvndr_lgl_eng_nm = formObj.vndr_lgl_eng_nm.value;
		// in case of Term, Tp/Sz, From, To, AGMT, Flag == 1, using on EES_MST_0016.do
		// in case of Flag == 2, using on EES_MST_0021.do
		var param="?own_cntr_flg=" + ownCntrFlg
				+ "&cntr_tpsz_cd=&from_spec_yr=&to_spec_yr=&agmt_no=&active_flag=2&strVndrSeq=&strVndrNm=";
		ComOpenPopupWithTarget(sUrl + param, iWidth, iHeight, sTargetObjList, sDisplay,true);		
	}
	/**
	 * Form Element Clear .<br>
	 */
	function clearForm() {
		var formObj=document.form;
		formObj.own_cntr_flg.value="O";
		
		formObj.cntr_spec_no.value="";
		comboObjects[0].SetSelectText("");
		comboObjects[1].SetSelectText("");
		formObj.spec_yr.value="";
		formObj.lod_capa.value="";
		formObj.lod_capa_cbf.value="";
		formObj.cntr_grs_wgt.value="";
		formObj.cntr_grs_wgt_ibs.value="";
		formObj.tare_wgt.value="";
		formObj.tare_wgt_ibs.value="";
		formObj.pay_load.value="";
		formObj.pay_load_ibs.value="";
		formObj.inter_len.value="";
		formObj.inter_wdt.value="";
		formObj.inter_hgt.value="";
		formObj.xter_len.value="";
		formObj.xter_wdt.value="";
		formObj.xter_hgt.value="";
		formObj.opn_dor_wdt.value="";
		formObj.opn_dor_hgt.value="";
		formObj.rc_ldb_capa.value="";
		formObj.rc_ldb_capa_cbf.value="";
		formObj.rc_ldb_hgt.value="";
		formObj.tnk_capa.value="";
		formObj.tnk_capa_cbf.value="";
		formObj.vndr_seq2.value="";	
		comboObjects[1].SetSelectCode("");
		comboObjects[2].SetSelectCode("");
		formObj.vndr_seq.value="";	
		formObj.vndr_lgl_eng_nm.value="";	
		div_dcond0.style.display = "";
		div_dcond1.style.display = "";
		div_dcond2.style.display = "none";
		
	}
	/**
	 * DataTosheet 
	 * @return
	 */
	//function DataTosheet() {
	//	var formObj = document.form;
	//	
	//	if (formObj.own_cntr_flg[0].checked == true)
	//		sheetObj.CellValue(1, "own_cntr_flg") = "Y";
	//	else if (formObj.own_cntr_flg[1].checked == true)
	//		sheetObj.CellValue(1, "own_cntr_flg") = "N";
	//	else
	//		sheetObj.CellValue(1, "own_cntr_flg") = "";
	//	
	//	sheetObj.CellValue(1, "cntr_tpsz_cd") = comboObjects[0].Text;
	//	sheetObj.CellValue(1, "spec_yr") = formObj.spec_yr.value;
	//	sheetObj.CellValue(1, "cntr_mtrl_cd") = comboObjects[1].Code;
	//	sheetObj.CellValue(1, "lod_capa") = formObj.lod_capa.value;
	//	sheetObj.CellValue(1, "cntr_grs_wgt") = formObj.cntr_grs_wgt.value;
	//	sheetObj.CellValue(1, "tare_wgt") = formObj.tare_wgt.value;
	//	sheetObj.CellValue(1, "inter_len") = formObj.inter_len.value;
	//	sheetObj.CellValue(1, "inter_wdt") = formObj.inter_wdt.value;
	//	sheetObj.CellValue(1, "inter_hgt") = formObj.inter_hgt.value;
	//	sheetObj.CellValue(1, "xter_len") = formObj.xter_len.value;
	//	sheetObj.CellValue(1, "xter_wdt") = formObj.xter_wdt.value;
	//	sheetObj.CellValue(1, "xter_hgt") = formObj.xter_hgt.value;
	//	sheetObj.CellValue(1, "opn_dor_wdt") = formObj.opn_dor_wdt.value;
	//	sheetObj.CellValue(1, "opn_dor_hgt") = formObj.opn_dor_hgt.value;
	//	sheetObj.CellValue(1, "rc_ldb_capa") = formObj.rc_ldb_capa.value;
	//	sheetObj.CellValue(1, "rc_ldb_hgt") = formObj.rc_ldb_hgt.value;
	//	sheetObj.CellValue(1, "tnk_capa") = formObj.tnk_capa.value;
	//	
	//	if (formObj.own_cntr_flg[0].checked == true)
	//		sheetObj.CellValue(1, "vndr_seq2") = formObj.mft_vndr_seq.Code;
	//	else if (formObj.own_cntr_flg[1].checked == true)
	//		sheetObj.CellValue(1, "vndr_seq2") = formObj.vndr_seq.value;
	//	
	//		
	//}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		if (sAction == IBSAVE) { // save시 mandatory inserting값 checking.
			if (spec_yr.value == "" || spec_yr.value == null) {
				spec_yr.focus();
				ComShowCodeMessage("MST00001", "Year");
				return false;
			}
			if (comboObjects[0].GetSelectText()== "") {
				ComShowCodeMessage("MST00001", "TY/SZ");
				return false;
			}

			if (formObj.own_cntr_flg.value != "S") {
				if (comboObjects[1].GetSelectText()== "") {
					ComShowCodeMessage("MST00001", "Material");
					return false;
				}
				if (comboObjects[2].GetSelectText()== "" && vndr_lgl_eng_nm.value == "") {
					if(formObj.own_cntr_flg.value =="O"){
						ComShowCodeMessage("MST00001", "M/facturer");
					}else{
						ComShowCodeMessage("MST00001", "Lessor");				
					}
					return false;
				}				
			}		
		} else if (sAction == IBDELETE) {
			if (cntr_spec_no.value == "" || cntr_spec_no.value == null) {
				ComShowCodeMessage("MST00001", "Spec No");
				return false;
			}
		}
	}
	return true;
	}
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}

	/**
	 * handlin event changing on object
	 */
	function obj_vndr_seq_change() {
		var formObj = document.form;
		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);

		if (vndrSeq != "") {
			// getting Lessor name
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
		} else {
			// removing Lessor
			formObj.vndr_lgl_eng_nm.value = "";
		}
	}

	/**
	 * handlin event changing on object
	 */
	function obj_cntr_spec_no_change() {
		var formObj = document.form;

		if (formObj.cntr_spec_no.value != "") {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}

		changeTySzCd(ComGetObjValue(document.getElementById(comboObjects[0].options.id)));
	}


	function obj_own_cntr_flg_change(){
		var formObj = document.form;
		
		comboObjects[1].SetSelectText("");
		comboObjects[2].SetSelectText("");
		comboObjects[1].SetSelectCode("");
		comboObjects[2].SetSelectCode("");		
		formObj.vndr_seq.value="";
		formObj.vndr_lgl_eng_nm.value="";
		switch (formObj.own_cntr_flg.value) {
		case "O":
			div_dcond1.style.display = "";
			div_dcond2.style.display = "none";	
			div_dcond0.style.display = "";
			break;
		case "L":
			div_dcond1.style.display = "none";
			div_dcond2.style.display = "";	
			div_dcond0.style.display = "";
			break;
		case "S":
			div_dcond1.style.display = "none";
			div_dcond2.style.display = "none";	
			div_dcond0.style.display = "none";
			break;
		} // end switch		

		ComSetFocus(formObj.spec_yr);	
	}


	function ComNullToBlank(sStr){
		if( sStr==null || sStr=='null' || sStr=='undefined' || sStr==undefined || typeof sStr=='undefined'){
			return '';
		} else {
			return sStr;
		}
	} 
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터를 셋팅한다.
	  */
	 function f_change_data_setting(formObj, inputFlg) {
		 if (inputFlg == true) {
			 arr_lod_capa           [0]=formObj.lod_capa       .value;  arr_lod_capa           [1]=formObj.lod_capa       .value;
			 arr_cntr_grs_wgt       [0]=formObj.cntr_grs_wgt   .value;  arr_cntr_grs_wgt       [1]=formObj.cntr_grs_wgt   .value;
			 arr_tare_wgt           [0]=formObj.tare_wgt       .value;  arr_tare_wgt           [1]=formObj.tare_wgt       .value;
			 arr_inter_len          [0]=formObj.inter_len      .value;  arr_inter_len          [1]=formObj.inter_len      .value;
			 arr_inter_wdt          [0]=formObj.inter_wdt      .value;  arr_inter_wdt          [1]=formObj.inter_wdt      .value;
			 arr_inter_hgt          [0]=formObj.inter_hgt      .value;  arr_inter_hgt          [1]=formObj.inter_hgt      .value;
			 arr_xter_len           [0]=formObj.xter_len       .value;  arr_xter_len           [1]=formObj.xter_len       .value;
			 arr_xter_wdt           [0]=formObj.xter_wdt       .value;  arr_xter_wdt           [1]=formObj.xter_wdt       .value;
			 arr_xter_hgt           [0]=formObj.xter_hgt       .value;  arr_xter_hgt           [1]=formObj.xter_hgt       .value;
			 arr_opn_dor_wdt        [0]=formObj.opn_dor_wdt    .value;  arr_opn_dor_wdt        [1]=formObj.opn_dor_wdt    .value;
			 arr_opn_dor_hgt        [0]=formObj.opn_dor_hgt    .value;  arr_opn_dor_hgt        [1]=formObj.opn_dor_hgt    .value;
			 arr_rc_ldb_capa        [0]=formObj.rc_ldb_capa    .value;  arr_rc_ldb_capa        [1]=formObj.rc_ldb_capa    .value;
			 arr_rc_ldb_capa_cbf    [0]=formObj.rc_ldb_capa_cbf.value;  arr_rc_ldb_capa_cbf    [1]=formObj.rc_ldb_capa_cbf.value;
			 arr_tnk_capa_cbf       [0]=formObj.tnk_capa_cbf   .value;  arr_tnk_capa_cbf       [1]=formObj.tnk_capa_cbf   .value;
		 } else {
			 arr_lod_capa           [0]="";  arr_lod_capa           [1]="";     
			 arr_cntr_grs_wgt       [0]="";  arr_cntr_grs_wgt       [1]="";     
			 arr_tare_wgt           [0]="";  arr_tare_wgt           [1]="";     
			 arr_inter_len          [0]="";  arr_inter_len          [1]="";                                                                              
			 arr_inter_wdt          [0]="";  arr_inter_wdt          [1]="";                                                                              
			 arr_inter_hgt          [0]="";  arr_inter_hgt          [1]="";                                                                              
			 arr_xter_len           [0]="";  arr_xter_len           [1]="";                                                                              
			 arr_xter_wdt           [0]="";  arr_xter_wdt           [1]="";                                                                              
			 arr_xter_hgt           [0]="";  arr_xter_hgt           [1]="";                                                                              
			 arr_opn_dor_wdt        [0]="";  arr_opn_dor_wdt        [1]="";                                                                              
			 arr_opn_dor_hgt        [0]="";  arr_opn_dor_hgt        [1]="";                                                                              
			 arr_rc_ldb_capa        [0]="";  arr_rc_ldb_capa        [1]="";                                                                              
			 arr_rc_ldb_capa_cbf    [0]="";  arr_rc_ldb_capa_cbf    [1]="";                                                                              
			 arr_tnk_capa_cbf       [0]="";  arr_tnk_capa_cbf       [1]="";  
		 }
	 }
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터 변경 여부를 리턴한다.
	  * return Value
	  * true : 변경 됨
	  * false : 유지 됨
	  */
	 function f_change_data_checking(formObj) {
		 formObj.frack_clps_ctnt.value = "";
		 formObj.frack_bed_tik_ctnt.value = "";
		 formObj.opntp_roof_opn_ctnt.value = "";
		 formObj.opntp_intr_hgt_ctnt.value = "";
		 formObj.opntp_rear_hdr_opn_ctnt.value = "";
		 
		 arr_lod_capa           [1]=formObj.lod_capa       .value;
		 arr_cntr_grs_wgt       [1]=formObj.cntr_grs_wgt   .value;
		 arr_tare_wgt           [1]=formObj.tare_wgt       .value;
		 arr_inter_len          [1]=formObj.inter_len      .value;
		 arr_inter_wdt          [1]=formObj.inter_wdt      .value;
		 arr_inter_hgt          [1]=formObj.inter_hgt      .value;
		 arr_xter_len           [1]=formObj.xter_len       .value;
		 arr_xter_wdt           [1]=formObj.xter_wdt       .value;
		 arr_xter_hgt           [1]=formObj.xter_hgt       .value;
		 arr_opn_dor_wdt        [1]=formObj.opn_dor_wdt    .value;
		 arr_opn_dor_hgt        [1]=formObj.opn_dor_hgt    .value;
		 arr_rc_ldb_capa        [1]=formObj.rc_ldb_capa    .value;
		 arr_rc_ldb_capa_cbf    [1]=formObj.rc_ldb_capa_cbf.value;
		 arr_tnk_capa_cbf       [1]=formObj.tnk_capa_cbf   .value;
		 if ( 
				 ( getZeroToNum( arr_lod_capa           [0] ) !=  getZeroToNum( arr_lod_capa           [1] )) ||      
				 ( getZeroToNum( arr_cntr_grs_wgt       [0] ) !=  getZeroToNum( arr_cntr_grs_wgt       [1] )) ||      
				 ( getZeroToNum( arr_tare_wgt           [0] ) !=  getZeroToNum( arr_tare_wgt           [1] )) ||      
				 ( getZeroToNum( arr_inter_len          [0] ) !=  getZeroToNum( arr_inter_len          [1] )) ||                                                                              
				 ( getZeroToNum( arr_inter_wdt          [0] ) !=  getZeroToNum( arr_inter_wdt          [1] )) ||                                                                              
				 ( getZeroToNum( arr_inter_hgt          [0] ) !=  getZeroToNum( arr_inter_hgt          [1] )) ||                                                                              
				 ( getZeroToNum( arr_xter_len           [0] ) !=  getZeroToNum( arr_xter_len           [1] )) ||                                                                              
				 ( getZeroToNum( arr_xter_wdt           [0] ) !=  getZeroToNum( arr_xter_wdt           [1] )) ||                                                                              
				 ( getZeroToNum( arr_xter_hgt           [0] ) !=  getZeroToNum( arr_xter_hgt           [1] )) ||                                                                              
				 ( getZeroToNum( arr_opn_dor_wdt        [0] ) !=  getZeroToNum( arr_opn_dor_wdt        [1] )) ||                                                                              
				 ( getZeroToNum( arr_opn_dor_hgt        [0] ) !=  getZeroToNum( arr_opn_dor_hgt        [1] )) ||                                                                              
				 ( getZeroToNum( arr_rc_ldb_capa        [0] ) !=  getZeroToNum( arr_rc_ldb_capa        [1] )) ||                                                                              
				 ( getZeroToNum( arr_rc_ldb_capa_cbf    [0] ) !=  getZeroToNum( arr_rc_ldb_capa_cbf    [1] )) ||                                                                              
				 ( getZeroToNum( arr_tnk_capa_cbf       [0] ) !=  getZeroToNum( arr_tnk_capa_cbf       [1] ))             
			) {
			return  ComShowCodeConfirm("COM130504")  ;
		 } else {
			 return false;
		 }
	 }
