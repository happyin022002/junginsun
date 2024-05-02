﻿﻿﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0229.js
*@FileTitle  : e-Booking & SI Process Top 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var iterator="|$$|";
var isFirstOnLoad="false";
var isCopyAllRequested=false;
var saveFail=false;
var saveSuccess=true;
var tabDataSearchEnd = 0;
var tabDataSearchStart = 0;
var viewType = null;

//// Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_copyoption":
			isFirstOnLoad="false";
			comBkgCallPop0231();
			break;
		case "btn_preview":
			rdOpen("preview");
			break;
		case "btn_previewprint":
			rdOpen("print");
			break;
		case "btn_opusupload":
//			ComOpenWait(true);
			saveFail == false;
			saveSuccess=true;
			if(formObject.loadFinish.value=="N"){
				ComShowCodeMessage("Screen", "");
				break;
			}
			var t1frame_form=window.frames["t1frame"].form;
			// open window which is related with C/A Reason after BDR
			if(t1frame_form.rqst_iss_plc_nm.value.length > 50 ){
				ComShowCodeMessage("BKG02087");
				return false;
			}
			if (t1frame_form.xter_bkg_rqst_sts_cd.value == "X") {
				doActionIBSheet(sheetObject, formObject, COMMAND03);
			} else if (t1frame_form.bdr_flg.value == "Y") {
				var bkgNo=nullToBlank(t1frame_form.bkg_no.value); 
				if (bkgNo == "") {
					ComShowCodeMessage("BKG00255");
					return false;
				}
				doActionIBSheet(sheetObject, formObject, COMMAND02);
			} else {
				doActionIBSheet(sheetObject, formObject, COMMAND02);
			}
			
			uploadNextFunction();
			
//			if(saveFail==false && saveSuccess==true){	
//				if(t1frame_form.bkg_wt_chk_flg.checked && !t1frame_form.bkg_wt_chk_flg.disabled){
//					var rtnData = sheetObject.GetSaveData("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+t1frame_form.bkg_no.value);
//				}
//				reloadPage();
//			} else if(saveFail==true){// in case of finishing to 'save file'-> initializing
//				saveFail=false; 
//				saveSuccess=true;
//				setBtnEnableSts("btn_opusupload", true);
//			}
//			ComOpenWait(false);
			break;
		case "btn_reject":
			comBkgCallPop0902();
			break;
		case "btn_pending":
			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
			break;
		case "btn_reinstate":
			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
			break;
		case "btn_retrieve":
			reloadPage();
			break;
		case "btn_xmlview":
			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC03);
			break;
		} // end switch
	} catch (e) {
//		ComOpenWait(false);
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 * adding function which should be handled first after loading screen
 * 
 */
function loadPage() {
	for ( var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	tabObjects[0].SetSelectedIndex(0);
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].FitColWidth();
	}
	initControl();
}
function reloadPage() {
	var formObj=document.form
	formObj.f_cmd.value=SEARCH;
	formObj.method="get";
	formObj.target="_self";
	formObj.action="/opuscntr/ESM_BKG_0229.do" + formObj.param_data.value;
	formObj.submit();
}
/**
 * setting sheet initial values and header param : sheetObj ==> sheet Object, sheetNo ==> sequence
 *  adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: 
	    with(sheetObj){
		      var HeadTitle="ibflag|rqst_no|rqst_seq|sender_id";
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				           {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rqst_no" },
				           {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rqst_seq" },
				           {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sender_id" },
				           {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cntc_pson_eml" },
				           {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" }
				           ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetVisible(false);
            }
		break;
	}
}
function initControl() {
	applyShortcut();
}
/**
 * registering IBTab Object as list adding process for list in case of needing batch processing with other items 
 * 
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * setting Tab  setting item of Tab
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			tabObj.InsertItem( eBkgTabName[0], "");
			tabObj.InsertItem( eBkgTabName[1], "");
			tabObj.InsertItem( eBkgTabName[2], "");
			tabObj.InsertItem( eBkgTabName[3], "");
			tabObj.InsertItem( eBkgTabName[4], "");
			tabObj.InsertItem( eBkgTabName[5], "");
			tabObj.InsertItem( eBkgTabName[6], "");
			tabObj.InsertItem( eBkgTabName[7], "");
			tabObj.InsertItem( eBkgTabName[8], "");
			tabObj.InsertItem( eBkgTabName[9], "");
			tabObj.InsertItem( eBkgTabName[10], "");
		}
		break;
	}
//no support[check again]CLT 	tabObj.TabMouseOverEffect=true;
}
/**
 * Event when clicking Tab activating selected tab items
 */
