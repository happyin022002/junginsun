/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   STM_SAP_0240.js
*@FileTitle  : Prepayment Invoices
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Invoices : business script for STM_SAP_0240
     */
	var focusObj=null;
	// public variable
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
	var editMainRow=0; 
    var prefix1; 
	var prefix2;
	var prefix3;
	var save_inv_seq;	
	
	var  TAX_ACCOUNT = "";
	var  OVERSAES_TAX_ACCOUNT = "";
	var  OFC_COUNTRY = "";
	var  NATIVE_COUNTRY = "";
	var  ARR_LINE_TAX_RATE;	
	var  apLoginCurr = "";
	var  EXRATE_RULE = "";
	var  PaymentMethodName = "";
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var formObj=document.form;
		
     	try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					break;
				case "btn_new":
					ComResetAll();    //기본 object 초기화
					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
					sheet1ChnFlag="N";
					break;	
 				case "btn_save":
 					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					break;
 				case "btn_delete":
 					doActionIBSheet(sheetObjects[0], formObj, IBDELETE);
 					break;
 				case "btn_cancel":
 					doActionIBSheet(sheetObjects[0], formObj, MULTI02);
 					break;
 				case "btn_apply":
 					var mainRow=sheetObjects[0].GetSelectRow();
 					if ( "" != sheetObjects[0].GetCellValue(mainRow, prefix1+"ibflag")) {
 						var attr_ctnt15=sheetObjects[0].GetCellValue(mainRow, prefix1+"attr_ctnt15");
 						var pay_sts_flg=sheetObjects[0].GetCellValue(mainRow, prefix1+"pay_sts_flg");
 						var inv_cxl_dt=sheetObjects[0].GetCellValue(mainRow, prefix1+"inv_cxl_dt");
 						//alert("결재완료여부::" + attr_ctnt15 +":::지불처리여부:::" + pay_sts_flg + ":::CancelDate:::" + inv_cxl_dt );
 						if ("Y" == attr_ctnt15 && "Y" == pay_sts_flg && "" == inv_cxl_dt )  {
 							var param="?inv_seq=" + sheetObjects[0].GetCellValue(mainRow, prefix1+"inv_seq") + "&point=" + getPoint() + "&f_curr=" + formObj.hid_func_curr_cd.value;
 							ComOpenPopup("STM_SAP_0241.do" + param, 900, 680, "", "0,0", true, false);
 						} else {
 							var msg="";
 							if ("Y" != attr_ctnt15) msg="\nThis invoice is not approved.";
 							if ("Y" != pay_sts_flg && "" == msg ) msg="\nThis invoice is not paid yet. \nPlease apply/unapply after payment.";
 							if ("" != inv_cxl_dt && "" == msg ) msg="\nThis invoice was canceled.";
 							ComShowCodeMessage("SAP00035", msg );    
 						}
 					}
 					break;	
				case "btn_print":
					doActionIBSheet(sheetObjects[0],formObj,RDPRINT);
	                break;
				case "btns_search_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					break;	
				case "btns_search_csr":
					ComOpenPopupWithTarget('/opuscntr/STM_SAP_0003.do?inv_no='+document.form.inv_no.value+"&ofc_cd=" + document.form.ofc_cd.value+"&inv_flg=P", 480, 550,"inv_no:inv_no", "0,0", true);
					break;	
				case "btns_search_paygroup":
					var param="?lu_cd=" + encodeURIComponent(formObj.ap_pay_grp_lu_cd.value)+"&attr_ctnt1=" + formObj.ofc_cd.value;
					ComOpenPopup("STM_SAP_0004.do"+param, 400, 420, "setPayGroup", "0,0", true, false);
					break;	
				case "btns_calInvFr":
					var cal=new ComCalendar();
					cal.select(form.inv_fr_dt, 'yyyy-MM-dd');
					break;					
				case "btns_calInvTo":
					var cal=new ComCalendar();
					cal.select(form.inv_to_dt, 'yyyy-MM-dd');
					break;					
				case "btns_calGlFr":
					var cal=new ComCalendar();
					cal.select(form.gl_fr_dt, 'yyyy-MM-dd');
					break;					
				case "btns_calGlTo":
					var cal=new ComCalendar();
					cal.select(form.gl_to_dt, 'yyyy-MM-dd');
					break;					
				case "btns_search_supplier":
					var param="?vndr_seq=" + formObj.vndr_no.value + "&delt_flg=";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setSupplier", "0,0", true, false);
					break;		
				case "btns_search_source":
					var param="?lu_cd=" + encodeURIComponent(formObj.ap_inv_src_cd.value);
					ComOpenPopup("STM_SAP_0005.do"+param, 430, 420, "setSource", "0,0", true, false);
					break;		
				case "btn_sheet1RowAdd":
					if (sheet1ChnFlag == "N" && sheetObjects[1].IsDataModified()== false && sheetObjects[2].IsDataModified()== false ) {
						if(sheetObjects[0].SearchRows()== 0) {
							//sheetObjects[0].RemoveAll();
						}
						sheetObjects[0].SetComboOpenMode(1);

						var row=sheetObjects[0].DataInsert(-1);
						sheetObjects[0].SetCellValue(row, prefix1 + "chk_flg","1");
						sheetObjects[0].SetCellValue(row, prefix1 + "inv_tp_lu_cd","PREPAYMENT");
						sheetObjects[0].SetCellValue(row, prefix1 + "ofc_cd",formObj.hid_login_ap_ofc.value);						
						sheetObjects[0].SetCellValue(row, prefix1 + "inv_curr_cd",formObj.hid_login_curr_cd.value);
						sheetObjects[0].SetCellValue(row, prefix1 + "liab_coa_co_cd","01");
						sheetObjects[0].SetCellValue(row, prefix1 + "inv_dt",formObj.hid_local_sysdate.value);
						sheetObjects[0].SetCellValue(row, prefix1 + "attr_cate_nm","INVOICES");
						
						sheetObjects[1].RemoveAll();
					    sheetObjects[2].RemoveAll();
					    ComBtnEnable("btn_save");
					    ComBtnDisable("btn_delete");
					    ComBtnDisable("btn_cancel");
					    ComBtnDisable("btn_print");
					    ComBtnDisable("btn_apply");
					} else {
						 if (ComShowCodeConfirm("COM130504")) {   
							 doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
							 return;
	                     } else {
	                    	 sheetObjects[0].ReturnData(editMainRow);
	                     }
					}
 					break;
				case "btn_sheet1RowDelete":
					if(sheetObjects[0].GetSelectRow()< 0) {
						break;
					}
					var row=sheetObjects[0].GetSelectRow();
					if(sheetObjects[0].GetCellValue(row, prefix1 + "inv_seq") == "") {
						sheetObjects[0].SetRowHidden(row,1);
						sheetObjects[0].SetRowStatus(row,"D");
					} else {
						ComShowCodeMessage("SAP00031");
					}
					sheet1ChnFlag="N";
					break; 	
					
				case "btn_sheet2CalcTax":
					
					fncCalcTax();
					break;
					
				case "btn_sheet2RowAdd":
					var mainRow=sheetObjects[0].GetSelectRow();
					if (chkValidHeader() && sheetObjects[0].GetCellValue(mainRow, prefix1+"chkEditable") != "N" ) {
						var lastNo=0;
						if (sheetObjects[1].LastRow()> 1 ) {
							lastNo=sheetObjects[1].GetCellValue(sheetObjects[1].LastRow()-1, prefix2 + "dtrb_line_no");
						}
						var point=getPoint();
						if("I" == sheetObjects[0].GetCellValue(mainRow, prefix1+"ibflag") && sheetObjects[1].RowCount()== 0 ) {
							sheetObjects[1] = sheetObjects[1].Reset();
							initSheet(sheetObjects[1], 2, point);
						}
						var row=sheetObjects[1].DataInsert(-1);
			    		sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_line_no",parseInt(ComNullToZero(lastNo)) +1);
			    		sheetObjects[1].SetCellValue(row, prefix2 + "line_tp_lu_cd","ITEM");
			    		sheetObjects[1].SetCellValue(row, prefix2 + "acctg_dt",sheetObjects[0].GetCellValue(mainRow, prefix1 + "gl_dt"));
			    		sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_desc",sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_desc"));
			        	sheetObjects[1].SetCellValue(row, prefix2 + "attr_ctnt3",document.form.hid_login_loc_cd.value);
			        	if (sheetObjects[0].GetCellValue(mainRow, prefix1 + "attr_cate_nm") == "ETC") {
			        		sheetObjects[1].SetCellValue(row, prefix2 + "attr_ctnt12", sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd"));
			        		sheetObjects[1].SetCellValue(row, prefix2 + "attr_ctnt11", sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_dt"));
			        		//sheetObjects[1].SetCellValue(row, prefix2 + "attr_ctnt14", "COM");
			        	}
			    		// Expense Account Information 
			    		var sXml=sheetObjects[1].GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND04 + "&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no")  + "&value1=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd") + "&value2=PREPAYMENT" );
	            		if (SAPDecideErrXml(sheetObjects[1], sXml)) {
	        				return;
	        			} else { 
	            			//clear
	        				sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_co_cd","",0);
	        				sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_rgn_cd","",0);
	        				sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_ctr_cd","",0);
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_acct_no","",0);
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_inter_co_cd","",0);
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_vvd_cd","",0);
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_cd_cmb_seq","",0);
		                	//setting
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_co_cd",ComGetEtcData(sXml, "company_code"));
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_rgn_cd",ComGetEtcData(sXml, "region_code"));
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_ctr_cd",ComGetEtcData(sXml, "center_code"));
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_acct_no",ComGetEtcData(sXml, "account_code"));
		                	sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_inter_co_cd",ComGetEtcData(sXml, "intercompany_code"));
		                	//sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_coa_vvd_cd",ComGetEtcData(sXml, "vvd_code"));
		                	//sheetObjects[1].SetCellValue(row, prefix2 + "dtrb_cd_cmb_seq",ComGetEtcData(sXml, "cd_cmb_seq"));
	        			}	
	            		if( point == 0 ) {
							sheetObjects[1].InitCellProperty(row, prefix2 + "dtrb_amt"		,{ Type:"Int",Align:"Right",Format:"NullInteger"} );
							sheetObjects[1].InitCellProperty(row, prefix2 + "dtrb_func_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
						} else {
							sheetObjects[1].InitCellProperty(row, prefix2 + "dtrb_amt"		,{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
							sheetObjects[1].InitCellProperty(row, prefix2 + "dtrb_func_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
						}			
			    	} 
 					break;
				case "btn_sheet2RowDelete":
					if(sheetObjects[1].GetSelectRow()< 0) {
						break;
					}
					var mainRow=sheetObjects[0].GetSelectRow();
					if ( sheetObjects[0].GetCellValue(mainRow, prefix1 +"chkEditable") != "N") {
						var row=sheetObjects[1].GetSelectRow();
						sheetObjects[1].SetRowHidden(row,1);
						sheetObjects[1].SetRowStatus(row,"D");
					}
					break; 	
				case "btn_sheet3RowAdd":
					if (chkValidHeader()) {
						var mainRow=sheetObjects[0].GetSelectRow();
						if ("I" == sheetObjects[0].GetCellValue(mainRow, prefix1 + "ibflag") && sheetObjects[2].RowCount() == 0 ) {  
							addSheet3Data("INIT");
						} else {	
							addSheet3Data("APPEND");
						} 
					}
 					break;
				case "btn_sheet3RowDelete":
					if(sheetObjects[2].GetSelectRow()< 0) {
						break;
					}
					var row=sheetObjects[2].GetSelectRow();
					sheetObjects[2].SetRowHidden(row,1);
					sheetObjects[2].SetRowStatus(row,"D");
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
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
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
			initSheet(sheetObjects[i],i+1, 0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);		
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
	    this.prefix1=sheetObjects[0].id + "_"; 
	    this.prefix2=sheetObjects[1].id + "_";
	    this.prefix3=sheetObjects[2].id + "_";
	    
	    this.TAX_ACCOUNT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=AP TAX ACCOUNT&attr_ctnt1=INTERNAL");	
	    this.OVERSAES_TAX_ACCOUNT = chkLookupOneData(sheetObjects[0], "&lu_tp_cd=AP TAX ACCOUNT&attr_ctnt1=EXTERNAL");
	    this.NATIVE_COUNTRY = chkLookupOneData(sheetObjects[0], "&lu_appl_cd=SCO&lu_tp_cd=NATIVE COUNTRY");
	    this.EXRATE_RULE = chkLookupOneData(sheetObjects[0], "&lu_appl_cd=SAP&lu_tp_cd=AP EXCHANGE RATE METHOD");
	    
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		initControl();
		tab1_OnChange(tabObjects[0],0);
		//resizeSheet();
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
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
	function initSheet(sheetObj,sheetNo,point) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
					var HeadTitle1="|Chk|CSR No|Invoice Type|Office|Supplier Name|Supplier Code|Invoice Date|GL Date|Invoice Currency|Invoice Amount|Description|Pay Group|Terms Date|Terms|Payment Method|Evidence|Liability Account|Liability Account|Liability Account|Liability Account|Liability Account|Liability Account|Exchange Rate Type|Exchange Rate Type Code|Exchange Rate Date|Exchange Rate|Payment Currency|Status|Prepaid Amount|Invoice Vat Code|Register Number|Invoice Id";
					HeadTitle1=HeadTitle1 + "|ATTR_CTNT1|ATTR_CTNT3|ATTR_CTNT4|ATTR_CTNT5|ATTR_CTNT6|ATTR_CTNT7|ATTR_CTNT8|ATTR_CTNT9|ATTR_CTNT10|ATTR_CTNT11|ATTR_CTNT12|ATTR_CTNT13|ATTR_CTNT14|ATTR_CTNT15";
					HeadTitle1=HeadTitle1 + "|glo_1|glo_2|glo_3|glo_4|glo_5|glo_6|glo_7|glo_8|glo_9|glo_10|glo_11|glo_12|glo_13|glo_14|glo_15|glo_16|glo_17|glo_18|glo_19|glo_20";
					HeadTitle1=HeadTitle1 + "|inv_apro_rdy_flg|period_chk|inv_func_amt|inv_curr_prcs|cnt_acctg_pst_flg_y|sup_reg_no|sup_tax_code|liab_cd_cmb_seq|chkEditable";
					HeadTitle1=HeadTitle1 + "|pay_sts_flg|ap_apsts_cd|inv_cxl_dt|Amount Paid|Remaining Amount|ap_inv_src_cd|bank_acct_flg|Submit";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 3});

					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_flg" },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20, AcceptKeys:"E", InputCaseSensitive:1},
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_tp_lu_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
		             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1},
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd" },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd" },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },    //original code after converted
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             //{Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_amt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },					//clt guideline
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_pay_grp_lu_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_term_dt",          KeyField:1,   CalcLogic:"",   Format:"Ymd" },
		             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_term_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_cate_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_co_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_rgn_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_ctr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_acct_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_inter_co_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_vvd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_rt_tp_cd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
		             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
		             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		         
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:-1,  UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_pay_curr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"approval_status",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_curr_inv_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_vat_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20, AcceptKeys:"E", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt6",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt7",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt8",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt9",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt10",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt11",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt12",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt13",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt14",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt15",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt7",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt8",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt9",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt10",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt11",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt12",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt13",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt14",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt15",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt16",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt17",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt18",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt19",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_apro_rdy_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"period_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_func_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_prcs",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cnt_acctg_pst_flg_y",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sup_reg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sup_tax_code",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_cd_cmb_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"chkEditable",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_sts_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_apsts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_cxl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_pay_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"prepay_rmn_tot_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_inv_src_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:prefix+"submit_flag",     	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
					InitColumns(cols);
					
					SetEditable(1);
