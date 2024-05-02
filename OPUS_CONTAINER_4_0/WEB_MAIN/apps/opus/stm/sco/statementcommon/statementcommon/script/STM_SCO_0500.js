/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0500
*@FileTitle  : SAKURA Interface Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/12
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Receipts : business script for STM_SAR_0012
     */

 // common global variable
//    var gCurRow = 0;
//    var prefix = "sheet1_";
	var sheetObjects=new Array();
	var sheetCnt=0;	
	var comboObjects=new Array();
	var comboCnt=0;
    var selOfcCds="";

    
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					//date_condition();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_new":
					removeAll(formObj);
					break;
				case "btn_downexcel":
					if(sheetObjects[0].RowCount() < 1){//no data
               		 ComShowCodeMessage("COM132501");
					}else{
						if(sheetObj.RowCount() >= sheetObj.GetTotalRows() ) {
							sheetObjects[0].Down2Excel();
						} else {
							ComShowCodeMessage("SCO00017");  //To retrieve all data, please scroll down to the bottom and click down excel.
						}	
					}
	    	    	break;	
	    	    case "btn_cal_pst_dt_fm":
	    	    	var calName = formObj.pst_dt_fm;
	    	    	getCalDate(calName);
	    	    	break;
	    	    case "btn_cal_pst_dt_to":
	    	    	var calName = formObj.pst_dt_to;
	    	    	getCalDate(calName);
	    	    	break;
	    	    case "btn_cal_if_dt_fm":
	    	    	var calName = formObj.if_dt_fm;
	    	    	getCalDate(calName);
	    	    	break;
	    	    case "btn_cal_if_dt_to":
	    	    	var calName = formObj.if_dt_to;
	    	    	getCalDate(calName);
	    	    	break;