function tab1_OnChange(tabObj, tabIndex) {
	if (beforetab != tabIndex) {
		var objs=document.all.item("tabLayer");
		objs[tabIndex].style.position = "relative";
		objs[tabIndex].style.top = "0px";
		objs[beforetab].style.position = "absolute";
		objs[beforetab].style.top = "-9000px";
	}
	beforetab=tabIndex;
}
function loadTabPage(tabIndex) {
	var formObj=document.form;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet();
}
function clearAllTabPages() {
	for ( var i=0; i < tabObjects[0].GetCount(); i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
		}
	}
}
function enableAllTabPages(flag) {
	if (flag == null || flag == "") {
		if (document.form.cfm_flg.value.toUpperCase() != "YES") {
			flag=true;
		} else {
			flag=false;
		}
	}
	for ( var i=0; i < tabObjects[0].GetCount(); i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
		}
	}
}
//calling from jsp, and executing first 
function frame1_OnLoad() {
	if (isFirstOnLoad == "false") {
//		var timer;
//		timer = setTimeout("setTabSrc()", 500, "Javascript");
		// after loading the first tab , executing
		ComOpenWait(true);
		setTimeout("setTabSrc()", 500);
		
//		setTabSrc();
	}
	//autoResize(ComGetEvent("name"));
}
function frame_OnLoad() {
	var srcName=ComGetEvent("name");
	if (undefined != window.frames[srcName].document.form) {
		if (srcName == "t1frame") {
			document.form.t1load.value = "Y";			
		} else if (srcName == "t2frame") {
			document.form.t2load.value = "Y";			
		} else if (srcName == "t3frame") {
			document.form.t3load.value = "Y";			
		} else if (srcName == "t4frame") {
			document.form.t4load.value = "Y";			
		} else if (srcName == "t5frame") {
			document.form.t5load.value = "Y";			
		} else if (srcName == "t6frame") {
			document.form.t6load.value = "Y";			
		} else if (srcName == "t7frame") {
			document.form.t7load.value = "Y";			
		} else if (srcName == "t8frame") {
			document.form.t8load.value = "Y";			
		} else if (srcName == "t9frame") {
			document.form.t9load.value = "Y";			
		} else if (srcName == "t10frame") {
			document.form.t10load.value = "Y";			
		} else if (srcName == "t11frame") {
			document.form.t11load.value = "Y";			
		}
	}
	if (isCopyAllRequested && window.frames[srcName].document.form) {
		if("t10frame"==srcName){
//			if("1"==ComGetObjValue(window.frames["t1frame"].form.usa_cstms_file_cd)){
				window.frames[srcName].window.dataCopy();				
//			}		
		} else {
			window.frames[srcName].window.dataCopy();
		}
	}
	//autoResize(srcName);
}
// after booking tab is loading, each tab is loading
function setTabSrc() {
	var formObj=document.form; 
//	var t1frame_form=window.frames["t1frame"].form;
	var t1frame_form=window.frames['t1frame'].form;
	var param=formObj.param_data.value;
	isFirstOnLoad="true";
	if (!ComIsNull(t1frame_form.bdr_flg.value) && t1frame_form.bdr_flg.value == "Y") {
		ComOpenWait(false);
		ComShowCodeMessage("BKG02047");
	}
	/*opening Data Copy(ESM_BKG_0231)
	when e-Booking & SI is uploaded,  showing the message below when Booking information is not existed
    copying Booking and data automatically, 
	in case Booking information is not existed, selecting copy item by option*/
	isCopyAllRequested=false;
	if (t1frame_form.save_bkg_flag.value == "Y") {
		if (ComShowCodeConfirm("BKG02018")) {
			isCopyAllRequested=true;
			window.frames["t1frame"].window.doDataCopy();
		}
		else {
			isCopyAllRequested=false;
			//return: not loading other tab
//			return;
		}
	}else if(t1frame_form.save_bkg_flag.value != "Y") {
		if (t1frame_form.bkg_upld_sts_cd.value == "N") {
			comBkgCallPop0231();
		}
	}
	allTabEnable(true);
	document.form.loadFinish.value="Y";	
}

var tabs=new Array (
		new Array ("save_bkg_flag",		"t1frame",  "t1_",  ""), // ESM_BKG_0229_01
		new Array ("save_cust_flag",	"t2frame",  "t2_",  ""), // ESM_BKG_0229_02
		new Array ("save_cntr_flag",	"t3frame",  "t3_",  ""), // ESM_BKG_0229_03
		new Array ("save_mnd_flag",		"t4frame",  "t4_",  ""), // ESM_BKG_0229_04
		new Array ("save_cm_flag",		"t5frame",  "t5_",  ""), // ESM_BKG_0229_05
		new Array ("save_tro_flag",		"t6frame",  "t6_",  ""), // ESM_BKG_0229_06
		new Array ("save_rf_flag",		"t7frame",  "t7_",  ""), // ESM_BKG_0229_07
		new Array ("save_dg_flag",		"t8frame",  "t8_",  ""), // ESM_BKG_0229_08
		new Array ("save_ak_flag",		"t9frame",  "t9_",  ""), // ESM_BKG_0229_09
		new Array ("save_hbl_flag",		"t10frame", "t10_", ""), // ESM_BKG_0229_10
		new Array ("save_hbl2_flag",	"t11frame", "t11_", "") // ESM_BKG_0229_11
);