//					SetColProperty(0 ,prefix + "inv_amt" , {AcceptKeys:"N|[-.]"});
					SetColProperty(0 , prefix + "inv_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "vndr_no" ,  {AcceptKeys:"N"});
					//SetColProperty(0 ,prefix + "inv_amt", {AcceptKeys:"N|[.-"});
					SetColProperty(0 ,prefix +"inv_amt" , {AcceptKeys:"N|[-.,]"});
					SetColProperty(0 ,prefix + "attr_cate_nm" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_co_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_rgn_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_ctr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_acct_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "liab_coa_inter_co_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "attr_ctnt2", {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					
		            SetColProperty(0,prefix+"inv_curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode},"");
		            SetColProperty(0,prefix+"inv_pay_curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode},"");
//		            SetColProperty(prefix+"inv_tp_lu_cd", {ComboText:"2", ComboCode:"INVOICETYPE"} );
		            SapInitDataCombo(sheetObj, prefix + "inv_tp_lu_cd", "2", " " , " ", "INVOICE TYPE" , "&attr_ctnt1=P") ;
		            SapInitDataCombo(sheetObj, prefix + "pay_mzd_lu_cd", "2", " " , " ", "PAYMENT METHOD" , "", 1) ;
		            
		            SetColHidden(prefix + "chk_flg",1);
		            InitComboNoMatchText(true);
		            SetSheetHeight(200);
				}
			    break;
			case 2:      // sheet1 init
			    with(sheetObj){
					var HeadTitle1="|No|Type|Line Amount|GL Date|Expense Account|Expense Account|Expense Account|Expense Account|Expense Account|Expense Account|Line Description|Location|Tax Code|Tax Name|Functional Amount";
					HeadTitle1=HeadTitle1 + "|ATTR_CTNT1|ATTR_CTNT2|ATTR_CTNT4|ATTR_CTNT5|ATTR_CTNT6|ATTR_CTNT7|ATTR_CTNT8|ATTR_CTNT9|ATTR_CTNT10|ATTR_CTNT11|ATTR_CTNT12|ATTR_CTNT13|ATTR_CTNT14|ATTR_CTNT15";
					HeadTitle1=HeadTitle1 + "|inv_dtrb_seq|inv_seq|period_chk|dtrb_cd_cmb_seq|inv_rnd_amt|tax_rate|tax_ref_key|dtrb_xch_dt|dtrb_xch_rt|dtrb_xch_rt_tp_cd|dtrb_func_gain_amt|dtrb_func_lss_amt";
					var headCount=ComCountHeadTitle(HeadTitle1) ;
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_line_no",         KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"line_tp_lu_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		            if (point == 0 ) {
		            	cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dtrb_amt",             KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            } else {
		            	cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dtrb_amt",             KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:point,UpdateEdit:1,   InsertEdit:1 });
		            }

		            
		            cols.push({Type:"PopupEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acctg_dt",             KeyField:1,   CalcLogic:"",   Format:"Ymd" });
		            cols.push({Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_co_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_rgn_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_ctr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_acct_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_inter_co_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"PopupEdit", Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_coa_vvd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"dtrb_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt3",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50, AcceptKeys:"E", InputCaseSensitive:1 });
		            cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_vat_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 });
		            cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"dtrb_vat_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"AutoSum",   Hidden:0, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"dtrb_func_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:-1,  UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt6",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt7",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt8",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt9",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt10",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt11",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt12",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt13",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt14",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_ctnt15",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dtrb_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"period_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_cd_cmb_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_rnd_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_vat_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }); 
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_ctnt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_xch_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_xch_rt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_func_gain_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_func_lss_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      
		            InitColumns(cols);
		            SetEditable(1);
		            SetColProperty(0 ,prefix + "dtrb_coa_co_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		            SetColProperty(0 ,prefix + "dtrb_coa_rgn_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "dtrb_coa_ctr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "dtrb_coa_acct_no", {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "dtrb_coa_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,prefix + "dtrb_coa_inter_co_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});				
					SetColProperty(0 ,prefix + "attr_ctnt3" ,{AcceptKeys:"E|N|[.-/,() &]"});
					SapInitDataCombo(sheetObj, prefix + "line_tp_lu_cd", "2", " " , " ", "AP INVOICE LINE TYPE" ) ;
					SapInitDataComboTax(sheetObj, prefix + "dtrb_vat_cd", "2", " " , " ") ;
		            SetColHidden(prefix + "dtrb_func_amt",1);
		            InitComboNoMatchText(true);
		            SetSumText(1,"Total");
		            //SetSheetHeight(170);
				}
			    break;   
			case 3:      // sheet1 init
			    with(sheetObj){
					var HeadTitle1="|No|Hold|Hold Reason|Due Date|Gross Amount|Currency|Priority|Payment Method|Remit to Supplier Name|Remit to Supplier Code|Remit to Account Num|XTER_BANK_ACCT_SEQ|PAY_RMN_AMT";
					var headCount=ComCountHeadTitle(HeadTitle1) ;
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_skd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_hld_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"attr_ctnt15",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",             KeyField:1,   CalcLogic:"",   Format:"Ymd" } ];
		            if(point == 0 ) {
		            	cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_grs_amt",        KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            } else {
		            	cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_grs_amt",        KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:point,UpdateEdit:1,   InsertEdit:1 });
		            }
		            cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
		            cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_prio_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 });
		            cols.push({Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 });
		            cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"PopupEdit", Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"remit_vndr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            cols.push({Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xter_bank_acct_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_rmn_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		 
		            InitColumns(cols);
		            //SetSheetHeight(170);
		            SetEditable(1);
					SetColProperty(0 ,prefix + "pay_prio_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		            SetColProperty(prefix+"inv_curr_cd", {ComboText:"|"+currText, ComboCode:"|"+currCode} );
		            SetColHidden(prefix + "pay_skd_no",1);
		            InitComboNoMatchText(true);
		            SetSumText(3,"Total");
		      	}
			    break; 			   
		}
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
					InsertItem( "1. Lines" , "");
					InsertItem( "2. Scheduled Payments" , "");
				}
				break;
		}
	}	
	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */
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
		//sheetObjects[1].RemoveAll();
	    //sheetObjects[2].RemoveAll();
	    var point=getPoint();
	    sheetObjects[1] = sheetObjects[1].Reset();
		initSheet(sheetObjects[1], 2, point);
		sheetObjects[2] = sheetObjects[2].Reset();
		initSheet(sheetObjects[2], 3, point);
		with(sheetObj){
			var inv_seq=sheetObj.GetCellValue(row, prefix + "inv_seq");
	        formObj.hid_inv_seq.value=inv_seq;
	        doActionIBSheet(sheetObjects[1],formObj,SEARCHLIST01);
	        doActionIBSheet(sheetObjects[2],formObj,SEARCHLIST02);
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
		
		if(sheetObj.GetCellValue(Row, prefix+"chk_flg") != 1 ) {
			sheetObj.SetCellValue(Row, prefix+"chk_flg","1", 0);
			if(Col == 15) {
				sheet1_OnClick(sheetObj, Row, Col);   // 재귀호출이 필용한 부분은 Payment Method 더블 클릭을 없애기 위해서.
			} 
		}		
		
		var prefix2=sheetObjects[1].id + "_";
		var prefix3=sheetObjects[2].id + "_";
		if(sheetObj.GetCellValue(Row, prefix+"ibflag")!="I") {
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_cancel");
			ComBtnEnable("btn_print");		
			ComBtnEnable("btn_apply");		
		} else {
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_cancel");
			ComBtnDisable("btn_print");		
			ComBtnDisable("btn_apply");	
		}		
		if (Row != editMainRow) {
			if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" &&   ( sheet1ChnFlag == "Y" || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true ) ) {
				if (ComShowCodeConfirm("COM130504")) {    // "Data was changed. Do you want to save it?"
					 sheetObj.SetCellValue(editMainRow, prefix+"chk_flg","1", 0); 
					 sheetObj.SetSelectRow(editMainRow)
					 editMainRow=Row;
					 doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					 return;
	           } else {
	        	   if( sheetObj.GetCellValue(editMainRow, prefix+"ibflag")!="I" ) {
	        		   sheetObjects[0].ReturnData(editMainRow);
	        	   } else {
	        		   sheetObjects[0].RowDelete(editMainRow, false);
	        	   }        		   
	        	   sheet1ChnFlag="N";
	           }
			} 
		}
		//if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" ) {
		//	sheetObj.SetCellValue(Row, prefix+"chk_flg","1",0);
		//}
		editMainRow=Row;
		if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" && ( sheetObj.GetCellValue(Row, prefix+"inv_seq") != sheetObjects[1].GetCellValue(1, prefix2+"inv_seq") ) ) {
	    	searchDetailList(sheetObj, Row, Col);
	    }
		//eidtable setting
		if (sheetObj.GetCellValue(Row, prefix+"chkEditable") == "N") {
			ComBtnDisable("btn_sheet2CalcTax");
		} else {
			ComBtnEnable("btn_sheet2CalcTax");
		}
		resizeSheet();
	}
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {	
		//document.form.hid_func_curr_cd.value = this.apLoginCurr; --2015.02.27 KS.JO 제거 처리
		sheet1ChnFlag="N";
		var prefix=sheetObj.id + "_";
		if ( sheetObj.RowCount()> 0 ) {
			var findRowIdx=sheetObj.FindText(prefix + "inv_seq", save_inv_seq);
			if (findRowIdx > -1) {
				//sheetObj.SetSelectRow(findRowIdx); //2015.03.02 화면에 보여주기 전에 해당 함수가 처리되는것으로 보여 제거 처리
				sheetObj.SetCellValue(findRowIdx, prefix+"chk_flg","1",0);
				searchDetailList(sheetObj, findRowIdx, 0);	
				sheetObj.SelectCell(findRowIdx,2);
				sheet1ChnFlag="N";						
			} else {
				sheetObj.SetCellValue(1, prefix+"chk_flg","1",0);
				searchDetailList(sheetObj, 1, 0);
			}
			
			editMainRow = sheetObj.GetSelectRow();
			
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_cancel");
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_apply");
		}
		var f_curr_cd=ComTrim(document.form.hid_func_curr_cd.value);
		for (var i=sheetObj.HeaderRows(); i<= sheetObj.RowCount(); i++){
			var chkEditable=chkEditableInv(i);
			sheetObj.SetCellValue(i, prefix+"chkEditable",chkEditable,0);
			if (chkEditable == "Y") {
				sheetObj.SetRowEditable(i,1);
			} else {
				//sheetObj.RowEditable(i) = false;
				var colcnt=sheetObj.LastCol();
				for(var j=0; j <= colcnt; j++) {
					if (sheetObj.ColSaveName(j) == prefix+"attr_cate_nm") {
						sheetObj.SetCellEditable(i, j,1);
						sheetObj.InitCellProperty(i, j,{ Type:"Popup",Align:"Center",Format:""} );
						//sheetObj.InitCellProperty(i, j,{ Type:"Popup",Align:"Center",Format:"dfNull"} );
						//sheetObj.SetColProperty(0 ,"mphn_no" , {AcceptKeys:"N|[-]"});
						sheetObj.SetCellBackColor(i, j,"#EFF0F300");
					} else {
						sheetObj.SetCellEditable(i, j,0);
					}
				}
			}	
			if (f_curr_cd == sheetObj.GetCellValue(i, prefix+"inv_curr_cd")) {
				sheetObj.SetCellValue(i, prefix+"inv_xch_rt_tp_cd_nm","",0);
			}
		}
		// Lines editable setting
		if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"chkEditable") == "N") {
			sheetObjects[1].SetEditable(1);
			for(var i=1; i <= sheetObjects[1].RowCount(); i++) {
				var colcnt=sheetObjects[1].LastCol();
				for(var j=0; j <= colcnt; j++) {
					if (sheetObjects[1].ColSaveName(j) == prefix2+"attr_ctnt3") {
						sheetObjects[1].SetCellEditable(i, j,1);
						sheetObjects[1].InitCellProperty(i, j,{ Type:"Popup",Align:"Center",Format:""} );
						sheetObjects[1].SetCellBackColor(i, j,"#EFF0F300");
					} else {
						sheetObjects[1].SetCellEditable(i, j,0);
					}
				}
			}
		} else {
			sheetObjects[1].SetEditable(1);
		}		

		//eidtable setting
		if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"chkEditable") == "N" ) {
			ComBtnDisable("btn_sheet2CalcTax");
		} else {
			ComBtnEnable("btn_sheet2CalcTax");
		}
		
		// Payment Schedule editable setting
		if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"pay_sts_flg") == "Y" || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"pay_sts_flg") == "P" ) {
			sheetObjects[2].SetEditable(0);
		} else {
			sheetObjects[2].SetEditable(1);
		}
	}
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case prefix + "ofc_cd":    // office
                	if (Value == "") return;
                	var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND07 + "&value0=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd") );
     				if (SAPDecideErrXml(sheetObj, sXml)) {
     					sheetObj.SetCellValue(Row, Col, "");
     					sheetObj.SelectCell(Row, Col, true, "");
                     } else {
                    	 if ( "NO_DATA" == ComGetEtcData(sXml, "ofc_cd") ) {
                    		ComShowCodeMessage("COM132201", "Office Code" );  
                    		sheetObj.SetCellValue(Row, prefix + "ofc_cd", "");
         					sheetObj.SelectCell(Row, prefix + "ofc_cd", true, "");
         					return false;		
                    	 } else {
                    		 sheetObj.SetCellValue(Row, prefix + "ofc_cd",ComGetEtcData(sXml, "ofc_cd"));
                    		 sheetObj.SetCellValue(Row, prefix + "liab_coa_rgn_cd",ComGetEtcData(sXml, "finc_rgn_cd"));
                    		 sheetObj.SetCellValue(Row, prefix + "liab_coa_ctr_cd",ComGetEtcData(sXml, "ap_ctr_cd"));
                    		 this.OFC_COUNTRY = ComGetEtcData(sXml, "ofc_cnt_cd");
                    		 changeOfcAndGlDate(sheetObj, Row, Col);
                    	 }
                     }
                	break;
            	case prefix + "inv_dt":    // Invoice Date
            		if (Value == "") return;
            		if ("I" == sheetObj.GetCellValue(Row, prefix + "ibflag") ) {
            			if (sheetObj.GetCellValue(Row, prefix + "gl_dt") == "" ) {
            				//alert("C");
            				sheetObj.SetCellValue(Row, prefix + "gl_dt", Value);
            			}
	            		sheetObj.SetCellValue(Row, prefix + "inv_term_dt", Value, 0);
                	}
                	break;
            	case prefix + "gl_dt":    // GL Date
            		changeOfcAndGlDate(sheetObj, Row, Col);

            		/*if ("I" == sheetObj.GetCellValue(Row, prefix + "ibflag")) {
            			var inv_curr_cd=sheetObj.GetCellValue(Row, prefix + "inv_curr_cd");
            			var f_curr_cd=formObj.hid_func_curr_cd.value;
            			if (inv_curr_cd != f_curr_cd) {
            				sheetObj.SetCellValue(Row, prefix + "inv_xch_dt",Value);
            			}
            		}
                	break;*/		
                	
                	var inv_curr_cd=sheetObj.GetCellValue(Row, prefix + "inv_curr_cd");
        			var f_curr_cd=formObj.hid_func_curr_cd.value;
        			if (inv_curr_cd != f_curr_cd) {
        				var gl_dt = sheetObj.GetCellValue(Row, prefix + "gl_dt");
        				//alert("C" + gl_dt);
        				sheetObj.SetCellValue(Row, prefix + "inv_xch_dt",gl_dt);
        			}        		
                	break;
                	
            	case prefix + "inv_xch_dt":    // Exchange Date
            		//if (Value == "") return;
            		var inv_xch_dt=sheetObj.GetCellValue(Row, prefix + "inv_xch_dt");
            		if (inv_xch_dt == "") {
            			//alert("C" + inv_xch_dt);
	            		sheetObj.SetCellValue(Row, prefix + "inv_xch_rt","");
	                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt","",0);
	                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd","",0);
	                 	sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs","",0);
	                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","",0);
            		}
            		
            		if (inv_xch_dt != "") {
            			chkXRate(prefix + "inv_xch_dt", Row);
            		}
            		
            		/*var inv_curr_cd=sheetObj.GetCellValue(Row, prefix + "inv_curr_cd");
        			var f_curr_cd=formObj.hid_func_curr_cd.value;
        			var inv_xch_dt=ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_xch_dt"));
            		if (inv_curr_cd != f_curr_cd) {
            			var xmlStr=GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + inv_xch_dt + "&value1=" + inv_curr_cd + "&value2=" + f_curr_cd);
         				if (SAPDecideErrXml(sheetObj, xmlStr)) {
                             SelectCell(Row, Col, true, "");
                         } else {
                             var x_rate=ComGetEtcData(xmlStr, "x_rate");
                             var x_date=ComGetEtcData(xmlStr, "x_date");
                             var x_type=ComGetEtcData(xmlStr, "x_type");
                             var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                             if ( x_rate != "NO_DATA") {
                             	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt",x_rate,0);
                             	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt",x_date,0);
                             	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd",x_type,0);
                             	sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs",x_prcs,0);
                             	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","Corporate",0);
                             } else {
                            	 ComShowCodeMessage("SAP00002", inv_xch_dt, inv_curr_cd);  // currency 없음 
                            	 break;
                             }
                         }
            		}*/
                	break;			
                case prefix + "inv_curr_cd":    // invoice currency code	
                	if (Value == "") return;
                	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd",sheetObj.GetCellValue(Row, prefix + "inv_curr_cd"),0);
					var inv_curr_cd=sheetObj.GetCellValue(Row, prefix + "inv_curr_cd");
					var inv_dt=sheetObj.GetCellValue(Row, prefix + "inv_dt");
					var period_chk=sheetObj.GetCellValue(Row, prefix + "period_chk");
					var inv_xch_dt=ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_xch_dt"));
					var gl_dt=ComTrim(sheetObj.GetCellValue(Row, prefix + "gl_dt"));
					if(inv_xch_dt == "") {
             			inv_xch_dt = (gl_dt == "" ) ? inv_dt : gl_dt;
             		}
             		var f_curr_cd=formObj.hid_func_curr_cd.value;
             		if (inv_dt.length > 0 && inv_curr_cd.length > 0 && period_chk == "Y") {
             			if (inv_curr_cd != f_curr_cd) {
             				sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt",1);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_dt",1);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt_tp_cd",1);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt_tp_cd_nm",1);
                         	var xmlStr=GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + inv_xch_dt + "&value1=" + inv_curr_cd + "&value2=" + f_curr_cd);
             				if (SAPDecideErrXml(sheetObj, xmlStr)) {
             					 SetCellValue(Row, Col, "");
                                 SelectCell(Row, Col, true, "");
                             } else {
                                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                                 var x_date=ComGetEtcData(xmlStr, "x_date");
                                 var x_type=ComGetEtcData(xmlStr, "x_type");
                                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                                 if ( x_rate != "NO_DATA") {
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt",x_rate);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt",x_date,0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd",x_type,0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs",x_prcs,0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","Corporate",0);
                                 } else  {
                                 	ComShowCodeMessage("SAP00002", inv_xch_dt, inv_curr_cd);  // currency 없음 
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt","");
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_amt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_func_amt","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_curr_cd","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","",0);
                                 	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd","",0);
                                 	SetCellValue(Row, Col, "");
                                 	SelectCell(Row, Col, true, "");
                             		return;
                                 }
                             }
             			} else {
             				sheetObj.SetCellValue(Row, prefix + "inv_xch_rt","");
                         	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt","",0);
                         	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd","",0);
                         	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","",0);
                         	//sheetObj.CellValue2(Row, prefix + "inv_curr_prcs") = ""; 
                         	//sheetObj.CellValue2(Row, prefix + "inv_amt") = ""; 
                         	//sheetObj.CellValue2(Row, prefix + "inv_func_amt") = ""; 
                         	//sheetObj.CellValue2(Row, prefix + "inv_curr_cd") = ""; 
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt",0);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_dt",0);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt_tp_cd",0);
                         	sheetObj.SetCellEditable(Row, prefix + "inv_xch_rt_tp_cd_nm",0);
             			}
             		} else {
             		}
             		if ( ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_amt") ) != "" ) {
             			settingFuncAmt(sheetObj, Row, Col);   
             		}
            		break;	
            	case prefix + "inv_amt":    // invoice currency code	
            		if (Value == "") return;
            		var inv_tp_lu_cd=sheetObj.GetCellValue(Row, prefix + "inv_tp_lu_cd");
            		var inv_amt=sheetObj.GetCellValue(Row,  prefix +  "inv_amt");
            		var pay_method_cd=sheetObj.GetCellValue(Row, prefix + "pay_mzd_lu_cd");
            		if ( !chkValidHeaderPre(sheetObj, Row, Col) ) {
            			return false;
            		} 
            		if ( inv_tp_lu_cd == "CREDIT" ) {
        				if ( inv_amt > 0 ) {    //--2015.03.19 KS.JO 금액이 Zero인 경우 제외 처리
        					ComShowCodeMessage("SAP00003", inv_tp_lu_cd, "negative number");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
        					sheetObj.SetCellValue(Row, prefix + "inv_amt","",0);
        					sheetObj.SelectCell(Row, prefix + "inv_amt", true, "");
        					return;
        				}
        			} else {
        				if ( inv_amt < 0 ) {
        					ComShowCodeMessage("SAP00003", inv_tp_lu_cd, "positive number");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
        					sheetObj.SetCellValue(Row, prefix + "inv_amt","",0);
        					sheetObj.SelectCell(Row, prefix + "inv_amt", true, "");
        					return;
        				}
        			}
            		// ASA 처럼 Invoice amount가 0인 경우 Payment Method가 X인 경우 처리 가능, 그외의 경우 처리 불가
            		if (pay_method_cd != "") {
        				if (inv_amt != 0 && pay_method_cd == "X") {
        					ComShowCodeMessage("SAP00083" ); 
        					sheetObj.SetCellValue(Row,prefix + "vndr_no","");
        					sheetObj.SelectCell(Row, prefix + "vndr_no", true, "");
        					return false;
        				}
        			}
            		settingFuncAmt(sheetObj, Row, Col);
            		break;
            	case prefix + "inv_xch_rt":    // inv_xch_rt
            		if (Value == "") return;
            		settingFuncAmt(sheetObj, Row, Col);
            		break;
            	case prefix + "inv_tp_lu_cd":    // invoice type
            		if (Value == "") return;
            		var inv_tp_lu_cd=sheetObj.GetCellValue(Row, prefix + "inv_tp_lu_cd");
            		var inv_amt=sheetObj.GetCellValue(Row,  prefix +  "inv_amt");
            		if ( inv_amt != "" ) {
            			inv_amt=parseFloat(inv_amt);
            			if ( inv_amt < 0 ) {
            				if ( inv_tp_lu_cd != "CREDIT" ) {
	            				ComShowCodeMessage("SAP00004", "negative number", "CREDIT");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
	            				sheetObj.SetCellValue(Row, prefix + "inv_tp_lu_cd","",0);
	            				sheetObj.SelectCell(Row, prefix + "inv_tp_lu_cd", true, "");
	            				return;
	            			}
	            		} else if ( inv_amt > 0 ) { //--2015.03.19 KS.JO 금액 ZERO인 경우 제외 처리
	            			if ( inv_tp_lu_cd == "CREDIT" ) {
	            				ComShowCodeMessage("SAP00005", "positive number", "CREDIT");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
	            				sheetObj.SetCellValue(Row, prefix + "inv_tp_lu_cd","",0);
	            				sheetObj.SelectCell(Row, prefix + "inv_tp_lu_cd", true, "");
	            				return;
	            			}
	            		}
            		}
            		break;
            	//case prefix + "vndr_lgl_eng_nm":    // vndr_lgl_eng_nm
            	case prefix + "vndr_no":    		// vndr_no
            		if (Value == "") return;
            		var vndr_no=sheetObj.GetCellValue(Row, prefix + "vndr_no") ;
            		// Vendor Information
            		var vendorParam = "&value0=" + vndr_no +"&value2=N";  
                	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND03 + vendorParam);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				return;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml2, "vndr_lgl_eng_nm") ) {        					
        					ComShowCodeMessage("COM132201", "Supplier Code" );  
        					sheetObj.SetCellValue(Row,prefix + "vndr_no","");
        					sheetObj.SelectCell(Row, prefix + "vndr_no", true, "");
        					return false;				
        				} else { 
        					var inv_amt=sheetObj.GetCellValue(Row,  prefix +  "inv_amt");
                    	    inv_amt1=parseFloat(inv_amt);
                    	    if (inv_amt1 != 0 && inv_amt != "") { //금액이 0 인 경우 X(No payment Method도 가능)
	        					if (ComGetEtcData(sXml2, "pay_mzd_cd") == "X") {
	        						ComShowCodeMessage("SAP00083" ); 
	            					sheetObj.SetCellValue(Row,prefix + "vndr_no","");
	            					sheetObj.SelectCell(Row, prefix + "vndr_no", true, "");
	            					return false;
	        					} 
                    	    }
        					
	        				//clear
		                	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm","",0);
		                	sheetObj.SetCellValue(Row, prefix + "inv_term_nm","",0);
		                	sheetObj.SetCellValue(Row, prefix + "inv_curr_cd","",0);
		                	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd","",0);
		                	sheetObj.SetCellValue(Row, prefix + "sup_reg_no","",0);
		                	sheetObj.SetCellValue(Row, prefix + "bank_acct_flg","",0);
		                	sheetObj.SetCellValue(Row, prefix + "pay_mzd_lu_cd","",0);
		                	//setting
		                	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm",ComGetEtcData(sXml2, "vndr_lgl_eng_nm"));
		                	sheetObj.SetCellValue(Row, prefix + "inv_curr_cd",ComGetEtcData(sXml2, "inv_curr_cd"));
		                	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd",ComGetEtcData(sXml2, "inv_curr_cd"), 0);
		                	sheetObj.SetCellValue(Row, prefix + "inv_term_nm",ComGetEtcData(sXml2, "gen_pay_term_cd"), 0);
		                	sheetObj.SetCellValue(Row, prefix + "sup_reg_no",ComGetEtcData(sXml2, "rgst_no"),0);
		                	sheetObj.SetCellValue(Row, prefix + "bank_acct_flg",ComGetEtcData(sXml2, "bank_acct_flg"),0);
		                	sheetObj.SetCellValue(Row, prefix + "pay_mzd_lu_cd",ComGetEtcData(sXml2, "sap_pay_mzd_cd"),0);
        				}
                	}
                	// Liability Account Information 
                	var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND04 + "&value0=" + sheetObj.GetCellValue(Row, prefix + "vndr_no")  + "&value1=" + sheetObj.GetCellValue(Row, prefix + "ofc_cd") + "&value2=INVOICE" );
            		if (SAPDecideErrXml(sheetObj, sXml)) {
        				return;
        			} else { 
            			//clear
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_co_cd","",0);
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_rgn_cd","",0);
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_ctr_cd","",0);
	                	if (sheetObj.GetCellValue(Row, prefix + "liab_coa_acct_no") == "") { //2016.05.31 Account가 변경된 경우 Default값 처리 제외
	                		sheetObj.SetCellValue(Row, prefix + "liab_coa_acct_no","",0);
	                	}
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_inter_co_cd","",0);
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_vvd_cd","",0);
	                	sheetObj.SetCellValue(Row, prefix + "liab_cd_cmb_seq","",0);
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_co_cd",ComGetEtcData(sXml, "company_code"));
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_rgn_cd",ComGetEtcData(sXml, "region_code"));
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_ctr_cd",ComGetEtcData(sXml, "center_code"));
	                	if (sheetObj.GetCellValue(Row, prefix + "liab_coa_acct_no") == "") { //2016.05.31 Account가 변경된 경우 Default값 처리 제외
	                		sheetObj.SetCellValue(Row, prefix + "liab_coa_acct_no",ComGetEtcData(sXml, "account_code"));
	                	}
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_inter_co_cd",ComGetEtcData(sXml, "intercompany_code"));
	                	sheetObj.SetCellValue(Row, prefix + "liab_coa_vvd_cd",ComGetEtcData(sXml, "vvd_code"));
	                	sheetObj.SetCellValue(Row, prefix + "liab_cd_cmb_seq",ComGetEtcData(sXml, "cd_cmb_seq"));
        			}	
                    break;
            	case prefix + "ap_pay_grp_lu_cd":    // Pay Group
            		if (Value == "") return;
            		var param="&lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
            		var sXml2=sheetObj.GetSearchData("STM_SAP_0004GS.do", "f_cmd=" + SEARCH + param);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				return;
        			} else {      
        				if (Value != ComGetEtcData(sXml2, "lu_cd")) {        					
        					ComShowCodeMessage("COM132201", "Pay Group" );
        					SetCellValue(Row, Col, "");
                   		 	SelectCell(Row, Col, true, "");
        					return false;					
        				} 
        			} 
                	break;
            	case prefix + "inv_term_nm":    // Terms
            		if (Value == "") return;
            		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=AP TERMS&lu_cd="+Value);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Terms" );  
                		 SetCellValue(Row, Col, "");
                		 SelectCell(Row, Col, true, "");
     					return false;		
                	 } 
            		break;   
            	case prefix + "pay_mzd_lu_cd":    // Payment Method
            		if (Value == "") return;
            		var inv_amt=sheetObj.GetCellValue(Row,  prefix +  "inv_amt");
            	    inv_amt=parseFloat(inv_amt);
            		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=PAYMENT METHOD&lu_cd="+Value);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Payment Method" );
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					return false;		
                	} 
            		// ASA 처럼 Invoice amount가 0인 경우 Payment Method가 X인 경우 처리 가능, 그외의 경우 처리 불가
    				if (inv_amt != 0 && Value == "X") {
    					ComShowCodeMessage("SAP00083" ); 
    					SetCellValue(Row, Col, "");
               		 	SelectCell(Row, Col, true, "");
    					return false;
    				}
            		break;             		
            	case prefix + "attr_cate_nm":    // Evidence
            		if (Value == "") return;
            		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=EVIDENCE TYPE&lu_cd="+Value);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Evidence" );  
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					return false;		
                	 } 
            		break;   
            	case prefix + "liab_coa_co_cd":    //Company
            		if (Value == "") return;
            		var chkVal=SapGetCompany(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Company" );
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "liab_coa_rgn_cd":    //Region
            		if (Value == "") return;
            		var chkVal=SapGetRegion(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Region" );
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "liab_coa_ctr_cd":    //Center
            		if (Value == "") return;
            		var chkVal=SapGetCenter(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Center" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "liab_coa_acct_no":    //Account
            		if (Value == "") return;
            		var chkVal=SapGetAccount(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Account" );  
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	} 
            		var vvd_cd=sheetObj.GetCellValue(Row,  prefix +  "liab_coa_vvd_cd"); // account & vvd 조건 추가
            		if (vvd_cd != "") {
            			var chkVal2=SapGetVVD(sheetObj, vvd_cd, "COM", "CODE", Value);
                		if ( chkVal2 != vvd_cd ) {
                    		ComShowCodeMessage("COM132201", "VVD" );
                    		sheetObj.SetCellValue(Row,prefix + "liab_coa_vvd_cd","");
        					sheetObj.SelectCell(Row, prefix + "liab_coa_vvd_cd", true, "");
         					break;		
                    	 } 
            		}
            		break;  
            	case prefix + "liab_coa_inter_co_cd":    //Inter Company
            		if (Value == "") return;
            		var chkVal=SapGetInterCompany(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Inter Company" );
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "liab_coa_vvd_cd":    //VVD
            		if (Value == "") return;
            		var acct_cd=sheetObj.GetCellValue(Row,  prefix +  "liab_coa_acct_no"); // account 조건 추가
            		var chkVal=SapGetVVD(sheetObj, Value, "COM", "CODE", acct_cd);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "VVD" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            }
        }
        sheet1ChnFlag="Y";
        editMainRow=Row;
	}
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var param="";
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix + "ofc_cd":    //Office Code
                	param="?ofc_cd=" + sheetObj.GetCellValue(Row, Col);
                	ComOpenPopup("STM_SAP_0001.do" + param, 400, 430, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "vndr_lgl_eng_nm":    //Supplier Name
                	var param="?vndr_lgl_eng_nm="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col)) + "&delt_flg=N";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "vndr_no":    //Supplier code
                	var param="?vndr_seq=" + sheetObj.GetCellValue(Row, Col) + "&delt_flg=N";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "ap_pay_grp_lu_cd":    //Pay Group
                	var param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col))+"&attr_ctnt1=" + sheetObj.GetCellValue(Row, prefix1 + "ofc_cd");
                	ComOpenPopup("STM_SAP_0004.do" + param, 400, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "inv_term_nm":    //Terms
                	var param="?f_term=" + sheetObj.GetCellValue(Row, Col);
                	ComOpenPopup("STM_SAP_0033.do" + param, 480, 540, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "pay_mzd_lu_cd":    //Payment Method
                	param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col));
                	ComOpenPopup("STM_SAP_0007.do" + param, 500, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "liab_coa_vvd_cd":    //Liability Account
					var company=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_co_cd");
					var region=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_rgn_cd");
					var center=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_ctr_cd");
					var account=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_acct_no");
					var intercom=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_inter_co_cd");
					var vvd=sheetObj.GetCellValue(Row, prefix1 + "liab_coa_vvd_cd");
            		var param="?account_type=2%&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;  
            		param += "&lineType=MAIN"; 
            		param += "&vvdType=COM";
                	ComOpenPopup("STM_SAP_0021.do"+param, 450, 300, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  prefix + "attr_cate_nm":    //Evidence
                	var attr_cate_nm=sheetObj.GetCellValue(Row, prefix + "attr_cate_nm");
            		var param="?evidence_type=" + attr_cate_nm;
            		var ap_source_nm = sheetObj.GetCellValue(Row, prefix + "ap_inv_src_cd");
            		var attr_ctnt2 = sheetObj.GetCellValue(Row, prefix + "attr_ctnt2");
            		var attr_ctnt4 = sheetObj.GetCellValue(Row, prefix + "attr_ctnt4");
					param += "&ofc_cd=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "ofc_cd"));
					param += "&inv_seq=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "inv_seq"));
					param += "&inv_curr_cd=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "inv_curr_cd"));
					if (ap_source_nm == "" || ap_source_nm == "Manual Invoice Entry") {
						param += "&evidence_flag=MI";
					} else if (ap_source_nm == "AR") {
						if (attr_ctnt2 != "") {
							param += "&evidence_flag=AO";
						} else if (attr_ctnt4 != "") {
							param += "&evidence_flag=AR";
						}
					} else {
						param += "&evidence_flag=MI";
					}
					param += "&inv_type=N";
					param += "&chk_editable=" +  sheetObj.GetCellValue(Row, prefix + "chkEditable");
					param += "&ctnt2=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt2"));
					param += "&ctnt3=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt3"));
					param += "&ctnt4=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt4"));
					param += "&ctnt5=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt5"));
					param += "&ctnt6=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt6"));
					param += "&ctnt7=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt7"));
					param += "&ctnt8=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt8"));
					param += "&ctnt9=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt9"));
					param += "&ctnt11=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt11"));
					param += "&gctnt1=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt1"));
					param += "&gctnt13=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt13"));
					param += "&gctnt14=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt14"));
					param += "&gctnt15=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt15"));
					param += "&gctnt16=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt16"));
					param += "&gctnt17=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt17"));
					param += "&gctnt18=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "glo_attr_ctnt18"));
            		//계산서 등 나올때는 크기 500, 490 
                	ComOpenPopup("STM_SAP_0011.do" + param, 500, 350, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;	
                case  prefix + "inv_dt":
                	var cal=new ComCalendarGrid(prefix + "inv_dt");
                	cal.endFunction="ComCalendar_EndFunction_invDt";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');        			
                	break;
                case  prefix + "gl_dt": 
                	var cal=new ComCalendarGrid(ColSaveName(Col));
                	cal.endFunction="ComCalendar_EndFunction_gl_dt";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;
                case  prefix + "inv_term_dt": 
                	var cal=new ComCalendarGrid(ColSaveName(Col));
                	cal.endFunction="ComCalendar_EndFunction_inv_term_dt";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;
                case  prefix + "inv_xch_dt":                 	
                	var cal=new ComCalendarGrid(ColSaveName(Col));
                	cal.endFunction="ComCalendar_EndFunction_inv_xch_dt";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;
            }
        }
	}
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_invDt(){
		with(sheetObjects[0]) {
			sheet1_OnChange(sheetObjects[0], GetSelectRow(), SaveNameCol(prefix1+"inv_dt"), GetCellValue(GetSelectRow(), prefix1+"inv_dt"));
		}
	}	
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_gl_dt(){
		with(sheetObjects[0]) {
			sheet1_OnChange(sheetObjects[0], GetSelectRow(), SaveNameCol(prefix1+"gl_dt"), GetCellValue(GetSelectRow(), prefix1+"gl_dt"));
		}
	}	
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_inv_term_dt(){
		with(sheetObjects[0]) {
			sheet1_OnChange(sheetObjects[0], GetSelectRow(), SaveNameCol(prefix1+"inv_term_dt"), GetCellValue(GetSelectRow(), prefix1+"inv_term_dt"));
		}
	}
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_inv_xch_dt(){
		with(sheetObjects[0]) {
			sheet1_OnChange(sheetObjects[0], GetSelectRow(), SaveNameCol(prefix1+"inv_xch_dt"), GetCellValue(GetSelectRow(), prefix1+"inv_xch_dt"));
		}
	}
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        //if (ErrMsg != "") return;
        //ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    }	
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */	    
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
		var prefix1=sheetObjects[0].id + "_";
        with (sheetObj) {
            switch (ColSaveName(Col)) {
	            case prefix + "line_tp_lu_cd":    // TYPE
	            	if (Value == "") return;
	            	var line_type=sheetObj.GetCellValue(Row, prefix + "line_tp_lu_cd");
	            	if ("TAX" == line_type ) { 
	            		//sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no","111821",0);
	            		if( SAPFindText(sheetObj,prefix + "line_tp_lu_cd", "TAX" )  == Row ) {
	            			if(OFC_COUNTRY == NATIVE_COUNTRY) {
	            				sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no", TAX_ACCOUNT, 0) ; // opus 111811 kam 125201
		            		} else {
		            			sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no", OVERSAES_TAX_ACCOUNT, 0) ; // opus 111821 kam 125201
		            		}
	            		} else {
	            			ComShowCodeMessage("SAP00058");  //  Entry tax already exists. You can't select Tax Item.
	            			sheetObj.SetCellValue(Row, prefix + "line_tp_lu_cd") = "";
	            		}	            		
	            	} else {
	            		sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no","",0);
	            	}
	            	break;
                case prefix + "acctg_dt":    // gl_date
                        if (Value == "") return;
                	var mainRow=sheetObjects[0].GetSelectRow();
                	var h_gl_dt=ComReplaceStr( sheetObjects[0].GetCellValue(mainRow, prefix1 + "gl_dt"), "-", "");
                	var l_gl_dt=ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "acctg_dt"), "-", "");
        			if (h_gl_dt.substring(0,6) != l_gl_dt.substring(0,6) ) {
        				ComShowCodeMessage("SAP00006", "Line GL Date month", "Header GL Date month" );   //"There is no updated data to save."
        				sheetObj.SetCellValue(Row, prefix2 + "acctg_dt", "");
        				sheetObj.SelectCell(Row, prefix2 + "acctg_dt", true, "");
        				return false;
        			} else {
        				changeOfcAndGlDate(sheetObj, Row, Col);
        			}
                	break;
                case prefix + "dtrb_amt":    // Line Amount
                	if (Value == "") return;
                	var formObj=document.form;
                	var mainRow=sheetObjects[0].GetSelectRow();
                	var inv_curr_cd=sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "inv_curr_cd");
            		var f_curr_cd=formObj.hid_func_curr_cd.value;
            		var f_curr_prcs=ComNullToZero(formObj.hid_func_curr_prcs.value);	
            		var point=f_curr_prcs;
            		var dtrb_amt=sheetObj.ComputeSum("|"+prefix2 + "dtrb_amt" +"|", Row, Row);
            		var lineType=sheetObj.GetCellValue(Row, prefix2 + "line_tp_lu_cd");
            		if( "ITEM" == lineType ) {
            			if(dtrb_amt < 0) {
            				ComShowCodeMessage("SAP00060" );   // You must input positive number at Line Amount when the line type is ITEM.
            				sheetObj.SetCellValue(Row, prefix2 + "dtrb_amt", "")
            				sheetObj.SelectCell(Row, prefix2 + "dtrb_amt", true, "");
            				return;
            			}
            		}

            		if (EXRATE_RULE == "LINE") {
                		chkXRateLine(prefix + "dtrb_amt", Row);
                	}

            		if ( f_curr_cd != inv_curr_cd ) {
        				var inv_xch_rt=parseFloat ( sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_xch_rt") ) ; //Line으로 추후 바꾸이어할지 체크 부분
						var inv_curr_prcs=parseInt(ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_prcs")));
            			point=inv_curr_prcs;
            			sheetObj.SetCellValue(Row, prefix2 + "dtrb_amt",SAPComAddComma2( ComRound(dtrb_amt, point) + '', point) ,0);
            			sheetObj.SetCellValue(Row, prefix2 + "dtrb_func_amt",SAPComAddComma2( SAPComRound(dtrb_amt * inv_xch_rt, f_curr_prcs) + '', f_curr_prcs) ,0);
            		} else {
            			sheetObj.SetCellValue(Row, prefix2 + "dtrb_amt",SAPComAddComma2( ComRound(dtrb_amt, point) + '', point) ,0);
            			sheetObj.SetCellValue(Row, prefix2 + "dtrb_func_amt",sheetObj.GetCellValue(Row, prefix2 + "dtrb_amt"),0);
            		}
                	break;		
                /*case prefix + "dtrb_coa_acct_no":    // account
                	var lineType=sheetObj.GetCellValue(Row, prefix2 + "line_tp_lu_cd");
                	if( "ITEM" == lineType ) {
                		if ( "1" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1)) {
    						ComShowCodeMessage("SAP00007", "Expense Account", "1"); 
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						return false;
    					}  
                    	//미결계정여부 체크 
                		var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND05 + "&value0=" + sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no"));
                    	if (SAPDecideErrXml(sheetObj, sXml)) {
                			return false;
                        } else {
                        	var pndTgtFlg=ComGetEtcData(sXml, "pnd_tgt_flg");
                        	if (pndTgtFlg != "Y") {
                        		ComShowCodeMessage("SAP00033"); 
                        		sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
                        		sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
                        		return false;
                        	} 
                        } 
                	} else if( "MISCELLANEOUS" == lineType ) {
                		if ( "5" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1) && "9" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1) ) {
    						ComShowCodeMessage("SAP00007", "Expense Account", "5 or 9"); 
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						return false;
    					}  
                	} else if( "TAX" == lineType ) {
                		if ( (TAX_ACCOUNT != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no")) && (OVERSAES_TAX_ACCOUNT != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no")) ) {
    						ComShowCodeMessage("SAP00006", "Tax Expense Account", TAX_ACCOUNT + ' or ' + OVERSAES_TAX_ACCOUNT);
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						return false;
    					} 
                	}
                	break;	*/
                case prefix + "dtrb_coa_co_cd":    //Company
            		var chkVal=SapGetCompany(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Company" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "dtrb_coa_rgn_cd":    //Region
            		var chkVal=SapGetRegion(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Region" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "dtrb_coa_ctr_cd":    //Center
            		var chkVal=SapGetCenter(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Center" );  
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		break;  
            	case prefix + "dtrb_coa_acct_no":    //Account
            		var chkVal=SapGetAccount(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Account" );  
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					break;		
                	 } 
            		var lineType=sheetObj.GetCellValue(Row, prefix2 + "line_tp_lu_cd");
                	if( "ITEM" == lineType ) {
                		if ( "1" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1)) {
    						ComShowCodeMessage("SAP00007", "Expense Account", "1"); 
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						break;	
    					}  
                    	//미결계정여부 체크 
                		var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND05 + "&value0=" + sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no"));
                    	if (SAPDecideErrXml(sheetObj, sXml)) {
                			return false;
                        } else {
                        	var pndTgtFlg=ComGetEtcData(sXml, "pnd_tgt_flg");
                        	if (pndTgtFlg != "Y") {
                        		ComShowCodeMessage("SAP00033"); 
                        		sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
                        		sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
                        		break;	
                        	} 
                        } 
                	} else if( "MISCELLANEOUS" == lineType ) {
                		if ( "5" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1) && "9" != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no").substring(0,1) ) {
    						ComShowCodeMessage("SAP00007", "Expense Account", "5 or 9");   
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						break;	
    					}  
                	} else if( "TAX" == lineType ) {
                		if ( (TAX_ACCOUNT != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no")) && (OVERSAES_TAX_ACCOUNT != sheetObj.GetCellValue(Row, prefix2 + "dtrb_coa_acct_no")) ) {
    						ComShowCodeMessage("SAP00006", "Tax Expense Account", TAX_ACCOUNT + ' or ' + OVERSAES_TAX_ACCOUNT);
    						sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_acct_no", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_acct_no", true, "");
    						break;	
    					} 
                	}
                	var vvd_cd=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_vvd_cd");  // Account & Common VVD 처리 조건 추가
                	if(vvd_cd != "") {
                		var mainRow=sheetObjects[0].GetSelectRow();
                		var ap_source_nm = sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "ap_inv_src_cd");
                		var vvd_type = "";
                		if (ap_source_nm == "" || ap_source_nm == "Manual Invoice Entry") {
                			vvd_type = "ACT";
                		} else {
                			vvd_type = "COM";
                		}
                		var chkVal2=SapGetVVD(sheetObj, vvd_cd, vvd_type, "CODE", Value);
                		if ( chkVal2 != vvd_cd ) {
                    		ComShowCodeMessage("COM132201", "VVD" );
                    		sheetObj.SetCellValue(Row, prefix2 + "dtrb_coa_vvd_cd", "");
    						sheetObj.SelectCell(Row, prefix2 + "dtrb_coa_vvd_cd", true, "");
    						break;		
                    	} 
                	}
                	break;	
            	case prefix + "dtrb_coa_inter_co_cd":    //Inter Company
            		if (Value == "") return;
            		var chkVal=SapGetInterCompany(sheetObj, Value, "CODE");
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Inter Company" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
                		break;  	
                	 } 
            		break;  
            	case prefix + "dtrb_coa_vvd_cd":    //VVD
            		var mainRow=sheetObjects[0].GetSelectRow();
            		if (Value == "") return;
            		var ap_source_nm = sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "ap_inv_src_cd");
            		var vvd_type = "";
            		if (ap_source_nm == "" || ap_source_nm == "Manual Invoice Entry") {
            			vvd_type = "ACT";
            		} else {
            			vvd_type = "COM";
            		}
            		var acct_cd=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_acct_no");  // Account 조건 추가
            		var chkVal=SapGetVVD(sheetObj, Value, vvd_type, "CODE", acct_cd);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "VVD" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
                		break;  		
                	}
            		if((sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "attr_cate_nm") == "ETC") || (sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "attr_cate_nm") == "INVOICES")) {
            			var vvd=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_vvd_cd");
    					var slane_cd = "";
    					if (vvd.length > 0) {
    						var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + vvd );
    						if (SAPDecideErrXml(sheetObj, xmlStr)) {
    							null;
    			            } else {
    			                slane_cd=ComGetEtcData(xmlStr, "service_lane");
    			                if ( slane_cd == "NO_DATA") {
    			                	slane_cd="COM";
    			                }
    			            }
    						//if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt14") == "" ) {
    						if (sheetObj.GetCellValue(Row, prefix+"ibflag") != "R") {
    							sheetObj.SetCellValue(Row, prefix + "attr_ctnt14", slane_cd);
            				}
    					}
            		}
            		break;  	
                case prefix + "dtrb_vat_cd":    // Tax Code
                	var sText=sheetObj.GetComboInfo(Row, Col, "Text");
    				var arrText=sText.split("|");
    				var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
    				var vText=arrText[idx].split("\t");
    				if (idx == 0 ) { 
    					sheetObj.SetCellValue(Row, prefix + "dtrb_vat_nm","");
    					sheetObj.SetCellValue(Row, prefix + "dtrb_vat_rt","");
    				} else {
    					sheetObj.SetCellValue(Row, prefix + "dtrb_vat_nm",vText[1]);
    					sheetObj.SetCellValue(Row, prefix + "dtrb_vat_rt",ARR_LINE_TAX_RATE[idx]);
    				}
                	break;
                	
                case prefix + "attr_ctnt11":    // Activity Date
            		
                	if (EXRATE_RULE == "LINE") {
                		chkXRateLine(prefix + "attr_ctnt11", Row);
                	}

                	break;
            }
        }
	}	
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet2_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var param="";
		var prefix1=sheetObjects[0].id + "_";
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix + "dtrb_coa_vvd_cd":    //Account
					var company=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_co_cd");
					var region=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_rgn_cd");
					var center=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_ctr_cd");
					var account=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_acct_no");
					var intercom=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_inter_co_cd");
					var vvd=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_vvd_cd");
					var line_type=sheetObj.GetCellValue(Row, prefix + "line_tp_lu_cd");
					var ap_source_nm = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  prefix1 +  "ap_inv_src_cd");
            		var vvd_type = "";
            		if (ap_source_nm == "" || ap_source_nm == "Manual Invoice Entry") {
            			vvd_type = "ACT";
            		} else {
            			vvd_type = "COM";
            		}
            		if ("ITEM" == line_type) line_type="PREPAY_ITEM"; 
            		var param="?account_type=5%&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;  
            		param += "&lineType=" + line_type;
            		param += "&vvdType=" + vvd_type;
            		ComOpenPopup("STM_SAP_0021.do"+param, 450, 300, "setPopupData2", "0,0", true, false, Row, Col, 1);
                	break;
                case  prefix + "attr_ctnt3":    //LOCATION	
                	if (sheetObj.GetCellValue(Row, prefix + "dtrb_coa_acct_no") == "" ) {
        				ComShowCodeMessage("COM12113", "Line Account");
        				sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no", "");
        				sheetObj.SelectCell(Row, prefix + "dtrb_coa_acct_no", true, "");
        				return false;				
        			}
                	var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND03 + "&value0=" + sheetObj.GetCellValue(Row, prefix + "dtrb_coa_acct_no") );
        			if (SAPDecideErrXml(sheetObj, sXml)) {
        				return;
        			} else {
        				var chk_acct=ComTrim(ComGetEtcData(sXml, "chk_account"));
        				var url="STM_SAP_0024.do";
        				var param="";
        				var pwidth="500";
        				var pheight="300";
        				var loc_cd="";
        				var ofc_code="";
        				var invoice_date="";
        				var service_lane="";
        				if( null ==  chk_acct || "" ==  chk_acct  || undefined ==  chk_acct ) {      	  url="STM_SAP_0024.do";
        				} else if ( "AP_ASSET_ACCT" ==  chk_acct ) {          url="STM_SAP_0026.do"; pwidth="500"; pheight="320";
        				} else if ( "AP_CLAIM_ACCT" ==  chk_acct ) {          url="STM_SAP_0027.do"; pwidth="500"; pheight="320";
        				} else if ( "AP_ENTERTAINMENT_ACCT" ==  chk_acct ) {  url="STM_SAP_0025.do"; pwidth="620"; pheight="550";
        				} else if ( "AP_OVERSEAS_ACCT" ==  chk_acct ) {		  url="STM_SAP_0029.do"; pwidth="500"; pheight="320";
        				} else if ( "AP_PREPAID_EXPENSE_ACCT" ==  chk_acct ) {url="STM_SAP_0028.do"; pwidth="500"; pheight="490";
        				} else if ( "AP_IO_OWNERS_ACCOUNT" ==  chk_acct ) {   url="STM_SAP_0041.do"; pwidth="500"; pheight="450";
        				} else if ( "AP_EQ_CLAIM_ACCOUNT" ==  chk_acct ) {    url="STM_SAP_0042.do"; pwidth="500"; pheight="340";
        				} else if ( "AP_IO_ACCOUNT" ==  chk_acct ) {          url="STM_SAP_0043.do"; pwidth="500"; pheight="320";
        				}
        				if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt3") == "" ) {
        					loc_cd=formObj.hid_login_loc_cd.value;
        				} else {
        					loc_cd=sheetObj.GetCellValue(Row, prefix + "attr_ctnt3");
        				}
        				var svc_lane_enable = "ACT"; //2015.11.05 KS.JO Service Lane item of Location Popup is setting to enable or disable
        				if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "attr_cate_nm") == "ETC") {
        					var vvd2=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_vvd_cd");
        					var slane_cd2 = "";
        					if (vvd2.length > 0) {
        						var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + vvd2 );
        						if (SAPDecideErrXml(sheetObj, xmlStr)) {
        							null;
        			            } else {
        			                slane_cd2=ComGetEtcData(xmlStr, "service_lane");
        			                if ( slane_cd2 == "NO_DATA") {
        			                	slane_cd2="CNT";
        			                }
        			            }
        					}
        					if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt12") == "" ) {
        						ofc_code=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "ofc_cd");
            				} else {
            					ofc_code=sheetObj.GetCellValue(Row, prefix + "attr_ctnt12");
            				}
        					if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt11") == "" ) {
        						invoice_date=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "inv_dt");
            				} else {
            					invoice_date=sheetObj.GetCellValue(Row, prefix + "attr_ctnt11");
            				}
        					if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt14") == "" ) {
        						service_lane=slane_cd2;
            				} else if ((slane_cd2 != sheetObj.GetCellValue(Row, prefix + "attr_ctnt14")) && sheetObj.GetCellValue(Row, prefix+"ibflag") != "R" ) { //2015.11.05
            					service_lane=slane_cd2;
            					//service_lane=sheetObj.GetCellValue(Row, prefix + "attr_ctnt14");
            				} else {
            					service_lane=sheetObj.GetCellValue(Row, prefix + "attr_ctnt14");
            				}
        				} else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "attr_cate_nm") == "INVOICES") {
        					var vvd=sheetObj.GetCellValue(Row, prefix + "dtrb_coa_vvd_cd");
        					var slane_cd = "";
        					if (vvd.length > 0) {
        						var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + vvd );
        						if (SAPDecideErrXml(sheetObj, xmlStr)) {
        							null;
        			            } else {
        			                var slane_cd=ComGetEtcData(xmlStr, "service_lane");
        			                if ( slane_cd == "NO_DATA") {
        			                	slane_cd="CNT";
        			                }
        			            }
        						if ( sheetObj.GetCellValue(Row, prefix + "attr_ctnt14") == "" ) {
        							service_lane=slane_cd;
        						} else if ((slane_cd != sheetObj.GetCellValue(Row, prefix + "attr_ctnt14")) && sheetObj.GetCellValue(Row, prefix+"ibflag") != "R" ) {  //2015.11.05
        							service_lane=slane_cd; // R인 경우를 제외한 Service Lane 반영 처리
        							//service_lane=sheetObj.GetCellValue(Row, prefix + "attr_ctnt14");
        						} else {
                					service_lane=sheetObj.GetCellValue(Row, prefix + "attr_ctnt14");
                				}
        					}
        				}
						param=param + "?reqHType=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "attr_cate_nm");
						param += "&chk_editable=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "chkEditable");
						param += "&chk_svc_editable=" + svc_lane_enable; //2015.11.05 KS.JO service lane enable or disable
						param += "&attr1=" +  encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt1"));
						param += "&attr2="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt2"));
        				param += "&attr3="  + loc_cd;
						param += "&attr4="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt4"));
						param += "&attr5="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt5"));
						param += "&attr6="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt6"));
						param += "&attr7="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt7"));
						param += "&attr8="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt8"));
						param += "&attr9="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt9"));
						param += "&attr10="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt10"));
						if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "attr_cate_nm") == "ETC") {
							param += "&attr11="  + invoice_date;
							param += "&attr12="  + ofc_code;
							param += "&attr13="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt13"));
							param += "&attr14="  + service_lane;
						} else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "attr_cate_nm") == "INVOICES") {
							param += "&attr11="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt11"));
							param += "&attr12="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt12"));
							param += "&attr13="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt13"));
							param += "&attr14="  + service_lane;
						} else {
							param += "&attr11="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt11"));
							param += "&attr12="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt12"));
							param += "&attr13="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt13"));
							param += "&attr14="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt14"));
						}
						param += "&attr15="  + encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "attr_ctnt15"));
        				ComOpenPopup(url+param, pwidth, pheight, "setPopupData2", "0,0", true, false, Row, Col, 1);
        			}
                	break;
        		case  prefix + "acctg_dt":    //Gl Date	
        			var cal=new ComCalendarGrid(prefix + "acctg_dt");
        			cal.endFunction="ComCalendar_EndFunction_acctgDt";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;
            }
		}
	}
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {		
		var prefix=sheetObj.id + "_";
		var prefix1=sheetObjects[0].id + "_";
		if ( sheetObj.RowCount()> 0 ) {
			//alert(sheetObjects[0].GetCellValue(1, "sheet1_chkEditable") );
			if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"chkEditable") == "N") {
				sheetObjects[1].SetEditable(1);
				for(var i=1; i <= sheetObj.RowCount(); i++) {
					var colcnt=sheetObj.LastCol();
					for(var j=0; j <= colcnt; j++) {
						if (sheetObj.ColSaveName(j) == prefix+"attr_ctnt3") {
							sheetObj.SetCellEditable(i, j,1);
							sheetObj.InitCellProperty(i, j,{ Type:"Popup",Align:"Center",Format:""} );
							sheetObj.SetCellBackColor(i, j,"#EFF0F300");
						} else {
							sheetObj.SetCellEditable(i, j,0);
						}
					}
				}
			} else {
				sheetObjects[1].SetEditable(1);
			}
		}
	}		
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_acctgDt(){
		with(sheetObjects[1]) {
			sheet2_OnChange(sheetObjects[1], GetSelectRow(), SaveNameCol(prefix2+"acctg_dt"), GetCellValue(GetSelectRow(), prefix2+"acctg_dt"));
		}
	}
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet3_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var param="";
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix + "pay_mzd_lu_cd":    //Payment Method
                	param="?lu_cd=" + encodeURIComponent(sheetObj.GetCellValue(Row, Col));
                	ComOpenPopup("STM_SAP_0007.do" + param, 500, 420, "setPopupData3", "0,0", true, false, Row, Col, 2);
                	break;
                case  prefix + "remit_vndr_no":    //Remit to Supplier Code
                	var mainRow=sheetObjects[0].GetSelectRow();
                	param="?bank_acct_tp_nm=SUPPLIER&call_flag=INVOICE&vndr_seq=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no") +"&curr_cd="  + sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_cd") ;
                	ComOpenPopup("STM_SAP_0032.do" + param, 500, 420, "setPopupData3", "0,0", true, false, Row, Col, 2);
                	break;
                case  prefix + "due_dt":    //Due Date
                	var cal=new ComCalendarGrid();
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;
            }
		}
	}
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */	    
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
		var prefix1=sheetObjects[0].id + "_";
        with (sheetObj) {
            switch (ColSaveName(Col)) {
	            case prefix + "pay_grs_amt":    
	            	sheetObj.SetCellValue(Row, prefix + "pay_rmn_amt",sheetObj.GetCellValue(Row, prefix + "pay_grs_amt"),0);
	            	break;
	            case prefix + "pay_mzd_lu_cd":     	
            		var chkVal=chkLookupOneData(sheetObj, "&lu_tp_cd=PAYMENT METHOD&lu_cd="+Value);
            		if ( chkVal != Value ) {
                		ComShowCodeMessage("COM132201", "Payment Method" ); 
                		SetCellValue(Row, Col, "");
                		SelectCell(Row, Col, true, "");
     					return false;		
                	 }
            		break;
	            case prefix + "remit_vndr_no":     	
	            	var param = "&value0=" + Value + "&value2=N";  
                	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND03 + param);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				return;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml2, "vndr_seq") ) {        					
        					ComShowCodeMessage("COM132201", "Remit Supplier Code" ); 
        					sheetObj.SetCellValue(Row, prefix + "remit_vndr_no", "");
        					sheetObj.SelectCell(Row, prefix + "remit_vndr_no", true, "");
        					return false;				
        				} 
        			}
            		break;	
            }
        }
	}
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {		
		var prefix=sheetObj.id + "_";
		var prefix1=sheetObjects[0].id + "_";
		if ( sheetObj.RowCount()> 0 ) {
			if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"pay_sts_flg") == "Y" || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"pay_sts_flg") == "P" ) {
				sheetObjects[2].SetEditable(0);
			} else {
				sheetObjects[2].SetEditable(1);
			}
		}
	}	
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(!validateForm(sheetObj,formObj,sAction)){
			return false;
		}
		switch (sAction) {
			case IBSEARCH: // RETRIEVE 
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch("STM_SAP_0240GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), {Sync:2} );
				//var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				//sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case SEARCHLIST01: // RETRIEVE LINE (TAB)
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;	
			case SEARCHLIST02: // RETRIEVE PAYMENTS SCHEDULED (TAB)
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;		
			case COMMAND01: // RETRIEVE AP OFFICE
				var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH01);
				var apLoginOfc=ComGetEtcData(sXml, "ap_ofc_cd");
				this.apLoginCurr=ComGetEtcData(sXml, "ar_curr_cd");
				var apLoginLoc=ComGetEtcData(sXml, "loc_cd");
				formObj.ofc_cd.value=apLoginOfc;
				formObj.hid_login_curr_cd.value=apLoginCurr;
				formObj.hid_login_ap_ofc.value=apLoginOfc;
				formObj.hid_login_loc_cd.value=apLoginLoc;
				var localTime=SapGetLocDate(sheetObj);
				var localStartTime=localTime.substr(0,6) + "01";
				formObj.inv_fr_dt.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.inv_to_dt.value=ComGetMaskedValue(localTime, "ymd");
				formObj.hid_local_sysdate.value=localTime;
				var tmpArray=SapGetFunctionalCurrencyCode(sheetObj);
				formObj.hid_func_curr_cd.value=tmpArray[0];
				formObj.hid_func_curr_prcs.value=tmpArray[1];
				//Condition - Currency
		 		var currComboItems=SapGetCurrComboItems(sheetObjects[0], "");
		 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " "); 
		 		//Button disable
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_cancel");
				ComBtnDisable("btn_print");
				ComBtnDisable("btn_apply");
				break;
			case IBSAVE: // SAVE
				formObj.f_cmd.value=MULTI01;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				if(sParam2 == "" ){
					return;
				}
				var sParam3=ComGetSaveString(sheetObjects[2], true, true);
				if(sParam3 == "" ){
					return;
				}
				var sParam=sParam1 + "&" + sParam2 + "&" + sParam3 + "&" +FormQueryString(formObj);

				var sXml="";
				ComOpenWait(true);
				setTimeout( function () {
					sXml=sheetObj.GetSaveData("STM_SAP_0240GS.do", sParam);
					//sheetObjects[1].LoadSaveData(sXml,{Sync:1} ); 
					//sheetObj.LoadSaveData(sXml,{Sync:1} );
					SapOpenWait(false,true);  
					this.save_inv_seq=ComGetEtcData(sXml, "inv_seq");
					if (SAPDecideErrXmlSave(sheetObj, sXml)) { 
						return ;
					} else {
						ComShowCodeMessage("COM130102", "Data"); 
						//doActionIBSheet(sheetObj, document.form, IBSEARCH);
					}
				} , 100);
				
				setTimeout( function () {
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != undefined && ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "F" ) {
						//ComShowCodeMessage("COM130102", "Data"); 
						doActionIBSheet(sheetObj, document.form, IBSEARCH);
					}
				} , 100); 

				break;

			case IBDELETE: // DELETE
				var row=sheetObj.GetSelectRow();
				var csr_no=sheetObj.GetCellValue(row, prefix + "inv_no");
                if (ComShowCodeConfirm("COM12165", "[" + csr_no + "]")) {    // Do you want to delete {?msg1}?
                    ComOpenWait(true);
                    formObj.f_cmd.value=REMOVE01;
                    sheetObj.DoAllSave("STM_SAP_0240GS.do", FormQueryString(formObj));
                    ComOpenWait(false);
                    doActionIBSheet(sheetObj, document.form, IBSEARCH);
                }
                break;
			case MULTI02: // Cancel
				var row=sheetObj.GetSelectRow();
				var csr_no=sheetObj.GetCellValue(row, prefix + "inv_no");
                if (ComShowCodeConfirm("SAP00013", "[" + csr_no + "]")) {    // Do you want to cancel {?msg1}?
                    ComOpenWait(true);
                    formObj.f_cmd.value=MULTI02;
                    sheetObj.DoAllSave("STM_SAP_0240GS.do", FormQueryString(formObj));
                    ComOpenWait(false);
                    this.save_inv_seq=sheetObj.GetCellValue(row, prefix + "inv_seq");
    				doActionIBSheet(sheetObj, document.form, IBSEARCH);
                }
                break; 
			case RDPRINT:	//Print
				formObj.f_cmd.value=PRINT;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}  
                var sParam=sParam1 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("STM_SAP_0240GS.do", sParam);
				ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;
				var print_seq=ComGetEtcData(sXml, "INV_RQST_SEQ");
				rdOpen(formObj, print_seq);
		        break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(formObj.ofc_cd.value == ""){
					ComShowCodeMessage("COM12113", "Office");
					ComSetFocus(document.all.item("ofc_cd"));
					return false;
				}
				if(formObj.inv_fr_dt.value == ""){
					ComShowCodeMessage("COM12113", "From Inv Date");
					ComSetFocus(document.all.item("inv_fr_dt"));
					return false;
				}
				if(formObj.inv_to_dt.value == ""){
					ComShowCodeMessage("COM12113", "To Inv Date");
					ComSetFocus(document.all.item("inv_to_dt"));
					return false;
				}
				var frDt1=ComReplaceStr(formObj.inv_fr_dt,"-","");
				var toDt1=ComReplaceStr(formObj.inv_to_dt,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.inv_to_dt.focus();
					return false;
				}
				var frDt2=ComReplaceStr(formObj.gl_fr_dt,"-","");
				var toDt2=ComReplaceStr(formObj.gl_to_dt,"-","");
				if (ComGetDaysBetween(frDt2, toDt2) < 0){
					ComShowCodeMessage("COM132002");
					formObj.gl_to_dt.focus();
					return false;
				}
				break;
			case IBSAVE: //SAVE
				if (!ComChkValid(formObj)) return false;
				if (sheet1ChnFlag == "Y" || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true ) {
					var prefix1=sheetObjects[0].id + "_";
					var prefix2=sheetObjects[1].id + "_";
					var prefix3=sheetObjects[2].id + "_";
				  	//validate header, 필수항목 및 business logic 
					if ( !chkValidHeader() ) return false;
					//Line 필수항목체크 
					var sParam2=ComGetSaveString(sheetObjects[1], true, true);
					if(sParam2 == "" ){
						return false;
					}
					var mainRow=sheetObjects[0].GetSelectRow();
					//Amount Check
					//var hInvAmt=parseFloat(sheetObjects[0].ComputeSum("|"+prefix1 + "inv_amt" +"|", mainRow, mainRow));
					var hInvAmt=parseFloat( ComReplaceStr( sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_amt"), ",", "") );
					var lineSum=sheetObjects[1].GetSumValue(0,prefix2 + "dtrb_amt");
					if ( hInvAmt != lineSum ) {
						ComShowCodeMessage("SAP00006", "line amount's Total("+lineSum+")" ,  "Invoice amount("+hInvAmt+")" );   //[{?msg1}] should be equal to [{?msg2].
						return false;
					}
					
					if (!changeOfcAndGlDate(sheetObjects[0], mainRow, prefix1 + "gl_dt")) {
		    			return false;
		    		}
					
					// Check Gl Date, Inv Date
					var hGlDt=ComReplaceStr( sheetObjects[0].GetCellValue(mainRow, prefix1 + "gl_dt"), "-", "");
					var hXchDt=ComReplaceStr( sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_xch_dt"), "-", "");
					var hGlMonth="";
					if (hGlDt != "" && hXchDt != "" ) {
						hGlMonth=hGlDt.substring(0,6);
						if (hGlDt.substring(0,6) != hXchDt.substring(0,6) ) {
							ComShowCodeMessage("SAP00006", "GL Date" ,  "Exchange Date" ); 
							return false;
						}
					} 
					hGlMonth=hGlDt.substring(0,6);
					for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
						var dGlDt=ComReplaceStr( sheetObjects[1].GetCellValue(i, prefix2 + "acctg_dt"), "-", "").substring(0,6);
						if (dGlDt != hGlMonth) {
							ComShowCodeMessage("SAP00006", "Header's GL Date month" ,  "Line's GL Date month" ); 
							return false;
						}
					}
					
					//Exchange Rate Check
					if ( !chkXRate("inv_xch_dt", mainRow) ) { 
						return false; 
					} 
					
					var hEviType=sheetObjects[0].GetCellValue(mainRow, prefix1 + "attr_cate_nm");
					if ("TAX" == hEviType ) {
						var dTaxRow=sheetObjects[1].FindText(prefix2 + "line_tp_lu_cd", "Tax", 0);
						if (dTaxRow == -1 ) {
							ComShowCodeMessage("SAP00011"); 
							return false;
						} 
					}
					
					// AR Evidence check
					if(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_seq") == "" && (("REFUND" == hEviType) || ("ARAPOFFSET" == hEviType)) ) {
						ComShowCodeMessage("SAP00069"); 
						sheetObjects[0].SetCellValue(mainRow, prefix1 + "attr_cate_nm", "");
						sheetObjects[0].SelectCell(mainRow, prefix1 + "attr_cate_nm", true, "");
						return false;
					}

					// Region of ({?msg1})office and country of ({?msg2})vendor are different. Please use the same region.
					var param="&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd");
					param +=  "&value1=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no");
					var sXml=sheetObjects[0].GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND11 + param);
					if(SAPDecideErrXml(sheetObjects[0], sXml)) {
						return false;
					} else {
						if ( "N" == ComGetEtcData(sXml, "enable_flg") ) {
	       					 ComShowCodeMessage("SAP00079", sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd"), sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no") );  
	       					 sheetObjects[0].SetCellValue(mainRow, prefix1 + "vndr_no", "");
	       					 sheetObjects[0].SelectCell(mainRow, prefix1 + "vndr_no", true, "");
	       					 return false;
	       				 }
					}
					
					//Payment Method Name 가져오기
            		var sText=sheetObjects[0].GetComboInfo(mainRow, prefix1 + "pay_mzd_lu_cd", "Text");
    				var arrText=sText.split("|");
    				var idx=sheetObjects[0].GetComboInfo(mainRow, prefix1 + "pay_mzd_lu_cd", "SelectedIndex");
    				var vText=arrText[idx].split("\t");
    				if (idx == 0 ) { 
    					PaymentMethodName = "";
    				} else {
    					PaymentMethodName = vText[1];
    				}
    				
					// Payment Method(M:TT)와 Vendor의 Bank Account Flag 값 존재 여부 validation  2016.03.02
					var hpaymentMethod=sheetObjects[0].GetCellValue(mainRow, prefix1 + "pay_mzd_lu_cd");
					var hbankacctflag=sheetObjects[0].GetCellValue(mainRow, prefix1 + "bank_acct_flg");
					if(hpaymentMethod == "M") {
						if(hbankacctflag != "Y") {
							ComShowCodeMessage("SAP00081", PaymentMethodName, sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no") );  
	       					return false;
						}
					} else if (hpaymentMethod == "N") { //ACH Payment Method
						// In case of [{?msg1}] Payment method, Currency of CSR and Local Curr of Vendor[{?msg2}] must have same. Please use same Currency.
						var param="&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no");
						param +=  "&value1=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_cd");
						param +=  "&value2=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_acct_no");
						var sXml=sheetObjects[0].GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND12 + param);
						if(SAPDecideErrXml(sheetObjects[0], sXml)) {
							return false;
						} else {
							if (sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "inv_curr_cd") != ComGetEtcData(sXml, "local_currency")) {
								ComShowCodeMessage("SAP00082", PaymentMethodName, sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no") );  
		       					 return false;
		       				 }
						}
					} else if (hpaymentMethod == "X") { //X No Payment Method
						//Header amount check
	    				var HeaderInvAmt = sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_amt");
	    				if (HeaderInvAmt != 0) {
	    					ComShowCodeMessage("SAP00083"); 
        					sheetObj.SetCellValue(mainRow, prefix1 + "vndr_no","");
        					sheetObj.SelectCell(mainRow, prefix1 + "vndr_no", true, "");
        					return false;
	    				}
					}
					
					if ("INVOICES" == hEviType) {
						for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
							var chkVal=sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt1");
							if ( "" == chkVal && (sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "ITEM" || sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "MISCELLANEOUS" ||
									              sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "TAX" || sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "WITHHOLDING TAX" ||
									              sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "FREIGHT" ) ) {							
								ComShowCodeMessage("SAP00012"); 
								sheetObjects[1].SetCellValue(i, prefix2 + "attr_ctnt1", "");
								sheetObjects[1].SelectCell(i, prefix2 + "attr_ctnt1", true, "");
								return false;
							}
							//vendor invoice no dup check
							var inv_no=sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_no");
							if (chkVal != "" ) {
								var param="&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no");
								param +=    "&value1=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_no");
								param +=    "&value2=" + sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt1");
								var sXml=sheetObjects[0].GetSearchData("STM_SAP_0010GS.do", "f_cmd=" + COMMAND01 + param);
								if (SAPDecideErrXml(sheetObjects[0], sXml)) {
									sheetObjects[0].SelectCell(mainRow, prefix1 + "vndr_no", true, "");
						        } else {
						        	 if ( "E" == ComGetEtcData(sXml, "dup_flg") ) {
						        		 ComShowCodeMessage("SAP00014", ComGetEtcData(sXml, "dup_msg"));   //data is duplicated
										 return false;
						        	 }       	
						         }														
							}
						}
						//ASA check
						//office의 상계정산대리점인 경우 (SO_IF_CD 가 O 인 경우) ASA(ATTR_CTNT2)에 값 필수 및 해당 ASA Open 여부 확인 처리(SAR_ASA_MST의 ASA_NO로, ASA_STS_CD 가 OPEN 인 경우만 가능
						var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND07 + "&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd") );
	            		if (SAPDecideErrXml(sheetObj, sXml)) {
	                     } else {
	                    	 if ( "NO_DATA" == ComGetEtcData(sXml, "ofc_cd") ) {
	                    		ComShowCodeMessage("COM132201", "Office Code" );  
	                    		sheetObjects[0].SetCellValue(mainRow, prefix1 + "ofc_cd", "");
	                    		sheetObjects[0].SelectCell(mainRow, prefix1 + "ofc_cd", true, "");
	         					return false;		
	                    	 } else {
	                    		 if("O" == ComGetEtcData(sXml, "so_if_cd")) {
	                    			//필수값 체크 
	                    			 var chkVal=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "attr_ctnt2"));
	                    			if ( "" == chkVal ) {
										ComShowCodeMessage("SAP00019"); 
										return false;
									}
	                    			 //Asa
	                    			var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND09 + "&value0=" + chkVal );
	                    			 if (SAPDecideErrXml(sheetObj, sXml)) {
	                    				 return false;
	                    			 } else {
	                    				 if ( "NO_DATA" == ComGetEtcData(sXml, "asa_sts_cd") ) {
	                    					 ComShowCodeMessage("COM132201", "Register Number(Asa No)" );   
	                    					 return false;
	                    				 }
	                    				 if ( "O" != ComGetEtcData(sXml, "asa_sts_cd") ) {
	                    					 ComShowCodeMessage("SAP00020", chkVal);  
	                    					 sheetObjects[0].SetCellValue(mainRow, prefix1 + "attr_ctnt2", "");
	                    					 sheetObjects[0].SelectCell(mainRow, prefix1 + "attr_ctnt2", true, "");
	                    					 return false;
	                    				 }
	                    			 }
	                    		 }
	                    	 }
	                     }
	     			}
					//Line Check ================================================================
					var inv_curr_cd=sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "inv_curr_cd");
					var inv_xch_rt=parseFloat ( ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_xch_rt")) ) ;
					var inv_curr_prcs=parseFloat ( ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_prcs")) ) ;
		    		var f_curr_cd=formObj.hid_func_curr_cd.value;
		    		var f_curr_prcs=ComNullToZero(formObj.hid_func_curr_prcs.value);	
		    		if ( inv_xch_rt == 0 ) inv_xch_rt=1;
		    		var point=f_curr_prcs;
		    		if ( f_curr_cd != inv_curr_cd ) point=inv_curr_prcs;
		    		//line no dup check
		    		var dupRowSheet2=sheetObjects[1].ColValueDup(prefix2+"dtrb_line_no", false);
		            if(dupRowSheet2 != -1) {
		            	ComShowCodeMessage("COM131302", "Lines No");
		            	sheetObjects[1].SetSelectRow(dupRowSheet2);
		            	return false;
		            }
		            
		            var lineFuncSum = 0;
		            var auto_tax_flag = false;  //Calc Tax 를 이용한 Tax 라인의 존재 여부 
		            var h_liab_coa_co_cd = ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_co_cd"));
 		    		var h_liab_coa_rgn_cd = ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_rgn_cd"));
 		    		var h_liab_coa_ctr_cd = ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_ctr_cd"));
 		    		var lFunctionalLineAmt = 0;
 					var lFunctionalHeaderAmt = 0;
 					var lGainTotalAmt = 0;
 					var lLossTotalAmt = 0;
		            for(var i=1; i <=sheetObjects[1].RowCount(); i++ ) {
		            	if(sheetObjects[1].GetRowStatus(i) != "D") {
				    		//COA 조합이 Code Combination 에 사용 가능 상태인지 체크 
							var company=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_co_cd");
							var region=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_rgn_cd");
							var center=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_ctr_cd");
							var account=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_acct_no");
							var intercom=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_inter_co_cd");
							var vvd=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_vvd_cd");
							var cmbSeq=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_cd_cmb_seq");
							if (h_liab_coa_co_cd != company) {
								ComShowCodeMessage("SAP00073", i + "Row");
			    				sheetObjects[1].SelectCell(i, prefix2 + "dtrb_coa_co_cd", true, "");
			    				return false;
							}
							if (h_liab_coa_rgn_cd != region) {
								ComShowCodeMessage("SAP00074", i + "Row");
			    				sheetObjects[1].SelectCell(i, prefix2 + "dtrb_coa_rgn_cd", true, "");
			    				return false;
							}
							if (h_liab_coa_ctr_cd != center) {
								ComShowCodeMessage("SAP00075", i + "Row");
			    				sheetObjects[1].SelectCell(i, prefix2 + "dtrb_coa_ctr_cd", true, "");
			    				return false;
							}
				    		var rtnCmbSeq=chkValidLeger(sheetObjects[1],company, region, center, account, intercom, vvd);
				    		if (rtnCmbSeq == "NO_DATA" || rtnCmbSeq == "ERROR" ) {
				    			ComShowCodeMessage("COM132201", "Expense Account");
				    			return false;
				    		} else if (rtnCmbSeq == "ADD_ERROR") {
				    			return false;
				    		} else {
				    			if ( cmbSeq != rtnCmbSeq ) {
				    				sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_cd_cmb_seq",rtnCmbSeq,0);
				    			}
				    		}	
				    		
				    		var activeDate=sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt11");  //Activity Date
							var activePlace=sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt12"); //Activity Place
							var ServiceLane=sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt14"); //Service lane
							if ( "" == activeDate ) {
								ComShowCodeMessage("SAP00085", i + "Row");
								sheetObjects[1].SelectCell(i, prefix2 + "attr_ctnt11", true, "");
								return false;
							}
							if ( "" == activePlace ) {
								ComShowCodeMessage("SAP00086", i + "Row");
								sheetObjects[1].SelectCell(i, prefix2 + "attr_ctnt12", true, "");
								return false;
							}
							if ( "" == ServiceLane ) {
								ComShowCodeMessage("SAP00087", i + "Row");
								sheetObjects[1].SelectCell(i, prefix2 + "attr_ctnt14", true, "");
								return false;
							}
				    		
				    		//line amount check
		    				var lineAmt=sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_amt");
		    				var linetype=sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd");
		    				
			    			if(lineAmt == "0" && linetype != "TAX") {
			    				ComShowCodeMessage("SAP00051", i + "Row [Line Amount] ");
			    				sheetObjects[1].SelectCell(i, prefix2 + "dtrb_amt", true, "");
			    				return false;
			    			}
			    			
			    			if (EXRATE_RULE == "LINE") {
				    			//Line Exchange Rate Check
								if ( !chkXRateLine("dtrb_amt", i) ) { 
									return false; 
								} 
			    			}
			    			
				    		//DTRB_FUNC_AMT 계산 		
			    			var lineAmt=sheetObjects[1].ComputeSum("|"+prefix2 + "dtrb_amt" +"|", i, i);
				    		if (EXRATE_RULE == "LINE") {
				    			var inv_line_xch_rt=parseFloat ( ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_xch_rt")) ) ;
				    			if ( inv_line_xch_rt == 0 ) inv_line_xch_rt=1;

				    			lFunctionalHeaderAmt = SAPComRound(lineAmt * inv_xch_rt, f_curr_prcs);
				    			lFunctionalLineAmt = SAPComRound(lineAmt * inv_line_xch_rt, f_curr_prcs);
				    			sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_amt",SAPComAddComma2( SAPComRound(lineAmt * inv_line_xch_rt, f_curr_prcs) + '', f_curr_prcs) );
				    			if (inv_line_xch_rt >= inv_xch_rt) {
				    				if (lineAmt >= 0) {
				    					sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_gain_amt", SAPComAddComma2( SAPComRound(Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt)), f_curr_prcs) + '', f_curr_prcs) );
				    					lGainTotalAmt = SAPComRound(parseFloat(lGainTotalAmt) + (Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt))), f_curr_prcs);
				    				} else {
				    					sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_lss_amt", SAPComAddComma2( SAPComRound(Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt)), f_curr_prcs) + '', f_curr_prcs) );
				    					lLossTotalAmt = SAPComRound(parseFloat(lLossTotalAmt) + (Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt))), f_curr_prcs);
				    				}
				    			} else {
				    				if (lineAmt >= 0) {
				    					sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_lss_amt", SAPComAddComma2( SAPComRound(Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt)), f_curr_prcs) + '', f_curr_prcs) );
				    					lLossTotalAmt = SAPComRound(parseFloat(lLossTotalAmt) + (Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt))), f_curr_prcs);
				    				} else {
				    					sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_gain_amt", SAPComAddComma2( SAPComRound(Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt)), f_curr_prcs) + '', f_curr_prcs) );
				    					lGainTotalAmt = SAPComRound(parseFloat(lGainTotalAmt) + (Math.abs(parseFloat(lFunctionalLineAmt) - parseFloat(lFunctionalHeaderAmt))), f_curr_prcs);
				    				}
				    			}

				    		} else {
				    			sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_func_amt",SAPComAddComma2( SAPComRound(lineAmt * inv_xch_rt, f_curr_prcs) + '', f_curr_prcs) );
				    		}
				    		
				    		var linfFunc=sheetObjects[1].ComputeSum("|"+prefix2 + "dtrb_func_amt" +"|", i, i);
				    		//var linfGainFunc=ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_func_gain_amt"));
				    		//var linfLossFunc=ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_func_lss_amt"));
				    		
				    		//LineSum 구하기 (TYPE이 PREPAY 가 아닌것들의 합계)
				    		//if (EXRATE_RULE == "LINE") {
					    		lineFuncSum = SAPComRound(parseFloat(lineFuncSum) + parseFloat(linfFunc),point); 
				    		//} else {
					    	//	lineFuncSum = SAPComRound(parseFloat(lineFuncSum) + parseFloat(linfFunc),point); 
				    		//}
				    		
				    		//Line Type이 Item일경우 -금액 입력 불가
				    		if(sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "ITEM" && lineAmt < 0 ) {
				    			ComShowCodeMessage("SAP00060" );   // You must input positive number at Line Amount when the line type is ITEM.
				    			sheetObjects[1].SetCellValue(i, prefix2 + "dtrb_amt","");
				    			sheetObjects[1].SelectCell(i, prefix2 + "dtrb_amt", true, "");
				    			return false;
				    		}
				    		
				    		//Tax Line 유무 체크 (아래 Tax Validation 시 사용) -- 다음의 주석에서 사용 : COA seq setting  &&  Tax Code 가 있는 ITEM 에 따른 Tax Line 체크
				    		if(sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "TAX" && sheetObjects[1].GetCellValue(i, prefix2 + "glo_attr_ctnt1") != "") {
				    			auto_tax_flag = true;
				    		}
		            	}
					}	
		            var lineTaxSum = 0;
 		    		var taxRateFlag = false;
		    		for(var i=1; i <=sheetObjects[1].RowCount(); i++ ) {
		    			if(sheetObjects[1].GetRowStatus(i) != "D") {
				    			    		
				    		//Tax Code (Tax Rate) 가 있는 ITEM 에 따른 Tax Line 체크 
				    		var tax_rate = parseFloat(ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_vat_rt")));
				    		var tax_cd = sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_vat_cd");
				    		var calcTaxRow = -1;
				    		if (tax_cd != "" ) {
							//if (tax_rate > 0 ) {
								taxRateFlag = true;	// 한건이라도 tax_rate 가 존재하면 true
								var this_line_no = sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_line_no");
								// manual 로 입력한 TAX Line 이 존재하거나 해당 line_no 의 TAX line 이 존재하면 통과
								// 그렇지 않으면 메세지 출력  
								if( SAPFindText(sheetObjects[1],prefix2 + "line_tp_lu_cd", "TAX" )  == -1 ) {
									ComShowCodeMessage("SAP00055", parseInt(this_line_no) );  //Line No. [] is tax item. Please use the [Calculate Tax] Button.
									return false;
								} else {
									if (auto_tax_flag ) {  // auto calc 한 데이타가 한건이라도 있으면 
										calcTaxRow = SAPFindText(sheetObjects[1], prefix2 + "glo_attr_ctnt1", this_line_no);
										if( calcTaxRow == -1) {
											ComShowCodeMessage("SAP00055", parseInt(this_line_no) );  //Line No. [] is tax item. Please use the [Calculate Tax] Button.
											return false;
										}									
									}					
								}
								
								// ==== 범위내에 있는 TAX 인지 체크 (+1 ~ -1 ) ====
								// 0. Auto Calc Tax인지 Manual Tax 인지 판단.
								// auto calc tax 인경우, 1. lineAmt 에 따른 TAX 를 구한다.  2. 해당 라인의 REF_KEY 의 lineAmt (tax amt) 구한다.  3. (1번값 - 2번값) 이 범위내에 있는지 체크한다. 
								// manually inputted tax 이면,  1. lineAmt 에 따른 TAX 를 구한다. 2. 앞에서 구한 tax 의 합을 구한다.  3. (2번의값 - 입력한tax값 ) 이 범위내에 있는지 체크.  -- 요건은 합계금액 체크이므로 for 문 바깥에서.
								
								var lineAmt = sheetObjects[1].ComputeSum("|"+prefix2 + "dtrb_amt" +"|", i, i);
					    							    		
								var thisLineTax = parseFloat( SAPComRound(lineAmt * (tax_rate/100), point) ) ;
								lineTaxSum = lineTaxSum + thisLineTax;
								var calcLineTax = parseFloat( sheetObjects[1].GetCellValue(calcTaxRow, prefix2 + "dtrb_amt") ) ;
								if(auto_tax_flag) {
									if ( Math.abs(thisLineTax - calcLineTax) > 1  ) {
										ComShowCodeMessage("SAP00056", sheetObjects[1].GetCellValue(calcTaxRow, prefix2 + "dtrb_line_no") );
										return false;
									}
								} 
							} else { // end of if (tax_rate > 0 ) { 
								if (sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "TAX") {
									taxRateFlag = true;		
								}
							}  
		    			}
		    		}
		    		
		    		//TAX RATE가 존재하는 경우에만 TAX LINE 이 존재할 수 있다.
		    		if(!taxRateFlag) {
		    			if( SAPFindText(sheetObjects[1],prefix2 + "line_tp_lu_cd", "TAX" )  != -1 ) {
		    				ComShowCodeMessage("SAP00062");  //There is no tax item. You can't input TAX Line.
		    				return false;
		    			}
		    		}
		    		
		    		//위의 manually inputted tax 이면,  로직 처리 
		    		if (taxRateFlag && !auto_tax_flag) {
		    			var manualTaxRow = SAPFindText(sheetObjects[1], prefix2 + "line_tp_lu_cd", "TAX");
		    			var manualTaxAmt = parseFloat( sheetObjects[1].GetCellValue(manualTaxRow, prefix2 + "dtrb_amt") ) ;
		    			if ( Math.abs(lineTaxSum - manualTaxAmt) > 1  ) {
							ComShowCodeMessage("SAP00057", manualTaxAmt,  lineTaxSum + " ± 1" );
							return false;
						}
		    		}
		    		
		    		//functional amount 합계 체크 
		    		//var hFuncInvAmt=sheetObjects[0].ComputeSum("|"+prefix1 + "inv_func_amt" +"|", mainRow, mainRow);
		    		var hFuncInvAmt = parseFloat( ComReplaceStr( sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_func_amt"), ",", "") );
		    		//var lineFuncSum=sheetObjects[1].GetSumValue(0,prefix2 + "dtrb_func_amt") ;
					var diffAmt=0;
					if (EXRATE_RULE == "LINE") {
						diffAmt = SAPComRound(hFuncInvAmt - parseFloat(lineFuncSum) + parseFloat(lGainTotalAmt) - parseFloat(lLossTotalAmt),point);
					} else {
						if ( hFuncInvAmt != lineFuncSum ) {
							diffAmt=hFuncInvAmt - lineFuncSum;							
						}
					}
					sheetObjects[1].SetCellValue(1, prefix2 + "inv_rnd_amt",diffAmt);
					
					//Pay Skd Check ================================================================
					if ("I" == sheetObjects[0].GetCellValue(mainRow, prefix1 + "ibflag") && sheetObjects[2].RowCount() == 0 ) {  
						addSheet3Data("INIT");			
					} 
					var skdSum=parseFloat(sheetObjects[2].GetSumValue(0,prefix3 + "pay_grs_amt"));
					if ( hInvAmt != skdSum ) {
						var firstPayGrsAmt=parseFloat(sheetObjects[2].ComputeSum("|"+prefix3 + "pay_grs_amt" +"|", 1, 1));
						var diffAmt=hInvAmt - skdSum;
						sheetObjects[2].SetCellValue(1, prefix3 + "pay_grs_amt",firstPayGrsAmt + diffAmt);
					}
					var skdSum=sheetObjects[2].GetSumValue(0,prefix3 + "pay_grs_amt");
					if ( hInvAmt != skdSum ) {
						ComShowCodeMessage("SAP00006", "Scheduled Payments Gross amount" ,  "Invoice amount" );  
						return false;
					}
					for(var i=1; i <= sheetObjects[2].RowCount(); i++ ) {
						if ("" == sheetObjects[2].GetCellValue(i, prefix3 + "pay_prio_cd")) sheetObjects[2].SetCellValue(i, prefix3 + "pay_prio_cd","99");
						sheetObjects[2].SetCellValue(i, prefix3 + "pay_rmn_amt",sheetObjects[2].GetCellValue(i, prefix3 + "pay_grs_amt") );
					}					
				} else {
					ComShowCodeMessage("COM130503");   
					return false;
				}
				break;
			case IBDELETE: //delete
				var mainRow=sheetObjects[0].GetSelectRow();
				var prefix=sheetObjects[0].id + "_";
				if (mainRow > 0 ) { 
					if ( sheetObjects[0].GetCellValue(mainRow, prefix+"chkEditable") == "N" ) {
						ComShowCodeMessage("SAP00045");   
						return false;
					}
					var source_code=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "ap_inv_src_cd")) ;
					if (source_code == "AR" ) {
						ComShowCodeMessage("SAP00045");   
						return false;
					}
				} else {
					return false;
				}
				break;
			case MULTI02: //cancel
				var mainRow=sheetObjects[0].GetSelectRow();
				var prefix=sheetObjects[0].id + "_";
				
				var chk1=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "attr_ctnt15")) ; //2016.08.17 승인전 전표 Cancel 불가
				var chk2=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "pay_sts_flg")) ;
				var chk5=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "inv_cxl_dt")) ;
				var chk8=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "submit_flag")) ; //2016.08.17 Submit처리된 이후 Cancel 가능
				var source_code=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix + "ap_inv_src_cd")) ;
				if (mainRow > 0 ) { 
					if ( chk1 == "Y" || chk2 == "Y" || chk2 == "P" || chk5 != "" || source_code != "Manual Invoice Entry" || chk8 != "Y" ) {
						ComShowCodeMessage("SAP00048");   
						return false;
					}
				} else {
					return false;
				}
				break;	
			case RDPRINT: //print
				var mainRow=sheetObjects[0].GetSelectRow();
				var prefix=sheetObjects[0].id + "_";
				if (mainRow > 0 ) { 
					break;
				} else {
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
		axon_event.addListenerForm('blur', 'obj_deactivate', formObj);   //beforedeactivate   deactivate
		axon_event.addListenerFormat('focus', 'obj_activate', formObj);
		//axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}
  
    /** 
     * handling keyup event of Object  <br>
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
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		//ComChkObjValid(event.srcElement);	
		var obj=ComGetEvent();
		switch(ComGetEvent("name")){ 	    	
	   		case "inv_fr_dt":
	   			ComAddSeparator(form.inv_fr_dt, "ymd");
	   			ComChkObjValid(ComGetEvent());
	   			break;
	   		case "inv_to_dt":
	   			ComAddSeparator(form.inv_to_dt, "ymd");
	   			ComChkObjValid(ComGetEvent());		
	   			break;
	   		case "gl_fr_dt":
	   			ComAddSeparator(form.gl_fr_dt, "ymd");
	   			ComChkObjValid(ComGetEvent());
	   			break;
	   		case "gl_to_dt":
	   			ComAddSeparator(form.gl_to_dt, "ymd");
	   			ComChkObjValid(ComGetEvent());	
	   			break;	
		}
	}
    function SAPInitDataCurrCombo(sheetObj, colName, type, appendStr, appendCode, sCondition) {
    	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH06 + "&value0=" + sCondition );
    	var comboString=ComXml2ComboString(sXml, "curr_cd", "dp_prcs_knt");
        if ( appendStr != "" ) appendStr=appendStr + "|";
        if ( appendCode != "" ) appendCode=appendCode + "|";
        if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
        } else if (type == "2" ) {
        	var codeStrTemp=comboString[0].split('|'); // 코드
            var nameStrTemp=comboString[1].split('|'); // 이름
            var fullStrTemp='';  // 코드 + 이름  
            for(var i=0; i<codeStrTemp.length; i++){
                fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i] + '|' ;
            }
            sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        }
    } 
    /**
     * IBSeet내의 데이터 중 ofc_cd 와 gl_date 변경시 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	   
    function changeOfcAndGlDate(sheetObj, Row, Col) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		if ("sheet1" == sheetID) {
			var gl_dt=sheetObj.GetCellValue(Row, prefix + "gl_dt");
			var ofc_cd=sheetObj.GetCellValue(Row, prefix + "ofc_cd");
			if ( gl_dt.length > 0 && ofc_cd.length > 0 ) {
				var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + gl_dt + "&value1=" + ofc_cd);
				if (SAPDecideErrXml(sheetObj, xmlStr)) {
					SetCellValue(Row, Col, "");
	                SelectCell(Row, Col, true, "");
	                return false;
	            } else {
	                var chk_period=ComGetEtcData(xmlStr, "chk_period");
	                if ( chk_period != "O") {
	                	ComShowCodeMessage("SAP00001", gl_dt, ofc_cd);  // inv_dt,, ofc_cd can't open.
	                	sheetObj.SetCellValue(Row, prefix + "period_chk","N",0);
	                	sheetObj.SetCellValue(Row, prefix + "gl_dt","");
	                	//SetCellValue(Row, Col, "");
	                	sheetObj.SelectCell(Row, Col, true, "");
	                	return false;
	                } else  {
	                	sheetObj.SetCellValue(Row, prefix + "period_chk","Y",0);
                		/*if ("I" == sheetObj.GetCellValue(Row, prefix + "ibflag") ) {
		                	sheetObj.SetCellValue(Row, prefix + "gl_dt",inv_dt);
		            		sheetObj.SetCellValue(Row, prefix + "inv_term_dt",inv_dt,0);
	                	}*/
	                	return true;
	                }
	            }
			}
			return true;
		} else if ("sheet2" == sheetID) {
			
		    var prefix1=sheetObjects[0].id + "_";
			var prefix2=sheetObjects[1].id + "_";
			var prefix3=sheetObjects[2].id + "_";
			var mainRow=sheetObjects[0].GetSelectRow();
			var inv_dt=sheetObjects[1].GetCellValue(Row, prefix2 + "acctg_dt");
			var ofc_cd=sheetObjects[0].GetCellValue(mainRow, prefix1 + "ofc_cd");
			if ( inv_dt.length > 0 && ofc_cd.length > 0 ) {
				var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + inv_dt + "&value1=" + ofc_cd);
				if (SAPDecideErrXml(sheetObj, xmlStr)) {
					SetCellValue(Row, Col, "");
	                SelectCell(Row, Col, true, "");
	                return false;
	            } else {
	                var chk_period=ComGetEtcData(xmlStr, "chk_period");
	                if ( chk_period != "O") {
	                	ComShowCodeMessage("SAP00001", inv_dt, ofc_cd);  // inv_dt,, ofc_cd can't open.
	                	sheetObj.SetCellValue(Row, prefix2 + "period_chk","N",0);
	                	sheetObj.SelectCell(Row, Col, true, "");
	                	return false;
	                } else  {
	                	sheetObj.SetCellValue(Row, prefix2 + "period_chk","Y",0);
	                	return true;
	                }
	            }
			}
			return true;
		}
    }
    /**
     * 숫자형 데이타에 ComAddComma(obj) 적용 및 소숫점 자릿수에 맞게 0 추가 
     * @param {obj} String : Form Object
     * @param {prcs} String : 소숫점 이하 자릿수 
     */  
    function SAPComAddComma2(obj,prcs)  {
            var sVal=getArgValue(obj);
            if (prcs == null || prcs == "" || prcs == 0 ) {
           	 return ComAddComma(sVal);
            } else {
           	    p=sVal.split(".");
                p[0]=ComAddComma(p[0]);
                if (p.length == 1) {
                	rtnVal=p[0] + "." + ComRpad("0", prcs, "0");
                } else if (p.length == 2) {
                	if(p[1].length == prcs) {
                		rtnVal=p[0]+"."+p[1];	                 		
                	} else {
                		rtnVal=p[0]+"." +p[1] + ComRpad("0", prcs - p[1].length, "0");
                	}
                }
                return rtnVal;
            }             
    }   
    /**
     * Header sheet's inv_func_amt setting   
     */      
    function settingFuncAmt(sheetObj, Row, Col) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		if (sheetObj.GetCellValue(Row, prefix + "inv_amt") == "") return;
		var inv_curr_cd=sheetObj.GetCellValue(Row,  prefix +  "inv_curr_cd");
		var f_curr_cd=formObj.hid_func_curr_cd.value;
		var f_curr_prcs=ComNullToZero(formObj.hid_func_curr_prcs.value);	
		//var inv_amt=sheetObj.ComputeSum("|"+prefix + "inv_amt" +"|", Row, Row);
		var point=getPoint();
		var inv_amt = 0;

		if (ComIsContainsChars(ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "inv_amt"), ",", ""), ".")) {
			inv_amt = parseFloat(ComTrunc( ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "inv_amt"), ",", ""), point));
		} else {
			inv_amt = parseFloat( ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "inv_amt"), ",", "") );
		}
		
		//var inv_amt = ComTrunc(parseFloat( ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "inv_amt"), ",", "") ), point);
		//var inv_amt = parseFloat( ComReplaceStr( sheetObj.GetCellValue(Row, prefix + "inv_amt"), ",", "") );
		//var point=f_curr_prcs;
		if ( f_curr_cd != inv_curr_cd ) {
			var inv_dt=sheetObj.GetCellValue(Row, prefix + "inv_dt");
			var period_chk=sheetObj.GetCellValue(Row, prefix + "period_chk");
			var inv_tp_lu_cd=sheetObj.GetCellValue(Row, prefix + "inv_tp_lu_cd");
			var inv_xch_rt=parseFloat ( sheetObj.GetCellValue(Row, prefix + "inv_xch_rt") ) ;
			var inv_curr_prcs=parseInt(ComNullToZero(sheetObj.GetCellValue(Row, prefix + "inv_curr_prcs")));
			point=inv_curr_prcs;
			sheetObj.SetCellValue(Row, prefix + "inv_amt",SAPComAddComma2( ComRound(inv_amt, point) + '', point) ,0);
			sheetObj.SetCellValue(Row, prefix + "inv_func_amt",SAPComAddComma2( SAPComRound(inv_amt * inv_xch_rt, f_curr_prcs) + '', f_curr_prcs) ,0);
		} else {
			sheetObj.SetCellValue(Row, prefix + "inv_amt",SAPComAddComma2( ComRound(inv_amt, point) + '', point) ,0);
			sheetObj.SetCellValue(Row, prefix + "inv_func_amt",sheetObj.GetCellValue(Row, prefix + "inv_amt"),0);
		}

		//Line Tab - Header 와 같은 precision 적용 
		if (sheetObjects[1].LastRow() > 1 ) {
			if( point == 0 ) {
				for(i=1;i<sheetObjects[1].LastRow()-1;i++){
					sheetObjects[1].InitCellProperty(i, prefix2 + "dtrb_amt",{ Type:"Int",Align:"Right",Format:"Interger"} );
					sheetObjects[1].InitCellProperty(i, prefix2 + "dtrb_func_amt",{ Type:"Int",Align:"Right",Format:"Integer"} );
				}	
			} else {
				for(i=1;i<sheetObjects[1].LastRow()-1;i++){
					sheetObjects[1].InitCellProperty(i, prefix2 + "dtrb_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
					sheetObjects[1].InitCellProperty(i, prefix2 + "dtrb_func_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
				}	
			}			
		}
		//Payment SKD Tab - Header 와 같은 precision 적용 
		if (sheetObjects[2].LastRow() > 1 ) {
			if( point == 0 ) {
				for(i=1;i<sheetObjects[2].LastRow()-1;i++){
					sheetObjects[2].InitCellProperty(i, prefix3 + "pay_grs_amt",{ Type:"Int",Align:"Right",Format:"Integer"} );
				}	
			} else {
				for(i=1;i<sheetObjects[2].LastRow()-1;i++){
					sheetObjects[2].InitCellProperty(i, prefix3 + "pay_grs_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
				}	
			}			
		}		
		return true;
    }
    /**
     * Header sheet 작성시 필수로 [먼저] 입력해야 하는 값 체크  
     */    
    function chkValidHeaderPre(sheetObj, Row, Col) {
    	var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		if(ComTrim(sheetObj.GetCellValue(Row, prefix + "ofc_cd")) == "") {
			ComShowCodeMessage("COM12113", "Office");  // please select msg.
			sheetObj.SetCellValue(Row, Col,"",0);
			sheetObj.SelectCell(Row, prefix + "ofc_cd", true, "");
			return false;
		}
		if(ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_dt")) == "") {
			ComShowCodeMessage("COM12113", "Invoice Date");  // please select msg.
			sheetObj.SetCellValue(Row, prefix + "inv_dt","",0);
			sheetObj.SelectCell(Row, prefix + "inv_dt", true, "");
			return false;
		}
		if(ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_curr_cd")) == "") {
			ComShowCodeMessage("COM12113", "Invoice Currency");  // please select msg.
			sheetObj.SetCellValue(Row, prefix + "inv_curr_cd","",0);
			sheetObj.SelectCell(Row, prefix + "inv_curr_cd", true, "");
			return false;
		}
		return true;
    }
    /**
     * Setting supplier by popup
     */
    function setSupplier(aryPopupData) {
    	document.form.vndr_no.value=aryPopupData[0][1];
    	document.form.vndr_nm.value=aryPopupData[0][2];
    }  
    /**
     * Setting source by popup
     */    
    function setSource(aryPopupData) {
    	document.form.ap_inv_src_cd.value=aryPopupData[0][1];
    } 
    /**
     * Setting pay group by popup
     */    
    function setPayGroup(aryPopupData) {
    	document.form.ap_pay_grp_lu_cd.value=aryPopupData[0][1];
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
                    case prefix + "inv_tp_lu_cd":
                    	SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                    case prefix + "attr_cate_nm":
                        //clear
            			sheetObj.SetCellValue(Row, prefix + "attr_cate_nm","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt2","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt3","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt4","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt5","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt6","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt7","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt8","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt9","",0);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt11","",0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt1",aryPopupData[0][21],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt13",aryPopupData[0][33],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt14",aryPopupData[0][34],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt15",aryPopupData[0][35],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt16",aryPopupData[0][36],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt17",aryPopupData[0][37],0);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt18",aryPopupData[0][38],0);
                    	//setting
                    	sheetObj.SetCellValue(Row, prefix + "attr_cate_nm",aryPopupData[0][0]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt2",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt3",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt4",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt5",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt6",aryPopupData[0][6]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt7",aryPopupData[0][7]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt8",aryPopupData[0][8]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt9",aryPopupData[0][9]);
                    	sheetObj.SetCellValue(Row, prefix + "attr_ctnt11",aryPopupData[0][11]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt1",aryPopupData[0][21]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt13",aryPopupData[0][33]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt14",aryPopupData[0][34]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt15",aryPopupData[0][35]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt16",aryPopupData[0][36]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt17",aryPopupData[0][37]);
                    	sheetObj.SetCellValue(Row, prefix + "glo_attr_ctnt18",aryPopupData[0][38]);
                        break;
                    case prefix + "liab_coa_vvd_cd":
                    	//clear
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_co_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_rgn_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_ctr_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_acct_no","",0);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_inter_co_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_vvd_cd","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_co_cd",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_rgn_cd",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_ctr_cd",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_acct_no",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_inter_co_cd",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, prefix + "liab_coa_vvd_cd",aryPopupData[0][6]);
                    	break;
                   	case prefix + "vndr_lgl_eng_nm":
                   	case prefix + "vndr_no":	
                    	//clear
                   		sheetObj.SetCellValue(Row, prefix + "vndr_no","",0);
                    	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm","",0);
                    	sheetObj.SetCellValue(Row, prefix + "inv_term_nm","",0);
                    	sheetObj.SetCellValue(Row, prefix + "inv_curr_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "sup_reg_no","",0);
                    	sheetObj.SetCellValue(Row, prefix + "bank_acct_flg","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, prefix + "vndr_no",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, prefix + "inv_curr_cd",aryPopupData[0][3],0);
                    	sheetObj.SetCellValue(Row, prefix + "inv_pay_curr_cd",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, prefix + "inv_term_nm",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, prefix + "sup_reg_no",aryPopupData[0][7]);
                    	sheetObj.SetCellValue(Row, prefix + "bank_acct_flg",aryPopupData[0][8],0);
                    	break;
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData2(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
                    case prefix + "dtrb_coa_vvd_cd":  
                    	//clear
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_co_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_rgn_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_ctr_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no","",0);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_inter_co_cd","",0);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_vvd_cd","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_co_cd",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_rgn_cd",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_ctr_cd",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_acct_no",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_inter_co_cd",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, prefix + "dtrb_coa_vvd_cd",aryPopupData[0][6]);
                    	break;
                    case prefix + "attr_ctnt3":  
	                	//clear
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt1","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt2","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt3","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt4","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt5","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt6","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt7","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt8","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt9","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt10","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt11","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt12","",0);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt14","",0);
	                	
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt1",aryPopupData[0][1]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt2",aryPopupData[0][2]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt3",aryPopupData[0][3]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt4",aryPopupData[0][4]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt5",aryPopupData[0][5]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt6",aryPopupData[0][6]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt7",aryPopupData[0][7]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt8",aryPopupData[0][8]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt9",aryPopupData[0][9]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt10",aryPopupData[0][10]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt11",aryPopupData[0][11]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt12",aryPopupData[0][12]);
	                	sheetObj.SetCellValue(Row, prefix + "attr_ctnt14",aryPopupData[0][13]);
	                	
	                	break;
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }
    }    
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData3(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
            	var sheetObj=sheetObjects[ShtIdx];
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
                    case prefix + "remit_vndr_no":  
                    	//clear
	                	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm","",0);
	                	sheetObj.SetCellValue(Row, prefix + "remit_vndr_no","",0);
	                	sheetObj.SetCellValue(Row, prefix + "bank_acct_no","",0);
	                	sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq","",0);
	                	//setting
	                	sheetObj.SetCellValue(Row, prefix + "bank_acct_no",aryPopupData[0][1]);
	                	sheetObj.SetCellValue(Row, prefix + "remit_vndr_no",aryPopupData[0][2]);
	                	sheetObj.SetCellValue(Row, prefix + "vndr_lgl_eng_nm",aryPopupData[0][4]);
	                	sheetObj.SetCellValue(Row, prefix + "xter_bank_acct_seq",aryPopupData[0][5]);
	                	break;
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }
    }     
    /**
     * initialize vendor name
     */ 
    /*function vndr_no_onchange() {
    	//document.form.vndr_nm.value = "";
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var vndr_no=formObj.vndr_no.value;
    	if(vndr_no == "")
    		{
    		document.form.vndr_nm.value="";
    		}else{
    	    	document.form.vndr_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
    		}

    }*/
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
    /**
     * check selected header information
     */      
    function chkValidHeader() {
    	var formObj=document.form;
    	var mainRow=sheetObjects[0].GetSelectRow();
    	if (mainRow == -1 || sheetObjects[0].CheckedRows(prefix1+ "chk_flg") == 0 ) {
    		ComShowCodeMessage("SAP00009");  // please select msg.   SAP00009
    		return false;
    	}
    	if (!ComChkValid(formObj)) return false;
    	if ("" != sheetObjects[0].GetSaveString(false, false, prefix1+ "chk_flg")) {  // sheet1의 필수항목체크
    		var inv_tp_lu_cd=sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_tp_lu_cd");
    		var inv_amt=parseFloat(ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_amt")));
    		// Check Duplicate CSR_No
			var dupRow=sheetObjects[0].ColValueDup(prefix1+"inv_no");
            if(dupRow != -1) {
            	ComShowCodeMessage("COM131302", "CSR No");
            	sheetObjects[0].SetSelectRow(dupRow);
            	return false;
            }
            //Header의 계정은 2 로 시작해야 함
            if ( "2" != sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_acct_no").substring(0,1)) {
            	ComShowCodeMessage("SAP00007", "Liability account", "2");  
            	sheetObjects[0].SetCellValue(mainRow, prefix1 + "liab_coa_acct_no", "");
            	sheetObjects[0].SelectCell(mainRow, prefix1 + "liab_coa_acct_no", true);
        		return false;
        	}  
    		//Invoice Type 에 따른 금액 부호 체크 
    		if ( inv_tp_lu_cd == "CREDIT" ) {
				if ( inv_amt > 0 ) {  //--2015.03.19 KS.JO 금액 Zero 제외 처리
					ComShowCodeMessage("SAP00003", inv_tp_lu_cd, "negative number");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
					sheetObjects[0].SetCellValue(mainRow, prefix1 + "inv_amt","",0);
					sheetObjects[0].SelectCell(mainRow, prefix1 + "inv_amt", true, "");
					return false;
				}
			} else {
				if ( inv_amt < 0 ) {
					ComShowCodeMessage("SAP00003", inv_tp_lu_cd, "positive number");  // -금액일경우 invoice type 은 credit 을 선택해야 함.
					sheetObjects[0].SetCellValue(mainRow, prefix1 + "inv_amt","",0);
					sheetObjects[0].SelectCell(mainRow, prefix1 + "inv_amt", true, "");
					return false;
				}
			}
    		//COA 조합이 Code Combination 에 사용 가능 상태인지 체크 
    		//chkValidLeger(sheetObj, company, region, center, account, intercom, vvd) {
			var company=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_co_cd");
			var region=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_rgn_cd");
			var center=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_ctr_cd");
			var account=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_acct_no");
			var intercom=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_inter_co_cd");
			var vvd=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_coa_vvd_cd");
			var cmbSeq=sheetObjects[0].GetCellValue(mainRow, prefix1 + "liab_cd_cmb_seq");
    		var rtnCmbSeq=chkValidLeger(sheetObjects[0],company, region, center, account, intercom, vvd);
    		if (rtnCmbSeq == "NO_DATA" || rtnCmbSeq == "ERROR" ) {
    			ComShowCodeMessage("COM132201", "Liability Account");
    			return false;
    		} else if (rtnCmbSeq == "ADD_ERROR") {
    			return false;
    		} else {
    			if ( cmbSeq != rtnCmbSeq ) {
    				sheetObjects[0].SetCellValue(mainRow, prefix1 + "liab_cd_cmb_seq",rtnCmbSeq,0);
    			}
    		}
    		settingFuncAmt(sheetObjects[0], mainRow,  prefix1 + "inv_amt");
    	} else {
    		return false;
    	}
    	return true;
	}  
    /**
     * Check editable about header, line
     * 조건 : Header와 Line의 수정 불가는 결재완료인 ATTR_CTNT15 = 'Y'인 경우와 
     * 지불처리인 PAY_STS_FLG가 'Y' 또는 'P'인 경우, 
     * 지불하기 위한 접수 완료 처리인 AP_APSTS_CD = 'MANUALLY APPROVED' 인 경우, 
     * Line의 ACCTG_PST_FLG = 'Y'가 하나라도 존재하는 경우, 
     * Cancel 처리된 경우인 Header의 INV_CXL_DT 에 Cancel일자가 존재하는 경우에는 수정 불가
     * @return boolean : true - 수정가능 , false - 수정불가 
     */   
    function chkEditableInv(mainRow) {
    		//var mainRow = sheetObjects[0].SelectRow;
		var chk1=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "attr_ctnt15")) ;
		var chk2=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "pay_sts_flg")) ;
		var chk3=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "ap_apsts_cd")) ;
		var chk4=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "cnt_acctg_pst_flg_y")) ;
		var chk5=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_cxl_dt")) ;
		var chk6=ComTrim(sheetObjects[0].GetCellValue(mainRow, prefix1 + "ap_inv_src_cd")) ;
		if ( chk1 == "Y"  || chk2 == "Y" || chk2 == "P" || chk3 == "MANUALLY APPROVED" || chk4 != "0" || chk5 != "" || (chk6 != "Manual Invoice Entry" && chk6 != "AR") ) {
			return "N";
		} else {
			return "Y";
		}
    }   
    /**
     * Header와 Line에 입력된 COA 조합이 Code Combination 에 사용 가능 상태인지 체크 
     * @param sheetObj
     * @param company
     * @param region
     * @param center
     * @param account
     * @param intercom
     * @param vvd 
     * @return cd_cmb_seq 
     */   
    function chkValidLeger(sheetObj, company, region, center, account, intercom, vvd) {
        var param="&value1=" + company +"&value2=" + region +"&value3=" + center  +"&value4=" + account  +"&value5=" + intercom  +"&value6=" + vvd;  
        var sXml=sheetObj.GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND08 + param);
		if (SAPDecideErrXml(sheetObj, sXml)) {
			sheetObj.SetCellValue(Row, Col, "");
			sheetObj.SelectCell(Row, Col, true, "");
        } else {
        	if ( "NO_DATA" == ComGetEtcData(sXml, "cd_cmb_seq") ) {
        		//return "NO_DATA";
        		 var cmb_chk=SapAddCCID(sheetObj, company, region, center, account, intercom, vvd);
        		 var cmb_msg=cmb_chk[0];
        		 var cmb_seq=cmb_chk[1];
        		 if (cmb_msg != "OK") {
        			 ComShowMessage(cmb_msg);
        			 return "ADD_ERROR"
        		 } else {
        			 return cmb_seq;
        		 }
        	 } else {
        		return ComGetEtcData(sXml, "cd_cmb_seq") ;
        	 }        	
         }	
		return "ERROR";
	} 
    /**
     * 화면에서 핸들링 할 소숫점 이하 자릿수를 가져온다. 
     * header 의 inv_curr_cd 에 따라 변한다.
     */ 
    function getPoint() {
    	var formObj=document.form;
    	var mainRow=sheetObjects[0].GetSelectRow();
		var inv_curr_cd=sheetObjects[0].GetCellValue(mainRow,  prefix1 +  "inv_curr_cd");
		var inv_xch_rt=parseFloat ( ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_xch_rt")) ) ;
		var inv_curr_prcs=parseFloat ( ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_prcs")) ) ;
		var f_curr_cd=formObj.hid_func_curr_cd.value;
		var f_curr_prcs=ComNullToZero(formObj.hid_func_curr_prcs.value);	
		if ( inv_xch_rt == 0 ) inv_xch_rt=1;
		var point=f_curr_prcs;
		if ( f_curr_cd != inv_curr_cd ) point=inv_curr_prcs;
		return point;
    }
    /**
     * Scheduled payments line add
     */     
    function addSheet3Data(flag) {
    	var mainRow=sheetObjects[0].GetSelectRow();
    	var point=getPoint();
		var rowChk = sheetObjects[2].LastRow() == 1 ? sheetObjects[2].RowCount() : sheetObjects[2].LastRow();
    	if("I" == sheetObjects[0].GetCellValue(mainRow, prefix1+"ibflag") && rowChk == 0 ) {
    		sheetObjects[2] = sheetObjects[2].Reset();
			initSheet(sheetObjects[2], 3, point);
		}
    	var sh3row=sheetObjects[2].DataInsert(-1);
		if( point == 0 ) {
			sheetObjects[2].InitCellProperty(sh3row, prefix3 + "pay_grs_amt",{ Type:"Int",Align:"Right",Format:"Integer"} );
		} else {
			sheetObjects[2].InitCellProperty(sh3row, prefix3 + "pay_grs_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
		}	
    	if (flag != "INIT") { 
    		sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_rmn_amt","");
			sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_grs_amt","");
    	} else {	
    		sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_rmn_amt",sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_amt"));
    		sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_grs_amt",sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_amt"));
    	}
    	sheetObjects[2].SetCellValue(sh3row, prefix3 + "inv_seq",sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_seq"));
    	var hInvTermDt=sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_term_dt");
    	var hInvTermNm=ComNullToZero(sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_term_nm"));
		hInvTermNm= hInvTermNm.replace(/^[A-Za-z]+/g, '');
		var due_dt=ComGetDateAdd(hInvTermDt, "D", hInvTermNm, ""); 
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "due_dt",due_dt);
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "inv_hld_flg","N");
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_mzd_lu_cd",sheetObjects[0].GetCellValue(mainRow, prefix1 + "pay_mzd_lu_cd"));
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_sts_flg","N");
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "attr_ctnt15","");
		sheetObjects[2].SetCellValue(sh3row, prefix3 + "inv_curr_cd",sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_cd"));
		// setting supplier info
		var param="&value0=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "inv_curr_cd")
		param +=    "&value1=" + sheetObjects[0].GetCellValue(mainRow, prefix1 + "vndr_no");
		var sXml=sheetObjects[0].GetSearchData("STM_SAP_0240GS.do", "f_cmd=" + COMMAND10 + param);
		if (SAPDecideErrXml(sheetObjects[0], sXml)) {
			return false;
	    } else {
	    	 if ( "NO_DATA" == ComGetEtcData(sXml, "bank_acct_prio_cd") ) {
	    		 //ComShowCodeMessage("SAP00015","Schedule Payment's SAP_BANK_ACCT");  
				 //return false;
	    		 sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_prio_cd","99");
	    	 } else {
	    		 var bank_acct_prio_cd=ComGetEtcData(sXml, "bank_acct_prio_cd");
	    		 var bank_acct_seq=ComGetEtcData(sXml, "bank_acct_seq");
	    		 var bank_acct_vndr_seq=ComGetEtcData(sXml, "bank_acct_vndr_seq");
	    		 sheetObjects[2].SetCellValue(sh3row, prefix3 + "pay_prio_cd",bank_acct_prio_cd);
	    		 sheetObjects[2].SetCellValue(sh3row, prefix3 + "remit_vndr_no",bank_acct_vndr_seq);
	    		 sheetObjects[2].SetCellValue(sh3row, prefix3 + "xter_bank_acct_seq",bank_acct_seq);
	    	 }      	
	     }	
	}
    function SapInitDataComboTax(sheetObj, colName, type, appendStr, appendCode, sCondition, param) {
    	//SapInitDataComboTax(sheetObj, prefix + "dtrb_vat_cd", "2", " " , " ") ;
    	if (param == undefined ) param="";
    	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH07 );
    	var combo_tax_code=ComGetEtcData(sXml,"combo_tax_code");
		var combo_tax_nm=ComGetEtcData(sXml,"combo_tax_nm");
		var combo_tax_rt = ComGetEtcData(sXml,"combo_tax_rt");
		var combo_tax_nm_rt = ComGetEtcData(sXml,"combo_tax_nm_rt");
		
		this.ARR_LINE_TAX_RATE = combo_tax_rt.split('|'); 
		//alert(appendStr+combo_tax_nm);
	    if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+combo_tax_nm, ComboCode:appendCode+combo_tax_code} );
        } else if (type == "2" ) {
        	appendStr=appendCode + "\t" + appendStr ;
            sheetObj.SetColProperty(colName, {ComboText:appendStr+combo_tax_nm, ComboCode:appendCode+combo_tax_code} );
        }else if (type == "3" ) {
        	appendStr = appendCode + "\t" + appendStr ;
            sheetObj.InitDataCombo(0, colName, appendStr +  combo_tax_nm_rt, appendStr +  combo_tax_code, "", "", 1);
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
    
    /**
     * Click Calculate Tax Button
     * Line 데이타 중 Tax Code 가 있고, 해당 Tax Code 에 Tax Rate 가 0 이상일때 자동으로 Tax Line 생성 및 Tax Amt 계산 
     */    
    function fncCalcTax() {
    	
    	if(sheetObjects[1].RowCount() < 1) {
			return;
		}
    	
    	var mainRow = sheetObjects[0].GetSelectRow();
    	
    	//Clac할 대상이 있는지 여부 체크
    	var need_calc_flag = false;
    	for(var i=1; i <=sheetObjects[1].RowCount(); i++ ) {
    		var tax_rate = parseFloat(ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_vat_rt")));
			if (tax_rate >= 0 ) {
				need_calc_flag = true;
			}
    	}
    	if(!need_calc_flag){
    		ComShowCodeMessage("SAP00015", " to [Calculate Tax]");  //There is no data {?msg1}
    		return;
    	}
    	
    	var initTotRow = sheetObjects[1].RowCount();
    	
    	for(var i=initTotRow; i >= 1; i-- ) {	//RowDelete 로 인한 영향으로 거꾸로 for 문 사용 
    		
    		//alert(i + ":::" + sheetObjects[1].CellValue(i, prefix2 + "line_tp_lu_cd") + ":::" + sheetObjects[1].CellValue(i, prefix2 + "glo_attr_ctnt1") + ":::" );
    		
    		//1.Manual 로 입력한 ( glo_attr_ctnt1 값 존재X ) TAX 라인 
    		if(sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "TAX" && sheetObjects[1].GetCellValue(i, prefix2 + "glo_attr_ctnt1") == "" ) {
    			ComShowCodeMessage("SAP00054"); // If there is manually inputted tax data, you can't use the [Calculate Tax] button. 
    			return;
    		}
    		
    		//2.자동계산으로 인한 Tax Line 삭제 (ReferenceKey(glo_attr_ctnt1 컬럼값)가 있는 라인)
	    	if(sheetObjects[1].GetCellValue(i, prefix2 + "line_tp_lu_cd") == "TAX" && sheetObjects[1].GetCellValue(i, prefix2 + "glo_attr_ctnt1") != "") {
	    		//sheetObjects[1].RowDelete(i,false);	
	    		sheetObjects[1].SetRowHidden(i, true);
	    		sheetObjects[1].SetRowStatus(i, "D");
			}
    	}
    	
    	//3.자동계산 Tax Line 추가
    	for(var i=1; i <=sheetObjects[1].RowCount(); i++ ) {
			if(sheetObjects[1].GetRowStatus(i) != "D") {
				var tax_cd = sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_vat_cd"); 
				
				if (ComTrim(tax_cd) != "") {
					var tax_rate = parseFloat(ComNullToZero(sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_vat_rt")));
					if (tax_rate >= 0 ) {
						
						var lastNo = 0;
	
						lastNo = sheetObjects[1].RowCount("I")+ sheetObjects[1].RowCount("U") + sheetObjects[1].RowCount("R");
						
						var point = getPoint();
						if("I" == sheetObjects[0].GetCellValue(mainRow, prefix1+"ibflag") && sheetObjects[1].RowCount() == 0 ) {
							sheetObjects[1] = sheetObjects[1].Reset();
							initSheet(sheetObjects[1], 2, point);
							
						}
						var new_row = sheetObjects[1].DataInsert(-1);
			    		
			    		sheetObjects[1].SetCellValue(new_row,  prefix2 + "dtrb_line_no",   		parseInt(ComNullToZero(lastNo)) +1);
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "line_tp_lu_cd",  		"TAX", 0 );
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "acctg_dt",       		sheetObjects[1].GetCellValue(i, prefix2 + "acctg_dt"), 0 );    		
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_co_cd",		sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_co_cd"), 0 );
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_rgn_cd",		sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_rgn_cd"), 0 ); 
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_ctr_cd",		sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_ctr_cd"), 0 );
			    		if(OFC_COUNTRY == NATIVE_COUNTRY) {
			    			sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_acct_no",	TAX_ACCOUNT, 0 );
			    		} else {
			    			sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_acct_no",	OVERSAES_TAX_ACCOUNT, 0 );
			    		}
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_inter_co_cd",sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_inter_co_cd"), 0 );
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_coa_vvd_cd",		sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_coa_vvd_cd"), 0 );
			    		
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_desc",			sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_desc"), 0 );
			    		
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt1",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt1"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt2",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt2"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt3",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt3"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt4",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt4"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt5",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt5"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt6",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt6"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt7",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt7"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt8",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt8"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt9",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt9"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt10",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt10"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt11",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt11"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt12",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt12"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt13",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt13"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt14",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt14"), 0 );
			        	sheetObjects[1].SetCellValue(new_row, prefix2 + "attr_ctnt15",			sheetObjects[1].GetCellValue(i, prefix2 + "attr_ctnt15"), 0 );
			        	
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "glo_attr_ctnt1",		sheetObjects[1].GetCellValue(i, prefix2 + "dtrb_line_no"), 0 );
			    		
			    		if( point == 0 ) {
							sheetObjects[1].InitCellProperty(new_row, prefix2 + "dtrb_amt"		,{ Type:"Int",Align:"Right",Format:"NullInteger"} );
							sheetObjects[1].InitCellProperty(new_row, prefix2 + "dtrb_func_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
						} else {
							sheetObjects[1].InitCellProperty(new_row, prefix2 + "dtrb_amt"		,{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
							sheetObjects[1].InitCellProperty(new_row, prefix2 + "dtrb_func_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:point} );
						}		
			    		var lineAmt = sheetObjects[1].ComputeSum("|"+prefix2 + "dtrb_amt" +"|", i, i);
			    		
			    		sheetObjects[1].SetCellValue(new_row, prefix2 + "dtrb_amt", SAPComAddComma2( SAPComRound(lineAmt * (tax_rate/100), point) + '', point), 0 );
						
					}
				}
			}

		}	
    	
    } 
    
    function resizeSheet(){
        //for (i=1; i<sheetObjects.length; i++){
        //    ComResizeSheet(sheetObjects[i]);
        //}
        var tabIdx = tab1.GetSelectedIndex();
        ComResizeSheet(sheetObjects[tabIdx + 1]);
        var wSheet = sheetObjects[tabIdx + 1].GetSheetWidth();
        var divTabs = $("div[id=tabLayer]");
        var wTable = $(divTabs[tabIdx]).find(".GMMainTable").width();
        if(wSheet - 10 > wTable) {
        	ComResizeSheet(sheetObjects[tabIdx + 1]);
        }
    }
    
    
    function chkXRate(Col, Row) {
    	
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	//var Row =  sheetObj.GetSelectRow();
    	var prefix = sheetObj.id+ "_";
    	
    	//if (Col == "") Col = "inv_xch_dt"; 

    	var inv_curr_cd=sheetObj.GetCellValue(Row, prefix + "inv_curr_cd");
    	var f_curr_cd=formObj.hid_func_curr_cd.value;
    	var inv_xch_dt=ComTrim(sheetObj.GetCellValue(Row, prefix + "inv_xch_dt"));
    	var gl_dt = ComTrim(sheetObj.GetCellValue(Row, prefix + "gl_dt"));
		var cond_dt = ( inv_xch_dt == "" ) ? gl_dt : inv_xch_dt ;
    	
    	
    	if (inv_curr_cd != f_curr_cd) {
    		var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + cond_dt + "&value1=" + inv_curr_cd + "&value2=" + f_curr_cd);
    			if (SAPDecideErrXml(sheetObj, xmlStr)) {
                 return false;
             } else {
                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                 var x_date=ComGetEtcData(xmlStr, "x_date");
                 var x_type=ComGetEtcData(xmlStr, "x_type");
                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                 if ( x_rate != "NO_DATA") {
                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt",x_rate);
                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_dt",x_date,0);
                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd",x_type,0);
                 	sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs",x_prcs,0);
                 	sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","Corporate",0);
                 } else {
                	 ComShowCodeMessage("SAP00002", inv_xch_dt, inv_curr_cd);  // currency 없음 
                	 sheetObj.SetCellValue(Row, prefix + "inv_xch_rt","");
                  	 sheetObj.SetCellValue(Row, prefix + "inv_xch_dt","",0);
                  	 sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd","",0);
                  	 sheetObj.SetCellValue(Row, prefix + "inv_curr_prcs","",0);
                  	 sheetObj.SetCellValue(Row, prefix + "inv_xch_rt_tp_cd_nm","",0);
                	 return false;
                 }
             }
    	}
		
		return true;
		
    }     
   
    function chkXRateLine(Col, Row) {
    	
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	var prefix = sheetObj.id+ "_";
    	var prefix1 = sheetObjects[0].id + "_";
 
    	var inv_curr_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "inv_curr_cd");
    	var f_curr_cd = formObj.hid_func_curr_cd.value;
    	//var inv_xch_dt = ComTrim(sheetObj.GetCellValue(Row, prefix + "attr_ctnt11")); //Line 단위
    	var inv_xch_dt=ComTrim(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "inv_xch_dt")); //Heaer단위
    	var gl_dt = ComTrim(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1 + "gl_dt"));
		var cond_dt = ( inv_xch_dt == "" ) ? gl_dt : inv_xch_dt ;

    	if (inv_curr_cd != f_curr_cd) {
    		var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + cond_dt + "&value1=" + inv_curr_cd + "&value2=" + f_curr_cd);
    			if (SAPDecideErrXml(sheetObj, xmlStr)) {
                 return false;
             } else {
                 var x_rate=ComGetEtcData(xmlStr, "x_rate");
                 var x_date=ComGetEtcData(xmlStr, "x_date");
                 var x_type=ComGetEtcData(xmlStr, "x_type");
                 var x_prcs=ComGetEtcData(xmlStr, "x_prcs");
                 if ( x_rate != "NO_DATA") {
                 	sheetObj.SetCellValue(Row, prefix + "dtrb_xch_rt",x_rate);
                 	sheetObj.SetCellValue(Row, prefix + "dtrb_xch_dt",x_date,0);
                 	sheetObj.SetCellValue(Row, prefix + "dtrb_xch_rt_tp_cd",x_type,0);
                 } else {
                	 ComShowCodeMessage("SAP00002", inv_xch_dt, inv_curr_cd);  // currency 없음 
                	 sheetObj.SetCellValue(Row, prefix + "dtrb_xch_rt","");
                  	 sheetObj.SetCellValue(Row, prefix + "dtrb_xch_dt","",0);
                  	 sheetObj.SetCellValue(Row, prefix + "dtrb_xch_rt_tp_cd","",0);
                	 return false;
                 }
             }
    	}
		
		return true;
		
    }  