//				case "btns_cal_pst_dt_fm":
//					var cal=new ComCalendar();
//					cal.setDisplayType('date');
//	             	cal.select(formObj.pst_dt_fm, 'yyyy-MM-dd');
//					break;	
//				case "btns_cal_pst_dt_to":
//					var cal=new ComCalendar();
//					cal.setDisplayType('date');
//	             	cal.select(formObj.pst_dt_to, 'yyyy-MM-dd');
//					break; 
//				case "btns_cal_if_dt_fm":
//					var cal=new ComCalendar();
//					cal.setDisplayType('date');
//	             	cal.select(formObj.if_dt_fm, 'yyyy-MM-dd');
//					break;	
//				case "btns_cal_if_dt_to":
//					var cal=new ComCalendar();
//					cal.setDisplayType('date');
//	             	cal.select(formObj.if_dt_to, 'yyyy-MM-dd');
//					break; 
			}		// end switch			
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
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
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}	
//		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
		if_doc_tp_cd.SetSelectText("All");
		document.form.pst_dt_fm.focus();
		/*
		selOfcCds = "?selOfcCds=" + ComReplaceStr(document.form.rct_ofc_cd.value, "'", "");
		if(document.form.call_yn.value == "Y"){
			if(document.form.req_rct_dt.value != ""){ 
				var reqDate = document.form.req_rct_dt.value; 
				document.form.pst_dt_fm.value = ComGetDateAdd(reqDate, "d", -15);
				document.form.pst_dt_to.value = ComGetDateAdd(reqDate, "d", 15);
			} 
			date_condition();
			//sheetObjects[0].RenderSheet(0);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  
			//sheetObjects[0].RenderSheet(1);  
		}
		*/
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					var HeadTitle1="|Doc Type|Doc Date|Posting Date|Reference Doc No.|Currency|Posting Key|Tax Code|Local Amount|Doc Amount|Assignment No.|G/L Account No.|Customer No.|Rec Type|I/F Flag|I/F File ID|I/F Date|ERP I/F \nError Flag|ERP I/F Error Reason";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"if_doc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"doc_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pst_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"ref_doc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pst_key_cd",         	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vat_tax_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"locl_amt",         	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"doc_amt",    	     	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"asgn_no",         	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"gl_acct_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cust_no",        		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rec_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"if_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"if_file_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"if_dt",            	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"erp_if_err_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:560,  Align:"left",    ColMerge:0,   SaveName:"erp_if_err_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			               ];
			        InitColumns(cols);
			        SetEditable(1);
			        SetColProperty("doc_dt", {Format:"Ymd"} );
			        SetColProperty("pst_dt", {Format:"Ymd"} );
			        SetColProperty("if_dt", {Format:"Ymd"} );
			        //SetSheetHeight(360);
			        SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			        resizeSheet();
				}
			    break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {				
			case IBSEARCH: // RETRIEVE 
				if (!validateForm(sheetObj,formObj,sAction)) {		 				
					return false;
				}		
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				iPageNo = 1;
				setTimeout( function () {  
					formObj.f_cmd.value=SEARCH;
	 				var sXml=sheetObj.GetSearchData("STM_SCO_0500GS.do", FormQueryString(formObj)+"&i_page="+iPageNo);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					ComOpenWait(false); 
			    } , 100);		
				break;	
				
			case IBSEARCHAPPEND: // paging after 2nd page
				if (!validateForm(sheetObj,formObj,sAction)) {		 				
					return false;
				}	
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				
				setTimeout( function () {  
					formObj.f_cmd.value=SEARCH;
	 				var sXml=sheetObj.GetSearchData("STM_SCO_0500GS.do", FormQueryString(formObj)+"&i_page="+PageNo, {Append:true});
					sheetObj.LoadSearchData(sXml,{Sync:0,Append:1} );
					ComOpenWait(false); 
			    } , 100);			
				break;
		}
	}
	
	/* for paging */
	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) { 
	    	return;
	    } else {
	    	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	    }
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {				
		sheetObj.ShowDebugMsg(false);			
				
				if(ComIsEmpty(formObj.pst_dt_fm) && ComIsEmpty(formObj.if_dt_fm)){	
					ComShowCodeMessage("COM130403", "Date");
					ComSetFocus(formObj.pst_dt_fm);
					return false;
				}	
				if(!ComIsEmpty(formObj.pst_dt_fm) && ComIsEmpty(formObj.pst_dt_to)){	
					ComShowCodeMessage("COM130403", "Posting Date 'TO'");
					ComSetFocus(formObj.pst_dt_fm);
					return false;
				}	
				if(ComIsEmpty(formObj.pst_dt_fm) && !ComIsEmpty(formObj.pst_dt_to)){	
					ComShowCodeMessage("COM130403", "Posting Date 'FROM'");
					ComSetFocus(formObj.pst_dt_fm);
					return false;
				}	
				if(!ComIsEmpty(formObj.if_dt_fm) && ComIsEmpty(formObj.if_dt_to)){	
					ComShowCodeMessage("COM130403", "I/F Date 'TO'");
					ComSetFocus(formObj.if_dt_to);
					return false;
				}	
				if(ComIsEmpty(formObj.if_dt_fm) && !ComIsEmpty(formObj.if_dt_to)){	
					ComShowCodeMessage("COM130403", "I/F Date 'FROM'");
					ComSetFocus(formObj.if_dt_to);
					return false;
				}	
				
				if(!ComIsEmpty(formObj.pst_dt_fm) && !ComIsEmpty(formObj.pst_dt_to)){	
					if(!validatePstIfDate(formObj.pst_dt_fm.value, formObj.pst_dt_to.value, formObj.if_doc_tp_cd.value)){
						return false;
					}
				}
				if(!ComIsEmpty(formObj.if_dt_fm) && !ComIsEmpty(formObj.if_dt_to)){
					if(!validatePstIfDate(formObj.if_dt_fm.value, formObj.if_dt_to.value, formObj.if_doc_tp_cd.value)){
						return false;	
					}
				}

		return true;			
	}				
					

	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var formObj=document.form;
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
//		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('deactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('blur', 'obj_blur', formObj);
//		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}

	/** 
	 * init combo<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return none
	 * @see #
	 * @author yhha
	 * @version 2014 04 29 
	 */
		function initCombo(comboObj, comboNo) {
			switch (comboObj.options.id) {
				case "if_doc_tp_cd":
					with (comboObj) {
						InsertItem(0, "All", "");
						InsertItem(1, "H1|Invoice (Non-JP)", "H1");
						InsertItem(2, "U1|Invoice (JP)", "U1");
						InsertItem(3, "H2|Receipt (Non-JP)", "H2");
						InsertItem(4, "U2|Receipt (JP)", "U2");
						InsertItem(5, "H3|Adjustment (Non-JP)", "H3");
						InsertItem(6, "U3|Adjustment (JP)", "U3");
						InsertItem(7, "H4|Offset (Non-JP)", "H4");
						InsertItem(8, "U4|Offset (JP)", "U4");
						InsertItem(9, "H5|Standard - Expense slip (Non-JP)", "H5");
						InsertItem(10, "U5|Standard - Expense slip (JP)", "U5");
						InsertItem(11, "H6|Prepayment - Advanced payments (Non-JP)", "H6");
						InsertItem(12, "U6|Prepayment - Advanced payments (JP)", "U6");
						InsertItem(13, "H7|Credit - Credit note (Non-JP)", "H7");
						InsertItem(14, "U7|Credit note (JP) ", "U7");
			    		SetMultiSelect(0);
//no support[check again]CLT 			    		UseCode=true;
			    		//LineColor = "#ffffff";
			    		SetColAlign(0, "left");
			    		SetMultiSeparator(",");
			    		SetDropHeight(190);
					}
				break;
			}
		}	
    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
		var formObj=document.form;
		switch (ComGetEvent("name")) {
			case "pst_dt_fm":
				var condPstDtFm=ComReplaceStr(ComGetEvent("value"),"-","");
				if (condPstDtFm.length == 8) {
					formObj.pst_dt_to.focus();
				}
	 		break;
			case "pst_dt_to":
				var condPstDtTo=ComReplaceStr(ComGetEvent("value"),"-","");
				if (condPstDtTo.length == 8) {
					formObj.if_dt_fm.focus();
				}
	 		break;
			case "if_dt_fm":
				var condIfDtFm=ComReplaceStr(ComGetEvent("value"),"-","");
				if (condIfDtFm.length == 8) {
					formObj.if_dt_to.focus();
				}
	 		break;
			case "if_dt_to":
				var condIfDtTo=ComReplaceStr(ComGetEvent("value"),"-","");
				if (condIfDtTo.length == 8) {
					formObj.asgn_no.focus();
				}
	 		break;	 		
		}
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
       	switch(ComGetEvent("name")){ 	    	
       		case "pst_dt_fm":
       			ComClearSeparator(ComGetEvent());
       			break;
       		case "pst_dt_to":
       			ComClearSeparator(ComGetEvent());
       			break; 
       		case "if_dt_fm":
       			ComClearSeparator(ComGetEvent());
       			break;
       		case "if_dt_to":
       			ComClearSeparator(ComGetEvent());
       			break;
       	}