//handling of Sheet 
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case COMMAND02: // saving all tab
		if(saveFail == true) return;// in case of executing from booking close, return to prevent infinite loop
		var t1FormObj=window.frames["t1frame"].form;
		
		var t1DocObj=window.frames["t1frame"].document;
		//  all tab information is controlled as Array
		// name of the saving flag , name of frame ,  prefix of each tab, savestring
		
		checkAllTabLoad(t1FormObj, formObj);
		// saving tab information 
		var saveFlagBackupStr="Y";
		for (var i=1; i < tabs.length; i ++) {
			saveFlagBackupStr=saveFlagBackupStr + "|" + t1DocObj.getElementsByName(tabs[i][0])[0].value;
		}		
		// in case of saving as the number of all tab, getting validation , parameter 
		try {
			for (var i=0; i < tabs.length; i++) {
				// Booking Tab is included surely. in case of i = 0
				if (i == 0 || t1DocObj.getElementsByName(tabs[i][0])[0].value == "Y") {
					//  checking Validation at client 
					tabObjects[0].SetSelectedIndex(i);
					if (window.frames[tabs[i][1]].validateForUpload() == false) {
						saveSuccess=false;//don't reload 
						return false;
					}
					// in case of passing the validation, get the string to save
					tabs[i][3]=window.frames[tabs[i][1]].getSaveStringForUpload();
				}
			}
		} finally {
//			tabObjects[0].SetSelectedIndex(0);
			//  upload
		}
		
		// c/a reason pop-up
		t1FormObj.ca_rsn_cd.value=null;
		if(t1FormObj.bdr_flg.value == "Y") {
			//executing after calling setCaReasonCallBack()
			comBkgCallPop0708("setCAReasonCallBack", t1FormObj.bkg_no.value, "S");
			if(t1FormObj.ca_rsn_cd.value == null || t1FormObj.ca_rsn_cd.value == "null" || ComIsNull(t1FormObj.ca_rsn_cd.value)){
				saveSuccess=false;//don't reload 
				return false;
			}
		}	
		
		// Save Flag.
        // (1)  make status of the 'Save Flag'  Y to open Booking tab
		// (2) if GetSaveString is not existed, update to N
		for (var i=0; i < tabs.length; i ++) {
			t1DocObj.getElementsByName(tabs[i][0])[0].value=(tabs[i][3] == "")?"N":"Y";
		}
		// adding parameter , f_cmd to save: COMMAND02		
		t1FormObj.f_cmd.value=COMMAND02;
		var params=FormQueryString(t1FormObj);
		for (var i=0; i < tabs.length; i ++) {
			// getSaveStringForUpload-  SaveString
			if (tabs[i][3] != "") {
				//  to classify parameter of each tab, adding prefix to parameter
				params=params + "&" + ComSetPrifix(tabs[i][3], tabs[i][2]);
			}
		}
		// roll back to save flag
		var saveFlags=saveFlagBackupStr.split("|");
		for(var i=0; i < saveFlags.length; i++) {
			t1DocObj.getElementsByName(tabs[i][0])[0].value=saveFlags[i];
		}
		// in order to do not encoding over again, forwarding argument to false lastly
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229GS.do", params, false);
 		
		allTabEnable(false);
		var t1frame_form=window.frames["t1frame"].form;
		
		if(ComGetEtcData(sXml, "Toyota") == 'Y'){
			if(ComShowConfirm('Would you like to create Booking for Toyota B/L?')){
				t1frame_form.bkg_ty_flg.checked = 1;
			}else{
				t1frame_form.usr_toyota_check.value = "Y";
			}
			doActionIBSheet(sheetObj, formObj, COMMAND02);
		}else{
			
			if(ComGetEtcData(sXml, "psaValCode") != "Y" && ComGetEtcData(sXml, "psaValCode") != undefined){
				var errMsg01 = ComGetEtcData(sXml,"psaValCode");
				if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
			    	var rmsg=errMsg01.split("<||>");
			    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
			    		ComShowCodeMessage("BKG06125");
			    	}else if ( rmsg[1] != "BKG95025" ){
			    		ComShowMessage(rmsg[3]);
			    	}
				}
			}	
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
				saveFail=true;//fail: don't show bkg close mail 
				saveSuccess=false;//don't reload 
	 			sheetObj.LoadSaveData(sXml);// showing fail meassge
				//fail to c/a 
				if (t1frame_form.bdr_flg.value == "Y") {
	        		formObj.f_cmd.value=MULTI01;  //cancel CA  	 
	           		var sXml2=sheetObj.GetSaveData("ESM_BKG_0079GS.do", FormQueryString(formObj));
	        		allTabEnable(false);
	          		if (ComGetEtcData(sXml2, "TRANS_RESULT_KEY") != "S") {
	           			sheetObj.LoadSaveData(sXml2);
	          		}
				}
			} else {
				saveSuccess=true;
				if(t1frame_form.check_confirm.value == 'true'){
					t1frame_form.check_confirm.value = 'false';
					ComShowMessage("User should transmit the 301&310 EDI again MANUALLY.");
				}
				
				var rtnBkgNo=ComGetEtcData(sXml, "bkg_no"); 
				if(rtnBkgNo != undefined && rtnBkgNo.length>10) t1frame_form.bkg_no.value=ComGetEtcData(sXml, "bkg_no");
				if(ComGetEtcData(sXml, "closeBkgFlag") == "Y"){
					var firstVvd=ComGetEtcData(sXml, "first_vvd");
					if(ComShowCodeConfirm("BKG00312",firstVvd)){ //"though it is booking close status, saving"
						t1frame_form.close_bkg_flag.value="Y"; // booking close : don't handle validation
						doActionIBSheet(sheetObj, formObj, COMMAND02);// saving
	    				if(saveFail==false && ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
	    					//bkg close mail open
	    					//============================================================================================
	    					var subject=(t1frame_form.opus2.value != "Yes")?"BKG Creation Notice":"BKG Change Notice";
	    					var closeBkgMsg=ComGetEtcData(sXml, "closeBkgMsg");
	    					if(closeBkgMsg.indexOf("BKG No : <BR>")){
	    						closeBkgMsg="BKG No : " + t1frame_form.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
	    					}
							window.frames["t1frame"].sendBkgCloseMail(subject, closeBkgMsg);
							t1frame_form.close_bkg_flag.value="N";	
	    					//============================================================================================
	    				}
					} else { //in case of selecting "stopping because of booking closing "
						t1frame_form.close_bkg_flag.value="N";	
						saveSuccess=false;// -> don't reload 
						break;
					}
				} else if (ComGetEtcData(sXml, "cbfBkgFlag") == "Y") {
					if(ComShowCodeConfirm("BKG02069")){ //in case of selecting "though it is booking cbf status, saving"
						t1frame_form.cbf_bkg_flag.value="Y"; // booking cbf : don't handle validation
						doActionIBSheet(sheetObj, formObj, COMMAND02);// saving
	    				if(saveFail==false && ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
	    					//bkg close mail open
	    					//============================================================================================
	    					var subject=(t1frame_form.opus2.value != "Yes")?"BKG Creation Notice":"BKG Change Notice";
	    					var closeBkgMsg=ComGetEtcData(sXml, "closeBkgMsg");
	    					if(closeBkgMsg.indexOf("BKG No : <BR>")){
	    						closeBkgMsg="BKG No : " + t1frame_form.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
	    					}
							window.frames["t1frame"].sendBkgCloseMail(subject, closeBkgMsg);
							t1frame_form.cbf_bkg_flag.value="N";	
	    					//============================================================================================
	    				}
					} else { //in case of selecting "stopping because of booking closing "
						t1frame_form.cbf_bkg_flag.value="N";	
						saveSuccess=false;// -> don't reload
						break;
					}
				} else {
					// success to create pctl , showing the message
					ComShowCodeMessage("BKG00166");
					saveFail=false;
					saveSuccess=true; // -> reload 
					formObj.bkg_no.value=t1frame_form.bkg_no.value;
				}
			}	
		}
		
			
		break;
	case IBSEARCH_ASYNC01: // Pending
		var t1FormObj=window.frames["t1frame"].form;
		if (!window.frames["t1frame"].validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}
		if (t1FormObj.bkg_upld_sts_cd.value == "D") {
			ComShowMessage(msgs['BKG00471']);
			return false;
		}
		if (t1FormObj.bkg_upld_sts_cd.value == "R") {
			ComShowMessage(msgs['BKG00473']);
			return false;
		}
		sheetObj.RemoveAll();
		var Row=sheetObj.DataInsert(-1);
		sheetObj.SetRowStatus(Row,"U");
		sheetObj.SetCellValue(Row, "rqst_no",t1FormObj.rqst_no.value);
		sheetObj.SetCellValue(Row, "rqst_seq",t1FormObj.rqst_seq.value);
		sheetObj.SetCellValue(Row, "sender_id",t1FormObj.sender_id.value);
		t1FormObj.f_cmd.value=MODIFY01;
