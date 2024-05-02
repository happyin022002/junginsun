/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2032.js
*@FileTitle  : Leased M.G.Set Charge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_2032 : ees_cgm_2032 business script for
     */
	function ees_cgm_2032() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version
     */ 
	function processButtonClick(){
		/***** use additional sheet var in case of more than 2 tap each sheet *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
	    /*******************************************************/
	    var formObject=document.form;
	    try {
	    	var srcName=ComGetEvent("name");
	    	if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	        	case "btn_Retrieve":
	        		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
	        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	        		}
					break;
				case "btn_New":
					initControl();
					break;
				case "btn_ChargeCreation":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_InvoiceImportAudit":
					var iCheckRow=sheetObject1.CheckedRows("del_chk");
					var sChgSeq=formObject.chg_cre_seq.value;
					// check box selecting check
					if(iCheckRow > 0){
						// Charge Creation check
						if(sChgSeq != ''){
							var param="?cost_yrmon=" + formObject.cost_yrmon.value;
							param=param + "&vndr_seq=" + formObject.vndr_seq.value;
							param=param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							// Modal Popup call
							var sWinName="Invoice Import & Audit";
							ComOpenWindowCenter('/opuscntr/EES_CGM_2085.do' + param, sWinName, 1100, 550, true);
							// Retrieve 
							//var obj = document.getElementById("btn_Retrieve");
					    	//obj.fireEvent("onclick");
//					    	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
		    			ComShowCodeMessage('CGM10008');
					}
					break;
				case "btn_AuditResultCreation":
					var iCheckRow=sheetObject1.CheckedRows("del_chk");
					var sChgSeq=formObject.chg_cre_seq.value;
					// check box selecting check
					if(iCheckRow > 0){
						// Charge Creation check
						if(sChgSeq != ''){
							var param="?cost_yrmon=" + formObject.cost_yrmon.value;
							param=param + "&vndr_seq=" + formObject.vndr_seq.value;
							param=param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							param=param + "&lse_chg_sts_cd=" + formObject.lse_chg_sts_cd.value;
							// Modal Popup call
							var sWinName="Payable Charge Audit Result & Payable Amount Confirm";
							ComOpenWindowCenter('EES_CGM_2098.do' + param, sWinName, 1100, 640, true);
//							ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 480, "ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
//							ComOpenPopupWithTarget('/opuscntr/EES_CGM_2098.do' + param, 980, 600 , sWinName, true);
							// Retrieve 
							//var obj = document.getElementById("btn_Retrieve");
					    	//obj.fireEvent("onclick");
//							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
		    			ComShowCodeMessage('CGM10008');
					}
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
				case "btns_cost_yrmon":
					var cal=new ComCalendar();
			        cal.setDisplayType('month');
			        cal.select(formObject.cost_yrmon, "yyyy-MM");
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
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items <br>
	 * @param  {object} sheetObj	
	 * @return 
	 * @author 
	 * @version
	 */
	function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet <br>
	 * implementing onLoad event handler in body tag <br>
	 * adding first-served functions after loading screen. <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version 
	 */
	function loadPage() {
		// axon event regist
	//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    //    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	    for(i=0;i<sheetObjects.length;i++){
	    	//
	    	ComConfigSheet (sheetObjects[i] );
	    	initSheet(sheetObjects[i],i+1);
	    	//
	    	ComEndConfigSheet(sheetObjects[i]);
	    	initControl();
	    }
	}
    function firstDayInPreviousMonth(yourDate) {
	        var d=new Date(yourDate);
	        d.setDate(1);
	        d.setMonth(d.getMonth() - 1);
	        return d;
    }
	function initControl(){
    	var d=firstDayInPreviousMonth(new Date()); //firstDayInPreviousMonth(new Date());
    	var y=d.getFullYear(); 
    	var m="";
    	var mtmp=d.getMonth()+1;
		if(mtmp<10)	m='0'+mtmp; 
		else m=''+ mtmp;
		var costYrmon=y+ '-' + m;
    	// COST YMO
    	document.form.cost_yrmon.value=costYrmon;
    	// Sheet Object reset
    	for(var i=0; i < sheetObjects.length; i++){
    		sheetObjects[i].RemoveAll();
    	}
    	// Import & Audit button disable
    	ComBtnDisable("btn_InvoiceImportAudit");
    	// Audit Result & P.Amt Confirm disable
    	ComBtnDisable("btn_AuditResultCreation");
    	// Delete button disable
    	ComBtnDisable("btn_Delete");
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {int} sheetNo
	 * @return 
	 * @author 
	 * @version 
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    switch(sheetNo) {
	        case 1:      // sheet1 init
	            with (sheetObj) {
		            var HeadTitle="||AGMT No.|From|To|Term|Lessor|Lessor Name|Status||||";
		            var headCount=ComCountHeadTitle(HeadTitle);
	
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                   {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"lse_chg_sts_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lse_chg_sts_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chg_cre_seq" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
		                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" } ];
		             
		            InitColumns(cols);
	
		            SetEditable(1);
		            SetEditableColorDiff(0);
                    SetColProperty(0,"agmt_eff_dt", {Format:"####-##-##"} );
		            SetColProperty(0,"agmt_exp_dt", {Format:"####-##-##"} );
		            SetSheetHeight(230);
				}
	        	break;
			case 2:      // sheet2 init
	        	with (sheetObj) {
			        
			        var HeadTitle="|STS|OWN|Invoice|Payable Amount|Debit Amount|Credit Amount|Tax|Created Office|User ID|Created Date";
			        var HeadTitle2="|STS|Amount|Request Total|Payable Amount|Debit Amount|Credit Amount|Tax|Created Office|User ID|Created Date";
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lse_chg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"lse_chg_smry_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_smry_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pay_lse_chg_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"debit_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cr_smry_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tax_smry_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			               {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
//			        SetSheetHeight(250);
			        resizeSheet();
				}
	            break;
	    }
	}

    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    }
	/**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return 
     * @author 
     * @version
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	    	case IBSEARCH:      //retrieve (Retrieve button click)
		    	formObj.f_cmd.value=SEARCH;
	     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	     		formObj.chg_cre_seq.value='';
	     		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);	 		     		
		 		var sXml=sheetObj.GetSearchData("EES_CGM_2032GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1"), '', true);
	     		sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
	     		sheetObjects[1].RemoveAll();
		 		ComOpenWait(false);	 	
	            break;
	    	case IBSEARCH_ASYNC01:      //retrieve 
		    	formObj.f_cmd.value=SEARCH;
	     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	     		var sXml=sheetObj.GetSearchData("EES_CGM_2032GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1"), '', true);
	     		sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
	     		sheetObjects[1].RemoveAll();
	     		// sheet1 click event
	 			var Col=sheetObjects[0].SaveNameCol("del_chk");
	 			var Row;
	 			for(var i=1; i <= sheetObjects[0].RowCount(); i++){
	 				if(sheetObjects[0].GetCellValue(i,"del_chk") == 1){
	 					Row=i;
	 					sheetObjects[0].SetCellValue(i,"del_chk",0);
	 					sheet1_OnClick(sheetObjects[0], Row, Col);
	 					break;
	 				}
	 			}
	            break;
	    	case IBSAVE:        // saving (Charge Creation)
	    		var iCheckRow=sheetObj.CheckedRows("del_chk");
	    		if(iCheckRow > 0){
	    			var sCheckRows=sheetObj.FindCheckedRow("del_chk");
	    			var arrCheckRows=sCheckRows.split("|");
	    			// Charge Creation check 
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd=sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != '' && lseChgStsCd != 'H'){
	    					ComShowCodeMessage('CGM20015', sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_desc"));
	    					return;
	    				}
	    			}
			 		sheetObj.SetWaitImageVisible(0);
			 		ComOpenWait(true);		    			
			 		formObj.f_cmd.value=MULTI;
	     			formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	     		 	var sParam=sheetObjects[0].GetSaveString();
		         	sParam=ComSetPrifix(sParam, "sheet1");
		         	sParam=sParam + "&";
		         	sParam=sParam + FormQueryString(formObj);
		         	var prefix=new Array("sheet1", "sheet2");	
		         	var sXml=sheetObj.GetSaveData("EES_CGM_2032GS.do", sParam + "&" + ComGetPrefixParam(prefix));
	     			var arrXml=sXml.split("|$$|");
	     			sheetObjects[0].LoadSaveData(arrXml[0]);
	     			sheetObjects[1].RemoveAll();
	     			ComOpenWait(false);	 	
	     			//sheetObjects[1].LoadSearchXml(arrXml[1]);
	     			var Col=sheetObjects[0].SaveNameCol("del_chk");
	     			var Row;
	     			for(var i=1; i <= sheetObjects[0].RowCount(); i++){
	     				if(sheetObjects[0].GetCellValue(i,"del_chk") == 1){
	     					Row=i;
	     					sheetObjects[0].SetCellValue(i,"del_chk",0);
	     					sheet1_OnClick(sheetObjects[0], Row, Col);
	     					break;
	     				}
	     			}
	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
	            break;
	    	case IBDELETE:      // deleting
	    		var iCheckRow=sheetObj.CheckedRows("del_chk");
	    		var chgCreSeq=document.form.chg_cre_seq.value;
		    	if(iCheckRow > 0){
		    		if(chgCreSeq != ''){
		    			var sCheckRows=sheetObj.FindCheckedRow("del_chk");
		    			var arrCheckRows=sCheckRows.split("|");
		    			// Charge Creation check 
		    			for(var i=0; i<arrCheckRows.length-1; i++){
		    				var lseChgStsCd=sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
		    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A' && lseChgStsCd != 'S'){
		    					ComShowCodeMessage('CGM20015', sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_desc"));
		    					return;
		    				}
		    			}
				 		sheetObj.SetWaitImageVisible(0);
				 		ComOpenWait(true);	
		    			formObj.f_cmd.value=REMOVE;
			    		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
			     		var sParam=sheetObjects[0].GetSaveString();
			         	sParam=ComSetPrifix(sParam, "sheet1");
			         	sParam=sParam + "&";
			         	sParam=sParam + FormQueryString(formObj);
			         	var sXml=sheetObjects[1].GetSaveData("EES_CGM_2032GS.do", sParam + "&" + ComGetPrefixParam("sheet1"));
			     		sheetObjects[1].RemoveAll();
			     		sheetObjects[0].LoadSaveData(sXml);
				 		ComOpenWait(false);	
			     		// Import & Audit button disable
			        	ComBtnDisable("btn_InvoiceImportAudit");
			        	// Audit Result & P.Amt Confirm disable
			        	ComBtnDisable("btn_AuditResultCreation");
			        	// Audit Result & P.Amt Confirm disable
			        	ComBtnDisable("btn_Delete");
		    		}
		    	} else {
		    		ComShowCodeMessage('CGM10008');
	    		}
	            break;
	    }
	}
	/**
     * handling process for input validation <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type 
     * @return {boolean}			false => validation check error, true => validation check succes
     * @author 
     * @version
     */  
	function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
	    	switch(sAction){
	    		case IBSEARCH:
	    			if(cost_yrmon.value == ''){
	    				ComShowCodeMessage('CGM10004','Cost Month');
	    				cost_yrmon.focus();
        	 			return false;
	    			} else {
	    				return true;
	    			}
	    			break;
	    	}
	    }
	    return true;
	}

	/** 
	 * Object activate event handling  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	/** 
     * Object deactivate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
    }
	/**
	 * Sheet1 OnSaveEnd event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
		}
	}
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
		var formObj=document.form;
		var chgCreSeq=sheetObj.GetCellValue(Row,"chg_cre_seq");
		var lseChgStsCd=sheetObj.GetCellValue(Row, "lse_chg_sts_cd");
		var vndrSeq=sheetObj.GetCellValue(Row,"vndr_seq"); 
		// checkhandling
		if(sheetObj.ColSaveName(Col)=='del_chk'){
			sheetObj.SetCellValue(Row,"del_chk",sheetObj.GetCellValue(Row,"del_chk") == 0?1:0);
		}
		formObj.vndr_seq.value=vndrSeq;
		// sheet2 data deleting
		sheetObjects[1].RemoveAll();
		// Charge Creation 
		if(chgCreSeq == ""){
			if(vndrSeq == '132466' || vndrSeq == '105026'){
				vndrSeq="105621";
			}
			for(var i=1; i <= sheetObj.RowCount(); i++){
				var cellVndrSeq=sheetObj.GetCellValue(i,"vndr_seq");
				if(cellVndrSeq == '132466' || cellVndrSeq == '105026'){
					cellVndrSeq="105621";
				}
				if(vndrSeq == cellVndrSeq &&
						sheetObj.GetCellValue(i,"chg_cre_seq") == ''){
					sheetObj.SetRowBackColor(i,"#E7FAF8");
				} else {
					sheetObj.SetCellValue(i,"del_chk",0);
					sheetObj.SetCellValue(i,"ibflag","");
					if(sheetObj.GetCellValue(i,"lse_chg_sts_cd") == ""){
						sheetObj.SetRowBackColor(i,"#C0C0C0");
					} else {
						sheetObj.SetRowBackColor(i,"#FFFFFF");
					}
				}
			}
			ComBtnDisable("btn_InvoiceImportAudit");
			ComBtnDisable("btn_AuditResultCreation");
			ComBtnDisable("btn_Delete");
			formObj.chg_cre_seq.value="";
		} else {
			for(var i=1; i <= sheetObj.RowCount(); i++){
				if(chgCreSeq == sheetObj.GetCellValue(i,"chg_cre_seq")){
					if(sheetObj.ColSaveName(Col)=='del_chk'){
						//sheetObj.cellValue2(i,"del_chk") = 1;
						sheetObj.SetCellValue(i,"del_chk",sheetObj.GetCellValue(Row,"del_chk"))
						if(sheetObj.GetCellValue(Row,"del_chk")==0){
							sheetObj.SetCellValue(i,"ibflag","");
						} else {
							sheetObj.SetCellValue(i,"ibflag","U");
						}
					}
					sheetObj.SetRowBackColor(i,"#E7FAF8");
				} else {
					sheetObj.SetCellValue(i,"del_chk",0);
					sheetObj.SetCellValue(i,"ibflag","");
					if(sheetObj.GetCellValue(i,"lse_chg_sts_cd") == ""){
						sheetObj.SetRowBackColor(i,"#C0C0C0");
					} else {
						sheetObj.SetRowBackColor(i,"#FFFFFF");
					}
				}
			}
			// Invoice Import & Audit Button disable handling
			if(sheetObj.ColSaveName(Col)=='del_chk'){
				var iCheckRow=sheetObj.CheckedRows("del_chk");
				var sCheckRows=sheetObj.FindCheckedRow("del_chk");
    			var arrCheckRows=sCheckRows.split("|");
    			if(iCheckRow > 0){
    				var auditImportBtn=true;
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd=sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A'){
	    					auditImportBtn=false;
	    					break;
	    				}
	    			}
	    			var deleteBtn=true;
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd=sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A'){
	    					deleteBtn=false;
	    					break;
	    				}
	    			}
	    			if(auditImportBtn){
	    				ComBtnEnable("btn_InvoiceImportAudit");
	    			} else {
	    				ComBtnDisable("btn_InvoiceImportAudit");
	    			}
	    			if(deleteBtn){
	    				ComBtnEnable("btn_Delete");
	    			} else {
	    				ComBtnDisable("btn_Delete");
	    			}
	    			// Audit Result & P.Amt Confirm Button enable
	    			ComBtnEnable("btn_AuditResultCreation");
    			} else {
    				ComBtnDisable("btn_InvoiceImportAudit");
    				ComBtnDisable("btn_AuditResultCreation");
    				ComBtnDisable("btn_Delete");
    			}
			}
			// Charge Creation result list retrieve
			formObj.f_cmd.value=SEARCH01;
     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
     		formObj.chg_cre_seq.value=chgCreSeq;
     		formObj.lse_chg_sts_cd.value=lseChgStsCd;
     		var sXml=sheetObj.GetSearchData("EES_CGM_2032GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2"), '', true );
     		sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
		}
	} 
	
	function closeSearch(){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
	}
	/* developer job end */
