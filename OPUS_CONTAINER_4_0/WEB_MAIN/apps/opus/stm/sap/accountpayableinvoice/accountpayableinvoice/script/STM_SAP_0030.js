/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0030.js
*@FileTitle  : Invoice Slip
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/**
 * @extends 
 * @class stm_sap_0030 : business script for stm_sap_0030
 */
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sheet1ChnFlag="N";		//sheet1 change Flag
	var sheetObject1;
	var sheetObject2;
	var sheetObject3;
	var prefix1; 
	var prefix2;
	var prefix3;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/*******************************************************/
		var formObj=document.form;
		/***** setting sheet object *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
	    	    	sheetObjects[1].RemoveAll();
	    	    	sheetObjects[2].RemoveAll();
	    	    	comboObjects[0].RemoveAll();
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;	
				case "btn_print":
					doActionIBSheet(sheetObject1,formObj,RDPRINT);
					break;
                case "btn_close":
                	//ComClosePopup();
                	window.close();
                    break;
				case "btns_calInvFr":
					if (!formObj.inv_dt_fr.readOnly) { 
						var cal=new ComCalendar();
						cal.select(form.inv_dt_fr, 'yyyy-MM-dd');
					}
					break;				
				case "btns_calInvTo":
					if (!formObj.inv_dt_to.readOnly) {
						var cal=new ComCalendar();
						cal.select(form.inv_dt_to, 'yyyy-MM-dd');
					}
					break;		
				case "btns_calGlFr":
					if (!formObj.gl_dt_fr.readOnly) {
						var cal=new ComCalendar();
						cal.select(form.gl_dt_fr, 'yyyy-MM-dd');
					}
					break;				
				case "btns_calGlTo":
					if (!formObj.gl_dt_to.readOnly) {
						var cal=new ComCalendar();
						cal.select(form.gl_dt_to, 'yyyy-MM-dd');
					}
					break;	
				// Open Office
				case "btns_search_ofc":
					if (!formObj.ofc_cd.readOnly) {
						ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					}
					break;	
				// Pay Group
				case "btns_search_paygroup":
					if (!formObj.ap_pay_grp_lu_cd.readOnly) {
						ComOpenPopupWithTarget('STM_SAP_0004.do?lu_cd='+document.form.ap_pay_grp_lu_cd.value + "&attr_ctnt1="+document.form.ofc_cd.value, 400, 420,"lu_cd:ap_pay_grp_lu_cd", "0,0", true);
					}
					break;	
				// CSR No
				case "btns_search_csrno":
					if (!formObj.inv_no.readOnly) {
						ComOpenPopupWithTarget('STM_SAP_0003.do?inv_no='+document.form.inv_no.value+"&ofc_cd=" + document.form.ofc_cd.value+"&inv_flg=A", 480, 550,"inv_no:inv_no", "0,0", true);
					}
					break;	
				//Source
				case "btns_search_source":
					if (!formObj.ap_inv_src_cd.readOnly) {
						ComOpenPopupWithTarget('STM_SAP_0005.do?lu_cd='+document.form.ap_inv_src_cd.value, 430, 420,"lu_cd:ap_inv_src_cd", "0,0", true);
					}
					break;
                // Supplier
				case "btns_search_supplier":
					if (!formObj.vndr_no.readOnly) {
						var param="?vndr_seq=" + formObj.vndr_no.value; 
						ComOpenPopup("STM_SAP_0002.do"+param, 900, 420, "setSupplier", "0,0", true, false);
					}
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    /**
     * Supplier - return data from popup
     */
    function setSupplier(aryPopupData) {
    	document.form.vndr_no.value=aryPopupData[0][1];
    	document.form.vndr_nm.value=aryPopupData[0][2];
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
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/** 
	 * registering IBCombo Object as list
	 * param : combo_obj
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}		
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];
		this.sheetObject3=sheetObjects[2];
	    this.prefix1=sheetObject1.id + "_"; 
	    this.prefix2=sheetObject2.id + "_";
	    this.prefix3=sheetObject3.id + "_";
	    // insert initial value in Sheet
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	    initControl();
	    tab1_OnChange(tabObjects[0],1);
	    resizeSheet();
	    tab1_OnChange(tabObjects[0],0);
	}
	/**
     * initializing Tab
     * setting Tab items
     */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( "1. Invoice Line" , "");
					InsertItem( "2. Payment" , "");
				}
				break;
		}
	}	
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch (comboObj.options.id) {
		    	case "inv_curr_cd":
		    		with (comboObj) {
				   	ValidChar(2);
			       	}
	           break;
			   default :
		           with (comboObj) {
			       }
	           break;
	     }
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:  // sheet1 init 
			    with(sheetObj){
				      var HeadTitle1="|||CSR No|Supplier Name|Supplier Code|Invoice Date|Curr|Invoice Amount|Source Module|User Name|Invoice Type|Approval|Receipt No|Payment date|Rejected By|||Office||Submit";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"chk_flg" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"checkbox",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_cd", 		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ap_inv_src_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_tp_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"approval",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:prefix+"receipt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rejected_by",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:70,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:prefix+"submit_flag",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
//				      SetColProperty(prefix+"inv_dt", {Format:"####-##-##"} );
				      SetColHidden(prefix + "chk_flg",1);
				      SetSheetHeight(200);
		      }
			   break;
			case 2:   //sheet2 init
			    with(sheetObj){
				      var HeadTitle1="|Line No|Type|Post|GL Date|Line Amount|Tax Code|Tax Name|Supplier Inv No|Supplier Inv Date|Line Description";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_line_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"line_tp_lu_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acctg_pst_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acctg_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"dtrb_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_vat_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vat_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vendor_inv_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vendor_inv_date", KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:prefix+"dtrb_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
//				      SetColProperty(prefix+"acctg_dt", {Format:"####-##-##"} );
//				      SetColProperty(prefix+"vendor_inv_date", {Format:"####-##-##"} );
				      SetSheetHeight(150);
		      }
			   break;
			case 3:   //sheet3 init - second tab
			    with(sheetObj){
				      var HeadTitle1="|Bank Account Name|Check Number|Pay Doc Name|Pay Type|Voucher No|Curr|Payment date|Post|Pay Amount";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"doc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acctg_pst_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
//				      SetColProperty(prefix+"pay_dt", {Format:"####-##-##"} );
				      SetSheetHeight(150);
		      }
			   break;
	    }
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		switch (sAction) {
		    case COMMAND01: // When form open
		    	var popMode=formObj.pop_mode.value;
		    	if ( popMode == "Y" ) {
		    		formObj.ofc_cd.value=formObj.pop_ofc_cd.value;
		    		formObj.inv_dt_fr.value=formObj.pop_inv_dt.value;
		    		formObj.inv_dt_to.value=formObj.pop_inv_dt.value;
		    		formObj.inv_no.value=formObj.pop_inv_no.value;
		    		// formObject Enable
		    		ComEnableObject(formObj.ofc_cd,           false);
		    		ComEnableObject(formObj.ap_pay_grp_lu_cd, false);
		    		ComEnableObject(formObj.inv_no,           false);
		    		ComEnableObject(formObj.inv_dt_fr,        false);
		    		ComEnableObject(formObj.inv_dt_to,        false);
		    		ComEnableObject(formObj.ap_inv_src_cd,    false);
		    		ComEnableObject(formObj.vendor_inv_no,    false);
		    		ComEnableObject(formObj.gl_dt_fr,         false);
		    		ComEnableObject(formObj.gl_dt_to,         false);
		    		ComEnableObject(formObj.vndr_no,          false);
		    		// Combo Enable
		    		comboObjects[0].SetEnable(0);
		    		// RADIO Disabled
		    		formObj.approval[0].disabled=true;
		    		formObj.approval[1].disabled=true;
		    		formObj.approval[2].disabled=true;
		    		formObj.approval[3].disabled=true;
		    		// Retrieve
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    		// Header Auto Check
		    		sheetObj.SetCellValue(1,   prefix + "checkbox",1,0);
		    		sheetObj.SetCellEditable(1, prefix + "checkbox",0);
		    	} else {
			    	// Login-user's AP office Information
			    	formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
			    	// Local time
			    	var localTime=SapGetLocDate(sheetObj);
					var localStartTime=localTime.substr(0,6) + "01";
					formObj.inv_dt_fr.value=ComGetMaskedValue(localStartTime, "ymd");				
					formObj.inv_dt_to.value=ComGetMaskedValue(localTime, "ymd");
					//Condition - EVIDENCE TYPE 
			 		var currComboItems=SapGetCurrComboItems(sheetObjects[0], "");
			 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " ");
		    	}
		    	break;
			case IBSEARCH: //RETRIEVE
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				//search start 
				formObj.f_cmd.value=SEARCH;		
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0030GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case SEARCHLIST01: // RETRIEVE LINE (TAB)
				formObj.f_cmd.value=SEARCH02;
 				var sXml=sheetObj.GetSearchData("STM_SAP_0030GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;	
			case SEARCHLIST02: // RETRIEVE PAYMENT (TAB)
				formObj.f_cmd.value=SEARCH03;
 				var sXml=sheetObj.GetSearchData("STM_SAP_0030GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;		
			case RDPRINT:	//Print
				formObj.f_cmd.value=PRINT;
				var sParam1="";
				for(k=1; k <= sheetObj.SearchRows()+1; k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						sParam1 += sheetObj.RowSaveStr(k) + "&" ;
					}
				}				
                var sParam=sParam1 + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0030GS.do", sParam);
				ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;
				var print_seq=ComGetEtcData(sXml, "INV_RQST_SEQ");
				rdOpen(formObj, print_seq);
		        break;
		}
	}
	/******************************************************
	 * Sheet /Tab Event - Start
	 *****************************************************/
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
	function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
        objs[beforetab].style.display="none";
        objs[nItem].style.display="Inline";
        beforetab=nItem;
        resizeSheet();
        
	}	
	/**
     * Header Sheet를 click 하거나 최초 조회시 발생
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @return 없음.
     */  
    function searchDetailList(sheetObj, row, col) {
    	var sheetID=sheetObjects[0].id;
		var prefix=sheetID + "_";
		var formObj=document.form
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var prefix1=sheetObject1.id + "_";
		sheetObject2.RemoveAll();
	    sheetObject3.RemoveAll();
	 //   var point = getPoint();
	//	initSheet(sheetObject2, 2, point);
	//	initSheet(sheetObject3, 3, point);
		with(sheetObj){
	        //For mapping invoice & Line / Detail Data
			var inv_seq=sheetObj.GetCellValue(row, prefix + "inv_seq");
			var inv_curr_cd_hid=sheetObj.GetCellValue(row, prefix + "inv_curr_cd");
			formObj.hid_inv_seq.value=inv_seq;
			formObj.hid_inv_curr_cd.value=inv_curr_cd_hid;
	        doActionIBSheet(sheetObject2,formObj,SEARCHLIST01);
	        doActionIBSheet(sheetObject3,formObj,SEARCHLIST02);
	        //For write Invoice Description textBox 
	        var inv_desc=sheetObj.GetCellValue(row, prefix + "inv_desc");
	        formObj.inv_desc.value=inv_desc;
	        return;
		}
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet1_OnClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var sheetObject2=sheetObjects[1];
	    var prefix2=sheetObject2.id + "_";
		sheetObj.SetCellValue(Row, prefix+"chk_flg","1",0);
		if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" && ( sheetObj.GetCellValue(Row, prefix+"inv_seq") != sheetObject2.GetCellValue(1, prefix2+"inv_seq") ) ) {
			searchDetailList(sheetObj, Row, Col);
		}
	}	
	/**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		sheet1ChnFlag="N";
		var prefix=sheetObj.id + "_";
		if ( sheetObj.RowCount()> 0 ) {
			sheetObj.SetCellValue(1, prefix+"chk_flg","1",0);
			searchDetailList(sheetObj, 1, 0);
		}	
	}
    /******************************************************
	 * Sheet Event - End
	 *****************************************************/
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
	    var sheetObject3=sheetObjects[2];
		switch (sAction) {
		    case IBSEARCH: //retrieve
				if(formObj.inv_dt_fr.value == ""){
					ComShowCodeMessage("COM12113", "From Invoice Date");
					ComSetFocus(document.all.item("inv_dt_fr"));
					return false;
				}
				if(formObj.inv_dt_to.value == ""){
					ComShowCodeMessage("COM12113", "To Invoice Date");
					ComSetFocus(document.all.item("inv_dt_to"));
					return false;
				}
				var frDt1=ComReplaceStr(formObj.inv_dt_fr,"-","");
				var toDt1=ComReplaceStr(formObj.inv_dt_to,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.inv_dt_to.focus();
					return false;
				}
				break;
			case RDPRINT: //print
				var chkRows=sheetObj.CheckedRows("sheet1_checkbox"); ;
				if ( chkRows < 1 ) {
					ComShowCodeMessage("SAP00010" , " data to print");
					return false;
				}
				break;	
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
	    //handling Axon event. event catch
//		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
		//axon_event.addListenerForm('keyup',    'obj_keyup',   	formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	    axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	    //axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
	}
	/**
	 *  Supplier Number / Name - OnChange
	 */
	/*function vndr_no_onchange(comboObj) {
		//document.form.vndr_nm.value = "";
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var vndr_no = formObj.vndr_no.value;
		if (vndr_no == "") {
			document.form.vndr_nm.value = "";
		} else {
			document.form.vndr_nm.value = SapGetSupplierName(sheetObj, vndr_no, "", "" );
		}
	}*/
	/**
	 * control keyboard input  onkeypress event of HTML Control
	 **/