//		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", FormQueryString(t1FormObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_01GS.do", "f_cmd=" + MODIFY01 + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));
		if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
			ComBkgSaveCompleted();
			// doActionIBSheet(sheetObj, formObj, IBSEARCH);
			reloadPage();
		} else {
 			sheetObj.LoadSaveData(sXml);
		}
		break;
	case IBSEARCH_ASYNC02: // Reinstate
		var t1FormObj=window.frames["t1frame"].form;
		if (!window.frames["t1frame"].validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}
		if(!ComShowConfirm("Are you sure?")){
			return false;			
		}
		sheetObj.RemoveAll();
		var Row=sheetObj.DataInsert(-1);
		sheetObj.SetRowStatus(Row,"U");
		sheetObj.SetCellValue(Row, "rqst_no",t1FormObj.rqst_no.value);
		sheetObj.SetCellValue(Row, "rqst_seq",t1FormObj.rqst_seq.value);
		sheetObj.SetCellValue(Row, "sender_id",t1FormObj.sender_id.value);
		sheetObj.SetCellValue(Row, "bkg_cntc_pson_eml",t1FormObj.bkg_cntc_pson_eml.value);
		sheetObj.SetCellValue(Row, "bkg_no", t1FormObj.bkg_no.value);
		
		t1FormObj.f_cmd.value=MODIFY02;
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_01GS.do", "f_cmd=" + MODIFY02 + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));
		if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