//       	event.srcElement.select();
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
	
    function obj_blur(){
    	var obj=ComGetEvent();
	    var formObj=document.form;
		switch(ComGetEvent("name")){
			case "pst_dt_fm":
				ComAddSeparator(formObj.pst_dt_fm, "ymd");
				break;
			case "pst_dt_to":
				ComAddSeparator(formObj.pst_dt_to, "ymd");
				break;
			case "if_dt_fm":
				ComAddSeparator(formObj.if_dt_fm, "ymd");
				break;
			case "if_dt_to":
				ComAddSeparator(formObj.if_dt_to, "ymd");
				break;
			default:
			break;
		}    
    }
    
	function obj_deactivate(){
		var obj=ComGetEvent();
	    var formObj=document.form;
		switch(ComGetEvent("name")){
			case "pst_dt_fm":
				ComAddSeparator(formObj.pst_dt_fm, "ymd");
				ComChkObjValid(ComGetEvent());
				break;
			case "pst_dt_to":
				ComAddSeparator(formObj.pst_dt_to, "ymd");
				ComChkObjValid(ComGetEvent());
				break;
			case "if_dt_fm":
				ComAddSeparator(formObj.if_dt_fm, "ymd");
				ComChkObjValid(formobj.if_dt_fm);
				break;
			case "if_dt_to":
				ComAddSeparator(formObj.if_dt_to, "ymd");
				ComChkObjValid(formobj.if_dt_fm);
				break;
			default:
	          //  ComChkObjValid(ComGetEvent());
			break;
		}
	}
/*	function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_cnt_cd":
				if (formObj.rct_cust_cnt_cd.value == '') {
					formObj.rct_cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
				break;
				
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else {
					formObj.cust_nm.value = "";
				}
				break;
		}
	}	*/

		/** 
		 * Initialize screen.<br>
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  {object} formObj  
		 * @return none.
		 */
		function removeAll(formObj) {
			var sheetObject1=sheetObjects[0];
			var formObj=document.form;
			formObj.reset();
			sheetObject1.RemoveAll();
			comboObjects[0].RemoveAll();
			for(var k=0;k<comboObjects.length;k++){
				initCombo(comboObjects[k],k+1);
			}	
			doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC01);
			formObj.pst_dt_fm.focus();
			if_doc_tp_cd.SetSelectText("All");
		}

		function resizeSheet(){
			ComResizeSheet(sheetObjects[0]);
		}
		
		
		function getCalDate(calName){
			var cal=new ComCalendar();
			cal.setDisplayType('date');
			var calName = calName;
			cal.select(calName, 'yyyy-MM-dd');
		}
		
		
		
		//validate Posting Date and I/F Date
		
		function validatePstIfDate(fromDate, toDate, ifDocTpCd){
	         var nextDate="";
	         var fromDate = fromDate;
	         var toDate = toDate;
	         var ifDocToCd = ifDocTpCd;
	         
			 // doc_tp_cd is 'ALL' then retrieve 10 days data
	         if (ifDocTpCd == '') {
	             nextDate=ComGetDateAdd(fromDate, "D", 10);
	         }
	         //else 1 month
	         else {
	             nextDate=ComGetDateAdd(fromDate, "M", 1);
	         }
	         if (toDate >= nextDate) {
	             ComShowCodeMessage("SCO00016");  //'When you choose Doc Type, you can retrieve 1 month data. Otherwise, you can retrieved 10 days data.'
	             document.form.pst_dt_fm.focus();
	             return false;
	         }
	         return true;
		}