//	function obj_keypress() {
//		switch(ComGetEvent().dataformat){
//			case "engup":
//				ComKeyOnlyAlphabet('uppernum');
//				break;
//			case "engnum":
//				//English to enter uppercase letters, uppercase letters+number
//	            ComKeyOnlyAlphabet('uppernum');
//				break;	
//			case "ymd":
//				ComKeyOnlyNumber(ComGetEvent());
//				break;
//			default:
//				//common standard: recognization only number, english
//				ComKeyOnlyAlphabet("num");
//				break;     
//		}
//	}   
	/** 
	 * handling Keypress event of Object  <br>
	 * checking validation of input value by dataformat of object  <br>
	 */ 
	/*function obj_keyup(){
		switch(event.srcElement.name){ 	    	
   		case "inv_curr_cd_text":
			$("#inv_curr_cd_text").val($("#inv_curr_cd_text").val().toUpperCase());
   			break;
		}
	}  */
	/** 
	 * handling work javascript OnFocus event  <br>
	 */    
	function obj_activate() {
	   	//delete mask separator
        ComClearSeparator(ComGetEvent());     
	}
	/** 
	 * handling work javascript OnBlur event  <br>
	 */    
	function obj_blur(){
		// ComChkObjValid(ComGetEvent());
	}    
	/**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		var obj=ComGetEvent();
	    //var formObj=document.form;

		switch(ComGetEvent("name")){ 	    	
	   		case "inv_dt_fr":
	   			ComAddSeparator(form.inv_dt_fr, "ymd");
	   			ComChkObjValid(ComGetEvent());	
	   			break;
	   		case "inv_dt_to":
	   			ComAddSeparator(form.inv_dt_to, "ymd");
	   			ComChkObjValid(ComGetEvent());
	   			break;
	   		case "gl_dt_fr":
	   			ComAddSeparator(form.gl_dt_fr, "ymd");
	   			ComChkObjValid(ComGetEvent());	
	   			break;
	   		case "gl_dt_to":
	   			ComAddSeparator(form.gl_dt_to, "ymd");
	   			ComChkObjValid(ComGetEvent());
	   			break;	
		}
	}
	/**
     * initialize or check selected header information
     */ 
    function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "vndr_no":
				var vndr_no=formObj.vndr_no.value;
				formObj.vndr_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
		    	break;
				
			case "ofc_cd":
				var office_code=formObj.ofc_cd.value;
				formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
				break;
		}
	}
    function rdOpen( formObj, print_seq){
        var rdParam='/rp '+setRDParamStr(print_seq);
        var strPath="apps/opus/stm/sap/accountpayableinvoice/accountpayableinvoice/report/STM_SAP_1001.mrd";
        formObj.com_mrdPath.value=strPath;
        formObj.com_mrdArguments.value=rdParam;
        ComOpenRDPopupModal();
    }   
    function setRDParamStr(print_seq){
    	var rdParamStr="";
        var formObj=document.form;         
        rdParamStr += " ["+print_seq+"]";
        rdParamStr += " ["+"Y" +"]";
        return rdParamStr;
    }	
    
    /*function resizeSheet(){
        for (i=1; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }*/
    
    function resizeSheet(){
        var tabIdx = tab1.GetSelectedIndex();
        ComResizeSheet(sheetObjects[tabIdx + 1]);
        var wSheet = sheetObjects[tabIdx + 1].GetSheetWidth();
        var divTabs = $("div[id=tabLayer]");
        var wTable = $(divTabs[tabIdx]).find(".GMMainTable").width();
        if(wSheet - 10 > wTable) {
        	ComResizeSheet(sheetObjects[tabIdx + 1]);
        }
    }
    