//			ComBkgSaveCompleted();
			reloadPage();
		} else {
 			sheetObj.LoadSaveData(sXml);
		}
		break;
	case IBSEARCH_ASYNC03: // xml view
		var t1FormObj=window.frames["t1frame"].form;
		if (!window.frames["t1frame"].validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}
		sheetObj.SetCellValue(Row, "rqst_no",t1FormObj.rqst_no.value);
		sheetObj.SetCellValue(Row, "rqst_seq",t1FormObj.rqst_seq.value);
		sheetObj.SetCellValue(Row, "sender_id",t1FormObj.sender_id.value);
		
		var param="?sndr_id="+t1FormObj.sender_id.value+"&rqst_no="+t1FormObj.rqst_no.value+"&rqst_seq="+t1FormObj.rqst_seq.value;
 		ComOpenPopup("ESM_BKG_1802.do" + param, 825, 550, "", "1,0", true);
		break;
	case COMMAND03: //Cancel
		if(saveFail == true){
			return;
		}
		var t1FormObj=window.frames["t1frame"].form;
		if (!window.frames["t1frame"].validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}	
		var sXml = sheetObj.GetSaveData("ESM_BKG_0620GS.do", "f_cmd="+SEARCH01 + "&bkg_no="+formObj.bkg_no.value +"&type=E");
		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
			if(ComGetEtcData(sXml, "CNT") > 0){
				comBkgCallPop0620('setCallBack0620');
				saveFail = true;
				return false;
			}
		}
		break;
	}
}

function setMessage(msg){
	document.form.message.value = msg;
}

function setCallBack0620(msg){
	document.form.message.value = msg;
	cancelFuncion();
}

function cancelFuncion(){
	var formObj = document.form;
	var t1FormObj = window.frames["t1frame"].form;
	t1FormObj.f_cmd.value = COMMAND03;
	var sheetObj = sheetObjects[0];
	
	var sXml = sheetObj.GetSaveData("ESM_BKG_0229GS.do", FormQueryString(t1FormObj) + "&message=" + formObj.message.value);
	allTabEnable(false); 
	if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
		var firstVvd=ComGetEtcData(sXml, "first_vvd");
		if(ComShowCodeConfirm("BKG00312",firstVvd)){
			ComSetObjValue(t1FormObj.close_bkg_flag, "Y");
			doActionIBSheet(sheetObj, formObj, COMMAND03);
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        		var subject="BKG Change Notice";            		
				window.frames["t1frame"].sendBkgCloseMail(subject, ComGetEtcData(sXml, "closeBkgMsg"));
				ComSetObjValue(t1FormObj.close_bkg_flag, "N");	      					
			}
		} else {
			ComSetObjValue(t1FormObj.close_bkg_flag, "N");	
			saveFail == true;
			saveSuccess=false;	
		}
	} else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
		if(ComShowCodeConfirm("BKG02069")){
			ComSetObjValue(t1FormObj.cbf_bkg_flag, "Y");
			doActionIBSheet(sheetObj, formObj, COMMAND03);
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        		var subject="BKG Change Notice";            		
				window.frames["t1frame"].sendBkgCloseMail(subject, ComGetEtcData(sXml, "closeBkgMsg"));
				ComSetObjValue(t1FormObj.cbf_bkg_flag, "N");	      					
			}
		} else {
			ComSetObjValue(t1FormObj.cbf_bkg_flag, "N");	
			saveFail == true;
			saveSuccess=false;
		}
	} else if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
		ComBkgSaveCompleted();
	} else { //fail to cancel 
		ComShowMessage(ComResultMessage(sXml));
		saveFail == true;
		saveSuccess=false;
	}	
	
	uploadNextFunction();
}

function getRdData(){
	var rdData = [];
	var t1FormObj=window.frames["t1frame"].form;
	var formObj=document.form;
	var rdFile = null;
	if (t1FormObj.doc_tp_cd.value == "B")
		rdFile="ESM_BKG_0230B.mrd";
	else
		rdFile="ESM_BKG_0230S.mrd";
	
	var rdUrl = "apps/opus/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
	var rdParam="/rv " + "frm1_sender_id[" + formObj.sender_id.value + "]" + " frm1_rqst_no[" + formObj.rqst_no.value + "]" + " frm1_rqst_seq[" + formObj.rqst_seq.value + "]" + " frm1_bkg_no[" + formObj.bkg_no.value + "]";
	rdData.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile, 'width' : 800, 'height' : 600});
	return rdData;
}

function setBtnEnableSts(name, enableSts) {
	if (enableSts == true) {
		ComBtnEnable(name);
	}
	else {
		ComBtnDisable(name);
	}
}
function setBtnColor(name, color) {
	changeObjectColor("Y", "Y", name, color, "btn1");
}
function hideLoadingImg() {
	document.getElementById('loadingBar').style.display="none";
	document.getElementById('divBody').style.display="";
}
/**
 * CA Reason  : CaReasonModify
 */ 
function setCAReasonCallBack(arrPopupData) {
	var formObj=document.form;
	var t1FormObj=window.frames["t1frame"].form;
	//01. CA ReasonCd, Remark 
	var strRsnCd=nullToBlank(arrPopupData[0][2]);
	var strRemark=nullToBlank(arrPopupData[0][3]);
	//02. modifyCaReason(e) call
	t1FormObj.ca_rsn_cd.value=strRsnCd;
	t1FormObj.bkg_corr_rmk.value=strRemark;
	
	var t1DocObj = window.frames["t1frame"].document;
	 // (1)  make status of the 'Save Flag'  Y to open Booking tab
	// (2) if GetSaveString is not existed, update to N
	for (var i=0; i < tabs.length; i ++) {
		t1DocObj.getElementsByName(tabs[i][0])[0].value=(tabs[i][3] == "")?"N":"Y";
	}
	
	t1FormObj.f_cmd.value = COMMAND02;
	var params = FormQueryString(t1FormObj);
	
	for (var i=0; i < tabs.length; i ++) {
		// getSaveStringForUpload-  SaveString
		if (tabs[i][3] != "") {
			//  to classify parameter of each tab, adding prefix to parameter
			params=params + "&" + ComSetPrifix(tabs[i][3], tabs[i][2]);
		}
	}
	
	var saveFlagBackupStr="Y";
	for (var i=1; i < tabs.length; i ++) {
		saveFlagBackupStr=saveFlagBackupStr + "|" + t1DocObj.getElementsByName(tabs[i][0])[0].value;
	}	
	
	var saveFlags = saveFlagBackupStr.split("|");
	for(var i=0; i < saveFlags.length; i++) {
		t1DocObj.getElementsByName(tabs[i][0])[0].value=saveFlags[i];
	}
	
	// in order to do not encoding over again, forwarding argument to false lastly
	var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0229GS.do", params, false);
	allTabEnable(false);
	if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
		saveFail = true;//fail: don't show bkg close mail 
		saveSuccess = false;//don't reload 
		sheetObjects[0].LoadSaveData(sXml);// showing fail meassge
		if (t1FormObj.bdr_flg.value == "Y") {
    		formObj.f_cmd.value = MULTI01;  //cancel CA  	 
       		var sXml2 = sheetObjects[0].GetSaveData("ESM_BKG_0079GS.do", FormQueryString(formObj));
    		allTabEnable(false);
      		if (ComGetEtcData(sXml2, "TRANS_RESULT_KEY") != "S") {
      			sheetObjects[0].LoadSaveData(sXml2);
      		}
		}
	} else {
		if(ComGetEtcData(sXml, "psaValCode") != "Y" && ComGetEtcData(sXml, "psaValCode") != undefined){
			var errMsg01 = ComGetEtcData(sXml,"psaValCode");
			if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
		    	var rmsg= errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}
			}
		}	
		ComShowCodeMessage("BKG00166");
		reloadPage();	
	}
	
}

function comBkgCallPop0902() {
	var formObj=window.frames["t1frame"].form;
	var cntc_eml = "";
	if(formObj.doc_tp_cd.value == "S"){
		cntc_eml = formObj.si_cntc_eml2.value;
	}else{
		cntc_eml = formObj.cntc_eml2.value;
	}
	var param="?xter_bkg_rqst_sts_cd=" + formObj.xter_bkg_rqst_sts_cd.value + "&doc_tp_cd=" + formObj.doc_tp_cd.value + "&bkg_no="+formObj.bkg_no.value + "&rqst_no=" + encodeURIComponent(formObj.rqst_no.value) + "&rqst_seq=" + formObj.rqst_seq.value + "&sender_id=" + formObj.sender_id.value + "&cntc_eml=" + cntc_eml
	+ "&bl_prf_shpr_flg=" + formObj.bl_prf_shpr_flg.value;
	
	ComOpenWindowCenter("/opuscntr/ESM_BKG_0902.do" + param, "PopupEsmBkg0902", 500, 500, true);
}
function comBkgCallPop0231() {
 	ComOpenPopup("ESM_BKG_0231.do", 500, 470,"callBack0231", "0,1,1,1,1", true);
}
/**
* e-Booking & SI Process - Copy Option <br>
* <br>
* <b>Example :</b>
* 
* <pre>
* callBack0231(copyTabStr);
* </pre>
* 
* @param Popup
* @return 
* * @author 
* @version 2010.01.27
*/
function callBack0231(copyTabStr) {
	var formObj=document.form;
	/*if(isFirstOnLoad!="false"){	
		// copying data after loading each tab 
		if(copyTabStr[0]=="COPY") ComSetObjValue(formObj.tabload2,  "COPY");
		if(copyTabStr[1]=="COPY") ComSetObjValue(formObj.tabload3,  "COPY");
		if(copyTabStr[2]=="COPY") ComSetObjValue(formObj.tabload4,  "COPY");
		if(copyTabStr[3]=="COPY") ComSetObjValue(formObj.tabload5,  "COPY");
		if(copyTabStr[4]=="COPY") ComSetObjValue(formObj.tabload6,  "COPY");
		if(copyTabStr[5]=="COPY") ComSetObjValue(formObj.tabload7,  "COPY");
		if(copyTabStr[6]=="COPY") ComSetObjValue(formObj.tabload8,  "COPY");
		if(copyTabStr[7]=="COPY") ComSetObjValue(formObj.tabload9,  "COPY");
		if(copyTabStr[8]=="COPY") ComSetObjValue(formObj.tabload10, "COPY");
		if(copyTabStr[9]=="COPY") ComSetObjValue(formObj.tabload11, "COPY");
	} else {*/
		// copying the selected tab, after loading
		if(copyTabStr[0]=="COPY") window.frames["t2frame"].dataCopy();
		if(copyTabStr[1]=="COPY") window.frames["t3frame"].dataCopy();
		if(copyTabStr[2]=="COPY") window.frames["t4frame"].dataCopy();
		if(copyTabStr[3]=="COPY") window.frames["t5frame"].dataCopy();
		if(copyTabStr[4]=="COPY") window.frames["t6frame"].dataCopy();
		if(copyTabStr[5]=="COPY") window.frames["t7frame"].dataCopy();
		if(copyTabStr[6]=="COPY") window.frames["t8frame"].dataCopy();
		if(copyTabStr[7]=="COPY") window.frames["t9frame"].dataCopy();
//		if("1"==ComGetObjValue(window.frames["t1frame"].form.usa_cstms_file_cd) ||
//		   "1"==ComGetObjValue(window.frames["t1frame"].form.cnd_cstms_file_cd) ){
			if(copyTabStr[8]=="COPY") window.frames["t10frame"].dataCopy();
//		}
		if(copyTabStr[9]=="COPY") window.frames["t11frame"].dataCopy();
	//}
}

function allTabEnable(reload){
	var t1frame_form=window.frames["t1frame"].form;
	var formObj=document.form;
	var param=formObj.param_data.value;
	// each tab load
	if (t1frame_form.save_cust_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t2frame.src="ESM_BKG_0229_02.do" + param;
		tabObjects[0].SetTabDisable(1, false);
	} else {
		if(reload) document.all.t2frame.src="";
		tabObjects[0].SetTabDisable(1, true);
	}
	if (t1frame_form.save_cntr_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t3frame.src="ESM_BKG_0229_03.do" + param;
		tabObjects[0].SetTabDisable(1, false);
	} else {
		if(reload) document.all.t3frame.src="";
		tabObjects[0].SetTabDisable(2, true);
	}
	if (t1frame_form.save_mnd_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t4frame.src="ESM_BKG_0229_04.do" + param;
		tabObjects[0].SetTabDisable(3, false);
	} else {
		if(reload) document.all.t4frame.src="";
		tabObjects[0].SetTabDisable(3, true);
	}
	if (t1frame_form.save_cm_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t5frame.src="ESM_BKG_0229_05.do" + param;
		tabObjects[0].SetTabDisable(4, false);
	} else {
		if(reload) document.all.t5frame.src="";
		tabObjects[0].SetTabDisable(4, true);
	}
	if (t1frame_form.save_tro_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t6frame.src="ESM_BKG_0229_06.do" + param;
		tabObjects[0].SetTabDisable(5, false);
	} else {
		if(reload) document.all.t6frame.src="";
		tabObjects[0].SetTabDisable(5, true);
	}
	if (t1frame_form.save_rf_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t7frame.src="ESM_BKG_0229_07.do" + param;
		tabObjects[0].SetTabDisable(6, false);
	} else {
		if(reload) document.all.t7frame.src="";
		tabObjects[0].SetTabDisable(6, true);
	}
	if (t1frame_form.save_dg_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t8frame.src="ESM_BKG_0229_08.do" + param;
		tabObjects[0].SetTabDisable(7, false);
	} else {
		if(reload) document.all.t8frame.src="";
		tabObjects[0].SetTabDisable(7, true);
	}
	if (t1frame_form.save_ak_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t9frame.src="ESM_BKG_0229_09.do" + param;
		tabObjects[0].SetTabDisable(8, false);
	} else {
		if(reload) document.all.t9frame.src="";
		tabObjects[0].SetTabDisable(8, true);
	}
	if (t1frame_form.save_hbl_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t10frame.src="ESM_BKG_0229_10.do" + param;
		tabObjects[0].SetTabDisable(9, false);
	} else {
		if(reload) document.all.t10frame.src="";
		tabObjects[0].SetTabDisable(9, true);
	}
	if (t1frame_form.save_hbl2_flag.value == "Y") {
		tabDataSearchStart++;
		if(reload) document.all.t11frame.src="ESM_BKG_0229_11.do" + param;
		tabObjects[0].SetTabDisable(10, false);
	} else {
		if(reload) document.all.t11frame.src="";
		tabObjects[0].SetTabDisable(10, true);
	}
	tabObjects[0].SetSelectedIndex(0);
}
//checking the tab which should be saved finish loading
function checkAllTabLoad(t1FormObj, formObj){
	if(t1FormObj.save_cust_flag.value =="Y" && formObj.tabload2.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[1]);
		return false;
	}
	if(t1FormObj.save_cntr_flag.value =="Y" && formObj.tabload3.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[2]);
		return false;
	}
	if(t1FormObj.save_mnd_flag.value  =="Y" && formObj.tabload4.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[3]);
		return false;
	}
	if(t1FormObj.save_cm_flag.value   =="Y" && formObj.tabload5.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[4]);
		return false;
	}
	if(t1FormObj.save_tro_flag.value  =="Y" && formObj.tabload6.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[5]);
		return false;
	}
	if(t1FormObj.save_rf_flag.value   =="Y" && formObj.tabload7.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[6]);
		return false;
	}
	if(t1FormObj.save_dg_flag.value   =="Y" && formObj.tabload8.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[7]);
		return false;
	}
	if(t1FormObj.save_ak_flag.value   =="Y" && formObj.tabload9.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[8]);
		return false;
	}
	if(t1FormObj.save_hbl_flag.value  =="Y" && formObj.tabload10.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[9]);
		return false;
	}
	if(t1FormObj.save_hbl2_flag.value =="Y" && formObj.tabload11.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[10]);
		return false;
	}
	return true;
}

function autoResize(id){
    var newheight = window.frames[id].window.getHeight ? window.frames[id].window.getHeight() : '700';
    document.getElementById(id).height= (newheight) + "px";
}

function subPageSearchEnd(pageNme){
	tabDataSearchEnd++;
//	console.log(tabDataSearchStart, tabDataSearchEnd, pageNme);
	if(tabDataSearchStart <= tabDataSearchEnd) ComOpenWait(false);
//	tabDataSearchStart++;
//	tabDataSearchObj[searchNum] = true;
//	for (var i = 0; i < tabDataSearchObj.length; i++) {
//		if(!tabDataSearchObj[i]) return ;
//	}
	
}

function uploadNextFunction(){
	var t1frame_form=window.frames["t1frame"].form;
	var sheetObject=sheetObjects[0];
	if(saveFail==false && saveSuccess==true){	
		if(t1frame_form.bkg_wt_chk_flg.checked && !t1frame_form.bkg_wt_chk_flg.disabled){
			var rtnData = sheetObject.GetSaveData("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+t1frame_form.bkg_no.value);
		}
		reloadPage();
	} else if(saveFail==true){// in case of finishing to 'save file'-> initializing
		saveFail=false; 
		saveSuccess=true;
		setBtnEnableSts("btn_opusupload", true);
	}
}
